package com.tencent.tavkit.utils;

import android.media.ExifInterface;
import java.io.IOException;

public class TAVBitmapUtils
{
  public static int readImagePreferRotation(String paramString)
  {
    int i = 1;
    try
    {
      int j = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      switch (j)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        i = 0;
      case 8: 
        return i;
      case 6: 
        return 3;
      }
      return 2;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.utils.TAVBitmapUtils
 * JD-Core Version:    0.7.0.1
 */