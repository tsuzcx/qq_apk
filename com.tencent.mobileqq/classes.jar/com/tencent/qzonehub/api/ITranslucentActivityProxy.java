package com.tencent.qzonehub.api;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITranslucentActivityProxy
  extends QRouteApi
{
  public abstract SharedPreferences getSharedPreferences(String paramString, int paramInt);
  
  public abstract void startPlugin(Intent paramIntent, Activity paramActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.ITranslucentActivityProxy
 * JD-Core Version:    0.7.0.1
 */