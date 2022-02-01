package com.tencent.mobileqq.qwallet.preload.impl;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import mqq.app.AppRuntime;

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
    Object localObject2 = null;
    Object localObject3 = BaseApplicationImpl.getApplication();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((BaseApplicationImpl)localObject3).getSharedPreferences("qwallet_preload_config", 4);
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((SharedPreferences)localObject3).getString("config_from_qq" + paramString, null);
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
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
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
    if (QLog.isColorLevel()) {
      QLog.d("PreloadStaticApi", 2, "getResInfoByUrl :" + paramString + "|" + paramBoolean + "|" + localResourceInfo);
    }
    return localResourceInfo;
  }
  
  public IPreloadService.PathResult getResPathSync(DownloadParam paramDownloadParam)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadServiceImpl", 2, "getResPathSync: param" + paramDownloadParam);
      }
      if ((paramDownloadParam == null) || (TextUtils.isEmpty(paramDownloadParam.url))) {
        return null;
      }
      paramDownloadParam.standardlize();
      localObject = getResInfoByUrl(paramDownloadParam.url, paramDownloadParam.isForceUnzip, paramDownloadParam.filePos);
      if (isFileValid((ResourceInfo)localObject, paramDownloadParam))
      {
        IPreloadService.PathResult localPathResult = new IPreloadService.PathResult();
        localPathResult.url = paramDownloadParam.url;
        localPathResult.filePath = ((ResourceInfo)localObject).filePath;
        localPathResult.folderPath = ((ResourceInfo)localObject).folderPath;
        localPathResult.isAlreadyExist = true;
        return localPathResult;
      }
      return null;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("method_type", 4);
    ((Bundle)localObject).putSerializable("download_params", paramDownloadParam);
    paramDownloadParam = QIPCClientHelper.getInstance().getClient().callServer("QWalletIPCModule", "preloadCommon", (Bundle)localObject);
    if ((paramDownloadParam != null) && (paramDownloadParam.isSuccess()) && (paramDownloadParam.data != null)) {
      try
      {
        paramDownloadParam = (IPreloadService.PathResult)paramDownloadParam.data.getSerializable("path_result");
        return paramDownloadParam;
      }
      catch (Throwable paramDownloadParam) {}
    }
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
    ResourceInfo localResourceInfo = ResUtil.a(paramString, false, 0, 0);
    paramString = null;
    if (localResourceInfo != null) {
      paramString = localResourceInfo.folderPath;
    }
    return paramString;
  }
  
  public boolean isDiskEnoughToUnzip(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    long l1 = 0L;
    if (!TextUtils.isEmpty(paramString))
    {
      long l2 = StorageManager.a(paramString);
      l1 = l2;
      if (l2 > 52428800L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadStaticApi", 2, "isDiskEnoughToUnzip|true|" + paramString + "|" + l2);
        }
        return true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadStaticApi", 2, "isDiskEnoughToUnzip|false|" + paramString + "|" + l1);
    }
    return false;
  }
  
  public boolean isFileValid(ResourceInfo paramResourceInfo, DownloadParam paramDownloadParam)
  {
    if (paramDownloadParam == null) {
      return false;
    }
    if ((paramResourceInfo == null) || (TextUtils.isEmpty(paramResourceInfo.filePath))) {
      return false;
    }
    String str = paramDownloadParam.md5;
    Object localObject;
    if ((!TextUtils.isEmpty(str)) && (paramDownloadParam.useQWalletConfig))
    {
      paramDownloadParam.md5Time = 0L;
      localObject = QWalletTools.a();
      if (localObject != null)
      {
        localObject = (QWalletConfigManager)((QQAppInterface)localObject).getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
        if (localObject == null) {
          break label144;
        }
      }
    }
    boolean bool;
    label144:
    for (long l = ((QWalletConfigManager)localObject).a();; l = 0L)
    {
      paramDownloadParam.md5Time = l;
      l = paramDownloadParam.md5Time;
      bool = paramDownloadParam.isForceUnzip;
      paramDownloadParam = paramDownloadParam.md5ForChecked;
      if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramResourceInfo.filePath)) || (str.equalsIgnoreCase(paramResourceInfo.fileMd5)) || (paramResourceInfo.doneTime >= l)) {
        break;
      }
      return false;
    }
    if ((!TextUtils.isEmpty(paramDownloadParam)) && (!TextUtils.isEmpty(paramResourceInfo.filePath)) && (!paramDownloadParam.equalsIgnoreCase(paramResourceInfo.fileMd5))) {
      return false;
    }
    if ((bool) || (isNeedAutoUnzip(paramResourceInfo.url, 0)))
    {
      if (!TextUtils.isEmpty(paramResourceInfo.folderPath)) {
        return true;
      }
    }
    else {
      return true;
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
  
  /* Error */
  public boolean unzipAtomically(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: iload 4
    //   7: istore_3
    //   8: aload_1
    //   9: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +15 -> 27
    //   15: aload_2
    //   16: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: istore_3
    //   20: iload_3
    //   21: ifeq +10 -> 31
    //   24: iload 4
    //   26: istore_3
    //   27: aload_0
    //   28: monitorexit
    //   29: iload_3
    //   30: ireturn
    //   31: iload 4
    //   33: istore_3
    //   34: aload_0
    //   35: aload_2
    //   36: invokevirtual 334	com/tencent/mobileqq/qwallet/preload/impl/PreloadStaticApiImpl:isDiskEnoughToUnzip	(Ljava/lang/String;)Z
    //   39: ifeq -12 -> 27
    //   42: aload_1
    //   43: aload_2
    //   44: invokestatic 336	com/tencent/mobileqq/activity/qwallet/utils/QWalletTools:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   47: istore_3
    //   48: goto -21 -> 27
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	PreloadStaticApiImpl
    //   0	56	1	paramString1	String
    //   0	56	2	paramString2	String
    //   7	41	3	bool1	boolean
    //   1	31	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   8	20	51	finally
    //   34	48	51	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadStaticApiImpl
 * JD-Core Version:    0.7.0.1
 */