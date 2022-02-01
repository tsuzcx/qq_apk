package com.tencent.mobileqq.screendetect;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;

public class ScreenShotAdapter$ScreenShotViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public RecentDynamicAvatarView a;
  public final TextView b;
  private ScreenShotAdapter.OnHolderItemClickListener d;
  
  public ScreenShotAdapter$ScreenShotViewHolder(ScreenShotAdapter paramScreenShotAdapter, View paramView, ScreenShotAdapter.OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramView);
    this.a = ((RecentDynamicAvatarView)paramView.findViewById(2131435219));
    this.b = ((TextView)paramView.findViewById(2131439320));
    this.d = paramOnHolderItemClickListener;
    paramView.setOnClickListener(this);
    paramView.setTag(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.d != null) && (ScreenShotAdapter.a(this.c)))
    {
      this.d.a(paramView, getAdapterPosition() - 1);
    }
    else
    {
      ScreenShotAdapter.OnHolderItemClickListener localOnHolderItemClickListener = this.d;
      if (localOnHolderItemClickListener != null) {
        localOnHolderItemClickListener.a(paramView, getAdapterPosition());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotAdapter.ScreenShotViewHolder
 * JD-Core Version:    0.7.0.1
 */