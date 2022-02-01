package com.tencent.mobileqq.service.push;

import MessageSvcPack.RequestPushStatus;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.msf.service.protocol.push.SvcReqSetToken;
import com.tencent.msf.service.protocol.push.SvcRespSetToken;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;

public class PushService
  extends BaseProtocolCoder
{
  private static final String[] a = { "Push", "PushService" };
  
  private Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRespSetToken)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRespSetToken", new SvcRespSetToken());
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    SvcReqSetToken localSvcReqSetToken = new SvcReqSetToken();
    paramToServiceMsg = paramToServiceMsg.extraData.getString("push_token");
    try
    {
      localSvcReqSetToken.vNewToken = paramToServiceMsg.getBytes("utf-8");
      localSvcReqSetToken.bEnterVersion = 37;
      localSvcReqSetToken.bPushMsg = 1;
      paramUniPacket.put("SvcReqSetToken", localSvcReqSetToken);
      paramUniPacket.setServantName("PushService");
      paramUniPacket.setFuncName("SvcReqSetToken");
      if (QLog.isColorLevel()) {
        QLog.d("PushService", 2, "HPush_requestSetPushToken-encodeRequestMsg-handleReqSetPushToken:");
      }
      return true;
    }
    catch (UnsupportedEncodingException paramToServiceMsg)
    {
      for (;;)
      {
        paramToServiceMsg.printStackTrace();
      }
    }
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg;
    if (paramFromServiceMsg.getWupBuffer() == null) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return a;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("MessageSvc.PushNotify")) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
  
  public void decodeRespMsg(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (str.equals("MessageSvc.RequestPushStatus"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StatusPush", 2, "decodeRespMsg MessageSvc.RequestPushStatus uin:" + paramFromServiceMsg.getUin() + " at " + System.currentTimeMillis());
      }
      paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
      if (paramToServiceMsg != null) {}
    }
    do
    {
      return;
      paramFromServiceMsg = new UniPacket();
      paramFromServiceMsg.decode(paramToServiceMsg);
      paramToServiceMsg = (RequestPushStatus)paramFromServiceMsg.getByClass("req_PushStatus", new RequestPushStatus());
      paramFromServiceMsg = BaseApplication.getContext().getSharedPreferences("share", 0).edit();
      str = "is_pc_online" + paramToServiceMsg.lUin;
      if (paramToServiceMsg.cStatus == 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramFromServiceMsg.putBoolean(str, bool).commit();
        return;
      }
      if ("baseSdk.Msf.NotifyResp".equals(str))
      {
        paramToServiceMsg = new Intent("tencent.notify.album");
        paramToServiceMsg.putExtra("resp", paramFromServiceMsg);
        BaseApplication.getContext().sendBroadcast(paramToServiceMsg, "com.tencent.msg.permission.pushnotify");
        return;
      }
    } while (!"PushService.SetToken".equalsIgnoreCase(str));
    a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void destroy() {}
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("PushService.SetToken")) {
      return a(paramToServiceMsg, paramUniPacket);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.push.PushService
 * JD-Core Version:    0.7.0.1
 */