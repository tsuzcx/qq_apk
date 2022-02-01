package com.tencent.mobileqq.utils.confighandler;

import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.SyncLoadTask;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ReadConfigTask<T extends ConfigInfo>
  extends SyncLoadTask
{
  int mConfigID = 0;
  public T mConfigInfo;
  Class<T> mConfigInfoClass;
  WeakReference<AppInterface> mRefApp;
  String mSPKey_Config;
  String mSPKey_Ver;
  String mSPName;
  final String mUin;
  
  ReadConfigTask(String paramString1, String paramString2, AppInterface paramAppInterface, Class<T> paramClass)
  {
    super(paramString1);
    this.mUin = paramString2;
    this.mRefApp = new WeakReference(paramAppInterface);
    this.mConfigInfoClass = paramClass;
  }
  
  public void innerClean()
  {
    this.mConfigInfo = null;
  }
  
  public boolean runOnSubThread(Resources paramResources)
  {
    paramResources = this.mConfigInfoClass;
    if (this.mConfigID != 0) {
      this.mConfigInfo = ConfigHandler.getConfigInfoNew(this.mTAG, null, this.mConfigID, paramResources, this.mUin);
    } else {
      this.mConfigInfo = ConfigHandler.getConfigInfo(this.mTAG, null, 0, paramResources, this.mUin, this.mSPName, this.mSPKey_Config, this.mSPKey_Ver);
    }
    paramResources = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadConfigTask,ConfigInfo[");
    localStringBuilder.append(this.mConfigInfo);
    localStringBuilder.append("]");
    QLog.w(paramResources, 1, localStringBuilder.toString());
    QQAudioHelper.b((AppInterface)this.mRefApp.get());
    return true;
  }
  
  void setSPInfo(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.mConfigID = paramInt;
    this.mSPName = paramString1;
    this.mSPKey_Config = paramString2;
    this.mSPKey_Ver = paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.ReadConfigTask
 * JD-Core Version:    0.7.0.1
 */