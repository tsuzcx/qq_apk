package com.tencent.mobileqq.msf.core.net;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ad;
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
    String str1 = "MSF";
    for (;;)
    {
      try
      {
        localToServiceMsg = new ToServiceMsg("", "0", "MSF");
        localToServiceMsg.setRequestSsoSeq(MsfCore.getNextSeq());
        localToServiceMsg.setMsfCommand(MsfCommand.msf_ssoping);
        long l1 = com.tencent.mobileqq.msf.core.a.a.u();
        if (l1 > 10000L) {
          localToServiceMsg.setTimeout(l1);
        } else {
          localToServiceMsg.setTimeout(10000L);
        }
      }
      catch (Exception localException)
      {
        ToServiceMsg localToServiceMsg;
        Object localObject;
        int i1;
        byte b1;
        localException.printStackTrace();
        QLog.d("MSF.C.NetConnTag", 1, "send SSOPing pkg fail, exception ", localException);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ssoping cmd:");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(" seq: ");
      ((StringBuilder)localObject).append(localToServiceMsg.getRequestSsoSeq());
      ((StringBuilder)localObject).append(" timeout: ");
      ((StringBuilder)localObject).append(localToServiceMsg.getTimeout());
      QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject).toString());
      i1 = str1.getBytes().length + 13 + 1 + 0 + 4;
      b1 = (byte)(str1.getBytes().length + 1);
      localObject = ByteBuffer.allocate(i1);
      ((ByteBuffer)localObject).putInt(i1).putInt(20140601).putInt(0).put(b1).put(str1.getBytes()).put((byte)5).putInt(0);
      localToServiceMsg.putWupBuffer(((ByteBuffer)localObject).array());
      this.y = localToServiceMsg;
      this.r.sender.c(localToServiceMsg);
      localToServiceMsg.getAttributes().put("__timestamp_msf2net", Long.valueOf(SystemClock.elapsedRealtime()));
      if (a(this.r.getMsfAppid(), 0, localToServiceMsg.getRequestSsoSeq(), localToServiceMsg.getUin(), localToServiceMsg.getServiceCmd(), "", localToServiceMsg.getMsfCommand(), localToServiceMsg.getWupBuffer(), null) > 0)
      {
        com.tencent.mobileqq.a.a.a.a().a(localToServiceMsg);
        return;
      }
      this.r.sender.c(localToServiceMsg.getRequestSsoSeq());
      this.r.sender.d(localToServiceMsg);
      QLog.d("MSF.C.NetConnTag", 1, "send SSOPing pkg fail");
      b(com.tencent.qphone.base.a.C);
      return;
      if (paramBoolean) {
        String str2 = "GWv4";
      }
    }
  }
  
  private void m()
  {
    MsfCore localMsfCore = this.r;
    if ((localMsfCore != null) && (localMsfCore.pushManager != null) && (this.r.pushManager.at != null))
    {
      localMsfCore = this.r;
      localMsfCore.sendSsoMsg(localMsfCore.pushManager.at);
      this.r.pushManager.at = null;
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, MsfCommand paramMsfCommand, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg)
  {
    if ((!this.w.get()) && (this.v.get()) && (this.i != null))
    {
      if (paramMsfCommand != MsfCommand.openConn)
      {
        paramString3 = this.i.a(this.d, paramString1, paramString2, paramArrayOfByte);
        if (paramString2.equals("SSO.LoginMerge"))
        {
          if (!this.r.sender.r)
          {
            paramString1 = (ArrayList)this.r.sender.e.remove(Integer.valueOf(paramInt3));
            paramString2 = new StringBuilder();
            paramString2.append("NetChanged devide merge package, ");
            paramString2.append(Arrays.toString(paramString1.toArray()));
            paramString2.append(" resend.");
            QLog.d("MSF.C.NetConnTag", 1, paramString2.toString());
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
        }
        else if (paramString2.equals("RegPrxySvc.infoLogin"))
        {
          this.r.sender.a(paramToServiceMsg, this.g.hashCode());
        }
        else if (paramString2.equals("RegPrxySvc.getOffMsg"))
        {
          this.r.sender.a(paramToServiceMsg, this.g.hashCode());
        }
        else if (paramString2.equals("RegPrxySvc.infoSync"))
        {
          this.r.sender.a(paramToServiceMsg, this.g.hashCode());
        }
        if ((ad.s) && (f.a()))
        {
          QLog.d("MSF.C.NetConnTag", 1, "send data in socket adaptor way");
          try
          {
            if (this.r.sender.I == null) {
              break label447;
            }
            this.r.sender.I.b().a(paramString3, this.g, paramInt3);
          }
          catch (Exception paramMsfCommand)
          {
            QLog.d("MSF.C.NetConnTag", 1, "", paramMsfCommand);
          }
        }
        else
        {
          this.h.write(paramString3);
          this.h.flush();
        }
        label447:
        this.C.addAndGet(paramString3.length);
        paramString3 = new StringBuilder();
        if (QLog.isDevelopLevel())
        {
          paramString3.append("netSend appid:");
          paramString3.append(paramInt1);
          paramString3.append(" appSeq:");
          paramString3.append(paramInt2);
          paramString3.append(" ssoSeq:");
          paramString3.append(paramInt3);
          paramString3.append(" uin:");
          paramString3.append(MsfSdkUtils.getShortUin(paramString1));
          paramString3.append(" cmd:");
          paramString3.append(paramString2);
          paramString3.append(" len:");
          paramString3.append(paramArrayOfByte.length);
          paramString1 = new StringBuilder();
          paramString1.append(" ");
          paramString1.append(Integer.toHexString(this.g.hashCode()));
          paramString3.append(paramString1.toString());
          QLog.d("MSF.C.NetConnTag", 1, paramString3.toString());
        }
        else
        {
          paramString3.append("netSend ssoSeq:");
          paramString3.append(paramInt3);
          paramString3.append(" uin:");
          paramString3.append(MsfSdkUtils.getShortUin(paramString1));
          paramString3.append(" cmd:");
          paramString3.append(com.tencent.mobileqq.msf.core.b.a.a(paramString2));
          paramString1 = new StringBuilder();
          paramString1.append(" ");
          paramString1.append(paramInt3 + paramArrayOfByte.length);
          paramString3.append(paramString1.toString());
          paramString1 = new StringBuilder();
          paramString1.append(" ");
          paramString1.append(Integer.toHexString(this.g.hashCode()));
          paramString3.append(paramString1.toString());
          QLog.d("MSF.C.NetConnTag", 1, paramString3.toString());
        }
      }
      return paramArrayOfByte.length;
    }
    return -100;
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
    //   42: invokevirtual 315	com/tencent/mobileqq/msf/core/net/m:b	(Lcom/tencent/qphone/base/a;)V
    //   45: aload_0
    //   46: getfield 245	com/tencent/mobileqq/msf/core/net/m:y	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   49: ifnull +22 -> 71
    //   52: aload_0
    //   53: invokevirtual 502	com/tencent/mobileqq/msf/core/net/m:h	()Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   56: pop
    //   57: aload_0
    //   58: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   61: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   64: aload_0
    //   65: getfield 504	com/tencent/mobileqq/msf/core/net/m:F	Ljava/lang/Runnable;
    //   68: invokevirtual 507	com/tencent/mobileqq/msf/core/ad:a	(Ljava/lang/Runnable;)V
    //   71: aload_0
    //   72: aload_1
    //   73: putfield 349	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   76: aload_0
    //   77: aload_2
    //   78: putfield 344	com/tencent/mobileqq/msf/core/net/m:i	Lcom/tencent/mobileqq/msf/core/net/d;
    //   81: aload_0
    //   82: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   85: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   88: aload_1
    //   89: invokevirtual 511	com/tencent/mobileqq/msf/core/d:j	()Z
    //   92: putfield 363	com/tencent/mobileqq/msf/core/ad:r	Z
    //   95: getstatic 516	com/tencent/mobileqq/msf/core/net/x:b	Lcom/tencent/mobileqq/msf/core/net/x;
    //   98: astore_2
    //   99: aload_0
    //   100: lconst_0
    //   101: putfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   104: aload_0
    //   105: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   108: ldc2_w 517
    //   111: getstatic 524	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   114: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   117: ifeq +3662 -> 3779
    //   120: invokestatic 263	android/os/SystemClock:elapsedRealtime	()J
    //   123: lstore 8
    //   125: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   128: lstore 4
    //   130: aload_0
    //   131: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   134: putfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   137: invokestatic 538	com/tencent/mobileqq/a/a/a$c:a	()Lcom/tencent/mobileqq/a/a/a$c;
    //   140: iconst_0
    //   141: aload_1
    //   142: invokevirtual 541	com/tencent/mobileqq/a/a/a$c:a	(ZLcom/tencent/mobileqq/msf/core/d;)V
    //   145: aload_1
    //   146: invokevirtual 543	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   149: astore 13
    //   151: aload_0
    //   152: new 545	java/net/InetSocketAddress
    //   155: dup
    //   156: aload 13
    //   158: aload_1
    //   159: invokevirtual 547	com/tencent/mobileqq/msf/core/d:f	()I
    //   162: invokespecial 550	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   165: putfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   168: invokestatic 298	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   171: invokevirtual 552	com/tencent/mobileqq/a/a/a:c	()V
    //   174: new 179	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   181: astore 18
    //   183: ldc_w 554
    //   186: astore 16
    //   188: ldc_w 556
    //   191: iconst_1
    //   192: anewarray 4	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload_1
    //   198: invokevirtual 557	com/tencent/mobileqq/msf/core/d:toString	()Ljava/lang/String;
    //   201: aastore
    //   202: invokestatic 561	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   205: invokestatic 566	com/tencent/mobileqq/msf/core/al:a	(Ljava/lang/String;)V
    //   208: invokestatic 456	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   211: istore 12
    //   213: ldc_w 568
    //   216: astore 13
    //   218: iload 12
    //   220: ifeq +195 -> 415
    //   223: lload 4
    //   225: lstore 6
    //   227: aload 18
    //   229: ldc_w 570
    //   232: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: lload 4
    //   238: lstore 6
    //   240: aload 18
    //   242: aload_1
    //   243: invokevirtual 557	com/tencent/mobileqq/msf/core/d:toString	()Ljava/lang/String;
    //   246: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: lload 4
    //   252: lstore 6
    //   254: aload_1
    //   255: getfield 572	com/tencent/mobileqq/msf/core/d:g	Z
    //   258: ifeq +3530 -> 3788
    //   261: aload 16
    //   263: astore 14
    //   265: goto +3 -> 268
    //   268: lload 4
    //   270: lstore 6
    //   272: aload 18
    //   274: aload 14
    //   276: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: lload 4
    //   282: lstore 6
    //   284: aload 18
    //   286: ldc_w 574
    //   289: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: lload 4
    //   295: lstore 6
    //   297: aload 18
    //   299: invokestatic 579	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   302: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: lload 4
    //   308: lstore 6
    //   310: aload 18
    //   312: ldc_w 581
    //   315: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: lload 4
    //   321: lstore 6
    //   323: aload_1
    //   324: invokestatic 586	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   327: ifeq +3469 -> 3796
    //   330: goto +3 -> 333
    //   333: lload 4
    //   335: lstore 6
    //   337: aload 18
    //   339: aload 13
    //   341: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: lload 4
    //   347: lstore 6
    //   349: aload 18
    //   351: ldc_w 588
    //   354: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: lload 4
    //   360: lstore 6
    //   362: aload 18
    //   364: aload_1
    //   365: invokevirtual 590	com/tencent/mobileqq/msf/core/d:b	()Ljava/lang/String;
    //   368: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: lload 4
    //   374: lstore 6
    //   376: ldc 204
    //   378: iconst_1
    //   379: aload 18
    //   381: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: goto +195 -> 582
    //   390: astore_1
    //   391: goto +1696 -> 2087
    //   394: astore 14
    //   396: lload 6
    //   398: lstore 4
    //   400: ldc 82
    //   402: astore 13
    //   404: aload 14
    //   406: astore 15
    //   408: aload 15
    //   410: astore 16
    //   412: goto +1725 -> 2137
    //   415: lload 4
    //   417: lstore 6
    //   419: aload 18
    //   421: ldc_w 570
    //   424: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: lload 4
    //   430: lstore 6
    //   432: aload 18
    //   434: aload_1
    //   435: invokevirtual 557	com/tencent/mobileqq/msf/core/d:toString	()Ljava/lang/String;
    //   438: invokestatic 486	com/tencent/mobileqq/msf/core/b/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   441: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: lload 4
    //   447: lstore 6
    //   449: aload_1
    //   450: getfield 572	com/tencent/mobileqq/msf/core/d:g	Z
    //   453: ifeq +3350 -> 3803
    //   456: aload 16
    //   458: astore 14
    //   460: goto +3 -> 463
    //   463: lload 4
    //   465: lstore 6
    //   467: aload 18
    //   469: aload 14
    //   471: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: lload 4
    //   477: lstore 6
    //   479: aload 18
    //   481: ldc_w 574
    //   484: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: lload 4
    //   490: lstore 6
    //   492: aload 18
    //   494: invokestatic 579	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   497: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: lload 4
    //   503: lstore 6
    //   505: aload 18
    //   507: ldc_w 581
    //   510: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: lload 4
    //   516: lstore 6
    //   518: aload_1
    //   519: invokestatic 586	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   522: ifeq +3289 -> 3811
    //   525: goto +3 -> 528
    //   528: lload 4
    //   530: lstore 6
    //   532: aload 18
    //   534: aload 13
    //   536: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: lload 4
    //   542: lstore 6
    //   544: aload 18
    //   546: ldc_w 588
    //   549: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: lload 4
    //   555: lstore 6
    //   557: aload 18
    //   559: aload_1
    //   560: invokevirtual 590	com/tencent/mobileqq/msf/core/d:b	()Ljava/lang/String;
    //   563: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: lload 4
    //   569: lstore 6
    //   571: ldc 204
    //   573: iconst_1
    //   574: aload 18
    //   576: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: lload 4
    //   584: lstore 6
    //   586: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   589: lstore 4
    //   591: lload 4
    //   593: lstore 6
    //   595: aload_0
    //   596: new 592	com/tencent/mobileqq/msf/core/net/h
    //   599: dup
    //   600: invokespecial 593	com/tencent/mobileqq/msf/core/net/h:<init>	()V
    //   603: putfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   606: lload 4
    //   608: lstore 6
    //   610: aload_0
    //   611: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   614: sipush 10000
    //   617: invokevirtual 596	com/tencent/mobileqq/msf/core/net/h:setSoTimeout	(I)V
    //   620: lload 4
    //   622: lstore 6
    //   624: aload_0
    //   625: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   628: iconst_1
    //   629: invokevirtual 599	com/tencent/mobileqq/msf/core/net/h:setTcpNoDelay	(Z)V
    //   632: lload 4
    //   634: lstore 6
    //   636: aload_0
    //   637: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   640: iconst_1
    //   641: invokevirtual 602	com/tencent/mobileqq/msf/core/net/h:setKeepAlive	(Z)V
    //   644: lload 4
    //   646: lstore 6
    //   648: aload_0
    //   649: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   652: astore 13
    //   654: aload 13
    //   656: ifnull +35 -> 691
    //   659: lload 4
    //   661: lstore 6
    //   663: aload_0
    //   664: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   667: getfield 606	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   670: ifnull +21 -> 691
    //   673: lload 4
    //   675: lstore 6
    //   677: aload_0
    //   678: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   681: getfield 606	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   684: iconst_1
    //   685: invokeinterface 612 2 0
    //   690: pop
    //   691: lload 4
    //   693: lstore 6
    //   695: aload_0
    //   696: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   699: aload_0
    //   700: getfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   703: aload_1
    //   704: invokevirtual 614	com/tencent/mobileqq/msf/core/d:g	()I
    //   707: invokevirtual 618	com/tencent/mobileqq/msf/core/net/h:connect	(Ljava/net/SocketAddress;I)V
    //   710: lload 4
    //   712: lstore 6
    //   714: aload_0
    //   715: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   718: astore 13
    //   720: aload 13
    //   722: ifnull +35 -> 757
    //   725: lload 4
    //   727: lstore 6
    //   729: aload_0
    //   730: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   733: getfield 606	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   736: ifnull +21 -> 757
    //   739: lload 4
    //   741: lstore 6
    //   743: aload_0
    //   744: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   747: getfield 606	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   750: iconst_1
    //   751: invokeinterface 621 2 0
    //   756: pop
    //   757: lload 4
    //   759: lstore 6
    //   761: aload_0
    //   762: invokestatic 579	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   765: putfield 88	com/tencent/mobileqq/msf/core/net/m:n	I
    //   768: lload 4
    //   770: lstore 6
    //   772: aload_0
    //   773: aload_1
    //   774: invokevirtual 623	com/tencent/mobileqq/msf/core/d:d	()I
    //   777: putfield 90	com/tencent/mobileqq/msf/core/net/m:o	I
    //   780: lload 4
    //   782: lstore 6
    //   784: aload_3
    //   785: iconst_1
    //   786: putfield 627	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   789: lload 4
    //   791: lstore 6
    //   793: aload_3
    //   794: aload_3
    //   795: getfield 629	com/tencent/mobileqq/msf/core/net/a:j	I
    //   798: iconst_1
    //   799: iadd
    //   800: putfield 629	com/tencent/mobileqq/msf/core/net/a:j	I
    //   803: lload 4
    //   805: lstore 6
    //   807: aload_0
    //   808: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   811: putfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   814: lload 4
    //   816: lstore 6
    //   818: aload_0
    //   819: aload_0
    //   820: getfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   823: lload 4
    //   825: lsub
    //   826: putfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   829: lload 4
    //   831: lstore 6
    //   833: aload_0
    //   834: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   837: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   840: getfield 632	com/tencent/mobileqq/msf/core/ad:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   843: astore 13
    //   845: lload 4
    //   847: lstore 6
    //   849: aload 13
    //   851: getfield 636	com/tencent/mobileqq/msf/core/net/n:l	J
    //   854: lstore 10
    //   856: ldc_w 638
    //   859: astore 17
    //   861: aload 13
    //   863: lload 10
    //   865: aload_0
    //   866: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   869: ladd
    //   870: putfield 636	com/tencent/mobileqq/msf/core/net/n:l	J
    //   873: aload_0
    //   874: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   877: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   880: getfield 632	com/tencent/mobileqq/msf/core/ad:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   883: aload_0
    //   884: getfield 132	com/tencent/mobileqq/msf/core/net/m:G	I
    //   887: iconst_1
    //   888: invokevirtual 641	com/tencent/mobileqq/msf/core/net/n:b	(IZ)V
    //   891: aload_0
    //   892: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   895: lstore 6
    //   897: lload 6
    //   899: lconst_0
    //   900: lcmp
    //   901: ifge +16 -> 917
    //   904: aload_0
    //   905: lconst_0
    //   906: putfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   909: goto +8 -> 917
    //   912: astore 14
    //   914: goto -514 -> 400
    //   917: aload_0
    //   918: getfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   921: putstatic 644	com/tencent/mobileqq/msf/core/ad:U	J
    //   924: aload_0
    //   925: getfield 121	com/tencent/mobileqq/msf/core/net/m:C	Ljava/util/concurrent/atomic/AtomicLong;
    //   928: lconst_0
    //   929: invokevirtual 646	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   932: aload_0
    //   933: getfield 123	com/tencent/mobileqq/msf/core/net/m:D	Ljava/util/concurrent/atomic/AtomicLong;
    //   936: lconst_0
    //   937: invokevirtual 646	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   940: aload_0
    //   941: aload_0
    //   942: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   945: invokevirtual 650	com/tencent/mobileqq/msf/core/net/h:getOutputStream	()Ljava/io/OutputStream;
    //   948: putfield 76	com/tencent/mobileqq/msf/core/net/m:h	Ljava/io/OutputStream;
    //   951: getstatic 69	com/tencent/mobileqq/msf/core/net/m:q	Ljava/util/ArrayList;
    //   954: aload_0
    //   955: getfield 76	com/tencent/mobileqq/msf/core/net/m:h	Ljava/io/OutputStream;
    //   958: invokevirtual 651	java/lang/Object:toString	()Ljava/lang/String;
    //   961: invokevirtual 654	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   964: istore 12
    //   966: iload 12
    //   968: ifne +17 -> 985
    //   971: getstatic 69	com/tencent/mobileqq/msf/core/net/m:q	Ljava/util/ArrayList;
    //   974: aload_0
    //   975: getfield 76	com/tencent/mobileqq/msf/core/net/m:h	Ljava/io/OutputStream;
    //   978: invokevirtual 651	java/lang/Object:toString	()Ljava/lang/String;
    //   981: invokevirtual 657	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   984: pop
    //   985: aload_0
    //   986: new 659	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   989: dup
    //   990: aload_0
    //   991: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   994: sipush 2048
    //   997: ldc_w 661
    //   1000: iconst_m1
    //   1001: invokespecial 664	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   1004: putfield 80	com/tencent/mobileqq/msf/core/net/m:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   1007: aload_0
    //   1008: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   1011: astore 13
    //   1013: aload 13
    //   1015: ifnull +26 -> 1041
    //   1018: aload_0
    //   1019: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   1022: invokevirtual 669	com/tencent/mobileqq/msf/core/net/m$a:isAlive	()Z
    //   1025: ifne +6 -> 1031
    //   1028: goto +13 -> 1041
    //   1031: aload_0
    //   1032: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   1035: invokevirtual 671	com/tencent/mobileqq/msf/core/net/m$a:a	()V
    //   1038: goto +32 -> 1070
    //   1041: aload_0
    //   1042: new 673	com/tencent/mobileqq/msf/core/net/m$b
    //   1045: dup
    //   1046: aload_0
    //   1047: invokespecial 676	com/tencent/mobileqq/msf/core/net/m$b:<init>	(Lcom/tencent/mobileqq/msf/core/net/m;)V
    //   1050: putfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   1053: aload_0
    //   1054: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   1057: ldc_w 678
    //   1060: invokevirtual 681	com/tencent/mobileqq/msf/core/net/m$a:setName	(Ljava/lang/String;)V
    //   1063: aload_0
    //   1064: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   1067: invokevirtual 684	com/tencent/mobileqq/msf/core/net/m$a:start	()V
    //   1070: aload_0
    //   1071: getfield 100	com/tencent/mobileqq/msf/core/net/m:v	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1074: iconst_1
    //   1075: invokevirtual 497	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1078: getstatic 686	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   1081: astore 13
    //   1083: ldc_w 688
    //   1086: astore 14
    //   1088: invokestatic 690	com/tencent/mobileqq/msf/core/ad:j	()V
    //   1091: aload_1
    //   1092: invokevirtual 692	com/tencent/mobileqq/msf/core/d:a	()Ljava/lang/String;
    //   1095: putstatic 694	com/tencent/mobileqq/msf/core/ad:E	Ljava/lang/String;
    //   1098: new 179	java/lang/StringBuilder
    //   1101: dup
    //   1102: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   1105: astore_2
    //   1106: aload_2
    //   1107: aload_0
    //   1108: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1111: invokevirtual 698	com/tencent/mobileqq/msf/core/net/h:getLocalSocketAddress	()Ljava/net/SocketAddress;
    //   1114: invokevirtual 701	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1117: pop
    //   1118: aload_2
    //   1119: ldc_w 703
    //   1122: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: pop
    //   1126: aload_2
    //   1127: aload_0
    //   1128: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1131: invokevirtual 706	com/tencent/mobileqq/msf/core/net/h:getLocalPort	()I
    //   1134: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1137: pop
    //   1138: aload_2
    //   1139: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1142: putstatic 708	com/tencent/mobileqq/msf/core/ad:F	Ljava/lang/String;
    //   1145: invokestatic 711	com/tencent/mobileqq/msf/core/net/j:b	()B
    //   1148: putstatic 714	com/tencent/mobileqq/msf/core/ad:H	I
    //   1151: aload_1
    //   1152: invokevirtual 716	com/tencent/mobileqq/msf/core/d:h	()V
    //   1155: aload 18
    //   1157: iconst_0
    //   1158: aload 18
    //   1160: invokevirtual 719	java/lang/StringBuilder:length	()I
    //   1163: invokevirtual 723	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1166: pop
    //   1167: invokestatic 456	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1170: istore 12
    //   1172: iload 12
    //   1174: ifeq +217 -> 1391
    //   1177: aload 18
    //   1179: ldc_w 725
    //   1182: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1185: pop
    //   1186: aload 18
    //   1188: aload_0
    //   1189: getfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   1192: invokevirtual 726	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   1195: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: pop
    //   1199: aload 18
    //   1201: ldc_w 728
    //   1204: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: pop
    //   1208: aload 18
    //   1210: aload_0
    //   1211: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   1214: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1217: pop
    //   1218: aload 18
    //   1220: ldc_w 730
    //   1223: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: pop
    //   1227: aload 18
    //   1229: aload_1
    //   1230: invokevirtual 614	com/tencent/mobileqq/msf/core/d:g	()I
    //   1233: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1236: pop
    //   1237: aload 18
    //   1239: ldc_w 732
    //   1242: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: pop
    //   1246: aload 18
    //   1248: aload_0
    //   1249: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1252: invokevirtual 736	com/tencent/mobileqq/msf/core/net/h:getLocalAddress	()Ljava/net/InetAddress;
    //   1255: invokevirtual 741	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1258: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: pop
    //   1262: aload 18
    //   1264: ldc_w 743
    //   1267: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: pop
    //   1271: aload 18
    //   1273: aload_0
    //   1274: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1277: invokevirtual 706	com/tencent/mobileqq/msf/core/net/h:getLocalPort	()I
    //   1280: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1283: pop
    //   1284: aload_1
    //   1285: getfield 572	com/tencent/mobileqq/msf/core/d:g	Z
    //   1288: ifeq +2530 -> 3818
    //   1291: goto +3 -> 1294
    //   1294: aload 18
    //   1296: aload 16
    //   1298: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1301: pop
    //   1302: aload 18
    //   1304: ldc_w 581
    //   1307: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1310: pop
    //   1311: aload_1
    //   1312: invokestatic 586	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   1315: istore 12
    //   1317: iload 12
    //   1319: ifeq +10 -> 1329
    //   1322: ldc_w 745
    //   1325: astore_2
    //   1326: goto +7 -> 1333
    //   1329: ldc_w 747
    //   1332: astore_2
    //   1333: aload 18
    //   1335: aload_2
    //   1336: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: pop
    //   1340: aload 18
    //   1342: aload_0
    //   1343: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1346: invokevirtual 413	java/lang/Object:hashCode	()I
    //   1349: invokestatic 480	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   1352: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: pop
    //   1356: aload 18
    //   1358: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1361: astore_2
    //   1362: ldc 204
    //   1364: iconst_1
    //   1365: aload_2
    //   1366: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1369: goto +331 -> 1700
    //   1372: astore_2
    //   1373: goto +668 -> 2041
    //   1376: astore_1
    //   1377: aload 13
    //   1379: astore_2
    //   1380: aload 14
    //   1382: astore 13
    //   1384: goto +2307 -> 3691
    //   1387: astore_2
    //   1388: goto +653 -> 2041
    //   1391: aload 18
    //   1393: ldc_w 725
    //   1396: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: pop
    //   1400: aload 18
    //   1402: aload_0
    //   1403: getfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   1406: invokevirtual 726	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   1409: invokestatic 486	com/tencent/mobileqq/msf/core/b/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1412: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: pop
    //   1416: aload 18
    //   1418: ldc_w 728
    //   1421: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1424: pop
    //   1425: aload 13
    //   1427: astore_2
    //   1428: aload 14
    //   1430: astore 15
    //   1432: aload 18
    //   1434: aload_0
    //   1435: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   1438: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1441: pop
    //   1442: aload 13
    //   1444: astore_2
    //   1445: aload 14
    //   1447: astore 15
    //   1449: aload 18
    //   1451: ldc_w 730
    //   1454: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: pop
    //   1458: aload 13
    //   1460: astore_2
    //   1461: aload 14
    //   1463: astore 15
    //   1465: aload 18
    //   1467: aload_1
    //   1468: invokevirtual 614	com/tencent/mobileqq/msf/core/d:g	()I
    //   1471: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1474: pop
    //   1475: aload 13
    //   1477: astore_2
    //   1478: aload 14
    //   1480: astore 15
    //   1482: aload 18
    //   1484: ldc_w 732
    //   1487: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: pop
    //   1491: aload 13
    //   1493: astore_2
    //   1494: aload 14
    //   1496: astore 15
    //   1498: aload 18
    //   1500: aload_0
    //   1501: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1504: invokevirtual 736	com/tencent/mobileqq/msf/core/net/h:getLocalAddress	()Ljava/net/InetAddress;
    //   1507: invokevirtual 741	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1510: invokestatic 486	com/tencent/mobileqq/msf/core/b/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1513: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1516: pop
    //   1517: aload 13
    //   1519: astore_2
    //   1520: aload 14
    //   1522: astore 15
    //   1524: aload 18
    //   1526: ldc_w 743
    //   1529: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: pop
    //   1533: aload 13
    //   1535: astore_2
    //   1536: aload 14
    //   1538: astore 15
    //   1540: aload 18
    //   1542: aload_0
    //   1543: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1546: invokevirtual 706	com/tencent/mobileqq/msf/core/net/h:getLocalPort	()I
    //   1549: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1552: pop
    //   1553: aload 13
    //   1555: astore_2
    //   1556: aload 14
    //   1558: astore 15
    //   1560: aload_1
    //   1561: getfield 572	com/tencent/mobileqq/msf/core/d:g	Z
    //   1564: ifeq +2261 -> 3825
    //   1567: goto +3 -> 1570
    //   1570: aload 13
    //   1572: astore_2
    //   1573: aload 14
    //   1575: astore 15
    //   1577: aload 18
    //   1579: aload 16
    //   1581: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1584: pop
    //   1585: aload 13
    //   1587: astore_2
    //   1588: aload 14
    //   1590: astore 15
    //   1592: aload 18
    //   1594: ldc_w 581
    //   1597: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: pop
    //   1601: aload 13
    //   1603: astore_2
    //   1604: aload 14
    //   1606: astore 15
    //   1608: aload_1
    //   1609: invokestatic 586	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   1612: istore 12
    //   1614: iload 12
    //   1616: ifeq +23 -> 1639
    //   1619: ldc_w 745
    //   1622: astore 16
    //   1624: goto +20 -> 1644
    //   1627: astore 15
    //   1629: aload 13
    //   1631: astore_2
    //   1632: aload 14
    //   1634: astore 13
    //   1636: goto -1228 -> 408
    //   1639: ldc_w 747
    //   1642: astore 16
    //   1644: aload 13
    //   1646: astore_2
    //   1647: aload 14
    //   1649: astore 15
    //   1651: aload 18
    //   1653: aload 16
    //   1655: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: pop
    //   1659: aload 13
    //   1661: astore_2
    //   1662: aload 14
    //   1664: astore 15
    //   1666: aload 18
    //   1668: aload_0
    //   1669: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1672: invokevirtual 413	java/lang/Object:hashCode	()I
    //   1675: invokestatic 480	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   1678: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1681: pop
    //   1682: aload 13
    //   1684: astore_2
    //   1685: aload 14
    //   1687: astore 15
    //   1689: ldc 204
    //   1691: iconst_1
    //   1692: aload 18
    //   1694: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1697: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1700: aload 13
    //   1702: astore_2
    //   1703: aload 14
    //   1705: astore 15
    //   1707: aload_0
    //   1708: getfield 95	com/tencent/mobileqq/msf/core/net/m:s	Ljava/util/concurrent/atomic/AtomicInteger;
    //   1711: iconst_0
    //   1712: invokevirtual 749	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   1715: aload 13
    //   1717: astore_2
    //   1718: aload 14
    //   1720: astore 15
    //   1722: getstatic 424	com/tencent/mobileqq/msf/core/ad:s	Z
    //   1725: istore 12
    //   1727: iload 12
    //   1729: ifeq +108 -> 1837
    //   1732: aload 13
    //   1734: astore_2
    //   1735: aload 14
    //   1737: astore 15
    //   1739: invokestatic 428	com/tencent/mobileqq/msf/core/net/a/f:a	()Z
    //   1742: istore 12
    //   1744: iload 12
    //   1746: ifeq +91 -> 1837
    //   1749: aload 13
    //   1751: astore_2
    //   1752: aload 14
    //   1754: astore 15
    //   1756: ldc 204
    //   1758: iconst_1
    //   1759: ldc_w 751
    //   1762: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1765: aload 13
    //   1767: astore_2
    //   1768: aload 14
    //   1770: astore 15
    //   1772: aload_0
    //   1773: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1776: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   1779: getfield 433	com/tencent/mobileqq/msf/core/ad:I	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   1782: ifnull +55 -> 1837
    //   1785: aload 13
    //   1787: astore_2
    //   1788: aload 14
    //   1790: astore 15
    //   1792: aload_0
    //   1793: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1796: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   1799: getfield 433	com/tencent/mobileqq/msf/core/ad:I	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   1802: invokevirtual 436	com/tencent/mobileqq/msf/core/net/a/f:b	()Lcom/tencent/mobileqq/msf/core/net/a/e;
    //   1805: aload_0
    //   1806: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   1809: invokeinterface 754 2 0
    //   1814: goto +23 -> 1837
    //   1817: astore 16
    //   1819: aload 13
    //   1821: astore_2
    //   1822: aload 14
    //   1824: astore 15
    //   1826: ldc 204
    //   1828: iconst_1
    //   1829: ldc_w 756
    //   1832: aload 16
    //   1834: invokestatic 323	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1837: aload 13
    //   1839: astore_2
    //   1840: aload 14
    //   1842: astore 15
    //   1844: aload_0
    //   1845: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1848: invokevirtual 760	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   1851: ifnull +125 -> 1976
    //   1854: aload 13
    //   1856: astore_2
    //   1857: aload 14
    //   1859: astore 15
    //   1861: aload_0
    //   1862: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1865: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   1868: getfield 770	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   1871: ifnull +105 -> 1976
    //   1874: aload 13
    //   1876: astore_2
    //   1877: aload 14
    //   1879: astore 15
    //   1881: aload_0
    //   1882: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1885: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   1888: getfield 770	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   1891: getfield 774	com/tencent/mobileqq/msf/core/d/j$c:e	J
    //   1894: lstore 6
    //   1896: lload 6
    //   1898: lconst_0
    //   1899: lcmp
    //   1900: ifle +24 -> 1924
    //   1903: aload 13
    //   1905: astore_2
    //   1906: aload 14
    //   1908: astore 15
    //   1910: aload_0
    //   1911: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1914: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   1917: getfield 770	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   1920: lconst_0
    //   1921: putfield 776	com/tencent/mobileqq/msf/core/d/j$c:f	J
    //   1924: aload 13
    //   1926: astore_2
    //   1927: aload 14
    //   1929: astore 15
    //   1931: aload_0
    //   1932: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1935: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   1938: getfield 770	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   1941: lconst_0
    //   1942: putfield 778	com/tencent/mobileqq/msf/core/d/j$c:g	J
    //   1945: aload 13
    //   1947: astore_2
    //   1948: aload 14
    //   1950: astore 15
    //   1952: ldc 204
    //   1954: iconst_1
    //   1955: ldc_w 780
    //   1958: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1961: goto +15 -> 1976
    //   1964: astore_2
    //   1965: aload 13
    //   1967: astore 15
    //   1969: aload 14
    //   1971: astore 13
    //   1973: goto +158 -> 2131
    //   1976: aload_0
    //   1977: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   1980: invokevirtual 783	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1983: aload 13
    //   1985: getstatic 686	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   1988: if_acmpeq +18 -> 2006
    //   1991: aload_3
    //   1992: iconst_0
    //   1993: putfield 627	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   1996: aload_3
    //   1997: aload_3
    //   1998: getfield 785	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2001: iconst_1
    //   2002: iadd
    //   2003: putfield 785	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2006: aload_3
    //   2007: aload 13
    //   2009: putfield 787	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2012: aload_3
    //   2013: ldc_w 688
    //   2016: putfield 789	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   2019: invokestatic 263	android/os/SystemClock:elapsedRealtime	()J
    //   2022: lstore 4
    //   2024: aload_3
    //   2025: lload 4
    //   2027: lload 8
    //   2029: lsub
    //   2030: putfield 791	com/tencent/mobileqq/msf/core/net/a:a	J
    //   2033: goto +1065 -> 3098
    //   2036: astore_2
    //   2037: goto +19 -> 2056
    //   2040: astore_2
    //   2041: goto +15 -> 2056
    //   2044: astore_1
    //   2045: aload 13
    //   2047: astore_2
    //   2048: aload 14
    //   2050: astore 13
    //   2052: goto +64 -> 2116
    //   2055: astore_2
    //   2056: aload 13
    //   2058: astore 15
    //   2060: aload 14
    //   2062: astore 13
    //   2064: goto +67 -> 2131
    //   2067: astore 13
    //   2069: goto +27 -> 2096
    //   2072: astore 13
    //   2074: lload 6
    //   2076: lstore 4
    //   2078: goto +18 -> 2096
    //   2081: astore 13
    //   2083: goto +13 -> 2096
    //   2086: astore_1
    //   2087: ldc 82
    //   2089: astore 13
    //   2091: goto +1600 -> 3691
    //   2094: astore 13
    //   2096: ldc 82
    //   2098: astore 14
    //   2100: aload 13
    //   2102: astore 16
    //   2104: aload 14
    //   2106: astore 13
    //   2108: goto +29 -> 2137
    //   2111: astore_1
    //   2112: ldc 82
    //   2114: astore 13
    //   2116: goto +1575 -> 3691
    //   2119: astore 14
    //   2121: ldc 82
    //   2123: astore 13
    //   2125: aload_2
    //   2126: astore 15
    //   2128: aload 14
    //   2130: astore_2
    //   2131: aload_2
    //   2132: astore 16
    //   2134: aload 15
    //   2136: astore_2
    //   2137: aload_0
    //   2138: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   2141: lload 4
    //   2143: lsub
    //   2144: putfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   2147: aload_0
    //   2148: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2151: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   2154: getfield 632	com/tencent/mobileqq/msf/core/ad:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   2157: astore 15
    //   2159: aload 15
    //   2161: getfield 636	com/tencent/mobileqq/msf/core/net/n:l	J
    //   2164: lstore 4
    //   2166: aload 13
    //   2168: astore 14
    //   2170: aload 15
    //   2172: lload 4
    //   2174: aload_0
    //   2175: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   2178: ladd
    //   2179: putfield 636	com/tencent/mobileqq/msf/core/net/n:l	J
    //   2182: aload 13
    //   2184: astore 14
    //   2186: aload_0
    //   2187: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2190: invokevirtual 760	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   2193: ifnull +155 -> 2348
    //   2196: aload 13
    //   2198: astore 14
    //   2200: aload_0
    //   2201: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2204: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   2207: getfield 770	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   2210: ifnull +138 -> 2348
    //   2213: aload 13
    //   2215: astore 14
    //   2217: aload_0
    //   2218: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2221: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   2224: getfield 770	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   2227: getfield 774	com/tencent/mobileqq/msf/core/d/j$c:e	J
    //   2230: lconst_0
    //   2231: lcmp
    //   2232: ifle +45 -> 2277
    //   2235: aload 13
    //   2237: astore 14
    //   2239: aload_0
    //   2240: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2243: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   2246: getfield 770	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   2249: getfield 776	com/tencent/mobileqq/msf/core/d/j$c:f	J
    //   2252: lconst_0
    //   2253: lcmp
    //   2254: ifne +23 -> 2277
    //   2257: aload 13
    //   2259: astore 14
    //   2261: aload_0
    //   2262: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2265: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   2268: getfield 770	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   2271: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   2274: putfield 776	com/tencent/mobileqq/msf/core/d/j$c:f	J
    //   2277: aload 13
    //   2279: astore 14
    //   2281: aload_0
    //   2282: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2285: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   2288: getfield 770	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   2291: getfield 778	com/tencent/mobileqq/msf/core/d/j$c:g	J
    //   2294: lconst_0
    //   2295: lcmp
    //   2296: ifne +52 -> 2348
    //   2299: aload 13
    //   2301: astore 14
    //   2303: aload_0
    //   2304: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2307: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   2310: getfield 770	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   2313: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   2316: putfield 778	com/tencent/mobileqq/msf/core/d/j$c:g	J
    //   2319: aload 13
    //   2321: astore 14
    //   2323: ldc 204
    //   2325: iconst_1
    //   2326: iconst_2
    //   2327: anewarray 4	java/lang/Object
    //   2330: dup
    //   2331: iconst_0
    //   2332: ldc_w 793
    //   2335: aastore
    //   2336: dup
    //   2337: iconst_1
    //   2338: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   2341: invokestatic 269	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2344: aastore
    //   2345: invokestatic 796	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   2348: aload 13
    //   2350: astore 14
    //   2352: aload 16
    //   2354: invokevirtual 797	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2357: invokevirtual 800	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2360: astore 15
    //   2362: aload 15
    //   2364: astore 14
    //   2366: invokestatic 803	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   2369: ifne +47 -> 2416
    //   2372: aload 15
    //   2374: astore 14
    //   2376: getstatic 805	com/tencent/mobileqq/msf/core/net/x:m	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2379: astore 13
    //   2381: aload 13
    //   2383: astore_2
    //   2384: aload 13
    //   2386: invokevirtual 806	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   2389: astore 14
    //   2391: aload 13
    //   2393: astore_2
    //   2394: aload 14
    //   2396: astore 15
    //   2398: aload_3
    //   2399: invokestatic 809	com/tencent/mobileqq/msf/core/a/a:aE	()I
    //   2402: putfield 811	com/tencent/mobileqq/msf/core/net/a:h	I
    //   2405: goto +643 -> 3048
    //   2408: astore_1
    //   2409: aload 15
    //   2411: astore 13
    //   2413: goto -297 -> 2116
    //   2416: aload 15
    //   2418: astore 14
    //   2420: aload 15
    //   2422: ldc_w 813
    //   2425: invokevirtual 817	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2428: iconst_m1
    //   2429: if_icmple +25 -> 2454
    //   2432: aload 15
    //   2434: astore 14
    //   2436: getstatic 819	com/tencent/mobileqq/msf/core/net/x:g	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2439: astore 13
    //   2441: aload 13
    //   2443: astore_2
    //   2444: aload 13
    //   2446: invokevirtual 806	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   2449: astore 14
    //   2451: goto +597 -> 3048
    //   2454: aload 15
    //   2456: astore 14
    //   2458: aload 15
    //   2460: ldc_w 821
    //   2463: invokevirtual 817	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2466: iconst_m1
    //   2467: if_icmple +25 -> 2492
    //   2470: aload 15
    //   2472: astore 14
    //   2474: getstatic 823	com/tencent/mobileqq/msf/core/net/x:q	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2477: astore 13
    //   2479: aload 13
    //   2481: astore_2
    //   2482: aload 13
    //   2484: invokevirtual 806	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   2487: astore 14
    //   2489: goto +559 -> 3048
    //   2492: aload 15
    //   2494: astore 14
    //   2496: aload 15
    //   2498: ldc_w 825
    //   2501: invokevirtual 817	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2504: iconst_m1
    //   2505: if_icmple +39 -> 2544
    //   2508: aload 15
    //   2510: astore 14
    //   2512: getstatic 805	com/tencent/mobileqq/msf/core/net/x:m	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2515: astore 13
    //   2517: aload 13
    //   2519: astore_2
    //   2520: aload 13
    //   2522: invokevirtual 806	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   2525: astore 14
    //   2527: aload 13
    //   2529: astore_2
    //   2530: aload 14
    //   2532: astore 15
    //   2534: aload_3
    //   2535: invokestatic 809	com/tencent/mobileqq/msf/core/a/a:aE	()I
    //   2538: putfield 811	com/tencent/mobileqq/msf/core/net/a:h	I
    //   2541: goto +507 -> 3048
    //   2544: aload 15
    //   2546: astore 14
    //   2548: aload 15
    //   2550: ldc_w 827
    //   2553: invokevirtual 817	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2556: iconst_m1
    //   2557: if_icmple +25 -> 2582
    //   2560: aload 15
    //   2562: astore 14
    //   2564: getstatic 829	com/tencent/mobileqq/msf/core/net/x:i	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2567: astore 13
    //   2569: aload 13
    //   2571: astore_2
    //   2572: aload 13
    //   2574: invokevirtual 806	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   2577: astore 14
    //   2579: goto +469 -> 3048
    //   2582: aload 15
    //   2584: astore 14
    //   2586: aload 15
    //   2588: ldc_w 831
    //   2591: invokevirtual 817	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2594: iconst_m1
    //   2595: if_icmple +25 -> 2620
    //   2598: aload 15
    //   2600: astore 14
    //   2602: getstatic 833	com/tencent/mobileqq/msf/core/net/x:s	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2605: astore 13
    //   2607: aload 13
    //   2609: astore_2
    //   2610: aload 13
    //   2612: invokevirtual 806	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   2615: astore 14
    //   2617: goto +431 -> 3048
    //   2620: aload 15
    //   2622: astore 14
    //   2624: aload 15
    //   2626: ldc_w 835
    //   2629: invokevirtual 817	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2632: iconst_m1
    //   2633: if_icmple +25 -> 2658
    //   2636: aload 15
    //   2638: astore 14
    //   2640: getstatic 837	com/tencent/mobileqq/msf/core/net/x:r	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2643: astore 13
    //   2645: aload 13
    //   2647: astore_2
    //   2648: aload 13
    //   2650: invokevirtual 806	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   2653: astore 14
    //   2655: goto +393 -> 3048
    //   2658: aload 15
    //   2660: astore 14
    //   2662: aload 15
    //   2664: ldc_w 839
    //   2667: invokevirtual 817	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2670: iconst_m1
    //   2671: if_icmpgt +358 -> 3029
    //   2674: aload 15
    //   2676: astore 14
    //   2678: aload 15
    //   2680: ldc_w 841
    //   2683: invokevirtual 817	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2686: iconst_m1
    //   2687: if_icmple +6 -> 2693
    //   2690: goto +339 -> 3029
    //   2693: aload 15
    //   2695: astore 14
    //   2697: aload 15
    //   2699: ldc_w 843
    //   2702: invokevirtual 817	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2705: iconst_m1
    //   2706: if_icmple +25 -> 2731
    //   2709: aload 15
    //   2711: astore 14
    //   2713: getstatic 845	com/tencent/mobileqq/msf/core/net/x:p	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2716: astore 13
    //   2718: aload 13
    //   2720: astore_2
    //   2721: aload 13
    //   2723: invokevirtual 806	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   2726: astore 14
    //   2728: goto +320 -> 3048
    //   2731: aload 15
    //   2733: astore 14
    //   2735: aload 15
    //   2737: ldc_w 847
    //   2740: invokevirtual 817	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2743: iconst_m1
    //   2744: if_icmple +25 -> 2769
    //   2747: aload 15
    //   2749: astore 14
    //   2751: getstatic 849	com/tencent/mobileqq/msf/core/net/x:o	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2754: astore 13
    //   2756: aload 13
    //   2758: astore_2
    //   2759: aload 13
    //   2761: invokevirtual 806	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   2764: astore 14
    //   2766: goto +282 -> 3048
    //   2769: aload 15
    //   2771: astore 14
    //   2773: aload 15
    //   2775: ldc_w 851
    //   2778: invokevirtual 817	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2781: iconst_m1
    //   2782: if_icmple +25 -> 2807
    //   2785: aload 15
    //   2787: astore 14
    //   2789: getstatic 853	com/tencent/mobileqq/msf/core/net/x:h	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2792: astore 13
    //   2794: aload 13
    //   2796: astore_2
    //   2797: aload 13
    //   2799: invokevirtual 806	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   2802: astore 14
    //   2804: goto +244 -> 3048
    //   2807: aload 15
    //   2809: astore 14
    //   2811: aload 15
    //   2813: ldc_w 855
    //   2816: invokevirtual 817	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2819: iconst_m1
    //   2820: if_icmple +25 -> 2845
    //   2823: aload 15
    //   2825: astore 14
    //   2827: getstatic 857	com/tencent/mobileqq/msf/core/net/x:l	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2830: astore 13
    //   2832: aload 13
    //   2834: astore_2
    //   2835: aload 13
    //   2837: invokevirtual 806	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   2840: astore 14
    //   2842: goto +206 -> 3048
    //   2845: aload 15
    //   2847: astore 14
    //   2849: aload 15
    //   2851: ldc_w 859
    //   2854: invokevirtual 817	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2857: iconst_m1
    //   2858: if_icmple +25 -> 2883
    //   2861: aload 15
    //   2863: astore 14
    //   2865: getstatic 861	com/tencent/mobileqq/msf/core/net/x:j	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2868: astore 13
    //   2870: aload 13
    //   2872: astore_2
    //   2873: aload 13
    //   2875: invokevirtual 806	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   2878: astore 14
    //   2880: goto +168 -> 3048
    //   2883: aload 15
    //   2885: astore 14
    //   2887: aload 15
    //   2889: ldc_w 863
    //   2892: invokevirtual 817	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2895: iconst_m1
    //   2896: if_icmple +25 -> 2921
    //   2899: aload 15
    //   2901: astore 14
    //   2903: getstatic 865	com/tencent/mobileqq/msf/core/net/x:t	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2906: astore 13
    //   2908: aload 13
    //   2910: astore_2
    //   2911: aload 13
    //   2913: invokevirtual 806	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   2916: astore 14
    //   2918: goto +130 -> 3048
    //   2921: aload 15
    //   2923: astore 14
    //   2925: aload 15
    //   2927: ldc_w 867
    //   2930: invokevirtual 817	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2933: iconst_m1
    //   2934: if_icmple +25 -> 2959
    //   2937: aload 15
    //   2939: astore 14
    //   2941: getstatic 869	com/tencent/mobileqq/msf/core/net/x:n	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2944: astore 13
    //   2946: aload 13
    //   2948: astore_2
    //   2949: aload 13
    //   2951: invokevirtual 806	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   2954: astore 14
    //   2956: goto +92 -> 3048
    //   2959: aload 15
    //   2961: astore 14
    //   2963: getstatic 871	com/tencent/mobileqq/msf/core/net/x:u	Lcom/tencent/mobileqq/msf/core/net/x;
    //   2966: astore 17
    //   2968: aload 17
    //   2970: astore_2
    //   2971: aload 16
    //   2973: invokestatic 875	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2976: astore 16
    //   2978: aload 17
    //   2980: astore_2
    //   2981: aload 16
    //   2983: astore 15
    //   2985: aload 17
    //   2987: astore 13
    //   2989: aload 16
    //   2991: astore 14
    //   2993: aload 16
    //   2995: invokevirtual 876	java/lang/String:length	()I
    //   2998: sipush 200
    //   3001: if_icmple +47 -> 3048
    //   3004: aload 17
    //   3006: astore_2
    //   3007: aload 16
    //   3009: astore 15
    //   3011: aload 16
    //   3013: iconst_0
    //   3014: sipush 200
    //   3017: invokevirtual 880	java/lang/String:substring	(II)Ljava/lang/String;
    //   3020: astore 14
    //   3022: aload 17
    //   3024: astore 13
    //   3026: goto +22 -> 3048
    //   3029: aload 15
    //   3031: astore 14
    //   3033: getstatic 865	com/tencent/mobileqq/msf/core/net/x:t	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3036: astore 13
    //   3038: aload 13
    //   3040: astore_2
    //   3041: aload 13
    //   3043: invokevirtual 806	com/tencent/mobileqq/msf/core/net/x:toString	()Ljava/lang/String;
    //   3046: astore 14
    //   3048: aload_0
    //   3049: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   3052: invokevirtual 783	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   3055: aload 13
    //   3057: getstatic 686	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3060: if_acmpeq +18 -> 3078
    //   3063: aload_3
    //   3064: iconst_0
    //   3065: putfield 627	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   3068: aload_3
    //   3069: aload_3
    //   3070: getfield 785	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3073: iconst_1
    //   3074: iadd
    //   3075: putfield 785	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3078: aload_3
    //   3079: aload 13
    //   3081: putfield 787	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3084: aload_3
    //   3085: aload 14
    //   3087: putfield 789	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3090: invokestatic 263	android/os/SystemClock:elapsedRealtime	()J
    //   3093: lstore 4
    //   3095: goto -1071 -> 2024
    //   3098: aload_0
    //   3099: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3102: invokevirtual 760	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   3105: ifnull +39 -> 3144
    //   3108: aload_0
    //   3109: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3112: invokevirtual 760	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   3115: astore_2
    //   3116: aload 13
    //   3118: getstatic 686	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3121: if_acmpne +711 -> 3832
    //   3124: iconst_1
    //   3125: istore 12
    //   3127: goto +3 -> 3130
    //   3130: aload_2
    //   3131: iload 12
    //   3133: aload_0
    //   3134: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   3137: aload_1
    //   3138: invokevirtual 543	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   3141: invokevirtual 883	com/tencent/mobileqq/msf/core/d/j:b	(ZJLjava/lang/String;)V
    //   3144: goto +12 -> 3156
    //   3147: ldc 204
    //   3149: iconst_1
    //   3150: ldc_w 885
    //   3153: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3156: aload 13
    //   3158: getstatic 686	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3161: if_acmpne +359 -> 3520
    //   3164: aload_1
    //   3165: invokestatic 586	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   3168: ifeq +16 -> 3184
    //   3171: invokestatic 538	com/tencent/mobileqq/a/a/a$c:a	()Lcom/tencent/mobileqq/a/a/a$c;
    //   3174: iconst_1
    //   3175: invokevirtual 887	com/tencent/mobileqq/a/a/a$c:a	(Z)V
    //   3178: invokestatic 538	com/tencent/mobileqq/a/a/a$c:a	()Lcom/tencent/mobileqq/a/a/a$c;
    //   3181: invokevirtual 889	com/tencent/mobileqq/a/a/a$c:b	()V
    //   3184: invokestatic 892	com/tencent/mobileqq/msf/core/NetConnInfoCenter:checkConnInfo	()V
    //   3187: invokestatic 895	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isNetSupport	()Z
    //   3190: ifne +7 -> 3197
    //   3193: iconst_1
    //   3194: invokestatic 898	com/tencent/mobileqq/msf/core/NetConnInfoCenter:setNetSupport	(Z)V
    //   3197: invokestatic 803	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   3200: putstatic 899	com/tencent/mobileqq/msf/core/ad:G	I
    //   3203: aload_0
    //   3204: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3207: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   3210: aconst_null
    //   3211: invokevirtual 901	com/tencent/mobileqq/msf/core/ad:a	([B)V
    //   3214: aload_0
    //   3215: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3218: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   3221: invokevirtual 903	com/tencent/mobileqq/msf/core/ad:f	()V
    //   3224: getstatic 905	com/tencent/mobileqq/msf/core/ad:A	Ljava/util/concurrent/atomic/AtomicInteger;
    //   3227: iconst_0
    //   3228: invokevirtual 749	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   3231: getstatic 907	com/tencent/mobileqq/msf/core/ad:B	Ljava/util/ArrayList;
    //   3234: invokevirtual 910	java/util/ArrayList:clear	()V
    //   3237: aload_0
    //   3238: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   3241: ifnull +538 -> 3779
    //   3244: aload_0
    //   3245: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3248: astore_2
    //   3249: new 179	java/lang/StringBuilder
    //   3252: dup
    //   3253: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   3256: astore 13
    //   3258: aload 13
    //   3260: aload_0
    //   3261: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   3264: invokevirtual 736	com/tencent/mobileqq/msf/core/net/h:getLocalAddress	()Ljava/net/InetAddress;
    //   3267: invokevirtual 741	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   3270: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3273: pop
    //   3274: aload 13
    //   3276: ldc_w 743
    //   3279: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3282: pop
    //   3283: aload 13
    //   3285: aload_0
    //   3286: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   3289: invokevirtual 706	com/tencent/mobileqq/msf/core/net/h:getLocalPort	()I
    //   3292: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3295: pop
    //   3296: aload_2
    //   3297: aload 13
    //   3299: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3302: putfield 913	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   3305: invokestatic 298	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   3308: aload_0
    //   3309: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   3312: getstatic 899	com/tencent/mobileqq/msf/core/ad:G	I
    //   3315: aload_0
    //   3316: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   3319: l2i
    //   3320: invokevirtual 916	com/tencent/mobileqq/a/a/a:a	(Ljava/net/Socket;II)V
    //   3323: aload_0
    //   3324: getfield 104	com/tencent/mobileqq/msf/core/net/m:x	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3327: iconst_0
    //   3328: invokevirtual 497	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   3331: invokestatic 918	com/tencent/mobileqq/msf/core/a/a:v	()Z
    //   3334: ifeq +47 -> 3381
    //   3337: aload_0
    //   3338: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3341: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   3344: getfield 632	com/tencent/mobileqq/msf/core/ad:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   3347: invokevirtual 920	com/tencent/mobileqq/msf/core/net/n:o	()Z
    //   3350: ifeq +19 -> 3369
    //   3353: aload_0
    //   3354: invokevirtual 922	com/tencent/mobileqq/msf/core/net/m:j	()I
    //   3357: iconst_1
    //   3358: if_icmpne +11 -> 3369
    //   3361: aload_0
    //   3362: iconst_1
    //   3363: invokespecial 924	com/tencent/mobileqq/msf/core/net/m:b	(Z)V
    //   3366: goto +8 -> 3374
    //   3369: aload_0
    //   3370: iconst_0
    //   3371: invokespecial 924	com/tencent/mobileqq/msf/core/net/m:b	(Z)V
    //   3374: aload_0
    //   3375: invokespecial 926	com/tencent/mobileqq/msf/core/net/m:m	()V
    //   3378: goto +12 -> 3390
    //   3381: ldc 204
    //   3383: iconst_1
    //   3384: ldc_w 928
    //   3387: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3390: invokestatic 930	com/tencent/mobileqq/msf/core/a/a:w	()Z
    //   3393: ifeq +27 -> 3420
    //   3396: aload_0
    //   3397: aload_0
    //   3398: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3401: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   3404: aload_0
    //   3405: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   3408: invokevirtual 413	java/lang/Object:hashCode	()I
    //   3411: invokevirtual 933	com/tencent/mobileqq/msf/core/ad:a	(I)Ljava/lang/Runnable;
    //   3414: putfield 504	com/tencent/mobileqq/msf/core/net/m:F	Ljava/lang/Runnable;
    //   3417: goto +30 -> 3447
    //   3420: ldc 204
    //   3422: iconst_1
    //   3423: ldc_w 935
    //   3426: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3429: goto +18 -> 3447
    //   3432: astore_2
    //   3433: aload_2
    //   3434: invokevirtual 318	java/lang/Exception:printStackTrace	()V
    //   3437: ldc 204
    //   3439: iconst_1
    //   3440: ldc_w 937
    //   3443: aload_2
    //   3444: invokestatic 323	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3447: aload_0
    //   3448: getfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   3451: invokevirtual 726	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   3454: invokestatic 942	com/tencent/qphone/base/util/g:b	(Ljava/lang/String;)J
    //   3457: putstatic 946	com/tencent/mobileqq/msf/core/push/e:d	J
    //   3460: goto +18 -> 3478
    //   3463: ldc2_w 947
    //   3466: putstatic 946	com/tencent/mobileqq/msf/core/push/e:d	J
    //   3469: ldc 204
    //   3471: iconst_1
    //   3472: ldc_w 950
    //   3475: invokestatic 952	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   3478: aload_1
    //   3479: invokevirtual 543	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   3482: aload_1
    //   3483: invokevirtual 547	com/tencent/mobileqq/msf/core/d:f	()I
    //   3486: getstatic 899	com/tencent/mobileqq/msf/core/ad:G	I
    //   3489: invokestatic 957	com/tencent/mobileqq/a/a/f:a	(Ljava/lang/String;II)V
    //   3492: aload_0
    //   3493: getfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   3496: invokevirtual 726	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   3499: aload_0
    //   3500: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3503: getfield 913	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   3506: invokestatic 961	com/tencent/mobileqq/msf/core/NetConnInfoCenter:onConnOpened	(Ljava/lang/String;Ljava/lang/String;)V
    //   3509: aload_0
    //   3510: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   3513: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   3516: invokevirtual 963	com/tencent/mobileqq/msf/core/ad:o	()V
    //   3519: return
    //   3520: aload 13
    //   3522: getstatic 686	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3525: if_acmpeq +254 -> 3779
    //   3528: invokestatic 298	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   3531: getstatic 899	com/tencent/mobileqq/msf/core/ad:G	I
    //   3534: aload_0
    //   3535: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   3538: aload 13
    //   3540: invokevirtual 966	com/tencent/mobileqq/a/a/a:a	(IJLcom/tencent/mobileqq/msf/core/net/x;)V
    //   3543: new 179	java/lang/StringBuilder
    //   3546: dup
    //   3547: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   3550: astore 13
    //   3552: aload 13
    //   3554: ldc_w 968
    //   3557: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3560: pop
    //   3561: aload 13
    //   3563: aload_0
    //   3564: getfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   3567: invokevirtual 701	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3570: pop
    //   3571: aload 13
    //   3573: ldc_w 970
    //   3576: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3579: pop
    //   3580: aload 13
    //   3582: aload_3
    //   3583: getfield 789	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3586: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3589: pop
    //   3590: aload 13
    //   3592: ldc_w 972
    //   3595: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3598: pop
    //   3599: aload 13
    //   3601: aload_0
    //   3602: getfield 108	com/tencent/mobileqq/msf/core/net/m:A	J
    //   3605: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3608: pop
    //   3609: aload 13
    //   3611: ldc_w 730
    //   3614: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3617: pop
    //   3618: aload 13
    //   3620: aload_1
    //   3621: invokevirtual 614	com/tencent/mobileqq/msf/core/d:g	()I
    //   3624: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3627: pop
    //   3628: aload_1
    //   3629: getfield 572	com/tencent/mobileqq/msf/core/d:g	Z
    //   3632: ifeq +206 -> 3838
    //   3635: ldc_w 554
    //   3638: astore_2
    //   3639: goto +3 -> 3642
    //   3642: aload 13
    //   3644: aload_2
    //   3645: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3648: pop
    //   3649: aload 13
    //   3651: ldc_w 581
    //   3654: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3657: pop
    //   3658: aload_1
    //   3659: invokestatic 586	com/tencent/mobileqq/msf/core/net/j:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   3662: ifeq +183 -> 3845
    //   3665: ldc_w 568
    //   3668: astore_1
    //   3669: goto +3 -> 3672
    //   3672: aload 13
    //   3674: aload_1
    //   3675: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3678: pop
    //   3679: ldc 204
    //   3681: iconst_1
    //   3682: aload 13
    //   3684: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3687: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3690: return
    //   3691: aload_0
    //   3692: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   3695: invokevirtual 783	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   3698: aload_2
    //   3699: getstatic 686	com/tencent/mobileqq/msf/core/net/x:c	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3702: if_acmpeq +18 -> 3720
    //   3705: aload_3
    //   3706: iconst_0
    //   3707: putfield 627	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   3710: aload_3
    //   3711: aload_3
    //   3712: getfield 785	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3715: iconst_1
    //   3716: iadd
    //   3717: putfield 785	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3720: aload_3
    //   3721: aload_2
    //   3722: putfield 787	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3725: aload_3
    //   3726: aload 13
    //   3728: putfield 789	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3731: aload_3
    //   3732: invokestatic 263	android/os/SystemClock:elapsedRealtime	()J
    //   3735: lload 8
    //   3737: lsub
    //   3738: putfield 791	com/tencent/mobileqq/msf/core/net/a:a	J
    //   3741: aload_1
    //   3742: athrow
    //   3743: astore_1
    //   3744: aload_3
    //   3745: iconst_0
    //   3746: putfield 627	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   3749: aload_3
    //   3750: aload_3
    //   3751: getfield 785	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3754: iconst_1
    //   3755: iadd
    //   3756: putfield 785	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3759: aload_3
    //   3760: getstatic 974	com/tencent/mobileqq/msf/core/net/x:f	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3763: putfield 787	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/x;
    //   3766: aload_3
    //   3767: aload_1
    //   3768: invokevirtual 975	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   3771: putfield 789	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3774: aload_3
    //   3775: lconst_0
    //   3776: putfield 791	com/tencent/mobileqq/msf/core/net/a:a	J
    //   3779: return
    //   3780: astore_2
    //   3781: goto -634 -> 3147
    //   3784: astore_2
    //   3785: goto -322 -> 3463
    //   3788: ldc_w 638
    //   3791: astore 14
    //   3793: goto -3525 -> 268
    //   3796: ldc 144
    //   3798: astore 13
    //   3800: goto -3467 -> 333
    //   3803: ldc_w 638
    //   3806: astore 14
    //   3808: goto -3345 -> 463
    //   3811: ldc 144
    //   3813: astore 13
    //   3815: goto -3287 -> 528
    //   3818: aload 17
    //   3820: astore 16
    //   3822: goto -2528 -> 1294
    //   3825: aload 17
    //   3827: astore 16
    //   3829: goto -2259 -> 1570
    //   3832: iconst_0
    //   3833: istore 12
    //   3835: goto -705 -> 3130
    //   3838: ldc_w 638
    //   3841: astore_2
    //   3842: goto -200 -> 3642
    //   3845: ldc 144
    //   3847: astore_1
    //   3848: goto -176 -> 3672
    //   3851: astore_1
    //   3852: aload 14
    //   3854: astore 13
    //   3856: goto -165 -> 3691
    //   3859: astore_1
    //   3860: goto -1744 -> 2116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3863	0	this	m
    //   0	3863	1	paramd	com.tencent.mobileqq.msf.core.d
    //   0	3863	2	paramd1	d
    //   0	3863	3	parama	a
    //   128	2966	4	l1	long
    //   225	1850	6	l2	long
    //   123	3613	8	l3	long
    //   854	10	10	l4	long
    //   211	3623	12	bool	boolean
    //   149	1914	13	localObject1	Object
    //   2067	1	13	localThrowable1	java.lang.Throwable
    //   2072	1	13	localThrowable2	java.lang.Throwable
    //   2081	1	13	localThrowable3	java.lang.Throwable
    //   2089	1	13	str1	String
    //   2094	7	13	localThrowable4	java.lang.Throwable
    //   2106	1749	13	localObject2	Object
    //   263	12	14	localObject3	Object
    //   394	11	14	localThrowable5	java.lang.Throwable
    //   458	12	14	localObject4	Object
    //   912	1	14	localThrowable6	java.lang.Throwable
    //   1086	1019	14	str2	String
    //   2119	10	14	localThrowable7	java.lang.Throwable
    //   2168	1685	14	localObject5	Object
    //   406	1201	15	localObject6	Object
    //   1627	1	15	localThrowable8	java.lang.Throwable
    //   1649	1381	15	localObject7	Object
    //   186	1468	16	localObject8	Object
    //   1817	16	16	localException	Exception
    //   2102	1726	16	localObject9	Object
    //   859	2967	17	localObject10	Object
    //   181	1512	18	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   227	236	390	finally
    //   240	250	390	finally
    //   254	261	390	finally
    //   272	280	390	finally
    //   284	293	390	finally
    //   297	306	390	finally
    //   310	319	390	finally
    //   323	330	390	finally
    //   337	345	390	finally
    //   349	358	390	finally
    //   362	372	390	finally
    //   376	387	390	finally
    //   663	673	390	finally
    //   677	691	390	finally
    //   729	739	390	finally
    //   743	757	390	finally
    //   904	909	390	finally
    //   971	985	390	finally
    //   1018	1028	390	finally
    //   1031	1038	390	finally
    //   227	236	394	java/lang/Throwable
    //   240	250	394	java/lang/Throwable
    //   254	261	394	java/lang/Throwable
    //   272	280	394	java/lang/Throwable
    //   284	293	394	java/lang/Throwable
    //   297	306	394	java/lang/Throwable
    //   310	319	394	java/lang/Throwable
    //   323	330	394	java/lang/Throwable
    //   337	345	394	java/lang/Throwable
    //   349	358	394	java/lang/Throwable
    //   362	372	394	java/lang/Throwable
    //   376	387	394	java/lang/Throwable
    //   663	673	394	java/lang/Throwable
    //   677	691	394	java/lang/Throwable
    //   729	739	394	java/lang/Throwable
    //   743	757	394	java/lang/Throwable
    //   904	909	912	java/lang/Throwable
    //   971	985	912	java/lang/Throwable
    //   1018	1028	912	java/lang/Throwable
    //   1031	1038	912	java/lang/Throwable
    //   1208	1291	1372	java/lang/Throwable
    //   1294	1317	1372	java/lang/Throwable
    //   1333	1362	1372	java/lang/Throwable
    //   1177	1208	1376	finally
    //   1208	1291	1376	finally
    //   1294	1317	1376	finally
    //   1333	1362	1376	finally
    //   1362	1369	1376	finally
    //   1177	1208	1387	java/lang/Throwable
    //   1739	1744	1627	java/lang/Throwable
    //   1756	1765	1627	java/lang/Throwable
    //   1772	1785	1627	java/lang/Throwable
    //   1792	1814	1627	java/lang/Throwable
    //   1826	1837	1627	java/lang/Throwable
    //   1756	1765	1817	java/lang/Exception
    //   1772	1785	1817	java/lang/Exception
    //   1792	1814	1817	java/lang/Exception
    //   1910	1924	1964	java/lang/Throwable
    //   1931	1945	1964	java/lang/Throwable
    //   1952	1961	1964	java/lang/Throwable
    //   1432	1442	2036	java/lang/Throwable
    //   1449	1458	2036	java/lang/Throwable
    //   1465	1475	2036	java/lang/Throwable
    //   1482	1491	2036	java/lang/Throwable
    //   1498	1517	2036	java/lang/Throwable
    //   1524	1533	2036	java/lang/Throwable
    //   1540	1553	2036	java/lang/Throwable
    //   1560	1567	2036	java/lang/Throwable
    //   1577	1585	2036	java/lang/Throwable
    //   1592	1601	2036	java/lang/Throwable
    //   1608	1614	2036	java/lang/Throwable
    //   1651	1659	2036	java/lang/Throwable
    //   1666	1682	2036	java/lang/Throwable
    //   1689	1700	2036	java/lang/Throwable
    //   1707	1715	2036	java/lang/Throwable
    //   1722	1727	2036	java/lang/Throwable
    //   1844	1854	2036	java/lang/Throwable
    //   1861	1874	2036	java/lang/Throwable
    //   1881	1896	2036	java/lang/Throwable
    //   1362	1369	2040	java/lang/Throwable
    //   1391	1425	2040	java/lang/Throwable
    //   1088	1172	2044	finally
    //   1391	1425	2044	finally
    //   1088	1172	2055	java/lang/Throwable
    //   861	897	2067	java/lang/Throwable
    //   917	966	2067	java/lang/Throwable
    //   985	1013	2067	java/lang/Throwable
    //   1041	1070	2067	java/lang/Throwable
    //   1070	1083	2067	java/lang/Throwable
    //   419	428	2072	java/lang/Throwable
    //   432	445	2072	java/lang/Throwable
    //   449	456	2072	java/lang/Throwable
    //   467	475	2072	java/lang/Throwable
    //   479	488	2072	java/lang/Throwable
    //   492	501	2072	java/lang/Throwable
    //   505	514	2072	java/lang/Throwable
    //   518	525	2072	java/lang/Throwable
    //   532	540	2072	java/lang/Throwable
    //   544	553	2072	java/lang/Throwable
    //   557	567	2072	java/lang/Throwable
    //   571	582	2072	java/lang/Throwable
    //   586	591	2072	java/lang/Throwable
    //   595	606	2072	java/lang/Throwable
    //   610	620	2072	java/lang/Throwable
    //   624	632	2072	java/lang/Throwable
    //   636	644	2072	java/lang/Throwable
    //   648	654	2072	java/lang/Throwable
    //   695	710	2072	java/lang/Throwable
    //   714	720	2072	java/lang/Throwable
    //   761	768	2072	java/lang/Throwable
    //   772	780	2072	java/lang/Throwable
    //   784	789	2072	java/lang/Throwable
    //   793	803	2072	java/lang/Throwable
    //   807	814	2072	java/lang/Throwable
    //   818	829	2072	java/lang/Throwable
    //   833	845	2072	java/lang/Throwable
    //   849	856	2072	java/lang/Throwable
    //   188	213	2081	java/lang/Throwable
    //   151	183	2086	finally
    //   188	213	2086	finally
    //   419	428	2086	finally
    //   432	445	2086	finally
    //   449	456	2086	finally
    //   467	475	2086	finally
    //   479	488	2086	finally
    //   492	501	2086	finally
    //   505	514	2086	finally
    //   518	525	2086	finally
    //   532	540	2086	finally
    //   544	553	2086	finally
    //   557	567	2086	finally
    //   571	582	2086	finally
    //   586	591	2086	finally
    //   595	606	2086	finally
    //   610	620	2086	finally
    //   624	632	2086	finally
    //   636	644	2086	finally
    //   648	654	2086	finally
    //   695	710	2086	finally
    //   714	720	2086	finally
    //   761	768	2086	finally
    //   772	780	2086	finally
    //   784	789	2086	finally
    //   793	803	2086	finally
    //   807	814	2086	finally
    //   818	829	2086	finally
    //   833	845	2086	finally
    //   849	856	2086	finally
    //   861	897	2086	finally
    //   917	966	2086	finally
    //   985	1013	2086	finally
    //   1041	1070	2086	finally
    //   1070	1083	2086	finally
    //   151	183	2094	java/lang/Throwable
    //   145	151	2111	finally
    //   145	151	2119	java/lang/Throwable
    //   1432	1442	2408	finally
    //   1449	1458	2408	finally
    //   1465	1475	2408	finally
    //   1482	1491	2408	finally
    //   1498	1517	2408	finally
    //   1524	1533	2408	finally
    //   1540	1553	2408	finally
    //   1560	1567	2408	finally
    //   1577	1585	2408	finally
    //   1592	1601	2408	finally
    //   1608	1614	2408	finally
    //   1651	1659	2408	finally
    //   1666	1682	2408	finally
    //   1689	1700	2408	finally
    //   1707	1715	2408	finally
    //   1722	1727	2408	finally
    //   1739	1744	2408	finally
    //   1756	1765	2408	finally
    //   1772	1785	2408	finally
    //   1792	1814	2408	finally
    //   1826	1837	2408	finally
    //   1844	1854	2408	finally
    //   1861	1874	2408	finally
    //   1881	1896	2408	finally
    //   1910	1924	2408	finally
    //   1931	1945	2408	finally
    //   1952	1961	2408	finally
    //   2384	2391	2408	finally
    //   2398	2405	2408	finally
    //   2444	2451	2408	finally
    //   2482	2489	2408	finally
    //   2520	2527	2408	finally
    //   2534	2541	2408	finally
    //   2572	2579	2408	finally
    //   2610	2617	2408	finally
    //   2648	2655	2408	finally
    //   2721	2728	2408	finally
    //   2759	2766	2408	finally
    //   2797	2804	2408	finally
    //   2835	2842	2408	finally
    //   2873	2880	2408	finally
    //   2911	2918	2408	finally
    //   2949	2956	2408	finally
    //   2971	2978	2408	finally
    //   2993	3004	2408	finally
    //   3011	3022	2408	finally
    //   3041	3048	2408	finally
    //   3305	3366	3432	java/lang/Exception
    //   3369	3374	3432	java/lang/Exception
    //   3374	3378	3432	java/lang/Exception
    //   3381	3390	3432	java/lang/Exception
    //   3390	3417	3432	java/lang/Exception
    //   3420	3429	3432	java/lang/Exception
    //   104	145	3743	java/lang/InterruptedException
    //   1976	2006	3743	java/lang/InterruptedException
    //   2006	2024	3743	java/lang/InterruptedException
    //   2024	2033	3743	java/lang/InterruptedException
    //   3048	3078	3743	java/lang/InterruptedException
    //   3078	3095	3743	java/lang/InterruptedException
    //   3098	3124	3743	java/lang/InterruptedException
    //   3130	3144	3743	java/lang/InterruptedException
    //   3147	3156	3743	java/lang/InterruptedException
    //   3156	3184	3743	java/lang/InterruptedException
    //   3184	3197	3743	java/lang/InterruptedException
    //   3197	3305	3743	java/lang/InterruptedException
    //   3305	3366	3743	java/lang/InterruptedException
    //   3369	3374	3743	java/lang/InterruptedException
    //   3374	3378	3743	java/lang/InterruptedException
    //   3381	3390	3743	java/lang/InterruptedException
    //   3390	3417	3743	java/lang/InterruptedException
    //   3420	3429	3743	java/lang/InterruptedException
    //   3433	3447	3743	java/lang/InterruptedException
    //   3447	3460	3743	java/lang/InterruptedException
    //   3463	3478	3743	java/lang/InterruptedException
    //   3478	3519	3743	java/lang/InterruptedException
    //   3520	3635	3743	java/lang/InterruptedException
    //   3642	3665	3743	java/lang/InterruptedException
    //   3672	3690	3743	java/lang/InterruptedException
    //   3691	3720	3743	java/lang/InterruptedException
    //   3720	3743	3743	java/lang/InterruptedException
    //   3098	3124	3780	java/lang/Exception
    //   3130	3144	3780	java/lang/Exception
    //   3447	3460	3784	java/lang/Exception
    //   2170	2182	3851	finally
    //   2186	2196	3851	finally
    //   2200	2213	3851	finally
    //   2217	2235	3851	finally
    //   2239	2257	3851	finally
    //   2261	2277	3851	finally
    //   2281	2299	3851	finally
    //   2303	2319	3851	finally
    //   2323	2348	3851	finally
    //   2352	2362	3851	finally
    //   2366	2372	3851	finally
    //   2376	2381	3851	finally
    //   2420	2432	3851	finally
    //   2436	2441	3851	finally
    //   2458	2470	3851	finally
    //   2474	2479	3851	finally
    //   2496	2508	3851	finally
    //   2512	2517	3851	finally
    //   2548	2560	3851	finally
    //   2564	2569	3851	finally
    //   2586	2598	3851	finally
    //   2602	2607	3851	finally
    //   2624	2636	3851	finally
    //   2640	2645	3851	finally
    //   2662	2674	3851	finally
    //   2678	2690	3851	finally
    //   2697	2709	3851	finally
    //   2713	2718	3851	finally
    //   2735	2747	3851	finally
    //   2751	2756	3851	finally
    //   2773	2785	3851	finally
    //   2789	2794	3851	finally
    //   2811	2823	3851	finally
    //   2827	2832	3851	finally
    //   2849	2861	3851	finally
    //   2865	2870	3851	finally
    //   2887	2899	3851	finally
    //   2903	2908	3851	finally
    //   2925	2937	3851	finally
    //   2941	2946	3851	finally
    //   2963	2968	3851	finally
    //   3033	3038	3851	finally
    //   2137	2166	3859	finally
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
    //   14: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   17: iconst_0
    //   18: putfield 978	com/tencent/mobileqq/msf/core/ad:q	Z
    //   21: aload_0
    //   22: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   25: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   28: iconst_0
    //   29: putfield 363	com/tencent/mobileqq/msf/core/ad:r	Z
    //   32: aload_0
    //   33: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   36: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   39: lconst_0
    //   40: putfield 980	com/tencent/mobileqq/msf/core/ad:p	J
    //   43: aload_0
    //   44: getfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   47: ifnull +57 -> 104
    //   50: getstatic 982	com/tencent/mobileqq/msf/core/push/e:e	Z
    //   53: ifeq +51 -> 104
    //   56: aload_0
    //   57: getfield 489	com/tencent/mobileqq/msf/core/net/m:c	Ljava/net/InetSocketAddress;
    //   60: invokevirtual 726	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   63: invokestatic 942	com/tencent/qphone/base/util/g:b	(Ljava/lang/String;)J
    //   66: putstatic 984	com/tencent/mobileqq/msf/core/push/e:c	J
    //   69: iconst_0
    //   70: putstatic 982	com/tencent/mobileqq/msf/core/push/e:e	Z
    //   73: goto +31 -> 104
    //   76: astore_1
    //   77: goto +21 -> 98
    //   80: ldc2_w 947
    //   83: putstatic 984	com/tencent/mobileqq/msf/core/push/e:c	J
    //   86: ldc 204
    //   88: iconst_1
    //   89: ldc_w 986
    //   92: invokestatic 952	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: goto -26 -> 69
    //   98: iconst_0
    //   99: putstatic 982	com/tencent/mobileqq/msf/core/push/e:e	Z
    //   102: aload_1
    //   103: athrow
    //   104: invokestatic 992	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   107: invokevirtual 995	java/lang/Thread:getName	()Ljava/lang/String;
    //   110: astore 6
    //   112: new 179	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   119: astore 7
    //   121: aload 7
    //   123: ldc_w 997
    //   126: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 7
    //   132: aload_1
    //   133: invokevirtual 701	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: ldc 204
    //   139: iconst_1
    //   140: iconst_2
    //   141: anewarray 4	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: aload 6
    //   148: aastore
    //   149: dup
    //   150: iconst_1
    //   151: aload 7
    //   153: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: aastore
    //   157: invokestatic 796	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   160: aload_0
    //   161: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   164: astore 6
    //   166: getstatic 1000	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   169: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   172: ifnull +90 -> 262
    //   175: aload_0
    //   176: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   179: astore 6
    //   181: getstatic 1000	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   184: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   187: getfield 770	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   190: ifnull +72 -> 262
    //   193: aload_0
    //   194: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   197: astore 6
    //   199: getstatic 1000	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   202: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   205: getfield 770	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   208: getfield 778	com/tencent/mobileqq/msf/core/d/j$c:g	J
    //   211: lconst_0
    //   212: lcmp
    //   213: ifne +49 -> 262
    //   216: aload_0
    //   217: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   220: astore 6
    //   222: getstatic 1000	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   225: getfield 764	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   228: getfield 770	com/tencent/mobileqq/msf/core/d/j:Y	Lcom/tencent/mobileqq/msf/core/d/j$c;
    //   231: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   234: putfield 778	com/tencent/mobileqq/msf/core/d/j$c:g	J
    //   237: ldc 204
    //   239: iconst_1
    //   240: iconst_2
    //   241: anewarray 4	java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: ldc_w 1002
    //   249: aastore
    //   250: dup
    //   251: iconst_1
    //   252: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   255: invokestatic 269	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   258: aastore
    //   259: invokestatic 796	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   262: aload_0
    //   263: getfield 245	com/tencent/mobileqq/msf/core/net/m:y	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   266: ifnull +22 -> 288
    //   269: aload_0
    //   270: invokevirtual 502	com/tencent/mobileqq/msf/core/net/m:h	()Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   273: pop
    //   274: aload_0
    //   275: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   278: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   281: aload_0
    //   282: getfield 504	com/tencent/mobileqq/msf/core/net/m:F	Ljava/lang/Runnable;
    //   285: invokevirtual 507	com/tencent/mobileqq/msf/core/ad:a	(Ljava/lang/Runnable;)V
    //   288: aload_0
    //   289: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   292: ifnonnull +40 -> 332
    //   295: new 179	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   302: astore 6
    //   304: aload 6
    //   306: ldc_w 1004
    //   309: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 6
    //   315: aload_1
    //   316: invokevirtual 701	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: ldc 204
    //   322: iconst_1
    //   323: aload 6
    //   325: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: return
    //   332: invokestatic 1007	com/tencent/mobileqq/msf/core/a/a:aI	()Z
    //   335: ifeq +75 -> 410
    //   338: getstatic 424	com/tencent/mobileqq/msf/core/ad:s	Z
    //   341: ifeq +73 -> 414
    //   344: invokestatic 428	com/tencent/mobileqq/msf/core/net/a/f:a	()Z
    //   347: ifeq +67 -> 414
    //   350: ldc 204
    //   352: iconst_1
    //   353: ldc_w 1009
    //   356: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: aload_0
    //   360: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   363: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   366: getfield 433	com/tencent/mobileqq/msf/core/ad:I	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   369: ifnull +45 -> 414
    //   372: aload_0
    //   373: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   376: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   379: getfield 433	com/tencent/mobileqq/msf/core/ad:I	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   382: invokevirtual 436	com/tencent/mobileqq/msf/core/net/a/f:b	()Lcom/tencent/mobileqq/msf/core/net/a/e;
    //   385: invokeinterface 1010 1 0
    //   390: goto +24 -> 414
    //   393: astore 6
    //   395: getstatic 1014	com/tencent/mobileqq/msf/core/net/a/a:a	Ljava/lang/String;
    //   398: iconst_1
    //   399: ldc_w 1016
    //   402: aload 6
    //   404: invokestatic 323	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   407: goto +7 -> 414
    //   410: iconst_0
    //   411: putstatic 424	com/tencent/mobileqq/msf/core/ad:s	Z
    //   414: ldc 82
    //   416: astore 7
    //   418: invokestatic 1017	com/tencent/mobileqq/a/a/f:a	()V
    //   421: invokestatic 298	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   424: aload_1
    //   425: invokevirtual 1019	com/tencent/mobileqq/a/a/a:a	(Lcom/tencent/qphone/base/a;)V
    //   428: invokestatic 1024	com/tencent/mobileqq/a/a/a$b:a	()Lcom/tencent/mobileqq/a/a/a$b;
    //   431: aload_1
    //   432: invokevirtual 1025	com/tencent/mobileqq/a/a/a$b:a	(Lcom/tencent/qphone/base/a;)V
    //   435: invokestatic 1028	com/tencent/mobileqq/msf/core/a/a:aH	()Z
    //   438: ifeq +6 -> 444
    //   441: invokestatic 1031	com/tencent/mobileqq/a/a/d:a	()V
    //   444: aload_0
    //   445: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   448: invokevirtual 1032	com/tencent/mobileqq/msf/core/net/h:toString	()Ljava/lang/String;
    //   451: astore 6
    //   453: aload 6
    //   455: astore 7
    //   457: aload_0
    //   458: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   461: ldc2_w 517
    //   464: getstatic 524	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   467: invokevirtual 528	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   470: istore_2
    //   471: iload_2
    //   472: ifeq +199 -> 671
    //   475: aload_0
    //   476: getfield 95	com/tencent/mobileqq/msf/core/net/m:s	Ljava/util/concurrent/atomic/AtomicInteger;
    //   479: iconst_0
    //   480: invokevirtual 749	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   483: aload_0
    //   484: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   487: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   490: aconst_null
    //   491: invokevirtual 901	com/tencent/mobileqq/msf/core/ad:a	([B)V
    //   494: aload_0
    //   495: getfield 100	com/tencent/mobileqq/msf/core/net/m:v	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   498: invokevirtual 342	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   501: istore_3
    //   502: aload_0
    //   503: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   506: ifnull +14 -> 520
    //   509: aload_0
    //   510: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   513: getfield 1034	com/tencent/mobileqq/msf/core/net/m$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   516: iconst_0
    //   517: invokevirtual 497	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   520: aload_0
    //   521: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   524: invokevirtual 1038	com/tencent/mobileqq/msf/core/net/h:getInputStream	()Ljava/io/InputStream;
    //   527: ifnull +13 -> 540
    //   530: aload_0
    //   531: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   534: invokevirtual 1038	com/tencent/mobileqq/msf/core/net/h:getInputStream	()Ljava/io/InputStream;
    //   537: invokevirtual 1043	java/io/InputStream:close	()V
    //   540: aload_0
    //   541: getfield 76	com/tencent/mobileqq/msf/core/net/m:h	Ljava/io/OutputStream;
    //   544: astore 7
    //   546: aload 7
    //   548: ifnull +24 -> 572
    //   551: getstatic 69	com/tencent/mobileqq/msf/core/net/m:q	Ljava/util/ArrayList;
    //   554: aload_0
    //   555: getfield 76	com/tencent/mobileqq/msf/core/net/m:h	Ljava/io/OutputStream;
    //   558: invokevirtual 651	java/lang/Object:toString	()Ljava/lang/String;
    //   561: invokevirtual 1045	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   564: pop
    //   565: aload_0
    //   566: getfield 76	com/tencent/mobileqq/msf/core/net/m:h	Ljava/io/OutputStream;
    //   569: invokevirtual 1046	java/io/OutputStream:close	()V
    //   572: aload_0
    //   573: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   576: astore 7
    //   578: aload 7
    //   580: ifnull +40 -> 620
    //   583: aload_0
    //   584: getfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   587: invokevirtual 1047	com/tencent/mobileqq/msf/core/net/h:close	()V
    //   590: aload_1
    //   591: invokestatic 1050	com/tencent/mobileqq/msf/core/aj:a	(Lcom/tencent/qphone/base/a;)V
    //   594: aload_0
    //   595: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   598: invokevirtual 1054	com/tencent/mobileqq/msf/core/MsfCore:getStandyModeManager	()Lcom/tencent/mobileqq/msf/core/e/a;
    //   601: invokevirtual 1057	com/tencent/mobileqq/msf/core/e/a:f	()V
    //   604: goto +10 -> 614
    //   607: astore 7
    //   609: aload 7
    //   611: invokevirtual 1058	java/lang/Throwable:printStackTrace	()V
    //   614: getstatic 69	com/tencent/mobileqq/msf/core/net/m:q	Ljava/util/ArrayList;
    //   617: invokevirtual 910	java/util/ArrayList:clear	()V
    //   620: aload_0
    //   621: aconst_null
    //   622: putfield 410	com/tencent/mobileqq/msf/core/net/m:g	Lcom/tencent/mobileqq/msf/core/net/h;
    //   625: aload_0
    //   626: getfield 100	com/tencent/mobileqq/msf/core/net/m:v	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   629: iconst_0
    //   630: invokevirtual 497	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   633: aload_0
    //   634: aconst_null
    //   635: putfield 344	com/tencent/mobileqq/msf/core/net/m:i	Lcom/tencent/mobileqq/msf/core/net/d;
    //   638: iload_3
    //   639: istore_2
    //   640: aload_0
    //   641: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   644: invokevirtual 783	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   647: iload_3
    //   648: istore_2
    //   649: goto +156 -> 805
    //   652: iload_3
    //   653: istore_2
    //   654: aload_0
    //   655: getfield 128	com/tencent/mobileqq/msf/core/net/m:E	Ljava/util/concurrent/locks/ReentrantLock;
    //   658: invokevirtual 783	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   661: iload_3
    //   662: istore_2
    //   663: aload 7
    //   665: athrow
    //   666: astore 7
    //   668: goto +98 -> 766
    //   671: aload 6
    //   673: astore 7
    //   675: aload_0
    //   676: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   679: ifnull +18 -> 697
    //   682: aload 6
    //   684: astore 7
    //   686: aload_0
    //   687: getfield 78	com/tencent/mobileqq/msf/core/net/m:j	Lcom/tencent/mobileqq/msf/core/net/m$a;
    //   690: getfield 1034	com/tencent/mobileqq/msf/core/net/m$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   693: iconst_0
    //   694: invokevirtual 497	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   697: aload 6
    //   699: astore 7
    //   701: ldc 204
    //   703: iconst_1
    //   704: ldc_w 1060
    //   707: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   710: aload 6
    //   712: astore 7
    //   714: aload_0
    //   715: getfield 102	com/tencent/mobileqq/msf/core/net/m:w	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   718: iconst_1
    //   719: invokevirtual 497	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   722: aload 6
    //   724: astore 7
    //   726: aload_0
    //   727: getfield 95	com/tencent/mobileqq/msf/core/net/m:s	Ljava/util/concurrent/atomic/AtomicInteger;
    //   730: iconst_1
    //   731: invokevirtual 1063	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   734: bipush 10
    //   736: if_icmpne +13 -> 749
    //   739: aload 6
    //   741: astore 7
    //   743: invokestatic 1068	android/os/Process:myPid	()I
    //   746: invokestatic 1071	android/os/Process:killProcess	(I)V
    //   749: iconst_1
    //   750: istore_2
    //   751: goto +54 -> 805
    //   754: astore 8
    //   756: iconst_1
    //   757: istore_2
    //   758: aload 7
    //   760: astore 6
    //   762: aload 8
    //   764: astore 7
    //   766: new 179	java/lang/StringBuilder
    //   769: dup
    //   770: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   773: astore 8
    //   775: aload 8
    //   777: ldc_w 1073
    //   780: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: pop
    //   784: aload 8
    //   786: aload 7
    //   788: invokevirtual 701	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   791: pop
    //   792: ldc 204
    //   794: iconst_1
    //   795: aload 8
    //   797: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   800: aload 7
    //   802: invokestatic 323	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   805: aload_0
    //   806: getfield 102	com/tencent/mobileqq/msf/core/net/m:w	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   809: invokevirtual 342	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   812: ifne +387 -> 1199
    //   815: iload_2
    //   816: ifeq +383 -> 1199
    //   819: aload_0
    //   820: getfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   823: lconst_0
    //   824: lcmp
    //   825: ifle +123 -> 948
    //   828: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   831: aload_0
    //   832: getfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   835: lsub
    //   836: lstore 4
    //   838: aload_0
    //   839: lconst_0
    //   840: putfield 106	com/tencent/mobileqq/msf/core/net/m:z	J
    //   843: aload_0
    //   844: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   847: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   850: invokevirtual 1075	com/tencent/mobileqq/msf/core/ad:e	()[B
    //   853: invokestatic 1081	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   856: astore 7
    //   858: invokestatic 1084	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getCurrentAPN	()Ljava/lang/String;
    //   861: astore 8
    //   863: aload_0
    //   864: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   867: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   870: getfield 632	com/tencent/mobileqq/msf/core/ad:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   873: invokevirtual 1086	com/tencent/mobileqq/msf/core/net/n:g	()V
    //   876: aload_0
    //   877: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   880: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/ad;
    //   883: getfield 632	com/tencent/mobileqq/msf/core/ad:b	Lcom/tencent/mobileqq/msf/core/net/n;
    //   886: lconst_0
    //   887: putfield 1088	com/tencent/mobileqq/msf/core/net/n:m	J
    //   890: aload_0
    //   891: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   894: invokevirtual 760	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   897: ifnull +51 -> 948
    //   900: aload_0
    //   901: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   904: invokevirtual 760	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/d/j;
    //   907: iconst_0
    //   908: lload 4
    //   910: ldc2_w 1089
    //   913: ldiv
    //   914: aload_0
    //   915: getfield 349	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   918: aload_1
    //   919: getstatic 714	com/tencent/mobileqq/msf/core/ad:H	I
    //   922: lload 4
    //   924: aload_0
    //   925: getfield 121	com/tencent/mobileqq/msf/core/net/m:C	Ljava/util/concurrent/atomic/AtomicLong;
    //   928: invokevirtual 1092	java/util/concurrent/atomic/AtomicLong:get	()J
    //   931: aload_0
    //   932: getfield 123	com/tencent/mobileqq/msf/core/net/m:D	Ljava/util/concurrent/atomic/AtomicLong;
    //   935: invokevirtual 1092	java/util/concurrent/atomic/AtomicLong:get	()J
    //   938: aload 7
    //   940: aload 8
    //   942: invokevirtual 1095	com/tencent/mobileqq/msf/core/d/j:a	(ZJLcom/tencent/mobileqq/msf/core/d;Lcom/tencent/qphone/base/a;IJJJLjava/lang/String;Ljava/lang/String;)V
    //   945: goto +3 -> 948
    //   948: invokestatic 456	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   951: ifeq +59 -> 1010
    //   954: new 179	java/lang/StringBuilder
    //   957: dup
    //   958: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   961: astore 7
    //   963: aload 7
    //   965: ldc_w 1097
    //   968: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: pop
    //   972: aload 7
    //   974: aload 6
    //   976: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: pop
    //   980: aload 7
    //   982: ldc_w 1099
    //   985: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: pop
    //   989: aload 7
    //   991: aload_1
    //   992: invokevirtual 701	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: ldc 204
    //   998: iconst_1
    //   999: aload 7
    //   1001: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1004: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1007: goto +59 -> 1066
    //   1010: new 179	java/lang/StringBuilder
    //   1013: dup
    //   1014: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   1017: astore 7
    //   1019: aload 7
    //   1021: ldc_w 1097
    //   1024: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: pop
    //   1028: aload 7
    //   1030: aload 6
    //   1032: invokestatic 486	com/tencent/mobileqq/msf/core/b/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1035: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: pop
    //   1039: aload 7
    //   1041: ldc_w 1099
    //   1044: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: pop
    //   1048: aload 7
    //   1050: aload_1
    //   1051: invokevirtual 701	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1054: pop
    //   1055: ldc 204
    //   1057: iconst_1
    //   1058: aload 7
    //   1060: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1063: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1066: aload_0
    //   1067: getfield 349	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   1070: ifnull +28 -> 1098
    //   1073: aload_0
    //   1074: getfield 349	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   1077: aload_1
    //   1078: invokevirtual 1102	com/tencent/mobileqq/msf/core/d:a	(Lcom/tencent/qphone/base/a;)Z
    //   1081: ifeq +17 -> 1098
    //   1084: aload_0
    //   1085: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1088: invokevirtual 1106	com/tencent/mobileqq/msf/core/MsfCore:getSsoListManager	()Lcom/tencent/mobileqq/msf/core/a/c;
    //   1091: aload_0
    //   1092: getfield 349	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   1095: invokevirtual 1111	com/tencent/mobileqq/msf/core/a/c:a	(Lcom/tencent/mobileqq/msf/core/d;)V
    //   1098: ldc_w 743
    //   1101: putstatic 694	com/tencent/mobileqq/msf/core/ad:E	Ljava/lang/String;
    //   1104: ldc 144
    //   1106: putstatic 708	com/tencent/mobileqq/msf/core/ad:F	Ljava/lang/String;
    //   1109: goto +10 -> 1119
    //   1112: astore 6
    //   1114: aload 6
    //   1116: invokevirtual 318	java/lang/Exception:printStackTrace	()V
    //   1119: aload_0
    //   1120: aconst_null
    //   1121: putfield 349	com/tencent/mobileqq/msf/core/net/m:d	Lcom/tencent/mobileqq/msf/core/d;
    //   1124: aload_0
    //   1125: getfield 130	com/tencent/mobileqq/msf/core/net/m:r	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   1128: aconst_null
    //   1129: putfield 913	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   1132: aload_0
    //   1133: getfield 121	com/tencent/mobileqq/msf/core/net/m:C	Ljava/util/concurrent/atomic/AtomicLong;
    //   1136: lconst_0
    //   1137: invokevirtual 646	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   1140: aload_0
    //   1141: getfield 123	com/tencent/mobileqq/msf/core/net/m:D	Ljava/util/concurrent/atomic/AtomicLong;
    //   1144: lconst_0
    //   1145: invokevirtual 646	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   1148: invokestatic 1116	com/tencent/qphone/base/util/CodecWarpper:nativeOnConnClose	()V
    //   1151: goto +44 -> 1195
    //   1154: astore 6
    //   1156: new 179	java/lang/StringBuilder
    //   1159: dup
    //   1160: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   1163: astore 7
    //   1165: aload 7
    //   1167: ldc_w 1118
    //   1170: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: pop
    //   1174: aload 7
    //   1176: aload 6
    //   1178: invokevirtual 701	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1181: pop
    //   1182: ldc 204
    //   1184: iconst_1
    //   1185: aload 7
    //   1187: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1190: aload 6
    //   1192: invokestatic 323	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1195: aload_1
    //   1196: invokestatic 1121	com/tencent/mobileqq/msf/core/NetConnInfoCenter:onConnClosed	(Lcom/tencent/qphone/base/a;)V
    //   1199: return
    //   1200: astore 6
    //   1202: goto -1122 -> 80
    //   1205: astore 7
    //   1207: goto -667 -> 540
    //   1210: astore 7
    //   1212: goto -640 -> 572
    //   1215: astore 7
    //   1217: goto -597 -> 620
    //   1220: astore 7
    //   1222: goto -570 -> 652
    //   1225: astore 7
    //   1227: iconst_1
    //   1228: istore_3
    //   1229: goto -577 -> 652
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1232	0	this	m
    //   0	1232	1	parama	com.tencent.qphone.base.a
    //   470	346	2	bool1	boolean
    //   501	728	3	bool2	boolean
    //   836	87	4	l1	long
    //   110	214	6	localObject1	Object
    //   393	10	6	localException1	Exception
    //   451	580	6	localObject2	Object
    //   1112	3	6	localException2	Exception
    //   1154	37	6	localException3	Exception
    //   1200	1	6	localException4	Exception
    //   119	460	7	localObject3	Object
    //   607	57	7	localThrowable1	java.lang.Throwable
    //   666	1	7	localThrowable2	java.lang.Throwable
    //   673	513	7	localObject4	Object
    //   1205	1	7	localThrowable3	java.lang.Throwable
    //   1210	1	7	localException5	Exception
    //   1215	1	7	localThrowable4	java.lang.Throwable
    //   1220	1	7	localObject5	Object
    //   1225	1	7	localObject6	Object
    //   754	9	8	localThrowable5	java.lang.Throwable
    //   773	168	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   56	69	76	finally
    //   80	95	76	finally
    //   350	390	393	java/lang/Exception
    //   590	604	607	java/lang/Throwable
    //   640	647	666	java/lang/Throwable
    //   654	661	666	java/lang/Throwable
    //   663	666	666	java/lang/Throwable
    //   444	453	754	java/lang/Throwable
    //   457	471	754	java/lang/Throwable
    //   675	682	754	java/lang/Throwable
    //   686	697	754	java/lang/Throwable
    //   701	710	754	java/lang/Throwable
    //   714	722	754	java/lang/Throwable
    //   726	739	754	java/lang/Throwable
    //   743	749	754	java/lang/Throwable
    //   1066	1098	1112	java/lang/Exception
    //   1098	1109	1112	java/lang/Exception
    //   1148	1151	1154	java/lang/Exception
    //   56	69	1200	java/lang/Exception
    //   520	540	1205	java/lang/Throwable
    //   551	572	1210	java/lang/Exception
    //   583	590	1215	java/lang/Throwable
    //   609	614	1215	java/lang/Throwable
    //   614	620	1215	java/lang/Throwable
    //   502	520	1220	finally
    //   520	540	1220	finally
    //   540	546	1220	finally
    //   551	572	1220	finally
    //   572	578	1220	finally
    //   583	590	1220	finally
    //   590	604	1220	finally
    //   609	614	1220	finally
    //   614	620	1220	finally
    //   620	638	1220	finally
    //   475	502	1225	finally
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("msgSignal seq: ");
      ((StringBuilder)localObject).append(localToServiceMsg.getRequestSsoSeq());
      QLog.d("MSF.C.NetConnTag", 1, ((StringBuilder)localObject).toString());
      int i1 = "CHNK".getBytes().length + 13 + 1 + 0 + 4;
      byte b1 = (byte)("CHNK".getBytes().length + 1);
      localObject = ByteBuffer.allocate(i1);
      ((ByteBuffer)localObject).putInt(i1).putInt(20140601).putInt(0).put(b1).put("CHNK".getBytes()).put((byte)1).putInt(0);
      localToServiceMsg.putWupBuffer(((ByteBuffer)localObject).array());
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
    h localh = this.g;
    if (localh == null) {
      return 0;
    }
    return localh.hashCode();
  }
  
  public int j()
  {
    if (this.v.get())
    {
      com.tencent.mobileqq.msf.core.d locald = this.d;
      if (locald != null) {
        return locald.d();
      }
    }
    return 0;
  }
  
  public long k()
  {
    return this.C.get();
  }
  
  public long l()
  {
    h localh = this.g;
    if (localh != null) {
      return localh.a();
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.m
 * JD-Core Version:    0.7.0.1
 */