package com.tencent.qqmini.sdk.core.generated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GameJsPluginScope
{
  public static final Map EVENT_HANDLERS_GameDataJsPlugin;
  public static final Map EVENT_HANDLERS_ImmersiveJsPlugin;
  public static final Map EVENT_HANDLERS_MiniGameUIJsPlugin;
  public static final Map EVENT_HANDLERS_OpenDataJsPlugin;
  public static final Map EVENT_HANDLERS_SubpackageJsPlugin;
  public static final Map EVENT_HANDLERS_UDPJsPlugin;
  public static final Map EVENT_HANDLERS_UpdateManagerJsPlugin;
  public static final Map EVENT_HANDLERS_VideoJsPlugin;
  public static final Map EVENT_HANDLERS_WebAudioPlugin;
  public static final Map PLUGIN_EVENTS;
  public static final List PRELOAD_PLUGINS = new ArrayList();
  public static final Map SECONDARY_PLUGIN_EVENTS;
  public static final Map SERVICE_INJECTORS_GameDataJsPlugin;
  public static final Map SERVICE_INJECTORS_OpenDataJsPlugin;
  
  static
  {
    PLUGIN_EVENTS = new HashMap();
    SECONDARY_PLUGIN_EVENTS = new HashMap();
    EVENT_HANDLERS_VideoJsPlugin = new HashMap();
    EVENT_HANDLERS_WebAudioPlugin = new HashMap();
    EVENT_HANDLERS_MiniGameUIJsPlugin = new HashMap();
    EVENT_HANDLERS_OpenDataJsPlugin = new HashMap();
    SERVICE_INJECTORS_OpenDataJsPlugin = new HashMap();
    EVENT_HANDLERS_GameDataJsPlugin = new HashMap();
    SERVICE_INJECTORS_GameDataJsPlugin = new HashMap();
    EVENT_HANDLERS_SubpackageJsPlugin = new HashMap();
    EVENT_HANDLERS_ImmersiveJsPlugin = new HashMap();
    EVENT_HANDLERS_UDPJsPlugin = new HashMap();
    EVENT_HANDLERS_UpdateManagerJsPlugin = new HashMap();
    PRELOAD_PLUGINS.add("com.tencent.qqmini.sdk.minigame.plugins.OrientationJsPlugin");
    EVENT_HANDLERS_VideoJsPlugin.put("insertVideoPlayer", "insertVideoPlayer");
    EVENT_HANDLERS_VideoJsPlugin.put("updateVideoPlayer", "updateVideoPlayer");
    EVENT_HANDLERS_VideoJsPlugin.put("operateVideoPlayer", "operateVideoPlayer");
    EVENT_HANDLERS_VideoJsPlugin.put("removeVideoPlayer", "removeVideoPlayer");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.minigame.plugins.VideoJsPlugin", EVENT_HANDLERS_VideoJsPlugin);
    EVENT_HANDLERS_WebAudioPlugin.put("createWebAudioContext", "createWebAudioContext");
    EVENT_HANDLERS_WebAudioPlugin.put("closeWebAudioContext", "closeWebAudioContext");
    EVENT_HANDLERS_WebAudioPlugin.put("operateWebAudioContext", "operateWebAudioContext");
    EVENT_HANDLERS_WebAudioPlugin.put("createWebAudioContextBuffer", "createWebAudioContextBuffer");
    EVENT_HANDLERS_WebAudioPlugin.put("createWebAudioBufferSource", "createWebAudioBufferSource");
    EVENT_HANDLERS_WebAudioPlugin.put("setWebAudioSourceBuffer", "setWebAudioSourceBuffer");
    EVENT_HANDLERS_WebAudioPlugin.put("sourceStart", "sourceStart");
    EVENT_HANDLERS_WebAudioPlugin.put("sourceStop", "sourceStop");
    EVENT_HANDLERS_WebAudioPlugin.put("getWebAudioDestination", "getWebAudioDestination");
    EVENT_HANDLERS_WebAudioPlugin.put("createWebAudioGain", "createWebAudioGain");
    EVENT_HANDLERS_WebAudioPlugin.put("getWebAudioCurrentGain", "getWebAudioCurrentGain");
    EVENT_HANDLERS_WebAudioPlugin.put("setWebAudioBufferSourceLoop", "setWebAudioBufferSourceLoop");
    EVENT_HANDLERS_WebAudioPlugin.put("getWebAudioCurrentTime", "getWebAudioCurrentTime");
    EVENT_HANDLERS_WebAudioPlugin.put("setWebAudioCurrentGain", "setWebAudioCurrentGain");
    EVENT_HANDLERS_WebAudioPlugin.put("getWebAudioBufferChannelData", "getWebAudioBufferChannelData");
    EVENT_HANDLERS_WebAudioPlugin.put("decodeWebAudioData", "decodeWebAudioData");
    EVENT_HANDLERS_WebAudioPlugin.put("audioBufferCopyFromChannel", "audioBufferCopyFromChannel");
    EVENT_HANDLERS_WebAudioPlugin.put("audioBufferCopyToChannel", "audioBufferCopyToChannel");
    EVENT_HANDLERS_WebAudioPlugin.put("createWebAudioScriptProcessor", "createWebAudioScriptProcessor");
    EVENT_HANDLERS_WebAudioPlugin.put("audioProcessingEventSetQueueBuffer", "audioProcessingEventSetQueueBuffer");
    EVENT_HANDLERS_WebAudioPlugin.put("webAudioConnectAudioNode", "webAudioConnectAudioNode");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.minigame.plugins.WebAudioPlugin", EVENT_HANDLERS_WebAudioPlugin);
    EVENT_HANDLERS_MiniGameUIJsPlugin.put("showToast", "showToast");
    EVENT_HANDLERS_MiniGameUIJsPlugin.put("hideToast", "hideToastOrLoading");
    EVENT_HANDLERS_MiniGameUIJsPlugin.put("hideLoading", "hideToastOrLoading");
    EVENT_HANDLERS_MiniGameUIJsPlugin.put("showLoading", "showLoading");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.minigame.plugins.MiniGameUIJsPlugin", EVENT_HANDLERS_MiniGameUIJsPlugin);
    EVENT_HANDLERS_OpenDataJsPlugin.put("onMessage", "onMessage");
    EVENT_HANDLERS_OpenDataJsPlugin.put("getUserCloudStorage", "getUserCloudStorage");
    EVENT_HANDLERS_OpenDataJsPlugin.put("getFriendCloudStorage", "getFriendCloudStorage");
    EVENT_HANDLERS_OpenDataJsPlugin.put("getGroupCloudStorage", "getGroupCloudStorage");
    EVENT_HANDLERS_OpenDataJsPlugin.put("setUserCloudStorage", "setUserCloudStorage");
    EVENT_HANDLERS_OpenDataJsPlugin.put("removeUserCloudStorage", "removeUserCloudStorage");
    EVENT_HANDLERS_OpenDataJsPlugin.put("getOpenDataContext", "getOpenDataContext");
    EVENT_HANDLERS_OpenDataJsPlugin.put("setMessageToFriendQuery", "setMessageToFriendQuery");
    EVENT_HANDLERS_OpenDataJsPlugin.put("getPotentialFriendList", "getPotentialFriendList");
    EVENT_HANDLERS_OpenDataJsPlugin.put("shareMessageToFriend", "shareMessageToFriend");
    EVENT_HANDLERS_OpenDataJsPlugin.put("getUserInteractiveStorage", "getUserInteractiveStorage");
    EVENT_HANDLERS_OpenDataJsPlugin.put("modifyFriendInteractiveStorage", "modifyFriendInteractiveStorage");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.minigame.plugins.OpenDataJsPlugin", EVENT_HANDLERS_OpenDataJsPlugin);
    SERVICE_INJECTORS_OpenDataJsPlugin.put("mChannelProxy", "com.tencent.qqmini.sdk.core.proxy.ChannelProxy");
    EVENT_HANDLERS_GameDataJsPlugin.put("getLaunchOptionsSync", "getLaunchOptionsSync");
    EVENT_HANDLERS_GameDataJsPlugin.put("recordOffLineResourceState", "recordOffLineResourceState");
    EVENT_HANDLERS_GameDataJsPlugin.put("navigateToMiniProgramConfig", "navigateToMiniProgramConfig");
    EVENT_HANDLERS_GameDataJsPlugin.put("getOpenDataUserInfo", "getOpenDataUserInfo");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.minigame.plugins.GameDataJsPlugin", EVENT_HANDLERS_GameDataJsPlugin);
    SERVICE_INJECTORS_GameDataJsPlugin.put("mChannelProxy", "com.tencent.qqmini.sdk.core.proxy.ChannelProxy");
    EVENT_HANDLERS_SubpackageJsPlugin.put("createLoadSubPackageTask", "createLoadSubPackageTask");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.minigame.plugins.SubpackageJsPlugin", EVENT_HANDLERS_SubpackageJsPlugin);
    EVENT_HANDLERS_ImmersiveJsPlugin.put("setStatusBarStyle", "setStatusBarStyle");
    EVENT_HANDLERS_ImmersiveJsPlugin.put("setMenuStyle", "setMenuStyle");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.minigame.plugins.ImmersiveJsPlugin", EVENT_HANDLERS_ImmersiveJsPlugin);
    EVENT_HANDLERS_UDPJsPlugin.put("createUDPTask", "createUDPTask");
    EVENT_HANDLERS_UDPJsPlugin.put("operateUDPTask", "operateUDPTask");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.minigame.plugins.UDPJsPlugin", EVENT_HANDLERS_UDPJsPlugin);
    EVENT_HANDLERS_UpdateManagerJsPlugin.put("getUpdateManager", "getUpdateManager");
    EVENT_HANDLERS_UpdateManagerJsPlugin.put("onUpdateCheckResult", "onUpdateCheckResult");
    EVENT_HANDLERS_UpdateManagerJsPlugin.put("onUpdateDownloadResult", "onUpdateDownloadResult");
    EVENT_HANDLERS_UpdateManagerJsPlugin.put("updateApp", "updateApp");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.minigame.plugins.UpdateManagerJsPlugin", EVENT_HANDLERS_UpdateManagerJsPlugin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.GameJsPluginScope
 * JD-Core Version:    0.7.0.1
 */