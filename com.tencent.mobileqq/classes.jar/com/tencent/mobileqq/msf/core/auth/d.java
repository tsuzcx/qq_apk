package com.tencent.mobileqq.msf.core.auth;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import oicq.wlogin_sdk.request.WtloginHelper;

public class d
{
  public static final int a = 604800000;
  public static final int b = 21600000;
  public static final int c = 1800000;
  public static final int d = 1000;
  public static ConcurrentHashMap f = new ConcurrentHashMap();
  public static final String g = "_new_version_never_change_token";
  public static boolean h = true;
  private static final String i = "MSF.C.TokenChecker";
  private static final String j = "_lastchecktokentime";
  private static final int k = 1800000;
  private static long l = -1L;
  private static int m = 5;
  private static Handler n;
  b e;
  
  public d(b paramb)
  {
    this.e = paramb;
    n = q.b();
    h = TextUtils.isEmpty(MsfStore.getNativeConfigStore().getConfig("_new_version_never_change_token")) ^ true;
    if (!h) {
      MsfStore.getNativeConfigStore().n_setConfig("_lastchecktokentime", String.valueOf(0));
    }
    QLog.d("MSF.C.TokenChecker", 1, "msf init ct");
  }
  
  private long b(String paramString)
  {
    long l2 = this.e.a.getWtLoginCenter().a(paramString, 64);
    long l3 = this.e.a.getWtLoginCenter().a(paramString, 262144);
    long l1 = l2;
    if (l2 > l3) {
      l1 = l3;
    }
    return l1;
  }
  
  private long c(String paramString)
  {
    long l2 = this.e.a.getWtLoginCenter().a(paramString, 4096);
    long l4 = this.e.a.getWtLoginCenter().a(paramString, 32);
    long l3 = this.e.a.getWtLoginCenter().a(paramString, 1048576);
    long l1 = l2;
    if (l2 > l4) {
      l1 = l4;
    }
    l2 = l1;
    if (l1 > l3) {
      l2 = l3;
    }
    return l2;
  }
  
  private long d()
  {
    long l1;
    try
    {
      int i1 = new Random(SystemClock.elapsedRealtime()).nextInt(1800000);
      l1 = i1 - 900000;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      l1 = 0L;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RandomRevise: ");
      localStringBuilder.append(l1);
      QLog.d("MSF.C.TokenChecker", 4, localStringBuilder.toString());
    }
    return l1;
  }
  
  private long d(String paramString)
  {
    long l2 = this.e.a.getWtLoginCenter().b(paramString, 4096);
    long l4 = this.e.a.getWtLoginCenter().b(paramString, 32);
    long l3 = this.e.a.getWtLoginCenter().b(paramString, 1048576);
    long l1 = l2;
    if (l2 > l4) {
      l1 = l4;
    }
    l2 = l1;
    if (l1 > l3) {
      l2 = l3;
    }
    return l2;
  }
  
