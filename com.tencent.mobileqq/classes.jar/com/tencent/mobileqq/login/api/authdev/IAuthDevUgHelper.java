package com.tencent.mobileqq.login.api.authdev;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"tool"})
public abstract interface IAuthDevUgHelper
  extends QRouteApi
{
  public abstract void notifyPhoneChanged(Activity paramActivity, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.login.api.authdev.IAuthDevUgHelper
 * JD-Core Version:    0.7.0.1
 */