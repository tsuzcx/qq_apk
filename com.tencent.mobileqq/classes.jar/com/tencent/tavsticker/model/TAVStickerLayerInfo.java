package com.tencent.tavsticker.model;

import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.List;

public class TAVStickerLayerInfo
{
  private List<TAVStickerLayerInfo.TAVStickerImageEffect> imageEffects = new ArrayList();
  private int layerIndex = 0;
  private TAVStickerLayerType layerType = TAVStickerLayerType.Unknown;
  private List<TAVStickerLayerInfo.TAVStickerTimeEffect> timeEffects = new ArrayList();
  private CMTimeRange timeRange = CMTimeRange.CMTimeRangeInvalid;
  private List<TAVStickerLayerInfo.TAVStickerUserData> userDataList = new ArrayList();
  
  public TAVStickerLayerInfo(int paramInt, TAVStickerLayerType paramTAVStickerLayerType, CMTimeRange paramCMTimeRange, List<TAVStickerLayerInfo.TAVStickerTimeEffect> paramList, List<TAVStickerLayerInfo.TAVStickerImageEffect> paramList1, List<TAVStickerLayerInfo.TAVStickerUserData> paramList2)
  {
    this.layerIndex = paramInt;
    if (paramTAVStickerLayerType != null) {
      this.layerType = paramTAVStickerLayerType;
    }
    if (paramCMTimeRange != null) {
      this.timeRange = paramCMTimeRange;
    }
    if (paramList != null)
    {
      this.timeEffects.clear();
      this.timeEffects.addAll(paramList);
    }
    if (paramList1 != null)
    {
      this.imageEffects.clear();
      this.imageEffects.addAll(paramList1);
    }
    if (paramList2 != null)
    {
      this.userDataList.clear();
      this.userDataList.addAll(paramList2);
    }
  }
  
  public List<TAVStickerLayerInfo.TAVStickerImageEffect> getImageEffects()
  {
    return this.imageEffects;
  }
  
  public int getLayerIndex()
  {
    return this.layerIndex;
  }
  
  public TAVStickerLayerType getLayerType()
  {
    return this.layerType;
  }
  
  public List<TAVStickerLayerInfo.TAVStickerTimeEffect> getTimeEffects()
  {
    return this.timeEffects;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public List<TAVStickerLayerInfo.TAVStickerUserData> getUserDataList()
  {
    return this.userDataList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerLayerInfo
 * JD-Core Version:    0.7.0.1
 */