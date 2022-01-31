package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class DisplacementProcess
{
  private static void calcHorizontialPosition(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt2 == null)) {}
    for (;;)
    {
      return;
      paramInt3 = paramInt2 * paramInt1;
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
    return 0xFF000000 | 0xFFFFFF & paramInt;
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
      int[] arrayOfInt1 = new int[j * k];
      int[] arrayOfInt2 = new int[j * k];
      paramBitmap.getPixels(arrayOfInt1, 0, j, 0, 0, j, k);
      int i = 0;
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
    catch (OutOfMemoryError paramBitmap)
    {
      label92:
      break label92;
    }
  }
  
  /* Error */
  private static void saveBitmap(Bitmap paramBitmap, java.lang.String paramString)
  {
    // Byte code:
    //   0: new 65	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: new 65	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: invokevirtual 72	java/io/File:getParent	()Ljava/lang/String;
    //   17: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: invokevirtual 76	java/io/File:exists	()Z
    //   25: ifne +8 -> 33
    //   28: aload_2
    //   29: invokevirtual 79	java/io/File:mkdirs	()Z
    //   32: pop
    //   33: new 81	java/io/FileOutputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 84	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   41: astore_1
    //   42: aload_0
    //   43: getstatic 90	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   46: bipush 100
    //   48: aload_1
    //   49: invokevirtual 94	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   52: pop
    //   53: aload_1
    //   54: astore_0
    //   55: aload_0
    //   56: ifnull +11 -> 67
    //   59: aload_0
    //   60: invokevirtual 97	java/io/FileOutputStream:flush	()V
    //   63: aload_0
    //   64: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   67: return
    //   68: astore_2
    //   69: aconst_null
    //   70: astore_0
    //   71: aload_2
    //   72: invokevirtual 101	java/io/FileNotFoundException:printStackTrace	()V
    //   75: goto -20 -> 55
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 102	java/io/IOException:printStackTrace	()V
    //   83: return
    //   84: astore_2
    //   85: aload_1
    //   86: astore_0
    //   87: goto -16 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramBitmap	Bitmap
    //   0	90	1	paramString	java.lang.String
    //   20	9	2	localFile	java.io.File
    //   68	4	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   84	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   33	42	68	java/io/FileNotFoundException
    //   59	67	78	java/io/IOException
    //   42	53	84	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mtveffects.DisplacementProcess
 * JD-Core Version:    0.7.0.1
 */