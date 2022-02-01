package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/SchemaBridgeInvokeHandler;", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;", "(Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;)V", "jumpAction", "", "params", "Lorg/json/JSONObject;", "callBackId", "", "nameSpace", "register", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SchemaBridgeInvokeHandler
  extends AbsBridgeInvokeHandler
{
  public static final SchemaBridgeInvokeHandler.Companion a = new SchemaBridgeInvokeHandler.Companion(null);
  
  public SchemaBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  private final void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null)
    {
      a(paramString, "params is null");
      return;
    }
    if (!paramJSONObject.has("schema"))
    {
      a(paramString, "schema is null");
      return;
    }
    Activity localActivity = a();
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    Object localObject = localAppRuntime;
    if (!(localAppRuntime instanceof QQAppInterface)) {
      localObject = null;
    }
    localObject = (QQAppInterface)localObject;
    if ((localActivity != null) && (localObject != null)) {
      try
      {
        paramJSONObject = paramJSONObject.getString("schema");
        paramJSONObject = JumpParser.a((BaseQQAppInterface)localObject, (Context)localActivity, paramJSONObject);
        if (paramJSONObject == null) {
          return;
        }
        paramJSONObject.b("viola");
        paramJSONObject.a();
        a(paramString, null);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
    } else {
      a(paramString, "activity or app is null");
    }
  }
  
  @NotNull
  public String a()
  {
    return "schema";
  }
  
  public void a()
  {
    a("jumpAction", (Function2)new SchemaBridgeInvokeHandler.register.1((SchemaBridgeInvokeHandler)this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.SchemaBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */