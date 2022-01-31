package org.junit.rules;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

@Deprecated
public class TestWatchman
  implements MethodRule
{
  public Statement apply(Statement paramStatement, FrameworkMethod paramFrameworkMethod, Object paramObject)
  {
    return new TestWatchman.1(this, paramFrameworkMethod, paramStatement);
  }
  
  public void failed(Throwable paramThrowable, FrameworkMethod paramFrameworkMethod) {}
  
  public void finished(FrameworkMethod paramFrameworkMethod) {}
  
  public void starting(FrameworkMethod paramFrameworkMethod) {}
  
  public void succeeded(FrameworkMethod paramFrameworkMethod) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.rules.TestWatchman
 * JD-Core Version:    0.7.0.1
 */