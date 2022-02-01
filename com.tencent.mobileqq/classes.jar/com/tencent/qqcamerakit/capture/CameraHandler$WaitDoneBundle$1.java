package com.tencent.qqcamerakit.capture;

class CameraHandler$WaitDoneBundle$1
  implements Runnable
{
  CameraHandler$WaitDoneBundle$1(CameraHandler.WaitDoneBundle paramWaitDoneBundle) {}
  
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
 * Qualified Name:     com.tencent.qqcamerakit.capture.CameraHandler.WaitDoneBundle.1
 * JD-Core Version:    0.7.0.1
 */