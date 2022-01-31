package com.tencent.mobileqq.utils.confighandler;

import android.content.res.Resources;
import baiq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ReadConfigTask<T extends ConfigInfo>
  extends baiq
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
    if (this.mConfigID != 0) {}
    for (this.mConfigInfo = ConfigHandler.getConfigInfoNew(this.TAG, null, this.mConfigID, paramResources, this.mUin);; this.mConfigInfo = ConfigHandler.getConfigInfo(this.TAG, null, 0, paramResources, this.mUin, this.mSPName, this.mSPKey_Config, this.mSPKey_Ver))
    {
      QLog.w(this.TAG, 1, "ReadConfigTask,ConfigInfo[" + this.mConfigInfo + "]");
      AudioHelper.a((AppInterface)this.mRefApp.get());
      return true;
    }
  }
  
  void setSPInfo(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.mConfigID = paramInt;
    this.mSPName = paramString1;
    this.mSPKey_Config = paramString2;
    this.mSPKey_Ver = paramString3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.ReadConfigTask
 * JD-Core Version:    0.7.0.1
 */