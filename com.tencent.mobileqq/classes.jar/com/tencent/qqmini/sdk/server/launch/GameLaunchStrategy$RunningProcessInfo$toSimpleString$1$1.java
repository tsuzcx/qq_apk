package com.tencent.qqmini.sdk.server.launch;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/qqmini/sdk/server/launch/RunningApp;", "invoke"}, k=3, mv={1, 1, 16})
final class GameLaunchStrategy$RunningProcessInfo$toSimpleString$1$1
  extends Lambda
  implements Function1<RunningApp, String>
{
  public static final 1 INSTANCE = new 1();
  
  GameLaunchStrategy$RunningProcessInfo$toSimpleString$1$1()
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull RunningApp paramRunningApp)
  {
    Intrinsics.checkParameterIsNotNull(paramRunningApp, "it");
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramRunningApp.getState();
    int i = GameLaunchStrategy.RunningProcessInfo.WhenMappings.$EnumSwitchMapping$1[localObject.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            localObject = "☠️S";
          } else {
            throw new NoWhenBranchMatchedException();
          }
        }
        else {
          localObject = "😴B";
        }
      }
      else {
        localObject = "😄F";
      }
    }
    else {
      localObject = "🚀S";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramRunningApp.getId().toSimpleString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.GameLaunchStrategy.RunningProcessInfo.toSimpleString.1.1
 * JD-Core Version:    0.7.0.1
 */