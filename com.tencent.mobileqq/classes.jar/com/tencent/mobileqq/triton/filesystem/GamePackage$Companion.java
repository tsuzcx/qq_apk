package com.tencent.mobileqq.triton.filesystem;

import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Companion;", "", "()V", "create", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "id", "", "name", "packageDir", "Ljava/io/File;", "gameConfigContent", "orientation", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Orientation;", "version", "environment", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$Environment;", "optionConfig", "", "plugins", "", "Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;", "subPackageDownloader", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$SubpackageListener;", "callback", "", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class GamePackage$Companion
{
  @NotNull
  public final GamePackage create(@NotNull String paramString1, @NotNull String paramString2, @NotNull File paramFile, @NotNull String paramString3, @NotNull GamePackage.Orientation paramOrientation, @NotNull String paramString4, @NotNull GamePackage.Environment paramEnvironment, @NotNull Map<String, ? extends Object> paramMap, @NotNull List<? extends GamePluginPackage> paramList, @NotNull Function2<? super String, ? super GamePackage.SubpackageListener, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "id");
    Intrinsics.checkParameterIsNotNull(paramString2, "name");
    Intrinsics.checkParameterIsNotNull(paramFile, "packageDir");
    Intrinsics.checkParameterIsNotNull(paramString3, "gameConfigContent");
    Intrinsics.checkParameterIsNotNull(paramOrientation, "orientation");
    Intrinsics.checkParameterIsNotNull(paramString4, "version");
    Intrinsics.checkParameterIsNotNull(paramEnvironment, "environment");
    Intrinsics.checkParameterIsNotNull(paramMap, "optionConfig");
    Intrinsics.checkParameterIsNotNull(paramList, "plugins");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "subPackageDownloader");
    return (GamePackage)new GamePackage.Companion.create.1(paramFile, paramFunction2, paramString2, paramString1, paramString4, paramString3, paramOrientation, paramEnvironment, paramMap, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.filesystem.GamePackage.Companion
 * JD-Core Version:    0.7.0.1
 */