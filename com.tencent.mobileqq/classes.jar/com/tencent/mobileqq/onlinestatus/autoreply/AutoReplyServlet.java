package com.tencent.mobileqq.onlinestatus.autoreply;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.onlinestatus.utils.MessagePBElemDecoder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.GetDataReq;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.GetDataRsp;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.ReqBody;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.storage.wording_storage.WordingCfg;

public class AutoReplyServlet
  extends MSFServlet
{
  private oidb_sso.OIDBSSOPkg a(FromServiceMsg paramFromServiceMsg)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
    byte[] arrayOfByte = new byte[paramFromServiceMsg.getInt() - 4];
    paramFromServiceMsg.get(arrayOfByte);
    try
    {
      localOIDBSSOPkg.mergeFrom(arrayOfByte);
      return localOIDBSSOPkg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSFServlet", 2, "respGetBirthday|oidb_sso parseFrom byte", paramFromServiceMsg);
      }
    }
    return null;
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    boolean bool = false;
    int i = 0;
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        paramFromServiceMsg = a(paramFromServiceMsg);
        if (paramFromServiceMsg != null)
        {
          int j = paramFromServiceMsg.uint32_result.get();
          if (j == 0) {
            try
            {
              Object localObject = new oidb_cmd0xcd5.RspBody();
              ((oidb_cmd0xcd5.RspBody)localObject).mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
              paramFromServiceMsg = (oidb_cmd0xcd5.GetDataRsp)((oidb_cmd0xcd5.RspBody)localObject).getdata_rsp.get();
              if ((paramFromServiceMsg != null) && (paramFromServiceMsg.flag.get() != 1) && (paramFromServiceMsg.pb_data.has()))
              {
                paramFromServiceMsg = paramFromServiceMsg.pb_data.get().toByteArray();
                localObject = new wording_storage.WordingCfg();
                ((wording_storage.WordingCfg)localObject).mergeFrom(paramFromServiceMsg);
                if (((wording_storage.WordingCfg)localObject).select_id.has()) {
                  i = ((wording_storage.WordingCfg)localObject).select_id.get();
                }
                paramFromServiceMsg = ((wording_storage.WordingCfg)localObject).wording_list.get();
                if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > i))
                {
                  paramFromServiceMsg = ((im_msg_body.RichText)paramFromServiceMsg.get(i)).elems.get();
                  localBundle.putString("key_auto_reply", new MessagePBElemDecoder().a(paramFromServiceMsg));
                }
              }
              bool = true;
            }
            catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
            {
              bool = true;
              break label253;
            }
          }
        }
        bool = false;
        try
        {
          notifyObserver(paramIntent, 12485, bool, localBundle, null);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
      }
      else
      {
        bool = false;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      label253:
      QLog.e("MSFServlet", 1, "decode err: ", paramFromServiceMsg);
    }
    notifyObserver(paramIntent, 12485, bool, localBundle, null);
  }
  
  private static void a(AppRuntime paramAppRuntime, int paramInt, String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    if (paramAppRuntime == null)
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("sendRequest QQAppInterface is null, command is ");
      paramAppRuntime.append(paramString);
      QLog.e("MSFServlet", 1, paramAppRuntime.toString());
      return;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramArrayOfByte = new NewIntent(paramAppRuntime.getApp(), AutoReplyServlet.class);
    paramArrayOfByte.putExtra("cmd", paramString);
    paramArrayOfByte.putExtra("data", localOIDBSSOPkg.toByteArray());
    paramArrayOfByte.setObserver(paramBusinessObserver);
    paramAppRuntime.startServlet(paramArrayOfByte);
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, BusinessObserver paramBusinessObserver)
  {
    oidb_cmd0xcd5.ReqBody localReqBody = new oidb_cmd0xcd5.ReqBody();
    oidb_cmd0xcd5.GetDataReq localGetDataReq = new oidb_cmd0xcd5.GetDataReq();
    localGetDataReq.query_type.set(3);
    localGetDataReq.target_uin.set(Long.parseLong(paramString));
    localReqBody.getdata_req.set(localGetDataReq);
    localReqBody.service_type.set(1);
    a(paramAppRuntime, 3285, "OidbSvc.0xcd5", localReqBody.toByteArray(), paramBusinessObserver);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MSFServlet", 2, "onReceive");
    }
    if (paramIntent != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      if ("OidbSvc.0xcd5".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramIntent, paramFromServiceMsg);
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramIntent = paramIntent.getStringExtra("cmd");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSend, cmd is ");
    localStringBuilder.append(paramIntent);
    QLog.i("MSFServlet", 1, localStringBuilder.toString());
    paramPacket.setSSOCommand(paramIntent);
    paramPacket.putSendData(WupUtil.a(arrayOfByte));
    if (QLog.isColorLevel()) {
      QLog.i("MSFServlet", 2, "onSend exit");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.autoreply.AutoReplyServlet
 * JD-Core Version:    0.7.0.1
 */