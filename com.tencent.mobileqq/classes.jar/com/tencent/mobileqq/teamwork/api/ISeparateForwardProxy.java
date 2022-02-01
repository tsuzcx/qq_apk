package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISeparateForwardProxy
  extends QRouteApi
{
  public abstract void createSeparateForward(Activity paramActivity, int paramInt);
  
  public abstract void forward(Object paramObject);
  
  public abstract void onCreate();
  
  public abstract void onDestroy();
  
  public abstract void onFowardActivityResult(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.ISeparateForwardProxy
 * JD-Core Version:    0.7.0.1
 */