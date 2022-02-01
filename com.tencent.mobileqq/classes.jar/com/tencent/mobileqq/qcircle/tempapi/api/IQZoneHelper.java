package com.tencent.mobileqq.qcircle.tempapi.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQZoneHelper
  extends QRouteApi
{
  public abstract void preloadHippy();
  
  public abstract void startQCircleHippyActivity(Context paramContext, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.IQZoneHelper
 * JD-Core Version:    0.7.0.1
 */