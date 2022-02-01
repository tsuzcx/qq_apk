package junit.framework;

public abstract interface TestListener
{
  public abstract void addError(Test paramTest, Throwable paramThrowable);
  
  public abstract void addFailure(Test paramTest, AssertionFailedError paramAssertionFailedError);
  
  public abstract void endTest(Test paramTest);
  
  public abstract void startTest(Test paramTest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     junit.framework.TestListener
 * JD-Core Version:    0.7.0.1
 */