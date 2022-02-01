package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.tencent.xweb.n;
import java.io.File;
import org.xwalk.core.XWalkLongScreenshotCallback;

public class g$d
  extends XWalkLongScreenshotCallback
{
  private n a;
  
  public g$d(n paramn)
  {
    this.a = paramn;
  }
  
  public File getCacheFileDir()
  {
    return this.a.getCacheFileDir();
  }
  
  public int getMaxHeightSupported()
  {
    return this.a.getMaxHeightSupported();
  }
  
  public File getResultFileDir()
  {
    return this.a.getResultFileDir();
  }
  
  public void onLongScreenshotFinished(int paramInt, @Nullable String paramString)
  {
    this.a.onLongScreenshotFinished(paramInt, paramString);
  }
  
  public Bitmap overrideScreenshot(Bitmap paramBitmap)
  {
    return this.a.overrideScreenshot(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.g.d
 * JD-Core Version:    0.7.0.1
 */