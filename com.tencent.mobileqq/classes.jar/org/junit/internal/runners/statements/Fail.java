package org.junit.internal.runners.statements;

import org.junit.runners.model.Statement;

public class Fail
  extends Statement
{
  private final Throwable error;
  
  public Fail(Throwable paramThrowable)
  {
    this.error = paramThrowable;
  }
  
  public void evaluate()
  {
    throw this.error;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.internal.runners.statements.Fail
 * JD-Core Version:    0.7.0.1
 */