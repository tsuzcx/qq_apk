package com.tencent.mobileqq.mini.push;

import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniCacheFreeManager;
import mqq.app.AppRuntime;

class ClearCacheAction$1
  implements ThreadExcutor.IThreadListener
{
  ClearCacheAction$1(ClearCacheAction paramClearCacheAction, String paramString) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    AppLoaderFactory.g().getMiniCacheFreeManager().freeCache(BaseApplicationImpl.getApplication().getRuntime().getAccount(), new MiniAppInfo(), false);
    QLog.d("ClearCacheAction", 1, "ClearCacheAction: appid:" + this.val$appId + " killSelf!!!");
    Process.killProcess(Process.myPid());
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.push.ClearCacheAction.1
 * JD-Core Version:    0.7.0.1
 */