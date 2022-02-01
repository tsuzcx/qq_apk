package org.libpag;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.nio.ByteBuffer;

public class ImageCodec
{
  private static int[] GetSizeFromBytes(byte[] paramArrayOfByte)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    int i;
    try
    {
      BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
      i = localOptions.outWidth;
      try
      {
        j = localOptions.outHeight;
      }
      catch (Exception paramArrayOfByte) {}
      paramArrayOfByte.printStackTrace();
    }
    catch (Exception paramArrayOfByte)
    {
      i = 0;
    }
    int j = 0;
    return new int[] { i, j };
  }
  
  private static int[] GetSizeFromPath(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    int i;
    try
    {
      BitmapFactory.decodeFile(paramString, localOptions);
      i = localOptions.outWidth;
      try
      {
        j = localOptions.outHeight;
      }
      catch (Exception paramString) {}
      paramString.printStackTrace();
    }
    catch (Exception paramString)
    {
      i = 0;
    }
    int j = 0;
    return new int[] { i, j };
  }
  
  private static boolean ReadPixelsFromBytes(byte[] paramArrayOfByte, ByteBuffer paramByteBuffer)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.getConfig() != Bitmap.Config.ARGB_8888) {
        return false;
      }
      paramArrayOfByte.copyPixelsToBuffer(paramByteBuffer);
      return true;
    }
    return false;
  }
  
  private static boolean ReadPixelsFromPath(String paramString, ByteBuffer paramByteBuffer)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    paramString = BitmapFactory.decodeFile(paramString, localOptions);
    if ((paramString != null) && (paramString.getConfig() == Bitmap.Config.ARGB_8888))
    {
      paramString.copyPixelsToBuffer(paramByteBuffer);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.libpag.ImageCodec
 * JD-Core Version:    0.7.0.1
 */