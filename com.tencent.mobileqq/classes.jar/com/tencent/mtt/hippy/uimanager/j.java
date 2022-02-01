package com.tencent.mtt.hippy.uimanager;

import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.Iterator;
import java.util.Set;

public class j
{
  private static ThreadLocal<double[]> a = new j.1();
  
  private static double a(HippyMap paramHippyMap, String paramString)
  {
    boolean bool = paramHippyMap.get(paramString) instanceof String;
    int j = 1;
    int i = 1;
    double d;
    if (bool)
    {
      paramString = (String)paramHippyMap.get(paramString);
      if (paramString.endsWith("rad"))
      {
        paramHippyMap = paramString.substring(0, paramString.length() - 3);
      }
      else
      {
        paramHippyMap = paramString;
        if (paramString.endsWith("deg"))
        {
          paramHippyMap = paramString.substring(0, paramString.length() - 3);
          i = 0;
        }
      }
      d = Float.parseFloat(paramHippyMap);
    }
    else if ((paramHippyMap.get(paramString) instanceof Number))
    {
      d = ((Number)paramHippyMap.get(paramString)).doubleValue();
      i = j;
    }
    else
    {
      d = 0.0D;
      i = j;
    }
    if (i != 0) {
      return d;
    }
    return f.b(d);
  }
  
  public static void a(HippyArray paramHippyArray, double[] paramArrayOfDouble)
  {
    double[] arrayOfDouble = (double[])a.get();
    f.e(paramArrayOfDouble);
    int k = paramHippyArray.size();
    int i = 0;
    while (i < k)
    {
      Object localObject2 = paramHippyArray.getMap(i);
      Object localObject1 = (String)((HippyMap)localObject2).keySet().iterator().next();
      f.e(arrayOfDouble);
      Object localObject3 = ((HippyMap)localObject2).get((String)localObject1);
      int j;
      if (("matrix".equals(localObject1)) && ((localObject3 instanceof HippyArray)))
      {
        localObject1 = (HippyArray)localObject3;
        j = 0;
      }
      while (j < 16)
      {
        localObject2 = ((HippyArray)localObject1).getObject(j);
        if ((localObject2 instanceof Number)) {
          arrayOfDouble[j] = ((Number)localObject2).doubleValue();
        }
        j += 1;
        continue;
        if (("perspective".equals(localObject1)) && ((localObject3 instanceof Number)))
        {
          f.b(arrayOfDouble, ((Number)localObject3).doubleValue());
        }
        else
        {
          if (!"rotateX".equals(localObject1)) {
            break label206;
          }
          f.g(arrayOfDouble, a((HippyMap)localObject2, (String)localObject1));
        }
      }
      label415:
      label456:
      for (;;)
      {
        break;
        label206:
        if ("rotateY".equals(localObject1))
        {
          f.h(arrayOfDouble, a((HippyMap)localObject2, (String)localObject1));
        }
        else if ((!"rotate".equals(localObject1)) && (!"rotateZ".equals(localObject1)))
        {
          double d1;
          if (("scale".equals(localObject1)) && ((localObject3 instanceof Number)))
          {
            d1 = ((Number)localObject3).doubleValue();
            f.c(arrayOfDouble, d1);
          }
          for (;;)
          {
            f.d(arrayOfDouble, d1);
            break;
            if (("scaleX".equals(localObject1)) && ((localObject3 instanceof Number)))
            {
              f.c(arrayOfDouble, ((Number)localObject3).doubleValue());
              break;
            }
            if (!"scaleY".equals(localObject1)) {
              break label352;
            }
            d1 = ((Number)localObject3).doubleValue();
          }
          label352:
          if (("translate".equals(localObject1)) && ((localObject3 instanceof HippyArray)))
          {
            localObject1 = (HippyArray)localObject3;
            if (((HippyArray)localObject1).size() > 0)
            {
              localObject2 = ((HippyArray)localObject1).getObject(0);
              if ((localObject2 instanceof Number))
              {
                d1 = ((Number)localObject2).doubleValue();
                break label415;
              }
            }
            d1 = 0.0D;
            if (((HippyArray)localObject1).size() > 1)
            {
              localObject2 = ((HippyArray)localObject1).getObject(1);
              if ((localObject2 instanceof Number))
              {
                d2 = ((Number)localObject2).doubleValue();
                break label456;
              }
            }
            double d2 = 0.0D;
            if (((HippyArray)localObject1).size() > 2)
            {
              localObject1 = ((HippyArray)localObject1).getObject(2);
              if ((localObject1 instanceof Number))
              {
                d3 = ((Number)localObject1).doubleValue();
                break label497;
              }
            }
            double d3 = 0.0D;
            label497:
            f.a(arrayOfDouble, d1, d2, d3);
          }
          else if (("translateX".equals(localObject1)) && ((localObject3 instanceof Number)))
          {
            f.a(arrayOfDouble, ((Number)localObject3).doubleValue(), 0.0D);
          }
          else if (("translateY".equals(localObject1)) && ((localObject3 instanceof Number)))
          {
            f.a(arrayOfDouble, 0.0D, ((Number)localObject3).doubleValue());
          }
          else if ("skewX".equals(localObject1))
          {
            f.e(arrayOfDouble, a((HippyMap)localObject2, (String)localObject1));
          }
          else if ("skewY".equals(localObject1))
          {
            f.f(arrayOfDouble, a((HippyMap)localObject2, (String)localObject1));
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Unsupported transform type: ");
            ((StringBuilder)localObject2).append((String)localObject1);
            new RuntimeException(((StringBuilder)localObject2).toString()).printStackTrace();
          }
        }
        else
        {
          f.i(arrayOfDouble, a((HippyMap)localObject2, (String)localObject1));
        }
      }
      f.a(paramArrayOfDouble, paramArrayOfDouble, arrayOfDouble);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.j
 * JD-Core Version:    0.7.0.1
 */