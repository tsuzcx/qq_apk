package com.tencent.mobileqq.msf.core.auth;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.u;
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
    n = u.b();
    if (!TextUtils.isEmpty(MsfStore.getNativeConfigStore().getConfig("_new_version_never_change_token"))) {}
    for (boolean bool = true;; bool = false)
    {
      h = bool;
      if (!h) {
        MsfStore.getNativeConfigStore().n_setConfig("_lastchecktokentime", String.valueOf(0));
      }
      QLog.d("MSF.C.TokenChecker", 1, "msf init ct");
      return;
    }
  }
  
  private long b(String paramString)
  {
    long l1 = this.e.a.getWtLoginCenter().a(paramString, 64);
    long l2 = this.e.a.getWtLoginCenter().a(paramString, 262144);
    if (l1 > l2) {
      return l2;
    }
    return l1;
  }
  
  private long c(String paramString)
  {
    long l1 = this.e.a.getWtLoginCenter().a(paramString, 4096);
    long l2 = this.e.a.getWtLoginCenter().a(paramString, 32);
    long l3 = this.e.a.getWtLoginCenter().a(paramString, 1048576);
    if (l1 > l2) {
      l1 = l2;
    }
    while (l1 > l3) {
      return l3;
    }
    return l1;
  }
  
  private long d()
  {
    long l1 = 0L;
    try
    {
      int i1 = new Random(SystemClock.elapsedRealtime()).nextInt(1800000);
      l1 = i1 - 900000;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.TokenChecker", 4, "RandomRevise: " + l1);
    }
    return l1;
  }
  
  private long d(String paramString)
  {
    long l1 = this.e.a.getWtLoginCenter().b(paramString, 4096);
    long l2 = this.e.a.getWtLoginCenter().b(paramString, 32);
    long l3 = this.e.a.getWtLoginCenter().b(paramString, 1048576);
    if (l1 > l2) {
      l1 = l2;
    }
    while (l1 > l3) {
      return l3;
    }
    return l1;
  }
  
  private long e()
  {
    long l1 = 0L;
    try
    {
      int i1 = new Random(SystemClock.elapsedRealtime()).nextInt(1800000);
      l1 = i1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.TokenChecker", 4, "WebRandomRevise: " + l1);
    }
    return l1;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    if (l == -1L)
    {
      str = MsfStore.getNativeConfigStore().getConfig("_lastchecktokentime");
      if (str != null)
      {
        l = Long.parseLong(str);
        if ((l1 < l) || (l1 - l >= com.tencent.mobileqq.msf.core.a.a.E())) {}
      }
    }
    else
    {
      while ((l1 >= l) && (l1 - l < com.tencent.mobileqq.msf.core.a.a.E()))
      {
        String str;
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.TokenChecker", 2, "doCheck, lastCheckTime=" + l + ", now=" + l1);
    }
    l = l1;
    MsfStore.getNativeConfigStore().n_setConfig("_lastchecktokentime", String.valueOf(l1));
    b();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = null;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      long l1;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              str = paramFromServiceMsg.getUin();
              paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
              if (paramFromServiceMsg.isSuccess()) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.w("MSF.C.TokenChecker", 2, "onChangeTokenResult fail, uin=" + str + ", errorcode=" + paramFromServiceMsg.getBusinessFailCode());
            return;
            if (!paramToServiceMsg.equals("login.chgTok_A2D2")) {
              break;
            }
            paramToServiceMsg = (RespondCustomSig)paramFromServiceMsg.getAttribute(paramFromServiceMsg.getServiceCmd());
          } while (paramToServiceMsg == null);
          Iterator localIterator = paramToServiceMsg.SigList.iterator();
          paramFromServiceMsg = null;
          CustomSigContent localCustomSigContent = null;
          paramToServiceMsg = (ToServiceMsg)localObject;
          localObject = localCustomSigContent;
          while (localIterator.hasNext())
          {
            localCustomSigContent = (CustomSigContent)localIterator.next();
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.TokenChecker", 2, "onChangeTokenResult, content.ulSigType=" + localCustomSigContent.ulSigType + ", uin=" + str);
            }
            QLog.d("MSF.C.TokenChecker", 1, "iSimplified for " + MsfSdkUtils.getShortUin(str));
            if (localCustomSigContent.ulSigType == 0L) {
              localObject = localCustomSigContent.SigContent;
            } else if (localCustomSigContent.ulSigType == 18L) {
              paramFromServiceMsg = localCustomSigContent.SigContent;
            } else if (localCustomSigContent.ulSigType == 20L) {
              paramToServiceMsg = localCustomSigContent.SigContent;
            }
          }
        } while ((localObject == null) || (paramFromServiceMsg == null) || (paramToServiceMsg == null));
        l1 = System.currentTimeMillis();
      } while (l1 - this.e.l(str).z() <= 1800000L);
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.TokenChecker", 2, "renew A2 D2 succ, uin=" + str);
      }
      this.e.a(str, (byte[])localObject, paramFromServiceMsg, paramToServiceMsg, l1);
      if (com.tencent.mobileqq.msf.core.a.a.l())
      {
        QLog.d("MSF.C.TokenChecker", 1, "reloadkey add uin:" + MsfSdkUtils.getShortUin(str));
        f.put(str, Boolean.valueOf(true));
        return;
      }
      QLog.d("MSF.C.TokenChecker", 1, "give up reloading key for uin:" + MsfSdkUtils.getShortUin(str));
      return;
    } while (!paramToServiceMsg.equals("login.chgTok_WEBVIEW_KEY"));
    QLog.d("MSF.C.TokenChecker", 1, "RENEW webview key succ for " + MsfSdkUtils.getShortUin(str));
  }
  
  void a(String paramString)
  {
    if (this.e.g(paramString)) {
      u.b().postAtFrontOfQueue(new i(this, paramString));
    }
  }
  
  public void b()
  {
    n.post(new e(this));
  }
  
  void c()
  {
    long l3 = System.currentTimeMillis();
    Object localObject1 = null;
    Object localObject4 = this.e.d();
    Object localObject2 = new ArrayList();
    Object localObject3 = localObject4;
    if (com.tencent.mobileqq.msf.core.a.a.aj())
    {
      localObject4 = ((ArrayList)localObject4).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        localObject3 = (SimpleAccount)((Iterator)localObject4).next();
        if (((SimpleAccount)localObject3).isLogined()) {
          ((List)localObject2).add(localObject3);
        }
        if (!((SimpleAccount)localObject3).getUin().equals(this.e.i())) {
          break label707;
        }
        localObject1 = localObject3;
      }
    }
    label395:
    label436:
    label694:
    label699:
    label702:
    label704:
    label707:
    for (;;)
    {
      break;
      if (((List)localObject2).size() > 0)
      {
        Collections.sort((List)localObject2, new f(this));
        if (((List)localObject2).size() <= m) {
          break label704;
        }
        localObject2 = ((List)localObject2).subList(0, m);
      }
      for (;;)
      {
        localObject3 = localObject2;
        if (localObject1 != null)
        {
          localObject3 = localObject2;
          if (!((List)localObject2).contains(localObject1))
          {
            ((List)localObject2).remove(((List)localObject2).size() - 1);
            ((List)localObject2).add(localObject1);
            localObject3 = localObject2;
          }
        }
        localObject1 = ((List)localObject3).iterator();
        for (;;)
        {
          int i1;
          label330:
          boolean bool1;
          boolean bool2;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((SimpleAccount)((Iterator)localObject1).next()).getUin();
            if (!this.e.g((String)localObject2)) {
              break label699;
            }
            long l4 = b((String)localObject2);
            long l2 = com.tencent.mobileqq.msf.core.a.a.ah();
            long l1 = l2;
            if (l2 <= 0L) {
              l1 = 604800000L;
            }
            if (l3 - l4 <= l1 + d()) {
              break label694;
            }
            i1 = 1;
            localObject3 = new g(this, (String)localObject2);
            l1 = e();
            n.postDelayed((Runnable)localObject3, l1);
            l4 = d((String)localObject2);
            long l5 = c((String)localObject2);
            l2 = com.tencent.mobileqq.msf.core.a.a.ai();
            l1 = l2;
            if (l2 <= 0L) {
              l1 = 21600000L;
            }
            if ((TextUtils.isEmpty(m.a((String)localObject2))) && (!l.e.IsNeedLoginWithPasswd((String)localObject2, 16L).booleanValue()))
            {
              i2 = 1;
              if ((h) && (l3 - l5 <= l1) && (!this.e.a.getWtLoginCenter().b((String)localObject2)) && (i2 == 0)) {
                break label665;
              }
              bool1 = true;
              l.e.SetUinDeviceToken(true);
              if (l3 <= l4 - 1800000L) {
                break label671;
              }
              bool2 = true;
              label458:
              QLog.d("MSF.C.TokenChecker", 1, "checkToken for " + MsfSdkUtils.getShortUin((String)localObject2) + " now: " + l3 + " lastCheckWebviewKeyTime: " + l5 + " needChangeToken: " + bool1 + " isInstant:" + bool2);
              i2 = i1;
              if (bool1)
              {
                localObject3 = new h(this, (String)localObject2);
                l1 = e();
                n.postDelayed((Runnable)localObject3, l1);
                QLog.d("MSF.C.TokenChecker", 1, new Object[] { "checkToken renew webKey for ", MsfSdkUtils.getShortUin((String)localObject2), " isNewVersion: ", Boolean.valueOf(h), " delayTime: ", Long.valueOf(l1) });
              }
            }
          }
          for (int i2 = i1;; i2 = 0)
          {
            for (;;)
            {
              if (i2 == 0) {
                break label702;
              }
              try
              {
                Thread.sleep(com.tencent.mobileqq.msf.core.a.a.F());
              }
              catch (Throwable localThrowable)
              {
                localThrowable.printStackTrace();
              }
            }
            break;
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.TokenChecker", 2, "checkToken, no active account");
            }
            return;
            i2 = 0;
            break label395;
            bool1 = false;
            break label436;
            bool2 = false;
            break label458;
            h = true;
            MsfStore.getNativeConfigStore().n_setConfig("_new_version_never_change_token", String.valueOf(true));
            return;
            i1 = 0;
            break label330;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.d
 * JD-Core Version:    0.7.0.1
 */