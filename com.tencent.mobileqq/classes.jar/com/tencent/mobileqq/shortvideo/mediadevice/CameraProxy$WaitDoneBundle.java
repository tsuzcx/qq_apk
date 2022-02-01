package com.tencent.mobileqq.shortvideo.mediadevice;

import android.os.Message;

public class CameraProxy$WaitDoneBundle
{
  public final Runnable a = new CameraProxy.WaitDoneBundle.1(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.WaitDoneBundle
 * JD-Core Version:    0.7.0.1
 */