package com.tencent.mobileqq.triton.filesystem;

import com.tencent.mobileqq.triton.script.ScriptFile;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "", "getScript", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "name", "", "Companion", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface ScriptPackage
{
  public static final ScriptPackage.Companion Companion = ScriptPackage.Companion.$$INSTANCE;
  
  @NotNull
  public abstract ScriptFile getScript(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.filesystem.ScriptPackage
 * JD-Core Version:    0.7.0.1
 */