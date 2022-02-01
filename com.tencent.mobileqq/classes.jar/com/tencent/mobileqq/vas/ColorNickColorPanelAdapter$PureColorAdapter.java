package com.tencent.mobileqq.vas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.ColorSelectView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ColorNickColorPanelAdapter$PureColorAdapter
  extends BaseAdapter
{
  public static final int[] a = { 0, -16777216, -51904, -41579, -2992688, -15808515, -16268201, -12464 };
  public int b = -1;
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return a.length;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(a[paramInt]);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = false;
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131628299, paramViewGroup, false);
    }
    paramView = (ColorSelectView)localView.findViewById(2131430962);
    ImageView localImageView = (ImageView)localView.findViewById(2131430960);
    if (paramInt == 0)
    {
      paramView.setVisibility(8);
      localImageView.setVisibility(0);
      int i;
      if (this.b == paramInt) {
        i = 2130848956;
      } else {
        i = 2130848955;
      }
      localImageView.setImageResource(i);
    }
    else
    {
      paramView.setVisibility(0);
      localImageView.setVisibility(8);
      paramView.setColor(a[paramInt]);
      if (this.b == paramInt) {
        bool = true;
      }
      paramView.setSelect(bool);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickColorPanelAdapter.PureColorAdapter
 * JD-Core Version:    0.7.0.1
 */