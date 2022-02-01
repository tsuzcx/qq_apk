package com.tencent.mobileqq.mini.apkg;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ApkgMainProcessManager$7
  implements ApkgManager.OnInitApkgListener
{
  ApkgMainProcessManager$7(ApkgMainProcessManager paramApkgMainProcessManager, MiniAppConfig paramMiniAppConfig, long paramLong) {}
  
  public void onInitApkgInfo(int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    paramString = new StringBuilder().append("load apkg in main process end ");
    if (paramApkgInfo != null) {}
    for (paramApkgInfo = paramApkgInfo.appConfig;; paramApkgInfo = "")
    {
      QLog.d("ApkgMainProcessManager", 2, new Object[] { "onInitApkgInfo ", paramApkgInfo });
      paramString = (List)ApkgMainProcessManager.access$000(this.this$0).remove(this.val$miniAppConfig.config.appId);
      if (paramString == null) {
        break;
      }
      paramApkgInfo = new Bundle();
      paramApkgInfo.putLong("DOWNLOAD_TIME_MS", SystemClock.uptimeMillis() - this.val$start);
      paramApkgInfo.putBoolean("HAS_DOWNLOAD", true);
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        CmdCallback localCmdCallback = (CmdCallback)paramString.next();
        if (localCmdCallback != null) {
          try
          {
            localCmdCallback.onCmdResult(true, paramApkgInfo);
          }
          catch (RemoteException localRemoteException)
          {
            localRemoteException.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager.7
 * JD-Core Version:    0.7.0.1
 */