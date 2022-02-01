package org.jbox2d.pooling.arrays;

import java.util.HashMap;

public class IntArray
{
  private final HashMap<Integer, int[]> map = new HashMap();
  
  public int[] get(int paramInt)
  {
    if (!this.map.containsKey(Integer.valueOf(paramInt))) {
      this.map.put(Integer.valueOf(paramInt), getInitializedArray(paramInt));
    }
    return (int[])this.map.get(Integer.valueOf(paramInt));
  }
  
  protected int[] getInitializedArray(int paramInt)
  {
    return new int[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.arrays.IntArray
 * JD-Core Version:    0.7.0.1
 */