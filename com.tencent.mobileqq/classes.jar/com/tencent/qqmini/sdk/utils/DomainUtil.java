package com.tencent.qqmini.sdk.utils;

import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.DomainConfig;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.Nullable;

public class DomainUtil
{
  private static final String CONFIG_SPLIT = ";";
  private static final String[] DOMAIN_NAME_LIST = { "Request", "Websocket", "Download", "Upload", "Webview", "UDP" };
  public static final int DOMIAN_TYPE_DOWNLOAD = 2;
  public static final int DOMIAN_TYPE_DUP = 5;
  public static final int DOMIAN_TYPE_REQUEST = 0;
  public static final int DOMIAN_TYPE_UPLOAD = 3;
  public static final int DOMIAN_TYPE_WEBSOCKET = 1;
  public static final int DOMIAN_TYPE_WEBVIEW = 4;
  private static ConcurrentHashMap<Integer, ArrayList<DomainConfig>> mCachedDomainConfigMap;
  private static String mCurWhiteListConfig;
  private static ArrayList<String> sDominWhiteList = null;
  
  private static boolean checkAppConfig(MiniAppInfo paramMiniAppInfo, String paramString, int paramInt, DomainConfig paramDomainConfig)
  {
    if ((paramDomainConfig != null) && (!TextUtils.isEmpty(paramDomainConfig.host)) && (paramMiniAppInfo != null))
    {
      Object localObject = paramMiniAppInfo.requestDomainList;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                paramMiniAppInfo = (MiniAppInfo)localObject;
              } else {
                paramMiniAppInfo = paramMiniAppInfo.udpIpList;
              }
            }
            else {
              paramMiniAppInfo = paramMiniAppInfo.businessDomainList;
            }
          }
          else {
            paramMiniAppInfo = paramMiniAppInfo.uploadFileDomainList;
          }
        }
        else {
          paramMiniAppInfo = paramMiniAppInfo.downloadFileDomainList;
        }
      }
      else {
        paramMiniAppInfo = paramMiniAppInfo.socketDomainList;
      }
      if (paramMiniAppInfo != null)
      {
        paramMiniAppInfo = paramMiniAppInfo.iterator();
        while (paramMiniAppInfo.hasNext())
        {
          localObject = (String)paramMiniAppInfo.next();
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localObject = DomainConfig.getDomainConfig(((String)localObject).toLowerCase());
              if (DomainConfig.isDomainConfigMatch((DomainConfig)localObject, paramDomainConfig))
              {
                putDomainConfigToCache(paramDomainConfig, paramInt);
                return true;
              }
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("request:");
              localStringBuilder.append(paramDomainConfig);
              localStringBuilder.append(",allow:");
              localStringBuilder.append(localObject);
              QMLog.i("[mini] http.domainValid", localStringBuilder.toString());
            }
          }
          catch (Throwable localThrowable)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("check domainValid error, requestUrl:");
            localStringBuilder.append(paramString);
            QMLog.e("[mini] http.domainValid", localStringBuilder.toString(), localThrowable);
          }
        }
      }
    }
    return false;
  }
  
  private static boolean checkIsReportDomain(String paramString)
  {
    if (((QUAUtil.isRdmBuild()) || (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion())) && (paramString.startsWith(WnsConfig.getConfig("qqminiapp", "MiniAppRMDDomainWhiteList", "https://www.urlshare.cn/"))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rdm mode, https://www.urlshare.cn/ is valid, current Url is: ");
      localStringBuilder.append(paramString);
      QMLog.d("[mini] http.domainValid", localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  private static boolean checkProtocol(MiniAppInfo paramMiniAppInfo, String paramString1, int paramInt, String paramString2)
  {
    if (!needCheckProtocol(paramInt)) {
      return false;
    }
    boolean bool;
    if (paramInt == 4) {
      bool = true;
    } else {
      bool = false;
    }
    if (!isValidPrefix(paramString2, bool))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(DOMAIN_NAME_LIST[paramInt]);
      localStringBuilder.append(":请求域名不合法，请使用https或wss协议,reqeustUrl:");
      localStringBuilder.append(paramString1);
      QMLog.e("[mini] http.domainValid", localStringBuilder.toString());
      if (!isOnlineVersion(paramMiniAppInfo)) {
        ThreadManager.getUIHandler().post(new DomainUtil.2(paramInt, paramString2));
      }
      return true;
    }
    return false;
  }
  
  @Nullable
  private static Boolean checkVersionAndDebug(MiniAppInfo paramMiniAppInfo, String paramString1, int paramInt, String paramString2)
  {
    if ((!isOnlineVersion(paramMiniAppInfo)) && (getEnableDebug(paramMiniAppInfo.appId)))
    {
      if (!isValidPrefix(paramString2, true))
      {
        paramMiniAppInfo = new StringBuilder();
        paramMiniAppInfo.append(DOMAIN_NAME_LIST[paramInt]);
        paramMiniAppInfo.append("域名不合法，需使用https或wss协议:");
        paramMiniAppInfo.append(paramString1);
        QMLog.d("[mini] http.domainValid", paramMiniAppInfo.toString());
        return Boolean.valueOf(false);
      }
      paramMiniAppInfo = new StringBuilder();
      paramMiniAppInfo.append("debug opened and not online version, skip:");
      paramMiniAppInfo.append(paramString1);
      QMLog.d("[mini] http.domainValid", paramMiniAppInfo.toString());
      return Boolean.valueOf(true);
    }
    return null;
  }
  
  private static boolean checkWnsConfig(String paramString, int paramInt, DomainConfig paramDomainConfig)
  {
    Object localObject = getDomainWhiteList();
    try
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (DomainConfig.isDomainMatchRfc2019((String)((Iterator)localObject).next(), paramDomainConfig))
        {
          putDomainConfigToCache(paramDomainConfig, paramInt);
          return true;
        }
      }
    }
    catch (Throwable paramDomainConfig)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("check domainValid error, requestUrl:");
      ((StringBuilder)localObject).append(paramString);
      QMLog.e("[mini] http.domainValid", ((StringBuilder)localObject).toString(), paramDomainConfig);
    }
    return false;
  }
  
  private static ArrayList<String> getDomainWhiteList()
  {
    try
    {
      if (sDominWhiteList == null)
      {
        String str = WnsConfig.getConfig("qqminiapp", "defaultAllowedHostList", ".qlogo.cn;.tcb.qcloud.la;open.mp.qq.com;api-report.q.qq.com;rpt.gdt.qq.com;.gtimg.cn");
        if ((str != null) && (!str.equals(mCurWhiteListConfig)))
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Default white domain:");
          ((StringBuilder)localObject2).append(str);
          QMLog.i("[mini] http.domainValid", ((StringBuilder)localObject2).toString());
          sDominWhiteList = new ArrayList();
          try
          {
            localObject2 = str.split(";");
            if (localObject2 != null)
            {
              int j = localObject2.length;
              int i = 0;
              while (i < j)
              {
                CharSequence localCharSequence = localObject2[i];
                if (!TextUtils.isEmpty(localCharSequence)) {
                  sDominWhiteList.add(localCharSequence);
                }
                i += 1;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            mCurWhiteListConfig = str;
          }
        }
      }
      return sDominWhiteList;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public static boolean getEnableDebug(String paramString)
  {
    SharedPreferences localSharedPreferences = StorageUtil.getPreference();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_debug");
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
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
    if ((!TextUtils.isEmpty(paramString)) && (paramMiniAppInfo != null))
    {
      if (paramBoolean)
      {
        paramMiniAppInfo = new StringBuilder();
        paramMiniAppInfo.append(DOMAIN_NAME_LIST[paramInt]);
        paramMiniAppInfo.append(":域名检查 skipDomainCheckFromJs:");
        paramMiniAppInfo.append(paramString);
        QMLog.d("[mini] http.domainValid", paramMiniAppInfo.toString());
        return true;
      }
      int i;
      if (paramMiniAppInfo.skipDomainCheck == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramMiniAppInfo = new StringBuilder();
        paramMiniAppInfo.append(DOMAIN_NAME_LIST[paramInt]);
        paramMiniAppInfo.append(":域名检查 skip:");
        paramMiniAppInfo.append(paramString);
        QMLog.d("[mini] http.domainValid", paramMiniAppInfo.toString());
        return true;
      }
      localObject1 = paramString.toLowerCase();
      Object localObject2 = checkVersionAndDebug(paramMiniAppInfo, paramString, paramInt, (String)localObject1);
      if (localObject2 != null) {
        return ((Boolean)localObject2).booleanValue();
      }
      if (checkIsReportDomain(paramString)) {
        return true;
      }
      if (checkProtocol(paramMiniAppInfo, paramString, paramInt, (String)localObject1)) {
        return false;
      }
      localObject1 = DomainConfig.getDomainConfig((String)localObject1);
      if (isDomainConfigCached((DomainConfig)localObject1, paramInt)) {
        return true;
      }
      if (checkAppConfig(paramMiniAppInfo, paramString, paramInt, (DomainConfig)localObject1)) {
        return true;
      }
      if (checkWnsConfig(paramString, paramInt, (DomainConfig)localObject1)) {
        return true;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(DOMAIN_NAME_LIST[paramInt]);
      ((StringBuilder)localObject2).append(":请求域名不合法，请配置，requestUrl:");
      ((StringBuilder)localObject2).append(paramString);
      QMLog.e("[mini] http.domainValid", ((StringBuilder)localObject2).toString());
      if (!isOnlineVersion(paramMiniAppInfo)) {
        ThreadManager.getUIHandler().post(new DomainUtil.1(paramInt, (DomainConfig)localObject1));
      }
      return false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("url or appcconfig is null. url : ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("; appconfig : ");
    ((StringBuilder)localObject1).append(paramMiniAppInfo);
    QMLog.e("[mini] http.domainValid", ((StringBuilder)localObject1).toString());
    return false;
  }
  
  private static boolean isOnlineVersion(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo != null) && (paramMiniAppInfo.verType == 3);
  }
  
  private static boolean isValidPrefix(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.startsWith("https://")) {
        return true;
      }
      if (paramString.startsWith("wss://")) {
        return true;
      }
      if ((paramBoolean) && ((paramString.startsWith("http://")) || (paramString.startsWith("ws://")))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean needCheckProtocol(int paramInt)
  {
    return paramInt != 5;
  }
  
  private static void putDomainConfigToCache(DomainConfig paramDomainConfig, int paramInt)
  {
    if (paramDomainConfig == null) {
      return;
    }
    if (mCachedDomainConfigMap == null) {
      mCachedDomainConfigMap = new ConcurrentHashMap();
    }
    ArrayList localArrayList2 = (ArrayList)mCachedDomainConfigMap.get(Integer.valueOf(paramInt));
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      mCachedDomainConfigMap.put(Integer.valueOf(paramInt), localArrayList1);
    }
    if (!localArrayList1.contains(paramDomainConfig)) {
      localArrayList1.add(paramDomainConfig);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.DomainUtil
 * JD-Core Version:    0.7.0.1
 */