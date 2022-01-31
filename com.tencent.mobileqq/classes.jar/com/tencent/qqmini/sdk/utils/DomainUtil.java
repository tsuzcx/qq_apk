package com.tencent.qqmini.sdk.utils;

import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import bgpx;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.DomainConfig;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DomainUtil
{
  private static final String CONFIG_SPLIT = ";";
  private static final String[] DOMAIN_NAME_LIST = { "Request", "Websocket", "Download", "Upload", "Webview" };
  public static final int DOMIAN_TYPE_DOWNLOAD = 2;
  public static final int DOMIAN_TYPE_REQUEST = 0;
  public static final int DOMIAN_TYPE_UPLOAD = 3;
  public static final int DOMIAN_TYPE_WEBSOCKET = 1;
  public static final int DOMIAN_TYPE_WEBVIEW = 4;
  private static ConcurrentHashMap<Integer, ArrayList<DomainConfig>> mCachedDomainConfigMap;
  private static String mCurWhiteListConfig;
  private static ArrayList<String> sDominWhiteList;
  
  private static ArrayList<String> getDomainWhiteList()
  {
    try
    {
      if (sDominWhiteList == null)
      {
        String str1 = bgpx.a("qqminiapp", "defaultAllowedHostList", ".qq.com;.qlogo.cn;.tcb.qcloud.la");
        if ((str1 != null) && (!str1.equals(mCurWhiteListConfig)))
        {
          QMLog.i("[mini] http.domainValid", "Default white domain:" + str1);
          sDominWhiteList = new ArrayList();
          try
          {
            String[] arrayOfString = str1.split(";");
            if (arrayOfString != null)
            {
              int j = arrayOfString.length;
              int i = 0;
              while (i < j)
              {
                String str2 = arrayOfString[i];
                if (!TextUtils.isEmpty(str2)) {
                  sDominWhiteList.add(str2);
                }
                i += 1;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            mCurWhiteListConfig = str1;
          }
        }
      }
      return sDominWhiteList;
    }
    finally {}
  }
  
  private static boolean getEnableDebug(String paramString)
  {
    return StorageUtil.getPreference().getBoolean(paramString + "_debug", false);
  }
  
  private static boolean isDomainConfigCached(DomainConfig paramDomainConfig, int paramInt)
  {
    if (paramDomainConfig == null) {
      return false;
    }
    Object localObject = mCachedDomainConfigMap;
    if (localObject == null) {
      return false;
    }
    localObject = (ArrayList)((Map)localObject).get(Integer.valueOf(paramInt));
    return (localObject != null) && (((ArrayList)localObject).contains(paramDomainConfig));
  }
  
  public static boolean isDomainValid(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramBoolean)
    {
      QMLog.d("[mini] http.domainValid", DOMAIN_NAME_LIST[paramInt] + ":域名检查 skipDomainCheckFromJs:" + paramString);
      return true;
    }
    if (paramMiniAppInfo.skipDomainCheck == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      QMLog.d("[mini] http.domainValid", DOMAIN_NAME_LIST[paramInt] + ":域名检查 skip:" + paramString);
      return true;
    }
    Object localObject1 = paramString.toLowerCase();
    if ((!isOnlineVersion(paramMiniAppInfo)) && (getEnableDebug(paramMiniAppInfo.appId)))
    {
      if (!isValidPrefix((String)localObject1, true))
      {
        QMLog.d("[mini] http.domainValid", DOMAIN_NAME_LIST[paramInt] + "域名不合法，需使用https或wss协议:" + paramString);
        return false;
      }
      QMLog.d("[mini] http.domainValid", "debug opened and not online version, skip:" + paramString);
      return true;
    }
    if (((QUAUtil.isRdmBuild()) || (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion())) && (paramString.startsWith(bgpx.a("qqminiapp", "MiniAppRMDDomainWhiteList", "https://www.urlshare.cn/"))))
    {
      QMLog.d("[mini] http.domainValid", "rdm mode, https://www.urlshare.cn/ is valid, current Url is: " + paramString);
      return true;
    }
    if (!isValidPrefix((String)localObject1, false))
    {
      QMLog.e("[mini] http.domainValid", DOMAIN_NAME_LIST[paramInt] + ":请求域名不合法，请使用https或wss协议,reqeustUrl:" + paramString);
      if (!isOnlineVersion(paramMiniAppInfo))
      {
        ThreadManager.c().post(new DomainUtil.1(paramInt, (String)localObject1));
        return false;
      }
      return false;
    }
    DomainConfig localDomainConfig = DomainConfig.getDomainConfig((String)localObject1);
    if (isDomainConfigCached(localDomainConfig, paramInt)) {
      return true;
    }
    if ((localDomainConfig != null) && (!TextUtils.isEmpty(localDomainConfig.host)) && (paramMiniAppInfo != null))
    {
      localObject1 = paramMiniAppInfo.requestDomainList;
      switch (paramInt)
      {
      default: 
        if (localObject1 != null) {
          localObject1 = ((List)localObject1).iterator();
        }
        break;
      case 1: 
      case 2: 
      case 3: 
      case 4: 
        for (;;)
        {
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label580;
            }
            Object localObject2 = (String)((Iterator)localObject1).next();
            try
            {
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject2 = DomainConfig.getDomainConfig(((String)localObject2).toLowerCase());
                if (DomainConfig.isDomainConfigMatch((DomainConfig)localObject2, localDomainConfig))
                {
                  putDomainConfigToCache(localDomainConfig, paramInt);
                  return true;
                  localObject1 = paramMiniAppInfo.socketDomainList;
                  break;
                  localObject1 = paramMiniAppInfo.downloadFileDomainList;
                  break;
                  localObject1 = paramMiniAppInfo.uploadFileDomainList;
                  break;
                  localObject1 = paramMiniAppInfo.businessDomainList;
                  break;
                }
                QMLog.i("[mini] http.domainValid", "request:" + localDomainConfig + ",allow:" + localObject2);
              }
            }
            catch (Throwable localThrowable2)
            {
              QMLog.e("[mini] http.domainValid", "check domainValid error, requestUrl:" + paramString, localThrowable2);
            }
          }
        }
        label580:
        localObject1 = getDomainWhiteList();
        try
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            String str = (String)((Iterator)localObject1).next();
            if (((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(localDomainConfig.host)) && (str.startsWith(".")) && (str.split("\\.").length >= 1) && (localDomainConfig.host.endsWith(str))) || (str.equals(localDomainConfig.host)))
            {
              putDomainConfigToCache(localDomainConfig, paramInt);
              return true;
            }
          }
        }
        catch (Throwable localThrowable1)
        {
          QMLog.e("[mini] http.domainValid", "check domainValid error, requestUrl:" + paramString, localThrowable1);
        }
      }
    }
    QMLog.e("[mini] http.domainValid", DOMAIN_NAME_LIST[paramInt] + ":请求域名不合法，请配置，requestUrl:" + paramString);
    if (!isOnlineVersion(paramMiniAppInfo))
    {
      ThreadManager.c().post(new DomainUtil.2(paramInt, localDomainConfig));
      return false;
    }
    return false;
  }
  
  private static boolean isOnlineVersion(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo != null) && (paramMiniAppInfo.verType == 3);
  }
  
  private static boolean isValidPrefix(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("https://")) && (!paramString.startsWith("wss://")) && (!paramString.startsWith("http://")))) {}
    }
    while ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("https://")) || (paramString.startsWith("wss://"))))
    {
      return true;
      return false;
    }
    return false;
  }
  
  private static void putDomainConfigToCache(DomainConfig paramDomainConfig, int paramInt)
  {
    if (paramDomainConfig == null) {}
    ArrayList localArrayList1;
    do
    {
      return;
      if (mCachedDomainConfigMap == null) {
        mCachedDomainConfigMap = new ConcurrentHashMap();
      }
      ArrayList localArrayList2 = (ArrayList)mCachedDomainConfigMap.get(Integer.valueOf(paramInt));
      localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        mCachedDomainConfigMap.put(Integer.valueOf(paramInt), localArrayList1);
      }
    } while (localArrayList1.contains(paramDomainConfig));
    localArrayList1.add(paramDomainConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.DomainUtil
 * JD-Core Version:    0.7.0.1
 */