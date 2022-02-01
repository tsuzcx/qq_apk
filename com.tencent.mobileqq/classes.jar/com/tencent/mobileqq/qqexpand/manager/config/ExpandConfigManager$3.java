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
  
  public void onProtocol(ExpandReqInfo paramExpandReqInfo, @NonNull ExpandResponse paramExpandResponse)
  {
    int i = paramExpandResponse.b();
    boolean bool1 = false;
    if ((i == 0) && (paramExpandResponse.a() != null))
    {
      paramExpandReqInfo = new ExtendFriendABTestConfig.GetTabTestInfoRsp();
      try
      {
        paramExpandReqInfo.mergeFrom(paramExpandResponse.a());
        boolean bool2 = ExpandSharePreUtils.a(ExpandConfigManager.a(this.b).getCurrentAccountUin(), paramExpandReqInfo, ExpandConfigManager.a(this.b));
        bool1 = bool2;
      }
      catch (InvalidProtocolBufferMicroException paramExpandReqInfo)
      {
        QLog.w("expand.config.ExpandConfigManager", 1, "getABTestConfig InvalidProtocolBufferMicroException", paramExpandReqInfo);
      }
      paramExpandReqInfo = this.a;
      if (paramExpandReqInfo != null) {
        paramExpandReqInfo.a(bool1);
      }
      return;
    }
    paramExpandReqInfo = new StringBuilder();
    paramExpandReqInfo.append("getABTestConfig. ");
    paramExpandReqInfo.append(paramExpandResponse.d());
    QLog.w("expand.config.ExpandConfigManager", 1, paramExpandReqInfo.toString());
    paramExpandReqInfo = this.a;
    if (paramExpandReqInfo != null) {
      paramExpandReqInfo.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.config.ExpandConfigManager.3
 * JD-Core Version:    0.7.0.1
 */