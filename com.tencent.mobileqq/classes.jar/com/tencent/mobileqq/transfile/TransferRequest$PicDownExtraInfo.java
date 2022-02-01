package com.tencent.mobileqq.transfile;

import com.tencent.image.URLDrawableHandler;

public class TransferRequest$PicDownExtraInfo
{
  public URLDrawableHandler mHandler;
  public int mStartDownOffset;
  public String mUrlFromMsg;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mUrlFromMsg:" + this.mUrlFromMsg);
    localStringBuilder.append(",mStartDownOffset:" + this.mStartDownOffset);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransferRequest.PicDownExtraInfo
 * JD-Core Version:    0.7.0.1
 */