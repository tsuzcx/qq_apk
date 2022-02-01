package com.tencent.timi.game.room.impl.util;

import android.app.Activity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.room.api.GuildShequnParams;
import com.tencent.timi.game.room.api.SimpleRoomInterceptCheckCallback;
import com.tencent.timi.game.room.impl.network.JoinYoloRoomServlet;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.ISmobaService;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameMode;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomEnterRsp;

final class YoloRoomUtil$5
  extends SimpleRoomInterceptCheckCallback
{
  YoloRoomUtil$5(long paramLong1, Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, GuildShequnParams paramGuildShequnParams, long paramLong2, boolean paramBoolean2, IResultListener paramIResultListener, List paramList, int paramInt4) {}
  
  private void b(String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    localConcurrentHashMap.put("yes_fail_reason", paramString);
    localConcurrentHashMap.put("yes_team_id", String.valueOf(this.a));
    localConcurrentHashMap.put("yes_team_rank", YoloRoomUtil.a(this.k));
    paramString = ((ISmobaService)ServiceCenter.a(ISmobaService.class)).e(this.l);
    if (paramString != null) {
      paramString = paramString.mode_name.get();
    } else {
      paramString = String.valueOf(this.l);
    }
    localConcurrentHashMap.put("yes_game_mode", paramString);
    localConcurrentHashMap.put("yes_ref_room_id", String.valueOf(this.h));
    localConcurrentHashMap.put("yes_ref_room_type", String.valueOf(5));
    paramString = this.g;
    if (paramString != null)
    {
      localConcurrentHashMap.put("yes_ref_qq_group_num", String.valueOf(paramString.a));
      localConcurrentHashMap.put("yes_ref_channel_num", String.valueOf(this.g.b));
      localConcurrentHashMap.put("yes_ref_channel_name", String.valueOf(this.g.c));
    }
    ((IReportService)ServiceCenter.a(IReportService.class)).a("ev_yes_team_join_fail", localConcurrentHashMap);
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enterYoloRoom ");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(" - checkSuccess");
    Logger.a("YoloRoomUtil", ((StringBuilder)localObject).toString());
    localObject = this.b;
    if ((localObject != null) && ((localObject instanceof TimiGameBaseActivity)) && (!((Activity)localObject).isFinishing())) {
      ((TimiGameBaseActivity)this.b).a();
    }
    localObject = (NetApi)ServiceCenter.a(NetApi.class);
    long l1 = this.a;
    int n = this.c;
    int i1 = this.d;
    int m;
    if (this.e) {
      m = 1;
    } else {
      m = 2;
    }
    ((NetApi)localObject).a(JoinYoloRoomServlet.a(l1, n, i1, m, this.f, this.g, this.h), YoloRoomOuterClass.YoloRoomEnterRsp.class, new YoloRoomUtil.5.1(this));
  }
  
  public void a(String paramString)
  {
    IResultListener localIResultListener = this.j;
    if (localIResultListener != null) {
      localIResultListener.a(-1244, "");
    }
    b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil.5
 * JD-Core Version:    0.7.0.1
 */