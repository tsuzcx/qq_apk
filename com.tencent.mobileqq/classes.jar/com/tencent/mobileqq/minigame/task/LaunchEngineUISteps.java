package com.tencent.mobileqq.minigame.task;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.TaskExecutionStatics;
import com.tencent.mobileqq.mini.tfs.TaskSteps;
import com.tencent.mobileqq.triton.statistic.EngineInitStatistic;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/task/LaunchEngineUISteps;", "Lcom/tencent/mobileqq/mini/tfs/BaseTask;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "launchGameBeginTime", "", "steps", "Lcom/tencent/mobileqq/mini/tfs/TaskSteps;", "execute", "", "getName", "", "getSubTaskExecutionStatics", "", "Lcom/tencent/mobileqq/mini/tfs/TaskExecutionStatics;", "getTotalRunDurationMs", "onFirstFrame", "onGameLaunched", "statics", "Lcom/tencent/mobileqq/triton/statistic/GameLaunchStatistic;", "onRuntimeInitDone", "Companion", "FirstFrame", "InitEngine", "LaunchGame", "ScriptTask", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class LaunchEngineUISteps
  extends BaseTask
{
  public static final LaunchEngineUISteps.Companion Companion = new LaunchEngineUISteps.Companion(null);
  private static final String TAG = "LaunchEngineUISteps";
  private long launchGameBeginTime;
  private final TaskSteps steps = new TaskSteps((BaseTask)this, CollectionsKt.listOf(new BaseTask[] { (BaseTask)new LaunchEngineUISteps.InitEngine(this), (BaseTask)new LaunchEngineUISteps.LaunchGame(this), (BaseTask)new LaunchEngineUISteps.FirstFrame(this) }));
  
  public LaunchEngineUISteps(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public void execute()
  {
    this.steps.start();
  }
  
  @NotNull
  public String getName()
  {
    return "LaunchEngine";
  }
  
  @NotNull
  public List<TaskExecutionStatics> getSubTaskExecutionStatics()
  {
    return this.steps.getStepExecutionStatics();
  }
  
  public long getTotalRunDurationMs()
  {
    return getRunDurationMs();
  }
  
  public final void onFirstFrame()
  {
    this.steps.getCurrentStep().onTaskSucceed();
    QLog.i("LaunchEngineUISteps", 1, "onFirstFrame");
  }
  
  public final void onGameLaunched(@NotNull GameLaunchStatistic paramGameLaunchStatistic)
  {
    Intrinsics.checkParameterIsNotNull(paramGameLaunchStatistic, "statics");
    long l1 = SystemClock.uptimeMillis() - this.launchGameBeginTime;
    long l2 = l1 - paramGameLaunchStatistic.getLaunchTimesMs();
    BaseTask localBaseTask = this.steps.getCurrentStep();
    if (localBaseTask == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.minigame.task.LaunchEngineUISteps.InitEngine");
    }
    ((LaunchEngineUISteps.InitEngine)localBaseTask).onTaskSucceed(paramGameLaunchStatistic.getEngineInitStatistic(), l2);
    localBaseTask = this.steps.getCurrentStep();
    if (localBaseTask == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.minigame.task.LaunchEngineUISteps.LaunchGame");
    }
    ((LaunchEngineUISteps.LaunchGame)localBaseTask).onTaskSucceed(paramGameLaunchStatistic.getLaunchTimesMs(), paramGameLaunchStatistic.getGameScriptLoadStatics());
    QLog.i("LaunchEngineUISteps", 1, StringsKt.trimIndent("onGameLaunched launchGameEnd \n                        totalTimeSpendInLaunch:" + l1 + " \n                        effectivelyInitEngineTime:" + l2 + " \n                        engineInitTime:" + paramGameLaunchStatistic.getEngineInitStatistic().getTotalInitTimesMs() + " \n                        launchTime:" + paramGameLaunchStatistic.getLaunchTimesMs() + "\n                    "));
  }
  
  public final void onRuntimeInitDone()
  {
    run();
    this.launchGameBeginTime = SystemClock.uptimeMillis();
    QLog.i("LaunchEngineUISteps", 1, "onRuntimeInitDone launchGameBegin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.LaunchEngineUISteps
 * JD-Core Version:    0.7.0.1
 */