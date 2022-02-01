package com.tencent.ttpic.filament;

import android.graphics.Bitmap;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FurUtil
{
  private static Random randomColor = new Random();
  
  public static List<Bitmap> createFurTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramInt3)
    {
      byte[] arrayOfByte = new byte[paramInt2 * paramInt2 * 4];
      int j = 0;
      while (j < arrayOfByte.length)
      {
        arrayOfByte[j] = 0;
        j += 1;
      }
      float f1 = 1.0F - i / paramInt3;
      float f2 = Math.min(f1, 0.9F);
      int k = (int)(paramInt4 * f1 * 3.0F);
      Random localRandom = new Random(paramInt1);
      j = 0;
      while (j < k)
      {
        int m = localRandom.nextInt(paramInt2);
        int n = localRandom.nextInt(paramInt2);
        arrayOfByte[((m * paramInt2 + n) * 4 + 0)] = ((byte)(int)(255.0F * f2));
        arrayOfByte[((m * paramInt2 + n) * 4 + 1)] = ((byte)(int)(255.0F * f2));
        arrayOfByte[((m * paramInt2 + n) * 4 + 2)] = ((byte)(int)(255.0F * f2));
        arrayOfByte[((m * paramInt2 + n) * 4 + 3)] = ((byte)(int)(255.0F * f1));
        j += 1;
      }
      localArrayList.add(BitmapUtils.RGBA2Bitmap(arrayOfByte, paramInt2, paramInt2));
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<Bitmap> createFurTextureFromBitmap(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap paramBitmap)
  {
    ArrayList localArrayList = new ArrayList();
    byte[] arrayOfByte1 = BitmapUtils.bitmap2RGBA(paramBitmap);
    int i = 0;
    while (i < paramInt3)
    {
      byte[] arrayOfByte2 = new byte[paramInt2 * paramInt2 * 4];
      int j = 0;
      while (j < arrayOfByte2.length)
      {
        arrayOfByte2[j] = 0;
        j += 1;
      }
      float f1 = 1.0F - i / paramInt3;
      float f2 = Math.min(f1, 0.9F);
      int k = (int)(paramInt4 * f1 * 3.0F);
      Random localRandom1 = new Random(paramInt1);
      Random localRandom2 = new Random(paramInt1);
      j = 0;
      while (j < k)
      {
        int m = localRandom1.nextInt(paramInt2);
        int n = localRandom1.nextInt(paramInt2);
        int i1 = localRandom2.nextInt(paramBitmap.getWidth());
        int i2 = localRandom2.nextInt(paramBitmap.getHeight());
        arrayOfByte2[((m * paramInt2 + n) * 4 + 0)] = ((byte)(int)(arrayOfByte1[((paramBitmap.getWidth() * i2 + i1) * 4 + 0)] * f2));
        arrayOfByte2[((m * paramInt2 + n) * 4 + 1)] = ((byte)(int)(arrayOfByte1[((paramBitmap.getWidth() * i2 + i1) * 4 + 1)] * f2));
        arrayOfByte2[((m * paramInt2 + n) * 4 + 2)] = ((byte)(int)(arrayOfByte1[((i1 + i2 * paramBitmap.getWidth()) * 4 + 2)] * f2));
        arrayOfByte2[((m * paramInt2 + n) * 4 + 3)] = ((byte)(int)(255.0F * f1));
        j += 1;
      }
      localArrayList.add(BitmapUtils.RGBA2Bitmap(arrayOfByte2, paramInt2, paramInt2));
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filament.FurUtil
 * JD-Core Version:    0.7.0.1
 */