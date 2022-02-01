package com.tencent.mobileqq.earlydownload.api.impl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.inject.BaseEarlyHandlerProcessor;
import com.tencent.mobileqq.earlydownload.inject.EarlyHandlerProcessorFactory;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GPS;
import protocol.KQQConfig.GetResourceRespInfo;
import protocol.KQQConfig.GetResourceRespInfoV2;
import protocol.KQQConfig.GetResourceRespV2;
import protocol.KQQConfig.ReqUserInfo;

public class EarlyDownloadServiceImpl
  implements Handler.Callback, IEarlyDownloadService, INetEngineListener, HttpEngineTask.IHttpEngineTask
{
  static final int ACTION_DOWNLOAD_ON_CANCEL = 131329;
  static final int ACTION_DOWNLOAD_ON_RESP = 131328;
  static final int ACTION_NET_CHANGED = 131330;
  static final int ACTION_ON_BROADCAST_REQ = 131333;
  static final int ACTION_ON_GET_CONFIG_RESP = 131331;
  static final int ACTION_ON_SERVER_RESP = 131332;
  public static int DELAY_TIME = 60000;
  static final int MAX_REQ_DOWNLOAD_COUNT = 3;
  private static final String TAG = "EarlyDown.EarlyDownloadServiceImpl";
  private static String currentUin;
  public static final Lock lock = new ReentrantLock();
  private boolean afterAppStart = false;
  AppRuntime app;
  private ArrayList<BaseEarlyHandlerProcessor> mBaseEarlyHandlerProcessorArrayList;
  private HashMap<String, EarlyDownloadServiceImpl.DownloadRecord> mDownloadRecords = new HashMap();
  private Handler mEarlyHandler;
  private EarlyHandlerProcessorFactory mEarlyHandlerProcessorFactory = new EarlyHandlerProcessorFactory();
  private HashMap<String, HttpEngineTask> mPendingDownloadRecords = new HashMap();
  private IPreDownloadController mPreDownloadCtrl;
  public final HashSet<String> mRequestSet = new HashSet();
  private ServerConfigObserver mServerConfigObserver = new EarlyDownloadServiceImpl.1(this);
  private HashMap<String, EarlyHandler> mapHandler = new HashMap();
  public Boolean pluginConfigGetSucc;
  private long timeUpdateSuccess;
  
  private EarlyHandler createHandler(String paramString, AppRuntime paramAppRuntime)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("createHandler pkgName=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("EarlyDown.EarlyDownloadServiceImpl", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    Object localObject3 = null;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      localObject1 = this.mBaseEarlyHandlerProcessorArrayList;
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject2 = this.mBaseEarlyHandlerProcessorArrayList.iterator();
        do
        {
          localObject1 = localObject3;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (BaseEarlyHandlerProcessor)((Iterator)localObject2).next();
        } while ((localObject1 == null) || (!TextUtils.equals(((BaseEarlyHandlerProcessor)localObject1).a(), paramString)));
        localObject1 = ((BaseEarlyHandlerProcessor)localObject1).a(paramAppRuntime);
      }
      else
      {
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          paramAppRuntime = new StringBuilder();
          paramAppRuntime.append("createHandler(), mBaseEarlyHandlerProcessorArrayList is null !!!");
          paramAppRuntime.append(paramString);
          QLog.e("EarlyDown.EarlyDownloadServiceImpl", 2, paramAppRuntime.toString());
          localObject1 = localObject3;
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("createHandler() can't find Handler for:");
        paramAppRuntime.append(paramString);
        QLog.e("EarlyDown.EarlyDownloadServiceImpl", 1, paramAppRuntime.toString());
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
  
  private void doBroadcastReq(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("strResName");
    Object localObject2 = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleBroadcastReq() resName=");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(" action=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject1).toString());
    }
    EarlyHandler localEarlyHandler = getEarlyHandler(str);
    if (localEarlyHandler == null)
    {
      localObject1 = new Intent(paramIntent.getAction().replace("req.", "resp."));
      ((Intent)localObject1).putExtra("strResName", paramIntent.getStringExtra("strResName"));
      ((Intent)localObject1).putExtra("strPkgName", paramIntent.getStringExtra("strPkgName"));
      ((Intent)localObject1).putExtra("reqResult", false);
      paramIntent = new StringBuilder();
      paramIntent.append("resName:");
      paramIntent.append(str);
      paramIntent.append(" is not valid.");
      ((Intent)localObject1).putExtra("resultReason", paramIntent.toString());
      MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast((Intent)localObject1, "com.tencent.qqhead.permission.getheadresp");
      return;
    }
    Object localObject1 = localEarlyHandler.h();
    if ("req.com.tencent.mobileqq.EARLY_DOWNLOAD".equals(localObject2))
    {
      if (((XmlData)localObject1).loadState == 1)
      {
        paramIntent = new Intent("resp.com.tencent.mobileqq.EARLY_DOWNLOAD");
        paramIntent.putExtra("reqResult", false);
        paramIntent.putExtra("strResName", str);
        paramIntent.putExtra("strPkgName", ((XmlData)localObject1).strPkgName);
        paramIntent.putExtra("loadState", 1);
        paramIntent.putExtra("resultReason", "resource has been success.");
        MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast(paramIntent, "com.tencent.qqhead.permission.getheadresp");
        return;
      }
      localEarlyHandler.b(true);
      localEarlyHandler.a(paramIntent.getBooleanExtra("userClick", false));
      return;
    }
    if ("req.com.tencent.mobileqq.EARLY_QUERY".equals(localObject2))
    {
      paramIntent = new Intent("resp.com.tencent.mobileqq.EARLY_QUERY");
      paramIntent.putExtra("strResName", str);
      paramIntent.putExtra("strPkgName", ((XmlData)localObject1).strPkgName);
      paramIntent.putExtra("reqResult", true);
      paramIntent.putExtra("loadState", ((XmlData)localObject1).loadState);
      paramIntent.putExtra("totalSize", ((XmlData)localObject1).totalSize);
      paramIntent.putExtra("downSize", ((XmlData)localObject1).downSize);
      MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast(paramIntent, "com.tencent.qqhead.permission.getheadresp");
      return;
    }
    if ("req.com.tencent.mobileqq.EARLY_CANCEL".equals(localObject2))
    {
      localEarlyHandler.b(true);
      cancelDownload(localEarlyHandler.h());
      return;
    }
    if ("req.com.tencent.mobileqq.EARLY_SET_FAIL".equals(localObject2))
    {
      localEarlyHandler.c(false);
      localObject2 = new Intent("resp.com.tencent.mobileqq.EARLY_SET_FAIL");
      ((Intent)localObject2).putExtra("strResName", str);
      ((Intent)localObject2).putExtra("strPkgName", ((XmlData)localObject1).strPkgName);
      ((Intent)localObject2).putExtra("reqResult", true);
      ((Intent)localObject2).putExtra("loadState", ((XmlData)localObject1).loadState);
      MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast((Intent)localObject2, "com.tencent.qqhead.permission.getheadresp");
      if (paramIntent.getBooleanExtra("restartDownload", false))
      {
        localEarlyHandler.b(true);
        localEarlyHandler.a(paramIntent.getBooleanExtra("userClick", false));
      }
    }
  }
  
  private void doOnCancelDownload(XmlData paramXmlData)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doOnCancelDownload() name=");
      ((StringBuilder)localObject1).append(paramXmlData.strResName);
      ((StringBuilder)localObject1).append(",strResURL_big=");
      ((StringBuilder)localObject1).append(paramXmlData.strResURL_big);
      ((StringBuilder)localObject1).append(",strResURL_small=");
      ((StringBuilder)localObject1).append(paramXmlData.strResURL_small);
      ((StringBuilder)localObject1).append(",localVer=");
      ((StringBuilder)localObject1).append(paramXmlData.Version);
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject1).toString());
    }
    lock.lock();
    try
    {
      Object localObject2 = (EarlyDownloadServiceImpl.DownloadRecord)this.mDownloadRecords.remove(paramXmlData.strResName);
      Object localObject3 = (HttpEngineTask)this.mPendingDownloadRecords.remove(paramXmlData.strResName);
      lock.unlock();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doOnCancelDownload(), netReq = ");
        ((StringBuilder)localObject1).append(((EarlyDownloadServiceImpl.DownloadRecord)localObject2).a);
        ((StringBuilder)localObject1).append(", pendingNetReq = ");
        ((StringBuilder)localObject1).append(localObject3);
        QLog.d("EarlyDown.EarlyDownloadServiceImpl", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = getEarlyHandler(paramXmlData.strResName);
      if ((localObject2 == null) && (localObject3 == null))
      {
        if ((localObject1 != null) && (((EarlyHandler)localObject1).i()))
        {
          localObject2 = new Intent("resp.com.tencent.mobileqq.EARLY_CANCEL");
          ((Intent)localObject2).putExtra("reqResult", false);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("resName=");
          ((StringBuilder)localObject3).append(paramXmlData.strResName);
          ((StringBuilder)localObject3).append(" is not loading..");
          ((Intent)localObject2).putExtra("resultReason", ((StringBuilder)localObject3).toString());
          ((Intent)localObject2).putExtra("strResName", paramXmlData.strResName);
          ((Intent)localObject2).putExtra("strPkgName", paramXmlData.strPkgName);
          MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast((Intent)localObject2, "com.tencent.qqhead.permission.getheadresp");
          ((EarlyHandler)localObject1).b(false);
        }
      }
      else
      {
        if (localObject2 != null) {
          if (((EarlyDownloadServiceImpl.DownloadRecord)localObject2).b != null) {
            this.mPreDownloadCtrl.cancelPreDownload(paramXmlData.strResURL_big);
          } else {
            ((IHttpEngineService)this.app.getRuntimeService(IHttpEngineService.class, "all")).cancelReq(((EarlyDownloadServiceImpl.DownloadRecord)localObject2).a);
          }
        }
        if (localObject3 != null) {
          this.mPreDownloadCtrl.cancelPreDownload(paramXmlData.strResURL_big);
        }
        paramXmlData.tStart = 0L;
        paramXmlData.hasResDownloaded = false;
        paramXmlData.loadState = 0;
        EarlyDataFactory.a(paramXmlData, new String[] { "loadState", "hasResDownloaded", "tStart" });
        if (localObject1 != null) {
          ((EarlyHandler)localObject1).c(paramXmlData);
        }
      }
      return;
    }
    finally
    {
      lock.unlock();
    }
  }
  
  private void doOnGetConfig(GetResourceRespV2 paramGetResourceRespV2)
  {
    if (paramGetResourceRespV2 == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (paramGetResourceRespV2.vecDeletedResInfo != null)
    {
      localObject1 = paramGetResourceRespV2.vecDeletedResInfo.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (GetResourceRespInfoV2)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject3 = ((GetResourceRespInfoV2)localObject2).strResName;
          localObject4 = (EarlyHandler)this.mapHandler.get(localObject3);
          if (localObject4 != null) {
            ((EarlyHandler)localObject4).u();
          }
          removeHandler((String)localObject3);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("doOnGetConfig() removeRes, strPkgName=");
            ((StringBuilder)localObject3).append(((GetResourceRespInfoV2)localObject2).strPkgName);
            QLog.d("EarlyDown", 2, ((StringBuilder)localObject3).toString());
          }
        }
      }
    }
    if (paramGetResourceRespV2.vecAddedResInfo != null)
    {
      localObject1 = paramGetResourceRespV2.vecAddedResInfo.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (GetResourceRespInfoV2)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((GetResourceRespInfoV2)localObject2).iPluginType == 512))
        {
          localObject4 = ((GetResourceRespInfoV2)localObject2).strResName;
          localObject3 = getEarlyHandler((String)localObject4);
          if (localObject3 != null)
          {
            XmlData localXmlData = EarlyDataFactory.a(((EarlyHandler)localObject3).a(), ((GetResourceRespInfoV2)localObject2).strResName, ((GetResourceRespInfoV2)localObject2).strPkgName, ((GetResourceRespInfoV2)localObject2).strResConf, ((GetResourceRespInfoV2)localObject2).uiNewVer, ((GetResourceRespInfoV2)localObject2).strResURL_big, ((GetResourceRespInfoV2)localObject2).strResURL_small);
            if (!TextUtils.equals(((GetResourceRespInfoV2)localObject2).strPkgName, ((EarlyHandler)localObject3).h().strPkgName))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("doOnGetConfig() pkgName mismatch! resp:");
              localStringBuilder.append(((GetResourceRespInfoV2)localObject2).strPkgName);
              localStringBuilder.append(" vs local:");
              localStringBuilder.append(((EarlyHandler)localObject3).h().strPkgName);
              QLog.e("EarlyDown.EarlyDownloadServiceImpl", 1, localStringBuilder.toString());
            }
            ((EarlyHandler)localObject3).h().updateServerInfo(localXmlData);
            EarlyDataFactory.a(((EarlyHandler)localObject3).h(), new String[0]);
            localObject3 = Message.obtain();
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = new Message();
            }
            ((Message)localObject2).what = 131332;
            ((Message)localObject2).obj = new Object[] { localObject4, localXmlData };
            if (((String)localObject4).equals(this.mEarlyHandlerProcessorFactory.a())) {
              DELAY_TIME = 0;
            } else {
              DELAY_TIME = 60000;
            }
            localObject3 = this.mEarlyHandler;
            if (localObject3 != null) {
              ((Handler)localObject3).sendMessageDelayed((Message)localObject2, DELAY_TIME);
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("doOnGetConfig() Added resName=");
              ((StringBuilder)localObject2).append((String)localObject4);
              ((StringBuilder)localObject2).append(" data=");
              ((StringBuilder)localObject2).append(localXmlData);
              ((StringBuilder)localObject2).append(" updateServerInfo done, doOnServerResp after ");
              ((StringBuilder)localObject2).append(DELAY_TIME);
              ((StringBuilder)localObject2).append("ms");
              QLog.d("EarlyDown", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
      }
    }
    if (paramGetResourceRespV2.vecUpdatedResInfo != null)
    {
      paramGetResourceRespV2 = paramGetResourceRespV2.vecUpdatedResInfo.iterator();
      while (paramGetResourceRespV2.hasNext())
      {
        localObject1 = (GetResourceRespInfoV2)paramGetResourceRespV2.next();
        if ((localObject1 != null) && (((GetResourceRespInfoV2)localObject1).iPluginType == 512))
        {
          localObject3 = ((GetResourceRespInfoV2)localObject1).strResName;
          localObject2 = getEarlyHandler((String)localObject3);
          if (localObject2 != null)
          {
            int i = ((EarlyHandler)localObject2).h().Version;
            localObject4 = EarlyDataFactory.a(((EarlyHandler)localObject2).a(), ((GetResourceRespInfoV2)localObject1).strResName, ((GetResourceRespInfoV2)localObject1).strPkgName, ((GetResourceRespInfoV2)localObject1).strResConf, ((GetResourceRespInfoV2)localObject1).uiNewVer, ((GetResourceRespInfoV2)localObject1).strResURL_big, ((GetResourceRespInfoV2)localObject1).strResURL_small);
            ((EarlyHandler)localObject2).h().updateServerInfo((XmlData)localObject4);
            if (i < ((GetResourceRespInfoV2)localObject1).uiNewVer) {
              ((EarlyHandler)localObject2).h().loadState = 0;
            }
            EarlyDataFactory.a(((EarlyHandler)localObject2).h(), new String[0]);
            localObject2 = Message.obtain();
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new Message();
            }
            ((Message)localObject1).what = 131332;
            ((Message)localObject1).obj = new Object[] { localObject3, localObject4 };
            if (((String)localObject3).equals(this.mEarlyHandlerProcessorFactory.a())) {
              DELAY_TIME = 0;
            } else {
              DELAY_TIME = 60000;
            }
            localObject2 = this.mEarlyHandler;
            if (localObject2 != null) {
              ((Handler)localObject2).sendMessageDelayed((Message)localObject1, DELAY_TIME);
            }
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("doOnGetConfig() Updated resName=");
              ((StringBuilder)localObject1).append((String)localObject3);
              ((StringBuilder)localObject1).append(" data=");
              ((StringBuilder)localObject1).append(localObject4);
              ((StringBuilder)localObject1).append(" updateServerInfo done, doOnServerResp after ");
              ((StringBuilder)localObject1).append(DELAY_TIME);
              ((StringBuilder)localObject1).append("ms");
              QLog.d("EarlyDown", 2, ((StringBuilder)localObject1).toString());
            }
            else {}
          }
        }
      }
    }
  }
  
  private void doOnResp(NetResp paramNetResp)
  {
    XmlData localXmlData = (XmlData)paramNetResp.mReq.getUserData();
    if (localXmlData == null) {
      return;
    }
    if (paramNetResp.mResult == 3)
    {
      if (QLog.isColorLevel())
      {
        paramNetResp = new StringBuilder();
        paramNetResp.append("doOnResp() resName=");
        paramNetResp.append(localXmlData.strResName);
        paramNetResp.append(" is downloading...");
        QLog.d("EarlyDown", 2, paramNetResp.toString());
      }
      return;
    }
    boolean bool1;
    if (paramNetResp.mResult == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    long l2 = SystemClock.elapsedRealtime();
    long l3 = localXmlData.tStart;
    try
    {
      l1 = new File(paramNetResp.mReq.mOutPath).length();
    }
    catch (Exception localException1)
    {
      long l1;
      label125:
      break label125;
    }
    l1 = 0L;
    lock.lock();
    try
    {
      localObject1 = (EarlyDownloadServiceImpl.DownloadRecord)this.mDownloadRecords.remove(localXmlData.strResName);
      if (localObject1 != null) {
        localObject1 = ((EarlyDownloadServiceImpl.DownloadRecord)localObject1).a;
      } else {
        localObject1 = null;
      }
      lock.unlock();
      bool2 = bool1;
      if (bool1)
      {
        bool1 = verifyResource(localXmlData, paramNetResp.mReq.mOutPath);
        if (!bool1)
        {
          paramNetResp.mErrCode = -6103066;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("md5_not_same.netSize:");
          ((StringBuilder)localObject2).append(l1);
          ((StringBuilder)localObject2).append(localXmlData.strLog);
          paramNetResp.mErrDesc = ((StringBuilder)localObject2).toString();
          localXmlData.strLog = "";
          localXmlData.hasResDownloaded = false;
        }
      }
    }
    finally
    {
      Object localObject1;
      boolean bool2;
      Object localObject2;
      label285:
      int i;
      EarlyHandler localEarlyHandler;
      lock.unlock();
    }
    try
    {
      FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
    }
    catch (Exception localException2)
    {
      break label285;
    }
    bool2 = bool1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doOnResp() verifyResource=");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(" resName=");
      ((StringBuilder)localObject2).append(localXmlData.strResName);
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject2).toString());
      bool2 = bool1;
    }
    i = localXmlData.reqLoadCount;
    if (((paramNetResp.mErrCode == -6103066) || (paramNetResp.mErrCode == -9527)) && (i < 3))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("retry load.resName:");
        ((StringBuilder)localObject1).append(localXmlData.strResName);
        ((StringBuilder)localObject1).append(".reqCount=");
        ((StringBuilder)localObject1).append(localXmlData.reqLoadCount);
        ((StringBuilder)localObject1).append(".errCode=");
        ((StringBuilder)localObject1).append(paramNetResp.mErrCode);
        QLog.d("EarlyDown", 2, ((StringBuilder)localObject1).toString());
      }
      downloadResource(localXmlData, paramNetResp.mReq.mOutPath);
      return;
    }
    localXmlData.reqLoadCount = 0;
    localEarlyHandler = getEarlyHandler(localXmlData.strResName);
    if (bool2)
    {
      localXmlData.tLoadFail = 0L;
      localXmlData.loadState = 1;
      localXmlData.hasResDownloaded = true;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onDownloadFinish() resName=");
        ((StringBuilder)localObject2).append(localXmlData.strResName);
        ((StringBuilder)localObject2).append(" storeBackup=");
        ((StringBuilder)localObject2).append(localXmlData.StoreBackup);
        localObject2 = new StringBuffer(((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject2 = null;
      }
      if ((!localXmlData.StoreBackup) || (localEarlyHandler == null)) {}
    }
    try
    {
      String str = localEarlyHandler.l();
      bool1 = FileUtils.copyFile(paramNetResp.mReq.mOutPath, str);
      if ((QLog.isColorLevel()) && (localObject2 != null))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" copyResult=");
        localStringBuilder.append(bool1);
        localStringBuilder.append(" src=");
        localStringBuilder.append(paramNetResp.mReq.mOutPath);
        localStringBuilder.append(" dest=");
        localStringBuilder.append(str);
        ((StringBuffer)localObject2).append(localStringBuilder.toString());
      }
    }
    catch (Exception localException3)
    {
      label720:
      label891:
      break label720;
    }
    if ((QLog.isColorLevel()) && (localObject2 != null))
    {
      QLog.d("EarlyDown", 2, ((StringBuffer)localObject2).toString());
      break label891;
      if ((paramNetResp.mErrCode != 9366) && (paramNetResp.mErrCode != 9369) && (paramNetResp.mErrCode != 9367) && (paramNetResp.mErrCode != 9037) && (paramNetResp.mErrCode != 9004)) {
        localXmlData.tLoadFail = System.currentTimeMillis();
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("set tLoadFail=");
        ((StringBuilder)localObject2).append(localXmlData.tLoadFail);
        ((StringBuilder)localObject2).append(" strPkgName=");
        ((StringBuilder)localObject2).append(localXmlData.strResName);
        QLog.d("EarlyDown", 2, ((StringBuilder)localObject2).toString());
      }
      if (localEarlyHandler != null) {
        localEarlyHandler.c(true);
      }
      FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
    }
    EarlyDataFactory.a(localXmlData, new String[] { "Version", "loadState", "tLoadFail", "hasResDownloaded" });
    removeRequesting(localXmlData.getStrResName());
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doOnResp() result=");
      ((StringBuilder)localObject2).append(bool2);
      ((StringBuilder)localObject2).append(" errCode=");
      ((StringBuilder)localObject2).append(paramNetResp.mErrCode);
      ((StringBuilder)localObject2).append(" name=");
      ((StringBuilder)localObject2).append(localXmlData.strResName);
      ((StringBuilder)localObject2).append(",strResURL_big=");
      ((StringBuilder)localObject2).append(localXmlData.strResURL_big);
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 != null)
    {
      if (localEarlyHandler != null)
      {
        localEarlyHandler.a(localXmlData, bool2, paramNetResp.mErrCode, paramNetResp.mReq.mOutPath);
        localEarlyHandler.t();
      }
      if ((paramNetResp.mErrCode != 9366) && (paramNetResp.mErrCode != 9037) && (paramNetResp.mErrCode != 9004) && (paramNetResp.mErrCode != 9040))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_FailCode", Integer.toString(paramNetResp.mErrCode));
        ((HashMap)localObject1).put("param_strPkgName", localXmlData.strPkgName);
        ((HashMap)localObject1).put("param_reqCount", Integer.toString(i));
        if (!bool2)
        {
          if (paramNetResp.mRespProperties != null)
          {
            localObject2 = (String)paramNetResp.mRespProperties.get("serverip");
            if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
              ((HashMap)localObject1).put("param_serverIP", localObject2);
            }
          }
          if ((paramNetResp.mErrDesc != null) && (paramNetResp.mErrDesc.length() > 0))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramNetResp.mErrDesc);
            ((StringBuilder)localObject2).append(localXmlData.strLog);
            ((HashMap)localObject1).put("param_desc", ((StringBuilder)localObject2).toString());
            localXmlData.strLog = "";
          }
        }
        if (localEarlyHandler != null)
        {
          paramNetResp = localEarlyHandler.b();
          if ((paramNetResp != null) && (paramNetResp.length() > 0)) {
            StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance(this.app.getCurrentAccountUin(), localEarlyHandler.b(), bool2, l2 - l3, l1, (HashMap)localObject1, "");
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramNetResp = new StringBuilder();
      paramNetResp.append("doOnResp() resName=");
      paramNetResp.append(localXmlData.strResName);
      paramNetResp.append(" netReq is null. may has been cancelled.");
      QLog.d("EarlyDown", 2, paramNetResp.toString());
    }
  }
  
  private void initStrResNames(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = this.mEarlyHandlerProcessorFactory.a(paramAppRuntime);
    if ((paramAppRuntime != null) && (paramAppRuntime.size() > 0)) {
      this.mBaseEarlyHandlerProcessorArrayList = paramAppRuntime;
    }
    paramAppRuntime = this.mBaseEarlyHandlerProcessorArrayList;
    if ((paramAppRuntime != null) && (paramAppRuntime.size() > 0))
    {
      if (QLog.isColorLevel()) {
        paramAppRuntime = this.mBaseEarlyHandlerProcessorArrayList.iterator();
      }
    }
    else {
      while (paramAppRuntime.hasNext())
      {
        BaseEarlyHandlerProcessor localBaseEarlyHandlerProcessor = (BaseEarlyHandlerProcessor)paramAppRuntime.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("early download res name : ");
        localStringBuilder.append(localBaseEarlyHandlerProcessor.a());
        QLog.i("EarlyDown.EarlyDownloadServiceImpl", 2, localStringBuilder.toString());
        continue;
        QLog.i("EarlyDown.EarlyDownloadServiceImpl", 1, "early download res name list is null !!!");
      }
    }
  }
  
  private void onDownloadBegin(XmlData paramXmlData, HttpNetReq paramHttpNetReq, AbsPreDownloadTask paramAbsPreDownloadTask)
  {
    paramXmlData.tStart = SystemClock.elapsedRealtime();
    paramXmlData.loadState = 2;
    paramXmlData.hasResDownloaded = false;
    EarlyDataFactory.a(paramXmlData, new String[] { "loadState", "hasResDownloaded" });
    Object localObject = getEarlyHandler(paramXmlData.getStrResName());
    if ((localObject != null) && (paramXmlData.reqLoadCount == 0)) {
      ((EarlyHandler)localObject).b(paramXmlData);
    }
    paramXmlData.reqLoadCount += 1;
    lock.lock();
    try
    {
      localObject = new EarlyDownloadServiceImpl.DownloadRecord(null);
      ((EarlyDownloadServiceImpl.DownloadRecord)localObject).a = paramHttpNetReq;
      ((EarlyDownloadServiceImpl.DownloadRecord)localObject).b = paramAbsPreDownloadTask;
      this.mDownloadRecords.put(paramXmlData.strResName, localObject);
      this.mPendingDownloadRecords.remove(paramXmlData.strResName);
      return;
    }
    finally
    {
      lock.unlock();
    }
  }
  
  private boolean verifyResource(XmlData paramXmlData, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("verifyResource() data=");
      localStringBuilder.append(paramXmlData.strResName);
      localStringBuilder.append(", filepath=");
      localStringBuilder.append(paramString);
      QLog.d("EarlyDown", 2, localStringBuilder.toString());
    }
    File localFile;
    if (paramXmlData != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (TextUtils.isEmpty(paramXmlData.MD5)) {
        return false;
      }
      localFile = new File(paramString);
      if (!localFile.exists())
      {
        if (QLog.isColorLevel())
        {
          paramXmlData = new StringBuilder();
          paramXmlData.append("verifyResource() file[");
          paramXmlData.append(paramString);
          paramXmlData.append("] not exist..");
          QLog.e("EarlyDown", 2, paramXmlData.toString());
        }
        return false;
      }
      localStringBuilder = null;
    }
    try
    {
      paramString = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    }
    catch (UnsatisfiedLinkError paramString)
    {
      label159:
      label168:
      break label159;
    }
    try
    {
      paramString = MD5FileUtil.a(localFile);
    }
    catch (Exception paramString)
    {
      paramString = localStringBuilder;
      break label168;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("verifyResource ");
      localStringBuilder.append(paramXmlData.strResName);
      localStringBuilder.append(",data.md5=");
      localStringBuilder.append(paramXmlData.MD5);
      localStringBuilder.append(",file.md5=");
      localStringBuilder.append(paramString);
      QLog.d("EarlyDown", 2, localStringBuilder.toString());
    }
    if (paramXmlData.MD5.equalsIgnoreCase(paramString)) {
      return true;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(".md5.S:");
    localStringBuilder.append(paramXmlData.MD5);
    localStringBuilder.append(".L:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".");
    paramXmlData.strLog = localStringBuilder.toString();
    return false;
  }
  
  public void addRequesting(String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("addRequesting ");
      ((StringBuilder)???).append(paramString);
      QLog.i("EarlyDown.EarlyDownloadServiceImpl", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.mRequestSet)
    {
      if (!this.mRequestSet.contains(paramString)) {
        this.mRequestSet.add(paramString);
      }
      return;
    }
  }
  
  void cancelDownload(XmlData paramXmlData)
  {
    if (paramXmlData == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancelDownload.name=");
      ((StringBuilder)localObject).append(paramXmlData.strResName);
      ((StringBuilder)localObject).append(",strResURL_big=");
      ((StringBuilder)localObject).append(paramXmlData.strResURL_big);
      ((StringBuilder)localObject).append(",localVer=");
      ((StringBuilder)localObject).append(paramXmlData.Version);
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mEarlyHandler;
    if (localObject != null) {
      ((Handler)localObject).obtainMessage(131329, paramXmlData).sendToTarget();
    }
  }
  
  public void downloadResource(XmlData paramXmlData, String paramString)
  {
    int i = 2;
    if ((paramXmlData != null) && (paramString != null)) {}
    for (;;)
    {
      try
      {
        Object localObject;
        if (paramString.length() != 0)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("downloadResource() name=");
            ((StringBuilder)localObject).append(paramXmlData.strResName);
            ((StringBuilder)localObject).append(" strResURL_big=");
            ((StringBuilder)localObject).append(paramXmlData.strResURL_big);
            ((StringBuilder)localObject).append(" storagePath=");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("EarlyDown", 2, ((StringBuilder)localObject).toString());
          }
          boolean bool = TextUtils.isEmpty(paramXmlData.strResURL_big);
          if (bool) {
            return;
          }
          lock.lock();
          try
          {
            if (this.mDownloadRecords.containsKey(paramXmlData.strResName))
            {
              if (paramXmlData.loadState == 0)
              {
                paramXmlData.loadState = 2;
                EarlyDataFactory.a(paramXmlData, new String[] { "loadState" });
              }
              if (QLog.isColorLevel())
              {
                paramString = new StringBuilder();
                paramString.append("downloadResource() return, already exist=");
                paramString.append(paramXmlData.strResName);
                QLog.d("EarlyDown.EarlyDownloadServiceImpl", 2, paramString.toString());
              }
              lock.unlock();
              return;
            }
            if (this.mPendingDownloadRecords.containsKey(paramXmlData.strResName))
            {
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("hasPendingDownloadRecord, isUserClick ");
                ((StringBuilder)localObject).append(paramXmlData.isUserClick);
                QLog.d("EarlyDown.EarlyDownloadServiceImpl", 2, ((StringBuilder)localObject).toString());
              }
              bool = paramXmlData.isUserClick;
              if (!bool)
              {
                lock.unlock();
                return;
              }
              localObject = (HttpEngineTask)this.mPendingDownloadRecords.remove(paramXmlData.strResName);
              if (localObject != null) {
                this.mPreDownloadCtrl.cancelPreDownload(((HttpEngineTask)localObject).httpReq.mReqUrl);
              }
            }
            lock.unlock();
            paramXmlData.tStart = SystemClock.elapsedRealtime();
            paramXmlData.loadState = 2;
            paramXmlData.hasResDownloaded = false;
            EarlyDataFactory.a(paramXmlData, new String[] { "loadState", "hasResDownloaded" });
            localObject = (IHttpEngineService)this.app.getRuntimeService(IHttpEngineService.class, "all");
            if (QLog.isColorLevel()) {
              QLog.d("EarlyDown.EarlyDownloadServiceImpl", 2, "netEngine == null ? ");
            }
            HttpNetReq localHttpNetReq = new HttpNetReq();
            localHttpNetReq.mCallback = this;
            localHttpNetReq.mSupportBreakResume = true;
            localHttpNetReq.mReqUrl = paramXmlData.strResURL_big;
            localHttpNetReq.mNeedIpConnect = true;
            localHttpNetReq.mHttpMethod = 0;
            localHttpNetReq.setUserData(paramXmlData);
            localHttpNetReq.mOutPath = paramString;
            localHttpNetReq.bAcceptNegativeContentLength = true;
            if ((!paramXmlData.isUserClick) && (this.mPreDownloadCtrl.isEnable()))
            {
              localHttpNetReq.mPrioty = 2;
              lock.lock();
              try
              {
                paramString = new HttpEngineTask((BaseQQAppInterface)this.app, paramXmlData.strResName, this, localHttpNetReq);
                if (paramXmlData.load2G)
                {
                  i = 2;
                }
                else
                {
                  if (!paramXmlData.load3G) {
                    break label781;
                  }
                  i = 3;
                }
                localObject = getEarlyHandler(paramXmlData.strResName);
                if (localObject != null)
                {
                  this.mPreDownloadCtrl.requestPreDownload(((EarlyHandler)localObject).c(), ((EarlyHandler)localObject).d(), paramXmlData.strResName, 0, paramXmlData.strResURL_big, ((EarlyHandler)localObject).k(), i, 0, false, paramString);
                  this.mPendingDownloadRecords.put(paramXmlData.strResName, paramString);
                }
              }
              finally {}
            }
            else
            {
              if (paramXmlData.isUserClick) {
                i = 1;
              }
              localHttpNetReq.mPrioty = i;
              onDownloadBegin(paramXmlData, localHttpNetReq, null);
              ((IHttpEngineService)localObject).sendReq(localHttpNetReq);
            }
            return;
          }
          finally
          {
            lock.unlock();
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("downloadResource() return, ");
            if (paramXmlData == null)
            {
              paramXmlData = "data==null";
            }
            else
            {
              paramXmlData = new StringBuilder();
              paramXmlData.append("storagePath=");
              paramXmlData.append(paramString);
              paramXmlData = paramXmlData.toString();
            }
            ((StringBuilder)localObject).append(paramXmlData);
            QLog.d("EarlyDown", 2, ((StringBuilder)localObject).toString());
          }
          return;
        }
      }
      finally {}
      label781:
      i = 1;
    }
  }
  
  public String getCurrentUin()
  {
    Object localObject = currentUin;
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      localObject = MobileQQ.sMobileQQ.getApplicationContext();
      int i;
      if (Build.VERSION.SDK_INT > 10) {
        i = 4;
      } else {
        i = 0;
      }
      currentUin = ((Context)localObject).getSharedPreferences("Last_Login", i).getString("uin", "");
    }
    localObject = currentUin;
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      return currentUin;
    }
    return "10000";
  }
  
  public EarlyHandler getEarlyHandler(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      EarlyHandler localEarlyHandler2 = (EarlyHandler)this.mapHandler.get(paramString);
      EarlyHandler localEarlyHandler1 = localEarlyHandler2;
      if (localEarlyHandler2 == null)
      {
        localEarlyHandler2 = createHandler(paramString, this.app);
        localEarlyHandler1 = localEarlyHandler2;
        if (localEarlyHandler2 != null)
        {
          lock.lock();
          try
          {
            if (!this.mapHandler.containsKey(paramString)) {
              this.mapHandler.put(paramString, localEarlyHandler2);
            }
            return localEarlyHandler2;
          }
          finally
          {
            lock.unlock();
          }
        }
      }
      return localEarlyHandler1;
    }
    return null;
  }
  
  public void handleBroadcastReq(Intent paramIntent)
  {
    if (this.mEarlyHandler != null)
    {
      Message localMessage2 = Message.obtain();
      Message localMessage1 = localMessage2;
      if (localMessage2 == null) {
        localMessage1 = new Message();
      }
      localMessage1.obj = paramIntent;
      localMessage1.what = 131333;
      this.mEarlyHandler.sendMessage(localMessage1);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EarlyDownloadManager handleMessage,msg.what = ");
      ((StringBuilder)localObject).append(paramMessage.what);
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject).toString());
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 131333: 
      if ((paramMessage.obj instanceof Intent))
      {
        doBroadcastReq((Intent)paramMessage.obj);
        return false;
      }
      break;
    case 131332: 
      StringBuilder localStringBuilder;
      if ((paramMessage.obj instanceof GetResourceRespInfo))
      {
        paramMessage = (GetResourceRespInfo)paramMessage.obj;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ACTION_ON_SERVER_RESP doOnServerResp() GetResourceRespInfo,resp.strPkgName = ");
          ((StringBuilder)localObject).append(paramMessage.strPkgName);
          ((StringBuilder)localObject).append(",resp.iResult = ");
          ((StringBuilder)localObject).append(paramMessage.iResult);
          ((StringBuilder)localObject).append(",resp.strResName = ");
          ((StringBuilder)localObject).append(paramMessage.strResName);
          QLog.d("EarlyDown", 2, ((StringBuilder)localObject).toString());
        }
        if (paramMessage.iResult == 0)
        {
          localObject = getEarlyHandler(paramMessage.strResName);
          if (localObject != null) {
            ((EarlyHandler)localObject).a(EarlyDataFactory.a(((EarlyHandler)localObject).a(), paramMessage.strResName, paramMessage.strPkgName, paramMessage.strResConf, paramMessage.uiNewVer, paramMessage.strResURL_big, paramMessage.strResURL_small));
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("ACTION_ON_SERVER_RESP doOnServerResp() GetResourceRespInfo = ");
            localStringBuilder.append(paramMessage.strPkgName);
            localStringBuilder.append(",handler = ");
            localStringBuilder.append(localObject);
            QLog.d("EarlyDown", 2, localStringBuilder.toString());
            return false;
          }
        }
        else
        {
          localObject = getEarlyHandler(paramMessage.strResName);
          if (localObject != null)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("!ACTION_ON_SERVER_RESP! doOnServerResp() GetResourceRespInfo = ");
              localStringBuilder.append(paramMessage.strPkgName);
              localStringBuilder.append(",handler = ");
              localStringBuilder.append(localObject);
              QLog.d("EarlyDown", 2, localStringBuilder.toString());
            }
            ((EarlyHandler)localObject).a(((EarlyHandler)localObject).h(), false, paramMessage.iResult, "");
          }
          removeRequesting(paramMessage.strResName);
          return false;
        }
      }
      else if ((paramMessage.obj instanceof Object[]))
      {
        paramMessage = (Object[])paramMessage.obj;
        if ((paramMessage.length == 2) && ((paramMessage[0] instanceof String)) && ((paramMessage[1] instanceof XmlData)))
        {
          localObject = (String)paramMessage[0];
          paramMessage = (XmlData)paramMessage[1];
          localObject = getEarlyHandler((String)localObject);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("ACTION_ON_SERVER_RESP object[], handler = ");
            localStringBuilder.append(localObject);
            QLog.d("EarlyDown", 2, localStringBuilder.toString());
          }
          if (localObject != null)
          {
            ((EarlyHandler)localObject).a(paramMessage);
            return false;
          }
        }
      }
      break;
    case 131331: 
      localObject = null;
      if (paramMessage.obj != null) {
        localObject = (GetResourceRespV2)paramMessage.obj;
      }
      doOnGetConfig((GetResourceRespV2)localObject);
      return false;
    case 131330: 
      updateConfigs(false);
      return false;
    case 131329: 
      doOnCancelDownload((XmlData)paramMessage.obj);
      return false;
    case 131328: 
      doOnResp((NetResp)paramMessage.obj);
    }
    return false;
  }
  
  public void handleOnGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuffer();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onGetPluginConfig() isSucc=");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(" iPluginType=");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuffer)localObject1).append(((StringBuilder)localObject2).toString());
      if (paramGetResourceRespV2 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" result=");
        ((StringBuilder)localObject2).append(paramGetResourceRespV2.result);
        ((StringBuffer)localObject1).append(((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" uin=");
        ((StringBuilder)localObject2).append(paramGetResourceRespV2.uin);
        ((StringBuffer)localObject1).append(((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" add=");
        int i;
        if (paramGetResourceRespV2.vecAddedResInfo != null) {
          i = paramGetResourceRespV2.vecAddedResInfo.size();
        } else {
          i = 0;
        }
        ((StringBuilder)localObject2).append(i);
        ((StringBuffer)localObject1).append(((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" update=");
        if (paramGetResourceRespV2.vecUpdatedResInfo != null) {
          i = paramGetResourceRespV2.vecUpdatedResInfo.size();
        } else {
          i = 0;
        }
        ((StringBuilder)localObject2).append(i);
        ((StringBuffer)localObject1).append(((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" delete=");
        if (paramGetResourceRespV2.vecDeletedResInfo != null) {
          i = paramGetResourceRespV2.vecDeletedResInfo.size();
        } else {
          i = 0;
        }
        ((StringBuilder)localObject2).append(i);
        ((StringBuffer)localObject1).append(((StringBuilder)localObject2).toString());
      }
      QLog.d("EarlyDown", 2, ((StringBuffer)localObject1).toString());
      ((StringBuffer)localObject1).setLength(0);
      if ((!this.afterAppStart) && (paramInt == 512)) {
        ((StringBuffer)localObject1).append("set afterAppStart=true");
      }
      QLog.d("EarlyDown", 2, ((StringBuffer)localObject1).toString());
    }
    if (paramInt != 512) {
      return;
    }
    this.pluginConfigGetSucc = Boolean.valueOf(paramBoolean);
    this.afterAppStart = true;
    if (!paramBoolean) {
      return;
    }
    if (paramGetResourceRespV2 == null) {
      return;
    }
    this.timeUpdateSuccess = SystemClock.elapsedRealtime();
    if (this.mEarlyHandler != null)
    {
      localObject2 = Message.obtain();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Message();
      }
      ((Message)localObject1).what = 131331;
      ((Message)localObject1).obj = paramGetResourceRespV2;
      this.mEarlyHandler.sendMessage((Message)localObject1);
    }
  }
  
  public boolean isLowEndPhone()
  {
    return (DeviceInfoUtil.U()) || (FileUtils.getAvailableInnernalMemorySize() <= 1.048576E+008F);
  }
  
  public boolean isRequesting(String paramString)
  {
    synchronized (this.mRequestSet)
    {
      boolean bool = this.mRequestSet.contains(paramString);
      return bool;
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    initStrResNames(paramAppRuntime);
    this.app = paramAppRuntime;
    this.mEarlyHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.mPreDownloadCtrl = ((IPreDownloadController)paramAppRuntime.getRuntimeService(IPreDownloadController.class, ""));
  }
  
  public void onDestroy()
  {
    currentUin = null;
    Object localObject1 = this.mBaseEarlyHandlerProcessorArrayList;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = this.mBaseEarlyHandlerProcessorArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (BaseEarlyHandlerProcessor)((Iterator)localObject1).next();
        if (localObject3 != null)
        {
          localObject3 = (EarlyHandler)this.mapHandler.get(((BaseEarlyHandlerProcessor)localObject3).a());
          if (localObject3 != null) {
            ((EarlyHandler)localObject3).g();
          }
        }
      }
    }
    localObject1 = this.mEarlyHandler;
    if (localObject1 != null) {
      ((Handler)localObject1).removeCallbacksAndMessages(null);
    }
    this.mEarlyHandler = null;
    lock.lock();
    try
    {
      this.mapHandler.clear();
      lock.unlock();
      return;
    }
    finally
    {
      lock.unlock();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void onNetChanged()
  {
    Object localObject = this.mEarlyHandler;
    if (localObject == null) {
      return;
    }
    boolean bool = ((Handler)localObject).hasMessages(131331);
    if ((this.afterAppStart) && (!bool))
    {
      Message localMessage = Message.obtain();
      localObject = localMessage;
      if (localMessage == null) {
        localObject = new Message();
      }
      ((Message)localObject).what = 131330;
      if (this.mEarlyHandler.hasMessages(131330)) {
        this.mEarlyHandler.removeMessages(131330);
      }
      this.mEarlyHandler.sendMessageDelayed((Message)localObject, DELAY_TIME);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onNetChange() sendMsg:ACTION_NET_CHANGE, delay(ms):");
        ((StringBuilder)localObject).append(DELAY_TIME);
        QLog.d("EarlyDown", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onNetChanged() return, afterAppStart=");
      ((StringBuilder)localObject).append(this.afterAppStart);
      ((StringBuilder)localObject).append(" hasMsg:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onPreDownloadStart(HttpEngineTask paramHttpEngineTask)
  {
    onDownloadBegin((XmlData)paramHttpEngineTask.httpReq.getUserData(), paramHttpEngineTask.httpReq, paramHttpEngineTask);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Handler localHandler = this.mEarlyHandler;
    if (localHandler != null) {
      localHandler.obtainMessage(131328, paramNetResp).sendToTarget();
    }
  }
  
  public void onServerResp(GetResourceRespInfo paramGetResourceRespInfo)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onServerResp() PkgName = ");
      if (paramGetResourceRespInfo != null) {
        localObject1 = paramGetResourceRespInfo.strPkgName;
      } else {
        localObject1 = "[respInfo is null]";
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject2).toString());
    }
    if (!this.afterAppStart)
    {
      this.afterAppStart = true;
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "onServerResp() afterAppStart=true");
      }
    }
    if (this.mEarlyHandler != null)
    {
      localObject2 = Message.obtain();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new Message();
      }
      ((Message)localObject1).what = 131332;
      ((Message)localObject1).obj = paramGetResourceRespInfo;
      this.mEarlyHandler.sendMessage((Message)localObject1);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (XmlData)paramNetReq.getUserData();
    if (paramNetReq != null)
    {
      paramNetReq.totalSize = paramLong2;
      paramNetReq.downSize = paramLong1;
      paramNetReq = getEarlyHandler(paramNetReq.strResName);
      if (paramNetReq != null) {
        paramNetReq.a(paramLong1, paramLong2);
      }
    }
  }
  
  public void removeHandler(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeHandler() strResName=");
      localStringBuilder.append(paramString);
      QLog.d("EarlyDown", 2, localStringBuilder.toString());
    }
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      lock.lock();
      try
      {
        paramString = (EarlyHandler)this.mapHandler.remove(paramString);
        lock.unlock();
        if (paramString != null) {
          paramString.g();
        }
        return;
      }
      finally
      {
        lock.unlock();
      }
    }
  }
  
  public void removeRequesting(String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("removeRequesting ");
      ((StringBuilder)???).append(paramString);
      QLog.i("EarlyDown.EarlyDownloadServiceImpl", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.mRequestSet)
    {
      if (this.mRequestSet.contains(paramString)) {
        this.mRequestSet.remove(paramString);
      }
      return;
    }
  }
  
  public void setEarlyDownloadLock()
  {
    lock.lock();
  }
  
  public void setEarlyDownloadUnLock()
  {
    lock.unlock();
  }
  
  public void updateConfigs(boolean paramBoolean)
  {
    long l = this.timeUpdateSuccess;
    if ((l > 0L) && (l + 7200000 > SystemClock.elapsedRealtime()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateConfigs() timeUpdateSuccess + delay(");
        ((StringBuilder)localObject).append(120);
        ((StringBuilder)localObject).append("min) > now. return.");
        QLog.d("EarlyDown", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    ReqUserInfo localReqUserInfo = new ReqUserInfo();
    localReqUserInfo.cType = 1;
    localReqUserInfo.stGps = new GPS();
    localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
    localReqUserInfo.strAuthPassword = "NzVK_qGE";
    localReqUserInfo.vCells = new ArrayList();
    localReqUserInfo.vMacs = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.mBaseEarlyHandlerProcessorArrayList;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      Iterator localIterator = this.mBaseEarlyHandlerProcessorArrayList.iterator();
      while (localIterator.hasNext())
      {
        BaseEarlyHandlerProcessor localBaseEarlyHandlerProcessor = (BaseEarlyHandlerProcessor)localIterator.next();
        if (localBaseEarlyHandlerProcessor != null)
        {
          localObject = null;
          EarlyHandler localEarlyHandler = getEarlyHandler(localBaseEarlyHandlerProcessor.a());
          if (localEarlyHandler != null)
          {
            localEarlyHandler.e(paramBoolean);
            localObject = localEarlyHandler.b(localBaseEarlyHandlerProcessor.a());
          }
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPluginList: 128 reqInfoV2s.len=");
      ((StringBuilder)localObject).append(localArrayList.size());
      QLog.d("EarlyDown", 2, ((StringBuilder)localObject).toString());
    }
    ((ServerConfigManager)this.app.getManager(4)).getPluginConfig(512, localReqUserInfo, localArrayList, this.mServerConfigObserver, AppSetting.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.api.impl.EarlyDownloadServiceImpl
 * JD-Core Version:    0.7.0.1
 */