package org.java_websocket.exceptions;

public class IncompleteHandshakeException
  extends RuntimeException
{
  private static final long serialVersionUID = 7906596804233893092L;
  private final int preferredSize;
  
  public IncompleteHandshakeException()
  {
    this.preferredSize = 0;
  }
  
  public IncompleteHandshakeException(int paramInt)
  {
    this.preferredSize = paramInt;
  }
  
  public int getPreferredSize()
  {
    return this.preferredSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.java_websocket.exceptions.IncompleteHandshakeException
 * JD-Core Version:    0.7.0.1
 */