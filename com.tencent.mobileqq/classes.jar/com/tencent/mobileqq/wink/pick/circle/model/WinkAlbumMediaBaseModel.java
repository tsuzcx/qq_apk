package com.tencent.mobileqq.wink.pick.circle.model;

import java.io.Serializable;

public class WinkAlbumMediaBaseModel
  implements Serializable
{
  private String mOriginPath;
  private String path;
  
  public WinkAlbumMediaBaseModel(String paramString)
  {
    this.path = paramString;
  }
  
  public String getOriginPath()
  {
    return this.mOriginPath;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public void setOriginPath(String paramString)
  {
    this.mOriginPath = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.model.WinkAlbumMediaBaseModel
 * JD-Core Version:    0.7.0.1
 */