package rx.exceptions;

import java.io.PrintWriter;

class CompositeException$WrappedPrintWriter
  extends CompositeException.PrintStreamOrWriter
{
  private final PrintWriter printWriter;
  
  CompositeException$WrappedPrintWriter(PrintWriter paramPrintWriter)
  {
    super(null);
    this.printWriter = paramPrintWriter;
  }
  
  Object lock()
  {
    return this.printWriter;
  }
  
  void println(Object paramObject)
  {
    this.printWriter.println(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.exceptions.CompositeException.WrappedPrintWriter
 * JD-Core Version:    0.7.0.1
 */