package org.jbox2d.pooling.arrays;

import java.util.HashMap;

public class FloatArray
{
  private final HashMap<Integer, float[]> map = new HashMap();
  
  public float[] get(int paramInt)
  {
    if (!this.map.containsKey(Integer.valueOf(paramInt))) {
      this.map.put(Integer.valueOf(paramInt), getInitializedArray(paramInt));
    }
    return (float[])this.map.get(Integer.valueOf(paramInt));
  }
  
  protected float[] getInitializedArray(int paramInt)
  {
    return new float[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.arrays.FloatArray
 * JD-Core Version:    0.7.0.1
 */