package com.tencent.mobileqq.ocr.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ocr.api.IOCRHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class OCRHandlerImpl
  implements IOCRHandler
{
  public static final String TAG = "OCRHandlerImpl";
  private AppRuntime mApp;
  private OCRHandler mOcrHandler;
  
  private OCRHandler getOcrHandler()
  {
    AppRuntime localAppRuntime = this.mApp;
    if ((localAppRuntime instanceof AppInterface)) {
      return (OCRHandler)((AppInterface)localAppRuntime).getBusinessHandler(OCRHandler.class.getName());
    }
    QLog.e("OCRHandlerImpl", 1, "[onCreate] error, not run in AppInterface!");
    return null;
  }
  
  public void batchTranslate(String paramString1, String paramString2, String paramString3)
  {
    OCRHandler localOCRHandler = this.mOcrHandler;
    if (localOCRHandler != null) {
      localOCRHandler.a(paramString1, paramString2, paramString3);
    }
  }
  
  public String getClassName()
  {
    return null;
  }
  
  public boolean getUSING_TEST_SERVERT()
  {
    return OCRHandler.c;
  }
  
  public void notifyUI(int paramInt, boolean paramBoolean, Object paramObject)
  {
    OCRHandler localOCRHandler = this.mOcrHandler;
    if (localOCRHandler != null) {
      localOCRHandler.notifyUI(paramInt, paramBoolean, paramObject);
    }
  }
  
  public void notifyUI(int paramInt, boolean paramBoolean1, Object paramObject, boolean paramBoolean2)
  {
    OCRHandler localOCRHandler = this.mOcrHandler;
    if (localOCRHandler != null) {
      localOCRHandler.notifyUI(paramInt, paramBoolean1, paramObject, paramBoolean2);
    }
  }
  
  public void notifyUI(ToServiceMsg paramToServiceMsg, int paramInt, boolean paramBoolean, Object paramObject)
  {
    OCRHandler localOCRHandler = this.mOcrHandler;
    if (localOCRHandler != null) {
      localOCRHandler.notifyUI(paramToServiceMsg, paramInt, paramBoolean, paramObject);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mOcrHandler = getOcrHandler();
  }
  
  public void onDestroy() {}
  
  public void send(ToServiceMsg paramToServiceMsg)
  {
    OCRHandler localOCRHandler = this.mOcrHandler;
    if (localOCRHandler != null) {
      localOCRHandler.send(paramToServiceMsg);
    }
  }
  
  public void sendPbReq(ToServiceMsg paramToServiceMsg)
  {
    OCRHandler localOCRHandler = this.mOcrHandler;
    if (localOCRHandler != null) {
      localOCRHandler.sendPbReq(paramToServiceMsg);
    }
  }
  
  public void setUSING_TEST_SERVERT(boolean paramBoolean)
  {
    OCRHandler.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.impl.OCRHandlerImpl
 * JD-Core Version:    0.7.0.1
 */