package org.junit.rules;

import org.junit.runners.model.Statement;

class ExpectedException$ExpectedExceptionStatement
  extends Statement
{
  private final Statement next;
  
  public ExpectedException$ExpectedExceptionStatement(ExpectedException paramExpectedException, Statement paramStatement)
  {
    this.next = paramStatement;
  }
  
  public void evaluate()
  {
    try
    {
      this.next.evaluate();
      if (ExpectedException.access$100(this.this$0)) {
        ExpectedException.access$200(this.this$0);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      ExpectedException.access$000(this.this$0, localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.rules.ExpectedException.ExpectedExceptionStatement
 * JD-Core Version:    0.7.0.1
 */