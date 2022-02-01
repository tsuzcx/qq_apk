package com.tencent.qqmini.sdk.core.generated;

import bkkn;
import bkkq;
import bkks;
import bkkv;
import bkkw;
import bkky;
import bklb;
import bkld;
import bkle;
import bklf;
import bklg;
import bkli;
import bklj;
import bklk;
import bkll;
import bklt;
import bklu;
import bkma;
import bknz;
import bkqb;
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
    EVENT_HANDLERS.put("addColorSign", bknz.class);
    EVENT_HANDLERS.put("addColorSignDirectly", bknz.class);
    EVENT_HANDLERS.put("addRecentColorSign", bknz.class);
    EVENT_HANDLERS.put("isColorSignExistSync", bknz.class);
    EVENT_HANDLERS.put("exitMiniProgram", bkqb.class);
    EVENT_HANDLERS.put("navigateBackMiniProgram", bkqb.class);
    EVENT_HANDLERS.put("navigateToMiniProgram", bkqb.class);
    EVENT_HANDLERS.put("showMiniAIOEntrance", bkma.class);
    EVENT_HANDLERS.put("hideMiniAIOEntrance", bkma.class);
    EVENT_HANDLERS.put("getCMShowInfo", bkkn.class);
    SECONDARY_EVENT_HANDLERS.put("requestWebSSO", bklt.class);
    SECONDARY_EVENT_HANDLERS.put("getGUID", bkkq.class);
    SECONDARY_EVENT_HANDLERS.put("sendMsg", bkli.class);
    SECONDARY_EVENT_HANDLERS.put("getMultiMemList", bkkw.class);
    SECONDARY_EVENT_HANDLERS.put("openTenpayView", TenpayPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("qWalletBridge", TenpayPlugin.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_groupUploadPhoto", bkll.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_openUserQzoneHome", bkll.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_importGroupAIO", bkll.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_showGroupPhotoBrowser", bkll.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_jumpGroupAlbumSendBox", bkll.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_downloadGroupAlbumPhoto", bkll.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_jumpCategoryAlbum", bkll.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_pickQzoneAlbum", bkll.class);
    SECONDARY_EVENT_HANDLERS.put("groupAlbum_start", bkll.class);
    SECONDARY_EVENT_HANDLERS.put("tim_space", bklk.class);
    SECONDARY_EVENT_HANDLERS.put("uploadAvatar", bklg.class);
    SECONDARY_EVENT_HANDLERS.put("tdoc_channel", bklj.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_opendiscover", bkld.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_opendetail", bkld.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_openhomepage", bkld.class);
    SECONDARY_EVENT_HANDLERS.put("qsubscribe_getdeviceinfo", bkld.class);
    SECONDARY_EVENT_HANDLERS.put("weiyunDownload", bklu.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_qzoneUploadAndPublish", bkle.class);
    SECONDARY_EVENT_HANDLERS.put("refreshQzoneFeed", bklf.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_invokeGYCamera", bkky.class);
    SECONDARY_EVENT_HANDLERS.put("checkin_uploadRes", bkkv.class);
    SECONDARY_EVENT_HANDLERS.put("setCMShowPetStatus", bkkn.class);
    SECONDARY_EVENT_HANDLERS.put("invokeGameBuddyAio", bkks.class);
    SECONDARY_EVENT_HANDLERS.put("checkGameBuddyType", bkks.class);
    SECONDARY_EVENT_HANDLERS.put("nowlive", bklb.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.generated.ExtJsPluginScope
 * JD-Core Version:    0.7.0.1
 */