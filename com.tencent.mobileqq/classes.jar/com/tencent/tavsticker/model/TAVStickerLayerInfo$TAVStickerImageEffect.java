package com.tencent.tavsticker.model;

import com.tencent.tav.coremedia.CMTimeRange;

public class TAVStickerLayerInfo$TAVStickerImageEffect
{
  private String mEffectId = "";
  private String mName = "";
  private CMTimeRange mTimeRange = CMTimeRange.CMTimeRangeInvalid;
  
  public TAVStickerLayerInfo$TAVStickerImageEffect(CMTimeRange paramCMTimeRange, String paramString1, String paramString2)
  {
    if (paramCMTimeRange != null) {
      this.mTimeRange = paramCMTimeRange;
    }
    if (paramString1 != null) {
      this.mEffectId = paramString1;
    }
    if (paramString2 != null) {
      this.mName = paramString2;
    }
  }
  
  public String getEffectId()
  {
    return this.mEffectId;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.mTimeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerImageEffect
 * JD-Core Version:    0.7.0.1
 */