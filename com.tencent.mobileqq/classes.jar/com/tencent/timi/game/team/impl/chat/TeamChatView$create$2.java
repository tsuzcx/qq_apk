package com.tencent.timi.game.team.impl.chat;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.component.chat.message.MessageLayout.OnScrollMsgListener;
import com.tencent.timi.game.component.chat.message.MessageLayoutImpl;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.impl.util.YoloRoomIMUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.sp.TGSharedPreferenceUtil;
import com.tencent.timi.game.ui.utils.TimeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSmobaConf;
import trpc.yes.wuji.WujiYoloRoomOuterClass.WujiYoloSmobaRoomConf;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TeamChatView$create$2
  implements Runnable
{
  TeamChatView$create$2(TeamChatView paramTeamChatView, int paramInt, YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo) {}
  
  public final void run()
  {
    TeamChatView.a(this.this$0).setOnScrollMsgListener((MessageLayout.OnScrollMsgListener)new TeamChatView.create.2.1(this));
    int i = this.a;
    if ((i == 1) || (i == 2))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("team_road_insert_time_");
      ((StringBuilder)localObject1).append(this.b.tim_group_id.get());
      localObject1 = ((StringBuilder)localObject1).toString();
      long l = TGSharedPreferenceUtil.b((String)localObject1, 0L);
      Object localObject2 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.b.room_id.get());
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "ServiceCenter.getService…a(roomInfo.room_id.get())");
      localObject2 = ((IRoomGetDataService)localObject2).c();
      if (localObject2 != null)
      {
        localObject2 = ((YoloRoomOuterClass.YoloRoomConf)localObject2).yolo_room_smoba_conf;
        if (localObject2 != null)
        {
          localObject2 = ((YoloRoomOuterClass.YoloRoomSmobaConf)localObject2).yolo_smoba_room_conf;
          if (localObject2 != null)
          {
            localObject2 = ((WujiYoloRoomOuterClass.WujiYoloSmobaRoomConf)localObject2).lanetype_message_send_time_interval;
            if (localObject2 != null)
            {
              i = ((PBInt32Field)localObject2).get();
              break label178;
            }
          }
        }
      }
      i = 600;
      label178:
      if (TimeUtils.a() - l > i * 1000)
      {
        YoloRoomIMUtil.a.b(this.b.tim_group_id.get());
        TGSharedPreferenceUtil.a((String)localObject1, TimeUtils.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamChatView.create.2
 * JD-Core Version:    0.7.0.1
 */