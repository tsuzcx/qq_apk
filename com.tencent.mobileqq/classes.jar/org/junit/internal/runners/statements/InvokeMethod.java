package org.junit.internal.runners.statements;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class InvokeMethod
  extends Statement
{
  private final Object target;
  private final FrameworkMethod testMethod;
  
  public InvokeMethod(FrameworkMethod paramFrameworkMethod, Object paramObject)
  {
    this.testMethod = paramFrameworkMethod;
    this.target = paramObject;
  }
  
  public void evaluate()
  {
    this.testMethod.invokeExplosively(this.target, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.internal.runners.statements.InvokeMethod
 * JD-Core Version:    0.7.0.1
 */