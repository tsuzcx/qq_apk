package com.tencent.qqmini.sdk.core.generated;

import com.tencent.qqmini.nativePlugins.CMShowJsPlugin;
import com.tencent.qqmini.nativePlugins.DeviceInfoPlugin;
import com.tencent.qqmini.nativePlugins.GameBuddyPlugin;
import com.tencent.qqmini.nativePlugins.GroupCheckInUploadPlugin;
import com.tencent.qqmini.nativePlugins.GroupPlugin;
import com.tencent.qqmini.nativePlugins.LaunchAECameraPlugin;
import com.tencent.qqmini.nativePlugins.NowLiveJsPlugin;
import com.tencent.qqmini.nativePlugins.QQPublicAccountNativePlugin;
import com.tencent.qqmini.nativePlugins.QzonePublishPlugin;
import com.tencent.qqmini.nativePlugins.RefreshQzoneFeedPlugin;
import com.tencent.qqmini.nativePlugins.SetAvatarNativePlugin;
import com.tencent.qqmini.nativePlugins.SmsPlugin;
import com.tencent.qqmini.nativePlugins.TenDocChannelPlugin;
import com.tencent.qqmini.nativePlugins.TenpayPlugin;
import com.tencent.qqmini.nativePlugins.TimTeamPlugin;
import com.tencent.qqmini.nativePlugins.TroopAlbumPlugin;
import com.tencent.qqmini.nativePlugins.WebSsoJsPlugin;
import com.tencent.qqmini.nativePlugins.WeiyunDownloadFilePlugin;
import com.tencent.qqmini.proxyimpl.AIOEntryPlugin;
import com.tencent.qqmini.proxyimpl.ColorNotePlugin;
import com.tencent.qqmini.proxyimpl.NavigationJsPlugin;
import com.tencent.qqmini.proxyimpl.tavkitplugin.WeishiPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExtJsPluginScope
{
  public static final Map EVENT_HANDLERS;
  public static final List PRELOAD_PLUGINS = new ArrayList();
  public static final Map SECONDARY_EVENT_HANDLERS;
  
  static
  {
    EVENT_HANDLERS = new HashMap();
    SECONDARY_EVENT_HANDLERS = new HashMap();
    EVENT_HANDLERS.put("addColorSign", ColorNotePlugin.class);
    EVENT_HANDLERS.put("addColorSignDirectly", ColorNotePlugin.class);
    EVENT_HANDLERS.put("addRecentColorSign", ColorNotePlugin.class);
    EVENT_HANDLERS.put("isColorSignExistSync", ColorNotePlugin.class);
    EVENT_HANDLERS.put("exitMiniProgram", NavigationJsPlugin.class);
    EVENT_HANDLERS.put("navigateBackMiniProgram", NavigationJsPlugin.class);
    EVENT_HANDLERS.put("navigateToMiniProgram", NavigationJsPlugin.class);
    EVENT_HANDLERS.put("showMiniAIOEntrance", AIOEntryPlugin.class);
    EVENT_HANDLERS.put("hideMiniAIOEntrance", AIOEntryPlugin.class);
    EVENT_HANDLERS.put("getCMShowInfo", CMShowJsPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("requestWebSSO", WebSsoJsPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("getGUID", DeviceInfoPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("sendMsg", SmsPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("getMultiMemList", GroupPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("openTenpayView", TenpayPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("qWalletBridge", TenpayPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_groupUploadPhoto", TroopAlbumPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_openUserQzoneHome", TroopAlbumPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_importGroupAIO", TroopAlbumPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_showGroupPhotoBrowser", TroopAlbumPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_jumpGroupAlbumSendBox", TroopAlbumPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_downloadGroupAlbumPhoto", TroopAlbumPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_jumpCategoryAlbum", TroopAlbumPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_pickQzoneAlbum", TroopAlbumPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_start", TroopAlbumPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("tim_space", TimTeamPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("uploadAvatar", SetAvatarNativePlugin.class);
    SECONDARY_EVENT_HANDLERS.put("tdoc_channel", TenDocChannelPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_opendiscover", QQPublicAccountNativePlugin.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_opendetail", QQPublicAccountNativePlugin.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_openhomepage", QQPublicAccountNativePlugin.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_getdeviceinfo", QQPublicAccountNativePlugin.class);
    SECONDARY_EVENT_HANDLERS.put("weiyunDownload", WeiyunDownloadFilePlugin.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_qzoneUploadAndPublish", QzonePublishPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("refreshQzoneFeed", RefreshQzoneFeedPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_invokeGYCamera", LaunchAECameraPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("play_invokeGYCamera", LaunchAECameraPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("miniApp_invokeGYCamera", LaunchAECameraPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_uploadRes", GroupCheckInUploadPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("setCMShowPetStatus", CMShowJsPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("invokeGameBuddyAio", GameBuddyPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("checkGameBuddyType", GameBuddyPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("nowlive", NowLiveJsPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("tav_createObject", WeishiPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("tav_sendMsgToObject", WeishiPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("tav_releaseObject", WeishiPlugin.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.ExtJsPluginScope
 * JD-Core Version:    0.7.0.1
 */