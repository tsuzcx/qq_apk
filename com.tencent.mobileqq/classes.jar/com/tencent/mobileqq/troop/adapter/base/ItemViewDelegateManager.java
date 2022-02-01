package com.tencent.mobileqq.troop.adapter.base;

import android.support.v4.util.SparseArrayCompat;

public class ItemViewDelegateManager<T>
{
  SparseArrayCompat<ItemViewDelegate<T>> a = new SparseArrayCompat();
  
  public int a()
  {
    return this.a.size();
  }
  
  public int a(T paramT, int paramInt)
  {
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((ItemViewDelegate)this.a.valueAt(i)).a(paramT, paramInt)) {
        return this.a.keyAt(i);
      }
      i -= 1;
    }
    paramT = new StringBuilder();
    paramT.append("No ItemViewDelegate added that matches position=");
    paramT.append(paramInt);
    paramT.append(" in data source");
    paramT = new IllegalArgumentException(paramT.toString());
    for (;;)
    {
      throw paramT;
    }
  }
  
  public ItemViewDelegate a(int paramInt)
  {
    return (ItemViewDelegate)this.a.get(paramInt);
  }
  
  public ItemViewDelegateManager<T> a(ItemViewDelegate<T> paramItemViewDelegate)
  {
    int i = this.a.size();
    if (paramItemViewDelegate != null) {
      this.a.put(i, paramItemViewDelegate);
    }
    return this;
  }
  
  public void a(ViewHolder paramViewHolder, T paramT, int paramInt)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ItemViewDelegate localItemViewDelegate = (ItemViewDelegate)this.a.valueAt(i);
      if (localItemViewDelegate.a(paramT, paramInt))
      {
        localItemViewDelegate.a(paramViewHolder, paramT, paramInt);
        return;
      }
      i += 1;
    }
    paramViewHolder = new StringBuilder();
    paramViewHolder.append("No ItemViewDelegateManager added that matches position=");
    paramViewHolder.append(paramInt);
    paramViewHolder.append(" in data source");
    paramViewHolder = new IllegalArgumentException(paramViewHolder.toString());
    for (;;)
    {
      throw paramViewHolder;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.adapter.base.ItemViewDelegateManager
 * JD-Core Version:    0.7.0.1
 */