package com.tencent.qqmini.minigame.manager;

import android.os.Handler;
import com.tencent.qqmini.minigame.GameRuntimeLoader;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.report.MiniProgramReporter;

public class GameReportManager
{
  private static String TAG;
  private boolean firstFrame;
  private GameRuntimeLoader gameRuntimeLoader;
  private boolean jsError;
  
  public GameReportManager(GameRuntimeLoader paramGameRuntimeLoader)
  {
    TAG = toString();
    this.gameRuntimeLoader = paramGameRuntimeLoader;
    this.firstFrame = false;
    this.jsError = false;
  }
  
  public void onFirstFrame()
  {
    try
    {
      MiniProgramReporter.getInstance().getReportHandler().post(new GameReportManager.2(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e(TAG, "onFirstFrame", localThrowable);
    }
  }
  
  public void onJsError()
  {
    try
    {
      if (!this.jsError)
      {
        this.jsError = true;
        MiniProgramReporter.getInstance().getReportHandler().post(new GameReportManager.1(this));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e(TAG, "onJsError", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.GameReportManager
 * JD-Core Version:    0.7.0.1
 */