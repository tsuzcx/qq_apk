package com.tencent.mobileqq.wink.pick.circle.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLImageView;

public class MultiTouchImageView
  extends URLImageView
{
  private PhotoViewAttacher a;
  private ImageView.ScaleType b;
  
  public MultiTouchImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = new PhotoViewAttacher(this);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    ImageView.ScaleType localScaleType = this.b;
    if (localScaleType != null)
    {
      setScaleType(localScaleType);
      this.b = null;
    }
  }
  
  public Matrix getImageMatrix()
  {
    return this.a.e();
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.a.c();
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    if (bool) {
      this.a.d();
    }
    return bool;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    paramDrawable = this.a;
    if (paramDrawable != null) {
      paramDrawable.d();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    PhotoViewAttacher localPhotoViewAttacher = this.a;
    if (localPhotoViewAttacher != null) {
      localPhotoViewAttacher.d();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    paramUri = this.a;
    if (paramUri != null) {
      paramUri.d();
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a.a(paramOnClickListener);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.a.a(paramOnLongClickListener);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    PhotoViewAttacher localPhotoViewAttacher = this.a;
    if (localPhotoViewAttacher == null)
    {
      this.b = paramScaleType;
      return;
    }
    localPhotoViewAttacher.a(paramScaleType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.widget.MultiTouchImageView
 * JD-Core Version:    0.7.0.1
 */