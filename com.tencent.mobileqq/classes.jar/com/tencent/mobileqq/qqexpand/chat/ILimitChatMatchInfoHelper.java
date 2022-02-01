package com.tencent.mobileqq.qqexpand.chat;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import expand.common.MatchedInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/chat/ILimitChatMatchInfoHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getIceBreakAioType", "", "matchedInfo", "Lexpand/common/MatchedInfo;", "getMatchInfoRequest", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "uin", "", "callback", "Lcom/tencent/mobileqq/qqexpand/network/IExpandCmdCallback;", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ILimitChatMatchInfoHelper
  extends QRouteApi
{
  public abstract int getIceBreakAioType(@Nullable MatchedInfo paramMatchedInfo);
  
  public abstract void getMatchInfoRequest(@Nullable BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString, @Nullable IExpandCmdCallback paramIExpandCmdCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.ILimitChatMatchInfoHelper
 * JD-Core Version:    0.7.0.1
 */