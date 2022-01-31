package com.tencent.qqlive.tvkplayer.vinfo.live;

import java.util.Map;

public class TVKLiveInfoParams
{
  private Map<String, String> mExtraPara;
  private boolean mGetDlnaUrl = false;
  private boolean mGetPreviewInfo = false;
  private boolean mIsDolby = false;
  private int mStreamFormat = 2;
  
  public Map<String, String> getExtraPara()
  {
    return this.mExtraPara;
  }
  
  public boolean getPreviewInfo()
  {
    return this.mGetPreviewInfo;
  }
  
  public int getStreamFormat()
  {
    return this.mStreamFormat;
  }
  
  public boolean isDolby()
  {
    return this.mIsDolby;
  }
  
  public boolean isGetDlnaUrl()
  {
    return this.mGetDlnaUrl;
  }
  
  public void setDolby(boolean paramBoolean)
  {
    this.mIsDolby = paramBoolean;
  }
  
  public void setExtraPara(Map<String, String> paramMap)
  {
    this.mExtraPara = paramMap;
  }
  
  public void setGetDlnaUrl(boolean paramBoolean)
  {
    this.mGetDlnaUrl = paramBoolean;
  }
  
  public void setGetPreviewInfo(boolean paramBoolean)
  {
    this.mGetPreviewInfo = paramBoolean;
  }
  
  public void setStreamFormat(int paramInt)
  {
    this.mStreamFormat = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveInfoParams
 * JD-Core Version:    0.7.0.1
 */