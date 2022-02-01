package com.tencent.mobileqq.transfile;

public class TransferRequest$PicUpExtraInfo
{
  public boolean mIsRaw;
  public boolean mIsShareAppPic;
  public TransferRequest.AppShare mShareAppInfo;
  public int mUinType;
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mUinType:");
    localStringBuilder2.append(this.mUinType);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mIsRaw:");
    localStringBuilder2.append(this.mIsRaw);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mIsShareAppPic:");
    localStringBuilder2.append(this.mIsShareAppPic);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mShareAppInfo:{");
    localStringBuilder2.append(this.mShareAppInfo);
    localStringBuilder2.append("}");
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo
 * JD-Core Version:    0.7.0.1
 */