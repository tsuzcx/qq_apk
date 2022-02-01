package com.tencent.mobileqq.utils.confighandler;

import amtj;
import android.content.SharedPreferences;
import bfzh;
import bgav;
import bgay;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public abstract class NormalConfigHandler<T extends ConfigInfo>
  extends ConfigHandler<T>
{
  T mConfig;
  Object mLock_Config = new Object();
  public ReadConfigTask<T> mReadConfigTask;
  String mSPKey_Config;
  String mSPKey_Ver;
  String mSPName;
  
  public NormalConfigHandler(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramString1, paramString2);
    this.mSPName = paramString3;
    this.mSPKey_Config = paramString4;
    this.mSPKey_Ver = paramString5;
  }
  
  private SharedPreferences getSP()
  {
    if ((AudioHelper.e()) && (this.mSPName == null)) {
      throw new IllegalArgumentException(this.TAG + "mSPName为空");
    }
    return bgay.a(this.TAG, this.mUin, this.mSPName);
  }
  
  public T getConfig()
  {
    if ((this.mConfig == null) && (AudioHelper.e()))
    {
      QLog.w(this.TAG, 1, "getConfig, 配置还未初始化", new Throwable("打印调用栈"));
      throw new IllegalArgumentException(amtj.a(2131706702));
    }
    return this.mConfig;
  }
  
  public T getConfigDirect()
  {
    if (this.mConfig == null) {
      setConfig(ConfigHandler.getConfigInfo(this.TAG, null, 0, getConfigInfoClass(), this.mUin, this.mSPName, this.mSPKey_Config, this.mSPKey_Ver));
    }
    return this.mConfig;
  }
  
  protected int getConfigID()
  {
    return 0;
  }
  
  public int getConfigVer()
  {
    if ((AudioHelper.e()) && (this.mSPKey_Config == null)) {
      throw new IllegalArgumentException(this.TAG + "mSPKey_Config为空");
    }
    return getConfigVer(getSP(), this.mSPKey_Config, this.mSPKey_Ver);
  }
  
  public boolean isConfigReady()
  {
    for (;;)
    {
      synchronized (this.mLock_Config)
      {
        if (this.mConfig != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void saveConfig(String paramString, int paramInt)
  {
    if ((AudioHelper.e()) && (this.mSPKey_Config == null)) {
      throw new IllegalArgumentException(this.TAG + "mSPKey_Config为空");
    }
    SharedPreferences localSharedPreferences = getSP();
    saveConfigSP(this.TAG, localSharedPreferences, paramString, paramInt, this.mSPKey_Config, this.mSPKey_Ver);
  }
  
  public boolean setConfig(T paramT)
  {
    synchronized (this.mLock_Config)
    {
      this.mReadConfigTask = null;
      if (this.mConfig == paramT) {
        return false;
      }
      if ((this.mConfig != null) && (paramT != null) && (this.mConfig.serverVer == paramT.serverVer)) {
        return false;
      }
    }
    this.mConfig = paramT;
    return true;
  }
  
  public ReadConfigTask<T> syncGetConfigInfo(AppInterface paramAppInterface, NormalConfigHandler.GetConfigListen<T> paramGetConfigListen)
  {
    Object localObject2 = this.mReadConfigTask;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ReadConfigTask(this.TAG, this.mUin, paramAppInterface, getConfigInfoClass());
      ((ReadConfigTask)localObject1).setSPInfo(getConfigID(), this.mSPName, this.mSPKey_Config, this.mSPKey_Ver);
      this.mReadConfigTask = ((ReadConfigTask)localObject1);
    }
    if (((ReadConfigTask)localObject1).isNeedRunTask())
    {
      QLog.w(this.TAG, 1, "异步加载config[" + ((ReadConfigTask)localObject1).TAG + "]");
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      bfzh.requestSyncTask(null, (ArrayList)localObject2, new bgav(this, paramGetConfigListen, paramAppInterface));
      return localObject1;
    }
    QLog.w(this.TAG, 1, "异步加载config[" + ((ReadConfigTask)localObject1).TAG + "], 已经在加载中");
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.NormalConfigHandler
 * JD-Core Version:    0.7.0.1
 */