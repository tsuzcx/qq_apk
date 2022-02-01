package com.tencent.mobileqq.triton.internal.script;

import com.tencent.mobileqq.triton.script.ScriptContextType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem$Companion;", "", "()V", "TAG", "", "toNative", "", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "toScriptContextType", "Triton_release"}, k=1, mv={1, 1, 16})
public final class ScriptSystem$Companion
{
  private final int toNative(@NotNull ScriptContextType paramScriptContextType)
  {
    int j = ScriptSystem.Companion.WhenMappings.$EnumSwitchMapping$0[paramScriptContextType.ordinal()];
    int i = 3;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3) {
          return 0;
        }
      }
      else {
        return 2;
      }
    }
    else {
      i = 1;
    }
    return i;
  }
  
  private final ScriptContextType toScriptContextType(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3) {
          return ScriptContextType.WORKER;
        }
        throw ((Throwable)new IllegalArgumentException());
      }
      return ScriptContextType.OPEN_DATA;
    }
    return ScriptContextType.MAIN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.ScriptSystem.Companion
 * JD-Core Version:    0.7.0.1
 */