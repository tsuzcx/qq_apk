package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.data.NearbyPeopleCard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lorg/json/JSONObject;", "invoke"}, k=3, mv={1, 1, 16})
final class NearbyProfileReportKt$reportProfile$1
  extends Lambda
  implements Function1<JSONObject, Unit>
{
  NearbyProfileReportKt$reportProfile$1(NearbyPeopleCard paramNearbyPeopleCard, Function1 paramFunction1)
  {
    super(1);
  }
  
  public final void invoke(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "$receiver");
    paramJSONObject.put("d2", String.valueOf(this.$card.gender));
    paramJSONObject.put("d3", String.valueOf(this.$card.age));
    paramJSONObject.put("touin", String.valueOf(this.$card.tinyId));
    Function1 localFunction1 = this.$func;
    if (localFunction1 != null) {
      paramJSONObject = (Unit)localFunction1.invoke(paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileReportKt.reportProfile.1
 * JD-Core Version:    0.7.0.1
 */