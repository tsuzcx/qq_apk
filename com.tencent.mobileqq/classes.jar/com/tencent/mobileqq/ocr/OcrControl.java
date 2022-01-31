package com.tencent.mobileqq.ocr;

import afoj;
import afon;
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
  public int a;
  Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ARCloudFileUpload.ARCloudFileUploadCallback jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload$ARCloudFileUploadCallback = new afon(this);
  ARCloudFileUpload jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload;
  public OCRManager a;
  private OcrControl.OcrCallback jdField_a_of_type_ComTencentMobileqqOcrOcrControl$OcrCallback;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  public HashMap a;
  private Handler b;
  
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
    //   3: getfield 48	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnull +60 -> 70
    //   13: aload_1
    //   14: getfield 112	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +50 -> 70
    //   23: aload_0
    //   24: getfield 48	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   27: aload_1
    //   28: getfield 112	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   31: aload_1
    //   32: invokevirtual 116	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +31 -> 70
    //   42: ldc 84
    //   44: iconst_2
    //   45: new 86	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   52: ldc 118
    //   54: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_1
    //   58: getfield 112	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   61: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: aload_2
    //   71: monitorexit
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: astore_1
    //   76: aload_2
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	OcrControl
    //   0	85	1	paramARCloudReqInfo	ARCloudReqInfo
    //   6	71	2	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   13	70	75	finally
    //   70	72	75	finally
    //   76	78	75	finally
    //   2	9	80	finally
    //   78	80	80	finally
  }
  
  private void a(Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.b != null) {
        this.b.post(paramRunnable);
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
  public void a(com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo paramARCloudReqFileInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 107	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo
    //   5: dup
    //   6: invokespecial 181	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:<init>	()V
    //   9: astore_2
    //   10: aload_2
    //   11: aload_0
    //   12: invokevirtual 183	com/tencent/mobileqq/ocr/OcrControl:a	()Ljava/lang/String;
    //   15: putfield 112	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: aload_2
    //   19: aload_1
    //   20: putfield 186	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo	Lcom/tencent/mobileqq/ar/arengine/ARCloudReqFileInfo;
    //   23: aload_2
    //   24: ldc 187
    //   26: putfield 189	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_b_of_type_Int	I
    //   29: aload_2
    //   30: ldc 187
    //   32: putfield 190	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_Int	I
    //   35: aload_2
    //   36: ldc2_w 191
    //   39: putfield 195	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_Long	J
    //   42: aload_2
    //   43: iconst_0
    //   44: putfield 198	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_c_of_type_Int	I
    //   47: aload_2
    //   48: aload_0
    //   49: getfield 32	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   52: invokevirtual 201	com/tencent/common/app/AppInterface:getAppid	()I
    //   55: invokestatic 204	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   58: putfield 206	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   61: aload_2
    //   62: aload_0
    //   63: getfield 32	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   66: invokevirtual 130	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   69: invokestatic 212	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   72: putfield 214	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_b_of_type_Long	J
    //   75: aload_2
    //   76: invokestatic 145	java/lang/System:currentTimeMillis	()J
    //   79: putfield 216	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_c_of_type_Long	J
    //   82: aload_0
    //   83: aload_2
    //   84: invokespecial 218	com/tencent/mobileqq/ocr/OcrControl:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudReqInfo;)V
    //   87: aload_2
    //   88: getfield 112	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   91: astore_3
    //   92: aload_0
    //   93: getfield 63	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   96: new 220	afok
    //   99: dup
    //   100: aload_0
    //   101: aload_3
    //   102: invokespecial 223	afok:<init>	(Lcom/tencent/mobileqq/ocr/OcrControl;Ljava/lang/String;)V
    //   105: ldc2_w 224
    //   108: invokevirtual 229	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   111: pop
    //   112: aload_0
    //   113: getfield 41	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload	Lcom/tencent/mobileqq/ar/arcloud/ARCloudFileUpload;
    //   116: aload_2
    //   117: aload_0
    //   118: getfield 30	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_ComTencentMobileqqArArcloudARCloudFileUpload$ARCloudFileUploadCallback	Lcom/tencent/mobileqq/ar/arcloud/ARCloudFileUpload$ARCloudFileUploadCallback;
    //   121: invokevirtual 232	com/tencent/mobileqq/ar/arcloud/ARCloudFileUpload:a	(Lcom/tencent/mobileqq/ar/arengine/ARCloudReqInfo;Lcom/tencent/mobileqq/ar/arcloud/ARCloudFileUpload$ARCloudFileUploadCallback;)Z
    //   124: ifeq +42 -> 166
    //   127: aload_0
    //   128: getfield 63	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   131: new 234	afol
    //   134: dup
    //   135: aload_0
    //   136: aload_3
    //   137: aload_1
    //   138: invokespecial 237	afol:<init>	(Lcom/tencent/mobileqq/ocr/OcrControl;Ljava/lang/String;Lcom/tencent/mobileqq/ar/arengine/ARCloudReqFileInfo;)V
    //   141: ldc2_w 238
    //   144: invokevirtual 229	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   147: pop
    //   148: new 241	afom
    //   151: dup
    //   152: aload_0
    //   153: aload_1
    //   154: invokespecial 244	afom:<init>	(Lcom/tencent/mobileqq/ocr/OcrControl;Lcom/tencent/mobileqq/ar/arengine/ARCloudReqFileInfo;)V
    //   157: iconst_5
    //   158: aconst_null
    //   159: iconst_0
    //   160: invokestatic 249	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   163: aload_0
    //   164: monitorexit
    //   165: return
    //   166: aload_0
    //   167: getfield 34	com/tencent/mobileqq/ocr/OcrControl:jdField_a_of_type_ComTencentMobileqqOcrOcrControl$OcrCallback	Lcom/tencent/mobileqq/ocr/OcrControl$OcrCallback;
    //   170: iconst_3
    //   171: aconst_null
    //   172: aload_1
    //   173: getfield 252	com/tencent/mobileqq/ar/arengine/ARCloudReqFileInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   176: lconst_0
    //   177: invokeinterface 257 6 0
    //   182: goto -34 -> 148
    //   185: astore_1
    //   186: aload_0
    //   187: monitorexit
    //   188: aload_1
    //   189: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	OcrControl
    //   0	190	1	paramARCloudReqFileInfo	com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo
    //   9	108	2	localARCloudReqInfo	ARCloudReqInfo
    //   91	46	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	148	185	finally
    //   148	163	185	finally
    //   166	182	185	finally
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "recogPic picPath:" + paramString + ",isCrop:" + paramBoolean);
    }
    a(new afoj(this, paramString, paramBoolean));
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
        this.b = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
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
      if (this.b != null) {
        this.b.removeCallbacksAndMessages(null);
      }
      this.b = null;
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