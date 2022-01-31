package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import bejs;
import bems;
import bemt;

public class CommonTextView
  extends TextView
  implements bemt
{
  private bejs jdField_a_of_type_Bejs;
  private bems jdField_a_of_type_Bems;
  
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
  
  public void a(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void b(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bems != null)
    {
      this.jdField_a_of_type_Bems.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bems != null)
    {
      this.jdField_a_of_type_Bems.b(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_Bejs != null) {
      this.jdField_a_of_type_Bejs.a(paramView, paramInt);
    }
  }
  
  public void setMosaicEffect(bems parambems)
  {
    bems localbems = this.jdField_a_of_type_Bems;
    if (localbems != null) {
      localbems.a(null);
    }
    this.jdField_a_of_type_Bems = parambems;
    if (parambems != null) {
      parambems.a(this);
    }
    invalidate();
  }
  
  public void setOnVisibilityChangedListener(bejs parambejs)
  {
    this.jdField_a_of_type_Bejs = parambejs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CommonTextView
 * JD-Core Version:    0.7.0.1
 */