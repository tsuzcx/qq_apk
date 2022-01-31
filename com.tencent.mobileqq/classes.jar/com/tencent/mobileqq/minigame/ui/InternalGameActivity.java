package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.util.AnimUtil;
import com.tencent.mobileqq.minigame.utils.GameLog;

public class InternalGameActivity
  extends GameActivity
{
  private static final String TAG = "InternalGameActivity";
  
  protected void changeWindowInfo(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config != null) && (paramMiniAppConfig.config.isInternalApp()))
    {
      GameLog.getInstance().i("InternalGameActivity", "skip changeWindowInfo for interMode minigame:" + paramMiniAppConfig.config.simpleInfo());
      return;
    }
    super.changeWindowInfo(paramMiniAppConfig);
  }
  
  public void doOnBackPressed()
  {
    if ((this.mGameAppConfig != null) && (this.mGameAppConfig.config != null) && (this.mGameAppConfig.config.isInternalApp()))
    {
      GameLog.getInstance().i("InternalGameActivity", "doOnBackPressed finishActivity for interMode minigame:" + this.mGameAppConfig.config.simpleInfo());
      reportOnBackPressed();
      quitDebugSocket();
      finishActivity();
      AnimUtil.setCloseAnim(this);
      return;
    }
    super.doOnBackPressed();
  }
  
  protected void performMiniGameClose()
  {
    super.performMiniGameClose();
    AnimUtil.setCloseAnim(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.InternalGameActivity
 * JD-Core Version:    0.7.0.1
 */