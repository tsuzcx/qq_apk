package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class SharedPreUtils
{
  protected static List a;
  
  public static int A(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("scribble_config_ver", 0);
  }
  
  public static int A(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("green_video_config_version_" + paramString, 0);
  }
  
  public static void A(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("scribble_gif_config_content", paramString);
    paramContext.commit();
  }
  
  public static void A(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "create_troop_max_invite_num", paramInt);
    paramContext.commit();
  }
  
  public static boolean A(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "user_guide_taste_tracking_sticker_tips_0", false);
  }
  
  public static int B(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qim_predownload_cfg_version", 0);
  }
  
  public static int B(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "video_compress_config_appid", 0);
  }
  
  public static void B(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("scribble_paint_config_content", paramString);
    paramContext.commit();
  }
  
  public static void B(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "aio_post_tab_plugin", paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat.aio_post_list_plugin", 2, "updateHotChatAIOPluginFlag,re:" + paramInt);
    }
    paramContext.commit();
  }
  
  public static int C(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qim_music_cfg_version", 0);
  }
  
  public static int C(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("video_compress_config_version_" + paramString, 0);
  }
  
  public static void C(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("scribble_switch_ver", paramString);
    paramContext.commit();
  }
  
  public static void C(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "show", paramInt);
    paramContext.commit();
  }
  
  public static int D(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qim_sticker_cfg_version", 0);
  }
  
  public static int D(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "search_config_version", 0);
  }
  
  public static void D(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("scribble_switch_config", paramString);
    paramContext.commit();
  }
  
  public static void D(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (paramInt == -1) {
      paramContext.remove(paramString + "_" + "quick_shot_share_to_story_config_version");
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.putInt(paramString + "_" + "quick_shot_share_to_story_config_version", paramInt);
    }
  }
  
  public static int E(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qim_faceu_cfg_version", 0);
  }
  
  public static int E(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "search_config_appid", 0);
  }
  
  public static void E(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "troop_effect_pic_guide", true);
    paramContext.commit();
  }
  
  public static void E(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "msg_box_inter_follow_unread_count", paramInt);
    paramContext.commit();
  }
  
  public static int F(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "poke_config_appid", 0);
  }
  
  public static void F(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "troop_online_member_guide", true);
    paramContext.commit();
  }
  
  public static void F(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "ark_service_type", paramInt);
    paramContext.commit();
  }
  
  public static int G(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "pa_subcribe_config_version", 0);
  }
  
  public static void G(Context paramContext, String paramString)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong(paramString + "_readinjoy_skin_guide_time", System.currentTimeMillis()).commit();
  }
  
  public static void G(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ark_ai_dict_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static int H(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "subscript_recommend_config_version" + "_" + "7.6.3.3565", 0);
  }
  
  public static void H(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "user_guide_taste_tracking_sticker_tips_3", true);
    paramContext.commit();
  }
  
  public static void H(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ark_at_babyq_guide_last_day_count_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static int I(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "redbag_fold_msg_config_version", 0);
  }
  
  public static void I(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "user_guide_taste_tracking_sticker_tips", true);
    paramContext.commit();
  }
  
  public static void I(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ark_at_babyq_guide_total_day_count_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static int J(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "poke_bar_config_version", 0);
  }
  
  public static void J(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "user_guide_taste_tracking_sticker_tips_0", true);
    paramContext.commit();
  }
  
  public static void J(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ark_ai_close_tip_count_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static int K(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "heads_up_notify_version", 0);
  }
  
  private static void K(Context paramContext, String paramString)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(paramContext);
    String str1 = "ark_qq_version_" + paramString;
    String str2 = ((SharedPreferences)localObject).getString(str1, "");
    if (!str2.equals("7.6.3"))
    {
      QLog.e("ArkApp.Config", 1, new Object[] { "QQ Version Changed, clear local config version, %s->%s", str2, "7.6.3" });
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(str1, "7.6.3");
      ((SharedPreferences.Editor)localObject).commit();
      G(paramContext, paramString, 0);
      z(paramContext, 0, paramString);
    }
  }
  
  public static void K(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("troop_pobing_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static int L(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "lbs_pack_version", 0);
  }
  
  public static void L(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("troop_gift_url_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static int M(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "kandian_hb_version", 0);
  }
  
  public static void M(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qq_pre_down_yyb_ver_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static int N(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("apollo_config_version" + paramString, 0);
  }
  
  public static void N(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("buluo_red_dot_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static int O(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "readinjoy_local_channel_config_version", 0);
  }
  
  public static void O(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "qqhead_syncqzone_checkedstate", paramInt);
    paramContext.commit();
  }
  
  public static int P(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "qwallet_setting_version", 0);
  }
  
  public static void P(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "qqhead_history_numflag", paramInt);
    paramContext.commit();
  }
  
  public static int Q(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "passwd_red_bag_setting_version", 0);
  }
  
  public static void Q(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("contact_recommend_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static int R(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "pstn_switch_wording_config_version", 0);
  }
  
  public static void R(Context paramContext, String paramString, int paramInt)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putInt("cu_open_card_guide_config_appid_" + paramString, paramInt).apply();
  }
  
  public static int S(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("pre_download_dialog_version" + paramString, 0);
  }
  
  public static void S(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("cu_open_card_guide_" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static int T(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("upgrade_tim_version" + paramString, 0);
  }
  
  public static void T(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("sticker_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static int U(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("photo_plus_sticker_version" + paramString, 0);
  }
  
  public static void U(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("webcgi_whitelist_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static int V(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("art_filter_version" + paramString, 0);
  }
  
  public static void V(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("doutu_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static int W(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "readinjoy_folder_config_version", 0);
  }
  
  public static void W(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "doutu_config_appid", paramInt);
    paramContext.commit();
  }
  
  public static int X(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "preload_config_version", 0);
  }
  
  public static void X(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("doutu_smart_default_count_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static int Y(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("readinjoy_merge_config_version_" + paramString, 0);
  }
  
  public static void Y(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "troop_robot_panel_version", paramInt);
    paramContext.commit();
  }
  
  public static int Z(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("readinjoy_crop_and_group_version_3565_" + paramString, 0);
  }
  
  public static void Z(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "video_redbag_config_appid", paramInt);
    paramContext.commit();
  }
  
  public static int a(int paramInt, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getInt("lastSeq" + paramInt + paramString, 0);
  }
  
  public static int a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("AvWeakNet_video_version_code", 0);
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("entry_config_verion_code_" + paramString, 0);
  }
  
  public static int a(Context paramContext, String paramString, int paramInt)
  {
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "now_entrance_action_info" + "_" + paramInt, 2);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory", 2, "getNowEntranceInfo,bid:" + paramInt + "-->first:" + i);
    }
    return i;
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString2 + "_" + paramString1, 0);
  }
  
  public static int a(BaseApplication paramBaseApplication)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramBaseApplication.getApplicationContext()).getInt("qim_dynamic_text_cfg_version", 0);
  }
  
  public static int a(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getInt(paramString + "_sticker_bubble_last_send_id", 1);
  }
  
  public static int a(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + "_qqstory_feed_sp";
    paramString2 = "key_qqstory_feed_timeout_second_" + paramString2;
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString1, 0).getInt(paramString2, 604800);
  }
  
  public static long a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 4).getLong("filter_spacing", 0L);
  }
  
  public static long a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("upgrade_qq_time" + paramString, 0L);
  }
  
  public static long a(Context paramContext, String paramString, int paramInt)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("ark_at_babyq_tip_lasttime_" + paramString + "_" + paramInt, 0L);
  }
  
  public static long a(Context paramContext, String paramString1, String paramString2)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("ark_ai_keyword_tip_lasttime" + paramString1 + paramString2, 0L);
  }
  
  public static long a(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getLong(paramString + "_" + "clean_disk_cache_time", 0L);
  }
  
  public static long a(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + "_qqstory_feed_sp";
    paramString2 = "key_latest_q_zone_feed_second_" + paramString2;
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString1, 0).getLong(paramString2, 0L);
  }
  
  public static SharedPreferences a(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("lightalk_pstn_number_sp_" + paramString, 0);
  }
  
  public static SharedPreferences a(String paramString1, String paramString2)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences(paramString2 + paramString1, 0);
  }
  
  public static Object a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramString = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { paramString, "push_recommend_shield_config", Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      return Integer.valueOf(paramContext.getInt(paramString, 0));
    }
    return paramContext.getString(paramString, "");
  }
  
  public static String a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("last_loginuin_for_birthday_uin", "");
  }
  
  public static String a(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("add_contacts_view_config_" + paramString, "");
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 });
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString1, "");
  }
  
  public static List a(Context paramContext, String paramString)
  {
    if (a != null) {
      return a;
    }
    a = new ArrayList();
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "local_set_top_troop_uploaded_ignore", null);
    if (TextUtils.isEmpty(paramContext)) {
      return a;
    }
    paramContext = paramContext.split("_");
    if ((paramContext == null) && (paramContext.length == 0)) {
      return a;
    }
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramContext[i];
      if (!TextUtils.isEmpty(paramString)) {
        a.add(paramString);
      }
      i += 1;
    }
    return a;
  }
  
  public static void a()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 4).edit();
    localEditor.putLong("filter_spacing", System.currentTimeMillis());
    localEditor.commit();
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 4).edit();
    localEditor.putInt("filter_download", paramInt1);
    localEditor.putInt("filter_total", paramInt2);
    localEditor.commit();
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putInt("lastSeq" + paramInt1 + paramString, paramInt2);
    localEditor.commit();
  }
  
  public static void a(int paramInt, String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putBoolean("hasClicked" + paramInt + paramString, true);
    localEditor.commit();
  }
  
  public static void a(long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_mainP_thread_monitor_infos", 4).edit();
    localEditor.putLong("peakThreadCount", paramLong);
    localEditor.apply();
  }
  
  public static void a(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("green_video_list");
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("AvWeakNet_video_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("dynamic_splash_config_version", paramInt1);
    paramContext.putInt("dynamic_splash_config_play_times", paramInt2);
    paramContext.putInt("dynamic_splash_config_play_internal", paramInt3);
    paramContext.putInt("dynamic_splash_config_show_times", paramInt4);
    paramContext.putString("dynamic_splash_config_md5", paramString1);
    paramContext.putString("dynamic_splash_config_effective_time", paramString2);
    paramContext.putString("dynamic_splash_config_zip_url", paramString3);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("entry_config_verion_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("splash_version_code", paramInt);
    paramContext.putString("splash_effectivetime", paramString1);
    paramContext.putString("splash_md5value", paramString2);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int i = 1;
    int k = 1;
    int j = 0;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    if (!paramBoolean)
    {
      j = paramContext.getInt("hotchat_scene_config_fcount", 0) + 1;
      if (j <= 5) {
        break label82;
      }
    }
    label82:
    for (i = k;; i = 0)
    {
      paramContext = paramContext.edit();
      if (i != 0) {
        paramContext.putInt("hotchat_scene_config_version", paramInt);
      }
      paramContext.putInt("hotchat_scene_config_fcount", j);
      paramContext.commit();
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("last_loginuin_for_birthday_uin", paramString);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("keyword_and_remark_version_code" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "poke_bar_config_version", paramInt1);
    paramContext.putInt(paramString + "_" + "aio_poke_touch_effect", paramInt2);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "poke_bar_config_version", paramInt1);
    paramContext.putInt(paramString + "_" + "aio_unique_poke_show", paramInt2);
    paramContext.putInt(paramString + "_" + "aio_unique_poke_type", paramInt3);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1 + "_" + "qim_user_special_config_version", paramInt1);
    paramContext.putInt(paramString1 + "_" + "qim_user_special_config_avatar_switch", paramInt2);
    paramContext.putInt(paramString1 + "_" + "qim_user_special_config_title_bg_switch", paramInt3);
    paramContext.putInt(paramString1 + "_" + "qim_user_special_config_bubble_switch", paramInt4);
    paramContext.putString(paramString1 + "_" + "qim_user_special_config_resources_url", paramString2);
    paramContext.putString(paramString1 + "_" + "qim_user_special_config_resources_md5", paramString3);
    paramContext.putString(paramString1 + "_" + "qim_user_special_config_qim_website", paramString4);
    paramContext.putString(paramString1 + "_" + "qim_user_special_config_online_wording", paramString5);
    paramContext.putBoolean("qim_user_special_need_force_download", paramBoolean);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("ark_at_babyq_tip_lasttime_" + paramString + "_" + paramInt, paramLong);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong(paramString1 + "_" + "aio_poke_strength_rule_interval", paramLong);
    paramContext.putString(paramString1 + "_" + "aio_poke_res_url", paramString2);
    paramContext.putString(paramString1 + "_" + "aio_poke_res_md5", paramString3);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, Object paramObject)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    String str = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { paramString, "push_recommend_shield_config", Integer.valueOf(paramInt) });
    boolean bool;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if ((!bool) && (QLog.isColorLevel())) {
        QLog.i("QQStoryFeedManager", 2, String.format(Locale.getDefault(), "updatePushRecommendShield [uin: %s, type: %d, value: %s, key: %s ret: %s]", new Object[] { paramString, Integer.valueOf(paramInt), paramObject, str, Boolean.valueOf(bool) }));
      }
      return;
      if (!(paramObject instanceof Integer)) {
        break;
      }
      paramContext.edit().putInt(str, ((Integer)paramObject).intValue()).apply();
      bool = true;
      continue;
      if (!(paramObject instanceof String)) {
        break;
      }
      paramContext.edit().putString(str, (String)paramObject).apply();
      bool = true;
    }
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1 + "_" + "poke_bar_config_version", paramInt);
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString(paramString1 + "_" + "aio_poke_panel_config", paramString2);
    }
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    paramContext.putInt(paramString1 + "_" + "aio_poke_entry_type", paramInt1);
    paramContext.putInt(paramString1 + "_" + "aio_pe_view_type", paramInt4);
    paramContext.putString(paramString1 + "_" + "poke_emo_res_url", paramString2);
    paramContext.putString(paramString1 + "_" + "poke_emo_res_md5", paramString3);
    paramContext.putString(paramString1 + "_" + "poke_emo_surprice_indexs", paramString4);
    paramContext.putString(paramString1 + "_" + "poke_emo_order", paramString5);
    paramContext.putInt(paramString1 + "_" + "aio_pe_input_switch", paramInt2);
    paramContext.putInt(paramString1 + "_" + "aio_pe_bubble_limit_count", paramInt3);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "poke_bar_config_version", paramInt1);
    if (paramBoolean)
    {
      paramContext.putInt(paramString + "_" + "poke_bar_switch", paramInt2);
      paramContext.putInt(paramString + "_" + "poke_pad_switch", paramInt3);
      paramContext.putInt(paramString + "_" + "aio_poke_unitcount", paramInt4);
      paramContext.putInt(paramString + "_" + "aio_poke_unittime", paramInt5);
    }
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "redbag_fold_msg_config_version", paramInt1);
    paramContext.putBoolean(paramString + "_" + "redbag_fold_msg_switch", paramBoolean1);
    paramContext.putInt(paramString + "_" + "redbag_fold_msg_num", paramInt2);
    paramContext.putBoolean(paramString + "_" + "redbag_fold_index_switch", paramBoolean2);
    paramContext.putBoolean(paramString + "_" + "redbag_fold_index_with_redbagid", paramBoolean3);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "heads_up_notify_version", paramInt);
    if (paramBoolean1) {
      paramContext.putBoolean(paramString + "_" + "heads_up_notify_switch", paramBoolean2);
    }
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("upgrade_qq_time" + paramString, paramLong);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("readinjoy_folder_nickname", paramString1);
    paramContext.putString("readinjoy_folder_icon_url", paramString2);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString2 + "_" + paramString1, paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("ark_ai_keyword_tip_lasttime" + paramString1 + paramString2, paramLong);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 });
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString1, paramString3);
    paramContext.apply();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    localEditor.putBoolean(paramContext, paramBoolean);
    localEditor.commit();
  }
  
  public static void a(Context paramContext, String paramString, JSONObject paramJSONObject)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString + "_" + "nearby_config_info", paramJSONObject.toString());
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre uin is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre auto =" + paramBoolean);
    }
    String str = paramContext.getPackageName() + "_preferences";
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      paramContext = paramContext.getSharedPreferences(str, i);
      paramContext.edit().putBoolean("login_auto" + paramString, paramBoolean);
      paramBoolean = paramContext.edit().commit();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre isOK =" + paramBoolean);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "game_invite", paramBoolean);
    paramContext.putLong(paramString + "_" + "game_invite_time", paramLong);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString1 + "_" + "hot_friend_days_contact", paramBoolean1);
    paramContext.putBoolean(paramString1 + "_" + "hot_friend_days_chat", paramBoolean2);
    paramContext.putString("show_hot_friend_days_setting", paramString2);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("is_nearby_auth_video_authentic", paramBoolean);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, boolean paramBoolean, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("kandian_interest_label_web_" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  @TargetApi(9)
  public static void a(SharedPreferences.Editor paramEditor)
  {
    if (Build.VERSION.SDK_INT > 8)
    {
      paramEditor.apply();
      return;
    }
    paramEditor.commit();
  }
  
  public static void a(BaseApplication paramBaseApplication, int paramInt)
  {
    paramBaseApplication = PreferenceManager.getDefaultSharedPreferences(paramBaseApplication.getApplicationContext()).edit();
    paramBaseApplication.putInt("qim_dynamic_text_cfg_version", paramInt);
    paramBaseApplication.commit();
  }
  
  public static void a(String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putLong(paramString + "_" + "clean_disk_cache_time", NetConnInfoCenter.getServerTime() / 3600L);
    localEditor.commit();
  }
  
  public static void a(String paramString, int paramInt)
  {
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putLong("search_discovery_sp_prefixlast_request_time" + paramString, System.currentTimeMillis()).putLong("search_discovery_sp_prefixcache_time" + paramString, paramInt * 1000).commit();
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putLong("search_discovery_sp_prefixlast_update_time" + paramString + "_" + paramInt1, System.currentTimeMillis()).putLong("search_discovery_sp_prefixexpire_time" + paramString + "_" + paramInt1, paramInt2 * 1000).commit();
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = paramString1 + "_qqstory_feed_sp";
    paramString2 = "key_qqstory_feed_timeout_second_" + paramString2;
    BaseApplicationImpl.getApplication().getSharedPreferences(paramString1, 0).edit().putInt(paramString2, paramInt).apply();
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + "_qqstory_feed_sp";
    paramString2 = "key_latest_q_zone_feed_second_" + paramString2;
    BaseApplicationImpl.getApplication().getSharedPreferences(paramString1, 0).edit().putLong(paramString2, paramLong).apply();
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putBoolean(paramString + "_is_has_show_troop_revoke_tip", paramBoolean);
    localEditor.apply();
  }
  
  public static void a(String paramString, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfString.length - 1)
      {
        localStringBuilder.append(paramArrayOfString[i]).append("_");
        i += 1;
      }
      localStringBuilder.append(paramArrayOfString[(paramArrayOfString.length - 1)]);
    }
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putString("pref_tag_hotword_title_list" + paramString, localStringBuilder.toString()).commit();
  }
  
  public static void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putBoolean("poke_emo_download_mark", paramBoolean);
    localEditor.commit();
  }
  
  public static boolean a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 0).getBoolean("qq_filter_flag", false);
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean("hasClicked" + paramInt + paramString, false);
  }
  
  public static boolean a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("is_nearby_auth_video_authentic", false);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("translate_bubble_first_time", true);
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    boolean bool = false;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    if (paramInt == 0) {
      bool = paramContext.getBoolean(paramString + "_" + "hot_friend_days_contact", false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotFriend_GET_LOCAL_CONFIG", 2, "type= " + paramInt + ",result=" + bool);
      }
      return bool;
      if (paramInt == 1) {
        bool = paramContext.getBoolean(paramString + "_" + "hot_friend_days_chat", false);
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString1 + "_readinjoy_skin_guide_" + paramString2, false);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext = paramString2 + "_" + paramString1;
    }
    return localSharedPreferences.getBoolean(paramContext, paramBoolean);
  }
  
  public static boolean a(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean(paramString + "_is_has_show_troop_revoke_tip", false);
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    long l1 = localSharedPreferences.getLong("search_discovery_sp_prefixlast_update_time" + paramString + "_" + paramInt, 0L);
    long l2 = localSharedPreferences.getLong("search_discovery_sp_prefixexpire_time" + paramString + "_" + paramInt, 0L);
    return System.currentTimeMillis() - l1 >= l2;
  }
  
  public static int[] a()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 4);
    return new int[] { localSharedPreferences.getInt("filter_download", 0), localSharedPreferences.getInt("filter_total", 0) };
  }
  
  public static String[] a(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getString("pref_tag_hotword_title_list" + paramString, "").split("_");
  }
  
  public static int aA(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("contact_recommend_config_version_" + paramString, 0);
  }
  
  public static int aB(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("doutu_config_version_" + paramString, 0);
  }
  
  public static int aC(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("cu_open_card_guide_config_appid_" + paramString, 0);
  }
  
  public static int aD(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("cu_open_card_guide_" + paramString, 0);
  }
  
  public static int aE(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("sticker_config_version_" + paramString, 0);
  }
  
  public static int aF(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("webcgi_whitelist_config_version_" + paramString, 0);
  }
  
  public static int aG(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "doutu_config_appid", 0);
  }
  
  public static int aH(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("doutu_smart_default_count_" + paramString, 0);
  }
  
  public static int aI(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "video_redbag_config_appid", 0);
  }
  
  public static int aJ(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("video_redbag_config_version_" + paramString, 0);
  }
  
  public static int aK(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "troop_robot_panel_version", 0);
  }
  
  public static int aL(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("app_guide_tips_config_version_" + paramString, 0);
  }
  
  public static int aM(Context paramContext, String paramString)
  {
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "troop_aio_keyword_version", 0);
    if (QLog.isColorLevel()) {
      QLog.i("SharedPreUtils", 2, "getTroopAioKeyWordVersion, version=" + i);
    }
    return i;
  }
  
  public static int aN(Context paramContext, String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "_" + "sp_aio_config", 0).getInt(paramString + "_" + "receipt_config_version", 0);
  }
  
  public static int aO(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "qim_user_special_config_version", 0);
  }
  
  public static int aP(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "qim_user_special_config_appid", 0);
  }
  
  public static int aQ(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "tim_user_special_config_version", 0);
  }
  
  public static int aR(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "tim_user_special_config_appid", 0);
  }
  
  public static int aS(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("zhitu_config_version_" + paramString, 0);
  }
  
  public static int aT(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("zhitu_config_page_len_" + paramString, 8);
  }
  
  public static int aU(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "aio_story_feed_config_version", 0);
  }
  
  public static int aV(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "story_halo_config_version", 0);
  }
  
  public static int aW(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "native_monitor_config_version", 0);
  }
  
  public static int aX(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "native_monitor_config_appid", 0);
  }
  
  public static int aY(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "qim_cfg_show_save_button", 0);
  }
  
  public static int aa(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "long_text_msg_config_version", 0);
  }
  
  public static void aa(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("video_redbag_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static int ab(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("hot_friend_chat_config_" + paramString, 0);
  }
  
  public static void ab(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("app_guide_tips_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static int ac(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("add_contacts_view_config_version_" + paramString, 0);
  }
  
  public static void ac(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "troop_aio_keyword_version", paramInt);
    paramContext.apply();
  }
  
  public static int ad(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("classic_head_activity_config_version_" + paramString, 0);
  }
  
  public static void ad(Context paramContext, String paramString, int paramInt)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "_" + "sp_aio_config", 0).edit();
    paramContext.putInt(paramString + "_" + "receipt_config_version", paramInt);
    paramContext.commit();
  }
  
  public static int ae(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("love_language_config_version_" + paramString, 0);
  }
  
  public static void ae(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "qim_user_special_config_appid", paramInt);
    paramContext.commit();
  }
  
  public static int af(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("love_language_activity_config_" + paramString, 0);
  }
  
  public static void af(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "tim_user_special_config_appid", paramInt);
    paramContext.commit();
  }
  
  public static int ag(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("love_language_activity_gray_config_" + paramString, 0);
  }
  
  public static void ag(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("zhitu_config_version_" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static int ah(Context paramContext, String paramString)
  {
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "create_troop_max_invite_num", 100);
    if (QLog.isColorLevel()) {
      QLog.d(".troop_common_config", 2, "getCreateTroopMaxInviteNum,re:" + i);
    }
    return i;
  }
  
  public static void ah(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("zhitu_config_page_len_" + paramString, paramInt);
    paramContext.apply();
  }
  
  public static int ai(Context paramContext, String paramString)
  {
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "aio_post_tab_plugin", 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat.aio_post_list_plugin", 2, "getHotChatAIOPluginFlag,re:" + i);
    }
    return i;
  }
  
  public static void ai(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "native_monitor_config_appid", paramInt);
    paramContext.commit();
  }
  
  public static int aj(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("medal_config_" + paramString, 0);
  }
  
  public static int ak(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "shortvideo_dynamic_adjustment", 0);
  }
  
  public static int al(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "show", 0);
  }
  
  public static int am(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "quick_shot_share_to_story_config_version", 0);
  }
  
  public static int an(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "msg_box_inter_follow_unread_count", 0);
  }
  
  public static int ao(Context paramContext, String paramString)
  {
    K(paramContext, paramString);
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("arkmsgai_disable_version_v2_" + paramString, 0);
  }
  
  public static int ap(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "ark_service_type", 0);
  }
  
  public static int aq(Context paramContext, String paramString)
  {
    K(paramContext, paramString);
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ark_ai_dict_config_version_" + paramString, 0);
  }
  
  public static int ar(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ark_at_babyq_guide_last_day_count_" + paramString, 0);
  }
  
  public static int as(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ark_at_babyq_guide_total_day_count_" + paramString, 0);
  }
  
  public static int at(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ark_ai_close_tip_count_" + paramString, 0);
  }
  
  public static int au(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("troop_gift_url_config_version_" + paramString, 0);
  }
  
  public static int av(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("troop_pobing_config_version_" + paramString, 0);
  }
  
  public static int aw(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qq_pre_down_yyb_ver_" + paramString, 0);
  }
  
  public static int ax(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("buluo_red_dot_config_version_" + paramString, 0);
  }
  
  public static int ay(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "qqhead_syncqzone_checkedstate", -1);
  }
  
  public static int az(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "qqhead_history_numflag", -1);
  }
  
  public static int b(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("eqq_config_version_code", 0);
  }
  
  public static int b(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("group_video_version_code_" + paramString, 0);
  }
  
  public static int b(Context paramContext, String paramString, int paramInt)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { paramString, "medal_strong_reminder_config", Integer.valueOf(paramInt) }), 0);
  }
  
  public static int b(Context paramContext, String paramString1, String paramString2)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString1 + "_" + paramString2 + "_" + "msg_box_delete_msg_tab_flag", 0);
  }
  
  public static long b()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 4).getLong("av_pendant_spacing", 0L);
  }
  
  public static long b(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("ark_at_babyq_guide_last_day_time_" + paramString, 0L);
  }
  
  public static long b(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + "_qqstory_feed_sp";
    paramString2 = "key_q_zone_exceed_second_" + paramString2;
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString1, 0).getLong(paramString2, 9223372036854775807L);
  }
  
  public static SharedPreferences b(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("aio_jump_lightalk_red_dot" + paramString, 0);
  }
  
  public static String b(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("birthday_user", "");
  }
  
  public static String b(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("classic_head_activity_config_" + paramString, "");
  }
  
  public static void b()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 0).edit();
    localEditor.putBoolean("qq_filter_flag", true);
    localEditor.commit();
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 4).edit();
    localEditor.putInt("av_pendant_download", paramInt1);
    localEditor.putInt("av_pendant_total", paramInt2);
    localEditor.commit();
  }
  
  public static void b(int paramInt, String paramString)
  {
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putInt(paramString + "_sticker_bubble_last_send_id", paramInt).apply();
  }
  
  public static void b(long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_mainP_thread_monitor_infos", 4).edit();
    localEditor.putLong("monitorStartTime", paramLong);
    localEditor.apply();
  }
  
  public static void b(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("shortvideo_sync_to_story_need_guide", false);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("eqq_config_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("group_video_version_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString2 + "_" + "birthday_splash_version_code", paramInt);
    paramContext.putString("birthday_splash_md5value", paramString1);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("birthday_user", paramString);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("send_bless_version_code" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "poke_bar_config_version", paramInt1);
    paramContext.putInt(paramString + "_" + "aio_poke_combo_time", paramInt2);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("love_language_config_version_" + paramString, paramInt1);
    paramContext.putInt("love_language_activity_config_" + paramString, paramInt2);
    paramContext.putInt("love_language_activity_gray_config_" + paramString, paramInt3);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1 + "_" + "tim_user_special_config_version", paramInt1);
    paramContext.putInt(paramString1 + "_" + "tim_user_special_config_avatar_switch", paramInt2);
    paramContext.putInt(paramString1 + "_" + "tim_user_special_config_title_bg_switch", paramInt3);
    paramContext.putInt(paramString1 + "_" + "tim_user_special_config_bubble_switch", paramInt4);
    paramContext.putString(paramString1 + "_" + "tim_user_special_config_resources_url", paramString2);
    paramContext.putString(paramString1 + "_" + "tim_user_special_config_resources_md5", paramString3);
    paramContext.putString(paramString1 + "_" + "tim_user_special_config_tim_website", paramString4);
    paramContext.putString(paramString1 + "_" + "tim_user_special_config_online_wording", paramString5);
    paramContext.putBoolean("tim_user_special_need_force_download", paramBoolean);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1 + "_" + "story_halo_config_version", paramInt);
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString(paramString1 + "_" + "story_halo_config_json", paramString2);
    }
    paramContext.apply();
  }
  
  public static void b(Context paramContext, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "long_text_msg_config_version", paramInt);
    paramContext.putBoolean(paramString + "_" + "long_text_msg_switch", paramBoolean1);
    paramContext.putBoolean(paramString + "_msfpull_filter_switch", paramBoolean2);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("ark_at_babyq_guide_last_day_time_" + paramString, paramLong);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove(paramString2 + "_" + paramString1);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1 + "_" + paramString2 + "_" + "msg_box_delete_msg_tab_flag", paramInt);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "enter_lightalk_vip", paramBoolean);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("kandian_read_data", paramBoolean);
    paramContext.commit();
  }
  
  public static void b(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + "_qqstory_feed_sp";
    paramString2 = "key_q_zone_exceed_second_" + paramString2;
    BaseApplicationImpl.getApplication().getSharedPreferences(paramString1, 0).edit().putLong(paramString2, paramLong).apply();
  }
  
  public static boolean b()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 0).getBoolean("av_pendant_flag", false);
  }
  
  public static boolean b(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("kandian_read_data", true);
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    paramString = "config_app_version_" + paramString;
    return !TextUtils.equals(PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString, ""), "7.6.3");
  }
  
  public static boolean b(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    long l1 = localSharedPreferences.getLong("search_discovery_sp_prefixlast_request_time" + paramString, 0L);
    long l2 = localSharedPreferences.getLong("search_discovery_sp_prefixcache_time" + paramString, 0L);
    return System.currentTimeMillis() - l1 >= l2;
  }
  
  public static int[] b()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 4);
    return new int[] { localSharedPreferences.getInt("av_pendant_download", 0), localSharedPreferences.getInt("av_pendant_total", 0) };
  }
  
  public static int c(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("splash_version_code", 0);
  }
  
  public static int c(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qvip_res_version_code_" + paramString, 0);
  }
  
  public static int c(Context paramContext, String paramString, int paramInt)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ark_at_babyq_tip_count_" + paramString + "_" + paramInt, 0);
  }
  
  public static int c(Context paramContext, String paramString1, String paramString2)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ark_ai_keyword_tip_count_" + paramString1 + paramString2, 0);
  }
  
  public static long c()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qq_mainP_thread_monitor_infos", 4).getLong("peakThreadCount", 0L);
  }
  
  public static long c(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("doutu_config_duration_" + paramString, 0L);
  }
  
  public static long c(String paramString1, String paramString2)
  {
    paramString1 = paramString1 + "_qqstory_feed_sp";
    paramString2 = "key_latest_signature_feed_second_" + paramString2;
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString1, 0).getLong(paramString2, 0L);
  }
  
  public static SharedPreferences c(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("qav_upgrade_invite" + paramString, 0);
  }
  
  public static String c(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("eqq-config-data", null);
  }
  
  public static String c(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("buluo_enter_url_config", 4).getString(paramString + "_" + "buluo_enter_url_config", "");
  }
  
  public static void c()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 4).edit();
    localEditor.putLong("av_pendant_spacing", System.currentTimeMillis());
    localEditor.commit();
  }
  
  public static void c(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("apm_config_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qvip_res_version_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("add_contacts_view_config_version_" + paramString1, paramInt);
    paramContext.putString("add_contacts_view_config_" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("eqq-config-data", paramString);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "nearby_flower_gray_tips_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "now_entrance_action_info" + "_" + paramInt1, paramInt2);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1 + "_" + "aio_story_feed_config_version", paramInt);
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString(paramString1 + "_" + "aio_story_feed_config_json", paramString2);
    }
    paramContext.apply();
  }
  
  public static void c(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("doutu_config_duration_" + paramString, paramLong);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("buluo_enter_url_config", 4).edit();
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString(paramString1 + "_" + "buluo_enter_url_config", paramString2);
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.remove(paramString1 + "_" + "buluo_enter_url_config");
    }
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ark_ai_keyword_tip_count_" + paramString1 + paramString2, paramInt);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("readinjoy_folder_setting_url", paramString);
    paramContext.putBoolean("readinjoy_folder_setting_btn", paramBoolean);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("kandian_video_sound", paramBoolean);
    paramContext.commit();
  }
  
  public static void c(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + "_qqstory_feed_sp";
    paramString2 = "key_latest_signature_feed_second_" + paramString2;
    BaseApplicationImpl.getApplication().getSharedPreferences(paramString1, 0).edit().putLong(paramString2, paramLong).apply();
  }
  
  public static boolean c()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean("poke_emo_download_mark", false);
  }
  
  public static boolean c(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("shortvideo_sync_to_story_last_checked", false);
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "arkmsgai_disable_v2", false);
  }
  
  public static int d(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("apm_config_version_code", 0);
  }
  
  public static int d(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qvip_keyword_version_code_" + paramString, 0);
  }
  
  public static int d(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_version", new Object[] { paramString1, paramString2 });
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString1, 0);
  }
  
  public static long d()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qq_mainP_thread_monitor_infos", 4).getLong("monitorStartTime", 0L);
  }
  
  public static long d(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("doutu_config_combo_duration_" + paramString, 0L);
  }
  
  public static SharedPreferences d(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("AvWeakNet_video_version_code" + paramString, 0);
  }
  
  public static String d(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("green_video_list", "HUAWEI;HUAWEI NXT-AL10;24|HUAWEI;FRD-AL00;24|HUAWEI;EVA-AL00;24|HUAWEI;KNT-AL10;24|HUAWEI;EDI-AL10;24");
  }
  
  public static String d(Context paramContext, String paramString)
  {
    paramString = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "hot_chat_link", "https://play.mobile.qq.com/play/mqqplay/hotchat/index_v2.html?_wv=1027&_bid=2152");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory", 2, "getHotChatLink,link:" + paramString);
    }
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "https://play.mobile.qq.com/play/mqqplay/hotchat/index_v2.html?_wv=1027&_bid=2152";
    }
    return paramContext;
  }
  
  public static void d()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 0).edit();
    localEditor.putBoolean("av_pendant_flag", true);
    localEditor.commit();
  }
  
  public static void d(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("nearby_chat_gray_tips_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qvip_keyword_version_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("classic_head_activity_config_version_" + paramString1, paramInt);
    paramContext.putString("classic_head_activity_config_" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("translate_bubble_first_time", false);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "nearby_hotchat_v_list_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramString = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { paramString, "medal_strong_reminder_config", Integer.valueOf(paramInt1) });
    paramContext.edit().putInt(paramString, paramInt2).apply();
  }
  
  public static void d(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1 + "_" + "native_monitor_config_version", paramInt);
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString(paramString1 + "_" + "native_monitor_config_content", paramString2);
    }
    paramContext.commit();
  }
  
  public static void d(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("doutu_config_combo_duration_" + paramString, paramLong);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString1 + "_" + "hot_chat_link", paramString2);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_version", new Object[] { paramString1, paramString2 });
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1, paramInt);
    paramContext.apply();
  }
  
  public static void d(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "arkmsgai_disable_v2", paramBoolean);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("shortvideo_sync_to_story_last_checked", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean d(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("shortvideo_sync_to_story_need_guide", true);
  }
  
  public static boolean d(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "arkmsgai_msgflow_disable", false);
  }
  
  public static int e(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("nearby_chat_gray_tips_config_version", 0);
  }
  
  public static int e(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("individuation_abtest_code_" + paramString, 0);
  }
  
  public static int e(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_appid", new Object[] { paramString1, paramString2 });
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString1, 0);
  }
  
  public static long e(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("doutu_config_combo_keep_" + paramString, 0L);
  }
  
  public static SharedPreferences e(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("qav_anychat_time_limit" + paramString, 0);
  }
  
  public static String e(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("public_account_config_data", null);
  }
  
  public static String e(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "robot_aio_bar", "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory", 2, "getRobotAioBar,aio_bar:" + paramContext);
    }
    return paramContext;
  }
  
  public static void e(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("troop_rank_map_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void e(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("individuation_abtest_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void e(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("green_video_list", paramString);
    paramContext.commit();
  }
  
  public static void e(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "green_video_appid", paramInt);
    paramContext.commit();
  }
  
  public static void e(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ark_at_babyq_tip_count_" + paramString + "_" + paramInt1, paramInt2);
    paramContext.commit();
  }
  
  public static void e(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong("doutu_config_combo_keep_" + paramString, paramLong);
    paramContext.commit();
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString1 + "_" + "robot_aio_bar", paramString2);
    paramContext.commit();
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_appid", new Object[] { paramString1, paramString2 });
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1, paramInt);
    paramContext.apply();
  }
  
  public static void e(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "arkmsgai_msgflow_disable", paramBoolean);
    paramContext.commit();
  }
  
  public static void e(Context paramContext, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("doutu_res_damaged", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean e(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("doutu_res_damaged", false);
  }
  
  public static boolean e(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "arkmsgai_input_disable", false);
  }
  
  public static int f(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("troop_rank_map_config_version", 0);
  }
  
  public static int f(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("webView_url_check_code_" + paramString, 0);
  }
  
  public static long f(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong(paramString + "_" + "graytips_call_last_alerttime", 0L);
  }
  
  public static SharedPreferences f(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("qav_score" + paramString, 0);
  }
  
  public static String f(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("videodown_ct_whitelist", null);
  }
  
  public static String f(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "robot_voice_tail", "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory", 2, "getRobotVoiceTail,aio_bar:" + paramContext);
    }
    return paramContext;
  }
  
  public static void f(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ptv_template_cfg_version", paramInt);
    paramContext.commit();
  }
  
  public static void f(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("webView_url_check_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void f(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("public_account_config_data", paramString);
    paramContext.commit();
  }
  
  public static void f(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("green_video_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void f(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong(paramString + "_" + "graytips_call_last_alerttime", paramLong);
    paramContext.commit();
  }
  
  public static void f(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString1 + "_" + "robot_voice_tail", paramString2);
    paramContext.commit();
  }
  
  public static void f(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences(paramString1 + "_" + "sp_aio_config", 0).edit();
    paramContext.putInt(paramString2, paramInt);
    paramContext.apply();
  }
  
  public static void f(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "arkmsgai_input_disable", paramBoolean);
    paramContext.commit();
  }
  
  public static void f(Context paramContext, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("video_redbag_res_damaged", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean f(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("video_redbag_res_damaged", false);
  }
  
  public static boolean f(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "ark_at_babyq_disable", true);
  }
  
  public static int g(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qav_general_config_version", 0);
  }
  
  public static int g(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "hotchat_classify_version_code", 0);
  }
  
  public static long g(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong(paramString + "_req_troop_effect_config", 0L);
  }
  
  public static SharedPreferences g(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("contact_recommend_sp" + paramString, 0);
  }
  
  public static String g(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("mix_msg_forward_config", null);
  }
  
  public static String g(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "story_player_proxy_config", null);
  }
  
  public static void g(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("capture_ptv_template_cfg_version", paramInt);
    paramContext.commit();
  }
  
  public static void g(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "qfind_pidlist_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void g(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("config_app_version_" + paramString, "7.6.3");
    paramContext.commit();
  }
  
  public static void g(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "video_compress_config_appid", paramInt);
    paramContext.commit();
  }
  
  public static void g(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putLong(paramString + "_req_troop_effect_config", paramLong);
    paramContext.commit();
  }
  
  public static void g(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString(paramString1 + "_" + "quick_shot_share_to_story_config", paramString2);
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.remove(paramString1 + "_" + "quick_shot_share_to_story_config");
    }
  }
  
  public static void g(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "ark_at_babyq_disable", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean g(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "ark_app_manage_panel_disable", true);
  }
  
  public static int h(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ptv_template_cfg_version", 0);
  }
  
  public static int h(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "qfind_pidlist_version_code", 0);
  }
  
  public static long h(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("readinjoy_skin_guide_seq_" + paramString, 0L);
  }
  
  public static String h(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("readinjoy_folder_nickname", "");
  }
  
  public static String h(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("ark_ai_dict_config_json_" + paramString, "");
  }
  
  public static void h(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ptv_template_web_cfg_version", paramInt);
    paramContext.commit();
  }
  
  public static void h(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "", paramInt);
    paramContext.commit();
  }
  
  public static void h(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0)
    {
      paramContext = paramContext.getSharedPreferences("nearby_glamour", i).edit();
      paramContext.putString("nearby_glamour_level_config_info", paramString);
      paramContext.commit();
      return;
    }
  }
  
  public static void h(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("video_compress_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void h(Context paramContext, String paramString, long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putLong("readinjoy_skin_guide_seq_" + paramString, paramLong).commit();
  }
  
  public static void h(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.putString(paramString1 + "_" + "story_player_proxy_config", paramString2);
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.remove(paramString1 + "_" + "story_player_proxy_config");
    }
  }
  
  public static void h(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "ark_app_manage_panel_disable", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean h(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "ark_download_by_yyb_disable", true);
  }
  
  public static int i(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("capture_ptv_template_cfg_version", 0);
  }
  
  public static int i(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "", 0);
  }
  
  public static long i(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getLong(paramString + "_readinjoy_skin_guide_time", 0L);
  }
  
  public static String i(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("readinjoy_folder_icon_url", "");
  }
  
  public static String i(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("ark_ai_tip_switch_config_json" + paramString, "false");
  }
  
  public static void i(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("doodle_template_cfg_version", paramInt);
    paramContext.commit();
  }
  
  public static void i(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "pushbanner_ad_version_code", paramInt);
    paramContext.commit();
  }
  
  public static void i(Context paramContext, String paramString)
  {
    G(paramContext, paramString, 0);
    i(paramContext, paramString, "");
  }
  
  public static void i(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "search_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void i(Context paramContext, String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramString1 = "ark_ai_dict_config_json_" + paramString1;
    paramContext = paramString2;
    if (paramString2 == null) {
      paramContext = "";
    }
    localEditor.putString(paramString1, paramContext);
    localEditor.commit();
  }
  
  public static void i(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "ark_download_by_yyb_disable", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean i(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "auto_agree_join_troop", false);
  }
  
  public static int j(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ptv_template_web_cfg_version", 0);
  }
  
  public static int j(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "pushbanner_ad_version_code", 0);
  }
  
  public static String j(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("show_hot_friend_days_setting", "3|30|3|30|3|30|3|30|5");
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_GET_LOCAL_CONFIG", 2, "result=" + paramContext);
    }
    return paramContext;
  }
  
  public static String j(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("troop_gift_url_config", 0).getString(paramString, "");
  }
  
  public static void j(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("doodle_template_cfg_version", paramInt);
    paramContext.commit();
  }
  
  public static void j(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("general_configs_version_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void j(Context paramContext, String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString;
    if (paramString == null) {
      paramContext = "";
    }
    localEditor.putString("ark_ai_keyword_config_json", paramContext);
    localEditor.commit();
  }
  
  public static void j(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "poke_config_appid", paramInt);
    paramContext.commit();
  }
  
  public static void j(Context paramContext, String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramString2 = "ark_ai_tip_switch_config_json" + paramString2;
    paramContext = paramString1;
    if (paramString1 == null) {
      paramContext = "false";
    }
    localEditor.putString(paramString2, paramContext);
    localEditor.commit();
  }
  
  public static void j(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "auto_agree_join_troop", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean j(Context paramContext, String paramString)
  {
    boolean bool1 = false;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    boolean bool2 = paramContext.getBoolean(paramString + "_" + "local_set_top_troop_uploaded", false);
    int i = paramContext.getInt(paramString + "_" + "local_set_top_troop_uploaded_repeat_count", 0);
    paramContext.edit().putInt(paramString + "_" + "local_set_top_troop_uploaded_repeat_count", i + 1).commit();
    if ((bool2) || (i >= 5)) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static int k(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("doodle_template_cfg_version", 0);
  }
  
  public static int k(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "birthday_splash_version_code", 0);
  }
  
  public static String k(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0) {
      return paramContext.getSharedPreferences("nearby_glamour", i).getString("nearby_glamour_level_config_info", null);
    }
  }
  
  public static String k(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("qq_pre_down_yyb", 0).getString(paramString, "");
  }
  
  public static void k(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ptv_bless_special_pendant_cfg_version", paramInt);
    paramContext.commit();
  }
  
  public static void k(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("general_android_configs_version_code_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void k(Context paramContext, String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString;
    if (paramString == null) {
      paramContext = "";
    }
    localEditor.putString("ark_ai_keyword_sdk_share_app_info", paramContext);
    localEditor.commit();
  }
  
  public static void k(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "search_config_appid", paramInt);
    paramContext.commit();
  }
  
  public static void k(Context paramContext, String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.putString(paramString1 + "_" + "local_set_top_troop_uploaded_ignore", localSharedPreferences.getString(new StringBuilder().append(paramString1).append("_").append("local_set_top_troop_uploaded_ignore").toString(), "") + "_" + paramString2);
    localEditor.commit();
    if (a == null) {
      a = a(paramContext, paramString1);
    }
    a.add(paramString2);
  }
  
  public static void k(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "is_show_buluo_red_num_red_dot", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean k(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "is_show_buluo_red_num_red_dot", false);
  }
  
  public static int l(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("doodle_template_cfg_version", 0);
  }
  
  public static int l(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("keyword_and_remark_version_code" + paramString, 0);
  }
  
  public static String l(Context paramContext)
  {
    return paramContext.getSharedPreferences("shortvideoSyncStoryConfig", 4).getString("shortvideo_sync_to_story_config", null);
  }
  
  public static String l(Context paramContext, String paramString)
  {
    return g(paramString).getString("contact_recommend_config_json_" + paramString, "");
  }
  
  public static void l(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("public_account_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void l(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "jump_lightalk_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void l(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "local_set_top_troop_uploaded", true);
    paramContext.commit();
  }
  
  public static void l(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "pa_subcribe_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void l(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("troop_gift_url_config", 0);
    paramContext.edit().putString(paramString1, paramString2);
    paramContext.edit().commit();
  }
  
  public static void l(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "game_room", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean l(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    boolean bool3 = paramContext.getBoolean(paramString + "_" + "game_invite", false);
    long l = paramContext.getLong(paramString + "_" + "game_invite_time", 0L);
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (System.currentTimeMillis() - l < 3600000L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int m(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ptv_bless_special_pendant_cfg_version", 0);
  }
  
  public static int m(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("send_bless_version_code" + paramString, 0);
  }
  
  public static String m(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("ark_ai_keyword_config_json", "");
  }
  
  public static String m(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("doutu_res_url_" + paramString, "");
  }
  
  public static void m(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ark_ai_keyword_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void m(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "qav_upgrade_invite_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void m(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_config_switch_" + paramString);
    paramContext.commit();
  }
  
  public static void m(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "subscript_recommend_config_version" + "_" + "7.6.3.3565", paramInt);
    paramContext.commit();
  }
  
  public static void m(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("qq_pre_down_yyb", 0);
    paramContext.edit().putString(paramString1, paramString2);
    paramContext.edit().commit();
  }
  
  public static void m(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("doutu_config_switch_" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static boolean m(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "game_room", false);
  }
  
  public static int n(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("public_account_config_version", 0);
  }
  
  public static int n(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("general_configs_version_code_" + paramString, 0);
  }
  
  public static String n(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("ark_ai_keyword_sdk_share_app_info", "");
  }
  
  public static String n(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("doutu_res_md5_" + paramString, "");
  }
  
  public static void n(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ark_ai_keyword_share_app_version", paramInt);
    paramContext.commit();
  }
  
  public static void n(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "qav_anychat_time_limit_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void n(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_combo_config_switch_" + paramString);
    paramContext.commit();
  }
  
  public static void n(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "lbs_pack_version", paramInt);
    paramContext.commit();
  }
  
  public static void n(Context paramContext, String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = g(paramString1).edit();
    paramString1 = "contact_recommend_config_json_" + paramString1;
    paramContext = paramString2;
    if (paramString2 == null) {
      paramContext = "";
    }
    localEditor.putString(paramString1, paramContext);
    localEditor.commit();
  }
  
  public static void n(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("doutu_setting_switch_" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static boolean n(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("doutu_config_switch_" + paramString, false);
  }
  
  public static int o(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ark_ai_keyword_config_version", 0);
  }
  
  public static int o(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("general_android_configs_version_code_" + paramString, 0);
  }
  
  public static String o(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("scribble_gif_ver", "");
  }
  
  public static String o(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("video_redbag_res_md5_" + paramString, "");
  }
  
  public static void o(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("apollo_switch", paramInt);
    paramContext.commit();
  }
  
  public static void o(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "qav_score_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void o(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_smart_config_switch_" + paramString);
    paramContext.commit();
  }
  
  public static void o(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "kandian_hb_version", paramInt);
    paramContext.commit();
  }
  
  public static void o(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("doutu_res_url_" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void o(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("doutu_combo_config_switch_" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static boolean o(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("doutu_setting_switch_" + paramString, true);
  }
  
  public static int p(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ark_ai_keyword_share_app_version", 0);
  }
  
  public static int p(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "lightalk_config_version", 0);
  }
  
  public static String p(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("scribble_paint_ver", "");
  }
  
  public static String p(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("video_redbag_res_url_" + paramString, "");
  }
  
  public static void p(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("camera_compatible_list_version", paramInt);
    paramContext.commit();
  }
  
  public static void p(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "qav_effect_operate_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void p(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_smart_default_count_" + paramString);
    paramContext.commit();
  }
  
  public static void p(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("apollo_config_version" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void p(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("doutu_res_md5_" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void p(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("doutu_smart_config_switch_" + paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static boolean p(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("doutu_combo_config_switch_" + paramString, false);
  }
  
  public static int q(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("videodown_ct_whitelist_version", 0);
  }
  
  public static int q(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "jump_lightalk_config_version", 0);
  }
  
  public static String q(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("scribble_gif_config_content", null);
  }
  
  public static String q(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("video_compress_config_" + paramString, "");
  }
  
  public static void q(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("shortvideo_progressive_blacklist_version", paramInt);
    paramContext.commit();
  }
  
  public static void q(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "now_tab_config_cmd_version", paramInt);
    paramContext.commit();
  }
  
  public static void q(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_res_url_" + paramString);
    paramContext.commit();
  }
  
  public static void q(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "readinjoy_local_channel_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void q(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("video_redbag_res_md5_" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void q(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString + "_" + "troop_gift_to_all_tab", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean q(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("doutu_smart_config_switch_" + paramString, false);
  }
  
  public static int r(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("mix_msg_forward_config_version", 0);
  }
  
  public static int r(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "qav_upgrade_invite_config_version", 0);
  }
  
  public static String r(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("scribble_paint_config_content", null);
  }
  
  public static String r(Context paramContext, String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getString(paramString + "_readinjoy_skin", null);
  }
  
  public static void r(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("readinjoy_folder_setting_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void r(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "now_download_engine_cmd_version", paramInt);
    paramContext.commit();
  }
  
  public static void r(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_res_md5_" + paramString);
    paramContext.commit();
  }
  
  public static void r(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "qwallet_setting_version", paramInt);
    paramContext.commit();
  }
  
  public static void r(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("video_redbag_res_url_" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void r(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit();
    paramContext.putBoolean(paramString + "_readinjoy_skin_volume", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean r(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "troop_gift_to_all_tab", true);
  }
  
  public static int s(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("apollo_switch", 0);
  }
  
  public static int s(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "qav_anychat_time_limit_config_version", 0);
  }
  
  public static String s(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("scribble_switch_ver", "");
  }
  
  public static String s(Context paramContext, String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getString(paramString + "_readinjoy_refresh", null);
  }
  
  public static void s(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("readinjoy_folder_config_id", paramInt);
    paramContext.commit();
  }
  
  public static void s(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("videodown_ct_whitelist_version", paramInt);
    paramContext.putString("videodown_ct_whitelist", paramString);
    paramContext.commit();
  }
  
  public static void s(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("video_redbag_res_md5_" + paramString);
    paramContext.commit();
  }
  
  public static void s(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "passwd_red_bag_setting_version", paramInt);
    paramContext.commit();
  }
  
  public static void s(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("video_compress_config_" + paramString1, paramString2);
    paramContext.commit();
  }
  
  public static void s(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("zhitu_config_switch_" + paramString, paramBoolean);
    paramContext.apply();
  }
  
  public static boolean s(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "troop_effect_pic_guide", false);
  }
  
  public static int t(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("hotchat_scene_config_version", 0);
  }
  
  public static int t(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "qav_score_config_version", 0);
  }
  
  public static String t(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("scribble_switch_config", null);
  }
  
  public static String t(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "story_halo_config_json", "");
  }
  
  public static void t(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("scribble_config_ver", paramInt);
    paramContext.commit();
  }
  
  public static void t(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("mix_msg_forward_config_version", paramInt);
    paramContext.putString("mix_msg_forward_config", paramString);
    paramContext.commit();
  }
  
  public static void t(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("video_redbag_res_url_" + paramString);
    paramContext.commit();
  }
  
  public static void t(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "pstn_switch_wording_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void t(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString1 + "_isClickEnterEffectGrayTipsEntrance_" + paramString2, true);
    paramContext.commit();
  }
  
  public static void t(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("zhitu_setting_switch_" + paramString, paramBoolean);
    paramContext.apply();
  }
  
  public static boolean t(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "troop_online_member_guide", false);
  }
  
  public static int u(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("camera_compatible_list_version", 0);
  }
  
  public static int u(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "qav_effect_operate_config_version", 0);
  }
  
  public static String u(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString + "_" + "aio_story_feed_config_json", "");
  }
  
  public static void u(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("unite_search_trigger_number", paramInt);
    paramContext.commit();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.setUniteSearchTriggerNum", 2, "setUniteSearchTriggerNum:" + paramInt);
    }
  }
  
  public static void u(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("readinjoy_merge_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void u(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("video_compress_config_" + paramString);
    paramContext.commit();
  }
  
  public static void u(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("pre_download_dialog_version" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void u(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit();
    if (paramString2 == null) {
      paramContext.remove(paramString1 + "_readinjoy_skin");
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.putString(paramString1 + "_readinjoy_skin", paramString2);
    }
  }
  
  public static void u(Context paramContext, String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if (QQAppInterface.class.isInstance(paramContext)) {}
    for (paramContext = ((QQAppInterface)paramContext).c();; paramContext = "")
    {
      localEditor.putBoolean(paramString + "_" + "qim_video_combol_lock_info" + "_" + paramContext, paramBoolean);
      localEditor.commit();
      return;
    }
  }
  
  public static boolean u(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("zhitu_config_switch_" + paramString, false);
  }
  
  public static int v(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("dynamic_splash_config_version", 0);
  }
  
  public static int v(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "now_tab_config_cmd_version", 0);
  }
  
  public static String v(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      throw new IllegalArgumentException("ctx or uin may be null, ctx=" + paramContext + ", uin=" + paramString);
    }
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("recent_poi_" + paramString, null);
  }
  
  public static void v(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qim_music_cfg_version", paramInt);
    paramContext.commit();
  }
  
  public static void v(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("readinjoy_crop_and_group_version_3565_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void v(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_config_duration_" + paramString);
    paramContext.commit();
  }
  
  public static void v(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("upgrade_tim_version" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void v(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit();
    if (paramString2 == null) {
      paramContext.remove(paramString1 + "_readinjoy_refresh");
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.putString(paramString1 + "_readinjoy_refresh", paramString2);
    }
  }
  
  public static boolean v(Context paramContext, String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getBoolean(paramString + "_readinjoy_skin_volume", false);
  }
  
  public static int w(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("shortvideo_progressive_blacklist_version", 0);
  }
  
  public static int w(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "now_download_engine_cmd_version", 0);
  }
  
  public static void w(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qim_sticker_cfg_version", paramInt);
    paramContext.commit();
  }
  
  public static void w(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("hot_friend_chat_config_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void w(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_config_combo_duration_" + paramString);
    paramContext.commit();
  }
  
  public static void w(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("photo_plus_sticker_version" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void w(Context paramContext, String paramString1, String paramString2)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putBoolean(paramString1 + "_readinjoy_skin_guide_" + paramString2, true).commit();
  }
  
  public static boolean w(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("zhitu_setting_switch_" + paramString, true);
  }
  
  public static int x(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qqhotspot_config_version", 0);
  }
  
  public static int x(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "nearby_flower_gray_tips_config_version", 0);
  }
  
  public static void x(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qim_faceu_cfg_version", paramInt);
    paramContext.commit();
  }
  
  public static void x(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "shortvideo_dynamic_adjustment", paramInt);
    paramContext.commit();
  }
  
  public static void x(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("doutu_config_combo_keep_" + paramString);
    paramContext.commit();
  }
  
  public static void x(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("art_filter_version" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void x(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {
      throw new IllegalArgumentException("ctx or uin may be null, ctx=" + paramContext + ", uin=" + paramString1);
    }
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString("recent_poi_" + paramString1, paramString2).apply();
  }
  
  public static boolean x(Context paramContext, String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if (QQAppInterface.class.isInstance(paramContext)) {}
    for (paramContext = ((QQAppInterface)paramContext).c();; paramContext = "") {
      return localSharedPreferences.getBoolean(paramString + "_" + "qim_video_combol_lock_info" + "_" + paramContext, true);
    }
  }
  
  public static int y(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("readinjoy_folder_setting_config_version", 0);
  }
  
  public static int y(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "nearby_hotchat_v_list_config_version", 0);
  }
  
  public static void y(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("medal_config_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void y(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("scribble_gif_ver", paramString);
    paramContext.commit();
  }
  
  public static void y(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "readinjoy_folder_config_version", paramInt);
    paramContext.commit();
  }
  
  public static boolean y(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "user_guide_taste_tracking_sticker_tips_3", false);
  }
  
  public static int z(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("readinjoy_folder_config_id", 0);
  }
  
  public static int z(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "green_video_appid", 0);
  }
  
  public static void z(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("arkmsgai_disable_version_v2_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void z(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("scribble_paint_ver", paramString);
    paramContext.commit();
  }
  
  public static void z(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "preload_config_version", paramInt);
    paramContext.commit();
  }
  
  public static boolean z(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString + "_" + "user_guide_taste_tracking_sticker_tips", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SharedPreUtils
 * JD-Core Version:    0.7.0.1
 */