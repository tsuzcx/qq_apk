package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import bgql;
import bgqm;
import bgqn;
import bgqo;
import bgqp;
import bgqq;
import bgqr;
import blgg;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

public class WheelPickerLayout
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private bgqp jdField_a_of_type_Bgqp;
  private bgqq jdField_a_of_type_Bgqq;
  private bgqr jdField_a_of_type_Bgqr;
  private blgg jdField_a_of_type_Blgg = new bgqm(this);
  private AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new bgql(this);
  private bgqo[] jdField_a_of_type_ArrayOfBgqo;
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
        ((WheelTextView)paramView).setTextSize(1, this.jdField_a_of_type_Bgqq.b);
        ((WheelTextView)paramView).setTextColor(this.jdField_a_of_type_Bgqq.c);
      }
    }
    else {
      return;
    }
    ((WheelTextView)paramView).setTextSize(1, this.jdField_a_of_type_Bgqq.e);
    ((WheelTextView)paramView).setTextColor(this.jdField_a_of_type_Bgqq.f);
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
    bgqo localbgqo = new bgqo(this, paramInt, this.jdField_a_of_type_Bgqq.jdField_a_of_type_Int);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt] = paramWheelView;
    this.jdField_a_of_type_ArrayOfBgqo[paramInt] = localbgqo;
    paramWheelView.setAdapter(localbgqo);
    paramWheelView.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
    paramWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_Blgg);
    paramWheelView.setOnEndMovementListener(new bgqn(this, paramInt));
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
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfBgqo.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    this.jdField_a_of_type_ArrayOfBgqo[paramInt].notifyDataSetChanged();
  }
  
  public void a(bgqp parambgqp, bgqq parambgqq)
  {
    this.jdField_a_of_type_Bgqq = parambgqq;
    if (parambgqq == null) {
      throw new RuntimeException("ViewStyle can not be null!");
    }
    this.jdField_a_of_type_Bgqp = parambgqp;
    this.jdField_a_of_type_Int = getChildCount();
    if (this.jdField_a_of_type_Int <= 0) {
      throw new RuntimeException("Unsupportted column count " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[this.jdField_a_of_type_Int];
    this.jdField_a_of_type_ArrayOfBgqo = new bgqo[this.jdField_a_of_type_Int];
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      a((WheelView)getChildAt(i), i);
      i += 1;
    }
  }
  
  public void setPickListener(bgqr parambgqr)
  {
    this.jdField_a_of_type_Bgqr = parambgqr;
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