package com.tencent.qqlive.mediaplayer.api;

import java.io.Serializable;

public class TVK_NetVideoInfo$RecommadInfo
  implements Serializable
{
  private static final long serialVersionUID = -1L;
  private String a;
  private String b;
  private String c;
  private boolean d;
  
  public String getmCid()
  {
    return this.b;
  }
  
  public String getmTargetId()
  {
    return this.c;
  }
  
  public String getmVid()
  {
    return this.a;
  }
  
  public boolean ismDanmuOpen()
  {
    return this.d;
  }
  
  public void setmCid(String paramString)
  {
    this.b = paramString;
  }
  
  public void setmDanmuOpen(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setmTargetId(String paramString)
  {
    this.c = ("targetid=" + paramString + "&type=2");
  }
  
  public void setmVid(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo.RecommadInfo
 * JD-Core Version:    0.7.0.1
 */