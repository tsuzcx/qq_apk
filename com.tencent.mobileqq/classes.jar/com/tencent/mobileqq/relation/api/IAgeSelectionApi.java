package com.tencent.mobileqq.relation.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IAgeSelectionApi
  extends QRouteApi
{
  public abstract void startAgeSelectionActivity(Activity paramActivity, Intent paramIntent, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.IAgeSelectionApi
 * JD-Core Version:    0.7.0.1
 */