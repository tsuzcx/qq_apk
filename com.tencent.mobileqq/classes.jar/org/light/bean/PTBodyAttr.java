package org.light.bean;

import java.io.Serializable;
import java.lang.reflect.Array;

public class PTBodyAttr
  implements Serializable
{
  public float[][] bodyPoint = (float[][])Array.newInstance(Float.TYPE, new int[] { 59, 2 });
  public float classifyConfidence;
  public String classifyName;
  public float confidence;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.bean.PTBodyAttr
 * JD-Core Version:    0.7.0.1
 */