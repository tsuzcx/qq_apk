package com.tencent.qqmini.minigame.gpkg;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.ApkgManager.OnInitApkgListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ApkgMainProcessManager$5
  implements ApkgManager.OnInitApkgListener
{
  ApkgMainProcessManager$5(ApkgMainProcessManager paramApkgMainProcessManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void onInitApkgInfo(int paramInt, ApkgInfo paramApkgInfo, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onInitApkgInfo load apkg in main process end ");
    ((StringBuilder)localObject).append(paramApkgInfo);
    QMLog.d("ApkgMainProcessManager", ((StringBuilder)localObject).toString());
    paramApkgInfo = (List)ApkgMainProcessManager.access$000(this.this$0).remove(this.val$miniAppConfig.appId);
    if (paramApkgInfo != null)
    {
      paramApkgInfo = paramApkgInfo.iterator();
      while (paramApkgInfo.hasNext())
      {
        localObject = (MiniCmdCallback)paramApkgInfo.next();
        if (localObject != null) {
          try
          {
            Bundle localBundle = new Bundle();
            localBundle.putInt("retCode", paramInt);
            localBundle.putString("errMsg", paramString);
            ((MiniCmdCallback)localObject).onCmdResult(true, localBundle);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.ApkgMainProcessManager.5
 * JD-Core Version:    0.7.0.1
 */