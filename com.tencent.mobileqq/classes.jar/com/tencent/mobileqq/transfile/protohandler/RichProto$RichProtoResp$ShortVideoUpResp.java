package com.tencent.mobileqq.transfile.protohandler;

public class RichProto$RichProtoResp$ShortVideoUpResp
  extends RichProto.RichProtoResp.RespCommon
{
  public String fileId;
  public boolean isExist;
  public long startOffset = 0L;
  public int videoAttr = 0;
  public int videoKandianType = 0;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" isExist:");
    localStringBuilder.append(this.isExist);
    localStringBuilder.append(" fileId:");
    localStringBuilder.append(this.fileId);
    localStringBuilder.append(" startOffset:");
    localStringBuilder.append(this.startOffset);
    localStringBuilder.append(" videoAttr:");
    localStringBuilder.append(this.videoAttr);
    localStringBuilder.append(" videoKandianType:");
    localStringBuilder.append(this.videoKandianType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoUpResp
 * JD-Core Version:    0.7.0.1
 */