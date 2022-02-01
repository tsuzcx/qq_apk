package com.tencent.timi.game.liveroom.impl.report;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.report.IQQLiveReportCallback;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.router.ServiceCenter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/report/TGReportUtil$registerRoomReportCallback$1$2", "Lcom/tencent/mobileqq/qqlive/report/IQQLiveReportCallback;", "onQQLiveReportEvent", "", "event", "", "data", "Ljava/util/HashMap;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGReportUtil$registerRoomReportCallback$$inlined$apply$lambda$1
  implements IQQLiveReportCallback
{
  TGReportUtil$registerRoomReportCallback$$inlined$apply$lambda$1(ILiveRoom paramILiveRoom, boolean paramBoolean, LiveRoomExtraInfo paramLiveRoomExtraInfo, long paramLong) {}
  
  public void a(@Nullable String paramString, @Nullable HashMap<String, String> paramHashMap)
  {
    Object localObject = (CharSequence)"event_room_enter";
    paramString = (CharSequence)paramString;
    if (!TextUtils.equals((CharSequence)localObject, paramString))
    {
      long l;
      if (TextUtils.equals((CharSequence)"event_room_exit", paramString))
      {
        localObject = (Map)TGReportUtil.a(TGReportUtil.a, this.b, this.d, this.c);
        ((Map)localObject).put("qqlive_entertime", String.valueOf(this.a.getEnterRoomTime()));
        if (paramHashMap != null)
        {
          paramString = (String)paramHashMap.get("key_room_window_mode");
          if (paramString != null) {}
        }
        else
        {
          paramString = "";
        }
        ((Map)localObject).put("qqlive_seeway", paramString);
        l = System.currentTimeMillis();
        ((Map)localObject).put("qqlive_timelong", String.valueOf(l - TGReportUtil.a.b()));
        TGReportUtil.a.b(l);
        ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a("ev_qqlive_heartbeat", (Map)localObject);
        if (!this.b)
        {
          localObject = (Map)TGReportUtil.a(TGReportUtil.a, this.d, this.c);
          ((Map)localObject).put("qqlive_entertime", String.valueOf(this.a.getEnterRoomTime()));
          if (paramHashMap != null)
          {
            paramString = (String)paramHashMap.get("key_room_window_mode");
            if (paramString != null) {}
          }
          else
          {
            paramString = "";
          }
          ((Map)localObject).put("qqlive_seeway", paramString);
          ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a("ev_qqlive_quitroom", (Map)localObject);
        }
        TGReportUtil.a.a(0L);
        this.a.stopRoomTimer();
        this.a.unRegisterReportCallback((IQQLiveReportCallback)this);
        return;
      }
      if (TextUtils.equals((CharSequence)"event_room_heart", paramString))
      {
        localObject = (Map)TGReportUtil.a(TGReportUtil.a, this.b, this.d, this.c);
        ((Map)localObject).put("qqlive_entertime", String.valueOf(this.a.getEnterRoomTime()));
        if (paramHashMap != null)
        {
          paramString = (String)paramHashMap.get("key_room_window_mode");
          if (paramString != null) {}
        }
        else
        {
          paramString = "";
        }
        ((Map)localObject).put("qqlive_seeway", paramString);
        l = System.currentTimeMillis();
        ((Map)localObject).put("qqlive_timelong", String.valueOf(l - TGReportUtil.a.b()));
        TGReportUtil.a.b(l);
        ((ILiveReportService)ServiceCenter.a(ILiveReportService.class)).a("ev_qqlive_heartbeat", (Map)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.report.TGReportUtil.registerRoomReportCallback..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */