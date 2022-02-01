package com.tencent.mobileqq.qqexpand.chat.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqexpand.chat.IExpandChatNetworkHelper;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import expand.common.AdvertisingVideo.AbleToGreetReq;
import expand.common.AdvertisingVideo.GreetMsgReportReq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/chat/impl/ExpandChatNetworkHelperImpl;", "Lcom/tencent/mobileqq/qqexpand/chat/IExpandChatNetworkHelper;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "reportGreet", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "matchUin", "", "callback", "Lcom/tencent/mobileqq/qqexpand/network/IExpandCmdCallback;", "requestAbleToGreet", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandChatNetworkHelperImpl
  implements IExpandChatNetworkHelper
{
  @NotNull
  private final String TAG = "ExpandChatNetworkHelperImpl";
  
  @NotNull
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public void reportGreet(@NotNull BaseQQAppInterface paramBaseQQAppInterface, long paramLong, @NotNull IExpandCmdCallback paramIExpandCmdCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramIExpandCmdCallback, "callback");
    AdvertisingVideo.GreetMsgReportReq localGreetMsgReportReq = new AdvertisingVideo.GreetMsgReportReq();
    localGreetMsgReportReq.to_uin.set(paramLong);
    ((IExpandCmdHandler)QRoute.api(IExpandCmdHandler.class)).sendSSORequest(paramBaseQQAppInterface, "QQExpand.AioMsg.GreetMsgReport", localGreetMsgReportReq.toByteArray(), paramIExpandCmdCallback);
    if (QLog.isDebugVersion())
    {
      paramBaseQQAppInterface = this.TAG;
      paramIExpandCmdCallback = new StringBuilder();
      paramIExpandCmdCallback.append("start reportGreet matchUin:");
      paramIExpandCmdCallback.append(paramLong);
      QLog.d(paramBaseQQAppInterface, 1, paramIExpandCmdCallback.toString());
    }
  }
  
  public void requestAbleToGreet(@NotNull BaseQQAppInterface paramBaseQQAppInterface, long paramLong, @NotNull IExpandCmdCallback paramIExpandCmdCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramIExpandCmdCallback, "callback");
    AdvertisingVideo.AbleToGreetReq localAbleToGreetReq = new AdvertisingVideo.AbleToGreetReq();
    localAbleToGreetReq.to_uin.set(paramLong);
    ((IExpandCmdHandler)QRoute.api(IExpandCmdHandler.class)).sendSSORequest(paramBaseQQAppInterface, "QQExpand.AioMsg.AbleToGreet", localAbleToGreetReq.toByteArray(), paramIExpandCmdCallback);
    if (QLog.isDebugVersion())
    {
      paramBaseQQAppInterface = this.TAG;
      paramIExpandCmdCallback = new StringBuilder();
      paramIExpandCmdCallback.append("start requestAbleToGreet matchUin:");
      paramIExpandCmdCallback.append(paramLong);
      QLog.d(paramBaseQQAppInterface, 1, paramIExpandCmdCallback.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.impl.ExpandChatNetworkHelperImpl
 * JD-Core Version:    0.7.0.1
 */