package com.tencent.mobileqq.weiyun.api;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IWeiyunSaveTipsHelper
  extends QRouteApi
{
  public abstract void showTopTips(AppInterface paramAppInterface, Activity paramActivity, int paramInt);
  
  public abstract void startWeiyunDisk(AppInterface paramAppInterface, Activity paramActivity, Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper
 * JD-Core Version:    0.7.0.1
 */