package com.tencent.qqlive.tvkplayer.vinfo;

import java.io.Serializable;

public class TVKVideoInfo$ReferUrl
  implements Serializable
{
  private static final long serialVersionUID = -1L;
  private int dt;
  private int dtc;
  private TVKVideoInfo.HlsNode hlsNode;
  private String path;
  private int spPort;
  private String spip;
  private String url;
  private int vt;
  
  public int getDt()
  {
    return this.dt;
  }
  
  public int getDtc()
  {
    return this.dtc;
  }
  
  public TVKVideoInfo.HlsNode getHlsNode()
  {
    return this.hlsNode;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public int getSpPort()
  {
    return this.spPort;
  }
  
  public String getSpip()
  {
    return this.spip;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getVt()
  {
    return this.vt;
  }
  
  public void setDt(int paramInt)
  {
    this.dt = paramInt;
  }
  
  public void setDtc(int paramInt)
  {
    this.dtc = paramInt;
  }
  
  public void setHlsNode(TVKVideoInfo.HlsNode paramHlsNode)
  {
    this.hlsNode = paramHlsNode;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setSpPort(int paramInt)
  {
    this.spPort = paramInt;
  }
  
  public void setSpip(String paramString)
  {
    this.spip = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setVt(int paramInt)
  {
    this.vt = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo.ReferUrl
 * JD-Core Version:    0.7.0.1
 */