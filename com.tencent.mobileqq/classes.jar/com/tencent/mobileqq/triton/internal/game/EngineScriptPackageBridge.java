package com.tencent.mobileqq.triton.internal.game;

import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.filesystem.ScriptPackage;
import io.github.landerlyoung.jenny.NativeProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/game/EngineScriptPackageBridge;", "", "enginePackage", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "(Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;)V", "getScript", "", "", "name", "(Ljava/lang/String;)[Ljava/lang/String;", "Triton_release"}, k=1, mv={1, 1, 16})
@NativeProxy(allFields=false, allMethods=true, namespace="triton::jni")
public final class EngineScriptPackageBridge
{
  private final ScriptPackage enginePackage;
  
  public EngineScriptPackageBridge(@NotNull ScriptPackage paramScriptPackage)
  {
    this.enginePackage = paramScriptPackage;
  }
  
  @Nullable
  public final String[] getScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    try
    {
      paramString = ScriptPackageBridgesKt.access$toNativeType(this.enginePackage.getScript(paramString), null);
      return paramString;
    }
    catch (TritonException paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.game.EngineScriptPackageBridge
 * JD-Core Version:    0.7.0.1
 */