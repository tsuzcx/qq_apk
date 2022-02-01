package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.mobileqq.weiyun.WeiyunCallback;
import com.tencent.mobileqq.weiyun.api.IWeiyunCallback;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp;
import com.tencent.qphone.base.util.QLog;

class WeiYunLogicCenter$6
  implements IWeiyunCallback<WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp>
{
  WeiYunLogicCenter$6(WeiYunLogicCenter paramWeiYunLogicCenter, WeiyunCallback paramWeiyunCallback) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp paramAioPicAndVideoCopyToWeiyunMsgRsp)
  {
    if (QLog.isColorLevel())
    {
      paramAioPicAndVideoCopyToWeiyunMsgRsp = new StringBuilder();
      paramAioPicAndVideoCopyToWeiyunMsgRsp.append("saveAioMedia2Weiyun Failed errorCode=");
      paramAioPicAndVideoCopyToWeiyunMsgRsp.append(paramInt);
      paramAioPicAndVideoCopyToWeiyunMsgRsp.append("; errorMsg=");
      paramAioPicAndVideoCopyToWeiyunMsgRsp.append(paramString);
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, paramAioPicAndVideoCopyToWeiyunMsgRsp.toString());
    }
    paramAioPicAndVideoCopyToWeiyunMsgRsp = this.jdField_a_of_type_ComTencentMobileqqWeiyunWeiyunCallback;
    if (paramAioPicAndVideoCopyToWeiyunMsgRsp != null) {
      paramAioPicAndVideoCopyToWeiyunMsgRsp.a(paramInt, paramString);
    }
  }
  
  public void a(WeiyunPB.AioPicAndVideoCopyToWeiyunMsgRsp paramAioPicAndVideoCopyToWeiyunMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "saveAioMedia2Weiyun Success");
    }
    paramAioPicAndVideoCopyToWeiyunMsgRsp = this.jdField_a_of_type_ComTencentMobileqqWeiyunWeiyunCallback;
    if (paramAioPicAndVideoCopyToWeiyunMsgRsp != null) {
      paramAioPicAndVideoCopyToWeiyunMsgRsp.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.6
 * JD-Core Version:    0.7.0.1
 */