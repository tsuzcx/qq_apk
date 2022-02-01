package com.tencent.timi.game.component.chat.message;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
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
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.IntRef;
import trpc.yes.common.MessageOuterClass.ShareYoloRoomMsg;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaGameDataInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class TeamMessageItemView$renderUI$4
  implements View.OnClickListener
{
  TeamMessageItemView$renderUI$4(TeamMessageItemView paramTeamMessageItemView, MessageOuterClass.ShareYoloRoomMsg paramShareYoloRoomMsg, Ref.IntRef paramIntRef, YoloRoomOuterClass.YoloSmobaGameDataInfo paramYoloSmobaGameDataInfo, IMsg paramIMsg) {}
  
  public final void onClick(View paramView)
  {
    Object localObject1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(5);
    if (localObject1 != null)
    {
      localObject1 = ((YoloRoomOuterClass.YoloRoomInfo)localObject1).room_id;
      if (localObject1 != null)
      {
        l1 = ((PBUInt64Field)localObject1).get();
        break label44;
      }
    }
    long l1 = 0L;
    label44:
    localObject1 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    IRoomService localIRoomService = null;
    if (localObject1 != null) {
      localObject1 = ((IExpandHall)localObject1).b();
    } else {
      localObject1 = null;
    }
    int i;
    if ((localObject1 != null) && (((ExpandHallLaunchParam)localObject1).a == 2)) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject2 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    localObject1 = localIRoomService;
    if (localObject2 != null)
    {
      localObject2 = ((IExpandHall)localObject2).e();
      localObject1 = localIRoomService;
      if (localObject2 != null) {
        localObject1 = ((HallReportHelper)localObject2).u();
      }
    }
    localIRoomService = (IRoomService)ServiceCenter.a(IRoomService.class);
    localObject2 = (Activity)TimiGameActivityManager.a();
    long l2 = this.b.room_info.room_id.get();
    if (i != 0) {
      i = 2;
    } else {
      i = 1;
    }
    localIRoomService.a(true, (Activity)localObject2, l2, i, 1, this.b.room_info.room_type.get(), this.c.element, this.d.area.get(), this.d.grade_list.get(), ((IRoomService)ServiceCenter.a(IRoomService.class)).b(this.b.room_info.room_type.get()), (GuildShequnParams)localObject1, l1, (IResultListener)new TeamMessageItemView.renderUI.4.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.TeamMessageItemView.renderUI.4
 * JD-Core Version:    0.7.0.1
 */