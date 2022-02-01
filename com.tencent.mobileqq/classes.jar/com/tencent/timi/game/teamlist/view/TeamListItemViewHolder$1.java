package com.tencent.timi.game.teamlist.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.expand.hall.api.HallReportHelper;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.room.api.GuildShequnParams;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.teamlist.presenter.TeamListVerticalAdapter.OnTeamClickListener;
import java.util.List;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

class TeamListItemViewHolder$1
  implements View.OnClickListener
{
  TeamListItemViewHolder$1(TeamListItemViewHolder paramTeamListItemViewHolder, TeamListVerticalAdapter.OnTeamClickListener paramOnTeamClickListener, long paramLong, int paramInt1, int paramInt2, List paramList) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.a;
    if (localObject1 != null) {
      ((TeamListVerticalAdapter.OnTeamClickListener)localObject1).a(this.f.getAdapterPosition());
    }
    localObject1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(5);
    long l1;
    if (localObject1 != null) {
      l1 = ((YoloRoomOuterClass.YoloRoomInfo)localObject1).room_id.get();
    } else {
      l1 = 0L;
    }
    Object localObject2 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (localObject2 != null) {
      localObject1 = ((IExpandHall)localObject2).b();
    } else {
      localObject1 = null;
    }
    int i;
    if ((localObject1 != null) && (((ExpandHallLaunchParam)localObject1).a == 2)) {
      i = 1;
    } else {
      i = 0;
    }
    if (localObject2 != null) {
      localObject1 = ((IExpandHall)localObject2).e().u();
    } else {
      localObject1 = null;
    }
    localObject2 = (IRoomService)ServiceCenter.a(IRoomService.class);
    QBaseActivity localQBaseActivity = TimiGameActivityManager.a();
    long l2 = this.b;
    if (i != 0) {
      i = 2;
    } else {
      i = 1;
    }
    ((IRoomService)localObject2).a(true, localQBaseActivity, l2, i, 1, this.c, this.d, 0, this.e, ((IRoomService)ServiceCenter.a(IRoomService.class)).b(this.c), (GuildShequnParams)localObject1, l1, new TeamListItemViewHolder.1.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListItemViewHolder.1
 * JD-Core Version:    0.7.0.1
 */