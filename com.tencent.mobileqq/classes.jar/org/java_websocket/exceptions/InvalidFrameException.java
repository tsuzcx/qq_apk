package org.java_websocket.exceptions;

public class InvalidFrameException
  extends InvalidDataException
{
  private static final long serialVersionUID = -9016496369828887591L;
  
  public InvalidFrameException()
  {
    super(1002);
  }
  
  public InvalidFrameException(String paramString)
  {
    super(1002, paramString);
  }
  
  public InvalidFrameException(String paramString, Throwable paramThrowable)
  {
    super(1002, paramString, paramThrowable);
  }
  
  public InvalidFrameException(Throwable paramThrowable)
  {
    super(1002, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.exceptions.InvalidFrameException
 * JD-Core Version:    0.7.0.1
 */