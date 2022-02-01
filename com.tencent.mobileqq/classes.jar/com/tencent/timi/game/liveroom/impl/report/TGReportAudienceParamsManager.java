package com.tencent.timi.game.liveroom.impl.report;

import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/report/TGReportAudienceParamsManager;", "", "()V", "audiencePageParamsMap", "", "", "acquireParamsMap", "clear", "", "updateParamMap", "roomId", "", "extraInfo", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGReportAudienceParamsManager
{
  public static final TGReportAudienceParamsManager.Companion a = new TGReportAudienceParamsManager.Companion(null);
  @NotNull
  private static final TGReportAudienceParamsManager c = new TGReportAudienceParamsManager();
  private Map<String, String> b;
  
  @NotNull
  public final Map<String, String> a()
  {
    Map localMap = this.b;
    if (localMap != null) {
      return localMap;
    }
    return (Map)new LinkedHashMap();
  }
  
  public final void a(long paramLong, @Nullable LiveRoomExtraInfo paramLiveRoomExtraInfo)
  {
    this.b = ((Map)TGReportUtil.a.a(paramLong, paramLiveRoomExtraInfo));
  }
  
  public final void b()
  {
    this.b = ((Map)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.report.TGReportAudienceParamsManager
 * JD-Core Version:    0.7.0.1
 */