  private long e()
  {
    long l1;
    try
    {
      int i1 = new Random(SystemClock.elapsedRealtime()).nextInt(1800000);
      l1 = i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      l1 = 0L;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WebRandomRevise: ");
      localStringBuilder.append(l1);
      QLog.d("MSF.C.TokenChecker", 4, localStringBuilder.toString());
    }
    return l1;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l;
    Object localObject;
    if (l2 == -1L)
    {
      localObject = MsfStore.getNativeConfigStore().getConfig("_lastchecktokentime");
      if (localObject != null)
      {
        l = Long.parseLong((String)localObject);
        l2 = l;
        if ((l1 < l2) || (l1 - l2 >= com.tencent.mobileqq.msf.core.a.a.E())) {}
      }
    }
    else if ((l1 >= l2) && (l1 - l2 < com.tencent.mobileqq.msf.core.a.a.E()))
    {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doCheck, lastCheckTime=");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(", now=");
      ((StringBuilder)localObject).append(l1);
      QLog.d("MSF.C.TokenChecker", 2, ((StringBuilder)localObject).toString());
    }
    l = l1;
    MsfStore.getNativeConfigStore().n_setConfig("_lastchecktokentime", String.valueOf(l1));
    b();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      String str = paramFromServiceMsg.getUin();
      paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
      if (!paramFromServiceMsg.isSuccess())
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("onChangeTokenResult fail, uin=");
          paramToServiceMsg.append(str);
          paramToServiceMsg.append(", errorcode=");
          paramToServiceMsg.append(paramFromServiceMsg.getBusinessFailCode());
          QLog.w("MSF.C.TokenChecker", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (paramToServiceMsg.equals("login.chgTok_A2D2"))
      {
        paramToServiceMsg = (RespondCustomSig)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd());
        if (paramToServiceMsg != null)
        {
          Object localObject = paramToServiceMsg.SigList.iterator();
          byte[] arrayOfByte = null;
          paramToServiceMsg = arrayOfByte;
          paramFromServiceMsg = paramToServiceMsg;
          while (((Iterator)localObject).hasNext())
          {
            CustomSigContent localCustomSigContent = (CustomSigContent)((Iterator)localObject).next();
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("onChangeTokenResult, content.ulSigType=");
              localStringBuilder.append(localCustomSigContent.ulSigType);
              localStringBuilder.append(", uin=");
              localStringBuilder.append(str);
              QLog.d("MSF.C.TokenChecker", 2, localStringBuilder.toString());
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("iSimplified for ");
            localStringBuilder.append(MsfSdkUtils.getShortUin(str));
            QLog.d("MSF.C.TokenChecker", 1, localStringBuilder.toString());
            if (localCustomSigContent.ulSigType == 0L) {
              arrayOfByte = localCustomSigContent.SigContent;
            } else if (localCustomSigContent.ulSigType == 18L) {
              paramToServiceMsg = localCustomSigContent.SigContent;
            } else if (localCustomSigContent.ulSigType == 20L) {
              paramFromServiceMsg = localCustomSigContent.SigContent;
            }
          }
          if ((arrayOfByte != null) && (paramToServiceMsg != null) && (paramFromServiceMsg != null))
          {
            long l1 = System.currentTimeMillis();
            if (l1 - this.e.l(str).z() > 1800000L)
            {
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("renew A2 D2 succ, uin=");
                ((StringBuilder)localObject).append(str);
                QLog.d("MSF.C.TokenChecker", 2, ((StringBuilder)localObject).toString());
              }
              this.e.a(str, arrayOfByte, paramToServiceMsg, paramFromServiceMsg, l1);
              if (com.tencent.mobileqq.msf.core.a.a.l())
              {
                paramToServiceMsg = new StringBuilder();
                paramToServiceMsg.append("reloadkey add uin:");
                paramToServiceMsg.append(MsfSdkUtils.getShortUin(str));
                QLog.d("MSF.C.TokenChecker", 1, paramToServiceMsg.toString());
                f.put(str, Boolean.valueOf(true));
                return;
              }
              paramToServiceMsg = new StringBuilder();
              paramToServiceMsg.append("give up reloading key for uin:");
              paramToServiceMsg.append(MsfSdkUtils.getShortUin(str));
              QLog.d("MSF.C.TokenChecker", 1, paramToServiceMsg.toString());
            }
          }
        }
      }
      else if (paramToServiceMsg.equals("login.chgTok_WEBVIEW_KEY"))
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("RENEW webview key succ for ");
        paramToServiceMsg.append(MsfSdkUtils.getShortUin(str));
        QLog.d("MSF.C.TokenChecker", 1, paramToServiceMsg.toString());
      }
    }
  }
  
  void a(String paramString)
  {
    if (this.e.g(paramString)) {
      q.b().postAtFrontOfQueue(new i(this, paramString));
    }
  }
  
  public void b()
  {
    n.post(new e(this));
  }
  
  void c()
  {
    long l3 = System.currentTimeMillis();
    Object localObject2 = this.e.d();
    Object localObject1 = new ArrayList();
    boolean bool1 = com.tencent.mobileqq.msf.core.a.a.aj();
    Object localObject4 = "MSF.C.TokenChecker";
    Object localObject3 = localObject2;
    int i1;
    int i2;
    if (bool1)
    {
      Iterator localIterator = ((ArrayList)localObject2).iterator();
      localObject2 = null;
      while (localIterator.hasNext())
      {
        localObject3 = (SimpleAccount)localIterator.next();
        if (((SimpleAccount)localObject3).isLogined()) {
          ((List)localObject1).add(localObject3);
        }
        if (((SimpleAccount)localObject3).getUin().equals(this.e.i())) {
          localObject2 = localObject3;
        }
      }
      if (((List)localObject1).size() > 0)
      {
        Collections.sort((List)localObject1, new f(this));
        i1 = ((List)localObject1).size();
        i2 = m;
        if (i1 > i2) {
          localObject1 = ((List)localObject1).subList(0, i2);
        }
        localObject3 = localObject1;
        if (localObject2 != null)
        {
          localObject3 = localObject1;
          if (!((List)localObject1).contains(localObject2))
          {
            ((List)localObject1).remove(((List)localObject1).size() - 1);
            ((List)localObject1).add(localObject2);
            localObject3 = localObject1;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.TokenChecker", 2, "checkToken, no active account");
        }
        return;
      }
    }
    localObject2 = ((List)localObject3).iterator();
    localObject1 = localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((SimpleAccount)((Iterator)localObject2).next()).getUin();
      if (this.e.g((String)localObject3))
      {
        long l4 = b((String)localObject3);
        long l2 = com.tencent.mobileqq.msf.core.a.a.ah();
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = 604800000L;
        }
        if (l3 - l4 > l1 + d())
        {
          localObject4 = new g(this, (String)localObject3);
          l1 = e();
          n.postDelayed((Runnable)localObject4, l1);
          i1 = 1;
        }
        else
        {
          i1 = 0;
        }
        l4 = d((String)localObject3);
        long l5 = c((String)localObject3);
        l2 = com.tencent.mobileqq.msf.core.a.a.ai();
        l1 = l2;
        if (l2 <= 0L) {
          l1 = 21600000L;
        }
        if ((TextUtils.isEmpty(m.a((String)localObject3))) && (!l.e.IsNeedLoginWithPasswd((String)localObject3, 16L).booleanValue())) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        if ((h) && (l3 - l5 <= l1) && (!this.e.a.getWtLoginCenter().b((String)localObject3)) && (i2 == 0)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        l.e.SetUinDeviceToken(true);
        boolean bool2;
        if (l3 > l4 - 1800000L) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("checkToken for ");
        ((StringBuilder)localObject4).append(MsfSdkUtils.getShortUin((String)localObject3));
        ((StringBuilder)localObject4).append(" now: ");
        ((StringBuilder)localObject4).append(l3);
        ((StringBuilder)localObject4).append(" lastCheckWebviewKeyTime: ");
        ((StringBuilder)localObject4).append(l5);
        ((StringBuilder)localObject4).append(" needChangeToken: ");
        ((StringBuilder)localObject4).append(bool1);
        ((StringBuilder)localObject4).append(" isInstant:");
        ((StringBuilder)localObject4).append(bool2);
        localObject4 = ((StringBuilder)localObject4).toString();
        QLog.d((String)localObject1, 1, (String)localObject4);
        if (bool1)
        {
          localObject4 = new h(this, (String)localObject3);
          l1 = e();
          n.postDelayed((Runnable)localObject4, l1);
          QLog.d((String)localObject1, 1, new Object[] { "checkToken renew webKey for ", MsfSdkUtils.getShortUin((String)localObject3), " isNewVersion: ", Boolean.valueOf(h), " delayTime: ", Long.valueOf(l1) });
        }
      }
      else
      {
        i1 = 0;
      }
      if (i1 != 0) {
        try
        {
          Thread.sleep(com.tencent.mobileqq.msf.core.a.a.F());
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
    }
    h = true;
    MsfStore.getNativeConfigStore().n_setConfig("_new_version_never_change_token", String.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.d
 * JD-Core Version:    0.7.0.1
 */