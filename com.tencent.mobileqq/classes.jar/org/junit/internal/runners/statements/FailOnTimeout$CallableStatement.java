package org.junit.internal.runners.statements;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import org.junit.runners.model.Statement;

class FailOnTimeout$CallableStatement
  implements Callable<Throwable>
{
  private final CountDownLatch startLatch = new CountDownLatch(1);
  
  private FailOnTimeout$CallableStatement(FailOnTimeout paramFailOnTimeout) {}
  
  public void awaitStarted()
  {
    this.startLatch.await();
  }
  
  public Throwable call()
  {
    try
    {
      this.startLatch.countDown();
      FailOnTimeout.access$600(this.this$0).evaluate();
      return null;
    }
    catch (Exception localException)
    {
      throw localException;
    }
    catch (Throwable localThrowable)
    {
      return localThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.junit.internal.runners.statements.FailOnTimeout.CallableStatement
 * JD-Core Version:    0.7.0.1
 */