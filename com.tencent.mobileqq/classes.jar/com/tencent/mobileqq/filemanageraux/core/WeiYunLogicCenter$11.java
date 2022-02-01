package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp;
import cooperation.weiyun.sdk.api.IWeiyunCallback;

class WeiYunLogicCenter$11
  implements IWeiyunCallback<WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp>
{
  WeiYunLogicCenter$11(WeiYunLogicCenter paramWeiYunLogicCenter, WeiYunLogicCenter.WeiyunCallback paramWeiyunCallback) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp paramWeiyunShareAddFromMobileQQMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink onFailed: errorCode[" + paramInt + "], errorMsg[" + paramString + "]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter$WeiyunCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter$WeiyunCallback.a(paramInt, paramString);
    }
  }
  
  public void a(WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp paramWeiyunShareAddFromMobileQQMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink succeed");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter$WeiyunCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter$WeiyunCallback.a(paramWeiyunShareAddFromMobileQQMsgRsp.raw_url.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.11
 * JD-Core Version:    0.7.0.1
 */