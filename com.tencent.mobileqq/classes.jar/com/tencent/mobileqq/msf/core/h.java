package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.a.c;
import com.tencent.mobileqq.msf.core.a.c.a;
import com.tencent.mobileqq.msf.core.net.b;
import com.tencent.mobileqq.msf.core.net.f;
import com.tencent.mobileqq.msf.core.net.l;
import com.tencent.mobileqq.msf.core.quicksend.QuickSendStrategy;
import com.tencent.mobileqq.msf.sdk.y;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class h
{
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  public static final String i = "send_mode";
  public static final int j = 0;
  public static final int k = 1;
  public static final String l = "unknown";
  public static final String m = "pcactive";
  public static final String n = "quicksend";
  public static final int o = 0;
  public static final int p = -1;
  public static final int q = 1;
  public static final int r = 2;
  public static final int s = 3;
  public static final int t = 4;
  public static final int u = 5;
  public static final int v = 6;
  private static final String w = "LightTcpSender";
  private int A;
  private int B;
  private boolean C;
  private final h.a D;
  b a;
  Network b = null;
  boolean c;
  boolean d;
  public final LinkedBlockingQueue e;
  private Context x;
  private MsfCore y;
  private Handler z = null;
  
  public h(MsfCore paramMsfCore, Context paramContext)
  {
    boolean bool = true;
    this.c = true;
    this.A = 10000;
    this.B = 30000;
    this.C = false;
    this.d = false;
    this.e = new LinkedBlockingQueue(100);
    this.D = new h.a(this);
    this.x = paramContext;
    this.y = paramMsfCore;
    if ((new Random().nextInt(100) % 2 != 0) || (!com.tencent.mobileqq.msf.core.a.a.bv())) {
      bool = false;
    }
    this.d = bool;
    if (!this.d) {
      this.a = new com.tencent.mobileqq.msf.core.net.g();
    } else {
      this.a = new f();
    }
    paramMsfCore = new HandlerThread("LightTcpSenderThread");
    paramMsfCore.start();
    this.z = new h.b(this, paramMsfCore.getLooper());
    l.a(this.D);
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
          arrayOfByte1 = j.b(arrayOfByte2);
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
          QLog.d("LightTcpSender", 1, "LightSender uncompress data failed", paramFromServiceMsg);
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
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt, String paramString, com.tencent.mobileqq.msf.core.quicksend.g paramg)
  {
    paramg.f = paramInt;
    if (paramFromServiceMsg == null)
    {
      FromServiceMsg localFromServiceMsg = o.a(paramToServiceMsg);
      if (localFromServiceMsg != null)
      {
        localFromServiceMsg.setBusinessFail(paramInt, paramString);
        this.y.getSsoRespHandler().a(paramToServiceMsg, localFromServiceMsg);
      }
    }
    else
    {
      this.y.getSsoRespHandler().a(paramToServiceMsg, paramFromServiceMsg);
    }
    com.tencent.mobileqq.a.a.a.a().a(paramToServiceMsg, paramFromServiceMsg, paramg);
  }
  
  private boolean a(com.tencent.mobileqq.msf.core.quicksend.g paramg, ToServiceMsg paramToServiceMsg)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  /* Error */
  private boolean a(ToServiceMsg paramToServiceMsg, com.tencent.mobileqq.msf.core.quicksend.g paramg, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 278	com/tencent/mobileqq/msf/core/h:e	()Z
    //   6: ifne +23 -> 29
    //   9: aload_0
    //   10: aload_1
    //   11: aload_2
    //   12: aload_3
    //   13: aload 4
    //   15: invokespecial 280	com/tencent/mobileqq/msf/core/h:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/mobileqq/msf/core/quicksend/g;Ljava/lang/String;Ljava/lang/String;)Z
    //   18: istore 5
    //   20: iload 5
    //   22: ifne +7 -> 29
    //   25: aload_0
    //   26: monitorexit
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_0
    //   30: invokespecial 278	com/tencent/mobileqq/msf/core/h:e	()Z
    //   33: istore 5
    //   35: iload 5
    //   37: ifeq +23 -> 60
    //   40: aload_0
    //   41: monitorexit
    //   42: iconst_1
    //   43: ireturn
    //   44: astore_1
    //   45: goto +19 -> 64
    //   48: astore_1
    //   49: ldc 42
    //   51: iconst_1
    //   52: aload_1
    //   53: invokevirtual 284	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   56: aload_1
    //   57: invokestatic 286	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   60: aload_0
    //   61: monitorexit
    //   62: iconst_0
    //   63: ireturn
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	h
    //   0	68	1	paramToServiceMsg	ToServiceMsg
    //   0	68	2	paramg	com.tencent.mobileqq.msf.core.quicksend.g
    //   0	68	3	paramString1	String
    //   0	68	4	paramString2	String
    //   18	18	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	20	44	finally
    //   29	35	44	finally
    //   49	60	44	finally
    //   2	20	48	java/lang/Throwable
    //   29	35	48	java/lang/Throwable
  }
  
  private boolean b(ToServiceMsg paramToServiceMsg, com.tencent.mobileqq.msf.core.quicksend.g paramg, String paramString1, String paramString2)
  {
    Object localObject1;
    if (NetConnInfoCenter.isWifiConn())
    {
      if (this.a.a())
      {
        localObject1 = this.y.getSsoListManager().a(c.a.a("Quic", "Wifi", "Ipv4"), true);
      }
      else
      {
        localObject2 = this.y.getSsoListManager().a(c.a.a("Http", "Wifi", "Ipv4"), true);
        CopyOnWriteArrayList localCopyOnWriteArrayList = this.y.getSsoListManager().a(c.a.a("Http", "Mobile", "Ipv4"), true);
        localObject1 = localObject2;
        if (this.c)
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
    else if (this.a.a()) {
      localObject1 = this.y.getSsoListManager().a(c.a.a("Quic", "Mobile", "Ipv4"), true);
    } else {
      localObject1 = this.y.getSsoListManager().a(c.a.a("Http", "Mobile", "Ipv4"), true);
    }
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty(paramString2)) {
      localObject2 = a((CopyOnWriteArrayList)localObject1, paramString2);
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("selectAndConnect sortedList: ");
      paramString2.append(localObject2);
      QLog.d("LightTcpSender", 2, paramString2.toString());
    }
    if (localObject2 != null)
    {
      localObject1 = ((CopyOnWriteArrayList)localObject2).iterator();
      boolean bool = false;
      while (((Iterator)localObject1).hasNext())
      {
        paramString2 = (d)((Iterator)localObject1).next();
        this.A = paramString2.g();
        this.a.a(this.A);
        this.a.a(this.b);
        long l1 = SystemClock.elapsedRealtime();
        bool = this.a.a(paramString2.c(), paramString2.f(), paramString1, paramg);
        paramg.k += 1;
        paramg.j = (SystemClock.elapsedRealtime() - l1);
        paramg.i = bool;
        if (!bool)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("connect ");
            ((StringBuilder)localObject2).append(paramString2.toString());
            ((StringBuilder)localObject2).append(" fail");
            QLog.i("LightTcpSender", 2, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("connect ");
            paramToServiceMsg.append(paramString2.toString());
            paramToServiceMsg.append(" ok");
            QLog.i("LightTcpSender", 2, paramToServiceMsg.toString());
          }
          return true;
        }
      }
      if (!bool)
      {
        paramg.g = (SystemClock.elapsedRealtime() - paramg.g);
        paramString1 = new StringBuilder();
        paramString1.append("selectAndConnect ssoseq:");
        paramString1.append(paramToServiceMsg.getRequestSsoSeq());
        paramString1.append(", connect all failed");
        a(paramToServiceMsg, null, 2, paramString1.toString(), paramg);
      }
      return false;
    }
    QLog.w("LightTcpSender", 1, "selectAndConnect ssolist is null");
    return false;
  }
  
  private String d(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg != null) && (paramToServiceMsg.getServiceCmd().equals("MessageSvc.QueryPullUp"))) {
      return "pcactive";
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.isQuickSendEnable()) && (QuickSendStrategy.getStragegyArgs(paramToServiceMsg.getQuickSendStrategy()) != null)) {
      return "quicksend";
    }
    return "unknown";
  }
  
  private boolean e()
  {
    return this.a.b();
  }
  
  private byte[] e(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return null;
    }
    try
    {
      localObject = paramToServiceMsg.getServiceCmd();
      byte[] arrayOfByte1 = paramToServiceMsg.getWupBuffer();
      int i1 = 0;
      byte[] arrayOfByte2;
      if (arrayOfByte1 != null)
      {
        byte b1 = f();
        byte b2 = (byte)NetConnInfoCenter.getActiveNetIpFamily(false);
        if (paramToServiceMsg.getAttributes().containsKey("send_mode")) {
          i1 = ((Integer)paramToServiceMsg.getAttributes().get("send_mode")).intValue();
        }
        try
        {
          arrayOfByte1 = ad.b(paramToServiceMsg, b2);
        }
        catch (Exception localException)
        {
          QLog.d("LightTcpSender", 1, "", localException);
          arrayOfByte2 = null;
        }
        if (i1 == 1)
        {
          if (591 == CodecWarpper.getSharedObjectVersion())
          {
            arrayOfByte2 = CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", (String)localObject, null, paramToServiceMsg.getAppId(), this.y.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, paramToServiceMsg.getWupBuffer(), true);
            paramToServiceMsg = arrayOfByte2;
          }
          else if ((595 != CodecWarpper.getSharedObjectVersion()) && (600 != CodecWarpper.getSharedObjectVersion()))
          {
            arrayOfByte2 = CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", (String)localObject, null, paramToServiceMsg.getAppId(), this.y.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, b2, arrayOfByte2, null, paramToServiceMsg.getWupBuffer(), true);
            paramToServiceMsg = arrayOfByte2;
          }
          else
          {
            arrayOfByte2 = CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", (String)localObject, null, paramToServiceMsg.getAppId(), this.y.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, arrayOfByte2, null, paramToServiceMsg.getWupBuffer(), true);
            paramToServiceMsg = arrayOfByte2;
          }
        }
        else if (591 == CodecWarpper.getSharedObjectVersion())
        {
          arrayOfByte2 = CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", (String)localObject, null, paramToServiceMsg.getAppId(), this.y.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, paramToServiceMsg.getWupBuffer(), true);
          paramToServiceMsg = arrayOfByte2;
        }
        else if ((595 != CodecWarpper.getSharedObjectVersion()) && (600 != CodecWarpper.getSharedObjectVersion()))
        {
          arrayOfByte2 = CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", (String)localObject, null, paramToServiceMsg.getAppId(), this.y.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, b2, arrayOfByte2, null, paramToServiceMsg.getWupBuffer(), true);
          paramToServiceMsg = arrayOfByte2;
        }
        else
        {
          arrayOfByte2 = CodecWarpper.nativeEncodeRequest(paramToServiceMsg.getRequestSsoSeq(), o.d(), o.f(), o.g(), "", (String)localObject, null, paramToServiceMsg.getAppId(), this.y.getMsfAppid(), paramToServiceMsg.getUin(), (byte)0, b1, arrayOfByte2, null, paramToServiceMsg.getWupBuffer(), true);
          paramToServiceMsg = arrayOfByte2;
        }
      }
      else
      {
        arrayOfByte2 = new byte[0];
        paramToServiceMsg = arrayOfByte2;
      }
      return paramToServiceMsg;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("LightSender get packet fail ssoseq: ");
      ((StringBuilder)localObject).append(paramToServiceMsg.getRequestSsoSeq());
      QLog.d("LightTcpSender", 1, ((StringBuilder)localObject).toString(), localThrowable);
    }
    return null;
  }
  
  private byte f()
  {
    Object localObject = this.b;
    if (localObject != null) {
      try
      {
        if (l.a(this.x, (Network)localObject, 0))
        {
          ConnectivityManager localConnectivityManager = (ConnectivityManager)this.x.getSystemService("connectivity");
          if (localConnectivityManager != null)
          {
            localObject = localConnectivityManager.getNetworkInfo((Network)localObject);
            if (localObject != null) {
              i1 = ((NetworkInfo)localObject).getSubtype();
            } else {
              i1 = ((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getNetworkType();
            }
            i2 = y.a(i1);
            int i1 = i2;
            if (i2 != 20) {
              i1 = i2 + 100;
            }
            i2 = i1;
            if (i1 <= 254) {
              break label187;
            }
            if (!QLog.isColorLevel()) {
              break label183;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("error,netWorkType is ");
            ((StringBuilder)localObject).append(254);
            QLog.d("LightTcpSender", 2, ((StringBuilder)localObject).toString());
            break label183;
          }
        }
        else
        {
          boolean bool = l.a(this.x, (Network)localObject, 0);
          if (bool) {
            return 1;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    } else {
      return 0;
    }
    label183:
    int i2 = 254;
    label187:
    return (byte)i2;
  }
  
  public void a(int paramInt)
  {
    this.C = true;
    this.z.removeMessages(1);
    this.z.sendEmptyMessageDelayed(1, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("LightTcpSender", 2, "closeMobileNetwork");
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    this.e.remove(paramToServiceMsg);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("removeMsg size=");
      paramToServiceMsg.append(this.e.size());
      QLog.i("LightTcpSender", 2, paramToServiceMsg.toString());
    }
  }
  
  public boolean a()
  {
    return l.a(this.x, this.b, 0);
  }
  
  public void b()
  {
    this.C = false;
    this.z.removeMessages(1);
    if (QLog.isColorLevel()) {
      QLog.i("LightTcpSender", 2, "cancelToCloseMobilework");
    }
  }
  
  public boolean b(ToServiceMsg paramToServiceMsg)
  {
    if (!this.e.contains(paramToServiceMsg)) {
      if (this.e.offer(paramToServiceMsg))
      {
        this.C = false;
        this.z.removeMessages(1);
        this.z.sendEmptyMessage(2);
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("sendMsg size=");
          paramToServiceMsg.append(this.e.size());
          QLog.i("LightTcpSender", 2, paramToServiceMsg.toString());
          return true;
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("sendMsg Queue Full size=");
          paramToServiceMsg.append(this.e.size());
          QLog.i("LightTcpSender", 2, paramToServiceMsg.toString());
        }
        return false;
      }
    }
    return true;
  }
  
  public void c()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      if ("MessageSvc.QueryPullUp".equals(((ToServiceMsg)localIterator.next()).getServiceCmd())) {
        localIterator.remove();
      }
    }
  }
  
  public boolean c(ToServiceMsg paramToServiceMsg)
  {
    return this.e.contains(paramToServiceMsg);
  }
  
  public void d()
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      ToServiceMsg localToServiceMsg = (ToServiceMsg)localIterator.next();
      if ("MessageSvc.QueryPullUp".equals(localToServiceMsg.getServiceCmd())) {
        localToServiceMsg.getAttributes().put("RequestEcho", Boolean.valueOf(false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.h
 * JD-Core Version:    0.7.0.1
 */