package com.tencent.timi.game.component.chat.message;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.AutoUpdateServiceListener;
import com.tencent.timi.game.tim.api.message.IMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.ShareYoloRoomMsg;
import trpc.yes.common.PremadesTeamServerOuterClass.SmobaPremadesTeamInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/message/TeamMessageItemView$teamUpdateListener$1", "Lcom/tencent/timi/game/teamlist/service/TeamInfoAutoUpdateService$AutoUpdateServiceListener;", "onDataUpdate", "", "requestScene", "", "shareYoloRoomMsgList", "", "Ltrpc/yes/common/MessageOuterClass$ShareYoloRoomMsg;", "smobaPremadesTeamInfoList", "Ltrpc/yes/common/PremadesTeamServerOuterClass$SmobaPremadesTeamInfo;", "reqTeamIds", "", "onGetTeamIds", "onGetUids", "onUserOnlineRouteInfoListUpdate", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamMessageItemView$teamUpdateListener$1
  implements TeamInfoAutoUpdateService.AutoUpdateServiceListener
{
  @NotNull
  public List<Long> a()
  {
    if (this.a.getMsg() != null)
    {
      IMsg localIMsg = this.a.getMsg();
      if (localIMsg == null) {
        Intrinsics.throwNpe();
      }
      if (localIMsg.m() != 1)
      {
        localIMsg = this.a.getMsg();
        if (localIMsg == null) {
          Intrinsics.throwNpe();
        }
        if (localIMsg.g().share_yolo_room_msg.room_info.status.get() == 1)
        {
          localIMsg = this.a.getMsg();
          if (localIMsg == null) {
            Intrinsics.throwNpe();
          }
          return CollectionsKt.mutableListOf(new Long[] { Long.valueOf(localIMsg.g().share_yolo_room_msg.room_info.room_id.get()) });
        }
      }
    }
    return (List)new ArrayList();
  }
  
  public void a(@Nullable String paramString, @Nullable List<MessageOuterClass.ShareYoloRoomMsg> paramList, @Nullable List<PremadesTeamServerOuterClass.SmobaPremadesTeamInfo> paramList1, @Nullable List<Long> paramList2)
  {
    if (this.a.getMsg() != null)
    {
      paramString = this.a.getMsg();
      if (paramString == null) {
        Intrinsics.throwNpe();
      }
      if (paramString.m() == 1) {
        return;
      }
      paramString = this.a.getMsg();
      if (paramString == null) {
        Intrinsics.throwNpe();
      }
      long l = paramString.g().share_yolo_room_msg.room_info.room_id.get();
      if ((paramList2 != null) && (paramList2.contains(Long.valueOf(l)) == true))
      {
        paramString = null;
        paramList1 = null;
        if (paramList != null)
        {
          paramList = ((Iterable)paramList).iterator();
          int i;
          do
          {
            paramString = paramList1;
            if (!paramList.hasNext()) {
              break;
            }
            paramString = paramList.next();
            if (((MessageOuterClass.ShareYoloRoomMsg)paramString).room_info.room_id.get() == l) {
              i = 1;
            } else {
              i = 0;
            }
          } while (i == 0);
          paramString = (MessageOuterClass.ShareYoloRoomMsg)paramString;
        }
        if (paramString != null)
        {
          if (paramString.room_info.status.get() == 1)
          {
            paramList = this.a.getMsg();
            if (paramList != null) {
              paramList.a(paramString);
            }
            paramList = this.a.getMsg();
            if (paramList != null)
            {
              paramString = paramString.toByteArray();
              Intrinsics.checkExpressionValueIsNotNull(paramString, "findResult.toByteArray()");
              paramList.a(new String(paramString, Charsets.UTF_8));
            }
          }
          else
          {
            paramString = this.a.getMsg();
            if (paramString != null) {
              paramString.a(1);
            }
          }
        }
        else
        {
          paramString = this.a.getMsg();
          if (paramString != null) {
            paramString.a(1);
          }
        }
        paramString = this.a;
        paramList = paramString.getMsg();
        if (paramList == null) {
          Intrinsics.throwNpe();
        }
        paramString.b(paramList);
      }
    }
  }
  
  @NotNull
  public List<Long> b()
  {
    return (List)new ArrayList();
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.TeamMessageItemView.teamUpdateListener.1
 * JD-Core Version:    0.7.0.1
 */