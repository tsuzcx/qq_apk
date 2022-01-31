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
    Iterator localIterator = paramList.iterator();
    Object localObject2;
    for (paramList = null; localIterator.hasNext(); paramList = (List<Pair<Float, Double>>)localObject2)
    {
      localObject2 = (Pair)localIterator.next();
      localObject1 = localObject2;
      if (((Float)((Pair)localObject2).first).floatValue() > paramFloat) {
        break label72;
      }
    }
    Object localObject1 = null;
    label72:
    if ((paramList == null) && (localObject1 == null)) {
      return 1.0D;
    }
    if (paramList == null) {
      paramList = (List<Pair<Float, Double>>)localObject1;
    }
    for (;;)
    {
      if (((Float)((Pair)localObject1).first).equals(paramList.first))
      {
        return ((Double)((Pair)localObject1).second).doubleValue();
        if (localObject1 == null)
        {
          localObject1 = paramList;
          localObject2 = paramList;
          paramList = (List<Pair<Float, Double>>)localObject1;
          localObject1 = localObject2;
        }
      }
      else
      {
        return getValue(paramInt, ((Double)((Pair)localObject1).second).doubleValue(), ((Float)((Pair)localObject1).first).floatValue(), ((Double)paramList.second).doubleValue(), ((Float)paramList.first).floatValue(), paramFloat);
      }
      localObject2 = paramList;
      paramList = (List<Pair<Float, Double>>)localObject1;
      localObject1 = localObject2;
    }
  }
  
  private static double getValue(int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5)
  {
    paramDouble2 = (paramDouble5 - paramDouble2) / (paramDouble4 - paramDouble2);
    switch (paramInt)
    {
    default: 
      return paramDouble2 * (paramDouble3 - paramDouble1) + paramDouble1;
    case 1: 
      paramDouble1 = -(paramDouble3 - paramDouble1);
      return Math.cos(paramDouble2 * 1.570796326794897D) * paramDouble1 + paramDouble3;
    case 2: 
      return Math.sin(paramDouble2 * 1.570796326794897D) * (paramDouble3 - paramDouble1) + paramDouble1;
    }
    paramDouble3 = -(paramDouble3 - paramDouble1) / 2.0D;
    return (Math.cos(paramDouble2 * 3.141592653589793D) - 1.0D) * paramDouble3 + paramDouble1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.AudioFabbyUtil
 * JD-Core Version:    0.7.0.1
 */