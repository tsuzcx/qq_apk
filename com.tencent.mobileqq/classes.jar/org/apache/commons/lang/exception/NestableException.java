package org.apache.commons.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class NestableException
  extends Exception
  implements Nestable
{
  private static final long serialVersionUID = 1L;
  private Throwable cause = null;
  protected NestableDelegate delegate = new NestableDelegate(this);
  
  public NestableException() {}
  
  public NestableException(String paramString)
  {
    super(paramString);
  }
  
  public NestableException(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.cause = paramThrowable;
  }
  
  public NestableException(Throwable paramThrowable)
  {
    this.cause = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.cause;
  }
  
  public String getMessage()
  {
    if (super.getMessage() != null) {
      return super.getMessage();
    }
    Throwable localThrowable = this.cause;
    if (localThrowable != null) {
      return localThrowable.toString();
    }
    return null;
  }
  
  public String getMessage(int paramInt)
  {
    if (paramInt == 0) {
      return super.getMessage();
    }
    return this.delegate.getMessage(paramInt);
  }
  
  public String[] getMessages()
  {
    return this.delegate.getMessages();
  }
  
  public Throwable getThrowable(int paramInt)
  {
    return this.delegate.getThrowable(paramInt);
  }
  
  public int getThrowableCount()
  {
    return this.delegate.getThrowableCount();
  }
  
  public Throwable[] getThrowables()
  {
    return this.delegate.getThrowables();
  }
  
  public int indexOfThrowable(Class paramClass)
  {
    return this.delegate.indexOfThrowable(paramClass, 0);
  }
  
  public int indexOfThrowable(Class paramClass, int paramInt)
  {
    return this.delegate.indexOfThrowable(paramClass, paramInt);
  }
  
  public final void printPartialStackTrace(PrintWriter paramPrintWriter)
  {
    super.printStackTrace(paramPrintWriter);
  }
  
  public void printStackTrace()
  {
    this.delegate.printStackTrace();
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    this.delegate.printStackTrace(paramPrintStream);
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    this.delegate.printStackTrace(paramPrintWriter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.exception.NestableException
 * JD-Core Version:    0.7.0.1
 */