package com.tencent.mobileqq.flutter.channel.sso;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import expand.network.gateway.SSOUpStream;
import expand.network.gateway.SSOUpStreamHead;

public class GateWayRequest
  extends NetworkRequest
{
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public String a()
  {
    return "QQExpand.Test.Debug";
  }
  
  public byte[] a()
  {
    gateway.SSOUpStream localSSOUpStream = new gateway.SSOUpStream();
    localSSOUpStream.head = new gateway.SSOUpStreamHead();
    localSSOUpStream.body.set(ByteStringMicro.copyFromUtf8("test"));
    return localSSOUpStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.sso.GateWayRequest
 * JD-Core Version:    0.7.0.1
 */