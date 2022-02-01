package com.tencent.ttpic.util;

import android.util.Pair;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.util.Pair<Ljava.lang.Float;Ljava.lang.Double;>;>;

public class AudioFabbyUtil
{
  public static double getRangeValue(int paramInt, float paramFloat, List<Pair<Float, Double>> paramList, double paramDouble)
  {
    if (paramList.size() <= 0) {
      return paramDouble;
    }
    Object localObject3 = paramList.iterator();
    Object localObject2 = null;
    Object localObject1;
    for (paramList = null;; paramList = (List<Pair<Float, Double>>)localObject1)
    {
      localObject1 = localObject2;
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
      localObject1 = (Pair)((Iterator)localObject3).next();
      if (((Float)((Pair)localObject1).first).floatValue() > paramFloat) {
        break;
      }
    }
    if ((paramList == null) && (localObject1 == null)) {
      return 1.0D;
    }
    if (paramList == null)
    {
      localObject3 = localObject1;
      localObject2 = localObject1;
    }
    else
    {
      localObject2 = localObject1;
      localObject3 = paramList;
      if (localObject1 == null)
      {
        localObject2 = paramList;
        localObject3 = paramList;
      }
    }
    if (((Float)((Pair)localObject3).first).equals(((Pair)localObject2).first)) {
      return ((Double)((Pair)localObject3).second).doubleValue();
    }
    return getValue(paramInt, ((Double)((Pair)localObject3).second).doubleValue(), ((Float)((Pair)localObject3).first).floatValue(), ((Double)((Pair)localObject2).second).doubleValue(), ((Float)((Pair)localObject2).first).floatValue(), paramFloat);
  }
  
  private static double getValue(int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    paramDouble2 = (paramDouble5 - paramDouble2) / (paramDouble4 - paramDouble2);
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        if (paramInt == 3) {}
      }
      for (paramDouble2 = (paramDouble3 - paramDouble1) * paramDouble2;; paramDouble2 = (paramDouble3 - paramDouble1) * Math.sin(paramDouble2 * 1.570796326794897D))
      {
        return paramDouble2 + paramDouble1;
        return -(paramDouble3 - paramDouble1) / 2.0D * (Math.cos(paramDouble2 * 3.141592653589793D) - 1.0D) + paramDouble1;
      }
    }
    return paramDouble3 + -(paramDouble3 - paramDouble1) * Math.cos(paramDouble2 * 1.570796326794897D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.util.AudioFabbyUtil
 * JD-Core Version:    0.7.0.1
 */