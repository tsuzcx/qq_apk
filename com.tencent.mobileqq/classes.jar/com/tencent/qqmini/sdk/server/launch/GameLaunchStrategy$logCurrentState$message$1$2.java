package com.tencent.qqmini.sdk.server.launch;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy$RunningProcessInfo;", "Lcom/tencent/qqmini/sdk/server/launch/GameLaunchStrategy;", "invoke"}, k=3, mv={1, 1, 16})
final class GameLaunchStrategy$logCurrentState$message$1$2
  extends Lambda
  implements Function1<GameLaunchStrategy.RunningProcessInfo, String>
{
  public static final 2 INSTANCE = new 2();
  
  GameLaunchStrategy$logCurrentState$message$1$2()
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull GameLaunchStrategy.RunningProcessInfo paramRunningProcessInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramRunningProcessInfo, "it");
    return paramRunningProcessInfo.toSimpleString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.GameLaunchStrategy.logCurrentState.message.1.2
 * JD-Core Version:    0.7.0.1
 */