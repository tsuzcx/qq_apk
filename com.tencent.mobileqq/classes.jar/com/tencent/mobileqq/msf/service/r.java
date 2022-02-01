package com.tencent.mobileqq.msf.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ab;
import com.tencent.mobileqq.msf.core.aj;
import com.tencent.mobileqq.msf.core.ao;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.auth.l;
import com.tencent.mobileqq.msf.core.c.f;
import com.tencent.mobileqq.msf.core.c.f.a;
import com.tencent.mobileqq.msf.core.i;
import com.tencent.mobileqq.msf.core.net.k.b;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.core.push.RegPushReason;
import com.tencent.mobileqq.msf.core.push.a;
import com.tencent.mobileqq.msf.core.push.g;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.core.w;
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
    if (paramToServiceMsg == null) {}
    label64:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            localObject1 = u.b(paramToServiceMsg);
            if (("LongConn.OffPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(paramToServiceMsg.getServiceCmd())))
            {
              QLog.d(a, 1, "handleMsfRequest." + paramToServiceMsg.getStringForLog());
              paramToServiceMsg.addAttribute("__timestamp_app2msf", Long.valueOf(System.currentTimeMillis()));
              if (((paramToServiceMsg.getServiceCmd().equals("RegPrxySvc.infoLogin")) || (paramToServiceMsg.getServiceCmd().equals("RegPrxySvc.infoSync"))) && (!g.u))
              {
                QLog.d(a, 1, "get infoLogin, but not register push, register now");
                localObject3 = paramContext.getPackageName();
                if (localObject3 == null) {
                  break label819;
                }
                localObject2 = new ToServiceMsg("", paramToServiceMsg.getUin(), "push.register");
                ((ToServiceMsg)localObject2).setMsfCommand(MsfCommand.registerPush);
                ((ToServiceMsg)localObject2).setAppId(paramToServiceMsg.getAppId());
                ((ToServiceMsg)localObject2).setTimeout(30000L);
                MsfSdkUtils.addToMsgProcessName((String)localObject3, (ToServiceMsg)localObject2);
                localObject3 = (a)MsfService.core.pushManager.i.get(localObject3);
                if (localObject3 == null) {
                  break label687;
                }
                aa.a((ToServiceMsg)localObject2, ((a)localObject3).k);
                MsfService.core.pushManager.a((ToServiceMsg)localObject2, RegPushReason.fillRegProxy);
              }
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d(a, 2, (String)localObject1 + " msfCommand: " + paramToServiceMsg.getMsfCommand());
              }
              switch (s.a[paramToServiceMsg.getMsfCommand().ordinal()])
              {
              default: 
                MsfService.core.sendSsoMsg(paramToServiceMsg);
                return;
                if ((!QLog.isColorLevel()) || (paramToServiceMsg.getMsfCommand().equals(MsfCommand.reportSocket))) {
                  break label64;
                }
                QLog.d(a, 2, "recv " + (String)localObject1 + " req:" + paramToServiceMsg);
                break label64;
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
                continue;
                QLog.d(a, 1, "qqprocessName not find can not register");
              }
            }
            QLog.d(a, 1, "handleMsfRequest registerMsfService");
            paramContext = (MsfServiceBindInfo)paramToServiceMsg.getAttributes().get("intent_bindServiceInfo");
            e.a(paramContext.getProcessName(), paramContext.getBootBoradcastName(), paramContext.getMsfServiceCallbacker(), paramToServiceMsg.getAppId());
            MsfCore.initAppProMsg(u.b(paramToServiceMsg), paramToServiceMsg.getAppId());
            return;
            e.a((String)localObject1, ((Integer)paramToServiceMsg.getAttribute("k_event")).intValue(), ((Long)paramToServiceMsg.getAttribute("k_arg0")).longValue(), ((Long)paramToServiceMsg.getAttribute("k_arg1")).longValue());
            return;
            QLog.d(a, 1, "handleMsfRequest unRegisterMsfService");
            MsfService.core.getNetFlowStore().a();
            paramContext = Boolean.valueOf(true);
            if (paramToServiceMsg.extraData.containsKey("to_stop_wake_process")) {
              paramContext = Boolean.valueOf(paramToServiceMsg.extraData.getBoolean("to_stop_wake_process"));
            }
            e.a((String)localObject1, paramContext);
            return;
            MsfService.core.verifyPasswd(paramToServiceMsg);
            return;
            MsfService.core.verifyPasswdImage(paramToServiceMsg);
            return;
            MsfService.core.verifyPasswdRefreshImage(paramToServiceMsg);
            return;
            MsfService.core.login(paramToServiceMsg, 16, 0, new byte[0]);
            return;
            MsfService.core.ChangeUinLogin(paramToServiceMsg);
            return;
            MsfService.core.changeTokenAfterLogin(paramToServiceMsg, true);
            return;
            MsfService.core.syncDelAccount(paramToServiceMsg);
            paramContext = u.a(paramToServiceMsg);
            paramContext.addAttribute("resp_simpleAccount_uin", paramToServiceMsg.getUin());
            paramContext.setMsgSuccess();
            e.a((String)localObject1, paramToServiceMsg, paramContext);
            return;
            MsfService.core.submitVerifycode(paramToServiceMsg);
            return;
            MsfService.core.refreVerifycode(paramToServiceMsg);
            return;
            MsfService.core.submitPuzzleVerifyCodeTicket(paramToServiceMsg);
            return;
            paramContext = paramToServiceMsg.getUin();
            if (!TextUtils.isEmpty(paramContext))
            {
              MsfService.core.refreshWebviewTickets(paramContext, "NotifyReLogin");
              return;
              paramContext = (RegPushReason)paramToServiceMsg.getAttribute("regPushReason");
              MsfService.core.registerPush(paramToServiceMsg, paramContext);
              return;
              MsfService.core.unRegisterPush(paramToServiceMsg);
              return;
              MsfService.core.registerCmdCall(paramToServiceMsg);
              return;
              MsfService.core.unRegisterCmdCall(paramToServiceMsg);
              return;
              QLog.d(a, 1, "handleMsfRequest proxyRegisterPush");
              paramContext = aa.d(paramToServiceMsg);
              e.a(paramContext.b, paramContext.c, null, paramToServiceMsg.getAppId());
              MsfService.core.proxyRegister(paramContext, paramToServiceMsg);
              return;
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
              MsfService.core.report(paramToServiceMsg);
              return;
              paramContext = MsfService.core.handleGetAccountKey(paramContext, paramToServiceMsg, paramInt);
              localObject2 = u.a(paramToServiceMsg);
              ((FromServiceMsg)localObject2).addAttribute(((FromServiceMsg)localObject2).getServiceCmd(), paramContext);
              ((FromServiceMsg)localObject2).setMsgSuccess();
              e.a((String)localObject1, paramToServiceMsg, (FromServiceMsg)localObject2);
              return;
              paramContext = paramToServiceMsg.getUin();
              paramContext = MsfService.core.getWtLoginCenter().c(paramContext);
              localObject2 = u.a(paramToServiceMsg);
              ((FromServiceMsg)localObject2).getAttributes().put("keyMap", paramContext);
              ((FromServiceMsg)localObject2).setMsgSuccess();
              e.a((String)localObject1, paramToServiceMsg, (FromServiceMsg)localObject2);
              return;
              paramContext = MsfService.core.syncGetServerConfig(paramToServiceMsg);
              localObject2 = u.a(paramToServiceMsg);
              ((FromServiceMsg)localObject2).addAttribute("to_getServerConfig_type", Integer.valueOf(((Integer)paramToServiceMsg.getAttributes().get("to_getServerConfig_type")).intValue()));
              ((FromServiceMsg)localObject2).addAttribute("to_getServerConfig_content", paramContext);
              ((FromServiceMsg)localObject2).setMsgSuccess();
              e.a((String)localObject1, paramToServiceMsg, (FromServiceMsg)localObject2);
              return;
              MsfService.core.getPluginConfig(paramToServiceMsg);
              return;
              MsfService.core.getWtLoginCenter().g(paramToServiceMsg);
              return;
              MsfService.core.getWtLoginCenter().h(paramToServiceMsg);
              return;
              MsfService.core.getWtLoginCenter().k(paramToServiceMsg);
              return;
              MsfService.core.getWtLoginCenter().i(paramToServiceMsg);
              return;
              MsfService.core.getWtLoginCenter().j(paramToServiceMsg);
              return;
              MsfService.core.getWtLoginCenter().l(paramToServiceMsg);
              return;
              MsfService.core.getWtLoginCenter().m(paramToServiceMsg);
              return;
              MsfService.core.getWtLoginCenter().n(paramToServiceMsg);
              return;
              MsfService.core.suspend();
              return;
              MsfService.core.resume();
              return;
              QLog.e(a, 1, "appDataIncerment not handled");
              return;
              QLog.e(a, 1, "appDataIncerment not handled");
              return;
              paramContext = u.a(paramToServiceMsg);
              paramContext.addAttribute(paramToServiceMsg.getServiceCmd(), "dropped");
              paramContext.setMsgSuccess();
              e.a((String)localObject1, paramToServiceMsg, paramContext);
              return;
              paramContext = new JceInputStream((byte[])paramToServiceMsg.getAttribute(paramToServiceMsg.getServiceCmd()));
              paramToServiceMsg = new RdmReq();
              paramToServiceMsg.readFrom(paramContext);
              if (MsfService.core.getStatReporter() != null)
              {
                MsfService.core.getStatReporter().a(paramToServiceMsg.appKey, paramToServiceMsg.eventName, paramToServiceMsg.isSucceed, paramToServiceMsg.elapse, paramToServiceMsg.size, paramToServiceMsg.params, paramToServiceMsg.isRealTime, paramToServiceMsg.isImmediatelyUpload, paramToServiceMsg.isMerge);
                return;
                MsfService.core.getNetFlowStore().a(paramToServiceMsg);
                return;
                paramContext = aj.o();
                localObject2 = u.a(paramToServiceMsg);
                ((FromServiceMsg)localObject2).addAttribute(paramToServiceMsg.getServiceCmd(), paramContext);
                ((FromServiceMsg)localObject2).setMsgSuccess();
                e.a((String)localObject1, paramToServiceMsg, (FromServiceMsg)localObject2);
                return;
                e.b((String)localObject1, paramToServiceMsg, u.a(paramToServiceMsg));
                return;
                e.c((String)localObject1, paramToServiceMsg, u.a(paramToServiceMsg));
                return;
                paramInt = ((Integer)paramToServiceMsg.getAttribute("NetExceptionType")).intValue();
                if (QLog.isDevelopLevel()) {
                  QLog.d("MSF.C.NetExceptionStat", 4, "get a NetExceptionStatistics event value:" + paramInt);
                }
                switch (paramInt)
                {
                default: 
                  return;
                }
                com.tencent.mobileqq.msf.core.net.k.a(k.b.a);
                return;
                paramInt = ((Integer)paramToServiceMsg.getAttribute("cmd")).intValue();
                paramContext = new WirelessPsw.CWirelessPswReq();
                paramContext.cmd.set(paramInt);
                paramContext.time.set((int)(System.currentTimeMillis() / 1000L));
                paramContext.uin.set(Long.parseLong(paramToServiceMsg.getUin()));
                try
                {
                  localObject1 = InetAddress.getByName(aj.o());
                  localObject2 = ((InetAddress)localObject1).getAddress();
                  if ((localObject2.length > 4) || (localObject2.length <= 0))
                  {
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d(a, 2, "SEND_WIRELESS_PSWREQ inetAddress error :" + localObject1);
                    return;
                  }
                }
                catch (Exception paramContext)
                {
                  paramContext.printStackTrace();
                  return;
                }
                i = localObject2[0];
                j = localObject2[1];
                k = localObject2[2];
                m = localObject2[3];
                paramContext.ip.set(0x0 | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8 | m & 0xFF);
                localObject1 = MsfService.getCore().getAccountCenter().f();
                paramContext.ksid.set(ByteStringMicro.copyFrom((byte[])localObject1));
                localObject2 = paramContext.toByteArray();
                l = localObject2.length;
                localObject3 = new byte[(int)l + 4];
                a((byte[])localObject3, 0, 4L + l);
                System.arraycopy(localObject2, 0, localObject3, 4, (int)l);
                paramToServiceMsg.putWupBuffer((byte[])localObject3);
                if (QLog.isDevelopLevel()) {
                  QLog.d(a, 4, "WIRELESS_PSWREQ cmd:" + paramInt + " time:" + paramContext.time.get() + " uin:" + paramContext.uin.get() + " ip:" + paramContext.ip.get() + " ksid:" + localObject1);
                }
                MsfService.core.sendSsoMsg(paramToServiceMsg);
                return;
                paramInt = ((Integer)paramToServiceMsg.getAttribute("cmd")).intValue();
                paramContext = new WirelessMibao.CWirelessMibaoReq();
                paramContext.cmd.set(paramInt);
                paramContext.time.set((int)(System.currentTimeMillis() / 1000L));
                paramContext.uin.set(Long.parseLong(paramToServiceMsg.getUin()));
                try
                {
                  localObject1 = InetAddress.getByName(aj.o());
                  localObject2 = ((InetAddress)localObject1).getAddress();
                  if ((localObject2.length > 4) || (localObject2.length <= 0))
                  {
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d(a, 2, "SEND_WIRELESS_PSWREQ inetAddress error :" + localObject1);
                  }
                }
                catch (Exception paramContext)
                {
                  paramContext.printStackTrace();
                  return;
                }
              }
            }
          }
          int i = localObject2[0];
          int j = localObject2[1];
          int k = localObject2[2];
          int m = localObject2[3];
          paramContext.ip.set(0x0 | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8 | m & 0xFF);
          Object localObject1 = MsfService.getCore().getAccountCenter().f();
          paramContext.ksid.set(ByteStringMicro.copyFrom((byte[])localObject1));
          paramContext.imei.set(w.d());
          paramContext.guid.set(ByteStringMicro.copyFrom(l.a()));
          Object localObject2 = paramContext.toByteArray();
          long l = localObject2.length;
          Object localObject3 = new byte[(int)l + 4];
          a((byte[])localObject3, 0, 4L + l);
          System.arraycopy(localObject2, 0, localObject3, 4, (int)l);
          paramToServiceMsg.putWupBuffer((byte[])localObject3);
          if (QLog.isDevelopLevel()) {
            QLog.d(a, 4, "WIRELESS_MEIBAOREQ cmd:" + paramInt + " time:" + paramContext.time.get() + " uin:" + paramContext.uin.get() + " ip:" + paramContext.ip.get() + " ksid:" + localObject1);
          }
          MsfService.core.sendSsoMsg(paramToServiceMsg);
          return;
          MsfService.core.wt_GetOpenKeyWithoutPasswd(paramToServiceMsg);
          return;
          MsfService.core.wt_GetStWithPasswd(paramToServiceMsg);
          return;
          MsfService.core.wt_GetStWithoutPasswd(paramToServiceMsg);
          return;
          MsfService.core.wt_CheckPictureAndGetSt(paramToServiceMsg);
          return;
          MsfService.core.wt_RefreshPictureData(paramToServiceMsg);
          return;
          MsfService.core.wt_VerifyCode(paramToServiceMsg);
          return;
          MsfService.core.wt_CloseCode(paramToServiceMsg);
          return;
          MsfService.core.wt_CancelCode(paramToServiceMsg);
          return;
          MsfService.core.wt_GetA1WithA1(paramToServiceMsg);
          return;
          MsfService.core.wt_CheckDevLockStatus(paramToServiceMsg);
          return;
          MsfService.core.wt_AskDevLockSms(paramToServiceMsg);
          return;
          MsfService.core.wt_CheckDevLockSms(paramToServiceMsg);
          return;
          MsfService.core.wt_CloseDevLock(paramToServiceMsg);
          return;
          MsfService.core.wt_setRegDevLockFlag(paramToServiceMsg);
          return;
          MsfService.core.wt_SetDevlockMobileType(paramToServiceMsg);
          return;
          MsfService.core.wt_RefreshSMSData(paramToServiceMsg);
          return;
          MsfService.core.wt_CheckSMSAndGetSt(paramToServiceMsg);
          return;
          MsfService.core.wt_CheckSMSAndGetStExt(paramToServiceMsg);
          return;
          MsfService.core.wt_RegGetSMSVerifyLoginAccount(paramToServiceMsg);
          return;
          MsfService.core.wt_CheckSMSVerifyLoginAccount(paramToServiceMsg);
          return;
          MsfService.core.wt_RefreshSMSVerifyLoginCode(paramToServiceMsg);
          return;
          MsfService.core.wt_VerifySMSVerifyLoginCode(paramToServiceMsg);
          return;
          MsfService.core.wt_GetStViaSMSVerifyLogin(paramToServiceMsg);
          return;
          MsfService.core.sendSsoMsg(paramToServiceMsg);
          paramContext = String.valueOf(paramToServiceMsg.getAttribute("stype", Integer.valueOf(0)));
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("MsgType", paramToServiceMsg.toString());
          ((HashMap)localObject1).put("SharpType", paramContext);
          MsfService.core.getStatReporter().a("dim.Msf.RecvVideoS2CACK", false, 0L, 0L, (Map)localObject1, true, false);
          f.a().a(f.a.i, paramToServiceMsg.getWupBuffer(), 0);
          return;
          paramContext = paramToServiceMsg.getUin();
          paramToServiceMsg = (String)paramToServiceMsg.getAttributes().get("src");
          MsfService.core.startPCActivePolling(paramContext, paramToServiceMsg);
          return;
          paramToServiceMsg.getUin();
          paramContext = (String)paramToServiceMsg.getAttributes().get("src");
          MsfService.core.stopPCActivePolling(paramContext);
          return;
          paramContext = paramToServiceMsg.getUin();
          localObject1 = (String)paramToServiceMsg.getAttributes().get("src");
          boolean bool = ((Boolean)paramToServiceMsg.getAttributes().get("opened")).booleanValue();
          MsfService.core.openUinPCActive(paramContext, (String)localObject1, bool);
          return;
          paramContext = u.a(paramToServiceMsg);
          paramContext.addAttribute("msf_con_erro", n.p);
          paramContext.setMsgSuccess();
          e.a((String)localObject1, paramToServiceMsg, paramContext);
          return;
          MsfService.core.sendMsgSignal();
          return;
          MsfService.core.refreshDA2(paramToServiceMsg);
          return;
          ab.a((String)localObject1, paramToServiceMsg);
          return;
          try
          {
            l = ((Long)paramToServiceMsg.getAttribute("infoSync_timestamp")).longValue();
            ao.a(paramToServiceMsg.getUin(), l);
            QLog.d(a, 1, "recv infoSync timestamp:" + l);
            return;
          }
          catch (Exception paramContext) {}
        } while (!QLog.isColorLevel());
        QLog.d(a, 2, "failed to recv infologin end ", paramContext);
        return;
        try
        {
          w.a((String)paramToServiceMsg.getAttribute("geoginfo_lontitude"), (String)paramToServiceMsg.getAttribute("geoginfo_latitude"), NetConnInfoCenter.getServerTime());
          return;
        }
        catch (Exception paramContext) {}
      } while (!QLog.isColorLevel());
      QLog.d(a, 2, "failed to save geog info ", paramContext);
      return;
      i.a(((Integer)paramToServiceMsg.getAttribute("opType")).intValue(), ((Integer)paramToServiceMsg.getAttribute("manualLogLevel")).intValue());
      return;
      paramInt = ((Integer)paramToServiceMsg.getAttribute("localeId")).intValue();
    } while (MsfCore.sCore == null);
    label687:
    label819:
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "msf_update_localeId, localeId = " + paramInt);
    }
    MsfCore.sCore.mLocaleId = paramInt;
    return;
    MsfService.core.updateBatteryStatus(paramToServiceMsg);
    return;
    q.a().a(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.r
 * JD-Core Version:    0.7.0.1
 */