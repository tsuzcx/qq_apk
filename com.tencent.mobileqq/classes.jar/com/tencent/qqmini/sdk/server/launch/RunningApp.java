package com.tencent.qqmini.sdk.server.launch;

import android.support.annotation.VisibleForTesting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/server/launch/RunningApp;", "", "id", "Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;", "(Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;)V", "getId", "()Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;", "state", "Lcom/tencent/qqmini/sdk/server/launch/RunningMiniAppState;", "getState", "()Lcom/tencent/qqmini/sdk/server/launch/RunningMiniAppState;", "setState", "(Lcom/tencent/qqmini/sdk/server/launch/RunningMiniAppState;)V", "lib_miniserver_internalRelease"}, k=1, mv={1, 1, 16})
@VisibleForTesting
public final class RunningApp
{
  @NotNull
  private final AppIdentity id;
  @NotNull
  private RunningMiniAppState state;
  
  public RunningApp(@NotNull AppIdentity paramAppIdentity)
  {
    this.id = paramAppIdentity;
    this.state = RunningMiniAppState.STARTING;
  }
  
  @NotNull
  public final AppIdentity getId()
  {
    return this.id;
  }
  
  @NotNull
  public final RunningMiniAppState getState()
  {
    return this.state;
  }
  
  public final void setState(@NotNull RunningMiniAppState paramRunningMiniAppState)
  {
    Intrinsics.checkParameterIsNotNull(paramRunningMiniAppState, "<set-?>");
    this.state = paramRunningMiniAppState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.RunningApp
 * JD-Core Version:    0.7.0.1
 */