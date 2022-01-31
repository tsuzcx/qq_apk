package com.tencent.mobileqq.msf.core.net;

import android.os.SystemClock;
import com.tencent.mobileqq.a.a.a.c;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.af;
import com.tencent.mobileqq.msf.core.b.c;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.net.a.e;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
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

public class l
{
  public static int A = 0;
  public static final int a = -100;
  public static final int b = -200;
  public static ArrayList n = new ArrayList();
  public com.tencent.mobileqq.msf.core.d B;
  private AtomicInteger C = new AtomicInteger();
  private long D;
  private long E;
  private boolean F = true;
  private long G = SystemClock.uptimeMillis();
  protected InetSocketAddress c;
  com.tencent.mobileqq.msf.core.d d;
  int e;
  int f = 30000;
  public Socket g;
  OutputStream h = null;
  public d i;
  a j = null;
  MsfSocketInputBuffer k = null;
  public String l = "";
  public int m;
  AtomicLong o = new AtomicLong();
  AtomicLong p = new AtomicLong();
  long q = 0L;
  boolean r = false;
  AtomicBoolean s = new AtomicBoolean();
  AtomicBoolean t = new AtomicBoolean();
  AtomicBoolean u = new AtomicBoolean();
  ReentrantLock v = new ReentrantLock();
  boolean w;
  ToServiceMsg x;
  Runnable y;
  MsfCore z;
  
