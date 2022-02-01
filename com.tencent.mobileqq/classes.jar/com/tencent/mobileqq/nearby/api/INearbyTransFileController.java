package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;

@QAPI(process={"all"})
public abstract interface INearbyTransFileController
  extends QRouteApi
{
  public abstract BaseTransProcessor getProcessor(TransferRequest paramTransferRequest);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.INearbyTransFileController
 * JD-Core Version:    0.7.0.1
 */