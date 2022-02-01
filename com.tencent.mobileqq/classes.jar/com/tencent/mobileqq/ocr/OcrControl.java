package com.tencent.mobileqq.ocr;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload.ARCloudFileUploadCallback;
import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import com.tencent.mobileqq.ocr.api.IOCRService;
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
  private OcrControl.OcrCallback jdField_a_of_type_ComTencentMobileqqOcrOcrControl$OcrCallback;
  IOCRService jdField_a_of_type_ComTencentMobileqqOcrApiIOCRService;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  HashMap<String, ARCloudReqInfo> jdField_a_of_type_JavaUtilHashMap;
  private Handler b;
  
  static
  {
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap.put("zh", HardCodeUtil.a(2131707794));
    jdField_b_of_type_JavaUtilHashMap.put("en", HardCodeUtil.a(2131707813));
    jdField_b_of_type_JavaUtilHashMap.put("af", HardCodeUtil.a(2131707817));
    jdField_b_of_type_JavaUtilHashMap.put("ar", HardCodeUtil.a(2131707770));
    jdField_b_of_type_JavaUtilHashMap.put("eu", HardCodeUtil.a(2131707805));
    jdField_b_of_type_JavaUtilHashMap.put("be", HardCodeUtil.a(2131707768));
    jdField_b_of_type_JavaUtilHashMap.put("hr", HardCodeUtil.a(2131707775));
    jdField_b_of_type_JavaUtilHashMap.put("da", HardCodeUtil.a(2131707762));
    jdField_b_of_type_JavaUtilHashMap.put("nl", HardCodeUtil.a(2131707798));
    jdField_b_of_type_JavaUtilHashMap.put("fo", HardCodeUtil.a(2131707788));
    jdField_b_of_type_JavaUtilHashMap.put("fi", HardCodeUtil.a(2131707779));
    jdField_b_of_type_JavaUtilHashMap.put("fr", HardCodeUtil.a(2131707772));
    jdField_b_of_type_JavaUtilHashMap.put("gd", HardCodeUtil.a(2131707811));
    jdField_b_of_type_JavaUtilHashMap.put("de", HardCodeUtil.a(2131707763));
    jdField_b_of_type_JavaUtilHashMap.put("he", HardCodeUtil.a(2131707793));
    jdField_b_of_type_JavaUtilHashMap.put("hu", HardCodeUtil.a(2131707807));
    jdField_b_of_type_JavaUtilHashMap.put("id", HardCodeUtil.a(2131707789));
    jdField_b_of_type_JavaUtilHashMap.put("it", HardCodeUtil.a(2131707780));
    jdField_b_of_type_JavaUtilHashMap.put("kr", HardCodeUtil.a(2131707803));
    jdField_b_of_type_JavaUtilHashMap.put("lv", HardCodeUtil.a(2131707782));
    jdField_b_of_type_JavaUtilHashMap.put("mk", HardCodeUtil.a(2131707815));
    jdField_b_of_type_JavaUtilHashMap.put("mt", HardCodeUtil.a(2131707784));
    jdField_b_of_type_JavaUtilHashMap.put("no", HardCodeUtil.a(2131707771));
    jdField_b_of_type_JavaUtilHashMap.put("pt", HardCodeUtil.a(2131707795));
    jdField_b_of_type_JavaUtilHashMap.put("rm", HardCodeUtil.a(2131707778));
    jdField_b_of_type_JavaUtilHashMap.put("ro", HardCodeUtil.a(2131707776));
    jdField_b_of_type_JavaUtilHashMap.put("sr", HardCodeUtil.a(2131707800));
    jdField_b_of_type_JavaUtilHashMap.put("sk", HardCodeUtil.a(2131707802));
    jdField_b_of_type_JavaUtilHashMap.put("sb", HardCodeUtil.a(2131707761));
    jdField_b_of_type_JavaUtilHashMap.put("es", HardCodeUtil.a(2131707774));
    jdField_b_of_type_JavaUtilHashMap.put("sx", HardCodeUtil.a(2131707783));
    jdField_b_of_type_JavaUtilHashMap.put("sv", HardCodeUtil.a(2131707785));
    jdField_b_of_type_JavaUtilHashMap.put("ts", HardCodeUtil.a(2131707767));
    jdField_b_of_type_JavaUtilHashMap.put("tr", HardCodeUtil.a(2131707792));
    jdField_b_of_type_JavaUtilHashMap.put("ur", HardCodeUtil.a(2131707816));
    jdField_b_of_type_JavaUtilHashMap.put("vi", HardCodeUtil.a(2131707765));
    jdField_b_of_type_JavaUtilHashMap.put("ji", HardCodeUtil.a(2131707758));
    jdField_b_of_type_JavaUtilHashMap.put("sq", HardCodeUtil.a(2131707764));
    jdField_b_of_type_JavaUtilHashMap.put("bg", HardCodeUtil.a(2131707773));
    jdField_b_of_type_JavaUtilHashMap.put("ca", HardCodeUtil.a(2131707781));
    jdField_b_of_type_JavaUtilHashMap.put("cs", HardCodeUtil.a(2131707808));
    jdField_b_of_type_JavaUtilHashMap.put("et", HardCodeUtil.a(2131707806));
    jdField_b_of_type_JavaUtilHashMap.put("fa", HardCodeUtil.a(2131707804));
    jdField_b_of_type_JavaUtilHashMap.put("ga", HardCodeUtil.a(2131707801));
    jdField_b_of_type_JavaUtilHashMap.put("el", HardCodeUtil.a(2131707810));
    jdField_b_of_type_JavaUtilHashMap.put("hi", HardCodeUtil.a(2131707799));
    jdField_b_of_type_JavaUtilHashMap.put("is", HardCodeUtil.a(2131707760));
    jdField_b_of_type_JavaUtilHashMap.put("jp", HardCodeUtil.a(2131707814));
    jdField_b_of_type_JavaUtilHashMap.put("lt", HardCodeUtil.a(2131707790));
    jdField_b_of_type_JavaUtilHashMap.put("ms", HardCodeUtil.a(2131707759));
    jdField_b_of_type_JavaUtilHashMap.put("pl", HardCodeUtil.a(2131707769));
    jdField_b_of_type_JavaUtilHashMap.put("ru", HardCodeUtil.a(2131707766));
    jdField_b_of_type_JavaUtilHashMap.put("sz", HardCodeUtil.a(2131707791));
    jdField_b_of_type_JavaUtilHashMap.put("sl", HardCodeUtil.a(2131707797));
    jdField_b_of_type_JavaUtilHashMap.put("th", HardCodeUtil.a(2131707787));
    jdField_b_of_type_JavaUtilHashMap.put("tn", HardCodeUtil.a(2131707809));
    jdField_b_of_type_JavaUtilHashMap.put("uk", HardCodeUtil.a(2131707786));
    jdField_b_of_type_JavaUtilHashMap.put("ve", HardCodeUtil.a(2131707777));
    jdField_b_of_type_JavaUtilHashMap.put("xh", HardCodeUtil.a(2131707812));
    jdField_b_of_type_JavaUtilHashMap.put("zu", HardCodeUtil.a(2131707796));
  }
  
  public OcrControl(AppInterface paramAppInterface, OcrControl.OcrCallback paramOcrCallback, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl$OcrCallback = paramOcrCallback;
    this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload = new ARCloudFileUpload(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload.a();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqOcrApiIOCRService = ((IOCRService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IOCRService.class, ""));
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private ARCloudReqInfo a(String paramString)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        if (!TextUtils.isEmpty(paramString))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("req had been remove, sessionId:");
            localStringBuilder.append(paramString);
            QLog.d("Q.ocr.control", 2, localStringBuilder.toString());
          }
          paramString = (ARCloudReqInfo)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
          return paramString;
        }
      }
      paramString = null;
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
    //   10: ifnull +68 -> 78
    //   13: aload_1
    //   14: getfield 308	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokestatic 272	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +58 -> 78
    //   23: aload_0
    //   24: getfield 243	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   27: aload_1
    //   28: getfield 308	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   31: aload_1
    //   32: invokevirtual 39	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: invokestatic 278	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +39 -> 78
    //   42: new 280	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 281	java/lang/StringBuilder:<init>	()V
    //   49: astore_3
    //   50: aload_3
    //   51: ldc_w 310
    //   54: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_3
    //   59: aload_1
    //   60: getfield 308	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   63: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: ldc_w 289
    //   70: iconst_2
    //   71: aload_3
    //   72: invokevirtual 293	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 297	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_2
    //   79: monitorexit
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: astore_1
    //   84: aload_2
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	OcrControl
    //   0	93	1	paramARCloudReqInfo	ARCloudReqInfo
    //   6	79	2	localHashMap	HashMap
    //   49	23	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   13	78	83	finally
    //   78	80	83	finally
    //   84	86	83	finally
    //   2	9	88	finally
    //   86	88	88	finally
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
  
  public void a(ARCloudReqFileInfo paramARCloudReqFileInfo, String paramString)
  {
    try
    {
      ARCloudReqInfo localARCloudReqInfo = new ARCloudReqInfo();
      localARCloudReqInfo.jdField_a_of_type_JavaLangString = a();
      localARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo = paramARCloudReqFileInfo;
      localARCloudReqInfo.jdField_b_of_type_Int = 900000000;
      localARCloudReqInfo.jdField_a_of_type_Int = 900000000;
      localARCloudReqInfo.jdField_a_of_type_Long = 16L;
      localARCloudReqInfo.jdField_c_of_type_Int = 0;
      localARCloudReqInfo.jdField_b_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAppid());
      localARCloudReqInfo.jdField_b_of_type_Long = Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      localARCloudReqInfo.jdField_c_of_type_Long = System.currentTimeMillis();
      ARCloudReqOcrInfo localARCloudReqOcrInfo = new ARCloudReqOcrInfo();
      if (!TextUtils.isEmpty(paramString)) {
        localARCloudReqOcrInfo.jdField_a_of_type_JavaLangString = paramString;
      }
      localARCloudReqInfo.jdField_a_of_type_ComTencentMobileqqOcrARCloudReqOcrInfo = localARCloudReqOcrInfo;
      a(localARCloudReqInfo);
      paramString = localARCloudReqInfo.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new OcrControl.2(this, paramString), 3000L);
      if (this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload.a(localARCloudReqInfo, this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload$ARCloudFileUploadCallback)) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new OcrControl.3(this, paramString, paramARCloudReqFileInfo), 30000L);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl$OcrCallback.a(3, null, paramARCloudReqFileInfo.jdField_b_of_type_JavaLangString, 0L);
      }
      ThreadManager.post(new OcrControl.4(this, paramARCloudReqFileInfo), 5, null, false);
      return;
    }
    finally {}
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean, null);
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recogPic picPath:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",needCompress:");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.ocr.control", 2, localStringBuilder.toString());
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ocr_upload_thread");
        localStringBuilder.append(System.currentTimeMillis());
        this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread(localStringBuilder.toString(), 0);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload;
    if (localObject != null) {
      ((ARCloudFileUpload)localObject).a();
    }
    localObject = this.jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "Ocr control stop");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl
 * JD-Core Version:    0.7.0.1
 */