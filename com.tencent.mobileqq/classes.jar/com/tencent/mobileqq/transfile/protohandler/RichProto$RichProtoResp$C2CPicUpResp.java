package com.tencent.mobileqq.transfile.protohandler;

public class RichProto$RichProtoResp$C2CPicUpResp
  extends RichProto.RichProtoResp.RespCommon
{
  public int blockSize;
  public boolean isExist = false;
  public String mOriginalDownPara;
  public String mResid;
  public String mUkey;
  public String mUuid;
  public boolean networkChange = false;
  public long startOffset = 0L;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" mResid:");
    localStringBuilder.append(this.mResid);
    localStringBuilder.append(" isExist:");
    localStringBuilder.append(this.isExist);
    localStringBuilder.append(" blockSize:");
    localStringBuilder.append(this.blockSize);
    localStringBuilder.append(" netChg:");
    localStringBuilder.append(this.networkChange);
    localStringBuilder.append(" startOffset:");
    localStringBuilder.append(this.startOffset);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp
 * JD-Core Version:    0.7.0.1
 */