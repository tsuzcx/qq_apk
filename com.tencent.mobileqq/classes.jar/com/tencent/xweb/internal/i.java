package com.tencent.xweb.internal;

import android.text.TextUtils;
import com.tencent.xweb.util.e;
import com.tencent.xweb.util.e.a;
import java.util.ArrayList;
import java.util.List;
import org.xwalk.core.Log;

public class i
{
  public double a;
  public double b;
  public double[] c = new double[0];
  public double d = 1.0D;
  
  public static List<i> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    paramString = paramString.split(";");
    if (paramString != null)
    {
      if (paramString.length == 0) {
        return localArrayList;
      }
      e.b();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = b((String)localObject);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static i b(String paramString)
  {
    i locali = new i();
    paramString = paramString.replace("(", "-").replace(")", "").split("-");
    if ((paramString != null) && (paramString.length >= 2))
    {
      int i = 0;
      double d1 = e.c(paramString[0]);
      if ((d1 >= 0.0D) && (d1 <= 24.0D))
      {
        locali.a = d1;
        d1 = e.c(paramString[1]);
        if ((d1 >= 0.0D) && (d1 <= 24.0D))
        {
          locali.b = d1;
          if (paramString.length == 3)
          {
            paramString = e.a(paramString[2]);
            if (!paramString.a)
            {
              Log.e("getTimeRangeItem", "scale parse error");
              return null;
            }
            d1 = paramString.a();
            if ((d1 >= 0.0D) && (d1 <= 1000000.0000999999D))
            {
              locali.d = d1;
              return locali;
            }
            Log.e("getTimeRangeItem", "scale parse value error");
            return null;
          }
          if (paramString.length > 3)
          {
            double[] arrayOfDouble = new double[paramString.length - 2];
            for (;;)
            {
              int j = i + 2;
              if (j >= paramString.length) {
                break label270;
              }
              e.a locala = e.a(paramString[j]);
              if (!locala.a)
              {
                Log.e("getTimeRangeItem", "scales parse error");
                return null;
              }
              d1 = locala.a();
              if ((d1 < 0.0D) || (d1 > 1000000.0000999999D)) {
                break;
              }
              arrayOfDouble[i] = d1;
              i += 1;
            }
            Log.e("getTimeRangeItem", "scales parse value error");
            return null;
            label270:
            locali.c = arrayOfDouble;
          }
          return locali;
        }
        Log.e("getTimeRangeItem", "bind.rangeFrom.timeEnd parse error");
        return null;
      }
      Log.e("getTimeRangeItem", "bind.rangeFrom.timeStart parse error");
      return null;
    }
    Log.e("getTimeRangeItem", "length error");
    return null;
  }
  
  public double a(double paramDouble)
  {
    double d2 = this.a;
    if (paramDouble >= d2)
    {
      double d1 = this.b;
      if (paramDouble <= d1)
      {
        double[] arrayOfDouble = this.c;
        if ((arrayOfDouble != null) && (arrayOfDouble.length != 0))
        {
          int j = arrayOfDouble.length;
          int i = 0;
          if (j == 1) {
            return arrayOfDouble[0];
          }
          if (paramDouble == d1) {
            return arrayOfDouble[(arrayOfDouble.length - 1)];
          }
          int k = arrayOfDouble.length - 1;
          double d3 = k;
          Double.isNaN(d3);
          d1 = (d1 - d2) / d3;
          paramDouble -= d2;
          while (i < k)
          {
            j = i + 1;
            d2 = j;
            Double.isNaN(d2);
            d3 = i;
            Double.isNaN(d3);
            if (paramDouble <= d2 * d1)
            {
              arrayOfDouble = this.c;
              return arrayOfDouble[i] + (arrayOfDouble[j] - arrayOfDouble[i]) * (paramDouble - d3 * d1) / d1;
            }
            i = j;
          }
          arrayOfDouble = this.c;
          return arrayOfDouble[(arrayOfDouble.length - 1)];
        }
        return this.d;
      }
    }
    return 0.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.internal.i
 * JD-Core Version:    0.7.0.1
 */