package com.tencent.mobileqq.mini.apkg;

import albw;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ApkgConfigHolder
  implements Serializable
{
  private static final String CONFIG_NAME = ".ApkgConfigs";
  private static final String TAG = "ApkgConfigHolder";
  private static final long serialVersionUID = 1L;
  private Map<String, ApkgConfigHolder.ApkgConfigWrapper> mApkgConfigs = new HashMap();
  private Map<String, ApkgConfigHolder.ApkgConfigWrapper> mDebugApkgConfigs = new HashMap();
  private transient byte[] mSaveLock;
  private transient String mSavePath;
  
  private static String getConfigPath(AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramAppRuntime.getApplication().getFilesDir().getPath());
    localStringBuilder.append("/mini/").append(paramAppRuntime.getAccount()).append("/");
    localStringBuilder.append(".ApkgConfigs");
    return localStringBuilder.toString();
  }
  
  public static ApkgConfigHolder readConfig(QQAppInterface paramQQAppInterface)
  {
    String str = getConfigPath(paramQQAppInterface);
    try
    {
      paramQQAppInterface = (ApkgConfigHolder)albw.a(str);
      Object localObject = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        localObject = new ApkgConfigHolder();
      }
      ((ApkgConfigHolder)localObject).mSavePath = str;
      ((ApkgConfigHolder)localObject).mSaveLock = new byte[0];
      if (((ApkgConfigHolder)localObject).mDebugApkgConfigs == null) {
        ((ApkgConfigHolder)localObject).mDebugApkgConfigs = new HashMap();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApkgConfigHolder", 2, "readApkgConfigHolder:" + localObject);
      }
      return localObject;
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
        paramQQAppInterface = null;
      }
    }
  }
  
  public static void removeRes(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo != null)
    {
      PreloadManager.a(paramMiniAppInfo.downloadUrl, false, 0);
      FileUtils.delete(ApkgManager.getApkgFolderPath(paramMiniAppInfo), false);
    }
  }
  
  public MiniAppInfo getConfig(String paramString)
  {
    paramString = (ApkgConfigHolder.ApkgConfigWrapper)this.mApkgConfigs.get(paramString);
    if (paramString != null) {
      return paramString.apkgConfig;
    }
    return null;
  }
  
  public void saveConfig()
  {
    ThreadManager.getFileThreadHandler().post(new ApkgConfigHolder.1(this));
  }
  
  public void updateConfig(List<MiniAppInfo> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MiniAppInfo localMiniAppInfo = (MiniAppInfo)localIterator.next();
        if ((localMiniAppInfo != null) && (!TextUtils.isEmpty(localMiniAppInfo.appId))) {
          if (localMiniAppInfo.verType == 3)
          {
            paramList = (ApkgConfigHolder.ApkgConfigWrapper)this.mDebugApkgConfigs.get(localMiniAppInfo.appId);
            this.mDebugApkgConfigs.put(localMiniAppInfo.appId, new ApkgConfigHolder.ApkgConfigWrapper(localMiniAppInfo));
          }
          else
          {
            ApkgConfigHolder.ApkgConfigWrapper localApkgConfigWrapper = (ApkgConfigHolder.ApkgConfigWrapper)this.mApkgConfigs.get(localMiniAppInfo.appId);
            paramList = localApkgConfigWrapper;
            if (localApkgConfigWrapper == null)
            {
              paramList = new ApkgConfigHolder.ApkgConfigWrapper();
              this.mApkgConfigs.put(localMiniAppInfo.appId, new ApkgConfigHolder.ApkgConfigWrapper(localMiniAppInfo));
            }
            paramList.updateConfig(localMiniAppInfo);
          }
        }
      }
      saveConfig();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgConfigHolder
 * JD-Core Version:    0.7.0.1
 */