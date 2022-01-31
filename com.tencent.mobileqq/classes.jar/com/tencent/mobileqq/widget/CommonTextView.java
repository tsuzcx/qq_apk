package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import bbhc;
import bbkd;
import bbke;

public class CommonTextView
  extends TextView
  implements bbke
{
  private bbhc jdField_a_of_type_Bbhc;
  private bbkd jdField_a_of_type_Bbkd;
  
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
    if (this.jdField_a_of_type_Bbkd != null)
    {
      this.jdField_a_of_type_Bbkd.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bbkd != null)
    {
      this.jdField_a_of_type_Bbkd.b(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_Bbhc != null) {
      this.jdField_a_of_type_Bbhc.a(paramView, paramInt);
    }
  }
  
  public void setMosaicEffect(bbkd parambbkd)
  {
    bbkd localbbkd = this.jdField_a_of_type_Bbkd;
    if (localbbkd != null) {
      localbbkd.a(null);
    }
    this.jdField_a_of_type_Bbkd = parambbkd;
    if (parambbkd != null) {
      parambbkd.a(this);
    }
    invalidate();
  }
  
  public void setOnVisibilityChangedListener(bbhc parambbhc)
  {
    this.jdField_a_of_type_Bbhc = parambbhc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CommonTextView
 * JD-Core Version:    0.7.0.1
 */