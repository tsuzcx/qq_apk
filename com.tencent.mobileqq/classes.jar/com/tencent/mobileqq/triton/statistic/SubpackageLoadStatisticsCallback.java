package com.tencent.mobileqq.triton.statistic;

import androidx.annotation.MainThread;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/statistic/SubpackageLoadStatisticsCallback;", "", "onSubpackageLoaded", "", "name", "", "statistic", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public abstract interface SubpackageLoadStatisticsCallback
{
  @MainThread
  public abstract void onSubpackageLoaded(@NotNull String paramString, @NotNull ScriptLoadStatistic paramScriptLoadStatistic);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.statistic.SubpackageLoadStatisticsCallback
 * JD-Core Version:    0.7.0.1
 */