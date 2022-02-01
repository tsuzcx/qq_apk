package com.tencent.mobileqq.nearby.profilecard;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lorg/json/JSONObject;", "invoke"}, k=3, mv={1, 1, 16})
final class NearbyProfileReportKt$reportSendMsgDialogButtonClick$1
  extends Lambda
  implements Function1<JSONObject, Unit>
{
  NearbyProfileReportKt$reportSendMsgDialogButtonClick$1(String paramString)
  {
    super(1);
  }
  
  public final void invoke(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "$receiver");
    paramJSONObject.put("d6", this.$content);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileReportKt.reportSendMsgDialogButtonClick.1
 * JD-Core Version:    0.7.0.1
 */