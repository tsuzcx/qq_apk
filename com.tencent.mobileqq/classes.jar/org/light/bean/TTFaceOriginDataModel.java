package org.light.bean;

import java.io.Serializable;

public class TTFaceOriginDataModel
  implements Serializable
{
  public int cls;
  public float[] facePoint = new float['¼'];
  public float[] facePointVisible = new float[94];
  public float pitch;
  public float roll;
  public float yaw;
  
  public TTFaceOriginDataModel() {}
  
  public TTFaceOriginDataModel(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.facePoint = paramArrayOfFloat1;
    this.facePointVisible = paramArrayOfFloat2;
    this.pitch = paramFloat1;
    this.yaw = paramFloat2;
    this.roll = paramFloat3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.bean.TTFaceOriginDataModel
 * JD-Core Version:    0.7.0.1
 */