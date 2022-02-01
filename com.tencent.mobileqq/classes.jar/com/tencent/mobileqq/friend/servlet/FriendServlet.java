package com.tencent.mobileqq.friend.servlet;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/friend/servlet/FriendServlet;", "Lmqq/app/MSFServlet;", "()V", "onReceive", "", "request", "Landroid/content/Intent;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSend", "packet", "Lmqq/app/Packet;", "Companion", "IMCore_release"}, k=1, mv={1, 1, 16})
public final class FriendServlet
  extends MSFServlet
{
  public static final FriendServlet.Companion a = new FriendServlet.Companion(null);
  
  public void onReceive(@Nullable Intent paramIntent, @NotNull FromServiceMsg paramFromServiceMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramFromServiceMsg, "response");
    ToServiceMsg localToServiceMsg = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getParcelableExtra(Reflection.getOrCreateKotlinClass(ToServiceMsg.class).getSimpleName());
      Intrinsics.checkExpressionValueIsNotNull(paramIntent, "request.getParcelableExt…iceMsg::class.simpleName)");
      localToServiceMsg = (ToServiceMsg)paramIntent;
      paramIntent = paramFromServiceMsg.attributes;
      Intrinsics.checkExpressionValueIsNotNull(paramIntent, "response.attributes");
      ((Map)paramIntent).put(Reflection.getOrCreateKotlinClass(FromServiceMsg.class).getSimpleName(), localToServiceMsg);
    }
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onReceive| toMsg cmd: ");
      paramIntent.append(localToServiceMsg.getServiceCmd());
      QLog.d("IMCore.friend.FriendServlet", 2, paramIntent.toString());
    }
    paramIntent = getAppRuntime();
    if (paramIntent != null)
    {
      paramIntent = ((AppInterface)paramIntent).getBusinessHandler(Reflection.getOrCreateKotlinClass(FriendHandler.class).getQualifiedName());
      if (paramIntent != null)
      {
        ((FriendHandler)paramIntent).a().a(localToServiceMsg, paramFromServiceMsg);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.friend.handler.FriendHandler");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
  }
  
  public void onSend(@Nullable Intent paramIntent, @Nullable Packet paramPacket)
  {
    String str = null;
    if (paramIntent != null) {
      paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(Reflection.getOrCreateKotlinClass(ToServiceMsg.class).getSimpleName());
    } else {
      paramIntent = null;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSend| toMsg cmd: ");
      if (paramIntent != null) {
        str = paramIntent.getServiceCmd();
      }
      localStringBuilder.append(str);
      QLog.d("IMCore.friend.FriendServlet", 2, localStringBuilder.toString());
    }
    if (paramIntent != null)
    {
      if (paramPacket != null) {
        paramPacket.setSSOCommand(paramIntent.getServiceCmd());
      }
      if (paramPacket != null) {
        paramPacket.putSendData(paramIntent.getWupBuffer());
      }
      if (paramPacket != null) {
        paramPacket.setTimeout(paramIntent.getTimeout());
      }
      if (paramPacket != null) {
        paramPacket.setAttributes(paramIntent.getAttributes());
      }
      if ((!paramIntent.isNeedCallback()) && (paramPacket != null)) {
        paramPacket.setNoResponse();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.servlet.FriendServlet
 * JD-Core Version:    0.7.0.1
 */