  public l(MsfCore paramMsfCore, boolean paramBoolean)
  {
    this.z = paramMsfCore;
    this.w = paramBoolean;
  }
  
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    for (Object localObject = paramThrowable; localObject != null; localObject = ((Throwable)localObject).getCause()) {
      if ((localObject instanceof UnknownHostException)) {
        return "";
      }
    }
    localObject = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter((Writer)localObject);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    return ((StringWriter)localObject).toString();
  }
  
  private void a(com.tencent.mobileqq.msf.core.d paramd)
  {
    a.c.a().a(false, paramd);
  }
  
  private void h()
  {
    if ((this.z != null) && (this.z.pushManager != null) && (this.z.pushManager.aq != null))
    {
      this.z.sendSsoMsg(this.z.pushManager.aq);
      this.z.pushManager.aq = null;
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, MsfCommand paramMsfCommand, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg)
    throws IOException
  {
    if ((this.u.get()) || (!this.s.get()) || (this.i == null)) {
      return -100;
    }
    if (paramMsfCommand == MsfCommand.openConn) {}
    for (;;)
    {
      return paramArrayOfByte.length;
      paramString3 = this.i.a(this.d, paramString1, paramString2, paramArrayOfByte);
      if (paramString2.equals("SSO.LoginMerge"))
      {
        if (!this.z.sender.q)
        {
          paramString1 = (ArrayList)this.z.sender.d.remove(Integer.valueOf(paramInt3));
          QLog.d("MSF.C.NetConnTag", 1, "NetChanged devide merge package, " + Arrays.toString(paramString1.toArray()) + " resend.");
          if (paramString1 != null)
          {
            paramString1 = paramString1.iterator();
            while (paramString1.hasNext())
            {
              paramString2 = (Integer)paramString1.next();
              paramString2 = this.z.sender.c(paramString2.intValue());
              this.z.sender.b(paramString2);
            }
          }
          return -200;
        }
        if (paramToServiceMsg != null) {
          this.z.sender.a(paramToServiceMsg, this.g.hashCode());
        }
        label241:
        if ((!af.s) || (!com.tencent.mobileqq.msf.core.net.a.f.a())) {
          break label554;
        }
        QLog.d("MSF.C.NetConnTag", 1, "send data in socket adaptor way");
      }
      for (;;)
      {
        try
        {
          if (this.z.sender.J != null) {
            this.z.sender.J.b().a(paramString3, this.g, paramInt3);
          }
          this.o.addAndGet(paramString3.length);
          paramString3 = new StringBuilder();
          if (!QLog.isDevelopLevel()) {
            break label573;
          }
          QLog.d("MSF.C.NetConnTag", 1, "netSend appid:" + paramInt1 + " appSeq:" + paramInt2 + " ssoSeq:" + paramInt3 + " uin:" + MsfSdkUtils.getShortUin(paramString1) + " cmd:" + paramString2 + " len:" + paramArrayOfByte.length + new StringBuilder().append(" ").append(Integer.toHexString(this.g.hashCode())).toString());
          break;
          if (paramString2.equals("RegPrxySvc.infoLogin"))
          {
            this.z.sender.a(paramToServiceMsg, this.g.hashCode());
            break label241;
          }
          if (paramString2.equals("RegPrxySvc.getOffMsg"))
          {
            this.z.sender.a(paramToServiceMsg, this.g.hashCode());
            break label241;
          }
          if (!paramString2.equals("RegPrxySvc.infoSync")) {
            break label241;
          }
          this.z.sender.a(paramToServiceMsg, this.g.hashCode());
        }
        catch (Exception paramMsfCommand)
        {
          QLog.d("MSF.C.NetConnTag", 1, "", paramMsfCommand);
          continue;
        }
        label554:
        this.h.write(paramString3);
        this.h.flush();
      }
      label573:
      QLog.d("MSF.C.NetConnTag", 1, "netSend ssoSeq:" + paramInt3 + " uin:" + MsfSdkUtils.getShortUin(paramString1) + " cmd:" + c.a(paramString2) + new StringBuilder().append(" ").append(paramArrayOfByte.length + paramInt3).toString() + new StringBuilder().append(" ").append(Integer.toHexString(this.g.hashCode())).toString());
    }
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.msf.core.d paramd, int paramInt1, int paramInt2, d paramd1, boolean paramBoolean, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 114	com/tencent/mobileqq/msf/core/net/l:u	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 195	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifne +13 -> 20
    //   10: aload_0
    //   11: getfield 110	com/tencent/mobileqq/msf/core/net/l:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   14: invokevirtual 195	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   17: ifne +28 -> 45
    //   20: aload_0
    //   21: getfield 114	com/tencent/mobileqq/msf/core/net/l:u	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   24: invokevirtual 195	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   27: ifeq +18 -> 45
    //   30: aload_0
    //   31: getfield 114	com/tencent/mobileqq/msf/core/net/l:u	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   34: iconst_0
    //   35: invokevirtual 382	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   38: aload_0
    //   39: getstatic 387	com/tencent/qphone/base/a:f	Lcom/tencent/qphone/base/a;
    //   42: invokevirtual 390	com/tencent/mobileqq/msf/core/net/l:a	(Lcom/tencent/qphone/base/a;)V
    //   45: aload_0
    //   46: getfield 392	com/tencent/mobileqq/msf/core/net/l:x	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   49: ifnull +22 -> 71
    //   52: aload_0
    //   53: invokevirtual 395	com/tencent/mobileqq/msf/core/net/l:g	()Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   56: pop
    //   57: aload_0
    //   58: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   61: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   64: aload_0
    //   65: getfield 397	com/tencent/mobileqq/msf/core/net/l:y	Ljava/lang/Runnable;
    //   68: invokevirtual 400	com/tencent/mobileqq/msf/core/af:a	(Ljava/lang/Runnable;)V
    //   71: aload_0
    //   72: aload_1
    //   73: putfield 205	com/tencent/mobileqq/msf/core/net/l:d	Lcom/tencent/mobileqq/msf/core/d;
    //   76: aload_0
    //   77: aload 4
    //   79: putfield 197	com/tencent/mobileqq/msf/core/net/l:i	Lcom/tencent/mobileqq/msf/core/net/d;
    //   82: aload_0
    //   83: iload 5
    //   85: putfield 105	com/tencent/mobileqq/msf/core/net/l:r	Z
    //   88: aload_0
    //   89: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   92: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   95: aload_1
    //   96: invokevirtual 404	com/tencent/mobileqq/msf/core/d:h	()Z
    //   99: putfield 226	com/tencent/mobileqq/msf/core/af:q	Z
    //   102: getstatic 409	com/tencent/mobileqq/msf/core/net/v:b	Lcom/tencent/mobileqq/msf/core/net/v;
    //   105: astore 16
    //   107: ldc 87
    //   109: astore 17
    //   111: aload_0
    //   112: lconst_0
    //   113: putfield 103	com/tencent/mobileqq/msf/core/net/l:q	J
    //   116: aload_0
    //   117: getfield 119	com/tencent/mobileqq/msf/core/net/l:v	Ljava/util/concurrent/locks/ReentrantLock;
    //   120: ldc2_w 410
    //   123: getstatic 417	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   126: invokevirtual 421	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   129: ifeq +2517 -> 2646
    //   132: invokestatic 424	android/os/SystemClock:elapsedRealtime	()J
    //   135: lstore 11
    //   137: invokestatic 429	java/lang/System:currentTimeMillis	()J
    //   140: lstore 9
    //   142: aload_0
    //   143: invokestatic 429	java/lang/System:currentTimeMillis	()J
    //   146: putfield 431	com/tencent/mobileqq/msf/core/net/l:E	J
    //   149: aload_0
    //   150: aload_1
    //   151: invokespecial 433	com/tencent/mobileqq/msf/core/net/l:a	(Lcom/tencent/mobileqq/msf/core/d;)V
    //   154: aload 17
    //   156: astore 14
    //   158: lload 9
    //   160: lstore 7
    //   162: aload 16
    //   164: astore 13
    //   166: aload 17
    //   168: astore 15
    //   170: aload 16
    //   172: astore 4
    //   174: aload_0
    //   175: new 435	java/net/InetSocketAddress
    //   178: dup
    //   179: aload_1
    //   180: invokevirtual 437	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   183: aload_1
    //   184: invokevirtual 439	com/tencent/mobileqq/msf/core/d:d	()I
    //   187: invokespecial 442	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   190: putfield 444	com/tencent/mobileqq/msf/core/net/l:c	Ljava/net/InetSocketAddress;
    //   193: aload 17
    //   195: astore 14
    //   197: lload 9
    //   199: lstore 7
    //   201: aload 16
    //   203: astore 13
    //   205: aload 17
    //   207: astore 15
    //   209: aload 16
    //   211: astore 4
    //   213: invokestatic 449	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   216: invokevirtual 451	com/tencent/mobileqq/a/a/a:c	()V
    //   219: aload 17
    //   221: astore 14
    //   223: lload 9
    //   225: lstore 7
    //   227: aload 16
    //   229: astore 13
    //   231: aload 17
    //   233: astore 15
    //   235: aload 16
    //   237: astore 4
    //   239: new 245	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   246: astore 19
    //   248: aload 17
    //   250: astore 14
    //   252: lload 9
    //   254: lstore 7
    //   256: aload 16
    //   258: astore 13
    //   260: aload 17
    //   262: astore 15
    //   264: aload 16
    //   266: astore 4
    //   268: aload 19
    //   270: ldc_w 453
    //   273: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_1
    //   277: invokevirtual 454	com/tencent/mobileqq/msf/core/d:toString	()Ljava/lang/String;
    //   280: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: astore 20
    //   285: aload 17
    //   287: astore 14
    //   289: lload 9
    //   291: lstore 7
    //   293: aload 16
    //   295: astore 13
    //   297: aload 17
    //   299: astore 15
    //   301: aload 16
    //   303: astore 4
    //   305: aload_1
    //   306: getfield 456	com/tencent/mobileqq/msf/core/d:i	Z
    //   309: ifeq +2338 -> 2647
    //   312: ldc_w 458
    //   315: astore 18
    //   317: aload 17
    //   319: astore 14
    //   321: lload 9
    //   323: lstore 7
    //   325: aload 16
    //   327: astore 13
    //   329: aload 17
    //   331: astore 15
    //   333: aload 16
    //   335: astore 4
    //   337: aload 20
    //   339: aload 18
    //   341: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: ldc_w 460
    //   347: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokestatic 465	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetworkType	()I
    //   353: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: ldc_w 467
    //   359: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: astore 20
    //   364: aload 17
    //   366: astore 14
    //   368: lload 9
    //   370: lstore 7
    //   372: aload 16
    //   374: astore 13
    //   376: aload 17
    //   378: astore 15
    //   380: aload 16
    //   382: astore 4
    //   384: aload_1
    //   385: invokestatic 472	com/tencent/mobileqq/msf/core/net/i:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   388: ifeq +4001 -> 4389
    //   391: ldc_w 474
    //   394: astore 18
    //   396: aload 17
    //   398: astore 14
    //   400: lload 9
    //   402: lstore 7
    //   404: aload 16
    //   406: astore 13
    //   408: aload 17
    //   410: astore 15
    //   412: aload 16
    //   414: astore 4
    //   416: ldc 243
    //   418: iconst_1
    //   419: aload 20
    //   421: aload 18
    //   423: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload 17
    //   434: astore 14
    //   436: lload 9
    //   438: lstore 7
    //   440: aload 16
    //   442: astore 13
    //   444: aload 17
    //   446: astore 15
    //   448: aload 16
    //   450: astore 4
    //   452: invokestatic 429	java/lang/System:currentTimeMillis	()J
    //   455: lstore 9
    //   457: aload 17
    //   459: astore 14
    //   461: lload 9
    //   463: lstore 7
    //   465: aload 16
    //   467: astore 13
    //   469: aload 17
    //   471: astore 15
    //   473: aload 16
    //   475: astore 4
    //   477: aload_0
    //   478: lload 9
    //   480: putfield 476	com/tencent/mobileqq/msf/core/net/l:D	J
    //   483: aload 17
    //   485: astore 14
    //   487: lload 9
    //   489: lstore 7
    //   491: aload 16
    //   493: astore 13
    //   495: aload 17
    //   497: astore 15
    //   499: aload 16
    //   501: astore 4
    //   503: aload_0
    //   504: new 478	java/net/Socket
    //   507: dup
    //   508: invokespecial 479	java/net/Socket:<init>	()V
    //   511: putfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   514: aload 17
    //   516: astore 14
    //   518: lload 9
    //   520: lstore 7
    //   522: aload 16
    //   524: astore 13
    //   526: aload 17
    //   528: astore 15
    //   530: aload 16
    //   532: astore 4
    //   534: aload_0
    //   535: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   538: iload_3
    //   539: invokevirtual 483	java/net/Socket:setSoTimeout	(I)V
    //   542: aload 17
    //   544: astore 14
    //   546: lload 9
    //   548: lstore 7
    //   550: aload 16
    //   552: astore 13
    //   554: aload 17
    //   556: astore 15
    //   558: aload 16
    //   560: astore 4
    //   562: aload_0
    //   563: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   566: iconst_1
    //   567: invokevirtual 486	java/net/Socket:setTcpNoDelay	(Z)V
    //   570: aload 17
    //   572: astore 14
    //   574: lload 9
    //   576: lstore 7
    //   578: aload 16
    //   580: astore 13
    //   582: aload 17
    //   584: astore 15
    //   586: aload 16
    //   588: astore 4
    //   590: aload_0
    //   591: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   594: iconst_1
    //   595: invokevirtual 489	java/net/Socket:setKeepAlive	(Z)V
    //   598: aload 17
    //   600: astore 14
    //   602: lload 9
    //   604: lstore 7
    //   606: aload 16
    //   608: astore 13
    //   610: aload 17
    //   612: astore 15
    //   614: aload 16
    //   616: astore 4
    //   618: aload_0
    //   619: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   622: ifnull +67 -> 689
    //   625: aload 17
    //   627: astore 14
    //   629: lload 9
    //   631: lstore 7
    //   633: aload 16
    //   635: astore 13
    //   637: aload 17
    //   639: astore 15
    //   641: aload 16
    //   643: astore 4
    //   645: aload_0
    //   646: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   649: getfield 493	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   652: ifnull +37 -> 689
    //   655: aload 17
    //   657: astore 14
    //   659: lload 9
    //   661: lstore 7
    //   663: aload 16
    //   665: astore 13
    //   667: aload 17
    //   669: astore 15
    //   671: aload 16
    //   673: astore 4
    //   675: aload_0
    //   676: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   679: getfield 493	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   682: iconst_1
    //   683: invokeinterface 499 2 0
    //   688: pop
    //   689: aload 17
    //   691: astore 14
    //   693: lload 9
    //   695: lstore 7
    //   697: aload 16
    //   699: astore 13
    //   701: aload 17
    //   703: astore 15
    //   705: aload 16
    //   707: astore 4
    //   709: aload_0
    //   710: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   713: aload_0
    //   714: getfield 444	com/tencent/mobileqq/msf/core/net/l:c	Ljava/net/InetSocketAddress;
    //   717: aload_1
    //   718: invokevirtual 501	com/tencent/mobileqq/msf/core/d:e	()I
    //   721: invokevirtual 505	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   724: aload 17
    //   726: astore 14
    //   728: lload 9
    //   730: lstore 7
    //   732: aload 16
    //   734: astore 13
    //   736: aload 17
    //   738: astore 15
    //   740: aload 16
    //   742: astore 4
    //   744: aload_0
    //   745: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   748: ifnull +67 -> 815
    //   751: aload 17
    //   753: astore 14
    //   755: lload 9
    //   757: lstore 7
    //   759: aload 16
    //   761: astore 13
    //   763: aload 17
    //   765: astore 15
    //   767: aload 16
    //   769: astore 4
    //   771: aload_0
    //   772: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   775: getfield 493	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   778: ifnull +37 -> 815
    //   781: aload 17
    //   783: astore 14
    //   785: lload 9
    //   787: lstore 7
    //   789: aload 16
    //   791: astore 13
    //   793: aload 17
    //   795: astore 15
    //   797: aload 16
    //   799: astore 4
    //   801: aload_0
    //   802: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   805: getfield 493	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
    //   808: iconst_1
    //   809: invokeinterface 508 2 0
    //   814: pop
    //   815: aload 17
    //   817: astore 14
    //   819: lload 9
    //   821: lstore 7
    //   823: aload 16
    //   825: astore 13
    //   827: aload 17
    //   829: astore 15
    //   831: aload 16
    //   833: astore 4
    //   835: aload 6
    //   837: iconst_1
    //   838: putfield 512	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   841: aload 17
    //   843: astore 14
    //   845: lload 9
    //   847: lstore 7
    //   849: aload 16
    //   851: astore 13
    //   853: aload 17
    //   855: astore 15
    //   857: aload 16
    //   859: astore 4
    //   861: aload 6
    //   863: aload 6
    //   865: getfield 514	com/tencent/mobileqq/msf/core/net/a:j	I
    //   868: iconst_1
    //   869: iadd
    //   870: putfield 514	com/tencent/mobileqq/msf/core/net/a:j	I
    //   873: aload 17
    //   875: astore 14
    //   877: lload 9
    //   879: lstore 7
    //   881: aload 16
    //   883: astore 13
    //   885: aload 17
    //   887: astore 15
    //   889: aload 16
    //   891: astore 4
    //   893: aload_0
    //   894: invokestatic 429	java/lang/System:currentTimeMillis	()J
    //   897: putfield 103	com/tencent/mobileqq/msf/core/net/l:q	J
    //   900: aload 17
    //   902: astore 14
    //   904: lload 9
    //   906: lstore 7
    //   908: aload 16
    //   910: astore 13
    //   912: aload 17
    //   914: astore 15
    //   916: aload 16
    //   918: astore 4
    //   920: aload_0
    //   921: aload_0
    //   922: getfield 103	com/tencent/mobileqq/msf/core/net/l:q	J
    //   925: lload 9
    //   927: lsub
    //   928: putfield 431	com/tencent/mobileqq/msf/core/net/l:E	J
    //   931: aload 17
    //   933: astore 14
    //   935: lload 9
    //   937: lstore 7
    //   939: aload 16
    //   941: astore 13
    //   943: aload 17
    //   945: astore 15
    //   947: aload 16
    //   949: astore 4
    //   951: aload_0
    //   952: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   955: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   958: getfield 517	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
    //   961: astore 18
    //   963: aload 17
    //   965: astore 14
    //   967: lload 9
    //   969: lstore 7
    //   971: aload 16
    //   973: astore 13
    //   975: aload 17
    //   977: astore 15
    //   979: aload 16
    //   981: astore 4
    //   983: aload 18
    //   985: aload 18
    //   987: getfield 521	com/tencent/mobileqq/msf/core/net/m:p	J
    //   990: aload_0
    //   991: getfield 431	com/tencent/mobileqq/msf/core/net/l:E	J
    //   994: ladd
    //   995: putfield 521	com/tencent/mobileqq/msf/core/net/m:p	J
    //   998: aload 17
    //   1000: astore 14
    //   1002: lload 9
    //   1004: lstore 7
    //   1006: aload 16
    //   1008: astore 13
    //   1010: aload 17
    //   1012: astore 15
    //   1014: aload 16
    //   1016: astore 4
    //   1018: aload_0
    //   1019: getfield 431	com/tencent/mobileqq/msf/core/net/l:E	J
    //   1022: lconst_0
    //   1023: lcmp
    //   1024: ifge +28 -> 1052
    //   1027: aload 17
    //   1029: astore 14
    //   1031: lload 9
    //   1033: lstore 7
    //   1035: aload 16
    //   1037: astore 13
    //   1039: aload 17
    //   1041: astore 15
    //   1043: aload 16
    //   1045: astore 4
    //   1047: aload_0
    //   1048: lconst_0
    //   1049: putfield 431	com/tencent/mobileqq/msf/core/net/l:E	J
    //   1052: aload 17
    //   1054: astore 14
    //   1056: lload 9
    //   1058: lstore 7
    //   1060: aload 16
    //   1062: astore 13
    //   1064: aload 17
    //   1066: astore 15
    //   1068: aload 16
    //   1070: astore 4
    //   1072: aload_0
    //   1073: getfield 103	com/tencent/mobileqq/msf/core/net/l:q	J
    //   1076: putstatic 524	com/tencent/mobileqq/msf/core/af:S	J
    //   1079: aload 17
    //   1081: astore 14
    //   1083: lload 9
    //   1085: lstore 7
    //   1087: aload 16
    //   1089: astore 13
    //   1091: aload 17
    //   1093: astore 15
    //   1095: aload 16
    //   1097: astore 4
    //   1099: aload_0
    //   1100: getfield 99	com/tencent/mobileqq/msf/core/net/l:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   1103: lconst_0
    //   1104: invokevirtual 527	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   1107: aload 17
    //   1109: astore 14
    //   1111: lload 9
    //   1113: lstore 7
    //   1115: aload 16
    //   1117: astore 13
    //   1119: aload 17
    //   1121: astore 15
    //   1123: aload 16
    //   1125: astore 4
    //   1127: aload_0
    //   1128: getfield 101	com/tencent/mobileqq/msf/core/net/l:p	Ljava/util/concurrent/atomic/AtomicLong;
    //   1131: lconst_0
    //   1132: invokevirtual 527	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   1135: aload 17
    //   1137: astore 14
    //   1139: lload 9
    //   1141: lstore 7
    //   1143: aload 16
    //   1145: astore 13
    //   1147: aload 17
    //   1149: astore 15
    //   1151: aload 16
    //   1153: astore 4
    //   1155: aload_0
    //   1156: aload_0
    //   1157: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   1160: invokevirtual 531	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   1163: putfield 81	com/tencent/mobileqq/msf/core/net/l:h	Ljava/io/OutputStream;
    //   1166: aload 17
    //   1168: astore 14
    //   1170: lload 9
    //   1172: lstore 7
    //   1174: aload 16
    //   1176: astore 13
    //   1178: aload 17
    //   1180: astore 15
    //   1182: aload 16
    //   1184: astore 4
    //   1186: getstatic 74	com/tencent/mobileqq/msf/core/net/l:n	Ljava/util/ArrayList;
    //   1189: aload_0
    //   1190: getfield 81	com/tencent/mobileqq/msf/core/net/l:h	Ljava/io/OutputStream;
    //   1193: invokevirtual 532	java/lang/Object:toString	()Ljava/lang/String;
    //   1196: invokevirtual 535	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   1199: ifne +37 -> 1236
    //   1202: aload 17
    //   1204: astore 14
    //   1206: lload 9
    //   1208: lstore 7
    //   1210: aload 16
    //   1212: astore 13
    //   1214: aload 17
    //   1216: astore 15
    //   1218: aload 16
    //   1220: astore 4
    //   1222: getstatic 74	com/tencent/mobileqq/msf/core/net/l:n	Ljava/util/ArrayList;
    //   1225: aload_0
    //   1226: getfield 81	com/tencent/mobileqq/msf/core/net/l:h	Ljava/io/OutputStream;
    //   1229: invokevirtual 532	java/lang/Object:toString	()Ljava/lang/String;
    //   1232: invokevirtual 538	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1235: pop
    //   1236: aload 17
    //   1238: astore 14
    //   1240: lload 9
    //   1242: lstore 7
    //   1244: aload 16
    //   1246: astore 13
    //   1248: aload 17
    //   1250: astore 15
    //   1252: aload 16
    //   1254: astore 4
    //   1256: aload_0
    //   1257: new 540	com/tencent/qphone/base/util/MsfSocketInputBuffer
    //   1260: dup
    //   1261: aload_0
    //   1262: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   1265: iload_2
    //   1266: ldc_w 542
    //   1269: iconst_m1
    //   1270: invokespecial 545	com/tencent/qphone/base/util/MsfSocketInputBuffer:<init>	(Ljava/net/Socket;ILjava/lang/String;I)V
    //   1273: putfield 85	com/tencent/mobileqq/msf/core/net/l:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
    //   1276: aload 17
    //   1278: astore 14
    //   1280: lload 9
    //   1282: lstore 7
    //   1284: aload 16
    //   1286: astore 13
    //   1288: aload 17
    //   1290: astore 15
    //   1292: aload 16
    //   1294: astore 4
    //   1296: aload_0
    //   1297: getfield 121	com/tencent/mobileqq/msf/core/net/l:F	Z
    //   1300: ifne +1355 -> 2655
    //   1303: aload 17
    //   1305: astore 14
    //   1307: lload 9
    //   1309: lstore 7
    //   1311: aload 16
    //   1313: astore 13
    //   1315: aload 17
    //   1317: astore 15
    //   1319: aload 16
    //   1321: astore 4
    //   1323: aload_0
    //   1324: new 12	com/tencent/mobileqq/msf/core/net/l$c
    //   1327: dup
    //   1328: aload_0
    //   1329: invokespecial 548	com/tencent/mobileqq/msf/core/net/l$c:<init>	(Lcom/tencent/mobileqq/msf/core/net/l;)V
    //   1332: putfield 83	com/tencent/mobileqq/msf/core/net/l:j	Lcom/tencent/mobileqq/msf/core/net/l$a;
    //   1335: aload 17
    //   1337: astore 14
    //   1339: lload 9
    //   1341: lstore 7
    //   1343: aload 16
    //   1345: astore 13
    //   1347: aload 17
    //   1349: astore 15
    //   1351: aload 16
    //   1353: astore 4
    //   1355: aload_0
    //   1356: getfield 83	com/tencent/mobileqq/msf/core/net/l:j	Lcom/tencent/mobileqq/msf/core/net/l$a;
    //   1359: ldc_w 550
    //   1362: invokevirtual 554	com/tencent/mobileqq/msf/core/net/l$a:setName	(Ljava/lang/String;)V
    //   1365: aload 17
    //   1367: astore 14
    //   1369: lload 9
    //   1371: lstore 7
    //   1373: aload 16
    //   1375: astore 13
    //   1377: aload 17
    //   1379: astore 15
    //   1381: aload 16
    //   1383: astore 4
    //   1385: aload_0
    //   1386: getfield 83	com/tencent/mobileqq/msf/core/net/l:j	Lcom/tencent/mobileqq/msf/core/net/l$a;
    //   1389: invokevirtual 557	com/tencent/mobileqq/msf/core/net/l$a:start	()V
    //   1392: aload 17
    //   1394: astore 14
    //   1396: lload 9
    //   1398: lstore 7
    //   1400: aload 16
    //   1402: astore 13
    //   1404: aload 17
    //   1406: astore 15
    //   1408: aload 16
    //   1410: astore 4
    //   1412: aload_0
    //   1413: getfield 83	com/tencent/mobileqq/msf/core/net/l:j	Lcom/tencent/mobileqq/msf/core/net/l$a;
    //   1416: invokevirtual 559	com/tencent/mobileqq/msf/core/net/l$a:a	()V
    //   1419: aload 17
    //   1421: astore 14
    //   1423: lload 9
    //   1425: lstore 7
    //   1427: aload 16
    //   1429: astore 13
    //   1431: aload 17
    //   1433: astore 15
    //   1435: aload 16
    //   1437: astore 4
    //   1439: aload_0
    //   1440: getfield 110	com/tencent/mobileqq/msf/core/net/l:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1443: iconst_1
    //   1444: invokevirtual 382	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1447: aload 17
    //   1449: astore 14
    //   1451: lload 9
    //   1453: lstore 7
    //   1455: aload 16
    //   1457: astore 13
    //   1459: aload 17
    //   1461: astore 15
    //   1463: aload 16
    //   1465: astore 4
    //   1467: getstatic 561	com/tencent/mobileqq/msf/core/net/v:c	Lcom/tencent/mobileqq/msf/core/net/v;
    //   1470: astore 16
    //   1472: ldc_w 563
    //   1475: astore 17
    //   1477: aload 17
    //   1479: astore 14
    //   1481: lload 9
    //   1483: lstore 7
    //   1485: aload 16
    //   1487: astore 13
    //   1489: aload 17
    //   1491: astore 15
    //   1493: aload 16
    //   1495: astore 4
    //   1497: aload_0
    //   1498: aload_1
    //   1499: putfield 565	com/tencent/mobileqq/msf/core/net/l:B	Lcom/tencent/mobileqq/msf/core/d;
    //   1502: aload 17
    //   1504: astore 14
    //   1506: lload 9
    //   1508: lstore 7
    //   1510: aload 16
    //   1512: astore 13
    //   1514: aload 17
    //   1516: astore 15
    //   1518: aload 16
    //   1520: astore 4
    //   1522: invokestatic 567	com/tencent/mobileqq/msf/core/af:g	()V
    //   1525: aload 17
    //   1527: astore 14
    //   1529: lload 9
    //   1531: lstore 7
    //   1533: aload 16
    //   1535: astore 13
    //   1537: aload 17
    //   1539: astore 15
    //   1541: aload 16
    //   1543: astore 4
    //   1545: new 245	java/lang/StringBuilder
    //   1548: dup
    //   1549: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1552: aload_0
    //   1553: getfield 565	com/tencent/mobileqq/msf/core/net/l:B	Lcom/tencent/mobileqq/msf/core/d;
    //   1556: invokevirtual 437	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   1559: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1562: ldc_w 569
    //   1565: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: aload_0
    //   1569: getfield 565	com/tencent/mobileqq/msf/core/net/l:B	Lcom/tencent/mobileqq/msf/core/d;
    //   1572: invokevirtual 439	com/tencent/mobileqq/msf/core/d:d	()I
    //   1575: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1578: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1581: putstatic 571	com/tencent/mobileqq/msf/core/af:G	Ljava/lang/String;
    //   1584: aload 17
    //   1586: astore 14
    //   1588: lload 9
    //   1590: lstore 7
    //   1592: aload 16
    //   1594: astore 13
    //   1596: aload 17
    //   1598: astore 15
    //   1600: aload 16
    //   1602: astore 4
    //   1604: new 245	java/lang/StringBuilder
    //   1607: dup
    //   1608: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   1611: aload_0
    //   1612: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   1615: invokevirtual 575	java/net/Socket:getLocalSocketAddress	()Ljava/net/SocketAddress;
    //   1618: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1621: ldc_w 580
    //   1624: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1627: aload_0
    //   1628: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   1631: invokevirtual 583	java/net/Socket:getLocalPort	()I
    //   1634: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1637: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1640: putstatic 586	com/tencent/mobileqq/msf/core/af:H	Ljava/lang/String;
    //   1643: aload 17
    //   1645: astore 14
    //   1647: lload 9
    //   1649: lstore 7
    //   1651: aload 16
    //   1653: astore 13
    //   1655: aload 17
    //   1657: astore 15
    //   1659: aload 16
    //   1661: astore 4
    //   1663: invokestatic 589	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isWifiConn	()Z
    //   1666: ifeq +1587 -> 3253
    //   1669: aload 17
    //   1671: astore 14
    //   1673: lload 9
    //   1675: lstore 7
    //   1677: aload 16
    //   1679: astore 13
    //   1681: aload 17
    //   1683: astore 15
    //   1685: aload 16
    //   1687: astore 4
    //   1689: iconst_1
    //   1690: putstatic 591	com/tencent/mobileqq/msf/core/af:I	I
    //   1693: aload 17
    //   1695: astore 14
    //   1697: lload 9
    //   1699: lstore 7
    //   1701: aload 16
    //   1703: astore 13
    //   1705: aload 17
    //   1707: astore 15
    //   1709: aload 16
    //   1711: astore 4
    //   1713: aload_0
    //   1714: getfield 565	com/tencent/mobileqq/msf/core/net/l:B	Lcom/tencent/mobileqq/msf/core/d;
    //   1717: invokevirtual 593	com/tencent/mobileqq/msf/core/d:f	()V
    //   1720: aload 17
    //   1722: astore 14
    //   1724: lload 9
    //   1726: lstore 7
    //   1728: aload 16
    //   1730: astore 13
    //   1732: aload 17
    //   1734: astore 15
    //   1736: aload 16
    //   1738: astore 4
    //   1740: aload 19
    //   1742: iconst_0
    //   1743: aload 19
    //   1745: invokevirtual 596	java/lang/StringBuilder:length	()I
    //   1748: invokevirtual 600	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1751: pop
    //   1752: aload 17
    //   1754: astore 14
    //   1756: lload 9
    //   1758: lstore 7
    //   1760: aload 16
    //   1762: astore 13
    //   1764: aload 17
    //   1766: astore 15
    //   1768: aload 16
    //   1770: astore 4
    //   1772: aload 19
    //   1774: ldc_w 602
    //   1777: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1780: aload_0
    //   1781: getfield 444	com/tencent/mobileqq/msf/core/net/l:c	Ljava/net/InetSocketAddress;
    //   1784: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1787: ldc_w 604
    //   1790: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1793: aload_0
    //   1794: getfield 431	com/tencent/mobileqq/msf/core/net/l:E	J
    //   1797: invokevirtual 607	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1800: ldc_w 609
    //   1803: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1806: aload_1
    //   1807: invokevirtual 501	com/tencent/mobileqq/msf/core/d:e	()I
    //   1810: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1813: ldc_w 611
    //   1816: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1819: aload_0
    //   1820: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   1823: invokevirtual 615	java/net/Socket:getLocalAddress	()Ljava/net/InetAddress;
    //   1826: invokevirtual 620	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   1829: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1832: ldc_w 569
    //   1835: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1838: aload_0
    //   1839: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   1842: invokevirtual 583	java/net/Socket:getLocalPort	()I
    //   1845: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1848: astore 19
    //   1850: aload 17
    //   1852: astore 14
    //   1854: lload 9
    //   1856: lstore 7
    //   1858: aload 16
    //   1860: astore 13
    //   1862: aload 17
    //   1864: astore 15
    //   1866: aload 16
    //   1868: astore 4
    //   1870: aload_1
    //   1871: getfield 456	com/tencent/mobileqq/msf/core/d:i	Z
    //   1874: ifeq +2523 -> 4397
    //   1877: ldc_w 458
    //   1880: astore 18
    //   1882: aload 17
    //   1884: astore 14
    //   1886: lload 9
    //   1888: lstore 7
    //   1890: aload 16
    //   1892: astore 13
    //   1894: aload 17
    //   1896: astore 15
    //   1898: aload 16
    //   1900: astore 4
    //   1902: aload 19
    //   1904: aload 18
    //   1906: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1909: ldc_w 467
    //   1912: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1915: astore 19
    //   1917: aload 17
    //   1919: astore 14
    //   1921: lload 9
    //   1923: lstore 7
    //   1925: aload 16
    //   1927: astore 13
    //   1929: aload 17
    //   1931: astore 15
    //   1933: aload 16
    //   1935: astore 4
    //   1937: aload_1
    //   1938: invokestatic 472	com/tencent/mobileqq/msf/core/net/i:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   1941: ifeq +2464 -> 4405
    //   1944: ldc_w 622
    //   1947: astore 18
    //   1949: aload 17
    //   1951: astore 14
    //   1953: lload 9
    //   1955: lstore 7
    //   1957: aload 16
    //   1959: astore 13
    //   1961: aload 17
    //   1963: astore 15
    //   1965: aload 16
    //   1967: astore 4
    //   1969: ldc 243
    //   1971: iconst_1
    //   1972: aload 19
    //   1974: aload 18
    //   1976: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1979: aload_0
    //   1980: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   1983: invokevirtual 296	java/lang/Object:hashCode	()I
    //   1986: invokestatic 352	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   1989: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1992: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1995: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1998: aload 17
    //   2000: astore 14
    //   2002: lload 9
    //   2004: lstore 7
    //   2006: aload 16
    //   2008: astore 13
    //   2010: aload 17
    //   2012: astore 15
    //   2014: aload 16
    //   2016: astore 4
    //   2018: aload_0
    //   2019: getfield 94	com/tencent/mobileqq/msf/core/net/l:C	Ljava/util/concurrent/atomic/AtomicInteger;
    //   2022: iconst_0
    //   2023: invokevirtual 624	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   2026: aload 17
    //   2028: astore 14
    //   2030: lload 9
    //   2032: lstore 7
    //   2034: aload 16
    //   2036: astore 13
    //   2038: aload 17
    //   2040: astore 15
    //   2042: aload 16
    //   2044: astore 4
    //   2046: getstatic 301	com/tencent/mobileqq/msf/core/af:s	Z
    //   2049: ifeq +137 -> 2186
    //   2052: aload 17
    //   2054: astore 14
    //   2056: lload 9
    //   2058: lstore 7
    //   2060: aload 16
    //   2062: astore 13
    //   2064: aload 17
    //   2066: astore 15
    //   2068: aload 16
    //   2070: astore 4
    //   2072: invokestatic 305	com/tencent/mobileqq/msf/core/net/a/f:a	()Z
    //   2075: istore 5
    //   2077: iload 5
    //   2079: ifeq +107 -> 2186
    //   2082: aload 17
    //   2084: astore 14
    //   2086: lload 9
    //   2088: lstore 7
    //   2090: aload 16
    //   2092: astore 13
    //   2094: aload 17
    //   2096: astore 15
    //   2098: aload 16
    //   2100: astore 4
    //   2102: ldc 243
    //   2104: iconst_1
    //   2105: ldc_w 626
    //   2108: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2111: aload 17
    //   2113: astore 14
    //   2115: lload 9
    //   2117: lstore 7
    //   2119: aload 16
    //   2121: astore 13
    //   2123: aload 17
    //   2125: astore 15
    //   2127: aload 16
    //   2129: astore 4
    //   2131: aload_0
    //   2132: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2135: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   2138: getfield 310	com/tencent/mobileqq/msf/core/af:J	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   2141: ifnull +45 -> 2186
    //   2144: aload 17
    //   2146: astore 14
    //   2148: lload 9
    //   2150: lstore 7
    //   2152: aload 16
    //   2154: astore 13
    //   2156: aload 17
    //   2158: astore 15
    //   2160: aload 16
    //   2162: astore 4
    //   2164: aload_0
    //   2165: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2168: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   2171: getfield 310	com/tencent/mobileqq/msf/core/af:J	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   2174: invokevirtual 313	com/tencent/mobileqq/msf/core/net/a/f:b	()Lcom/tencent/mobileqq/msf/core/net/a/e;
    //   2177: aload_0
    //   2178: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   2181: invokeinterface 629 2 0
    //   2186: aload 17
    //   2188: astore 14
    //   2190: lload 9
    //   2192: lstore 7
    //   2194: aload 16
    //   2196: astore 13
    //   2198: aload 17
    //   2200: astore 15
    //   2202: aload 16
    //   2204: astore 4
    //   2206: aload_0
    //   2207: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2210: invokevirtual 633	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
    //   2213: ifnull +108 -> 2321
    //   2216: aload 17
    //   2218: astore 14
    //   2220: lload 9
    //   2222: lstore 7
    //   2224: aload 16
    //   2226: astore 13
    //   2228: aload 17
    //   2230: astore 15
    //   2232: aload 16
    //   2234: astore 4
    //   2236: aload_0
    //   2237: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2240: getfield 637	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   2243: getfield 643	com/tencent/mobileqq/msf/core/c/j:Q	Lcom/tencent/mobileqq/msf/core/c/j$c;
    //   2246: ifnull +75 -> 2321
    //   2249: aload 17
    //   2251: astore 14
    //   2253: lload 9
    //   2255: lstore 7
    //   2257: aload 16
    //   2259: astore 13
    //   2261: aload 17
    //   2263: astore 15
    //   2265: aload 16
    //   2267: astore 4
    //   2269: aload_0
    //   2270: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2273: getfield 637	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   2276: getfield 643	com/tencent/mobileqq/msf/core/c/j:Q	Lcom/tencent/mobileqq/msf/core/c/j$c;
    //   2279: getfield 647	com/tencent/mobileqq/msf/core/c/j$c:e	J
    //   2282: lconst_0
    //   2283: lcmp
    //   2284: ifle +37 -> 2321
    //   2287: aload 17
    //   2289: astore 14
    //   2291: lload 9
    //   2293: lstore 7
    //   2295: aload 16
    //   2297: astore 13
    //   2299: aload 17
    //   2301: astore 15
    //   2303: aload 16
    //   2305: astore 4
    //   2307: aload_0
    //   2308: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2311: getfield 637	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   2314: getfield 643	com/tencent/mobileqq/msf/core/c/j:Q	Lcom/tencent/mobileqq/msf/core/c/j$c;
    //   2317: lconst_0
    //   2318: putfield 649	com/tencent/mobileqq/msf/core/c/j$c:f	J
    //   2321: aload_0
    //   2322: getfield 119	com/tencent/mobileqq/msf/core/net/l:v	Ljava/util/concurrent/locks/ReentrantLock;
    //   2325: invokevirtual 652	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2328: aload 16
    //   2330: getstatic 561	com/tencent/mobileqq/msf/core/net/v:c	Lcom/tencent/mobileqq/msf/core/net/v;
    //   2333: if_acmpeq +21 -> 2354
    //   2336: aload 6
    //   2338: iconst_0
    //   2339: putfield 512	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   2342: aload 6
    //   2344: aload 6
    //   2346: getfield 654	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2349: iconst_1
    //   2350: iadd
    //   2351: putfield 654	com/tencent/mobileqq/msf/core/net/a:k	I
    //   2354: aload 6
    //   2356: aload 16
    //   2358: putfield 656	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/v;
    //   2361: aload 6
    //   2363: ldc_w 563
    //   2366: putfield 658	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   2369: aload 6
    //   2371: invokestatic 424	android/os/SystemClock:elapsedRealtime	()J
    //   2374: lload 11
    //   2376: lsub
    //   2377: putfield 660	com/tencent/mobileqq/msf/core/net/a:a	J
    //   2380: aload 16
    //   2382: astore 14
    //   2384: aload 14
    //   2386: getstatic 561	com/tencent/mobileqq/msf/core/net/v:c	Lcom/tencent/mobileqq/msf/core/net/v;
    //   2389: if_acmpne +1854 -> 4243
    //   2392: aload_0
    //   2393: getfield 133	com/tencent/mobileqq/msf/core/net/l:w	Z
    //   2396: ifeq +1847 -> 4243
    //   2399: aload_1
    //   2400: invokestatic 472	com/tencent/mobileqq/msf/core/net/i:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   2403: ifeq +16 -> 2419
    //   2406: invokestatic 168	com/tencent/mobileqq/a/a/a$c:a	()Lcom/tencent/mobileqq/a/a/a$c;
    //   2409: iconst_1
    //   2410: invokevirtual 662	com/tencent/mobileqq/a/a/a$c:a	(Z)V
    //   2413: invokestatic 168	com/tencent/mobileqq/a/a/a$c:a	()Lcom/tencent/mobileqq/a/a/a$c;
    //   2416: invokevirtual 664	com/tencent/mobileqq/a/a/a$c:b	()V
    //   2419: invokestatic 667	com/tencent/mobileqq/msf/core/NetConnInfoCenter:checkConnInfo	()V
    //   2422: invokestatic 670	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isNetSupport	()Z
    //   2425: ifne +7 -> 2432
    //   2428: iconst_1
    //   2429: invokestatic 673	com/tencent/mobileqq/msf/core/NetConnInfoCenter:setNetSupport	(Z)V
    //   2432: invokestatic 676	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   2435: putstatic 678	com/tencent/mobileqq/msf/core/net/l:A	I
    //   2438: aload_0
    //   2439: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2442: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   2445: aconst_null
    //   2446: invokevirtual 680	com/tencent/mobileqq/msf/core/af:a	([B)V
    //   2449: aload_0
    //   2450: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2453: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   2456: invokevirtual 681	com/tencent/mobileqq/msf/core/af:f	()V
    //   2459: getstatic 682	com/tencent/mobileqq/msf/core/af:C	Ljava/util/concurrent/atomic/AtomicInteger;
    //   2462: iconst_0
    //   2463: invokevirtual 624	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   2466: getstatic 684	com/tencent/mobileqq/msf/core/af:D	Ljava/util/ArrayList;
    //   2469: invokevirtual 687	java/util/ArrayList:clear	()V
    //   2472: aload_0
    //   2473: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   2476: ifnull +170 -> 2646
    //   2479: aload_0
    //   2480: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2483: new 245	java/lang/StringBuilder
    //   2486: dup
    //   2487: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   2490: aload_0
    //   2491: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   2494: invokevirtual 615	java/net/Socket:getLocalAddress	()Ljava/net/InetAddress;
    //   2497: invokevirtual 620	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   2500: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2503: ldc_w 569
    //   2506: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2509: aload_0
    //   2510: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   2513: invokevirtual 583	java/net/Socket:getLocalPort	()I
    //   2516: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2519: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2522: putfield 690	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   2525: invokestatic 449	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   2528: aload_0
    //   2529: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   2532: getstatic 678	com/tencent/mobileqq/msf/core/net/l:A	I
    //   2535: aload_0
    //   2536: getfield 431	com/tencent/mobileqq/msf/core/net/l:E	J
    //   2539: l2i
    //   2540: invokevirtual 693	com/tencent/mobileqq/a/a/a:a	(Ljava/net/Socket;II)V
    //   2543: aload_0
    //   2544: getfield 112	com/tencent/mobileqq/msf/core/net/l:t	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2547: iconst_0
    //   2548: invokevirtual 382	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   2551: invokestatic 697	com/tencent/mobileqq/msf/core/a/a:v	()Z
    //   2554: ifeq +1624 -> 4178
    //   2557: aload_0
    //   2558: invokevirtual 698	com/tencent/mobileqq/msf/core/net/l:f	()V
    //   2561: aload_0
    //   2562: invokespecial 700	com/tencent/mobileqq/msf/core/net/l:h	()V
    //   2565: invokestatic 702	com/tencent/mobileqq/msf/core/a/a:w	()Z
    //   2568: ifeq +1643 -> 4211
    //   2571: aload_0
    //   2572: aload_0
    //   2573: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2576: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   2579: aload_0
    //   2580: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   2583: invokevirtual 296	java/lang/Object:hashCode	()I
    //   2586: invokevirtual 705	com/tencent/mobileqq/msf/core/af:a	(I)Ljava/lang/Runnable;
    //   2589: putfield 397	com/tencent/mobileqq/msf/core/net/l:y	Ljava/lang/Runnable;
    //   2592: aload_0
    //   2593: getfield 444	com/tencent/mobileqq/msf/core/net/l:c	Ljava/net/InetSocketAddress;
    //   2596: invokevirtual 706	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   2599: invokestatic 711	com/tencent/qphone/base/util/e:b	(Ljava/lang/String;)J
    //   2602: putstatic 715	com/tencent/mobileqq/msf/core/push/d:d	J
    //   2605: aload_1
    //   2606: invokevirtual 437	com/tencent/mobileqq/msf/core/d:c	()Ljava/lang/String;
    //   2609: aload_1
    //   2610: invokevirtual 439	com/tencent/mobileqq/msf/core/d:d	()I
    //   2613: getstatic 678	com/tencent/mobileqq/msf/core/net/l:A	I
    //   2616: invokestatic 720	com/tencent/mobileqq/a/a/f:a	(Ljava/lang/String;II)V
    //   2619: aload_0
    //   2620: getfield 444	com/tencent/mobileqq/msf/core/net/l:c	Ljava/net/InetSocketAddress;
    //   2623: invokevirtual 706	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   2626: aload_0
    //   2627: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2630: getfield 690	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   2633: invokestatic 724	com/tencent/mobileqq/msf/core/NetConnInfoCenter:onConnOpened	(Ljava/lang/String;Ljava/lang/String;)V
    //   2636: aload_0
    //   2637: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2640: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   2643: invokevirtual 726	com/tencent/mobileqq/msf/core/af:l	()V
    //   2646: return
    //   2647: ldc_w 728
    //   2650: astore 18
    //   2652: goto -2335 -> 317
    //   2655: aload 17
    //   2657: astore 14
    //   2659: lload 9
    //   2661: lstore 7
    //   2663: aload 16
    //   2665: astore 13
    //   2667: aload 17
    //   2669: astore 15
    //   2671: aload 16
    //   2673: astore 4
    //   2675: aload_0
    //   2676: getfield 83	com/tencent/mobileqq/msf/core/net/l:j	Lcom/tencent/mobileqq/msf/core/net/l$a;
    //   2679: ifnull +33 -> 2712
    //   2682: aload 17
    //   2684: astore 14
    //   2686: lload 9
    //   2688: lstore 7
    //   2690: aload 16
    //   2692: astore 13
    //   2694: aload 17
    //   2696: astore 15
    //   2698: aload 16
    //   2700: astore 4
    //   2702: aload_0
    //   2703: getfield 83	com/tencent/mobileqq/msf/core/net/l:j	Lcom/tencent/mobileqq/msf/core/net/l$a;
    //   2706: invokevirtual 731	com/tencent/mobileqq/msf/core/net/l$a:isAlive	()Z
    //   2709: ifne +453 -> 3162
    //   2712: aload 17
    //   2714: astore 14
    //   2716: lload 9
    //   2718: lstore 7
    //   2720: aload 16
    //   2722: astore 13
    //   2724: aload 17
    //   2726: astore 15
    //   2728: aload 16
    //   2730: astore 4
    //   2732: aload_0
    //   2733: new 9	com/tencent/mobileqq/msf/core/net/l$b
    //   2736: dup
    //   2737: aload_0
    //   2738: invokespecial 732	com/tencent/mobileqq/msf/core/net/l$b:<init>	(Lcom/tencent/mobileqq/msf/core/net/l;)V
    //   2741: putfield 83	com/tencent/mobileqq/msf/core/net/l:j	Lcom/tencent/mobileqq/msf/core/net/l$a;
    //   2744: aload 17
    //   2746: astore 14
    //   2748: lload 9
    //   2750: lstore 7
    //   2752: aload 16
    //   2754: astore 13
    //   2756: aload 17
    //   2758: astore 15
    //   2760: aload 16
    //   2762: astore 4
    //   2764: aload_0
    //   2765: getfield 83	com/tencent/mobileqq/msf/core/net/l:j	Lcom/tencent/mobileqq/msf/core/net/l$a;
    //   2768: ldc_w 734
    //   2771: invokevirtual 554	com/tencent/mobileqq/msf/core/net/l$a:setName	(Ljava/lang/String;)V
    //   2774: aload 17
    //   2776: astore 14
    //   2778: lload 9
    //   2780: lstore 7
    //   2782: aload 16
    //   2784: astore 13
    //   2786: aload 17
    //   2788: astore 15
    //   2790: aload 16
    //   2792: astore 4
    //   2794: aload_0
    //   2795: getfield 83	com/tencent/mobileqq/msf/core/net/l:j	Lcom/tencent/mobileqq/msf/core/net/l$a;
    //   2798: invokevirtual 557	com/tencent/mobileqq/msf/core/net/l$a:start	()V
    //   2801: goto -1382 -> 1419
    //   2804: astore 18
    //   2806: aload 14
    //   2808: astore 15
    //   2810: aload 13
    //   2812: astore 4
    //   2814: aload_0
    //   2815: invokestatic 429	java/lang/System:currentTimeMillis	()J
    //   2818: lload 7
    //   2820: lsub
    //   2821: putfield 431	com/tencent/mobileqq/msf/core/net/l:E	J
    //   2824: aload 14
    //   2826: astore 15
    //   2828: aload 13
    //   2830: astore 4
    //   2832: aload_0
    //   2833: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2836: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   2839: getfield 517	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
    //   2842: astore 16
    //   2844: aload 14
    //   2846: astore 15
    //   2848: aload 13
    //   2850: astore 4
    //   2852: aload 16
    //   2854: aload 16
    //   2856: getfield 521	com/tencent/mobileqq/msf/core/net/m:p	J
    //   2859: aload_0
    //   2860: getfield 431	com/tencent/mobileqq/msf/core/net/l:E	J
    //   2863: ladd
    //   2864: putfield 521	com/tencent/mobileqq/msf/core/net/m:p	J
    //   2867: aload 14
    //   2869: astore 15
    //   2871: aload 13
    //   2873: astore 4
    //   2875: aload_0
    //   2876: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2879: invokevirtual 633	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
    //   2882: ifnull +100 -> 2982
    //   2885: aload 14
    //   2887: astore 15
    //   2889: aload 13
    //   2891: astore 4
    //   2893: aload_0
    //   2894: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2897: getfield 637	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   2900: getfield 643	com/tencent/mobileqq/msf/core/c/j:Q	Lcom/tencent/mobileqq/msf/core/c/j$c;
    //   2903: ifnull +79 -> 2982
    //   2906: aload 14
    //   2908: astore 15
    //   2910: aload 13
    //   2912: astore 4
    //   2914: aload_0
    //   2915: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2918: getfield 637	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   2921: getfield 643	com/tencent/mobileqq/msf/core/c/j:Q	Lcom/tencent/mobileqq/msf/core/c/j$c;
    //   2924: getfield 647	com/tencent/mobileqq/msf/core/c/j$c:e	J
    //   2927: lconst_0
    //   2928: lcmp
    //   2929: ifle +53 -> 2982
    //   2932: aload 14
    //   2934: astore 15
    //   2936: aload 13
    //   2938: astore 4
    //   2940: aload_0
    //   2941: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2944: getfield 637	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   2947: getfield 643	com/tencent/mobileqq/msf/core/c/j:Q	Lcom/tencent/mobileqq/msf/core/c/j$c;
    //   2950: getfield 649	com/tencent/mobileqq/msf/core/c/j$c:f	J
    //   2953: lconst_0
    //   2954: lcmp
    //   2955: ifne +27 -> 2982
    //   2958: aload 14
    //   2960: astore 15
    //   2962: aload 13
    //   2964: astore 4
    //   2966: aload_0
    //   2967: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   2970: getfield 637	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/c/j;
    //   2973: getfield 643	com/tencent/mobileqq/msf/core/c/j:Q	Lcom/tencent/mobileqq/msf/core/c/j$c;
    //   2976: invokestatic 429	java/lang/System:currentTimeMillis	()J
    //   2979: putfield 649	com/tencent/mobileqq/msf/core/c/j$c:f	J
    //   2982: aload 14
    //   2984: astore 15
    //   2986: aload 13
    //   2988: astore 4
    //   2990: aload 18
    //   2992: invokevirtual 735	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2995: invokevirtual 738	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2998: astore 17
    //   3000: aload 17
    //   3002: astore 15
    //   3004: aload 13
    //   3006: astore 4
    //   3008: invokestatic 676	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   3011: ifne +336 -> 3347
    //   3014: aload 17
    //   3016: astore 15
    //   3018: aload 13
    //   3020: astore 4
    //   3022: getstatic 740	com/tencent/mobileqq/msf/core/net/v:m	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3025: astore 14
    //   3027: aload 17
    //   3029: astore 15
    //   3031: aload 14
    //   3033: astore 4
    //   3035: aload 14
    //   3037: invokevirtual 741	com/tencent/mobileqq/msf/core/net/v:toString	()Ljava/lang/String;
    //   3040: astore 13
    //   3042: aload 13
    //   3044: astore 15
    //   3046: aload 14
    //   3048: astore 4
    //   3050: aload 6
    //   3052: invokestatic 744	com/tencent/mobileqq/msf/core/a/a:aD	()I
    //   3055: putfield 746	com/tencent/mobileqq/msf/core/net/a:h	I
    //   3058: aload_0
    //   3059: getfield 119	com/tencent/mobileqq/msf/core/net/l:v	Ljava/util/concurrent/locks/ReentrantLock;
    //   3062: invokevirtual 652	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   3065: aload 14
    //   3067: getstatic 561	com/tencent/mobileqq/msf/core/net/v:c	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3070: if_acmpeq +21 -> 3091
    //   3073: aload 6
    //   3075: iconst_0
    //   3076: putfield 512	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   3079: aload 6
    //   3081: aload 6
    //   3083: getfield 654	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3086: iconst_1
    //   3087: iadd
    //   3088: putfield 654	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3091: aload 6
    //   3093: aload 14
    //   3095: putfield 656	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3098: aload 6
    //   3100: aload 13
    //   3102: putfield 658	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3105: aload 6
    //   3107: invokestatic 424	android/os/SystemClock:elapsedRealtime	()J
    //   3110: lload 11
    //   3112: lsub
    //   3113: putfield 660	com/tencent/mobileqq/msf/core/net/a:a	J
    //   3116: goto -732 -> 2384
    //   3119: astore_1
    //   3120: aload 6
    //   3122: iconst_0
    //   3123: putfield 512	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   3126: aload 6
    //   3128: aload 6
    //   3130: getfield 654	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3133: iconst_1
    //   3134: iadd
    //   3135: putfield 654	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3138: aload 6
    //   3140: getstatic 748	com/tencent/mobileqq/msf/core/net/v:f	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3143: putfield 656	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3146: aload 6
    //   3148: aload_1
    //   3149: invokevirtual 749	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   3152: putfield 658	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3155: aload 6
    //   3157: lconst_0
    //   3158: putfield 660	com/tencent/mobileqq/msf/core/net/a:a	J
    //   3161: return
    //   3162: aload 17
    //   3164: astore 14
    //   3166: lload 9
    //   3168: lstore 7
    //   3170: aload 16
    //   3172: astore 13
    //   3174: aload 17
    //   3176: astore 15
    //   3178: aload 16
    //   3180: astore 4
    //   3182: aload_0
    //   3183: getfield 83	com/tencent/mobileqq/msf/core/net/l:j	Lcom/tencent/mobileqq/msf/core/net/l$a;
    //   3186: invokevirtual 559	com/tencent/mobileqq/msf/core/net/l$a:a	()V
    //   3189: goto -1770 -> 1419
    //   3192: astore_1
    //   3193: aload_0
    //   3194: getfield 119	com/tencent/mobileqq/msf/core/net/l:v	Ljava/util/concurrent/locks/ReentrantLock;
    //   3197: invokevirtual 652	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   3200: aload 4
    //   3202: getstatic 561	com/tencent/mobileqq/msf/core/net/v:c	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3205: if_acmpeq +21 -> 3226
    //   3208: aload 6
    //   3210: iconst_0
    //   3211: putfield 512	com/tencent/mobileqq/msf/core/net/a:d	Z
    //   3214: aload 6
    //   3216: aload 6
    //   3218: getfield 654	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3221: iconst_1
    //   3222: iadd
    //   3223: putfield 654	com/tencent/mobileqq/msf/core/net/a:k	I
    //   3226: aload 6
    //   3228: aload 4
    //   3230: putfield 656	com/tencent/mobileqq/msf/core/net/a:e	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3233: aload 6
    //   3235: aload 15
    //   3237: putfield 658	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   3240: aload 6
    //   3242: invokestatic 424	android/os/SystemClock:elapsedRealtime	()J
    //   3245: lload 11
    //   3247: lsub
    //   3248: putfield 660	com/tencent/mobileqq/msf/core/net/a:a	J
    //   3251: aload_1
    //   3252: athrow
    //   3253: aload 17
    //   3255: astore 14
    //   3257: lload 9
    //   3259: lstore 7
    //   3261: aload 16
    //   3263: astore 13
    //   3265: aload 17
    //   3267: astore 15
    //   3269: aload 16
    //   3271: astore 4
    //   3273: invokestatic 752	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isMobileConn	()Z
    //   3276: ifeq -1583 -> 1693
    //   3279: aload 17
    //   3281: astore 14
    //   3283: lload 9
    //   3285: lstore 7
    //   3287: aload 16
    //   3289: astore 13
    //   3291: aload 17
    //   3293: astore 15
    //   3295: aload 16
    //   3297: astore 4
    //   3299: invokestatic 755	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getMobileNetworkType	()I
    //   3302: bipush 100
    //   3304: iadd
    //   3305: putstatic 591	com/tencent/mobileqq/msf/core/af:I	I
    //   3308: goto -1615 -> 1693
    //   3311: astore 18
    //   3313: aload 17
    //   3315: astore 14
    //   3317: lload 9
    //   3319: lstore 7
    //   3321: aload 16
    //   3323: astore 13
    //   3325: aload 17
    //   3327: astore 15
    //   3329: aload 16
    //   3331: astore 4
    //   3333: ldc 243
    //   3335: iconst_1
    //   3336: ldc_w 757
    //   3339: aload 18
    //   3341: invokestatic 361	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3344: goto -1158 -> 2186
    //   3347: aload 17
    //   3349: astore 15
    //   3351: aload 13
    //   3353: astore 4
    //   3355: aload 17
    //   3357: ldc_w 759
    //   3360: invokevirtual 763	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3363: iconst_m1
    //   3364: if_icmple +34 -> 3398
    //   3367: aload 17
    //   3369: astore 15
    //   3371: aload 13
    //   3373: astore 4
    //   3375: getstatic 765	com/tencent/mobileqq/msf/core/net/v:g	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3378: astore 14
    //   3380: aload 17
    //   3382: astore 15
    //   3384: aload 14
    //   3386: astore 4
    //   3388: aload 14
    //   3390: invokevirtual 741	com/tencent/mobileqq/msf/core/net/v:toString	()Ljava/lang/String;
    //   3393: astore 13
    //   3395: goto -337 -> 3058
    //   3398: aload 17
    //   3400: astore 15
    //   3402: aload 13
    //   3404: astore 4
    //   3406: aload 17
    //   3408: ldc_w 767
    //   3411: invokevirtual 763	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3414: iconst_m1
    //   3415: if_icmple +34 -> 3449
    //   3418: aload 17
    //   3420: astore 15
    //   3422: aload 13
    //   3424: astore 4
    //   3426: getstatic 769	com/tencent/mobileqq/msf/core/net/v:q	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3429: astore 14
    //   3431: aload 17
    //   3433: astore 15
    //   3435: aload 14
    //   3437: astore 4
    //   3439: aload 14
    //   3441: invokevirtual 741	com/tencent/mobileqq/msf/core/net/v:toString	()Ljava/lang/String;
    //   3444: astore 13
    //   3446: goto -388 -> 3058
    //   3449: aload 17
    //   3451: astore 15
    //   3453: aload 13
    //   3455: astore 4
    //   3457: aload 17
    //   3459: ldc_w 771
    //   3462: invokevirtual 763	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3465: iconst_m1
    //   3466: if_icmple +50 -> 3516
    //   3469: aload 17
    //   3471: astore 15
    //   3473: aload 13
    //   3475: astore 4
    //   3477: getstatic 740	com/tencent/mobileqq/msf/core/net/v:m	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3480: astore 14
    //   3482: aload 17
    //   3484: astore 15
    //   3486: aload 14
    //   3488: astore 4
    //   3490: aload 14
    //   3492: invokevirtual 741	com/tencent/mobileqq/msf/core/net/v:toString	()Ljava/lang/String;
    //   3495: astore 13
    //   3497: aload 13
    //   3499: astore 15
    //   3501: aload 14
    //   3503: astore 4
    //   3505: aload 6
    //   3507: invokestatic 744	com/tencent/mobileqq/msf/core/a/a:aD	()I
    //   3510: putfield 746	com/tencent/mobileqq/msf/core/net/a:h	I
    //   3513: goto -455 -> 3058
    //   3516: aload 17
    //   3518: astore 15
    //   3520: aload 13
    //   3522: astore 4
    //   3524: aload 17
    //   3526: ldc_w 773
    //   3529: invokevirtual 763	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3532: iconst_m1
    //   3533: if_icmple +34 -> 3567
    //   3536: aload 17
    //   3538: astore 15
    //   3540: aload 13
    //   3542: astore 4
    //   3544: getstatic 775	com/tencent/mobileqq/msf/core/net/v:i	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3547: astore 14
    //   3549: aload 17
    //   3551: astore 15
    //   3553: aload 14
    //   3555: astore 4
    //   3557: aload 14
    //   3559: invokevirtual 741	com/tencent/mobileqq/msf/core/net/v:toString	()Ljava/lang/String;
    //   3562: astore 13
    //   3564: goto -506 -> 3058
    //   3567: aload 17
    //   3569: astore 15
    //   3571: aload 13
    //   3573: astore 4
    //   3575: aload 17
    //   3577: ldc_w 777
    //   3580: invokevirtual 763	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3583: iconst_m1
    //   3584: if_icmple +34 -> 3618
    //   3587: aload 17
    //   3589: astore 15
    //   3591: aload 13
    //   3593: astore 4
    //   3595: getstatic 779	com/tencent/mobileqq/msf/core/net/v:s	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3598: astore 14
    //   3600: aload 17
    //   3602: astore 15
    //   3604: aload 14
    //   3606: astore 4
    //   3608: aload 14
    //   3610: invokevirtual 741	com/tencent/mobileqq/msf/core/net/v:toString	()Ljava/lang/String;
    //   3613: astore 13
    //   3615: goto -557 -> 3058
    //   3618: aload 17
    //   3620: astore 15
    //   3622: aload 13
    //   3624: astore 4
    //   3626: aload 17
    //   3628: ldc_w 781
    //   3631: invokevirtual 763	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3634: iconst_m1
    //   3635: if_icmple +34 -> 3669
    //   3638: aload 17
    //   3640: astore 15
    //   3642: aload 13
    //   3644: astore 4
    //   3646: getstatic 783	com/tencent/mobileqq/msf/core/net/v:r	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3649: astore 14
    //   3651: aload 17
    //   3653: astore 15
    //   3655: aload 14
    //   3657: astore 4
    //   3659: aload 14
    //   3661: invokevirtual 741	com/tencent/mobileqq/msf/core/net/v:toString	()Ljava/lang/String;
    //   3664: astore 13
    //   3666: goto -608 -> 3058
    //   3669: aload 17
    //   3671: astore 15
    //   3673: aload 13
    //   3675: astore 4
    //   3677: aload 17
    //   3679: ldc_w 785
    //   3682: invokevirtual 763	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3685: iconst_m1
    //   3686: if_icmpgt +23 -> 3709
    //   3689: aload 17
    //   3691: astore 15
    //   3693: aload 13
    //   3695: astore 4
    //   3697: aload 17
    //   3699: ldc_w 787
    //   3702: invokevirtual 763	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3705: iconst_m1
    //   3706: if_icmple +34 -> 3740
    //   3709: aload 17
    //   3711: astore 15
    //   3713: aload 13
    //   3715: astore 4
    //   3717: getstatic 789	com/tencent/mobileqq/msf/core/net/v:t	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3720: astore 14
    //   3722: aload 17
    //   3724: astore 15
    //   3726: aload 14
    //   3728: astore 4
    //   3730: aload 14
    //   3732: invokevirtual 741	com/tencent/mobileqq/msf/core/net/v:toString	()Ljava/lang/String;
    //   3735: astore 13
    //   3737: goto -679 -> 3058
    //   3740: aload 17
    //   3742: astore 15
    //   3744: aload 13
    //   3746: astore 4
    //   3748: aload 17
    //   3750: ldc_w 791
    //   3753: invokevirtual 763	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3756: iconst_m1
    //   3757: if_icmple +34 -> 3791
    //   3760: aload 17
    //   3762: astore 15
    //   3764: aload 13
    //   3766: astore 4
    //   3768: getstatic 793	com/tencent/mobileqq/msf/core/net/v:p	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3771: astore 14
    //   3773: aload 17
    //   3775: astore 15
    //   3777: aload 14
    //   3779: astore 4
    //   3781: aload 14
    //   3783: invokevirtual 741	com/tencent/mobileqq/msf/core/net/v:toString	()Ljava/lang/String;
    //   3786: astore 13
    //   3788: goto -730 -> 3058
    //   3791: aload 17
    //   3793: astore 15
    //   3795: aload 13
    //   3797: astore 4
    //   3799: aload 17
    //   3801: ldc_w 795
    //   3804: invokevirtual 763	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3807: iconst_m1
    //   3808: if_icmple +34 -> 3842
    //   3811: aload 17
    //   3813: astore 15
    //   3815: aload 13
    //   3817: astore 4
    //   3819: getstatic 797	com/tencent/mobileqq/msf/core/net/v:o	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3822: astore 14
    //   3824: aload 17
    //   3826: astore 15
    //   3828: aload 14
    //   3830: astore 4
    //   3832: aload 14
    //   3834: invokevirtual 741	com/tencent/mobileqq/msf/core/net/v:toString	()Ljava/lang/String;
    //   3837: astore 13
    //   3839: goto -781 -> 3058
    //   3842: aload 17
    //   3844: astore 15
    //   3846: aload 13
    //   3848: astore 4
    //   3850: aload 17
    //   3852: ldc_w 799
    //   3855: invokevirtual 763	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3858: iconst_m1
    //   3859: if_icmple +34 -> 3893
    //   3862: aload 17
    //   3864: astore 15
    //   3866: aload 13
    //   3868: astore 4
    //   3870: getstatic 801	com/tencent/mobileqq/msf/core/net/v:h	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3873: astore 14
    //   3875: aload 17
    //   3877: astore 15
    //   3879: aload 14
    //   3881: astore 4
    //   3883: aload 14
    //   3885: invokevirtual 741	com/tencent/mobileqq/msf/core/net/v:toString	()Ljava/lang/String;
    //   3888: astore 13
    //   3890: goto -832 -> 3058
    //   3893: aload 17
    //   3895: astore 15
    //   3897: aload 13
    //   3899: astore 4
    //   3901: aload 17
    //   3903: ldc_w 803
    //   3906: invokevirtual 763	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3909: iconst_m1
    //   3910: if_icmple +34 -> 3944
    //   3913: aload 17
    //   3915: astore 15
    //   3917: aload 13
    //   3919: astore 4
    //   3921: getstatic 805	com/tencent/mobileqq/msf/core/net/v:l	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3924: astore 14
    //   3926: aload 17
    //   3928: astore 15
    //   3930: aload 14
    //   3932: astore 4
    //   3934: aload 14
    //   3936: invokevirtual 741	com/tencent/mobileqq/msf/core/net/v:toString	()Ljava/lang/String;
    //   3939: astore 13
    //   3941: goto -883 -> 3058
    //   3944: aload 17
    //   3946: astore 15
    //   3948: aload 13
    //   3950: astore 4
    //   3952: aload 17
    //   3954: ldc_w 807
    //   3957: invokevirtual 763	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3960: iconst_m1
    //   3961: if_icmple +34 -> 3995
    //   3964: aload 17
    //   3966: astore 15
    //   3968: aload 13
    //   3970: astore 4
    //   3972: getstatic 809	com/tencent/mobileqq/msf/core/net/v:j	Lcom/tencent/mobileqq/msf/core/net/v;
    //   3975: astore 14
    //   3977: aload 17
    //   3979: astore 15
    //   3981: aload 14
    //   3983: astore 4
    //   3985: aload 14
    //   3987: invokevirtual 741	com/tencent/mobileqq/msf/core/net/v:toString	()Ljava/lang/String;
    //   3990: astore 13
    //   3992: goto -934 -> 3058
    //   3995: aload 17
    //   3997: astore 15
    //   3999: aload 13
    //   4001: astore 4
    //   4003: aload 17
    //   4005: ldc_w 811
    //   4008: invokevirtual 763	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4011: iconst_m1
    //   4012: if_icmple +34 -> 4046
    //   4015: aload 17
    //   4017: astore 15
    //   4019: aload 13
    //   4021: astore 4
    //   4023: getstatic 789	com/tencent/mobileqq/msf/core/net/v:t	Lcom/tencent/mobileqq/msf/core/net/v;
    //   4026: astore 14
    //   4028: aload 17
    //   4030: astore 15
    //   4032: aload 14
    //   4034: astore 4
    //   4036: aload 14
    //   4038: invokevirtual 741	com/tencent/mobileqq/msf/core/net/v:toString	()Ljava/lang/String;
    //   4041: astore 13
    //   4043: goto -985 -> 3058
    //   4046: aload 17
    //   4048: astore 15
    //   4050: aload 13
    //   4052: astore 4
    //   4054: aload 17
    //   4056: ldc_w 813
    //   4059: invokevirtual 763	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   4062: iconst_m1
    //   4063: if_icmple +34 -> 4097
    //   4066: aload 17
    //   4068: astore 15
    //   4070: aload 13
    //   4072: astore 4
    //   4074: getstatic 815	com/tencent/mobileqq/msf/core/net/v:n	Lcom/tencent/mobileqq/msf/core/net/v;
    //   4077: astore 14
    //   4079: aload 17
    //   4081: astore 15
    //   4083: aload 14
    //   4085: astore 4
    //   4087: aload 14
    //   4089: invokevirtual 741	com/tencent/mobileqq/msf/core/net/v:toString	()Ljava/lang/String;
    //   4092: astore 13
    //   4094: goto -1036 -> 3058
    //   4097: aload 17
    //   4099: astore 15
    //   4101: aload 13
    //   4103: astore 4
    //   4105: getstatic 817	com/tencent/mobileqq/msf/core/net/v:u	Lcom/tencent/mobileqq/msf/core/net/v;
    //   4108: astore 16
    //   4110: aload 17
    //   4112: astore 15
    //   4114: aload 16
    //   4116: astore 4
    //   4118: aload 18
    //   4120: invokestatic 819	com/tencent/mobileqq/msf/core/net/l:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4123: astore 17
    //   4125: aload 17
    //   4127: astore 13
    //   4129: aload 16
    //   4131: astore 14
    //   4133: aload 17
    //   4135: astore 15
    //   4137: aload 16
    //   4139: astore 4
    //   4141: aload 17
    //   4143: invokevirtual 820	java/lang/String:length	()I
    //   4146: sipush 200
    //   4149: if_icmple -1091 -> 3058
    //   4152: aload 17
    //   4154: astore 15
    //   4156: aload 16
    //   4158: astore 4
    //   4160: aload 17
    //   4162: iconst_0
    //   4163: sipush 200
    //   4166: invokevirtual 824	java/lang/String:substring	(II)Ljava/lang/String;
    //   4169: astore 13
    //   4171: aload 16
    //   4173: astore 14
    //   4175: goto -1117 -> 3058
    //   4178: ldc 243
    //   4180: iconst_1
    //   4181: ldc_w 826
    //   4184: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4187: goto -1622 -> 2565
    //   4190: astore 4
    //   4192: aload 4
    //   4194: invokevirtual 828	java/lang/Exception:printStackTrace	()V
    //   4197: ldc 243
    //   4199: iconst_1
    //   4200: ldc_w 830
    //   4203: aload 4
    //   4205: invokestatic 361	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4208: goto -1616 -> 2592
    //   4211: ldc 243
    //   4213: iconst_1
    //   4214: ldc_w 832
    //   4217: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4220: goto -1628 -> 2592
    //   4223: astore 4
    //   4225: ldc2_w 833
    //   4228: putstatic 715	com/tencent/mobileqq/msf/core/push/d:d	J
    //   4231: ldc 243
    //   4233: iconst_1
    //   4234: ldc_w 836
    //   4237: invokestatic 838	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   4240: goto -1635 -> 2605
    //   4243: aload 14
    //   4245: getstatic 561	com/tencent/mobileqq/msf/core/net/v:c	Lcom/tencent/mobileqq/msf/core/net/v;
    //   4248: if_acmpeq -1602 -> 2646
    //   4251: invokestatic 449	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   4254: getstatic 678	com/tencent/mobileqq/msf/core/net/l:A	I
    //   4257: aload_0
    //   4258: getfield 431	com/tencent/mobileqq/msf/core/net/l:E	J
    //   4261: aload 14
    //   4263: invokevirtual 841	com/tencent/mobileqq/a/a/a:a	(IJLcom/tencent/mobileqq/msf/core/net/v;)V
    //   4266: new 245	java/lang/StringBuilder
    //   4269: dup
    //   4270: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   4273: ldc_w 843
    //   4276: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4279: aload_0
    //   4280: getfield 444	com/tencent/mobileqq/msf/core/net/l:c	Ljava/net/InetSocketAddress;
    //   4283: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4286: ldc_w 845
    //   4289: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4292: aload 6
    //   4294: getfield 658	com/tencent/mobileqq/msf/core/net/a:f	Ljava/lang/String;
    //   4297: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4300: ldc_w 847
    //   4303: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4306: aload_0
    //   4307: getfield 431	com/tencent/mobileqq/msf/core/net/l:E	J
    //   4310: invokevirtual 607	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4313: ldc_w 609
    //   4316: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4319: aload_1
    //   4320: invokevirtual 501	com/tencent/mobileqq/msf/core/d:e	()I
    //   4323: invokevirtual 330	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4326: astore 13
    //   4328: aload_1
    //   4329: getfield 456	com/tencent/mobileqq/msf/core/d:i	Z
    //   4332: ifeq +81 -> 4413
    //   4335: ldc_w 458
    //   4338: astore 4
    //   4340: aload 13
    //   4342: aload 4
    //   4344: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4347: ldc_w 467
    //   4350: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4353: astore 4
    //   4355: aload_1
    //   4356: invokestatic 472	com/tencent/mobileqq/msf/core/net/i:a	(Lcom/tencent/mobileqq/msf/core/d;)Z
    //   4359: ifeq +23 -> 4382
    //   4362: ldc_w 474
    //   4365: astore_1
    //   4366: ldc 243
    //   4368: iconst_1
    //   4369: aload 4
    //   4371: aload_1
    //   4372: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4375: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4378: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4381: return
    //   4382: ldc_w 849
    //   4385: astore_1
    //   4386: goto -20 -> 4366
    //   4389: ldc_w 849
    //   4392: astore 18
    //   4394: goto -3998 -> 396
    //   4397: ldc_w 728
    //   4400: astore 18
    //   4402: goto -2520 -> 1882
    //   4405: ldc_w 851
    //   4408: astore 18
    //   4410: goto -2461 -> 1949
    //   4413: ldc_w 728
    //   4416: astore 4
    //   4418: goto -78 -> 4340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4421	0	this	l
    //   0	4421	1	paramd	com.tencent.mobileqq.msf.core.d
    //   0	4421	2	paramInt1	int
    //   0	4421	3	paramInt2	int
    //   0	4421	4	paramd1	d
    //   0	4421	5	paramBoolean	boolean
    //   0	4421	6	parama	a
    //   160	3160	7	l1	long
    //   140	3178	9	l2	long
    //   135	3111	11	l3	long
    //   164	4177	13	localObject1	Object
    //   156	4106	14	localObject2	Object
    //   168	3987	15	localObject3	Object
    //   105	4067	16	localObject4	Object
    //   109	4052	17	str1	String
    //   315	2336	18	localObject5	Object
    //   2804	187	18	localThrowable	Throwable
    //   3311	808	18	localException	Exception
    //   4392	17	18	str2	String
    //   246	1727	19	localStringBuilder1	StringBuilder
    //   283	137	20	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   174	193	2804	java/lang/Throwable
    //   213	219	2804	java/lang/Throwable
    //   239	248	2804	java/lang/Throwable
    //   268	285	2804	java/lang/Throwable
    //   305	312	2804	java/lang/Throwable
    //   337	364	2804	java/lang/Throwable
    //   384	391	2804	java/lang/Throwable
    //   416	432	2804	java/lang/Throwable
    //   452	457	2804	java/lang/Throwable
    //   477	483	2804	java/lang/Throwable
    //   503	514	2804	java/lang/Throwable
    //   534	542	2804	java/lang/Throwable
    //   562	570	2804	java/lang/Throwable
    //   590	598	2804	java/lang/Throwable
    //   618	625	2804	java/lang/Throwable
    //   645	655	2804	java/lang/Throwable
    //   675	689	2804	java/lang/Throwable
    //   709	724	2804	java/lang/Throwable
    //   744	751	2804	java/lang/Throwable
    //   771	781	2804	java/lang/Throwable
    //   801	815	2804	java/lang/Throwable
    //   835	841	2804	java/lang/Throwable
    //   861	873	2804	java/lang/Throwable
    //   893	900	2804	java/lang/Throwable
    //   920	931	2804	java/lang/Throwable
    //   951	963	2804	java/lang/Throwable
    //   983	998	2804	java/lang/Throwable
    //   1018	1027	2804	java/lang/Throwable
    //   1047	1052	2804	java/lang/Throwable
    //   1072	1079	2804	java/lang/Throwable
    //   1099	1107	2804	java/lang/Throwable
    //   1127	1135	2804	java/lang/Throwable
    //   1155	1166	2804	java/lang/Throwable
    //   1186	1202	2804	java/lang/Throwable
    //   1222	1236	2804	java/lang/Throwable
    //   1256	1276	2804	java/lang/Throwable
    //   1296	1303	2804	java/lang/Throwable
    //   1323	1335	2804	java/lang/Throwable
    //   1355	1365	2804	java/lang/Throwable
    //   1385	1392	2804	java/lang/Throwable
    //   1412	1419	2804	java/lang/Throwable
    //   1439	1447	2804	java/lang/Throwable
    //   1467	1472	2804	java/lang/Throwable
    //   1497	1502	2804	java/lang/Throwable
    //   1522	1525	2804	java/lang/Throwable
    //   1545	1584	2804	java/lang/Throwable
    //   1604	1643	2804	java/lang/Throwable
    //   1663	1669	2804	java/lang/Throwable
    //   1689	1693	2804	java/lang/Throwable
    //   1713	1720	2804	java/lang/Throwable
    //   1740	1752	2804	java/lang/Throwable
    //   1772	1850	2804	java/lang/Throwable
    //   1870	1877	2804	java/lang/Throwable
    //   1902	1917	2804	java/lang/Throwable
    //   1937	1944	2804	java/lang/Throwable
    //   1969	1998	2804	java/lang/Throwable
    //   2018	2026	2804	java/lang/Throwable
    //   2046	2052	2804	java/lang/Throwable
    //   2072	2077	2804	java/lang/Throwable
    //   2102	2111	2804	java/lang/Throwable
    //   2131	2144	2804	java/lang/Throwable
    //   2164	2186	2804	java/lang/Throwable
    //   2206	2216	2804	java/lang/Throwable
    //   2236	2249	2804	java/lang/Throwable
    //   2269	2287	2804	java/lang/Throwable
    //   2307	2321	2804	java/lang/Throwable
    //   2675	2682	2804	java/lang/Throwable
    //   2702	2712	2804	java/lang/Throwable
    //   2732	2744	2804	java/lang/Throwable
    //   2764	2774	2804	java/lang/Throwable
    //   2794	2801	2804	java/lang/Throwable
    //   3182	3189	2804	java/lang/Throwable
    //   3273	3279	2804	java/lang/Throwable
    //   3299	3308	2804	java/lang/Throwable
    //   3333	3344	2804	java/lang/Throwable
    //   116	154	3119	java/lang/InterruptedException
    //   2321	2354	3119	java/lang/InterruptedException
    //   2354	2380	3119	java/lang/InterruptedException
    //   2384	2419	3119	java/lang/InterruptedException
    //   2419	2432	3119	java/lang/InterruptedException
    //   2432	2525	3119	java/lang/InterruptedException
    //   2525	2565	3119	java/lang/InterruptedException
    //   2565	2592	3119	java/lang/InterruptedException
    //   2592	2605	3119	java/lang/InterruptedException
    //   2605	2646	3119	java/lang/InterruptedException
    //   3058	3091	3119	java/lang/InterruptedException
    //   3091	3116	3119	java/lang/InterruptedException
    //   3193	3226	3119	java/lang/InterruptedException
    //   3226	3253	3119	java/lang/InterruptedException
    //   4178	4187	3119	java/lang/InterruptedException
    //   4192	4208	3119	java/lang/InterruptedException
    //   4211	4220	3119	java/lang/InterruptedException
    //   4225	4240	3119	java/lang/InterruptedException
    //   4243	4335	3119	java/lang/InterruptedException
    //   4340	4362	3119	java/lang/InterruptedException
    //   4366	4381	3119	java/lang/InterruptedException
    //   174	193	3192	finally
    //   213	219	3192	finally
    //   239	248	3192	finally
    //   268	285	3192	finally
    //   305	312	3192	finally
    //   337	364	3192	finally
    //   384	391	3192	finally
    //   416	432	3192	finally
    //   452	457	3192	finally
    //   477	483	3192	finally
    //   503	514	3192	finally
    //   534	542	3192	finally
    //   562	570	3192	finally
    //   590	598	3192	finally
    //   618	625	3192	finally
    //   645	655	3192	finally
    //   675	689	3192	finally
    //   709	724	3192	finally
    //   744	751	3192	finally
    //   771	781	3192	finally
    //   801	815	3192	finally
    //   835	841	3192	finally
    //   861	873	3192	finally
    //   893	900	3192	finally
    //   920	931	3192	finally
    //   951	963	3192	finally
    //   983	998	3192	finally
    //   1018	1027	3192	finally
    //   1047	1052	3192	finally
    //   1072	1079	3192	finally
    //   1099	1107	3192	finally
    //   1127	1135	3192	finally
    //   1155	1166	3192	finally
    //   1186	1202	3192	finally
    //   1222	1236	3192	finally
    //   1256	1276	3192	finally
    //   1296	1303	3192	finally
    //   1323	1335	3192	finally
    //   1355	1365	3192	finally
    //   1385	1392	3192	finally
    //   1412	1419	3192	finally
    //   1439	1447	3192	finally
    //   1467	1472	3192	finally
    //   1497	1502	3192	finally
    //   1522	1525	3192	finally
    //   1545	1584	3192	finally
    //   1604	1643	3192	finally
    //   1663	1669	3192	finally
    //   1689	1693	3192	finally
    //   1713	1720	3192	finally
    //   1740	1752	3192	finally
    //   1772	1850	3192	finally
    //   1870	1877	3192	finally
    //   1902	1917	3192	finally
    //   1937	1944	3192	finally
    //   1969	1998	3192	finally
    //   2018	2026	3192	finally
    //   2046	2052	3192	finally
    //   2072	2077	3192	finally
    //   2102	2111	3192	finally
    //   2131	2144	3192	finally
    //   2164	2186	3192	finally
    //   2206	2216	3192	finally
    //   2236	2249	3192	finally
    //   2269	2287	3192	finally
    //   2307	2321	3192	finally
    //   2675	2682	3192	finally
    //   2702	2712	3192	finally
    //   2732	2744	3192	finally
    //   2764	2774	3192	finally
    //   2794	2801	3192	finally
    //   2814	2824	3192	finally
    //   2832	2844	3192	finally
    //   2852	2867	3192	finally
    //   2875	2885	3192	finally
    //   2893	2906	3192	finally
    //   2914	2932	3192	finally
    //   2940	2958	3192	finally
    //   2966	2982	3192	finally
    //   2990	3000	3192	finally
    //   3008	3014	3192	finally
    //   3022	3027	3192	finally
    //   3035	3042	3192	finally
    //   3050	3058	3192	finally
    //   3182	3189	3192	finally
    //   3273	3279	3192	finally
    //   3299	3308	3192	finally
    //   3333	3344	3192	finally
    //   3355	3367	3192	finally
    //   3375	3380	3192	finally
    //   3388	3395	3192	finally
    //   3406	3418	3192	finally
    //   3426	3431	3192	finally
    //   3439	3446	3192	finally
    //   3457	3469	3192	finally
    //   3477	3482	3192	finally
    //   3490	3497	3192	finally
    //   3505	3513	3192	finally
    //   3524	3536	3192	finally
    //   3544	3549	3192	finally
    //   3557	3564	3192	finally
    //   3575	3587	3192	finally
    //   3595	3600	3192	finally
    //   3608	3615	3192	finally
    //   3626	3638	3192	finally
    //   3646	3651	3192	finally
    //   3659	3666	3192	finally
    //   3677	3689	3192	finally
    //   3697	3709	3192	finally
    //   3717	3722	3192	finally
    //   3730	3737	3192	finally
    //   3748	3760	3192	finally
    //   3768	3773	3192	finally
    //   3781	3788	3192	finally
    //   3799	3811	3192	finally
    //   3819	3824	3192	finally
    //   3832	3839	3192	finally
    //   3850	3862	3192	finally
    //   3870	3875	3192	finally
    //   3883	3890	3192	finally
    //   3901	3913	3192	finally
    //   3921	3926	3192	finally
    //   3934	3941	3192	finally
    //   3952	3964	3192	finally
    //   3972	3977	3192	finally
    //   3985	3992	3192	finally
    //   4003	4015	3192	finally
    //   4023	4028	3192	finally
    //   4036	4043	3192	finally
    //   4054	4066	3192	finally
    //   4074	4079	3192	finally
    //   4087	4094	3192	finally
    //   4105	4110	3192	finally
    //   4118	4125	3192	finally
    //   4141	4152	3192	finally
    //   4160	4171	3192	finally
    //   2102	2111	3311	java/lang/Exception
    //   2131	2144	3311	java/lang/Exception
    //   2164	2186	3311	java/lang/Exception
    //   2525	2565	4190	java/lang/Exception
    //   2565	2592	4190	java/lang/Exception
    //   4178	4187	4190	java/lang/Exception
    //   4211	4220	4190	java/lang/Exception
    //   2592	2605	4223	java/lang/Exception
  }
  
  /* Error */
  public void a(com.tencent.qphone.base.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   4: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   7: iconst_0
    //   8: putfield 853	com/tencent/mobileqq/msf/core/af:p	Z
    //   11: aload_0
    //   12: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   15: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   18: iconst_0
    //   19: putfield 226	com/tencent/mobileqq/msf/core/af:q	Z
    //   22: aload_0
    //   23: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   26: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   29: lconst_0
    //   30: putfield 855	com/tencent/mobileqq/msf/core/af:o	J
    //   33: aload_0
    //   34: getfield 444	com/tencent/mobileqq/msf/core/net/l:c	Ljava/net/InetSocketAddress;
    //   37: ifnull +26 -> 63
    //   40: getstatic 857	com/tencent/mobileqq/msf/core/push/d:e	Z
    //   43: ifeq +20 -> 63
    //   46: aload_0
    //   47: getfield 444	com/tencent/mobileqq/msf/core/net/l:c	Ljava/net/InetSocketAddress;
    //   50: invokevirtual 706	java/net/InetSocketAddress:toString	()Ljava/lang/String;
    //   53: invokestatic 711	com/tencent/qphone/base/util/e:b	(Ljava/lang/String;)J
    //   56: putstatic 859	com/tencent/mobileqq/msf/core/push/d:c	J
    //   59: iconst_0
    //   60: putstatic 857	com/tencent/mobileqq/msf/core/push/d:e	Z
    //   63: ldc 243
    //   65: iconst_1
    //   66: new 245	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   73: invokestatic 865	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   76: invokevirtual 868	java/lang/Thread:getName	()Ljava/lang/String;
    //   79: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc_w 870
    //   85: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_1
    //   89: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload_0
    //   99: getfield 392	com/tencent/mobileqq/msf/core/net/l:x	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   102: ifnull +22 -> 124
    //   105: aload_0
    //   106: invokevirtual 395	com/tencent/mobileqq/msf/core/net/l:g	()Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   109: pop
    //   110: aload_0
    //   111: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   114: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   117: aload_0
    //   118: getfield 397	com/tencent/mobileqq/msf/core/net/l:y	Ljava/lang/Runnable;
    //   121: invokevirtual 400	com/tencent/mobileqq/msf/core/af:a	(Ljava/lang/Runnable;)V
    //   124: aload_0
    //   125: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   128: ifnonnull +61 -> 189
    //   131: ldc 243
    //   133: iconst_1
    //   134: new 245	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 872
    //   144: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_1
    //   148: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: return
    //   158: astore 6
    //   160: ldc2_w 833
    //   163: putstatic 859	com/tencent/mobileqq/msf/core/push/d:c	J
    //   166: ldc 243
    //   168: iconst_1
    //   169: ldc_w 874
    //   172: invokestatic 838	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: iconst_0
    //   176: putstatic 857	com/tencent/mobileqq/msf/core/push/d:e	Z
    //   179: goto -116 -> 63
    //   182: astore_1
    //   183: iconst_0
    //   184: putstatic 857	com/tencent/mobileqq/msf/core/push/d:e	Z
    //   187: aload_1
    //   188: athrow
    //   189: invokestatic 877	com/tencent/mobileqq/msf/core/a/a:aH	()Z
    //   192: ifeq +563 -> 755
    //   195: getstatic 301	com/tencent/mobileqq/msf/core/af:s	Z
    //   198: ifeq +49 -> 247
    //   201: invokestatic 305	com/tencent/mobileqq/msf/core/net/a/f:a	()Z
    //   204: ifeq +43 -> 247
    //   207: ldc 243
    //   209: iconst_1
    //   210: ldc_w 879
    //   213: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: aload_0
    //   217: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   220: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   223: getfield 310	com/tencent/mobileqq/msf/core/af:J	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   226: ifnull +21 -> 247
    //   229: aload_0
    //   230: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   233: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   236: getfield 310	com/tencent/mobileqq/msf/core/af:J	Lcom/tencent/mobileqq/msf/core/net/a/f;
    //   239: invokevirtual 313	com/tencent/mobileqq/msf/core/net/a/f:b	()Lcom/tencent/mobileqq/msf/core/net/a/e;
    //   242: invokeinterface 880 1 0
    //   247: iconst_1
    //   248: istore_3
    //   249: invokestatic 881	com/tencent/mobileqq/a/a/f:a	()V
    //   252: invokestatic 449	com/tencent/mobileqq/a/a/a:a	()Lcom/tencent/mobileqq/a/a/a;
    //   255: aload_1
    //   256: invokevirtual 882	com/tencent/mobileqq/a/a/a:a	(Lcom/tencent/qphone/base/a;)V
    //   259: invokestatic 887	com/tencent/mobileqq/a/a/a$b:a	()Lcom/tencent/mobileqq/a/a/a$b;
    //   262: aload_1
    //   263: invokevirtual 888	com/tencent/mobileqq/a/a/a$b:a	(Lcom/tencent/qphone/base/a;)V
    //   266: invokestatic 891	com/tencent/mobileqq/msf/core/a/a:aG	()Z
    //   269: ifeq +6 -> 275
    //   272: invokestatic 894	com/tencent/mobileqq/a/a/d:a	()V
    //   275: aload_0
    //   276: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   279: invokevirtual 895	java/net/Socket:toString	()Ljava/lang/String;
    //   282: astore 6
    //   284: aload_0
    //   285: getfield 119	com/tencent/mobileqq/msf/core/net/l:v	Ljava/util/concurrent/locks/ReentrantLock;
    //   288: ldc2_w 410
    //   291: getstatic 417	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   294: invokevirtual 421	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   297: istore_2
    //   298: iload_2
    //   299: ifeq +526 -> 825
    //   302: aload_0
    //   303: getfield 94	com/tencent/mobileqq/msf/core/net/l:C	Ljava/util/concurrent/atomic/AtomicInteger;
    //   306: iconst_0
    //   307: invokevirtual 624	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   310: aload_0
    //   311: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   314: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   317: aconst_null
    //   318: invokevirtual 680	com/tencent/mobileqq/msf/core/af:a	([B)V
    //   321: aload_0
    //   322: getfield 110	com/tencent/mobileqq/msf/core/net/l:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   325: invokevirtual 195	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   328: istore_2
    //   329: aload_0
    //   330: getfield 83	com/tencent/mobileqq/msf/core/net/l:j	Lcom/tencent/mobileqq/msf/core/net/l$a;
    //   333: ifnull +14 -> 347
    //   336: aload_0
    //   337: getfield 83	com/tencent/mobileqq/msf/core/net/l:j	Lcom/tencent/mobileqq/msf/core/net/l$a;
    //   340: getfield 897	com/tencent/mobileqq/msf/core/net/l$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   343: iconst_0
    //   344: invokevirtual 382	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   347: aload_0
    //   348: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   351: invokevirtual 901	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   354: ifnull +13 -> 367
    //   357: aload_0
    //   358: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   361: invokevirtual 901	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   364: invokevirtual 906	java/io/InputStream:close	()V
    //   367: aload_0
    //   368: getfield 81	com/tencent/mobileqq/msf/core/net/l:h	Ljava/io/OutputStream;
    //   371: astore 7
    //   373: aload 7
    //   375: ifnull +24 -> 399
    //   378: getstatic 74	com/tencent/mobileqq/msf/core/net/l:n	Ljava/util/ArrayList;
    //   381: aload_0
    //   382: getfield 81	com/tencent/mobileqq/msf/core/net/l:h	Ljava/io/OutputStream;
    //   385: invokevirtual 532	java/lang/Object:toString	()Ljava/lang/String;
    //   388: invokevirtual 908	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   391: pop
    //   392: aload_0
    //   393: getfield 81	com/tencent/mobileqq/msf/core/net/l:h	Ljava/io/OutputStream;
    //   396: invokevirtual 909	java/io/OutputStream:close	()V
    //   399: aload_0
    //   400: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   403: astore 7
    //   405: aload 7
    //   407: ifnull +30 -> 437
    //   410: aload_0
    //   411: getfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   414: invokevirtual 910	java/net/Socket:close	()V
    //   417: aload_1
    //   418: invokestatic 913	com/tencent/mobileqq/msf/core/aj:a	(Lcom/tencent/qphone/base/a;)V
    //   421: aload_0
    //   422: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   425: invokevirtual 917	com/tencent/mobileqq/msf/core/MsfCore:getStandyModeManager	()Lcom/tencent/mobileqq/msf/core/d/a;
    //   428: invokevirtual 920	com/tencent/mobileqq/msf/core/d/a:f	()V
    //   431: getstatic 74	com/tencent/mobileqq/msf/core/net/l:n	Ljava/util/ArrayList;
    //   434: invokevirtual 687	java/util/ArrayList:clear	()V
    //   437: aload_0
    //   438: aconst_null
    //   439: putfield 293	com/tencent/mobileqq/msf/core/net/l:g	Ljava/net/Socket;
    //   442: aload_0
    //   443: getfield 110	com/tencent/mobileqq/msf/core/net/l:s	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   446: iconst_0
    //   447: invokevirtual 382	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   450: aload_0
    //   451: aconst_null
    //   452: putfield 197	com/tencent/mobileqq/msf/core/net/l:i	Lcom/tencent/mobileqq/msf/core/net/d;
    //   455: aload_0
    //   456: getfield 119	com/tencent/mobileqq/msf/core/net/l:v	Ljava/util/concurrent/locks/ReentrantLock;
    //   459: invokevirtual 652	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   462: aload_0
    //   463: getfield 114	com/tencent/mobileqq/msf/core/net/l:u	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   466: invokevirtual 195	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   469: ifne +213 -> 682
    //   472: iload_2
    //   473: ifeq +209 -> 682
    //   476: aload_0
    //   477: getfield 133	com/tencent/mobileqq/msf/core/net/l:w	Z
    //   480: ifeq +202 -> 682
    //   483: aload_0
    //   484: getfield 103	com/tencent/mobileqq/msf/core/net/l:q	J
    //   487: lconst_0
    //   488: lcmp
    //   489: ifle +120 -> 609
    //   492: invokestatic 429	java/lang/System:currentTimeMillis	()J
    //   495: aload_0
    //   496: getfield 103	com/tencent/mobileqq/msf/core/net/l:q	J
    //   499: lsub
    //   500: lstore 4
    //   502: aload_0
    //   503: lconst_0
    //   504: putfield 103	com/tencent/mobileqq/msf/core/net/l:q	J
    //   507: aload_0
    //   508: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   511: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   514: invokevirtual 923	com/tencent/mobileqq/msf/core/af:e	()[B
    //   517: invokestatic 929	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   520: astore 7
    //   522: invokestatic 932	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getCurrentAPN	()Ljava/lang/String;
    //   525: astore 8
    //   527: aload_0
    //   528: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   531: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   534: getfield 517	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
    //   537: invokevirtual 934	com/tencent/mobileqq/msf/core/net/m:d	()V
    //   540: aload_0
    //   541: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   544: getfield 222	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
    //   547: getfield 517	com/tencent/mobileqq/msf/core/af:a	Lcom/tencent/mobileqq/msf/core/net/m;
    //   550: lconst_0
    //   551: putfield 935	com/tencent/mobileqq/msf/core/net/m:q	J
    //   554: aload_0
    //   555: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   558: invokevirtual 633	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
    //   561: ifnull +48 -> 609
    //   564: aload_0
    //   565: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   568: invokevirtual 633	com/tencent/mobileqq/msf/core/MsfCore:getStatReporter	()Lcom/tencent/mobileqq/msf/core/c/j;
    //   571: iconst_0
    //   572: lload 4
    //   574: ldc2_w 936
    //   577: ldiv
    //   578: aload_0
    //   579: getfield 205	com/tencent/mobileqq/msf/core/net/l:d	Lcom/tencent/mobileqq/msf/core/d;
    //   582: aload_1
    //   583: getstatic 591	com/tencent/mobileqq/msf/core/af:I	I
    //   586: lload 4
    //   588: aload_0
    //   589: getfield 99	com/tencent/mobileqq/msf/core/net/l:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   592: invokevirtual 939	java/util/concurrent/atomic/AtomicLong:get	()J
    //   595: aload_0
    //   596: getfield 101	com/tencent/mobileqq/msf/core/net/l:p	Ljava/util/concurrent/atomic/AtomicLong;
    //   599: invokevirtual 939	java/util/concurrent/atomic/AtomicLong:get	()J
    //   602: aload 7
    //   604: aload 8
    //   606: invokevirtual 942	com/tencent/mobileqq/msf/core/c/j:a	(ZJLcom/tencent/mobileqq/msf/core/d;Lcom/tencent/qphone/base/a;IJJJLjava/lang/String;Ljava/lang/String;)V
    //   609: ldc 243
    //   611: iconst_1
    //   612: new 245	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   619: ldc_w 944
    //   622: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: aload 6
    //   627: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: ldc_w 946
    //   633: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload_1
    //   637: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   640: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   646: aload_0
    //   647: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   650: aconst_null
    //   651: putfield 690	com/tencent/mobileqq/msf/core/MsfCore:nowSocketConnAdd	Ljava/lang/String;
    //   654: aload_0
    //   655: aconst_null
    //   656: putfield 205	com/tencent/mobileqq/msf/core/net/l:d	Lcom/tencent/mobileqq/msf/core/d;
    //   659: aload_0
    //   660: getfield 99	com/tencent/mobileqq/msf/core/net/l:o	Ljava/util/concurrent/atomic/AtomicLong;
    //   663: lconst_0
    //   664: invokevirtual 527	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   667: aload_0
    //   668: getfield 101	com/tencent/mobileqq/msf/core/net/l:p	Ljava/util/concurrent/atomic/AtomicLong;
    //   671: lconst_0
    //   672: invokevirtual 527	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   675: invokestatic 951	com/tencent/qphone/base/util/CodecWarpper:nativeOnConnClose	()V
    //   678: aload_1
    //   679: invokestatic 954	com/tencent/mobileqq/msf/core/NetConnInfoCenter:onConnClosed	(Lcom/tencent/qphone/base/a;)V
    //   682: aload_0
    //   683: getfield 565	com/tencent/mobileqq/msf/core/net/l:B	Lcom/tencent/mobileqq/msf/core/d;
    //   686: ifnull +28 -> 714
    //   689: aload_0
    //   690: getfield 565	com/tencent/mobileqq/msf/core/net/l:B	Lcom/tencent/mobileqq/msf/core/d;
    //   693: aload_1
    //   694: invokevirtual 957	com/tencent/mobileqq/msf/core/d:a	(Lcom/tencent/qphone/base/a;)Z
    //   697: ifeq +17 -> 714
    //   700: aload_0
    //   701: getfield 131	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   704: invokevirtual 961	com/tencent/mobileqq/msf/core/MsfCore:getSsoListManager	()Lcom/tencent/mobileqq/msf/core/a/d;
    //   707: aload_0
    //   708: getfield 565	com/tencent/mobileqq/msf/core/net/l:B	Lcom/tencent/mobileqq/msf/core/d;
    //   711: invokevirtual 964	com/tencent/mobileqq/msf/core/a/d:a	(Lcom/tencent/mobileqq/msf/core/d;)V
    //   714: aload_0
    //   715: aconst_null
    //   716: putfield 565	com/tencent/mobileqq/msf/core/net/l:B	Lcom/tencent/mobileqq/msf/core/d;
    //   719: ldc_w 569
    //   722: putstatic 571	com/tencent/mobileqq/msf/core/af:G	Ljava/lang/String;
    //   725: ldc_w 849
    //   728: putstatic 586	com/tencent/mobileqq/msf/core/af:H	Ljava/lang/String;
    //   731: return
    //   732: astore_1
    //   733: aload_1
    //   734: invokevirtual 828	java/lang/Exception:printStackTrace	()V
    //   737: return
    //   738: astore 6
    //   740: getstatic 968	com/tencent/mobileqq/msf/core/net/a/a:a	Ljava/lang/String;
    //   743: iconst_1
    //   744: ldc_w 970
    //   747: aload 6
    //   749: invokestatic 361	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   752: goto -505 -> 247
    //   755: iconst_0
    //   756: putstatic 301	com/tencent/mobileqq/msf/core/af:s	Z
    //   759: goto -512 -> 247
    //   762: astore 7
    //   764: aload 7
    //   766: invokevirtual 971	java/lang/Throwable:printStackTrace	()V
    //   769: goto -338 -> 431
    //   772: astore 7
    //   774: goto -337 -> 437
    //   777: astore 7
    //   779: iconst_1
    //   780: istore_2
    //   781: aload_0
    //   782: getfield 119	com/tencent/mobileqq/msf/core/net/l:v	Ljava/util/concurrent/locks/ReentrantLock;
    //   785: invokevirtual 652	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   788: aload 7
    //   790: athrow
    //   791: astore 7
    //   793: ldc 243
    //   795: iconst_1
    //   796: new 245	java/lang/StringBuilder
    //   799: dup
    //   800: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   803: ldc_w 973
    //   806: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: aload 7
    //   811: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   814: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: aload 7
    //   819: invokestatic 361	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   822: goto -360 -> 462
    //   825: aload_0
    //   826: getfield 83	com/tencent/mobileqq/msf/core/net/l:j	Lcom/tencent/mobileqq/msf/core/net/l$a;
    //   829: ifnull +14 -> 843
    //   832: aload_0
    //   833: getfield 83	com/tencent/mobileqq/msf/core/net/l:j	Lcom/tencent/mobileqq/msf/core/net/l$a;
    //   836: getfield 897	com/tencent/mobileqq/msf/core/net/l$a:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   839: iconst_0
    //   840: invokevirtual 382	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   843: ldc 243
    //   845: iconst_1
    //   846: ldc_w 975
    //   849: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   852: aload_0
    //   853: getfield 114	com/tencent/mobileqq/msf/core/net/l:u	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   856: iconst_1
    //   857: invokevirtual 382	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   860: iload_3
    //   861: istore_2
    //   862: aload_0
    //   863: getfield 94	com/tencent/mobileqq/msf/core/net/l:C	Ljava/util/concurrent/atomic/AtomicInteger;
    //   866: iconst_1
    //   867: invokevirtual 978	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   870: bipush 10
    //   872: if_icmpne -410 -> 462
    //   875: invokestatic 983	android/os/Process:myPid	()I
    //   878: invokestatic 986	android/os/Process:killProcess	(I)V
    //   881: iload_3
    //   882: istore_2
    //   883: goto -421 -> 462
    //   886: astore 7
    //   888: iconst_1
    //   889: istore_2
    //   890: goto -97 -> 793
    //   893: astore 6
    //   895: ldc 243
    //   897: iconst_1
    //   898: new 245	java/lang/StringBuilder
    //   901: dup
    //   902: invokespecial 246	java/lang/StringBuilder:<init>	()V
    //   905: ldc_w 988
    //   908: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: aload 6
    //   913: invokevirtual 578	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   916: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   919: aload 6
    //   921: invokestatic 361	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   924: goto -246 -> 678
    //   927: astore 7
    //   929: iconst_1
    //   930: istore_2
    //   931: ldc 87
    //   933: astore 6
    //   935: goto -142 -> 793
    //   938: astore 7
    //   940: goto -147 -> 793
    //   943: astore 7
    //   945: goto -164 -> 781
    //   948: astore 7
    //   950: goto -551 -> 399
    //   953: astore 7
    //   955: goto -588 -> 367
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	958	0	this	l
    //   0	958	1	parama	com.tencent.qphone.base.a
    //   297	634	2	bool1	boolean
    //   248	634	3	bool2	boolean
    //   500	87	4	l1	long
    //   158	1	6	localException1	Exception
    //   282	344	6	str1	String
    //   738	10	6	localException2	Exception
    //   893	27	6	localException3	Exception
    //   933	1	6	str2	String
    //   371	232	7	localObject1	Object
    //   762	3	7	localThrowable1	Throwable
    //   772	1	7	localThrowable2	Throwable
    //   777	12	7	localObject2	Object
    //   791	27	7	localThrowable3	Throwable
    //   886	1	7	localThrowable4	Throwable
    //   927	1	7	localThrowable5	Throwable
    //   938	1	7	localThrowable6	Throwable
    //   943	1	7	localObject3	Object
    //   948	1	7	localException4	Exception
    //   953	1	7	localThrowable7	Throwable
    //   525	80	8	str3	String
    // Exception table:
    //   from	to	target	type
    //   46	59	158	java/lang/Exception
    //   46	59	182	finally
    //   160	175	182	finally
    //   682	714	732	java/lang/Exception
    //   714	731	732	java/lang/Exception
    //   207	247	738	java/lang/Exception
    //   417	431	762	java/lang/Throwable
    //   410	417	772	java/lang/Throwable
    //   431	437	772	java/lang/Throwable
    //   764	769	772	java/lang/Throwable
    //   302	329	777	finally
    //   781	791	791	java/lang/Throwable
    //   284	298	886	java/lang/Throwable
    //   825	843	886	java/lang/Throwable
    //   843	860	886	java/lang/Throwable
    //   862	881	886	java/lang/Throwable
    //   675	678	893	java/lang/Exception
    //   275	284	927	java/lang/Throwable
    //   455	462	938	java/lang/Throwable
    //   329	347	943	finally
    //   347	367	943	finally
    //   367	373	943	finally
    //   378	399	943	finally
    //   399	405	943	finally
    //   410	417	943	finally
    //   417	431	943	finally
    //   431	437	943	finally
    //   437	455	943	finally
    //   764	769	943	finally
    //   378	399	948	java/lang/Exception
    //   347	367	953	java/lang/Throwable
  }
  
  public boolean a()
  {
    return this.r;
  }
  
  public boolean b()
  {
    return this.s.get();
  }
  
  public long c()
  {
    return this.G;
  }
  
  public long d()
  {
    return this.q;
  }
  
  public void e()
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
      a(this.z.getMsfAppid(), 0, localToServiceMsg.getRequestSsoSeq(), localToServiceMsg.getUin(), localToServiceMsg.getServiceCmd(), "", localToServiceMsg.getMsfCommand(), localToServiceMsg.getWupBuffer(), null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("MSF.C.NetConnTag", 1, "send MsgSignal pkg fail, exception ", localException);
    }
  }
  
  public void f()
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
        byte b1 = (byte)"MSF".getBytes().length;
        ByteBuffer localByteBuffer = ByteBuffer.allocate(i1);
        localByteBuffer.putInt(i1).putInt(20140601).putInt(0).put(b1).put("MSF".getBytes()).put((byte)0).putInt(0);
        localToServiceMsg.putWupBuffer(localByteBuffer.array());
        this.x = localToServiceMsg;
        this.z.sender.c(localToServiceMsg);
        localToServiceMsg.getAttributes().put("__timestamp_msf2net", Long.valueOf(SystemClock.elapsedRealtime()));
        if (a(this.z.getMsfAppid(), 0, localToServiceMsg.getRequestSsoSeq(), localToServiceMsg.getUin(), localToServiceMsg.getServiceCmd(), "", localToServiceMsg.getMsfCommand(), localToServiceMsg.getWupBuffer(), null) <= 0) {
          break;
        }
        com.tencent.mobileqq.a.a.a.a().a(localToServiceMsg);
        return;
        localToServiceMsg.setTimeout(10000L);
      }
      this.z.sender.c(localException.getRequestSsoSeq());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("MSF.C.NetConnTag", 1, "send SSOPing pkg fail, exception ", localException);
      return;
    }
    this.z.sender.d(localException);
    QLog.d("MSF.C.NetConnTag", 1, "send SSOPing pkg fail");
    a(com.tencent.qphone.base.a.C);
  }
  
  public ToServiceMsg g()
  {
    if (this.x != null)
    {
      this.z.sender.c(this.x.getRequestSsoSeq());
      this.z.sender.d(this.x);
    }
    return this.x;
  }
  
  abstract class a
    extends Thread
  {
    volatile AtomicBoolean a = new AtomicBoolean(true);
    
    a() {}
    
    public void a() {}
    
    public void run() {}
  }
  
  class b
    extends l.a
  {
    static final String c = "SocketReaderNew";
    final Object d = new Object();
    boolean e = false;
    long f = 0L;
    boolean g = false;
    long h = 0L;
    long i = 0L;
    
    b()
    {
      super();
    }
    
    public void a()
    {
      synchronized (this.d)
      {
        this.d.notifyAll();
        this.e = true;
        QLog.i("SocketReaderNew", 1, "SocketReader(" + this.f + ") onConnOpened");
        return;
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokestatic 84	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   4: invokevirtual 88	java/lang/Thread:getId	()J
      //   7: putfield 39	com/tencent/mobileqq/msf/core/net/l$b:f	J
      //   10: ldc 11
      //   12: iconst_1
      //   13: new 52	java/lang/StringBuilder
      //   16: dup
      //   17: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   20: ldc 55
      //   22: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   25: aload_0
      //   26: getfield 39	com/tencent/mobileqq/msf/core/net/l$b:f	J
      //   29: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   32: ldc 90
      //   34: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   40: invokestatic 73	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   43: ldc 11
      //   45: iconst_1
      //   46: new 52	java/lang/StringBuilder
      //   49: dup
      //   50: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   53: ldc 55
      //   55: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   58: aload_0
      //   59: getfield 39	com/tencent/mobileqq/msf/core/net/l$b:f	J
      //   62: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   65: ldc 92
      //   67: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   70: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   73: invokestatic 73	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   76: aload_0
      //   77: getfield 95	com/tencent/mobileqq/msf/core/net/l$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   80: invokevirtual 101	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   83: ifeq +501 -> 584
      //   86: aload_0
      //   87: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   90: getfield 105	com/tencent/mobileqq/msf/core/net/l:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
      //   93: aload_0
      //   94: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   97: getfield 108	com/tencent/mobileqq/msf/core/net/l:f	I
      //   100: invokevirtual 114	com/tencent/qphone/base/util/MsfSocketInputBuffer:isDataAvailable	(I)Z
      //   103: ifeq +412 -> 515
      //   106: aload_0
      //   107: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   110: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   113: ifnull +33 -> 146
      //   116: aload_0
      //   117: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   120: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   123: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   126: ifnull +20 -> 146
      //   129: aload_0
      //   130: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   133: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   136: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   139: iconst_2
      //   140: invokeinterface 129 2 0
      //   145: pop
      //   146: aload_0
      //   147: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   150: getfield 132	com/tencent/mobileqq/msf/core/net/l:i	Lcom/tencent/mobileqq/msf/core/net/d;
      //   153: aload_0
      //   154: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   157: getfield 105	com/tencent/mobileqq/msf/core/net/l:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
      //   160: invokeinterface 137 2 0
      //   165: aload_0
      //   166: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   169: getfield 141	com/tencent/mobileqq/msf/core/net/l:p	Ljava/util/concurrent/atomic/AtomicLong;
      //   172: aload_0
      //   173: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   176: getfield 105	com/tencent/mobileqq/msf/core/net/l:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
      //   179: invokevirtual 145	com/tencent/qphone/base/util/MsfSocketInputBuffer:getBufferlen	()I
      //   182: i2l
      //   183: invokevirtual 151	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
      //   186: pop2
      //   187: aload_0
      //   188: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   191: getfield 105	com/tencent/mobileqq/msf/core/net/l:k	Lcom/tencent/qphone/base/util/MsfSocketInputBuffer;
      //   194: invokevirtual 154	com/tencent/qphone/base/util/MsfSocketInputBuffer:reset	()V
      //   197: aload_0
      //   198: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   201: invokestatic 159	android/os/SystemClock:uptimeMillis	()J
      //   204: invokestatic 162	com/tencent/mobileqq/msf/core/net/l:a	(Lcom/tencent/mobileqq/msf/core/net/l;J)J
      //   207: pop2
      //   208: aload_0
      //   209: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   212: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   215: ifnull -139 -> 76
      //   218: aload_0
      //   219: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   222: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   225: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   228: ifnull -152 -> 76
      //   231: aload_0
      //   232: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   235: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   238: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   241: iconst_2
      //   242: invokeinterface 165 2 0
      //   247: pop
      //   248: goto -172 -> 76
      //   251: astore_1
      //   252: aload_0
      //   253: getfield 95	com/tencent/mobileqq/msf/core/net/l$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   256: iconst_0
      //   257: invokevirtual 169	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   260: aload_0
      //   261: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   264: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   267: getfield 173	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
      //   270: invokevirtual 177	com/tencent/mobileqq/msf/core/af:h	()V
      //   273: aload_0
      //   274: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   277: getstatic 182	com/tencent/qphone/base/a:c	Lcom/tencent/qphone/base/a;
      //   280: invokevirtual 185	com/tencent/mobileqq/msf/core/net/l:a	(Lcom/tencent/qphone/base/a;)V
      //   283: aload_1
      //   284: invokevirtual 188	java/lang/Throwable:printStackTrace	()V
      //   287: aload_0
      //   288: getfield 45	com/tencent/mobileqq/msf/core/net/l$b:i	J
      //   291: lconst_0
      //   292: lcmp
      //   293: ifle +516 -> 809
      //   296: aload_0
      //   297: getfield 43	com/tencent/mobileqq/msf/core/net/l$b:h	J
      //   300: lconst_0
      //   301: lcmp
      //   302: ifle +507 -> 809
      //   305: aload_0
      //   306: getfield 45	com/tencent/mobileqq/msf/core/net/l$b:i	J
      //   309: aload_0
      //   310: getfield 43	com/tencent/mobileqq/msf/core/net/l$b:h	J
      //   313: lsub
      //   314: ldc2_w 189
      //   317: lcmp
      //   318: ifge +491 -> 809
      //   321: invokestatic 193	android/os/SystemClock:elapsedRealtime	()J
      //   324: aload_0
      //   325: getfield 45	com/tencent/mobileqq/msf/core/net/l$b:i	J
      //   328: lsub
      //   329: ldc2_w 189
      //   332: lcmp
      //   333: ifge +476 -> 809
      //   336: aload_0
      //   337: getfield 41	com/tencent/mobileqq/msf/core/net/l$b:g	Z
      //   340: ifne +88 -> 428
      //   343: aload_0
      //   344: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   347: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   350: getfield 197	com/tencent/mobileqq/msf/core/MsfCore:mtaReporter	Lcom/tencent/mobileqq/msf/core/c/a;
      //   353: ifnull +75 -> 428
      //   356: aload_0
      //   357: iconst_1
      //   358: putfield 41	com/tencent/mobileqq/msf/core/net/l$b:g	Z
      //   361: new 199	java/util/Properties
      //   364: dup
      //   365: invokespecial 200	java/util/Properties:<init>	()V
      //   368: astore_2
      //   369: aload_2
      //   370: ldc 202
      //   372: getstatic 205	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   375: invokevirtual 209	com/tencent/mobileqq/msf/core/MsfCore:getAccountCenter	()Lcom/tencent/mobileqq/msf/core/auth/b;
      //   378: invokevirtual 213	com/tencent/mobileqq/msf/core/auth/b:i	()Ljava/lang/String;
      //   381: invokestatic 219	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   384: invokevirtual 223	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
      //   387: pop
      //   388: aload_2
      //   389: ldc 225
      //   391: aload_1
      //   392: invokevirtual 228	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   395: invokestatic 219	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   398: invokevirtual 223	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
      //   401: pop
      //   402: aload_0
      //   403: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   406: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   409: getfield 197	com/tencent/mobileqq/msf/core/MsfCore:mtaReporter	Lcom/tencent/mobileqq/msf/core/c/a;
      //   412: ldc 230
      //   414: aload_2
      //   415: aload_0
      //   416: getfield 45	com/tencent/mobileqq/msf/core/net/l$b:i	J
      //   419: aload_0
      //   420: getfield 43	com/tencent/mobileqq/msf/core/net/l$b:h	J
      //   423: lsub
      //   424: l2i
      //   425: invokevirtual 236	com/tencent/mobileqq/msf/core/c/a:reportTimeKVEvent	(Ljava/lang/String;Ljava/util/Properties;I)V
      //   428: aload_0
      //   429: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   432: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   435: getfield 173	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
      //   438: invokevirtual 177	com/tencent/mobileqq/msf/core/af:h	()V
      //   441: aload_0
      //   442: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   445: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   448: ifnull +33 -> 481
      //   451: aload_0
      //   452: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   455: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   458: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   461: ifnull +20 -> 481
      //   464: aload_0
      //   465: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   468: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   471: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   474: iconst_2
      //   475: invokeinterface 165 2 0
      //   480: pop
      //   481: ldc 11
      //   483: iconst_1
      //   484: new 52	java/lang/StringBuilder
      //   487: dup
      //   488: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   491: ldc 55
      //   493: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   496: aload_0
      //   497: getfield 39	com/tencent/mobileqq/msf/core/net/l$b:f	J
      //   500: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   503: ldc 238
      //   505: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   508: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   511: invokestatic 73	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   514: return
      //   515: aload_0
      //   516: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   519: invokestatic 159	android/os/SystemClock:uptimeMillis	()J
      //   522: invokestatic 162	com/tencent/mobileqq/msf/core/net/l:a	(Lcom/tencent/mobileqq/msf/core/net/l;J)J
      //   525: pop2
      //   526: aload_0
      //   527: getfield 95	com/tencent/mobileqq/msf/core/net/l$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   530: invokevirtual 101	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   533: ifne -325 -> 208
      //   536: ldc 11
      //   538: iconst_1
      //   539: ldc 240
      //   541: invokestatic 242	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   544: aload_0
      //   545: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   548: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   551: ifnull +33 -> 584
      //   554: aload_0
      //   555: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   558: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   561: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   564: ifnull +20 -> 584
      //   567: aload_0
      //   568: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   571: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   574: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   577: iconst_2
      //   578: invokeinterface 165 2 0
      //   583: pop
      //   584: aload_0
      //   585: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   588: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   591: getfield 173	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
      //   594: invokevirtual 177	com/tencent/mobileqq/msf/core/af:h	()V
      //   597: aload_0
      //   598: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   601: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   604: ifnull +33 -> 637
      //   607: aload_0
      //   608: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   611: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   614: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   617: ifnull +20 -> 637
      //   620: aload_0
      //   621: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   624: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   627: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   630: iconst_2
      //   631: invokeinterface 165 2 0
      //   636: pop
      //   637: ldc 11
      //   639: iconst_1
      //   640: new 52	java/lang/StringBuilder
      //   643: dup
      //   644: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   647: ldc 55
      //   649: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   652: aload_0
      //   653: getfield 39	com/tencent/mobileqq/msf/core/net/l$b:f	J
      //   656: invokevirtual 62	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   659: ldc 244
      //   661: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   664: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   667: invokestatic 73	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   670: aload_0
      //   671: getfield 35	com/tencent/mobileqq/msf/core/net/l$b:d	Ljava/lang/Object;
      //   674: astore_1
      //   675: aload_1
      //   676: monitorenter
      //   677: aload_0
      //   678: getfield 37	com/tencent/mobileqq/msf/core/net/l$b:e	Z
      //   681: ifne +93 -> 774
      //   684: aload_0
      //   685: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   688: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   691: ifnull +33 -> 724
      //   694: aload_0
      //   695: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   698: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   701: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   704: ifnull +20 -> 724
      //   707: aload_0
      //   708: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   711: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   714: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   717: iconst_2
      //   718: invokeinterface 165 2 0
      //   723: pop
      //   724: aload_0
      //   725: getfield 35	com/tencent/mobileqq/msf/core/net/l$b:d	Ljava/lang/Object;
      //   728: ldc2_w 245
      //   731: invokevirtual 250	java/lang/Object:wait	(J)V
      //   734: aload_0
      //   735: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   738: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   741: ifnull +33 -> 774
      //   744: aload_0
      //   745: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   748: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   751: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   754: ifnull +20 -> 774
      //   757: aload_0
      //   758: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   761: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   764: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   767: iconst_2
      //   768: invokeinterface 129 2 0
      //   773: pop
      //   774: aload_0
      //   775: iconst_0
      //   776: putfield 37	com/tencent/mobileqq/msf/core/net/l$b:e	Z
      //   779: aload_1
      //   780: monitorexit
      //   781: aload_0
      //   782: getfield 95	com/tencent/mobileqq/msf/core/net/l$b:a	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   785: iconst_1
      //   786: invokevirtual 169	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
      //   789: goto -746 -> 43
      //   792: astore_1
      //   793: ldc 11
      //   795: iconst_1
      //   796: ldc 252
      //   798: aload_1
      //   799: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   802: aload_1
      //   803: invokevirtual 256	java/lang/Exception:printStackTrace	()V
      //   806: goto -325 -> 481
      //   809: aload_0
      //   810: getfield 43	com/tencent/mobileqq/msf/core/net/l$b:h	J
      //   813: lconst_0
      //   814: lcmp
      //   815: ifne +66 -> 881
      //   818: aload_0
      //   819: invokestatic 193	android/os/SystemClock:elapsedRealtime	()J
      //   822: putfield 43	com/tencent/mobileqq/msf/core/net/l$b:h	J
      //   825: aload_0
      //   826: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   829: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   832: getfield 173	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
      //   835: invokevirtual 177	com/tencent/mobileqq/msf/core/af:h	()V
      //   838: aload_0
      //   839: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   842: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   845: ifnull -208 -> 637
      //   848: aload_0
      //   849: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   852: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   855: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   858: ifnull -221 -> 637
      //   861: aload_0
      //   862: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   865: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   868: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   871: iconst_2
      //   872: invokeinterface 165 2 0
      //   877: pop
      //   878: goto -241 -> 637
      //   881: aload_0
      //   882: getfield 45	com/tencent/mobileqq/msf/core/net/l$b:i	J
      //   885: lconst_0
      //   886: lcmp
      //   887: ifne +77 -> 964
      //   890: aload_0
      //   891: invokestatic 193	android/os/SystemClock:elapsedRealtime	()J
      //   894: putfield 45	com/tencent/mobileqq/msf/core/net/l$b:i	J
      //   897: goto -72 -> 825
      //   900: astore_1
      //   901: aload_1
      //   902: invokevirtual 256	java/lang/Exception:printStackTrace	()V
      //   905: goto -80 -> 825
      //   908: astore_1
      //   909: aload_0
      //   910: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   913: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   916: getfield 173	com/tencent/mobileqq/msf/core/MsfCore:sender	Lcom/tencent/mobileqq/msf/core/af;
      //   919: invokevirtual 177	com/tencent/mobileqq/msf/core/af:h	()V
      //   922: aload_0
      //   923: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   926: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   929: ifnull +33 -> 962
      //   932: aload_0
      //   933: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   936: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   939: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   942: ifnull +20 -> 962
      //   945: aload_0
      //   946: getfield 26	com/tencent/mobileqq/msf/core/net/l$b:j	Lcom/tencent/mobileqq/msf/core/net/l;
      //   949: getfield 118	com/tencent/mobileqq/msf/core/net/l:z	Lcom/tencent/mobileqq/msf/core/MsfCore;
      //   952: getfield 124	com/tencent/mobileqq/msf/core/MsfCore:mMsfMonitorCallback	Lcom/tencent/mobileqq/monitor/MsfMonitorCallback;
      //   955: iconst_2
      //   956: invokeinterface 165 2 0
      //   961: pop
      //   962: aload_1
      //   963: athrow
      //   964: aload_0
      //   965: lconst_0
      //   966: putfield 45	com/tencent/mobileqq/msf/core/net/l$b:i	J
      //   969: aload_0
      //   970: lconst_0
      //   971: putfield 43	com/tencent/mobileqq/msf/core/net/l$b:h	J
      //   974: goto -149 -> 825
      //   977: astore_2
      //   978: aload_1
      //   979: monitorexit
      //   980: aload_2
      //   981: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	982	0	this	b
      //   251	141	1	localThrowable	Throwable
      //   792	11	1	localException1	Exception
      //   900	2	1	localException2	Exception
      //   908	71	1	localObject2	Object
      //   368	47	2	localProperties	java.util.Properties
      //   977	4	2	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   43	76	251	java/lang/Throwable
      //   76	146	251	java/lang/Throwable
      //   146	208	251	java/lang/Throwable
      //   208	248	251	java/lang/Throwable
      //   515	584	251	java/lang/Throwable
      //   670	677	792	java/lang/Exception
      //   781	789	792	java/lang/Exception
      //   980	982	792	java/lang/Exception
      //   287	428	900	java/lang/Exception
      //   809	825	900	java/lang/Exception
      //   881	897	900	java/lang/Exception
      //   964	974	900	java/lang/Exception
      //   43	76	908	finally
      //   76	146	908	finally
      //   146	208	908	finally
      //   208	248	908	finally
      //   252	287	908	finally
      //   287	428	908	finally
      //   515	584	908	finally
      //   809	825	908	finally
      //   881	897	908	finally
      //   901	905	908	finally
      //   964	974	908	finally
      //   677	724	977	finally
      //   724	774	977	finally
      //   774	781	977	finally
      //   978	980	977	finally
    }
  }
  
  class c
    extends l.a
  {
    static final String c = "SocketReaderOld";
    long d = 0L;
    
    c()
    {
      super();
    }
    
    public void a()
    {
      QLog.i("SocketReaderOld", 1, "SocketReader(" + this.d + ") onConnOpened");
    }
    
    public void run()
    {
      this.d = Thread.currentThread().getId();
      QLog.i("SocketReaderOld", 1, "SocketReader(" + this.d + ") initialized");
      while (this.a.get())
      {
        try
        {
          while (!l.this.k.isDataAvailable(l.this.f)) {
            if (!this.a.get())
            {
              l.this.z.sender.h();
              QLog.d("SocketReaderOld", 1, "read over return");
              return;
            }
          }
          if (this.a.get()) {
            break label223;
          }
          l.this.z.sender.h();
          QLog.d("SocketReaderOld", 1, "read end return");
          return;
        }
        catch (Throwable localThrowable)
        {
          if (l.this.z.getStatReporter() != null) {
            l.this.z.getStatReporter().j();
          }
          this.a.set(false);
          QLog.d("SocketReaderOld", 1, "read DataError " + localThrowable);
          l.this.z.sender.h();
          l.this.a(com.tencent.qphone.base.a.c);
        }
        continue;
        label223:
        l.this.i.a(l.this.k);
        l.this.p.addAndGet(l.this.k.getBufferlen());
        l.this.k.reset();
      }
      l.this.z.sender.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.l
 * JD-Core Version:    0.7.0.1
 */