package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "param", "Lorg/json/JSONObject;", "callback", "", "invoke"}, k=3, mv={1, 1, 16})
final class AppBridgeInvokeHandler$register$4
  extends Lambda
  implements Function2<JSONObject, String, Unit>
{
  AppBridgeInvokeHandler$register$4(AppBridgeInvokeHandler paramAppBridgeInvokeHandler)
  {
    super(2);
  }
  
  public final void invoke(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    BridgeModule localBridgeModule = this.this$0.d();
    String str2 = null;
    String str1;
    if (paramJSONObject != null) {
      str1 = paramJSONObject.optString("schema");
    } else {
      str1 = null;
    }
    if (paramJSONObject != null) {
      str2 = paramJSONObject.optString("sourceId");
    }
    localBridgeModule.openApp(str1, paramString, str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.AppBridgeInvokeHandler.register.4
 * JD-Core Version:    0.7.0.1
 */