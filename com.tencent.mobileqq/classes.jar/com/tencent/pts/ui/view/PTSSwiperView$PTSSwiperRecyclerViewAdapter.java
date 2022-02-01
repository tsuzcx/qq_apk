package com.tencent.pts.ui.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSRecyclerViewAdapter;
import com.tencent.pts.ui.PTSRecyclerViewAdapter.PTSViewHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PTSSwiperView$PTSSwiperRecyclerViewAdapter
  extends PTSRecyclerViewAdapter
{
  private boolean isInfiniteLoop = true;
  
  public PTSSwiperView$PTSSwiperRecyclerViewAdapter(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  public int getItemCount()
  {
    if (this.isInfiniteLoop) {
      return 2147483647;
    }
    return getRealItemCount();
  }
  
  public int getItemViewType(int paramInt)
  {
    return super.getItemViewType(getRealPosition(paramInt));
  }
  
  public int getRealItemCount()
  {
    return super.getItemCount();
  }
  
  public int getRealPosition(int paramInt)
  {
    int i = paramInt;
    if (this.isInfiniteLoop)
    {
      int j = getRealItemCount();
      i = paramInt;
      if (j > 0) {
        i = paramInt % j;
      }
    }
    return i;
  }
  
  public void onBindViewHolder(@NonNull PTSRecyclerViewAdapter.PTSViewHolder paramPTSViewHolder, int paramInt)
  {
    super.onBindViewHolder(paramPTSViewHolder, getRealPosition(paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramPTSViewHolder, paramInt, getItemId(paramInt));
  }
  
  public void setInfiniteLoop(boolean paramBoolean)
  {
    this.isInfiniteLoop = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSSwiperView.PTSSwiperRecyclerViewAdapter
 * JD-Core Version:    0.7.0.1
 */