package com.tencent.mobileqq.mini.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import bfup;
import bhrs;
import bhrt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import nhe;
import nmd;

public class TroopApplicationListUtil
{
  public static final String ACTION_ADD_GROUP_SUCCESS = "com.tencent.mobileqq.addgroupapplication";
  public static final String ADD_TROOP_APPLICATION_API = "app.qun.qq.com/cgi-bin/api/inner_setunifiedapp";
  public static final String CHECK_MINIAPP_IN_TROOP_APPLICATION_LIST = "app.qun.qq.com/cgi-bin/api/inner_checkunifiedapp";
  private static final String CONTENT_TYPE_FORM_URLENCODED = "application/x-www-form-urlencoded";
  public static final int START_TROOP_ACTIVITY_REQUEST_CODE = 1048576;
  public static final int STATUS_CODE_ADDED_TROOP = 44012;
  public static final int STATUS_CODE_EXCEED_MAX_SIZE = 41005;
  public static final int STATUS_CODE_HAS_ADDED = 41012;
  private static final String TAG = "TroopApplicationListUtil";
  public static final int TYPE_ADD = 1001;
  public static final int TYPE_CHECK = 1000;
  public static final String WNS_CGI_PROXY_URL = "https://h5.qzone.qq.com/miniapp/proxy/wnscgi/{api}";
  
  public static void addMiniAppToTroopApplicationList(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString1, String paramString2, String paramString3, TroopApplicationListUtil.JsPluginParam paramJsPluginParam)
  {
    if (!nmd.a(BaseApplicationImpl.getContext()))
    {
      showToast(1000);
      paramBaseJsPluginEngine.callbackJsEventFail(paramJsPluginParam.jsRuntime, paramJsPluginParam.event, null, "network is not available.", paramJsPluginParam.callbackId);
      QLog.e("TroopApplicationListUtil", 1, "addMiniAppToTroopApplicationList, network is not available");
      return;
    }
    paramString3 = buildRequest(paramString1, paramString2, paramString3, 1001);
    paramBaseJsPluginEngine = new TroopApplicationListUtil.4(ThreadManagerV2.getSubThreadLooper(), paramBaseJsPluginEngine, paramJsPluginParam, paramString1, paramString2);
    bhrs.a().a(paramString3, paramBaseJsPluginEngine, getCookie(paramString3.jdField_a_of_type_JavaLangString));
  }
  
  public static void addMiniAppToTroopApplicationList(String paramString1, String paramString2, String paramString3)
  {
    if (!nmd.a(BaseApplicationImpl.getContext()))
    {
      showToast(1000);
      QLog.e("TroopApplicationListUtil", 1, "addMiniAppToTroopApplicationList, network is not available");
      return;
    }
    paramString3 = buildRequest(paramString1, paramString2, paramString3, 1001);
    paramString1 = new TroopApplicationListUtil.3(ThreadManagerV2.getSubThreadLooper(), paramString1, paramString2);
    bhrs.a().a(paramString3, paramString1, getCookie(paramString3.jdField_a_of_type_JavaLangString));
  }
  
  public static void addMiniAppToTroopApplicationList(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    if (!nmd.a(BaseApplicationImpl.getContext()))
    {
      showToast(1000);
      paramAsyncResult.onReceiveResult(false, null);
      QLog.e("TroopApplicationListUtil", 1, "addMiniAppToTroopApplicationList, network is not available");
      return;
    }
    paramString3 = buildRequest(paramString1, paramString2, null, 1001);
    paramString1 = new TroopApplicationListUtil.5(ThreadManagerV2.getSubThreadLooper(), paramAsyncResult, paramString1, paramString2);
    bhrs.a().a(paramString3, paramString1, getCookie(paramString3.jdField_a_of_type_JavaLangString));
  }
  
