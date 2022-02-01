package com.tencent.qqmini.minigame.gpkg;

import android.support.annotation.Nullable;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniGamePluginInfo;

final class GpkgManager$MergedOnInitListener
  implements GpkgManager.DownloadPluginCallback, GpkgManager.OnInitGpkgListener
{
  private MiniAppInfo mGameConfig;
  private boolean mGpkgDone;
  private GpkgManager.Info mGpkgDownloadInfo;
  private String mGpkgErrorMsg;
  private MiniGamePkg mGpkgPkg;
  private int mGpkgResCode;
  private final GpkgManager.OnInitGpkgListener mMergedResultListener;
  private boolean mPluginDone;
  private GpkgManager.Info mPluginDownloadInfo;
  private Throwable mPluginError;
  private boolean mPluginSuccess;
  
  GpkgManager$MergedOnInitListener(MiniAppInfo paramMiniAppInfo, GpkgManager.OnInitGpkgListener paramOnInitGpkgListener)
  {
    this.mGameConfig = paramMiniAppInfo;
    this.mMergedResultListener = paramOnInitGpkgListener;
  }
  
  private void handleFinish()
  {
    if ((this.mGpkgDone) && (this.mPluginDone))
    {
      Object localObject = this.mGpkgDownloadInfo;
      if (localObject != null) {
        ((GpkgManager.Info)localObject).plugin = this.mPluginDownloadInfo;
      }
      if (!this.mPluginSuccess)
      {
        GpkgManager.OnInitGpkgListener localOnInitGpkgListener = this.mMergedResultListener;
        MiniGamePkg localMiniGamePkg = this.mGpkgPkg;
        localObject = this.mPluginError;
        if (localObject != null) {
          localObject = ((Throwable)localObject).getMessage();
        } else {
          localObject = "download plugin fail";
        }
        localOnInitGpkgListener.onInitGpkgInfo(2022, localMiniGamePkg, (String)localObject, this.mGpkgDownloadInfo);
      }
      this.mMergedResultListener.onInitGpkgInfo(this.mGpkgResCode, this.mGpkgPkg, this.mGpkgErrorMsg, this.mGpkgDownloadInfo);
    }
  }
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    this.mMergedResultListener.onDownloadGpkgProgress(paramMiniAppInfo, paramFloat, paramLong);
  }
  
  public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString, GpkgManager.Info paramInfo)
  {
    try
    {
      this.mGpkgDone = true;
      this.mGpkgResCode = paramInt;
      this.mGpkgPkg = paramMiniGamePkg;
      this.mGpkgErrorMsg = paramString;
      this.mGpkgDownloadInfo = paramInfo;
      handleFinish();
      return;
    }
    finally
    {
      paramMiniGamePkg = finally;
      throw paramMiniGamePkg;
    }
  }
  
  public void onPluginDownloadComplete(boolean paramBoolean, @Nullable Throwable paramThrowable, GpkgManager.Info paramInfo)
  {
    try
    {
      this.mPluginDone = true;
      this.mPluginSuccess = paramBoolean;
      this.mPluginError = paramThrowable;
      this.mPluginDownloadInfo = paramInfo;
      if (paramInfo != null)
      {
        paramThrowable = new StringBuilder();
        paramThrowable.append(this.mGameConfig.miniGamePluginInfo.name);
        paramThrowable.append("/");
        paramThrowable.append(this.mGameConfig.miniGamePluginInfo.id);
        paramThrowable.append(" ");
        paramThrowable.append(paramInfo.message);
        paramInfo.message = paramThrowable.toString();
      }
      handleFinish();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.gpkg.GpkgManager.MergedOnInitListener
 * JD-Core Version:    0.7.0.1
 */