package com.tencent.ttpic.face;

import com.tencent.ttpic.model.StickerItem.FeatureStatValueRange;

public abstract interface FaceStatusChecker
{
  public abstract float getLevel(FaceRangeStatus paramFaceRangeStatus, StickerItem.FeatureStatValueRange paramFeatureStatValueRange);
  
  public abstract boolean isInRange(FaceRangeStatus paramFaceRangeStatus, StickerItem.FeatureStatValueRange paramFeatureStatValueRange);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.face.FaceStatusChecker
 * JD-Core Version:    0.7.0.1
 */