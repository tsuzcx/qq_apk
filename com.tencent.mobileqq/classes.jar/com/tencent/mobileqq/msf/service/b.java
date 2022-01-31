package com.tencent.mobileqq.msf.service;

import android.os.DeadObjectException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.c.f.a;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.push.g;
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
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

class b
  extends Thread
{
  private static final String e = "MSF.S.AppProcessManager";
  private static final int f = 3;
  private static final int g = 6;
  private static final int h = 10;
  volatile Object a = new Object();
  volatile boolean b = false;
  volatile boolean c = true;
  int d = 0;
  
  static void a(MsfMessagePair paramMsfMessagePair, int paramInt1, int paramInt2, int paramInt3, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    if (paramMsfMessagePair.toServiceMsg == null)
    {
      paramIMsfServiceCallbacker.onSyncReceivePushResp(paramMsfMessagePair.fromServiceMsg, paramInt1, paramInt2, paramInt3);
      return;
    }
    paramIMsfServiceCallbacker.onSyncResponse(paramMsfMessagePair.toServiceMsg, paramMsfMessagePair.fromServiceMsg, paramInt1, paramInt2, paramInt3);
  }
  
  private static void a(MsfMessagePair paramMsfMessagePair, int paramInt1, int paramInt2, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    int i = 0;
    int j;
    do
    {
      if (i < 3) {}
      try
      {
        a(paramMsfMessagePair, paramIMsfServiceCallbacker);
        return;
      }
      catch (DeadObjectException paramMsfMessagePair)
      {
        throw paramMsfMessagePair;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.AppProcessManager", 2, "try asyncTransport fail with " + localException.getMessage() + ", ssoSeq = " + paramMsfMessagePair.fromServiceMsg.getRequestSsoSeq() + ", cmd = " + paramMsfMessagePair.fromServiceMsg.getServiceCmd() + ", time = " + i + ", packageLength = " + paramInt1);
        }
        j = i + 1;
        i = j;
      }
    } while (j != 3);
    if (paramMsfMessagePair.fromServiceMsg.getRequestSsoSeq() != -1)
    {
      b(paramMsfMessagePair, paramInt1 / 2, paramInt2, paramIMsfServiceCallbacker);
      return;
    }
    throw localException;
  }
  
  private static void a(MsfMessagePair paramMsfMessagePair, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    if (paramMsfMessagePair.toServiceMsg == null)
    {
      paramIMsfServiceCallbacker.onReceivePushResp(paramMsfMessagePair.fromServiceMsg);
      return;
    }
    paramIMsfServiceCallbacker.onResponse(paramMsfMessagePair.toServiceMsg, paramMsfMessagePair.fromServiceMsg);
  }
  
  private static void a(MsfMessagePair paramMsfMessagePair, IMsfServiceCallbacker paramIMsfServiceCallbacker, String paramString)
  {
    if (paramIMsfServiceCallbacker == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MSF.S.AppProcessManager", 2, "IMsfServiceCallback is null");
      }
      return;
    }
    int i = paramMsfMessagePair.fromServiceMsg.getWupBuffer().length;
    int j = h.a();
    if ((paramMsfMessagePair.fromServiceMsg.getRequestSsoSeq() == -1) || (i <= j))
    {
      a(paramMsfMessagePair, j, i, paramIMsfServiceCallbacker);
      return;
    }
    b(paramMsfMessagePair, j, i, paramIMsfServiceCallbacker);
  }
  
  private static boolean a(MsfMessagePair paramMsfMessagePair, int paramInt1, int paramInt2, int paramInt3, int paramInt4, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    if (i < 3) {}
    do
    {
      int j;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.AppProcessManager", 2, "send package, index = " + paramInt1 + ", ssoSeq = " + paramMsfMessagePair.fromServiceMsg.getRequestSsoSeq() + ", cmd = " + paramMsfMessagePair.fromServiceMsg.getServiceCmd() + ", divideTryTime = " + paramInt4 + ", packageLength = " + paramInt2);
        }
        a(paramMsfMessagePair, paramInt1, paramInt2, paramInt3, paramIMsfServiceCallbacker);
        bool1 = true;
        return bool1;
      }
      catch (DeadObjectException paramMsfMessagePair)
      {
        f.a().a(false, "DeadObjectException");
        throw paramMsfMessagePair;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.S.AppProcessManager", 2, "try syncTransport fail with " + localException.getMessage() + ", ssoSeq = " + paramMsfMessagePair.fromServiceMsg.getRequestSsoSeq() + ", cmd = " + paramMsfMessagePair.fromServiceMsg.getServiceCmd() + ", time = " + i + ", divideTryTime = " + paramInt4 + ", packageLength = " + paramInt2);
        }
        j = i + 1;
        i = j;
      }
      if (j != 3) {
        break;
      }
      bool1 = bool2;
    } while (paramInt4 < 6);
    f.a().a(false, localException.getClass().getSimpleName());
    throw localException;
  }
  
  private static boolean a(String paramString, c paramc)
  {
    int i = 0;
    int j;
    MsfMessagePair localMsfMessagePair2;
    label51:
    Object localObject1;
    boolean bool1;
    label65:
    boolean bool3;
    label91:
    boolean bool2;
    Object localObject2;
    int k;
    label259:
    label326:
    label460:
    label467:
    long l;
    if (!paramc.i.isEmpty())
    {
      i += 1;
      j = i;
      if (i <= 10)
      {
        localMsfMessagePair2 = (MsfMessagePair)paramc.i.peek();
        if (localMsfMessagePair2 != null) {
          break label51;
        }
        j = i;
      }
      for (;;)
      {
        if (j > 10)
        {
          return true;
          localObject1 = paramc.c();
          if (localObject1 == null)
          {
            bool1 = true;
            if ((TextUtils.isEmpty(paramc.b())) || (localMsfMessagePair2.fromServiceMsg.getAttribute("resp_needBootApp") == null)) {
              break label447;
            }
            bool3 = true;
            if (!bool1) {
              break label467;
            }
            bool2 = false;
            localObject2 = localMsfMessagePair2.fromServiceMsg.getServiceCmd();
            localObject1 = BaseConstants.CMD_NeedBootPushCmdHeads;
            k = localObject1.length;
            j = 0;
          }
          for (;;)
          {
            bool1 = bool2;
            Object localObject3;
            if (j < k)
            {
              localObject3 = localObject1[j];
              if ((localObject2 == null) || (!((String)localObject2).startsWith((String)localObject3))) {
                break label460;
              }
              paramc.a = false;
              paramc.c = false;
              if ((!"LongConn.OffPicUp".equalsIgnoreCase((String)localObject2)) && (!"ImgStore.GroupPicUp".equalsIgnoreCase((String)localObject2))) {
                break label1458;
              }
              localObject3 = new StringBuilder().append("dispatchMsg:").append((String)localObject2).append(" resp:").append(localMsfMessagePair2.fromServiceMsg.getStringForLog()).append(" req:");
              if (localMsfMessagePair2.toServiceMsg == null) {
                break label453;
              }
            }
            label438:
            label447:
            label453:
            for (localObject1 = localMsfMessagePair2.toServiceMsg.getStringForLog();; localObject1 = "null")
            {
              QLog.d("MSF.S.AppProcessManager", 1, (String)localObject1);
              bool1 = true;
              if (QLog.isColorLevel()) {
                QLog.d("MSF.S.AppProcessManager", 2, paramString + "'s callBack is null; " + (String)localObject2 + " is cared: " + bool1 + ", needBoot: " + bool3);
              }
              boolean bool4 = true;
              bool2 = bool1;
              bool1 = bool4;
              if (("LongConn.OffPicUp".equalsIgnoreCase(localMsfMessagePair2.fromServiceMsg.getServiceCmd())) || ("ImgStore.GroupPicUp".equalsIgnoreCase(localMsfMessagePair2.fromServiceMsg.getServiceCmd()))) {
                QLog.d("MSF.S.AppProcessManager", 1, "dispatchMsg:" + localMsfMessagePair2.fromServiceMsg.getStringForLog() + " processDied:" + bool2 + " isSendToSink:" + bool1);
              }
              if (bool2) {
                break label980;
              }
              paramc.i.poll();
              if (bool3) {
                paramc.a(3, localMsfMessagePair2.fromServiceMsg);
              }
              break;
              bool1 = false;
              break label65;
              bool3 = false;
              break label91;
            }
            j += 1;
          }
          if ((paramc.c == true) && (localMsfMessagePair2.fromServiceMsg.getMsfCommand() != MsfCommand.setMsfConnStatus))
          {
            j = i;
            if (SystemClock.elapsedRealtime() - paramc.b < 2000L) {
              continue;
            }
            paramc.c = false;
            if (QLog.isColorLevel()) {
              QLog.d("MSF.S.AppProcessManager", 2, "half close timeout " + paramString + " isAppConnected " + paramc.a);
            }
          }
          l = System.currentTimeMillis();
        }
      }
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          if (localMsfMessagePair2.toServiceMsg == null) {
            break label1469;
          }
          j = localMsfMessagePair2.toServiceMsg.getWupBuffer().length;
          if (localMsfMessagePair2.fromServiceMsg == null) {
            break label1474;
          }
          k = localMsfMessagePair2.fromServiceMsg.getWupBuffer().length;
          QLog.d("MSF.S.AppProcessManager", 2, "send push " + paramString + ", to=" + j + " from=" + k);
        }
        if (localMsfMessagePair2.toServiceMsg == null)
        {
          if ((paramString != null) && (paramString.endsWith(":video")) && (localMsfMessagePair2.fromServiceMsg != null) && (localMsfMessagePair2.fromServiceMsg.getServiceCmd().equals("SharpSvr.s2c")) && (localMsfMessagePair2.fromServiceMsg.getAttribute("msf_timestamp") == null)) {
            localMsfMessagePair2.fromServiceMsg.addAttribute("msf_timestamp", Long.valueOf(System.currentTimeMillis()));
          }
          QLog.i("MSF.S.AppProcessManager", 1, "SendToApp PUSH process:" + paramString + " fromServiceMsg: " + localMsfMessagePair2.fromServiceMsg.getShortStringForLog() + " cost=" + (System.currentTimeMillis() - l) + " needBoot=" + bool3);
          a(localMsfMessagePair2, (IMsfServiceCallbacker)localObject1, paramString);
          bool2 = bool1;
          bool1 = true;
          break label326;
        }
        QLog.i("MSF.S.AppProcessManager", 1, "SendToApp process:" + paramString + " fromServiceMsg: " + localMsfMessagePair2.fromServiceMsg.getShortStringForLog() + " cost=" + (System.currentTimeMillis() - l) + " needBoot=" + bool3);
        continue;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        paramc.a(localDeadObjectException, bool1);
        bool2 = true;
        bool1 = false;
        paramc.d();
        QLog.w("MSF.S.AppProcessManager", 1, "DeadObjectException process=" + paramString + " cost=" + (System.currentTimeMillis() - l), localDeadObjectException);
      }
      catch (Throwable localThrowable)
      {
        QLog.w("MSF.S.AppProcessManager", 1, localThrowable.getMessage(), localThrowable);
        bool2 = bool1;
        bool1 = false;
      }
      break label326;
      label980:
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
              localObject2 = new HashMap();
              e.a((HashMap)localObject2);
              ((HashMap)localObject2).put("MsgType", localMsfMessagePair1.fromServiceMsg.toString());
              ((HashMap)localObject2).put("ProcName", paramString);
              ((HashMap)localObject2).put("uin", localMsfMessagePair1.fromServiceMsg.getUin());
              ((HashMap)localObject2).put("appid", String.valueOf(localMsfMessagePair1.fromServiceMsg.getAppId()));
              ((HashMap)localObject2).put("MsgLeft", String.valueOf(paramc.i.size()));
              QLog.d("MSF.S.AppProcessManager", 1, "dispatchMsg boot too many times:" + a.aD() + " MsgType:" + localMsfMessagePair1.fromServiceMsg.toString() + " ProcName:" + paramString + " MsgLeft:" + String.valueOf(paramc.i.size()));
              if (e.e.getStatReporter() != null) {
                e.e.getStatReporter().a("dim.Msf.ForkProcFailed", false, 0L, 0L, (Map)localObject2, true, false);
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
      break label438;
      break label438;
      return false;
      label1458:
      bool1 = true;
      break label259;
      j = i;
      break;
      label1469:
      j = 0;
      continue;
      label1474:
      k = 0;
    }
  }
  
  private static void b(MsfMessagePair paramMsfMessagePair, int paramInt1, int paramInt2, IMsfServiceCallbacker paramIMsfServiceCallbacker)
  {
    for (;;)
    {
      int i;
      try
      {
        arrayOfByte2 = paramMsfMessagePair.fromServiceMsg.getWupBuffer();
        arrayOfByte1 = null;
        i = 0;
        j = 0;
      }
      catch (OutOfMemoryError paramIMsfServiceCallbacker)
      {
        byte[] arrayOfByte2;
        byte[] arrayOfByte1;
        int j;
        QLog.e("MSF.S.AppProcessManager", 1, "transportToAppProcess throw oom, cmd = " + paramMsfMessagePair.fromServiceMsg.getServiceCmd(), paramIMsfServiceCallbacker);
        f.a().a(false, "OutOfMemoryError");
        return;
      }
      if ((arrayOfByte1 == null) || (arrayOfByte1.length != k))
      {
        arrayOfByte1 = new byte[k];
        System.arraycopy(arrayOfByte2, i, arrayOfByte1, 0, k);
        paramMsfMessagePair.fromServiceMsg.putWupBuffer(arrayOfByte1);
        if (a(paramMsfMessagePair, i, paramInt1, paramInt2, j, paramIMsfServiceCallbacker))
        {
          i += k;
        }
        else
        {
          paramInt1 /= 2;
          j += 1;
          break label177;
          f.a().a(true, "");
        }
      }
      else
      {
        continue;
      }
      label177:
      for (;;)
      {
        if (i >= paramInt2) {
          break label178;
        }
        if (i + paramInt1 > paramInt2) {
          break label180;
        }
        k = paramInt1;
        break;
      }
      label178:
      continue;
      label180:
      int k = paramInt2 - i;
    }
  }
  
  private static boolean b(String paramString, c paramc)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (!paramc.i.isEmpty())
      {
        if (i <= 10) {
          break label31;
        }
        bool1 = true;
      }
      label31:
      MsfMessagePair localMsfMessagePair;
      do
      {
        return bool1;
        localMsfMessagePair = (MsfMessagePair)paramc.i.peek();
        bool1 = bool2;
      } while (localMsfMessagePair == null);
      if (localMsfMessagePair.fromServiceMsg.getAttribute("resp_needBootApp") != null) {}
      for (int j = 1;; j = 0)
      {
        Object localObject;
        if ((paramc.c() == null) && (j != 0))
        {
          bool1 = bool2;
          if (localMsfMessagePair.fromServiceMsg == null) {
            break;
          }
          localObject = BaseConstants.CMD_NeedBootPushCmdHeads;
          j = localObject.length;
          i = 0;
          label101:
          if (i >= j) {
            break label1183;
          }
          String str = localObject[i];
          if (!localMsfMessagePair.fromServiceMsg.getServiceCmd().startsWith(str)) {}
        }
        label1050:
        label1183:
        for (i = 1;; i = 0)
        {
          for (;;)
          {
            if (i != 0)
            {
              paramc.a = false;
              paramc.c = false;
              i = e.e.getUinPushStatus(localMsfMessagePair.fromServiceMsg.getUin());
              t.a(BaseApplication.getContext(), paramString, localMsfMessagePair.fromServiceMsg.getUin(), ((c)e.c.get(paramString)).b(), i, localMsfMessagePair.fromServiceMsg);
              MsfService.getCore().pushManager.j.a();
              if (QLog.isColorLevel()) {
                QLog.d("MSF.S.AppProcessManager", 2, "need boot app " + paramString + " from:" + localMsfMessagePair.fromServiceMsg);
              }
              paramc.d += 1L;
              bool1 = bool2;
              if (paramc.d <= a.aD()) {
                break;
              }
              localMsfMessagePair = (MsfMessagePair)paramc.i.poll();
              localObject = new HashMap();
              e.a((HashMap)localObject);
              ((HashMap)localObject).put("MsgType", localMsfMessagePair.fromServiceMsg.toString());
              ((HashMap)localObject).put("ProcName", paramString);
              ((HashMap)localObject).put("uin", localMsfMessagePair.fromServiceMsg.getUin());
              ((HashMap)localObject).put("appid", String.valueOf(localMsfMessagePair.fromServiceMsg.getAppId()));
              ((HashMap)localObject).put("MsgLeft", String.valueOf(paramc.i.size()));
              QLog.d("MSF.S.AppProcessManager", 1, "sendAppMsgPair boot too many times:" + a.aD() + " MsgType:" + localMsfMessagePair.fromServiceMsg.toString() + " ProcName:" + paramString + " MsgLeft:" + String.valueOf(paramc.i.size()));
              if (e.e.getStatReporter() != null) {
                e.e.getStatReporter().a("dim.Msf.ForkProcFailed", false, 0L, 0L, (Map)localObject, true, false);
              }
              paramc.d = 0L;
              return false;
              i += 1;
              break label101;
            }
            paramc.i.poll();
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("MSF.S.AppProcessManager", 2, "need boot app but not in CMD_NeedBootPushCmdHeads " + paramString + " from:" + localMsfMessagePair.fromServiceMsg);
            return false;
            if ((paramc.c == true) && (localMsfMessagePair.fromServiceMsg.getMsfCommand() != MsfCommand.setMsfConnStatus))
            {
              bool1 = bool2;
              if (SystemClock.elapsedRealtime() - paramc.b < 2000L) {
                break;
              }
              paramc.c = false;
              if (QLog.isColorLevel()) {
                QLog.d("MSF.S.AppProcessManager", 2, "half close timeout " + paramString + " isAppConnected " + paramc.a);
              }
            }
            if (!paramc.a) {
              break label1050;
            }
            try
            {
              if (localMsfMessagePair.toServiceMsg == null) {
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.S.AppProcessManager", 2, "send push " + paramString + " from:" + localMsfMessagePair.fromServiceMsg);
                }
              }
              for (;;)
              {
                a(localMsfMessagePair, paramc.c(), paramString);
                paramc.i.poll();
                break;
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.S.AppProcessManager", 2, "send resp " + paramString + " to:" + localMsfMessagePair.toServiceMsg + " from:" + localMsfMessagePair.fromServiceMsg);
                }
              }
            }
            catch (DeadObjectException localDeadObjectException)
            {
              paramc.d();
              if (j != 0)
              {
                i = e.e.getUinPushStatus(localMsfMessagePair.fromServiceMsg.getUin());
                if (e.c.get(paramString) != null)
                {
                  t.a(BaseApplication.getContext(), paramString, localMsfMessagePair.fromServiceMsg.getUin(), ((c)e.c.get(paramString)).b(), i, localMsfMessagePair.fromServiceMsg);
                  MsfService.getCore().pushManager.j.a();
                }
              }
              for (;;)
              {
                bool1 = bool2;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("MSF.S.AppProcessManager", 2, "found DeadObjectException " + localDeadObjectException.toString());
                return false;
                paramc.i.poll();
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.S.AppProcessManager", 2, "found not NeedBootMsg," + localMsfMessagePair.fromServiceMsg + " dropped");
                }
              }
            }
            catch (Throwable localThrowable)
            {
              paramc.i.poll();
              localThrowable.printStackTrace();
              if (!QLog.isColorLevel()) {
                break label1193;
              }
            }
          }
          QLog.d("MSF.S.AppProcessManager", 2, "handle error " + localMsfMessagePair.toString() + " " + localMsfMessagePair.fromServiceMsg + " ", localThrowable);
          break label1193;
          if (j != 0)
          {
            i = e.e.getUinPushStatus(localMsfMessagePair.fromServiceMsg.getUin());
            t.a(BaseApplication.getContext(), paramString, localMsfMessagePair.fromServiceMsg.getUin(), ((c)e.c.get(paramString)).b(), i, localMsfMessagePair.fromServiceMsg);
            MsfService.getCore().pushManager.j.a();
            return false;
          }
          paramc.i.poll();
          if (!QLog.isColorLevel()) {
            break label1193;
          }
          QLog.d("MSF.S.AppProcessManager", 2, "found " + paramc.g + " notNeedBootMsg," + localMsfMessagePair.fromServiceMsg + " dropped");
          break label1193;
        }
      }
      label1193:
      i += 1;
    }
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