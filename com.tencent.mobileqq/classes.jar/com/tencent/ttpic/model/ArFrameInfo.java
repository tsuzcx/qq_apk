package com.tencent.ttpic.model;

import java.util.List;

public class ArFrameInfo
{
  public float[] cameraModelMatrix = new float[16];
  public List<ArFrameInfo.Plane> planeList;
  public float[] projectionMatrix = new float[16];
  
  public double[] float2double(float[] paramArrayOfFloat)
  {
    double[] arrayOfDouble = new double[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      arrayOfDouble[i] = paramArrayOfFloat[i];
      i += 1;
    }
    return arrayOfDouble;
  }
  
  public String printFloatArray(float[] paramArrayOfFloat)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      localStringBuffer.append(paramArrayOfFloat[i]);
      localStringBuffer.append(",");
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.model.ArFrameInfo
 * JD-Core Version:    0.7.0.1
 */