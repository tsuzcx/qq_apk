package com.tencent.mobileqq.wink.pick;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.transfile.BaseURLDrawableHelper;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.widget.Gallery;
import java.net.URL;

public class URLDrawableHelper
  extends BaseURLDrawableHelper
{
  public static Bitmap.Config a = Bitmap.Config.ARGB_8888;
  public static Bitmap.Config b = Bitmap.Config.RGB_565;
  public static int c = 921600;
  public static final Drawable d = new ColorDrawable(0);
  public static int e;
  public static int f;
  private static int g;
  private static boolean h = false;
  private static int i;
  
  static
  {
    e = 45;
    f = Gallery.AIO_IMAGE_MAX_SIZE;
    i = -1;
    Context localContext = RFApplication.getApplication();
    if (localContext != null)
    {
      e = (int)DisplayUtils.a(localContext, 45.0F);
      g = localContext.getResources().getDisplayMetrics().densityDpi;
    }
  }
  
  public static URLDrawable a(URL paramURL)
  {
    return a(paramURL, 0, 0, null, null, false, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean, float paramFloat)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramInt1;
    localURLDrawableOptions.mRequestHeight = paramInt2;
    localURLDrawableOptions.mLoadingDrawable = paramDrawable1;
    localURLDrawableOptions.mFailedDrawable = paramDrawable2;
    localURLDrawableOptions.mPlayGifImage = paramBoolean;
    localURLDrawableOptions.mGifRoundCorner = paramFloat;
    return URLDrawable.getDrawable(paramURL, localURLDrawableOptions);
  }
  
  public static URLDrawable a(URL paramURL, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return a(paramURL, 0, 0, paramDrawable1, paramDrawable2, false, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.URLDrawableHelper
 * JD-Core Version:    0.7.0.1
 */