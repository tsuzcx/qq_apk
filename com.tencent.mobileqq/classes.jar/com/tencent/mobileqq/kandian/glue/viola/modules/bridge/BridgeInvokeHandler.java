package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/BridgeInvokeHandler;", "", "bridgeModule", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;", "(Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;)V", "nsHandlerList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/AbsBridgeInvokeHandler;", "Lkotlin/collections/ArrayList;", "invoke", "", "ns", "", "method", "jsonObject", "Lorg/json/JSONObject;", "callback", "nonStandardFormat", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BridgeInvokeHandler
{
  private final ArrayList<AbsBridgeInvokeHandler> a = new ArrayList(16);
  
  public BridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    ArrayList localArrayList = this.a;
    localArrayList.add(new RIJBridgeInvokeHandler(paramBridgeModule));
    localArrayList.add(new DataBridgeInvokeHandler(paramBridgeModule));
    localArrayList.add(new UIBridgeInvokeHandler(paramBridgeModule));
    localArrayList.add(new AppBridgeInvokeHandler(paramBridgeModule));
    localArrayList.add(new DeviceBridgeInvokeHandler(paramBridgeModule));
    localArrayList.add(new DebugBridgeInvokeHandler(paramBridgeModule));
    localArrayList.add(new MediaBridgeInvokeHandler(paramBridgeModule));
    localArrayList.add(new OfflineBridgeInvokeHandler(paramBridgeModule));
    localArrayList.add(new EventBridgeInvokeHandler(paramBridgeModule));
    localArrayList.add(new SchemaBridgeInvokeHandler(paramBridgeModule));
    localArrayList.add(new GDTBridgeInvokeHandler(paramBridgeModule));
    localArrayList.add(new NowLiveBridgeInvokeHandler(paramBridgeModule));
    localArrayList.add(new PublicAccountNewBridgeInvokeHandler(paramBridgeModule));
    localArrayList.add(new FriendBridgeInvokeHandler(paramBridgeModule));
    localArrayList.add(new SensorBridgeInvokeHandler(paramBridgeModule));
  }
  
  private final boolean a(String paramString1, String paramString2)
  {
    return (("downloadApp".equals(paramString2)) && ("app".equals(paramString1))) || (("openRoom".equals(paramString2)) && ("nowlive".equals(paramString1)));
  }
  
  public final boolean a(@NotNull String paramString1, @NotNull String paramString2, @NotNull JSONObject paramJSONObject, @Nullable String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "ns");
    Intrinsics.checkParameterIsNotNull(paramString2, "method");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "jsonObject");
    if (!a(paramString1, paramString2)) {
      paramJSONObject = paramJSONObject.optJSONObject("params");
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      AbsBridgeInvokeHandler localAbsBridgeInvokeHandler = (AbsBridgeInvokeHandler)localIterator.next();
      if (localAbsBridgeInvokeHandler.a(paramString1)) {
        return localAbsBridgeInvokeHandler.a(paramString2, paramJSONObject, paramString3);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.BridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */