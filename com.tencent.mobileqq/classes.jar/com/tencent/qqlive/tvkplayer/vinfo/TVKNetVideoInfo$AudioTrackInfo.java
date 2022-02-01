package com.tencent.qqlive.tvkplayer.vinfo;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;

public class TVKNetVideoInfo$AudioTrackInfo
  implements Serializable
{
  public static final int AAC = 1;
  public static final int DOLBY_ATMOS = 3;
  public static final int DOLBY_SURROUND = 2;
  private static final long serialVersionUID = -1L;
  private String mAction = null;
  private String mAudioPlayUrl = null;
  private long mAudioPrePlayTime;
  private String mAudioShowName;
  private String mAudioTrack;
  private int mAudioType;
  private ArrayList<String> mAudioUrlList = null;
  private int mIsVip;
  private String mKeyId;
  
  public String getAction()
  {
    return this.mAction;
  }
  
  public String getAudioPlayUrl()
  {
    return this.mAudioPlayUrl;
  }
  
  public long getAudioPrePlayTime()
  {
    return this.mAudioPrePlayTime;
  }
  
  public String getAudioShowName()
  {
    return this.mAudioShowName;
  }
  
  public String getAudioTrack()
  {
    return this.mAudioTrack;
  }
  
  public int getAudioType()
  {
    return this.mAudioType;
  }
  
  public ArrayList<String> getAudioUrlList()
  {
    return this.mAudioUrlList;
  }
  
  public String getKeyId()
  {
    return this.mKeyId;
  }
  
  public boolean isSameAudio(AudioTrackInfo paramAudioTrackInfo)
  {
    return ((paramAudioTrackInfo == null) && (TextUtils.isEmpty(this.mAudioTrack))) || ((paramAudioTrackInfo != null) && (TextUtils.isEmpty(paramAudioTrackInfo.getAudioTrack())) && (TextUtils.isEmpty(this.mAudioTrack))) || ((paramAudioTrackInfo != null) && (this.mAudioTrack != null) && (this.mAudioTrack.equals(paramAudioTrackInfo.getAudioTrack())));
  }
  
  public int isVip()
  {
    return this.mIsVip;
  }
  
  public void setAction(String paramString)
  {
    this.mAction = paramString;
  }
  
  public void setAudioPrePlayTime(long paramLong)
  {
    this.mAudioPrePlayTime = paramLong;
  }
  
  public void setAudioShowName(String paramString)
  {
    this.mAudioShowName = paramString;
  }
  
  public void setAudioTrack(String paramString)
  {
    this.mAudioTrack = paramString;
  }
  
  public void setAudioType(int paramInt)
  {
    this.mAudioType = paramInt;
  }
  
  public void setAudioUrlList(ArrayList<String> paramArrayList)
  {
    this.mAudioUrlList = paramArrayList;
    if ((this.mAudioUrlList == null) || (this.mAudioUrlList.size() == 0))
    {
      this.mAudioPlayUrl = null;
      return;
    }
    this.mAudioPlayUrl = ((String)this.mAudioUrlList.get(0));
  }
  
  public void setKeyId(String paramString)
  {
    this.mKeyId = paramString;
  }
  
  public void setVip(int paramInt)
  {
    this.mIsVip = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.TVKNetVideoInfo.AudioTrackInfo
 * JD-Core Version:    0.7.0.1
 */