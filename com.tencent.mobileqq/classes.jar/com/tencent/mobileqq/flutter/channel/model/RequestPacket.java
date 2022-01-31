package com.tencent.mobileqq.flutter.channel.model;

import aryi;
import java.util.HashMap;
import java.util.Map;

public class RequestPacket
{
  public byte[] body;
  public String cmd;
  public Integer dataType;
  public HashMap extra;
  public Integer timeout;
  
  public static RequestPacket fromMap(Map paramMap)
  {
    return (RequestPacket)aryi.a(paramMap, RequestPacket.class);
  }
  
  public static Map toMap(RequestPacket paramRequestPacket)
  {
    return aryi.a(paramRequestPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.model.RequestPacket
 * JD-Core Version:    0.7.0.1
 */