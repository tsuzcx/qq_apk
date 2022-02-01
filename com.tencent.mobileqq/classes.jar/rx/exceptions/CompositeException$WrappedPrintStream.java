package rx.exceptions;

import java.io.PrintStream;

class CompositeException$WrappedPrintStream
  extends CompositeException.PrintStreamOrWriter
{
  private final PrintStream printStream;
  
  CompositeException$WrappedPrintStream(PrintStream paramPrintStream)
  {
    super(null);
    this.printStream = paramPrintStream;
  }
  
  Object lock()
  {
    return this.printStream;
  }
  
  void println(Object paramObject)
  {
    this.printStream.println(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.exceptions.CompositeException.WrappedPrintStream
 * JD-Core Version:    0.7.0.1
 */