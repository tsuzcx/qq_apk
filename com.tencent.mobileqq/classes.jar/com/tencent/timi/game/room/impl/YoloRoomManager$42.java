package com.tencent.timi.game.room.impl;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomCommonListener;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.List;
import trpc.yes.common.YoloRoomOuterClass.GetYoloRoomDataRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomAction;

class YoloRoomManager$42
  implements RequestListener<YoloRoomOuterClass.GetYoloRoomDataRsp>
{
  YoloRoomManager$42(YoloRoomManager paramYoloRoomManager, long paramLong) {}
  
  public void a(YoloRoomOuterClass.GetYoloRoomDataRsp paramGetYoloRoomDataRsp, FromServiceMsg paramFromServiceMsg)
  {
    if ((this.b.v()) && (this.a == YoloRoomManager.i(this.b)))
    {
      if (paramGetYoloRoomDataRsp == null)
      {
        Logger.c("YoloRoomManager", "GetYoloRoomData yoloRoomDataRsp is null!");
      }
      else
      {
        boolean bool;
        if (paramGetYoloRoomDataRsp.has_more.get() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        int i = paramGetYoloRoomDataRsp.online_num.get();
        paramFromServiceMsg = paramGetYoloRoomDataRsp.action_list.get();
        if (paramFromServiceMsg.size() > 0) {
          YoloRoomManager.a(this.b, ((YoloRoomOuterClass.YoloRoomAction)paramFromServiceMsg.get(paramFromServiceMsg.size() - 1)).action_id.get());
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GetYoloRoomData suc - hasMoreAction= ");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append(", onlineNum= ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", maxClientActionId= ");
        ((StringBuilder)localObject).append(YoloRoomManager.k(this.b));
        ((StringBuilder)localObject).append(", yoloRoomActionList.size= ");
        ((StringBuilder)localObject).append(paramFromServiceMsg.size());
        Logger.a("YoloRoomManager", ((StringBuilder)localObject).toString());
        if (YoloRoomManager.l(this.b) != i)
        {
          YoloRoomManager.a(this.b, i);
          YoloRoomManager.m(this.b).a(i);
        }
        YoloRoomManager.n(this.b).clear();
        YoloRoomManager.n(this.b).addAll(paramGetYoloRoomDataRsp.uid_list.get());
        localObject = new ArrayList();
        i = 0;
        while (i < paramFromServiceMsg.size())
        {
          YoloRoomManager.a(this.b, (YoloRoomOuterClass.YoloRoomAction)paramFromServiceMsg.get(i), (List)localObject);
          i += 1;
        }
        if (((List)localObject).size() > 0) {
          YoloRoomManager.a((List)localObject);
        }
      }
      YoloRoomManager.d(this.b, false);
      YoloRoomManager.e(this.b, false);
      if ((!YoloRoomManager.o(this.b)) && ((paramGetYoloRoomDataRsp == null) || (paramGetYoloRoomDataRsp.has_more.get() == 0)))
      {
        this.b.b(false);
        return;
      }
      Logger.b("YoloRoomManager", "requestingRoomData immediately");
      YoloRoomManager.f(this.b, false);
      this.b.b(true);
      return;
    }
    paramGetYoloRoomDataRsp = new StringBuilder();
    paramGetYoloRoomDataRsp.append("GetYoloRoomData onRsp but skip!!! requestRoomId=");
    paramGetYoloRoomDataRsp.append(this.a);
    paramGetYoloRoomDataRsp.append(", roomId=");
    paramGetYoloRoomDataRsp.append(YoloRoomManager.i(this.b));
    Logger.c("YoloRoomManager", paramGetYoloRoomDataRsp.toString());
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, @Nullable YoloRoomOuterClass.GetYoloRoomDataRsp paramGetYoloRoomDataRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    YoloRoomManager.e(this.b, false);
    paramGetYoloRoomDataRsp = new StringBuilder();
    paramGetYoloRoomDataRsp.append("GetYoloRoomData onError -- ");
    paramGetYoloRoomDataRsp.append(paramInt2);
    paramGetYoloRoomDataRsp.append("");
    paramGetYoloRoomDataRsp.append(paramString1);
    paramGetYoloRoomDataRsp.append(" - ");
    paramGetYoloRoomDataRsp.append(paramString2);
    Logger.c("YoloRoomManager", paramGetYoloRoomDataRsp.toString());
    if (paramInt1 == 1002) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((paramInt1 != 0) && (YoloRoomManager.o(this.b))) {
      YoloRoomManager.f(this.b, false);
    }
    if (YoloRoomManager.o(this.b)) {
      Logger.b("YoloRoomManager", "requestingRoomData immediately");
    }
    YoloRoomUtil.a(paramInt2);
    if (paramInt2 == 920017)
    {
      YoloRoomManager.m(this.b).a(paramInt2, paramString2);
      YoloRoomManager.a(this.b, paramInt2, paramString2);
    }
    if ((paramInt2 != 920009) && (paramInt2 != 920003))
    {
      paramString1 = this.b;
      paramString1.b(YoloRoomManager.o(paramString1));
    }
    else
    {
      YoloRoomManager.p(this.b);
    }
    YoloRoomManager.f(this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.42
 * JD-Core Version:    0.7.0.1
 */