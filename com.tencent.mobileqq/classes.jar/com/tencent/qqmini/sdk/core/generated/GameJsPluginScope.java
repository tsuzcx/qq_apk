package com.tencent.qqmini.sdk.core.generated;

import com.tencent.qqmini.minigame.plugins.BlockAdPlugin;
import com.tencent.qqmini.minigame.plugins.CustomButtonPlugin;
import com.tencent.qqmini.minigame.plugins.GameDataJsPlugin;
import com.tencent.qqmini.minigame.plugins.GameFileJsPlugin;
import com.tencent.qqmini.minigame.plugins.GameSystemInfoPlugin;
import com.tencent.qqmini.minigame.plugins.ImmersiveJsPlugin;
import com.tencent.qqmini.minigame.plugins.LifecycleJsPlugin;
import com.tencent.qqmini.minigame.plugins.MemoryJsPlugin;
import com.tencent.qqmini.minigame.plugins.OrientationJsPlugin;
import com.tencent.qqmini.minigame.plugins.ProfileJsPlugin;
import com.tencent.qqmini.minigame.plugins.UpdateManagerJsPlugin;
import com.tencent.qqmini.minigame.plugins.VideoJsPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GameJsPluginScope
{
  public static final Map EVENT_HANDLERS;
  public static final List PRELOAD_PLUGINS = new ArrayList();
  
  static
  {
    EVENT_HANDLERS = new HashMap();
    PRELOAD_PLUGINS.add(LifecycleJsPlugin.class);
    PRELOAD_PLUGINS.add(ProfileJsPlugin.class);
    PRELOAD_PLUGINS.add(OrientationJsPlugin.class);
    PRELOAD_PLUGINS.add(UpdateManagerJsPlugin.class);
    EVENT_HANDLERS.put("registerProfile", ProfileJsPlugin.class);
    EVENT_HANDLERS.put("timePerformanceResult", ProfileJsPlugin.class);
    EVENT_HANDLERS.put("getSystemInfo", GameSystemInfoPlugin.class);
    EVENT_HANDLERS.put("getSystemInfoSync", GameSystemInfoPlugin.class);
    EVENT_HANDLERS.put("downloadWithCache", GameFileJsPlugin.class);
    EVENT_HANDLERS.put("createBlockAd", BlockAdPlugin.class);
    EVENT_HANDLERS.put("operateBlockAd", BlockAdPlugin.class);
    EVENT_HANDLERS.put("updateBlockAdSize", BlockAdPlugin.class);
    EVENT_HANDLERS.put("setStatusBarStyle", ImmersiveJsPlugin.class);
    EVENT_HANDLERS.put("setMenuStyle", ImmersiveJsPlugin.class);
    EVENT_HANDLERS.put("operateCustomButton", CustomButtonPlugin.class);
    EVENT_HANDLERS.put("insertVideoPlayer", VideoJsPlugin.class);
    EVENT_HANDLERS.put("updateVideoPlayer", VideoJsPlugin.class);
    EVENT_HANDLERS.put("operateVideoPlayer", VideoJsPlugin.class);
    EVENT_HANDLERS.put("removeVideoPlayer", VideoJsPlugin.class);
    EVENT_HANDLERS.put("onMemoryWarning", MemoryJsPlugin.class);
    EVENT_HANDLERS.put("getLaunchOptionsSync", GameDataJsPlugin.class);
    EVENT_HANDLERS.put("recordOffLineResourceState", GameDataJsPlugin.class);
    EVENT_HANDLERS.put("navigateToMiniProgramConfig", GameDataJsPlugin.class);
    EVENT_HANDLERS.put("getOpenDataUserInfo", GameDataJsPlugin.class);
    EVENT_HANDLERS.put("getUpdateManager", UpdateManagerJsPlugin.class);
    EVENT_HANDLERS.put("onUpdateCheckResult", UpdateManagerJsPlugin.class);
    EVENT_HANDLERS.put("onUpdateDownloadResult", UpdateManagerJsPlugin.class);
    EVENT_HANDLERS.put("updateApp", UpdateManagerJsPlugin.class);
    EVENT_HANDLERS.put("onAppEnterForeground", LifecycleJsPlugin.class);
    EVENT_HANDLERS.put("onAppEnterBackground", LifecycleJsPlugin.class);
    EVENT_HANDLERS.put("onAppStop", LifecycleJsPlugin.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.GameJsPluginScope
 * JD-Core Version:    0.7.0.1
 */