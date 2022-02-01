package com.tencent.mobileqq.transfile.protohandler;

public class RichProto$RichProtoReq$MultiMsgUpReq
  extends RichProto.RichProtoReq.ReqCommon
{
  public byte[] md5;
  public int multiMsgType;
  public long size;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" size:");
    localStringBuilder.append(this.size);
    localStringBuilder.append(" storeType:");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.MultiMsgUpReq
 * JD-Core Version:    0.7.0.1
 */