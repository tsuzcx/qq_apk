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
  private final int b;
  private final int c;
  
  public WheelPickerLayout$InnerAdapter(WheelPickerLayout paramWheelPickerLayout, int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.b = ((int)TypedValue.applyDimension(1, paramInt2, paramWheelPickerLayout.getResources().getDisplayMetrics()));
  }
  
  public int getCount()
  {
    return WheelPickerLayout.a(this.a).a(this.c);
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
      localObject = new WheelTextView(this.a.getContext());
      ((View)localObject).setLayoutParams(new VerticalGallery.LayoutParams(-1, this.b));
      ((View)localObject).setFocusable(true);
      ((View)localObject).setFocusableInTouchMode(true);
    }
    paramView = WheelPickerLayout.a(this.a).a(this.c, paramInt);
    WheelTextView localWheelTextView = (WheelTextView)localObject;
    localWheelTextView.setTextSize(1, WheelPickerLayout.b(this.a).b);
    localWheelTextView.setTextColor(WheelPickerLayout.b(this.a).c);
    localWheelTextView.setGravity(WheelPickerLayout.b(this.a).d);
    localWheelTextView.setText(paramView);
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.WheelPickerLayout.InnerAdapter
 * JD-Core Version:    0.7.0.1
 */