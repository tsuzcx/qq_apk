package com.tencent.mobileqq.shortvideo.mediadevice;

class CameraProxy$WaitDoneBundle$1
  implements Runnable
{
  CameraProxy$WaitDoneBundle$1(CameraProxy.WaitDoneBundle paramWaitDoneBundle) {}
  
  public void run()
  {
    synchronized (this.this$0.a)
    {
      this.this$0.a.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.WaitDoneBundle.1
 * JD-Core Version:    0.7.0.1
 */