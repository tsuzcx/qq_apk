package com.tencent.mobileqq.kandian.ad.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"all"})
public abstract interface IRIJADExposureService
  extends IRuntimeService
{
  public abstract void checkADScrollAction(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, Activity paramActivity, boolean paramBoolean, double paramDouble);
  
  public abstract boolean checkAndReportAdExposure(IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, Activity paramActivity);
  
  public abstract void reportAllInvalidADExposure(Activity paramActivity);
  
  public abstract void reportInvalidADExposure(Context paramContext, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJADExposureService
 * JD-Core Version:    0.7.0.1
 */