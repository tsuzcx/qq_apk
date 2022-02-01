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
    for (;;)
    {
      try
      {
        try
        {
          AsyncTimeout localAsyncTimeout = AsyncTimeout.awaitTimeout();
          if (localAsyncTimeout != null) {
            break label27;
          }
          continue;
        }
        finally {}
        continue;
      }
      catch (InterruptedException localInterruptedException) {}
      label27:
      if (localInterruptedException == AsyncTimeout.head)
      {
        AsyncTimeout.head = null;
        return;
      }
      localInterruptedException.timedOut();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okio.AsyncTimeout.Watchdog
 * JD-Core Version:    0.7.0.1
 */