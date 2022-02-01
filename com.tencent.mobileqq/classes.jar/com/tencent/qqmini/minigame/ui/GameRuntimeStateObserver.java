package com.tencent.qqmini.minigame.ui;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.Pair;
import com.tencent.mobileqq.triton.statistic.GameLaunchStatistic;
import com.tencent.qqmini.minigame.report.GameStopType;
import com.tencent.qqmini.minigame.report.MiniGameBeaconReport;
import com.tencent.qqmini.minigame.task.LaunchEngineUISteps;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniGdtReporter;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.MiniAppStateMessage;
import com.tencent.qqmini.sdk.runtime.AppRuntimeEventCenter.RuntimeStateObserver;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics.Status;
import com.tencent.qqmini.sdk.task.TaskStaticsVisualizer;
import java.util.List;

public class GameRuntimeStateObserver
  extends AppRuntimeEventCenter.RuntimeStateObserver
{
  private static final long JANK_TRACE_REPORT_MIN_RUN_DURATION_MS = 30000L;
  private static final String TAG = "GameRuntimeState";
  private Activity mActivity;
  private long mBeginOnCreate;
  private GameLaunchStatistic mGameLaunchStatistic;
  private final Runnable mGameLaunchWatchDog = new GameRuntimeStateObserver.1(this);
  private final GameUIProxy mGameUI;
  private boolean mHasFirstFrameFinished = false;
  private boolean mHasReportLoadCanceled = false;
  private long mLastOnShowTime;
  private final LaunchEngineUISteps mLaunchEngineUISteps = new LaunchEngineUISteps(AppLoaderFactory.g().getContext());
  private long mLoadGameStartTime;
  private final Handler mMainHandler = new Handler(Looper.getMainLooper());
  private MiniAppInfo mMiniAppInfo;
  private long mOnGameLaunchedTime;
  private long mOnGameSurfaceCreateTime;
  
  GameRuntimeStateObserver(GameUIProxy paramGameUIProxy)
  {
    this.mGameUI = paramGameUIProxy;
  }
  
  @NonNull
  private TaskExecutionStatics getTaskExecutionStatics(long paramLong)
  {
    List localList = this.mGameUI.getTaskStatics();
    localList.add(this.mLaunchEngineUISteps.getExecutionStatics());
    TaskExecutionStatics localTaskExecutionStatics = (TaskExecutionStatics)localList.get(0);
    return new TaskExecutionStatics("root", localTaskExecutionStatics.getRunDurationMs() + paramLong, localTaskExecutionStatics.getRunDurationMs() + paramLong, TaskExecutionStatics.Status.SUCCESS, "", localList);
  }
  
  @NonNull
  private List<TaskExecutionStatics> getTaskExecutionStatics()
  {
    List localList = this.mGameUI.getTaskStatics();
    localList.add(this.mLaunchEngineUISteps.getExecutionStatics());
    return localList;
  }
  
  private void notifyGameOnHide()
  {
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onAppStateChange(this.mMiniAppInfo, 2);
  }
  
  private void notifyGameOnShow()
  {
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onAppStateChange(this.mMiniAppInfo, 1);
  }
  
  private void notifyGameStop()
  {
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).onAppStateChange(this.mMiniAppInfo, 3);
  }
  
  private void onEngineLoaded(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Game engine loaded. ");
    ((StringBuilder)localObject).append(this.mMiniAppInfo);
    QMLog.i("GameRuntimeState", ((StringBuilder)localObject).toString());
    if ((paramMiniAppStateMessage.obj instanceof String))
    {
      localObject = (String)paramMiniAppStateMessage.obj;
      this.mGameUI.updateLoadingProcessText((String)localObject, 1.0F);
    }
    if (paramMiniAppStateMessage.appRuntimeLoader != null) {
      paramMiniAppStateMessage.appRuntimeLoader.notifyRuntimeEvent(4, new Object[0]);
    }
    long l = System.currentTimeMillis() - this.mLoadGameStartTime;
    MiniReportManager.reportEventType(this.mMiniAppInfo, 1033, null, String.valueOf(this.mGameUI.getStatMode()), null, 0, "1", l, null);
    paramMiniAppStateMessage = new StringBuilder();
    paramMiniAppStateMessage.append("step[load baseLib] succeed, cost time: ");
    paramMiniAppStateMessage.append(l);
    QMLog.e("[minigame][timecost] ", paramMiniAppStateMessage.toString());
  }
  
  private void onGameRuntimeMsgEngineFailed(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Failed to load game engine. ");
    localStringBuilder.append(this.mMiniAppInfo);
    QMLog.i("GameRuntimeState", localStringBuilder.toString());
    if ((paramMiniAppStateMessage.obj instanceof Integer)) {
      if (((Integer)paramMiniAppStateMessage.obj).intValue() == 104) {
        this.mGameUI.showUpdateMobileQQDialog();
      } else {
        runOnUiThread(new GameRuntimeStateObserver.4(this));
      }
    }
    MiniGdtReporter.report(this.mMiniAppInfo, 510);
    long l = System.currentTimeMillis() - this.mLoadGameStartTime;
    MiniReportManager.reportEventType(this.mMiniAppInfo, 1033, null, String.valueOf(this.mGameUI.getStatMode()), null, -1, "1", l, null);
    paramMiniAppStateMessage = new StringBuilder();
    paramMiniAppStateMessage.append("step[load baseLib] fail, cost time: ");
    paramMiniAppStateMessage.append(l);
    QMLog.e("[minigame][timecost] ", paramMiniAppStateMessage.toString());
    runOnUiThread(new GameRuntimeStateObserver.5(this));
  }
  
  private void onGameRuntimeMsgFirstRender(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Game First render. ");
    ((StringBuilder)localObject).append(this.mMiniAppInfo);
    QMLog.i("GameRuntimeState", ((StringBuilder)localObject).toString());
    this.mHasFirstFrameFinished = true;
    int i;
    if ((paramMiniAppStateMessage.obj instanceof Integer)) {
      i = ((Integer)paramMiniAppStateMessage.obj).intValue();
    } else {
      i = 0;
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.mOnGameSurfaceCreateTime;
    long l3 = l1 - this.mBeginOnCreate;
    long l4 = this.mOnGameLaunchedTime;
    MiniReportManager.reportEventType(this.mMiniAppInfo, 1043, null, this.mGameUI.getLaunchMsg(), null, i, "1", l3, null);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("step[onFirstFrameAppear] (首帧出现) cost time ");
    ((StringBuilder)localObject).append(l1 - l2);
    ((StringBuilder)localObject).append("(from create surfaceView), ");
    ((StringBuilder)localObject).append(l3);
    ((StringBuilder)localObject).append("(from onCreate) ");
    ((StringBuilder)localObject).append(l1 - l4);
    ((StringBuilder)localObject).append(" ms(from gameLaunched)");
    QMLog.e("[minigame][timecost] ", ((StringBuilder)localObject).toString());
    runOnUiThread(new GameRuntimeStateObserver.3(this));
    if (paramMiniAppStateMessage.appRuntimeLoader != null) {
      paramMiniAppStateMessage.appRuntimeLoader.notifyRuntimeEvent(11, new Object[0]);
    }
    this.mLaunchEngineUISteps.onFirstFrame();
    localObject = getTaskExecutionStatics(l3);
    paramMiniAppStateMessage = this.mMiniAppInfo;
    if (paramMiniAppStateMessage != null) {
      paramMiniAppStateMessage = paramMiniAppStateMessage.appId;
    } else {
      paramMiniAppStateMessage = "";
    }
    MiniGameBeaconReport.reportLaunchStatics(paramMiniAppStateMessage, (TaskExecutionStatics)localObject, this.mGameLaunchStatistic, true, this.mGameUI.getStatMode());
    reportJankTraceStatistics(true);
    paramMiniAppStateMessage = new StringBuilder();
    paramMiniAppStateMessage.append("launchGame ");
    paramMiniAppStateMessage.append(this.mGameUI.getMiniAppInfo());
    paramMiniAppStateMessage.append(" GameLoadTaskExecutionStatics: \n");
    paramMiniAppStateMessage.append(TaskStaticsVisualizer.visualizeToString((TaskExecutionStatics)localObject));
    QMLog.e("[minigame][timecost] ", paramMiniAppStateMessage.toString());
  }
  
  private void onGpkgFailed()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Failed to load game package. ");
    localStringBuilder.append(this.mMiniAppInfo);
    QMLog.i("GameRuntimeState", localStringBuilder.toString());
    runOnUiThread(new GameRuntimeStateObserver.2(this));
    long l = System.currentTimeMillis() - this.mLoadGameStartTime;
    MiniGdtReporter.report(this.mMiniAppInfo, 511);
    MiniReportManager.reportEventType(this.mMiniAppInfo, 1036, null, null, null, -1, "1", l, null);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("step[load gpkg] fail, cost time: ");
    localStringBuilder.append(l);
    QMLog.e("[minigame][timecost] ", localStringBuilder.toString());
  }
  
  private void onGpkgLoading(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Game package loading. ");
    localStringBuilder.append(paramMiniAppStateMessage.obj);
    localStringBuilder.append(this.mMiniAppInfo);
    QMLog.i("GameRuntimeState", localStringBuilder.toString());
    if ((paramMiniAppStateMessage.obj instanceof LoadingStatus))
    {
      paramMiniAppStateMessage = (LoadingStatus)paramMiniAppStateMessage.obj;
      if (paramMiniAppStateMessage.isInProgress()) {
        this.mGameUI.setPackageDownloadFlag(true);
      }
      this.mGameUI.updateLoadingProcessText(paramMiniAppStateMessage.getProcessInPercentage(), paramMiniAppStateMessage.getProgress());
    }
  }
  
  private void onMsgHide()
  {
    if (SystemClock.uptimeMillis() - this.mLastOnShowTime > 30000L) {
      reportJankTraceStatistics(false);
    }
    notifyGameOnHide();
  }
  
  private void reportGameLoadCanceled(GameStopType paramGameStopType)
  {
    if (!this.mHasFirstFrameFinished)
    {
      if (this.mHasReportLoadCanceled) {
        return;
      }
      this.mHasReportLoadCanceled = true;
      TaskExecutionStatics localTaskExecutionStatics = getTaskExecutionStatics(System.currentTimeMillis() - this.mBeginOnCreate);
      Object localObject = this.mMiniAppInfo;
      if (localObject != null) {
        localObject = ((MiniAppInfo)localObject).appId;
      } else {
        localObject = "";
      }
      MiniGameBeaconReport.reportGameLoadCancelEvent((String)localObject, localTaskExecutionStatics, this.mGameLaunchStatistic, paramGameStopType, this.mGameUI.getStatMode());
    }
  }
  
  private void reportJankTraceStatistics(boolean paramBoolean)
  {
    this.mGameUI.getTraceStatistics(new GameRuntimeStateObserver.6(this, paramBoolean));
  }
  
  private void runOnUiThread(Runnable paramRunnable)
  {
    this.mMainHandler.post(paramRunnable);
  }
  
  public void onStateChange(AppRuntimeEventCenter.MiniAppStateMessage paramMiniAppStateMessage)
  {
    this.mMiniAppInfo = this.mGameUI.getMiniAppInfo();
    this.mActivity = this.mGameUI.getActivity();
    int i = paramMiniAppStateMessage.what;
    if (i != 20)
    {
      if (i != 60)
      {
        StringBuilder localStringBuilder;
        if (i != 63)
        {
          long l;
          if (i != 2021)
          {
            if (i != 2031)
            {
              if (i != 2032) {
                switch (i)
                {
                default: 
                  switch (i)
                  {
                  default: 
                    switch (i)
                    {
                    default: 
                      return;
                    case 2053: 
                      notifyGameStop();
                      if (!(paramMiniAppStateMessage.obj instanceof GameStopType)) {
                        break;
                      }
                      reportGameLoadCanceled((GameStopType)paramMiniAppStateMessage.obj);
                      return;
                    case 2052: 
                      onMsgHide();
                      return;
                    case 2051: 
                      this.mLastOnShowTime = SystemClock.uptimeMillis();
                      notifyGameOnShow();
                      return;
                    }
                    break;
                  case 2013: 
                    onGameRuntimeMsgEngineFailed(paramMiniAppStateMessage);
                    return;
                  case 2012: 
                    onEngineLoaded(paramMiniAppStateMessage);
                    return;
                  case 2011: 
                    localStringBuilder = new StringBuilder();
                    localStringBuilder.append("Game engine loading. ");
                    localStringBuilder.append(this.mMiniAppInfo);
                    QMLog.i("GameRuntimeState", localStringBuilder.toString());
                    if (!(paramMiniAppStateMessage.obj instanceof LoadingStatus)) {
                      break;
                    }
                    paramMiniAppStateMessage = (LoadingStatus)paramMiniAppStateMessage.obj;
                    this.mGameUI.updateLoadingProcessText(paramMiniAppStateMessage.getProcessInPercentage(), paramMiniAppStateMessage.getProgress());
                    return;
                  }
                  break;
                case 2003: 
                  onGpkgFailed();
                  return;
                case 2002: 
                  paramMiniAppStateMessage = new StringBuilder();
                  paramMiniAppStateMessage.append("Game package loaded. ");
                  paramMiniAppStateMessage.append(this.mMiniAppInfo);
                  QMLog.i("GameRuntimeState", paramMiniAppStateMessage.toString());
                  this.mGameUI.updateLoadingProcessText("100%", 1.0F);
                  l = System.currentTimeMillis() - this.mLoadGameStartTime;
                  MiniReportManager.reportEventType(this.mMiniAppInfo, 1036, null, this.mGameUI.getLaunchMsg(), null, 0, "1", l, null);
                  paramMiniAppStateMessage = new StringBuilder();
                  paramMiniAppStateMessage.append("step[load gpkg] succeed, cost time: ");
                  paramMiniAppStateMessage.append(l);
                  QMLog.e("[minigame][timecost] ", paramMiniAppStateMessage.toString());
                  return;
                case 2001: 
                  onGpkgLoading(paramMiniAppStateMessage);
                  return;
                }
              } else {
                onGameRuntimeMsgFirstRender(paramMiniAppStateMessage);
              }
            }
            else
            {
              paramMiniAppStateMessage = new StringBuilder();
              paramMiniAppStateMessage.append("Game surface create. ");
              paramMiniAppStateMessage.append(this.mMiniAppInfo);
              QMLog.i("GameRuntimeState", paramMiniAppStateMessage.toString());
              this.mOnGameSurfaceCreateTime = System.currentTimeMillis();
            }
          }
          else
          {
            l = System.currentTimeMillis() - this.mLoadGameStartTime;
            MiniReportManager.reportEventType(this.mMiniAppInfo, 1037, null, this.mGameUI.getLaunchMsg(), null, 0, "1", l, null);
            paramMiniAppStateMessage = new StringBuilder();
            paramMiniAppStateMessage.append("[MiniEng] step[init runTime] cost time ");
            paramMiniAppStateMessage.append(l);
            paramMiniAppStateMessage.append(", include steps[load baseLib, load gpkg]");
            QMLog.e("[minigame][timecost] ", paramMiniAppStateMessage.toString());
            this.mLaunchEngineUISteps.onRuntimeInitDone();
          }
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Game launched. ");
          localStringBuilder.append(this.mMiniAppInfo);
          QMLog.i("GameRuntimeState", localStringBuilder.toString());
          paramMiniAppStateMessage = (Pair)paramMiniAppStateMessage.obj;
          this.mOnGameLaunchedTime = System.currentTimeMillis();
          this.mGameLaunchStatistic = ((GameLaunchStatistic)paramMiniAppStateMessage.second);
          this.mLaunchEngineUISteps.onGameLaunched((GameLaunchStatistic)paramMiniAppStateMessage.second);
        }
      }
      else
      {
        reportGameLoadCanceled(GameStopType.CAPSULE_BUTTON);
      }
    }
    else
    {
      paramMiniAppStateMessage = new StringBuilder();
      paramMiniAppStateMessage.append("User click. onCreate/onNewIntent. ");
      paramMiniAppStateMessage.append(this.mMiniAppInfo);
      QMLog.i("GameRuntimeState", paramMiniAppStateMessage.toString());
      this.mLoadGameStartTime = System.currentTimeMillis();
      this.mMainHandler.postDelayed(this.mGameLaunchWatchDog, 10000L);
    }
  }
  
  void setOnCreateTimeStamp()
  {
    this.mBeginOnCreate = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.GameRuntimeStateObserver
 * JD-Core Version:    0.7.0.1
 */