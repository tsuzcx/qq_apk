package com.tencent.mobileqq.minigame.publicaccount.api;

import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;

@QAPI(process={"all"})
public abstract interface IMiniGamePublicAccountApi
  extends QRouteApi
{
  public static final String UIN_MINI_GAME_PA = "1983141935";
  
  public abstract boolean canPreloadHippy();
  
  public abstract HippyAPIProvider createHippyProvider();
  
  public abstract Class<? extends QPublicBaseFragment> getMiniGamePAHippyClass();
  
  public abstract boolean hasNewMessage();
  
  public abstract boolean isMiniGamePAModule(String paramString);
  
  public abstract boolean isUseHippy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi
 * JD-Core Version:    0.7.0.1
 */