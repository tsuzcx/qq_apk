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
  public static ConcurrentHashMap<String, String> a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static Intent a(long paramLong, Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    Intent localIntent = paramIntent;
    if (paramLong > 0L) {
      localIntent = b(paramIntent, String.valueOf(paramLong));
    }
    return localIntent;
  }
  
  private static Intent a(Intent paramIntent, String paramString)
  {
    return ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).putWebViewTitleStyle(paramIntent, paramString);
  }
  
  @NotNull
  private static String a(int paramInt)
  {
    String str = new EntryReportParams(paramInt).a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("&traceDetail=base64-");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public static String a(Intent paramIntent, Context paramContext, long paramLong, String paramString)
  {
    int j = paramIntent.getIntExtra("emojimall_src", 1);
    int i;
    if (paramLong == 4L) {
      i = 3;
    } else if (paramLong == 8L) {
      i = 2;
    } else {
      i = 1;
    }
    if ((i != 1) && (i != 3))
    {
      paramContext = paramString;
    }
    else
    {
      localObject = IndividuationUrlHelper.a(paramContext, "emoji", "");
      paramString = (String)localObject;
      if (((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).isFragmentStyleOrEmoStore(paramIntent)) {
        paramString = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).processEmoStoreHomeUrl((String)localObject);
      }
      if ((j != 8) && (j != 4) && (j != 12))
      {
        if (j == 11)
        {
          paramContext = IndividuationUrlHelper.a(paramContext, "smallEmojiList", "[id]", "");
        }
        else if (j == 5)
        {
          paramContext = IndividuationUrlHelper.a(paramContext, "emojiAuthorDetail", "[id]", "");
        }
        else if (j == 6)
        {
          paramString = IndividuationUrlHelper.a(MobileQQ.sMobileQQ.getApplicationContext(), "magicPlus", "");
          paramContext = paramString;
          if (!TextUtils.isEmpty(paramString))
          {
            paramContext = paramString;
            if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
              paramContext = paramString.replace("[uin]", MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
            }
            paramContext = paramContext.replace("[client]", "androidQQ").replace("[version]", "8.7.0.5295").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE);
          }
        }
        else if (j == 9)
        {
          paramContext = paramContext.getSharedPreferences("mobileQQ", 0).getString("magic_promotion_jump_url", "");
          localObject = paramContext;
          if (!TextUtils.isEmpty(paramContext))
          {
            paramString = paramContext;
            if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
              paramString = paramContext.replace("[uin]", MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
            }
            localObject = paramString.replace("[client]", "androidQQ").replace("[version]", "8.7.0.5295").replace("[platformId]", "2").replace("[device]", Build.DEVICE).replace("[system]", Build.VERSION.RELEASE);
            paramString = (String)localObject;
          }
          paramContext = paramString;
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("promotion_jump_url:");
            paramContext.append((String)localObject);
            QLog.d("VasWebviewUtil", 2, paramContext.toString());
            paramContext = paramString;
          }
        }
        else
        {
          paramContext = paramString;
          if (j == 3)
          {
            localObject = paramIntent.getStringExtra("currentId");
            paramContext = paramString;
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              paramContext = paramString;
              if (!TextUtils.isEmpty(paramString)) {
                if (paramString.contains("?"))
                {
                  paramContext = new StringBuilder();
                  paramContext.append(paramString);
                  paramContext.append("&rec_id=");
                  paramContext.append((String)localObject);
                  paramContext = paramContext.toString();
                }
                else
                {
                  paramContext = new StringBuilder();
                  paramContext.append(paramString);
                  paramContext.append("?rec_id=");
                  paramContext.append((String)localObject);
                  paramContext = paramContext.toString();
                }
              }
            }
          }
        }
      }
      else if (!paramIntent.hasExtra("emoji_is_original"))
      {
        paramContext = IndividuationUrlHelper.a(paramContext, "emojiDetail", "[id]", "");
      }
      else
      {
        paramString = Integer.toString(paramIntent.getIntExtra("emoji_author_id", 0));
        if (paramIntent.getBooleanExtra("emoji_is_original", false)) {
          paramContext = IndividuationUrlHelper.a(paramContext, "openAuthorDetail", paramString, "");
        } else {
          paramContext = IndividuationUrlHelper.a(paramContext, "emojiAuthorDetail", paramString, "");
        }
      }
    }
    if (TextUtils.isEmpty(paramContext)) {
      return "";
    }
    paramString = "vip.gongneng.mobile.biaoqing.client_tab_store";
    if ((j != 8) && (j != 4) && (j != 12))
    {
      if ((j != 2) && (j != 3))
      {
        if (j == 7) {
          paramString = "vip.gongneng.mobile.biaoqing.client_index_banner";
        } else if (j == 6) {
          paramString = "vip.gongneng.mobile.biaoqing.client_aio_magic";
        }
      }
      else {
        paramString = "vip.gongneng.mobile.biaoqing.client_manager_top";
      }
      i = 1;
    }
    else
    {
      paramString = paramIntent.getStringExtra("emojimall_detail_id");
      if (TextUtils.isEmpty(paramString))
      {
        localObject = "vip.gongneng.mobile.biaoqing.client_tab_store";
        i = 0;
        paramString = paramContext;
        paramContext = (Context)localObject;
      }
      else
      {
        paramString = paramContext.replace("[id]", paramString).replace("[type]", "view");
        paramContext = "vip.gongneng.mobile.biaoqing.client_manager_item";
        i = 1;
      }
      localObject = paramString;
      if (j == 12)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("&location=dashang");
        localObject = ((StringBuilder)localObject).toString();
      }
      paramString = paramContext;
      paramContext = (Context)localObject;
    }
    Object localObject = paramContext;
    if (i != 0)
    {
      paramContext = paramContext.replace("[adtag]", paramString).replace("[systemInt]", Integer.toString(Build.VERSION.SDK_INT));
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("loadHomePage:");
        paramString.append(paramContext);
        QLog.d("VasWebviewUtil", 2, paramString.toString());
      }
      i = paramIntent.getIntExtra("emomall_new_time", -1);
      if (i > 0)
      {
        paramString = new StringBuilder();
        paramString.append("");
        paramString.append(i);
        paramContext = paramContext.replace("[updateTime]", paramString.toString());
      }
      else
      {
        paramContext = paramContext.replace("[updateTime]", "0");
      }
      paramContext = paramContext.replace("[updateFlag]", Boolean.valueOf(paramIntent.getBooleanExtra("updateFlag", false)).toString());
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(paramIntent.getIntExtra("updateId", 0));
      paramString = paramContext.replace("[updateId]", paramString.toString());
      paramContext = paramString;
      if (paramIntent.hasExtra(((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getKeyIsSmallEmoticon()))
      {
        paramContext = paramString;
        if (paramIntent.getBooleanExtra(((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getKeyIsSmallEmoticon(), false))
        {
          paramContext = new StringBuilder();
          paramContext.append(paramString);
          paramContext.append("&emojiType=5");
          paramContext = paramContext.toString();
        }
      }
      paramString = paramContext;
      if (paramIntent.getBooleanExtra("emoji_to_dressup", false))
      {
        paramIntent = new StringBuilder();
        paramIntent.append(paramContext);
        paramIntent.append("&to=recommend");
        paramString = paramIntent.toString();
      }
      localObject = a(paramString, 47);
    }
    return localObject;
  }
  
  public static String a(String paramString, int paramInt)
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
    String str = a(paramInt);
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
    if (VasUtil.a().isCanOpenGxhHippyPage())
    {
      VasUtil.a().openGxhHippyPage();
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
    ConcurrentHashMap localConcurrentHashMap = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    Object localObject = paramString;
    if (localConcurrentHashMap != null)
    {
      localObject = paramString;
      if (localConcurrentHashMap.size() > 0)
      {
        localObject = paramString;
        if ("1".equalsIgnoreCase((String)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramLong))))
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
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramIntent.putExtra("url", (String)localObject);
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
      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
      {
        localObject = paramAppInterface.getResources().getDisplayMetrics();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((DisplayMetrics)localObject).widthPixels);
        localStringBuilder.append("*");
        localStringBuilder.append(((DisplayMetrics)localObject).heightPixels);
        jdField_a_of_type_JavaLangString = localStringBuilder.toString();
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
      paramAppInterface = Arrays.asList(new String[] { "1", str1, ((IQQDcReporter)QRoute.api(IQQDcReporter.class)).getImei(paramAppInterface), "", "android", "201", Build.VERSION.RELEASE, "3001", "3001013", "", "", paramString1, "", "", "", paramString2, "", paramString3, "", "", paramString4, "", "", "8.7.0", "", "", "", "", "", "android", str2, jdField_a_of_type_JavaLangString, "", localObject[0], localObject[1], localObject[2], localObject[3], localObject[4], localObject[5], localObject[6], localObject[7], localObject[8] });
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
  
  public static boolean a(Context paramContext)
  {
    if (!Utils.a())
    {
      Toast.makeText(paramContext, paramContext.getString(2131718574), 0).show();
      return false;
    }
    if (Utils.b() < 5242880L)
    {
      Toast.makeText(paramContext, paramContext.getString(2131718575), 0).show();
      return false;
    }
    return true;
  }
  
  private static Intent b(Intent paramIntent, String paramString)
  {
    return ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).insertWbPlugin(paramIntent, paramString);
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
    if ((paramLong == 4194304L) && (!a(paramContext))) {
      return;
    }
    if (paramIntent != null) {
      paramIntent.setClass(paramContext, ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getQQBrowserActivityClass());
    } else {
      paramIntent = new Intent(paramContext, ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getQQBrowserActivityClass());
    }
    if ((paramLong != 2L) && (paramLong != 4L))
    {
      localObject1 = paramString;
      if (paramLong != 8L) {}
    }
    else
    {
      localObject1 = a(paramIntent, paramContext, paramLong, paramString);
      paramString = (String)localObject1;
      if (paramIntent != null)
      {
        paramString = (String)localObject1;
        if (paramIntent.getBooleanExtra("is_small_emoji", false))
        {
          paramString = new StringBuilder();
          paramString.append((String)localObject1);
          paramString.append("&emojiType=5");
          paramString = paramString.toString();
        }
        localObject2 = paramIntent.getStringExtra("emoji_ids");
        localObject1 = paramString;
        if (localObject2 != null)
        {
          localObject1 = paramString;
          if (!((String)localObject2).equals(""))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString);
            ((StringBuilder)localObject1).append("&id=");
            ((StringBuilder)localObject1).append((String)localObject2);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        paramString = (String)localObject1;
        if (paramIntent.getBooleanExtra(((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).getKeyIsKandianEmoticon(), false))
        {
          paramString = new StringBuilder();
          paramString.append((String)localObject1);
          paramString.append("&sceneType=1");
          paramString = paramString.toString();
        }
      }
      localObject1 = paramString;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("small emoji url = ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.i("VasWebviewUtil", 2, ((StringBuilder)localObject1).toString());
        localObject1 = paramString;
      }
    }
    Object localObject2 = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    paramString = (String)localObject1;
    if (localObject2 != null)
    {
      paramString = (String)localObject1;
      if (((ConcurrentHashMap)localObject2).size() > 0)
      {
        paramString = (String)localObject1;
        if ("1".equalsIgnoreCase((String)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramLong))))
        {
          paramString = (String)localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramString = (String)localObject1;
            if (!((String)localObject1).contains("async_cookie=1"))
            {
              localObject1 = ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).addParamToUrl((String)localObject1, "async_cookie=1");
              paramString = (String)localObject1;
              if (QLog.isColorLevel())
              {
                paramString = new StringBuilder();
                paramString.append("now business id ");
                paramString.append(paramLong);
                paramString.append("  use async_cookie");
                QLog.i("VasWebviewUtil", 1, paramString.toString());
                paramString = (String)localObject1;
              }
            }
          }
        }
      }
    }
    Object localObject1 = paramIntent;
    if (!TextUtils.isEmpty(paramString))
    {
      paramIntent.putExtra("url", paramString);
      localObject1 = a(paramIntent, Uri.parse(paramString).getHost());
    }
    ((Intent)localObject1).putExtra("business", paramLong);
    a(paramLong, (Intent)localObject1);
    if (((Intent)localObject1).getLongExtra("startOpenPageTime", 0L) <= 0L) {
      ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
    }
    ((Intent)localObject1).putExtra(((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).isShowAdKey(), false);
    ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_jc_vip");
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
      ((Activity)paramContext).startActivityForResult((Intent)localObject1, paramInt);
      return;
    }
    paramContext.startActivity((Intent)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.webview.util.VasWebviewUtil
 * JD-Core Version:    0.7.0.1
 */