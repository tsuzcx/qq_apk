package com.tencent.mobileqq.flashshow.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IFSQQBaseService
  extends QRouteApi
{
  public abstract Intent handleFSHybirdActivityIntent(Context paramContext, String paramString, Intent paramIntent, int paramInt);
  
  public abstract Intent handleFSPublishHybirdActivityIntent(Context paramContext, String paramString, Intent paramIntent, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.IFSQQBaseService
 * JD-Core Version:    0.7.0.1
 */