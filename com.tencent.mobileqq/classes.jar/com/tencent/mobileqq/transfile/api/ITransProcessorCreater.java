package com.tencent.mobileqq.transfile.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;

@QAPI(process={""})
public abstract interface ITransProcessorCreater
  extends QRouteApi
{
  public abstract BaseTransProcessor createProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest);
  
  public abstract Class<?> getProcessorClazz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.ITransProcessorCreater
 * JD-Core Version:    0.7.0.1
 */