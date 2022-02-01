package com.tencent.mobileqq.ptt.temp.api.impl;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.transfile.IGroupPttUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;

class PttTransferTempApiImpl$2
  extends MessageObserver
{
  IGroupPttUploadProcessor jdField_a_of_type_ComTencentMobileqqTransfileIGroupPttUploadProcessor = this.b;
  
  PttTransferTempApiImpl$2(PttTransferTempApiImpl paramPttTransferTempApiImpl, IGroupPttUploadProcessor paramIGroupPttUploadProcessor) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, StatictisInfo paramStatictisInfo)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileIGroupPttUploadProcessor.getRequest().mUinType == 1026) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onNotifyResultAfterSendRich, UIN_TYPE_HOTCHAT_TOPIC  ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("PttShow", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileIGroupPttUploadProcessor;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("success:");
    localStringBuilder.append(paramBoolean);
    ((IGroupPttUploadProcessor)localObject).logRichMediaEvent("sendMsgFinish", localStringBuilder.toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileIGroupPttUploadProcessor;
    ((IGroupPttUploadProcessor)localObject).copyStatisInfo(((IGroupPttUploadProcessor)localObject).getStepMsg(), false, paramBoolean, paramStatictisInfo);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileIGroupPttUploadProcessor.onSuccess();
      return;
    }
    if (paramStatictisInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileIGroupPttUploadProcessor.setShouldMsgReportSucc(paramStatictisInfo.d);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileIGroupPttUploadProcessor.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.temp.api.impl.PttTransferTempApiImpl.2
 * JD-Core Version:    0.7.0.1
 */