package com.tencent.mobileqq.troop.widget;

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
  private int jdField_a_of_type_Int = 0;
  private WheelPickerLayout.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$PickerViewAdapter;
  private WheelPickerLayout.ViewStyle jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$ViewStyle;
  private WheelPickerLayout.WheelPickListener jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$WheelPickListener;
  private AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new WheelPickerLayout.1(this);
  private VerticalGallery.OnSelectViewDataUpdateListener jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener = new WheelPickerLayout.2(this);
  private WheelView[] jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
  private WheelPickerLayout.InnerAdapter[] jdField_a_of_type_ArrayOfComTencentMobileqqTroopWidgetWheelPickerLayout$InnerAdapter;
  
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
        paramView = (WheelTextView)paramView;
        paramView.setTextSize(1, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$ViewStyle.b);
        paramView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$ViewStyle.c);
        return;
      }
      paramView = (WheelTextView)paramView;
      paramView.setTextSize(1, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$ViewStyle.e);
      paramView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$ViewStyle.f);
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof WheelTextView))
    {
      paramView = (WheelTextView)paramView;
      paramView.setContentDescription(new StringBuilder(paramView.getText()));
    }
  }
  
  private void a(WheelView paramWheelView, int paramInt)
  {
    paramWheelView.setTag(Integer.valueOf(paramInt));
    WheelPickerLayout.InnerAdapter localInnerAdapter = new WheelPickerLayout.InnerAdapter(this, paramInt, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$ViewStyle.jdField_a_of_type_Int);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt] = paramWheelView;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopWidgetWheelPickerLayout$InnerAdapter[paramInt] = localInnerAdapter;
    paramWheelView.setAdapter(localInnerAdapter);
    paramWheelView.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
    paramWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener);
    paramWheelView.setOnEndMovementListener(new WheelPickerLayout.EndMovementListener(this, paramInt));
  }
  
  public int a(int paramInt)
  {
    if (paramInt >= 0)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
      if (paramInt < localObject.length) {
        return localObject[paramInt].getSelectedItemPosition();
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Error column index ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopWidgetWheelPickerLayout$InnerAdapter;
      if (paramInt < localObject.length)
      {
        localObject[paramInt].notifyDataSetChanged();
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Error column index ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void a(WheelPickerLayout.PickerViewAdapter paramPickerViewAdapter, WheelPickerLayout.ViewStyle paramViewStyle)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$ViewStyle = paramViewStyle;
    if (paramViewStyle != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$PickerViewAdapter = paramPickerViewAdapter;
      this.jdField_a_of_type_Int = getChildCount();
      int i = this.jdField_a_of_type_Int;
      if (i > 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[i];
        this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopWidgetWheelPickerLayout$InnerAdapter = new WheelPickerLayout.InnerAdapter[i];
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          a((WheelView)getChildAt(i), i);
          i += 1;
        }
        return;
      }
      paramPickerViewAdapter = new StringBuilder();
      paramPickerViewAdapter.append("Unsupportted column count ");
      paramPickerViewAdapter.append(this.jdField_a_of_type_Int);
      throw new RuntimeException(paramPickerViewAdapter.toString());
    }
    paramPickerViewAdapter = new RuntimeException("ViewStyle can not be null!");
    for (;;)
    {
      throw paramPickerViewAdapter;
    }
  }
  
  public void setPickListener(WheelPickerLayout.WheelPickListener paramWheelPickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$WheelPickListener = paramWheelPickListener;
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
      if (paramInt1 < localObject.length)
      {
        localObject[paramInt1].setSelection(paramInt2, true);
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Error column index ");
    ((StringBuilder)localObject).append(paramInt1);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.WheelPickerLayout
 * JD-Core Version:    0.7.0.1
 */