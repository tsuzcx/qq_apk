package junit.runner;

public abstract interface TestRunListener
{
  public static final int STATUS_ERROR = 1;
  public static final int STATUS_FAILURE = 2;
  
  public abstract void testEnded(String paramString);
  
  public abstract void testFailed(int paramInt, String paramString1, String paramString2);
  
  public abstract void testRunEnded(long paramLong);
  
  public abstract void testRunStarted(String paramString, int paramInt);
  
  public abstract void testRunStopped(long paramLong);
  
  public abstract void testStarted(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     junit.runner.TestRunListener
 * JD-Core Version:    0.7.0.1
 */