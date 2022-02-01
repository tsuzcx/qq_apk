package com.tencent.qqmini.sdk.auth;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppMode;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.SecondApiRightInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AuthFilterList
{
  private static final String CONFIG_SPLIT = ",";
  public static final int EVENT_BLACK = 0;
  public static final int EVENT_WHITE = 1;
  public static final int SECONDARY_API_BLACK = -1;
  public static final int SECONDARY_API_WHITE = 1;
  private static final String TAG = "AuthFilterList";
  private static List<String> sAppWhiteList = new ArrayList();
  private static String sCurAppWhiteListConfig;
  private static List<String> sEventLocalBlackList = new ArrayList();
  private static Map<String, Map<String, Integer>> sEventLocalSecondaryApiMap;
  private static Map<String, Integer> sEventRemoteList = new HashMap();
  private static HashMap<String, HashMap<String, Integer>> sEventRemoteSecondaryApiMap;
  private static MiniAppProxy sMiniAppProxy;
  
  static
  {
    sEventLocalSecondaryApiMap = new HashMap();
    sEventRemoteSecondaryApiMap = new HashMap();
    sMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    initAppWhiteList();
    initEventLocalBlackList();
    initEventSecondaryApiList();
  }
  
  public static boolean apiAuthoritySilent(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo != null) && ((paramMiniAppInfo.appMode.unlimitedApiRight) || ((paramMiniAppInfo.appMode != null) && (paramMiniAppInfo.appMode.authoritySilent)));
  }
  
  private static void initAppWhiteList()
  {
    synchronized (sAppWhiteList)
    {
      String str1 = WnsConfig.getConfig("qqminiapp", "MiniAppAuthWhiteList", "1108292102");
      if ((str1 != null) && (!str1.equals(sCurAppWhiteListConfig)))
      {
        sAppWhiteList.clear();
        try
        {
          String[] arrayOfString = str1.split(",");
          if (arrayOfString != null)
          {
            int j = arrayOfString.length;
            int i = 0;
            while (i < j)
            {
              String str2 = arrayOfString[i];
              if (!StringUtil.isEmpty(str2)) {
                sAppWhiteList.add(str2);
              }
              i += 1;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          QMLog.e("AuthFilterList", "initAuthWhiteList error,", localThrowable);
          sCurAppWhiteListConfig = str1;
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private static void initEventLocalBlackList()
  {
    synchronized (sEventLocalBlackList)
    {
      sEventLocalBlackList.clear();
      sEventLocalBlackList.add("requestPayment");
      sEventLocalBlackList.add("requestMidasPayment");
      sEventLocalBlackList.add("requestWxPayment");
      sEventLocalBlackList.add("requestPaymentToBank");
      sEventLocalBlackList.add("reportSubmitForm");
      sEventLocalBlackList.add("insertHTMLWebView");
      sEventLocalBlackList.add("updateHTMLWebView");
      sEventLocalBlackList.add("removeHTMLWebView");
      sEventLocalBlackList.add("onWebInvokeAppService");
      sEventLocalBlackList.add("insertLivePusher");
      sEventLocalBlackList.add("updateLivePusher");
      sEventLocalBlackList.add("removeLivePusher");
      sEventLocalBlackList.add("operateLivePusher");
      sEventLocalBlackList.add("onLivePusherEvent");
      sEventLocalBlackList.add("onLivePusherNetStatus");
      sEventLocalBlackList.add("insertLivePlayer");
      sEventLocalBlackList.add("updateLivePlayer");
      sEventLocalBlackList.add("removeLivePlayer");
      sEventLocalBlackList.add("operateLivePlayer");
      sEventLocalBlackList.add("onLivePlayerEvent");
      sEventLocalBlackList.add("onLivePlayerFullScreenChange");
      sEventLocalBlackList.add("onLivePlayerNetStatus");
      sEventLocalBlackList.add("insertXWebLivePlayer");
      sEventLocalBlackList.add("updateXWebLivePlayer");
      sEventLocalBlackList.add("removeXWebLivePlayer");
      sEventLocalBlackList.add("operateXWebLivePlayer");
      sEventLocalBlackList.add("insertXWebLivePusher");
      sEventLocalBlackList.add("updateXWebLivePusher");
      sEventLocalBlackList.add("removeXWebLivePusher");
      sEventLocalBlackList.add("operateXWebLivePusher");
      sEventLocalBlackList.add("shareAppPictureMessage");
      sEventLocalBlackList.add("shareAppPictureMessageDirectly");
      sEventLocalBlackList.add("getPhoneNumber");
      sEventLocalBlackList.add("wnsRequest");
      sEventLocalBlackList.add("getQua");
      sEventLocalBlackList.add("notifyNative");
      sEventLocalBlackList.add("openUrl");
      sEventLocalBlackList.add("getUserInfoExtra");
      sEventLocalBlackList.add("openScheme");
      sEventLocalBlackList.add("Personalize");
      sEventLocalBlackList.add("invokeNativePlugin");
      sEventLocalBlackList.add("wnsRequest");
      sEventLocalBlackList.add("wnsGroupRequest");
      sEventLocalBlackList.add("getGroupInfoExtra");
      sEventLocalBlackList.add("startDownloadAppTask");
      sEventLocalBlackList.add("cancelDownloadAppTask");
      sEventLocalBlackList.add("queryDownloadAppTask");
      sEventLocalBlackList.add("queryAppInfo");
      sEventLocalBlackList.add("installApp");
      sEventLocalBlackList.add("startApp");
      sEventLocalBlackList.add("insertBookshelf");
      sEventLocalBlackList.add("queryBookshelf");
      sEventLocalBlackList.add("updateBookshelfReadTime");
      sEventLocalBlackList.add("navigateToBookshelf");
      sEventLocalBlackList.add("addRecentColorSign");
      sEventLocalBlackList.add("detectAbnormalLog");
      sEventLocalBlackList.add("minigameRaffle");
      sEventLocalBlackList.add("preloadPackage");
      return;
    }
  }
  
  private static void initEventSecondaryApiList()
  {
    synchronized (sEventLocalSecondaryApiMap)
    {
      sEventLocalSecondaryApiMap.clear();
      sEventLocalSecondaryApiMap.put("openScheme", new HashMap());
      sEventLocalSecondaryApiMap.put("Personalize", new HashMap());
      sEventLocalSecondaryApiMap.put("invokeNativePlugin", new HashMap());
      sEventLocalSecondaryApiMap.put("canUseComponent", new HashMap());
      return;
    }
  }
  
  public static boolean isAppInWhiteList(String paramString)
  {
    return sAppWhiteList.contains(paramString);
  }
  
  public static boolean isEventInLocalBlackList(String paramString)
  {
    return sEventLocalBlackList.contains(paramString);
  }
  
  public static boolean isEventInSecondaryApiList(String paramString)
  {
    return (sEventLocalSecondaryApiMap.containsKey(paramString)) || (sEventRemoteSecondaryApiMap.containsKey(paramString));
  }
  
  public static boolean isEventNameRight(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.appMode.unlimitedApiRight)) {
      return true;
    }
    if (sEventRemoteList.containsKey(paramString1))
    {
      if (((Integer)sEventRemoteList.get(paramString1)).intValue() == 0)
      {
        paramMiniAppInfo = new StringBuilder();
        paramMiniAppInfo.append("false, 一级黑名单 : ");
        paramMiniAppInfo.append(paramString1);
        QMLog.d("AuthFilterList_isEventNameRight", paramMiniAppInfo.toString());
        return false;
      }
      if (((Integer)sEventRemoteList.get(paramString1)).intValue() == 1)
      {
        paramMiniAppInfo = new StringBuilder();
        paramMiniAppInfo.append("true, 一级白名单 : ");
        paramMiniAppInfo.append(paramString1);
        QMLog.d("AuthFilterList_isEventNameRight", paramMiniAppInfo.toString());
        return true;
      }
    }
    if (isEventInSecondaryApiList(paramString1))
    {
      if ((sEventRemoteSecondaryApiMap.get(paramString1) != null) && (((HashMap)sEventRemoteSecondaryApiMap.get(paramString1)).containsKey(paramString2)) && (((Integer)((HashMap)sEventRemoteSecondaryApiMap.get(paramString1)).get(paramString2)).intValue() == -1))
      {
        paramMiniAppInfo = new StringBuilder();
        paramMiniAppInfo.append("false, 二级黑名单 : ");
        paramMiniAppInfo.append(paramString1);
        paramMiniAppInfo.append(" ");
        paramMiniAppInfo.append(paramString2);
        QMLog.d("AuthFilterList_isEventNameRight", paramMiniAppInfo.toString());
        return false;
      }
      if ((sEventRemoteSecondaryApiMap.get(paramString1) != null) && (((HashMap)sEventRemoteSecondaryApiMap.get(paramString1)).containsKey(paramString2)) && (((Integer)((HashMap)sEventRemoteSecondaryApiMap.get(paramString1)).get(paramString2)).intValue() == 1))
      {
        paramMiniAppInfo = new StringBuilder();
        paramMiniAppInfo.append("true, 二级白名单 : ");
        paramMiniAppInfo.append(paramString1);
        paramMiniAppInfo.append(" ");
        paramMiniAppInfo.append(paramString2);
        QMLog.d("AuthFilterList_isEventNameRight", paramMiniAppInfo.toString());
        return true;
      }
      if (sEventLocalSecondaryApiMap.containsKey(paramString1))
      {
        paramMiniAppInfo = new StringBuilder();
        paramMiniAppInfo.append("false, 二级默认黑名单 : ");
        paramMiniAppInfo.append(paramString1);
        paramMiniAppInfo.append(" ");
        paramMiniAppInfo.append(paramString2);
        QMLog.d("AuthFilterList_isEventNameRight", paramMiniAppInfo.toString());
        return false;
      }
      paramMiniAppInfo = new StringBuilder();
      paramMiniAppInfo.append("true, 二级白名单或未配置 : ");
      paramMiniAppInfo.append(paramString1);
      paramMiniAppInfo.append(" ");
      paramMiniAppInfo.append(paramString2);
      QMLog.d("AuthFilterList_isEventNameRight", paramMiniAppInfo.toString());
      return true;
    }
    if (sEventLocalBlackList.contains(paramString1))
    {
      paramMiniAppInfo = new StringBuilder();
      paramMiniAppInfo.append("false, 本地黑名单 : ");
      paramMiniAppInfo.append(paramString1);
      QMLog.d("AuthFilterList_isEventNameRight", paramMiniAppInfo.toString());
      return false;
    }
    if (sMiniAppProxy.isDebugVersion())
    {
      paramMiniAppInfo = new StringBuilder();
      paramMiniAppInfo.append("true, 无限制api : ");
      paramMiniAppInfo.append(paramString1);
      QMLog.d("AuthFilterList_isEventNameRight", paramMiniAppInfo.toString());
    }
    return true;
  }
  
  public static void reset()
  {
    sEventRemoteList.clear();
    sEventLocalSecondaryApiMap.clear();
    sEventRemoteSecondaryApiMap.clear();
    initEventSecondaryApiList();
  }
  
  public static void updateEventRemoteList(List<String> paramList1, List<String> paramList2)
  {
    Map localMap = sEventRemoteList;
    if (paramList1 != null) {}
    try
    {
      paramList1 = paramList1.iterator();
      Object localObject;
      while (paramList1.hasNext())
      {
        localObject = (String)paramList1.next();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("whiteList eventName : ");
          localStringBuilder.append((String)localObject);
          QMLog.d("AuthFilterList", localStringBuilder.toString());
          sEventRemoteList.put(localObject, Integer.valueOf(0));
        }
      }
      if (paramList2 != null)
      {
        paramList1 = paramList2.iterator();
        while (paramList1.hasNext())
        {
          paramList2 = (String)paramList1.next();
          if (!TextUtils.isEmpty(paramList2))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("whiteList eventName : ");
            ((StringBuilder)localObject).append(paramList2);
            QMLog.d("AuthFilterList", ((StringBuilder)localObject).toString());
            sEventRemoteList.put(paramList2, Integer.valueOf(1));
          }
        }
      }
      return;
    }
    finally
    {
      label183:
      break label183;
    }
    for (;;)
    {
      throw paramList1;
    }
  }
  
  public static void updateEventSecondaryApiList(List<SecondApiRightInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SecondApiRightInfo localSecondApiRightInfo = (SecondApiRightInfo)paramList.next();
      if (localSecondApiRightInfo != null)
      {
        Object localObject;
        if (sEventRemoteSecondaryApiMap.containsKey(localSecondApiRightInfo.apiName))
        {
          if (QMLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("config apiName : ");
            ((StringBuilder)localObject).append(localSecondApiRightInfo.apiName);
            ((StringBuilder)localObject).append(", secondName: ");
            ((StringBuilder)localObject).append(localSecondApiRightInfo.secondName);
            QMLog.d("AuthFilterList", ((StringBuilder)localObject).toString());
          }
          ((Map)sEventRemoteSecondaryApiMap.get(localSecondApiRightInfo.apiName)).put(localSecondApiRightInfo.secondName, Integer.valueOf(localSecondApiRightInfo.right));
        }
        else
        {
          if (QMLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("init config apiName : ");
            ((StringBuilder)localObject).append(localSecondApiRightInfo.apiName);
            ((StringBuilder)localObject).append(", secondName: ");
            ((StringBuilder)localObject).append(localSecondApiRightInfo.secondName);
            QMLog.d("AuthFilterList", ((StringBuilder)localObject).toString());
          }
          localObject = new HashMap();
          ((HashMap)localObject).put(localSecondApiRightInfo.secondName, Integer.valueOf(localSecondApiRightInfo.right));
          sEventRemoteSecondaryApiMap.put(localSecondApiRightInfo.apiName, localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.auth.AuthFilterList
 * JD-Core Version:    0.7.0.1
 */