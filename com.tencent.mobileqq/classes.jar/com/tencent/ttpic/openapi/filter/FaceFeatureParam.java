package com.tencent.ttpic.openapi.filter;

public class FaceFeatureParam
  implements Cloneable
{
  public float faceFeatureMultiplyAdjustValue = 0.8F;
  public String faceFeatureMultiplyImage = "beauty_multiply.png";
  public float faceFeatureNormal2AdjustValue = 0.0F;
  public float faceFeatureNormalAdjustValue = 0.8F;
  public String faceFeatureNormalImage = "beauty_normal.png";
  public float faceFeatureSoftlightAdjustValue = 0.8F;
  public String faceFeatureSoftlightImage = "beauty_softlight.png";
  
  public FaceFeatureParam(float paramFloat)
  {
    this.faceFeatureNormalAdjustValue = paramFloat;
    this.faceFeatureMultiplyAdjustValue = paramFloat;
    this.faceFeatureSoftlightAdjustValue = paramFloat;
  }
  
  public FaceFeatureParam(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.faceFeatureNormalAdjustValue = paramFloat1;
    this.faceFeatureMultiplyAdjustValue = paramFloat2;
    this.faceFeatureSoftlightAdjustValue = paramFloat3;
  }
  
  public FaceFeatureParam(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.faceFeatureNormalAdjustValue = paramFloat1;
    this.faceFeatureMultiplyAdjustValue = paramFloat2;
    this.faceFeatureSoftlightAdjustValue = paramFloat3;
    this.faceFeatureNormal2AdjustValue = paramFloat4;
  }
  
  public FaceFeatureParam(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, String paramString)
  {
    this.faceFeatureNormalAdjustValue = paramFloat1;
    this.faceFeatureMultiplyAdjustValue = paramFloat2;
    this.faceFeatureSoftlightAdjustValue = paramFloat3;
    this.faceFeatureNormal2AdjustValue = paramFloat4;
  }
  
  public FaceFeatureParam(float paramFloat1, float paramFloat2, float paramFloat3, String paramString1, String paramString2, String paramString3)
  {
    this.faceFeatureNormalAdjustValue = paramFloat1;
    this.faceFeatureMultiplyAdjustValue = paramFloat2;
    this.faceFeatureSoftlightAdjustValue = paramFloat3;
    this.faceFeatureNormalImage = paramString1;
    this.faceFeatureMultiplyImage = paramString2;
    this.faceFeatureSoftlightImage = paramString3;
  }
  
  public FaceFeatureParam clone()
  {
    try
    {
      FaceFeatureParam localFaceFeatureParam = (FaceFeatureParam)super.clone();
      return localFaceFeatureParam;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.FaceFeatureParam
 * JD-Core Version:    0.7.0.1
 */