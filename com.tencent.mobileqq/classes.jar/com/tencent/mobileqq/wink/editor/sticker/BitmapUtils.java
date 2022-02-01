package com.tencent.mobileqq.wink.editor.sticker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

public class BitmapUtils
{
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    int i = j;
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return 1;
      }
      if (k <= paramInt2)
      {
        i = j;
        if (m <= paramInt1) {}
      }
      else
      {
        i = Math.min(Math.round(k / paramInt2), Math.round(m / paramInt1));
        float f1 = m * k;
        float f2 = paramInt1 * paramInt2 * 2;
        paramInt1 = i;
        for (;;)
        {
          i = paramInt1;
          if (f1 / (paramInt1 * paramInt1) <= f2) {
            break;
          }
          paramInt1 += 1;
        }
      }
    }
    return i;
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = a(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    localOptions.inPreferQualityOverSpeed = true;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
      return localBitmap;
    }
    catch (Exception paramString)
    {
      break label65;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label49:
      break label49;
    }
    localOptions.inSampleSize *= 2;
    return BitmapFactory.decodeFile(paramString, localOptions);
    label65:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.sticker.BitmapUtils
 * JD-Core Version:    0.7.0.1
 */