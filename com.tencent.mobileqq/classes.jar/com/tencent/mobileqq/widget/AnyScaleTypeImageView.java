package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;

public class AnyScaleTypeImageView
  extends URLTextImageView
{
  private boolean a = false;
  private AnyScaleTypeImageView.DisplayRuleDef b;
  
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
  
  public void setDisplayRuleDef(AnyScaleTypeImageView.DisplayRuleDef paramDisplayRuleDef)
  {
    this.b = paramDisplayRuleDef;
    if (paramDisplayRuleDef != null) {
      setScaleType(ImageView.ScaleType.MATRIX);
    }
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = true;
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    if (this.b != null)
    {
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingTop();
      int m = getPaddingBottom();
      setImageMatrix(this.b.a(localDrawable, paramInt3 - paramInt1 - i - j, paramInt4 - paramInt2 - k - m));
    }
    return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((this.a) && (paramDrawable != null) && (this.b != null))
    {
      int i = getWidth();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = getHeight();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      setImageMatrix(this.b.a(paramDrawable, i - j - k, m - n - i1));
    }
    super.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnyScaleTypeImageView
 * JD-Core Version:    0.7.0.1
 */