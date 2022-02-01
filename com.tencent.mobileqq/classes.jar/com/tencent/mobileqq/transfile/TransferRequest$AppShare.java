package com.tencent.mobileqq.transfile;

public class TransferRequest$AppShare
{
  public long mAppShareID;
  public String mShareUrl;
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mAppShareID:");
    localStringBuilder2.append(this.mAppShareID);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mShareUrl:");
    localStringBuilder2.append(this.mShareUrl);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransferRequest.AppShare
 * JD-Core Version:    0.7.0.1
 */