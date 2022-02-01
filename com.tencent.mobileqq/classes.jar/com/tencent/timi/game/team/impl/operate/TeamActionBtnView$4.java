package com.tencent.timi.game.team.impl.operate;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.NoDoubleClickUtils;

class TeamActionBtnView$4
  implements View.OnClickListener
{
  TeamActionBtnView$4(TeamActionBtnView paramTeamActionBtnView, boolean paramBoolean, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a()) {
      if (!this.a)
      {
        CustomToastView.a("需要所有人都准备，才可以发车哦");
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("最少需要");
        localStringBuilder.append(this.b);
        localStringBuilder.append("人才可以发车哦");
        CustomToastView.a(localStringBuilder.toString());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.operate.TeamActionBtnView.4
 * JD-Core Version:    0.7.0.1
 */