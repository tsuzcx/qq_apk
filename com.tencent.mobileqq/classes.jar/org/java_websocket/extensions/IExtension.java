package org.java_websocket.extensions;

import org.java_websocket.framing.Framedata;

public abstract interface IExtension
{
  public abstract boolean acceptProvidedExtensionAsClient(String paramString);
  
  public abstract boolean acceptProvidedExtensionAsServer(String paramString);
  
  public abstract IExtension copyInstance();
  
  public abstract void decodeFrame(Framedata paramFramedata);
  
  public abstract void encodeFrame(Framedata paramFramedata);
  
  public abstract String getProvidedExtensionAsClient();
  
  public abstract String getProvidedExtensionAsServer();
  
  public abstract void isFrameValid(Framedata paramFramedata);
  
  public abstract void reset();
  
  public abstract String toString();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.java_websocket.extensions.IExtension
 * JD-Core Version:    0.7.0.1
 */