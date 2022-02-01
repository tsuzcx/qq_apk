package com.tencent.ttpic.facedetect;

import java.io.Serializable;
import java.lang.reflect.Array;

public class TTFaceOriginDataModel
  implements Serializable
{
  public float cls;
  public float[][] facePoint = (float[][])Array.newInstance(Float.TYPE, new int[] { 94, 2 });
  public float[] facePointVisible = new float[94];
  public float pitch;
  public float roll;
  public float yaw;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.facedetect.TTFaceOriginDataModel
 * JD-Core Version:    0.7.0.1
 */