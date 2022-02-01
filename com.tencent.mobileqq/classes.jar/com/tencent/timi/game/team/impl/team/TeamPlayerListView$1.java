package com.tencent.timi.game.team.impl.team;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.gift.api.OnSelectGiftToUserListener;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

class TeamPlayerListView$1
  implements OnSelectGiftToUserListener
{
  TeamPlayerListView$1(TeamPlayerListView paramTeamPlayerListView) {}
  
  public void a(@NotNull List<CommonOuterClass.QQUserId> paramList, @Nullable String paramString)
  {
    TeamPlayerListView.a(this.a).clear();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = (CommonOuterClass.QQUserId)paramList.next();
      TeamPlayerListView.a(this.a).add(Long.valueOf(((CommonOuterClass.QQUserId)localObject).uid.get()));
    }
    TeamPlayerListView.a(this.a, paramString);
    paramString = TeamPlayerListView.b(this.a).iterator();
    while (paramString.hasNext())
    {
      localObject = (SpeakingPosBean)paramString.next();
      if (TeamPlayerListView.a(this.a).contains(Long.valueOf(((SpeakingPosBean)localObject).a().user_id.uid.get()))) {
        paramList = TeamPlayerListView.c(this.a);
      } else {
        paramList = null;
      }
      ((SpeakingPosBean)localObject).a(paramList);
    }
    TeamPlayerListView.e(this.a).a(TeamPlayerListView.b(this.a), ((IRoomService)ServiceCenter.a(IRoomService.class)).a(TeamPlayerListView.d(this.a)).j());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamPlayerListView.1
 * JD-Core Version:    0.7.0.1
 */