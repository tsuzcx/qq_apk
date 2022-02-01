package com.tencent.timi.game.room.impl.util;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.room.impl.network.RecoverYoloRoomServlet;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.utils.TimeUtils;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.CommonOuterClass.OnlineRouteInfo;
import trpc.yes.common.CommonOuterClass.OnlineRouteInfoList;
import trpc.yes.common.CommonOuterClass.RoomRouteInfo;
import trpc.yes.common.UserProxyCmdOuterClass.GetUserRouteInfoRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomRecoverRsp;

class YoloRoomUtil$7$2
  implements IResultListener<UserProxyCmdOuterClass.GetUserRouteInfoRsp>
{
  YoloRoomUtil$7$2(YoloRoomUtil.7 param7, int paramInt, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createYoloRoom - getUserOnlineRouteInfoList errorCode = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramString);
    Logger.c("YoloRoomUtil", localStringBuilder.toString());
    if (this.c.a != null) {
      this.c.a.a(this.a, this.b);
    }
  }
  
  public void a(UserProxyCmdOuterClass.GetUserRouteInfoRsp paramGetUserRouteInfoRsp)
  {
    Object localObject = new ArrayList();
    if ((paramGetUserRouteInfoRsp != null) && (paramGetUserRouteInfoRsp.route_list.has()) && (paramGetUserRouteInfoRsp.route_list.route_list.size() > 0))
    {
      paramGetUserRouteInfoRsp = paramGetUserRouteInfoRsp.route_list.route_list.get().iterator();
      while (paramGetUserRouteInfoRsp.hasNext())
      {
        CommonOuterClass.OnlineRouteInfo localOnlineRouteInfo = (CommonOuterClass.OnlineRouteInfo)paramGetUserRouteInfoRsp.next();
        if ((localOnlineRouteInfo != null) && (localOnlineRouteInfo.route_status.get() == 1) && (localOnlineRouteInfo.yolo_room_route_info.room_id.get() != 0L) && (localOnlineRouteInfo.expire_time.get() * 1000L > TimeUtils.a())) {
          ((List)localObject).add(localOnlineRouteInfo);
        }
      }
    }
    if (((List)localObject).size() > 0)
    {
      paramGetUserRouteInfoRsp = ((List)localObject).iterator();
      while (paramGetUserRouteInfoRsp.hasNext())
      {
        localObject = (CommonOuterClass.OnlineRouteInfo)paramGetUserRouteInfoRsp.next();
        long l = ((CommonOuterClass.OnlineRouteInfo)localObject).yolo_room_route_info.room_id.get();
        int i = ((CommonOuterClass.OnlineRouteInfo)localObject).yolo_room_route_info.room_type.get();
        ((NetApi)ServiceCenter.a(NetApi.class)).a(RecoverYoloRoomServlet.a(l), YoloRoomOuterClass.YoloRoomRecoverRsp.class, new YoloRoomUtil.7.2.1(this, l, i));
      }
    }
    if (this.c.a != null) {
      this.c.a.a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil.7.2
 * JD-Core Version:    0.7.0.1
 */