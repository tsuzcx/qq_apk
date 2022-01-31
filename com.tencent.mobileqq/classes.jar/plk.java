import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class plk
  implements ThreadFactory
{
  private final AtomicInteger a = new AtomicInteger(1);
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "AsyncTask :" + this.a.getAndIncrement());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     plk
 * JD-Core Version:    0.7.0.1
 */