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
  OnHolderItemClickListener p;
  ImageView q;
  
  public HotPicPageView$MyViewHolder(HotPicPageView paramHotPicPageView, View paramView, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramView);
    if (paramOnHolderItemClickListener != null)
    {
      this.p = paramOnHolderItemClickListener;
      this.q = ((ImageView)paramView.findViewById(2131435176));
      this.q.setTag("HotPicControlTag");
      this.itemView.setOnClickListener(this);
      this.itemView.setOnLongClickListener(this);
      this.itemView.setOnTouchListener(paramOnHolderItemClickListener);
    }
  }
  
  public void onClick(View paramView)
  {
    OnHolderItemClickListener localOnHolderItemClickListener = this.p;
    if (localOnHolderItemClickListener != null) {
      localOnHolderItemClickListener.a(paramView, getPosition());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    OnHolderItemClickListener localOnHolderItemClickListener = this.p;
    if (localOnHolderItemClickListener != null)
    {
      localOnHolderItemClickListener.b(paramView, getPosition());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.MyViewHolder
 * JD-Core Version:    0.7.0.1
 */