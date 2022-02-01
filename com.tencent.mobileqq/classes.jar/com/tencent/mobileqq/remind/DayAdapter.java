package com.tencent.mobileqq.remind;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.VerticalGallery.LayoutParams;

public class DayAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 25;
  private Context jdField_a_of_type_AndroidContentContext;
  private int b;
  private int c;
  
  public DayAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.b = paramContext.getColor(2131167148);
    this.jdField_a_of_type_Int = ((int)TypedValue.applyDimension(1, paramInt, paramContext.getDisplayMetrics()));
    this.c = paramContext.getColor(2131167116);
  }
  
  public View a(int paramInt)
  {
    return getView(paramInt, null, null);
  }
  
  public int getCount()
  {
    return TimeHelper.jdField_a_of_type_Int;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = new WheelTextView(this.jdField_a_of_type_AndroidContentContext);
      ((View)localObject1).setLayoutParams(new VerticalGallery.LayoutParams(-1, this.jdField_a_of_type_Int));
      paramView = (WheelTextView)localObject1;
    }
    else
    {
      localObject2 = null;
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    Object localObject2 = paramView;
    if (paramView == null) {
      localObject2 = (WheelTextView)localObject1;
    }
    paramView = TimeHelper.a(paramInt);
    ((WheelTextView)localObject2).setTextSize(20.0F);
    ((WheelTextView)localObject2).setTextColor(this.b);
    ((WheelTextView)localObject2).setGravity(17);
    ((WheelTextView)localObject2).setText(paramView);
    ((WheelTextView)localObject2).setBackgroundColor(this.c);
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.remind.DayAdapter
 * JD-Core Version:    0.7.0.1
 */