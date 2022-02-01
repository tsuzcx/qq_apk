package com.tencent.mobileqq.nearby.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface INearbyFakeActivityUtils
  extends QRouteApi
{
  public abstract boolean isNearbyProcessExist();
  
  public abstract void openNearbyActWithPreLoad(Context paramContext, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.INearbyFakeActivityUtils
 * JD-Core Version:    0.7.0.1
 */