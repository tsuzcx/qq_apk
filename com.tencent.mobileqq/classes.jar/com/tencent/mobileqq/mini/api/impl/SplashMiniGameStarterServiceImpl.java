package com.tencent.mobileqq.mini.api.impl;

import com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameStarter;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameUtil;
import com.tencent.mobileqq.minigame.ui.GameActivity3;

public class SplashMiniGameStarterServiceImpl
  implements ISplashMiniGameStarterService
{
  public SplashMiniGameData getCurrData()
  {
    return SplashMiniGameStarter.curData;
  }
  
  public Class getGameActivityClass()
  {
    return GameActivity3.class;
  }
  
  public boolean needJump()
  {
    return SplashMiniGameStarter.needJump;
  }
  
  public boolean needShow()
  {
    return SplashMiniGameStarter.needShow();
  }
  
  public void preloadGameProcess() {}
  
  public void preloadMiniGame() {}
  
  public void preloadProcess() {}
  
  public void saveConfigData(String paramString)
  {
    SplashMiniGameUtil.saveConfigData(paramString);
  }
  
  public void setHasClickJumpBtn(boolean paramBoolean)
  {
    SplashMiniGameStarter.hasClickJumpBtn = paramBoolean;
  }
  
  public void setHasJumped() {}
  
  public void setNeedJump(boolean paramBoolean)
  {
    SplashMiniGameStarter.needJump = paramBoolean;
  }
  
  public void setNeedShow(boolean paramBoolean)
  {
    SplashMiniGameStarter.setNeedShow(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.impl.SplashMiniGameStarterServiceImpl
 * JD-Core Version:    0.7.0.1
 */