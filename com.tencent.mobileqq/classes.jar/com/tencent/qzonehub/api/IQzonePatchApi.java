package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQzonePatchApi
  extends QRouteApi
{
  public static final String LIVE_PLUGIN_ID = "qzone_live_video_plugin_hack.apk";
  public static final String MM_REPORT = "qz_patch";
  public static final String PATCH_DIR = "patchs";
  public static final String QZONE_LIVE_FULL_PROCESS_NAME = "com.tencent.mobileqq:qzonelive";
  public static final String QZONE_VIDEO_VERTICAL_LAYER_FULL_PROCESS_NAME = "com.tencent.mobileqq:qzone";
  public static final String QZONE_WEISHI_FEEDS_FULL_PROCESS_NAME = "com.tencent.mobileqq:qzonelive";
  public static final String SP_LENGTH = "p_len";
  public static final String TAG = "com.tencent.qzonehub.api.IQzonePatchApi";
  public static final String VERTICAL_VIDEO_LAYER_PLUGIN_ID = "qzone_vertical_video_plugin.apk";
  public static final String VERTICAL_VIDEO_PLUGIN_NAME = "QZoneVerticalVideo";
  public static final String WEISHI_FEEDS_PLUGIN_ID = "qzone_weishi_feeds_plugin.apk";
  public static final String WEISHI_FEEDS_PLUGIN_NAME = "QZoneWeishiFeedsVideo";
  
  public abstract String getLoadQZoneLivePluginId();
  
  public abstract void getPatchList();
  
  public abstract void triggerQQDownloadPtuFilter();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQzonePatchApi
 * JD-Core Version:    0.7.0.1
 */