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
    String str1 = null;
    Object localObject1 = null;
    if ((paramScriptFile instanceof ScriptFile.Path))
    {
      str1 = ((ScriptFile.Path)paramScriptFile).getName();
      str2 = ((ScriptFile.Path)paramScriptFile).getPath().getAbsolutePath();
      localObject2 = (String)null;
      File localFile = ((ScriptFile.Path)paramScriptFile).getCodeCache();
      paramScriptFile = (ScriptFile)localObject1;
      if (localFile != null) {
        paramScriptFile = localFile.getAbsolutePath();
      }
      return new String[] { str1, str2, localObject2, paramScriptFile, paramString };
    }
    if (paramScriptFile == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.triton.script.ScriptFile.Content");
    }
    localObject1 = (ScriptFile.Content)paramScriptFile;
    localObject1 = ((ScriptFile.Content)paramScriptFile).getName();
    String str2 = (String)null;
    Object localObject2 = ((ScriptFile.Content)paramScriptFile).getCodeCache();
    paramScriptFile = str1;
    if (localObject2 != null) {
      paramScriptFile = ((File)localObject2).getAbsolutePath();
    }
    return new String[] { localObject1, str2, paramScriptFile, paramString };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.game.ScriptPackageBridgesKt
 * JD-Core Version:    0.7.0.1
 */