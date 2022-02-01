package com.tencent.mobileqq.flutter.channel.model;

import atkr;
import java.util.Map;

public class ResponsePacket
{
  public byte[] body;
  public Integer errCode;
  public Boolean isSuc;
  public RequestPacket request;
  
  public static ResponsePacket fromMap(Map paramMap)
  {
    return (ResponsePacket)atkr.a(paramMap, ResponsePacket.class);
  }
  
  public static Map toMap(ResponsePacket paramResponsePacket)
  {
    return atkr.a(paramResponsePacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.model.ResponsePacket
 * JD-Core Version:    0.7.0.1
 */