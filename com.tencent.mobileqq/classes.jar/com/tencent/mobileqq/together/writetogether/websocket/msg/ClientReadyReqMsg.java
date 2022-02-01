package com.tencent.mobileqq.together.writetogether.websocket.msg;

import java.lang.reflect.Type;

public class ClientReadyReqMsg
  extends BaseToWriteTogetherMsg<ClientReadyHeader, ClientReadyReqMsg.Body>
{
  public ClientReadyReqMsg() {}
  
  public ClientReadyReqMsg(String paramString1, String paramString2, long paramLong, int paramInt, String paramString3)
  {
    this.header = new ClientReadyHeader(paramString1, paramString2, paramLong, paramInt, paramString3);
    this.body = new ClientReadyReqMsg.Body();
  }
  
  Type getBodyType()
  {
    return ClientReadyReqMsg.Body.class;
  }
  
  Type getHeaderType()
  {
    return ClientReadyHeader.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.ClientReadyReqMsg
 * JD-Core Version:    0.7.0.1
 */