package com.tencent.qzonehub.api.gift;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQZoneCheckSendGiftServlet
  extends QRouteApi
{
  public static final int CMD_ID_CHECK_SEND_GIFT = 110;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.gift.IQZoneCheckSendGiftServlet
 * JD-Core Version:    0.7.0.1
 */