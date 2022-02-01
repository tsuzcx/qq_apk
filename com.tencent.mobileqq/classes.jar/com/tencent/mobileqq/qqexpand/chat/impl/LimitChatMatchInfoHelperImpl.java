package com.tencent.mobileqq.qqexpand.chat.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatMatchInfoHelper;
import com.tencent.mobileqq.qqexpand.chat.LimitChatMatchInfoHelper;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback;
import expand.common.MatchedInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/chat/impl/LimitChatMatchInfoHelperImpl;", "Lcom/tencent/mobileqq/qqexpand/chat/ILimitChatMatchInfoHelper;", "()V", "getIceBreakAioType", "", "matchedInfo", "Lexpand/common/MatchedInfo;", "getMatchInfoRequest", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "uin", "", "callback", "Lcom/tencent/mobileqq/qqexpand/network/IExpandCmdCallback;", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class LimitChatMatchInfoHelperImpl
  implements ILimitChatMatchInfoHelper
{
  public int getIceBreakAioType(@Nullable MatchedInfo paramMatchedInfo)
  {
    return LimitChatMatchInfoHelper.a(paramMatchedInfo);
  }
  
  public void getMatchInfoRequest(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString, @Nullable IExpandCmdCallback paramIExpandCmdCallback)
  {
    LimitChatMatchInfoHelper.a(paramBaseQQAppInterface, paramString, paramIExpandCmdCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.impl.LimitChatMatchInfoHelperImpl
 * JD-Core Version:    0.7.0.1
 */