package com.tencent.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class XMultiListAdapter
  extends BaseAdapter
  implements XListAdapter
{
  private List a;
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return (View)this.a.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.widget.XMultiListAdapter
 * JD-Core Version:    0.7.0.1
 */