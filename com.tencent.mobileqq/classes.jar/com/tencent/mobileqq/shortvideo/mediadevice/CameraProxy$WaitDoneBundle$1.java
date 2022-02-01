package com.tencent.mobileqq.shortvideo.mediadevice;

class CameraProxy$WaitDoneBundle$1
  implements Runnable
{
  CameraProxy$WaitDoneBundle$1(CameraProxy.WaitDoneBundle paramWaitDoneBundle) {}
  
  public void run()
  {
    synchronized (this.this$0.b)
    {
      this.this$0.b.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy.WaitDoneBundle.1
 * JD-Core Version:    0.7.0.1
 */