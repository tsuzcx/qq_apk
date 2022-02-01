package com.tencent.mobileqq.kandian.biz.comment.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RIJEnhancedImageSpan
  extends ImageSpan
{
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private RIJEnhancedImageSpan.IAlignConfig jdField_a_of_type_ComTencentMobileqqKandianBizCommentUtilRIJEnhancedImageSpan$IAlignConfig;
  
  public RIJEnhancedImageSpan(int paramInt)
  {
    this(null, paramInt);
  }
  
  public RIJEnhancedImageSpan(@NonNull Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
    a();
  }
  
  private void a()
  {
    int i = this.mVerticalAlignment;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUtilRIJEnhancedImageSpan$IAlignConfig = new RIJEnhancedImageSpan.AlignBottomConfig(null);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUtilRIJEnhancedImageSpan$IAlignConfig = new RIJEnhancedImageSpan.AlignTopConfig(null);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUtilRIJEnhancedImageSpan$IAlignConfig = new RIJEnhancedImageSpan.AlignCenterConfig(null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUtilRIJEnhancedImageSpan$IAlignConfig = new RIJEnhancedImageSpan.AlignBaselineConfig(null);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUtilRIJEnhancedImageSpan$IAlignConfig.a(paramInt1, paramInt2);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUtilRIJEnhancedImageSpan$IAlignConfig.b(paramInt1, paramInt2);
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    Drawable localDrawable = getDrawable();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUtilRIJEnhancedImageSpan$IAlignConfig.a(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint, localDrawable);
  }
  
  public Drawable getDrawable()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = super.getDrawable();
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    Drawable localDrawable = getDrawable();
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUtilRIJEnhancedImageSpan$IAlignConfig.a(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt, localDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.RIJEnhancedImageSpan
 * JD-Core Version:    0.7.0.1
 */