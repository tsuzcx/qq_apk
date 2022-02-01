package com.tencent.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PagerBaseAdapterWrapper
  extends BaseAdapter
{
  private int a = 1;
  private BaseAdapter b;
  private int c;
  
  public PagerBaseAdapterWrapper(BaseAdapter paramBaseAdapter, int paramInt)
  {
    this.b = paramBaseAdapter;
    if (paramInt <= 0) {
      paramInt = 1;
    }
    this.a = paramInt;
    paramBaseAdapter = this.b;
    if (paramBaseAdapter != null) {
      paramBaseAdapter.registerDataSetObserver(new PagerBaseAdapterWrapper.1(this));
    }
  }
  
  public BaseAdapter a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    int i = c();
    if (paramInt < 0)
    {
      this.c = 0;
      return;
    }
    if (paramInt >= i)
    {
      this.c = (i - 1);
      return;
    }
    this.c = paramInt;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public int c()
  {
    int i = this.b.getCount();
    int k = this.a;
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
    int k = this.b.getCount();
    int m = this.c;
    int j = this.a;
    int i = j;
    if ((m + 1) * j > k) {
      i = k % j;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.getItem(this.c * this.a + paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.b.getItemId(this.c * this.a + paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = this.b.getView(this.c * this.a + paramInt, paramView, paramViewGroup);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.PagerBaseAdapterWrapper
 * JD-Core Version:    0.7.0.1
 */