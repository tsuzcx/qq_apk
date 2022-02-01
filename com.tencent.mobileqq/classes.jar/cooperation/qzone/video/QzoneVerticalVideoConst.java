package cooperation.qzone.video;

import android.content.Intent;

public class QzoneVerticalVideoConst
{
  public static final int BUSINESS_TYPE = 1;
  public static final int BUSINESS_TYPE_AIO = 7;
  public static final int BUSINESS_TYPE_PASS_FEED = 6;
  public static final int BUSINESS_TYPE_QQ_PROFILE_CARD = 3;
  public static final int BUSINESS_TYPE_QQ_SETTING = 4;
  public static final int BUSINESS_TYPE_QZONE_BANNER = 1;
  public static final int BUSINESS_TYPE_QZONE_PERSONAL_PAGE = 2;
  public static final int BUSINESS_TYPE_VIDEO_STORY_AGGREGATE = 5;
  public static final int BUSINESS_TYPE_VIDEO_STORY_PUSH = 8;
  public static final int DEFAULT_REQUEST_FROM_FEEDS = 0;
  public static final int DEFAULT_REQUEST_FROM_RECENT_VIDEO = 1;
  public static final String KEY_BACKUP_URL = "key_backup_url";
  public static final String KEY_CURRENT_FEEDUIN = "key_current_feeduin";
  public static final String KEY_CURRENT_FEED_CELLID = "key_current_feed_cellid";
  public static final String KEY_CURRENT_FEED_NICK = "key_current_feed_nick";
  public static final String KEY_CURRENT_LOGIN_UIN = "key_current_login_uin";
  public static final String KEY_LANDSCAPE_MODE = "key_video_float_layer_landscape_mode";
  public static final String KEY_LANDSCAPE_MODE_REQ_TYPE = "key_video_float_layer_landscape_mode_req_type";
  public static final String KEY_LAUNCH_TIME = "key_launch_time";
  public static final String KEY_MODE = "key_mode";
  public static final String KEY_PLUGIN_ID = "key_plugin_id";
  public static final String KEY_REQUEST_BUSINESS_TYPE = "key_request_business_type";
  public static final String KEY_REQUEST_FROM = "key_request_from";
  public static final String KEY_REQUEST_SUB_BUSINESS_TYPE = "key_request_sub_business_type";
  public static final String KEY_SCHEME_REQUEST_FROM_BUSINESS_TYPE = "key_scheme_request_from_business_type";
  public static final String KEY_SUPPORTPIC = "support_pic";
  public static final String KEY_SUPPORT_DYNAMIC_VIDEO = "support_dynamic_video";
  public static final String KEY_VIDEO_STORY_JUMP_POSITION = "key_video_story_jump_position";
  public static final String KEY_VIDEO_STORY_SHARE_DATA_SOURCE_ID = "key_video_story_share_data_source_id";
  public static final String KEY_VIDEO_STORY_TRANPARENT_CELL_USER_INFO = "key_video_story_tranparent_cell_user_info";
  public static final String KEY_VIDEO_STORY_TRANPARENT_STORY_BANNER_DATA = "key_video_story_tranparent_story_banner_data";
  public static final String KEY_VIDEO_STORY_TRANPARENT_STORY_FEED = "key_video_story_tranparent_story_feed";
  public static final String KEY_VIDEO_STORY_TRANPARENT_VIDEO_RECOMMEND_INFO = "key_video_story_tranparent_video_recommend_info";
  public static final String KEY_VIDEO_WEISHI_FEEDS_TRACE_ID = "key_video_weishi_feeds_trace_id";
  public static final String KEY_VIDEO_WEISHI_LABEL_MY_VIDEO_INFO = "key_video_weishi_label_my_video_info";
  public static final String KEY_VIDEO_WEISHI_PUBLIC_ACCOUNT_FEED = "key_video_weishi_public_account_feed";
  public static final String KEY_VIDEO_WEISHI_PUBLIC_ACCOUNT_GLOBAL_CONFIG = "key_video_weishi_public_account_global_config";
  public static final String KEY_VIDEO_WEISHI_SERVER_RESPONSE_HEADER_MAP = "key_video_weishi_server_response_header_map";
  public static final String KEY_WEISHI_AGGREGATE_ID = "key_weishi_aggregate_id";
  public static final String KEY_WEISHI_AGGREGATE_NAME = "key_weishi_aggregate_name";
  public static final String KEY_WEISHI_ENTRANCE_TYPE = "key_weishi_entrance_type";
  public static final String KEY_WEISHI_FEEDS_BUSI_PARAMS = "key_weishi_feeds_busi_params";
  public static final String KEY_WEISHI_FEEDS_ID = "key_weishi_feeds_id";
  public static final String KEY_WEISHI_FEEDS_UGCKEY = "key_weisi_feeds_ugckey";
  public static final String KEY_WEISHI_FEEDS_UIN = "key_weisi_feeds_uin";
  public static final String KEY_WEISHI_FEED_APPID = "key_weishi_feed_appid";
  public static final String KEY_WEISHI_FUNCTIONID = "key_weishi_functionid";
  public static final String KEY_WEISHI_PUSH_MSG_DATA = "key_weishi_push_msg_data";
  public static final String KEY_WEISHI_ROOFTOP_FEEDS_ID = "key_weishi_rooftop_feeds_id";
  public static final String KEY_WEISHI_SCENE_TYPE = "key_weishi_scene_type";
  public static final int REQUEST_FROM_FRIEND_VIDEO_STORY = 2;
  public static final int REQUEST_FROM_MINI_APP_CONTAINER = 6;
  public static final int REQUEST_FROM_PERSONAL_VIDEO_STORY_AGGREGATE = 4;
  public static final int REQUEST_FROM_PERSONAL_VIDEO_STORY_FLOW = 3;
  public static final int REQUEST_FROM_WEISHI = 5;
  public static final String RESULT_FINISH_VIDEO_COMPONENT = "finish_video_component";
  public static final String SP_KEY_SUPPORT_TRIM = "support_trim";
  public static final String WEISHI_KEY_SCENE_TYPE = "key_weishi_scene_type";
  public static final int WEISHI_SCENE_PUBLIC_ACCOUNT = 2;
  public static final int WEISHI_SCENE_TRENDS_TAB = 6;
  
  public static boolean isRequestVideoStoryBusiness(Intent paramIntent)
  {
    if (paramIntent != null) {}
    try
    {
      if (paramIntent.hasExtra("key_request_business_type"))
      {
        int i = paramIntent.getIntExtra("key_request_business_type", 0);
        if ((i >= 1) && (i <= 7)) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramIntent) {}
    return false;
  }
  
  public static boolean isRequestVideoWeishiPublicAccount(Intent paramIntent)
  {
    if (paramIntent != null) {}
    try
    {
      if (paramIntent.hasExtra("key_request_from"))
      {
        int i = paramIntent.getIntExtra("key_request_from", 0);
        if (i == 5) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramIntent) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVerticalVideoConst
 * JD-Core Version:    0.7.0.1
 */