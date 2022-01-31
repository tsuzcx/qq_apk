package com.tencent.mobileqq.minigame.gpkg;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

final class GpkgManager$MergedOnInitListener
  implements GpkgManager.DownloadPluginCallback, GpkgManager.OnInitGpkgListener
{
  private boolean mGpkgDone;
  private String mGpkgErrorMsg;
  private MiniGamePkg mGpkgPkg;
  private int mGpkgResCode;
  private final GpkgManager.OnInitGpkgListener mMergedResultListener;
  private boolean mPluginDone;
  private Throwable mPluginError;
  private boolean mPluginSuccess;
  
  GpkgManager$MergedOnInitListener(GpkgManager.OnInitGpkgListener paramOnInitGpkgListener)
  {
    this.mMergedResultListener = paramOnInitGpkgListener;
  }
  
  private void handleFinish()
  {
    GpkgManager.OnInitGpkgListener localOnInitGpkgListener;
    MiniGamePkg localMiniGamePkg;
    if ((this.mGpkgDone) && (this.mPluginDone)) {
      if (!this.mPluginSuccess)
      {
        localOnInitGpkgListener = this.mMergedResultListener;
        localMiniGamePkg = this.mGpkgPkg;
        if (this.mPluginError == null) {
          break label79;
        }
      }
    }
    label79:
    for (String str = this.mPluginError.getMessage();; str = "download plugin fail")
    {
      localOnInitGpkgListener.onInitGpkgInfo(2022, localMiniGamePkg, str);
      this.mMergedResultListener.onInitGpkgInfo(this.mGpkgResCode, this.mGpkgPkg, this.mGpkgErrorMsg);
      return;
    }
  }
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    this.mMergedResultListener.onDownloadGpkgProgress(paramMiniAppInfo, paramFloat, paramLong);
  }
  
  public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString)
  {
    try
    {
      this.mGpkgDone = true;
      this.mGpkgResCode = paramInt;
      this.mGpkgPkg = paramMiniGamePkg;
      this.mGpkgErrorMsg = paramString;
      handleFinish();
      return;
    }
    finally
    {
      paramMiniGamePkg = finally;
      throw paramMiniGamePkg;
    }
  }
  
  public void onPluginDownloadComplete(boolean paramBoolean, @Nullable Throwable paramThrowable)
  {
    try
    {
      this.mPluginDone = true;
      this.mPluginSuccess = paramBoolean;
      this.mPluginError = paramThrowable;
      handleFinish();
      return;
    }
    finally
    {
      paramThrowable = finally;
      throw paramThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.gpkg.GpkgManager.MergedOnInitListener
 * JD-Core Version:    0.7.0.1
 */