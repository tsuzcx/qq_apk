package com.tencent.mobileqq.mini.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.webso.WebSoCgiService;
import com.tencent.mobileqq.webview.webso.WebSoCgiService.CgiReqInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class TroopApplicationListUtil
{
  public static final String ACTION_ADD_GROUP_SUCCESS = "com.tencent.mobileqq.addgroupapplication";
  public static final String ADD_TROOP_APPLICATION_API = "app.qun.qq.com/cgi-bin/api/inner_setunifiedapp";
  public static final String CHECK_MINIAPP_IN_TROOP_APPLICATION_LIST = "app.qun.qq.com/cgi-bin/api/inner_checkunifiedapp";
  private static final String CONTENT_TYPE_FORM_URLENCODED = "application/x-www-form-urlencoded";
  public static final int START_TROOP_ACTIVITY_REQUEST_CODE = 107;
  public static final int STATUS_CODE_ADDED_TROOP = 44012;
  public static final int STATUS_CODE_EXCEED_MAX_SIZE = 41005;
  public static final int STATUS_CODE_HAS_ADDED = 41012;
  public static final int STATUS_CODE_NOT_GROUP_ADMINISTRATOR = 44004;
  public static final int STATUS_CODE_NOT_GROUP_MANAGER = 41004;
  private static final String TAG = "TroopApplicationListUtil";
  public static final int TYPE_ADD = 1001;
  public static final int TYPE_CHECK = 1000;
  public static final String WNS_CGI_PROXY_URL = "https://h5.qzone.qq.com/miniapp/proxy/wnscgi/{api}";
  
  public static void addMiniAppToTroopApplicationList(String paramString1, String paramString2, String paramString3)
  {
    if (!NetworkUtil.a(BaseApplicationImpl.getContext()))
    {
      showToast(1000);
      QLog.e("TroopApplicationListUtil", 1, "addMiniAppToTroopApplicationList, network is not available");
      return;
    }
    paramString3 = buildRequest(paramString1, paramString2, paramString3, 1001);
    paramString1 = new TroopApplicationListUtil.2(ThreadManagerV2.getSubThreadLooper(), paramString1, paramString2);
    WebSoCgiService.a().a(paramString3, paramString1, getCookie(paramString3.a));
  }
  
  public static void addMiniAppToTroopApplicationList(String paramString1, String paramString2, String paramString3, AsyncResult paramAsyncResult)
  {
    if (!NetworkUtil.a(BaseApplicationImpl.getContext()))
    {
      showToast(1000);
      paramAsyncResult.onReceiveResult(false, null);
      QLog.e("TroopApplicationListUtil", 1, "addMiniAppToTroopApplicationList, network is not available");
      return;
    }
    paramString3 = buildRequest(paramString1, paramString2, null, 1001);
    paramString1 = new TroopApplicationListUtil.3(ThreadManagerV2.getSubThreadLooper(), paramAsyncResult, paramString1, paramString2);
    WebSoCgiService.a().a(paramString3, paramString1, getCookie(paramString3.a));
  }
  
  private static WebSoCgiService.CgiReqInfo buildRequest(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    WebSoCgiService.CgiReqInfo localCgiReqInfo = new WebSoCgiService.CgiReqInfo();
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt == 1000)
    {
      localStringBuilder.append("gc=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("&appid=");
      localStringBuilder.append(paramString2);
      localCgiReqInfo.a = "https://h5.qzone.qq.com/miniapp/proxy/wnscgi/{api}".replace("{api}", "app.qun.qq.com/cgi-bin/api/inner_checkunifiedapp");
    }
    else
    {
      localStringBuilder.append("gc=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("&append_appid=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("&add_type=1");
      localStringBuilder.append("&append_source=1");
      localCgiReqInfo.a = "https://h5.qzone.qq.com/miniapp/proxy/wnscgi/{api}".replace("{api}", "app.qun.qq.com/cgi-bin/api/inner_setunifiedapp");
    }
    localStringBuilder.append("&sourcekey=qzone");
    localStringBuilder.append("&qqver=");
    localStringBuilder.append("8.8.17");
    localStringBuilder.append(".");
    localStringBuilder.append("5770");
    localStringBuilder.append("&platform=2");
    localCgiReqInfo.c = "{}";
    localCgiReqInfo.h = 60000;
    localCgiReqInfo.e = "application/x-www-form-urlencoded";
    paramString1 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString1 = "POST";
    }
    localCgiReqInfo.b = paramString1;
    localCgiReqInfo.g = false;
    localCgiReqInfo.d = localStringBuilder.toString();
    try
    {
      paramInt = getBkn(localCgiReqInfo.a);
      if (paramInt != -1)
      {
        if (localCgiReqInfo.a.contains("?"))
        {
          paramString1 = new StringBuilder();
          paramString1.append(localCgiReqInfo.a);
          paramString1.append("&bkn=");
          paramString1.append(paramInt);
          localCgiReqInfo.a = paramString1.toString();
          return localCgiReqInfo;
        }
        paramString1 = new StringBuilder();
        paramString1.append(localCgiReqInfo.a);
        paramString1.append("?bkn=");
        paramString1.append(paramInt);
        localCgiReqInfo.a = paramString1.toString();
        return localCgiReqInfo;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("TroopApplicationListUtil", 1, "get bkn fail.", paramString1);
    }
    return localCgiReqInfo;
  }
  
  private static int getBkn(String paramString)
  {
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    String str1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str2 = localTicketManager.getPskey(str1, AuthorizeConfig.a().e(SwiftBrowserCookieMonster.b(paramString)));
    if (!TextUtils.isEmpty(str2)) {
      i = getGTK(str2);
    } else {
      i = -1;
    }
    int j = i;
    if (i == -1)
    {
      paramString = SwiftBrowserCookieMonster.d(paramString);
      j = i;
      if (!TextUtils.isEmpty(paramString))
      {
        j = i;
        if (paramString.contains("p_skey"))
        {
          paramString = paramString.split(";");
          int m = paramString.length;
          int k = 0;
          for (;;)
          {
            j = i;
            if (k >= m) {
              break;
            }
            str2 = paramString[k];
            j = i;
            if (!TextUtils.isEmpty(str2))
            {
              j = i;
              if (str2.contains("p_skey"))
              {
                str2 = str2.substring(str2.indexOf("=") + 1, str2.length());
                j = i;
                if (!TextUtils.isEmpty(str2)) {
                  j = getGTK(str2);
                }
              }
            }
            k += 1;
            i = j;
          }
        }
      }
    }
    int i = j;
    if (j == -1) {
      i = getGTK(localTicketManager.getSkey(str1));
    }
    return i;
  }
  
  public static String getCookie(String paramString)
  {
    return MiniAppUtils.getCookie(paramString);
  }
  
  public static int getGTK(String paramString)
  {
    return MiniAppUtils.getGTK(paramString);
  }
  
  public static void getGroupAppStatus(String paramString1, String paramString2, AsyncResult paramAsyncResult)
  {
    paramString1 = buildRequest(paramString1, paramString2, null, 1000);
    paramString2 = new TroopApplicationListUtil.1(ThreadManagerV2.getSubThreadLooper(), paramAsyncResult);
    WebSoCgiService.a().a(paramString1, paramString2, getCookie(paramString1.a));
  }
  
  public static boolean isAdminOrCreated()
  {
    boolean bool = TroopUtils.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isAdminOrCreated: ");
    localStringBuilder.append(bool);
    QLog.d("TroopApplicationListUtil", 1, localStringBuilder.toString());
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
  
  public static void showToast(int paramInt)
  {
    int i = 0;
    String str;
    if ((paramInt != 0) && (paramInt != 41012))
    {
      if (paramInt == 41005)
      {
        str = BaseApplicationImpl.getApplication().getResources().getString(2131891749);
        paramInt = i;
      }
      else if (paramInt == 41004)
      {
        str = BaseApplicationImpl.getApplication().getResources().getString(2131891764);
        paramInt = i;
      }
      else
      {
        str = BaseApplicationImpl.getApplication().getResources().getString(2131891741);
        paramInt = i;
      }
    }
    else
    {
      str = BaseApplicationImpl.getApplication().getResources().getString(2131891742);
      paramInt = 5;
    }
    ThreadManager.getUIHandler().post(new TroopApplicationListUtil.4(paramInt, str));
  }
  
  public static void startTroopActivityAndAddTroopApplication(Activity paramActivity, String paramString, AsyncResult paramAsyncResult)
  {
    QLog.d("TroopApplicationListUtil", 1, "setMiniAppToTroopApplicationList");
    IActivityResultManager localIActivityResultManager = AppLoaderFactory.g().getMiniAppEnv().getActivityResultManager();
    localIActivityResultManager.addActivityResultListener(new TroopApplicationListUtil.5(localIActivityResultManager, paramString, paramAsyncResult));
    paramString = new Intent(paramActivity, TroopActivity.class);
    paramString.putExtra("onlyOneSegement", true);
    paramString.putExtra("_key_mode", 0);
    paramString.putExtra("key_tab_mode", 0);
    paramString.putExtra("is_select_troop", true);
    paramString.putExtra("key_from", 3);
    paramActivity.startActivityForResult(paramString, 107);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.TroopApplicationListUtil
 * JD-Core Version:    0.7.0.1
 */