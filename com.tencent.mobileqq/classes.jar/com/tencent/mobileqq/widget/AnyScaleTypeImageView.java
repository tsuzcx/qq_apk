package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import bcjg;

public class AnyScaleTypeImageView
  extends URLTextImageView
{
  private bcjg jdField_a_of_type_Bcjg;
  private boolean jdField_a_of_type_Boolean;
  
  public AnyScaleTypeImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnyScaleTypeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AnyScaleTypeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setDisplayRuleDef(bcjg parambcjg)
  {
    this.jdField_a_of_type_Bcjg = parambcjg;
    if (parambcjg != null) {
      setScaleType(ImageView.ScaleType.MATRIX);
    }
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Boolean = true;
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if (this.jdField_a_of_type_Bcjg != null)
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingTop();
      int m = getPaddingBottom();
      setImageMatrix(this.jdField_a_of_type_Bcjg.a(localDrawable, paramInt3 - paramInt1 - i - j, paramInt4 - paramInt2 - k - m));
    }
    return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramDrawable != null) && (this.jdField_a_of_type_Bcjg != null))
    {
      int i = getWidth();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = getHeight();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      setImageMatrix(this.jdField_a_of_type_Bcjg.a(paramDrawable, i - j - k, m - n - i1));
    }
    super.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnyScaleTypeImageView
 * JD-Core Version:    0.7.0.1
 */