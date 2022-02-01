package com.tencent.mobileqq.msf.core.net.c;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.msf.service.protocol.push.a.b;
import com.tencent.msf.service.protocol.push.a.e;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.g;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
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

public class c
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
  private static final int Q = 5;
  long A = 0L;
  long B = 0L;
  long C = 0L;
  long D = 0L;
  long E = 0L;
  private HostnameVerifier R = new d(this);
  private String S = "";
  private int T;
  private int U;
  private boolean V = true;
  c.b a;
  com.tencent.msf.service.protocol.push.a.d b;
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
  c.e p = new c.e();
  c.d q = new c.d();
  long r = 0L;
  long s = 0L;
  long t = 0L;
  long u = 0L;
  long v = 0L;
  long w = 0L;
  long x = 0L;
  long y = 0L;
  long z = 0L;
  
  public c(com.tencent.msf.service.protocol.push.a.d paramd, c.b paramb)
  {
    this.b = paramd;
    this.a = paramb;
    this.c = null;
    this.d = 1;
    this.e = 0;
  }
  
  public c(com.tencent.msf.service.protocol.push.a.d paramd, b paramb, c.b paramb1, int paramInt1, int paramInt2)
  {
    this.b = paramd;
    this.c = paramb;
    this.a = paramb1;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  private void a(c.e.a parama)
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
      a(c.e.a.y);
      return;
    }
    if (paramString.indexOf("timeout") > -1)
    {
      a(c.e.a.x);
      return;
    }
    a(c.e.a.e);
  }
  
  private boolean a(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (this.a == c.b.c)
    {
      if (paramInt == 0) {
        return true;
      }
      if (paramInt > 524288)
      {
        if (QLog.isDevelopLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("testdata too big ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" return http");
          QLog.d("MSF.C.QualityTestManager", 4, localStringBuilder.toString());
        }
        this.V = false;
        a(c.e.a.h);
        return false;
      }
      if (paramInt < 1)
      {
        if (QLog.isDevelopLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("qualityTestMsg sPkgData too short, http qualityTestMsg.sPkgData.length:");
          localStringBuilder.append(this.b.e.length);
          QLog.d("MSF.C.QualityTestManager", 4, localStringBuilder.toString());
        }
        a(c.e.a.i);
        return false;
      }
      return true;
    }
    if (paramInt > 524288)
    {
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("testdata too big ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" return not http");
        QLog.d("MSF.C.QualityTestManager", 4, localStringBuilder.toString());
      }
      this.V = false;
      a(c.e.a.h);
      return false;
    }
    if (paramInt < 1)
    {
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("qualityTestMsg sPkgData too short, not http qualityTestMsg.sPkgData.length:");
        localStringBuilder.append(this.b.e.length);
        QLog.d("MSF.C.QualityTestManager", 4, localStringBuilder.toString());
      }
      a(c.e.a.i);
      return false;
    }
    return true;
  }
  
  /* Error */
  private boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +61 -> 64
    //   6: new 241	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   13: astore 12
    //   15: aload 12
    //   17: ldc_w 287
    //   20: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 12
    //   26: iload_1
    //   27: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 12
    //   33: ldc_w 289
    //   36: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 12
    //   42: aload_0
    //   43: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   46: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   49: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc 255
    //   55: iconst_2
    //   56: aload 12
    //   58: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: iload_1
    //   65: ldc 233
    //   67: if_icmple +26 -> 93
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 134	com/tencent/mobileqq/msf/core/net/c/c:V	Z
    //   75: aload_0
    //   76: getstatic 293	com/tencent/mobileqq/msf/core/net/c/c$e$a:A	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   79: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/c:a	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;)V
    //   82: ldc 255
    //   84: iconst_1
    //   85: ldc_w 295
    //   88: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: iconst_0
    //   92: ireturn
    //   93: getstatic 300	com/tencent/mobileqq/msf/core/net/c/e:a	[I
    //   96: aload_0
    //   97: getfield 166	com/tencent/mobileqq/msf/core/net/c/c:a	Lcom/tencent/mobileqq/msf/core/net/c/c$b;
    //   100: invokevirtual 303	com/tencent/mobileqq/msf/core/net/c/c$b:ordinal	()I
    //   103: iaload
    //   104: istore_3
    //   105: iload_3
    //   106: iconst_1
    //   107: if_icmpeq +2918 -> 3025
    //   110: aconst_null
    //   111: astore 15
    //   113: aconst_null
    //   114: astore 12
    //   116: aconst_null
    //   117: astore 16
    //   119: aconst_null
    //   120: astore 17
    //   122: aconst_null
    //   123: astore 14
    //   125: aconst_null
    //   126: astore 13
    //   128: iload_3
    //   129: iconst_2
    //   130: if_icmpeq +1597 -> 1727
    //   133: iload_3
    //   134: iconst_3
    //   135: if_icmpeq +5 -> 140
    //   138: iconst_0
    //   139: ireturn
    //   140: aload_0
    //   141: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   144: aload_0
    //   145: getfield 305	com/tencent/mobileqq/msf/core/net/c/c:k	Ljava/net/HttpURLConnection;
    //   148: invokevirtual 310	java/net/HttpURLConnection:getResponseCode	()I
    //   151: putfield 312	com/tencent/mobileqq/msf/core/net/c/c$e:G	I
    //   154: aload_0
    //   155: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   158: aload_0
    //   159: getfield 305	com/tencent/mobileqq/msf/core/net/c/c:k	Ljava/net/HttpURLConnection;
    //   162: invokevirtual 315	java/net/HttpURLConnection:getContentLength	()I
    //   165: putfield 317	com/tencent/mobileqq/msf/core/net/c/c$e:H	I
    //   168: aload_0
    //   169: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   172: putfield 146	com/tencent/mobileqq/msf/core/net/c/c:w	J
    //   175: aload_0
    //   176: aload_0
    //   177: getfield 146	com/tencent/mobileqq/msf/core/net/c/c:w	J
    //   180: aload_0
    //   181: getfield 144	com/tencent/mobileqq/msf/core/net/c/c:v	J
    //   184: lsub
    //   185: putfield 154	com/tencent/mobileqq/msf/core/net/c/c:A	J
    //   188: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   191: istore 7
    //   193: iload 7
    //   195: ifeq +102 -> 297
    //   198: new 241	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   205: astore_2
    //   206: aload_2
    //   207: ldc_w 325
    //   210: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload_2
    //   215: aload_0
    //   216: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   219: getfield 312	com/tencent/mobileqq/msf/core/net/c/c$e:G	I
    //   222: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_2
    //   227: ldc_w 327
    //   230: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_2
    //   235: iload_1
    //   236: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_2
    //   241: ldc_w 329
    //   244: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_2
    //   249: aload_0
    //   250: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   253: getfield 317	com/tencent/mobileqq/msf/core/net/c/c$e:H	I
    //   256: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: ldc 255
    //   262: iconst_4
    //   263: aload_2
    //   264: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: goto +27 -> 297
    //   273: astore 12
    //   275: aload 13
    //   277: astore_2
    //   278: aload 12
    //   280: astore 13
    //   282: goto +1410 -> 1692
    //   285: astore 12
    //   287: aload 15
    //   289: astore_2
    //   290: aload 12
    //   292: astore 13
    //   294: goto +1252 -> 1546
    //   297: aload_0
    //   298: getfield 146	com/tencent/mobileqq/msf/core/net/c/c:w	J
    //   301: lstore 8
    //   303: aload_0
    //   304: lload 8
    //   306: putfield 148	com/tencent/mobileqq/msf/core/net/c/c:x	J
    //   309: aload_0
    //   310: lload 8
    //   312: putfield 150	com/tencent/mobileqq/msf/core/net/c/c:y	J
    //   315: new 331	java/io/BufferedInputStream
    //   318: dup
    //   319: aload_0
    //   320: getfield 305	com/tencent/mobileqq/msf/core/net/c/c:k	Ljava/net/HttpURLConnection;
    //   323: invokevirtual 335	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   326: invokespecial 338	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   329: astore_2
    //   330: getstatic 343	com/tencent/mobileqq/msf/core/net/c/k:f	Ljava/util/ArrayList;
    //   333: aload_2
    //   334: invokevirtual 344	java/lang/Object:toString	()Ljava/lang/String;
    //   337: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   340: pop
    //   341: sipush 1024
    //   344: newarray byte
    //   346: astore 12
    //   348: iload_1
    //   349: newarray byte
    //   351: astore 14
    //   353: iconst_0
    //   354: istore_3
    //   355: iload_3
    //   356: iload_1
    //   357: if_icmpge +176 -> 533
    //   360: aload_2
    //   361: aload 12
    //   363: invokevirtual 355	java/io/InputStream:read	([B)I
    //   366: istore 4
    //   368: iload 4
    //   370: iconst_m1
    //   371: if_icmpeq +162 -> 533
    //   374: iload 4
    //   376: iload_1
    //   377: if_icmple +16 -> 393
    //   380: aload 12
    //   382: iconst_0
    //   383: aload 14
    //   385: iload_3
    //   386: iload_1
    //   387: invokestatic 359	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   390: goto +37 -> 427
    //   393: iload 4
    //   395: iload_3
    //   396: iadd
    //   397: iload_1
    //   398: if_icmple +18 -> 416
    //   401: aload 12
    //   403: iconst_0
    //   404: aload 14
    //   406: iload_3
    //   407: iload_1
    //   408: iload_3
    //   409: isub
    //   410: invokestatic 359	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   413: goto +14 -> 427
    //   416: aload 12
    //   418: iconst_0
    //   419: aload 14
    //   421: iload_3
    //   422: iload 4
    //   424: invokestatic 359	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   427: iload_3
    //   428: iload 4
    //   430: iadd
    //   431: istore_3
    //   432: aload_0
    //   433: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   436: putfield 150	com/tencent/mobileqq/msf/core/net/c/c:y	J
    //   439: iload_3
    //   440: ldc_w 360
    //   443: if_icmple +77 -> 520
    //   446: getstatic 343	com/tencent/mobileqq/msf/core/net/c/k:f	Ljava/util/ArrayList;
    //   449: aload_2
    //   450: invokevirtual 344	java/lang/Object:toString	()Ljava/lang/String;
    //   453: invokevirtual 363	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   456: pop
    //   457: aload_0
    //   458: aload_0
    //   459: getfield 160	com/tencent/mobileqq/msf/core/net/c/c:D	J
    //   462: iload_3
    //   463: i2l
    //   464: ladd
    //   465: putfield 160	com/tencent/mobileqq/msf/core/net/c/c:D	J
    //   468: aload_0
    //   469: aload_0
    //   470: getfield 365	com/tencent/mobileqq/msf/core/net/c/c:U	I
    //   473: iload_3
    //   474: iadd
    //   475: putfield 365	com/tencent/mobileqq/msf/core/net/c/c:U	I
    //   478: aload_0
    //   479: iconst_0
    //   480: putfield 134	com/tencent/mobileqq/msf/core/net/c/c:V	Z
    //   483: aload_0
    //   484: getstatic 367	com/tencent/mobileqq/msf/core/net/c/c$e$a:u	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   487: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/c:a	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;)V
    //   490: aload_2
    //   491: invokevirtual 370	java/io/InputStream:close	()V
    //   494: goto +24 -> 518
    //   497: astore_2
    //   498: aload_2
    //   499: invokevirtual 373	java/lang/Throwable:printStackTrace	()V
    //   502: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   505: ifeq +13 -> 518
    //   508: ldc 255
    //   510: iconst_4
    //   511: ldc_w 375
    //   514: aload_2
    //   515: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   518: iconst_0
    //   519: ireturn
    //   520: goto -165 -> 355
    //   523: astore 12
    //   525: goto -247 -> 278
    //   528: astore 12
    //   530: goto -240 -> 290
    //   533: getstatic 343	com/tencent/mobileqq/msf/core/net/c/k:f	Ljava/util/ArrayList;
    //   536: aload_2
    //   537: invokevirtual 344	java/lang/Object:toString	()Ljava/lang/String;
    //   540: invokevirtual 363	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   543: pop
    //   544: aload_0
    //   545: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   548: aload_0
    //   549: getfield 144	com/tencent/mobileqq/msf/core/net/c/c:v	J
    //   552: putfield 380	com/tencent/mobileqq/msf/core/net/c/c$e:M	J
    //   555: aload_0
    //   556: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   559: aload_0
    //   560: getfield 150	com/tencent/mobileqq/msf/core/net/c/c:y	J
    //   563: putfield 382	com/tencent/mobileqq/msf/core/net/c/c$e:N	J
    //   566: aload_0
    //   567: getfield 150	com/tencent/mobileqq/msf/core/net/c/c:y	J
    //   570: lstore 8
    //   572: aload_0
    //   573: lload 8
    //   575: aload_0
    //   576: getfield 144	com/tencent/mobileqq/msf/core/net/c/c:v	J
    //   579: lsub
    //   580: putfield 162	com/tencent/mobileqq/msf/core/net/c/c:E	J
    //   583: aload_0
    //   584: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   587: getfield 384	com/tencent/mobileqq/msf/core/net/c/c$e:J	Ljava/util/ArrayList;
    //   590: aload_0
    //   591: getfield 162	com/tencent/mobileqq/msf/core/net/c/c:E	J
    //   594: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   597: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   600: pop
    //   601: aload_0
    //   602: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   605: astore 12
    //   607: aload 12
    //   609: getfield 391	com/tencent/mobileqq/msf/core/net/c/c$e:k	I
    //   612: istore 4
    //   614: iload 4
    //   616: i2l
    //   617: lstore 8
    //   619: aload 12
    //   621: lload 8
    //   623: aload_0
    //   624: getfield 162	com/tencent/mobileqq/msf/core/net/c/c:E	J
    //   627: ladd
    //   628: l2i
    //   629: putfield 391	com/tencent/mobileqq/msf/core/net/c/c$e:k	I
    //   632: aload_0
    //   633: getfield 158	com/tencent/mobileqq/msf/core/net/c/c:C	J
    //   636: lstore 8
    //   638: aload_0
    //   639: getfield 150	com/tencent/mobileqq/msf/core/net/c/c:y	J
    //   642: lstore 10
    //   644: aload_2
    //   645: astore 13
    //   647: aload 13
    //   649: astore 12
    //   651: aload_0
    //   652: lload 8
    //   654: lload 10
    //   656: aload_0
    //   657: getfield 148	com/tencent/mobileqq/msf/core/net/c/c:x	J
    //   660: lsub
    //   661: ladd
    //   662: putfield 158	com/tencent/mobileqq/msf/core/net/c/c:C	J
    //   665: aload 13
    //   667: astore 12
    //   669: aload_0
    //   670: aload_0
    //   671: getfield 160	com/tencent/mobileqq/msf/core/net/c/c:D	J
    //   674: iload_3
    //   675: i2l
    //   676: ladd
    //   677: putfield 160	com/tencent/mobileqq/msf/core/net/c/c:D	J
    //   680: aload 13
    //   682: astore 12
    //   684: aload_0
    //   685: aload_0
    //   686: getfield 365	com/tencent/mobileqq/msf/core/net/c/c:U	I
    //   689: iload_3
    //   690: iadd
    //   691: putfield 365	com/tencent/mobileqq/msf/core/net/c/c:U	I
    //   694: aload 13
    //   696: astore 12
    //   698: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   701: ifeq +129 -> 830
    //   704: aload 13
    //   706: astore 12
    //   708: new 241	java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   715: astore_2
    //   716: aload 13
    //   718: astore 12
    //   720: aload_2
    //   721: ldc_w 393
    //   724: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload 13
    //   730: astore 12
    //   732: aload_2
    //   733: aload_0
    //   734: getfield 162	com/tencent/mobileqq/msf/core/net/c/c:E	J
    //   737: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: aload 13
    //   743: astore 12
    //   745: aload_2
    //   746: ldc_w 398
    //   749: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: pop
    //   753: aload 13
    //   755: astore 12
    //   757: aload_2
    //   758: aload_0
    //   759: getfield 158	com/tencent/mobileqq/msf/core/net/c/c:C	J
    //   762: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: aload 13
    //   768: astore 12
    //   770: aload_2
    //   771: ldc_w 400
    //   774: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload 13
    //   780: astore 12
    //   782: aload_2
    //   783: aload_0
    //   784: getfield 160	com/tencent/mobileqq/msf/core/net/c/c:D	J
    //   787: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   790: pop
    //   791: aload 13
    //   793: astore 12
    //   795: aload_2
    //   796: ldc_w 402
    //   799: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: aload 13
    //   805: astore 12
    //   807: aload_2
    //   808: aload_0
    //   809: getfield 365	com/tencent/mobileqq/msf/core/net/c/c:U	I
    //   812: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   815: pop
    //   816: aload 13
    //   818: astore 12
    //   820: ldc 255
    //   822: iconst_4
    //   823: aload_2
    //   824: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   830: aload 13
    //   832: astore 12
    //   834: aload_0
    //   835: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   838: getfield 403	com/tencent/msf/service/protocol/push/a/d:x	J
    //   841: lconst_0
    //   842: lcmp
    //   843: ifle +208 -> 1051
    //   846: aload 13
    //   848: astore 12
    //   850: aload_0
    //   851: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   854: getfield 403	com/tencent/msf/service/protocol/push/a/d:x	J
    //   857: l2i
    //   858: istore 5
    //   860: aload 13
    //   862: astore 12
    //   864: aload_0
    //   865: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   868: getfield 404	com/tencent/msf/service/protocol/push/a/d:w	J
    //   871: l2i
    //   872: istore 6
    //   874: iload 5
    //   876: istore 4
    //   878: iload 5
    //   880: ldc_w 405
    //   883: if_icmple +8 -> 891
    //   886: ldc_w 405
    //   889: istore 4
    //   891: aload 13
    //   893: astore 12
    //   895: iload_3
    //   896: iload_1
    //   897: invokestatic 411	java/lang/Math:min	(II)I
    //   900: istore 5
    //   902: iload 6
    //   904: iload 5
    //   906: if_icmpge +145 -> 1051
    //   909: iload 4
    //   911: iload 6
    //   913: iadd
    //   914: iload 5
    //   916: if_icmple +56 -> 972
    //   919: aload 13
    //   921: astore 12
    //   923: aload_0
    //   924: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   927: astore_2
    //   928: iload 5
    //   930: iload 6
    //   932: isub
    //   933: istore 4
    //   935: aload 13
    //   937: astore 12
    //   939: aload_2
    //   940: new 219	java/lang/String
    //   943: dup
    //   944: aload 14
    //   946: iload 6
    //   948: iload 4
    //   950: invokespecial 414	java/lang/String:<init>	([BII)V
    //   953: putfield 416	com/tencent/mobileqq/msf/core/net/c/c$e:P	Ljava/lang/String;
    //   956: aload 13
    //   958: astore 12
    //   960: aload_0
    //   961: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   964: iload 4
    //   966: putfield 418	com/tencent/mobileqq/msf/core/net/c/c$e:O	I
    //   969: goto +40 -> 1009
    //   972: aload 13
    //   974: astore 12
    //   976: aload_0
    //   977: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   980: new 219	java/lang/String
    //   983: dup
    //   984: aload 14
    //   986: iload 6
    //   988: iload 4
    //   990: invokespecial 414	java/lang/String:<init>	([BII)V
    //   993: putfield 416	com/tencent/mobileqq/msf/core/net/c/c$e:P	Ljava/lang/String;
    //   996: aload 13
    //   998: astore 12
    //   1000: aload_0
    //   1001: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1004: iload 4
    //   1006: putfield 418	com/tencent/mobileqq/msf/core/net/c/c$e:O	I
    //   1009: aload 13
    //   1011: astore 12
    //   1013: aload_0
    //   1014: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1017: aload_0
    //   1018: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1021: getfield 416	com/tencent/mobileqq/msf/core/net/c/c$e:P	Ljava/lang/String;
    //   1024: invokestatic 423	com/tencent/qphone/base/util/g:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1027: putfield 416	com/tencent/mobileqq/msf/core/net/c/c$e:P	Ljava/lang/String;
    //   1030: aload 13
    //   1032: astore 12
    //   1034: aload_0
    //   1035: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1038: aload_0
    //   1039: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1042: getfield 416	com/tencent/mobileqq/msf/core/net/c/c$e:P	Ljava/lang/String;
    //   1045: invokevirtual 426	java/lang/String:length	()I
    //   1048: putfield 418	com/tencent/mobileqq/msf/core/net/c/c$e:O	I
    //   1051: aload 13
    //   1053: astore 12
    //   1055: new 219	java/lang/String
    //   1058: dup
    //   1059: aload 14
    //   1061: iconst_0
    //   1062: iload_3
    //   1063: aload 14
    //   1065: arraylength
    //   1066: invokestatic 411	java/lang/Math:min	(II)I
    //   1069: invokespecial 414	java/lang/String:<init>	([BII)V
    //   1072: astore_2
    //   1073: aload 13
    //   1075: astore 12
    //   1077: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1080: ifeq +55 -> 1135
    //   1083: aload 13
    //   1085: astore 12
    //   1087: new 241	java/lang/StringBuilder
    //   1090: dup
    //   1091: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1094: astore 14
    //   1096: aload 13
    //   1098: astore 12
    //   1100: aload 14
    //   1102: ldc_w 428
    //   1105: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: pop
    //   1109: aload 13
    //   1111: astore 12
    //   1113: aload 14
    //   1115: aload_2
    //   1116: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: pop
    //   1120: aload 13
    //   1122: astore 12
    //   1124: ldc 255
    //   1126: iconst_4
    //   1127: aload 14
    //   1129: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1132: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1135: aload 13
    //   1137: astore 12
    //   1139: aload_2
    //   1140: aload_0
    //   1141: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1144: getfield 430	com/tencent/msf/service/protocol/push/a/d:t	Ljava/lang/String;
    //   1147: invokevirtual 434	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1150: ifne +15 -> 1165
    //   1153: aload 13
    //   1155: astore 12
    //   1157: aload_0
    //   1158: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1161: iconst_1
    //   1162: putfield 436	com/tencent/mobileqq/msf/core/net/c/c$e:F	I
    //   1165: aload 13
    //   1167: astore 12
    //   1169: aload_0
    //   1170: aload_0
    //   1171: getfield 305	com/tencent/mobileqq/msf/core/net/c/c:k	Ljava/net/HttpURLConnection;
    //   1174: ldc_w 438
    //   1177: invokevirtual 441	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1180: invokespecial 443	com/tencent/mobileqq/msf/core/net/c/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1183: astore_2
    //   1184: aload_2
    //   1185: ifnull +88 -> 1273
    //   1188: aload 13
    //   1190: astore 12
    //   1192: aload_2
    //   1193: invokestatic 449	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   1196: astore 14
    //   1198: aload 13
    //   1200: astore 12
    //   1202: aload_0
    //   1203: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1206: aload 14
    //   1208: putfield 451	com/tencent/mobileqq/msf/core/net/c/c$e:d	Ljava/net/InetAddress;
    //   1211: aload 13
    //   1213: astore 12
    //   1215: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1218: ifeq +55 -> 1273
    //   1221: aload 13
    //   1223: astore 12
    //   1225: new 241	java/lang/StringBuilder
    //   1228: dup
    //   1229: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1232: astore 14
    //   1234: aload 13
    //   1236: astore 12
    //   1238: aload 14
    //   1240: ldc_w 453
    //   1243: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: pop
    //   1247: aload 13
    //   1249: astore 12
    //   1251: aload 14
    //   1253: aload_2
    //   1254: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: pop
    //   1258: aload 13
    //   1260: astore 12
    //   1262: ldc 255
    //   1264: iconst_4
    //   1265: aload 14
    //   1267: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1270: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1273: aload 13
    //   1275: astore 12
    //   1277: aload_0
    //   1278: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1281: astore_2
    //   1282: aload 13
    //   1284: astore 12
    //   1286: aload_2
    //   1287: aload_2
    //   1288: getfield 454	com/tencent/mobileqq/msf/core/net/c/c$e:m	I
    //   1291: iconst_1
    //   1292: iadd
    //   1293: putfield 454	com/tencent/mobileqq/msf/core/net/c/c$e:m	I
    //   1296: aload 13
    //   1298: astore 12
    //   1300: new 241	java/lang/StringBuilder
    //   1303: dup
    //   1304: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1307: astore_2
    //   1308: aload 13
    //   1310: astore 12
    //   1312: aload_2
    //   1313: ldc_w 456
    //   1316: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1319: pop
    //   1320: aload 13
    //   1322: astore 12
    //   1324: aload_2
    //   1325: iload_3
    //   1326: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1329: pop
    //   1330: aload 13
    //   1332: astore 12
    //   1334: aload_2
    //   1335: ldc_w 458
    //   1338: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1341: pop
    //   1342: aload 13
    //   1344: astore 12
    //   1346: aload_2
    //   1347: iload_1
    //   1348: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1351: pop
    //   1352: aload 13
    //   1354: astore 12
    //   1356: aload_2
    //   1357: ldc_w 460
    //   1360: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: pop
    //   1364: aload 13
    //   1366: astore 12
    //   1368: aload_2
    //   1369: aload_0
    //   1370: getfield 162	com/tencent/mobileqq/msf/core/net/c/c:E	J
    //   1373: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1376: pop
    //   1377: aload 13
    //   1379: astore 12
    //   1381: aload_2
    //   1382: ldc_w 462
    //   1385: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: pop
    //   1389: aload 13
    //   1391: astore 12
    //   1393: aload_2
    //   1394: aload_0
    //   1395: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1398: getfield 430	com/tencent/msf/service/protocol/push/a/d:t	Ljava/lang/String;
    //   1401: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1404: pop
    //   1405: aload 13
    //   1407: astore 12
    //   1409: ldc 255
    //   1411: iconst_1
    //   1412: aload_2
    //   1413: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1416: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1419: aload 13
    //   1421: invokevirtual 370	java/io/InputStream:close	()V
    //   1424: goto +2674 -> 4098
    //   1427: astore_2
    //   1428: aload_2
    //   1429: invokevirtual 373	java/lang/Throwable:printStackTrace	()V
    //   1432: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1435: ifeq +2663 -> 4098
    //   1438: ldc 255
    //   1440: iconst_4
    //   1441: ldc_w 375
    //   1444: aload_2
    //   1445: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1448: goto +2650 -> 4098
    //   1451: astore_2
    //   1452: aload 13
    //   1454: astore 12
    //   1456: goto +84 -> 1540
    //   1459: astore 13
    //   1461: aload_2
    //   1462: astore 12
    //   1464: aload 13
    //   1466: astore_2
    //   1467: goto +59 -> 1526
    //   1470: astore 13
    //   1472: aload_2
    //   1473: astore 12
    //   1475: aload 13
    //   1477: astore_2
    //   1478: goto +62 -> 1540
    //   1481: astore 13
    //   1483: aload_2
    //   1484: astore 12
    //   1486: aload 13
    //   1488: astore_2
    //   1489: goto +37 -> 1526
    //   1492: astore 13
    //   1494: aload_2
    //   1495: astore 12
    //   1497: aload 13
    //   1499: astore_2
    //   1500: goto +40 -> 1540
    //   1503: astore 13
    //   1505: aload_2
    //   1506: astore 12
    //   1508: aload 13
    //   1510: astore_2
    //   1511: goto +15 -> 1526
    //   1514: astore 13
    //   1516: aload_2
    //   1517: astore 12
    //   1519: aload 13
    //   1521: astore_2
    //   1522: goto +18 -> 1540
    //   1525: astore_2
    //   1526: aload_2
    //   1527: astore 13
    //   1529: aload 12
    //   1531: astore_2
    //   1532: goto +160 -> 1692
    //   1535: astore_2
    //   1536: aload 16
    //   1538: astore 12
    //   1540: aload_2
    //   1541: astore 13
    //   1543: aload 12
    //   1545: astore_2
    //   1546: aload_2
    //   1547: ifnull +17 -> 1564
    //   1550: aload_2
    //   1551: astore 12
    //   1553: getstatic 343	com/tencent/mobileqq/msf/core/net/c/k:f	Ljava/util/ArrayList;
    //   1556: aload_2
    //   1557: invokevirtual 344	java/lang/Object:toString	()Ljava/lang/String;
    //   1560: invokevirtual 363	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   1563: pop
    //   1564: aload_2
    //   1565: astore 12
    //   1567: aload_0
    //   1568: aload 13
    //   1570: invokevirtual 463	java/lang/Exception:toString	()Ljava/lang/String;
    //   1573: invokevirtual 466	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1576: invokespecial 468	com/tencent/mobileqq/msf/core/net/c/c:a	(Ljava/lang/String;)V
    //   1579: aload_2
    //   1580: astore 12
    //   1582: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1585: ifeq +17 -> 1602
    //   1588: aload_2
    //   1589: astore 12
    //   1591: ldc 255
    //   1593: iconst_4
    //   1594: ldc_w 470
    //   1597: aload 13
    //   1599: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1602: aload_2
    //   1603: astore 12
    //   1605: aload_0
    //   1606: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1609: astore 14
    //   1611: aload_2
    //   1612: astore 12
    //   1614: aload 14
    //   1616: aload 14
    //   1618: getfield 472	com/tencent/mobileqq/msf/core/net/c/c$e:n	I
    //   1621: iconst_1
    //   1622: iadd
    //   1623: putfield 472	com/tencent/mobileqq/msf/core/net/c/c$e:n	I
    //   1626: aload_2
    //   1627: astore 12
    //   1629: aload_0
    //   1630: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1633: getfield 384	com/tencent/mobileqq/msf/core/net/c/c$e:J	Ljava/util/ArrayList;
    //   1636: ldc2_w 473
    //   1639: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1642: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1645: pop
    //   1646: aload_2
    //   1647: astore 12
    //   1649: aload 13
    //   1651: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   1654: aload_2
    //   1655: ifnull +31 -> 1686
    //   1658: aload_2
    //   1659: invokevirtual 370	java/io/InputStream:close	()V
    //   1662: goto +24 -> 1686
    //   1665: astore_2
    //   1666: aload_2
    //   1667: invokevirtual 373	java/lang/Throwable:printStackTrace	()V
    //   1670: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1673: ifeq +13 -> 1686
    //   1676: ldc 255
    //   1678: iconst_4
    //   1679: ldc_w 375
    //   1682: aload_2
    //   1683: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1686: iconst_0
    //   1687: ireturn
    //   1688: astore_2
    //   1689: goto -163 -> 1526
    //   1692: aload_2
    //   1693: ifnull +31 -> 1724
    //   1696: aload_2
    //   1697: invokevirtual 370	java/io/InputStream:close	()V
    //   1700: goto +24 -> 1724
    //   1703: astore_2
    //   1704: aload_2
    //   1705: invokevirtual 373	java/lang/Throwable:printStackTrace	()V
    //   1708: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1711: ifeq +13 -> 1724
    //   1714: ldc 255
    //   1716: iconst_4
    //   1717: ldc_w 375
    //   1720: aload_2
    //   1721: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1724: aload 13
    //   1726: athrow
    //   1727: aload_0
    //   1728: getfield 108	com/tencent/mobileqq/msf/core/net/c/c:h	Ljava/net/Socket;
    //   1731: invokevirtual 478	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   1734: astore 13
    //   1736: getstatic 343	com/tencent/mobileqq/msf/core/net/c/k:f	Ljava/util/ArrayList;
    //   1739: aload 13
    //   1741: invokevirtual 344	java/lang/Object:toString	()Ljava/lang/String;
    //   1744: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1747: pop
    //   1748: iload_1
    //   1749: newarray byte
    //   1751: astore 12
    //   1753: aload 13
    //   1755: aload 12
    //   1757: invokevirtual 355	java/io/InputStream:read	([B)I
    //   1760: istore_3
    //   1761: aload_0
    //   1762: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   1765: putfield 146	com/tencent/mobileqq/msf/core/net/c/c:w	J
    //   1768: aload_0
    //   1769: getfield 154	com/tencent/mobileqq/msf/core/net/c/c:A	J
    //   1772: lstore 8
    //   1774: aload_0
    //   1775: getfield 146	com/tencent/mobileqq/msf/core/net/c/c:w	J
    //   1778: lstore 10
    //   1780: aload_0
    //   1781: lload 8
    //   1783: lload 10
    //   1785: aload_0
    //   1786: getfield 144	com/tencent/mobileqq/msf/core/net/c/c:v	J
    //   1789: lsub
    //   1790: ladd
    //   1791: putfield 154	com/tencent/mobileqq/msf/core/net/c/c:A	J
    //   1794: new 241	java/lang/StringBuilder
    //   1797: dup
    //   1798: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1801: astore 14
    //   1803: aload 14
    //   1805: ldc_w 480
    //   1808: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1811: pop
    //   1812: aload 14
    //   1814: aload_2
    //   1815: arraylength
    //   1816: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1819: pop
    //   1820: aload 14
    //   1822: ldc_w 482
    //   1825: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1828: pop
    //   1829: aload 14
    //   1831: aload_0
    //   1832: getfield 146	com/tencent/mobileqq/msf/core/net/c/c:w	J
    //   1835: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1838: pop
    //   1839: aload 14
    //   1841: ldc_w 484
    //   1844: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1847: pop
    //   1848: aload 14
    //   1850: aload_0
    //   1851: getfield 144	com/tencent/mobileqq/msf/core/net/c/c:v	J
    //   1854: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1857: pop
    //   1858: aload 14
    //   1860: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1863: astore 15
    //   1865: ldc 255
    //   1867: astore 14
    //   1869: aload 14
    //   1871: iconst_1
    //   1872: aload 15
    //   1874: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1877: aload_0
    //   1878: getfield 146	com/tencent/mobileqq/msf/core/net/c/c:w	J
    //   1881: lstore 8
    //   1883: aload_0
    //   1884: lload 8
    //   1886: putfield 148	com/tencent/mobileqq/msf/core/net/c/c:x	J
    //   1889: aload_0
    //   1890: lload 8
    //   1892: putfield 150	com/tencent/mobileqq/msf/core/net/c/c:y	J
    //   1895: iload_3
    //   1896: iconst_m1
    //   1897: if_icmpeq +2180 -> 4077
    //   1900: iload_3
    //   1901: istore 4
    //   1903: iload_3
    //   1904: iload_1
    //   1905: if_icmpge +2169 -> 4074
    //   1908: aload 13
    //   1910: aload 12
    //   1912: iload_3
    //   1913: iload_1
    //   1914: iload_3
    //   1915: isub
    //   1916: invokevirtual 487	java/io/InputStream:read	([BII)I
    //   1919: istore 4
    //   1921: iconst_m1
    //   1922: iload 4
    //   1924: if_icmpne +6 -> 1930
    //   1927: goto +18 -> 1945
    //   1930: iload_3
    //   1931: iload 4
    //   1933: iadd
    //   1934: istore_3
    //   1935: aload_0
    //   1936: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   1939: putfield 150	com/tencent/mobileqq/msf/core/net/c/c:y	J
    //   1942: goto -39 -> 1903
    //   1945: iconst_m1
    //   1946: iload 4
    //   1948: if_icmpne +148 -> 2096
    //   1951: aload 13
    //   1953: ifnull +15 -> 1968
    //   1956: getstatic 343	com/tencent/mobileqq/msf/core/net/c/k:f	Ljava/util/ArrayList;
    //   1959: aload 13
    //   1961: invokevirtual 344	java/lang/Object:toString	()Ljava/lang/String;
    //   1964: invokevirtual 363	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   1967: pop
    //   1968: aload_0
    //   1969: getstatic 227	com/tencent/mobileqq/msf/core/net/c/c$e$a:e	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   1972: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/c:a	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;)V
    //   1975: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1978: ifeq +49 -> 2027
    //   1981: new 241	java/lang/StringBuilder
    //   1984: dup
    //   1985: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1988: astore_2
    //   1989: aload_2
    //   1990: ldc_w 489
    //   1993: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1996: pop
    //   1997: aload_2
    //   1998: iload_3
    //   1999: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2002: pop
    //   2003: aload_2
    //   2004: ldc_w 327
    //   2007: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2010: pop
    //   2011: aload_2
    //   2012: iload_1
    //   2013: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2016: pop
    //   2017: aload 14
    //   2019: iconst_4
    //   2020: aload_2
    //   2021: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2024: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2027: aload_0
    //   2028: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   2031: getfield 384	com/tencent/mobileqq/msf/core/net/c/c$e:J	Ljava/util/ArrayList;
    //   2034: ldc2_w 473
    //   2037: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2040: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2043: pop
    //   2044: aload 13
    //   2046: ifnull +48 -> 2094
    //   2049: aload 14
    //   2051: astore 12
    //   2053: aload 13
    //   2055: invokevirtual 370	java/io/InputStream:close	()V
    //   2058: goto +36 -> 2094
    //   2061: astore_2
    //   2062: aload 14
    //   2064: astore 12
    //   2066: aload_2
    //   2067: invokevirtual 373	java/lang/Throwable:printStackTrace	()V
    //   2070: aload 14
    //   2072: astore 12
    //   2074: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2077: ifeq +17 -> 2094
    //   2080: aload 14
    //   2082: astore 12
    //   2084: aload 14
    //   2086: iconst_4
    //   2087: ldc_w 375
    //   2090: aload_2
    //   2091: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2094: iconst_0
    //   2095: ireturn
    //   2096: getstatic 343	com/tencent/mobileqq/msf/core/net/c/k:f	Ljava/util/ArrayList;
    //   2099: aload 13
    //   2101: invokevirtual 344	java/lang/Object:toString	()Ljava/lang/String;
    //   2104: invokevirtual 363	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   2107: pop
    //   2108: aload_0
    //   2109: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   2112: astore 15
    //   2114: aload 15
    //   2116: aload_0
    //   2117: getfield 144	com/tencent/mobileqq/msf/core/net/c/c:v	J
    //   2120: putfield 380	com/tencent/mobileqq/msf/core/net/c/c$e:M	J
    //   2123: aload_0
    //   2124: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   2127: aload_0
    //   2128: getfield 150	com/tencent/mobileqq/msf/core/net/c/c:y	J
    //   2131: putfield 382	com/tencent/mobileqq/msf/core/net/c/c$e:N	J
    //   2134: aload_0
    //   2135: aload_0
    //   2136: getfield 150	com/tencent/mobileqq/msf/core/net/c/c:y	J
    //   2139: aload_0
    //   2140: getfield 144	com/tencent/mobileqq/msf/core/net/c/c:v	J
    //   2143: lsub
    //   2144: putfield 162	com/tencent/mobileqq/msf/core/net/c/c:E	J
    //   2147: aload_0
    //   2148: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   2151: getfield 384	com/tencent/mobileqq/msf/core/net/c/c$e:J	Ljava/util/ArrayList;
    //   2154: aload_0
    //   2155: getfield 162	com/tencent/mobileqq/msf/core/net/c/c:E	J
    //   2158: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2161: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2164: pop
    //   2165: aload_0
    //   2166: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   2169: astore 15
    //   2171: aload 15
    //   2173: aload 15
    //   2175: getfield 391	com/tencent/mobileqq/msf/core/net/c/c$e:k	I
    //   2178: i2l
    //   2179: aload_0
    //   2180: getfield 162	com/tencent/mobileqq/msf/core/net/c/c:E	J
    //   2183: ladd
    //   2184: l2i
    //   2185: putfield 391	com/tencent/mobileqq/msf/core/net/c/c$e:k	I
    //   2188: aload_0
    //   2189: aload_0
    //   2190: getfield 158	com/tencent/mobileqq/msf/core/net/c/c:C	J
    //   2193: aload_0
    //   2194: getfield 150	com/tencent/mobileqq/msf/core/net/c/c:y	J
    //   2197: aload_0
    //   2198: getfield 148	com/tencent/mobileqq/msf/core/net/c/c:x	J
    //   2201: lsub
    //   2202: ladd
    //   2203: putfield 158	com/tencent/mobileqq/msf/core/net/c/c:C	J
    //   2206: aload_0
    //   2207: aload_0
    //   2208: getfield 160	com/tencent/mobileqq/msf/core/net/c/c:D	J
    //   2211: iload_1
    //   2212: i2l
    //   2213: ladd
    //   2214: putfield 160	com/tencent/mobileqq/msf/core/net/c/c:D	J
    //   2217: aload_0
    //   2218: aload_0
    //   2219: getfield 365	com/tencent/mobileqq/msf/core/net/c/c:U	I
    //   2222: iload_1
    //   2223: iadd
    //   2224: putfield 365	com/tencent/mobileqq/msf/core/net/c/c:U	I
    //   2227: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2230: ifeq +1859 -> 4089
    //   2233: new 241	java/lang/StringBuilder
    //   2236: dup
    //   2237: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   2240: astore 15
    //   2242: aload 15
    //   2244: ldc_w 491
    //   2247: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2250: pop
    //   2251: aload 15
    //   2253: iload_3
    //   2254: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2257: pop
    //   2258: aload 15
    //   2260: ldc_w 493
    //   2263: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2266: pop
    //   2267: aload 15
    //   2269: aload_0
    //   2270: getfield 162	com/tencent/mobileqq/msf/core/net/c/c:E	J
    //   2273: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2276: pop
    //   2277: aload 15
    //   2279: ldc_w 398
    //   2282: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2285: pop
    //   2286: aload 15
    //   2288: aload_0
    //   2289: getfield 158	com/tencent/mobileqq/msf/core/net/c/c:C	J
    //   2292: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2295: pop
    //   2296: aload 15
    //   2298: ldc_w 400
    //   2301: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2304: pop
    //   2305: aload 15
    //   2307: aload_0
    //   2308: getfield 160	com/tencent/mobileqq/msf/core/net/c/c:D	J
    //   2311: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2314: pop
    //   2315: aload 15
    //   2317: ldc_w 402
    //   2320: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2323: pop
    //   2324: aload 15
    //   2326: aload_0
    //   2327: getfield 365	com/tencent/mobileqq/msf/core/net/c/c:U	I
    //   2330: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2333: pop
    //   2334: aload 15
    //   2336: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2339: astore 15
    //   2341: aload 14
    //   2343: iconst_2
    //   2344: aload 15
    //   2346: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2349: goto +3 -> 2352
    //   2352: ldc 255
    //   2354: astore 14
    //   2356: aload_0
    //   2357: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2360: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   2363: ifeq +61 -> 2424
    //   2366: iconst_1
    //   2367: aload_0
    //   2368: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2371: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   2374: if_icmpne +6 -> 2380
    //   2377: goto +47 -> 2424
    //   2380: iconst_2
    //   2381: aload_0
    //   2382: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2385: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   2388: if_icmpne +1704 -> 4092
    //   2391: aload_0
    //   2392: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   2395: astore_2
    //   2396: aload_2
    //   2397: aload_2
    //   2398: getfield 454	com/tencent/mobileqq/msf/core/net/c/c$e:m	I
    //   2401: iconst_1
    //   2402: iadd
    //   2403: putfield 454	com/tencent/mobileqq/msf/core/net/c/c$e:m	I
    //   2406: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2409: ifeq +1683 -> 4092
    //   2412: ldc 255
    //   2414: iconst_2
    //   2415: ldc_w 495
    //   2418: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2421: goto +1671 -> 4092
    //   2424: aload_2
    //   2425: arraylength
    //   2426: bipush 8
    //   2428: isub
    //   2429: newarray byte
    //   2431: astore 15
    //   2433: aload_2
    //   2434: iconst_0
    //   2435: aload 15
    //   2437: iconst_0
    //   2438: aload 15
    //   2440: arraylength
    //   2441: invokestatic 359	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2444: iload_1
    //   2445: bipush 8
    //   2447: isub
    //   2448: newarray byte
    //   2450: astore_2
    //   2451: aload 12
    //   2453: iconst_0
    //   2454: aload_2
    //   2455: iconst_0
    //   2456: aload_2
    //   2457: arraylength
    //   2458: invokestatic 359	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2461: aload 15
    //   2463: invokestatic 501	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   2466: aload_2
    //   2467: invokestatic 501	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   2470: invokevirtual 504	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2473: ifeq +222 -> 2695
    //   2476: new 241	java/lang/StringBuilder
    //   2479: dup
    //   2480: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   2483: astore_2
    //   2484: aload_2
    //   2485: ldc_w 506
    //   2488: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2491: pop
    //   2492: aload_2
    //   2493: iload_1
    //   2494: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2497: pop
    //   2498: ldc 255
    //   2500: iconst_1
    //   2501: aload_2
    //   2502: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2505: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2508: aload_0
    //   2509: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   2512: astore_2
    //   2513: aload_2
    //   2514: aload_2
    //   2515: getfield 454	com/tencent/mobileqq/msf/core/net/c/c$e:m	I
    //   2518: iconst_1
    //   2519: iadd
    //   2520: putfield 454	com/tencent/mobileqq/msf/core/net/c/c$e:m	I
    //   2523: aload 12
    //   2525: arraylength
    //   2526: iconst_4
    //   2527: if_icmplt +115 -> 2642
    //   2530: aload 12
    //   2532: aload 12
    //   2534: arraylength
    //   2535: iconst_4
    //   2536: isub
    //   2537: invokestatic 511	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   2540: istore_3
    //   2541: iload_3
    //   2542: i2l
    //   2543: invokestatic 514	com/tencent/qphone/base/util/g:a	(J)Ljava/net/InetAddress;
    //   2546: astore_2
    //   2547: new 241	java/lang/StringBuilder
    //   2550: dup
    //   2551: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   2554: astore 12
    //   2556: aload 12
    //   2558: ldc_w 516
    //   2561: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2564: pop
    //   2565: aload 12
    //   2567: iload_1
    //   2568: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2571: pop
    //   2572: aload 12
    //   2574: ldc_w 518
    //   2577: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2580: pop
    //   2581: aload 12
    //   2583: aload_0
    //   2584: getfield 162	com/tencent/mobileqq/msf/core/net/c/c:E	J
    //   2587: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2590: pop
    //   2591: aload 12
    //   2593: ldc_w 520
    //   2596: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2599: pop
    //   2600: aload 12
    //   2602: aload_2
    //   2603: invokevirtual 523	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2606: pop
    //   2607: aload 12
    //   2609: ldc_w 525
    //   2612: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2615: pop
    //   2616: aload 12
    //   2618: iload_3
    //   2619: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2622: pop
    //   2623: ldc 255
    //   2625: iconst_1
    //   2626: aload 12
    //   2628: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2631: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2634: aload_0
    //   2635: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   2638: aload_2
    //   2639: putfield 451	com/tencent/mobileqq/msf/core/net/c/c$e:d	Ljava/net/InetAddress;
    //   2642: aload 13
    //   2644: ifnull +1454 -> 4098
    //   2647: aload 14
    //   2649: astore 12
    //   2651: aload 13
    //   2653: invokevirtual 370	java/io/InputStream:close	()V
    //   2656: goto +1442 -> 4098
    //   2659: astore_2
    //   2660: aload 14
    //   2662: astore 12
    //   2664: aload_2
    //   2665: invokevirtual 373	java/lang/Throwable:printStackTrace	()V
    //   2668: aload 14
    //   2670: astore 12
    //   2672: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2675: ifeq +1423 -> 4098
    //   2678: aload 14
    //   2680: astore 12
    //   2682: ldc 255
    //   2684: iconst_4
    //   2685: ldc_w 375
    //   2688: aload_2
    //   2689: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2692: goto +1406 -> 4098
    //   2695: aload_0
    //   2696: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   2699: getfield 384	com/tencent/mobileqq/msf/core/net/c/c$e:J	Ljava/util/ArrayList;
    //   2702: aload_0
    //   2703: getfield 162	com/tencent/mobileqq/msf/core/net/c/c:E	J
    //   2706: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2709: invokevirtual 363	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   2712: pop
    //   2713: new 241	java/lang/StringBuilder
    //   2716: dup
    //   2717: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   2720: astore 12
    //   2722: aload 12
    //   2724: ldc_w 527
    //   2727: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2730: pop
    //   2731: aload 12
    //   2733: aload_2
    //   2734: invokestatic 501	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   2737: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2740: pop
    //   2741: new 280	java/lang/Exception
    //   2744: dup
    //   2745: aload 12
    //   2747: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2750: invokespecial 529	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   2753: athrow
    //   2754: ldc 255
    //   2756: astore_2
    //   2757: astore 12
    //   2759: goto +32 -> 2791
    //   2762: ldc 255
    //   2764: astore_2
    //   2765: astore 12
    //   2767: goto +36 -> 2803
    //   2770: astore 12
    //   2772: ldc 255
    //   2774: astore_2
    //   2775: goto +16 -> 2791
    //   2778: astore 12
    //   2780: ldc 255
    //   2782: astore_2
    //   2783: goto +20 -> 2803
    //   2786: astore 12
    //   2788: ldc 255
    //   2790: astore_2
    //   2791: aload 12
    //   2793: astore 14
    //   2795: goto +176 -> 2971
    //   2798: astore 12
    //   2800: ldc 255
    //   2802: astore_2
    //   2803: goto +28 -> 2831
    //   2806: astore 12
    //   2808: ldc 255
    //   2810: astore_2
    //   2811: aload 17
    //   2813: astore 13
    //   2815: aload 12
    //   2817: astore 14
    //   2819: goto +152 -> 2971
    //   2822: astore 12
    //   2824: ldc 255
    //   2826: astore_2
    //   2827: aload 14
    //   2829: astore 13
    //   2831: aload 13
    //   2833: ifnull +15 -> 2848
    //   2836: getstatic 343	com/tencent/mobileqq/msf/core/net/c/k:f	Ljava/util/ArrayList;
    //   2839: aload 13
    //   2841: invokevirtual 344	java/lang/Object:toString	()Ljava/lang/String;
    //   2844: invokevirtual 363	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   2847: pop
    //   2848: aload_0
    //   2849: aload 12
    //   2851: invokevirtual 463	java/lang/Exception:toString	()Ljava/lang/String;
    //   2854: invokevirtual 466	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2857: invokespecial 468	com/tencent/mobileqq/msf/core/net/c/c:a	(Ljava/lang/String;)V
    //   2860: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2863: ifeq +13 -> 2876
    //   2866: aload_2
    //   2867: iconst_4
    //   2868: ldc_w 531
    //   2871: aload 12
    //   2873: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2876: aload_0
    //   2877: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   2880: astore 14
    //   2882: aload 14
    //   2884: aload 14
    //   2886: getfield 472	com/tencent/mobileqq/msf/core/net/c/c$e:n	I
    //   2889: iconst_1
    //   2890: iadd
    //   2891: putfield 472	com/tencent/mobileqq/msf/core/net/c/c$e:n	I
    //   2894: aload_0
    //   2895: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   2898: getfield 384	com/tencent/mobileqq/msf/core/net/c/c$e:J	Ljava/util/ArrayList;
    //   2901: ldc2_w 473
    //   2904: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2907: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2910: pop
    //   2911: aload 12
    //   2913: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   2916: aload 13
    //   2918: ifnull +46 -> 2964
    //   2921: aload_2
    //   2922: astore 12
    //   2924: aload 13
    //   2926: invokevirtual 370	java/io/InputStream:close	()V
    //   2929: goto +35 -> 2964
    //   2932: astore 13
    //   2934: aload_2
    //   2935: astore 12
    //   2937: aload 13
    //   2939: invokevirtual 373	java/lang/Throwable:printStackTrace	()V
    //   2942: aload_2
    //   2943: astore 12
    //   2945: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2948: ifeq +16 -> 2964
    //   2951: aload_2
    //   2952: astore 12
    //   2954: aload_2
    //   2955: iconst_4
    //   2956: ldc_w 375
    //   2959: aload 13
    //   2961: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2964: iconst_0
    //   2965: ireturn
    //   2966: astore 12
    //   2968: goto -153 -> 2815
    //   2971: aload 13
    //   2973: ifnull +46 -> 3019
    //   2976: aload_2
    //   2977: astore 12
    //   2979: aload 13
    //   2981: invokevirtual 370	java/io/InputStream:close	()V
    //   2984: goto +35 -> 3019
    //   2987: astore 13
    //   2989: aload_2
    //   2990: astore 12
    //   2992: aload 13
    //   2994: invokevirtual 373	java/lang/Throwable:printStackTrace	()V
    //   2997: aload_2
    //   2998: astore 12
    //   3000: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3003: ifeq +16 -> 3019
    //   3006: aload_2
    //   3007: astore 12
    //   3009: aload_2
    //   3010: iconst_4
    //   3011: ldc_w 375
    //   3014: aload 13
    //   3016: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3019: aload_2
    //   3020: astore 12
    //   3022: aload 14
    //   3024: athrow
    //   3025: ldc 255
    //   3027: astore 13
    //   3029: aload 13
    //   3031: astore 12
    //   3033: iload_1
    //   3034: newarray byte
    //   3036: astore 14
    //   3038: aload 13
    //   3040: astore 12
    //   3042: new 533	java/net/DatagramPacket
    //   3045: dup
    //   3046: aload 14
    //   3048: iload_1
    //   3049: invokespecial 536	java/net/DatagramPacket:<init>	([BI)V
    //   3052: astore 15
    //   3054: aload_0
    //   3055: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   3058: putfield 148	com/tencent/mobileqq/msf/core/net/c/c:x	J
    //   3061: aload_0
    //   3062: getfield 106	com/tencent/mobileqq/msf/core/net/c/c:g	Ljava/net/DatagramSocket;
    //   3065: aload 15
    //   3067: invokevirtual 542	java/net/DatagramSocket:receive	(Ljava/net/DatagramPacket;)V
    //   3070: aload_0
    //   3071: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   3074: putfield 150	com/tencent/mobileqq/msf/core/net/c/c:y	J
    //   3077: aload_0
    //   3078: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   3081: aload_0
    //   3082: getfield 144	com/tencent/mobileqq/msf/core/net/c/c:v	J
    //   3085: putfield 380	com/tencent/mobileqq/msf/core/net/c/c$e:M	J
    //   3088: aload_0
    //   3089: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   3092: aload_0
    //   3093: getfield 150	com/tencent/mobileqq/msf/core/net/c/c:y	J
    //   3096: putfield 382	com/tencent/mobileqq/msf/core/net/c/c$e:N	J
    //   3099: aload_0
    //   3100: aload_0
    //   3101: getfield 150	com/tencent/mobileqq/msf/core/net/c/c:y	J
    //   3104: aload_0
    //   3105: getfield 144	com/tencent/mobileqq/msf/core/net/c/c:v	J
    //   3108: lsub
    //   3109: putfield 162	com/tencent/mobileqq/msf/core/net/c/c:E	J
    //   3112: aload_0
    //   3113: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   3116: getfield 384	com/tencent/mobileqq/msf/core/net/c/c$e:J	Ljava/util/ArrayList;
    //   3119: aload_0
    //   3120: getfield 162	com/tencent/mobileqq/msf/core/net/c/c:E	J
    //   3123: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3126: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3129: pop
    //   3130: aload_0
    //   3131: getfield 158	com/tencent/mobileqq/msf/core/net/c/c:C	J
    //   3134: lstore 8
    //   3136: aload_0
    //   3137: getfield 150	com/tencent/mobileqq/msf/core/net/c/c:y	J
    //   3140: lstore 10
    //   3142: aload_0
    //   3143: lload 8
    //   3145: lload 10
    //   3147: aload_0
    //   3148: getfield 148	com/tencent/mobileqq/msf/core/net/c/c:x	J
    //   3151: lsub
    //   3152: ladd
    //   3153: putfield 158	com/tencent/mobileqq/msf/core/net/c/c:C	J
    //   3156: aload_0
    //   3157: aload_0
    //   3158: getfield 160	com/tencent/mobileqq/msf/core/net/c/c:D	J
    //   3161: aload 15
    //   3163: invokevirtual 545	java/net/DatagramPacket:getLength	()I
    //   3166: i2l
    //   3167: ladd
    //   3168: putfield 160	com/tencent/mobileqq/msf/core/net/c/c:D	J
    //   3171: aload_0
    //   3172: aload_0
    //   3173: getfield 365	com/tencent/mobileqq/msf/core/net/c/c:U	I
    //   3176: aload 15
    //   3178: invokevirtual 545	java/net/DatagramPacket:getLength	()I
    //   3181: iadd
    //   3182: putfield 365	com/tencent/mobileqq/msf/core/net/c/c:U	I
    //   3185: aload_0
    //   3186: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   3189: astore 12
    //   3191: aload 12
    //   3193: aload 12
    //   3195: getfield 391	com/tencent/mobileqq/msf/core/net/c/c$e:k	I
    //   3198: i2l
    //   3199: aload_0
    //   3200: getfield 162	com/tencent/mobileqq/msf/core/net/c/c:E	J
    //   3203: ladd
    //   3204: l2i
    //   3205: putfield 391	com/tencent/mobileqq/msf/core/net/c/c$e:k	I
    //   3208: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3211: ifeq +884 -> 4095
    //   3214: new 241	java/lang/StringBuilder
    //   3217: dup
    //   3218: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   3221: astore 12
    //   3223: aload 12
    //   3225: ldc_w 547
    //   3228: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3231: pop
    //   3232: aload 12
    //   3234: aload 15
    //   3236: invokevirtual 545	java/net/DatagramPacket:getLength	()I
    //   3239: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3242: pop
    //   3243: aload 12
    //   3245: ldc_w 493
    //   3248: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3251: pop
    //   3252: aload 12
    //   3254: aload_0
    //   3255: getfield 162	com/tencent/mobileqq/msf/core/net/c/c:E	J
    //   3258: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3261: pop
    //   3262: aload 12
    //   3264: ldc_w 398
    //   3267: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3270: pop
    //   3271: aload 12
    //   3273: aload_0
    //   3274: getfield 158	com/tencent/mobileqq/msf/core/net/c/c:C	J
    //   3277: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3280: pop
    //   3281: aload 12
    //   3283: ldc_w 400
    //   3286: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3289: pop
    //   3290: aload 12
    //   3292: aload_0
    //   3293: getfield 160	com/tencent/mobileqq/msf/core/net/c/c:D	J
    //   3296: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3299: pop
    //   3300: aload 12
    //   3302: ldc_w 402
    //   3305: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3308: pop
    //   3309: aload 12
    //   3311: aload_0
    //   3312: getfield 365	com/tencent/mobileqq/msf/core/net/c/c:U	I
    //   3315: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3318: pop
    //   3319: aload 12
    //   3321: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3324: astore 12
    //   3326: aload 13
    //   3328: iconst_2
    //   3329: aload 12
    //   3331: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3334: goto +3 -> 3337
    //   3337: aload_0
    //   3338: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3341: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   3344: ifeq +323 -> 3667
    //   3347: iconst_1
    //   3348: aload_0
    //   3349: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3352: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   3355: if_icmpne +6 -> 3361
    //   3358: goto +309 -> 3667
    //   3361: iconst_2
    //   3362: aload_0
    //   3363: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3366: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   3369: if_icmpne +397 -> 3766
    //   3372: aload 15
    //   3374: invokevirtual 551	java/net/DatagramPacket:getAddress	()Ljava/net/InetAddress;
    //   3377: aload_0
    //   3378: getfield 118	com/tencent/mobileqq/msf/core/net/c/c:n	Ljava/net/InetAddress;
    //   3381: invokevirtual 552	java/net/InetAddress:equals	(Ljava/lang/Object;)Z
    //   3384: istore 7
    //   3386: iload 7
    //   3388: ifeq +153 -> 3541
    //   3391: aload 15
    //   3393: invokevirtual 555	java/net/DatagramPacket:getPort	()I
    //   3396: aload_0
    //   3397: getfield 557	com/tencent/mobileqq/msf/core/net/c/c:o	I
    //   3400: if_icmpeq +6 -> 3406
    //   3403: goto +138 -> 3541
    //   3406: new 241	java/lang/StringBuilder
    //   3409: dup
    //   3410: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   3413: astore_2
    //   3414: aload_2
    //   3415: ldc_w 559
    //   3418: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3421: pop
    //   3422: aload_2
    //   3423: aload_0
    //   3424: getfield 118	com/tencent/mobileqq/msf/core/net/c/c:n	Ljava/net/InetAddress;
    //   3427: invokevirtual 560	java/net/InetAddress:toString	()Ljava/lang/String;
    //   3430: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3433: pop
    //   3434: aload_2
    //   3435: ldc_w 562
    //   3438: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3441: pop
    //   3442: aload_2
    //   3443: aload_0
    //   3444: getfield 557	com/tencent/mobileqq/msf/core/net/c/c:o	I
    //   3447: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3450: pop
    //   3451: aload_2
    //   3452: ldc_w 564
    //   3455: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3458: pop
    //   3459: aload_2
    //   3460: aload 15
    //   3462: invokevirtual 551	java/net/DatagramPacket:getAddress	()Ljava/net/InetAddress;
    //   3465: invokevirtual 560	java/net/InetAddress:toString	()Ljava/lang/String;
    //   3468: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3471: pop
    //   3472: aload_2
    //   3473: ldc_w 562
    //   3476: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3479: pop
    //   3480: aload_2
    //   3481: aload 15
    //   3483: invokevirtual 555	java/net/DatagramPacket:getPort	()I
    //   3486: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3489: pop
    //   3490: aload_2
    //   3491: ldc_w 566
    //   3494: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3497: pop
    //   3498: ldc 255
    //   3500: iconst_2
    //   3501: aload_2
    //   3502: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3505: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3508: aload_0
    //   3509: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   3512: astore_2
    //   3513: aload_2
    //   3514: aload_2
    //   3515: getfield 454	com/tencent/mobileqq/msf/core/net/c/c$e:m	I
    //   3518: iconst_1
    //   3519: iadd
    //   3520: putfield 454	com/tencent/mobileqq/msf/core/net/c/c$e:m	I
    //   3523: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3526: ifeq +240 -> 3766
    //   3529: ldc 255
    //   3531: iconst_2
    //   3532: ldc_w 568
    //   3535: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3538: goto +228 -> 3766
    //   3541: aload_0
    //   3542: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   3545: astore_2
    //   3546: aload_2
    //   3547: aload_2
    //   3548: getfield 454	com/tencent/mobileqq/msf/core/net/c/c$e:m	I
    //   3551: iconst_1
    //   3552: iadd
    //   3553: putfield 454	com/tencent/mobileqq/msf/core/net/c/c$e:m	I
    //   3556: aload_0
    //   3557: getstatic 570	com/tencent/mobileqq/msf/core/net/c/c$e$a:v	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   3560: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/c:a	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;)V
    //   3563: new 241	java/lang/StringBuilder
    //   3566: dup
    //   3567: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   3570: astore_2
    //   3571: aload_2
    //   3572: ldc_w 572
    //   3575: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3578: pop
    //   3579: aload_2
    //   3580: aload_0
    //   3581: getfield 118	com/tencent/mobileqq/msf/core/net/c/c:n	Ljava/net/InetAddress;
    //   3584: invokevirtual 560	java/net/InetAddress:toString	()Ljava/lang/String;
    //   3587: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3590: pop
    //   3591: aload_2
    //   3592: ldc_w 562
    //   3595: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3598: pop
    //   3599: aload_2
    //   3600: aload_0
    //   3601: getfield 557	com/tencent/mobileqq/msf/core/net/c/c:o	I
    //   3604: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3607: pop
    //   3608: aload_2
    //   3609: ldc_w 564
    //   3612: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3615: pop
    //   3616: aload_2
    //   3617: aload 15
    //   3619: invokevirtual 551	java/net/DatagramPacket:getAddress	()Ljava/net/InetAddress;
    //   3622: invokevirtual 560	java/net/InetAddress:toString	()Ljava/lang/String;
    //   3625: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3628: pop
    //   3629: aload_2
    //   3630: ldc_w 562
    //   3633: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3636: pop
    //   3637: aload_2
    //   3638: aload 15
    //   3640: invokevirtual 555	java/net/DatagramPacket:getPort	()I
    //   3643: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3646: pop
    //   3647: aload_2
    //   3648: ldc_w 566
    //   3651: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3654: pop
    //   3655: ldc 255
    //   3657: iconst_2
    //   3658: aload_2
    //   3659: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3662: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3665: iconst_0
    //   3666: ireturn
    //   3667: aload_2
    //   3668: arraylength
    //   3669: bipush 8
    //   3671: isub
    //   3672: newarray byte
    //   3674: astore 12
    //   3676: aload_2
    //   3677: iconst_0
    //   3678: aload 12
    //   3680: iconst_0
    //   3681: aload 12
    //   3683: arraylength
    //   3684: invokestatic 359	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3687: iload_1
    //   3688: bipush 8
    //   3690: isub
    //   3691: newarray byte
    //   3693: astore_2
    //   3694: aload 14
    //   3696: iconst_0
    //   3697: aload_2
    //   3698: iconst_0
    //   3699: aload_2
    //   3700: arraylength
    //   3701: invokestatic 359	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3704: aload 12
    //   3706: invokestatic 501	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   3709: aload_2
    //   3710: invokestatic 501	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   3713: invokevirtual 504	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3716: ifeq +160 -> 3876
    //   3719: new 241	java/lang/StringBuilder
    //   3722: dup
    //   3723: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   3726: astore_2
    //   3727: aload_2
    //   3728: ldc_w 574
    //   3731: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3734: pop
    //   3735: aload_2
    //   3736: iload_1
    //   3737: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3740: pop
    //   3741: ldc 255
    //   3743: iconst_1
    //   3744: aload_2
    //   3745: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3748: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3751: aload_0
    //   3752: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   3755: astore_2
    //   3756: aload_2
    //   3757: aload_2
    //   3758: getfield 454	com/tencent/mobileqq/msf/core/net/c/c$e:m	I
    //   3761: iconst_1
    //   3762: iadd
    //   3763: putfield 454	com/tencent/mobileqq/msf/core/net/c/c$e:m	I
    //   3766: aload 14
    //   3768: arraylength
    //   3769: iconst_4
    //   3770: if_icmplt +328 -> 4098
    //   3773: aload 14
    //   3775: iconst_0
    //   3776: invokestatic 511	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   3779: istore_1
    //   3780: aload 14
    //   3782: aload 14
    //   3784: arraylength
    //   3785: iconst_4
    //   3786: isub
    //   3787: invokestatic 511	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   3790: istore_3
    //   3791: iload_3
    //   3792: i2l
    //   3793: invokestatic 514	com/tencent/qphone/base/util/g:a	(J)Ljava/net/InetAddress;
    //   3796: astore_2
    //   3797: new 241	java/lang/StringBuilder
    //   3800: dup
    //   3801: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   3804: astore 12
    //   3806: aload 12
    //   3808: ldc_w 576
    //   3811: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3814: pop
    //   3815: aload 12
    //   3817: iload_1
    //   3818: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3821: pop
    //   3822: aload 12
    //   3824: ldc_w 520
    //   3827: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3830: pop
    //   3831: aload 12
    //   3833: aload_2
    //   3834: invokevirtual 523	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3837: pop
    //   3838: aload 12
    //   3840: ldc_w 525
    //   3843: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3846: pop
    //   3847: aload 12
    //   3849: iload_3
    //   3850: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3853: pop
    //   3854: ldc 255
    //   3856: iconst_1
    //   3857: aload 12
    //   3859: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3862: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3865: aload_0
    //   3866: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   3869: aload_2
    //   3870: putfield 451	com/tencent/mobileqq/msf/core/net/c/c$e:d	Ljava/net/InetAddress;
    //   3873: goto +225 -> 4098
    //   3876: aload_0
    //   3877: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   3880: getfield 384	com/tencent/mobileqq/msf/core/net/c/c$e:J	Ljava/util/ArrayList;
    //   3883: aload_0
    //   3884: getfield 162	com/tencent/mobileqq/msf/core/net/c/c:E	J
    //   3887: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3890: invokevirtual 363	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   3893: pop
    //   3894: new 241	java/lang/StringBuilder
    //   3897: dup
    //   3898: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   3901: astore 12
    //   3903: aload 12
    //   3905: ldc_w 527
    //   3908: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3911: pop
    //   3912: aload 12
    //   3914: aload_2
    //   3915: invokestatic 501	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   3918: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3921: pop
    //   3922: new 280	java/lang/Exception
    //   3925: dup
    //   3926: aload 12
    //   3928: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3931: invokespecial 529	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   3934: athrow
    //   3935: astore_2
    //   3936: goto +4 -> 3940
    //   3939: astore_2
    //   3940: ldc 255
    //   3942: astore 13
    //   3944: aload 13
    //   3946: astore 12
    //   3948: aload_0
    //   3949: aload_2
    //   3950: invokevirtual 463	java/lang/Exception:toString	()Ljava/lang/String;
    //   3953: invokevirtual 466	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   3956: invokespecial 468	com/tencent/mobileqq/msf/core/net/c/c:a	(Ljava/lang/String;)V
    //   3959: aload 13
    //   3961: astore 12
    //   3963: ldc 255
    //   3965: iconst_1
    //   3966: ldc_w 578
    //   3969: aload_2
    //   3970: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3973: aload 13
    //   3975: astore 12
    //   3977: aload_0
    //   3978: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   3981: astore_2
    //   3982: aload 13
    //   3984: astore 12
    //   3986: aload_2
    //   3987: aload_2
    //   3988: getfield 472	com/tencent/mobileqq/msf/core/net/c/c$e:n	I
    //   3991: iconst_1
    //   3992: iadd
    //   3993: putfield 472	com/tencent/mobileqq/msf/core/net/c/c$e:n	I
    //   3996: aload 13
    //   3998: astore 12
    //   4000: aload_0
    //   4001: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   4004: getfield 384	com/tencent/mobileqq/msf/core/net/c/c$e:J	Ljava/util/ArrayList;
    //   4007: ldc2_w 473
    //   4010: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4013: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4016: pop
    //   4017: iconst_0
    //   4018: ireturn
    //   4019: ldc 255
    //   4021: astore 12
    //   4023: aload_0
    //   4024: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   4027: astore_2
    //   4028: aload_2
    //   4029: aload_2
    //   4030: getfield 472	com/tencent/mobileqq/msf/core/net/c/c$e:n	I
    //   4033: iconst_1
    //   4034: iadd
    //   4035: putfield 472	com/tencent/mobileqq/msf/core/net/c/c$e:n	I
    //   4038: aload_0
    //   4039: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   4042: getfield 384	com/tencent/mobileqq/msf/core/net/c/c$e:J	Ljava/util/ArrayList;
    //   4045: ldc2_w 473
    //   4048: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4051: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4054: pop
    //   4055: aload 12
    //   4057: iconst_1
    //   4058: ldc_w 580
    //   4061: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4064: iconst_0
    //   4065: ireturn
    //   4066: astore_2
    //   4067: goto -48 -> 4019
    //   4070: astore_2
    //   4071: goto -48 -> 4023
    //   4074: goto -2129 -> 1945
    //   4077: iconst_0
    //   4078: istore 5
    //   4080: iload_3
    //   4081: istore 4
    //   4083: iload 5
    //   4085: istore_3
    //   4086: goto -2141 -> 1945
    //   4089: goto -1737 -> 2352
    //   4092: goto -1569 -> 2523
    //   4095: goto -758 -> 3337
    //   4098: iconst_1
    //   4099: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4100	0	this	c
    //   0	4100	1	paramInt	int
    //   0	4100	2	paramArrayOfByte	byte[]
    //   104	3982	3	i1	int
    //   366	3716	4	i2	int
    //   858	3226	5	i3	int
    //   872	115	6	i4	int
    //   191	3196	7	bool	boolean
    //   301	2843	8	l1	long
    //   642	2504	10	l2	long
    //   13	102	12	localStringBuilder	StringBuilder
    //   273	6	12	localObject1	Object
    //   285	6	12	localException1	Exception
    //   346	71	12	arrayOfByte1	byte[]
    //   523	1	12	localObject2	Object
    //   528	1	12	localException2	Exception
    //   605	2141	12	localObject3	Object
    //   2757	1	12	localObject4	Object
    //   2765	1	12	localException3	Exception
    //   2770	1	12	localObject5	Object
    //   2778	1	12	localException4	Exception
    //   2786	6	12	localObject6	Object
    //   2798	1	12	localException5	Exception
    //   2806	10	12	localObject7	Object
    //   2822	90	12	localException6	Exception
    //   2922	31	12	arrayOfByte2	byte[]
    //   2966	1	12	localObject8	Object
    //   2977	1079	12	localObject9	Object
    //   126	1327	13	localObject10	Object
    //   1459	6	13	localObject11	Object
    //   1470	6	13	localException7	Exception
    //   1481	6	13	localObject12	Object
    //   1492	6	13	localException8	Exception
    //   1503	6	13	localObject13	Object
    //   1514	6	13	localException9	Exception
    //   1527	1398	13	localObject14	Object
    //   2932	48	13	localThrowable1	Throwable
    //   2987	28	13	localThrowable2	Throwable
    //   3027	970	13	str	String
    //   123	3660	14	localObject15	Object
    //   111	3528	15	localObject16	Object
    //   117	1420	16	localObject17	Object
    //   120	2692	17	localObject18	Object
    // Exception table:
    //   from	to	target	type
    //   198	270	273	finally
    //   198	270	285	java/lang/Exception
    //   490	494	497	java/lang/Throwable
    //   360	368	523	finally
    //   380	390	523	finally
    //   401	413	523	finally
    //   416	427	523	finally
    //   432	439	523	finally
    //   446	490	523	finally
    //   360	368	528	java/lang/Exception
    //   380	390	528	java/lang/Exception
    //   401	413	528	java/lang/Exception
    //   416	427	528	java/lang/Exception
    //   432	439	528	java/lang/Exception
    //   446	490	528	java/lang/Exception
    //   1419	1424	1427	java/lang/Throwable
    //   651	665	1451	java/lang/Exception
    //   669	680	1451	java/lang/Exception
    //   684	694	1451	java/lang/Exception
    //   698	704	1451	java/lang/Exception
    //   708	716	1451	java/lang/Exception
    //   720	728	1451	java/lang/Exception
    //   732	741	1451	java/lang/Exception
    //   745	753	1451	java/lang/Exception
    //   757	766	1451	java/lang/Exception
    //   770	778	1451	java/lang/Exception
    //   782	791	1451	java/lang/Exception
    //   795	803	1451	java/lang/Exception
    //   807	816	1451	java/lang/Exception
    //   820	830	1451	java/lang/Exception
    //   834	846	1451	java/lang/Exception
    //   850	860	1451	java/lang/Exception
    //   864	874	1451	java/lang/Exception
    //   895	902	1451	java/lang/Exception
    //   923	928	1451	java/lang/Exception
    //   939	956	1451	java/lang/Exception
    //   960	969	1451	java/lang/Exception
    //   976	996	1451	java/lang/Exception
    //   1000	1009	1451	java/lang/Exception
    //   1013	1030	1451	java/lang/Exception
    //   1034	1051	1451	java/lang/Exception
    //   1055	1073	1451	java/lang/Exception
    //   1077	1083	1451	java/lang/Exception
    //   1087	1096	1451	java/lang/Exception
    //   1100	1109	1451	java/lang/Exception
    //   1113	1120	1451	java/lang/Exception
    //   1124	1135	1451	java/lang/Exception
    //   1139	1153	1451	java/lang/Exception
    //   1157	1165	1451	java/lang/Exception
    //   1169	1184	1451	java/lang/Exception
    //   1192	1198	1451	java/lang/Exception
    //   1202	1211	1451	java/lang/Exception
    //   1215	1221	1451	java/lang/Exception
    //   1225	1234	1451	java/lang/Exception
    //   1238	1247	1451	java/lang/Exception
    //   1251	1258	1451	java/lang/Exception
    //   1262	1273	1451	java/lang/Exception
    //   1277	1282	1451	java/lang/Exception
    //   1286	1296	1451	java/lang/Exception
    //   1300	1308	1451	java/lang/Exception
    //   1312	1320	1451	java/lang/Exception
    //   1324	1330	1451	java/lang/Exception
    //   1334	1342	1451	java/lang/Exception
    //   1346	1352	1451	java/lang/Exception
    //   1356	1364	1451	java/lang/Exception
    //   1368	1377	1451	java/lang/Exception
    //   1381	1389	1451	java/lang/Exception
    //   1393	1405	1451	java/lang/Exception
    //   1409	1419	1451	java/lang/Exception
    //   619	644	1459	finally
    //   619	644	1470	java/lang/Exception
    //   572	614	1481	finally
    //   572	614	1492	java/lang/Exception
    //   330	353	1503	finally
    //   533	572	1503	finally
    //   330	353	1514	java/lang/Exception
    //   533	572	1514	java/lang/Exception
    //   140	193	1525	finally
    //   297	330	1525	finally
    //   140	193	1535	java/lang/Exception
    //   297	330	1535	java/lang/Exception
    //   1658	1662	1665	java/lang/Throwable
    //   651	665	1688	finally
    //   669	680	1688	finally
    //   684	694	1688	finally
    //   698	704	1688	finally
    //   708	716	1688	finally
    //   720	728	1688	finally
    //   732	741	1688	finally
    //   745	753	1688	finally
    //   757	766	1688	finally
    //   770	778	1688	finally
    //   782	791	1688	finally
    //   795	803	1688	finally
    //   807	816	1688	finally
    //   820	830	1688	finally
    //   834	846	1688	finally
    //   850	860	1688	finally
    //   864	874	1688	finally
    //   895	902	1688	finally
    //   923	928	1688	finally
    //   939	956	1688	finally
    //   960	969	1688	finally
    //   976	996	1688	finally
    //   1000	1009	1688	finally
    //   1013	1030	1688	finally
    //   1034	1051	1688	finally
    //   1055	1073	1688	finally
    //   1077	1083	1688	finally
    //   1087	1096	1688	finally
    //   1100	1109	1688	finally
    //   1113	1120	1688	finally
    //   1124	1135	1688	finally
    //   1139	1153	1688	finally
    //   1157	1165	1688	finally
    //   1169	1184	1688	finally
    //   1192	1198	1688	finally
    //   1202	1211	1688	finally
    //   1215	1221	1688	finally
    //   1225	1234	1688	finally
    //   1238	1247	1688	finally
    //   1251	1258	1688	finally
    //   1262	1273	1688	finally
    //   1277	1282	1688	finally
    //   1286	1296	1688	finally
    //   1300	1308	1688	finally
    //   1312	1320	1688	finally
    //   1324	1330	1688	finally
    //   1334	1342	1688	finally
    //   1346	1352	1688	finally
    //   1356	1364	1688	finally
    //   1368	1377	1688	finally
    //   1381	1389	1688	finally
    //   1393	1405	1688	finally
    //   1409	1419	1688	finally
    //   1553	1564	1688	finally
    //   1567	1579	1688	finally
    //   1582	1588	1688	finally
    //   1591	1602	1688	finally
    //   1605	1611	1688	finally
    //   1614	1626	1688	finally
    //   1629	1646	1688	finally
    //   1649	1654	1688	finally
    //   1696	1700	1703	java/lang/Throwable
    //   2053	2058	2061	java/lang/Throwable
    //   2651	2656	2659	java/lang/Throwable
    //   1869	1895	2754	finally
    //   1908	1921	2754	finally
    //   1935	1942	2754	finally
    //   1956	1968	2754	finally
    //   1968	2027	2754	finally
    //   2027	2044	2754	finally
    //   2096	2114	2754	finally
    //   2341	2349	2754	finally
    //   2356	2377	2754	finally
    //   2380	2421	2754	finally
    //   2424	2523	2754	finally
    //   2523	2642	2754	finally
    //   2695	2754	2754	finally
    //   1869	1895	2762	java/lang/Exception
    //   1908	1921	2762	java/lang/Exception
    //   1935	1942	2762	java/lang/Exception
    //   1956	1968	2762	java/lang/Exception
    //   1968	2027	2762	java/lang/Exception
    //   2027	2044	2762	java/lang/Exception
    //   2096	2114	2762	java/lang/Exception
    //   2341	2349	2762	java/lang/Exception
    //   2356	2377	2762	java/lang/Exception
    //   2380	2421	2762	java/lang/Exception
    //   2424	2523	2762	java/lang/Exception
    //   2523	2642	2762	java/lang/Exception
    //   2695	2754	2762	java/lang/Exception
    //   1780	1865	2770	finally
    //   2114	2341	2770	finally
    //   1780	1865	2778	java/lang/Exception
    //   2114	2341	2778	java/lang/Exception
    //   1736	1761	2786	finally
    //   1761	1780	2786	finally
    //   1736	1761	2798	java/lang/Exception
    //   1761	1780	2798	java/lang/Exception
    //   1727	1736	2806	finally
    //   1727	1736	2822	java/lang/Exception
    //   2924	2929	2932	java/lang/Throwable
    //   2836	2848	2966	finally
    //   2848	2876	2966	finally
    //   2876	2916	2966	finally
    //   2979	2984	2987	java/lang/Throwable
    //   3142	3326	3935	java/lang/Exception
    //   3054	3142	3939	java/lang/Exception
    //   3326	3334	3939	java/lang/Exception
    //   3337	3358	3939	java/lang/Exception
    //   3361	3386	3939	java/lang/Exception
    //   3391	3403	3939	java/lang/Exception
    //   3406	3538	3939	java/lang/Exception
    //   3541	3665	3939	java/lang/Exception
    //   3667	3766	3939	java/lang/Exception
    //   3766	3873	3939	java/lang/Exception
    //   3876	3935	3939	java/lang/Exception
    //   70	91	4066	java/lang/Exception
    //   93	105	4066	java/lang/Exception
    //   490	494	4066	java/lang/Exception
    //   498	518	4066	java/lang/Exception
    //   1419	1424	4066	java/lang/Exception
    //   1428	1448	4066	java/lang/Exception
    //   1658	1662	4066	java/lang/Exception
    //   1666	1686	4066	java/lang/Exception
    //   1696	1700	4066	java/lang/Exception
    //   1704	1724	4066	java/lang/Exception
    //   1724	1727	4066	java/lang/Exception
    //   2053	2058	4070	java/lang/Exception
    //   2066	2070	4070	java/lang/Exception
    //   2074	2080	4070	java/lang/Exception
    //   2084	2094	4070	java/lang/Exception
    //   2651	2656	4070	java/lang/Exception
    //   2664	2668	4070	java/lang/Exception
    //   2672	2678	4070	java/lang/Exception
    //   2682	2692	4070	java/lang/Exception
    //   2924	2929	4070	java/lang/Exception
    //   2937	2942	4070	java/lang/Exception
    //   2945	2951	4070	java/lang/Exception
    //   2954	2964	4070	java/lang/Exception
    //   2979	2984	4070	java/lang/Exception
    //   2992	2997	4070	java/lang/Exception
    //   3000	3006	4070	java/lang/Exception
    //   3009	3019	4070	java/lang/Exception
    //   3022	3025	4070	java/lang/Exception
    //   3033	3038	4070	java/lang/Exception
    //   3042	3054	4070	java/lang/Exception
    //   3948	3959	4070	java/lang/Exception
    //   3963	3973	4070	java/lang/Exception
    //   3977	3982	4070	java/lang/Exception
    //   3986	3996	4070	java/lang/Exception
    //   4000	4017	4070	java/lang/Exception
  }
  
  private boolean a(com.tencent.msf.service.protocol.push.a.a parama)
  {
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      this.p.z = ((com.tencent.msf.service.protocol.push.a.d)localObject1).i;
      if ((this.b.i > 0L) && (this.b.i < 600L)) {
        this.m = ((int)this.b.i * 1000);
      }
    }
    else
    {
      localObject1 = this.c;
      if (localObject1 != null)
      {
        this.p.z = ((b)localObject1).i;
        if ((this.c.i > 0L) && (this.c.i < 600L)) {
          this.m = ((int)this.c.i * 1000);
        }
      }
    }
    label1949:
    label1951:
    label1957:
    label1985:
    label1988:
    for (;;)
    {
      int i2;
      try
      {
        boolean bool = QLog.isDevelopLevel();
        if (bool)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("QualityTest: Start connecting: ");
          ((StringBuilder)localObject1).append(this.n);
          ((StringBuilder)localObject1).append(", port:");
          ((StringBuilder)localObject1).append(this.o);
          ((StringBuilder)localObject1).append(", strDomain:");
          ((StringBuilder)localObject1).append(parama.c);
          ((StringBuilder)localObject1).append(", mTestType:");
          ((StringBuilder)localObject1).append(this.a);
          QLog.d("MSF.C.QualityTestManager", 4, ((StringBuilder)localObject1).toString());
        }
        i1 = e.a[this.a.ordinal()];
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3) {
              return false;
            }
            try
            {
              i1 = this.b.y;
              if (i1 == 1)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("https://");
                ((StringBuilder)localObject1).append(this.n.getHostAddress());
                ((StringBuilder)localObject1).append(":");
                ((StringBuilder)localObject1).append(this.o);
                ((StringBuilder)localObject1).append("/");
                ((StringBuilder)localObject1).append(this.b.q);
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              else
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("http://");
                ((StringBuilder)localObject1).append(this.n.getHostAddress());
                ((StringBuilder)localObject1).append(":");
                ((StringBuilder)localObject1).append(this.o);
                ((StringBuilder)localObject1).append("/");
                ((StringBuilder)localObject1).append(this.b.q);
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              Object localObject2;
              if (QLog.isDevelopLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("QualityTest: connecting http url:");
                ((StringBuilder)localObject2).append((String)localObject1);
                QLog.d("MSF.C.QualityTestManager", 4, ((StringBuilder)localObject2).toString());
              }
              this.t = System.currentTimeMillis();
              this.j = new URL((String)localObject1);
              this.k = ((HttpURLConnection)this.j.openConnection());
              if (this.b.y == 1)
              {
                g();
                ((HttpsURLConnection)this.k).setHostnameVerifier(this.R);
              }
              this.k.setConnectTimeout(this.m);
              this.k.setDoInput(true);
              this.k.setUseCaches(false);
              this.k.setReadTimeout(this.m);
              this.k.setRequestProperty("Connection", "close");
              if (this.l == 0)
              {
                this.k.setDoOutput(true);
                this.k.setRequestMethod("POST");
                this.k.setRequestProperty("Content-Type", "application/octet-stream");
              }
              else if (this.l == 1)
              {
                this.k.setInstanceFollowRedirects(false);
                this.k.setRequestMethod("GET");
              }
              this.k.setRequestProperty("Host", parama.c);
              if ((this.b.s != null) && (this.b.s.size() > 0))
              {
                parama = this.b.s.iterator();
                if (parama.hasNext())
                {
                  localObject1 = (e)parama.next();
                  if (localObject1 == null) {
                    continue;
                  }
                  this.k.setRequestProperty(((e)localObject1).a, ((e)localObject1).b);
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("reqHead.strKey:");
                  ((StringBuilder)localObject2).append(((e)localObject1).a);
                  ((StringBuilder)localObject2).append(",reqHead.strValue:");
                  ((StringBuilder)localObject2).append(((e)localObject1).b);
                  QLog.d("MSF.C.QualityTestManager", 4, ((StringBuilder)localObject2).toString());
                  continue;
                }
              }
              this.k.connect();
              long l1 = System.currentTimeMillis();
              this.u = l1;
              this.v = l1;
              if (QLog.isColorLevel())
              {
                parama = new StringBuilder();
                parama.append("QualityTest: end connect: mRequestMethod:");
                parama.append(this.l);
                parama.append(", readTimeout:");
                parama.append(this.m);
                QLog.d("MSF.C.QualityTestManager", 4, parama.toString());
              }
              parama = "";
              if (this.l == 1)
              {
                i2 = this.k.getResponseCode();
                if ((this.b.r & 0x4) == 4) {
                  break label1949;
                }
                i1 = 1;
                break label1951;
                i3 += 1;
                if (i3 > 10)
                {
                  QLog.d("MSF.C.QualityTestManager", 4, "Redirect too much!");
                  break label1988;
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
                  if (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (e)((Iterator)localObject1).next();
                    if (localObject2 == null) {
                      break label1985;
                    }
                    this.k.setRequestProperty(((e)localObject2).a, ((e)localObject2).b);
                    if (!QLog.isColorLevel()) {
                      break label1985;
                    }
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append("reqHead.strKey:");
                    localStringBuilder.append(((e)localObject2).a);
                    localStringBuilder.append(",reqHead.strValue:");
                    localStringBuilder.append(((e)localObject2).b);
                    QLog.d("MSF.C.QualityTestManager", 4, localStringBuilder.toString());
                    break label1985;
                  }
                }
                this.k.connect();
                l1 = System.currentTimeMillis();
                this.u = l1;
                this.v = l1;
                if (QLog.isColorLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("Redirect responseCode:");
                  ((StringBuilder)localObject1).append(i2);
                  ((StringBuilder)localObject1).append(",lastRedirectUrl:");
                  ((StringBuilder)localObject1).append(parama);
                  QLog.d("MSF.C.QualityTestManager", 4, ((StringBuilder)localObject1).toString());
                }
                i2 = this.k.getResponseCode();
                break label1957;
              }
              this.z = (this.u - this.t);
              this.p.I.add(Long.valueOf(this.z));
              bool = TextUtils.isEmpty(parama);
              if (bool) {
                continue;
              }
              try
              {
                parama = parama.substring(parama.indexOf("://") + 3);
                parama = InetAddress.getByName(parama.substring(0, parama.indexOf("/")));
                this.p.L = parama.getHostAddress();
              }
              catch (Exception parama)
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
              }
              QLog.d("MSF.C.QualityTestManager", 4, "DNSParse for lastUrl error!", parama);
            }
            catch (Throwable parama)
            {
              if (QLog.isDevelopLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("QualityTest: connecting ");
                ((StringBuilder)localObject1).append(this.n);
                ((StringBuilder)localObject1).append(" port:");
                ((StringBuilder)localObject1).append(this.o);
                ((StringBuilder)localObject1).append(" mTestType:");
                ((StringBuilder)localObject1).append(this.a);
                ((StringBuilder)localObject1).append(" failed");
                QLog.d("MSF.C.QualityTestManager", 4, ((StringBuilder)localObject1).toString(), parama);
              }
              parama = this.p;
              parama.o += 1;
              this.p.I.add(Long.valueOf(-1L));
              return false;
            }
          }
          else
          {
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
              parama = new StringBuilder();
              parama.append("QualityTest: TCP end connect: ");
              parama.append(this.n);
              parama.append(", port:");
              parama.append(this.o);
              parama.append(", readTimeout:");
              parama.append(this.m);
              QLog.d("MSF.C.QualityTestManager", 4, parama.toString());
            }
            catch (Throwable parama)
            {
              if (QLog.isDevelopLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("QualityTest: TCP end connect: ");
                ((StringBuilder)localObject1).append(this.n);
                ((StringBuilder)localObject1).append(", port:");
                ((StringBuilder)localObject1).append(this.o);
                ((StringBuilder)localObject1).append(", mTestType:");
                ((StringBuilder)localObject1).append(this.a);
                ((StringBuilder)localObject1).append(" failed");
                QLog.d("MSF.C.QualityTestManager", 4, ((StringBuilder)localObject1).toString(), parama);
              }
              parama = this.p;
              parama.o += 1;
              this.p.I.add(Long.valueOf(-1L));
              return false;
            }
          }
        }
        else
        {
          this.g = new DatagramSocket();
          this.g.setSoTimeout(this.m);
          this.p.I.add(Long.valueOf(-1L));
        }
        return true;
      }
      catch (Exception parama)
      {
        this.p.I.add(Long.valueOf(-1L));
        parama.printStackTrace();
        return false;
      }
      int i1 = 0;
      parama = "";
      int i3 = 0;
      if (i1 != 0) {
        if ((i2 != 301) && (i2 != 302)) {
          if (i2 == 307) {
            continue;
          }
        }
      }
    }
  }
  
  private boolean a(byte[] paramArrayOfByte)
  {
    try
    {
      int i1 = e.a[this.a.ordinal()];
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return false;
          }
          try
          {
            this.i = this.k.getOutputStream();
            k.g.add(this.i.toString());
            this.i.write(paramArrayOfByte);
            this.i.flush();
            k.g.remove(this.i.toString());
            this.B += paramArrayOfByte.length;
            this.T += paramArrayOfByte.length;
            paramArrayOfByte = this.p;
            paramArrayOfByte.l += 1;
            return true;
          }
          catch (Exception paramArrayOfByte)
          {
            if (this.i != null) {
              k.g.remove(this.i.toString());
            }
            a(c.e.a.d);
            QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send http error:", paramArrayOfByte);
            return false;
          }
        }
        try
        {
          this.v = System.currentTimeMillis();
          k.g.add(this.i.toString());
          this.i.write(paramArrayOfByte);
          this.i.flush();
          k.g.remove(this.i.toString());
          this.B += paramArrayOfByte.length;
          this.T += paramArrayOfByte.length;
          paramArrayOfByte = this.p;
          paramArrayOfByte.l += 1;
          return true;
        }
        catch (Exception paramArrayOfByte)
        {
          if (this.i != null) {
            k.g.remove(this.i.toString());
          }
          a(c.e.a.d);
          QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send tcp error:", paramArrayOfByte);
          return false;
        }
      }
      DatagramPacket localDatagramPacket = new DatagramPacket(paramArrayOfByte, paramArrayOfByte.length, this.n, this.o);
      try
      {
        this.v = System.currentTimeMillis();
        this.g.send(localDatagramPacket);
        this.w = System.currentTimeMillis();
        this.A += this.w - this.v;
        this.B += paramArrayOfByte.length;
        this.T += paramArrayOfByte.length;
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("QualityTest: send udp packet length:");
        paramArrayOfByte.append(localDatagramPacket.getLength());
        paramArrayOfByte.append(" sendEndTime:");
        paramArrayOfByte.append(this.w);
        paramArrayOfByte.append(" sendTime:");
        paramArrayOfByte.append(this.v);
        QLog.d("MSF.C.QualityTestManager", 1, paramArrayOfByte.toString());
        paramArrayOfByte = this.p;
        paramArrayOfByte.l += 1;
        return true;
      }
      catch (Exception paramArrayOfByte)
      {
        a(c.e.a.d);
        QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send udp packet error:", paramArrayOfByte);
        return false;
      }
      return false;
    }
    catch (Exception paramArrayOfByte) {}
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
      if (this.a != c.b.c) {
        if ((this.b.o != 0) && (1 != this.b.o))
        {
          if (2 == this.b.o)
          {
            if (QLog.isColorLevel())
            {
              QLog.d("MSF.C.QualityTestManager", 2, "qualityTestMsg.cTestType=2, Should*NOT* check head len");
              return arrayOfByte;
            }
          }
          else
          {
            if (QLog.isColorLevel())
            {
              paramArrayOfByte1 = new StringBuilder();
              paramArrayOfByte1.append("qualityTestMsg.cTestType");
              paramArrayOfByte1.append(this.b.o);
              paramArrayOfByte1.append("NotSupport, giveup speed_test");
              QLog.d("MSF.C.QualityTestManager", 2, paramArrayOfByte1.toString());
            }
            return null;
          }
        }
        else
        {
          int i1 = com.tencent.mobileqq.msf.core.c.a(arrayOfByte, 0);
          if (i1 != paramInt)
          {
            if (QLog.isDevelopLevel())
            {
              paramArrayOfByte1 = new StringBuilder();
              paramArrayOfByte1.append("testdata length error stop dataTotalLen:");
              paramArrayOfByte1.append(i1);
              paramArrayOfByte1.append(" receBodySize:");
              paramArrayOfByte1.append(paramInt);
              QLog.d("MSF.C.QualityTestManager", 4, paramArrayOfByte1.toString());
            }
            b(c.e.a.f, true);
            k.a();
            return null;
          }
        }
      }
      return arrayOfByte;
    }
    paramArrayOfByte1 = this.c;
    return null;
  }
  
  private String b(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      paramString = Pattern.compile("(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})").matcher(paramString);
      if (paramString.find()) {
        return paramString.group();
      }
    }
    return null;
  }
  
  private void b(c.e.a parama, boolean paramBoolean)
  {
    a(parama, paramBoolean);
    if (paramBoolean)
    {
      parama = new ArrayList();
      try
      {
        parama.add(this.S.getBytes("utf-8"));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("QualTest", parama);
      try
      {
        k.a(this.V, this.b, this.c, this.U, this.T, this.p.g);
        k.d.configManager.a(localHashMap, "");
      }
      catch (Exception parama)
      {
        parama.printStackTrace();
      }
      parama = new StringBuilder();
      parama.append("QualityClient finish, succ: ");
      parama.append(this.S);
      QLog.d("MSF.C.QualityTestManager", 1, parama.toString());
    }
  }
  
  private void b(com.tencent.msf.service.protocol.push.a.a parama)
  {
    long l1 = parama.a;
    int i1 = parama.b;
    try
    {
      this.n = g.a(l1);
      this.o = g.a(i1);
    }
    catch (UnknownHostException localUnknownHostException)
    {
      localUnknownHostException.printStackTrace();
    }
    Object localObject = this.p;
    ((c.e)localObject).e = this.n;
    ((c.e)localObject).f = this.o;
    ((c.e)localObject).C = parama.c;
    parama = parama.c;
    i1 = 0;
    if ((parama != null) && (parama.length() > 0) && (2 == this.b.o)) {
      try
      {
        l1 = SystemClock.elapsedRealtime();
        this.r = System.currentTimeMillis();
        localObject = InetAddress.getAllByName(parama);
        this.p.D = (SystemClock.elapsedRealtime() - l1);
        this.s = System.currentTimeMillis();
        if ((localObject != null) && (localObject.length > 0))
        {
          this.p.E = 0;
          if ((this.b.r & 0x1) == 1) {
            this.n = localObject[0];
          } else {
            this.n = localObject[new java.util.Random().nextInt(localObject.length)];
          }
          this.p.e = this.n;
          parama = new StringBuilder();
          while (i1 < localObject.length)
          {
            parama.append(localObject[i1].getHostAddress());
            parama.append("|");
            parama.append(localObject[i1].getHostName());
            parama.append("**");
            i1 += 1;
          }
          if (!QLog.isDevelopLevel()) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("dns addrs ");
          ((StringBuilder)localObject).append(parama.toString());
          QLog.d("MSF.C.QualityTestManager", 4, ((StringBuilder)localObject).toString());
          return;
        }
        this.p.E = 1;
        return;
      }
      catch (UnknownHostException parama)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "dns parse error! ", parama);
        }
        this.p.E = 1;
        return;
      }
    } else {
      this.p.E = 0;
    }
  }
  
  private boolean b(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (new String(paramArrayOfByte).endsWith("\r\n\r\n"));
  }
  
  /* Error */
  public static String d()
  {
    // Byte code:
    //   0: new 956	java/io/BufferedReader
    //   3: dup
    //   4: new 958	java/io/FileReader
    //   7: dup
    //   8: ldc_w 960
    //   11: invokespecial 961	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   14: sipush 8192
    //   17: invokespecial 964	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   20: astore_1
    //   21: aload_1
    //   22: astore_0
    //   23: aload_1
    //   24: invokevirtual 967	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: ldc_w 969
    //   30: ldc 120
    //   32: invokevirtual 973	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   35: ldc_w 610
    //   38: invokevirtual 977	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   41: astore_2
    //   42: aload_1
    //   43: astore_0
    //   44: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   47: ifeq +45 -> 92
    //   50: aload_1
    //   51: astore_0
    //   52: new 241	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   59: astore_3
    //   60: aload_1
    //   61: astore_0
    //   62: aload_3
    //   63: ldc_w 979
    //   66: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_1
    //   71: astore_0
    //   72: aload_3
    //   73: aload_2
    //   74: iconst_1
    //   75: aaload
    //   76: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_1
    //   81: astore_0
    //   82: ldc 255
    //   84: iconst_4
    //   85: aload_3
    //   86: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_1
    //   93: invokevirtual 980	java/io/BufferedReader:close	()V
    //   96: goto +23 -> 119
    //   99: astore_0
    //   100: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   103: ifeq +12 -> 115
    //   106: ldc 255
    //   108: iconst_4
    //   109: ldc_w 982
    //   112: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: aload_0
    //   116: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   119: aload_2
    //   120: iconst_1
    //   121: aaload
    //   122: areturn
    //   123: astore_2
    //   124: goto +12 -> 136
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_0
    //   130: goto +64 -> 194
    //   133: astore_2
    //   134: aconst_null
    //   135: astore_1
    //   136: aload_1
    //   137: astore_0
    //   138: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   141: ifeq +14 -> 155
    //   144: aload_1
    //   145: astore_0
    //   146: ldc 255
    //   148: iconst_4
    //   149: ldc_w 984
    //   152: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_1
    //   156: astore_0
    //   157: aload_2
    //   158: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   161: aload_1
    //   162: invokevirtual 980	java/io/BufferedReader:close	()V
    //   165: ldc_w 986
    //   168: areturn
    //   169: astore_0
    //   170: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   173: ifeq +12 -> 185
    //   176: ldc 255
    //   178: iconst_4
    //   179: ldc_w 982
    //   182: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload_0
    //   186: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   189: ldc_w 986
    //   192: areturn
    //   193: astore_1
    //   194: aload_0
    //   195: invokevirtual 980	java/io/BufferedReader:close	()V
    //   198: goto +23 -> 221
    //   201: astore_0
    //   202: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   205: ifeq +12 -> 217
    //   208: ldc 255
    //   210: iconst_4
    //   211: ldc_w 982
    //   214: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_0
    //   218: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   221: aload_1
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	60	0	localBufferedReader1	java.io.BufferedReader
    //   99	17	0	localException1	Exception
    //   129	28	0	localObject1	Object
    //   169	26	0	localException2	Exception
    //   201	17	0	localException3	Exception
    //   20	73	1	localBufferedReader2	java.io.BufferedReader
    //   127	1	1	localObject2	Object
    //   135	27	1	localObject3	Object
    //   193	29	1	localObject4	Object
    //   41	79	2	arrayOfString	String[]
    //   123	1	2	localException4	Exception
    //   133	25	2	localException5	Exception
    //   59	27	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   92	96	99	java/lang/Exception
    //   23	42	123	java/lang/Exception
    //   44	50	123	java/lang/Exception
    //   52	60	123	java/lang/Exception
    //   62	70	123	java/lang/Exception
    //   72	80	123	java/lang/Exception
    //   82	92	123	java/lang/Exception
    //   0	21	127	finally
    //   0	21	133	java/lang/Exception
    //   161	165	169	java/lang/Exception
    //   23	42	193	finally
    //   44	50	193	finally
    //   52	60	193	finally
    //   62	70	193	finally
    //   72	80	193	finally
    //   82	92	193	finally
    //   138	144	193	finally
    //   146	155	193	finally
    //   157	161	193	finally
    //   194	198	201	java/lang/Exception
  }
  
  /* Error */
  public static String e()
  {
    // Byte code:
    //   0: new 956	java/io/BufferedReader
    //   3: dup
    //   4: new 958	java/io/FileReader
    //   7: dup
    //   8: ldc_w 988
    //   11: invokespecial 961	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   14: sipush 8192
    //   17: invokespecial 964	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: aload_2
    //   24: invokevirtual 967	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: ldc_w 990
    //   30: invokevirtual 977	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   33: astore 4
    //   35: iconst_2
    //   36: istore_0
    //   37: ldc 120
    //   39: astore_3
    //   40: aload_2
    //   41: astore_1
    //   42: iload_0
    //   43: aload 4
    //   45: arraylength
    //   46: if_icmpge +61 -> 107
    //   49: aload_2
    //   50: astore_1
    //   51: new 241	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   58: astore 5
    //   60: aload_2
    //   61: astore_1
    //   62: aload 5
    //   64: aload_3
    //   65: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_2
    //   70: astore_1
    //   71: aload 5
    //   73: aload 4
    //   75: iload_0
    //   76: aaload
    //   77: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_2
    //   82: astore_1
    //   83: aload 5
    //   85: ldc_w 992
    //   88: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_2
    //   93: astore_1
    //   94: aload 5
    //   96: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore_3
    //   100: iload_0
    //   101: iconst_1
    //   102: iadd
    //   103: istore_0
    //   104: goto -64 -> 40
    //   107: aload_2
    //   108: invokevirtual 980	java/io/BufferedReader:close	()V
    //   111: goto +23 -> 134
    //   114: astore_1
    //   115: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   118: ifeq +12 -> 130
    //   121: ldc 255
    //   123: iconst_4
    //   124: ldc_w 982
    //   127: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload_1
    //   131: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   134: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   137: ifeq +35 -> 172
    //   140: new 241	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   147: astore_1
    //   148: aload_1
    //   149: ldc_w 994
    //   152: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_1
    //   157: aload_3
    //   158: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: ldc 255
    //   164: iconst_4
    //   165: aload_1
    //   166: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_3
    //   173: areturn
    //   174: astore_3
    //   175: goto +12 -> 187
    //   178: astore_2
    //   179: aconst_null
    //   180: astore_1
    //   181: goto +64 -> 245
    //   184: astore_3
    //   185: aconst_null
    //   186: astore_2
    //   187: aload_2
    //   188: astore_1
    //   189: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   192: ifeq +14 -> 206
    //   195: aload_2
    //   196: astore_1
    //   197: ldc 255
    //   199: iconst_4
    //   200: ldc_w 996
    //   203: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_2
    //   207: astore_1
    //   208: aload_3
    //   209: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   212: aload_2
    //   213: invokevirtual 980	java/io/BufferedReader:close	()V
    //   216: ldc_w 998
    //   219: areturn
    //   220: astore_1
    //   221: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   224: ifeq +12 -> 236
    //   227: ldc 255
    //   229: iconst_4
    //   230: ldc_w 982
    //   233: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_1
    //   237: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   240: ldc_w 998
    //   243: areturn
    //   244: astore_2
    //   245: aload_1
    //   246: invokevirtual 980	java/io/BufferedReader:close	()V
    //   249: goto +23 -> 272
    //   252: astore_1
    //   253: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   256: ifeq +12 -> 268
    //   259: ldc 255
    //   261: iconst_4
    //   262: ldc_w 982
    //   265: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: aload_1
    //   269: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   272: goto +5 -> 277
    //   275: aload_2
    //   276: athrow
    //   277: goto -2 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	68	0	i1	int
    //   22	72	1	localBufferedReader1	java.io.BufferedReader
    //   114	17	1	localException1	Exception
    //   147	61	1	localObject1	Object
    //   220	26	1	localException2	Exception
    //   252	17	1	localException3	Exception
    //   20	88	2	localBufferedReader2	java.io.BufferedReader
    //   178	1	2	localObject2	Object
    //   186	27	2	localObject3	Object
    //   244	32	2	localObject4	Object
    //   39	134	3	str	String
    //   174	1	3	localException4	Exception
    //   184	25	3	localException5	Exception
    //   33	41	4	arrayOfString	String[]
    //   58	37	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   107	111	114	java/lang/Exception
    //   23	35	174	java/lang/Exception
    //   42	49	174	java/lang/Exception
    //   51	60	174	java/lang/Exception
    //   62	69	174	java/lang/Exception
    //   71	81	174	java/lang/Exception
    //   83	92	174	java/lang/Exception
    //   94	100	174	java/lang/Exception
    //   0	21	178	finally
    //   0	21	184	java/lang/Exception
    //   212	216	220	java/lang/Exception
    //   23	35	244	finally
    //   42	49	244	finally
    //   51	60	244	finally
    //   62	69	244	finally
    //   71	81	244	finally
    //   83	92	244	finally
    //   94	100	244	finally
    //   189	195	244	finally
    //   197	206	244	finally
    //   208	212	244	finally
    //   245	249	252	java/lang/Exception
  }
  
  /* Error */
  public static ArrayList f()
  {
    // Byte code:
    //   0: getstatic 1016	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 21
    //   5: if_icmplt +157 -> 162
    //   8: invokestatic 1022	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: ldc_w 1024
    //   14: invokevirtual 1028	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 1030	android/net/ConnectivityManager
    //   20: astore_1
    //   21: aload_1
    //   22: invokevirtual 1034	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   25: astore_2
    //   26: aload_2
    //   27: invokevirtual 1039	android/net/NetworkInfo:getType	()I
    //   30: pop
    //   31: aload_2
    //   32: invokevirtual 1039	android/net/NetworkInfo:getType	()I
    //   35: ifne +6 -> 41
    //   38: goto +16 -> 54
    //   41: aload_2
    //   42: invokevirtual 1039	android/net/NetworkInfo:getType	()I
    //   45: iconst_1
    //   46: if_icmpne +8 -> 54
    //   49: iconst_1
    //   50: istore_0
    //   51: goto +5 -> 56
    //   54: iconst_0
    //   55: istore_0
    //   56: ldc_w 1030
    //   59: ldc_w 1041
    //   62: iconst_1
    //   63: anewarray 1043	java/lang/Class
    //   66: dup
    //   67: iconst_0
    //   68: getstatic 1047	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   71: aastore
    //   72: invokevirtual 1051	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   75: astore_2
    //   76: aload_2
    //   77: aload_1
    //   78: iconst_1
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: iload_0
    //   85: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: invokevirtual 1057	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 1061	java/lang/Object:getClass	()Ljava/lang/Class;
    //   97: ldc_w 1063
    //   100: invokevirtual 1067	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   103: astore_2
    //   104: aload_2
    //   105: iconst_1
    //   106: invokevirtual 1072	java/lang/reflect/Field:setAccessible	(Z)V
    //   109: aload_2
    //   110: aload_1
    //   111: invokevirtual 1073	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   114: checkcast 346	java/util/ArrayList
    //   117: astore_1
    //   118: aload_1
    //   119: areturn
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 1074	java/lang/NoSuchFieldException:printStackTrace	()V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 1075	java/lang/SecurityException:printStackTrace	()V
    //   132: aconst_null
    //   133: areturn
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 1076	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   139: aconst_null
    //   140: areturn
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 1077	java/lang/IllegalAccessException:printStackTrace	()V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_1
    //   149: aload_1
    //   150: invokevirtual 1078	java/lang/IllegalArgumentException:printStackTrace	()V
    //   153: aconst_null
    //   154: areturn
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 1079	java/lang/NoSuchMethodException:printStackTrace	()V
    //   160: aconst_null
    //   161: areturn
    //   162: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +45 -> 210
    //   168: new 241	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   175: astore_1
    //   176: aload_1
    //   177: ldc_w 1081
    //   180: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_1
    //   185: getstatic 1016	android/os/Build$VERSION:SDK_INT	I
    //   188: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_1
    //   193: ldc_w 1083
    //   196: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: ldc 255
    //   202: iconst_4
    //   203: aload_1
    //   204: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: aconst_null
    //   211: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   50	35	0	i1	int
    //   20	99	1	localObject1	Object
    //   120	2	1	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   127	2	1	localSecurityException	java.lang.SecurityException
    //   134	2	1	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   141	2	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   148	2	1	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   155	2	1	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   175	29	1	localStringBuilder	StringBuilder
    //   25	85	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   93	118	120	java/lang/NoSuchFieldException
    //   93	118	127	java/lang/SecurityException
    //   76	93	134	java/lang/reflect/InvocationTargetException
    //   93	118	134	java/lang/reflect/InvocationTargetException
    //   121	125	134	java/lang/reflect/InvocationTargetException
    //   128	132	134	java/lang/reflect/InvocationTargetException
    //   76	93	141	java/lang/IllegalAccessException
    //   93	118	141	java/lang/IllegalAccessException
    //   121	125	141	java/lang/IllegalAccessException
    //   128	132	141	java/lang/IllegalAccessException
    //   76	93	148	java/lang/IllegalArgumentException
    //   93	118	148	java/lang/IllegalArgumentException
    //   121	125	148	java/lang/IllegalArgumentException
    //   128	132	148	java/lang/IllegalArgumentException
    //   56	76	155	java/lang/NoSuchMethodException
    //   76	93	155	java/lang/NoSuchMethodException
    //   93	118	155	java/lang/NoSuchMethodException
    //   121	125	155	java/lang/NoSuchMethodException
    //   128	132	155	java/lang/NoSuchMethodException
    //   135	139	155	java/lang/NoSuchMethodException
    //   142	146	155	java/lang/NoSuchMethodException
    //   149	153	155	java/lang/NoSuchMethodException
  }
  
  private static void g()
  {
    try
    {
      c.a locala = new c.a();
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      SecureRandom localSecureRandom = new SecureRandom();
      localSSLContext.init(null, new TrustManager[] { locala }, localSecureRandom);
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
      int i1 = e.a[this.a.ordinal()];
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return;
          }
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
          if (!QLog.isDevelopLevel()) {
            break label186;
          }
          QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close Http socket");
          return;
        }
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
        if (!QLog.isDevelopLevel()) {
          break label186;
        }
        QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close Tcp socket");
        return;
      }
      if (this.g != null)
      {
        this.g.close();
        this.g = null;
      }
      if (!QLog.isDevelopLevel()) {
        break label186;
      }
      QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close Udp socket");
      return;
    }
    catch (Exception localException)
    {
      label171:
      label186:
      break label171;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: close socket excep!");
    }
  }
  
  /* Error */
  private void i()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   4: ifnonnull +15 -> 19
    //   7: aload_0
    //   8: getstatic 1128	com/tencent/mobileqq/msf/core/net/c/c$e$a:k	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   11: iconst_1
    //   12: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   15: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   18: return
    //   19: aload_0
    //   20: invokespecial 1130	com/tencent/mobileqq/msf/core/net/c/c:j	()V
    //   23: aload_0
    //   24: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   27: aload_0
    //   28: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   31: getfield 1132	com/tencent/msf/service/protocol/push/a/d:a	S
    //   34: putfield 1134	com/tencent/mobileqq/msf/core/net/c/c$e:r	I
    //   37: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +246 -> 286
    //   43: new 241	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   50: astore 6
    //   52: aload 6
    //   54: ldc_w 1136
    //   57: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 6
    //   63: aload_0
    //   64: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   67: getfield 1132	com/tencent/msf/service/protocol/push/a/d:a	S
    //   70: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 6
    //   76: ldc_w 1138
    //   79: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 6
    //   85: aload_0
    //   86: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   89: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   92: invokevirtual 678	java/util/ArrayList:size	()I
    //   95: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 6
    //   101: ldc_w 1142
    //   104: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 6
    //   110: aload_0
    //   111: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   114: getfield 710	com/tencent/msf/service/protocol/push/a/d:r	S
    //   117: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 6
    //   123: ldc_w 1144
    //   126: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 6
    //   132: aload_0
    //   133: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   136: getfield 430	com/tencent/msf/service/protocol/push/a/d:t	Ljava/lang/String;
    //   139: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 6
    //   145: ldc_w 1146
    //   148: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 6
    //   154: aload_0
    //   155: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   158: getfield 1148	com/tencent/msf/service/protocol/push/a/d:u	Ljava/lang/String;
    //   161: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 6
    //   167: ldc_w 1150
    //   170: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 6
    //   176: aload_0
    //   177: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   180: getfield 404	com/tencent/msf/service/protocol/push/a/d:w	J
    //   183: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 6
    //   189: ldc_w 1152
    //   192: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 6
    //   198: aload_0
    //   199: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   202: getfield 403	com/tencent/msf/service/protocol/push/a/d:x	J
    //   205: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 6
    //   211: ldc_w 1154
    //   214: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 6
    //   220: aload_0
    //   221: getfield 132	com/tencent/mobileqq/msf/core/net/c/c:q	Lcom/tencent/mobileqq/msf/core/net/c/c$d;
    //   224: getfield 1156	com/tencent/mobileqq/msf/core/net/c/c$d:j	Ljava/lang/String;
    //   227: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 6
    //   233: ldc_w 1158
    //   236: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 6
    //   242: aload_0
    //   243: getfield 132	com/tencent/mobileqq/msf/core/net/c/c:q	Lcom/tencent/mobileqq/msf/core/net/c/c$d;
    //   246: getfield 1160	com/tencent/mobileqq/msf/core/net/c/c$d:l	J
    //   249: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 6
    //   255: ldc_w 1162
    //   258: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 6
    //   264: aload_0
    //   265: getfield 132	com/tencent/mobileqq/msf/core/net/c/c:q	Lcom/tencent/mobileqq/msf/core/net/c/c$d;
    //   268: getfield 1164	com/tencent/mobileqq/msf/core/net/c/c$d:m	Ljava/lang/String;
    //   271: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: ldc 255
    //   277: iconst_2
    //   278: aload 6
    //   280: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: aload_0
    //   287: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   290: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   293: invokevirtual 678	java/util/ArrayList:size	()I
    //   296: bipush 10
    //   298: if_icmple +35 -> 333
    //   301: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   304: ifeq +12 -> 316
    //   307: ldc 255
    //   309: iconst_4
    //   310: ldc_w 1166
    //   313: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: aload_0
    //   317: iconst_0
    //   318: putfield 134	com/tencent/mobileqq/msf/core/net/c/c:V	Z
    //   321: aload_0
    //   322: getstatic 1168	com/tencent/mobileqq/msf/core/net/c/c$e$a:m	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   325: iconst_1
    //   326: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   329: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   332: return
    //   333: aload_0
    //   334: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   337: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   340: invokevirtual 678	java/util/ArrayList:size	()I
    //   343: ifgt +35 -> 378
    //   346: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   349: ifeq +12 -> 361
    //   352: ldc 255
    //   354: iconst_4
    //   355: ldc_w 1170
    //   358: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: aload_0
    //   362: iconst_0
    //   363: putfield 134	com/tencent/mobileqq/msf/core/net/c/c:V	Z
    //   366: aload_0
    //   367: getstatic 1172	com/tencent/mobileqq/msf/core/net/c/c$e$a:n	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   370: iconst_1
    //   371: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   374: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   377: return
    //   378: aload_0
    //   379: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   382: getfield 1174	com/tencent/msf/service/protocol/push/a/d:h	J
    //   385: ldc2_w 1175
    //   388: lmul
    //   389: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   392: lcmp
    //   393: ifge +81 -> 474
    //   396: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   399: ifeq +63 -> 462
    //   402: new 241	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   409: astore 6
    //   411: aload 6
    //   413: ldc_w 1178
    //   416: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload 6
    //   422: aload_0
    //   423: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   426: getfield 1174	com/tencent/msf/service/protocol/push/a/d:h	J
    //   429: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 6
    //   435: ldc_w 1180
    //   438: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload 6
    //   444: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   447: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: ldc 255
    //   453: iconst_4
    //   454: aload 6
    //   456: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: aload_0
    //   463: getstatic 1182	com/tencent/mobileqq/msf/core/net/c/c$e$a:j	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   466: iconst_1
    //   467: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   470: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   473: return
    //   474: ldc_w 1183
    //   477: istore_2
    //   478: iload_2
    //   479: istore_1
    //   480: aload_0
    //   481: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   484: getfield 583	com/tencent/msf/service/protocol/push/a/d:i	J
    //   487: lconst_0
    //   488: lcmp
    //   489: ifle +32 -> 521
    //   492: iload_2
    //   493: istore_1
    //   494: aload_0
    //   495: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   498: getfield 583	com/tencent/msf/service/protocol/push/a/d:i	J
    //   501: ldc2_w 1184
    //   504: lcmp
    //   505: ifge +16 -> 521
    //   508: aload_0
    //   509: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   512: getfield 583	com/tencent/msf/service/protocol/push/a/d:i	J
    //   515: l2i
    //   516: sipush 1000
    //   519: imul
    //   520: istore_1
    //   521: iconst_0
    //   522: istore_2
    //   523: aload_0
    //   524: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   527: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   530: invokevirtual 678	java/util/ArrayList:size	()I
    //   533: istore_3
    //   534: iload_2
    //   535: iload_3
    //   536: if_icmpge +773 -> 1309
    //   539: aload_0
    //   540: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   543: invokestatic 208	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   546: putfield 883	com/tencent/mobileqq/msf/core/net/c/c$e:g	I
    //   549: aload_0
    //   550: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   553: invokestatic 1188	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getWifiStrength	()I
    //   556: putfield 1190	com/tencent/mobileqq/msf/core/net/c/c$e:h	I
    //   559: aload_0
    //   560: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   563: invokestatic 1193	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getCdmaStrength	()I
    //   566: putfield 1195	com/tencent/mobileqq/msf/core/net/c/c$e:j	I
    //   569: aload_0
    //   570: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   573: invokestatic 1198	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getGsmStrength	()I
    //   576: putfield 1200	com/tencent/mobileqq/msf/core/net/c/c$e:i	I
    //   579: aload_0
    //   580: aload_0
    //   581: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   584: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   587: iload_2
    //   588: invokevirtual 1203	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   591: checkcast 597	com/tencent/msf/service/protocol/push/a/a
    //   594: getfield 907	com/tencent/msf/service/protocol/push/a/a:a	J
    //   597: invokestatic 514	com/tencent/qphone/base/util/g:a	(J)Ljava/net/InetAddress;
    //   600: putfield 118	com/tencent/mobileqq/msf/core/net/c/c:n	Ljava/net/InetAddress;
    //   603: goto +22 -> 625
    //   606: astore 6
    //   608: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   611: ifeq +14 -> 625
    //   614: ldc 255
    //   616: iconst_4
    //   617: ldc_w 1205
    //   620: aload 6
    //   622: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   625: aload_0
    //   626: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   629: aload_0
    //   630: getfield 118	com/tencent/mobileqq/msf/core/net/c/c:n	Ljava/net/InetAddress;
    //   633: invokevirtual 608	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   636: putfield 1207	com/tencent/mobileqq/msf/core/net/c/c$e:K	Ljava/lang/String;
    //   639: aload_0
    //   640: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   643: aload_0
    //   644: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   647: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   650: iload_2
    //   651: invokevirtual 1203	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   654: checkcast 597	com/tencent/msf/service/protocol/push/a/a
    //   657: getfield 599	com/tencent/msf/service/protocol/push/a/a:c	Ljava/lang/String;
    //   660: putfield 919	com/tencent/mobileqq/msf/core/net/c/c$e:C	Ljava/lang/String;
    //   663: aload_0
    //   664: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   667: getfield 919	com/tencent/mobileqq/msf/core/net/c/c$e:C	Ljava/lang/String;
    //   670: ifnull +16 -> 686
    //   673: aload_0
    //   674: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   677: getfield 919	com/tencent/mobileqq/msf/core/net/c/c$e:C	Ljava/lang/String;
    //   680: invokevirtual 1209	java/lang/String:isEmpty	()Z
    //   683: ifeq +17 -> 700
    //   686: aload_0
    //   687: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   690: aload_0
    //   691: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   694: getfield 1207	com/tencent/mobileqq/msf/core/net/c/c$e:K	Ljava/lang/String;
    //   697: putfield 919	com/tencent/mobileqq/msf/core/net/c/c$e:C	Ljava/lang/String;
    //   700: aload_0
    //   701: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   704: getfield 178	com/tencent/mobileqq/msf/core/net/c/c$e:c	Ljava/util/Map;
    //   707: invokeinterface 1212 1 0
    //   712: aload_0
    //   713: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   716: getfield 919	com/tencent/mobileqq/msf/core/net/c/c$e:C	Ljava/lang/String;
    //   719: astore 6
    //   721: aload_0
    //   722: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   725: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   728: putfield 380	com/tencent/mobileqq/msf/core/net/c/c$e:M	J
    //   731: new 1214	com/tencent/mobileqq/msf/core/net/c/i
    //   734: dup
    //   735: aload 6
    //   737: iconst_1
    //   738: iload_1
    //   739: invokespecial 1217	com/tencent/mobileqq/msf/core/net/c/i:<init>	(Ljava/lang/String;ZI)V
    //   742: astore 9
    //   744: getstatic 300	com/tencent/mobileqq/msf/core/net/c/e:a	[I
    //   747: aload_0
    //   748: getfield 166	com/tencent/mobileqq/msf/core/net/c/c:a	Lcom/tencent/mobileqq/msf/core/net/c/c$b;
    //   751: invokevirtual 303	com/tencent/mobileqq/msf/core/net/c/c$b:ordinal	()I
    //   754: iaload
    //   755: istore_3
    //   756: ldc 120
    //   758: astore 6
    //   760: iload_3
    //   761: iconst_4
    //   762: if_icmpeq +75 -> 837
    //   765: iload_3
    //   766: iconst_5
    //   767: if_icmpeq +9 -> 776
    //   770: iconst_1
    //   771: istore 4
    //   773: goto +382 -> 1155
    //   776: aload 9
    //   778: invokevirtual 1220	com/tencent/mobileqq/msf/core/net/c/i:a	()Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   781: astore 8
    //   783: aload 8
    //   785: ifnull +561 -> 1346
    //   788: aload 8
    //   790: getfield 1224	com/tencent/mobileqq/msf/core/net/c/i$a:b	Z
    //   793: ifeq +553 -> 1346
    //   796: aload 8
    //   798: getfield 1226	com/tencent/mobileqq/msf/core/net/c/i$a:d	Ljava/lang/String;
    //   801: astore 7
    //   803: aload 7
    //   805: astore 6
    //   807: aload 8
    //   809: getfield 1227	com/tencent/mobileqq/msf/core/net/c/i$a:c	Ljava/lang/String;
    //   812: invokestatic 728	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   815: ifne -45 -> 770
    //   818: aload_0
    //   819: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   822: aload 8
    //   824: getfield 1227	com/tencent/mobileqq/msf/core/net/c/i$a:c	Ljava/lang/String;
    //   827: putfield 1207	com/tencent/mobileqq/msf/core/net/c/c$e:K	Ljava/lang/String;
    //   830: aload 7
    //   832: astore 6
    //   834: goto -64 -> 770
    //   837: aload_0
    //   838: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   841: getfield 1229	com/tencent/msf/service/protocol/push/a/d:v	Ljava/util/ArrayList;
    //   844: ifnull +250 -> 1094
    //   847: aload_0
    //   848: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   851: getfield 1229	com/tencent/msf/service/protocol/push/a/d:v	Ljava/util/ArrayList;
    //   854: invokevirtual 678	java/util/ArrayList:size	()I
    //   857: ifle +237 -> 1094
    //   860: aload_0
    //   861: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   864: getfield 1229	com/tencent/msf/service/protocol/push/a/d:v	Ljava/util/ArrayList;
    //   867: invokevirtual 682	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   870: astore 10
    //   872: ldc 120
    //   874: astore 7
    //   876: aload 10
    //   878: invokeinterface 687 1 0
    //   883: ifeq +161 -> 1044
    //   886: aload 10
    //   888: invokeinterface 691 1 0
    //   893: checkcast 1231	com/tencent/msf/service/protocol/push/a/c
    //   896: astore 11
    //   898: aload 11
    //   900: ifnull -24 -> 876
    //   903: new 241	java/lang/StringBuilder
    //   906: dup
    //   907: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   910: astore 8
    //   912: aload 8
    //   914: aload 7
    //   916: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: pop
    //   920: aload 8
    //   922: aload 11
    //   924: getfield 1232	com/tencent/msf/service/protocol/push/a/c:a	Ljava/lang/String;
    //   927: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: pop
    //   931: aload 8
    //   933: ldc_w 969
    //   936: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: pop
    //   940: aload 8
    //   942: aload 11
    //   944: getfield 1233	com/tencent/msf/service/protocol/push/a/c:b	Ljava/lang/String;
    //   947: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: pop
    //   951: aload 8
    //   953: ldc_w 969
    //   956: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: pop
    //   960: aload 8
    //   962: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   965: astore 8
    //   967: aload 8
    //   969: astore 7
    //   971: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   974: ifeq -98 -> 876
    //   977: new 241	java/lang/StringBuilder
    //   980: dup
    //   981: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   984: astore 7
    //   986: aload 7
    //   988: ldc_w 1235
    //   991: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: pop
    //   995: aload 7
    //   997: aload 11
    //   999: getfield 1232	com/tencent/msf/service/protocol/push/a/c:a	Ljava/lang/String;
    //   1002: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: pop
    //   1006: aload 7
    //   1008: ldc_w 1237
    //   1011: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: pop
    //   1015: aload 7
    //   1017: aload 11
    //   1019: getfield 1233	com/tencent/msf/service/protocol/push/a/c:b	Ljava/lang/String;
    //   1022: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: pop
    //   1026: ldc 255
    //   1028: iconst_4
    //   1029: aload 7
    //   1031: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1034: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1037: aload 8
    //   1039: astore 7
    //   1041: goto -165 -> 876
    //   1044: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1047: ifeq +40 -> 1087
    //   1050: new 241	java/lang/StringBuilder
    //   1053: dup
    //   1054: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1057: astore 8
    //   1059: aload 8
    //   1061: ldc_w 1239
    //   1064: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: pop
    //   1068: aload 8
    //   1070: aload 7
    //   1072: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: pop
    //   1076: ldc 255
    //   1078: iconst_2
    //   1079: aload 8
    //   1081: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1084: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1087: aload 9
    //   1089: aload 7
    //   1091: invokevirtual 1240	com/tencent/mobileqq/msf/core/net/c/i:a	(Ljava/lang/String;)V
    //   1094: aload 9
    //   1096: invokevirtual 1242	com/tencent/mobileqq/msf/core/net/c/i:b	()Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   1099: astore 8
    //   1101: aload 8
    //   1103: ifnull +243 -> 1346
    //   1106: aload 8
    //   1108: getfield 1224	com/tencent/mobileqq/msf/core/net/c/i$a:b	Z
    //   1111: ifeq +235 -> 1346
    //   1114: aload 8
    //   1116: getfield 1226	com/tencent/mobileqq/msf/core/net/c/i$a:d	Ljava/lang/String;
    //   1119: astore 7
    //   1121: aload 7
    //   1123: astore 6
    //   1125: aload 8
    //   1127: getfield 1227	com/tencent/mobileqq/msf/core/net/c/i$a:c	Ljava/lang/String;
    //   1130: invokestatic 728	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1133: ifne -363 -> 770
    //   1136: aload_0
    //   1137: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1140: aload 8
    //   1142: getfield 1227	com/tencent/mobileqq/msf/core/net/c/i$a:c	Ljava/lang/String;
    //   1145: putfield 1207	com/tencent/mobileqq/msf/core/net/c/c$e:K	Ljava/lang/String;
    //   1148: aload 7
    //   1150: astore 6
    //   1152: goto -382 -> 770
    //   1155: aload_0
    //   1156: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1159: aload 6
    //   1161: invokestatic 423	com/tencent/qphone/base/util/g:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1164: putfield 1244	com/tencent/mobileqq/msf/core/net/c/c$e:R	Ljava/lang/String;
    //   1167: aload_0
    //   1168: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1171: aload_0
    //   1172: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1175: getfield 1244	com/tencent/mobileqq/msf/core/net/c/c$e:R	Ljava/lang/String;
    //   1178: invokevirtual 426	java/lang/String:length	()I
    //   1181: putfield 1246	com/tencent/mobileqq/msf/core/net/c/c$e:Q	I
    //   1184: aload_0
    //   1185: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1188: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   1191: putfield 382	com/tencent/mobileqq/msf/core/net/c/c$e:N	J
    //   1194: iload_2
    //   1195: aload_0
    //   1196: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1199: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   1202: invokevirtual 678	java/util/ArrayList:size	()I
    //   1205: iconst_1
    //   1206: isub
    //   1207: if_icmpne +145 -> 1352
    //   1210: iconst_1
    //   1211: istore 5
    //   1213: goto +3 -> 1216
    //   1216: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1219: ifeq +57 -> 1276
    //   1222: new 241	java/lang/StringBuilder
    //   1225: dup
    //   1226: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1229: astore 6
    //   1231: aload 6
    //   1233: ldc_w 1248
    //   1236: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1239: pop
    //   1240: aload 6
    //   1242: iload 4
    //   1244: invokevirtual 1251	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1247: pop
    //   1248: aload 6
    //   1250: ldc_w 1253
    //   1253: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: pop
    //   1257: aload 6
    //   1259: iload 5
    //   1261: invokevirtual 1251	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1264: pop
    //   1265: ldc 255
    //   1267: iconst_2
    //   1268: aload 6
    //   1270: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1273: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1276: iload 4
    //   1278: ifeq +15 -> 1293
    //   1281: aload_0
    //   1282: getstatic 1255	com/tencent/mobileqq/msf/core/net/c/c$e$a:a	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   1285: iload 5
    //   1287: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   1290: goto +12 -> 1302
    //   1293: aload_0
    //   1294: getstatic 1257	com/tencent/mobileqq/msf/core/net/c/c$e$a:b	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   1297: iload 5
    //   1299: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   1302: iload_2
    //   1303: iconst_1
    //   1304: iadd
    //   1305: istore_2
    //   1306: goto -783 -> 523
    //   1309: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1312: return
    //   1313: astore 6
    //   1315: goto +19 -> 1334
    //   1318: astore 6
    //   1320: ldc 255
    //   1322: iconst_1
    //   1323: ldc_w 1259
    //   1326: aload 6
    //   1328: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1331: goto -22 -> 1309
    //   1334: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1337: goto +6 -> 1343
    //   1340: aload 6
    //   1342: athrow
    //   1343: goto -3 -> 1340
    //   1346: iconst_0
    //   1347: istore 4
    //   1349: goto -194 -> 1155
    //   1352: iconst_0
    //   1353: istore 5
    //   1355: goto -139 -> 1216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1358	0	this	c
    //   479	260	1	i1	int
    //   477	829	2	i2	int
    //   533	235	3	i3	int
    //   771	577	4	bool1	boolean
    //   1211	143	5	bool2	boolean
    //   50	405	6	localStringBuilder	StringBuilder
    //   606	15	6	localException1	Exception
    //   719	550	6	localObject1	Object
    //   1313	1	6	localObject2	Object
    //   1318	23	6	localException2	Exception
    //   801	348	7	localObject3	Object
    //   781	360	8	localObject4	Object
    //   742	353	9	locali	i
    //   870	17	10	localIterator	Iterator
    //   896	122	11	localc	com.tencent.msf.service.protocol.push.a.c
    // Exception table:
    //   from	to	target	type
    //   539	603	606	java/lang/Exception
    //   523	534	1313	finally
    //   539	603	1313	finally
    //   608	625	1313	finally
    //   625	686	1313	finally
    //   686	700	1313	finally
    //   700	756	1313	finally
    //   776	783	1313	finally
    //   788	803	1313	finally
    //   807	830	1313	finally
    //   837	872	1313	finally
    //   876	898	1313	finally
    //   903	967	1313	finally
    //   971	1037	1313	finally
    //   1044	1087	1313	finally
    //   1087	1094	1313	finally
    //   1094	1101	1313	finally
    //   1106	1121	1313	finally
    //   1125	1148	1313	finally
    //   1155	1210	1313	finally
    //   1216	1276	1313	finally
    //   1281	1290	1313	finally
    //   1293	1302	1313	finally
    //   1320	1331	1313	finally
    //   523	534	1318	java/lang/Exception
    //   608	625	1318	java/lang/Exception
    //   625	686	1318	java/lang/Exception
    //   686	700	1318	java/lang/Exception
    //   700	756	1318	java/lang/Exception
    //   776	783	1318	java/lang/Exception
    //   788	803	1318	java/lang/Exception
    //   807	830	1318	java/lang/Exception
    //   837	872	1318	java/lang/Exception
    //   876	898	1318	java/lang/Exception
    //   903	967	1318	java/lang/Exception
    //   971	1037	1318	java/lang/Exception
    //   1044	1087	1318	java/lang/Exception
    //   1087	1094	1318	java/lang/Exception
    //   1094	1101	1318	java/lang/Exception
    //   1106	1121	1318	java/lang/Exception
    //   1125	1148	1318	java/lang/Exception
    //   1155	1210	1318	java/lang/Exception
    //   1216	1276	1318	java/lang/Exception
    //   1281	1290	1318	java/lang/Exception
    //   1293	1302	1318	java/lang/Exception
  }
  
  private void j()
  {
    this.q.d = this.b.j;
    this.q.e = this.b.o;
    this.q.f = this.b.k;
    this.q.g = this.b.l;
    this.q.h = this.b.m;
    this.q.a = c.d.a.a;
    this.q.i = this.b.u;
    Object localObject = f();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      this.q.j = ((InetAddress)((ArrayList)localObject).get(0)).getHostAddress();
    } else if (QLog.isColorLevel()) {
      QLog.d("MSF.C.QualityTestManager", 2, "mDnses is null");
    }
    if (0L != o.h)
    {
      this.q.l = o.h;
      localObject = this.q;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(o.i);
      localStringBuilder.append(",");
      localStringBuilder.append(o.j);
      ((c.d)localObject).m = localStringBuilder.toString();
    }
  }
  
  private boolean k()
  {
    if ((this.b.g == null) && (this.b.g.length <= 0)) {
      return false;
    }
    String[] arrayOfString = new String(this.b.g).split("\r\n");
    int i2 = arrayOfString.length;
    Object localObject2 = "";
    Object localObject1 = localObject2;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = arrayOfString[i1];
      Object localObject4;
      if (((str.startsWith("Cookie:")) && (str.contains("md5="))) || ((str.startsWith("Set-Cookie:")) && (str.contains("md5="))))
      {
        int i4 = str.indexOf("md5=");
        int i3 = str.indexOf(";", i4);
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (i4 != -1)
        {
          i4 += 4;
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (i3 > i4)
          {
            localObject4 = str.substring(i4, i3);
            localObject3 = localObject2;
          }
        }
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append("\r\n");
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = localObject1;
      }
      i1 += 1;
      localObject2 = localObject3;
      localObject1 = localObject4;
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("\r\n");
    return localObject1.equals(MD5.toMD5(((StringBuilder)localObject3).toString()));
  }
  
  /* Error */
  private void l()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   4: ifnonnull +15 -> 19
    //   7: aload_0
    //   8: getstatic 1305	com/tencent/mobileqq/msf/core/net/c/c$e$a:o	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   11: iconst_1
    //   12: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   15: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   18: return
    //   19: aload_0
    //   20: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   23: getstatic 1310	com/tencent/mobileqq/msf/core/net/c/c$e$b:b	Lcom/tencent/mobileqq/msf/core/net/c/c$e$b;
    //   26: putfield 1312	com/tencent/mobileqq/msf/core/net/c/c$e:a	Lcom/tencent/mobileqq/msf/core/net/c/c$e$b;
    //   29: aload_0
    //   30: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   33: invokestatic 208	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   36: putfield 883	com/tencent/mobileqq/msf/core/net/c/c$e:g	I
    //   39: aload_0
    //   40: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   43: aload_0
    //   44: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   47: getfield 1313	com/tencent/msf/service/protocol/push/a/b:a	S
    //   50: putfield 1134	com/tencent/mobileqq/msf/core/net/c/c$e:r	I
    //   53: aload_0
    //   54: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   57: aload_0
    //   58: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   61: getfield 1314	com/tencent/msf/service/protocol/push/a/b:g	J
    //   64: putfield 1315	com/tencent/mobileqq/msf/core/net/c/c$e:s	J
    //   67: aload_0
    //   68: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   71: aload_0
    //   72: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   75: getfield 1316	com/tencent/msf/service/protocol/push/a/b:f	J
    //   78: putfield 1317	com/tencent/mobileqq/msf/core/net/c/c$e:t	J
    //   81: aload_0
    //   82: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   85: new 346	java/util/ArrayList
    //   88: dup
    //   89: invokespecial 868	java/util/ArrayList:<init>	()V
    //   92: putfield 1319	com/tencent/mobileqq/msf/core/net/c/c$e:u	Ljava/util/ArrayList;
    //   95: iconst_0
    //   96: istore_1
    //   97: iload_1
    //   98: aload_0
    //   99: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   102: getfield 1321	com/tencent/msf/service/protocol/push/a/b:d	Ljava/util/ArrayList;
    //   105: invokevirtual 678	java/util/ArrayList:size	()I
    //   108: if_icmpge +32 -> 140
    //   111: aload_0
    //   112: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   115: getfield 1319	com/tencent/mobileqq/msf/core/net/c/c$e:u	Ljava/util/ArrayList;
    //   118: aload_0
    //   119: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   122: getfield 1321	com/tencent/msf/service/protocol/push/a/b:d	Ljava/util/ArrayList;
    //   125: iload_1
    //   126: invokevirtual 1203	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   129: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   132: pop
    //   133: iload_1
    //   134: iconst_1
    //   135: iadd
    //   136: istore_1
    //   137: goto -40 -> 97
    //   140: aload_0
    //   141: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   144: aload_0
    //   145: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   148: getfield 1322	com/tencent/msf/service/protocol/push/a/b:h	J
    //   151: putfield 1323	com/tencent/mobileqq/msf/core/net/c/c$e:w	J
    //   154: aload_0
    //   155: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   158: new 346	java/util/ArrayList
    //   161: dup
    //   162: invokespecial 868	java/util/ArrayList:<init>	()V
    //   165: putfield 1324	com/tencent/mobileqq/msf/core/net/c/c$e:v	Ljava/util/ArrayList;
    //   168: new 241	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   175: astore 15
    //   177: aload 15
    //   179: ldc_w 1326
    //   182: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 15
    //   188: aload_0
    //   189: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   192: getfield 1316	com/tencent/msf/service/protocol/push/a/b:f	J
    //   195: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 15
    //   201: ldc_w 1138
    //   204: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 15
    //   210: aload_0
    //   211: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   214: getfield 1327	com/tencent/msf/service/protocol/push/a/b:b	Ljava/util/ArrayList;
    //   217: invokevirtual 678	java/util/ArrayList:size	()I
    //   220: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 15
    //   226: ldc_w 1329
    //   229: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 15
    //   235: aload_0
    //   236: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   239: getfield 1331	com/tencent/msf/service/protocol/push/a/b:c	Ljava/util/ArrayList;
    //   242: invokevirtual 678	java/util/ArrayList:size	()I
    //   245: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 15
    //   251: ldc_w 1333
    //   254: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 15
    //   260: aload_0
    //   261: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   264: getfield 1314	com/tencent/msf/service/protocol/push/a/b:g	J
    //   267: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: ldc 255
    //   273: iconst_1
    //   274: aload 15
    //   276: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aload_0
    //   283: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   286: getfield 1327	com/tencent/msf/service/protocol/push/a/b:b	Ljava/util/ArrayList;
    //   289: invokevirtual 678	java/util/ArrayList:size	()I
    //   292: bipush 75
    //   294: if_icmple +35 -> 329
    //   297: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   300: ifeq +12 -> 312
    //   303: ldc 255
    //   305: iconst_4
    //   306: ldc_w 1166
    //   309: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: aload_0
    //   313: iconst_0
    //   314: putfield 134	com/tencent/mobileqq/msf/core/net/c/c:V	Z
    //   317: aload_0
    //   318: getstatic 1168	com/tencent/mobileqq/msf/core/net/c/c$e$a:m	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   321: iconst_1
    //   322: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   325: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   328: return
    //   329: aload_0
    //   330: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   333: getfield 1327	com/tencent/msf/service/protocol/push/a/b:b	Ljava/util/ArrayList;
    //   336: invokevirtual 678	java/util/ArrayList:size	()I
    //   339: ifgt +30 -> 369
    //   342: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   345: ifeq +12 -> 357
    //   348: ldc 255
    //   350: iconst_4
    //   351: ldc_w 1170
    //   354: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: aload_0
    //   358: getstatic 1172	com/tencent/mobileqq/msf/core/net/c/c$e$a:n	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   361: iconst_1
    //   362: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   365: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   368: return
    //   369: aload_0
    //   370: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   373: getfield 1314	com/tencent/msf/service/protocol/push/a/b:g	J
    //   376: ldc2_w 1334
    //   379: lcmp
    //   380: ifle +35 -> 415
    //   383: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   386: ifeq +12 -> 398
    //   389: ldc 255
    //   391: iconst_4
    //   392: ldc_w 1337
    //   395: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload_0
    //   399: iconst_0
    //   400: putfield 134	com/tencent/mobileqq/msf/core/net/c/c:V	Z
    //   403: aload_0
    //   404: getstatic 1339	com/tencent/mobileqq/msf/core/net/c/c$e$a:l	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   407: iconst_1
    //   408: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   411: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   414: return
    //   415: aload_0
    //   416: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   419: getfield 1322	com/tencent/msf/service/protocol/push/a/b:h	J
    //   422: ldc2_w 1175
    //   425: lmul
    //   426: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   429: lcmp
    //   430: ifge +81 -> 511
    //   433: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   436: ifeq +63 -> 499
    //   439: new 241	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   446: astore 15
    //   448: aload 15
    //   450: ldc_w 1341
    //   453: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload 15
    //   459: aload_0
    //   460: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   463: getfield 1322	com/tencent/msf/service/protocol/push/a/b:h	J
    //   466: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload 15
    //   472: ldc_w 1180
    //   475: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload 15
    //   481: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   484: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: ldc 255
    //   490: iconst_4
    //   491: aload 15
    //   493: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   499: aload_0
    //   500: getstatic 1182	com/tencent/mobileqq/msf/core/net/c/c$e$a:j	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   503: iconst_1
    //   504: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   507: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   510: return
    //   511: aload_0
    //   512: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   515: getfield 1343	com/tencent/msf/service/protocol/push/a/b:e	Ljava/util/ArrayList;
    //   518: invokevirtual 678	java/util/ArrayList:size	()I
    //   521: aload_0
    //   522: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   525: getfield 1321	com/tencent/msf/service/protocol/push/a/b:d	Ljava/util/ArrayList;
    //   528: invokevirtual 678	java/util/ArrayList:size	()I
    //   531: if_icmpne +1271 -> 1802
    //   534: aload_0
    //   535: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   538: getfield 1331	com/tencent/msf/service/protocol/push/a/b:c	Ljava/util/ArrayList;
    //   541: invokevirtual 678	java/util/ArrayList:size	()I
    //   544: aload_0
    //   545: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   548: getfield 1321	com/tencent/msf/service/protocol/push/a/b:d	Ljava/util/ArrayList;
    //   551: invokevirtual 678	java/util/ArrayList:size	()I
    //   554: if_icmpeq +6 -> 560
    //   557: goto +1245 -> 1802
    //   560: aload_0
    //   561: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   564: getfield 1314	com/tencent/msf/service/protocol/push/a/b:g	J
    //   567: lconst_0
    //   568: lcmp
    //   569: ifgt +63 -> 632
    //   572: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   575: ifeq +45 -> 620
    //   578: new 241	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   585: astore 15
    //   587: aload 15
    //   589: ldc_w 1345
    //   592: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload 15
    //   598: aload_0
    //   599: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   602: getfield 1314	com/tencent/msf/service/protocol/push/a/b:g	J
    //   605: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   608: pop
    //   609: ldc 255
    //   611: iconst_4
    //   612: aload 15
    //   614: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   620: aload_0
    //   621: getstatic 273	com/tencent/mobileqq/msf/core/net/c/c$e$a:i	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   624: iconst_1
    //   625: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   628: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   631: return
    //   632: aload_0
    //   633: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   636: getfield 1314	com/tencent/msf/service/protocol/push/a/b:g	J
    //   639: aload_0
    //   640: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   643: getfield 1331	com/tencent/msf/service/protocol/push/a/b:c	Ljava/util/ArrayList;
    //   646: invokevirtual 678	java/util/ArrayList:size	()I
    //   649: i2l
    //   650: lmul
    //   651: ldc2_w 1334
    //   654: lcmp
    //   655: ifle +35 -> 690
    //   658: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   661: ifeq +12 -> 673
    //   664: ldc 255
    //   666: iconst_4
    //   667: ldc_w 1337
    //   670: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   673: aload_0
    //   674: iconst_0
    //   675: putfield 134	com/tencent/mobileqq/msf/core/net/c/c:V	Z
    //   678: aload_0
    //   679: getstatic 1339	com/tencent/mobileqq/msf/core/net/c/c$e$a:l	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   682: iconst_1
    //   683: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   686: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   689: return
    //   690: iconst_0
    //   691: istore_2
    //   692: iload_2
    //   693: aload_0
    //   694: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   697: getfield 1327	com/tencent/msf/service/protocol/push/a/b:b	Ljava/util/ArrayList;
    //   700: invokevirtual 678	java/util/ArrayList:size	()I
    //   703: if_icmpge +1068 -> 1771
    //   706: aload_0
    //   707: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   710: new 346	java/util/ArrayList
    //   713: dup
    //   714: invokespecial 868	java/util/ArrayList:<init>	()V
    //   717: putfield 1347	com/tencent/mobileqq/msf/core/net/c/c$e:y	Ljava/util/ArrayList;
    //   720: aload_0
    //   721: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   724: iconst_0
    //   725: putfield 391	com/tencent/mobileqq/msf/core/net/c/c$e:k	I
    //   728: aload_0
    //   729: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   732: iconst_0
    //   733: putfield 472	com/tencent/mobileqq/msf/core/net/c/c$e:n	I
    //   736: aload_0
    //   737: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   740: iconst_0
    //   741: putfield 792	com/tencent/mobileqq/msf/core/net/c/c$e:l	I
    //   744: aload_0
    //   745: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   748: iconst_0
    //   749: putfield 454	com/tencent/mobileqq/msf/core/net/c/c$e:m	I
    //   752: aload_0
    //   753: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   756: iconst_0
    //   757: putfield 750	com/tencent/mobileqq/msf/core/net/c/c$e:o	I
    //   760: aload_0
    //   761: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   764: getfield 178	com/tencent/mobileqq/msf/core/net/c/c$e:c	Ljava/util/Map;
    //   767: invokeinterface 1212 1 0
    //   772: aload_0
    //   773: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   776: getfield 1324	com/tencent/mobileqq/msf/core/net/c/c$e:v	Ljava/util/ArrayList;
    //   779: invokevirtual 1348	java/util/ArrayList:clear	()V
    //   782: aload_0
    //   783: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   786: invokestatic 1188	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getWifiStrength	()I
    //   789: putfield 1190	com/tencent/mobileqq/msf/core/net/c/c$e:h	I
    //   792: aload_0
    //   793: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   796: invokestatic 1193	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getCdmaStrength	()I
    //   799: putfield 1195	com/tencent/mobileqq/msf/core/net/c/c$e:j	I
    //   802: aload_0
    //   803: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   806: invokestatic 1198	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getGsmStrength	()I
    //   809: putfield 1200	com/tencent/mobileqq/msf/core/net/c/c$e:i	I
    //   812: goto +1022 -> 1834
    //   815: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   818: ifeq +1016 -> 1834
    //   821: ldc 255
    //   823: iconst_4
    //   824: ldc_w 1350
    //   827: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   830: goto +1004 -> 1834
    //   833: iload_3
    //   834: aload_0
    //   835: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   838: getfield 1331	com/tencent/msf/service/protocol/push/a/b:c	Ljava/util/ArrayList;
    //   841: invokevirtual 678	java/util/ArrayList:size	()I
    //   844: if_icmpge +885 -> 1729
    //   847: aload_0
    //   848: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   851: getfield 1331	com/tencent/msf/service/protocol/push/a/b:c	Ljava/util/ArrayList;
    //   854: iload_3
    //   855: invokevirtual 1203	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   858: checkcast 1351	[B
    //   861: arraylength
    //   862: bipush 8
    //   864: if_icmpge +28 -> 892
    //   867: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   870: ifeq +12 -> 882
    //   873: ldc 255
    //   875: iconst_4
    //   876: ldc_w 1353
    //   879: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   882: aload_0
    //   883: getstatic 273	com/tencent/mobileqq/msf/core/net/c/c$e$a:i	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   886: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/c:a	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;)V
    //   889: goto +958 -> 1847
    //   892: aload_0
    //   893: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   896: getfield 1343	com/tencent/msf/service/protocol/push/a/b:e	Ljava/util/ArrayList;
    //   899: iload_3
    //   900: invokevirtual 1203	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   903: ifnull +938 -> 1841
    //   906: aload_0
    //   907: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   910: getfield 1343	com/tencent/msf/service/protocol/push/a/b:e	Ljava/util/ArrayList;
    //   913: iload_3
    //   914: invokevirtual 1203	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   917: checkcast 1351	[B
    //   920: arraylength
    //   921: ifle +920 -> 1841
    //   924: aload_0
    //   925: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   928: getfield 1343	com/tencent/msf/service/protocol/push/a/b:e	Ljava/util/ArrayList;
    //   931: iload_3
    //   932: invokevirtual 1203	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   935: checkcast 1351	[B
    //   938: arraylength
    //   939: istore 4
    //   941: goto +3 -> 944
    //   944: iload 4
    //   946: i2l
    //   947: lstore 8
    //   949: aload_0
    //   950: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   953: getfield 1331	com/tencent/msf/service/protocol/push/a/b:c	Ljava/util/ArrayList;
    //   956: iload_3
    //   957: invokevirtual 1203	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   960: checkcast 1351	[B
    //   963: arraylength
    //   964: i2l
    //   965: lstore 10
    //   967: aload_0
    //   968: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   971: getfield 1321	com/tencent/msf/service/protocol/push/a/b:d	Ljava/util/ArrayList;
    //   974: iload_3
    //   975: invokevirtual 1203	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   978: checkcast 386	java/lang/Long
    //   981: invokevirtual 1356	java/lang/Long:longValue	()J
    //   984: lstore 12
    //   986: lload 10
    //   988: invokestatic 1360	java/lang/Long:signum	(J)I
    //   991: pop
    //   992: lload 8
    //   994: lload 10
    //   996: lload 12
    //   998: lmul
    //   999: ladd
    //   1000: l2i
    //   1001: istore 6
    //   1003: new 241	java/lang/StringBuilder
    //   1006: dup
    //   1007: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1010: astore 15
    //   1012: aload 15
    //   1014: ldc_w 1362
    //   1017: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: pop
    //   1021: aload 15
    //   1023: iload 6
    //   1025: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1028: pop
    //   1029: ldc 255
    //   1031: iconst_1
    //   1032: aload 15
    //   1034: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1037: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1040: iload 6
    //   1042: ldc_w 1363
    //   1045: if_icmple +74 -> 1119
    //   1048: aload_0
    //   1049: getfield 166	com/tencent/mobileqq/msf/core/net/c/c:a	Lcom/tencent/mobileqq/msf/core/net/c/c$b;
    //   1052: getstatic 1364	com/tencent/mobileqq/msf/core/net/c/c$b:a	Lcom/tencent/mobileqq/msf/core/net/c/c$b;
    //   1055: if_acmpne +64 -> 1119
    //   1058: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1061: ifeq +48 -> 1109
    //   1064: new 241	java/lang/StringBuilder
    //   1067: dup
    //   1068: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1071: astore 15
    //   1073: aload 15
    //   1075: ldc 244
    //   1077: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: pop
    //   1081: aload 15
    //   1083: iload 6
    //   1085: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1088: pop
    //   1089: aload 15
    //   1091: ldc_w 1366
    //   1094: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: pop
    //   1098: ldc 255
    //   1100: iconst_4
    //   1101: aload 15
    //   1103: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1106: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1109: aload_0
    //   1110: getstatic 264	com/tencent/mobileqq/msf/core/net/c/c$e$a:h	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   1113: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/c:a	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;)V
    //   1116: goto +731 -> 1847
    //   1119: iload 6
    //   1121: ldc_w 1363
    //   1124: if_icmple +69 -> 1193
    //   1127: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1130: ifeq +48 -> 1178
    //   1133: new 241	java/lang/StringBuilder
    //   1136: dup
    //   1137: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1140: astore 15
    //   1142: aload 15
    //   1144: ldc 244
    //   1146: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: pop
    //   1150: aload 15
    //   1152: iload 6
    //   1154: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1157: pop
    //   1158: aload 15
    //   1160: ldc_w 1366
    //   1163: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: pop
    //   1167: ldc 255
    //   1169: iconst_4
    //   1170: aload 15
    //   1172: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1175: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1178: aload_0
    //   1179: iconst_0
    //   1180: putfield 134	com/tencent/mobileqq/msf/core/net/c/c:V	Z
    //   1183: aload_0
    //   1184: getstatic 264	com/tencent/mobileqq/msf/core/net/c/c$e$a:h	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   1187: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/c:a	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;)V
    //   1190: goto +657 -> 1847
    //   1193: aload_0
    //   1194: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1197: getfield 1316	com/tencent/msf/service/protocol/push/a/b:f	J
    //   1200: ldc2_w 1367
    //   1203: lcmp
    //   1204: ifge +646 -> 1850
    //   1207: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1210: ifeq +54 -> 1264
    //   1213: new 241	java/lang/StringBuilder
    //   1216: dup
    //   1217: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1220: astore 15
    //   1222: aload 15
    //   1224: ldc_w 1370
    //   1227: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: pop
    //   1231: aload 15
    //   1233: aload_0
    //   1234: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1237: getfield 1316	com/tencent/msf/service/protocol/push/a/b:f	J
    //   1240: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1243: pop
    //   1244: aload 15
    //   1246: ldc_w 1366
    //   1249: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: pop
    //   1253: ldc 255
    //   1255: iconst_4
    //   1256: aload 15
    //   1258: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1261: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1264: aload_0
    //   1265: getstatic 1372	com/tencent/mobileqq/msf/core/net/c/c$e$a:g	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   1268: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/c:a	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;)V
    //   1271: goto +576 -> 1847
    //   1274: iload 4
    //   1276: i2l
    //   1277: aload_0
    //   1278: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1281: getfield 1314	com/tencent/msf/service/protocol/push/a/b:g	J
    //   1284: lcmp
    //   1285: ifge +591 -> 1876
    //   1288: iload_1
    //   1289: ifne +74 -> 1363
    //   1292: aload_0
    //   1293: aload_0
    //   1294: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1297: getfield 1327	com/tencent/msf/service/protocol/push/a/b:b	Ljava/util/ArrayList;
    //   1300: iload_2
    //   1301: invokevirtual 1203	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1304: checkcast 597	com/tencent/msf/service/protocol/push/a/a
    //   1307: invokespecial 1374	com/tencent/mobileqq/msf/core/net/c/c:a	(Lcom/tencent/msf/service/protocol/push/a/a;)Z
    //   1310: ifne +28 -> 1338
    //   1313: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1316: ifeq +12 -> 1328
    //   1319: ldc 255
    //   1321: iconst_4
    //   1322: ldc_w 1376
    //   1325: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1328: aload_0
    //   1329: getstatic 1378	com/tencent/mobileqq/msf/core/net/c/c$e$a:c	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   1332: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/c:a	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;)V
    //   1335: goto +532 -> 1867
    //   1338: aload_0
    //   1339: lconst_0
    //   1340: putfield 154	com/tencent/mobileqq/msf/core/net/c/c:A	J
    //   1343: aload_0
    //   1344: lconst_0
    //   1345: putfield 158	com/tencent/mobileqq/msf/core/net/c/c:C	J
    //   1348: aload_0
    //   1349: lconst_0
    //   1350: putfield 156	com/tencent/mobileqq/msf/core/net/c/c:B	J
    //   1353: aload_0
    //   1354: lconst_0
    //   1355: putfield 160	com/tencent/mobileqq/msf/core/net/c/c:D	J
    //   1358: iconst_1
    //   1359: istore_1
    //   1360: goto +3 -> 1363
    //   1363: iload 6
    //   1365: invokestatic 815	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1368: astore 15
    //   1370: iload 6
    //   1372: newarray byte
    //   1374: astore 16
    //   1376: aload_0
    //   1377: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1380: getfield 1343	com/tencent/msf/service/protocol/push/a/b:e	Ljava/util/ArrayList;
    //   1383: iload_3
    //   1384: invokevirtual 1203	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1387: ifnull +469 -> 1856
    //   1390: aload_0
    //   1391: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1394: getfield 1343	com/tencent/msf/service/protocol/push/a/b:e	Ljava/util/ArrayList;
    //   1397: iload_3
    //   1398: invokevirtual 1203	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1401: checkcast 1351	[B
    //   1404: arraylength
    //   1405: ifle +451 -> 1856
    //   1408: aload 15
    //   1410: aload_0
    //   1411: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1414: getfield 1343	com/tencent/msf/service/protocol/push/a/b:e	Ljava/util/ArrayList;
    //   1417: iload_3
    //   1418: invokevirtual 1203	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1421: checkcast 1351	[B
    //   1424: invokevirtual 818	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   1427: pop
    //   1428: goto +428 -> 1856
    //   1431: iload 5
    //   1433: i2l
    //   1434: aload_0
    //   1435: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1438: getfield 1321	com/tencent/msf/service/protocol/push/a/b:d	Ljava/util/ArrayList;
    //   1441: iload_3
    //   1442: invokevirtual 1203	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1445: checkcast 386	java/lang/Long
    //   1448: invokevirtual 1356	java/lang/Long:longValue	()J
    //   1451: lcmp
    //   1452: ifge +32 -> 1484
    //   1455: aload 15
    //   1457: aload_0
    //   1458: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1461: getfield 1331	com/tencent/msf/service/protocol/push/a/b:c	Ljava/util/ArrayList;
    //   1464: iload_3
    //   1465: invokevirtual 1203	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1468: checkcast 1351	[B
    //   1471: invokevirtual 818	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   1474: pop
    //   1475: iload 5
    //   1477: iconst_1
    //   1478: iadd
    //   1479: istore 5
    //   1481: goto -50 -> 1431
    //   1484: aload 15
    //   1486: invokevirtual 824	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   1489: pop
    //   1490: aload 15
    //   1492: aload 16
    //   1494: invokevirtual 826	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1497: pop
    //   1498: aload 16
    //   1500: arraylength
    //   1501: istore 5
    //   1503: aload 16
    //   1505: iconst_0
    //   1506: invokestatic 511	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   1509: istore 7
    //   1511: iload 7
    //   1513: iload 5
    //   1515: if_icmpeq +73 -> 1588
    //   1518: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1521: ifeq +57 -> 1578
    //   1524: new 241	java/lang/StringBuilder
    //   1527: dup
    //   1528: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1531: astore 15
    //   1533: aload 15
    //   1535: ldc_w 834
    //   1538: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1541: pop
    //   1542: aload 15
    //   1544: iload 7
    //   1546: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1549: pop
    //   1550: aload 15
    //   1552: ldc_w 836
    //   1555: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1558: pop
    //   1559: aload 15
    //   1561: iload 5
    //   1563: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1566: pop
    //   1567: ldc 255
    //   1569: iconst_4
    //   1570: aload 15
    //   1572: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1575: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1578: aload_0
    //   1579: getstatic 838	com/tencent/mobileqq/msf/core/net/c/c$e$a:f	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   1582: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/c:a	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;)V
    //   1585: goto +125 -> 1710
    //   1588: aload_0
    //   1589: aload 16
    //   1591: invokespecial 1380	com/tencent/mobileqq/msf/core/net/c/c:a	([B)Z
    //   1594: ifne +6 -> 1600
    //   1597: goto +265 -> 1862
    //   1600: aload_0
    //   1601: aload 16
    //   1603: arraylength
    //   1604: aload 16
    //   1606: invokespecial 1382	com/tencent/mobileqq/msf/core/net/c/c:a	(I[B)Z
    //   1609: ifne +46 -> 1655
    //   1612: aload_0
    //   1613: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1616: getfield 1324	com/tencent/mobileqq/msf/core/net/c/c$e:v	Ljava/util/ArrayList;
    //   1619: aload 16
    //   1621: arraylength
    //   1622: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1625: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1628: pop
    //   1629: goto +233 -> 1862
    //   1632: astore 15
    //   1634: goto +5 -> 1639
    //   1637: astore 15
    //   1639: ldc 255
    //   1641: iconst_1
    //   1642: ldc_w 1384
    //   1645: aload 15
    //   1647: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1650: aload 15
    //   1652: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   1655: aload_0
    //   1656: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1659: getfield 1316	com/tencent/msf/service/protocol/push/a/b:f	J
    //   1662: invokestatic 1390	java/lang/Thread:sleep	(J)V
    //   1665: goto +202 -> 1867
    //   1668: astore 15
    //   1670: new 241	java/lang/StringBuilder
    //   1673: dup
    //   1674: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1677: astore 16
    //   1679: aload 16
    //   1681: ldc_w 1392
    //   1684: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1687: pop
    //   1688: aload 16
    //   1690: aload 15
    //   1692: invokevirtual 523	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1695: pop
    //   1696: ldc 255
    //   1698: iconst_1
    //   1699: aload 16
    //   1701: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1704: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1707: goto +160 -> 1867
    //   1710: aload_0
    //   1711: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1714: getfield 1347	com/tencent/mobileqq/msf/core/net/c/c$e:y	Ljava/util/ArrayList;
    //   1717: iload 6
    //   1719: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1722: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1725: pop
    //   1726: goto +153 -> 1879
    //   1729: aload_0
    //   1730: invokespecial 1394	com/tencent/mobileqq/msf/core/net/c/c:h	()V
    //   1733: iload_2
    //   1734: aload_0
    //   1735: getfield 168	com/tencent/mobileqq/msf/core/net/c/c:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1738: getfield 1327	com/tencent/msf/service/protocol/push/a/b:b	Ljava/util/ArrayList;
    //   1741: invokevirtual 678	java/util/ArrayList:size	()I
    //   1744: iconst_1
    //   1745: isub
    //   1746: if_icmpne +140 -> 1886
    //   1749: iconst_1
    //   1750: istore 14
    //   1752: goto +3 -> 1755
    //   1755: aload_0
    //   1756: getstatic 1255	com/tencent/mobileqq/msf/core/net/c/c$e$a:a	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   1759: iload 14
    //   1761: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   1764: iload_2
    //   1765: iconst_1
    //   1766: iadd
    //   1767: istore_2
    //   1768: goto -1076 -> 692
    //   1771: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1774: return
    //   1775: astore 15
    //   1777: goto +19 -> 1796
    //   1780: astore 15
    //   1782: ldc 255
    //   1784: iconst_1
    //   1785: ldc_w 1396
    //   1788: aload 15
    //   1790: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1793: goto -22 -> 1771
    //   1796: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1799: aload 15
    //   1801: athrow
    //   1802: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1805: ifeq +12 -> 1817
    //   1808: ldc 255
    //   1810: iconst_4
    //   1811: ldc_w 1398
    //   1814: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1817: aload_0
    //   1818: getstatic 273	com/tencent/mobileqq/msf/core/net/c/c$e$a:i	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   1821: iconst_1
    //   1822: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   1825: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1828: return
    //   1829: astore 15
    //   1831: goto -1016 -> 815
    //   1834: iconst_0
    //   1835: istore_1
    //   1836: iconst_0
    //   1837: istore_3
    //   1838: goto -1005 -> 833
    //   1841: iconst_0
    //   1842: istore 4
    //   1844: goto -900 -> 944
    //   1847: goto +32 -> 1879
    //   1850: iconst_0
    //   1851: istore 4
    //   1853: goto -579 -> 1274
    //   1856: iconst_0
    //   1857: istore 5
    //   1859: goto -428 -> 1431
    //   1862: iconst_0
    //   1863: istore_1
    //   1864: goto +3 -> 1867
    //   1867: iload 4
    //   1869: iconst_1
    //   1870: iadd
    //   1871: istore 4
    //   1873: goto -599 -> 1274
    //   1876: goto -166 -> 1710
    //   1879: iload_3
    //   1880: iconst_1
    //   1881: iadd
    //   1882: istore_3
    //   1883: goto -1050 -> 833
    //   1886: iconst_0
    //   1887: istore 14
    //   1889: goto -134 -> 1755
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1892	0	this	c
    //   96	1768	1	i1	int
    //   691	1077	2	i2	int
    //   833	1050	3	i3	int
    //   939	933	4	i4	int
    //   1431	427	5	i5	int
    //   1001	717	6	i6	int
    //   1509	36	7	i7	int
    //   947	46	8	l1	long
    //   965	30	10	l2	long
    //   984	13	12	l3	long
    //   1750	138	14	bool	boolean
    //   175	1396	15	localObject1	Object
    //   1632	1	15	localException1	Exception
    //   1637	14	15	localException2	Exception
    //   1668	23	15	localException3	Exception
    //   1775	1	15	localObject2	Object
    //   1780	20	15	localException4	Exception
    //   1829	1	15	localException5	Exception
    //   1374	326	16	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   1503	1511	1632	java/lang/Exception
    //   1518	1578	1632	java/lang/Exception
    //   1578	1585	1632	java/lang/Exception
    //   1588	1597	1632	java/lang/Exception
    //   1600	1629	1632	java/lang/Exception
    //   1363	1428	1637	java/lang/Exception
    //   1431	1475	1637	java/lang/Exception
    //   1484	1503	1637	java/lang/Exception
    //   1655	1665	1668	java/lang/Exception
    //   692	782	1775	finally
    //   782	812	1775	finally
    //   815	830	1775	finally
    //   833	882	1775	finally
    //   882	889	1775	finally
    //   892	941	1775	finally
    //   949	986	1775	finally
    //   1003	1040	1775	finally
    //   1048	1109	1775	finally
    //   1109	1116	1775	finally
    //   1127	1178	1775	finally
    //   1178	1190	1775	finally
    //   1193	1264	1775	finally
    //   1264	1271	1775	finally
    //   1274	1288	1775	finally
    //   1292	1328	1775	finally
    //   1328	1335	1775	finally
    //   1338	1358	1775	finally
    //   1363	1428	1775	finally
    //   1431	1475	1775	finally
    //   1484	1503	1775	finally
    //   1503	1511	1775	finally
    //   1518	1578	1775	finally
    //   1578	1585	1775	finally
    //   1588	1597	1775	finally
    //   1600	1629	1775	finally
    //   1639	1655	1775	finally
    //   1655	1665	1775	finally
    //   1670	1707	1775	finally
    //   1710	1726	1775	finally
    //   1729	1749	1775	finally
    //   1755	1764	1775	finally
    //   1782	1793	1775	finally
    //   692	782	1780	java/lang/Exception
    //   815	830	1780	java/lang/Exception
    //   833	882	1780	java/lang/Exception
    //   882	889	1780	java/lang/Exception
    //   892	941	1780	java/lang/Exception
    //   949	986	1780	java/lang/Exception
    //   1003	1040	1780	java/lang/Exception
    //   1048	1109	1780	java/lang/Exception
    //   1109	1116	1780	java/lang/Exception
    //   1127	1178	1780	java/lang/Exception
    //   1178	1190	1780	java/lang/Exception
    //   1193	1264	1780	java/lang/Exception
    //   1264	1271	1780	java/lang/Exception
    //   1274	1288	1780	java/lang/Exception
    //   1292	1328	1780	java/lang/Exception
    //   1328	1335	1780	java/lang/Exception
    //   1338	1358	1780	java/lang/Exception
    //   1639	1655	1780	java/lang/Exception
    //   1670	1707	1780	java/lang/Exception
    //   1710	1726	1780	java/lang/Exception
    //   1729	1749	1780	java/lang/Exception
    //   1755	1764	1780	java/lang/Exception
    //   782	812	1829	java/lang/Exception
  }
  
  public String a()
  {
    return this.S;
  }
  
  public void a(c.e.a parama, boolean paramBoolean)
  {
    if (parama == c.e.a.a)
    {
      this.p.b = parama;
    }
    else
    {
      this.p.b = c.e.a.b;
      if (parama != c.e.a.b) {
        a(parama);
      }
    }
    long l1;
    if (((this.a == c.b.c) && (this.l == 1)) || (this.a == c.b.a))
    {
      this.p.p = 0;
    }
    else
    {
      l1 = this.A;
      if (l1 != 0L) {
        this.p.p = ((int)((float)this.B / (float)l1));
      }
    }
    if (this.a == c.b.a)
    {
      this.p.q = 0;
    }
    else
    {
      l1 = this.C;
      if (l1 != 0L) {
        this.p.q = ((int)((float)this.D / (float)l1));
      }
    }
    parama = this.p.toString();
    if (TextUtils.isEmpty(this.S))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.S);
      localStringBuilder.append("(");
      this.S = localStringBuilder.toString();
      if ((this.b != null) && (this.c == null) && (this.q.a == c.d.a.a) && (this.p.a == c.e.b.a))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.S);
        localStringBuilder.append(this.q.toString());
        this.S = localStringBuilder.toString();
      }
    }
    else if ((!this.S.endsWith("#")) && (!this.S.endsWith("(")))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.S);
      localStringBuilder.append("*");
      this.S = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.S);
    localStringBuilder.append(parama);
    this.S = localStringBuilder.toString();
    if (paramBoolean) {
      try
      {
        parama = new StringBuilder();
        parama.append(this.S);
        parama.append(")");
        this.S = parama.toString();
        parama = new CRC32();
        parama.update(this.S.getBytes());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.S);
        localStringBuilder.append(parama.getValue());
        this.S = localStringBuilder.toString();
        return;
      }
      catch (Exception parama)
      {
        parama.printStackTrace();
      }
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
    //   2: putfield 104	com/tencent/mobileqq/msf/core/net/c/c:f	Z
    //   5: aload_0
    //   6: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   9: ifnonnull +15 -> 24
    //   12: aload_0
    //   13: getstatic 1128	com/tencent/mobileqq/msf/core/net/c/c$e$a:k	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   16: iconst_1
    //   17: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   20: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   23: return
    //   24: aload_0
    //   25: invokespecial 1130	com/tencent/mobileqq/msf/core/net/c/c:j	()V
    //   28: aload_0
    //   29: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   32: getstatic 1407	com/tencent/mobileqq/msf/core/net/c/c$e$b:a	Lcom/tencent/mobileqq/msf/core/net/c/c$e$b;
    //   35: putfield 1312	com/tencent/mobileqq/msf/core/net/c/c$e:a	Lcom/tencent/mobileqq/msf/core/net/c/c$e$b;
    //   38: aload_0
    //   39: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   42: aload_0
    //   43: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   46: getfield 1132	com/tencent/msf/service/protocol/push/a/d:a	S
    //   49: putfield 1134	com/tencent/mobileqq/msf/core/net/c/c$e:r	I
    //   52: aload_0
    //   53: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   56: aload_0
    //   57: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   60: getfield 1428	com/tencent/msf/service/protocol/push/a/d:c	J
    //   63: putfield 1315	com/tencent/mobileqq/msf/core/net/c/c$e:s	J
    //   66: aload_0
    //   67: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   70: aload_0
    //   71: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   74: getfield 1429	com/tencent/msf/service/protocol/push/a/d:d	J
    //   77: putfield 1317	com/tencent/mobileqq/msf/core/net/c/c$e:t	J
    //   80: aload_0
    //   81: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   84: new 346	java/util/ArrayList
    //   87: dup
    //   88: invokespecial 868	java/util/ArrayList:<init>	()V
    //   91: putfield 1319	com/tencent/mobileqq/msf/core/net/c/c$e:u	Ljava/util/ArrayList;
    //   94: aload_0
    //   95: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   98: getfield 1319	com/tencent/mobileqq/msf/core/net/c/c$e:u	Ljava/util/ArrayList;
    //   101: aload_0
    //   102: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   105: getfield 820	com/tencent/msf/service/protocol/push/a/d:f	J
    //   108: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   111: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   114: pop
    //   115: aload_0
    //   116: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   119: aload_0
    //   120: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   123: getfield 1174	com/tencent/msf/service/protocol/push/a/d:h	J
    //   126: putfield 1323	com/tencent/mobileqq/msf/core/net/c/c$e:w	J
    //   129: aload_0
    //   130: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   133: aload_0
    //   134: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   137: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   140: i2l
    //   141: putfield 1430	com/tencent/mobileqq/msf/core/net/c/c$e:B	J
    //   144: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +574 -> 721
    //   150: new 241	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   157: astore 17
    //   159: aload 17
    //   161: ldc_w 1432
    //   164: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 17
    //   170: aload_0
    //   171: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   174: getfield 1429	com/tencent/msf/service/protocol/push/a/d:d	J
    //   177: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 17
    //   183: ldc_w 1434
    //   186: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 17
    //   192: aload_0
    //   193: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   196: getfield 1429	com/tencent/msf/service/protocol/push/a/d:d	J
    //   199: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 17
    //   205: ldc_w 1138
    //   208: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 17
    //   214: aload_0
    //   215: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   218: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   221: invokevirtual 678	java/util/ArrayList:size	()I
    //   224: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload 17
    //   230: ldc_w 1333
    //   233: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload 17
    //   239: aload_0
    //   240: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   243: getfield 1428	com/tencent/msf/service/protocol/push/a/d:c	J
    //   246: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 17
    //   252: ldc_w 1436
    //   255: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload_0
    //   260: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   263: getfield 1295	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   266: astore 15
    //   268: ldc_w 1438
    //   271: astore 16
    //   273: aload 15
    //   275: ifnull +19 -> 294
    //   278: aload_0
    //   279: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   282: getfield 1295	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   285: arraylength
    //   286: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   289: astore 15
    //   291: goto +8 -> 299
    //   294: ldc_w 1438
    //   297: astore 15
    //   299: aload 17
    //   301: aload 15
    //   303: invokevirtual 523	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 17
    //   309: ldc_w 1440
    //   312: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_0
    //   317: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   320: getfield 1442	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   323: ifnull +19 -> 342
    //   326: aload_0
    //   327: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   330: getfield 1442	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   333: arraylength
    //   334: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   337: astore 15
    //   339: goto +8 -> 347
    //   342: ldc_w 1438
    //   345: astore 15
    //   347: aload 17
    //   349: aload 15
    //   351: invokevirtual 523	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload 17
    //   357: ldc_w 1444
    //   360: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload 17
    //   366: aload_0
    //   367: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   370: getfield 820	com/tencent/msf/service/protocol/push/a/d:f	J
    //   373: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload 17
    //   379: ldc_w 1446
    //   382: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 16
    //   388: astore 15
    //   390: aload_0
    //   391: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   394: getfield 271	com/tencent/msf/service/protocol/push/a/d:e	[B
    //   397: ifnull +16 -> 413
    //   400: aload_0
    //   401: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   404: getfield 271	com/tencent/msf/service/protocol/push/a/d:e	[B
    //   407: arraylength
    //   408: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   411: astore 15
    //   413: aload 17
    //   415: aload 15
    //   417: invokevirtual 523	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload 17
    //   423: ldc_w 1142
    //   426: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload 17
    //   432: aload_0
    //   433: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   436: getfield 710	com/tencent/msf/service/protocol/push/a/d:r	S
    //   439: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload 17
    //   445: ldc_w 1448
    //   448: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload 17
    //   454: aload_0
    //   455: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   458: getfield 1261	com/tencent/msf/service/protocol/push/a/d:j	J
    //   461: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload 17
    //   467: ldc_w 1450
    //   470: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload 17
    //   476: aload_0
    //   477: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   480: getfield 1267	com/tencent/msf/service/protocol/push/a/d:k	J
    //   483: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 17
    //   489: ldc_w 1452
    //   492: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 17
    //   498: aload_0
    //   499: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   502: getfield 1269	com/tencent/msf/service/protocol/push/a/d:l	J
    //   505: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 17
    //   511: ldc_w 1454
    //   514: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload 17
    //   520: aload_0
    //   521: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   524: getfield 1273	com/tencent/msf/service/protocol/push/a/d:m	J
    //   527: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload 17
    //   533: ldc_w 1456
    //   536: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: aload 17
    //   542: aload_0
    //   543: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   546: getfield 1458	com/tencent/msf/service/protocol/push/a/d:n	J
    //   549: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload 17
    //   555: ldc_w 1460
    //   558: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: aload 17
    //   564: aload_0
    //   565: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   568: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   571: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload 17
    //   577: ldc_w 1146
    //   580: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload 17
    //   586: aload_0
    //   587: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   590: getfield 1148	com/tencent/msf/service/protocol/push/a/d:u	Ljava/lang/String;
    //   593: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload 17
    //   599: ldc_w 1154
    //   602: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload 17
    //   608: aload_0
    //   609: getfield 132	com/tencent/mobileqq/msf/core/net/c/c:q	Lcom/tencent/mobileqq/msf/core/net/c/c$d;
    //   612: getfield 1156	com/tencent/mobileqq/msf/core/net/c/c$d:j	Ljava/lang/String;
    //   615: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload 17
    //   621: ldc_w 1158
    //   624: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload 17
    //   630: aload_0
    //   631: getfield 132	com/tencent/mobileqq/msf/core/net/c/c:q	Lcom/tencent/mobileqq/msf/core/net/c/c$d;
    //   634: getfield 1160	com/tencent/mobileqq/msf/core/net/c/c$d:l	J
    //   637: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: aload 17
    //   643: ldc_w 1162
    //   646: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload 17
    //   652: aload_0
    //   653: getfield 132	com/tencent/mobileqq/msf/core/net/c/c:q	Lcom/tencent/mobileqq/msf/core/net/c/c$d;
    //   656: getfield 1164	com/tencent/mobileqq/msf/core/net/c/c$d:m	Ljava/lang/String;
    //   659: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: pop
    //   663: aload 17
    //   665: ldc_w 1462
    //   668: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload 17
    //   674: aload_0
    //   675: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   678: getfield 271	com/tencent/msf/service/protocol/push/a/d:e	[B
    //   681: invokestatic 1466	java/util/Arrays:toString	([B)Ljava/lang/String;
    //   684: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: aload 17
    //   690: ldc_w 1468
    //   693: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload 17
    //   699: aload_0
    //   700: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   703: getfield 603	com/tencent/msf/service/protocol/push/a/d:y	S
    //   706: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: ldc 255
    //   712: iconst_2
    //   713: aload 17
    //   715: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   721: aload_0
    //   722: getfield 170	com/tencent/mobileqq/msf/core/net/c/c:d	I
    //   725: istore_1
    //   726: iload_1
    //   727: iconst_1
    //   728: if_icmple +51 -> 779
    //   731: aload_0
    //   732: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   735: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   738: invokevirtual 678	java/util/ArrayList:size	()I
    //   741: sipush 200
    //   744: if_icmple +175 -> 919
    //   747: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   750: ifeq +12 -> 762
    //   753: ldc 255
    //   755: iconst_4
    //   756: ldc_w 1470
    //   759: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   762: aload_0
    //   763: iconst_0
    //   764: putfield 134	com/tencent/mobileqq/msf/core/net/c/c:V	Z
    //   767: aload_0
    //   768: getstatic 1168	com/tencent/mobileqq/msf/core/net/c/c$e$a:m	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   771: iconst_1
    //   772: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   775: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   778: return
    //   779: iload_1
    //   780: iconst_1
    //   781: if_icmpne +66 -> 847
    //   784: aload_0
    //   785: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   788: getfield 1273	com/tencent/msf/service/protocol/push/a/d:m	J
    //   791: ldc2_w 1471
    //   794: land
    //   795: lconst_1
    //   796: lcmp
    //   797: ifeq +50 -> 847
    //   800: aload_0
    //   801: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   804: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   807: invokevirtual 678	java/util/ArrayList:size	()I
    //   810: bipush 75
    //   812: if_icmple +107 -> 919
    //   815: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   818: ifeq +12 -> 830
    //   821: ldc 255
    //   823: iconst_4
    //   824: ldc_w 1166
    //   827: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   830: aload_0
    //   831: iconst_0
    //   832: putfield 134	com/tencent/mobileqq/msf/core/net/c/c:V	Z
    //   835: aload_0
    //   836: getstatic 1168	com/tencent/mobileqq/msf/core/net/c/c$e$a:m	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   839: iconst_1
    //   840: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   843: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   846: return
    //   847: aload_0
    //   848: getfield 170	com/tencent/mobileqq/msf/core/net/c/c:d	I
    //   851: iconst_1
    //   852: if_icmpne +67 -> 919
    //   855: aload_0
    //   856: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   859: getfield 1273	com/tencent/msf/service/protocol/push/a/d:m	J
    //   862: ldc2_w 1471
    //   865: land
    //   866: lconst_1
    //   867: lcmp
    //   868: ifne +51 -> 919
    //   871: aload_0
    //   872: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   875: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   878: invokevirtual 678	java/util/ArrayList:size	()I
    //   881: sipush 200
    //   884: if_icmple +35 -> 919
    //   887: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   890: ifeq +12 -> 902
    //   893: ldc 255
    //   895: iconst_4
    //   896: ldc_w 1470
    //   899: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   902: aload_0
    //   903: iconst_0
    //   904: putfield 134	com/tencent/mobileqq/msf/core/net/c/c:V	Z
    //   907: aload_0
    //   908: getstatic 1168	com/tencent/mobileqq/msf/core/net/c/c$e$a:m	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   911: iconst_1
    //   912: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   915: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   918: return
    //   919: aload_0
    //   920: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   923: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   926: invokevirtual 678	java/util/ArrayList:size	()I
    //   929: ifgt +30 -> 959
    //   932: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   935: ifeq +12 -> 947
    //   938: ldc 255
    //   940: iconst_4
    //   941: ldc_w 1170
    //   944: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   947: aload_0
    //   948: getstatic 1172	com/tencent/mobileqq/msf/core/net/c/c$e$a:n	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   951: iconst_1
    //   952: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   955: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   958: return
    //   959: aload_0
    //   960: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   963: getfield 820	com/tencent/msf/service/protocol/push/a/d:f	J
    //   966: lconst_0
    //   967: lcmp
    //   968: ifgt +30 -> 998
    //   971: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   974: ifeq +12 -> 986
    //   977: ldc 255
    //   979: iconst_4
    //   980: ldc_w 1474
    //   983: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   986: aload_0
    //   987: getstatic 1476	com/tencent/mobileqq/msf/core/net/c/c$e$a:q	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   990: iconst_1
    //   991: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   994: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   997: return
    //   998: aload_0
    //   999: getfield 170	com/tencent/mobileqq/msf/core/net/c/c:d	I
    //   1002: istore_1
    //   1003: iload_1
    //   1004: iconst_1
    //   1005: if_icmple +49 -> 1054
    //   1008: aload_0
    //   1009: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1012: getfield 1428	com/tencent/msf/service/protocol/push/a/d:c	J
    //   1015: ldc2_w 1477
    //   1018: lcmp
    //   1019: ifle +172 -> 1191
    //   1022: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1025: ifeq +12 -> 1037
    //   1028: ldc 255
    //   1030: iconst_4
    //   1031: ldc_w 1480
    //   1034: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1037: aload_0
    //   1038: iconst_0
    //   1039: putfield 134	com/tencent/mobileqq/msf/core/net/c/c:V	Z
    //   1042: aload_0
    //   1043: getstatic 1339	com/tencent/mobileqq/msf/core/net/c/c$e$a:l	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   1046: iconst_1
    //   1047: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   1050: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1053: return
    //   1054: iload_1
    //   1055: iconst_1
    //   1056: if_icmpne +65 -> 1121
    //   1059: aload_0
    //   1060: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1063: getfield 1273	com/tencent/msf/service/protocol/push/a/d:m	J
    //   1066: ldc2_w 1471
    //   1069: land
    //   1070: lconst_1
    //   1071: lcmp
    //   1072: ifeq +49 -> 1121
    //   1075: aload_0
    //   1076: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1079: getfield 1428	com/tencent/msf/service/protocol/push/a/d:c	J
    //   1082: ldc2_w 1334
    //   1085: lcmp
    //   1086: ifle +105 -> 1191
    //   1089: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1092: ifeq +12 -> 1104
    //   1095: ldc 255
    //   1097: iconst_4
    //   1098: ldc_w 1337
    //   1101: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1104: aload_0
    //   1105: iconst_0
    //   1106: putfield 134	com/tencent/mobileqq/msf/core/net/c/c:V	Z
    //   1109: aload_0
    //   1110: getstatic 1339	com/tencent/mobileqq/msf/core/net/c/c$e$a:l	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   1113: iconst_1
    //   1114: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   1117: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1120: return
    //   1121: aload_0
    //   1122: getfield 170	com/tencent/mobileqq/msf/core/net/c/c:d	I
    //   1125: iconst_1
    //   1126: if_icmpne +65 -> 1191
    //   1129: aload_0
    //   1130: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1133: getfield 1273	com/tencent/msf/service/protocol/push/a/d:m	J
    //   1136: ldc2_w 1471
    //   1139: land
    //   1140: lconst_1
    //   1141: lcmp
    //   1142: ifne +49 -> 1191
    //   1145: aload_0
    //   1146: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1149: getfield 1428	com/tencent/msf/service/protocol/push/a/d:c	J
    //   1152: ldc2_w 1477
    //   1155: lcmp
    //   1156: ifle +35 -> 1191
    //   1159: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1162: ifeq +12 -> 1174
    //   1165: ldc 255
    //   1167: iconst_4
    //   1168: ldc_w 1480
    //   1171: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1174: aload_0
    //   1175: iconst_0
    //   1176: putfield 134	com/tencent/mobileqq/msf/core/net/c/c:V	Z
    //   1179: aload_0
    //   1180: getstatic 1339	com/tencent/mobileqq/msf/core/net/c/c$e$a:l	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   1183: iconst_1
    //   1184: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   1187: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1190: return
    //   1191: aload_0
    //   1192: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1195: getfield 1273	com/tencent/msf/service/protocol/push/a/d:m	J
    //   1198: bipush 8
    //   1200: lshr
    //   1201: ldc2_w 1471
    //   1204: land
    //   1205: ldc2_w 1334
    //   1208: lcmp
    //   1209: ifle +35 -> 1244
    //   1212: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1215: ifeq +12 -> 1227
    //   1218: ldc 255
    //   1220: iconst_4
    //   1221: ldc_w 1482
    //   1224: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1227: aload_0
    //   1228: iconst_0
    //   1229: putfield 134	com/tencent/mobileqq/msf/core/net/c/c:V	Z
    //   1232: aload_0
    //   1233: getstatic 1339	com/tencent/mobileqq/msf/core/net/c/c$e$a:l	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   1236: iconst_1
    //   1237: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   1240: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1243: return
    //   1244: aload_0
    //   1245: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1248: getfield 1174	com/tencent/msf/service/protocol/push/a/d:h	J
    //   1251: ldc2_w 1175
    //   1254: lmul
    //   1255: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   1258: lcmp
    //   1259: ifge +81 -> 1340
    //   1262: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1265: ifeq +63 -> 1328
    //   1268: new 241	java/lang/StringBuilder
    //   1271: dup
    //   1272: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1275: astore 15
    //   1277: aload 15
    //   1279: ldc_w 1178
    //   1282: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: pop
    //   1286: aload 15
    //   1288: aload_0
    //   1289: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1292: getfield 1174	com/tencent/msf/service/protocol/push/a/d:h	J
    //   1295: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1298: pop
    //   1299: aload 15
    //   1301: ldc_w 1180
    //   1304: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: pop
    //   1308: aload 15
    //   1310: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   1313: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1316: pop
    //   1317: ldc 255
    //   1319: iconst_4
    //   1320: aload 15
    //   1322: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1325: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1328: aload_0
    //   1329: getstatic 1182	com/tencent/mobileqq/msf/core/net/c/c$e$a:j	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   1332: iconst_1
    //   1333: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   1336: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1339: return
    //   1340: aload_0
    //   1341: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1344: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   1347: ifeq +94 -> 1441
    //   1350: iconst_1
    //   1351: aload_0
    //   1352: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1355: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   1358: if_icmpeq +83 -> 1441
    //   1361: iconst_2
    //   1362: aload_0
    //   1363: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1366: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   1369: if_icmpeq +72 -> 1441
    //   1372: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1375: ifeq +54 -> 1429
    //   1378: new 241	java/lang/StringBuilder
    //   1381: dup
    //   1382: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1385: astore 15
    //   1387: aload 15
    //   1389: ldc_w 1484
    //   1392: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1395: pop
    //   1396: aload 15
    //   1398: aload_0
    //   1399: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1402: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   1405: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1408: pop
    //   1409: aload 15
    //   1411: ldc_w 1486
    //   1414: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: pop
    //   1418: ldc 255
    //   1420: iconst_2
    //   1421: aload 15
    //   1423: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1426: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1429: aload_0
    //   1430: getstatic 1488	com/tencent/mobileqq/msf/core/net/c/c$e$a:w	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   1433: iconst_1
    //   1434: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   1437: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1440: return
    //   1441: aload_0
    //   1442: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1445: getfield 1295	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   1448: ifnull +2324 -> 3772
    //   1451: aload_0
    //   1452: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1455: getfield 1295	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   1458: arraylength
    //   1459: ifle +2313 -> 3772
    //   1462: aload_0
    //   1463: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1466: getfield 1295	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   1469: arraylength
    //   1470: istore_1
    //   1471: goto +3 -> 1474
    //   1474: iload_1
    //   1475: i2l
    //   1476: lstore 7
    //   1478: aload_0
    //   1479: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1482: getfield 271	com/tencent/msf/service/protocol/push/a/d:e	[B
    //   1485: arraylength
    //   1486: i2l
    //   1487: lstore 9
    //   1489: aload_0
    //   1490: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1493: getfield 820	com/tencent/msf/service/protocol/push/a/d:f	J
    //   1496: lstore 11
    //   1498: lload 9
    //   1500: invokestatic 1360	java/lang/Long:signum	(J)I
    //   1503: pop
    //   1504: lload 7
    //   1506: lload 9
    //   1508: lload 11
    //   1510: lmul
    //   1511: ladd
    //   1512: l2i
    //   1513: istore_1
    //   1514: iload_1
    //   1515: istore 4
    //   1517: aload_0
    //   1518: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1521: getfield 1442	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   1524: ifnull +29 -> 1553
    //   1527: iload_1
    //   1528: istore 4
    //   1530: aload_0
    //   1531: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1534: getfield 1442	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   1537: arraylength
    //   1538: ifle +15 -> 1553
    //   1541: iload_1
    //   1542: aload_0
    //   1543: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1546: getfield 1442	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   1549: arraylength
    //   1550: iadd
    //   1551: istore 4
    //   1553: new 241	java/lang/StringBuilder
    //   1556: dup
    //   1557: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1560: astore 15
    //   1562: aload 15
    //   1564: ldc_w 1490
    //   1567: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1570: pop
    //   1571: aload 15
    //   1573: iload 4
    //   1575: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1578: pop
    //   1579: ldc 255
    //   1581: iconst_1
    //   1582: aload 15
    //   1584: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1587: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1590: aload_0
    //   1591: getfield 166	com/tencent/mobileqq/msf/core/net/c/c:a	Lcom/tencent/mobileqq/msf/core/net/c/c$b;
    //   1594: getstatic 232	com/tencent/mobileqq/msf/core/net/c/c$b:c	Lcom/tencent/mobileqq/msf/core/net/c/c$b;
    //   1597: if_acmpne +21 -> 1618
    //   1600: iload 4
    //   1602: ifne +11 -> 1613
    //   1605: aload_0
    //   1606: iconst_1
    //   1607: putfield 114	com/tencent/mobileqq/msf/core/net/c/c:l	I
    //   1610: goto +8 -> 1618
    //   1613: aload_0
    //   1614: iconst_0
    //   1615: putfield 114	com/tencent/mobileqq/msf/core/net/c/c:l	I
    //   1618: aload_0
    //   1619: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1622: getfield 1429	com/tencent/msf/service/protocol/push/a/d:d	J
    //   1625: ldc2_w 1367
    //   1628: lcmp
    //   1629: ifge +75 -> 1704
    //   1632: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1635: ifeq +54 -> 1689
    //   1638: new 241	java/lang/StringBuilder
    //   1641: dup
    //   1642: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1645: astore 15
    //   1647: aload 15
    //   1649: ldc_w 1370
    //   1652: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1655: pop
    //   1656: aload 15
    //   1658: aload_0
    //   1659: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1662: getfield 1429	com/tencent/msf/service/protocol/push/a/d:d	J
    //   1665: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1668: pop
    //   1669: aload 15
    //   1671: ldc_w 1366
    //   1674: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1677: pop
    //   1678: ldc 255
    //   1680: iconst_4
    //   1681: aload 15
    //   1683: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1686: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1689: aload_0
    //   1690: getstatic 1372	com/tencent/mobileqq/msf/core/net/c/c$e$a:g	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   1693: iconst_1
    //   1694: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   1697: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1700: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1703: return
    //   1704: iconst_0
    //   1705: istore_1
    //   1706: iconst_0
    //   1707: istore_3
    //   1708: iload_1
    //   1709: aload_0
    //   1710: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1713: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   1716: invokevirtual 678	java/util/ArrayList:size	()I
    //   1719: if_icmpge +2011 -> 3730
    //   1722: iload_3
    //   1723: ifeq +6 -> 1729
    //   1726: goto +2004 -> 3730
    //   1729: aload_0
    //   1730: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1733: new 346	java/util/ArrayList
    //   1736: dup
    //   1737: invokespecial 868	java/util/ArrayList:<init>	()V
    //   1740: putfield 1347	com/tencent/mobileqq/msf/core/net/c/c$e:y	Ljava/util/ArrayList;
    //   1743: aload_0
    //   1744: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1747: iconst_0
    //   1748: putfield 391	com/tencent/mobileqq/msf/core/net/c/c$e:k	I
    //   1751: aload_0
    //   1752: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1755: iconst_0
    //   1756: putfield 472	com/tencent/mobileqq/msf/core/net/c/c$e:n	I
    //   1759: aload_0
    //   1760: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1763: iconst_0
    //   1764: putfield 792	com/tencent/mobileqq/msf/core/net/c/c$e:l	I
    //   1767: aload_0
    //   1768: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1771: iconst_0
    //   1772: putfield 454	com/tencent/mobileqq/msf/core/net/c/c$e:m	I
    //   1775: aload_0
    //   1776: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1779: iconst_0
    //   1780: putfield 750	com/tencent/mobileqq/msf/core/net/c/c$e:o	I
    //   1783: aload_0
    //   1784: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1787: getfield 178	com/tencent/mobileqq/msf/core/net/c/c$e:c	Ljava/util/Map;
    //   1790: invokeinterface 1212 1 0
    //   1795: aload_0
    //   1796: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1799: iconst_0
    //   1800: putfield 1492	com/tencent/mobileqq/msf/core/net/c/c$e:x	Z
    //   1803: aload_0
    //   1804: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1807: aconst_null
    //   1808: putfield 1494	com/tencent/mobileqq/msf/core/net/c/c$e:A	Ljava/lang/String;
    //   1811: aload_0
    //   1812: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1815: getfield 723	com/tencent/mobileqq/msf/core/net/c/c$e:I	Ljava/util/ArrayList;
    //   1818: invokevirtual 1348	java/util/ArrayList:clear	()V
    //   1821: aload_0
    //   1822: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1825: getfield 384	com/tencent/mobileqq/msf/core/net/c/c$e:J	Ljava/util/ArrayList;
    //   1828: invokevirtual 1348	java/util/ArrayList:clear	()V
    //   1831: aload_0
    //   1832: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1835: aconst_null
    //   1836: putfield 451	com/tencent/mobileqq/msf/core/net/c/c$e:d	Ljava/net/InetAddress;
    //   1839: aload_0
    //   1840: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1843: lconst_0
    //   1844: putfield 929	com/tencent/mobileqq/msf/core/net/c/c$e:D	J
    //   1847: aload_0
    //   1848: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1851: iconst_0
    //   1852: putfield 931	com/tencent/mobileqq/msf/core/net/c/c$e:E	I
    //   1855: aload_0
    //   1856: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1859: iconst_0
    //   1860: putfield 436	com/tencent/mobileqq/msf/core/net/c/c$e:F	I
    //   1863: aload_0
    //   1864: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1867: iconst_0
    //   1868: putfield 312	com/tencent/mobileqq/msf/core/net/c/c$e:G	I
    //   1871: aload_0
    //   1872: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1875: invokestatic 208	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   1878: putfield 883	com/tencent/mobileqq/msf/core/net/c/c$e:g	I
    //   1881: aload_0
    //   1882: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1885: invokestatic 1188	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getWifiStrength	()I
    //   1888: putfield 1190	com/tencent/mobileqq/msf/core/net/c/c$e:h	I
    //   1891: aload_0
    //   1892: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1895: invokestatic 1193	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getCdmaStrength	()I
    //   1898: putfield 1195	com/tencent/mobileqq/msf/core/net/c/c$e:j	I
    //   1901: aload_0
    //   1902: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   1905: invokestatic 1198	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getGsmStrength	()I
    //   1908: putfield 1200	com/tencent/mobileqq/msf/core/net/c/c$e:i	I
    //   1911: goto +18 -> 1929
    //   1914: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1917: ifeq +12 -> 1929
    //   1920: ldc 255
    //   1922: iconst_4
    //   1923: ldc_w 1350
    //   1926: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1929: aload_0
    //   1930: lconst_0
    //   1931: putfield 154	com/tencent/mobileqq/msf/core/net/c/c:A	J
    //   1934: aload_0
    //   1935: lconst_0
    //   1936: putfield 158	com/tencent/mobileqq/msf/core/net/c/c:C	J
    //   1939: aload_0
    //   1940: lconst_0
    //   1941: putfield 156	com/tencent/mobileqq/msf/core/net/c/c:B	J
    //   1944: aload_0
    //   1945: lconst_0
    //   1946: putfield 160	com/tencent/mobileqq/msf/core/net/c/c:D	J
    //   1949: invokestatic 1497	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isWifiConn	()Z
    //   1952: ifeq +175 -> 2127
    //   1955: invokestatic 1188	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getWifiStrength	()I
    //   1958: bipush 10
    //   1960: if_icmple +167 -> 2127
    //   1963: getstatic 1499	com/tencent/mobileqq/msf/core/net/c/k:e	Ljava/lang/String;
    //   1966: ldc_w 1501
    //   1969: invokevirtual 504	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1972: istore 13
    //   1974: iload 13
    //   1976: ifeq +65 -> 2041
    //   1979: aload_0
    //   1980: getfield 172	com/tencent/mobileqq/msf/core/net/c/c:e	I
    //   1983: ifeq +58 -> 2041
    //   1986: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1989: ifeq +1741 -> 3730
    //   1992: new 241	java/lang/StringBuilder
    //   1995: dup
    //   1996: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1999: astore 15
    //   2001: aload 15
    //   2003: ldc_w 1503
    //   2006: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2009: pop
    //   2010: aload 15
    //   2012: invokestatic 1507	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2015: invokevirtual 1510	java/lang/Thread:getName	()Ljava/lang/String;
    //   2018: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2021: pop
    //   2022: ldc 255
    //   2024: iconst_2
    //   2025: aload 15
    //   2027: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2030: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2033: goto +1697 -> 3730
    //   2036: astore 15
    //   2038: goto +386 -> 2424
    //   2041: aload_0
    //   2042: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2045: getfield 1273	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2048: ldc2_w 1471
    //   2051: land
    //   2052: lconst_1
    //   2053: lcmp
    //   2054: ifne +57 -> 2111
    //   2057: aload_0
    //   2058: getfield 170	com/tencent/mobileqq/msf/core/net/c/c:d	I
    //   2061: iconst_1
    //   2062: if_icmple +37 -> 2099
    //   2065: aload_0
    //   2066: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2069: getfield 1428	com/tencent/msf/service/protocol/push/a/d:c	J
    //   2072: lstore 7
    //   2074: aload_0
    //   2075: getfield 170	com/tencent/mobileqq/msf/core/net/c/c:d	I
    //   2078: istore 5
    //   2080: iload_1
    //   2081: istore_2
    //   2082: iload 5
    //   2084: i2l
    //   2085: lstore 9
    //   2087: lload 7
    //   2089: lload 9
    //   2091: ldiv
    //   2092: lstore 7
    //   2094: iload_2
    //   2095: istore_1
    //   2096: goto +362 -> 2458
    //   2099: aload_0
    //   2100: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2103: getfield 1273	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2106: lstore 7
    //   2108: goto +1669 -> 3777
    //   2111: iload_1
    //   2112: istore_2
    //   2113: aload_0
    //   2114: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2117: getfield 1428	com/tencent/msf/service/protocol/push/a/d:c	J
    //   2120: lstore 7
    //   2122: iload_2
    //   2123: istore_1
    //   2124: goto +334 -> 2458
    //   2127: iload_1
    //   2128: istore_2
    //   2129: ldc_w 1501
    //   2132: putstatic 1499	com/tencent/mobileqq/msf/core/net/c/k:e	Ljava/lang/String;
    //   2135: aload_0
    //   2136: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2139: getfield 1273	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2142: ldc2_w 1471
    //   2145: land
    //   2146: lconst_1
    //   2147: lcmp
    //   2148: ifne +255 -> 2403
    //   2151: aload_0
    //   2152: getfield 170	com/tencent/mobileqq/msf/core/net/c/c:d	I
    //   2155: iconst_1
    //   2156: if_icmple +235 -> 2391
    //   2159: aload_0
    //   2160: getfield 172	com/tencent/mobileqq/msf/core/net/c/c:e	I
    //   2163: ifeq +53 -> 2216
    //   2166: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2169: ifeq +1561 -> 3730
    //   2172: new 241	java/lang/StringBuilder
    //   2175: dup
    //   2176: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   2179: astore 15
    //   2181: aload 15
    //   2183: ldc_w 1503
    //   2186: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2189: pop
    //   2190: aload 15
    //   2192: invokestatic 1507	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2195: invokevirtual 1510	java/lang/Thread:getName	()Ljava/lang/String;
    //   2198: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2201: pop
    //   2202: ldc 255
    //   2204: iconst_2
    //   2205: aload 15
    //   2207: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2210: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2213: goto +1517 -> 3730
    //   2216: aload_0
    //   2217: iconst_1
    //   2218: putfield 170	com/tencent/mobileqq/msf/core/net/c/c:d	I
    //   2221: aload_0
    //   2222: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2225: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   2228: invokevirtual 678	java/util/ArrayList:size	()I
    //   2231: bipush 75
    //   2233: if_icmple +81 -> 2314
    //   2236: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2239: ifeq +12 -> 2251
    //   2242: ldc 255
    //   2244: iconst_4
    //   2245: ldc_w 1166
    //   2248: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2251: aload_0
    //   2252: getfield 122	com/tencent/mobileqq/msf/core/net/c/c:S	Ljava/lang/String;
    //   2255: ldc_w 1410
    //   2258: invokevirtual 223	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2261: istore_1
    //   2262: iload_1
    //   2263: iconst_m1
    //   2264: if_icmpeq +18 -> 2282
    //   2267: aload_0
    //   2268: aload_0
    //   2269: getfield 122	com/tencent/mobileqq/msf/core/net/c/c:S	Ljava/lang/String;
    //   2272: iconst_0
    //   2273: iload_1
    //   2274: iconst_1
    //   2275: iadd
    //   2276: invokevirtual 737	java/lang/String:substring	(II)Ljava/lang/String;
    //   2279: putfield 122	com/tencent/mobileqq/msf/core/net/c/c:S	Ljava/lang/String;
    //   2282: aload_0
    //   2283: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   2286: getfield 178	com/tencent/mobileqq/msf/core/net/c/c$e:c	Ljava/util/Map;
    //   2289: invokeinterface 1212 1 0
    //   2294: aload_0
    //   2295: iconst_0
    //   2296: putfield 134	com/tencent/mobileqq/msf/core/net/c/c:V	Z
    //   2299: aload_0
    //   2300: getstatic 1168	com/tencent/mobileqq/msf/core/net/c/c$e$a:m	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   2303: iconst_1
    //   2304: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   2307: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   2310: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   2313: return
    //   2314: aload_0
    //   2315: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2318: getfield 1273	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2321: lstore 7
    //   2323: lload 7
    //   2325: bipush 8
    //   2327: lshr
    //   2328: ldc2_w 1471
    //   2331: land
    //   2332: lstore 7
    //   2334: aload_0
    //   2335: getfield 122	com/tencent/mobileqq/msf/core/net/c/c:S	Ljava/lang/String;
    //   2338: ldc_w 1410
    //   2341: invokevirtual 223	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2344: istore_1
    //   2345: iload_1
    //   2346: iconst_m1
    //   2347: if_icmpeq +18 -> 2365
    //   2350: aload_0
    //   2351: aload_0
    //   2352: getfield 122	com/tencent/mobileqq/msf/core/net/c/c:S	Ljava/lang/String;
    //   2355: iconst_0
    //   2356: iload_1
    //   2357: iconst_1
    //   2358: iadd
    //   2359: invokevirtual 737	java/lang/String:substring	(II)Ljava/lang/String;
    //   2362: putfield 122	com/tencent/mobileqq/msf/core/net/c/c:S	Ljava/lang/String;
    //   2365: iconst_m1
    //   2366: istore_1
    //   2367: goto +91 -> 2458
    //   2370: astore 15
    //   2372: iconst_m1
    //   2373: istore_2
    //   2374: lload 7
    //   2376: lstore 9
    //   2378: goto +51 -> 2429
    //   2381: astore 15
    //   2383: lconst_1
    //   2384: lstore 9
    //   2386: iconst_m1
    //   2387: istore_2
    //   2388: goto +41 -> 2429
    //   2391: aload_0
    //   2392: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2395: getfield 1273	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2398: lstore 7
    //   2400: goto +1377 -> 3777
    //   2403: aload_0
    //   2404: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2407: getfield 1428	com/tencent/msf/service/protocol/push/a/d:c	J
    //   2410: lstore 7
    //   2412: iload_2
    //   2413: istore_1
    //   2414: goto +44 -> 2458
    //   2417: astore 15
    //   2419: goto +5 -> 2424
    //   2422: astore 15
    //   2424: lconst_1
    //   2425: lstore 9
    //   2427: iload_1
    //   2428: istore_2
    //   2429: lload 9
    //   2431: lstore 7
    //   2433: iload_2
    //   2434: istore_1
    //   2435: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2438: ifeq +20 -> 2458
    //   2441: ldc 255
    //   2443: iconst_4
    //   2444: ldc_w 1512
    //   2447: aload 15
    //   2449: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2452: iload_2
    //   2453: istore_1
    //   2454: lload 9
    //   2456: lstore 7
    //   2458: iconst_0
    //   2459: istore_2
    //   2460: iconst_1
    //   2461: istore 13
    //   2463: iload_2
    //   2464: i2l
    //   2465: lload 7
    //   2467: lcmp
    //   2468: ifge +1336 -> 3804
    //   2471: iload_1
    //   2472: iconst_m1
    //   2473: if_icmpne +6 -> 2479
    //   2476: goto +1328 -> 3804
    //   2479: invokestatic 1497	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isWifiConn	()Z
    //   2482: istore 14
    //   2484: iload 14
    //   2486: ifeq +239 -> 2725
    //   2489: invokestatic 1188	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getWifiStrength	()I
    //   2492: bipush 10
    //   2494: if_icmple +231 -> 2725
    //   2497: getstatic 1499	com/tencent/mobileqq/msf/core/net/c/k:e	Ljava/lang/String;
    //   2500: ldc_w 1501
    //   2503: invokevirtual 504	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2506: ifeq +104 -> 2610
    //   2509: aload_0
    //   2510: getfield 172	com/tencent/mobileqq/msf/core/net/c/c:e	I
    //   2513: istore 5
    //   2515: iload 5
    //   2517: ifeq +93 -> 2610
    //   2520: aload_0
    //   2521: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2524: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   2527: invokevirtual 678	java/util/ArrayList:size	()I
    //   2530: istore 5
    //   2532: iload 5
    //   2534: istore_1
    //   2535: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2538: ifeq +54 -> 2592
    //   2541: iload 5
    //   2543: istore_1
    //   2544: new 241	java/lang/StringBuilder
    //   2547: dup
    //   2548: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   2551: astore 15
    //   2553: iload 5
    //   2555: istore_1
    //   2556: aload 15
    //   2558: ldc_w 1503
    //   2561: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2564: pop
    //   2565: iload 5
    //   2567: istore_1
    //   2568: aload 15
    //   2570: aload_0
    //   2571: getfield 172	com/tencent/mobileqq/msf/core/net/c/c:e	I
    //   2574: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2577: pop
    //   2578: iload 5
    //   2580: istore_1
    //   2581: ldc 255
    //   2583: iconst_2
    //   2584: aload 15
    //   2586: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2589: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2592: iconst_1
    //   2593: istore_3
    //   2594: iload 5
    //   2596: istore_1
    //   2597: goto +998 -> 3595
    //   2600: astore 15
    //   2602: iconst_1
    //   2603: istore 5
    //   2605: iload_1
    //   2606: istore_3
    //   2607: goto +533 -> 3140
    //   2610: aload_0
    //   2611: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2614: getfield 1273	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2617: ldc2_w 1471
    //   2620: land
    //   2621: lconst_1
    //   2622: lcmp
    //   2623: ifne +68 -> 2691
    //   2626: aload_0
    //   2627: getfield 170	com/tencent/mobileqq/msf/core/net/c/c:d	I
    //   2630: iconst_1
    //   2631: if_icmple +37 -> 2668
    //   2634: aload_0
    //   2635: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2638: getfield 1428	com/tencent/msf/service/protocol/push/a/d:c	J
    //   2641: lstore 9
    //   2643: aload_0
    //   2644: getfield 170	com/tencent/mobileqq/msf/core/net/c/c:d	I
    //   2647: istore 5
    //   2649: iload 5
    //   2651: i2l
    //   2652: lstore 11
    //   2654: lload 9
    //   2656: lload 11
    //   2658: ldiv
    //   2659: lstore 9
    //   2661: lload 9
    //   2663: lstore 7
    //   2665: goto +39 -> 2704
    //   2668: aload_0
    //   2669: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2672: getfield 1273	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2675: bipush 8
    //   2677: lshr
    //   2678: ldc2_w 1471
    //   2681: land
    //   2682: lstore 9
    //   2684: lload 9
    //   2686: lstore 7
    //   2688: goto +413 -> 3101
    //   2691: aload_0
    //   2692: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2695: getfield 1428	com/tencent/msf/service/protocol/push/a/d:c	J
    //   2698: lstore 9
    //   2700: lload 9
    //   2702: lstore 7
    //   2704: goto +397 -> 3101
    //   2707: astore 15
    //   2709: goto +5 -> 2714
    //   2712: astore 15
    //   2714: iload_1
    //   2715: istore 5
    //   2717: iload_2
    //   2718: istore_1
    //   2719: iload 5
    //   2721: istore_2
    //   2722: goto +411 -> 3133
    //   2725: iload_2
    //   2726: istore 6
    //   2728: iload_1
    //   2729: istore 5
    //   2731: ldc_w 1501
    //   2734: putstatic 1499	com/tencent/mobileqq/msf/core/net/c/k:e	Ljava/lang/String;
    //   2737: aload_0
    //   2738: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2741: getfield 1273	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2744: lstore 9
    //   2746: lload 9
    //   2748: ldc2_w 1471
    //   2751: land
    //   2752: lconst_1
    //   2753: lcmp
    //   2754: ifne +334 -> 3088
    //   2757: aload_0
    //   2758: getfield 170	com/tencent/mobileqq/msf/core/net/c/c:d	I
    //   2761: istore 6
    //   2763: iload 6
    //   2765: iconst_1
    //   2766: if_icmple +289 -> 3055
    //   2769: aload_0
    //   2770: getfield 172	com/tencent/mobileqq/msf/core/net/c/c:e	I
    //   2773: istore 6
    //   2775: iload 6
    //   2777: ifeq +77 -> 2854
    //   2780: aload_0
    //   2781: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2784: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   2787: invokevirtual 678	java/util/ArrayList:size	()I
    //   2790: istore_1
    //   2791: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2794: ifeq +42 -> 2836
    //   2797: new 241	java/lang/StringBuilder
    //   2800: dup
    //   2801: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   2804: astore 15
    //   2806: aload 15
    //   2808: ldc_w 1503
    //   2811: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2814: pop
    //   2815: aload 15
    //   2817: aload_0
    //   2818: getfield 172	com/tencent/mobileqq/msf/core/net/c/c:e	I
    //   2821: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2824: pop
    //   2825: ldc 255
    //   2827: iconst_2
    //   2828: aload 15
    //   2830: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2833: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2836: iconst_1
    //   2837: istore_3
    //   2838: goto +757 -> 3595
    //   2841: astore 15
    //   2843: goto +8 -> 2851
    //   2846: astore 15
    //   2848: iload 5
    //   2850: istore_1
    //   2851: goto -249 -> 2602
    //   2854: aload_0
    //   2855: iconst_1
    //   2856: putfield 170	com/tencent/mobileqq/msf/core/net/c/c:d	I
    //   2859: aload_0
    //   2860: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2863: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   2866: invokevirtual 678	java/util/ArrayList:size	()I
    //   2869: istore_1
    //   2870: iload_1
    //   2871: bipush 75
    //   2873: if_icmple +86 -> 2959
    //   2876: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2879: ifeq +12 -> 2891
    //   2882: ldc 255
    //   2884: iconst_4
    //   2885: ldc_w 1166
    //   2888: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2891: aload_0
    //   2892: getfield 122	com/tencent/mobileqq/msf/core/net/c/c:S	Ljava/lang/String;
    //   2895: ldc_w 1410
    //   2898: invokevirtual 223	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2901: istore_1
    //   2902: iload_1
    //   2903: iconst_m1
    //   2904: if_icmpeq +18 -> 2922
    //   2907: aload_0
    //   2908: aload_0
    //   2909: getfield 122	com/tencent/mobileqq/msf/core/net/c/c:S	Ljava/lang/String;
    //   2912: iconst_0
    //   2913: iload_1
    //   2914: iconst_1
    //   2915: iadd
    //   2916: invokevirtual 737	java/lang/String:substring	(II)Ljava/lang/String;
    //   2919: putfield 122	com/tencent/mobileqq/msf/core/net/c/c:S	Ljava/lang/String;
    //   2922: aload_0
    //   2923: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   2926: getfield 178	com/tencent/mobileqq/msf/core/net/c/c$e:c	Ljava/util/Map;
    //   2929: invokeinterface 1212 1 0
    //   2934: aload_0
    //   2935: iconst_0
    //   2936: putfield 134	com/tencent/mobileqq/msf/core/net/c/c:V	Z
    //   2939: aload_0
    //   2940: getstatic 1168	com/tencent/mobileqq/msf/core/net/c/c$e$a:m	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   2943: iconst_1
    //   2944: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   2947: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   2950: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   2953: return
    //   2954: astore 15
    //   2956: goto +87 -> 3043
    //   2959: aload_0
    //   2960: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2963: getfield 1273	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2966: lstore 9
    //   2968: aload_0
    //   2969: getfield 122	com/tencent/mobileqq/msf/core/net/c/c:S	Ljava/lang/String;
    //   2972: ldc_w 1410
    //   2975: invokevirtual 223	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2978: istore_1
    //   2979: iload_1
    //   2980: iconst_m1
    //   2981: if_icmpeq +30 -> 3011
    //   2984: aload_0
    //   2985: getfield 122	com/tencent/mobileqq/msf/core/net/c/c:S	Ljava/lang/String;
    //   2988: astore 15
    //   2990: aload_0
    //   2991: aload 15
    //   2993: iconst_0
    //   2994: iload_1
    //   2995: iconst_1
    //   2996: iadd
    //   2997: invokevirtual 737	java/lang/String:substring	(II)Ljava/lang/String;
    //   3000: putfield 122	com/tencent/mobileqq/msf/core/net/c/c:S	Ljava/lang/String;
    //   3003: goto +8 -> 3011
    //   3006: astore 15
    //   3008: goto +10 -> 3018
    //   3011: iconst_m1
    //   3012: istore_1
    //   3013: goto -416 -> 2597
    //   3016: astore 15
    //   3018: lload 9
    //   3020: bipush 8
    //   3022: lshr
    //   3023: ldc2_w 1471
    //   3026: land
    //   3027: lstore 7
    //   3029: iconst_0
    //   3030: istore_1
    //   3031: iconst_m1
    //   3032: istore_2
    //   3033: goto +100 -> 3133
    //   3036: astore 15
    //   3038: goto +5 -> 3043
    //   3041: astore 15
    //   3043: iconst_0
    //   3044: istore_1
    //   3045: iconst_m1
    //   3046: istore_2
    //   3047: goto +86 -> 3133
    //   3050: astore 15
    //   3052: goto -338 -> 2714
    //   3055: aload_0
    //   3056: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3059: getfield 1273	com/tencent/msf/service/protocol/push/a/d:m	J
    //   3062: lstore 9
    //   3064: lload 9
    //   3066: bipush 8
    //   3068: lshr
    //   3069: ldc2_w 1471
    //   3072: land
    //   3073: lstore 7
    //   3075: goto +26 -> 3101
    //   3078: astore 15
    //   3080: goto +45 -> 3125
    //   3083: astore 15
    //   3085: goto +40 -> 3125
    //   3088: aload_0
    //   3089: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3092: getfield 1428	com/tencent/msf/service/protocol/push/a/d:c	J
    //   3095: lstore 9
    //   3097: lload 9
    //   3099: lstore 7
    //   3101: iload_2
    //   3102: istore 5
    //   3104: goto +65 -> 3169
    //   3107: astore 15
    //   3109: iload 6
    //   3111: istore_1
    //   3112: iload 5
    //   3114: istore_2
    //   3115: goto +18 -> 3133
    //   3118: astore 15
    //   3120: goto +5 -> 3125
    //   3123: astore 15
    //   3125: iload_1
    //   3126: istore 5
    //   3128: iload_2
    //   3129: istore_1
    //   3130: iload 5
    //   3132: istore_2
    //   3133: iload_3
    //   3134: istore 5
    //   3136: iload_2
    //   3137: istore_3
    //   3138: iload_1
    //   3139: istore_2
    //   3140: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3143: ifeq +14 -> 3157
    //   3146: ldc 255
    //   3148: iconst_4
    //   3149: ldc_w 1512
    //   3152: aload 15
    //   3154: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3157: iload 5
    //   3159: istore 6
    //   3161: iload_3
    //   3162: istore_1
    //   3163: iload_2
    //   3164: istore 5
    //   3166: iload 6
    //   3168: istore_3
    //   3169: aload_0
    //   3170: lconst_0
    //   3171: putfield 136	com/tencent/mobileqq/msf/core/net/c/c:r	J
    //   3174: aload_0
    //   3175: lconst_0
    //   3176: putfield 138	com/tencent/mobileqq/msf/core/net/c/c:s	J
    //   3179: aload_0
    //   3180: lconst_0
    //   3181: putfield 140	com/tencent/mobileqq/msf/core/net/c/c:t	J
    //   3184: aload_0
    //   3185: lconst_0
    //   3186: putfield 142	com/tencent/mobileqq/msf/core/net/c/c:u	J
    //   3189: aload_0
    //   3190: lconst_0
    //   3191: putfield 144	com/tencent/mobileqq/msf/core/net/c/c:v	J
    //   3194: aload_0
    //   3195: lconst_0
    //   3196: putfield 146	com/tencent/mobileqq/msf/core/net/c/c:w	J
    //   3199: aload_0
    //   3200: lconst_0
    //   3201: putfield 148	com/tencent/mobileqq/msf/core/net/c/c:x	J
    //   3204: aload_0
    //   3205: lconst_0
    //   3206: putfield 150	com/tencent/mobileqq/msf/core/net/c/c:y	J
    //   3209: aload_0
    //   3210: aload_0
    //   3211: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3214: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   3217: iload_1
    //   3218: invokevirtual 1203	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3221: checkcast 597	com/tencent/msf/service/protocol/push/a/a
    //   3224: invokespecial 1514	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/msf/service/protocol/push/a/a;)V
    //   3227: aload_0
    //   3228: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3231: getfield 710	com/tencent/msf/service/protocol/push/a/d:r	S
    //   3234: iconst_2
    //   3235: iand
    //   3236: iconst_2
    //   3237: if_icmpne +28 -> 3265
    //   3240: aload_0
    //   3241: getstatic 1516	com/tencent/mobileqq/msf/core/net/c/c$e$a:z	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   3244: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/c:a	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;)V
    //   3247: aload_0
    //   3248: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   3251: lconst_0
    //   3252: putfield 1315	com/tencent/mobileqq/msf/core/net/c/c$e:s	J
    //   3255: aload_0
    //   3256: invokespecial 1394	com/tencent/mobileqq/msf/core/net/c/c:h	()V
    //   3259: iconst_0
    //   3260: istore 13
    //   3262: goto +534 -> 3796
    //   3265: aload_0
    //   3266: iload 4
    //   3268: invokespecial 1518	com/tencent/mobileqq/msf/core/net/c/c:a	(I)Z
    //   3271: istore 14
    //   3273: aload_0
    //   3274: iload 4
    //   3276: aload_0
    //   3277: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3280: getfield 1295	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   3283: aload_0
    //   3284: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3287: getfield 1442	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   3290: invokespecial 1520	com/tencent/mobileqq/msf/core/net/c/c:a	(I[B[B)[B
    //   3293: astore 15
    //   3295: aload_0
    //   3296: aload_0
    //   3297: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3300: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   3303: iload_1
    //   3304: invokevirtual 1203	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3307: checkcast 597	com/tencent/msf/service/protocol/push/a/a
    //   3310: invokespecial 1374	com/tencent/mobileqq/msf/core/net/c/c:a	(Lcom/tencent/msf/service/protocol/push/a/a;)Z
    //   3313: ifne +56 -> 3369
    //   3316: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3319: ifeq +15 -> 3334
    //   3322: ldc 255
    //   3324: iconst_4
    //   3325: ldc_w 1376
    //   3328: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3331: goto +3 -> 3334
    //   3334: aload_0
    //   3335: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   3338: getfield 384	com/tencent/mobileqq/msf/core/net/c/c$e:J	Ljava/util/ArrayList;
    //   3341: ldc2_w 473
    //   3344: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3347: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3350: pop
    //   3351: aload_0
    //   3352: getstatic 1378	com/tencent/mobileqq/msf/core/net/c/c$e$a:c	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   3355: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/c:a	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;)V
    //   3358: goto -103 -> 3255
    //   3361: astore 15
    //   3363: iconst_0
    //   3364: istore 13
    //   3366: goto +148 -> 3514
    //   3369: iload 14
    //   3371: ifeq -116 -> 3255
    //   3374: aload 15
    //   3376: ifnonnull +6 -> 3382
    //   3379: goto -124 -> 3255
    //   3382: aload_0
    //   3383: getfield 166	com/tencent/mobileqq/msf/core/net/c/c:a	Lcom/tencent/mobileqq/msf/core/net/c/c$b;
    //   3386: getstatic 232	com/tencent/mobileqq/msf/core/net/c/c$b:c	Lcom/tencent/mobileqq/msf/core/net/c/c$b;
    //   3389: if_acmpne +10 -> 3399
    //   3392: aload_0
    //   3393: getfield 114	com/tencent/mobileqq/msf/core/net/c/c:l	I
    //   3396: ifne +36 -> 3432
    //   3399: aload_0
    //   3400: aload 15
    //   3402: invokespecial 1380	com/tencent/mobileqq/msf/core/net/c/c:a	([B)Z
    //   3405: istore 14
    //   3407: iload 14
    //   3409: ifne +23 -> 3432
    //   3412: aload_0
    //   3413: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   3416: getfield 384	com/tencent/mobileqq/msf/core/net/c/c$e:J	Ljava/util/ArrayList;
    //   3419: ldc2_w 473
    //   3422: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3425: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3428: pop
    //   3429: goto -174 -> 3255
    //   3432: aload_0
    //   3433: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3436: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   3439: ifeq +40 -> 3479
    //   3442: iconst_1
    //   3443: aload_0
    //   3444: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3447: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   3450: if_icmpne +6 -> 3456
    //   3453: goto +26 -> 3479
    //   3456: iconst_2
    //   3457: aload_0
    //   3458: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3461: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   3464: if_icmpne +327 -> 3791
    //   3467: aload_0
    //   3468: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3471: getfield 1458	com/tencent/msf/service/protocol/push/a/d:n	J
    //   3474: l2i
    //   3475: istore_2
    //   3476: goto +7 -> 3483
    //   3479: aload 15
    //   3481: arraylength
    //   3482: istore_2
    //   3483: aload_0
    //   3484: iload_2
    //   3485: aload 15
    //   3487: invokespecial 1382	com/tencent/mobileqq/msf/core/net/c/c:a	(I[B)Z
    //   3490: istore 14
    //   3492: iload 14
    //   3494: ifne +6 -> 3500
    //   3497: goto -242 -> 3255
    //   3500: aload_0
    //   3501: invokespecial 1394	com/tencent/mobileqq/msf/core/net/c/c:h	()V
    //   3504: goto +29 -> 3533
    //   3507: astore 15
    //   3509: goto +79 -> 3588
    //   3512: astore 15
    //   3514: ldc 255
    //   3516: iconst_1
    //   3517: ldc_w 1384
    //   3520: aload 15
    //   3522: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3525: aload 15
    //   3527: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   3530: goto -30 -> 3500
    //   3533: aload_0
    //   3534: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3537: getfield 1429	com/tencent/msf/service/protocol/push/a/d:d	J
    //   3540: invokestatic 1390	java/lang/Thread:sleep	(J)V
    //   3543: goto +253 -> 3796
    //   3546: astore 15
    //   3548: new 241	java/lang/StringBuilder
    //   3551: dup
    //   3552: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   3555: astore 16
    //   3557: aload 16
    //   3559: ldc_w 1392
    //   3562: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3565: pop
    //   3566: aload 16
    //   3568: aload 15
    //   3570: invokevirtual 523	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3573: pop
    //   3574: ldc 255
    //   3576: iconst_1
    //   3577: aload 16
    //   3579: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3582: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3585: goto +211 -> 3796
    //   3588: aload_0
    //   3589: invokespecial 1394	com/tencent/mobileqq/msf/core/net/c/c:h	()V
    //   3592: aload 15
    //   3594: athrow
    //   3595: aload_0
    //   3596: getfield 127	com/tencent/mobileqq/msf/core/net/c/c:p	Lcom/tencent/mobileqq/msf/core/net/c/c$e;
    //   3599: getfield 1347	com/tencent/mobileqq/msf/core/net/c/c$e:y	Ljava/util/ArrayList;
    //   3602: iload 4
    //   3604: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3607: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3610: pop
    //   3611: iload_1
    //   3612: iconst_m1
    //   3613: if_icmpne +6 -> 3619
    //   3616: goto +107 -> 3723
    //   3619: iload_1
    //   3620: aload_0
    //   3621: getfield 164	com/tencent/mobileqq/msf/core/net/c/c:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3624: getfield 1140	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   3627: invokevirtual 678	java/util/ArrayList:size	()I
    //   3630: iconst_1
    //   3631: isub
    //   3632: if_icmpne +175 -> 3807
    //   3635: iconst_1
    //   3636: istore 14
    //   3638: goto +3 -> 3641
    //   3641: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3644: ifeq +169 -> 3813
    //   3647: new 241	java/lang/StringBuilder
    //   3650: dup
    //   3651: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   3654: astore 15
    //   3656: aload 15
    //   3658: ldc_w 1248
    //   3661: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3664: pop
    //   3665: aload 15
    //   3667: iload 13
    //   3669: invokevirtual 1251	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3672: pop
    //   3673: ldc 255
    //   3675: iconst_2
    //   3676: aload 15
    //   3678: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3681: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3684: goto +3 -> 3687
    //   3687: iload 13
    //   3689: ifeq +15 -> 3704
    //   3692: aload_0
    //   3693: getstatic 1255	com/tencent/mobileqq/msf/core/net/c/c$e$a:a	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   3696: iload 14
    //   3698: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   3701: goto +12 -> 3713
    //   3704: aload_0
    //   3705: getstatic 1257	com/tencent/mobileqq/msf/core/net/c/c$e$a:b	Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;
    //   3708: iload 14
    //   3710: invokespecial 841	com/tencent/mobileqq/msf/core/net/c/c:b	(Lcom/tencent/mobileqq/msf/core/net/c/c$e$a;Z)V
    //   3713: iload 14
    //   3715: ifeq +8 -> 3723
    //   3718: aload_0
    //   3719: iconst_1
    //   3720: putfield 104	com/tencent/mobileqq/msf/core/net/c/c:f	Z
    //   3723: iload_1
    //   3724: iconst_1
    //   3725: iadd
    //   3726: istore_1
    //   3727: goto -2019 -> 1708
    //   3730: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   3733: return
    //   3734: astore 15
    //   3736: goto +19 -> 3755
    //   3739: astore 15
    //   3741: ldc 255
    //   3743: iconst_1
    //   3744: ldc_w 1522
    //   3747: aload 15
    //   3749: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3752: goto -22 -> 3730
    //   3755: invokestatic 843	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   3758: goto +6 -> 3764
    //   3761: aload 15
    //   3763: athrow
    //   3764: goto -3 -> 3761
    //   3767: astore 15
    //   3769: goto -1855 -> 1914
    //   3772: iconst_0
    //   3773: istore_1
    //   3774: goto -2300 -> 1474
    //   3777: lload 7
    //   3779: bipush 8
    //   3781: lshr
    //   3782: ldc2_w 1471
    //   3785: land
    //   3786: lstore 7
    //   3788: goto -1330 -> 2458
    //   3791: iconst_0
    //   3792: istore_2
    //   3793: goto -310 -> 3483
    //   3796: iload 5
    //   3798: iconst_1
    //   3799: iadd
    //   3800: istore_2
    //   3801: goto -1338 -> 2463
    //   3804: goto -209 -> 3595
    //   3807: iconst_0
    //   3808: istore 14
    //   3810: goto -169 -> 3641
    //   3813: goto -126 -> 3687
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3816	0	this	c
    //   725	3049	1	i1	int
    //   2081	1720	2	i2	int
    //   1707	1462	3	i3	int
    //   1515	2088	4	i4	int
    //   2078	1722	5	i5	int
    //   2726	441	6	i6	int
    //   1476	2311	7	l1	long
    //   1487	1611	9	l2	long
    //   1496	1161	11	l3	long
    //   1972	1716	13	bool1	boolean
    //   2482	1327	14	bool2	boolean
    //   266	1760	15	localObject1	Object
    //   2036	1	15	localException1	Exception
    //   2179	27	15	localStringBuilder1	StringBuilder
    //   2370	1	15	localException2	Exception
    //   2381	1	15	localException3	Exception
    //   2417	1	15	localException4	Exception
    //   2422	26	15	localException5	Exception
    //   2551	34	15	localStringBuilder2	StringBuilder
    //   2600	1	15	localException6	Exception
    //   2707	1	15	localException7	Exception
    //   2712	1	15	localException8	Exception
    //   2804	25	15	localStringBuilder3	StringBuilder
    //   2841	1	15	localException9	Exception
    //   2846	1	15	localException10	Exception
    //   2954	1	15	localException11	Exception
    //   2988	4	15	str	String
    //   3006	1	15	localException12	Exception
    //   3016	1	15	localException13	Exception
    //   3036	1	15	localException14	Exception
    //   3041	1	15	localException15	Exception
    //   3050	1	15	localException16	Exception
    //   3078	1	15	localException17	Exception
    //   3083	1	15	localException18	Exception
    //   3107	1	15	localException19	Exception
    //   3118	1	15	localException20	Exception
    //   3123	30	15	localException21	Exception
    //   3293	1	15	arrayOfByte	byte[]
    //   3361	125	15	localException22	Exception
    //   3507	1	15	localObject2	Object
    //   3512	14	15	localException23	Exception
    //   3546	47	15	localException24	Exception
    //   3654	23	15	localStringBuilder4	StringBuilder
    //   3734	1	15	localObject3	Object
    //   3739	23	15	localException25	Exception
    //   3767	1	15	localException26	Exception
    //   271	3307	16	localObject4	Object
    //   157	557	17	localStringBuilder5	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   1979	2033	2036	java/lang/Exception
    //   2334	2345	2370	java/lang/Exception
    //   2350	2365	2370	java/lang/Exception
    //   2216	2251	2381	java/lang/Exception
    //   2251	2262	2381	java/lang/Exception
    //   2267	2282	2381	java/lang/Exception
    //   2282	2310	2381	java/lang/Exception
    //   2314	2323	2381	java/lang/Exception
    //   2087	2094	2417	java/lang/Exception
    //   2099	2108	2417	java/lang/Exception
    //   2113	2122	2417	java/lang/Exception
    //   2129	2213	2417	java/lang/Exception
    //   2391	2400	2417	java/lang/Exception
    //   2403	2412	2417	java/lang/Exception
    //   1949	1974	2422	java/lang/Exception
    //   2041	2080	2422	java/lang/Exception
    //   2520	2532	2600	java/lang/Exception
    //   2535	2541	2600	java/lang/Exception
    //   2544	2553	2600	java/lang/Exception
    //   2556	2565	2600	java/lang/Exception
    //   2568	2578	2600	java/lang/Exception
    //   2581	2592	2600	java/lang/Exception
    //   2654	2661	2707	java/lang/Exception
    //   2668	2684	2707	java/lang/Exception
    //   2691	2700	2707	java/lang/Exception
    //   2489	2515	2712	java/lang/Exception
    //   2610	2649	2712	java/lang/Exception
    //   2791	2836	2841	java/lang/Exception
    //   2780	2791	2846	java/lang/Exception
    //   2876	2891	2954	java/lang/Exception
    //   2891	2902	2954	java/lang/Exception
    //   2907	2922	2954	java/lang/Exception
    //   2922	2950	2954	java/lang/Exception
    //   2990	3003	3006	java/lang/Exception
    //   2968	2979	3016	java/lang/Exception
    //   2984	2990	3016	java/lang/Exception
    //   2959	2968	3036	java/lang/Exception
    //   2854	2870	3041	java/lang/Exception
    //   2769	2775	3050	java/lang/Exception
    //   3055	3064	3078	java/lang/Exception
    //   2757	2763	3083	java/lang/Exception
    //   3088	3097	3107	java/lang/Exception
    //   2731	2746	3118	java/lang/Exception
    //   2479	2484	3123	java/lang/Exception
    //   3334	3358	3361	java/lang/Exception
    //   3412	3429	3361	java/lang/Exception
    //   3169	3255	3507	finally
    //   3265	3331	3507	finally
    //   3334	3358	3507	finally
    //   3382	3399	3507	finally
    //   3399	3407	3507	finally
    //   3412	3429	3507	finally
    //   3432	3453	3507	finally
    //   3456	3476	3507	finally
    //   3479	3483	3507	finally
    //   3483	3492	3507	finally
    //   3514	3530	3507	finally
    //   3169	3255	3512	java/lang/Exception
    //   3265	3331	3512	java/lang/Exception
    //   3382	3399	3512	java/lang/Exception
    //   3399	3407	3512	java/lang/Exception
    //   3432	3453	3512	java/lang/Exception
    //   3456	3476	3512	java/lang/Exception
    //   3479	3483	3512	java/lang/Exception
    //   3483	3492	3512	java/lang/Exception
    //   3533	3543	3546	java/lang/Exception
    //   1441	1471	3734	finally
    //   1478	1498	3734	finally
    //   1517	1527	3734	finally
    //   1530	1553	3734	finally
    //   1553	1600	3734	finally
    //   1605	1610	3734	finally
    //   1613	1618	3734	finally
    //   1618	1689	3734	finally
    //   1689	1700	3734	finally
    //   1708	1722	3734	finally
    //   1729	1871	3734	finally
    //   1871	1911	3734	finally
    //   1914	1929	3734	finally
    //   1929	1949	3734	finally
    //   1949	1974	3734	finally
    //   1979	2033	3734	finally
    //   2041	2080	3734	finally
    //   2087	2094	3734	finally
    //   2099	2108	3734	finally
    //   2113	2122	3734	finally
    //   2129	2213	3734	finally
    //   2216	2251	3734	finally
    //   2251	2262	3734	finally
    //   2267	2282	3734	finally
    //   2282	2310	3734	finally
    //   2314	2323	3734	finally
    //   2334	2345	3734	finally
    //   2350	2365	3734	finally
    //   2391	2400	3734	finally
    //   2403	2412	3734	finally
    //   2435	2452	3734	finally
    //   2479	2484	3734	finally
    //   2489	2515	3734	finally
    //   2520	2532	3734	finally
    //   2535	2541	3734	finally
    //   2544	2553	3734	finally
    //   2556	2565	3734	finally
    //   2568	2578	3734	finally
    //   2581	2592	3734	finally
    //   2610	2649	3734	finally
    //   2654	2661	3734	finally
    //   2668	2684	3734	finally
    //   2691	2700	3734	finally
    //   2731	2746	3734	finally
    //   2757	2763	3734	finally
    //   2769	2775	3734	finally
    //   2780	2791	3734	finally
    //   2791	2836	3734	finally
    //   2854	2870	3734	finally
    //   2876	2891	3734	finally
    //   2891	2902	3734	finally
    //   2907	2922	3734	finally
    //   2922	2950	3734	finally
    //   2959	2968	3734	finally
    //   2968	2979	3734	finally
    //   2984	2990	3734	finally
    //   2990	3003	3734	finally
    //   3055	3064	3734	finally
    //   3088	3097	3734	finally
    //   3140	3157	3734	finally
    //   3255	3259	3734	finally
    //   3500	3504	3734	finally
    //   3533	3543	3734	finally
    //   3548	3585	3734	finally
    //   3588	3595	3734	finally
    //   3595	3611	3734	finally
    //   3619	3635	3734	finally
    //   3641	3684	3734	finally
    //   3692	3701	3734	finally
    //   3704	3713	3734	finally
    //   3718	3723	3734	finally
    //   3741	3752	3734	finally
    //   1441	1471	3739	java/lang/Exception
    //   1478	1498	3739	java/lang/Exception
    //   1517	1527	3739	java/lang/Exception
    //   1530	1553	3739	java/lang/Exception
    //   1553	1600	3739	java/lang/Exception
    //   1605	1610	3739	java/lang/Exception
    //   1613	1618	3739	java/lang/Exception
    //   1618	1689	3739	java/lang/Exception
    //   1689	1700	3739	java/lang/Exception
    //   1708	1722	3739	java/lang/Exception
    //   1729	1871	3739	java/lang/Exception
    //   1914	1929	3739	java/lang/Exception
    //   1929	1949	3739	java/lang/Exception
    //   2435	2452	3739	java/lang/Exception
    //   3140	3157	3739	java/lang/Exception
    //   3255	3259	3739	java/lang/Exception
    //   3500	3504	3739	java/lang/Exception
    //   3548	3585	3739	java/lang/Exception
    //   3588	3595	3739	java/lang/Exception
    //   3595	3611	3739	java/lang/Exception
    //   3619	3635	3739	java/lang/Exception
    //   3641	3684	3739	java/lang/Exception
    //   3692	3701	3739	java/lang/Exception
    //   3704	3713	3739	java/lang/Exception
    //   3718	3723	3739	java/lang/Exception
    //   1871	1911	3767	java/lang/Exception
  }
  
  public void run()
  {
    try
    {
      if (this.b != null)
      {
        int i1 = e.a[this.a.ordinal()];
        if ((i1 != 1) && (i1 != 2) && (i1 != 3))
        {
          if ((i1 != 4) && (i1 != 5)) {
            return;
          }
          i();
          return;
        }
        c();
        return;
      }
      if (this.c != null)
      {
        l();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.QualityTestManager", 1, "QualityClient start failed, Exception :", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.c
 * JD-Core Version:    0.7.0.1
 */