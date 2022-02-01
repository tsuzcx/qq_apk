package com.tencent.timi.game.liveroom.impl.live.widget;

import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "", "", "it", "kotlin.jvm.PlatformType", "getDynamicParams"}, k=3, mv={1, 1, 16})
final class HorBottomControllerView$bindReport$1
  implements IDynamicParams
{
  HorBottomControllerView$bindReport$1(HorBottomControllerView paramHorBottomControllerView) {}
  
  @NotNull
  public final Map<String, Object> getDynamicParams(String paramString)
  {
    if (HorBottomControllerView.a(this.a)) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    return MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("qqlive_danmu_status", paramString), TuplesKt.to("qqlive_screen_orientation", "1"), TuplesKt.to("zengzhi_moduleid", "em_qqlive_bottom_bar") });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.HorBottomControllerView.bindReport.1
 * JD-Core Version:    0.7.0.1
 */