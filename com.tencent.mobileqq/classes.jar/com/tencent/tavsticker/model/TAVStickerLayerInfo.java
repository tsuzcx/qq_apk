package com.tencent.tavsticker.model;

import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.List;

public class TAVStickerLayerInfo
{
  private List<TAVStickerLayerInfo.TAVStickerImageEffect> mImageEffects = new ArrayList();
  private int mLayerIndex = 0;
  private TAVStickerLayerType mLayerType = TAVStickerLayerType.Unknown;
  private List<TAVStickerLayerInfo.TAVStickerTimeEffect> mTimeEffects = new ArrayList();
  private CMTimeRange mTimeRange = CMTimeRange.CMTimeRangeInvalid;
  private List<TAVStickerLayerInfo.TAVStickerUserData> mUserDataList = new ArrayList();
  
  public TAVStickerLayerInfo(int paramInt, TAVStickerLayerType paramTAVStickerLayerType, CMTimeRange paramCMTimeRange, List<TAVStickerLayerInfo.TAVStickerTimeEffect> paramList, List<TAVStickerLayerInfo.TAVStickerImageEffect> paramList1, List<TAVStickerLayerInfo.TAVStickerUserData> paramList2)
  {
    this.mLayerIndex = paramInt;
    if (paramTAVStickerLayerType != null) {
      this.mLayerType = paramTAVStickerLayerType;
    }
    if (paramCMTimeRange != null) {
      this.mTimeRange = paramCMTimeRange;
    }
    if (paramList != null)
    {
      this.mTimeEffects.clear();
      this.mTimeEffects.addAll(paramList);
    }
    if (paramList1 != null)
    {
      this.mImageEffects.clear();
      this.mImageEffects.addAll(paramList1);
    }
    if (paramList2 != null)
    {
      this.mUserDataList.clear();
      this.mUserDataList.addAll(paramList2);
    }
  }
  
  public List<TAVStickerLayerInfo.TAVStickerImageEffect> getImageEffects()
  {
    return this.mImageEffects;
  }
  
  public int getLayerIndex()
  {
    return this.mLayerIndex;
  }
  
  public TAVStickerLayerType getLayerType()
  {
    return this.mLayerType;
  }
  
  public List<TAVStickerLayerInfo.TAVStickerTimeEffect> getTimeEffects()
  {
    return this.mTimeEffects;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.mTimeRange;
  }
  
  public List<TAVStickerLayerInfo.TAVStickerUserData> getUserDataList()
  {
    return this.mUserDataList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerLayerInfo
 * JD-Core Version:    0.7.0.1
 */