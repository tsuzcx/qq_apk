package com.tencent.mobileqq.nearby.gameroom;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PlayerInvitePanel$1
  implements View.OnClickListener
{
  PlayerInvitePanel$1(PlayerInvitePanel paramPlayerInvitePanel, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (PlayerInvitePanel.a(this.b) != null)
    {
      AdapterView.OnItemClickListener localOnItemClickListener = PlayerInvitePanel.a(this.b);
      PlayerInvitePanel localPlayerInvitePanel = this.b;
      int i = this.a;
      localOnItemClickListener.onItemClick(localPlayerInvitePanel, paramView, i, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.PlayerInvitePanel.1
 * JD-Core Version:    0.7.0.1
 */