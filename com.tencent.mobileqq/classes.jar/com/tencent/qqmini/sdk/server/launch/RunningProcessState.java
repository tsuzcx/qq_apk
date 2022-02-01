package com.tencent.qqmini.sdk.server.launch;

import android.support.annotation.VisibleForTesting;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/server/launch/RunningProcessState;", "", "(Ljava/lang/String;I)V", "STARTING", "PRELOAD", "RUNNING", "lib_miniserver_internalRelease"}, k=1, mv={1, 1, 16})
@VisibleForTesting
public enum RunningProcessState
{
  static
  {
    RunningProcessState localRunningProcessState1 = new RunningProcessState("STARTING", 0);
    STARTING = localRunningProcessState1;
    RunningProcessState localRunningProcessState2 = new RunningProcessState("PRELOAD", 1);
    PRELOAD = localRunningProcessState2;
    RunningProcessState localRunningProcessState3 = new RunningProcessState("RUNNING", 2);
    RUNNING = localRunningProcessState3;
    $VALUES = new RunningProcessState[] { localRunningProcessState1, localRunningProcessState2, localRunningProcessState3 };
  }
  
  private RunningProcessState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.RunningProcessState
 * JD-Core Version:    0.7.0.1
 */