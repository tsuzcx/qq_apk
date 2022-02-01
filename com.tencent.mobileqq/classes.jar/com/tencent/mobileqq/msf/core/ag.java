package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.d.e.a;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.core.push.g;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.mobileqq.msf.service.u;
import com.tencent.msf.service.protocol.push.RequestMSFForceOffline;
import com.tencent.msf.service.protocol.security.i;
import com.tencent.msf.service.protocol.security.m;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
  private static final int y = 1000000;
  MsfCore s;
  long t = -1L;
  long u = -1L;
  private Handler x = new ah(this);
  private final Random z = new Random();
  
  public ag(MsfCore paramMsfCore)
  {
    this.s = paramMsfCore;
  }
  
  public static void a(FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg.setBusinessFail(2002, "verifyCode");
    paramFromServiceMsg.setMsfCommand(MsfCommand.onRecvVerifyCode);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (this.z.nextInt(1000000) == 0) && (this.s.statReporter != null))
    {
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("resultCode", String.valueOf(paramFromServiceMsg.getResultCode()));
      this.s.statReporter.a("EvtSendSSO", paramFromServiceMsg.isSuccess(), 0L, 0L, paramToServiceMsg, true, false);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg == null) && (paramFromServiceMsg == null))
    {
      QLog.d("MSF.C.SSORespHandler", 1, "handleHttpSsoFailResp msg is empty");
      return;
    }
    if (paramToServiceMsg.getServiceCmd().equals("MessageSvc.QueryPullUp"))
    {
      this.s.pushManager.q().a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (paramToServiceMsg.getAttributes().containsKey("attr_quick_send")) {
      this.s.quicksender.a(paramToServiceMsg, paramFromServiceMsg, -1);
    }
  }
  
  protected boolean a(int paramInt)
  {
    return (paramInt == -12003) || (paramInt == 210) || (paramInt == -10001) || (paramInt == -10003) || (paramInt == -10004) || (paramInt == -10006) || (paramInt == -10106);
  }
  
  protected boolean a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg)
  {
    int i2 = paramFromServiceMsg.getBusinessFailCode();
    boolean bool2 = a(i2);
    Object localObject3 = Boolean.valueOf(false);
    Object localObject1;
    if (-10106 == i2)
    {
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("uin", paramFromServiceMsg.getUin());
    }
    try
    {
      ((HashMap)localObject1).put("time", new Date().toString());
      label67:
      int i1;
      if (this.s.statReporter != null)
      {
        j localj = this.s.statReporter;
        if (true == bool2) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        localj.a("dim_Msf_ForceQuitParseFail", true, i1, 0L, (Map)localObject1, false, false);
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
          if (!this.s.sender.ab.get())
          {
            bool1 = bool2;
            if (!this.s.getAccountCenter().a(paramFromServiceMsg.getUin()))
            {
              QLog.d("MSF.C.SSORespHandler", 1, "reload D2 failed");
              this.s.sender.aa = 1;
              bool1 = true;
            }
            this.s.sender.ab.set(true);
          }
          else
          {
            if ((paramToServiceMsg != null) && (this.s.sender.aa != -1) && (paramToServiceMsg.getRequestSsoSeq() >= this.s.sender.aa))
            {
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("set userTokenExpired. afterReloadD2SendSeq is ");
                ((StringBuilder)localObject1).append(this.s.sender.aa);
                QLog.d("MSF.C.SSORespHandler", 2, ((StringBuilder)localObject1).toString());
              }
            }
            else
            {
              bool1 = bool2;
              if (this.t == -1L) {
                break label374;
              }
              bool1 = bool2;
              if (System.currentTimeMillis() - this.t <= 60000L) {
                break label374;
              }
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.SSORespHandler", 2, "set userTokenExpired after so long wait. ");
              }
            }
            bool1 = true;
          }
        }
      }
      label374:
      if (bool1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Thread.currentThread().getName());
        ((StringBuilder)localObject1).append(" handleSsoFailCode tokenExpired to setAccountNoLogin uin=");
        ((StringBuilder)localObject1).append(MsfSdkUtils.getShortUin(paramFromServiceMsg.getUin()));
        QLog.d("MSF.C.SSORespHandler", 1, ((StringBuilder)localObject1).toString());
        this.s.getAccountCenter().k(paramFromServiceMsg.getUin());
        if ((!u.b()) && ((this.u == -1L) || (System.currentTimeMillis() - this.u > 10000L))) {
          try
          {
            localObject1 = u.c();
            i1 = this.s.getUinPushStatus(paramFromServiceMsg.getUin());
            u.a(BaseApplication.getContext(), BaseApplication.getContext().getPackageName(), paramFromServiceMsg.getUin(), (String)localObject1, i1, null);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("sendBootAction for mainProcess for ");
            ((StringBuilder)localObject1).append(MD5.toMD5(paramFromServiceMsg.getUin()));
            QLog.d("MSF.C.SSORespHandler", 1, ((StringBuilder)localObject1).toString());
            this.u = System.currentTimeMillis();
          }
          catch (Exception localException1)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("sendBootAction for mainProcess error ");
            ((StringBuilder)localObject3).append(localException1);
            QLog.d("MSF.C.SSORespHandler", 1, ((StringBuilder)localObject3).toString(), localException1);
          }
        }
        paramFromServiceMsg.setBusinessFail(2001, paramFromServiceMsg.getBusinessFailMsg());
        MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
        this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
        if (this.s.getStatReporter() != null) {
          this.s.getStatReporter().a(0L, i2, 0L);
        }
        return true;
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
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append(Thread.currentThread().getName());
          paramFromServiceMsg.append(" handleSsoFailCode closeConn ssoInvalidCookie");
          QLog.d("MSF.C.NetConnTag", 2, paramFromServiceMsg.toString());
        }
        this.s.sender.a(com.tencent.qphone.base.a.m);
        return true;
      }
      if (i2 == -10104)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("get CODE_SSO_FORCEQUIT kill ");
          paramFromServiceMsg.append(BaseApplication.getContext().getPackageName());
          paramFromServiceMsg.append(":qq now");
          QLog.d("MSF.C.SSORespHandler", 2, paramFromServiceMsg.toString());
        }
        MsfSdkUtils.killProcess(BaseApplication.getContext(), BaseApplication.getContext().getPackageName());
        return true;
      }
      if (i2 == -10105)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("get CODE_SSO_FORCEQUITSDK kill ");
          paramFromServiceMsg.append(BaseApplication.getContext().getPackageName());
          paramFromServiceMsg.append(":msf now");
          QLog.d("MSF.C.SSORespHandler", 2, paramFromServiceMsg.toString());
        }
        paramFromServiceMsg = BaseApplication.getContext();
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append(BaseApplication.getContext().getPackageName());
        paramToServiceMsg.append(":MSF");
        MsfSdkUtils.killProcess(paramFromServiceMsg, paramToServiceMsg.toString());
        return true;
      }
      Object localObject2 = null;
      if (paramToServiceMsg != null) {
        localObject2 = (com.tencent.msf.service.protocol.e.d)a.get(paramToServiceMsg.getUin());
      }
      if ((localObject2 != null) && (!paramFromServiceMsg.getServiceCmd().startsWith("login.")) && (!paramToServiceMsg.getServiceCmd().startsWith("wtlogin.login")) && (!paramToServiceMsg.getServiceCmd().equals("GrayUinPro.Check")))
      {
        QLog.d("MSF.C.SSORespHandler", 1, new Object[] { "handleSsoFailCode, not in gray list, ", paramFromServiceMsg.getUin() });
        if (paramToServiceMsg == null) {}
      }
      try
      {
        paramFromServiceMsg.setBusinessFail(2008, new String(((com.tencent.msf.service.protocol.e.d)localObject2).c, "UTF-8"));
      }
      catch (Exception localException2)
      {
        label1208:
        break label1208;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramToServiceMsg.getUin());
      ((StringBuilder)localObject3).append(" not in gray list");
      paramFromServiceMsg.setBusinessFail(2008, ((StringBuilder)localObject3).toString());
      paramFromServiceMsg.addAttribute(paramFromServiceMsg.getServiceCmd(), String.valueOf(((com.tencent.msf.service.protocol.e.d)localObject2).b));
      MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
      this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
      return true;
      if (paramFromServiceMsg.getServiceCmd().equals("MessageSvc.PushForceOffline")) {
        try
        {
          this.s.pushManager.c(paramFromServiceMsg.getUin());
          paramFromServiceMsg.addAttribute("_attr_sameDevice", localObject3);
          paramFromServiceMsg.setBusinessFail(2013, paramFromServiceMsg.getBusinessFailMsg());
          MsfSdkUtils.addFromMsgProcessName("*", paramFromServiceMsg);
          this.s.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
          com.tencent.mobileqq.msf.core.net.a.a.a("kicked");
          return true;
        }
        catch (Exception paramFromServiceMsg)
        {
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("handle forceLogout error ");
            paramToServiceMsg.append(paramFromServiceMsg);
            QLog.e("MSF.C.SSORespHandler", 2, paramToServiceMsg.toString());
          }
          return true;
        }
      }
      if (paramFromServiceMsg.getServiceCmd().equals("StatSvc.ReqMSFOffline"))
      {
        try
        {
          this.s.pushManager.c(paramFromServiceMsg.getUin());
          paramToServiceMsg = new UniPacket(true);
          paramToServiceMsg.setEncodeName("utf-8");
          paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
          paramToServiceMsg = (RequestMSFForceOffline)paramToServiceMsg.getByClass("RequestMSFForceOffline", new RequestMSFForceOffline());
          long l1 = paramToServiceMsg.lUin;
          try
          {
            paramToServiceMsg = new com.tencent.msf.service.protocol.push.b(l1, paramToServiceMsg.iSeqno, (byte)0);
            localObject2 = new ToServiceMsg("", paramFromServiceMsg.getUin(), "StatSvc.RspMSFForceOffline");
            ((ToServiceMsg)localObject2).addAttribute("_attr_sameDevice", localObject3);
            localObject3 = new UniPacket(true);
            ((UniPacket)localObject3).setEncodeName("utf-8");
            ((UniPacket)localObject3).setServantName("StatSvc");
            ((UniPacket)localObject3).setFuncName("RspMSFForceOffline");
            ((UniPacket)localObject3).put("RspMSFForceOffline", paramToServiceMsg);
            ((ToServiceMsg)localObject2).setMsfCommand(MsfCommand._msf_kickedAndCleanTokenResp);
            ((ToServiceMsg)localObject2).setNeedCallback(false);
            ((ToServiceMsg)localObject2).putWupBuffer(((UniPacket)localObject3).encode());
            ((ToServiceMsg)localObject2).setRequestSsoSeq(MsfCore.getNextSeq());
            ((ToServiceMsg)localObject2).setAppId(this.s.getMsfAppid());
            ((ToServiceMsg)localObject2).setTimeout(30000L);
            ((ToServiceMsg)localObject2).addAttribute(((ToServiceMsg)localObject2).getServiceCmd(), paramFromServiceMsg);
            this.s.sender.b((ToServiceMsg)localObject2);
            com.tencent.mobileqq.msf.core.net.a.a.a("kicked");
            return true;
          }
          catch (Exception paramFromServiceMsg) {}
          if (!QLog.isColorLevel()) {
            break label1689;
          }
        }
        catch (Exception paramFromServiceMsg) {}
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("send offlineResp error ");
        paramToServiceMsg.append(paramFromServiceMsg);
        QLog.e("MSF.C.SSORespHandler", 2, paramToServiceMsg.toString());
        label1689:
        return true;
      }
      return false;
    }
    catch (AssertionError localAssertionError)
    {
      break label67;
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
    Object localObject1 = Long.valueOf(0L);
    Boolean localBoolean = Boolean.valueOf(false);
    int i1;
    boolean bool;
    long l1;
    long l2;
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.getAttributes().remove("to_timeoutCallbacker");
      if (com.tencent.mobileqq.msf.core.a.a.x()) {
        paramToServiceMsg.getAttributes().remove("to_predetect_timeoutCallbacker");
      }
      if ((this.s.getMsfAppid() == -1) && (paramToServiceMsg.getAppId() != 100) && (!paramToServiceMsg.getUin().equals("0"))) {
        this.s.setMsfAppid(paramToServiceMsg.getAppId());
      }
      if (paramFromServiceMsg.getBusinessFailCode() != 1000)
      {
        int i2;
        try
        {
          i1 = paramFromServiceMsg.getBusinessFailCode();
          i2 = ((Integer)paramToServiceMsg.getAttribute("reqPkgSize", Integer.valueOf(0))).intValue();
          bool = ((Boolean)paramToServiceMsg.getAttribute("_tag_senddata_error", localBoolean)).booleanValue();
          l1 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf", localObject1)).longValue() - ((Long)paramToServiceMsg.getAttribute("__timestamp_msf2net", localObject1)).longValue();
          if (l1 < 0L) {
            break label2177;
          }
          if (l1 <= 2147483647L) {
            break label2174;
          }
        }
        catch (Exception localException2) {}
        if (this.s.statReporter != null)
        {
          localObject1 = this.s.statReporter;
          String str = paramToServiceMsg.getServiceCmd();
          int i3 = paramToServiceMsg.getRequestSsoSeq();
          l2 = paramToServiceMsg.getWupBuffer().length;
          int i4 = paramFromServiceMsg.getWupBuffer().length;
          long l3 = i4;
          long l4 = i2;
          try
          {
            ((j)localObject1).a(str, i3, l1, i1, l2, l3, l4, bool);
          }
          catch (Exception localException1) {}
          QLog.e("MSF.C.SSORespHandler", 1, "reportSendError exception:", localException2);
        }
      }
    }
    if ((ad.s) && (com.tencent.mobileqq.msf.core.net.a.f.a())) {
      try
      {
        QLog.d("MSF.C.NetConnTag", 1, "recv data in socket adaptor way");
        if (this.s.sender.I != null) {
          this.s.sender.I.b().a(paramFromServiceMsg.getRequestSsoSeq(), false);
        }
      }
      catch (Exception localException3)
      {
        QLog.d("MSF.C.SSORespHandler", 1, "adaptor recv failed", localException3);
      }
    }
    if (paramFromServiceMsg.getServiceCmd().equals("RegPrxySvc.PbSyncMsg")) {
      paramFromServiceMsg.addAttribute("infoSync_timestamp", Long.valueOf(SystemClock.elapsedRealtime()));
    }
    Object localObject2;
    if (("LongConn.OffPicUp".equals(paramFromServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equals(paramFromServiceMsg.getServiceCmd())))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("SsoRespHandler handleSsoResp resp:");
      ((StringBuilder)localObject2).append(paramFromServiceMsg.getStringForLog());
      ((StringBuilder)localObject2).append(" ToServiceMsg:");
      if (paramToServiceMsg != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject2).append(bool);
      QLog.d("MSF.C.SSORespHandler", 1, ((StringBuilder)localObject2).toString());
    }
    if ((paramToServiceMsg != null) && (this.s.quicksender != null)) {
      this.s.quicksender.a(paramToServiceMsg, paramFromServiceMsg);
    }
    for (;;)
    {
      try
      {
        if ("MessageSvc.PbSendMsg".equals(paramFromServiceMsg.getServiceCmd()))
        {
          aj.a(paramToServiceMsg, paramFromServiceMsg, false);
          com.tencent.mobileqq.a.a.a.a().a(paramToServiceMsg, paramFromServiceMsg, false, 0);
          if (com.tencent.mobileqq.msf.core.a.a.aH()) {
            com.tencent.mobileqq.a.a.d.a(paramToServiceMsg, paramFromServiceMsg);
          }
        }
        else
        {
          "RegPrxySvc.NoticeEnd".equals(paramFromServiceMsg.getServiceCmd());
        }
        if ((paramFromServiceMsg.getServiceCmd() != null) && (paramFromServiceMsg.getServiceCmd().startsWith("RegPrxySvc"))) {
          this.s.sender.b(paramFromServiceMsg);
        }
        if (("RegPrxySvc.infoSync".equals(paramFromServiceMsg.getServiceCmd())) && (this.s.getStatReporter() != null))
        {
          localObject2 = this.s.getStatReporter();
          if (paramFromServiceMsg.getBusinessFailCode() != 1000) {
            break label2183;
          }
          bool = true;
          ((j)localObject2).c(bool);
        }
        if ((paramToServiceMsg != null) && (this.s.quicksender != null) && (this.s.quicksender.d(paramToServiceMsg)) && (paramFromServiceMsg.isSuccess())) {
          this.s.quicksender.f.a(paramToServiceMsg, paramFromServiceMsg);
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      if (paramFromServiceMsg.getServiceCmd().startsWith("SharpSvr."))
      {
        l1 = SystemClock.elapsedRealtime();
        if ((ad.J > 0L) && (l1 - ad.J > 0L) && (l1 - ad.J <= 30000L)) {
          paramFromServiceMsg.addAttribute("__timestamp_msf2net_boot_sharp_c2s", Long.valueOf(ad.J));
        } else {
          paramFromServiceMsg.addAttribute("__timestamp_msf2net_boot_sharp_c2s", Integer.valueOf(-1));
        }
      }
      if (a(paramFromServiceMsg, paramToServiceMsg))
      {
        if ((paramFromServiceMsg.getServiceCmd().startsWith("wtlogin.")) && (paramToServiceMsg != null)) {
          com.tencent.mobileqq.msf.core.auth.n.a(paramToServiceMsg, paramFromServiceMsg);
        }
        d(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ((com.tencent.mobileqq.msf.core.a.a.u) && (paramToServiceMsg != null) && (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_RegPush) && (paramToServiceMsg.getMsfCommand() != MsfCommand._msf_queryPush) && (this.s.pushManager != null)) {
        this.s.pushManager.a(System.currentTimeMillis(), SystemClock.elapsedRealtime());
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.getAttribute("to_wtlogin_oldcmd") != null)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((paramFromServiceMsg.getServiceCmd().startsWith("login.")) && (i1 == 0))
      {
        if (paramToServiceMsg != null)
        {
          this.s.getAccountCenter().f.a(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if (((paramFromServiceMsg.getServiceCmd().equals("login.auth")) || (paramFromServiceMsg.getServiceCmd().equals("login.chguin"))) && (paramFromServiceMsg.getResultCode() == 1000) && (this.s.getStatReporter() != null)) {
          this.s.getStatReporter().a(paramFromServiceMsg.getServiceCmd().equals("login.chguin"));
        }
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("found timeoutResp ");
          paramToServiceMsg.append(paramFromServiceMsg);
          QLog.d("MSF.C.SSORespHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ((paramFromServiceMsg.getServiceCmd().startsWith("wtlogin.")) && (i1 != 0))
      {
        if (paramToServiceMsg != null)
        {
          com.tencent.mobileqq.msf.core.auth.n.a(paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        if ((paramFromServiceMsg.getServiceCmd().equals("wtlogin.login")) && (paramFromServiceMsg.getResultCode() == 1000) && (this.s.getStatReporter() != null)) {
          this.s.getStatReporter().a(false);
        }
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("found timeoutResp ");
          paramToServiceMsg.append(paramFromServiceMsg);
          QLog.d("MSF.C.SSORespHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("wtlogin.PushChangeToken"))
      {
        this.s.getAccountCenter().g.b();
        return;
      }
      Object localObject3;
      if (paramFromServiceMsg.getServiceCmd().equals("OnlinePush.SidTicketExpired"))
      {
        localObject3 = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
        ((ToServiceMsg)localObject3).setRequestSsoSeq(paramFromServiceMsg.getRequestSsoSeq());
        ((ToServiceMsg)localObject3).setAppId(this.s.getMsfAppid());
        ((ToServiceMsg)localObject3).setNeedCallback(false);
        ((ToServiceMsg)localObject3).setTimeout(30000L);
        this.s.sendSsoMsg((ToServiceMsg)localObject3);
        localObject3 = this.x.obtainMessage();
        ((Message)localObject3).what = 1000;
        ((Message)localObject3).obj = paramFromServiceMsg.getUin();
        if (this.x.hasMessages(1000)) {
          this.x.removeMessages(1000);
        }
        this.x.sendMessageDelayed((Message)localObject3, 3000L);
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
        com.tencent.mobileqq.msf.core.net.c.k.d = this.s;
        com.tencent.mobileqq.msf.core.net.c.k.a(paramFromServiceMsg);
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
      if ((paramToServiceMsg != null) && ((paramFromServiceMsg.getServiceCmd().equals("ConfigService.ClientReq")) || (paramFromServiceMsg.getServiceCmd().equals("ResourceConfig.ClientReq"))))
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
        localObject3 = new ToServiceMsg("", paramFromServiceMsg.getUin(), "SharpSvr.s2cackMSF");
        ((ToServiceMsg)localObject3).setAppId(this.s.getMsfAppid());
        ((ToServiceMsg)localObject3).setRequestSsoSeq(paramFromServiceMsg.getRequestSsoSeq());
        ((ToServiceMsg)localObject3).setNeedCallback(false);
        ((ToServiceMsg)localObject3).setTimeout(30000L);
        ((ToServiceMsg)localObject3).putWupBuffer(paramFromServiceMsg.getWupBuffer());
        this.s.sender.b((ToServiceMsg)localObject3);
        if (paramToServiceMsg == null) {
          com.tencent.mobileqq.msf.core.d.e.a().a(e.a.b, paramFromServiceMsg.getWupBuffer(), 0);
        } else {
          com.tencent.mobileqq.msf.core.d.e.a().a(e.a.b, paramFromServiceMsg.getWupBuffer(), 2);
        }
      }
      if ((paramFromServiceMsg.getServiceCmd().equals("QQWifiSvc.AvailQQWiFiForMSF")) && (paramToServiceMsg != null) && (((Boolean)paramToServiceMsg.getAttribute("isformsf", localBoolean)).booleanValue()))
      {
        v.a().a(paramToServiceMsg, paramFromServiceMsg);
        return;
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
        d(paramToServiceMsg, paramFromServiceMsg);
        return;
      case 6: 
        l2 = System.currentTimeMillis() / 1000L;
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("CorrectTime get current time:");
          paramToServiceMsg.append(l2);
          QLog.d("MSF.C.SSORespHandler", 2, paramToServiceMsg.toString());
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
          l1 = l2;
          if (QLog.isDevelopLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handle serverTime error ");
            paramFromServiceMsg.append(paramToServiceMsg);
            QLog.d("MSF.C.SSORespHandler", 4, paramFromServiceMsg.toString());
            l1 = l2;
          }
        }
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("CorrectTime get server time:");
          paramToServiceMsg.append(l1);
          QLog.d("MSF.C.SSORespHandler", 2, paramToServiceMsg.toString());
        }
        NetConnInfoCenter.handleGetServerTimeResp(l1);
        return;
      case 5: 
        this.s.getAccountCenter().c.a(paramToServiceMsg, paramFromServiceMsg);
        return;
      case 4: 
        this.s.sender.a(paramFromServiceMsg);
        return;
      case 3: 
        this.s.pushManager.b(paramToServiceMsg, paramFromServiceMsg);
        return;
      case 2: 
        this.s.pushManager.a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      this.s.pushManager.a(paramToServiceMsg, paramFromServiceMsg);
      return;
      label2174:
      break;
      label2177:
      l1 = 0L;
      break;
      label2183:
      bool = false;
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(paramFromServiceMsg);
    Object localObject2 = new UniPacket(true);
    ((UniPacket)localObject2).setEncodeName("UTF-8");
    ((UniPacket)localObject2).decode(paramFromServiceMsg.getWupBuffer());
    Object localObject1 = (com.tencent.msf.service.protocol.security.k)((UniPacket)localObject2).getByClass("RespondHeader", new com.tencent.msf.service.protocol.security.k());
    paramToServiceMsg = new VerifyCodeInfo();
    paramToServiceMsg.ssoSeq = paramFromServiceMsg.getRequestSsoSeq();
    paramToServiceMsg.wupSeq = ((com.tencent.msf.service.protocol.security.k)localObject1).c;
    int i1 = ((com.tencent.msf.service.protocol.security.k)localObject1).b;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 == 2)
        {
          localObject2 = (m)((UniPacket)localObject2).getByClass("RespondRefreshVPic", new m());
          paramToServiceMsg.vpicSid = ((m)localObject2).c;
          paramToServiceMsg.svrSeqNo = ((com.tencent.msf.service.protocol.security.k)localObject1).e;
          paramToServiceMsg.verifyimage = ((m)localObject2).a;
          paramToServiceMsg.verifyNote = ((m)localObject2).b;
        }
      }
      else
      {
        localObject2 = (com.tencent.msf.service.protocol.security.n)((UniPacket)localObject2).getByClass("RespondVerifyPic", new com.tencent.msf.service.protocol.security.n());
        paramToServiceMsg.vpicSid = ((com.tencent.msf.service.protocol.security.n)localObject2).b;
        paramToServiceMsg.svrSeqNo = ((com.tencent.msf.service.protocol.security.k)localObject1).e;
        paramToServiceMsg.verifyimage = ((com.tencent.msf.service.protocol.security.n)localObject2).a;
        paramToServiceMsg.verifyNote = "";
      }
    }
    else
    {
      localObject2 = (i)((UniPacket)localObject2).getByClass("RespondAuth", new i());
      paramToServiceMsg.vpicSid = ((i)localObject2).c;
      paramToServiceMsg.svrSeqNo = ((com.tencent.msf.service.protocol.security.k)localObject1).e;
      paramToServiceMsg.verifyimage = ((i)localObject2).a;
      paramToServiceMsg.verifyNote = ((i)localObject2).b;
    }
    VerifyCodeInfo.putVerifyCodeInfo(paramFromServiceMsg, paramToServiceMsg);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("rece businessVerifyCode from:");
      ((StringBuilder)localObject1).append(paramFromServiceMsg);
      ((StringBuilder)localObject1).append(" svrseqNo:");
      ((StringBuilder)localObject1).append(paramToServiceMsg.svrSeqNo);
      ((StringBuilder)localObject1).append(" vipsid:");
      ((StringBuilder)localObject1).append(paramToServiceMsg.vpicSid);
      ((StringBuilder)localObject1).append(" wupSeq:");
      ((StringBuilder)localObject1).append(paramToServiceMsg.wupSeq);
      QLog.d("MSF.C.SSORespHandler", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ag
 * JD-Core Version:    0.7.0.1
 */