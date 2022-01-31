package org.java_websocket.protocols;

public abstract interface IProtocol
{
  public abstract boolean acceptProvidedProtocol(String paramString);
  
  public abstract IProtocol copyInstance();
  
  public abstract String getProvidedProtocol();
  
  public abstract String toString();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.java_websocket.protocols.IProtocol
 * JD-Core Version:    0.7.0.1
 */