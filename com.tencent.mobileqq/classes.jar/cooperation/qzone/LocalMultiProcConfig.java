package cooperation.qzone;

import ambi;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;

public class LocalMultiProcConfig
{
  public static final String PEFORMANCE_CONFIG = "QZ_Per_Config";
  private static final String PREFS_NAME_4_UIN_DEFAULT = "QZ_QQ_shared_preference";
  public static final String PREFS_NAME_LOCAL_QZ_SETTING = "QZ_setting";
  public static final String PREFS_NAME_PHOTOPLUS_SETTING = "paster_setting";
  public static final String PREFS_NAME_QZ_QQ_SETTING = "QZ_QQ_shared_setting";
  public static final String PREFS_NAME_QZ_SETTING = "Qz_setting";
  public static final String PREFS_NAME_QZ_VIDEO_SETTING = "QZ_video_shared_setting";
  public static final String QZONE_ALBUM_DLNA_SWITCH = "QZone_dlnaSwitch";
  public static final String QZONE_BARRAGE_EFFECT_ENABLED = "qzone_barrage_effect_enabled";
  public static final String QZONE_BARRAGE_EFFECT_SAVE_DATA = "qzone_barrage_effect_save_data";
  public static final String QZONE_CLEAR_CACHE_VERSION = "Qzone_clearCacheVersion";
  public static final String QZONE_CUSTOM_PRAISE_ENABLED = "qzone_custom_praise_enabled";
  public static final String QZONE_FEED_SKIN_ENABLE = "qzone_feed_skin_enable";
  public static final String QZONE_FONT_ENABLED = "qzone_font_enabled";
  public static final String QZONE_FONT_RED_DOT = "qzone_font_red_dot";
  public static final String QZONE_FONT_SAVE_DATA = "qzone_font_save_data";
  public static final String QZONE_GPS_SWITCH = "Qzone_gps_switch";
  public static final String QZONE_LARGE_FONT_SAVE_DATA = "qzone_large_font_save_data";
  public static final String QZONE_PASSIVE_PRAISE_ENABLED = "qzone_passive_praise_enabled";
  public static final String QZONE_SETTING_GIF_PLAYING = "qzone_setting_gif_playing";
  public static final String QZONE_SET_APM_DROP = "Qzone_setApm_drop";
  public static final String QZONE_SET_APM_IO = "Qzone_setApm_io";
  public static final String QZONE_SET_APM_MEM = "Qzone_setApm_mem";
  public static final String QZONE_SET_APM_MEMLEAK = "Qzone_setApm_MemLeak";
  public static final String QZONE_SET_GIFPLAYMODE = "Qzone_setGifplay";
  public static final String QZONE_SET_VIDEOPLAYMODE = "Qzone_setVideoplay";
  public static final String QZONE_SUPER_FONT_ENABLED = "qzone_super_font_enabled";
  public static final String QZONE_SUPER_FONT_SAVE_DATA = "qzone_super_font_save_data";
  public static final String SHARPP_SO_MD5_AND_LENGTH = "sharpPSoMD5AndLength";
  public static final String SHARPP_SO_PREVIOUS_VERSION_MD5_AND_LENGTH = "sharpPSoMD5AndLength_previous";
  public static final String WIDGET_CONFIG_PREFIX = "Widget_";
  
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
  
  public static boolean getBool(String paramString1, String paramString2, boolean paramBoolean)
  {
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
    return getPreferences(paramString1).getInt(paramString2, paramInt);
  }
  
  public static int getInt4Uin(String paramString, int paramInt, long paramLong)
  {
    return getPreferences4Uin(paramLong).getInt(paramString, paramInt);
  }
  
  public static int getInt4UinString(String paramString1, int paramInt, String paramString2)
  {
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
    return getPreferences("QZ_QQ_shared_setting").getLong(paramString, paramLong);
  }
  
  public static long getLong(String paramString1, String paramString2, long paramLong)
  {
    return getPreferences(paramString1).getLong(paramString2, paramLong);
  }
  
  public static long getLong4Uin(String paramString, long paramLong1, long paramLong2)
  {
    return getPreferences4Uin(paramLong2).getLong(paramString, paramLong1);
  }
  
  @SuppressLint({"InlinedApi"})
  private static SharedPreferences getPreferences(String paramString)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0) {
      return localBaseApplicationImpl.getSharedPreferences(paramString, i);
    }
  }
  
  private static SharedPreferences getPreferences4Uin(long paramLong)
  {
    if (paramLong == 0L) {
      return getPreferences("QZ_QQ_shared_setting");
    }
    return getPreferences(paramLong + "_" + "QZ_QQ_shared_preference");
  }
  
  public static String getString(String paramString1, String paramString2)
  {
    return getString("QZ_QQ_shared_setting", paramString1, paramString2);
  }
  
  public static String getString(String paramString1, String paramString2, String paramString3)
  {
    return getPreferences(paramString1).getString(paramString2, paramString3);
  }
  
  public static String getString4Uin(String paramString1, String paramString2, long paramLong)
  {
    return getPreferences4Uin(paramLong).getString(paramString1, paramString2);
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
    ThreadManager.post(new ambi(paramString1, paramString2, paramBoolean), 8, null, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qzone.LocalMultiProcConfig
 * JD-Core Version:    0.7.0.1
 */