package okhttp3;

class ConnectionPool$1
  implements Runnable
{
  ConnectionPool$1(ConnectionPool paramConnectionPool) {}
  
  public void run()
  {
    long l1;
    do
    {
      l1 = this.this$0.cleanup(System.nanoTime());
      if (l1 == -1L) {
        return;
      }
    } while (l1 <= 0L);
    long l2 = l1 / 1000000L;
    try
    {
      label57:
      synchronized (this.this$0)
      {
        this.this$0.wait(l2, (int)(l1 - l2 * 1000000L));
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.ConnectionPool.1
 * JD-Core Version:    0.7.0.1
 */