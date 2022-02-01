package com.tencent.mobileqq.flutter.channel.qqcircle;

import aumu;
import com.tencent.biz.qcircleshadow.local.requests.QCircleBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;

public class QCircleFlutterRequest
  extends QCircleBaseRequest
{
  protected String cmd;
  protected byte[] req;
  protected byte[] rsp;
  
  public QCircleFlutterRequest(String paramString, byte[] paramArrayOfByte)
  {
    this.cmd = paramString;
    this.req = paramArrayOfByte;
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    this.rsp = paramArrayOfByte;
    return new aumu(this);
  }
  
  public String getCmdName()
  {
    return this.cmd;
  }
  
  public byte[] getRequestByteData()
  {
    return this.req;
  }
  
  public byte[] getResponseByteData()
  {
    return this.rsp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.qqcircle.QCircleFlutterRequest
 * JD-Core Version:    0.7.0.1
 */