package com.tencent.mobileqq.nearby.now.widget;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class CommonViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  @Nullable
  private CommonViewHolder.ItemClickListener a;
  
  public void onClick(View paramView)
  {
    CommonViewHolder.ItemClickListener localItemClickListener = this.a;
    if (localItemClickListener != null) {
      localItemClickListener.a(getPosition(), paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    CommonViewHolder.ItemClickListener localItemClickListener = this.a;
    if (localItemClickListener != null)
    {
      localItemClickListener.b(getPosition(), paramView);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.widget.CommonViewHolder
 * JD-Core Version:    0.7.0.1
 */