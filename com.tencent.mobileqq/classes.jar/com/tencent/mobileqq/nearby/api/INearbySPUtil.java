package com.tencent.mobileqq.nearby.api;

import android.content.SharedPreferences;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface INearbySPUtil
  extends QRouteApi
{
  public static final String CONFIG_SHOW_DATE = "config_show_date";
  public static final String CONFIG_SHOW_RANK = "config_show_rank";
  public static final String DATING_LAST_EVENTID = "dating_last_event_id";
  public static final String DATING_READ_EVENTID = "dating_read_event_id";
  public static final String FRESHFEED_LAST_EVENTID = "freshfeed_last_event_seq";
  public static final String FRESHFEED_READ_EVENTID = "freshfeed_red_event_seq";
  public static final String FRESHNEWS_TAB_SWITCH = "ShowFreshNews";
  public static final String HOTCHAT_DEMO_SWITCH = "supportHotChatDemo";
  public static final String HOTCHAT_TAB_SWITCH = "hotchat_tab_switch";
  public static final String KEY_APP_ID = "key_app_id";
  public static final String KEY_AUTOENTER_WITHOUTREDOT = "key_auto_enter_without_redot";
  public static final String KEY_BANNER_ENTER_ITEMS = "key_banner_enter_items";
  public static final String KEY_CIKE_GUIDE_CONTENT = "cike_guide_content";
  public static final String KEY_CONFIG_VERSION = "key_config_ver";
  public static final String KEY_EXPIRED_BANNER = "key_expired_banner";
  public static final String KEY_HAS_NEW_BANNER = "has_new_banner";
  public static final String KEY_LAST_CONFIG_TIME = "key_last_config_time";
  public static final String KEY_LAST_NEARBY_LOC = "key_nearby_loc";
  public static final String KEY_MSG_BOX_COMMENT_ZAN_RED_DOT_TYPE = "key_nearby_msg_box_comment_zan_msg_type";
  public static final String KEY_MSG_BOX_SAY_HELLO_RED_DOT_TYPE = "key_nearby_msg_box_say_hello_msg_type";
  public static final String KEY_NEARBY_FACE_SCORE_SWITCH = "face_score_switch";
  public static final String KEY_NEARBY_MINE_URL = "nearby_mine_page_url";
  public static final String KEY_NEARBY_MSG_TAB_LAST_RED_NUM = "nearby_msg_tab_last_num";
  public static final String KEY_NEARBY_MYTAB_ZAN_CHECK = "key_nearby_mytab_zan_check";
  public static final String KEY_NEARBY_NOW_QQ_CONNECT_AUTH_TIME = "key_nearby_now_qq_connect_auth_time";
  public static final String KEY_NEARBY_PUBLISH_MENU = "key_nearby_publish_menu";
  public static final String KEY_NEARBY_PUSH_SIGIN_REDTOUCH = "key_nearby_push_signin_redtouch";
  public static final String KEY_NEARBY_RED_DOT_ASSIST_TEXT = "key_nearby_red_dot_assist_text";
  public static final String KEY_NEARBY_RED_DOT_CORNER_TEXT = "key_nearby_red_dot_corner_text";
  public static final String KEY_NEARBY_SELECT_PIC = "key_nearby_select_pic";
  public static final String KEY_NEARBY_TAB_URL_PARAMS = "nearby_tab_url_params";
  public static final String KEY_NEARBY_USERCARD_PUBLISH = "nearby_usercard_publish";
  public static final String KEY_NEARBY_USERCARD_TAB_GUEST = "nearby_usercard_tab_guest";
  public static final String KEY_NEARBY_USERCARD_TAB_HOST = "nearby_usercard_tab_host";
  public static final String KEY_NEARBY__LIVE_TAB_URL_PARAMS = "nearby_live_tab_url_params";
  public static final String KEY_NOTIFY_SWITCH_STATE = "key_notify_switch_state";
  public static final String KEY_NOW_IP_CONN_SWITCH = "now_ip_conn_switch";
  public static final String KEY_PRELOAD_FAIL_COUNT = "key_preload_fail_count";
  public static final String KEY_PRELOAD_UNHIT_COUNT = "key_preload_unhit_count";
  public static final String KEY_TABS_ARRAY = "key_tabs_array";
  public static final String KEY_TABS_CONFIG_VERSION = "key_tabs_config_version";
  public static final String KEY_WEREWOLVES_CONFIG = "werewolves_config";
  public static final int MAX_PRELOAD_FAIL_COUNT = 2;
  public static final int MAX_PRELOAD_UNHIT_COUNT = 2;
  public static final String NEARBY_ENTER_TIME = "nearby_enter_time";
  public static final String NEARBY_EVENT_FILE = "nearby_event_file";
  public static final String NEARBY_PROCESS_PRELOAD_FILE = "nearby_process_preload_file";
  public static final String NEARBY_SP_UPGRADE_FLAG = "nearby_sp_upgrade_flag";
  public static final String NEARBY_TROOP_TITLE = "nearby_troop_title";
  public static final String NEARBY_VISITOR_FILE = "nearby_visitor_file";
  public static final String NOW_NEARBY_1V1_OPEN_SWITCH = "now_nearby_1v1_open_switch";
  public static final String NOW_NEARBY_CHANGE_TIMES = "now_nearby_change_times";
  public static final String NOW_NEARBY_MATCH_SECS = "now_nearby_match_secs";
  public static final String NOW_NEARBY_MATCH_TIMES = "now_nearby_match_times";
  public static final String RANK_LAST_EVENTID = "rank_last_event_seq";
  public static final String RANK_READ_EVENTID = "rank_read_event_seq";
  public static final String SP_FILE_NAME_MYTAB = "sp_nearby_mytab";
  public static final String SP_FILE_NAME_NEWFRESH = "NEW_FRESH_SP";
  public static final String SP_KEY_DISCLAIMER_OK = "nearby_people_disclaimer_ok_5.8.0";
  public static final String SP_KEY_HISTORY_VALID = "history_valid";
  public static final String SP_KEY_HIS_VISITOR = "sp_nearby_his_visitor";
  public static final String SP_KEY_IS_NEARBY_NOVICE = "is_nearby_novice";
  public static final String SP_KEY_IS_NEED_SHOW_GUID = "nearby_need_show_guide";
  public static final String SP_KEY_IS_USER_SKIPGUIDE = "sp_key_user_skip_guide";
  public static final String SP_KEY_NEW_VISITOR = "sp_nearby_new_visitor";
  public static final String SP_KEY_QQ_AVATAR_TYPE = "qq_avatar_type";
  public static final String SP_KEY_SCHOOL_NAME = "school_name";
  public static final String SP_KEY_SCHOOL_VALID_STATE = "school_valid_state";
  public static final String SP_KEY_SELF_AGE = "self_age";
  public static final String SP_KEY_SELF_GENDER = "self_gender";
  public static final String SP_KEY_SELF_GOD_FLAG = "self_god_flag";
  public static final String SP_KEY_SELF_NICK = "self_nick";
  public static final String SP_KEY_SELF_SCHOOL_NAME = "self_school_name";
  public static final String SP_KEY_SELF_THIRD_LINE_ICON = "self_third_line_icon";
  public static final String SP_KEY_SELF_THIRD_LINE_INFO = "self_third_line_info";
  public static final String SP_KEY_SELF_TINNYID = "self_tinnyid";
  public static final String SP_KEY_TEMP_SCHOOLNAME = "temp_school_name";
  public static final String SP_KEY_TEMP_VALIDATE = "temp_validate";
  public static final String SP_KEY_TOTAL_VISITOR = "sp_nearby_total_visitor";
  public static final String SP_KEY_UPLOAD_AVATAR_OK = "nearby_people_avatar_upload_ok";
  public static final String SP_NEARBY_URL_PARAMS = "nearby_url_params";
  public static final String TOPLIST_SP_HIDE_BOYGOD_SEQ = "toplist_hide_boygod_seq";
  public static final String UNREAD_COUNT_DATE = "unread_count_date";
  public static final String UNREAD_COUNT_FRESHNEWS = "unread_count_freshnews";
  public static final String UNREAD_COUNT_RANK = "unread_count_rank";
  public static final int VALUE_COMMENT_ZAN_RED_DOT_NORMAL = 1;
  public static final int VALUE_COMMENT_ZAN_RED_DOT_NUM = 0;
  public static final int VALUE_SAY_HELLO_RED_DOT_NORMAL = 1;
  public static final int VALUE_SAY_HELLO_RED_DOT_NUM = 0;
  public static final String VOTE_COUNT = "vote_count";
  public static final String VOTE_INCREMENT = "vote_increment";
  
  public abstract boolean checkMode(int paramInt);
  
  public abstract boolean checkPreload(String paramString);
  
  public abstract void clearCornerRedDot(String paramString);
  
  public abstract boolean contains(String paramString1, String paramString2);
  
  public abstract boolean contains(String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract void enterNearbyProcess(String paramString);
  
  public abstract boolean getDatingSessionSwitch(String paramString);
  
  public abstract String getLiveTabWebViewUrlByJson();
  
  public abstract boolean getLocVisiblityForPeople(String paramString);
  
  public abstract SosoLbsInfo getNearbyLastLocation(String paramString);
  
  public abstract String getNearbyTabUrlParams();
  
  public abstract boolean getNotifySwitchState(String paramString);
  
  public abstract SharedPreferences getSharedPreferences(String paramString1, String paramString2, int paramInt);
  
  public abstract int getUnreadCount(String paramString1, String paramString2);
  
  public abstract String getUrlJsonToStr(String paramString);
  
  public abstract Object getValue(SharedPreferences paramSharedPreferences, String paramString, Object paramObject);
  
  public abstract Object getValue(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject);
  
  public abstract Object getValue(String paramString1, String paramString2, Object paramObject);
  
  public abstract Object[] getVoteInfo(String paramString);
  
  public abstract boolean isNeedNearbyShowGuide(String paramString);
  
  public abstract boolean isObtainLocAllowed(String paramString);
  
  public abstract JSONObject mergeJson(JSONObject paramJSONObject1, JSONObject paramJSONObject2);
  
  public abstract void preloadNearbyProcessStart(String paramString);
  
  public abstract void preloadNearbyProcessSuc(String paramString);
  
  public abstract void saveLiveTabWebViewUrlParam(String paramString);
  
  public abstract void saveNearbyTabUrlParams(String paramString);
  
  public abstract void setNearbyLastLocation(String paramString, SosoLbsInfo paramSosoLbsInfo);
  
  public abstract void setNotifySwitchState(String paramString, boolean paramBoolean);
  
  public abstract boolean setObtainLocAllowed(String paramString, boolean paramBoolean);
  
  public abstract boolean setValue(SharedPreferences paramSharedPreferences, String paramString, Object paramObject);
  
  public abstract boolean setValue(String paramString1, String paramString2, int paramInt, String paramString3, Object paramObject);
  
  public abstract boolean setValue(String paramString1, String paramString2, Object paramObject);
  
  public abstract boolean setVisibilityForPeople(String paramString, boolean paramBoolean);
  
  public abstract boolean setVoteInfo(String paramString, long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.INearbySPUtil
 * JD-Core Version:    0.7.0.1
 */