package com.tencent.turingfd.sdk.xq;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class public
  implements Runnable
{
  public public(AtomicBoolean paramAtomicBoolean, AtomicReference paramAtomicReference, long paramLong, Object paramObject) {}
  
  public void run()
  {
    if (this.Tf.get()) {
      return;
    }
    try
    {
      throw new Exception("");
    }
    catch (Exception localException)
    {
      ??? = final.get(final.of);
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
          this.Uf.set(Boolean.valueOf(true));
        }
        i += 1;
      }
      synchronized (this.Vf)
      {
        this.Vf.notify();
        return;
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.public
 * JD-Core Version:    0.7.0.1
 */