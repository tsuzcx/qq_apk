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
  public static final int[] a;
  public int a;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 0, -16777216, -51904, -41579, -2992688, -15808515, -16268201, -12464 };
  }
  
  public ColorNickColorPanelAdapter$PureColorAdapter()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return jdField_a_of_type_ArrayOfInt.length;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(jdField_a_of_type_ArrayOfInt[paramInt]);
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
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561881, paramViewGroup, false);
    }
    paramView = (ColorSelectView)localView.findViewById(2131364837);
    ImageView localImageView = (ImageView)localView.findViewById(2131364835);
    if (paramInt == 0)
    {
      paramView.setVisibility(8);
      localImageView.setVisibility(0);
      int i;
      if (this.jdField_a_of_type_Int == paramInt) {
        i = 2130847305;
      } else {
        i = 2130847304;
      }
      localImageView.setImageResource(i);
    }
    else
    {
      paramView.setVisibility(0);
      localImageView.setVisibility(8);
      paramView.setColor(jdField_a_of_type_ArrayOfInt[paramInt]);
      if (this.jdField_a_of_type_Int == paramInt) {
        bool = true;
      }
      paramView.setSelect(bool);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickColorPanelAdapter.PureColorAdapter
 * JD-Core Version:    0.7.0.1
 */