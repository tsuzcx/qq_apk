package com.tencent.timi.game.team.impl.team;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomCommonListener;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.impl.title.TeamTitleView;
import com.tencent.timi.game.ui.widget.CustomToastView;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.YoloRoomOuterClass.YoloBattleOBStatusChangeAction;
import trpc.yes.common.YoloRoomOuterClass.YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomModifyInfoActionContent;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;

class TeamContainerView$6
  implements YoloRoomInterface.YoloRoomCommonListener
{
  TeamContainerView$6(TeamContainerView paramTeamContainerView) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      CustomToastView.a(paramString);
    }
  }
  
  public void a(int paramInt, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    TeamContainerView.g(this.a).a(paramList);
  }
  
  public void a(long paramLong) {}
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(long paramLong1, long paramLong2, long paramLong3) {}
  
  public void a(long paramLong, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    TeamContainerView.g(this.a).a(paramList);
  }
  
  public void a(String paramString, int paramInt, YoloRoomOuterClass.YoloBattleOBStatusChangeAction paramYoloBattleOBStatusChangeAction) {}
  
  public void a(List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    TeamContainerView.g(this.a).a(paramList);
    TeamContainerView.b(this.a, paramList);
  }
  
  public void a(YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    TeamContainerView.g(this.a).a(paramList);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt, YoloRoomOuterClass.YoloGameRouteInfo paramYoloGameRouteInfo)
  {
    TeamContainerView.g(this.a).a(((IRoomService)ServiceCenter.a(IRoomService.class)).a(TeamContainerView.f(this.a)).h());
    TeamContainerView.b(this.a, ((IRoomService)ServiceCenter.a(IRoomService.class)).a(TeamContainerView.f(this.a)).h());
  }
  
  public void b(int paramInt, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    TeamContainerView.g(this.a).a(paramList);
    TeamContainerView.b(this.a, paramList);
  }
  
  public void b(long paramLong) {}
  
  public void b(long paramLong, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    TeamContainerView.g(this.a).a(paramList);
    TeamContainerView.b(this.a, paramList);
  }
  
  public void b(List<YoloRoomOuterClass.YoloRoomModifyInfoActionContent> paramList)
  {
    paramList = paramList.iterator();
    int j;
    YoloRoomOuterClass.YoloRoomModifyInfoActionContent localYoloRoomModifyInfoActionContent;
    do
    {
      boolean bool = paramList.hasNext();
      j = 1;
      if (!bool) {
        break;
      }
      localYoloRoomModifyInfoActionContent = (YoloRoomOuterClass.YoloRoomModifyInfoActionContent)paramList.next();
      i = j;
      if (localYoloRoomModifyInfoActionContent.type.get() == 102) {
        break label81;
      }
      i = j;
      if (localYoloRoomModifyInfoActionContent.type.get() == 2) {
        break label81;
      }
    } while (localYoloRoomModifyInfoActionContent.type.get() != 1);
    int i = j;
    break label81;
    i = 0;
    label81:
    if (i != 0) {
      TeamContainerView.h(this.a).a();
    }
  }
  
  public void c(int paramInt, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    TeamContainerView.g(this.a).a(paramList);
  }
  
  public void c(long paramLong)
  {
    TeamContainerView.h(this.a).a();
    TeamContainerView.g(this.a).a(paramLong);
    TeamContainerView.b(this.a, ((IRoomService)ServiceCenter.a(IRoomService.class)).a(TeamContainerView.f(this.a)).h());
  }
  
  public void d(int paramInt, YoloRoomOuterClass.YoloRoomSpeakingPosInfo paramYoloRoomSpeakingPosInfo, List<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> paramList)
  {
    TeamContainerView.g(this.a).a(paramList);
    if (paramYoloRoomSpeakingPosInfo.uid.get() == ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a()) {
      TeamContainerView.a(this.a, paramList);
    }
  }
  
  public void d(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamContainerView.6
 * JD-Core Version:    0.7.0.1
 */