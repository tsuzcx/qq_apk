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

class ad$b
  implements Runnable
{
  ad$b(ad paramad) {}
  
  public void run()
  {
    int j;
    Object localObject6;
    Object localObject7;
    int i1;
    int m;
    int n;
    int i2;
    label1145:
    Object localObject3;
    label1700:
    label1711:
    synchronized (ad.a(this.a))
    {
      j = this.a.h.size();
      int i = j;
      if (j > this.a.j) {
        i = this.a.j;
      }
      long l = SystemClock.elapsedRealtime();
      if (this.a.L >= l) {
        ad.b(this.a).postDelayed(this.a.i, this.a.m);
      } else {
        ad.a(this.a, false);
      }
      if ((!ad.c(this.a)) && (this.a.h.size() - this.a.k > 0))
      {
        ad.b(this.a).postDelayed(this.a.i, this.a.m);
        ad.a(this.a, true);
      }
      if (QLog.isDevelopLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("delayWaitSendList size is ");
        ((StringBuilder)???).append(this.a.h.size());
        ((StringBuilder)???).append(", ");
        ((StringBuilder)???).append(i);
        ((StringBuilder)???).append(" sso package should be merged.");
        QLog.d("MSF.C.NetConnTag", 4, ((StringBuilder)???).toString());
      }
      Object localObject4 = null;
      if (i > 0)
      {
        j = i;
        try
        {
          if (i > this.a.h.size()) {
            j = this.a.h.size();
          }
          if (j == 1)
          {
            ??? = (ToServiceMsg)this.a.h.peek();
            if ((??? != null) && (((ToServiceMsg)???).getWupBuffer().length < this.a.o))
            {
              localObject4 = this.a;
              ((ad)localObject4).l -= ((ToServiceMsg)???).getWupBuffer().length;
              ad.a(this.a, (ToServiceMsg)this.a.h.poll());
              return;
            }
          }
          localObject4 = new ToServiceMsg("MSF SSOPackageMerge", ad.d(this.a), "SSO.LoginMerge");
          ((ToServiceMsg)localObject4).setAppId(MsfCore.mobileQQAppid);
          ((ToServiceMsg)localObject4).setMsfCommand(MsfCommand.unknown);
          if (((ToServiceMsg)localObject4).getRequestSsoSeq() == -1) {
            ((ToServiceMsg)localObject4).setRequestSsoSeq(MsfCore.getNextSeq());
          }
          ((ToServiceMsg)localObject4).setTimeout(30000L);
          ((ToServiceMsg)localObject4).setNeedCallback(false);
          localObject6 = new ArrayList();
          ??? = new ArrayList();
          localObject7 = new SSOLoginMerge.BusiBuffData();
          i = j;
          k = i;
          if (i <= this.a.h.size()) {
            break label1700;
          }
          k = this.a.h.size();
        }
        catch (Exception localException)
        {
          int k;
          ToServiceMsg localToServiceMsg;
          SSOLoginMerge.BusiBuffItem localBusiBuffItem;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("add delayMsg to send error, close LoginMerge. ");
          ((StringBuilder)localObject4).append(localException);
          QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject4).toString(), localException);
          this.a.r = false;
          while (this.a.h.size() > 0)
          {
            localObject3 = (ToServiceMsg)this.a.h.poll();
            if (localObject3 != null) {
              ad.a(this.a, (ToServiceMsg)localObject3);
            }
          }
        }
        i1 = k;
        i = j;
        if (m < k)
        {
          localToServiceMsg = (ToServiceMsg)this.a.h.poll();
          i1 = n;
          i2 = j;
          if (localToServiceMsg == null) {
            break label1711;
          }
          if ("RegPrxySvc.infoLogin".equals(localToServiceMsg.getServiceCmd())) {
            ((ToServiceMsg)localObject4).getAttributes().put("infoLoginMsg", localToServiceMsg);
          } else if ("RegPrxySvc.getOffMsg".equals(localToServiceMsg.getServiceCmd())) {
            ((ToServiceMsg)localObject4).getAttributes().put("infoLoginMsg", localToServiceMsg);
          } else if ("RegPrxySvc.infoSync".equals(localToServiceMsg.getServiceCmd())) {
            ((ToServiceMsg)localObject4).getAttributes().put("infoLoginMsg", localToServiceMsg);
          }
          i = j;
          if (!localToServiceMsg.isNeedCallback()) {
            i = j + 1;
          }
          j = n + localToServiceMsg.getWupBuffer().length;
          if ((j >= this.a.k) && (m != 0))
          {
            this.a.h.addFirst(localToServiceMsg);
            i1 = m;
          }
          else
          {
            ??? = this.a;
            ((ad)???).l -= localToServiceMsg.getWupBuffer().length;
            if (m == 0)
            {
              ((ToServiceMsg)localObject4).setUin(localToServiceMsg.getUin());
            }
            else if (!((ToServiceMsg)localObject4).getUin().equals(localToServiceMsg.getUin()))
            {
              this.a.h.addFirst(localToServiceMsg);
              ??? = this.a;
              ((ad)???).l += localToServiceMsg.getWupBuffer().length;
              i1 = k;
              break label1145;
            }
            localBusiBuffItem = new SSOLoginMerge.BusiBuffItem();
            localBusiBuffItem.SeqNo.set(localToServiceMsg.getRequestSsoSeq());
            localBusiBuffItem.ServiceCmd.set(localToServiceMsg.getServiceCmd());
            if (localToServiceMsg.getWupBuffer().length < 4) {
              localBusiBuffItem.BusiBuffLen.set(ad.b(localToServiceMsg.getWupBuffer()).length);
            } else {
              localBusiBuffItem.BusiBuffLen.set(localToServiceMsg.getWupBuffer().length);
            }
            if (localToServiceMsg.getWupBuffer().length >= 4)
            {
              ??? = new byte[localToServiceMsg.getWupBuffer().length - 4];
              System.arraycopy(localToServiceMsg.getWupBuffer(), 4, ???, 0, ???.length);
            }
            else
            {
              ??? = localToServiceMsg.getWupBuffer();
            }
            localBusiBuffItem.BusiBuff.set(ByteStringMicro.copyFrom((byte[])???));
            localBusiBuffItem.NeedResp.set(localToServiceMsg.isNeedCallback());
            ((SSOLoginMerge.BusiBuffData)localObject7).BusiBuffVec.add(localBusiBuffItem);
            ((ArrayList)localObject6).add(Integer.valueOf(localToServiceMsg.getRequestSsoSeq()));
            ((ArrayList)???).add(localToServiceMsg);
            this.a.d.put(Integer.valueOf(localToServiceMsg.getRequestSsoSeq()), localToServiceMsg);
            localToServiceMsg.getAttributes().put("__extraTimeoutSeq", Integer.valueOf(ad.t().incrementAndGet()));
            if (localToServiceMsg.getTimeout() == -1L)
            {
              localToServiceMsg.setTimeout(30000L);
              ??? = this.a.D.msfAlarmer.a(localToServiceMsg, localToServiceMsg.getTimeout());
            }
            else
            {
              ??? = this.a.D.msfAlarmer.a(localToServiceMsg, localToServiceMsg.getTimeout());
            }
            localToServiceMsg.addAttribute("to_timeoutCallbacker", ???);
            i1 = j;
            i2 = i;
            if (!a.x()) {
              break label1711;
            }
            l = localToServiceMsg.getTimeout() - a.A();
            i1 = j;
            i2 = i;
            if (l <= 0L) {
              break label1711;
            }
            localToServiceMsg.addAttribute("to_predetect_timeoutCallbacker", this.a.D.msfAlarmer.b(localToServiceMsg, l));
            i1 = j;
            i2 = i;
            break label1711;
          }
        }
        synchronized (ad.a(this.a))
        {
          if ((this.a.l >= this.a.k) && (!ad.c(this.a)))
          {
            ad.a(this.a, true);
            ad.b(this.a).post(this.a.i);
          }
          else if ((!ad.c(this.a)) && (this.a.h.size() >= this.a.j))
          {
            ad.a(this.a, true);
            ad.b(this.a).post(this.a.i);
          }
          else if ((!ad.c(this.a)) && (!this.a.h.isEmpty()))
          {
            ad.b(this.a).postDelayed(this.a.i, this.a.m);
            ad.a(this.a, true);
          }
          if (i1 > 0)
          {
            this.a.e.put(Integer.valueOf(((ToServiceMsg)localObject4).getRequestSsoSeq()), localObject6);
            this.a.f.put(Integer.valueOf(((ToServiceMsg)localObject4).getRequestSsoSeq()), ???);
            ??? = ((SSOLoginMerge.BusiBuffData)localObject7).toByteArray();
            localObject6 = new ByteArrayOutputStream();
            j.a((byte[])???, (OutputStream)localObject6);
            localObject6 = ad.b(((ByteArrayOutputStream)localObject6).toByteArray());
            ((ToServiceMsg)localObject4).putWupBuffer((byte[])localObject6);
            ((ToServiceMsg)localObject4).getAttributes().put("mergeCount", Integer.valueOf(i1));
            ((ToServiceMsg)localObject4).getAttributes().put("noRespCount", Integer.valueOf(i));
            if (QLog.isDevelopLevel())
            {
              localObject7 = new StringBuilder();
              ((StringBuilder)localObject7).append("Delay ToServiceMsg ssoseq: ");
              ((StringBuilder)localObject7).append(((ToServiceMsg)localObject4).getRequestSsoSeq());
              ((StringBuilder)localObject7).append(" delayWaitSendList buffer size is ");
              ((StringBuilder)localObject7).append(???.length);
              ((StringBuilder)localObject7).append(", zip size is ");
              ((StringBuilder)localObject7).append(localObject6.length);
              QLog.d("MSF.C.NetConnTag", 4, ((StringBuilder)localObject7).toString());
            }
          }
          if (localObject4 != null)
          {
            ((ToServiceMsg)localObject4).addAttribute("__timestamp_addSendQueue", Long.valueOf(System.currentTimeMillis()));
            ad.a(this.a, (ToServiceMsg)localObject4);
            return;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.ad.b
 * JD-Core Version:    0.7.0.1
 */