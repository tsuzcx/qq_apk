package com.tencent.mobileqq.transfile.protohandler;

import java.util.Arrays;

public class RichProto$RichProtoReq$GuildPicDownReq
  extends RichProto.RichProtoReq.ReqCommon
{
  public int fileType;
  public long groupFileID;
  public byte[] index;
  public byte[] md5;
  public int msgTime;
  public int protocolType;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GuildPicDownReq{groupFileID=");
    localStringBuilder.append(this.groupFileID);
    localStringBuilder.append(", md5=");
    localStringBuilder.append(Arrays.toString(this.md5));
    localStringBuilder.append(", index=");
    localStringBuilder.append(Arrays.toString(this.index));
    localStringBuilder.append(", fileType=");
    localStringBuilder.append(this.fileType);
    localStringBuilder.append(", msgTime=");
    localStringBuilder.append(this.msgTime);
    localStringBuilder.append(", protocolType=");
    localStringBuilder.append(this.protocolType);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.GuildPicDownReq
 * JD-Core Version:    0.7.0.1
 */