package com.tencent.mobileqq.qwallet.preload.impl;

import Wallet.ResInfo;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class PreloadBackControlConfig
  implements Serializable
{
  public static final String CONFIG_NAME = "back_config";
  private static final long serialVersionUID = 1L;
  private transient AppRuntime a;
  private int mConfigVersion;
  private ArrayList<ResInfo> mLastBackResInfos;
  
  public PreloadBackControlConfig(AppRuntime paramAppRuntime)
  {
    this.a = paramAppRuntime;
    this.mConfigVersion = 0;
  }
  
  public static String getConfigPath(AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PreloadStaticApi.a(paramAppRuntime));
    localStringBuilder.append("back_config");
    return localStringBuilder.toString();
  }
  
  public static PreloadBackControlConfig readBackControlConfig(AppRuntime paramAppRuntime)
  {
    try
    {
      localPreloadBackControlConfig = (PreloadBackControlConfig)QWalletTools.a(getConfigPath(paramAppRuntime));
    }
    catch (Exception localException)
    {
      PreloadBackControlConfig localPreloadBackControlConfig;
      label14:
      break label14;
    }
    localPreloadBackControlConfig = null;
    if (localPreloadBackControlConfig == null) {
      localPreloadBackControlConfig = new PreloadBackControlConfig(paramAppRuntime);
    } else {
      localPreloadBackControlConfig.a = paramAppRuntime;
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("readBackControlConfig:");
      paramAppRuntime.append(localPreloadBackControlConfig);
      QLog.d("BackControlConfig", 2, paramAppRuntime.toString());
    }
    return localPreloadBackControlConfig;
  }
  
  public ArrayList<ResInfo> getLastBackResInfos()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (this.mLastBackResInfos != null)
      {
        Iterator localIterator = this.mLastBackResInfos.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add((ResInfo)localIterator.next());
        }
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public boolean isLocalResNewest()
  {
    try
    {
      int i = QConfigManager.a().a(68, this.a.getLongAccountUin());
      int j = this.mConfigVersion;
      return i == j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BackControlConfig [mVersion=");
    localStringBuilder.append(this.mConfigVersion);
    localStringBuilder.append(", mLastRes=");
    localStringBuilder.append(this.mLastBackResInfos);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void update(ArrayList<ResInfo> paramArrayList)
  {
    try
    {
      this.mConfigVersion = QConfigManager.a().a(68, this.a.getLongAccountUin());
      this.mLastBackResInfos = paramArrayList;
      QWalletTools.a(this, getConfigPath(this.a));
      return;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadBackControlConfig
 * JD-Core Version:    0.7.0.1
 */