package com.tencent.mobileqq.earlydownload;

import abyt;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.handler.ApngHandler;
import com.tencent.mobileqq.earlydownload.handler.ApolloJscHandler;
import com.tencent.mobileqq.earlydownload.handler.ApolloLibHandler;
import com.tencent.mobileqq.earlydownload.handler.AppleEmojiHandler;
import com.tencent.mobileqq.earlydownload.handler.ArNativeSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.handler.FaceModelsDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.FaceScanNativeSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.HotFriendResHandler;
import com.tencent.mobileqq.earlydownload.handler.JpegSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.earlydownload.handler.PrecoverHandler;
import com.tencent.mobileqq.earlydownload.handler.PttSilkAndChangeVoiceSoHandler;
import com.tencent.mobileqq.earlydownload.handler.QQDingdongSoundHandler;
import com.tencent.mobileqq.earlydownload.handler.QavGAudioSoundHandler;
import com.tencent.mobileqq.earlydownload.handler.QavImageHandler;
import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.QavVideoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.SystemFaceHandler;
import com.tencent.mobileqq.earlydownload.handler.ViolaLibHandler;
import com.tencent.mobileqq.earlydownload.handler.WebpSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.HttpEngineTask.IHttpEngineTask;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
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
import mqq.manager.Manager;
import mqq.manager.ServerConfigManager;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GPS;
import protocol.KQQConfig.GetResourceReqInfoV2;
import protocol.KQQConfig.GetResourceRespInfo;
import protocol.KQQConfig.GetResourceRespInfoV2;
import protocol.KQQConfig.GetResourceRespV2;
import protocol.KQQConfig.ReqUserInfo;

