package com.tencent.mobileqq.conditionsearch.widget;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.VerticalGallery.LayoutParams;

class TimeSelectView$InnerAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 25;
  private int b;
  
  public TimeSelectView$InnerAdapter(TimeSelectView paramTimeSelectView, int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.jdField_a_of_type_Int = ((int)TypedValue.applyDimension(1, paramInt2, paramTimeSelectView.getResources().getDisplayMetrics()));
  }
  
  public int getCount()
  {
    return TimeSelectView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView).a(this.b);
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
    Object localObject1 = paramView;
    if (paramView == null)
    {
      localObject1 = new WheelTextView(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.getContext());
      ((View)localObject1).setLayoutParams(new VerticalGallery.LayoutParams(-1, this.jdField_a_of_type_Int));
      ((View)localObject1).setFocusable(true);
      ((View)localObject1).setFocusableInTouchMode(true);
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("getView column:");
      paramView.append(this.b);
      paramView.append(", position: ");
      paramView.append(paramInt);
      QLog.d("TimeSelectView", 2, paramView.toString());
    }
    paramView = TimeSelectView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView).a(this.b, paramInt);
    Object localObject2 = ((View)localObject1).getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).height = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.getContext(), 35.0F);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("view height 33dp -> ");
      localStringBuilder.append(((ViewGroup.LayoutParams)localObject2).height);
      localStringBuilder.append("px");
      QLog.d("TimeSelectView", 2, localStringBuilder.toString());
    }
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = (WheelTextView)localObject1;
    ((WheelTextView)localObject2).setTextSize(20.0F);
    ((WheelTextView)localObject2).setTextColor(TimeSelectView.jdField_a_of_type_Int);
    if (TimeSelectView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView)[0].getId() == paramViewGroup.getId()) {
      ((WheelTextView)localObject2).setGravity(8388613);
    } else {
      ((WheelTextView)localObject2).setGravity(8388611);
    }
    ((WheelTextView)localObject2).setText(paramView);
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.InnerAdapter
 * JD-Core Version:    0.7.0.1
 */