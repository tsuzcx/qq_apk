package com.tencent.mobileqq.qqexpand.chat.utils;

import com.tencent.mobileqq.qqexpand.network.ExpandReqInfo;
import com.tencent.mobileqq.qqexpand.network.ExpandResponse;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class LimitChatUtil$5
  implements IExpandCmdCallback
{
  public void onProtocol(@Nullable ExpandReqInfo paramExpandReqInfo, @NotNull ExpandResponse paramExpandResponse)
  {
    paramExpandReqInfo = new StringBuilder();
    paramExpandReqInfo.append("QQExpand.ExpandRelation.AddMatchedRaletion response code=");
    paramExpandReqInfo.append(paramExpandResponse.b());
    paramExpandReqInfo.append(" msg=");
    paramExpandReqInfo.append(paramExpandResponse.c());
    QLog.i("LimitChatUtil", 1, paramExpandReqInfo.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil.5
 * JD-Core Version:    0.7.0.1
 */