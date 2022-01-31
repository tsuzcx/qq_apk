package com.tencent.ttpic.util;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

public class StableUtil
{
  public static List<Integer> getAvgAngles(List<List<Integer>> paramList)
  {
    Object localObject;
    if (VideoUtil.isEmpty(paramList))
    {
      localObject = VideoMaterialUtil.EMPTY_ANGLES_LIST;
      return localObject;
    }
    ArrayList localArrayList = new ArrayList(((List)paramList.get(0)).size());
    int i = 0;
    while (i < paramList.size())
    {
      int j = 0;
      while (j < ((List)paramList.get(0)).size())
      {
        if (j >= localArrayList.size()) {
          localArrayList.add(Integer.valueOf(0));
        }
        int k = ((Integer)localArrayList.get(j)).intValue();
        localArrayList.set(j, Integer.valueOf(((Integer)((List)paramList.get(i)).get(j)).intValue() + k));
        j += 1;
      }
      i += 1;
    }
    i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= localArrayList.size()) {
        break;
      }
      localArrayList.set(i, Integer.valueOf(((Integer)localArrayList.get(i)).intValue() / paramList.size()));
      i += 1;
    }
  }
  
  public static List<PointF> getAvgPoints(List<List<PointF>> paramList)
  {
    Object localObject;
    if (VideoUtil.isEmpty(paramList))
    {
      localObject = VideoMaterialUtil.EMPTY_POINTS_LIST;
      return localObject;
    }
    ArrayList localArrayList = new ArrayList(((List)paramList.get(0)).size());
    int i = 0;
    while (i < paramList.size())
    {
      int j = 0;
      while (j < ((List)paramList.get(0)).size())
      {
        if (j >= localArrayList.size()) {
          localArrayList.add(new PointF());
        }
        localObject = (PointF)localArrayList.get(j);
        float f = ((PointF)localObject).x;
        ((PointF)localObject).x = (((PointF)((List)paramList.get(i)).get(j)).x + f);
        localObject = (PointF)localArrayList.get(j);
        f = ((PointF)localObject).y;
        ((PointF)localObject).y = (((PointF)((List)paramList.get(i)).get(j)).y + f);
        j += 1;
      }
      i += 1;
    }
    i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= localArrayList.size()) {
        break;
      }
      localObject = (PointF)localArrayList.get(i);
      ((PointF)localObject).x /= paramList.size();
      localObject = (PointF)localArrayList.get(i);
      ((PointF)localObject).y /= paramList.size();
      i += 1;
    }
  }
  
  public static float getDistSquare(PointF paramPointF1, PointF paramPointF2)
  {
    if ((paramPointF1 == null) || (paramPointF2 == null)) {
      return 0.0F;
    }
    float f1 = paramPointF1.x - paramPointF2.x;
    float f2 = paramPointF1.y - paramPointF2.y;
    return f1 * f1 + f2 * f2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.StableUtil
 * JD-Core Version:    0.7.0.1
 */