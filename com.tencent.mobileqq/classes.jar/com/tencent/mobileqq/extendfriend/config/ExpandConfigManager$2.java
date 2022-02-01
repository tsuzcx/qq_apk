package com.tencent.mobileqq.extendfriend.config;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.network.ExpandCmdHandler.ICallback;
import com.tencent.mobileqq.extendfriend.network.ExpandReqInfo;
import com.tencent.mobileqq.extendfriend.network.ExpandResponse;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.im.usercategory.ExtendFriendUserCategory.GetUserStatusRsp;

class ExpandConfigManager$2
  implements ExpandCmdHandler.ICallback
{
  ExpandConfigManager$2(ExpandConfigManager paramExpandConfigManager) {}
  
  public void a(ExpandReqInfo paramExpandReqInfo, @NonNull ExpandResponse paramExpandResponse)
  {
    try
    {
      if ((paramExpandResponse.a() != 0) || (paramExpandResponse.a() == null))
      {
        QLog.w("expand.config.ExpandConfigManager", 1, "getForbiddenInfo. " + paramExpandResponse.b());
        return;
      }
      paramExpandReqInfo = new ExtendFriendUserCategory.GetUserStatusRsp();
      paramExpandReqInfo.mergeFrom(paramExpandResponse.a());
      paramExpandResponse = (ExtendFriendManager)ExpandConfigManager.a(this.a).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (paramExpandResponse != null)
      {
        paramExpandResponse.b(paramExpandReqInfo);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramExpandReqInfo)
    {
      QLog.w("expand.config.ExpandConfigManager", 1, paramExpandReqInfo.toString());
      paramExpandReqInfo.printStackTrace();
      return;
    }
    catch (Exception paramExpandReqInfo)
    {
      QLog.e("expand.config.ExpandConfigManager", 1, "onProtocol " + paramExpandReqInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.config.ExpandConfigManager.2
 * JD-Core Version:    0.7.0.1
 */