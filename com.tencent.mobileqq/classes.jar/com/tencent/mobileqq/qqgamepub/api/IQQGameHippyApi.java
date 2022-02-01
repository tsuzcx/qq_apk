package com.tencent.mobileqq.qqgamepub.api;

import android.content.Context;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;

@QAPI(process={"all"})
public abstract interface IQQGameHippyApi
  extends QRouteApi
{
  public abstract int canOpenHippyByModuleName(String paramString);
  
  public abstract String getGamePaHippyModuleName();
  
  public abstract QQGameMsgInfo getMsgInfoByHippyMap(HippyMap paramHippyMap);
  
  public abstract int getMsgPosByHippyMap(HippyMap paramHippyMap);
  
  public abstract HippyAPIProvider getQQGameHippyAPIProvider();
  
  public abstract HippyCustomViewCreator getQQGameHippyViewCreator();
  
  public abstract boolean isQQGamePubHippyV2(String paramString);
  
  public abstract void openQQGameCenterByHippy(Context paramContext, String paramString1, String paramString2);
  
  public abstract void preloadNewQQGamePaHippy();
  
  public abstract void preloadQQGameCenterByHippy();
  
  public abstract void setGetHippysManagerConfig(boolean paramBoolean);
  
  public abstract void setReadyToPreloadHippy(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
 * JD-Core Version:    0.7.0.1
 */