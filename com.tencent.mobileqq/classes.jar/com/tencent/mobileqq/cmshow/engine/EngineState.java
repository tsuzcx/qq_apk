package com.tencent.mobileqq.cmshow.engine;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/EngineState;", "", "(Ljava/lang/String;I)V", "INITIALIZING", "INITIALIZED", "STARTED", "STOPPED", "DESTROYED", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public enum EngineState
{
  static
  {
    EngineState localEngineState1 = new EngineState("INITIALIZING", 0);
    INITIALIZING = localEngineState1;
    EngineState localEngineState2 = new EngineState("INITIALIZED", 1);
    INITIALIZED = localEngineState2;
    EngineState localEngineState3 = new EngineState("STARTED", 2);
    STARTED = localEngineState3;
    EngineState localEngineState4 = new EngineState("STOPPED", 3);
    STOPPED = localEngineState4;
    EngineState localEngineState5 = new EngineState("DESTROYED", 4);
    DESTROYED = localEngineState5;
    $VALUES = new EngineState[] { localEngineState1, localEngineState2, localEngineState3, localEngineState4, localEngineState5 };
  }
  
  private EngineState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.EngineState
 * JD-Core Version:    0.7.0.1
 */