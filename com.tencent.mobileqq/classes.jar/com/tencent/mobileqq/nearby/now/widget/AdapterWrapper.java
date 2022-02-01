package com.tencent.mobileqq.nearby.now.widget;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AdapterWrapper
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private RecyclerView.Adapter a;
  private SparseArrayCompat<View> b = new SparseArrayCompat();
  private SparseArrayCompat<View> c = new SparseArrayCompat();
  
  public AdapterWrapper(RecyclerView.Adapter paramAdapter)
  {
    this.a = paramAdapter;
  }
  
  private boolean a(int paramInt)
  {
    return paramInt < b();
  }
  
  private boolean b(int paramInt)
  {
    return paramInt >= b() + d();
  }
  
  private int d()
  {
    return this.a.getItemCount();
  }
  
  public RecyclerView.Adapter a()
  {
    return this.a;
  }
  
  public void a(View paramView)
  {
    SparseArrayCompat localSparseArrayCompat = this.b;
    localSparseArrayCompat.put(localSparseArrayCompat.size() + 100000, paramView);
  }
  
  public int b()
  {
    return this.b.size();
  }
  
  public void b(View paramView)
  {
    SparseArrayCompat localSparseArrayCompat = this.c;
    localSparseArrayCompat.put(localSparseArrayCompat.size() + 200000, paramView);
  }
  
  public int c()
  {
    return this.c.size();
  }
  
  public int getItemCount()
  {
    return b() + d() + c();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (a(paramInt)) {
      return this.b.keyAt(paramInt);
    }
    if (b(paramInt)) {
      return this.c.keyAt(paramInt - b() - d());
    }
    return this.a.getItemViewType(paramInt - b());
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((!a(paramInt)) && (!b(paramInt))) {
      this.a.onBindViewHolder(paramViewHolder, paramInt - b());
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.b.get(paramInt) != null) {
      return new AdapterWrapper.ViewHolder((View)this.b.get(paramInt));
    }
    if (this.c.get(paramInt) != null) {
      return new AdapterWrapper.ViewHolder((View)this.c.get(paramInt));
    }
    return this.a.onCreateViewHolder(paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.widget.AdapterWrapper
 * JD-Core Version:    0.7.0.1
 */