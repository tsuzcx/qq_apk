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
    Object localObject = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getParcelableExtra(Reflection.getOrCreateKotlinClass(ToServiceMsg.class).getSimpleName());
      Intrinsics.checkExpressionValueIsNotNull(paramIntent, "request.getParcelableExt…iceMsg::class.simpleName)");
      paramIntent = (ToServiceMsg)paramIntent;
      localObject = paramFromServiceMsg.attributes;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "response.attributes");
      ((Map)localObject).put(Reflection.getOrCreateKotlinClass(FromServiceMsg.class).getSimpleName(), paramIntent);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.FriendServlet", 2, "onReceive| toMsg cmd: " + paramIntent.getServiceCmd());
      }
      localObject = getAppRuntime();
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
      }
      localObject = ((AppInterface)localObject).getBusinessHandler(Reflection.getOrCreateKotlinClass(FriendHandler.class).getQualifiedName());
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.friend.handler.FriendHandler");
      }
      ((FriendHandler)localObject).a().a(paramIntent, paramFromServiceMsg);
      return;
      paramIntent = (Intent)localObject;
    }
  }
  
  public void onSend(@Nullable Intent paramIntent, @Nullable Packet paramPacket)
  {
    String str = null;
    if (paramIntent != null) {}
    for (paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(Reflection.getOrCreateKotlinClass(ToServiceMsg.class).getSimpleName());; paramIntent = null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("onSend| toMsg cmd: ");
        if (paramIntent != null) {
          str = paramIntent.getServiceCmd();
        }
        QLog.d("IMCore.friend.FriendServlet", 2, str);
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
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.servlet.FriendServlet
 * JD-Core Version:    0.7.0.1
 */