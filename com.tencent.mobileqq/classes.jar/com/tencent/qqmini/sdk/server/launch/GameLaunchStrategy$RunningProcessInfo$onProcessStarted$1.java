package com.tencent.qqmini.sdk.server.launch;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class GameLaunchStrategy$RunningProcessInfo$onProcessStarted$1
  implements Runnable
{
  GameLaunchStrategy$RunningProcessInfo$onProcessStarted$1(GameLaunchStrategy.RunningProcessInfo paramRunningProcessInfo) {}
  
  public final void run()
  {
    this.this$0.this$0.onProcessExited$lib_miniserver_internalRelease(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.GameLaunchStrategy.RunningProcessInfo.onProcessStarted.1
 * JD-Core Version:    0.7.0.1
 */