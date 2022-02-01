package com.tencent.mobileqq.hotpic;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class RecyclerFooterWrapperAdapter
  extends RecyclerView.Adapter
{
  HotPicFooterInterface a;
  private RecyclerView.Adapter b;
  private RecyclerView.AdapterDataObserver c = new RecyclerFooterWrapperAdapter.1(this);
  
  public RecyclerFooterWrapperAdapter(@NonNull RecyclerView.Adapter paramAdapter, HotPicFooterInterface paramHotPicFooterInterface)
  {
    this.a = paramHotPicFooterInterface;
    this.b = paramAdapter;
    this.b.registerAdapterDataObserver(this.c);
  }
  
  public int getItemCount()
  {
    if (this.a == null) {
      return this.b.getItemCount();
    }
    return this.b.getItemCount() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.a != null) && (paramInt == getItemCount() - 1)) {
      return 2147483647;
    }
    return super.getItemViewType(paramInt);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.a != null) && (paramInt == getItemCount() - 1)) {
      this.a.a(paramViewHolder, paramInt);
    } else {
      this.b.onBindViewHolder(paramViewHolder, paramInt);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    HotPicFooterInterface localHotPicFooterInterface = this.a;
    if ((localHotPicFooterInterface != null) && (2147483647 == paramInt)) {
      return localHotPicFooterInterface.a(paramViewGroup, paramInt);
    }
    return this.b.onCreateViewHolder(paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.RecyclerFooterWrapperAdapter
 * JD-Core Version:    0.7.0.1
 */