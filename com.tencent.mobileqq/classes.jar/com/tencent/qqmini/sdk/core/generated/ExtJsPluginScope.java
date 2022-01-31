package com.tencent.qqmini.sdk.core.generated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExtJsPluginScope
{
  public static final Map EVENT_HANDLERS_AIOEntryPlugin;
  public static final Map EVENT_HANDLERS_ColorNotePlugin;
  public static final Map EVENT_HANDLERS_GroupCheckInUploadPlugin;
  public static final Map EVENT_HANDLERS_GroupPlugin;
  public static final Map EVENT_HANDLERS_LaunchCameraPlugin;
  public static final Map EVENT_HANDLERS_NavigationJsPlugin;
  public static final Map EVENT_HANDLERS_QQPublicAccountNativePlugin;
  public static final Map EVENT_HANDLERS_QzonePublishPlugin;
  public static final Map EVENT_HANDLERS_RefreshQzoneFeedPlugin;
  public static final Map EVENT_HANDLERS_SetAvatarNativePlugin;
  public static final Map EVENT_HANDLERS_TenDocChannelPlugin;
  public static final Map EVENT_HANDLERS_TenpayPlugin;
  public static final Map EVENT_HANDLERS_TimTeamPlugin;
  public static final Map EVENT_HANDLERS_TroopAlbumPlugin;
  public static final Map EVENT_HANDLERS_WebSsoJsPlugin;
  public static final Map EVENT_HANDLERS_WeiyunDownloadFilePlugin;
  public static final Map PLUGIN_EVENTS;
  public static final List PRELOAD_PLUGINS = new ArrayList();
  public static final Map SECONDARY_PLUGIN_EVENTS;
  
  static
  {
    PLUGIN_EVENTS = new HashMap();
    SECONDARY_PLUGIN_EVENTS = new HashMap();
    EVENT_HANDLERS_ColorNotePlugin = new HashMap();
    EVENT_HANDLERS_NavigationJsPlugin = new HashMap();
    EVENT_HANDLERS_AIOEntryPlugin = new HashMap();
    EVENT_HANDLERS_WebSsoJsPlugin = new HashMap();
    EVENT_HANDLERS_GroupPlugin = new HashMap();
    EVENT_HANDLERS_TenpayPlugin = new HashMap();
    EVENT_HANDLERS_TroopAlbumPlugin = new HashMap();
    EVENT_HANDLERS_TimTeamPlugin = new HashMap();
    EVENT_HANDLERS_SetAvatarNativePlugin = new HashMap();
    EVENT_HANDLERS_TenDocChannelPlugin = new HashMap();
    EVENT_HANDLERS_QQPublicAccountNativePlugin = new HashMap();
    EVENT_HANDLERS_WeiyunDownloadFilePlugin = new HashMap();
    EVENT_HANDLERS_QzonePublishPlugin = new HashMap();
    EVENT_HANDLERS_RefreshQzoneFeedPlugin = new HashMap();
    EVENT_HANDLERS_LaunchCameraPlugin = new HashMap();
    EVENT_HANDLERS_GroupCheckInUploadPlugin = new HashMap();
    EVENT_HANDLERS_ColorNotePlugin.put("addColorSign", "addColorSign");
    EVENT_HANDLERS_ColorNotePlugin.put("addColorSignDirectly", "addColorSignDirectly");
    PLUGIN_EVENTS.put("com.tencent.qqmini.proxyimpl.ColorNotePlugin", EVENT_HANDLERS_ColorNotePlugin);
    EVENT_HANDLERS_NavigationJsPlugin.put("exitMiniProgram", "exitMiniProgram");
    EVENT_HANDLERS_NavigationJsPlugin.put("navigateBackMiniProgram", "navigateBackMiniProgram");
    EVENT_HANDLERS_NavigationJsPlugin.put("navigateToMiniProgram", "navigateToMiniProgram");
    PLUGIN_EVENTS.put("com.tencent.qqmini.proxyimpl.NavigationJsPlugin", EVENT_HANDLERS_NavigationJsPlugin);
    EVENT_HANDLERS_AIOEntryPlugin.put("showMiniAIOEntrance", "showMiniAIOEntrance");
    EVENT_HANDLERS_AIOEntryPlugin.put("hideMiniAIOEntrance", "hideMiniAIOEntrance");
    PLUGIN_EVENTS.put("com.tencent.qqmini.proxyimpl.AIOEntryPlugin", EVENT_HANDLERS_AIOEntryPlugin);
    EVENT_HANDLERS_WebSsoJsPlugin.put("requestWebSSO", "requestWebSSO");
    SECONDARY_PLUGIN_EVENTS.put("com.tencent.qqmini.nativePlugins.WebSsoJsPlugin", EVENT_HANDLERS_WebSsoJsPlugin);
    EVENT_HANDLERS_GroupPlugin.put("getMultiMemList", "getMultiMemList");
    SECONDARY_PLUGIN_EVENTS.put("com.tencent.qqmini.nativePlugins.GroupPlugin", EVENT_HANDLERS_GroupPlugin);
    EVENT_HANDLERS_TenpayPlugin.put("openTenpayView", "openTenpayView");
    SECONDARY_PLUGIN_EVENTS.put("com.tencent.qqmini.nativePlugins.TenpayPlugin", EVENT_HANDLERS_TenpayPlugin);
    EVENT_HANDLERS_TroopAlbumPlugin.put("groupAlbum_groupUploadPhoto", "groupAlbumGroupUploadPhoto");
    EVENT_HANDLERS_TroopAlbumPlugin.put("groupAlbum_openUserQzoneHome", "groupAlbumOpenUserQzoneHome");
    EVENT_HANDLERS_TroopAlbumPlugin.put("groupAlbum_importGroupAIO", "groupAlbumImportGroupAIO");
    EVENT_HANDLERS_TroopAlbumPlugin.put("groupAlbum_showGroupPhotoBrowser", "groupAlbumShowGroupPhotoBrowser");
    EVENT_HANDLERS_TroopAlbumPlugin.put("groupAlbum_jumpGroupAlbumSendBox", "groupAlbumJumpGroupAlbumSendBox");
    EVENT_HANDLERS_TroopAlbumPlugin.put("groupAlbum_downloadGroupAlbumPhoto", "groupAlbumDownloadGroupAlbumPhoto");
    EVENT_HANDLERS_TroopAlbumPlugin.put("groupAlbum_jumpCategoryAlbum", "groupAlbumJumpCategoryAlbum");
    EVENT_HANDLERS_TroopAlbumPlugin.put("groupAlbum_pickQzoneAlbum", "groupAlbumPickQzoneAlbum");
    EVENT_HANDLERS_TroopAlbumPlugin.put("groupAlbum_start", "groupAlbumStart");
    SECONDARY_PLUGIN_EVENTS.put("com.tencent.qqmini.nativePlugins.TroopAlbumPlugin", EVENT_HANDLERS_TroopAlbumPlugin);
    EVENT_HANDLERS_TimTeamPlugin.put("tim_space", "timSpace");
    SECONDARY_PLUGIN_EVENTS.put("com.tencent.qqmini.nativePlugins.TimTeamPlugin", EVENT_HANDLERS_TimTeamPlugin);
    EVENT_HANDLERS_SetAvatarNativePlugin.put("uploadAvatar", "uploadAvatar");
    SECONDARY_PLUGIN_EVENTS.put("com.tencent.qqmini.nativePlugins.SetAvatarNativePlugin", EVENT_HANDLERS_SetAvatarNativePlugin);
    EVENT_HANDLERS_TenDocChannelPlugin.put("tdoc_channel", "tdocChannel");
    SECONDARY_PLUGIN_EVENTS.put("com.tencent.qqmini.nativePlugins.TenDocChannelPlugin", EVENT_HANDLERS_TenDocChannelPlugin);
    EVENT_HANDLERS_QQPublicAccountNativePlugin.put("qsubscribe_opendiscover", "qsubscribeOpendiscover");
    EVENT_HANDLERS_QQPublicAccountNativePlugin.put("qsubscribe_opendetail", "qsubscribeOpendetail");
    EVENT_HANDLERS_QQPublicAccountNativePlugin.put("qsubscribe_openhomepage", "qsubscribeOpenhomepage");
    EVENT_HANDLERS_QQPublicAccountNativePlugin.put("qsubscribe_getdeviceinfo", "qsubscribeGetdeviceinfo");
    SECONDARY_PLUGIN_EVENTS.put("com.tencent.qqmini.nativePlugins.QQPublicAccountNativePlugin", EVENT_HANDLERS_QQPublicAccountNativePlugin);
    EVENT_HANDLERS_WeiyunDownloadFilePlugin.put("weiyunDownload", "weiyunDownload");
    SECONDARY_PLUGIN_EVENTS.put("com.tencent.qqmini.nativePlugins.WeiyunDownloadFilePlugin", EVENT_HANDLERS_WeiyunDownloadFilePlugin);
    EVENT_HANDLERS_QzonePublishPlugin.put("checkin_qzoneUploadAndPublish", "checkinQzoneUploadAndPublish");
    SECONDARY_PLUGIN_EVENTS.put("com.tencent.qqmini.nativePlugins.QzonePublishPlugin", EVENT_HANDLERS_QzonePublishPlugin);
    EVENT_HANDLERS_RefreshQzoneFeedPlugin.put("refreshQzoneFeed", "refreshQzoneFeed");
    SECONDARY_PLUGIN_EVENTS.put("com.tencent.qqmini.nativePlugins.RefreshQzoneFeedPlugin", EVENT_HANDLERS_RefreshQzoneFeedPlugin);
    EVENT_HANDLERS_LaunchCameraPlugin.put("checkin_invokeGYCamera", "checkinInvokeGYCamera");
    SECONDARY_PLUGIN_EVENTS.put("com.tencent.qqmini.nativePlugins.LaunchCameraPlugin", EVENT_HANDLERS_LaunchCameraPlugin);
    EVENT_HANDLERS_GroupCheckInUploadPlugin.put("checkin_uploadRes", "checkinUploadRes");
    SECONDARY_PLUGIN_EVENTS.put("com.tencent.qqmini.nativePlugins.GroupCheckInUploadPlugin", EVENT_HANDLERS_GroupCheckInUploadPlugin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.ExtJsPluginScope
 * JD-Core Version:    0.7.0.1
 */