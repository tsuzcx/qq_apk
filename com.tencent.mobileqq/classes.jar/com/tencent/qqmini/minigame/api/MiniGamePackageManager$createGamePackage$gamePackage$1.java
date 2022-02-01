package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.filesystem.GamePackage.SubpackageListener;
import com.tencent.qqmini.minigame.gpkg.GpkgManager.OnInitGpkgListener;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "name", "", "callback", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$SubpackageListener;", "invoke"}, k=3, mv={1, 1, 16})
final class MiniGamePackageManager$createGamePackage$gamePackage$1
  extends Lambda
  implements Function2<String, GamePackage.SubpackageListener, Unit>
{
  MiniGamePackageManager$createGamePackage$gamePackage$1(MiniGamePkg paramMiniGamePkg, MiniAppInfo paramMiniAppInfo)
  {
    super(2);
  }
  
  public final void invoke(@NotNull String paramString, @NotNull GamePackage.SubpackageListener paramSubpackageListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramSubpackageListener, "callback");
    this.$pkg.downloadSubPack(this.$info, paramString, (GpkgManager.OnInitGpkgListener)new MiniGamePackageManager.createGamePackage.gamePackage.1.1(paramSubpackageListener, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.MiniGamePackageManager.createGamePackage.gamePackage.1
 * JD-Core Version:    0.7.0.1
 */