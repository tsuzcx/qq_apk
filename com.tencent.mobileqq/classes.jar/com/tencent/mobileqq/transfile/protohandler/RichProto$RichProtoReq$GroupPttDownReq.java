package com.tencent.mobileqq.transfile.protohandler;

public class RichProto$RichProtoReq$GroupPttDownReq
  extends RichProto.RichProtoReq.ReqCommon
{
  public int downType;
  public long groupFileID;
  public String groupFileKey;
  public byte[] md5;
  public int voiceType;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" groupFileID:");
    localStringBuilder.append(this.groupFileID);
    localStringBuilder.append(" groupFileKey:");
    localStringBuilder.append(this.groupFileKey);
    localStringBuilder.append(" md5:");
    localStringBuilder.append(this.md5);
    localStringBuilder.append(" voiceType:");
    localStringBuilder.append(this.voiceType);
    localStringBuilder.append(" downType:");
    localStringBuilder.append(this.downType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.GroupPttDownReq
 * JD-Core Version:    0.7.0.1
 */