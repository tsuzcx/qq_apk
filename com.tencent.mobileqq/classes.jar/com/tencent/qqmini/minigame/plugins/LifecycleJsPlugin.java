package com.tencent.qqmini.minigame.plugins;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.RuntimeStateObserver;
import com.tencent.qqmini.sdk.runtime.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsPlugin(lazyLoad=false)
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/plugins/LifecycleJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "()V", "lifeCycleMap", "Ljava/util/HashMap;", "", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "Lkotlin/collections/HashMap;", "observer", "Lcom/tencent/qqmini/sdk/runtime/AppRuntimeEventCenter$RuntimeStateObserver;", "bindBackgroundListener", "req", "bindForegroundListener", "bindFun", "bindStopListener", "onCreate", "", "miniAppContext", "Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;", "onDestroy", "Companion", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class LifecycleJsPlugin
  extends BaseJsPlugin
{
  public static final LifecycleJsPlugin.Companion Companion = new LifecycleJsPlugin.Companion(null);
  private static final String TAG = "LifecycleJsPlugin";
  private final HashMap<String, RequestEvent> lifeCycleMap = new HashMap();
  private AppRuntimeEventCenter.RuntimeStateObserver observer;
  
  private final String bindFun(RequestEvent paramRequestEvent)
  {
    if (!this.lifeCycleMap.containsKey(paramRequestEvent.event))
    {
      Map localMap = (Map)this.lifeCycleMap;
      String str = paramRequestEvent.event;
      Intrinsics.checkExpressionValueIsNotNull(str, "req.event");
      localMap.put(str, paramRequestEvent);
    }
    return null;
  }
  
  @JsEvent({"onAppEnterBackground"})
  @Nullable
  public final String bindBackgroundListener(@NotNull RequestEvent paramRequestEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramRequestEvent, "req");
    return bindFun(paramRequestEvent);
  }
  
  @JsEvent({"onAppEnterForeground"})
  @Nullable
  public final String bindForegroundListener(@NotNull RequestEvent paramRequestEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramRequestEvent, "req");
    return bindFun(paramRequestEvent);
  }
  
  @JsEvent({"onAppStop"})
  @Nullable
  public final String bindStopListener(@NotNull RequestEvent paramRequestEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramRequestEvent, "req");
    return bindFun(paramRequestEvent);
  }
  
  public void onCreate(@Nullable IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    BaseRuntimeLoader localBaseRuntimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(this.mMiniAppInfo);
    if (localBaseRuntimeLoader != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localBaseRuntimeLoader, "AppRuntimeLoaderManager.…r(mMiniAppInfo) ?: return");
      this.observer = ((AppRuntimeEventCenter.RuntimeStateObserver)new LifecycleJsPlugin.onCreate.1(this, paramIMiniAppContext));
      localBaseRuntimeLoader.addRuntimeStateObserver(this.observer);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    BaseRuntimeLoader localBaseRuntimeLoader = AppRuntimeLoaderManager.g().queryAppRunTimeLoader(this.mMiniAppInfo);
    if ((this.observer != null) && (localBaseRuntimeLoader != null)) {
      localBaseRuntimeLoader.removeRuntimeStateObserver(this.observer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.LifecycleJsPlugin
 * JD-Core Version:    0.7.0.1
 */