package com.tencent.qqmini.sdk.core.generated;

import bjtd;
import bjtf;
import bjti;
import bjtj;
import bjtl;
import bjto;
import bjtp;
import bjtq;
import bjtr;
import bjtt;
import bjtu;
import bjtv;
import bjud;
import bjue;
import bjuk;
import bjwc;
import bjxs;
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
    EVENT_HANDLERS.put("addColorSign", bjwc.class);
    EVENT_HANDLERS.put("addColorSignDirectly", bjwc.class);
    EVENT_HANDLERS.put("exitMiniProgram", bjxs.class);
    EVENT_HANDLERS.put("navigateBackMiniProgram", bjxs.class);
    EVENT_HANDLERS.put("navigateToMiniProgram", bjxs.class);
    EVENT_HANDLERS.put("showMiniAIOEntrance", bjuk.class);
    EVENT_HANDLERS.put("hideMiniAIOEntrance", bjuk.class);
    SECONDARY_EVENT_HANDLERS.put("requestWebSSO", bjud.class);
    SECONDARY_EVENT_HANDLERS.put("getGUID", bjtd.class);
    SECONDARY_EVENT_HANDLERS.put("getMultiMemList", bjtj.class);
    SECONDARY_EVENT_HANDLERS.put("openTenpayView", TenpayPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("qWalletBridge", TenpayPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_groupUploadPhoto", bjtv.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_openUserQzoneHome", bjtv.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_importGroupAIO", bjtv.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_showGroupPhotoBrowser", bjtv.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_jumpGroupAlbumSendBox", bjtv.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_downloadGroupAlbumPhoto", bjtv.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_jumpCategoryAlbum", bjtv.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_pickQzoneAlbum", bjtv.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_start", bjtv.class);
    SECONDARY_EVENT_HANDLERS.put("tim_space", bjtu.class);
    SECONDARY_EVENT_HANDLERS.put("uploadAvatar", bjtr.class);
    SECONDARY_EVENT_HANDLERS.put("tdoc_channel", bjtt.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_opendiscover", bjto.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_opendetail", bjto.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_openhomepage", bjto.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_getdeviceinfo", bjto.class);
    SECONDARY_EVENT_HANDLERS.put("weiyunDownload", bjue.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_qzoneUploadAndPublish", bjtp.class);
    SECONDARY_EVENT_HANDLERS.put("refreshQzoneFeed", bjtq.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_invokeGYCamera", bjtl.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_uploadRes", bjti.class);
    SECONDARY_EVENT_HANDLERS.put("invokeGameBuddyAio", bjtf.class);
    SECONDARY_EVENT_HANDLERS.put("checkGameBuddyType", bjtf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.ExtJsPluginScope
 * JD-Core Version:    0.7.0.1
 */