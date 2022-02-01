package com.tencent.timi.game.teamlist.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;

class TeamListFilterAdapter$1
  implements View.OnClickListener
{
  TeamListFilterAdapter$1(TeamListFilterAdapter paramTeamListFilterAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("itemClick");
    localStringBuilder.append(this.a);
    Logger.b("TeamListFilterAdapter", localStringBuilder.toString());
    boolean bool = ((CheckBox)paramView).isChecked();
    if (this.a == 0)
    {
      if (bool) {
        TeamListFilterAdapter.a(this.b);
      }
    }
    else
    {
      TeamListFilterAdapter.a(this.b, false);
      TeamListFilterAdapter.b(this.b).set(this.a - 1, Boolean.valueOf(bool));
      TeamListFilterAdapter.c(this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.presenter.TeamListFilterAdapter.1
 * JD-Core Version:    0.7.0.1
 */