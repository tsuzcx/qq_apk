package com.tencent.qqmini.sdk.server.launch;

import android.support.annotation.VisibleForTesting;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/server/launch/RunningMiniAppState;", "", "(Ljava/lang/String;I)V", "STARTING", "FOREGROUND", "BACKGROUND", "STOPPED", "lib_miniserver_internalRelease"}, k=1, mv={1, 1, 16})
@VisibleForTesting
public enum RunningMiniAppState
{
  static
  {
    RunningMiniAppState localRunningMiniAppState1 = new RunningMiniAppState("STARTING", 0);
    STARTING = localRunningMiniAppState1;
    RunningMiniAppState localRunningMiniAppState2 = new RunningMiniAppState("FOREGROUND", 1);
    FOREGROUND = localRunningMiniAppState2;
    RunningMiniAppState localRunningMiniAppState3 = new RunningMiniAppState("BACKGROUND", 2);
    BACKGROUND = localRunningMiniAppState3;
    RunningMiniAppState localRunningMiniAppState4 = new RunningMiniAppState("STOPPED", 3);
    STOPPED = localRunningMiniAppState4;
    $VALUES = new RunningMiniAppState[] { localRunningMiniAppState1, localRunningMiniAppState2, localRunningMiniAppState3, localRunningMiniAppState4 };
  }
  
  private RunningMiniAppState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.RunningMiniAppState
 * JD-Core Version:    0.7.0.1
 */