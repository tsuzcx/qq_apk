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
  public int a;
  public ArkAppLoadLayout a;
  public ArkAppView a;
  MessageForArkFlashChat jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat = null;
  public FlashChatItem a;
  public FlashChatPanel.PluginData a;
  OnHolderItemClickListener jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener;
  public int b;
  int c;
  
  public FlashChatTextEffectView$MyViewHolder(View paramView, OnHolderItemClickListener paramOnHolderItemClickListener, int paramInt)
  {
    super(paramView);
    if (paramOnHolderItemClickListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener = paramOnHolderItemClickListener;
    }
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = ((ArkAppView)paramView.findViewById(2131362947));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout = ((ArkAppLoadLayout)paramView.findViewById(2131370350));
    this.itemView.setOnClickListener(this);
    this.itemView.setOnTouchListener(paramOnHolderItemClickListener);
  }
  
  public void onClick(View paramView)
  {
    OnHolderItemClickListener localOnHolderItemClickListener = this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener;
    if (localOnHolderItemClickListener != null) {
      localOnHolderItemClickListener.a(paramView, getPosition(), this.c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    OnHolderItemClickListener localOnHolderItemClickListener = this.jdField_a_of_type_ComTencentMobileqqFlashchatOnHolderItemClickListener;
    if (localOnHolderItemClickListener != null)
    {
      localOnHolderItemClickListener.b(paramView, getPosition(), this.c);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatTextEffectView.MyViewHolder
 * JD-Core Version:    0.7.0.1
 */