package com.tencent.mobileqq.shortvideo.mediadevice;

import android.os.Handler;

public class CameraExceptionHandler
{
  public Handler a;
  public CameraExceptionHandler.Callback b;
  
  public CameraExceptionHandler(Handler paramHandler, CameraExceptionHandler.Callback paramCallback)
  {
    this.a = paramHandler;
    this.b = paramCallback;
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    this.a.post(new CameraExceptionHandler.1(this, paramRuntimeException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler
 * JD-Core Version:    0.7.0.1
 */