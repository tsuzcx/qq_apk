package com.tencent.qqmini.sdk.core.generated;

import com.tencent.qqmini.minigame.plugins.BlockAdPlugin;
import com.tencent.qqmini.minigame.plugins.CustomButtonPlugin;
import com.tencent.qqmini.minigame.plugins.GameDataJsPlugin;
import com.tencent.qqmini.minigame.plugins.GameFileJsPlugin;
import com.tencent.qqmini.minigame.plugins.GameSystemInfoPlugin;
import com.tencent.qqmini.minigame.plugins.ImmersiveJsPlugin;
import com.tencent.qqmini.minigame.plugins.OpenDataJsPlugin;
import com.tencent.qqmini.minigame.plugins.OrientationJsPlugin;
import com.tencent.qqmini.minigame.plugins.ProfileJsPlugin;
import com.tencent.qqmini.minigame.plugins.SubpackageJsPlugin;
import com.tencent.qqmini.minigame.plugins.UDPJsPlugin;
import com.tencent.qqmini.minigame.plugins.UpdateManagerJsPlugin;
import com.tencent.qqmini.minigame.plugins.VideoJsPlugin;
import com.tencent.qqmini.minigame.plugins.WebAudioPlugin;
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
    PRELOAD_PLUGINS.add(OrientationJsPlugin.class);
    EVENT_HANDLERS.put("getSystemInfo", GameSystemInfoPlugin.class);
    EVENT_HANDLERS.put("getSystemInfoSync", GameSystemInfoPlugin.class);
    EVENT_HANDLERS.put("createUDPTask", UDPJsPlugin.class);
    EVENT_HANDLERS.put("operateUDPTask", UDPJsPlugin.class);
    EVENT_HANDLERS.put("downloadWithCache", GameFileJsPlugin.class);
    EVENT_HANDLERS.put("createBlockAd", BlockAdPlugin.class);
    EVENT_HANDLERS.put("operateBlockAd", BlockAdPlugin.class);
    EVENT_HANDLERS.put("updateBlockAdSize", BlockAdPlugin.class);
    EVENT_HANDLERS.put("onMessage", OpenDataJsPlugin.class);
    EVENT_HANDLERS.put("getOpenDataContext", OpenDataJsPlugin.class);
    EVENT_HANDLERS.put("getPotentialFriendList", OpenDataJsPlugin.class);
    EVENT_HANDLERS.put("getUserInteractiveStorage", OpenDataJsPlugin.class);
    EVENT_HANDLERS.put("modifyFriendInteractiveStorage", OpenDataJsPlugin.class);
    EVENT_HANDLERS.put("setStatusBarStyle", ImmersiveJsPlugin.class);
    EVENT_HANDLERS.put("setMenuStyle", ImmersiveJsPlugin.class);
    EVENT_HANDLERS.put("getUpdateManager", UpdateManagerJsPlugin.class);
    EVENT_HANDLERS.put("onUpdateCheckResult", UpdateManagerJsPlugin.class);
    EVENT_HANDLERS.put("onUpdateDownloadResult", UpdateManagerJsPlugin.class);
    EVENT_HANDLERS.put("updateApp", UpdateManagerJsPlugin.class);
    EVENT_HANDLERS.put("timePerformanceResult", ProfileJsPlugin.class);
    EVENT_HANDLERS.put("createWebAudioContext", WebAudioPlugin.class);
    EVENT_HANDLERS.put("closeWebAudioContext", WebAudioPlugin.class);
    EVENT_HANDLERS.put("operateWebAudioContext", WebAudioPlugin.class);
    EVENT_HANDLERS.put("createWebAudioContextBuffer", WebAudioPlugin.class);
    EVENT_HANDLERS.put("createWebAudioBufferSource", WebAudioPlugin.class);
    EVENT_HANDLERS.put("setWebAudioSourceBuffer", WebAudioPlugin.class);
    EVENT_HANDLERS.put("sourceStart", WebAudioPlugin.class);
    EVENT_HANDLERS.put("sourceStop", WebAudioPlugin.class);
    EVENT_HANDLERS.put("getWebAudioDestination", WebAudioPlugin.class);
    EVENT_HANDLERS.put("createWebAudioGain", WebAudioPlugin.class);
    EVENT_HANDLERS.put("getWebAudioCurrentGain", WebAudioPlugin.class);
    EVENT_HANDLERS.put("setWebAudioBufferSourceLoop", WebAudioPlugin.class);
    EVENT_HANDLERS.put("getWebAudioCurrentTime", WebAudioPlugin.class);
    EVENT_HANDLERS.put("setWebAudioCurrentGain", WebAudioPlugin.class);
    EVENT_HANDLERS.put("getWebAudioBufferChannelData", WebAudioPlugin.class);
    EVENT_HANDLERS.put("decodeWebAudioData", WebAudioPlugin.class);
    EVENT_HANDLERS.put("audioBufferCopyFromChannel", WebAudioPlugin.class);
    EVENT_HANDLERS.put("audioBufferCopyToChannel", WebAudioPlugin.class);
    EVENT_HANDLERS.put("createWebAudioScriptProcessor", WebAudioPlugin.class);
    EVENT_HANDLERS.put("audioProcessingEventSetQueueBuffer", WebAudioPlugin.class);
    EVENT_HANDLERS.put("webAudioConnectAudioNode", WebAudioPlugin.class);
    EVENT_HANDLERS.put("insertVideoPlayer", VideoJsPlugin.class);
    EVENT_HANDLERS.put("updateVideoPlayer", VideoJsPlugin.class);
    EVENT_HANDLERS.put("operateVideoPlayer", VideoJsPlugin.class);
    EVENT_HANDLERS.put("removeVideoPlayer", VideoJsPlugin.class);
    EVENT_HANDLERS.put("operateCustomButton", CustomButtonPlugin.class);
    EVENT_HANDLERS.put("createLoadSubPackageTask", SubpackageJsPlugin.class);
    EVENT_HANDLERS.put("getLaunchOptionsSync", GameDataJsPlugin.class);
    EVENT_HANDLERS.put("recordOffLineResourceState", GameDataJsPlugin.class);
    EVENT_HANDLERS.put("navigateToMiniProgramConfig", GameDataJsPlugin.class);
    EVENT_HANDLERS.put("getOpenDataUserInfo", GameDataJsPlugin.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.GameJsPluginScope
 * JD-Core Version:    0.7.0.1
 */