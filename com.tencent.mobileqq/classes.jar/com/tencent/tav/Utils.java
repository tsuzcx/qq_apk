package com.tencent.tav;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build;
import android.text.TextUtils;

public class Utils
{
  public static Bitmap flipYBitmap(Bitmap paramBitmap)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(1.0F, -1.0F, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  public static String getPhoneName()
  {
    String str = Build.MANUFACTURER.toUpperCase() + " " + Build.MODEL;
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    return str.replace(" ", "_").replace("+", "").replace("(t)", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.tav.Utils
 * JD-Core Version:    0.7.0.1
 */