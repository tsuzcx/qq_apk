package dov.com.qq.im.capture.control;

import bpmq;

public class QIMAsyncManager$1
  implements Runnable
{
  public QIMAsyncManager$1(bpmq parambpmq) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      if (bpmq.a(this.this$0)) {
        return;
      }
      this.this$0.d();
      bpmq.a(this.this$0, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.control.QIMAsyncManager.1
 * JD-Core Version:    0.7.0.1
 */