package com.tencent.mobileqq.mini.api;

import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISplashMiniGameStarterService
  extends QRouteApi
{
  public abstract SplashMiniGameData getCurrData();
  
  public abstract Class getGameActivityClass();
  
  public abstract boolean needJump();
  
  public abstract boolean needShow();
  
  public abstract void preloadGameProcess();
  
  public abstract void preloadMiniGame();
  
  public abstract void preloadProcess();
  
  public abstract void saveConfigData(String paramString);
  
  public abstract void setHasClickJumpBtn(boolean paramBoolean);
  
  public abstract void setHasJumped();
  
  public abstract void setNeedJump(boolean paramBoolean);
  
  public abstract void setNeedShow(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService
 * JD-Core Version:    0.7.0.1
 */