package com.tencent.tavkit.utils;

import android.media.ExifInterface;
import com.tencent.tav.decoder.logger.Logger;
import java.io.IOException;

public class TAVBitmapUtils
{
  private static final String TAG = "TAVBitmapUtils";
  
  public static int readImagePreferRotation(String paramString)
  {
    try
    {
      int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      if (i != 3)
      {
        if (i != 6)
        {
          if (i != 8) {
            return 0;
          }
          return 1;
        }
        return 3;
      }
      return 2;
    }
    catch (IOException paramString)
    {
      Logger.e("TAVBitmapUtils", "readImagePreferRotation: ", paramString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.utils.TAVBitmapUtils
 * JD-Core Version:    0.7.0.1
 */