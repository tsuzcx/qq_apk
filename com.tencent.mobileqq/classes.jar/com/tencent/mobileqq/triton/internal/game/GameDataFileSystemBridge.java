package com.tencent.mobileqq.triton.internal.game;

import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem.DefaultImpls;
import com.tencent.mobileqq.triton.filesystem.TemporaryFile;
import io.github.landerlyoung.jenny.NativeProxy;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/game/GameDataFileSystemBridge;", "", "gameDataFileSystem", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "(Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;)V", "getFile", "", "pathInGame", "getFilePathInGame", "file", "newTempFile", "", "()[Ljava/lang/Object;", "Triton_release"}, k=1, mv={1, 1, 16})
@NativeProxy(allFields=false, allMethods=true, namespace="triton::jni")
public final class GameDataFileSystemBridge
{
  private final GameDataFileSystem gameDataFileSystem;
  
  public GameDataFileSystemBridge(@NotNull GameDataFileSystem paramGameDataFileSystem)
  {
    this.gameDataFileSystem = paramGameDataFileSystem;
  }
  
  @NotNull
  public final String getFile(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "pathInGame");
    paramString = this.gameDataFileSystem.getFile(paramString).getAbsolutePath();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "gameDataFileSystem.getFi…(pathInGame).absolutePath");
    return paramString;
  }
  
  @NotNull
  public final String getFilePathInGame(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "file");
    return this.gameDataFileSystem.getFilePathInGame(new File(paramString));
  }
  
  @NotNull
  public final Object[] newTempFile()
  {
    TemporaryFile localTemporaryFile = GameDataFileSystem.DefaultImpls.newTempFile$default(this.gameDataFileSystem, null, null, 3, null);
    return new Object[] { localTemporaryFile.getFile(), localTemporaryFile.getPathInGame() };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.game.GameDataFileSystemBridge
 * JD-Core Version:    0.7.0.1
 */