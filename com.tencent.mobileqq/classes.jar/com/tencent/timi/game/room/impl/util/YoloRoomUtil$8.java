package com.tencent.timi.game.room.impl.util;

import android.app.Activity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.expand.hall.api.HallReportHelper;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.RoomInterceptCheckCallback;
import com.tencent.timi.game.room.api.RoomInterceptCheckParam;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.impl.YoloRoomList;
import com.tencent.timi.game.room.impl.YoloRoomManager;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.SmobaCheckCallback;
import com.tencent.timi.game.ui.widget.CommonDialog;
import com.tencent.timi.game.ui.widget.CommonDialog.Builder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

final class YoloRoomUtil$8
  implements SmobaCheckCallback
{
  YoloRoomUtil$8(RoomInterceptCheckParam paramRoomInterceptCheckParam, RoomInterceptCheckCallback paramRoomInterceptCheckCallback, Activity paramActivity) {}
  
  public void a()
  {
    Object localObject1;
    if (YoloRoomList.a().d())
    {
      localObject1 = new ArrayList();
      if (this.a.b == 1)
      {
        ((List)localObject1).add(Integer.valueOf(this.a.b));
      }
      else
      {
        ((List)localObject1).add(Integer.valueOf(2));
        ((List)localObject1).add(Integer.valueOf(3));
      }
      Object localObject3 = YoloRoomList.a().a((List)localObject1);
      if (localObject3 == null)
      {
        localObject1 = this.b;
        if (localObject1 != null) {
          ((RoomInterceptCheckCallback)localObject1).a();
        }
      }
      else
      {
        if (((YoloRoomManager)localObject3).a() != 1)
        {
          YoloRoomUtil.a((YoloRoomManager)localObject3, this.b);
          return;
        }
        if (this.a.b == 1) {
          localObject1 = "车队";
        } else {
          localObject1 = "房间";
        }
        Object localObject4 = new CommonDialog.Builder(this.c).a("");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("是否退出当前");
        localStringBuilder.append("车队");
        localStringBuilder.append("并");
        if (this.a.a) {
          localObject2 = "创建";
        } else {
          localObject2 = "加入";
        }
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append("新");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("？");
        Object localObject2 = ((CommonDialog.Builder)localObject4).c(localStringBuilder.toString()).a(17).d("确认").a(new YoloRoomUtil.8.2(this, (YoloRoomManager)localObject3)).e("取消").b(new YoloRoomUtil.8.1(this)).a();
        localObject1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(5);
        if (localObject1 != null)
        {
          localObject3 = YoloRoomUtil.c((YoloRoomOuterClass.YoloRoomInfo)localObject1);
          boolean bool = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(((YoloRoomOuterClass.YoloRoomInfo)localObject1).room_id.get()).o();
          localObject1 = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
          if (localObject1 != null)
          {
            ((IExpandHall)localObject1).e().a(localObject2);
          }
          else
          {
            localObject4 = (IReportService)ServiceCenter.a(IReportService.class);
            if (bool) {
              localObject1 = "pg_sgrp_smoba_cpdd";
            } else {
              localObject1 = "pg_kl_smoba_cpdd";
            }
            ((IReportService)localObject4).a(localObject2, (String)localObject1);
          }
          if (bool)
          {
            ((IReportService)ServiceCenter.a(IReportService.class)).a(((CommonDialog)localObject2).a(), false, "", "em_yes_changeteam_win_confirm", (Map)localObject3);
            ((IReportService)ServiceCenter.a(IReportService.class)).a(((CommonDialog)localObject2).b(), false, "", "em_yes_changeteam_win_cancel", (Map)localObject3);
          }
          else
          {
            ((IReportService)ServiceCenter.a(IReportService.class)).a(((CommonDialog)localObject2).a(), false, "", "em_yes_changeteam_win_confirm", (Map)localObject3);
            ((IReportService)ServiceCenter.a(IReportService.class)).a(((CommonDialog)localObject2).b(), false, "", "em_yes_changeteam_win_cancel", (Map)localObject3);
          }
        }
        ((CommonDialog)localObject2).show();
      }
    }
    else
    {
      localObject1 = this.b;
      if (localObject1 != null) {
        ((RoomInterceptCheckCallback)localObject1).a();
      }
    }
  }
  
  public void a(String paramString)
  {
    RoomInterceptCheckCallback localRoomInterceptCheckCallback = this.b;
    if (localRoomInterceptCheckCallback != null) {
      localRoomInterceptCheckCallback.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil.8
 * JD-Core Version:    0.7.0.1
 */