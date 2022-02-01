package com.tencent.mobileqq.qqexpand.manager.config;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandReqInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandResponse;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback;
import com.tencent.mobileqq.qqexpand.utils.ExpandSharePreUtils;
import com.tencent.qphone.base.util.QLog;
import tencent.im.usercategory.ExtendFriendUserCategory.GetUserStatusRsp;

class ExpandConfigManager$1
  implements IExpandCmdCallback
{
  ExpandConfigManager$1(ExpandConfigManager paramExpandConfigManager) {}
  
  public void a(ExpandReqInfo paramExpandReqInfo, @NonNull ExpandResponse paramExpandResponse)
  {
    if ((paramExpandResponse.a() == 0) && (paramExpandResponse.a() != null))
    {
      paramExpandReqInfo = new ExtendFriendUserCategory.GetUserStatusRsp();
      try
      {
        paramExpandReqInfo.mergeFrom(paramExpandResponse.a());
        paramExpandResponse = (ExpandManager)ExpandConfigManager.a(this.a).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        if (paramExpandResponse != null)
        {
          paramExpandResponse.a(paramExpandReqInfo);
          paramExpandReqInfo = ExpandConfigManager.a(this.a).getCurrentAccountUin();
          ExpandSharePreUtils.a(paramExpandReqInfo, true);
          ExpandSharePreUtils.b(paramExpandReqInfo, System.currentTimeMillis());
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramExpandReqInfo)
      {
        QLog.w("expand.config.ExpandConfigManager", 1, paramExpandReqInfo.toString());
        paramExpandReqInfo.printStackTrace();
        return;
      }
    }
    paramExpandReqInfo = new StringBuilder();
    paramExpandReqInfo.append("getUserCategory. ");
    paramExpandReqInfo.append(paramExpandResponse.b());
    QLog.w("expand.config.ExpandConfigManager", 1, paramExpandReqInfo.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.config.ExpandConfigManager.1
 * JD-Core Version:    0.7.0.1
 */