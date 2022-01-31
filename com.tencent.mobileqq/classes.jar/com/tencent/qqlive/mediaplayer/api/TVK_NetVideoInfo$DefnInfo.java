package com.tencent.qqlive.mediaplayer.api;

import java.io.Serializable;

public class TVK_NetVideoInfo$DefnInfo
  implements Serializable
{
  private static final long serialVersionUID = -1L;
  private String a;
  private String b;
  private int c;
  private int d;
  
  public String getmDefn()
  {
    return this.a;
  }
  
  public int getmDefnId()
  {
    return this.d;
  }
  
  public String getmDefnName()
  {
    return this.b;
  }
  
  public boolean isAudioOnly()
  {
    return "audio".equalsIgnoreCase(this.a);
  }
  
  public int isVip()
  {
    return this.c;
  }
  
  public void setVip(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setmDefn(String paramString)
  {
    this.a = paramString;
  }
  
  public void setmDefnId(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setmDefnName(String paramString)
  {
    this.b = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo.DefnInfo
 * JD-Core Version:    0.7.0.1
 */