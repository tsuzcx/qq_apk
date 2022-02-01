package com.tencent.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PagerBaseAdapterWrapper
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 1;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  private int b;
  
  public PagerBaseAdapterWrapper(BaseAdapter paramBaseAdapter, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    if (paramInt <= 0) {
      paramInt = 1;
    }
    this.jdField_a_of_type_Int = paramInt;
    paramBaseAdapter = this.jdField_a_of_type_AndroidWidgetBaseAdapter;
    if (paramBaseAdapter != null) {
      paramBaseAdapter.registerDataSetObserver(new PagerBaseAdapterWrapper.1(this));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter;
  }
  
  public void a(int paramInt)
  {
    int i = b();
    if (paramInt < 0)
    {
      this.b = 0;
      return;
    }
    if (paramInt >= i)
    {
      this.b = (i - 1);
      return;
    }
    this.b = paramInt;
  }
  
  public int b()
  {
    int i = this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount();
    int k = this.jdField_a_of_type_Int;
    int j = i / k;
    if (i % k != 0) {
      i = 1;
    } else {
      i = 0;
    }
    return j + i;
  }
  
  public int getCount()
  {
    int k = this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount();
    int m = this.b;
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if ((m + 1) * j > k) {
      i = k % j;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.getItem(this.b * this.jdField_a_of_type_Int + paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.jdField_a_of_type_AndroidWidgetBaseAdapter.getItemId(this.b * this.jdField_a_of_type_Int + paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = this.jdField_a_of_type_AndroidWidgetBaseAdapter.getView(this.b * this.jdField_a_of_type_Int + paramInt, paramView, paramViewGroup);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.PagerBaseAdapterWrapper
 * JD-Core Version:    0.7.0.1
 */