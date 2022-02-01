package com.tencent.mobileqq.msf.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.ai;
import com.tencent.mobileqq.msf.core.auth.l;
import com.tencent.mobileqq.msf.core.c.d;
import com.tencent.mobileqq.msf.core.c.e.a;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.net.k;
import com.tencent.mobileqq.msf.core.net.k.b;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.msf.core.push.RegPushReason;
import com.tencent.mobileqq.msf.core.push.a;
import com.tencent.mobileqq.msf.core.push.g;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.msf.sdk.aa;
import com.tencent.mobileqq.msf.sdk.z;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.msf.service.protocol.pb.WirelessMibao.CWirelessMibaoReq;
import com.tencent.msf.service.protocol.pb.WirelessPsw.CWirelessPswReq;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.MsfServiceBindInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class r
{
  private static String a = "MSF.S.ReqHandler";
  
  public static void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)paramLong);
  }
  
  void a(Context paramContext, ToServiceMsg paramToServiceMsg, int paramInt)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    Object localObject1 = u.b(paramToServiceMsg);
    Object localObject2;
    Object localObject3;
    if ((!"LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) && (!"ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())))
    {
      if ((QLog.isColorLevel()) && (!paramToServiceMsg.getMsfCommand().equals(MsfCommand.reportSocket)))
      {
        localObject2 = a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("recv ");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(" req:");
        ((StringBuilder)localObject3).append(paramToServiceMsg);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
    }
    else
    {
      localObject2 = a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("handleMsfRequest.");
      ((StringBuilder)localObject3).append(paramToServiceMsg.getStringForLog());
      QLog.d((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    }
    paramToServiceMsg.addAttribute("__timestamp_app2msf", Long.valueOf(System.currentTimeMillis()));
    if (((paramToServiceMsg.getServiceCmd().equals("RegPrxySvc.infoLogin")) || (paramToServiceMsg.getServiceCmd().equals("RegPrxySvc.infoSync"))) && (!g.v))
    {
      QLog.d(a, 1, "get infoLogin, but not register push, register now");
      localObject3 = paramContext.getPackageName();
      if (localObject3 != null)
      {
        localObject2 = new ToServiceMsg("", paramToServiceMsg.getUin(), "push.register");
        ((ToServiceMsg)localObject2).setMsfCommand(MsfCommand.registerPush);
        ((ToServiceMsg)localObject2).setAppId(paramToServiceMsg.getAppId());
        ((ToServiceMsg)localObject2).setTimeout(30000L);
        MsfSdkUtils.addToMsgProcessName((String)localObject3, (ToServiceMsg)localObject2);
        localObject3 = (a)MsfService.core.pushManager.i.get(localObject3);
        if (localObject3 != null)
        {
          aa.a((ToServiceMsg)localObject2, ((a)localObject3).k);
          MsfService.core.pushManager.a((ToServiceMsg)localObject2, RegPushReason.fillRegProxy);
        }
        else
        {
          QLog.d(a, 1, "AppPushInfo not find can not register");
          localObject3 = new PushRegisterInfo();
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(Long.valueOf(1L));
          localArrayList.add(Long.valueOf(2L));
          localArrayList.add(Long.valueOf(4L));
          ((PushRegisterInfo)localObject3).pushIds = localArrayList;
          ((PushRegisterInfo)localObject3).uin = paramToServiceMsg.getUin();
          ((PushRegisterInfo)localObject3).iStatus = 11;
          ((PushRegisterInfo)localObject3).bKikPC = 0;
          ((PushRegisterInfo)localObject3).bKikWeak = 0;
          ((PushRegisterInfo)localObject3).timeStamp = 0L;
          ((PushRegisterInfo)localObject3).iLargeSeq = 0L;
          aa.a((ToServiceMsg)localObject2, (PushRegisterInfo)localObject3);
          MsfService.core.pushManager.a((ToServiceMsg)localObject2, RegPushReason.createDefaultRegInfo);
        }
      }
      else
      {
        QLog.d(a, 1, "qqprocessName not find can not register");
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = a;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(" msfCommand: ");
      ((StringBuilder)localObject3).append(paramToServiceMsg.getMsfCommand());
      QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    }
    long l;
    int i;
    int j;
    int k;
    int m;
    switch (s.a[paramToServiceMsg.getMsfCommand().ordinal()])
    {
    default: 
      MsfService.core.sendSsoMsg(paramToServiceMsg);
      return;
    case 84: 
      com.tencent.mobileqq.msf.core.i.a().a(paramToServiceMsg);
      return;
    case 83: 
      MsfService.core.updateBatteryStatus(paramToServiceMsg);
      return;
    case 82: 
      paramInt = ((Integer)paramToServiceMsg.getAttribute("localeId")).intValue();
      if (MsfCore.sCore == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramContext = a;
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("msf_update_localeId, localeId = ");
        paramToServiceMsg.append(paramInt);
        QLog.d(paramContext, 2, paramToServiceMsg.toString());
      }
      MsfCore.sCore.mLocaleId = paramInt;
      return;
    case 81: 
      com.tencent.qphone.base.util.log.a.b.a(((Integer)paramToServiceMsg.getAttribute("opType")).intValue(), ((Integer)paramToServiceMsg.getAttribute("manualLogLevel")).intValue());
      return;
    case 80: 
      try
      {
        o.a((String)paramToServiceMsg.getAttribute("geoginfo_lontitude"), (String)paramToServiceMsg.getAttribute("geoginfo_latitude"), NetConnInfoCenter.getServerTime());
        return;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d(a, 2, "failed to save geog info ", paramContext);
      return;
    case 79: 
      try
      {
        l = ((Long)paramToServiceMsg.getAttribute("infoSync_timestamp")).longValue();
        ai.a(paramToServiceMsg.getUin(), l);
        paramContext = a;
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("recv infoSync timestamp:");
        paramToServiceMsg.append(l);
        QLog.d(paramContext, 1, paramToServiceMsg.toString());
        return;
      }
      catch (Exception paramContext)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.d(a, 2, "failed to recv infologin end ", paramContext);
      return;
    case 78: 
      com.tencent.mobileqq.msf.core.stepcount.i.b((String)localObject1, paramToServiceMsg);
      return;
    case 77: 
      MsfService.core.refreshDA2(paramToServiceMsg);
      return;
    case 76: 
      MsfService.core.sendMsgSignal();
      return;
    case 75: 
      paramContext = u.a(paramToServiceMsg);
      paramContext.addAttribute("msf_con_erro", n.p);
      paramContext.setMsgSuccess();
      e.a((String)localObject1, paramToServiceMsg, paramContext);
      return;
    case 74: 
      paramContext = paramToServiceMsg.getUin();
      localObject1 = (String)paramToServiceMsg.getAttributes().get("src");
      boolean bool = ((Boolean)paramToServiceMsg.getAttributes().get("opened")).booleanValue();
      MsfService.core.openUinPCActive(paramContext, (String)localObject1, bool);
      return;
    case 73: 
      paramToServiceMsg.getUin();
      paramContext = (String)paramToServiceMsg.getAttributes().get("src");
      MsfService.core.stopPCActivePolling(paramContext);
      return;
    case 72: 
      paramContext = paramToServiceMsg.getUin();
      paramToServiceMsg = (String)paramToServiceMsg.getAttributes().get("src");
      MsfService.core.startPCActivePolling(paramContext, paramToServiceMsg);
      return;
    case 71: 
      MsfService.core.sendSsoMsg(paramToServiceMsg);
      paramContext = String.valueOf(paramToServiceMsg.getAttribute("stype", Integer.valueOf(0)));
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("MsgType", paramToServiceMsg.toString());
      ((HashMap)localObject1).put("SharpType", paramContext);
      MsfService.core.getStatReporter().a("dim.Msf.RecvVideoS2CACK", false, 0L, 0L, (Map)localObject1, true, false);
      com.tencent.mobileqq.msf.core.c.e.a().a(e.a.i, paramToServiceMsg.getWupBuffer(), 0);
      return;
    case 70: 
      MsfService.core.wt_QuickLoginByGateway(paramToServiceMsg);
      return;
    case 69: 
      MsfService.core.wt_GetStViaSMSVerifyLogin(paramToServiceMsg);
      return;
    case 68: 
      MsfService.core.wt_VerifySMSVerifyLoginCode(paramToServiceMsg);
      return;
    case 67: 
      MsfService.core.wt_RefreshSMSVerifyLoginCode(paramToServiceMsg);
      return;
    case 66: 
      MsfService.core.wt_CheckSMSVerifyLoginAccount(paramToServiceMsg);
      return;
    case 65: 
      MsfService.core.wt_RegGetSMSVerifyLoginAccount(paramToServiceMsg);
      return;
    case 64: 
      MsfService.core.wt_CheckSMSAndGetStExt(paramToServiceMsg);
      return;
    case 63: 
      MsfService.core.wt_CheckSMSAndGetSt(paramToServiceMsg);
      return;
    case 62: 
      MsfService.core.wt_RefreshSMSData(paramToServiceMsg);
      return;
    case 61: 
      MsfService.core.wt_SetDevlockMobileType(paramToServiceMsg);
      return;
    case 60: 
      MsfService.core.wt_setRegDevLockFlag(paramToServiceMsg);
      return;
    case 59: 
      MsfService.core.wt_CloseDevLock(paramToServiceMsg);
      return;
    case 58: 
      MsfService.core.wt_CheckDevLockSms(paramToServiceMsg);
      return;
    case 57: 
      MsfService.core.wt_AskDevLockSms(paramToServiceMsg);
      return;
    case 56: 
      MsfService.core.wt_CheckDevLockStatus(paramToServiceMsg);
      return;
    case 55: 
      MsfService.core.wt_GetA1WithA1(paramToServiceMsg);
      return;
    case 54: 
      MsfService.core.wt_CancelCode(paramToServiceMsg);
      return;
    case 53: 
      MsfService.core.wt_CloseCode(paramToServiceMsg);
      return;
    case 52: 
      MsfService.core.wt_VerifyCode(paramToServiceMsg);
      return;
    case 51: 
      MsfService.core.wt_RefreshPictureData(paramToServiceMsg);
      return;
    case 50: 
      MsfService.core.wt_CheckPictureAndGetSt(paramToServiceMsg);
      return;
    case 49: 
      MsfService.core.wt_GetStWithoutPasswd(paramToServiceMsg);
      return;
    case 48: 
      MsfService.core.wt_GetStWithPasswd(paramToServiceMsg);
      return;
    case 47: 
      MsfService.core.wt_GetOpenKeyWithoutPasswd(paramToServiceMsg);
      return;
    case 46: 
      paramInt = ((Integer)paramToServiceMsg.getAttribute("cmd")).intValue();
      paramContext = new WirelessMibao.CWirelessMibaoReq();
      paramContext.cmd.set(paramInt);
      paramContext.time.set((int)(System.currentTimeMillis() / 1000L));
      paramContext.uin.set(Long.parseLong(paramToServiceMsg.getUin()));
      try
      {
        localObject1 = InetAddress.getByName(ac.q());
        localObject2 = ((InetAddress)localObject1).getAddress();
        if ((localObject2.length <= 4) && (localObject2.length > 0))
        {
          i = localObject2[0];
          j = localObject2[1];
          k = localObject2[2];
          m = localObject2[3];
          paramContext.ip.set((k & 0xFF) << 8 | (j & 0xFF) << 16 | (i & 0xFF) << 24 | 0x0 | m & 0xFF);
          localObject1 = MsfService.getCore().getAccountCenter().f();
          paramContext.ksid.set(ByteStringMicro.copyFrom((byte[])localObject1));
          paramContext.imei.set(o.d());
          paramContext.guid.set(ByteStringMicro.copyFrom(l.a()));
          localObject2 = paramContext.toByteArray();
          l = localObject2.length;
          i = (int)l;
          localObject3 = new byte[i + 4];
          a((byte[])localObject3, 0, l + 4L);
          System.arraycopy(localObject2, 0, localObject3, 4, i);
          paramToServiceMsg.putWupBuffer((byte[])localObject3);
          if (QLog.isDevelopLevel())
          {
            localObject2 = a;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("WIRELESS_MEIBAOREQ cmd:");
            ((StringBuilder)localObject3).append(paramInt);
            ((StringBuilder)localObject3).append(" time:");
            ((StringBuilder)localObject3).append(paramContext.time.get());
            ((StringBuilder)localObject3).append(" uin:");
            ((StringBuilder)localObject3).append(paramContext.uin.get());
            ((StringBuilder)localObject3).append(" ip:");
            ((StringBuilder)localObject3).append(paramContext.ip.get());
            ((StringBuilder)localObject3).append(" ksid:");
            ((StringBuilder)localObject3).append(localObject1);
            QLog.d((String)localObject2, 4, ((StringBuilder)localObject3).toString());
          }
          MsfService.core.sendSsoMsg(paramToServiceMsg);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramContext = a;
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("SEND_WIRELESS_PSWREQ inetAddress error :");
          paramToServiceMsg.append(localObject1);
          QLog.d(paramContext, 2, paramToServiceMsg.toString());
        }
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    case 45: 
      paramInt = ((Integer)paramToServiceMsg.getAttribute("cmd")).intValue();
      paramContext = new WirelessPsw.CWirelessPswReq();
      paramContext.cmd.set(paramInt);
      paramContext.time.set((int)(System.currentTimeMillis() / 1000L));
      paramContext.uin.set(Long.parseLong(paramToServiceMsg.getUin()));
      try
      {
        localObject1 = InetAddress.getByName(ac.q());
        localObject2 = ((InetAddress)localObject1).getAddress();
        if ((localObject2.length <= 4) && (localObject2.length > 0))
        {
          i = localObject2[0];
          j = localObject2[1];
          k = localObject2[2];
          m = localObject2[3];
          paramContext.ip.set((k & 0xFF) << 8 | (j & 0xFF) << 16 | (i & 0xFF) << 24 | 0x0 | m & 0xFF);
          localObject1 = MsfService.getCore().getAccountCenter().f();
          paramContext.ksid.set(ByteStringMicro.copyFrom((byte[])localObject1));
          localObject2 = paramContext.toByteArray();
          l = localObject2.length;
          i = (int)l;
          localObject3 = new byte[i + 4];
          a((byte[])localObject3, 0, l + 4L);
          System.arraycopy(localObject2, 0, localObject3, 4, i);
          paramToServiceMsg.putWupBuffer((byte[])localObject3);
          if (QLog.isDevelopLevel())
          {
            localObject2 = a;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("WIRELESS_PSWREQ cmd:");
            ((StringBuilder)localObject3).append(paramInt);
            ((StringBuilder)localObject3).append(" time:");
            ((StringBuilder)localObject3).append(paramContext.time.get());
            ((StringBuilder)localObject3).append(" uin:");
            ((StringBuilder)localObject3).append(paramContext.uin.get());
            ((StringBuilder)localObject3).append(" ip:");
            ((StringBuilder)localObject3).append(paramContext.ip.get());
            ((StringBuilder)localObject3).append(" ksid:");
            ((StringBuilder)localObject3).append(localObject1);
            QLog.d((String)localObject2, 4, ((StringBuilder)localObject3).toString());
          }
          MsfService.core.sendSsoMsg(paramToServiceMsg);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramContext = a;
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("SEND_WIRELESS_PSWREQ inetAddress error :");
          paramToServiceMsg.append(localObject1);
          QLog.d(paramContext, 2, paramToServiceMsg.toString());
        }
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    case 44: 
      paramInt = ((Integer)paramToServiceMsg.getAttribute("NetExceptionType")).intValue();
      if (QLog.isDevelopLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("get a NetExceptionStatistics event value:");
        paramContext.append(paramInt);
        QLog.d("MSF.C.NetExceptionStat", 4, paramContext.toString());
      }
      if (paramInt != 1) {
        return;
      }
      k.a(k.b.a);
      return;
    case 43: 
      e.c((String)localObject1, paramToServiceMsg, u.a(paramToServiceMsg));
      return;
    case 42: 
      e.b((String)localObject1, paramToServiceMsg, u.a(paramToServiceMsg));
      return;
    case 41: 
      paramContext = ac.q();
      localObject2 = u.a(paramToServiceMsg);
      ((FromServiceMsg)localObject2).addAttribute(paramToServiceMsg.getServiceCmd(), paramContext);
      ((FromServiceMsg)localObject2).setMsgSuccess();
      e.a((String)localObject1, paramToServiceMsg, (FromServiceMsg)localObject2);
      return;
    case 40: 
      MsfService.core.getNetFlowStore().a(paramToServiceMsg);
      return;
    case 39: 
      paramContext = new JceInputStream((byte[])paramToServiceMsg.getAttribute(paramToServiceMsg.getServiceCmd()));
      paramToServiceMsg = new RdmReq();
      paramToServiceMsg.readFrom(paramContext);
      if (MsfService.core.getStatReporter() == null) {
        return;
      }
      MsfService.core.getStatReporter().a(paramToServiceMsg.appKey, paramToServiceMsg.eventName, paramToServiceMsg.isSucceed, paramToServiceMsg.elapse, paramToServiceMsg.size, paramToServiceMsg.params, paramToServiceMsg.isRealTime, paramToServiceMsg.isImmediatelyUpload, paramToServiceMsg.isMerge);
      return;
    case 38: 
      paramContext = u.a(paramToServiceMsg);
      paramContext.addAttribute(paramToServiceMsg.getServiceCmd(), "dropped");
      paramContext.setMsgSuccess();
      e.a((String)localObject1, paramToServiceMsg, paramContext);
      return;
    case 37: 
      QLog.e(a, 1, "appDataIncerment not handled");
      return;
    case 36: 
      QLog.e(a, 1, "appDataIncerment not handled");
      return;
    case 35: 
      MsfService.core.resume();
      return;
    case 34: 
      MsfService.core.suspend();
      return;
    case 33: 
      MsfService.core.getWtLoginCenter().n(paramToServiceMsg);
      return;
    case 32: 
      MsfService.core.getWtLoginCenter().m(paramToServiceMsg);
      return;
    case 31: 
      MsfService.core.getWtLoginCenter().l(paramToServiceMsg);
      return;
    case 30: 
      MsfService.core.getWtLoginCenter().j(paramToServiceMsg);
      return;
    case 29: 
      MsfService.core.getWtLoginCenter().i(paramToServiceMsg);
      return;
    case 28: 
      MsfService.core.getWtLoginCenter().k(paramToServiceMsg);
      return;
    case 27: 
      MsfService.core.getWtLoginCenter().h(paramToServiceMsg);
      return;
    case 26: 
      MsfService.core.getWtLoginCenter().g(paramToServiceMsg);
      return;
    case 25: 
      MsfService.core.getPluginConfig(paramToServiceMsg);
      return;
    case 24: 
      paramContext = MsfService.core.syncGetServerConfig(paramToServiceMsg);
      localObject2 = u.a(paramToServiceMsg);
      ((FromServiceMsg)localObject2).addAttribute("to_getServerConfig_type", Integer.valueOf(((Integer)paramToServiceMsg.getAttributes().get("to_getServerConfig_type")).intValue()));
      ((FromServiceMsg)localObject2).addAttribute("to_getServerConfig_content", paramContext);
      ((FromServiceMsg)localObject2).setMsgSuccess();
      e.a((String)localObject1, paramToServiceMsg, (FromServiceMsg)localObject2);
      return;
    case 23: 
      paramContext = paramToServiceMsg.getUin();
      paramContext = MsfService.core.getWtLoginCenter().c(paramContext);
      localObject2 = u.a(paramToServiceMsg);
      ((FromServiceMsg)localObject2).getAttributes().put("keyMap", paramContext);
      ((FromServiceMsg)localObject2).setMsgSuccess();
      e.a((String)localObject1, paramToServiceMsg, (FromServiceMsg)localObject2);
      return;
    case 22: 
      paramContext = MsfService.core.handleGetAccountKey(paramContext, paramToServiceMsg, paramInt);
      localObject2 = u.a(paramToServiceMsg);
      ((FromServiceMsg)localObject2).addAttribute(((FromServiceMsg)localObject2).getServiceCmd(), paramContext);
      ((FromServiceMsg)localObject2).setMsgSuccess();
      e.a((String)localObject1, paramToServiceMsg, (FromServiceMsg)localObject2);
      return;
    case 21: 
      MsfService.core.report(paramToServiceMsg);
      return;
    case 20: 
      paramContext = (String)paramToServiceMsg.getAttribute(paramToServiceMsg.getServiceCmd());
      if (e.b(paramContext))
      {
        MsfService.core.proxyUnRegister(paramContext, paramToServiceMsg);
        return;
      }
      paramContext = u.a(paramToServiceMsg);
      paramContext.setBusinessFail(1011, "can not unregister by proxy.");
      e.a((String)localObject1, paramToServiceMsg, paramContext);
      return;
    case 19: 
      QLog.d(a, 1, "handleMsfRequest proxyRegisterPush");
      paramContext = aa.d(paramToServiceMsg);
      e.a(paramContext.b, paramContext.c, null, paramToServiceMsg.getAppId());
      MsfService.core.proxyRegister(paramContext, paramToServiceMsg);
      return;
    case 18: 
      MsfService.core.unRegisterCmdCall(paramToServiceMsg);
      return;
    case 17: 
      MsfService.core.registerCmdCall(paramToServiceMsg);
      return;
    case 16: 
      MsfService.core.unRegisterPush(paramToServiceMsg);
      return;
    case 15: 
      paramContext = (RegPushReason)paramToServiceMsg.getAttribute("regPushReason");
      MsfService.core.registerPush(paramToServiceMsg, paramContext);
      return;
    case 14: 
      paramContext = paramToServiceMsg.getUin();
      if (TextUtils.isEmpty(paramContext)) {
        return;
      }
      MsfService.core.refreshWebviewTickets(paramContext, "NotifyReLogin");
      return;
    case 13: 
      MsfService.core.submitPuzzleVerifyCodeTicket(paramToServiceMsg);
      return;
    case 12: 
      MsfService.core.refreVerifycode(paramToServiceMsg);
      return;
    case 11: 
      MsfService.core.submitVerifycode(paramToServiceMsg);
      return;
    case 10: 
      MsfService.core.syncDelAccount(paramToServiceMsg);
      paramContext = u.a(paramToServiceMsg);
      paramContext.addAttribute("resp_simpleAccount_uin", paramToServiceMsg.getUin());
      paramContext.setMsgSuccess();
      e.a((String)localObject1, paramToServiceMsg, paramContext);
      return;
    case 9: 
      MsfService.core.changeTokenAfterLogin(paramToServiceMsg, true);
      return;
    case 8: 
      MsfService.core.ChangeUinLogin(paramToServiceMsg);
      return;
    case 7: 
      MsfService.core.login(paramToServiceMsg, 16, 0, new byte[0]);
      return;
    case 6: 
      MsfService.core.verifyPasswdRefreshImage(paramToServiceMsg);
      return;
    case 5: 
      MsfService.core.verifyPasswdImage(paramToServiceMsg);
      return;
    case 4: 
      MsfService.core.verifyPasswd(paramToServiceMsg);
      return;
    case 3: 
      QLog.d(a, 1, "handleMsfRequest unRegisterMsfService");
      MsfService.core.getNetFlowStore().a();
      paramContext = Boolean.valueOf(true);
      if (paramToServiceMsg.extraData.containsKey("to_stop_wake_process")) {
        paramContext = Boolean.valueOf(paramToServiceMsg.extraData.getBoolean("to_stop_wake_process"));
      }
      e.a((String)localObject1, paramContext);
      return;
    case 2: 
      e.a((String)localObject1, ((Integer)paramToServiceMsg.getAttribute("k_event")).intValue(), ((Long)paramToServiceMsg.getAttribute("k_arg0")).longValue(), ((Long)paramToServiceMsg.getAttribute("k_arg1")).longValue());
      return;
    }
    QLog.d(a, 1, "handleMsfRequest registerMsfService");
    paramContext = (MsfServiceBindInfo)paramToServiceMsg.getAttributes().get("intent_bindServiceInfo");
    e.a(paramContext.getProcessName(), paramContext.getBootBoradcastName(), paramContext.getMsfServiceCallbacker(), paramToServiceMsg.getAppId());
    MsfCore.initAppProMsg(u.b(paramToServiceMsg), paramToServiceMsg.getAppId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.r
 * JD-Core Version:    0.7.0.1
 */