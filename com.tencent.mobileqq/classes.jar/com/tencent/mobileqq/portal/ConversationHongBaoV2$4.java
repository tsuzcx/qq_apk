package com.tencent.mobileqq.portal;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ConversationHongBaoV2$4
  implements View.OnClickListener
{
  ConversationHongBaoV2$4(ConversationHongBaoV2 paramConversationHongBaoV2) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.4
 * JD-Core Version:    0.7.0.1
 */