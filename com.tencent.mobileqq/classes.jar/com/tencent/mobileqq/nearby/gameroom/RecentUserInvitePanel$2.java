package com.tencent.mobileqq.nearby.gameroom;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RecentUserInvitePanel$2
  implements View.OnClickListener
{
  RecentUserInvitePanel$2(RecentUserInvitePanel paramRecentUserInvitePanel) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel.2
 * JD-Core Version:    0.7.0.1
 */