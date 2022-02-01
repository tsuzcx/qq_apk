package com.tencent.mobileqq.qassistant.core;

import android.content.Intent;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qassistant.proto.oidb_0xebe.CleanSessionReq;
import com.tencent.mobileqq.qassistant.proto.oidb_0xebe.CleanSessionRsp;
import com.tencent.mobileqq.qassistant.proto.oidb_0xebe.ReqBody;
import com.tencent.mobileqq.qassistant.proto.oidb_0xebe.RspBody;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.nio.ByteBuffer;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ClearSessionServlet
  extends MSFServlet
{
  public void a()
  {
    Object localObject2 = AssistantUtils.a().getCurrentAccountUin();
    Object localObject1 = new oidb_0xebe.CleanSessionReq();
    ((oidb_0xebe.CleanSessionReq)localObject1).uint64_uin.set(Long.parseLong((String)localObject2));
    ((oidb_0xebe.CleanSessionReq)localObject1).uint32_version.set(1);
    localObject2 = new oidb_0xebe.ReqBody();
    ((oidb_0xebe.ReqBody)localObject2).msg_clean_session_req.set((MessageMicro)localObject1);
    localObject1 = new NewIntent(AssistantUtils.a(), ClearSessionServlet.class);
    ((NewIntent)localObject1).putExtra("reqBody", ((oidb_0xebe.ReqBody)localObject2).toByteArray());
    AssistantUtils.a().startServlet((NewIntent)localObject1);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramFromServiceMsg.getResultCode();
    paramIntent = new StringBuilder();
    paramIntent.append("AssistantServlet#onReceive, oidbCode:");
    paramIntent.append(i);
    AssistantUtils.a("AssistantServlet", paramIntent.toString());
    if (!paramFromServiceMsg.isSuccess()) {
      return;
    }
    paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
    if (paramFromServiceMsg != null)
    {
      if (paramFromServiceMsg.length == 0) {
        return;
      }
      try
      {
        paramIntent = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg);
        byte[] arrayOfByte = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get(arrayOfByte);
        paramIntent.mergeFrom(arrayOfByte);
        paramFromServiceMsg = paramIntent.bytes_bodybuffer.get().toByteArray();
        AssistantUtils.a("AssistantServlet", String.format("oidbHeader:%s, error:%s", new Object[] { Integer.valueOf(paramIntent.uint32_result.get()), paramIntent.str_error_msg.get() }));
        paramIntent = new oidb_0xebe.RspBody();
        paramIntent.mergeFrom(paramFromServiceMsg);
        paramIntent = (oidb_0xebe.CleanSessionRsp)paramIntent.msg_clean_session_rsp.get();
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        AssistantUtils.a("AssistantServlet", paramIntent.getMessage());
        paramIntent.printStackTrace();
        paramIntent = null;
      }
      if (paramIntent == null) {
        return;
      }
      i = paramIntent.int32_ret_code.get();
      paramIntent = new StringBuilder();
      paramIntent.append("ret code:");
      paramIntent.append(i);
      AssistantUtils.a("AssistantServlet", paramIntent.toString());
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getByteArrayExtra("reqBody");
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(3774);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramIntent));
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.f());
    paramIntent = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localObject = new byte[paramIntent.length + 4];
    PkgTools.dWord2Byte((byte[])localObject, 0, paramIntent.length + 4);
    PkgTools.copyData((byte[])localObject, 4, paramIntent, paramIntent.length);
    paramPacket.setSSOCommand("OidbSvc.0xebe");
    paramPacket.putSendData((byte[])localObject);
    AssistantUtils.a("AssistantServlet", "AssistantServlet#onSend");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.ClearSessionServlet
 * JD-Core Version:    0.7.0.1
 */