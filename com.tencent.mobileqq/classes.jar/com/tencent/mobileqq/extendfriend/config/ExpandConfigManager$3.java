package com.tencent.mobileqq.extendfriend.config;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.network.ExpandCmdHandler.ICallback;
import com.tencent.mobileqq.extendfriend.network.ExpandReqInfo;
import com.tencent.mobileqq.extendfriend.network.ExpandResponse;
import com.tencent.mobileqq.extendfriend.utils.ExpandSharePreUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import expand.network.ExtendFriendABTestConfig.GetTabTestInfoRsp;

class ExpandConfigManager$3
  implements ExpandCmdHandler.ICallback
{
  ExpandConfigManager$3(ExpandConfigManager paramExpandConfigManager, ExpandConfigManager.IConfigCallback paramIConfigCallback) {}
  
  public void a(ExpandReqInfo paramExpandReqInfo, @NonNull ExpandResponse paramExpandResponse)
  {
    boolean bool1 = false;
    if ((paramExpandResponse.a() != 0) || (paramExpandResponse.a() == null))
    {
      QLog.w("expand.config.ExpandConfigManager", 1, "getABTestConfig. " + paramExpandResponse.b());
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager$IConfigCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager$IConfigCallback.a(false);
      }
    }
    do
    {
      return;
      paramExpandReqInfo = new ExtendFriendABTestConfig.GetTabTestInfoRsp();
      try
      {
        paramExpandReqInfo.mergeFrom(paramExpandResponse.a());
        boolean bool2 = ExpandSharePreUtils.a(ExpandConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager).getCurrentAccountUin(), paramExpandReqInfo, ExpandConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager));
        bool1 = bool2;
      }
      catch (InvalidProtocolBufferMicroException paramExpandReqInfo)
      {
        for (;;)
        {
          QLog.w("expand.config.ExpandConfigManager", 1, "getABTestConfig InvalidProtocolBufferMicroException", paramExpandReqInfo);
        }
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager$IConfigCallback == null);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendConfigExpandConfigManager$IConfigCallback.a(bool1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.config.ExpandConfigManager.3
 * JD-Core Version:    0.7.0.1
 */