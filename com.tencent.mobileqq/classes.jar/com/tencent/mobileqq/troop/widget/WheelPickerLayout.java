package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import baqt;
import baqu;
import baqv;
import baqw;
import baqx;
import baqy;
import baqz;
import bfpv;
import bfxc;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;

public class WheelPickerLayout
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private baqx jdField_a_of_type_Baqx;
  private baqy jdField_a_of_type_Baqy;
  private baqz jdField_a_of_type_Baqz;
  private bfpv jdField_a_of_type_Bfpv = new baqt(this);
  private bfxc jdField_a_of_type_Bfxc = new baqu(this);
  private baqw[] jdField_a_of_type_ArrayOfBaqw;
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
        ((WheelTextView)paramView).setTextSize(1, this.jdField_a_of_type_Baqy.b);
        ((WheelTextView)paramView).setTextColor(this.jdField_a_of_type_Baqy.c);
      }
    }
    else {
      return;
    }
    ((WheelTextView)paramView).setTextSize(1, this.jdField_a_of_type_Baqy.e);
    ((WheelTextView)paramView).setTextColor(this.jdField_a_of_type_Baqy.f);
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
    baqw localbaqw = new baqw(this, paramInt, this.jdField_a_of_type_Baqy.jdField_a_of_type_Int);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt] = paramWheelView;
    this.jdField_a_of_type_ArrayOfBaqw[paramInt] = localbaqw;
    paramWheelView.setAdapter(localbaqw);
    paramWheelView.setOnItemSelectedListener(this.jdField_a_of_type_Bfpv);
    paramWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_Bfxc);
    paramWheelView.setOnEndMovementListener(new baqv(this, paramInt));
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
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfBaqw.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    this.jdField_a_of_type_ArrayOfBaqw[paramInt].notifyDataSetChanged();
  }
  
  public void a(baqx parambaqx, baqy parambaqy)
  {
    this.jdField_a_of_type_Baqy = parambaqy;
    if (parambaqy == null) {
      throw new RuntimeException("ViewStyle can not be null!");
    }
    this.jdField_a_of_type_Baqx = parambaqx;
    this.jdField_a_of_type_Int = getChildCount();
    if (this.jdField_a_of_type_Int <= 0) {
      throw new RuntimeException("Unsupportted column count " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[this.jdField_a_of_type_Int];
    this.jdField_a_of_type_ArrayOfBaqw = new baqw[this.jdField_a_of_type_Int];
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      a((WheelView)getChildAt(i), i);
      i += 1;
    }
  }
  
  public void setPickListener(baqz parambaqz)
  {
    this.jdField_a_of_type_Baqz = parambaqz;
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt1);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt1].setSelection(paramInt2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.WheelPickerLayout
 * JD-Core Version:    0.7.0.1
 */