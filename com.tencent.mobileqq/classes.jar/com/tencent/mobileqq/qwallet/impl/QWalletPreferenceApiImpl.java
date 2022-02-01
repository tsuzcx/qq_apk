package com.tencent.mobileqq.qwallet.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class QWalletPreferenceApiImpl
  implements IQWalletPreferenceApi
{
  public static final String KEY_DRAW_LAST_SUCC_MODEL = "key_draw_hb_last_succ_model";
  public static final String KEY_F2F_REDPACK_ENTRY = "F2FRedpackEntry";
  public static final String KEY_F2F_REDPACK_ENTRY_COLOR_BEGIN_TIME = "F2FRedpack_EntryColorBeginTime";
  public static final String KEY_F2F_REDPACK_ENTRY_COLOR_END_TIME = "F2FRedpack_EntryColorEndTime";
  public static final String KEY_F2F_REDPACK_GIF = "F2FRedpackGIF";
  public static final String KEY_F2F_REDPACK_QR_CHECK = "F2FRedpackQRCheck";
  public static final String KEY_IDIOM_MATCH_IN_PHONE = "idiom_match_in_phone";
  public static final String KEY_LAST_TENSORFLOW_LIB = "key_last_tensorflow_lib";
  public static final String KEY_PREFIX_LAST_SUCC = "key_last_succ_";
  public static final String KEY_PRELOAD_CONTROL_BIG_FILE_DELAY = "deal_delay_interval";
  public static final String KEY_PRELOAD_CONTROL_NEED_WAIT_SIZE = "need_wait_size";
  public static final String KEY_PRIVACY_HAS_CLICK_AGREE = "privacy_has_click_agree";
  public static final String KEY_QWALLET_LAST_CLEAR_NOTIFY_TIME = "qwallet_last_clear_notify_time_";
  public static final String KEY_REDPACK_POPWND_BEGIN_TIME = "redpack_popwnd_begin_time_";
  public static final String KEY_REDPACK_POPWND_CURRENT = "redpack_popwnd_current_";
  public static final String KEY_REDPACK_POPWND_END_TIME = "redpack_popwnd_end_time_";
  public static final String KEY_REDPACK_POPWND_FREQ = "redpack_popwnd_freq_";
  public static final String KEY_REDPACK_POPWND_GROUP_TYPE = "redpack_popwnd_group_type_";
  public static final String KEY_REDPACK_POPWND_ID = "redpack_popwnd_id";
  public static final String KEY_REDPACK_POPWND_LAST_SHOW_TIME = "redpack_popwnd_last_show_time_";
  public static final String KEY_REDPACK_POPWND_NETWORK = "redpack_popwnd_network_";
  public static final String KEY_REDPACK_POPWND_STATE = "redpack_popwnd_state_";
  public static final String KEY_REDPACK_POPWND_TOTAL = "redpack_popwnd_total_";
  public static final String KEY_REDPACK_POPWND_URL = "redpack_popwnd_url_";
  public static final String KEY_REPORT_RANDOM = "download_report_random";
  public static final String KEY_SKIN_ENRTY_ERROR_TIPS = "skin_entry_error_tips";
  public static final String KEY_SPECIAL_SKIN_MAP = "skin_map";
  public static final String KEY_STRANGER_CHAT_EXT = "strangerchat_ext";
  public static final String KEY_VOICE_RECOGNIZE_IN_PHONE = "voice_recognieze_in_phone";
  public static final String KEY_VOICE_RECOGNIZE_IN_PHONE_TIPS = "voice_recognieze_in_phone_tips";
  public static final String PREF_KEY_CUR_SKIN_ID = "skin_id";
  public static final String PREF_KEY_SKIN_MD5 = "skin_md5";
  public static final String PREF_KEY_SKIN_RES_NUM = "skin_res_num";
  public static final String PREF_KEY_ZIP_URL = "zip_url";
  public static final String PREF_NAME_FOR_BIRTHDAY_REMINDER = "birthday_reminder_setting";
  public static final String PREF_NAME_QWALLET_SKIN = "qwallet_skin";
  public static final String PREF_NAME_SETTING = "qwallet_setting";
  
  private SharedPreferences getPreference(String paramString)
  {
    if (MobileQQ.getContext() != null) {
      return MobileQQ.getContext().getSharedPreferences(paramString, 4);
    }
    return null;
  }
  
  public boolean getBoolean(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (MobileQQ.getContext() != null)
    {
      SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("birthday_reminder_setting", 4);
      if (localSharedPreferences != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("_");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("_");
        localStringBuilder.append(paramString3);
        return localSharedPreferences.getBoolean(localStringBuilder.toString(), paramBoolean);
      }
    }
    return paramBoolean;
  }
  
  public boolean getBoolean(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getPreference("qwallet_setting");
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      return localSharedPreferences.getBoolean(localStringBuilder.toString(), paramBoolean);
    }
    return paramBoolean;
  }
  
  public int getInt(String paramString, int paramInt)
  {
    if (MobileQQ.getContext() != null)
    {
      SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("birthday_reminder_setting", 4);
      if (localSharedPreferences != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("_pack_count");
        return localSharedPreferences.getInt(localStringBuilder.toString(), paramInt);
      }
    }
    return paramInt;
  }
  
  public int getInt(String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences localSharedPreferences = getPreference("qwallet_setting");
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      return localSharedPreferences.getInt(localStringBuilder.toString(), paramInt);
    }
    return paramInt;
  }
  
  public long getLong(String paramString1, String paramString2, long paramLong)
  {
    SharedPreferences localSharedPreferences = getPreference("qwallet_setting");
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      return localSharedPreferences.getLong(localStringBuilder.toString(), paramLong);
    }
    return paramLong;
  }
  
  public String getString(String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences localSharedPreferences = getPreference("qwallet_setting");
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      return localSharedPreferences.getString(localStringBuilder.toString(), paramString3);
    }
    return paramString3;
  }
  
  public boolean isShowF2FRedpackEntryColor(String paramString)
  {
    SharedPreferences localSharedPreferences = getPreference("qwallet_setting");
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("F2FRedpack_EntryColorBeginTime");
      localStringBuilder.append(paramString);
      long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("F2FRedpack_EntryColorEndTime");
      localStringBuilder.append(paramString);
      long l2 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      if ((l3 > l1) && (l3 < l2)) {
        return true;
      }
    }
    return false;
  }
  
  public void putBoolean(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (MobileQQ.getContext() != null)
    {
      SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("birthday_reminder_setting", 4);
      if (localSharedPreferences != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("_");
        localStringBuilder.append(paramString2);
        localStringBuilder.append("_");
        localStringBuilder.append(paramString3);
        paramString1 = localStringBuilder.toString();
        localSharedPreferences.edit().putBoolean(paramString1, paramBoolean).commit();
      }
    }
  }
  
  public void putBoolean(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject = getPreference("qwallet_setting");
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).commit();
    }
  }
  
  public void putInt(String paramString, int paramInt)
  {
    if (MobileQQ.getContext() != null)
    {
      SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("birthday_reminder_setting", 4);
      if (localSharedPreferences != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("_pack_count");
        paramString = localStringBuilder.toString();
        localSharedPreferences.edit().putInt(paramString, paramInt).commit();
      }
    }
  }
  
  public void putInt(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = getPreference("qwallet_setting");
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), paramInt).commit();
    }
  }
  
  public void putLong(String paramString1, String paramString2, long paramLong)
  {
    Object localObject = getPreference("qwallet_setting");
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong).commit();
    }
  }
  
  public void putString(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = getPreference("qwallet_setting");
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString3).apply();
    }
  }
  
  public void removeSp(String paramString1, String paramString2)
  {
    Object localObject = getPreference("qwallet_setting");
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(paramString1);
      ((SharedPreferences.Editor)localObject).remove(localStringBuilder.toString()).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletPreferenceApiImpl
 * JD-Core Version:    0.7.0.1
 */