package com.tencent.mobileqq.together.writetogether.websocket.msg;

import java.lang.reflect.Type;

public class ClientReadyRespMsg
  extends BaseToWriteTogetherMsg<ClientReadyHeader, OnPostWrapper>
{
  Type getBodyType()
  {
    return OnPostWrapper.class;
  }
  
  Type getHeaderType()
  {
    return ClientReadyHeader.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.websocket.msg.ClientReadyRespMsg
 * JD-Core Version:    0.7.0.1
 */