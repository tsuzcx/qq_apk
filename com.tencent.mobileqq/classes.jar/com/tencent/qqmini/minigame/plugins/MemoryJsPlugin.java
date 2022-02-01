package com.tencent.qqmini.minigame.plugins;

import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsPlugin
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/plugins/MemoryJsPlugin;", "Lcom/tencent/qqmini/sdk/launcher/core/plugins/BaseJsPlugin;", "()V", "componentCallbacks", "Landroid/content/ComponentCallbacks2;", "hasRegisterComponent", "", "onDestroy", "", "onMemoryWarning", "", "req", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "registerComponentCallback", "Companion", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class MemoryJsPlugin
  extends BaseJsPlugin
{
  public static final MemoryJsPlugin.Companion Companion = new MemoryJsPlugin.Companion(null);
  private static final String TAG = "MemoryJsPlugin";
  private ComponentCallbacks2 componentCallbacks;
  private boolean hasRegisterComponent;
  
  private final void registerComponentCallback(RequestEvent paramRequestEvent)
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    try
    {
      this.componentCallbacks = ((ComponentCallbacks2)new MemoryJsPlugin.registerComponentCallback.1(this, paramRequestEvent));
      paramRequestEvent = this.mContext;
      Intrinsics.checkExpressionValueIsNotNull(paramRequestEvent, "mContext");
      paramRequestEvent.getApplicationContext().registerComponentCallbacks((ComponentCallbacks)this.componentCallbacks);
      return;
    }
    catch (Exception paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.hasRegisterComponent) && (this.componentCallbacks != null))
    {
      Context localContext = this.mContext;
      Intrinsics.checkExpressionValueIsNotNull(localContext, "mContext");
      localContext.getApplicationContext().unregisterComponentCallbacks((ComponentCallbacks)this.componentCallbacks);
    }
  }
  
  @JsEvent({"onMemoryWarning"})
  @Nullable
  public final String onMemoryWarning(@NotNull RequestEvent paramRequestEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramRequestEvent, "req");
    if (!this.hasRegisterComponent)
    {
      registerComponentCallback(paramRequestEvent);
      this.hasRegisterComponent = true;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.MemoryJsPlugin
 * JD-Core Version:    0.7.0.1
 */