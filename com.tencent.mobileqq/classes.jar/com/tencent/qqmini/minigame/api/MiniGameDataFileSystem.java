package com.tencent.qqmini.minigame.api;

import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.TemporaryFile;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/api/MiniGameDataFileSystem;", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "info", "Lcom/tencent/qqmini/sdk/launcher/model/ApkgBaseInfo;", "(Lcom/tencent/qqmini/sdk/launcher/model/ApkgBaseInfo;)V", "fileManager", "Lcom/tencent/qqmini/sdk/core/manager/MiniAppFileManager;", "kotlin.jvm.PlatformType", "getFile", "Ljava/io/File;", "pathInGame", "", "getFilePathInGame", "file", "newTempFile", "Lcom/tencent/mobileqq/triton/filesystem/TemporaryFile;", "hash", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class MiniGameDataFileSystem
  implements GameDataFileSystem
{
  private final MiniAppFileManager fileManager;
  
  public MiniGameDataFileSystem(@NotNull ApkgBaseInfo paramApkgBaseInfo)
  {
    this.fileManager = MiniAppFileManager.getMiniAppFileManager(paramApkgBaseInfo);
  }
  
  @NotNull
  public File getFile(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "pathInGame");
    return new File(this.fileManager.getAbsolutePath(paramString));
  }
  
  @NotNull
  public String getFilePathInGame(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "file");
    paramFile = this.fileManager.getWxFilePathByExistLocalPath(paramFile.getAbsolutePath());
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "fileManager.getWxFilePat…alPath(file.absolutePath)");
    return paramFile;
  }
  
  @NotNull
  public TemporaryFile newTempFile(@Nullable String paramString)
  {
    paramString = new File(this.fileManager.getTmpPath(null));
    String str = this.fileManager.getWxFilePathByExistLocalPath(paramString.getAbsolutePath());
    Intrinsics.checkExpressionValueIsNotNull(str, "scheme");
    return new TemporaryFile(paramString, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.api.MiniGameDataFileSystem
 * JD-Core Version:    0.7.0.1
 */