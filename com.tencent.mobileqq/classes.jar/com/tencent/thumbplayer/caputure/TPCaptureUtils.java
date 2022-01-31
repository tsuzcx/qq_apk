package com.tencent.thumbplayer.caputure;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import java.nio.ByteBuffer;

public class TPCaptureUtils
{
  private static Bitmap byte2Bitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565);
    localBitmap.copyPixelsFromBuffer(paramArrayOfByte);
    paramArrayOfByte = localBitmap;
    if (paramInt3 != 0)
    {
      paramArrayOfByte = new Matrix();
      paramArrayOfByte.postRotate(paramInt3);
      paramArrayOfByte = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), paramArrayOfByte, true);
    }
    return paramArrayOfByte;
  }
  
  public static Bitmap frame2Bitmap(TPVideoFrame paramTPVideoFrame)
  {
    if ((paramTPVideoFrame.data.length <= 0) || (paramTPVideoFrame.height == 0) || (paramTPVideoFrame.width == 0)) {
      return null;
    }
    return byte2Bitmap(paramTPVideoFrame.data[0], paramTPVideoFrame.width, paramTPVideoFrame.height, paramTPVideoFrame.rotation);
  }
  
  public static Bitmap[] frame2Bitmaps(TPVideoFrame paramTPVideoFrame)
  {
    if ((paramTPVideoFrame.data.length <= 0) || (paramTPVideoFrame.height == 0) || (paramTPVideoFrame.width == 0)) {
      return null;
    }
    Bitmap[] arrayOfBitmap = new Bitmap[paramTPVideoFrame.data.length];
    int i = 0;
    while (i < paramTPVideoFrame.data.length)
    {
      arrayOfBitmap[i] = byte2Bitmap(paramTPVideoFrame.data[i], paramTPVideoFrame.width, paramTPVideoFrame.height, paramTPVideoFrame.rotation);
      i += 1;
    }
    return arrayOfBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.caputure.TPCaptureUtils
 * JD-Core Version:    0.7.0.1
 */