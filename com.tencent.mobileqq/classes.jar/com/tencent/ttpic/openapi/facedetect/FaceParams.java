package com.tencent.ttpic.openapi.facedetect;

import android.graphics.PointF;
import com.tencent.faceBeauty.FaceParam;
import java.util.List;

public class FaceParams
{
  private float[] faceAngles;
  private FaceParam faceParam;
  private List<PointF> facePoints;
  
  public float[] getFaceAngles()
  {
    return this.faceAngles;
  }
  
  public FaceParam getFaceParam()
  {
    return this.faceParam;
  }
  
  public List<PointF> getFacePoints()
  {
    return this.facePoints;
  }
  
  public void setFaceAngles(float[] paramArrayOfFloat)
  {
    this.faceAngles = paramArrayOfFloat;
  }
  
  public void setFaceParam(FaceParam paramFaceParam)
  {
    this.faceParam = paramFaceParam;
  }
  
  public void setFacePoints(List<PointF> paramList)
  {
    this.facePoints = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.facedetect.FaceParams
 * JD-Core Version:    0.7.0.1
 */