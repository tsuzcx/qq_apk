package com.tencent.mobileqq.msf.core;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffData;
import com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffItem;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.j;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

class ac$b
  implements Runnable
{
  ac$b(ac paramac) {}
  
  public void run()
  {
    int j;
    long l;
    synchronized (ac.a(this.a))
    {
      j = this.a.h.size();
      i = j;
      if (j > this.a.j) {
        i = this.a.j;
      }
      l = SystemClock.elapsedRealtime();
      if (this.a.L >= l)
      {
        ac.b(this.a).postDelayed(this.a.i, this.a.m);
        if ((!ac.c(this.a)) && (this.a.h.size() - this.a.k > 0))
        {
          ac.b(this.a).postDelayed(this.a.i, this.a.m);
          ac.a(this.a, true);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.NetConnTag", 4, "delayWaitSendList size is " + this.a.h.size() + ", " + i + " sso package should be merged.");
        }
        if (i <= 0) {
          break label1622;
        }
        j = i;
      }
      try
      {
        if (i > this.a.h.size()) {
          j = this.a.h.size();
        }
        if (j != 1) {
          break label348;
        }
        ??? = (ToServiceMsg)this.a.h.peek();
        if ((??? == null) || (((ToServiceMsg)???).getWupBuffer().length >= this.a.o)) {
          break label348;
        }
        ac localac = this.a;
        localac.l -= ((ToServiceMsg)???).getWupBuffer().length;
        ac.a(this.a, (ToServiceMsg)this.a.h.poll());
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          synchronized (ac.a(this.a))
          {
            if ((this.a.l >= this.a.k) && (!ac.c(this.a)))
            {
              ac.a(this.a, true);
              ac.b(this.a).post(this.a.i);
              if (i1 > 0)
              {
                this.a.e.put(Integer.valueOf(((ToServiceMsg)???).getRequestSsoSeq()), localArrayList);
                this.a.f.put(Integer.valueOf(((ToServiceMsg)???).getRequestSsoSeq()), localObject6);
                localObject5 = ((SSOLoginMerge.BusiBuffData)localObject5).toByteArray();
                localObject6 = new ByteArrayOutputStream();
                j.a((byte[])localObject5, (OutputStream)localObject6);
                localObject6 = ac.b(((ByteArrayOutputStream)localObject6).toByteArray());
                ((ToServiceMsg)???).putWupBuffer((byte[])localObject6);
                ((ToServiceMsg)???).getAttributes().put("mergeCount", Integer.valueOf(i1));
                ((ToServiceMsg)???).getAttributes().put("noRespCount", Integer.valueOf(j));
                if (QLog.isDevelopLevel()) {
                  QLog.d("MSF.C.NetConnTag", 4, "Delay ToServiceMsg ssoseq: " + ((ToServiceMsg)???).getRequestSsoSeq() + " delayWaitSendList buffer size is " + localObject5.length + ", zip size is " + localObject6.length);
                }
              }
              if (??? == null) {
                continue;
              }
              ((ToServiceMsg)???).addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
              ac.a(this.a, (ToServiceMsg)???);
              return;
              localException = localException;
              QLog.d("MSF.C.NetConnTag", 1, "add delayMsg to send error, close LoginMerge. " + localException, localException);
              this.a.r = false;
              if (this.a.h.size() <= 0) {
                continue;
              }
              localToServiceMsg1 = (ToServiceMsg)this.a.h.poll();
              if (localToServiceMsg1 == null) {
                continue;
              }
              ac.a(this.a, localToServiceMsg1);
              continue;
              if ("RegPrxySvc.getOffMsg".equals(localToServiceMsg2.getServiceCmd()))
              {
                localToServiceMsg1.getAttributes().put("infoLoginMsg", localToServiceMsg2);
                continue;
              }
              if (!"RegPrxySvc.infoSync".equals(localToServiceMsg2.getServiceCmd())) {
                continue;
              }
              localToServiceMsg1.getAttributes().put("infoLoginMsg", localToServiceMsg2);
              continue;
              ??? = this.a;
              ((ac)???).l -= localToServiceMsg2.getWupBuffer().length;
              if (n == 0)
              {
                localToServiceMsg1.setUin(localToServiceMsg2.getUin());
                localBusiBuffItem = new SSOLoginMerge.BusiBuffItem();
                localBusiBuffItem.SeqNo.set(localToServiceMsg2.getRequestSsoSeq());
                localBusiBuffItem.ServiceCmd.set(localToServiceMsg2.getServiceCmd());
                if (localToServiceMsg2.getWupBuffer().length < 4)
                {
                  localBusiBuffItem.BusiBuffLen.set(ac.b(localToServiceMsg2.getWupBuffer()).length);
                  if (localToServiceMsg2.getWupBuffer().length < 4) {
                    continue;
                  }
                  ??? = new byte[localToServiceMsg2.getWupBuffer().length - 4];
                  System.arraycopy(localToServiceMsg2.getWupBuffer(), 4, ???, 0, ???.length);
                  localBusiBuffItem.BusiBuff.set(ByteStringMicro.copyFrom((byte[])???));
                  localBusiBuffItem.NeedResp.set(localToServiceMsg2.isNeedCallback());
                  ((SSOLoginMerge.BusiBuffData)localObject5).BusiBuffVec.add(localBusiBuffItem);
                  localArrayList.add(Integer.valueOf(localToServiceMsg2.getRequestSsoSeq()));
                  ((ArrayList)localObject6).add(localToServiceMsg2);
                  this.a.d.put(Integer.valueOf(localToServiceMsg2.getRequestSsoSeq()), localToServiceMsg2);
                  localToServiceMsg2.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(ac.t().incrementAndGet()));
                  if (localToServiceMsg2.getTimeout() != -1L) {
                    continue;
                  }
                  localToServiceMsg2.setTimeout(30000L);
                  ??? = this.a.D.msfAlarmer.a(localToServiceMsg2, localToServiceMsg2.getTimeout());
                  localToServiceMsg2.addAttribute("to_timeoutCallbacker", ???);
                  i1 = j;
                  i2 = i;
                  if (!a.x()) {
                    break;
                  }
                  l = localToServiceMsg2.getTimeout() - a.A();
                  i1 = j;
                  i2 = i;
                  if (l <= 0L) {
                    break;
                  }
                  localToServiceMsg2.addAttribute("to_predetect_timeoutCallbacker", this.a.D.msfAlarmer.b(localToServiceMsg2, l));
                  i1 = j;
                  i2 = i;
                  break;
                }
              }
              else
              {
                if (localToServiceMsg1.getUin().equals(localToServiceMsg2.getUin())) {
                  continue;
                }
                this.a.h.addFirst(localToServiceMsg2);
                ??? = this.a;
                i = ((ac)???).l;
                ((ac)???).l = (localToServiceMsg2.getWupBuffer().length + i);
                i1 = k;
                continue;
              }
              localBusiBuffItem.BusiBuffLen.set(localToServiceMsg2.getWupBuffer().length);
              continue;
              ??? = localToServiceMsg2.getWupBuffer();
              continue;
              ??? = this.a.D.msfAlarmer.a(localToServiceMsg2, localToServiceMsg2.getTimeout());
              continue;
            }
            if ((!ac.c(this.a)) && (this.a.h.size() >= this.a.j))
            {
              ac.a(this.a, true);
              ac.b(this.a).post(this.a.i);
            }
          }
          if ((!ac.c(this.a)) && (!this.a.h.isEmpty()))
          {
            ac.b(this.a).postDelayed(this.a.i, this.a.m);
            ac.a(this.a, true);
          }
        }
        int k = i;
      }
      ac.a(this.a, false);
    }
    label348:
    ??? = new ToServiceMsg("MSF SSOPackageMerge", ac.d(this.a), "SSO.LoginMerge");
    ((ToServiceMsg)???).setAppId(MsfCore.mobileQQAppid);
    ((ToServiceMsg)???).setMsfCommand(MsfCommand.unknown);
    if (((ToServiceMsg)???).getRequestSsoSeq() == -1) {
      ((ToServiceMsg)???).setRequestSsoSeq(MsfCore.getNextSeq());
    }
    ((ToServiceMsg)???).setTimeout(30000L);
    ((ToServiceMsg)???).setNeedCallback(false);
    ArrayList localArrayList = new ArrayList();
    Object localObject6 = new ArrayList();
    Object localObject5 = new SSOLoginMerge.BusiBuffData();
    int i = j;
    if (i > this.a.h.size()) {
      k = this.a.h.size();
    }
    for (;;)
    {
      int i1 = k;
      j = i;
      ToServiceMsg localToServiceMsg2;
      int i2;
      if (n < k)
      {
        localToServiceMsg2 = (ToServiceMsg)this.a.h.poll();
        i1 = i;
        i2 = m;
        if (localToServiceMsg2 == null) {
          break label1648;
        }
        if (!"RegPrxySvc.infoLogin".equals(localToServiceMsg2.getServiceCmd())) {
          break label956;
        }
        ((ToServiceMsg)???).getAttributes().put("infoLoginMsg", localToServiceMsg2);
        j = i;
        if (!localToServiceMsg2.isNeedCallback()) {
          j = i + 1;
        }
        i = m + localToServiceMsg2.getWupBuffer().length;
        if ((i < this.a.k) || (n == 0)) {
          break label1016;
        }
        this.a.h.addFirst(localToServiceMsg2);
        i1 = n;
      }
      ToServiceMsg localToServiceMsg1;
      label956:
      label1016:
      SSOLoginMerge.BusiBuffItem localBusiBuffItem;
      label1622:
      localObject5 = null;
      localObject6 = null;
      localArrayList = null;
      Object localObject3 = null;
      break;
      int m = 0;
      i = 0;
      int n = 0;
      continue;
      label1648:
      n += 1;
      m = i2;
      i = i1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ac.b
 * JD-Core Version:    0.7.0.1
 */