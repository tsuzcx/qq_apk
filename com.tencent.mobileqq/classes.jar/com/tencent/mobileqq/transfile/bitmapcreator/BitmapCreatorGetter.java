package com.tencent.mobileqq.transfile.bitmapcreator;

import android.graphics.Bitmap;

public class BitmapCreatorGetter
{
  BitmapCreator a;
  
  protected Bitmap b(Bitmap paramBitmap)
  {
    if (this.a == null) {
      return paramBitmap;
    }
    return this.a.a(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.bitmapcreator.BitmapCreatorGetter
 * JD-Core Version:    0.7.0.1
 */