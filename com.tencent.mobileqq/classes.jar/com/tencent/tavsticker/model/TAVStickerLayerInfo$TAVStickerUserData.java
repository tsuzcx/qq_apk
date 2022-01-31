package com.tencent.tavsticker.model;

import com.tencent.tav.coremedia.CMTimeRange;

public class TAVStickerLayerInfo$TAVStickerUserData
{
  private String mData = "";
  private CMTimeRange mTimeRange = CMTimeRange.CMTimeRangeInvalid;
  
  public TAVStickerLayerInfo$TAVStickerUserData(CMTimeRange paramCMTimeRange, String paramString)
  {
    if (paramCMTimeRange != null) {
      this.mTimeRange = paramCMTimeRange;
    }
    if (paramString != null) {
      this.mData = paramString;
    }
  }
  
  public String getData()
  {
    return this.mData;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.mTimeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerUserData
 * JD-Core Version:    0.7.0.1
 */