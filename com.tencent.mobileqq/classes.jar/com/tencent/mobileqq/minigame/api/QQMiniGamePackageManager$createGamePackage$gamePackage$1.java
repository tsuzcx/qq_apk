package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.triton.filesystem.GamePackage.SubpackageListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "name", "", "callback", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$SubpackageListener;", "invoke"}, k=3, mv={1, 1, 16})
final class QQMiniGamePackageManager$createGamePackage$gamePackage$1
  extends Lambda
  implements Function2<String, GamePackage.SubpackageListener, Unit>
{
  QQMiniGamePackageManager$createGamePackage$gamePackage$1(MiniGamePkg paramMiniGamePkg)
  {
    super(2);
  }
  
  public final void invoke(@NotNull String paramString, @NotNull GamePackage.SubpackageListener paramSubpackageListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramSubpackageListener, "callback");
    QQMiniGamePackageManager.access$performDownloadSubPackage(QQMiniGamePackageManager.INSTANCE, this.$miniGamePkg, paramString, paramSubpackageListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQMiniGamePackageManager.createGamePackage.gamePackage.1
 * JD-Core Version:    0.7.0.1
 */