package com.tencent.mobileqq.nearby.now.utils.impl;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qphone.base.util.QLog;

public class ImageLoaderImpl
  implements IImageLoader
{
  private static final String TAG = "ImageLoader";
  
  public void displayImage(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    displayImage(paramImageView, paramString, null, null, paramInt1, paramInt2, paramURLDrawableListener, false);
  }
  
  public void displayImage(ImageView paramImageView, String paramString, Drawable paramDrawable1, Drawable paramDrawable2, int paramInt1, int paramInt2, URLDrawable.URLDrawableListener paramURLDrawableListener, boolean paramBoolean)
  {
    if ((paramImageView != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("uri:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(",width:");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(",height:");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("ImageLoader", 2, ((StringBuilder)localObject).toString());
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        localURLDrawableOptions.mRequestWidth = paramInt1;
        localURLDrawableOptions.mRequestHeight = paramInt2;
      }
      Object localObject = paramDrawable1;
      if (paramDrawable1 == null) {
        localObject = URLDrawableHelperConstants.a;
      }
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      paramDrawable1 = paramDrawable2;
      if (paramDrawable2 == null) {
        paramDrawable1 = URLDrawableHelperConstants.a;
      }
      localURLDrawableOptions.mLoadingDrawable = paramDrawable1;
      localURLDrawableOptions.mMemoryCacheKeySuffix = "now";
      localURLDrawableOptions.mUseAutoScaleParams = false;
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramBoolean) {
        paramString.setDecodeHandler(URLDrawableDecodeHandler.b);
      }
      if (paramURLDrawableListener != null)
      {
        if (paramString.getStatus() == 1)
        {
          SLog.b("ImageLoader", "URLDrawable's status is SUCCESSED.");
          paramURLDrawableListener.onLoadSuccessed(paramString);
        }
        else
        {
          SLog.b("ImageLoader", "start load URLDrawable.");
        }
        paramString.setURLDrawableListener(paramURLDrawableListener);
      }
      paramImageView.setImageDrawable(paramString);
      return;
    }
    SLog.e("ImageLoader", "ImageView or uri is null.");
  }
  
  public void displayImage(ImageView paramImageView, String paramString, Drawable paramDrawable1, Drawable paramDrawable2, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    displayImage(paramImageView, paramString, paramDrawable1, paramDrawable2, 0, 0, paramURLDrawableListener, false);
  }
  
  public void displayImage(ImageView paramImageView, String paramString, Drawable paramDrawable1, Drawable paramDrawable2, URLDrawable.URLDrawableListener paramURLDrawableListener, boolean paramBoolean)
  {
    displayImage(paramImageView, paramString, paramDrawable1, paramDrawable2, 0, 0, paramURLDrawableListener, paramBoolean);
  }
  
  public void displayImage(ImageView paramImageView, String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    displayImage(paramImageView, paramString, null, null, 0, 0, paramURLDrawableListener, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.impl.ImageLoaderImpl
 * JD-Core Version:    0.7.0.1
 */