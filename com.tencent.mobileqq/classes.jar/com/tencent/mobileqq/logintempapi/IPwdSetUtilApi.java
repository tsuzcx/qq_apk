package com.tencent.mobileqq.logintempapi;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IPwdSetUtilApi
  extends QRouteApi
{
  public abstract boolean checkHasNotSetPwd(Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.logintempapi.IPwdSetUtilApi
 * JD-Core Version:    0.7.0.1
 */