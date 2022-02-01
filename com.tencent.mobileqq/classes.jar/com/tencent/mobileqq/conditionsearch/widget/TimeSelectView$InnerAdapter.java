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
  private int b = 25;
  private int c;
  
  public TimeSelectView$InnerAdapter(TimeSelectView paramTimeSelectView, int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.b = ((int)TypedValue.applyDimension(1, paramInt2, paramTimeSelectView.getResources().getDisplayMetrics()));
  }
  
  public int getCount()
  {
    return TimeSelectView.b(this.a).a(this.c);
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
      localObject1 = new WheelTextView(this.a.getContext());
      ((View)localObject1).setLayoutParams(new VerticalGallery.LayoutParams(-1, this.b));
      ((View)localObject1).setFocusable(true);
      ((View)localObject1).setFocusableInTouchMode(true);
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("getView column:");
      paramView.append(this.c);
      paramView.append(", position: ");
      paramView.append(paramInt);
      QLog.d("TimeSelectView", 2, paramView.toString());
    }
    paramView = TimeSelectView.b(this.a).a(this.c, paramInt);
    Object localObject2 = ((View)localObject1).getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).height = DisplayUtil.a(this.a.getContext(), 35.0F);
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
    ((WheelTextView)localObject2).setTextColor(TimeSelectView.a);
    if (TimeSelectView.c(this.a)[0].getId() == paramViewGroup.getId()) {
      ((WheelTextView)localObject2).setGravity(8388613);
    } else {
      ((WheelTextView)localObject2).setGravity(8388611);
    }
    ((WheelTextView)localObject2).setText(paramView);
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.InnerAdapter
 * JD-Core Version:    0.7.0.1
 */