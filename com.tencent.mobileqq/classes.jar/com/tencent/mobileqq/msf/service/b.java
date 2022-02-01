package com.tencent.mobileqq.msf.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.c.f.a;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

class b
  extends Thread
{
  private static final String e = "MSF.S.AppProcessManager";
  private static final int f = 4;
  private static final int g = 4;
  private static final long h = 0L;
  private static final long[] i = { 20L, 60L, 100L };
  private static final String j = "sleep_by_ipc_block_time";
  private static final int l = 10;
  volatile Object a = new Object();
  volatile boolean b = false;
  volatile boolean c = true;
  int d = 0;
  private long k;
  
  b()
  {
    b();
  }
  
  private void a(MsfMessagePair paramMsfMessagePair, int paramInt1, int paramInt2, int paramInt3, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    if (paramMsfMessagePair.toServiceMsg == null)
    {
      if (paramInt1 == 0)
      {
        paramIMsfServiceCallbacker.onReceiveFirstPkgPushResp(paramMsfMessagePair.fromServiceMsg, paramInt1, paramInt2, paramInt3);
        return;
      }
      paramIMsfServiceCallbacker.onReceiveNextPkgPushResp(paramMsfMessagePair.fromServiceMsg.getRequestSsoSeq(), paramInt1, paramMsfMessagePair.fromServiceMsg.getWupBuffer());
      return;
    }
    if (paramInt1 == 0)
    {
      paramIMsfServiceCallbacker.onFirstPkgResp(paramMsfMessagePair.toServiceMsg, paramMsfMessagePair.fromServiceMsg, paramInt1, paramInt2, paramInt3);
      return;
    }
    paramIMsfServiceCallbacker.onNextPkgResp(paramMsfMessagePair.fromServiceMsg.getRequestSsoSeq(), paramInt1, paramMsfMessagePair.fromServiceMsg.getWupBuffer());
  }
  
  private void a(MsfMessagePair paramMsfMessagePair, int paramInt1, int paramInt2, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    int m = 0;
    for (;;)
    {
      if (m < 4) {}
      try
      {
        a(paramMsfMessagePair, paramIMsfServiceCallbacker);
        if (m > 0) {
          h.a().a(true, "", c(paramMsfMessagePair), paramInt2, paramMsfMessagePair.fromServiceMsg.getServiceCmd(), this.k);
        }
        return;
      }
      catch (DeadObjectException paramMsfMessagePair)
      {
        throw paramMsfMessagePair;
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.AppProcessManager", 2, "try asyncTransport fail with e = " + localRemoteException.getClass().getSimpleName() + ", msg = " + localRemoteException.getMessage() + ", ssoSeq = " + paramMsfMessagePair.fromServiceMsg.getRequestSsoSeq() + ", cmd = " + paramMsfMessagePair.fromServiceMsg.getServiceCmd() + ", time = " + m + ", packageLength = " + paramInt1);
        }
        m += 1;
        if (m == 4)
        {
          if (a(paramMsfMessagePair))
          {
            b(paramMsfMessagePair, paramInt1 / 2, paramInt2, paramIMsfServiceCallbacker);
            return;
          }
          throw localRemoteException;
        }
        if (m >= 2) {
          b(paramMsfMessagePair);
        }
      }
    }
  }
  
  private void a(MsfMessagePair paramMsfMessagePair, IMsfServiceCallbacker paramIMsfServiceCallbacker, String paramString)
  {
    if (paramIMsfServiceCallbacker == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MSF.S.AppProcessManager", 2, "IMsfServiceCallback is null");
      }
      return;
    }
    if (!q.a().b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.AppProcessManager", 2, "transportToAppProcess, enableIPCDivideToTransport is false, so trans directly");
      }
      a(paramMsfMessagePair, paramIMsfServiceCallbacker);
      return;
    }
    int m = paramMsfMessagePair.fromServiceMsg.getWupBuffer().length;
    int n = f.a().b();
    if ((!a(paramMsfMessagePair)) || (m <= n)) {
      a(paramMsfMessagePair, n, m, paramIMsfServiceCallbacker);
    }
    for (;;)
    {
      h.a().b();
      return;
      b(paramMsfMessagePair, n, m, paramIMsfServiceCallbacker);
    }
  }
  
  private boolean a(MsfMessagePair paramMsfMessagePair)
  {
    return (paramMsfMessagePair.fromServiceMsg.getRequestSsoSeq() != -1) && (!a(paramMsfMessagePair.fromServiceMsg.getServiceCmd()));
  }
  
  private boolean a(MsfMessagePair paramMsfMessagePair, int paramInt1, int paramInt2, int paramInt3, int paramInt4, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    int m = 0;
    while (m < 4) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.AppProcessManager", 2, "send package, index = " + paramInt1 + ", ssoSeq = " + paramMsfMessagePair.fromServiceMsg.getRequestSsoSeq() + ", cmd = " + paramMsfMessagePair.fromServiceMsg.getServiceCmd() + ", divideTryTime = " + paramInt4 + ", packageLength = " + paramInt2);
        }
        a(paramMsfMessagePair, paramInt1, paramInt2, paramInt3, paramIMsfServiceCallbacker);
        return true;
      }
      catch (DeadObjectException paramIMsfServiceCallbacker)
      {
        h.a().a(false, paramIMsfServiceCallbacker.getClass().getSimpleName(), c(paramMsfMessagePair), paramInt3, paramMsfMessagePair.fromServiceMsg.getServiceCmd(), this.k);
        throw paramIMsfServiceCallbacker;
      }
      catch (RemoteException localRemoteException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.AppProcessManager", 2, "try syncTransport fail with e = " + localRemoteException.getClass().getSimpleName() + ", msg" + localRemoteException.getMessage() + ", ssoSeq = " + paramMsfMessagePair.fromServiceMsg.getRequestSsoSeq() + ", cmd = " + paramMsfMessagePair.fromServiceMsg.getServiceCmd() + ", time = " + m + ", divideTryTime = " + paramInt4 + ", packageLength = " + paramInt2);
        }
        m += 1;
        if (m == 4)
        {
          if (paramInt4 < 4) {
            return false;
          }
          h.a().a(false, localRemoteException.getClass().getSimpleName(), c(paramMsfMessagePair), paramInt3, paramMsfMessagePair.fromServiceMsg.getServiceCmd(), this.k);
          throw localRemoteException;
        }
        if (m >= 2) {
          b(paramMsfMessagePair);
        }
      }
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    return TextUtils.equals("cmd_pushSetConfig", paramString);
  }
  
  private boolean a(String paramString, c paramc)
  {
    int m = 0;
    int n;
    MsfMessagePair localMsfMessagePair2;
    if (!paramc.i.isEmpty())
    {
      m += 1;
      n = m;
      if (m <= 10)
      {
        localMsfMessagePair2 = (MsfMessagePair)paramc.i.peek();
        if (localMsfMessagePair2 != null) {
          break label54;
        }
        n = m;
      }
    }
    for (;;)
    {
      label45:
      label54:
      Object localObject1;
      label68:
      boolean bool3;
      label94:
      boolean bool2;
      String str;
      if (n > 10)
      {
        return true;
        localObject1 = paramc.c();
        if (localObject1 == null)
        {
          bool1 = true;
          if ((TextUtils.isEmpty(paramc.b())) || (localMsfMessagePair2.fromServiceMsg.getAttribute("resp_needBootApp") == null)) {
            break label466;
          }
          bool3 = true;
          if (!bool1) {
            break label489;
          }
          bool2 = false;
          str = localMsfMessagePair2.fromServiceMsg.getServiceCmd();
          localObject1 = BaseConstants.CMD_NeedBootPushCmdHeads;
          int i1 = localObject1.length;
          n = 0;
          label125:
          bool1 = bool2;
          if (n < i1)
          {
            Object localObject2 = localObject1[n];
            if ((str == null) || (!str.startsWith((String)localObject2))) {
              break label480;
            }
            paramc.a = false;
            paramc.c = false;
            if ((!"LongConn.OffPicUp".equalsIgnoreCase(str)) && (!"ImgStore.GroupPicUp".equalsIgnoreCase(str))) {
              break label1500;
            }
            localObject2 = new StringBuilder().append("dispatchMsg:").append(str).append(" resp:").append(localMsfMessagePair2.fromServiceMsg.getStringForLog()).append(" req:");
            if (localMsfMessagePair2.toServiceMsg == null) {
              break label472;
            }
            localObject1 = localMsfMessagePair2.toServiceMsg.getStringForLog();
            label251:
            QLog.d("MSF.S.AppProcessManager", 1, (String)localObject1);
          }
        }
      }
      label340:
      label472:
      label1500:
      for (boolean bool1 = true;; bool1 = true)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.AppProcessManager", 2, paramString + "'s callBack is null; " + str + " is cared: " + bool1 + ", needBoot: " + bool3);
        }
        boolean bool4 = true;
        bool2 = bool1;
        bool1 = bool4;
        if (("LongConn.OffPicUp".equalsIgnoreCase(localMsfMessagePair2.fromServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(localMsfMessagePair2.fromServiceMsg.getServiceCmd()))) {
          QLog.d("MSF.S.AppProcessManager", 1, "dispatchMsg:" + localMsfMessagePair2.fromServiceMsg.getStringForLog() + " processDied:" + bool2 + " isSendToSink:" + bool1);
        }
        if (!bool2)
        {
          paramc.i.poll();
          if (bool3) {
            paramc.a(3, localMsfMessagePair2.fromServiceMsg);
          }
        }
        for (;;)
        {
          for (;;)
          {
            break;
            bool1 = false;
            break label68;
            bool3 = false;
            break label94;
            localObject1 = "null";
            break label251;
            label480:
            n += 1;
            break label125;
            label489:
            if ((paramc.c == true) && (localMsfMessagePair2.fromServiceMsg.getMsfCommand() != MsfCommand.setMsfConnStatus))
            {
              n = m;
              if (SystemClock.elapsedRealtime() - paramc.b < 2000L) {
                break label45;
              }
              paramc.c = false;
              if (QLog.isColorLevel()) {
                QLog.d("MSF.S.AppProcessManager", 2, "half close timeout " + paramString + " isAppConnected " + paramc.a);
              }
            }
            long l1 = System.currentTimeMillis();
            try
            {
              if (localMsfMessagePair2.toServiceMsg == null)
              {
                if ((paramString != null) && (paramString.endsWith(":video")) && (localMsfMessagePair2.fromServiceMsg != null) && (localMsfMessagePair2.fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")) && (localMsfMessagePair2.fromServiceMsg.getAttribute("msf_timestamp") == null)) {
                  localMsfMessagePair2.fromServiceMsg.addAttribute("msf_timestamp", Long.valueOf(System.currentTimeMillis()));
                }
                QLog.i("MSF.S.AppProcessManager", 1, "SendToApp PUSH process:" + paramString + " fromServiceMsg: " + localMsfMessagePair2.fromServiceMsg.getShortStringForLog() + " cost = " + (System.currentTimeMillis() - l1) + " needBoot=" + bool3 + " from.len = " + localMsfMessagePair2.fromServiceMsg.getWupBuffer().length);
              }
              for (;;)
              {
                a(localMsfMessagePair2, (IMsfServiceCallbacker)localObject1, paramString);
                bool2 = bool1;
                bool1 = true;
                break;
                QLog.i("MSF.S.AppProcessManager", 1, "SendToApp process:" + paramString + " fromServiceMsg: " + localMsfMessagePair2.fromServiceMsg.getShortStringForLog() + " cos t =" + (System.currentTimeMillis() - l1) + " needBoot=" + bool3 + " to.len = " + localMsfMessagePair2.toServiceMsg.getWupBuffer().length + " from.len = " + localMsfMessagePair2.fromServiceMsg.getWupBuffer().length);
              }
            }
            catch (DeadObjectException localDeadObjectException)
            {
              paramc.a(localDeadObjectException, bool1);
              bool2 = true;
              bool1 = false;
              paramc.a((IMsfServiceCallbacker)localObject1);
              QLog.w("MSF.S.AppProcessManager", 1, "DeadObjectException process=" + paramString + " cost=" + (System.currentTimeMillis() - l1), localDeadObjectException);
            }
            catch (Throwable localThrowable)
            {
              QLog.w("MSF.S.AppProcessManager", 1, localThrowable.getMessage(), localThrowable);
              bool2 = bool1;
              bool1 = false;
            }
          }
          break label340;
          if (QLog.isColorLevel()) {
            QLog.d("MSF.S.AppProcessManager", 2, "need boot " + bool3 + " " + paramString + " from:" + localMsfMessagePair2.fromServiceMsg);
          }
          try
          {
            if ((localMsfMessagePair2.fromServiceMsg.getServiceCmd().equals("MessageSvc.PushNotify")) && (e.e.getStatReporter() != null)) {
              e.e.getStatReporter().a("dim.Msf.PushRecvFail", true, 0L, 0L, null, true, false);
            }
            if (!bool3) {}
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              try
              {
                paramc.a(0, localMsfMessagePair2.fromServiceMsg);
                paramc.d += 1L;
                if (paramc.d > a.aD())
                {
                  MsfMessagePair localMsfMessagePair1 = (MsfMessagePair)paramc.i.poll();
                  HashMap localHashMap = new HashMap();
                  e.a(localHashMap);
                  localHashMap.put("MsgType", localMsfMessagePair1.fromServiceMsg.toString());
                  localHashMap.put("ProcName", paramString);
                  localHashMap.put("uin", localMsfMessagePair1.fromServiceMsg.getUin());
                  localHashMap.put("appid", String.valueOf(localMsfMessagePair1.fromServiceMsg.getAppId()));
                  localHashMap.put("MsgLeft", String.valueOf(paramc.i.size()));
                  localHashMap.put("sleep_by_ipc_block_time", String.valueOf(this.k));
                  localHashMap.put("account_uin", MsfService.getCore().getAccountCenter().i());
                  QLog.d("MSF.S.AppProcessManager", 1, "dispatchMsg boot too many times:" + a.aD() + " MsgType:" + localMsfMessagePair1.fromServiceMsg.toString() + " ProcName:" + paramString + " MsgLeft:" + String.valueOf(paramc.i.size()));
                  if (e.e.getStatReporter() != null)
                  {
                    e.e.getStatReporter().a("dim.Msf.ForkProcFailed", false, 0L, 0L, localHashMap, true, false);
                    e.e.getStatReporter().a("msf_fork_process_fail", false, 0L, 0L, localHashMap, true, false);
                  }
                  paramc.d = 0L;
                  if ((localMsfMessagePair2.fromServiceMsg != null) && (localMsfMessagePair2.fromServiceMsg.getServiceCmd() != null) && (localMsfMessagePair2.fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c"))) {
                    com.tencent.mobileqq.msf.core.c.f.a().a(f.a.c, localMsfMessagePair2.fromServiceMsg.getWupBuffer(), 14);
                  }
                }
                return false;
              }
              catch (Exception localException2)
              {
                QLog.d("MSF.S.AppProcessManager", 1, "needBoot:" + bool3, localException2);
              }
              localException1 = localException1;
              if (QLog.isColorLevel()) {
                QLog.d("MSF.S.AppProcessManager", 2, "failed to report push notify event");
              }
            }
            paramc.i.poll();
          }
        }
        return false;
      }
      label466:
      n = m;
    }
  }
  
  private void b()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("common_sp_for_msf", 0);
    this.k = localSharedPreferences.getLong("sleep_by_ipc_block_time", 0L);
    if (this.k == 0L)
    {
      int i1 = i.length;
      int n = new Random().nextInt(i1);
      int m;
      if (n >= 0)
      {
        m = n;
        if (n < i1) {}
      }
      else
      {
        m = i1 - 1;
      }
      this.k = i[m];
      localSharedPreferences.edit().putLong("sleep_by_ipc_block_time", this.k).apply();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.S.AppProcessManager", 2, "init, mSleepByIPCBlockTime = " + this.k);
      }
    }
  }
  
  private void b(MsfMessagePair paramMsfMessagePair)
  {
    if ((!q.a().c()) || (a(paramMsfMessagePair.fromServiceMsg.getServiceCmd()))) {}
    do
    {
      return;
      QLog.d("MSF.S.AppProcessManager", 1, "sleep " + this.k + " ms by IPC block");
      try
      {
        sleep(this.k);
        return;
      }
      catch (Exception paramMsfMessagePair) {}
    } while (!QLog.isColorLevel());
    QLog.d("MSF.S.AppProcessManager", 2, "sleepByIPCBlock throws ex: ", paramMsfMessagePair);
  }
  
  private void b(MsfMessagePair paramMsfMessagePair, int paramInt1, int paramInt2, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    int n = 0;
    int m = 0;
    for (;;)
    {
      try
      {
        arrayOfByte2 = paramMsfMessagePair.fromServiceMsg.getWupBuffer();
        arrayOfByte1 = null;
      }
      catch (OutOfMemoryError paramIMsfServiceCallbacker)
      {
        byte[] arrayOfByte2;
        byte[] arrayOfByte1;
        QLog.e("MSF.S.AppProcessManager", 1, "transportToAppProcess throw oom, cmd = " + paramMsfMessagePair.fromServiceMsg.getServiceCmd(), paramIMsfServiceCallbacker);
        h.a().a(false, paramIMsfServiceCallbacker.getClass().getSimpleName(), c(paramMsfMessagePair), paramInt2, paramMsfMessagePair.fromServiceMsg.getServiceCmd(), this.k);
        return;
      }
      if ((arrayOfByte1 == null) || (arrayOfByte1.length != i1))
      {
        arrayOfByte1 = new byte[i1];
        System.arraycopy(arrayOfByte2, m, arrayOfByte1, 0, i1);
        paramMsfMessagePair.fromServiceMsg.putWupBuffer(arrayOfByte1);
        if (a(paramMsfMessagePair, m, paramInt1, paramInt2, n, paramIMsfServiceCallbacker))
        {
          m += i1;
        }
        else
        {
          paramInt1 /= 2;
          n += 1;
          break label219;
          h.a().a(true, "", c(paramMsfMessagePair), paramInt2, paramMsfMessagePair.fromServiceMsg.getServiceCmd(), this.k);
        }
      }
      else
      {
        continue;
      }
      label219:
      for (;;)
      {
        if (m >= paramInt2) {
          break label220;
        }
        if (m + paramInt1 > paramInt2) {
          break label222;
        }
        i1 = paramInt1;
        break;
      }
      label220:
      continue;
      label222:
      int i1 = paramInt2 - m;
    }
  }
  
  private int c(MsfMessagePair paramMsfMessagePair)
  {
    if (paramMsfMessagePair.toServiceMsg != null) {
      return paramMsfMessagePair.toServiceMsg.getWupBuffer().length;
    }
    return 0;
  }
  
  public void a()
  {
    synchronized (this.a)
    {
      this.c = true;
      this.b = false;
      this.a.notify();
      return;
    }
  }
  
  void a(MsfMessagePair paramMsfMessagePair, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    if (paramMsfMessagePair.toServiceMsg == null)
    {
      paramIMsfServiceCallbacker.onReceivePushResp(paramMsfMessagePair.fromServiceMsg);
      return;
    }
    paramIMsfServiceCallbacker.onResponse(paramMsfMessagePair.toServiceMsg, paramMsfMessagePair.fromServiceMsg);
  }
  
  public void run()
  {
    e.f.f = false;
    while (this.c)
    {
      this.c = false;
      this.d = 0;
      ??? = e.c.keySet().iterator();
      while (((Iterator)???).hasNext())
      {
        String str = (String)((Iterator)???).next();
        c localc = (c)e.c.get(str);
        if (localc != null)
        {
          if (a(str, localc)) {
            this.c = true;
          }
          this.d += localc.i.size();
        }
      }
    }
    this.b = true;
    for (;;)
    {
      synchronized (this.a)
      {
        boolean bool = this.b;
        if (bool) {}
        try
        {
          if (this.d == 0)
          {
            this.a.wait(61440L);
            this.c = true;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          continue;
        }
      }
      this.a.wait(600L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.b
 * JD-Core Version:    0.7.0.1
 */