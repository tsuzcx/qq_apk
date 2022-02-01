package org.jbox2d.pooling.arrays;

import java.util.HashMap;
import org.jbox2d.common.Vec2;

public class Vec2Array
{
  private final HashMap<Integer, Vec2[]> map = new HashMap();
  
  public Vec2[] get(int paramInt)
  {
    if (!this.map.containsKey(Integer.valueOf(paramInt))) {
      this.map.put(Integer.valueOf(paramInt), getInitializedArray(paramInt));
    }
    return (Vec2[])this.map.get(Integer.valueOf(paramInt));
  }
  
  protected Vec2[] getInitializedArray(int paramInt)
  {
    Vec2[] arrayOfVec2 = new Vec2[paramInt];
    paramInt = 0;
    while (paramInt < arrayOfVec2.length)
    {
      arrayOfVec2[paramInt] = new Vec2();
      paramInt += 1;
    }
    return arrayOfVec2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.pooling.arrays.Vec2Array
 * JD-Core Version:    0.7.0.1
 */