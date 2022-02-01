package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import bhlo;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.GameLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/minigame/jsapi/plugins/MemoryPlugin$handleNativeRequest$1", "Landroid/content/ComponentCallbacks2;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "onTrimMemory", "level", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class MemoryPlugin$handleNativeRequest$1
  implements ComponentCallbacks2
{
  MemoryPlugin$handleNativeRequest$1(JsRuntime paramJsRuntime) {}
  
  public void onConfigurationChanged(@NotNull Configuration paramConfiguration)
  {
    Intrinsics.checkParameterIsNotNull(paramConfiguration, "newConfig");
  }
  
  public void onLowMemory()
  {
    Object localObject2 = null;
    Debug.MemoryInfo localMemoryInfo = bhlo.a(Process.myPid());
    GameLog localGameLog = GameLog.getInstance();
    StringBuilder localStringBuilder = new StringBuilder().append("onLowMemory!!!!!! ").append("Meminfo:dalvikPss[");
    if (localMemoryInfo != null)
    {
      localObject1 = Integer.valueOf(localMemoryInfo.dalvikPss);
      localStringBuilder = localStringBuilder.append(localObject1).append("], ").append("nativePss[");
      if (localMemoryInfo == null) {
        break label172;
      }
      localObject1 = Integer.valueOf(localMemoryInfo.nativePss);
      label79:
      localStringBuilder = localStringBuilder.append(localObject1).append("], ").append("otherPss[");
      if (localMemoryInfo == null) {
        break label177;
      }
    }
    label172:
    label177:
    for (Object localObject1 = Integer.valueOf(localMemoryInfo.otherPss);; localObject1 = null)
    {
      localStringBuilder = localStringBuilder.append(localObject1).append("], ").append("total[");
      localObject1 = localObject2;
      if (localMemoryInfo != null) {
        localObject1 = Integer.valueOf(localMemoryInfo.getTotalPss());
      }
      localGameLog.e("MemoryPlugin", localObject1 + ']');
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label79;
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("level", paramInt);
    JsRuntime localJsRuntime = this.$runtime;
    if (localJsRuntime != null) {
      localJsRuntime.evaluateSubcribeJS("onMemoryWarning", localJSONObject.toString(), -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.MemoryPlugin.handleNativeRequest.1
 * JD-Core Version:    0.7.0.1
 */