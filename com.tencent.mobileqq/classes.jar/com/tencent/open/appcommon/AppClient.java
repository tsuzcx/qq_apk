package com.tencent.open.appcommon;

import aknq;
import aknr;
import akns;
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
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class AppClient
{
  public static Class a(String paramString)
  {
    try
    {
      Class.forName("com.tencent.open.appcenter.QZoneAppWebViewActivity");
      if (paramString.equals("detail")) {
        return QZoneAppListActivity.class;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      if (paramString.equals("index")) {
        return QZoneAppListActivity.class;
      }
      if (!paramString.equals("online")) {}
    }
    return QZoneAppListActivity.class;
  }
  
  protected static String a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    LogUtility.c("AppClient", "getFeedsChannelId >>> qzoneAppid = " + paramInt1 + "| " + paramInt2 + " | " + paramInt3);
    if (paramInt1 == 352) {}
    switch (paramInt2)
    {
    case 4: 
    case 5: 
    case 6: 
    default: 
      return "";
    case 1: 
    case 3: 
      return "100_1";
    case 7: 
    case 8: 
      if ((paramInt3 == 0) || (paramInt3 == 2)) {
        return "200_1";
      }
      if (paramInt3 == 1) {
        return "200_2";
      }
      break;
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split("\\.");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 2;
    if ((paramString != null) && (paramString.length > 2))
    {
      if (i < paramString.length)
      {
        if (i == paramString.length - 1) {
          localStringBuilder.append(paramString[i]);
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append(paramString[i] + ".");
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    Common.a();
    int i = paramBundle.getInt("qzoneAppid");
    int j = paramBundle.getInt("qzoneSubId");
    int k = paramBundle.getInt("op_type");
    int m = paramBundle.getInt("from");
    boolean bool = paramBundle.getBoolean("is_can_open_yyb_native", true);
    paramActivity = paramBundle.getString("schemaUrl");
    Object localObject2;
    if ((!TextUtils.isEmpty(paramActivity)) && (paramActivity.contains("&")))
    {
      localObject6 = new Bundle();
      if (paramActivity.startsWith("http://")) {}
      String str3;
      String str2;
      for (;;)
      {
        try
        {
          localObject2 = new URL(paramActivity).getQuery();
          HashMap localHashMap = Common.a((String)localObject2);
          str1 = (String)localHashMap.get("appid");
          if (TextUtils.isEmpty(str1))
          {
            str1 = (String)localHashMap.get(DownloadConstants.a);
            localObject4 = (String)localHashMap.get(DownloadConstants.jdField_b_of_type_JavaLangString);
            if (!TextUtils.isEmpty((CharSequence)localObject4)) {
              break label416;
            }
            localObject4 = (String)localHashMap.get("ta");
            localObject5 = (String)localHashMap.get(DownloadConstants.c);
            if (!TextUtils.isEmpty((CharSequence)localObject5)) {
              break label419;
            }
            localObject5 = (String)localHashMap.get("tk");
            str3 = (String)localHashMap.get(DownloadConstants.d);
            str2 = (String)localHashMap.get("via");
            localObject3 = (String)localHashMap.get("packName");
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              break label422;
            }
            localObject3 = (String)localHashMap.get(DownloadConstants.e);
            paramActivity = (String)localHashMap.get(DownloadConstants.A);
            LogUtility.d("AppClient", " feedChannel:" + paramActivity + "   schemaUrl:" + (String)localObject2);
            if ((!TextUtils.isEmpty(paramActivity)) && (!paramActivity.startsWith("0;"))) {
              break label425;
            }
            paramActivity = "";
            LogUtility.d("AppClient", " finalFeedChannel:" + paramActivity);
            if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!AppUtil.a((String)localObject3))) {
              break;
            }
            paramActivity = (String)localHashMap.get("appCustom");
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          String str1;
          localMalformedURLException.printStackTrace();
        }
        try
        {
          paramBundle = URLDecoder.decode(paramActivity, "UTF-8");
          paramActivity = paramBundle;
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            CharSequence localCharSequence;
            Object localObject1;
            break;
          }
        }
        AppUtil.a(CommonDataAdapter.a().a(), str1, (String)localObject3, paramActivity);
        return;
        localObject2 = paramActivity;
        continue;
        continue;
        label416:
        continue;
        label419:
        continue;
        label422:
        continue;
        label425:
        paramActivity = paramActivity.split(";");
        if (paramActivity == null)
        {
          paramActivity = "";
        }
        else if (paramActivity.length <= 0)
        {
          paramActivity = "";
        }
        else
        {
          localCharSequence = paramActivity[0];
          if (!TextUtils.isEmpty(localCharSequence))
          {
            paramActivity = localCharSequence;
            if (!localCharSequence.equals("0")) {}
          }
          else
          {
            paramActivity = "";
          }
        }
      }
      ((Bundle)localObject6).putString(DownloadConstants.a, localMalformedURLException);
      ((Bundle)localObject6).putString(DownloadConstants.jdField_b_of_type_JavaLangString, (String)localObject4);
      ((Bundle)localObject6).putString(DownloadConstants.c, (String)localObject5);
      ((Bundle)localObject6).putString(DownloadConstants.d, str3);
      ((Bundle)localObject6).putString(DownloadConstants.e, (String)localObject3);
      ((Bundle)localObject6).putString(DownloadConstants.h, str2);
      ((Bundle)localObject6).putString(DownloadConstants.A, paramActivity);
      ((Bundle)localObject6).putString("schemaUrl", (String)localObject2);
      paramActivity = (Activity)localObject6;
      localObject5 = str3;
      localObject4 = localObject3;
      localObject3 = paramActivity;
      paramActivity = str2;
      if (k != 7) {
        break label730;
      }
      localObject6 = a(i, j, m, localMalformedURLException);
      if (!TextUtils.isEmpty(paramActivity)) {
        break label1223;
      }
      paramActivity = StaticAnalyz.a(i, j, m);
      OpenSdkStatic.a().a(String.valueOf(CommonDataAdapter.a().a()), localMalformedURLException, paramActivity, "200", false);
    }
    label730:
    for (paramActivity = (Activity)localObject6;; paramActivity = "2410")
    {
      if ((TextUtils.isEmpty((CharSequence)localObject5)) || (TextUtils.isEmpty((CharSequence)localObject4)) || ("0".equals(localObject5)) || (localObject3 == null) || (!MyAppApi.a().c()) || (!bool)) {
        break label737;
      }
      ThreadManager.getSubThreadHandler().post(new aknr(paramBundle, (Bundle)localObject3, localMalformedURLException, (String)localObject2, paramActivity));
      return;
      localObject3 = null;
      localObject4 = null;
      localObject5 = "0";
      localObject6 = null;
      localObject1 = paramActivity;
      localObject2 = paramActivity;
      paramActivity = (Activity)localObject6;
      break;
    }
    label737:
    Object localObject3 = Common.g() + File.separator + "qapp_center_detail.htm";
    Object localObject4 = new File((String)localObject3);
    if (!((File)localObject4).exists())
    {
      LogUtility.d("AppClient", "file" + (String)localObject3 + " not exist copyassets.");
      FileUtils.a("Page/system", Common.h());
    }
    Object localObject5 = new Intent();
    Object localObject6 = new Bundle();
    if (((File)localObject4).exists())
    {
      localObject3 = "file:///" + (String)localObject3;
      localObject4 = "&from=-10&id=" + (String)localObject1 + "&channelId=" + paramActivity;
      paramActivity = (Activity)localObject4;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        if (!((String)localObject2).equals(localObject1)) {
          break label1185;
        }
        paramActivity = (Activity)localObject4;
      }
      label933:
      if (Common.a(paramBundle.getString("schemaUrl")).get("auto_download") == null) {
        break label1214;
      }
    }
    label1185:
    label1214:
    for (i = 1;; i = 0)
    {
      localObject1 = paramActivity;
      if (i != 0)
      {
        localObject1 = paramActivity;
        if (!paramActivity.contains("auto_download")) {
          localObject1 = paramActivity + "&auto_download=1";
        }
      }
      ((Intent)localObject5).setClass(CommonDataAdapter.a().a(), QZoneAppListActivity.class);
      ((Bundle)localObject6).putString("APP_URL", (String)localObject3);
      ((Bundle)localObject6).putBoolean("FROM_FEED", true);
      ((Bundle)localObject6).putString("APP_PARAMS", (String)localObject1);
      ((Bundle)localObject6).putInt("goto_type", 2);
      if (paramBundle.getInt("process_id") == 2) {
        ((Bundle)localObject6).putInt("process_id", 2);
      }
      LogUtility.b("Jie", "APP_URL:" + (String)localObject3 + " |  PARAMS >>> " + ((Bundle)localObject6).getString("APP_PARAMS"));
      ((Intent)localObject5).putExtras((Bundle)localObject6);
      ((Intent)localObject5).putExtra("adapter_action", "action_app_detail");
      ((Intent)localObject5).addFlags(872415232);
      CommonDataAdapter.a().a().startActivity((Intent)localObject5);
      return;
      localObject3 = Common.m() + File.separator + "qapp_center_detail.htm";
      break;
      paramActivity = (String)localObject4 + "&" + (String)localObject2;
      break label933;
    }
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
    String str1 = Common.g() + File.separator + "qapp_center_detail.htm";
    Common.a();
    Object localObject = new File(str1);
    if (!((File)localObject).exists())
    {
      LogUtility.d("AppClient", "file" + str1 + " not exist copyassets.");
      FileUtils.a("Page/system", Common.h());
    }
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    String str2;
    if (((File)localObject).exists())
    {
      str2 = "file:///" + str1;
      localIntent.setClass(CommonDataAdapter.a().a(), QZoneAppListActivity.class);
      localBundle.putInt("goto_type", 3);
      str1 = "&from=-10&id=" + paramString + "&channelId=" + paramInt;
      paramString = null;
      if (paramBundle != null) {
        paramString = paramBundle.getString("via");
      }
      if (!TextUtils.isEmpty(paramString)) {
        break label546;
      }
    }
    for (;;)
    {
      int i = 0;
      paramString = str1;
      if (paramBundle != null)
      {
        boolean bool = paramBundle.getBoolean("autoDownload");
        paramString = paramBundle.getString("packageName");
        localObject = str1;
        if (!TextUtils.isEmpty(paramString)) {
          localObject = str1 + "&packageName=" + paramString;
        }
        str1 = paramBundle.getString("subpagetype");
        paramString = (String)localObject;
        i = bool;
        if (!TextUtils.isEmpty(str1))
        {
          paramString = (String)localObject + "&subpagetype=" + str1;
          i = bool;
        }
      }
      str1 = paramString;
      if (i != 0) {
        str1 = paramString + "&msgType=56";
      }
      localBundle.putString("APP_PARAMS", str1);
      if (paramBundle != null)
      {
        localBundle.putString("uin", paramBundle.getString("uin"));
        localBundle.putString("sid", paramBundle.getString("vkey"));
      }
      localBundle.putString("APP_URL", str2);
      localBundle.putBoolean("FROM_FEED", true);
      LogUtility.b("Jie", "APP_URL:" + str2 + " |  PARAMS >>> " + localBundle.getString("APP_PARAMS"));
      localIntent.putExtras(localBundle);
      localIntent.putExtra("adapter_action", "action_app_detail");
      localIntent.addFlags(603979776);
      paramActivity.startActivityForResult(localIntent, 200);
      return;
      str2 = Common.m() + File.separator + "qapp_center_detail.htm";
      break;
      label546:
      str1 = str1 + "&via=" + paramString;
    }
  }
  
  protected static void a(Activity paramActivity, String paramString1, String paramString2, Bundle paramBundle, String paramString3, String paramString4)
  {
    Common.a();
    int i = 1;
    Object localObject;
    if (!paramString3.equals("online"))
    {
      paramString4 = Common.g() + File.separator + paramString4;
      localObject = new File(paramString4);
      if (!((File)localObject).exists())
      {
        LogUtility.d("AppClient", "file" + paramString4 + " not exist copyassets.");
        FileUtils.a("Page/system", Common.h());
      }
      if (((File)localObject).exists()) {
        paramString4 = "file:///" + paramString4;
      }
    }
    Intent localIntent;
    Bundle localBundle;
    String str1;
    for (;;)
    {
      localIntent = new Intent();
      localBundle = new Bundle();
      Class localClass = a(paramString3);
      localIntent.setClass(paramActivity, localClass);
      String str5 = paramBundle.getString("installedVersion");
      String str6 = paramBundle.getString("localVersion");
      String str7 = paramBundle.getString("typeid");
      String str8 = paramBundle.getString("serverApkVersion");
      String str9 = paramBundle.getString("msgType");
      String str10 = paramBundle.getString("sendTime");
      str1 = paramBundle.getString("via");
      String str3 = paramBundle.getString("splitvia");
      String str4 = paramBundle.getString("subPageType");
      String str2 = paramBundle.getString("appCustom");
      localObject = paramString2;
      if (paramString2 == "2460") {
        localObject = paramString2 + "_" + str9;
      }
      paramString2 = "&from=-10&id=" + paramString1 + "&channelId=" + (String)localObject + "&installedVersion=" + str5 + "&localVersion=" + str6 + "&serverApkVersion=" + str8 + "&typeId=" + str7 + "&msgType=" + str9 + "&sendTime=" + str10;
      str5 = paramBundle.getString("schemaUrl");
      if (TextUtils.isEmpty(str4))
      {
        label409:
        if (!TextUtils.isEmpty(str1)) {
          break label967;
        }
        label417:
        if (!TextUtils.isEmpty(str3)) {
          break label996;
        }
        label425:
        if (!TextUtils.isEmpty(str2)) {
          break label1025;
        }
        label433:
        if (!TextUtils.isEmpty(str5)) {
          break label1054;
        }
        label441:
        localBundle.putString("APP_PARAMS", paramString2);
        localBundle.putString("uin", paramBundle.getString("uin"));
        localBundle.putString("sid", paramBundle.getString("vkey"));
        localBundle.putString("APP_URL", paramString4);
        localBundle.putBoolean("FROM_FEED", true);
        localBundle.putString(DownloadConstants.h, str1);
        if (!"detail".equals(paramString3)) {
          break label1082;
        }
        localBundle.putInt("goto_type", 2);
        label528:
        if ((!paramString3.equals("custom")) || (i == 0)) {}
      }
      try
      {
        paramString2 = paramBundle.getString("pageTitles");
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString2 = new ArrayList(Arrays.asList(paramString2.split("&")));
          localBundle.putStringArrayList("titleName", paramString2);
          if (paramString2.size() > 0)
          {
            bool = true;
            localBundle.putBoolean("showTitle", bool);
            LogUtility.b("AppClient", "titles = " + paramString2);
          }
        }
        else
        {
          LogUtility.b("TAG", "APP_URL:" + paramString4 + " |  PARAMS >>> " + localBundle.getString("APP_PARAMS"));
          localIntent.putExtras(localBundle);
          localIntent.putExtra("adapter_action", "action_app_detail");
          localIntent.addFlags(603979776);
        }
      }
      catch (Exception paramString2)
      {
        try
        {
          for (;;)
          {
            paramString2 = Class.forName("com.tencent.open.appcenter.QZoneAppWebViewActivity");
            if ((paramString2 == null) || (!localClass.getName().equals(paramString2.getName()))) {
              break label1167;
            }
            if (!((String)localObject).equals("2457")) {
              break label1143;
            }
            paramString1 = DownloadManager.a().a(paramString1);
            if ((!MyAppApi.a().c()) || (paramString1 == null) || (paramString1.c != 1)) {
              break label1133;
            }
            LogUtility.d("AppClient", ">>>appid=" + paramString1.jdField_b_of_type_JavaLangString + " myAppid=" + paramString1.i);
            localBundle.putString(DownloadConstants.a, paramString1.jdField_b_of_type_JavaLangString);
            localBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, paramString1.i);
            localBundle.putString(DownloadConstants.c, paramString1.j);
            localBundle.putString(DownloadConstants.h, str1);
            localBundle.putString(DownloadConstants.e, paramString1.d);
            localBundle.putInt(DownloadConstants.d, paramString1.jdField_b_of_type_Int);
            MyAppApi.a().a(paramActivity, localBundle, ((String)localObject).equals("2457"), true);
            return;
            i = 0;
            paramString4 = Common.m() + File.separator + "qapp_center_detail.htm";
            break;
            break;
            paramString2 = paramString2 + "&subPageType=" + str4;
            break label409;
            label967:
            paramString2 = paramString2 + "&via=" + str1;
            break label417;
            label996:
            paramString2 = paramString2 + "&splitVia=" + str3;
            break label425;
            label1025:
            paramString2 = paramString2 + "&appCustom=" + str2;
            break label433;
            label1054:
            paramString2 = paramString2 + "&" + str5;
            break label441;
            label1082:
            if (!"index".equals(paramString3)) {
              break label528;
            }
            localBundle.putInt("goto_type", 1);
            break label528;
            boolean bool = false;
          }
          paramString2 = paramString2;
          LogUtility.c("AppClient", "get push title error>>>", paramString2);
        }
        catch (Exception paramString2)
        {
          for (;;)
          {
            paramString2.printStackTrace();
            paramString2 = null;
          }
          label1133:
          paramActivity.startActivityForResult(localIntent, 200);
          return;
        }
      }
    }
    label1143:
    ThreadManager.getSubThreadHandler().post(new aknq(paramString1, localBundle, str1, paramActivity, localIntent, paramBundle));
    return;
    label1167:
    paramActivity.startActivityForResult(localIntent, 200);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    a(paramActivity, paramString1, paramString2, paramString3, "2457");
  }
  
  protected static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    LogUtility.b("AppClient", "shcemaUrlAnd:" + paramString1);
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    for (;;)
    {
      return;
      Object localObject2 = Common.a(paramString1);
      String str8 = (String)((HashMap)localObject2).get("appid");
      String str10 = (String)((HashMap)localObject2).get("sendtime");
      String str9 = (String)((HashMap)localObject2).get("packname");
      String str13 = (String)((HashMap)localObject2).get("packetversion");
      String str11 = (String)((HashMap)localObject2).get("msgtype");
      String str14 = (String)((HashMap)localObject2).get("type");
      Object localObject1 = (String)((HashMap)localObject2).get("downurl");
      String str12 = (String)((HashMap)localObject2).get("via");
      String str15 = a(str12);
      String str7 = (String)((HashMap)localObject2).get("appCustom");
      String str2 = (String)((HashMap)localObject2).get("nativepage");
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = (String)((HashMap)localObject2).get("np");
      }
      str2 = (String)((HashMap)localObject2).get("htmlpage");
      label236:
      label370:
      String str16;
      label270:
      label304:
      label337:
      int i;
      if (TextUtils.isEmpty(str2))
      {
        str2 = (String)((HashMap)localObject2).get("hp");
        String str3 = (String)((HashMap)localObject2).get("subpagetype");
        if (!TextUtils.isEmpty(str3)) {
          break label864;
        }
        str3 = (String)((HashMap)localObject2).get("sp");
        String str4 = (String)((HashMap)localObject2).get("pagetitles");
        if (!TextUtils.isEmpty(str4)) {
          break label867;
        }
        str4 = (String)((HashMap)localObject2).get("pt");
        String str5 = (String)((HashMap)localObject2).get(DownloadConstants.jdField_b_of_type_JavaLangString);
        if (!TextUtils.isEmpty(str5)) {
          break label870;
        }
        str5 = (String)((HashMap)localObject2).get("ta");
        String str6 = (String)((HashMap)localObject2).get(DownloadConstants.c);
        if (!TextUtils.isEmpty(str6)) {
          break label873;
        }
        str6 = (String)((HashMap)localObject2).get("tk");
        str16 = (String)((HashMap)localObject2).get("minvercode");
        localObject2 = (String)((HashMap)localObject2).get("backurl");
        LogUtility.b("AppClient", "appid=" + str8 + " ,sendtime=" + str10 + " ,packname=" + str9 + " ,packetversion=" + str13 + " ,msgtype=" + str11 + " ,type=" + str14 + " ,downUrl=" + (String)localObject1 + " ,nativePage=" + str1 + " ,htmlPage=" + str2 + " ,subPageType=" + str3 + " ,pageTitles=" + str4 + " ,minvercode=" + str16 + " ,backUrl=" + (String)localObject2);
        i = AppUtil.a(str9);
        int j = AppUtil.b(DownloadManager.a().a(str8));
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("installedVersion", String.valueOf(i));
        ((Bundle)localObject1).putString("localVersion", String.valueOf(j));
        ((Bundle)localObject1).putString("serverApkVersion", str13);
        ((Bundle)localObject1).putString("typeid", str14);
        ((Bundle)localObject1).putString("msgType", str11);
        ((Bundle)localObject1).putString("sendTime", str10);
        ((Bundle)localObject1).putString("subPageType", str3);
        ((Bundle)localObject1).putString("pageTitles", str4);
        ((Bundle)localObject1).putString("appCustom", str7);
        ((Bundle)localObject1).putString("schemaUrl", paramString1);
        if (!TextUtils.isEmpty(str12))
        {
          ((Bundle)localObject1).putString("via", str12);
          ((Bundle)localObject1).putString("splitvia", str15);
        }
        ((Bundle)localObject1).putString("uin", paramString2);
        ((Bundle)localObject1).putString("vkey", paramString3);
        ((Bundle)localObject1).putString(DownloadConstants.a, str8);
        ((Bundle)localObject1).putString(DownloadConstants.jdField_b_of_type_JavaLangString, str5);
        ((Bundle)localObject1).putString(DownloadConstants.c, str6);
        if (!TextUtils.isEmpty(str9)) {
          ((Bundle)localObject1).putString(DownloadConstants.e, str9);
        }
        ((Bundle)localObject1).putString(DownloadConstants.d, str13);
      }
      try
      {
        CommonDataAdapter.a().a(Integer.parseInt(paramString2));
        label800:
        CommonDataAdapter.a().a(paramString3);
        b(paramString4, str11, str8, str12);
        if ("2460".equals(paramString4))
        {
          a(paramString2, paramString3, str8, str10);
          if (i <= 0) {}
        }
        try
        {
          paramString1 = URLDecoder.decode(str7, "UTF-8");
          AppUtil.a(paramActivity, str8, str9, paramString1);
          return;
          break label236;
          label864:
          break label270;
          label867:
          break label304;
          label870:
          break label337;
          label873:
          break label370;
          if (TextUtils.isEmpty(str1))
          {
            a(paramActivity, str8, paramString4, (Bundle)localObject1, "detail", "qapp_center_detail.htm");
            return;
          }
          if (str1.equals("tmast"))
          {
            if (TextUtils.isEmpty(str2)) {
              continue;
            }
            i = AppUtil.a("com.tencent.android.qqdownloader");
            if ((!TextUtils.isEmpty(str16)) && (i > 0) && (i >= Integer.valueOf(str16).intValue()))
            {
              paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(str2));
              paramString1.setFlags(268435456);
              paramActivity.startActivity(paramString1);
              return;
            }
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              continue;
            }
            a(paramActivity, str8, paramString4, (Bundle)localObject1, "online", (String)localObject2);
            return;
          }
          if (str1.equals("detail"))
          {
            a(paramActivity, str8, paramString4, (Bundle)localObject1, "detail", "qapp_center_detail.htm");
            return;
          }
          a(paramActivity, str8, paramString4, (Bundle)localObject1, str1, str2);
          return;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1 = str7;
          }
        }
      }
      catch (NumberFormatException paramString1)
      {
        break label800;
      }
    }
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
    new HttpCgiAsyncTask("http://appic.qq.com/cgi-bin/appstage/mapp_setrequest.cgi", "GET", null).execute(new Bundle[] { localBundle });
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("packageName");
    String str2 = paramBundle.getString("appId");
    boolean bool = paramBundle.getBoolean("autoDownload");
    StaticAnalyz.a("200", "ANDROIDQQ.SHARESOURCE", str2);
    ThreadManager.executeOnSubThread(new akns(str2, str1, paramActivity, bool));
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    a(paramActivity, paramString1, paramString2, paramString3, "2460");
  }
  
  protected static void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ("2457".equals(paramString1)) {
      if (!TextUtils.isEmpty(paramString4)) {
        break label67;
      }
    }
    for (String str = "ANDROIDQQ.PCPUSH.AIOMSG";; str = paramString4)
    {
      StaticAnalyz.a("200", str, paramString3);
      if ("2460".equals(paramString1)) {}
      label67:
      try
      {
        paramString2 = StaticAnalyz.a(Integer.parseInt(paramString2));
        paramString1 = paramString4;
        if (TextUtils.isEmpty(paramString4)) {
          paramString1 = paramString2;
        }
        StaticAnalyz.a("200", paramString1, paramString3);
        return;
      }
      catch (NumberFormatException paramString1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.appcommon.AppClient
 * JD-Core Version:    0.7.0.1
 */