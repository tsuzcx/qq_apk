package com.tencent.xweb;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import java.io.File;

public abstract interface n
{
  public abstract File getCacheFileDir();
  
  public abstract int getMaxHeightSupported();
  
  public abstract File getResultFileDir();
  
  public abstract void onLongScreenshotFinished(int paramInt, @Nullable String paramString);
  
  public abstract Bitmap overrideScreenshot(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.n
 * JD-Core Version:    0.7.0.1
 */