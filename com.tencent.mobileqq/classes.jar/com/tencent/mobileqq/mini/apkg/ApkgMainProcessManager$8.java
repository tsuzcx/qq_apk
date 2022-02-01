package com.tencent.mobileqq.mini.apkg;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager.Info;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager.OnInitGpkgListener;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ApkgMainProcessManager$8
  implements GpkgManager.OnInitGpkgListener
{
  ApkgMainProcessManager$8(ApkgMainProcessManager paramApkgMainProcessManager, MiniAppConfig paramMiniAppConfig, long paramLong) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    Object localObject = (List)ApkgMainProcessManager.access$000(this.this$0).get(this.val$miniAppConfig.config.appId);
    if (localObject != null)
    {
      paramMiniAppInfo = new Bundle();
      paramMiniAppInfo.putFloat("PROGRESS", paramFloat);
      paramMiniAppInfo.putLong("TOTAL_SIZE", paramLong);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CmdCallback localCmdCallback = (CmdCallback)((Iterator)localObject).next();
        if (localCmdCallback != null) {
          try
          {
            localCmdCallback.onCmdResult(false, paramMiniAppInfo);
          }
          catch (RemoteException localRemoteException) {}
        }
      }
    }
  }
  
  public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString, GpkgManager.Info paramInfo)
  {
    QLog.d("ApkgMainProcessManager", 2, new Object[] { "onInitGpkgInfo ", "load gpkg in main process end " + this.val$miniAppConfig });
    paramString = (List)ApkgMainProcessManager.access$000(this.this$0).remove(this.val$miniAppConfig.config.appId);
    if (paramString != null)
    {
      paramMiniGamePkg = new Bundle();
      paramMiniGamePkg.putLong("DOWNLOAD_TIME_MS", SystemClock.uptimeMillis() - this.val$start);
      paramMiniGamePkg.putBoolean("HAS_DOWNLOAD", true);
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        paramInfo = (CmdCallback)paramString.next();
        if (paramInfo != null) {
          try
          {
            paramInfo.onCmdResult(true, paramMiniGamePkg);
          }
          catch (RemoteException paramInfo) {}
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager.8
 * JD-Core Version:    0.7.0.1
 */