package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.auth.c;
import com.tencent.mobileqq.msf.core.c.e.a;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.net.c.g;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.mobileqq.msf.service.l;
import com.tencent.msf.service.protocol.push.RequestMSFForceOffline;
import com.tencent.msf.service.protocol.security.i;
import com.tencent.msf.service.protocol.security.n;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class ag
{
  public static ConcurrentHashMap a = new ConcurrentHashMap();
  public static final int b = 210;
  public static final int c = -12003;
  public static final int d = -10001;
  public static final int e = -10003;
  public static final int f = -10004;
  public static final int g = -10005;
  public static final int h = -10006;
  public static final int i = -10000;
  public static final int j = -10007;
  public static final int k = -10009;
  public static final int l = -10101;
  public static final int m = -10102;
  public static final int n = -10103;
  public static final int o = -10104;
  public static final int p = -10105;
  public static final int q = -10106;
  static final String r = "OverLoadPush.notify";
  private static final String v = "MSF.C.SSORespHandler";
  private static final int w = 1000;
  MsfCore s;
  long t = -1L;
  long u = -1L;
  private Handler x = new ah(this);
  
  public ag(MsfCore paramMsfCore)
  {
    this.s = paramMsfCore;
  }
  
  public static void a(FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg.setBusinessFail(2002, "verifyCode");
    paramFromServiceMsg.setMsfCommand(MsfCommand.onRecvVerifyCode);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg == null) && (paramFromServiceMsg == null)) {
      QLog.d("MSF.C.SSORespHandler", 1, "handleHttpSsoFailResp msg is empty");
    }
    do
    {
      return;
      if (paramToServiceMsg.getServiceCmd().equals("MessageSvc.QueryPullUp"))
      {
        this.s.pushManager.q().a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
    } while (!paramToServiceMsg.getAttributes().containsKey("attr_quick_send"));
    this.s.quicksender.a(paramToServiceMsg, paramFromServiceMsg, -1);
  }
  
  protected boolean a(int paramInt)
  {
    return (paramInt == -12003) || (paramInt == 210) || (paramInt == -10001) || (paramInt == -10003) || (paramInt == -10004) || (paramInt == -10006) || (paramInt == -10106);
  }
  
  protected boolean a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    int i2 = paramFromServiceMsg.getBusinessFailCode();
    boolean bool2 = a(i2);
    Object localObject1;
    int i1;
    if (-10106 == i2)
    {
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("uin", paramFromServiceMsg.getUin());
      ((HashMap)localObject1).put("time", new Date().toString());
      if (this.s.statReporter != null)
      {
        j localj = this.s.statReporter;
        if (true != bool2) {
          break label431;
        }
        i1 = 1;
        localj.a("dim.Msf.ForceQuitParseFail", true, i1, 0L, (Map)localObject1, false, false);
      }
    }
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (i2 == -10005)
      {
        if (this.t == -1L) {
          this.t = System.currentTimeMillis();
        }
        if (this.s.sender.Z.get()) {
          break label436;
        }
        if (this.s.getAccountCenter().a(paramFromServiceMsg.getUin())) {
          break label1602;
        }
        QLog.d("MSF.C.SSORespHandler", 1, "reload D2 failed");
        this.s.sender.Y = 1;
      }
    }
    label431:
    label436:
    label1602:
    for (bool1 = true;; bool1 = bool2)
    {
      for (;;)
      {
        this.s.sender.Z.set(true);
        label211:
        if (bool1)
        {
          QLog.d("MSF.C.SSORespHandler", 1, Thread.currentThread().getName() + " handleSsoFailCode tokenExpired to setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
          this.s.getAccountCenter().k(paramFromServiceMsg.getUin());
          if ((!l.b()) && ((this.u == -1L) || (System.currentTimeMillis() - this.u > 10000L))) {}
          try
          {
            localObject1 = l.c();
            i1 = this.s.getUinPushStatus(paramFromServiceMsg.getUin());
            l.a(BaseApplication.getContext(), BaseApplication.getContext().getPackageName(), paramFromServiceMsg.getUin(), (String)localObject1, i1, null);
            QLog.d("MSF.C.SSORespHandler", 1, "sendBootAction for mainProcess for " + MD5.toMD5(paramFromServiceMsg.getUin()));
            this.u = System.currentTimeMillis();
            paramFromServiceMsg.setBusinessFail(2001, paramFromServiceMsg.getBusinessFailMsg());
            MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
            this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
            if (this.s.getStatReporter() != null) {
              this.s.getStatReporter().a(0L, i2, 0L);
            }
            return true;
            i1 = 0;
            break;
            if ((paramToServiceMsg != null) && (this.s.sender.Y != -1) && (paramToServiceMsg.getRequestSsoSeq() >= this.s.sender.Y))
            {
              bool2 = true;
              bool1 = bool2;
              if (!QLog.isColorLevel()) {
                break label211;
              }
              QLog.d("MSF.C.SSORespHandler", 2, "set userTokenExpired. afterReloadD2SendSeq is " + this.s.sender.Y);
              bool1 = bool2;
              break label211;
            }
            bool1 = bool2;
            if (this.t == -1L) {
              break label211;
            }
            bool1 = bool2;
            if (System.currentTimeMillis() - this.t <= 60000L) {
              break label211;
            }
            bool2 = true;
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              break label211;
            }
            QLog.d("MSF.C.SSORespHandler", 2, "set userTokenExpired after so long wait. ");
            bool1 = bool2;
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              QLog.d("MSF.C.SSORespHandler", 1, "sendBootAction for mainProcess error " + localException1, localException1);
            }
          }
        }
      }
      if (i2 == -10101)
      {
        QLog.d("MSF.C.SSORespHandler", 1, "handleSsoFailCode, sso pop tips");
        paramFromServiceMsg.setBusinessFail(2011, paramFromServiceMsg.getBusinessFailMsg());
        MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
        this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
        return true;
      }
      if (i2 == -10102)
      {
        QLog.d("MSF.C.SSORespHandler", 1, "handleSsoFailCode, sso suspent");
        this.s.suspend();
        paramFromServiceMsg.setBusinessFail(2009, paramFromServiceMsg.getBusinessFailMsg());
        MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
        this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
        return true;
      }
      if (i2 == -10103)
      {
        QLog.d("MSF.C.SSORespHandler", 1, "handleSsoFailCode, sso expired token");
        this.s.getAccountCenter().k(paramFromServiceMsg.getUin());
        paramFromServiceMsg.setBusinessFail(2012, paramFromServiceMsg.getBusinessFailMsg());
        MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
        this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
        return true;
      }
      if (i2 == -10009)
      {
        paramFromServiceMsg.setBusinessFail(2015, paramFromServiceMsg.getBusinessFailMsg());
        MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
        this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.NetConnTag", 2, Thread.currentThread().getName() + " handleSsoFailCode closeConn ssoInvalidCookie");
        }
        this.s.sender.a(com.tencent.qphone.base.a.m);
        return true;
      }
      if (i2 == -10104)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.SSORespHandler", 2, "get CODE_SSO_FORCEQUIT kill " + BaseApplication.getContext().getPackageName() + ":qq now");
        }
        MsfSdkUtils.killProcess(BaseApplication.getContext(), BaseApplication.getContext().getPackageName());
        return true;
      }
      if (i2 == -10105)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.SSORespHandler", 2, "get CODE_SSO_FORCEQUITSDK kill " + BaseApplication.getContext().getPackageName() + ":msf now");
        }
        MsfSdkUtils.killProcess(BaseApplication.getContext(), BaseApplication.getContext().getPackageName() + ":MSF");
        return true;
      }
      Object localObject2 = null;
      if (paramToServiceMsg != null) {
        localObject2 = (com.tencent.msf.service.protocol.e.d)a.get(paramToServiceMsg.getUin());
      }
      if ((localObject2 != null) && (!paramFromServiceMsg.getServiceCmd().startsWith("login.")) && (!paramToServiceMsg.getServiceCmd().startsWith("wtlogin.login")) && (!paramToServiceMsg.getServiceCmd().equals("GrayUinPro.Check")))
      {
        QLog.d("MSF.C.SSORespHandler", 1, new Object[] { "handleSsoFailCode, not in gray list, ", paramFromServiceMsg.getUin() });
        if (paramToServiceMsg != null) {}
        try
        {
          paramFromServiceMsg.setBusinessFail(2008, new String(((com.tencent.msf.service.protocol.e.d)localObject2).c, "UTF-8"));
          paramFromServiceMsg.addAttribute(paramFromServiceMsg.getServiceCmd(), String.valueOf(((com.tencent.msf.service.protocol.e.d)localObject2).b));
          MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
          this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
          return true;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            paramFromServiceMsg.setBusinessFail(2008, paramToServiceMsg.getUin() + " not in gray list");
          }
        }
      }
      if (paramFromServiceMsg.getServiceCmd().equals("MessageSvc.PushForceOffline")) {
        try
        {
          this.s.pushManager.b(paramFromServiceMsg.getUin());
          paramFromServiceMsg.addAttribute("_attr_sameDevice", Boolean.valueOf(false));
          paramFromServiceMsg.setBusinessFail(2013, paramFromServiceMsg.getBusinessFailMsg());
          MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
          this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
          com.tencent.mobileqq.msf.core.net.a.a.a("kicked");
          return true;
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("MSF.C.SSORespHandler", 2, "handle forceLogout error " + paramFromServiceMsg);
            }
          }
        }
      }
      if (paramFromServiceMsg.getServiceCmd().equals("StatSvc.ReqMSFOffline")) {
        try
        {
          this.s.pushManager.b(paramFromServiceMsg.getUin());
          paramToServiceMsg = new UniPacket(true);
          paramToServiceMsg.setEncodeName("utf-8");
          paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
          paramToServiceMsg = (RequestMSFForceOffline)paramToServiceMsg.getByClass("RequestMSFForceOffline", new RequestMSFForceOffline());
          paramToServiceMsg = new com.tencent.msf.service.protocol.push.b(paramToServiceMsg.lUin, paramToServiceMsg.iSeqno, (byte)0);
          localObject2 = new ToServiceMsg("", paramFromServiceMsg.getUin(), "StatSvc.RspMSFForceOffline");
          ((ToServiceMsg)localObject2).addAttribute("_attr_sameDevice", Boolean.valueOf(false));
          UniPacket localUniPacket = new UniPacket(true);
          localUniPacket.setEncodeName("utf-8");
          localUniPacket.setServantName("StatSvc");
          localUniPacket.setFuncName("RspMSFForceOffline");
          localUniPacket.put("RspMSFForceOffline", paramToServiceMsg);
          ((ToServiceMsg)localObject2).setMsfCommand(MsfCommand._msf_kickedAndCleanTokenResp);
          ((ToServiceMsg)localObject2).setNeedCallback(false);
          ((ToServiceMsg)localObject2).putWupBuffer(localUniPacket.encode());
          ((ToServiceMsg)localObject2).setRequestSsoSeq(MsfCore.getNextSeq());
          ((ToServiceMsg)localObject2).setAppId(this.s.getMsfAppid());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).addAttribute(((ToServiceMsg)localObject2).getServiceCmd(), paramFromServiceMsg);
          this.s.sender.b((ToServiceMsg)localObject2);
          com.tencent.mobileqq.msf.core.net.a.a.a("kicked");
          return true;
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("MSF.C.SSORespHandler", 2, "send offlineResp error " + paramFromServiceMsg);
            }
          }
        }
      }
      return false;
    }
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt)
  {
    if ((paramToServiceMsg == null) && (paramFromServiceMsg == null))
    {
      QLog.d("MSF.C.SSORespHandler", 1, "handleHttpSsoResp msg is empty");
      return false;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("ConfigPushSvc.PushReq"))
    {
      paramToServiceMsg = new UniPacket(true);
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramFromServiceMsg.getUin();
      paramToServiceMsg = (com.tencent.msf.service.protocol.serverconfig.f)paramToServiceMsg.getByClass("PushReq", new com.tencent.msf.service.protocol.serverconfig.f());
      this.s.ssoListManager.a(paramToServiceMsg);
      return false;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("MessageSvc.QueryPullUp"))
    {
      this.s.pushManager.q().a(paramToServiceMsg, paramFromServiceMsg);
      return true;
    }
    if (paramToServiceMsg.getAttributes().containsKey("attr_quick_send"))
    {
      this.s.quicksender.a(paramToServiceMsg, paramFromServiceMsg, paramInt);
      return true;
    }
    return false;
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
      if (com.tencent.mobileqq.msf.core.a.a.x()) {
        paramToServiceMsg.getAttributes().remove("to_predetect_timeoutCallbacker");
      }
      if ((this.s.getMsfAppid() == -1) && (paramToServiceMsg.getAppId() != 100) && (!paramToServiceMsg.getUin().equals("0"))) {
        this.s.setMsfAppid(paramToServiceMsg.getAppId());
      }
      if (paramFromServiceMsg.getBusinessFailCode() == 1000) {}
    }
    label788:
    label841:
    for (;;)
    {
      int i1;
      long l2;
      long l1;
      try
      {
        i1 = paramFromServiceMsg.getBusinessFailCode();
        int i2 = ((Integer)paramToServiceMsg.getAttribute("reqPkgSize", Integer.valueOf(0))).intValue();
        bool = false;
        if (((Boolean)paramToServiceMsg.getAttribute("_tag_senddata_error", Boolean.valueOf(false))).booleanValue()) {
          bool = true;
        }
        l2 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf", Long.valueOf(0L))).longValue() - ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net", Long.valueOf(0L))).longValue();
        if (l2 < 0L) {
          break label2030;
        }
        l1 = l2;
        if (l2 > 2147483647L) {
          break label2030;
        }
        if (this.s.statReporter != null) {
          this.s.statReporter.a(paramToServiceMsg.getServiceCmd(), paramToServiceMsg.getRequestSsoSeq(), l1, i1, paramToServiceMsg.getWupBuffer().length, paramFromServiceMsg.getWupBuffer().length, i2, bool);
        }
      }
      catch (Exception localException1)
      {
        try
        {
          QLog.d("MSF.C.NetConnTag", 1, "recv data in socket adaptor way");
          if (this.s.sender.J != null) {
            this.s.sender.J.b().a(paramFromServiceMsg.getRequestSsoSeq(), false);
          }
          if (paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.PbSyncMsg")) {
            paramFromServiceMsg.addAttribute("infoSync_timestamp", Long.valueOf(SystemClock.elapsedRealtime()));
          }
          if (("LongConn.OffPicUp".equals(paramFromServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equals(paramFromServiceMsg.getServiceCmd())))
          {
            StringBuilder localStringBuilder = new StringBuilder().append("SsoRespHandler handleSsoResp resp:").append(paramFromServiceMsg.getStringForLog()).append(" ToServiceMsg:");
            if (paramToServiceMsg != null)
            {
              bool = true;
              QLog.d("MSF.C.SSORespHandler", 1, bool);
            }
          }
          else if ((paramToServiceMsg != null) && (this.s.quicksender != null))
          {
            this.s.quicksender.a(paramToServiceMsg, paramFromServiceMsg);
          }
          try
          {
            if (!"MessageSvc.PbSendMsg".equals(paramFromServiceMsg.getServiceCmd())) {
              continue;
            }
            aj.a(paramToServiceMsg, paramFromServiceMsg, false);
            com.tencent.mobileqq.a.a.a.a().a(paramToServiceMsg, paramFromServiceMsg, false, 0);
            if (com.tencent.mobileqq.msf.core.a.a.aG()) {
              com.tencent.mobileqq.a.a.d.a(paramToServiceMsg, paramFromServiceMsg);
            }
            if ((paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().startsWith("RegPrxySvc"))) {
              this.s.sender.b(paramFromServiceMsg);
            }
            if ((paramToServiceMsg != null) && (this.s.quicksender != null) && (this.s.quicksender.b(paramToServiceMsg)) && (paramFromServiceMsg.isSuccess())) {
              this.s.quicksender.f.a(paramToServiceMsg, paramFromServiceMsg);
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            continue;
            paramFromServiceMsg.addAttribute("__timestamp_msf2net_boot_sharp_c2s", Integer.valueOf(-1));
            continue;
            if ((!com.tencent.mobileqq.msf.core.a.a.t) || (paramToServiceMsg == null) || (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_RegPush) || (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_queryPush) || (this.s.pushManager == null)) {
              break label788;
            }
            this.s.pushManager.a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
            if ((paramToServiceMsg == null) || (paramToServiceMsg.getAttribute("to_wtlogin_oldcmd") == null)) {
              break label841;
            }
            for (i1 = 1;; i1 = 0)
            {
              if ((!paramFromServiceMsg.getServiceCmd().startsWith("login.")) || (i1 != 0)) {
                break label945;
              }
              if (paramToServiceMsg == null) {
                break;
              }
              this.s.getAccountCenter().f.a(paramToServiceMsg, paramFromServiceMsg);
              return;
            }
            if (((!paramFromServiceMsg.getServiceCmd().equals("login.auth")) && (!paramFromServiceMsg.getServiceCmd().equals("login.chguin"))) || (paramFromServiceMsg.getResultCode() != 1000) || (this.s.getStatReporter() == null)) {
              break label912;
            }
            this.s.getStatReporter().a(paramFromServiceMsg.getServiceCmd().equals("login.chguin"));
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MSF.C.SSORespHandler", 2, "found timeoutResp " + paramFromServiceMsg);
            return;
          }
          if (paramFromServiceMsg.getServiceCmd().startsWith("SharpSvr."))
          {
            l1 = SystemClock.elapsedRealtime();
            if ((af.K > 0L) && (l1 - af.K > 0L) && (l1 - af.K <= 30000L)) {
              paramFromServiceMsg.addAttribute("__timestamp_msf2net_boot_sharp_c2s", Long.valueOf(af.K));
            }
          }
          else
          {
            if (!a(paramFromServiceMsg, paramToServiceMsg)) {
              break label732;
            }
            if ((paramFromServiceMsg.getServiceCmd().startsWith("wtlogin.")) && (paramToServiceMsg != null)) {
              com.tencent.mobileqq.msf.core.auth.m.a(paramToServiceMsg, paramFromServiceMsg);
            }
            return;
            localException1 = localException1;
            QLog.e("MSF.C.SSORespHandler", 1, "reportSendError exception:", localException1);
          }
        }
        catch (Exception localException2)
        {
          QLog.d("MSF.C.SSORespHandler", 1, "adaptor recv failed", localException2);
          continue;
          boolean bool = false;
          continue;
          bool = "RegPrxySvc.NoticeEnd".equals(paramFromServiceMsg.getServiceCmd());
          if (!bool) {
            continue;
          }
          continue;
        }
      }
      label732:
      if (((!af.s) || (!com.tencent.mobileqq.msf.core.net.a.f.a())) || ((paramFromServiceMsg.getServiceCmd().startsWith("wtlogin.")) && (i1 != 0)))
      {
        if (paramToServiceMsg != null)
        {
          com.tencent.mobileqq.msf.core.auth.m.a(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ((paramFromServiceMsg.getServiceCmd().equals("wtlogin.login")) && (paramFromServiceMsg.getResultCode() == 1000) && (this.s.getStatReporter() != null)) {
          this.s.getStatReporter().a(false);
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.SSORespHandler", 2, "found timeoutResp " + paramFromServiceMsg);
        }
      }
      else
      {
        if (paramFromServiceMsg.getServiceCmd().equals("wtlogin.PushChangeToken"))
        {
          this.s.getAccountCenter().g.b();
          return;
        }
        Object localObject;
        if (paramFromServiceMsg.getServiceCmd().equals("OnlinePush.SidTicketExpired"))
        {
          localObject = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
          ((ToServiceMsg)localObject).setRequestSsoSeq(paramFromServiceMsg.getRequestSsoSeq());
          ((ToServiceMsg)localObject).setAppId(this.s.getMsfAppid());
          ((ToServiceMsg)localObject).setNeedCallback(false);
          ((ToServiceMsg)localObject).setTimeout(30000L);
          this.s.sendSsoMsg((ToServiceMsg)localObject);
          localObject = this.x.obtainMessage();
          ((Message)localObject).what = 1000;
          ((Message)localObject).obj = paramFromServiceMsg.getUin();
          if (this.x.hasMessages(1000)) {
            this.x.removeMessages(1000);
          }
          this.x.sendMessageDelayed((Message)localObject, 3000L);
        }
        if (paramFromServiceMsg.getServiceCmd().equals("ConfigPushSvc.PushReq"))
        {
          this.s.ssoListManager.a(paramFromServiceMsg);
          return;
        }
        if (paramFromServiceMsg.getServiceCmd().equals("SSO.HelloPush"))
        {
          this.s.pushManager.d(paramFromServiceMsg);
          return;
        }
        if (paramFromServiceMsg.getServiceCmd().equals("QualityTest.PushList"))
        {
          g.d = this.s;
          g.a(paramFromServiceMsg);
          paramToServiceMsg = new ToServiceMsg("", "0", paramFromServiceMsg.getServiceCmd());
          paramToServiceMsg.setMsfCommand(MsfCommand._msf_QualityTest);
          paramToServiceMsg.setRequestSsoSeq(paramFromServiceMsg.getRequestSsoSeq());
          paramToServiceMsg.setAppId(this.s.getMsfAppid());
          paramToServiceMsg.setNeedCallback(false);
          paramToServiceMsg.setTimeout(30000L);
          this.s.sendSsoMsg(paramToServiceMsg);
          return;
        }
        if (paramFromServiceMsg.getServiceCmd().equals("OnlinePush.PbPushOffMsg"))
        {
          this.s.pushManager.c(paramFromServiceMsg);
          return;
        }
        if (paramFromServiceMsg.getServiceCmd().equals("OnlinePush.PushOffReadedNotify"))
        {
          this.s.pushManager.b(paramFromServiceMsg);
          return;
        }
        if (paramFromServiceMsg.getServiceCmd().equals("MessageSvc.PullUnreadMsgCount"))
        {
          this.s.pushManager.a(paramFromServiceMsg, paramToServiceMsg);
          return;
        }
        if ((paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.infoLogin")) || (paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.PbSyncMsg"))) {
          this.s.mbIsInfoLoginGetted.set(true);
        }
        if ((paramToServiceMsg != null) && (paramFromServiceMsg.getServiceCmd().equals("ConfigService.ClientReq")))
        {
          if (paramToServiceMsg.getMsfCommand() == MsfCommand._msf_getConfig)
          {
            this.s.configManager.a(paramFromServiceMsg, paramToServiceMsg);
            return;
          }
          this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (paramFromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))
        {
          localObject = new ToServiceMsg("", paramFromServiceMsg.getUin(), "SharpSvr.s2cackMSF");
          ((ToServiceMsg)localObject).setAppId(this.s.getMsfAppid());
          ((ToServiceMsg)localObject).setRequestSsoSeq(paramFromServiceMsg.getRequestSsoSeq());
          ((ToServiceMsg)localObject).setNeedCallback(false);
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).putWupBuffer(paramFromServiceMsg.getWupBuffer());
          this.s.sender.b((ToServiceMsg)localObject);
          if (paramToServiceMsg != null) {
            break label1672;
          }
          com.tencent.mobileqq.msf.core.c.e.a().a(e.a.b, paramFromServiceMsg.getWupBuffer(), 0);
        }
        while ((paramFromServiceMsg.getServiceCmd().equals("QQWifiSvc.AvailQQWiFiForMSF")) && (paramToServiceMsg != null) && (((Boolean)paramToServiceMsg.getAttribute("isformsf", Boolean.valueOf(false))).booleanValue()))
        {
          x.a().a(paramToServiceMsg, paramFromServiceMsg);
          return;
          com.tencent.mobileqq.msf.core.c.e.a().a(e.a.b, paramFromServiceMsg.getWupBuffer(), 2);
        }
        if (paramToServiceMsg == null)
        {
          if (paramFromServiceMsg.getServiceCmd().equals("OverLoadPush.notify"))
          {
            this.s.configManager.a(paramFromServiceMsg);
            return;
          }
          this.s.pushManager.a(paramFromServiceMsg);
          return;
        }
        switch (ai.a[paramToServiceMsg.getMsfCommand().ordinal()])
        {
        default: 
          paramFromServiceMsg.setAppId(paramToServiceMsg.getAppId());
          paramFromServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
          paramFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
          this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
          return;
        case 1: 
          this.s.pushManager.a(paramToServiceMsg, paramFromServiceMsg);
          return;
        case 2: 
          this.s.pushManager.a(paramToServiceMsg, paramFromServiceMsg);
          return;
        case 3: 
          this.s.pushManager.b(paramToServiceMsg, paramFromServiceMsg);
          return;
        case 4: 
          this.s.sender.a(paramFromServiceMsg);
          return;
        case 5: 
          this.s.getAccountCenter().c.a(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        l2 = System.currentTimeMillis() / 1000L;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.SSORespHandler", 2, "CorrectTime get current time:" + l2);
        }
        l1 = l2;
        try
        {
          if (paramFromServiceMsg.isSuccess())
          {
            i1 = MsfSdkUtils.convertBytes2Int(paramFromServiceMsg.getWupBuffer(), 4);
            l1 = i1;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          for (;;)
          {
            l1 = l2;
            if (QLog.isDevelopLevel())
            {
              QLog.d("MSF.C.SSORespHandler", 4, "handle serverTime error " + paramToServiceMsg);
              l1 = l2;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.SSORespHandler", 2, "CorrectTime get server time:" + l1);
        }
        NetConnInfoCenter.handleGetServerTimeResp(l1);
        return;
        label2030:
        l1 = 0L;
      }
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(paramFromServiceMsg);
    Object localObject = new UniPacket(true);
    ((UniPacket)localObject).setEncodeName("UTF-8");
    ((UniPacket)localObject).decode(paramFromServiceMsg.getWupBuffer());
    paramToServiceMsg = (com.tencent.msf.service.protocol.security.k)((UniPacket)localObject).getByClass("RespondHeader", new com.tencent.msf.service.protocol.security.k());
    VerifyCodeInfo localVerifyCodeInfo = new VerifyCodeInfo();
    localVerifyCodeInfo.ssoSeq = paramFromServiceMsg.getRequestSsoSeq();
    localVerifyCodeInfo.wupSeq = paramToServiceMsg.c;
    switch (paramToServiceMsg.b)
    {
    }
    for (;;)
    {
      VerifyCodeInfo.putVerifyCodeInfo(paramFromServiceMsg, localVerifyCodeInfo);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.SSORespHandler", 2, "rece businessVerifyCode from:" + paramFromServiceMsg + " svrseqNo:" + localVerifyCodeInfo.svrSeqNo + " vipsid:" + localVerifyCodeInfo.vpicSid + " wupSeq:" + localVerifyCodeInfo.wupSeq);
      }
      return;
      localObject = (i)((UniPacket)localObject).getByClass("RespondAuth", new i());
      localVerifyCodeInfo.vpicSid = ((i)localObject).c;
      localVerifyCodeInfo.svrSeqNo = paramToServiceMsg.e;
      localVerifyCodeInfo.verifyimage = ((i)localObject).a;
      localVerifyCodeInfo.verifyNote = ((i)localObject).b;
      continue;
      localObject = (n)((UniPacket)localObject).getByClass("RespondVerifyPic", new n());
      localVerifyCodeInfo.vpicSid = ((n)localObject).b;
      localVerifyCodeInfo.svrSeqNo = paramToServiceMsg.e;
      localVerifyCodeInfo.verifyimage = ((n)localObject).a;
      localVerifyCodeInfo.verifyNote = "";
      continue;
      localObject = (com.tencent.msf.service.protocol.security.m)((UniPacket)localObject).getByClass("RespondRefreshVPic", new com.tencent.msf.service.protocol.security.m());
      localVerifyCodeInfo.vpicSid = ((com.tencent.msf.service.protocol.security.m)localObject).c;
      localVerifyCodeInfo.svrSeqNo = paramToServiceMsg.e;
      localVerifyCodeInfo.verifyimage = ((com.tencent.msf.service.protocol.security.m)localObject).a;
      localVerifyCodeInfo.verifyNote = ((com.tencent.msf.service.protocol.security.m)localObject).b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ag
 * JD-Core Version:    0.7.0.1
 */