package com.tencent.mobileqq.triton.sdk.callback;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.triton.sdk.statics.FirstRenderStatistic;
import com.tencent.mobileqq.triton.sdk.statics.GameLaunchStatistic;

public abstract interface GameLaunchCallback
{
  public abstract void onFirstRender(@NonNull FirstRenderStatistic paramFirstRenderStatistic);
  
  public abstract void onGameLaunched(@NonNull GameLaunchStatistic paramGameLaunchStatistic);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.callback.GameLaunchCallback
 * JD-Core Version:    0.7.0.1
 */