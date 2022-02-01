package com.tencent.timi.game.team.impl.chat;

import android.widget.TextView;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

class TeamAtListView$TeamAtListViewPresenter
{
  boolean a = false;
  
  private TeamAtListView$TeamAtListViewPresenter(TeamAtListView paramTeamAtListView) {}
  
  void a()
  {
    TeamAtListView.TeamAtListViewModel.b(TeamAtListView.b(this.b)).clear();
    b();
  }
  
  void a(long paramLong)
  {
    TeamAtListView.TeamAtListViewModel.a(TeamAtListView.b(this.b)).clear();
    TeamAtListView.TeamAtListViewModel.a(TeamAtListView.b(this.b)).addAll(((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramLong).h());
    long l = ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a();
    Iterator localIterator = TeamAtListView.TeamAtListViewModel.a(TeamAtListView.b(this.b)).iterator();
    while (localIterator.hasNext())
    {
      YoloRoomOuterClass.YoloRoomSpeakingPosInfo localYoloRoomSpeakingPosInfo = (YoloRoomOuterClass.YoloRoomSpeakingPosInfo)localIterator.next();
      if ((localYoloRoomSpeakingPosInfo.uid.get() == 0L) || (localYoloRoomSpeakingPosInfo.uid.get() == l)) {
        localIterator.remove();
      }
    }
    TeamAtListView.TeamAtListViewModel.a(TeamAtListView.b(this.b), ((IRoomService)ServiceCenter.a(IRoomService.class)).a(paramLong).f());
    TeamAtListView.c(this.b).notifyDataSetChanged();
  }
  
  void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    TeamAtListView.c(this.b).notifyDataSetChanged();
    if (paramBoolean)
    {
      TeamAtListView.d(this.b).setText("完成");
      return;
    }
    TeamAtListView.d(this.b).setText("多选");
  }
  
  void b()
  {
    this.b.dismiss();
    Iterator localIterator = TeamAtListView.TeamAtListViewModel.b(TeamAtListView.b(this.b)).iterator();
    while (localIterator.hasNext()) {
      Logger.a("TeamAtListView", ((TeamAtListView.AtMember)localIterator.next()).a);
    }
    if (TeamAtListView.e(this.b) != null) {
      TeamAtListView.e(this.b).a(TeamAtListView.TeamAtListViewModel.b(TeamAtListView.b(this.b)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamAtListView.TeamAtListViewPresenter
 * JD-Core Version:    0.7.0.1
 */