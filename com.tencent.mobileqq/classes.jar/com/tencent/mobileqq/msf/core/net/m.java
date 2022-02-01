package com.tencent.mobileqq.msf.core.net;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.aj;
import com.tencent.mobileqq.msf.core.b.c;
import com.tencent.mobileqq.msf.core.net.a.e;
import com.tencent.mobileqq.msf.core.net.a.f;
import com.tencent.mobileqq.msf.core.push.g;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class m
{
  public static final int a = -100;
  public static final int b = -200;
  public static final int p = 10000;
  public static ArrayList q = new ArrayList();
  private static final int t = 30000;
  private static final int u = 2048;
  private long A = 0L;
  private long B = SystemClock.uptimeMillis();
  private AtomicLong C = new AtomicLong();
  private AtomicLong D = new AtomicLong();
  private ReentrantLock E = new ReentrantLock();
  private Runnable F;
  private final int G;
  protected InetSocketAddress c;
  com.tencent.mobileqq.msf.core.d d;
  int e;
  int f = 30000;
  public h g;
  OutputStream h = null;
  public d i;
  m.a j = null;
  MsfSocketInputBuffer k = null;
  public String l = "";
  public int m = 0;
  public int n = 0;
  public int o = 0;
  MsfCore r;
  private AtomicInteger s = new AtomicInteger();
  private AtomicBoolean v = new AtomicBoolean();
  private AtomicBoolean w = new AtomicBoolean();
  private AtomicBoolean x = new AtomicBoolean();
  private ToServiceMsg y;
  private long z = 0L;
  
  public m(MsfCore paramMsfCore, int paramInt)
  {
    this.r = paramMsfCore;
    this.G = paramInt;
  }
  
  private void b(boolean paramBoolean)
  {
    for (;;)
    {
      ToServiceMsg localToServiceMsg;
      try
      {
        localToServiceMsg = new ToServiceMsg("", "0", "MSF");
        localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
        localToServiceMsg.setMsfCommand(MsfCommand.msf_ssoping);
        long l1 = com.tencent.mobileqq.msf.core.a.a.u();
        if (l1 > 10000L)
        {
          localToServiceMsg.setTimeout(l1);
          break label356;
          String str1;
          QLog.d("MSF.C.NetConnTag", 1, "ssoping cmd:" + str1 + " seq: " + localToServiceMsg.getRequestSsoSeq() + " timeout: " + localToServiceMsg.getTimeout());
          int i1 = str1.getBytes().length + 13 + 1 + 0 + 4;
          byte b1 = (byte)(str1.getBytes().length + 1);
          ByteBuffer localByteBuffer = ByteBuffer.allocate(i1);
          localByteBuffer.putInt(i1).putInt(20140601).putInt(0).put(b1).put(str1.getBytes()).put((byte)5).putInt(0);
          localToServiceMsg.putWupBuffer(localByteBuffer.array());
          this.y = localToServiceMsg;
          this.r.sender.c(localToServiceMsg);
          localToServiceMsg.getAttributes().put("__timestamp_msf2net", Long.valueOf(SystemClock.elapsedRealtime()));
          if (a(this.r.getMsfAppid(), 0, localToServiceMsg.getRequestSsoSeq(), localToServiceMsg.getUin(), localToServiceMsg.getServiceCmd(), "", localToServiceMsg.getMsfCommand(), localToServiceMsg.getWupBuffer(), null) > 0) {
            com.tencent.mobileqq.a.a.a.a().a(localToServiceMsg);
          }
        }
        else
        {
          localToServiceMsg.setTimeout(10000L);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("MSF.C.NetConnTag", 1, "send SSOPing pkg fail, exception ", localException);
        return;
      }
      label356:
      do
      {
        str2 = "GWv4";
        break;
        this.r.sender.c(localToServiceMsg.getRequestSsoSeq());
        this.r.sender.d(localToServiceMsg);
        QLog.d("MSF.C.NetConnTag", 1, "send SSOPing pkg fail");
        b(com.tencent.qphone.base.a.C);
        return;
      } while (paramBoolean);
      String str2 = "MSF";
    }
  }
  
  private void m()
  {
    if ((this.r != null) && (this.r.pushManager != null) && (this.r.pushManager.as != null))
    {
      this.r.sendSsoMsg(this.r.pushManager.as);
      this.r.pushManager.as = null;
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, MsfCommand paramMsfCommand, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg)
  {
    if ((this.w.get()) || (!this.v.get()) || (this.i == null)) {
      return -100;
    }
    if (paramMsfCommand == MsfCommand.openConn) {}
    for (;;)
    {
      return paramArrayOfByte.length;
      paramString3 = this.i.a(this.d, paramString1, paramString2, paramArrayOfByte);
      if (paramString2.equals("SSO.LoginMerge"))
      {
        if (!this.r.sender.r)
        {
          paramString1 = (ArrayList)this.r.sender.e.remove(Integer.valueOf(paramInt3));
          QLog.d("MSF.C.NetConnTag", 1, "NetChanged devide merge package, " + Arrays.toString(paramString1.toArray()) + " resend.");
          if (paramString1 != null)
          {
            paramString1 = paramString1.iterator();
            while (paramString1.hasNext())
            {
              paramString2 = (Integer)paramString1.next();
              paramString2 = this.r.sender.c(paramString2.intValue());
              this.r.sender.b(paramString2);
            }
          }
          return -200;
        }
        if (paramToServiceMsg != null) {
          this.r.sender.a(paramToServiceMsg, this.g.hashCode());
        }
        label243:
        if ((!aj.s) || (!f.a())) {
          break label556;
        }
        QLog.d("MSF.C.NetConnTag", 1, "send data in socket adaptor way");
      }
      for (;;)
      {
        try
        {
          if (this.r.sender.I != null) {
            this.r.sender.I.b().a(paramString3, this.g, paramInt3);
          }
          this.C.addAndGet(paramString3.length);
          paramString3 = new StringBuilder();
          if (!QLog.isDevelopLevel()) {
            break label575;
          }
          QLog.d("MSF.C.NetConnTag", 1, "netSend appid:" + paramInt1 + " appSeq:" + paramInt2 + " ssoSeq:" + paramInt3 + " uin:" + MsfSdkUtils.getShortUin(paramString1) + " cmd:" + paramString2 + " len:" + paramArrayOfByte.length + new StringBuilder().append(" ").append(Integer.toHexString(this.g.hashCode())).toString());
          break;
          if (paramString2.equals("RegPrxySvc.infoLogin"))
          {
            this.r.sender.a(paramToServiceMsg, this.g.hashCode());
            break label243;
          }
          if (paramString2.equals("RegPrxySvc.getOffMsg"))
          {
            this.r.sender.a(paramToServiceMsg, this.g.hashCode());
            break label243;
          }
          if (!paramString2.equals("RegPrxySvc.infoSync")) {
            break label243;
          }
          this.r.sender.a(paramToServiceMsg, this.g.hashCode());
        }
        catch (Exception paramMsfCommand)
        {
          QLog.d("MSF.C.NetConnTag", 1, "", paramMsfCommand);
          continue;
        }
        label556:
        this.h.write(paramString3);
        this.h.flush();
      }
      label575:
      QLog.d("MSF.C.NetConnTag", 1, "netSend ssoSeq:" + paramInt3 + " uin:" + MsfSdkUtils.getShortUin(paramString1) + " cmd:" + c.a(paramString2) + new StringBuilder().append(" ").append(paramArrayOfByte.length + paramInt3).toString() + new StringBuilder().append(" ").append(Integer.toHexString(this.g.hashCode())).toString());
    }
  }
  
  public InetSocketAddress a()
  {
    return this.c;
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.msf.core.d paramd, d paramd1, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	com/tencent/mobileqq/msf/core/net/m:w	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 342	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifne +13 -> 20
    //   10: aload_0
    //   11: getfield 100	com/tencent/mobileqq/msf/core/net/m:v	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   14: invokevirtual 342	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   17: ifne +28 -> 45
    //   20: aload_0
    //   21: getfield 102	com/tencent/mobileqq/msf/core/net/m:w	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   24: invokevirtual 342	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   27: ifeq +18 -> 45
    //   30: aload_0
    //   31: getfield 102	com/tencent/mobileqq/msf/core/net/m:w	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   34: iconst_0
    //   35: invokevirtual 497	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   38: aload_0
    //   39: getstatic 499	com/tencent/qphone/base/a:f	Lcom/tencent/qphone/base/a;
    //   42: invokevirtual 325	com/tencent/mobileqq/msf/core/net/m:b	(Lcom/tencent/qphone/base/a;)V
    //   45: aload_0
    //   46: getfield 245	com/tencent/mobileqq/msf/core/net/m:y	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   49: ifnull +22 -> 71
    //   52: aload_0
    //   53: invokevirtual 502	com/tencent/mobileqq/msf/core/net/m:h	()Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   56: pop
    //   57: aload_0
    //   58: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   61: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   64: aload_0
    //   65: getfield 504	com/tencent/mobileqq/msf/core/net/m:F	Ljava/lang/Runnable;
    //   68: invokevirtual 507	com/tencent/mobileqq/msf/core/aj:a	(Ljava/lang/Runnable;)V
    //   71: aload_0
    //   72: aload_1
    //   73: putfield 349	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   76: aload_0
    //   77: aload_2
    //   78: putfield 344	com/tencent/mobileqq/msf/core/net/m:i	Lcom/tencent/mobileqq/msf/core/net/d;
    //   81: aload_0
    //   82: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   85: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   88: aload_1
    //   89: invokevirtual 511	com/tencent/mobileqq/msf/core/d:j	()Z
    //   92: putfield 363	com/tencent/mobileqq/msf/core/aj:r	Z
    //   95: getstatic 516	com/tencent/mobileqq/msf/core/net/x:b	Lcom/tencent/mobileqq/msf/core/net/x;
    //   98: astore 14
    //   100: ldc 82
    //   102: astore 15
    //   104: aload_0
    //   105: lconst_0
    //   106: putfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   109: aload_0
    //   110: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   113: ldc2_w 517
    //   116: getstatic 524	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   119: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   122: ifeq +2662 -> 2784
    //   125: invokestatic 263	android/os/SystemClock:elapsedRealtime	()J
    //   128: lstore 8
    //   130: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   133: lstore 6
    //   135: aload_0
    //   136: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   139: putfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   142: invokestatic 538	com/tencent/mobileqq/a/a/a$c:a	()Lcom/tencent/mobileqq/a/a/a$c;
    //   145: iconst_0
    //   146: aload_1
    //   147: invokevirtual 541	com/tencent/mobileqq/a/a/a$c:a	(ZLcom/tencent/mobileqq/msf/core/d;)V
    //   150: aload 15
    //   152: astore 12
    //   154: lload 6
    //   156: lstore 4
    //   158: aload 14
    //   160: astore 11
    //   162: aload 15
    //   164: astore 13
    //   166: aload 14
    //   168: astore_2
    //   169: aload_0
    //   170: new 543	java/net/InetSocketAddress
    //   173: dup
    //   174: aload_1
    //   175: invokevirtual 545	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   178: aload_1
    //   179: invokevirtual 547	com/tencent/mobileqq/msf/core/d:f	()I
    //   182: invokespecial 550	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   185: putfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   188: aload 15
    //   190: astore 12
    //   192: lload 6
    //   194: lstore 4
    //   196: aload 14
    //   198: astore 11
    //   200: aload 15
    //   202: astore 13
    //   204: aload 14
    //   206: astore_2
    //   207: invokestatic 298	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   210: invokevirtual 552	com/tencent/mobileqq/a/a/a:c	()V
    //   213: aload 15
    //   215: astore 12
    //   217: lload 6
    //   219: lstore 4
    //   221: aload 14
    //   223: astore 11
    //   225: aload 15
    //   227: astore 13
    //   229: aload 14
    //   231: astore_2
    //   232: new 181	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   239: astore 17
    //   241: aload 15
    //   243: astore 12
    //   245: lload 6
    //   247: lstore 4
    //   249: aload 14
    //   251: astore 11
    //   253: aload 15
    //   255: astore 13
    //   257: aload 14
    //   259: astore_2
    //   260: ldc_w 554
    //   263: iconst_1
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: aload_1
    //   270: invokevirtual 555	com/tencent/mobileqq/msf/core/d:toString	()Ljava/lang/String;
    //   273: aastore
    //   274: invokestatic 559	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   277: invokestatic 564	com/tencent/mobileqq/msf/core/aq:a	(Ljava/lang/String;)V
    //   280: aload 15
    //   282: astore 12
    //   284: lload 6
    //   286: lstore 4
    //   288: aload 14
    //   290: astore 11
    //   292: aload 15
    //   294: astore 13
    //   296: aload 14
    //   298: astore_2
    //   299: invokestatic 442	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   302: ifeq +2491 -> 2793
    //   305: aload 15
    //   307: astore 12
    //   309: lload 6
    //   311: lstore 4
    //   313: aload 14
    //   315: astore 11
    //   317: aload 15
    //   319: astore 13
    //   321: aload 14
    //   323: astore_2
    //   324: aload 17
    //   326: ldc_w 566
    //   329: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_1
    //   333: invokevirtual 555	com/tencent/mobileqq/msf/core/d:toString	()Ljava/lang/String;
    //   336: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: astore 18
    //   341: aload 15
    //   343: astore 12
    //   345: lload 6
    //   347: lstore 4
    //   349: aload 14
    //   351: astore 11
    //   353: aload 15
    //   355: astore 13
    //   357: aload 14
    //   359: astore_2
    //   360: aload_1
    //   361: getfield 568	com/tencent/mobileqq/msf/core/d:g	Z
    //   364: ifeq +2421 -> 2785
    //   367: ldc_w 570
    //   370: astore 16
    //   372: aload 15
    //   374: astore 12
    //   376: lload 6
    //   378: lstore 4
    //   380: aload 14
    //   382: astore 11
    //   384: aload 15
    //   386: astore 13
    //   388: aload 14
    //   390: astore_2
    //   391: aload 18
    //   393: aload 16
    //   395: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: ldc_w 572
    //   401: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokestatic 577	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   407: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   410: ldc_w 579
    //   413: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: astore 18
    //   418: aload 15
    //   420: astore 12
    //   422: lload 6
    //   424: lstore 4
    //   426: aload 14
    //   428: astore 11
    //   430: aload 15
    //   432: astore 13
    //   434: aload 14
    //   436: astore_2
    //   437: aload_1
    //   438: invokestatic 584	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   441: ifeq +4358 -> 4799
    //   444: ldc_w 586
    //   447: astore 16
    //   449: aload 15
    //   451: astore 12
    //   453: lload 6
    //   455: lstore 4
    //   457: aload 14
    //   459: astore 11
    //   461: aload 15
    //   463: astore 13
    //   465: aload 14
    //   467: astore_2
    //   468: ldc 179
    //   470: iconst_1
    //   471: aload 18
    //   473: aload 16
    //   475: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: ldc_w 588
    //   481: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload_1
    //   485: invokevirtual 590	com/tencent/mobileqq/msf/core/d:b	()Ljava/lang/String;
    //   488: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   497: aload 15
    //   499: astore 12
    //   501: lload 6
    //   503: lstore 4
    //   505: aload 14
    //   507: astore 11
    //   509: aload 15
    //   511: astore 13
    //   513: aload 14
    //   515: astore_2
    //   516: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   519: lstore 6
    //   521: aload 15
    //   523: astore 12
    //   525: lload 6
    //   527: lstore 4
    //   529: aload 14
    //   531: astore 11
    //   533: aload 15
    //   535: astore 13
    //   537: aload 14
    //   539: astore_2
    //   540: aload_0
    //   541: new 592	com/tencent/mobileqq/msf/core/net/h
    //   544: dup
    //   545: invokespecial 593	com/tencent/mobileqq/msf/core/net/h:<init>	()V
    //   548: putfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   551: aload 15
    //   553: astore 12
    //   555: lload 6
    //   557: lstore 4
    //   559: aload 14
    //   561: astore 11
    //   563: aload 15
    //   565: astore 13
    //   567: aload 14
    //   569: astore_2
    //   570: aload_0
    //   571: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   574: sipush 10000
    //   577: invokevirtual 596	com/tencent/mobileqq/msf/core/net/h:setSoTimeout	(I)V
    //   580: aload 15
    //   582: astore 12
    //   584: lload 6
    //   586: lstore 4
    //   588: aload 14
    //   590: astore 11
    //   592: aload 15
    //   594: astore 13
    //   596: aload 14
    //   598: astore_2
    //   599: aload_0
    //   600: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   603: iconst_1
    //   604: invokevirtual 599	com/tencent/mobileqq/msf/core/net/h:setTcpNoDelay	(Z)V
    //   607: aload 15
    //   609: astore 12
    //   611: lload 6
    //   613: lstore 4
    //   615: aload 14
    //   617: astore 11
    //   619: aload 15
    //   621: astore 13
    //   623: aload 14
    //   625: astore_2
    //   626: aload_0
    //   627: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   630: iconst_1
    //   631: invokevirtual 602	com/tencent/mobileqq/msf/core/net/h:setKeepAlive	(Z)V
    //   634: aload 15
    //   636: astore 12
    //   638: lload 6
    //   640: lstore 4
    //   642: aload 14
    //   644: astore 11
    //   646: aload 15
    //   648: astore 13
    //   650: aload 14
    //   652: astore_2
    //   653: aload_0
    //   654: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   657: ifnull +65 -> 722
    //   660: aload 15
    //   662: astore 12
    //   664: lload 6
    //   666: lstore 4
    //   668: aload 14
    //   670: astore 11
    //   672: aload 15
    //   674: astore 13
    //   676: aload 14
    //   678: astore_2
    //   679: aload_0
    //   680: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   683: getfield 606	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   686: ifnull +36 -> 722
    //   689: aload 15
    //   691: astore 12
    //   693: lload 6
    //   695: lstore 4
    //   697: aload 14
    //   699: astore 11
    //   701: aload 15
    //   703: astore 13
    //   705: aload 14
    //   707: astore_2
    //   708: aload_0
    //   709: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   712: getfield 606	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   715: iconst_1
    //   716: invokeinterface 612 2 0
    //   721: pop
    //   722: aload 15
    //   724: astore 12
    //   726: lload 6
    //   728: lstore 4
    //   730: aload 14
    //   732: astore 11
    //   734: aload 15
    //   736: astore 13
    //   738: aload 14
    //   740: astore_2
    //   741: aload_0
    //   742: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   745: aload_0
    //   746: getfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   749: aload_1
    //   750: invokevirtual 614	com/tencent/mobileqq/msf/core/d:g	()I
    //   753: invokevirtual 618	com/tencent/mobileqq/msf/core/net/h:connect	(Ljava/net/SocketAddress;I)V
    //   756: aload 15
    //   758: astore 12
    //   760: lload 6
    //   762: lstore 4
    //   764: aload 14
    //   766: astore 11
    //   768: aload 15
    //   770: astore 13
    //   772: aload 14
    //   774: astore_2
    //   775: aload_0
    //   776: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   779: ifnull +65 -> 844
    //   782: aload 15
    //   784: astore 12
    //   786: lload 6
    //   788: lstore 4
    //   790: aload 14
    //   792: astore 11
    //   794: aload 15
    //   796: astore 13
    //   798: aload 14
    //   800: astore_2
    //   801: aload_0
    //   802: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   805: getfield 606	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   808: ifnull +36 -> 844
    //   811: aload 15
    //   813: astore 12
    //   815: lload 6
    //   817: lstore 4
    //   819: aload 14
    //   821: astore 11
    //   823: aload 15
    //   825: astore 13
    //   827: aload 14
    //   829: astore_2
    //   830: aload_0
    //   831: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   834: getfield 606	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   837: iconst_1
    //   838: invokeinterface 621 2 0
    //   843: pop
    //   844: aload 15
    //   846: astore 12
    //   848: lload 6
    //   850: lstore 4
    //   852: aload 14
    //   854: astore 11
    //   856: aload 15
    //   858: astore 13
    //   860: aload 14
    //   862: astore_2
    //   863: aload_0
    //   864: invokestatic 577	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   867: putfield 88	com/tencent/mobileqq/msf/core/net/m:n	I
    //   870: aload 15
    //   872: astore 12
    //   874: lload 6
    //   876: lstore 4
    //   878: aload 14
    //   880: astore 11
    //   882: aload 15
    //   884: astore 13
    //   886: aload 14
    //   888: astore_2
    //   889: aload_0
    //   890: aload_1
    //   891: invokevirtual 623	com/tencent/mobileqq/msf/core/d:d	()I
    //   894: putfield 90	com/tencent/mobileqq/msf/core/net/m:o	I
    //   897: aload 15
    //   899: astore 12
    //   901: lload 6
    //   903: lstore 4
    //   905: aload 14
    //   907: astore 11
    //   909: aload 15
    //   911: astore 13
    //   913: aload 14
    //   915: astore_2
    //   916: aload_3
    //   917: iconst_1
    //   918: putfield 627	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   921: aload 15
    //   923: astore 12
    //   925: lload 6
    //   927: lstore 4
    //   929: aload 14
    //   931: astore 11
    //   933: aload 15
    //   935: astore 13
    //   937: aload 14
    //   939: astore_2
    //   940: aload_3
    //   941: aload_3
    //   942: getfield 629	com/tencent/mobileqq/msf/core/net/a:j	I
    //   945: iconst_1
    //   946: iadd
    //   947: putfield 629	com/tencent/mobileqq/msf/core/net/a:j	I
    //   950: aload 15
    //   952: astore 12
    //   954: lload 6
    //   956: lstore 4
    //   958: aload 14
    //   960: astore 11
    //   962: aload 15
    //   964: astore 13
    //   966: aload 14
    //   968: astore_2
    //   969: aload_0
    //   970: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   973: putfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   976: aload 15
    //   978: astore 12
    //   980: lload 6
    //   982: lstore 4
    //   984: aload 14
    //   986: astore 11
    //   988: aload 15
    //   990: astore 13
    //   992: aload 14
    //   994: astore_2
    //   995: aload_0
    //   996: aload_0
    //   997: getfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   1000: lload 6
    //   1002: lsub
    //   1003: putfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   1006: aload 15
    //   1008: astore 12
    //   1010: lload 6
    //   1012: lstore 4
    //   1014: aload 14
    //   1016: astore 11
    //   1018: aload 15
    //   1020: astore 13
    //   1022: aload 14
    //   1024: astore_2
    //   1025: aload_0
    //   1026: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1029: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   1032: getfield 632	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1035: astore 16
    //   1037: aload 15
    //   1039: astore 12
    //   1041: lload 6
    //   1043: lstore 4
    //   1045: aload 14
    //   1047: astore 11
    //   1049: aload 15
    //   1051: astore 13
    //   1053: aload 14
    //   1055: astore_2
    //   1056: aload 16
    //   1058: aload 16
    //   1060: getfield 636	com/tencent/mobileqq/msf/core/net/n:l	J
    //   1063: aload_0
    //   1064: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   1067: ladd
    //   1068: putfield 636	com/tencent/mobileqq/msf/core/net/n:l	J
    //   1071: aload 15
    //   1073: astore 12
    //   1075: lload 6
    //   1077: lstore 4
    //   1079: aload 14
    //   1081: astore 11
    //   1083: aload 15
    //   1085: astore 13
    //   1087: aload 14
    //   1089: astore_2
    //   1090: aload_0
    //   1091: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1094: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   1097: getfield 632	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1100: aload_0
    //   1101: getfield 132	com/tencent/mobileqq/msf/core/net/m:G	I
    //   1104: iconst_1
    //   1105: invokevirtual 639	com/tencent/mobileqq/msf/core/net/n:b	(IZ)V
    //   1108: aload 15
    //   1110: astore 12
    //   1112: lload 6
    //   1114: lstore 4
    //   1116: aload 14
    //   1118: astore 11
    //   1120: aload 15
    //   1122: astore 13
    //   1124: aload 14
    //   1126: astore_2
    //   1127: aload_0
    //   1128: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   1131: lconst_0
    //   1132: lcmp
    //   1133: ifge +27 -> 1160
    //   1136: aload 15
    //   1138: astore 12
    //   1140: lload 6
    //   1142: lstore 4
    //   1144: aload 14
    //   1146: astore 11
    //   1148: aload 15
    //   1150: astore 13
    //   1152: aload 14
    //   1154: astore_2
    //   1155: aload_0
    //   1156: lconst_0
    //   1157: putfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   1160: aload 15
    //   1162: astore 12
    //   1164: lload 6
    //   1166: lstore 4
    //   1168: aload 14
    //   1170: astore 11
    //   1172: aload 15
    //   1174: astore 13
    //   1176: aload 14
    //   1178: astore_2
    //   1179: aload_0
    //   1180: getfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   1183: putstatic 642	com/tencent/mobileqq/msf/core/aj:U	J
    //   1186: aload 15
    //   1188: astore 12
    //   1190: lload 6
    //   1192: lstore 4
    //   1194: aload 14
    //   1196: astore 11
    //   1198: aload 15
    //   1200: astore 13
    //   1202: aload 14
    //   1204: astore_2
    //   1205: aload_0
    //   1206: getfield 121	com/tencent/mobileqq/msf/core/net/m:C	Ljava/util/concurrent/atomic/AtomicLong;
    //   1209: lconst_0
    //   1210: invokevirtual 644	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   1213: aload 15
    //   1215: astore 12
    //   1217: lload 6
    //   1219: lstore 4
    //   1221: aload 14
    //   1223: astore 11
    //   1225: aload 15
    //   1227: astore 13
    //   1229: aload 14
    //   1231: astore_2
    //   1232: aload_0
    //   1233: getfield 123	com/tencent/mobileqq/msf/core/net/m:D	Ljava/util/concurrent/atomic/AtomicLong;
    //   1236: lconst_0
    //   1237: invokevirtual 644	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   1240: aload 15
    //   1242: astore 12
    //   1244: lload 6
    //   1246: lstore 4
    //   1248: aload 14
    //   1250: astore 11
    //   1252: aload 15
    //   1254: astore 13
    //   1256: aload 14
    //   1258: astore_2
    //   1259: aload_0
    //   1260: aload_0
    //   1261: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1264: invokevirtual 648	com/tencent/mobileqq/msf/core/net/h:getOutputStream	()Ljava/io/OutputStream;
    //   1267: putfield 76	com/tencent/mobileqq/msf/core/net/m:h	Ljava/io/OutputStream;
    //   1270: aload 15
    //   1272: astore 12
    //   1274: lload 6
    //   1276: lstore 4
    //   1278: aload 14
    //   1280: astore 11
    //   1282: aload 15
    //   1284: astore 13
    //   1286: aload 14
    //   1288: astore_2
    //   1289: getstatic 69	com/tencent/mobileqq/msf/core/net/m:q	Ljava/util/ArrayList;
    //   1292: aload_0
    //   1293: getfield 76	com/tencent/mobileqq/msf/core/net/m:h	Ljava/io/OutputStream;
    //   1296: invokevirtual 649	java/lang/Object:toString	()Ljava/lang/String;
    //   1299: invokevirtual 652	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1302: ifne +36 -> 1338
    //   1305: aload 15
    //   1307: astore 12
    //   1309: lload 6
    //   1311: lstore 4
    //   1313: aload 14
    //   1315: astore 11
    //   1317: aload 15
    //   1319: astore 13
    //   1321: aload 14
    //   1323: astore_2
    //   1324: getstatic 69	com/tencent/mobileqq/msf/core/net/m:q	Ljava/util/ArrayList;
    //   1327: aload_0
    //   1328: getfield 76	com/tencent/mobileqq/msf/core/net/m:h	Ljava/io/OutputStream;
    //   1331: invokevirtual 649	java/lang/Object:toString	()Ljava/lang/String;
    //   1334: invokevirtual 655	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1337: pop
    //   1338: aload 15
    //   1340: astore 12
    //   1342: lload 6
    //   1344: lstore 4
    //   1346: aload 14
    //   1348: astore 11
    //   1350: aload 15
    //   1352: astore 13
    //   1354: aload 14
    //   1356: astore_2
    //   1357: aload_0
    //   1358: new 657	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   1361: dup
    //   1362: aload_0
    //   1363: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1366: sipush 2048
    //   1369: ldc_w 659
    //   1372: iconst_m1
    //   1373: invokespecial 662	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   1376: putfield 80	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   1379: aload 15
    //   1381: astore 12
    //   1383: lload 6
    //   1385: lstore 4
    //   1387: aload 14
    //   1389: astore 11
    //   1391: aload 15
    //   1393: astore 13
    //   1395: aload 14
    //   1397: astore_2
    //   1398: aload_0
    //   1399: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   1402: ifnull +32 -> 1434
    //   1405: aload 15
    //   1407: astore 12
    //   1409: lload 6
    //   1411: lstore 4
    //   1413: aload 14
    //   1415: astore 11
    //   1417: aload 15
    //   1419: astore 13
    //   1421: aload 14
    //   1423: astore_2
    //   1424: aload_0
    //   1425: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   1428: invokevirtual 667	com/tencent/mobileqq/msf/core/net/m$a:isAlive	()Z
    //   1431: ifne +1980 -> 3411
    //   1434: aload 15
    //   1436: astore 12
    //   1438: lload 6
    //   1440: lstore 4
    //   1442: aload 14
    //   1444: astore 11
    //   1446: aload 15
    //   1448: astore 13
    //   1450: aload 14
    //   1452: astore_2
    //   1453: aload_0
    //   1454: new 669	com/tencent/mobileqq/msf/core/net/m$b
    //   1457: dup
    //   1458: aload_0
    //   1459: invokespecial 672	com/tencent/mobileqq/msf/core/net/m$b:<init>	(Lcom/tencent/mobileqq/msf/core/net/m;)V
    //   1462: putfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   1465: aload 15
    //   1467: astore 12
    //   1469: lload 6
    //   1471: lstore 4
    //   1473: aload 14
    //   1475: astore 11
    //   1477: aload 15
    //   1479: astore 13
    //   1481: aload 14
    //   1483: astore_2
    //   1484: aload_0
    //   1485: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   1488: ldc_w 674
    //   1491: invokevirtual 677	com/tencent/mobileqq/msf/core/net/m$a:setName	(Ljava/lang/String;)V
    //   1494: aload 15
    //   1496: astore 12
    //   1498: lload 6
    //   1500: lstore 4
    //   1502: aload 14
    //   1504: astore 11
    //   1506: aload 15
    //   1508: astore 13
    //   1510: aload 14
    //   1512: astore_2
    //   1513: aload_0
    //   1514: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   1517: invokevirtual 680	com/tencent/mobileqq/msf/core/net/m$a:start	()V
    //   1520: aload 15
    //   1522: astore 12
    //   1524: lload 6
    //   1526: lstore 4
    //   1528: aload 14
    //   1530: astore 11
    //   1532: aload 15
    //   1534: astore 13
    //   1536: aload 14
    //   1538: astore_2
    //   1539: aload_0
    //   1540: getfield 100	com/tencent/mobileqq/msf/core/net/m:v	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1543: iconst_1
    //   1544: invokevirtual 497	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1547: aload 15
    //   1549: astore 12
    //   1551: lload 6
    //   1553: lstore 4
    //   1555: aload 14
    //   1557: astore 11
    //   1559: aload 15
    //   1561: astore 13
    //   1563: aload 14
    //   1565: astore_2
    //   1566: getstatic 682	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   1569: astore 14
    //   1571: ldc_w 684
    //   1574: astore 15
    //   1576: aload 15
    //   1578: astore 12
    //   1580: lload 6
    //   1582: lstore 4
    //   1584: aload 14
    //   1586: astore 11
    //   1588: aload 15
    //   1590: astore 13
    //   1592: aload 14
    //   1594: astore_2
    //   1595: invokestatic 686	com/tencent/mobileqq/msf/core/aj:h	()V
    //   1598: aload 15
    //   1600: astore 12
    //   1602: lload 6
    //   1604: lstore 4
    //   1606: aload 14
    //   1608: astore 11
    //   1610: aload 15
    //   1612: astore 13
    //   1614: aload 14
    //   1616: astore_2
    //   1617: aload_1
    //   1618: invokevirtual 688	com/tencent/mobileqq/msf/core/d:a	()Ljava/lang/String;
    //   1621: putstatic 690	com/tencent/mobileqq/msf/core/aj:E	Ljava/lang/String;
    //   1624: aload 15
    //   1626: astore 12
    //   1628: lload 6
    //   1630: lstore 4
    //   1632: aload 14
    //   1634: astore 11
    //   1636: aload 15
    //   1638: astore 13
    //   1640: aload 14
    //   1642: astore_2
    //   1643: new 181	java/lang/StringBuilder
    //   1646: dup
    //   1647: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   1650: aload_0
    //   1651: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1654: invokevirtual 694	com/tencent/mobileqq/msf/core/net/h:getLocalSocketAddress	()Ljava/net/SocketAddress;
    //   1657: invokevirtual 697	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1660: ldc_w 699
    //   1663: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1666: aload_0
    //   1667: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1670: invokevirtual 702	com/tencent/mobileqq/msf/core/net/h:getLocalPort	()I
    //   1673: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1676: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1679: putstatic 704	com/tencent/mobileqq/msf/core/aj:F	Ljava/lang/String;
    //   1682: aload 15
    //   1684: astore 12
    //   1686: lload 6
    //   1688: lstore 4
    //   1690: aload 14
    //   1692: astore 11
    //   1694: aload 15
    //   1696: astore 13
    //   1698: aload 14
    //   1700: astore_2
    //   1701: invokestatic 707	com/tencent/mobileqq/msf/core/net/j:b	()B
    //   1704: putstatic 710	com/tencent/mobileqq/msf/core/aj:H	I
    //   1707: aload 15
    //   1709: astore 12
    //   1711: lload 6
    //   1713: lstore 4
    //   1715: aload 14
    //   1717: astore 11
    //   1719: aload 15
    //   1721: astore 13
    //   1723: aload 14
    //   1725: astore_2
    //   1726: aload_1
    //   1727: invokevirtual 711	com/tencent/mobileqq/msf/core/d:h	()V
    //   1730: aload 15
    //   1732: astore 12
    //   1734: lload 6
    //   1736: lstore 4
    //   1738: aload 14
    //   1740: astore 11
    //   1742: aload 15
    //   1744: astore 13
    //   1746: aload 14
    //   1748: astore_2
    //   1749: aload 17
    //   1751: iconst_0
    //   1752: aload 17
    //   1754: invokevirtual 714	java/lang/StringBuilder:length	()I
    //   1757: invokevirtual 718	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1760: pop
    //   1761: aload 15
    //   1763: astore 12
    //   1765: lload 6
    //   1767: lstore 4
    //   1769: aload 14
    //   1771: astore 11
    //   1773: aload 15
    //   1775: astore 13
    //   1777: aload 14
    //   1779: astore_2
    //   1780: invokestatic 442	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1783: ifeq +1718 -> 3501
    //   1786: aload 15
    //   1788: astore 12
    //   1790: lload 6
    //   1792: lstore 4
    //   1794: aload 14
    //   1796: astore 11
    //   1798: aload 15
    //   1800: astore 13
    //   1802: aload 14
    //   1804: astore_2
    //   1805: aload 17
    //   1807: ldc_w 720
    //   1810: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1813: aload_0
    //   1814: getfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   1817: invokevirtual 721	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   1820: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1823: ldc_w 723
    //   1826: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: aload_0
    //   1830: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   1833: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1836: ldc_w 725
    //   1839: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1842: aload_1
    //   1843: invokevirtual 614	com/tencent/mobileqq/msf/core/d:g	()I
    //   1846: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1849: ldc_w 727
    //   1852: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1855: aload_0
    //   1856: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1859: invokevirtual 731	com/tencent/mobileqq/msf/core/net/h:getLocalAddress	()Ljava/net/InetAddress;
    //   1862: invokevirtual 736	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1865: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1868: ldc_w 738
    //   1871: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1874: aload_0
    //   1875: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1878: invokevirtual 702	com/tencent/mobileqq/msf/core/net/h:getLocalPort	()I
    //   1881: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1884: astore 17
    //   1886: aload 15
    //   1888: astore 12
    //   1890: lload 6
    //   1892: lstore 4
    //   1894: aload 14
    //   1896: astore 11
    //   1898: aload 15
    //   1900: astore 13
    //   1902: aload 14
    //   1904: astore_2
    //   1905: aload_1
    //   1906: getfield 568	com/tencent/mobileqq/msf/core/d:g	Z
    //   1909: ifeq +1584 -> 3493
    //   1912: ldc_w 570
    //   1915: astore 16
    //   1917: aload 15
    //   1919: astore 12
    //   1921: lload 6
    //   1923: lstore 4
    //   1925: aload 14
    //   1927: astore 11
    //   1929: aload 15
    //   1931: astore 13
    //   1933: aload 14
    //   1935: astore_2
    //   1936: aload 17
    //   1938: aload 16
    //   1940: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1943: ldc_w 579
    //   1946: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1949: astore 17
    //   1951: aload 15
    //   1953: astore 12
    //   1955: lload 6
    //   1957: lstore 4
    //   1959: aload 14
    //   1961: astore 11
    //   1963: aload 15
    //   1965: astore 13
    //   1967: aload 14
    //   1969: astore_2
    //   1970: aload_1
    //   1971: invokestatic 584	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   1974: ifeq +2839 -> 4813
    //   1977: ldc_w 740
    //   1980: astore 16
    //   1982: aload 15
    //   1984: astore 12
    //   1986: lload 6
    //   1988: lstore 4
    //   1990: aload 14
    //   1992: astore 11
    //   1994: aload 15
    //   1996: astore 13
    //   1998: aload 14
    //   2000: astore_2
    //   2001: ldc 179
    //   2003: iconst_1
    //   2004: aload 17
    //   2006: aload 16
    //   2008: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2011: aload_0
    //   2012: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2015: invokevirtual 413	java/lang/Object:hashCode	()I
    //   2018: invokestatic 466	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   2021: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2024: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2027: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2030: aload 15
    //   2032: astore 12
    //   2034: lload 6
    //   2036: lstore 4
    //   2038: aload 14
    //   2040: astore 11
    //   2042: aload 15
    //   2044: astore 13
    //   2046: aload 14
    //   2048: astore_2
    //   2049: aload_0
    //   2050: getfield 95	com/tencent/mobileqq/msf/core/net/m:s	Ljava/util/concurrent/atomic/AtomicInteger;
    //   2053: iconst_0
    //   2054: invokevirtual 742	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   2057: aload 15
    //   2059: astore 12
    //   2061: lload 6
    //   2063: lstore 4
    //   2065: aload 14
    //   2067: astore 11
    //   2069: aload 15
    //   2071: astore 13
    //   2073: aload 14
    //   2075: astore_2
    //   2076: getstatic 418	com/tencent/mobileqq/msf/core/aj:s	Z
    //   2079: ifeq +133 -> 2212
    //   2082: aload 15
    //   2084: astore 12
    //   2086: lload 6
    //   2088: lstore 4
    //   2090: aload 14
    //   2092: astore 11
    //   2094: aload 15
    //   2096: astore 13
    //   2098: aload 14
    //   2100: astore_2
    //   2101: invokestatic 422	com/tencent/mobileqq/msf/core/net/a/f:a	()Z
    //   2104: istore 10
    //   2106: iload 10
    //   2108: ifeq +104 -> 2212
    //   2111: aload 15
    //   2113: astore 12
    //   2115: lload 6
    //   2117: lstore 4
    //   2119: aload 14
    //   2121: astore 11
    //   2123: aload 15
    //   2125: astore 13
    //   2127: aload 14
    //   2129: astore_2
    //   2130: ldc 179
    //   2132: iconst_1
    //   2133: ldc_w 744
    //   2136: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2139: aload 15
    //   2141: astore 12
    //   2143: lload 6
    //   2145: lstore 4
    //   2147: aload 14
    //   2149: astore 11
    //   2151: aload 15
    //   2153: astore 13
    //   2155: aload 14
    //   2157: astore_2
    //   2158: aload_0
    //   2159: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2162: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   2165: getfield 427	com/tencent/mobileqq/msf/core/aj:I	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   2168: ifnull +44 -> 2212
    //   2171: aload 15
    //   2173: astore 12
    //   2175: lload 6
    //   2177: lstore 4
    //   2179: aload 14
    //   2181: astore 11
    //   2183: aload 15
    //   2185: astore 13
    //   2187: aload 14
    //   2189: astore_2
    //   2190: aload_0
    //   2191: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2194: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   2197: getfield 427	com/tencent/mobileqq/msf/core/aj:I	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   2200: invokevirtual 430	com/tencent/mobileqq/msf/core/net/a/f:b	()Lcom/tencent/mobileqq/msf/core/net/a/e;
    //   2203: aload_0
    //   2204: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2207: invokeinterface 747 2 0
    //   2212: aload 15
    //   2214: astore 12
    //   2216: lload 6
    //   2218: lstore 4
    //   2220: aload 14
    //   2222: astore 11
    //   2224: aload 15
    //   2226: astore 13
    //   2228: aload 14
    //   2230: astore_2
    //   2231: aload_0
    //   2232: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2235: invokevirtual 751	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   2238: ifnull +166 -> 2404
    //   2241: aload 15
    //   2243: astore 12
    //   2245: lload 6
    //   2247: lstore 4
    //   2249: aload 14
    //   2251: astore 11
    //   2253: aload 15
    //   2255: astore 13
    //   2257: aload 14
    //   2259: astore_2
    //   2260: aload_0
    //   2261: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2264: getfield 755	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2267: getfield 761	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   2270: ifnull +134 -> 2404
    //   2273: aload 15
    //   2275: astore 12
    //   2277: lload 6
    //   2279: lstore 4
    //   2281: aload 14
    //   2283: astore 11
    //   2285: aload 15
    //   2287: astore 13
    //   2289: aload 14
    //   2291: astore_2
    //   2292: aload_0
    //   2293: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2296: getfield 755	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2299: getfield 761	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   2302: getfield 765	com/tencent/mobileqq/msf/core/c/k$c:e	J
    //   2305: lconst_0
    //   2306: lcmp
    //   2307: ifle +36 -> 2343
    //   2310: aload 15
    //   2312: astore 12
    //   2314: lload 6
    //   2316: lstore 4
    //   2318: aload 14
    //   2320: astore 11
    //   2322: aload 15
    //   2324: astore 13
    //   2326: aload 14
    //   2328: astore_2
    //   2329: aload_0
    //   2330: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2333: getfield 755	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2336: getfield 761	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   2339: lconst_0
    //   2340: putfield 767	com/tencent/mobileqq/msf/core/c/k$c:f	J
    //   2343: aload 15
    //   2345: astore 12
    //   2347: lload 6
    //   2349: lstore 4
    //   2351: aload 14
    //   2353: astore 11
    //   2355: aload 15
    //   2357: astore 13
    //   2359: aload 14
    //   2361: astore_2
    //   2362: aload_0
    //   2363: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2366: getfield 755	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2369: getfield 761	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   2372: lconst_0
    //   2373: putfield 769	com/tencent/mobileqq/msf/core/c/k$c:g	J
    //   2376: aload 15
    //   2378: astore 12
    //   2380: lload 6
    //   2382: lstore 4
    //   2384: aload 14
    //   2386: astore 11
    //   2388: aload 15
    //   2390: astore 13
    //   2392: aload 14
    //   2394: astore_2
    //   2395: ldc 179
    //   2397: iconst_1
    //   2398: ldc_w 771
    //   2401: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2404: aload_0
    //   2405: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   2408: invokevirtual 774	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2411: aload 14
    //   2413: getstatic 682	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2416: if_acmpeq +18 -> 2434
    //   2419: aload_3
    //   2420: iconst_0
    //   2421: putfield 627	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   2424: aload_3
    //   2425: aload_3
    //   2426: getfield 776	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2429: iconst_1
    //   2430: iadd
    //   2431: putfield 776	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2434: aload_3
    //   2435: aload 14
    //   2437: putfield 778	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2440: aload_3
    //   2441: ldc_w 684
    //   2444: putfield 780	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   2447: aload_3
    //   2448: invokestatic 263	android/os/SystemClock:elapsedRealtime	()J
    //   2451: lload 8
    //   2453: lsub
    //   2454: putfield 782	com/tencent/mobileqq/msf/core/net/a:a	J
    //   2457: aload 14
    //   2459: astore 12
    //   2461: aload_0
    //   2462: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2465: invokevirtual 751	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   2468: ifnull +36 -> 2504
    //   2471: aload_0
    //   2472: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2475: invokevirtual 751	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   2478: astore_2
    //   2479: aload 12
    //   2481: getstatic 682	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2484: if_acmpne +2087 -> 4571
    //   2487: iconst_1
    //   2488: istore 10
    //   2490: aload_2
    //   2491: iload 10
    //   2493: aload_0
    //   2494: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   2497: aload_1
    //   2498: invokevirtual 545	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   2501: invokevirtual 785	com/tencent/mobileqq/msf/core/c/k:b	(ZJLjava/lang/String;)V
    //   2504: aload 12
    //   2506: getstatic 682	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2509: if_acmpne +2150 -> 4659
    //   2512: aload_1
    //   2513: invokestatic 584	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   2516: ifeq +16 -> 2532
    //   2519: invokestatic 538	com/tencent/mobileqq/a/a/a$c:a	()Lcom/tencent/mobileqq/a/a/a$c;
    //   2522: iconst_1
    //   2523: invokevirtual 787	com/tencent/mobileqq/a/a/a$c:a	(Z)V
    //   2526: invokestatic 538	com/tencent/mobileqq/a/a/a$c:a	()Lcom/tencent/mobileqq/a/a/a$c;
    //   2529: invokevirtual 789	com/tencent/mobileqq/a/a/a$c:b	()V
    //   2532: invokestatic 792	com/tencent/mobileqq/msf/core/NetConnInfoCenter:checkConnInfo	()V
    //   2535: invokestatic 795	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isNetSupport	()Z
    //   2538: ifne +7 -> 2545
    //   2541: iconst_1
    //   2542: invokestatic 798	com/tencent/mobileqq/msf/core/NetConnInfoCenter:setNetSupport	(Z)V
    //   2545: invokestatic 801	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   2548: putstatic 802	com/tencent/mobileqq/msf/core/aj:G	I
    //   2551: aload_0
    //   2552: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2555: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   2558: aconst_null
    //   2559: invokevirtual 804	com/tencent/mobileqq/msf/core/aj:a	([B)V
    //   2562: aload_0
    //   2563: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2566: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   2569: invokevirtual 806	com/tencent/mobileqq/msf/core/aj:f	()V
    //   2572: getstatic 808	com/tencent/mobileqq/msf/core/aj:A	Ljava/util/concurrent/atomic/AtomicInteger;
    //   2575: iconst_0
    //   2576: invokevirtual 742	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   2579: getstatic 810	com/tencent/mobileqq/msf/core/aj:B	Ljava/util/ArrayList;
    //   2582: invokevirtual 813	java/util/ArrayList:clear	()V
    //   2585: aload_0
    //   2586: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2589: ifnull +195 -> 2784
    //   2592: aload_0
    //   2593: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2596: new 181	java/lang/StringBuilder
    //   2599: dup
    //   2600: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   2603: aload_0
    //   2604: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2607: invokevirtual 731	com/tencent/mobileqq/msf/core/net/h:getLocalAddress	()Ljava/net/InetAddress;
    //   2610: invokevirtual 736	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   2613: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2616: ldc_w 738
    //   2619: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2622: aload_0
    //   2623: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2626: invokevirtual 702	com/tencent/mobileqq/msf/core/net/h:getLocalPort	()I
    //   2629: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2632: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2635: putfield 816	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   2638: invokestatic 298	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   2641: aload_0
    //   2642: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2645: getstatic 802	com/tencent/mobileqq/msf/core/aj:G	I
    //   2648: aload_0
    //   2649: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   2652: l2i
    //   2653: invokevirtual 819	com/tencent/mobileqq/a/a/a:a	(Ljava/net/Socket;II)V
    //   2656: aload_0
    //   2657: getfield 104	com/tencent/mobileqq/msf/core/net/m:x	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2660: iconst_0
    //   2661: invokevirtual 497	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   2664: invokestatic 821	com/tencent/mobileqq/msf/core/a/a:v	()Z
    //   2667: ifeq +1949 -> 4616
    //   2670: aload_0
    //   2671: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2674: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   2677: getfield 632	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   2680: invokevirtual 823	com/tencent/mobileqq/msf/core/net/n:o	()Z
    //   2683: ifeq +1907 -> 4590
    //   2686: aload_0
    //   2687: invokevirtual 825	com/tencent/mobileqq/msf/core/net/m:j	()I
    //   2690: iconst_1
    //   2691: if_icmpne +1899 -> 4590
    //   2694: aload_0
    //   2695: iconst_1
    //   2696: invokespecial 827	com/tencent/mobileqq/msf/core/net/m:b	(Z)V
    //   2699: aload_0
    //   2700: invokespecial 829	com/tencent/mobileqq/msf/core/net/m:m	()V
    //   2703: invokestatic 831	com/tencent/mobileqq/msf/core/a/a:w	()Z
    //   2706: ifeq +1922 -> 4628
    //   2709: aload_0
    //   2710: aload_0
    //   2711: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2714: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   2717: aload_0
    //   2718: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2721: invokevirtual 413	java/lang/Object:hashCode	()I
    //   2724: invokevirtual 834	com/tencent/mobileqq/msf/core/aj:a	(I)Ljava/lang/Runnable;
    //   2727: putfield 504	com/tencent/mobileqq/msf/core/net/m:F	Ljava/lang/Runnable;
    //   2730: aload_0
    //   2731: getfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   2734: invokevirtual 721	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   2737: invokestatic 839	com/tencent/qphone/base/util/g:b	(Ljava/lang/String;)J
    //   2740: putstatic 843	com/tencent/mobileqq/msf/core/push/e:d	J
    //   2743: aload_1
    //   2744: invokevirtual 545	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   2747: aload_1
    //   2748: invokevirtual 547	com/tencent/mobileqq/msf/core/d:f	()I
    //   2751: getstatic 802	com/tencent/mobileqq/msf/core/aj:G	I
    //   2754: invokestatic 848	com/tencent/mobileqq/a/a/f:a	(Ljava/lang/String;II)V
    //   2757: aload_0
    //   2758: getfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   2761: invokevirtual 721	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   2764: aload_0
    //   2765: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2768: getfield 816	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   2771: invokestatic 852	com/tencent/mobileqq/msf/core/NetConnInfoCenter:onConnOpened	(Ljava/lang/String;Ljava/lang/String;)V
    //   2774: aload_0
    //   2775: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2778: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   2781: invokevirtual 853	com/tencent/mobileqq/msf/core/aj:m	()V
    //   2784: return
    //   2785: ldc_w 855
    //   2788: astore 16
    //   2790: goto -2418 -> 372
    //   2793: aload 15
    //   2795: astore 12
    //   2797: lload 6
    //   2799: lstore 4
    //   2801: aload 14
    //   2803: astore 11
    //   2805: aload 15
    //   2807: astore 13
    //   2809: aload 14
    //   2811: astore_2
    //   2812: aload 17
    //   2814: ldc_w 566
    //   2817: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2820: aload_1
    //   2821: invokevirtual 555	com/tencent/mobileqq/msf/core/d:toString	()Ljava/lang/String;
    //   2824: invokestatic 486	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2827: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2830: astore 18
    //   2832: aload 15
    //   2834: astore 12
    //   2836: lload 6
    //   2838: lstore 4
    //   2840: aload 14
    //   2842: astore 11
    //   2844: aload 15
    //   2846: astore 13
    //   2848: aload 14
    //   2850: astore_2
    //   2851: aload_1
    //   2852: getfield 568	com/tencent/mobileqq/msf/core/d:g	Z
    //   2855: ifeq +548 -> 3403
    //   2858: ldc_w 570
    //   2861: astore 16
    //   2863: aload 15
    //   2865: astore 12
    //   2867: lload 6
    //   2869: lstore 4
    //   2871: aload 14
    //   2873: astore 11
    //   2875: aload 15
    //   2877: astore 13
    //   2879: aload 14
    //   2881: astore_2
    //   2882: aload 18
    //   2884: aload 16
    //   2886: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2889: ldc_w 572
    //   2892: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2895: invokestatic 577	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   2898: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2901: ldc_w 579
    //   2904: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2907: astore 18
    //   2909: aload 15
    //   2911: astore 12
    //   2913: lload 6
    //   2915: lstore 4
    //   2917: aload 14
    //   2919: astore 11
    //   2921: aload 15
    //   2923: astore 13
    //   2925: aload 14
    //   2927: astore_2
    //   2928: aload_1
    //   2929: invokestatic 584	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   2932: ifeq +1874 -> 4806
    //   2935: ldc_w 586
    //   2938: astore 16
    //   2940: aload 15
    //   2942: astore 12
    //   2944: lload 6
    //   2946: lstore 4
    //   2948: aload 14
    //   2950: astore 11
    //   2952: aload 15
    //   2954: astore 13
    //   2956: aload 14
    //   2958: astore_2
    //   2959: ldc 179
    //   2961: iconst_1
    //   2962: aload 18
    //   2964: aload 16
    //   2966: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2969: ldc_w 588
    //   2972: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2975: aload_1
    //   2976: invokevirtual 590	com/tencent/mobileqq/msf/core/d:b	()Ljava/lang/String;
    //   2979: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2982: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2985: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2988: goto -2491 -> 497
    //   2991: astore 16
    //   2993: aload 12
    //   2995: astore 13
    //   2997: aload 11
    //   2999: astore_2
    //   3000: aload_0
    //   3001: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   3004: lload 4
    //   3006: lsub
    //   3007: putfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   3010: aload 12
    //   3012: astore 13
    //   3014: aload 11
    //   3016: astore_2
    //   3017: aload_0
    //   3018: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3021: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   3024: getfield 632	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   3027: astore 14
    //   3029: aload 12
    //   3031: astore 13
    //   3033: aload 11
    //   3035: astore_2
    //   3036: aload 14
    //   3038: aload 14
    //   3040: getfield 636	com/tencent/mobileqq/msf/core/net/n:l	J
    //   3043: aload_0
    //   3044: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   3047: ladd
    //   3048: putfield 636	com/tencent/mobileqq/msf/core/net/n:l	J
    //   3051: aload 12
    //   3053: astore 13
    //   3055: aload 11
    //   3057: astore_2
    //   3058: aload_0
    //   3059: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3062: invokevirtual 751	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   3065: ifnull +176 -> 3241
    //   3068: aload 12
    //   3070: astore 13
    //   3072: aload 11
    //   3074: astore_2
    //   3075: aload_0
    //   3076: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3079: getfield 755	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3082: getfield 761	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3085: ifnull +156 -> 3241
    //   3088: aload 12
    //   3090: astore 13
    //   3092: aload 11
    //   3094: astore_2
    //   3095: aload_0
    //   3096: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3099: getfield 755	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3102: getfield 761	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3105: getfield 765	com/tencent/mobileqq/msf/core/c/k$c:e	J
    //   3108: lconst_0
    //   3109: lcmp
    //   3110: ifle +51 -> 3161
    //   3113: aload 12
    //   3115: astore 13
    //   3117: aload 11
    //   3119: astore_2
    //   3120: aload_0
    //   3121: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3124: getfield 755	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3127: getfield 761	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3130: getfield 767	com/tencent/mobileqq/msf/core/c/k$c:f	J
    //   3133: lconst_0
    //   3134: lcmp
    //   3135: ifne +26 -> 3161
    //   3138: aload 12
    //   3140: astore 13
    //   3142: aload 11
    //   3144: astore_2
    //   3145: aload_0
    //   3146: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3149: getfield 755	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3152: getfield 761	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3155: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   3158: putfield 767	com/tencent/mobileqq/msf/core/c/k$c:f	J
    //   3161: aload 12
    //   3163: astore 13
    //   3165: aload 11
    //   3167: astore_2
    //   3168: aload_0
    //   3169: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3172: getfield 755	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3175: getfield 761	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3178: getfield 769	com/tencent/mobileqq/msf/core/c/k$c:g	J
    //   3181: lconst_0
    //   3182: lcmp
    //   3183: ifne +58 -> 3241
    //   3186: aload 12
    //   3188: astore 13
    //   3190: aload 11
    //   3192: astore_2
    //   3193: aload_0
    //   3194: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3197: getfield 755	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3200: getfield 761	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3203: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   3206: putfield 769	com/tencent/mobileqq/msf/core/c/k$c:g	J
    //   3209: aload 12
    //   3211: astore 13
    //   3213: aload 11
    //   3215: astore_2
    //   3216: ldc 179
    //   3218: iconst_1
    //   3219: iconst_2
    //   3220: anewarray 4	java/lang/Object
    //   3223: dup
    //   3224: iconst_0
    //   3225: ldc_w 857
    //   3228: aastore
    //   3229: dup
    //   3230: iconst_1
    //   3231: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   3234: invokestatic 269	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3237: aastore
    //   3238: invokestatic 860	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   3241: aload 12
    //   3243: astore 13
    //   3245: aload 11
    //   3247: astore_2
    //   3248: aload 16
    //   3250: invokevirtual 861	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3253: invokevirtual 864	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   3256: astore 15
    //   3258: aload 15
    //   3260: astore 13
    //   3262: aload 11
    //   3264: astore_2
    //   3265: invokestatic 801	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   3268: ifne +521 -> 3789
    //   3271: aload 15
    //   3273: astore 13
    //   3275: aload 11
    //   3277: astore_2
    //   3278: getstatic 866	com/tencent/mobileqq/msf/core/net/x:m	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3281: astore 12
    //   3283: aload 15
    //   3285: astore 13
    //   3287: aload 12
    //   3289: astore_2
    //   3290: aload 12
    //   3292: invokevirtual 867	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   3295: astore 11
    //   3297: aload 11
    //   3299: astore 13
    //   3301: aload 12
    //   3303: astore_2
    //   3304: aload_3
    //   3305: invokestatic 870	com/tencent/mobileqq/msf/core/a/a:aE	()I
    //   3308: putfield 872	com/tencent/mobileqq/msf/core/net/a:h	I
    //   3311: aload_0
    //   3312: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   3315: invokevirtual 774	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   3318: aload 12
    //   3320: getstatic 682	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3323: if_acmpeq +18 -> 3341
    //   3326: aload_3
    //   3327: iconst_0
    //   3328: putfield 627	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   3331: aload_3
    //   3332: aload_3
    //   3333: getfield 776	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3336: iconst_1
    //   3337: iadd
    //   3338: putfield 776	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3341: aload_3
    //   3342: aload 12
    //   3344: putfield 778	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3347: aload_3
    //   3348: aload 11
    //   3350: putfield 780	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3353: aload_3
    //   3354: invokestatic 263	android/os/SystemClock:elapsedRealtime	()J
    //   3357: lload 8
    //   3359: lsub
    //   3360: putfield 782	com/tencent/mobileqq/msf/core/net/a:a	J
    //   3363: goto -902 -> 2461
    //   3366: astore_1
    //   3367: aload_3
    //   3368: iconst_0
    //   3369: putfield 627	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   3372: aload_3
    //   3373: aload_3
    //   3374: getfield 776	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3377: iconst_1
    //   3378: iadd
    //   3379: putfield 776	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3382: aload_3
    //   3383: getstatic 874	com/tencent/mobileqq/msf/core/net/x:f	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3386: putfield 778	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3389: aload_3
    //   3390: aload_1
    //   3391: invokevirtual 875	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   3394: putfield 780	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3397: aload_3
    //   3398: lconst_0
    //   3399: putfield 782	com/tencent/mobileqq/msf/core/net/a:a	J
    //   3402: return
    //   3403: ldc_w 855
    //   3406: astore 16
    //   3408: goto -545 -> 2863
    //   3411: aload 15
    //   3413: astore 12
    //   3415: lload 6
    //   3417: lstore 4
    //   3419: aload 14
    //   3421: astore 11
    //   3423: aload 15
    //   3425: astore 13
    //   3427: aload 14
    //   3429: astore_2
    //   3430: aload_0
    //   3431: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   3434: invokevirtual 877	com/tencent/mobileqq/msf/core/net/m$a:a	()V
    //   3437: goto -1917 -> 1520
    //   3440: astore_1
    //   3441: aload_0
    //   3442: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   3445: invokevirtual 774	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   3448: aload_2
    //   3449: getstatic 682	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3452: if_acmpeq +18 -> 3470
    //   3455: aload_3
    //   3456: iconst_0
    //   3457: putfield 627	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   3460: aload_3
    //   3461: aload_3
    //   3462: getfield 776	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3465: iconst_1
    //   3466: iadd
    //   3467: putfield 776	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3470: aload_3
    //   3471: aload_2
    //   3472: putfield 778	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3475: aload_3
    //   3476: aload 13
    //   3478: putfield 780	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3481: aload_3
    //   3482: invokestatic 263	android/os/SystemClock:elapsedRealtime	()J
    //   3485: lload 8
    //   3487: lsub
    //   3488: putfield 782	com/tencent/mobileqq/msf/core/net/a:a	J
    //   3491: aload_1
    //   3492: athrow
    //   3493: ldc_w 855
    //   3496: astore 16
    //   3498: goto -1581 -> 1917
    //   3501: aload 15
    //   3503: astore 12
    //   3505: lload 6
    //   3507: lstore 4
    //   3509: aload 14
    //   3511: astore 11
    //   3513: aload 15
    //   3515: astore 13
    //   3517: aload 14
    //   3519: astore_2
    //   3520: aload 17
    //   3522: ldc_w 720
    //   3525: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3528: aload_0
    //   3529: getfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   3532: invokevirtual 721	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   3535: invokestatic 486	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3538: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3541: ldc_w 723
    //   3544: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3547: aload_0
    //   3548: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   3551: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3554: ldc_w 725
    //   3557: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3560: aload_1
    //   3561: invokevirtual 614	com/tencent/mobileqq/msf/core/d:g	()I
    //   3564: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3567: ldc_w 727
    //   3570: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3573: aload_0
    //   3574: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   3577: invokevirtual 731	com/tencent/mobileqq/msf/core/net/h:getLocalAddress	()Ljava/net/InetAddress;
    //   3580: invokevirtual 736	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   3583: invokestatic 486	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3586: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3589: ldc_w 738
    //   3592: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3595: aload_0
    //   3596: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   3599: invokevirtual 702	com/tencent/mobileqq/msf/core/net/h:getLocalPort	()I
    //   3602: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3605: astore 17
    //   3607: aload 15
    //   3609: astore 12
    //   3611: lload 6
    //   3613: lstore 4
    //   3615: aload 14
    //   3617: astore 11
    //   3619: aload 15
    //   3621: astore 13
    //   3623: aload 14
    //   3625: astore_2
    //   3626: aload_1
    //   3627: getfield 568	com/tencent/mobileqq/msf/core/d:g	Z
    //   3630: ifeq +1191 -> 4821
    //   3633: ldc_w 570
    //   3636: astore 16
    //   3638: aload 15
    //   3640: astore 12
    //   3642: lload 6
    //   3644: lstore 4
    //   3646: aload 14
    //   3648: astore 11
    //   3650: aload 15
    //   3652: astore 13
    //   3654: aload 14
    //   3656: astore_2
    //   3657: aload 17
    //   3659: aload 16
    //   3661: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3664: ldc_w 579
    //   3667: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3670: astore 17
    //   3672: aload 15
    //   3674: astore 12
    //   3676: lload 6
    //   3678: lstore 4
    //   3680: aload 14
    //   3682: astore 11
    //   3684: aload 15
    //   3686: astore 13
    //   3688: aload 14
    //   3690: astore_2
    //   3691: aload_1
    //   3692: invokestatic 584	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   3695: ifeq +1134 -> 4829
    //   3698: ldc_w 740
    //   3701: astore 16
    //   3703: aload 15
    //   3705: astore 12
    //   3707: lload 6
    //   3709: lstore 4
    //   3711: aload 14
    //   3713: astore 11
    //   3715: aload 15
    //   3717: astore 13
    //   3719: aload 14
    //   3721: astore_2
    //   3722: ldc 179
    //   3724: iconst_1
    //   3725: aload 17
    //   3727: aload 16
    //   3729: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3732: aload_0
    //   3733: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   3736: invokevirtual 413	java/lang/Object:hashCode	()I
    //   3739: invokestatic 466	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   3742: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3745: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3748: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3751: goto -1721 -> 2030
    //   3754: astore 16
    //   3756: aload 15
    //   3758: astore 12
    //   3760: lload 6
    //   3762: lstore 4
    //   3764: aload 14
    //   3766: astore 11
    //   3768: aload 15
    //   3770: astore 13
    //   3772: aload 14
    //   3774: astore_2
    //   3775: ldc 179
    //   3777: iconst_1
    //   3778: ldc_w 879
    //   3781: aload 16
    //   3783: invokestatic 308	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3786: goto -1574 -> 2212
    //   3789: aload 15
    //   3791: astore 13
    //   3793: aload 11
    //   3795: astore_2
    //   3796: aload 15
    //   3798: ldc_w 881
    //   3801: invokevirtual 885	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3804: iconst_m1
    //   3805: if_icmple +32 -> 3837
    //   3808: aload 15
    //   3810: astore 13
    //   3812: aload 11
    //   3814: astore_2
    //   3815: getstatic 887	com/tencent/mobileqq/msf/core/net/x:g	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3818: astore 12
    //   3820: aload 15
    //   3822: astore 13
    //   3824: aload 12
    //   3826: astore_2
    //   3827: aload 12
    //   3829: invokevirtual 867	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   3832: astore 11
    //   3834: goto -523 -> 3311
    //   3837: aload 15
    //   3839: astore 13
    //   3841: aload 11
    //   3843: astore_2
    //   3844: aload 15
    //   3846: ldc_w 889
    //   3849: invokevirtual 885	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3852: iconst_m1
    //   3853: if_icmple +32 -> 3885
    //   3856: aload 15
    //   3858: astore 13
    //   3860: aload 11
    //   3862: astore_2
    //   3863: getstatic 891	com/tencent/mobileqq/msf/core/net/x:q	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3866: astore 12
    //   3868: aload 15
    //   3870: astore 13
    //   3872: aload 12
    //   3874: astore_2
    //   3875: aload 12
    //   3877: invokevirtual 867	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   3880: astore 11
    //   3882: goto -571 -> 3311
    //   3885: aload 15
    //   3887: astore 13
    //   3889: aload 11
    //   3891: astore_2
    //   3892: aload 15
    //   3894: ldc_w 893
    //   3897: invokevirtual 885	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3900: iconst_m1
    //   3901: if_icmple +46 -> 3947
    //   3904: aload 15
    //   3906: astore 13
    //   3908: aload 11
    //   3910: astore_2
    //   3911: getstatic 866	com/tencent/mobileqq/msf/core/net/x:m	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3914: astore 12
    //   3916: aload 15
    //   3918: astore 13
    //   3920: aload 12
    //   3922: astore_2
    //   3923: aload 12
    //   3925: invokevirtual 867	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   3928: astore 11
    //   3930: aload 11
    //   3932: astore 13
    //   3934: aload 12
    //   3936: astore_2
    //   3937: aload_3
    //   3938: invokestatic 870	com/tencent/mobileqq/msf/core/a/a:aE	()I
    //   3941: putfield 872	com/tencent/mobileqq/msf/core/net/a:h	I
    //   3944: goto -633 -> 3311
    //   3947: aload 15
    //   3949: astore 13
    //   3951: aload 11
    //   3953: astore_2
    //   3954: aload 15
    //   3956: ldc_w 895
    //   3959: invokevirtual 885	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3962: iconst_m1
    //   3963: if_icmple +32 -> 3995
    //   3966: aload 15
    //   3968: astore 13
    //   3970: aload 11
    //   3972: astore_2
    //   3973: getstatic 897	com/tencent/mobileqq/msf/core/net/x:i	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3976: astore 12
    //   3978: aload 15
    //   3980: astore 13
    //   3982: aload 12
    //   3984: astore_2
    //   3985: aload 12
    //   3987: invokevirtual 867	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   3990: astore 11
    //   3992: goto -681 -> 3311
    //   3995: aload 15
    //   3997: astore 13
    //   3999: aload 11
    //   4001: astore_2
    //   4002: aload 15
    //   4004: ldc_w 899
    //   4007: invokevirtual 885	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4010: iconst_m1
    //   4011: if_icmple +32 -> 4043
    //   4014: aload 15
    //   4016: astore 13
    //   4018: aload 11
    //   4020: astore_2
    //   4021: getstatic 901	com/tencent/mobileqq/msf/core/net/x:s	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4024: astore 12
    //   4026: aload 15
    //   4028: astore 13
    //   4030: aload 12
    //   4032: astore_2
    //   4033: aload 12
    //   4035: invokevirtual 867	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4038: astore 11
    //   4040: goto -729 -> 3311
    //   4043: aload 15
    //   4045: astore 13
    //   4047: aload 11
    //   4049: astore_2
    //   4050: aload 15
    //   4052: ldc_w 903
    //   4055: invokevirtual 885	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4058: iconst_m1
    //   4059: if_icmple +32 -> 4091
    //   4062: aload 15
    //   4064: astore 13
    //   4066: aload 11
    //   4068: astore_2
    //   4069: getstatic 905	com/tencent/mobileqq/msf/core/net/x:r	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4072: astore 12
    //   4074: aload 15
    //   4076: astore 13
    //   4078: aload 12
    //   4080: astore_2
    //   4081: aload 12
    //   4083: invokevirtual 867	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4086: astore 11
    //   4088: goto -777 -> 3311
    //   4091: aload 15
    //   4093: astore 13
    //   4095: aload 11
    //   4097: astore_2
    //   4098: aload 15
    //   4100: ldc_w 907
    //   4103: invokevirtual 885	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4106: iconst_m1
    //   4107: if_icmpgt +22 -> 4129
    //   4110: aload 15
    //   4112: astore 13
    //   4114: aload 11
    //   4116: astore_2
    //   4117: aload 15
    //   4119: ldc_w 909
    //   4122: invokevirtual 885	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4125: iconst_m1
    //   4126: if_icmple +32 -> 4158
    //   4129: aload 15
    //   4131: astore 13
    //   4133: aload 11
    //   4135: astore_2
    //   4136: getstatic 911	com/tencent/mobileqq/msf/core/net/x:t	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4139: astore 12
    //   4141: aload 15
    //   4143: astore 13
    //   4145: aload 12
    //   4147: astore_2
    //   4148: aload 12
    //   4150: invokevirtual 867	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4153: astore 11
    //   4155: goto -844 -> 3311
    //   4158: aload 15
    //   4160: astore 13
    //   4162: aload 11
    //   4164: astore_2
    //   4165: aload 15
    //   4167: ldc_w 913
    //   4170: invokevirtual 885	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4173: iconst_m1
    //   4174: if_icmple +32 -> 4206
    //   4177: aload 15
    //   4179: astore 13
    //   4181: aload 11
    //   4183: astore_2
    //   4184: getstatic 915	com/tencent/mobileqq/msf/core/net/x:p	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4187: astore 12
    //   4189: aload 15
    //   4191: astore 13
    //   4193: aload 12
    //   4195: astore_2
    //   4196: aload 12
    //   4198: invokevirtual 867	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4201: astore 11
    //   4203: goto -892 -> 3311
    //   4206: aload 15
    //   4208: astore 13
    //   4210: aload 11
    //   4212: astore_2
    //   4213: aload 15
    //   4215: ldc_w 917
    //   4218: invokevirtual 885	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4221: iconst_m1
    //   4222: if_icmple +32 -> 4254
    //   4225: aload 15
    //   4227: astore 13
    //   4229: aload 11
    //   4231: astore_2
    //   4232: getstatic 919	com/tencent/mobileqq/msf/core/net/x:o	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4235: astore 12
    //   4237: aload 15
    //   4239: astore 13
    //   4241: aload 12
    //   4243: astore_2
    //   4244: aload 12
    //   4246: invokevirtual 867	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4249: astore 11
    //   4251: goto -940 -> 3311
    //   4254: aload 15
    //   4256: astore 13
    //   4258: aload 11
    //   4260: astore_2
    //   4261: aload 15
    //   4263: ldc_w 921
    //   4266: invokevirtual 885	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4269: iconst_m1
    //   4270: if_icmple +32 -> 4302
    //   4273: aload 15
    //   4275: astore 13
    //   4277: aload 11
    //   4279: astore_2
    //   4280: getstatic 923	com/tencent/mobileqq/msf/core/net/x:h	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4283: astore 12
    //   4285: aload 15
    //   4287: astore 13
    //   4289: aload 12
    //   4291: astore_2
    //   4292: aload 12
    //   4294: invokevirtual 867	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4297: astore 11
    //   4299: goto -988 -> 3311
    //   4302: aload 15
    //   4304: astore 13
    //   4306: aload 11
    //   4308: astore_2
    //   4309: aload 15
    //   4311: ldc_w 925
    //   4314: invokevirtual 885	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4317: iconst_m1
    //   4318: if_icmple +32 -> 4350
    //   4321: aload 15
    //   4323: astore 13
    //   4325: aload 11
    //   4327: astore_2
    //   4328: getstatic 927	com/tencent/mobileqq/msf/core/net/x:l	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4331: astore 12
    //   4333: aload 15
    //   4335: astore 13
    //   4337: aload 12
    //   4339: astore_2
    //   4340: aload 12
    //   4342: invokevirtual 867	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4345: astore 11
    //   4347: goto -1036 -> 3311
    //   4350: aload 15
    //   4352: astore 13
    //   4354: aload 11
    //   4356: astore_2
    //   4357: aload 15
    //   4359: ldc_w 929
    //   4362: invokevirtual 885	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4365: iconst_m1
    //   4366: if_icmple +32 -> 4398
    //   4369: aload 15
    //   4371: astore 13
    //   4373: aload 11
    //   4375: astore_2
    //   4376: getstatic 931	com/tencent/mobileqq/msf/core/net/x:j	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4379: astore 12
    //   4381: aload 15
    //   4383: astore 13
    //   4385: aload 12
    //   4387: astore_2
    //   4388: aload 12
    //   4390: invokevirtual 867	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4393: astore 11
    //   4395: goto -1084 -> 3311
    //   4398: aload 15
    //   4400: astore 13
    //   4402: aload 11
    //   4404: astore_2
    //   4405: aload 15
    //   4407: ldc_w 933
    //   4410: invokevirtual 885	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4413: iconst_m1
    //   4414: if_icmple +32 -> 4446
    //   4417: aload 15
    //   4419: astore 13
    //   4421: aload 11
    //   4423: astore_2
    //   4424: getstatic 911	com/tencent/mobileqq/msf/core/net/x:t	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4427: astore 12
    //   4429: aload 15
    //   4431: astore 13
    //   4433: aload 12
    //   4435: astore_2
    //   4436: aload 12
    //   4438: invokevirtual 867	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4441: astore 11
    //   4443: goto -1132 -> 3311
    //   4446: aload 15
    //   4448: astore 13
    //   4450: aload 11
    //   4452: astore_2
    //   4453: aload 15
    //   4455: ldc_w 935
    //   4458: invokevirtual 885	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4461: iconst_m1
    //   4462: if_icmple +32 -> 4494
    //   4465: aload 15
    //   4467: astore 13
    //   4469: aload 11
    //   4471: astore_2
    //   4472: getstatic 937	com/tencent/mobileqq/msf/core/net/x:n	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4475: astore 12
    //   4477: aload 15
    //   4479: astore 13
    //   4481: aload 12
    //   4483: astore_2
    //   4484: aload 12
    //   4486: invokevirtual 867	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4489: astore 11
    //   4491: goto -1180 -> 3311
    //   4494: aload 15
    //   4496: astore 13
    //   4498: aload 11
    //   4500: astore_2
    //   4501: getstatic 939	com/tencent/mobileqq/msf/core/net/x:u	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4504: astore 14
    //   4506: aload 15
    //   4508: astore 13
    //   4510: aload 14
    //   4512: astore_2
    //   4513: aload 16
    //   4515: invokestatic 943	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4518: astore 15
    //   4520: aload 15
    //   4522: astore 11
    //   4524: aload 14
    //   4526: astore 12
    //   4528: aload 15
    //   4530: astore 13
    //   4532: aload 14
    //   4534: astore_2
    //   4535: aload 15
    //   4537: invokevirtual 944	java/lang/String:length	()I
    //   4540: sipush 200
    //   4543: if_icmple -1232 -> 3311
    //   4546: aload 15
    //   4548: astore 13
    //   4550: aload 14
    //   4552: astore_2
    //   4553: aload 15
    //   4555: iconst_0
    //   4556: sipush 200
    //   4559: invokevirtual 948	java/lang/String:substring	(II)Ljava/lang/String;
    //   4562: astore 11
    //   4564: aload 14
    //   4566: astore 12
    //   4568: goto -1257 -> 3311
    //   4571: iconst_0
    //   4572: istore 10
    //   4574: goto -2084 -> 2490
    //   4577: astore_2
    //   4578: ldc 179
    //   4580: iconst_1
    //   4581: ldc_w 950
    //   4584: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4587: goto -2083 -> 2504
    //   4590: aload_0
    //   4591: iconst_0
    //   4592: invokespecial 827	com/tencent/mobileqq/msf/core/net/m:b	(Z)V
    //   4595: goto -1896 -> 2699
    //   4598: astore_2
    //   4599: aload_2
    //   4600: invokevirtual 303	java/lang/Exception:printStackTrace	()V
    //   4603: ldc 179
    //   4605: iconst_1
    //   4606: ldc_w 952
    //   4609: aload_2
    //   4610: invokestatic 308	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4613: goto -1883 -> 2730
    //   4616: ldc 179
    //   4618: iconst_1
    //   4619: ldc_w 954
    //   4622: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4625: goto -1922 -> 2703
    //   4628: ldc 179
    //   4630: iconst_1
    //   4631: ldc_w 956
    //   4634: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4637: goto -1907 -> 2730
    //   4640: astore_2
    //   4641: ldc2_w 957
    //   4644: putstatic 843	com/tencent/mobileqq/msf/core/push/e:d	J
    //   4647: ldc 179
    //   4649: iconst_1
    //   4650: ldc_w 960
    //   4653: invokestatic 962	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4656: goto -1913 -> 2743
    //   4659: aload 12
    //   4661: getstatic 682	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4664: if_acmpeq -1880 -> 2784
    //   4667: invokestatic 298	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   4670: getstatic 802	com/tencent/mobileqq/msf/core/aj:G	I
    //   4673: aload_0
    //   4674: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   4677: aload 12
    //   4679: invokevirtual 965	com/tencent/mobileqq/a/a/a:a	(IJLcom/tencent/mobileqq/msf/core/net/x;)V
    //   4682: new 181	java/lang/StringBuilder
    //   4685: dup
    //   4686: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   4689: ldc_w 967
    //   4692: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4695: aload_0
    //   4696: getfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   4699: invokevirtual 697	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4702: ldc_w 969
    //   4705: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4708: aload_3
    //   4709: getfield 780	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   4712: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4715: ldc_w 971
    //   4718: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4721: aload_0
    //   4722: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   4725: invokevirtual 204	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4728: ldc_w 725
    //   4731: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4734: aload_1
    //   4735: invokevirtual 614	com/tencent/mobileqq/msf/core/d:g	()I
    //   4738: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4741: astore 11
    //   4743: aload_1
    //   4744: getfield 568	com/tencent/mobileqq/msf/core/d:g	Z
    //   4747: ifeq +90 -> 4837
    //   4750: ldc_w 570
    //   4753: astore_2
    //   4754: aload 11
    //   4756: aload_2
    //   4757: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4760: ldc_w 579
    //   4763: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4766: astore_2
    //   4767: aload_1
    //   4768: invokestatic 584	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   4771: ifeq +22 -> 4793
    //   4774: ldc_w 586
    //   4777: astore_1
    //   4778: ldc 179
    //   4780: iconst_1
    //   4781: aload_2
    //   4782: aload_1
    //   4783: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4786: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4789: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4792: return
    //   4793: ldc 142
    //   4795: astore_1
    //   4796: goto -18 -> 4778
    //   4799: ldc 142
    //   4801: astore 16
    //   4803: goto -4354 -> 449
    //   4806: ldc 142
    //   4808: astore 16
    //   4810: goto -1870 -> 2940
    //   4813: ldc_w 973
    //   4816: astore 16
    //   4818: goto -2836 -> 1982
    //   4821: ldc_w 855
    //   4824: astore 16
    //   4826: goto -1188 -> 3638
    //   4829: ldc_w 973
    //   4832: astore 16
    //   4834: goto -1131 -> 3703
    //   4837: ldc_w 855
    //   4840: astore_2
    //   4841: goto -87 -> 4754
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4844	0	this	m
    //   0	4844	1	paramd	com.tencent.mobileqq.msf.core.d
    //   0	4844	2	paramd1	d
    //   0	4844	3	parama	a
    //   156	3607	4	l1	long
    //   133	3628	6	l2	long
    //   128	3358	8	l3	long
    //   2104	2469	10	bool	boolean
    //   160	4595	11	localObject1	Object
    //   152	4526	12	localObject2	Object
    //   164	4385	13	localObject3	Object
    //   98	4467	14	localObject4	Object
    //   102	4452	15	str1	String
    //   370	2595	16	localObject5	Object
    //   2991	258	16	localThrowable	java.lang.Throwable
    //   3406	322	16	str2	String
    //   3754	760	16	localException	Exception
    //   4801	32	16	str3	String
    //   239	3487	17	localStringBuilder1	StringBuilder
    //   339	2624	18	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   169	188	2991	java/lang/Throwable
    //   207	213	2991	java/lang/Throwable
    //   232	241	2991	java/lang/Throwable
    //   260	280	2991	java/lang/Throwable
    //   299	305	2991	java/lang/Throwable
    //   324	341	2991	java/lang/Throwable
    //   360	367	2991	java/lang/Throwable
    //   391	418	2991	java/lang/Throwable
    //   437	444	2991	java/lang/Throwable
    //   468	497	2991	java/lang/Throwable
    //   516	521	2991	java/lang/Throwable
    //   540	551	2991	java/lang/Throwable
    //   570	580	2991	java/lang/Throwable
    //   599	607	2991	java/lang/Throwable
    //   626	634	2991	java/lang/Throwable
    //   653	660	2991	java/lang/Throwable
    //   679	689	2991	java/lang/Throwable
    //   708	722	2991	java/lang/Throwable
    //   741	756	2991	java/lang/Throwable
    //   775	782	2991	java/lang/Throwable
    //   801	811	2991	java/lang/Throwable
    //   830	844	2991	java/lang/Throwable
    //   863	870	2991	java/lang/Throwable
    //   889	897	2991	java/lang/Throwable
    //   916	921	2991	java/lang/Throwable
    //   940	950	2991	java/lang/Throwable
    //   969	976	2991	java/lang/Throwable
    //   995	1006	2991	java/lang/Throwable
    //   1025	1037	2991	java/lang/Throwable
    //   1056	1071	2991	java/lang/Throwable
    //   1090	1108	2991	java/lang/Throwable
    //   1127	1136	2991	java/lang/Throwable
    //   1155	1160	2991	java/lang/Throwable
    //   1179	1186	2991	java/lang/Throwable
    //   1205	1213	2991	java/lang/Throwable
    //   1232	1240	2991	java/lang/Throwable
    //   1259	1270	2991	java/lang/Throwable
    //   1289	1305	2991	java/lang/Throwable
    //   1324	1338	2991	java/lang/Throwable
    //   1357	1379	2991	java/lang/Throwable
    //   1398	1405	2991	java/lang/Throwable
    //   1424	1434	2991	java/lang/Throwable
    //   1453	1465	2991	java/lang/Throwable
    //   1484	1494	2991	java/lang/Throwable
    //   1513	1520	2991	java/lang/Throwable
    //   1539	1547	2991	java/lang/Throwable
    //   1566	1571	2991	java/lang/Throwable
    //   1595	1598	2991	java/lang/Throwable
    //   1617	1624	2991	java/lang/Throwable
    //   1643	1682	2991	java/lang/Throwable
    //   1701	1707	2991	java/lang/Throwable
    //   1726	1730	2991	java/lang/Throwable
    //   1749	1761	2991	java/lang/Throwable
    //   1780	1786	2991	java/lang/Throwable
    //   1805	1886	2991	java/lang/Throwable
    //   1905	1912	2991	java/lang/Throwable
    //   1936	1951	2991	java/lang/Throwable
    //   1970	1977	2991	java/lang/Throwable
    //   2001	2030	2991	java/lang/Throwable
    //   2049	2057	2991	java/lang/Throwable
    //   2076	2082	2991	java/lang/Throwable
    //   2101	2106	2991	java/lang/Throwable
    //   2130	2139	2991	java/lang/Throwable
    //   2158	2171	2991	java/lang/Throwable
    //   2190	2212	2991	java/lang/Throwable
    //   2231	2241	2991	java/lang/Throwable
    //   2260	2273	2991	java/lang/Throwable
    //   2292	2310	2991	java/lang/Throwable
    //   2329	2343	2991	java/lang/Throwable
    //   2362	2376	2991	java/lang/Throwable
    //   2395	2404	2991	java/lang/Throwable
    //   2812	2832	2991	java/lang/Throwable
    //   2851	2858	2991	java/lang/Throwable
    //   2882	2909	2991	java/lang/Throwable
    //   2928	2935	2991	java/lang/Throwable
    //   2959	2988	2991	java/lang/Throwable
    //   3430	3437	2991	java/lang/Throwable
    //   3520	3607	2991	java/lang/Throwable
    //   3626	3633	2991	java/lang/Throwable
    //   3657	3672	2991	java/lang/Throwable
    //   3691	3698	2991	java/lang/Throwable
    //   3722	3751	2991	java/lang/Throwable
    //   3775	3786	2991	java/lang/Throwable
    //   109	150	3366	java/lang/InterruptedException
    //   2404	2434	3366	java/lang/InterruptedException
    //   2434	2457	3366	java/lang/InterruptedException
    //   2461	2487	3366	java/lang/InterruptedException
    //   2490	2504	3366	java/lang/InterruptedException
    //   2504	2532	3366	java/lang/InterruptedException
    //   2532	2545	3366	java/lang/InterruptedException
    //   2545	2638	3366	java/lang/InterruptedException
    //   2638	2699	3366	java/lang/InterruptedException
    //   2699	2703	3366	java/lang/InterruptedException
    //   2703	2730	3366	java/lang/InterruptedException
    //   2730	2743	3366	java/lang/InterruptedException
    //   2743	2784	3366	java/lang/InterruptedException
    //   3311	3341	3366	java/lang/InterruptedException
    //   3341	3363	3366	java/lang/InterruptedException
    //   3441	3470	3366	java/lang/InterruptedException
    //   3470	3493	3366	java/lang/InterruptedException
    //   4578	4587	3366	java/lang/InterruptedException
    //   4590	4595	3366	java/lang/InterruptedException
    //   4599	4613	3366	java/lang/InterruptedException
    //   4616	4625	3366	java/lang/InterruptedException
    //   4628	4637	3366	java/lang/InterruptedException
    //   4641	4656	3366	java/lang/InterruptedException
    //   4659	4750	3366	java/lang/InterruptedException
    //   4754	4774	3366	java/lang/InterruptedException
    //   4778	4792	3366	java/lang/InterruptedException
    //   169	188	3440	finally
    //   207	213	3440	finally
    //   232	241	3440	finally
    //   260	280	3440	finally
    //   299	305	3440	finally
    //   324	341	3440	finally
    //   360	367	3440	finally
    //   391	418	3440	finally
    //   437	444	3440	finally
    //   468	497	3440	finally
    //   516	521	3440	finally
    //   540	551	3440	finally
    //   570	580	3440	finally
    //   599	607	3440	finally
    //   626	634	3440	finally
    //   653	660	3440	finally
    //   679	689	3440	finally
    //   708	722	3440	finally
    //   741	756	3440	finally
    //   775	782	3440	finally
    //   801	811	3440	finally
    //   830	844	3440	finally
    //   863	870	3440	finally
    //   889	897	3440	finally
    //   916	921	3440	finally
    //   940	950	3440	finally
    //   969	976	3440	finally
    //   995	1006	3440	finally
    //   1025	1037	3440	finally
    //   1056	1071	3440	finally
    //   1090	1108	3440	finally
    //   1127	1136	3440	finally
    //   1155	1160	3440	finally
    //   1179	1186	3440	finally
    //   1205	1213	3440	finally
    //   1232	1240	3440	finally
    //   1259	1270	3440	finally
    //   1289	1305	3440	finally
    //   1324	1338	3440	finally
    //   1357	1379	3440	finally
    //   1398	1405	3440	finally
    //   1424	1434	3440	finally
    //   1453	1465	3440	finally
    //   1484	1494	3440	finally
    //   1513	1520	3440	finally
    //   1539	1547	3440	finally
    //   1566	1571	3440	finally
    //   1595	1598	3440	finally
    //   1617	1624	3440	finally
    //   1643	1682	3440	finally
    //   1701	1707	3440	finally
    //   1726	1730	3440	finally
    //   1749	1761	3440	finally
    //   1780	1786	3440	finally
    //   1805	1886	3440	finally
    //   1905	1912	3440	finally
    //   1936	1951	3440	finally
    //   1970	1977	3440	finally
    //   2001	2030	3440	finally
    //   2049	2057	3440	finally
    //   2076	2082	3440	finally
    //   2101	2106	3440	finally
    //   2130	2139	3440	finally
    //   2158	2171	3440	finally
    //   2190	2212	3440	finally
    //   2231	2241	3440	finally
    //   2260	2273	3440	finally
    //   2292	2310	3440	finally
    //   2329	2343	3440	finally
    //   2362	2376	3440	finally
    //   2395	2404	3440	finally
    //   2812	2832	3440	finally
    //   2851	2858	3440	finally
    //   2882	2909	3440	finally
    //   2928	2935	3440	finally
    //   2959	2988	3440	finally
    //   3000	3010	3440	finally
    //   3017	3029	3440	finally
    //   3036	3051	3440	finally
    //   3058	3068	3440	finally
    //   3075	3088	3440	finally
    //   3095	3113	3440	finally
    //   3120	3138	3440	finally
    //   3145	3161	3440	finally
    //   3168	3186	3440	finally
    //   3193	3209	3440	finally
    //   3216	3241	3440	finally
    //   3248	3258	3440	finally
    //   3265	3271	3440	finally
    //   3278	3283	3440	finally
    //   3290	3297	3440	finally
    //   3304	3311	3440	finally
    //   3430	3437	3440	finally
    //   3520	3607	3440	finally
    //   3626	3633	3440	finally
    //   3657	3672	3440	finally
    //   3691	3698	3440	finally
    //   3722	3751	3440	finally
    //   3775	3786	3440	finally
    //   3796	3808	3440	finally
    //   3815	3820	3440	finally
    //   3827	3834	3440	finally
    //   3844	3856	3440	finally
    //   3863	3868	3440	finally
    //   3875	3882	3440	finally
    //   3892	3904	3440	finally
    //   3911	3916	3440	finally
    //   3923	3930	3440	finally
    //   3937	3944	3440	finally
    //   3954	3966	3440	finally
    //   3973	3978	3440	finally
    //   3985	3992	3440	finally
    //   4002	4014	3440	finally
    //   4021	4026	3440	finally
    //   4033	4040	3440	finally
    //   4050	4062	3440	finally
    //   4069	4074	3440	finally
    //   4081	4088	3440	finally
    //   4098	4110	3440	finally
    //   4117	4129	3440	finally
    //   4136	4141	3440	finally
    //   4148	4155	3440	finally
    //   4165	4177	3440	finally
    //   4184	4189	3440	finally
    //   4196	4203	3440	finally
    //   4213	4225	3440	finally
    //   4232	4237	3440	finally
    //   4244	4251	3440	finally
    //   4261	4273	3440	finally
    //   4280	4285	3440	finally
    //   4292	4299	3440	finally
    //   4309	4321	3440	finally
    //   4328	4333	3440	finally
    //   4340	4347	3440	finally
    //   4357	4369	3440	finally
    //   4376	4381	3440	finally
    //   4388	4395	3440	finally
    //   4405	4417	3440	finally
    //   4424	4429	3440	finally
    //   4436	4443	3440	finally
    //   4453	4465	3440	finally
    //   4472	4477	3440	finally
    //   4484	4491	3440	finally
    //   4501	4506	3440	finally
    //   4513	4520	3440	finally
    //   4535	4546	3440	finally
    //   4553	4564	3440	finally
    //   2130	2139	3754	java/lang/Exception
    //   2158	2171	3754	java/lang/Exception
    //   2190	2212	3754	java/lang/Exception
    //   2461	2487	4577	java/lang/Exception
    //   2490	2504	4577	java/lang/Exception
    //   2638	2699	4598	java/lang/Exception
    //   2699	2703	4598	java/lang/Exception
    //   2703	2730	4598	java/lang/Exception
    //   4590	4595	4598	java/lang/Exception
    //   4616	4625	4598	java/lang/Exception
    //   4628	4637	4598	java/lang/Exception
    //   2730	2743	4640	java/lang/Exception
  }
  
  public void a(com.tencent.qphone.base.a parama)
  {
    if (this.n == 1)
    {
      int i1 = NetConnInfoCenter.getActiveNetworkType();
      if ((i1 == 2) || (i1 == 3)) {
        b(parama);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.x.set(paramBoolean);
  }
  
  public com.tencent.mobileqq.msf.core.d b()
  {
    return this.d;
  }
  
  /* Error */
  public void b(com.tencent.qphone.base.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 88	com/tencent/mobileqq/msf/core/net/m:n	I
    //   5: aload_0
    //   6: iconst_0
    //   7: putfield 90	com/tencent/mobileqq/msf/core/net/m:o	I
    //   10: aload_0
    //   11: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   14: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   17: iconst_0
    //   18: putfield 976	com/tencent/mobileqq/msf/core/aj:q	Z
    //   21: aload_0
    //   22: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   25: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   28: iconst_0
    //   29: putfield 363	com/tencent/mobileqq/msf/core/aj:r	Z
    //   32: aload_0
    //   33: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   36: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   39: lconst_0
    //   40: putfield 978	com/tencent/mobileqq/msf/core/aj:p	J
    //   43: aload_0
    //   44: getfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   47: ifnull +26 -> 73
    //   50: getstatic 980	com/tencent/mobileqq/msf/core/push/e:e	Z
    //   53: ifeq +20 -> 73
    //   56: aload_0
    //   57: getfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   60: invokevirtual 721	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   63: invokestatic 839	com/tencent/qphone/base/util/g:b	(Ljava/lang/String;)J
    //   66: putstatic 982	com/tencent/mobileqq/msf/core/push/e:c	J
    //   69: iconst_0
    //   70: putstatic 980	com/tencent/mobileqq/msf/core/push/e:e	Z
    //   73: ldc 179
    //   75: iconst_1
    //   76: iconst_2
    //   77: anewarray 4	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: invokestatic 988	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   85: invokevirtual 991	java/lang/Thread:getName	()Ljava/lang/String;
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: new 181	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 993
    //   101: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: invokevirtual 697	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: aastore
    //   112: invokestatic 860	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   115: aload_0
    //   116: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   119: astore 6
    //   121: getstatic 996	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   124: getfield 755	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   127: ifnull +90 -> 217
    //   130: aload_0
    //   131: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   134: astore 6
    //   136: getstatic 996	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   139: getfield 755	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   142: getfield 761	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   145: ifnull +72 -> 217
    //   148: aload_0
    //   149: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   152: astore 6
    //   154: getstatic 996	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   157: getfield 755	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   160: getfield 761	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   163: getfield 769	com/tencent/mobileqq/msf/core/c/k$c:g	J
    //   166: lconst_0
    //   167: lcmp
    //   168: ifne +49 -> 217
    //   171: aload_0
    //   172: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   175: astore 6
    //   177: getstatic 996	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   180: getfield 755	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   183: getfield 761	com/tencent/mobileqq/msf/core/c/k:Y	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   186: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   189: putfield 769	com/tencent/mobileqq/msf/core/c/k$c:g	J
    //   192: ldc 179
    //   194: iconst_1
    //   195: iconst_2
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: ldc_w 998
    //   204: aastore
    //   205: dup
    //   206: iconst_1
    //   207: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   210: invokestatic 269	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   213: aastore
    //   214: invokestatic 860	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   217: aload_0
    //   218: getfield 245	com/tencent/mobileqq/msf/core/net/m:y	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   221: ifnull +22 -> 243
    //   224: aload_0
    //   225: invokevirtual 502	com/tencent/mobileqq/msf/core/net/m:h	()Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   228: pop
    //   229: aload_0
    //   230: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   233: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   236: aload_0
    //   237: getfield 504	com/tencent/mobileqq/msf/core/net/m:F	Ljava/lang/Runnable;
    //   240: invokevirtual 507	com/tencent/mobileqq/msf/core/aj:a	(Ljava/lang/Runnable;)V
    //   243: aload_0
    //   244: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   247: ifnonnull +61 -> 308
    //   250: ldc 179
    //   252: iconst_1
    //   253: new 181	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   260: ldc_w 1000
    //   263: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_1
    //   267: invokevirtual 697	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: return
    //   277: astore 6
    //   279: ldc2_w 957
    //   282: putstatic 982	com/tencent/mobileqq/msf/core/push/e:c	J
    //   285: ldc 179
    //   287: iconst_1
    //   288: ldc_w 1002
    //   291: invokestatic 962	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: iconst_0
    //   295: putstatic 980	com/tencent/mobileqq/msf/core/push/e:e	Z
    //   298: goto -225 -> 73
    //   301: astore_1
    //   302: iconst_0
    //   303: putstatic 980	com/tencent/mobileqq/msf/core/push/e:e	Z
    //   306: aload_1
    //   307: athrow
    //   308: invokestatic 1005	com/tencent/mobileqq/msf/core/a/a:aI	()Z
    //   311: ifeq +550 -> 861
    //   314: getstatic 418	com/tencent/mobileqq/msf/core/aj:s	Z
    //   317: ifeq +49 -> 366
    //   320: invokestatic 422	com/tencent/mobileqq/msf/core/net/a/f:a	()Z
    //   323: ifeq +43 -> 366
    //   326: ldc 179
    //   328: iconst_1
    //   329: ldc_w 1007
    //   332: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_0
    //   336: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   339: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   342: getfield 427	com/tencent/mobileqq/msf/core/aj:I	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   345: ifnull +21 -> 366
    //   348: aload_0
    //   349: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   352: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   355: getfield 427	com/tencent/mobileqq/msf/core/aj:I	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   358: invokevirtual 430	com/tencent/mobileqq/msf/core/net/a/f:b	()Lcom/tencent/mobileqq/msf/core/net/a/e;
    //   361: invokeinterface 1008 1 0
    //   366: iconst_1
    //   367: istore_3
    //   368: invokestatic 1009	com/tencent/mobileqq/a/a/f:a	()V
    //   371: invokestatic 298	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   374: aload_1
    //   375: invokevirtual 1011	com/tencent/mobileqq/a/a/a:a	(Lcom/tencent/qphone/base/a;)V
    //   378: invokestatic 1016	com/tencent/mobileqq/a/a/a$b:a	()Lcom/tencent/mobileqq/a/a/a$b;
    //   381: aload_1
    //   382: invokevirtual 1017	com/tencent/mobileqq/a/a/a$b:a	(Lcom/tencent/qphone/base/a;)V
    //   385: invokestatic 1020	com/tencent/mobileqq/msf/core/a/a:aH	()Z
    //   388: ifeq +6 -> 394
    //   391: invokestatic 1023	com/tencent/mobileqq/a/a/d:a	()V
    //   394: aload_0
    //   395: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   398: invokevirtual 1024	com/tencent/mobileqq/msf/core/net/h:toString	()Ljava/lang/String;
    //   401: astore 6
    //   403: aload_0
    //   404: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   407: ldc2_w 517
    //   410: getstatic 524	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   413: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   416: istore_2
    //   417: iload_2
    //   418: ifeq +513 -> 931
    //   421: aload_0
    //   422: getfield 95	com/tencent/mobileqq/msf/core/net/m:s	Ljava/util/concurrent/atomic/AtomicInteger;
    //   425: iconst_0
    //   426: invokevirtual 742	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   429: aload_0
    //   430: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   433: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   436: aconst_null
    //   437: invokevirtual 804	com/tencent/mobileqq/msf/core/aj:a	([B)V
    //   440: aload_0
    //   441: getfield 100	com/tencent/mobileqq/msf/core/net/m:v	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   444: invokevirtual 342	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   447: istore_2
    //   448: aload_0
    //   449: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   452: ifnull +14 -> 466
    //   455: aload_0
    //   456: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   459: getfield 1026	com/tencent/mobileqq/msf/core/net/m$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   462: iconst_0
    //   463: invokevirtual 497	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   466: aload_0
    //   467: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   470: invokevirtual 1030	com/tencent/mobileqq/msf/core/net/h:getInputStream	()Ljava/io/InputStream;
    //   473: ifnull +13 -> 486
    //   476: aload_0
    //   477: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   480: invokevirtual 1030	com/tencent/mobileqq/msf/core/net/h:getInputStream	()Ljava/io/InputStream;
    //   483: invokevirtual 1035	java/io/InputStream:close	()V
    //   486: aload_0
    //   487: getfield 76	com/tencent/mobileqq/msf/core/net/m:h	Ljava/io/OutputStream;
    //   490: astore 7
    //   492: aload 7
    //   494: ifnull +24 -> 518
    //   497: getstatic 69	com/tencent/mobileqq/msf/core/net/m:q	Ljava/util/ArrayList;
    //   500: aload_0
    //   501: getfield 76	com/tencent/mobileqq/msf/core/net/m:h	Ljava/io/OutputStream;
    //   504: invokevirtual 649	java/lang/Object:toString	()Ljava/lang/String;
    //   507: invokevirtual 1037	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   510: pop
    //   511: aload_0
    //   512: getfield 76	com/tencent/mobileqq/msf/core/net/m:h	Ljava/io/OutputStream;
    //   515: invokevirtual 1038	java/io/OutputStream:close	()V
    //   518: aload_0
    //   519: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   522: astore 7
    //   524: aload 7
    //   526: ifnull +30 -> 556
    //   529: aload_0
    //   530: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   533: invokevirtual 1039	com/tencent/mobileqq/msf/core/net/h:close	()V
    //   536: aload_1
    //   537: invokestatic 1042	com/tencent/mobileqq/msf/core/ao:a	(Lcom/tencent/qphone/base/a;)V
    //   540: aload_0
    //   541: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   544: invokevirtual 1046	com/tencent/mobileqq/msf/core/MsfCore:getStandyModeManager	()Lcom/tencent/mobileqq/msf/core/d/a;
    //   547: invokevirtual 1049	com/tencent/mobileqq/msf/core/d/a:f	()V
    //   550: getstatic 69	com/tencent/mobileqq/msf/core/net/m:q	Ljava/util/ArrayList;
    //   553: invokevirtual 813	java/util/ArrayList:clear	()V
    //   556: aload_0
    //   557: aconst_null
    //   558: putfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   561: aload_0
    //   562: getfield 100	com/tencent/mobileqq/msf/core/net/m:v	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   565: iconst_0
    //   566: invokevirtual 497	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   569: aload_0
    //   570: aconst_null
    //   571: putfield 344	com/tencent/mobileqq/msf/core/net/m:i	Lcom/tencent/mobileqq/msf/core/net/d;
    //   574: aload_0
    //   575: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   578: invokevirtual 774	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   581: aload_0
    //   582: getfield 102	com/tencent/mobileqq/msf/core/net/m:w	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   585: invokevirtual 342	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   588: ifne -312 -> 276
    //   591: iload_2
    //   592: ifeq -316 -> 276
    //   595: aload_0
    //   596: getfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   599: lconst_0
    //   600: lcmp
    //   601: ifle +120 -> 721
    //   604: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   607: aload_0
    //   608: getfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   611: lsub
    //   612: lstore 4
    //   614: aload_0
    //   615: lconst_0
    //   616: putfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   619: aload_0
    //   620: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   623: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   626: invokevirtual 1051	com/tencent/mobileqq/msf/core/aj:e	()[B
    //   629: invokestatic 1057	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   632: astore 7
    //   634: invokestatic 1060	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getCurrentAPN	()Ljava/lang/String;
    //   637: astore 8
    //   639: aload_0
    //   640: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   643: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   646: getfield 632	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   649: invokevirtual 1062	com/tencent/mobileqq/msf/core/net/n:g	()V
    //   652: aload_0
    //   653: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   656: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/aj;
    //   659: getfield 632	com/tencent/mobileqq/msf/core/aj:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   662: lconst_0
    //   663: putfield 1064	com/tencent/mobileqq/msf/core/net/n:m	J
    //   666: aload_0
    //   667: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   670: invokevirtual 751	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   673: ifnull +48 -> 721
    //   676: aload_0
    //   677: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   680: invokevirtual 751	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   683: iconst_0
    //   684: lload 4
    //   686: ldc2_w 1065
    //   689: ldiv
    //   690: aload_0
    //   691: getfield 349	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   694: aload_1
    //   695: getstatic 710	com/tencent/mobileqq/msf/core/aj:H	I
    //   698: lload 4
    //   700: aload_0
    //   701: getfield 121	com/tencent/mobileqq/msf/core/net/m:C	Ljava/util/concurrent/atomic/AtomicLong;
    //   704: invokevirtual 1068	java/util/concurrent/atomic/AtomicLong:get	()J
    //   707: aload_0
    //   708: getfield 123	com/tencent/mobileqq/msf/core/net/m:D	Ljava/util/concurrent/atomic/AtomicLong;
    //   711: invokevirtual 1068	java/util/concurrent/atomic/AtomicLong:get	()J
    //   714: aload 7
    //   716: aload 8
    //   718: invokevirtual 1071	com/tencent/mobileqq/msf/core/c/k:a	(ZJLcom/tencent/mobileqq/msf/core/d;Lcom/tencent/qphone/base/a;IJJJLjava/lang/String;Ljava/lang/String;)V
    //   721: invokestatic 442	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   724: ifeq +275 -> 999
    //   727: ldc 179
    //   729: iconst_1
    //   730: new 181	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   737: ldc_w 1073
    //   740: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload 6
    //   745: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: ldc_w 1075
    //   751: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: aload_1
    //   755: invokevirtual 697	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   758: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   764: aload_0
    //   765: getfield 349	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   768: ifnull +28 -> 796
    //   771: aload_0
    //   772: getfield 349	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   775: aload_1
    //   776: invokevirtual 1078	com/tencent/mobileqq/msf/core/d:a	(Lcom/tencent/qphone/base/a;)Z
    //   779: ifeq +17 -> 796
    //   782: aload_0
    //   783: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   786: invokevirtual 1082	com/tencent/mobileqq/msf/core/MsfCore:getSsoListManager	()Lcom/tencent/mobileqq/msf/core/a/c;
    //   789: aload_0
    //   790: getfield 349	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   793: invokevirtual 1087	com/tencent/mobileqq/msf/core/a/c:a	(Lcom/tencent/mobileqq/msf/core/d;)V
    //   796: ldc_w 738
    //   799: putstatic 690	com/tencent/mobileqq/msf/core/aj:E	Ljava/lang/String;
    //   802: ldc 142
    //   804: putstatic 704	com/tencent/mobileqq/msf/core/aj:F	Ljava/lang/String;
    //   807: aload_0
    //   808: aconst_null
    //   809: putfield 349	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   812: aload_0
    //   813: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   816: aconst_null
    //   817: putfield 816	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   820: aload_0
    //   821: getfield 121	com/tencent/mobileqq/msf/core/net/m:C	Ljava/util/concurrent/atomic/AtomicLong;
    //   824: lconst_0
    //   825: invokevirtual 644	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   828: aload_0
    //   829: getfield 123	com/tencent/mobileqq/msf/core/net/m:D	Ljava/util/concurrent/atomic/AtomicLong;
    //   832: lconst_0
    //   833: invokevirtual 644	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   836: invokestatic 1092	com/tencent/qphone/base/util/CodecWarpper:nativeOnConnClose	()V
    //   839: aload_1
    //   840: invokestatic 1095	com/tencent/mobileqq/msf/core/NetConnInfoCenter:onConnClosed	(Lcom/tencent/qphone/base/a;)V
    //   843: return
    //   844: astore 6
    //   846: getstatic 1099	com/tencent/mobileqq/msf/core/net/a/a:a	Ljava/lang/String;
    //   849: iconst_1
    //   850: ldc_w 1101
    //   853: aload 6
    //   855: invokestatic 308	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   858: goto -492 -> 366
    //   861: iconst_0
    //   862: putstatic 418	com/tencent/mobileqq/msf/core/aj:s	Z
    //   865: goto -499 -> 366
    //   868: astore 7
    //   870: aload 7
    //   872: invokevirtual 1102	java/lang/Throwable:printStackTrace	()V
    //   875: goto -325 -> 550
    //   878: astore 7
    //   880: goto -324 -> 556
    //   883: astore 7
    //   885: iconst_1
    //   886: istore_2
    //   887: aload_0
    //   888: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   891: invokevirtual 774	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   894: aload 7
    //   896: athrow
    //   897: astore 7
    //   899: ldc 179
    //   901: iconst_1
    //   902: new 181	java/lang/StringBuilder
    //   905: dup
    //   906: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   909: ldc_w 1104
    //   912: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: aload 7
    //   917: invokevirtual 697	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   920: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   923: aload 7
    //   925: invokestatic 308	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   928: goto -347 -> 581
    //   931: aload_0
    //   932: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   935: ifnull +14 -> 949
    //   938: aload_0
    //   939: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   942: getfield 1026	com/tencent/mobileqq/msf/core/net/m$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   945: iconst_0
    //   946: invokevirtual 497	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   949: ldc 179
    //   951: iconst_1
    //   952: ldc_w 1106
    //   955: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   958: aload_0
    //   959: getfield 102	com/tencent/mobileqq/msf/core/net/m:w	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   962: iconst_1
    //   963: invokevirtual 497	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   966: iload_3
    //   967: istore_2
    //   968: aload_0
    //   969: getfield 95	com/tencent/mobileqq/msf/core/net/m:s	Ljava/util/concurrent/atomic/AtomicInteger;
    //   972: iconst_1
    //   973: invokevirtual 1109	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   976: bipush 10
    //   978: if_icmpne -397 -> 581
    //   981: invokestatic 1114	android/os/Process:myPid	()I
    //   984: invokestatic 1117	android/os/Process:killProcess	(I)V
    //   987: iload_3
    //   988: istore_2
    //   989: goto -408 -> 581
    //   992: astore 7
    //   994: iconst_1
    //   995: istore_2
    //   996: goto -97 -> 899
    //   999: ldc 179
    //   1001: iconst_1
    //   1002: new 181	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   1009: ldc_w 1073
    //   1012: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: aload 6
    //   1017: invokestatic 486	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1020: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: ldc_w 1075
    //   1026: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: aload_1
    //   1030: invokevirtual 697	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1033: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1036: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1039: goto -275 -> 764
    //   1042: astore 6
    //   1044: aload 6
    //   1046: invokevirtual 303	java/lang/Exception:printStackTrace	()V
    //   1049: goto -242 -> 807
    //   1052: astore 6
    //   1054: ldc 179
    //   1056: iconst_1
    //   1057: new 181	java/lang/StringBuilder
    //   1060: dup
    //   1061: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   1064: ldc_w 1119
    //   1067: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: aload 6
    //   1072: invokevirtual 697	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1075: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1078: aload 6
    //   1080: invokestatic 308	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1083: goto -244 -> 839
    //   1086: astore 7
    //   1088: iconst_1
    //   1089: istore_2
    //   1090: ldc 82
    //   1092: astore 6
    //   1094: goto -195 -> 899
    //   1097: astore 7
    //   1099: goto -200 -> 899
    //   1102: astore 7
    //   1104: goto -217 -> 887
    //   1107: astore 7
    //   1109: goto -591 -> 518
    //   1112: astore 7
    //   1114: goto -628 -> 486
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1117	0	this	m
    //   0	1117	1	parama	com.tencent.qphone.base.a
    //   416	674	2	bool1	boolean
    //   367	621	3	bool2	boolean
    //   612	87	4	l1	long
    //   119	57	6	localMsfCore	MsfCore
    //   277	1	6	localException1	Exception
    //   401	343	6	str1	String
    //   844	172	6	localException2	Exception
    //   1042	3	6	localException3	Exception
    //   1052	27	6	localException4	Exception
    //   1092	1	6	str2	String
    //   490	225	7	localObject1	Object
    //   868	3	7	localThrowable1	java.lang.Throwable
    //   878	1	7	localThrowable2	java.lang.Throwable
    //   883	12	7	localObject2	Object
    //   897	27	7	localThrowable3	java.lang.Throwable
    //   992	1	7	localThrowable4	java.lang.Throwable
    //   1086	1	7	localThrowable5	java.lang.Throwable
    //   1097	1	7	localThrowable6	java.lang.Throwable
    //   1102	1	7	localObject3	Object
    //   1107	1	7	localException5	Exception
    //   1112	1	7	localThrowable7	java.lang.Throwable
    //   637	80	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   56	69	277	java/lang/Exception
    //   56	69	301	finally
    //   279	294	301	finally
    //   326	366	844	java/lang/Exception
    //   536	550	868	java/lang/Throwable
    //   529	536	878	java/lang/Throwable
    //   550	556	878	java/lang/Throwable
    //   870	875	878	java/lang/Throwable
    //   421	448	883	finally
    //   887	897	897	java/lang/Throwable
    //   403	417	992	java/lang/Throwable
    //   931	949	992	java/lang/Throwable
    //   949	966	992	java/lang/Throwable
    //   968	987	992	java/lang/Throwable
    //   764	796	1042	java/lang/Exception
    //   796	807	1042	java/lang/Exception
    //   836	839	1052	java/lang/Exception
    //   394	403	1086	java/lang/Throwable
    //   574	581	1097	java/lang/Throwable
    //   448	466	1102	finally
    //   466	486	1102	finally
    //   486	492	1102	finally
    //   497	518	1102	finally
    //   518	524	1102	finally
    //   529	536	1102	finally
    //   536	550	1102	finally
    //   550	556	1102	finally
    //   556	574	1102	finally
    //   870	875	1102	finally
    //   497	518	1107	java/lang/Exception
    //   466	486	1112	java/lang/Throwable
  }
  
  public boolean c()
  {
    return this.v.get();
  }
  
  public boolean d()
  {
    return this.x.get();
  }
  
  public long e()
  {
    return this.z;
  }
  
  public long f()
  {
    return this.B;
  }
  
  public void g()
  {
    try
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "MSF");
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setMsfCommand(MsfCommand.msf_msgsignal);
      QLog.d("MSF.C.NetConnTag", 1, "msgSignal seq: " + localToServiceMsg.getRequestSsoSeq());
      int i1 = "CHNK".getBytes().length + 13 + 1 + 0 + 4;
      byte b1 = (byte)("CHNK".getBytes().length + 1);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i1);
      localByteBuffer.putInt(i1).putInt(20140601).putInt(0).put(b1).put("CHNK".getBytes()).put((byte)1).putInt(0);
      localToServiceMsg.putWupBuffer(localByteBuffer.array());
      a(this.r.getMsfAppid(), 0, localToServiceMsg.getRequestSsoSeq(), localToServiceMsg.getUin(), localToServiceMsg.getServiceCmd(), "", localToServiceMsg.getMsfCommand(), localToServiceMsg.getWupBuffer(), null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("MSF.C.NetConnTag", 1, "send MsgSignal pkg fail, exception ", localException);
    }
  }
  
  public ToServiceMsg h()
  {
    if (this.y != null)
    {
      this.r.sender.c(this.y.getRequestSsoSeq());
      this.r.sender.d(this.y);
    }
    return this.y;
  }
  
  public int i()
  {
    if (this.g == null) {
      return 0;
    }
    return this.g.hashCode();
  }
  
  public int j()
  {
    if ((this.v.get()) && (this.d != null)) {
      return this.d.d();
    }
    return 0;
  }
  
  public long k()
  {
    return this.C.get();
  }
  
  public long l()
  {
    long l1 = 0L;
    h localh = this.g;
    if (localh != null) {
      l1 = localh.a();
    }
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.m
 * JD-Core Version:    0.7.0.1
 */