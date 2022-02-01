package com.tencent.mobileqq.qqexpand.utils.impl;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqexpand.network.ExpandReqInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandResponse;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback;
import com.tencent.qphone.base.util.QLog;
import tencent.im.usercategory.ExtendFriendUserCategory.GetUserStatusRsp;

final class EntryExtendForbiddenUtilsImpl$2
  implements IExpandCmdCallback
{
  public void onProtocol(ExpandReqInfo paramExpandReqInfo, @NonNull ExpandResponse paramExpandResponse)
  {
    try
    {
      if ((paramExpandResponse.b() == 0) && (paramExpandResponse.a() != null))
      {
        paramExpandReqInfo = new ExtendFriendUserCategory.GetUserStatusRsp();
        paramExpandReqInfo.mergeFrom(paramExpandResponse.a());
        EntryExtendForbiddenUtilsImpl.updateForbiddenInfo(paramExpandReqInfo);
        return;
      }
      paramExpandReqInfo = new StringBuilder();
      paramExpandReqInfo.append("getForbiddenInfo. ");
      paramExpandReqInfo.append(paramExpandResponse.d());
      QLog.w("EntryExpandForbiddenUtilsImpl", 1, paramExpandReqInfo.toString());
      return;
    }
    catch (Exception paramExpandReqInfo)
    {
      paramExpandResponse = new StringBuilder();
      paramExpandResponse.append("onProtocol ");
      paramExpandResponse.append(paramExpandReqInfo.toString());
      QLog.e("EntryExpandForbiddenUtilsImpl", 1, paramExpandResponse.toString());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramExpandReqInfo)
    {
      QLog.w("EntryExpandForbiddenUtilsImpl", 1, paramExpandReqInfo.toString());
      paramExpandReqInfo.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.impl.EntryExtendForbiddenUtilsImpl.2
 * JD-Core Version:    0.7.0.1
 */