public class EarlyDownloadManager
  extends ServerConfigObserver
  implements Handler.Callback, INetEngine.IBreakDownFix, INetEngine.INetEngineListener, HttpEngineTask.IHttpEngineTask, Manager
{
  public static int a;
  private static String jdField_a_of_type_JavaLangString;
  public static final Lock a;
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "qq.android.appleemoji", "qq.android.system.face.gifv9", "qq.android.ar.native.so_v7.6.5.1", "qq.android.qav.so_665", "qq.android.qav.sov7_755", "qq.android.qav.image2", "qq.android.qav.muteaudio", "qq.android.pic.jpeg.so_above665", "qq.android.pic.webp.so", "qq.android.qav.video", "qq.android.ptt.so.658", "qq.android.system.chirp", "qq.android.dingdong.ring", "qq.android.early.precover", "android.qq.apollo.js.760g3", "android.qq.apollo.jsc", "qq.android.hotfriend.res", "qq.android.native.apng_v700", "qq.android.poke.res_1228", "qq.android.ar.face.so_v7.2.0", "qq.android.ar.face.models_v7.1.5", "android.qq.readinjoy.viola" };
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PreDownloadController jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController;
  public Boolean a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public final HashSet a;
  private boolean jdField_a_of_type_Boolean;
  private HashMap b = new HashMap();
  private HashMap c = new HashMap();
  
  static
  {
    jdField_a_of_type_Int = 60000;
    jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  }
  
  public EarlyDownloadManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController = ((PreDownloadController)paramQQAppInterface.getManager(192));
  }
  
  private static final EarlyHandler a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "createHandler pkgName=" + paramString);
    }
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return null;
      if ("qq.android.system.face.gifv9".equals(paramString)) {
        return new SystemFaceHandler(paramQQAppInterface);
      }
      if (QavSoDownloadHandler.e().equals(paramString)) {
        return new QavSoDownloadHandler(paramQQAppInterface);
      }
      if ("qq.android.qav.image2".equals(paramString)) {
        return new QavImageHandler(paramQQAppInterface);
      }
      if ("qq.android.qav.muteaudio".equals(paramString)) {
        return new QavGAudioSoundHandler(paramQQAppInterface);
      }
      if ("qq.android.pic.jpeg.so_above665".equals(paramString)) {
        return new JpegSoDownloadHandler(paramQQAppInterface);
      }
      if ("qq.android.pic.webp.so".equals(paramString)) {
        return new WebpSoDownloadHandler(paramQQAppInterface);
      }
      if ("qq.android.qav.video".equals(paramString)) {
        return new QavVideoDownloadHandler(paramQQAppInterface);
      }
      if ("qq.android.ptt.so.658".equals(paramString)) {
        return new PttSilkAndChangeVoiceSoHandler(paramQQAppInterface);
      }
      if ("qq.android.appleemoji".equals(paramString)) {
        return new AppleEmojiHandler(paramQQAppInterface);
      }
      if ("qq.android.ar.native.so_v7.6.5.1".equals(paramString)) {
        return new ArNativeSoDownloadHandler(paramQQAppInterface);
      }
      if ("qq.android.dingdong.ring".equals(paramString)) {
        return new QQDingdongSoundHandler(paramQQAppInterface);
      }
      if ("qq.android.system.chirp".equals(paramString)) {
        return new ChirpSoHandler(paramQQAppInterface);
      }
      if ("qq.android.early.precover".equals(paramString)) {
        return new PrecoverHandler(paramQQAppInterface);
      }
      if ("qq.android.hotfriend.res".equals(paramString)) {
        return new HotFriendResHandler(paramQQAppInterface);
      }
      if ("qq.android.native.apng_v700".equals(paramString)) {
        return new ApngHandler(paramQQAppInterface);
      }
      if ("qq.android.poke.res_1228".equals(paramString)) {
        return new PokeResHandler(paramQQAppInterface);
      }
      if ("android.qq.apollo.js.760g3".equals(paramString)) {
        return new ApolloLibHandler(paramQQAppInterface);
      }
      if ("qq.android.ar.face.so_v7.2.0".equals(paramString)) {
        return new FaceScanNativeSoDownloadHandler(paramQQAppInterface);
      }
      if ("qq.android.ar.face.models_v7.1.5".equals(paramString)) {
        return new FaceModelsDownloadHandler(paramQQAppInterface);
      }
      if ("android.qq.readinjoy.viola".equals(paramString)) {
        return new ViolaLibHandler(paramQQAppInterface);
      }
      if ("android.qq.apollo.jsc".equals(paramString)) {
        return new ApolloJscHandler(paramQQAppInterface);
      }
    } while (!QLog.isColorLevel());
    QLog.e("EarlyDown", 2, "createHandler() can't find Handler for:" + paramString);
    return null;
  }
  
  public static String a()
  {
    BaseApplication localBaseApplication;
    if ((jdField_a_of_type_JavaLangString == null) || (jdField_a_of_type_JavaLangString.length() == 0))
    {
      localBaseApplication = BaseApplicationImpl.getContext();
      if (Build.VERSION.SDK_INT <= 10) {
        break label69;
      }
    }
    label69:
    for (int i = 4;; i = 0)
    {
      jdField_a_of_type_JavaLangString = localBaseApplication.getSharedPreferences("Last_Login", i).getString("uin", "");
      if ((jdField_a_of_type_JavaLangString == null) || (jdField_a_of_type_JavaLangString.length() <= 0)) {
        break;
      }
      return jdField_a_of_type_JavaLangString;
    }
    return "10000";
  }
  
  private void a(XmlData paramXmlData, HttpNetReq paramHttpNetReq, AbsPreDownloadTask paramAbsPreDownloadTask)
  {
    paramXmlData.tStart = SystemClock.elapsedRealtime();
    paramXmlData.loadState = 2;
    paramXmlData.hasResDownloaded = false;
    EarlyDataFactory.a(paramXmlData, new String[] { "loadState", "hasResDownloaded" });
    Object localObject = a(paramXmlData.getStrResName());
    if ((localObject != null) && (paramXmlData.reqLoadCount == 0)) {
      ((EarlyHandler)localObject).b(paramXmlData);
    }
    paramXmlData.reqLoadCount += 1;
    jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      localObject = new abyt(null);
      ((abyt)localObject).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = paramHttpNetReq;
      ((abyt)localObject).jdField_a_of_type_ComTencentMobileqqTransfilePredownloadAbsPreDownloadTask = paramAbsPreDownloadTask;
      this.b.put(paramXmlData.strResName, localObject);
      this.c.remove(paramXmlData.strResName);
      return;
    }
    finally
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private void a(GetResourceRespV2 paramGetResourceRespV2)
  {
    if (paramGetResourceRespV2 == null) {}
    Object localObject1;
    Object localObject3;
    Object localObject4;
    do
    {
      return;
      if (paramGetResourceRespV2.vecDeletedResInfo != null)
      {
        localObject1 = paramGetResourceRespV2.vecDeletedResInfo.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (GetResourceRespInfoV2)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = ((GetResourceRespInfoV2)localObject2).strResName;
            localObject3 = (EarlyHandler)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
            if (localObject3 != null) {
              ((EarlyHandler)localObject3).e();
            }
            c((String)localObject2);
          }
        }
      }
      if (paramGetResourceRespV2.vecAddedResInfo != null)
      {
        localObject3 = paramGetResourceRespV2.vecAddedResInfo.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject2 = (GetResourceRespInfoV2)((Iterator)localObject3).next();
          if ((localObject2 != null) && (((GetResourceRespInfoV2)localObject2).iPluginType == 512))
          {
            localObject4 = ((GetResourceRespInfoV2)localObject2).strResName;
            localObject1 = a((String)localObject4);
            if (localObject1 != null)
            {
              XmlData localXmlData = EarlyDataFactory.a(((EarlyHandler)localObject1).a(), ((GetResourceRespInfoV2)localObject2).strResName, ((GetResourceRespInfoV2)localObject2).strPkgName, ((GetResourceRespInfoV2)localObject2).strResConf, ((GetResourceRespInfoV2)localObject2).uiNewVer, ((GetResourceRespInfoV2)localObject2).strResURL_big, ((GetResourceRespInfoV2)localObject2).strResURL_small);
              ((EarlyHandler)localObject1).a().updateServerInfo(localXmlData);
              EarlyDataFactory.a(((EarlyHandler)localObject1).a(), new String[0]);
              localObject2 = Message.obtain();
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = new Message();
              }
              ((Message)localObject1).what = 131332;
              ((Message)localObject1).obj = new Object[] { localObject4, localXmlData };
              if (((String)localObject4).equals("qq.android.ar.native.so_v7.6.5.1")) {}
              for (jdField_a_of_type_Int = 0;; jdField_a_of_type_Int = 60000)
              {
                this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, jdField_a_of_type_Int);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("EarlyDown", 2, "doOnGetConfig() Added resName=" + (String)localObject4 + " updateServerInfo done, doOnServerResp after " + jdField_a_of_type_Int + "ms");
                break;
              }
            }
          }
        }
      }
    } while (paramGetResourceRespV2.vecUpdatedResInfo == null);
    Object localObject2 = paramGetResourceRespV2.vecUpdatedResInfo.iterator();
    label367:
    while (((Iterator)localObject2).hasNext())
    {
      paramGetResourceRespV2 = (GetResourceRespInfoV2)((Iterator)localObject2).next();
      if ((paramGetResourceRespV2 != null) && (paramGetResourceRespV2.iPluginType == 512))
      {
        localObject3 = paramGetResourceRespV2.strResName;
        localObject1 = a((String)localObject3);
        if (localObject1 != null)
        {
          int i = ((EarlyHandler)localObject1).a().Version;
          localObject4 = EarlyDataFactory.a(((EarlyHandler)localObject1).a(), paramGetResourceRespV2.strResName, paramGetResourceRespV2.strPkgName, paramGetResourceRespV2.strResConf, paramGetResourceRespV2.uiNewVer, paramGetResourceRespV2.strResURL_big, paramGetResourceRespV2.strResURL_small);
          ((EarlyHandler)localObject1).a().updateServerInfo((XmlData)localObject4);
          if (i < paramGetResourceRespV2.uiNewVer) {
            ((EarlyHandler)localObject1).a().loadState = 0;
          }
          EarlyDataFactory.a(((EarlyHandler)localObject1).a(), new String[0]);
          localObject1 = Message.obtain();
          paramGetResourceRespV2 = (GetResourceRespV2)localObject1;
          if (localObject1 == null) {
            paramGetResourceRespV2 = new Message();
          }
          paramGetResourceRespV2.what = 131332;
          paramGetResourceRespV2.obj = new Object[] { localObject3, localObject4 };
          if (!((String)localObject3).equals("qq.android.ar.native.so_v7.6.5.1")) {
            break label622;
          }
        }
      }
    }
    label622:
    for (jdField_a_of_type_Int = 0;; jdField_a_of_type_Int = 60000)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramGetResourceRespV2, jdField_a_of_type_Int);
      if (!QLog.isColorLevel()) {
        break label367;
      }
      QLog.d("EarlyDown", 2, "doOnGetConfig() Updated resName=" + (String)localObject3 + " updateServerInfo done, doOnServerResp after " + jdField_a_of_type_Int + "ms");
      break label367;
      break;
    }
  }
  
  private boolean a(XmlData paramXmlData, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "verifyResource() data=" + paramXmlData.strResName + ", filepath=" + paramString);
    }
    if ((paramXmlData == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if (TextUtils.isEmpty(paramXmlData.MD5)) {
      return false;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("EarlyDown", 2, "verifyResource() file[" + paramString + "] not exist..");
      }
      return false;
    }
    Object localObject = null;
    try
    {
      paramString = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "verifyResource " + paramXmlData.strResName + ",data.md5=" + paramXmlData.MD5 + ",file.md5=" + paramString);
      }
      if (paramXmlData.MD5.equalsIgnoreCase(paramString)) {
        return true;
      }
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        try
        {
          paramString = MD5FileUtil.a(localFile);
        }
        catch (Exception paramString)
        {
          paramString = localObject;
        }
        paramXmlData.strLog = (".md5.S:" + paramXmlData.MD5 + ".L:" + paramString + ".");
        return false;
      }
    }
  }
  
  private void b(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("strResName");
    Object localObject2 = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "handleBroadcastReq() resName=" + str + " action=" + (String)localObject2);
    }
    EarlyHandler localEarlyHandler = a(str);
    Object localObject1;
    if (localEarlyHandler == null)
    {
      localObject1 = new Intent(paramIntent.getAction().replace("req.", "resp."));
      ((Intent)localObject1).putExtra("strResName", paramIntent.getStringExtra("strResName"));
      ((Intent)localObject1).putExtra("strPkgName", paramIntent.getStringExtra("strPkgName"));
      ((Intent)localObject1).putExtra("reqResult", false);
      ((Intent)localObject1).putExtra("resultReason", "resName:" + str + " is not valid.");
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject1, "com.tencent.qqhead.permission.getheadresp");
    }
    do
    {
      do
      {
        return;
        localObject1 = localEarlyHandler.a();
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
            BaseApplicationImpl.getContext().sendBroadcast(paramIntent, "com.tencent.qqhead.permission.getheadresp");
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
          BaseApplicationImpl.getContext().sendBroadcast(paramIntent, "com.tencent.qqhead.permission.getheadresp");
          return;
        }
        if ("req.com.tencent.mobileqq.EARLY_CANCEL".equals(localObject2))
        {
          localEarlyHandler.b(true);
          a(localEarlyHandler.a());
          return;
        }
      } while (!"req.com.tencent.mobileqq.EARLY_SET_FAIL".equals(localObject2));
      localEarlyHandler.c(false);
      localObject2 = new Intent("resp.com.tencent.mobileqq.EARLY_SET_FAIL");
      ((Intent)localObject2).putExtra("strResName", str);
      ((Intent)localObject2).putExtra("strPkgName", ((XmlData)localObject1).strPkgName);
      ((Intent)localObject2).putExtra("reqResult", true);
      ((Intent)localObject2).putExtra("loadState", ((XmlData)localObject1).loadState);
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject2, "com.tencent.qqhead.permission.getheadresp");
    } while (!paramIntent.getBooleanExtra("restartDownload", false));
    localEarlyHandler.b(true);
    localEarlyHandler.a(paramIntent.getBooleanExtra("userClick", false));
  }
  
  private void b(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "doOnCancelDownload() name=" + paramXmlData.strResName + ",strResURL_big=" + paramXmlData.strResURL_big + ",strResURL_small=" + paramXmlData.strResURL_small + ",localVer=" + paramXmlData.Version);
    }
    jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    EarlyHandler localEarlyHandler;
    do
    {
      for (;;)
      {
        try
        {
          localObject = (abyt)this.b.remove(paramXmlData.strResName);
          HttpEngineTask localHttpEngineTask = (HttpEngineTask)this.c.remove(paramXmlData.strResName);
          jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "doOnCancelDownload(), netReq = " + ((abyt)localObject).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq + ", pendingNetReq = " + localHttpEngineTask);
          }
          localEarlyHandler = a(paramXmlData.strResName);
          if ((localObject == null) && (localHttpEngineTask == null)) {
            break;
          }
          if (localObject != null)
          {
            if (((abyt)localObject).jdField_a_of_type_ComTencentMobileqqTransfilePredownloadAbsPreDownloadTask != null) {
              this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.a(paramXmlData.strResURL_big);
            }
          }
          else
          {
            if (localHttpEngineTask != null) {
              this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.a(paramXmlData.strResURL_big);
            }
            paramXmlData.tStart = 0L;
            paramXmlData.hasResDownloaded = false;
            paramXmlData.loadState = 0;
            EarlyDataFactory.a(paramXmlData, new String[] { "loadState", "hasResDownloaded", "tStart" });
            if (localEarlyHandler != null) {
              localEarlyHandler.c(paramXmlData);
            }
            return;
          }
        }
        finally
        {
          jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0).b(((abyt)localObject).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
      }
    } while ((localEarlyHandler == null) || (!localEarlyHandler.d()));
    Object localObject = new Intent("resp.com.tencent.mobileqq.EARLY_CANCEL");
    ((Intent)localObject).putExtra("reqResult", false);
    ((Intent)localObject).putExtra("resultReason", "resName=" + paramXmlData.strResName + " is not loading..");
    ((Intent)localObject).putExtra("strResName", paramXmlData.strResName);
    ((Intent)localObject).putExtra("strPkgName", paramXmlData.strPkgName);
    BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.qqhead.permission.getheadresp");
    localEarlyHandler.b(false);
  }
  
  /* Error */
  private void b(NetResp paramNetResp)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 649	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   4: invokevirtual 653	com/tencent/mobileqq/transfile/NetReq:a	()Ljava/lang/Object;
    //   7: checkcast 278	com/tencent/mobileqq/earlydownload/xmldata/XmlData
    //   10: astore 15
    //   12: aload 15
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: aload_1
    //   19: getfield 654	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Int	I
    //   22: iconst_3
    //   23: if_icmpne +46 -> 69
    //   26: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq -12 -> 17
    //   32: ldc 140
    //   34: iconst_2
    //   35: new 142	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 656
    //   45: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload 15
    //   50: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   53: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 658
    //   59: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: return
    //   69: aload_1
    //   70: getfield 654	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Int	I
    //   73: ifne +338 -> 411
    //   76: iconst_1
    //   77: istore_3
    //   78: invokestatic 276	android/os/SystemClock:elapsedRealtime	()J
    //   81: lstore 9
    //   83: aload 15
    //   85: getfield 281	com/tencent/mobileqq/earlydownload/xmldata/XmlData:tStart	J
    //   88: lstore 11
    //   90: lconst_0
    //   91: lstore 5
    //   93: new 462	java/io/File
    //   96: dup
    //   97: aload_1
    //   98: getfield 649	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   101: getfield 660	com/tencent/mobileqq/transfile/NetReq:c	Ljava/lang/String;
    //   104: invokespecial 464	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: invokevirtual 662	java/io/File:length	()J
    //   110: lstore 7
    //   112: lload 7
    //   114: lstore 5
    //   116: getstatic 89	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   119: invokeinterface 313 1 0
    //   124: aload_0
    //   125: getfield 99	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:b	Ljava/util/HashMap;
    //   128: aload 15
    //   130: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   133: invokevirtual 335	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   136: checkcast 315	abyt
    //   139: astore 13
    //   141: aload 13
    //   143: ifnull +273 -> 416
    //   146: aload 13
    //   148: getfield 321	abyt:jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq	Lcom/tencent/mobileqq/transfile/HttpNetReq;
    //   151: astore 13
    //   153: getstatic 89	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   156: invokeinterface 338 1 0
    //   161: iload_3
    //   162: ifeq +1080 -> 1242
    //   165: aload_0
    //   166: aload 15
    //   168: aload_1
    //   169: getfield 649	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   172: getfield 660	com/tencent/mobileqq/transfile/NetReq:c	Ljava/lang/String;
    //   175: invokespecial 664	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;Ljava/lang/String;)Z
    //   178: istore 4
    //   180: iload 4
    //   182: ifne +68 -> 250
    //   185: aload_1
    //   186: ldc_w 665
    //   189: putfield 667	com/tencent/mobileqq/transfile/NetResp:b	I
    //   192: aload_1
    //   193: new 142	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   200: ldc_w 669
    //   203: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: lload 5
    //   208: invokevirtual 672	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   211: aload 15
    //   213: getfield 507	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strLog	Ljava/lang/String;
    //   216: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: putfield 673	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   225: aload 15
    //   227: ldc_w 261
    //   230: putfield 507	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strLog	Ljava/lang/String;
    //   233: aload 15
    //   235: iconst_0
    //   236: putfield 287	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   239: aload_1
    //   240: getfield 649	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   243: getfield 660	com/tencent/mobileqq/transfile/NetReq:c	Ljava/lang/String;
    //   246: invokestatic 677	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   249: pop
    //   250: iload 4
    //   252: istore_3
    //   253: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +47 -> 303
    //   259: ldc 140
    //   261: iconst_2
    //   262: new 142	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 679
    //   272: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: iload 4
    //   277: invokevirtual 682	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   280: ldc_w 684
    //   283: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload 15
    //   288: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   291: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: iload 4
    //   302: istore_3
    //   303: aload 15
    //   305: getfield 303	com/tencent/mobileqq/earlydownload/xmldata/XmlData:reqLoadCount	I
    //   308: istore_2
    //   309: aload_1
    //   310: getfield 667	com/tencent/mobileqq/transfile/NetResp:b	I
    //   313: ldc_w 665
    //   316: if_icmpeq +13 -> 329
    //   319: aload_1
    //   320: getfield 667	com/tencent/mobileqq/transfile/NetResp:b	I
    //   323: sipush -9527
    //   326: if_icmpne +107 -> 433
    //   329: iload_2
    //   330: iconst_3
    //   331: if_icmpge +102 -> 433
    //   334: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +60 -> 397
    //   340: ldc 140
    //   342: iconst_2
    //   343: new 142	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   350: ldc_w 686
    //   353: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload 15
    //   358: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   361: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc_w 688
    //   367: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload 15
    //   372: getfield 303	com/tencent/mobileqq/earlydownload/xmldata/XmlData:reqLoadCount	I
    //   375: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   378: ldc_w 690
    //   381: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload_1
    //   385: getfield 667	com/tencent/mobileqq/transfile/NetResp:b	I
    //   388: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   391: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: aload_0
    //   398: aload 15
    //   400: aload_1
    //   401: getfield 649	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   404: getfield 660	com/tencent/mobileqq/transfile/NetReq:c	Ljava/lang/String;
    //   407: invokevirtual 693	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;Ljava/lang/String;)V
    //   410: return
    //   411: iconst_0
    //   412: istore_3
    //   413: goto -335 -> 78
    //   416: aconst_null
    //   417: astore 13
    //   419: goto -266 -> 153
    //   422: astore_1
    //   423: getstatic 89	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   426: invokeinterface 338 1 0
    //   431: aload_1
    //   432: athrow
    //   433: aload 15
    //   435: iconst_0
    //   436: putfield 303	com/tencent/mobileqq/earlydownload/xmldata/XmlData:reqLoadCount	I
    //   439: aload_0
    //   440: aload 15
    //   442: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   445: invokevirtual 300	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/earlydownload/handler/EarlyHandler;
    //   448: astore 16
    //   450: iload_3
    //   451: ifeq +605 -> 1056
    //   454: aload 15
    //   456: lconst_0
    //   457: putfield 696	com/tencent/mobileqq/earlydownload/xmldata/XmlData:tLoadFail	J
    //   460: aload 15
    //   462: iconst_1
    //   463: putfield 284	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   466: aload 15
    //   468: iconst_1
    //   469: putfield 287	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   472: aconst_null
    //   473: astore 14
    //   475: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq +50 -> 528
    //   481: new 698	java/lang/StringBuffer
    //   484: dup
    //   485: new 142	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   492: ldc_w 700
    //   495: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload 15
    //   500: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   503: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: ldc_w 702
    //   509: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 15
    //   514: getfield 705	com/tencent/mobileqq/earlydownload/xmldata/XmlData:StoreBackup	Z
    //   517: invokevirtual 682	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   520: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokespecial 706	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   526: astore 14
    //   528: aload 15
    //   530: getfield 705	com/tencent/mobileqq/earlydownload/xmldata/XmlData:StoreBackup	Z
    //   533: ifeq +94 -> 627
    //   536: aload 16
    //   538: ifnull +89 -> 627
    //   541: aload 16
    //   543: invokevirtual 708	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:d	()Ljava/lang/String;
    //   546: astore 17
    //   548: aload_1
    //   549: getfield 649	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   552: getfield 660	com/tencent/mobileqq/transfile/NetReq:c	Ljava/lang/String;
    //   555: aload 17
    //   557: invokestatic 711	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   560: istore 4
    //   562: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   565: ifeq +62 -> 627
    //   568: aload 14
    //   570: ifnull +57 -> 627
    //   573: aload 14
    //   575: new 142	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   582: ldc_w 713
    //   585: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: iload 4
    //   590: invokevirtual 682	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   593: ldc_w 715
    //   596: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: aload_1
    //   600: getfield 649	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   603: getfield 660	com/tencent/mobileqq/transfile/NetReq:c	Ljava/lang/String;
    //   606: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: ldc_w 717
    //   612: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: aload 17
    //   617: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   623: invokevirtual 720	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   626: pop
    //   627: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   630: ifeq +19 -> 649
    //   633: aload 14
    //   635: ifnull +14 -> 649
    //   638: ldc 140
    //   640: iconst_2
    //   641: aload 14
    //   643: invokevirtual 721	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   646: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   649: aload 15
    //   651: iconst_4
    //   652: anewarray 33	java/lang/String
    //   655: dup
    //   656: iconst_0
    //   657: ldc_w 722
    //   660: aastore
    //   661: dup
    //   662: iconst_1
    //   663: ldc_w 288
    //   666: aastore
    //   667: dup
    //   668: iconst_2
    //   669: ldc_w 723
    //   672: aastore
    //   673: dup
    //   674: iconst_3
    //   675: ldc_w 289
    //   678: aastore
    //   679: invokestatic 294	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   682: aload_0
    //   683: aload 15
    //   685: invokevirtual 297	com/tencent/mobileqq/earlydownload/xmldata/XmlData:getStrResName	()Ljava/lang/String;
    //   688: invokevirtual 725	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:b	(Ljava/lang/String;)V
    //   691: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   694: ifeq +70 -> 764
    //   697: ldc 140
    //   699: iconst_2
    //   700: new 142	java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   707: ldc_w 727
    //   710: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: iload_3
    //   714: invokevirtual 682	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   717: ldc_w 729
    //   720: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: aload_1
    //   724: getfield 667	com/tencent/mobileqq/transfile/NetResp:b	I
    //   727: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   730: ldc_w 731
    //   733: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: aload 15
    //   738: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   741: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: ldc_w 605
    //   747: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: aload 15
    //   752: getfield 606	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResURL_big	Ljava/lang/String;
    //   755: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   764: aload 13
    //   766: ifnull +418 -> 1184
    //   769: aload 16
    //   771: ifnull +27 -> 798
    //   774: aload 16
    //   776: aload 15
    //   778: iload_3
    //   779: aload_1
    //   780: getfield 667	com/tencent/mobileqq/transfile/NetResp:b	I
    //   783: aload_1
    //   784: getfield 649	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   787: getfield 660	com/tencent/mobileqq/transfile/NetReq:c	Ljava/lang/String;
    //   790: invokevirtual 734	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;ZILjava/lang/String;)V
    //   793: aload 16
    //   795: invokevirtual 736	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:d	()V
    //   798: aload_1
    //   799: getfield 667	com/tencent/mobileqq/transfile/NetResp:b	I
    //   802: sipush 9366
    //   805: if_icmpeq -788 -> 17
    //   808: aload_1
    //   809: getfield 667	com/tencent/mobileqq/transfile/NetResp:b	I
    //   812: sipush 9037
    //   815: if_icmpeq -798 -> 17
    //   818: aload_1
    //   819: getfield 667	com/tencent/mobileqq/transfile/NetResp:b	I
    //   822: sipush 9004
    //   825: if_icmpeq -808 -> 17
    //   828: aload_1
    //   829: getfield 667	com/tencent/mobileqq/transfile/NetResp:b	I
    //   832: sipush 9040
    //   835: if_icmpeq -818 -> 17
    //   838: new 94	java/util/HashMap
    //   841: dup
    //   842: invokespecial 95	java/util/HashMap:<init>	()V
    //   845: astore 13
    //   847: aload 13
    //   849: ldc_w 738
    //   852: aload_1
    //   853: getfield 667	com/tencent/mobileqq/transfile/NetResp:b	I
    //   856: invokestatic 743	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   859: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   862: pop
    //   863: aload 13
    //   865: ldc_w 745
    //   868: aload 15
    //   870: getfield 558	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   873: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   876: pop
    //   877: aload 13
    //   879: ldc_w 747
    //   882: iload_2
    //   883: invokestatic 743	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   886: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   889: pop
    //   890: iload_3
    //   891: ifne +108 -> 999
    //   894: aload_1
    //   895: getfield 748	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   898: ifnull +42 -> 940
    //   901: aload_1
    //   902: getfield 748	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   905: ldc_w 750
    //   908: invokevirtual 366	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   911: checkcast 33	java/lang/String
    //   914: astore 14
    //   916: aload 14
    //   918: ifnull +22 -> 940
    //   921: aload 14
    //   923: invokevirtual 161	java/lang/String:length	()I
    //   926: ifle +14 -> 940
    //   929: aload 13
    //   931: ldc_w 752
    //   934: aload 14
    //   936: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   939: pop
    //   940: aload_1
    //   941: getfield 673	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   944: ifnull +55 -> 999
    //   947: aload_1
    //   948: getfield 673	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   951: invokevirtual 161	java/lang/String:length	()I
    //   954: ifle +45 -> 999
    //   957: aload 13
    //   959: ldc_w 754
    //   962: new 142	java/lang/StringBuilder
    //   965: dup
    //   966: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   969: aload_1
    //   970: getfield 673	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   973: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: aload 15
    //   978: getfield 507	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strLog	Ljava/lang/String;
    //   981: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   990: pop
    //   991: aload 15
    //   993: ldc_w 261
    //   996: putfield 507	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strLog	Ljava/lang/String;
    //   999: aload 16
    //   1001: ifnull -984 -> 17
    //   1004: aload 16
    //   1006: invokevirtual 756	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	()Ljava/lang/String;
    //   1009: astore_1
    //   1010: aload_1
    //   1011: ifnull -994 -> 17
    //   1014: aload_1
    //   1015: invokevirtual 161	java/lang/String:length	()I
    //   1018: ifle -1001 -> 17
    //   1021: invokestatic 244	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1024: invokestatic 761	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1027: aload_0
    //   1028: getfield 108	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1031: invokevirtual 764	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1034: aload 16
    //   1036: invokevirtual 756	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	()Ljava/lang/String;
    //   1039: iload_3
    //   1040: lload 9
    //   1042: lload 11
    //   1044: lsub
    //   1045: lload 5
    //   1047: aload 13
    //   1049: ldc_w 261
    //   1052: invokevirtual 767	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1055: return
    //   1056: aload_1
    //   1057: getfield 667	com/tencent/mobileqq/transfile/NetResp:b	I
    //   1060: sipush 9366
    //   1063: if_icmpeq +51 -> 1114
    //   1066: aload_1
    //   1067: getfield 667	com/tencent/mobileqq/transfile/NetResp:b	I
    //   1070: sipush 9369
    //   1073: if_icmpeq +41 -> 1114
    //   1076: aload_1
    //   1077: getfield 667	com/tencent/mobileqq/transfile/NetResp:b	I
    //   1080: sipush 9367
    //   1083: if_icmpeq +31 -> 1114
    //   1086: aload_1
    //   1087: getfield 667	com/tencent/mobileqq/transfile/NetResp:b	I
    //   1090: sipush 9037
    //   1093: if_icmpeq +21 -> 1114
    //   1096: aload_1
    //   1097: getfield 667	com/tencent/mobileqq/transfile/NetResp:b	I
    //   1100: sipush 9004
    //   1103: if_icmpeq +11 -> 1114
    //   1106: aload 15
    //   1108: invokestatic 772	java/lang/System:currentTimeMillis	()J
    //   1111: putfield 696	com/tencent/mobileqq/earlydownload/xmldata/XmlData:tLoadFail	J
    //   1114: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1117: ifeq +47 -> 1164
    //   1120: ldc 140
    //   1122: iconst_2
    //   1123: new 142	java/lang/StringBuilder
    //   1126: dup
    //   1127: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   1130: ldc_w 774
    //   1133: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: aload 15
    //   1138: getfield 696	com/tencent/mobileqq/earlydownload/xmldata/XmlData:tLoadFail	J
    //   1141: invokevirtual 672	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1144: ldc_w 776
    //   1147: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: aload 15
    //   1152: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   1155: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1161: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1164: aload 16
    //   1166: iconst_1
    //   1167: invokevirtual 597	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:c	(Z)V
    //   1170: aload_1
    //   1171: getfield 649	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   1174: getfield 660	com/tencent/mobileqq/transfile/NetReq:c	Ljava/lang/String;
    //   1177: invokestatic 677	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   1180: pop
    //   1181: goto -532 -> 649
    //   1184: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1187: ifeq -1170 -> 17
    //   1190: ldc 140
    //   1192: iconst_2
    //   1193: new 142	java/lang/StringBuilder
    //   1196: dup
    //   1197: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   1200: ldc_w 656
    //   1203: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: aload 15
    //   1208: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   1211: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: ldc_w 778
    //   1217: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1223: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1226: return
    //   1227: astore 17
    //   1229: goto -602 -> 627
    //   1232: astore 14
    //   1234: goto -984 -> 250
    //   1237: astore 13
    //   1239: goto -1123 -> 116
    //   1242: goto -939 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1245	0	this	EarlyDownloadManager
    //   0	1245	1	paramNetResp	NetResp
    //   308	575	2	i	int
    //   77	963	3	bool1	boolean
    //   178	411	4	bool2	boolean
    //   91	955	5	l1	long
    //   110	3	7	l2	long
    //   81	960	9	l3	long
    //   88	955	11	l4	long
    //   139	909	13	localObject1	Object
    //   1237	1	13	localException1	Exception
    //   473	462	14	localObject2	Object
    //   1232	1	14	localException2	Exception
    //   10	1197	15	localXmlData	XmlData
    //   448	717	16	localEarlyHandler	EarlyHandler
    //   546	70	17	str	String
    //   1227	1	17	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   124	141	422	finally
    //   146	153	422	finally
    //   541	568	1227	java/lang/Exception
    //   573	627	1227	java/lang/Exception
    //   239	250	1232	java/lang/Exception
    //   93	112	1237	java/lang/Exception
  }
  
  public EarlyHandler a(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.length() == 0)) {
      localObject = null;
    }
    EarlyHandler localEarlyHandler;
    do
    {
      do
      {
        return localObject;
        localEarlyHandler = (EarlyHandler)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        localObject = localEarlyHandler;
      } while (localEarlyHandler != null);
      localEarlyHandler = a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = localEarlyHandler;
    } while (localEarlyHandler == null);
    jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localEarlyHandler);
      }
      return localEarlyHandler;
    }
    finally
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
        bool = this.jdField_a_of_type_AndroidOsHandler.hasMessages(131331);
        if ((!this.jdField_a_of_type_Boolean) || (bool)) {
          break;
        }
        Message localMessage2 = Message.obtain();
        Message localMessage1 = localMessage2;
        if (localMessage2 == null) {
          localMessage1 = new Message();
        }
        localMessage1.what = 131330;
        if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(131330)) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(131330);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage1, jdField_a_of_type_Int);
      } while (!QLog.isColorLevel());
      QLog.d("EarlyDown", 2, "onNetChange() sendMsg:ACTION_NET_CHANGE, delay(ms):" + jdField_a_of_type_Int);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("EarlyDown", 2, "onNetChanged() return, afterAppStart=" + this.jdField_a_of_type_Boolean + " hasMsg:" + bool);
  }
  
  public void a(Intent paramIntent)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage2 = Message.obtain();
      Message localMessage1 = localMessage2;
      if (localMessage2 == null) {
        localMessage1 = new Message();
      }
      localMessage1.obj = paramIntent;
      localMessage1.what = 131333;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage1);
    }
  }
  
  void a(XmlData paramXmlData)
  {
    if (paramXmlData == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EarlyDown", 2, "cancelDownload.name=" + paramXmlData.strResName + ",strResURL_big=" + paramXmlData.strResURL_big + ",localVer=" + paramXmlData.Version);
      }
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(131329, paramXmlData).sendToTarget();
  }
  
  /* Error */
  public void a(XmlData paramXmlData, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iconst_2
    //   3: istore 4
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnull +14 -> 22
    //   11: aload_2
    //   12: ifnull +10 -> 22
    //   15: aload_2
    //   16: invokevirtual 161	java/lang/String:length	()I
    //   19: ifne +74 -> 93
    //   22: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +41 -> 66
    //   28: new 142	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 818
    //   38: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: astore 6
    //   43: aload_1
    //   44: ifnonnull +25 -> 69
    //   47: ldc_w 820
    //   50: astore_1
    //   51: ldc 140
    //   53: iconst_2
    //   54: aload 6
    //   56: aload_1
    //   57: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: new 142	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 822
    //   79: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_2
    //   83: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore_1
    //   90: goto -39 -> 51
    //   93: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +55 -> 151
    //   99: ldc 140
    //   101: iconst_2
    //   102: new 142	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   109: ldc_w 824
    //   112: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   119: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc_w 826
    //   125: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_1
    //   129: getfield 606	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResURL_big	Ljava/lang/String;
    //   132: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc_w 828
    //   138: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_2
    //   142: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload_1
    //   152: getfield 606	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResURL_big	Ljava/lang/String;
    //   155: invokestatic 457	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifne -92 -> 66
    //   161: getstatic 89	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   164: invokeinterface 313 1 0
    //   169: aload_0
    //   170: getfield 99	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:b	Ljava/util/HashMap;
    //   173: aload_1
    //   174: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   177: invokevirtual 783	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   180: ifeq +80 -> 260
    //   183: aload_1
    //   184: getfield 284	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   187: ifne +22 -> 209
    //   190: aload_1
    //   191: iconst_2
    //   192: putfield 284	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   195: aload_1
    //   196: iconst_1
    //   197: anewarray 33	java/lang/String
    //   200: dup
    //   201: iconst_0
    //   202: ldc_w 288
    //   205: aastore
    //   206: invokestatic 294	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   209: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +32 -> 244
    //   215: ldc 140
    //   217: iconst_2
    //   218: new 142	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   225: ldc_w 830
    //   228: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_1
    //   232: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   235: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: getstatic 89	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   247: invokeinterface 338 1 0
    //   252: goto -186 -> 66
    //   255: astore_1
    //   256: aload_0
    //   257: monitorexit
    //   258: aload_1
    //   259: athrow
    //   260: aload_0
    //   261: getfield 101	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:c	Ljava/util/HashMap;
    //   264: aload_1
    //   265: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   268: invokevirtual 783	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   271: ifeq +97 -> 368
    //   274: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq +32 -> 309
    //   280: ldc 140
    //   282: iconst_2
    //   283: new 142	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   290: ldc_w 832
    //   293: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_1
    //   297: getfield 835	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   300: invokevirtual 682	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   303: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: aload_1
    //   310: getfield 835	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   313: istore 5
    //   315: iload 5
    //   317: ifne +14 -> 331
    //   320: getstatic 89	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   323: invokeinterface 338 1 0
    //   328: goto -262 -> 66
    //   331: aload_0
    //   332: getfield 101	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:c	Ljava/util/HashMap;
    //   335: aload_1
    //   336: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   339: invokevirtual 335	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   342: checkcast 613	com/tencent/mobileqq/transfile/predownload/HttpEngineTask
    //   345: astore 6
    //   347: aload 6
    //   349: ifnull +19 -> 368
    //   352: aload_0
    //   353: getfield 131	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController	Lcom/tencent/mobileqq/transfile/predownload/PreDownloadController;
    //   356: aload 6
    //   358: getfield 836	com/tencent/mobileqq/transfile/predownload/HttpEngineTask:jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq	Lcom/tencent/mobileqq/transfile/HttpNetReq;
    //   361: getfield 839	com/tencent/mobileqq/transfile/HttpNetReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   364: invokevirtual 623	com/tencent/mobileqq/transfile/predownload/PreDownloadController:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/transfile/predownload/AbsPreDownloadTask;
    //   367: pop
    //   368: getstatic 89	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   371: invokeinterface 338 1 0
    //   376: aload_1
    //   377: invokestatic 276	android/os/SystemClock:elapsedRealtime	()J
    //   380: putfield 281	com/tencent/mobileqq/earlydownload/xmldata/XmlData:tStart	J
    //   383: aload_1
    //   384: iconst_2
    //   385: putfield 284	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   388: aload_1
    //   389: iconst_0
    //   390: putfield 287	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   393: aload_1
    //   394: iconst_2
    //   395: anewarray 33	java/lang/String
    //   398: dup
    //   399: iconst_0
    //   400: ldc_w 288
    //   403: aastore
    //   404: dup
    //   405: iconst_1
    //   406: ldc_w 289
    //   409: aastore
    //   410: invokestatic 294	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   413: aload_0
    //   414: getfield 108	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   417: iconst_0
    //   418: invokevirtual 630	com/tencent/mobileqq/app/QQAppInterface:getNetEngine	(I)Lcom/tencent/mobileqq/transfile/INetEngine;
    //   421: astore 6
    //   423: new 838	com/tencent/mobileqq/transfile/HttpNetReq
    //   426: dup
    //   427: invokespecial 840	com/tencent/mobileqq/transfile/HttpNetReq:<init>	()V
    //   430: astore 7
    //   432: aload 7
    //   434: aload_0
    //   435: putfield 843	com/tencent/mobileqq/transfile/HttpNetReq:jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener	Lcom/tencent/mobileqq/transfile/INetEngine$INetEngineListener;
    //   438: aload 7
    //   440: aload_0
    //   441: putfield 846	com/tencent/mobileqq/transfile/HttpNetReq:jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix	Lcom/tencent/mobileqq/transfile/INetEngine$IBreakDownFix;
    //   444: aload 7
    //   446: aload_1
    //   447: getfield 606	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResURL_big	Ljava/lang/String;
    //   450: putfield 839	com/tencent/mobileqq/transfile/HttpNetReq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   453: aload 7
    //   455: iconst_1
    //   456: putfield 847	com/tencent/mobileqq/transfile/HttpNetReq:jdField_a_of_type_Boolean	Z
    //   459: aload 7
    //   461: iconst_0
    //   462: putfield 848	com/tencent/mobileqq/transfile/HttpNetReq:jdField_a_of_type_Int	I
    //   465: aload 7
    //   467: aload_1
    //   468: invokevirtual 851	com/tencent/mobileqq/transfile/HttpNetReq:a	(Ljava/lang/Object;)V
    //   471: aload 7
    //   473: aload_2
    //   474: putfield 852	com/tencent/mobileqq/transfile/HttpNetReq:c	Ljava/lang/String;
    //   477: aload 7
    //   479: iconst_1
    //   480: putfield 855	com/tencent/mobileqq/transfile/HttpNetReq:m	Z
    //   483: aload 7
    //   485: iconst_1
    //   486: putfield 858	com/tencent/mobileqq/transfile/HttpNetReq:n	Z
    //   489: aload_1
    //   490: getfield 835	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   493: ifne +13 -> 506
    //   496: aload_0
    //   497: getfield 131	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController	Lcom/tencent/mobileqq/transfile/predownload/PreDownloadController;
    //   500: invokevirtual 860	com/tencent/mobileqq/transfile/predownload/PreDownloadController:a	()Z
    //   503: ifne +47 -> 550
    //   506: aload_1
    //   507: getfield 835	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   510: ifeq +190 -> 700
    //   513: aload 7
    //   515: iload_3
    //   516: putfield 862	com/tencent/mobileqq/transfile/HttpNetReq:e	I
    //   519: aload_0
    //   520: aload_1
    //   521: aload 7
    //   523: aconst_null
    //   524: invokespecial 864	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;Lcom/tencent/mobileqq/transfile/HttpNetReq;Lcom/tencent/mobileqq/transfile/predownload/AbsPreDownloadTask;)V
    //   527: aload 6
    //   529: aload 7
    //   531: invokeinterface 866 2 0
    //   536: goto -470 -> 66
    //   539: astore_1
    //   540: getstatic 89	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   543: invokeinterface 338 1 0
    //   548: aload_1
    //   549: athrow
    //   550: aload 7
    //   552: iconst_2
    //   553: putfield 862	com/tencent/mobileqq/transfile/HttpNetReq:e	I
    //   556: getstatic 89	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   559: invokeinterface 313 1 0
    //   564: new 613	com/tencent/mobileqq/transfile/predownload/HttpEngineTask
    //   567: dup
    //   568: aload_0
    //   569: getfield 108	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   572: aload_1
    //   573: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   576: aload_0
    //   577: aload 7
    //   579: invokespecial 869	com/tencent/mobileqq/transfile/predownload/HttpEngineTask:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/predownload/HttpEngineTask$IHttpEngineTask;Lcom/tencent/mobileqq/transfile/HttpNetReq;)V
    //   582: astore_2
    //   583: aload_1
    //   584: getfield 872	com/tencent/mobileqq/earlydownload/xmldata/XmlData:load2G	Z
    //   587: ifeq +81 -> 668
    //   590: iload 4
    //   592: istore_3
    //   593: aload_0
    //   594: aload_1
    //   595: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   598: invokevirtual 300	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/earlydownload/handler/EarlyHandler;
    //   601: astore 6
    //   603: aload 6
    //   605: ifnull +52 -> 657
    //   608: aload_0
    //   609: getfield 131	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController	Lcom/tencent/mobileqq/transfile/predownload/PreDownloadController;
    //   612: aload 6
    //   614: invokevirtual 874	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	()I
    //   617: aload 6
    //   619: invokevirtual 876	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:b	()Ljava/lang/String;
    //   622: aload_1
    //   623: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   626: iconst_0
    //   627: aload_1
    //   628: getfield 606	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResURL_big	Ljava/lang/String;
    //   631: aload 6
    //   633: invokevirtual 878	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:c	()Ljava/lang/String;
    //   636: iload_3
    //   637: iconst_0
    //   638: iconst_0
    //   639: aload_2
    //   640: invokevirtual 881	com/tencent/mobileqq/transfile/predownload/PreDownloadController:a	(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIZLcom/tencent/mobileqq/transfile/predownload/AbsPreDownloadTask;)Z
    //   643: pop
    //   644: aload_0
    //   645: getfield 101	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:c	Ljava/util/HashMap;
    //   648: aload_1
    //   649: getfield 327	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   652: aload_2
    //   653: invokevirtual 331	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   656: pop
    //   657: getstatic 89	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   660: invokeinterface 338 1 0
    //   665: goto -599 -> 66
    //   668: aload_1
    //   669: getfield 884	com/tencent/mobileqq/earlydownload/xmldata/XmlData:load3G	Z
    //   672: istore 5
    //   674: iload 5
    //   676: ifeq +8 -> 684
    //   679: iconst_3
    //   680: istore_3
    //   681: goto -88 -> 593
    //   684: iconst_1
    //   685: istore_3
    //   686: goto -93 -> 593
    //   689: astore_1
    //   690: getstatic 89	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   693: invokeinterface 338 1 0
    //   698: aload_1
    //   699: athrow
    //   700: iconst_2
    //   701: istore_3
    //   702: goto -189 -> 513
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	705	0	this	EarlyDownloadManager
    //   0	705	1	paramXmlData	XmlData
    //   0	705	2	paramString	String
    //   1	701	3	i	int
    //   3	588	4	j	int
    //   313	362	5	bool	boolean
    //   41	591	6	localObject	Object
    //   430	148	7	localHttpNetReq	HttpNetReq
    // Exception table:
    //   from	to	target	type
    //   15	22	255	finally
    //   22	43	255	finally
    //   51	66	255	finally
    //   69	90	255	finally
    //   93	151	255	finally
    //   151	169	255	finally
    //   244	252	255	finally
    //   320	328	255	finally
    //   368	506	255	finally
    //   506	513	255	finally
    //   513	536	255	finally
    //   540	550	255	finally
    //   550	564	255	finally
    //   657	665	255	finally
    //   690	700	255	finally
    //   169	209	539	finally
    //   209	244	539	finally
    //   260	309	539	finally
    //   309	315	539	finally
    //   331	347	539	finally
    //   352	368	539	finally
    //   564	590	689	finally
    //   593	603	689	finally
    //   608	657	689	finally
    //   668	674	689	finally
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (XmlData)paramNetReq.a();
    if (paramNetReq != null)
    {
      paramNetReq.totalSize = paramLong2;
      paramNetReq.downSize = paramLong1;
      paramNetReq = a(paramNetReq.strResName);
      if (paramNetReq != null) {
        paramNetReq.a(paramLong1, paramLong2);
      }
    }
  }
  
  public void a(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    StringBuffer localStringBuffer;
    do
    {
      do
      {
        return;
      } while (!(paramNetReq instanceof HttpNetReq));
      HttpNetReq localHttpNetReq = (HttpNetReq)paramNetReq;
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(".start=" + localHttpNetReq.jdField_a_of_type_Long + ".written=" + paramNetResp.c);
      localHttpNetReq.jdField_a_of_type_Long += paramNetResp.c;
      paramNetResp.c = 0L;
      paramNetResp = "bytes=" + localHttpNetReq.jdField_a_of_type_Long + "-";
      localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", paramNetResp);
      localStringBuffer.append(".range=");
      localStringBuffer.append(paramNetResp);
    } while (!(paramNetReq.a() instanceof XmlData));
    ((XmlData)paramNetReq.a()).strLog = localStringBuffer.toString();
  }
  
  public void a(NetResp paramNetResp)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(131328, paramNetResp).sendToTarget();
    }
  }
  
  public void a(HttpEngineTask paramHttpEngineTask)
  {
    a((XmlData)paramHttpEngineTask.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.a(), paramHttpEngineTask.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq, paramHttpEngineTask);
  }
  
  public void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashSet)
    {
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(paramString)) {
        this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
      }
      return;
    }
  }
  
  public void a(GetResourceRespInfo paramGetResourceRespInfo)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("onServerResp() PkgName = ");
      if (paramGetResourceRespInfo == null) {
        break label117;
      }
    }
    label117:
    for (Object localObject1 = paramGetResourceRespInfo.strPkgName;; localObject1 = "[respInfo is null]")
    {
      QLog.d("EarlyDown", 2, (String)localObject1);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "onServerResp() afterAppStart=true");
        }
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        localObject2 = Message.obtain();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Message();
        }
        ((Message)localObject1).what = 131332;
        ((Message)localObject1).obj = paramGetResourceRespInfo;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
      }
      return;
    }
  }
  
  public boolean a()
  {
    return (DeviceInfoUtil.e()) || (FileUtils.a() <= 1.048576E+008F);
  }
  
  public boolean a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashSet)
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashSet.contains(paramString);
      return bool;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Long > 0L)
    {
      long l = this.jdField_a_of_type_Long;
      if (7200000 + l > SystemClock.elapsedRealtime())
      {
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "updateConfigs() timeUpdateSuccess + delay(" + 120 + "min) > now. return.");
        }
        return;
      }
    }
    ReqUserInfo localReqUserInfo = new ReqUserInfo();
    localReqUserInfo.cType = 1;
    localReqUserInfo.stGps = new GPS();
    localReqUserInfo.strAuthName = "B1_QQ_Neighbor_android";
    localReqUserInfo.strAuthPassword = "NzVK_qGE";
    localReqUserInfo.vCells = new ArrayList();
    localReqUserInfo.vMacs = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      GetResourceReqInfoV2 localGetResourceReqInfoV2 = null;
      localObject = a((String)localObject);
      if (localObject != null) {
        localGetResourceReqInfoV2 = ((EarlyHandler)localObject).a();
      }
      if (localGetResourceReqInfoV2 != null) {
        localArrayList.add(localGetResourceReqInfoV2);
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "getPluginList: 128 reqInfoV2s.len=" + localArrayList.size());
    }
    ((ServerConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(4)).getPluginConfig(512, localReqUserInfo, localArrayList, this, AppSetting.jdField_a_of_type_Int);
  }
  
  public void b(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashSet)
    {
      if (this.jdField_a_of_type_JavaUtilHashSet.contains(paramString)) {
        this.jdField_a_of_type_JavaUtilHashSet.remove(paramString);
      }
      return;
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "removeHandler() strResName=" + paramString);
    }
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
      try
      {
        paramString = (EarlyHandler)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (paramString == null) {
          continue;
        }
        paramString.b();
        return;
      }
      finally
      {
        jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "EarlyDownloadManager handleMessage,msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    }
    label267:
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              b((NetResp)paramMessage.obj);
              return false;
              b((XmlData)paramMessage.obj);
              return false;
              b();
              return false;
              localObject = null;
              if (paramMessage.obj != null) {
                localObject = (GetResourceRespV2)paramMessage.obj;
              }
              a((GetResourceRespV2)localObject);
              return false;
              if (!(paramMessage.obj instanceof GetResourceRespInfo)) {
                break label267;
              }
              paramMessage = (GetResourceRespInfo)paramMessage.obj;
              if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "ACTION_ON_SERVER_RESP doOnServerResp() GetResourceRespInfo = " + paramMessage.strPkgName + ",resp.iResult = " + paramMessage.iResult);
              }
              if (paramMessage.iResult != 0) {
                break;
              }
              localObject = a(paramMessage.strResName);
            } while (localObject == null);
            ((EarlyHandler)localObject).a(EarlyDataFactory.a(((EarlyHandler)localObject).a(), paramMessage.strResName, paramMessage.strPkgName, paramMessage.strResConf, paramMessage.uiNewVer, paramMessage.strResURL_big, paramMessage.strResURL_small));
            return false;
            b(paramMessage.strResName);
            return false;
          } while (!(paramMessage.obj instanceof Object[]));
          localObject = (Object[])paramMessage.obj;
        } while ((localObject.length != 2) || (!(localObject[0] instanceof String)) || (!(localObject[1] instanceof XmlData)));
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "ACTION_ON_SERVER_RESP object[] ");
        }
        paramMessage = (String)localObject[0];
        localObject = (XmlData)localObject[1];
        paramMessage = a(paramMessage);
      } while (paramMessage == null);
      paramMessage.a((XmlData)localObject);
      return false;
    } while (!(paramMessage.obj instanceof Intent));
    b((Intent)paramMessage.obj);
    return false;
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_JavaLangString = null;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = arrayOfString[i];
      localObject2 = (EarlyHandler)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
      if (localObject2 != null) {
        ((EarlyHandler)localObject2).b();
      }
      i += 1;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
    jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
    finally
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void onGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuffer();
      ((StringBuffer)localObject1).append("onGetPluginConfig() isSucc=" + paramBoolean + " iPluginType=" + paramInt);
      if (paramGetResourceRespV2 != null)
      {
        ((StringBuffer)localObject1).append(" result=" + paramGetResourceRespV2.result);
        ((StringBuffer)localObject1).append(" uin=" + paramGetResourceRespV2.uin);
        localObject2 = new StringBuilder().append(" add=");
        if (paramGetResourceRespV2.vecAddedResInfo != null)
        {
          i = paramGetResourceRespV2.vecAddedResInfo.size();
          ((StringBuffer)localObject1).append(i);
          localObject2 = new StringBuilder().append(" update=");
          if (paramGetResourceRespV2.vecUpdatedResInfo == null) {
            break label319;
          }
          i = paramGetResourceRespV2.vecUpdatedResInfo.size();
          label191:
          ((StringBuffer)localObject1).append(i);
          localObject2 = new StringBuilder().append(" delete=");
          if (paramGetResourceRespV2.vecDeletedResInfo == null) {
            break label325;
          }
          i = paramGetResourceRespV2.vecDeletedResInfo.size();
          label238:
          ((StringBuffer)localObject1).append(i);
        }
      }
      else
      {
        QLog.d("EarlyDown", 2, ((StringBuffer)localObject1).toString());
        ((StringBuffer)localObject1).setLength(0);
        if ((!this.jdField_a_of_type_Boolean) && (paramInt == 512)) {
          ((StringBuffer)localObject1).append("set afterAppStart=true");
        }
        QLog.d("EarlyDown", 2, ((StringBuffer)localObject1).toString());
      }
    }
    else
    {
      if (paramInt == 512) {
        break label331;
      }
    }
    label319:
    label325:
    label331:
    do
    {
      do
      {
        return;
        i = 0;
        break;
        i = 0;
        break label191;
        i = 0;
        break label238;
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
        this.jdField_a_of_type_Boolean = true;
      } while ((!paramBoolean) || (paramGetResourceRespV2 == null));
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    } while (this.jdField_a_of_type_AndroidOsHandler == null);
    Object localObject2 = Message.obtain();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Message();
    }
    ((Message)localObject1).what = 131331;
    ((Message)localObject1).obj = paramGetResourceRespV2;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.EarlyDownloadManager
 * JD-Core Version:    0.7.0.1
 */