package com.tencent.qqmini.minigame.utils;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineState;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"valid", "", "Lcom/tencent/mobileqq/triton/TritonEngine;", "getValid", "(Lcom/tencent/mobileqq/triton/TritonEngine;)Z", "lib_minigame_internalRelease"}, k=2, mv={1, 1, 16})
public final class TritonEngineUtilsKt
{
  public static final boolean getValid(@Nullable TritonEngine paramTritonEngine)
  {
    return (paramTritonEngine != null) && (paramTritonEngine.getState() != EngineState.DESTROYED);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.utils.TritonEngineUtilsKt
 * JD-Core Version:    0.7.0.1
 */