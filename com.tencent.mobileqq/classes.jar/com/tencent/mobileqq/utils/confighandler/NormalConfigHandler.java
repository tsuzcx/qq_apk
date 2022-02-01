package com.tencent.mobileqq.utils.confighandler;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.SyncLoadTask;
import com.tencent.mobileqq.utils.configsp.BaseConfigSP;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public abstract class NormalConfigHandler<T extends ConfigInfo>
  extends ConfigHandler<T>
{
  T mConfig;
  Object mLock_Config = new Object();
  ReadConfigTask<T> mReadConfigTask;
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
    if ((QQAudioHelper.b()) && (this.mSPName == null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.TAG);
      localStringBuilder.append("mSPName为空");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return BaseConfigSP.a(this.TAG, this.mUin, this.mSPName);
  }
  
  public T getConfig()
  {
    if ((this.mConfig == null) && (QQAudioHelper.b()))
    {
      QLog.w(this.TAG, 1, "getConfig, 配置还未初始化", new Throwable("打印调用栈"));
      throw new IllegalArgumentException(HardCodeUtil.a(2131905419));
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
    if ((QQAudioHelper.b()) && (this.mSPKey_Config == null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.TAG);
      localStringBuilder.append("mSPKey_Config为空");
      throw new IllegalArgumentException(localStringBuilder.toString());
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
    if ((QQAudioHelper.b()) && (this.mSPKey_Config == null))
    {
      paramString = new StringBuilder();
      paramString.append(this.TAG);
      paramString.append("mSPKey_Config为空");
      throw new IllegalArgumentException(paramString.toString());
    }
    SharedPreferences localSharedPreferences = getSP();
    saveConfigSP(this.TAG, localSharedPreferences, paramString, paramInt, this.mSPKey_Config, this.mSPKey_Ver);
  }
  
  boolean setConfig(T paramT)
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
      this.mConfig = paramT;
      return true;
    }
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
      localObject2 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("异步加载config[");
      localStringBuilder.append(((ReadConfigTask)localObject1).mTAG);
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString());
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      SyncLoadTask.requestSyncTask(null, (ArrayList)localObject2, new NormalConfigHandler.1(this, paramGetConfigListen, paramAppInterface));
      return localObject1;
    }
    paramAppInterface = this.TAG;
    paramGetConfigListen = new StringBuilder();
    paramGetConfigListen.append("异步加载config[");
    paramGetConfigListen.append(((ReadConfigTask)localObject1).mTAG);
    paramGetConfigListen.append("], 已经在加载中");
    QLog.w(paramAppInterface, 1, paramGetConfigListen.toString());
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.NormalConfigHandler
 * JD-Core Version:    0.7.0.1
 */