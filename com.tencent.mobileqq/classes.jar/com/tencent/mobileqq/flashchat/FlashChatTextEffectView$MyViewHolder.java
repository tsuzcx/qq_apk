package com.tencent.mobileqq.flashchat;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FlashChatTextEffectView$MyViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener, View.OnLongClickListener
{
  OnHolderItemClickListener a;
  public int b;
  public int c;
  public FlashChatItem d;
  public FlashChatPanel.PluginData e;
  int f;
  MessageForArkFlashChat g = null;
  public ArkAppView h;
  public ArkAppLoadLayout i;
  
  public FlashChatTextEffectView$MyViewHolder(View paramView, OnHolderItemClickListener paramOnHolderItemClickListener, int paramInt)
  {
    super(paramView);
    if (paramOnHolderItemClickListener != null) {
      this.a = paramOnHolderItemClickListener;
    }
    this.f = paramInt;
    this.h = ((ArkAppView)paramView.findViewById(2131428746));
    this.i = ((ArkAppLoadLayout)paramView.findViewById(2131437612));
    this.itemView.setOnClickListener(this);
    this.itemView.setOnTouchListener(paramOnHolderItemClickListener);
  }
  
  public void onClick(View paramView)
  {
    OnHolderItemClickListener localOnHolderItemClickListener = this.a;
    if (localOnHolderItemClickListener != null) {
      localOnHolderItemClickListener.a(paramView, getPosition(), this.f);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    OnHolderItemClickListener localOnHolderItemClickListener = this.a;
    if (localOnHolderItemClickListener != null)
    {
      localOnHolderItemClickListener.b(paramView, getPosition(), this.f);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView.MyViewHolder
 * JD-Core Version:    0.7.0.1
 */