package org.apache.commons.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public abstract interface Nestable
{
  public abstract Throwable getCause();
  
  public abstract String getMessage();
  
  public abstract String getMessage(int paramInt);
  
  public abstract String[] getMessages();
  
  public abstract Throwable getThrowable(int paramInt);
  
  public abstract int getThrowableCount();
  
  public abstract Throwable[] getThrowables();
  
  public abstract int indexOfThrowable(Class paramClass);
  
  public abstract int indexOfThrowable(Class paramClass, int paramInt);
  
  public abstract void printPartialStackTrace(PrintWriter paramPrintWriter);
  
  public abstract void printStackTrace(PrintStream paramPrintStream);
  
  public abstract void printStackTrace(PrintWriter paramPrintWriter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.exception.Nestable
 * JD-Core Version:    0.7.0.1
 */