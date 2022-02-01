package com.tencent.mobileqq.nearby.now.utils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IImageLoader
  extends QRouteApi
{
  public abstract void displayImage(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, URLDrawable.URLDrawableListener paramURLDrawableListener);
  
  public abstract void displayImage(ImageView paramImageView, String paramString, Drawable paramDrawable1, Drawable paramDrawable2, int paramInt1, int paramInt2, URLDrawable.URLDrawableListener paramURLDrawableListener, boolean paramBoolean);
  
  public abstract void displayImage(ImageView paramImageView, String paramString, Drawable paramDrawable1, Drawable paramDrawable2, URLDrawable.URLDrawableListener paramURLDrawableListener);
  
  public abstract void displayImage(ImageView paramImageView, String paramString, Drawable paramDrawable1, Drawable paramDrawable2, URLDrawable.URLDrawableListener paramURLDrawableListener, boolean paramBoolean);
  
  public abstract void displayImage(ImageView paramImageView, String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.IImageLoader
 * JD-Core Version:    0.7.0.1
 */