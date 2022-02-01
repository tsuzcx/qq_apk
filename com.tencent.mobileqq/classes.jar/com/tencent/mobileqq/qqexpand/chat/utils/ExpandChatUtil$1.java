package com.tencent.mobileqq.qqexpand.chat.utils;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendCardUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqexpand.network.ExpandReqInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandResponse;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqexpand.entrance.entrance.Entrance.EntranceGetRsp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class ExpandChatUtil$1
  implements IExpandCmdCallback
{
  ExpandChatUtil$1(QQAppInterface paramQQAppInterface) {}
  
  public void onProtocol(@Nullable ExpandReqInfo paramExpandReqInfo, @NotNull ExpandResponse paramExpandResponse)
  {
    if (QLog.isColorLevel())
    {
      paramExpandReqInfo = new StringBuilder();
      paramExpandReqInfo.append("requestContactsEntranceInfo get errorCode:");
      paramExpandReqInfo.append(paramExpandResponse.b());
      QLog.d("ExpandFriendChatUtil", 2, paramExpandReqInfo.toString());
    }
    int i = paramExpandResponse.b();
    boolean bool = true;
    if (i == 1000)
    {
      paramExpandReqInfo = new Entrance.EntranceGetRsp();
      try
      {
        paramExpandReqInfo.mergeFrom(paramExpandResponse.a());
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        QLog.e("ExpandFriendChatUtil", 1, "rsp.mergeFrom error", localInvalidProtocolBufferMicroException);
      }
      ExtendFriendCardUtils.a(this.a, paramExpandReqInfo);
    }
    else
    {
      paramExpandReqInfo = new StringBuilder();
      paramExpandReqInfo.append("extend friend entrance get fail errorInfo:");
      paramExpandReqInfo.append(paramExpandResponse.d());
      QLog.e("ExpandFriendChatUtil", 1, paramExpandReqInfo.toString());
    }
    paramExpandReqInfo = (IExpandHandler)this.a.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (paramExpandReqInfo != null)
    {
      if (paramExpandResponse.b() != 1000) {
        bool = false;
      }
      paramExpandReqInfo.notifyUI(34, bool, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil.1
 * JD-Core Version:    0.7.0.1
 */