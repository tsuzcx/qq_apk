package org.libpag;

import android.os.Handler;
import android.os.Looper;

class SynchronizeHandler
  extends Handler
{
  public SynchronizeHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final boolean runSync(SynchronizeHandler.TimeoutRunnable paramTimeoutRunnable, long paramLong)
  {
    if (paramTimeoutRunnable != null)
    {
      if (paramLong >= 0L)
      {
        if (Looper.myLooper() == getLooper())
        {
          paramTimeoutRunnable.run();
          return true;
        }
        return new SynchronizeHandler.BlockingRunnable(paramTimeoutRunnable).postAndWait(this, paramLong);
      }
      throw new IllegalArgumentException("timeout must be non-negative");
    }
    throw new IllegalArgumentException("runnable must not be null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.libpag.SynchronizeHandler
 * JD-Core Version:    0.7.0.1
 */