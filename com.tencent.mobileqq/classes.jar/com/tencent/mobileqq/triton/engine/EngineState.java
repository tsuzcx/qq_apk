package com.tencent.mobileqq.triton.engine;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/engine/EngineState;", "", "(Ljava/lang/String;I)V", "INITIALIZED", "STARTED", "STOPPED", "DESTROYED", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public enum EngineState
{
  static
  {
    EngineState localEngineState1 = new EngineState("INITIALIZED", 0);
    INITIALIZED = localEngineState1;
    EngineState localEngineState2 = new EngineState("STARTED", 1);
    STARTED = localEngineState2;
    EngineState localEngineState3 = new EngineState("STOPPED", 2);
    STOPPED = localEngineState3;
    EngineState localEngineState4 = new EngineState("DESTROYED", 3);
    DESTROYED = localEngineState4;
    $VALUES = new EngineState[] { localEngineState1, localEngineState2, localEngineState3, localEngineState4 };
  }
  
  private EngineState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.EngineState
 * JD-Core Version:    0.7.0.1
 */