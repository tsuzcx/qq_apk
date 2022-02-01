package dov.com.qq.im.capture.control;

class QIMAsyncManager$1
  implements Runnable
{
  QIMAsyncManager$1(QIMAsyncManager paramQIMAsyncManager) {}
  
  public void run()
  {
    synchronized (this.this$0)
    {
      if (QIMAsyncManager.access$000(this.this$0)) {
        return;
      }
      this.this$0.initIndeed();
      QIMAsyncManager.access$002(this.this$0, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.control.QIMAsyncManager.1
 * JD-Core Version:    0.7.0.1
 */