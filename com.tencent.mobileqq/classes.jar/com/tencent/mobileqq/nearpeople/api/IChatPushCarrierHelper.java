package com.tencent.mobileqq.nearpeople.api;

import android.content.Context;
import com.tencent.mobileqq.nearpeople.IChatPushCarrier;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IChatPushCarrierHelper
  extends QRouteApi
{
  public abstract IChatPushCarrier getChatPushCarrier(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearpeople.api.IChatPushCarrierHelper
 * JD-Core Version:    0.7.0.1
 */