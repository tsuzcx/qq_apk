package com.tencent.tavsticker.model;

import com.tencent.tav.coremedia.CMTimeRange;

public class TAVStickerLayerInfo$TAVStickerUserData
{
  private String data = "";
  private CMTimeRange timeRange = CMTimeRange.CMTimeRangeInvalid;
  
  public TAVStickerLayerInfo$TAVStickerUserData(CMTimeRange paramCMTimeRange, String paramString)
  {
    if (paramCMTimeRange != null) {
      this.timeRange = paramCMTimeRange;
    }
    if (paramString != null) {
      this.data = paramString;
    }
  }
  
  public String getData()
  {
    return this.data;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerUserData
 * JD-Core Version:    0.7.0.1
 */