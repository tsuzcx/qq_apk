package com.tencent.mobileqq.qqexpand.chat;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/chat/IExpandChatNetworkHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "reportGreet", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "matchUin", "", "callback", "Lcom/tencent/mobileqq/qqexpand/network/IExpandCmdCallback;", "requestAbleToGreet", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandChatNetworkHelper
  extends QRouteApi
{
  public abstract void reportGreet(@NotNull BaseQQAppInterface paramBaseQQAppInterface, long paramLong, @NotNull IExpandCmdCallback paramIExpandCmdCallback);
  
  public abstract void requestAbleToGreet(@NotNull BaseQQAppInterface paramBaseQQAppInterface, long paramLong, @NotNull IExpandCmdCallback paramIExpandCmdCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.IExpandChatNetworkHelper
 * JD-Core Version:    0.7.0.1
 */