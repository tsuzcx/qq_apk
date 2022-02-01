package com.tencent.timi.game.team.impl.team;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.concurrent.ConcurrentHashMap;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

class TeamPlayerAdapter$1
  implements View.OnClickListener
{
  TeamPlayerAdapter$1(TeamPlayerAdapter paramTeamPlayerAdapter, CommonOuterClass.QQUserId paramQQUserId, TeamPlayerViewHolder paramTeamPlayerViewHolder, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo) {}
  
  public void onClick(View paramView)
  {
    ConcurrentHashMap localConcurrentHashMap = YoloRoomUtil.c(TeamPlayerAdapter.a(this.d));
    localConcurrentHashMap.put("yes_to_uid", String.valueOf(this.a.uid.get()));
    ((IReportService)ServiceCenter.a(IReportService.class)).b(this.b.h, true, "座位区踢出队伍按钮", "em_yes_seat_kickout", localConcurrentHashMap);
    FleetProfileUtil.a.a(this.c.uid.get(), null, TeamPlayerAdapter.b(this.d));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamPlayerAdapter.1
 * JD-Core Version:    0.7.0.1
 */