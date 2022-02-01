package com.tencent.mobileqq.qqlive.sso;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.datareport.IDataReportModule;
import com.tencent.mobileqq.qqlive.data.datareport.ReportTask;
import com.tencent.mobileqq.qqlive.utils.QQLiveCaptureContext;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.Cmd2HandlerMapHelper;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qlive.qlive_proxy_svr.qlive_proxy_svr.nano.AuthInfo;
import com.tencent.trpcprotocol.qlive.qlive_proxy_svr.qlive_proxy_svr.nano.ProxyReq;
import com.tencent.trpcprotocol.qlive.qlive_proxy_svr.qlive_proxy_svr.nano.TransInfo;
import java.util.concurrent.ConcurrentHashMap;

public class QQLiveBusinessHandler
  extends BusinessHandler
{
  public static final String a = "com.tencent.mobileqq.qqlive.sso.QQLiveBusinessHandler";
  protected static final String[] b = { QQLiveBusinessHandler.class.getName(), "com.tencent.mobileqq.qqgift.sso.QQGiftBusinessHandler" };
  private boolean c = false;
  private ConcurrentHashMap<String, IQQLiveSSOCommonHeader> d = new ConcurrentHashMap();
  
  protected QQLiveBusinessHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(String paramString1, long paramLong, String paramString2)
  {
    if (this.c) {
      return;
    }
    Object localObject = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(paramString1);
    if (localObject == null)
    {
      QLog.e("QQLiveBusinessHandler", 1, "reportSsoRequestTime get sdk null");
      return;
    }
    IQQLiveSSOCommonHeader localIQQLiveSSOCommonHeader = (IQQLiveSSOCommonHeader)this.d.get(paramString1);
    if (localIQQLiveSSOCommonHeader == null)
    {
      QLog.e("QQLiveBusinessHandler", 1, "reportSsoRequestTime get IQQLiveSSOCommonHeader is null");
      return;
    }
    if (localIQQLiveSSOCommonHeader.a() % 10L != 5L)
    {
      this.c = true;
      if (QLog.isColorLevel()) {
        QLog.e("QQLiveBusinessHandler", 1, "reportSsoRequestTime PublicVersion Filter");
      }
      return;
    }
    localObject = ((IQQLiveSDK)localObject).getDataReportModule().newReportTask().setEventName("sso_cost_time");
    ((ReportTask)localObject).addKeyValue("appid", paramString1);
    ((ReportTask)localObject).addKeyValue("uid", localIQQLiveSSOCommonHeader.a());
    ((ReportTask)localObject).addKeyValue("version", localIQQLiveSSOCommonHeader.g());
    if (!TextUtils.isEmpty(paramString2)) {
      ((ReportTask)localObject).addKeyValue("service", paramString2);
    }
    ((ReportTask)localObject).addKeyValue("costtime", paramLong);
    ((ReportTask)localObject).send();
  }
  
  private byte[] a(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3)
  {
    IQQLiveSSOCommonHeader localIQQLiveSSOCommonHeader = (IQQLiveSSOCommonHeader)this.d.get(paramString1);
    ProxyReq localProxyReq = new ProxyReq();
    if (localIQQLiveSSOCommonHeader == null)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("[packSendBuffer] biz is null! appId:");
      paramArrayOfByte.append(paramString1);
      paramArrayOfByte.append(", method:");
      paramArrayOfByte.append(paramString3);
      QLog.e("QQLiveBusinessHandler", 1, paramArrayOfByte.toString());
    }
    else
    {
      localProxyReq.d = localIQQLiveSSOCommonHeader.f();
      localProxyReq.e = localIQQLiveSSOCommonHeader.g();
      localProxyReq.f = paramArrayOfByte;
      localProxyReq.g = localIQQLiveSSOCommonHeader.h();
      localProxyReq.h = localIQQLiveSSOCommonHeader.i();
      localProxyReq.p = localIQQLiveSSOCommonHeader.l().getBytes();
      if (localIQQLiveSSOCommonHeader.k().booleanValue()) {
        localProxyReq.n = 2;
      } else {
        localProxyReq.n = 0;
      }
      localProxyReq.k = localIQQLiveSSOCommonHeader.j();
      localProxyReq.q = 37;
      localProxyReq.a = localIQQLiveSSOCommonHeader.a();
      localProxyReq.b = localIQQLiveSSOCommonHeader.b();
      if (!TextUtils.isEmpty(localIQQLiveSSOCommonHeader.c())) {
        localProxyReq.c = localIQQLiveSSOCommonHeader.c();
      } else {
        localProxyReq.c = "";
      }
      localProxyReq.j = localIQQLiveSSOCommonHeader.d();
      localProxyReq.i = localIQQLiveSSOCommonHeader.e();
      if (localProxyReq.i == null) {
        localProxyReq.i = "";
      }
      localProxyReq.t = "0.0.1-snapshot";
      paramString1 = "8.8.17";
      if (TextUtils.isEmpty("8.8.17")) {
        paramString1 = "";
      }
      localProxyReq.u = paramString1;
      localProxyReq.v = paramString2;
      localProxyReq.w = paramString3;
      localProxyReq.x = 109;
      localProxyReq.y = 0;
      localProxyReq.m = "";
      localProxyReq.r = "";
      localProxyReq.o = new AuthInfo[0];
      localProxyReq.s = new TransInfo[0];
    }
    return MessageNano.toByteArray(localProxyReq);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.d.remove(paramString);
  }
  
  public void a(String paramString, IQQLiveSSOCommonHeader paramIQQLiveSSOCommonHeader)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramIQQLiveSSOCommonHeader == null) {
        return;
      }
      this.d.put(paramString, paramIQQLiveSSOCommonHeader);
    }
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, int paramInt1, int paramInt2, QQLiveBusinessObserver paramQQLiveBusinessObserver)
  {
    paramQQLiveBusinessObserver.setAppId(paramString1);
    paramQQLiveBusinessObserver = super.createToServiceMsg("trpc.qlive.qlive_proxy_svr.TrpcProxy.*", paramQQLiveBusinessObserver);
    paramQQLiveBusinessObserver.addAttribute("notify_type", Integer.valueOf(paramInt2));
    paramQQLiveBusinessObserver.addAttribute("app_id", paramString1);
    paramQQLiveBusinessObserver.addAttribute("start_time", Long.valueOf(System.currentTimeMillis()));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(paramString3);
    localObject = ((StringBuilder)localObject).toString();
    paramQQLiveBusinessObserver.addAttribute("cmd", localObject);
    paramQQLiveBusinessObserver.putWupBuffer(a(paramString1, paramArrayOfByte, paramString2, paramString3));
    paramQQLiveBusinessObserver.extraData.putBoolean("req_pb_protocol_flag", true);
    if (paramInt1 > 0)
    {
      long l = paramInt1;
      paramQQLiveBusinessObserver.setTimeout(l);
      paramQQLiveBusinessObserver.setSendTimeout(l);
    }
    if (!Cmd2HandlerMapHelper.a("trpc.qlive.qlive_proxy_svr.TrpcProxy.*")) {
      Cmd2HandlerMapHelper.a("trpc.qlive.qlive_proxy_svr.TrpcProxy.*", b);
    }
    paramString1 = QQLiveCaptureContext.a();
    if (paramString1 == null)
    {
      QLog.e("QQLiveBusinessHandler", 1, "[sendQQLiveReq] appInterface is null");
    }
    else
    {
      paramQQLiveBusinessObserver.extraData.putString("moduleId", QQLiveCaptureContext.b());
      paramString1.sendToService(paramQQLiveBusinessObserver);
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("[Live SSO] onSend cmd:[");
      paramString1.append((String)localObject);
      paramString1.append("]");
      QLog.i("QQLiveBusinessHandler", 2, paramString1.toString());
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
    String str2 = (String)paramToServiceMsg.getAttribute("app_id");
    String str3 = (String)paramToServiceMsg.getAttribute("cmd");
    long l = ((Long)paramToServiceMsg.getAttribute("start_time")).longValue();
    a(str2, System.currentTimeMillis() - l, str3);
    if (msgCmdFilter(str1))
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("[Live SSO] onReceive msgCmdFilter, cmd:");
      paramToServiceMsg.append(str1);
      paramToServiceMsg.append(", trulyCmd:[");
      paramToServiceMsg.append(str3);
      paramToServiceMsg.append("], appId:");
      paramToServiceMsg.append(str2);
      QLog.e("QQLiveBusinessHandler", 1, paramToServiceMsg.toString());
      return;
    }
    boolean bool = paramFromServiceMsg.isSuccess();
    Object localObject;
    if (bool)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[Live SSO] onReceive cmd[");
        ((StringBuilder)localObject).append(str3);
        ((StringBuilder)localObject).append("] success, appId:");
        ((StringBuilder)localObject).append(str2);
        QLog.i("QQLiveBusinessHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      int j = paramFromServiceMsg.getBusinessFailCode();
      localObject = paramFromServiceMsg.getBusinessFailMsg();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Live SSO] onReceive cmd[");
        localStringBuilder.append(str3);
        localStringBuilder.append("] fail, appId:");
        localStringBuilder.append(str2);
        localStringBuilder.append(", failCode:");
        localStringBuilder.append(j);
        localStringBuilder.append(", failMsg:");
        localStringBuilder.append((String)localObject);
        QLog.i("QQLiveBusinessHandler", 2, localStringBuilder.toString());
      }
    }
    if (paramObject == null)
    {
      paramObject = new StringBuilder();
      paramObject.append("[Live SSO] onReceive data is null, cmd:");
      paramObject.append(str1);
      paramObject.append(", trulyCmd:[");
      paramObject.append(str3);
      paramObject.append("], appId:");
      paramObject.append(str2);
      QLog.e("QQLiveBusinessHandler", 1, paramObject.toString());
      notifyUI(paramToServiceMsg, i, bool, new QQLiveRspData(paramFromServiceMsg, str2, str3));
      return;
    }
    notifyUI(paramToServiceMsg, i, bool, new QQLiveRspData(paramFromServiceMsg, (byte[])paramObject, str2, str3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.sso.QQLiveBusinessHandler
 * JD-Core Version:    0.7.0.1
 */