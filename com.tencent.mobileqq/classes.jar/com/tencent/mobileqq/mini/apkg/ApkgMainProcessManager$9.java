package com.tencent.mobileqq.mini.apkg;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager.Info;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager.OnInitGpkgListener;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ApkgMainProcessManager$9
  implements GpkgManager.OnInitGpkgListener
{
  ApkgMainProcessManager$9(ApkgMainProcessManager paramApkgMainProcessManager, MiniAppConfig paramMiniAppConfig) {}
  
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
    paramMiniGamePkg = (List)ApkgMainProcessManager.access$000(this.this$0).remove(this.val$miniAppConfig.config.appId);
    if (paramMiniGamePkg != null)
    {
      paramMiniGamePkg = paramMiniGamePkg.iterator();
      while (paramMiniGamePkg.hasNext())
      {
        paramString = (CmdCallback)paramMiniGamePkg.next();
        if (paramString != null) {
          try
          {
            paramString.onCmdResult(true, new Bundle());
          }
          catch (RemoteException paramString) {}
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.ApkgMainProcessManager.9
 * JD-Core Version:    0.7.0.1
 */