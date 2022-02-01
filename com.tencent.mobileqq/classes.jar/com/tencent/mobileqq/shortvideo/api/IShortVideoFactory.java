package com.tencent.mobileqq.shortvideo.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;

@QAPI(process={""})
public abstract interface IShortVideoFactory
  extends QRouteApi
{
  public abstract IShortVideoOperator getAioShortVideoSendOperator(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract BaseTransProcessor getProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest);
  
  public abstract Class getShortVideoForwardProcessorClass();
  
  public abstract Class getShortVideoUploadProcessorClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.api.IShortVideoFactory
 * JD-Core Version:    0.7.0.1
 */