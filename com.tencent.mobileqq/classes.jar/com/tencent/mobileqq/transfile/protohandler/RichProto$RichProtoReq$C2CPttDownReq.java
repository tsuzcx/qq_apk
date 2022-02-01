package com.tencent.mobileqq.transfile.protohandler;

public class RichProto$RichProtoReq$C2CPttDownReq
  extends RichProto.RichProtoReq.ReqCommon
{
  public int autoToText;
  public int busiType;
  public int downType;
  public boolean isSelfSend;
  public String storageSource;
  public String uuid;
  public int voiceType;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" uuid:");
    localStringBuilder.append(this.uuid);
    localStringBuilder.append(" storageSource:");
    localStringBuilder.append(this.storageSource);
    localStringBuilder.append(" isSelfSend:");
    localStringBuilder.append(this.isSelfSend);
    localStringBuilder.append(" voiceType:");
    localStringBuilder.append(this.voiceType);
    localStringBuilder.append(" busiType:");
    localStringBuilder.append(this.busiType);
    localStringBuilder.append(" downType:");
    localStringBuilder.append(this.downType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.C2CPttDownReq
 * JD-Core Version:    0.7.0.1
 */