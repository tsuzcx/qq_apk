package com.tencent.mobileqq.ptt.temp.api;

import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.IC2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.IGroupPttUploadProcessor;

@QAPI(process={"all"})
public abstract interface IPttTransferTempApi
  extends QRouteApi
{
  public abstract BaseMessageObserver getC2CPttUploadProcessorMsgObserver(IC2CPttUploadProcessor paramIC2CPttUploadProcessor);
  
  public abstract BaseMessageObserver getGroupPttUploadProcessorMsgObserver(IGroupPttUploadProcessor paramIGroupPttUploadProcessor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.temp.api.IPttTransferTempApi
 * JD-Core Version:    0.7.0.1
 */