package com.tencent.mobileqq.kandian.base.view.widget;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter;

class RecyclerViewWithHeaderFooterFix$1
  extends RecyclerViewHeaderViewAdapter<RecyclerView.Adapter>
{
  RecyclerViewWithHeaderFooterFix$1(RecyclerViewWithHeaderFooterFix paramRecyclerViewWithHeaderFooterFix, RecyclerView.Adapter paramAdapter)
  {
    super(paramAdapter);
  }
  
  protected void onBindHeader(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.onBindHeader(paramViewHolder, paramInt);
    this.a.a(paramViewHolder, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.RecyclerViewWithHeaderFooterFix.1
 * JD-Core Version:    0.7.0.1
 */