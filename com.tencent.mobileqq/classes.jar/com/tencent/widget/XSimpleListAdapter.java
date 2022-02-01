package com.tencent.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class XSimpleListAdapter
  extends BaseAdapter
  implements XListAdapter
{
  private View mContentView;
  private int mCount;
  
  public XSimpleListAdapter(View paramView)
  {
    this.mContentView = paramView;
    if (paramView == null)
    {
      this.mCount = 0;
      return;
    }
    this.mCount = 1;
  }
  
  public int getCount()
  {
    return this.mCount;
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
    View localView = this.mContentView;
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.XSimpleListAdapter
 * JD-Core Version:    0.7.0.1
 */