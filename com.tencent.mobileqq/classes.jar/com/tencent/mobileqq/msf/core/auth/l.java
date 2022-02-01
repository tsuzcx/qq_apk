package com.tencent.mobileqq.msf.core.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.u;
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
  private static final String i = "msf_guid";
  private static final long j = 9L;
  private static final long k = 8L;
  private final int l = 100;
  
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
        l1 = paramToServiceMsg.getAppId();
        if (paramToServiceMsg.getServiceCmd().equals("login.chgTok_A2D2"))
        {
          n = 262208;
        }
        else if (paramToServiceMsg.getServiceCmd().equals("login.chgTok_WEBVIEW_KEY"))
        {
          n = 1052704;
        }
        else
        {
          Object localObject = (HashMap)paramToServiceMsg.getAttributes().get("to_login_token_map");
          if ((((RequestCustomSig)((HashMap)localObject).get("RequestCustomSig")).ulCustumFlag & 0x2000) != 8192L) {
            break label444;
          }
          l2 = Long.parseLong((String)((HashMap)localObject).get("OpenAppid"));
          l1 = 715019303L;
          m = 1;
          n = 16384;
          n |= 0x2000000;
          if ((com.tencent.mobileqq.msf.core.a.a.k()) && (m != 0))
          {
            localp.a = true;
            e.SetTimeOut((int)paramToServiceMsg.getTimeout());
            n.a(paramToServiceMsg);
            if ((n & 0x100000) == 1048576) {
              localObject = n.c(paramToServiceMsg.getRequestSsoSeq());
            } else {
              localObject = n.b(paramToServiceMsg.getRequestSsoSeq());
            }
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("changeTokenAfterLoginReal|GetStWithoutPasswd:");
              localStringBuilder.append(paramBoolean1);
              QLog.d("MSF.C.WTLoginCenter", 2, localStringBuilder.toString());
            }
            if (!paramBoolean1)
            {
              parama = new byte[1][];
              parama[0] = new byte[1];
              parama[0][0] = 1;
              m = e.GetStWithoutPasswd(paramToServiceMsg.getUin(), 16L, l1, -1L, n, l2, arrayOfLong, (WUserSigInfo)localObject, new byte[0][], parama);
            }
            else
            {
              if (parama == null)
              {
                QLog.e("MSF.C.WTLoginCenter", 1, "changeTokenAfterLogin error account is null.");
                return -1;
              }
              m = e.GetStWithoutPasswd(parama.d(), 16L, 16L, paramToServiceMsg.getAppId(), n, parama.f(), parama.i(), parama.k(), (WUserSigInfo)localObject);
            }
            try
            {
              a(paramToServiceMsg, localp, m, "sendChangeTokenMsg");
              return m;
            }
            catch (Exception paramToServiceMsg) {}
          }
          else
          {
            return 1;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        parama = new StringBuilder();
        parama.append("changeTokenAfterLogin error ");
        parama.append(paramToServiceMsg.toString());
        QLog.e("MSF.C.WTLoginCenter", 1, parama.toString(), paramToServiceMsg);
        return 0;
      }
      long l3 = 16L;
      long l2 = l1;
      int m = 1;
      long l1 = l3;
      continue;
      label444:
      l3 = 16L;
      l2 = l1;
      m = 0;
      int n = 0;
      l1 = l3;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, p paramp, int paramInt, String paramString)
  {
    if (paramInt != -1001)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("call ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" ret  ");
        localStringBuilder.append(paramInt);
        QLog.d("MSF.C.WTLoginCenter", 2, localStringBuilder.toString());
      }
      paramp.a(paramString, 0, n.b(paramToServiceMsg.getRequestSsoSeq()));
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, String paramString)
  {
    FromServiceMsg localFromServiceMsg = com.tencent.mobileqq.msf.core.o.a(paramToServiceMsg);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Thread.currentThread().getName());
    localStringBuilder.append(" createNeedLoginRespByWt setAccountNoLogin uin=");
    localStringBuilder.append(MsfSdkUtils.getShortUin(localFromServiceMsg.getUin()));
    QLog.d("MSF.C.WTLoginCenter", 1, localStringBuilder.toString());
    d.getAccountCenter().k(localFromServiceMsg.getUin());
    localFromServiceMsg.setBusinessFail(2001, localFromServiceMsg.getBusinessFailMsg());
    MsfSdkUtils.addFromMsgProcessName("*", localFromServiceMsg);
    d.addRespToQuque(paramToServiceMsg, localFromServiceMsg);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("found accountToken ");
    paramToServiceMsg.append(localFromServiceMsg.getUin());
    paramToServiceMsg.append(" is expired on call ");
    paramToServiceMsg.append(paramString);
    QLog.d("MSF.C.WTLoginCenter", 1, paramToServiceMsg.toString());
  }
  
  private void a(ToServiceMsg paramToServiceMsg, WUserSigInfo paramWUserSigInfo)
  {
    if (!"com.tencent.mobileqq:openSdk".equals((String)paramToServiceMsg.getAttribute("process", null))) {
      return;
    }
    Object localObject = paramToServiceMsg.getAttribute("connect_data");
    if ((localObject instanceof byte[]))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WTLoginCenter login --> MsfCommand=");
      localStringBuilder.append(paramToServiceMsg.getMsfCommand());
      localStringBuilder.append(", connect_data=");
      paramToServiceMsg = (byte[])localObject;
      localStringBuilder.append(paramToServiceMsg.length);
      QLog.d("MSF.C.WTLoginCenter", 1, localStringBuilder.toString());
      WtloginHelper.setExtraLoginTlvValue(paramWUserSigInfo, 1346, paramToServiceMsg);
      return;
    }
    paramWUserSigInfo = new StringBuilder();
    paramWUserSigInfo.append("WTLoginCenter login --> MsfCommand=");
    paramWUserSigInfo.append(paramToServiceMsg.getMsfCommand());
    QLog.d("MSF.C.WTLoginCenter", 1, paramWUserSigInfo.toString());
  }
  
  static void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateCheckTime ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("MSF.C.WTLoginCenter", 2, ((StringBuilder)localObject).toString());
    long l1 = System.currentTimeMillis();
    localObject = MsfStore.getNativeConfigStore();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_wtlastchecklocaltokentime_");
    localStringBuilder.append(paramString);
    ((NativeConfigStore)localObject).setConfig(localStringBuilder.toString(), String.valueOf(l1));
  }
  
  public static void a(WUserSigInfo paramWUserSigInfo, int paramInt, String paramString)
  {
    if (paramWUserSigInfo != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      long l1;
      try
      {
        l1 = Long.valueOf(paramString).longValue();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        l1 = 0L;
      }
      if (l1 > 0L)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("setExtraRegTlvValue|type= ");
          paramString.append(paramInt);
          paramString.append("|");
          paramString.append(l1);
          QLog.d("MSF.C.WTLoginCenter", 2, paramString.toString());
        }
        paramString = new byte[8];
        util.int64_to_buf(paramString, 0, l1);
        WtloginHelper.setExtraRegTlvValue(paramWUserSigInfo, paramInt, paramString);
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
    if (com.tencent.mobileqq.msf.core.a.a.k())
    {
      long l1 = System.currentTimeMillis();
      NativeConfigStore localNativeConfigStore = MsfStore.getNativeConfigStore();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("_wtlastchecklocaltokentime_");
      localStringBuilder.append(paramString);
      paramString = localNativeConfigStore.getConfig(localStringBuilder.toString());
      if (paramString == null) {
        return false;
      }
      long l2 = Long.parseLong(paramString);
      if (l1 > l2) {
        return l1 - l2 <= 43200000L;
      }
    }
    return false;
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
    Object localObject = paramToServiceMsg.getAttribute("key_business_seq");
    if ((localObject != null) && ((localObject instanceof Integer))) {
      localWUserSigInfo._seqence = ((Integer)localObject).intValue();
    }
    localObject = paramToServiceMsg.getAttribute("businessType");
    if ((localObject != null) && ((localObject instanceof Integer))) {
      localWUserSigInfo.businessType = ((Integer)localObject).intValue();
    }
    a(paramToServiceMsg, localWUserSigInfo);
    localObject = (byte[])paramToServiceMsg.getAttribute("smsExtraData");
    a(paramToServiceMsg, localp, e.RefreshSMSData(paramToServiceMsg.getUin(), 9L, localWUserSigInfo, (byte[])localObject), "wt_RefreshSMSData");
  }
  
  public void F(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    a(paramToServiceMsg, localWUserSigInfo);
    localWUserSigInfo._seqence = localp.f;
    Object localObject = paramToServiceMsg.getAttribute("key_business_seq");
    if ((localObject != null) && ((localObject instanceof Integer))) {
      localWUserSigInfo._seqence = ((Integer)localObject).intValue();
    }
    localObject = paramToServiceMsg.getAttribute("businessType");
    if ((localObject != null) && ((localObject instanceof Integer))) {
      localWUserSigInfo.businessType = ((Integer)localObject).intValue();
    }
    localObject = paramToServiceMsg.getAttribute("phoneToken");
    if (localObject != null) {
      WtloginHelper.setExtraLoginTlvValue(localWUserSigInfo, 1346, (byte[])localObject);
    }
    localObject = (byte[])paramToServiceMsg.getAttribute("smsExtraData");
    a(paramToServiceMsg, localp, e.CheckSMSAndGetSt(paramToServiceMsg.getUin(), (byte[])paramToServiceMsg.getAttribute("userInput"), localWUserSigInfo, (byte[][])null, (byte[])localObject), "wt_CheckSMSAndGetSt");
  }
  
  public void G(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    byte[] arrayOfByte = (byte[])paramToServiceMsg.getAttribute("smsExtraData");
    a(paramToServiceMsg, localp, e.CheckSMSAndGetSt(paramToServiceMsg.getUin(), (byte[])paramToServiceMsg.getAttribute("userInput"), localWUserSigInfo, (byte[][])null, arrayOfByte), "wt_CheckSMSAndGetSt");
  }
  
  public void H(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    Object localObject1 = (String)paramToServiceMsg.getAttributes().get("To_register_lh_uin");
    Object localObject2 = (String)paramToServiceMsg.getAttributes().get("To_register_unbind_lh_uin");
    String str = (String)paramToServiceMsg.getAttributes().get("to_register_cr_appVersion");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("GetSMSVerifyLoginAccount|lhUin= ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("MSF.C.WTLoginCenter", 2, ((StringBuilder)localObject2).toString());
      }
      a(localWUserSigInfo, 46, (String)localObject1);
    }
    else if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("GetSMSVerifyLoginAccount|unBindUin= ");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.d("MSF.C.WTLoginCenter", 2, ((StringBuilder)localObject1).toString());
      }
      a(localWUserSigInfo, 47, (String)localObject2);
    }
    a(paramToServiceMsg, localp, e.RegGetSMSVerifyLoginAccount((byte[])paramToServiceMsg.getAttribute("msgchk"), "qqpassport".getBytes(), (byte[])paramToServiceMsg.getAttribute("nick"), str.getBytes(), localWUserSigInfo), "wt_RegGetSMSVerifyLoginAccount");
  }
  
  public void I(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    Object localObject = (String)paramToServiceMsg.getAttribute("countryCode");
    String str = (String)paramToServiceMsg.getAttribute("userAccount");
    if (!((String)localObject).startsWith("86"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("00");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(str);
      str = localStringBuilder.toString();
    }
    localObject = paramToServiceMsg.getAttribute("verifyToken");
    if (localObject != null) {
      WtloginHelper.setExtraLoginTlvValue(localWUserSigInfo, 1346, (byte[])localObject);
    }
    a(paramToServiceMsg, localp, e.CheckSMSVerifyLoginAccount(16L, paramToServiceMsg.getAppId(), str, localWUserSigInfo), "wt_CheckSMSVerifyLoginAccount");
  }
  
  public void J(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    String str2 = (String)paramToServiceMsg.getAttribute("countryCode");
    String str1 = (String)paramToServiceMsg.getAttribute("userAccount");
    Object localObject = str1;
    if (!str2.startsWith("86"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("00");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(str1);
      localObject = ((StringBuilder)localObject).toString();
    }
    a(paramToServiceMsg, localp, e.RefreshSMSVerifyLoginCode((String)localObject, localWUserSigInfo), "wt_RefreshSMSVerifyLoginCode");
  }
  
  public void K(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    String str2 = (String)paramToServiceMsg.getAttribute("countryCode");
    String str1 = (String)paramToServiceMsg.getAttribute("userAccount");
    Object localObject = str1;
    if (!str2.startsWith("86"))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("00");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(str1);
      localObject = ((StringBuilder)localObject).toString();
    }
    a(paramToServiceMsg, localp, e.VerifySMSVerifyLoginCode((String)localObject, (String)paramToServiceMsg.getAttribute("code"), localWUserSigInfo), "wt_VerifySMSVerifyLoginCode");
  }
  
  public void L(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    Object localObject = paramToServiceMsg.getAttribute("phoneToken");
    if (localObject != null) {
      WtloginHelper.setExtraLoginTlvValue(localWUserSigInfo, 1346, (byte[])localObject);
    }
    a(paramToServiceMsg, localp, e.quickLoginByGateway(16L, 34869344L, paramToServiceMsg.getAppId(), localWUserSigInfo), "wt_QuickLoginByGateway");
  }
  
  public void M(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    long l2 = paramToServiceMsg.getAppId();
    Object localObject1 = (String)paramToServiceMsg.getAttribute("from_where", null);
    long l1;
    if ((localObject1 != null) && (((String)localObject1).equalsIgnoreCase("ssoAccountAction")))
    {
      localWUserSigInfo._login_bitmap = 2;
      l1 = 1600001540L;
    }
    else
    {
      localWUserSigInfo._login_bitmap = 0;
      l1 = 16L;
    }
    String str = (String)paramToServiceMsg.getAttribute("countryCode");
    Object localObject2 = (String)paramToServiceMsg.getAttribute("userAccount");
    localObject1 = localObject2;
    if (!str.startsWith("86"))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("00");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("wt_GetStViaSMSVerifyLogin appId = ");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append(" localappid = ");
      ((StringBuilder)localObject2).append(l2);
      QLog.d("MSF.C.WTLoginCenter", 2, ((StringBuilder)localObject2).toString());
    }
    a(paramToServiceMsg, localp, e.GetStViaSMSVerifyLogin((String)localObject1, l1, l2, 34869344, localWUserSigInfo), "wt_GetStViaSMSVerifyLogin");
  }
  
  public int a(a parama, int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      if (d(parama.d()))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(parama.d());
          ((StringBuilder)localObject).append(" setKeyToWtlogin not reach time limit, return ...");
          QLog.d("MSF.C.WTLoginCenter", 2, ((StringBuilder)localObject).toString());
          return 1;
        }
      }
      else
      {
        localObject = parama.k();
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
        paramInt = e.GetStWithoutPasswd(parama.d(), 16L, 16L, localToServiceMsg.getAppId(), paramInt, parama.f(), parama.i(), (byte[])localObject, n.b(m));
        a(localToServiceMsg, localp, paramInt, "setWt");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("call setWt for ");
          ((StringBuilder)localObject).append(parama.d());
          QLog.d("MSF.C.WTLoginCenter", 2, ((StringBuilder)localObject).toString());
        }
        return paramInt;
      }
    }
    catch (Exception parama)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("call setWt error ");
      ((StringBuilder)localObject).append(parama);
      QLog.d("MSF.C.WTLoginCenter", 1, ((StringBuilder)localObject).toString(), parama);
      return -1;
    }
    return 1;
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
    paramWtloginHelper = new StringBuilder();
    paramWtloginHelper.append("checkIsNeedLoginWithPasswd ");
    paramWtloginHelper.append(MD5.toMD5(paramToServiceMsg.getUin()));
    paramWtloginHelper.append(" IsNeedLoginWithPasswd");
    QLog.d("MSF.C.WTLoginCenter", 1, paramWtloginHelper.toString());
    paramWtloginHelper = com.tencent.mobileqq.msf.core.o.a(paramToServiceMsg);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramToServiceMsg.getUin());
    localStringBuilder.append(" not login");
    paramWtloginHelper.setBusinessFail(2001, localStringBuilder.toString());
    MsfSdkUtils.addFromMsgProcessName("*", paramWtloginHelper);
    d.addRespToQuque(paramToServiceMsg, paramWtloginHelper);
    return -1;
  }
  
  public int a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    Object localObject1 = (byte[])paramToServiceMsg.getAttributes().get("to_login_pwd");
    String str;
    try
    {
      localObject1 = new String((byte[])localObject1, "ISO-8859-1");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      str = "";
    }
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
    WUserSigInfo localWUserSigInfo = n.c(paramToServiceMsg.getRequestSsoSeq());
    a(paramToServiceMsg, localWUserSigInfo);
    Object localObject2 = (String)paramToServiceMsg.getAttribute("from_where", null);
    if (paramToServiceMsg.getAttribute("resp_register_supersig") != null) {
      localWUserSigInfo._in_ksid = ((byte[])paramToServiceMsg.getAttribute("resp_register_supersig"));
    }
    long l3 = paramToServiceMsg.getAppId();
    if ((localObject2 != null) && (((String)localObject2).equalsIgnoreCase("ssoAccountAction"))) {
      localWUserSigInfo._login_bitmap = 2;
    } else {
      localWUserSigInfo._login_bitmap = 0;
    }
    localObject2 = paramToServiceMsg.getAttribute("to_login_uin_encrypt");
    if (localObject2 != null) {
      WtloginHelper.setExtraLoginTlvValue(localWUserSigInfo, 1346, (byte[])localObject2);
    }
    localObject2 = paramToServiceMsg.getAttribute("sigSession");
    if (localObject2 != null) {
      WtloginHelper.setExtraLoginTlvValue(localWUserSigInfo, 260, (byte[])localObject2);
    }
    localObject2 = paramToServiceMsg.getAttribute("businessType");
    if ((localObject2 != null) && ((localObject2 instanceof Integer))) {
      localWUserSigInfo.businessType = ((Integer)localObject2).intValue();
    }
    int n = 130;
    long l2 = 16L;
    localObject2 = (String)paramToServiceMsg.getAttribute("process", null);
    int m = n;
    long l1 = l2;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      m = n;
      l1 = l2;
      if (((String)localObject2).equals("com.tencent.mobileqq:openSdk"))
      {
        m = ((Integer)paramToServiceMsg.getAttribute("puzzle_verify_code", Integer.valueOf(0))).intValue();
        l1 = 1600001540L;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("WTLoginCenter login --> CanWebVerify=");
    ((StringBuilder)localObject2).append(m);
    QLog.d("MSF.C.WTLoginCenter", 1, ((StringBuilder)localObject2).toString());
    e.SetCanWebVerify(m);
    localObject2 = new long[0];
    if (com.tencent.mobileqq.msf.core.a.a.aY())
    {
      localObject2 = new long[1];
      localObject2[0] = 1600000226L;
    }
    e.SetUinDeviceToken(true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("login appId = ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" localappid = ");
      localStringBuilder.append(l3);
      QLog.d("MSF.C.WTLoginCenter", 2, localStringBuilder.toString());
    }
    m = e.GetStWithPasswd(paramToServiceMsg.getUin(), l1, 34869344, l3, (long[])localObject2, true, str, localWUserSigInfo, new byte[0][]);
    a(paramToServiceMsg, (p)localObject3, m, "login");
    return m;
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
    WtloginHelper.setQimeiListener(new l.a());
    WtloginHelper.setReportListener(new l.b());
    e = new WtloginHelper(BaseApplication.getContext());
    QLog.d("wtlogin_guid", 1, util.buf_to_string(e.GetGuid()));
    e.SetTimeOut(40000);
    e.SetMsfTransportFlag(1);
    e.setBabyQFlg(true);
    paramMsfCore = new o(paramMsfCore);
    e.SetListener(paramMsfCore);
    NetConnInfoCenter.GUID = e.GetGuid();
    paramMsfCore = util.buf_to_string(NetConnInfoCenter.GUID);
    if (!TextUtils.isEmpty(paramMsfCore)) {
      BaseApplication.getContext().getSharedPreferences("sp_msf_common", 4).edit().putString("msf_guid", paramMsfCore).apply();
    }
  }
  
  public void a(WUserSigInfo paramWUserSigInfo, HashMap paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder("regAddFaceParam analysisExtraMap");
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte1;
    if (paramHashMap != null)
    {
      arrayOfByte1 = (byte[])paramHashMap.get("face_reg_sig");
      arrayOfByte2 = (byte[])paramHashMap.get("face_result");
      paramHashMap = arrayOfByte1;
      arrayOfByte1 = arrayOfByte2;
    }
    else
    {
      localStringBuilder.append(",extraMap = null");
      arrayOfByte1 = null;
      paramHashMap = arrayOfByte2;
    }
    localStringBuilder.append(",byteFaceRegSig = ");
    if (paramHashMap != null)
    {
      localStringBuilder.append(paramHashMap.length);
      WtloginHelper.setExtraRegTlvValue(paramWUserSigInfo, 54, paramHashMap);
    }
    else
    {
      localStringBuilder.append("null");
    }
    localStringBuilder.append(",byteFaceResult = ");
    if (arrayOfByte1 != null)
    {
      localStringBuilder.append(arrayOfByte1.length);
      WtloginHelper.setExtraRegTlvValue(paramWUserSigInfo, 55, arrayOfByte1);
    }
    else
    {
      localStringBuilder.append("null");
    }
    QLog.i("MSF.C.WTLoginCenter", 1, localStringBuilder.toString());
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
      int m = a(paramToServiceMsg, e);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeTokenAfterLogin checkIsNeedLoginWithPasswd ");
      localStringBuilder.append(m);
      localStringBuilder.append(" process:");
      localStringBuilder.append(u.b(paramToServiceMsg));
      localStringBuilder.append(" cmd:");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      QLog.d("MSF.C.WTLoginCenter", 1, localStringBuilder.toString());
      if (m != -1)
      {
        if (m != 0)
        {
          if (m != 1) {
            return 0;
          }
          return a(paramToServiceMsg, false, null, paramBoolean);
        }
        return a(paramToServiceMsg, true, d.getAccountCenter().l(paramToServiceMsg.getUin()), paramBoolean);
      }
      a(paramToServiceMsg, "changeTokenAfterLogin");
      return -1;
    }
    catch (Exception paramToServiceMsg)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeTokenAfterLogin error ");
      localStringBuilder.append(paramToServiceMsg.toString());
      QLog.e("MSF.C.WTLoginCenter", 1, localStringBuilder.toString(), paramToServiceMsg);
    }
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
      localObject = com.tencent.mobileqq.msf.core.a.a.bg();
      if (localObject == null)
      {
        QLog.d("MSF.C.WTLoginCenter", 1, "check ps, dons is empty!");
        return false;
      }
      Iterator localIterator = ((HashSet)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        byte[] arrayOfByte = (byte[])paramString._pskey_map.get(localObject);
        if ((arrayOfByte == null) || (arrayOfByte.length == 0))
        {
          paramString = new StringBuilder();
          paramString.append("check ps, ");
          paramString.append((String)localObject);
          paramString.append(" is empty!");
          QLog.d("MSF.C.WTLoginCenter", 1, paramString.toString());
          return true;
        }
      }
      return false;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get ticket failed, PSKEY, exception: ");
      ((StringBuilder)localObject).append(paramString.toString());
      QLog.d("MSF.C.WTLoginCenter", 1, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public int c(ToServiceMsg paramToServiceMsg)
  {
    Object localObject = (byte[])paramToServiceMsg.getAttributes().get("to_login_pwd");
    String str;
    try
    {
      localObject = new String((byte[])localObject, "ISO-8859-1");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      str = "";
    }
    p localp = n.a(d, paramToServiceMsg);
    localp.a = true;
    localp.h = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = new WUserSigInfo();
    localWUserSigInfo._reserveData = MsfSdkUtils.convertInt2Bytes(paramToServiceMsg.getRequestSsoSeq());
    int m = e.GetStWithPasswd(paramToServiceMsg.getUin(), 16L, 0, 1600000749L, new long[0], true, str, localWUserSigInfo, new byte[0][]);
    a(paramToServiceMsg, localp, m, "verifyPasswd");
    return m;
  }
  
  /* Error */
  public HashMap c(String paramString)
  {
    // Byte code:
    //   0: getstatic 131	com/tencent/mobileqq/msf/core/auth/l:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   3: aload_1
    //   4: ldc2_w 11
    //   7: bipush 64
    //   9: invokevirtual 724	oicq/wlogin_sdk/request/WtloginHelper:GetLocalTicket	(Ljava/lang/String;JI)Loicq/wlogin_sdk/request/Ticket;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnull +20 -> 34
    //   17: aload_2
    //   18: getfield 904	oicq/wlogin_sdk/request/Ticket:_sig	[B
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull +11 -> 34
    //   26: aload_2
    //   27: invokestatic 909	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   30: astore_2
    //   31: goto +5 -> 36
    //   34: aconst_null
    //   35: astore_2
    //   36: getstatic 131	com/tencent/mobileqq/msf/core/auth/l:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   39: aload_1
    //   40: ldc2_w 11
    //   43: sipush 4096
    //   46: invokevirtual 724	oicq/wlogin_sdk/request/WtloginHelper:GetLocalTicket	(Ljava/lang/String;JI)Loicq/wlogin_sdk/request/Ticket;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull +24 -> 75
    //   54: aload_3
    //   55: getfield 904	oicq/wlogin_sdk/request/Ticket:_sig	[B
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull +15 -> 75
    //   63: new 82	java/lang/String
    //   66: dup
    //   67: aload_3
    //   68: invokespecial 912	java/lang/String:<init>	([B)V
    //   71: astore_3
    //   72: goto +5 -> 77
    //   75: aconst_null
    //   76: astore_3
    //   77: getstatic 131	com/tencent/mobileqq/msf/core/auth/l:e	Loicq/wlogin_sdk/request/WtloginHelper;
    //   80: aload_1
    //   81: ldc2_w 11
    //   84: bipush 32
    //   86: invokevirtual 724	oicq/wlogin_sdk/request/WtloginHelper:GetLocalTicket	(Ljava/lang/String;JI)Loicq/wlogin_sdk/request/Ticket;
    //   89: astore 6
    //   91: aload_2
    //   92: astore 4
    //   94: aload_3
    //   95: astore 5
    //   97: aload 6
    //   99: ifnull +60 -> 159
    //   102: aload 6
    //   104: getfield 904	oicq/wlogin_sdk/request/Ticket:_sig	[B
    //   107: astore 6
    //   109: aload_2
    //   110: astore 4
    //   112: aload_3
    //   113: astore 5
    //   115: aload 6
    //   117: ifnull +42 -> 159
    //   120: aload 6
    //   122: invokestatic 909	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   125: astore 5
    //   127: goto +43 -> 170
    //   130: astore 4
    //   132: goto +16 -> 148
    //   135: astore 4
    //   137: aconst_null
    //   138: astore_3
    //   139: goto +9 -> 148
    //   142: astore 4
    //   144: aconst_null
    //   145: astore_3
    //   146: aload_3
    //   147: astore_2
    //   148: aload 4
    //   150: invokevirtual 352	java/lang/Exception:printStackTrace	()V
    //   153: aload_3
    //   154: astore 5
    //   156: aload_2
    //   157: astore 4
    //   159: aconst_null
    //   160: astore_2
    //   161: aload 5
    //   163: astore_3
    //   164: aload_2
    //   165: astore 5
    //   167: aload 4
    //   169: astore_2
    //   170: new 98	java/util/HashMap
    //   173: dup
    //   174: invokespecial 913	java/util/HashMap:<init>	()V
    //   177: astore 4
    //   179: aload 4
    //   181: ldc_w 915
    //   184: aload_1
    //   185: invokevirtual 919	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   188: pop
    //   189: aload 4
    //   191: ldc_w 921
    //   194: aload_2
    //   195: invokevirtual 919	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   198: pop
    //   199: aload 4
    //   201: ldc_w 923
    //   204: aconst_null
    //   205: invokevirtual 919	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   208: pop
    //   209: aload 4
    //   211: ldc_w 925
    //   214: aload_3
    //   215: invokevirtual 919	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   218: pop
    //   219: aload 4
    //   221: ldc_w 927
    //   224: aconst_null
    //   225: invokevirtual 919	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   228: pop
    //   229: aload 4
    //   231: ldc_w 929
    //   234: aload 5
    //   236: invokevirtual 919	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   239: pop
    //   240: aload 4
    //   242: ldc_w 931
    //   245: aconst_null
    //   246: invokevirtual 919	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   249: pop
    //   250: aload 4
    //   252: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	l
    //   0	253	1	paramString	String
    //   12	183	2	localObject1	Object
    //   49	166	3	localObject2	Object
    //   92	19	4	localObject3	Object
    //   130	1	4	localException1	Exception
    //   135	1	4	localException2	Exception
    //   142	7	4	localException3	Exception
    //   157	94	4	localObject4	Object
    //   95	140	5	localObject5	Object
    //   89	32	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   77	91	130	java/lang/Exception
    //   102	109	130	java/lang/Exception
    //   120	127	130	java/lang/Exception
    //   36	50	135	java/lang/Exception
    //   54	59	135	java/lang/Exception
    //   63	72	135	java/lang/Exception
    //   0	13	142	java/lang/Exception
    //   17	22	142	java/lang/Exception
    //   26	31	142	java/lang/Exception
  }
  
  public int d(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    a(paramToServiceMsg, localWUserSigInfo);
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
    a(paramToServiceMsg, localWUserSigInfo);
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
    a(paramToServiceMsg, localWUserSigInfo);
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
    long l1 = ((Long)paramToServiceMsg.getAttributes().get("appid")).longValue();
    String str3 = (String)paramToServiceMsg.getAttribute("To_register_captcha_sig", null);
    Object localObject1 = (String)paramToServiceMsg.getAttributes().get("wifi_mac");
    Object localObject2 = (String)paramToServiceMsg.getAttributes().get("os_language");
    int m = ((Integer)paramToServiceMsg.getAttributes().get("qq_language")).intValue();
    Object localObject3 = (String)paramToServiceMsg.getAttributes().get("gps_location");
    Object localObject4 = e;
    WtloginHelper.setSecTransInfo((String)localObject1, (String)localObject2, m, (String)localObject3);
    localObject1 = n.a(d, paramToServiceMsg);
    n.a(paramToServiceMsg);
    localObject2 = n.b(paramToServiceMsg.getRequestSsoSeq());
    ((WUserSigInfo)localObject2)._seqence = ((p)localObject1).f;
    localObject3 = e;
    WtloginHelper.setRegisterFlg(68);
    localObject3 = (String)paramToServiceMsg.getAttribute("To_register_Invitation_code", null);
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("RegSubmitMobile|invitation= ");
        ((StringBuilder)localObject4).append((String)localObject3);
        QLog.d("MSF.C.WTLoginCenter", 2, ((StringBuilder)localObject4).toString());
      }
      WtloginHelper.setExtraRegTlvValue((WUserSigInfo)localObject2, 49, ((String)localObject3).getBytes());
    }
    localObject3 = (HashMap)paramToServiceMsg.getAttributes().get("To_register_map_param");
    a((WUserSigInfo)localObject2, (HashMap)localObject3);
    m = e.RegSubmitMobile(str3, str2.getBytes(), str1.getBytes(), localByte1.byteValue(), localByte2.byteValue(), localByte3.byteValue(), 16L, l1, (WUserSigInfo)localObject2, (Map)localObject3);
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
    if ((paramToServiceMsg.getAttributes().containsKey("To_register_type")) && (!((Boolean)paramToServiceMsg.getAttributes().get("To_register_type")).booleanValue())) {
      m = 5;
    } else {
      m = 1;
    }
    p localp = n.a(d, paramToServiceMsg);
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    String str4 = (String)paramToServiceMsg.getAttributes().get("To_register_lh_uin");
    Object localObject = (String)paramToServiceMsg.getAttributes().get("To_register_unbind_lh_uin");
    String str5 = (String)paramToServiceMsg.getAttributes().get("to_register_cr_appVersion");
    if (!TextUtils.isEmpty(str4))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("RegGetAccount|lhUin= ");
        ((StringBuilder)localObject).append(str4);
        QLog.d("MSF.C.WTLoginCenter", 2, ((StringBuilder)localObject).toString());
      }
      a(localWUserSigInfo, 46, str4);
    }
    else if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("RegGetAccount|unBindUin= ");
        localStringBuilder.append(str4);
        QLog.d("MSF.C.WTLoginCenter", 2, localStringBuilder.toString());
      }
      a(localWUserSigInfo, 47, (String)localObject);
    }
    a(localWUserSigInfo, (HashMap)paramToServiceMsg.getAttributes().get("To_register_map_param"));
    int m = e.RegGetAccount(str1.getBytes(), "qqpassport".getBytes(), str2.getBytes(), str3.getBytes(), str5.getBytes(), m, localWUserSigInfo);
    a(paramToServiceMsg, localp, m, "RegGetAccount");
    return m;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WTLoiginCenter|checkQuickRegister : account= ");
      localStringBuilder.append(str1);
      localStringBuilder.append(",subAppId = ");
      localStringBuilder.append(m);
      localStringBuilder.append(",appVer=");
      localStringBuilder.append(str2);
      QLog.d("Login_Optimize_Center", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WTLoiginCenter|getQuickRegisterAccount : account= ");
      localStringBuilder.append(str1);
      localStringBuilder.append(",nick= ");
      localStringBuilder.append(str3);
      localStringBuilder.append(",subAppId = ");
      localStringBuilder.append(m);
      localStringBuilder.append(",appVer=");
      localStringBuilder.append(str4);
      QLog.d("Login_Optimize_Center", 2, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("wt_GetOpenKeyWithoutPasswd uin=");
      ((StringBuilder)localObject).append(paramToServiceMsg.getUin());
      ((StringBuilder)localObject).append(" dwSrcAppid=");
      ((StringBuilder)localObject).append(paramToServiceMsg.getAttribute("dwSrcAppid"));
      ((StringBuilder)localObject).append(" dwDstAppid=");
      ((StringBuilder)localObject).append(paramToServiceMsg.getAttribute("dwDstAppid"));
      ((StringBuilder)localObject).append(" sigInfo=");
      ((StringBuilder)localObject).append(localWUserSigInfo);
      QLog.d("MSF.C.WTLoginCenter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (String)paramToServiceMsg.getAttribute("from_where", null);
    a(paramToServiceMsg, localp, e.GetOpenKeyWithoutPasswd(paramToServiceMsg.getUin(), ((Long)paramToServiceMsg.getAttribute("dwSrcAppid")).longValue(), ((Long)paramToServiceMsg.getAttribute("dwDstAppid")).longValue(), 36864, localWUserSigInfo), "wt_GetOpenKeyWithoutPasswd");
  }
  
  public void q(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    a(paramToServiceMsg, localWUserSigInfo);
    long l1 = paramToServiceMsg.getAppId();
    long l2 = ((Long)paramToServiceMsg.getAttribute("dwSrcAppid")).longValue();
    long l3 = ((Long)paramToServiceMsg.getAttribute("dwDstAppid")).longValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("wt_GetStWithoutPasswd dwSrcppid = ");
      localStringBuilder.append(l2);
      localStringBuilder.append(" dwDstAppid = ");
      localStringBuilder.append(l3);
      localStringBuilder.append(" localappid = ");
      localStringBuilder.append(l1);
      QLog.d("MSF.C.WTLoginCenter", 2, localStringBuilder.toString());
    }
    a(paramToServiceMsg, localp, e.GetStWithoutPasswd(paramToServiceMsg.getUin(), l2, l3, l1, 34869344, localWUserSigInfo), "wt_GetStWithoutPasswd");
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
    long l1 = ((Long)paramToServiceMsg.getAttribute("dwSrcAppid")).longValue();
    long l2 = ((Long)paramToServiceMsg.getAttribute("dwSubSrcAppid")).longValue();
    long l3 = ((Long)paramToServiceMsg.getAttribute("dwDstAppid")).longValue();
    long l4 = ((Long)paramToServiceMsg.getAttribute("dwSubDstAppid")).longValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("wt_GetA1WithA1 dwSrcppid = ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" dwSubSrcAppid = ");
      localStringBuilder.append(l2);
      localStringBuilder.append(" dwDstAppid = ");
      localStringBuilder.append(l3);
      localStringBuilder.append(" dwSubDstAppid = ");
      localStringBuilder.append(l4);
      QLog.d("MSF.C.WTLoginCenter", 2, localStringBuilder.toString());
    }
    a(paramToServiceMsg, localp, e.GetA1WithA1(paramToServiceMsg.getUin(), l1, l2, (byte[])paramToServiceMsg.getAttribute("dstAppName"), ((Long)paramToServiceMsg.getAttribute("dwDstSsoVer")).longValue(), l3, l4, (byte[])paramToServiceMsg.getAttribute("dstAppVer"), (byte[])paramToServiceMsg.getAttribute("dstAppSign"), localWUserSigInfo, (WFastLoginInfo)paramToServiceMsg.getAttribute("fastLoginInfo")), "wt_GetA1WithA1");
  }
  
  public void y(ToServiceMsg paramToServiceMsg)
  {
    p localp = n.a(d, paramToServiceMsg);
    localp.g = true;
    n.a(paramToServiceMsg);
    WUserSigInfo localWUserSigInfo = n.b(paramToServiceMsg.getRequestSsoSeq());
    localWUserSigInfo._seqence = localp.f;
    a(paramToServiceMsg, localWUserSigInfo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.l
 * JD-Core Version:    0.7.0.1
 */