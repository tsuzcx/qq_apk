package com.tencent.mobileqq.qwallet.preload.impl;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class PreloadStaticApiImpl
  implements IPreloadStaticApi
{
  private static final int SAFE_FREE_SPACE = 52428800;
  private static final String TAG = "PreloadStaticApi";
  
  public void deleteRes(String paramString, boolean paramBoolean, int paramInt)
  {
    ResourceInfo localResourceInfo = getResInfoByUrl(paramString, paramBoolean, paramInt);
    if (localResourceInfo != null)
    {
      ResUtil.b(paramString, paramInt);
      QWalletTools.a(localResourceInfo.filePath);
      QWalletTools.a(localResourceInfo.folderPath);
    }
  }
  
  public String getConfigFromQQ(String paramString)
  {
    Object localObject3 = MobileQQ.sMobileQQ;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((BaseApplication)localObject3).getSharedPreferences("qwallet_preload_config", 4);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("config_from_qq");
        ((StringBuilder)localObject1).append(paramString);
        localObject1 = ((SharedPreferences)localObject3).getString(((StringBuilder)localObject1).toString(), null);
      }
    }
    return localObject1;
  }
  
  public String getFolderPathByMD5AndUrl(String paramString1, String paramString2, int paramInt)
  {
    return PreloadResourceImpl.getFolderPathByMD5AndUrl(paramString1, paramString2, paramInt);
  }
  
  public IPreloadServiceAbs getInstance()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime instanceof AppInterface)) {
      return (IPreloadServiceAbs)localAppRuntime.getRuntimeService(IPreloadService.class, "");
    }
    return (IPreloadServiceAbs)localAppRuntime.getRuntimeService(IPreloadServiceProxy.class, "multi");
  }
  
  public String getRealMd5(String paramString1, String paramString2, int paramInt)
  {
    return ResUtil.b(paramString1, paramString2, paramInt);
  }
  
  public ResourceInfo getResInfoByUrl(String paramString, boolean paramBoolean, int paramInt)
  {
    ResourceInfo localResourceInfo = ResUtil.a(paramString, paramBoolean, 0, paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getResInfoByUrl :");
      localStringBuilder.append(paramString);
      localStringBuilder.append("|");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("|");
      localStringBuilder.append(localResourceInfo);
      QLog.d("PreloadStaticApi", 2, localStringBuilder.toString());
    }
    return localResourceInfo;
  }
  
  public IPreloadService.PathResult getResPathSync(DownloadParam paramDownloadParam)
  {
    boolean bool = QWalletHelperImpl.getAppRuntime() instanceof BaseQQAppInterface;
    Object localObject2 = null;
    if (bool)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getResPathSync: param");
        ((StringBuilder)localObject1).append(paramDownloadParam);
        QLog.d("PreloadServiceImpl", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = localObject2;
      if (paramDownloadParam != null)
      {
        if (TextUtils.isEmpty(paramDownloadParam.url)) {
          return null;
        }
        paramDownloadParam.standardlize();
        ResourceInfo localResourceInfo = getResInfoByUrl(paramDownloadParam.url, paramDownloadParam.isForceUnzip, paramDownloadParam.filePos);
        localObject1 = localObject2;
        if (isFileValid(localResourceInfo, paramDownloadParam))
        {
          localObject1 = new IPreloadService.PathResult();
          ((IPreloadService.PathResult)localObject1).url = paramDownloadParam.url;
          ((IPreloadService.PathResult)localObject1).filePath = localResourceInfo.filePath;
          ((IPreloadService.PathResult)localObject1).folderPath = localResourceInfo.folderPath;
          ((IPreloadService.PathResult)localObject1).isAlreadyExist = true;
        }
      }
      return localObject1;
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("method_type", 4);
    ((Bundle)localObject1).putSerializable("download_params", paramDownloadParam);
    paramDownloadParam = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "preloadCommon", (Bundle)localObject1);
    if ((paramDownloadParam != null) && (paramDownloadParam.isSuccess()) && (paramDownloadParam.data != null)) {}
    try
    {
      paramDownloadParam = (IPreloadService.PathResult)paramDownloadParam.data.getSerializable("path_result");
      return paramDownloadParam;
    }
    catch (Throwable paramDownloadParam) {}
    return null;
    return null;
  }
  
  public String getResourcePathByUrl(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = PreloadStaticApi.b(paramString, paramInt);
      if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
      {
        ResUtil.a(paramString, paramInt, NetConnInfoCenter.getServerTimeMillis());
        return str;
      }
    }
    return null;
  }
  
  public String getUnzipFolderPath(String paramString)
  {
    paramString = ResUtil.a(paramString, false, 0, 0);
    if (paramString != null) {
      return paramString.folderPath;
    }
    return null;
  }
  
  public boolean isDiskEnoughToUnzip(String paramString)
  {
    Object localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    long l1 = 0L;
    if (!TextUtils.isEmpty(paramString))
    {
      long l2 = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).StorageManager$getFreeSpace(paramString);
      l1 = l2;
      if (l2 > 52428800L)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("isDiskEnoughToUnzip|true|");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("|");
          ((StringBuilder)localObject).append(l2);
          QLog.d("PreloadStaticApi", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isDiskEnoughToUnzip|false|");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(l1);
      QLog.d("PreloadStaticApi", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public boolean isFileValid(ResourceInfo paramResourceInfo, DownloadParam paramDownloadParam)
  {
    if (paramDownloadParam == null) {
      return false;
    }
    if (paramResourceInfo != null)
    {
      if (TextUtils.isEmpty(paramResourceInfo.filePath)) {
        return false;
      }
      String str = paramDownloadParam.md5;
      if ((!TextUtils.isEmpty(str)) && (paramDownloadParam.useQWalletConfig))
      {
        l = 0L;
        paramDownloadParam.md5Time = 0L;
        Object localObject = QWalletTools.a();
        if (localObject != null)
        {
          localObject = (IQWalletConfigService)((BaseQQAppInterface)localObject).getRuntimeService(IQWalletConfigService.class, "");
          if (localObject != null) {
            l = ((IQWalletConfigService)localObject).getLastReqTime();
          }
          paramDownloadParam.md5Time = l;
        }
      }
      long l = paramDownloadParam.md5Time;
      boolean bool = paramDownloadParam.isForceUnzip;
      paramDownloadParam = paramDownloadParam.md5ForChecked;
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramResourceInfo.filePath)) && (!str.equalsIgnoreCase(paramResourceInfo.fileMd5)) && (paramResourceInfo.doneTime < l)) {
        return false;
      }
      if ((!TextUtils.isEmpty(paramDownloadParam)) && (!TextUtils.isEmpty(paramResourceInfo.filePath)) && (!paramDownloadParam.equalsIgnoreCase(paramResourceInfo.fileMd5))) {
        return false;
      }
      if ((!bool) && (!isNeedAutoUnzip(paramResourceInfo.url, 0))) {
        return true;
      }
      if (!TextUtils.isEmpty(paramResourceInfo.folderPath)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isFolderPathValid(String paramString)
  {
    return PreloadResourceImpl.isFolderPathValid(paramString);
  }
  
  public boolean isNeedAutoUnzip(String paramString, int paramInt)
  {
    return (paramInt == 4) || ((paramString != null) && (paramString.length() > 5) && (paramString.substring(paramString.length() - 4).equals(".zip")));
  }
  
  public boolean unzipAtomically(String paramString1, String paramString2)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        if (isDiskEnoughToUnzip(paramString2))
        {
          boolean bool = QWalletTools.a(paramString1, paramString2);
          return bool;
        }
        return false;
      }
      return false;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadStaticApiImpl
 * JD-Core Version:    0.7.0.1
 */