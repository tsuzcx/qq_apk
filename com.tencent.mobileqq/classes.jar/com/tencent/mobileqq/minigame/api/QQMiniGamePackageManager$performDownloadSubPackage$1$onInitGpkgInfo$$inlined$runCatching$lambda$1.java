package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.filesystem.ScriptPackage;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.mobileqq.triton.script.ScriptFile.Path;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/minigame/api/QQMiniGamePackageManager$performDownloadSubPackage$1$onInitGpkgInfo$1$1", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "getScript", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "defaultName", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QQMiniGamePackageManager$performDownloadSubPackage$1$onInitGpkgInfo$$inlined$runCatching$lambda$1
  implements ScriptPackage
{
  QQMiniGamePackageManager$performDownloadSubPackage$1$onInitGpkgInfo$$inlined$runCatching$lambda$1(QQMiniGamePackageManager.performDownloadSubPackage.1 param1, boolean paramBoolean, String paramString, MiniGamePkg paramMiniGamePkg) {}
  
  @NotNull
  public ScriptFile getScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "defaultName");
    Object localObject = this.$gamePkg$inlined;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    File localFile = new File(((MiniGamePkg)localObject).getApkgFolderPath(), this.$gamePkg$inlined.getRootPath(this.this$0.$name));
    localObject = localFile;
    if (localFile.exists())
    {
      localObject = localFile;
      if (localFile.isDirectory()) {
        localObject = new File(localFile, paramString);
      }
    }
    GameLog.getInstance().e("subpackage", "getScript name:" + this.this$0.$name + ", pkgFile:" + ((File)localObject).getAbsolutePath());
    return (ScriptFile)new ScriptFile.Path(this.this$0.$name, (File)localObject, new File(((File)localObject).getAbsolutePath() + ".cc"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQMiniGamePackageManager.performDownloadSubPackage.1.onInitGpkgInfo..inlined.runCatching.lambda.1
 * JD-Core Version:    0.7.0.1
 */