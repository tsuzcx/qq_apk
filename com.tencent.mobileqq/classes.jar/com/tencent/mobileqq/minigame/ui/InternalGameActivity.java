package com.tencent.mobileqq.minigame.ui;

import Override;
import android.content.res.Configuration;
import android.view.MotionEvent;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.util.AnimUtil;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void performMiniGameClose()
  {
    super.performMiniGameClose();
    AnimUtil.setCloseAnim(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.InternalGameActivity
 * JD-Core Version:    0.7.0.1
 */