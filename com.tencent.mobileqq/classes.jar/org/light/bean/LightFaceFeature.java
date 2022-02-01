package org.light.bean;

import java.util.HashMap;

public class LightFaceFeature
{
  public int age;
  public HashMap<String, Boolean> expression_status_ = new HashMap();
  public float[] faceBoundsRect = new float[4];
  public float[] faceFeature256Points = new float[512];
  public float[] faceFeature256Visibility = new float[256];
  public float[] faceFeature3DPoints = new float[3000];
  public float[] faceFeaturePoints = new float['¦'];
  public float[] faceFeatureVisibility = new float[83];
  public float[] facePoint83 = new float['¦'];
  public float[] facePoint83Visibility = new float[83];
  public float[] facePoint90 = new float['´'];
  public float[] facePoint90Visibility = new float[90];
  public float[] facePoints = new float['¼'];
  public float[] facePointsVisible = new float[94];
  public String gender;
  public boolean hasOutline;
  public float[] imageSize = new float[2];
  public float[] leBounds = new float[4];
  public TTFaceOriginDataModel mTTFaceOriginDataModel;
  public float[] mouthBounds = new float[4];
  public float pitch;
  public float[] reBounds = new float[4];
  public float roll;
  public float[] transform3D = new float[16];
  public float yaw;
  
  public LightFaceFeature() {}
  
  public LightFaceFeature(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, float[] paramArrayOfFloat6, float[] paramArrayOfFloat7, float[] paramArrayOfFloat8, float[] paramArrayOfFloat9, float[] paramArrayOfFloat10, float[] paramArrayOfFloat11, float[] paramArrayOfFloat12, float[] paramArrayOfFloat13, float[] paramArrayOfFloat14, float[] paramArrayOfFloat15, HashMap<String, Boolean> paramHashMap)
  {
    this.imageSize = paramArrayOfFloat1;
    this.faceBoundsRect = paramArrayOfFloat2;
    this.leBounds = paramArrayOfFloat3;
    this.reBounds = paramArrayOfFloat4;
    this.mouthBounds = paramArrayOfFloat5;
    this.pitch = paramFloat1;
    this.yaw = paramFloat2;
    this.roll = paramFloat3;
    this.hasOutline = paramBoolean;
    this.facePoints = paramArrayOfFloat6;
    this.facePointsVisible = paramArrayOfFloat7;
    this.faceFeaturePoints = paramArrayOfFloat8;
    this.faceFeatureVisibility = paramArrayOfFloat9;
    this.facePoint90 = paramArrayOfFloat10;
    this.facePoint90Visibility = paramArrayOfFloat11;
    this.faceFeature256Points = paramArrayOfFloat12;
    this.faceFeature256Visibility = paramArrayOfFloat13;
    this.faceFeature3DPoints = paramArrayOfFloat14;
    this.transform3D = paramArrayOfFloat15;
    this.expression_status_ = paramHashMap;
    this.mTTFaceOriginDataModel = new TTFaceOriginDataModel(paramArrayOfFloat6, paramArrayOfFloat7, paramFloat1, paramFloat2, paramFloat3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.bean.LightFaceFeature
 * JD-Core Version:    0.7.0.1
 */