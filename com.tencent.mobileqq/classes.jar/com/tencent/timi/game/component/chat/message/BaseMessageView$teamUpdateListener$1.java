package com.tencent.timi.game.component.chat.message;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.AutoUpdateServiceListener;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.ShareYoloRoomMsg;
import trpc.yes.common.PremadesTeamServerOuterClass.SmobaPremadesTeamInfo;
import trpc.yes.common.PremadesTeamServerOuterClass.UserOnlineRouteInfoList;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/message/BaseMessageView$teamUpdateListener$1", "Lcom/tencent/timi/game/teamlist/service/TeamInfoAutoUpdateService$AutoUpdateServiceListener;", "onDataUpdate", "", "requestScene", "", "shareYoloRoomMsgList", "", "Ltrpc/yes/common/MessageOuterClass$ShareYoloRoomMsg;", "smobaPremadesTeamInfoList", "Ltrpc/yes/common/PremadesTeamServerOuterClass$SmobaPremadesTeamInfo;", "reqTeamIds", "", "onGetTeamIds", "onGetUids", "onUserOnlineRouteInfoListUpdate", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BaseMessageView$teamUpdateListener$1
  implements TeamInfoAutoUpdateService.AutoUpdateServiceListener
{
  @NotNull
  public List<Long> a()
  {
    return (List)new ArrayList();
  }
  
  public void a(@Nullable String paramString, @Nullable List<MessageOuterClass.ShareYoloRoomMsg> paramList, @Nullable List<PremadesTeamServerOuterClass.SmobaPremadesTeamInfo> paramList1, @Nullable List<Long> paramList2) {}
  
  @NotNull
  public List<Long> b()
  {
    Object localObject = this.a.getMsg();
    if (localObject != null)
    {
      localObject = ((IMsg)localObject).d();
      if (localObject != null)
      {
        localObject = ((CommonOuterClass.QQUserId)localObject).uid;
        if (localObject != null)
        {
          l = ((PBUInt64Field)localObject).get();
          break label42;
        }
      }
    }
    long l = 0L;
    label42:
    localObject = this.a.getRoomInfo();
    if (localObject != null)
    {
      localObject = ((YoloRoomOuterClass.YoloRoomInfo)localObject).room_type;
      if ((localObject != null) && (((PBInt32Field)localObject).get() == 1)) {}
    }
    else if (l > 20000)
    {
      return CollectionsKt.mutableListOf(new Long[] { Long.valueOf(l) });
    }
    return (List)new ArrayList();
  }
  
  public void c()
  {
    Object localObject1 = this.a.getMsg();
    if (localObject1 != null) {
      localObject1 = ((IMsg)localObject1).f();
    } else {
      localObject1 = null;
    }
    if (localObject1 == MsgStatus.REVOKE) {
      return;
    }
    localObject1 = TeamInfoAutoUpdateService.a();
    Object localObject2 = this.a.getMsg();
    if (localObject2 != null)
    {
      localObject2 = ((IMsg)localObject2).d();
      if (localObject2 != null)
      {
        localObject2 = ((CommonOuterClass.QQUserId)localObject2).uid;
        if (localObject2 != null)
        {
          l = ((PBUInt64Field)localObject2).get();
          break label87;
        }
      }
    }
    long l = 0L;
    label87:
    localObject1 = ((TeamInfoAutoUpdateService)localObject1).a(l);
    BaseMessageView.a(this.a, (PremadesTeamServerOuterClass.UserOnlineRouteInfoList)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.BaseMessageView.teamUpdateListener.1
 * JD-Core Version:    0.7.0.1
 */