package com.tencent.mobileqq.mini.apkg;

import android.content.SharedPreferences;
import android.text.TextUtils;
import bgxr;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ApkgBaseInfo
{
  private static final String CONFIG_SPLIT = ",";
  private static final String[] DOMAIN_NAME_LIST = { "Request", "Websocket", "Download", "Upload", "Webview" };
  public static final int DOMIAN_TYPE_DOWNLOAD = 2;
  public static final int DOMIAN_TYPE_REQUEST = 0;
  public static final int DOMIAN_TYPE_UPLOAD = 3;
  public static final int DOMIAN_TYPE_WEBSOCKET = 1;
  public static final int DOMIAN_TYPE_WEBVIEW = 4;
  public static boolean isRdmBuild = bgxr.a().toLowerCase().contains("rdm");
  private static String mCurWhiteListConfig;
  private static ArrayList<String> sDominWhiteList;
  public String apkgFolderPath;
  public String apkgName;
  public MiniAppConfig appConfig;
  public String appId;
  public String iconUrl;
  private ConcurrentHashMap<Integer, ArrayList<DomainConfig>> mCachedDomainConfigMap;
  public String mConfigStr;
  private volatile Set<String> mUdpIpWhiteSet;
  
  public ApkgBaseInfo(String paramString, MiniAppConfig paramMiniAppConfig)
  {
    this.apkgFolderPath = paramString;
    this.appId = paramMiniAppConfig.config.appId;
    this.apkgName = paramMiniAppConfig.config.name;
    this.iconUrl = paramMiniAppConfig.config.iconUrl;
    this.appConfig = paramMiniAppConfig;
  }
  
  private static ArrayList<String> getDefaultRegularPatterns()
  {
    try
    {
      if (sDominWhiteList == null)
      {
        String str1 = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameDomainWhiteList", "\\S*\\.qq\\.com,thirdqq\\.qlogo\\.cn,c\\d{4}\\.myh5\\.90wmoyu\\.com,\\S*\\.gtimg\\.cn");
        if ((str1 != null) && (!str1.equals(mCurWhiteListConfig)))
        {
          QLog.i("[mini] http.", 1, "Default white domain:" + str1);
          sDominWhiteList = new ArrayList();
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
  
  private boolean isDomainConfigCached(DomainConfig paramDomainConfig, int paramInt)
  {
    if (paramDomainConfig == null) {
      return false;
    }
    Object localObject = this.mCachedDomainConfigMap;
    if (localObject == null) {
      return false;
    }
    localObject = (ArrayList)((Map)localObject).get(Integer.valueOf(paramInt));
    return (localObject != null) && (((ArrayList)localObject).contains(paramDomainConfig));
  }
  
  private boolean isOnlineVersion()
  {
    return (this.appConfig != null) && (this.appConfig.config != null) && (this.appConfig.config.verType == 3);
  }
  
  public static String normalize(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      int j = paramString.indexOf("?");
      int i = j;
      if (j == -1) {
        i = paramString.length();
      }
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  private void putDomainConfigToCache(DomainConfig paramDomainConfig, int paramInt)
  {
    if (paramDomainConfig == null) {}
    ArrayList localArrayList1;
    do
    {
      return;
      if (this.mCachedDomainConfigMap == null) {
        this.mCachedDomainConfigMap = new ConcurrentHashMap();
      }
      ArrayList localArrayList2 = (ArrayList)this.mCachedDomainConfigMap.get(Integer.valueOf(paramInt));
      localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        this.mCachedDomainConfigMap.put(Integer.valueOf(paramInt), localArrayList1);
      }
    } while (localArrayList1.contains(paramDomainConfig));
    localArrayList1.add(paramDomainConfig);
  }
  
  public String getApkgFolderPath()
  {
    return this.apkgFolderPath;
  }
  
  public boolean getEnableDebug()
  {
    return StorageUtil.getPreference().getBoolean(this.appId + "_debug", false);
  }
  
  public String getFilePath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return new File(getRootPath(), paramString).getAbsolutePath();
  }
  
  public String getRootPath()
  {
    return this.apkgFolderPath;
  }
  
  public abstract String getRootPath(String paramString);
  
  public abstract String getWorkerPath(String paramString1, String paramString2);
  
  public abstract void init(String paramString);
  
  public boolean isDomainValid(boolean paramBoolean, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramBoolean)
    {
      QLog.d("[mini] http.domainValid", 1, DOMAIN_NAME_LIST[paramInt] + ":域名检查 skipDomainCheckFromJs:" + paramString);
      return true;
    }
    if (this.appConfig.config.skipDomainCheck == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      QLog.d("[mini] http.domainValid", 1, DOMAIN_NAME_LIST[paramInt] + ":域名检查 skip:" + paramString);
      return true;
    }
    Object localObject1 = paramString.toLowerCase();
    if ((!isOnlineVersion()) && (getEnableDebug()))
    {
      if (!isValidPrefix((String)localObject1, true))
      {
        QLog.d("[mini] http.domainValid", 1, DOMAIN_NAME_LIST[paramInt] + "域名不合法，需使用https或wss协议:" + paramString);
        return false;
      }
      QLog.d("[mini] http.domainValid", 1, "debug opened and not online version, skip:" + paramString);
      return true;
    }
    if (!isRdmBuild) {}
    while (!isValidPrefix((String)localObject1, false))
    {
      QLog.e("[mini] http.domainValid", 1, DOMAIN_NAME_LIST[paramInt] + ":请求域名不合法，请使用https或wss协议,reqeustUrl:" + paramString);
      if (!isOnlineVersion())
      {
        GameLog.vconsoleLog(DOMAIN_NAME_LIST[paramInt] + "域名不合法，需使用https或wss协议:" + (String)localObject1);
        AppBrandTask.runTaskOnUiThread(new ApkgBaseInfo.1(this, paramInt, (String)localObject1));
        return false;
        if (paramString.startsWith(QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppRMDDomainWhiteList", "https://www.urlshare.cn/")))
        {
          QLog.d("[mini] http.domainValid", 1, "rdm mode, https://www.urlshare.cn/ is valid, current Url is: " + paramString);
          return true;
        }
      }
      else
      {
        return false;
      }
    }
    DomainConfig localDomainConfig = DomainConfig.getDomainConfig((String)localObject1);
    if (isDomainConfigCached(localDomainConfig, paramInt)) {
      return true;
    }
    if ((localDomainConfig != null) && (!TextUtils.isEmpty(localDomainConfig.host)))
    {
      localObject1 = getDefaultRegularPatterns().iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Pattern localPattern = Pattern.compile((String)((Iterator)localObject1).next(), 2);
          if (localPattern == null) {
            continue;
          }
          try
          {
            paramBoolean = localPattern.matcher(localDomainConfig.host).matches();
            if (paramBoolean)
            {
              putDomainConfigToCache(localDomainConfig, paramInt);
              return true;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("[mini] http.", 1, "", localException);
              paramBoolean = false;
            }
          }
        }
      }
      if ((this.appConfig != null) && (this.appConfig.config != null))
      {
        localObject1 = this.appConfig.config.requestDomainList;
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
                break label761;
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
                    localObject1 = this.appConfig.config.socketDomainList;
                    break;
                    localObject1 = this.appConfig.config.downloadFileDomainList;
                    break;
                    localObject1 = this.appConfig.config.uploadFileDomainList;
                    break;
                    localObject1 = this.appConfig.config.businessDomainList;
                    break;
                  }
                  QLog.i("[mini] http.domainValid", 1, "request:" + localDomainConfig + ",allow:" + localObject2);
                }
              }
              catch (Throwable localThrowable)
              {
                QLog.e("[mini] http.domainValid", 1, "check domainValid error, requestUrl:" + paramString, localThrowable);
              }
            }
          }
        }
      }
    }
    label761:
    GameLog.vconsoleLog(DOMAIN_NAME_LIST[paramInt] + ":Invalid domain, please config requestUrl: " + paramString);
    QLog.e("[mini] http.domainValid", 1, DOMAIN_NAME_LIST[paramInt] + ":Invalid domain, please config requestUrl: " + paramString);
    if (!isOnlineVersion())
    {
      GameLog.vconsoleLog(DOMAIN_NAME_LIST[paramInt] + " invalid domain, please config " + localDomainConfig);
      AppBrandTask.runTaskOnUiThread(new ApkgBaseInfo.2(this, paramInt, localDomainConfig));
      return false;
    }
    return false;
  }
  
  public boolean isEngineTypeMiniApp()
  {
    if ((this.appConfig != null) && (this.appConfig.config != null)) {
      return this.appConfig.config.isEngineTypeMiniApp();
    }
    return false;
  }
  
  public boolean isEngineTypeMiniGame()
  {
    if ((this.appConfig != null) && (this.appConfig.config != null)) {
      return this.appConfig.config.isEngineTypeMiniGame();
    }
    return false;
  }
  
  public boolean isUdpIpValid(String paramString)
  {
    int i = 0;
    if ((this.appConfig == null) || (this.appConfig.config == null)) {
      return false;
    }
    if (this.appConfig.config.skipDomainCheck == 1) {
      i = 1;
    }
    if (i != 0)
    {
      QLog.d("[mini] http.udp", 1, "udp ip检查 skip: " + paramString);
      return true;
    }
    if ((!isOnlineVersion()) && (getEnableDebug()))
    {
      QLog.d("[mini] http.udp", 1, "debug opened and not online version, skip:" + paramString);
      return true;
    }
    if (this.mUdpIpWhiteSet == null) {}
    try
    {
      if (this.mUdpIpWhiteSet == null) {
        this.mUdpIpWhiteSet = new HashSet(this.appConfig.config.udpIpList);
      }
      return this.mUdpIpWhiteSet.contains(paramString);
    }
    finally {}
  }
  
  public abstract boolean isUrlResReady(String paramString);
  
  public boolean isValidPrefix(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("https://")) && (!paramString.startsWith("wss://")) && (!paramString.startsWith("ws://")) && (!paramString.startsWith("http://")))) {}
    }
    while ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("https://")) || (paramString.startsWith("wss://"))))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appId:").append(this.appId).append(", name:").append(this.apkgName);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgBaseInfo
 * JD-Core Version:    0.7.0.1
 */