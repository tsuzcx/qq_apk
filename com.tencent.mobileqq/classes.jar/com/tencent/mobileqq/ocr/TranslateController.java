package com.tencent.mobileqq.ocr;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload;
import com.tencent.mobileqq.ocr.api.IOCRHandler;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import java.util.HashMap;

public class TranslateController
{
  HashMap<String, TranslateController.ImageTranslateTask> a;
  private ARCloudFileUpload b;
  private HandlerThread c;
  private Handler d;
  private QQAppInterface e;
  private IOCRHandler f;
  
  public TranslateController(QQAppInterface paramQQAppInterface)
  {
    this.e = paramQQAppInterface;
    this.b = new ARCloudFileUpload(paramQQAppInterface);
    this.b.b();
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("TranslateFileUpload_");
    paramQQAppInterface.append(System.currentTimeMillis());
    this.c = new HandlerThread(paramQQAppInterface.toString());
    this.c.start();
    this.d = new Handler(this.c.getLooper());
    this.a = new HashMap();
    this.f = ((IOCRHandler)this.e.getRuntimeService(IOCRHandler.class, ""));
  }
  
  private void a(boolean paramBoolean, String paramString, TranslateResult arg3)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.f != null)
    {
      if (??? != null) {
        ???.e = paramString;
      }
      this.f.notifyUI(2, paramBoolean, new Object[] { Integer.valueOf(2), ??? });
      synchronized (this.a)
      {
        this.a.remove(paramString);
        return;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    IOCRHandler localIOCRHandler = this.f;
    if (localIOCRHandler != null) {
      localIOCRHandler.batchTranslate(paramString1, paramString2, paramString3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.TranslateController
 * JD-Core Version:    0.7.0.1
 */