package com.tencent.mobileqq.kandian.ad.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRIJRecommendFeedsLifeService
  extends QRouteApi
{
  public abstract void onBackToTopAndRefresh(Activity paramActivity, int paramInt);
  
  public abstract void onCreate();
  
  public abstract void onCreateView();
  
  public abstract void onDestroy();
  
  public abstract void onDestroyView();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onStart();
  
  public abstract void onStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJRecommendFeedsLifeService
 * JD-Core Version:    0.7.0.1
 */