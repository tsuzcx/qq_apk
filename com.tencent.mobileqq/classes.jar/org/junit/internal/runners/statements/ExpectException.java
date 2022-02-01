package org.junit.internal.runners.statements;

import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.model.Statement;

public class ExpectException
  extends Statement
{
  private final Class<? extends Throwable> expected;
  private final Statement next;
  
  public ExpectException(Statement paramStatement, Class<? extends Throwable> paramClass)
  {
    this.next = paramStatement;
    this.expected = paramClass;
  }
  
  public void evaluate()
  {
    try
    {
      this.next.evaluate();
      i = 1;
    }
    catch (AssumptionViolatedException localAssumptionViolatedException)
    {
      throw localAssumptionViolatedException;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (!this.expected.isAssignableFrom(localThrowable.getClass()))
        {
          throw new Exception("Unexpected exception, expected<" + this.expected.getName() + "> but was<" + localThrowable.getClass().getName() + ">", localThrowable);
          return;
        }
        int i = 0;
      }
    }
    if (i != 0) {
      throw new AssertionError("Expected exception: " + this.expected.getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.junit.internal.runners.statements.ExpectException
 * JD-Core Version:    0.7.0.1
 */