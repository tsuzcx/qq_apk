package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "content", "", "type", "", "invoke", "com/tencent/mobileqq/kandian/glue/viola/modules/bridge/UIBridgeInvokeHandler$arouseTkdBarragePublisher$1$dialog$1$1", "com/tencent/mobileqq/kandian/glue/viola/modules/bridge/UIBridgeInvokeHandler$$special$$inlined$apply$lambda$1"}, k=3, mv={1, 1, 16})
final class UIBridgeInvokeHandler$arouseTkdBarragePublisher$$inlined$let$lambda$1
  extends Lambda
  implements Function2<String, Integer, Unit>
{
  UIBridgeInvokeHandler$arouseTkdBarragePublisher$$inlined$let$lambda$1(int paramInt, String paramString1, String paramString2, UIBridgeInvokeHandler paramUIBridgeInvokeHandler, JSONObject paramJSONObject, String paramString3)
  {
    super(2);
  }
  
  public final void invoke(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "content");
    JSONObject localJSONObject = this.$params$inlined;
    if (localJSONObject != null) {
      localJSONObject.put("text", paramString);
    }
    localJSONObject = this.$params$inlined;
    if (localJSONObject != null)
    {
      if (paramInt == 2) {
        paramString = "2";
      } else {
        paramString = "1";
      }
      localJSONObject.put("type", paramString);
    }
    this.this$0.a(this.$callbackId$inlined, this.$params$inlined);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.UIBridgeInvokeHandler.arouseTkdBarragePublisher..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */