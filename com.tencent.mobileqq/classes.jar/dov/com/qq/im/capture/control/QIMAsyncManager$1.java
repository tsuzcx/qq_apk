package dov.com.qq.im.capture.control;

import bmrl;

public class QIMAsyncManager$1
  implements Runnable
{
  public QIMAsyncManager$1(bmrl parambmrl) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      if (bmrl.access$000(this.this$0)) {
        return;
      }
      this.this$0.initIndeed();
      bmrl.access$002(this.this$0, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.control.QIMAsyncManager.1
 * JD-Core Version:    0.7.0.1
 */