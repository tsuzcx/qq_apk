package com.tencent.weseevideo.model.effect;

import com.tencent.weseevideo.model.data.MusicMaterialMetaDataBean;

public class MusicModel
  extends BaseEffectModel
{
  private float bgmVolume = 0.8F;
  private boolean closeLyric = false;
  private int duration;
  private int filePath;
  private boolean manuallyChangedVolume = false;
  private MusicMaterialMetaDataBean metaDataBean;
  private String musicId;
  private String musicPath;
  private int offset;
  private MusicMaterialMetaDataBean userMetaDataBean;
  private float volume = 0.3F;
  
  public void clear()
  {
    this.musicId = "";
    this.metaDataBean = null;
    this.closeLyric = false;
    this.offset = 0;
    this.duration = 0;
    this.filePath = 0;
    this.bgmVolume = 0.8F;
    this.volume = 0.3F;
    this.source = 0;
  }
  
  public float getBgmVolume()
  {
    return this.bgmVolume;
  }
  
  public int getDuration()
  {
    return this.duration;
  }
  
  public int getFilePath()
  {
    return this.filePath;
  }
  
  public MusicMaterialMetaDataBean getMetaDataBean()
  {
    return this.metaDataBean;
  }
  
  public String getMusicId()
  {
    return this.musicId;
  }
  
  public String getMusicPath()
  {
    return this.musicPath;
  }
  
  public int getOffset()
  {
    return this.offset;
  }
  
  public MusicMaterialMetaDataBean getUserMetaDataBean()
  {
    return this.userMetaDataBean;
  }
  
  public float getVolume()
  {
    return this.volume;
  }
  
  public boolean isCloseLyric()
  {
    return this.closeLyric;
  }
  
  public boolean isManuallyChangedVolume()
  {
    return this.manuallyChangedVolume;
  }
  
  public void setBgmVolume(float paramFloat)
  {
    this.bgmVolume = paramFloat;
  }
  
  public void setCloseLyric(boolean paramBoolean)
  {
    this.closeLyric = paramBoolean;
  }
  
  public void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public void setFilePath(int paramInt)
  {
    this.filePath = paramInt;
  }
  
  public void setManuallyChangedVolume(boolean paramBoolean)
  {
    this.manuallyChangedVolume = paramBoolean;
  }
  
  public void setMetaDataBean(MusicMaterialMetaDataBean paramMusicMaterialMetaDataBean)
  {
    this.metaDataBean = paramMusicMaterialMetaDataBean;
  }
  
  public void setMusicId(String paramString)
  {
    this.musicId = paramString;
  }
  
  public void setMusicPath(String paramString)
  {
    this.musicPath = paramString;
  }
  
  public void setOffset(int paramInt)
  {
    this.offset = paramInt;
  }
  
  public void setUserMetaDataBean(MusicMaterialMetaDataBean paramMusicMaterialMetaDataBean)
  {
    this.userMetaDataBean = paramMusicMaterialMetaDataBean;
  }
  
  public void setVolume(float paramFloat)
  {
    this.volume = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.MusicModel
 * JD-Core Version:    0.7.0.1
 */