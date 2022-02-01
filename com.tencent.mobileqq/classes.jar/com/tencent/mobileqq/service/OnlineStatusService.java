package com.tencent.mobileqq.service;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.msf.service.protocol.push.SvcReqRegister;
import com.tencent.msf.service.protocol.push.SvcReqSetToken;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.msf.service.protocol.push.SvcRespSetToken;
import com.tencent.msf.service.protocol.push.VendorPushInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.Key;

public class OnlineStatusService
  extends BaseProtocolCoder
{
  private static final String[] a = { "StatSvc" };
  private AppInterface b;
  
  public OnlineStatusService(AppInterface paramAppInterface)
  {
    this.b = paramAppInterface;
  }
  
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
    long l;
    if (((IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class)).isShowGuildTab()) {
      l = 1L;
    } else {
      l = 0L;
    }
    localSvcReqSetToken.uGroupProSwitch = l;
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
      paramUniPacket.append(" uGroupProSwitch:");
      paramUniPacket.append(localSvcReqSetToken.uGroupProSwitch);
      QLog.d("OnlineStatusService", 2, paramUniPacket.toString());
    }
    return true;
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRespRegister)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    SvcReqRegister localSvcReqRegister = new SvcReqRegister();
    VendorPushInfo localVendorPushInfo = new VendorPushInfo();
    localSvcReqRegister.cConnType = 0;
    localSvcReqRegister.lBid = 7L;
    localSvcReqRegister.lUin = Long.parseLong(paramToServiceMsg.getUin());
    AppRuntime.Status localStatus = (AppRuntime.Status)paramToServiceMsg.extraData.getSerializable("onlineStatus");
    localSvcReqRegister.iStatus = localStatus.getValue();
    localSvcReqRegister.bKikPC = 0;
    localSvcReqRegister.bKikWeak = 0;
    localSvcReqRegister.timeStamp = this.b.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
    localSvcReqRegister.iLargeSeq = paramToServiceMsg.extraData.getLong("K_SEQ", 0L);
    localSvcReqRegister.bRegType = 0;
    byte b1;
    if (paramToServiceMsg.extraData.getBoolean("isAutoSet", false)) {
      b1 = 2;
    } else {
      b1 = 1;
    }
    localSvcReqRegister.bIsSetStatus = b1;
    localSvcReqRegister.uExtOnlineStatus = paramToServiceMsg.extraData.getLong("extOnlineStatus", -1L);
    int i = paramToServiceMsg.extraData.getInt("vendor_push_type", 1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnlineStatusService-handleReqSetOnlineStatus.vendor_push_type:");
      localStringBuilder.append(i);
      QLog.d("OnlineStatusService", 2, localStringBuilder.toString());
    }
    localVendorPushInfo.uVendorType = i;
    if ((localStatus == AppRuntime.Status.online) && (OnlineStatusItem.a(localSvcReqRegister.uExtOnlineStatus)))
    {
      i = paramToServiceMsg.extraData.getInt("batteryCapacity", 0);
      int j = paramToServiceMsg.extraData.getInt("powerConnect", -1);
      localSvcReqRegister.iBatteryStatus = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getSendBatteryStatus(i, j);
    }
    else
    {
      localSvcReqRegister.iBatteryStatus = 0;
    }
    try
    {
      localSvcReqRegister.iOSVersion = Integer.parseInt(Build.VERSION.SDK);
    }
    catch (Exception paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
    }
    if (NetConnInfoCenter.isMobileConn()) {
      localSvcReqRegister.cNetType = 0;
    } else if (NetConnInfoCenter.isWifiConn()) {
      localSvcReqRegister.cNetType = 1;
    }
    localSvcReqRegister.vecGuid = NetConnInfoCenter.GUID;
    localSvcReqRegister.strDevName = Build.MODEL;
    localSvcReqRegister.strDevType = Build.MODEL;
    localSvcReqRegister.strOSVer = Build.VERSION.RELEASE;
    localSvcReqRegister.stVendorPushInfo = localVendorPushInfo;
    paramUniPacket.put("SvcReqRegister", localSvcReqRegister);
    paramUniPacket.setServantName("PushService");
    paramUniPacket.setFuncName("SvcReqRegister");
    return true;
  }
  
  public String[] cmdHeaderPrefix()
  {
    return a;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("StatSvc.SetStatusFromClient".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("PushService.SetToken")) {
      return a(paramToServiceMsg, paramFromServiceMsg);
    }
    return super.decode(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("StatSvc.SetStatusFromClient")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("PushService.SetToken")) {
      return a(paramToServiceMsg, paramUniPacket);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.OnlineStatusService
 * JD-Core Version:    0.7.0.1
 */