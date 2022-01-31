package com.tencent.mobileqq.minigame.manager;

import android.os.Handler;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.qphone.base.util.QLog;

public class GameReportManager
{
  private static final String TAG = "GameReportManager";
  private static GameReportManager instance;
  private boolean firstFrame = false;
  private boolean jsError = false;
  
  public static GameReportManager g()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new GameReportManager();
      }
      return instance;
    }
    finally {}
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
      QLog.e("GameReportManager", 1, "onFirstFrame", localThrowable);
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
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GameReportManager", 1, "onJsError", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameReportManager
 * JD-Core Version:    0.7.0.1
 */