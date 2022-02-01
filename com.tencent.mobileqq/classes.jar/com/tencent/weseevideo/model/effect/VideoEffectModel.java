package com.tencent.weseevideo.model.effect;

import android.text.TextUtils;
import com.tencent.weseevideo.composition.effectnode.VideoEffectType;

public class VideoEffectModel
  extends VideoPagModel
{
  private long createTime;
  private int effectBgColor;
  private String effectId;
  private String effectName;
  
  public VideoEffectModel()
  {
    this.effectType = VideoEffectType.TYPE_SPECIAL_EFFECT.value;
  }
  
  public VideoEffectModel clone()
  {
    return (VideoEffectModel)super.clone();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof VideoEffectModel))
    {
      paramObject = (VideoEffectModel)paramObject;
      return (!TextUtils.isEmpty(this.effectId)) && (this.effectId.equals(paramObject.getEffectId())) && (this.startTime == paramObject.getStartTime()) && (this.duration == paramObject.getDuration());
    }
    return super.equals(paramObject);
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public int getEffectBgColor()
  {
    return this.effectBgColor;
  }
  
  public String getEffectId()
  {
    return this.effectId;
  }
  
  public String getEffectName()
  {
    return this.effectName;
  }
  
  public float getEndTime()
  {
    return this.startTime + this.duration;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public void setEffectBgColor(int paramInt)
  {
    this.effectBgColor = paramInt;
  }
  
  public void setEffectId(String paramString)
  {
    this.effectId = paramString;
  }
  
  public void setEffectName(String paramString)
  {
    this.effectName = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.effect.VideoEffectModel
 * JD-Core Version:    0.7.0.1
 */