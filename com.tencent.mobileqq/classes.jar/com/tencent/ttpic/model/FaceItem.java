package com.tencent.ttpic.model;

import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import java.util.List;

public class FaceItem
{
  public float blendAlpha;
  public int blendMode;
  public CharmRange charmRange;
  public String faceExchangeImage;
  public List<Float> facePoints;
  public FaceOffUtil.FEATURE_TYPE featureType;
  public int grayScale;
  public int personID;
  
  public FaceItem() {}
  
  public FaceItem(String paramString, float paramFloat, int paramInt1, int paramInt2, List<Float> paramList)
  {
    this.faceExchangeImage = paramString;
    this.blendAlpha = paramFloat;
    this.grayScale = paramInt1;
    this.featureType = FaceOffUtil.getFeatureType(paramInt2);
    this.facePoints = paramList;
    this.personID = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.FaceItem
 * JD-Core Version:    0.7.0.1
 */