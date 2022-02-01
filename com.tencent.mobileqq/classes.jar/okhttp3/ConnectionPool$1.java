package okhttp3;

class ConnectionPool$1
  implements Runnable
{
  ConnectionPool$1(ConnectionPool paramConnectionPool) {}
  
  public void run()
  {
    for (;;)
    {
      long l1 = this.this$0.cleanup(System.nanoTime());
      if (l1 == -1L) {
        return;
      }
      long l2;
      if (l1 > 0L) {
        l2 = l1 / 1000000L;
      }
      try
      {
        synchronized (this.this$0)
        {
          this.this$0.wait(l2, (int)(l1 - 1000000L * l2));
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        label65:
        break label65;
      }
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.ConnectionPool.1
 * JD-Core Version:    0.7.0.1
 */