package com.tencent.ttpic.openapi.facedetect;

import android.graphics.PointF;
import java.util.List;

public class FaceInfo
{
  public int age;
  public float[] angles = new float[3];
  public int curGender;
  public float[] denseFaceModel;
  public float[] expressionWeights;
  public float[] eyeEulerAngle;
  public float[] eyeRollWeights = new float[3];
  public long faceId;
  public int gender;
  public List<PointF> irisPoints;
  public float[] orig256FacePoints;
  public float[] origFacePoints = new float['¼'];
  public float[] origPointsVis = new float[94];
  public float pitch;
  public List<PointF> point94;
  public List<PointF> points;
  public Float[] pointsVis;
  public float[] rect = new float[4];
  public float roll;
  public float scale;
  public float[] transform;
  public float tx;
  public float ty;
  public float yaw;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.facedetect.FaceInfo
 * JD-Core Version:    0.7.0.1
 */