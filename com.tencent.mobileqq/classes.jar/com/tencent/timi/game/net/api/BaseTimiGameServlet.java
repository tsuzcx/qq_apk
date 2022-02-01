package com.tencent.timi.game.net.api;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.timi.game.utils.DeviceInfoManager;
import com.tencent.timi.game.utils.Logger;
import com.tencent.util.QQDeviceInfo;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import trpc.yes.common.BaseInterfaceOuterClass.CSQQAccessBaseInfo;
import trpc.yes.common.BaseInterfaceOuterClass.CSQQAccessReply;
import trpc.yes.common.BaseInterfaceOuterClass.CSQQAccessReqHeader;
import trpc.yes.common.BaseInterfaceOuterClass.CSQQAccessRequest;
import trpc.yes.common.BaseInterfaceOuterClass.CSQQAccessRspHeader;
import trpc.yes.common.BaseInterfaceOuterClass.NetInfo;
import trpc.yes.common.BaseInterfaceOuterClass.Terminal;

public abstract class BaseTimiGameServlet
  extends MSFServlet
{
  protected abstract int a();
  
  protected byte[] a(Intent paramIntent)
  {
    return paramIntent.getByteArrayExtra("bytes");
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int k = a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("req_cmd", k);
    if (paramFromServiceMsg != null)
    {
      localBundle.putParcelable("msf_data", paramFromServiceMsg);
      localBundle.putInt("msf_code", paramFromServiceMsg.getResultCode());
    }
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localBundle.putBoolean("msf_success", bool1);
    if (paramFromServiceMsg == null)
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("onReceive cmd=");
      paramFromServiceMsg.append(k);
      paramFromServiceMsg.append(", response is null");
      Logger.c("NetCore_BaseTimiGameServlet_", paramFromServiceMsg.toString());
    }
    for (;;)
    {
      bool1 = false;
      break label577;
      if (paramFromServiceMsg.isSuccess()) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive cmd=");
      localStringBuilder.append(k);
      localStringBuilder.append(", msf not success - ");
      localStringBuilder.append(paramFromServiceMsg.getResultCode());
      Logger.c("NetCore_BaseTimiGameServlet_", localStringBuilder.toString());
    }
    Object localObject2 = WupUtil.b(paramFromServiceMsg.getWupBuffer());
    Object localObject3 = null;
    try
    {
      paramFromServiceMsg = new BaseInterfaceOuterClass.CSQQAccessReply();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])localObject2);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1) {}
      localInvalidProtocolBufferMicroException2.printStackTrace();
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
    {
      paramFromServiceMsg = null;
    }
    Object localObject1 = paramFromServiceMsg.get();
    int i = -9999;
    int j;
    if ((localObject1 != null) && (paramFromServiceMsg.rsp_header != null))
    {
      localObject3 = paramFromServiceMsg.rsp_header;
      paramFromServiceMsg = paramFromServiceMsg.rsp_body.get().toByteArray();
      i = ((BaseInterfaceOuterClass.CSQQAccessRspHeader)localObject3).error_code.get();
      localObject1 = ((BaseInterfaceOuterClass.CSQQAccessRspHeader)localObject3).error_message.get();
      localObject2 = ((BaseInterfaceOuterClass.CSQQAccessRspHeader)localObject3).disply_error_message.get();
      j = ((BaseInterfaceOuterClass.CSQQAccessRspHeader)localObject3).system_error_sub_code.get();
      bool1 = bool2;
      if (i == 0) {
        bool1 = true;
      }
      if (bool1)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onReceive cmd=");
        ((StringBuilder)localObject3).append(k);
        ((StringBuilder)localObject3).append(", timi notify success!");
        Logger.a("NetCore_BaseTimiGameServlet_", ((StringBuilder)localObject3).toString());
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onReceive cmd=");
        ((StringBuilder)localObject3).append(k);
        ((StringBuilder)localObject3).append(", timi notify error, timiErrorCode=");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append(", timiErrorMsg=");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(", timiDisplayErrorMsg=");
        ((StringBuilder)localObject3).append((String)localObject2);
        Logger.c("NetCore_BaseTimiGameServlet_", ((StringBuilder)localObject3).toString());
      }
    }
    else
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("onReceive cmd=");
      paramFromServiceMsg.append(k);
      paramFromServiceMsg.append(", decode CSQQAccessReply fail - ");
      paramFromServiceMsg.append(localObject2);
      Logger.c("NetCore_BaseTimiGameServlet_", paramFromServiceMsg.toString());
      localObject1 = "";
      localObject2 = "回包解析失败";
      j = -9999;
      paramFromServiceMsg = (FromServiceMsg)localObject3;
      bool1 = bool3;
    }
    localBundle.putInt("timi_code", i);
    if (paramFromServiceMsg != null) {
      localBundle.putByteArray("timi_data", paramFromServiceMsg);
    }
    localBundle.putString("timi_errmsg", (String)localObject1);
    localBundle.putString("timi_displaymsg", (String)localObject2);
    localBundle.putInt("timi_subcode", j);
    label577:
    notifyObserver(paramIntent, 0, bool1, localBundle, null);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = a();
    if (paramIntent == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend bad request, cmd=");
      paramIntent.append(i);
      Logger.c("NetCore_BaseTimiGameServlet_", paramIntent.toString());
      return;
    }
    if (paramPacket == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("onSend bad packet, cmd=");
      paramIntent.append(i);
      Logger.c("NetCore_BaseTimiGameServlet_", paramIntent.toString());
      return;
    }
    Object localObject2 = new BaseInterfaceOuterClass.Terminal();
    ((BaseInterfaceOuterClass.Terminal)localObject2).qimei.set(QQDeviceInfo.getQIMEI());
    ((BaseInterfaceOuterClass.Terminal)localObject2).phone_system.set(2);
    ((BaseInterfaceOuterClass.Terminal)localObject2).platform_type.set(2);
    ((BaseInterfaceOuterClass.Terminal)localObject2).client_version.set(DeviceInfoManager.a().c());
    Object localObject3 = new BaseInterfaceOuterClass.NetInfo();
    ((BaseInterfaceOuterClass.NetInfo)localObject3).client_ip.set(DeviceInfoManager.a().d());
    Object localObject1 = new BaseInterfaceOuterClass.CSQQAccessBaseInfo();
    ((BaseInterfaceOuterClass.CSQQAccessBaseInfo)localObject1).terminal.set((MessageMicro)localObject2);
    ((BaseInterfaceOuterClass.CSQQAccessBaseInfo)localObject1).net_info.set((MessageMicro)localObject3);
    localObject3 = new BaseInterfaceOuterClass.CSQQAccessReqHeader();
    ((BaseInterfaceOuterClass.CSQQAccessReqHeader)localObject3).cmd.set(i);
    localObject2 = new BaseInterfaceOuterClass.CSQQAccessRequest();
    ((BaseInterfaceOuterClass.CSQQAccessRequest)localObject2).base_info.set((MessageMicro)localObject1);
    ((BaseInterfaceOuterClass.CSQQAccessRequest)localObject2).req_header.set((MessageMicro)localObject3);
    paramIntent = a(paramIntent);
    if ((paramIntent != null) && (paramIntent.length > 0)) {
      ((BaseInterfaceOuterClass.CSQQAccessRequest)localObject2).req_body.set(ByteStringMicro.copyFrom(paramIntent));
    }
    localObject1 = ((BaseInterfaceOuterClass.CSQQAccessRequest)localObject2).toByteArray();
    paramPacket.setSSOCommand("trpc.yes.qq_access_proxy.QQAccess.ClientDo");
    paramPacket.putSendData(WupUtil.a((byte[])localObject1));
    paramPacket = new StringBuilder();
    paramPacket.append("onSend cmd=");
    paramPacket.append(i);
    paramPacket.append(", requestBody.size= ");
    if (paramIntent != null) {
      i = paramIntent.length;
    } else {
      i = -1;
    }
    paramPacket.append(i);
    Logger.a("NetCore_BaseTimiGameServlet_", paramPacket.toString());
  }
  
  protected void sendToMSF(Intent paramIntent, ToServiceMsg paramToServiceMsg)
  {
    super.sendToMSF(paramIntent, paramToServiceMsg);
    paramIntent = new StringBuilder();
    paramIntent.append("sendToMSF cmd=");
    paramIntent.append(a());
    paramIntent.append(", appSeq= ");
    paramIntent.append(paramToServiceMsg.getAppSeq());
    Logger.a("NetCore_BaseTimiGameServlet_", paramIntent.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.net.api.BaseTimiGameServlet
 * JD-Core Version:    0.7.0.1
 */