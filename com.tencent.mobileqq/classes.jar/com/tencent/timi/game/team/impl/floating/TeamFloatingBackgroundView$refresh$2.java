package com.tencent.timi.game.team.impl.floating;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class TeamFloatingBackgroundView$refresh$2
  implements View.OnClickListener
{
  TeamFloatingBackgroundView$refresh$2(TeamFloatingBackgroundView paramTeamFloatingBackgroundView) {}
  
  public final void onClick(View paramView)
  {
    TeamFloatingBackgroundView.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.TeamFloatingBackgroundView.refresh.2
 * JD-Core Version:    0.7.0.1
 */