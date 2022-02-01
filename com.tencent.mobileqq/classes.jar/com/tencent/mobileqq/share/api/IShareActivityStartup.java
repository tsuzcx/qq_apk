package com.tencent.mobileqq.share.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IShareActivityStartup
  extends QRouteApi
{
  public abstract void gotoShareActivity(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.share.api.IShareActivityStartup
 * JD-Core Version:    0.7.0.1
 */