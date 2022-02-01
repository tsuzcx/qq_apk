package com.tencent.mobileqq.transfile;

import com.tencent.image.URLDrawableHandler;

public class TransferRequest$PicDownExtraInfo
{
  public URLDrawableHandler mHandler;
  public int mStartDownOffset;
  public String mUrlFromMsg;
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mUrlFromMsg:");
    localStringBuilder2.append(this.mUrlFromMsg);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(",mStartDownOffset:");
    localStringBuilder2.append(this.mStartDownOffset);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransferRequest.PicDownExtraInfo
 * JD-Core Version:    0.7.0.1
 */