package okio;

final class AsyncTimeout$Watchdog
  extends Thread
{
  public AsyncTimeout$Watchdog()
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
        AsyncTimeout localAsyncTimeout = AsyncTimeout.awaitTimeout();
        if (localAsyncTimeout != null) {
          localAsyncTimeout.timedOut();
        }
      }
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     okio.AsyncTimeout.Watchdog
 * JD-Core Version:    0.7.0.1
 */