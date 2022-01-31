package com.tencent.qqmini.sdk.core.generated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class AppJsPluginScope
{
  public static final Map EVENT_HANDLERS_AudioJsPlugin;
  public static final Map EVENT_HANDLERS_CanvasJsPlugin;
  public static final Map EVENT_HANDLERS_EmbeddedVideoJsPlugin;
  public static final Map EVENT_HANDLERS_ImageViewJsPlugin;
  public static final Map EVENT_HANDLERS_LivePlayerJsPlugin;
  public static final Map EVENT_HANDLERS_LivePusherJsPlugin;
  public static final Map EVENT_HANDLERS_MediaJsPlugin;
  public static final Map EVENT_HANDLERS_MiniAppFileJsPlugin;
  public static final Map EVENT_HANDLERS_MiniAppUIJsPlugin;
  public static final Map EVENT_HANDLERS_NavigationBarPlugin;
  public static final Map EVENT_HANDLERS_PickerJsPlugin;
  public static final Map EVENT_HANDLERS_PullDownRefreshJsPlugin;
  public static final Map EVENT_HANDLERS_ScrollViewJsPlugin;
  public static final Map EVENT_HANDLERS_SubpackageJsPlugin;
  public static final Map EVENT_HANDLERS_TabBarJsPlugin;
  public static final Map EVENT_HANDLERS_TextViewJsPlugin;
  public static final Map EVENT_HANDLERS_VideoJsPlugin;
  public static final Map PLUGIN_EVENTS;
  public static final List PRELOAD_PLUGINS = new ArrayList();
  public static final Map SECONDARY_PLUGIN_EVENTS;
  public static final Map SERVICE_INJECTORS_VideoJsPlugin;
  
  static
  {
    PLUGIN_EVENTS = new HashMap();
    SECONDARY_PLUGIN_EVENTS = new HashMap();
    EVENT_HANDLERS_NavigationBarPlugin = new HashMap();
    EVENT_HANDLERS_LivePlayerJsPlugin = new HashMap();
    EVENT_HANDLERS_MediaJsPlugin = new HashMap();
    EVENT_HANDLERS_ScrollViewJsPlugin = new HashMap();
    EVENT_HANDLERS_TabBarJsPlugin = new HashMap();
    EVENT_HANDLERS_VideoJsPlugin = new HashMap();
    SERVICE_INJECTORS_VideoJsPlugin = new HashMap();
    EVENT_HANDLERS_AudioJsPlugin = new HashMap();
    EVENT_HANDLERS_PullDownRefreshJsPlugin = new HashMap();
    EVENT_HANDLERS_MiniAppFileJsPlugin = new HashMap();
    EVENT_HANDLERS_MiniAppUIJsPlugin = new HashMap();
    EVENT_HANDLERS_EmbeddedVideoJsPlugin = new HashMap();
    EVENT_HANDLERS_TextViewJsPlugin = new HashMap();
    EVENT_HANDLERS_ImageViewJsPlugin = new HashMap();
    EVENT_HANDLERS_PickerJsPlugin = new HashMap();
    EVENT_HANDLERS_LivePusherJsPlugin = new HashMap();
    EVENT_HANDLERS_SubpackageJsPlugin = new HashMap();
    EVENT_HANDLERS_CanvasJsPlugin = new HashMap();
    EVENT_HANDLERS_NavigationBarPlugin.put("setNavigationBarTitle", "doInterceptJsEvent");
    EVENT_HANDLERS_NavigationBarPlugin.put("showNavigationBarLoading", "doInterceptJsEvent");
    EVENT_HANDLERS_NavigationBarPlugin.put("hideNavigationBarLoading", "doInterceptJsEvent");
    EVENT_HANDLERS_NavigationBarPlugin.put("setNavigationBarColor", "doInterceptJsEvent");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.NavigationBarPlugin", EVENT_HANDLERS_NavigationBarPlugin);
    EVENT_HANDLERS_LivePlayerJsPlugin.put("insertLivePlayer", "insertLivePlayer");
    EVENT_HANDLERS_LivePlayerJsPlugin.put("updateLivePlayer", "updateLivePlayer");
    EVENT_HANDLERS_LivePlayerJsPlugin.put("removeLivePlayer", "removeLivePlayer");
    EVENT_HANDLERS_LivePlayerJsPlugin.put("operateLivePlayer", "operateLivePlayer");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.LivePlayerJsPlugin", EVENT_HANDLERS_LivePlayerJsPlugin);
    EVENT_HANDLERS_MediaJsPlugin.put("operateVideoPlayer", "operateVideoPlayer");
    EVENT_HANDLERS_MediaJsPlugin.put("insertVideoPlayer", "insertVideoPlayer");
    EVENT_HANDLERS_MediaJsPlugin.put("updateVideoPlayer", "updateVideoPlayer");
    EVENT_HANDLERS_MediaJsPlugin.put("removeVideoPlayer", "removeVideoPlayer");
    EVENT_HANDLERS_MediaJsPlugin.put("insertCamera", "insertCamera");
    EVENT_HANDLERS_MediaJsPlugin.put("removeCamera", "removeCamera");
    EVENT_HANDLERS_MediaJsPlugin.put("operateCamera", "operateCamera");
    EVENT_HANDLERS_MediaJsPlugin.put("updateCamera", "updateCamera");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.MediaJsPlugin", EVENT_HANDLERS_MediaJsPlugin);
    EVENT_HANDLERS_ScrollViewJsPlugin.put("insertScrollView", "setEventInsertScrollview");
    EVENT_HANDLERS_ScrollViewJsPlugin.put("updateScrollView", "setEventUpdateScrollview");
    EVENT_HANDLERS_ScrollViewJsPlugin.put("removeScrollView", "setEventRemoveScrollview");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.ScrollViewJsPlugin", EVENT_HANDLERS_ScrollViewJsPlugin);
    EVENT_HANDLERS_TabBarJsPlugin.put("showTabBar", "doInterceptJsEvent");
    EVENT_HANDLERS_TabBarJsPlugin.put("hideTabBar", "doInterceptJsEvent");
    EVENT_HANDLERS_TabBarJsPlugin.put("setTabBarItem", "doInterceptJsEvent");
    EVENT_HANDLERS_TabBarJsPlugin.put("setTabBarStyle", "doInterceptJsEvent");
    EVENT_HANDLERS_TabBarJsPlugin.put("setTabBarBadge", "doInterceptJsEvent");
    EVENT_HANDLERS_TabBarJsPlugin.put("removeTabBarBadge", "doInterceptJsEvent");
    EVENT_HANDLERS_TabBarJsPlugin.put("showTabBarRedDot", "doInterceptJsEvent");
    EVENT_HANDLERS_TabBarJsPlugin.put("hideTabBarRedDot", "doInterceptJsEvent");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.TabBarJsPlugin", EVENT_HANDLERS_TabBarJsPlugin);
    EVENT_HANDLERS_VideoJsPlugin.put("chooseVideo", "chooseVideo");
    EVENT_HANDLERS_VideoJsPlugin.put("saveVideoToPhotosAlbum", "saveVideoToPhotosAlbum");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.VideoJsPlugin", EVENT_HANDLERS_VideoJsPlugin);
    SERVICE_INJECTORS_VideoJsPlugin.put("mImpl", "com.tencent.qqmini.sdk.core.proxy.VideoJsProxy");
    EVENT_HANDLERS_AudioJsPlugin.put("startRecord", "startRecord");
    EVENT_HANDLERS_AudioJsPlugin.put("stopRecord", "stopRecord");
    EVENT_HANDLERS_AudioJsPlugin.put("playVoice", "playVoice");
    EVENT_HANDLERS_AudioJsPlugin.put("pauseVoice", "pauseVoice");
    EVENT_HANDLERS_AudioJsPlugin.put("stopVoice", "stopVoice");
    EVENT_HANDLERS_AudioJsPlugin.put("operateRecorder", "operateRecorder");
    EVENT_HANDLERS_AudioJsPlugin.put("operateMusicPlayer", "operateMusicPlayer");
    EVENT_HANDLERS_AudioJsPlugin.put("getMusicPlayerState", "getMusicPlayerState");
    EVENT_HANDLERS_AudioJsPlugin.put("getBackgroundAudioState", "getBackgroundAudioState");
    EVENT_HANDLERS_AudioJsPlugin.put("operateBackgroundAudio", "operateBackgroundAudio");
    EVENT_HANDLERS_AudioJsPlugin.put("setBackgroundAudioState", "setBackgroundAudioState");
    EVENT_HANDLERS_AudioJsPlugin.put("getAvailableAudioSources", "getAvailableAudioSources");
    EVENT_HANDLERS_AudioJsPlugin.put("createAudioInstance", "createAudioInstance");
    EVENT_HANDLERS_AudioJsPlugin.put("setAudioState", "setAudioState");
    EVENT_HANDLERS_AudioJsPlugin.put("getAudioState", "getAudioState");
    EVENT_HANDLERS_AudioJsPlugin.put("operateAudio", "operateAudio");
    EVENT_HANDLERS_AudioJsPlugin.put("destroyAudioInstance", "destroyAudioInstance");
    EVENT_HANDLERS_AudioJsPlugin.put("setInnerAudioOption", "setInnerAudioOption");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.AudioJsPlugin", EVENT_HANDLERS_AudioJsPlugin);
    EVENT_HANDLERS_PullDownRefreshJsPlugin.put("startPullDownRefresh", "doInterceptJsEvent");
    EVENT_HANDLERS_PullDownRefreshJsPlugin.put("stopPullDownRefresh", "doInterceptJsEvent");
    EVENT_HANDLERS_PullDownRefreshJsPlugin.put("disableScrollBounce", "doInterceptJsEvent");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.PullDownRefreshJsPlugin", EVENT_HANDLERS_PullDownRefreshJsPlugin);
    EVENT_HANDLERS_MiniAppFileJsPlugin.put("openDocument", "openDocument");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.MiniAppFileJsPlugin", EVENT_HANDLERS_MiniAppFileJsPlugin);
    EVENT_HANDLERS_MiniAppUIJsPlugin.put("showToast", "showToast");
    EVENT_HANDLERS_MiniAppUIJsPlugin.put("showLoading", "showLoading");
    EVENT_HANDLERS_MiniAppUIJsPlugin.put("hideToast", "hideToast");
    EVENT_HANDLERS_MiniAppUIJsPlugin.put("hideLoading", "hideToast");
    EVENT_HANDLERS_MiniAppUIJsPlugin.put("setBackgroundTextStyle", "setBackgroundTextStyle");
    EVENT_HANDLERS_MiniAppUIJsPlugin.put("setBackgroundColor", "setBackgroundTextStyle");
    EVENT_HANDLERS_MiniAppUIJsPlugin.put("scrollWebviewTo", "pageScrollTo");
    EVENT_HANDLERS_MiniAppUIJsPlugin.put("hideHomeButton", "hideHomeButton");
    EVENT_HANDLERS_MiniAppUIJsPlugin.put("getRegionData", "getRegionData");
    EVENT_HANDLERS_MiniAppUIJsPlugin.put("scrollWebviewTo", "scrollWebviewTo");
    EVENT_HANDLERS_MiniAppUIJsPlugin.put("insertHTMLWebView", "insertHtmlWebview");
    EVENT_HANDLERS_MiniAppUIJsPlugin.put("updateHTMLWebView", "updateHtmlWebview");
    EVENT_HANDLERS_MiniAppUIJsPlugin.put("removeHTMLWebView", "removeHtmlWebview");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.MiniAppUIJsPlugin", EVENT_HANDLERS_MiniAppUIJsPlugin);
    EVENT_HANDLERS_EmbeddedVideoJsPlugin.put("getVolume", "getVolume");
    EVENT_HANDLERS_EmbeddedVideoJsPlugin.put("setVolume", "setVolume");
    EVENT_HANDLERS_EmbeddedVideoJsPlugin.put("insertXWebVideo", "insertXwebVideo");
    EVENT_HANDLERS_EmbeddedVideoJsPlugin.put("updateXWebVideo", "updateXwebVideo");
    EVENT_HANDLERS_EmbeddedVideoJsPlugin.put("operateXWebVideo", "operateXwebVideo");
    EVENT_HANDLERS_EmbeddedVideoJsPlugin.put("setDisplayOrientation", "setDisplayOrientation");
    EVENT_HANDLERS_EmbeddedVideoJsPlugin.put("hideVirtualBottomNavigationBar", "hideNavigationBar");
    EVENT_HANDLERS_EmbeddedVideoJsPlugin.put("showVirtualBottomNavigationBar", "showNavigationBar");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.EmbeddedVideoJsPlugin", EVENT_HANDLERS_EmbeddedVideoJsPlugin);
    EVENT_HANDLERS_TextViewJsPlugin.put("insertTextView", "setEventInsertTextview");
    EVENT_HANDLERS_TextViewJsPlugin.put("updateTextView", "setEventUpdateTextview");
    EVENT_HANDLERS_TextViewJsPlugin.put("removeTextView", "setEventRemoveTextview");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.TextViewJsPlugin", EVENT_HANDLERS_TextViewJsPlugin);
    EVENT_HANDLERS_ImageViewJsPlugin.put("insertImageView", "insertImageView");
    EVENT_HANDLERS_ImageViewJsPlugin.put("updateImageView", "updateImageView");
    EVENT_HANDLERS_ImageViewJsPlugin.put("removeImageView", "removeImageView");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.ImageViewJsPlugin", EVENT_HANDLERS_ImageViewJsPlugin);
    EVENT_HANDLERS_PickerJsPlugin.put("showPickerView", "handleShowPickerView");
    EVENT_HANDLERS_PickerJsPlugin.put("showMultiPickerView", "handleShowMultiPickerView");
    EVENT_HANDLERS_PickerJsPlugin.put("showDatePickerView", "handleShowDatePickerView");
    EVENT_HANDLERS_PickerJsPlugin.put("updateMultiPickerView", "handleUpdateMultiPickerView");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.PickerJsPlugin", EVENT_HANDLERS_PickerJsPlugin);
    EVENT_HANDLERS_LivePusherJsPlugin.put("insertLivePusher", "insertLivePusher");
    EVENT_HANDLERS_LivePusherJsPlugin.put("updateLivePusher", "updateLivePusher");
    EVENT_HANDLERS_LivePusherJsPlugin.put("removeLivePusher", "removeLivePusher");
    EVENT_HANDLERS_LivePusherJsPlugin.put("operateLivePusher", "operateLivePusher");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.LivePusherJsPlugin", EVENT_HANDLERS_LivePusherJsPlugin);
    EVENT_HANDLERS_SubpackageJsPlugin.put("createLoadSubPackageTask", "createLoadSubPackageTask");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.SubpackageJsPlugin", EVENT_HANDLERS_SubpackageJsPlugin);
    EVENT_HANDLERS_CanvasJsPlugin.put("drawCanvas", "doInterceptJsEvent");
    EVENT_HANDLERS_CanvasJsPlugin.put("canvasToTempFilePath", "doInterceptJsEvent");
    EVENT_HANDLERS_CanvasJsPlugin.put("canvasPutImageData", "doInterceptJsEvent");
    EVENT_HANDLERS_CanvasJsPlugin.put("canvasGetImageData", "doInterceptJsEvent");
    EVENT_HANDLERS_CanvasJsPlugin.put("insertCanvas", "doInterceptJsEvent");
    EVENT_HANDLERS_CanvasJsPlugin.put("updateCanvas", "doInterceptJsEvent");
    EVENT_HANDLERS_CanvasJsPlugin.put("removeCanvas", "doInterceptJsEvent");
    EVENT_HANDLERS_CanvasJsPlugin.put("measureText", "measureText");
    PLUGIN_EVENTS.put("com.tencent.qqmini.sdk.runtime.plugin.CanvasJsPlugin", EVENT_HANDLERS_CanvasJsPlugin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.AppJsPluginScope
 * JD-Core Version:    0.7.0.1
 */