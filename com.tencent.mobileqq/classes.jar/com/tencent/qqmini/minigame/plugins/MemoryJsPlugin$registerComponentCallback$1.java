package com.tencent.qqmini.minigame.plugins;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Debug.MemoryInfo;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/qqmini/minigame/plugins/MemoryJsPlugin$registerComponentCallback$1", "Landroid/content/ComponentCallbacks2;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "onTrimMemory", "level", "", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class MemoryJsPlugin$registerComponentCallback$1
  implements ComponentCallbacks2
{
  MemoryJsPlugin$registerComponentCallback$1(RequestEvent paramRequestEvent) {}
  
  public void onConfigurationChanged(@NotNull Configuration paramConfiguration)
  {
    Intrinsics.checkParameterIsNotNull(paramConfiguration, "newConfig");
  }
  
  public void onLowMemory()
  {
    Object localObject = MemoryJsPlugin.access$getMContext$p(this.this$0).getSystemService("activity");
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }
    localObject = ((android.app.ActivityManager)localObject).getProcessMemoryInfo(new int[] { android.os.Process.myPid() })[0];
    StringBuilder localStringBuilder = new StringBuilder().append("onLowMemory!!!!!! Meminfo:dalvikPss[").append(((Debug.MemoryInfo)localObject).dalvikPss).append("],nativePss[").append(((Debug.MemoryInfo)localObject).nativePss).append("],otherPss[").append(((Debug.MemoryInfo)localObject).otherPss).append(']').append(",total[");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mem");
    QMLog.e("MemoryJsPlugin", ((Debug.MemoryInfo)localObject).getTotalPss() + ']');
  }
  
  public void onTrimMemory(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("level", paramInt);
    this.$req.jsService.evaluateSubscribeJS("onMemoryWarning", localJSONObject.toString(), -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.MemoryJsPlugin.registerComponentCallback.1
 * JD-Core Version:    0.7.0.1
 */