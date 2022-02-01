package com.tencent.open.downloadnew.common;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;

public class IntentFactory
{
  public static String a = "com.tencent.open.download.start";
  public static ArrayList<String> a;
  public static String b = "com.tencent.open.download.pause";
  public static String c = "com.tencent.open.download.restart";
  public static String d = "com.tencent.open.download.complete";
  public static String e = "com.tencent.open.download.open";
  public static String f = "com.tencent.open.download.yyb";
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(d);
    jdField_a_of_type_JavaUtilArrayList.add(e);
    jdField_a_of_type_JavaUtilArrayList.add(b);
    jdField_a_of_type_JavaUtilArrayList.add(f);
    jdField_a_of_type_JavaUtilArrayList.add(c);
    jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_JavaLangString);
  }
  
  public static PendingIntent a(int paramInt, NoticeParam paramNoticeParam)
  {
    Intent localIntent = new Intent();
    if (paramNoticeParam != null)
    {
      localIntent.putExtra("noticeParam", paramNoticeParam);
      localIntent.putExtra("param_notifyid", AppNotificationManager.a().a(paramNoticeParam.f, paramNoticeParam.b, paramNoticeParam.jdField_a_of_type_JavaLangString));
    }
    paramNoticeParam = Common.r();
    if (!TextUtils.isEmpty(paramNoticeParam)) {
      localIntent.putExtra("processName", paramNoticeParam);
    }
    paramNoticeParam = paramNoticeParam.replace(":", ".");
    StringBuilder localStringBuilder;
    switch (paramInt)
    {
    default: 
      break;
    case 6: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(e);
      localStringBuilder.append(".");
      localStringBuilder.append(paramNoticeParam);
      localIntent.setAction(localStringBuilder.toString());
      break;
    case 5: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(f);
      localStringBuilder.append(".");
      localStringBuilder.append(paramNoticeParam);
      localIntent.setAction(localStringBuilder.toString());
      break;
    case 4: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(d);
      localStringBuilder.append(".");
      localStringBuilder.append(paramNoticeParam);
      localIntent.setAction(localStringBuilder.toString());
      break;
    case 2: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append(".");
      localStringBuilder.append(paramNoticeParam);
      localIntent.setAction(localStringBuilder.toString());
      break;
    case 1: 
    case 3: 
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(".");
      localStringBuilder.append(paramNoticeParam);
      localIntent.setAction(localStringBuilder.toString());
    }
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    return PendingIntent.getBroadcast(CommonDataAdapter.a().a(), (int)(System.currentTimeMillis() & 0xFFFFFFF), localIntent, 134217728);
  }
  
  public static Intent a(Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("adapter_action", "action_push_app_detail");
    localIntent.setClassName("com.tencent.plugin.qappcenter", "com.tencent.open.appcenter.QZoneAppWebViewActivity");
    localIntent.putExtras(paramBundle);
    Object localObject1 = new StringBuffer("sd://qapp_center_detail.htm?");
    Object localObject2 = paramBundle.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      String str = paramBundle.getString((String)localObject3);
      ((StringBuffer)localObject1).append((String)localObject3);
      ((StringBuffer)localObject1).append("=");
      ((StringBuffer)localObject1).append(str);
      ((StringBuffer)localObject1).append("&");
    }
    localObject2 = Common.a(((StringBuffer)localObject1).toString());
    localObject1 = localObject2[0];
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(localObject2[1]);
    localObject2 = ((StringBuilder)localObject3).toString();
    localObject3 = paramBundle.getString("from");
    localIntent.putExtra("uinRestore", CommonDataAdapter.a().a());
    localIntent.putExtra("APP_URL_NOTICE", (String)localObject1);
    if (a((String)localObject3)) {
      localObject1 = a(paramBundle);
    } else {
      localObject1 = localObject2;
    }
    localIntent.putExtra("APP_PARAMS_NOTICE", (String)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("params=");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("\n pushParams=");
    ((StringBuilder)localObject1).append(a(paramBundle));
    LogUtility.b("IntentFactory", ((StringBuilder)localObject1).toString());
    if (paramBundle.containsKey("friendUin"))
    {
      localIntent.putExtra("friendUin", paramBundle.getString("friendUin"));
      localIntent.putExtra("isTroop", paramBundle.getInt("isTroop"));
    }
    localIntent.addFlags(603979776);
    return localIntent;
  }
  
  public static Intent a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (paramString1.length() != 0))
    {
      Object localObject1 = Common.a(paramString1);
      paramString1 = (String)((HashMap)localObject1).get("appid");
      String str1 = (String)((HashMap)localObject1).get("sendtime");
      String str2 = (String)((HashMap)localObject1).get("packname");
      String str3 = (String)((HashMap)localObject1).get("packetversion");
      String str4 = (String)((HashMap)localObject1).get("msgtype");
      String str5 = (String)((HashMap)localObject1).get("type");
      String str6 = (String)((HashMap)localObject1).get("downurl");
      localObject1 = (String)((HashMap)localObject1).get("via");
      String str7 = AppClient.a((String)localObject1);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("appid=");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("&sendtime=");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append("&packname=");
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append("&packetversion=");
      ((StringBuilder)localObject2).append(str3);
      ((StringBuilder)localObject2).append("&msgtype=");
      ((StringBuilder)localObject2).append(str4);
      ((StringBuilder)localObject2).append("&type=");
      ((StringBuilder)localObject2).append(str5);
      ((StringBuilder)localObject2).append("&downUrl=");
      ((StringBuilder)localObject2).append(str6);
      ((StringBuilder)localObject2).append("&via=");
      ((StringBuilder)localObject2).append((String)localObject1);
      LogUtility.b("IntentFactory", ((StringBuilder)localObject2).toString());
      int i = AppUtil.a(str2);
      int j = AppUtil.b(DownloadManager.a().a(paramString1));
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("id", paramString1);
      ((Bundle)localObject2).putString("from", "2458");
      ((Bundle)localObject2).putString("downloadUrl", str6);
      ((Bundle)localObject2).putString("packageName", str2);
      ((Bundle)localObject2).putString("installedVersion", String.valueOf(i));
      ((Bundle)localObject2).putString("localVersion", String.valueOf(j));
      ((Bundle)localObject2).putString("serverApkVersion", str3);
      ((Bundle)localObject2).putString("typeid", str5);
      ((Bundle)localObject2).putString("msgType", str4);
      ((Bundle)localObject2).putString("sendTime", str1);
      ((Bundle)localObject2).putString("via", (String)localObject1);
      ((Bundle)localObject2).putString("splitvia", str7);
      ((Bundle)localObject2).putString("friendUin", paramString2);
      ((Bundle)localObject2).putInt("isTroop", paramInt);
      return a((Bundle)localObject2);
    }
    return null;
  }
  
  protected static String a(Bundle paramBundle)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected static boolean a(String paramString)
  {
    return ("2457".equals(paramString)) || ("2458".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.IntentFactory
 * JD-Core Version:    0.7.0.1
 */