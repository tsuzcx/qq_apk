package com.tencent.mobileqq.flashshow.api.constants;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.IVFSAssistantApi;

public class FSConstants
{
  public static final String[] CONSTELLATION_LIST = { "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座", "水瓶座", "双鱼座" };
  public static final String FS_CACHE_PRIVATE_ROOT_PATH;
  public static final String FS_DOWNLOAD_ROOT_PATH;
  public static final String FS_FEEDCLOUD_APPID = "95";
  public static final String FS_FEED_TYPE_PERSONAL_PRAISED = "fs_feed_type_personal_praised";
  public static final String FS_FEED_TYPE_PERSONAL_PRODUCTION = "fs_feed_type_personal_production";
  public static final String FS_FILE_PRIVATE_ROOT_PATH;
  public static final String FS_FOLLOW_TAB_CMD = "QflashSvr.trpc.qflash.commreader.ComReader.GetFeedListFollow";
  public static final String FS_KEY_BUNDLE_PERSONAL_USER_UIN = "fs_key_bundle_personal_user_uin";
  public static final String FS_KEY_TRANS_BADGE_EXT = "BadgeExtInfo";
  private static final String FS_PRIVATE_ROOT_PATH = ((IVFSAssistantApi)QRoute.api(IVFSAssistantApi.class)).getSDKPrivatePath("flash_show/");
  public static final String FS_RCMD_TAB_CMD = "QflashSvr.trpc.qflash.commreader.ComReader.GetFeedListRecom";
  public static final String JS_PLUGIN_ACTION_UPDATE_USER_FOLLOW_STATE = "updateUserFollowState";
  public static final String JS_PLUGIN_NAMESPACE = "qflash";
  public static final String KEY_BUNDLE_COMMON_INIT_BEAN = "fs_key_bundle_common_init_bean";
  public static final String KEY_BUNDLE_INDIVIDUAL_FOLDER_PAGE = "fs_key_bundle_individual_folder_page";
  public static final String KEY_BUNDLE_OPEN_PAGE_TIME = "key_bundle_open_page_time";
  public static final int REQUEST_CODE_AT_REQUEST_CODE = 256;
  public static final int TYPE_UPDATE_RED_POINT_DISPLAY = 1000;
  public static final String VALID_HOST = ".qq.com";
  public static final int WEB_COLOR_NOTE_QQ_CIRCLE = 3;
  public static final String WEB_COLOR_NOTE_TYPE = "web_color_note_type";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FS_PRIVATE_ROOT_PATH);
    localStringBuilder.append("file/");
    FS_FILE_PRIVATE_ROOT_PATH = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(FS_PRIVATE_ROOT_PATH);
    localStringBuilder.append("cache/");
    FS_CACHE_PRIVATE_ROOT_PATH = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(FS_FILE_PRIVATE_ROOT_PATH);
    localStringBuilder.append("download/");
    FS_DOWNLOAD_ROOT_PATH = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.constants.FSConstants
 * JD-Core Version:    0.7.0.1
 */