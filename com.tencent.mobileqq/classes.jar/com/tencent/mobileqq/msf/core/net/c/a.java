package com.tencent.mobileqq.msf.core.net.c;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.msf.service.protocol.push.a.d;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class a
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
  private static HostnameVerifier R = new b();
  long A = 0L;
  long B = 0L;
  long C = 0L;
  long D = 0L;
  long E = 0L;
  private String S = "";
  private int T;
  private int U;
  private boolean V = true;
  a a;
  d b;
  com.tencent.msf.service.protocol.push.a.b c;
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
  d p = new d();
  c q = new c();
  long r = 0L;
  long s = 0L;
  long t = 0L;
  long u = 0L;
  long v = 0L;
  long w = 0L;
  long x = 0L;
  long y = 0L;
  long z = 0L;
  
  public a(d paramd, a parama)
  {
    this.b = paramd;
    this.a = parama;
    this.c = null;
    this.d = 1;
    this.e = 0;
  }
  
  public a(d paramd, com.tencent.msf.service.protocol.push.a.b paramb, a parama, int paramInt1, int paramInt2)
  {
    this.b = paramd;
    this.c = paramb;
    this.a = parama;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  private void a(a.d.a parama)
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
      a(a.d.a.y);
      return;
    }
    if (paramString.indexOf("timeout") > -1)
    {
      a(a.d.a.x);
      return;
    }
    a(a.d.a.e);
  }
  
  private boolean a(int paramInt)
  {
    if (this.a == a.c) {
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
          a(a.d.a.h);
          return false;
        }
      } while (paramInt >= 1);
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, http qualityTestMsg.sPkgData.length:" + this.b.e.length);
      }
      a(a.d.a.i);
      return false;
      if (paramInt > 524288)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + paramInt + " return not http");
        }
        this.V = false;
        a(a.d.a.h);
        return false;
      }
    } while (paramInt >= 1);
    if (QLog.isDevelopLevel()) {
      QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData too short, not http qualityTestMsg.sPkgData.length:" + this.b.e.length);
    }
    a(a.d.a.i);
    return false;
  }
  
  /* Error */
  private boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +45 -> 48
    //   6: ldc 246
    //   8: iconst_2
    //   9: new 248	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 292
    //   19: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: ldc_w 294
    //   29: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: getfield 174	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   36: getfield 296	com/tencent/msf/service/protocol/push/a/d:o	S
    //   39: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: iload_1
    //   49: ldc 238
    //   51: if_icmple +26 -> 77
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield 144	com/tencent/mobileqq/msf/core/net/c/a:V	Z
    //   59: aload_0
    //   60: getstatic 298	com/tencent/mobileqq/msf/core/net/c/a$d$a:A	Lcom/tencent/mobileqq/msf/core/net/c/a$d$a;
    //   63: invokespecial 222	com/tencent/mobileqq/msf/core/net/c/a:a	(Lcom/tencent/mobileqq/msf/core/net/c/a$d$a;)V
    //   66: ldc 246
    //   68: iconst_1
    //   69: ldc_w 300
    //   72: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: iconst_0
    //   76: ireturn
    //   77: getstatic 305	com/tencent/mobileqq/msf/core/net/c/d:a	[I
    //   80: aload_0
    //   81: getfield 176	com/tencent/mobileqq/msf/core/net/c/a:a	Lcom/tencent/mobileqq/msf/core/net/c/a$a;
    //   84: invokevirtual 308	com/tencent/mobileqq/msf/core/net/c/a$a:ordinal	()I
    //   87: iaload
    //   88: tableswitch	default:+3534 -> 3622, 1:+28->116, 2:+850->938, 3:+2340->2428
    //   117: newarray byte
    //   119: astore 9
    //   121: new 310	java/net/DatagramPacket
    //   124: dup
    //   125: aload 9
    //   127: iload_1
    //   128: invokespecial 313	java/net/DatagramPacket:<init>	([BI)V
    //   131: astore 10
    //   133: aload_0
    //   134: invokestatic 319	java/lang/System:currentTimeMillis	()J
    //   137: putfield 158	com/tencent/mobileqq/msf/core/net/c/a:x	J
    //   140: aload_0
    //   141: getfield 120	com/tencent/mobileqq/msf/core/net/c/a:g	Ljava/net/DatagramSocket;
    //   144: aload 10
    //   146: invokevirtual 325	java/net/DatagramSocket:receive	(Ljava/net/DatagramPacket;)V
    //   149: aload_0
    //   150: invokestatic 319	java/lang/System:currentTimeMillis	()J
    //   153: putfield 160	com/tencent/mobileqq/msf/core/net/c/a:y	J
    //   156: aload_0
    //   157: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   160: aload_0
    //   161: getfield 154	com/tencent/mobileqq/msf/core/net/c/a:v	J
    //   164: putfield 327	com/tencent/mobileqq/msf/core/net/c/a$d:M	J
    //   167: aload_0
    //   168: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   171: aload_0
    //   172: getfield 160	com/tencent/mobileqq/msf/core/net/c/a:y	J
    //   175: putfield 329	com/tencent/mobileqq/msf/core/net/c/a$d:N	J
    //   178: aload_0
    //   179: aload_0
    //   180: getfield 160	com/tencent/mobileqq/msf/core/net/c/a:y	J
    //   183: aload_0
    //   184: getfield 154	com/tencent/mobileqq/msf/core/net/c/a:v	J
    //   187: lsub
    //   188: putfield 172	com/tencent/mobileqq/msf/core/net/c/a:E	J
    //   191: aload_0
    //   192: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   195: getfield 332	com/tencent/mobileqq/msf/core/net/c/a$d:J	Ljava/util/ArrayList;
    //   198: aload_0
    //   199: getfield 172	com/tencent/mobileqq/msf/core/net/c/a:E	J
    //   202: invokestatic 337	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   205: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   208: pop
    //   209: aload_0
    //   210: aload_0
    //   211: getfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   214: aload_0
    //   215: getfield 160	com/tencent/mobileqq/msf/core/net/c/a:y	J
    //   218: aload_0
    //   219: getfield 158	com/tencent/mobileqq/msf/core/net/c/a:x	J
    //   222: lsub
    //   223: ladd
    //   224: putfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   227: aload_0
    //   228: aload_0
    //   229: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:D	J
    //   232: aload 10
    //   234: invokevirtual 345	java/net/DatagramPacket:getLength	()I
    //   237: i2l
    //   238: ladd
    //   239: putfield 170	com/tencent/mobileqq/msf/core/net/c/a:D	J
    //   242: aload_0
    //   243: aload_0
    //   244: getfield 347	com/tencent/mobileqq/msf/core/net/c/a:U	I
    //   247: aload 10
    //   249: invokevirtual 345	java/net/DatagramPacket:getLength	()I
    //   252: iadd
    //   253: putfield 347	com/tencent/mobileqq/msf/core/net/c/a:U	I
    //   256: aload_0
    //   257: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   260: astore 11
    //   262: aload 11
    //   264: aload 11
    //   266: getfield 349	com/tencent/mobileqq/msf/core/net/c/a$d:k	I
    //   269: i2l
    //   270: aload_0
    //   271: getfield 172	com/tencent/mobileqq/msf/core/net/c/a:E	J
    //   274: ladd
    //   275: l2i
    //   276: putfield 349	com/tencent/mobileqq/msf/core/net/c/a$d:k	I
    //   279: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +85 -> 367
    //   285: ldc 246
    //   287: iconst_2
    //   288: new 248	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   295: ldc_w 351
    //   298: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload 10
    //   303: invokevirtual 345	java/net/DatagramPacket:getLength	()I
    //   306: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   309: ldc_w 353
    //   312: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_0
    //   316: getfield 172	com/tencent/mobileqq/msf/core/net/c/a:E	J
    //   319: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   322: ldc_w 358
    //   325: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_0
    //   329: getfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   332: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   335: ldc_w 360
    //   338: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_0
    //   342: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:D	J
    //   345: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   348: ldc_w 362
    //   351: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_0
    //   355: getfield 347	com/tencent/mobileqq/msf/core/net/c/a:U	I
    //   358: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   361: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   367: aload_0
    //   368: getfield 174	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   371: getfield 296	com/tencent/msf/service/protocol/push/a/d:o	S
    //   374: ifeq +14 -> 388
    //   377: iconst_1
    //   378: aload_0
    //   379: getfield 174	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   382: getfield 296	com/tencent/msf/service/protocol/push/a/d:o	S
    //   385: if_icmpne +294 -> 679
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
    //   405: invokestatic 366	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
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
    //   422: invokestatic 366	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   425: aload 10
    //   427: invokestatic 372	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   430: aload_2
    //   431: invokestatic 372	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   434: invokevirtual 375	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   437: ifne +108 -> 545
    //   440: aload_0
    //   441: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   444: getfield 332	com/tencent/mobileqq/msf/core/net/c/a$d:J	Ljava/util/ArrayList;
    //   447: aload_0
    //   448: getfield 172	com/tencent/mobileqq/msf/core/net/c/a:E	J
    //   451: invokestatic 337	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   454: invokevirtual 378	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   457: pop
    //   458: new 285	java/lang/Exception
    //   461: dup
    //   462: new 248	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   469: ldc_w 380
    //   472: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: aload_2
    //   476: invokestatic 372	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   479: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokespecial 382	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   488: athrow
    //   489: astore_2
    //   490: aload_0
    //   491: aload_2
    //   492: invokevirtual 383	java/lang/Exception:toString	()Ljava/lang/String;
    //   495: invokevirtual 386	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   498: invokespecial 388	com/tencent/mobileqq/msf/core/net/c/a:a	(Ljava/lang/String;)V
    //   501: ldc 246
    //   503: iconst_1
    //   504: ldc_w 390
    //   507: aload_2
    //   508: invokestatic 393	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   511: aload_0
    //   512: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   515: astore_2
    //   516: aload_2
    //   517: aload_2
    //   518: getfield 395	com/tencent/mobileqq/msf/core/net/c/a$d:n	I
    //   521: iconst_1
    //   522: iadd
    //   523: putfield 395	com/tencent/mobileqq/msf/core/net/c/a$d:n	I
    //   526: aload_0
    //   527: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   530: getfield 332	com/tencent/mobileqq/msf/core/net/c/a$d:J	Ljava/util/ArrayList;
    //   533: ldc2_w 396
    //   536: invokestatic 337	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   539: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   542: pop
    //   543: iconst_0
    //   544: ireturn
    //   545: ldc 246
    //   547: iconst_1
    //   548: new 248	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   555: ldc_w 399
    //   558: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: iload_1
    //   562: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   565: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: aload_0
    //   572: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   575: astore_2
    //   576: aload_2
    //   577: aload_2
    //   578: getfield 400	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   581: iconst_1
    //   582: iadd
    //   583: putfield 400	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   586: aload 9
    //   588: ifnull +3036 -> 3624
    //   591: aload 9
    //   593: arraylength
    //   594: iconst_4
    //   595: if_icmplt +3029 -> 3624
    //   598: aload 9
    //   600: iconst_0
    //   601: invokestatic 405	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   604: istore_1
    //   605: aload 9
    //   607: aload 9
    //   609: arraylength
    //   610: iconst_4
    //   611: isub
    //   612: invokestatic 405	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   615: istore_3
    //   616: iload_3
    //   617: i2l
    //   618: invokestatic 410	com/tencent/qphone/base/util/e:a	(J)Ljava/net/InetAddress;
    //   621: astore_2
    //   622: ldc 246
    //   624: iconst_1
    //   625: new 248	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   632: ldc_w 412
    //   635: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: iload_1
    //   639: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   642: ldc_w 414
    //   645: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: aload_2
    //   649: invokevirtual 417	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   652: ldc_w 419
    //   655: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: iload_3
    //   659: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   662: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   665: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   668: aload_0
    //   669: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   672: aload_2
    //   673: putfield 421	com/tencent/mobileqq/msf/core/net/c/a$d:d	Ljava/net/InetAddress;
    //   676: goto +2948 -> 3624
    //   679: iconst_2
    //   680: aload_0
    //   681: getfield 174	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   684: getfield 296	com/tencent/msf/service/protocol/push/a/d:o	S
    //   687: if_icmpne -101 -> 586
    //   690: aload 10
    //   692: invokevirtual 425	java/net/DatagramPacket:getAddress	()Ljava/net/InetAddress;
    //   695: aload_0
    //   696: getfield 132	com/tencent/mobileqq/msf/core/net/c/a:n	Ljava/net/InetAddress;
    //   699: invokevirtual 428	java/net/InetAddress:equals	(Ljava/lang/Object;)Z
    //   702: ifeq +15 -> 717
    //   705: aload 10
    //   707: invokevirtual 431	java/net/DatagramPacket:getPort	()I
    //   710: aload_0
    //   711: getfield 433	com/tencent/mobileqq/msf/core/net/c/a:o	I
    //   714: if_icmpeq +109 -> 823
    //   717: aload_0
    //   718: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   721: astore_2
    //   722: aload_2
    //   723: aload_2
    //   724: getfield 400	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   727: iconst_1
    //   728: iadd
    //   729: putfield 400	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   732: aload_0
    //   733: getstatic 435	com/tencent/mobileqq/msf/core/net/c/a$d$a:v	Lcom/tencent/mobileqq/msf/core/net/c/a$d$a;
    //   736: invokespecial 222	com/tencent/mobileqq/msf/core/net/c/a:a	(Lcom/tencent/mobileqq/msf/core/net/c/a$d$a;)V
    //   739: ldc 246
    //   741: iconst_2
    //   742: new 248	java/lang/StringBuilder
    //   745: dup
    //   746: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   749: ldc_w 437
    //   752: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: aload_0
    //   756: getfield 132	com/tencent/mobileqq/msf/core/net/c/a:n	Ljava/net/InetAddress;
    //   759: invokevirtual 438	java/net/InetAddress:toString	()Ljava/lang/String;
    //   762: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: ldc_w 440
    //   768: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: aload_0
    //   772: getfield 433	com/tencent/mobileqq/msf/core/net/c/a:o	I
    //   775: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   778: ldc_w 442
    //   781: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: aload 10
    //   786: invokevirtual 425	java/net/DatagramPacket:getAddress	()Ljava/net/InetAddress;
    //   789: invokevirtual 438	java/net/InetAddress:toString	()Ljava/lang/String;
    //   792: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: ldc_w 440
    //   798: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: aload 10
    //   803: invokevirtual 431	java/net/DatagramPacket:getPort	()I
    //   806: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   809: ldc_w 444
    //   812: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   821: iconst_0
    //   822: ireturn
    //   823: ldc 246
    //   825: iconst_2
    //   826: new 248	java/lang/StringBuilder
    //   829: dup
    //   830: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   833: ldc_w 446
    //   836: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: aload_0
    //   840: getfield 132	com/tencent/mobileqq/msf/core/net/c/a:n	Ljava/net/InetAddress;
    //   843: invokevirtual 438	java/net/InetAddress:toString	()Ljava/lang/String;
    //   846: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: ldc_w 440
    //   852: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   855: aload_0
    //   856: getfield 433	com/tencent/mobileqq/msf/core/net/c/a:o	I
    //   859: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   862: ldc_w 442
    //   865: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: aload 10
    //   870: invokevirtual 425	java/net/DatagramPacket:getAddress	()Ljava/net/InetAddress;
    //   873: invokevirtual 438	java/net/InetAddress:toString	()Ljava/lang/String;
    //   876: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: ldc_w 440
    //   882: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: aload 10
    //   887: invokevirtual 431	java/net/DatagramPacket:getPort	()I
    //   890: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   893: ldc_w 444
    //   896: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   902: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   905: aload_0
    //   906: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   909: astore_2
    //   910: aload_2
    //   911: aload_2
    //   912: getfield 400	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   915: iconst_1
    //   916: iadd
    //   917: putfield 400	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   920: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   923: ifeq -337 -> 586
    //   926: ldc 246
    //   928: iconst_2
    //   929: ldc_w 448
    //   932: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   935: goto -349 -> 586
    //   938: aconst_null
    //   939: astore 10
    //   941: aconst_null
    //   942: astore 9
    //   944: aload_0
    //   945: getfield 122	com/tencent/mobileqq/msf/core/net/c/a:h	Ljava/net/Socket;
    //   948: invokevirtual 454	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   951: astore 11
    //   953: aload 11
    //   955: astore 9
    //   957: aload 11
    //   959: astore 10
    //   961: getstatic 458	com/tencent/mobileqq/msf/core/net/c/g:f	Ljava/util/ArrayList;
    //   964: aload 11
    //   966: invokevirtual 459	java/lang/Object:toString	()Ljava/lang/String;
    //   969: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   972: pop
    //   973: aload 11
    //   975: astore 9
    //   977: aload 11
    //   979: astore 10
    //   981: iload_1
    //   982: newarray byte
    //   984: astore 12
    //   986: iconst_0
    //   987: istore 6
    //   989: aload 11
    //   991: astore 9
    //   993: aload 11
    //   995: astore 10
    //   997: aload 11
    //   999: aload 12
    //   1001: invokevirtual 465	java/io/InputStream:read	([B)I
    //   1004: istore_3
    //   1005: aload 11
    //   1007: astore 9
    //   1009: aload 11
    //   1011: astore 10
    //   1013: aload_0
    //   1014: invokestatic 319	java/lang/System:currentTimeMillis	()J
    //   1017: putfield 156	com/tencent/mobileqq/msf/core/net/c/a:w	J
    //   1020: aload 11
    //   1022: astore 9
    //   1024: aload 11
    //   1026: astore 10
    //   1028: aload_0
    //   1029: aload_0
    //   1030: getfield 164	com/tencent/mobileqq/msf/core/net/c/a:A	J
    //   1033: aload_0
    //   1034: getfield 156	com/tencent/mobileqq/msf/core/net/c/a:w	J
    //   1037: aload_0
    //   1038: getfield 154	com/tencent/mobileqq/msf/core/net/c/a:v	J
    //   1041: lsub
    //   1042: ladd
    //   1043: putfield 164	com/tencent/mobileqq/msf/core/net/c/a:A	J
    //   1046: aload 11
    //   1048: astore 9
    //   1050: aload 11
    //   1052: astore 10
    //   1054: ldc 246
    //   1056: iconst_1
    //   1057: new 248	java/lang/StringBuilder
    //   1060: dup
    //   1061: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   1064: ldc_w 467
    //   1067: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: aload_2
    //   1071: arraylength
    //   1072: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1075: ldc_w 469
    //   1078: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: aload_0
    //   1082: getfield 156	com/tencent/mobileqq/msf/core/net/c/a:w	J
    //   1085: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1088: ldc_w 471
    //   1091: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1094: aload_0
    //   1095: getfield 154	com/tencent/mobileqq/msf/core/net/c/a:v	J
    //   1098: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1101: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1104: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1107: aload 11
    //   1109: astore 9
    //   1111: aload 11
    //   1113: astore 10
    //   1115: aload_0
    //   1116: getfield 156	com/tencent/mobileqq/msf/core/net/c/a:w	J
    //   1119: lstore 7
    //   1121: aload 11
    //   1123: astore 9
    //   1125: aload 11
    //   1127: astore 10
    //   1129: aload_0
    //   1130: lload 7
    //   1132: putfield 158	com/tencent/mobileqq/msf/core/net/c/a:x	J
    //   1135: aload 11
    //   1137: astore 9
    //   1139: aload 11
    //   1141: astore 10
    //   1143: aload_0
    //   1144: lload 7
    //   1146: putfield 160	com/tencent/mobileqq/msf/core/net/c/a:y	J
    //   1149: iload_3
    //   1150: istore 5
    //   1152: iload_3
    //   1153: iconst_m1
    //   1154: if_icmpeq +53 -> 1207
    //   1157: iload_3
    //   1158: istore 4
    //   1160: iload_3
    //   1161: istore 5
    //   1163: iload 4
    //   1165: istore 6
    //   1167: iload 4
    //   1169: iload_1
    //   1170: if_icmpge +37 -> 1207
    //   1173: aload 11
    //   1175: astore 9
    //   1177: aload 11
    //   1179: astore 10
    //   1181: aload 11
    //   1183: aload 12
    //   1185: iload 4
    //   1187: iload_1
    //   1188: iload 4
    //   1190: isub
    //   1191: invokevirtual 474	java/io/InputStream:read	([BII)I
    //   1194: istore_3
    //   1195: iconst_m1
    //   1196: iload_3
    //   1197: if_icmpne +219 -> 1416
    //   1200: iload 4
    //   1202: istore 6
    //   1204: iload_3
    //   1205: istore 5
    //   1207: iconst_m1
    //   1208: iload 5
    //   1210: if_icmpne +381 -> 1591
    //   1213: aload 11
    //   1215: ifnull +23 -> 1238
    //   1218: aload 11
    //   1220: astore 9
    //   1222: aload 11
    //   1224: astore 10
    //   1226: getstatic 458	com/tencent/mobileqq/msf/core/net/c/g:f	Ljava/util/ArrayList;
    //   1229: aload 11
    //   1231: invokevirtual 459	java/lang/Object:toString	()Ljava/lang/String;
    //   1234: invokevirtual 378	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   1237: pop
    //   1238: aload 11
    //   1240: astore 9
    //   1242: aload 11
    //   1244: astore 10
    //   1246: aload_0
    //   1247: getstatic 234	com/tencent/mobileqq/msf/core/net/c/a$d$a:e	Lcom/tencent/mobileqq/msf/core/net/c/a$d$a;
    //   1250: invokespecial 222	com/tencent/mobileqq/msf/core/net/c/a:a	(Lcom/tencent/mobileqq/msf/core/net/c/a$d$a;)V
    //   1253: aload 11
    //   1255: astore 9
    //   1257: aload 11
    //   1259: astore 10
    //   1261: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1264: ifeq +48 -> 1312
    //   1267: aload 11
    //   1269: astore 9
    //   1271: aload 11
    //   1273: astore 10
    //   1275: ldc 246
    //   1277: iconst_4
    //   1278: new 248	java/lang/StringBuilder
    //   1281: dup
    //   1282: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   1285: ldc_w 476
    //   1288: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1291: iload 6
    //   1293: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1296: ldc_w 478
    //   1299: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: iload_1
    //   1303: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1306: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1309: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1312: aload 11
    //   1314: astore 9
    //   1316: aload 11
    //   1318: astore 10
    //   1320: aload_0
    //   1321: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1324: getfield 332	com/tencent/mobileqq/msf/core/net/c/a$d:J	Ljava/util/ArrayList;
    //   1327: ldc2_w 396
    //   1330: invokestatic 337	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1333: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1336: pop
    //   1337: aload 11
    //   1339: ifnull +2281 -> 3620
    //   1342: aload 11
    //   1344: invokevirtual 481	java/io/InputStream:close	()V
    //   1347: iconst_0
    //   1348: ireturn
    //   1349: astore_2
    //   1350: aload_2
    //   1351: invokevirtual 484	java/lang/Throwable:printStackTrace	()V
    //   1354: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1357: ifeq +2263 -> 3620
    //   1360: ldc 246
    //   1362: iconst_4
    //   1363: ldc_w 486
    //   1366: aload_2
    //   1367: invokestatic 393	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1370: iconst_0
    //   1371: ireturn
    //   1372: astore_2
    //   1373: aload_0
    //   1374: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1377: astore_2
    //   1378: aload_2
    //   1379: aload_2
    //   1380: getfield 395	com/tencent/mobileqq/msf/core/net/c/a$d:n	I
    //   1383: iconst_1
    //   1384: iadd
    //   1385: putfield 395	com/tencent/mobileqq/msf/core/net/c/a$d:n	I
    //   1388: aload_0
    //   1389: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1392: getfield 332	com/tencent/mobileqq/msf/core/net/c/a$d:J	Ljava/util/ArrayList;
    //   1395: ldc2_w 396
    //   1398: invokestatic 337	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1401: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1404: pop
    //   1405: ldc 246
    //   1407: iconst_1
    //   1408: ldc_w 488
    //   1411: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1414: iconst_0
    //   1415: ireturn
    //   1416: iload 4
    //   1418: iload_3
    //   1419: iadd
    //   1420: istore 4
    //   1422: aload 11
    //   1424: astore 9
    //   1426: aload 11
    //   1428: astore 10
    //   1430: aload_0
    //   1431: invokestatic 319	java/lang/System:currentTimeMillis	()J
    //   1434: putfield 160	com/tencent/mobileqq/msf/core/net/c/a:y	J
    //   1437: goto -277 -> 1160
    //   1440: astore_2
    //   1441: aload 9
    //   1443: ifnull +19 -> 1462
    //   1446: aload 9
    //   1448: astore 10
    //   1450: getstatic 458	com/tencent/mobileqq/msf/core/net/c/g:f	Ljava/util/ArrayList;
    //   1453: aload 9
    //   1455: invokevirtual 459	java/lang/Object:toString	()Ljava/lang/String;
    //   1458: invokevirtual 378	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   1461: pop
    //   1462: aload 9
    //   1464: astore 10
    //   1466: aload_0
    //   1467: aload_2
    //   1468: invokevirtual 383	java/lang/Exception:toString	()Ljava/lang/String;
    //   1471: invokevirtual 386	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1474: invokespecial 388	com/tencent/mobileqq/msf/core/net/c/a:a	(Ljava/lang/String;)V
    //   1477: aload 9
    //   1479: astore 10
    //   1481: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1484: ifeq +17 -> 1501
    //   1487: aload 9
    //   1489: astore 10
    //   1491: ldc 246
    //   1493: iconst_4
    //   1494: ldc_w 490
    //   1497: aload_2
    //   1498: invokestatic 393	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1501: aload 9
    //   1503: astore 10
    //   1505: aload_0
    //   1506: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1509: astore 11
    //   1511: aload 9
    //   1513: astore 10
    //   1515: aload 11
    //   1517: aload 11
    //   1519: getfield 395	com/tencent/mobileqq/msf/core/net/c/a$d:n	I
    //   1522: iconst_1
    //   1523: iadd
    //   1524: putfield 395	com/tencent/mobileqq/msf/core/net/c/a$d:n	I
    //   1527: aload 9
    //   1529: astore 10
    //   1531: aload_0
    //   1532: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1535: getfield 332	com/tencent/mobileqq/msf/core/net/c/a$d:J	Ljava/util/ArrayList;
    //   1538: ldc2_w 396
    //   1541: invokestatic 337	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1544: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1547: pop
    //   1548: aload 9
    //   1550: astore 10
    //   1552: aload_2
    //   1553: invokevirtual 491	java/lang/Exception:printStackTrace	()V
    //   1556: aload 9
    //   1558: ifnull +2062 -> 3620
    //   1561: aload 9
    //   1563: invokevirtual 481	java/io/InputStream:close	()V
    //   1566: iconst_0
    //   1567: ireturn
    //   1568: astore_2
    //   1569: aload_2
    //   1570: invokevirtual 484	java/lang/Throwable:printStackTrace	()V
    //   1573: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1576: ifeq +2044 -> 3620
    //   1579: ldc 246
    //   1581: iconst_4
    //   1582: ldc_w 486
    //   1585: aload_2
    //   1586: invokestatic 393	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1589: iconst_0
    //   1590: ireturn
    //   1591: aload 11
    //   1593: astore 9
    //   1595: aload 11
    //   1597: astore 10
    //   1599: getstatic 458	com/tencent/mobileqq/msf/core/net/c/g:f	Ljava/util/ArrayList;
    //   1602: aload 11
    //   1604: invokevirtual 459	java/lang/Object:toString	()Ljava/lang/String;
    //   1607: invokevirtual 378	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   1610: pop
    //   1611: aload 11
    //   1613: astore 9
    //   1615: aload 11
    //   1617: astore 10
    //   1619: aload_0
    //   1620: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1623: aload_0
    //   1624: getfield 154	com/tencent/mobileqq/msf/core/net/c/a:v	J
    //   1627: putfield 327	com/tencent/mobileqq/msf/core/net/c/a$d:M	J
    //   1630: aload 11
    //   1632: astore 9
    //   1634: aload 11
    //   1636: astore 10
    //   1638: aload_0
    //   1639: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1642: aload_0
    //   1643: getfield 160	com/tencent/mobileqq/msf/core/net/c/a:y	J
    //   1646: putfield 329	com/tencent/mobileqq/msf/core/net/c/a$d:N	J
    //   1649: aload 11
    //   1651: astore 9
    //   1653: aload 11
    //   1655: astore 10
    //   1657: aload_0
    //   1658: aload_0
    //   1659: getfield 160	com/tencent/mobileqq/msf/core/net/c/a:y	J
    //   1662: aload_0
    //   1663: getfield 154	com/tencent/mobileqq/msf/core/net/c/a:v	J
    //   1666: lsub
    //   1667: putfield 172	com/tencent/mobileqq/msf/core/net/c/a:E	J
    //   1670: aload 11
    //   1672: astore 9
    //   1674: aload 11
    //   1676: astore 10
    //   1678: aload_0
    //   1679: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1682: getfield 332	com/tencent/mobileqq/msf/core/net/c/a$d:J	Ljava/util/ArrayList;
    //   1685: aload_0
    //   1686: getfield 172	com/tencent/mobileqq/msf/core/net/c/a:E	J
    //   1689: invokestatic 337	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1692: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1695: pop
    //   1696: aload 11
    //   1698: astore 9
    //   1700: aload 11
    //   1702: astore 10
    //   1704: aload_0
    //   1705: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   1708: astore 13
    //   1710: aload 11
    //   1712: astore 9
    //   1714: aload 11
    //   1716: astore 10
    //   1718: aload 13
    //   1720: aload 13
    //   1722: getfield 349	com/tencent/mobileqq/msf/core/net/c/a$d:k	I
    //   1725: i2l
    //   1726: aload_0
    //   1727: getfield 172	com/tencent/mobileqq/msf/core/net/c/a:E	J
    //   1730: ladd
    //   1731: l2i
    //   1732: putfield 349	com/tencent/mobileqq/msf/core/net/c/a$d:k	I
    //   1735: aload 11
    //   1737: astore 9
    //   1739: aload 11
    //   1741: astore 10
    //   1743: aload_0
    //   1744: aload_0
    //   1745: getfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   1748: aload_0
    //   1749: getfield 160	com/tencent/mobileqq/msf/core/net/c/a:y	J
    //   1752: aload_0
    //   1753: getfield 158	com/tencent/mobileqq/msf/core/net/c/a:x	J
    //   1756: lsub
    //   1757: ladd
    //   1758: putfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   1761: aload 11
    //   1763: astore 9
    //   1765: aload 11
    //   1767: astore 10
    //   1769: aload_0
    //   1770: aload_0
    //   1771: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:D	J
    //   1774: iload_1
    //   1775: i2l
    //   1776: ladd
    //   1777: putfield 170	com/tencent/mobileqq/msf/core/net/c/a:D	J
    //   1780: aload 11
    //   1782: astore 9
    //   1784: aload 11
    //   1786: astore 10
    //   1788: aload_0
    //   1789: aload_0
    //   1790: getfield 347	com/tencent/mobileqq/msf/core/net/c/a:U	I
    //   1793: iload_1
    //   1794: iadd
    //   1795: putfield 347	com/tencent/mobileqq/msf/core/net/c/a:U	I
    //   1798: aload 11
    //   1800: astore 9
    //   1802: aload 11
    //   1804: astore 10
    //   1806: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1809: ifeq +90 -> 1899
    //   1812: aload 11
    //   1814: astore 9
    //   1816: aload 11
    //   1818: astore 10
    //   1820: ldc 246
    //   1822: iconst_2
    //   1823: new 248	java/lang/StringBuilder
    //   1826: dup
    //   1827: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   1830: ldc_w 493
    //   1833: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1836: iload 6
    //   1838: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1841: ldc_w 353
    //   1844: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1847: aload_0
    //   1848: getfield 172	com/tencent/mobileqq/msf/core/net/c/a:E	J
    //   1851: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1854: ldc_w 358
    //   1857: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1860: aload_0
    //   1861: getfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   1864: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1867: ldc_w 360
    //   1870: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1873: aload_0
    //   1874: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:D	J
    //   1877: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1880: ldc_w 362
    //   1883: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1886: aload_0
    //   1887: getfield 347	com/tencent/mobileqq/msf/core/net/c/a:U	I
    //   1890: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1893: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1896: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1899: aload 11
    //   1901: astore 9
    //   1903: aload 11
    //   1905: astore 10
    //   1907: aload_0
    //   1908: getfield 174	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1911: getfield 296	com/tencent/msf/service/protocol/push/a/d:o	S
    //   1914: ifeq +22 -> 1936
    //   1917: aload 11
    //   1919: astore 9
    //   1921: aload 11
    //   1923: astore 10
    //   1925: iconst_1
    //   1926: aload_0
    //   1927: getfield 174	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1930: getfield 296	com/tencent/msf/service/protocol/push/a/d:o	S
    //   1933: if_icmpne +411 -> 2344
    //   1936: aload 11
    //   1938: astore 9
    //   1940: aload 11
    //   1942: astore 10
    //   1944: aload_2
    //   1945: arraylength
    //   1946: bipush 8
    //   1948: isub
    //   1949: newarray byte
    //   1951: astore 13
    //   1953: aload 11
    //   1955: astore 9
    //   1957: aload 11
    //   1959: astore 10
    //   1961: aload_2
    //   1962: iconst_0
    //   1963: aload 13
    //   1965: iconst_0
    //   1966: aload 13
    //   1968: arraylength
    //   1969: invokestatic 366	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1972: aload 11
    //   1974: astore 9
    //   1976: aload 11
    //   1978: astore 10
    //   1980: iload_1
    //   1981: bipush 8
    //   1983: isub
    //   1984: newarray byte
    //   1986: astore_2
    //   1987: aload 11
    //   1989: astore 9
    //   1991: aload 11
    //   1993: astore 10
    //   1995: aload 12
    //   1997: iconst_0
    //   1998: aload_2
    //   1999: iconst_0
    //   2000: aload_2
    //   2001: arraylength
    //   2002: invokestatic 366	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2005: aload 11
    //   2007: astore 9
    //   2009: aload 11
    //   2011: astore 10
    //   2013: aload 13
    //   2015: invokestatic 372	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   2018: aload_2
    //   2019: invokestatic 372	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   2022: invokevirtual 375	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2025: ifne +81 -> 2106
    //   2028: aload 11
    //   2030: astore 9
    //   2032: aload 11
    //   2034: astore 10
    //   2036: aload_0
    //   2037: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2040: getfield 332	com/tencent/mobileqq/msf/core/net/c/a$d:J	Ljava/util/ArrayList;
    //   2043: aload_0
    //   2044: getfield 172	com/tencent/mobileqq/msf/core/net/c/a:E	J
    //   2047: invokestatic 337	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2050: invokevirtual 378	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   2053: pop
    //   2054: aload 11
    //   2056: astore 9
    //   2058: aload 11
    //   2060: astore 10
    //   2062: new 285	java/lang/Exception
    //   2065: dup
    //   2066: new 248	java/lang/StringBuilder
    //   2069: dup
    //   2070: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   2073: ldc_w 380
    //   2076: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2079: aload_2
    //   2080: invokestatic 372	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   2083: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2086: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2089: invokespecial 382	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   2092: athrow
    //   2093: astore_2
    //   2094: aload 10
    //   2096: ifnull +8 -> 2104
    //   2099: aload 10
    //   2101: invokevirtual 481	java/io/InputStream:close	()V
    //   2104: aload_2
    //   2105: athrow
    //   2106: aload 11
    //   2108: astore 9
    //   2110: aload 11
    //   2112: astore 10
    //   2114: ldc 246
    //   2116: iconst_1
    //   2117: new 248	java/lang/StringBuilder
    //   2120: dup
    //   2121: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   2124: ldc_w 495
    //   2127: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2130: iload_1
    //   2131: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2134: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2137: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2140: aload 11
    //   2142: astore 9
    //   2144: aload 11
    //   2146: astore 10
    //   2148: aload_0
    //   2149: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2152: astore_2
    //   2153: aload 11
    //   2155: astore 9
    //   2157: aload 11
    //   2159: astore 10
    //   2161: aload_2
    //   2162: aload_2
    //   2163: getfield 400	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   2166: iconst_1
    //   2167: iadd
    //   2168: putfield 400	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   2171: aload 12
    //   2173: ifnull +134 -> 2307
    //   2176: aload 11
    //   2178: astore 9
    //   2180: aload 11
    //   2182: astore 10
    //   2184: aload 12
    //   2186: arraylength
    //   2187: iconst_4
    //   2188: if_icmplt +119 -> 2307
    //   2191: aload 11
    //   2193: astore 9
    //   2195: aload 11
    //   2197: astore 10
    //   2199: aload 12
    //   2201: aload 12
    //   2203: arraylength
    //   2204: iconst_4
    //   2205: isub
    //   2206: invokestatic 405	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   2209: istore_3
    //   2210: aload 11
    //   2212: astore 9
    //   2214: aload 11
    //   2216: astore 10
    //   2218: iload_3
    //   2219: i2l
    //   2220: invokestatic 410	com/tencent/qphone/base/util/e:a	(J)Ljava/net/InetAddress;
    //   2223: astore_2
    //   2224: aload 11
    //   2226: astore 9
    //   2228: aload 11
    //   2230: astore 10
    //   2232: ldc 246
    //   2234: iconst_1
    //   2235: new 248	java/lang/StringBuilder
    //   2238: dup
    //   2239: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   2242: ldc_w 497
    //   2245: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2248: iload_1
    //   2249: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2252: ldc_w 499
    //   2255: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2258: aload_0
    //   2259: getfield 172	com/tencent/mobileqq/msf/core/net/c/a:E	J
    //   2262: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2265: ldc_w 414
    //   2268: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2271: aload_2
    //   2272: invokevirtual 417	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2275: ldc_w 419
    //   2278: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2281: iload_3
    //   2282: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2285: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2288: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2291: aload 11
    //   2293: astore 9
    //   2295: aload 11
    //   2297: astore 10
    //   2299: aload_0
    //   2300: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2303: aload_2
    //   2304: putfield 421	com/tencent/mobileqq/msf/core/net/c/a$d:d	Ljava/net/InetAddress;
    //   2307: aload 11
    //   2309: ifnull +1315 -> 3624
    //   2312: aload 11
    //   2314: invokevirtual 481	java/io/InputStream:close	()V
    //   2317: goto +1307 -> 3624
    //   2320: astore_2
    //   2321: aload_2
    //   2322: invokevirtual 484	java/lang/Throwable:printStackTrace	()V
    //   2325: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2328: ifeq +1296 -> 3624
    //   2331: ldc 246
    //   2333: iconst_4
    //   2334: ldc_w 486
    //   2337: aload_2
    //   2338: invokestatic 393	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2341: goto +1283 -> 3624
    //   2344: aload 11
    //   2346: astore 9
    //   2348: aload 11
    //   2350: astore 10
    //   2352: iconst_2
    //   2353: aload_0
    //   2354: getfield 174	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2357: getfield 296	com/tencent/msf/service/protocol/push/a/d:o	S
    //   2360: if_icmpne -189 -> 2171
    //   2363: aload 11
    //   2365: astore 9
    //   2367: aload 11
    //   2369: astore 10
    //   2371: aload_0
    //   2372: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2375: astore_2
    //   2376: aload 11
    //   2378: astore 9
    //   2380: aload 11
    //   2382: astore 10
    //   2384: aload_2
    //   2385: aload_2
    //   2386: getfield 400	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   2389: iconst_1
    //   2390: iadd
    //   2391: putfield 400	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   2394: aload 11
    //   2396: astore 9
    //   2398: aload 11
    //   2400: astore 10
    //   2402: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2405: ifeq -234 -> 2171
    //   2408: aload 11
    //   2410: astore 9
    //   2412: aload 11
    //   2414: astore 10
    //   2416: ldc 246
    //   2418: iconst_2
    //   2419: ldc_w 501
    //   2422: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2425: goto -254 -> 2171
    //   2428: aconst_null
    //   2429: astore_2
    //   2430: aload_0
    //   2431: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2434: aload_0
    //   2435: getfield 503	com/tencent/mobileqq/msf/core/net/c/a:k	Ljava/net/HttpURLConnection;
    //   2438: invokevirtual 508	java/net/HttpURLConnection:getResponseCode	()I
    //   2441: putfield 510	com/tencent/mobileqq/msf/core/net/c/a$d:G	I
    //   2444: aload_0
    //   2445: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2448: aload_0
    //   2449: getfield 503	com/tencent/mobileqq/msf/core/net/c/a:k	Ljava/net/HttpURLConnection;
    //   2452: invokevirtual 513	java/net/HttpURLConnection:getContentLength	()I
    //   2455: putfield 515	com/tencent/mobileqq/msf/core/net/c/a$d:H	I
    //   2458: aload_0
    //   2459: invokestatic 319	java/lang/System:currentTimeMillis	()J
    //   2462: putfield 156	com/tencent/mobileqq/msf/core/net/c/a:w	J
    //   2465: aload_0
    //   2466: aload_0
    //   2467: getfield 156	com/tencent/mobileqq/msf/core/net/c/a:w	J
    //   2470: aload_0
    //   2471: getfield 154	com/tencent/mobileqq/msf/core/net/c/a:v	J
    //   2474: lsub
    //   2475: putfield 164	com/tencent/mobileqq/msf/core/net/c/a:A	J
    //   2478: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2481: ifeq +61 -> 2542
    //   2484: ldc 246
    //   2486: iconst_4
    //   2487: new 248	java/lang/StringBuilder
    //   2490: dup
    //   2491: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   2494: ldc_w 517
    //   2497: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2500: aload_0
    //   2501: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2504: getfield 510	com/tencent/mobileqq/msf/core/net/c/a$d:G	I
    //   2507: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2510: ldc_w 478
    //   2513: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2516: iload_1
    //   2517: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2520: ldc_w 519
    //   2523: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2526: aload_0
    //   2527: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2530: getfield 515	com/tencent/mobileqq/msf/core/net/c/a$d:H	I
    //   2533: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2536: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2539: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2542: aload_0
    //   2543: getfield 156	com/tencent/mobileqq/msf/core/net/c/a:w	J
    //   2546: lstore 7
    //   2548: aload_0
    //   2549: lload 7
    //   2551: putfield 158	com/tencent/mobileqq/msf/core/net/c/a:x	J
    //   2554: aload_0
    //   2555: lload 7
    //   2557: putfield 160	com/tencent/mobileqq/msf/core/net/c/a:y	J
    //   2560: new 521	java/io/BufferedInputStream
    //   2563: dup
    //   2564: aload_0
    //   2565: getfield 503	com/tencent/mobileqq/msf/core/net/c/a:k	Ljava/net/HttpURLConnection;
    //   2568: invokevirtual 522	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2571: invokespecial 525	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   2574: astore 9
    //   2576: getstatic 458	com/tencent/mobileqq/msf/core/net/c/g:f	Ljava/util/ArrayList;
    //   2579: aload 9
    //   2581: invokevirtual 459	java/lang/Object:toString	()Ljava/lang/String;
    //   2584: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2587: pop
    //   2588: sipush 1024
    //   2591: newarray byte
    //   2593: astore 10
    //   2595: iload_1
    //   2596: newarray byte
    //   2598: astore_2
    //   2599: iconst_0
    //   2600: istore_3
    //   2601: iload_3
    //   2602: iload_1
    //   2603: if_icmpge +311 -> 2914
    //   2606: aload 9
    //   2608: aload 10
    //   2610: invokevirtual 465	java/io/InputStream:read	([B)I
    //   2613: istore 4
    //   2615: iload 4
    //   2617: iconst_m1
    //   2618: if_icmpeq +296 -> 2914
    //   2621: iload 4
    //   2623: iload_1
    //   2624: if_icmple +116 -> 2740
    //   2627: aload 10
    //   2629: iconst_0
    //   2630: aload_2
    //   2631: iload_3
    //   2632: iload_1
    //   2633: invokestatic 366	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2636: iload 4
    //   2638: iload_3
    //   2639: iadd
    //   2640: istore_3
    //   2641: aload_0
    //   2642: invokestatic 319	java/lang/System:currentTimeMillis	()J
    //   2645: putfield 160	com/tencent/mobileqq/msf/core/net/c/a:y	J
    //   2648: iload_3
    //   2649: ldc_w 526
    //   2652: if_icmple +965 -> 3617
    //   2655: aload 9
    //   2657: ifnull +15 -> 2672
    //   2660: getstatic 458	com/tencent/mobileqq/msf/core/net/c/g:f	Ljava/util/ArrayList;
    //   2663: aload 9
    //   2665: invokevirtual 459	java/lang/Object:toString	()Ljava/lang/String;
    //   2668: invokevirtual 378	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   2671: pop
    //   2672: aload_0
    //   2673: aload_0
    //   2674: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:D	J
    //   2677: iload_3
    //   2678: i2l
    //   2679: ladd
    //   2680: putfield 170	com/tencent/mobileqq/msf/core/net/c/a:D	J
    //   2683: aload_0
    //   2684: iload_3
    //   2685: aload_0
    //   2686: getfield 347	com/tencent/mobileqq/msf/core/net/c/a:U	I
    //   2689: iadd
    //   2690: putfield 347	com/tencent/mobileqq/msf/core/net/c/a:U	I
    //   2693: aload_0
    //   2694: iconst_0
    //   2695: putfield 144	com/tencent/mobileqq/msf/core/net/c/a:V	Z
    //   2698: aload_0
    //   2699: getstatic 528	com/tencent/mobileqq/msf/core/net/c/a$d$a:u	Lcom/tencent/mobileqq/msf/core/net/c/a$d$a;
    //   2702: invokespecial 222	com/tencent/mobileqq/msf/core/net/c/a:a	(Lcom/tencent/mobileqq/msf/core/net/c/a$d$a;)V
    //   2705: aload 9
    //   2707: ifnull +913 -> 3620
    //   2710: aload 9
    //   2712: invokevirtual 481	java/io/InputStream:close	()V
    //   2715: iconst_0
    //   2716: ireturn
    //   2717: astore_2
    //   2718: aload_2
    //   2719: invokevirtual 484	java/lang/Throwable:printStackTrace	()V
    //   2722: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2725: ifeq +895 -> 3620
    //   2728: ldc 246
    //   2730: iconst_4
    //   2731: ldc_w 486
    //   2734: aload_2
    //   2735: invokestatic 393	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2738: iconst_0
    //   2739: ireturn
    //   2740: iload 4
    //   2742: iload_3
    //   2743: iadd
    //   2744: iload_1
    //   2745: if_icmple +143 -> 2888
    //   2748: aload 10
    //   2750: iconst_0
    //   2751: aload_2
    //   2752: iload_3
    //   2753: iload_1
    //   2754: iload_3
    //   2755: isub
    //   2756: invokestatic 366	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2759: goto -123 -> 2636
    //   2762: astore 10
    //   2764: aload 9
    //   2766: astore_2
    //   2767: aload 10
    //   2769: astore 9
    //   2771: aload_2
    //   2772: ifnull +14 -> 2786
    //   2775: getstatic 458	com/tencent/mobileqq/msf/core/net/c/g:f	Ljava/util/ArrayList;
    //   2778: aload_2
    //   2779: invokevirtual 459	java/lang/Object:toString	()Ljava/lang/String;
    //   2782: invokevirtual 378	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   2785: pop
    //   2786: aload_0
    //   2787: aload 9
    //   2789: invokevirtual 383	java/lang/Exception:toString	()Ljava/lang/String;
    //   2792: invokevirtual 386	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2795: invokespecial 388	com/tencent/mobileqq/msf/core/net/c/a:a	(Ljava/lang/String;)V
    //   2798: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2801: ifeq +14 -> 2815
    //   2804: ldc 246
    //   2806: iconst_4
    //   2807: ldc_w 530
    //   2810: aload 9
    //   2812: invokestatic 393	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2815: aload_0
    //   2816: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2819: astore 10
    //   2821: aload 10
    //   2823: aload 10
    //   2825: getfield 395	com/tencent/mobileqq/msf/core/net/c/a$d:n	I
    //   2828: iconst_1
    //   2829: iadd
    //   2830: putfield 395	com/tencent/mobileqq/msf/core/net/c/a$d:n	I
    //   2833: aload_0
    //   2834: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2837: getfield 332	com/tencent/mobileqq/msf/core/net/c/a$d:J	Ljava/util/ArrayList;
    //   2840: ldc2_w 396
    //   2843: invokestatic 337	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2846: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2849: pop
    //   2850: aload 9
    //   2852: invokevirtual 491	java/lang/Exception:printStackTrace	()V
    //   2855: aload_2
    //   2856: ifnull +764 -> 3620
    //   2859: aload_2
    //   2860: invokevirtual 481	java/io/InputStream:close	()V
    //   2863: iconst_0
    //   2864: ireturn
    //   2865: astore_2
    //   2866: aload_2
    //   2867: invokevirtual 484	java/lang/Throwable:printStackTrace	()V
    //   2870: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2873: ifeq +747 -> 3620
    //   2876: ldc 246
    //   2878: iconst_4
    //   2879: ldc_w 486
    //   2882: aload_2
    //   2883: invokestatic 393	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2886: iconst_0
    //   2887: ireturn
    //   2888: aload 10
    //   2890: iconst_0
    //   2891: aload_2
    //   2892: iload_3
    //   2893: iload 4
    //   2895: invokestatic 366	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2898: goto -262 -> 2636
    //   2901: astore_2
    //   2902: aload 9
    //   2904: ifnull +8 -> 2912
    //   2907: aload 9
    //   2909: invokevirtual 481	java/io/InputStream:close	()V
    //   2912: aload_2
    //   2913: athrow
    //   2914: getstatic 458	com/tencent/mobileqq/msf/core/net/c/g:f	Ljava/util/ArrayList;
    //   2917: aload 9
    //   2919: invokevirtual 459	java/lang/Object:toString	()Ljava/lang/String;
    //   2922: invokevirtual 378	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   2925: pop
    //   2926: aload_0
    //   2927: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2930: aload_0
    //   2931: getfield 154	com/tencent/mobileqq/msf/core/net/c/a:v	J
    //   2934: putfield 327	com/tencent/mobileqq/msf/core/net/c/a$d:M	J
    //   2937: aload_0
    //   2938: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2941: aload_0
    //   2942: getfield 160	com/tencent/mobileqq/msf/core/net/c/a:y	J
    //   2945: putfield 329	com/tencent/mobileqq/msf/core/net/c/a$d:N	J
    //   2948: aload_0
    //   2949: aload_0
    //   2950: getfield 160	com/tencent/mobileqq/msf/core/net/c/a:y	J
    //   2953: aload_0
    //   2954: getfield 154	com/tencent/mobileqq/msf/core/net/c/a:v	J
    //   2957: lsub
    //   2958: putfield 172	com/tencent/mobileqq/msf/core/net/c/a:E	J
    //   2961: aload_0
    //   2962: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2965: getfield 332	com/tencent/mobileqq/msf/core/net/c/a$d:J	Ljava/util/ArrayList;
    //   2968: aload_0
    //   2969: getfield 172	com/tencent/mobileqq/msf/core/net/c/a:E	J
    //   2972: invokestatic 337	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2975: invokevirtual 342	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2978: pop
    //   2979: aload_0
    //   2980: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   2983: astore 10
    //   2985: aload 10
    //   2987: aload 10
    //   2989: getfield 349	com/tencent/mobileqq/msf/core/net/c/a$d:k	I
    //   2992: i2l
    //   2993: aload_0
    //   2994: getfield 172	com/tencent/mobileqq/msf/core/net/c/a:E	J
    //   2997: ladd
    //   2998: l2i
    //   2999: putfield 349	com/tencent/mobileqq/msf/core/net/c/a$d:k	I
    //   3002: aload_0
    //   3003: aload_0
    //   3004: getfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   3007: aload_0
    //   3008: getfield 160	com/tencent/mobileqq/msf/core/net/c/a:y	J
    //   3011: aload_0
    //   3012: getfield 158	com/tencent/mobileqq/msf/core/net/c/a:x	J
    //   3015: lsub
    //   3016: ladd
    //   3017: putfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   3020: aload_0
    //   3021: aload_0
    //   3022: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:D	J
    //   3025: iload_3
    //   3026: i2l
    //   3027: ladd
    //   3028: putfield 170	com/tencent/mobileqq/msf/core/net/c/a:D	J
    //   3031: aload_0
    //   3032: aload_0
    //   3033: getfield 347	com/tencent/mobileqq/msf/core/net/c/a:U	I
    //   3036: iload_3
    //   3037: iadd
    //   3038: putfield 347	com/tencent/mobileqq/msf/core/net/c/a:U	I
    //   3041: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3044: ifeq +71 -> 3115
    //   3047: ldc 246
    //   3049: iconst_4
    //   3050: new 248	java/lang/StringBuilder
    //   3053: dup
    //   3054: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   3057: ldc_w 532
    //   3060: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3063: aload_0
    //   3064: getfield 172	com/tencent/mobileqq/msf/core/net/c/a:E	J
    //   3067: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3070: ldc_w 358
    //   3073: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3076: aload_0
    //   3077: getfield 168	com/tencent/mobileqq/msf/core/net/c/a:C	J
    //   3080: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3083: ldc_w 360
    //   3086: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3089: aload_0
    //   3090: getfield 170	com/tencent/mobileqq/msf/core/net/c/a:D	J
    //   3093: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3096: ldc_w 362
    //   3099: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3102: aload_0
    //   3103: getfield 347	com/tencent/mobileqq/msf/core/net/c/a:U	I
    //   3106: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3109: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3112: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3115: aload_0
    //   3116: getfield 174	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3119: getfield 533	com/tencent/msf/service/protocol/push/a/d:x	J
    //   3122: lconst_0
    //   3123: lcmp
    //   3124: ifle +132 -> 3256
    //   3127: aload_0
    //   3128: getfield 174	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3131: getfield 533	com/tencent/msf/service/protocol/push/a/d:x	J
    //   3134: l2i
    //   3135: istore 5
    //   3137: aload_0
    //   3138: getfield 174	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3141: getfield 534	com/tencent/msf/service/protocol/push/a/d:w	J
    //   3144: l2i
    //   3145: istore 6
    //   3147: iload 5
    //   3149: istore 4
    //   3151: iload 5
    //   3153: ldc_w 535
    //   3156: if_icmple +8 -> 3164
    //   3159: ldc_w 535
    //   3162: istore 4
    //   3164: iload_3
    //   3165: iload_1
    //   3166: invokestatic 541	java/lang/Math:min	(II)I
    //   3169: istore 5
    //   3171: iload 6
    //   3173: iload 5
    //   3175: if_icmpge +81 -> 3256
    //   3178: iload 4
    //   3180: iload 6
    //   3182: iadd
    //   3183: iload 5
    //   3185: if_icmple +324 -> 3509
    //   3188: aload_0
    //   3189: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   3192: new 226	java/lang/String
    //   3195: dup
    //   3196: aload_2
    //   3197: iload 6
    //   3199: iload 5
    //   3201: iload 6
    //   3203: isub
    //   3204: invokespecial 544	java/lang/String:<init>	([BII)V
    //   3207: putfield 546	com/tencent/mobileqq/msf/core/net/c/a$d:P	Ljava/lang/String;
    //   3210: aload_0
    //   3211: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   3214: iload 5
    //   3216: iload 6
    //   3218: isub
    //   3219: putfield 548	com/tencent/mobileqq/msf/core/net/c/a$d:O	I
    //   3222: aload_0
    //   3223: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   3226: aload_0
    //   3227: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   3230: getfield 546	com/tencent/mobileqq/msf/core/net/c/a$d:P	Ljava/lang/String;
    //   3233: invokestatic 551	com/tencent/qphone/base/util/e:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3236: putfield 546	com/tencent/mobileqq/msf/core/net/c/a$d:P	Ljava/lang/String;
    //   3239: aload_0
    //   3240: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   3243: aload_0
    //   3244: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   3247: getfield 546	com/tencent/mobileqq/msf/core/net/c/a$d:P	Ljava/lang/String;
    //   3250: invokevirtual 554	java/lang/String:length	()I
    //   3253: putfield 548	com/tencent/mobileqq/msf/core/net/c/a$d:O	I
    //   3256: new 226	java/lang/String
    //   3259: dup
    //   3260: aload_2
    //   3261: iconst_0
    //   3262: iload_3
    //   3263: aload_2
    //   3264: arraylength
    //   3265: invokestatic 541	java/lang/Math:min	(II)I
    //   3268: invokespecial 544	java/lang/String:<init>	([BII)V
    //   3271: astore_2
    //   3272: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3275: ifeq +29 -> 3304
    //   3278: ldc 246
    //   3280: iconst_4
    //   3281: new 248	java/lang/StringBuilder
    //   3284: dup
    //   3285: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   3288: ldc_w 556
    //   3291: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3294: aload_2
    //   3295: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3298: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3301: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3304: aload_2
    //   3305: aload_0
    //   3306: getfield 174	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3309: getfield 558	com/tencent/msf/service/protocol/push/a/d:t	Ljava/lang/String;
    //   3312: invokevirtual 562	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3315: ifne +11 -> 3326
    //   3318: aload_0
    //   3319: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   3322: iconst_1
    //   3323: putfield 564	com/tencent/mobileqq/msf/core/net/c/a$d:F	I
    //   3326: aload_0
    //   3327: aload_0
    //   3328: getfield 503	com/tencent/mobileqq/msf/core/net/c/a:k	Ljava/net/HttpURLConnection;
    //   3331: ldc_w 566
    //   3334: invokevirtual 569	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   3337: invokespecial 571	com/tencent/mobileqq/msf/core/net/c/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3340: astore_2
    //   3341: aload_2
    //   3342: ifnull +50 -> 3392
    //   3345: aload_2
    //   3346: invokestatic 575	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   3349: astore 10
    //   3351: aload_0
    //   3352: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   3355: aload 10
    //   3357: putfield 421	com/tencent/mobileqq/msf/core/net/c/a$d:d	Ljava/net/InetAddress;
    //   3360: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3363: ifeq +29 -> 3392
    //   3366: ldc 246
    //   3368: iconst_4
    //   3369: new 248	java/lang/StringBuilder
    //   3372: dup
    //   3373: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   3376: ldc_w 577
    //   3379: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3382: aload_2
    //   3383: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3386: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3389: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3392: aload_0
    //   3393: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   3396: astore_2
    //   3397: aload_2
    //   3398: aload_2
    //   3399: getfield 400	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   3402: iconst_1
    //   3403: iadd
    //   3404: putfield 400	com/tencent/mobileqq/msf/core/net/c/a$d:m	I
    //   3407: ldc 246
    //   3409: iconst_1
    //   3410: new 248	java/lang/StringBuilder
    //   3413: dup
    //   3414: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   3417: ldc_w 579
    //   3420: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3423: iload_3
    //   3424: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3427: ldc_w 581
    //   3430: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3433: iload_1
    //   3434: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3437: ldc_w 583
    //   3440: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3443: aload_0
    //   3444: getfield 172	com/tencent/mobileqq/msf/core/net/c/a:E	J
    //   3447: invokevirtual 356	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3450: ldc_w 585
    //   3453: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3456: aload_0
    //   3457: getfield 174	com/tencent/mobileqq/msf/core/net/c/a:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3460: getfield 558	com/tencent/msf/service/protocol/push/a/d:t	Ljava/lang/String;
    //   3463: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3466: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3469: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3472: aload 9
    //   3474: ifnull +150 -> 3624
    //   3477: aload 9
    //   3479: invokevirtual 481	java/io/InputStream:close	()V
    //   3482: goto +142 -> 3624
    //   3485: astore_2
    //   3486: aload_2
    //   3487: invokevirtual 484	java/lang/Throwable:printStackTrace	()V
    //   3490: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3493: ifeq +131 -> 3624
    //   3496: ldc 246
    //   3498: iconst_4
    //   3499: ldc_w 486
    //   3502: aload_2
    //   3503: invokestatic 393	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3506: goto +118 -> 3624
    //   3509: aload_0
    //   3510: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   3513: new 226	java/lang/String
    //   3516: dup
    //   3517: aload_2
    //   3518: iload 6
    //   3520: iload 4
    //   3522: invokespecial 544	java/lang/String:<init>	([BII)V
    //   3525: putfield 546	com/tencent/mobileqq/msf/core/net/c/a$d:P	Ljava/lang/String;
    //   3528: aload_0
    //   3529: getfield 139	com/tencent/mobileqq/msf/core/net/c/a:p	Lcom/tencent/mobileqq/msf/core/net/c/a$d;
    //   3532: iload 4
    //   3534: putfield 548	com/tencent/mobileqq/msf/core/net/c/a$d:O	I
    //   3537: goto -315 -> 3222
    //   3540: astore 9
    //   3542: aload 9
    //   3544: invokevirtual 484	java/lang/Throwable:printStackTrace	()V
    //   3547: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3550: ifeq -1446 -> 2104
    //   3553: ldc 246
    //   3555: iconst_4
    //   3556: ldc_w 486
    //   3559: aload 9
    //   3561: invokestatic 393	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3564: goto -1460 -> 2104
    //   3567: astore 9
    //   3569: aload 9
    //   3571: invokevirtual 484	java/lang/Throwable:printStackTrace	()V
    //   3574: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3577: ifeq -665 -> 2912
    //   3580: ldc 246
    //   3582: iconst_4
    //   3583: ldc_w 486
    //   3586: aload 9
    //   3588: invokestatic 393	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3591: goto -679 -> 2912
    //   3594: astore_2
    //   3595: aconst_null
    //   3596: astore 9
    //   3598: goto -696 -> 2902
    //   3601: astore 10
    //   3603: aload_2
    //   3604: astore 9
    //   3606: aload 10
    //   3608: astore_2
    //   3609: goto -707 -> 2902
    //   3612: astore 9
    //   3614: goto -843 -> 2771
    //   3617: goto -1016 -> 2601
    //   3620: iconst_0
    //   3621: ireturn
    //   3622: iconst_0
    //   3623: ireturn
    //   3624: iconst_1
    //   3625: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3626	0	this	a
    //   0	3626	1	paramInt	int
    //   0	3626	2	paramArrayOfByte	byte[]
    //   615	2809	3	i1	int
    //   1158	2375	4	i2	int
    //   1150	2069	5	i3	int
    //   987	2532	6	i4	int
    //   1119	1437	7	l1	long
    //   119	3359	9	localObject1	Object
    //   3540	20	9	localThrowable1	Throwable
    //   3567	20	9	localThrowable2	Throwable
    //   3596	9	9	arrayOfByte1	byte[]
    //   3612	1	9	localException1	Exception
    //   131	2618	10	localObject2	Object
    //   2762	6	10	localException2	Exception
    //   2819	537	10	localObject3	Object
    //   3601	6	10	localObject4	Object
    //   260	2153	11	localObject5	Object
    //   984	1218	12	arrayOfByte2	byte[]
    //   1708	306	13	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   133	367	489	java/lang/Exception
    //   367	388	489	java/lang/Exception
    //   388	489	489	java/lang/Exception
    //   545	586	489	java/lang/Exception
    //   591	676	489	java/lang/Exception
    //   679	717	489	java/lang/Exception
    //   717	821	489	java/lang/Exception
    //   823	935	489	java/lang/Exception
    //   1342	1347	1349	java/lang/Throwable
    //   54	75	1372	java/lang/Exception
    //   77	116	1372	java/lang/Exception
    //   116	133	1372	java/lang/Exception
    //   490	543	1372	java/lang/Exception
    //   1342	1347	1372	java/lang/Exception
    //   1350	1370	1372	java/lang/Exception
    //   1561	1566	1372	java/lang/Exception
    //   1569	1589	1372	java/lang/Exception
    //   2099	2104	1372	java/lang/Exception
    //   2104	2106	1372	java/lang/Exception
    //   2312	2317	1372	java/lang/Exception
    //   2321	2341	1372	java/lang/Exception
    //   2710	2715	1372	java/lang/Exception
    //   2718	2738	1372	java/lang/Exception
    //   2859	2863	1372	java/lang/Exception
    //   2866	2886	1372	java/lang/Exception
    //   2907	2912	1372	java/lang/Exception
    //   2912	2914	1372	java/lang/Exception
    //   3477	3482	1372	java/lang/Exception
    //   3486	3506	1372	java/lang/Exception
    //   3542	3564	1372	java/lang/Exception
    //   3569	3591	1372	java/lang/Exception
    //   944	953	1440	java/lang/Exception
    //   961	973	1440	java/lang/Exception
    //   981	986	1440	java/lang/Exception
    //   997	1005	1440	java/lang/Exception
    //   1013	1020	1440	java/lang/Exception
    //   1028	1046	1440	java/lang/Exception
    //   1054	1107	1440	java/lang/Exception
    //   1115	1121	1440	java/lang/Exception
    //   1129	1135	1440	java/lang/Exception
    //   1143	1149	1440	java/lang/Exception
    //   1181	1195	1440	java/lang/Exception
    //   1226	1238	1440	java/lang/Exception
    //   1246	1253	1440	java/lang/Exception
    //   1261	1267	1440	java/lang/Exception
    //   1275	1312	1440	java/lang/Exception
    //   1320	1337	1440	java/lang/Exception
    //   1430	1437	1440	java/lang/Exception
    //   1599	1611	1440	java/lang/Exception
    //   1619	1630	1440	java/lang/Exception
    //   1638	1649	1440	java/lang/Exception
    //   1657	1670	1440	java/lang/Exception
    //   1678	1696	1440	java/lang/Exception
    //   1704	1710	1440	java/lang/Exception
    //   1718	1735	1440	java/lang/Exception
    //   1743	1761	1440	java/lang/Exception
    //   1769	1780	1440	java/lang/Exception
    //   1788	1798	1440	java/lang/Exception
    //   1806	1812	1440	java/lang/Exception
    //   1820	1899	1440	java/lang/Exception
    //   1907	1917	1440	java/lang/Exception
    //   1925	1936	1440	java/lang/Exception
    //   1944	1953	1440	java/lang/Exception
    //   1961	1972	1440	java/lang/Exception
    //   1980	1987	1440	java/lang/Exception
    //   1995	2005	1440	java/lang/Exception
    //   2013	2028	1440	java/lang/Exception
    //   2036	2054	1440	java/lang/Exception
    //   2062	2093	1440	java/lang/Exception
    //   2114	2140	1440	java/lang/Exception
    //   2148	2153	1440	java/lang/Exception
    //   2161	2171	1440	java/lang/Exception
    //   2184	2191	1440	java/lang/Exception
    //   2199	2210	1440	java/lang/Exception
    //   2218	2224	1440	java/lang/Exception
    //   2232	2291	1440	java/lang/Exception
    //   2299	2307	1440	java/lang/Exception
    //   2352	2363	1440	java/lang/Exception
    //   2371	2376	1440	java/lang/Exception
    //   2384	2394	1440	java/lang/Exception
    //   2402	2408	1440	java/lang/Exception
    //   2416	2425	1440	java/lang/Exception
    //   1561	1566	1568	java/lang/Throwable
    //   944	953	2093	finally
    //   961	973	2093	finally
    //   981	986	2093	finally
    //   997	1005	2093	finally
    //   1013	1020	2093	finally
    //   1028	1046	2093	finally
    //   1054	1107	2093	finally
    //   1115	1121	2093	finally
    //   1129	1135	2093	finally
    //   1143	1149	2093	finally
    //   1181	1195	2093	finally
    //   1226	1238	2093	finally
    //   1246	1253	2093	finally
    //   1261	1267	2093	finally
    //   1275	1312	2093	finally
    //   1320	1337	2093	finally
    //   1430	1437	2093	finally
    //   1450	1462	2093	finally
    //   1466	1477	2093	finally
    //   1481	1487	2093	finally
    //   1491	1501	2093	finally
    //   1505	1511	2093	finally
    //   1515	1527	2093	finally
    //   1531	1548	2093	finally
    //   1552	1556	2093	finally
    //   1599	1611	2093	finally
    //   1619	1630	2093	finally
    //   1638	1649	2093	finally
    //   1657	1670	2093	finally
    //   1678	1696	2093	finally
    //   1704	1710	2093	finally
    //   1718	1735	2093	finally
    //   1743	1761	2093	finally
    //   1769	1780	2093	finally
    //   1788	1798	2093	finally
    //   1806	1812	2093	finally
    //   1820	1899	2093	finally
    //   1907	1917	2093	finally
    //   1925	1936	2093	finally
    //   1944	1953	2093	finally
    //   1961	1972	2093	finally
    //   1980	1987	2093	finally
    //   1995	2005	2093	finally
    //   2013	2028	2093	finally
    //   2036	2054	2093	finally
    //   2062	2093	2093	finally
    //   2114	2140	2093	finally
    //   2148	2153	2093	finally
    //   2161	2171	2093	finally
    //   2184	2191	2093	finally
    //   2199	2210	2093	finally
    //   2218	2224	2093	finally
    //   2232	2291	2093	finally
    //   2299	2307	2093	finally
    //   2352	2363	2093	finally
    //   2371	2376	2093	finally
    //   2384	2394	2093	finally
    //   2402	2408	2093	finally
    //   2416	2425	2093	finally
    //   2312	2317	2320	java/lang/Throwable
    //   2710	2715	2717	java/lang/Throwable
    //   2576	2599	2762	java/lang/Exception
    //   2606	2615	2762	java/lang/Exception
    //   2627	2636	2762	java/lang/Exception
    //   2641	2648	2762	java/lang/Exception
    //   2660	2672	2762	java/lang/Exception
    //   2672	2705	2762	java/lang/Exception
    //   2748	2759	2762	java/lang/Exception
    //   2888	2898	2762	java/lang/Exception
    //   2914	3115	2762	java/lang/Exception
    //   3115	3147	2762	java/lang/Exception
    //   3164	3171	2762	java/lang/Exception
    //   3188	3222	2762	java/lang/Exception
    //   3222	3256	2762	java/lang/Exception
    //   3256	3304	2762	java/lang/Exception
    //   3304	3326	2762	java/lang/Exception
    //   3326	3341	2762	java/lang/Exception
    //   3345	3392	2762	java/lang/Exception
    //   3392	3472	2762	java/lang/Exception
    //   3509	3537	2762	java/lang/Exception
    //   2859	2863	2865	java/lang/Throwable
    //   2576	2599	2901	finally
    //   2606	2615	2901	finally
    //   2627	2636	2901	finally
    //   2641	2648	2901	finally
    //   2660	2672	2901	finally
    //   2672	2705	2901	finally
    //   2748	2759	2901	finally
    //   2888	2898	2901	finally
    //   2914	3115	2901	finally
    //   3115	3147	2901	finally
    //   3164	3171	2901	finally
    //   3188	3222	2901	finally
    //   3222	3256	2901	finally
    //   3256	3304	2901	finally
    //   3304	3326	2901	finally
    //   3326	3341	2901	finally
    //   3345	3392	2901	finally
    //   3392	3472	2901	finally
    //   3509	3537	2901	finally
    //   3477	3482	3485	java/lang/Throwable
    //   2099	2104	3540	java/lang/Throwable
    //   2907	2912	3567	java/lang/Throwable
    //   2430	2542	3594	finally
    //   2542	2576	3594	finally
    //   2775	2786	3601	finally
    //   2786	2815	3601	finally
    //   2815	2855	3601	finally
    //   2430	2542	3612	java/lang/Exception
    //   2542	2576	3612	java/lang/Exception
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
        i1 = d.a[this.a.ordinal()];
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
    Object localObject;
    label1155:
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
          if (this.b.y == 1)
          {
            localObject = "https://" + this.n.getHostAddress() + ":" + this.o + "/" + this.b.q;
            if (QLog.isDevelopLevel()) {
              QLog.d("MSF.C.QualityTestManager", 4, "QualityTest: connecting http url:" + (String)localObject);
            }
            this.t = System.currentTimeMillis();
            this.j = new URL((String)localObject);
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
              break label1155;
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
            localObject = (com.tencent.msf.service.protocol.push.a.e)parama.next();
            if (localObject == null) {
              continue;
            }
            this.k.setRequestProperty(((com.tencent.msf.service.protocol.push.a.e)localObject).a, ((com.tencent.msf.service.protocol.push.a.e)localObject).b);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("MSF.C.QualityTestManager", 4, "reqHead.strKey:" + ((com.tencent.msf.service.protocol.push.a.e)localObject).a + ",reqHead.strValue:" + ((com.tencent.msf.service.protocol.push.a.e)localObject).b);
            continue;
          }
          localObject = "http://" + this.n.getHostAddress() + ":" + this.o + "/" + this.b.q;
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
      localObject = parama;
      if (this.l == 1)
      {
        i2 = this.k.getResponseCode();
        if ((this.b.r & 0x4) == 4) {
          break label1789;
        }
        i1 = 1;
        break label1752;
        i3 += 1;
        if (i3 <= 10) {
          break;
        }
        QLog.d("MSF.C.QualityTestManager", 4, "Redirect too much!");
        localObject = parama;
      }
      label1321:
      this.z = (this.u - this.t);
      this.p.I.add(Long.valueOf(this.z));
      boolean bool = TextUtils.isEmpty((CharSequence)localObject);
      if (!bool)
      {
        try
        {
          parama = ((String)localObject).substring(((String)localObject).indexOf("://") + 3);
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
      localObject = this.b.s.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.msf.service.protocol.push.a.e locale = (com.tencent.msf.service.protocol.push.a.e)((Iterator)localObject).next();
        if (locale != null)
        {
          this.k.setRequestProperty(locale.a, locale.b);
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "reqHead.strKey:" + locale.a + ",reqHead.strValue:" + locale.b);
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
      label1752:
      i3 = 0;
      localObject = parama;
      if (i1 == 0) {
        break label1321;
      }
      if ((i2 == 301) || (i2 == 302)) {
        break;
      }
      localObject = parama;
      if (i2 != 307) {
        break label1321;
      }
      break;
      label1789:
      i1 = 0;
    }
  }
  
  private boolean a(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      try
      {
        switch (d.a[this.a.ordinal()])
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
            a(a.d.a.d);
            QLog.d("MSF.C.QualityTestManager", 1, "QualityTest: send udp packet error:", paramArrayOfByte);
            return false;
          }
        case 2: 
          try
          {
            this.v = System.currentTimeMillis();
            g.g.add(this.i.toString());
            this.i.write(paramArrayOfByte);
            this.i.flush();
            g.g.remove(this.i.toString());
            this.B += paramArrayOfByte.length;
            this.T += paramArrayOfByte.length;
            paramArrayOfByte = this.p;
            paramArrayOfByte.l += 1;
          }
          catch (Exception paramArrayOfByte)
          {
            if (this.i != null) {
              g.g.remove(this.i.toString());
            }
            a(a.d.a.d);
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
        g.g.add(this.i.toString());
        this.i.write(paramArrayOfByte);
        this.i.flush();
        g.g.remove(this.i.toString());
        this.B += paramArrayOfByte.length;
        this.T += paramArrayOfByte.length;
        paramArrayOfByte = this.p;
        paramArrayOfByte.l += 1;
      }
      catch (Exception paramArrayOfByte)
      {
        if (this.i != null) {
          g.g.remove(this.i.toString());
        }
        a(a.d.a.d);
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
      if (this.a != a.c) {
        if ((this.b.o == 0) || (1 == this.b.o))
        {
          int i1 = com.tencent.mobileqq.msf.core.c.a(arrayOfByte, 0);
          if (i1 != paramInt)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("MSF.C.QualityTestManager", 4, "testdata length error stop dataTotalLen:" + i1 + " receBodySize:" + paramInt);
            }
            b(a.d.a.f, true);
            g.a();
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
      paramString = Pattern.compile("(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})").matcher(paramString);
      if (paramString.find()) {
        return paramString.group();
      }
    }
    return null;
  }
  
  private void b(a.d.a parama, boolean paramBoolean)
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
        g.a(this.V, this.b, this.c, this.U, this.T);
        g.d.configManager.a(localHashMap, "");
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
      this.n = com.tencent.qphone.base.util.e.a(l1);
      this.o = com.tencent.qphone.base.util.e.a(i1);
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
    //   0: new 959	java/io/BufferedReader
    //   3: dup
    //   4: new 961	java/io/FileReader
    //   7: dup
    //   8: ldc_w 963
    //   11: invokespecial 964	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   14: sipush 8192
    //   17: invokespecial 967	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   20: astore_1
    //   21: aload_1
    //   22: astore_0
    //   23: aload_1
    //   24: invokevirtual 970	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: ldc_w 972
    //   30: ldc 134
    //   32: invokevirtual 976	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   35: ldc_w 651
    //   38: invokevirtual 980	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   41: astore_2
    //   42: aload_1
    //   43: astore_0
    //   44: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   47: ifeq +33 -> 80
    //   50: aload_1
    //   51: astore_0
    //   52: ldc 246
    //   54: iconst_4
    //   55: new 248	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   62: ldc_w 982
    //   65: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_2
    //   69: iconst_1
    //   70: aaload
    //   71: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_1
    //   81: invokevirtual 983	java/io/BufferedReader:close	()V
    //   84: aload_2
    //   85: iconst_1
    //   86: aaload
    //   87: areturn
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: astore_0
    //   93: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   96: ifeq +14 -> 110
    //   99: aload_1
    //   100: astore_0
    //   101: ldc 246
    //   103: iconst_4
    //   104: ldc_w 985
    //   107: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aload_1
    //   111: astore_0
    //   112: aload_2
    //   113: invokevirtual 491	java/lang/Exception:printStackTrace	()V
    //   116: aload_1
    //   117: invokevirtual 983	java/io/BufferedReader:close	()V
    //   120: ldc_w 987
    //   123: areturn
    //   124: astore_0
    //   125: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   128: ifeq +12 -> 140
    //   131: ldc 246
    //   133: iconst_4
    //   134: ldc_w 989
    //   137: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload_0
    //   141: invokevirtual 491	java/lang/Exception:printStackTrace	()V
    //   144: ldc_w 987
    //   147: areturn
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 983	java/io/BufferedReader:close	()V
    //   155: aload_1
    //   156: athrow
    //   157: astore_0
    //   158: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   161: ifeq +12 -> 173
    //   164: ldc 246
    //   166: iconst_4
    //   167: ldc_w 989
    //   170: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload_0
    //   174: invokevirtual 491	java/lang/Exception:printStackTrace	()V
    //   177: goto -22 -> 155
    //   180: astore_0
    //   181: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   184: ifeq +12 -> 196
    //   187: ldc 246
    //   189: iconst_4
    //   190: ldc_w 989
    //   193: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: aload_0
    //   197: invokevirtual 491	java/lang/Exception:printStackTrace	()V
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
    //   0: new 959	java/io/BufferedReader
    //   3: dup
    //   4: new 961	java/io/FileReader
    //   7: dup
    //   8: ldc_w 991
    //   11: invokespecial 964	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   14: sipush 8192
    //   17: invokespecial 967	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   20: astore_3
    //   21: aload_3
    //   22: astore_1
    //   23: aload_3
    //   24: invokevirtual 970	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: ldc_w 993
    //   30: invokevirtual 980	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   33: astore 4
    //   35: iconst_2
    //   36: istore_0
    //   37: ldc 134
    //   39: astore_2
    //   40: aload_3
    //   41: astore_1
    //   42: iload_0
    //   43: aload 4
    //   45: arraylength
    //   46: if_icmpge +89 -> 135
    //   49: aload_3
    //   50: astore_1
    //   51: new 248	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   58: aload_2
    //   59: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload 4
    //   64: iload_0
    //   65: aaload
    //   66: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc_w 995
    //   72: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   92: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   95: ifeq +14 -> 109
    //   98: aload_2
    //   99: astore_1
    //   100: ldc 246
    //   102: iconst_4
    //   103: ldc_w 997
    //   106: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_2
    //   110: astore_1
    //   111: aload 4
    //   113: invokevirtual 491	java/lang/Exception:printStackTrace	()V
    //   116: ldc_w 999
    //   119: astore_1
    //   120: aload_2
    //   121: invokevirtual 983	java/io/BufferedReader:close	()V
    //   124: aload_1
    //   125: areturn
    //   126: astore_2
    //   127: aconst_null
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 983	java/io/BufferedReader:close	()V
    //   133: aload_2
    //   134: athrow
    //   135: aload_3
    //   136: invokevirtual 983	java/io/BufferedReader:close	()V
    //   139: aload_2
    //   140: astore_1
    //   141: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   144: ifeq -20 -> 124
    //   147: ldc 246
    //   149: iconst_4
    //   150: new 248	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 1001
    //   160: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_2
    //   164: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload_2
    //   174: areturn
    //   175: astore_1
    //   176: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   179: ifeq +12 -> 191
    //   182: ldc 246
    //   184: iconst_4
    //   185: ldc_w 989
    //   188: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload_1
    //   192: invokevirtual 491	java/lang/Exception:printStackTrace	()V
    //   195: goto -62 -> 133
    //   198: astore_1
    //   199: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   202: ifeq +12 -> 214
    //   205: ldc 246
    //   207: iconst_4
    //   208: ldc_w 989
    //   211: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload_1
    //   215: invokevirtual 491	java/lang/Exception:printStackTrace	()V
    //   218: ldc_w 999
    //   221: areturn
    //   222: astore_1
    //   223: invokestatic 244	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   226: ifeq +12 -> 238
    //   229: ldc 246
    //   231: iconst_4
    //   232: ldc_w 989
    //   235: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload_1
    //   239: invokevirtual 491	java/lang/Exception:printStackTrace	()V
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
    //   4: getstatic 1019	android/os/Build$VERSION:SDK_INT	I
    //   7: bipush 21
    //   9: if_icmplt +158 -> 167
    //   12: invokestatic 1025	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   15: ldc_w 1027
    //   18: invokevirtual 1031	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   21: checkcast 1033	android/net/ConnectivityManager
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 1037	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 1042	android/net/NetworkInfo:getType	()I
    //   34: pop
    //   35: aload_2
    //   36: invokevirtual 1042	android/net/NetworkInfo:getType	()I
    //   39: ifne +67 -> 106
    //   42: ldc_w 1033
    //   45: ldc_w 1044
    //   48: iconst_1
    //   49: anewarray 1046	java/lang/Class
    //   52: dup
    //   53: iconst_0
    //   54: getstatic 1050	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   57: aastore
    //   58: invokevirtual 1054	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   61: astore_2
    //   62: aload_2
    //   63: aload_1
    //   64: iconst_1
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: iload_0
    //   71: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokevirtual 1060	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   78: astore_1
    //   79: aload_1
    //   80: invokevirtual 1064	java/lang/Object:getClass	()Ljava/lang/Class;
    //   83: ldc_w 1066
    //   86: invokevirtual 1070	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   89: astore_2
    //   90: aload_2
    //   91: iconst_1
    //   92: invokevirtual 1075	java/lang/reflect/Field:setAccessible	(Z)V
    //   95: aload_2
    //   96: aload_1
    //   97: invokevirtual 1076	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   100: checkcast 339	java/util/ArrayList
    //   103: astore_1
    //   104: aload_1
    //   105: areturn
    //   106: aload_2
    //   107: invokevirtual 1042	android/net/NetworkInfo:getType	()I
    //   110: iconst_1
    //   111: if_icmpne -69 -> 42
    //   114: iconst_1
    //   115: istore_0
    //   116: goto -74 -> 42
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 1077	java/lang/SecurityException:printStackTrace	()V
    //   124: aconst_null
    //   125: astore_1
    //   126: goto -22 -> 104
    //   129: astore_1
    //   130: aload_1
    //   131: invokevirtual 1078	java/lang/NoSuchFieldException:printStackTrace	()V
    //   134: aconst_null
    //   135: astore_1
    //   136: goto -32 -> 104
    //   139: astore_1
    //   140: aload_1
    //   141: invokevirtual 1079	java/lang/IllegalArgumentException:printStackTrace	()V
    //   144: aconst_null
    //   145: areturn
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 1080	java/lang/NoSuchMethodException:printStackTrace	()V
    //   151: aconst_null
    //   152: areturn
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 1081	java/lang/IllegalAccessException:printStackTrace	()V
    //   158: aconst_null
    //   159: areturn
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 1082	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   165: aconst_null
    //   166: areturn
    //   167: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq -66 -> 104
    //   173: ldc 246
    //   175: iconst_4
    //   176: new 248	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 249	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 1084
    //   186: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: getstatic 1019	android/os/Build$VERSION:SDK_INT	I
    //   192: invokevirtual 258	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: ldc_w 1086
    //   198: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 267	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    c localc = new c();
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      SecureRandom localSecureRandom = new SecureRandom();
      localSSLContext.init(null, new TrustManager[] { localc }, localSecureRandom);
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
      switch (d.a[this.a.ordinal()])
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
      b(a.d.a.k, true);
      g.a();
      return;
    }
    j();
    this.p.r = this.b.a;
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.QualityTestManager", 2, "cProtoType:" + this.b.a + " IpPort.size():" + this.b.b.size() + " cDomainToIpMode:" + this.b.r + " strRspMatchPattern" + this.b.t + " strUserInfo:" + this.b.u + " dwRecvCopyStart" + this.b.w + " dwRecvCopyLen" + this.b.x + " strDnsSrvIp:" + this.q.j + " dwLocationTime:" + this.q.l + " strAxis:" + this.q.m);
    }
    if (this.b.b.size() > 10)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
      }
      this.V = false;
      b(a.d.a.m, true);
      g.a();
      return;
    }
    if (this.b.b.size() <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too small, return ");
      }
      this.V = false;
      b(a.d.a.n, true);
      g.a();
      return;
    }
    if (this.b.h * 1000L < System.currentTimeMillis())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg expired, stop test qualityTestMsg.dwExpirTime:" + this.b.h + "System.currentTimeMillis():" + System.currentTimeMillis());
      }
      b(a.d.a.j, true);
      g.a();
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
          break label1220;
        }
        str3 = str3 + localc.a + " " + localc.b + " ";
        localObject1 = str3;
        if (!QLog.isColorLevel()) {
          break label1220;
        }
        QLog.d("MSF.C.QualityTestManager", 4, "pingOptions.strKey:" + localc.a + ",pingOptions.strValue:" + localc.b);
        localObject1 = str3;
        break label1220;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MSF.C.QualityTestManager", 2, "pingParamStr : " + str3);
        ((e)localObject3).a(str3);
        Object localObject3 = ((e)localObject3).b();
        if ((localObject3 == null) || (!((e.a)localObject3).b)) {
          break label1227;
        }
        str3 = ((e.a)localObject3).d;
        localObject1 = str3;
        if (TextUtils.isEmpty(((e.a)localObject3).c)) {
          break label1190;
        }
        this.p.K = ((e.a)localObject3).c;
        bool1 = true;
        localObject1 = str3;
        continue;
        localObject3 = ((e)localObject3).a();
        if ((localObject3 == null) || (!((e.a)localObject3).b)) {
          break label1237;
        }
        str3 = ((e.a)localObject3).d;
        localObject1 = str3;
        if (TextUtils.isEmpty(((e.a)localObject3).c)) {
          break label1190;
        }
        this.p.K = ((e.a)localObject3).c;
        bool1 = true;
        localObject1 = str3;
        continue;
        b(a.d.a.b, bool2);
      }
      finally
      {
        g.a();
      }
      try
      {
        this.p.g = NetConnInfoCenter.getSystemNetworkType();
        this.p.h = NetConnInfoCenter.getWifiStrength();
        this.p.j = NetConnInfoCenter.getCdmaStrength();
        this.p.i = NetConnInfoCenter.getGsmStrength();
        this.n = com.tencent.qphone.base.util.e.a(((com.tencent.msf.service.protocol.push.a.a)this.b.b.get(i2)).a);
        this.p.K = this.n.getHostAddress();
        this.p.C = ((com.tencent.msf.service.protocol.push.a.a)this.b.b.get(i2)).c;
        if ((this.p.C == null) || (this.p.C.isEmpty())) {
          this.p.C = this.p.K;
        }
        this.p.c.clear();
        str1 = this.p.C;
        this.p.M = System.currentTimeMillis();
        localObject3 = new e(str1, true, i1);
        switch (d.a[this.a.ordinal()])
        {
        case 4: 
          this.p.R = com.tencent.qphone.base.util.e.a(str1);
          this.p.Q = this.p.R.length();
          this.p.N = System.currentTimeMillis();
          if (i2 != this.b.b.size() - 1) {
            break label1247;
          }
          bool2 = true;
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.QualityTestManager", 2, "testsuccess: " + bool1 + ",isUpload:" + bool2);
          }
          if (bool1) {
            b(a.d.a.a, bool2);
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
      label1190:
      boolean bool1 = true;
      continue;
      i1 = 1200000;
      break;
      String str2 = "";
      bool1 = true;
      continue;
      i2 += 1;
      continue;
      label1220:
      String str3 = str2;
      continue;
      label1227:
      str2 = "";
      bool1 = false;
      continue;
      label1237:
      str2 = "";
      bool1 = false;
      continue;
      label1247:
      boolean bool2 = false;
    }
  }
  
  private void j()
  {
    this.q.d = this.b.j;
    this.q.e = this.b.o;
    this.q.f = this.b.k;
    this.q.g = this.b.l;
    this.q.h = this.b.m;
    this.q.a = a.c.a.a;
    this.q.i = this.b.u;
    ArrayList localArrayList = f();
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      this.q.j = ((InetAddress)localArrayList.get(0)).getHostAddress();
    }
    for (;;)
    {
      if (0L != t.g)
      {
        this.q.l = t.g;
        this.q.m = (t.h + "," + t.i);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.QualityTestManager", 2, "mDnses is null");
      }
    }
  }
  
  private boolean k()
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
  
  private void l()
  {
    if (this.c == null)
    {
      b(a.d.a.o, true);
      g.a();
      return;
    }
    this.p.a = a.d.b.b;
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
      b(a.d.a.m, true);
      g.a();
      return;
    }
    if (this.c.b.size() <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too small, return ");
      }
      b(a.d.a.n, true);
      g.a();
      return;
    }
    if (this.c.g > 20L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much, return ");
      }
      this.V = false;
      b(a.d.a.l, true);
      g.a();
      return;
    }
    if (this.c.h * 1000L < System.currentTimeMillis())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "mtuTest expired, stop test mtuTest.dwExpirTime:" + this.c.h + "System.currentTimeMillis():" + System.currentTimeMillis());
      }
      b(a.d.a.j, true);
      g.a();
      return;
    }
    if ((this.c.e.size() != this.c.d.size()) || (this.c.c.size() != this.c.d.size()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg sPkgData size error, stop test");
      }
      b(a.d.a.i, true);
      g.a();
      return;
    }
    if (this.c.g <= 0L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "mtuTest dwPkgNum too short, stop test mtuTest.dwPkgNum:" + this.c.g);
      }
      b(a.d.a.i, true);
      g.a();
      return;
    }
    if (this.c.g * this.c.c.size() > 20L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much, return ");
      }
      this.V = false;
      b(a.d.a.l, true);
      g.a();
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
              a(a.d.a.i);
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
        if ((i6 > 262144) && (this.a == a.a))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i6 + " return ");
          }
          a(a.d.a.h);
        }
        else if (i6 > 262144)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "testdata too big " + i6 + " return ");
          }
          this.V = false;
          a(a.d.a.h);
        }
        else
        {
          if (this.c.f >= 10L) {
            break label1702;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.QualityTestManager", 4, "dwPkgInterval too small " + this.c.f + " return ");
          }
          a(a.d.a.g);
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
                a(a.d.a.c);
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
              a(a.d.a.f);
              this.p.y.add(Integer.valueOf(i6));
            }
          }
        }
      }
      finally
      {
        g.a();
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
          b(a.d.a.a, bool);
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
  
  public void a(a.d.a parama, boolean paramBoolean)
  {
    if (parama == a.d.a.a)
    {
      this.p.b = parama;
      if (((this.a != a.c) || (this.l != 1)) && (this.a != a.a)) {
        break label314;
      }
      this.p.p = 0;
      label51:
      if (this.a != a.a) {
        break label345;
      }
      this.p.q = 0;
      label69:
      parama = this.p.toString();
      if (!TextUtils.isEmpty(this.S)) {
        break label376;
      }
      this.S += "(";
      if ((this.b == null) || (this.c != null) || (this.q.a != a.c.a.a) || (this.p.a != a.d.b.a)) {}
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
        this.p.b = a.d.a.b;
        if (parama == a.d.a.b) {
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
  
  public void c()
  {
    this.f = false;
    if (this.b == null)
    {
      b(a.d.a.k, true);
      g.a();
      return;
    }
    j();
    this.p.a = a.d.b.a;
    this.p.r = this.b.a;
    this.p.s = this.b.c;
    this.p.t = this.b.d;
    this.p.u = new ArrayList();
    this.p.u.add(Long.valueOf(this.b.f));
    this.p.w = this.b.h;
    this.p.B = this.b.o;
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder2 = localStringBuilder1.append(" cProtoType:").append(this.b.d).append(" PkgInterval:").append(this.b.d).append(" IpPort.size():").append(this.b.b.size()).append(" PkgNum:").append(this.b.c).append(" HeadData.length:");
      if (this.b.g == null) {
        break label637;
      }
      localObject1 = Integer.valueOf(this.b.g.length);
      localStringBuilder2 = localStringBuilder2.append(localObject1).append(" TailData.length:");
      if (this.b.p == null) {
        break label645;
      }
      localObject1 = Integer.valueOf(this.b.p.length);
      label297:
      localStringBuilder2 = localStringBuilder2.append(localObject1).append(" RepeatTimes:").append(this.b.f).append(" PkgData.length:");
      if (this.b.e == null) {
        break label653;
      }
    }
    label645:
    label653:
    for (Object localObject1 = Integer.valueOf(this.b.e.length);; localObject1 = "null")
    {
      localStringBuilder2.append(localObject1).append(" cDomainToIpMode:").append(this.b.r).append(" dwTaskType:").append(this.b.j).append(" dwTaskTime:").append(this.b.k).append(" dwReserved1:").append(this.b.l).append(" dwReserved2:").append(this.b.m).append(" dwRecvLen:").append(this.b.n).append(" cTestType:").append(this.b.o).append(" strUserInfo:").append(this.b.u).append(" strDnsSrvIp:").append(this.q.j).append(" dwLocationTime:").append(this.q.l).append(" strAxis:").append(this.q.m).append(" sPkgData:").append(Arrays.toString(this.b.e)).append(" cHttpsFunction").append(this.b.y);
      QLog.d("MSF.C.QualityTestManager", 2, localStringBuilder1.toString());
      if (this.d <= 1) {
        break label661;
      }
      if (this.b.b.size() <= 200) {
        break label804;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much for WiFi test, return ");
      }
      this.V = false;
      b(a.d.a.m, true);
      g.a();
      return;
      label637:
      localObject1 = "null";
      break;
      localObject1 = "null";
      break label297;
    }
    label661:
    if ((this.d == 1) && ((this.b.m & 0xFF) != 1L))
    {
      if (this.b.b.size() > 75)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
        }
        this.V = false;
        b(a.d.a.m, true);
        g.a();
      }
    }
    else if ((this.d == 1) && ((this.b.m & 0xFF) == 1L) && (this.b.b.size() > 200))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much for WiFi test, return ");
      }
      this.V = false;
      b(a.d.a.m, true);
      g.a();
      return;
    }
    label804:
    if (this.b.b.size() <= 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too small, return ");
      }
      b(a.d.a.n, true);
      g.a();
      return;
    }
    if (this.b.f <= 0L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "dwRepeatTimes must > 0");
      }
      b(a.d.a.q, true);
      g.a();
      return;
    }
    if (this.d > 1)
    {
      if (this.b.c > 50L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much for WiFi test, return ");
        }
        this.V = false;
        b(a.d.a.l, true);
        g.a();
      }
    }
    else if ((this.d == 1) && ((this.b.m & 0xFF) != 1L))
    {
      if (this.b.c > 20L)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much, return ");
        }
        this.V = false;
        b(a.d.a.l, true);
        g.a();
      }
    }
    else if ((this.d == 1) && ((this.b.m & 0xFF) == 1L) && (this.b.c > 50L))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "dwPkgNum too much for WiFi test, return ");
      }
      this.V = false;
      b(a.d.a.l, true);
      g.a();
      return;
    }
    if ((this.b.m >> 8 & 0xFF) > 20L)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "dwReserved2>>8 &0xFF too much, return ");
      }
      this.V = false;
      b(a.d.a.l, true);
      g.a();
      return;
    }
    if (this.b.h * 1000L < System.currentTimeMillis())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("MSF.C.QualityTestManager", 4, "qualityTestMsg expired, stop test qualityTestMsg.dwExpirTime:" + this.b.h + "System.currentTimeMillis():" + System.currentTimeMillis());
      }
      b(a.d.a.j, true);
      g.a();
      return;
    }
    if ((this.b.o != 0) && (1 != this.b.o) && (2 != this.b.o))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.QualityTestManager", 2, "qualityTestMsg.cTestType " + this.b.o + " NoSupport");
      }
      b(a.d.a.w, true);
      g.a();
      return;
    }
    int i2 = 0;
    int i1 = i2;
    label1507:
    int i5;
    label1543:
    label1548:
    int i3;
    long l1;
    label1893:
    int i4;
    label1938:
    label2021:
    boolean bool1;
    for (;;)
    {
      int i6;
      try
      {
        if (this.b.g != null)
        {
          i1 = i2;
          if (this.b.g.length > 0) {
            i1 = this.b.g.length;
          }
        }
        i6 = (int)(i1 + this.b.e.length * this.b.f);
        if ((this.b.p == null) || (this.b.p.length <= 0)) {
          break;
        }
        i6 += this.b.p.length;
        QLog.d("MSF.C.QualityTestManager", 1, "allbodylength " + i6);
        if (this.a == a.c)
        {
          if (i6 != 0) {
            continue;
          }
          this.l = 1;
        }
        if (this.b.d >= 10L) {
          break label1543;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "dwPkgInterval too small " + this.b.d + " return ");
        }
        b(a.d.a.g, true);
        g.a();
      }
      catch (Exception localException1)
      {
        QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: error ", localException1);
        continue;
      }
      finally
      {
        g.a();
      }
      return;
      this.l = 0;
      continue;
      i5 = 0;
      i1 = 0;
      if ((i1 >= this.b.b.size()) || (i5 != 0)) {
        break label3495;
      }
      this.p.y = new ArrayList();
      this.p.k = 0;
      this.p.n = 0;
      this.p.l = 0;
      this.p.m = 0;
      this.p.o = 0;
      this.p.c.clear();
      this.p.x = false;
      this.p.A = null;
      this.p.I.clear();
      this.p.J.clear();
      this.p.d = null;
      this.p.D = 0L;
      this.p.E = 0;
      this.p.F = 0;
      this.p.G = 0;
      for (;;)
      {
        long l2;
        try
        {
          for (;;)
          {
            this.p.g = NetConnInfoCenter.getSystemNetworkType();
            this.p.h = NetConnInfoCenter.getWifiStrength();
            this.p.j = NetConnInfoCenter.getCdmaStrength();
            this.p.i = NetConnInfoCenter.getGsmStrength();
            this.A = 0L;
            this.C = 0L;
            this.B = 0L;
            this.D = 0L;
            i3 = i1;
            try
            {
              if (!NetConnInfoCenter.isWifiConn()) {
                break label2021;
              }
              i3 = i1;
              if (NetConnInfoCenter.getWifiStrength() <= 10) {
                break label2021;
              }
              i3 = i1;
              if (!g.e.equals("NotWiFi")) {
                break label1938;
              }
              i3 = i1;
              if (this.e == 0) {
                break label1938;
              }
              i3 = i1;
              if (!QLog.isColorLevel()) {
                break;
              }
              i3 = i1;
              QLog.d("MSF.C.QualityTestManager", 2, "lost wifi connection, give up qualitytest run_thread" + Thread.currentThread().getName());
            }
            catch (Exception localException2)
            {
              l2 = 1L;
              i2 = i3;
            }
          }
          l1 = l2;
          i1 = i2;
          if (!QLog.isDevelopLevel()) {
            break label3451;
          }
          QLog.d("MSF.C.QualityTestManager", 4, "net change caused quality test error", localException2);
          l1 = l2;
          i1 = i2;
          break label3451;
          this.p.y.add(Integer.valueOf(i6));
          if (i4 != -1) {
            break label3288;
          }
        }
        catch (Exception localException3)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.d("MSF.C.QualityTestManager", 4, "failed to get network strength");
          continue;
          i3 = i1;
          if ((this.b.m & 0xFF) == 1L)
          {
            i3 = i1;
            if (this.d > 1)
            {
              i3 = i1;
              l1 = this.b.c / this.d;
              break label3451;
            }
            i3 = i1;
            l1 = this.b.m >> 8 & 0xFF;
            break label3451;
          }
          i3 = i1;
          l1 = this.b.c;
          break label3451;
        }
        i3 = i1;
        g.e = "NotWiFi";
        i3 = i1;
        if ((this.b.m & 0xFF) == 1L)
        {
          i3 = i1;
          if (this.d > 1)
          {
            i3 = i1;
            if (this.e != 0)
            {
              i3 = i1;
              if (!QLog.isColorLevel()) {
                break;
              }
              i3 = i1;
              QLog.d("MSF.C.QualityTestManager", 2, "lost wifi connection, give up qualitytest run_thread" + Thread.currentThread().getName());
              break;
            }
            i2 = -1;
            i3 = i2;
            this.d = 1;
            i3 = i2;
            if (this.b.b.size() > 75)
            {
              i3 = i2;
              if (QLog.isDevelopLevel())
              {
                i3 = i2;
                QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
              }
              i3 = i2;
              i1 = this.S.indexOf("#");
              if (i1 != -1)
              {
                i3 = i2;
                this.S = this.S.substring(0, i1 + 1);
              }
              i3 = i2;
              this.p.c.clear();
              i3 = i2;
              this.V = false;
              i3 = i2;
              b(a.d.a.m, true);
              i3 = i2;
              g.a();
              break;
            }
            i3 = i2;
            l1 = this.b.m;
            l2 = l1 >> 8 & 0xFF;
            try
            {
              i3 = this.S.indexOf("#");
              l1 = l2;
              i1 = i2;
              if (i3 == -1) {
                break label3451;
              }
              this.S = this.S.substring(0, i3 + 1);
              l1 = l2;
              i1 = i2;
            }
            catch (Exception localException4) {}
            continue;
          }
          i3 = i1;
          l1 = this.b.m >> 8 & 0xFF;
          break label3451;
        }
        i3 = i1;
        l1 = this.b.c;
        break label3451;
        try
        {
          label2337:
          if ((NetConnInfoCenter.isWifiConn()) && (NetConnInfoCenter.getWifiStrength() > 10)) {
            if (g.e.equals("NotWiFi"))
            {
              i4 = this.e;
              if (i4 == 0) {}
            }
          }
        }
        catch (Exception localException9)
        {
          for (;;)
          {
            label2478:
            label2921:
            label3060:
            label3070:
            i4 = i3;
            label2834:
            label2861:
            label3288:
            i5 = i1;
            label2944:
            label2960:
            i3 = i2;
            i1 = i4;
            i2 = i5;
          }
        }
        try
        {
          i1 = this.b.b.size();
          i3 = i1;
          i1 = i3;
        }
        catch (Exception localException10)
        {
          i1 = i3;
          i4 = 1;
          i3 = i2;
          i2 = i4;
          break label2834;
        }
        try
        {
          if (QLog.isColorLevel())
          {
            i1 = i3;
            QLog.d("MSF.C.QualityTestManager", 2, "lost wifi connection, give up qualitytest run_thread" + this.e);
          }
          i5 = 1;
          i4 = i3;
        }
        catch (Exception localException11)
        {
          i4 = 1;
          i3 = i2;
          i2 = i4;
          break label2834;
          break label2834;
        }
      }
      if ((this.b.m & 0xFF) == 1L) {
        if (this.d > 1)
        {
          l2 = this.b.c / this.d;
          l1 = l2;
          i4 = i1;
        }
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            for (;;)
            {
              this.r = 0L;
              this.s = 0L;
              this.t = 0L;
              this.u = 0L;
              this.v = 0L;
              this.w = 0L;
              this.x = 0L;
              this.y = 0L;
              b((com.tencent.msf.service.protocol.push.a.a)this.b.b.get(i3));
              if ((this.b.r & 0x2) != 2) {
                break label2960;
              }
              a(a.d.a.z);
              this.p.s = 0L;
              bool1 = false;
              h();
              i2 += 1;
              i1 = i4;
              break label3461;
              l2 = this.b.m >> 8 & 0xFF;
              l1 = l2;
              break label2478;
              l2 = this.b.c;
              l1 = l2;
              break label2478;
              g.e = "NotWiFi";
              if ((this.b.m & 0xFF) != 1L) {
                break label2944;
              }
              if (this.d <= 1) {
                break label2921;
              }
              i4 = this.e;
              if (i4 != 0)
              {
                i1 = this.b.b.size();
                i3 = i1;
                i1 = i3;
                if (QLog.isColorLevel())
                {
                  i1 = i3;
                  QLog.d("MSF.C.QualityTestManager", 2, "lost wifi connection, give up qualitytest run_thread" + this.e);
                }
                i5 = 1;
                i4 = i3;
                break;
              }
              i3 = 0;
              try
              {
                this.d = 1;
                if (this.b.b.size() <= 75) {
                  break label2861;
                }
                if (QLog.isDevelopLevel()) {
                  QLog.d("MSF.C.QualityTestManager", 4, "IPPort size too much, return ");
                }
                i2 = this.S.indexOf("#");
                if (i2 != -1) {
                  this.S = this.S.substring(0, i2 + 1);
                }
                this.p.c.clear();
                this.V = false;
                b(a.d.a.m, true);
                g.a();
              }
              catch (Exception localException5)
              {
                i4 = -1;
                i2 = i1;
                i1 = i4;
              }
            }
            if (QLog.isDevelopLevel()) {
              QLog.d("MSF.C.QualityTestManager", 4, "net change caused quality test error", localException5);
            }
            i4 = i2;
            i2 = i3;
            i3 = i1;
            continue;
            l2 = this.b.m;
            l1 = l2 >> 8 & 0xFF;
          }
          catch (Exception localException7)
          {
            byte[] arrayOfByte;
            QLog.d("MSF.C.QualityTestManager", 1, "QualityClient:  error:", localException7);
            localException7.printStackTrace();
            h();
            continue;
          }
          finally
          {
            h();
          }
          try
          {
            i2 = this.S.indexOf("#");
            if (i2 != -1) {
              this.S = this.S.substring(0, i2 + 1);
            }
            i4 = -1;
            i5 = i1;
          }
          catch (Exception localException12)
          {
            i4 = -1;
            i2 = i1;
            i1 = i4;
          }
        }
        l2 = this.b.m >> 8 & 0xFF;
        l1 = l2;
        break label2478;
        l2 = this.b.c;
        l1 = l2;
        break label2478;
        bool2 = a(i6);
        arrayOfByte = a(i6, this.b.g, this.b.p);
        if (a((com.tencent.msf.service.protocol.push.a.a)this.b.b.get(i3))) {
          break label3497;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("MSF.C.QualityTestManager", 4, "connectToServer error, return ");
        }
        bool1 = false;
        try
        {
          this.p.J.add(Long.valueOf(-1L));
          a(a.d.a.c);
          h();
        }
        catch (Exception localException8)
        {
          bool1 = false;
          continue;
        }
        bool1 = false;
        h();
        continue;
        if ((this.a != a.c) || (this.l == 0))
        {
          bool2 = a(arrayOfByte);
          if (!bool2)
          {
            bool1 = false;
            this.p.J.add(Long.valueOf(-1L));
            h();
            continue;
          }
        }
        i1 = 0;
        if ((this.b.o == 0) || (1 == this.b.o))
        {
          i1 = arrayOfByte.length;
          bool2 = a(i1, arrayOfByte);
          if (!bool2)
          {
            bool1 = false;
            h();
          }
        }
        else
        {
          if (2 != this.b.o) {
            continue;
          }
          l2 = this.b.n;
          i1 = (int)l2;
          continue;
        }
        h();
        try
        {
          Thread.sleep(this.b.d);
        }
        catch (Exception localException6)
        {
          QLog.d("MSF.C.QualityTestManager", 1, "QualityClient: Thread sleep error " + localException6);
        }
      }
      if (i4 != this.b.b.size() - 1) {
        break label3510;
      }
    }
    label3461:
    label3489:
    label3495:
    label3497:
    label3510:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.QualityTestManager", 2, "testsuccess: " + bool1);
      }
      if (bool1) {
        b(a.d.a.a, bool2);
      }
      for (;;)
      {
        if (bool2)
        {
          this.f = true;
          break label3489;
          b(a.d.a.b, bool2);
          continue;
          break;
          label3451:
          bool1 = true;
          i3 = i1;
          i2 = 0;
          i1 = i5;
          i4 = i3;
          i5 = i1;
          if (i2 >= l1) {
            break label1893;
          }
          if (i3 != -1) {
            break label2337;
          }
          i4 = i3;
          i5 = i1;
          break label1893;
        }
      }
      i1 = i4 + 1;
      break label1548;
      break label1507;
      if (!bool2) {
        break label3060;
      }
      if (localException12 != null) {
        break label3070;
      }
      break label3060;
    }
  }
  
  public void run()
  {
    try
    {
      if (this.b == null) {
        break label74;
      }
      switch (d.a[this.a.ordinal()])
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
      l();
      return;
    }
  }
  
  public static enum a
  {
    public static a a(String paramString)
    {
      return (a)Enum.valueOf(a.class, paramString);
    }
    
    public static a[] a()
    {
      return (a[])f.clone();
    }
  }
  
  static class b
  {
    public String[] a;
    public String b = "";
    
    public static b a(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      b localb = new b();
      int j = paramString.indexOf("\r\n\r\n");
      int i = j;
      if (j == -1) {
        i = paramString.length();
      }
      localb.a = paramString.substring(0, i).split("\r\n");
      return localb;
    }
    
    public String a()
    {
      if ((this.a == null) || (this.a.length == 0)) {
        return "";
      }
      String str1 = "";
      String[] arrayOfString = this.a;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str2 = arrayOfString[i];
        str1 = str1 + str2 + "\r\n";
        i += 1;
      }
      return str1 + "\r\n";
    }
    
    public String b()
    {
      if ((this.a == null) || (this.a.length == 0)) {}
      for (;;)
      {
        return "";
        String[] arrayOfString = this.a;
        int m = arrayOfString.length;
        int i = 0;
        while (i < m)
        {
          String str = arrayOfString[i];
          if (((str.startsWith("Set-Cookie:")) && (str.contains("gateway="))) || ((str.startsWith("Cookie:")) && (str.contains("gateway="))))
          {
            int n = str.indexOf("gateway=");
            int k = str.indexOf(";", n);
            int j = k;
            if (k == -1) {
              j = str.length();
            }
            if ((n != -1) && (j > n)) {
              return str.substring("gateway=".length() + n, j);
            }
          }
          i += 1;
        }
      }
    }
    
    public String c()
    {
      if ((this.a == null) || (this.a.length == 0)) {}
      for (;;)
      {
        return "";
        String[] arrayOfString = this.a;
        int m = arrayOfString.length;
        int i = 0;
        while (i < m)
        {
          String str = arrayOfString[i];
          if (((str.startsWith("Set-Cookie:")) && (str.contains("md5="))) || ((str.startsWith("Cookie:")) && (str.contains("md5="))))
          {
            int n = str.indexOf("md5=");
            int k = str.indexOf(";", n);
            int j = k;
            if (k == -1) {
              j = str.length();
            }
            if ((n != -1) && (j > n)) {
              return str.substring("md5=".length() + n, j);
            }
          }
          i += 1;
        }
      }
    }
    
    public String d()
    {
      if ((this.a == null) || (this.a.length == 0)) {
        return this.b;
      }
      String[] arrayOfString = this.a;
      int j = arrayOfString.length;
      Object localObject1 = "";
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        Object localObject2;
        if (str.startsWith("Set-Cookie:"))
        {
          localObject2 = localObject1;
          if (str.contains("md5=")) {}
        }
        else if (str.startsWith("Cookie:"))
        {
          localObject2 = localObject1;
          if (str.contains("md5=")) {}
        }
        else
        {
          localObject2 = (String)localObject1 + str + "\r\n";
        }
        i += 1;
        localObject1 = localObject2;
      }
      return (String)localObject1 + "\r\n";
    }
    
    public int e()
    {
      int k = -1;
      int j = k;
      if (this.a != null)
      {
        j = k;
        if (this.a.length <= 0) {}
      }
      try
      {
        String[] arrayOfString = this.a;
        int m = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          j = k;
          if (i < m)
          {
            String str = arrayOfString[i];
            if (str.startsWith("Content-Length:")) {
              j = Integer.parseInt(str.substring("Content-Length:".length(), str.length()).trim());
            }
          }
          else
          {
            return j;
          }
          i += 1;
        }
        return -1;
      }
      catch (Exception localException) {}
    }
    
    public boolean f()
    {
      if ((this.a == null) || (this.a.length <= 0)) {}
      label64:
      for (;;)
      {
        return false;
        String[] arrayOfString = this.a;
        int j = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label64;
          }
          String str = arrayOfString[i];
          if (str.startsWith("HTTP/1."))
          {
            if (!str.contains("200")) {
              break;
            }
            return true;
          }
          i += 1;
        }
      }
    }
    
    public boolean g()
    {
      return (f()) && (!TextUtils.isEmpty(c()));
    }
  }
  
  static class c
  {
    public a a = a.a;
    public String b;
    public int c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public String i;
    public String j;
    public String k;
    public long l;
    public String m;
    
    c()
    {
      String str = Build.VERSION.RELEASE.replaceAll("|", "_").replaceAll("#", "_").replace("*", "_");
      this.b = (a.e() + "," + a.d() + "," + str);
      this.c = 0;
      this.d = 0L;
      this.e = 0L;
      this.f = 0L;
      this.g = 0L;
      this.h = 0L;
      this.i = "";
      this.j = "0.0.0.0";
      this.k = t.e();
      this.l = 0L;
      this.m = "0,0";
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      localStringBuilder.append(this.a).append(":").append(5).append("|").append(this.i).append("|").append(this.j).append("|").append(this.k).append("|").append(this.l).append("|").append(this.m).append("|").append(this.e).append("|").append(this.d).append("|").append(this.f).append("|").append(this.c).append("|").append(this.b).append("|").append(this.g).append("|").append(this.h).append("#");
      return localStringBuilder.toString();
    }
    
    public static enum a
    {
      public static a a(String paramString)
      {
        return (a)Enum.valueOf(a.class, paramString);
      }
      
      public static a[] a()
      {
        return (a[])b.clone();
      }
    }
  }
  
  static class d
  {
    public String A;
    public long B = 0L;
    public String C;
    public long D = 0L;
    public int E = 0;
    public int F = 0;
    public int G = 0;
    public int H;
    public ArrayList I = new ArrayList();
    public ArrayList J = new ArrayList();
    public String K;
    public String L = "0.0.0.0";
    public long M = 0L;
    public long N = 0L;
    public int O = 0;
    public String P = "";
    public int Q = 0;
    public String R = "";
    public b a = b.a;
    public a b = a.a;
    public Map c = new HashMap();
    public InetAddress d;
    public InetAddress e;
    public int f = 0;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;
    public int o = 0;
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public long s = 0L;
    public long t = 0L;
    ArrayList u;
    ArrayList v;
    public long w = 0L;
    public boolean x = false;
    ArrayList y;
    public long z;
    
    public String toString()
    {
      Object localObject1;
      label79:
      Object localObject3;
      label110:
      Object localObject4;
      if ((this.b == a.a) && (this.c.isEmpty()))
      {
        localObject1 = this.b;
        localObject1 = a.a.toString();
        if ((this.r != 5) && (this.r != 6)) {
          break label374;
        }
        if (this.K != null) {
          break label343;
        }
        localObject2 = "0|" + "0.0.0.0|";
        if (this.C != null)
        {
          localObject3 = localObject2;
          if (!this.C.isEmpty()) {}
        }
        else
        {
          this.C = this.K;
          localObject3 = localObject2;
        }
        localObject2 = "";
        localObject4 = localObject2;
        if (this.y == null) {
          break label558;
        }
        localObject4 = localObject2;
        if (this.y.size() == 0) {
          break label558;
        }
        i1 = 0;
        label138:
        localObject4 = localObject2;
        if (i1 >= this.y.size()) {
          break label558;
        }
        if (i1 == this.y.size() - 1) {
          break label529;
        }
      }
      label384:
      label512:
      label529:
      for (Object localObject2 = (String)localObject2 + this.y.get(i1) + ",";; localObject2 = (String)localObject2 + this.y.get(i1))
      {
        i1 += 1;
        break label138;
        if ((this.c == null) || (this.c.isEmpty()))
        {
          localObject1 = this.b;
          localObject1 = a.b.toString();
          break;
        }
        localObject3 = this.c.entrySet().iterator();
        for (localObject2 = "";; localObject2 = (String)localObject2 + ((a)localObject4).toString() + ":" + i1 + ";")
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (Map.Entry)((Iterator)localObject3).next();
          localObject4 = (a)((Map.Entry)localObject1).getKey();
          i1 = ((Integer)((Map.Entry)localObject1).getValue()).intValue();
        }
        label343:
        localObject2 = "0|" + this.K + "|";
        break label79;
        label374:
        if (this.d == null)
        {
          localObject2 = "0.0.0.0|";
          if (this.e != null) {
            break label479;
          }
        }
        label479:
        for (localObject2 = (String)localObject2 + "0.0.0.0|";; localObject2 = (String)localObject2 + this.e.getHostAddress() + "|")
        {
          if (this.C != null)
          {
            localObject3 = localObject2;
            if (!this.C.isEmpty()) {
              break;
            }
          }
          if (this.e != null) {
            break label512;
          }
          this.C = "0.0.0.0";
          localObject3 = localObject2;
          break;
          localObject2 = this.d.getHostAddress() + "|";
          break label384;
        }
        this.C = this.e.getHostAddress();
        localObject3 = localObject2;
        break label110;
      }
      label558:
      localObject2 = "";
      Object localObject5 = localObject2;
      if (this.u != null)
      {
        localObject5 = localObject2;
        if (this.u.size() != 0)
        {
          i1 = 0;
          localObject5 = localObject2;
          if (i1 < this.u.size())
          {
            if (i1 != this.u.size() - 1) {}
            for (localObject2 = (String)localObject2 + this.u.get(i1) + ",";; localObject2 = (String)localObject2 + this.u.get(i1))
            {
              i1 += 1;
              break;
            }
          }
        }
      }
      if (this.x) {}
      for (String str1 = this.A; this.a == b.a; str1 = "false") {
        return "" + (String)localObject1 + "|" + (String)localObject3 + this.f + "|" + this.L + "|" + this.M + "|" + this.N + "|" + this.O + "|" + this.P + "|" + this.Q + "|" + this.R + "|" + this.C + "|" + this.D + "|" + this.E + "|" + this.F + "|" + this.G + "|" + this.g + "|" + this.l + "|" + this.m + "|" + this.I.toString().replace("[", "").replace("]", "") + "|" + this.J.toString().replace("[", "").replace("]", "") + "|" + this.n + "|" + this.o + "|" + this.p + "|" + this.q + "|" + this.r + "|" + this.s + "|" + this.t + "|" + localObject5 + "|" + this.w + "|" + str1 + "|" + (String)localObject4 + "|" + this.z + "|" + this.h + "," + this.i + "," + this.j;
      }
      int i1 = Math.min(this.l, this.m);
      String str2;
      if (i1 > 0)
      {
        str2 = Integer.toString(this.k / i1);
        String str3 = "";
        localObject2 = str3;
        if (this.v == null) {
          break label1315;
        }
        localObject2 = str3;
        if (this.v.size() == 0) {
          break label1315;
        }
        localObject2 = "";
        i1 = 0;
        label1216:
        if (i1 >= this.v.size()) {
          break label1315;
        }
        if (i1 == this.v.size() - 1) {
          break label1286;
        }
      }
      label1286:
      for (localObject2 = (String)localObject2 + this.v.get(i1) + ",";; localObject2 = (String)localObject2 + this.v.get(i1))
      {
        i1 += 1;
        break label1216;
        str2 = "0";
        break;
      }
      label1315:
      return "" + this.a + "|" + (String)localObject1 + "|" + (String)localObject3 + this.f + "|" + this.g + "|" + str2 + "|" + this.l + "|" + this.m + "|" + this.n + "|" + this.o + "|" + (String)localObject2 + "|" + this.p + "|" + this.q + "|" + this.r + "|" + this.s + "|" + this.t + "|" + localObject5 + "|" + this.w + "|" + str1 + "|" + (String)localObject4 + "|" + this.z + "|" + this.h + "," + this.i + "," + this.j;
    }
    
    public static enum a
    {
      public static a a(String paramString)
      {
        return (a)Enum.valueOf(a.class, paramString);
      }
      
      public static a[] a()
      {
        return (a[])B.clone();
      }
    }
    
    public static enum b
    {
      public static b a(String paramString)
      {
        return (b)Enum.valueOf(b.class, paramString);
      }
      
      public static b[] a()
      {
        return (b[])c.clone();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.a
 * JD-Core Version:    0.7.0.1
 */