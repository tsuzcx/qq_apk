package org.aspectj.lang;

public class NoAspectBoundException
  extends RuntimeException
{
  Throwable cause;
  
  public NoAspectBoundException() {}
  
  public NoAspectBoundException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.NoAspectBoundException
 * JD-Core Version:    0.7.0.1
 */