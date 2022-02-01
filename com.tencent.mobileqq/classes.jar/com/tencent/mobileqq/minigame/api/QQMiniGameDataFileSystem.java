package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.TemporaryFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/api/QQMiniGameDataFileSystem;", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "()V", "fileManager", "Lcom/tencent/mobileqq/mini/appbrand/utils/MiniAppFileManager;", "kotlin.jvm.PlatformType", "getFile", "Ljava/io/File;", "pathInGame", "", "getFilePathInGame", "file", "newTempFile", "Lcom/tencent/mobileqq/triton/filesystem/TemporaryFile;", "hash", "suffix", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QQMiniGameDataFileSystem
  implements GameDataFileSystem
{
  private final MiniAppFileManager fileManager = MiniAppFileManager.getInstance();
  
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
  public TemporaryFile newTempFile(@Nullable String paramString1, @Nullable String paramString2)
  {
    paramString1 = new File(this.fileManager.getTmpPath(paramString2));
    paramString2 = this.fileManager.getWxFilePathByExistLocalPath(paramString1.getAbsolutePath());
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "scheme");
    return new TemporaryFile(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.QQMiniGameDataFileSystem
 * JD-Core Version:    0.7.0.1
 */