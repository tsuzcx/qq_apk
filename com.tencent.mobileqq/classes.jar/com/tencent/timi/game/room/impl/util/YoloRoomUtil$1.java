package com.tencent.timi.game.room.impl.util;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.room.impl.YoloRoomList;
import com.tencent.timi.game.ui.utils.TimeUtils;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import java.util.List;
import trpc.yes.common.CommonOuterClass.OnlineRouteInfo;
import trpc.yes.common.CommonOuterClass.OnlineRouteInfoList;
import trpc.yes.common.CommonOuterClass.RoomRouteInfo;
import trpc.yes.common.UserProxyCmdOuterClass.GetUserRouteInfoRsp;

final class YoloRoomUtil$1
  implements IResultListener<UserProxyCmdOuterClass.GetUserRouteInfoRsp>
{
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshRoomRouteAndResume#getOnlineRouteInfoListRequest ERROR - ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg = ");
    localStringBuilder.append(paramString);
    Logger.c("YoloRoomUtil", localStringBuilder.toString());
  }
  
  public void a(UserProxyCmdOuterClass.GetUserRouteInfoRsp paramGetUserRouteInfoRsp)
  {
    if ((paramGetUserRouteInfoRsp != null) && (paramGetUserRouteInfoRsp.route_list.has())) {
      paramGetUserRouteInfoRsp = paramGetUserRouteInfoRsp.route_list;
    } else {
      paramGetUserRouteInfoRsp = null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshRoomRoute OnlineRouteInfoList - ");
    ((StringBuilder)localObject).append(paramGetUserRouteInfoRsp);
    if (((StringBuilder)localObject).toString() != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("size=");
      ((StringBuilder)localObject).append(paramGetUserRouteInfoRsp.route_list.size());
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "null";
    }
    Logger.a("YoloRoomUtil", (String)localObject);
    if ((paramGetUserRouteInfoRsp != null) && (paramGetUserRouteInfoRsp.route_list.size() > 0))
    {
      paramGetUserRouteInfoRsp = paramGetUserRouteInfoRsp.route_list.get().iterator();
      int i = 0;
      for (;;)
      {
        j = i;
        if (!paramGetUserRouteInfoRsp.hasNext()) {
          break;
        }
        localObject = (CommonOuterClass.OnlineRouteInfo)paramGetUserRouteInfoRsp.next();
        if ((((CommonOuterClass.OnlineRouteInfo)localObject).route_status.get() == 1) && (((CommonOuterClass.OnlineRouteInfo)localObject).yolo_room_route_info.has()))
        {
          j = i + 1;
          CommonOuterClass.RoomRouteInfo localRoomRouteInfo = ((CommonOuterClass.OnlineRouteInfo)localObject).yolo_room_route_info;
          long l1 = ((CommonOuterClass.OnlineRouteInfo)localObject).expire_time.get() * 1000L;
          long l2 = localRoomRouteInfo.room_id.get();
          int k = localRoomRouteInfo.room_type.get();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("refreshRoomRoute - YoloRoomRouteInfo, yoloRoomId = ");
          ((StringBuilder)localObject).append(l2);
          ((StringBuilder)localObject).append(", yoloRoomType= ");
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append(", expireTime =");
          ((StringBuilder)localObject).append(l1);
          Logger.a("YoloRoomUtil", ((StringBuilder)localObject).toString());
          i = j;
          if (l2 != 0L)
          {
            i = j;
            if (l1 > TimeUtils.a()) {
              if (YoloRoomList.a().c(l2))
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("refreshRoomRoute - room exist -");
                ((StringBuilder)localObject).append(l2);
                Logger.a("YoloRoomUtil", ((StringBuilder)localObject).toString());
                i = j;
              }
              else
              {
                YoloRoomUtil.a(l2, k, false);
                i = j;
              }
            }
          }
        }
      }
    }
    int j = 0;
    if (j == 0) {
      YoloRoomList.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil.1
 * JD-Core Version:    0.7.0.1
 */