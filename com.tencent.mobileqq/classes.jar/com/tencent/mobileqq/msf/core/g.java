package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.a.c;
import com.tencent.mobileqq.msf.core.a.c.a;
import com.tencent.mobileqq.msf.core.quicksend.QuickSendStrategy;
import com.tencent.mobileqq.msf.core.quicksend.f;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class g
{
  public static final String a = "send_mode";
  public static final int b = 0;
  public static final int c = 1;
  public static final String d = "unknown";
  public static final String e = "pcactive";
  public static final String f = "quicksend";
  public static final int g = 0;
  public static final int h = -1;
  public static final int i = 1;
  public static final int j = 2;
  public static final int k = 3;
  public static final int l = 4;
  public static final int m = 5;
  public static final int n = 6;
  public static final String o = "light_sender_type";
  public static final int p = 0;
  public static final int q = 1;
  private static final String r = "LightSender";
  private MsfCore s;
  private LinkedBlockingQueue t = new LinkedBlockingQueue();
  private ConcurrentLinkedQueue u = new ConcurrentLinkedQueue();
  private long v = 0L;
  private ThreadPoolExecutor w;
  private int x = com.tencent.mobileqq.msf.core.a.a.ac();
  private int y = com.tencent.mobileqq.msf.core.a.a.ac();
  private int z = 60;
  
  public g(MsfCore paramMsfCore, Context paramContext)
  {
    this.s = paramMsfCore;
    CodecWarpper.nativeSetKsid(paramMsfCore.getAccountCenter().f());
    if (Build.VERSION.SDK_INT >= 9)
    {
      this.w = new ThreadPoolExecutor(this.x, this.y, this.z, TimeUnit.SECONDS, this.t, new g.a("LightSender"));
      this.w.allowCoreThreadTimeOut(true);
      return;
    }
    this.w = new ThreadPoolExecutor(1, 1, this.z, TimeUnit.SECONDS, this.t, new g.a("LightSender"));
  }
  
  private FromServiceMsg a(FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg.getFlag() & 0x1) != 0)
    {
      byte[] arrayOfByte1 = paramFromServiceMsg.getWupBuffer();
      if (arrayOfByte1.length > 4)
      {
        int i1 = (arrayOfByte1[0] & 0xFF) << 24 | 0x0 | (arrayOfByte1[1] & 0xFF) << 16 | (arrayOfByte1[2] & 0xFF) << 8 | arrayOfByte1[3] & 0xFF;
        try
        {
          byte[] arrayOfByte2 = new byte[i1];
          System.arraycopy(arrayOfByte1, 4, arrayOfByte2, 0, i1 - 4);
          arrayOfByte1 = com.tencent.qphone.base.util.j.b(arrayOfByte2);
          arrayOfByte2 = new byte[arrayOfByte1.length + 4];
          arrayOfByte2[0] = ((byte)(arrayOfByte1.length + 4 >> 24 & 0xFF));
          arrayOfByte2[1] = ((byte)(arrayOfByte1.length + 4 >> 16 & 0xFF));
          arrayOfByte2[2] = ((byte)(arrayOfByte1.length + 4 >> 8 & 0xFF));
          arrayOfByte2[3] = ((byte)(arrayOfByte1.length + 4 & 0xFF));
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 4, arrayOfByte1.length);
          paramFromServiceMsg.putWupBuffer(arrayOfByte2);
          return paramFromServiceMsg;
        }
        catch (Throwable paramFromServiceMsg)
        {
          QLog.d("LightSender", 1, "LightSender uncompress data failed", paramFromServiceMsg);
        }
      }
      return null;
    }
    return paramFromServiceMsg;
  }
  
  private CopyOnWriteArrayList a(CopyOnWriteArrayList paramCopyOnWriteArrayList, String paramString)
  {
    if ((paramCopyOnWriteArrayList != null) && (paramCopyOnWriteArrayList.size() > 0))
    {
      if (TextUtils.isEmpty(paramString)) {
        return paramCopyOnWriteArrayList;
      }
      CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
      while (paramCopyOnWriteArrayList.hasNext())
      {
        d locald = (d)paramCopyOnWriteArrayList.next();
        if ((locald != null) && (paramString.equals(locald.i))) {
          localCopyOnWriteArrayList.add(0, locald);
        } else {
          localCopyOnWriteArrayList.add(locald);
        }
      }
      return localCopyOnWriteArrayList;
    }
    return paramCopyOnWriteArrayList;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt, String paramString, f paramf)
  {
    paramf.f = paramInt;
    if (paramFromServiceMsg == null)
    {
      FromServiceMsg localFromServiceMsg = o.a(paramToServiceMsg);
      if (localFromServiceMsg != null)
      {
        localFromServiceMsg.setBusinessFail(paramInt, paramString);
        this.s.getSsoRespHandler().a(paramToServiceMsg, localFromServiceMsg);
      }
    }
    else
    {
      this.s.getSsoRespHandler().a(paramToServiceMsg, paramFromServiceMsg);
    }
    com.tencent.mobileqq.a.a.a.a().a(paramToServiceMsg, paramFromServiceMsg, paramf);
  }
  
  private boolean a(com.tencent.mobileqq.msf.core.net.b paramb, String paramString1, int paramInt, f paramf, String paramString2, boolean paramBoolean)
  {
    Object localObject1;
    if (NetConnInfoCenter.isWifiConn())
    {
      if (paramb.a())
      {
        localObject1 = this.s.getSsoListManager().a(c.a.a("Quic", "Wifi", "Ipv4"), true);
      }
      else
      {
        localObject2 = this.s.getSsoListManager().a(c.a.a("Http", "Wifi", "Ipv4"), true);
        CopyOnWriteArrayList localCopyOnWriteArrayList = this.s.getSsoListManager().a(c.a.a("Http", "Mobile", "Ipv4"), true);
        localObject1 = localObject2;
        if (paramf.l)
        {
          localObject1 = localObject2;
          if (localCopyOnWriteArrayList != null)
          {
            localObject1 = localObject2;
            if (localCopyOnWriteArrayList.size() > 0) {
              localObject1 = localCopyOnWriteArrayList;
            }
          }
        }
      }
    }
    else if (paramb.a()) {
      localObject1 = this.s.getSsoListManager().a(c.a.a("Quic", "Mobile", "Ipv4"), true);
    } else {
      localObject1 = this.s.getSsoListManager().a(c.a.a("Http", "Mobile", "Ipv4"), true);
    }
    Object localObject2 = localObject1;
    if (paramBoolean) {
      localObject2 = a((CopyOnWriteArrayList)localObject1, paramString2);
    }
    if (localObject2 != null)
    {
      paramString2 = ((CopyOnWriteArrayList)localObject2).iterator();
      while (paramString2.hasNext())
      {
        localObject1 = (d)paramString2.next();
        paramb.a(((d)localObject1).g());
        long l1 = SystemClock.elapsedRealtime();
        paramBoolean = paramb.a(((d)localObject1).c(), ((d)localObject1).f(), paramString1, paramf);
        paramf.k += 1;
        if (paramBoolean)
        {
          paramf.j = (SystemClock.elapsedRealtime() - l1);
          return true;
        }
      }
      paramb = new StringBuilder();
      paramb.append("LightSender connect all fail ssoseq:");
      paramb.append(paramInt);
      QLog.d("LightSender", 1, paramb.toString());
      return false;
    }
    paramb = new StringBuilder();
    paramb.append("LightSender ssolist is empty ssoseq:");
    paramb.append(paramInt);
    QLog.d("LightSender", 1, paramb.toString());
    return false;
  }
  
  private boolean c()
  {
    return this.t.size() + this.w.getActiveCount() >= this.y;
  }
  
  private void d(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LightSender, addSendQueue cmd:");
        ((StringBuilder)localObject).append(paramToServiceMsg.getServiceCmd());
        ((StringBuilder)localObject).append(" ssoSeq:");
        ((StringBuilder)localObject).append(paramToServiceMsg.getRequestSsoSeq());
        QLog.d("LightSender", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new g.b(this, paramToServiceMsg);
      this.w.submit((Runnable)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("submit task failed, cmd:");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      localStringBuilder.append(" ssoSeq:");
      localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
      QLog.d("LightSender", 1, localStringBuilder.toString(), localException);
    }
  }
  
  private String e(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramToServiceMsg.getServiceCmd().equals("MessageSvc.QueryPullUp"))) {
      return "pcactive";
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.isQuickSendEnable()) && (QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy()) != null)) {
      return "quicksend";
    }
    return "unknown";
  }
  
  private byte[] f(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return null;
    }
    try
    {
      localObject = paramToServiceMsg.getServiceCmd();
      byte[] arrayOfByte1 = paramToServiceMsg.getWupBuffer();
      int i1 = 0;
      byte[] arrayOfByte3;
      if (arrayOfByte1 != null)
      {
        byte b1 = com.tencent.mobileqq.msf.core.net.j.b();
        if (b1 == 0)
        {
          long l1 = System.currentTimeMillis();
          if ((this.v == 0L) || (l1 - this.v > 60000L))
          {
            this.v = l1;
            try
            {
              NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
            }
            catch (Throwable localThrowable1)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("checkConnInfo ");
              localStringBuilder.append(localThrowable1);
              QLog.d("LightSender", 1, localStringBuilder.toString());
            }
          }
        }
        byte b2 = (byte)NetConnInfoCenter.getActiveNetIpFamily(false);
        if (paramToServiceMsg.getAttributes().containsKey("send_mode")) {
          i1 = ((Integer)paramToServiceMsg.getAttributes().get("send_mode")).intValue();
        }
        try
        {
          byte[] arrayOfByte2 = ac.b(paramToServiceMsg, b2);
        }
        catch (Exception localException)
        {
          QLog.d("LightSender", 1, "", localException);
          arrayOfByte3 = null;
        }
        if (i1 == 1)
        {
          if (591 == CodecWarpper.getSharedObjectVersion())
          {
            arrayOfByte3 = CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", (String)localObject, null, paramToServiceMsg.getAppId(), this.s.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, paramToServiceMsg.getWupBuffer(), true);
            paramToServiceMsg = arrayOfByte3;
          }
          else if ((595 != CodecWarpper.getSharedObjectVersion()) && (600 != CodecWarpper.getSharedObjectVersion()))
          {
            arrayOfByte3 = CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", (String)localObject, null, paramToServiceMsg.getAppId(), this.s.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, b2, arrayOfByte3, null, paramToServiceMsg.getWupBuffer(), true);
            paramToServiceMsg = arrayOfByte3;
          }
          else
          {
            arrayOfByte3 = CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", (String)localObject, null, paramToServiceMsg.getAppId(), this.s.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, arrayOfByte3, null, paramToServiceMsg.getWupBuffer(), true);
            paramToServiceMsg = arrayOfByte3;
          }
        }
        else if (591 == CodecWarpper.getSharedObjectVersion())
        {
          arrayOfByte3 = CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", (String)localObject, null, paramToServiceMsg.getAppId(), this.s.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, paramToServiceMsg.getWupBuffer(), true);
          paramToServiceMsg = arrayOfByte3;
        }
        else if ((595 != CodecWarpper.getSharedObjectVersion()) && (600 != CodecWarpper.getSharedObjectVersion()))
        {
          arrayOfByte3 = CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", (String)localObject, null, paramToServiceMsg.getAppId(), this.s.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, b2, arrayOfByte3, null, paramToServiceMsg.getWupBuffer(), true);
          paramToServiceMsg = arrayOfByte3;
        }
        else
        {
          arrayOfByte3 = CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", (String)localObject, null, paramToServiceMsg.getAppId(), this.s.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, arrayOfByte3, null, paramToServiceMsg.getWupBuffer(), true);
          paramToServiceMsg = arrayOfByte3;
        }
      }
      else
      {
        arrayOfByte3 = new byte[0];
        paramToServiceMsg = arrayOfByte3;
      }
      return paramToServiceMsg;
    }
    catch (Throwable localThrowable2)
    {
      localThrowable2.printStackTrace();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LightSender get packet fail ssoseq: ");
      ((StringBuilder)localObject).append(paramToServiceMsg.getRequestSsoSeq());
      QLog.d("LightSender", 1, ((StringBuilder)localObject).toString(), localThrowable2);
    }
    return null;
  }
  
  public void a()
  {
    if (!this.t.isEmpty())
    {
      Iterator localIterator = this.t.iterator();
      while (localIterator.hasNext())
      {
        g.b localb = (g.b)localIterator.next();
        if ((localb != null) && (localb.a != null) && (localb.a.getServiceName().equals("MessageSvc.QueryPullUp"))) {
          localIterator.remove();
        }
      }
    }
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return false;
    }
    for (;;)
    {
      try
      {
        if (paramToServiceMsg.getAttributes().containsKey("light_sender_type"))
        {
          i1 = ((Integer)paramToServiceMsg.getAttributes().get("light_sender_type")).intValue();
          if ((i1 == 1) && (c()))
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("LightSender busy returns, cmd:");
              localStringBuilder.append(paramToServiceMsg.getServiceCmd());
              localStringBuilder.append(" ssoSeq:");
              localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
              QLog.d("LightSender", 2, localStringBuilder.toString());
            }
            return false;
          }
          d(paramToServiceMsg);
          return true;
        }
      }
      finally {}
      int i1 = 0;
    }
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, boolean paramBoolean, Object paramObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b()
  {
    if (!this.u.isEmpty())
    {
      Iterator localIterator = this.u.iterator();
      while (localIterator.hasNext())
      {
        ToServiceMsg localToServiceMsg = (ToServiceMsg)localIterator.next();
        if (localToServiceMsg.getServiceCmd().equals("MessageSvc.QueryPullUp")) {
          localToServiceMsg.getAttributes().put("RequestEcho", Boolean.valueOf(false));
        }
      }
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)localIterator.next();
      if (paramToServiceMsg.getRequestSsoSeq() == localToServiceMsg.getRequestSsoSeq()) {
        localIterator.remove();
      }
    }
  }
  
  public boolean c(ToServiceMsg paramToServiceMsg)
  {
    return a(paramToServiceMsg, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.g
 * JD-Core Version:    0.7.0.1
 */