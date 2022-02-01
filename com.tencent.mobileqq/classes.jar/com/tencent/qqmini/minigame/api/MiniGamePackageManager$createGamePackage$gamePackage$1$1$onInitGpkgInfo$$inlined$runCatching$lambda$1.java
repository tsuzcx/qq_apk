package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.filesystem.ScriptPackage;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.mobileqq.triton.script.ScriptFile.Path;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.minigame.utils.GameLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/qqmini/minigame/api/MiniGamePackageManager$createGamePackage$gamePackage$1$1$onInitGpkgInfo$1$1", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "getScript", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "defaultName", "", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class MiniGamePackageManager$createGamePackage$gamePackage$1$1$onInitGpkgInfo$$inlined$runCatching$lambda$1
  implements ScriptPackage
{
  MiniGamePackageManager$createGamePackage$gamePackage$1$1$onInitGpkgInfo$$inlined$runCatching$lambda$1(MiniGamePackageManager.createGamePackage.gamePackage.1.1 param1, MiniGamePkg paramMiniGamePkg, int paramInt, String paramString) {}
  
  @NotNull
  public ScriptFile getScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "defaultName");
    Object localObject1 = this.$gamePkg$inlined;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((MiniGamePkg)localObject1).getApkgFolderPath();
    Object localObject2 = this.$gamePkg$inlined;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    localObject2 = new File((String)localObject1, ((MiniGamePkg)localObject2).getRootPath(this.this$0.$name));
    localObject1 = localObject2;
    if (((File)localObject2).exists())
    {
      localObject1 = localObject2;
      if (((File)localObject2).isDirectory()) {
        localObject1 = new File((File)localObject2, paramString);
      }
    }
    paramString = GameLog.getInstance();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getScript name:");
    ((StringBuilder)localObject2).append(this.this$0.$name);
    ((StringBuilder)localObject2).append(", pkgFile:");
    ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
    paramString.e("subpackage", ((StringBuilder)localObject2).toString());
    paramString = this.this$0.$name;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
    ((StringBuilder)localObject2).append(".cc");
    return (ScriptFile)new ScriptFile.Path(paramString, (File)localObject1, new File(((StringBuilder)localObject2).toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.MiniGamePackageManager.createGamePackage.gamePackage.1.1.onInitGpkgInfo..inlined.runCatching.lambda.1
 * JD-Core Version:    0.7.0.1
 */