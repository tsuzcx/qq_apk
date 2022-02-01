package com.tencent.mobileqq.qqgift.sso;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.gift.qlive_proxy_svr.nano.AuthInfo;
import com.tencent.gift.qlive_proxy_svr.nano.ProxyReq;
import com.tencent.gift.qlive_proxy_svr.nano.TransInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qqgift.utils.QQGiftCaptureContext;
import com.tencent.mobileqq.service.Cmd2HandlerMapHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class QQGiftBusinessHandler
  extends BusinessHandler
{
  public static final String a = "com.tencent.mobileqq.qqgift.sso.QQGiftBusinessHandler";
  protected static final String[] b = { QQGiftBusinessHandler.class.getName(), "com.tencent.mobileqq.qqlive.sso.QQLiveBusinessHandler" };
  
  protected QQGiftBusinessHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private byte[] a(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    ProxyReq localProxyReq = new ProxyReq();
    localProxyReq.f = paramArrayOfByte;
    localProxyReq.t = "1.1.0";
    paramArrayOfByte = "8.8.17";
    if (TextUtils.isEmpty("8.8.17")) {
      paramArrayOfByte = "";
    }
    localProxyReq.u = paramArrayOfByte;
    localProxyReq.v = paramString1;
    localProxyReq.w = paramString2;
    localProxyReq.x = 109;
    localProxyReq.m = "";
    localProxyReq.r = "";
    localProxyReq.o = new AuthInfo[0];
    localProxyReq.s = new TransInfo[0];
    localProxyReq.y = 0;
    localProxyReq.z = paramInt;
    return MessageNano.toByteArray(localProxyReq);
  }
  
  protected void a(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt2, int paramInt3, BusinessObserver paramBusinessObserver)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    paramBusinessObserver = super.createToServiceMsg("trpc.qlive.qlive_proxy_svr.TrpcProxy.*", paramBusinessObserver);
    paramBusinessObserver.addAttribute("notify_type", Integer.valueOf(paramInt3));
    paramBusinessObserver.addAttribute("cmd", localObject);
    paramBusinessObserver.addAttribute("app_id", Integer.valueOf(paramInt1));
    paramBusinessObserver.putWupBuffer(a(paramInt1, paramArrayOfByte, paramString1, paramString2));
    paramBusinessObserver.extraData.putBoolean("req_pb_protocol_flag", true);
    if (paramInt2 > 0)
    {
      long l = paramInt2;
      paramBusinessObserver.setTimeout(l);
      paramBusinessObserver.setSendTimeout(l);
    }
    if (!Cmd2HandlerMapHelper.a("trpc.qlive.qlive_proxy_svr.TrpcProxy.*")) {
      Cmd2HandlerMapHelper.a("trpc.qlive.qlive_proxy_svr.TrpcProxy.*", b);
    }
    paramString1 = QQGiftCaptureContext.a();
    if (paramString1 == null)
    {
      QLog.e("QQGiftBusinessHandler", 1, "[sendQQGiftReq] appInterface is null");
    }
    else
    {
      paramBusinessObserver.extraData.putString("moduleId", QQGiftCaptureContext.b());
      paramString1.sendToService(paramBusinessObserver);
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("[sendQQGiftReq] onSend cmd:[");
      paramString1.append((String)localObject);
      paramString1.append("]");
      QLog.i("QQGiftBusinessHandler", 2, paramString1.toString());
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = paramFromServiceMsg.getServiceCmd();
    int i = ((Integer)paramToServiceMsg.getAttribute("notify_type")).intValue();
    String str2 = (String)paramToServiceMsg.getAttribute("cmd");
    int j = ((Integer)paramToServiceMsg.getAttribute("app_id")).intValue();
    if (msgCmdFilter(str1))
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("[Gift SSO] onReceive msgCmdFilter, cmd:");
      paramToServiceMsg.append(str1);
      paramToServiceMsg.append(", trulyCmd:[");
      paramToServiceMsg.append(str2);
      paramToServiceMsg.append("]");
      QLog.e("QQGiftBusinessHandler", 1, paramToServiceMsg.toString());
      return;
    }
    boolean bool = paramFromServiceMsg.isSuccess();
    Object localObject;
    if (bool)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[Gift SSO] onReceive cmd[");
        ((StringBuilder)localObject).append(str2);
        ((StringBuilder)localObject).append("] success");
        QLog.i("QQGiftBusinessHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      int k = paramFromServiceMsg.getBusinessFailCode();
      localObject = paramFromServiceMsg.getBusinessFailMsg();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Gift SSO] onReceive cmd[");
        localStringBuilder.append(str2);
        localStringBuilder.append("] fail,, failCode:");
        localStringBuilder.append(k);
        localStringBuilder.append(", failMsg:");
        localStringBuilder.append((String)localObject);
        QLog.i("QQGiftBusinessHandler", 2, localStringBuilder.toString());
      }
    }
    if (paramObject == null)
    {
      paramObject = new StringBuilder();
      paramObject.append("[Gift SSO] onReceive data is null, cmd:");
      paramObject.append(str1);
      paramObject.append(", trulyCmd:[");
      paramObject.append(str2);
      paramObject.append("]");
      QLog.e("QQGiftBusinessHandler", 1, paramObject.toString());
      notifyUI(paramToServiceMsg, i, bool, new QQGiftRspData(j, paramFromServiceMsg, str2, this.seq));
      return;
    }
    notifyUI(paramToServiceMsg, i, bool, new QQGiftRspData(j, paramFromServiceMsg, (byte[])paramObject, str2, this.seq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.sso.QQGiftBusinessHandler
 * JD-Core Version:    0.7.0.1
 */