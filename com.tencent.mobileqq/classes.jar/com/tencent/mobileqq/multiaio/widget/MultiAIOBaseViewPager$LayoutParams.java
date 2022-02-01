package com.tencent.mobileqq.multiaio.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class MultiAIOBaseViewPager$LayoutParams
  extends ViewGroup.LayoutParams
{
  float a;
  public int a;
  public boolean a;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  int c;
  
  public MultiAIOBaseViewPager$LayoutParams()
  {
    super(-1, -1);
    this.jdField_a_of_type_Float = 0.0F;
  }
  
  public MultiAIOBaseViewPager$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = 0.0F;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, MultiAIOBaseViewPager.a);
    this.jdField_a_of_type_Int = paramContext.getInteger(0, 48);
    paramContext.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager.LayoutParams
 * JD-Core Version:    0.7.0.1
 */