package com.tencent.qqlive.tvkplayer.vinfo;

import java.io.Serializable;

public class TVKNetVideoInfo$DefnInfo
  implements Serializable, Cloneable
{
  private static final long serialVersionUID = -1L;
  private int drm;
  private int isVip;
  private int mAudioCodec;
  private String mDefn;
  private int mDefnId;
  private String mDefnName;
  private String mDefnRate;
  private String mDefnShowName;
  private long mFileSize;
  private int mHdr10EnHance;
  private int mVideoCodec;
  
  public Object clone()
  {
    try
    {
      DefnInfo localDefnInfo = (DefnInfo)super.clone();
      return localDefnInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public int getAudioCodec()
  {
    return this.mAudioCodec;
  }
  
  public String getDefn()
  {
    return this.mDefn;
  }
  
  public int getDefnId()
  {
    return this.mDefnId;
  }
  
  public String getDefnName()
  {
    return this.mDefnName;
  }
  
  public String getDefnRate()
  {
    return this.mDefnRate;
  }
  
  public String getDefnShowName()
  {
    return this.mDefnShowName;
  }
  
  public int getDrm()
  {
    return this.drm;
  }
  
  public long getFileSize()
  {
    return this.mFileSize;
  }
  
  public String getFnName()
  {
    return this.mDefnName;
  }
  
  public int getHdr10EnHance()
  {
    return this.mHdr10EnHance;
  }
  
  public int getVideoCodec()
  {
    return this.mVideoCodec;
  }
  
  public boolean isAudioOnly()
  {
    return "audio".equalsIgnoreCase(this.mDefn);
  }
  
  public int isVip()
  {
    return this.isVip;
  }
  
  public void setAudioCodec(int paramInt)
  {
    this.mAudioCodec = paramInt;
  }
  
  public void setDefn(String paramString)
  {
    this.mDefn = paramString;
  }
  
  public void setDefnId(int paramInt)
  {
    this.mDefnId = paramInt;
  }
  
  public void setDefnName(String paramString)
  {
    this.mDefnName = paramString;
  }
  
  public void setDefnRate(String paramString)
  {
    this.mDefnRate = paramString;
  }
  
  public void setDefnShowName(String paramString)
  {
    this.mDefnShowName = paramString;
  }
  
  public void setDrm(int paramInt)
  {
    this.drm = paramInt;
  }
  
  public void setFileSize(long paramLong)
  {
    this.mFileSize = paramLong;
  }
  
  public void setFnName(String paramString)
  {
    this.mDefnName = paramString;
  }
  
  public void setHdr10EnHance(int paramInt)
  {
    this.mHdr10EnHance = paramInt;
  }
  
  public void setVideoCodec(int paramInt)
  {
    this.mVideoCodec = paramInt;
  }
  
  public void setVip(int paramInt)
  {
    this.isVip = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKNetVideoInfo.DefnInfo
 * JD-Core Version:    0.7.0.1
 */