  private static bhrt buildRequest(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    bhrt localbhrt = new bhrt();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 1000)
    {
      localStringBuilder.append("gc=").append(paramString1).append("&appid=").append(paramString2);
      localbhrt.jdField_a_of_type_JavaLangString = "https://h5.qzone.qq.com/miniapp/proxy/wnscgi/{api}".replace("{api}", "app.qun.qq.com/cgi-bin/api/inner_checkunifiedapp");
    }
    for (;;)
    {
      localStringBuilder.append("&sourcekey=qzone").append("&qqver=").append("8.4.1").append(".").append("4680").append("&platform=2");
      localbhrt.c = "{}";
      localbhrt.jdField_a_of_type_Int = 60000;
      localbhrt.e = "application/x-www-form-urlencoded";
      paramString1 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        paramString1 = "POST";
      }
      localbhrt.b = paramString1;
      localbhrt.jdField_a_of_type_Boolean = false;
      localbhrt.d = localStringBuilder.toString();
      try
      {
        paramInt = getBkn(localbhrt.jdField_a_of_type_JavaLangString);
        if (paramInt != -1)
        {
          if (localbhrt.jdField_a_of_type_JavaLangString.contains("?")) {
            localbhrt.jdField_a_of_type_JavaLangString = (localbhrt.jdField_a_of_type_JavaLangString + "&bkn=" + paramInt);
          }
        }
        else
        {
          return localbhrt;
          localStringBuilder.append("gc=").append(paramString1).append("&append_appid=").append(paramString2).append("&add_type=1").append("&append_source=1");
          localbhrt.jdField_a_of_type_JavaLangString = "https://h5.qzone.qq.com/miniapp/proxy/wnscgi/{api}".replace("{api}", "app.qun.qq.com/cgi-bin/api/inner_setunifiedapp");
          continue;
        }
        localbhrt.jdField_a_of_type_JavaLangString = (localbhrt.jdField_a_of_type_JavaLangString + "?bkn=" + paramInt);
        return localbhrt;
      }
      catch (Throwable paramString1)
      {
        QLog.e("TroopApplicationListUtil", 1, "get bkn fail.", paramString1);
      }
    }
    return localbhrt;
  }
  
  private static int getBkn(String paramString)
  {
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = localTicketManager.getPskey(str1, nhe.a().d(SwiftBrowserCookieMonster.b(paramString)));
    if (!TextUtils.isEmpty(str2)) {}
    for (int i = getGTK(str2);; i = -1)
    {
      int k = i;
      if (i == -1)
      {
        paramString = SwiftBrowserCookieMonster.c(paramString);
        k = i;
        if (!TextUtils.isEmpty(paramString))
        {
          k = i;
          if (paramString.contains("p_skey"))
          {
            paramString = paramString.split(";");
            int m = paramString.length;
            int j = 0;
            for (;;)
            {
              k = i;
              if (j >= m) {
                break;
              }
              str2 = paramString[j];
              k = i;
              if (!TextUtils.isEmpty(str2))
              {
                k = i;
                if (str2.contains("p_skey"))
                {
                  str2 = str2.substring(str2.indexOf("=") + 1, str2.length());
                  k = i;
                  if (!TextUtils.isEmpty(str2)) {
                    k = getGTK(str2);
                  }
                }
              }
              j += 1;
              i = k;
            }
          }
        }
      }
      if (k == -1) {
        return getGTK(localTicketManager.getSkey(str1));
      }
      return k;
    }
  }
  
  public static String getCookie(String paramString)
  {
    return MiniAppUtils.getCookie(paramString);
  }
  
  public static int getGTK(String paramString)
  {
    return MiniAppUtils.getGTK(paramString);
  }
  
  public static void getGroupAppStatus(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString1, String paramString2, TroopApplicationListUtil.JsPluginParam paramJsPluginParam)
  {
    paramString1 = buildRequest(paramString1, paramString2, null, 1000);
    paramBaseJsPluginEngine = new TroopApplicationListUtil.1(ThreadManagerV2.getSubThreadLooper(), paramBaseJsPluginEngine, paramJsPluginParam);
    bhrs.a().a(paramString1, paramBaseJsPluginEngine, getCookie(paramString1.jdField_a_of_type_JavaLangString));
  }
  
  public static void getGroupAppStatus(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    paramString1 = buildRequest(paramString1, paramString2, null, 1000);
    paramString2 = new TroopApplicationListUtil.2(ThreadManagerV2.getSubThreadLooper(), paramAsyncResult);
    bhrs.a().a(paramString1, paramString2, getCookie(paramString1.jdField_a_of_type_JavaLangString));
  }
  
  public static boolean isAdminOrCreated()
  {
    boolean bool = bfup.a();
    QLog.d("TroopApplicationListUtil", 1, "isAdminOrCreated: " + bool);
    return bool;
  }
  
  private static void sendMsgToTroopApplication(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt == 0) || (paramInt == 41012))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.mobileqq.addgroupapplication");
      localIntent.putExtra("groupUin", paramString1);
      localIntent.putExtra("appId", paramString2);
      BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
    }
  }
  
  private static void showToast(int paramInt)
  {
    int i = 0;
    String str;
    if ((paramInt == 0) || (paramInt == 41012))
    {
      str = BaseApplicationImpl.getApplication().getResources().getString(2131693666);
      paramInt = 5;
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new TroopApplicationListUtil.6(paramInt, str));
      return;
      if (paramInt == 41005)
      {
        str = BaseApplicationImpl.getApplication().getResources().getString(2131693671);
        paramInt = i;
      }
      else
      {
        str = BaseApplicationImpl.getApplication().getResources().getString(2131693665);
        paramInt = i;
      }
    }
  }
  
  public static void startTroopActivityAndAddTroopApplication(Activity paramActivity, String paramString, AsyncResult paramAsyncResult)
  {
    QLog.d("TroopApplicationListUtil", 1, "setMiniAppToTroopApplicationList");
    IActivityResultManager localIActivityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
    localIActivityResultManager.addActivityResultListener(new TroopApplicationListUtil.8(localIActivityResultManager, paramString, paramAsyncResult));
    paramString = new Intent(paramActivity, TroopActivity.class);
    paramString.putExtra("onlyOneSegement", true);
    paramString.putExtra("_key_mode", 0);
    paramString.putExtra("key_tab_mode", 0);
    paramString.putExtra("is_select_troop", true);
    paramString.putExtra("key_from", 3);
    paramActivity.startActivityForResult(paramString, 1048576);
  }
  
  public static void startTroopActivityAndAddTroopApplication(BaseJsPluginEngine paramBaseJsPluginEngine, String paramString, TroopApplicationListUtil.JsPluginParam paramJsPluginParam)
  {
    QLog.d("TroopApplicationListUtil", 1, "setMiniAppToTroopApplicationList");
    paramString = new TroopApplicationListUtil.7(paramBaseJsPluginEngine, paramString, paramJsPluginParam);
    MiniAppController.getInstance().setActivityResultListener(paramString);
    paramString = new Intent(paramBaseJsPluginEngine.activityContext, TroopActivity.class);
    paramString.putExtra("onlyOneSegement", true);
    paramString.putExtra("_key_mode", 0);
    paramString.putExtra("key_tab_mode", 0);
    paramString.putExtra("is_select_troop", true);
    paramString.putExtra("key_from", 3);
    paramBaseJsPluginEngine.activityContext.startActivityForResult(paramString, 1048576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.TroopApplicationListUtil
 * JD-Core Version:    0.7.0.1
 */