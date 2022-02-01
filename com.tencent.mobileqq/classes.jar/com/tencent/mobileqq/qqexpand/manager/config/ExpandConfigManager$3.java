package com.tencent.mobileqq.qqexpand.manager.config;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqexpand.config.IConfigCallback;
import com.tencent.mobileqq.qqexpand.network.ExpandReqInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandResponse;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback;
import com.tencent.mobileqq.qqexpand.utils.ExpandSharePreUtils;
import com.tencent.qphone.base.util.QLog;
import expand.network.ExtendFriendABTestConfig.GetTabTestInfoRsp;

class ExpandConfigManager$3
  implements IExpandCmdCallback
{
  ExpandConfigManager$3(ExpandConfigManager paramExpandConfigManager, IConfigCallback paramIConfigCallback) {}
  
  public void a(ExpandReqInfo paramExpandReqInfo, @NonNull ExpandResponse paramExpandResponse)
  {
    int i = paramExpandResponse.a();
    boolean bool1 = false;
    if ((i == 0) && (paramExpandResponse.a() != null))
    {
      paramExpandReqInfo = new ExtendFriendABTestConfig.GetTabTestInfoRsp();
      try
      {
        paramExpandReqInfo.mergeFrom(paramExpandResponse.a());
        boolean bool2 = ExpandSharePreUtils.a(ExpandConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager).getCurrentAccountUin(), paramExpandReqInfo, ExpandConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerConfigExpandConfigManager));
        bool1 = bool2;
      }
      catch (InvalidProtocolBufferMicroException paramExpandReqInfo)
      {
        QLog.w("expand.config.ExpandConfigManager", 1, "getABTestConfig InvalidProtocolBufferMicroException", paramExpandReqInfo);
      }
      paramExpandReqInfo = this.jdField_a_of_type_ComTencentMobileqqQqexpandConfigIConfigCallback;
      if (paramExpandReqInfo != null) {
        paramExpandReqInfo.a(bool1);
      }
      return;
    }
    paramExpandReqInfo = new StringBuilder();
    paramExpandReqInfo.append("getABTestConfig. ");
    paramExpandReqInfo.append(paramExpandResponse.b());
    QLog.w("expand.config.ExpandConfigManager", 1, paramExpandReqInfo.toString());
    paramExpandReqInfo = this.jdField_a_of_type_ComTencentMobileqqQqexpandConfigIConfigCallback;
    if (paramExpandReqInfo != null) {
      paramExpandReqInfo.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.config.ExpandConfigManager.3
 * JD-Core Version:    0.7.0.1
 */