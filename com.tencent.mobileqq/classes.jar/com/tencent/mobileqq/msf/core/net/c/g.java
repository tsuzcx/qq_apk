package com.tencent.mobileqq.msf.core.net.c;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.msf.service.protocol.push.a.b;
import com.tencent.msf.service.protocol.push.a.d;
import com.tencent.msf.service.protocol.push.a.e;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class g
  implements Runnable
{
  private static final String F = "HTTP/1.";
  private static final String G = "Cookie:";
  private static final String H = "Set-Cookie:";
  private static final String I = "Content-Length:";
  private static final String J = "md5=";
  private static final String K = "gateway=";
  private static final String L = ";";
  private static final String M = "\r\n";
  private static final String N = "\r\n\r\n";
  private static final String O = "200";
  private static final int P = 10240;
  private static final int Q = 6;
  private static HostnameVerifier R = new h();
  long A = 0L;
  long B = 0L;
  long C = 0L;
  long D = 0L;
  long E = 0L;
  private String S = "";
  private int T;
  private int U;
  private boolean V = true;
  g.a a;
  d b;
  b c;
  int d;
  int e;
  boolean f = false;
  DatagramSocket g = null;
  Socket h = null;
  OutputStream i = null;
  URL j = null;
  HttpURLConnection k;
  int l = 0;
  int m = 10000;
  InetAddress n = null;
  int o;
  g.d p = new g.d();
  g.c q = new g.c();
  long r = 0L;
  long s = 0L;
  long t = 0L;
  long u = 0L;
  long v = 0L;
  long w = 0L;
  long x = 0L;
  long y = 0L;
  long z = 0L;
  
  public g(d paramd, g.a parama)
  {
    this.b = paramd;
    this.a = parama;
    this.c = null;
    this.d = 1;
    this.e = 0;
  }
  
  public g(d paramd, b paramb, g.a parama, int paramInt1, int paramInt2)
  {
    this.b = paramd;
    this.c = paramb;
    this.a = parama;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  private void a(g.d.a parama)
  {
    if (this.p.c.containsKey(parama))
    {
      int i1 = ((Integer)this.p.c.get(parama)).intValue();
      this.p.c.put(parama, Integer.valueOf(i1 + 1));
      return;
    }
    this.p.c.put(parama, Integer.valueOf(1));
  }
  
  private void a(String paramString)
  {
    if (NetConnInfoCenter.getSystemNetworkType() == 0)
    {
      a(g.d.a.y);
      return;
    }
    if (paramString.indexOf("timeout") > -1)
    {
      a(g.d.a.x);
      return;
    }
    a(g.d.a.e);
  }
  
  private boolean a(int paramInt)
  {
    if (this.a == g.a.c) {
      if (paramInt != 0) {}
    }
    do
    {
      do
      {
        return true;
        if (paramInt > 524288)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + paramInt + " return http");
          }
          this.V = false;
          a(g.d.a.h);
          return false;
        }
      } while (paramInt >= 1);
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, http qualityTestMsg.sPkgData.length:" + this.b.e.length);
      }
      a(g.d.a.i);
      return false;
      if (paramInt > 524288)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + paramInt + " return not http");
        }
        this.V = false;
        a(g.d.a.h);
        return false;
      }
    } while (paramInt >= 1);
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, not http qualityTestMsg.sPkgData.length:" + this.b.e.length);
    }
    a(g.d.a.i);
    return false;
  }
  
  /* Error */
  private boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +45 -> 48
    //   6: ldc 240
    //   8: iconst_2
    //   9: new 242	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 286
    //   19: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: ldc_w 288
    //   29: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   36: getfield 290	com/tencent/msf/service/protocol/push/a/d:o	S
    //   39: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: iload_1
    //   49: ldc 232
    //   51: if_icmple +26 -> 77
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield 134	com/tencent/mobileqq/msf/core/net/c/g:V	Z
    //   59: aload_0
    //   60: getstatic 292	com/tencent/mobileqq/msf/core/net/c/g$d$a:A	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   63: invokespecial 214	com/tencent/mobileqq/msf/core/net/c/g:a	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;)V
    //   66: ldc 240
    //   68: iconst_1
    //   69: ldc_w 294
    //   72: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: iconst_0
    //   76: ireturn
    //   77: getstatic 299	com/tencent/mobileqq/msf/core/net/c/j:a	[I
    //   80: aload_0
    //   81: getfield 166	com/tencent/mobileqq/msf/core/net/c/g:a	Lcom/tencent/mobileqq/msf/core/net/c/g$a;
    //   84: invokevirtual 302	com/tencent/mobileqq/msf/core/net/c/g$a:ordinal	()I
    //   87: iaload
    //   88: tableswitch	default:+3814 -> 3902, 1:+28->116, 2:+958->1046, 3:+2620->2708
    //   117: newarray byte
    //   119: astore 9
    //   121: new 304	java/net/DatagramPacket
    //   124: dup
    //   125: aload 9
    //   127: iload_1
    //   128: invokespecial 307	java/net/DatagramPacket:<init>	([BI)V
    //   131: astore 10
    //   133: aload_0
    //   134: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   137: putfield 148	com/tencent/mobileqq/msf/core/net/c/g:x	J
    //   140: aload_0
    //   141: getfield 106	com/tencent/mobileqq/msf/core/net/c/g:g	Ljava/net/DatagramSocket;
    //   144: aload 10
    //   146: invokevirtual 319	java/net/DatagramSocket:receive	(Ljava/net/DatagramPacket;)V
    //   149: aload_0
    //   150: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   153: putfield 150	com/tencent/mobileqq/msf/core/net/c/g:y	J
    //   156: aload_0
    //   157: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   160: aload_0
    //   161: getfield 144	com/tencent/mobileqq/msf/core/net/c/g:v	J
    //   164: putfield 321	com/tencent/mobileqq/msf/core/net/c/g$d:M	J
    //   167: aload_0
    //   168: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   171: aload_0
    //   172: getfield 150	com/tencent/mobileqq/msf/core/net/c/g:y	J
    //   175: putfield 323	com/tencent/mobileqq/msf/core/net/c/g$d:N	J
    //   178: aload_0
    //   179: aload_0
    //   180: getfield 150	com/tencent/mobileqq/msf/core/net/c/g:y	J
    //   183: aload_0
    //   184: getfield 144	com/tencent/mobileqq/msf/core/net/c/g:v	J
    //   187: lsub
    //   188: putfield 162	com/tencent/mobileqq/msf/core/net/c/g:E	J
    //   191: aload_0
    //   192: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   195: getfield 326	com/tencent/mobileqq/msf/core/net/c/g$d:J	Ljava/util/ArrayList;
    //   198: aload_0
    //   199: getfield 162	com/tencent/mobileqq/msf/core/net/c/g:E	J
    //   202: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   205: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   208: pop
    //   209: aload_0
    //   210: aload_0
    //   211: getfield 158	com/tencent/mobileqq/msf/core/net/c/g:C	J
    //   214: aload_0
    //   215: getfield 150	com/tencent/mobileqq/msf/core/net/c/g:y	J
    //   218: aload_0
    //   219: getfield 148	com/tencent/mobileqq/msf/core/net/c/g:x	J
    //   222: lsub
    //   223: ladd
    //   224: putfield 158	com/tencent/mobileqq/msf/core/net/c/g:C	J
    //   227: aload_0
    //   228: aload_0
    //   229: getfield 160	com/tencent/mobileqq/msf/core/net/c/g:D	J
    //   232: aload 10
    //   234: invokevirtual 339	java/net/DatagramPacket:getLength	()I
    //   237: i2l
    //   238: ladd
    //   239: putfield 160	com/tencent/mobileqq/msf/core/net/c/g:D	J
    //   242: aload_0
    //   243: aload_0
    //   244: getfield 341	com/tencent/mobileqq/msf/core/net/c/g:U	I
    //   247: aload 10
    //   249: invokevirtual 339	java/net/DatagramPacket:getLength	()I
    //   252: iadd
    //   253: putfield 341	com/tencent/mobileqq/msf/core/net/c/g:U	I
    //   256: aload_0
    //   257: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   260: astore 11
    //   262: aload 11
    //   264: aload 11
    //   266: getfield 343	com/tencent/mobileqq/msf/core/net/c/g$d:k	I
    //   269: i2l
    //   270: aload_0
    //   271: getfield 162	com/tencent/mobileqq/msf/core/net/c/g:E	J
    //   274: ladd
    //   275: l2i
    //   276: putfield 343	com/tencent/mobileqq/msf/core/net/c/g$d:k	I
    //   279: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +85 -> 367
    //   285: ldc 240
    //   287: iconst_2
    //   288: new 242	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   295: ldc_w 345
    //   298: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload 10
    //   303: invokevirtual 339	java/net/DatagramPacket:getLength	()I
    //   306: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   309: ldc_w 347
    //   312: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_0
    //   316: getfield 162	com/tencent/mobileqq/msf/core/net/c/g:E	J
    //   319: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   322: ldc_w 352
    //   325: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_0
    //   329: getfield 158	com/tencent/mobileqq/msf/core/net/c/g:C	J
    //   332: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   335: ldc_w 354
    //   338: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_0
    //   342: getfield 160	com/tencent/mobileqq/msf/core/net/c/g:D	J
    //   345: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   348: ldc_w 356
    //   351: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_0
    //   355: getfield 341	com/tencent/mobileqq/msf/core/net/c/g:U	I
    //   358: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   361: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   367: aload_0
    //   368: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   371: getfield 290	com/tencent/msf/service/protocol/push/a/d:o	S
    //   374: ifeq +14 -> 388
    //   377: iconst_1
    //   378: aload_0
    //   379: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   382: getfield 290	com/tencent/msf/service/protocol/push/a/d:o	S
    //   385: if_icmpne +338 -> 723
    //   388: aload_2
    //   389: arraylength
    //   390: bipush 8
    //   392: isub
    //   393: newarray byte
    //   395: astore 10
    //   397: aload_2
    //   398: iconst_0
    //   399: aload 10
    //   401: iconst_0
    //   402: aload 10
    //   404: arraylength
    //   405: invokestatic 360	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   408: iload_1
    //   409: bipush 8
    //   411: isub
    //   412: newarray byte
    //   414: astore_2
    //   415: aload 9
    //   417: iconst_0
    //   418: aload_2
    //   419: iconst_0
    //   420: aload_2
    //   421: arraylength
    //   422: invokestatic 360	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   425: aload 10
    //   427: invokestatic 366	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   430: aload_2
    //   431: invokestatic 366	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   434: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   437: ifne +108 -> 545
    //   440: aload_0
    //   441: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   444: getfield 326	com/tencent/mobileqq/msf/core/net/c/g$d:J	Ljava/util/ArrayList;
    //   447: aload_0
    //   448: getfield 162	com/tencent/mobileqq/msf/core/net/c/g:E	J
    //   451: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   454: invokevirtual 372	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   457: pop
    //   458: new 279	java/lang/Exception
    //   461: dup
    //   462: new 242	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   469: ldc_w 374
    //   472: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: aload_2
    //   476: invokestatic 366	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   479: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokespecial 376	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   488: athrow
    //   489: astore_2
    //   490: aload_0
    //   491: aload_2
    //   492: invokevirtual 377	java/lang/Exception:toString	()Ljava/lang/String;
    //   495: invokevirtual 380	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   498: invokespecial 382	com/tencent/mobileqq/msf/core/net/c/g:a	(Ljava/lang/String;)V
    //   501: ldc 240
    //   503: iconst_1
    //   504: ldc_w 384
    //   507: aload_2
    //   508: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   511: aload_0
    //   512: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   515: astore_2
    //   516: aload_2
    //   517: aload_2
    //   518: getfield 389	com/tencent/mobileqq/msf/core/net/c/g$d:n	I
    //   521: iconst_1
    //   522: iadd
    //   523: putfield 389	com/tencent/mobileqq/msf/core/net/c/g$d:n	I
    //   526: aload_0
    //   527: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   530: getfield 326	com/tencent/mobileqq/msf/core/net/c/g$d:J	Ljava/util/ArrayList;
    //   533: ldc2_w 390
    //   536: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   539: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   542: pop
    //   543: iconst_0
    //   544: ireturn
    //   545: ldc 240
    //   547: iconst_1
    //   548: new 242	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   555: ldc_w 393
    //   558: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: iload_1
    //   562: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   565: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: aload_0
    //   572: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   575: astore_2
    //   576: aload_2
    //   577: aload_2
    //   578: getfield 394	com/tencent/mobileqq/msf/core/net/c/g$d:m	I
    //   581: iconst_1
    //   582: iadd
    //   583: putfield 394	com/tencent/mobileqq/msf/core/net/c/g$d:m	I
    //   586: aload 9
    //   588: ifnull +3316 -> 3904
    //   591: aload 9
    //   593: arraylength
    //   594: iconst_4
    //   595: if_icmplt +3309 -> 3904
    //   598: aload 9
    //   600: iconst_0
    //   601: invokestatic 399	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   604: istore_1
    //   605: ldc 240
    //   607: iconst_1
    //   608: new 242	java/lang/StringBuilder
    //   611: dup
    //   612: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   615: ldc_w 401
    //   618: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: iload_1
    //   622: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   625: ldc_w 403
    //   628: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload 9
    //   633: arraylength
    //   634: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   637: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   640: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   643: aload_0
    //   644: getfield 118	com/tencent/mobileqq/msf/core/net/c/g:n	Ljava/net/InetAddress;
    //   647: instanceof 405
    //   650: ifeq +332 -> 982
    //   653: aload 9
    //   655: arraylength
    //   656: bipush 20
    //   658: if_icmplt +3246 -> 3904
    //   661: bipush 16
    //   663: newarray byte
    //   665: astore_2
    //   666: aload 9
    //   668: aload 9
    //   670: arraylength
    //   671: bipush 16
    //   673: isub
    //   674: aload_2
    //   675: iconst_0
    //   676: bipush 16
    //   678: invokestatic 360	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   681: aload_2
    //   682: invokestatic 411	java/net/InetAddress:getByAddress	([B)Ljava/net/InetAddress;
    //   685: astore_2
    //   686: ldc 240
    //   688: iconst_1
    //   689: new 242	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   696: ldc_w 413
    //   699: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload_2
    //   703: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   706: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   712: aload_0
    //   713: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   716: aload_2
    //   717: putfield 418	com/tencent/mobileqq/msf/core/net/c/g$d:d	Ljava/net/InetAddress;
    //   720: goto +3184 -> 3904
    //   723: iconst_2
    //   724: aload_0
    //   725: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   728: getfield 290	com/tencent/msf/service/protocol/push/a/d:o	S
    //   731: if_icmpne -145 -> 586
    //   734: aload 10
    //   736: invokevirtual 422	java/net/DatagramPacket:getAddress	()Ljava/net/InetAddress;
    //   739: aload_0
    //   740: getfield 118	com/tencent/mobileqq/msf/core/net/c/g:n	Ljava/net/InetAddress;
    //   743: invokevirtual 423	java/net/InetAddress:equals	(Ljava/lang/Object;)Z
    //   746: ifeq +15 -> 761
    //   749: aload 10
    //   751: invokevirtual 426	java/net/DatagramPacket:getPort	()I
    //   754: aload_0
    //   755: getfield 428	com/tencent/mobileqq/msf/core/net/c/g:o	I
    //   758: if_icmpeq +109 -> 867
    //   761: aload_0
    //   762: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   765: astore_2
    //   766: aload_2
    //   767: aload_2
    //   768: getfield 394	com/tencent/mobileqq/msf/core/net/c/g$d:m	I
    //   771: iconst_1
    //   772: iadd
    //   773: putfield 394	com/tencent/mobileqq/msf/core/net/c/g$d:m	I
    //   776: aload_0
    //   777: getstatic 430	com/tencent/mobileqq/msf/core/net/c/g$d$a:v	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   780: invokespecial 214	com/tencent/mobileqq/msf/core/net/c/g:a	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;)V
    //   783: ldc 240
    //   785: iconst_2
    //   786: new 242	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   793: ldc_w 432
    //   796: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: aload_0
    //   800: getfield 118	com/tencent/mobileqq/msf/core/net/c/g:n	Ljava/net/InetAddress;
    //   803: invokevirtual 433	java/net/InetAddress:toString	()Ljava/lang/String;
    //   806: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: ldc_w 435
    //   812: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: aload_0
    //   816: getfield 428	com/tencent/mobileqq/msf/core/net/c/g:o	I
    //   819: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   822: ldc_w 437
    //   825: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: aload 10
    //   830: invokevirtual 422	java/net/DatagramPacket:getAddress	()Ljava/net/InetAddress;
    //   833: invokevirtual 433	java/net/InetAddress:toString	()Ljava/lang/String;
    //   836: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: ldc_w 435
    //   842: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: aload 10
    //   847: invokevirtual 426	java/net/DatagramPacket:getPort	()I
    //   850: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   853: ldc_w 439
    //   856: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   865: iconst_0
    //   866: ireturn
    //   867: ldc 240
    //   869: iconst_2
    //   870: new 242	java/lang/StringBuilder
    //   873: dup
    //   874: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   877: ldc_w 441
    //   880: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: aload_0
    //   884: getfield 118	com/tencent/mobileqq/msf/core/net/c/g:n	Ljava/net/InetAddress;
    //   887: invokevirtual 433	java/net/InetAddress:toString	()Ljava/lang/String;
    //   890: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: ldc_w 435
    //   896: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: aload_0
    //   900: getfield 428	com/tencent/mobileqq/msf/core/net/c/g:o	I
    //   903: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   906: ldc_w 437
    //   909: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: aload 10
    //   914: invokevirtual 422	java/net/DatagramPacket:getAddress	()Ljava/net/InetAddress;
    //   917: invokevirtual 433	java/net/InetAddress:toString	()Ljava/lang/String;
    //   920: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: ldc_w 435
    //   926: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: aload 10
    //   931: invokevirtual 426	java/net/DatagramPacket:getPort	()I
    //   934: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   937: ldc_w 439
    //   940: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   946: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   949: aload_0
    //   950: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   953: astore_2
    //   954: aload_2
    //   955: aload_2
    //   956: getfield 394	com/tencent/mobileqq/msf/core/net/c/g$d:m	I
    //   959: iconst_1
    //   960: iadd
    //   961: putfield 394	com/tencent/mobileqq/msf/core/net/c/g$d:m	I
    //   964: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   967: ifeq -381 -> 586
    //   970: ldc 240
    //   972: iconst_2
    //   973: ldc_w 443
    //   976: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   979: goto -393 -> 586
    //   982: aload 9
    //   984: aload 9
    //   986: arraylength
    //   987: iconst_4
    //   988: isub
    //   989: invokestatic 399	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   992: istore_1
    //   993: iload_1
    //   994: i2l
    //   995: invokestatic 448	com/tencent/qphone/base/util/g:a	(J)Ljava/net/InetAddress;
    //   998: astore_2
    //   999: ldc 240
    //   1001: iconst_1
    //   1002: new 242	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   1009: ldc_w 413
    //   1012: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: aload_2
    //   1016: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1019: ldc_w 450
    //   1022: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: iload_1
    //   1026: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1029: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1032: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1035: aload_0
    //   1036: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1039: aload_2
    //   1040: putfield 418	com/tencent/mobileqq/msf/core/net/c/g$d:d	Ljava/net/InetAddress;
    //   1043: goto +2861 -> 3904
    //   1046: aconst_null
    //   1047: astore 10
    //   1049: aconst_null
    //   1050: astore 9
    //   1052: aload_0
    //   1053: getfield 108	com/tencent/mobileqq/msf/core/net/c/g:h	Ljava/net/Socket;
    //   1056: invokevirtual 456	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   1059: astore 11
    //   1061: aload 11
    //   1063: astore 9
    //   1065: aload 11
    //   1067: astore 10
    //   1069: getstatic 460	com/tencent/mobileqq/msf/core/net/c/m:f	Ljava/util/ArrayList;
    //   1072: aload 11
    //   1074: invokevirtual 461	java/lang/Object:toString	()Ljava/lang/String;
    //   1077: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1080: pop
    //   1081: aload 11
    //   1083: astore 9
    //   1085: aload 11
    //   1087: astore 10
    //   1089: iload_1
    //   1090: newarray byte
    //   1092: astore 12
    //   1094: iconst_0
    //   1095: istore 6
    //   1097: aload 11
    //   1099: astore 9
    //   1101: aload 11
    //   1103: astore 10
    //   1105: aload 11
    //   1107: aload 12
    //   1109: invokevirtual 467	java/io/InputStream:read	([B)I
    //   1112: istore_3
    //   1113: aload 11
    //   1115: astore 9
    //   1117: aload 11
    //   1119: astore 10
    //   1121: aload_0
    //   1122: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   1125: putfield 146	com/tencent/mobileqq/msf/core/net/c/g:w	J
    //   1128: aload 11
    //   1130: astore 9
    //   1132: aload 11
    //   1134: astore 10
    //   1136: aload_0
    //   1137: aload_0
    //   1138: getfield 154	com/tencent/mobileqq/msf/core/net/c/g:A	J
    //   1141: aload_0
    //   1142: getfield 146	com/tencent/mobileqq/msf/core/net/c/g:w	J
    //   1145: aload_0
    //   1146: getfield 144	com/tencent/mobileqq/msf/core/net/c/g:v	J
    //   1149: lsub
    //   1150: ladd
    //   1151: putfield 154	com/tencent/mobileqq/msf/core/net/c/g:A	J
    //   1154: aload 11
    //   1156: astore 9
    //   1158: aload 11
    //   1160: astore 10
    //   1162: ldc 240
    //   1164: iconst_1
    //   1165: new 242	java/lang/StringBuilder
    //   1168: dup
    //   1169: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   1172: ldc_w 469
    //   1175: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: aload_2
    //   1179: arraylength
    //   1180: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1183: ldc_w 471
    //   1186: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: aload_0
    //   1190: getfield 146	com/tencent/mobileqq/msf/core/net/c/g:w	J
    //   1193: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1196: ldc_w 473
    //   1199: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: aload_0
    //   1203: getfield 144	com/tencent/mobileqq/msf/core/net/c/g:v	J
    //   1206: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1209: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1212: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1215: aload 11
    //   1217: astore 9
    //   1219: aload 11
    //   1221: astore 10
    //   1223: aload_0
    //   1224: getfield 146	com/tencent/mobileqq/msf/core/net/c/g:w	J
    //   1227: lstore 7
    //   1229: aload 11
    //   1231: astore 9
    //   1233: aload 11
    //   1235: astore 10
    //   1237: aload_0
    //   1238: lload 7
    //   1240: putfield 148	com/tencent/mobileqq/msf/core/net/c/g:x	J
    //   1243: aload 11
    //   1245: astore 9
    //   1247: aload 11
    //   1249: astore 10
    //   1251: aload_0
    //   1252: lload 7
    //   1254: putfield 150	com/tencent/mobileqq/msf/core/net/c/g:y	J
    //   1257: iload_3
    //   1258: istore 5
    //   1260: iload_3
    //   1261: iconst_m1
    //   1262: if_icmpeq +53 -> 1315
    //   1265: iload_3
    //   1266: istore 4
    //   1268: iload_3
    //   1269: istore 5
    //   1271: iload 4
    //   1273: istore 6
    //   1275: iload 4
    //   1277: iload_1
    //   1278: if_icmpge +37 -> 1315
    //   1281: aload 11
    //   1283: astore 9
    //   1285: aload 11
    //   1287: astore 10
    //   1289: aload 11
    //   1291: aload 12
    //   1293: iload 4
    //   1295: iload_1
    //   1296: iload 4
    //   1298: isub
    //   1299: invokevirtual 476	java/io/InputStream:read	([BII)I
    //   1302: istore_3
    //   1303: iconst_m1
    //   1304: iload_3
    //   1305: if_icmpne +219 -> 1524
    //   1308: iload 4
    //   1310: istore 6
    //   1312: iload_3
    //   1313: istore 5
    //   1315: iconst_m1
    //   1316: iload 5
    //   1318: if_icmpne +381 -> 1699
    //   1321: aload 11
    //   1323: ifnull +23 -> 1346
    //   1326: aload 11
    //   1328: astore 9
    //   1330: aload 11
    //   1332: astore 10
    //   1334: getstatic 460	com/tencent/mobileqq/msf/core/net/c/m:f	Ljava/util/ArrayList;
    //   1337: aload 11
    //   1339: invokevirtual 461	java/lang/Object:toString	()Ljava/lang/String;
    //   1342: invokevirtual 372	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   1345: pop
    //   1346: aload 11
    //   1348: astore 9
    //   1350: aload 11
    //   1352: astore 10
    //   1354: aload_0
    //   1355: getstatic 226	com/tencent/mobileqq/msf/core/net/c/g$d$a:e	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   1358: invokespecial 214	com/tencent/mobileqq/msf/core/net/c/g:a	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;)V
    //   1361: aload 11
    //   1363: astore 9
    //   1365: aload 11
    //   1367: astore 10
    //   1369: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1372: ifeq +48 -> 1420
    //   1375: aload 11
    //   1377: astore 9
    //   1379: aload 11
    //   1381: astore 10
    //   1383: ldc 240
    //   1385: iconst_4
    //   1386: new 242	java/lang/StringBuilder
    //   1389: dup
    //   1390: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   1393: ldc_w 478
    //   1396: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: iload 6
    //   1401: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1404: ldc_w 480
    //   1407: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: iload_1
    //   1411: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1414: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1417: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1420: aload 11
    //   1422: astore 9
    //   1424: aload 11
    //   1426: astore 10
    //   1428: aload_0
    //   1429: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1432: getfield 326	com/tencent/mobileqq/msf/core/net/c/g$d:J	Ljava/util/ArrayList;
    //   1435: ldc2_w 390
    //   1438: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1441: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1444: pop
    //   1445: aload 11
    //   1447: ifnull +2453 -> 3900
    //   1450: aload 11
    //   1452: invokevirtual 483	java/io/InputStream:close	()V
    //   1455: iconst_0
    //   1456: ireturn
    //   1457: astore_2
    //   1458: aload_2
    //   1459: invokevirtual 486	java/lang/Throwable:printStackTrace	()V
    //   1462: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1465: ifeq +2435 -> 3900
    //   1468: ldc 240
    //   1470: iconst_4
    //   1471: ldc_w 488
    //   1474: aload_2
    //   1475: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1478: iconst_0
    //   1479: ireturn
    //   1480: astore_2
    //   1481: aload_0
    //   1482: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1485: astore_2
    //   1486: aload_2
    //   1487: aload_2
    //   1488: getfield 389	com/tencent/mobileqq/msf/core/net/c/g$d:n	I
    //   1491: iconst_1
    //   1492: iadd
    //   1493: putfield 389	com/tencent/mobileqq/msf/core/net/c/g$d:n	I
    //   1496: aload_0
    //   1497: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1500: getfield 326	com/tencent/mobileqq/msf/core/net/c/g$d:J	Ljava/util/ArrayList;
    //   1503: ldc2_w 390
    //   1506: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1509: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1512: pop
    //   1513: ldc 240
    //   1515: iconst_1
    //   1516: ldc_w 490
    //   1519: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1522: iconst_0
    //   1523: ireturn
    //   1524: iload 4
    //   1526: iload_3
    //   1527: iadd
    //   1528: istore 4
    //   1530: aload 11
    //   1532: astore 9
    //   1534: aload 11
    //   1536: astore 10
    //   1538: aload_0
    //   1539: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   1542: putfield 150	com/tencent/mobileqq/msf/core/net/c/g:y	J
    //   1545: goto -277 -> 1268
    //   1548: astore_2
    //   1549: aload 9
    //   1551: ifnull +19 -> 1570
    //   1554: aload 9
    //   1556: astore 10
    //   1558: getstatic 460	com/tencent/mobileqq/msf/core/net/c/m:f	Ljava/util/ArrayList;
    //   1561: aload 9
    //   1563: invokevirtual 461	java/lang/Object:toString	()Ljava/lang/String;
    //   1566: invokevirtual 372	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   1569: pop
    //   1570: aload 9
    //   1572: astore 10
    //   1574: aload_0
    //   1575: aload_2
    //   1576: invokevirtual 377	java/lang/Exception:toString	()Ljava/lang/String;
    //   1579: invokevirtual 380	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1582: invokespecial 382	com/tencent/mobileqq/msf/core/net/c/g:a	(Ljava/lang/String;)V
    //   1585: aload 9
    //   1587: astore 10
    //   1589: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1592: ifeq +17 -> 1609
    //   1595: aload 9
    //   1597: astore 10
    //   1599: ldc 240
    //   1601: iconst_4
    //   1602: ldc_w 492
    //   1605: aload_2
    //   1606: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1609: aload 9
    //   1611: astore 10
    //   1613: aload_0
    //   1614: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1617: astore 11
    //   1619: aload 9
    //   1621: astore 10
    //   1623: aload 11
    //   1625: aload 11
    //   1627: getfield 389	com/tencent/mobileqq/msf/core/net/c/g$d:n	I
    //   1630: iconst_1
    //   1631: iadd
    //   1632: putfield 389	com/tencent/mobileqq/msf/core/net/c/g$d:n	I
    //   1635: aload 9
    //   1637: astore 10
    //   1639: aload_0
    //   1640: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1643: getfield 326	com/tencent/mobileqq/msf/core/net/c/g$d:J	Ljava/util/ArrayList;
    //   1646: ldc2_w 390
    //   1649: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1652: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1655: pop
    //   1656: aload 9
    //   1658: astore 10
    //   1660: aload_2
    //   1661: invokevirtual 493	java/lang/Exception:printStackTrace	()V
    //   1664: aload 9
    //   1666: ifnull +2234 -> 3900
    //   1669: aload 9
    //   1671: invokevirtual 483	java/io/InputStream:close	()V
    //   1674: iconst_0
    //   1675: ireturn
    //   1676: astore_2
    //   1677: aload_2
    //   1678: invokevirtual 486	java/lang/Throwable:printStackTrace	()V
    //   1681: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1684: ifeq +2216 -> 3900
    //   1687: ldc 240
    //   1689: iconst_4
    //   1690: ldc_w 488
    //   1693: aload_2
    //   1694: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1697: iconst_0
    //   1698: ireturn
    //   1699: aload 11
    //   1701: astore 9
    //   1703: aload 11
    //   1705: astore 10
    //   1707: getstatic 460	com/tencent/mobileqq/msf/core/net/c/m:f	Ljava/util/ArrayList;
    //   1710: aload 11
    //   1712: invokevirtual 461	java/lang/Object:toString	()Ljava/lang/String;
    //   1715: invokevirtual 372	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   1718: pop
    //   1719: aload 11
    //   1721: astore 9
    //   1723: aload 11
    //   1725: astore 10
    //   1727: aload_0
    //   1728: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1731: aload_0
    //   1732: getfield 144	com/tencent/mobileqq/msf/core/net/c/g:v	J
    //   1735: putfield 321	com/tencent/mobileqq/msf/core/net/c/g$d:M	J
    //   1738: aload 11
    //   1740: astore 9
    //   1742: aload 11
    //   1744: astore 10
    //   1746: aload_0
    //   1747: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1750: aload_0
    //   1751: getfield 150	com/tencent/mobileqq/msf/core/net/c/g:y	J
    //   1754: putfield 323	com/tencent/mobileqq/msf/core/net/c/g$d:N	J
    //   1757: aload 11
    //   1759: astore 9
    //   1761: aload 11
    //   1763: astore 10
    //   1765: aload_0
    //   1766: aload_0
    //   1767: getfield 150	com/tencent/mobileqq/msf/core/net/c/g:y	J
    //   1770: aload_0
    //   1771: getfield 144	com/tencent/mobileqq/msf/core/net/c/g:v	J
    //   1774: lsub
    //   1775: putfield 162	com/tencent/mobileqq/msf/core/net/c/g:E	J
    //   1778: aload 11
    //   1780: astore 9
    //   1782: aload 11
    //   1784: astore 10
    //   1786: aload_0
    //   1787: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1790: getfield 326	com/tencent/mobileqq/msf/core/net/c/g$d:J	Ljava/util/ArrayList;
    //   1793: aload_0
    //   1794: getfield 162	com/tencent/mobileqq/msf/core/net/c/g:E	J
    //   1797: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1800: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1803: pop
    //   1804: aload 11
    //   1806: astore 9
    //   1808: aload 11
    //   1810: astore 10
    //   1812: aload_0
    //   1813: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1816: astore 13
    //   1818: aload 11
    //   1820: astore 9
    //   1822: aload 11
    //   1824: astore 10
    //   1826: aload 13
    //   1828: aload 13
    //   1830: getfield 343	com/tencent/mobileqq/msf/core/net/c/g$d:k	I
    //   1833: i2l
    //   1834: aload_0
    //   1835: getfield 162	com/tencent/mobileqq/msf/core/net/c/g:E	J
    //   1838: ladd
    //   1839: l2i
    //   1840: putfield 343	com/tencent/mobileqq/msf/core/net/c/g$d:k	I
    //   1843: aload 11
    //   1845: astore 9
    //   1847: aload 11
    //   1849: astore 10
    //   1851: aload_0
    //   1852: aload_0
    //   1853: getfield 158	com/tencent/mobileqq/msf/core/net/c/g:C	J
    //   1856: aload_0
    //   1857: getfield 150	com/tencent/mobileqq/msf/core/net/c/g:y	J
    //   1860: aload_0
    //   1861: getfield 148	com/tencent/mobileqq/msf/core/net/c/g:x	J
    //   1864: lsub
    //   1865: ladd
    //   1866: putfield 158	com/tencent/mobileqq/msf/core/net/c/g:C	J
    //   1869: aload 11
    //   1871: astore 9
    //   1873: aload 11
    //   1875: astore 10
    //   1877: aload_0
    //   1878: aload_0
    //   1879: getfield 160	com/tencent/mobileqq/msf/core/net/c/g:D	J
    //   1882: iload_1
    //   1883: i2l
    //   1884: ladd
    //   1885: putfield 160	com/tencent/mobileqq/msf/core/net/c/g:D	J
    //   1888: aload 11
    //   1890: astore 9
    //   1892: aload 11
    //   1894: astore 10
    //   1896: aload_0
    //   1897: aload_0
    //   1898: getfield 341	com/tencent/mobileqq/msf/core/net/c/g:U	I
    //   1901: iload_1
    //   1902: iadd
    //   1903: putfield 341	com/tencent/mobileqq/msf/core/net/c/g:U	I
    //   1906: aload 11
    //   1908: astore 9
    //   1910: aload 11
    //   1912: astore 10
    //   1914: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1917: ifeq +90 -> 2007
    //   1920: aload 11
    //   1922: astore 9
    //   1924: aload 11
    //   1926: astore 10
    //   1928: ldc 240
    //   1930: iconst_2
    //   1931: new 242	java/lang/StringBuilder
    //   1934: dup
    //   1935: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   1938: ldc_w 495
    //   1941: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1944: iload 6
    //   1946: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1949: ldc_w 347
    //   1952: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1955: aload_0
    //   1956: getfield 162	com/tencent/mobileqq/msf/core/net/c/g:E	J
    //   1959: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1962: ldc_w 352
    //   1965: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1968: aload_0
    //   1969: getfield 158	com/tencent/mobileqq/msf/core/net/c/g:C	J
    //   1972: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1975: ldc_w 354
    //   1978: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1981: aload_0
    //   1982: getfield 160	com/tencent/mobileqq/msf/core/net/c/g:D	J
    //   1985: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1988: ldc_w 356
    //   1991: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1994: aload_0
    //   1995: getfield 341	com/tencent/mobileqq/msf/core/net/c/g:U	I
    //   1998: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2001: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2004: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2007: aload 11
    //   2009: astore 9
    //   2011: aload 11
    //   2013: astore 10
    //   2015: aload_0
    //   2016: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2019: getfield 290	com/tencent/msf/service/protocol/push/a/d:o	S
    //   2022: ifeq +22 -> 2044
    //   2025: aload 11
    //   2027: astore 9
    //   2029: aload 11
    //   2031: astore 10
    //   2033: iconst_1
    //   2034: aload_0
    //   2035: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2038: getfield 290	com/tencent/msf/service/protocol/push/a/d:o	S
    //   2041: if_icmpne +487 -> 2528
    //   2044: aload 11
    //   2046: astore 9
    //   2048: aload 11
    //   2050: astore 10
    //   2052: aload_2
    //   2053: arraylength
    //   2054: bipush 8
    //   2056: isub
    //   2057: newarray byte
    //   2059: astore 13
    //   2061: aload 11
    //   2063: astore 9
    //   2065: aload 11
    //   2067: astore 10
    //   2069: aload_2
    //   2070: iconst_0
    //   2071: aload 13
    //   2073: iconst_0
    //   2074: aload 13
    //   2076: arraylength
    //   2077: invokestatic 360	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2080: aload 11
    //   2082: astore 9
    //   2084: aload 11
    //   2086: astore 10
    //   2088: iload_1
    //   2089: bipush 8
    //   2091: isub
    //   2092: newarray byte
    //   2094: astore_2
    //   2095: aload 11
    //   2097: astore 9
    //   2099: aload 11
    //   2101: astore 10
    //   2103: aload 12
    //   2105: iconst_0
    //   2106: aload_2
    //   2107: iconst_0
    //   2108: aload_2
    //   2109: arraylength
    //   2110: invokestatic 360	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2113: aload 11
    //   2115: astore 9
    //   2117: aload 11
    //   2119: astore 10
    //   2121: aload 13
    //   2123: invokestatic 366	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   2126: aload_2
    //   2127: invokestatic 366	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   2130: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2133: ifne +81 -> 2214
    //   2136: aload 11
    //   2138: astore 9
    //   2140: aload 11
    //   2142: astore 10
    //   2144: aload_0
    //   2145: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   2148: getfield 326	com/tencent/mobileqq/msf/core/net/c/g$d:J	Ljava/util/ArrayList;
    //   2151: aload_0
    //   2152: getfield 162	com/tencent/mobileqq/msf/core/net/c/g:E	J
    //   2155: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2158: invokevirtual 372	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   2161: pop
    //   2162: aload 11
    //   2164: astore 9
    //   2166: aload 11
    //   2168: astore 10
    //   2170: new 279	java/lang/Exception
    //   2173: dup
    //   2174: new 242	java/lang/StringBuilder
    //   2177: dup
    //   2178: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   2181: ldc_w 374
    //   2184: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2187: aload_2
    //   2188: invokestatic 366	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   2191: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2194: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2197: invokespecial 376	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   2200: athrow
    //   2201: astore_2
    //   2202: aload 10
    //   2204: ifnull +8 -> 2212
    //   2207: aload 10
    //   2209: invokevirtual 483	java/io/InputStream:close	()V
    //   2212: aload_2
    //   2213: athrow
    //   2214: aload 11
    //   2216: astore 9
    //   2218: aload 11
    //   2220: astore 10
    //   2222: ldc 240
    //   2224: iconst_1
    //   2225: new 242	java/lang/StringBuilder
    //   2228: dup
    //   2229: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   2232: ldc_w 497
    //   2235: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2238: iload_1
    //   2239: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2242: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2245: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2248: aload 11
    //   2250: astore 9
    //   2252: aload 11
    //   2254: astore 10
    //   2256: aload_0
    //   2257: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   2260: astore_2
    //   2261: aload 11
    //   2263: astore 9
    //   2265: aload 11
    //   2267: astore 10
    //   2269: aload_2
    //   2270: aload_2
    //   2271: getfield 394	com/tencent/mobileqq/msf/core/net/c/g$d:m	I
    //   2274: iconst_1
    //   2275: iadd
    //   2276: putfield 394	com/tencent/mobileqq/msf/core/net/c/g$d:m	I
    //   2279: aload 12
    //   2281: ifnull +210 -> 2491
    //   2284: aload 11
    //   2286: astore 9
    //   2288: aload 11
    //   2290: astore 10
    //   2292: aload 12
    //   2294: arraylength
    //   2295: iconst_4
    //   2296: if_icmplt +195 -> 2491
    //   2299: aload 11
    //   2301: astore 9
    //   2303: aload 11
    //   2305: astore 10
    //   2307: ldc 240
    //   2309: iconst_1
    //   2310: new 242	java/lang/StringBuilder
    //   2313: dup
    //   2314: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   2317: ldc_w 499
    //   2320: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2323: iload_1
    //   2324: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2327: ldc_w 501
    //   2330: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2333: aload_0
    //   2334: getfield 162	com/tencent/mobileqq/msf/core/net/c/g:E	J
    //   2337: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2340: ldc_w 403
    //   2343: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2346: aload 12
    //   2348: arraylength
    //   2349: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2352: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2355: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2358: aload 11
    //   2360: astore 9
    //   2362: aload 11
    //   2364: astore 10
    //   2366: aload_0
    //   2367: getfield 118	com/tencent/mobileqq/msf/core/net/c/g:n	Ljava/net/InetAddress;
    //   2370: instanceof 405
    //   2373: ifeq +239 -> 2612
    //   2376: aload 11
    //   2378: astore 9
    //   2380: aload 11
    //   2382: astore 10
    //   2384: aload 12
    //   2386: arraylength
    //   2387: bipush 20
    //   2389: if_icmplt +102 -> 2491
    //   2392: aload 11
    //   2394: astore 9
    //   2396: aload 11
    //   2398: astore 10
    //   2400: bipush 16
    //   2402: newarray byte
    //   2404: astore_2
    //   2405: aload 11
    //   2407: astore 9
    //   2409: aload 11
    //   2411: astore 10
    //   2413: aload 12
    //   2415: aload 12
    //   2417: arraylength
    //   2418: bipush 16
    //   2420: isub
    //   2421: aload_2
    //   2422: iconst_0
    //   2423: bipush 16
    //   2425: invokestatic 360	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2428: aload 11
    //   2430: astore 9
    //   2432: aload 11
    //   2434: astore 10
    //   2436: aload_2
    //   2437: invokestatic 411	java/net/InetAddress:getByAddress	([B)Ljava/net/InetAddress;
    //   2440: astore_2
    //   2441: aload 11
    //   2443: astore 9
    //   2445: aload 11
    //   2447: astore 10
    //   2449: ldc 240
    //   2451: iconst_1
    //   2452: new 242	java/lang/StringBuilder
    //   2455: dup
    //   2456: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   2459: ldc_w 503
    //   2462: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2465: aload_2
    //   2466: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2469: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2472: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2475: aload 11
    //   2477: astore 9
    //   2479: aload 11
    //   2481: astore 10
    //   2483: aload_0
    //   2484: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   2487: aload_2
    //   2488: putfield 418	com/tencent/mobileqq/msf/core/net/c/g$d:d	Ljava/net/InetAddress;
    //   2491: aload 11
    //   2493: ifnull +1411 -> 3904
    //   2496: aload 11
    //   2498: invokevirtual 483	java/io/InputStream:close	()V
    //   2501: goto +1403 -> 3904
    //   2504: astore_2
    //   2505: aload_2
    //   2506: invokevirtual 486	java/lang/Throwable:printStackTrace	()V
    //   2509: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2512: ifeq +1392 -> 3904
    //   2515: ldc 240
    //   2517: iconst_4
    //   2518: ldc_w 488
    //   2521: aload_2
    //   2522: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2525: goto +1379 -> 3904
    //   2528: aload 11
    //   2530: astore 9
    //   2532: aload 11
    //   2534: astore 10
    //   2536: iconst_2
    //   2537: aload_0
    //   2538: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2541: getfield 290	com/tencent/msf/service/protocol/push/a/d:o	S
    //   2544: if_icmpne -265 -> 2279
    //   2547: aload 11
    //   2549: astore 9
    //   2551: aload 11
    //   2553: astore 10
    //   2555: aload_0
    //   2556: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   2559: astore_2
    //   2560: aload 11
    //   2562: astore 9
    //   2564: aload 11
    //   2566: astore 10
    //   2568: aload_2
    //   2569: aload_2
    //   2570: getfield 394	com/tencent/mobileqq/msf/core/net/c/g$d:m	I
    //   2573: iconst_1
    //   2574: iadd
    //   2575: putfield 394	com/tencent/mobileqq/msf/core/net/c/g$d:m	I
    //   2578: aload 11
    //   2580: astore 9
    //   2582: aload 11
    //   2584: astore 10
    //   2586: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2589: ifeq -310 -> 2279
    //   2592: aload 11
    //   2594: astore 9
    //   2596: aload 11
    //   2598: astore 10
    //   2600: ldc 240
    //   2602: iconst_2
    //   2603: ldc_w 505
    //   2606: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2609: goto -330 -> 2279
    //   2612: aload 11
    //   2614: astore 9
    //   2616: aload 11
    //   2618: astore 10
    //   2620: aload 12
    //   2622: aload 12
    //   2624: arraylength
    //   2625: iconst_4
    //   2626: isub
    //   2627: invokestatic 399	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   2630: istore_1
    //   2631: aload 11
    //   2633: astore 9
    //   2635: aload 11
    //   2637: astore 10
    //   2639: iload_1
    //   2640: i2l
    //   2641: invokestatic 448	com/tencent/qphone/base/util/g:a	(J)Ljava/net/InetAddress;
    //   2644: astore_2
    //   2645: aload 11
    //   2647: astore 9
    //   2649: aload 11
    //   2651: astore 10
    //   2653: ldc 240
    //   2655: iconst_1
    //   2656: new 242	java/lang/StringBuilder
    //   2659: dup
    //   2660: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   2663: ldc_w 503
    //   2666: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2669: aload_2
    //   2670: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2673: ldc_w 450
    //   2676: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2679: iload_1
    //   2680: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2683: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2686: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2689: aload 11
    //   2691: astore 9
    //   2693: aload 11
    //   2695: astore 10
    //   2697: aload_0
    //   2698: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   2701: aload_2
    //   2702: putfield 418	com/tencent/mobileqq/msf/core/net/c/g$d:d	Ljava/net/InetAddress;
    //   2705: goto -214 -> 2491
    //   2708: aconst_null
    //   2709: astore_2
    //   2710: aload_0
    //   2711: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   2714: aload_0
    //   2715: getfield 507	com/tencent/mobileqq/msf/core/net/c/g:k	Ljava/net/HttpURLConnection;
    //   2718: invokevirtual 512	java/net/HttpURLConnection:getResponseCode	()I
    //   2721: putfield 514	com/tencent/mobileqq/msf/core/net/c/g$d:G	I
    //   2724: aload_0
    //   2725: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   2728: aload_0
    //   2729: getfield 507	com/tencent/mobileqq/msf/core/net/c/g:k	Ljava/net/HttpURLConnection;
    //   2732: invokevirtual 517	java/net/HttpURLConnection:getContentLength	()I
    //   2735: putfield 519	com/tencent/mobileqq/msf/core/net/c/g$d:H	I
    //   2738: aload_0
    //   2739: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   2742: putfield 146	com/tencent/mobileqq/msf/core/net/c/g:w	J
    //   2745: aload_0
    //   2746: aload_0
    //   2747: getfield 146	com/tencent/mobileqq/msf/core/net/c/g:w	J
    //   2750: aload_0
    //   2751: getfield 144	com/tencent/mobileqq/msf/core/net/c/g:v	J
    //   2754: lsub
    //   2755: putfield 154	com/tencent/mobileqq/msf/core/net/c/g:A	J
    //   2758: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2761: ifeq +61 -> 2822
    //   2764: ldc 240
    //   2766: iconst_4
    //   2767: new 242	java/lang/StringBuilder
    //   2770: dup
    //   2771: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   2774: ldc_w 521
    //   2777: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2780: aload_0
    //   2781: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   2784: getfield 514	com/tencent/mobileqq/msf/core/net/c/g$d:G	I
    //   2787: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2790: ldc_w 480
    //   2793: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2796: iload_1
    //   2797: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2800: ldc_w 523
    //   2803: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2806: aload_0
    //   2807: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   2810: getfield 519	com/tencent/mobileqq/msf/core/net/c/g$d:H	I
    //   2813: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2816: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2819: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2822: aload_0
    //   2823: getfield 146	com/tencent/mobileqq/msf/core/net/c/g:w	J
    //   2826: lstore 7
    //   2828: aload_0
    //   2829: lload 7
    //   2831: putfield 148	com/tencent/mobileqq/msf/core/net/c/g:x	J
    //   2834: aload_0
    //   2835: lload 7
    //   2837: putfield 150	com/tencent/mobileqq/msf/core/net/c/g:y	J
    //   2840: new 525	java/io/BufferedInputStream
    //   2843: dup
    //   2844: aload_0
    //   2845: getfield 507	com/tencent/mobileqq/msf/core/net/c/g:k	Ljava/net/HttpURLConnection;
    //   2848: invokevirtual 526	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2851: invokespecial 529	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   2854: astore 9
    //   2856: getstatic 460	com/tencent/mobileqq/msf/core/net/c/m:f	Ljava/util/ArrayList;
    //   2859: aload 9
    //   2861: invokevirtual 461	java/lang/Object:toString	()Ljava/lang/String;
    //   2864: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2867: pop
    //   2868: sipush 1024
    //   2871: newarray byte
    //   2873: astore 10
    //   2875: iload_1
    //   2876: newarray byte
    //   2878: astore_2
    //   2879: iconst_0
    //   2880: istore_3
    //   2881: iload_3
    //   2882: iload_1
    //   2883: if_icmpge +311 -> 3194
    //   2886: aload 9
    //   2888: aload 10
    //   2890: invokevirtual 467	java/io/InputStream:read	([B)I
    //   2893: istore 4
    //   2895: iload 4
    //   2897: iconst_m1
    //   2898: if_icmpeq +296 -> 3194
    //   2901: iload 4
    //   2903: iload_1
    //   2904: if_icmple +116 -> 3020
    //   2907: aload 10
    //   2909: iconst_0
    //   2910: aload_2
    //   2911: iload_3
    //   2912: iload_1
    //   2913: invokestatic 360	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2916: iload 4
    //   2918: iload_3
    //   2919: iadd
    //   2920: istore_3
    //   2921: aload_0
    //   2922: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   2925: putfield 150	com/tencent/mobileqq/msf/core/net/c/g:y	J
    //   2928: iload_3
    //   2929: ldc_w 530
    //   2932: if_icmple +965 -> 3897
    //   2935: aload 9
    //   2937: ifnull +15 -> 2952
    //   2940: getstatic 460	com/tencent/mobileqq/msf/core/net/c/m:f	Ljava/util/ArrayList;
    //   2943: aload 9
    //   2945: invokevirtual 461	java/lang/Object:toString	()Ljava/lang/String;
    //   2948: invokevirtual 372	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   2951: pop
    //   2952: aload_0
    //   2953: aload_0
    //   2954: getfield 160	com/tencent/mobileqq/msf/core/net/c/g:D	J
    //   2957: iload_3
    //   2958: i2l
    //   2959: ladd
    //   2960: putfield 160	com/tencent/mobileqq/msf/core/net/c/g:D	J
    //   2963: aload_0
    //   2964: iload_3
    //   2965: aload_0
    //   2966: getfield 341	com/tencent/mobileqq/msf/core/net/c/g:U	I
    //   2969: iadd
    //   2970: putfield 341	com/tencent/mobileqq/msf/core/net/c/g:U	I
    //   2973: aload_0
    //   2974: iconst_0
    //   2975: putfield 134	com/tencent/mobileqq/msf/core/net/c/g:V	Z
    //   2978: aload_0
    //   2979: getstatic 532	com/tencent/mobileqq/msf/core/net/c/g$d$a:u	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   2982: invokespecial 214	com/tencent/mobileqq/msf/core/net/c/g:a	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;)V
    //   2985: aload 9
    //   2987: ifnull +913 -> 3900
    //   2990: aload 9
    //   2992: invokevirtual 483	java/io/InputStream:close	()V
    //   2995: iconst_0
    //   2996: ireturn
    //   2997: astore_2
    //   2998: aload_2
    //   2999: invokevirtual 486	java/lang/Throwable:printStackTrace	()V
    //   3002: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3005: ifeq +895 -> 3900
    //   3008: ldc 240
    //   3010: iconst_4
    //   3011: ldc_w 488
    //   3014: aload_2
    //   3015: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3018: iconst_0
    //   3019: ireturn
    //   3020: iload 4
    //   3022: iload_3
    //   3023: iadd
    //   3024: iload_1
    //   3025: if_icmple +143 -> 3168
    //   3028: aload 10
    //   3030: iconst_0
    //   3031: aload_2
    //   3032: iload_3
    //   3033: iload_1
    //   3034: iload_3
    //   3035: isub
    //   3036: invokestatic 360	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3039: goto -123 -> 2916
    //   3042: astore 10
    //   3044: aload 9
    //   3046: astore_2
    //   3047: aload 10
    //   3049: astore 9
    //   3051: aload_2
    //   3052: ifnull +14 -> 3066
    //   3055: getstatic 460	com/tencent/mobileqq/msf/core/net/c/m:f	Ljava/util/ArrayList;
    //   3058: aload_2
    //   3059: invokevirtual 461	java/lang/Object:toString	()Ljava/lang/String;
    //   3062: invokevirtual 372	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   3065: pop
    //   3066: aload_0
    //   3067: aload 9
    //   3069: invokevirtual 377	java/lang/Exception:toString	()Ljava/lang/String;
    //   3072: invokevirtual 380	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   3075: invokespecial 382	com/tencent/mobileqq/msf/core/net/c/g:a	(Ljava/lang/String;)V
    //   3078: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3081: ifeq +14 -> 3095
    //   3084: ldc 240
    //   3086: iconst_4
    //   3087: ldc_w 534
    //   3090: aload 9
    //   3092: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3095: aload_0
    //   3096: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3099: astore 10
    //   3101: aload 10
    //   3103: aload 10
    //   3105: getfield 389	com/tencent/mobileqq/msf/core/net/c/g$d:n	I
    //   3108: iconst_1
    //   3109: iadd
    //   3110: putfield 389	com/tencent/mobileqq/msf/core/net/c/g$d:n	I
    //   3113: aload_0
    //   3114: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3117: getfield 326	com/tencent/mobileqq/msf/core/net/c/g$d:J	Ljava/util/ArrayList;
    //   3120: ldc2_w 390
    //   3123: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3126: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3129: pop
    //   3130: aload 9
    //   3132: invokevirtual 493	java/lang/Exception:printStackTrace	()V
    //   3135: aload_2
    //   3136: ifnull +764 -> 3900
    //   3139: aload_2
    //   3140: invokevirtual 483	java/io/InputStream:close	()V
    //   3143: iconst_0
    //   3144: ireturn
    //   3145: astore_2
    //   3146: aload_2
    //   3147: invokevirtual 486	java/lang/Throwable:printStackTrace	()V
    //   3150: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3153: ifeq +747 -> 3900
    //   3156: ldc 240
    //   3158: iconst_4
    //   3159: ldc_w 488
    //   3162: aload_2
    //   3163: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3166: iconst_0
    //   3167: ireturn
    //   3168: aload 10
    //   3170: iconst_0
    //   3171: aload_2
    //   3172: iload_3
    //   3173: iload 4
    //   3175: invokestatic 360	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3178: goto -262 -> 2916
    //   3181: astore_2
    //   3182: aload 9
    //   3184: ifnull +8 -> 3192
    //   3187: aload 9
    //   3189: invokevirtual 483	java/io/InputStream:close	()V
    //   3192: aload_2
    //   3193: athrow
    //   3194: getstatic 460	com/tencent/mobileqq/msf/core/net/c/m:f	Ljava/util/ArrayList;
    //   3197: aload 9
    //   3199: invokevirtual 461	java/lang/Object:toString	()Ljava/lang/String;
    //   3202: invokevirtual 372	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   3205: pop
    //   3206: aload_0
    //   3207: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3210: aload_0
    //   3211: getfield 144	com/tencent/mobileqq/msf/core/net/c/g:v	J
    //   3214: putfield 321	com/tencent/mobileqq/msf/core/net/c/g$d:M	J
    //   3217: aload_0
    //   3218: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3221: aload_0
    //   3222: getfield 150	com/tencent/mobileqq/msf/core/net/c/g:y	J
    //   3225: putfield 323	com/tencent/mobileqq/msf/core/net/c/g$d:N	J
    //   3228: aload_0
    //   3229: aload_0
    //   3230: getfield 150	com/tencent/mobileqq/msf/core/net/c/g:y	J
    //   3233: aload_0
    //   3234: getfield 144	com/tencent/mobileqq/msf/core/net/c/g:v	J
    //   3237: lsub
    //   3238: putfield 162	com/tencent/mobileqq/msf/core/net/c/g:E	J
    //   3241: aload_0
    //   3242: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3245: getfield 326	com/tencent/mobileqq/msf/core/net/c/g$d:J	Ljava/util/ArrayList;
    //   3248: aload_0
    //   3249: getfield 162	com/tencent/mobileqq/msf/core/net/c/g:E	J
    //   3252: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3255: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3258: pop
    //   3259: aload_0
    //   3260: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3263: astore 10
    //   3265: aload 10
    //   3267: aload 10
    //   3269: getfield 343	com/tencent/mobileqq/msf/core/net/c/g$d:k	I
    //   3272: i2l
    //   3273: aload_0
    //   3274: getfield 162	com/tencent/mobileqq/msf/core/net/c/g:E	J
    //   3277: ladd
    //   3278: l2i
    //   3279: putfield 343	com/tencent/mobileqq/msf/core/net/c/g$d:k	I
    //   3282: aload_0
    //   3283: aload_0
    //   3284: getfield 158	com/tencent/mobileqq/msf/core/net/c/g:C	J
    //   3287: aload_0
    //   3288: getfield 150	com/tencent/mobileqq/msf/core/net/c/g:y	J
    //   3291: aload_0
    //   3292: getfield 148	com/tencent/mobileqq/msf/core/net/c/g:x	J
    //   3295: lsub
    //   3296: ladd
    //   3297: putfield 158	com/tencent/mobileqq/msf/core/net/c/g:C	J
    //   3300: aload_0
    //   3301: aload_0
    //   3302: getfield 160	com/tencent/mobileqq/msf/core/net/c/g:D	J
    //   3305: iload_3
    //   3306: i2l
    //   3307: ladd
    //   3308: putfield 160	com/tencent/mobileqq/msf/core/net/c/g:D	J
    //   3311: aload_0
    //   3312: aload_0
    //   3313: getfield 341	com/tencent/mobileqq/msf/core/net/c/g:U	I
    //   3316: iload_3
    //   3317: iadd
    //   3318: putfield 341	com/tencent/mobileqq/msf/core/net/c/g:U	I
    //   3321: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3324: ifeq +71 -> 3395
    //   3327: ldc 240
    //   3329: iconst_4
    //   3330: new 242	java/lang/StringBuilder
    //   3333: dup
    //   3334: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   3337: ldc_w 536
    //   3340: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3343: aload_0
    //   3344: getfield 162	com/tencent/mobileqq/msf/core/net/c/g:E	J
    //   3347: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3350: ldc_w 352
    //   3353: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3356: aload_0
    //   3357: getfield 158	com/tencent/mobileqq/msf/core/net/c/g:C	J
    //   3360: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3363: ldc_w 354
    //   3366: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3369: aload_0
    //   3370: getfield 160	com/tencent/mobileqq/msf/core/net/c/g:D	J
    //   3373: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3376: ldc_w 356
    //   3379: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3382: aload_0
    //   3383: getfield 341	com/tencent/mobileqq/msf/core/net/c/g:U	I
    //   3386: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3389: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3392: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3395: aload_0
    //   3396: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3399: getfield 537	com/tencent/msf/service/protocol/push/a/d:x	J
    //   3402: lconst_0
    //   3403: lcmp
    //   3404: ifle +132 -> 3536
    //   3407: aload_0
    //   3408: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3411: getfield 537	com/tencent/msf/service/protocol/push/a/d:x	J
    //   3414: l2i
    //   3415: istore 5
    //   3417: aload_0
    //   3418: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3421: getfield 538	com/tencent/msf/service/protocol/push/a/d:w	J
    //   3424: l2i
    //   3425: istore 6
    //   3427: iload 5
    //   3429: istore 4
    //   3431: iload 5
    //   3433: ldc_w 539
    //   3436: if_icmple +8 -> 3444
    //   3439: ldc_w 539
    //   3442: istore 4
    //   3444: iload_3
    //   3445: iload_1
    //   3446: invokestatic 545	java/lang/Math:min	(II)I
    //   3449: istore 5
    //   3451: iload 6
    //   3453: iload 5
    //   3455: if_icmpge +81 -> 3536
    //   3458: iload 4
    //   3460: iload 6
    //   3462: iadd
    //   3463: iload 5
    //   3465: if_icmple +324 -> 3789
    //   3468: aload_0
    //   3469: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3472: new 218	java/lang/String
    //   3475: dup
    //   3476: aload_2
    //   3477: iload 6
    //   3479: iload 5
    //   3481: iload 6
    //   3483: isub
    //   3484: invokespecial 548	java/lang/String:<init>	([BII)V
    //   3487: putfield 550	com/tencent/mobileqq/msf/core/net/c/g$d:P	Ljava/lang/String;
    //   3490: aload_0
    //   3491: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3494: iload 5
    //   3496: iload 6
    //   3498: isub
    //   3499: putfield 552	com/tencent/mobileqq/msf/core/net/c/g$d:O	I
    //   3502: aload_0
    //   3503: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3506: aload_0
    //   3507: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3510: getfield 550	com/tencent/mobileqq/msf/core/net/c/g$d:P	Ljava/lang/String;
    //   3513: invokestatic 555	com/tencent/qphone/base/util/g:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3516: putfield 550	com/tencent/mobileqq/msf/core/net/c/g$d:P	Ljava/lang/String;
    //   3519: aload_0
    //   3520: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3523: aload_0
    //   3524: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3527: getfield 550	com/tencent/mobileqq/msf/core/net/c/g$d:P	Ljava/lang/String;
    //   3530: invokevirtual 558	java/lang/String:length	()I
    //   3533: putfield 552	com/tencent/mobileqq/msf/core/net/c/g$d:O	I
    //   3536: new 218	java/lang/String
    //   3539: dup
    //   3540: aload_2
    //   3541: iconst_0
    //   3542: iload_3
    //   3543: aload_2
    //   3544: arraylength
    //   3545: invokestatic 545	java/lang/Math:min	(II)I
    //   3548: invokespecial 548	java/lang/String:<init>	([BII)V
    //   3551: astore_2
    //   3552: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3555: ifeq +29 -> 3584
    //   3558: ldc 240
    //   3560: iconst_4
    //   3561: new 242	java/lang/StringBuilder
    //   3564: dup
    //   3565: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   3568: ldc_w 560
    //   3571: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3574: aload_2
    //   3575: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3578: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3581: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3584: aload_2
    //   3585: aload_0
    //   3586: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3589: getfield 562	com/tencent/msf/service/protocol/push/a/d:t	Ljava/lang/String;
    //   3592: invokevirtual 566	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3595: ifne +11 -> 3606
    //   3598: aload_0
    //   3599: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3602: iconst_1
    //   3603: putfield 568	com/tencent/mobileqq/msf/core/net/c/g$d:F	I
    //   3606: aload_0
    //   3607: aload_0
    //   3608: getfield 507	com/tencent/mobileqq/msf/core/net/c/g:k	Ljava/net/HttpURLConnection;
    //   3611: ldc_w 570
    //   3614: invokevirtual 573	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   3617: invokespecial 575	com/tencent/mobileqq/msf/core/net/c/g:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3620: astore_2
    //   3621: aload_2
    //   3622: ifnull +50 -> 3672
    //   3625: aload_2
    //   3626: invokestatic 579	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   3629: astore 10
    //   3631: aload_0
    //   3632: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3635: aload 10
    //   3637: putfield 418	com/tencent/mobileqq/msf/core/net/c/g$d:d	Ljava/net/InetAddress;
    //   3640: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3643: ifeq +29 -> 3672
    //   3646: ldc 240
    //   3648: iconst_4
    //   3649: new 242	java/lang/StringBuilder
    //   3652: dup
    //   3653: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   3656: ldc_w 581
    //   3659: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3662: aload_2
    //   3663: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3666: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3669: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3672: aload_0
    //   3673: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3676: astore_2
    //   3677: aload_2
    //   3678: aload_2
    //   3679: getfield 394	com/tencent/mobileqq/msf/core/net/c/g$d:m	I
    //   3682: iconst_1
    //   3683: iadd
    //   3684: putfield 394	com/tencent/mobileqq/msf/core/net/c/g$d:m	I
    //   3687: ldc 240
    //   3689: iconst_1
    //   3690: new 242	java/lang/StringBuilder
    //   3693: dup
    //   3694: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   3697: ldc_w 583
    //   3700: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3703: iload_3
    //   3704: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3707: ldc_w 585
    //   3710: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3713: iload_1
    //   3714: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3717: ldc_w 587
    //   3720: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3723: aload_0
    //   3724: getfield 162	com/tencent/mobileqq/msf/core/net/c/g:E	J
    //   3727: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3730: ldc_w 589
    //   3733: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3736: aload_0
    //   3737: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3740: getfield 562	com/tencent/msf/service/protocol/push/a/d:t	Ljava/lang/String;
    //   3743: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3746: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3749: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3752: aload 9
    //   3754: ifnull +150 -> 3904
    //   3757: aload 9
    //   3759: invokevirtual 483	java/io/InputStream:close	()V
    //   3762: goto +142 -> 3904
    //   3765: astore_2
    //   3766: aload_2
    //   3767: invokevirtual 486	java/lang/Throwable:printStackTrace	()V
    //   3770: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3773: ifeq +131 -> 3904
    //   3776: ldc 240
    //   3778: iconst_4
    //   3779: ldc_w 488
    //   3782: aload_2
    //   3783: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3786: goto +118 -> 3904
    //   3789: aload_0
    //   3790: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3793: new 218	java/lang/String
    //   3796: dup
    //   3797: aload_2
    //   3798: iload 6
    //   3800: iload 4
    //   3802: invokespecial 548	java/lang/String:<init>	([BII)V
    //   3805: putfield 550	com/tencent/mobileqq/msf/core/net/c/g$d:P	Ljava/lang/String;
    //   3808: aload_0
    //   3809: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3812: iload 4
    //   3814: putfield 552	com/tencent/mobileqq/msf/core/net/c/g$d:O	I
    //   3817: goto -315 -> 3502
    //   3820: astore 9
    //   3822: aload 9
    //   3824: invokevirtual 486	java/lang/Throwable:printStackTrace	()V
    //   3827: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3830: ifeq -1618 -> 2212
    //   3833: ldc 240
    //   3835: iconst_4
    //   3836: ldc_w 488
    //   3839: aload 9
    //   3841: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3844: goto -1632 -> 2212
    //   3847: astore 9
    //   3849: aload 9
    //   3851: invokevirtual 486	java/lang/Throwable:printStackTrace	()V
    //   3854: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3857: ifeq -665 -> 3192
    //   3860: ldc 240
    //   3862: iconst_4
    //   3863: ldc_w 488
    //   3866: aload 9
    //   3868: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3871: goto -679 -> 3192
    //   3874: astore_2
    //   3875: aconst_null
    //   3876: astore 9
    //   3878: goto -696 -> 3182
    //   3881: astore 10
    //   3883: aload_2
    //   3884: astore 9
    //   3886: aload 10
    //   3888: astore_2
    //   3889: goto -707 -> 3182
    //   3892: astore 9
    //   3894: goto -843 -> 3051
    //   3897: goto -1016 -> 2881
    //   3900: iconst_0
    //   3901: ireturn
    //   3902: iconst_0
    //   3903: ireturn
    //   3904: iconst_1
    //   3905: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3906	0	this	g
    //   0	3906	1	paramInt	int
    //   0	3906	2	paramArrayOfByte	byte[]
    //   1112	2592	3	i1	int
    //   1266	2547	4	i2	int
    //   1258	2241	5	i3	int
    //   1095	2704	6	i4	int
    //   1227	1609	7	l1	long
    //   119	3639	9	localObject1	Object
    //   3820	20	9	localThrowable1	Throwable
    //   3847	20	9	localThrowable2	Throwable
    //   3876	9	9	arrayOfByte1	byte[]
    //   3892	1	9	localException1	Exception
    //   131	2898	10	localObject2	Object
    //   3042	6	10	localException2	Exception
    //   3099	537	10	localObject3	Object
    //   3881	6	10	localObject4	Object
    //   260	2434	11	localObject5	Object
    //   1092	1531	12	arrayOfByte2	byte[]
    //   1816	306	13	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   133	367	489	java/lang/Exception
    //   367	388	489	java/lang/Exception
    //   388	489	489	java/lang/Exception
    //   545	586	489	java/lang/Exception
    //   591	720	489	java/lang/Exception
    //   723	761	489	java/lang/Exception
    //   761	865	489	java/lang/Exception
    //   867	979	489	java/lang/Exception
    //   982	1043	489	java/lang/Exception
    //   1450	1455	1457	java/lang/Throwable
    //   54	75	1480	java/lang/Exception
    //   77	116	1480	java/lang/Exception
    //   116	133	1480	java/lang/Exception
    //   490	543	1480	java/lang/Exception
    //   1450	1455	1480	java/lang/Exception
    //   1458	1478	1480	java/lang/Exception
    //   1669	1674	1480	java/lang/Exception
    //   1677	1697	1480	java/lang/Exception
    //   2207	2212	1480	java/lang/Exception
    //   2212	2214	1480	java/lang/Exception
    //   2496	2501	1480	java/lang/Exception
    //   2505	2525	1480	java/lang/Exception
    //   2990	2995	1480	java/lang/Exception
    //   2998	3018	1480	java/lang/Exception
    //   3139	3143	1480	java/lang/Exception
    //   3146	3166	1480	java/lang/Exception
    //   3187	3192	1480	java/lang/Exception
    //   3192	3194	1480	java/lang/Exception
    //   3757	3762	1480	java/lang/Exception
    //   3766	3786	1480	java/lang/Exception
    //   3822	3844	1480	java/lang/Exception
    //   3849	3871	1480	java/lang/Exception
    //   1052	1061	1548	java/lang/Exception
    //   1069	1081	1548	java/lang/Exception
    //   1089	1094	1548	java/lang/Exception
    //   1105	1113	1548	java/lang/Exception
    //   1121	1128	1548	java/lang/Exception
    //   1136	1154	1548	java/lang/Exception
    //   1162	1215	1548	java/lang/Exception
    //   1223	1229	1548	java/lang/Exception
    //   1237	1243	1548	java/lang/Exception
    //   1251	1257	1548	java/lang/Exception
    //   1289	1303	1548	java/lang/Exception
    //   1334	1346	1548	java/lang/Exception
    //   1354	1361	1548	java/lang/Exception
    //   1369	1375	1548	java/lang/Exception
    //   1383	1420	1548	java/lang/Exception
    //   1428	1445	1548	java/lang/Exception
    //   1538	1545	1548	java/lang/Exception
    //   1707	1719	1548	java/lang/Exception
    //   1727	1738	1548	java/lang/Exception
    //   1746	1757	1548	java/lang/Exception
    //   1765	1778	1548	java/lang/Exception
    //   1786	1804	1548	java/lang/Exception
    //   1812	1818	1548	java/lang/Exception
    //   1826	1843	1548	java/lang/Exception
    //   1851	1869	1548	java/lang/Exception
    //   1877	1888	1548	java/lang/Exception
    //   1896	1906	1548	java/lang/Exception
    //   1914	1920	1548	java/lang/Exception
    //   1928	2007	1548	java/lang/Exception
    //   2015	2025	1548	java/lang/Exception
    //   2033	2044	1548	java/lang/Exception
    //   2052	2061	1548	java/lang/Exception
    //   2069	2080	1548	java/lang/Exception
    //   2088	2095	1548	java/lang/Exception
    //   2103	2113	1548	java/lang/Exception
    //   2121	2136	1548	java/lang/Exception
    //   2144	2162	1548	java/lang/Exception
    //   2170	2201	1548	java/lang/Exception
    //   2222	2248	1548	java/lang/Exception
    //   2256	2261	1548	java/lang/Exception
    //   2269	2279	1548	java/lang/Exception
    //   2292	2299	1548	java/lang/Exception
    //   2307	2358	1548	java/lang/Exception
    //   2366	2376	1548	java/lang/Exception
    //   2384	2392	1548	java/lang/Exception
    //   2400	2405	1548	java/lang/Exception
    //   2413	2428	1548	java/lang/Exception
    //   2436	2441	1548	java/lang/Exception
    //   2449	2475	1548	java/lang/Exception
    //   2483	2491	1548	java/lang/Exception
    //   2536	2547	1548	java/lang/Exception
    //   2555	2560	1548	java/lang/Exception
    //   2568	2578	1548	java/lang/Exception
    //   2586	2592	1548	java/lang/Exception
    //   2600	2609	1548	java/lang/Exception
    //   2620	2631	1548	java/lang/Exception
    //   2639	2645	1548	java/lang/Exception
    //   2653	2689	1548	java/lang/Exception
    //   2697	2705	1548	java/lang/Exception
    //   1669	1674	1676	java/lang/Throwable
    //   1052	1061	2201	finally
    //   1069	1081	2201	finally
    //   1089	1094	2201	finally
    //   1105	1113	2201	finally
    //   1121	1128	2201	finally
    //   1136	1154	2201	finally
    //   1162	1215	2201	finally
    //   1223	1229	2201	finally
    //   1237	1243	2201	finally
    //   1251	1257	2201	finally
    //   1289	1303	2201	finally
    //   1334	1346	2201	finally
    //   1354	1361	2201	finally
    //   1369	1375	2201	finally
    //   1383	1420	2201	finally
    //   1428	1445	2201	finally
    //   1538	1545	2201	finally
    //   1558	1570	2201	finally
    //   1574	1585	2201	finally
    //   1589	1595	2201	finally
    //   1599	1609	2201	finally
    //   1613	1619	2201	finally
    //   1623	1635	2201	finally
    //   1639	1656	2201	finally
    //   1660	1664	2201	finally
    //   1707	1719	2201	finally
    //   1727	1738	2201	finally
    //   1746	1757	2201	finally
    //   1765	1778	2201	finally
    //   1786	1804	2201	finally
    //   1812	1818	2201	finally
    //   1826	1843	2201	finally
    //   1851	1869	2201	finally
    //   1877	1888	2201	finally
    //   1896	1906	2201	finally
    //   1914	1920	2201	finally
    //   1928	2007	2201	finally
    //   2015	2025	2201	finally
    //   2033	2044	2201	finally
    //   2052	2061	2201	finally
    //   2069	2080	2201	finally
    //   2088	2095	2201	finally
    //   2103	2113	2201	finally
    //   2121	2136	2201	finally
    //   2144	2162	2201	finally
    //   2170	2201	2201	finally
    //   2222	2248	2201	finally
    //   2256	2261	2201	finally
    //   2269	2279	2201	finally
    //   2292	2299	2201	finally
    //   2307	2358	2201	finally
    //   2366	2376	2201	finally
    //   2384	2392	2201	finally
    //   2400	2405	2201	finally
    //   2413	2428	2201	finally
    //   2436	2441	2201	finally
    //   2449	2475	2201	finally
    //   2483	2491	2201	finally
    //   2536	2547	2201	finally
    //   2555	2560	2201	finally
    //   2568	2578	2201	finally
    //   2586	2592	2201	finally
    //   2600	2609	2201	finally
    //   2620	2631	2201	finally
    //   2639	2645	2201	finally
    //   2653	2689	2201	finally
    //   2697	2705	2201	finally
    //   2496	2501	2504	java/lang/Throwable
    //   2990	2995	2997	java/lang/Throwable
    //   2856	2879	3042	java/lang/Exception
    //   2886	2895	3042	java/lang/Exception
    //   2907	2916	3042	java/lang/Exception
    //   2921	2928	3042	java/lang/Exception
    //   2940	2952	3042	java/lang/Exception
    //   2952	2985	3042	java/lang/Exception
    //   3028	3039	3042	java/lang/Exception
    //   3168	3178	3042	java/lang/Exception
    //   3194	3395	3042	java/lang/Exception
    //   3395	3427	3042	java/lang/Exception
    //   3444	3451	3042	java/lang/Exception
    //   3468	3502	3042	java/lang/Exception
    //   3502	3536	3042	java/lang/Exception
    //   3536	3584	3042	java/lang/Exception
    //   3584	3606	3042	java/lang/Exception
    //   3606	3621	3042	java/lang/Exception
    //   3625	3672	3042	java/lang/Exception
    //   3672	3752	3042	java/lang/Exception
    //   3789	3817	3042	java/lang/Exception
    //   3139	3143	3145	java/lang/Throwable
    //   2856	2879	3181	finally
    //   2886	2895	3181	finally
    //   2907	2916	3181	finally
    //   2921	2928	3181	finally
    //   2940	2952	3181	finally
    //   2952	2985	3181	finally
    //   3028	3039	3181	finally
    //   3168	3178	3181	finally
    //   3194	3395	3181	finally
    //   3395	3427	3181	finally
    //   3444	3451	3181	finally
    //   3468	3502	3181	finally
    //   3502	3536	3181	finally
    //   3536	3584	3181	finally
    //   3584	3606	3181	finally
    //   3606	3621	3181	finally
    //   3625	3672	3181	finally
    //   3672	3752	3181	finally
    //   3789	3817	3181	finally
    //   3757	3762	3765	java/lang/Throwable
    //   2207	2212	3820	java/lang/Throwable
    //   3187	3192	3847	java/lang/Throwable
    //   2710	2822	3874	finally
    //   2822	2856	3874	finally
    //   3055	3066	3881	finally
    //   3066	3095	3881	finally
    //   3095	3135	3881	finally
    //   2710	2822	3892	java/lang/Exception
    //   2822	2856	3892	java/lang/Exception
  }
  
  private boolean a(com.tencent.msf.service.protocol.push.a.a parama)
  {
    if (this.b != null)
    {
      this.p.z = this.b.i;
      if ((this.b.i > 0L) && (this.b.i < 600L)) {
        this.m = ((int)this.b.i * 1000);
      }
    }
    int i1;
    for (;;)
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: Start connecting: " + this.n + ", port:" + this.o + ", strDomain:" + parama.c + ", mTestType:" + this.a);
        }
        i1 = j.a[this.a.ordinal()];
        switch (i1)
        {
        default: 
          return false;
        }
      }
      catch (Exception parama)
      {
        this.p.I.add(Long.valueOf(-1L));
        parama.printStackTrace();
        return false;
      }
      if (this.c != null)
      {
        this.p.z = this.c.i;
        if ((this.c.i > 0L) && (this.c.i < 600L))
        {
          this.m = ((int)this.c.i * 1000);
          continue;
          this.g = new DatagramSocket();
          this.g.setSoTimeout(this.m);
          this.p.I.add(Long.valueOf(-1L));
        }
      }
    }
    Object localObject2;
    Object localObject1;
    label1197:
    int i3;
    for (;;)
    {
      return true;
      try
      {
        parama = new InetSocketAddress(this.n, this.o);
        this.h = new Socket();
        this.h.setSoTimeout(this.m);
        this.h.setTcpNoDelay(true);
        this.h.setKeepAlive(true);
        this.t = System.currentTimeMillis();
        this.h.connect(parama, this.m);
        this.u = System.currentTimeMillis();
        this.z = (this.u - this.t);
        this.p.I.add(Long.valueOf(this.z));
        this.i = this.h.getOutputStream();
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: TCP end connect: " + this.n + ", port:" + this.o + ", readTimeout:" + this.m);
      }
      catch (Throwable parama)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: TCP end connect: " + this.n + ", port:" + this.o + ", mTestType:" + this.a + " failed", parama);
        }
        parama = this.p;
        parama.o += 1;
        this.p.I.add(Long.valueOf(-1L));
        return false;
      }
      for (;;)
      {
        try
        {
          localObject2 = this.n.getHostAddress();
          localObject1 = localObject2;
          if ((this.n instanceof Inet6Address)) {
            localObject1 = "[" + (String)localObject2 + "]";
          }
          if (this.b.y == 1)
          {
            localObject1 = "https://" + (String)localObject1 + ":" + this.o + "/" + this.b.q;
            if (QLog.isDevelopLevel()) {
              QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: connecting http url:" + (String)localObject1);
            }
            this.t = System.currentTimeMillis();
            this.j = new URL((String)localObject1);
            this.k = ((HttpURLConnection)this.j.openConnection());
            if (this.b.y == 1)
            {
              g();
              ((HttpsURLConnection)this.k).setHostnameVerifier(R);
            }
            this.k.setConnectTimeout(this.m);
            this.k.setDoInput(true);
            this.k.setUseCaches(false);
            this.k.setReadTimeout(this.m);
            this.k.setRequestProperty("Connection", "close");
            if (this.l != 0) {
              break label1197;
            }
            this.k.setDoOutput(true);
            this.k.setRequestMethod("POST");
            this.k.setRequestProperty("Content-Type", "application/octet-stream");
            this.k.setRequestProperty("Host", parama.c);
            if ((this.b.s == null) || (this.b.s.size() <= 0)) {
              break;
            }
            parama = this.b.s.iterator();
            if (!parama.hasNext()) {
              break;
            }
            localObject1 = (e)parama.next();
            if (localObject1 == null) {
              continue;
            }
            this.k.setRequestProperty(((e)localObject1).a, ((e)localObject1).b);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MSF.C.QualityTestManager", 4, "reqHead.strKey:" + ((e)localObject1).a + ",reqHead.strValue:" + ((e)localObject1).b);
            continue;
          }
          localObject1 = "http://" + (String)localObject1 + ":" + this.o + "/" + this.b.q;
        }
        catch (Throwable parama)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: connecting " + this.n + " port:" + this.o + " mTestType:" + this.a + " failed", parama);
          }
          parama = this.p;
          parama.o += 1;
          this.p.I.add(Long.valueOf(-1L));
          return false;
        }
        continue;
        if (this.l == 1)
        {
          this.k.setInstanceFollowRedirects(false);
          this.k.setRequestMethod("GET");
        }
      }
      this.k.connect();
      l1 = System.currentTimeMillis();
      this.u = l1;
      this.v = l1;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: end connect: mRequestMethod:" + this.l + ", readTimeout:" + this.m);
      }
      parama = "";
      localObject1 = parama;
      if (this.l == 1)
      {
        i2 = this.k.getResponseCode();
        if ((this.b.r & 0x4) == 4) {
          break label1831;
        }
        i1 = 1;
        break label1794;
        i3 += 1;
        if (i3 <= 10) {
          break;
        }
        QLog.d("MSF.C.QualityTestManager", 4, "Redirect too much!");
        localObject1 = parama;
      }
      label1363:
      this.z = (this.u - this.t);
      this.p.I.add(Long.valueOf(this.z));
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool)
      {
        try
        {
          parama = ((String)localObject1).substring(((String)localObject1).indexOf("://") + 3);
          parama = InetAddress.getByName(parama.substring(0, parama.indexOf("/")));
          this.p.L = parama.getHostAddress();
        }
        catch (Exception parama) {}
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "DNSParse for lastUrl error!", parama);
        }
      }
    }
    parama = this.k.getHeaderField("Location");
    this.k.disconnect();
    this.j = new URL(parama);
    this.k = ((HttpURLConnection)this.j.openConnection());
    this.k.setConnectTimeout(this.m);
    this.k.setDoInput(true);
    this.k.setUseCaches(false);
    this.k.setInstanceFollowRedirects(false);
    this.k.setReadTimeout(this.m);
    this.k.setRequestProperty("Connection", "close");
    this.k.setRequestMethod("GET");
    if ((this.b.s != null) && (this.b.s.size() > 0))
    {
      localObject1 = this.b.s.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (e)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          this.k.setRequestProperty(((e)localObject2).a, ((e)localObject2).b);
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "reqHead.strKey:" + ((e)localObject2).a + ",reqHead.strValue:" + ((e)localObject2).b);
          }
        }
      }
    }
    this.k.connect();
    long l1 = System.currentTimeMillis();
    this.u = l1;
    this.v = l1;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.QualityTestManager", 4, "Redirect responseCode:" + i2 + ",lastRedirectUrl:" + parama);
    }
    int i2 = this.k.getResponseCode();
    for (;;)
    {
      label1794:
      i3 = 0;
      localObject1 = parama;
      if (i1 == 0) {
        break label1363;
      }
      if ((i2 == 301) || (i2 == 302)) {
        break;
      }
      localObject1 = parama;
      if (i2 != 307) {
        break label1363;
      }
      break;
      label1831:
      i1 = 0;
    }
  }
  
  private boolean a(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        switch (j.a[this.a.ordinal()])
        {
        case 1: 
          DatagramPacket localDatagramPacket = new DatagramPacket(paramArrayOfByte, paramArrayOfByte.length, this.n, this.o);
          try
          {
            this.v = System.currentTimeMillis();
            this.g.send(localDatagramPacket);
            this.w = System.currentTimeMillis();
            this.A += this.w - this.v;
            this.B += paramArrayOfByte.length;
            this.T += paramArrayOfByte.length;
            QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send udp packet length:" + localDatagramPacket.getLength() + " sendEndTime:" + this.w + " sendTime:" + this.v);
            paramArrayOfByte = this.p;
            paramArrayOfByte.l += 1;
            return true;
          }
          catch (Exception paramArrayOfByte)
          {
            a(g.d.a.d);
            QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send udp packet error:", paramArrayOfByte);
            return false;
          }
        case 2: 
          try
          {
            this.v = System.currentTimeMillis();
            m.g.add(this.i.toString());
            this.i.write(paramArrayOfByte);
            this.i.flush();
            m.g.remove(this.i.toString());
            this.B += paramArrayOfByte.length;
            this.T += paramArrayOfByte.length;
            paramArrayOfByte = this.p;
            paramArrayOfByte.l += 1;
          }
          catch (Exception paramArrayOfByte)
          {
            if (this.i != null) {
              m.g.remove(this.i.toString());
            }
            a(g.d.a.d);
            QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send tcp error:", paramArrayOfByte);
            return false;
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        return false;
      }
      try
      {
        this.i = this.k.getOutputStream();
        m.g.add(this.i.toString());
        this.i.write(paramArrayOfByte);
        this.i.flush();
        m.g.remove(this.i.toString());
        this.B += paramArrayOfByte.length;
        this.T += paramArrayOfByte.length;
        paramArrayOfByte = this.p;
        paramArrayOfByte.l += 1;
      }
      catch (Exception paramArrayOfByte)
      {
        if (this.i != null) {
          m.g.remove(this.i.toString());
        }
        a(g.d.a.d);
        QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send http error:", paramArrayOfByte);
        return false;
      }
    }
    return false;
  }
  
  private byte[] a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (this.b != null)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(paramInt);
      byte[] arrayOfByte = new byte[paramInt];
      if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0)) {
        localByteBuffer.put(paramArrayOfByte1);
      }
      paramInt = 0;
      while (paramInt < this.b.f)
      {
        localByteBuffer.put(this.b.e);
        paramInt += 1;
      }
      if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0)) {
        localByteBuffer.put(paramArrayOfByte2);
      }
      localByteBuffer.flip();
      localByteBuffer.get(arrayOfByte);
      paramInt = arrayOfByte.length;
      if (this.a != g.a.c) {
        if ((this.b.o == 0) || (1 == this.b.o))
        {
          int i1 = com.tencent.mobileqq.msf.core.c.a(arrayOfByte, 0);
          if (i1 != paramInt)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("MSF.C.QualityTestManager", 4, "testdata length error stop dataTotalLen:" + i1 + " receBodySize:" + paramInt);
            }
            b(g.d.a.f, true);
            m.a();
            return null;
          }
        }
        else
        {
          if (2 != this.b.o) {
            break label233;
          }
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.QualityTestManager", 2, "qualityTestMsg.cTestType=2, Should*NOT* check head len");
          }
        }
      }
      return arrayOfByte;
      label233:
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.QualityTestManager", 2, "qualityTestMsg.cTestType" + this.b.o + "NotSupport, giveup speed_test");
      }
      return null;
    }
    if (this.c != null) {}
    return null;
  }
  
  private String b(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      Matcher localMatcher = Pattern.compile("(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})").matcher(paramString);
      if (localMatcher.find()) {
        return localMatcher.group();
      }
      paramString = Pattern.compile("([a-f0-9]{1,4}(:[a-f0-9]{1,4}){7}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){0,7}::[a-f0-9]{0,4}(:[a-f0-9]{1,4}){0,7})").matcher(paramString);
      if (paramString.find()) {
        return paramString.group();
      }
    }
    return null;
  }
  
  private void b(g.d.a parama, boolean paramBoolean)
  {
    a(parama, paramBoolean);
    if (paramBoolean) {
      parama = new ArrayList();
    }
    try
    {
      parama.add(this.S.getBytes("utf-8"));
      localHashMap = new HashMap();
      localHashMap.put("QualTest", parama);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      try
      {
        HashMap localHashMap;
        m.a(this.V, this.b, this.c, this.U, this.T);
        m.d.configManager.a(localHashMap, "");
        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient finish, succ: " + this.S);
        return;
        localUnsupportedEncodingException = localUnsupportedEncodingException;
        localUnsupportedEncodingException.printStackTrace();
      }
      catch (Exception parama)
      {
        for (;;)
        {
          parama.printStackTrace();
        }
      }
    }
  }
  
  private void b(com.tencent.msf.service.protocol.push.a.a parama)
  {
    long l1 = parama.a;
    int i1 = parama.b;
    try
    {
      this.n = com.tencent.qphone.base.util.g.a(parama);
      this.o = com.tencent.qphone.base.util.g.a(i1);
      this.p.e = this.n;
      this.p.f = this.o;
      this.p.C = parama.c;
      parama = parama.c;
      if ((parama == null) || (parama.length() <= 0) || (2 != this.b.o)) {
        break label329;
      }
    }
    catch (UnknownHostException localUnknownHostException)
    {
      try
      {
        l1 = SystemClock.elapsedRealtime();
        this.r = System.currentTimeMillis();
        parama = InetAddress.getAllByName(parama);
        this.p.D = (SystemClock.elapsedRealtime() - l1);
        this.s = System.currentTimeMillis();
        if ((parama == null) || (parama.length <= 0)) {
          break label320;
        }
        this.p.E = 0;
        if ((this.b.r & 0x1) == 1) {}
        for (this.n = parama[0];; this.n = parama[new java.util.Random().nextInt(parama.length)])
        {
          this.p.e = this.n;
          StringBuilder localStringBuilder = new StringBuilder();
          i1 = 0;
          while (i1 < parama.length)
          {
            localStringBuilder.append(parama[i1].getHostAddress()).append("|").append(parama[i1].getHostName()).append("**");
            i1 += 1;
          }
          localUnknownHostException = localUnknownHostException;
          localUnknownHostException.printStackTrace();
          break;
        }
        while (!QLog.isDevelopLevel()) {}
      }
      catch (UnknownHostException parama)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "dns parse error! ", parama);
        }
        this.p.E = 1;
        return;
      }
    }
    QLog.d("MSF.C.QualityTestManager", 4, "dns addrs " + localUnknownHostException.toString());
    return;
    label320:
    this.p.E = 1;
    return;
    label329:
    this.p.E = 0;
  }
  
  private boolean b(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (new String(paramArrayOfByte).endsWith("\r\n\r\n"));
  }
  
  /* Error */
  public static String d()
  {
    // Byte code:
    //   0: new 972	java/io/BufferedReader
    //   3: dup
    //   4: new 974	java/io/FileReader
    //   7: dup
    //   8: ldc_w 976
    //   11: invokespecial 977	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   14: sipush 8192
    //   17: invokespecial 980	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   20: astore_1
    //   21: aload_1
    //   22: astore_0
    //   23: aload_1
    //   24: invokevirtual 983	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: ldc_w 985
    //   30: ldc 120
    //   32: invokevirtual 989	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   35: ldc_w 659
    //   38: invokevirtual 993	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   41: astore_2
    //   42: aload_1
    //   43: astore_0
    //   44: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   47: ifeq +33 -> 80
    //   50: aload_1
    //   51: astore_0
    //   52: ldc 240
    //   54: iconst_4
    //   55: new 242	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   62: ldc_w 995
    //   65: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_2
    //   69: iconst_1
    //   70: aaload
    //   71: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_1
    //   81: invokevirtual 996	java/io/BufferedReader:close	()V
    //   84: aload_2
    //   85: iconst_1
    //   86: aaload
    //   87: areturn
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: astore_0
    //   93: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   96: ifeq +14 -> 110
    //   99: aload_1
    //   100: astore_0
    //   101: ldc 240
    //   103: iconst_4
    //   104: ldc_w 998
    //   107: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_1
    //   111: astore_0
    //   112: aload_2
    //   113: invokevirtual 493	java/lang/Exception:printStackTrace	()V
    //   116: aload_1
    //   117: invokevirtual 996	java/io/BufferedReader:close	()V
    //   120: ldc_w 1000
    //   123: areturn
    //   124: astore_0
    //   125: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   128: ifeq +12 -> 140
    //   131: ldc 240
    //   133: iconst_4
    //   134: ldc_w 1002
    //   137: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload_0
    //   141: invokevirtual 493	java/lang/Exception:printStackTrace	()V
    //   144: ldc_w 1000
    //   147: areturn
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 996	java/io/BufferedReader:close	()V
    //   155: aload_1
    //   156: athrow
    //   157: astore_0
    //   158: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   161: ifeq +12 -> 173
    //   164: ldc 240
    //   166: iconst_4
    //   167: ldc_w 1002
    //   170: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload_0
    //   174: invokevirtual 493	java/lang/Exception:printStackTrace	()V
    //   177: goto -22 -> 155
    //   180: astore_0
    //   181: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   184: ifeq +12 -> 196
    //   187: ldc 240
    //   189: iconst_4
    //   190: ldc_w 1002
    //   193: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_0
    //   197: invokevirtual 493	java/lang/Exception:printStackTrace	()V
    //   200: goto -116 -> 84
    //   203: astore_1
    //   204: goto -53 -> 151
    //   207: astore_2
    //   208: goto -117 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	90	0	localBufferedReader1	java.io.BufferedReader
    //   124	17	0	localException1	Exception
    //   150	2	0	localObject1	Object
    //   157	17	0	localException2	Exception
    //   180	17	0	localException3	Exception
    //   20	97	1	localBufferedReader2	java.io.BufferedReader
    //   148	8	1	localObject2	Object
    //   203	1	1	localObject3	Object
    //   41	44	2	arrayOfString	String[]
    //   88	25	2	localException4	Exception
    //   207	1	2	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   0	21	88	java/lang/Exception
    //   116	120	124	java/lang/Exception
    //   0	21	148	finally
    //   151	155	157	java/lang/Exception
    //   80	84	180	java/lang/Exception
    //   23	42	203	finally
    //   44	50	203	finally
    //   52	80	203	finally
    //   93	99	203	finally
    //   101	110	203	finally
    //   112	116	203	finally
    //   23	42	207	java/lang/Exception
    //   44	50	207	java/lang/Exception
    //   52	80	207	java/lang/Exception
  }
  
  /* Error */
  public static String e()
  {
    // Byte code:
    //   0: new 972	java/io/BufferedReader
    //   3: dup
    //   4: new 974	java/io/FileReader
    //   7: dup
    //   8: ldc_w 1004
    //   11: invokespecial 977	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   14: sipush 8192
    //   17: invokespecial 980	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   20: astore_3
    //   21: aload_3
    //   22: astore_1
    //   23: aload_3
    //   24: invokevirtual 983	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: ldc_w 1006
    //   30: invokevirtual 993	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   33: astore 4
    //   35: iconst_2
    //   36: istore_0
    //   37: ldc 120
    //   39: astore_2
    //   40: aload_3
    //   41: astore_1
    //   42: iload_0
    //   43: aload 4
    //   45: arraylength
    //   46: if_icmpge +89 -> 135
    //   49: aload_3
    //   50: astore_1
    //   51: new 242	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   58: aload_2
    //   59: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 4
    //   64: iload_0
    //   65: aaload
    //   66: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc_w 1008
    //   72: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_2
    //   79: iload_0
    //   80: iconst_1
    //   81: iadd
    //   82: istore_0
    //   83: goto -43 -> 40
    //   86: astore 4
    //   88: aconst_null
    //   89: astore_2
    //   90: aload_2
    //   91: astore_1
    //   92: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   95: ifeq +14 -> 109
    //   98: aload_2
    //   99: astore_1
    //   100: ldc 240
    //   102: iconst_4
    //   103: ldc_w 1010
    //   106: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_2
    //   110: astore_1
    //   111: aload 4
    //   113: invokevirtual 493	java/lang/Exception:printStackTrace	()V
    //   116: ldc_w 1012
    //   119: astore_1
    //   120: aload_2
    //   121: invokevirtual 996	java/io/BufferedReader:close	()V
    //   124: aload_1
    //   125: areturn
    //   126: astore_2
    //   127: aconst_null
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 996	java/io/BufferedReader:close	()V
    //   133: aload_2
    //   134: athrow
    //   135: aload_3
    //   136: invokevirtual 996	java/io/BufferedReader:close	()V
    //   139: aload_2
    //   140: astore_1
    //   141: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   144: ifeq -20 -> 124
    //   147: ldc 240
    //   149: iconst_4
    //   150: new 242	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 1014
    //   160: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_2
    //   164: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload_2
    //   174: areturn
    //   175: astore_1
    //   176: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   179: ifeq +12 -> 191
    //   182: ldc 240
    //   184: iconst_4
    //   185: ldc_w 1002
    //   188: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload_1
    //   192: invokevirtual 493	java/lang/Exception:printStackTrace	()V
    //   195: goto -62 -> 133
    //   198: astore_1
    //   199: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   202: ifeq +12 -> 214
    //   205: ldc 240
    //   207: iconst_4
    //   208: ldc_w 1002
    //   211: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload_1
    //   215: invokevirtual 493	java/lang/Exception:printStackTrace	()V
    //   218: ldc_w 1012
    //   221: areturn
    //   222: astore_1
    //   223: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   226: ifeq +12 -> 238
    //   229: ldc 240
    //   231: iconst_4
    //   232: ldc_w 1002
    //   235: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload_1
    //   239: invokevirtual 493	java/lang/Exception:printStackTrace	()V
    //   242: goto -103 -> 139
    //   245: astore_2
    //   246: goto -117 -> 129
    //   249: astore 4
    //   251: aload_3
    //   252: astore_2
    //   253: goto -163 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	47	0	i1	int
    //   22	119	1	localObject1	Object
    //   175	17	1	localException1	Exception
    //   198	17	1	localException2	Exception
    //   222	17	1	localException3	Exception
    //   39	82	2	str1	String
    //   126	48	2	str2	String
    //   245	1	2	localObject2	Object
    //   252	1	2	localBufferedReader1	java.io.BufferedReader
    //   20	232	3	localBufferedReader2	java.io.BufferedReader
    //   33	30	4	arrayOfString	String[]
    //   86	26	4	localException4	Exception
    //   249	1	4	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   0	21	86	java/lang/Exception
    //   0	21	126	finally
    //   129	133	175	java/lang/Exception
    //   120	124	198	java/lang/Exception
    //   135	139	222	java/lang/Exception
    //   23	35	245	finally
    //   42	49	245	finally
    //   51	79	245	finally
    //   92	98	245	finally
    //   100	109	245	finally
    //   111	116	245	finally
    //   23	35	249	java/lang/Exception
    //   42	49	249	java/lang/Exception
    //   51	79	249	java/lang/Exception
  }
  
  /* Error */
  public static ArrayList f()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_0
    //   2: aconst_null
    //   3: astore_1
    //   4: getstatic 1032	android/os/Build$VERSION:SDK_INT	I
    //   7: bipush 21
    //   9: if_icmplt +158 -> 167
    //   12: invokestatic 1038	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   15: ldc_w 1040
    //   18: invokevirtual 1044	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   21: checkcast 1046	android/net/ConnectivityManager
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 1050	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 1055	android/net/NetworkInfo:getType	()I
    //   34: pop
    //   35: aload_2
    //   36: invokevirtual 1055	android/net/NetworkInfo:getType	()I
    //   39: ifne +67 -> 106
    //   42: ldc_w 1046
    //   45: ldc_w 1057
    //   48: iconst_1
    //   49: anewarray 1059	java/lang/Class
    //   52: dup
    //   53: iconst_0
    //   54: getstatic 1063	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   57: aastore
    //   58: invokevirtual 1067	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   61: astore_2
    //   62: aload_2
    //   63: aload_1
    //   64: iconst_1
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: iload_0
    //   71: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokevirtual 1073	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   78: astore_1
    //   79: aload_1
    //   80: invokevirtual 1077	java/lang/Object:getClass	()Ljava/lang/Class;
    //   83: ldc_w 1079
    //   86: invokevirtual 1083	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   89: astore_2
    //   90: aload_2
    //   91: iconst_1
    //   92: invokevirtual 1088	java/lang/reflect/Field:setAccessible	(Z)V
    //   95: aload_2
    //   96: aload_1
    //   97: invokevirtual 1089	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 333	java/util/ArrayList
    //   103: astore_1
    //   104: aload_1
    //   105: areturn
    //   106: aload_2
    //   107: invokevirtual 1055	android/net/NetworkInfo:getType	()I
    //   110: iconst_1
    //   111: if_icmpne -69 -> 42
    //   114: iconst_1
    //   115: istore_0
    //   116: goto -74 -> 42
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 1090	java/lang/SecurityException:printStackTrace	()V
    //   124: aconst_null
    //   125: astore_1
    //   126: goto -22 -> 104
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 1091	java/lang/NoSuchFieldException:printStackTrace	()V
    //   134: aconst_null
    //   135: astore_1
    //   136: goto -32 -> 104
    //   139: astore_1
    //   140: aload_1
    //   141: invokevirtual 1092	java/lang/IllegalArgumentException:printStackTrace	()V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 1093	java/lang/NoSuchMethodException:printStackTrace	()V
    //   151: aconst_null
    //   152: areturn
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 1094	java/lang/IllegalAccessException:printStackTrace	()V
    //   158: aconst_null
    //   159: areturn
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 1095	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   165: aconst_null
    //   166: areturn
    //   167: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq -66 -> 104
    //   173: ldc 240
    //   175: iconst_4
    //   176: new 242	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 1097
    //   186: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: getstatic 1032	android/os/Build$VERSION:SDK_INT	I
    //   192: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: ldc_w 1099
    //   198: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aconst_null
    //   208: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	115	0	i1	int
    //   3	102	1	localObject1	Object
    //   119	2	1	localSecurityException	java.lang.SecurityException
    //   125	1	1	localObject2	Object
    //   129	2	1	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   135	1	1	localObject3	Object
    //   139	2	1	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   146	2	1	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   153	2	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   160	2	1	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   29	78	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   79	104	119	java/lang/SecurityException
    //   79	104	129	java/lang/NoSuchFieldException
    //   62	79	139	java/lang/IllegalArgumentException
    //   79	104	139	java/lang/IllegalArgumentException
    //   120	124	139	java/lang/IllegalArgumentException
    //   130	134	139	java/lang/IllegalArgumentException
    //   42	62	146	java/lang/NoSuchMethodException
    //   62	79	146	java/lang/NoSuchMethodException
    //   79	104	146	java/lang/NoSuchMethodException
    //   120	124	146	java/lang/NoSuchMethodException
    //   130	134	146	java/lang/NoSuchMethodException
    //   140	144	146	java/lang/NoSuchMethodException
    //   154	158	146	java/lang/NoSuchMethodException
    //   161	165	146	java/lang/NoSuchMethodException
    //   62	79	153	java/lang/IllegalAccessException
    //   79	104	153	java/lang/IllegalAccessException
    //   120	124	153	java/lang/IllegalAccessException
    //   130	134	153	java/lang/IllegalAccessException
    //   62	79	160	java/lang/reflect/InvocationTargetException
    //   79	104	160	java/lang/reflect/InvocationTargetException
    //   120	124	160	java/lang/reflect/InvocationTargetException
    //   130	134	160	java/lang/reflect/InvocationTargetException
  }
  
  private static void g()
  {
    i locali = new i();
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      SecureRandom localSecureRandom = new SecureRandom();
      localSSLContext.init(null, new TrustManager[] { locali }, localSecureRandom);
      HttpsURLConnection.setDefaultSSLSocketFactory(localSSLContext.getSocketFactory());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MSF.C.QualityTestManager", 1, "trustallhost error! ", localException);
    }
  }
  
  private void h()
  {
    try
    {
      switch (j.a[this.a.ordinal()])
      {
      case 1: 
        if (this.g != null)
        {
          this.g.close();
          this.g = null;
        }
        if (QLog.isDevelopLevel())
        {
          QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close Udp socket");
          return;
        }
        break;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close socket excep!");
        return;
        if (this.i != null)
        {
          this.i.close();
          this.i = null;
        }
        if (this.h != null)
        {
          this.h.close();
          this.h = null;
        }
        if (QLog.isDevelopLevel())
        {
          QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close Tcp socket");
          return;
          if (this.i != null)
          {
            this.i.close();
            this.i = null;
          }
          if (this.k != null)
          {
            this.k.disconnect();
            this.k = null;
          }
          if (QLog.isDevelopLevel())
          {
            QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close Http socket");
            return;
          }
        }
      }
    }
  }
  
  private void i()
  {
    if (this.b == null)
    {
      b(g.d.a.k, true);
      m.a();
      return;
    }
    k();
    this.p.r = this.b.a;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.QualityTestManager", 2, "cProtoType:" + this.b.a + " IpPort.size():" + this.b.b.size() + " cDomainToIpMode:" + this.b.r + " strRspMatchPattern" + this.b.t + " strUserInfo:" + this.b.u + " dwRecvCopyStart" + this.b.w + " dwRecvCopyLen" + this.b.x + " strDnsSrvInfo:" + this.q.j + " dwLocationTime:" + this.q.l + " strAxis:" + this.q.m);
    }
    if (this.b.b.size() > 10)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
      }
      this.V = false;
      b(g.d.a.m, true);
      m.a();
      return;
    }
    if (this.b.b.size() <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too small, return ");
      }
      this.V = false;
      b(g.d.a.n, true);
      m.a();
      return;
    }
    if (this.b.h * 1000L < System.currentTimeMillis())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg expired, stop test qualityTestMsg.dwExpirTime:" + this.b.h + "System.currentTimeMillis():" + System.currentTimeMillis());
      }
      b(g.d.a.j, true);
      m.a();
      return;
    }
    int i1;
    int i2;
    if ((this.b.i > 0L) && (this.b.i < 1800L))
    {
      i1 = (int)this.b.i * 1000;
      i2 = 0;
    }
    for (;;)
    {
      try
      {
        int i3 = this.b.b.size();
        if (i2 >= i3) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        String str1;
        QLog.d("MSF.C.QualityTestManager", 1, "networkDetectRun: error ", localException2);
        return;
        if ((this.b.v == null) || (this.b.v.size() <= 0)) {
          continue;
        }
        str3 = "";
        Iterator localIterator = this.b.v.iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        com.tencent.msf.service.protocol.push.a.c localc = (com.tencent.msf.service.protocol.push.a.c)localIterator.next();
        Object localObject1 = str3;
        if (localc == null) {
          break label1216;
        }
        str3 = str3 + localc.a + " " + localc.b + " ";
        localObject1 = str3;
        if (!QLog.isColorLevel()) {
          break label1216;
        }
        QLog.d("MSF.C.QualityTestManager", 4, "pingOptions.strKey:" + localc.a + ",pingOptions.strValue:" + localc.b);
        localObject1 = str3;
        break label1216;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MSF.C.QualityTestManager", 2, "pingParamStr : " + str3);
        ((k)localObject3).a(str3);
        Object localObject3 = ((k)localObject3).b();
        if ((localObject3 == null) || (!((k.a)localObject3).b)) {
          break label1223;
        }
        str3 = ((k.a)localObject3).d;
        localObject1 = str3;
        if (TextUtils.isEmpty(((k.a)localObject3).c)) {
          break label1186;
        }
        this.p.K = ((k.a)localObject3).c;
        bool1 = true;
        localObject1 = str3;
        continue;
        localObject3 = ((k)localObject3).a();
        if ((localObject3 == null) || (!((k.a)localObject3).b)) {
          break label1233;
        }
        str3 = ((k.a)localObject3).d;
        localObject1 = str3;
        if (TextUtils.isEmpty(((k.a)localObject3).c)) {
          break label1186;
        }
        this.p.K = ((k.a)localObject3).c;
        bool1 = true;
        localObject1 = str3;
        continue;
        b(g.d.a.b, bool2);
      }
      finally
      {
        m.a();
      }
      try
      {
        this.p.g = NetConnInfoCenter.getSystemNetworkType();
        this.p.h = NetConnInfoCenter.getWifiStrength();
        this.p.j = NetConnInfoCenter.getCdmaStrength();
        this.p.i = NetConnInfoCenter.getGsmStrength();
        this.n = com.tencent.qphone.base.util.g.a((com.tencent.msf.service.protocol.push.a.a)this.b.b.get(i2));
        this.p.K = this.n.getHostAddress();
        this.p.C = ((com.tencent.msf.service.protocol.push.a.a)this.b.b.get(i2)).c;
        if ((this.p.C == null) || (this.p.C.isEmpty())) {
          this.p.C = this.p.K;
        }
        this.p.c.clear();
        str1 = this.p.C;
        this.p.M = System.currentTimeMillis();
        localObject3 = new k(str1, true, i1);
        switch (j.a[this.a.ordinal()])
        {
        case 4: 
          this.p.R = com.tencent.qphone.base.util.g.a(str1);
          this.p.Q = this.p.R.length();
          this.p.N = System.currentTimeMillis();
          if (i2 != this.b.b.size() - 1) {
            break label1243;
          }
          bool2 = true;
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.QualityTestManager", 2, "testsuccess: " + bool1 + ",isUpload:" + bool2);
          }
          if (bool1) {
            b(g.d.a.a, bool2);
          }
          break;
        }
      }
      catch (Exception localException1)
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.d("MSF.C.QualityTestManager", 4, "failed to get network info", localException1);
        continue;
      }
      label1186:
      boolean bool1 = true;
      continue;
      i1 = 1200000;
      break;
      String str2 = "";
      bool1 = true;
      continue;
      i2 += 1;
      continue;
      label1216:
      String str3 = str2;
      continue;
      label1223:
      str2 = "";
      bool1 = false;
      continue;
      label1233:
      str2 = "";
      bool1 = false;
      continue;
      label1243:
      boolean bool2 = false;
    }
  }
  
  private String j()
  {
    StringBuilder localStringBuilder = new StringBuilder("").append(NetConnInfoCenter.getActiveNetIpFamily(false)).append("_");
    if (NetConnInfoCenter.isWifiConn()) {
      localStringBuilder.append("wifi").append("_");
    }
    for (;;)
    {
      localStringBuilder.append(Build.VERSION.SDK_INT).append("_").append(Build.BRAND);
      return localStringBuilder.substring(0, Math.min(32, localStringBuilder.length()));
      if (NetConnInfoCenter.isMobileConn()) {
        localStringBuilder.append(NetConnInfoCenter.getCurrentAPN()).append("_");
      } else {
        localStringBuilder.append("other").append("_");
      }
    }
  }
  
  private void k()
  {
    this.q.d = this.b.j;
    this.q.e = this.b.o;
    this.q.f = this.b.k;
    this.q.g = this.b.l;
    this.q.h = this.b.m;
    this.q.a = g.c.a.a;
    this.q.i = this.b.u;
    this.q.n = j();
    ArrayList localArrayList = f();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      int i2 = Math.min(localArrayList.size(), 3);
      StringBuilder localStringBuilder = new StringBuilder("");
      int i1 = 0;
      while (i1 < i2)
      {
        localStringBuilder.append(((InetAddress)localArrayList.get(i1)).getHostAddress());
        if ((i2 > 1) && (i1 < i2 - 1)) {
          localStringBuilder.append(",");
        }
        i1 += 1;
      }
      this.q.j = localStringBuilder.toString();
    }
    for (;;)
    {
      if (0L != t.h)
      {
        this.q.l = t.h;
        this.q.m = (t.i + "," + t.j);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.QualityTestManager", 2, "mDnses is null");
      }
    }
  }
  
  private boolean l()
  {
    if ((this.b.g == null) && (this.b.g.length <= 0)) {
      return false;
    }
    String[] arrayOfString = new String(this.b.g).split("\r\n");
    Object localObject1 = "";
    Object localObject2 = "";
    int i2 = arrayOfString.length;
    int i1 = 0;
    if (i1 < i2)
    {
      String str = arrayOfString[i1];
      Object localObject4;
      Object localObject3;
      if (((!str.startsWith("Cookie:")) || (!str.contains("md5="))) && ((!str.startsWith("Set-Cookie:")) || (!str.contains("md5="))))
      {
        localObject4 = (String)localObject1 + str + "\r\n";
        localObject3 = localObject2;
      }
      for (;;)
      {
        i1 += 1;
        localObject2 = localObject3;
        localObject1 = localObject4;
        break;
        int i3 = str.indexOf("md5=");
        int i4 = str.indexOf(";", i3);
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (i3 != -1)
        {
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (i4 > "md5=".length() + i3)
          {
            localObject3 = str.substring("md5=".length() + i3, i4);
            localObject4 = localObject1;
          }
        }
      }
    }
    return ((String)localObject2).equals(MD5.toMD5((String)localObject1 + "\r\n"));
  }
  
  private void m()
  {
    if (this.c == null)
    {
      b(g.d.a.o, true);
      m.a();
      return;
    }
    this.p.a = g.d.b.b;
    this.p.g = NetConnInfoCenter.getSystemNetworkType();
    this.p.r = this.c.a;
    this.p.s = this.c.g;
    this.p.t = this.c.f;
    this.p.u = new ArrayList();
    int i1 = 0;
    while (i1 < this.c.d.size())
    {
      this.p.u.add(this.c.d.get(i1));
      i1 += 1;
    }
    this.p.w = this.c.h;
    this.p.v = new ArrayList();
    QLog.d("MSF.C.QualityTestManager", 1, "PkgInterval :" + this.c.f + " IpPort.size():" + this.c.b.size() + " PkgData.length " + this.c.c.size() + " PkgNum:" + this.c.g);
    if (this.c.b.size() > 75)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
      }
      this.V = false;
      b(g.d.a.m, true);
      m.a();
      return;
    }
    if (this.c.b.size() <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too small, return ");
      }
      b(g.d.a.n, true);
      m.a();
      return;
    }
    if (this.c.g > 20L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much, return ");
      }
      this.V = false;
      b(g.d.a.l, true);
      m.a();
      return;
    }
    if (this.c.h * 1000L < System.currentTimeMillis())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "mtuTest expired, stop test mtuTest.dwExpirTime:" + this.c.h + "System.currentTimeMillis():" + System.currentTimeMillis());
      }
      b(g.d.a.j, true);
      m.a();
      return;
    }
    if ((this.c.e.size() != this.c.d.size()) || (this.c.c.size() != this.c.d.size()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData size error, stop test");
      }
      b(g.d.a.i, true);
      m.a();
      return;
    }
    if (this.c.g <= 0L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "mtuTest dwPkgNum too short, stop test mtuTest.dwPkgNum:" + this.c.g);
      }
      b(g.d.a.i, true);
      m.a();
      return;
    }
    if (this.c.g * this.c.c.size() > 20L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much, return ");
      }
      this.V = false;
      b(g.d.a.l, true);
      m.a();
      return;
    }
    int i3 = 0;
    for (;;)
    {
      int i4;
      int i5;
      try
      {
        if (i3 < this.c.b.size())
        {
          i1 = 0;
          this.p.y = new ArrayList();
          this.p.k = 0;
          this.p.n = 0;
          this.p.l = 0;
          this.p.m = 0;
          this.p.o = 0;
          this.p.c.clear();
          this.p.v.clear();
          try
          {
            this.p.h = NetConnInfoCenter.getWifiStrength();
            this.p.j = NetConnInfoCenter.getCdmaStrength();
            this.p.i = NetConnInfoCenter.getGsmStrength();
            i4 = 0;
            if (i4 >= this.c.c.size()) {
              break label1638;
            }
            if (((byte[])this.c.c.get(i4)).length < 8)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, stop test qualityTestMsg.sPkgData.length");
              }
              a(g.d.a.i);
            }
          }
          catch (Exception localException1)
          {
            if (!QLog.isDevelopLevel()) {
              continue;
            }
            QLog.d("MSF.C.QualityTestManager", 4, "failed to get network strength");
            continue;
          }
        }
        int i6;
        ByteBuffer localByteBuffer;
        int i7;
        if (arrayOfByte == null) {
          break label1593;
        }
      }
      catch (Exception localException2)
      {
        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient  error ", localException2);
        return;
        if ((this.c.e.get(i4) == null) || (((byte[])this.c.e.get(i4)).length <= 0)) {
          break label1688;
        }
        i2 = ((byte[])this.c.e.get(i4)).length;
        i6 = (int)(i2 + ((byte[])this.c.c.get(i4)).length * ((Long)this.c.d.get(i4)).longValue());
        QLog.d("MSF.C.QualityTestManager", 1, "mtu allbodylength " + i6);
        if ((i6 > 262144) && (this.a == g.a.a))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i6 + " return ");
          }
          a(g.d.a.h);
        }
        else if (i6 > 262144)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i6 + " return ");
          }
          this.V = false;
          a(g.d.a.h);
        }
        else
        {
          if (this.c.f >= 10L) {
            break label1702;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "dwPkgInterval too small " + this.c.f + " return ");
          }
          a(g.d.a.g);
          break label1693;
          if (i5 < this.c.g)
          {
            i1 = i2;
            if (i2 == 0)
            {
              if (!a((com.tencent.msf.service.protocol.push.a.a)this.c.b.get(i3)))
              {
                if (QLog.isDevelopLevel()) {
                  QLog.d("MSF.C.QualityTestManager", 4, "connectToServer error, return ");
                }
                a(g.d.a.c);
                i1 = i2;
                break label1710;
              }
              this.A = 0L;
              this.C = 0L;
              this.B = 0L;
              this.D = 0L;
              i1 = 1;
            }
            try
            {
              localByteBuffer = ByteBuffer.allocate(i6);
              arrayOfByte = new byte[i6];
              if ((this.c.e.get(i4) == null) || (((byte[])this.c.e.get(i4)).length <= 0)) {
                break label1721;
              }
              localByteBuffer.put((byte[])this.c.e.get(i4));
            }
            catch (Exception localException3)
            {
              byte[] arrayOfByte;
              QLog.d("MSF.C.QualityTestManager", 1, "QualityClient:  error:", localException3);
              localException3.printStackTrace();
              try
              {
                Thread.sleep(this.c.f);
              }
              catch (Exception localException4)
              {
                QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: Thread sleep error " + localException4);
              }
            }
            if (i2 < ((Long)this.c.d.get(i4)).longValue())
            {
              localByteBuffer.put((byte[])this.c.c.get(i4));
              i2 += 1;
              continue;
            }
            localByteBuffer.flip();
            localByteBuffer.get(arrayOfByte);
            i2 = arrayOfByte.length;
            i7 = com.tencent.mobileqq.msf.core.c.a(arrayOfByte, 0);
            if (i7 != i2)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.QualityTestManager", 4, "testdata length error stop dataTotalLen:" + i7 + " receBodySize:" + i2);
              }
              a(g.d.a.f);
              this.p.y.add(Integer.valueOf(i6));
            }
          }
        }
      }
      finally
      {
        m.a();
      }
      if (!a(arrayOfByte))
      {
        i1 = 0;
      }
      else if (!a(arrayOfByte.length, arrayOfByte))
      {
        this.p.v.add(Integer.valueOf(arrayOfByte.length));
        i1 = 0;
      }
      else
      {
        label1593:
        label1638:
        h();
        if (i3 == this.c.b.size() - 1) {}
        for (boolean bool = true;; bool = false)
        {
          b(g.d.a.a, bool);
          i3 += 1;
          break;
        }
        i1 = i2;
        continue;
        label1688:
        i2 = 0;
        continue;
        label1693:
        i4 += 1;
        continue;
        label1702:
        i5 = 0;
        i2 = i1;
        continue;
      }
      label1710:
      i5 += 1;
      int i2 = i1;
      continue;
      label1721:
      i2 = 0;
    }
  }
  
  public String a()
  {
    return this.S;
  }
  
  public void a(g.d.a parama, boolean paramBoolean)
  {
    if (parama == g.d.a.a)
    {
      this.p.b = parama;
      if (((this.a != g.a.c) || (this.l != 1)) && (this.a != g.a.a)) {
        break label314;
      }
      this.p.p = 0;
      label51:
      if (this.a != g.a.a) {
        break label345;
      }
      this.p.q = 0;
      label69:
      parama = this.p.toString();
      if (!TextUtils.isEmpty(this.S)) {
        break label376;
      }
      this.S += "(";
      if ((this.b == null) || (this.c != null) || (this.q.a != g.c.a.a) || (this.p.a != g.d.b.a)) {}
    }
    for (this.S += this.q.toString();; this.S += "*") {
      label314:
      label345:
      label376:
      do
      {
        this.S += parama;
        if (paramBoolean) {}
        try
        {
          this.S += ")";
          parama = new CRC32();
          parama.update(this.S.getBytes());
          this.S += parama.getValue();
          return;
        }
        catch (Exception parama)
        {
          parama.printStackTrace();
        }
        this.p.b = g.d.a.b;
        if (parama == g.d.a.b) {
          break;
        }
        a(parama);
        break;
        if (this.A == 0L) {
          break label51;
        }
        this.p.p = ((int)((float)this.B / (float)this.A));
        break label51;
        if (this.C == 0L) {
          break label69;
        }
        this.p.q = ((int)((float)this.D / (float)this.C));
        break label69;
      } while ((this.S.endsWith("#")) || (this.S.endsWith("(")));
    }
  }
  
  public String b()
  {
    c();
    if (this.f) {
      return this.S;
    }
    return "";
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield 104	com/tencent/mobileqq/msf/core/net/c/g:f	Z
    //   5: aload_0
    //   6: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   9: ifnonnull +15 -> 24
    //   12: aload_0
    //   13: getstatic 1144	com/tencent/mobileqq/msf/core/net/c/g$d$a:k	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   16: iconst_1
    //   17: invokespecial 848	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;Z)V
    //   20: invokestatic 850	com/tencent/mobileqq/msf/core/net/c/m:a	()V
    //   23: return
    //   24: aload_0
    //   25: invokespecial 1146	com/tencent/mobileqq/msf/core/net/c/g:k	()V
    //   28: aload_0
    //   29: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   32: getstatic 1450	com/tencent/mobileqq/msf/core/net/c/g$d$b:a	Lcom/tencent/mobileqq/msf/core/net/c/g$d$b;
    //   35: putfield 1359	com/tencent/mobileqq/msf/core/net/c/g$d:a	Lcom/tencent/mobileqq/msf/core/net/c/g$d$b;
    //   38: aload_0
    //   39: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   42: aload_0
    //   43: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   46: getfield 1148	com/tencent/msf/service/protocol/push/a/d:a	S
    //   49: putfield 1150	com/tencent/mobileqq/msf/core/net/c/g$d:r	I
    //   52: aload_0
    //   53: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   56: aload_0
    //   57: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   60: getfield 1471	com/tencent/msf/service/protocol/push/a/d:c	J
    //   63: putfield 1362	com/tencent/mobileqq/msf/core/net/c/g$d:s	J
    //   66: aload_0
    //   67: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   70: aload_0
    //   71: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   74: getfield 1472	com/tencent/msf/service/protocol/push/a/d:d	J
    //   77: putfield 1364	com/tencent/mobileqq/msf/core/net/c/g$d:t	J
    //   80: aload_0
    //   81: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   84: new 333	java/util/ArrayList
    //   87: dup
    //   88: invokespecial 883	java/util/ArrayList:<init>	()V
    //   91: putfield 1366	com/tencent/mobileqq/msf/core/net/c/g$d:u	Ljava/util/ArrayList;
    //   94: aload_0
    //   95: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   98: getfield 1366	com/tencent/mobileqq/msf/core/net/c/g$d:u	Ljava/util/ArrayList;
    //   101: aload_0
    //   102: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   105: getfield 833	com/tencent/msf/service/protocol/push/a/d:f	J
    //   108: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   111: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   114: pop
    //   115: aload_0
    //   116: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   119: aload_0
    //   120: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   123: getfield 1190	com/tencent/msf/service/protocol/push/a/d:h	J
    //   126: putfield 1370	com/tencent/mobileqq/msf/core/net/c/g$d:w	J
    //   129: aload_0
    //   130: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   133: aload_0
    //   134: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   137: getfield 290	com/tencent/msf/service/protocol/push/a/d:o	S
    //   140: i2l
    //   141: putfield 1473	com/tencent/mobileqq/msf/core/net/c/g$d:B	J
    //   144: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +434 -> 581
    //   150: new 242	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   157: astore 17
    //   159: aload 17
    //   161: ldc_w 1475
    //   164: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_0
    //   168: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   171: getfield 1472	com/tencent/msf/service/protocol/push/a/d:d	J
    //   174: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   177: ldc_w 1477
    //   180: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload_0
    //   184: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   187: getfield 1472	com/tencent/msf/service/protocol/push/a/d:d	J
    //   190: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   193: ldc_w 1154
    //   196: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_0
    //   200: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   203: getfield 1156	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   206: invokevirtual 718	java/util/ArrayList:size	()I
    //   209: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: ldc_w 1380
    //   215: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_0
    //   219: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   222: getfield 1471	com/tencent/msf/service/protocol/push/a/d:c	J
    //   225: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   228: ldc_w 1479
    //   231: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: astore 18
    //   236: aload_0
    //   237: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   240: getfield 1342	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   243: ifnull +394 -> 637
    //   246: aload_0
    //   247: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   250: getfield 1342	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   253: arraylength
    //   254: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: astore 16
    //   259: aload 18
    //   261: aload 16
    //   263: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   266: ldc_w 1481
    //   269: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: astore 18
    //   274: aload_0
    //   275: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   278: getfield 1483	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   281: ifnull +364 -> 645
    //   284: aload_0
    //   285: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   288: getfield 1483	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   291: arraylength
    //   292: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   295: astore 16
    //   297: aload 18
    //   299: aload 16
    //   301: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   304: ldc_w 1485
    //   307: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_0
    //   311: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   314: getfield 833	com/tencent/msf/service/protocol/push/a/d:f	J
    //   317: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   320: ldc_w 1487
    //   323: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: astore 18
    //   328: aload_0
    //   329: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   332: getfield 270	com/tencent/msf/service/protocol/push/a/d:e	[B
    //   335: ifnull +318 -> 653
    //   338: aload_0
    //   339: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   342: getfield 270	com/tencent/msf/service/protocol/push/a/d:e	[B
    //   345: arraylength
    //   346: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   349: astore 16
    //   351: aload 18
    //   353: aload 16
    //   355: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   358: ldc_w 1158
    //   361: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: aload_0
    //   365: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   368: getfield 760	com/tencent/msf/service/protocol/push/a/d:r	S
    //   371: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   374: ldc_w 1489
    //   377: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_0
    //   381: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   384: getfield 1304	com/tencent/msf/service/protocol/push/a/d:j	J
    //   387: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   390: ldc_w 1491
    //   393: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_0
    //   397: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   400: getfield 1310	com/tencent/msf/service/protocol/push/a/d:k	J
    //   403: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   406: ldc_w 1493
    //   409: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_0
    //   413: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   416: getfield 1312	com/tencent/msf/service/protocol/push/a/d:l	J
    //   419: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   422: ldc_w 1495
    //   425: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: aload_0
    //   429: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   432: getfield 1316	com/tencent/msf/service/protocol/push/a/d:m	J
    //   435: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   438: ldc_w 1497
    //   441: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload_0
    //   445: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   448: getfield 1499	com/tencent/msf/service/protocol/push/a/d:n	J
    //   451: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   454: ldc_w 1501
    //   457: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload_0
    //   461: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   464: getfield 290	com/tencent/msf/service/protocol/push/a/d:o	S
    //   467: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   470: ldc_w 1162
    //   473: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload_0
    //   477: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   480: getfield 1164	com/tencent/msf/service/protocol/push/a/d:u	Ljava/lang/String;
    //   483: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: ldc_w 1170
    //   489: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload_0
    //   493: getfield 132	com/tencent/mobileqq/msf/core/net/c/g:q	Lcom/tencent/mobileqq/msf/core/net/c/g$c;
    //   496: getfield 1172	com/tencent/mobileqq/msf/core/net/c/g$c:j	Ljava/lang/String;
    //   499: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: ldc_w 1174
    //   505: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload_0
    //   509: getfield 132	com/tencent/mobileqq/msf/core/net/c/g:q	Lcom/tencent/mobileqq/msf/core/net/c/g$c;
    //   512: getfield 1176	com/tencent/mobileqq/msf/core/net/c/g$c:l	J
    //   515: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   518: ldc_w 1178
    //   521: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: aload_0
    //   525: getfield 132	com/tencent/mobileqq/msf/core/net/c/g:q	Lcom/tencent/mobileqq/msf/core/net/c/g$c;
    //   528: getfield 1180	com/tencent/mobileqq/msf/core/net/c/g$c:m	Ljava/lang/String;
    //   531: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: ldc_w 1503
    //   537: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload_0
    //   541: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   544: getfield 270	com/tencent/msf/service/protocol/push/a/d:e	[B
    //   547: invokestatic 1507	java/util/Arrays:toString	([B)Ljava/lang/String;
    //   550: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: ldc_w 1509
    //   556: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: aload_0
    //   560: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   563: getfield 655	com/tencent/msf/service/protocol/push/a/d:y	S
    //   566: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: ldc 240
    //   572: iconst_2
    //   573: aload 17
    //   575: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   581: aload_0
    //   582: getfield 170	com/tencent/mobileqq/msf/core/net/c/g:d	I
    //   585: iconst_1
    //   586: if_icmple +75 -> 661
    //   589: aload_0
    //   590: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   593: getfield 1156	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   596: invokevirtual 718	java/util/ArrayList:size	()I
    //   599: sipush 200
    //   602: if_icmple +202 -> 804
    //   605: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   608: ifeq +12 -> 620
    //   611: ldc 240
    //   613: iconst_4
    //   614: ldc_w 1511
    //   617: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   620: aload_0
    //   621: iconst_0
    //   622: putfield 134	com/tencent/mobileqq/msf/core/net/c/g:V	Z
    //   625: aload_0
    //   626: getstatic 1184	com/tencent/mobileqq/msf/core/net/c/g$d$a:m	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   629: iconst_1
    //   630: invokespecial 848	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;Z)V
    //   633: invokestatic 850	com/tencent/mobileqq/msf/core/net/c/m:a	()V
    //   636: return
    //   637: ldc_w 1513
    //   640: astore 16
    //   642: goto -383 -> 259
    //   645: ldc_w 1513
    //   648: astore 16
    //   650: goto -353 -> 297
    //   653: ldc_w 1513
    //   656: astore 16
    //   658: goto -307 -> 351
    //   661: aload_0
    //   662: getfield 170	com/tencent/mobileqq/msf/core/net/c/g:d	I
    //   665: iconst_1
    //   666: if_icmpne +66 -> 732
    //   669: aload_0
    //   670: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   673: getfield 1316	com/tencent/msf/service/protocol/push/a/d:m	J
    //   676: ldc2_w 1514
    //   679: land
    //   680: lconst_1
    //   681: lcmp
    //   682: ifeq +50 -> 732
    //   685: aload_0
    //   686: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   689: getfield 1156	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   692: invokevirtual 718	java/util/ArrayList:size	()I
    //   695: bipush 75
    //   697: if_icmple +107 -> 804
    //   700: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   703: ifeq +12 -> 715
    //   706: ldc 240
    //   708: iconst_4
    //   709: ldc_w 1182
    //   712: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   715: aload_0
    //   716: iconst_0
    //   717: putfield 134	com/tencent/mobileqq/msf/core/net/c/g:V	Z
    //   720: aload_0
    //   721: getstatic 1184	com/tencent/mobileqq/msf/core/net/c/g$d$a:m	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   724: iconst_1
    //   725: invokespecial 848	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;Z)V
    //   728: invokestatic 850	com/tencent/mobileqq/msf/core/net/c/m:a	()V
    //   731: return
    //   732: aload_0
    //   733: getfield 170	com/tencent/mobileqq/msf/core/net/c/g:d	I
    //   736: iconst_1
    //   737: if_icmpne +67 -> 804
    //   740: aload_0
    //   741: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   744: getfield 1316	com/tencent/msf/service/protocol/push/a/d:m	J
    //   747: ldc2_w 1514
    //   750: land
    //   751: lconst_1
    //   752: lcmp
    //   753: ifne +51 -> 804
    //   756: aload_0
    //   757: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   760: getfield 1156	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   763: invokevirtual 718	java/util/ArrayList:size	()I
    //   766: sipush 200
    //   769: if_icmple +35 -> 804
    //   772: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   775: ifeq +12 -> 787
    //   778: ldc 240
    //   780: iconst_4
    //   781: ldc_w 1511
    //   784: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   787: aload_0
    //   788: iconst_0
    //   789: putfield 134	com/tencent/mobileqq/msf/core/net/c/g:V	Z
    //   792: aload_0
    //   793: getstatic 1184	com/tencent/mobileqq/msf/core/net/c/g$d$a:m	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   796: iconst_1
    //   797: invokespecial 848	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;Z)V
    //   800: invokestatic 850	com/tencent/mobileqq/msf/core/net/c/m:a	()V
    //   803: return
    //   804: aload_0
    //   805: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   808: getfield 1156	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   811: invokevirtual 718	java/util/ArrayList:size	()I
    //   814: ifgt +30 -> 844
    //   817: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   820: ifeq +12 -> 832
    //   823: ldc 240
    //   825: iconst_4
    //   826: ldc_w 1186
    //   829: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   832: aload_0
    //   833: getstatic 1188	com/tencent/mobileqq/msf/core/net/c/g$d$a:n	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   836: iconst_1
    //   837: invokespecial 848	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;Z)V
    //   840: invokestatic 850	com/tencent/mobileqq/msf/core/net/c/m:a	()V
    //   843: return
    //   844: aload_0
    //   845: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   848: getfield 833	com/tencent/msf/service/protocol/push/a/d:f	J
    //   851: lconst_0
    //   852: lcmp
    //   853: ifgt +30 -> 883
    //   856: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   859: ifeq +12 -> 871
    //   862: ldc 240
    //   864: iconst_4
    //   865: ldc_w 1517
    //   868: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   871: aload_0
    //   872: getstatic 1519	com/tencent/mobileqq/msf/core/net/c/g$d$a:q	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   875: iconst_1
    //   876: invokespecial 848	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;Z)V
    //   879: invokestatic 850	com/tencent/mobileqq/msf/core/net/c/m:a	()V
    //   882: return
    //   883: aload_0
    //   884: getfield 170	com/tencent/mobileqq/msf/core/net/c/g:d	I
    //   887: iconst_1
    //   888: if_icmple +49 -> 937
    //   891: aload_0
    //   892: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   895: getfield 1471	com/tencent/msf/service/protocol/push/a/d:c	J
    //   898: ldc2_w 1520
    //   901: lcmp
    //   902: ifle +175 -> 1077
    //   905: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   908: ifeq +12 -> 920
    //   911: ldc 240
    //   913: iconst_4
    //   914: ldc_w 1523
    //   917: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   920: aload_0
    //   921: iconst_0
    //   922: putfield 134	com/tencent/mobileqq/msf/core/net/c/g:V	Z
    //   925: aload_0
    //   926: getstatic 1386	com/tencent/mobileqq/msf/core/net/c/g$d$a:l	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   929: iconst_1
    //   930: invokespecial 848	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;Z)V
    //   933: invokestatic 850	com/tencent/mobileqq/msf/core/net/c/m:a	()V
    //   936: return
    //   937: aload_0
    //   938: getfield 170	com/tencent/mobileqq/msf/core/net/c/g:d	I
    //   941: iconst_1
    //   942: if_icmpne +65 -> 1007
    //   945: aload_0
    //   946: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   949: getfield 1316	com/tencent/msf/service/protocol/push/a/d:m	J
    //   952: ldc2_w 1514
    //   955: land
    //   956: lconst_1
    //   957: lcmp
    //   958: ifeq +49 -> 1007
    //   961: aload_0
    //   962: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   965: getfield 1471	com/tencent/msf/service/protocol/push/a/d:c	J
    //   968: ldc2_w 1381
    //   971: lcmp
    //   972: ifle +105 -> 1077
    //   975: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   978: ifeq +12 -> 990
    //   981: ldc 240
    //   983: iconst_4
    //   984: ldc_w 1384
    //   987: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   990: aload_0
    //   991: iconst_0
    //   992: putfield 134	com/tencent/mobileqq/msf/core/net/c/g:V	Z
    //   995: aload_0
    //   996: getstatic 1386	com/tencent/mobileqq/msf/core/net/c/g$d$a:l	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   999: iconst_1
    //   1000: invokespecial 848	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;Z)V
    //   1003: invokestatic 850	com/tencent/mobileqq/msf/core/net/c/m:a	()V
    //   1006: return
    //   1007: aload_0
    //   1008: getfield 170	com/tencent/mobileqq/msf/core/net/c/g:d	I
    //   1011: iconst_1
    //   1012: if_icmpne +65 -> 1077
    //   1015: aload_0
    //   1016: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1019: getfield 1316	com/tencent/msf/service/protocol/push/a/d:m	J
    //   1022: ldc2_w 1514
    //   1025: land
    //   1026: lconst_1
    //   1027: lcmp
    //   1028: ifne +49 -> 1077
    //   1031: aload_0
    //   1032: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1035: getfield 1471	com/tencent/msf/service/protocol/push/a/d:c	J
    //   1038: ldc2_w 1520
    //   1041: lcmp
    //   1042: ifle +35 -> 1077
    //   1045: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1048: ifeq +12 -> 1060
    //   1051: ldc 240
    //   1053: iconst_4
    //   1054: ldc_w 1523
    //   1057: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1060: aload_0
    //   1061: iconst_0
    //   1062: putfield 134	com/tencent/mobileqq/msf/core/net/c/g:V	Z
    //   1065: aload_0
    //   1066: getstatic 1386	com/tencent/mobileqq/msf/core/net/c/g$d$a:l	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   1069: iconst_1
    //   1070: invokespecial 848	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;Z)V
    //   1073: invokestatic 850	com/tencent/mobileqq/msf/core/net/c/m:a	()V
    //   1076: return
    //   1077: aload_0
    //   1078: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1081: getfield 1316	com/tencent/msf/service/protocol/push/a/d:m	J
    //   1084: bipush 8
    //   1086: lshr
    //   1087: ldc2_w 1514
    //   1090: land
    //   1091: ldc2_w 1381
    //   1094: lcmp
    //   1095: ifle +35 -> 1130
    //   1098: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1101: ifeq +12 -> 1113
    //   1104: ldc 240
    //   1106: iconst_4
    //   1107: ldc_w 1525
    //   1110: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1113: aload_0
    //   1114: iconst_0
    //   1115: putfield 134	com/tencent/mobileqq/msf/core/net/c/g:V	Z
    //   1118: aload_0
    //   1119: getstatic 1386	com/tencent/mobileqq/msf/core/net/c/g$d$a:l	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   1122: iconst_1
    //   1123: invokespecial 848	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;Z)V
    //   1126: invokestatic 850	com/tencent/mobileqq/msf/core/net/c/m:a	()V
    //   1129: return
    //   1130: aload_0
    //   1131: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1134: getfield 1190	com/tencent/msf/service/protocol/push/a/d:h	J
    //   1137: ldc2_w 1191
    //   1140: lmul
    //   1141: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   1144: lcmp
    //   1145: ifge +65 -> 1210
    //   1148: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1151: ifeq +47 -> 1198
    //   1154: ldc 240
    //   1156: iconst_4
    //   1157: new 242	java/lang/StringBuilder
    //   1160: dup
    //   1161: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   1164: ldc_w 1194
    //   1167: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: aload_0
    //   1171: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1174: getfield 1190	com/tencent/msf/service/protocol/push/a/d:h	J
    //   1177: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1180: ldc_w 1196
    //   1183: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   1189: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1192: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1195: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1198: aload_0
    //   1199: getstatic 1198	com/tencent/mobileqq/msf/core/net/c/g$d$a:j	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   1202: iconst_1
    //   1203: invokespecial 848	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;Z)V
    //   1206: invokestatic 850	com/tencent/mobileqq/msf/core/net/c/m:a	()V
    //   1209: return
    //   1210: aload_0
    //   1211: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1214: getfield 290	com/tencent/msf/service/protocol/push/a/d:o	S
    //   1217: ifeq +81 -> 1298
    //   1220: iconst_1
    //   1221: aload_0
    //   1222: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1225: getfield 290	com/tencent/msf/service/protocol/push/a/d:o	S
    //   1228: if_icmpeq +70 -> 1298
    //   1231: iconst_2
    //   1232: aload_0
    //   1233: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1236: getfield 290	com/tencent/msf/service/protocol/push/a/d:o	S
    //   1239: if_icmpeq +59 -> 1298
    //   1242: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1245: ifeq +41 -> 1286
    //   1248: ldc 240
    //   1250: iconst_2
    //   1251: new 242	java/lang/StringBuilder
    //   1254: dup
    //   1255: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   1258: ldc_w 1527
    //   1261: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: aload_0
    //   1265: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1268: getfield 290	com/tencent/msf/service/protocol/push/a/d:o	S
    //   1271: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1274: ldc_w 1529
    //   1277: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1280: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1283: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1286: aload_0
    //   1287: getstatic 1531	com/tencent/mobileqq/msf/core/net/c/g$d$a:w	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   1290: iconst_1
    //   1291: invokespecial 848	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;Z)V
    //   1294: invokestatic 850	com/tencent/mobileqq/msf/core/net/c/m:a	()V
    //   1297: return
    //   1298: iconst_0
    //   1299: istore_2
    //   1300: iload_2
    //   1301: istore_1
    //   1302: aload_0
    //   1303: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1306: getfield 1342	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   1309: ifnull +25 -> 1334
    //   1312: iload_2
    //   1313: istore_1
    //   1314: aload_0
    //   1315: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1318: getfield 1342	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   1321: arraylength
    //   1322: ifle +12 -> 1334
    //   1325: aload_0
    //   1326: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1329: getfield 1342	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   1332: arraylength
    //   1333: istore_1
    //   1334: iload_1
    //   1335: i2l
    //   1336: aload_0
    //   1337: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1340: getfield 270	com/tencent/msf/service/protocol/push/a/d:e	[B
    //   1343: arraylength
    //   1344: i2l
    //   1345: aload_0
    //   1346: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1349: getfield 833	com/tencent/msf/service/protocol/push/a/d:f	J
    //   1352: lmul
    //   1353: ladd
    //   1354: l2i
    //   1355: istore 6
    //   1357: aload_0
    //   1358: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1361: getfield 1483	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   1364: ifnull +2770 -> 4134
    //   1367: aload_0
    //   1368: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1371: getfield 1483	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   1374: arraylength
    //   1375: ifle +2759 -> 4134
    //   1378: iload 6
    //   1380: aload_0
    //   1381: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1384: getfield 1483	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   1387: arraylength
    //   1388: iadd
    //   1389: istore 6
    //   1391: ldc 240
    //   1393: iconst_1
    //   1394: new 242	java/lang/StringBuilder
    //   1397: dup
    //   1398: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   1401: ldc_w 1533
    //   1404: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1407: iload 6
    //   1409: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1412: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1415: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1418: aload_0
    //   1419: getfield 166	com/tencent/mobileqq/msf/core/net/c/g:a	Lcom/tencent/mobileqq/msf/core/net/c/g$a;
    //   1422: getstatic 231	com/tencent/mobileqq/msf/core/net/c/g$a:c	Lcom/tencent/mobileqq/msf/core/net/c/g$a;
    //   1425: if_acmpne +13 -> 1438
    //   1428: iload 6
    //   1430: ifne +81 -> 1511
    //   1433: aload_0
    //   1434: iconst_1
    //   1435: putfield 114	com/tencent/mobileqq/msf/core/net/c/g:l	I
    //   1438: aload_0
    //   1439: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1442: getfield 1472	com/tencent/msf/service/protocol/push/a/d:d	J
    //   1445: ldc2_w 1414
    //   1448: lcmp
    //   1449: ifge +94 -> 1543
    //   1452: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1455: ifeq +41 -> 1496
    //   1458: ldc 240
    //   1460: iconst_4
    //   1461: new 242	java/lang/StringBuilder
    //   1464: dup
    //   1465: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   1468: ldc_w 1417
    //   1471: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: aload_0
    //   1475: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1478: getfield 1472	com/tencent/msf/service/protocol/push/a/d:d	J
    //   1481: invokevirtual 350	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1484: ldc_w 1413
    //   1487: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1493: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1496: aload_0
    //   1497: getstatic 1419	com/tencent/mobileqq/msf/core/net/c/g$d$a:g	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   1500: iconst_1
    //   1501: invokespecial 848	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;Z)V
    //   1504: invokestatic 850	com/tencent/mobileqq/msf/core/net/c/m:a	()V
    //   1507: invokestatic 850	com/tencent/mobileqq/msf/core/net/c/m:a	()V
    //   1510: return
    //   1511: aload_0
    //   1512: iconst_0
    //   1513: putfield 114	com/tencent/mobileqq/msf/core/net/c/g:l	I
    //   1516: goto -78 -> 1438
    //   1519: astore 16
    //   1521: ldc 240
    //   1523: iconst_1
    //   1524: ldc_w 1535
    //   1527: aload 16
    //   1529: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1532: goto -25 -> 1507
    //   1535: astore 16
    //   1537: invokestatic 850	com/tencent/mobileqq/msf/core/net/c/m:a	()V
    //   1540: aload 16
    //   1542: athrow
    //   1543: iconst_0
    //   1544: istore 5
    //   1546: iconst_0
    //   1547: istore_1
    //   1548: iload_1
    //   1549: aload_0
    //   1550: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1553: getfield 1156	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   1556: invokevirtual 718	java/util/ArrayList:size	()I
    //   1559: if_icmpge -52 -> 1507
    //   1562: iload 5
    //   1564: ifne -57 -> 1507
    //   1567: aload_0
    //   1568: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1571: new 333	java/util/ArrayList
    //   1574: dup
    //   1575: invokespecial 883	java/util/ArrayList:<init>	()V
    //   1578: putfield 1396	com/tencent/mobileqq/msf/core/net/c/g$d:y	Ljava/util/ArrayList;
    //   1581: aload_0
    //   1582: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1585: iconst_0
    //   1586: putfield 343	com/tencent/mobileqq/msf/core/net/c/g$d:k	I
    //   1589: aload_0
    //   1590: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1593: iconst_0
    //   1594: putfield 389	com/tencent/mobileqq/msf/core/net/c/g$d:n	I
    //   1597: aload_0
    //   1598: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1601: iconst_0
    //   1602: putfield 801	com/tencent/mobileqq/msf/core/net/c/g$d:l	I
    //   1605: aload_0
    //   1606: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1609: iconst_0
    //   1610: putfield 394	com/tencent/mobileqq/msf/core/net/c/g$d:m	I
    //   1613: aload_0
    //   1614: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1617: iconst_0
    //   1618: putfield 646	com/tencent/mobileqq/msf/core/net/c/g$d:o	I
    //   1621: aload_0
    //   1622: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1625: getfield 177	com/tencent/mobileqq/msf/core/net/c/g$d:c	Ljava/util/Map;
    //   1628: invokeinterface 1227 1 0
    //   1633: aload_0
    //   1634: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1637: iconst_0
    //   1638: putfield 1537	com/tencent/mobileqq/msf/core/net/c/g$d:x	Z
    //   1641: aload_0
    //   1642: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1645: aconst_null
    //   1646: putfield 1539	com/tencent/mobileqq/msf/core/net/c/g$d:A	Ljava/lang/String;
    //   1649: aload_0
    //   1650: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1653: getfield 617	com/tencent/mobileqq/msf/core/net/c/g$d:I	Ljava/util/ArrayList;
    //   1656: invokevirtual 1397	java/util/ArrayList:clear	()V
    //   1659: aload_0
    //   1660: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1663: getfield 326	com/tencent/mobileqq/msf/core/net/c/g$d:J	Ljava/util/ArrayList;
    //   1666: invokevirtual 1397	java/util/ArrayList:clear	()V
    //   1669: aload_0
    //   1670: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1673: aconst_null
    //   1674: putfield 418	com/tencent/mobileqq/msf/core/net/c/g$d:d	Ljava/net/InetAddress;
    //   1677: aload_0
    //   1678: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1681: lconst_0
    //   1682: putfield 944	com/tencent/mobileqq/msf/core/net/c/g$d:D	J
    //   1685: aload_0
    //   1686: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1689: iconst_0
    //   1690: putfield 946	com/tencent/mobileqq/msf/core/net/c/g$d:E	I
    //   1693: aload_0
    //   1694: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1697: iconst_0
    //   1698: putfield 568	com/tencent/mobileqq/msf/core/net/c/g$d:F	I
    //   1701: aload_0
    //   1702: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1705: iconst_0
    //   1706: putfield 514	com/tencent/mobileqq/msf/core/net/c/g$d:G	I
    //   1709: aload_0
    //   1710: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1713: invokestatic 207	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   1716: putfield 1202	com/tencent/mobileqq/msf/core/net/c/g$d:g	I
    //   1719: aload_0
    //   1720: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1723: invokestatic 1205	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getWifiStrength	()I
    //   1726: putfield 1207	com/tencent/mobileqq/msf/core/net/c/g$d:h	I
    //   1729: aload_0
    //   1730: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1733: invokestatic 1210	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getCdmaStrength	()I
    //   1736: putfield 1212	com/tencent/mobileqq/msf/core/net/c/g$d:j	I
    //   1739: aload_0
    //   1740: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1743: invokestatic 1215	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getGsmStrength	()I
    //   1746: putfield 1217	com/tencent/mobileqq/msf/core/net/c/g$d:i	I
    //   1749: aload_0
    //   1750: lconst_0
    //   1751: putfield 154	com/tencent/mobileqq/msf/core/net/c/g:A	J
    //   1754: aload_0
    //   1755: lconst_0
    //   1756: putfield 158	com/tencent/mobileqq/msf/core/net/c/g:C	J
    //   1759: aload_0
    //   1760: lconst_0
    //   1761: putfield 156	com/tencent/mobileqq/msf/core/net/c/g:B	J
    //   1764: aload_0
    //   1765: lconst_0
    //   1766: putfield 160	com/tencent/mobileqq/msf/core/net/c/g:D	J
    //   1769: iload_1
    //   1770: istore_3
    //   1771: invokestatic 1285	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isWifiConn	()Z
    //   1774: ifeq +247 -> 2021
    //   1777: iload_1
    //   1778: istore_3
    //   1779: invokestatic 1205	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getWifiStrength	()I
    //   1782: bipush 10
    //   1784: if_icmple +237 -> 2021
    //   1787: iload_1
    //   1788: istore_3
    //   1789: getstatic 1541	com/tencent/mobileqq/msf/core/net/c/m:e	Ljava/lang/String;
    //   1792: ldc_w 1543
    //   1795: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1798: ifeq +140 -> 1938
    //   1801: iload_1
    //   1802: istore_3
    //   1803: aload_0
    //   1804: getfield 172	com/tencent/mobileqq/msf/core/net/c/g:e	I
    //   1807: ifeq +131 -> 1938
    //   1810: iload_1
    //   1811: istore_3
    //   1812: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1815: ifeq -308 -> 1507
    //   1818: iload_1
    //   1819: istore_3
    //   1820: ldc 240
    //   1822: iconst_2
    //   1823: new 242	java/lang/StringBuilder
    //   1826: dup
    //   1827: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   1830: ldc_w 1545
    //   1833: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1836: invokestatic 1549	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1839: invokevirtual 1552	java/lang/Thread:getName	()Ljava/lang/String;
    //   1842: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1845: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1848: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1851: goto -344 -> 1507
    //   1854: astore 16
    //   1856: lconst_1
    //   1857: lstore 11
    //   1859: iload_3
    //   1860: istore_2
    //   1861: lload 11
    //   1863: lstore 9
    //   1865: iload_2
    //   1866: istore_1
    //   1867: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1870: ifeq +2267 -> 4137
    //   1873: ldc 240
    //   1875: iconst_4
    //   1876: ldc_w 1554
    //   1879: aload 16
    //   1881: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1884: lload 11
    //   1886: lstore 9
    //   1888: iload_2
    //   1889: istore_1
    //   1890: goto +2247 -> 4137
    //   1893: aload_0
    //   1894: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   1897: getfield 1396	com/tencent/mobileqq/msf/core/net/c/g$d:y	Ljava/util/ArrayList;
    //   1900: iload 6
    //   1902: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1905: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1908: pop
    //   1909: iload 4
    //   1911: iconst_m1
    //   1912: if_icmpne +2041 -> 3953
    //   1915: goto +2260 -> 4175
    //   1918: astore 16
    //   1920: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1923: ifeq -174 -> 1749
    //   1926: ldc 240
    //   1928: iconst_4
    //   1929: ldc_w 1402
    //   1932: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1935: goto -186 -> 1749
    //   1938: iload_1
    //   1939: istore_3
    //   1940: aload_0
    //   1941: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1944: getfield 1316	com/tencent/msf/service/protocol/push/a/d:m	J
    //   1947: ldc2_w 1514
    //   1950: land
    //   1951: lconst_1
    //   1952: lcmp
    //   1953: ifne +54 -> 2007
    //   1956: iload_1
    //   1957: istore_3
    //   1958: aload_0
    //   1959: getfield 170	com/tencent/mobileqq/msf/core/net/c/g:d	I
    //   1962: iconst_1
    //   1963: if_icmple +23 -> 1986
    //   1966: iload_1
    //   1967: istore_3
    //   1968: aload_0
    //   1969: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1972: getfield 1471	com/tencent/msf/service/protocol/push/a/d:c	J
    //   1975: aload_0
    //   1976: getfield 170	com/tencent/mobileqq/msf/core/net/c/g:d	I
    //   1979: i2l
    //   1980: ldiv
    //   1981: lstore 9
    //   1983: goto +2154 -> 4137
    //   1986: iload_1
    //   1987: istore_3
    //   1988: aload_0
    //   1989: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1992: getfield 1316	com/tencent/msf/service/protocol/push/a/d:m	J
    //   1995: bipush 8
    //   1997: lshr
    //   1998: ldc2_w 1514
    //   2001: land
    //   2002: lstore 9
    //   2004: goto +2133 -> 4137
    //   2007: iload_1
    //   2008: istore_3
    //   2009: aload_0
    //   2010: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2013: getfield 1471	com/tencent/msf/service/protocol/push/a/d:c	J
    //   2016: lstore 9
    //   2018: goto +2119 -> 4137
    //   2021: iload_1
    //   2022: istore_3
    //   2023: ldc_w 1543
    //   2026: putstatic 1541	com/tencent/mobileqq/msf/core/net/c/m:e	Ljava/lang/String;
    //   2029: iload_1
    //   2030: istore_3
    //   2031: aload_0
    //   2032: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2035: getfield 1316	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2038: ldc2_w 1514
    //   2041: land
    //   2042: lconst_1
    //   2043: lcmp
    //   2044: ifne +279 -> 2323
    //   2047: iload_1
    //   2048: istore_3
    //   2049: aload_0
    //   2050: getfield 170	com/tencent/mobileqq/msf/core/net/c/g:d	I
    //   2053: iconst_1
    //   2054: if_icmple +248 -> 2302
    //   2057: iload_1
    //   2058: istore_3
    //   2059: aload_0
    //   2060: getfield 172	com/tencent/mobileqq/msf/core/net/c/g:e	I
    //   2063: ifeq +47 -> 2110
    //   2066: iload_1
    //   2067: istore_3
    //   2068: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2071: ifeq -564 -> 1507
    //   2074: iload_1
    //   2075: istore_3
    //   2076: ldc 240
    //   2078: iconst_2
    //   2079: new 242	java/lang/StringBuilder
    //   2082: dup
    //   2083: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   2086: ldc_w 1545
    //   2089: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2092: invokestatic 1549	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2095: invokevirtual 1552	java/lang/Thread:getName	()Ljava/lang/String;
    //   2098: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2101: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2104: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2107: goto -600 -> 1507
    //   2110: iconst_m1
    //   2111: istore_2
    //   2112: iload_2
    //   2113: istore_3
    //   2114: aload_0
    //   2115: iconst_1
    //   2116: putfield 170	com/tencent/mobileqq/msf/core/net/c/g:d	I
    //   2119: iload_2
    //   2120: istore_3
    //   2121: aload_0
    //   2122: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2125: getfield 1156	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   2128: invokevirtual 718	java/util/ArrayList:size	()I
    //   2131: bipush 75
    //   2133: if_icmple +96 -> 2229
    //   2136: iload_2
    //   2137: istore_3
    //   2138: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2141: ifeq +14 -> 2155
    //   2144: iload_2
    //   2145: istore_3
    //   2146: ldc 240
    //   2148: iconst_4
    //   2149: ldc_w 1182
    //   2152: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2155: iload_2
    //   2156: istore_3
    //   2157: aload_0
    //   2158: getfield 122	com/tencent/mobileqq/msf/core/net/c/g:S	Ljava/lang/String;
    //   2161: ldc_w 1465
    //   2164: invokevirtual 222	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2167: istore_1
    //   2168: iload_1
    //   2169: iconst_m1
    //   2170: if_icmpeq +20 -> 2190
    //   2173: iload_2
    //   2174: istore_3
    //   2175: aload_0
    //   2176: aload_0
    //   2177: getfield 122	com/tencent/mobileqq/msf/core/net/c/g:S	Ljava/lang/String;
    //   2180: iconst_0
    //   2181: iload_1
    //   2182: iconst_1
    //   2183: iadd
    //   2184: invokevirtual 776	java/lang/String:substring	(II)Ljava/lang/String;
    //   2187: putfield 122	com/tencent/mobileqq/msf/core/net/c/g:S	Ljava/lang/String;
    //   2190: iload_2
    //   2191: istore_3
    //   2192: aload_0
    //   2193: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   2196: getfield 177	com/tencent/mobileqq/msf/core/net/c/g$d:c	Ljava/util/Map;
    //   2199: invokeinterface 1227 1 0
    //   2204: iload_2
    //   2205: istore_3
    //   2206: aload_0
    //   2207: iconst_0
    //   2208: putfield 134	com/tencent/mobileqq/msf/core/net/c/g:V	Z
    //   2211: iload_2
    //   2212: istore_3
    //   2213: aload_0
    //   2214: getstatic 1184	com/tencent/mobileqq/msf/core/net/c/g$d$a:m	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   2217: iconst_1
    //   2218: invokespecial 848	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;Z)V
    //   2221: iload_2
    //   2222: istore_3
    //   2223: invokestatic 850	com/tencent/mobileqq/msf/core/net/c/m:a	()V
    //   2226: goto -719 -> 1507
    //   2229: iload_2
    //   2230: istore_3
    //   2231: aload_0
    //   2232: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2235: getfield 1316	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2238: lstore 9
    //   2240: lload 9
    //   2242: bipush 8
    //   2244: lshr
    //   2245: ldc2_w 1514
    //   2248: land
    //   2249: lstore 11
    //   2251: aload_0
    //   2252: getfield 122	com/tencent/mobileqq/msf/core/net/c/g:S	Ljava/lang/String;
    //   2255: ldc_w 1465
    //   2258: invokevirtual 222	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2261: istore_3
    //   2262: lload 11
    //   2264: lstore 9
    //   2266: iload_2
    //   2267: istore_1
    //   2268: iload_3
    //   2269: iconst_m1
    //   2270: if_icmpeq +1867 -> 4137
    //   2273: aload_0
    //   2274: aload_0
    //   2275: getfield 122	com/tencent/mobileqq/msf/core/net/c/g:S	Ljava/lang/String;
    //   2278: iconst_0
    //   2279: iload_3
    //   2280: iconst_1
    //   2281: iadd
    //   2282: invokevirtual 776	java/lang/String:substring	(II)Ljava/lang/String;
    //   2285: putfield 122	com/tencent/mobileqq/msf/core/net/c/g:S	Ljava/lang/String;
    //   2288: lload 11
    //   2290: lstore 9
    //   2292: iload_2
    //   2293: istore_1
    //   2294: goto +1843 -> 4137
    //   2297: astore 16
    //   2299: goto -438 -> 1861
    //   2302: iload_1
    //   2303: istore_3
    //   2304: aload_0
    //   2305: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2308: getfield 1316	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2311: bipush 8
    //   2313: lshr
    //   2314: ldc2_w 1514
    //   2317: land
    //   2318: lstore 9
    //   2320: goto +1817 -> 4137
    //   2323: iload_1
    //   2324: istore_3
    //   2325: aload_0
    //   2326: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2329: getfield 1471	com/tencent/msf/service/protocol/push/a/d:c	J
    //   2332: lstore 9
    //   2334: goto +1803 -> 4137
    //   2337: invokestatic 1285	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isWifiConn	()Z
    //   2340: ifeq +657 -> 2997
    //   2343: invokestatic 1205	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getWifiStrength	()I
    //   2346: bipush 10
    //   2348: if_icmple +649 -> 2997
    //   2351: getstatic 1541	com/tencent/mobileqq/msf/core/net/c/m:e	Ljava/lang/String;
    //   2354: ldc_w 1543
    //   2357: invokevirtual 369	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2360: ifeq +75 -> 2435
    //   2363: aload_0
    //   2364: getfield 172	com/tencent/mobileqq/msf/core/net/c/g:e	I
    //   2367: istore 4
    //   2369: iload 4
    //   2371: ifeq +64 -> 2435
    //   2374: aload_0
    //   2375: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2378: getfield 1156	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   2381: invokevirtual 718	java/util/ArrayList:size	()I
    //   2384: istore_1
    //   2385: iload_1
    //   2386: istore_3
    //   2387: iload_3
    //   2388: istore_1
    //   2389: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2392: ifeq +34 -> 2426
    //   2395: iload_3
    //   2396: istore_1
    //   2397: ldc 240
    //   2399: iconst_2
    //   2400: new 242	java/lang/StringBuilder
    //   2403: dup
    //   2404: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   2407: ldc_w 1545
    //   2410: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2413: aload_0
    //   2414: getfield 172	com/tencent/mobileqq/msf/core/net/c/g:e	I
    //   2417: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2420: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2423: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2426: iconst_1
    //   2427: istore 5
    //   2429: iload_3
    //   2430: istore 4
    //   2432: goto -539 -> 1893
    //   2435: aload_0
    //   2436: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2439: getfield 1316	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2442: ldc2_w 1514
    //   2445: land
    //   2446: lconst_1
    //   2447: lcmp
    //   2448: ifne +533 -> 2981
    //   2451: aload_0
    //   2452: getfield 170	com/tencent/mobileqq/msf/core/net/c/g:d	I
    //   2455: iconst_1
    //   2456: if_icmple +502 -> 2958
    //   2459: aload_0
    //   2460: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2463: getfield 1471	com/tencent/msf/service/protocol/push/a/d:c	J
    //   2466: aload_0
    //   2467: getfield 170	com/tencent/mobileqq/msf/core/net/c/g:d	I
    //   2470: i2l
    //   2471: ldiv
    //   2472: lstore 11
    //   2474: lload 11
    //   2476: lstore 9
    //   2478: iload_2
    //   2479: istore 4
    //   2481: iload_3
    //   2482: istore_2
    //   2483: iload 14
    //   2485: istore 13
    //   2487: aload_0
    //   2488: lconst_0
    //   2489: putfield 136	com/tencent/mobileqq/msf/core/net/c/g:r	J
    //   2492: iload 14
    //   2494: istore 13
    //   2496: aload_0
    //   2497: lconst_0
    //   2498: putfield 138	com/tencent/mobileqq/msf/core/net/c/g:s	J
    //   2501: iload 14
    //   2503: istore 13
    //   2505: aload_0
    //   2506: lconst_0
    //   2507: putfield 140	com/tencent/mobileqq/msf/core/net/c/g:t	J
    //   2510: iload 14
    //   2512: istore 13
    //   2514: aload_0
    //   2515: lconst_0
    //   2516: putfield 142	com/tencent/mobileqq/msf/core/net/c/g:u	J
    //   2519: iload 14
    //   2521: istore 13
    //   2523: aload_0
    //   2524: lconst_0
    //   2525: putfield 144	com/tencent/mobileqq/msf/core/net/c/g:v	J
    //   2528: iload 14
    //   2530: istore 13
    //   2532: aload_0
    //   2533: lconst_0
    //   2534: putfield 146	com/tencent/mobileqq/msf/core/net/c/g:w	J
    //   2537: iload 14
    //   2539: istore 13
    //   2541: aload_0
    //   2542: lconst_0
    //   2543: putfield 148	com/tencent/mobileqq/msf/core/net/c/g:x	J
    //   2546: iload 14
    //   2548: istore 13
    //   2550: aload_0
    //   2551: lconst_0
    //   2552: putfield 150	com/tencent/mobileqq/msf/core/net/c/g:y	J
    //   2555: iload 14
    //   2557: istore 13
    //   2559: aload_0
    //   2560: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2563: getfield 1156	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   2566: iload_2
    //   2567: invokevirtual 1220	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2570: checkcast 603	com/tencent/msf/service/protocol/push/a/a
    //   2573: astore 20
    //   2575: iload 14
    //   2577: istore 13
    //   2579: aload_0
    //   2580: aload 20
    //   2582: invokespecial 1556	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/msf/service/protocol/push/a/a;)V
    //   2585: iload 14
    //   2587: istore 13
    //   2589: iconst_0
    //   2590: invokestatic 1282	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
    //   2593: istore 7
    //   2595: iload 14
    //   2597: istore 13
    //   2599: aload_0
    //   2600: getfield 118	com/tencent/mobileqq/msf/core/net/c/g:n	Ljava/net/InetAddress;
    //   2603: instanceof 405
    //   2606: ifeq +732 -> 3338
    //   2609: iconst_2
    //   2610: istore 5
    //   2612: ldc 120
    //   2614: astore 16
    //   2616: aload 16
    //   2618: astore 17
    //   2620: iload 7
    //   2622: iconst_2
    //   2623: if_icmplt +270 -> 2893
    //   2626: iload 14
    //   2628: istore 13
    //   2630: aload_0
    //   2631: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   2634: getfield 946	com/tencent/mobileqq/msf/core/net/c/g$d:E	I
    //   2637: iconst_1
    //   2638: if_icmpne +36 -> 2674
    //   2641: iload 14
    //   2643: istore 13
    //   2645: invokestatic 1561	com/tencent/mobileqq/msf/core/net/c/b:a	()Lcom/tencent/mobileqq/msf/core/net/c/b;
    //   2648: iconst_1
    //   2649: iload 7
    //   2651: aload_0
    //   2652: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   2655: getfield 1202	com/tencent/mobileqq/msf/core/net/c/g$d:g	I
    //   2658: iload 5
    //   2660: aload_0
    //   2661: getfield 166	com/tencent/mobileqq/msf/core/net/c/g:a	Lcom/tencent/mobileqq/msf/core/net/c/g$a;
    //   2664: aload 20
    //   2666: getfield 605	com/tencent/msf/service/protocol/push/a/a:c	Ljava/lang/String;
    //   2669: ldc 120
    //   2671: invokevirtual 1564	com/tencent/mobileqq/msf/core/net/c/b:a	(IIIILcom/tencent/mobileqq/msf/core/net/c/g$a;Ljava/lang/String;Ljava/lang/String;)V
    //   2674: aload 16
    //   2676: astore 17
    //   2678: iload 7
    //   2680: iconst_2
    //   2681: if_icmpne +212 -> 2893
    //   2684: aload 16
    //   2686: astore 17
    //   2688: iload 5
    //   2690: iconst_1
    //   2691: if_icmpne +202 -> 2893
    //   2694: iload 14
    //   2696: istore 13
    //   2698: ldc_w 1566
    //   2701: invokestatic 943	java/net/InetAddress:getAllByName	(Ljava/lang/String;)[Ljava/net/InetAddress;
    //   2704: astore 21
    //   2706: aload 21
    //   2708: ifnull +1419 -> 4127
    //   2711: iload 14
    //   2713: istore 13
    //   2715: aload 21
    //   2717: arraylength
    //   2718: ifle +1409 -> 4127
    //   2721: iload 14
    //   2723: istore 13
    //   2725: aload 21
    //   2727: arraylength
    //   2728: istore 8
    //   2730: iconst_0
    //   2731: istore_3
    //   2732: ldc 120
    //   2734: astore 16
    //   2736: aload 16
    //   2738: astore 17
    //   2740: iload_3
    //   2741: iload 8
    //   2743: if_icmpge +93 -> 2836
    //   2746: aload 21
    //   2748: iload_3
    //   2749: aaload
    //   2750: astore 22
    //   2752: aload 16
    //   2754: astore 19
    //   2756: aload 22
    //   2758: ifnull +586 -> 3344
    //   2761: aload 16
    //   2763: astore 19
    //   2765: iload 14
    //   2767: istore 13
    //   2769: aload 16
    //   2771: astore 17
    //   2773: aload 16
    //   2775: astore 18
    //   2777: aload 22
    //   2779: instanceof 405
    //   2782: ifeq +562 -> 3344
    //   2785: iload 14
    //   2787: istore 13
    //   2789: aload 16
    //   2791: astore 17
    //   2793: aload 16
    //   2795: astore 18
    //   2797: aload 22
    //   2799: invokevirtual 649	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   2802: astore 16
    //   2804: iload 14
    //   2806: istore 13
    //   2808: aload 16
    //   2810: astore 17
    //   2812: aload 16
    //   2814: astore 18
    //   2816: aload 16
    //   2818: invokestatic 767	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2821: istore 15
    //   2823: aload 16
    //   2825: astore 19
    //   2827: iload 15
    //   2829: ifne +515 -> 3344
    //   2832: aload 16
    //   2834: astore 17
    //   2836: aload 17
    //   2838: astore 16
    //   2840: aload 16
    //   2842: astore 17
    //   2844: iload 14
    //   2846: istore 13
    //   2848: aload 16
    //   2850: invokestatic 767	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2853: ifeq +40 -> 2893
    //   2856: iload 14
    //   2858: istore 13
    //   2860: invokestatic 1561	com/tencent/mobileqq/msf/core/net/c/b:a	()Lcom/tencent/mobileqq/msf/core/net/c/b;
    //   2863: iconst_2
    //   2864: iload 7
    //   2866: aload_0
    //   2867: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   2870: getfield 1202	com/tencent/mobileqq/msf/core/net/c/g$d:g	I
    //   2873: iload 5
    //   2875: aload_0
    //   2876: getfield 166	com/tencent/mobileqq/msf/core/net/c/g:a	Lcom/tencent/mobileqq/msf/core/net/c/g$a;
    //   2879: aload 20
    //   2881: getfield 605	com/tencent/msf/service/protocol/push/a/a:c	Ljava/lang/String;
    //   2884: aload 16
    //   2886: invokevirtual 1564	com/tencent/mobileqq/msf/core/net/c/b:a	(IIIILcom/tencent/mobileqq/msf/core/net/c/g$a;Ljava/lang/String;Ljava/lang/String;)V
    //   2889: aload 16
    //   2891: astore 17
    //   2893: iload 14
    //   2895: istore 13
    //   2897: aload_0
    //   2898: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2901: getfield 760	com/tencent/msf/service/protocol/push/a/d:r	S
    //   2904: iconst_2
    //   2905: iand
    //   2906: iconst_2
    //   2907: if_icmpne +564 -> 3471
    //   2910: iload 14
    //   2912: istore 13
    //   2914: aload_0
    //   2915: getstatic 1568	com/tencent/mobileqq/msf/core/net/c/g$d$a:z	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   2918: invokespecial 214	com/tencent/mobileqq/msf/core/net/c/g:a	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;)V
    //   2921: iload 14
    //   2923: istore 13
    //   2925: aload_0
    //   2926: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   2929: lconst_0
    //   2930: putfield 1362	com/tencent/mobileqq/msf/core/net/c/g$d:s	J
    //   2933: iconst_0
    //   2934: istore 13
    //   2936: aload_0
    //   2937: invokespecial 1441	com/tencent/mobileqq/msf/core/net/c/g:h	()V
    //   2940: iload 4
    //   2942: iconst_1
    //   2943: iadd
    //   2944: istore 4
    //   2946: iload_2
    //   2947: istore_3
    //   2948: iload 4
    //   2950: istore_2
    //   2951: iload 13
    //   2953: istore 14
    //   2955: goto +1192 -> 4147
    //   2958: aload_0
    //   2959: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2962: getfield 1316	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2965: bipush 8
    //   2967: lshr
    //   2968: ldc2_w 1514
    //   2971: land
    //   2972: lstore 11
    //   2974: lload 11
    //   2976: lstore 9
    //   2978: goto -500 -> 2478
    //   2981: aload_0
    //   2982: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2985: getfield 1471	com/tencent/msf/service/protocol/push/a/d:c	J
    //   2988: lstore 11
    //   2990: lload 11
    //   2992: lstore 9
    //   2994: goto -516 -> 2478
    //   2997: ldc_w 1543
    //   3000: putstatic 1541	com/tencent/mobileqq/msf/core/net/c/m:e	Ljava/lang/String;
    //   3003: aload_0
    //   3004: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3007: getfield 1316	com/tencent/msf/service/protocol/push/a/d:m	J
    //   3010: ldc2_w 1514
    //   3013: land
    //   3014: lconst_1
    //   3015: lcmp
    //   3016: ifne +306 -> 3322
    //   3019: aload_0
    //   3020: getfield 170	com/tencent/mobileqq/msf/core/net/c/g:d	I
    //   3023: iconst_1
    //   3024: if_icmple +275 -> 3299
    //   3027: aload_0
    //   3028: getfield 172	com/tencent/mobileqq/msf/core/net/c/g:e	I
    //   3031: istore 4
    //   3033: iload 4
    //   3035: ifeq +64 -> 3099
    //   3038: aload_0
    //   3039: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3042: getfield 1156	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   3045: invokevirtual 718	java/util/ArrayList:size	()I
    //   3048: istore_1
    //   3049: iload_1
    //   3050: istore_3
    //   3051: iload_3
    //   3052: istore_1
    //   3053: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3056: ifeq +34 -> 3090
    //   3059: iload_3
    //   3060: istore_1
    //   3061: ldc 240
    //   3063: iconst_2
    //   3064: new 242	java/lang/StringBuilder
    //   3067: dup
    //   3068: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   3071: ldc_w 1545
    //   3074: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3077: aload_0
    //   3078: getfield 172	com/tencent/mobileqq/msf/core/net/c/g:e	I
    //   3081: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3084: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3087: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3090: iconst_1
    //   3091: istore 5
    //   3093: iload_3
    //   3094: istore 4
    //   3096: goto -1203 -> 1893
    //   3099: iconst_0
    //   3100: istore_3
    //   3101: aload_0
    //   3102: iconst_1
    //   3103: putfield 170	com/tencent/mobileqq/msf/core/net/c/g:d	I
    //   3106: aload_0
    //   3107: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3110: getfield 1156	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   3113: invokevirtual 718	java/util/ArrayList:size	()I
    //   3116: bipush 75
    //   3118: if_icmple +121 -> 3239
    //   3121: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3124: ifeq +12 -> 3136
    //   3127: ldc 240
    //   3129: iconst_4
    //   3130: ldc_w 1182
    //   3133: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3136: aload_0
    //   3137: getfield 122	com/tencent/mobileqq/msf/core/net/c/g:S	Ljava/lang/String;
    //   3140: ldc_w 1465
    //   3143: invokevirtual 222	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3146: istore_2
    //   3147: iload_2
    //   3148: iconst_m1
    //   3149: if_icmpeq +18 -> 3167
    //   3152: aload_0
    //   3153: aload_0
    //   3154: getfield 122	com/tencent/mobileqq/msf/core/net/c/g:S	Ljava/lang/String;
    //   3157: iconst_0
    //   3158: iload_2
    //   3159: iconst_1
    //   3160: iadd
    //   3161: invokevirtual 776	java/lang/String:substring	(II)Ljava/lang/String;
    //   3164: putfield 122	com/tencent/mobileqq/msf/core/net/c/g:S	Ljava/lang/String;
    //   3167: aload_0
    //   3168: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3171: getfield 177	com/tencent/mobileqq/msf/core/net/c/g$d:c	Ljava/util/Map;
    //   3174: invokeinterface 1227 1 0
    //   3179: aload_0
    //   3180: iconst_0
    //   3181: putfield 134	com/tencent/mobileqq/msf/core/net/c/g:V	Z
    //   3184: aload_0
    //   3185: getstatic 1184	com/tencent/mobileqq/msf/core/net/c/g$d$a:m	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   3188: iconst_1
    //   3189: invokespecial 848	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;Z)V
    //   3192: invokestatic 850	com/tencent/mobileqq/msf/core/net/c/m:a	()V
    //   3195: goto -1688 -> 1507
    //   3198: astore 16
    //   3200: iconst_m1
    //   3201: istore 4
    //   3203: iload_1
    //   3204: istore_2
    //   3205: iload 4
    //   3207: istore_1
    //   3208: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3211: ifeq +14 -> 3225
    //   3214: ldc 240
    //   3216: iconst_4
    //   3217: ldc_w 1554
    //   3220: aload 16
    //   3222: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3225: iload_2
    //   3226: istore 5
    //   3228: iload_3
    //   3229: istore 4
    //   3231: iload_1
    //   3232: istore_2
    //   3233: iload 5
    //   3235: istore_1
    //   3236: goto -753 -> 2483
    //   3239: aload_0
    //   3240: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3243: getfield 1316	com/tencent/msf/service/protocol/push/a/d:m	J
    //   3246: lstore 11
    //   3248: lload 11
    //   3250: bipush 8
    //   3252: lshr
    //   3253: ldc2_w 1514
    //   3256: land
    //   3257: lstore 9
    //   3259: aload_0
    //   3260: getfield 122	com/tencent/mobileqq/msf/core/net/c/g:S	Ljava/lang/String;
    //   3263: ldc_w 1465
    //   3266: invokevirtual 222	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   3269: istore_2
    //   3270: iload_2
    //   3271: iconst_m1
    //   3272: if_icmpeq +18 -> 3290
    //   3275: aload_0
    //   3276: aload_0
    //   3277: getfield 122	com/tencent/mobileqq/msf/core/net/c/g:S	Ljava/lang/String;
    //   3280: iconst_0
    //   3281: iload_2
    //   3282: iconst_1
    //   3283: iadd
    //   3284: invokevirtual 776	java/lang/String:substring	(II)Ljava/lang/String;
    //   3287: putfield 122	com/tencent/mobileqq/msf/core/net/c/g:S	Ljava/lang/String;
    //   3290: iconst_m1
    //   3291: istore 4
    //   3293: iload_1
    //   3294: istore 5
    //   3296: goto -1403 -> 1893
    //   3299: aload_0
    //   3300: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3303: getfield 1316	com/tencent/msf/service/protocol/push/a/d:m	J
    //   3306: bipush 8
    //   3308: lshr
    //   3309: ldc2_w 1514
    //   3312: land
    //   3313: lstore 11
    //   3315: lload 11
    //   3317: lstore 9
    //   3319: goto -841 -> 2478
    //   3322: aload_0
    //   3323: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3326: getfield 1471	com/tencent/msf/service/protocol/push/a/d:c	J
    //   3329: lstore 11
    //   3331: lload 11
    //   3333: lstore 9
    //   3335: goto -857 -> 2478
    //   3338: iconst_1
    //   3339: istore 5
    //   3341: goto -729 -> 2612
    //   3344: iload_3
    //   3345: iconst_1
    //   3346: iadd
    //   3347: istore_3
    //   3348: aload 19
    //   3350: astore 16
    //   3352: goto -616 -> 2736
    //   3355: astore 17
    //   3357: iload 14
    //   3359: istore 13
    //   3361: ldc 240
    //   3363: iconst_1
    //   3364: ldc_w 1570
    //   3367: aload 17
    //   3369: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3372: goto -532 -> 2840
    //   3375: astore 16
    //   3377: ldc 240
    //   3379: iconst_1
    //   3380: ldc_w 1431
    //   3383: aload 16
    //   3385: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3388: aload 16
    //   3390: invokevirtual 493	java/lang/Exception:printStackTrace	()V
    //   3393: aload_0
    //   3394: invokespecial 1441	com/tencent/mobileqq/msf/core/net/c/g:h	()V
    //   3397: aload_0
    //   3398: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3401: getfield 1472	com/tencent/msf/service/protocol/push/a/d:d	J
    //   3404: invokestatic 1437	java/lang/Thread:sleep	(J)V
    //   3407: goto -467 -> 2940
    //   3410: astore 16
    //   3412: ldc 240
    //   3414: iconst_1
    //   3415: new 242	java/lang/StringBuilder
    //   3418: dup
    //   3419: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   3422: ldc_w 1439
    //   3425: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3428: aload 16
    //   3430: invokevirtual 416	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3433: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3436: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3439: goto -499 -> 2940
    //   3442: astore 17
    //   3444: iload 14
    //   3446: istore 13
    //   3448: ldc 240
    //   3450: iconst_1
    //   3451: ldc_w 1572
    //   3454: aload 17
    //   3456: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3459: goto -619 -> 2840
    //   3462: astore 16
    //   3464: aload_0
    //   3465: invokespecial 1441	com/tencent/mobileqq/msf/core/net/c/g:h	()V
    //   3468: aload 16
    //   3470: athrow
    //   3471: iload 5
    //   3473: iconst_2
    //   3474: if_icmpne +42 -> 3516
    //   3477: iload 7
    //   3479: iconst_2
    //   3480: if_icmpge +36 -> 3516
    //   3483: iload 14
    //   3485: istore 13
    //   3487: aload_0
    //   3488: getstatic 1574	com/tencent/mobileqq/msf/core/net/c/g$d$a:B	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   3491: invokespecial 214	com/tencent/mobileqq/msf/core/net/c/g:a	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;)V
    //   3494: iload 14
    //   3496: istore 13
    //   3498: aload_0
    //   3499: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3502: lconst_0
    //   3503: putfield 1362	com/tencent/mobileqq/msf/core/net/c/g$d:s	J
    //   3506: iconst_0
    //   3507: istore 13
    //   3509: aload_0
    //   3510: invokespecial 1441	com/tencent/mobileqq/msf/core/net/c/g:h	()V
    //   3513: goto -573 -> 2940
    //   3516: iload 14
    //   3518: istore 13
    //   3520: aload_0
    //   3521: iload 6
    //   3523: invokespecial 1576	com/tencent/mobileqq/msf/core/net/c/g:a	(I)Z
    //   3526: istore 15
    //   3528: iload 14
    //   3530: istore 13
    //   3532: aload_0
    //   3533: iload 6
    //   3535: aload_0
    //   3536: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3539: getfield 1342	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   3542: aload_0
    //   3543: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3546: getfield 1483	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   3549: invokespecial 1578	com/tencent/mobileqq/msf/core/net/c/g:a	(I[B[B)[B
    //   3552: astore 16
    //   3554: iload 14
    //   3556: istore 13
    //   3558: aload_0
    //   3559: aload 20
    //   3561: invokespecial 1421	com/tencent/mobileqq/msf/core/net/c/g:a	(Lcom/tencent/msf/service/protocol/push/a/a;)Z
    //   3564: ifne +619 -> 4183
    //   3567: iload 14
    //   3569: istore 13
    //   3571: invokestatic 238	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3574: ifeq +16 -> 3590
    //   3577: iload 14
    //   3579: istore 13
    //   3581: ldc 240
    //   3583: iconst_4
    //   3584: ldc_w 1423
    //   3587: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3590: iconst_0
    //   3591: istore 14
    //   3593: iload 14
    //   3595: istore 13
    //   3597: aload_0
    //   3598: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3601: getfield 326	com/tencent/mobileqq/msf/core/net/c/g$d:J	Ljava/util/ArrayList;
    //   3604: ldc2_w 390
    //   3607: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3610: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3613: pop
    //   3614: iload 14
    //   3616: istore 13
    //   3618: aload_0
    //   3619: getstatic 1425	com/tencent/mobileqq/msf/core/net/c/g$d$a:c	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   3622: invokespecial 214	com/tencent/mobileqq/msf/core/net/c/g:a	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;)V
    //   3625: iload 14
    //   3627: istore 13
    //   3629: invokestatic 1561	com/tencent/mobileqq/msf/core/net/c/b:a	()Lcom/tencent/mobileqq/msf/core/net/c/b;
    //   3632: iconst_3
    //   3633: iload 7
    //   3635: aload_0
    //   3636: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3639: getfield 1202	com/tencent/mobileqq/msf/core/net/c/g$d:g	I
    //   3642: iload 5
    //   3644: aload_0
    //   3645: getfield 166	com/tencent/mobileqq/msf/core/net/c/g:a	Lcom/tencent/mobileqq/msf/core/net/c/g$a;
    //   3648: aload 20
    //   3650: getfield 605	com/tencent/msf/service/protocol/push/a/a:c	Ljava/lang/String;
    //   3653: aload 17
    //   3655: invokevirtual 1564	com/tencent/mobileqq/msf/core/net/c/b:a	(IIIILcom/tencent/mobileqq/msf/core/net/c/g$a;Ljava/lang/String;Ljava/lang/String;)V
    //   3658: aload_0
    //   3659: invokespecial 1441	com/tencent/mobileqq/msf/core/net/c/g:h	()V
    //   3662: iconst_0
    //   3663: istore 13
    //   3665: goto -725 -> 2940
    //   3668: iconst_0
    //   3669: istore 13
    //   3671: aload_0
    //   3672: invokespecial 1441	com/tencent/mobileqq/msf/core/net/c/g:h	()V
    //   3675: goto -735 -> 2940
    //   3678: iload 14
    //   3680: istore 13
    //   3682: aload_0
    //   3683: getfield 166	com/tencent/mobileqq/msf/core/net/c/g:a	Lcom/tencent/mobileqq/msf/core/net/c/g$a;
    //   3686: getstatic 231	com/tencent/mobileqq/msf/core/net/c/g$a:c	Lcom/tencent/mobileqq/msf/core/net/c/g$a;
    //   3689: if_acmpne +14 -> 3703
    //   3692: iload 14
    //   3694: istore 13
    //   3696: aload_0
    //   3697: getfield 114	com/tencent/mobileqq/msf/core/net/c/g:l	I
    //   3700: ifne +83 -> 3783
    //   3703: iload 14
    //   3705: istore 13
    //   3707: aload_0
    //   3708: aload 16
    //   3710: invokespecial 1427	com/tencent/mobileqq/msf/core/net/c/g:a	([B)Z
    //   3713: ifne +70 -> 3783
    //   3716: iconst_0
    //   3717: istore 14
    //   3719: iload 14
    //   3721: istore 13
    //   3723: aload_0
    //   3724: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3727: getfield 326	com/tencent/mobileqq/msf/core/net/c/g$d:J	Ljava/util/ArrayList;
    //   3730: ldc2_w 390
    //   3733: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3736: invokevirtual 336	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3739: pop
    //   3740: iload 14
    //   3742: istore 13
    //   3744: invokestatic 1561	com/tencent/mobileqq/msf/core/net/c/b:a	()Lcom/tencent/mobileqq/msf/core/net/c/b;
    //   3747: iconst_4
    //   3748: iload 7
    //   3750: aload_0
    //   3751: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3754: getfield 1202	com/tencent/mobileqq/msf/core/net/c/g$d:g	I
    //   3757: iload 5
    //   3759: aload_0
    //   3760: getfield 166	com/tencent/mobileqq/msf/core/net/c/g:a	Lcom/tencent/mobileqq/msf/core/net/c/g$a;
    //   3763: aload 20
    //   3765: getfield 605	com/tencent/msf/service/protocol/push/a/a:c	Ljava/lang/String;
    //   3768: aload 17
    //   3770: invokevirtual 1564	com/tencent/mobileqq/msf/core/net/c/b:a	(IIIILcom/tencent/mobileqq/msf/core/net/c/g$a;Ljava/lang/String;Ljava/lang/String;)V
    //   3773: aload_0
    //   3774: invokespecial 1441	com/tencent/mobileqq/msf/core/net/c/g:h	()V
    //   3777: iconst_0
    //   3778: istore 13
    //   3780: goto -840 -> 2940
    //   3783: iconst_0
    //   3784: istore_3
    //   3785: iload 14
    //   3787: istore 13
    //   3789: aload_0
    //   3790: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3793: getfield 290	com/tencent/msf/service/protocol/push/a/d:o	S
    //   3796: ifeq +18 -> 3814
    //   3799: iload 14
    //   3801: istore 13
    //   3803: iconst_1
    //   3804: aload_0
    //   3805: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3808: getfield 290	com/tencent/msf/service/protocol/push/a/d:o	S
    //   3811: if_icmpne +67 -> 3878
    //   3814: iload 14
    //   3816: istore 13
    //   3818: aload 16
    //   3820: arraylength
    //   3821: istore_3
    //   3822: iload 14
    //   3824: istore 13
    //   3826: aload_0
    //   3827: iload_3
    //   3828: aload 16
    //   3830: invokespecial 1429	com/tencent/mobileqq/msf/core/net/c/g:a	(I[B)Z
    //   3833: ifne +76 -> 3909
    //   3836: iconst_0
    //   3837: istore 13
    //   3839: invokestatic 1561	com/tencent/mobileqq/msf/core/net/c/b:a	()Lcom/tencent/mobileqq/msf/core/net/c/b;
    //   3842: iconst_5
    //   3843: iload 7
    //   3845: aload_0
    //   3846: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3849: getfield 1202	com/tencent/mobileqq/msf/core/net/c/g$d:g	I
    //   3852: iload 5
    //   3854: aload_0
    //   3855: getfield 166	com/tencent/mobileqq/msf/core/net/c/g:a	Lcom/tencent/mobileqq/msf/core/net/c/g$a;
    //   3858: aload 20
    //   3860: getfield 605	com/tencent/msf/service/protocol/push/a/a:c	Ljava/lang/String;
    //   3863: aload 17
    //   3865: invokevirtual 1564	com/tencent/mobileqq/msf/core/net/c/b:a	(IIIILcom/tencent/mobileqq/msf/core/net/c/g$a;Ljava/lang/String;Ljava/lang/String;)V
    //   3868: aload_0
    //   3869: invokespecial 1441	com/tencent/mobileqq/msf/core/net/c/g:h	()V
    //   3872: iconst_0
    //   3873: istore 13
    //   3875: goto -935 -> 2940
    //   3878: iload 14
    //   3880: istore 13
    //   3882: iconst_2
    //   3883: aload_0
    //   3884: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3887: getfield 290	com/tencent/msf/service/protocol/push/a/d:o	S
    //   3890: if_icmpne -68 -> 3822
    //   3893: iload 14
    //   3895: istore 13
    //   3897: aload_0
    //   3898: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3901: getfield 1499	com/tencent/msf/service/protocol/push/a/d:n	J
    //   3904: l2i
    //   3905: istore_3
    //   3906: goto -84 -> 3822
    //   3909: iload 14
    //   3911: istore 13
    //   3913: invokestatic 1561	com/tencent/mobileqq/msf/core/net/c/b:a	()Lcom/tencent/mobileqq/msf/core/net/c/b;
    //   3916: iconst_0
    //   3917: iload 7
    //   3919: aload_0
    //   3920: getfield 127	com/tencent/mobileqq/msf/core/net/c/g:p	Lcom/tencent/mobileqq/msf/core/net/c/g$d;
    //   3923: getfield 1202	com/tencent/mobileqq/msf/core/net/c/g$d:g	I
    //   3926: iload 5
    //   3928: aload_0
    //   3929: getfield 166	com/tencent/mobileqq/msf/core/net/c/g:a	Lcom/tencent/mobileqq/msf/core/net/c/g$a;
    //   3932: aload 20
    //   3934: getfield 605	com/tencent/msf/service/protocol/push/a/a:c	Ljava/lang/String;
    //   3937: aload 17
    //   3939: invokevirtual 1564	com/tencent/mobileqq/msf/core/net/c/b:a	(IIIILcom/tencent/mobileqq/msf/core/net/c/g$a;Ljava/lang/String;Ljava/lang/String;)V
    //   3942: aload_0
    //   3943: invokespecial 1441	com/tencent/mobileqq/msf/core/net/c/g:h	()V
    //   3946: iload 14
    //   3948: istore 13
    //   3950: goto -553 -> 3397
    //   3953: iload 4
    //   3955: aload_0
    //   3956: getfield 164	com/tencent/mobileqq/msf/core/net/c/g:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3959: getfield 1156	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   3962: invokevirtual 718	java/util/ArrayList:size	()I
    //   3965: iconst_1
    //   3966: isub
    //   3967: if_icmpne +229 -> 4196
    //   3970: iconst_1
    //   3971: istore 13
    //   3973: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3976: ifeq +30 -> 4006
    //   3979: ldc 240
    //   3981: iconst_2
    //   3982: new 242	java/lang/StringBuilder
    //   3985: dup
    //   3986: invokespecial 243	java/lang/StringBuilder:<init>	()V
    //   3989: ldc_w 1238
    //   3992: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3995: iload 14
    //   3997: invokevirtual 1241	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4000: invokevirtual 258	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4003: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4006: iload 14
    //   4008: ifeq +25 -> 4033
    //   4011: aload_0
    //   4012: getstatic 1245	com/tencent/mobileqq/msf/core/net/c/g$d$a:a	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   4015: iload 13
    //   4017: invokespecial 848	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;Z)V
    //   4020: iload 13
    //   4022: ifeq +153 -> 4175
    //   4025: aload_0
    //   4026: iconst_1
    //   4027: putfield 104	com/tencent/mobileqq/msf/core/net/c/g:f	Z
    //   4030: goto +145 -> 4175
    //   4033: aload_0
    //   4034: getstatic 1276	com/tencent/mobileqq/msf/core/net/c/g$d$a:b	Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;
    //   4037: iload 13
    //   4039: invokespecial 848	com/tencent/mobileqq/msf/core/net/c/g:b	(Lcom/tencent/mobileqq/msf/core/net/c/g$d$a;Z)V
    //   4042: goto -22 -> 4020
    //   4045: astore 18
    //   4047: aload 17
    //   4049: astore 16
    //   4051: aload 18
    //   4053: astore 17
    //   4055: goto -611 -> 3444
    //   4058: astore 17
    //   4060: aload 18
    //   4062: astore 16
    //   4064: goto -707 -> 3357
    //   4067: astore 16
    //   4069: iload_3
    //   4070: istore 4
    //   4072: iload_1
    //   4073: istore 5
    //   4075: iload_2
    //   4076: istore_3
    //   4077: iload 4
    //   4079: istore_1
    //   4080: iload 5
    //   4082: istore_2
    //   4083: goto -875 -> 3208
    //   4086: astore 16
    //   4088: iload_3
    //   4089: istore_1
    //   4090: iconst_1
    //   4091: istore 4
    //   4093: iload_2
    //   4094: istore_3
    //   4095: iload 4
    //   4097: istore_2
    //   4098: goto -890 -> 3208
    //   4101: astore 16
    //   4103: iconst_1
    //   4104: istore 4
    //   4106: iload_2
    //   4107: istore_3
    //   4108: iload 4
    //   4110: istore_2
    //   4111: goto -903 -> 3208
    //   4114: astore 16
    //   4116: iconst_m1
    //   4117: istore 4
    //   4119: iload_1
    //   4120: istore_2
    //   4121: iload 4
    //   4123: istore_1
    //   4124: goto -916 -> 3208
    //   4127: ldc 120
    //   4129: astore 17
    //   4131: goto -1295 -> 2836
    //   4134: goto -2743 -> 1391
    //   4137: iconst_1
    //   4138: istore 14
    //   4140: iload_1
    //   4141: istore_3
    //   4142: iconst_0
    //   4143: istore_2
    //   4144: iload 5
    //   4146: istore_1
    //   4147: iload_3
    //   4148: istore 4
    //   4150: iload_1
    //   4151: istore 5
    //   4153: iload_2
    //   4154: i2l
    //   4155: lload 9
    //   4157: lcmp
    //   4158: ifge -2265 -> 1893
    //   4161: iload_3
    //   4162: iconst_m1
    //   4163: if_icmpne -1826 -> 2337
    //   4166: iload_3
    //   4167: istore 4
    //   4169: iload_1
    //   4170: istore 5
    //   4172: goto -2279 -> 1893
    //   4175: iload 4
    //   4177: iconst_1
    //   4178: iadd
    //   4179: istore_1
    //   4180: goto -2632 -> 1548
    //   4183: iload 15
    //   4185: ifeq -517 -> 3668
    //   4188: aload 16
    //   4190: ifnonnull -512 -> 3678
    //   4193: goto -525 -> 3668
    //   4196: iconst_0
    //   4197: istore 13
    //   4199: goto -226 -> 3973
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4202	0	this	g
    //   1301	2879	1	i1	int
    //   1299	2855	2	i2	int
    //   1770	2397	3	i3	int
    //   1909	2270	4	i4	int
    //   1544	2627	5	i5	int
    //   1355	2179	6	i6	int
    //   2593	1325	7	i7	int
    //   2728	16	8	i8	int
    //   1863	2293	9	l1	long
    //   1857	1475	11	l2	long
    //   2485	1713	13	bool1	boolean
    //   2483	1656	14	bool2	boolean
    //   2821	1363	15	bool3	boolean
    //   257	400	16	localObject1	Object
    //   1519	9	16	localException1	Exception
    //   1535	6	16	localObject2	Object
    //   1854	26	16	localException2	Exception
    //   1918	1	16	localException3	Exception
    //   2297	1	16	localException4	Exception
    //   2614	276	16	localObject3	Object
    //   3198	23	16	localException5	Exception
    //   3350	1	16	localObject4	Object
    //   3375	14	16	localException6	Exception
    //   3410	19	16	localException7	Exception
    //   3462	7	16	localObject5	Object
    //   3552	511	16	localObject6	Object
    //   4067	1	16	localException8	Exception
    //   4086	1	16	localException9	Exception
    //   4101	1	16	localException10	Exception
    //   4114	75	16	localException11	Exception
    //   157	2735	17	localObject7	Object
    //   3355	13	17	localUnknownHostException1	UnknownHostException
    //   3442	606	17	localThrowable1	Throwable
    //   4053	1	17	localObject8	Object
    //   4058	1	17	localUnknownHostException2	UnknownHostException
    //   4129	1	17	str	String
    //   234	2581	18	localObject9	Object
    //   4045	16	18	localThrowable2	Throwable
    //   2754	595	19	localObject10	Object
    //   2573	1360	20	locala	com.tencent.msf.service.protocol.push.a.a
    //   2704	43	21	arrayOfInetAddress	InetAddress[]
    //   2750	48	22	localInetAddress	InetAddress
    // Exception table:
    //   from	to	target	type
    //   1302	1312	1519	java/lang/Exception
    //   1314	1334	1519	java/lang/Exception
    //   1334	1391	1519	java/lang/Exception
    //   1391	1428	1519	java/lang/Exception
    //   1433	1438	1519	java/lang/Exception
    //   1438	1496	1519	java/lang/Exception
    //   1496	1507	1519	java/lang/Exception
    //   1511	1516	1519	java/lang/Exception
    //   1548	1562	1519	java/lang/Exception
    //   1567	1709	1519	java/lang/Exception
    //   1749	1769	1519	java/lang/Exception
    //   1867	1884	1519	java/lang/Exception
    //   1893	1909	1519	java/lang/Exception
    //   1920	1935	1519	java/lang/Exception
    //   2936	2940	1519	java/lang/Exception
    //   3208	3225	1519	java/lang/Exception
    //   3393	3397	1519	java/lang/Exception
    //   3412	3439	1519	java/lang/Exception
    //   3464	3471	1519	java/lang/Exception
    //   3509	3513	1519	java/lang/Exception
    //   3658	3662	1519	java/lang/Exception
    //   3671	3675	1519	java/lang/Exception
    //   3773	3777	1519	java/lang/Exception
    //   3868	3872	1519	java/lang/Exception
    //   3942	3946	1519	java/lang/Exception
    //   3953	3970	1519	java/lang/Exception
    //   3973	4006	1519	java/lang/Exception
    //   4011	4020	1519	java/lang/Exception
    //   4025	4030	1519	java/lang/Exception
    //   4033	4042	1519	java/lang/Exception
    //   1302	1312	1535	finally
    //   1314	1334	1535	finally
    //   1334	1391	1535	finally
    //   1391	1428	1535	finally
    //   1433	1438	1535	finally
    //   1438	1496	1535	finally
    //   1496	1507	1535	finally
    //   1511	1516	1535	finally
    //   1521	1532	1535	finally
    //   1548	1562	1535	finally
    //   1567	1709	1535	finally
    //   1709	1749	1535	finally
    //   1749	1769	1535	finally
    //   1771	1777	1535	finally
    //   1779	1787	1535	finally
    //   1789	1801	1535	finally
    //   1803	1810	1535	finally
    //   1812	1818	1535	finally
    //   1820	1851	1535	finally
    //   1867	1884	1535	finally
    //   1893	1909	1535	finally
    //   1920	1935	1535	finally
    //   1940	1956	1535	finally
    //   1958	1966	1535	finally
    //   1968	1983	1535	finally
    //   1988	2004	1535	finally
    //   2009	2018	1535	finally
    //   2023	2029	1535	finally
    //   2031	2047	1535	finally
    //   2049	2057	1535	finally
    //   2059	2066	1535	finally
    //   2068	2074	1535	finally
    //   2076	2107	1535	finally
    //   2114	2119	1535	finally
    //   2121	2136	1535	finally
    //   2138	2144	1535	finally
    //   2146	2155	1535	finally
    //   2157	2168	1535	finally
    //   2175	2190	1535	finally
    //   2192	2204	1535	finally
    //   2206	2211	1535	finally
    //   2213	2221	1535	finally
    //   2223	2226	1535	finally
    //   2231	2240	1535	finally
    //   2251	2262	1535	finally
    //   2273	2288	1535	finally
    //   2304	2320	1535	finally
    //   2325	2334	1535	finally
    //   2337	2369	1535	finally
    //   2374	2385	1535	finally
    //   2389	2395	1535	finally
    //   2397	2426	1535	finally
    //   2435	2474	1535	finally
    //   2936	2940	1535	finally
    //   2958	2974	1535	finally
    //   2981	2990	1535	finally
    //   2997	3033	1535	finally
    //   3038	3049	1535	finally
    //   3053	3059	1535	finally
    //   3061	3090	1535	finally
    //   3101	3136	1535	finally
    //   3136	3147	1535	finally
    //   3152	3167	1535	finally
    //   3167	3195	1535	finally
    //   3208	3225	1535	finally
    //   3239	3248	1535	finally
    //   3259	3270	1535	finally
    //   3275	3290	1535	finally
    //   3299	3315	1535	finally
    //   3322	3331	1535	finally
    //   3393	3397	1535	finally
    //   3397	3407	1535	finally
    //   3412	3439	1535	finally
    //   3464	3471	1535	finally
    //   3509	3513	1535	finally
    //   3658	3662	1535	finally
    //   3671	3675	1535	finally
    //   3773	3777	1535	finally
    //   3868	3872	1535	finally
    //   3942	3946	1535	finally
    //   3953	3970	1535	finally
    //   3973	4006	1535	finally
    //   4011	4020	1535	finally
    //   4025	4030	1535	finally
    //   4033	4042	1535	finally
    //   1771	1777	1854	java/lang/Exception
    //   1779	1787	1854	java/lang/Exception
    //   1789	1801	1854	java/lang/Exception
    //   1803	1810	1854	java/lang/Exception
    //   1812	1818	1854	java/lang/Exception
    //   1820	1851	1854	java/lang/Exception
    //   1940	1956	1854	java/lang/Exception
    //   1958	1966	1854	java/lang/Exception
    //   1968	1983	1854	java/lang/Exception
    //   1988	2004	1854	java/lang/Exception
    //   2009	2018	1854	java/lang/Exception
    //   2023	2029	1854	java/lang/Exception
    //   2031	2047	1854	java/lang/Exception
    //   2049	2057	1854	java/lang/Exception
    //   2059	2066	1854	java/lang/Exception
    //   2068	2074	1854	java/lang/Exception
    //   2076	2107	1854	java/lang/Exception
    //   2114	2119	1854	java/lang/Exception
    //   2121	2136	1854	java/lang/Exception
    //   2138	2144	1854	java/lang/Exception
    //   2146	2155	1854	java/lang/Exception
    //   2157	2168	1854	java/lang/Exception
    //   2175	2190	1854	java/lang/Exception
    //   2192	2204	1854	java/lang/Exception
    //   2206	2211	1854	java/lang/Exception
    //   2213	2221	1854	java/lang/Exception
    //   2223	2226	1854	java/lang/Exception
    //   2231	2240	1854	java/lang/Exception
    //   2304	2320	1854	java/lang/Exception
    //   2325	2334	1854	java/lang/Exception
    //   1709	1749	1918	java/lang/Exception
    //   2251	2262	2297	java/lang/Exception
    //   2273	2288	2297	java/lang/Exception
    //   3101	3136	3198	java/lang/Exception
    //   3136	3147	3198	java/lang/Exception
    //   3152	3167	3198	java/lang/Exception
    //   3167	3195	3198	java/lang/Exception
    //   3239	3248	3198	java/lang/Exception
    //   2698	2706	3355	java/net/UnknownHostException
    //   2715	2721	3355	java/net/UnknownHostException
    //   2725	2730	3355	java/net/UnknownHostException
    //   2487	2492	3375	java/lang/Exception
    //   2496	2501	3375	java/lang/Exception
    //   2505	2510	3375	java/lang/Exception
    //   2514	2519	3375	java/lang/Exception
    //   2523	2528	3375	java/lang/Exception
    //   2532	2537	3375	java/lang/Exception
    //   2541	2546	3375	java/lang/Exception
    //   2550	2555	3375	java/lang/Exception
    //   2559	2575	3375	java/lang/Exception
    //   2579	2585	3375	java/lang/Exception
    //   2589	2595	3375	java/lang/Exception
    //   2599	2609	3375	java/lang/Exception
    //   2630	2641	3375	java/lang/Exception
    //   2645	2674	3375	java/lang/Exception
    //   2698	2706	3375	java/lang/Exception
    //   2715	2721	3375	java/lang/Exception
    //   2725	2730	3375	java/lang/Exception
    //   2777	2785	3375	java/lang/Exception
    //   2797	2804	3375	java/lang/Exception
    //   2816	2823	3375	java/lang/Exception
    //   2848	2856	3375	java/lang/Exception
    //   2860	2889	3375	java/lang/Exception
    //   2897	2910	3375	java/lang/Exception
    //   2914	2921	3375	java/lang/Exception
    //   2925	2933	3375	java/lang/Exception
    //   3361	3372	3375	java/lang/Exception
    //   3448	3459	3375	java/lang/Exception
    //   3487	3494	3375	java/lang/Exception
    //   3498	3506	3375	java/lang/Exception
    //   3520	3528	3375	java/lang/Exception
    //   3532	3554	3375	java/lang/Exception
    //   3558	3567	3375	java/lang/Exception
    //   3571	3577	3375	java/lang/Exception
    //   3581	3590	3375	java/lang/Exception
    //   3597	3614	3375	java/lang/Exception
    //   3618	3625	3375	java/lang/Exception
    //   3629	3658	3375	java/lang/Exception
    //   3682	3692	3375	java/lang/Exception
    //   3696	3703	3375	java/lang/Exception
    //   3707	3716	3375	java/lang/Exception
    //   3723	3740	3375	java/lang/Exception
    //   3744	3773	3375	java/lang/Exception
    //   3789	3799	3375	java/lang/Exception
    //   3803	3814	3375	java/lang/Exception
    //   3818	3822	3375	java/lang/Exception
    //   3826	3836	3375	java/lang/Exception
    //   3839	3868	3375	java/lang/Exception
    //   3882	3893	3375	java/lang/Exception
    //   3897	3906	3375	java/lang/Exception
    //   3913	3942	3375	java/lang/Exception
    //   3397	3407	3410	java/lang/Exception
    //   2698	2706	3442	java/lang/Throwable
    //   2715	2721	3442	java/lang/Throwable
    //   2725	2730	3442	java/lang/Throwable
    //   2487	2492	3462	finally
    //   2496	2501	3462	finally
    //   2505	2510	3462	finally
    //   2514	2519	3462	finally
    //   2523	2528	3462	finally
    //   2532	2537	3462	finally
    //   2541	2546	3462	finally
    //   2550	2555	3462	finally
    //   2559	2575	3462	finally
    //   2579	2585	3462	finally
    //   2589	2595	3462	finally
    //   2599	2609	3462	finally
    //   2630	2641	3462	finally
    //   2645	2674	3462	finally
    //   2698	2706	3462	finally
    //   2715	2721	3462	finally
    //   2725	2730	3462	finally
    //   2777	2785	3462	finally
    //   2797	2804	3462	finally
    //   2816	2823	3462	finally
    //   2848	2856	3462	finally
    //   2860	2889	3462	finally
    //   2897	2910	3462	finally
    //   2914	2921	3462	finally
    //   2925	2933	3462	finally
    //   3361	3372	3462	finally
    //   3377	3393	3462	finally
    //   3448	3459	3462	finally
    //   3487	3494	3462	finally
    //   3498	3506	3462	finally
    //   3520	3528	3462	finally
    //   3532	3554	3462	finally
    //   3558	3567	3462	finally
    //   3571	3577	3462	finally
    //   3581	3590	3462	finally
    //   3597	3614	3462	finally
    //   3618	3625	3462	finally
    //   3629	3658	3462	finally
    //   3682	3692	3462	finally
    //   3696	3703	3462	finally
    //   3707	3716	3462	finally
    //   3723	3740	3462	finally
    //   3744	3773	3462	finally
    //   3789	3799	3462	finally
    //   3803	3814	3462	finally
    //   3818	3822	3462	finally
    //   3826	3836	3462	finally
    //   3839	3868	3462	finally
    //   3882	3893	3462	finally
    //   3897	3906	3462	finally
    //   3913	3942	3462	finally
    //   2777	2785	4045	java/lang/Throwable
    //   2797	2804	4045	java/lang/Throwable
    //   2816	2823	4045	java/lang/Throwable
    //   2777	2785	4058	java/net/UnknownHostException
    //   2797	2804	4058	java/net/UnknownHostException
    //   2816	2823	4058	java/net/UnknownHostException
    //   2337	2369	4067	java/lang/Exception
    //   2435	2474	4067	java/lang/Exception
    //   2958	2974	4067	java/lang/Exception
    //   2981	2990	4067	java/lang/Exception
    //   2997	3033	4067	java/lang/Exception
    //   3299	3315	4067	java/lang/Exception
    //   3322	3331	4067	java/lang/Exception
    //   2374	2385	4086	java/lang/Exception
    //   3038	3049	4086	java/lang/Exception
    //   2389	2395	4101	java/lang/Exception
    //   2397	2426	4101	java/lang/Exception
    //   3053	3059	4101	java/lang/Exception
    //   3061	3090	4101	java/lang/Exception
    //   3259	3270	4114	java/lang/Exception
    //   3275	3290	4114	java/lang/Exception
  }
  
  public void run()
  {
    try
    {
      if (this.b == null) {
        break label74;
      }
      switch (j.a[this.a.ordinal()])
      {
      case 1: 
      case 2: 
      case 3: 
        c();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.QualityTestManager", 1, "QualityClient start failed, Exception :", localException);
      return;
    }
    i();
    return;
    label74:
    if (this.c != null)
    {
      m();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.g
 * JD-Core Version:    0.7.0.1
 */