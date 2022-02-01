package com.tencent.timi.game.liveroom.impl.widget;

import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "", "", "it", "kotlin.jvm.PlatformType", "getDynamicParams", "com/tencent/timi/game/liveroom/impl/widget/AudienceInputBoxView$bindReport$1$1"}, k=3, mv={1, 1, 16})
final class AudienceInputBoxView$bindReport$$inlined$apply$lambda$1
  implements IDynamicParams
{
  AudienceInputBoxView$bindReport$$inlined$apply$lambda$1(AudienceInputBoxView paramAudienceInputBoxView) {}
  
  @NotNull
  public final Map<String, Object> getDynamicParams(String paramString)
  {
    boolean bool = this.a.f();
    String str = "1";
    if (bool) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    Pair localPair = TuplesKt.to("qqlive_is_at", paramString);
    if (this.a.g()) {
      paramString = str;
    } else {
      paramString = "0";
    }
    return MapsKt.mutableMapOf(new Pair[] { localPair, TuplesKt.to("qqlive_is_with_sticker", paramString), TuplesKt.to("qqlive_text_content", this.a.getContent()), TuplesKt.to("zengzhi_moduleid", "em_qqlive_inputbar") });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AudienceInputBoxView.bindReport..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */