package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import bimx;
import biqb;
import biqc;

public class CommonTextView
  extends TextView
  implements biqc
{
  private bimx jdField_a_of_type_Bimx;
  private biqb jdField_a_of_type_Biqb;
  
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
    if (this.jdField_a_of_type_Biqb != null)
    {
      this.jdField_a_of_type_Biqb.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Biqb != null)
    {
      this.jdField_a_of_type_Biqb.b(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_Bimx != null) {
      this.jdField_a_of_type_Bimx.a(paramView, paramInt);
    }
  }
  
  public void setMosaicEffect(biqb parambiqb)
  {
    biqb localbiqb = this.jdField_a_of_type_Biqb;
    if (localbiqb != null) {
      localbiqb.a(null);
    }
    this.jdField_a_of_type_Biqb = parambiqb;
    if (parambiqb != null) {
      parambiqb.a(this);
    }
    invalidate();
  }
  
  public void setOnVisibilityChangedListener(bimx parambimx)
  {
    this.jdField_a_of_type_Bimx = parambimx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CommonTextView
 * JD-Core Version:    0.7.0.1
 */