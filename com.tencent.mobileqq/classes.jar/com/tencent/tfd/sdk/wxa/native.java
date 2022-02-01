package com.tencent.tfd.sdk.wxa;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class native
  implements Runnable
{
  public native(AtomicBoolean paramAtomicBoolean, AtomicReference paramAtomicReference, long paramLong, Object paramObject) {}
  
  public void run()
  {
    if (this.kc.get()) {
      return;
    }
    try
    {
      throw new Exception("");
    }
    catch (Exception localException)
    {
      ??? = const.get(const.Ob);
      StackTraceElement[] arrayOfStackTraceElement = localException.getStackTrace();
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localStackTraceElement.getClassName());
        localStringBuilder.append("_");
        localStringBuilder.append(localStackTraceElement.getMethodName());
        if (((String)???).equals(localStringBuilder.toString())) {
          this.lc.set(Boolean.valueOf(true));
        }
        i += 1;
      }
      synchronized (this.mc)
      {
        this.mc.notify();
        return;
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.native
 * JD-Core Version:    0.7.0.1
 */