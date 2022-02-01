package com.tencent.qcircle.weseevideo.model.effect;

import android.text.TextUtils;
import com.tencent.qcircle.weseevideo.composition.effectnode.VideoEffectType;

public class VideoEndModel
  extends VideoPagModel
{
  private float compositionDuration;
  private String landscapePag;
  private String mEndName;
  private String mId;
  private int mLastPosition;
  private String mPackageUrl;
  private String mType;
  private String miniVersion;
  private String pag;
  
  public VideoEndModel()
  {
    this.effectType = VideoEffectType.TYPE_VIDEO_END.value;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (VideoEndModel)paramObject;
      if (!TextUtils.equals(this.mEndName, paramObject.mEndName)) {
        return false;
      }
      if (!TextUtils.equals(this.mId, paramObject.mId)) {
        return false;
      }
      return TextUtils.equals(this.mType, paramObject.mType);
    }
    return false;
  }
  
  public float getCompositionDuration()
  {
    return this.compositionDuration;
  }
  
  public String getEndName()
  {
    return this.mEndName;
  }
  
  public String getId()
  {
    return this.mId;
  }
  
  public String getLandscapePag()
  {
    return this.landscapePag;
  }
  
  public int getLastPosition()
  {
    return this.mLastPosition;
  }
  
  public String getMiniVersion()
  {
    return this.miniVersion;
  }
  
  public String getPackageUrl()
  {
    return this.mPackageUrl;
  }
  
  public String getPag()
  {
    return this.pag;
  }
  
  public String getType()
  {
    return this.mType;
  }
  
  public int hashCode()
  {
    String str = this.mEndName;
    int k = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.mId;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.mType;
    if (str != null) {
      k = str.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  public void setCompositionDuration(float paramFloat)
  {
    this.compositionDuration = paramFloat;
  }
  
  public void setEndName(String paramString)
  {
    this.mEndName = paramString;
  }
  
  public void setId(String paramString)
  {
    this.mId = paramString;
  }
  
  public void setLandscapePag(String paramString)
  {
    this.landscapePag = paramString;
  }
  
  public void setLastPosition(int paramInt)
  {
    this.mLastPosition = paramInt;
  }
  
  public void setMiniVersion(String paramString)
  {
    this.miniVersion = paramString;
  }
  
  public void setPackageUrl(String paramString)
  {
    this.mPackageUrl = paramString;
  }
  
  public void setPag(String paramString)
  {
    this.pag = paramString;
  }
  
  public void setType(String paramString)
  {
    this.mType = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.effect.VideoEndModel
 * JD-Core Version:    0.7.0.1
 */