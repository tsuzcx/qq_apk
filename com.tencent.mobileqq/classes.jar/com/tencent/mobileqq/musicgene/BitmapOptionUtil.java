package com.tencent.mobileqq.musicgene;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BitmapOptionUtil
{
  private static List<float[]> a(float[][] paramArrayOfFloat)
  {
    int[] arrayOfInt = new int[8];
    HashMap localHashMap = new HashMap();
    int m = 0;
    int i = 0;
    for (;;)
    {
      k = paramArrayOfFloat.length;
      j = 1;
      if (i >= k) {
        break;
      }
      j = 1;
      while (j <= 7)
      {
        if (paramArrayOfFloat[i][0] < j / 7.0F * 360.0F)
        {
          arrayOfInt[j] += 1;
          List localList = (List)localHashMap.get(Integer.valueOf(j));
          Object localObject = localList;
          if (localList == null) {
            localObject = new ArrayList();
          }
          ((List)localObject).add(paramArrayOfFloat[i]);
          localHashMap.put(Integer.valueOf(j), localObject);
          break;
        }
        j += 1;
      }
      i += 1;
    }
    int k = -1;
    i = j;
    for (int j = m; i <= 7; j = m)
    {
      m = j;
      if (arrayOfInt[i] > j)
      {
        m = arrayOfInt[i];
        k = i;
      }
      i += 1;
    }
    if (localHashMap.containsKey(Integer.valueOf(k))) {
      return (List)localHashMap.get(Integer.valueOf(k));
    }
    return new ArrayList();
  }
  
  private static void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramArrayOfFloat1[2] <= 0.15D)
    {
      paramArrayOfFloat2[0] = paramArrayOfFloat1[0];
      paramArrayOfFloat2[1] = paramArrayOfFloat1[1];
      paramArrayOfFloat1[2] += 0.7F;
    }
    else
    {
      paramArrayOfFloat2[0] = paramArrayOfFloat1[0];
      paramArrayOfFloat2[1] = paramArrayOfFloat1[1];
      double d = paramArrayOfFloat1[2];
      Double.isNaN(d);
      if (d + 0.5D >= 1.0D) {
        paramArrayOfFloat1[2] -= 0.5F;
      } else {
        paramArrayOfFloat1[2] += 0.5F;
      }
    }
    if (paramArrayOfFloat2[1] > 0.5F) {
      paramArrayOfFloat2[1] -= 0.1F;
    }
  }
  
  private static float[] a(List<float[]> paramList)
  {
    int j = paramList.size();
    int i = 0;
    if (j > 4)
    {
      float f1 = 3.4028235E+38F;
      float[] arrayOfFloat = null;
      while (i < paramList.size())
      {
        float f2 = f1;
        if (((float[])paramList.get(i))[2] < f1)
        {
          f2 = ((float[])paramList.get(i))[2];
          arrayOfFloat = (float[])paramList.get(i);
        }
        i += 1;
        f1 = f2;
      }
      if (arrayOfFloat[2] > 0.15D) {
        arrayOfFloat[2] -= 0.1F;
      }
      if (arrayOfFloat[1] > 0.5D) {
        arrayOfFloat[1] -= 0.1F;
      }
      return arrayOfFloat;
    }
    paramList = (float[])paramList.get(0);
    paramList[2] = 0.15F;
    return paramList;
  }
  
  public static int[] a(int paramInt)
  {
    float[] arrayOfFloat1 = new float[3];
    Color.colorToHSV(paramInt, arrayOfFloat1);
    float[] arrayOfFloat2 = new float[3];
    a(arrayOfFloat1, arrayOfFloat2);
    return new int[] { Color.HSVToColor(arrayOfFloat1), Color.HSVToColor(arrayOfFloat2) };
  }
  
  public static int[] a(Bitmap paramBitmap)
  {
    paramBitmap = a(a(a(b(paramBitmap))));
    float[] arrayOfFloat = new float[3];
    b(paramBitmap, arrayOfFloat);
    return new int[] { Color.HSVToColor(paramBitmap), Color.HSVToColor(arrayOfFloat) };
  }
  
  private static float[][] a(int[] paramArrayOfInt)
  {
    float[][] arrayOfFloat = new float[16][];
    int i = 0;
    while (i < 16)
    {
      arrayOfFloat[i] = new float[3];
      Color.colorToHSV(paramArrayOfInt[i], arrayOfFloat[i]);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  private static void b(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float f4 = paramArrayOfFloat1[0];
    float f3 = paramArrayOfFloat1[1];
    float f1 = paramArrayOfFloat1[2];
    double d = f1;
    if (d <= 0.15D) {
      f1 += 0.7F;
    } else if (d <= 0.5D) {
      f1 += 0.5F;
    } else {
      f1 -= 0.5F;
    }
    float f2 = f3;
    if (f3 >= 0.5F) {
      f2 = f3 - 0.1F;
    }
    paramArrayOfFloat2[0] = f4;
    paramArrayOfFloat2[1] = f2;
    paramArrayOfFloat2[2] = f1;
  }
  
  private static int[] b(Bitmap paramBitmap)
  {
    paramBitmap = Bitmap.createScaledBitmap(paramBitmap, 4, 4, false);
    int[] arrayOfInt = new int[16];
    paramBitmap.getPixels(arrayOfInt, 0, 4, 0, 0, 4, 4);
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.BitmapOptionUtil
 * JD-Core Version:    0.7.0.1
 */