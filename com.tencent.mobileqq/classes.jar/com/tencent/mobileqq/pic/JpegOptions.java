package com.tencent.mobileqq.pic;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public final class JpegOptions
{
  static final JpegOptions DEFAULT = new JpegOptions();
  public Bitmap inBitmap = null;
  public boolean inDither = false;
  public boolean inJustDecodeBounds = false;
  public boolean inPreferQualityOverSpeed = true;
  public Bitmap.Config inPreferredConfig = Bitmap.Config.ARGB_8888;
  public int inSampleSize = 1;
  public int outHeight = 0;
  public int outWidth = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.JpegOptions
 * JD-Core Version:    0.7.0.1
 */