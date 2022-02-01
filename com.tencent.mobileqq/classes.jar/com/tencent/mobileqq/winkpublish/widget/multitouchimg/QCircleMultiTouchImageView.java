package com.tencent.mobileqq.winkpublish.widget.multitouchimg;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLImageView;

public class QCircleMultiTouchImageView
  extends URLImageView
{
  private PhotoViewAttacher a;
  private ImageView.ScaleType b;
  
  public QCircleMultiTouchImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleMultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleMultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  public PhotoViewAttacher getAttacher()
  {
    return this.a;
  }
  
  public RectF getDisplayRect()
  {
    return this.a.a();
  }
  
  public Matrix getImageMatrix()
  {
    return this.a.h();
  }
  
  public float getMaximumScale()
  {
    return this.a.d();
  }
  
  public float getMediumScale()
  {
    return this.a.c();
  }
  
  public float getMinimumScale()
  {
    return this.a.b();
  }
  
  public float getScale()
  {
    return this.a.e();
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.a.f();
  }
  
  public void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    if (bool) {
      this.a.g();
    }
    return bool;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    paramDrawable = this.a;
    if (paramDrawable != null) {
      paramDrawable.g();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    PhotoViewAttacher localPhotoViewAttacher = this.a;
    if (localPhotoViewAttacher != null) {
      localPhotoViewAttacher.g();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    paramUri = this.a;
    if (paramUri != null) {
      paramUri.g();
    }
  }
  
  public void setMaximumScale(float paramFloat)
  {
    this.a.e(paramFloat);
  }
  
  public void setMediumScale(float paramFloat)
  {
    this.a.d(paramFloat);
  }
  
  public void setMinimumScale(float paramFloat)
  {
    this.a.c(paramFloat);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a.a(paramOnClickListener);
  }
  
  public void setOnDoubleTabListener(OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.a.a(paramOnDoubleTapListener);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.a.a(paramOnDoubleTapListener);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.a.a(paramOnLongClickListener);
  }
  
  public void setOnMatrixChangeListener(OnMatrixChangedListener paramOnMatrixChangedListener)
  {
    this.a.a(paramOnMatrixChangedListener);
  }
  
  public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener paramOnOutsidePhotoTapListener)
  {
    this.a.a(paramOnOutsidePhotoTapListener);
  }
  
  public void setOnPhotoTapListener(OnPhotoTapListener paramOnPhotoTapListener)
  {
    this.a.a(paramOnPhotoTapListener);
  }
  
  public void setOnScaleBeginListener(OnScaleBeginListener paramOnScaleBeginListener)
  {
    this.a.a(paramOnScaleBeginListener);
  }
  
  public void setOnScaleChangeListener(OnScaleChangedListener paramOnScaleChangedListener)
  {
    this.a.a(paramOnScaleChangedListener);
  }
  
  public void setOnScaleEndListener(OnScaleEndListener paramOnScaleEndListener)
  {
    this.a.a(paramOnScaleEndListener);
  }
  
  public void setOnSingleFlingListener(OnSingleFlingListener paramOnSingleFlingListener)
  {
    this.a.a(paramOnSingleFlingListener);
  }
  
  public void setOnViewDragListener(OnViewDragListener paramOnViewDragListener)
  {
    this.a.a(paramOnViewDragListener);
  }
  
  public void setOnViewTapListener(OnViewTapListener paramOnViewTapListener)
  {
    this.a.a(paramOnViewTapListener);
  }
  
  public void setRotationBy(float paramFloat)
  {
    this.a.b(paramFloat);
  }
  
  public void setRotationTo(float paramFloat)
  {
    this.a.a(paramFloat);
  }
  
  public void setScale(float paramFloat)
  {
    this.a.f(paramFloat);
  }
  
  public void setScale(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    this.a.a(paramFloat1, paramFloat2, paramFloat3, paramBoolean);
  }
  
  public void setScale(float paramFloat, boolean paramBoolean)
  {
    this.a.a(paramFloat, paramBoolean);
  }
  
  public void setScaleLevels(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a.a(paramFloat1, paramFloat2, paramFloat3);
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
  
  public void setZoomTransitionDuration(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void setZoomable(boolean paramBoolean)
  {
    this.a.b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.widget.multitouchimg.QCircleMultiTouchImageView
 * JD-Core Version:    0.7.0.1
 */