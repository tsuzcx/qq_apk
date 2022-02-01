package com.tencent.mobileqq.qqexpand.network.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqexpand.network.ExpandCmdHandler;
import com.tencent.mobileqq.qqexpand.network.ExpandResponse;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdCallback;
import com.tencent.mobileqq.qqexpand.network.IExpandCmdHandler;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/network/impl/ExpandCmdHandlerImpl;", "Lcom/tencent/mobileqq/qqexpand/network/IExpandCmdHandler;", "()V", "sendSSORequest", "", "appInterface", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "cmdString", "", "buffer", "", "callback", "Lcom/tencent/mobileqq/qqexpand/network/IExpandCmdCallback;", "Companion", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandCmdHandlerImpl
  implements IExpandCmdHandler
{
  public static final ExpandCmdHandlerImpl.Companion Companion = new ExpandCmdHandlerImpl.Companion(null);
  @NotNull
  public static final String TAG = "ExpandCmdHandlerImpl";
  
  public void sendSSORequest(@NotNull BaseQQAppInterface paramBaseQQAppInterface, @Nullable String paramString, @Nullable byte[] paramArrayOfByte, @Nullable IExpandCmdCallback paramIExpandCmdCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseQQAppInterface, "appInterface");
    paramBaseQQAppInterface = ExpandCmdHandler.a(paramBaseQQAppInterface);
    if (paramBaseQQAppInterface == null)
    {
      paramBaseQQAppInterface = new StringBuilder();
      paramBaseQQAppInterface.append(paramString);
      paramBaseQQAppInterface.append(" sendSSORequest error handler is null");
      QLog.e("ExpandCmdHandlerImpl", 2, paramBaseQQAppInterface.toString());
      if (paramIExpandCmdCallback != null) {
        paramIExpandCmdCallback.a(null, new ExpandResponse(-1, "handler is null"));
      }
      return;
    }
    paramBaseQQAppInterface.a(paramString, paramArrayOfByte, paramIExpandCmdCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.network.impl.ExpandCmdHandlerImpl
 * JD-Core Version:    0.7.0.1
 */