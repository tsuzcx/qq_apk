package com.tencent.mobileqq.richmediabrowser;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.image.JpegExifReader;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.photo.incompatiblephoto.PhotoIncompatibleBase;

public class URLDrawableHelper
{
  public static final Drawable a = new ColorDrawable(0);
  
  public static int a(String paramString)
  {
    if (PhotoIncompatibleBase.b(paramString))
    {
      int i = Utils.getHeifOrientation(paramString);
      if (i != 3)
      {
        if (i != 6)
        {
          if (i != 8) {
            return 0;
          }
          return 270;
        }
        return 90;
      }
      return 180;
    }
    return JpegExifReader.getRotationDegree(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.URLDrawableHelper
 * JD-Core Version:    0.7.0.1
 */