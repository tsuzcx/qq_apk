package com.tencent.mobileqq.msf.core;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.a.a.f;
import com.tencent.mobileqq.msf.core.b.c;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.core.net.n;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.msf.service.t;
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
import com.tencent.qphone.base.util.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class ag$a
  extends CodecWarpper
{
  ag$a(ag paramag) {}
  
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
  
  private void a(FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {}
    try
    {
      paramFromServiceMsg = paramFromServiceMsg.getServiceCmd();
      if ((!TextUtils.isEmpty(paramFromServiceMsg)) && (paramFromServiceMsg.equals("SharpSvr.s2c"))) {
        t.a("MSF:VideoPush", 3000L);
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
      ag.a(paramFromServiceMsg.getUin(), false);
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
          break label1045;
        }
        i = 1;
        if (!QLog.isDevelopLevel()) {
          break label1152;
        }
        if (l1 != 0L) {
          break label1050;
        }
        str1 = String.valueOf(l1);
        label306:
        if (paramFromServiceMsg.getResultCode() == 1000) {
          break label1076;
        }
        QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + paramFromServiceMsg.getUin() + " cmd:" + str2 + " len:" + paramInt + " costTime:" + str1 + " code:" + paramFromServiceMsg.getResultCode() + " failMsg:" + paramFromServiceMsg.getBusinessFailMsg() + " cross:" + i);
        label413:
        paramFromServiceMsg.addAttribute("_tag_LOGSTR", ag.E + "|" + paramFromServiceMsg.getRequestSsoSeq() + "|" + paramFromServiceMsg.getServiceCmd() + "|");
        paramFromServiceMsg.addAttribute("_tag_socket", ag.E);
        paramFromServiceMsg.addAttribute("_tag_localsocket", ag.F);
        paramFromServiceMsg.addAttribute("_tag_socket_nettype", Integer.valueOf(ag.G));
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
          f.a((String)localObject, i, l2, l1, bool);
          com.tencent.mobileqq.a.a.a.a().a(localToServiceMsg, paramFromServiceMsg);
          if ((this.a.D.isReconnectSso.get()) && (this.a.D.sender.d()))
          {
            this.a.b.l().b(com.tencent.qphone.base.a.h);
            this.a.D.isReconnectSso.set(false);
          }
          if (localToServiceMsg == null) {
            break label1539;
          }
          paramFromServiceMsg.setAppSeq(localToServiceMsg.getAppSeq());
          paramFromServiceMsg.setMsfCommand(localToServiceMsg.getMsfCommand());
          paramFromServiceMsg.setAppId(localToServiceMsg.getAppId());
          if (paramFromServiceMsg.isSuccess()) {
            break label1539;
          }
          i = paramFromServiceMsg.getBusinessFailCode();
          paramInt = i;
          if (i == 302)
          {
            paramFromServiceMsg.setBusinessFail(-302);
            paramInt = -302;
          }
          if (paramInt != -302) {
            break label1430;
          }
          this.a.b.l().b(com.tencent.qphone.base.a.i);
          this.a.D.reSendMsg(localToServiceMsg);
          return;
          if ((paramFromServiceMsg.getUin() == null) || (paramFromServiceMsg.getUin().length() <= 4) || (ag.af.contains(paramFromServiceMsg.getUin())) || (!paramFromServiceMsg.isSuccess()) || (paramFromServiceMsg.getServiceCmd().startsWith("login.")) || (paramFromServiceMsg.getServiceCmd().startsWith("wtlogin.")) || (paramFromServiceMsg.getServiceCmd().equals("ConfigService.ClientReq")) || (paramFromServiceMsg.getServiceCmd().equals("ResourceConfig.ClientReq")) || (paramFromServiceMsg.getServiceCmd().equals("GrayUinPro.Check")) || (paramFromServiceMsg.getServiceCmd().equals("account.RequestReBindMblWTLogin_emp")) || (paramFromServiceMsg.getServiceCmd().equals("account.RequestVerifyWTLogin_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.get_app_info_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.sdk_auth_api_emp")) || (paramFromServiceMsg.getServiceCmd().equals("ConnAuthSvr.get_auth_api_list_emp"))) {
            continue;
          }
          localObject = (ConcurrentLinkedQueue)ag.t.get(paramFromServiceMsg.getUin());
          if ((localObject != null) && (((ConcurrentLinkedQueue)localObject).contains(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()))))
          {
            ag.t.remove(paramFromServiceMsg.getUin());
            ag.a(paramFromServiceMsg.getUin(), true);
            QLog.d(tag, 1, "recv Packet removeItem setV9, ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + ", uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
            continue;
          }
          QLog.d(tag, 1, "recv Packet ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + ", uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
          continue;
          localObject = paramFromServiceMsg.getServiceCmd();
          break label137;
          label1045:
          i = 0;
          break label286;
          label1050:
          str1 = l1 + NetConnInfoCenter.getSignalStrengthsLog();
          break label306;
          label1076:
          QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + paramFromServiceMsg.getUin() + " cmd:" + str2 + " len:" + paramInt + " costTime:" + str1 + " cross:" + i);
          break label413;
          label1152:
          if (paramFromServiceMsg.getResultCode() != 1000)
          {
            QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + c.a(str2) + new StringBuilder().append(" ").append(paramFromServiceMsg.getRequestSsoSeq() + paramInt).toString() + " code:" + paramFromServiceMsg.getResultCode() + " failMsg:" + paramFromServiceMsg.getBusinessFailMsg() + " cross:" + i);
            break label413;
          }
          QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()) + " cmd:" + c.a(str2) + new StringBuilder().append(" ").append(paramFromServiceMsg.getRequestSsoSeq() + paramInt).toString() + " cross:" + i);
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
        label1430:
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
    label1539:
    if (ag.s().get()) {
      QLog.e(tag, 1, "invalidSign, " + paramFromServiceMsg + " is droped.");
    }
    for (;;)
    {
      this.a.D.getAccountCenter().g.a();
      w.a().z();
      this.a.l();
      return;
      if (paramFromServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive)
      {
        this.a.a(paramFromServiceMsg, localToServiceMsg);
      }
      else if (paramFromServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat)
      {
        this.a.D.quicksender.a(localToServiceMsg, paramFromServiceMsg, false);
      }
      else
      {
        ag.A.set(0);
        ag.B.clear();
        this.a.D.getSsoRespHandler().b(localToServiceMsg, paramFromServiceMsg);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d(tag, 1, "MSF.C.CodecWarpper loginMerge onInvalidData " + paramInt1 + " size is " + paramInt2 + ", try to closeConn");
    this.a.b.l().b(a(paramInt1));
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(ag.d(this.a)).append("|").append(MsfCore.mobileQQAppid).append("|").append(paramInt3).append("|").append(paramInt1).append("|").append(this.a.b.l().b().a());
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
      return;
    }
    catch (Exception localException)
    {
      QLog.d(tag, 1, "call findResponseDataError error " + localException);
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
    ag.s().set(true);
  }
  
  public void onResponse(int paramInt1, Object paramObject, int paramInt2)
  {
    Object localObject1 = null;
    if (paramObject != null) {}
    try
    {
      if (ag.V != -1) {
        ag.V = -1;
      }
      this.a.T = System.currentTimeMillis();
      ag.U = this.a.T;
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
            ag.a(this.a, localToServiceMsg);
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
      localObject1 = c.a(((FromServiceMsg)localObject2).getServiceCmd());
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
          localObject3 = l.b((byte[])localObject3);
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
            ((FromServiceMsg)localObject4).putWupBuffer(ag.b(((FromServiceMsg)localObject4).getWupBuffer()));
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
    //   7: getstatic 637	com/tencent/mobileqq/msf/core/ag:V	I
    //   10: iconst_m1
    //   11: if_icmpeq +7 -> 18
    //   14: iconst_m1
    //   15: putstatic 637	com/tencent/mobileqq/msf/core/ag:V	I
    //   18: aload_0
    //   19: getfield 10	com/tencent/mobileqq/msf/core/ag$a:a	Lcom/tencent/mobileqq/msf/core/ag;
    //   22: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   25: putfield 640	com/tencent/mobileqq/msf/core/ag:T	J
    //   28: aload_0
    //   29: getfield 10	com/tencent/mobileqq/msf/core/ag$a:a	Lcom/tencent/mobileqq/msf/core/ag;
    //   32: getfield 640	com/tencent/mobileqq/msf/core/ag:T	J
    //   35: putstatic 643	com/tencent/mobileqq/msf/core/ag:U	J
    //   38: aload_2
    //   39: checkcast 47	com/tencent/qphone/base/remote/FromServiceMsg
    //   42: astore 9
    //   44: aload 9
    //   46: invokevirtual 646	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   49: arraylength
    //   50: istore_1
    //   51: aload 9
    //   53: invokevirtual 204	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   56: tableswitch	default:+1429 -> 1485, -10112:+561->617, -10111:+460->516, -10110:+377->433
    //   85: lconst_0
    //   86: invokevirtual 51	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   89: ldc_w 648
    //   92: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifeq +569 -> 664
    //   98: aload 9
    //   100: aload 9
    //   102: invokevirtual 138	com/tencent/qphone/base/remote/FromServiceMsg:getAppSeq	()I
    //   105: invokevirtual 142	com/tencent/qphone/base/remote/FromServiceMsg:setRequestSsoSeq	(I)V
    //   108: aload 9
    //   110: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   113: ifne +551 -> 664
    //   116: invokestatic 651	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +532 -> 651
    //   122: aload 9
    //   124: invokevirtual 51	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   127: astore 8
    //   129: ldc 206
    //   131: iconst_1
    //   132: new 188	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 653
    //   142: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 9
    //   147: invokevirtual 167	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   150: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: ldc_w 655
    //   156: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 8
    //   161: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc_w 657
    //   167: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 9
    //   172: invokevirtual 646	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   175: arraylength
    //   176: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   179: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload_0
    //   186: getfield 10	com/tencent/mobileqq/msf/core/ag$a:a	Lcom/tencent/mobileqq/msf/core/ag;
    //   189: getfield 659	com/tencent/mobileqq/msf/core/ag:e	Ljava/util/concurrent/ConcurrentHashMap;
    //   192: aload 9
    //   194: invokevirtual 167	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   197: invokestatic 264	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: invokevirtual 388	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   203: checkcast 534	java/util/ArrayList
    //   206: astore 8
    //   208: aload 9
    //   210: invokevirtual 149	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailCode	()I
    //   213: sipush -10107
    //   216: if_icmpne +60 -> 276
    //   219: aload_0
    //   220: getfield 10	com/tencent/mobileqq/msf/core/ag$a:a	Lcom/tencent/mobileqq/msf/core/ag;
    //   223: getfield 661	com/tencent/mobileqq/msf/core/ag:r	Z
    //   226: ifeq +11 -> 237
    //   229: aload_0
    //   230: getfield 10	com/tencent/mobileqq/msf/core/ag$a:a	Lcom/tencent/mobileqq/msf/core/ag;
    //   233: iconst_0
    //   234: putfield 661	com/tencent/mobileqq/msf/core/ag:r	Z
    //   237: ldc 206
    //   239: iconst_1
    //   240: new 188	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   247: ldc_w 663
    //   250: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload 8
    //   255: invokevirtual 667	java/util/ArrayList:toArray	()[Ljava/lang/Object;
    //   258: invokestatic 672	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   261: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc_w 674
    //   267: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: aload 8
    //   278: ifnull +386 -> 664
    //   281: aload 8
    //   283: invokevirtual 678	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   286: astore 4
    //   288: aload 4
    //   290: invokeinterface 683 1 0
    //   295: ifeq +137 -> 432
    //   298: aload 4
    //   300: invokeinterface 687 1 0
    //   305: checkcast 261	java/lang/Integer
    //   308: invokevirtual 690	java/lang/Integer:intValue	()I
    //   311: istore_1
    //   312: aload_0
    //   313: getfield 10	com/tencent/mobileqq/msf/core/ag$a:a	Lcom/tencent/mobileqq/msf/core/ag;
    //   316: getfield 126	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   319: getfield 131	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   322: iload_1
    //   323: invokevirtual 171	com/tencent/mobileqq/msf/core/ag:c	(I)Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   326: astore 8
    //   328: aload 8
    //   330: ifnull -42 -> 288
    //   333: aload_0
    //   334: getfield 10	com/tencent/mobileqq/msf/core/ag$a:a	Lcom/tencent/mobileqq/msf/core/ag;
    //   337: aload 8
    //   339: invokestatic 693	com/tencent/mobileqq/msf/core/ag:a	(Lcom/tencent/mobileqq/msf/core/ag;Lcom/tencent/qphone/base/remote/ToServiceMsg;)I
    //   342: pop
    //   343: goto -55 -> 288
    //   346: astore 8
    //   348: aload 9
    //   350: astore 4
    //   352: aload 8
    //   354: invokevirtual 694	java/lang/Throwable:toString	()Ljava/lang/String;
    //   357: ldc_w 696
    //   360: invokevirtual 698	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   363: ifeq +20 -> 383
    //   366: aload 4
    //   368: ifnull +15 -> 383
    //   371: aload_0
    //   372: bipush 248
    //   374: iload_3
    //   375: aload 4
    //   377: invokevirtual 167	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   380: invokevirtual 700	com/tencent/mobileqq/msf/core/ag$a:a	(III)V
    //   383: invokestatic 651	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq +46 -> 432
    //   389: getstatic 78	com/tencent/mobileqq/msf/core/ag$a:tag	Ljava/lang/String;
    //   392: iconst_2
    //   393: new 188	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   400: ldc_w 702
    //   403: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload_2
    //   407: invokevirtual 424	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   410: ldc_w 704
    //   413: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload 8
    //   418: invokevirtual 694	java/lang/Throwable:toString	()Ljava/lang/String;
    //   421: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: aload 8
    //   429: invokestatic 426	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   432: return
    //   433: aload_0
    //   434: getfield 10	com/tencent/mobileqq/msf/core/ag$a:a	Lcom/tencent/mobileqq/msf/core/ag;
    //   437: getfield 126	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   440: getfield 799	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/c;
    //   443: invokevirtual 803	com/tencent/mobileqq/msf/core/a/c:e	()V
    //   446: aload_0
    //   447: getfield 10	com/tencent/mobileqq/msf/core/ag$a:a	Lcom/tencent/mobileqq/msf/core/ag;
    //   450: getfield 126	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   453: getfield 131	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   456: getfield 267	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   459: invokevirtual 298	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   462: getstatic 301	com/tencent/qphone/base/a:h	Lcom/tencent/qphone/base/a;
    //   465: invokevirtual 306	com/tencent/mobileqq/msf/core/net/m:b	(Lcom/tencent/qphone/base/a;)V
    //   468: aload_0
    //   469: getfield 10	com/tencent/mobileqq/msf/core/ag$a:a	Lcom/tencent/mobileqq/msf/core/ag;
    //   472: getfield 126	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   475: getfield 287	com/tencent/mobileqq/msf/core/MsfCore:isReconnectSso	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   478: iconst_0
    //   479: invokevirtual 309	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   482: getstatic 78	com/tencent/mobileqq/msf/core/ag$a:tag	Ljava/lang/String;
    //   485: iconst_1
    //   486: new 188	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   493: ldc_w 805
    //   496: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload 9
    //   501: invokevirtual 204	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   504: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   507: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   513: goto -429 -> 84
    //   516: getstatic 78	com/tencent/mobileqq/msf/core/ag$a:tag	Ljava/lang/String;
    //   519: iconst_1
    //   520: new 188	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   527: ldc_w 807
    //   530: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload 9
    //   535: invokevirtual 204	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   538: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   541: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: aload_0
    //   548: getfield 10	com/tencent/mobileqq/msf/core/ag$a:a	Lcom/tencent/mobileqq/msf/core/ag;
    //   551: getfield 126	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   554: getfield 799	com/tencent/mobileqq/msf/core/MsfCore:ssoListManager	Lcom/tencent/mobileqq/msf/core/a/c;
    //   557: invokevirtual 803	com/tencent/mobileqq/msf/core/a/c:e	()V
    //   560: iconst_1
    //   561: invokestatic 811	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
    //   564: iconst_2
    //   565: if_icmpeq -481 -> 84
    //   568: aload_0
    //   569: getfield 10	com/tencent/mobileqq/msf/core/ag$a:a	Lcom/tencent/mobileqq/msf/core/ag;
    //   572: getfield 126	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   575: getfield 131	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   578: getfield 267	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   581: invokevirtual 298	com/tencent/mobileqq/msf/core/net/n:l	()Lcom/tencent/mobileqq/msf/core/net/m;
    //   584: getstatic 301	com/tencent/qphone/base/a:h	Lcom/tencent/qphone/base/a;
    //   587: invokevirtual 306	com/tencent/mobileqq/msf/core/net/m:b	(Lcom/tencent/qphone/base/a;)V
    //   590: aload_0
    //   591: getfield 10	com/tencent/mobileqq/msf/core/ag$a:a	Lcom/tencent/mobileqq/msf/core/ag;
    //   594: getfield 126	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   597: getfield 287	com/tencent/mobileqq/msf/core/MsfCore:isReconnectSso	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   600: iconst_0
    //   601: invokevirtual 309	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   604: getstatic 78	com/tencent/mobileqq/msf/core/ag$a:tag	Ljava/lang/String;
    //   607: iconst_1
    //   608: ldc_w 813
    //   611: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   614: goto -530 -> 84
    //   617: getstatic 78	com/tencent/mobileqq/msf/core/ag$a:tag	Ljava/lang/String;
    //   620: iconst_1
    //   621: new 188	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   628: ldc_w 807
    //   631: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload 9
    //   636: invokevirtual 204	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   639: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   642: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   645: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   648: goto -564 -> 84
    //   651: aload 9
    //   653: invokevirtual 51	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   656: invokestatic 410	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   659: astore 8
    //   661: goto -532 -> 129
    //   664: aload 9
    //   666: invokevirtual 707	com/tencent/qphone/base/remote/FromServiceMsg:getFlag	()I
    //   669: iconst_1
    //   670: iand
    //   671: ifeq +188 -> 859
    //   674: aload 9
    //   676: invokevirtual 646	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   679: astore 8
    //   681: aload 8
    //   683: arraylength
    //   684: istore 5
    //   686: iload 5
    //   688: iconst_4
    //   689: if_icmple +691 -> 1380
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
    //   756: invokestatic 711	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   759: aload 10
    //   761: invokestatic 716	com/tencent/qphone/base/util/l:b	([B)[B
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
    //   849: invokestatic 711	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   852: aload 9
    //   854: aload 11
    //   856: invokevirtual 719	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
    //   859: aload 4
    //   861: ifnull +168 -> 1029
    //   864: aload 9
    //   866: invokevirtual 51	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   869: ldc_w 815
    //   872: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   875: ifeq +154 -> 1029
    //   878: invokestatic 116	android/os/SystemClock:elapsedRealtime	()J
    //   881: lstore 6
    //   883: iconst_0
    //   884: lload 6
    //   886: ldc2_w 816
    //   889: lsub
    //   890: lload 6
    //   892: invokestatic 820	com/tencent/mobileqq/msf/core/c/k:a	(ZJJ)B
    //   895: putstatic 822	com/tencent/mobileqq/msf/core/ag:w	I
    //   898: new 824	com/tencent/msf/service/protocol/pb/SSOReserveField$ReserveFields
    //   901: dup
    //   902: invokespecial 825	com/tencent/msf/service/protocol/pb/SSOReserveField$ReserveFields:<init>	()V
    //   905: astore 8
    //   907: aload 8
    //   909: aload 4
    //   911: invokevirtual 826	com/tencent/msf/service/protocol/pb/SSOReserveField$ReserveFields:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   914: pop
    //   915: new 188	java/lang/StringBuilder
    //   918: dup
    //   919: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   922: astore 4
    //   924: aload 4
    //   926: aload 8
    //   928: getfield 830	com/tencent/msf/service/protocol/pb/SSOReserveField$ReserveFields:sso_send	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   931: invokevirtual 834	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   934: invokevirtual 403	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   937: ldc 246
    //   939: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   945: invokevirtual 403	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   948: pop
    //   949: aload 9
    //   951: ldc_w 836
    //   954: aload 4
    //   956: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   959: invokevirtual 109	com/tencent/qphone/base/remote/FromServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   962: pop
    //   963: getstatic 78	com/tencent/mobileqq/msf/core/ag$a:tag	Ljava/lang/String;
    //   966: iconst_1
    //   967: new 188	java/lang/StringBuilder
    //   970: dup
    //   971: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   974: ldc_w 838
    //   977: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: aload 4
    //   982: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   985: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   991: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   994: aload_0
    //   995: getfield 10	com/tencent/mobileqq/msf/core/ag$a:a	Lcom/tencent/mobileqq/msf/core/ag;
    //   998: getfield 126	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1001: getfield 842	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   1004: ifnull +25 -> 1029
    //   1007: aload_0
    //   1008: getfield 10	com/tencent/mobileqq/msf/core/ag$a:a	Lcom/tencent/mobileqq/msf/core/ag;
    //   1011: getfield 126	com/tencent/mobileqq/msf/core/ag:D	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1014: getfield 842	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   1017: ldc_w 844
    //   1020: iconst_1
    //   1021: lconst_0
    //   1022: lconst_0
    //   1023: aconst_null
    //   1024: iconst_0
    //   1025: iconst_0
    //   1026: invokevirtual 593	com/tencent/mobileqq/msf/core/c/k:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   1029: aload 9
    //   1031: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   1034: ifeq +402 -> 1436
    //   1037: aload 9
    //   1039: invokevirtual 51	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   1042: ldc_w 648
    //   1045: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1048: ifeq +388 -> 1436
    //   1051: ldc 206
    //   1053: iconst_1
    //   1054: new 188	java/lang/StringBuilder
    //   1057: dup
    //   1058: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   1061: ldc_w 721
    //   1064: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: aload 9
    //   1069: invokevirtual 167	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   1072: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1075: ldc_w 723
    //   1078: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: aload 9
    //   1083: invokevirtual 51	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   1086: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: ldc_w 657
    //   1092: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: iload_1
    //   1096: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1099: ldc_w 725
    //   1102: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: aload 9
    //   1107: invokevirtual 646	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1110: arraylength
    //   1111: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1114: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1117: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1120: new 727	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData
    //   1123: dup
    //   1124: invokespecial 728	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData:<init>	()V
    //   1127: astore 4
    //   1129: aload 9
    //   1131: invokevirtual 646	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1134: arraylength
    //   1135: iconst_4
    //   1136: isub
    //   1137: newarray byte
    //   1139: astore 8
    //   1141: aload 9
    //   1143: invokevirtual 646	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1146: iconst_4
    //   1147: aload 8
    //   1149: iconst_0
    //   1150: aload 8
    //   1152: arraylength
    //   1153: invokestatic 711	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1156: aload 4
    //   1158: aload 8
    //   1160: invokevirtual 732	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1163: checkcast 727	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData
    //   1166: getfield 736	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffData:BusiBuffVec	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1169: invokevirtual 741	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1172: invokeinterface 744 1 0
    //   1177: astore 4
    //   1179: aload 4
    //   1181: invokeinterface 683 1 0
    //   1186: ifeq -754 -> 432
    //   1189: aload 4
    //   1191: invokeinterface 687 1 0
    //   1196: checkcast 746	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffItem
    //   1199: astore 8
    //   1201: new 47	com/tencent/qphone/base/remote/FromServiceMsg
    //   1204: dup
    //   1205: invokespecial 747	com/tencent/qphone/base/remote/FromServiceMsg:<init>	()V
    //   1208: astore 10
    //   1210: aload 10
    //   1212: aload 8
    //   1214: getfield 751	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffItem:ServiceCmd	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1217: invokevirtual 755	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1220: invokevirtual 759	com/tencent/qphone/base/remote/FromServiceMsg:setServiceCmd	(Ljava/lang/String;)V
    //   1223: aload 10
    //   1225: aload 8
    //   1227: getfield 763	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffItem:SeqNo	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1230: invokevirtual 767	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1233: invokevirtual 142	com/tencent/qphone/base/remote/FromServiceMsg:setRequestSsoSeq	(I)V
    //   1236: aload 10
    //   1238: aload 8
    //   1240: getfield 771	com/tencent/msf/service/protocol/pb/SSOLoginMerge$BusiBuffItem:BusiBuff	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1243: invokevirtual 776	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1246: invokevirtual 781	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1249: invokevirtual 719	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
    //   1252: aload 10
    //   1254: aload 10
    //   1256: invokevirtual 167	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   1259: invokevirtual 313	com/tencent/qphone/base/remote/FromServiceMsg:setAppSeq	(I)V
    //   1262: aload 10
    //   1264: invokevirtual 784	com/tencent/qphone/base/remote/FromServiceMsg:setMsgSuccess	()V
    //   1267: aload 10
    //   1269: aload 9
    //   1271: invokevirtual 152	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   1274: invokevirtual 787	com/tencent/qphone/base/remote/FromServiceMsg:setUin	(Ljava/lang/String;)V
    //   1277: aload 10
    //   1279: aload 10
    //   1281: invokevirtual 646	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1284: invokestatic 788	com/tencent/mobileqq/msf/core/ag:b	([B)[B
    //   1287: invokevirtual 719	com/tencent/qphone/base/remote/FromServiceMsg:putWupBuffer	([B)V
    //   1290: aload_0
    //   1291: aload 10
    //   1293: aload 10
    //   1295: invokevirtual 646	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1298: arraylength
    //   1299: invokespecial 790	com/tencent/mobileqq/msf/core/ag$a:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;I)V
    //   1302: goto -123 -> 1179
    //   1305: astore 4
    //   1307: invokestatic 651	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1310: ifeq +31 -> 1341
    //   1313: getstatic 78	com/tencent/mobileqq/msf/core/ag$a:tag	Ljava/lang/String;
    //   1316: iconst_2
    //   1317: new 188	java/lang/StringBuilder
    //   1320: dup
    //   1321: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   1324: ldc_w 792
    //   1327: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: aload 4
    //   1332: invokevirtual 424	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1335: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1338: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1341: aload 9
    //   1343: invokevirtual 51	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   1346: ldc_w 648
    //   1349: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1352: ifne +13 -> 1365
    //   1355: aload_0
    //   1356: bipush 249
    //   1358: aload 8
    //   1360: arraylength
    //   1361: invokevirtual 794	com/tencent/mobileqq/msf/core/ag$a:onInvalidData	(II)V
    //   1364: return
    //   1365: aload_0
    //   1366: bipush 249
    //   1368: aload 8
    //   1370: arraylength
    //   1371: aload 9
    //   1373: invokevirtual 167	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   1376: invokevirtual 700	com/tencent/mobileqq/msf/core/ag$a:a	(III)V
    //   1379: return
    //   1380: aload 9
    //   1382: invokevirtual 51	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   1385: ldc_w 648
    //   1388: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1391: ifne +13 -> 1404
    //   1394: aload_0
    //   1395: bipush 250
    //   1397: aload 8
    //   1399: arraylength
    //   1400: invokevirtual 794	com/tencent/mobileqq/msf/core/ag$a:onInvalidData	(II)V
    //   1403: return
    //   1404: aload_0
    //   1405: bipush 250
    //   1407: aload 8
    //   1409: arraylength
    //   1410: aload 9
    //   1412: invokevirtual 167	com/tencent/qphone/base/remote/FromServiceMsg:getRequestSsoSeq	()I
    //   1415: invokevirtual 700	com/tencent/mobileqq/msf/core/ag$a:a	(III)V
    //   1418: return
    //   1419: astore 4
    //   1421: getstatic 78	com/tencent/mobileqq/msf/core/ag$a:tag	Ljava/lang/String;
    //   1424: iconst_1
    //   1425: ldc_w 846
    //   1428: aload 4
    //   1430: invokestatic 426	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1433: goto -404 -> 1029
    //   1436: aload 9
    //   1438: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   1441: ifeq +27 -> 1468
    //   1444: aload 9
    //   1446: invokevirtual 51	com/tencent/qphone/base/remote/FromServiceMsg:getServiceCmd	()Ljava/lang/String;
    //   1449: ldc_w 848
    //   1452: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1455: ifeq +13 -> 1468
    //   1458: aload 9
    //   1460: invokevirtual 646	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1463: iconst_1
    //   1464: invokestatic 854	com/tencent/mobileqq/msf/core/net/utils/MsfPullConfigUtil:parseConfigResponse	([BZ)V
    //   1467: return
    //   1468: aload_0
    //   1469: aload 9
    //   1471: iload_3
    //   1472: invokespecial 790	com/tencent/mobileqq/msf/core/ag$a:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;I)V
    //   1475: return
    //   1476: astore 8
    //   1478: aload 10
    //   1480: astore 4
    //   1482: goto -1130 -> 352
    //   1485: goto -1401 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1488	0	this	a
    //   0	1488	1	paramInt1	int
    //   0	1488	2	paramObject	Object
    //   0	1488	3	paramInt2	int
    //   0	1488	4	paramArrayOfByte	byte[]
    //   684	72	5	i	int
    //   881	10	6	l	long
    //   127	211	8	localObject1	Object
    //   346	82	8	localThrowable1	Throwable
    //   659	749	8	localObject2	Object
    //   1476	1	8	localThrowable2	Throwable
    //   42	1428	9	localFromServiceMsg	FromServiceMsg
    //   1	1478	10	localObject3	Object
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
    //   864	1029	346	java/lang/Throwable
    //   1029	1179	346	java/lang/Throwable
    //   1179	1302	346	java/lang/Throwable
    //   1307	1341	346	java/lang/Throwable
    //   1341	1364	346	java/lang/Throwable
    //   1365	1379	346	java/lang/Throwable
    //   1380	1403	346	java/lang/Throwable
    //   1404	1418	346	java/lang/Throwable
    //   1421	1433	346	java/lang/Throwable
    //   1436	1467	346	java/lang/Throwable
    //   1468	1475	346	java/lang/Throwable
    //   740	859	1305	java/lang/Exception
    //   864	1029	1419	java/lang/Exception
    //   7	18	1476	java/lang/Throwable
    //   18	44	1476	java/lang/Throwable
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
    label926:
    label943:
    for (;;)
    {
      ((ByteBuffer)localObject1).position(((ByteBuffer)localObject1).get() + ((ByteBuffer)localObject1).position() - 1);
      i = ((ByteBuffer)localObject1).getInt();
      Object localObject3 = (i >> 24 & 0xFF) + '.' + (i >> 16 & 0xFF) + '.' + (i >> 8 & 0xFF) + '.' + (i & 0xFF);
      if ("GWv4".equals(localObject2))
      {
        ag.O = i;
        if (paramArrayOfByte.length == 50)
        {
          byte[] arrayOfByte = new byte[24];
          ((ByteBuffer)localObject1).get(arrayOfByte, 0, 24);
          ag.N = arrayOfByte;
          if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "MSF.C.CodecWarpper onSSOPingResponse sGwV4Sec:" + ag.N);
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
          break label926;
        }
        l1 = 0L;
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label943;
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
        QLog.d("MSF.C.NetConnTag", 1, "netRecv ssoSeq:" + ((ToServiceMsg)localObject1).getRequestSsoSeq() + " uin:" + MsfSdkUtils.getShortUin(((ToServiceMsg)localObject1).getUin()) + " cmd:" + c.a(paramArrayOfByte) + new StringBuilder().append(" ").append(((ToServiceMsg)localObject1).getRequestSsoSeq() + j).toString());
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
 * Qualified Name:     com.tencent.mobileqq.msf.core.ag.a
 * JD-Core Version:    0.7.0.1
 */