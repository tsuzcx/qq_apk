package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import android.app.Activity;
import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.viola.core.ViolaInstance;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/AbsBridgeInvokeHandler;", "", "bridgeModule", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;", "(Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;)V", "getBridgeModule", "()Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;", "funcMap", "Landroid/support/v4/util/ArrayMap;", "", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "", "getActivity", "Landroid/app/Activity;", "getFragment", "Landroidx/fragment/app/Fragment;", "invokeCallJS", "callback", "data", "invokeErrorCallJS", "errorText", "invokeJS", "invokeNsHandler", "", "method", "param", "mineSpace", "ns", "nameSpace", "register", "registerFunc", "func", "violaInstance", "Lcom/tencent/viola/core/ViolaInstance;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract class AbsBridgeInvokeHandler
{
  private final ArrayMap<String, Function2<JSONObject, String, Unit>> a;
  @NotNull
  private final BridgeModule b;
  
  public AbsBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    this.b = paramBridgeModule;
    this.a = new ArrayMap();
    a();
  }
  
  public abstract void a();
  
  public final void a(@Nullable String paramString, @Nullable Object paramObject)
  {
    this.b.invokeCallJS(paramString, paramObject);
  }
  
  public final void a(@Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString2, "errorText");
    this.b.invokeErrorCallJS(paramString1, paramString2);
  }
  
  public final void a(@NotNull String paramString, @NotNull Function2<? super JSONObject, ? super String, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "method");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "func");
    ((Map)this.a).put(paramString, paramFunction2);
  }
  
  public final void a(@Nullable String paramString, @Nullable JSONObject paramJSONObject)
  {
    this.b.invokeJS(paramString, paramJSONObject);
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "ns");
    return b().equals(paramString);
  }
  
  public final boolean a(@NotNull String paramString1, @Nullable JSONObject paramJSONObject, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "method");
    paramString1 = (Function2)this.a.get(paramString1);
    if (paramString1 != null)
    {
      paramString1.invoke(paramJSONObject, paramString2);
      return true;
    }
    return false;
  }
  
  @NotNull
  public abstract String b();
  
  @Nullable
  public final Activity c()
  {
    ViolaInstance localViolaInstance = this.b.getViolaInstance();
    if (localViolaInstance != null) {
      return localViolaInstance.getActivity();
    }
    return null;
  }
  
  @NotNull
  public final BridgeModule d()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.AbsBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */