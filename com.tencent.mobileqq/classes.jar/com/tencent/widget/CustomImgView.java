package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;

public class CustomImgView
  extends FrameLayout
{
  public ImageView a;
  public ImageView b;
  
  public CustomImgView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CustomImgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public CustomImgView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new URLImageView(getContext());
    this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.a, localLayoutParams);
    this.b = new ImageView(getContext());
    this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView(this.b, localLayoutParams);
    this.b.setDuplicateParentStateEnabled(true);
  }
  
  public Drawable a()
  {
    return this.a.getDrawable();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.b.setImageDrawable(paramDrawable);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.a.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.a.setImageDrawable(paramDrawable);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    this.a.setScaleType(paramScaleType);
    this.b.setScaleType(paramScaleType);
  }
  
  public void setURLDrawableListener(URLDrawableDownListener paramURLDrawableDownListener)
  {
    if ((this.a != null) && ((this.a instanceof URLImageView))) {
      ((URLImageView)this.a).setURLDrawableDownListener(paramURLDrawableDownListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.CustomImgView
 * JD-Core Version:    0.7.0.1
 */