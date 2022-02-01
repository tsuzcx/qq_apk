package com.tencent.mobileqq.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class BaseDraggableGridViewAdapter
{
  DraggableGridView b;
  
  public abstract View a(LayoutInflater paramLayoutInflater, int paramInt1, int paramInt2, ViewGroup paramViewGroup);
  
  public abstract View a(LayoutInflater paramLayoutInflater, int paramInt, ViewGroup paramViewGroup);
  
  public abstract Object a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(View paramView, int paramInt);
  
  public abstract void a(View paramView, int paramInt1, int paramInt2);
  
  public abstract int b(int paramInt);
  
  public abstract void b(int paramInt1, int paramInt2);
  
  public int c(int paramInt)
  {
    return 0;
  }
  
  public abstract Object c(int paramInt1, int paramInt2);
  
  public abstract int d();
  
  public void d(int paramInt1, int paramInt2)
  {
    this.b.a(paramInt1, paramInt2);
  }
  
  public int e()
  {
    return 1;
  }
  
  public void f()
  {
    ((DraggableGridView.GridListViewAdapter)this.b.getInnerAdapter()).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BaseDraggableGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */