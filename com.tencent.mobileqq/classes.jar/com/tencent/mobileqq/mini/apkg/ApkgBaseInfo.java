package com.tencent.mobileqq.mini.apkg;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ApkgBaseInfo
{
  private static final String CONFIG_SPLIT = ";";
  private static final String[] DOMAIN_NAME_LIST = { "Request", "Websocket", "Download", "Upload", "Webview", "UDP" };
  public static final int DOMIAN_TYPE_DOWNLOAD = 2;
  public static final int DOMIAN_TYPE_REQUEST = 0;
  public static final int DOMIAN_TYPE_UDP = 5;
  public static final int DOMIAN_TYPE_UPLOAD = 3;
  public static final int DOMIAN_TYPE_WEBSOCKET = 1;
  public static final int DOMIAN_TYPE_WEBVIEW = 4;
  public static boolean isRdmBuild = QUA.getQUA3().toLowerCase().contains("rdm");
  private static String mCurWhiteListConfig;
  private static ArrayList<String> sDominWhiteList = null;
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
  
  private static ArrayList<String> getDomainWhiteList()
  {
    try
    {
      if (sDominWhiteList == null)
      {
        String str = QzoneConfig.getInstance().getConfig("qqminiapp", "defaultAllowedHostList", ".qlogo.cn;.tcb.qcloud.la;open.mp.qq.com;api-report.q.qq.com;rpt.gdt.qq.com;.pic.ap-shanghai.myqcloud.com;.gtimg.cn;graph.qq.com;");
        if ((str != null) && (!str.equals(mCurWhiteListConfig)))
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Default white domain:");
          ((StringBuilder)localObject2).append(str);
          QLog.i("[mini] http.", 1, ((StringBuilder)localObject2).toString());
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
    MiniAppConfig localMiniAppConfig = this.appConfig;
    return (localMiniAppConfig != null) && (localMiniAppConfig.config != null) && (this.appConfig.config.verType == 3);
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
    if (paramDomainConfig == null) {
      return;
    }
    if (this.mCachedDomainConfigMap == null) {
      this.mCachedDomainConfigMap = new ConcurrentHashMap();
    }
    ArrayList localArrayList2 = (ArrayList)this.mCachedDomainConfigMap.get(Integer.valueOf(paramInt));
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      this.mCachedDomainConfigMap.put(Integer.valueOf(paramInt), localArrayList1);
    }
    if (!localArrayList1.contains(paramDomainConfig)) {
      localArrayList1.add(paramDomainConfig);
    }
  }
  
  public String getApkgFolderPath()
  {
    return this.apkgFolderPath;
  }
  
  public boolean getEnableDebug()
  {
    SharedPreferences localSharedPreferences = StorageUtil.getPreference();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.appId);
    localStringBuilder.append("_debug");
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(DOMAIN_NAME_LIST[paramInt]);
      ((StringBuilder)localObject1).append(":域名检查 skipDomainCheckFromJs:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("[mini] http.domainValid", 1, ((StringBuilder)localObject1).toString());
      return true;
    }
    int i;
    if (this.appConfig.config.skipDomainCheck == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(DOMAIN_NAME_LIST[paramInt]);
      ((StringBuilder)localObject1).append(":域名检查 skip:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("[mini] http.domainValid", 1, ((StringBuilder)localObject1).toString());
      return true;
    }
    Object localObject1 = paramString.toLowerCase();
    if ((!isOnlineVersion()) && (getEnableDebug()))
    {
      if (!isValidPrefix((String)localObject1, true))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(DOMAIN_NAME_LIST[paramInt]);
        ((StringBuilder)localObject1).append("域名不合法，需使用https或wss协议:");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("[mini] http.domainValid", 1, ((StringBuilder)localObject1).toString());
        return false;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("debug opened and not online version, skip:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("[mini] http.domainValid", 1, ((StringBuilder)localObject1).toString());
      return true;
    }
    if ((isRdmBuild) && (paramString.startsWith(QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppRMDDomainWhiteList", "https://www.urlshare.cn/"))))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("rdm mode, https://www.urlshare.cn/ is valid, current Url is: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("[mini] http.domainValid", 1, ((StringBuilder)localObject1).toString());
      return true;
    }
    if (paramInt == 4) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    if (!isValidPrefix((String)localObject1, paramBoolean))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(DOMAIN_NAME_LIST[paramInt]);
      ((StringBuilder)localObject2).append(":请求域名不合法，请使用https或wss协议,reqeustUrl:");
      ((StringBuilder)localObject2).append(paramString);
      QLog.e("[mini] http.domainValid", 1, ((StringBuilder)localObject2).toString());
      if (!isOnlineVersion())
      {
        paramString = new StringBuilder();
        paramString.append(DOMAIN_NAME_LIST[paramInt]);
        paramString.append("域名不合法，需使用https或wss协议:");
        paramString.append((String)localObject1);
        GameLog.vconsoleLog(paramString.toString());
        AppBrandTask.runTaskOnUiThread(new ApkgBaseInfo.1(this, paramInt, (String)localObject1));
      }
      return false;
    }
    Object localObject2 = DomainConfig.getDomainConfig((String)localObject1);
    if (isDomainConfigCached((DomainConfig)localObject2, paramInt)) {
      return true;
    }
    if ((localObject2 != null) && (!TextUtils.isEmpty(((DomainConfig)localObject2).host)))
    {
      if (this.appConfig.config != null)
      {
        localObject1 = this.appConfig.config.requestDomainList;
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt == 4) {
                localObject1 = this.appConfig.config.businessDomainList;
              }
            }
            else {
              localObject1 = this.appConfig.config.uploadFileDomainList;
            }
          }
          else {
            localObject1 = this.appConfig.config.downloadFileDomainList;
          }
        }
        else {
          localObject1 = this.appConfig.config.socketDomainList;
        }
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject3 = (String)((Iterator)localObject1).next();
            try
            {
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                localObject3 = DomainConfig.getDomainConfig(((String)localObject3).toLowerCase(), true);
                if (DomainConfig.isDomainConfigMatch((DomainConfig)localObject3, (DomainConfig)localObject2))
                {
                  putDomainConfigToCache((DomainConfig)localObject2, paramInt);
                  return true;
                }
                localStringBuilder3 = new StringBuilder();
                localStringBuilder3.append("request:");
                localStringBuilder3.append(localObject2);
                localStringBuilder3.append(",allow:");
                localStringBuilder3.append(localObject3);
                QLog.i("[mini] http.domainValid", 1, localStringBuilder3.toString());
              }
            }
            catch (Throwable localThrowable2)
            {
              StringBuilder localStringBuilder3 = new StringBuilder();
              localStringBuilder3.append("check domainValid error, requestUrl:");
              localStringBuilder3.append(paramString);
              QLog.e("[mini] http.domainValid", 1, localStringBuilder3.toString(), localThrowable2);
            }
          }
        }
      }
      localObject1 = getDomainWhiteList();
      try
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (DomainConfig.isDomainMatchRfc2019((String)((Iterator)localObject1).next(), (DomainConfig)localObject2))
          {
            putDomainConfigToCache((DomainConfig)localObject2, paramInt);
            return true;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("check domainValid error, requestUrl:");
        localStringBuilder2.append(paramString);
        QLog.e("[mini] http.domainValid", 1, localStringBuilder2.toString(), localThrowable1);
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(DOMAIN_NAME_LIST[paramInt]);
    localStringBuilder1.append(":Invalid domain, please config requestUrl: ");
    localStringBuilder1.append(paramString);
    GameLog.vconsoleLog(localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(DOMAIN_NAME_LIST[paramInt]);
    localStringBuilder1.append(":Invalid domain, please config requestUrl: ");
    localStringBuilder1.append(paramString);
    QLog.e("[mini] http.domainValid", 1, localStringBuilder1.toString());
    if (!isOnlineVersion())
    {
      paramString = new StringBuilder();
      paramString.append(DOMAIN_NAME_LIST[paramInt]);
      paramString.append(" invalid domain, please config ");
      paramString.append(localObject2);
      GameLog.vconsoleLog(paramString.toString());
      AppBrandTask.runTaskOnUiThread(new ApkgBaseInfo.2(this, paramInt, (DomainConfig)localObject2));
    }
    return false;
  }
  
  public boolean isEngineTypeMiniApp()
  {
    MiniAppConfig localMiniAppConfig = this.appConfig;
    if ((localMiniAppConfig != null) && (localMiniAppConfig.config != null)) {
      return this.appConfig.config.isEngineTypeMiniApp();
    }
    return false;
  }
  
  public boolean isEngineTypeMiniGame()
  {
    MiniAppConfig localMiniAppConfig = this.appConfig;
    if ((localMiniAppConfig != null) && (localMiniAppConfig.config != null)) {
      return this.appConfig.config.isEngineTypeMiniGame();
    }
    return false;
  }
  
  public boolean isUdpIpValid(String paramString)
  {
    Object localObject = this.appConfig;
    int i = 0;
    if (localObject != null)
    {
      if (((MiniAppConfig)localObject).config == null) {
        return false;
      }
      if (this.appConfig.config.skipDomainCheck == 1) {
        i = 1;
      }
      if (i != 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("udp ip检查 skip: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("[mini] http.udp", 1, ((StringBuilder)localObject).toString());
        return true;
      }
      if (this.mUdpIpWhiteSet == null) {
        try
        {
          if (this.mUdpIpWhiteSet == null) {
            this.mUdpIpWhiteSet = new HashSet(this.appConfig.config.udpIpList);
          }
        }
        finally {}
      }
      boolean bool = this.mUdpIpWhiteSet.contains(paramString);
      if ((!bool) && (!isOnlineVersion()) && (getEnableDebug()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("debug opened and not online version, skip:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("[mini] http.udp", 1, ((StringBuilder)localObject).toString());
        AppBrandTask.runTaskOnUiThread(new ApkgBaseInfo.3(this, paramString));
        return true;
      }
      return bool;
    }
    return false;
  }
  
  public abstract boolean isUrlResReady(String paramString);
  
  public boolean isValidPrefix(String paramString, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramBoolean = bool1;
        if (paramString.startsWith("https://")) {
          break label66;
        }
        paramBoolean = bool1;
        if (paramString.startsWith("wss://")) {
          break label66;
        }
        paramBoolean = bool1;
        if (paramString.startsWith("ws://")) {
          break label66;
        }
        if (paramString.startsWith("http://")) {
          return true;
        }
      }
      paramBoolean = false;
      label66:
      return paramBoolean;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramBoolean = bool2;
      if (paramString.startsWith("https://")) {
        return paramBoolean;
      }
      if (paramString.startsWith("wss://")) {
        return true;
      }
    }
    paramBoolean = false;
    return paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appId:");
    localStringBuilder.append(this.appId);
    localStringBuilder.append(", name:");
    localStringBuilder.append(this.apkgName);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgBaseInfo
 * JD-Core Version:    0.7.0.1
 */