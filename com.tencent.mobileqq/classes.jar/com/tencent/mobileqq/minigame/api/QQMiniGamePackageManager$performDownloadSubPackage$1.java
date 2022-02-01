package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager.Info;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager.OnInitGpkgListener;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.triton.filesystem.GamePackage.SubpackageListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/minigame/api/QQMiniGamePackageManager$performDownloadSubPackage$1", "Lcom/tencent/mobileqq/minigame/gpkg/GpkgManager$OnInitGpkgListener;", "maxTryCount", "", "getMaxTryCount", "()I", "setMaxTryCount", "(I)V", "tryCount", "getTryCount", "setTryCount", "onDownloadGpkgProgress", "", "appInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "progress", "", "totalSize", "", "onInitGpkgInfo", "resCode", "gamePkg", "Lcom/tencent/mobileqq/minigame/gpkg/MiniGamePkg;", "errorMsg", "", "info", "Lcom/tencent/mobileqq/minigame/gpkg/GpkgManager$Info;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QQMiniGamePackageManager$performDownloadSubPackage$1
  implements GpkgManager.OnInitGpkgListener
{
  private int maxTryCount = GameWnsUtils.retryLoadSubpackageOnCompileCount();
  private int tryCount = 1;
  
  QQMiniGamePackageManager$performDownloadSubPackage$1(MiniGamePkg paramMiniGamePkg, String paramString, GamePackage.SubpackageListener paramSubpackageListener) {}
  
  public final int getMaxTryCount()
  {
    return this.maxTryCount;
  }
  
  public final int getTryCount()
  {
    return this.tryCount;
  }
  
  public void onDownloadGpkgProgress(@Nullable MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    this.$callback.onProgress(paramLong, ((float)paramLong * paramFloat));
  }
  
  public void onInitGpkgInfo(int paramInt, @Nullable MiniGamePkg paramMiniGamePkg, @Nullable String paramString, @Nullable GpkgManager.Info paramInfo)
  {
    if ((paramMiniGamePkg == null) || (paramInt != 0)) {}
    for (boolean bool = true; bool; bool = false)
    {
      paramInt = this.tryCount;
      this.tryCount = (paramInt + 1);
      if (paramInt >= this.maxTryCount) {
        break;
      }
      this.$miniGamePkg.downloadSubPack(this.$name, (GpkgManager.OnInitGpkgListener)this);
      return;
    }
    paramInfo = this.$callback;
    Result.Companion localCompanion = Result.Companion;
    try
    {
      localCompanion = Result.Companion;
      if (bool) {
        throw ((Throwable)new RuntimeException("download failed " + paramString));
      }
    }
    catch (Throwable paramMiniGamePkg)
    {
      paramString = Result.Companion;
      paramMiniGamePkg = Result.constructor-impl(ResultKt.createFailure(paramMiniGamePkg));
    }
    for (;;)
    {
      paramInfo.onComplete(paramMiniGamePkg);
      return;
      paramMiniGamePkg = Result.constructor-impl(new QQMiniGamePackageManager.performDownloadSubPackage.1.onInitGpkgInfo..inlined.runCatching.lambda.1(this, bool, paramString, paramMiniGamePkg));
    }
  }
  
  public final void setMaxTryCount(int paramInt)
  {
    this.maxTryCount = paramInt;
  }
  
  public final void setTryCount(int paramInt)
  {
    this.tryCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQMiniGamePackageManager.performDownloadSubPackage.1
 * JD-Core Version:    0.7.0.1
 */