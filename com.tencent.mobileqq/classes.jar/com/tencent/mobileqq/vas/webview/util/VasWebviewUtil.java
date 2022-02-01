package com.tencent.mobileqq.vas.webview.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.comic.api.IQQDcReporter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.bean.EntryReportParams;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class VasWebviewUtil
{
  public static String a = "";
  public static ConcurrentHashMap<String, String> b = new ConcurrentHashMap();
  
  public static int a(long paramLong)
  {
    if (paramLong == 4L) {
      return 3;
    }
    if (paramLong == 8L) {
      return 2;
    }
    return 1;
  }
  
  public static Intent a(long paramLong, Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    Intent localIntent = paramIntent;
    if (paramLong > 0L) {
      localIntent = d(paramIntent, String.valueOf(paramLong));
    }
    return localIntent;
  }
  
  @NotNull
  private static Intent a(Context paramContext, String paramString, long paramLong, Intent paramIntent)
  {
    if (paramIntent != null) {
      paramIntent.setClass(paramContext, ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getQQBrowserActivityClass());
    } else {
      paramIntent = new Intent(paramContext, ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getQQBrowserActivityClass());
    }
    paramString = b(paramContext, paramString, paramLong, paramIntent);
    paramContext = paramIntent;
    if (!TextUtils.isEmpty(paramString))
    {
      paramIntent.putExtra("url", paramString);
      paramContext = c(paramIntent, Uri.parse(paramString).getHost());
    }
    paramContext.putExtra("business", paramLong);
    a(paramLong, paramContext);
    if (paramContext.getLongExtra("startOpenPageTime", 0L) <= 0L) {
      paramContext.putExtra("startOpenPageTime", System.currentTimeMillis());
    }
    paramContext.putExtra(((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).isShowAdKey(), false);
    paramContext.putExtra("big_brother_source_key", "biz_src_jc_vip");
    return paramContext;
  }
  
  public static String a()
  {
    String str1 = IndividuationUrlHelper.a(MobileQQ.sMobileQQ.getApplicationContext(), "magicPlus", "");
    String str2 = str1;
    if (!TextUtils.isEmpty(str1))
    {
      str2 = str1;
      if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
        str2 = str1.replace("[uin]", MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
      }
      str2 = str2.replace("[client]", "androidQQ").replace("[version]", "8.8.17.5770").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE);
    }
    return str2;
  }
  
  public static String a(int paramInt, String paramString)
  {
    if ((paramInt != 2) && (paramInt != 3))
    {
      if (paramInt == 7) {
        return "vip.gongneng.mobile.biaoqing.client_index_banner";
      }
      if (paramInt == 6) {
        return "vip.gongneng.mobile.biaoqing.client_aio_magic";
      }
    }
    else
    {
      paramString = "vip.gongneng.mobile.biaoqing.client_manager_top";
    }
    return paramString;
  }
  
  public static String a(Intent paramIntent, Context paramContext)
  {
    if (!paramIntent.hasExtra("emoji_is_original")) {
      return IndividuationUrlHelper.a(paramContext, "emojiDetail", "[id]", "");
    }
    String str = Integer.toString(paramIntent.getIntExtra("emoji_author_id", 0));
    if (paramIntent.getBooleanExtra("emoji_is_original", false)) {
      return IndividuationUrlHelper.a(paramContext, "openAuthorDetail", str, "");
    }
    return IndividuationUrlHelper.a(paramContext, "emojiAuthorDetail", str, "");
  }
  
  public static String a(Intent paramIntent, Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt2 == 1) || (paramInt2 == 3))
    {
      String str = b(paramIntent, paramContext);
      if (a(paramInt1)) {
        return a(paramIntent, paramContext);
      }
      if (paramInt1 == 11) {
        return IndividuationUrlHelper.a(paramContext, "smallEmojiList", "[id]", "");
      }
      if (paramInt1 == 5) {
        return IndividuationUrlHelper.a(paramContext, "emojiAuthorDetail", "[id]", "");
      }
      if (paramInt1 == 6) {
        return a();
      }
      if (paramInt1 == 9) {
        return b(paramContext, str);
      }
      paramString = str;
      if (paramInt1 == 3) {
        paramString = b(paramIntent, str);
      }
    }
    return paramString;
  }
  
  public static String a(Intent paramIntent, Context paramContext, long paramLong, String paramString)
  {
    int j = 1;
    int i = 1;
    int k = paramIntent.getIntExtra("emojimall_src", 1);
    paramContext = a(paramIntent, paramContext, k, paramString, a(paramLong));
    if (TextUtils.isEmpty(paramContext)) {
      return "";
    }
    paramString = "vip.gongneng.mobile.biaoqing.client_tab_store";
    String str;
    if (a(k))
    {
      Object localObject = paramIntent.getStringExtra("emojimall_detail_id");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        i = 0;
        localObject = paramContext;
      }
      else
      {
        localObject = paramContext.replace("[id]", (CharSequence)localObject).replace("[type]", "view");
        paramString = "vip.gongneng.mobile.biaoqing.client_manager_item";
      }
      j = i;
      paramContext = (Context)localObject;
      str = paramString;
      if (k == 12)
      {
        paramContext = new StringBuilder();
        paramContext.append((String)localObject);
        paramContext.append("&location=dashang");
        paramContext = paramContext.toString();
        j = i;
        str = paramString;
      }
    }
    else
    {
      str = a(k, "vip.gongneng.mobile.biaoqing.client_tab_store");
    }
    paramString = paramContext;
    if (j != 0)
    {
      paramContext = paramContext.replace("[adtag]", str).replace("[systemInt]", Integer.toString(Build.VERSION.SDK_INT));
      a(paramContext);
      paramContext = a(paramContext, paramIntent.getIntExtra("emomall_new_time", -1)).replace("[updateFlag]", Boolean.valueOf(paramIntent.getBooleanExtra("updateFlag", false)).toString());
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(paramIntent.getIntExtra("updateId", 0));
      paramString = a(paramIntent, paramContext.replace("[updateId]", paramString.toString()));
      paramContext = paramString;
      if (paramIntent.getBooleanExtra("emoji_to_dressup", false))
      {
        paramIntent = new StringBuilder();
        paramIntent.append(paramString);
        paramIntent.append("&to=recommend");
        paramContext = paramIntent.toString();
      }
      paramString = b(paramContext, 47);
    }
    return paramString;
  }
  
  public static String a(Intent paramIntent, String paramString)
  {
    String str = paramString;
    if (paramIntent.hasExtra(((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getKeyIsSmallEmoticon()))
    {
      str = paramString;
      if (paramIntent.getBooleanExtra(((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getKeyIsSmallEmoticon(), false))
      {
        paramIntent = new StringBuilder();
        paramIntent.append(paramString);
        paramIntent.append("&emojiType=5");
        str = paramIntent.toString();
      }
    }
    return str;
  }
  
  @NotNull
  public static String a(String paramString, int paramInt)
  {
    if (paramInt > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt);
      return paramString.replace("[updateTime]", localStringBuilder.toString());
    }
    return paramString.replace("[updateTime]", "0");
  }
  
  private static String a(String paramString, long paramLong)
  {
    ConcurrentHashMap localConcurrentHashMap = b;
    Object localObject = paramString;
    if (localConcurrentHashMap != null)
    {
      localObject = paramString;
      if (localConcurrentHashMap.size() > 0)
      {
        localObject = paramString;
        if ("1".equalsIgnoreCase((String)b.get(String.valueOf(paramLong))))
        {
          localObject = paramString;
          if (!TextUtils.isEmpty(paramString))
          {
            localObject = paramString;
            if (!paramString.contains("async_cookie=1"))
            {
              paramString = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).addParamToUrl(paramString, "async_cookie=1");
              localObject = paramString;
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("now business id ");
                ((StringBuilder)localObject).append(paramLong);
                ((StringBuilder)localObject).append("  use async_cookie");
                QLog.i("VasWebviewUtil", 1, ((StringBuilder)localObject).toString());
                localObject = paramString;
              }
            }
          }
        }
      }
    }
    return localObject;
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, null);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    String str = IndividuationUrlHelper.a(paramContext, "personalIndex", "");
    Object localObject = str;
    if (paramString != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("individuation main page url = ");
      paramString.append((String)localObject);
      QLog.d("VasWebviewUtil", 2, paramString.toString());
    }
    paramString = new StringBuilder();
    paramString.append("individuation --------------open GXH ");
    paramString.append((String)localObject);
    QLog.d("VasWebviewUtil", 2, paramString.toString());
    if (VasUtil.b().isCanOpenGxhHippyPage())
    {
      VasUtil.b().openGxhHippyPage((String)localObject);
      return;
    }
    paramString = new Intent(paramContext, ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getQQBrowserActivityClass());
    paramString.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramString.putExtra("portraitOnly", true);
    if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
      paramString.putExtra("uin", MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
    }
    paramString.putExtra("hide_operation_bar", true);
    paramString.putExtra("hide_more_button", true);
    paramString.putExtra("individuation_url_type", 40100);
    b(paramContext, (String)localObject, 1048576L, paramString, false, -1);
    ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).startWebSoRequest((String)localObject);
  }
  
  public static void a(Context paramContext, String paramString, long paramLong, Intent paramIntent, boolean paramBoolean, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (paramContext == null) {
      return;
    }
    if (paramIntent != null) {
      paramIntent.setClass(paramContext, ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getQQBrowserActivityClass());
    } else {
      paramIntent = new Intent(paramContext, ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getQQBrowserActivityClass());
    }
    paramString = a(paramString, paramLong);
    if (!TextUtils.isEmpty(paramString)) {
      paramIntent.putExtra("url", paramString);
    }
    paramIntent.putExtra("business", paramLong);
    a(paramLong, paramIntent);
    if (paramIntent.getLongExtra("startOpenPageTime", 0L) <= 0L) {
      paramIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    }
    paramIntent.putExtra(((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).isShowAdKey(), false);
    if (QLog.isColorLevel())
    {
      paramLong = System.currentTimeMillis();
      paramString = new StringBuilder();
      paramString.append("opeen vas webview cost: ");
      paramString.append(paramLong - l);
      QLog.i("VasWebviewUtil", 2, paramString.toString());
    }
    if ((paramBoolean) && ((paramContext instanceof Activity)))
    {
      ((Activity)paramContext).startActivityForResult(paramIntent, paramInt);
      return;
    }
    paramContext.startActivity(paramIntent);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String... paramVarArgs)
  {
    if (paramAppInterface == null) {
      return;
    }
    BaseQQAppInterface localBaseQQAppInterface = null;
    if ((paramAppInterface instanceof BaseQQAppInterface)) {
      localBaseQQAppInterface = (BaseQQAppInterface)paramAppInterface;
    }
    if (localBaseQQAppInterface == null) {
      return;
    }
    String str1 = paramAppInterface.getCurrentAccountUin();
    paramAppInterface = paramAppInterface.getApp();
    if (str1 != null)
    {
      if (paramAppInterface == null) {
        return;
      }
      int j = HttpUtil.getNetWorkType();
      if (j >= 0)
      {
        i = j;
        if (j < AppConstants.NET_TYPE_NAME.length) {}
      }
      else
      {
        i = 0;
      }
      String str2 = AppConstants.NET_TYPE_NAME[i];
      if (TextUtils.isEmpty(a))
      {
        localObject = paramAppInterface.getResources().getDisplayMetrics();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((DisplayMetrics)localObject).widthPixels);
        localStringBuilder.append("*");
        localStringBuilder.append(((DisplayMetrics)localObject).heightPixels);
        a = localStringBuilder.toString();
      }
      Object localObject = new String[9];
      System.arraycopy(paramVarArgs, 0, localObject, 0, Math.min(9, paramVarArgs.length));
      j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (localObject[i] == null) {
          localObject[i] = "";
        }
        i += 1;
      }
      paramAppInterface = Arrays.asList(new String[] { "1", str1, ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).getImei(paramAppInterface), "", "android", "201", Build.VERSION.RELEASE, "3001", "3001013", "", "", paramString1, "", "", "", paramString2, "", paramString3, "", "", paramString4, "", "", "8.8.17", "", "", "", "", "", "android", str2, a, "", localObject[0], localObject[1], localObject[2], localObject[3], localObject[4], localObject[5], localObject[6], localObject[7], localObject[8] });
      ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).reportDCEvent(localBaseQQAppInterface, "dc00145", paramAppInterface);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("reportVASTo00145 paramList=");
        paramString1.append(paramAppInterface.toString());
        QLog.d("VasWebviewUtil", 2, paramString1.toString());
      }
    }
  }
  
  private static void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadHomePage:");
      localStringBuilder.append(paramString);
      QLog.d("VasWebviewUtil", 2, localStringBuilder.toString());
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, double paramDouble, int paramInt4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramDouble);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append("|");
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_font_performance", localStringBuilder.toString(), true);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    a(paramString1, paramString2, paramString3, paramInt1, paramInt2, 0, 0, "", "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    paramString1 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString1 = "0";
    }
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString5);
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_status_report", localStringBuilder.toString(), true);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    Object localObject = MobileQQ.sMobileQQ.peekAppRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = null;
    }
    a((String)localObject, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    a(paramString1, paramString2, paramString3, 0, paramInt, 0, "", paramString4, paramString5, "", "", "", "", 0, 0, 0, 0);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7)
  {
    if (TextUtils.isEmpty(paramString5)) {
      try
      {
        paramString5 = MobileQQ.sMobileQQ;
        int i = NetworkUtil.getSystemNetwork(MobileQQ.getContext());
        if ((i != -1) && (i < AppConstants.NET_TYPE_NAME.length)) {
          paramString5 = AppConstants.NET_TYPE_NAME[i];
        } else {
          paramString5 = "UNKNOWN";
        }
      }
      catch (Exception paramString5)
      {
        QLog.e("VasWebviewUtil", 1, "NetworkUtil.getSystemNetwork error", paramString5);
        paramString5 = "UNKNOWN";
      }
    }
    if (paramInt1 == 0) {
      paramInt1 = 1;
    }
    a(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramInt3, paramString5, paramString6, paramString7, "", "", "", "", 0, 0, 0, 0);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (TextUtils.isEmpty(paramString5)) {
      try
      {
        paramString5 = MobileQQ.sMobileQQ;
        int i = NetworkUtil.getSystemNetwork(MobileQQ.getContext());
        if ((i != -1) && (i < AppConstants.NET_TYPE_NAME.length)) {
          paramString5 = AppConstants.NET_TYPE_NAME[i];
        }
      }
      catch (Exception paramString5)
      {
        QLog.e("VasWebviewUtil", 1, "NetworkUtil.getSystemNetwork error", paramString5);
        paramString5 = "UNKNOWN";
      }
    }
    if (paramInt1 == 0) {
      paramInt1 = 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString5);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString6);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString7);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString8);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString9);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString10);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString11);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt5);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt6);
    localStringBuilder.append("|");
    localStringBuilder.append(paramInt7);
    localStringBuilder.append("|");
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_personal_data_hour", localStringBuilder.toString(), true);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString5);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString6);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString7);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString8);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString9);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString10);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("reportVipKeywords: ");
      paramString1.append(localStringBuilder.toString());
      QLog.d("VasWebviewUtil", 4, paramString1.toString());
    }
    DcReportUtil.a(null, "sendtdbank|b_sng_qqvip_key_word_grey_keyword_show_new|key_word_grey", localStringBuilder.toString(), true);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 8) || (paramInt == 4) || (paramInt == 12);
  }
  
  @NotNull
  private static String b(int paramInt)
  {
    String str = new EntryReportParams(paramInt).a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("&traceDetail=base64-");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public static String b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0).getString("magic_promotion_jump_url", "");
    Object localObject = paramContext;
    if (!TextUtils.isEmpty(paramContext))
    {
      paramString = paramContext;
      if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
        paramString = paramContext.replace("[uin]", MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
      }
      paramString = paramString.replace("[client]", "androidQQ").replace("[version]", "8.8.17.5770").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE);
      localObject = paramString;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("promotion_jump_url:");
      paramContext.append((String)localObject);
      QLog.d("VasWebviewUtil", 2, paramContext.toString());
    }
    return paramString;
  }
  
  private static String b(Context paramContext, String paramString, long paramLong, Intent paramIntent)
  {
    Object localObject;
    if ((paramLong != 2L) && (paramLong != 4L))
    {
      localObject = paramString;
      if (paramLong != 8L) {}
    }
    else
    {
      paramString = a(paramIntent, paramContext, paramLong, paramString);
      paramContext = paramString;
      if (paramIntent.getBooleanExtra("is_small_emoji", false))
      {
        paramContext = new StringBuilder();
        paramContext.append(paramString);
        paramContext.append("&emojiType=5");
        paramContext = paramContext.toString();
      }
      localObject = paramIntent.getStringExtra("emoji_ids");
      paramString = paramContext;
      if (localObject != null)
      {
        paramString = paramContext;
        if (!((String)localObject).equals(""))
        {
          paramString = new StringBuilder();
          paramString.append(paramContext);
          paramString.append("&id=");
          paramString.append((String)localObject);
          paramString = paramString.toString();
        }
      }
      paramContext = paramString;
      if (paramIntent.getBooleanExtra(((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getKeyIsKandianEmoticon(), false))
      {
        paramContext = new StringBuilder();
        paramContext.append(paramString);
        paramContext.append("&sceneType=1");
        paramContext = paramContext.toString();
      }
      localObject = paramContext;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("small emoji url = ");
        paramString.append(paramContext);
        QLog.i("VasWebviewUtil", 2, paramString.toString());
        localObject = paramContext;
      }
    }
    return a((String)localObject, paramLong);
  }
  
  public static String b(Intent paramIntent, Context paramContext)
  {
    String str = IndividuationUrlHelper.a(paramContext, "emoji", "");
    paramContext = str;
    if (((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).isFragmentStyleOrEmoStore(paramIntent)) {
      paramContext = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).processEmoStoreHomeUrl(str);
    }
    return paramContext;
  }
  
  public static String b(Intent paramIntent, String paramString)
  {
    String str = paramIntent.getStringExtra("currentId");
    paramIntent = paramString;
    if (!TextUtils.isEmpty(str))
    {
      paramIntent = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramString.contains("?"))
        {
          paramIntent = new StringBuilder();
          paramIntent.append(paramString);
          paramIntent.append("&rec_id=");
          paramIntent.append(str);
          return paramIntent.toString();
        }
        paramIntent = new StringBuilder();
        paramIntent.append(paramString);
        paramIntent.append("?rec_id=");
        paramIntent.append(str);
        paramIntent = paramIntent.toString();
      }
    }
    return paramIntent;
  }
  
  public static String b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("vas_web_report_entry: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("-->");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("WebReportAdapter", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 0) {
      return paramString;
    }
    String str = b(paramInt);
    Object localObject = paramString;
    if (!TextUtils.isEmpty(str))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static void b(Context paramContext, String paramString, long paramLong, Intent paramIntent, boolean paramBoolean, int paramInt)
  {
    if (paramContext == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("VasWebviewUtil", 4, "open qqbrowser erro context");
      }
      return;
    }
    long l = System.currentTimeMillis();
    if ((paramLong == 4194304L) && (!b(paramContext))) {
      return;
    }
    paramString = a(paramContext, paramString, paramLong, paramIntent);
    if (QLog.isColorLevel())
    {
      paramLong = System.currentTimeMillis();
      paramIntent = new StringBuilder();
      paramIntent.append("opeen vas webview cost: ");
      paramIntent.append(paramLong - l);
      QLog.i("VasWebviewUtil", 2, paramIntent.toString());
    }
    if ((paramBoolean) && ((paramContext instanceof Activity)))
    {
      ((Activity)paramContext).startActivityForResult(paramString, paramInt);
      return;
    }
    paramContext.startActivity(paramString);
  }
  
  public static boolean b(Context paramContext)
  {
    if (!Utils.b())
    {
      Toast.makeText(paramContext, paramContext.getString(2131916075), 0).show();
      return false;
    }
    if (Utils.c() < 5242880L)
    {
      Toast.makeText(paramContext, paramContext.getString(2131916076), 0).show();
      return false;
    }
    return true;
  }
  
  private static Intent c(Intent paramIntent, String paramString)
  {
    return ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).putWebViewTitleStyle(paramIntent, paramString);
  }
  
  private static Intent d(Intent paramIntent, String paramString)
  {
    return ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).insertWbPlugin(paramIntent, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.webview.util.VasWebviewUtil
 * JD-Core Version:    0.7.0.1
 */