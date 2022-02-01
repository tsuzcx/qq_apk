package com.tencent.mobileqq.transfile.bitmapcreator;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class FileBitmapDecoder
{
  private static final String TAG = "FileBitmapDecoder";
  
  public Bitmap getBitmap(String paramString, int paramInt1, int paramInt2, int paramInt3, BitmapFactory.Options paramOptions)
  {
    BitmapFactory.Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = new BitmapFactory.Options();
    }
    if (paramInt3 == 0) {
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, localOptions);
      }
    }
    for (localOptions.inSampleSize = ImageUtil.a(localOptions, paramInt1, paramInt2);; localOptions.inSampleSize = paramInt3)
    {
      localOptions.inJustDecodeBounds = false;
      try
      {
        paramString = BitmapFactory.decodeFile(paramString, localOptions);
        return paramString;
      }
      catch (OutOfMemoryError paramString)
      {
        if (!QLog.isColorLevel()) {
          break label116;
        }
        QLog.e("FileBitmapDecoder", 2, "getBitmap(): OutOfMemoryError, " + paramString.getMessage());
      }
    }
    label116:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.bitmapcreator.FileBitmapDecoder
 * JD-Core Version:    0.7.0.1
 */