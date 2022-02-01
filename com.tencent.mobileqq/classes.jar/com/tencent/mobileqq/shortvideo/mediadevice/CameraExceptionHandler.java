package com.tencent.mobileqq.shortvideo.mediadevice;

import android.os.Handler;

public class CameraExceptionHandler
{
  public Handler a;
  public CameraExceptionHandler.Callback a;
  
  public CameraExceptionHandler(Handler paramHandler, CameraExceptionHandler.Callback paramCallback)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback = paramCallback;
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new CameraExceptionHandler.1(this, paramRuntimeException));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler
 * JD-Core Version:    0.7.0.1
 */