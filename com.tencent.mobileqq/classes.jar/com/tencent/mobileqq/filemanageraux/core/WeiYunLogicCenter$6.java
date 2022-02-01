package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp;
import cooperation.weiyun.sdk.api.IWeiyunCallback;

class WeiYunLogicCenter$6
  implements IWeiyunCallback<WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp>
{
  WeiYunLogicCenter$6(WeiYunLogicCenter paramWeiYunLogicCenter, WeiYunLogicCenter.WeiyunCallback paramWeiyunCallback) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp paramAioPicAndVideoCopyToWeiyunMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "saveAioMedia2Weiyun Failed errorCode=" + paramInt + "; errorMsg=" + paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter$WeiyunCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter$WeiyunCallback.a(paramInt, paramString);
    }
  }
  
  public void a(WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp paramAioPicAndVideoCopyToWeiyunMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "saveAioMedia2Weiyun Success");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter$WeiyunCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter$WeiyunCallback.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.6
 * JD-Core Version:    0.7.0.1
 */