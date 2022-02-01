package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

public class ClosedOutputStream
  extends OutputStream
{
  public static final ClosedOutputStream CLOSED_OUTPUT_STREAM = new ClosedOutputStream();
  
  public void flush()
  {
    throw new IOException("flush() failed: stream is closed");
  }
  
  public void write(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("write(");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(") failed: stream is closed");
    throw new IOException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.output.ClosedOutputStream
 * JD-Core Version:    0.7.0.1
 */