package com.tencent.timi.game.component.chat.input;

import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.timi.game.expand.hall.api.HallReportHelper;
import com.tencent.timi.game.room.api.wrapper.IRoomAudioService;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "", "", "it", "kotlin.jvm.PlatformType", "getDynamicParams", "com/tencent/timi/game/component/chat/input/ExpandHallInputBoxView$bindMicSpeakerReport$2$1"}, k=3, mv={1, 1, 16})
final class ExpandHallInputBoxView$bindMicSpeakerReport$$inlined$apply$lambda$2
  implements IDynamicParams
{
  ExpandHallInputBoxView$bindMicSpeakerReport$$inlined$apply$lambda$2(ExpandHallInputBoxView paramExpandHallInputBoxView, HallReportHelper paramHallReportHelper) {}
  
  @NotNull
  public final Map<String, Object> getDynamicParams(String paramString)
  {
    Pair localPair1 = TuplesKt.to("yes_room_id", String.valueOf(ExpandHallInputBoxView.f(this.a)));
    Pair localPair2 = TuplesKt.to("yes_room_type", Integer.valueOf(5));
    paramString = this.a;
    if (ExpandHallInputBoxView.a(paramString, ExpandHallInputBoxView.f(paramString)).b()) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    paramString = MapsKt.mutableMapOf(new Pair[] { localPair1, localPair2, TuplesKt.to("yes_voice_status", paramString) });
    paramString.putAll(this.b.t());
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.ExpandHallInputBoxView.bindMicSpeakerReport..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */