package com.tencent.weseevideo.model.effect;

import android.text.TextUtils;
import com.tencent.weseevideo.composition.effectnode.VideoEffectType;

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
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramObject == null);
          bool1 = bool2;
        } while (getClass() != paramObject.getClass());
        paramObject = (VideoEndModel)paramObject;
        bool1 = bool2;
      } while (!TextUtils.equals(this.mEndName, paramObject.mEndName));
      bool1 = bool2;
    } while (!TextUtils.equals(this.mId, paramObject.mId));
    return TextUtils.equals(this.mType, paramObject.mType);
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
    int k = 0;
    int i;
    if (this.mEndName != null)
    {
      i = this.mEndName.hashCode();
      if (this.mId == null) {
        break label64;
      }
    }
    label64:
    for (int j = this.mId.hashCode();; j = 0)
    {
      if (this.mType != null) {
        k = this.mType.hashCode();
      }
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
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
 * Qualified Name:     com.tencent.weseevideo.model.effect.VideoEndModel
 * JD-Core Version:    0.7.0.1
 */