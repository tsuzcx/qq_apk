package com.tencent.timi.game.team.impl.team;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

class TeamPlayerAdapter$3
  implements View.OnClickListener
{
  TeamPlayerAdapter$3(TeamPlayerAdapter paramTeamPlayerAdapter, TeamPlayerViewHolder paramTeamPlayerViewHolder, int paramInt, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo) {}
  
  public void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a())
    {
      ((IReportService)ServiceCenter.a(IReportService.class)).b(this.a.i, true, "座位区座位锁定按钮", "em_yes_seat_lock", YoloRoomUtil.c(TeamPlayerAdapter.a(this.d)));
      TeamPlayerAdapter.a(this.d, this.b, this.c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamPlayerAdapter.3
 * JD-Core Version:    0.7.0.1
 */