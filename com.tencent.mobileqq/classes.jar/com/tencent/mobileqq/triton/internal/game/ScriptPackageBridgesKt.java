package com.tencent.mobileqq.triton.internal.game;

import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.mobileqq.triton.script.ScriptFile.Content;
import com.tencent.mobileqq.triton.script.ScriptFile.Path;
import java.io.File;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toNativeType", "", "", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "pluginId", "(Lcom/tencent/mobileqq/triton/script/ScriptFile;Ljava/lang/String;)[Ljava/lang/String;", "Triton_release"}, k=2, mv={1, 1, 16})
public final class ScriptPackageBridgesKt
{
  private static final String[] toNativeType(@NotNull ScriptFile paramScriptFile, String paramString)
  {
    boolean bool = paramScriptFile instanceof ScriptFile.Path;
    String str2 = null;
    String str1 = null;
    String str3;
    Object localObject;
    if (bool)
    {
      paramScriptFile = (ScriptFile.Path)paramScriptFile;
      str2 = paramScriptFile.getName();
      str3 = paramScriptFile.getPath().getAbsolutePath();
      localObject = (String)null;
      File localFile = paramScriptFile.getCodeCache();
      paramScriptFile = str1;
      if (localFile != null) {
        paramScriptFile = localFile.getAbsolutePath();
      }
      return new String[] { str2, str3, localObject, paramScriptFile, paramString };
    }
    if (paramScriptFile != null)
    {
      paramScriptFile = (ScriptFile.Content)paramScriptFile;
      str1 = paramScriptFile.getName();
      str3 = (String)null;
      localObject = paramScriptFile.getCodeCache();
      paramScriptFile = str2;
      if (localObject != null) {
        paramScriptFile = ((File)localObject).getAbsolutePath();
      }
      return new String[] { str1, str3, paramScriptFile, paramString };
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.triton.script.ScriptFile.Content");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.game.ScriptPackageBridgesKt
 * JD-Core Version:    0.7.0.1
 */