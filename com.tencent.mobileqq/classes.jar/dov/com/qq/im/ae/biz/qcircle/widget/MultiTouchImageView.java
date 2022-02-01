package dov.com.qq.im.ae.biz.qcircle.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLImageView;

public class MultiTouchImageView
  extends URLImageView
{
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  private PhotoViewAttacher jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher;
  
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
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher = new PhotoViewAttacher(this);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType != null)
    {
      setScaleType(this.jdField_a_of_type_AndroidWidgetImageView$ScaleType);
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = null;
    }
  }
  
  public Matrix getImageMatrix()
  {
    return this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.a();
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.a();
  }
  
  public void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.a(paramBoolean);
  }
  
  public boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    if (bool) {
      this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.a();
    }
    return bool;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher != null) {
      this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.a();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    if (this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher != null) {
      this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.a();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    if (this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher != null) {
      this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.a();
    }
  }
  
  public void setMaximumScale(float paramFloat)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.e(paramFloat);
  }
  
  public void setMediumScale(float paramFloat)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.d(paramFloat);
  }
  
  public void setMinimumScale(float paramFloat)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.c(paramFloat);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.a(paramOnClickListener);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.a(paramOnDoubleTapListener);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.a(paramOnLongClickListener);
  }
  
  public void setRotationBy(float paramFloat)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.b(paramFloat);
  }
  
  public void setRotationTo(float paramFloat)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.a(paramFloat);
  }
  
  public void setScale(float paramFloat)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.f(paramFloat);
  }
  
  public void setScale(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.a(paramFloat1, paramFloat2, paramFloat3, paramBoolean);
  }
  
  public void setScale(float paramFloat, boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.a(paramFloat, paramBoolean);
  }
  
  public void setScaleLevels(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.a(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = paramScaleType;
      return;
    }
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.a(paramScaleType);
  }
  
  public void setZoomTransitionDuration(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.a(paramInt);
  }
  
  public void setZoomable(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcircleWidgetPhotoViewAttacher.b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.widget.MultiTouchImageView
 * JD-Core Version:    0.7.0.1
 */