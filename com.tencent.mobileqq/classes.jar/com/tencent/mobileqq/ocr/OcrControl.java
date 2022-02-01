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
  public static final HashMap<String, String> h = new HashMap();
  AppInterface a;
  ARCloudFileUpload b;
  HashMap<String, ARCloudReqInfo> c;
  IOCRService d;
  Handler e;
  int f;
  ARCloudFileUpload.ARCloudFileUploadCallback g = new OcrControl.5(this);
  private HandlerThread i;
  private Handler j;
  private Object k = new Object();
  private OcrControl.OcrCallback l;
  
  static
  {
    h.put("zh", HardCodeUtil.a(2131905608));
    h.put("en", HardCodeUtil.a(2131905627));
    h.put("af", HardCodeUtil.a(2131905631));
    h.put("ar", HardCodeUtil.a(2131905584));
    h.put("eu", HardCodeUtil.a(2131905619));
    h.put("be", HardCodeUtil.a(2131905582));
    h.put("hr", HardCodeUtil.a(2131905589));
    h.put("da", HardCodeUtil.a(2131905576));
    h.put("nl", HardCodeUtil.a(2131905612));
    h.put("fo", HardCodeUtil.a(2131905602));
    h.put("fi", HardCodeUtil.a(2131905593));
    h.put("fr", HardCodeUtil.a(2131905586));
    h.put("gd", HardCodeUtil.a(2131905625));
    h.put("de", HardCodeUtil.a(2131905577));
    h.put("he", HardCodeUtil.a(2131905607));
    h.put("hu", HardCodeUtil.a(2131905621));
    h.put("id", HardCodeUtil.a(2131905603));
    h.put("it", HardCodeUtil.a(2131905594));
    h.put("kr", HardCodeUtil.a(2131905617));
    h.put("lv", HardCodeUtil.a(2131905596));
    h.put("mk", HardCodeUtil.a(2131905629));
    h.put("mt", HardCodeUtil.a(2131905598));
    h.put("no", HardCodeUtil.a(2131905585));
    h.put("pt", HardCodeUtil.a(2131905609));
    h.put("rm", HardCodeUtil.a(2131905592));
    h.put("ro", HardCodeUtil.a(2131905590));
    h.put("sr", HardCodeUtil.a(2131905614));
    h.put("sk", HardCodeUtil.a(2131905616));
    h.put("sb", HardCodeUtil.a(2131905575));
    h.put("es", HardCodeUtil.a(2131905588));
    h.put("sx", HardCodeUtil.a(2131905597));
    h.put("sv", HardCodeUtil.a(2131905599));
    h.put("ts", HardCodeUtil.a(2131905581));
    h.put("tr", HardCodeUtil.a(2131905606));
    h.put("ur", HardCodeUtil.a(2131905630));
    h.put("vi", HardCodeUtil.a(2131905579));
    h.put("ji", HardCodeUtil.a(2131905572));
    h.put("sq", HardCodeUtil.a(2131905578));
    h.put("bg", HardCodeUtil.a(2131905587));
    h.put("ca", HardCodeUtil.a(2131905595));
    h.put("cs", HardCodeUtil.a(2131905622));
    h.put("et", HardCodeUtil.a(2131905620));
    h.put("fa", HardCodeUtil.a(2131905618));
    h.put("ga", HardCodeUtil.a(2131905615));
    h.put("el", HardCodeUtil.a(2131905624));
    h.put("hi", HardCodeUtil.a(2131905613));
    h.put("is", HardCodeUtil.a(2131905574));
    h.put("jp", HardCodeUtil.a(2131905628));
    h.put("lt", HardCodeUtil.a(2131905604));
    h.put("ms", HardCodeUtil.a(2131905573));
    h.put("pl", HardCodeUtil.a(2131905583));
    h.put("ru", HardCodeUtil.a(2131905580));
    h.put("sz", HardCodeUtil.a(2131905605));
    h.put("sl", HardCodeUtil.a(2131905611));
    h.put("th", HardCodeUtil.a(2131905601));
    h.put("tn", HardCodeUtil.a(2131905623));
    h.put("uk", HardCodeUtil.a(2131905600));
    h.put("ve", HardCodeUtil.a(2131905591));
    h.put("xh", HardCodeUtil.a(2131905626));
    h.put("zu", HardCodeUtil.a(2131905610));
  }
  
  public OcrControl(AppInterface paramAppInterface, OcrControl.OcrCallback paramOcrCallback, int paramInt)
  {
    this.a = paramAppInterface;
    this.l = paramOcrCallback;
    this.b = new ARCloudFileUpload(paramAppInterface);
    this.b.b();
    this.c = new HashMap();
    this.d = ((IOCRService)this.a.getRuntimeService(IOCRService.class, ""));
    this.e = new Handler();
    this.f = paramInt;
  }
  
  private ARCloudReqInfo a(String paramString)
  {
    for (;;)
    {
      synchronized (this.c)
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
          paramString = (ARCloudReqInfo)this.c.remove(paramString);
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
    //   3: getfield 253	com/tencent/mobileqq/ocr/OcrControl:c	Ljava/util/HashMap;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnull +68 -> 78
    //   13: aload_1
    //   14: getfield 317	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:a	Ljava/lang/String;
    //   17: invokestatic 282	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifne +58 -> 78
    //   23: aload_0
    //   24: getfield 253	com/tencent/mobileqq/ocr/OcrControl:c	Ljava/util/HashMap;
    //   27: aload_1
    //   28: getfield 317	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:a	Ljava/lang/String;
    //   31: aload_1
    //   32: invokevirtual 49	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   35: pop
    //   36: invokestatic 288	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +39 -> 78
    //   42: new 290	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 291	java/lang/StringBuilder:<init>	()V
    //   49: astore_3
    //   50: aload_3
    //   51: ldc_w 319
    //   54: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_3
    //   59: aload_1
    //   60: getfield 317	com/tencent/mobileqq/ar/arengine/ARCloudReqInfo:a	Ljava/lang/String;
    //   63: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: ldc_w 299
    //   70: iconst_2
    //   71: aload_3
    //   72: invokevirtual 303	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 306	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    synchronized (this.k)
    {
      if (this.j != null) {
        this.j.post(paramRunnable);
      }
      return;
    }
  }
  
  public void a()
  {
    synchronized (this.c)
    {
      this.c.clear();
      if (this.b != null) {
        this.b.c();
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
      localARCloudReqInfo.a = b();
      localARCloudReqInfo.b = paramARCloudReqFileInfo;
      localARCloudReqInfo.d = 900000000;
      localARCloudReqInfo.c = 900000000;
      localARCloudReqInfo.e = 16L;
      localARCloudReqInfo.f = 0;
      localARCloudReqInfo.o = String.valueOf(this.a.getAppid());
      localARCloudReqInfo.p = Long.parseLong(this.a.getCurrentAccountUin());
      localARCloudReqInfo.q = System.currentTimeMillis();
      ARCloudReqOcrInfo localARCloudReqOcrInfo = new ARCloudReqOcrInfo();
      if (!TextUtils.isEmpty(paramString)) {
        localARCloudReqOcrInfo.a = paramString;
      }
      localARCloudReqInfo.m = localARCloudReqOcrInfo;
      a(localARCloudReqInfo);
      paramString = localARCloudReqInfo.a;
      this.e.postDelayed(new OcrControl.2(this, paramString), 3000L);
      if (this.b.a(localARCloudReqInfo, this.g)) {
        this.e.postDelayed(new OcrControl.3(this, paramString, paramARCloudReqFileInfo), 30000L);
      } else {
        this.l.a(3, null, paramARCloudReqFileInfo.e, 0L);
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
  
  public String b()
  {
    return String.format("%s_%s_%05d", new Object[] { this.a.getCurrentAccountUin(), new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis())), Integer.valueOf(new Random().nextInt(100000)) });
  }
  
  public void c()
  {
    try
    {
      QLog.i("Q.ocr.control", 1, "startUploadThread.");
      if (this.i == null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ocr_upload_thread");
        localStringBuilder.append(System.currentTimeMillis());
        this.i = ThreadManager.newFreeHandlerThread(localStringBuilder.toString(), 0);
        this.i.start();
        this.j = new Handler(this.i.getLooper());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d()
  {
    try
    {
      QLog.i("Q.ocr.control", 1, "stopUploadThread.");
      if (this.j != null) {
        this.j.removeCallbacksAndMessages(null);
      }
      this.j = null;
      if (this.i != null)
      {
        this.i.quit();
        this.i.interrupt();
      }
      this.i = null;
      return;
    }
    finally {}
  }
  
  public void e()
  {
    c();
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "Ocr control start");
    }
  }
  
  public void f()
  {
    d();
    Object localObject = this.b;
    if (localObject != null) {
      ((ARCloudFileUpload)localObject).c();
    }
    localObject = this.c;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    this.e.removeCallbacksAndMessages(null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "Ocr control stop");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl
 * JD-Core Version:    0.7.0.1
 */