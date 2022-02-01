package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.weiyun.WeiyunCallback;
import com.tencent.mobileqq.weiyun.api.IWeiyunCallback;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp;
import com.tencent.qphone.base.util.QLog;

class WeiYunLogicCenter$11
  implements IWeiyunCallback<WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp>
{
  WeiYunLogicCenter$11(WeiYunLogicCenter paramWeiYunLogicCenter, WeiyunCallback paramWeiyunCallback) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp paramWeiyunShareAddFromMobileQQMsgRsp)
  {
    if (QLog.isColorLevel())
    {
      paramWeiyunShareAddFromMobileQQMsgRsp = new StringBuilder();
      paramWeiyunShareAddFromMobileQQMsgRsp.append("getShareLink onFailed: errorCode[");
      paramWeiyunShareAddFromMobileQQMsgRsp.append(paramInt);
      paramWeiyunShareAddFromMobileQQMsgRsp.append("], errorMsg[");
      paramWeiyunShareAddFromMobileQQMsgRsp.append(paramString);
      paramWeiyunShareAddFromMobileQQMsgRsp.append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, paramWeiyunShareAddFromMobileQQMsgRsp.toString());
    }
    paramWeiyunShareAddFromMobileQQMsgRsp = this.jdField_a_of_type_ComTencentMobileqqWeiyunWeiyunCallback;
    if (paramWeiyunShareAddFromMobileQQMsgRsp != null) {
      paramWeiyunShareAddFromMobileQQMsgRsp.a(paramInt, paramString);
    }
  }
  
  public void a(WeiyunPB.WeiyunShareAddFromMobileQQMsgRsp paramWeiyunShareAddFromMobileQQMsgRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getShareLink succeed");
    }
    WeiyunCallback localWeiyunCallback = this.jdField_a_of_type_ComTencentMobileqqWeiyunWeiyunCallback;
    if (localWeiyunCallback != null) {
      localWeiyunCallback.a(paramWeiyunShareAddFromMobileQQMsgRsp.raw_url.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.11
 * JD-Core Version:    0.7.0.1
 */