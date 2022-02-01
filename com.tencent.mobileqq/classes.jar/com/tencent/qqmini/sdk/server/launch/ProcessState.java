package com.tencent.qqmini.sdk.server.launch;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/server/launch/ProcessState;", "", "(Ljava/lang/String;I)V", "EMPTY", "PRELOADED", "REUSE", "lib_miniserver_internalRelease"}, k=1, mv={1, 1, 16})
public enum ProcessState
{
  static
  {
    ProcessState localProcessState1 = new ProcessState("EMPTY", 0);
    EMPTY = localProcessState1;
    ProcessState localProcessState2 = new ProcessState("PRELOADED", 1);
    PRELOADED = localProcessState2;
    ProcessState localProcessState3 = new ProcessState("REUSE", 2);
    REUSE = localProcessState3;
    $VALUES = new ProcessState[] { localProcessState1, localProcessState2, localProcessState3 };
  }
  
  private ProcessState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.ProcessState
 * JD-Core Version:    0.7.0.1
 */