package org.apache.commons.io.input;

import java.io.InputStream;

public class ClosedInputStream
  extends InputStream
{
  public static final ClosedInputStream CLOSED_INPUT_STREAM = new ClosedInputStream();
  
  public int read()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.ClosedInputStream
 * JD-Core Version:    0.7.0.1
 */