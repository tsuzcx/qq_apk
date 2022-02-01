package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DisplacementProcess
{
  private static void calcHorizontialPosition(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramArrayOfInt1 != null)
    {
      if (paramArrayOfInt2 == null) {
        return;
      }
      paramInt3 = paramInt1 * paramInt2;
      paramInt1 = paramInt3;
      while (paramInt1 < paramInt2)
      {
        paramArrayOfInt1[paramInt1] = -1;
        paramInt1 += 1;
      }
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        int i = paramInt3 + paramInt1;
        int j = paramArrayOfInt2[i];
        j = (int)((grayValue(j >> 16 & 0xFF, j >> 8 & 0xFF, j & 0xFF) - 128) * paramInt4 * 1.0F / 255.0F) + i;
        if ((j >= paramInt3) && (j < paramInt3 + paramInt2)) {
          paramArrayOfInt1[j] = formatCoordinate((int)((i - paramInt3) * 1.0F / paramInt2 * 15728640.0F));
        }
        paramInt1 += 1;
      }
    }
  }
  
  private static int formatCoordinate(int paramInt)
  {
    return paramInt & 0xFFFFFF | 0xFF000000;
  }
  
  private static int grayValue(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 * 299 + paramInt2 * 587 + paramInt3 * 114) / 1000;
  }
  
  public static Bitmap horizontialProcess(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      int j = paramBitmap.getWidth();
      int k = paramBitmap.getHeight();
      int i = j * k;
      int[] arrayOfInt1 = new int[i];
      int[] arrayOfInt2 = new int[i];
      paramBitmap.getPixels(arrayOfInt1, 0, j, 0, 0, j, k);
      i = 0;
      while (i < k)
      {
        calcHorizontialPosition(arrayOfInt2, arrayOfInt1, i, j, k, paramInt);
        i += 1;
      }
      paramBitmap = Bitmap.createBitmap(arrayOfInt2, j, k, Bitmap.Config.ARGB_8888);
      return paramBitmap;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError paramBitmap) {}
    return null;
  }
  
  private static void saveBitmap(Bitmap paramBitmap, String paramString)
  {
    paramString = new File(paramString);
    File localFile = new File(paramString.getParent());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    try
    {
      paramString = new FileOutputStream(paramString);
      try
      {
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, paramString);
        paramBitmap = paramString;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        paramBitmap = paramString;
        paramString = localFileNotFoundException;
      }
      paramString.printStackTrace();
    }
    catch (FileNotFoundException paramString)
    {
      paramBitmap = null;
    }
    if (paramBitmap != null) {
      try
      {
        paramBitmap.flush();
        paramBitmap.close();
        return;
      }
      catch (IOException paramBitmap)
      {
        paramBitmap.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.DisplacementProcess
 * JD-Core Version:    0.7.0.1
 */