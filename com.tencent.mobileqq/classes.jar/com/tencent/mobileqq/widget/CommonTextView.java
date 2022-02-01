package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import bhvf;
import bhyj;
import bhyk;

public class CommonTextView
  extends TextView
  implements bhyk
{
  private bhvf jdField_a_of_type_Bhvf;
  private bhyj jdField_a_of_type_Bhyj;
  
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
    if (this.jdField_a_of_type_Bhyj != null)
    {
      this.jdField_a_of_type_Bhyj.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bhyj != null)
    {
      this.jdField_a_of_type_Bhyj.b(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_Bhvf != null) {
      this.jdField_a_of_type_Bhvf.a(paramView, paramInt);
    }
  }
  
  public void setMosaicEffect(bhyj parambhyj)
  {
    bhyj localbhyj = this.jdField_a_of_type_Bhyj;
    if (localbhyj != null) {
      localbhyj.a(null);
    }
    this.jdField_a_of_type_Bhyj = parambhyj;
    if (parambhyj != null) {
      parambhyj.a(this);
    }
    invalidate();
  }
  
  public void setOnVisibilityChangedListener(bhvf parambhvf)
  {
    this.jdField_a_of_type_Bhvf = parambhvf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CommonTextView
 * JD-Core Version:    0.7.0.1
 */