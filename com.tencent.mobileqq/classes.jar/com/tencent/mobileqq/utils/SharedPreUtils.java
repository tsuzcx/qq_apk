package com.tencent.mobileqq.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class SharedPreUtils
  extends BaseSharedPreUtil
{
  protected static List<String> a;
  
  public static int A(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("video_compress_config_appid");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String A(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("apollo_crossengine_version", null);
  }
  
  public static void A(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_pobing_config_version_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static int B(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("video_compress_config_version_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static SharedPreferences B(Context paramContext)
  {
    return paramContext.getSharedPreferences("qav_SP", 4);
  }
  
  public static void B(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_gift_url_config_version_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static SharedPreferences C(Context paramContext)
  {
    return paramContext.getSharedPreferences("qav_business", 4);
  }
  
  public static void C(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("public_account_config_data", paramString);
    paramContext.commit();
  }
  
  public static void C(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq_pre_down_yyb_ver_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static int D(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("hotchat_scene_config_version", 0);
  }
  
  public static int D(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("poke_config_appid");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void D(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buluo_red_dot_config_version_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static int E(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("camera_compatible_list_version", 0);
  }
  
  public static int E(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("pa_subcribe_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void E(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("qqhead_syncqzone_checkedstate");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static int F(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("dynamic_splash_config_version", 0);
  }
  
  public static int F(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("subscript_recommend_config_version");
    localStringBuilder.append("_");
    localStringBuilder.append("8.8.17.5770");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void F(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("qqhead_history_numflag");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static int G(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("shortvideo_progressive_blacklist_version", 0);
  }
  
  public static int G(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("redbag_fold_msg_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void G(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("contact_recommend_tab_config_version_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("updateContactRecommendTabConfigVersion version:");
      paramContext.append(paramInt);
      QLog.i("QQStoryFeedManager", 1, paramContext.toString());
    }
  }
  
  public static int H(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qqhotspot_config_version", 0);
  }
  
  public static int H(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("poke_bar_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void H(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cu_open_card_guide_config_appid_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt).apply();
  }
  
  public static int I(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("readinjoy_folder_setting_config_version", 0);
  }
  
  public static int I(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("heads_up_notify_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void I(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cu_open_card_guide_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
  
  public static int J(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("readinjoy_folder_config_id", 0);
  }
  
  public static void J(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("apollo_crossengine_version", paramString);
    paramContext.apply();
  }
  
  public static void J(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("app_guide_tips_config_version_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static SharedPreferences K(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qav_SP_");
    localStringBuilder.append(paramString);
    return paramContext.getSharedPreferences(localStringBuilder.toString(), 4);
  }
  
  public static String K(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("readinjoy_folder_nickname", "");
  }
  
  public static void K(Context paramContext, String paramString, int paramInt)
  {
    paramContext = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("sp_aio_config");
    paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 0).edit();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("receipt_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static int L(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("readinjoy_local_channel_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String L(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("readinjoy_folder_icon_url", "");
  }
  
  public static void L(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("qim_user_special_config_appid");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static int M(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("qwallet_setting_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void M(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("tim_user_special_config_appid");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static boolean M(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("kandian_read_data", true);
  }
  
  public static int N(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("passwd_red_bag_setting_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String N(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("show_hot_friend_days_setting", "3|30|3|30|3|30|3|30|5|7|30|7|30");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("result=");
      localStringBuilder.append(paramContext);
      QLog.d("HotFriend_GET_LOCAL_CONFIG", 2, localStringBuilder.toString());
    }
    return paramContext;
  }
  
  public static void N(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zhitu_config_version_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
  
  public static int O(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pre_download_dialog_version");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String O(Context paramContext)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 11) {
      i = 4;
    } else {
      i = 0;
    }
    return paramContext.getSharedPreferences("nearby_glamour", i).getString("nearby_glamour_level_config_info", null);
  }
  
  public static void O(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("conversation_unfollow_public_acc_version_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
  
  public static int P(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("scribble_config_ver", 0);
  }
  
  public static int P(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upgrade_tim_version");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String P(Context paramContext, String paramString, int paramInt)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_readinjoy_refresh_");
    localStringBuilder.append(paramInt);
    return paramContext.getString(localStringBuilder.toString(), null);
  }
  
  public static long Q(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upgrade_qq_time");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static String Q(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("scribble_gif_ver", "");
  }
  
  public static void Q(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_readinjoy_ad_material_is_preview");
    paramContext.putInt(localStringBuilder.toString(), paramInt).apply();
  }
  
  public static int R(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("photo_plus_sticker_version");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String R(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("scribble_paint_ver", "");
  }
  
  public static void R(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_readinjoy_ad_mini_game_shownum");
    paramContext.putInt(localStringBuilder.toString(), paramInt).apply();
  }
  
  public static int S(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("readinjoy_folder_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String S(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("scribble_gif_config_content", null);
  }
  
  public static void S(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zhitu_config_page_len_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
  
  public static int T(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy_merge_config_version_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String T(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("scribble_paint_config_content", null);
  }
  
  public static void T(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zhitu_safegate_request_interval_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
  
  public static int U(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("native_monitor_config_version_so_hook", -1);
  }
  
  public static int U(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy_crop_and_group_version_5770_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void U(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("native_monitor_config_appid");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static int V(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qim_music_cfg_version", 0);
  }
  
  public static int V(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy_remote_reset_config_version_5770_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void V(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("rich_text_chat_config_appid");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static int W(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qim_sticker_cfg_version", 0);
  }
  
  public static int W(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("long_text_msg_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void W(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("docs_structing_msg_gray_tips_remain_count_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
  
  public static int X(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qim_faceu_cfg_version", 0);
  }
  
  public static void X(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config_app_version_");
    localStringBuilder.append(paramString);
    paramContext.putString(localStringBuilder.toString(), "8.8.17");
    paramContext.commit();
  }
  
  public static void X(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("docs_structing_msg_gray_tips_group_showed_count_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
  
  public static String Y(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("docs_import_web_url", "");
  }
  
  public static void Y(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "setUpgradeAppid: invoked. ", " id: ", Integer.valueOf(paramInt), " uin: ", paramString });
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upgrade_appid_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
  
  public static boolean Y(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("config_app_version_");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    return TextUtils.equals(PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString, ""), "8.8.17") ^ true;
  }
  
  public static int Z(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hot_friend_chat_config_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void Z(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("sp_file_huiyin", 0).edit();
    paramContext.putBoolean("huiyin_was_used", true);
    paramContext.apply();
  }
  
  public static void Z(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "setDownloadDialogShownTimes: invoked. ", " times: ", Integer.valueOf(paramInt), " uin: ", paramString });
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download_dialog_shown_times_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
  
  public static int a(int paramInt, String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lastSeq");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(paramString);
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int a(BaseApplication paramBaseApplication)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramBaseApplication.getApplicationContext()).getInt("qim_dynamic_text_cfg_version", 0);
  }
  
  public static SharedPreferences a()
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("qav_ai_denoise", 4);
  }
  
  public static SharedPreferences a(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("aio_jump_lightalk_red_dot");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public static SharedPreferences a(String paramString1, String paramString2)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString1);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public static String a(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("last_loginuin_for_birthday_uin", "");
  }
  
  public static void a(int paramInt)
  {
    String str = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getAccount();
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("beancurd_config_version");
    localEditor.putInt(localStringBuilder.toString(), paramInt).apply();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lastSeq");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(paramString);
    localEditor.putInt(localStringBuilder.toString(), paramInt2);
    localEditor.commit();
  }
  
  public static void a(long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_mainP_thread_monitor_infos", 4).edit();
    localEditor.putLong("peakThreadCount", paramLong);
    localEditor.apply();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("entry_config_verion_code_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
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
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    int i = 1;
    int j;
    if (!paramBoolean)
    {
      j = paramContext.getInt("hotchat_scene_config_fcount", 0) + 1;
      if (j <= 5) {
        i = 0;
      }
    }
    else
    {
      j = 0;
    }
    paramContext = paramContext.edit();
    if (i != 0) {
      paramContext.putInt("hotchat_scene_config_version", paramInt);
    }
    paramContext.putInt("hotchat_scene_config_fcount", j);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, Boolean paramBoolean, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scribble_red_switch_conf_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean.booleanValue());
    paramContext.commit();
  }
  
  public static void a(Context paramContext, Float paramFloat, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scribble_red_version_conf_");
    localStringBuilder.append(paramString);
    paramContext.putFloat(localStringBuilder.toString(), paramFloat.floatValue());
    paramContext.commit();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("keyword_and_remark_version_code");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("poke_bar_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("aio_poke_touch_effect");
    paramContext.putInt(localStringBuilder.toString(), paramInt2);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("poke_bar_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("aio_unique_poke_show");
    paramContext.putInt(localStringBuilder.toString(), paramInt2);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("aio_unique_poke_type");
    paramContext.putInt(localStringBuilder.toString(), paramInt3);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("qim_user_special_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("qim_user_special_config_avatar_switch");
    paramContext.putInt(localStringBuilder.toString(), paramInt2);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("qim_user_special_config_title_bg_switch");
    paramContext.putInt(localStringBuilder.toString(), paramInt3);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("qim_user_special_config_bubble_switch");
    paramContext.putInt(localStringBuilder.toString(), paramInt4);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("qim_user_special_config_resources_url");
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append("qim_user_special_config_resources_md5");
    paramContext.putString(paramString2.toString(), paramString3);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append("qim_user_special_config_qim_website");
    paramContext.putString(paramString2.toString(), paramString4);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append("qim_user_special_config_online_wording");
    paramContext.putString(paramString2.toString(), paramString5);
    paramContext.putBoolean("qim_user_special_need_force_download", paramBoolean);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, long paramLong, String paramString2, String paramString3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("aio_poke_strength_rule_interval");
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("aio_poke_res_url");
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append("aio_poke_res_md5");
    paramContext.putString(paramString2.toString(), paramString3);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, Object paramObject)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    String str = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { paramString, "push_recommend_shield_config", Integer.valueOf(paramInt) });
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((paramInt != 3) || (!(paramObject instanceof String))) {
        break label125;
      }
      paramContext.edit().putString(str, (String)paramObject).apply();
    }
    else
    {
      if (!(paramObject instanceof Integer)) {
        break label125;
      }
      paramContext.edit().putInt(str, ((Integer)paramObject).intValue()).apply();
    }
    boolean bool = true;
    break label128;
    label125:
    bool = false;
    label128:
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.i("QQStoryFeedManager", 2, String.format(Locale.getDefault(), "updatePushRecommendShield [uin: %s, type: %d, value: %s, key: %s ret: %s]", new Object[] { paramString, Integer.valueOf(paramInt), paramObject, str, Boolean.valueOf(bool) }));
    }
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0))
    {
      if (paramContext == null) {
        return;
      }
      StringBuilder localStringBuilder;
      if (Build.VERSION.SDK_INT >= 11)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("SharedPreUtils_preference");
        localStringBuilder.append(paramString1);
        paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 4).edit();
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("SharedPreUtils_preference");
        localStringBuilder.append(paramString1);
        paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 0).edit();
      }
      paramContext.putInt(paramString2, paramInt);
      paramContext.commit();
    }
  }
  
  public static void a(Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("aio_poke_entry_type");
    paramContext.putInt(localStringBuilder.toString(), paramInt1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("aio_pe_view_type");
    paramContext.putInt(localStringBuilder.toString(), paramInt5);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("poke_emo_res_url");
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append("poke_emo_res_md5");
    paramContext.putString(paramString2.toString(), paramString3);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append("poke_emo_surprice_indexs");
    paramContext.putString(paramString2.toString(), paramString4);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append("poke_emo_order");
    paramContext.putString(paramString2.toString(), paramString5);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append("aio_pe_input_switch");
    paramContext.putInt(paramString2.toString(), paramInt2);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append("aio_pe_feed_back_switch");
    paramContext.putInt(paramString2.toString(), paramInt3);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append("aio_pe_bubble_limit_count");
    paramContext.putInt(paramString2.toString(), paramInt4);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_cloud_file_guide_banner&");
    localStringBuilder.append(paramString);
    localStringBuilder.append("&");
    localStringBuilder.append(paramInt);
    paramString = localStringBuilder.toString();
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString, paramBoolean);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("poke_bar_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt1);
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append("poke_bar_switch");
      paramContext.putInt(localStringBuilder.toString(), paramInt2);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append("poke_pad_switch");
      paramContext.putInt(localStringBuilder.toString(), paramInt3);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append("aio_poke_unitcount");
      paramContext.putInt(localStringBuilder.toString(), paramInt4);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append("aio_poke_unittime");
      paramContext.putInt(localStringBuilder.toString(), paramInt5);
    }
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("redbag_fold_msg_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("redbag_fold_msg_switch");
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("redbag_fold_msg_num");
    paramContext.putInt(localStringBuilder.toString(), paramInt2);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("redbag_fold_index_switch");
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean2);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("redbag_fold_index_with_redbagid");
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean3);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("heads_up_notify_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    if (paramBoolean1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append("heads_up_notify_switch");
      paramContext.putBoolean(localStringBuilder.toString(), paramBoolean2);
    }
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upgrade_qq_time");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reactive_will_downgrade_tips_time");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.apply();
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
    if (TextUtils.isEmpty(paramString2))
    {
      QLog.i("QQStoryFeedManager", 1, "setVerifiedPhoneShowRedDot phone is empty");
      return;
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("login_unverified_phone_show_red_dot");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.apply();
  }
  
  public static void a(Context paramContext, String paramString, JSONObject paramJSONObject)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("nearby_config_info");
    paramContext.putString(localStringBuilder.toString(), paramJSONObject.toString());
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    int i = 2;
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CNR setAutoLoginSharePre auto =");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("SharedPreUtils", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getPackageName());
      ((StringBuilder)localObject).append("_preferences");
      localObject = paramContext.getSharedPreferences(((StringBuilder)localObject).toString(), 4).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("login_auto");
      localStringBuilder.append(paramString);
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).commit();
      paramContext = paramContext.getSharedPreferences("sp_login_auto", 4).edit();
      if (!paramBoolean) {
        i = 1;
      }
      paramContext.putInt(paramString, i).commit();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SharedPreUtils", 2, "CNR setAutoLoginSharePre uin is null");
    }
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("game_invite");
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("game_invite_time");
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("hot_friend_days_contact");
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("hot_friend_days_chat");
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean2);
    paramContext.putString("show_hot_friend_days_setting", paramString2);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wifi_connect_switch_file_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("wifi_connect_switch_security_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean2);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("wifi_connect_switch_pdv_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean3);
    paramContext.apply();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kandian_interest_label_web_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
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
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager818searchProto_old", 2, "updateSearchDiscoveryLocalDataTime. ");
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("search_discovery_sp_prefixlast_update_time");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt1);
    localEditor = localEditor.putLong(localStringBuilder.toString(), System.currentTimeMillis());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("search_discovery_sp_prefixexpire_time");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt1);
    localEditor.putLong(localStringBuilder.toString(), paramInt2 * 1000).commit();
  }
  
  public static void a(String paramString, long paramLong)
  {
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putLong(paramString, paramLong).commit();
  }
  
  public static void a(String paramString, Object paramObject)
  {
    a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), true, paramString, paramObject);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_qqstory_feed_sp");
    paramString1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_qqstory_feed_timeout_second_");
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    BaseApplicationImpl.getApplication().getSharedPreferences(paramString1, 0).edit().putInt(paramString2, paramInt).apply();
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_qqstory_feed_sp");
    paramString1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_latest_q_zone_feed_second_");
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    BaseApplicationImpl.getApplication().getSharedPreferences(paramString1, 0).edit().putLong(paramString2, paramLong).apply();
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_is_has_show_troop_revoke_tip");
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.apply();
  }
  
  public static void a(String paramString, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfString.length - 1)
      {
        localStringBuilder1.append(paramArrayOfString[i]);
        localStringBuilder1.append("_");
        i += 1;
      }
      localStringBuilder1.append(paramArrayOfString[(paramArrayOfString.length - 1)]);
    }
    paramArrayOfString = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("pref_tag_hotword_title_list");
    localStringBuilder2.append(paramString);
    paramArrayOfString.putString(localStringBuilder2.toString(), localStringBuilder1.toString()).commit();
  }
  
  public static void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = a().edit();
    localEditor.putBoolean("support_ai_denoise", paramBoolean);
    localEditor.commit();
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("login_unverified_phone_show_red_dot");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager818searchProto_old", 2, "isSearchDiscoveryLocalDataExpired. ");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("search_discovery_sp_prefixlast_update_time");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("search_discovery_sp_prefixexpire_time");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    long l2 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    return System.currentTimeMillis() - l1 >= l2;
  }
  
  public static int aA(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qq_pre_down_yyb_ver_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int aB(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buluo_red_dot_config_version_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static boolean aC(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("is_show_buluo_red_num_red_dot");
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static int aD(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("qqhead_syncqzone_checkedstate");
    return paramContext.getInt(localStringBuilder.toString(), -1);
  }
  
  public static boolean aE(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("game_invite");
    localObject = ((StringBuilder)localObject).toString();
    boolean bool2 = false;
    boolean bool3 = paramContext.getBoolean((String)localObject, false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("game_invite_time");
    long l = paramContext.getLong(((StringBuilder)localObject).toString(), 0L);
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
  
  public static boolean aF(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("game_room");
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static int aG(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("qqhead_history_numflag");
    return paramContext.getInt(localStringBuilder.toString(), -1);
  }
  
  public static int aH(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("contact_recommend_tab_config_version_");
    localStringBuilder.append(paramString);
    int i = paramContext.getInt(localStringBuilder.toString(), 0);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getContactRecommendTabConfigVersion version:");
      paramContext.append(i);
      QLog.i("QQStoryFeedManager", 1, paramContext.toString());
    }
    return i;
  }
  
  public static int aI(Context paramContext, String paramString)
  {
    int i = f(paramString).getInt("boundaryFriendsCount", 5);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getContactRecommendTabBoundaryFriendsCount count:");
      paramContext.append(i);
      QLog.i("QQStoryFeedManager", 1, paramContext.toString());
    }
    return i;
  }
  
  public static int aJ(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doutu_config_version_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int aK(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cu_open_card_guide_config_appid_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int aL(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cu_open_card_guide_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String aM(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("video_redbag_res_md5_");
    localStringBuilder.append(paramString);
    return paramContext.getString(localStringBuilder.toString(), "");
  }
  
  public static String aN(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("video_redbag_res_url_");
    localStringBuilder.append(paramString);
    return paramContext.getString(localStringBuilder.toString(), "");
  }
  
  public static int aO(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("video_redbag_config_version_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String aP(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("video_compress_config_");
    localStringBuilder.append(paramString);
    return paramContext.getString(localStringBuilder.toString(), "");
  }
  
  public static void aQ(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("video_compress_config_");
    localStringBuilder.append(paramString);
    paramContext.remove(localStringBuilder.toString());
    paramContext.commit();
  }
  
  public static int aR(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("troop_robot_panel_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static boolean aS(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("troop_gift_to_all_tab");
    return paramContext.getBoolean(localStringBuilder.toString(), true);
  }
  
  public static int aT(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("app_guide_tips_config_version_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void aU(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("scribble_gif_ver", paramString);
    paramContext.commit();
  }
  
  public static void aV(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("scribble_paint_ver", paramString);
    paramContext.commit();
  }
  
  public static void aW(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("scribble_gif_config_content", paramString);
    paramContext.commit();
  }
  
  public static void aX(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("scribble_paint_config_content", paramString);
    paramContext.commit();
  }
  
  public static int aY(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scribble_red_switch_config_ver_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static boolean aZ(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scribble_switch_conf_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static int aa(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("mini_app_entry_auto_show", 0);
  }
  
  public static int aa(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hot_friend_new_boat_config_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void aa(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "setInstallDialogShownTimes: invoked. ", " times: ", Integer.valueOf(paramInt), " uin: ", paramString });
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("install_dialog_shown_times_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
  
  public static int ab(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add_contacts_view_config_version_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static boolean ab(Context paramContext, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_cloud_file_guide_banner&");
    localStringBuilder.append(paramString);
    localStringBuilder.append("&");
    localStringBuilder.append(paramInt);
    paramString = localStringBuilder.toString();
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString, true);
  }
  
  public static String ac(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add_contacts_view_config_");
    localStringBuilder.append(paramString);
    return paramContext.getString(localStringBuilder.toString(), "");
  }
  
  public static void ac(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_notification_push_gray_tips_today_count_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt).apply();
  }
  
  public static int ad(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("classic_head_activity_config_version_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void ad(Context paramContext, String paramString, int paramInt)
  {
    paramContext = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("sp_aio_config");
    paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 0).edit();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("aio_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static String ae(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("classic_head_activity_config_");
    localStringBuilder.append(paramString);
    return paramContext.getString(localStringBuilder.toString(), "");
  }
  
  public static void ae(Context paramContext, String paramString, int paramInt)
  {
    paramContext = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("sp_aio_config");
    paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 0).edit();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("multimsg_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static String af(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("buluo_enter_url_config", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("buluo_enter_url_config");
    return paramContext.getString(localStringBuilder.toString(), "");
  }
  
  public static String ag(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("buluo_profile_summary_url_config");
    return paramContext.getString(localStringBuilder.toString(), "https://buluo.qq.com/mobile/personal_v2.html?_wv=16778243");
  }
  
  public static String ah(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("hot_chat_link");
    paramContext = paramContext.getString(localStringBuilder.toString(), "https://play.mobile.qq.com/play/mqqplay/hotchat/index_v2.html?_wv=1027&_bid=2152");
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getHotChatLink,link:");
      paramString.append(paramContext);
      QLog.d("Q.qqstory", 2, paramString.toString());
    }
    if (TextUtils.isEmpty(paramContext)) {
      return "https://play.mobile.qq.com/play/mqqplay/hotchat/index_v2.html?_wv=1027&_bid=2152";
    }
    return paramContext;
  }
  
  public static int ai(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("aio_post_tab_plugin");
    int i = paramContext.getInt(localStringBuilder.toString(), 0);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getHotChatAIOPluginFlag,re:");
      paramContext.append(i);
      QLog.d("Q.hotchat.aio_post_list_plugin", 2, paramContext.toString());
    }
    return i;
  }
  
  public static void aj(Context paramContext, String paramString)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 11) {
      i = 4;
    } else {
      i = 0;
    }
    paramContext = paramContext.getSharedPreferences("nearby_glamour", i).edit();
    paramContext.putString("nearby_glamour_level_config_info", paramString);
    paramContext.commit();
  }
  
  public static int ak(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("medal_config_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int al(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("shortvideo_dynamic_adjustment");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int am(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("show");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int an(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("quick_shot_share_to_story_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String ao(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("story_player_proxy_config");
    return paramContext.getString(localStringBuilder.toString(), null);
  }
  
  public static int ap(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("msg_box_inter_follow_unread_count");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static boolean aq(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("local_set_top_troop_uploaded");
    localObject = ((StringBuilder)localObject).toString();
    boolean bool1 = false;
    boolean bool2 = paramContext.getBoolean((String)localObject, false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("local_set_top_troop_uploaded_repeat_count");
    int i = paramContext.getInt(((StringBuilder)localObject).toString(), 0);
    paramContext = paramContext.edit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("local_set_top_troop_uploaded_repeat_count");
    paramContext.putInt(((StringBuilder)localObject).toString(), i + 1).commit();
    if ((bool2) || (i >= 5)) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static void ar(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("local_set_top_troop_uploaded");
    paramContext.putBoolean(localStringBuilder.toString(), true);
    paramContext.commit();
  }
  
  public static List<String> as(Context paramContext, String paramString)
  {
    Object localObject = a;
    if (localObject != null) {
      return localObject;
    }
    a = new ArrayList();
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("local_set_top_troop_uploaded_ignore");
    paramContext = paramContext.getString(((StringBuilder)localObject).toString(), null);
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
  
  public static String at(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("troop_gift_url_config", 0).getString(paramString, "");
  }
  
  public static int au(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_gift_url_config_version_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int av(Context paramContext, String paramString)
  {
    return s("device_manage_switch_version");
  }
  
  public static String aw(Context paramContext, String paramString)
  {
    return r("device_manage_switch");
  }
  
  public static boolean ax(Context paramContext, String paramString)
  {
    return t("device_manage_has_show");
  }
  
  public static int ay(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_pobing_config_version_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String az(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("qq_pre_down_yyb", 0).getString(paramString, "");
  }
  
  public static int b(String paramString1, String paramString2)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("sp_aio_config");
    return localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 0).getInt(paramString2, 0);
  }
  
  public static SharedPreferences b(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qav_upgrade_invite");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public static String b(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("birthday_user", "");
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 4).edit();
    localEditor.putInt("av_pendant_download", paramInt1);
    localEditor.putInt("av_pendant_total", paramInt2);
    localEditor.commit();
  }
  
  public static void b(long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_mainP_thread_monitor_infos", 4).edit();
    localEditor.putLong("monitorStartTime", paramLong);
    localEditor.apply();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("group_video_version_code_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append("birthday_splash_version_code");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.putString("birthday_splash_md5value", paramString1);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, Float paramFloat, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scribble_plus_red_version_conf_");
    localStringBuilder.append(paramString);
    paramContext.putFloat(localStringBuilder.toString(), paramFloat.floatValue());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send_bless_version_code");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("poke_bar_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("aio_poke_combo_time");
    paramContext.putInt(localStringBuilder.toString(), paramInt2);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, int paramInt4)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("tim_user_special_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("tim_user_special_config_avatar_switch");
    paramContext.putInt(localStringBuilder.toString(), paramInt2);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("tim_user_special_config_title_bg_switch");
    paramContext.putInt(localStringBuilder.toString(), paramInt3);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("tim_user_special_config_bubble_switch");
    paramContext.putInt(localStringBuilder.toString(), paramInt4);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("tim_user_special_config_resources_url");
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append("tim_user_special_config_resources_md5");
    paramContext.putString(paramString2.toString(), paramString3);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append("tim_user_special_config_tim_website");
    paramContext.putString(paramString2.toString(), paramString4);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append("tim_user_special_config_online_wording");
    paramContext.putString(paramString2.toString(), paramString5);
    paramContext.putBoolean("tim_user_special_need_force_download", paramBoolean);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("long_text_msg_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("long_text_msg_switch");
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_msfpull_filter_switch");
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean2);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("graytips_call_last_alerttime");
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("readinjoy_folder_nickname", paramString1);
    paramContext.putString("readinjoy_folder_icon_url", paramString2);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append("msg_box_delete_msg_tab_flag");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_sharedpreutil", new Object[] { paramString1, paramString2 });
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString(paramString1, paramString3);
    paramContext.apply();
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_sharedpreutil", new Object[] { paramString1, paramString2 });
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean(paramString1, paramBoolean);
    paramContext.apply();
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("readinjoy_folder_setting_url", paramString);
    paramContext.putBoolean("readinjoy_folder_setting_btn", paramBoolean);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("kandian_read_data", paramBoolean);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, boolean paramBoolean, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scribble_switch_conf_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.commit();
  }
  
  public static void b(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager818searchProto_new", 2, "updateUnifyDiscoveryLocalDataTime. ");
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("search_discovery_sp_prefix_unifylast_update_time");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt1);
    localEditor = localEditor.putLong(localStringBuilder.toString(), System.currentTimeMillis());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("search_discovery_sp_prefix_unifyexpire_time");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt1);
    localEditor.putLong(localStringBuilder.toString(), paramInt2 * 1000).commit();
  }
  
  public static void b(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_close_noti_guid_banner_ts_");
    localStringBuilder.append(paramString);
    localEditor.putLong(localStringBuilder.toString(), paramLong).apply();
  }
  
  public static void b(String paramString, Object paramObject)
  {
    a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), false, paramString, paramObject);
  }
  
  public static void b(String paramString1, String paramString2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_qqstory_feed_sp");
    paramString1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_latest_signature_feed_second_");
    localStringBuilder.append(paramString2);
    paramString2 = localStringBuilder.toString();
    BaseApplicationImpl.getApplication().getSharedPreferences(paramString1, 0).edit().putLong(paramString2, paramLong).apply();
  }
  
  public static void b(String paramString, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfString.length - 1)
      {
        localStringBuilder1.append(paramArrayOfString[i]);
        localStringBuilder1.append("_");
        i += 1;
      }
      localStringBuilder1.append(paramArrayOfString[(paramArrayOfString.length - 1)]);
    }
    paramArrayOfString = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("pref_tag_unify_hotword_title_list");
    localStringBuilder2.append(paramString);
    paramArrayOfString.putString(localStringBuilder2.toString(), localStringBuilder1.toString()).commit();
  }
  
  public static void b(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = a().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setEnableDoubleAIDenoise = ");
    localStringBuilder.append(paramBoolean);
    QLog.i("SharedPreUtils", 1, localStringBuilder.toString());
    localEditor.putBoolean("enable_double_ai_denoise", paramBoolean);
    localEditor.commit();
  }
  
  public static boolean b()
  {
    return a().getBoolean("support_ai_denoise", false);
  }
  
  public static boolean b(int paramInt, String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hasClicked");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(paramString);
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static boolean b(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      bool1 = bool2;
      if (paramString1.length() != 0)
      {
        if (paramContext == null) {
          return false;
        }
        StringBuilder localStringBuilder;
        if (Build.VERSION.SDK_INT >= 11)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("SharedPreUtils_preference");
          localStringBuilder.append(paramString1);
          paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 4);
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("SharedPreUtils_preference");
          localStringBuilder.append(paramString1);
          paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 0);
        }
        bool1 = bool2;
        if (paramInt > paramContext.getInt(paramString2, 0)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager818searchProto_new", 2, "isUnifyDiscoveryLocalDataExpired. ");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("search_discovery_sp_prefix_unifylast_update_time");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("search_discovery_sp_prefix_unifyexpire_time");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    long l2 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    return System.currentTimeMillis() - l1 >= l2;
  }
  
  public static boolean bA(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zhitu_setting_switch_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), true);
  }
  
  public static int bB(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zhitu_config_page_len_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 8);
  }
  
  public static boolean bC(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zhitu_config_save_share_switch_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static boolean bD(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zhitu_safegate_switch_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static long bE(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zhitu_safegate_request_time_");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static int bF(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zhitu_safegate_request_interval_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int bG(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("aio_story_feed_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String bH(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("story_halo_config_json");
    return paramContext.getString(localStringBuilder.toString(), "");
  }
  
  public static int bI(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("story_halo_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int bJ(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("native_monitor_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int bK(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("native_monitor_config_appid");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static boolean bL(Context paramContext, String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if (QQAppInterface.class.isInstance(paramContext)) {
      paramContext = ((QQAppInterface)paramContext).getCurrentUin();
    } else {
      paramContext = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("qim_video_combol_lock_info");
    localStringBuilder.append("_");
    localStringBuilder.append(paramContext);
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
  }
  
  public static int bM(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("rich_text_chat_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int bN(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("rich_text_chat_config_appid");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static boolean bO(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("rich_text_first_time_tab_showed");
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static boolean bP(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rich_text_chat_config_settting_switch_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), true);
  }
  
  public static int bQ(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("docs_structing_msg_gray_tips_remain_count_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int bR(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("docs_structing_msg_gray_tips_group_showed_count_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int bS(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upgrade_appid_");
    localStringBuilder.append(paramString);
    int i = paramContext.getInt(localStringBuilder.toString(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "getUpgradeAppid: invoked. ", " appid: ", Integer.valueOf(i), " uin: ", paramString });
    }
    return i;
  }
  
  public static int bT(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download_dialog_shown_times_");
    localStringBuilder.append(paramString);
    int i = paramContext.getInt(localStringBuilder.toString(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "getDownloadDialogShownTimes: invoked. ", " times: ", Integer.valueOf(i), " uin: ", paramString });
    }
    return i;
  }
  
  public static long bU(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download_dialog_shown_timestamp_");
    localStringBuilder.append(paramString);
    long l = paramContext.getLong(localStringBuilder.toString(), 0L);
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "getDownloadDialogShownTimestamp: invoked. ", " ts: ", Long.valueOf(l), " uin: ", paramString });
    }
    return l;
  }
  
  public static int bV(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("install_dialog_shown_times_");
    localStringBuilder.append(paramString);
    int i = paramContext.getInt(localStringBuilder.toString(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "getInstallDialogShownTimes: invoked. ", " times: ", Integer.valueOf(i), " uin: ", paramString });
    }
    return i;
  }
  
  public static long bW(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("install_dialog_shown_timestamp_");
    localStringBuilder.append(paramString);
    long l = paramContext.getLong(localStringBuilder.toString(), 0L);
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "getInstallDialogShownTimestamp: invoked. ", " ts: ", Long.valueOf(l), " uin: ", paramString });
    }
    return l;
  }
  
  public static boolean bX(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("docs_export_file_is_first_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), true);
  }
  
  public static void bY(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("docs_import_web_url", paramString);
    paramContext.apply();
  }
  
  public static int bZ(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("sso_list", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_sso_list_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static boolean ba(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scribble_red_switch_conf_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static Float bb(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scribble_red_version_conf_");
    localStringBuilder.append(paramString);
    return Float.valueOf(paramContext.getFloat(localStringBuilder.toString(), 0.0F));
  }
  
  public static boolean bc(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scribble_plus_red_switch_conf_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static Float bd(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scribble_plus_red_version_conf_");
    localStringBuilder.append(paramString);
    return Float.valueOf(paramContext.getFloat(localStringBuilder.toString(), 0.0F));
  }
  
  public static long be(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("graytips_call_last_alerttime");
    return paramContext.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static boolean bf(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("troop_effect_pic_guide");
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static void bg(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("troop_effect_pic_guide");
    paramContext.putBoolean(localStringBuilder.toString(), true);
    paramContext.commit();
  }
  
  public static int bh(Context paramContext, String paramString)
  {
    paramContext = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("sp_aio_config");
    paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("receipt_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static long bi(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_req_troop_effect_config");
    return paramContext.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static int bj(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("qim_user_special_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int bk(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("qim_user_special_config_appid");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int bl(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("tim_user_special_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int bm(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("tim_user_special_config_appid");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int bn(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zhitu_config_version_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static boolean bo(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zhitu_config_switch_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static int bp(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("conversation_unfollow_public_acc_version_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static boolean bq(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("conversation_unfollow_public_acc_switch_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static String br(Context paramContext, String paramString)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_readinjoy_skin");
    return paramContext.getString(localStringBuilder.toString(), null);
  }
  
  public static void bs(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_readinjoy_diandian_guide");
    paramContext.putBoolean(localStringBuilder.toString(), true).commit();
  }
  
  public static long bt(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy_skin_guide_seq_");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static long bu(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_readinjoy_skin_guide_time");
    return paramContext.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static void bv(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_readinjoy_skin_guide_time");
    paramContext.putLong(localStringBuilder.toString(), System.currentTimeMillis()).commit();
  }
  
  public static int bw(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_readinjoy_ad_material_is_preview");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static long bx(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_readinjoy_ad_mini_game_lastshowtime");
    return paramContext.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static int by(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_readinjoy_ad_mini_game_shownum");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static boolean bz(Context paramContext, String paramString)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_readinjoy_skin_volume");
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static int c(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("AvWeakNet_video_version_code", 0);
  }
  
  public static int c(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("entry_config_verion_code_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int c(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static SharedPreferences c(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AvWeakNet_video_version_code");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public static Object c(String paramString, Object paramObject)
  {
    return a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramString, paramObject);
  }
  
  public static String c(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_sharedpreutil", new Object[] { paramString1, paramString2 });
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString1, paramString3);
  }
  
  public static void c(int paramInt, String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hasClicked");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(paramString);
    localEditor.putBoolean(localStringBuilder.toString(), true);
    localEditor.commit();
  }
  
  public static void c(long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putLong("X5Update", paramLong);
    localEditor.commit();
  }
  
  public static void c(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("sp_had_overload_extension_error", paramInt);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("qfind_pidlist_version_code");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("add_contacts_view_config_version_");
    localStringBuilder.append(paramString1);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("add_contacts_view_config_");
    localStringBuilder.append(paramString1);
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("nearby_flower_gray_tips_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("now_entrance_action_info");
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt1);
    paramContext.putInt(localStringBuilder.toString(), paramInt2);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("poke_bar_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append("aio_poke_panel_config");
      paramContext.putString(localStringBuilder.toString(), paramString2);
    }
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_req_troop_effect_config");
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_version", new Object[] { paramString1, paramString2 });
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1, paramInt);
    paramContext.apply();
  }
  
  public static void c(Context paramContext, String paramString, boolean paramBoolean)
  {
    a(paramContext, paramString, false, "device_manage_has_show", Boolean.valueOf(paramBoolean));
  }
  
  public static void c(Context paramContext, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("kandian_video_sound", paramBoolean);
    paramContext.commit();
  }
  
  public static void c(Context paramContext, boolean paramBoolean, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scribble_plus_red_switch_conf_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.commit();
  }
  
  public static void c(String paramString, int paramInt)
  {
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putInt(paramString, paramInt).commit();
  }
  
  public static void c(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = a().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setEnableGroupAIDenoise = ");
    localStringBuilder.append(paramBoolean);
    QLog.i("SharedPreUtils", 1, localStringBuilder.toString());
    localEditor.putBoolean("enable_group_ai_denoise", paramBoolean);
    localEditor.commit();
  }
  
  public static boolean c()
  {
    boolean bool = a().getBoolean("enable_double_ai_denoise", false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currentDoubleAIDenoiseStatus = ");
    localStringBuilder.append(bool);
    QLog.i("SharedPreUtils", 1, localStringBuilder.toString());
    return bool;
  }
  
  public static boolean c(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_sharedpreutil", new Object[] { paramString1, paramString2 });
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(paramString1, paramBoolean);
  }
  
  public static int ca(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("sso_list", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_sso_list_appid");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static long cb(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_notification_push_gray_tips_time_millis_today_zero_");
    localStringBuilder.append(paramString);
    return paramContext.getLong(localStringBuilder.toString(), 0L);
  }
  
  public static int cc(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_notification_push_gray_tips_today_count_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int cd(Context paramContext, String paramString)
  {
    paramContext = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("sp_aio_config");
    paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("aio_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int ce(Context paramContext, String paramString)
  {
    paramContext = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("sp_aio_config");
    paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("multimsg_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static boolean cf(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emotion_edit_guide_pop_switch_");
    localStringBuilder.append(paramString);
    return paramContext.getBoolean(localStringBuilder.toString(), true);
  }
  
  public static void cg(Context paramContext, String paramString)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_smart_manager_");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals("on"))) {
      bool = true;
    } else {
      bool = false;
    }
    paramContext.edit().putBoolean(str, bool).apply();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("updateTroopSmartManagerSwitch, key: ");
      paramContext.append(str);
      paramContext.append(" ,isOn: ");
      paramContext.append(bool);
      QLog.d("TroopSmartManager", 2, paramContext.toString());
    }
  }
  
  public static int d(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("eqq_config_version_code", 0);
  }
  
  public static int d(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("group_video_version_code_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static SharedPreferences d(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qav_anychat_time_limit");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
  }
  
  public static void d(int paramInt, String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_sticker_bubble_last_send_id");
    localEditor.putInt(localStringBuilder.toString(), paramInt).apply();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("classic_head_activity_config_version_");
    localStringBuilder.append(paramString1);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("classic_head_activity_config_");
    localStringBuilder.append(paramString1);
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramContext.commit();
  }
  
  public static void d(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("nearby_hotchat_v_list_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("story_halo_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append("story_halo_config_json");
      paramContext.putString(localStringBuilder.toString(), paramString2);
    }
    paramContext.apply();
  }
  
  public static void d(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy_skin_guide_seq_");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong).commit();
  }
  
  public static void d(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString1);
    paramContext.remove(localStringBuilder.toString());
    paramContext.commit();
  }
  
  public static void d(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_appid", new Object[] { paramString1, paramString2 });
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString1, paramInt);
    paramContext.apply();
  }
  
  public static void d(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramContext = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("sp_aio_config");
    paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 0).edit();
    paramContext.putString(paramString2, paramString3);
    paramContext.apply();
  }
  
  public static void d(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("is_show_buluo_red_num_red_dot");
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.commit();
  }
  
  public static void d(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putBoolean("poke_emo_download_mark", paramBoolean);
    localEditor.commit();
  }
  
  public static boolean d()
  {
    boolean bool = a().getBoolean("enable_group_ai_denoise", true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currentGroupAIDenoiseStatus = ");
    localStringBuilder.append(bool);
    QLog.i("SharedPreUtils", 1, localStringBuilder.toString());
    return bool;
  }
  
  public static boolean d(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramContext = new StringBuilder();
      paramContext.append(paramString2);
      paramContext.append("_");
      paramContext.append(paramString1);
      paramContext = paramContext.toString();
    }
    return localSharedPreferences.getBoolean(paramContext, paramBoolean);
  }
  
  public static int e(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("individuation_abtest_code_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static SharedPreferences e(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qav_score");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 4);
  }
  
  public static String e(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("eqq-config-data", null);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("pushbanner_ad_version_code");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void e(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("green_video_appid");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void e(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("aio_story_feed_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append("aio_story_feed_config_json");
      paramContext.putString(localStringBuilder.toString(), paramString2);
    }
    paramContext.apply();
  }
  
  public static void e(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_readinjoy_ad_mini_game_lastshowtime");
    paramContext.putLong(localStringBuilder.toString(), paramLong).apply();
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("buluo_enter_url_config", 4).edit();
    if (!TextUtils.isEmpty(paramString2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append("buluo_enter_url_config");
      paramContext.putString(localStringBuilder.toString(), paramString2);
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("_");
      paramString2.append("buluo_enter_url_config");
      paramContext.remove(paramString2.toString());
    }
    paramContext.commit();
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramContext = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("sp_aio_config");
    paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 0).edit();
    paramContext.putInt(paramString2, paramInt);
    paramContext.apply();
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reactive_notification_time");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString3);
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramContext.apply();
  }
  
  public static void e(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramContext = new StringBuilder();
      paramContext.append(paramString2);
      paramContext.append("_");
      paramContext.append(paramString1);
      paramContext = paramContext.toString();
    }
    localEditor.putBoolean(paramContext, paramBoolean);
    localEditor.commit();
  }
  
  public static void e(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("game_room");
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.commit();
  }
  
  public static int[] e()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 4);
    return new int[] { localSharedPreferences.getInt("filter_download", 0), localSharedPreferences.getInt("filter_total", 0) };
  }
  
  public static int f(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("sp_had_overload_extension_error", 0);
  }
  
  public static long f()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 4).getLong("filter_spacing", 0L);
  }
  
  public static SharedPreferences f(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("contact_recommend_sp");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("general_configs_version_code_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void f(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("eqq-config-data", paramString);
    paramContext.commit();
  }
  
  public static void f(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("green_video_config_version_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void f(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("native_monitor_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("native_monitor_config_content");
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramContext.commit();
  }
  
  public static void f(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zhitu_safegate_request_time_");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.apply();
  }
  
  public static void f(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("buluo_profile_summary_url_config");
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramContext.commit();
  }
  
  public static void f(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit();
    if (paramString2 == null)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("_readinjoy_refresh_");
      paramString2.append(paramInt);
      paramContext.remove(paramString2.toString());
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_readinjoy_refresh_");
      localStringBuilder.append(paramInt);
      paramContext.putString(localStringBuilder.toString(), paramString2);
    }
    paramContext.commit();
  }
  
  public static void f(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("has_show_robot_chat_waring_banner");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.apply();
  }
  
  public static void f(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("troop_gift_to_all_tab");
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.commit();
  }
  
  public static int g(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("splash_version_code", 0);
  }
  
  public static int g(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("hotchat_classify_version_code");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static SharedPreferences g(String paramString)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("extend_friend_config_785");
    localStringBuilder.append(paramString);
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 4);
  }
  
  public static void g()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 0).edit();
    localEditor.putBoolean("qq_filter_flag", true);
    localEditor.commit();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("general_android_configs_version_code_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void g(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("video_compress_config_appid");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void g(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("rich_text_chat_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append("rich_text_chat_config_content");
      paramContext.putString(localStringBuilder.toString(), paramString2);
    }
    paramContext.commit();
  }
  
  public static void g(Context paramContext, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "setDownloadDialogShownTimestamp: invoked. ", " ts: ", Long.valueOf(paramLong), " uin: ", paramString });
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download_dialog_shown_timestamp_");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.apply();
  }
  
  public static void g(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("hot_chat_link");
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramContext.commit();
  }
  
  public static void g(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramContext = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append("sp_aio_config");
    paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 0).edit();
    paramContext.putInt(paramString2, paramInt);
    paramContext.apply();
  }
  
  public static void g(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("conversation_unfollow_public_acc_switch_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.apply();
  }
  
  public static int h(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext != null)
      {
        int i = paramContext.versionCode;
        return i;
      }
      return 0;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static int h(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("qfind_pidlist_version_code");
    return paramContext.getInt(localStringBuilder.toString(), 0);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("qav_upgrade_invite_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void h(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("video_compress_config_version_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void h(Context paramContext, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryFeedManager", 2, new Object[] { "setInstallDialogShownTimestamp: invoked. ", " ts: ", Long.valueOf(paramLong), " uin: ", paramString });
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("install_dialog_shown_timestamp_");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong);
    paramContext.apply();
  }
  
  public static void h(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (!TextUtils.isEmpty(paramString2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append("quick_shot_share_to_story_config");
      paramContext.putString(localStringBuilder.toString(), paramString2);
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("_");
      paramString2.append("quick_shot_share_to_story_config");
      paramContext.remove(paramString2.toString());
    }
    paramContext.commit();
  }
  
  public static void h(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_readinjoy_skin_volume");
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.commit();
  }
  
  public static void h(String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("clean_disk_cache_time");
    localEditor.putLong(localStringBuilder.toString(), NetConnInfoCenter.getServerTime() / 3600L);
    localEditor.commit();
  }
  
  public static boolean h()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qq_filter_download", 0).getBoolean("qq_filter_flag", false);
  }
  
  public static int i(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("nearby_chat_gray_tips_config_version", 0);
  }
  
  public static int i(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static long i(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("clean_disk_cache_time");
    return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("qav_anychat_time_limit_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void i(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("poke_config_appid");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void i(Context paramContext, String paramString, long paramLong)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_notification_push_gray_tips_time_millis_today_zero_");
    localStringBuilder.append(paramString);
    paramContext.putLong(localStringBuilder.toString(), paramLong).apply();
  }
  
  public static void i(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    if (!TextUtils.isEmpty(paramString2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append("story_player_proxy_config");
      paramContext.putString(localStringBuilder.toString(), paramString2);
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("_");
      paramString2.append("story_player_proxy_config");
      paramContext.remove(paramString2.toString());
    }
    paramContext.commit();
  }
  
  public static void i(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zhitu_config_switch_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.apply();
  }
  
  public static int[] i()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 4);
    return new int[] { localSharedPreferences.getInt("av_pendant_download", 0), localSharedPreferences.getInt("av_pendant_total", 0) };
  }
  
  public static int j(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("troop_rank_map_config_version", 0);
  }
  
  public static int j(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("pushbanner_ad_version_code");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int j(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append("msg_box_delete_msg_tab_flag");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void j()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 4).edit();
    localEditor.putLong("av_pendant_spacing", System.currentTimeMillis());
    localEditor.commit();
  }
  
  public static void j(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("ptv_bless_special_pendant_cfg_version", paramInt);
    paramContext.commit();
  }
  
  public static void j(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("now_tab_config_cmd_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void j(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("subscript_recommend_config_version");
    localStringBuilder.append("_");
    localStringBuilder.append("8.8.17.5770");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void j(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zhitu_config_save_share_switch_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.apply();
  }
  
  public static boolean j(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_is_has_show_troop_revoke_tip");
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static int k(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("birthday_splash_version_code");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static long k()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 4).getLong("av_pendant_spacing", 0L);
  }
  
  public static long k(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getLong(paramString, 0L);
  }
  
  public static String k(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("green_video_list", "HUAWEI;HUAWEI NXT-AL10;24|HUAWEI;FRD-AL00;24|HUAWEI;EVA-AL00;24|HUAWEI;KNT-AL10;24|HUAWEI;EDI-AL10;24");
  }
  
  public static void k(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("apollo_switch", paramInt);
    paramContext.commit();
  }
  
  public static void k(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("now_download_engine_cmd_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void k(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("readinjoy_local_channel_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void k(Context paramContext, String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("local_set_top_troop_uploaded_ignore");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramString1);
    localStringBuilder2.append("_");
    localStringBuilder2.append("local_set_top_troop_uploaded_ignore");
    localStringBuilder1.append(localSharedPreferences.getString(localStringBuilder2.toString(), ""));
    localStringBuilder1.append("_");
    localStringBuilder1.append(paramString2);
    localEditor.putString((String)localObject, localStringBuilder1.toString());
    localEditor.commit();
    if (a == null) {
      a = as(paramContext, paramString1);
    }
    a.add(paramString2);
  }
  
  public static void k(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zhitu_safegate_switch_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.apply();
  }
  
  public static int l(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("keyword_and_remark_version_code");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int l(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getInt(paramString, 0);
  }
  
  public static void l()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 0).edit();
    localEditor.putBoolean("av_pendant_flag", true);
    localEditor.commit();
  }
  
  public static void l(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.remove("green_video_list");
    paramContext.commit();
  }
  
  public static void l(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("apollo_3d_switch", paramInt);
    paramContext.commit();
  }
  
  public static void l(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("videodown_ct_whitelist_version", paramInt);
    paramContext.putString("videodown_ct_whitelist", paramString);
    paramContext.commit();
  }
  
  public static void l(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("passwd_red_bag_setting_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
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
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if (QQAppInterface.class.isInstance(paramContext)) {
      paramContext = ((QQAppInterface)paramContext).getCurrentUin();
    } else {
      paramContext = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("qim_video_combol_lock_info");
    localStringBuilder.append("_");
    localStringBuilder.append(paramContext);
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  public static int m(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ptv_template_cfg_version", 0);
  }
  
  public static int m(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("send_bless_version_code");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void m(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("camera_compatible_list_version", paramInt);
    paramContext.commit();
  }
  
  public static void m(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("mix_msg_forward_config_version", paramInt);
    paramContext.putString("mix_msg_forward_config", paramString);
    paramContext.commit();
  }
  
  public static void m(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pre_download_dialog_version");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void m(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, paramString1, false, "device_manage_switch", paramString2);
  }
  
  public static void m(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("rich_text_first_time_tab_showed");
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.commit();
  }
  
  public static boolean m()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("av_pendant_download_info", 0).getBoolean("av_pendant_flag", false);
  }
  
  public static String[] m(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_tag_hotword_title_list");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getString(localStringBuilder.toString(), "").split("_");
  }
  
  public static int n(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("capture_ptv_template_cfg_version", 0);
  }
  
  public static long n()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qq_mainP_thread_monitor_infos", 4).getLong("peakThreadCount", 0L);
  }
  
  public static void n(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("shortvideo_progressive_blacklist_version", paramInt);
    paramContext.commit();
  }
  
  public static void n(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy_merge_config_version_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void n(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upgrade_tim_version");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void n(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("qq_pre_down_yyb", 0);
    paramContext.edit().putString(paramString1, paramString2);
    paramContext.edit().commit();
  }
  
  public static void n(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rich_text_chat_config_settting_switch_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.apply();
  }
  
  public static boolean n(Context paramContext, String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("translate_bubble_first_time", true);
    }
    return false;
  }
  
  public static String[] n(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_tag_unify_hotword_title_list");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getString(localStringBuilder.toString(), "").split("_");
  }
  
  public static int o(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ptv_template_web_cfg_version", 0);
  }
  
  public static long o()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qq_mainP_thread_monitor_infos", 4).getLong("monitorStartTime", 0L);
  }
  
  public static long o(String paramString)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_close_noti_guid_banner_ts_");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getLong(localStringBuilder.toString(), -1L);
  }
  
  public static void o(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("readinjoy_folder_setting_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void o(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy_crop_and_group_version_5770_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void o(Context paramContext, String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.putBoolean("translate_bubble_first_time", false);
      paramContext.commit();
    }
  }
  
  public static void o(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("photo_plus_sticker_version");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void o(Context paramContext, String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = f(paramString1).edit();
    paramContext = new StringBuilder();
    paramContext.append("contact_recommend_tab_config_json_");
    paramContext.append(paramString1);
    paramString1 = paramContext.toString();
    if (paramString2 == null) {
      paramContext = "";
    } else {
      paramContext = paramString2;
    }
    localEditor.putString(paramString1, paramContext);
    try
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        paramContext = new JSONObject(paramString2);
        if (paramContext.has("boundaryFriendsCount")) {
          localEditor.putInt("boundaryFriendsCount", paramContext.optInt("boundaryFriendsCount"));
        }
      }
    }
    catch (Exception paramContext)
    {
      paramString1 = new StringBuilder();
      paramString1.append("updateContactRecommendTabConfigJson error:");
      paramString1.append(paramContext.getMessage());
      QLog.e("QQStoryFeedManager", 1, paramString1.toString());
    }
    localEditor.commit();
  }
  
  public static void o(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("docs_export_file_is_first_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.apply();
  }
  
  public static int p(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("doodle_template_cfg_version", 0);
  }
  
  public static int p(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("general_configs_version_code_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int p(String paramString)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_sticker_bubble_last_send_id");
    return localSharedPreferences.getInt(localStringBuilder.toString(), 1);
  }
  
  public static void p(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("readinjoy_folder_config_id", paramInt);
    paramContext.commit();
  }
  
  public static void p(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readinjoy_remote_reset_config_version_5770_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void p(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("readinjoy_folder_config_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void p(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("video_compress_config_");
    localStringBuilder.append(paramString1);
    paramContext.putString(localStringBuilder.toString(), paramString2);
    paramContext.commit();
  }
  
  public static void p(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("emotion_edit_guide_pop_switch_");
    localStringBuilder.append(paramString);
    paramContext.putBoolean(localStringBuilder.toString(), paramBoolean);
    paramContext.commit();
  }
  
  public static boolean p()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean("poke_emo_download_mark", false);
  }
  
  public static int q()
  {
    String str = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getAccount();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("beancurd_config_version");
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int q(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("doodle_template_cfg_version", 0);
  }
  
  public static int q(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("general_android_configs_version_code_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int q(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_version", new Object[] { paramString1, paramString2 });
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString1, 0);
  }
  
  public static void q(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("scribble_config_ver", paramInt);
    paramContext.commit();
  }
  
  public static void q(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hot_friend_chat_config_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void q(String paramString)
  {
    String str = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getAccount();
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("beancurd_config_data");
    localEditor.putString(localStringBuilder.toString(), paramString);
  }
  
  public static boolean q(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    boolean bool = false;
    StringBuilder localStringBuilder;
    if (paramInt == 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append("hot_friend_days_contact");
      bool = paramContext.getBoolean(localStringBuilder.toString(), false);
    }
    else if (paramInt == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append("hot_friend_days_chat");
      bool = paramContext.getBoolean(localStringBuilder.toString(), false);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("type= ");
      paramContext.append(paramInt);
      paramContext.append(",result=");
      paramContext.append(bool);
      QLog.d("HotFriend_GET_LOCAL_CONFIG", 2, paramContext.toString());
    }
    return bool;
  }
  
  public static int r(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("ptv_bless_special_pendant_cfg_version", 0);
  }
  
  public static int r(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("qav_upgrade_invite_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int r(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_appid", new Object[] { paramString1, paramString2 });
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString1, 0);
  }
  
  public static String r()
  {
    String str = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getAccount();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("beancurd_config_data");
    return localSharedPreferences.getString(localStringBuilder.toString(), "");
  }
  
  public static String r(String paramString)
  {
    return (String)c(paramString, "");
  }
  
  public static void r(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("unite_search_trigger_number", paramInt);
    paramContext.commit();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("setUniteSearchTriggerNum:");
      paramContext.append(paramInt);
      QLog.d("Q.uniteSearch.setUniteSearchTriggerNum", 2, paramContext.toString());
    }
  }
  
  public static void r(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hot_friend_new_boat_config_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void r(Context paramContext, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateSupportFriendshipReactive code: ");
      localStringBuilder.append(paramInt);
      QLog.d("QQStoryFeedManager", 2, localStringBuilder.toString());
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("hot_friendship_support_key");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static int s(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("public_account_config_version", 0);
  }
  
  public static int s(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("qav_anychat_time_limit_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int s(String paramString)
  {
    return ((Integer)c(paramString, Integer.valueOf(0))).intValue();
  }
  
  public static long s()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getLong("X5Update", 0L);
  }
  
  public static String s(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = String.format(Locale.getDefault(), "%s_%s_config_content", new Object[] { paramString1, paramString2 });
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString1, "");
  }
  
  public static void s(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("unify_search_unite_trigger_number", paramInt);
    paramContext.commit();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("setUnifySearchUniteTriggerNum:");
      paramContext.append(paramInt);
      QLog.d("Q.uniteSearch.setUnifySearchUniteTriggerNum", 2, paramContext.toString());
    }
  }
  
  public static void s(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("shortvideo_dynamic_adjustment");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void s(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("create_troop_max_invite_num");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static int t(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("now_tab_config_cmd_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String t(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("public_account_config_data", null);
  }
  
  public static void t(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("native_monitor_config_version_so_hook", paramInt);
    paramContext.apply();
  }
  
  public static void t(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("medal_config_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void t(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("aio_post_tab_plugin");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("updateHotChatAIOPluginFlag,re:");
      paramString.append(paramInt);
      QLog.d("Q.hotchat.aio_post_list_plugin", 2, paramString.toString());
    }
    paramContext.commit();
  }
  
  public static void t(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_isClickEnterEffectGrayTipsEntrance_");
    localStringBuilder.append(paramString2);
    paramContext.putBoolean(localStringBuilder.toString(), true);
    paramContext.commit();
  }
  
  public static boolean t()
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_smart_manager_");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    boolean bool = ((SharedPreferences)localObject).getBoolean(str, false);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopSmartManagerSwitch, key: ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" ,isOn: ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("TroopSmartManager", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public static boolean t(String paramString)
  {
    return ((Boolean)c(paramString, Boolean.valueOf(false))).booleanValue();
  }
  
  public static int u(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("videodown_ct_whitelist_version", 0);
  }
  
  public static int u(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("now_download_engine_cmd_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void u(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("mini_app_entry_auto_show", paramInt);
    paramContext.apply();
  }
  
  public static void u(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scribble_red_switch_config_ver_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void u(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("show");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void u(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit();
    if (paramString2 == null)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("_readinjoy_skin");
      paramContext.remove(paramString2.toString());
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_readinjoy_skin");
      paramContext.putString(localStringBuilder.toString(), paramString2);
    }
    paramContext.commit();
  }
  
  public static int v(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("nearby_flower_gray_tips_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int v(Context paramContext, String paramString, int paramInt)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { paramString, "medal_strong_reminder_config", Integer.valueOf(paramInt) }), 0);
  }
  
  public static String v(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("videodown_ct_whitelist", null);
  }
  
  public static void v(Context paramContext, int paramInt, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("sso_list", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_sso_list_version");
    paramContext.putInt(localStringBuilder.toString(), paramInt).apply();
  }
  
  public static boolean v(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_readinjoy_skin_guide_");
    localStringBuilder.append(paramString2);
    return paramContext.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static int w(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("mix_msg_forward_config_version", 0);
  }
  
  public static int w(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("nearby_hotchat_v_list_config_version");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static Object w(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    paramString = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { paramString, "push_recommend_shield_config", Integer.valueOf(paramInt) });
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3) {
        return null;
      }
      return paramContext.getString(paramString, "");
    }
    return Integer.valueOf(paramContext.getInt(paramString, 0));
  }
  
  public static void w(Context paramContext, int paramInt, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("sso_list", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_sso_list_appid");
    paramContext.putInt(localStringBuilder.toString(), paramInt).apply();
  }
  
  public static void w(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_readinjoy_skin_guide_");
    localStringBuilder.append(paramString2);
    paramContext.putBoolean(localStringBuilder.toString(), true).commit();
  }
  
  public static String x(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("mix_msg_forward_config", null);
  }
  
  public static void x(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("green_video_list", paramString);
    paramContext.commit();
  }
  
  public static void x(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder;
    if (paramInt == -1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append("quick_shot_share_to_story_config_version");
      paramContext.remove(localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append("quick_shot_share_to_story_config_version");
      paramContext.putInt(localStringBuilder.toString(), paramInt);
    }
    paramContext.commit();
  }
  
  public static boolean x(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return false;
      }
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("has_show_robot_chat_waring_banner");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      return paramContext.getBoolean(localStringBuilder.toString(), false);
    }
    return false;
  }
  
  public static int y(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("apollo_switch", 0);
  }
  
  public static int y(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("green_video_appid");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static long y(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return 0L;
      }
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reactive_will_downgrade_tips_time");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      return paramContext.getLong(localStringBuilder.toString(), 0L);
    }
    return 0L;
  }
  
  public static void y(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("msg_box_inter_follow_unread_count");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static int z(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("apollo_3d_switch", 0);
  }
  
  public static int z(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("green_video_config_version_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void z(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext, paramString, false, "device_manage_switch_version", Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SharedPreUtils
 * JD-Core Version:    0.7.0.1
 */