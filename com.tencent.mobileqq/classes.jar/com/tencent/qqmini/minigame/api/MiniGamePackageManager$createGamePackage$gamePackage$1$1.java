package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.filesystem.GamePackage.SubpackageListener;
import com.tencent.qqmini.minigame.gpkg.GpkgManager.Info;
import com.tencent.qqmini.minigame.gpkg.GpkgManager.OnInitGpkgListener;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/qqmini/minigame/api/MiniGamePackageManager$createGamePackage$gamePackage$1$1", "Lcom/tencent/qqmini/minigame/gpkg/GpkgManager$OnInitGpkgListener;", "onDownloadGpkgProgress", "", "appInfo", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "progress", "", "totalSize", "", "onInitGpkgInfo", "resCode", "", "gamePkg", "Lcom/tencent/qqmini/minigame/gpkg/MiniGamePkg;", "errorMsg", "", "info", "Lcom/tencent/qqmini/minigame/gpkg/GpkgManager$Info;", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class MiniGamePackageManager$createGamePackage$gamePackage$1$1
  implements GpkgManager.OnInitGpkgListener
{
  MiniGamePackageManager$createGamePackage$gamePackage$1$1(GamePackage.SubpackageListener paramSubpackageListener, String paramString) {}
  
  public void onDownloadGpkgProgress(@Nullable MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    this.$callback.onProgress(paramLong, ((float)paramLong * paramFloat));
  }
  
  public void onInitGpkgInfo(int paramInt, @Nullable MiniGamePkg paramMiniGamePkg, @Nullable String paramString, @Nullable GpkgManager.Info paramInfo)
  {
    paramInfo = this.$callback;
    Result.Companion localCompanion = Result.Companion;
    try
    {
      localCompanion = Result.Companion;
      if ((paramMiniGamePkg != null) && (paramInt != 0)) {
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
      paramMiniGamePkg = Result.constructor-impl(new MiniGamePackageManager.createGamePackage.gamePackage.1.1.onInitGpkgInfo..inlined.runCatching.lambda.1(this, paramMiniGamePkg, paramInt, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.MiniGamePackageManager.createGamePackage.gamePackage.1.1
 * JD-Core Version:    0.7.0.1
 */