package com.tencent.mobileqq.service.push;

import MessageSvcPack.RequestPushStatus;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
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
    String str = paramToServiceMsg.extraData.getString("push_token");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("push_profileid");
    try
    {
      localSvcReqSetToken.vNewToken = str.getBytes("utf-8");
      if (!TextUtils.isEmpty(paramToServiceMsg)) {
        localSvcReqSetToken.vProfileID = paramToServiceMsg.getBytes("utf-8");
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    localSvcReqSetToken.bEnterVersion = 37;
    localSvcReqSetToken.bPushMsg = 1;
    paramUniPacket.put("SvcReqSetToken", localSvcReqSetToken);
    paramUniPacket.setServantName("PushService");
    paramUniPacket.setFuncName("SvcReqSetToken");
    if (QLog.isColorLevel())
    {
      paramUniPacket = new StringBuilder();
      paramUniPacket.append("HPush_requestSetPushToken-encodeRequestMsg-handleReqSetPushToken:");
      paramUniPacket.append(str);
      paramUniPacket.append(",profileid = ");
      paramUniPacket.append(paramToServiceMsg);
      QLog.d("PushService", 2, paramUniPacket.toString());
    }
    return true;
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getWupBuffer() == null) {
      return null;
    }
    return paramFromServiceMsg;
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
    Object localObject = paramFromServiceMsg.getServiceCmd();
    if (((String)localObject).equals("MessageSvc.RequestPushStatus"))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("decodeRespMsg MessageSvc.RequestPushStatus uin:");
        paramToServiceMsg.append(paramFromServiceMsg.getUin());
        paramToServiceMsg.append(" at ");
        paramToServiceMsg.append(System.currentTimeMillis());
        QLog.d("StatusPush", 2, paramToServiceMsg.toString());
      }
      paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
      if (paramToServiceMsg == null) {
        return;
      }
      paramFromServiceMsg = new UniPacket();
      paramFromServiceMsg.decode(paramToServiceMsg);
      paramToServiceMsg = (RequestPushStatus)paramFromServiceMsg.getByClass("req_PushStatus", new RequestPushStatus());
      paramFromServiceMsg = BaseApplication.getContext();
      boolean bool = false;
      paramFromServiceMsg = paramFromServiceMsg.getSharedPreferences("share", 0).edit();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("is_pc_online");
      ((StringBuilder)localObject).append(paramToServiceMsg.lUin);
      localObject = ((StringBuilder)localObject).toString();
      if (paramToServiceMsg.cStatus == 1) {
        bool = true;
      }
      paramFromServiceMsg.putBoolean((String)localObject, bool).commit();
      return;
    }
    if ("baseSdk.Msf.NotifyResp".equals(localObject))
    {
      paramToServiceMsg = new Intent("tencent.notify.album");
      paramToServiceMsg.putExtra("resp", paramFromServiceMsg);
      BaseApplication.getContext().sendBroadcast(paramToServiceMsg, "com.tencent.msg.permission.pushnotify");
      return;
    }
    if ("PushService.SetToken".equalsIgnoreCase((String)localObject)) {
      a(paramToServiceMsg, paramFromServiceMsg);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.push.PushService
 * JD-Core Version:    0.7.0.1
 */