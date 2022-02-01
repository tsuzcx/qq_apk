package com.tencent.turingfd.sdk.xq;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class package
  implements Runnable
{
  public package(AtomicBoolean paramAtomicBoolean, AtomicReference paramAtomicReference, long paramLong, Object paramObject) {}
  
  public void run()
  {
    if (this.a.get()) {
      return;
    }
    try
    {
      throw new Exception("");
    }
    catch (Exception localException)
    {
      ??? = import.a(import.G0);
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
          this.b.set(Boolean.TRUE);
        }
        i += 1;
      }
      synchronized (this.c)
      {
        this.c.notify();
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
 * Qualified Name:     com.tencent.turingfd.sdk.xq.package
 * JD-Core Version:    0.7.0.1
 */