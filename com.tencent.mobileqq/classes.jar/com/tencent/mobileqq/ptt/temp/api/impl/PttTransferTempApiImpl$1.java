package com.tencent.mobileqq.ptt.temp.api.impl;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.transfile.IC2CPttUploadProcessor;

class PttTransferTempApiImpl$1
  extends MessageObserver
{
  IC2CPttUploadProcessor a = this.b;
  
  PttTransferTempApiImpl$1(PttTransferTempApiImpl paramPttTransferTempApiImpl, IC2CPttUploadProcessor paramIC2CPttUploadProcessor) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, StatictisInfo paramStatictisInfo)
  {
    IC2CPttUploadProcessor localIC2CPttUploadProcessor = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("success:");
    localStringBuilder.append(paramBoolean);
    localIC2CPttUploadProcessor.logRichMediaEvent("sendMsgFinish", localStringBuilder.toString());
    localIC2CPttUploadProcessor = this.a;
    localIC2CPttUploadProcessor.copyStatisInfo(localIC2CPttUploadProcessor.getStepMsg(), false, paramBoolean, paramStatictisInfo);
    if (paramBoolean)
    {
      this.a.onSuccess();
      return;
    }
    this.a.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.temp.api.impl.PttTransferTempApiImpl.1
 * JD-Core Version:    0.7.0.1
 */