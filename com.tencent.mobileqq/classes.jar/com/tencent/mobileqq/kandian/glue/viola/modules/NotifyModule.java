package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.Destroyable;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.module.BaseModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/modules/NotifyModule;", "Lcom/tencent/viola/module/BaseModule;", "Lcom/tencent/viola/commons/Destroyable;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/kandian/glue/viola/event/ViolaEvent;", "()V", "toViolaEventMap", "", "", "addNotify", "", "eventName", "callback", "destroy", "getEventClass", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "invokeJS", "result", "Lorg/json/JSONObject;", "onReceiveEvent", "event", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "postNotify", "data", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class NotifyModule
  extends BaseModule
  implements SimpleEventReceiver<ViolaEvent>, Destroyable
{
  public static final NotifyModule.Companion Companion = new NotifyModule.Companion(null);
  @NotNull
  public static final String MODULE_NAME = "notify";
  private final Map<String, String> toViolaEventMap = (Map)new HashMap();
  
  public NotifyModule()
  {
    SimpleEventBus.getInstance().registerReceiver((SimpleEventReceiver)this);
  }
  
  private final void invokeJS(String paramString, JSONObject paramJSONObject)
  {
    if (getViolaInstance() != null)
    {
      ViolaBridgeManager localViolaBridgeManager = ViolaBridgeManager.getInstance();
      ViolaInstance localViolaInstance = getViolaInstance();
      Intrinsics.checkExpressionValueIsNotNull(localViolaInstance, "violaInstance");
      localViolaBridgeManager.callbackJavascript(localViolaInstance.getInstanceId(), "notify", "callback", paramString, paramJSONObject, true);
    }
  }
  
  @JSMethod
  public final void addNotify(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString1))
    {
      if (TextUtils.isEmpty((CharSequence)paramString2)) {
        return;
      }
      this.toViolaEventMap.put(paramString1, paramString2);
    }
  }
  
  public void destroy()
  {
    this.toViolaEventMap.clear();
    SimpleEventBus.getInstance().unRegisterReceiver((SimpleEventReceiver)this);
  }
  
  @NotNull
  public ArrayList<Class<ViolaEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ViolaEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(@Nullable SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof ViolaEvent))
    {
      Object localObject = this.toViolaEventMap;
      paramSimpleBaseEvent = (ViolaEvent)paramSimpleBaseEvent;
      localObject = (String)((Map)localObject).get(paramSimpleBaseEvent.eventName);
      if (localObject != null) {
        invokeJS((String)localObject, paramSimpleBaseEvent.data);
      }
    }
  }
  
  @JSMethod
  public final void postNotify(@Nullable String paramString, @Nullable JSONObject paramJSONObject)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return;
    }
    String str = (String)this.toViolaEventMap.get(paramString);
    if (str != null) {
      invokeJS(str, paramJSONObject);
    }
    SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)new ViolaEvent(paramString, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.NotifyModule
 * JD-Core Version:    0.7.0.1
 */