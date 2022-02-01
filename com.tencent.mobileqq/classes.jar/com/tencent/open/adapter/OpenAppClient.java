package com.tencent.open.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.component.cache.CacheManager;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.common.AppNotificationManager;
import com.tencent.open.downloadnew.common.IntentFactory;
import com.tencent.open.downloadnew.common.NoticeParam;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import mqq.manager.TicketManager;

public class OpenAppClient
{
  protected static int a = 7;
  public static final String a = "com.tencent.open.adapter.OpenAppClient";
  protected static boolean a = false;
  protected static int b = 11;
  protected static String b;
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    try
    {
      boolean bool = jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      jdField_a_of_type_Boolean = true;
      String str2 = paramBundle.getString("schemaurl");
      Object localObject = paramBundle.getString("uin");
      String str1 = paramBundle.getString("vkey");
      if (localObject != null)
      {
        paramBundle = (Bundle)localObject;
        if (!((String)localObject).equals("0")) {}
      }
      else
      {
        paramBundle = String.valueOf(CommonDataAdapter.a().a());
      }
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = CommonDataAdapter.a().a();
      }
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        ThreadManager.executeOnSubThread(new OpenAppClient.GetVkeyRunnable(paramActivity, 1, str2));
      }
      else
      {
        jdField_a_of_type_Boolean = false;
        AppClient.a(paramActivity, str2, paramBundle, (String)localObject);
      }
      return;
    }
    finally {}
  }
  
  public static void a(Context paramContext, String paramString)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPcPushMsgForground ");
    localStringBuilder.append(paramString);
    LogUtility.b(str, localStringBuilder.toString());
    if (APNUtil.c(paramContext)) {
      a(paramContext, Common.a(paramString));
    }
  }
  
  protected static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("onPushDownloadMsg ");
    ((StringBuilder)localObject3).append(paramHashMap);
    LogUtility.b((String)localObject1, ((StringBuilder)localObject3).toString());
    String str2 = (String)paramHashMap.get("appid");
    String str3 = (String)paramHashMap.get("packname");
    localObject1 = (String)paramHashMap.get("packetversion");
    String str4 = (String)paramHashMap.get("downurl");
    String str1 = (String)paramHashMap.get("via");
    localObject3 = (String)paramHashMap.get("appname");
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject3 = "";
    }
    paramHashMap = new StringBuilder();
    paramHashMap.append("_");
    paramHashMap.append(str2);
    String str5 = paramHashMap.toString();
    paramHashMap = DownloadManager.a().a(str2);
    int i = AppUtil.a(str3);
    int j = -1;
    if (i > 0) {
      i = AppUtil.a(str3);
    } else {
      i = -1;
    }
    if (AppUtil.b(paramHashMap) > 0) {
      j = AppUtil.b(paramHashMap);
    }
    paramHashMap = jdField_a_of_type_JavaLangString;
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("installedApkVer = ");
    ((StringBuilder)localObject4).append(i);
    ((StringBuilder)localObject4).append(" downloadedApkVer = ");
    ((StringBuilder)localObject4).append(j);
    ((StringBuilder)localObject4).append(" serverApkVer = ");
    ((StringBuilder)localObject4).append(j);
    LogUtility.a(paramHashMap, ((StringBuilder)localObject4).toString());
    try
    {
      k = Integer.valueOf((String)localObject1).intValue();
    }
    catch (NumberFormatException paramHashMap)
    {
      int k;
      label272:
      Object localObject5;
      Object localObject2;
      boolean bool;
      break label272;
    }
    paramHashMap = jdField_a_of_type_JavaLangString;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("onPushMsg versionCode exception versionCode: ");
    ((StringBuilder)localObject4).append((String)localObject1);
    LogUtility.e(paramHashMap, ((StringBuilder)localObject4).toString());
    k = 0;
    paramHashMap = null;
    localObject1 = null;
    if (!TextUtils.isEmpty(str1))
    {
      try
      {
        localObject4 = str1.split("\\.");
        if ((localObject4 == null) || (localObject4.length < 2)) {
          break label497;
        }
        paramHashMap = new StringBuilder();
        int m = 0;
        try
        {
          for (;;)
          {
            int n = localObject4.length;
            if (m >= n) {
              break;
            }
            if (m != 1)
            {
              try
              {
                paramHashMap.append(localObject4[m]);
              }
              catch (Exception localException3)
              {
                localObject1 = paramHashMap;
                paramHashMap = localException3;
                break label481;
              }
            }
            else
            {
              paramHashMap.append(localException3[m]);
              paramHashMap.append(".");
              paramHashMap.append("AUTO");
            }
            n = localException3.length;
            if (m != n - 1) {
              try
              {
                paramHashMap.append(".");
              }
              catch (Exception localException1)
              {
                break label470;
              }
            }
            m += 1;
          }
          HashMap<String, String> localHashMap = paramHashMap;
        }
        catch (Exception localException2)
        {
          label470:
          localObject5 = localException2;
          localObject2 = paramHashMap;
        }
        label481:
        LogUtility.c(jdField_a_of_type_JavaLangString, "viaSB >>>", (Throwable)localObject5);
      }
      catch (Exception paramHashMap)
      {
        localObject5 = paramHashMap;
      }
      break label500;
    }
    label497:
    localObject2 = paramHashMap;
    label500:
    if (localObject2 != null) {
      paramHashMap = ((StringBuilder)localObject2).toString();
    } else {
      paramHashMap = str1;
    }
    localObject2 = new NoticeParam();
    ((NoticeParam)localObject2).jdField_a_of_type_JavaLangString = str2;
    ((NoticeParam)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject3);
    ((NoticeParam)localObject2).d = str3;
    ((NoticeParam)localObject2).f = str5;
    localObject5 = new Bundle();
    ((Bundle)localObject5).putString("id", str2);
    ((Bundle)localObject5).putString("via", paramHashMap);
    ((Bundle)localObject5).putString("downloadUrl", str4);
    ((Bundle)localObject5).putString("packageName", str3);
    ((Bundle)localObject5).putString("channelId", "2400");
    if (k <= i)
    {
      StaticAnalyz.a("100", "ANDROIDQQ.PCPUSH.AUTO.NEWTIPS", str2);
      ((NoticeParam)localObject2).jdField_b_of_type_Int = 2;
      ((NoticeParam)localObject2).e = str4;
      ((NoticeParam)localObject2).jdField_a_of_type_AndroidContentIntent = IntentFactory.a((Bundle)localObject5);
      AppNotificationManager.a().a((NoticeParam)localObject2);
      return;
    }
    if (k <= j)
    {
      StaticAnalyz.a("100", "ANDROIDQQ.PCPUSH.AUTO.DOWNLOADED", str2);
      ((NoticeParam)localObject2).jdField_b_of_type_Int = 3;
      ((NoticeParam)localObject2).e = str4;
      ((NoticeParam)localObject2).jdField_a_of_type_AndroidContentIntent = IntentFactory.a((Bundle)localObject5);
      AppNotificationManager.a().a((NoticeParam)localObject2);
      paramHashMap = DownloadManager.a().a(str2);
      localObject2 = DownloadManager.a().b(str2);
      if ((AppUtil.a(paramHashMap) == null) || (AppUtil.a(paramContext, paramHashMap, (String)localObject2))) {
        LogUtility.e(jdField_a_of_type_JavaLangString, "AUTO push and AUTO install failed!!!");
      }
    }
    else
    {
      if (DownloadManager.a().a(str2) != null) {
        StaticAnalyz.a("100", "ANDROIDQQ.PCPUSH.AUTO.DOWNLOADING", str2);
      }
      paramContext = IntentFactory.a((Bundle)localObject5);
      if ((str3 != null) && (!str3.trim().equals(""))) {
        bool = true;
      } else {
        bool = false;
      }
      paramContext = new DownloadInfo(str2, str4.trim(), str3, (String)localObject3, paramHashMap, paramContext, "biz_src_yyb", bool);
      DownloadManager.a().a(paramContext);
    }
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    CacheManager.a(CommonDataAdapter.a().a());
    String str;
    if (paramAppInterface != null)
    {
      boolean bool = paramAppInterface instanceof QQAppInterface;
      str = "";
      if (bool)
      {
        ((TicketManager)paramAppInterface.getManager(2)).getSkey(paramAppInterface.getAccount());
        str = ((QQAppInterface)paramAppInterface).getAccount();
      }
      else if ((paramAppInterface instanceof BrowserAppInterface))
      {
        str = ((BrowserAppInterface)paramAppInterface).getAccount();
        ThreadManager.executeOnNetWorkThread(new OpenAppClient.GetVkeyRunnable(paramAppInterface, 0, ""));
      }
      if (TextUtils.isEmpty(str)) {}
    }
    try
    {
      CommonDataAdapter.a().a(Long.valueOf(str).longValue());
      return;
    }
    catch (Exception paramAppInterface) {}
  }
  
  protected static boolean a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null)
    {
      if (paramHashMap.size() == 0) {
        return false;
      }
      int i = -1;
      try
      {
        int j = Integer.parseInt((String)paramHashMap.get("isauto"));
        i = j;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        LogUtility.a(jdField_a_of_type_JavaLangString, "onPcPushMsgForground>>>", localNumberFormatException);
      }
      if (i == 1) {
        try
        {
          if (DownloadApi.a((String)paramHashMap.get("appid"))) {
            return false;
          }
          ThreadManager.executeOnSubThread(new OpenAppClient.2(paramContext, paramHashMap));
          return true;
        }
        catch (Exception paramContext)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onPushMsg exception: ");
          localStringBuilder.append(paramHashMap);
          paramHashMap = localStringBuilder.toString();
          LogUtility.c(jdField_a_of_type_JavaLangString, paramHashMap, paramContext);
        }
      }
    }
    return false;
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle)
  {
    try
    {
      boolean bool = jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      jdField_a_of_type_Boolean = true;
      String str = paramBundle.getString("schemaurl");
      paramBundle.getString("uin");
      if (TextUtils.isEmpty(str))
      {
        jdField_a_of_type_Boolean = false;
        return;
      }
      try
      {
        ThreadManager.executeOnNetWorkThread(new OpenAppClient.GetVkeyRunnable(paramActivity, 2, new URL(str).getQuery()));
      }
      catch (MalformedURLException paramActivity)
      {
        paramActivity.printStackTrace();
        jdField_a_of_type_Boolean = false;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.adapter.OpenAppClient
 * JD-Core Version:    0.7.0.1
 */