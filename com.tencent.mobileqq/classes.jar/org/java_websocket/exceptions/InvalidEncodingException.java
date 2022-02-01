package org.java_websocket.exceptions;

import java.io.UnsupportedEncodingException;

public class InvalidEncodingException
  extends RuntimeException
{
  private final UnsupportedEncodingException encodingException;
  
  public InvalidEncodingException(UnsupportedEncodingException paramUnsupportedEncodingException)
  {
    if (paramUnsupportedEncodingException != null)
    {
      this.encodingException = paramUnsupportedEncodingException;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public UnsupportedEncodingException getEncodingException()
  {
    return this.encodingException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.java_websocket.exceptions.InvalidEncodingException
 * JD-Core Version:    0.7.0.1
 */