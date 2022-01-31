package com.tencent.mobileqq.ocr;

import agfz;
import aggd;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
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
  public static final HashMap b;
  public int a;
  Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ARCloudFileUpload.ARCloudFileUploadCallback jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload$ARCloudFileUploadCallback = new aggd(this);
  ARCloudFileUpload jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload;
  public OCRManager a;
  private OcrControl.OcrCallback jdField_a_of_type_ComTencentMobileqqOcrOcrControl$OcrCallback;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap a;
  private Handler b;
  
  static
  {
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap.put("zh", "中文");
    jdField_b_of_type_JavaUtilHashMap.put("en", "英语");
    jdField_b_of_type_JavaUtilHashMap.put("af", "南非公用荷兰语");
    jdField_b_of_type_JavaUtilHashMap.put("ar", "阿拉伯语");
    jdField_b_of_type_JavaUtilHashMap.put("eu", "巴斯克语");
    jdField_b_of_type_JavaUtilHashMap.put("be", "白俄罗斯语");
    jdField_b_of_type_JavaUtilHashMap.put("hr", "克罗地亚语");
    jdField_b_of_type_JavaUtilHashMap.put("da", "丹麦语");
    jdField_b_of_type_JavaUtilHashMap.put("nl", "荷兰语");
    jdField_b_of_type_JavaUtilHashMap.put("fo", "法罗语");
    jdField_b_of_type_JavaUtilHashMap.put("fi", "芬兰语");
    jdField_b_of_type_JavaUtilHashMap.put("fr", "法语");
    jdField_b_of_type_JavaUtilHashMap.put("gd", "盖尔语");
    jdField_b_of_type_JavaUtilHashMap.put("de", "德语");
    jdField_b_of_type_JavaUtilHashMap.put("he", "希伯来语");
    jdField_b_of_type_JavaUtilHashMap.put("hu", "匈牙利语");
    jdField_b_of_type_JavaUtilHashMap.put("id", "印度尼西亚语");
    jdField_b_of_type_JavaUtilHashMap.put("it", "意大利语");
    jdField_b_of_type_JavaUtilHashMap.put("kr", "韩语");
    jdField_b_of_type_JavaUtilHashMap.put("lv", "拉脱维亚语");
    jdField_b_of_type_JavaUtilHashMap.put("mk", "马其顿语");
    jdField_b_of_type_JavaUtilHashMap.put("mt", "马耳他语");
    jdField_b_of_type_JavaUtilHashMap.put("no", "挪威文");
    jdField_b_of_type_JavaUtilHashMap.put("pt", "葡萄牙语");
    jdField_b_of_type_JavaUtilHashMap.put("rm", "里托罗曼斯文");
    jdField_b_of_type_JavaUtilHashMap.put("ro", "罗马尼亚语");
    jdField_b_of_type_JavaUtilHashMap.put("sr", "塞尔维亚语");
    jdField_b_of_type_JavaUtilHashMap.put("sk", "斯洛伐克语");
    jdField_b_of_type_JavaUtilHashMap.put("sb", "索布语");
    jdField_b_of_type_JavaUtilHashMap.put("es", "西班牙语");
    jdField_b_of_type_JavaUtilHashMap.put("sx", "苏图语");
    jdField_b_of_type_JavaUtilHashMap.put("sv", "瑞典语");
    jdField_b_of_type_JavaUtilHashMap.put("ts", "特松加语");
    jdField_b_of_type_JavaUtilHashMap.put("tr", "土耳其语");
    jdField_b_of_type_JavaUtilHashMap.put("ur", "乌尔都语");
    jdField_b_of_type_JavaUtilHashMap.put("vi", "越南语");
    jdField_b_of_type_JavaUtilHashMap.put("ji", "意第绪语");
    jdField_b_of_type_JavaUtilHashMap.put("sq", "阿尔巴尼亚语");
    jdField_b_of_type_JavaUtilHashMap.put("bg", "保加利亚语");
    jdField_b_of_type_JavaUtilHashMap.put("ca", "加泰罗尼亚语");
    jdField_b_of_type_JavaUtilHashMap.put("cs", "捷克语");
    jdField_b_of_type_JavaUtilHashMap.put("et", "爱沙尼亚语");
    jdField_b_of_type_JavaUtilHashMap.put("fa", "波斯语");
    jdField_b_of_type_JavaUtilHashMap.put("ga", "爱尔兰语");
    jdField_b_of_type_JavaUtilHashMap.put("el", "希腊");
    jdField_b_of_type_JavaUtilHashMap.put("hi", "印地文");
    jdField_b_of_type_JavaUtilHashMap.put("is", "冰岛语");
    jdField_b_of_type_JavaUtilHashMap.put("jp", "日语");
    jdField_b_of_type_JavaUtilHashMap.put("lt", "立陶宛语");
    jdField_b_of_type_JavaUtilHashMap.put("ms", "马来西亚语");
    jdField_b_of_type_JavaUtilHashMap.put("pl", "波兰语");
    jdField_b_of_type_JavaUtilHashMap.put("ru", "俄语");
    jdField_b_of_type_JavaUtilHashMap.put("sz", "萨米语");
    jdField_b_of_type_JavaUtilHashMap.put("sl", "斯洛文尼亚语");
    jdField_b_of_type_JavaUtilHashMap.put("th", "泰国语");
    jdField_b_of_type_JavaUtilHashMap.put("tn", "茨瓦纳语");
    jdField_b_of_type_JavaUtilHashMap.put("uk", "乌克兰语");
    jdField_b_of_type_JavaUtilHashMap.put("ve", "文达语");
    jdField_b_of_type_JavaUtilHashMap.put("xh", "科萨语");
    jdField_b_of_type_JavaUtilHashMap.put("zu", "祖鲁语");
  }
  
  public OcrControl(AppInterface paramAppInterface, OcrControl.OcrCallback paramOcrCallback, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl$OcrCallback = paramOcrCallback;
    this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload = new ARCloudFileUpload(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload.a();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqOcrOCRManager = ((OCRManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(227));
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
    //   3: getfield 296	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnull +62 -> 72
    //   13: aload_1
    //   14: getfield 359	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokestatic 323	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +52 -> 72
    //   23: aload_0
    //   24: getfield 296	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   27: aload_1
    //   28: getfield 359	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   31: aload_1
    //   32: invokevirtual 33	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: invokestatic 329	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +33 -> 72
    //   42: ldc_w 331
    //   45: iconst_2
    //   46: new 333	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 334	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 361
    //   56: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: getfield 359	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   63: invokevirtual 340	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 348	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   2: new 354	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo
    //   5: dup
    //   6: invokespecial 424	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:<init>	()V
    //   9: astore_3
    //   10: aload_3
    //   11: aload_0
    //   12: invokevirtual 426	com/tencent/mobileqq/ocr/OcrControl:a	()Ljava/lang/String;
    //   15: putfield 359	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: aload_3
    //   19: aload_1
    //   20: putfield 429	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo	Lcom/tencent/mobileqq/ar/arengine/ARCloudReqFileInfo;
    //   23: aload_3
    //   24: ldc_w 430
    //   27: putfield 432	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_b_of_type_Int	I
    //   30: aload_3
    //   31: ldc_w 430
    //   34: putfield 433	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_Int	I
    //   37: aload_3
    //   38: ldc2_w 434
    //   41: putfield 438	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_Long	J
    //   44: aload_3
    //   45: iconst_0
    //   46: putfield 441	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_c_of_type_Int	I
    //   49: aload_3
    //   50: aload_0
    //   51: getfield 283	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   54: invokevirtual 444	com/tencent/common/app/AppInterface:getAppid	()I
    //   57: invokestatic 447	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   60: putfield 449	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   63: aload_3
    //   64: aload_0
    //   65: getfield 283	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   68: invokevirtual 373	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   71: invokestatic 455	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   74: putfield 457	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_b_of_type_Long	J
    //   77: aload_3
    //   78: invokestatic 388	java/lang/System:currentTimeMillis	()J
    //   81: putfield 459	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_c_of_type_Long	J
    //   84: new 461	com/tencent/mobileqq/ocr/ARCloudReqOcrInfo
    //   87: dup
    //   88: invokespecial 462	com/tencent/mobileqq/ocr/ARCloudReqOcrInfo:<init>	()V
    //   91: astore 4
    //   93: aload_2
    //   94: invokestatic 323	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne +9 -> 106
    //   100: aload 4
    //   102: aload_2
    //   103: putfield 463	com/tencent/mobileqq/ocr/ARCloudReqOcrInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: aload_3
    //   107: aload 4
    //   109: putfield 466	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_ComTencentMobileqqOcrARCloudReqOcrInfo	Lcom/tencent/mobileqq/ocr/ARCloudReqOcrInfo;
    //   112: aload_0
    //   113: aload_3
    //   114: invokespecial 468	com/tencent/mobileqq/ocr/OcrControl:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudReqInfo;)V
    //   117: aload_3
    //   118: getfield 359	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   121: astore_2
    //   122: aload_0
    //   123: getfield 311	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   126: new 470	agga
    //   129: dup
    //   130: aload_0
    //   131: aload_2
    //   132: invokespecial 473	agga:<init>	(Lcom/tencent/mobileqq/ocr/OcrControl;Ljava/lang/String;)V
    //   135: ldc2_w 474
    //   138: invokevirtual 479	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   141: pop
    //   142: aload_0
    //   143: getfield 292	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload	Lcom/tencent/mobileqq/ar/arcloud/ARCloudFileUpload;
    //   146: aload_3
    //   147: aload_0
    //   148: getfield 281	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload$ARCloudFileUploadCallback	Lcom/tencent/mobileqq/ar/arcloud/ARCloudFileUpload$ARCloudFileUploadCallback;
    //   151: invokevirtual 482	com/tencent/mobileqq/ar/arcloud/ARCloudFileUpload:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudReqInfo;Lcom/tencent/mobileqq/ar/arcloud/ARCloudFileUpload$ARCloudFileUploadCallback;)Z
    //   154: ifeq +42 -> 196
    //   157: aload_0
    //   158: getfield 311	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   161: new 484	aggb
    //   164: dup
    //   165: aload_0
    //   166: aload_2
    //   167: aload_1
    //   168: invokespecial 487	aggb:<init>	(Lcom/tencent/mobileqq/ocr/OcrControl;Ljava/lang/String;Lcom/tencent/mobileqq/ar/arengine/ARCloudReqFileInfo;)V
    //   171: ldc2_w 488
    //   174: invokevirtual 479	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   177: pop
    //   178: new 491	aggc
    //   181: dup
    //   182: aload_0
    //   183: aload_1
    //   184: invokespecial 494	aggc:<init>	(Lcom/tencent/mobileqq/ocr/OcrControl;Lcom/tencent/mobileqq/ar/arengine/ARCloudReqFileInfo;)V
    //   187: iconst_5
    //   188: aconst_null
    //   189: iconst_0
    //   190: invokestatic 499	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   193: aload_0
    //   194: monitorexit
    //   195: return
    //   196: aload_0
    //   197: getfield 285	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_ComTencentMobileqqOcrOcrControl$OcrCallback	Lcom/tencent/mobileqq/ocr/OcrControl$OcrCallback;
    //   200: iconst_3
    //   201: aconst_null
    //   202: aload_1
    //   203: getfield 502	com/tencent/mobileqq/ar/arengine/ARCloudReqFileInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   206: lconst_0
    //   207: invokeinterface 507 6 0
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
      QLog.d("Q.ocr.control", 2, "recogPic picPath:" + paramString1 + ",isCrop:" + paramBoolean);
    }
    a(new agfz(this, paramString1, paramBoolean, paramString2));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl
 * JD-Core Version:    0.7.0.1
 */