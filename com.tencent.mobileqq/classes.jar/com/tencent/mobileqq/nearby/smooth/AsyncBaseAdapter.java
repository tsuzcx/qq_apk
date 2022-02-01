package com.tencent.mobileqq.nearby.smooth;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class AsyncBaseAdapter
  extends BaseAdapter
{
  final ItemManager a;
  final BaseAdapter b;
  
  AsyncBaseAdapter(ItemManager paramItemManager, BaseAdapter paramBaseAdapter)
  {
    this.a = paramItemManager;
    this.b = paramBaseAdapter;
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.b.areAllItemsEnabled();
  }
  
  public int getCount()
  {
    return this.b.getCount();
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.b.getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.b.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.b.getItemViewType(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.b.getView(paramInt, paramView, paramViewGroup);
    this.a.a(paramViewGroup, paramView, paramInt);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return this.b.getViewTypeCount();
  }
  
  public boolean hasStableIds()
  {
    return this.b.hasStableIds();
  }
  
  public boolean isEmpty()
  {
    return this.b.isEmpty();
  }
  
  public boolean isEnabled(int paramInt)
  {
    return this.b.isEnabled(paramInt);
  }
  
  public void notifyDataSetChanged()
  {
    this.b.notifyDataSetChanged();
  }
  
  public void notifyDataSetInvalidated()
  {
    this.b.notifyDataSetInvalidated();
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.b.registerDataSetObserver(paramDataSetObserver);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.b.unregisterDataSetObserver(paramDataSetObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.AsyncBaseAdapter
 * JD-Core Version:    0.7.0.1
 */