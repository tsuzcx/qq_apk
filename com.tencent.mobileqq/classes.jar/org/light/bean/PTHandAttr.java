package org.light.bean;

import java.io.Serializable;
import java.lang.reflect.Array;

public class PTHandAttr
  implements Serializable
{
  public float classifyConfidence;
  public String classifyName;
  public float confidence;
  public int detectHeight;
  public int detectWidth;
  public float[][] handPoint = (float[][])Array.newInstance(Float.TYPE, new int[] { 32, 2 });
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.bean.PTHandAttr
 * JD-Core Version:    0.7.0.1
 */