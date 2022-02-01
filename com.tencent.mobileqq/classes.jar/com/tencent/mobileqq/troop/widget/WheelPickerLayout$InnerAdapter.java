package com.tencent.mobileqq.troop.widget;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.VerticalGallery.LayoutParams;

class WheelPickerLayout$InnerAdapter
  extends BaseAdapter
{
  private final int jdField_a_of_type_Int;
  private final int b;
  
  public WheelPickerLayout$InnerAdapter(WheelPickerLayout paramWheelPickerLayout, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = ((int)TypedValue.applyDimension(1, paramInt2, paramWheelPickerLayout.getResources().getDisplayMetrics()));
  }
  
  public int getCount()
  {
    return WheelPickerLayout.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout).a(this.b);
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new WheelTextView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.getContext());
      ((View)localObject).setLayoutParams(new VerticalGallery.LayoutParams(-1, this.jdField_a_of_type_Int));
      ((View)localObject).setFocusable(true);
      ((View)localObject).setFocusableInTouchMode(true);
    }
    paramView = WheelPickerLayout.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout).a(this.b, paramInt);
    WheelTextView localWheelTextView = (WheelTextView)localObject;
    localWheelTextView.setTextSize(1, WheelPickerLayout.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout).b);
    localWheelTextView.setTextColor(WheelPickerLayout.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout).c);
    localWheelTextView.setGravity(WheelPickerLayout.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout).d);
    localWheelTextView.setText(paramView);
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.WheelPickerLayout.InnerAdapter
 * JD-Core Version:    0.7.0.1
 */