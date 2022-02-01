package com.tencent.turingfd.sdk.ams.ga;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class native
  implements Runnable
{
  public native(AtomicBoolean paramAtomicBoolean, AtomicReference paramAtomicReference, long paramLong, Object paramObject) {}
  
  public void run()
  {
    if (this.Ac.get()) {
      return;
    }
    try
    {
      throw new Exception("");
    }
    catch (Exception localException)
    {
      ??? = const.get(const.Rb);
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
          this.Bc.set(Boolean.valueOf(true));
        }
        i += 1;
      }
      synchronized (this.Cc)
      {
        this.Cc.notify();
        return;
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.native
 * JD-Core Version:    0.7.0.1
 */