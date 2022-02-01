package org.java_websocket.exceptions;

public class IncompleteException
  extends Exception
{
  private static final long serialVersionUID = 7330519489840500997L;
  private final int preferredSize;
  
  public IncompleteException(int paramInt)
  {
    this.preferredSize = paramInt;
  }
  
  public int getPreferredSize()
  {
    return this.preferredSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.java_websocket.exceptions.IncompleteException
 * JD-Core Version:    0.7.0.1
 */