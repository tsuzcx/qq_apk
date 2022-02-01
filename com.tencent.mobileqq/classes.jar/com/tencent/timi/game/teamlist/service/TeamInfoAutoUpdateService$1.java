package com.tencent.timi.game.teamlist.service;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.utils.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import trpc.yes.common.CommonOuterClass.OnlineRouteInfoList;
import trpc.yes.common.PremadesTeamServerOuterClass.RefreshAPIRsp;
import trpc.yes.common.PremadesTeamServerOuterClass.UserOnlineRouteInfoList;

class TeamInfoAutoUpdateService$1
  implements RequestListener<PremadesTeamServerOuterClass.RefreshAPIRsp>
{
  TeamInfoAutoUpdateService$1(TeamInfoAutoUpdateService paramTeamInfoAutoUpdateService, List paramList1, List paramList2) {}
  
  public void a(PremadesTeamServerOuterClass.RefreshAPIRsp paramRefreshAPIRsp, FromServiceMsg paramFromServiceMsg)
  {
    Logger.b("TeamInfoAutoUpdateService", "onSuccess");
    TeamInfoAutoUpdateService.a(this.c, false);
    if (paramRefreshAPIRsp == null) {
      return;
    }
    int i = paramRefreshAPIRsp.refresh_interval.get();
    TeamInfoAutoUpdateService.a(this.c).a(i * 1000);
    paramFromServiceMsg = this.a.iterator();
    Object localObject1;
    while (paramFromServiceMsg.hasNext())
    {
      localObject1 = (Long)paramFromServiceMsg.next();
      TeamInfoAutoUpdateService.b(this.c).remove(localObject1);
    }
    paramFromServiceMsg = paramRefreshAPIRsp.user_route_list.get().iterator();
    while (paramFromServiceMsg.hasNext())
    {
      localObject1 = (PremadesTeamServerOuterClass.UserOnlineRouteInfoList)paramFromServiceMsg.next();
      if (!((PremadesTeamServerOuterClass.UserOnlineRouteInfoList)localObject1).list.route_list.isEmpty()) {
        TeamInfoAutoUpdateService.b(this.c).put(Long.valueOf(((PremadesTeamServerOuterClass.UserOnlineRouteInfoList)localObject1).uid.get()), localObject1);
      }
    }
    paramFromServiceMsg = TeamInfoAutoUpdateService.c(this.c).entrySet().iterator();
    while (paramFromServiceMsg.hasNext())
    {
      Object localObject2 = (Map.Entry)paramFromServiceMsg.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (TeamInfoAutoUpdateService.AutoUpdateServiceListener)((Map.Entry)localObject2).getValue();
      if (localObject2 != null) {
        try
        {
          ((TeamInfoAutoUpdateService.AutoUpdateServiceListener)localObject2).a((String)localObject1, paramRefreshAPIRsp.share_yolo_room_msg.get(), paramRefreshAPIRsp.team_list.get(), this.b);
          ((TeamInfoAutoUpdateService.AutoUpdateServiceListener)localObject2).c();
        }
        catch (Exception localException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("业务Crash：");
          ((StringBuilder)localObject2).append(localException);
          Logger.c("TeamInfoAutoUpdateService", ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, @Nullable PremadesTeamServerOuterClass.RefreshAPIRsp paramRefreshAPIRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    Logger.c("TeamInfoAutoUpdateService", "onError");
    paramInt2 = TeamInfoAutoUpdateService.a(this.c).a() * 2;
    paramInt1 = paramInt2;
    if (paramInt2 > 60000) {
      paramInt1 = 60000;
    }
    TeamInfoAutoUpdateService.a(this.c).a(paramInt1);
    TeamInfoAutoUpdateService.a(this.c, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService.1
 * JD-Core Version:    0.7.0.1
 */