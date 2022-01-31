package com.tencent.mobileqq.musicgene;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BitmapOptionUtil
{
  private static List a(float[][] paramArrayOfFloat)
  {
    int[] arrayOfInt = new int[8];
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < paramArrayOfFloat.length)
    {
      j = 1;
      for (;;)
      {
        if (j <= 7)
        {
          if (paramArrayOfFloat[i][0] < 360.0F * (j / 7.0F))
          {
            arrayOfInt[j] += 1;
            List localList = (List)localHashMap.get(Integer.valueOf(j));
            Object localObject = localList;
            if (localList == null) {
              localObject = new ArrayList();
            }
            ((List)localObject).add(paramArrayOfFloat[i]);
            localHashMap.put(Integer.valueOf(j), localObject);
          }
        }
        else
        {
          i += 1;
          break;
        }
        j += 1;
      }
    }
    int k = -1;
    int j = 0;
    i = 1;
    while (i <= 7)
    {
      int m = j;
      if (arrayOfInt[i] > j)
      {
        m = arrayOfInt[i];
        k = i;
      }
      i += 1;
      j = m;
    }
    if (localHashMap.containsKey(Integer.valueOf(k))) {
      return (List)localHashMap.get(Integer.valueOf(k));
    }
    return new ArrayList();
  }
  
  private static float[] a(List paramList)
  {
    float[] arrayOfFloat;
    int i;
    if (paramList.size() > 4)
    {
      arrayOfFloat = null;
      i = 0;
      if (i < paramList.size())
      {
        if (((float[])paramList.get(i))[2] >= 3.4028235E+38F) {
          break label122;
        }
        arrayOfFloat = (float[])paramList.get(i);
      }
    }
    label122:
    for (;;)
    {
      i += 1;
      break;
      if (arrayOfFloat[2] > 0.15D) {
        arrayOfFloat[2] -= 0.1F;
      }
      while (arrayOfFloat[1] <= 0.5D) {
        return arrayOfFloat;
      }
      arrayOfFloat[1] -= 0.1F;
      return arrayOfFloat;
      paramList = (float[])paramList.get(0);
      paramList[2] = 0.15F;
      return paramList;
    }
  }
  
  public static int[] a(Bitmap paramBitmap)
  {
    paramBitmap = a(a(a(b(paramBitmap))));
    float[] arrayOfFloat = new float[3];
    if (paramBitmap[2] <= 0.15D)
    {
      arrayOfFloat[0] = paramBitmap[0];
      arrayOfFloat[1] = paramBitmap[1];
      paramBitmap[2] += 0.7F;
    }
    for (;;)
    {
      if (arrayOfFloat[1] > 0.5F) {
        arrayOfFloat[1] -= 0.1F;
      }
      return new int[] { Color.HSVToColor(paramBitmap), Color.HSVToColor(arrayOfFloat) };
      arrayOfFloat[0] = paramBitmap[0];
      arrayOfFloat[1] = paramBitmap[1];
      if (paramBitmap[2] + 0.5D >= 1.0D) {
        paramBitmap[2] -= 0.5F;
      } else {
        paramBitmap[2] += 0.5F;
      }
    }
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
  
  private static int[] b(Bitmap paramBitmap)
  {
    paramBitmap = Bitmap.createScaledBitmap(paramBitmap, 4, 4, false);
    int[] arrayOfInt = new int[16];
    paramBitmap.getPixels(arrayOfInt, 0, 4, 0, 0, 4, 4);
    return arrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.BitmapOptionUtil
 * JD-Core Version:    0.7.0.1
 */