package com.tencent.qzonehub.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQZoneEventHandlerProxy
  extends QRouteApi
{
  public abstract boolean handleActivityEvent(Object paramObject, int paramInt1, int paramInt2, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQZoneEventHandlerProxy
 * JD-Core Version:    0.7.0.1
 */