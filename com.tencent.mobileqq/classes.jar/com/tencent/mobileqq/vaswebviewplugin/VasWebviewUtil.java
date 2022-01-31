package com.tencent.mobileqq.vaswebviewplugin;

import ajwh;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;
import com.tencent.mobileqq.webview.swift.WebViewPluginFactory;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicReportUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class VasWebviewUtil
{
  public static final String BUSINESS_NAME = "individuation_mainpage_config2";
  public static final String DIR_NAME_FESTIVAL_ANIMATION = "IndividuationAnimation";
  public static final String H5_AID = "mvip.gexinghua.android.zbcenter_h5";
  public static final String IS_FORCE_PULL_JSON_SP_KEY = "individuationIsForcePullSpKey";
  public static final String JSON_FILE_NAME = "IndividuationMainpageConfig4.json";
  public static final int JSON_UPDATE_INTERVAL = 3600000;
  public static final String JSON_URL = "http://i.gtimg.cn/qqshow/admindata/comdata/vipList_dressup_data/xydata.v4.json";
  public static final String LAST_JSON_TIME_SP_KEY = "individuationLastJsonTimeSpKey";
  public static final String LAST_VIP_RECOMMEND_TIME_SP_KEY = "individuationLastVIPRecommendSpKey";
  public static final String NATIVE_AID = "mvip.gexinghua.android.zbcenter_qianbao";
  public static final String RECOMMEND_FAIL_H5_AID = "mvip.gexinghua.android.zbcenter_h5recall";
  public static final String SP_FILE_NAME_FOR_INDIVIDUATION_MAINPAGE = "sp_individuation_mainpage2";
  public static final String SP_KEY_LAST_FESTIVAL_ANIMATION_ZIP_URL = "sp_key_last_festival_animation_zip_url";
  public static final String SP_KEY_LOCAL_JSON_VERSION = "IndividuationConfigJsonVersion4";
  public static final String SP_PARSE_ASYNC_COOKIE = "read_vas_asyncCookie";
  public static final String TAG = "VasWebviewUtil";
  public static final String VIP_RECOMMEND_FILE_NAME = "VIPRecommendPayFile.txt";
  public static final int VIP_RECOMMEND_INTERVAL = 3600000;
  public static ConcurrentHashMap mAsyncCookiesForVas = new ConcurrentHashMap();
  
  public static String decodeUrl(Context paramContext, String paramString, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasWebviewUtil", 2, "decodeUrl:" + paramString);
    }
    String str1 = paramString.replace("[uin]", BaseApplicationImpl.sApplication.getRuntime().getAccount()).replace("[client]", "androidQQ").replace("[version]", "7.6.0.3525").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE);
    String str2 = paramIntent.getStringExtra("updateTime");
    paramString = str1;
    if (str2 != null)
    {
      paramString = str1;
      if (str2.length() > 0) {
        paramString = str1.replace("[updateTime]", str2);
      }
    }
    String str3 = paramIntent.getStringExtra("adTag");
    str1 = paramString;
    if (str2 != null)
    {
      str1 = paramString;
      if (str2.length() > 0) {
        str1 = paramString.replace("[adTag]", str3);
      }
    }
    paramContext = str1.replace("[updateFlag]", Boolean.valueOf(paramIntent.getBooleanExtra("updateFlag", false)).toString()).replace("[updateId]", "" + paramIntent.getIntExtra("updateId", 0)).replace("[density]", ThemeUtil.getThemeDensity(paramContext));
    int i = paramIntent.getIntExtra("bubbleId", -1);
    paramString = paramContext;
    if (i != -1)
    {
      paramString = paramContext;
      if (paramIntent.getBooleanExtra("fromAIO", false)) {
        paramString = paramContext + "&id=" + i;
      }
    }
    i = paramIntent.getIntExtra("fontId", -1);
    paramContext = paramString;
    if (i != -1)
    {
      paramContext = paramString;
      if (paramIntent.getBooleanExtra("fromAIO", false)) {
        paramContext = paramString + "&adtag=mvip.gexinghua.mobile.font.client_tab_store&id=" + i;
      }
    }
    paramString = paramContext;
    if (paramIntent.hasExtra("extra_theme_id"))
    {
      str1 = paramIntent.getStringExtra("extra_theme_id");
      paramString = paramContext;
      if (!TextUtils.isEmpty(str1)) {
        paramString = paramContext + "&id=" + str1;
      }
    }
    long l = paramIntent.getLongExtra("pendantId", -1L);
    paramContext = paramString;
    if (l != -1L)
    {
      paramContext = paramString;
      if (paramIntent.getBooleanExtra("fromAIO", false)) {
        paramContext = paramString + "&adtag=mvip.gexinghua.mobile.faceaddon.client_tab_store&id=" + l;
      }
    }
    return paramContext;
  }
  
  public static void doSonicErrorCodeReport(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append("|");
    localStringBuilder.append(paramString2).append("|");
    localStringBuilder.append(paramString3).append("|");
    localStringBuilder.append(paramInt1).append("|");
    localStringBuilder.append(paramInt2).append("|");
    localStringBuilder.append(paramInt3).append("|");
    localStringBuilder.append(paramString4).append("|");
    localStringBuilder.append(paramString5);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_sonic_errorcode_report_hour", localStringBuilder.toString(), true);
  }
  
  public static void doSonicSpeedReport(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, int paramInt3, int paramInt4, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append("|");
    localStringBuilder.append(paramString2).append("|");
    localStringBuilder.append(paramString3).append("|");
    localStringBuilder.append(paramInt1).append("|");
    localStringBuilder.append(paramInt2).append("|");
    localStringBuilder.append(paramLong1).append("|");
    localStringBuilder.append(paramLong2).append("|");
    localStringBuilder.append(paramLong3).append("|");
    localStringBuilder.append(paramLong4).append("|");
    localStringBuilder.append(paramLong5).append("|");
    localStringBuilder.append(paramLong6).append("|");
    localStringBuilder.append(paramLong7).append("|");
    localStringBuilder.append(paramLong8).append("|");
    localStringBuilder.append(paramLong9).append("|");
    localStringBuilder.append(paramLong10).append("|");
    localStringBuilder.append(paramLong11).append("|");
    localStringBuilder.append(paramInt3).append("|");
    localStringBuilder.append(paramInt4).append("|");
    localStringBuilder.append(paramString4).append("|");
    localStringBuilder.append(paramString5);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_sonic_speed_report", localStringBuilder.toString(), true);
  }
  
  public static String handleEmojiUrl(Intent paramIntent, Context paramContext, long paramLong, String paramString)
  {
    int k = paramIntent.getIntExtra("emojimall_src", 1);
    int i = 1;
    if (paramLong == 4L)
    {
      i = 3;
      if ((i != 1) && (i != 3)) {
        break label991;
      }
      paramString = IndividuationUrlHelper.a(paramContext, "emoji", "");
      if ((k != 8) && (k != 4) && (k != 12)) {
        break label171;
      }
      if (paramIntent.hasExtra("emoji_is_original")) {
        break label117;
      }
      paramContext = IndividuationUrlHelper.a(paramContext, "emojiDetail", "[id]", "");
    }
    for (;;)
    {
      Object localObject1;
      if (TextUtils.isEmpty(paramContext))
      {
        localObject1 = "";
        return localObject1;
        if (paramLong != 8L) {
          break;
        }
        i = 2;
        break;
        label117:
        paramString = Integer.toString(paramIntent.getIntExtra("emoji_author_id", 0));
        if (paramIntent.getBooleanExtra("emoji_is_original", false)) {}
        for (paramContext = IndividuationUrlHelper.a(paramContext, "openAuthorDetail", paramString, "");; paramContext = IndividuationUrlHelper.a(paramContext, "emojiAuthorDetail", paramString, "")) {
          break;
        }
        label171:
        if (k == 11)
        {
          paramContext = IndividuationUrlHelper.a(paramContext, "smallEmojiList", "[id]", "");
          continue;
        }
        if (k == 5)
        {
          paramContext = IndividuationUrlHelper.a(paramContext, "emojiAuthorDetail", "[id]", "");
          continue;
        }
        if (k == 6)
        {
          paramString = IndividuationUrlHelper.a(BaseApplicationImpl.sApplication, "magicPlus", "");
          paramContext = paramString;
          if (TextUtils.isEmpty(paramString)) {
            continue;
          }
          paramContext = paramString.replace("[uin]", BaseApplicationImpl.sApplication.getRuntime().getAccount()).replace("[client]", "androidQQ").replace("[version]", "7.6.0.3525").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE);
          continue;
        }
        if (k == 9)
        {
          paramContext = paramContext.getSharedPreferences("mobileQQ", 0).getString("magic_promotion_jump_url", "");
          localObject1 = paramContext;
          if (!TextUtils.isEmpty(paramContext))
          {
            localObject1 = paramContext.replace("[uin]", BaseApplicationImpl.sApplication.getRuntime().getAccount()).replace("[client]", "androidQQ").replace("[version]", "7.6.0.3525").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE);
            paramString = (String)localObject1;
          }
          paramContext = paramString;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("VasWebviewUtil", 2, "promotion_jump_url:" + (String)localObject1);
          paramContext = paramString;
          continue;
        }
        paramContext = paramString;
        if (k != 3) {
          continue;
        }
        localObject1 = paramIntent.getStringExtra("currentId");
        paramContext = paramString;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        paramContext = paramString;
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        if (paramString.contains("?"))
        {
          paramContext = paramString + "&rec_id=" + (String)localObject1;
          continue;
        }
        paramContext = paramString + "?rec_id=" + (String)localObject1;
        continue;
      }
      int j = 1;
      i = 1;
      Object localObject2;
      if ((k == 8) || (k == 4) || (k == 12))
      {
        paramString = paramIntent.getStringExtra("emojimall_detail_id");
        if (TextUtils.isEmpty(paramString))
        {
          i = 0;
          localObject1 = "vip.gongneng.mobile.biaoqing.client_tab_store";
          localObject2 = paramContext;
          label605:
          paramContext = (Context)localObject2;
          paramString = (String)localObject1;
          j = i;
          if (k == 12)
          {
            paramContext = (String)localObject2 + "&location=dashang";
            j = i;
            paramString = (String)localObject1;
          }
        }
      }
      for (;;)
      {
        label653:
        localObject1 = paramContext;
        if (j == 0) {
          break;
        }
        paramContext = paramContext.replace("[adtag]", paramString).replace("[systemInt]", Integer.toString(Build.VERSION.SDK_INT));
        if (QLog.isColorLevel()) {
          QLog.d("VasWebviewUtil", 2, "loadHomePage:" + paramContext);
        }
        i = paramIntent.getIntExtra("emomall_new_time", -1);
        if (i > 0) {}
        for (paramContext = paramContext.replace("[updateTime]", "" + i);; paramContext = paramContext.replace("[updateTime]", "0"))
        {
          paramString = paramContext.replace("[updateFlag]", Boolean.valueOf(paramIntent.getBooleanExtra("updateFlag", false)).toString()).replace("[updateId]", "" + paramIntent.getIntExtra("updateId", 0));
          paramContext = paramString;
          if (paramIntent.hasExtra("EXTRA_KEY_IS_SMALL_EMOTICON"))
          {
            paramContext = paramString;
            if (paramIntent.getBooleanExtra("EXTRA_KEY_IS_SMALL_EMOTICON", false)) {
              paramContext = paramString + "&emojiType=5";
            }
          }
          localObject1 = paramContext;
          if (!paramIntent.getBooleanExtra("emoji_to_dressup", false)) {
            break;
          }
          return paramContext + "&to=recommend";
          localObject2 = paramContext.replace("[id]", paramString).replace("[type]", "view");
          localObject1 = "vip.gongneng.mobile.biaoqing.client_manager_item";
          break label605;
          if ((k == 2) || (k == 3))
          {
            paramString = "vip.gongneng.mobile.biaoqing.client_manager_top";
            break label653;
          }
          if (k == 7)
          {
            paramString = "vip.gongneng.mobile.biaoqing.client_index_banner";
            break label653;
          }
          if (k != 6) {
            break label983;
          }
          paramString = "vip.gongneng.mobile.biaoqing.client_aio_magic";
          break label653;
        }
        label983:
        paramString = "vip.gongneng.mobile.biaoqing.client_tab_store";
      }
      label991:
      paramContext = paramString;
    }
  }
  
  public static Intent insertVasWbPluginToIntent(long paramLong, Intent paramIntent)
  {
    Intent localIntent;
    if (paramIntent == null) {
      localIntent = null;
    }
    String str;
    do
    {
      do
      {
        return localIntent;
        localIntent = paramIntent;
      } while (paramLong <= 0L);
      str = String.valueOf(paramLong);
      localIntent = paramIntent;
    } while (!WebViewPluginFactory.a.containsKey(str));
    paramIntent.putExtra("insertPluginsArray", new String[] { str });
    return paramIntent;
  }
  
  public static boolean isExternalStorageOK(Context paramContext)
  {
    if (!Utils.a())
    {
      Toast.makeText(paramContext, paramContext.getString(2131434753), 0).show();
      return false;
    }
    if (Utils.b() < 5242880L)
    {
      Toast.makeText(paramContext, paramContext.getString(2131434754), 0).show();
      return false;
    }
    return true;
  }
  
  public static void openIndividuationIndex(Context paramContext)
  {
    String str = IndividuationUrlHelper.a(paramContext, "personalIndex", "");
    if (QLog.isColorLevel()) {
      QLog.d("VasWebviewUtil", 2, "individuation main page url = " + str);
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("individuation_url_type", 40100);
    openQQBrowserWithoutAD(paramContext, str, 1048576L, localIntent, false, -1);
  }
  
  public static void openQQBrowserActivity(Context paramContext, String paramString, long paramLong, Intent paramIntent, boolean paramBoolean, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (paramContext == null) {
      return;
    }
    if (paramIntent != null) {
      paramIntent.setClass(paramContext, QQBrowserActivity.class);
    }
    for (;;)
    {
      String str = paramString;
      if (mAsyncCookiesForVas != null)
      {
        str = paramString;
        if (mAsyncCookiesForVas.size() > 0)
        {
          str = paramString;
          if ("1".equalsIgnoreCase((String)mAsyncCookiesForVas.get(String.valueOf(paramLong))))
          {
            str = paramString;
            if (!TextUtils.isEmpty(paramString))
            {
              str = paramString;
              if (!paramString.contains("async_cookie=1"))
              {
                paramString = HtmlOffline.a(paramString, "async_cookie=1");
                str = paramString;
                if (QLog.isColorLevel())
                {
                  QLog.i("VasWebviewUtil", 1, "now business id " + paramLong + "  use async_cookie");
                  str = paramString;
                }
              }
            }
          }
        }
      }
      if (!TextUtils.isEmpty(str)) {
        paramIntent.putExtra("url", str);
      }
      paramIntent.putExtra("business", paramLong);
      insertVasWbPluginToIntent(paramLong, paramIntent);
      if (paramIntent.getLongExtra("startOpenPageTime", 0L) <= 0L) {
        paramIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      }
      paramIntent.putExtra("isShowAd", false);
      if (QLog.isColorLevel())
      {
        paramLong = System.currentTimeMillis();
        QLog.i("VasWebviewUtil", 2, "opeen vas webview cost: " + (paramLong - l));
      }
      if ((!paramBoolean) || (!(paramContext instanceof Activity))) {
        break;
      }
      ((Activity)paramContext).startActivityForResult(paramIntent, paramInt);
      return;
      paramIntent = new Intent(paramContext, QQBrowserActivity.class);
    }
    paramContext.startActivity(paramIntent);
  }
  
  public static void openQQBrowserWithoutAD(Context paramContext, String paramString, long paramLong, Intent paramIntent, boolean paramBoolean, int paramInt)
  {
    if (paramContext == null) {
      if (QLog.isDevelopLevel()) {
        QLog.d("VasWebviewUtil", 4, "open qqbrowser erro context");
      }
    }
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while ((paramLong == 4194304L) && (!isExternalStorageOK(paramContext)));
    if (paramIntent != null) {
      paramIntent.setClass(paramContext, QQBrowserActivity.class);
    }
    for (Intent localIntent = paramIntent;; localIntent = new Intent(paramContext, QQBrowserActivity.class))
    {
      if ((paramLong != 2L) && (paramLong != 4L))
      {
        paramIntent = paramString;
        if (paramLong != 8L) {}
      }
      else
      {
        paramIntent = handleEmojiUrl(localIntent, paramContext, paramLong, paramString);
        paramString = paramIntent;
        if (localIntent != null)
        {
          paramString = paramIntent;
          if (localIntent.getBooleanExtra("is_small_emoji", false)) {
            paramString = paramIntent + "&emojiType=5";
          }
          String str = localIntent.getStringExtra("emoji_ids");
          paramIntent = paramString;
          if (str != null)
          {
            paramIntent = paramString;
            if (!str.equals("")) {
              paramIntent = paramString + "&id=" + str;
            }
          }
          paramString = paramIntent;
          if (localIntent.getBooleanExtra("EXTRA_KEY_IS_KANDIAN_EMOTICON", false)) {
            paramString = paramIntent + "&sceneType=1";
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("VasWebviewUtil", 2, "small emoji url = " + paramString);
        }
        paramIntent = paramString;
      }
      paramString = paramIntent;
      if (mAsyncCookiesForVas != null)
      {
        paramString = paramIntent;
        if (mAsyncCookiesForVas.size() > 0)
        {
          paramString = paramIntent;
          if ("1".equalsIgnoreCase((String)mAsyncCookiesForVas.get(String.valueOf(paramLong))))
          {
            paramString = paramIntent;
            if (!TextUtils.isEmpty(paramIntent))
            {
              paramString = paramIntent;
              if (!paramIntent.contains("async_cookie=1"))
              {
                paramIntent = HtmlOffline.a(paramIntent, "async_cookie=1");
                paramString = paramIntent;
                if (QLog.isColorLevel())
                {
                  QLog.i("VasWebviewUtil", 1, "now business id " + paramLong + "  use async_cookie");
                  paramString = paramIntent;
                }
              }
            }
          }
        }
      }
      if (!TextUtils.isEmpty(paramString))
      {
        localIntent.putExtra("url", paramString);
        paramString = Uri.parse(paramString).getHost();
        paramString = (WebViewTitleStyle)WebViewTitleStyleHelper.a().a.get(paramString);
        if (paramString != null) {
          localIntent.putExtra("titleStyle", paramString);
        }
      }
      localIntent.putExtra("business", paramLong);
      insertVasWbPluginToIntent(paramLong, localIntent);
      if (localIntent.getLongExtra("startOpenPageTime", 0L) <= 0L) {
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      }
      localIntent.putExtra("isShowAd", false);
      if (QLog.isColorLevel())
      {
        paramLong = System.currentTimeMillis();
        QLog.i("VasWebviewUtil", 2, "opeen vas webview cost: " + (paramLong - l));
      }
      if ((!paramBoolean) || (!(paramContext instanceof Activity))) {
        break;
      }
      ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
      return;
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void preparePareAsyncCookie()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasWebviewUtil", 2, "prepare to read async cookie!");
    }
    ThreadManager.post(new ajwh(), 5, null, true);
  }
  
  public static void reportCommercialDrainage(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7)
  {
    String str;
    if (TextUtils.isEmpty(paramString5)) {
      str = "UNKNOWN";
    }
    for (;;)
    {
      try
      {
        int i = NetworkUtil.a(BaseApplicationImpl.getContext());
        paramString5 = str;
        if (i != -1)
        {
          paramString5 = str;
          if (i < AppConstants.c.length) {
            paramString5 = AppConstants.c[i];
          }
        }
      }
      catch (Exception paramString5)
      {
        QLog.e("VasWebviewUtil", 1, "NetworkUtil.getSystemNetwork error", paramString5);
        paramString5 = "UNKNOWN";
        continue;
        continue;
      }
      if (paramInt1 == 0)
      {
        paramInt1 = 1;
        reportCommercialDrainage(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramInt3, paramString5, paramString6, paramString7, "", "", "", "", 0, 0, 0, 0);
        return;
      }
    }
  }
  
  public static void reportCommercialDrainage(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString5)) {
      localObject = "UNKNOWN";
    }
    for (;;)
    {
      try
      {
        i = NetworkUtil.a(BaseApplicationImpl.getContext());
        paramString5 = (String)localObject;
        if (i != -1)
        {
          paramString5 = (String)localObject;
          if (i < AppConstants.c.length) {
            paramString5 = AppConstants.c[i];
          }
        }
      }
      catch (Exception paramString5)
      {
        int i;
        QLog.e("VasWebviewUtil", 1, "NetworkUtil.getSystemNetwork error", paramString5);
        paramString5 = (String)localObject;
        continue;
      }
      i = paramInt1;
      if (paramInt1 == 0) {
        i = 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1).append("|");
      ((StringBuilder)localObject).append(paramString2).append("|");
      ((StringBuilder)localObject).append(paramString3).append("|");
      ((StringBuilder)localObject).append(paramString4).append("|");
      ((StringBuilder)localObject).append(i).append("|");
      ((StringBuilder)localObject).append(paramInt2).append("|");
      ((StringBuilder)localObject).append(paramInt3).append("|");
      ((StringBuilder)localObject).append(paramString5).append("|");
      ((StringBuilder)localObject).append(paramString6).append("|");
      ((StringBuilder)localObject).append(paramString7).append("|");
      ((StringBuilder)localObject).append(paramString8).append("|");
      ((StringBuilder)localObject).append(paramString9).append("|");
      ((StringBuilder)localObject).append(paramString10).append("|");
      ((StringBuilder)localObject).append(paramString11).append("|");
      ((StringBuilder)localObject).append(paramInt4).append("|");
      ((StringBuilder)localObject).append(paramInt5).append("|");
      ((StringBuilder)localObject).append(paramInt6).append("|");
      ((StringBuilder)localObject).append(paramInt7).append("|");
      DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_personal_data_hour", ((StringBuilder)localObject).toString(), true);
      return;
    }
  }
  
  public static void reportNetworkSpeedTimeFromX5(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    reportNetworkSpeedTimeFromX5(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, 0L, 0L, 0L, 0L, 0L, 0L, 0L, "", "", "");
  }
  
  public static void reportNetworkSpeedTimeFromX5(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, long paramLong12, String paramString4, String paramString5, String paramString6)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append("|");
    localStringBuilder.append(paramString2).append("|");
    localStringBuilder.append(paramInt1).append("|");
    localStringBuilder.append(paramInt2).append("|");
    localStringBuilder.append(paramInt3).append("|");
    localStringBuilder.append(paramString3).append("|");
    localStringBuilder.append(paramLong1).append("|");
    localStringBuilder.append(paramLong2).append("|");
    localStringBuilder.append(paramLong3).append("|");
    localStringBuilder.append(paramLong4).append("|");
    localStringBuilder.append(paramLong5).append("|");
    localStringBuilder.append(paramLong6).append("|");
    localStringBuilder.append(paramLong7).append("|");
    localStringBuilder.append(paramLong8).append("|");
    localStringBuilder.append(paramLong9).append("|");
    localStringBuilder.append(paramLong10).append("|");
    localStringBuilder.append(paramLong11).append("|");
    localStringBuilder.append(paramLong12).append("|");
    localStringBuilder.append(paramString4).append("|");
    localStringBuilder.append(paramString5).append("|");
    localStringBuilder.append(paramString6);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_network_speed_time_from_x5", localStringBuilder.toString(), true);
  }
  
  public static void reportQBWebInfo(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, int paramInt3, int paramInt4, String paramString8, String paramString9)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append("|");
    localStringBuilder.append(paramString2).append("|");
    localStringBuilder.append(paramString3).append("|");
    localStringBuilder.append(paramString4).append("|");
    localStringBuilder.append(paramInt1).append("|");
    localStringBuilder.append(paramInt2).append("|");
    localStringBuilder.append(paramString5).append("|");
    localStringBuilder.append(paramString6).append("|");
    localStringBuilder.append(paramString7).append("|");
    localStringBuilder.append(paramInt3).append("|");
    localStringBuilder.append(paramInt4).append("|");
    localStringBuilder.append(paramString8).append("|");
    localStringBuilder.append(paramString9);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_qbwebview_report", localStringBuilder.toString(), true);
  }
  
  public static void reportQuickUpdateDownload(int paramInt1, long paramLong, String paramString1, String paramString2, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1).append("|");
    localStringBuilder.append(paramLong).append("|");
    localStringBuilder.append(paramString1).append("|");
    localStringBuilder.append(paramString2).append("|");
    localStringBuilder.append(paramInt4).append("|");
    localStringBuilder.append(paramInt2).append("|");
    localStringBuilder.append(paramInt3).append("|");
    if (paramBoolean) {}
    for (paramString1 = "1";; paramString1 = "0")
    {
      localStringBuilder.append(paramString1).append("|");
      localStringBuilder.append(paramString3).append("|");
      localStringBuilder.append(paramString4).append("|");
      localStringBuilder.append(paramString5).append("|");
      DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_scupdate_dlreport", localStringBuilder.toString(), true);
      return;
    }
  }
  
  public static void reportQuickUpdateST(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong).append("|");
    localStringBuilder.append(paramString1).append("|");
    localStringBuilder.append(paramString2).append("|");
    localStringBuilder.append(paramInt1).append("|");
    localStringBuilder.append(paramInt2).append("|");
    localStringBuilder.append(paramInt3).append("|");
    localStringBuilder.append(paramString3).append("|");
    localStringBuilder.append(paramString4).append("|");
    localStringBuilder.append(paramString5).append("|");
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_scupdate_streport", localStringBuilder.toString(), true);
  }
  
  public static void reportVASTo00145(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String... paramVarArgs)
  {
    if (paramAppInterface == null) {}
    label579:
    for (;;)
    {
      return;
      if ((paramAppInterface instanceof QQAppInterface)) {}
      for (QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;; localQQAppInterface = null) {
        for (;;)
        {
          if (localQQAppInterface == null) {
            break label579;
          }
          String str = paramAppInterface.getCurrentAccountUin();
          Object localObject = paramAppInterface.getApp();
          if ((str == null) || (localObject == null)) {
            break;
          }
          if (TextUtils.isEmpty(VipComicReportUtils.jdField_a_of_type_JavaLangString)) {
            if (VipComicReportUtils.jdField_a_of_type_AndroidTelephonyTelephonyManager == null) {
              VipComicReportUtils.jdField_a_of_type_AndroidTelephonyTelephonyManager = (TelephonyManager)((Context)localObject).getSystemService("phone");
            }
          }
          try
          {
            VipComicReportUtils.jdField_a_of_type_JavaLangString = VipComicReportUtils.jdField_a_of_type_AndroidTelephonyTelephonyManager.getDeviceId();
            label83:
            if (VipComicReportUtils.jdField_a_of_type_JavaLangString == null) {
              VipComicReportUtils.jdField_a_of_type_JavaLangString = "";
            }
            int j = HttpUtil.a();
            if (j >= 0)
            {
              i = j;
              if (j < AppConstants.c.length) {}
            }
            else
            {
              i = 0;
            }
            paramAppInterface = AppConstants.c[i];
            if (TextUtils.isEmpty(VipComicReportUtils.b))
            {
              localObject = ((Context)localObject).getResources().getDisplayMetrics();
              VipComicReportUtils.b = ((DisplayMetrics)localObject).widthPixels + "*" + ((DisplayMetrics)localObject).heightPixels;
            }
            localObject = new String[9];
            System.arraycopy(paramVarArgs, 0, localObject, 0, Math.min(9, paramVarArgs.length));
            int i = 0;
            j = localObject.length;
            while (i < j)
            {
              if (localObject[i] == null) {
                localObject[i] = "";
              }
              i += 1;
            }
            paramAppInterface = Arrays.asList(new String[] { "1", str, VipComicReportUtils.jdField_a_of_type_JavaLangString, "", "android", "201", Build.VERSION.RELEASE, "3001", "3001013", "", "", paramString1, "", "", "", paramString2, "", paramString3, "", "", paramString4, "", "", "7.6.0", "", "", "", "", "", "android", paramAppInterface, VipComicReportUtils.b, "", localObject[0], localObject[1], localObject[2], localObject[3], localObject[4], localObject[5], localObject[6], localObject[7], localObject[8] });
            VipComicReportUtils.a(localQQAppInterface, "dc00145", paramAppInterface);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("VasWebviewUtil", 2, "reportVASTo00145 paramList=" + paramAppInterface.toString());
            return;
          }
          catch (Exception paramAppInterface)
          {
            break label83;
          }
        }
      }
    }
  }
  
  public static void reportVasStatus(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    reportVasStatus(paramString1, paramString2, paramString3, paramInt1, paramInt2, 0, 0, "", "");
  }
  
  public static void reportVasStatus(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append("|");
    localStringBuilder.append(paramString2).append("|");
    paramString1 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString1 = "0";
    }
    localStringBuilder.append(paramString1).append("|");
    localStringBuilder.append(paramInt1).append("|");
    localStringBuilder.append(paramInt2).append("|");
    localStringBuilder.append(paramInt3).append("|");
    localStringBuilder.append(paramInt4).append("|");
    localStringBuilder.append(paramString4).append("|");
    localStringBuilder.append(paramString5);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_status_report", localStringBuilder.toString(), true);
  }
  
  public static void reportVipKeywords(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append("|");
    localStringBuilder.append(paramString2).append("|");
    localStringBuilder.append(paramString3).append("|");
    localStringBuilder.append(paramString4).append("|");
    localStringBuilder.append(paramString5).append("|");
    localStringBuilder.append(paramString6).append("|");
    localStringBuilder.append(paramString7).append("|");
    localStringBuilder.append(paramString8).append("|");
    localStringBuilder.append(paramString9).append("|");
    localStringBuilder.append(paramString10);
    if (QLog.isColorLevel()) {
      QLog.d("VasWebviewUtil", 4, "reportVipKeywords: " + localStringBuilder.toString());
    }
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_key_word_grey_keyword_show_new|key_word_grey", localStringBuilder.toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil
 * JD-Core Version:    0.7.0.1
 */