package com.tencent.thumbplayer.adapter.player;

public class TPUrlDataSource
{
  private String selfPlayerUrl;
  private String systemPlayerUrl;
  
  public TPUrlDataSource(String paramString)
  {
    this.systemPlayerUrl = paramString;
    this.selfPlayerUrl = paramString;
  }
  
  public String getSelfPlayerUrl()
  {
    return this.selfPlayerUrl;
  }
  
  public String getSystemPlayerUrl()
  {
    return this.systemPlayerUrl;
  }
  
  public void setSelfPlayerUrl(String paramString)
  {
    this.selfPlayerUrl = paramString;
  }
  
  public void setSystemPlayerUrl(String paramString)
  {
    this.systemPlayerUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.TPUrlDataSource
 * JD-Core Version:    0.7.0.1
 */