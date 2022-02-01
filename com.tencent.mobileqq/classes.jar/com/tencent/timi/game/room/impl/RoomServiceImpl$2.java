package com.tencent.timi.game.room.impl;

import android.text.TextUtils;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

class RoomServiceImpl$2
  implements IResultListener<YoloRoomOuterClass.YoloRoomInfo>
{
  RoomServiceImpl$2(RoomServiceImpl paramRoomServiceImpl, IResultListener paramIResultListener) {}
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((IResultListener)localObject).a(paramInt, paramString);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString;
    }
    else if (Env.b())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("创建失败， errorCode == ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" errorMessage == ");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "创建失败，请稍后重试";
    }
    CustomToastView.a((String)localObject);
    localObject = new ConcurrentHashMap();
    ((ConcurrentHashMap)localObject).put("yes_fail_reason", paramString);
    ((ConcurrentHashMap)localObject).put("yes_room_type", String.valueOf(1));
    ((IReportService)ServiceCenter.a(IReportService.class)).a("ev_yes_team_create_fail", (Map)localObject);
  }
  
  public void a(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo)
  {
    IResultListener localIResultListener = this.a;
    if (localIResultListener != null) {
      localIResultListener.a(paramYoloRoomInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.RoomServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */