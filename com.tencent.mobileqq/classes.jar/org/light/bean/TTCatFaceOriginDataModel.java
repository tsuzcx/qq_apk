package org.light.bean;

import java.io.Serializable;
import java.lang.reflect.Array;

public class TTCatFaceOriginDataModel
  implements Serializable
{
  public float[][] catFacePoint = (float[][])Array.newInstance(Float.TYPE, new int[] { 20, 2 });
  public float classifyConfidence;
  public String classifyName;
  public float confidence;
  public float[] eulerAngle = new float[3];
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.bean.TTCatFaceOriginDataModel
 * JD-Core Version:    0.7.0.1
 */