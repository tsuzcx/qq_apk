package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "param", "Lorg/json/JSONObject;", "<anonymous parameter 1>", "", "invoke"}, k=3, mv={1, 1, 16})
final class GDTBridgeInvokeHandler$register$2
  extends Lambda
  implements Function2<JSONObject, String, Unit>
{
  GDTBridgeInvokeHandler$register$2(GDTBridgeInvokeHandler paramGDTBridgeInvokeHandler)
  {
    super(2);
  }
  
  public final void invoke(@Nullable JSONObject paramJSONObject, @Nullable String paramString)
  {
    this.this$0.d().handleClick(paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.GDTBridgeInvokeHandler.register.2
 * JD-Core Version:    0.7.0.1
 */