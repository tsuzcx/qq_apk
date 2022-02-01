package com.tencent.mobileqq.qqgamepub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IQQGameConfigUtil
  extends QRouteApi
{
  public static final int sFloatShowTime = 7000;
  public static final String sLastShowFloadWindowDate = "";
  public static final int sPlayVideoCount = 3;
  public static final int sPlayVideoTime = 30000;
  
  public abstract boolean canShowFloatWindow(String paramString);
  
  public abstract boolean checkGamePubAccountConfig();
  
  public abstract String getFeedWebUrl();
  
  public abstract String getGamePubUrl();
  
  public abstract boolean getHippySoDownload();
  
  public abstract boolean getHippySwitch();
  
  public abstract List<String> getInterceptAdIdList();
  
  public abstract boolean getNewPAHippySwitch();
  
  public abstract boolean getNewPAHippyV2Switch();
  
  public abstract int getPreloadFeedsLoadAll();
  
  public abstract boolean getPreloadFeedsSwitch();
  
  public abstract String getPreloadFeedsUrl();
  
  public abstract int getPreloadIntervalDay();
  
  public abstract String getPreloadUrl();
  
  public abstract boolean isFlutterPreLoad();
  
  public abstract boolean isGameCenterPreloadByTab();
  
  public abstract boolean isNeedPreloadByInterval();
  
  public abstract boolean isPreloadSwitch();
  
  public abstract boolean isPubAccountSwitch();
  
  public abstract boolean isPubFeedByWeb();
  
  public abstract boolean isUpdateHippyJsBundleByHttp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
 * JD-Core Version:    0.7.0.1
 */