package com.tencent.qqmini.sdk.core.generated;

import bkue;
import bkug;
import bkuj;
import bkuk;
import bkum;
import bkup;
import bkuq;
import bkur;
import bkus;
import bkuu;
import bkuv;
import bkuw;
import bkve;
import bkvf;
import bkvl;
import bkxc;
import bkyw;
import com.tencent.qqmini.nativePlugins.TenpayPlugin;
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
    EVENT_HANDLERS.put("addColorSign", bkxc.class);
    EVENT_HANDLERS.put("addColorSignDirectly", bkxc.class);
    EVENT_HANDLERS.put("isColorSignExistSync", bkxc.class);
    EVENT_HANDLERS.put("exitMiniProgram", bkyw.class);
    EVENT_HANDLERS.put("navigateBackMiniProgram", bkyw.class);
    EVENT_HANDLERS.put("navigateToMiniProgram", bkyw.class);
    EVENT_HANDLERS.put("showMiniAIOEntrance", bkvl.class);
    EVENT_HANDLERS.put("hideMiniAIOEntrance", bkvl.class);
    SECONDARY_EVENT_HANDLERS.put("requestWebSSO", bkve.class);
    SECONDARY_EVENT_HANDLERS.put("getGUID", bkue.class);
    SECONDARY_EVENT_HANDLERS.put("getMultiMemList", bkuk.class);
    SECONDARY_EVENT_HANDLERS.put("openTenpayView", TenpayPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("qWalletBridge", TenpayPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_groupUploadPhoto", bkuw.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_openUserQzoneHome", bkuw.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_importGroupAIO", bkuw.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_showGroupPhotoBrowser", bkuw.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_jumpGroupAlbumSendBox", bkuw.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_downloadGroupAlbumPhoto", bkuw.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_jumpCategoryAlbum", bkuw.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_pickQzoneAlbum", bkuw.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_start", bkuw.class);
    SECONDARY_EVENT_HANDLERS.put("tim_space", bkuv.class);
    SECONDARY_EVENT_HANDLERS.put("uploadAvatar", bkus.class);
    SECONDARY_EVENT_HANDLERS.put("tdoc_channel", bkuu.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_opendiscover", bkup.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_opendetail", bkup.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_openhomepage", bkup.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_getdeviceinfo", bkup.class);
    SECONDARY_EVENT_HANDLERS.put("weiyunDownload", bkvf.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_qzoneUploadAndPublish", bkuq.class);
    SECONDARY_EVENT_HANDLERS.put("refreshQzoneFeed", bkur.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_invokeGYCamera", bkum.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_uploadRes", bkuj.class);
    SECONDARY_EVENT_HANDLERS.put("invokeGameBuddyAio", bkug.class);
    SECONDARY_EVENT_HANDLERS.put("checkGameBuddyType", bkug.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.ExtJsPluginScope
 * JD-Core Version:    0.7.0.1
 */