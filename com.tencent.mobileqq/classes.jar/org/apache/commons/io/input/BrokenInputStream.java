package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

public class BrokenInputStream
  extends InputStream
{
  private final IOException exception;
  
  public BrokenInputStream()
  {
    this(new IOException("Broken input stream"));
  }
  
  public BrokenInputStream(IOException paramIOException)
  {
    this.exception = paramIOException;
  }
  
  public int available()
  {
    throw this.exception;
  }
  
  public void close()
  {
    throw this.exception;
  }
  
  public int read()
  {
    throw this.exception;
  }
  
  public void reset()
  {
    try
    {
      throw this.exception;
    }
    finally {}
  }
  
  public long skip(long paramLong)
  {
    throw this.exception;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.BrokenInputStream
 * JD-Core Version:    0.7.0.1
 */