package com.tencent.mobileqq.msf.core.net.b;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class d
{
  private static final String a = "ReqAllFailDetector";
  private static final int f = 10000;
  private static final long g = 180000L;
  private CopyOnWriteArrayList b;
  private CopyOnWriteArrayList c;
  private CopyOnWriteArrayList d = new CopyOnWriteArrayList();
  private AtomicBoolean e = new AtomicBoolean(false);
  private long h = 0L;
  private String i = "";
  private int j = 0;
  private long k = 0L;
  private String l = "";
  private MsfCore m;
  private Handler n = new e(this, Looper.getMainLooper());
  
  public d(MsfCore paramMsfCore)
  {
    this.m = paramMsfCore;
    a();
  }
  
  private CopyOnWriteArrayList c()
  {
    if (NetConnInfoCenter.isWifiConn()) {
      return this.c;
    }
    if (NetConnInfoCenter.isMobileConn()) {
      return this.b;
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      if (a.ax())
      {
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
        Object localObject = o.e();
        if (localObject != null)
        {
          boolean bool = ((String)localObject).startsWith("460");
          if ((bool) || (((String)localObject).startsWith("461"))) {
            if ((!((String)localObject).startsWith("46000")) && (!((String)localObject).startsWith("46002")))
            {
              if (((String)localObject).startsWith("46001"))
              {
                localObject = new com.tencent.mobileqq.msf.core.d();
                ((com.tencent.mobileqq.msf.core.d)localObject).c("112.90.82.216");
                ((com.tencent.mobileqq.msf.core.d)localObject).a(8080);
                this.b.add(localObject);
                localObject = new com.tencent.mobileqq.msf.core.d();
                ((com.tencent.mobileqq.msf.core.d)localObject).c("112.90.83.32");
                ((com.tencent.mobileqq.msf.core.d)localObject).a(8080);
                this.b.add(localObject);
              }
              else if (((String)localObject).startsWith("46003"))
              {
                localObject = new com.tencent.mobileqq.msf.core.d();
                ((com.tencent.mobileqq.msf.core.d)localObject).c("183.60.9.149");
                ((com.tencent.mobileqq.msf.core.d)localObject).a(8080);
                this.b.add(localObject);
                localObject = new com.tencent.mobileqq.msf.core.d();
                ((com.tencent.mobileqq.msf.core.d)localObject).c("183.60.15.152");
                ((com.tencent.mobileqq.msf.core.d)localObject).a(8080);
                this.b.add(localObject);
              }
            }
            else
            {
              localObject = new com.tencent.mobileqq.msf.core.d();
              ((com.tencent.mobileqq.msf.core.d)localObject).c("120.196.210.210");
              ((com.tencent.mobileqq.msf.core.d)localObject).a(8080);
              this.b.add(localObject);
              localObject = new com.tencent.mobileqq.msf.core.d();
              ((com.tencent.mobileqq.msf.core.d)localObject).c("183.232.95.122");
              ((com.tencent.mobileqq.msf.core.d)localObject).a(8080);
              this.b.add(localObject);
            }
          }
          localObject = new com.tencent.mobileqq.msf.core.d();
          ((com.tencent.mobileqq.msf.core.d)localObject).c("120.196.210.210");
          ((com.tencent.mobileqq.msf.core.d)localObject).a(8080);
          this.c.add(localObject);
          localObject = new com.tencent.mobileqq.msf.core.d();
          ((com.tencent.mobileqq.msf.core.d)localObject).c("183.232.95.122");
          ((com.tencent.mobileqq.msf.core.d)localObject).a(8080);
          this.c.add(localObject);
          localObject = new com.tencent.mobileqq.msf.core.d();
          ((com.tencent.mobileqq.msf.core.d)localObject).c("112.90.82.216");
          ((com.tencent.mobileqq.msf.core.d)localObject).a(8080);
          this.c.add(localObject);
          localObject = new com.tencent.mobileqq.msf.core.d();
          ((com.tencent.mobileqq.msf.core.d)localObject).c("112.90.83.32");
          ((com.tencent.mobileqq.msf.core.d)localObject).a(8080);
          this.c.add(localObject);
          localObject = new com.tencent.mobileqq.msf.core.d();
          ((com.tencent.mobileqq.msf.core.d)localObject).c("183.60.9.149");
          ((com.tencent.mobileqq.msf.core.d)localObject).a(8080);
          this.c.add(localObject);
          localObject = new com.tencent.mobileqq.msf.core.d();
          ((com.tencent.mobileqq.msf.core.d)localObject).c("183.60.15.152");
          ((com.tencent.mobileqq.msf.core.d)localObject).a(8080);
          this.c.add(localObject);
        }
      }
      else
      {
        this.b = a.az();
        this.c = a.ay();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("ReqAllFailDetector", 1, "loadConfigEndpoint exception", localException);
    }
  }
  
  public void a(long paramLong1, String paramString1, int paramInt, String paramString2, long paramLong2)
  {
    Object localObject = this.e;
    int i1 = 0;
    if (!((AtomicBoolean)localObject).compareAndSet(false, true))
    {
      QLog.d("ReqAllFailDetector", 1, "startReqFailDetect fail by detect running");
      return;
    }
    try
    {
      QLog.d("ReqAllFailDetector", 1, "startReqFailDetect succ");
      localObject = c();
      if ((localObject != null) && (((CopyOnWriteArrayList)localObject).size() > 0))
      {
        QLog.d("ReqAllFailDetector", 1, "startReqFailDetect");
        this.n.sendEmptyMessageDelayed(10000, 180000L);
        this.h = paramLong1;
        this.i = paramString1;
        this.j = paramInt;
        this.l = paramString2;
        this.k = paramLong2;
        paramInt = i1;
      }
      while (paramInt < ((CopyOnWriteArrayList)localObject).size())
      {
        paramString1 = new f(this.m, (com.tencent.mobileqq.msf.core.d)((CopyOnWriteArrayList)localObject).get(paramInt), paramInt);
        paramString1.start();
        this.d.add(paramString1);
        paramInt += 1;
        continue;
        this.e.set(false);
        QLog.d("ReqAllFailDetector", 1, "stopReqFailDetect by sso empty");
        return;
      }
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      QLog.d("ReqAllFailDetector", 1, "startReqFailDetect fail by except", paramString1);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      if ((this.e.get()) && (this.d.size() > 0))
      {
        int i1 = 0;
        while (i1 < this.d.size())
        {
          ((f)this.d.get(i1)).a(paramToServiceMsg);
          i1 += 1;
        }
      }
      return;
    }
    catch (Throwable paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      QLog.d("ReqAllFailDetector", 1, "onSendRequest exception", paramToServiceMsg);
    }
  }
  
  public void b()
  {
    QLog.d("ReqAllFailDetector", 1, "stopReqFailDetect");
    Object localObject1 = this.e;
    boolean bool2 = false;
    ((AtomicBoolean)localObject1).set(false);
    for (;;)
    {
      try
      {
        Object localObject2 = new StringBuffer();
        localObject1 = this.d.iterator();
        int i2 = 0;
        int i1 = 0;
        int i4;
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (f)((Iterator)localObject1).next();
          String str = ((f)localObject3).b();
          ((f)localObject3).a();
          this.d.remove(localObject3);
          if (((StringBuffer)localObject2).length() > 0) {
            ((StringBuffer)localObject2).append("#");
          }
          ((StringBuffer)localObject2).append(str);
          i3 = i2;
          if (((f)localObject3).c)
          {
            if (!((f)localObject3).a) {
              break label575;
            }
            i3 = i2;
            if (!((f)localObject3).b) {
              break label575;
            }
          }
          i4 = i1;
          if (((f)localObject3).c)
          {
            i4 = i1;
            if (((f)localObject3).d > 30000L) {
              i4 = 1;
            }
          }
          i2 = i3;
          i1 = i4;
          if (!((f)localObject3).c) {
            continue;
          }
          i2 = i3;
          i1 = i4;
          if (((f)localObject3).e <= 30000L) {
            continue;
          }
          i1 = 1;
          i2 = i3;
          continue;
        }
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("host", this.i);
        ((HashMap)localObject1).put("port", String.valueOf(this.j));
        ((HashMap)localObject1).put("reason", String.valueOf(this.l));
        ((HashMap)localObject1).put("sendCount", String.valueOf(this.k));
        ((HashMap)localObject1).put("connTime", String.valueOf(this.h));
        ((HashMap)localObject1).put("detectInfo", ((StringBuffer)localObject2).toString());
        localObject2 = BaseApplication.getContext().getPackageName();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(Environment.getExternalStorageDirectory().getPath());
        ((StringBuilder)localObject3).append("/tencent/");
        ((StringBuilder)localObject3).append(((String)localObject2).replace(".", "/"));
        ((StringBuilder)localObject3).append("/");
        localObject2 = new File(((StringBuilder)localObject3).toString());
        boolean bool1 = bool2;
        if (((File)localObject2).exists())
        {
          bool1 = bool2;
          if (((File)localObject2).isDirectory())
          {
            localObject2 = ((File)localObject2).list();
            bool1 = bool2;
            if (localObject2 != null)
            {
              bool1 = bool2;
              if (localObject2.length > 0)
              {
                i4 = localObject2.length;
                i3 = 0;
                bool1 = bool2;
                if (i3 < i4)
                {
                  if (!localObject2[i3].endsWith(".pcap")) {
                    break label580;
                  }
                  bool1 = true;
                }
              }
            }
          }
        }
        if (this.m.statReporter != null)
        {
          this.m.statReporter.a("dim_Msf_ConnRequestAllFailDetect3", bool1, 0L, 0L, (Map)localObject1, false, false);
          if (i2 != 0) {
            this.m.statReporter.a("dim_Msf_ConnRequestAllFailDetect_Special", bool1, 0L, 0L, (Map)localObject1, false, false);
          }
          if (i1 != 0)
          {
            this.m.statReporter.a("dim_Msf_ConnRequestAllFailDetect_Special1", bool1, 0L, 0L, (Map)localObject1, false, false);
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        QLog.d("ReqAllFailDetector", 1, "stopReqFailDetect exception", localThrowable);
      }
      return;
      label575:
      int i3 = 1;
      continue;
      label580:
      i3 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.d
 * JD-Core Version:    0.7.0.1
 */