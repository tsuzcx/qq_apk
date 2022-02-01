package okio;

final class AsyncTimeout$Watchdog
  extends Thread
{
  AsyncTimeout$Watchdog()
  {
    super("Okio Watchdog");
    setDaemon(true);
  }
  
  public void run()
  {
    try
    {
      for (;;)
      {
        try
        {
          AsyncTimeout localAsyncTimeout = AsyncTimeout.awaitTimeout();
          if (localAsyncTimeout == null) {}
          if (localAsyncTimeout == AsyncTimeout.head)
          {
            AsyncTimeout.head = null;
            return;
          }
          localAsyncTimeout.timedOut();
        }
        finally
        {
          for (;;)
          {
            throw localObject;
          }
        }
      }
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.AsyncTimeout.Watchdog
 * JD-Core Version:    0.7.0.1
 */