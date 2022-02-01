package com.tencent.open.appcommon;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.base.FileUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.tmassistantbase.common.DownloadSDKConfigManager;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class AppClient
  extends BaseAppClient
{
  public static Class a(String paramString)
  {
    try
    {
      Class.forName("com.tencent.open.appcenter.QZoneAppWebViewActivity");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (paramString.equals("detail")) {
      return QZoneAppListActivity.class;
    }
    if (paramString.equals("index")) {
      return QZoneAppListActivity.class;
    }
    paramString.equals("online");
    return QZoneAppListActivity.class;
  }
  
  protected static String a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("getFeedsChannelId >>> qzoneAppid = ");
    paramString.append(paramInt1);
    paramString.append("| ");
    paramString.append(paramInt2);
    paramString.append(" | ");
    paramString.append(paramInt3);
    LogUtility.c("AppClient", paramString.toString());
    if (paramInt1 == 352)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 == 3) {
            break label119;
          }
          if ((paramInt2 != 7) && (paramInt2 != 8)) {
            return "";
          }
          if ((paramInt3 != 0) && (paramInt3 != 2))
          {
            if (paramInt3 == 1) {
              return "200_2";
            }
          }
          else {
            return "200_1";
          }
        }
        return "";
      }
      label119:
      return "100_1";
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    if (bool) {
      return "";
    }
    String[] arrayOfString = paramString.split("\\.");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 2;
    paramString = str;
    if (arrayOfString != null)
    {
      paramString = str;
      if (arrayOfString.length > 2)
      {
        while (i < arrayOfString.length)
        {
          if (i == arrayOfString.length - 1)
          {
            localStringBuilder.append(arrayOfString[i]);
          }
          else
          {
            paramString = new StringBuilder();
            paramString.append(arrayOfString[i]);
            paramString.append(".");
            localStringBuilder.append(paramString.toString());
          }
          i += 1;
        }
        paramString = localStringBuilder.toString();
      }
    }
    return paramString;
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    Common.a();
    int i = paramBundle.getInt("qzoneAppid");
    int k = paramBundle.getInt("qzoneSubId");
    int m = paramBundle.getInt("op_type");
    int j = paramBundle.getInt("from");
    boolean bool1 = paramBundle.getBoolean("is_can_open_yyb_native", true);
    Object localObject1 = paramBundle.getString("schemaUrl");
    boolean bool2 = TextUtils.isEmpty((CharSequence)localObject1);
    paramActivity = null;
    String str;
    if ((!bool2) && (((String)localObject1).contains("&")))
    {
      localObject6 = new Bundle();
      localObject2 = localObject1;
      if (((String)localObject1).startsWith("http://")) {
        try
        {
          localObject2 = new URL((String)localObject1).getQuery();
        }
        catch (MalformedURLException paramActivity)
        {
          paramActivity.printStackTrace();
          localObject2 = localObject1;
        }
      }
      HashMap localHashMap = Common.a((String)localObject2);
      paramActivity = (String)localHashMap.get("appid");
      localObject1 = paramActivity;
      if (TextUtils.isEmpty(paramActivity)) {
        localObject1 = (String)localHashMap.get(DownloadConstants.b);
      }
      paramActivity = (String)localHashMap.get(DownloadConstants.jdField_c_of_type_JavaLangString);
      localObject3 = paramActivity;
      if (TextUtils.isEmpty(paramActivity)) {
        localObject3 = (String)localHashMap.get("ta");
      }
      paramActivity = (String)localHashMap.get(DownloadConstants.d);
      localObject4 = paramActivity;
      if (TextUtils.isEmpty(paramActivity)) {
        localObject4 = (String)localHashMap.get("tk");
      }
      localObject7 = (String)localHashMap.get(DownloadConstants.e);
      str = (String)localHashMap.get("via");
      localObject5 = (String)localHashMap.get("packName");
      paramActivity = (Activity)localObject5;
      if (TextUtils.isEmpty((CharSequence)localObject5)) {
        paramActivity = (String)localHashMap.get(DownloadConstants.f);
      }
      localObject5 = (String)localHashMap.get(DownloadConstants.D);
      Object localObject8 = new StringBuilder();
      ((StringBuilder)localObject8).append(" feedChannel:");
      ((StringBuilder)localObject8).append((String)localObject5);
      ((StringBuilder)localObject8).append("   schemaUrl:");
      ((StringBuilder)localObject8).append((String)localObject2);
      LogUtility.d("AppClient", ((StringBuilder)localObject8).toString());
      bool2 = TextUtils.isEmpty((CharSequence)localObject5);
      localObject8 = "";
      if ((!bool2) && (!((String)localObject5).startsWith("0;")))
      {
        localObject5 = ((String)localObject5).split(";");
        if (localObject5 != null) {
          break label406;
        }
      }
      label406:
      while (localObject5.length <= 0)
      {
        localObject5 = localObject8;
        break;
      }
      CharSequence localCharSequence = localObject5[0];
      localObject5 = localObject8;
      if (!TextUtils.isEmpty(localCharSequence)) {
        if (localCharSequence.equals("0")) {
          localObject5 = localObject8;
        } else {
          localObject5 = localCharSequence;
        }
      }
      localObject8 = new StringBuilder();
      ((StringBuilder)localObject8).append(" finalFeedChannel:");
      ((StringBuilder)localObject8).append((String)localObject5);
      LogUtility.d("AppClient", ((StringBuilder)localObject8).toString());
      if ((!TextUtils.isEmpty(paramActivity)) && (AppUtil.a(paramActivity))) {
        paramBundle = (String)localHashMap.get("appCustom");
      }
    }
    try
    {
      localObject2 = URLDecoder.decode(paramBundle, "UTF-8");
      paramBundle = (Bundle)localObject2;
    }
    catch (Exception localException)
    {
      label525:
      break label525;
    }
    AppUtil.a(CommonDataAdapter.a().a(), (String)localObject1, paramActivity, paramBundle);
    return;
    ((Bundle)localObject6).putString(DownloadConstants.b, (String)localObject1);
    ((Bundle)localObject6).putString(DownloadConstants.jdField_c_of_type_JavaLangString, (String)localObject3);
    ((Bundle)localObject6).putString(DownloadConstants.d, (String)localObject4);
    ((Bundle)localObject6).putString(DownloadConstants.e, (String)localObject7);
    ((Bundle)localObject6).putString(DownloadConstants.f, paramActivity);
    ((Bundle)localObject6).putString(DownloadConstants.i, str);
    ((Bundle)localObject6).putString(DownloadConstants.D, (String)localObject5);
    ((Bundle)localObject6).putString("schemaUrl", (String)localObject2);
    Object localObject5 = localObject6;
    Object localObject3 = str;
    Object localObject4 = localObject7;
    Object localObject6 = paramActivity;
    paramActivity = (Activity)localObject3;
    localObject3 = localObject1;
    break label661;
    localObject3 = localObject1;
    localObject4 = "0";
    localObject5 = null;
    localObject6 = localObject5;
    Object localObject2 = localObject1;
    label661:
    if (m == 7)
    {
      localObject7 = a(i, k, j, (String)localObject3);
      localObject1 = paramActivity;
      if (TextUtils.isEmpty(paramActivity)) {
        localObject1 = StaticAnalyz.a(i, k, j);
      }
      OpenSdkStatic.a().a(String.valueOf(CommonDataAdapter.a().a()), (String)localObject3, (String)localObject1, "200", false);
      paramActivity = (Activity)localObject7;
    }
    else
    {
      localObject7 = "2410";
      localObject1 = paramActivity;
      paramActivity = (Activity)localObject7;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject6)) && (!"0".equals(localObject4)) && (localObject5 != null) && (MyAppApi.a().c()) && (bool1))
    {
      ThreadManager.getSubThreadHandler().post(new AppClient.2(paramBundle, (Bundle)localObject5, (String)localObject3, (String)localObject2, paramActivity, (String)localObject1));
      return;
    }
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(Common.g());
    ((StringBuilder)localObject4).append(File.separator);
    ((StringBuilder)localObject4).append("qapp_center_detail.htm");
    localObject4 = ((StringBuilder)localObject4).toString();
    localObject5 = new File((String)localObject4);
    if (!((File)localObject5).exists())
    {
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("file");
      ((StringBuilder)localObject6).append((String)localObject4);
      ((StringBuilder)localObject6).append(" not exist copyassets.");
      LogUtility.d("AppClient", ((StringBuilder)localObject6).toString());
      FileUtils.a("Page/system", Common.h());
    }
    localObject6 = new Intent();
    Object localObject7 = new Bundle();
    if (((File)localObject5).exists())
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("file:///");
      ((StringBuilder)localObject5).append((String)localObject4);
      localObject4 = ((StringBuilder)localObject5).toString();
    }
    else
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(Common.m());
      ((StringBuilder)localObject4).append(File.separator);
      ((StringBuilder)localObject4).append("qapp_center_detail.htm");
      localObject4 = ((StringBuilder)localObject4).toString();
    }
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append("&from=-10&id=");
    ((StringBuilder)localObject5).append((String)localObject3);
    ((StringBuilder)localObject5).append("&channelId=");
    ((StringBuilder)localObject5).append(paramActivity);
    localObject5 = ((StringBuilder)localObject5).toString();
    paramActivity = (Activity)localObject5;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      if (((String)localObject2).equals(localObject3))
      {
        paramActivity = (Activity)localObject5;
      }
      else
      {
        paramActivity = new StringBuilder();
        paramActivity.append((String)localObject5);
        paramActivity.append("&");
        paramActivity.append((String)localObject2);
        paramActivity = paramActivity.toString();
      }
    }
    if (Common.a(paramBundle.getString("schemaUrl")).get("auto_download") != null) {
      i = 1;
    } else {
      i = 0;
    }
    localObject2 = paramActivity;
    if (i != 0)
    {
      localObject2 = paramActivity;
      if (!paramActivity.contains("auto_download"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramActivity);
        ((StringBuilder)localObject2).append("&auto_download=1");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    ((Intent)localObject6).setClass(CommonDataAdapter.a().a(), QZoneAppListActivity.class);
    ((Bundle)localObject7).putString("APP_URL", (String)localObject4);
    ((Bundle)localObject7).putBoolean("FROM_FEED", true);
    ((Bundle)localObject7).putString("APP_PARAMS", (String)localObject2);
    if (DownloadSDKConfigManager.canGotoNewDetailPage((String)localObject1)) {
      ((Bundle)localObject7).putInt("goto_type", 7);
    } else {
      ((Bundle)localObject7).putInt("goto_type", 2);
    }
    if (paramBundle.getInt("process_id") == 2) {
      ((Bundle)localObject7).putInt("process_id", 2);
    }
    paramActivity = new StringBuilder();
    paramActivity.append("APP_URL:");
    paramActivity.append((String)localObject4);
    paramActivity.append(" |  PARAMS >>> ");
    paramActivity.append(((Bundle)localObject7).getString("APP_PARAMS"));
    LogUtility.b("Jie", paramActivity.toString());
    ((Intent)localObject6).putExtras((Bundle)localObject7);
    ((Intent)localObject6).putExtra("adapter_action", "action_app_detail");
    ((Intent)localObject6).addFlags(872415232);
    CommonDataAdapter.a().a().startActivity((Intent)localObject6);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("schemaUrl", paramString);
    a(paramActivity, localBundle);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("schemaUrl", paramString);
    localBundle.putInt("qzoneAppid", paramInt1);
    localBundle.putInt("qzoneSubId", paramInt2);
    localBundle.putInt("from", paramInt3);
    a(paramActivity, localBundle);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt, Bundle paramBundle)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Common.g());
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("qapp_center_detail.htm");
    localObject1 = ((StringBuilder)localObject1).toString();
    Common.a();
    Object localObject2 = new File((String)localObject1);
    Object localObject3;
    if (!((File)localObject2).exists())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("file");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(" not exist copyassets.");
      LogUtility.d("AppClient", ((StringBuilder)localObject3).toString());
      FileUtils.a("Page/system", Common.h());
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if (((File)localObject2).exists())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("file:///");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject3 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Common.m());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("qapp_center_detail.htm");
      localObject3 = ((StringBuilder)localObject1).toString();
    }
    localIntent.setClass(CommonDataAdapter.a().a(), QZoneAppListActivity.class);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("&from=-10&id=");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("&channelId=");
    ((StringBuilder)localObject1).append(paramInt);
    localObject1 = ((StringBuilder)localObject1).toString();
    paramString = null;
    if (paramBundle != null) {
      paramString = paramBundle.getString("via");
    }
    if (DownloadSDKConfigManager.canGotoNewDetailPage(paramString)) {
      localBundle.putInt("goto_type", 7);
    } else {
      localBundle.putInt("goto_type", 3);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&via=");
      ((StringBuilder)localObject2).append(paramString);
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    int i = 0;
    paramString = (String)localObject1;
    if (paramBundle != null)
    {
      boolean bool = paramBundle.getBoolean("autoDownload");
      paramString = paramBundle.getString("packageName");
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("&packageName=");
        ((StringBuilder)localObject2).append(paramString);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = paramBundle.getString("subpagetype");
      paramString = (String)localObject2;
      i = bool;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramString = new StringBuilder();
        paramString.append((String)localObject2);
        paramString.append("&subpagetype=");
        paramString.append((String)localObject1);
        paramString = paramString.toString();
        i = bool;
      }
    }
    localObject1 = paramString;
    if (i != 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("&msgType=56");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localBundle.putString("APP_PARAMS", (String)localObject1);
    if (paramBundle != null)
    {
      localBundle.putString("uin", paramBundle.getString("uin"));
      localBundle.putString("sid", paramBundle.getString("vkey"));
    }
    localBundle.putString("APP_URL", (String)localObject3);
    localBundle.putBoolean("FROM_FEED", true);
    paramString = new StringBuilder();
    paramString.append("APP_URL:");
    paramString.append((String)localObject3);
    paramString.append(" |  PARAMS >>> ");
    paramString.append(localBundle.getString("APP_PARAMS"));
    LogUtility.b("Jie", paramString.toString());
    localIntent.putExtras(localBundle);
    localIntent.putExtra("adapter_action", "action_app_detail");
    localIntent.addFlags(603979776);
    paramActivity.startActivityForResult(localIntent, 200);
  }
  
  protected static void a(Activity paramActivity, String paramString1, String paramString2, Bundle paramBundle, String paramString3, String paramString4)
  {
    Object localObject2 = paramString2;
    Common.a();
    if (!paramString3.equals("online"))
    {
      paramString2 = new StringBuilder();
      paramString2.append(Common.g());
      paramString2.append(File.separator);
      paramString2.append(paramString4);
      paramString2 = paramString2.toString();
      paramString4 = new File(paramString2);
      if (!paramString4.exists())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("file");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(" not exist copyassets.");
        LogUtility.d("AppClient", ((StringBuilder)localObject1).toString());
        FileUtils.a("Page/system", Common.h());
      }
      if (paramString4.exists())
      {
        paramString4 = new StringBuilder();
        paramString4.append("file:///");
        paramString4.append(paramString2);
        paramString2 = paramString4.toString();
      }
      else
      {
        paramString2 = new StringBuilder();
        paramString2.append(Common.m());
        paramString2.append(File.separator);
        paramString2.append("qapp_center_detail.htm");
        localObject1 = paramString2.toString();
        i = 0;
        break label218;
      }
    }
    else
    {
      paramString2 = paramString4;
    }
    int i = 1;
    Object localObject1 = paramString2;
    label218:
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    Class localClass = a(paramString3);
    localIntent.setClass(paramActivity, localClass);
    paramString2 = paramBundle.getString("installedVersion");
    Object localObject6 = paramBundle.getString("localVersion");
    String str2 = paramBundle.getString("typeid");
    String str3 = paramBundle.getString("serverApkVersion");
    String str4 = paramBundle.getString("msgType");
    String str5 = paramBundle.getString("sendTime");
    String str1 = paramBundle.getString("via");
    Object localObject4 = paramBundle.getString("splitvia");
    Object localObject5 = paramBundle.getString("subPageType");
    Object localObject3 = paramBundle.getString("appCustom");
    paramString4 = (String)localObject2;
    if (localObject2 == "2460")
    {
      paramString4 = new StringBuilder();
      paramString4.append((String)localObject2);
      paramString4.append("_");
      paramString4.append(str4);
      paramString4 = paramString4.toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("&from=-10&id=");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("&channelId=");
    ((StringBuilder)localObject2).append(paramString4);
    ((StringBuilder)localObject2).append("&installedVersion=");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append("&localVersion=");
    ((StringBuilder)localObject2).append((String)localObject6);
    ((StringBuilder)localObject2).append("&serverApkVersion=");
    ((StringBuilder)localObject2).append(str3);
    ((StringBuilder)localObject2).append("&typeId=");
    ((StringBuilder)localObject2).append(str2);
    ((StringBuilder)localObject2).append("&msgType=");
    ((StringBuilder)localObject2).append(str4);
    ((StringBuilder)localObject2).append("&sendTime=");
    ((StringBuilder)localObject2).append(str5);
    paramString2 = ((StringBuilder)localObject2).toString();
    localObject2 = paramBundle.getString("schemaUrl");
    if (!TextUtils.isEmpty((CharSequence)localObject5))
    {
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append(paramString2);
      ((StringBuilder)localObject6).append("&subPageType=");
      ((StringBuilder)localObject6).append((String)localObject5);
      paramString2 = ((StringBuilder)localObject6).toString();
    }
    if (!TextUtils.isEmpty(str1))
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(paramString2);
      ((StringBuilder)localObject5).append("&via=");
      ((StringBuilder)localObject5).append(str1);
      paramString2 = ((StringBuilder)localObject5).toString();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(paramString2);
      ((StringBuilder)localObject5).append("&splitVia=");
      ((StringBuilder)localObject5).append((String)localObject4);
      paramString2 = ((StringBuilder)localObject5).toString();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(paramString2);
      ((StringBuilder)localObject4).append("&appCustom=");
      ((StringBuilder)localObject4).append((String)localObject3);
      paramString2 = ((StringBuilder)localObject4).toString();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString2);
      ((StringBuilder)localObject3).append("&");
      ((StringBuilder)localObject3).append((String)localObject2);
      paramString2 = ((StringBuilder)localObject3).toString();
    }
    localBundle.putString("APP_PARAMS", paramString2);
    localBundle.putString("uin", paramBundle.getString("uin"));
    localBundle.putString("sid", paramBundle.getString("vkey"));
    localBundle.putString("APP_URL", (String)localObject1);
    localBundle.putBoolean("FROM_FEED", true);
    localBundle.putString(DownloadConstants.i, str1);
    if ("detail".equals(paramString3)) {
      localBundle.putInt("goto_type", 2);
    } else if ("index".equals(paramString3)) {
      localBundle.putInt("goto_type", 1);
    }
    if ((paramString3.equals("custom")) && (i != 0)) {}
    for (;;)
    {
      try
      {
        paramString2 = paramBundle.getString("pageTitles");
        if (TextUtils.isEmpty(paramString2)) {
          break label1044;
        }
        paramString2 = new ArrayList(Arrays.asList(paramString2.split("&")));
        localBundle.putStringArrayList("titleName", paramString2);
        if (paramString2.size() <= 0) {
          break label1393;
        }
        bool = true;
        localBundle.putBoolean("showTitle", bool);
        paramString3 = new StringBuilder();
        paramString3.append("titles = ");
        paramString3.append(paramString2);
        paramString2 = paramString3.toString();
        try
        {
          LogUtility.b("AppClient", paramString2);
        }
        catch (Exception paramString2) {}
        LogUtility.c("AppClient", "get push title error>>>", paramString2);
      }
      catch (Exception paramString2) {}
      label1044:
      paramString2 = new StringBuilder();
      paramString2.append("APP_URL:");
      paramString2.append((String)localObject1);
      paramString2.append(" |  PARAMS >>> ");
      paramString2.append(localBundle.getString("APP_PARAMS"));
      LogUtility.b("TAG", paramString2.toString());
      localIntent.putExtras(localBundle);
      localIntent.putExtra("adapter_action", "action_app_detail");
      localIntent.addFlags(603979776);
      paramString2 = null;
      try
      {
        paramString3 = Class.forName("com.tencent.open.appcenter.QZoneAppWebViewActivity");
        paramString2 = paramString3;
      }
      catch (Exception paramString3)
      {
        paramString3.printStackTrace();
      }
      if ((paramString2 != null) && (localClass.getName().equals(paramString2.getName())))
      {
        if (paramString4.equals("2457"))
        {
          paramString1 = DownloadManager.a().a(paramString1);
          if ((MyAppApi.a().c()) && (paramString1 != null) && (paramString1.jdField_c_of_type_Int == 1))
          {
            paramString2 = new StringBuilder();
            paramString2.append(">>>appid=");
            paramString2.append(paramString1.jdField_c_of_type_JavaLangString);
            paramString2.append(" myAppid=");
            paramString2.append(paramString1.j);
            LogUtility.d("AppClient", paramString2.toString());
            localBundle.putString(DownloadConstants.b, paramString1.jdField_c_of_type_JavaLangString);
            localBundle.putString(DownloadConstants.jdField_c_of_type_JavaLangString, paramString1.j);
            localBundle.putString(DownloadConstants.d, paramString1.k);
            localBundle.putString(DownloadConstants.i, str1);
            localBundle.putString(DownloadConstants.f, paramString1.e);
            localBundle.putInt(DownloadConstants.e, paramString1.b);
            MyAppApi.a().a(paramActivity, localBundle, paramString4.equals("2457"), true);
            return;
          }
          paramActivity.startActivityForResult(localIntent, 200);
          return;
        }
        ThreadManager.getSubThreadHandler().post(new AppClient.1(paramString1, localBundle, str1, paramActivity, localIntent, paramBundle));
        return;
      }
      paramActivity.startActivityForResult(localIntent, 200);
      return;
      label1393:
      boolean bool = false;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    a(paramActivity, paramString1, paramString2, paramString3, "2457");
  }
  
  protected static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("shcemaUrlAnd:");
    ((StringBuilder)localObject1).append(paramString1);
    LogUtility.b("AppClient", ((StringBuilder)localObject1).toString());
    Object localObject8;
    String str3;
    String str5;
    String str4;
    String str6;
    Object localObject7;
    String str7;
    Object localObject2;
    Object localObject3;
    String str2;
    int i;
    int j;
    if (paramString1 != null)
    {
      if (paramString1.length() == 0) {
        return;
      }
      localObject8 = Common.a(paramString1);
      str3 = (String)((HashMap)localObject8).get("appid");
      str5 = (String)((HashMap)localObject8).get("sendtime");
      str4 = (String)((HashMap)localObject8).get("packname");
      String str8 = (String)((HashMap)localObject8).get("packetversion");
      str6 = (String)((HashMap)localObject8).get("msgtype");
      String str9 = (String)((HashMap)localObject8).get("type");
      localObject7 = (String)((HashMap)localObject8).get("downurl");
      str7 = (String)((HashMap)localObject8).get("via");
      String str10 = a(str7);
      String str1 = (String)((HashMap)localObject8).get("appCustom");
      localObject1 = (String)((HashMap)localObject8).get("nativepage");
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = (String)((HashMap)localObject8).get("np");
      }
      localObject3 = (String)((HashMap)localObject8).get("htmlpage");
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = (String)((HashMap)localObject8).get("hp");
      }
      Object localObject4 = (String)((HashMap)localObject8).get("subpagetype");
      localObject3 = localObject4;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        localObject3 = (String)((HashMap)localObject8).get("sp");
      }
      Object localObject5 = (String)((HashMap)localObject8).get("pagetitles");
      localObject4 = localObject5;
      if (TextUtils.isEmpty((CharSequence)localObject5)) {
        localObject4 = (String)((HashMap)localObject8).get("pt");
      }
      Object localObject6 = (String)((HashMap)localObject8).get(DownloadConstants.jdField_c_of_type_JavaLangString);
      localObject5 = localObject6;
      if (TextUtils.isEmpty((CharSequence)localObject6)) {
        localObject5 = (String)((HashMap)localObject8).get("ta");
      }
      str2 = (String)((HashMap)localObject8).get(DownloadConstants.d);
      localObject6 = str2;
      if (TextUtils.isEmpty(str2)) {
        localObject6 = (String)((HashMap)localObject8).get("tk");
      }
      str2 = (String)((HashMap)localObject8).get("minvercode");
      localObject8 = (String)((HashMap)localObject8).get("backurl");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("appid=");
      localStringBuilder.append(str3);
      localStringBuilder.append(" ,sendtime=");
      localStringBuilder.append(str5);
      localStringBuilder.append(" ,packname=");
      localStringBuilder.append(str4);
      localStringBuilder.append(" ,packetversion=");
      localStringBuilder.append(str8);
      localStringBuilder.append(" ,msgtype=");
      localStringBuilder.append(str6);
      localStringBuilder.append(" ,type=");
      localStringBuilder.append(str9);
      localStringBuilder.append(" ,downUrl=");
      localStringBuilder.append((String)localObject7);
      localStringBuilder.append(" ,nativePage=");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(" ,htmlPage=");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" ,subPageType=");
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append(" ,pageTitles=");
      localStringBuilder.append((String)localObject4);
      localStringBuilder.append(" ,minvercode=");
      localStringBuilder.append(str2);
      localStringBuilder.append(" ,backUrl=");
      localStringBuilder.append((String)localObject8);
      LogUtility.b("AppClient", localStringBuilder.toString());
      i = AppUtil.a(str4);
      j = AppUtil.b(DownloadManager.a().a(str3));
      localObject7 = new Bundle();
      ((Bundle)localObject7).putString("installedVersion", String.valueOf(i));
      ((Bundle)localObject7).putString("localVersion", String.valueOf(j));
      ((Bundle)localObject7).putString("serverApkVersion", str8);
      ((Bundle)localObject7).putString("typeid", str9);
      ((Bundle)localObject7).putString("msgType", str6);
      ((Bundle)localObject7).putString("sendTime", str5);
      ((Bundle)localObject7).putString("subPageType", (String)localObject3);
      ((Bundle)localObject7).putString("pageTitles", (String)localObject4);
      ((Bundle)localObject7).putString("appCustom", str1);
      ((Bundle)localObject7).putString("schemaUrl", paramString1);
      if (!TextUtils.isEmpty(str7))
      {
        ((Bundle)localObject7).putString("via", str7);
        ((Bundle)localObject7).putString("splitvia", str10);
      }
      ((Bundle)localObject7).putString("uin", paramString2);
      paramString1 = str1;
      ((Bundle)localObject7).putString("vkey", paramString3);
      ((Bundle)localObject7).putString(DownloadConstants.b, str3);
      ((Bundle)localObject7).putString(DownloadConstants.jdField_c_of_type_JavaLangString, (String)localObject5);
      ((Bundle)localObject7).putString(DownloadConstants.d, (String)localObject6);
      if (!TextUtils.isEmpty(str4)) {
        ((Bundle)localObject7).putString(DownloadConstants.f, str4);
      }
      ((Bundle)localObject7).putString(DownloadConstants.e, str8);
    }
    try
    {
      localObject3 = CommonDataAdapter.a();
      j = Integer.parseInt(paramString2);
      l = j;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      long l;
      label933:
      break label933;
    }
    try
    {
      ((CommonDataAdapter)localObject3).a(l);
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label933;
    }
    CommonDataAdapter.a().a(paramString3);
    b(paramString4, str6, str3, str7);
    if ("2460".equals(paramString4))
    {
      a(paramString2, paramString3, str3, str5);
      if (i <= 0) {}
    }
    try
    {
      paramString2 = URLDecoder.decode(paramString1, "UTF-8");
      paramString1 = paramString2;
    }
    catch (Exception paramString2)
    {
      label988:
      break label988;
    }
    AppUtil.a(paramActivity, str3, str4, paramString1);
    return;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      a(paramActivity, str3, paramString4, (Bundle)localObject7, "detail", "qapp_center_detail.htm");
      return;
    }
    if (((String)localObject2).equals("tmast"))
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        i = AppUtil.a("com.tencent.android.qqdownloader");
        if ((!TextUtils.isEmpty(str2)) && (i > 0) && (i >= Integer.valueOf(str2).intValue()))
        {
          paramString1 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject1));
          paramString1.setFlags(268435456);
          paramActivity.startActivity(paramString1);
          return;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject8))
        {
          a(paramActivity, str3, paramString4, (Bundle)localObject7, "online", (String)localObject8);
          return;
        }
      }
      return;
    }
    if (((String)localObject2).equals("detail"))
    {
      a(paramActivity, str3, paramString4, (Bundle)localObject7, "detail", "qapp_center_detail.htm");
      return;
    }
    a(paramActivity, str3, paramString4, (Bundle)localObject7, (String)localObject2, (String)localObject1);
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("process_id", 2);
    localBundle.putString("schemaUrl", paramString);
    localBundle.putBoolean("is_can_open_yyb_native", paramBoolean);
    if ((paramContext instanceof Activity))
    {
      a((Activity)paramContext, localBundle);
      return;
    }
    a(null, localBundle);
  }
  
  protected static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("huin", paramString1);
    localBundle.putString("keytype", "256");
    localBundle.putString("keystr", paramString2);
    localBundle.putString("appid", paramString3);
    localBundle.putString("platform", CommonDataAdapter.a().g());
    localBundle.putString("requestkeys", paramString4);
    localBundle.putString("mode", "1");
    localBundle.putString("v", CommonDataAdapter.a().e());
    new HttpCgiAsyncTask("https://appic.qq.com/cgi-bin/appstage/mapp_setrequest.cgi", "GET", null).execute(new Bundle[] { localBundle });
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("packageName");
    String str2 = paramBundle.getString("appId");
    boolean bool = paramBundle.getBoolean("autoDownload");
    paramBundle = paramBundle.getString("big_brother_source_key");
    StaticAnalyz.a("200", "ANDROIDQQ.SHARESOURCE", str2);
    ThreadManager.executeOnSubThread(new AppClient.3(str2, str1, paramBundle, paramActivity, bool));
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    a(paramActivity, paramString1, paramString2, paramString3, "2460");
  }
  
  protected static void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ("2457".equals(paramString1))
    {
      String str;
      if (TextUtils.isEmpty(paramString4)) {
        str = "ANDROIDQQ.PCPUSH.AIOMSG";
      } else {
        str = paramString4;
      }
      StaticAnalyz.a("200", str, paramString3);
    }
    if ("2460".equals(paramString1)) {}
    for (;;)
    {
      try
      {
        paramString1 = StaticAnalyz.a(Integer.parseInt(paramString2));
        if (TextUtils.isEmpty(paramString4))
        {
          StaticAnalyz.a("200", paramString1, paramString3);
          return;
        }
      }
      catch (NumberFormatException paramString1)
      {
        return;
      }
      paramString1 = paramString4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.AppClient
 * JD-Core Version:    0.7.0.1
 */