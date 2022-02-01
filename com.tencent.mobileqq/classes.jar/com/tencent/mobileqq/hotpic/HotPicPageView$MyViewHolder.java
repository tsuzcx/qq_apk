package com.tencent.mobileqq.hotpic;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HotPicPageView$MyViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  OnHolderItemClickListener a;
  ImageView d;
  
  public HotPicPageView$MyViewHolder(HotPicPageView paramHotPicPageView, View paramView, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramView);
    if (paramOnHolderItemClickListener != null)
    {
      this.a = paramOnHolderItemClickListener;
      this.d = ((ImageView)paramView.findViewById(2131368560));
      this.d.setTag("HotPicControlTag");
      this.itemView.setOnClickListener(this);
      this.itemView.setOnLongClickListener(this);
      this.itemView.setOnTouchListener(paramOnHolderItemClickListener);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.a(paramView, getPosition());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = false;
    if (this.a != null)
    {
      this.a.b(paramView, getPosition());
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.MyViewHolder
 * JD-Core Version:    0.7.0.1
 */