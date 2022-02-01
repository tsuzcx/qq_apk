package com.tencent.mobileqq.shortvideo.mediadevice;

import android.os.Message;

public class CameraProxy$WaitDoneBundle
{
  public final Object a;
  public final Runnable a;
  
  CameraProxy$WaitDoneBundle()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaLangRunnable = new CameraProxy.WaitDoneBundle.1(this);
  }
  
  static void a(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    if ((paramMessage.obj instanceof WaitDoneBundle)) {
      ((WaitDoneBundle)paramMessage.obj).jdField_a_of_type_JavaLangRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.WaitDoneBundle
 * JD-Core Version:    0.7.0.1
 */