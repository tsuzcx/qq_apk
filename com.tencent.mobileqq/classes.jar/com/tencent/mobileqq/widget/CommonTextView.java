package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import bhcf;
import bhfj;
import bhfk;

public class CommonTextView
  extends TextView
  implements bhfk
{
  private bhcf jdField_a_of_type_Bhcf;
  private bhfj jdField_a_of_type_Bhfj;
  
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
    if (this.jdField_a_of_type_Bhfj != null)
    {
      this.jdField_a_of_type_Bhfj.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bhfj != null)
    {
      this.jdField_a_of_type_Bhfj.b(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_Bhcf != null) {
      this.jdField_a_of_type_Bhcf.a(paramView, paramInt);
    }
  }
  
  public void setMosaicEffect(bhfj parambhfj)
  {
    bhfj localbhfj = this.jdField_a_of_type_Bhfj;
    if (localbhfj != null) {
      localbhfj.a(null);
    }
    this.jdField_a_of_type_Bhfj = parambhfj;
    if (parambhfj != null) {
      parambhfj.a(this);
    }
    invalidate();
  }
  
  public void setOnVisibilityChangedListener(bhcf parambhcf)
  {
    this.jdField_a_of_type_Bhcf = parambhcf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CommonTextView
 * JD-Core Version:    0.7.0.1
 */