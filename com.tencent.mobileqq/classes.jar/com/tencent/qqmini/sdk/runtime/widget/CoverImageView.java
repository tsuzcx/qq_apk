package com.tencent.qqmini.sdk.runtime.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.qqmini.sdk.core.widget.CoverView;

public class CoverImageView
  extends CoverView
{
  private ImageView a;
  
  public CoverImageView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.a = new ImageView(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.a.setScaleType(ImageView.ScaleType.FIT_XY);
    addView(this.a, paramContext);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.a.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.a.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.CoverImageView
 * JD-Core Version:    0.7.0.1
 */