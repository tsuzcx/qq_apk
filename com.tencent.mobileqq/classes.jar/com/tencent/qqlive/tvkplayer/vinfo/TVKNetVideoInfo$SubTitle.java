package com.tencent.qqlive.tvkplayer.vinfo;

import java.io.Serializable;
import java.util.List;

public class TVKNetVideoInfo$SubTitle
  implements Serializable
{
  private float mCaptionBottomHPercent;
  private float mCaptionTopHPercent;
  private String mKeyId;
  private String mLang;
  private String mName;
  private String mSubTitle;
  private List<String> mUrlList;
  
  public float getCaptionBottomHPercent()
  {
    return this.mCaptionBottomHPercent;
  }
  
  public float getCaptionTopHPercent()
  {
    return this.mCaptionTopHPercent;
  }
  
  public List<String> getUrlList()
  {
    return this.mUrlList;
  }
  
  public String getmKeyId()
  {
    return this.mKeyId;
  }
  
  public String getmLang()
  {
    return this.mLang;
  }
  
  public String getmName()
  {
    return this.mName;
  }
  
  public String getmSubTitle()
  {
    return this.mSubTitle;
  }
  
  public void setCaptionBottomHPercent(float paramFloat)
  {
    this.mCaptionBottomHPercent = paramFloat;
  }
  
  public void setCaptionTopHPercent(float paramFloat)
  {
    this.mCaptionTopHPercent = paramFloat;
  }
  
  public void setUrlList(List<String> paramList)
  {
    this.mUrlList = paramList;
  }
  
  public void setmKeyId(String paramString)
  {
    this.mKeyId = paramString;
  }
  
  public void setmLang(String paramString)
  {
    this.mLang = paramString;
  }
  
  public void setmName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setmSubTitle(String paramString)
  {
    this.mSubTitle = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKNetVideoInfo.SubTitle
 * JD-Core Version:    0.7.0.1
 */