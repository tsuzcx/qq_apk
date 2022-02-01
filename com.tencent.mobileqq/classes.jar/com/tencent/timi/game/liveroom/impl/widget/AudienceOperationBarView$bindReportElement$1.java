package com.tencent.timi.game.liveroom.impl.widget;

import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionReportHelper;
import com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionReportHelper.Companion;
import com.tencent.timi.game.liveroom.impl.observable.FollowStatusWrapper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "", "", "it", "kotlin.jvm.PlatformType", "getDynamicParams"}, k=3, mv={1, 1, 16})
final class AudienceOperationBarView$bindReportElement$1
  implements IDynamicParams
{
  AudienceOperationBarView$bindReportElement$1(AudienceOperationBarView paramAudienceOperationBarView, long paramLong) {}
  
  @NotNull
  public final Map<String, Object> getDynamicParams(String paramString)
  {
    Pair localPair = TuplesKt.to("qqlive_equip_status", LivingInscriptionReportHelper.a.a().a(this.b));
    paramString = AudienceOperationBarView.a(this.a);
    if ((paramString != null) && (paramString.a() == true)) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    return MapsKt.mutableMapOf(new Pair[] { localPair, TuplesKt.to("qqlive_follow_status", paramString), TuplesKt.to("zengzhi_moduleid", "em_qqlive_bottom_bar") });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AudienceOperationBarView.bindReportElement.1
 * JD-Core Version:    0.7.0.1
 */