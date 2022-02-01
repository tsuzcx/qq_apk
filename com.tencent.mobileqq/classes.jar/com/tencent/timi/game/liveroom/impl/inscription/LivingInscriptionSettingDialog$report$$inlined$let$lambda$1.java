package com.tencent.timi.game.liveroom.impl.inscription;

import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "", "", "it", "kotlin.jvm.PlatformType", "getDynamicParams", "com/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionSettingDialog$report$3$1"}, k=3, mv={1, 1, 16})
final class LivingInscriptionSettingDialog$report$$inlined$let$lambda$1
  implements IDynamicParams
{
  LivingInscriptionSettingDialog$report$$inlined$let$lambda$1(LivingInscriptionSettingDialog paramLivingInscriptionSettingDialog) {}
  
  @NotNull
  public final Map<String, Object> getDynamicParams(String paramString)
  {
    Pair localPair = TuplesKt.to("zengzhi_moduleid", "em_qqlive_equipshow_entrance");
    if (LivingInscriptionSettingDialog.a(this.a)) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    return MapsKt.mutableMapOf(new Pair[] { localPair, TuplesKt.to("qqlive_equip_status", paramString) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionSettingDialog.report..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */