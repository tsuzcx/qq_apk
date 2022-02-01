package com.tencent.mobileqq.transfile;

public class TransferRequest$PicUpExtraInfo
{
  public boolean mIsRaw;
  public boolean mIsShareAppPic;
  public TransferRequest.AppShare mShareAppInfo;
  public int mUinType;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mUinType:" + this.mUinType);
    localStringBuilder.append(",mIsRaw:" + this.mIsRaw);
    localStringBuilder.append(",mIsShareAppPic:" + this.mIsShareAppPic);
    localStringBuilder.append(",mShareAppInfo:{" + this.mShareAppInfo + "}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransferRequest.PicUpExtraInfo
 * JD-Core Version:    0.7.0.1
 */