package com.tencent.mobileqq.transfile.protohandler;

public class RichProto$RichProtoReq$MultiMsgDownReq
  extends RichProto.RichProtoReq.ReqCommon
{
  public byte[] msgResId;
  public int multiMsgType;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" msgResId:");
    localStringBuilder.append(this.msgResId);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.MultiMsgDownReq
 * JD-Core Version:    0.7.0.1
 */