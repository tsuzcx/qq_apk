package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.ConcurrentHashMap;

public class BaseURLDrawableHelper
{
  public static Drawable getFailedDrawable()
  {
    Bitmap localBitmap1;
    if (GlobalImageCache.b != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.b.get("static://CommonFailedDrawable");
    } else {
      localBitmap1 = null;
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(BaseApplication.getContext().getResources(), 2130847909);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (GlobalImageCache.b != null)
        {
          GlobalImageCache.b.put("static://CommonFailedDrawable", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    if (localBitmap2 != null) {
      return new BitmapDrawable(localBitmap2);
    }
    return new ColorDrawable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseURLDrawableHelper
 * JD-Core Version:    0.7.0.1
 */