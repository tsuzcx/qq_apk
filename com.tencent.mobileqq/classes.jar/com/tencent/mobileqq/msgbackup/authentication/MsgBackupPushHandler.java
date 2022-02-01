package com.tencent.mobileqq.msgbackup.authentication;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.data.MsgBackupConfirmQrRsp.Builder;
import com.tencent.mobileqq.msgbackup.data.MsgBackupPushData.Builder;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData.Builder;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.TransMsgContext;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_head.InstCtrl;
import tencent.im.msg.im_msg_head.InstInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x11a.submsgtype0x11a.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x11a.submsgtype0x11a.UserData;
import tencent.im.s2c.msgtype0x210.submsgtype0x11b.submsgtype0x11b.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd;

public class MsgBackupPushHandler
{
  private static MsgBackupPushHandler a;
  
  public static MsgBackupPushHandler a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new MsgBackupPushHandler();
        }
      }
      finally {}
    }
    return a;
  }
  
  private MsgBackupUserData a(submsgtype0x11a.UserData paramUserData)
  {
    MsgBackupUserData.Builder localBuilder = new MsgBackupUserData.Builder();
    if (paramUserData.bytes_ip.has()) {
      localBuilder.a(paramUserData.bytes_ip.get().toStringUtf8());
    }
    if (paramUserData.rpt_fixed32_port.has()) {
      localBuilder.a(paramUserData.rpt_fixed32_port.get());
    }
    if (paramUserData.bytes_bssid.has()) {
      localBuilder.c(paramUserData.bytes_bssid.get().toStringUtf8());
    }
    if (paramUserData.bytes_ssid.has()) {
      localBuilder.b(paramUserData.bytes_ssid.get().toStringUtf8());
    }
    if (paramUserData.enum_platform.has()) {
      localBuilder.a(paramUserData.enum_platform.get());
    }
    return localBuilder.a();
  }
  
  private String a()
  {
    Object localObject = new JSONArray();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("cmd", "exit");
      localJSONObject.put("sig", MsgBackupAuthProcessor.a().a());
      ((JSONArray)localObject).put(localJSONObject);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    localObject = ((JSONArray)localObject).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getExitJsonStr create: ");
      localStringBuilder.append((String)localObject);
      QLog.d("MsgBackup.MsgBackupPushHandler", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("processOnlinePush0x211 receive: res.getResultCode() = ");
      paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
      QLog.d("MsgBackup.MsgBackupPushHandler", 2, paramToServiceMsg.toString());
    }
    if (paramFromServiceMsg.getResultCode() != 1000) {
      a(a());
    }
  }
  
  public void a(String paramString)
  {
    Object localObject2 = new SubMsgType0x7.MsgBody.GenericSubCmd();
    ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint64_sessionid.set(1L);
    ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint32_size.set(1);
    ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint32_index.set(0);
    ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint32_type.set(7);
    ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).bytes_buf.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).uint32_support_auth.set(1);
    ((SubMsgType0x7.MsgBody.GenericSubCmd)localObject2).setHasFlag(true);
    Object localObject3 = new SubMsgType0x7.MsgBody();
    ((SubMsgType0x7.MsgBody)localObject3).uint32_sub_cmd.set(4);
    paramString = (BaseQQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    Object localObject1 = (IMsgBackupTempApi)QRoute.api(IMsgBackupTempApi.class);
    ((IMsgBackupTempApi)localObject1).fillMsgHeader(paramString, ((SubMsgType0x7.MsgBody)localObject3).msg_header, Long.valueOf(paramString.getCurrentAccountUin()));
    ((SubMsgType0x7.MsgBody)localObject3).msg_subcmd_0x4_generic.set((MessageMicro)localObject2);
    ((SubMsgType0x7.MsgBody)localObject3).setHasFlag(true);
    localObject2 = new TransMsgContext();
    localObject3 = ((SubMsgType0x7.MsgBody)localObject3).toByteArray();
    ((TransMsgContext)localObject2).jdField_a_of_type_Int = 7;
    ((TransMsgContext)localObject2).jdField_a_of_type_ArrayOfByte = ((byte[])localObject3);
    long l1 = QQFileManagerUtil.b();
    long l2 = QQFileManagerUtil.a();
    localObject1 = ((IMsgBackupTempApi)localObject1).createPbSendMsgReq(paramString, 13, paramString.getCurrentUin(), (TransMsgContext)localObject2, l2, MessageUtils.b(l1));
    localObject2 = new im_msg_head.InstInfo();
    ((im_msg_head.InstInfo)localObject2).uint32_apppid.set(1);
    ((im_msg_head.InstInfo)localObject2).uint32_instid.set(0);
    ((im_msg_head.InstInfo)localObject2).enum_device_type.set(2);
    ((im_msg_head.InstInfo)localObject2).setHasFlag(true);
    ((msg_svc.PbSendMsgReq)localObject1).routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add((MessageMicro)localObject2);
    localObject2 = new im_msg_head.InstInfo();
    ((im_msg_head.InstInfo)localObject2).uint32_apppid.set(1001);
    ((im_msg_head.InstInfo)localObject2).uint32_instid.set(AppSetting.a());
    ((im_msg_head.InstInfo)localObject2).enum_device_type.set(2);
    ((im_msg_head.InstInfo)localObject2).setHasFlag(true);
    ((msg_svc.PbSendMsgReq)localObject1).routing_head.trans_0x211.inst_ctrl.msg_from_inst = ((im_msg_head.InstInfo)localObject2);
    ((msg_svc.PbSendMsgReq)localObject1).routing_head.trans_0x211.inst_ctrl.setHasFlag(true);
    localObject2 = new ToServiceMsg("mobileqq.service", paramString.getCurrentAccountUin(), "MessageSvc.PbSendMsg");
    ((ToServiceMsg)localObject2).putWupBuffer(((msg_svc.PbSendMsgReq)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putBoolean("req_pb_protocol_flag", true);
    ((ToServiceMsg)localObject2).extraData.putBoolean("exit_push_0x211_key", true);
    paramString.sendToService((ToServiceMsg)localObject2);
  }
  
  public void a(submsgtype0x11a.MsgBody paramMsgBody)
  {
    if (paramMsgBody != null)
    {
      Object localObject = new MsgBackupConfirmQrRsp.Builder();
      if (paramMsgBody.enum_result.has())
      {
        int i = paramMsgBody.enum_result.get();
        if (i == 0)
        {
          if (paramMsgBody.bytes_token.has()) {
            ((MsgBackupConfirmQrRsp.Builder)localObject).a(paramMsgBody.bytes_token.get().toStringUtf8());
          }
          if (paramMsgBody.bytes_encrypt_key.has()) {
            ((MsgBackupConfirmQrRsp.Builder)localObject).b(paramMsgBody.bytes_encrypt_key.get().toStringUtf8());
          }
          if (paramMsgBody.msg_user_data.has()) {
            ((MsgBackupConfirmQrRsp.Builder)localObject).a(a((submsgtype0x11a.UserData)paramMsgBody.msg_user_data.get()));
          }
          if (paramMsgBody.enum_biz_type.has()) {
            ((MsgBackupConfirmQrRsp.Builder)localObject).a(paramMsgBody.enum_biz_type.get());
          }
          paramMsgBody = ((MsgBackupConfirmQrRsp.Builder)localObject).a();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("processOnLinePush receive processOnLinePush0x11a response = ");
            ((StringBuilder)localObject).append(paramMsgBody);
            QLog.d("MsgBackup.MsgBackupPushHandler", 2, ((StringBuilder)localObject).toString());
          }
          MsgBackupManager.a().a(paramMsgBody);
          return;
        }
        if (i == 6)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupPushHandler", 2, "processOnLinePush receive 0x210_0x11a， 对端拒绝了！");
          }
          MsgBackupManager.a().a(Integer.valueOf(6));
          return;
        }
        if (i == 20)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupPushHandler", 2, "processOnLinePush receive 0x210_0x11a， 内部错误");
          }
          MsgBackupManager.a().a(Integer.valueOf(20));
        }
      }
    }
  }
  
  public void a(submsgtype0x11b.MsgBody paramMsgBody)
  {
    if (paramMsgBody != null)
    {
      Object localObject = new MsgBackupPushData.Builder();
      if (paramMsgBody.bytes_qr_sig.has()) {
        ((MsgBackupPushData.Builder)localObject).a(paramMsgBody.bytes_qr_sig.get().toStringUtf8());
      }
      if (paramMsgBody.enum_biz_type.has()) {
        ((MsgBackupPushData.Builder)localObject).a(paramMsgBody.enum_biz_type.get());
      }
      paramMsgBody = ((MsgBackupPushData.Builder)localObject).a();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("processOnLinePush receive processOnLinePush0x11b ");
        ((StringBuilder)localObject).append(paramMsgBody);
        QLog.d("MsgBackup.MsgBackupPushHandler", 2, ((StringBuilder)localObject).toString());
      }
      MsgBackupManager.a().a(paramMsgBody);
      return;
    }
    MsgBackupManager.a().a(null);
  }
  
  public void a(SubMsgType0x7.MsgBody.GenericSubCmd paramGenericSubCmd)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupPushHandler", 2, "processExit0x7-------------->");
    }
    if (paramGenericSubCmd.bytes_buf.has())
    {
      paramGenericSubCmd = paramGenericSubCmd.bytes_buf.get().toStringUtf8();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("processExit0x7, genericSubCmd: ");
        localStringBuilder.append(paramGenericSubCmd);
        QLog.d("MsgBackup.MsgBackupPushHandler", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(paramGenericSubCmd)) {
        try
        {
          paramGenericSubCmd = new JSONArray(paramGenericSubCmd);
          if (paramGenericSubCmd.length() == 1)
          {
            paramGenericSubCmd = (JSONObject)paramGenericSubCmd.get(0);
            if ("exit".equals(paramGenericSubCmd.optString("cmd")))
            {
              paramGenericSubCmd = paramGenericSubCmd.optString("sig");
              if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupPushHandler", 2, "-------------------exit-------------------");
              }
              if (TextUtils.equals(paramGenericSubCmd, MsgBackupAuthProcessor.a().a()))
              {
                MsgBackupTransportProcessor.a().b(true);
                return;
              }
            }
          }
        }
        catch (JSONException paramGenericSubCmd)
        {
          QLog.e("MsgBackup.MsgBackupPushHandler", 2, "processExit0x7 parse json error!", paramGenericSubCmd);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.authentication.MsgBackupPushHandler
 * JD-Core Version:    0.7.0.1
 */