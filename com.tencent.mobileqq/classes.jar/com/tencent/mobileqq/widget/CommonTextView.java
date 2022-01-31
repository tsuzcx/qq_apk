package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import bckr;
import bcnq;
import bcnr;

public class CommonTextView
  extends TextView
  implements bcnr
{
  private bckr jdField_a_of_type_Bckr;
  private bcnq jdField_a_of_type_Bcnq;
  
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
    if (this.jdField_a_of_type_Bcnq != null)
    {
      this.jdField_a_of_type_Bcnq.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bcnq != null)
    {
      this.jdField_a_of_type_Bcnq.b(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_Bckr != null) {
      this.jdField_a_of_type_Bckr.a(paramView, paramInt);
    }
  }
  
  public void setMosaicEffect(bcnq parambcnq)
  {
    bcnq localbcnq = this.jdField_a_of_type_Bcnq;
    if (localbcnq != null) {
      localbcnq.a(null);
    }
    this.jdField_a_of_type_Bcnq = parambcnq;
    if (parambcnq != null) {
      parambcnq.a(this);
    }
    invalidate();
  }
  
  public void setOnVisibilityChangedListener(bckr parambckr)
  {
    this.jdField_a_of_type_Bckr = parambckr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CommonTextView
 * JD-Core Version:    0.7.0.1
 */