package com.tencent.qqmini.minigame.task;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.triton.statistic.EngineInitStatistic;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.task.BaseTask;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.task.TaskSteps;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/task/LaunchEngineUISteps;", "Lcom/tencent/qqmini/sdk/task/BaseTask;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "launchGameBeginTime", "", "steps", "Lcom/tencent/qqmini/sdk/task/TaskSteps;", "execute", "", "getName", "", "getSubTaskExecutionStatics", "", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "getTotalRunDurationMs", "onFirstFrame", "onGameLaunched", "statics", "Lcom/tencent/mobileqq/triton/statistic/GameLaunchStatistic;", "onRuntimeInitDone", "Companion", "FirstFrame", "InitEngine", "LaunchGame", "ScriptTask", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public final class LaunchEngineUISteps
  extends BaseTask
{
  public static final LaunchEngineUISteps.Companion Companion = new LaunchEngineUISteps.Companion(null);
  private static final String TAG = "LaunchEngineUISteps";
  private long launchGameBeginTime;
  private final TaskSteps steps = new TaskSteps((BaseTask)this, CollectionsKt.listOf(new BaseTask[] { (BaseTask)new LaunchEngineUISteps.InitEngine(this), (BaseTask)new LaunchEngineUISteps.LaunchGame(this), (BaseTask)new LaunchEngineUISteps.FirstFrame(this) }));
  
  public LaunchEngineUISteps(@NotNull Context paramContext)
  {
    super(paramContext, null);
  }
  
  protected void execute()
  {
    this.steps.start();
  }
  
  @NotNull
  public String getName()
  {
    return "LaunchEngine";
  }
  
  @NotNull
  protected List<TaskExecutionStatics> getSubTaskExecutionStatics()
  {
    return this.steps.getStepExecutionStatics();
  }
  
  public long getTotalRunDurationMs()
  {
    return getRunDurationMs();
  }
  
  public final void onFirstFrame()
  {
    BaseTask localBaseTask = this.steps.getCurrentStepOrNull();
    if (localBaseTask != null) {
      localBaseTask.onTaskSucceed();
    }
    QMLog.i("LaunchEngineUISteps", "onFirstFrame");
  }
  
  public final void onGameLaunched(@NotNull GameLaunchStatistic paramGameLaunchStatistic)
  {
    Intrinsics.checkParameterIsNotNull(paramGameLaunchStatistic, "statics");
    long l1 = SystemClock.uptimeMillis() - this.launchGameBeginTime;
    long l2 = l1 - paramGameLaunchStatistic.getLaunchTimesMs();
    BaseTask localBaseTask = this.steps.getCurrentStepOrNull();
    Object localObject = localBaseTask;
    if (!(localBaseTask instanceof LaunchEngineUISteps.InitEngine)) {
      localObject = null;
    }
    localObject = (LaunchEngineUISteps.InitEngine)localObject;
    if (localObject != null) {
      ((LaunchEngineUISteps.InitEngine)localObject).onTaskSucceed(paramGameLaunchStatistic.getEngineInitStatistic(), l2);
    }
    localBaseTask = this.steps.getCurrentStepOrNull();
    localObject = localBaseTask;
    if (!(localBaseTask instanceof LaunchEngineUISteps.LaunchGame)) {
      localObject = null;
    }
    localObject = (LaunchEngineUISteps.LaunchGame)localObject;
    if (localObject != null) {
      ((LaunchEngineUISteps.LaunchGame)localObject).onTaskSucceed(paramGameLaunchStatistic.getLaunchTimesMs(), paramGameLaunchStatistic.getGameScriptLoadStatics());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGameLaunched launchGameEnd \n                        totalTimeSpendInLaunch: ");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append(" \n                        effectivelyInitEngineTime: ");
    ((StringBuilder)localObject).append(l2);
    ((StringBuilder)localObject).append(" \n                        engineInitTime: ");
    ((StringBuilder)localObject).append(paramGameLaunchStatistic.getEngineInitStatistic().getTotalInitTimesMs());
    ((StringBuilder)localObject).append(" \n                        launchTime: ");
    ((StringBuilder)localObject).append(paramGameLaunchStatistic.getLaunchTimesMs());
    ((StringBuilder)localObject).append("\n                    ");
    QMLog.i("LaunchEngineUISteps", StringsKt.trimIndent(((StringBuilder)localObject).toString()));
  }
  
  public final void onRuntimeInitDone()
  {
    run();
    this.launchGameBeginTime = SystemClock.uptimeMillis();
    QMLog.i("LaunchEngineUISteps", "onRuntimeInitDone launchGameBegin");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.task.LaunchEngineUISteps
 * JD-Core Version:    0.7.0.1
 */