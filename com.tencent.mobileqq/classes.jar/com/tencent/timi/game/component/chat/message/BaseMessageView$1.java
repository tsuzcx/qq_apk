package com.tencent.timi.game.component.chat.message;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
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
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import trpc.yes.common.CommonOuterClass.OnlineRouteInfo;
import trpc.yes.common.CommonOuterClass.OnlineRouteInfoList;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.CommonOuterClass.RoomRouteInfo;
import trpc.yes.common.PremadesTeamServerOuterClass.UserOnlineRouteInfoList;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class BaseMessageView$1
  implements View.OnClickListener
{
  BaseMessageView$1(BaseMessageView paramBaseMessageView) {}
  
  public final void onClick(View paramView)
  {
    Logger.a("BaseMsgView ", "baseStatusDescTv click");
    Object localObject1 = TeamInfoAutoUpdateService.a();
    Object localObject2 = this.a.getMsg();
    long l2 = 0L;
    if (localObject2 != null)
    {
      localObject2 = ((IMsg)localObject2).d();
      if (localObject2 != null)
      {
        localObject2 = ((CommonOuterClass.QQUserId)localObject2).uid;
        if (localObject2 != null)
        {
          l1 = ((PBUInt64Field)localObject2).get();
          break label68;
        }
      }
    }
    long l1 = 0L;
    label68:
    localObject1 = ((TeamInfoAutoUpdateService)localObject1).a(l1);
    if (localObject1 != null)
    {
      localObject1 = ((PremadesTeamServerOuterClass.UserOnlineRouteInfoList)localObject1).list;
      if (localObject1 != null)
      {
        localObject1 = ((CommonOuterClass.OnlineRouteInfoList)localObject1).route_list;
        if (localObject1 != null)
        {
          localObject1 = ((PBRepeatMessageField)localObject1).get();
          if (localObject1 != null)
          {
            Object localObject3 = ((Iterable)localObject1).iterator();
            int j;
            int i;
            do
            {
              boolean bool = ((Iterator)localObject3).hasNext();
              j = 0;
              localObject2 = null;
              if (!bool) {
                break;
              }
              localObject1 = ((Iterator)localObject3).next();
              if (((CommonOuterClass.OnlineRouteInfo)localObject1).route_status.get() == 1) {
                i = 1;
              } else {
                i = 0;
              }
            } while (i == 0);
            break label190;
            localObject1 = null;
            label190:
            localObject3 = (CommonOuterClass.OnlineRouteInfo)localObject1;
            if (localObject3 != null)
            {
              localObject1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(5);
              l1 = l2;
              if (localObject1 != null)
              {
                localObject1 = ((YoloRoomOuterClass.YoloRoomInfo)localObject1).room_id;
                l1 = l2;
                if (localObject1 != null) {
                  l1 = ((PBUInt64Field)localObject1).get();
                }
              }
              localObject1 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
              if (localObject1 != null) {
                localObject1 = ((IExpandHall)localObject1).b();
              } else {
                localObject1 = null;
              }
              i = j;
              if (localObject1 != null)
              {
                i = j;
                if (((ExpandHallLaunchParam)localObject1).a == 2) {
                  i = 1;
                }
              }
              Object localObject4 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
              localObject1 = localObject2;
              if (localObject4 != null)
              {
                localObject4 = ((IExpandHall)localObject4).e();
                localObject1 = localObject2;
                if (localObject4 != null) {
                  localObject1 = ((HallReportHelper)localObject4).u();
                }
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("joinYoloRoom ");
              ((StringBuilder)localObject2).append(((CommonOuterClass.OnlineRouteInfo)localObject3).yolo_room_route_info.room_id.get());
              Logger.a("BaseMsgView ", ((StringBuilder)localObject2).toString());
              localObject2 = (IRoomService)ServiceCenter.a(IRoomService.class);
              localObject4 = (Activity)TimiGameActivityManager.a();
              l2 = ((CommonOuterClass.OnlineRouteInfo)localObject3).yolo_room_route_info.room_id.get();
              if (i != 0) {
                i = 2;
              } else {
                i = 1;
              }
              ((IRoomService)localObject2).a(true, (Activity)localObject4, l2, i, 1, 1, 0, 0, CollectionsKt.emptyList(), ((IRoomService)ServiceCenter.a(IRoomService.class)).b(1), (GuildShequnParams)localObject1, l1, null);
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.BaseMessageView.1
 * JD-Core Version:    0.7.0.1
 */