package com.tencent.mobileqq.triton.internal.utils;

import com.tencent.mobileqq.triton.filesystem.ScriptPackage;
import com.tencent.mobileqq.triton.script.ScriptFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/internal/utils/Utils$decorateSubPackage$1", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "getScript", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "name", "", "Triton_release"}, k=1, mv={1, 1, 16})
public final class Utils$decorateSubPackage$1
  implements ScriptPackage
{
  Utils$decorateSubPackage$1(ScriptPackage paramScriptPackage, boolean paramBoolean, String paramString) {}
  
  @NotNull
  public ScriptFile getScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return Utils.access$decorate(this.$this_decorateSubPackage.getScript(paramString), this.$enableCodeCache, "/game_sub_package/" + this.$subPackageName + '/', paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.utils.Utils.decorateSubPackage.1
 * JD-Core Version:    0.7.0.1
 */