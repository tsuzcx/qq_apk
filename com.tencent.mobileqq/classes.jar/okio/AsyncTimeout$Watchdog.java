package okio;

import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "()V", "run", "", "okio"}, k=1, mv={1, 1, 16})
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
        AsyncTimeout localAsyncTimeout = (AsyncTimeout)null;
        try
        {
          localAsyncTimeout = AsyncTimeout.Companion.awaitTimeout$okio();
          if (localAsyncTimeout == AsyncTimeout.access$getHead$cp())
          {
            AsyncTimeout.access$setHead$cp((AsyncTimeout)null);
            return;
          }
          Unit localUnit = Unit.INSTANCE;
          if (localAsyncTimeout != null) {
            localAsyncTimeout.timedOut();
          }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.AsyncTimeout.Watchdog
 * JD-Core Version:    0.7.0.1
 */