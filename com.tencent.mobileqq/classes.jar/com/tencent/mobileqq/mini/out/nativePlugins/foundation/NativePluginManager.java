package com.tencent.mobileqq.mini.out.nativePlugins.foundation;

import java.util.HashSet;
import java.util.Set;

public class NativePluginManager
{
  private static Set<NativePluginManager.PluginInfo> pluginList = new HashSet();
  
  static
  {
    pluginList.add(new NativePluginManager.PluginInfo("uploadAvatar", "com.tencent.mobileqq.mini.out.nativePlugins.SetAvatarNativePlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("weiyunDownload", "com.tencent.mobileqq.mini.out.nativePlugins.WeiyunDownloadFilePlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("refreshQzoneFeed", "com.tencent.mobileqq.mini.out.nativePlugins.RefreshQzoneFeedPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("getMultiMemList", "com.tencent.mobileqq.mini.out.nativePlugins.GroupPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("checkin_invokeGYCamera", "com.tencent.mobileqq.mini.out.nativePlugins.LaunchCameraPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("requestWebSSO", "com.tencent.mobileqq.mini.out.nativePlugins.WebSsoJsPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("checkin_qzoneUploadAndPublish", "com.tencent.mobileqq.mini.out.nativePlugins.QzonePublishPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("checkin_uploadRes", "com.tencent.mobileqq.mini.out.nativePlugins.GroupCheckInUploadPlugin"));
    initTroopAlbumPlugin();
    pluginList.add(new NativePluginManager.PluginInfo("tdoc_channel", "com.tencent.mobileqq.mini.out.nativePlugins.TenDocChannelPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("openTenpayView", "com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("qWalletBridge", "com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin"));
    initQQPublicAccountPlugin();
    pluginList.add(new NativePluginManager.PluginInfo("tim_space", "com.tencent.mobileqq.mini.out.nativePlugins.TimTeamPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("invokeGameBuddyAio", "com.tencent.mobileqq.mini.out.nativePlugins.GameBuddyPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("checkGameBuddyType", "com.tencent.mobileqq.mini.out.nativePlugins.GameBuddyPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("getGUID", "com.tencent.mobileqq.mini.out.nativePlugins.DeviceInfoPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("sendMsg", "com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("nowlive", "com.tencent.mobileqq.mini.out.nativePlugins.NowLiveNativePlugin"));
  }
  
  public static Set<NativePluginManager.PluginInfo> getPluginInfo()
  {
    return pluginList;
  }
  
  private static void initQQPublicAccountPlugin()
  {
    pluginList.add(new NativePluginManager.PluginInfo("qsubscribe_opendiscover", "com.tencent.mobileqq.mini.out.nativePlugins.QQPublicAccountNativePlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("qsubscribe_opendetail", "com.tencent.mobileqq.mini.out.nativePlugins.QQPublicAccountNativePlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("qsubscribe_openhomepage", "com.tencent.mobileqq.mini.out.nativePlugins.QQPublicAccountNativePlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("qsubscribe_getdeviceinfo", "com.tencent.mobileqq.mini.out.nativePlugins.QQPublicAccountNativePlugin"));
  }
  
  private static void initTroopAlbumPlugin()
  {
    pluginList.add(new NativePluginManager.PluginInfo("groupAlbum_groupUploadPhoto", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("groupAlbum_openUserQzoneHome", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("groupAlbum_importGroupAIO", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("groupAlbum_showGroupPhotoBrowser", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("groupAlbum_jumpGroupAlbumSendBox", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("groupAlbum_downloadGroupAlbumPhoto", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("groupAlbum_jumpCategoryAlbum", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("groupAlbum_pickQzoneAlbum", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
    pluginList.add(new NativePluginManager.PluginInfo("groupAlbum_start", "com.tencent.mobileqq.mini.out.nativePlugins.TroopAlbumPlugin"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.nativePlugins.foundation.NativePluginManager
 * JD-Core Version:    0.7.0.1
 */