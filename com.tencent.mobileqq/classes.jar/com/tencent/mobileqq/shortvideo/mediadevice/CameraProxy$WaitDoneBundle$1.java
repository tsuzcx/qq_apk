package com.tencent.mobileqq.shortvideo.mediadevice;

import bcja;

public class CameraProxy$WaitDoneBundle$1
  implements Runnable
{
  public CameraProxy$WaitDoneBundle$1(bcja parambcja) {}
  
  public void run()
  {
    synchronized (this.this$0.a)
    {
      this.this$0.a.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.WaitDoneBundle.1
 * JD-Core Version:    0.7.0.1
 */