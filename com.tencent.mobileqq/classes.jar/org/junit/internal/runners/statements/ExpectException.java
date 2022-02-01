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
      try
      {
        this.next.evaluate();
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        if (!this.expected.isAssignableFrom(localThrowable.getClass())) {
          break label73;
        }
      }
      int i = 0;
      if (i == 0) {
        return;
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Expected exception: ");
      localStringBuilder1.append(this.expected.getName());
      throw new AssertionError(localStringBuilder1.toString());
    }
    catch (AssumptionViolatedException localAssumptionViolatedException)
    {
      StringBuilder localStringBuilder1;
      label73:
      StringBuilder localStringBuilder2;
      throw localAssumptionViolatedException;
    }
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("Unexpected exception, expected<");
    localStringBuilder2.append(this.expected.getName());
    localStringBuilder2.append("> but was<");
    localStringBuilder2.append(localStringBuilder1.getClass().getName());
    localStringBuilder2.append(">");
    throw new Exception(localStringBuilder2.toString(), localStringBuilder1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.internal.runners.statements.ExpectException
 * JD-Core Version:    0.7.0.1
 */