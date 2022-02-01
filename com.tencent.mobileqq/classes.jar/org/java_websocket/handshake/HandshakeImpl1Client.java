package org.java_websocket.handshake;

public class HandshakeImpl1Client
  extends HandshakedataImpl1
  implements ClientHandshakeBuilder
{
  private String resourceDescriptor = "*";
  
  public String getResourceDescriptor()
  {
    return this.resourceDescriptor;
  }
  
  public void setResourceDescriptor(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("http resource descriptor must not be null");
    }
    this.resourceDescriptor = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.handshake.HandshakeImpl1Client
 * JD-Core Version:    0.7.0.1
 */