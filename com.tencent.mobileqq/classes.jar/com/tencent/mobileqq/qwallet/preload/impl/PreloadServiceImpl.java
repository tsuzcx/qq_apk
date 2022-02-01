package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.DownloadChooseReq;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.config.ConfigInfo;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService.ConfigUpdateListener;
import com.tencent.mobileqq.qwallet.impl.QWalletCommonServlet;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.DownloadCallback;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.FlowControlObj;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathsListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.qwallet.preload.PreloadConfBean;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class PreloadServiceImpl
  extends PreloadManagerAbs
  implements INetInfoHandler, IQWalletConfigService.ConfigUpdateListener, IPreloadService
{
  private static final int PRELOAD_DELAYS_DEFAULT = 30;
  private static final int PRELOAD_DELAYS_MAX = 1800;
  private static final int PRELOAD_DELAYS_MIN = 5;
  private static final int PRELOAD_WAIT_SIZE_MIN = 1024;
  private static final int SAFE_FREE_SPACE = 104857600;
  private PreloadBackControlConfig mBackControlConfig;
  private Handler mFlowControlHandler;
  private HandlerThread mFlowControlThread;
  public boolean mIsOnDestroy = false;
  private int mNeedWaitSize = 1024;
  private PreloadConfig mPreloadConfig;
  private int mPreloadDelays = 30;
  
  private void checkAndDownload(DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    try
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkAndDownload|");
        ((StringBuilder)localObject1).append(paramBoolean);
        ((StringBuilder)localObject1).append("|");
        ((StringBuilder)localObject1).append(this.mPreloadConfig);
        QLog.d("PreloadService", 2, ((StringBuilder)localObject1).toString());
      }
      preCheck();
      if ((this.mPreloadConfig.getModuleNum() > 0) && (isDiskEnoughToDownload()))
      {
        this.mPreloadConfig.filterInvalidModules(this);
        Object localObject3 = this.mPreloadConfig.getModules();
        localObject1 = new ArrayList();
        Object localObject2 = new ArrayList();
        PreloadConfig.splitModulesByBackControl((List)localObject3, (List)localObject1, (List)localObject2);
        if (((List)localObject2).size() > 0)
        {
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("checkAndDownload|noBackControlMods");
            ((StringBuilder)localObject3).append(localObject2);
            QLog.d("PreloadService", 2, ((StringBuilder)localObject3).toString());
          }
          downloadModules((List)localObject2, paramDownloadListener, paramBoolean);
        }
        if (((List)localObject1).size() > 0)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("checkAndDownload|backControlMods");
            ((StringBuilder)localObject2).append(localObject1);
            QLog.d("PreloadService", 2, ((StringBuilder)localObject2).toString());
          }
          downloadBackControlModules((List)localObject1, paramDownloadListener, paramBoolean);
        }
        this.mPreloadConfig.savePreloadConfig();
        return;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  private void checkAndDownload(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aconst_null
    //   4: iload_1
    //   5: invokespecial 147	com/tencent/mobileqq/qwallet/preload/impl/PreloadServiceImpl:checkAndDownload	(Lcom/tencent/mobileqq/vip/DownloadListener;Z)V
    //   8: goto +42 -> 50
    //   11: astore_2
    //   12: goto +41 -> 53
    //   15: astore_2
    //   16: new 75	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   23: astore_3
    //   24: aload_3
    //   25: ldc 149
    //   27: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_3
    //   32: aload_2
    //   33: invokevirtual 152	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   36: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: ldc 94
    //   42: iconst_1
    //   43: aload_3
    //   44: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_0
    //   51: monitorexit
    //   52: return
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	PreloadServiceImpl
    //   0	57	1	paramBoolean	boolean
    //   11	1	2	localObject	Object
    //   15	41	2	localThrowable	Throwable
    //   23	21	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	8	11	finally
    //   16	50	11	finally
    //   2	8	15	java/lang/Throwable
  }
  
  private List<PreloadModuleImpl> delayLargerModulesAndReturnSmallerModules(List<PreloadModuleImpl> paramList, DownloadListener paramDownloadListener)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    PreloadConfig.splitModulesBySize(this.mNeedWaitSize, paramList, localArrayList1, localArrayList2);
    if (localArrayList2.size() > 0)
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("delayLargerModulesAndReturnSmallerModules|begin delay download:");
        paramList.append(this.mPreloadDelays);
        paramList.append("|");
        paramList.append(this.mNeedWaitSize);
        paramList.append("|");
        paramList.append(localArrayList2);
        QLog.d("PreloadService", 2, paramList.toString());
      }
      paramList = new WeakReference(this);
      ThreadManager.getTimer().schedule(new PreloadServiceImpl.4(this, paramList, localArrayList2, paramDownloadListener), this.mPreloadDelays * 1000);
    }
    return localArrayList1;
  }
  
  private void downloadBackControlModules(List<PreloadModuleImpl> paramList, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    Object localObject = this.mBackControlConfig;
    if (localObject == null) {
      return;
    }
    if (!((PreloadBackControlConfig)localObject).isLocalResNewest())
    {
      localObject = new DownloadChooseReq();
      ((DownloadChooseReq)localObject).iUin = this.mApp.getLongAccountUin();
      ((DownloadChooseReq)localObject).vecResInfo = PreloadConfig.modulesToResInfos(paramList);
      QWalletCommonServlet.a((JceStruct)localObject, new PreloadServiceImpl.3(this, paramList, paramDownloadListener, paramBoolean));
      return;
    }
    paramList = this.mPreloadConfig.resInfosToModules(this.mBackControlConfig.getLastBackResInfos());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadBackControlModules|choose res:");
      ((StringBuilder)localObject).append(paramList);
      QLog.d("PreloadService", 2, ((StringBuilder)localObject).toString());
    }
    downloadModules(paramList, paramDownloadListener, paramBoolean);
  }
  
  private void downloadModules(List<PreloadModuleImpl> paramList, DownloadListener paramDownloadListener)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((PreloadModuleImpl)paramList.next()).downloadModule(false, paramDownloadListener, this, true);
      }
    }
  }
  
  private void downloadModules(List<PreloadModuleImpl> paramList, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    Object localObject = paramList;
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "downloadModules|afterGetConfig");
      }
      localObject = delayLargerModulesAndReturnSmallerModules(paramList, paramDownloadListener);
    }
    downloadModules((List)localObject, paramDownloadListener);
  }
  
  private void initFlowControlHandler()
  {
    if (this.mFlowControlHandler == null) {
      this.mFlowControlHandler = new PreloadServiceImpl.8(this, ThreadManager.getSubThreadLooper());
    }
  }
  
  private void initPreloadHelpConfig()
  {
    Object localObject = (IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getLongAccountUin());
    localStringBuilder.append("");
    int i = ((IQWalletPreferenceApi)localObject).getInt(localStringBuilder.toString(), "deal_delay_interval", 30);
    localObject = (IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getLongAccountUin());
    localStringBuilder.append("");
    int j = ((IQWalletPreferenceApi)localObject).getInt(localStringBuilder.toString(), "need_wait_size", 1024);
    setPreloadHelpConfig(i, j);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initPreloadHelpConfig|");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(this.mPreloadDelays);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(this.mNeedWaitSize);
      QLog.d("PreloadService", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean isDiskEnoughToDownload()
  {
    String str = PreloadStaticApi.a();
    Object localObject = new File(str);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    long l1 = 0L;
    if (!TextUtils.isEmpty(str))
    {
      long l2 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).StorageManager$getFreeSpace(str);
      l1 = l2;
      if (l2 > 104857600L)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("isDiskEnoughToDownload|true|");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append("|");
          ((StringBuilder)localObject).append(l2);
          QLog.d("PreloadService", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isDiskEnoughToDownload|false|");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(l1);
      QLog.d("PreloadService", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public static boolean isManagerValid(PreloadServiceImpl paramPreloadServiceImpl)
  {
    return (paramPreloadServiceImpl != null) && (!paramPreloadServiceImpl.mIsOnDestroy);
  }
  
  private void saveConfigFromQQToSp(String paramString)
  {
    Object localObject = MobileQQ.getContext();
    if (localObject != null)
    {
      localObject = ((Context)localObject).getSharedPreferences("qwallet_preload_config", 4);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("config_from_qq");
        localStringBuilder.append(this.mApp.getAccount());
        ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString).apply();
      }
    }
  }
  
  private void startCheckConfig()
  {
    startCheckConfig(false);
  }
  
  private void synDataFromMoggy()
  {
    ThreadManager.executeOnSubThread(new PreloadServiceImpl.1(this));
  }
  
  private void toReportCrash(Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append(paramThrowable.toString());
      if (paramThrowable.getStackTrace() != null)
      {
        paramThrowable = paramThrowable.getStackTrace();
        int i = 0;
        while ((i < paramThrowable.length) && (i < 16))
        {
          localStringBuilder.append("\n ");
          localStringBuilder.append(paramThrowable[i].toString());
          i += 1;
        }
      }
      VACDReportUtil.a("preload_crash", "qqwallet", "crash", "Catch", null, 668814, localStringBuilder.toString());
    }
  }
  
  public void addResToFlowControlCheck(IPreloadService.FlowControlObj paramFlowControlObj)
  {
    if (this.mFlowControlHandler == null) {
      initFlowControlHandler();
    }
    Message localMessage = this.mFlowControlHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramFlowControlObj;
    this.mFlowControlHandler.sendMessage(localMessage);
  }
  
  public void downloadModule(String paramString)
  {
    try
    {
      paramString = getModuleByMID(paramString);
      if (paramString != null) {
        paramString.downloadModule(true, null, this, false);
      }
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void downloadModule(String paramString1, String paramString2, IPreloadService.DownloadCallback paramDownloadCallback)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("downloadModule|");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" | ");
        localStringBuilder.append(paramString2);
        QLog.d("PreloadService", 2, localStringBuilder.toString());
      }
      if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)) && (paramDownloadCallback != null))
      {
        mergeConfig(paramString2);
        this.mPreloadConfig.savePreloadConfig();
        paramString2 = this.mPreloadConfig.getModuleByID(paramString1);
        if ((paramString2 != null) && (paramString2.getResNum() != 0))
        {
          if (!isDiskEnoughToDownload())
          {
            if (QLog.isColorLevel()) {
              QLog.d("PreloadService", 2, "downloadModule|disk space not enough");
            }
            paramDownloadCallback.onDownloadResFinished(paramString1, -4, null, null);
            return;
          }
          paramString2.downloadModule(true, new PreloadServiceImpl.7(this, paramString1, paramDownloadCallback), this, false);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PreloadService", 2, "downloadModule|json wrong");
        }
        paramDownloadCallback.onDownloadResFinished(paramString1, -7, null, null);
        return;
      }
      return;
    }
    finally {}
  }
  
  public void downloadModule(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = getModuleByName(paramString);
      if (paramString != null) {
        paramString.downloadModule(paramBoolean, null, this, false);
      }
      return;
    }
    finally {}
  }
  
  @Deprecated
  public void downloadRes(String paramString1, String paramString2, IPreloadService.DownloadCallback paramDownloadCallback)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("downloadRes|");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append("|");
        ((StringBuilder)localObject1).append(paramString2);
        QLog.d("PreloadService", 2, ((StringBuilder)localObject1).toString());
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        mergeConfig(paramString2);
        this.mPreloadConfig.savePreloadConfig();
      }
      Iterator localIterator1 = this.mPreloadConfig.getModules().iterator();
      str = null;
      localObject1 = str;
      if (!localIterator1.hasNext()) {
        break label288;
      }
      PreloadModuleImpl localPreloadModuleImpl = (PreloadModuleImpl)localIterator1.next();
      Iterator localIterator2 = localPreloadModuleImpl.getResList().iterator();
      Object localObject2 = localObject1;
      paramString2 = str;
      for (;;)
      {
        str = paramString2;
        localObject1 = localObject2;
        if (!localIterator2.hasNext()) {
          break;
        }
        localObject1 = (PreloadResourceImpl)localIterator2.next();
        if (QWalletTools.c(paramString1, ((PreloadResourceImpl)localObject1).mResId))
        {
          paramString2 = localPreloadModuleImpl;
          localObject2 = localObject1;
        }
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        String str;
        for (;;)
        {
          throw paramString1;
        }
        label288:
        if (str != null) {
          if (localObject1 != null) {}
        }
      }
    }
    if (!isDiskEnoughToDownload())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "downloadRes|disk space not enough");
      }
      paramDownloadCallback.onDownloadResFinished(null, -4, null, null);
      return;
    }
    ((PreloadResourceImpl)localObject1).startDownload(this, str, new PreloadServiceImpl.6(this, paramDownloadCallback), false);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "downloadRes ERR_CONFIG_NOT_EXIST");
    }
    paramDownloadCallback.onDownloadResFinished(null, -7, null, null);
  }
  
  public void downloadUrls(List<String> paramList, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        getResPath((String)paramList.next(), paramOnGetPathListener);
      }
    }
  }
  
  public void getFilePath(String paramString, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    getFilePath(paramString, "", paramOnGetPathListener);
  }
  
  public void getFilePath(String paramString1, String paramString2, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.url = paramString1;
    localDownloadParam.md5 = paramString2;
    localDownloadParam.isForceUnzip = false;
    localDownloadParam.useQWalletConfig = true;
    getResPath(localDownloadParam, paramOnGetPathListener);
  }
  
  public void getFilePathByResID(String paramString, ResultReceiver paramResultReceiver)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Iterator localIterator1 = this.mPreloadConfig.getModules().iterator();
        localObject2 = localObject1;
        if (localIterator1.hasNext())
        {
          PreloadModuleImpl localPreloadModuleImpl = (PreloadModuleImpl)localIterator1.next();
          Iterator localIterator2 = localPreloadModuleImpl.getResList().iterator();
          localObject2 = localObject1;
          for (;;)
          {
            localObject1 = localObject2;
            if (!localIterator2.hasNext()) {
              break;
            }
            localObject1 = (PreloadResourceImpl)localIterator2.next();
            if (QWalletTools.c(paramString, ((PreloadResourceImpl)localObject1).mResId)) {
              localObject2 = PreloadStaticApi.a(((PreloadResourceImpl)localObject1).getResDownloadUrl(localPreloadModuleImpl), ((PreloadResourceImpl)localObject1).getFilePos());
            }
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getFilePathByResID|");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("|");
        ((StringBuilder)localObject1).append(this.mPreloadConfig);
        ((StringBuilder)localObject1).append("|");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.d("PreloadService", 2, ((StringBuilder)localObject1).toString());
      }
      if (paramResultReceiver != null)
      {
        paramString = new Bundle();
        paramString.putString("path", (String)localObject2);
        paramResultReceiver.send(0, paramString);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public PreloadModuleImpl getModuleByMID(String paramString)
  {
    try
    {
      paramString = this.mPreloadConfig.getModuleByID(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public PreloadModuleImpl getModuleByName(String paramString)
  {
    try
    {
      paramString = this.mPreloadConfig.getModuleByName(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String getResIdByUrl(String paramString)
  {
    return this.mPreloadConfig.getResIdByUrl(paramString);
  }
  
  public ResourceInfo getResInfoByResId(String paramString)
  {
    ResourceInfo localResourceInfo = this.mPreloadConfig.getResInfoByResId(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getResInfoByResId :");
      localStringBuilder.append(paramString);
      localStringBuilder.append("|");
      localStringBuilder.append(localResourceInfo);
      QLog.d("PreloadService", 2, localStringBuilder.toString());
    }
    return localResourceInfo;
  }
  
  public void getResPath(DownloadParam paramDownloadParam, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    if ((paramDownloadParam != null) && (!TextUtils.isEmpty(paramDownloadParam.url)))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getResPath: param");
        ((StringBuilder)localObject1).append(paramDownloadParam);
        QLog.d("PreloadService", 2, ((StringBuilder)localObject1).toString());
      }
      paramDownloadParam.standardlize();
      Object localObject1 = PreloadStaticApi.a(paramDownloadParam.url, paramDownloadParam.isForceUnzip, paramDownloadParam.filePos);
      boolean bool = PreloadStaticApi.a((ResourceInfo)localObject1, paramDownloadParam);
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getResPath: isValidFileExist");
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("PreloadService", 2, ((StringBuilder)localObject2).toString());
      }
      if (bool)
      {
        if (paramOnGetPathListener != null)
        {
          localObject2 = new IPreloadService.PathResult();
          ((IPreloadService.PathResult)localObject2).url = paramDownloadParam.url;
          ((IPreloadService.PathResult)localObject2).filePath = ((ResourceInfo)localObject1).filePath;
          ((IPreloadService.PathResult)localObject2).folderPath = ((ResourceInfo)localObject1).folderPath;
          ((IPreloadService.PathResult)localObject2).isAlreadyExist = true;
          paramOnGetPathListener.onResult(0, (IPreloadService.PathResult)localObject2);
        }
      }
      else
      {
        if (localObject1 != null)
        {
          ResUtil.b(paramDownloadParam.url, paramDownloadParam.filePos);
          QWalletTools.a(((ResourceInfo)localObject1).filePath);
          QWalletTools.a(((ResourceInfo)localObject1).folderPath);
        }
        realTimeDownload(paramDownloadParam, paramOnGetPathListener);
      }
      return;
    }
    if (paramOnGetPathListener != null) {
      paramOnGetPathListener.onResult(1, IPreloadService.PathResult.getFailRes(null));
    }
  }
  
  public void getResPath(LinkedList<DownloadParam> paramLinkedList, IPreloadService.OnGetPathsListener paramOnGetPathsListener)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getResPath: params");
      localStringBuilder.append(paramLinkedList);
      localStringBuilder.append(",OnGetPathsListener=");
      localStringBuilder.append(paramOnGetPathsListener);
      QLog.d("PreloadService", 2, localStringBuilder.toString());
    }
    if (paramLinkedList == null)
    {
      if (paramOnGetPathsListener != null) {
        paramOnGetPathsListener.a(1, null);
      }
      return;
    }
    new PreloadServiceImpl.MultiDownTask(this, paramLinkedList, paramOnGetPathsListener).a();
  }
  
  public PreloadResourceImpl getResourceByResID(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    Object localObject1 = null;
    if (!bool)
    {
      Iterator localIterator1 = this.mPreloadConfig.getModules().iterator();
      localObject2 = localObject1;
      if (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((PreloadModuleImpl)localIterator1.next()).getResList().iterator();
        localObject2 = localObject1;
        for (;;)
        {
          localObject1 = localObject2;
          if (!localIterator2.hasNext()) {
            break;
          }
          localObject1 = (PreloadResourceImpl)localIterator2.next();
          if (QWalletTools.c(paramString, ((PreloadResourceImpl)localObject1).mResId)) {
            localObject2 = localObject1;
          }
        }
      }
    }
    return localObject2;
  }
  
  public void getUnzipFolderPath(String paramString, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    getUnzipFolderPath(paramString, "", paramOnGetPathListener);
  }
  
  public void getUnzipFolderPath(String paramString1, String paramString2, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.url = paramString1;
    localDownloadParam.md5 = paramString2;
    localDownloadParam.isForceUnzip = true;
    localDownloadParam.useQWalletConfig = true;
    getResPath(localDownloadParam, paramOnGetPathListener);
  }
  
  public String getUnzipFolderPathByResId(String paramString)
  {
    paramString = getResInfoByResId(paramString);
    if (paramString != null) {
      return paramString.folderPath;
    }
    return null;
  }
  
  public String getVideoResPathByID(String paramString)
  {
    try
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getVideoResPathByID|");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("|");
        ((StringBuilder)localObject).append(this.mPreloadConfig);
        QLog.d("PreloadService", 2, ((StringBuilder)localObject).toString());
      }
      paramString = this.mPreloadConfig.getModuleByID(paramString);
      if (paramString != null)
      {
        localObject = paramString.getResList().iterator();
        while (((Iterator)localObject).hasNext())
        {
          PreloadResourceImpl localPreloadResourceImpl = (PreloadResourceImpl)((Iterator)localObject).next();
          if ((localPreloadResourceImpl.type == 5) && ((!TextUtils.isEmpty(localPreloadResourceImpl.url)) || (!TextUtils.isEmpty(localPreloadResourceImpl.urlPath))))
          {
            paramString = PreloadStaticApi.a(localPreloadResourceImpl.getResDownloadUrl(paramString), localPreloadResourceImpl.getFilePos());
            return paramString;
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "getVideoResPathByID no valid path");
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public boolean isResInConfig(PreloadResourceImpl paramPreloadResourceImpl)
  {
    return this.mPreloadConfig.isResInConfig(paramPreloadResourceImpl);
  }
  
  public void mergeConfig(String paramString)
  {
    try
    {
      this.mPreloadConfig.mergeConfig(paramString, this);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void notifyResFlowCheckNext()
  {
    if (this.mFlowControlHandler == null) {
      initFlowControlHandler();
    }
    this.mFlowControlHandler.sendEmptyMessage(2);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    super.onCreate(paramAppRuntime);
    this.mPreloadConfig = PreloadConfig.readConfig("preload.config", this.mApp);
    this.mBackControlConfig = PreloadBackControlConfig.readBackControlConfig(this.mApp);
    initPreloadHelpConfig();
    try
    {
      AppNetConnInfo.registerConnectionChangeReceiver(paramAppRuntime.getApplication(), this);
    }
    catch (Throwable paramAppRuntime)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AppNetConnInfo.registerConnectionChangeReceiver is error msg=");
      localStringBuilder.append(paramAppRuntime.getMessage());
      QLog.d("PreloadService", 1, localStringBuilder.toString());
      toReportCrash(paramAppRuntime);
    }
    synDataFromMoggy();
  }
  
  public void onDestroy()
  {
    this.mIsOnDestroy = true;
    Object localObject = (IQWalletConfigService)this.mApp.getRuntimeService(IQWalletConfigService.class, "");
    if (localObject != null) {
      ((IQWalletConfigService)localObject).unRegisterUpdateListener("preload", this);
    }
    AppNetConnInfo.unregisterNetInfoHandler(this);
    localObject = this.mFlowControlHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    this.mBackControlConfig = null;
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "onNetMobile2Wifi");
    }
    startCheckConfig();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "onNetNone2Mobile");
    }
    startCheckConfig();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "onNetNone2Wifi");
    }
    startCheckConfig();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "onNetWifi2Mobile");
    }
    startCheckConfig();
  }
  
  public void onNetWifi2None() {}
  
  public void onUpdate(String paramString1, String paramString2, ConfigInfo paramConfigInfo)
  {
    if (QWalletTools.c(paramString1, "preload"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadService", 2, "configFromMoggy onUpdate");
      }
      replaceConfigFromMoggy(paramConfigInfo);
      startCheckConfig();
    }
  }
  
  public void preCheck()
  {
    if (!PreloadStaticApi.a) {
      ResUtil.a(0, this.mPreloadConfig);
    }
    ResUtil.a(1, this.mPreloadConfig);
  }
  
  public void realTimeDownload(DownloadParam paramDownloadParam, IPreloadService.OnGetPathListener paramOnGetPathListener)
  {
    paramOnGetPathListener = new PreloadServiceImpl.2(this, paramDownloadParam, paramOnGetPathListener, new WeakReference(this));
    if (TextUtils.isEmpty(paramDownloadParam.filePath)) {
      paramDownloadParam.filePath = PreloadStaticApi.b(paramDownloadParam.url, paramDownloadParam.filePos);
    }
    if (paramDownloadParam.isFlowControl)
    {
      addResToFlowControlCheck(new RealTimeFlowControlObj(paramDownloadParam, paramOnGetPathListener));
      return;
    }
    PreloadComDownloader.a().a(paramDownloadParam, paramOnGetPathListener, null);
  }
  
  public void replaceConfig(PreloadConfBean paramPreloadConfBean)
  {
    try
    {
      localJSONArray = new JSONArray();
      if ((paramPreloadConfBean == null) || (paramPreloadConfBean.a == null)) {
        break label147;
      }
      paramPreloadConfBean = paramPreloadConfBean.a;
      k = paramPreloadConfBean.length;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        JSONArray localJSONArray;
        int k;
        int i;
        Object localObject;
        StringBuilder localStringBuilder;
        for (;;)
        {
          label147:
          throw paramPreloadConfBean;
        }
        i += 1;
      }
    }
    if (i < k)
    {
      localObject = paramPreloadConfBean[i].jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("receiveAllConfigs|type: 68,content: ");
        localStringBuilder.append((String)localObject);
        QLog.d("PreloadService", 2, localStringBuilder.toString());
      }
      try
      {
        localObject = new JSONObject((String)localObject).getJSONArray("module_config");
        int j = 0;
        while (j < ((JSONArray)localObject).length())
        {
          localJSONArray.put(((JSONArray)localObject).get(j));
          j += 1;
        }
        saveConfigFromQQToSp(localJSONArray.toString());
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    else
    {
      this.mPreloadConfig.innerReplaceConfig(localJSONArray, this, 0);
      return;
    }
  }
  
  public void replaceConfig(JSONArray paramJSONArray, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[replaceConfig] fromType=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("configJa=");
        localStringBuilder.append(paramJSONArray);
        QLog.i("PreloadService", 2, localStringBuilder.toString());
      }
      this.mPreloadConfig.innerReplaceConfig(paramJSONArray, this, paramInt);
      return;
    }
    finally {}
  }
  
  public void replaceConfigFromMoggy(ConfigInfo paramConfigInfo)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      if ((paramConfigInfo != null) && ("preload".equals(paramConfigInfo.jdField_a_of_type_JavaLangString)))
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("replaceConfigFromMoggy:");
          ((StringBuilder)localObject).append(paramConfigInfo.jdField_a_of_type_Long);
          ((StringBuilder)localObject).append("|");
          ((StringBuilder)localObject).append(this.mPreloadConfig.moggyConfigVersion);
          ((StringBuilder)localObject).append("|");
          ((StringBuilder)localObject).append(paramConfigInfo.b);
          QLog.d("PreloadService", 2, ((StringBuilder)localObject).toString());
        }
        long l1 = paramConfigInfo.jdField_a_of_type_Long;
        long l2 = this.mPreloadConfig.moggyConfigVersion;
        if (l1 <= l2) {
          return;
        }
        try
        {
          localObject = new JSONObject(paramConfigInfo.b).getJSONArray("module_config");
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            localJSONArray.put(((JSONArray)localObject).get(i));
            i += 1;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          this.mPreloadConfig.innerReplaceConfig(localJSONArray, this, 1);
          this.mPreloadConfig.moggyConfigVersion = paramConfigInfo.jdField_a_of_type_Long;
          if (QLog.isColorLevel())
          {
            paramConfigInfo = new StringBuilder();
            paramConfigInfo.append("after synDataFromMoggy：");
            paramConfigInfo.append(this.mPreloadConfig);
            QLog.d("PreloadService", 2, paramConfigInfo.toString());
          }
          this.mPreloadConfig.savePreloadConfig();
          return;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramConfigInfo;
    }
  }
  
  public void savePreloadConfig()
  {
    try
    {
      this.mPreloadConfig.savePreloadConfig();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setPreloadHelpConfig(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 5) {
      this.mPreloadDelays = 5;
    } else if (paramInt1 > 1800) {
      this.mPreloadDelays = 1800;
    } else {
      this.mPreloadDelays = paramInt1;
    }
    if (paramInt2 <= 0)
    {
      this.mNeedWaitSize = 1024;
      return;
    }
    this.mNeedWaitSize = paramInt2;
  }
  
  public void startCheckConfig(boolean paramBoolean)
  {
    if (this.mIsOnDestroy) {
      return;
    }
    ThreadManager.post(new PreloadServiceImpl.5(this, new WeakReference(this), paramBoolean), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl
 * JD-Core Version:    0.7.0.1
 */