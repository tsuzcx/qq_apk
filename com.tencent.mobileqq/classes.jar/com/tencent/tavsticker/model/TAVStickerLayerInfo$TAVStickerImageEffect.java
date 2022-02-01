package com.tencent.tavsticker.model;

import com.tencent.tav.coremedia.CMTimeRange;

public class TAVStickerLayerInfo$TAVStickerImageEffect
{
  private String effectId = "";
  private String name = "";
  private CMTimeRange timeRange = CMTimeRange.CMTimeRangeInvalid;
  
  public TAVStickerLayerInfo$TAVStickerImageEffect(CMTimeRange paramCMTimeRange, String paramString1, String paramString2)
  {
    if (paramCMTimeRange != null) {
      this.timeRange = paramCMTimeRange;
    }
    if (paramString1 != null) {
      this.effectId = paramString1;
    }
    if (paramString2 != null) {
      this.name = paramString2;
    }
  }
  
  public String getEffectId()
  {
    return this.effectId;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerImageEffect
 * JD-Core Version:    0.7.0.1
 */