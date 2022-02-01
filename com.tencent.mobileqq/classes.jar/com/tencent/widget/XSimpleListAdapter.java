package com.tencent.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class XSimpleListAdapter
  extends BaseAdapter
  implements XListAdapter
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  
  public XSimpleListAdapter(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (paramView == null)
    {
      this.jdField_a_of_type_Int = 0;
      return;
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.XSimpleListAdapter
 * JD-Core Version:    0.7.0.1
 */