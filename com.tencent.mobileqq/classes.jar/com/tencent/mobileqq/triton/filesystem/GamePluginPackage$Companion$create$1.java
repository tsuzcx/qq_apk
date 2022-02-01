package com.tencent.mobileqq.triton.filesystem;

import com.tencent.mobileqq.triton.script.ScriptFile.Path;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/filesystem/GamePluginPackage$Companion$create$1", "Lcom/tencent/mobileqq/triton/filesystem/GamePluginPackage;", "id", "", "getId", "()Ljava/lang/String;", "name", "getName", "version", "getVersion", "getScript", "Lcom/tencent/mobileqq/triton/script/ScriptFile$Path;", "toString", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class GamePluginPackage$Companion$create$1
  implements GamePluginPackage
{
  @NotNull
  private final String id;
  @NotNull
  private final String name;
  @NotNull
  private final String version;
  
  GamePluginPackage$Companion$create$1(File paramFile, String paramString1, String paramString2, String paramString3)
  {
    this.id = paramString2;
    this.name = paramString1;
    this.version = paramString3;
  }
  
  @NotNull
  public String getId()
  {
    return this.id;
  }
  
  @NotNull
  public String getName()
  {
    return this.name;
  }
  
  @NotNull
  public ScriptFile.Path getScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return new ScriptFile.Path(paramString, new File(this.$packageDir, paramString), new File(this.$packageDir, paramString + ".cc"));
  }
  
  @NotNull
  public String getVersion()
  {
    return this.version;
  }
  
  @NotNull
  public String toString()
  {
    return "GamePluginPackage{ " + this.$name + ' ' + this.$id + ' ' + this.$version + " }";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.filesystem.GamePluginPackage.Companion.create.1
 * JD-Core Version:    0.7.0.1
 */