package com.tencent.mobileqq.triton.internal.script;

import com.tencent.mobileqq.triton.script.ScriptContextType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem$Companion;", "", "()V", "TAG", "", "toNative", "", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "toScriptContextType", "Triton_release"}, k=1, mv={1, 1, 16})
public final class ScriptSystem$Companion
{
  private final int toNative(@NotNull ScriptContextType paramScriptContextType)
  {
    switch (ScriptSystem.Companion.WhenMappings.$EnumSwitchMapping$0[paramScriptContextType.ordinal()])
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    }
    return 3;
  }
  
  private final ScriptContextType toScriptContextType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw ((Throwable)new IllegalArgumentException());
    case 1: 
      return ScriptContextType.MAIN;
    case 2: 
      return ScriptContextType.OPEN_DATA;
    }
    return ScriptContextType.WORKER;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.ScriptSystem.Companion
 * JD-Core Version:    0.7.0.1
 */