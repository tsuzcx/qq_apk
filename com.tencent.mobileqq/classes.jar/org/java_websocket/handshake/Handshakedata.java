package org.java_websocket.handshake;

import java.util.Iterator;

public abstract interface Handshakedata
{
  public abstract byte[] getContent();
  
  public abstract String getFieldValue(String paramString);
  
  public abstract boolean hasFieldValue(String paramString);
  
  public abstract Iterator<String> iterateHttpFields();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.java_websocket.handshake.Handshakedata
 * JD-Core Version:    0.7.0.1
 */