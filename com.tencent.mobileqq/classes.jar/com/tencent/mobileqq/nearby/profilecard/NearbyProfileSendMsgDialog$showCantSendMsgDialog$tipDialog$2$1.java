package com.tencent.mobileqq.nearby.profilecard;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Lorg/json/JSONObject;", "invoke"}, k=3, mv={1, 1, 16})
final class NearbyProfileSendMsgDialog$showCantSendMsgDialog$tipDialog$2$1
  extends Lambda
  implements Function1<JSONObject, Unit>
{
  NearbyProfileSendMsgDialog$showCantSendMsgDialog$tipDialog$2$1(NearbyProfileSendMsgDialog.showCantSendMsgDialog.tipDialog.2 param2)
  {
    super(1);
  }
  
  public final void invoke(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "$receiver");
    paramJSONObject.put("module", "limitpop_cancal_button");
    paramJSONObject.put("action", "click");
    paramJSONObject.put("timelong", String.valueOf((System.currentTimeMillis() - NearbyProfileSendMsgDialog.d(this.this$0.a)) / 1000));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileSendMsgDialog.showCantSendMsgDialog.tipDialog.2.1
 * JD-Core Version:    0.7.0.1
 */