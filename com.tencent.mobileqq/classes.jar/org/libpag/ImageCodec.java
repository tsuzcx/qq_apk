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
    for (;;)
    {
      try
      {
        BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
        j = localOptions.outWidth;
        paramArrayOfByte.printStackTrace();
      }
      catch (Exception paramArrayOfByte)
      {
        try
        {
          i = localOptions.outHeight;
          return new int[] { j, i };
        }
        catch (Exception paramArrayOfByte)
        {
          for (;;)
          {
            int j;
            int i = j;
          }
        }
        paramArrayOfByte = paramArrayOfByte;
        i = 0;
      }
      j = i;
      i = 0;
    }
  }
  
  private static int[] GetSizeFromPath(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    for (;;)
    {
      try
      {
        BitmapFactory.decodeFile(paramString, localOptions);
        j = localOptions.outWidth;
        paramString.printStackTrace();
      }
      catch (Exception paramString)
      {
        try
        {
          i = localOptions.outHeight;
          return new int[] { j, i };
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            int j;
            int i = j;
          }
        }
        paramString = paramString;
        i = 0;
      }
      j = i;
      i = 0;
    }
  }
  
  private static boolean ReadPixelsFromBytes(byte[] paramArrayOfByte, ByteBuffer paramByteBuffer)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.getConfig() != Bitmap.Config.ARGB_8888)) {
      return false;
    }
    paramArrayOfByte.copyPixelsToBuffer(paramByteBuffer);
    return true;
  }
  
  private static boolean ReadPixelsFromPath(String paramString, ByteBuffer paramByteBuffer)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    paramString = BitmapFactory.decodeFile(paramString, localOptions);
    if ((paramString == null) || (paramString.getConfig() != Bitmap.Config.ARGB_8888)) {
      return false;
    }
    paramString.copyPixelsToBuffer(paramByteBuffer);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.libpag.ImageCodec
 * JD-Core Version:    0.7.0.1
 */