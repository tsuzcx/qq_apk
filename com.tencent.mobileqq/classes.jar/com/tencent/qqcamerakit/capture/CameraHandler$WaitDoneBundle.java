package com.tencent.qqcamerakit.capture;

import android.os.Message;

public class CameraHandler$WaitDoneBundle
{
  public final Runnable a = new CameraHandler.WaitDoneBundle.1(this);
  public final Object b = new Object();
  
  static void a(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    if ((paramMessage.obj instanceof WaitDoneBundle)) {
      ((WaitDoneBundle)paramMessage.obj).a.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.CameraHandler.WaitDoneBundle
 * JD-Core Version:    0.7.0.1
 */