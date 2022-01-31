package com.tencent.mobileqq.gallery.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;

public class GalleryBaseAdapter$URLImageView2
  extends URLImageView
{
  public URLDrawable a;
  public boolean a;
  
  public GalleryBaseAdapter$URLImageView2(Context paramContext)
  {
    super(paramContext);
  }
  
  public GalleryBaseAdapter$URLImageView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == this.jdField_a_of_type_ComTencentImageURLDrawable)
    {
      setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == this.jdField_a_of_type_ComTencentImageURLDrawable)
    {
      Drawable localDrawable = getDrawable();
      if ((localDrawable != null) && (localDrawable.getIntrinsicWidth() == paramURLDrawable.getIntrinsicWidth()) && (localDrawable.getIntrinsicHeight() == paramURLDrawable.getIntrinsicHeight()))
      {
        this.jdField_a_of_type_Boolean = true;
        setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  public void requestLayout()
  {
    if (!this.jdField_a_of_type_Boolean) {
      super.requestLayout();
    }
  }
  
  public void setDecodingDrawble(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
    }
    paramURLDrawable.setURLDrawableListener(this);
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.view.GalleryBaseAdapter.URLImageView2
 * JD-Core Version:    0.7.0.1
 */