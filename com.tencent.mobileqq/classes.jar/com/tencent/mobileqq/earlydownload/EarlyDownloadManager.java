package com.tencent.mobileqq.earlydownload;

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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.handler.AppleEmojiHandler;
import com.tencent.mobileqq.earlydownload.handler.ArNativeSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.ChirpSoHandler;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.handler.FaceModelsDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.FaceScanNativeSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.HotFriendResHandler;
import com.tencent.mobileqq.earlydownload.handler.JpegSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.MiniScanDecodeSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.MiniScanDetectModelsDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.MiniScanDetectSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.earlydownload.handler.PrecoverHandler;
import com.tencent.mobileqq.earlydownload.handler.PttSilkAndChangeVoiceSoHandler;
import com.tencent.mobileqq.earlydownload.handler.PttTransitionAnimHandler;
import com.tencent.mobileqq.earlydownload.handler.QQDingdongSoundHandler;
import com.tencent.mobileqq.earlydownload.handler.QavGAudioSoundHandler;
import com.tencent.mobileqq.earlydownload.handler.QavImageHandler;
import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.QavVideoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.SystemFaceHandler;
import com.tencent.mobileqq.earlydownload.handler.ViolaBizLibHandler;
import com.tencent.mobileqq.earlydownload.handler.ViolaLibHandler;
import com.tencent.mobileqq.earlydownload.handler.WebpSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterAppData;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterEngineData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
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
  implements Handler.Callback, INetEngineListener, HttpEngineTask.IHttpEngineTask, Manager
{
  public static int a;
  private static String jdField_a_of_type_JavaLangString;
  public static final Lock a;
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "qq.android.appleemoji", "qq.android.system.face.gifv14", "qq.android.ar.native.so_v8.3.6", "qq.android.qav.so_665", "qq.android.qav.image2", "qq.android.qav.muteaudio", "qq.android.pic.jpeg.so_v7_820", "qq.android.pic.jpeg.so_v8_820", "qq.android.pic.webp.so", "qq.android.qav.video", "qq.android.ptt.so.658", "qq.android.system.chirp", "qq.android.dingdong.ring", "qq.android.early.precover", "qq.android.hotfriend.res", "qq.android.poke.res_0625", "qq.android.ar.face.so_v8.5.2_32", "qq.android.ar.face.models_v8.2.0", "android.qq.readinjoy.viola_795", "android.qq.readinjoy.viola_biz_810", "qq.android.minidecode.so_v8.2.0", "qq.android.minidetect.so_v8.2.0", "qq.android.minidetect.model_v8.2.0", "qq.android.flutter.engine.v8.5.5_v2", "qq.android.flutter.app.v8.5.5_v2", "ptt.transition.anim.res.zip" };
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PreDownloadController jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController;
  public Boolean a;
  private HashMap<String, EarlyHandler> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public final HashSet<String> a;
  private boolean jdField_a_of_type_Boolean = false;
  private HashMap<String, EarlyDownloadManager.DownloadRecord> b = new HashMap();
  private HashMap<String, HttpEngineTask> c = new HashMap();
  
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
    this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController = ((PreDownloadController)paramQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2));
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
      if ("qq.android.system.face.gifv14".equals(paramString)) {
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
      if (JpegSoDownloadHandler.e().equals(paramString)) {
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
      if ("qq.android.ar.native.so_v8.3.6".equals(paramString)) {
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
      if ("qq.android.poke.res_0625".equals(paramString)) {
        return new PokeResHandler(paramQQAppInterface);
      }
      if ("qq.android.ar.face.so_v8.5.2_32".equals(paramString)) {
        return new FaceScanNativeSoDownloadHandler(paramQQAppInterface);
      }
      if ("qq.android.ar.face.models_v8.2.0".equals(paramString)) {
        return new FaceModelsDownloadHandler(paramQQAppInterface);
      }
      if ("android.qq.readinjoy.viola_795".equals(paramString)) {
        return new ViolaLibHandler(paramQQAppInterface);
      }
      if ("android.qq.readinjoy.viola_biz_810".equals(paramString)) {
        return new ViolaBizLibHandler(paramQQAppInterface);
      }
      if ("qq.android.minidecode.so_v8.2.0".equals(paramString)) {
        return new MiniScanDecodeSoDownloadHandler(paramQQAppInterface);
      }
      if ("qq.android.minidetect.so_v8.2.0".equals(paramString)) {
        return new MiniScanDetectSoDownloadHandler(paramQQAppInterface);
      }
      if ("qq.android.minidetect.model_v8.2.0".equals(paramString)) {
        return new MiniScanDetectModelsDownloadHandler(paramQQAppInterface);
      }
      if ("qq.android.flutter.engine.v8.5.5_v2".equals(paramString)) {
        return QFlutterEngineData.createDownloader(paramQQAppInterface);
      }
      if ("qq.android.flutter.app.v8.5.5_v2".equals(paramString)) {
        return QFlutterAppData.createDownloader(paramQQAppInterface);
      }
      if ("ptt.transition.anim.res.zip".equals(paramString)) {
        return new PttTransitionAnimHandler(paramQQAppInterface);
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
        break label70;
      }
    }
    label70:
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
      localObject = new EarlyDownloadManager.DownloadRecord(null);
      ((EarlyDownloadManager.DownloadRecord)localObject).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = paramHttpNetReq;
      ((EarlyDownloadManager.DownloadRecord)localObject).jdField_a_of_type_ComTencentMobileqqTransfilePredownloadAbsPreDownloadTask = paramAbsPreDownloadTask;
      this.b.put(paramXmlData.strResName, localObject);
      this.c.remove(paramXmlData.strResName);
      return;
    }
    finally
    {
      jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  /* Error */
  private void a(NetResp paramNetResp)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 380	com/tencent/mobileqq/transfile/NetResp:mReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   4: invokevirtual 386	com/tencent/mobileqq/transfile/NetReq:getUserData	()Ljava/lang/Object;
    //   7: checkcast 311	com/tencent/mobileqq/earlydownload/xmldata/XmlData
    //   10: astore 15
    //   12: aload 15
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: aload_1
    //   19: getfield 389	com/tencent/mobileqq/transfile/NetResp:mResult	I
    //   22: iconst_3
    //   23: if_icmpne +46 -> 69
    //   26: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq -12 -> 17
    //   32: ldc 157
    //   34: iconst_2
    //   35: new 159	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 391
    //   45: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload 15
    //   50: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   53: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 393
    //   59: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: return
    //   69: aload_1
    //   70: getfield 389	com/tencent/mobileqq/transfile/NetResp:mResult	I
    //   73: ifne +338 -> 411
    //   76: iconst_1
    //   77: istore_3
    //   78: invokestatic 309	android/os/SystemClock:elapsedRealtime	()J
    //   81: lstore 9
    //   83: aload 15
    //   85: getfield 314	com/tencent/mobileqq/earlydownload/xmldata/XmlData:tStart	J
    //   88: lstore 11
    //   90: lconst_0
    //   91: lstore 5
    //   93: new 395	java/io/File
    //   96: dup
    //   97: aload_1
    //   98: getfield 380	com/tencent/mobileqq/transfile/NetResp:mReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   101: getfield 398	com/tencent/mobileqq/transfile/NetReq:mOutPath	Ljava/lang/String;
    //   104: invokespecial 401	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: invokevirtual 403	java/io/File:length	()J
    //   110: lstore 7
    //   112: lload 7
    //   114: lstore 5
    //   116: getstatic 99	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   119: invokeinterface 346 1 0
    //   124: aload_0
    //   125: getfield 111	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:b	Ljava/util/HashMap;
    //   128: aload 15
    //   130: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   133: invokevirtual 368	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   136: checkcast 348	com/tencent/mobileqq/earlydownload/EarlyDownloadManager$DownloadRecord
    //   139: astore 13
    //   141: aload 13
    //   143: ifnull +273 -> 416
    //   146: aload 13
    //   148: getfield 354	com/tencent/mobileqq/earlydownload/EarlyDownloadManager$DownloadRecord:jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq	Lcom/tencent/mobileqq/transfile/HttpNetReq;
    //   151: astore 13
    //   153: getstatic 99	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   156: invokeinterface 371 1 0
    //   161: iload_3
    //   162: ifeq +1085 -> 1247
    //   165: aload_0
    //   166: aload 15
    //   168: aload_1
    //   169: getfield 380	com/tencent/mobileqq/transfile/NetResp:mReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   172: getfield 398	com/tencent/mobileqq/transfile/NetReq:mOutPath	Ljava/lang/String;
    //   175: invokespecial 406	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;Ljava/lang/String;)Z
    //   178: istore 4
    //   180: iload 4
    //   182: ifne +68 -> 250
    //   185: aload_1
    //   186: ldc_w 407
    //   189: putfield 410	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   192: aload_1
    //   193: new 159	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   200: ldc_w 412
    //   203: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: lload 5
    //   208: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   211: aload 15
    //   213: getfield 418	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strLog	Ljava/lang/String;
    //   216: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: putfield 421	com/tencent/mobileqq/transfile/NetResp:mErrDesc	Ljava/lang/String;
    //   225: aload 15
    //   227: ldc_w 294
    //   230: putfield 418	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strLog	Ljava/lang/String;
    //   233: aload 15
    //   235: iconst_0
    //   236: putfield 320	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   239: aload_1
    //   240: getfield 380	com/tencent/mobileqq/transfile/NetResp:mReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   243: getfield 398	com/tencent/mobileqq/transfile/NetReq:mOutPath	Ljava/lang/String;
    //   246: invokestatic 426	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   249: pop
    //   250: iload 4
    //   252: istore_3
    //   253: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   256: ifeq +47 -> 303
    //   259: ldc 157
    //   261: iconst_2
    //   262: new 159	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 428
    //   272: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: iload 4
    //   277: invokevirtual 431	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   280: ldc_w 433
    //   283: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload 15
    //   288: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   291: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: iload 4
    //   302: istore_3
    //   303: aload 15
    //   305: getfield 336	com/tencent/mobileqq/earlydownload/xmldata/XmlData:reqLoadCount	I
    //   308: istore_2
    //   309: aload_1
    //   310: getfield 410	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   313: ldc_w 407
    //   316: if_icmpeq +13 -> 329
    //   319: aload_1
    //   320: getfield 410	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   323: sipush -9527
    //   326: if_icmpne +107 -> 433
    //   329: iload_2
    //   330: iconst_3
    //   331: if_icmpge +102 -> 433
    //   334: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +60 -> 397
    //   340: ldc 157
    //   342: iconst_2
    //   343: new 159	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   350: ldc_w 435
    //   353: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload 15
    //   358: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   361: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc_w 437
    //   367: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload 15
    //   372: getfield 336	com/tencent/mobileqq/earlydownload/xmldata/XmlData:reqLoadCount	I
    //   375: invokevirtual 440	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   378: ldc_w 442
    //   381: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload_1
    //   385: getfield 410	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   388: invokevirtual 440	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   391: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: aload_0
    //   398: aload 15
    //   400: aload_1
    //   401: getfield 380	com/tencent/mobileqq/transfile/NetResp:mReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   404: getfield 398	com/tencent/mobileqq/transfile/NetReq:mOutPath	Ljava/lang/String;
    //   407: invokevirtual 445	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;Ljava/lang/String;)V
    //   410: return
    //   411: iconst_0
    //   412: istore_3
    //   413: goto -335 -> 78
    //   416: aconst_null
    //   417: astore 13
    //   419: goto -266 -> 153
    //   422: astore_1
    //   423: getstatic 99	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   426: invokeinterface 371 1 0
    //   431: aload_1
    //   432: athrow
    //   433: aload 15
    //   435: iconst_0
    //   436: putfield 336	com/tencent/mobileqq/earlydownload/xmldata/XmlData:reqLoadCount	I
    //   439: aload_0
    //   440: aload 15
    //   442: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   445: invokevirtual 333	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/earlydownload/handler/EarlyHandler;
    //   448: astore 16
    //   450: iload_3
    //   451: ifeq +605 -> 1056
    //   454: aload 15
    //   456: lconst_0
    //   457: putfield 448	com/tencent/mobileqq/earlydownload/xmldata/XmlData:tLoadFail	J
    //   460: aload 15
    //   462: iconst_1
    //   463: putfield 317	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   466: aload 15
    //   468: iconst_1
    //   469: putfield 320	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   472: aconst_null
    //   473: astore 14
    //   475: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq +50 -> 528
    //   481: new 450	java/lang/StringBuffer
    //   484: dup
    //   485: new 159	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   492: ldc_w 452
    //   495: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload 15
    //   500: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   503: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: ldc_w 454
    //   509: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 15
    //   514: getfield 457	com/tencent/mobileqq/earlydownload/xmldata/XmlData:StoreBackup	Z
    //   517: invokevirtual 431	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   520: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokespecial 458	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   526: astore 14
    //   528: aload 15
    //   530: getfield 457	com/tencent/mobileqq/earlydownload/xmldata/XmlData:StoreBackup	Z
    //   533: ifeq +94 -> 627
    //   536: aload 16
    //   538: ifnull +89 -> 627
    //   541: aload 16
    //   543: invokevirtual 460	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:d	()Ljava/lang/String;
    //   546: astore 17
    //   548: aload_1
    //   549: getfield 380	com/tencent/mobileqq/transfile/NetResp:mReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   552: getfield 398	com/tencent/mobileqq/transfile/NetReq:mOutPath	Ljava/lang/String;
    //   555: aload 17
    //   557: invokestatic 463	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;Ljava/lang/String;)Z
    //   560: istore 4
    //   562: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   565: ifeq +62 -> 627
    //   568: aload 14
    //   570: ifnull +57 -> 627
    //   573: aload 14
    //   575: new 159	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   582: ldc_w 465
    //   585: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: iload 4
    //   590: invokevirtual 431	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   593: ldc_w 467
    //   596: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: aload_1
    //   600: getfield 380	com/tencent/mobileqq/transfile/NetResp:mReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   603: getfield 398	com/tencent/mobileqq/transfile/NetReq:mOutPath	Ljava/lang/String;
    //   606: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: ldc_w 469
    //   612: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: aload 17
    //   617: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   623: invokevirtual 472	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   626: pop
    //   627: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   630: ifeq +19 -> 649
    //   633: aload 14
    //   635: ifnull +14 -> 649
    //   638: ldc 157
    //   640: iconst_2
    //   641: aload 14
    //   643: invokevirtual 473	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   646: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   649: aload 15
    //   651: iconst_4
    //   652: anewarray 35	java/lang/String
    //   655: dup
    //   656: iconst_0
    //   657: ldc_w 475
    //   660: aastore
    //   661: dup
    //   662: iconst_1
    //   663: ldc_w 321
    //   666: aastore
    //   667: dup
    //   668: iconst_2
    //   669: ldc_w 476
    //   672: aastore
    //   673: dup
    //   674: iconst_3
    //   675: ldc_w 322
    //   678: aastore
    //   679: invokestatic 327	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   682: aload_0
    //   683: aload 15
    //   685: invokevirtual 330	com/tencent/mobileqq/earlydownload/xmldata/XmlData:getStrResName	()Ljava/lang/String;
    //   688: invokevirtual 478	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:b	(Ljava/lang/String;)V
    //   691: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   694: ifeq +70 -> 764
    //   697: ldc 157
    //   699: iconst_2
    //   700: new 159	java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   707: ldc_w 480
    //   710: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: iload_3
    //   714: invokevirtual 431	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   717: ldc_w 482
    //   720: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: aload_1
    //   724: getfield 410	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   727: invokevirtual 440	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   730: ldc_w 484
    //   733: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: aload 15
    //   738: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   741: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: ldc_w 486
    //   747: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: aload 15
    //   752: getfield 489	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResURL_big	Ljava/lang/String;
    //   755: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   764: aload 13
    //   766: ifnull +423 -> 1189
    //   769: aload 16
    //   771: ifnull +27 -> 798
    //   774: aload 16
    //   776: aload 15
    //   778: iload_3
    //   779: aload_1
    //   780: getfield 410	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   783: aload_1
    //   784: getfield 380	com/tencent/mobileqq/transfile/NetResp:mReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   787: getfield 398	com/tencent/mobileqq/transfile/NetReq:mOutPath	Ljava/lang/String;
    //   790: invokevirtual 492	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;ZILjava/lang/String;)V
    //   793: aload 16
    //   795: invokevirtual 494	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:d	()V
    //   798: aload_1
    //   799: getfield 410	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   802: sipush 9366
    //   805: if_icmpeq -788 -> 17
    //   808: aload_1
    //   809: getfield 410	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   812: sipush 9037
    //   815: if_icmpeq -798 -> 17
    //   818: aload_1
    //   819: getfield 410	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   822: sipush 9004
    //   825: if_icmpeq -808 -> 17
    //   828: aload_1
    //   829: getfield 410	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   832: sipush 9040
    //   835: if_icmpeq -818 -> 17
    //   838: new 106	java/util/HashMap
    //   841: dup
    //   842: invokespecial 107	java/util/HashMap:<init>	()V
    //   845: astore 13
    //   847: aload 13
    //   849: ldc_w 496
    //   852: aload_1
    //   853: getfield 410	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   856: invokestatic 501	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   859: invokevirtual 364	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   862: pop
    //   863: aload 13
    //   865: ldc_w 503
    //   868: aload 15
    //   870: getfield 506	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strPkgName	Ljava/lang/String;
    //   873: invokevirtual 364	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   876: pop
    //   877: aload 13
    //   879: ldc_w 508
    //   882: iload_2
    //   883: invokestatic 501	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   886: invokevirtual 364	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   889: pop
    //   890: iload_3
    //   891: ifne +108 -> 999
    //   894: aload_1
    //   895: getfield 511	com/tencent/mobileqq/transfile/NetResp:mRespProperties	Ljava/util/HashMap;
    //   898: ifnull +42 -> 940
    //   901: aload_1
    //   902: getfield 511	com/tencent/mobileqq/transfile/NetResp:mRespProperties	Ljava/util/HashMap;
    //   905: ldc_w 513
    //   908: invokevirtual 516	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   911: checkcast 35	java/lang/String
    //   914: astore 14
    //   916: aload 14
    //   918: ifnull +22 -> 940
    //   921: aload 14
    //   923: invokevirtual 178	java/lang/String:length	()I
    //   926: ifle +14 -> 940
    //   929: aload 13
    //   931: ldc_w 518
    //   934: aload 14
    //   936: invokevirtual 364	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   939: pop
    //   940: aload_1
    //   941: getfield 421	com/tencent/mobileqq/transfile/NetResp:mErrDesc	Ljava/lang/String;
    //   944: ifnull +55 -> 999
    //   947: aload_1
    //   948: getfield 421	com/tencent/mobileqq/transfile/NetResp:mErrDesc	Ljava/lang/String;
    //   951: invokevirtual 178	java/lang/String:length	()I
    //   954: ifle +45 -> 999
    //   957: aload 13
    //   959: ldc_w 520
    //   962: new 159	java/lang/StringBuilder
    //   965: dup
    //   966: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   969: aload_1
    //   970: getfield 421	com/tencent/mobileqq/transfile/NetResp:mErrDesc	Ljava/lang/String;
    //   973: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: aload 15
    //   978: getfield 418	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strLog	Ljava/lang/String;
    //   981: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokevirtual 364	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   990: pop
    //   991: aload 15
    //   993: ldc_w 294
    //   996: putfield 418	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strLog	Ljava/lang/String;
    //   999: aload 16
    //   1001: ifnull -984 -> 17
    //   1004: aload 16
    //   1006: invokevirtual 522	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	()Ljava/lang/String;
    //   1009: astore_1
    //   1010: aload_1
    //   1011: ifnull -994 -> 17
    //   1014: aload_1
    //   1015: invokevirtual 178	java/lang/String:length	()I
    //   1018: ifle -1001 -> 17
    //   1021: invokestatic 277	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1024: invokestatic 528	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1027: aload_0
    //   1028: getfield 120	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1031: invokevirtual 531	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1034: aload 16
    //   1036: invokevirtual 522	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	()Ljava/lang/String;
    //   1039: iload_3
    //   1040: lload 9
    //   1042: lload 11
    //   1044: lsub
    //   1045: lload 5
    //   1047: aload 13
    //   1049: ldc_w 294
    //   1052: invokevirtual 535	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1055: return
    //   1056: aload_1
    //   1057: getfield 410	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   1060: sipush 9366
    //   1063: if_icmpeq +51 -> 1114
    //   1066: aload_1
    //   1067: getfield 410	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   1070: sipush 9369
    //   1073: if_icmpeq +41 -> 1114
    //   1076: aload_1
    //   1077: getfield 410	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   1080: sipush 9367
    //   1083: if_icmpeq +31 -> 1114
    //   1086: aload_1
    //   1087: getfield 410	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   1090: sipush 9037
    //   1093: if_icmpeq +21 -> 1114
    //   1096: aload_1
    //   1097: getfield 410	com/tencent/mobileqq/transfile/NetResp:mErrCode	I
    //   1100: sipush 9004
    //   1103: if_icmpeq +11 -> 1114
    //   1106: aload 15
    //   1108: invokestatic 540	java/lang/System:currentTimeMillis	()J
    //   1111: putfield 448	com/tencent/mobileqq/earlydownload/xmldata/XmlData:tLoadFail	J
    //   1114: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1117: ifeq +47 -> 1164
    //   1120: ldc 157
    //   1122: iconst_2
    //   1123: new 159	java/lang/StringBuilder
    //   1126: dup
    //   1127: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   1130: ldc_w 542
    //   1133: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: aload 15
    //   1138: getfield 448	com/tencent/mobileqq/earlydownload/xmldata/XmlData:tLoadFail	J
    //   1141: invokevirtual 415	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1144: ldc_w 544
    //   1147: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: aload 15
    //   1152: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   1155: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1158: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1161: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1164: aload 16
    //   1166: ifnull +9 -> 1175
    //   1169: aload 16
    //   1171: iconst_1
    //   1172: invokevirtual 547	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:c	(Z)V
    //   1175: aload_1
    //   1176: getfield 380	com/tencent/mobileqq/transfile/NetResp:mReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   1179: getfield 398	com/tencent/mobileqq/transfile/NetReq:mOutPath	Ljava/lang/String;
    //   1182: invokestatic 426	com/tencent/mobileqq/utils/FileUtils:e	(Ljava/lang/String;)Z
    //   1185: pop
    //   1186: goto -537 -> 649
    //   1189: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1192: ifeq -1175 -> 17
    //   1195: ldc 157
    //   1197: iconst_2
    //   1198: new 159	java/lang/StringBuilder
    //   1201: dup
    //   1202: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   1205: ldc_w 391
    //   1208: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: aload 15
    //   1213: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   1216: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: ldc_w 549
    //   1222: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1228: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1231: return
    //   1232: astore 17
    //   1234: goto -607 -> 627
    //   1237: astore 14
    //   1239: goto -989 -> 250
    //   1242: astore 13
    //   1244: goto -1128 -> 116
    //   1247: goto -944 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1250	0	this	EarlyDownloadManager
    //   0	1250	1	paramNetResp	NetResp
    //   308	575	2	i	int
    //   77	963	3	bool1	boolean
    //   178	411	4	bool2	boolean
    //   91	955	5	l1	long
    //   110	3	7	l2	long
    //   81	960	9	l3	long
    //   88	955	11	l4	long
    //   139	909	13	localObject1	Object
    //   1242	1	13	localException1	Exception
    //   473	462	14	localObject2	Object
    //   1237	1	14	localException2	Exception
    //   10	1202	15	localXmlData	XmlData
    //   448	722	16	localEarlyHandler	EarlyHandler
    //   546	70	17	str	String
    //   1232	1	17	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   124	141	422	finally
    //   146	153	422	finally
    //   541	568	1232	java/lang/Exception
    //   573	627	1232	java/lang/Exception
    //   239	250	1237	java/lang/Exception
    //   93	112	1242	java/lang/Exception
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
            localObject3 = ((GetResourceRespInfoV2)localObject2).strResName;
            localObject4 = (EarlyHandler)this.jdField_a_of_type_JavaUtilHashMap.get(localObject3);
            if (localObject4 != null) {
              ((EarlyHandler)localObject4).e();
            }
            c((String)localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("EarlyDown", 2, "doOnGetConfig() removeRes, strPkgName=" + ((GetResourceRespInfoV2)localObject2).strPkgName);
            }
          }
        }
      }
      if (paramGetResourceRespV2.vecAddedResInfo != null)
      {
        localObject3 = paramGetResourceRespV2.vecAddedResInfo.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject1 = (GetResourceRespInfoV2)((Iterator)localObject3).next();
          if ((localObject1 != null) && (((GetResourceRespInfoV2)localObject1).iPluginType == 512))
          {
            localObject4 = ((GetResourceRespInfoV2)localObject1).strResName;
            localObject2 = a((String)localObject4);
            if (localObject2 != null)
            {
              XmlData localXmlData = EarlyDataFactory.a(((EarlyHandler)localObject2).a(), ((GetResourceRespInfoV2)localObject1).strResName, ((GetResourceRespInfoV2)localObject1).strPkgName, ((GetResourceRespInfoV2)localObject1).strResConf, ((GetResourceRespInfoV2)localObject1).uiNewVer, ((GetResourceRespInfoV2)localObject1).strResURL_big, ((GetResourceRespInfoV2)localObject1).strResURL_small);
              if (!TextUtils.equals(((GetResourceRespInfoV2)localObject1).strPkgName, ((EarlyHandler)localObject2).a().strPkgName)) {
                QLog.e("EarlyDown", 1, "doOnGetConfig() pkgName mismatch! resp:" + ((GetResourceRespInfoV2)localObject1).strPkgName + " vs local:" + ((EarlyHandler)localObject2).a().strPkgName);
              }
              ((EarlyHandler)localObject2).a().updateServerInfo(localXmlData);
              EarlyDataFactory.a(((EarlyHandler)localObject2).a(), new String[0]);
              localObject2 = Message.obtain();
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = new Message();
              }
              ((Message)localObject1).what = 131332;
              ((Message)localObject1).obj = new Object[] { localObject4, localXmlData };
              if (((String)localObject4).equals("qq.android.ar.native.so_v8.3.6")) {}
              for (jdField_a_of_type_Int = 0;; jdField_a_of_type_Int = 60000)
              {
                this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject1, jdField_a_of_type_Int);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("EarlyDown", 2, "doOnGetConfig() Added resName=" + (String)localObject4 + " data=" + localXmlData + " updateServerInfo done, doOnServerResp after " + jdField_a_of_type_Int + "ms");
                break;
              }
            }
          }
        }
      }
    } while (paramGetResourceRespV2.vecUpdatedResInfo == null);
    Object localObject2 = paramGetResourceRespV2.vecUpdatedResInfo.iterator();
    label473:
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
          if (!((String)localObject3).equals("qq.android.ar.native.so_v8.3.6")) {
            break label739;
          }
        }
      }
    }
    label739:
    for (jdField_a_of_type_Int = 0;; jdField_a_of_type_Int = 60000)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramGetResourceRespV2, jdField_a_of_type_Int);
      if (!QLog.isColorLevel()) {
        break label473;
      }
      QLog.d("EarlyDown", 2, "doOnGetConfig() Updated resName=" + (String)localObject3 + " data=" + localObject4 + " updateServerInfo done, doOnServerResp after " + jdField_a_of_type_Int + "ms");
      break label473;
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
          localObject = (EarlyDownloadManager.DownloadRecord)this.b.remove(paramXmlData.strResName);
          HttpEngineTask localHttpEngineTask = (HttpEngineTask)this.c.remove(paramXmlData.strResName);
          jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          if (QLog.isColorLevel()) {
            QLog.d("EarlyDown", 2, "doOnCancelDownload(), netReq = " + ((EarlyDownloadManager.DownloadRecord)localObject).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq + ", pendingNetReq = " + localHttpEngineTask);
          }
          localEarlyHandler = a(paramXmlData.strResName);
          if ((localObject == null) && (localHttpEngineTask == null)) {
            break;
          }
          if (localObject != null)
          {
            if (((EarlyDownloadManager.DownloadRecord)localObject).jdField_a_of_type_ComTencentMobileqqTransfilePredownloadAbsPreDownloadTask != null) {
              this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.cancelPreDownload(paramXmlData.strResURL_big);
            }
          }
          else
          {
            if (localHttpEngineTask != null) {
              this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.cancelPreDownload(paramXmlData.strResURL_big);
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
        ((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).cancelReq(((EarlyDownloadManager.DownloadRecord)localObject).jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
      }
    } while ((localEarlyHandler == null) || (!localEarlyHandler.c()));
    Object localObject = new Intent("resp.com.tencent.mobileqq.EARLY_CANCEL");
    ((Intent)localObject).putExtra("reqResult", false);
    ((Intent)localObject).putExtra("resultReason", "resName=" + paramXmlData.strResName + " is not loading..");
    ((Intent)localObject).putExtra("strResName", paramXmlData.strResName);
    ((Intent)localObject).putExtra("strPkgName", paramXmlData.strPkgName);
    BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject, "com.tencent.qqhead.permission.getheadresp");
    localEarlyHandler.b(false);
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
    //   16: invokevirtual 178	java/lang/String:length	()I
    //   19: ifne +74 -> 93
    //   22: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +41 -> 66
    //   28: new 159	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 876
    //   38: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: astore 6
    //   43: aload_1
    //   44: ifnonnull +25 -> 69
    //   47: ldc_w 878
    //   50: astore_1
    //   51: ldc 157
    //   53: iconst_2
    //   54: aload 6
    //   56: aload_1
    //   57: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: new 159	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 880
    //   79: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_2
    //   83: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore_1
    //   90: goto -39 -> 51
    //   93: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +55 -> 151
    //   99: ldc 157
    //   101: iconst_2
    //   102: new 159	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   109: ldc_w 882
    //   112: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_1
    //   116: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   119: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc_w 884
    //   125: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_1
    //   129: getfield 489	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResURL_big	Ljava/lang/String;
    //   132: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc_w 886
    //   138: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_2
    //   142: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload_1
    //   152: getfield 489	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResURL_big	Ljava/lang/String;
    //   155: invokestatic 666	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifne -92 -> 66
    //   161: getstatic 99	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   164: invokeinterface 346 1 0
    //   169: aload_0
    //   170: getfield 111	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:b	Ljava/util/HashMap;
    //   173: aload_1
    //   174: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   177: invokevirtual 843	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   180: ifeq +80 -> 260
    //   183: aload_1
    //   184: getfield 317	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   187: ifne +22 -> 209
    //   190: aload_1
    //   191: iconst_2
    //   192: putfield 317	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   195: aload_1
    //   196: iconst_1
    //   197: anewarray 35	java/lang/String
    //   200: dup
    //   201: iconst_0
    //   202: ldc_w 321
    //   205: aastore
    //   206: invokestatic 327	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   209: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +32 -> 244
    //   215: ldc 157
    //   217: iconst_2
    //   218: new 159	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   225: ldc_w 888
    //   228: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_1
    //   232: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   235: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   244: getstatic 99	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   247: invokeinterface 371 1 0
    //   252: goto -186 -> 66
    //   255: astore_1
    //   256: aload_0
    //   257: monitorexit
    //   258: aload_1
    //   259: athrow
    //   260: aload_0
    //   261: getfield 113	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:c	Ljava/util/HashMap;
    //   264: aload_1
    //   265: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   268: invokevirtual 843	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   271: ifeq +97 -> 368
    //   274: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq +32 -> 309
    //   280: ldc 157
    //   282: iconst_2
    //   283: new 159	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   290: ldc_w 890
    //   293: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_1
    //   297: getfield 893	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   300: invokevirtual 431	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   303: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: aload_1
    //   310: getfield 893	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   313: istore 5
    //   315: iload 5
    //   317: ifne +14 -> 331
    //   320: getstatic 99	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   323: invokeinterface 371 1 0
    //   328: goto -262 -> 66
    //   331: aload_0
    //   332: getfield 113	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:c	Ljava/util/HashMap;
    //   335: aload_1
    //   336: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   339: invokevirtual 368	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   342: checkcast 807	com/tencent/mobileqq/transfile/predownload/HttpEngineTask
    //   345: astore 6
    //   347: aload 6
    //   349: ifnull +19 -> 368
    //   352: aload_0
    //   353: getfield 148	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController	Lcom/tencent/mobileqq/transfile/predownload/PreDownloadController;
    //   356: aload 6
    //   358: getfield 896	com/tencent/mobileqq/transfile/predownload/HttpEngineTask:httpReq	Lcom/tencent/mobileqq/transfile/HttpNetReq;
    //   361: getfield 901	com/tencent/mobileqq/transfile/HttpNetReq:mReqUrl	Ljava/lang/String;
    //   364: invokevirtual 815	com/tencent/mobileqq/transfile/predownload/PreDownloadController:cancelPreDownload	(Ljava/lang/String;)Lcom/tencent/mobileqq/transfile/predownload/AbsPreDownloadTask;
    //   367: pop
    //   368: getstatic 99	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   371: invokeinterface 371 1 0
    //   376: aload_1
    //   377: invokestatic 309	android/os/SystemClock:elapsedRealtime	()J
    //   380: putfield 314	com/tencent/mobileqq/earlydownload/xmldata/XmlData:tStart	J
    //   383: aload_1
    //   384: iconst_2
    //   385: putfield 317	com/tencent/mobileqq/earlydownload/xmldata/XmlData:loadState	I
    //   388: aload_1
    //   389: iconst_0
    //   390: putfield 320	com/tencent/mobileqq/earlydownload/xmldata/XmlData:hasResDownloaded	Z
    //   393: aload_1
    //   394: iconst_2
    //   395: anewarray 35	java/lang/String
    //   398: dup
    //   399: iconst_0
    //   400: ldc_w 321
    //   403: aastore
    //   404: dup
    //   405: iconst_1
    //   406: ldc_w 322
    //   409: aastore
    //   410: invokestatic 327	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;[Ljava/lang/String;)V
    //   413: aload_0
    //   414: getfield 120	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   417: ldc_w 820
    //   420: ldc_w 822
    //   423: invokevirtual 826	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   426: checkcast 820	com/tencent/mobileqq/transfile/api/IHttpEngineService
    //   429: astore 6
    //   431: invokestatic 155	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +12 -> 446
    //   437: ldc 157
    //   439: iconst_2
    //   440: ldc_w 903
    //   443: invokestatic 174	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: new 898	com/tencent/mobileqq/transfile/HttpNetReq
    //   449: dup
    //   450: invokespecial 904	com/tencent/mobileqq/transfile/HttpNetReq:<init>	()V
    //   453: astore 7
    //   455: aload 7
    //   457: aload_0
    //   458: putfield 908	com/tencent/mobileqq/transfile/HttpNetReq:mCallback	Lcom/tencent/mobileqq/transfile/INetEngineListener;
    //   461: aload 7
    //   463: iconst_1
    //   464: putfield 911	com/tencent/mobileqq/transfile/HttpNetReq:mSupportBreakResume	Z
    //   467: aload 7
    //   469: aload_1
    //   470: getfield 489	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResURL_big	Ljava/lang/String;
    //   473: putfield 901	com/tencent/mobileqq/transfile/HttpNetReq:mReqUrl	Ljava/lang/String;
    //   476: aload 7
    //   478: iconst_1
    //   479: putfield 914	com/tencent/mobileqq/transfile/HttpNetReq:mNeedIpConnect	Z
    //   482: aload 7
    //   484: iconst_0
    //   485: putfield 917	com/tencent/mobileqq/transfile/HttpNetReq:mHttpMethod	I
    //   488: aload 7
    //   490: aload_1
    //   491: invokevirtual 921	com/tencent/mobileqq/transfile/HttpNetReq:setUserData	(Ljava/lang/Object;)V
    //   494: aload 7
    //   496: aload_2
    //   497: putfield 922	com/tencent/mobileqq/transfile/HttpNetReq:mOutPath	Ljava/lang/String;
    //   500: aload 7
    //   502: iconst_1
    //   503: putfield 925	com/tencent/mobileqq/transfile/HttpNetReq:bAcceptNegativeContentLength	Z
    //   506: aload_1
    //   507: getfield 893	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   510: ifne +13 -> 523
    //   513: aload_0
    //   514: getfield 148	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController	Lcom/tencent/mobileqq/transfile/predownload/PreDownloadController;
    //   517: invokevirtual 928	com/tencent/mobileqq/transfile/predownload/PreDownloadController:isEnable	()Z
    //   520: ifne +47 -> 567
    //   523: aload_1
    //   524: getfield 893	com/tencent/mobileqq/earlydownload/xmldata/XmlData:isUserClick	Z
    //   527: ifeq +190 -> 717
    //   530: aload 7
    //   532: iload_3
    //   533: putfield 931	com/tencent/mobileqq/transfile/HttpNetReq:mPrioty	I
    //   536: aload_0
    //   537: aload_1
    //   538: aload 7
    //   540: aconst_null
    //   541: invokespecial 933	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	(Lcom/tencent/mobileqq/earlydownload/xmldata/XmlData;Lcom/tencent/mobileqq/transfile/HttpNetReq;Lcom/tencent/mobileqq/transfile/predownload/AbsPreDownloadTask;)V
    //   544: aload 6
    //   546: aload 7
    //   548: invokeinterface 936 2 0
    //   553: goto -487 -> 66
    //   556: astore_1
    //   557: getstatic 99	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   560: invokeinterface 371 1 0
    //   565: aload_1
    //   566: athrow
    //   567: aload 7
    //   569: iconst_2
    //   570: putfield 931	com/tencent/mobileqq/transfile/HttpNetReq:mPrioty	I
    //   573: getstatic 99	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   576: invokeinterface 346 1 0
    //   581: new 807	com/tencent/mobileqq/transfile/predownload/HttpEngineTask
    //   584: dup
    //   585: aload_0
    //   586: getfield 120	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   589: aload_1
    //   590: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   593: aload_0
    //   594: aload 7
    //   596: invokespecial 939	com/tencent/mobileqq/transfile/predownload/HttpEngineTask:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/predownload/HttpEngineTask$IHttpEngineTask;Lcom/tencent/mobileqq/transfile/HttpNetReq;)V
    //   599: astore_2
    //   600: aload_1
    //   601: getfield 942	com/tencent/mobileqq/earlydownload/xmldata/XmlData:load2G	Z
    //   604: ifeq +81 -> 685
    //   607: iload 4
    //   609: istore_3
    //   610: aload_0
    //   611: aload_1
    //   612: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   615: invokevirtual 333	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/earlydownload/handler/EarlyHandler;
    //   618: astore 6
    //   620: aload 6
    //   622: ifnull +52 -> 674
    //   625: aload_0
    //   626: getfield 148	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController	Lcom/tencent/mobileqq/transfile/predownload/PreDownloadController;
    //   629: aload 6
    //   631: invokevirtual 944	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:a	()I
    //   634: aload 6
    //   636: invokevirtual 946	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:b	()Ljava/lang/String;
    //   639: aload_1
    //   640: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   643: iconst_0
    //   644: aload_1
    //   645: getfield 489	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResURL_big	Ljava/lang/String;
    //   648: aload 6
    //   650: invokevirtual 948	com/tencent/mobileqq/earlydownload/handler/EarlyHandler:c	()Ljava/lang/String;
    //   653: iload_3
    //   654: iconst_0
    //   655: iconst_0
    //   656: aload_2
    //   657: invokevirtual 952	com/tencent/mobileqq/transfile/predownload/PreDownloadController:requestPreDownload	(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIZLcom/tencent/mobileqq/transfile/predownload/AbsPreDownloadTask;)Z
    //   660: pop
    //   661: aload_0
    //   662: getfield 113	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:c	Ljava/util/HashMap;
    //   665: aload_1
    //   666: getfield 360	com/tencent/mobileqq/earlydownload/xmldata/XmlData:strResName	Ljava/lang/String;
    //   669: aload_2
    //   670: invokevirtual 364	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   673: pop
    //   674: getstatic 99	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   677: invokeinterface 371 1 0
    //   682: goto -616 -> 66
    //   685: aload_1
    //   686: getfield 955	com/tencent/mobileqq/earlydownload/xmldata/XmlData:load3G	Z
    //   689: istore 5
    //   691: iload 5
    //   693: ifeq +8 -> 701
    //   696: iconst_3
    //   697: istore_3
    //   698: goto -88 -> 610
    //   701: iconst_1
    //   702: istore_3
    //   703: goto -93 -> 610
    //   706: astore_1
    //   707: getstatic 99	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   710: invokeinterface 371 1 0
    //   715: aload_1
    //   716: athrow
    //   717: iconst_2
    //   718: istore_3
    //   719: goto -189 -> 530
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	722	0	this	EarlyDownloadManager
    //   0	722	1	paramXmlData	XmlData
    //   0	722	2	paramString	String
    //   1	718	3	i	int
    //   3	605	4	j	int
    //   313	379	5	bool	boolean
    //   41	608	6	localObject	Object
    //   453	142	7	localHttpNetReq	HttpNetReq
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
    //   368	446	255	finally
    //   446	523	255	finally
    //   523	530	255	finally
    //   530	553	255	finally
    //   557	567	255	finally
    //   567	581	255	finally
    //   674	682	255	finally
    //   707	717	255	finally
    //   169	209	556	finally
    //   209	244	556	finally
    //   260	309	556	finally
    //   309	315	556	finally
    //   331	347	556	finally
    //   352	368	556	finally
    //   581	607	706	finally
    //   610	620	706	finally
    //   625	674	706	finally
    //   685	691	706	finally
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EarlyDown", 2, "addRequesting " + paramString);
    }
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
  
  public void a(boolean paramBoolean)
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
      String str = arrayOfString[i];
      GetResourceReqInfoV2 localGetResourceReqInfoV2 = null;
      EarlyHandler localEarlyHandler = a(str);
      if (localEarlyHandler != null)
      {
        localEarlyHandler.e(paramBoolean);
        localGetResourceReqInfoV2 = localEarlyHandler.a(str);
      }
      if (localGetResourceReqInfoV2 != null) {
        localArrayList.add(localGetResourceReqInfoV2);
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EarlyDown", 2, "getPluginList: 128 reqInfoV2s.len=" + localArrayList.size());
    }
    ((ServerConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(4)).getPluginConfig(512, localReqUserInfo, localArrayList, this, AppSetting.a());
  }
  
  public boolean a()
  {
    return (DeviceInfoUtil.f()) || (FileUtils.a() <= 1.048576E+008F);
  }
  
  public boolean a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashSet)
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashSet.contains(paramString);
      return bool;
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EarlyDown", 2, "removeRequesting " + paramString);
    }
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
        paramString.a();
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
    label400:
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
              a((NetResp)paramMessage.obj);
              return false;
              b((XmlData)paramMessage.obj);
              return false;
              a(false);
              return false;
              localObject = null;
              if (paramMessage.obj != null) {
                localObject = (GetResourceRespV2)paramMessage.obj;
              }
              a((GetResourceRespV2)localObject);
              return false;
              if (!(paramMessage.obj instanceof GetResourceRespInfo)) {
                break label400;
              }
              paramMessage = (GetResourceRespInfo)paramMessage.obj;
              if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "ACTION_ON_SERVER_RESP doOnServerResp() GetResourceRespInfo,resp.strPkgName = " + paramMessage.strPkgName + ",resp.iResult = " + paramMessage.iResult + ",resp.strResName = " + paramMessage.strResName);
              }
              if (paramMessage.iResult != 0) {
                break;
              }
              localObject = a(paramMessage.strResName);
              if (localObject != null) {
                ((EarlyHandler)localObject).a(EarlyDataFactory.a(((EarlyHandler)localObject).a(), paramMessage.strResName, paramMessage.strPkgName, paramMessage.strResConf, paramMessage.uiNewVer, paramMessage.strResURL_big, paramMessage.strResURL_small));
              }
            } while (!QLog.isColorLevel());
            QLog.d("EarlyDown", 2, "ACTION_ON_SERVER_RESP doOnServerResp() GetResourceRespInfo = " + paramMessage.strPkgName + ",handler = " + localObject);
            return false;
            localObject = a(paramMessage.strResName);
            if (localObject != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("EarlyDown", 2, "!ACTION_ON_SERVER_RESP! doOnServerResp() GetResourceRespInfo = " + paramMessage.strPkgName + ",handler = " + localObject);
              }
              ((EarlyHandler)localObject).a(((EarlyHandler)localObject).a(), false, paramMessage.iResult, "");
            }
            b(paramMessage.strResName);
            return false;
          } while (!(paramMessage.obj instanceof Object[]));
          localObject = (Object[])paramMessage.obj;
        } while ((localObject.length != 2) || (!(localObject[0] instanceof String)) || (!(localObject[1] instanceof XmlData)));
        paramMessage = (String)localObject[0];
        localObject = (XmlData)localObject[1];
        paramMessage = a(paramMessage);
        if (QLog.isColorLevel()) {
          QLog.d("EarlyDown", 2, "ACTION_ON_SERVER_RESP object[], handler = " + paramMessage);
        }
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
        ((EarlyHandler)localObject2).a();
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
  
  public void onPreDownloadStart(HttpEngineTask paramHttpEngineTask)
  {
    a((XmlData)paramHttpEngineTask.httpReq.getUserData(), paramHttpEngineTask.httpReq, paramHttpEngineTask);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(131328, paramNetResp).sendToTarget();
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (XmlData)paramNetReq.getUserData();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.EarlyDownloadManager
 * JD-Core Version:    0.7.0.1
 */