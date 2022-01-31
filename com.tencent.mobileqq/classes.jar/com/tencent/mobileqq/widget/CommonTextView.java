package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import bckc;
import bcnb;
import bcnc;

public class CommonTextView
  extends TextView
  implements bcnc
{
  private bckc jdField_a_of_type_Bckc;
  private bcnb jdField_a_of_type_Bcnb;
  
  public CommonTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CommonTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void b(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void c(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bcnb != null)
    {
      this.jdField_a_of_type_Bcnb.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bcnb != null)
    {
      this.jdField_a_of_type_Bcnb.b(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_Bckc != null) {
      this.jdField_a_of_type_Bckc.a(paramView, paramInt);
    }
  }
  
  public void setMosaicEffect(bcnb parambcnb)
  {
    bcnb localbcnb = this.jdField_a_of_type_Bcnb;
    if (localbcnb != null) {
      localbcnb.a(null);
    }
    this.jdField_a_of_type_Bcnb = parambcnb;
    if (parambcnb != null) {
      parambcnb.a(this);
    }
    invalidate();
  }
  
  public void setOnVisibilityChangedListener(bckc parambckc)
  {
    this.jdField_a_of_type_Bckc = parambckc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CommonTextView
 * JD-Core Version:    0.7.0.1
 */