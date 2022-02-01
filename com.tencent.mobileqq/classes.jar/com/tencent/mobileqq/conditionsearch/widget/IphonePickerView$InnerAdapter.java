package com.tencent.mobileqq.conditionsearch.widget;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.VerticalGallery.LayoutParams;

class IphonePickerView$InnerAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 25;
  private int b;
  
  public IphonePickerView$InnerAdapter(IphonePickerView paramIphonePickerView, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = ((int)TypedValue.applyDimension(1, paramInt2, paramIphonePickerView.getResources().getDisplayMetrics()));
  }
  
  public int getCount()
  {
    return IphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView).getRowCount(this.b);
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
      localObject = new WheelTextView(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.getContext());
      ((View)localObject).setLayoutParams(new VerticalGallery.LayoutParams(-1, this.jdField_a_of_type_Int));
      ((View)localObject).setFocusable(true);
      ((View)localObject).setFocusableInTouchMode(true);
    }
    paramView = IphonePickerView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView).getText(this.b, paramInt);
    WheelTextView localWheelTextView = (WheelTextView)localObject;
    localWheelTextView.setTextSize(20.0F);
    localWheelTextView.setTextColor(IphonePickerView.jdField_a_of_type_Int);
    localWheelTextView.setGravity(17);
    localWheelTextView.setText(paramView);
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.InnerAdapter
 * JD-Core Version:    0.7.0.1
 */