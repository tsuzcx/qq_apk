package org.java_websocket.handshake;

public abstract interface ServerHandshake
  extends Handshakedata
{
  public abstract short getHttpStatus();
  
  public abstract String getHttpStatusMessage();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.java_websocket.handshake.ServerHandshake
 * JD-Core Version:    0.7.0.1
 */