package com.tencent.mobileqq.ocr;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload.ARCloudFileUploadCallback;
import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class OcrControl
{
  public static final HashMap<String, String> b;
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ARCloudFileUpload.ARCloudFileUploadCallback jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload$ARCloudFileUploadCallback = new OcrControl.5(this);
  ARCloudFileUpload jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload;
  OCRManager jdField_a_of_type_ComTencentMobileqqOcrOCRManager;
  private OcrControl.OcrCallback jdField_a_of_type_ComTencentMobileqqOcrOcrControl$OcrCallback;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  HashMap<String, ARCloudReqInfo> jdField_a_of_type_JavaUtilHashMap;
  private Handler b;
  
  static
  {
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap.put("zh", HardCodeUtil.a(2131707770));
    jdField_b_of_type_JavaUtilHashMap.put("en", HardCodeUtil.a(2131707789));
    jdField_b_of_type_JavaUtilHashMap.put("af", HardCodeUtil.a(2131707793));
    jdField_b_of_type_JavaUtilHashMap.put("ar", HardCodeUtil.a(2131707746));
    jdField_b_of_type_JavaUtilHashMap.put("eu", HardCodeUtil.a(2131707781));
    jdField_b_of_type_JavaUtilHashMap.put("be", HardCodeUtil.a(2131707744));
    jdField_b_of_type_JavaUtilHashMap.put("hr", HardCodeUtil.a(2131707751));
    jdField_b_of_type_JavaUtilHashMap.put("da", HardCodeUtil.a(2131707738));
    jdField_b_of_type_JavaUtilHashMap.put("nl", HardCodeUtil.a(2131707774));
    jdField_b_of_type_JavaUtilHashMap.put("fo", HardCodeUtil.a(2131707764));
    jdField_b_of_type_JavaUtilHashMap.put("fi", HardCodeUtil.a(2131707755));
    jdField_b_of_type_JavaUtilHashMap.put("fr", HardCodeUtil.a(2131707748));
    jdField_b_of_type_JavaUtilHashMap.put("gd", HardCodeUtil.a(2131707787));
    jdField_b_of_type_JavaUtilHashMap.put("de", HardCodeUtil.a(2131707739));
    jdField_b_of_type_JavaUtilHashMap.put("he", HardCodeUtil.a(2131707769));
    jdField_b_of_type_JavaUtilHashMap.put("hu", HardCodeUtil.a(2131707783));
    jdField_b_of_type_JavaUtilHashMap.put("id", HardCodeUtil.a(2131707765));
    jdField_b_of_type_JavaUtilHashMap.put("it", HardCodeUtil.a(2131707756));
    jdField_b_of_type_JavaUtilHashMap.put("kr", HardCodeUtil.a(2131707779));
    jdField_b_of_type_JavaUtilHashMap.put("lv", HardCodeUtil.a(2131707758));
    jdField_b_of_type_JavaUtilHashMap.put("mk", HardCodeUtil.a(2131707791));
    jdField_b_of_type_JavaUtilHashMap.put("mt", HardCodeUtil.a(2131707760));
    jdField_b_of_type_JavaUtilHashMap.put("no", HardCodeUtil.a(2131707747));
    jdField_b_of_type_JavaUtilHashMap.put("pt", HardCodeUtil.a(2131707771));
    jdField_b_of_type_JavaUtilHashMap.put("rm", HardCodeUtil.a(2131707754));
    jdField_b_of_type_JavaUtilHashMap.put("ro", HardCodeUtil.a(2131707752));
    jdField_b_of_type_JavaUtilHashMap.put("sr", HardCodeUtil.a(2131707776));
    jdField_b_of_type_JavaUtilHashMap.put("sk", HardCodeUtil.a(2131707778));
    jdField_b_of_type_JavaUtilHashMap.put("sb", HardCodeUtil.a(2131707737));
    jdField_b_of_type_JavaUtilHashMap.put("es", HardCodeUtil.a(2131707750));
    jdField_b_of_type_JavaUtilHashMap.put("sx", HardCodeUtil.a(2131707759));
    jdField_b_of_type_JavaUtilHashMap.put("sv", HardCodeUtil.a(2131707761));
    jdField_b_of_type_JavaUtilHashMap.put("ts", HardCodeUtil.a(2131707743));
    jdField_b_of_type_JavaUtilHashMap.put("tr", HardCodeUtil.a(2131707768));
    jdField_b_of_type_JavaUtilHashMap.put("ur", HardCodeUtil.a(2131707792));
    jdField_b_of_type_JavaUtilHashMap.put("vi", HardCodeUtil.a(2131707741));
    jdField_b_of_type_JavaUtilHashMap.put("ji", HardCodeUtil.a(2131707734));
    jdField_b_of_type_JavaUtilHashMap.put("sq", HardCodeUtil.a(2131707740));
    jdField_b_of_type_JavaUtilHashMap.put("bg", HardCodeUtil.a(2131707749));
    jdField_b_of_type_JavaUtilHashMap.put("ca", HardCodeUtil.a(2131707757));
    jdField_b_of_type_JavaUtilHashMap.put("cs", HardCodeUtil.a(2131707784));
    jdField_b_of_type_JavaUtilHashMap.put("et", HardCodeUtil.a(2131707782));
    jdField_b_of_type_JavaUtilHashMap.put("fa", HardCodeUtil.a(2131707780));
    jdField_b_of_type_JavaUtilHashMap.put("ga", HardCodeUtil.a(2131707777));
    jdField_b_of_type_JavaUtilHashMap.put("el", HardCodeUtil.a(2131707786));
    jdField_b_of_type_JavaUtilHashMap.put("hi", HardCodeUtil.a(2131707775));
    jdField_b_of_type_JavaUtilHashMap.put("is", HardCodeUtil.a(2131707736));
    jdField_b_of_type_JavaUtilHashMap.put("jp", HardCodeUtil.a(2131707790));
    jdField_b_of_type_JavaUtilHashMap.put("lt", HardCodeUtil.a(2131707766));
    jdField_b_of_type_JavaUtilHashMap.put("ms", HardCodeUtil.a(2131707735));
    jdField_b_of_type_JavaUtilHashMap.put("pl", HardCodeUtil.a(2131707745));
    jdField_b_of_type_JavaUtilHashMap.put("ru", HardCodeUtil.a(2131707742));
    jdField_b_of_type_JavaUtilHashMap.put("sz", HardCodeUtil.a(2131707767));
    jdField_b_of_type_JavaUtilHashMap.put("sl", HardCodeUtil.a(2131707773));
    jdField_b_of_type_JavaUtilHashMap.put("th", HardCodeUtil.a(2131707763));
    jdField_b_of_type_JavaUtilHashMap.put("tn", HardCodeUtil.a(2131707785));
    jdField_b_of_type_JavaUtilHashMap.put("uk", HardCodeUtil.a(2131707762));
    jdField_b_of_type_JavaUtilHashMap.put("ve", HardCodeUtil.a(2131707753));
    jdField_b_of_type_JavaUtilHashMap.put("xh", HardCodeUtil.a(2131707788));
    jdField_b_of_type_JavaUtilHashMap.put("zu", HardCodeUtil.a(2131707772));
  }
  
  public OcrControl(AppInterface paramAppInterface, OcrControl.OcrCallback paramOcrCallback, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl$OcrCallback = paramOcrCallback;
    this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload = new ARCloudFileUpload(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload.a();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqOcrOCRManager = ((OCRManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.OCR_MANAGER));
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private ARCloudReqInfo a(String paramString)
  {
    ARCloudReqInfo localARCloudReqInfo = null;
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.ocr.control", 2, "req had been remove, sessionId:" + paramString);
        }
        localARCloudReqInfo = (ARCloudReqInfo)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      }
      return localARCloudReqInfo;
    }
  }
  
  /* Error */
  private void a(ARCloudReqInfo paramARCloudReqInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 243	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnull +62 -> 72
    //   13: aload_1
    //   14: getfield 311	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +52 -> 72
    //   23: aload_0
    //   24: getfield 243	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   27: aload_1
    //   28: getfield 311	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   31: aload_1
    //   32: invokevirtual 39	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +33 -> 72
    //   42: ldc_w 283
    //   45: iconst_2
    //   46: new 285	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 313
    //   56: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: getfield 311	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   63: invokevirtual 292	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 300	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_2
    //   73: monitorexit
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_1
    //   78: aload_2
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	OcrControl
    //   0	87	1	paramARCloudReqInfo	ARCloudReqInfo
    //   6	73	2	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   13	72	77	finally
    //   72	74	77	finally
    //   78	80	77	finally
    //   2	9	82	finally
    //   80	82	82	finally
  }
  
  private void a(Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_b_of_type_AndroidOsHandler.post(paramRunnable);
      }
      return;
    }
  }
  
  public String a()
  {
    return String.format("%s_%s_%05d", new Object[] { this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis())), Integer.valueOf(new Random().nextInt(100000)) });
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      if (this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.ocr.control", 2, "stopRecog...");
      }
      return;
    }
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo paramARCloudReqFileInfo, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 306	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo
    //   5: dup
    //   6: invokespecial 376	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: aload_0
    //   12: invokevirtual 378	com/tencent/mobileqq/ocr/OcrControl:a	()Ljava/lang/String;
    //   15: putfield 311	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: aload_3
    //   19: aload_1
    //   20: putfield 381	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo	Lcom/tencent/mobileqq/ar/arengine/ARCloudReqFileInfo;
    //   23: aload_3
    //   24: ldc_w 382
    //   27: putfield 384	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_b_of_type_Int	I
    //   30: aload_3
    //   31: ldc_w 382
    //   34: putfield 385	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_Int	I
    //   37: aload_3
    //   38: ldc2_w 386
    //   41: putfield 390	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_Long	J
    //   44: aload_3
    //   45: iconst_0
    //   46: putfield 393	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_c_of_type_Int	I
    //   49: aload_3
    //   50: aload_0
    //   51: getfield 230	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   54: invokevirtual 396	com/tencent/common/app/AppInterface:getAppid	()I
    //   57: invokestatic 398	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   60: putfield 400	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   63: aload_3
    //   64: aload_0
    //   65: getfield 230	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   68: invokevirtual 325	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   71: invokestatic 406	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   74: putfield 408	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_b_of_type_Long	J
    //   77: aload_3
    //   78: invokestatic 340	java/lang/System:currentTimeMillis	()J
    //   81: putfield 410	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_c_of_type_Long	J
    //   84: new 412	com/tencent/mobileqq/ocr/ARCloudReqOcrInfo
    //   87: dup
    //   88: invokespecial 413	com/tencent/mobileqq/ocr/ARCloudReqOcrInfo:<init>	()V
    //   91: astore 4
    //   93: aload_2
    //   94: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne +9 -> 106
    //   100: aload 4
    //   102: aload_2
    //   103: putfield 414	com/tencent/mobileqq/ocr/ARCloudReqOcrInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: aload_3
    //   107: aload 4
    //   109: putfield 417	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_ComTencentMobileqqOcrARCloudReqOcrInfo	Lcom/tencent/mobileqq/ocr/ARCloudReqOcrInfo;
    //   112: aload_0
    //   113: aload_3
    //   114: invokespecial 419	com/tencent/mobileqq/ocr/OcrControl:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudReqInfo;)V
    //   117: aload_3
    //   118: getfield 311	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 263	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   126: new 421	com/tencent/mobileqq/ocr/OcrControl$2
    //   129: dup
    //   130: aload_0
    //   131: aload_2
    //   132: invokespecial 424	com/tencent/mobileqq/ocr/OcrControl$2:<init>	(Lcom/tencent/mobileqq/ocr/OcrControl;Ljava/lang/String;)V
    //   135: ldc2_w 425
    //   138: invokevirtual 430	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   141: pop
    //   142: aload_0
    //   143: getfield 239	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload	Lcom/tencent/mobileqq/ar/arcloud/ARCloudFileUpload;
    //   146: aload_3
    //   147: aload_0
    //   148: getfield 228	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload$ARCloudFileUploadCallback	Lcom/tencent/mobileqq/ar/arcloud/ARCloudFileUpload$ARCloudFileUploadCallback;
    //   151: invokevirtual 433	com/tencent/mobileqq/ar/arcloud/ARCloudFileUpload:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudReqInfo;Lcom/tencent/mobileqq/ar/arcloud/ARCloudFileUpload$ARCloudFileUploadCallback;)Z
    //   154: ifeq +42 -> 196
    //   157: aload_0
    //   158: getfield 263	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   161: new 435	com/tencent/mobileqq/ocr/OcrControl$3
    //   164: dup
    //   165: aload_0
    //   166: aload_2
    //   167: aload_1
    //   168: invokespecial 438	com/tencent/mobileqq/ocr/OcrControl$3:<init>	(Lcom/tencent/mobileqq/ocr/OcrControl;Ljava/lang/String;Lcom/tencent/mobileqq/ar/arengine/ARCloudReqFileInfo;)V
    //   171: ldc2_w 439
    //   174: invokevirtual 430	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   177: pop
    //   178: new 442	com/tencent/mobileqq/ocr/OcrControl$4
    //   181: dup
    //   182: aload_0
    //   183: aload_1
    //   184: invokespecial 445	com/tencent/mobileqq/ocr/OcrControl$4:<init>	(Lcom/tencent/mobileqq/ocr/OcrControl;Lcom/tencent/mobileqq/ar/arengine/ARCloudReqFileInfo;)V
    //   187: iconst_5
    //   188: aconst_null
    //   189: iconst_0
    //   190: invokestatic 450	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   193: aload_0
    //   194: monitorexit
    //   195: return
    //   196: aload_0
    //   197: getfield 232	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_ComTencentMobileqqOcrOcrControl$OcrCallback	Lcom/tencent/mobileqq/ocr/OcrControl$OcrCallback;
    //   200: iconst_3
    //   201: aconst_null
    //   202: aload_1
    //   203: getfield 453	com/tencent/mobileqq/ar/arengine/ARCloudReqFileInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   206: lconst_0
    //   207: invokeinterface 458 6 0
    //   212: goto -34 -> 178
    //   215: astore_1
    //   216: aload_0
    //   217: monitorexit
    //   218: aload_1
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	OcrControl
    //   0	220	1	paramARCloudReqFileInfo	com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo
    //   0	220	2	paramString	String
    //   9	138	3	localARCloudReqInfo	ARCloudReqInfo
    //   91	17	4	localARCloudReqOcrInfo	ARCloudReqOcrInfo
    // Exception table:
    //   from	to	target	type
    //   2	106	215	finally
    //   106	178	215	finally
    //   178	193	215	finally
    //   196	212	215	finally
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean, null);
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "recogPic picPath:" + paramString1 + ",needCompress:" + paramBoolean);
    }
    a(new OcrControl.1(this, paramString1, paramBoolean, paramString2));
  }
  
  public void b()
  {
    try
    {
      QLog.i("Q.ocr.control", 1, "startUploadThread.");
      if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("ocr_upload_thread" + System.currentTimeMillis(), 0);
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    try
    {
      QLog.i("Q.ocr.control", 1, "stopUploadThread.");
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      this.jdField_b_of_type_AndroidOsHandler = null;
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.quit();
        this.jdField_a_of_type_AndroidOsHandlerThread.interrupt();
      }
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
      return;
    }
    finally {}
  }
  
  public void d()
  {
    b();
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "Ocr control start");
    }
  }
  
  public void e()
  {
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload.a();
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "Ocr control stop");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl
 * JD-Core Version:    0.7.0.1
 */