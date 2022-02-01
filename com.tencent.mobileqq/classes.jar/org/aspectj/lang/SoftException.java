package org.aspectj.lang;

import java.io.PrintStream;
import java.io.PrintWriter;

public class SoftException
  extends RuntimeException
{
  private static final boolean HAVE_JAVA_14;
  Throwable inner;
  
  static
  {
    try
    {
      Class.forName("java.nio.Buffer");
      bool = true;
    }
    catch (Throwable localThrowable)
    {
      boolean bool;
      label11:
      break label11;
    }
    bool = false;
    HAVE_JAVA_14 = bool;
  }
  
  public SoftException(Throwable paramThrowable)
  {
    this.inner = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.inner;
  }
  
  public Throwable getWrappedThrowable()
  {
    return this.inner;
  }
  
  public void printStackTrace()
  {
    printStackTrace(System.err);
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    super.printStackTrace(paramPrintStream);
    Throwable localThrowable = this.inner;
    if ((!HAVE_JAVA_14) && (localThrowable != null))
    {
      paramPrintStream.print("Caused by: ");
      localThrowable.printStackTrace(paramPrintStream);
    }
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    super.printStackTrace(paramPrintWriter);
    Throwable localThrowable = this.inner;
    if ((!HAVE_JAVA_14) && (localThrowable != null))
    {
      paramPrintWriter.print("Caused by: ");
      localThrowable.printStackTrace(paramPrintWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.SoftException
 * JD-Core Version:    0.7.0.1
 */