package com.tencent.qqmini.minigame.gpkg;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ApkgMainProcessManager$6
  implements GpkgManager.OnInitGpkgListener
{
  ApkgMainProcessManager$6(ApkgMainProcessManager paramApkgMainProcessManager, MiniAppInfo paramMiniAppInfo) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    Object localObject = (List)ApkgMainProcessManager.access$000(this.this$0).get(this.val$miniAppConfig.appId);
    if (localObject != null)
    {
      paramMiniAppInfo = new Bundle();
      paramMiniAppInfo.putFloat("PROGRESS", paramFloat);
      paramMiniAppInfo.putLong("TOTAL_SIZE", paramLong);
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      MiniCmdCallback localMiniCmdCallback;
      if (((Iterator)localObject).hasNext())
      {
        localMiniCmdCallback = (MiniCmdCallback)((Iterator)localObject).next();
        if (localMiniCmdCallback == null) {}
      }
      else
      {
        try
        {
          localMiniCmdCallback.onCmdResult(false, paramMiniAppInfo);
        }
        catch (RemoteException localRemoteException) {}
        return;
      }
    }
  }
  
  public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString, @Nullable GpkgManager.Info paramInfo)
  {
    paramMiniGamePkg = new StringBuilder();
    paramMiniGamePkg.append("onInitGpkgInfo load gpkg in main process end ");
    paramMiniGamePkg.append(this.val$miniAppConfig);
    QMLog.d("ApkgMainProcessManager", paramMiniGamePkg.toString());
    paramMiniGamePkg = (List)ApkgMainProcessManager.access$000(this.this$0).remove(this.val$miniAppConfig.appId);
    if (paramMiniGamePkg != null) {
      paramMiniGamePkg = paramMiniGamePkg.iterator();
    }
    for (;;)
    {
      if (paramMiniGamePkg.hasNext())
      {
        paramInfo = (MiniCmdCallback)paramMiniGamePkg.next();
        if (paramInfo == null) {}
      }
      else
      {
        try
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("retCode", paramInt);
          localBundle.putString("errMsg", paramString);
          paramInfo.onCmdResult(true, localBundle);
        }
        catch (RemoteException paramInfo) {}
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.ApkgMainProcessManager.6
 * JD-Core Version:    0.7.0.1
 */