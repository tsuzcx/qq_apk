package com.tencent.mobileqq.troop.widget;

import ajum;
import ajun;
import ajuo;
import ajup;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener;

public class WheelPickerLayout
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private WheelPickerLayout.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$PickerViewAdapter;
  private WheelPickerLayout.ViewStyle jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$ViewStyle;
  private WheelPickerLayout.WheelPickListener jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$WheelPickListener;
  private AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new ajum(this);
  private VerticalGallery.OnSelectViewDataUpdateListener jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener = new ajun(this);
  private ajup[] jdField_a_of_type_ArrayOfAjup;
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
        ((WheelTextView)paramView).setTextSize(1, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$ViewStyle.b);
        ((WheelTextView)paramView).setTextColor(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$ViewStyle.c);
      }
    }
    else {
      return;
    }
    ((WheelTextView)paramView).setTextSize(1, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$ViewStyle.e);
    ((WheelTextView)paramView).setTextColor(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$ViewStyle.f);
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
    ajup localajup = new ajup(this, paramInt, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$ViewStyle.jdField_a_of_type_Int);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt] = paramWheelView;
    this.jdField_a_of_type_ArrayOfAjup[paramInt] = localajup;
    paramWheelView.setAdapter(localajup);
    paramWheelView.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
    paramWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener);
    paramWheelView.setOnEndMovementListener(new ajuo(this, paramInt));
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
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfAjup.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    this.jdField_a_of_type_ArrayOfAjup[paramInt].notifyDataSetChanged();
  }
  
  public void a(WheelPickerLayout.PickerViewAdapter paramPickerViewAdapter, WheelPickerLayout.ViewStyle paramViewStyle)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$ViewStyle = paramViewStyle;
    if (paramViewStyle == null) {
      throw new RuntimeException("ViewStyle can not be null!");
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$PickerViewAdapter = paramPickerViewAdapter;
    this.jdField_a_of_type_Int = getChildCount();
    if (this.jdField_a_of_type_Int <= 0) {
      throw new RuntimeException("Unsupportted column count " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[this.jdField_a_of_type_Int];
    this.jdField_a_of_type_ArrayOfAjup = new ajup[this.jdField_a_of_type_Int];
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      a((WheelView)getChildAt(i), i);
      i += 1;
    }
  }
  
  public void setPickListener(WheelPickerLayout.WheelPickListener paramWheelPickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$WheelPickListener = paramWheelPickListener;
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt1);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt1].setSelection(paramInt2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.WheelPickerLayout
 * JD-Core Version:    0.7.0.1
 */