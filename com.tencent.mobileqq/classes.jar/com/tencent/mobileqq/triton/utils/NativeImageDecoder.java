package com.tencent.mobileqq.triton.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import com.tencent.mobileqq.triton.internal.utils.Logger;

@TritonKeep
public class NativeImageDecoder
{
  private static int MAX_IMAGE_HEIGHT = 1024;
  private static int MAX_IMAGE_WIDTH = 1024;
  private static final String TAG = "NativeImageDecoder";
  
  @TritonKeep
  public static Bitmap decodeGifBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    Bitmap localBitmap2 = decodeImageBuffer(paramArrayOfByte, paramInt);
    if ((localBitmap2 != null) && (!localBitmap2.isRecycled()))
    {
      if (localBitmap2.getConfig() != Bitmap.Config.ARGB_8888)
      {
        Bitmap localBitmap1 = localBitmap2.copy(Bitmap.Config.ARGB_8888, true);
        paramArrayOfByte = localBitmap1;
        if (localBitmap1 == null)
        {
          paramArrayOfByte = Bitmap.createBitmap(localBitmap2.getWidth(), localBitmap2.getHeight(), Bitmap.Config.ARGB_8888);
          new Canvas(paramArrayOfByte).drawBitmap(localBitmap2, 0.0F, 0.0F, null);
          return paramArrayOfByte;
        }
      }
      else
      {
        return localBitmap2;
      }
    }
    else {
      paramArrayOfByte = null;
    }
    return paramArrayOfByte;
  }
  
  @TritonKeep
  public static Bitmap decodeImageBuffer(byte[] paramArrayOfByte, int paramInt)
  {
    return decodeImageBuffer(paramArrayOfByte, paramInt, MAX_IMAGE_WIDTH * 2, MAX_IMAGE_HEIGHT * 2);
  }
  
  public static Bitmap decodeImageBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      localObject = new BitmapFactory.Options();
      int i = 1;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramInt1);
      int j = ((BitmapFactory.Options)localObject).outWidth;
      int k = ((BitmapFactory.Options)localObject).outHeight;
      if ((j > paramInt2) || (k > paramInt3)) {
        i = Math.min(Math.round(j / paramInt2), Math.round(k / paramInt3));
      }
      ((BitmapFactory.Options)localObject).inSampleSize = i;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramInt1);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodeJpgBuffer failed:");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      Logger.e("NativeImageDecoder", ((StringBuilder)localObject).toString());
      return null;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodeJpgBuffer oom:");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      Logger.e("NativeImageDecoder", ((StringBuilder)localObject).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.utils.NativeImageDecoder
 * JD-Core Version:    0.7.0.1
 */