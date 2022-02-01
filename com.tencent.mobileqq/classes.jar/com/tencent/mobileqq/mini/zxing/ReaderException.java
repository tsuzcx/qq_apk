package com.tencent.mobileqq.mini.zxing;

public abstract class ReaderException
  extends Exception
{
  protected static final StackTraceElement[] NO_TRACE = new StackTraceElement[0];
  protected static final boolean isStackTrace;
  
  static
  {
    boolean bool;
    if (System.getProperty("surefire.test.class.path") != null) {
      bool = true;
    } else {
      bool = false;
    }
    isStackTrace = bool;
  }
  
  ReaderException() {}
  
  ReaderException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public final Throwable fillInStackTrace()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.ReaderException
 * JD-Core Version:    0.7.0.1
 */