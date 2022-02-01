package org.java_websocket.handshake;

public class HandshakeImpl1Server
  extends HandshakedataImpl1
  implements ServerHandshakeBuilder
{
  private short httpstatus;
  private String httpstatusmessage;
  
  public short getHttpStatus()
  {
    return this.httpstatus;
  }
  
  public String getHttpStatusMessage()
  {
    return this.httpstatusmessage;
  }
  
  public void setHttpStatus(short paramShort)
  {
    this.httpstatus = paramShort;
  }
  
  public void setHttpStatusMessage(String paramString)
  {
    this.httpstatusmessage = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.java_websocket.handshake.HandshakeImpl1Server
 * JD-Core Version:    0.7.0.1
 */