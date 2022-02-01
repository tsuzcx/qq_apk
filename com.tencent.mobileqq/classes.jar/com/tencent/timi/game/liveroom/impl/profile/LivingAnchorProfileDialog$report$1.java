package com.tencent.timi.game.liveroom.impl.profile;

import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "", "", "it", "kotlin.jvm.PlatformType", "getDynamicParams"}, k=3, mv={1, 1, 16})
final class LivingAnchorProfileDialog$report$1
  implements IDynamicParams
{
  LivingAnchorProfileDialog$report$1(LivingAnchorProfileDialog paramLivingAnchorProfileDialog) {}
  
  @NotNull
  public final Map<String, Object> getDynamicParams(String paramString)
  {
    Pair localPair1 = TuplesKt.to("zengzhi_moduleid", "em_qqlive_inf_module");
    paramString = this.a.d();
    if (paramString != null)
    {
      paramString = paramString.d();
      if (paramString != null) {}
    }
    else
    {
      paramString = "";
    }
    Pair localPair2 = TuplesKt.to("qqlive_equip_status", paramString);
    if (LivingAnchorProfileDialog.a(this.a)) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    return MapsKt.mutableMapOf(new Pair[] { localPair1, localPair2, TuplesKt.to("qqlive_follow_status", paramString) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.profile.LivingAnchorProfileDialog.report.1
 * JD-Core Version:    0.7.0.1
 */