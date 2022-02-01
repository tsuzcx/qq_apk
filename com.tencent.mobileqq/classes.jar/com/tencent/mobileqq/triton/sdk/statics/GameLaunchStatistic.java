package com.tencent.mobileqq.triton.sdk.statics;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;

public class GameLaunchStatistic
{
  public final EngineInitStatistic engineInitStatistic;
  @NonNull
  public final List<ScriptLoadStatics> gameScriptLoadStatics;
  public final long launchTimesMs;
  public final boolean success;
  
  public GameLaunchStatistic(boolean paramBoolean, long paramLong, @NonNull List<ScriptLoadStatics> paramList, EngineInitStatistic paramEngineInitStatistic)
  {
    this.success = paramBoolean;
    this.engineInitStatistic = paramEngineInitStatistic;
    this.launchTimesMs = paramLong;
    this.gameScriptLoadStatics = Collections.unmodifiableList(paramList);
  }
  
  public String toString()
  {
    return "GameLaunchStatics{success=" + this.success + ", launchTimesMs=" + this.launchTimesMs + ", engineScriptLoadStatics=" + this.gameScriptLoadStatics + ", engineInitStatics=" + this.engineInitStatistic + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.statics.GameLaunchStatistic
 * JD-Core Version:    0.7.0.1
 */