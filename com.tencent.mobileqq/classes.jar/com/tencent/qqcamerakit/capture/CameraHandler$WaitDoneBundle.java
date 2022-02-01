package com.tencent.qqcamerakit.capture;

import android.os.Message;

public class CameraHandler$WaitDoneBundle
{
  public final Object a;
  public final Runnable a;
  
  CameraHandler$WaitDoneBundle()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaLangRunnable = new CameraHandler.WaitDoneBundle.1(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.CameraHandler.WaitDoneBundle
 * JD-Core Version:    0.7.0.1
 */