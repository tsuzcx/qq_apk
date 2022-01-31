package com.tencent.mobileqq.msf.core.net;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ag;
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
  
  private void m()
  {
    if ((this.r != null) && (this.r.pushManager != null) && (this.r.pushManager.av != null))
    {
      this.r.sendSsoMsg(this.r.pushManager.av);
      this.r.pushManager.av = null;
    }
  }
  
  private void n()
  {
    try
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("", "0", "MSF");
      localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
      localToServiceMsg.setMsfCommand(MsfCommand.msf_ssoping);
      long l1 = com.tencent.mobileqq.msf.core.a.a.u();
      if (l1 > 10000L) {
        localToServiceMsg.setTimeout(l1);
      }
      for (;;)
      {
        QLog.d("MSF.C.NetConnTag", 1, "ssoping seq: " + localToServiceMsg.getRequestSsoSeq() + " timeout: " + localToServiceMsg.getTimeout());
        int i1 = "MSF".getBytes().length + 13 + 1 + 0 + 4;
        byte b1 = (byte)("MSF".getBytes().length + 1);
        ByteBuffer localByteBuffer = ByteBuffer.allocate(i1);
        localByteBuffer.putInt(i1).putInt(20140601).putInt(0).put(b1).put("MSF".getBytes()).put((byte)5).putInt(0);
        localToServiceMsg.putWupBuffer(localByteBuffer.array());
        this.y = localToServiceMsg;
        this.r.sender.c(localToServiceMsg);
        localToServiceMsg.getAttributes().put("__timestamp_msf2net", Long.valueOf(SystemClock.elapsedRealtime()));
        if (a(this.r.getMsfAppid(), 0, localToServiceMsg.getRequestSsoSeq(), localToServiceMsg.getUin(), localToServiceMsg.getServiceCmd(), "", localToServiceMsg.getMsfCommand(), localToServiceMsg.getWupBuffer(), null) <= 0) {
          break;
        }
        com.tencent.mobileqq.a.a.a.a().a(localToServiceMsg);
        return;
        localToServiceMsg.setTimeout(10000L);
      }
      this.r.sender.c(localException.getRequestSsoSeq());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("MSF.C.NetConnTag", 1, "send SSOPing pkg fail, exception ", localException);
      return;
    }
    this.r.sender.d(localException);
    QLog.d("MSF.C.NetConnTag", 1, "send SSOPing pkg fail");
    b(com.tencent.qphone.base.a.C);
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
        if ((!ag.s) || (!f.a())) {
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
    //   4: invokevirtual 337	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifne +13 -> 20
    //   10: aload_0
    //   11: getfield 100	com/tencent/mobileqq/msf/core/net/m:v	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   14: invokevirtual 337	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   17: ifne +28 -> 45
    //   20: aload_0
    //   21: getfield 102	com/tencent/mobileqq/msf/core/net/m:w	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   24: invokevirtual 337	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   27: ifeq +18 -> 45
    //   30: aload_0
    //   31: getfield 102	com/tencent/mobileqq/msf/core/net/m:w	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   34: iconst_0
    //   35: invokevirtual 493	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   38: aload_0
    //   39: getstatic 495	com/tencent/qphone/base/a:f	Lcom/tencent/qphone/base/a;
    //   42: invokevirtual 333	com/tencent/mobileqq/msf/core/net/m:b	(Lcom/tencent/qphone/base/a;)V
    //   45: aload_0
    //   46: getfield 255	com/tencent/mobileqq/msf/core/net/m:y	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   49: ifnull +22 -> 71
    //   52: aload_0
    //   53: invokevirtual 498	com/tencent/mobileqq/msf/core/net/m:h	()Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   56: pop
    //   57: aload_0
    //   58: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   61: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   64: aload_0
    //   65: getfield 500	com/tencent/mobileqq/msf/core/net/m:F	Ljava/lang/Runnable;
    //   68: invokevirtual 503	com/tencent/mobileqq/msf/core/ag:a	(Ljava/lang/Runnable;)V
    //   71: aload_0
    //   72: aload_1
    //   73: putfield 344	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   76: aload_0
    //   77: aload_2
    //   78: putfield 339	com/tencent/mobileqq/msf/core/net/m:i	Lcom/tencent/mobileqq/msf/core/net/d;
    //   81: aload_0
    //   82: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   85: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   88: aload_1
    //   89: invokevirtual 507	com/tencent/mobileqq/msf/core/d:j	()Z
    //   92: putfield 358	com/tencent/mobileqq/msf/core/ag:r	Z
    //   95: getstatic 512	com/tencent/mobileqq/msf/core/net/x:b	Lcom/tencent/mobileqq/msf/core/net/x;
    //   98: astore 14
    //   100: ldc 82
    //   102: astore 15
    //   104: aload_0
    //   105: lconst_0
    //   106: putfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   109: aload_0
    //   110: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   113: ldc2_w 513
    //   116: getstatic 520	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   119: invokevirtual 524	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   122: ifeq +2594 -> 2716
    //   125: invokestatic 273	android/os/SystemClock:elapsedRealtime	()J
    //   128: lstore 8
    //   130: invokestatic 529	java/lang/System:currentTimeMillis	()J
    //   133: lstore 6
    //   135: aload_0
    //   136: invokestatic 529	java/lang/System:currentTimeMillis	()J
    //   139: putfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   142: invokestatic 534	com/tencent/mobileqq/a/a/a$c:a	()Lcom/tencent/mobileqq/a/a/a$c;
    //   145: iconst_0
    //   146: aload_1
    //   147: invokevirtual 537	com/tencent/mobileqq/a/a/a$c:a	(ZLcom/tencent/mobileqq/msf/core/d;)V
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
    //   170: new 539	java/net/InetSocketAddress
    //   173: dup
    //   174: aload_1
    //   175: invokevirtual 541	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   178: aload_1
    //   179: invokevirtual 543	com/tencent/mobileqq/msf/core/d:f	()I
    //   182: invokespecial 546	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   185: putfield 484	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
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
    //   207: invokestatic 308	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   210: invokevirtual 548	com/tencent/mobileqq/a/a/a:c	()V
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
    //   232: new 193	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 194	java/lang/StringBuilder:<init>	()V
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
    //   260: ldc_w 550
    //   263: iconst_1
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: aload_1
    //   270: invokevirtual 551	com/tencent/mobileqq/msf/core/d:toString	()Ljava/lang/String;
    //   273: aastore
    //   274: invokestatic 555	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   277: invokestatic 560	com/tencent/mobileqq/msf/core/am:a	(Ljava/lang/String;)V
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
    //   299: invokestatic 437	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   302: ifeq +2423 -> 2725
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
    //   326: ldc_w 562
    //   329: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_1
    //   333: invokevirtual 551	com/tencent/mobileqq/msf/core/d:toString	()Ljava/lang/String;
    //   336: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   361: getfield 564	com/tencent/mobileqq/msf/core/d:g	Z
    //   364: ifeq +2353 -> 2717
    //   367: ldc_w 566
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
    //   395: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: ldc_w 568
    //   401: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokestatic 573	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   407: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   410: ldc_w 575
    //   413: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   438: invokestatic 580	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   441: ifeq +4263 -> 4704
    //   444: ldc_w 582
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
    //   468: ldc 191
    //   470: iconst_1
    //   471: aload 18
    //   473: aload 16
    //   475: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: ldc_w 584
    //   481: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload_1
    //   485: invokevirtual 586	com/tencent/mobileqq/msf/core/d:b	()Ljava/lang/String;
    //   488: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   516: invokestatic 529	java/lang/System:currentTimeMillis	()J
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
    //   541: new 588	com/tencent/mobileqq/msf/core/net/h
    //   544: dup
    //   545: invokespecial 589	com/tencent/mobileqq/msf/core/net/h:<init>	()V
    //   548: putfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
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
    //   571: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   574: sipush 10000
    //   577: invokevirtual 592	com/tencent/mobileqq/msf/core/net/h:setSoTimeout	(I)V
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
    //   600: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   603: iconst_1
    //   604: invokevirtual 595	com/tencent/mobileqq/msf/core/net/h:setTcpNoDelay	(Z)V
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
    //   627: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   630: iconst_1
    //   631: invokevirtual 598	com/tencent/mobileqq/msf/core/net/h:setKeepAlive	(Z)V
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
    //   683: getfield 602	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
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
    //   712: getfield 602	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   715: iconst_1
    //   716: invokeinterface 608 2 0
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
    //   742: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   745: aload_0
    //   746: getfield 484	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   749: aload_1
    //   750: invokevirtual 610	com/tencent/mobileqq/msf/core/d:g	()I
    //   753: invokevirtual 614	com/tencent/mobileqq/msf/core/net/h:connect	(Ljava/net/SocketAddress;I)V
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
    //   805: getfield 602	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
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
    //   834: getfield 602	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   837: iconst_1
    //   838: invokeinterface 617 2 0
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
    //   864: invokestatic 573	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
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
    //   891: invokevirtual 619	com/tencent/mobileqq/msf/core/d:d	()I
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
    //   918: putfield 623	com/tencent/mobileqq/msf/core/net/a:d	Z
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
    //   942: getfield 625	com/tencent/mobileqq/msf/core/net/a:j	I
    //   945: iconst_1
    //   946: iadd
    //   947: putfield 625	com/tencent/mobileqq/msf/core/net/a:j	I
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
    //   970: invokestatic 529	java/lang/System:currentTimeMillis	()J
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
    //   1029: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   1032: getfield 628	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
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
    //   1060: getfield 632	com/tencent/mobileqq/msf/core/net/n:l	J
    //   1063: aload_0
    //   1064: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   1067: ladd
    //   1068: putfield 632	com/tencent/mobileqq/msf/core/net/n:l	J
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
    //   1094: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   1097: getfield 628	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   1100: aload_0
    //   1101: getfield 132	com/tencent/mobileqq/msf/core/net/m:G	I
    //   1104: iconst_1
    //   1105: invokevirtual 635	com/tencent/mobileqq/msf/core/net/n:b	(IZ)V
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
    //   1183: putstatic 638	com/tencent/mobileqq/msf/core/ag:U	J
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
    //   1210: invokevirtual 640	java/util/concurrent/atomic/AtomicLong:set	(J)V
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
    //   1237: invokevirtual 640	java/util/concurrent/atomic/AtomicLong:set	(J)V
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
    //   1261: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1264: invokevirtual 644	com/tencent/mobileqq/msf/core/net/h:getOutputStream	()Ljava/io/OutputStream;
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
    //   1296: invokevirtual 645	java/lang/Object:toString	()Ljava/lang/String;
    //   1299: invokevirtual 648	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
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
    //   1331: invokevirtual 645	java/lang/Object:toString	()Ljava/lang/String;
    //   1334: invokevirtual 651	java/util/ArrayList:add	(Ljava/lang/Object;)Z
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
    //   1358: new 653	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   1361: dup
    //   1362: aload_0
    //   1363: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1366: sipush 2048
    //   1369: ldc_w 655
    //   1372: iconst_m1
    //   1373: invokespecial 658	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
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
    //   1428: invokevirtual 663	com/tencent/mobileqq/msf/core/net/m$a:isAlive	()Z
    //   1431: ifne +1912 -> 3343
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
    //   1454: new 665	com/tencent/mobileqq/msf/core/net/m$b
    //   1457: dup
    //   1458: aload_0
    //   1459: invokespecial 668	com/tencent/mobileqq/msf/core/net/m$b:<init>	(Lcom/tencent/mobileqq/msf/core/net/m;)V
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
    //   1488: ldc_w 670
    //   1491: invokevirtual 673	com/tencent/mobileqq/msf/core/net/m$a:setName	(Ljava/lang/String;)V
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
    //   1517: invokevirtual 676	com/tencent/mobileqq/msf/core/net/m$a:start	()V
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
    //   1544: invokevirtual 493	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
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
    //   1566: getstatic 678	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   1569: astore 14
    //   1571: ldc_w 680
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
    //   1595: invokestatic 682	com/tencent/mobileqq/msf/core/ag:h	()V
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
    //   1618: invokevirtual 684	com/tencent/mobileqq/msf/core/d:a	()Ljava/lang/String;
    //   1621: putstatic 686	com/tencent/mobileqq/msf/core/ag:E	Ljava/lang/String;
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
    //   1643: new 193	java/lang/StringBuilder
    //   1646: dup
    //   1647: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   1650: aload_0
    //   1651: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1654: invokevirtual 690	com/tencent/mobileqq/msf/core/net/h:getLocalSocketAddress	()Ljava/net/SocketAddress;
    //   1657: invokevirtual 693	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1660: ldc_w 695
    //   1663: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1666: aload_0
    //   1667: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1670: invokevirtual 698	com/tencent/mobileqq/msf/core/net/h:getLocalPort	()I
    //   1673: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1676: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1679: putstatic 700	com/tencent/mobileqq/msf/core/ag:F	Ljava/lang/String;
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
    //   1701: invokestatic 703	com/tencent/mobileqq/msf/core/net/j:b	()B
    //   1704: putstatic 706	com/tencent/mobileqq/msf/core/ag:H	I
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
    //   1727: invokevirtual 707	com/tencent/mobileqq/msf/core/d:h	()V
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
    //   1754: invokevirtual 710	java/lang/StringBuilder:length	()I
    //   1757: invokevirtual 714	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
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
    //   1780: invokestatic 437	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1783: ifeq +1650 -> 3433
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
    //   1807: ldc_w 716
    //   1810: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1813: aload_0
    //   1814: getfield 484	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   1817: invokevirtual 717	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   1820: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1823: ldc_w 719
    //   1826: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1829: aload_0
    //   1830: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   1833: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1836: ldc_w 721
    //   1839: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1842: aload_1
    //   1843: invokevirtual 610	com/tencent/mobileqq/msf/core/d:g	()I
    //   1846: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1849: ldc_w 723
    //   1852: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1855: aload_0
    //   1856: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1859: invokevirtual 727	com/tencent/mobileqq/msf/core/net/h:getLocalAddress	()Ljava/net/InetAddress;
    //   1862: invokevirtual 732	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1865: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1868: ldc_w 734
    //   1871: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1874: aload_0
    //   1875: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1878: invokevirtual 698	com/tencent/mobileqq/msf/core/net/h:getLocalPort	()I
    //   1881: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
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
    //   1906: getfield 564	com/tencent/mobileqq/msf/core/d:g	Z
    //   1909: ifeq +1516 -> 3425
    //   1912: ldc_w 566
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
    //   1940: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1943: ldc_w 575
    //   1946: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   1971: invokestatic 580	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   1974: ifeq +2744 -> 4718
    //   1977: ldc_w 736
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
    //   2001: ldc 191
    //   2003: iconst_1
    //   2004: aload 17
    //   2006: aload 16
    //   2008: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2011: aload_0
    //   2012: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2015: invokevirtual 408	java/lang/Object:hashCode	()I
    //   2018: invokestatic 461	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   2021: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2024: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2027: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   2054: invokevirtual 738	java/util/concurrent/atomic/AtomicInteger:set	(I)V
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
    //   2076: getstatic 413	com/tencent/mobileqq/msf/core/ag:s	Z
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
    //   2101: invokestatic 417	com/tencent/mobileqq/msf/core/net/a/f:a	()Z
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
    //   2130: ldc 191
    //   2132: iconst_1
    //   2133: ldc_w 740
    //   2136: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   2162: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   2165: getfield 422	com/tencent/mobileqq/msf/core/ag:I	Lcom/tencent/mobileqq/msf/core/net/a/f;
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
    //   2194: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   2197: getfield 422	com/tencent/mobileqq/msf/core/ag:I	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   2200: invokevirtual 425	com/tencent/mobileqq/msf/core/net/a/f:b	()Lcom/tencent/mobileqq/msf/core/net/a/e;
    //   2203: aload_0
    //   2204: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2207: invokeinterface 743 2 0
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
    //   2235: invokevirtual 747	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
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
    //   2264: getfield 751	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2267: getfield 757	com/tencent/mobileqq/msf/core/c/k:X	Lcom/tencent/mobileqq/msf/core/c/k$c;
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
    //   2296: getfield 751	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2299: getfield 757	com/tencent/mobileqq/msf/core/c/k:X	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   2302: getfield 761	com/tencent/mobileqq/msf/core/c/k$c:e	J
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
    //   2333: getfield 751	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2336: getfield 757	com/tencent/mobileqq/msf/core/c/k:X	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   2339: lconst_0
    //   2340: putfield 763	com/tencent/mobileqq/msf/core/c/k$c:f	J
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
    //   2366: getfield 751	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   2369: getfield 757	com/tencent/mobileqq/msf/core/c/k:X	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   2372: lconst_0
    //   2373: putfield 765	com/tencent/mobileqq/msf/core/c/k$c:g	J
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
    //   2395: ldc 191
    //   2397: iconst_1
    //   2398: ldc_w 767
    //   2401: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2404: aload_0
    //   2405: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   2408: invokevirtual 770	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2411: aload 14
    //   2413: getstatic 678	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2416: if_acmpeq +18 -> 2434
    //   2419: aload_3
    //   2420: iconst_0
    //   2421: putfield 623	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   2424: aload_3
    //   2425: aload_3
    //   2426: getfield 772	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2429: iconst_1
    //   2430: iadd
    //   2431: putfield 772	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2434: aload_3
    //   2435: aload 14
    //   2437: putfield 774	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2440: aload_3
    //   2441: ldc_w 680
    //   2444: putfield 776	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   2447: aload_3
    //   2448: invokestatic 273	android/os/SystemClock:elapsedRealtime	()J
    //   2451: lload 8
    //   2453: lsub
    //   2454: putfield 778	com/tencent/mobileqq/msf/core/net/a:a	J
    //   2457: aload 14
    //   2459: astore 12
    //   2461: aload 12
    //   2463: getstatic 678	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2466: if_acmpne +2098 -> 4564
    //   2469: aload_1
    //   2470: invokestatic 580	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   2473: ifeq +16 -> 2489
    //   2476: invokestatic 534	com/tencent/mobileqq/a/a/a$c:a	()Lcom/tencent/mobileqq/a/a/a$c;
    //   2479: iconst_1
    //   2480: invokevirtual 780	com/tencent/mobileqq/a/a/a$c:a	(Z)V
    //   2483: invokestatic 534	com/tencent/mobileqq/a/a/a$c:a	()Lcom/tencent/mobileqq/a/a/a$c;
    //   2486: invokevirtual 782	com/tencent/mobileqq/a/a/a$c:b	()V
    //   2489: invokestatic 785	com/tencent/mobileqq/msf/core/NetConnInfoCenter:checkConnInfo	()V
    //   2492: invokestatic 788	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isNetSupport	()Z
    //   2495: ifne +7 -> 2502
    //   2498: iconst_1
    //   2499: invokestatic 791	com/tencent/mobileqq/msf/core/NetConnInfoCenter:setNetSupport	(Z)V
    //   2502: invokestatic 794	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   2505: putstatic 795	com/tencent/mobileqq/msf/core/ag:G	I
    //   2508: aload_0
    //   2509: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2512: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   2515: aconst_null
    //   2516: invokevirtual 797	com/tencent/mobileqq/msf/core/ag:a	([B)V
    //   2519: aload_0
    //   2520: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2523: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   2526: invokevirtual 799	com/tencent/mobileqq/msf/core/ag:f	()V
    //   2529: getstatic 801	com/tencent/mobileqq/msf/core/ag:A	Ljava/util/concurrent/atomic/AtomicInteger;
    //   2532: iconst_0
    //   2533: invokevirtual 738	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   2536: getstatic 803	com/tencent/mobileqq/msf/core/ag:B	Ljava/util/ArrayList;
    //   2539: invokevirtual 806	java/util/ArrayList:clear	()V
    //   2542: aload_0
    //   2543: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2546: ifnull +170 -> 2716
    //   2549: aload_0
    //   2550: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2553: new 193	java/lang/StringBuilder
    //   2556: dup
    //   2557: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   2560: aload_0
    //   2561: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2564: invokevirtual 727	com/tencent/mobileqq/msf/core/net/h:getLocalAddress	()Ljava/net/InetAddress;
    //   2567: invokevirtual 732	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   2570: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2573: ldc_w 734
    //   2576: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2579: aload_0
    //   2580: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2583: invokevirtual 698	com/tencent/mobileqq/msf/core/net/h:getLocalPort	()I
    //   2586: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2589: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2592: putfield 809	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   2595: invokestatic 308	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   2598: aload_0
    //   2599: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2602: getstatic 795	com/tencent/mobileqq/msf/core/ag:G	I
    //   2605: aload_0
    //   2606: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   2609: l2i
    //   2610: invokevirtual 812	com/tencent/mobileqq/a/a/a:a	(Ljava/net/Socket;II)V
    //   2613: aload_0
    //   2614: getfield 104	com/tencent/mobileqq/msf/core/net/m:x	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2617: iconst_0
    //   2618: invokevirtual 493	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   2621: invokestatic 814	com/tencent/mobileqq/msf/core/a/a:v	()Z
    //   2624: ifeq +1879 -> 4503
    //   2627: aload_0
    //   2628: invokespecial 816	com/tencent/mobileqq/msf/core/net/m:n	()V
    //   2631: aload_0
    //   2632: invokespecial 818	com/tencent/mobileqq/msf/core/net/m:m	()V
    //   2635: invokestatic 820	com/tencent/mobileqq/msf/core/a/a:w	()Z
    //   2638: ifeq +1895 -> 4533
    //   2641: aload_0
    //   2642: aload_0
    //   2643: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2646: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   2649: aload_0
    //   2650: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   2653: invokevirtual 408	java/lang/Object:hashCode	()I
    //   2656: invokevirtual 823	com/tencent/mobileqq/msf/core/ag:a	(I)Ljava/lang/Runnable;
    //   2659: putfield 500	com/tencent/mobileqq/msf/core/net/m:F	Ljava/lang/Runnable;
    //   2662: aload_0
    //   2663: getfield 484	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   2666: invokevirtual 717	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   2669: invokestatic 828	com/tencent/qphone/base/util/g:b	(Ljava/lang/String;)J
    //   2672: putstatic 832	com/tencent/mobileqq/msf/core/push/e:d	J
    //   2675: aload_1
    //   2676: invokevirtual 541	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   2679: aload_1
    //   2680: invokevirtual 543	com/tencent/mobileqq/msf/core/d:f	()I
    //   2683: getstatic 795	com/tencent/mobileqq/msf/core/ag:G	I
    //   2686: invokestatic 837	com/tencent/mobileqq/a/a/f:a	(Ljava/lang/String;II)V
    //   2689: aload_0
    //   2690: getfield 484	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   2693: invokevirtual 717	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   2696: aload_0
    //   2697: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2700: getfield 809	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   2703: invokestatic 841	com/tencent/mobileqq/msf/core/NetConnInfoCenter:onConnOpened	(Ljava/lang/String;Ljava/lang/String;)V
    //   2706: aload_0
    //   2707: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2710: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   2713: invokevirtual 842	com/tencent/mobileqq/msf/core/ag:m	()V
    //   2716: return
    //   2717: ldc_w 844
    //   2720: astore 16
    //   2722: goto -2350 -> 372
    //   2725: aload 15
    //   2727: astore 12
    //   2729: lload 6
    //   2731: lstore 4
    //   2733: aload 14
    //   2735: astore 11
    //   2737: aload 15
    //   2739: astore 13
    //   2741: aload 14
    //   2743: astore_2
    //   2744: aload 17
    //   2746: ldc_w 562
    //   2749: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2752: aload_1
    //   2753: invokevirtual 551	com/tencent/mobileqq/msf/core/d:toString	()Ljava/lang/String;
    //   2756: invokestatic 481	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2759: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2762: astore 18
    //   2764: aload 15
    //   2766: astore 12
    //   2768: lload 6
    //   2770: lstore 4
    //   2772: aload 14
    //   2774: astore 11
    //   2776: aload 15
    //   2778: astore 13
    //   2780: aload 14
    //   2782: astore_2
    //   2783: aload_1
    //   2784: getfield 564	com/tencent/mobileqq/msf/core/d:g	Z
    //   2787: ifeq +548 -> 3335
    //   2790: ldc_w 566
    //   2793: astore 16
    //   2795: aload 15
    //   2797: astore 12
    //   2799: lload 6
    //   2801: lstore 4
    //   2803: aload 14
    //   2805: astore 11
    //   2807: aload 15
    //   2809: astore 13
    //   2811: aload 14
    //   2813: astore_2
    //   2814: aload 18
    //   2816: aload 16
    //   2818: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2821: ldc_w 568
    //   2824: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2827: invokestatic 573	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   2830: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2833: ldc_w 575
    //   2836: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2839: astore 18
    //   2841: aload 15
    //   2843: astore 12
    //   2845: lload 6
    //   2847: lstore 4
    //   2849: aload 14
    //   2851: astore 11
    //   2853: aload 15
    //   2855: astore 13
    //   2857: aload 14
    //   2859: astore_2
    //   2860: aload_1
    //   2861: invokestatic 580	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   2864: ifeq +1847 -> 4711
    //   2867: ldc_w 582
    //   2870: astore 16
    //   2872: aload 15
    //   2874: astore 12
    //   2876: lload 6
    //   2878: lstore 4
    //   2880: aload 14
    //   2882: astore 11
    //   2884: aload 15
    //   2886: astore 13
    //   2888: aload 14
    //   2890: astore_2
    //   2891: ldc 191
    //   2893: iconst_1
    //   2894: aload 18
    //   2896: aload 16
    //   2898: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2901: ldc_w 584
    //   2904: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2907: aload_1
    //   2908: invokevirtual 586	com/tencent/mobileqq/msf/core/d:b	()Ljava/lang/String;
    //   2911: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2914: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2917: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2920: goto -2423 -> 497
    //   2923: astore 16
    //   2925: aload 12
    //   2927: astore 13
    //   2929: aload 11
    //   2931: astore_2
    //   2932: aload_0
    //   2933: invokestatic 529	java/lang/System:currentTimeMillis	()J
    //   2936: lload 4
    //   2938: lsub
    //   2939: putfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   2942: aload 12
    //   2944: astore 13
    //   2946: aload 11
    //   2948: astore_2
    //   2949: aload_0
    //   2950: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2953: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   2956: getfield 628	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   2959: astore 14
    //   2961: aload 12
    //   2963: astore 13
    //   2965: aload 11
    //   2967: astore_2
    //   2968: aload 14
    //   2970: aload 14
    //   2972: getfield 632	com/tencent/mobileqq/msf/core/net/n:l	J
    //   2975: aload_0
    //   2976: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   2979: ladd
    //   2980: putfield 632	com/tencent/mobileqq/msf/core/net/n:l	J
    //   2983: aload 12
    //   2985: astore 13
    //   2987: aload 11
    //   2989: astore_2
    //   2990: aload_0
    //   2991: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2994: invokevirtual 747	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   2997: ifnull +176 -> 3173
    //   3000: aload 12
    //   3002: astore 13
    //   3004: aload 11
    //   3006: astore_2
    //   3007: aload_0
    //   3008: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3011: getfield 751	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3014: getfield 757	com/tencent/mobileqq/msf/core/c/k:X	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3017: ifnull +156 -> 3173
    //   3020: aload 12
    //   3022: astore 13
    //   3024: aload 11
    //   3026: astore_2
    //   3027: aload_0
    //   3028: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3031: getfield 751	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3034: getfield 757	com/tencent/mobileqq/msf/core/c/k:X	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3037: getfield 761	com/tencent/mobileqq/msf/core/c/k$c:e	J
    //   3040: lconst_0
    //   3041: lcmp
    //   3042: ifle +51 -> 3093
    //   3045: aload 12
    //   3047: astore 13
    //   3049: aload 11
    //   3051: astore_2
    //   3052: aload_0
    //   3053: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3056: getfield 751	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3059: getfield 757	com/tencent/mobileqq/msf/core/c/k:X	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3062: getfield 763	com/tencent/mobileqq/msf/core/c/k$c:f	J
    //   3065: lconst_0
    //   3066: lcmp
    //   3067: ifne +26 -> 3093
    //   3070: aload 12
    //   3072: astore 13
    //   3074: aload 11
    //   3076: astore_2
    //   3077: aload_0
    //   3078: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3081: getfield 751	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3084: getfield 757	com/tencent/mobileqq/msf/core/c/k:X	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3087: invokestatic 529	java/lang/System:currentTimeMillis	()J
    //   3090: putfield 763	com/tencent/mobileqq/msf/core/c/k$c:f	J
    //   3093: aload 12
    //   3095: astore 13
    //   3097: aload 11
    //   3099: astore_2
    //   3100: aload_0
    //   3101: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3104: getfield 751	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3107: getfield 757	com/tencent/mobileqq/msf/core/c/k:X	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3110: getfield 765	com/tencent/mobileqq/msf/core/c/k$c:g	J
    //   3113: lconst_0
    //   3114: lcmp
    //   3115: ifne +58 -> 3173
    //   3118: aload 12
    //   3120: astore 13
    //   3122: aload 11
    //   3124: astore_2
    //   3125: aload_0
    //   3126: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3129: getfield 751	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   3132: getfield 757	com/tencent/mobileqq/msf/core/c/k:X	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   3135: invokestatic 529	java/lang/System:currentTimeMillis	()J
    //   3138: putfield 765	com/tencent/mobileqq/msf/core/c/k$c:g	J
    //   3141: aload 12
    //   3143: astore 13
    //   3145: aload 11
    //   3147: astore_2
    //   3148: ldc 191
    //   3150: iconst_1
    //   3151: iconst_2
    //   3152: anewarray 4	java/lang/Object
    //   3155: dup
    //   3156: iconst_0
    //   3157: ldc_w 846
    //   3160: aastore
    //   3161: dup
    //   3162: iconst_1
    //   3163: invokestatic 529	java/lang/System:currentTimeMillis	()J
    //   3166: invokestatic 279	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3169: aastore
    //   3170: invokestatic 849	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   3173: aload 12
    //   3175: astore 13
    //   3177: aload 11
    //   3179: astore_2
    //   3180: aload 16
    //   3182: invokevirtual 850	java/lang/Throwable:toString	()Ljava/lang/String;
    //   3185: invokevirtual 853	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   3188: astore 15
    //   3190: aload 15
    //   3192: astore 13
    //   3194: aload 11
    //   3196: astore_2
    //   3197: invokestatic 794	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   3200: ifne +521 -> 3721
    //   3203: aload 15
    //   3205: astore 13
    //   3207: aload 11
    //   3209: astore_2
    //   3210: getstatic 855	com/tencent/mobileqq/msf/core/net/x:m	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3213: astore 12
    //   3215: aload 15
    //   3217: astore 13
    //   3219: aload 12
    //   3221: astore_2
    //   3222: aload 12
    //   3224: invokevirtual 856	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   3227: astore 11
    //   3229: aload 11
    //   3231: astore 13
    //   3233: aload 12
    //   3235: astore_2
    //   3236: aload_3
    //   3237: invokestatic 859	com/tencent/mobileqq/msf/core/a/a:aE	()I
    //   3240: putfield 861	com/tencent/mobileqq/msf/core/net/a:h	I
    //   3243: aload_0
    //   3244: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   3247: invokevirtual 770	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   3250: aload 12
    //   3252: getstatic 678	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3255: if_acmpeq +18 -> 3273
    //   3258: aload_3
    //   3259: iconst_0
    //   3260: putfield 623	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   3263: aload_3
    //   3264: aload_3
    //   3265: getfield 772	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3268: iconst_1
    //   3269: iadd
    //   3270: putfield 772	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3273: aload_3
    //   3274: aload 12
    //   3276: putfield 774	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3279: aload_3
    //   3280: aload 11
    //   3282: putfield 776	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3285: aload_3
    //   3286: invokestatic 273	android/os/SystemClock:elapsedRealtime	()J
    //   3289: lload 8
    //   3291: lsub
    //   3292: putfield 778	com/tencent/mobileqq/msf/core/net/a:a	J
    //   3295: goto -834 -> 2461
    //   3298: astore_1
    //   3299: aload_3
    //   3300: iconst_0
    //   3301: putfield 623	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   3304: aload_3
    //   3305: aload_3
    //   3306: getfield 772	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3309: iconst_1
    //   3310: iadd
    //   3311: putfield 772	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3314: aload_3
    //   3315: getstatic 863	com/tencent/mobileqq/msf/core/net/x:f	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3318: putfield 774	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3321: aload_3
    //   3322: aload_1
    //   3323: invokevirtual 864	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   3326: putfield 776	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3329: aload_3
    //   3330: lconst_0
    //   3331: putfield 778	com/tencent/mobileqq/msf/core/net/a:a	J
    //   3334: return
    //   3335: ldc_w 844
    //   3338: astore 16
    //   3340: goto -545 -> 2795
    //   3343: aload 15
    //   3345: astore 12
    //   3347: lload 6
    //   3349: lstore 4
    //   3351: aload 14
    //   3353: astore 11
    //   3355: aload 15
    //   3357: astore 13
    //   3359: aload 14
    //   3361: astore_2
    //   3362: aload_0
    //   3363: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   3366: invokevirtual 866	com/tencent/mobileqq/msf/core/net/m$a:a	()V
    //   3369: goto -1849 -> 1520
    //   3372: astore_1
    //   3373: aload_0
    //   3374: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   3377: invokevirtual 770	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   3380: aload_2
    //   3381: getstatic 678	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3384: if_acmpeq +18 -> 3402
    //   3387: aload_3
    //   3388: iconst_0
    //   3389: putfield 623	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   3392: aload_3
    //   3393: aload_3
    //   3394: getfield 772	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3397: iconst_1
    //   3398: iadd
    //   3399: putfield 772	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3402: aload_3
    //   3403: aload_2
    //   3404: putfield 774	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3407: aload_3
    //   3408: aload 13
    //   3410: putfield 776	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3413: aload_3
    //   3414: invokestatic 273	android/os/SystemClock:elapsedRealtime	()J
    //   3417: lload 8
    //   3419: lsub
    //   3420: putfield 778	com/tencent/mobileqq/msf/core/net/a:a	J
    //   3423: aload_1
    //   3424: athrow
    //   3425: ldc_w 844
    //   3428: astore 16
    //   3430: goto -1513 -> 1917
    //   3433: aload 15
    //   3435: astore 12
    //   3437: lload 6
    //   3439: lstore 4
    //   3441: aload 14
    //   3443: astore 11
    //   3445: aload 15
    //   3447: astore 13
    //   3449: aload 14
    //   3451: astore_2
    //   3452: aload 17
    //   3454: ldc_w 716
    //   3457: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3460: aload_0
    //   3461: getfield 484	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   3464: invokevirtual 717	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   3467: invokestatic 481	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3470: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3473: ldc_w 719
    //   3476: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3479: aload_0
    //   3480: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   3483: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3486: ldc_w 721
    //   3489: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3492: aload_1
    //   3493: invokevirtual 610	com/tencent/mobileqq/msf/core/d:g	()I
    //   3496: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3499: ldc_w 723
    //   3502: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3505: aload_0
    //   3506: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   3509: invokevirtual 727	com/tencent/mobileqq/msf/core/net/h:getLocalAddress	()Ljava/net/InetAddress;
    //   3512: invokevirtual 732	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   3515: invokestatic 481	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3518: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3521: ldc_w 734
    //   3524: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3527: aload_0
    //   3528: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   3531: invokevirtual 698	com/tencent/mobileqq/msf/core/net/h:getLocalPort	()I
    //   3534: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3537: astore 17
    //   3539: aload 15
    //   3541: astore 12
    //   3543: lload 6
    //   3545: lstore 4
    //   3547: aload 14
    //   3549: astore 11
    //   3551: aload 15
    //   3553: astore 13
    //   3555: aload 14
    //   3557: astore_2
    //   3558: aload_1
    //   3559: getfield 564	com/tencent/mobileqq/msf/core/d:g	Z
    //   3562: ifeq +1164 -> 4726
    //   3565: ldc_w 566
    //   3568: astore 16
    //   3570: aload 15
    //   3572: astore 12
    //   3574: lload 6
    //   3576: lstore 4
    //   3578: aload 14
    //   3580: astore 11
    //   3582: aload 15
    //   3584: astore 13
    //   3586: aload 14
    //   3588: astore_2
    //   3589: aload 17
    //   3591: aload 16
    //   3593: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3596: ldc_w 575
    //   3599: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3602: astore 17
    //   3604: aload 15
    //   3606: astore 12
    //   3608: lload 6
    //   3610: lstore 4
    //   3612: aload 14
    //   3614: astore 11
    //   3616: aload 15
    //   3618: astore 13
    //   3620: aload 14
    //   3622: astore_2
    //   3623: aload_1
    //   3624: invokestatic 580	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   3627: ifeq +1107 -> 4734
    //   3630: ldc_w 736
    //   3633: astore 16
    //   3635: aload 15
    //   3637: astore 12
    //   3639: lload 6
    //   3641: lstore 4
    //   3643: aload 14
    //   3645: astore 11
    //   3647: aload 15
    //   3649: astore 13
    //   3651: aload 14
    //   3653: astore_2
    //   3654: ldc 191
    //   3656: iconst_1
    //   3657: aload 17
    //   3659: aload 16
    //   3661: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3664: aload_0
    //   3665: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   3668: invokevirtual 408	java/lang/Object:hashCode	()I
    //   3671: invokestatic 461	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   3674: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3677: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3680: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3683: goto -1653 -> 2030
    //   3686: astore 16
    //   3688: aload 15
    //   3690: astore 12
    //   3692: lload 6
    //   3694: lstore 4
    //   3696: aload 14
    //   3698: astore 11
    //   3700: aload 15
    //   3702: astore 13
    //   3704: aload 14
    //   3706: astore_2
    //   3707: ldc 191
    //   3709: iconst_1
    //   3710: ldc_w 868
    //   3713: aload 16
    //   3715: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3718: goto -1506 -> 2212
    //   3721: aload 15
    //   3723: astore 13
    //   3725: aload 11
    //   3727: astore_2
    //   3728: aload 15
    //   3730: ldc_w 870
    //   3733: invokevirtual 874	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3736: iconst_m1
    //   3737: if_icmple +32 -> 3769
    //   3740: aload 15
    //   3742: astore 13
    //   3744: aload 11
    //   3746: astore_2
    //   3747: getstatic 876	com/tencent/mobileqq/msf/core/net/x:g	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3750: astore 12
    //   3752: aload 15
    //   3754: astore 13
    //   3756: aload 12
    //   3758: astore_2
    //   3759: aload 12
    //   3761: invokevirtual 856	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   3764: astore 11
    //   3766: goto -523 -> 3243
    //   3769: aload 15
    //   3771: astore 13
    //   3773: aload 11
    //   3775: astore_2
    //   3776: aload 15
    //   3778: ldc_w 878
    //   3781: invokevirtual 874	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3784: iconst_m1
    //   3785: if_icmple +32 -> 3817
    //   3788: aload 15
    //   3790: astore 13
    //   3792: aload 11
    //   3794: astore_2
    //   3795: getstatic 880	com/tencent/mobileqq/msf/core/net/x:q	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3798: astore 12
    //   3800: aload 15
    //   3802: astore 13
    //   3804: aload 12
    //   3806: astore_2
    //   3807: aload 12
    //   3809: invokevirtual 856	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   3812: astore 11
    //   3814: goto -571 -> 3243
    //   3817: aload 15
    //   3819: astore 13
    //   3821: aload 11
    //   3823: astore_2
    //   3824: aload 15
    //   3826: ldc_w 882
    //   3829: invokevirtual 874	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3832: iconst_m1
    //   3833: if_icmple +46 -> 3879
    //   3836: aload 15
    //   3838: astore 13
    //   3840: aload 11
    //   3842: astore_2
    //   3843: getstatic 855	com/tencent/mobileqq/msf/core/net/x:m	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3846: astore 12
    //   3848: aload 15
    //   3850: astore 13
    //   3852: aload 12
    //   3854: astore_2
    //   3855: aload 12
    //   3857: invokevirtual 856	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   3860: astore 11
    //   3862: aload 11
    //   3864: astore 13
    //   3866: aload 12
    //   3868: astore_2
    //   3869: aload_3
    //   3870: invokestatic 859	com/tencent/mobileqq/msf/core/a/a:aE	()I
    //   3873: putfield 861	com/tencent/mobileqq/msf/core/net/a:h	I
    //   3876: goto -633 -> 3243
    //   3879: aload 15
    //   3881: astore 13
    //   3883: aload 11
    //   3885: astore_2
    //   3886: aload 15
    //   3888: ldc_w 884
    //   3891: invokevirtual 874	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3894: iconst_m1
    //   3895: if_icmple +32 -> 3927
    //   3898: aload 15
    //   3900: astore 13
    //   3902: aload 11
    //   3904: astore_2
    //   3905: getstatic 886	com/tencent/mobileqq/msf/core/net/x:i	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3908: astore 12
    //   3910: aload 15
    //   3912: astore 13
    //   3914: aload 12
    //   3916: astore_2
    //   3917: aload 12
    //   3919: invokevirtual 856	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   3922: astore 11
    //   3924: goto -681 -> 3243
    //   3927: aload 15
    //   3929: astore 13
    //   3931: aload 11
    //   3933: astore_2
    //   3934: aload 15
    //   3936: ldc_w 888
    //   3939: invokevirtual 874	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3942: iconst_m1
    //   3943: if_icmple +32 -> 3975
    //   3946: aload 15
    //   3948: astore 13
    //   3950: aload 11
    //   3952: astore_2
    //   3953: getstatic 890	com/tencent/mobileqq/msf/core/net/x:s	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3956: astore 12
    //   3958: aload 15
    //   3960: astore 13
    //   3962: aload 12
    //   3964: astore_2
    //   3965: aload 12
    //   3967: invokevirtual 856	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   3970: astore 11
    //   3972: goto -729 -> 3243
    //   3975: aload 15
    //   3977: astore 13
    //   3979: aload 11
    //   3981: astore_2
    //   3982: aload 15
    //   3984: ldc_w 892
    //   3987: invokevirtual 874	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3990: iconst_m1
    //   3991: if_icmple +32 -> 4023
    //   3994: aload 15
    //   3996: astore 13
    //   3998: aload 11
    //   4000: astore_2
    //   4001: getstatic 894	com/tencent/mobileqq/msf/core/net/x:r	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4004: astore 12
    //   4006: aload 15
    //   4008: astore 13
    //   4010: aload 12
    //   4012: astore_2
    //   4013: aload 12
    //   4015: invokevirtual 856	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4018: astore 11
    //   4020: goto -777 -> 3243
    //   4023: aload 15
    //   4025: astore 13
    //   4027: aload 11
    //   4029: astore_2
    //   4030: aload 15
    //   4032: ldc_w 896
    //   4035: invokevirtual 874	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4038: iconst_m1
    //   4039: if_icmpgt +22 -> 4061
    //   4042: aload 15
    //   4044: astore 13
    //   4046: aload 11
    //   4048: astore_2
    //   4049: aload 15
    //   4051: ldc_w 898
    //   4054: invokevirtual 874	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4057: iconst_m1
    //   4058: if_icmple +32 -> 4090
    //   4061: aload 15
    //   4063: astore 13
    //   4065: aload 11
    //   4067: astore_2
    //   4068: getstatic 900	com/tencent/mobileqq/msf/core/net/x:t	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4071: astore 12
    //   4073: aload 15
    //   4075: astore 13
    //   4077: aload 12
    //   4079: astore_2
    //   4080: aload 12
    //   4082: invokevirtual 856	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4085: astore 11
    //   4087: goto -844 -> 3243
    //   4090: aload 15
    //   4092: astore 13
    //   4094: aload 11
    //   4096: astore_2
    //   4097: aload 15
    //   4099: ldc_w 902
    //   4102: invokevirtual 874	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4105: iconst_m1
    //   4106: if_icmple +32 -> 4138
    //   4109: aload 15
    //   4111: astore 13
    //   4113: aload 11
    //   4115: astore_2
    //   4116: getstatic 904	com/tencent/mobileqq/msf/core/net/x:p	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4119: astore 12
    //   4121: aload 15
    //   4123: astore 13
    //   4125: aload 12
    //   4127: astore_2
    //   4128: aload 12
    //   4130: invokevirtual 856	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4133: astore 11
    //   4135: goto -892 -> 3243
    //   4138: aload 15
    //   4140: astore 13
    //   4142: aload 11
    //   4144: astore_2
    //   4145: aload 15
    //   4147: ldc_w 906
    //   4150: invokevirtual 874	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4153: iconst_m1
    //   4154: if_icmple +32 -> 4186
    //   4157: aload 15
    //   4159: astore 13
    //   4161: aload 11
    //   4163: astore_2
    //   4164: getstatic 908	com/tencent/mobileqq/msf/core/net/x:o	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4167: astore 12
    //   4169: aload 15
    //   4171: astore 13
    //   4173: aload 12
    //   4175: astore_2
    //   4176: aload 12
    //   4178: invokevirtual 856	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4181: astore 11
    //   4183: goto -940 -> 3243
    //   4186: aload 15
    //   4188: astore 13
    //   4190: aload 11
    //   4192: astore_2
    //   4193: aload 15
    //   4195: ldc_w 910
    //   4198: invokevirtual 874	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4201: iconst_m1
    //   4202: if_icmple +32 -> 4234
    //   4205: aload 15
    //   4207: astore 13
    //   4209: aload 11
    //   4211: astore_2
    //   4212: getstatic 912	com/tencent/mobileqq/msf/core/net/x:h	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4215: astore 12
    //   4217: aload 15
    //   4219: astore 13
    //   4221: aload 12
    //   4223: astore_2
    //   4224: aload 12
    //   4226: invokevirtual 856	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4229: astore 11
    //   4231: goto -988 -> 3243
    //   4234: aload 15
    //   4236: astore 13
    //   4238: aload 11
    //   4240: astore_2
    //   4241: aload 15
    //   4243: ldc_w 914
    //   4246: invokevirtual 874	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4249: iconst_m1
    //   4250: if_icmple +32 -> 4282
    //   4253: aload 15
    //   4255: astore 13
    //   4257: aload 11
    //   4259: astore_2
    //   4260: getstatic 916	com/tencent/mobileqq/msf/core/net/x:l	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4263: astore 12
    //   4265: aload 15
    //   4267: astore 13
    //   4269: aload 12
    //   4271: astore_2
    //   4272: aload 12
    //   4274: invokevirtual 856	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4277: astore 11
    //   4279: goto -1036 -> 3243
    //   4282: aload 15
    //   4284: astore 13
    //   4286: aload 11
    //   4288: astore_2
    //   4289: aload 15
    //   4291: ldc_w 918
    //   4294: invokevirtual 874	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4297: iconst_m1
    //   4298: if_icmple +32 -> 4330
    //   4301: aload 15
    //   4303: astore 13
    //   4305: aload 11
    //   4307: astore_2
    //   4308: getstatic 920	com/tencent/mobileqq/msf/core/net/x:j	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4311: astore 12
    //   4313: aload 15
    //   4315: astore 13
    //   4317: aload 12
    //   4319: astore_2
    //   4320: aload 12
    //   4322: invokevirtual 856	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4325: astore 11
    //   4327: goto -1084 -> 3243
    //   4330: aload 15
    //   4332: astore 13
    //   4334: aload 11
    //   4336: astore_2
    //   4337: aload 15
    //   4339: ldc_w 922
    //   4342: invokevirtual 874	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4345: iconst_m1
    //   4346: if_icmple +32 -> 4378
    //   4349: aload 15
    //   4351: astore 13
    //   4353: aload 11
    //   4355: astore_2
    //   4356: getstatic 900	com/tencent/mobileqq/msf/core/net/x:t	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4359: astore 12
    //   4361: aload 15
    //   4363: astore 13
    //   4365: aload 12
    //   4367: astore_2
    //   4368: aload 12
    //   4370: invokevirtual 856	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4373: astore 11
    //   4375: goto -1132 -> 3243
    //   4378: aload 15
    //   4380: astore 13
    //   4382: aload 11
    //   4384: astore_2
    //   4385: aload 15
    //   4387: ldc_w 924
    //   4390: invokevirtual 874	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4393: iconst_m1
    //   4394: if_icmple +32 -> 4426
    //   4397: aload 15
    //   4399: astore 13
    //   4401: aload 11
    //   4403: astore_2
    //   4404: getstatic 926	com/tencent/mobileqq/msf/core/net/x:n	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4407: astore 12
    //   4409: aload 15
    //   4411: astore 13
    //   4413: aload 12
    //   4415: astore_2
    //   4416: aload 12
    //   4418: invokevirtual 856	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   4421: astore 11
    //   4423: goto -1180 -> 3243
    //   4426: aload 15
    //   4428: astore 13
    //   4430: aload 11
    //   4432: astore_2
    //   4433: getstatic 928	com/tencent/mobileqq/msf/core/net/x:u	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4436: astore 14
    //   4438: aload 15
    //   4440: astore 13
    //   4442: aload 14
    //   4444: astore_2
    //   4445: aload 16
    //   4447: invokestatic 932	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4450: astore 15
    //   4452: aload 15
    //   4454: astore 11
    //   4456: aload 14
    //   4458: astore 12
    //   4460: aload 15
    //   4462: astore 13
    //   4464: aload 14
    //   4466: astore_2
    //   4467: aload 15
    //   4469: invokevirtual 933	java/lang/String:length	()I
    //   4472: sipush 200
    //   4475: if_icmple -1232 -> 3243
    //   4478: aload 15
    //   4480: astore 13
    //   4482: aload 14
    //   4484: astore_2
    //   4485: aload 15
    //   4487: iconst_0
    //   4488: sipush 200
    //   4491: invokevirtual 937	java/lang/String:substring	(II)Ljava/lang/String;
    //   4494: astore 11
    //   4496: aload 14
    //   4498: astore 12
    //   4500: goto -1257 -> 3243
    //   4503: ldc 191
    //   4505: iconst_1
    //   4506: ldc_w 939
    //   4509: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4512: goto -1877 -> 2635
    //   4515: astore_2
    //   4516: aload_2
    //   4517: invokevirtual 313	java/lang/Exception:printStackTrace	()V
    //   4520: ldc 191
    //   4522: iconst_1
    //   4523: ldc_w 941
    //   4526: aload_2
    //   4527: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4530: goto -1868 -> 2662
    //   4533: ldc 191
    //   4535: iconst_1
    //   4536: ldc_w 943
    //   4539: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4542: goto -1880 -> 2662
    //   4545: astore_2
    //   4546: ldc2_w 944
    //   4549: putstatic 832	com/tencent/mobileqq/msf/core/push/e:d	J
    //   4552: ldc 191
    //   4554: iconst_1
    //   4555: ldc_w 947
    //   4558: invokestatic 949	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4561: goto -1886 -> 2675
    //   4564: aload 12
    //   4566: getstatic 678	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   4569: if_acmpeq -1853 -> 2716
    //   4572: invokestatic 308	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   4575: getstatic 795	com/tencent/mobileqq/msf/core/ag:G	I
    //   4578: aload_0
    //   4579: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   4582: aload 12
    //   4584: invokevirtual 952	com/tencent/mobileqq/a/a/a:a	(IJLcom/tencent/mobileqq/msf/core/net/x;)V
    //   4587: new 193	java/lang/StringBuilder
    //   4590: dup
    //   4591: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   4594: ldc_w 954
    //   4597: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4600: aload_0
    //   4601: getfield 484	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   4604: invokevirtual 693	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4607: ldc_w 956
    //   4610: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4613: aload_3
    //   4614: getfield 776	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   4617: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4620: ldc_w 958
    //   4623: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4626: aload_0
    //   4627: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   4630: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4633: ldc_w 721
    //   4636: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4639: aload_1
    //   4640: invokevirtual 610	com/tencent/mobileqq/msf/core/d:g	()I
    //   4643: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4646: astore 11
    //   4648: aload_1
    //   4649: getfield 564	com/tencent/mobileqq/msf/core/d:g	Z
    //   4652: ifeq +90 -> 4742
    //   4655: ldc_w 566
    //   4658: astore_2
    //   4659: aload 11
    //   4661: aload_2
    //   4662: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4665: ldc_w 575
    //   4668: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4671: astore_2
    //   4672: aload_1
    //   4673: invokestatic 580	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   4676: ifeq +22 -> 4698
    //   4679: ldc_w 582
    //   4682: astore_1
    //   4683: ldc 191
    //   4685: iconst_1
    //   4686: aload_2
    //   4687: aload_1
    //   4688: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4691: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4694: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4697: return
    //   4698: ldc 156
    //   4700: astore_1
    //   4701: goto -18 -> 4683
    //   4704: ldc 156
    //   4706: astore 16
    //   4708: goto -4259 -> 449
    //   4711: ldc 156
    //   4713: astore 16
    //   4715: goto -1843 -> 2872
    //   4718: ldc_w 960
    //   4721: astore 16
    //   4723: goto -2741 -> 1982
    //   4726: ldc_w 844
    //   4729: astore 16
    //   4731: goto -1161 -> 3570
    //   4734: ldc_w 960
    //   4737: astore 16
    //   4739: goto -1104 -> 3635
    //   4742: ldc_w 844
    //   4745: astore_2
    //   4746: goto -87 -> 4659
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4749	0	this	m
    //   0	4749	1	paramd	com.tencent.mobileqq.msf.core.d
    //   0	4749	2	paramd1	d
    //   0	4749	3	parama	a
    //   156	3539	4	l1	long
    //   133	3560	6	l2	long
    //   128	3290	8	l3	long
    //   2104	3	10	bool	boolean
    //   160	4500	11	localObject1	Object
    //   152	4431	12	localObject2	Object
    //   164	4317	13	localObject3	Object
    //   98	4399	14	localObject4	Object
    //   102	4384	15	str1	String
    //   370	2527	16	localObject5	Object
    //   2923	258	16	localThrowable	java.lang.Throwable
    //   3338	322	16	str2	String
    //   3686	760	16	localException	Exception
    //   4706	32	16	str3	String
    //   239	3419	17	localStringBuilder1	StringBuilder
    //   339	2556	18	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   169	188	2923	java/lang/Throwable
    //   207	213	2923	java/lang/Throwable
    //   232	241	2923	java/lang/Throwable
    //   260	280	2923	java/lang/Throwable
    //   299	305	2923	java/lang/Throwable
    //   324	341	2923	java/lang/Throwable
    //   360	367	2923	java/lang/Throwable
    //   391	418	2923	java/lang/Throwable
    //   437	444	2923	java/lang/Throwable
    //   468	497	2923	java/lang/Throwable
    //   516	521	2923	java/lang/Throwable
    //   540	551	2923	java/lang/Throwable
    //   570	580	2923	java/lang/Throwable
    //   599	607	2923	java/lang/Throwable
    //   626	634	2923	java/lang/Throwable
    //   653	660	2923	java/lang/Throwable
    //   679	689	2923	java/lang/Throwable
    //   708	722	2923	java/lang/Throwable
    //   741	756	2923	java/lang/Throwable
    //   775	782	2923	java/lang/Throwable
    //   801	811	2923	java/lang/Throwable
    //   830	844	2923	java/lang/Throwable
    //   863	870	2923	java/lang/Throwable
    //   889	897	2923	java/lang/Throwable
    //   916	921	2923	java/lang/Throwable
    //   940	950	2923	java/lang/Throwable
    //   969	976	2923	java/lang/Throwable
    //   995	1006	2923	java/lang/Throwable
    //   1025	1037	2923	java/lang/Throwable
    //   1056	1071	2923	java/lang/Throwable
    //   1090	1108	2923	java/lang/Throwable
    //   1127	1136	2923	java/lang/Throwable
    //   1155	1160	2923	java/lang/Throwable
    //   1179	1186	2923	java/lang/Throwable
    //   1205	1213	2923	java/lang/Throwable
    //   1232	1240	2923	java/lang/Throwable
    //   1259	1270	2923	java/lang/Throwable
    //   1289	1305	2923	java/lang/Throwable
    //   1324	1338	2923	java/lang/Throwable
    //   1357	1379	2923	java/lang/Throwable
    //   1398	1405	2923	java/lang/Throwable
    //   1424	1434	2923	java/lang/Throwable
    //   1453	1465	2923	java/lang/Throwable
    //   1484	1494	2923	java/lang/Throwable
    //   1513	1520	2923	java/lang/Throwable
    //   1539	1547	2923	java/lang/Throwable
    //   1566	1571	2923	java/lang/Throwable
    //   1595	1598	2923	java/lang/Throwable
    //   1617	1624	2923	java/lang/Throwable
    //   1643	1682	2923	java/lang/Throwable
    //   1701	1707	2923	java/lang/Throwable
    //   1726	1730	2923	java/lang/Throwable
    //   1749	1761	2923	java/lang/Throwable
    //   1780	1786	2923	java/lang/Throwable
    //   1805	1886	2923	java/lang/Throwable
    //   1905	1912	2923	java/lang/Throwable
    //   1936	1951	2923	java/lang/Throwable
    //   1970	1977	2923	java/lang/Throwable
    //   2001	2030	2923	java/lang/Throwable
    //   2049	2057	2923	java/lang/Throwable
    //   2076	2082	2923	java/lang/Throwable
    //   2101	2106	2923	java/lang/Throwable
    //   2130	2139	2923	java/lang/Throwable
    //   2158	2171	2923	java/lang/Throwable
    //   2190	2212	2923	java/lang/Throwable
    //   2231	2241	2923	java/lang/Throwable
    //   2260	2273	2923	java/lang/Throwable
    //   2292	2310	2923	java/lang/Throwable
    //   2329	2343	2923	java/lang/Throwable
    //   2362	2376	2923	java/lang/Throwable
    //   2395	2404	2923	java/lang/Throwable
    //   2744	2764	2923	java/lang/Throwable
    //   2783	2790	2923	java/lang/Throwable
    //   2814	2841	2923	java/lang/Throwable
    //   2860	2867	2923	java/lang/Throwable
    //   2891	2920	2923	java/lang/Throwable
    //   3362	3369	2923	java/lang/Throwable
    //   3452	3539	2923	java/lang/Throwable
    //   3558	3565	2923	java/lang/Throwable
    //   3589	3604	2923	java/lang/Throwable
    //   3623	3630	2923	java/lang/Throwable
    //   3654	3683	2923	java/lang/Throwable
    //   3707	3718	2923	java/lang/Throwable
    //   109	150	3298	java/lang/InterruptedException
    //   2404	2434	3298	java/lang/InterruptedException
    //   2434	2457	3298	java/lang/InterruptedException
    //   2461	2489	3298	java/lang/InterruptedException
    //   2489	2502	3298	java/lang/InterruptedException
    //   2502	2595	3298	java/lang/InterruptedException
    //   2595	2635	3298	java/lang/InterruptedException
    //   2635	2662	3298	java/lang/InterruptedException
    //   2662	2675	3298	java/lang/InterruptedException
    //   2675	2716	3298	java/lang/InterruptedException
    //   3243	3273	3298	java/lang/InterruptedException
    //   3273	3295	3298	java/lang/InterruptedException
    //   3373	3402	3298	java/lang/InterruptedException
    //   3402	3425	3298	java/lang/InterruptedException
    //   4503	4512	3298	java/lang/InterruptedException
    //   4516	4530	3298	java/lang/InterruptedException
    //   4533	4542	3298	java/lang/InterruptedException
    //   4546	4561	3298	java/lang/InterruptedException
    //   4564	4655	3298	java/lang/InterruptedException
    //   4659	4679	3298	java/lang/InterruptedException
    //   4683	4697	3298	java/lang/InterruptedException
    //   169	188	3372	finally
    //   207	213	3372	finally
    //   232	241	3372	finally
    //   260	280	3372	finally
    //   299	305	3372	finally
    //   324	341	3372	finally
    //   360	367	3372	finally
    //   391	418	3372	finally
    //   437	444	3372	finally
    //   468	497	3372	finally
    //   516	521	3372	finally
    //   540	551	3372	finally
    //   570	580	3372	finally
    //   599	607	3372	finally
    //   626	634	3372	finally
    //   653	660	3372	finally
    //   679	689	3372	finally
    //   708	722	3372	finally
    //   741	756	3372	finally
    //   775	782	3372	finally
    //   801	811	3372	finally
    //   830	844	3372	finally
    //   863	870	3372	finally
    //   889	897	3372	finally
    //   916	921	3372	finally
    //   940	950	3372	finally
    //   969	976	3372	finally
    //   995	1006	3372	finally
    //   1025	1037	3372	finally
    //   1056	1071	3372	finally
    //   1090	1108	3372	finally
    //   1127	1136	3372	finally
    //   1155	1160	3372	finally
    //   1179	1186	3372	finally
    //   1205	1213	3372	finally
    //   1232	1240	3372	finally
    //   1259	1270	3372	finally
    //   1289	1305	3372	finally
    //   1324	1338	3372	finally
    //   1357	1379	3372	finally
    //   1398	1405	3372	finally
    //   1424	1434	3372	finally
    //   1453	1465	3372	finally
    //   1484	1494	3372	finally
    //   1513	1520	3372	finally
    //   1539	1547	3372	finally
    //   1566	1571	3372	finally
    //   1595	1598	3372	finally
    //   1617	1624	3372	finally
    //   1643	1682	3372	finally
    //   1701	1707	3372	finally
    //   1726	1730	3372	finally
    //   1749	1761	3372	finally
    //   1780	1786	3372	finally
    //   1805	1886	3372	finally
    //   1905	1912	3372	finally
    //   1936	1951	3372	finally
    //   1970	1977	3372	finally
    //   2001	2030	3372	finally
    //   2049	2057	3372	finally
    //   2076	2082	3372	finally
    //   2101	2106	3372	finally
    //   2130	2139	3372	finally
    //   2158	2171	3372	finally
    //   2190	2212	3372	finally
    //   2231	2241	3372	finally
    //   2260	2273	3372	finally
    //   2292	2310	3372	finally
    //   2329	2343	3372	finally
    //   2362	2376	3372	finally
    //   2395	2404	3372	finally
    //   2744	2764	3372	finally
    //   2783	2790	3372	finally
    //   2814	2841	3372	finally
    //   2860	2867	3372	finally
    //   2891	2920	3372	finally
    //   2932	2942	3372	finally
    //   2949	2961	3372	finally
    //   2968	2983	3372	finally
    //   2990	3000	3372	finally
    //   3007	3020	3372	finally
    //   3027	3045	3372	finally
    //   3052	3070	3372	finally
    //   3077	3093	3372	finally
    //   3100	3118	3372	finally
    //   3125	3141	3372	finally
    //   3148	3173	3372	finally
    //   3180	3190	3372	finally
    //   3197	3203	3372	finally
    //   3210	3215	3372	finally
    //   3222	3229	3372	finally
    //   3236	3243	3372	finally
    //   3362	3369	3372	finally
    //   3452	3539	3372	finally
    //   3558	3565	3372	finally
    //   3589	3604	3372	finally
    //   3623	3630	3372	finally
    //   3654	3683	3372	finally
    //   3707	3718	3372	finally
    //   3728	3740	3372	finally
    //   3747	3752	3372	finally
    //   3759	3766	3372	finally
    //   3776	3788	3372	finally
    //   3795	3800	3372	finally
    //   3807	3814	3372	finally
    //   3824	3836	3372	finally
    //   3843	3848	3372	finally
    //   3855	3862	3372	finally
    //   3869	3876	3372	finally
    //   3886	3898	3372	finally
    //   3905	3910	3372	finally
    //   3917	3924	3372	finally
    //   3934	3946	3372	finally
    //   3953	3958	3372	finally
    //   3965	3972	3372	finally
    //   3982	3994	3372	finally
    //   4001	4006	3372	finally
    //   4013	4020	3372	finally
    //   4030	4042	3372	finally
    //   4049	4061	3372	finally
    //   4068	4073	3372	finally
    //   4080	4087	3372	finally
    //   4097	4109	3372	finally
    //   4116	4121	3372	finally
    //   4128	4135	3372	finally
    //   4145	4157	3372	finally
    //   4164	4169	3372	finally
    //   4176	4183	3372	finally
    //   4193	4205	3372	finally
    //   4212	4217	3372	finally
    //   4224	4231	3372	finally
    //   4241	4253	3372	finally
    //   4260	4265	3372	finally
    //   4272	4279	3372	finally
    //   4289	4301	3372	finally
    //   4308	4313	3372	finally
    //   4320	4327	3372	finally
    //   4337	4349	3372	finally
    //   4356	4361	3372	finally
    //   4368	4375	3372	finally
    //   4385	4397	3372	finally
    //   4404	4409	3372	finally
    //   4416	4423	3372	finally
    //   4433	4438	3372	finally
    //   4445	4452	3372	finally
    //   4467	4478	3372	finally
    //   4485	4496	3372	finally
    //   2130	2139	3686	java/lang/Exception
    //   2158	2171	3686	java/lang/Exception
    //   2190	2212	3686	java/lang/Exception
    //   2595	2635	4515	java/lang/Exception
    //   2635	2662	4515	java/lang/Exception
    //   4503	4512	4515	java/lang/Exception
    //   4533	4542	4515	java/lang/Exception
    //   2662	2675	4545	java/lang/Exception
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
    //   14: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   17: iconst_0
    //   18: putfield 963	com/tencent/mobileqq/msf/core/ag:q	Z
    //   21: aload_0
    //   22: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   25: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   28: iconst_0
    //   29: putfield 358	com/tencent/mobileqq/msf/core/ag:r	Z
    //   32: aload_0
    //   33: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   36: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   39: lconst_0
    //   40: putfield 965	com/tencent/mobileqq/msf/core/ag:p	J
    //   43: aload_0
    //   44: getfield 484	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   47: ifnull +26 -> 73
    //   50: getstatic 967	com/tencent/mobileqq/msf/core/push/e:e	Z
    //   53: ifeq +20 -> 73
    //   56: aload_0
    //   57: getfield 484	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   60: invokevirtual 717	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   63: invokestatic 828	com/tencent/qphone/base/util/g:b	(Ljava/lang/String;)J
    //   66: putstatic 969	com/tencent/mobileqq/msf/core/push/e:c	J
    //   69: iconst_0
    //   70: putstatic 967	com/tencent/mobileqq/msf/core/push/e:e	Z
    //   73: ldc 191
    //   75: iconst_1
    //   76: iconst_2
    //   77: anewarray 4	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: invokestatic 975	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   85: invokevirtual 978	java/lang/Thread:getName	()Ljava/lang/String;
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: new 193	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 980
    //   101: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: invokevirtual 693	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: aastore
    //   112: invokestatic 849	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   115: aload_0
    //   116: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   119: astore 6
    //   121: getstatic 983	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   124: getfield 751	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   127: ifnull +90 -> 217
    //   130: aload_0
    //   131: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   134: astore 6
    //   136: getstatic 983	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   139: getfield 751	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   142: getfield 757	com/tencent/mobileqq/msf/core/c/k:X	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   145: ifnull +72 -> 217
    //   148: aload_0
    //   149: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   152: astore 6
    //   154: getstatic 983	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   157: getfield 751	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   160: getfield 757	com/tencent/mobileqq/msf/core/c/k:X	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   163: getfield 765	com/tencent/mobileqq/msf/core/c/k$c:g	J
    //   166: lconst_0
    //   167: lcmp
    //   168: ifne +49 -> 217
    //   171: aload_0
    //   172: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   175: astore 6
    //   177: getstatic 983	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   180: getfield 751	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/k;
    //   183: getfield 757	com/tencent/mobileqq/msf/core/c/k:X	Lcom/tencent/mobileqq/msf/core/c/k$c;
    //   186: invokestatic 529	java/lang/System:currentTimeMillis	()J
    //   189: putfield 765	com/tencent/mobileqq/msf/core/c/k$c:g	J
    //   192: ldc 191
    //   194: iconst_1
    //   195: iconst_2
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: ldc_w 985
    //   204: aastore
    //   205: dup
    //   206: iconst_1
    //   207: invokestatic 529	java/lang/System:currentTimeMillis	()J
    //   210: invokestatic 279	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   213: aastore
    //   214: invokestatic 849	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   217: aload_0
    //   218: getfield 255	com/tencent/mobileqq/msf/core/net/m:y	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   221: ifnull +22 -> 243
    //   224: aload_0
    //   225: invokevirtual 498	com/tencent/mobileqq/msf/core/net/m:h	()Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   228: pop
    //   229: aload_0
    //   230: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   233: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   236: aload_0
    //   237: getfield 500	com/tencent/mobileqq/msf/core/net/m:F	Ljava/lang/Runnable;
    //   240: invokevirtual 503	com/tencent/mobileqq/msf/core/ag:a	(Ljava/lang/Runnable;)V
    //   243: aload_0
    //   244: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   247: ifnonnull +61 -> 308
    //   250: ldc 191
    //   252: iconst_1
    //   253: new 193	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   260: ldc_w 987
    //   263: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_1
    //   267: invokevirtual 693	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: return
    //   277: astore 6
    //   279: ldc2_w 944
    //   282: putstatic 969	com/tencent/mobileqq/msf/core/push/e:c	J
    //   285: ldc 191
    //   287: iconst_1
    //   288: ldc_w 989
    //   291: invokestatic 949	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: iconst_0
    //   295: putstatic 967	com/tencent/mobileqq/msf/core/push/e:e	Z
    //   298: goto -225 -> 73
    //   301: astore_1
    //   302: iconst_0
    //   303: putstatic 967	com/tencent/mobileqq/msf/core/push/e:e	Z
    //   306: aload_1
    //   307: athrow
    //   308: invokestatic 992	com/tencent/mobileqq/msf/core/a/a:aI	()Z
    //   311: ifeq +550 -> 861
    //   314: getstatic 413	com/tencent/mobileqq/msf/core/ag:s	Z
    //   317: ifeq +49 -> 366
    //   320: invokestatic 417	com/tencent/mobileqq/msf/core/net/a/f:a	()Z
    //   323: ifeq +43 -> 366
    //   326: ldc 191
    //   328: iconst_1
    //   329: ldc_w 994
    //   332: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_0
    //   336: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   339: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   342: getfield 422	com/tencent/mobileqq/msf/core/ag:I	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   345: ifnull +21 -> 366
    //   348: aload_0
    //   349: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   352: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   355: getfield 422	com/tencent/mobileqq/msf/core/ag:I	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   358: invokevirtual 425	com/tencent/mobileqq/msf/core/net/a/f:b	()Lcom/tencent/mobileqq/msf/core/net/a/e;
    //   361: invokeinterface 995 1 0
    //   366: iconst_1
    //   367: istore_3
    //   368: invokestatic 996	com/tencent/mobileqq/a/a/f:a	()V
    //   371: invokestatic 308	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   374: aload_1
    //   375: invokevirtual 998	com/tencent/mobileqq/a/a/a:a	(Lcom/tencent/qphone/base/a;)V
    //   378: invokestatic 1003	com/tencent/mobileqq/a/a/a$b:a	()Lcom/tencent/mobileqq/a/a/a$b;
    //   381: aload_1
    //   382: invokevirtual 1004	com/tencent/mobileqq/a/a/a$b:a	(Lcom/tencent/qphone/base/a;)V
    //   385: invokestatic 1007	com/tencent/mobileqq/msf/core/a/a:aH	()Z
    //   388: ifeq +6 -> 394
    //   391: invokestatic 1010	com/tencent/mobileqq/a/a/d:a	()V
    //   394: aload_0
    //   395: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   398: invokevirtual 1011	com/tencent/mobileqq/msf/core/net/h:toString	()Ljava/lang/String;
    //   401: astore 6
    //   403: aload_0
    //   404: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   407: ldc2_w 513
    //   410: getstatic 520	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   413: invokevirtual 524	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   416: istore_2
    //   417: iload_2
    //   418: ifeq +513 -> 931
    //   421: aload_0
    //   422: getfield 95	com/tencent/mobileqq/msf/core/net/m:s	Ljava/util/concurrent/atomic/AtomicInteger;
    //   425: iconst_0
    //   426: invokevirtual 738	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   429: aload_0
    //   430: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   433: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   436: aconst_null
    //   437: invokevirtual 797	com/tencent/mobileqq/msf/core/ag:a	([B)V
    //   440: aload_0
    //   441: getfield 100	com/tencent/mobileqq/msf/core/net/m:v	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   444: invokevirtual 337	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   447: istore_2
    //   448: aload_0
    //   449: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   452: ifnull +14 -> 466
    //   455: aload_0
    //   456: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   459: getfield 1013	com/tencent/mobileqq/msf/core/net/m$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   462: iconst_0
    //   463: invokevirtual 493	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   466: aload_0
    //   467: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   470: invokevirtual 1017	com/tencent/mobileqq/msf/core/net/h:getInputStream	()Ljava/io/InputStream;
    //   473: ifnull +13 -> 486
    //   476: aload_0
    //   477: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   480: invokevirtual 1017	com/tencent/mobileqq/msf/core/net/h:getInputStream	()Ljava/io/InputStream;
    //   483: invokevirtual 1022	java/io/InputStream:close	()V
    //   486: aload_0
    //   487: getfield 76	com/tencent/mobileqq/msf/core/net/m:h	Ljava/io/OutputStream;
    //   490: astore 7
    //   492: aload 7
    //   494: ifnull +24 -> 518
    //   497: getstatic 69	com/tencent/mobileqq/msf/core/net/m:q	Ljava/util/ArrayList;
    //   500: aload_0
    //   501: getfield 76	com/tencent/mobileqq/msf/core/net/m:h	Ljava/io/OutputStream;
    //   504: invokevirtual 645	java/lang/Object:toString	()Ljava/lang/String;
    //   507: invokevirtual 1024	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   510: pop
    //   511: aload_0
    //   512: getfield 76	com/tencent/mobileqq/msf/core/net/m:h	Ljava/io/OutputStream;
    //   515: invokevirtual 1025	java/io/OutputStream:close	()V
    //   518: aload_0
    //   519: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   522: astore 7
    //   524: aload 7
    //   526: ifnull +30 -> 556
    //   529: aload_0
    //   530: getfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   533: invokevirtual 1026	com/tencent/mobileqq/msf/core/net/h:close	()V
    //   536: aload_1
    //   537: invokestatic 1029	com/tencent/mobileqq/msf/core/ak:a	(Lcom/tencent/qphone/base/a;)V
    //   540: aload_0
    //   541: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   544: invokevirtual 1033	com/tencent/mobileqq/msf/core/MsfCore:getStandyModeManager	()Lcom/tencent/mobileqq/msf/core/d/a;
    //   547: invokevirtual 1036	com/tencent/mobileqq/msf/core/d/a:f	()V
    //   550: getstatic 69	com/tencent/mobileqq/msf/core/net/m:q	Ljava/util/ArrayList;
    //   553: invokevirtual 806	java/util/ArrayList:clear	()V
    //   556: aload_0
    //   557: aconst_null
    //   558: putfield 405	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   561: aload_0
    //   562: getfield 100	com/tencent/mobileqq/msf/core/net/m:v	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   565: iconst_0
    //   566: invokevirtual 493	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   569: aload_0
    //   570: aconst_null
    //   571: putfield 339	com/tencent/mobileqq/msf/core/net/m:i	Lcom/tencent/mobileqq/msf/core/net/d;
    //   574: aload_0
    //   575: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   578: invokevirtual 770	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   581: aload_0
    //   582: getfield 102	com/tencent/mobileqq/msf/core/net/m:w	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   585: invokevirtual 337	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   588: ifne -312 -> 276
    //   591: iload_2
    //   592: ifeq -316 -> 276
    //   595: aload_0
    //   596: getfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   599: lconst_0
    //   600: lcmp
    //   601: ifle +120 -> 721
    //   604: invokestatic 529	java/lang/System:currentTimeMillis	()J
    //   607: aload_0
    //   608: getfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   611: lsub
    //   612: lstore 4
    //   614: aload_0
    //   615: lconst_0
    //   616: putfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   619: aload_0
    //   620: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   623: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   626: invokevirtual 1038	com/tencent/mobileqq/msf/core/ag:e	()[B
    //   629: invokestatic 1044	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   632: astore 7
    //   634: invokestatic 1047	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getCurrentAPN	()Ljava/lang/String;
    //   637: astore 8
    //   639: aload_0
    //   640: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   643: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   646: getfield 628	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   649: invokevirtual 1049	com/tencent/mobileqq/msf/core/net/n:g	()V
    //   652: aload_0
    //   653: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   656: getfield 259	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ag;
    //   659: getfield 628	com/tencent/mobileqq/msf/core/ag:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   662: lconst_0
    //   663: putfield 1051	com/tencent/mobileqq/msf/core/net/n:m	J
    //   666: aload_0
    //   667: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   670: invokevirtual 747	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   673: ifnull +48 -> 721
    //   676: aload_0
    //   677: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   680: invokevirtual 747	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/k;
    //   683: iconst_0
    //   684: lload 4
    //   686: ldc2_w 1052
    //   689: ldiv
    //   690: aload_0
    //   691: getfield 344	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   694: aload_1
    //   695: getstatic 706	com/tencent/mobileqq/msf/core/ag:H	I
    //   698: lload 4
    //   700: aload_0
    //   701: getfield 121	com/tencent/mobileqq/msf/core/net/m:C	Ljava/util/concurrent/atomic/AtomicLong;
    //   704: invokevirtual 1055	java/util/concurrent/atomic/AtomicLong:get	()J
    //   707: aload_0
    //   708: getfield 123	com/tencent/mobileqq/msf/core/net/m:D	Ljava/util/concurrent/atomic/AtomicLong;
    //   711: invokevirtual 1055	java/util/concurrent/atomic/AtomicLong:get	()J
    //   714: aload 7
    //   716: aload 8
    //   718: invokevirtual 1058	com/tencent/mobileqq/msf/core/c/k:a	(ZJLcom/tencent/mobileqq/msf/core/d;Lcom/tencent/qphone/base/a;IJJJLjava/lang/String;Ljava/lang/String;)V
    //   721: invokestatic 437	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   724: ifeq +275 -> 999
    //   727: ldc 191
    //   729: iconst_1
    //   730: new 193	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   737: ldc_w 1060
    //   740: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload 6
    //   745: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: ldc_w 1062
    //   751: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: aload_1
    //   755: invokevirtual 693	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   758: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   764: aload_0
    //   765: getfield 344	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   768: ifnull +28 -> 796
    //   771: aload_0
    //   772: getfield 344	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   775: aload_1
    //   776: invokevirtual 1065	com/tencent/mobileqq/msf/core/d:a	(Lcom/tencent/qphone/base/a;)Z
    //   779: ifeq +17 -> 796
    //   782: aload_0
    //   783: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   786: invokevirtual 1069	com/tencent/mobileqq/msf/core/MsfCore:getSsoListManager	()Lcom/tencent/mobileqq/msf/core/a/c;
    //   789: aload_0
    //   790: getfield 344	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   793: invokevirtual 1074	com/tencent/mobileqq/msf/core/a/c:a	(Lcom/tencent/mobileqq/msf/core/d;)V
    //   796: ldc_w 734
    //   799: putstatic 686	com/tencent/mobileqq/msf/core/ag:E	Ljava/lang/String;
    //   802: ldc 156
    //   804: putstatic 700	com/tencent/mobileqq/msf/core/ag:F	Ljava/lang/String;
    //   807: aload_0
    //   808: aconst_null
    //   809: putfield 344	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   812: aload_0
    //   813: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   816: aconst_null
    //   817: putfield 809	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   820: aload_0
    //   821: getfield 121	com/tencent/mobileqq/msf/core/net/m:C	Ljava/util/concurrent/atomic/AtomicLong;
    //   824: lconst_0
    //   825: invokevirtual 640	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   828: aload_0
    //   829: getfield 123	com/tencent/mobileqq/msf/core/net/m:D	Ljava/util/concurrent/atomic/AtomicLong;
    //   832: lconst_0
    //   833: invokevirtual 640	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   836: invokestatic 1079	com/tencent/qphone/base/util/CodecWarpper:nativeOnConnClose	()V
    //   839: aload_1
    //   840: invokestatic 1082	com/tencent/mobileqq/msf/core/NetConnInfoCenter:onConnClosed	(Lcom/tencent/qphone/base/a;)V
    //   843: return
    //   844: astore 6
    //   846: getstatic 1086	com/tencent/mobileqq/msf/core/net/a/a:a	Ljava/lang/String;
    //   849: iconst_1
    //   850: ldc_w 1088
    //   853: aload 6
    //   855: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   858: goto -492 -> 366
    //   861: iconst_0
    //   862: putstatic 413	com/tencent/mobileqq/msf/core/ag:s	Z
    //   865: goto -499 -> 366
    //   868: astore 7
    //   870: aload 7
    //   872: invokevirtual 1089	java/lang/Throwable:printStackTrace	()V
    //   875: goto -325 -> 550
    //   878: astore 7
    //   880: goto -324 -> 556
    //   883: astore 7
    //   885: iconst_1
    //   886: istore_2
    //   887: aload_0
    //   888: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   891: invokevirtual 770	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   894: aload 7
    //   896: athrow
    //   897: astore 7
    //   899: ldc 191
    //   901: iconst_1
    //   902: new 193	java/lang/StringBuilder
    //   905: dup
    //   906: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   909: ldc_w 1091
    //   912: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: aload 7
    //   917: invokevirtual 693	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   920: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   923: aload 7
    //   925: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   928: goto -347 -> 581
    //   931: aload_0
    //   932: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   935: ifnull +14 -> 949
    //   938: aload_0
    //   939: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   942: getfield 1013	com/tencent/mobileqq/msf/core/net/m$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   945: iconst_0
    //   946: invokevirtual 493	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   949: ldc 191
    //   951: iconst_1
    //   952: ldc_w 1093
    //   955: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   958: aload_0
    //   959: getfield 102	com/tencent/mobileqq/msf/core/net/m:w	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   962: iconst_1
    //   963: invokevirtual 493	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   966: iload_3
    //   967: istore_2
    //   968: aload_0
    //   969: getfield 95	com/tencent/mobileqq/msf/core/net/m:s	Ljava/util/concurrent/atomic/AtomicInteger;
    //   972: iconst_1
    //   973: invokevirtual 1096	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   976: bipush 10
    //   978: if_icmpne -397 -> 581
    //   981: invokestatic 1101	android/os/Process:myPid	()I
    //   984: invokestatic 1104	android/os/Process:killProcess	(I)V
    //   987: iload_3
    //   988: istore_2
    //   989: goto -408 -> 581
    //   992: astore 7
    //   994: iconst_1
    //   995: istore_2
    //   996: goto -97 -> 899
    //   999: ldc 191
    //   1001: iconst_1
    //   1002: new 193	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   1009: ldc_w 1060
    //   1012: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: aload 6
    //   1017: invokestatic 481	com/tencent/mobileqq/msf/core/b/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1020: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: ldc_w 1062
    //   1026: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: aload_1
    //   1030: invokevirtual 693	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1033: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1036: invokestatic 223	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1039: goto -275 -> 764
    //   1042: astore 6
    //   1044: aload 6
    //   1046: invokevirtual 313	java/lang/Exception:printStackTrace	()V
    //   1049: goto -242 -> 807
    //   1052: astore 6
    //   1054: ldc 191
    //   1056: iconst_1
    //   1057: new 193	java/lang/StringBuilder
    //   1060: dup
    //   1061: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   1064: ldc_w 1106
    //   1067: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: aload 6
    //   1072: invokevirtual 693	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1075: invokevirtual 218	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1078: aload 6
    //   1080: invokestatic 318	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    if (this.g != null) {
      l1 = this.g.a();
    }
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.m
 * JD-Core Version:    0.7.0.1
 */