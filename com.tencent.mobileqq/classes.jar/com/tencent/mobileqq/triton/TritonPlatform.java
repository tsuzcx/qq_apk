package com.tencent.mobileqq.triton;

import com.tencent.mobileqq.triton.engine.GameLaunchCallback;
import com.tencent.mobileqq.triton.engine.GameLaunchParam;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/TritonPlatform;", "", "launchGame", "", "param", "Lcom/tencent/mobileqq/triton/engine/GameLaunchParam;", "gameLaunchCallback", "Lcom/tencent/mobileqq/triton/engine/GameLaunchCallback;", "Builder", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface TritonPlatform
{
  public abstract void launchGame(@NotNull GameLaunchParam paramGameLaunchParam, @NotNull GameLaunchCallback paramGameLaunchCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.TritonPlatform
 * JD-Core Version:    0.7.0.1
 */