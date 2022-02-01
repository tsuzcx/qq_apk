package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import bgyi;
import bgyj;
import bgyk;
import bgyl;
import bgym;
import bgyn;
import bgyo;
import bljo;
import blqt;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;

public class WheelPickerLayout
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private bgym jdField_a_of_type_Bgym;
  private bgyn jdField_a_of_type_Bgyn;
  private bgyo jdField_a_of_type_Bgyo;
  private bljo jdField_a_of_type_Bljo = new bgyi(this);
  private blqt jdField_a_of_type_Blqt = new bgyj(this);
  private bgyl[] jdField_a_of_type_ArrayOfBgyl;
  private WheelView[] jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
  
  public WheelPickerLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public WheelPickerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((paramView instanceof WheelTextView))
    {
      if (paramInt == 0)
      {
        ((WheelTextView)paramView).setTextSize(1, this.jdField_a_of_type_Bgyn.b);
        ((WheelTextView)paramView).setTextColor(this.jdField_a_of_type_Bgyn.c);
      }
    }
    else {
      return;
    }
    ((WheelTextView)paramView).setTextSize(1, this.jdField_a_of_type_Bgyn.e);
    ((WheelTextView)paramView).setTextColor(this.jdField_a_of_type_Bgyn.f);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof WheelTextView))
    {
      StringBuilder localStringBuilder = new StringBuilder(((WheelTextView)paramView).getText());
      ((WheelTextView)paramView).setContentDescription(localStringBuilder);
    }
  }
  
  private void a(WheelView paramWheelView, int paramInt)
  {
    paramWheelView.setTag(Integer.valueOf(paramInt));
    bgyl localbgyl = new bgyl(this, paramInt, this.jdField_a_of_type_Bgyn.jdField_a_of_type_Int);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt] = paramWheelView;
    this.jdField_a_of_type_ArrayOfBgyl[paramInt] = localbgyl;
    paramWheelView.setAdapter(localbgyl);
    paramWheelView.setOnItemSelectedListener(this.jdField_a_of_type_Bljo);
    paramWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_Blqt);
    paramWheelView.setOnEndMovementListener(new bgyk(this, paramInt));
  }
  
  public int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt].getSelectedItemPosition();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfBgyl.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    this.jdField_a_of_type_ArrayOfBgyl[paramInt].notifyDataSetChanged();
  }
  
  public void a(bgym parambgym, bgyn parambgyn)
  {
    this.jdField_a_of_type_Bgyn = parambgyn;
    if (parambgyn == null) {
      throw new RuntimeException("ViewStyle can not be null!");
    }
    this.jdField_a_of_type_Bgym = parambgym;
    this.jdField_a_of_type_Int = getChildCount();
    if (this.jdField_a_of_type_Int <= 0) {
      throw new RuntimeException("Unsupportted column count " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[this.jdField_a_of_type_Int];
    this.jdField_a_of_type_ArrayOfBgyl = new bgyl[this.jdField_a_of_type_Int];
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      a((WheelView)getChildAt(i), i);
      i += 1;
    }
  }
  
  public void setPickListener(bgyo parambgyo)
  {
    this.jdField_a_of_type_Bgyo = parambgyo;
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt1);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt1].setSelection(paramInt2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.WheelPickerLayout
 * JD-Core Version:    0.7.0.1
 */