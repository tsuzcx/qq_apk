package org.java_websocket.handshake;

public abstract interface ServerHandshakeBuilder
  extends HandshakeBuilder, ServerHandshake
{
  public abstract void setHttpStatus(short paramShort);
  
  public abstract void setHttpStatusMessage(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.handshake.ServerHandshakeBuilder
 * JD-Core Version:    0.7.0.1
 */