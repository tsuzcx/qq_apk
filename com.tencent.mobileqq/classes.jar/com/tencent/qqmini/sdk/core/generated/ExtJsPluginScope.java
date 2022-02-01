package com.tencent.qqmini.sdk.core.generated;

import bizj;
import bizl;
import bizo;
import bizp;
import bizr;
import bizu;
import bizw;
import bizx;
import bizy;
import bizz;
import bjab;
import bjac;
import bjad;
import bjae;
import bjam;
import bjan;
import bjat;
import bjcs;
import bjet;
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
    EVENT_HANDLERS.put("addColorSign", bjcs.class);
    EVENT_HANDLERS.put("addColorSignDirectly", bjcs.class);
    EVENT_HANDLERS.put("isColorSignExistSync", bjcs.class);
    EVENT_HANDLERS.put("exitMiniProgram", bjet.class);
    EVENT_HANDLERS.put("navigateBackMiniProgram", bjet.class);
    EVENT_HANDLERS.put("navigateToMiniProgram", bjet.class);
    EVENT_HANDLERS.put("showMiniAIOEntrance", bjat.class);
    EVENT_HANDLERS.put("hideMiniAIOEntrance", bjat.class);
    SECONDARY_EVENT_HANDLERS.put("requestWebSSO", bjam.class);
    SECONDARY_EVENT_HANDLERS.put("getGUID", bizj.class);
    SECONDARY_EVENT_HANDLERS.put("sendMsg", bjab.class);
    SECONDARY_EVENT_HANDLERS.put("getMultiMemList", bizp.class);
    SECONDARY_EVENT_HANDLERS.put("openTenpayView", TenpayPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("qWalletBridge", TenpayPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_groupUploadPhoto", bjae.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_openUserQzoneHome", bjae.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_importGroupAIO", bjae.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_showGroupPhotoBrowser", bjae.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_jumpGroupAlbumSendBox", bjae.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_downloadGroupAlbumPhoto", bjae.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_jumpCategoryAlbum", bjae.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_pickQzoneAlbum", bjae.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_start", bjae.class);
    SECONDARY_EVENT_HANDLERS.put("tim_space", bjad.class);
    SECONDARY_EVENT_HANDLERS.put("uploadAvatar", bizz.class);
    SECONDARY_EVENT_HANDLERS.put("tdoc_channel", bjac.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_opendiscover", bizw.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_opendetail", bizw.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_openhomepage", bizw.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_getdeviceinfo", bizw.class);
    SECONDARY_EVENT_HANDLERS.put("weiyunDownload", bjan.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_qzoneUploadAndPublish", bizx.class);
    SECONDARY_EVENT_HANDLERS.put("refreshQzoneFeed", bizy.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_invokeGYCamera", bizr.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_uploadRes", bizo.class);
    SECONDARY_EVENT_HANDLERS.put("invokeGameBuddyAio", bizl.class);
    SECONDARY_EVENT_HANDLERS.put("checkGameBuddyType", bizl.class);
    SECONDARY_EVENT_HANDLERS.put("nowlive", bizu.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.ExtJsPluginScope
 * JD-Core Version:    0.7.0.1
 */