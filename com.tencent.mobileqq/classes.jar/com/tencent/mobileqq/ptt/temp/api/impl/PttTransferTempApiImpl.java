package com.tencent.mobileqq.ptt.temp.api.impl;

import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.ptt.temp.api.IPttTransferTempApi;
import com.tencent.mobileqq.transfile.IC2CPttUploadProcessor;
import com.tencent.mobileqq.transfile.IGroupPttUploadProcessor;

public class PttTransferTempApiImpl
  implements IPttTransferTempApi
{
  public BaseMessageObserver getC2CPttUploadProcessorMsgObserver(IC2CPttUploadProcessor paramIC2CPttUploadProcessor)
  {
    return new PttTransferTempApiImpl.1(this, paramIC2CPttUploadProcessor);
  }
  
  public BaseMessageObserver getGroupPttUploadProcessorMsgObserver(IGroupPttUploadProcessor paramIGroupPttUploadProcessor)
  {
    return new PttTransferTempApiImpl.2(this, paramIGroupPttUploadProcessor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.temp.api.impl.PttTransferTempApiImpl
 * JD-Core Version:    0.7.0.1
 */