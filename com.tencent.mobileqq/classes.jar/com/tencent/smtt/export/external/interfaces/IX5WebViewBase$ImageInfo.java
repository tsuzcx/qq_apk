package com.tencent.smtt.export.external.interfaces;

public class IX5WebViewBase$ImageInfo
{
  public boolean mIsGif;
  public String mPicUrl;
  public long mRawDataSize;
  
  public long getPicSize()
  {
    return this.mRawDataSize;
  }
  
  public String getPicUrl()
  {
    return this.mPicUrl;
  }
  
  public boolean isGif()
  {
    return this.mIsGif;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5WebViewBase.ImageInfo
 * JD-Core Version:    0.7.0.1
 */