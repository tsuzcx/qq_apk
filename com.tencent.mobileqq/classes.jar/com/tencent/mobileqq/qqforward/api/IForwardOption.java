package com.tencent.mobileqq.qqforward.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IForwardOption
  extends QRouteApi
{
  public abstract void startForwardActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqforward.api.IForwardOption
 * JD-Core Version:    0.7.0.1
 */