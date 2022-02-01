package com.tencent.mobileqq.transfile.protohandler;

public class RichProto$RichProtoReq$PttUpReq
  extends RichProto.RichProtoReq.ReqCommon
{
  public int audioPanelType;
  public int autoToText;
  public String fileName;
  public int fileSize;
  public boolean forceViaOffline = false;
  public byte[] md5;
  public int voiceLength;
  public int voiceType;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" name:");
    localStringBuilder.append(this.fileName);
    localStringBuilder.append(" size:");
    localStringBuilder.append(this.fileSize);
    localStringBuilder.append(" voiceLength:");
    localStringBuilder.append(this.voiceLength);
    localStringBuilder.append(" autoToText:");
    localStringBuilder.append(this.autoToText);
    localStringBuilder.append(" type:").append(this.voiceType).append(" audioPanel:").append(this.audioPanelType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PttUpReq
 * JD-Core Version:    0.7.0.1
 */