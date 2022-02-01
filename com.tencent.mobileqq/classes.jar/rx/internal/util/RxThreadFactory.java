package rx.internal.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class RxThreadFactory
  extends AtomicLong
  implements ThreadFactory
{
  final String prefix;
  
  public RxThreadFactory(String paramString)
  {
    this.prefix = paramString;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.prefix);
    localStringBuilder.append(incrementAndGet());
    paramRunnable = new Thread(paramRunnable, localStringBuilder.toString());
    paramRunnable.setDaemon(true);
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.util.RxThreadFactory
 * JD-Core Version:    0.7.0.1
 */