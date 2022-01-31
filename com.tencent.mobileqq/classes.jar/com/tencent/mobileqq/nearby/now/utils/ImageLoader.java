package com.tencent.mobileqq.nearby.now.utils;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;

public class ImageLoader
{
  private static ImageLoader a = new ImageLoader();
  
  public static ImageLoader a()
  {
    return a;
  }
  
  public void a(ImageView paramImageView, String paramString, Drawable paramDrawable1, Drawable paramDrawable2, int paramInt1, int paramInt2, URLDrawable.URLDrawableListener paramURLDrawableListener, boolean paramBoolean)
  {
    if ((paramImageView == null) || (TextUtils.isEmpty(paramString)))
    {
      SLog.e("ImageLoader", "ImageView or uri is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ImageLoader", 2, "uri:" + paramString + ",width:" + paramInt1 + ",height:" + paramInt2);
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
    }
    Drawable localDrawable = paramDrawable1;
    if (paramDrawable1 == null) {
      localDrawable = URLDrawableHelper.a;
    }
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    paramDrawable1 = paramDrawable2;
    if (paramDrawable2 == null) {
      paramDrawable1 = URLDrawableHelper.a;
    }
    localURLDrawableOptions.mLoadingDrawable = paramDrawable1;
    localURLDrawableOptions.mMemoryCacheKeySuffix = "now";
    localURLDrawableOptions.mUseAutoScaleParams = false;
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramBoolean) {
      paramString.setDecodeHandler(URLDrawableDecodeHandler.a);
    }
    if (paramURLDrawableListener != null)
    {
      if (paramString.getStatus() != 1) {
        break label208;
      }
      SLog.b("ImageLoader", "URLDrawable's status is SUCCESSED.");
      paramURLDrawableListener.onLoadSuccessed(paramString);
    }
    for (;;)
    {
      paramString.setURLDrawableListener(paramURLDrawableListener);
      paramImageView.setImageDrawable(paramString);
      return;
      label208:
      SLog.b("ImageLoader", "start load URLDrawable.");
    }
  }
  
  public void a(ImageView paramImageView, String paramString, Drawable paramDrawable1, Drawable paramDrawable2, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    a(paramImageView, paramString, paramDrawable1, paramDrawable2, 0, 0, paramURLDrawableListener, false);
  }
  
  public void a(ImageView paramImageView, String paramString, Drawable paramDrawable1, Drawable paramDrawable2, URLDrawable.URLDrawableListener paramURLDrawableListener, boolean paramBoolean)
  {
    a(paramImageView, paramString, paramDrawable1, paramDrawable2, 0, 0, paramURLDrawableListener, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.ImageLoader
 * JD-Core Version:    0.7.0.1
 */