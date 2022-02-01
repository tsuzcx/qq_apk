package com.tencent.mobileqq.transfile;

public class SmartPttTranHelper$PttSliceInfoBean
{
  public int chatType;
  public int encodeType;
  public String filePath;
  public boolean isLast;
  public boolean isfirst;
  public String md5;
  public int offset;
  public int vegNum;
  public int vegPos;
  public String voiceId;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PttSliceInfoBean{encodeType=");
    localStringBuilder.append(this.encodeType);
    localStringBuilder.append(", isfirst=");
    localStringBuilder.append(this.isfirst);
    localStringBuilder.append(", isLast=");
    localStringBuilder.append(this.isLast);
    localStringBuilder.append(", voiceId='");
    localStringBuilder.append(this.voiceId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", offset=");
    localStringBuilder.append(this.offset);
    localStringBuilder.append(", vegPos='");
    localStringBuilder.append(this.vegPos);
    localStringBuilder.append('\'');
    localStringBuilder.append(", md5='");
    localStringBuilder.append(this.md5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", chatType='");
    localStringBuilder.append(this.chatType);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.SmartPttTranHelper.PttSliceInfoBean
 * JD-Core Version:    0.7.0.1
 */