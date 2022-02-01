package com.tencent.timi.game.teamlist.view;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TeamListView$4
  implements CompoundButton.OnCheckedChangeListener
{
  TeamListView$4(TeamListView paramTeamListView) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      TeamListView.a(this.a, true);
      this.a.c();
    }
    else
    {
      TeamListView.a(this.a, false);
      this.a.b();
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListView.4
 * JD-Core Version:    0.7.0.1
 */