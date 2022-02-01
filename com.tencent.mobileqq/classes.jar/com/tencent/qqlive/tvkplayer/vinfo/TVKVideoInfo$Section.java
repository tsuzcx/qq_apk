package com.tencent.qqlive.tvkplayer.vinfo;

import java.io.Serializable;

public class TVKVideoInfo$Section
  implements Serializable
{
  private static final long serialVersionUID = -1L;
  private double duration;
  private int idx;
  private String indexName;
  private int size;
  private String vbkey;
  private String vbkeyId;
  
  public double getDuration()
  {
    return this.duration;
  }
  
  public int getIdx()
  {
    return this.idx;
  }
  
  public String getIndexName()
  {
    return this.indexName;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  public String getVbkey()
  {
    return this.vbkey;
  }
  
  public String getVbkeyId()
  {
    return this.vbkeyId;
  }
  
  public void setDuration(double paramDouble)
  {
    this.duration = paramDouble;
  }
  
  public void setIdx(int paramInt)
  {
    this.idx = paramInt;
  }
  
  public void setIndexName(String paramString)
  {
    this.indexName = paramString;
  }
  
  public void setIndexName(String paramString, int paramInt)
  {
    paramString = paramString.replace(".mp4", "");
    this.indexName = (paramString + "." + paramInt + ".mp4");
  }
  
  public void setSize(int paramInt)
  {
    this.size = paramInt;
  }
  
  public void setVbkey(String paramString)
  {
    this.vbkey = paramString;
  }
  
  public void setVbkeyId(String paramString)
  {
    this.vbkeyId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo.Section
 * JD-Core Version:    0.7.0.1
 */