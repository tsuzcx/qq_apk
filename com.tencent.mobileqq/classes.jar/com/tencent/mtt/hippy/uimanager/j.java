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
    int i = 1;
    double d;
    if ((paramHippyMap.get(paramString) instanceof String))
    {
      paramString = (String)paramHippyMap.get(paramString);
      if (paramString.endsWith("rad"))
      {
        paramHippyMap = paramString.substring(0, paramString.length() - 3);
        d = Float.parseFloat(paramHippyMap);
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        return d;
        paramHippyMap = paramString;
        if (!paramString.endsWith("deg")) {
          break;
        }
        paramHippyMap = paramString.substring(0, paramString.length() - 3);
        i = 0;
        break;
        if (!(paramHippyMap.get(paramString) instanceof Number)) {
          break label120;
        }
        d = ((Number)paramHippyMap.get(paramString)).doubleValue();
        i = 1;
        continue;
      }
      return f.b(d);
      label120:
      i = 1;
      d = 0.0D;
    }
  }
  
  public static void a(HippyArray paramHippyArray, double[] paramArrayOfDouble)
  {
    double[] arrayOfDouble = (double[])a.get();
    f.e(paramArrayOfDouble);
    int k = paramHippyArray.size();
    int i = 0;
    Object localObject2;
    String str;
    Object localObject1;
    label194:
    double d1;
    label381:
    double d2;
    if (i < k)
    {
      localObject2 = paramHippyArray.getMap(i);
      str = (String)((HippyMap)localObject2).keySet().iterator().next();
      f.e(arrayOfDouble);
      localObject1 = ((HippyMap)localObject2).get(str);
      int j;
      if (("matrix".equals(str)) && ((localObject1 instanceof HippyArray)))
      {
        localObject1 = (HippyArray)localObject1;
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
        if ((!"perspective".equals(str)) || (!(localObject1 instanceof Number))) {
          break label194;
        }
        f.b(arrayOfDouble, ((Number)localObject1).doubleValue());
      }
      for (;;)
      {
        f.a(paramArrayOfDouble, paramArrayOfDouble, arrayOfDouble);
        i += 1;
        break;
        if ("rotateX".equals(str))
        {
          f.g(arrayOfDouble, a((HippyMap)localObject2, str));
        }
        else if ("rotateY".equals(str))
        {
          f.h(arrayOfDouble, a((HippyMap)localObject2, str));
        }
        else if (("rotate".equals(str)) || ("rotateZ".equals(str)))
        {
          f.i(arrayOfDouble, a((HippyMap)localObject2, str));
        }
        else if (("scale".equals(str)) && ((localObject1 instanceof Number)))
        {
          d1 = ((Number)localObject1).doubleValue();
          f.c(arrayOfDouble, d1);
          f.d(arrayOfDouble, d1);
        }
        else if (("scaleX".equals(str)) && ((localObject1 instanceof Number)))
        {
          f.c(arrayOfDouble, ((Number)localObject1).doubleValue());
        }
        else
        {
          if (!"scaleY".equals(str)) {
            break label381;
          }
          f.d(arrayOfDouble, ((Number)localObject1).doubleValue());
        }
      }
      if (("translate".equals(str)) && ((localObject1 instanceof HippyArray)))
      {
        d2 = 0.0D;
        d3 = 0.0D;
        d1 = d2;
        if (((HippyArray)localObject1).size() > 0)
        {
          localObject2 = ((HippyArray)localObject1).getObject(0);
          d1 = d2;
          if ((localObject2 instanceof Number)) {
            d1 = ((Number)localObject2).doubleValue();
          }
        }
        d2 = d3;
        if (((HippyArray)localObject1).size() > 1)
        {
          localObject2 = ((HippyArray)localObject1).getObject(1);
          d2 = d3;
          if ((localObject2 instanceof Number)) {
            d2 = ((Number)localObject2).doubleValue();
          }
        }
        if (((HippyArray)localObject1).size() <= 2) {
          break label707;
        }
        localObject1 = ((HippyArray)localObject1).getObject(2);
        if (!(localObject1 instanceof Number)) {
          break label707;
        }
      }
    }
    label707:
    for (double d3 = ((Number)localObject1).doubleValue();; d3 = 0.0D)
    {
      f.a(arrayOfDouble, d1, d2, d3);
      break;
      if (("translateX".equals(str)) && ((localObject1 instanceof Number)))
      {
        f.a(arrayOfDouble, ((Number)localObject1).doubleValue(), 0.0D);
        break;
      }
      if (("translateY".equals(str)) && ((localObject1 instanceof Number)))
      {
        f.a(arrayOfDouble, 0.0D, ((Number)localObject1).doubleValue());
        break;
      }
      if ("skewX".equals(str))
      {
        f.e(arrayOfDouble, a((HippyMap)localObject2, str));
        break;
      }
      if ("skewY".equals(str))
      {
        f.f(arrayOfDouble, a((HippyMap)localObject2, str));
        break;
      }
      new RuntimeException("Unsupported transform type: " + str).printStackTrace();
      break;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.j
 * JD-Core Version:    0.7.0.1
 */