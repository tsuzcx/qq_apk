package com.tencent.mobileqq.qqexpand.network;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/network/IExpandCmdHandler;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "sendDirectConnectSSORequest", "", "appInterface", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "cmdString", "", "buffer", "", "callback", "Lcom/tencent/mobileqq/qqexpand/network/IExpandCmdCallback;", "sendSSORequest", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandCmdHandler
  extends QRouteApi
{
  public abstract void sendDirectConnectSSORequest(@NotNull BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString, @Nullable byte[] paramArrayOfByte, @Nullable IExpandCmdCallback paramIExpandCmdCallback);
  
  public abstract void sendSSORequest(@NotNull BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString, @Nullable byte[] paramArrayOfByte, @Nullable IExpandCmdCallback paramIExpandCmdCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.network.IExpandCmdHandler
 * JD-Core Version:    0.7.0.1
 */