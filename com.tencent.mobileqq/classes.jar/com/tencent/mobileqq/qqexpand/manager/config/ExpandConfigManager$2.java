package com.tencent.mobileqq.qqexpand.manager.config;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqexpand.network.ExpandReqInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandResponse;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback;
import com.tencent.mobileqq.qqexpand.utils.impl.ExpandForbiddenUtilsImpl;
import com.tencent.qphone.base.util.QLog;
import tencent.im.usercategory.ExtendFriendUserCategory.GetUserStatusRsp;

class ExpandConfigManager$2
  implements IExpandCmdCallback
{
  ExpandConfigManager$2(ExpandConfigManager paramExpandConfigManager) {}
  
  public void onProtocol(ExpandReqInfo paramExpandReqInfo, @NonNull ExpandResponse paramExpandResponse)
  {
    try
    {
      if ((paramExpandResponse.b() == 0) && (paramExpandResponse.a() != null))
      {
        paramExpandReqInfo = new ExtendFriendUserCategory.GetUserStatusRsp();
        paramExpandReqInfo.mergeFrom(paramExpandResponse.a());
        ExpandForbiddenUtilsImpl.updateForbiddenInfo(paramExpandReqInfo);
        return;
      }
      paramExpandReqInfo = new StringBuilder();
      paramExpandReqInfo.append("getForbiddenInfo. ");
      paramExpandReqInfo.append(paramExpandResponse.d());
      QLog.w("expand.config.ExpandConfigManager", 1, paramExpandReqInfo.toString());
      return;
    }
    catch (Exception paramExpandReqInfo)
    {
      paramExpandResponse = new StringBuilder();
      paramExpandResponse.append("onProtocol ");
      paramExpandResponse.append(paramExpandReqInfo.toString());
      QLog.e("expand.config.ExpandConfigManager", 1, paramExpandResponse.toString());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramExpandReqInfo)
    {
      QLog.w("expand.config.ExpandConfigManager", 1, paramExpandReqInfo.toString());
      paramExpandReqInfo.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.config.ExpandConfigManager.2
 * JD-Core Version:    0.7.0.1
 */