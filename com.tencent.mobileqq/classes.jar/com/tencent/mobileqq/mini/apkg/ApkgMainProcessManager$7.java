package com.tencent.mobileqq.mini.apkg;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ApkgMainProcessManager$7
  implements ApkgManager.OnInitApkgListener
{
  ApkgMainProcessManager$7(ApkgMainProcessManager paramApkgMainProcessManager, MiniAppConfig paramMiniAppConfig) {}
  
  public void onInitApkgInfo(int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    paramString = new StringBuilder().append("load apkg in main process end ");
    if (paramApkgInfo != null) {}
    for (paramApkgInfo = paramApkgInfo.appConfig;; paramApkgInfo = "")
    {
      QLog.d("ApkgMainProcessManager", 2, new Object[] { "onInitApkgInfo ", paramApkgInfo });
      paramApkgInfo = (List)ApkgMainProcessManager.access$000(this.this$0).remove(this.val$miniAppConfig.config.appId);
      if (paramApkgInfo == null) {
        break;
      }
      paramApkgInfo = paramApkgInfo.iterator();
      while (paramApkgInfo.hasNext())
      {
        paramString = (CmdCallback)paramApkgInfo.next();
        if (paramString != null) {
          try
          {
            paramString.onCmdResult(true, new Bundle());
          }
          catch (RemoteException paramString)
          {
            paramString.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager.7
 * JD-Core Version:    0.7.0.1
 */