package com.tencent.mobileqq.msf.core.auth;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.q;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.security.RequestCustomSig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.util;

public class l
{
  static final String a = "MSF.C.WTLoginCenter";
  public static final long b = 16L;
  public static final HashSet c = new HashSet();
  public static MsfCore d;
  public static WtloginHelper e;
  public static final byte f = 1;
  private static final String g = "_wtlastchecklocaltokentime_";
  private static final int h = 43200000;
  private static final long i = 9L;
  private static final long j = 8L;
  private final int k = 100;
  
  private int a(ToServiceMsg paramToServiceMsg, boolean paramBoolean1, a parama, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        p localp = n.a(d, paramToServiceMsg);
        long[] arrayOfLong = new long[0];
        if (com.tencent.mobileqq.msf.core.a.a.aY())
        {
          arrayOfLong = new long[1];
          arrayOfLong[0] = 1600000226L;
        }
        long l1 = 16L;
        long l2 = paramToServiceMsg.getAppId();
        if (paramToServiceMsg.getServiceCmd().equals("login.chgTok_A2D2"))
        {
          n = 262208;
          m = 1;
          n |= 0x2000000;
          if ((!com.tencent.mobileqq.msf.core.a.a.k()) || (m == 0)) {
            continue;
          }
          localp.a = true;
          e.SetTimeOut((int)paramToServiceMsg.getTimeout());
          n.a(paramToServiceMsg);
          if ((0x100000 & n) == 1048576)
          {
            localObject = n.c(paramToServiceMsg.getRequestSsoSeq());
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.WTLoginCenter", 2, "changeTokenAfterLoginReal|GetStWithoutPasswd:" + paramBoolean1);
            }
            if (paramBoolean1) {
              continue;
            }
            parama = new byte[1][];
            parama[0] = new byte[1];
            parama[0][0] = 1;
            m = e.GetStWithoutPasswd(paramToServiceMsg.getUin(), 16L, l1, -1L, n, l2, arrayOfLong, (WUserSigInfo)localObject, new byte[0][], parama);
            a(paramToServiceMsg, localp, m, "sendChangeTokenMsg");
            return m;
          }
        }
        else
        {
          if (paramToServiceMsg.getServiceCmd().equals("login.chgTok_WEBVIEW_KEY"))
          {
            n = 1052704;
            m = 1;
            continue;
          }
          localObject = (HashMap)paramToServiceMsg.getAttributes().get("to_login_token_map");
          if ((((RequestCustomSig)((HashMap)localObject).get("RequestCustomSig")).ulCustumFlag & 0x2000) != 8192L) {
            break label413;
          }
          n = 16384;
          l1 = 715019303L;
          l2 = Long.parseLong((String)((HashMap)localObject).get("OpenAppid"));
          m = 1;
          continue;
        }
        Object localObject = n.b(paramToServiceMsg.getRequestSsoSeq());
        continue;
        if (parama == null)
        {
          QLog.e("MSF.C.WTLoginCenter", 1, "changeTokenAfterLogin error account is null.");
          return -1;
        }
        m = e.GetStWithoutPasswd(parama.d(), 16L, 16L, paramToServiceMsg.getAppId(), n, parama.f(), parama.i(), parama.k(), (WUserSigInfo)localObject);
        continue;
        return 1;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("MSF.C.WTLoginCenter", 1, "changeTokenAfterLogin error " + paramToServiceMsg.toString(), paramToServiceMsg);
        return 0;
      }
      label413:
      int m = 0;
      int n = 0;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, p paramp, int paramInt, String paramString)
  {
    if (paramInt != -1001)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.WTLoginCenter", 2, "call " + paramString + " ret  " + paramInt);
      }
      paramp.a(paramString, 0, n.b(paramToServiceMsg.getRequestSsoSeq()));
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, String paramString)
  {
    FromServiceMsg localFromServiceMsg = t.a(paramToServiceMsg);
    QLog.d("MSF.C.WTLoginCenter", 1, Thread.currentThread().getName() + " createNeedLoginRespByWt setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(localFromServiceMsg.getUin()));
    d.getAccountCenter().k(localFromServiceMsg.getUin());
    localFromServiceMsg.setBusinessFail(2001, localFromServiceMsg.getBusinessFailMsg());
    MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
    d.addRespToQuque(paramToServiceMsg, localFromServiceMsg);
    QLog.d("MSF.C.WTLoginCenter", 1, "found accountToken " + localFromServiceMsg.getUin() + " is expired on call " + paramString);
  }
  
  static void a(String paramString)
  {
    QLog.d("MSF.C.WTLoginCenter", 2, "updateCheckTime " + paramString);
    long l = System.currentTimeMillis();
    MsfStore.getNativeConfigStore().setConfig("_wtlastchecklocaltokentime_" + paramString, String.valueOf(l));
  }
  
  public static void a(WUserSigInfo paramWUserSigInfo, int paramInt, String paramString)
  {
    if ((paramWUserSigInfo == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        l = Long.valueOf(paramString).longValue();
        if (l <= 0L) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.WTLoginCenter", 2, "setExtraRegTlvValue|type= " + paramInt + "|" + l);
        }
        paramString = new byte[8];
        util.int64_to_buf(paramString, 0, l);
        WtloginHelper.setExtraRegTlvValue(paramWUserSigInfo, paramInt, paramString);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          long l = 0L;
        }
      }
    }
  }
  
  public static byte[] a()
  {
    return e.GetGuid();
  }
  
  private void b()
  {
    c.add("game.qq.com");
    c.add("mail.qq.com");
    c.add("qzone.qq.com");
    c.add("qun.qq.com");
    c.add("openmobile.qq.com");
    c.add("tenpay.com");
    c.add("connect.qq.com");
    c.add("qun.qq.com");
    c.add("qqweb.qq.com");
    c.add("office.qq.com");
    c.add("ti.qq.com");
    c.add("mma.qq.com");
    c.add("docs.qq.com");
    c.add("vip.qq.com");
    c.add("gamecenter.qq.com");
  }
  
  private boolean d(String paramString)
  {
    long l1;
    if (com.tencent.mobileqq.msf.core.a.a.k())
    {
      l1 = System.currentTimeMillis();
      paramString = MsfStore.getNativeConfigStore().getConfig("_wtlastchecklocaltokentime_" + paramString);
      if (paramString != null) {
        break label42;
      }
    }
    label42:
    long l2;
    do
    {
      return false;
      l2 = Long.parseLong(paramString);
    } while ((l1 <= l2) || (l1 - l2 > 43200000L));
    return true;
  }
  
  public void A(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    a(paramToServiceMsg, localp, e.CheckDevLockSms(paramToServiceMsg.getUin(), 16L, ((Long)paramToServiceMsg.getAttribute("subAppid")).longValue(), (String)paramToServiceMsg.getAttribute("smdCode"), (byte[])paramToServiceMsg.getAttribute("sppKey"), localWUserSigInfo), "wt_CheckDevLockSms");
  }
  
  public void B(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    a(paramToServiceMsg, localp, e.CloseDevLock(paramToServiceMsg.getUin(), 16L, ((Long)paramToServiceMsg.getAttribute("subAppid")).longValue(), localWUserSigInfo), "wt_CloseDevLock");
  }
  
  public void C(ToServiceMsg paramToServiceMsg)
  {
    int m = ((Integer)paramToServiceMsg.getAttribute("flag")).intValue();
    e.SetRegDevLockFlag(m);
  }
  
  public void D(ToServiceMsg paramToServiceMsg)
  {
    int m = ((Integer)paramToServiceMsg.getAttribute("mobile_type")).intValue();
    e.SetDevlockMobileType(m);
  }
  
  public void E(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    a(paramToServiceMsg, localp, e.RefreshSMSData(paramToServiceMsg.getUin(), 9L, localWUserSigInfo), "wt_RefreshSMSData");
  }
  
  public void F(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    a(paramToServiceMsg, localp, e.CheckSMSAndGetSt(paramToServiceMsg.getUin(), (byte[])paramToServiceMsg.getAttribute("userInput"), localWUserSigInfo), "wt_CheckSMSAndGetSt");
  }
  
  public void G(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    a(paramToServiceMsg, localp, e.CheckSMSAndGetSt(paramToServiceMsg.getUin(), (byte[])paramToServiceMsg.getAttribute("userInput"), localWUserSigInfo, (byte[][])null), "wt_CheckSMSAndGetSt");
  }
  
  public void H(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    String str1 = (String)paramToServiceMsg.getAttributes().get("To_register_lh_uin");
    String str2 = (String)paramToServiceMsg.getAttributes().get("To_register_unbind_lh_uin");
    String str3 = (String)paramToServiceMsg.getAttributes().get("to_register_cr_appVersion");
    if (!TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.WTLoginCenter", 2, "GetSMSVerifyLoginAccount|lhUin= " + str1);
      }
      a(localWUserSigInfo, 46, str1);
    }
    for (;;)
    {
      a(paramToServiceMsg, localp, e.RegGetSMSVerifyLoginAccount((byte[])paramToServiceMsg.getAttribute("msgchk"), "qqpassport".getBytes(), (byte[])paramToServiceMsg.getAttribute("nick"), str3.getBytes(), localWUserSigInfo), "wt_RegGetSMSVerifyLoginAccount");
      return;
      if (!TextUtils.isEmpty(str2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.WTLoginCenter", 2, "GetSMSVerifyLoginAccount|unBindUin= " + str2);
        }
        a(localWUserSigInfo, 47, str2);
      }
    }
  }
  
  public void I(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    String str2 = (String)paramToServiceMsg.getAttribute("countryCode");
    String str1 = (String)paramToServiceMsg.getAttribute("userAccount");
    if (!str2.startsWith("86")) {
      str1 = "00" + str2 + str1;
    }
    for (;;)
    {
      a(paramToServiceMsg, localp, e.CheckSMSVerifyLoginAccount(16L, paramToServiceMsg.getAppId(), str1, localWUserSigInfo), "wt_CheckSMSVerifyLoginAccount");
      return;
    }
  }
  
  public void J(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    String str3 = (String)paramToServiceMsg.getAttribute("countryCode");
    String str2 = (String)paramToServiceMsg.getAttribute("userAccount");
    String str1 = str2;
    if (!str3.startsWith("86")) {
      str1 = "00" + str3 + str2;
    }
    a(paramToServiceMsg, localp, e.RefreshSMSVerifyLoginCode(str1, localWUserSigInfo), "wt_RefreshSMSVerifyLoginCode");
  }
  
  public void K(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    String str3 = (String)paramToServiceMsg.getAttribute("countryCode");
    String str2 = (String)paramToServiceMsg.getAttribute("userAccount");
    String str1 = str2;
    if (!str3.startsWith("86")) {
      str1 = "00" + str3 + str2;
    }
    a(paramToServiceMsg, localp, e.VerifySMSVerifyLoginCode(str1, (String)paramToServiceMsg.getAttribute("code"), localWUserSigInfo), "wt_VerifySMSVerifyLoginCode");
  }
  
  public void L(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    long l = paramToServiceMsg.getAppId();
    Object localObject = (String)paramToServiceMsg.getAttribute("from_where", null);
    if ((localObject != null) && (((String)localObject).equalsIgnoreCase("ssoAccountAction")))
    {
      localWUserSigInfo._login_bitmap = 2;
      l = 2L;
    }
    for (;;)
    {
      String str2 = (String)paramToServiceMsg.getAttribute("countryCode");
      String str1 = (String)paramToServiceMsg.getAttribute("userAccount");
      localObject = str1;
      if (!str2.startsWith("86")) {
        localObject = "00" + str2 + str1;
      }
      a(paramToServiceMsg, localp, e.GetStViaSMSVerifyLogin((String)localObject, 16L, l, 34869344, localWUserSigInfo), "wt_GetStViaSMSVerifyLogin");
      return;
      localWUserSigInfo._login_bitmap = 0;
    }
  }
  
  public int a(a parama, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      if (d(parama.d()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.WTLoginCenter", 2, parama.d() + " setKeyToWtlogin not reach time limit, return ...");
        }
      }
      else
      {
        byte[] arrayOfByte = parama.k();
        int m = MsfCore.getNextSeq();
        ToServiceMsg localToServiceMsg = new ToServiceMsg("", parama.d(), "login.getSid");
        localToServiceMsg.setMsfCommand(MsfCommand._msf_refreToken);
        localToServiceMsg.setRequestSsoSeq(m);
        localToServiceMsg.setAppId(100);
        localToServiceMsg.setTimeout(30000L);
        p localp = n.a(d, localToServiceMsg);
        localp.b = false;
        n.a(localToServiceMsg);
        localp.a = true;
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.WTLoginCenter", 2, "setKeyToWtlogin|GetStWithoutPasswd");
        }
        m = e.GetStWithoutPasswd(parama.d(), 16L, 16L, localToServiceMsg.getAppId(), paramInt, parama.f(), parama.i(), arrayOfByte, n.b(m));
        a(localToServiceMsg, localp, m, "setWt");
        paramInt = m;
        if (!QLog.isColorLevel()) {
          return paramInt;
        }
        QLog.d("MSF.C.WTLoginCenter", 2, "call setWt for " + parama.d());
        return m;
      }
    }
    catch (Exception parama)
    {
      QLog.d("MSF.C.WTLoginCenter", 1, "call setWt error " + parama, parama);
      return -1;
    }
    paramInt = 1;
    return paramInt;
  }
  
  public int a(a parama, boolean paramBoolean)
  {
    return a(parama, 34869344, paramBoolean);
  }
  
  public int a(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.h = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    String str = (String)paramToServiceMsg.getAttribute("to_verify_passwd_image");
    a(paramToServiceMsg, localp, e.CheckPictureAndGetSt(paramToServiceMsg.getUin(), str.getBytes(), localWUserSigInfo), "verifyPasswdImage");
    return -1;
  }
  
  int a(ToServiceMsg paramToServiceMsg, WtloginHelper paramWtloginHelper)
  {
    if (!paramWtloginHelper.IsNeedLoginWithPasswd(paramToServiceMsg.getUin(), 16L).booleanValue()) {
      return 1;
    }
    paramWtloginHelper = d.getAccountCenter().l(paramToServiceMsg.getUin());
    if ((paramWtloginHelper != null) && (paramWtloginHelper.n())) {
      return 0;
    }
    QLog.d("MSF.C.WTLoginCenter", 1, "checkIsNeedLoginWithPasswd " + MD5.toMD5(paramToServiceMsg.getUin()) + " IsNeedLoginWithPasswd");
    paramWtloginHelper = t.a(paramToServiceMsg);
    paramWtloginHelper.setBusinessFail(2001, paramToServiceMsg.getUin() + " not login");
    MsfSdkUtils.addFromMsgProcessName("*", paramWtloginHelper);
    d.addRespToQuque(paramToServiceMsg, paramWtloginHelper);
    return -1;
  }
  
  public int a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    Object localObject1 = (byte[])paramToServiceMsg.getAttributes().get("to_login_pwd");
    try
    {
      localObject1 = new String((byte[])localObject1, "ISO-8859-1");
      if (paramBoolean)
      {
        localObject2 = (String)paramToServiceMsg.getAttribute("to_login_changeuin");
        localObject3 = paramToServiceMsg.getUin();
        paramToServiceMsg.setUin((String)localObject2);
        paramToServiceMsg.addAttribute("to_login_changeuin", localObject3);
      }
      Object localObject3 = n.a(d, paramToServiceMsg);
      ((p)localObject3).a = true;
      n.a(paramToServiceMsg);
      localWUserSigInfo = n.c(paramToServiceMsg.getRequestSsoSeq());
      Object localObject2 = (String)paramToServiceMsg.getAttribute("from_where", null);
      long l = paramToServiceMsg.getAppId();
      if ((localObject2 != null) && (((String)localObject2).equalsIgnoreCase("ssoAccountAction")))
      {
        localWUserSigInfo._login_bitmap = 2;
        l = 2L;
        localObject2 = (String)paramToServiceMsg.getAttribute("process", null);
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals("com.tencent.mobileqq:openSdk"))) {
          break label283;
        }
        m = 0;
        e.SetCanWebVerify(m);
        localObject2 = new long[0];
        if (com.tencent.mobileqq.msf.core.a.a.aY())
        {
          localObject2 = new long[1];
          localObject2[0] = 1600000226L;
        }
        e.SetUinDeviceToken(true);
        m = e.GetStWithPasswd(paramToServiceMsg.getUin(), 16L, 34869344, l, (long[])localObject2, true, (String)localObject1, localWUserSigInfo, new byte[0][]);
        a(paramToServiceMsg, (p)localObject3, m, "login");
        return m;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        WUserSigInfo localWUserSigInfo;
        localUnsupportedEncodingException.printStackTrace();
        String str = "";
        continue;
        localWUserSigInfo._login_bitmap = 0;
        continue;
        label283:
        int m = 130;
      }
    }
  }
  
  public long a(String paramString, int paramInt)
  {
    paramString = e.GetLocalTicket(paramString, 16L, paramInt);
    if (paramString == null) {
      return 0L;
    }
    return paramString._create_time * 1000L;
  }
  
  public void a(MsfCore paramMsfCore)
  {
    d = paramMsfCore;
    b();
    e = new WtloginHelper(BaseApplication.getContext());
    QLog.d("wtlogin_guid", 1, util.buf_to_string(e.GetGuid()));
    e.SetTimeOut(40000);
    e.SetMsfTransportFlag(1);
    e.setBabyQFlg(true);
    paramMsfCore = new o(paramMsfCore);
    e.SetListener(paramMsfCore);
    com.tencent.mobileqq.msf.core.NetConnInfoCenter.GUID = e.GetGuid();
  }
  
  public int b(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.h = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    a(paramToServiceMsg, localp, e.RefreshPictureData(paramToServiceMsg.getUin(), localWUserSigInfo), "verifyPasswdRefreshImage");
    return -1;
  }
  
  public int b(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    try
    {
      n.a(d, paramToServiceMsg);
      m = a(paramToServiceMsg, e);
      QLog.d("MSF.C.WTLoginCenter", 1, "changeTokenAfterLogin checkIsNeedLoginWithPasswd " + m + " process:" + q.b(paramToServiceMsg) + " cmd:" + paramToServiceMsg.getServiceCmd());
      switch (m)
      {
      case -1: 
        a(paramToServiceMsg, "changeTokenAfterLogin");
        return -1;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      int m;
      QLog.e("MSF.C.WTLoginCenter", 1, "changeTokenAfterLogin error " + paramToServiceMsg.toString(), paramToServiceMsg);
      return 0;
    }
    return a(paramToServiceMsg, true, d.getAccountCenter().l(paramToServiceMsg.getUin()), paramBoolean);
    m = a(paramToServiceMsg, false, null, paramBoolean);
    return m;
    return 0;
  }
  
  public long b(String paramString, int paramInt)
  {
    paramString = e.GetLocalTicket(paramString, 16L, paramInt);
    if (paramString == null) {
      return 0L;
    }
    return paramString._expire_time * 1000L;
  }
  
  public boolean b(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        QLog.d("MSF.C.WTLoginCenter", 1, "check ps, uin is empty!");
        return false;
      }
      paramString = e.GetLocalTicket(paramString, 16L, 1048576);
      if ((paramString == null) && (paramString._pskey_map == null))
      {
        QLog.d("MSF.C.WTLoginCenter", 1, "check ps, local store is empty!");
        return false;
      }
      Object localObject = com.tencent.mobileqq.msf.core.a.a.bg();
      if (localObject == null)
      {
        QLog.d("MSF.C.WTLoginCenter", 1, "check ps, dons is empty!");
        return false;
      }
      localObject = ((HashSet)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        byte[] arrayOfByte = (byte[])paramString._pskey_map.get(str);
        if ((arrayOfByte == null) || (arrayOfByte.length == 0))
        {
          QLog.d("MSF.C.WTLoginCenter", 1, "check ps, " + str + " is empty!");
          return true;
        }
      }
      return false;
    }
    catch (Exception paramString)
    {
      QLog.d("MSF.C.WTLoginCenter", 1, "get ticket failed, PSKEY, exception: " + paramString.toString());
    }
    return false;
  }
  
  public int c(ToServiceMsg paramToServiceMsg)
  {
    Object localObject = (byte[])paramToServiceMsg.getAttributes().get("to_login_pwd");
    try
    {
      localObject = new String((byte[])localObject, "ISO-8859-1");
      p localp = n.a(d, paramToServiceMsg);
      localp.a = true;
      localp.h = true;
      n.a(paramToServiceMsg);
      WUserSigInfo localWUserSigInfo = new WUserSigInfo();
      localWUserSigInfo._reserveData = MsfSdkUtils.convertInt2Bytes(paramToServiceMsg.getRequestSsoSeq());
      int m = e.GetStWithPasswd(paramToServiceMsg.getUin(), 16L, 0, 1600000749L, new long[0], true, (String)localObject, localWUserSigInfo, new byte[0][]);
      a(paramToServiceMsg, localp, m, "verifyPasswd");
      return m;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
        String str = "";
      }
    }
  }
  
  public HashMap c(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject1 = e.GetLocalTicket(paramString, 16L, 64);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((Ticket)localObject1)._sig;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = HexUtil.bytes2HexStr((byte[])localObject1);
      }
      catch (Exception localException1)
      {
        Object localObject3;
        Object localObject2 = null;
        Object localObject1 = null;
        localException1.printStackTrace();
        Object localObject6 = localObject2;
        Object localObject4 = null;
        localObject2 = localObject1;
        localObject1 = localObject6;
        continue;
        Object localObject5;
        localObject1 = null;
        continue;
      }
      try
      {
        localObject2 = e.GetLocalTicket(paramString, 16L, 4096);
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((Ticket)localObject2)._sig;
        if (localObject2 == null) {
          continue;
        }
        localObject2 = new String((byte[])localObject2);
      }
      catch (Exception localException2)
      {
        localObject2 = localObject1;
        localObject1 = null;
        continue;
        localObject2 = null;
        continue;
      }
      try
      {
        localObject3 = e.GetLocalTicket(paramString, 16L, 32);
        if (localObject3 == null) {
          continue;
        }
        localObject3 = ((Ticket)localObject3)._sig;
        if (localObject3 == null) {
          continue;
        }
        localObject3 = HexUtil.bytes2HexStr((byte[])localObject3);
      }
      catch (Exception localException3)
      {
        localObject5 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject5;
        localObject5 = localException3;
        continue;
        localObject5 = null;
      }
    }
    localObject6 = new HashMap();
    ((HashMap)localObject6).put("uin", paramString);
    ((HashMap)localObject6).put("A2", localObject1);
    ((HashMap)localObject6).put("vkey", null);
    ((HashMap)localObject6).put("skey", localObject2);
    ((HashMap)localObject6).put("pskey", null);
    ((HashMap)localObject6).put("stweb", localObject3);
    ((HashMap)localObject6).put("superkey", null);
    return localObject6;
  }
  
  public int d(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    int m = e.RefreshPictureData(paramToServiceMsg.getUin(), localWUserSigInfo);
    a(paramToServiceMsg, localp, m, "refreVerifycode");
    return m;
  }
  
  public int e(ToServiceMsg paramToServiceMsg)
  {
    String str = (String)paramToServiceMsg.getAttributes().get("to_verify_code");
    p localp = n.a(d, paramToServiceMsg);
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    int m = e.CheckPictureAndGetSt(paramToServiceMsg.getUin(), str.getBytes(), localWUserSigInfo);
    a(paramToServiceMsg, localp, m, "submitVerifycode");
    return m;
  }
  
  public int f(ToServiceMsg paramToServiceMsg)
  {
    String str = (String)paramToServiceMsg.getAttributes().get("to_puzzle_verify_code_sig");
    p localp = n.a(d, paramToServiceMsg);
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    int m = e.CheckWebsigAndGetSt(paramToServiceMsg.getUin(), str, localWUserSigInfo);
    a(paramToServiceMsg, localp, m, "submitPuzzleVerifyCodeTicket");
    return m;
  }
  
  public int g(ToServiceMsg paramToServiceMsg)
  {
    String str = (String)paramToServiceMsg.getAttributes().get("to_register_cr_mobile");
    p localp = n.a(d, paramToServiceMsg);
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    if (QLog.isColorLevel()) {
      QLog.d("queryMobile", 2, "WTLoginCenter.RegQueryAccount");
    }
    int m = e.RegQueryAccount(1, str.getBytes(), 16L, localWUserSigInfo);
    a(paramToServiceMsg, localp, m, "RegQueryAccount");
    return m;
  }
  
  public int h(ToServiceMsg paramToServiceMsg)
  {
    Byte localByte1 = (Byte)paramToServiceMsg.getAttributes().get("to_register_cr_country");
    Byte localByte2 = (Byte)paramToServiceMsg.getAttributes().get("to_register_cr_language");
    Byte localByte3 = (Byte)paramToServiceMsg.getAttributes().get("to_register_cr_pigType");
    String str1 = (String)paramToServiceMsg.getAttributes().get("to_register_cr_appName");
    str1 = (String)paramToServiceMsg.getAttributes().get("to_register_cr_appVersion");
    String str2 = (String)paramToServiceMsg.getAttributes().get("to_register_cr_mobile");
    long l = ((Long)paramToServiceMsg.getAttributes().get("appid")).longValue();
    String str3 = (String)paramToServiceMsg.getAttribute("To_register_captcha_sig", null);
    Object localObject1 = (String)paramToServiceMsg.getAttributes().get("wifi_mac");
    Object localObject2 = (String)paramToServiceMsg.getAttributes().get("os_language");
    int m = ((Integer)paramToServiceMsg.getAttributes().get("qq_language")).intValue();
    Object localObject3 = (String)paramToServiceMsg.getAttributes().get("gps_location");
    WtloginHelper localWtloginHelper = e;
    WtloginHelper.setSecTransInfo((String)localObject1, (String)localObject2, m, (String)localObject3);
    localObject1 = n.a(d, paramToServiceMsg);
    n.a(paramToServiceMsg);
    localObject2 = n.b(paramToServiceMsg.getRequestSsoSeq());
    ((WUserSigInfo)localObject2)._seqence = ((p)localObject1).f;
    localObject3 = e;
    WtloginHelper.setRegisterFlg(4);
    localObject3 = (String)paramToServiceMsg.getAttribute("To_register_Invitation_code", null);
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.WTLoginCenter", 2, "RegSubmitMobile|invitation= " + (String)localObject3);
      }
      WtloginHelper.setExtraRegTlvValue((WUserSigInfo)localObject2, 49, ((String)localObject3).getBytes());
    }
    m = e.RegSubmitMobile(str3, str2.getBytes(), str1.getBytes(), localByte1.byteValue(), localByte2.byteValue(), localByte3.byteValue(), 16L, l, (WUserSigInfo)localObject2);
    a(paramToServiceMsg, (p)localObject1, m, "RegSubmitMobile");
    return m;
  }
  
  public int i(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    int m = e.RegRequestServerResendMsg(localWUserSigInfo);
    a(paramToServiceMsg, localp, m, "RegRequestServerResendMsg");
    return m;
  }
  
  public int j(ToServiceMsg paramToServiceMsg)
  {
    String str = (String)paramToServiceMsg.getAttributes().get("To_register_smsCode");
    p localp = n.a(d, paramToServiceMsg);
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    int m = e.RegSubmitMsgChk(str.getBytes(), localWUserSigInfo);
    a(paramToServiceMsg, localp, m, "RegSubmitMsgChk");
    return m;
  }
  
  public int k(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    int m = e.RegQueryClientSentMsgStatus(localWUserSigInfo);
    a(paramToServiceMsg, localp, m, "RegQueryClientSentMsgStatus");
    return m;
  }
  
  public int l(ToServiceMsg paramToServiceMsg)
  {
    String str1 = (String)paramToServiceMsg.getAttributes().get("To_register_smsCode");
    String str2 = (String)paramToServiceMsg.getAttributes().get("To_register_pass");
    String str3 = (String)paramToServiceMsg.getAttributes().get("To_register_nick");
    int n = 1;
    int m = n;
    if (paramToServiceMsg.getAttributes().containsKey("To_register_type"))
    {
      m = n;
      if (!((Boolean)paramToServiceMsg.getAttributes().get("To_register_type")).booleanValue()) {
        m = 5;
      }
    }
    p localp = n.a(d, paramToServiceMsg);
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    String str4 = (String)paramToServiceMsg.getAttributes().get("To_register_lh_uin");
    String str5 = (String)paramToServiceMsg.getAttributes().get("To_register_unbind_lh_uin");
    String str6 = (String)paramToServiceMsg.getAttributes().get("to_register_cr_appVersion");
    if (!TextUtils.isEmpty(str4))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.WTLoginCenter", 2, "RegGetAccount|lhUin= " + str4);
      }
      a(localWUserSigInfo, 46, str4);
    }
    for (;;)
    {
      m = e.RegGetAccount(str1.getBytes(), "qqpassport".getBytes(), str2.getBytes(), str3.getBytes(), str6.getBytes(), m, localWUserSigInfo);
      a(paramToServiceMsg, localp, m, "RegGetAccount");
      return m;
      if (!TextUtils.isEmpty(str5))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.WTLoginCenter", 2, "RegGetAccount|unBindUin= " + str4);
        }
        a(localWUserSigInfo, 47, str5);
      }
    }
  }
  
  public int m(ToServiceMsg paramToServiceMsg)
  {
    String str1 = paramToServiceMsg.getUin();
    String str2 = (String)paramToServiceMsg.getAttributes().get("to_register_cr_appVersion");
    Byte localByte = (Byte)paramToServiceMsg.getAttributes().get("to_register_cr_language");
    int m = paramToServiceMsg.getAppId();
    p localp = n.a(d, paramToServiceMsg);
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_Center", 2, "WTLoiginCenter|checkQuickRegister : account= " + str1 + ",subAppId = " + m + ",appVer=" + str2);
    }
    m = e.quickRegisterCheckAccount(Long.valueOf(str1).longValue(), 16L, localByte.byteValue(), m, str2.getBytes(), localWUserSigInfo);
    a(paramToServiceMsg, localp, m, "checkQuickRegister");
    return m;
  }
  
  public int n(ToServiceMsg paramToServiceMsg)
  {
    String str1 = paramToServiceMsg.getUin();
    String str2 = (String)paramToServiceMsg.getAttributes().get("To_register_pass");
    String str3 = (String)paramToServiceMsg.getAttributes().get("To_register_nick");
    String str4 = (String)paramToServiceMsg.getAttributes().get("to_register_cr_appVersion");
    Byte localByte = (Byte)paramToServiceMsg.getAttributes().get("to_register_cr_language");
    int m = paramToServiceMsg.getAppId();
    p localp = n.a(d, paramToServiceMsg);
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    if (QLog.isColorLevel()) {
      QLog.d("Login_Optimize_Center", 2, "WTLoiginCenter|getQuickRegisterAccount : account= " + str1 + ",nick= " + str3 + ",subAppId = " + m + ",appVer=" + str4);
    }
    m = e.quickRegisterGetAccount(Long.valueOf(str1).longValue(), 16L, localByte.byteValue(), m, str4.getBytes(), str3.getBytes(), str2, localWUserSigInfo);
    a(paramToServiceMsg, localp, m, "getQuickRegisterAccount");
    return m;
  }
  
  public void o(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    a(paramToServiceMsg, localp, e.GetStWithPasswd(paramToServiceMsg.getUin(), ((Long)paramToServiceMsg.getAttribute("appid")).longValue(), (String)paramToServiceMsg.getAttribute("passwd"), localWUserSigInfo), "wt_GetStWithPasswd");
  }
  
  public void p(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter", 2, "wt_GetOpenKeyWithoutPasswd uin=" + paramToServiceMsg.getUin() + " dwSrcAppid=" + paramToServiceMsg.getAttribute("dwSrcAppid") + " dwDstAppid=" + paramToServiceMsg.getAttribute("dwDstAppid") + " sigInfo=" + localWUserSigInfo);
    }
    String str = (String)paramToServiceMsg.getAttribute("from_where", null);
    a(paramToServiceMsg, localp, e.GetOpenKeyWithoutPasswd(paramToServiceMsg.getUin(), ((Long)paramToServiceMsg.getAttribute("dwSrcAppid")).longValue(), ((Long)paramToServiceMsg.getAttribute("dwDstAppid")).longValue(), 36864, localWUserSigInfo), "wt_GetOpenKeyWithoutPasswd");
  }
  
  public void q(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    String str = (String)paramToServiceMsg.getAttribute("from_where", null);
    long l2 = paramToServiceMsg.getAppId();
    long l1 = l2;
    if (str != null)
    {
      l1 = l2;
      if (str.equalsIgnoreCase("ssoAccountAction")) {
        l1 = 2L;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter", 2, "wt_GetStWithoutPasswd localappid = " + l1);
    }
    a(paramToServiceMsg, localp, e.GetStWithoutPasswd(paramToServiceMsg.getUin(), ((Long)paramToServiceMsg.getAttribute("dwSrcAppid")).longValue(), ((Long)paramToServiceMsg.getAttribute("dwDstAppid")).longValue(), l1, 34869344, localWUserSigInfo), "wt_GetStWithoutPasswd");
  }
  
  public void r(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = false;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.WTLoginCenter", 2, "refreshDA2|GetStWithoutPasswd");
    }
    a(paramToServiceMsg, localp, e.GetStWithoutPasswd(paramToServiceMsg.getUin(), 16L, 16L, -1L, 33554432, localWUserSigInfo), "refreshDA2");
  }
  
  public void s(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    a(paramToServiceMsg, localp, e.CheckPictureAndGetSt(paramToServiceMsg.getUin(), (byte[])paramToServiceMsg.getAttribute("userInput"), localWUserSigInfo), "wt_CheckPictureAndGetSt");
  }
  
  public void t(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    a(paramToServiceMsg, localp, e.RefreshPictureData(paramToServiceMsg.getUin(), localWUserSigInfo), "wt_RefreshPictureData");
  }
  
  public void u(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    a(paramToServiceMsg, localp, e.VerifyCode(paramToServiceMsg.getUin(), ((Long)paramToServiceMsg.getAttribute("appid")).longValue(), ((Boolean)paramToServiceMsg.getAttribute("close")).booleanValue(), (byte[])paramToServiceMsg.getAttribute("code"), (int[])paramToServiceMsg.getAttribute("tlv"), ((Integer)paramToServiceMsg.getAttribute("version")).intValue(), localWUserSigInfo), "wt_VerifyCode");
  }
  
  public void v(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    Object localObject = (ArrayList)paramToServiceMsg.getAttribute("data");
    ArrayList localArrayList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(HexUtil.hexStr2Bytes((String)((Iterator)localObject).next()));
    }
    a(paramToServiceMsg, localp, e.CloseCode(paramToServiceMsg.getUin(), ((Long)paramToServiceMsg.getAttribute("appid")).longValue(), (byte[])paramToServiceMsg.getAttribute("code"), ((Integer)paramToServiceMsg.getAttribute("version")).intValue(), localArrayList, localWUserSigInfo), "wt_CloseCode");
  }
  
  public void w(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    a(paramToServiceMsg, localp, e.cancelCode(paramToServiceMsg.getUin(), ((Long)paramToServiceMsg.getAttribute("appid")).longValue(), (byte[])paramToServiceMsg.getAttribute("code"), localWUserSigInfo), "wt_CancelCode");
  }
  
  public void x(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    a(paramToServiceMsg, localp, e.GetA1WithA1(paramToServiceMsg.getUin(), ((Long)paramToServiceMsg.getAttribute("dwSrcAppid")).longValue(), ((Long)paramToServiceMsg.getAttribute("dwSubSrcAppid")).longValue(), (byte[])paramToServiceMsg.getAttribute("dstAppName"), ((Long)paramToServiceMsg.getAttribute("dwDstSsoVer")).longValue(), ((Long)paramToServiceMsg.getAttribute("dwDstAppid")).longValue(), ((Long)paramToServiceMsg.getAttribute("dwSubDstAppid")).longValue(), (byte[])paramToServiceMsg.getAttribute("dstAppVer"), (byte[])paramToServiceMsg.getAttribute("dstAppSign"), localWUserSigInfo, (WFastLoginInfo)paramToServiceMsg.getAttribute("fastLoginInfo")), "wt_GetA1WithA1");
  }
  
  public void y(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    a(paramToServiceMsg, localp, e.CheckDevLockStatus(paramToServiceMsg.getUin(), 16L, ((Long)paramToServiceMsg.getAttribute("subAppid")).longValue(), localWUserSigInfo), "wt_CheckDevLockStatus");
  }
  
  public void z(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    a(paramToServiceMsg, localp, e.AskDevLockSms(paramToServiceMsg.getUin(), 16L, 8L, localWUserSigInfo), "wt_AskDevLockSms");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.l
 * JD-Core Version:    0.7.0.1
 */