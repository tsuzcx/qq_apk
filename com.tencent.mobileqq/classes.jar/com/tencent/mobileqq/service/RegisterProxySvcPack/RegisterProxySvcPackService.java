package com.tencent.mobileqq.service.RegisterProxySvcPack;

import IPwdPxyMQQ.RespondHeader;
import IPwdPxyMQQ.RespondQueryIPwdStat;
import MessageSvcPack.SvcResponseGetMsgV2;
import MessageSvcPack.SvcResponsePullDisMsgSeq;
import MessageSvcPack.SvcResponsePullGroupMsgSeq;
import RegisterProxySvcPack.RegisterPushNotice;
import RegisterProxySvcPack.SvcRequestRegisterAndroid;
import RegisterProxySvcPack.SvcRequestRegisterNew;
import RegisterProxySvcPack.SvcRespParam;
import RegisterProxySvcPack.SvcResponsePullDisGroupSeq;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.msf.service.protocol.push.SvcReqRegister;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Constants.Key;
import mqq.app.MobileQQ;

public class RegisterProxySvcPackService
  extends BaseProtocolCoder
{
  private static final String[] a = { "RegPrxySvc" };
  private QQAppInterface b = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
  
  private SvcReqRegister a()
  {
    SvcReqRegister localSvcReqRegister = new SvcReqRegister();
    localSvcReqRegister.lUin = Long.parseLong(this.b.getCurrentAccountUin());
    localSvcReqRegister.lBid = 7L;
    localSvcReqRegister.cConnType = 0;
    Object localObject = ((IOnlineStatusService)this.b.getRuntimeService(IOnlineStatusService.class)).getOnlineStatus();
    int i = RegisterProxySvcPackService.1.a[localObject.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            localSvcReqRegister.iStatus = 41;
          }
        }
        else {
          localSvcReqRegister.iStatus = 31;
        }
      }
      else {
        localSvcReqRegister.iStatus = 21;
      }
    }
    else {
      localSvcReqRegister.iStatus = 11;
    }
    localSvcReqRegister.bKikPC = ((byte)this.b.getCurLoginStatus());
    localSvcReqRegister.bKikWeak = 0;
    localSvcReqRegister.timeStamp = this.b.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
    localSvcReqRegister.iLargeSeq = this.b.getApp().getSharedPreferences(this.b.getAccount(), 0).getInt("GetFrdListReq_seq", 0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" makeSvcReqRegisterPkg ");
      ((StringBuilder)localObject).append(localSvcReqRegister.iStatus);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(localSvcReqRegister.bKikPC);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(localSvcReqRegister.timeStamp);
      QLog.d("Q.contacts.", 2, ((StringBuilder)localObject).toString());
    }
    return localSvcReqRegister;
  }
  
  private Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRespParam)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRespParam", new SvcRespParam());
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("RegPrxySvc");
    paramToServiceMsg = new SvcRequestRegisterNew();
    paramToServiceMsg.ulRequestOptional |= 0x20;
    paramUniPacket.put("req_OffMsg", paramToServiceMsg);
    return true;
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterProxySvcPackService", 2, "decodeSvcResponseIpwdStat() ");
    }
    paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
    paramToServiceMsg = (RespondHeader)decodePacket(paramFromServiceMsg, "RespondHeader", new RespondHeader());
    paramFromServiceMsg = (RespondQueryIPwdStat)decodePacket(paramFromServiceMsg, "RespondQueryIPwdStat", new RespondQueryIPwdStat());
    if (paramToServiceMsg == null) {
      return null;
    }
    if (paramToServiceMsg.result != 0) {
      return null;
    }
    return paramFromServiceMsg;
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = new SvcRequestRegisterAndroid();
    paramToServiceMsg.ulRequestOptional = 1L;
    paramUniPacket.setServantName("RegisterProxySvcPack");
    paramUniPacket.setFuncName("OffLineMsg");
    paramUniPacket.put("req_OffMsg", paramToServiceMsg);
    return true;
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg.extraData.getLong("requestOptional", 0L) & 0x10) == 16L) {
      paramToServiceMsg = (SvcRespRegister)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
    } else {
      paramToServiceMsg = null;
    }
    if (paramToServiceMsg != null)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("decodeRegisterProxyInfoNew resp.strResult =");
        paramFromServiceMsg.append(paramToServiceMsg.strResult);
        QLog.i("RegisterProxySvcPackService", 2, paramFromServiceMsg.toString());
        return paramToServiceMsg;
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyTroopMsg null");
    }
    return paramToServiceMsg;
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("RegPrxySvc");
    paramToServiceMsg = d(paramToServiceMsg, paramUniPacket);
    paramUniPacket.put("req_OffMsg", paramToServiceMsg);
    return paramToServiceMsg.ulRequestOptional != 0L;
  }
  
  private SvcRequestRegisterNew d(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l = paramToServiceMsg.extraData.getLong("requestOptional");
    int i = paramToServiceMsg.extraData.getInt("type");
    int j = paramToServiceMsg.extraData.getInt("endSeq");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isGetPassword");
    SvcRequestRegisterNew localSvcRequestRegisterNew = new SvcRequestRegisterNew();
    localSvcRequestRegisterNew.cDisgroupMsgFilter = 1;
    localSvcRequestRegisterNew.ulRequestOptional = l;
    localSvcRequestRegisterNew.cSubCmd = 0;
    localSvcRequestRegisterNew.ulLastFilterListTime = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getUpdateTime();
    if (i == 3)
    {
      localSvcRequestRegisterNew.cOptGroupMsgFlag = 1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Type = ");
      localStringBuilder.append(i);
      localStringBuilder.append(", req.cOptGroupMsgFlag = ");
      localStringBuilder.append(localSvcRequestRegisterNew.cOptGroupMsgFlag);
      QLog.d("SvcRequestRegisterNew", 1, localStringBuilder.toString());
    }
    if ((l & 0x10) == 16L) {
      localSvcRequestRegisterNew.regist = a();
    }
    if ((l & 0x40) == 64L)
    {
      localSvcRequestRegisterNew.c2cmsg = this.b.getMsgHandler().w();
      paramUniPacket.put("req_PbOffMsg", this.b.getMsgHandler().x());
    }
    if (((l & 0x4) == 4L) || ((l & 0x80) == 128L))
    {
      localSvcRequestRegisterNew.groupmsg = this.b.getMsgHandler().i(i);
      if (localSvcRequestRegisterNew.groupmsg == null)
      {
        localSvcRequestRegisterNew.ulRequestOptional &= 0xFFFFFFFB;
        localSvcRequestRegisterNew.ulRequestOptional &= 0xFFFFFF7F;
      }
    }
    if (((l & 0x8) == 8L) || ((l & 0x100) == 256L)) {
      if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.infoLogin"))
      {
        localSvcRequestRegisterNew.disgroupmsg = this.b.getMsgHandler().y();
      }
      else
      {
        localSvcRequestRegisterNew.confmsg = this.b.getMsgHandler().j(i);
        if (localSvcRequestRegisterNew.confmsg == null)
        {
          localSvcRequestRegisterNew.ulRequestOptional &= 0xFFFFFFF7;
          localSvcRequestRegisterNew.ulRequestOptional &= 0xFFFFFEFF;
        }
      }
    }
    if (i == 1) {
      localSvcRequestRegisterNew.cGroupMask = 2;
    }
    localSvcRequestRegisterNew.uEndSeq = j;
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("requestMsgRegister , type = ");
    paramToServiceMsg.append(i);
    paramToServiceMsg.append(" isGetPassword = ");
    paramToServiceMsg.append(bool);
    QLog.d("RegisterProxySvcPackService", 1, paramToServiceMsg.toString());
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("cDisgroupMsgFilter:");
    paramToServiceMsg.append(localSvcRequestRegisterNew.cDisgroupMsgFilter);
    paramToServiceMsg.append(",NoticeEndSeq:");
    paramToServiceMsg.append(j);
    paramToServiceMsg.append(" , ulRequestOptional : ");
    paramToServiceMsg.append(localSvcRequestRegisterNew.ulRequestOptional);
    QLog.d("SvcRequestRegisterNew", 1, paramToServiceMsg.toString());
    return localSvcRequestRegisterNew;
  }
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponsePullGroupMsgSeq)decodePacket(paramFromServiceMsg.getWupBuffer(), "resp_PullGroupMsgSeq", new SvcResponsePullGroupMsgSeq());
    if (paramToServiceMsg != null)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("decodeRegisterProxyTroopSeq cReplyCode = ");
        paramFromServiceMsg.append(paramToServiceMsg.cReplyCode);
        QLog.i("RegisterProxySvcPackService", 2, paramFromServiceMsg.toString());
        return paramToServiceMsg;
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyTroopSeq null");
    }
    return paramToServiceMsg;
  }
  
  private Object e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (RegisterPushNotice)decodePacket(paramFromServiceMsg.getWupBuffer(), "RegisterPushNotice", new RegisterPushNotice());
    if (paramToServiceMsg != null)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("decodeRegisterProxyTroopSeq cReplyCode = ");
        paramFromServiceMsg.append(paramToServiceMsg.ulTimeOutFlag);
        QLog.i("RegisterProxySvcPackService", 2, paramFromServiceMsg.toString());
        return paramToServiceMsg;
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyTroopSeq null");
    }
    return paramToServiceMsg;
  }
  
  private boolean e(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("RegPrxySvc");
    SvcRequestRegisterNew localSvcRequestRegisterNew = f(paramToServiceMsg, paramUniPacket);
    paramUniPacket.put("req_OffMsg", localSvcRequestRegisterNew);
    paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    return localSvcRequestRegisterNew.ulRequestOptional != 0L;
  }
  
  private SvcRequestRegisterNew f(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = paramToServiceMsg.extraData.getLong("requestOptional");
    int i = paramToServiceMsg.extraData.getInt("type");
    int j = paramToServiceMsg.extraData.getInt("endSeq");
    long l2 = paramToServiceMsg.extraData.getLong("ulReportFlag");
    paramToServiceMsg = new SvcRequestRegisterNew();
    paramToServiceMsg.ulRequestOptional = l1;
    paramToServiceMsg.cDisgroupMsgFilter = 1;
    paramToServiceMsg.uEndSeq = j;
    paramToServiceMsg.ulLastFilterListTime = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getUpdateTime();
    paramToServiceMsg.ulReportFlag = l2;
    l2 = this.b.getMsgCache().r();
    if (l2 > 0L) {
      paramToServiceMsg.ulSyncTime = l2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestNewRegister , type = ");
    localStringBuilder.append(i);
    localStringBuilder.append(" ,ulRequestOptional = ");
    localStringBuilder.append(paramToServiceMsg.ulRequestOptional);
    localStringBuilder.append(" ,cDisgroupMsgFilter = ");
    localStringBuilder.append(paramToServiceMsg.cDisgroupMsgFilter);
    localStringBuilder.append(" ,NoticeEndSeq = ");
    localStringBuilder.append(paramToServiceMsg.uEndSeq);
    localStringBuilder.append(" ,ulSyncTime = ");
    localStringBuilder.append(paramToServiceMsg.ulSyncTime);
    QLog.d("RegisterProxySvcPackService", 1, localStringBuilder.toString());
    if (i == 1) {
      paramToServiceMsg.cGroupMask = 2;
    }
    if (i == 3)
    {
      paramToServiceMsg.cOptGroupMsgFlag = 1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Type = ");
      localStringBuilder.append(i);
      localStringBuilder.append(", req.cOptGroupMsgFlag = ");
      localStringBuilder.append(paramToServiceMsg.cOptGroupMsgFlag);
      QLog.d("SvcRequestRegisterNew", 1, localStringBuilder.toString());
    }
    if ((l1 & 0x10) == 16L) {
      paramToServiceMsg.regist = a();
    }
    if ((l1 & 0x40) == 64L)
    {
      paramToServiceMsg.c2cmsg = this.b.getMsgHandler().w();
      paramUniPacket.put("req_PbOffMsg", this.b.getMsgHandler().e(false));
      paramUniPacket.put("req_PbPubMsg", this.b.getMsgHandler().e(true));
    }
    paramToServiceMsg.bytes_0x769_reqbody = MsfPullConfigUtil.pullConfigRequest(true);
    paramToServiceMsg.uGuildUdcFlag = 1;
    return paramToServiceMsg;
  }
  
  private Object f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponsePullDisMsgSeq)decodePacket(paramFromServiceMsg.getWupBuffer(), "resp_PullDisMsgSeq", new SvcResponsePullDisMsgSeq());
    if (paramToServiceMsg != null)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("decodeRegisterProxyDisMsg cReplyCode = ");
        paramFromServiceMsg.append(paramToServiceMsg.cReplyCode);
        QLog.i("RegisterProxySvcPackService", 2, paramFromServiceMsg.toString());
        return paramToServiceMsg;
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyDisMsg null");
    }
    return paramToServiceMsg;
  }
  
  private Object g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponsePullDisGroupSeq)decodePacket(paramFromServiceMsg.getWupBuffer(), "resp_PullDisGroupSeq", new SvcResponsePullDisGroupSeq());
    if (paramToServiceMsg != null)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("decodeRegisterProxyDisGroupSeq cReplyCode = ");
        paramFromServiceMsg.append(paramToServiceMsg.cReplyCode);
        QLog.i("RegisterProxySvcPackService", 2, paramFromServiceMsg.toString());
        return paramToServiceMsg;
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.i("RegisterProxySvcPackService", 2, "decodeRegisterProxyDisGroupSeq null");
    }
    return paramToServiceMsg;
  }
  
  private Object h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcResponseGetMsgV2)decodePacket(paramFromServiceMsg.getWupBuffer(), "resp_GetMsgV2", new SvcResponseGetMsgV2());
  }
  
  public String[] cmdHeaderPrefix()
  {
    return a;
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ("RegPrxySvc.infoAndroid".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return null;
    }
    if ("RegPrxySvc.PushParam".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return a(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("RegPrxySvc.PbGetMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return null;
    }
    if ("RegPrxySvc.GetMsgV2".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return h(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("RegPrxySvc.PullGroupMsgSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return d(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("RegPrxySvc.PullDisMsgSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return f(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("RegPrxySvc.PullDisGroupSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return g(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("RegPrxySvc.infoLogin".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return c(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("RegPrxySvc.NoticeEnd".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return e(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("RegPrxySvc.QueryIpwdStat".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
  
  public boolean encodeReqMsg(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.infoAndroid")) {
      return b(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.infoLogin")) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.getOffMsg")) {
      return c(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.getExtinfo")) {
      return a(paramToServiceMsg, paramUniPacket);
    }
    if (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.infoSync")) {
      return e(paramToServiceMsg, paramUniPacket);
    }
    return paramToServiceMsg.getServiceCmd().equalsIgnoreCase("RegPrxySvc.PbSyncMsg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.RegisterProxySvcPack.RegisterProxySvcPackService
 * JD-Core Version:    0.7.0.1
 */