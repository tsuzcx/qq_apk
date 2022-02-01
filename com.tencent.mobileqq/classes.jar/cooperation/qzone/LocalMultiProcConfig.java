package cooperation.qzone;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class LocalMultiProcConfig
{
  public static final int CLOSE = 2;
  public static final int MOBILE_AND_WIFI = 1;
  public static final int NO_INIT = -1;
  public static final int ONLY_WIFI = 0;
  public static final String PEFORMANCE_CONFIG = "QZ_Per_Config";
  private static final String PREFS_NAME_4_UIN_DEFAULT = "QZ_QQ_shared_preference";
  @Deprecated
  public static final String PREFS_NAME_LOCAL_QZ_SETTING = "QZ_setting";
  public static final String PREFS_NAME_MULTI_QZ_SETTING = "Qzone_multi_setting";
  public static final String PREFS_NAME_PHOTOPLUS_SETTING = "paster_setting";
  public static final String PREFS_NAME_QZ_QQ_SETTING = "QZ_QQ_shared_setting";
  public static final String PREFS_NAME_QZ_SETTING = "Qz_setting";
  public static final String PREFS_NAME_QZ_VIDEO_SETTING = "QZ_video_shared_setting";
  public static String PROCESS_NAME = "com.tencent.mobileqq:qzone";
  public static final String QCIRCLE_PUBLISH_SELECTED_GRID_SAVE = "qcircle_publish_selected_grid_save";
  public static final String QCIRCLE_REDPOINT_GREY_TROOP_UIN = "qcircle_redpoint_grey_troop_uin";
  public static final String QCIRCLE_TROOP_REDPOINT_GREY_LAST_TIMESTAMP = "qcircle_troop_redpoint_grey_last_timestamp";
  public static final String QCIRCLE_TROOP_REDPOINT_GREY_TIME_THRESHOLD = "qcircle_troop_redpoint_grey_time_threshold";
  public static final String QCIRCLE_TROOP_REDPOINT_PULL_AMOUNT_THRESHOLD = "qcircle_troop_redpoint_pull_amount_threshold";
  public static final String QCIRCLE_TROOP_REDPOINT_PULL_TIME_THRESHOLD = "qcircle_troop_redpoint_pull_time_threshold";
  public static final String QZONE_ALBUM_DLNA_SWITCH = "QZone_dlnaSwitch";
  public static final String QZONE_ALBUM_RECOMM_EXPOSE_COUNTS = "qzone_album_recomm_expose_counts";
  public static final String QZONE_ALBUM_RECOMM_GREYINFO = "qzone_album_recomm_grey_info";
  public static final String QZONE_BARRAGE_EFFECT_ENABLED = "qzone_barrage_effect_enabled";
  public static final String QZONE_BARRAGE_EFFECT_SAVE_DATA = "qzone_barrage_effect_save_data";
  public static final String QZONE_CAMPUSINFO_SCHOOLNAME = "qzone_campusInfo_name";
  public static final String QZONE_CAMPUSINFO_SCHOOL_ID = "qzone_campusInfo_school_id";
  public static final String QZONE_CAMPUSINFO_SCHOOL_IDX = "qzone_campusInfo_school_idx";
  public static final String QZONE_CAMPUSINFO_VERFYSTATUS = "qzone_campusInfo_verfyStatus";
  public static final String QZONE_CLEAR_CACHE_VERSION = "Qzone_clearCacheVersion";
  public static final String QZONE_CUSTOM_PRAISE_ENABLED = "qzone_custom_praise_enabled";
  public static final String QZONE_DIY_JUMP_URL = "qzone_diy_page_jump_url";
  public static final String QZONE_ENABLE_FEED_TAB = "qzone_enable_feed_tab";
  public static final String QZONE_ENABLE_FPS_MONITOR = "qzone_enable_fps_monitor";
  public static final String QZONE_FEED_CUSTOM_BROWSER_DECO_SWITCH = "qzone_feed_custom_browser_deco_switch";
  public static final String QZONE_FEED_SKIN_ENABLE = "qzone_feed_skin_enable";
  public static final String QZONE_FLUTTER_PREDOWNLOAD_SUCCESS = "qzone_flutter_predownload_success";
  public static final String QZONE_FONT_ENABLED = "qzone_font_enabled";
  public static final String QZONE_FONT_RED_DOT = "qzone_font_red_dot";
  public static final String QZONE_FONT_SAVE_DATA = "qzone_font_save_data";
  public static final String QZONE_FORCE_WEISHI_LAYER = "Qzone_force_weishilayer";
  public static final String QZONE_GPS_SWITCH = "Qzone_gps_switch";
  public static final String QZONE_LARGE_FONT_SAVE_DATA = "qzone_large_font_save_data";
  public static final String QZONE_PASSIVE_PRAISE_ENABLED = "qzone_passive_praise_enabled";
  public static final String QZONE_SET_APM_DROP = "Qzone_setApm_drop";
  public static final String QZONE_SET_APM_IO = "Qzone_setApm_io";
  public static final String QZONE_SET_APM_MEM = "Qzone_setApm_mem";
  public static final String QZONE_SET_APM_MEMLEAK = "Qzone_setApm_MemLeak";
  @Deprecated
  public static final String QZONE_SET_GIFPLAYMODE = "Qzone_setGifplay";
  public static final String QZONE_SET_PLAYMODE = "Qzone_playMode";
  @Deprecated
  public static final String QZONE_SET_VIDEOPLAYMODE = "Qzone_setVideoplay";
  public static final String QZONE_SOUND_EFFECT_ENABLED = "qzone_sound_effect_enabled";
  public static final String QZONE_SUPER_FONT_ENABLED = "qzone_super_font_enabled";
  public static final String QZONE_SUPER_FONT_SAVE_DATA = "qzone_super_font_save_data";
  public static final String QZONE_SYNC_KUOLIE = "QZone_synckuolie";
  public static final String QZONE_TROOP_REDPOINT_PULL_AMOUNT_THRESHOLD = "qzone_troop_redpoint_pull_amount_threshold";
  public static final String QZONE_TROOP_REDPOINT_PULL_TIME_THRESHOLD = "qzone_troop_redpoint_pull_time_threshold";
  public static final String QZONE_WATER_MARK = "WaterMark";
  public static final String QZONE_WNS_NET_CLOSE = "qzone_wns_net";
  public static final String SHARPP_SO_MD5_AND_LENGTH = "sharpPSoMD5AndLength";
  public static final String SHARPP_SO_PREVIOUS_VERSION_MD5_AND_LENGTH = "sharpPSoMD5AndLength_previous";
  private static final int StateLoading = 0;
  private static final int StateNotReady = -1;
  private static final int StateReady = 1;
  private static final String TAG = "LocalMultiProcConfig";
  public static final String WIDGET_CONFIG_PREFIX = "Widget_";
  public static Map<String, ?> acountMap;
  private static int cacheState = -1;
  public static Map<String, ?> defultMap;
  
  public static void clearAllConfig()
  {
    if (cacheState != 1) {
      return;
    }
    Map localMap = defultMap;
    if (localMap != null) {
      localMap.clear();
    }
    localMap = acountMap;
    if (localMap != null) {
      localMap.clear();
    }
  }
  
  @SuppressLint({"NewApi"})
  private static void commitEditor(SharedPreferences.Editor paramEditor)
  {
    if (Build.VERSION.SDK_INT < 9)
    {
      paramEditor.commit();
      return;
    }
    paramEditor.apply();
  }
  
  public static boolean containKey(String paramString1, String paramString2)
  {
    return getPreferences(paramString1).contains(paramString2);
  }
  
  public static boolean getBool(String paramString1, String paramString2, boolean paramBoolean)
  {
    Map localMap = defultMap;
    if ((localMap != null) && (localMap.containsKey(paramString2)) && ((defultMap.get(paramString2) instanceof Boolean))) {
      return ((Boolean)defultMap.get(paramString2)).booleanValue();
    }
    return getPreferences(paramString1).getBoolean(paramString2, paramBoolean);
  }
  
  public static boolean getBool(String paramString, boolean paramBoolean)
  {
    return getBool("QZ_QQ_shared_setting", paramString, paramBoolean);
  }
  
  public static int getInt(String paramString, int paramInt)
  {
    return getInt("QZ_QQ_shared_setting", paramString, paramInt);
  }
  
  public static int getInt(String paramString1, String paramString2, int paramInt)
  {
    Map localMap = defultMap;
    if ((localMap != null) && (localMap.containsKey(paramString2)) && ((defultMap.get(paramString2) instanceof Integer))) {
      return ((Integer)defultMap.get(paramString2)).intValue();
    }
    return getPreferences(paramString1).getInt(paramString2, paramInt);
  }
  
  public static int getInt4Uin(String paramString, int paramInt, long paramLong)
  {
    Map localMap = acountMap;
    if ((localMap != null) && (localMap.containsKey(paramString)) && ((acountMap.get(paramString) instanceof Integer))) {
      return ((Integer)acountMap.get(paramString)).intValue();
    }
    return getPreferences4Uin(paramLong).getInt(paramString, paramInt);
  }
  
  public static int getInt4UinString(String paramString1, int paramInt, String paramString2)
  {
    Map localMap = acountMap;
    if ((localMap != null) && (localMap.containsKey(paramString1)) && ((acountMap.get(paramString1) instanceof Integer))) {
      return ((Integer)acountMap.get(paramString1)).intValue();
    }
    try
    {
      int i = getPreferences4Uin(Long.valueOf(paramString2).longValue()).getInt(paramString1, paramInt);
      return i;
    }
    catch (NumberFormatException paramString1) {}
    return paramInt;
  }
  
  public static long getLong(String paramString, long paramLong)
  {
    Map localMap = defultMap;
    if ((localMap != null) && (localMap.containsKey(paramString)) && ((defultMap.get(paramString) instanceof Long))) {
      return ((Long)defultMap.get(paramString)).longValue();
    }
    return getPreferences("QZ_QQ_shared_setting").getLong(paramString, paramLong);
  }
  
  public static long getLong(String paramString1, String paramString2, long paramLong)
  {
    return getPreferences(paramString1).getLong(paramString2, paramLong);
  }
  
  public static long getLong4Uin(String paramString, long paramLong1, long paramLong2)
  {
    Map localMap = acountMap;
    if ((localMap != null) && (localMap.containsKey(paramString)) && ((acountMap.get(paramString) instanceof Long))) {
      return ((Long)acountMap.get(paramString)).longValue();
    }
    return getPreferences4Uin(paramLong2).getLong(paramString, paramLong1);
  }
  
  @SuppressLint({"InlinedApi"})
  private static SharedPreferences getPreferences(String paramString)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    return localMobileQQ.getSharedPreferences(paramString, i);
  }
  
  private static SharedPreferences getPreferences4Uin(long paramLong)
  {
    if (paramLong == 0L) {
      return getPreferences("QZ_QQ_shared_setting");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("_");
    localStringBuilder.append("QZ_QQ_shared_preference");
    return getPreferences(localStringBuilder.toString());
  }
  
  public static String getString(String paramString1, String paramString2)
  {
    return getString("QZ_QQ_shared_setting", paramString1, paramString2);
  }
  
  public static String getString(String paramString1, String paramString2, String paramString3)
  {
    Map localMap = defultMap;
    if ((localMap != null) && (localMap.containsKey(paramString2)) && ((defultMap.get(paramString2) instanceof String))) {
      return (String)defultMap.get(paramString2);
    }
    return getPreferences(paramString1).getString(paramString2, paramString3);
  }
  
  public static String getString4Uin(String paramString1, String paramString2, long paramLong)
  {
    Map localMap = acountMap;
    if ((localMap != null) && (localMap.containsKey(paramString1)) && ((acountMap.get(paramString1) instanceof String))) {
      return (String)acountMap.get(paramString1);
    }
    return getPreferences4Uin(paramLong).getString(paramString1, paramString2);
  }
  
  public static void loadAllConfig()
  {
    QLog.d("LocalMultiProcConfig", 4, "loadAllConfig");
    if (cacheState == 0) {
      return;
    }
    defultMap = getPreferences("QZ_QQ_shared_setting").getAll();
    if (!TextUtils.isEmpty(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
      localStringBuilder.append("_");
      localStringBuilder.append("QZ_QQ_shared_preference");
      acountMap = getPreferences(localStringBuilder.toString()).getAll();
      return;
    }
    QLog.d("LocalMultiProcConfig", 1, "uin is 0");
  }
  
  public static void putBool(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = getPreferences(paramString1).edit();
    paramString1.putBoolean(paramString2, paramBoolean);
    commitEditor(paramString1);
  }
  
  public static void putBool(String paramString, boolean paramBoolean)
  {
    putBool("QZ_QQ_shared_setting", paramString, paramBoolean);
  }
  
  public static void putBooleanAsync(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.post(new LocalMultiProcConfig.1(paramString1, paramString2, paramBoolean), 8, null, true);
  }
  
  public static void putBooleanAsync(String paramString, boolean paramBoolean)
  {
    putBooleanAsync("QZ_QQ_shared_setting", paramString, paramBoolean);
  }
  
  public static void putInt(String paramString, int paramInt)
  {
    putInt("QZ_QQ_shared_setting", paramString, paramInt);
  }
  
  public static void putInt(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = getPreferences(paramString1).edit();
    paramString1.putInt(paramString2, paramInt);
    commitEditor(paramString1);
  }
  
  public static void putInt4Uin(String paramString, int paramInt, long paramLong)
  {
    SharedPreferences.Editor localEditor = getPreferences4Uin(paramLong).edit();
    localEditor.putInt(paramString, paramInt);
    commitEditor(localEditor);
  }
  
  public static void putLong(String paramString, long paramLong)
  {
    putLong("QZ_QQ_shared_setting", paramString, paramLong);
  }
  
  public static void putLong(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = getPreferences(paramString1).edit();
    paramString1.putLong(paramString2, paramLong);
    commitEditor(paramString1);
  }
  
  public static void putLong4Uin(String paramString, long paramLong1, long paramLong2)
  {
    SharedPreferences.Editor localEditor = getPreferences4Uin(paramLong2).edit();
    localEditor.putLong(paramString, paramLong1);
    commitEditor(localEditor);
  }
  
  public static void putString(String paramString1, String paramString2)
  {
    putString("QZ_QQ_shared_setting", paramString1, paramString2);
  }
  
  public static void putString(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = getPreferences(paramString1).edit();
    paramString1.putString(paramString2, paramString3);
    commitEditor(paramString1);
  }
  
  public static void putString4Uin(String paramString1, String paramString2, long paramLong)
  {
    SharedPreferences.Editor localEditor = getPreferences4Uin(paramLong).edit();
    localEditor.putString(paramString1, paramString2);
    commitEditor(localEditor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.LocalMultiProcConfig
 * JD-Core Version:    0.7.0.1
 */