package com.tencent.mobileqq.msf.core.push;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.core.quicksend.b;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.e;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.msf.service.protocol.pb.ImMqPullup.MsgReq;
import com.tencent.msf.service.protocol.pb.ImMqPullup.MsgRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.h;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
{
  private static final String b = "PCActiveEchoManager";
  private static final int c = 10000;
  private static final long d = 600000L;
  private static final long e = 60000L;
  private static final int g = 1;
  private static final int h = 2;
  private static final String j = "0";
  private static final String n = "key_pcactive_opened_uins";
  final long a = 30000L;
  private long f = 600000L;
  private long i = 0L;
  private AtomicBoolean k = new AtomicBoolean(false);
  private String l = "0";
  private MsfCore m;
  private Handler o = new d(this);
  
  public c(MsfCore paramMsfCore)
  {
    this.m = paramMsfCore;
    paramMsfCore = MsfStore.getNativeConfigStore().getConfig("0");
    if ((!TextUtils.isEmpty(paramMsfCore)) && (!"0".equals(paramMsfCore)))
    {
      this.l = paramMsfCore;
      this.o.sendEmptyMessageDelayed(10000, 60000L);
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == -12003) || (paramInt == 210) || (paramInt == -10001) || (paramInt == -10003) || (paramInt == -10004) || (paramInt == -10006) || (paramInt == -10106) || (paramInt == -10005) || (paramInt == -10103) || (paramInt == -10009);
  }
  
  private boolean b()
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.i;
    if (l2 > 0L)
    {
      l1 -= l2;
      if (l1 > 0L)
      {
        boolean bool;
        if (l1 > this.f + 30000L) {
          bool = true;
        } else {
          bool = false;
        }
        if (this.m.getStatReporter() != null) {
          this.m.getStatReporter().a("dim_Msf_PCActiveEcho", bool, l1, 0L, null, false, false);
        }
      }
      else
      {
        this.i = 0L;
      }
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("MessageSvc.QueryPullUp", this.l, "MessageSvc.QueryPullUp");
    localToServiceMsg.setRequestSsoSeq(MsfSdkUtils.getNextAppSeq());
    localToServiceMsg.getAttributes().put("send_mode", Integer.valueOf(1));
    localToServiceMsg.getAttributes().put("RequestEcho", Boolean.valueOf(true));
    byte[] arrayOfByte1 = new ImMqPullup.MsgReq().toByteArray();
    l1 = arrayOfByte1.length;
    int i1 = (int)l1;
    byte[] arrayOfByte2 = new byte[i1 + 4];
    h.a(arrayOfByte2, 0, l1 + 4L);
    h.a(arrayOfByte2, 4, arrayOfByte1, i1);
    localToServiceMsg.putWupBuffer(arrayOfByte2);
    this.m.lightSender.a(localToServiceMsg);
    return true;
  }
  
  public void a()
  {
    try
    {
      this.o.removeMessages(10000);
      this.l = "0";
      MsfStore.getNativeConfigStore().removeConfig("0");
      this.m.quicksender.e();
      this.m.quicksender.f();
      this.i = 0L;
      QLog.d("PCActiveEchoManager", 1, "stopEcho succ");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("PCActiveEchoManager", 1, "stopEcho fail", localException);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult");
    boolean bool = ((Boolean)paramToServiceMsg.getAttribute("RequestEcho", Boolean.valueOf(false))).booleanValue();
    if (paramFromServiceMsg.getServiceCmd().equals("ConfigPushSvc.PushReq")) {
      QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult ssolist changed");
    } else if (paramFromServiceMsg != null) {
      try
      {
        if ((paramFromServiceMsg.isSuccess()) && (paramFromServiceMsg.getWupBuffer() != null) && (paramFromServiceMsg.getWupBuffer().length > 4))
        {
          paramToServiceMsg = new byte[paramFromServiceMsg.getWupBuffer().length - 4];
          System.arraycopy(paramFromServiceMsg.getWupBuffer(), 4, paramToServiceMsg, 0, paramToServiceMsg.length);
          ImMqPullup.MsgRsp localMsgRsp = new ImMqPullup.MsgRsp();
          localMsgRsp.mergeFrom(paramToServiceMsg);
          if (localMsgRsp.command.get() == 1)
          {
            int i1 = localMsgRsp.uint32_ret.get();
            int i2 = localMsgRsp.uint32_itv.get();
            if (i2 > 0) {
              this.f = (i2 * 1000);
            }
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("onRecvEchoResult ret: ");
            paramToServiceMsg.append(i1);
            paramToServiceMsg.append(" interval: ");
            paramToServiceMsg.append(this.f);
            QLog.d("PCActiveEchoManager", 1, paramToServiceMsg.toString());
            if (i1 == 1)
            {
              paramToServiceMsg = new HashMap();
              e.a(paramToServiceMsg);
              paramToServiceMsg.put("account", paramFromServiceMsg.getUin());
              if (bool)
              {
                QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult succ, stop poll and active qq");
                a();
                this.m.pushManager.d(paramFromServiceMsg.getUin());
                if (this.m.getStatReporter() == null) {
                  return;
                }
                this.m.getStatReporter().a("dim_Msf_PCActiveSuccResult", true, 0L, 0L, paramToServiceMsg, false, false);
                return;
              }
              if (this.m.getStatReporter() != null) {
                this.m.getStatReporter().a("dim_Msf_PCActiveSuccResult", false, 0L, 0L, paramToServiceMsg, false, false);
              }
              QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult failed, need active, ToServiceMsg's RequestEcho Flag is false");
              return;
            }
            if (i1 == 2)
            {
              if (bool)
              {
                QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult succ, force stop poll");
                a();
                return;
              }
              QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult failed, need stop, ToServiceMsg's RequestEcho Flag is false");
            }
          }
        }
        else if (bool)
        {
          if (a(paramFromServiceMsg.getBusinessFailCode()))
          {
            QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult failed, tokenExpired");
            a();
          }
        }
        else
        {
          QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult failed, need stop1, ToServiceMsg's RequestEcho Flag is false");
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    }
    if (bool)
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("onRecvEchoResult succ, continue at ");
      paramToServiceMsg.append(this.f);
      paramToServiceMsg.append(" later");
      QLog.d("PCActiveEchoManager", 1, paramToServiceMsg.toString());
      this.i = SystemClock.elapsedRealtime();
      this.o.sendEmptyMessageDelayed(10000, this.f);
      return;
    }
    QLog.d("PCActiveEchoManager", 1, "onRecvEchoResult failed, need continue, ToServiceMsg's RequestEcho Flag is false");
    return;
  }
  
  public void a(String paramString)
  {
    try
    {
      if (this.k.get())
      {
        QLog.d("PCActiveEchoManager", 1, "startEcho failed, reason: echo still running");
        return;
      }
      QLog.d("PCActiveEchoManager", 1, "startEcho succ");
      this.k.set(true);
      this.o.removeMessages(10000);
      this.i = 0L;
      this.m.quicksender.e();
      this.m.quicksender.f();
      this.l = paramString;
      MsfStore.getNativeConfigStore().setConfig("0", paramString);
      this.o.sendEmptyMessageDelayed(10000, 60000L);
      this.k.set(false);
      if (this.m.getStatReporter() != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("account", paramString);
        this.m.getStatReporter().a("dim_Msf_PCActiveDidStartEvent", true, 0L, 0L, localHashMap, false, false);
        return;
      }
      QLog.d("msfCore", 1, "stop try report PCActiveDidStartEvent by reporter null");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("PCActiveEchoManager", 1, "startEcho fail", paramString);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("0")) {
        return;
      }
      Object localObject = MsfStore.getNativeConfigStore().getConfig("key_pcactive_opened_uins");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        StringBuilder localStringBuilder = new StringBuilder();
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2)
        {
          String str = localObject[i1];
          if (!str.equals(paramString)) {
            localStringBuilder.append(str);
          }
          i1 += 1;
        }
        if (paramBoolean) {
          localStringBuilder.append(paramString);
        }
        MsfStore.getNativeConfigStore().setConfig("key_pcactive_opened_uins", localStringBuilder.toString());
      }
    }
  }
  
  public boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("0")) {
        return false;
      }
      String[] arrayOfString = MsfStore.getNativeConfigStore().getConfig("key_pcactive_opened_uins").split(",");
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if (arrayOfString[i1].equals(paramString)) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.c
 * JD-Core Version:    0.7.0.1
 */