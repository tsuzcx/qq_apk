package com.tencent.mobileqq.triton.internal.engine;

import com.tencent.mobileqq.triton.engine.EngineState;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class EngineContext$DefaultImpls
{
  public static boolean isAlive(EngineContext paramEngineContext)
  {
    return paramEngineContext.getEngineState() != EngineState.DESTROYED;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.EngineContext.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */