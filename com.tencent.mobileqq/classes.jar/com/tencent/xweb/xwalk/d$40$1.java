package com.tencent.xweb.xwalk;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.tencent.xweb.n;
import java.io.File;
import org.xwalk.core.Log;

class d$40$1
  implements n
{
  d$40$1(d.40 param40) {}
  
  public File getCacheFileDir()
  {
    return new File(d.i(this.a.a).getExternalCacheDir().getAbsolutePath(), "LongScreenshot");
  }
  
  public int getMaxHeightSupported()
  {
    return 0;
  }
  
  public File getResultFileDir()
  {
    return new File(d.i(this.a.a).getExternalCacheDir().getAbsolutePath(), "LongScreenshot");
  }
  
  public void onLongScreenshotFinished(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLongScreenshotFinished with ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" / ");
    localStringBuilder.append(paramString);
    Log.d("WebDebugPage", localStringBuilder.toString());
  }
  
  public Bitmap overrideScreenshot(Bitmap paramBitmap)
  {
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.40.1
 * JD-Core Version:    0.7.0.1
 */