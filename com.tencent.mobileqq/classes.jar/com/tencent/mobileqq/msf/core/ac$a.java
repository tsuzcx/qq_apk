package com.tencent.mobileqq.msf.core;

import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.msf.service.u;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffData;
import com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffItem;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class ac$a
  extends CodecWarpper
{
  ac$a(ac paramac) {}
  
  private com.tencent.qphone.base.a a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return com.tencent.qphone.base.a.u;
    case -2: 
      return com.tencent.qphone.base.a.v;
    case -3: 
      return com.tencent.qphone.base.a.w;
    case -4: 
      return com.tencent.qphone.base.a.x;
    case -5: 
      return com.tencent.qphone.base.a.j;
    case -6: 
      return com.tencent.qphone.base.a.r;
    case -7: 
      return com.tencent.qphone.base.a.s;
    }
    return com.tencent.qphone.base.a.y;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (MsfService.getCore().getStatReporter() != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("fail_code", String.valueOf(paramInt1));
      localHashMap.put("data_len", String.valueOf(paramInt2));
      MsfService.getCore().getStatReporter().a("msf_invalid_data", false, 0L, 0L, localHashMap, true, false);
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {}
    try
    {
      paramFromServiceMsg = paramFromServiceMsg.getServiceCmd();
      if ((!TextUtils.isEmpty(paramFromServiceMsg)) && (paramFromServiceMsg.equals("SharpSvr.s2c"))) {
        u.a("MSF:VideoPush", 3000L);
      }
      return;
    }
    catch (Throwable paramFromServiceMsg)
    {
      QLog.e(tag, 1, "checkVideoPushCmd fail.", paramFromServiceMsg);
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    a(paramFromServiceMsg);
    paramFromServiceMsg.addAttribute("__timestamp_net2msf", Long.valueOf(System.currentTimeMillis()));
    paramFromServiceMsg.addAttribute("__timestamp_net2msf_boot", Long.valueOf(SystemClock.elapsedRealtime()));
    Object localObject = paramFromServiceMsg.getMsgCookie();
    if ((localObject != null) && (localObject.length > 0)) {
      this.a.D.sender.a((byte[])localObject);
    }
    paramFromServiceMsg.setRequestSsoSeq(paramFromServiceMsg.getAppSeq());
    if ((!paramFromServiceMsg.isSuccess()) && (paramFromServiceMsg.getBusinessFailCode() == -10008)) {
      ac.a(paramFromServiceMsg.getUin(), false);
    }
    ToServiceMsg localToServiceMsg;
    for (;;)
    {
      if (NetConnInfoCenter.isNeedWifiAuth()) {
        NetConnInfoCenter.setNeedWifiAuth(false);
      }
      localToServiceMsg = this.a.D.sender.c(paramFromServiceMsg.getRequestSsoSeq());
      label137:
      long l2;
      long l1;
      StringBuilder localStringBuilder;
      String str2;
      int i;
      label286:
      String str1;
      if (localToServiceMsg != null)
      {
        localObject = localToServiceMsg.getServiceCmd();
        l2 = 0L;
        l1 = l2;
        if (localToServiceMsg != null)
        {
          l1 = l2;
          if (localToServiceMsg.getAttribute("__timestamp_msf2net") != null)
          {
            l1 = l2;
            if (paramFromServiceMsg != null)
            {
              l1 = l2;
              if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
              {
                l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() - ((Long)localToServiceMsg.getAttribute("__timestamp_msf2net")).longValue();
                l1 = l2;
                if (l2 < 0L) {
                  l1 = 0L;
                }
                l2 = l1;
                if (l1 > 2147483647L) {
                  l2 = 0L;
                }
                paramFromServiceMsg.addAttribute("__timestamp_msf2net", localToServiceMsg.getAttribute("__timestamp_msf2net"));
                l1 = l2;
              }
            }
          }
        }
        localStringBuilder = new StringBuilder();
        str2 = paramFromServiceMsg.getServiceCmd();
        if (!com.tencent.mobileqq.a.a.a.b) {
          break label1056;
        }
        i = 1;
        if (!QLog.isDevelopLevel()) {
          break label1165;
        }
        if (l1 != 0L) {
          break label1061;
        }
        str1 = String.valueOf(l1);
        label306:
        if (paramFromServiceMsg.getResultCode() == 1000) {
          break label1087;
        }
        QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + paramFromServiceMsg.getUin() + " cmd:" + str2 + " len:" + paramInt + " costTime:" + str1 + " code:" + paramFromServiceMsg.getResultCode() + " failMsg:" + paramFromServiceMsg.getBusinessFailMsg() + " cross:" + i);
        label417:
        paramFromServiceMsg.addAttribute("_tag_LOGSTR", ac.E + "|" + paramFromServiceMsg.getRequestSsoSeq() + "|" + paramFromServiceMsg.getServiceCmd() + "|");
        paramFromServiceMsg.addAttribute("_tag_socket", ac.E);
        paramFromServiceMsg.addAttribute("_tag_localsocket", ac.F);
        paramFromServiceMsg.addAttribute("_tag_socket_nettype", Integer.valueOf(ac.G));
        if (localToServiceMsg == null) {}
      }
      try
      {
        this.a.b.a(paramFromServiceMsg, localToServiceMsg);
        i = paramFromServiceMsg.getRequestSsoSeq();
        l2 = paramInt;
        if (localToServiceMsg == null)
        {
          bool = true;
          com.tencent.mobileqq.a.a.f.a((String)localObject, i, l2, l1, bool);
          com.tencent.mobileqq.a.a.a.a().a(localToServiceMsg, paramFromServiceMsg);
          if ((this.a.D.isReconnectSso.get()) && (this.a.D.sender.d()))
          {
            this.a.b.l().b(com.tencent.qphone.base.a.h);
            this.a.D.isReconnectSso.set(false);
          }
          if (localToServiceMsg == null) {
            break label1556;
          }
          paramFromServiceMsg.setAppSeq(localToServiceMsg.getAppSeq());
          paramFromServiceMsg.setMsfCommand(localToServiceMsg.getMsfCommand());
          paramFromServiceMsg.setAppId(localToServiceMsg.getAppId());
          if (paramFromServiceMsg.isSuccess()) {
            break label1556;
          }
          i = paramFromServiceMsg.getBusinessFailCode();
          paramInt = i;
          if (i == 302)
          {
            paramFromServiceMsg.setBusinessFail(-302);
            paramInt = -302;
          }
          if (paramInt != -302) {
            break label1447;
          }
          this.a.b.l().b(com.tencent.qphone.base.a.i);
          this.a.D.reSendMsg(localToServiceMsg);
          return;
          if ((paramFromServiceMsg.getUin() == null) || (paramFromServiceMsg.getUin().length() <= 4) || (ac.af.contains(paramFromServiceMsg.getUin())) || (!paramFromServiceMsg.isSuccess()) || (paramFromServiceMsg.getServiceCmd().startsWith("login.")) || (paramFromServiceMsg.getServiceCmd().startsWith("wtlogin.")) || (paramFromServiceMsg.getServiceCmd().equals("ConfigService.ClientReq")) || (paramFromServiceMsg.getServiceCmd().equals("ResourceConfig.ClientReq")) || (paramFromServiceMsg.getServiceCmd().equals("GrayUinPro.Check")) || (paramFromServiceMsg.getServiceCmd().equals("account.RequestReBindMblWTLogin_emp")) || (paramFromServiceMsg.getServiceCmd().equals("account.RequestVerifyWTLogin_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.get_app_info_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.sdk_auth_api_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.get_auth_api_list_emp"))) {
            continue;
          }
          localObject = (ConcurrentLinkedQueue)ac.t.get(paramFromServiceMsg.getUin());
          if ((localObject != null) && (((ConcurrentLinkedQueue)localObject).contains(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()))))
          {
            ac.t.remove(paramFromServiceMsg.getUin());
            ac.a(paramFromServiceMsg.getUin(), true);
            QLog.d(tag, 1, "recv Packet removeItem setV9, ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + ", uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
            continue;
          }
          QLog.d(tag, 1, "recv Packet ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + ", uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
          continue;
          localObject = paramFromServiceMsg.getServiceCmd();
          break label137;
          label1056:
          i = 0;
          break label286;
          label1061:
          str1 = l1 + NetConnInfoCenter.getSignalStrengthsLog();
          break label306;
          label1087:
          QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + paramFromServiceMsg.getUin() + " cmd:" + str2 + " len:" + paramInt + " costTime:" + str1 + " cross:" + i);
          break label417;
          label1165:
          if (paramFromServiceMsg.getResultCode() != 1000)
          {
            QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + com.tencent.mobileqq.msf.core.b.a.a(str2) + new StringBuilder().append(" ").append(paramFromServiceMsg.getRequestSsoSeq() + paramInt).toString() + " code:" + paramFromServiceMsg.getResultCode() + " failMsg:" + paramFromServiceMsg.getBusinessFailMsg() + " cross:" + i);
            break label417;
          }
          QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + com.tencent.mobileqq.msf.core.b.a.a(str2) + new StringBuilder().append(" ").append(paramFromServiceMsg.getRequestSsoSeq() + paramInt).toString() + " cross:" + i);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.a.b.g();
          this.a.b.m = 0L;
          QLog.d(tag, 1, "call firstResponseGetted error " + localException, localException);
          continue;
          boolean bool = false;
        }
        label1447:
        if (paramInt == -10008)
        {
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getRequestSsoSeq() == 0)) {
            MsfCore.sCore.getStatReporter().a(false, localToServiceMsg, paramFromServiceMsg);
          }
          if (!MsfMsgUtil.hasResendBy10008(localToServiceMsg))
          {
            localToServiceMsg.getAttributes().put("_attr_msg_has_resend_by_10008", Boolean.valueOf(true));
            QLog.d(tag, 1, "Resend 10008 " + localToServiceMsg.getShortStringForLog());
            this.a.D.reSendMsg(localToServiceMsg);
            return;
          }
          QLog.d(tag, 1, "This msg has already resend by -10008, won't resend again!");
        }
      }
    }
    label1556:
    if (ac.v().get())
    {
      QLog.e(tag, 1, "invalidSign, " + paramFromServiceMsg + " is droped.");
      this.a.D.getAccountCenter().g.a();
      s.a().z();
      this.a.n();
      return;
    }
    if (paramFromServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive) {
      this.a.a(paramFromServiceMsg, localToServiceMsg);
    }
    for (;;)
    {
      ac.i(this.a);
      break;
      if (paramFromServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat)
      {
        this.a.D.quicksender.a(localToServiceMsg, paramFromServiceMsg, false);
      }
      else
      {
        ac.A.set(0);
        ac.B.clear();
        this.a.D.getSsoRespHandler().b(localToServiceMsg, paramFromServiceMsg);
      }
    }
  }
  
  private void a(ByteBuffer paramByteBuffer)
  {
    if (!ac.w()) {
      return;
    }
    if (paramByteBuffer.remaining() < 16)
    {
      QLog.d(tag, 1, "setGatewayIpV6, remaining = " + paramByteBuffer.remaining());
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        byte[] arrayOfByte = new byte[2];
        i = 0;
        if (i < 8)
        {
          paramByteBuffer.get(arrayOfByte);
          localStringBuilder.append(HexUtil.bytes2HexStr(arrayOfByte));
          if (i == 7) {
            break label226;
          }
          localStringBuilder.append(":");
          break label226;
        }
        paramByteBuffer = f.a(localStringBuilder.toString().toLowerCase());
        ac.e(paramByteBuffer);
        if (!QLog.isDevelopLevel()) {
          break label170;
        }
        QLog.d(tag, 2, "setGatewayIpV6, ip = " + paramByteBuffer);
        return;
      }
      catch (Throwable paramByteBuffer) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(tag, 2, "setGatewayIpV6 throws e", paramByteBuffer);
      return;
      label170:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(tag, 2, "setGatewayIpV6, " + com.tencent.mobileqq.msf.core.b.a.a(new StringBuilder().append("ip = ").append(paramByteBuffer).toString()));
      return;
      label226:
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d(tag, 1, "MSF.C.CodecWarpper loginMerge onInvalidData " + paramInt1 + " size is " + paramInt2 + ", try to closeConn");
    this.a.b.l().b(a(paramInt1));
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(ac.d(this.a)).append("|").append(MsfCore.mobileQQAppid).append("|").append(paramInt3).append("|").append(paramInt1).append("|").append(this.a.b.l().b().a());
    if (QLog.isDevelopLevel()) {
      QLog.d(tag, 4, "CodecStatHelper Report loginMerge_error " + localStringBuffer.toString());
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("loginMerge_failDetail", localStringBuffer.toString());
    if (MsfService.getCore().getStatReporter() != null) {
      MsfService.getCore().getStatReporter().a("loginMerge_error", true, 0L, 0L, localHashMap, false, false);
    }
  }
  
  public void onInvalidData(int paramInt1, int paramInt2)
  {
    QLog.d(tag, 1, "MSF.C.CodecWarpper onInvalidData " + paramInt1 + " size is " + paramInt2 + ", try to closeConn");
    this.a.b.l().b(a(paramInt1));
    try
    {
      this.a.b.i();
      a(paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d(tag, 1, "call findResponseDataError error " + localException);
      }
    }
  }
  
  public void onInvalidSign()
  {
    QLog.d(tag, 1, "MSF.C.CodecWarpper onInvalidSign");
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(this.a.D.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_InvalidSign");
    localFromServiceMsg.setBusinessFail(2014, "onInvalidSign");
    localFromServiceMsg.setMsfCommand(MsfCommand.onInvalidSign);
    MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
    this.a.D.addRespToQuque(null, localFromServiceMsg);
    ac.v().set(true);
  }
  
  public void onResponse(int paramInt1, Object paramObject, int paramInt2)
  {
    Object localObject1 = null;
    if (paramObject != null) {}
    try
    {
      if (ac.V != -1) {
        ac.V = -1;
      }
      this.a.T = System.currentTimeMillis();
      ac.U = this.a.T;
      localObject2 = (FromServiceMsg)paramObject;
      try
      {
        paramInt1 = ((FromServiceMsg)localObject2).getWupBuffer().length;
        if (!((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge")) {
          break label417;
        }
        ((FromServiceMsg)localObject2).setRequestSsoSeq(((FromServiceMsg)localObject2).getAppSeq());
        if (((FromServiceMsg)localObject2).isSuccess()) {
          break label417;
        }
        if (!QLog.isColorLevel()) {
          break label404;
        }
        localObject1 = ((FromServiceMsg)localObject2).getServiceCmd();
        QLog.d("MSF.C.NetConnTag", 1, "failed merge netRecv ssoSeq:" + ((FromServiceMsg)localObject2).getRequestSsoSeq() + " cmd: " + (String)localObject1 + " len: " + ((FromServiceMsg)localObject2).getWupBuffer().length);
        localObject1 = (ArrayList)this.a.e.remove(Integer.valueOf(((FromServiceMsg)localObject2).getRequestSsoSeq()));
        if (((FromServiceMsg)localObject2).getBusinessFailCode() == -10107)
        {
          if (this.a.r) {
            this.a.r = false;
          }
          QLog.d("MSF.C.NetConnTag", 1, "merge not support, " + Arrays.toString(((ArrayList)localObject1).toArray()) + "resend, close merge.");
        }
        if (localObject1 == null) {
          break label417;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramInt1 = ((Integer)((Iterator)localObject1).next()).intValue();
          ToServiceMsg localToServiceMsg = this.a.D.sender.c(paramInt1);
          if (localToServiceMsg != null) {
            ac.a(this.a, localToServiceMsg);
          }
        }
        if (!((Throwable)localObject2).toString().contains("InvalidProtocol")) {
          break label354;
        }
      }
      catch (Throwable localThrowable2)
      {
        localObject1 = localObject2;
        localObject2 = localThrowable2;
      }
    }
    catch (Throwable localThrowable1)
    {
      Object localObject2;
      label323:
      label354:
      break label323;
    }
    if (localObject1 != null) {
      a(-8, paramInt2, ((FromServiceMsg)localObject1).getRequestSsoSeq());
    }
    if (QLog.isColorLevel()) {
      QLog.d(tag, 2, "handleSsoResp " + paramObject + " error " + ((Throwable)localObject2).toString(), (Throwable)localObject2);
    }
    for (;;)
    {
      return;
      label404:
      localObject1 = com.tencent.mobileqq.msf.core.b.a.a(((FromServiceMsg)localObject2).getServiceCmd());
      break;
      label417:
      int i;
      if ((((FromServiceMsg)localObject2).getFlag() & 0x1) != 0)
      {
        localObject1 = ((FromServiceMsg)localObject2).getWupBuffer();
        i = localObject1.length;
        if (i > 4) {
          i = (localObject1[0] & 0xFF) << 24 | 0x0 | (localObject1[1] & 0xFF) << 16 | (localObject1[2] & 0xFF) << 8 | localObject1[3] & 0xFF;
        }
      }
      else
      {
        try
        {
          Object localObject3 = new byte[i];
          System.arraycopy(localObject1, 4, localObject3, 0, i - 4);
          localObject3 = com.tencent.qphone.base.util.j.b((byte[])localObject3);
          Object localObject4 = new byte[localObject3.length + 4];
          localObject4[0] = ((byte)(localObject3.length + 4 >> 24 & 0xFF));
          localObject4[1] = ((byte)(localObject3.length + 4 >> 16 & 0xFF));
          localObject4[2] = ((byte)(localObject3.length + 4 >> 8 & 0xFF));
          localObject4[3] = ((byte)(localObject3.length + 4 & 0xFF));
          System.arraycopy(localObject3, 0, localObject4, 4, localObject3.length);
          ((FromServiceMsg)localObject2).putWupBuffer((byte[])localObject4);
          if ((!((FromServiceMsg)localObject2).isSuccess()) || (!((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge"))) {
            break label1002;
          }
          QLog.d("MSF.C.NetConnTag", 1, "netRecv Delay FromServiceMsg ssoSeq:" + ((FromServiceMsg)localObject2).getRequestSsoSeq() + " scmd: " + ((FromServiceMsg)localObject2).getServiceCmd() + " len: " + paramInt1 + " uncompressed len: " + ((FromServiceMsg)localObject2).getWupBuffer().length);
          localObject1 = new SSOLoginMerge.BusiBuffData();
          localObject3 = new byte[((FromServiceMsg)localObject2).getWupBuffer().length - 4];
          System.arraycopy(((FromServiceMsg)localObject2).getWupBuffer(), 4, localObject3, 0, localObject3.length);
          localObject1 = ((SSOLoginMerge.BusiBuffData)((SSOLoginMerge.BusiBuffData)localObject1).mergeFrom((byte[])localObject3)).BusiBuffVec.get().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (SSOLoginMerge.BusiBuffItem)((Iterator)localObject1).next();
            localObject4 = new FromServiceMsg();
            ((FromServiceMsg)localObject4).setServiceCmd(((SSOLoginMerge.BusiBuffItem)localObject3).ServiceCmd.get());
            ((FromServiceMsg)localObject4).setRequestSsoSeq(((SSOLoginMerge.BusiBuffItem)localObject3).SeqNo.get());
            ((FromServiceMsg)localObject4).putWupBuffer(((SSOLoginMerge.BusiBuffItem)localObject3).BusiBuff.get().toByteArray());
            ((FromServiceMsg)localObject4).setAppSeq(((FromServiceMsg)localObject4).getRequestSsoSeq());
            ((FromServiceMsg)localObject4).setMsgSuccess();
            ((FromServiceMsg)localObject4).setUin(((FromServiceMsg)localObject2).getUin());
            ((FromServiceMsg)localObject4).putWupBuffer(ac.b(((FromServiceMsg)localObject4).getWupBuffer()));
            a((FromServiceMsg)localObject4, ((FromServiceMsg)localObject4).getWupBuffer().length);
          }
          if (((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge")) {
            break label987;
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "uncompress data failed " + localException);
          }
          if (!((FromServiceMsg)localObject2).getServiceCmd().equals("SSO.LoginMerge"))
          {
            onInvalidData(-7, localObject1.length);
            return;
          }
          a(-7, localObject1.length, ((FromServiceMsg)localObject2).getRequestSsoSeq());
          return;
        }
      }
    }
    onInvalidData(-6, localObject1.length);
    return;
    label987:
    a(-6, localObject1.length, ((FromServiceMsg)localObject2).getRequestSsoSeq());
    return;
    label1002:
    a((FromServiceMsg)localObject2, paramInt2);
  }
  
  /* Error */
  public void onResponse(int paramInt1, Object paramObject, int paramInt2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aload_2
    //   4: ifnull +428 -> 432
    //   7: getstatic 695	com/tencent/mobileqq/msf/core/ac:V	I
    //   10: iconst_m1
    //   11: if_icmpeq +7 -> 18
    //   14: iconst_m1
    //   15: putstatic 695	com/tencent/mobileqq/msf/core/ac:V	I
    //   18: aload_0
    //   19: getfield 10	com/tencent/mobileqq/msf/core/ac$a:a	Lcom/tencent/mobileqq/msf/core/ac;
    //   22: invokestatic 136	java/lang/System:currentTimeMillis	()J
    //   25: putfield 698	com/tencent/mobileqq/msf/core/ac:T	J
    //   28: aload_0
    //   29: getfield 10	com/tencent/mobileqq/msf/core/ac$a:a	Lcom/tencent/mobileqq/msf/core/ac;
    //   32: getfield 698	com/tencent/mobileqq/msf/core/ac:T	J
    //   35: putstatic 701	com/tencent/mobileqq/msf/core/ac:U	J
    //   38: aload_2
    //   39: checkcast 86	com/tencent/qphone/base/remote/FromServiceMsg
    //   42: astore 9
    //   44: aload 9
    //   46: invokevirtual 704	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   49: arraylength
    //   50: istore_1
    //   51: aload 9
    //   53: invokevirtual 238	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   56: tableswitch	default:+1430 -> 1486, -10112:+561->617, -10111:+460->516, -10110:+377->433
    //   85: lconst_0
    //   86: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   89: ldc_w 706
    //   92: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifeq +569 -> 664
    //   98: aload 9
    //   100: aload 9
    //   102: invokevirtual 172	com/tencent/qphone/base/remote/FromServiceMsg:getAppSeq	()I
    //   105: invokevirtual 176	com/tencent/qphone/base/remote/FromServiceMsg:setRequestSsoSeq	(I)V
    //   108: aload 9
    //   110: invokevirtual 180	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   113: ifne +551 -> 664
    //   116: invokestatic 606	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +532 -> 651
    //   122: aload 9
    //   124: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   127: astore 8
    //   129: ldc 240
    //   131: iconst_1
    //   132: new 222	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 708
    //   142: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 9
    //   147: invokevirtual 201	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   150: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: ldc_w 710
    //   156: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 8
    //   161: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc_w 712
    //   167: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 9
    //   172: invokevirtual 704	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   175: arraylength
    //   176: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload_0
    //   186: getfield 10	com/tencent/mobileqq/msf/core/ac$a:a	Lcom/tencent/mobileqq/msf/core/ac;
    //   189: getfield 714	com/tencent/mobileqq/msf/core/ac:e	Ljava/util/concurrent/ConcurrentHashMap;
    //   192: aload 9
    //   194: invokevirtual 201	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   197: invokestatic 298	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: invokevirtual 422	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   203: checkcast 560	java/util/ArrayList
    //   206: astore 8
    //   208: aload 9
    //   210: invokevirtual 183	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailCode	()I
    //   213: sipush -10107
    //   216: if_icmpne +60 -> 276
    //   219: aload_0
    //   220: getfield 10	com/tencent/mobileqq/msf/core/ac$a:a	Lcom/tencent/mobileqq/msf/core/ac;
    //   223: getfield 716	com/tencent/mobileqq/msf/core/ac:r	Z
    //   226: ifeq +11 -> 237
    //   229: aload_0
    //   230: getfield 10	com/tencent/mobileqq/msf/core/ac$a:a	Lcom/tencent/mobileqq/msf/core/ac;
    //   233: iconst_0
    //   234: putfield 716	com/tencent/mobileqq/msf/core/ac:r	Z
    //   237: ldc 240
    //   239: iconst_1
    //   240: new 222	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   247: ldc_w 718
    //   250: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 8
    //   255: invokevirtual 722	java/util/ArrayList:toArray	()[Ljava/lang/Object;
    //   258: invokestatic 727	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   261: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc_w 729
    //   267: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: aload 8
    //   278: ifnull +386 -> 664
    //   281: aload 8
    //   283: invokevirtual 733	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   286: astore 4
    //   288: aload 4
    //   290: invokeinterface 738 1 0
    //   295: ifeq +137 -> 432
    //   298: aload 4
    //   300: invokeinterface 742 1 0
    //   305: checkcast 295	java/lang/Integer
    //   308: invokevirtual 745	java/lang/Integer:intValue	()I
    //   311: istore_1
    //   312: aload_0
    //   313: getfield 10	com/tencent/mobileqq/msf/core/ac$a:a	Lcom/tencent/mobileqq/msf/core/ac;
    //   316: getfield 162	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   319: getfield 165	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ac;
    //   322: iload_1
    //   323: invokevirtual 205	com/tencent/mobileqq/msf/core/ac:c	(I)Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   326: astore 8
    //   328: aload 8
    //   330: ifnull -42 -> 288
    //   333: aload_0
    //   334: getfield 10	com/tencent/mobileqq/msf/core/ac$a:a	Lcom/tencent/mobileqq/msf/core/ac;
    //   337: aload 8
    //   339: invokestatic 748	com/tencent/mobileqq/msf/core/ac:a	(Lcom/tencent/mobileqq/msf/core/ac;Lcom/tencent/qphone/base/remote/ToServiceMsg;)I
    //   342: pop
    //   343: goto -55 -> 288
    //   346: astore 8
    //   348: aload 9
    //   350: astore 4
    //   352: aload 8
    //   354: invokevirtual 749	java/lang/Throwable:toString	()Ljava/lang/String;
    //   357: ldc_w 751
    //   360: invokevirtual 753	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   363: ifeq +20 -> 383
    //   366: aload 4
    //   368: ifnull +15 -> 383
    //   371: aload_0
    //   372: bipush 248
    //   374: iload_3
    //   375: aload 4
    //   377: invokevirtual 201	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   380: invokevirtual 755	com/tencent/mobileqq/msf/core/ac$a:a	(III)V
    //   383: invokestatic 606	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq +46 -> 432
    //   389: getstatic 115	com/tencent/mobileqq/msf/core/ac$a:tag	Ljava/lang/String;
    //   392: iconst_2
    //   393: new 222	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   400: ldc_w 757
    //   403: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload_2
    //   407: invokevirtual 458	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   410: ldc_w 759
    //   413: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload 8
    //   418: invokevirtual 749	java/lang/Throwable:toString	()Ljava/lang/String;
    //   421: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: aload 8
    //   429: invokestatic 460	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   432: return
    //   433: aload_0
    //   434: getfield 10	com/tencent/mobileqq/msf/core/ac$a:a	Lcom/tencent/mobileqq/msf/core/ac;
    //   437: getfield 162	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   440: getfield 853	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/c;
    //   443: invokevirtual 857	com/tencent/mobileqq/msf/core/a/c:e	()V
    //   446: aload_0
    //   447: getfield 10	com/tencent/mobileqq/msf/core/ac$a:a	Lcom/tencent/mobileqq/msf/core/ac;
    //   450: getfield 162	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   453: getfield 165	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ac;
    //   456: getfield 301	com/tencent/mobileqq/msf/core/ac:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   459: invokevirtual 332	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   462: getstatic 335	com/tencent/qphone/base/a:h	Lcom/tencent/qphone/base/a;
    //   465: invokevirtual 340	com/tencent/mobileqq/msf/core/net/m:b	(Lcom/tencent/qphone/base/a;)V
    //   468: aload_0
    //   469: getfield 10	com/tencent/mobileqq/msf/core/ac$a:a	Lcom/tencent/mobileqq/msf/core/ac;
    //   472: getfield 162	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   475: getfield 321	com/tencent/mobileqq/msf/core/MsfCore:isReconnectSso	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   478: iconst_0
    //   479: invokevirtual 343	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   482: getstatic 115	com/tencent/mobileqq/msf/core/ac$a:tag	Ljava/lang/String;
    //   485: iconst_1
    //   486: new 222	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   493: ldc_w 859
    //   496: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload 9
    //   501: invokevirtual 238	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   504: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   507: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   513: goto -429 -> 84
    //   516: getstatic 115	com/tencent/mobileqq/msf/core/ac$a:tag	Ljava/lang/String;
    //   519: iconst_1
    //   520: new 222	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   527: ldc_w 861
    //   530: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload 9
    //   535: invokevirtual 238	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   538: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   541: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: aload_0
    //   548: getfield 10	com/tencent/mobileqq/msf/core/ac$a:a	Lcom/tencent/mobileqq/msf/core/ac;
    //   551: getfield 162	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   554: getfield 853	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/c;
    //   557: invokevirtual 857	com/tencent/mobileqq/msf/core/a/c:e	()V
    //   560: iconst_1
    //   561: invokestatic 865	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
    //   564: iconst_2
    //   565: if_icmpeq -481 -> 84
    //   568: aload_0
    //   569: getfield 10	com/tencent/mobileqq/msf/core/ac$a:a	Lcom/tencent/mobileqq/msf/core/ac;
    //   572: getfield 162	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   575: getfield 165	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ac;
    //   578: getfield 301	com/tencent/mobileqq/msf/core/ac:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   581: invokevirtual 332	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   584: getstatic 335	com/tencent/qphone/base/a:h	Lcom/tencent/qphone/base/a;
    //   587: invokevirtual 340	com/tencent/mobileqq/msf/core/net/m:b	(Lcom/tencent/qphone/base/a;)V
    //   590: aload_0
    //   591: getfield 10	com/tencent/mobileqq/msf/core/ac$a:a	Lcom/tencent/mobileqq/msf/core/ac;
    //   594: getfield 162	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   597: getfield 321	com/tencent/mobileqq/msf/core/MsfCore:isReconnectSso	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   600: iconst_0
    //   601: invokevirtual 343	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   604: getstatic 115	com/tencent/mobileqq/msf/core/ac$a:tag	Ljava/lang/String;
    //   607: iconst_1
    //   608: ldc_w 867
    //   611: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   614: goto -530 -> 84
    //   617: getstatic 115	com/tencent/mobileqq/msf/core/ac$a:tag	Ljava/lang/String;
    //   620: iconst_1
    //   621: new 222	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   628: ldc_w 861
    //   631: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload 9
    //   636: invokevirtual 238	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   639: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   642: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   645: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   648: goto -564 -> 84
    //   651: aload 9
    //   653: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   656: invokestatic 444	com/tencent/mobileqq/msf/core/b/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   659: astore 8
    //   661: goto -532 -> 129
    //   664: aload 9
    //   666: invokevirtual 762	com/tencent/qphone/base/remote/FromServiceMsg:getFlag	()I
    //   669: iconst_1
    //   670: iand
    //   671: ifeq +188 -> 859
    //   674: aload 9
    //   676: invokevirtual 704	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   679: astore 8
    //   681: aload 8
    //   683: arraylength
    //   684: istore 5
    //   686: iload 5
    //   688: iconst_4
    //   689: if_icmple +692 -> 1381
    //   692: iconst_0
    //   693: aload 8
    //   695: iconst_0
    //   696: baload
    //   697: sipush 255
    //   700: iand
    //   701: bipush 24
    //   703: ishl
    //   704: ior
    //   705: aload 8
    //   707: iconst_1
    //   708: baload
    //   709: sipush 255
    //   712: iand
    //   713: bipush 16
    //   715: ishl
    //   716: ior
    //   717: aload 8
    //   719: iconst_2
    //   720: baload
    //   721: sipush 255
    //   724: iand
    //   725: bipush 8
    //   727: ishl
    //   728: ior
    //   729: aload 8
    //   731: iconst_3
    //   732: baload
    //   733: sipush 255
    //   736: iand
    //   737: ior
    //   738: istore 5
    //   740: iload 5
    //   742: newarray byte
    //   744: astore 10
    //   746: aload 8
    //   748: iconst_4
    //   749: aload 10
    //   751: iconst_0
    //   752: iload 5
    //   754: iconst_4
    //   755: isub
    //   756: invokestatic 766	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   759: aload 10
    //   761: invokestatic 771	com/tencent/qphone/base/util/j:b	([B)[B
    //   764: astore 10
    //   766: aload 10
    //   768: arraylength
    //   769: iconst_4
    //   770: iadd
    //   771: newarray byte
    //   773: astore 11
    //   775: aload 11
    //   777: iconst_0
    //   778: aload 10
    //   780: arraylength
    //   781: iconst_4
    //   782: iadd
    //   783: bipush 24
    //   785: ishr
    //   786: sipush 255
    //   789: iand
    //   790: i2b
    //   791: bastore
    //   792: aload 11
    //   794: iconst_1
    //   795: aload 10
    //   797: arraylength
    //   798: iconst_4
    //   799: iadd
    //   800: bipush 16
    //   802: ishr
    //   803: sipush 255
    //   806: iand
    //   807: i2b
    //   808: bastore
    //   809: aload 11
    //   811: iconst_2
    //   812: aload 10
    //   814: arraylength
    //   815: iconst_4
    //   816: iadd
    //   817: bipush 8
    //   819: ishr
    //   820: sipush 255
    //   823: iand
    //   824: i2b
    //   825: bastore
    //   826: aload 11
    //   828: iconst_3
    //   829: aload 10
    //   831: arraylength
    //   832: iconst_4
    //   833: iadd
    //   834: sipush 255
    //   837: iand
    //   838: i2b
    //   839: bastore
    //   840: aload 10
    //   842: iconst_0
    //   843: aload 11
    //   845: iconst_4
    //   846: aload 10
    //   848: arraylength
    //   849: invokestatic 766	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   852: aload 9
    //   854: aload 11
    //   856: invokevirtual 774	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
    //   859: aload 4
    //   861: ifnull +169 -> 1030
    //   864: aload 9
    //   866: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   869: ldc_w 869
    //   872: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   875: ifeq +155 -> 1030
    //   878: invokestatic 152	android/os/SystemClock:elapsedRealtime	()J
    //   881: lstore 6
    //   883: iconst_0
    //   884: lload 6
    //   886: ldc2_w 870
    //   889: lsub
    //   890: lload 6
    //   892: invokestatic 874	com/tencent/mobileqq/msf/core/c/j:a	(ZJJ)B
    //   895: putstatic 876	com/tencent/mobileqq/msf/core/ac:w	I
    //   898: new 878	com/tencent/msf/service/protocol/pb/SSOReserveField$ReserveFields
    //   901: dup
    //   902: invokespecial 879	com/tencent/msf/service/protocol/pb/SSOReserveField$ReserveFields:<init>	()V
    //   905: astore 8
    //   907: aload 8
    //   909: aload 4
    //   911: invokevirtual 880	com/tencent/msf/service/protocol/pb/SSOReserveField$ReserveFields:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   914: pop
    //   915: new 222	java/lang/StringBuilder
    //   918: dup
    //   919: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   922: astore 4
    //   924: aload 4
    //   926: aload 8
    //   928: getfield 884	com/tencent/msf/service/protocol/pb/SSOReserveField$ReserveFields:sso_send	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   931: invokevirtual 888	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   934: invokevirtual 437	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   937: ldc_w 280
    //   940: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: invokestatic 136	java/lang/System:currentTimeMillis	()J
    //   946: invokevirtual 437	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: aload 9
    //   952: ldc_w 890
    //   955: aload 4
    //   957: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   960: invokevirtual 145	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   963: pop
    //   964: getstatic 115	com/tencent/mobileqq/msf/core/ac$a:tag	Ljava/lang/String;
    //   967: iconst_1
    //   968: new 222	java/lang/StringBuilder
    //   971: dup
    //   972: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   975: ldc_w 892
    //   978: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: aload 4
    //   983: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   986: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   992: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   995: aload_0
    //   996: getfield 10	com/tencent/mobileqq/msf/core/ac$a:a	Lcom/tencent/mobileqq/msf/core/ac;
    //   999: getfield 162	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1002: getfield 896	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   1005: ifnull +25 -> 1030
    //   1008: aload_0
    //   1009: getfield 10	com/tencent/mobileqq/msf/core/ac$a:a	Lcom/tencent/mobileqq/msf/core/ac;
    //   1012: getfield 162	com/tencent/mobileqq/msf/core/ac:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1015: getfield 896	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   1018: ldc_w 898
    //   1021: iconst_1
    //   1022: lconst_0
    //   1023: lconst_0
    //   1024: aconst_null
    //   1025: iconst_0
    //   1026: iconst_0
    //   1027: invokevirtual 81	com/tencent/mobileqq/msf/core/c/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   1030: aload 9
    //   1032: invokevirtual 180	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   1035: ifeq +402 -> 1437
    //   1038: aload 9
    //   1040: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   1043: ldc_w 706
    //   1046: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1049: ifeq +388 -> 1437
    //   1052: ldc 240
    //   1054: iconst_1
    //   1055: new 222	java/lang/StringBuilder
    //   1058: dup
    //   1059: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   1062: ldc_w 776
    //   1065: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: aload 9
    //   1070: invokevirtual 201	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   1073: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1076: ldc_w 778
    //   1079: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: aload 9
    //   1084: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   1087: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: ldc_w 712
    //   1093: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1096: iload_1
    //   1097: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1100: ldc_w 780
    //   1103: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: aload 9
    //   1108: invokevirtual 704	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1111: arraylength
    //   1112: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1115: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1118: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1121: new 782	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData
    //   1124: dup
    //   1125: invokespecial 783	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData:<init>	()V
    //   1128: astore 4
    //   1130: aload 9
    //   1132: invokevirtual 704	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1135: arraylength
    //   1136: iconst_4
    //   1137: isub
    //   1138: newarray byte
    //   1140: astore 8
    //   1142: aload 9
    //   1144: invokevirtual 704	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1147: iconst_4
    //   1148: aload 8
    //   1150: iconst_0
    //   1151: aload 8
    //   1153: arraylength
    //   1154: invokestatic 766	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1157: aload 4
    //   1159: aload 8
    //   1161: invokevirtual 787	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1164: checkcast 782	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData
    //   1167: getfield 791	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData:BusiBuffVec	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1170: invokevirtual 796	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1173: invokeinterface 799 1 0
    //   1178: astore 4
    //   1180: aload 4
    //   1182: invokeinterface 738 1 0
    //   1187: ifeq -755 -> 432
    //   1190: aload 4
    //   1192: invokeinterface 742 1 0
    //   1197: checkcast 801	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffItem
    //   1200: astore 8
    //   1202: new 86	com/tencent/qphone/base/remote/FromServiceMsg
    //   1205: dup
    //   1206: invokespecial 802	com/tencent/qphone/base/remote/FromServiceMsg:<init>	()V
    //   1209: astore 10
    //   1211: aload 10
    //   1213: aload 8
    //   1215: getfield 806	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffItem:ServiceCmd	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1218: invokevirtual 810	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1221: invokevirtual 813	com/tencent/qphone/base/remote/FromServiceMsg:setServiceCmd	(Ljava/lang/String;)V
    //   1224: aload 10
    //   1226: aload 8
    //   1228: getfield 817	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffItem:SeqNo	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1231: invokevirtual 821	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1234: invokevirtual 176	com/tencent/qphone/base/remote/FromServiceMsg:setRequestSsoSeq	(I)V
    //   1237: aload 10
    //   1239: aload 8
    //   1241: getfield 825	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffItem:BusiBuff	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1244: invokevirtual 830	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1247: invokevirtual 835	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1250: invokevirtual 774	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
    //   1253: aload 10
    //   1255: aload 10
    //   1257: invokevirtual 201	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   1260: invokevirtual 347	com/tencent/qphone/base/remote/FromServiceMsg:setAppSeq	(I)V
    //   1263: aload 10
    //   1265: invokevirtual 838	com/tencent/qphone/base/remote/FromServiceMsg:setMsgSuccess	()V
    //   1268: aload 10
    //   1270: aload 9
    //   1272: invokevirtual 186	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   1275: invokevirtual 841	com/tencent/qphone/base/remote/FromServiceMsg:setUin	(Ljava/lang/String;)V
    //   1278: aload 10
    //   1280: aload 10
    //   1282: invokevirtual 704	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1285: invokestatic 842	com/tencent/mobileqq/msf/core/ac:b	([B)[B
    //   1288: invokevirtual 774	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
    //   1291: aload_0
    //   1292: aload 10
    //   1294: aload 10
    //   1296: invokevirtual 704	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1299: arraylength
    //   1300: invokespecial 844	com/tencent/mobileqq/msf/core/ac$a:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;I)V
    //   1303: goto -123 -> 1180
    //   1306: astore 4
    //   1308: invokestatic 606	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1311: ifeq +31 -> 1342
    //   1314: getstatic 115	com/tencent/mobileqq/msf/core/ac$a:tag	Ljava/lang/String;
    //   1317: iconst_2
    //   1318: new 222	java/lang/StringBuilder
    //   1321: dup
    //   1322: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   1325: ldc_w 846
    //   1328: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: aload 4
    //   1333: invokevirtual 458	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1336: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1339: invokestatic 273	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1342: aload 9
    //   1344: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   1347: ldc_w 706
    //   1350: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1353: ifne +13 -> 1366
    //   1356: aload_0
    //   1357: bipush 249
    //   1359: aload 8
    //   1361: arraylength
    //   1362: invokevirtual 848	com/tencent/mobileqq/msf/core/ac$a:onInvalidData	(II)V
    //   1365: return
    //   1366: aload_0
    //   1367: bipush 249
    //   1369: aload 8
    //   1371: arraylength
    //   1372: aload 9
    //   1374: invokevirtual 201	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   1377: invokevirtual 755	com/tencent/mobileqq/msf/core/ac$a:a	(III)V
    //   1380: return
    //   1381: aload 9
    //   1383: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   1386: ldc_w 706
    //   1389: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1392: ifne +13 -> 1405
    //   1395: aload_0
    //   1396: bipush 250
    //   1398: aload 8
    //   1400: arraylength
    //   1401: invokevirtual 848	com/tencent/mobileqq/msf/core/ac$a:onInvalidData	(II)V
    //   1404: return
    //   1405: aload_0
    //   1406: bipush 250
    //   1408: aload 8
    //   1410: arraylength
    //   1411: aload 9
    //   1413: invokevirtual 201	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   1416: invokevirtual 755	com/tencent/mobileqq/msf/core/ac$a:a	(III)V
    //   1419: return
    //   1420: astore 4
    //   1422: getstatic 115	com/tencent/mobileqq/msf/core/ac$a:tag	Ljava/lang/String;
    //   1425: iconst_1
    //   1426: ldc_w 900
    //   1429: aload 4
    //   1431: invokestatic 460	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1434: goto -404 -> 1030
    //   1437: aload 9
    //   1439: invokevirtual 180	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   1442: ifeq +27 -> 1469
    //   1445: aload 9
    //   1447: invokevirtual 90	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   1450: ldc_w 902
    //   1453: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1456: ifeq +13 -> 1469
    //   1459: aload 9
    //   1461: invokevirtual 704	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1464: iconst_1
    //   1465: invokestatic 908	com/tencent/mobileqq/msf/core/net/utils/MsfPullConfigUtil:parseConfigResponse	([BZ)V
    //   1468: return
    //   1469: aload_0
    //   1470: aload 9
    //   1472: iload_3
    //   1473: invokespecial 844	com/tencent/mobileqq/msf/core/ac$a:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;I)V
    //   1476: return
    //   1477: astore 8
    //   1479: aload 10
    //   1481: astore 4
    //   1483: goto -1131 -> 352
    //   1486: goto -1402 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1489	0	this	a
    //   0	1489	1	paramInt1	int
    //   0	1489	2	paramObject	Object
    //   0	1489	3	paramInt2	int
    //   0	1489	4	paramArrayOfByte	byte[]
    //   684	72	5	i	int
    //   881	10	6	l	long
    //   127	211	8	localObject1	Object
    //   346	82	8	localThrowable1	Throwable
    //   659	750	8	localObject2	Object
    //   1477	1	8	localThrowable2	Throwable
    //   42	1429	9	localFromServiceMsg	FromServiceMsg
    //   1	1479	10	localObject3	Object
    //   773	82	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   44	84	346	java/lang/Throwable
    //   84	129	346	java/lang/Throwable
    //   129	237	346	java/lang/Throwable
    //   237	276	346	java/lang/Throwable
    //   281	288	346	java/lang/Throwable
    //   288	328	346	java/lang/Throwable
    //   333	343	346	java/lang/Throwable
    //   433	513	346	java/lang/Throwable
    //   516	614	346	java/lang/Throwable
    //   617	648	346	java/lang/Throwable
    //   651	661	346	java/lang/Throwable
    //   664	686	346	java/lang/Throwable
    //   740	859	346	java/lang/Throwable
    //   864	1030	346	java/lang/Throwable
    //   1030	1180	346	java/lang/Throwable
    //   1180	1303	346	java/lang/Throwable
    //   1308	1342	346	java/lang/Throwable
    //   1342	1365	346	java/lang/Throwable
    //   1366	1380	346	java/lang/Throwable
    //   1381	1404	346	java/lang/Throwable
    //   1405	1419	346	java/lang/Throwable
    //   1422	1434	346	java/lang/Throwable
    //   1437	1468	346	java/lang/Throwable
    //   1469	1476	346	java/lang/Throwable
    //   740	859	1306	java/lang/Exception
    //   864	1030	1420	java/lang/Exception
    //   7	18	1477	java/lang/Throwable
    //   18	44	1477	java/lang/Throwable
  }
  
  public int onSSOPingResponse(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null)
    {
      QLog.d(tag, 1, "MSF.C.CodecWarpper onSSOPingResponse error, data null, connId = " + paramInt);
      return -1;
    }
    if (paramArrayOfByte.length <= 4)
    {
      QLog.d(tag, 1, "MSF.C.CodecWarpper onSSOPingResponse error, length: " + paramArrayOfByte.length);
      return 1;
    }
    int j = paramArrayOfByte.length;
    Object localObject1;
    int i;
    Object localObject2;
    try
    {
      localObject1 = ByteBuffer.wrap(paramArrayOfByte);
      i = ((ByteBuffer)localObject1).getInt();
      if (i != j) {
        return 1;
      }
      ((ByteBuffer)localObject1).getInt();
      ((ByteBuffer)localObject1).getInt();
      int k = ((ByteBuffer)localObject1).get() - 1;
      if ((k > 0) && (k <= i - 13))
      {
        localObject2 = new byte[k];
        ((ByteBuffer)localObject1).get((byte[])localObject2, 0, k);
        localObject2 = new String((byte[])localObject2);
        if ((!((String)localObject2).equals("MSF")) && (!((String)localObject2).equals("GWv4")) && (com.tencent.mobileqq.msf.core.a.a.aQ()))
        {
          boolean bool = com.tencent.mobileqq.msf.core.net.a.b.b();
          if (bool)
          {
            try
            {
              com.tencent.mobileqq.msf.core.net.a.b.b(paramArrayOfByte);
              return 0;
            }
            catch (Exception paramArrayOfByte)
            {
              for (;;)
              {
                QLog.d(tag, 1, "heartbeatproxy failed to process back msg ", paramArrayOfByte);
              }
            }
            return 0;
          }
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      QLog.d(tag, 1, "MSF.C.CodecWarpper onSSOPingResponse error, exception : ", paramArrayOfByte);
    }
    label933:
    label950:
    for (;;)
    {
      ((ByteBuffer)localObject1).position(((ByteBuffer)localObject1).get() + ((ByteBuffer)localObject1).position() - 1);
      i = ((ByteBuffer)localObject1).getInt();
      Object localObject3 = (i >> 24 & 0xFF) + '.' + (i >> 16 & 0xFF) + '.' + (i >> 8 & 0xFF) + '.' + (i & 0xFF);
      a((ByteBuffer)localObject1);
      if ("GWv4".equals(localObject2))
      {
        ac.O = i;
        if (paramArrayOfByte.length == 50)
        {
          byte[] arrayOfByte = new byte[24];
          ((ByteBuffer)localObject1).get(arrayOfByte, 0, 24);
          ac.N = arrayOfByte;
          if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "MSF.C.CodecWarpper onSSOPingResponse sGwV4Sec:" + ac.N);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(tag, 2, "MSF.C.CodecWarpper onSSOPingResponse cmd:" + (String)localObject2 + ", ip=" + (String)localObject3 + ", totalsize=" + j);
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        i = 0;
        while (i < j)
        {
          if (i % 4 == 0) {
            ((StringBuilder)localObject3).append("\n");
          }
          localObject2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
          localObject1 = localObject2;
          if (((String)localObject2).length() == 1) {
            localObject1 = "0" + (String)localObject2;
          }
          ((StringBuilder)localObject3).append((String)localObject1).append(" ");
          i += 1;
        }
        QLog.d(tag, 2, "MSF.C.CodecWarpper onSSOPingResponse pingBack=" + ((StringBuilder)localObject3).toString());
      }
      this.a.b.e(paramInt);
      localObject1 = this.a.b.l().h();
      long l2;
      long l1;
      if ((localObject1 != null) && (((ToServiceMsg)localObject1).getAttribute("__timestamp_msf2net") != null))
      {
        l2 = SystemClock.elapsedRealtime() - ((Long)((ToServiceMsg)localObject1).getAttribute("__timestamp_msf2net")).longValue();
        l1 = l2;
        if (l2 >= 0L) {
          break label933;
        }
        l1 = 0L;
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label950;
        }
        com.tencent.mobileqq.a.a.a.a().a(((ToServiceMsg)localObject1).getRequestSsoSeq(), l2);
        localObject2 = new StringBuilder();
        paramArrayOfByte = ((ToServiceMsg)localObject1).getServiceCmd();
        if (QLog.isDevelopLevel())
        {
          if (l2 == 0L) {}
          for (paramArrayOfByte = String.valueOf(l2);; paramArrayOfByte = l2 + NetConnInfoCenter.getSignalStrengthsLog())
          {
            QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + ((ToServiceMsg)localObject1).getRequestSsoSeq() + " uin:" + ((ToServiceMsg)localObject1).getUin() + " cmd:" + ((ToServiceMsg)localObject1).getServiceCmd() + " len:" + j + " costTime:" + paramArrayOfByte);
            break;
          }
        }
        QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + ((ToServiceMsg)localObject1).getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(((ToServiceMsg)localObject1).getUin()) + " cmd:" + com.tencent.mobileqq.msf.core.b.a.a(paramArrayOfByte) + new StringBuilder().append(" ").append(((ToServiceMsg)localObject1).getRequestSsoSeq() + j).toString());
        break;
        l2 = 0L;
        continue;
        return 1;
        l2 = l1;
        if (l1 > 2147483647L) {
          l2 = 0L;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ac.a
 * JD-Core Version:    0.7.0.1
 */