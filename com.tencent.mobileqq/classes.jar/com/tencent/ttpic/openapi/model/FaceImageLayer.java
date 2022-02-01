package com.tencent.ttpic.openapi.model;

import com.tencent.ttpic.util.FaceOffUtil.FeatureType;
import java.util.List;

public class FaceImageLayer
{
  public double antiWrinkle;
  public double blendAlpha;
  public String cosFunTemplateFile;
  public double distortionAlpha;
  public List<DistortionItem> distortionList;
  public List<Double> extraDistortionAlphaArray;
  public List<List<Double>> extraFacePointsArray;
  public List<Double> faceColorRange;
  public List<Double> faceMaskFacePoint;
  public String faceMaskImagePath;
  public List<Integer> faceTriangle;
  public int faceTriangleID;
  public FaceOffUtil.FeatureType featureType = FaceOffUtil.FeatureType.CRAZY_FACE;
  public double height;
  public List<Double> imageFaceColor;
  public List<Double> imageFaceColor2;
  public List<Double> imageFacePoint;
  public String imagePath;
  public int type;
  public double width;
  public double x;
  public double y;
  
  public int getVersion()
  {
    List localList = this.imageFaceColor2;
    if ((localList != null) && (localList.size() >= 12))
    {
      localList = this.faceColorRange;
      if ((localList != null) && (localList.size() >= 2)) {
        return 2;
      }
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.FaceImageLayer
 * JD-Core Version:    0.7.0.1
 */