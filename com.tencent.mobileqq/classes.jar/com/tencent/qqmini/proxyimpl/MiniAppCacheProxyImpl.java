package com.tencent.qqmini.proxyimpl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoByIdEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoByLinkEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy.LinkData;
import common.config.service.QzoneConfig;
import java.util.List;
import mqq.app.AppRuntime;

@ProxyService(proxy=MiniAppCacheProxy.class)
public class MiniAppCacheProxyImpl
  implements MiniAppCacheProxy
{
  private MiniAppEntityManager a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (MiniAppEntityManager)localAppRuntime.getManager(QQManagerFactory.MINI_APP_ENTITY_MANAGER);
    }
    return new MiniAppEntityManager(localAppRuntime.getAccount());
  }
  
  public boolean deleteCacheByTimeStamp(long paramLong)
  {
    MiniAppEntityManager localMiniAppEntityManager = a();
    if (localMiniAppEntityManager != null) {
      localMiniAppEntityManager.checkDB();
    }
    return true;
  }
  
  public boolean enableMiniAppCache()
  {
    return false;
  }
  
  public long getDeleteIntervalTime()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_appinfoentity_interval_time", 172800000L);
  }
  
  public byte[] getIdInfo(String paramString1, String paramString2)
  {
    MiniAppEntityManager localMiniAppEntityManager = a();
    if (localMiniAppEntityManager != null)
    {
      paramString1 = localMiniAppEntityManager.queryEntity(MiniAppInfoByIdEntity.class, false, "appId=? and entryPath=? ", new String[] { paramString1, paramString2 }, null, null, null, null);
      if ((paramString1 != null) && (paramString1.size() == 1))
      {
        paramString1 = (MiniAppInfoByIdEntity)paramString1.get(0);
        if (paramString1 != null) {
          return paramString1.appInfo;
        }
      }
    }
    return null;
  }
  
  public MiniAppCacheProxy.LinkData getLinkInfo(String paramString, int paramInt)
  {
    Object localObject = a();
    if (localObject != null)
    {
      paramString = ((MiniAppEntityManager)localObject).queryEntity(MiniAppInfoByLinkEntity.class, false, "link=? and linkType=? ", new String[] { paramString, String.valueOf(paramInt) }, null, null, null, null);
      if ((paramString != null) && (paramString.size() == 1))
      {
        paramString = (MiniAppInfoByLinkEntity)paramString.get(0);
        if (paramString != null)
        {
          localObject = new MiniAppCacheProxy.LinkData();
          ((MiniAppCacheProxy.LinkData)localObject).setAppInfo(paramString.appInfo);
          ((MiniAppCacheProxy.LinkData)localObject).setShareTicket(paramString.shareTicket);
          return localObject;
        }
      }
    }
    return null;
  }
  
  public boolean saveIdInfo(String paramString1, String paramString2, byte[] paramArrayOfByte, long paramLong)
  {
    MiniAppInfoByIdEntity localMiniAppInfoByIdEntity = new MiniAppInfoByIdEntity();
    localMiniAppInfoByIdEntity.appId = paramString1;
    localMiniAppInfoByIdEntity.entryPath = paramString2;
    localMiniAppInfoByIdEntity.appInfo = paramArrayOfByte;
    localMiniAppInfoByIdEntity.timeStamp = paramLong;
    paramString1 = a();
    if ((paramString1 != null) && (paramString1.insertOrReplaceEntity(localMiniAppInfoByIdEntity)))
    {
      paramString1 = new StringBuilder();
      paramString1.append("saveIdInfo ok.");
      paramString1.append(localMiniAppInfoByIdEntity.appId);
      QLog.d("MiniAppCacheProxyImpl", 1, paramString1.toString());
      return true;
    }
    return false;
  }
  
  public boolean saveLinkInfo(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte, long paramLong)
  {
    MiniAppInfoByLinkEntity localMiniAppInfoByLinkEntity = new MiniAppInfoByLinkEntity();
    localMiniAppInfoByLinkEntity.link = paramString1;
    localMiniAppInfoByLinkEntity.linkType = paramInt;
    localMiniAppInfoByLinkEntity.shareTicket = paramString2;
    localMiniAppInfoByLinkEntity.appInfo = paramArrayOfByte;
    localMiniAppInfoByLinkEntity.timeStamp = paramLong;
    paramString1 = a();
    if ((paramString1 != null) && (paramString1.insertOrReplaceEntity(localMiniAppInfoByLinkEntity)))
    {
      paramString1 = new StringBuilder();
      paramString1.append("saveLinkInfo ok.");
      paramString1.append(localMiniAppInfoByLinkEntity.link);
      paramString1.append(" linkType:");
      paramString1.append(paramInt);
      QLog.d("MiniAppCacheProxyImpl", 1, paramString1.toString());
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppCacheProxyImpl
 * JD-Core Version:    0.7.0.1
 */