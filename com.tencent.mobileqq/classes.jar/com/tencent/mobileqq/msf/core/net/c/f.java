package com.tencent.mobileqq.msf.core.net.c;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c;
import com.tencent.mobileqq.msf.core.o;
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

public class f
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
  long A = 0L;
  long B = 0L;
  long C = 0L;
  long D = 0L;
  long E = 0L;
  private HostnameVerifier R = new g(this);
  private String S = "";
  private int T;
  private int U;
  private boolean V = true;
  f.b a;
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
  f.e p = new f.e();
  f.d q = new f.d();
  long r = 0L;
  long s = 0L;
  long t = 0L;
  long u = 0L;
  long v = 0L;
  long w = 0L;
  long x = 0L;
  long y = 0L;
  long z = 0L;
  
  public f(d paramd, f.b paramb)
  {
    this.b = paramd;
    this.a = paramb;
    this.c = null;
    this.d = 1;
    this.e = 0;
  }
  
  public f(d paramd, b paramb, f.b paramb1, int paramInt1, int paramInt2)
  {
    this.b = paramd;
    this.c = paramb;
    this.a = paramb1;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  private void a(f.e.a parama)
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
      a(f.e.a.y);
      return;
    }
    if (paramString.indexOf("timeout") > -1)
    {
      a(f.e.a.x);
      return;
    }
    a(f.e.a.e);
  }
  
  private boolean a(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (this.a == f.b.c)
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
        a(f.e.a.h);
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
        a(f.e.a.i);
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
      a(f.e.a.h);
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
      a(f.e.a.i);
      return false;
    }
    return true;
  }
  
  /* Error */
  private boolean a(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: istore 7
    //   5: ldc 255
    //   7: astore 14
    //   9: iload 7
    //   11: ifeq +61 -> 72
    //   14: new 241	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   21: astore 12
    //   23: aload 12
    //   25: ldc_w 287
    //   28: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 12
    //   34: iload_1
    //   35: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 12
    //   41: ldc_w 289
    //   44: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 12
    //   50: aload_0
    //   51: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   54: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   57: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: ldc 255
    //   63: iconst_2
    //   64: aload 12
    //   66: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: iload_1
    //   73: ldc 233
    //   75: if_icmple +38 -> 113
    //   78: aload 14
    //   80: astore 15
    //   82: aload_0
    //   83: iconst_0
    //   84: putfield 134	com/tencent/mobileqq/msf/core/net/c/f:V	Z
    //   87: aload 14
    //   89: astore 15
    //   91: aload_0
    //   92: getstatic 293	com/tencent/mobileqq/msf/core/net/c/f$e$a:A	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   95: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/f:a	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;)V
    //   98: aload 14
    //   100: astore 15
    //   102: ldc 255
    //   104: iconst_1
    //   105: ldc_w 295
    //   108: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: iconst_0
    //   112: ireturn
    //   113: aload 14
    //   115: astore 15
    //   117: getstatic 300	com/tencent/mobileqq/msf/core/net/c/h:a	[I
    //   120: aload_0
    //   121: getfield 166	com/tencent/mobileqq/msf/core/net/c/f:a	Lcom/tencent/mobileqq/msf/core/net/c/f$b;
    //   124: invokevirtual 303	com/tencent/mobileqq/msf/core/net/c/f$b:ordinal	()I
    //   127: iaload
    //   128: istore_3
    //   129: iload_3
    //   130: iconst_1
    //   131: if_icmpeq +3406 -> 3537
    //   134: aconst_null
    //   135: astore 13
    //   137: aconst_null
    //   138: astore 12
    //   140: aconst_null
    //   141: astore 15
    //   143: aconst_null
    //   144: astore 16
    //   146: iload_3
    //   147: iconst_2
    //   148: if_icmpeq +1544 -> 1692
    //   151: iload_3
    //   152: iconst_3
    //   153: if_icmpeq +5 -> 158
    //   156: iconst_0
    //   157: ireturn
    //   158: aload 16
    //   160: astore 12
    //   162: aload_0
    //   163: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   166: aload_0
    //   167: getfield 305	com/tencent/mobileqq/msf/core/net/c/f:k	Ljava/net/HttpURLConnection;
    //   170: invokevirtual 310	java/net/HttpURLConnection:getResponseCode	()I
    //   173: putfield 312	com/tencent/mobileqq/msf/core/net/c/f$e:G	I
    //   176: aload 16
    //   178: astore 12
    //   180: aload_0
    //   181: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   184: aload_0
    //   185: getfield 305	com/tencent/mobileqq/msf/core/net/c/f:k	Ljava/net/HttpURLConnection;
    //   188: invokevirtual 315	java/net/HttpURLConnection:getContentLength	()I
    //   191: putfield 317	com/tencent/mobileqq/msf/core/net/c/f$e:H	I
    //   194: aload 16
    //   196: astore 12
    //   198: aload_0
    //   199: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   202: putfield 146	com/tencent/mobileqq/msf/core/net/c/f:w	J
    //   205: aload 16
    //   207: astore 12
    //   209: aload_0
    //   210: aload_0
    //   211: getfield 146	com/tencent/mobileqq/msf/core/net/c/f:w	J
    //   214: aload_0
    //   215: getfield 144	com/tencent/mobileqq/msf/core/net/c/f:v	J
    //   218: lsub
    //   219: putfield 154	com/tencent/mobileqq/msf/core/net/c/f:A	J
    //   222: aload 16
    //   224: astore 12
    //   226: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   229: ifeq +107 -> 336
    //   232: aload 16
    //   234: astore 12
    //   236: new 241	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   243: astore_2
    //   244: aload 16
    //   246: astore 12
    //   248: aload_2
    //   249: ldc_w 325
    //   252: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 16
    //   258: astore 12
    //   260: aload_2
    //   261: aload_0
    //   262: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   265: getfield 312	com/tencent/mobileqq/msf/core/net/c/f$e:G	I
    //   268: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 16
    //   274: astore 12
    //   276: aload_2
    //   277: ldc_w 327
    //   280: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 16
    //   286: astore 12
    //   288: aload_2
    //   289: iload_1
    //   290: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 16
    //   296: astore 12
    //   298: aload_2
    //   299: ldc_w 329
    //   302: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 16
    //   308: astore 12
    //   310: aload_2
    //   311: aload_0
    //   312: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   315: getfield 317	com/tencent/mobileqq/msf/core/net/c/f$e:H	I
    //   318: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 16
    //   324: astore 12
    //   326: ldc 255
    //   328: iconst_4
    //   329: aload_2
    //   330: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: aload 16
    //   338: astore 12
    //   340: aload_0
    //   341: getfield 146	com/tencent/mobileqq/msf/core/net/c/f:w	J
    //   344: lstore 8
    //   346: aload 16
    //   348: astore 12
    //   350: aload_0
    //   351: lload 8
    //   353: putfield 148	com/tencent/mobileqq/msf/core/net/c/f:x	J
    //   356: aload 16
    //   358: astore 12
    //   360: aload_0
    //   361: lload 8
    //   363: putfield 150	com/tencent/mobileqq/msf/core/net/c/f:y	J
    //   366: aload 16
    //   368: astore 12
    //   370: new 331	java/io/BufferedInputStream
    //   373: dup
    //   374: aload_0
    //   375: getfield 305	com/tencent/mobileqq/msf/core/net/c/f:k	Ljava/net/HttpURLConnection;
    //   378: invokevirtual 335	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   381: invokespecial 338	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   384: astore_2
    //   385: getstatic 343	com/tencent/mobileqq/msf/core/net/c/k:f	Ljava/util/ArrayList;
    //   388: aload_2
    //   389: invokevirtual 344	java/lang/Object:toString	()Ljava/lang/String;
    //   392: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   395: pop
    //   396: sipush 1024
    //   399: newarray byte
    //   401: astore 12
    //   403: iload_1
    //   404: newarray byte
    //   406: astore 13
    //   408: iconst_0
    //   409: istore_3
    //   410: iload_3
    //   411: iload_1
    //   412: if_icmpge +192 -> 604
    //   415: aload_2
    //   416: aload 12
    //   418: invokevirtual 355	java/io/InputStream:read	([B)I
    //   421: istore 4
    //   423: iload 4
    //   425: iconst_m1
    //   426: if_icmpeq +178 -> 604
    //   429: iload 4
    //   431: iload_1
    //   432: if_icmple +16 -> 448
    //   435: aload 12
    //   437: iconst_0
    //   438: aload 13
    //   440: iload_3
    //   441: iload_1
    //   442: invokestatic 359	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   445: goto +37 -> 482
    //   448: iload 4
    //   450: iload_3
    //   451: iadd
    //   452: iload_1
    //   453: if_icmple +18 -> 471
    //   456: aload 12
    //   458: iconst_0
    //   459: aload 13
    //   461: iload_3
    //   462: iload_1
    //   463: iload_3
    //   464: isub
    //   465: invokestatic 359	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   468: goto +14 -> 482
    //   471: aload 12
    //   473: iconst_0
    //   474: aload 13
    //   476: iload_3
    //   477: iload 4
    //   479: invokestatic 359	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   482: iload_3
    //   483: iload 4
    //   485: iadd
    //   486: istore_3
    //   487: aload_0
    //   488: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   491: putfield 150	com/tencent/mobileqq/msf/core/net/c/f:y	J
    //   494: iload_3
    //   495: ldc_w 360
    //   498: if_icmple +93 -> 591
    //   501: getstatic 343	com/tencent/mobileqq/msf/core/net/c/k:f	Ljava/util/ArrayList;
    //   504: aload_2
    //   505: invokevirtual 344	java/lang/Object:toString	()Ljava/lang/String;
    //   508: invokevirtual 363	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   511: pop
    //   512: aload_0
    //   513: aload_0
    //   514: getfield 160	com/tencent/mobileqq/msf/core/net/c/f:D	J
    //   517: iload_3
    //   518: i2l
    //   519: ladd
    //   520: putfield 160	com/tencent/mobileqq/msf/core/net/c/f:D	J
    //   523: aload_0
    //   524: aload_0
    //   525: getfield 365	com/tencent/mobileqq/msf/core/net/c/f:U	I
    //   528: iload_3
    //   529: iadd
    //   530: putfield 365	com/tencent/mobileqq/msf/core/net/c/f:U	I
    //   533: aload_0
    //   534: iconst_0
    //   535: putfield 134	com/tencent/mobileqq/msf/core/net/c/f:V	Z
    //   538: aload_0
    //   539: getstatic 367	com/tencent/mobileqq/msf/core/net/c/f$e$a:u	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   542: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/f:a	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;)V
    //   545: aload 14
    //   547: astore 15
    //   549: aload_2
    //   550: invokevirtual 370	java/io/InputStream:close	()V
    //   553: goto +36 -> 589
    //   556: astore_2
    //   557: aload 14
    //   559: astore 15
    //   561: aload_2
    //   562: invokevirtual 373	java/lang/Throwable:printStackTrace	()V
    //   565: aload 14
    //   567: astore 15
    //   569: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   572: ifeq +17 -> 589
    //   575: aload 14
    //   577: astore 15
    //   579: ldc 255
    //   581: iconst_4
    //   582: ldc_w 375
    //   585: aload_2
    //   586: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   589: iconst_0
    //   590: ireturn
    //   591: goto -181 -> 410
    //   594: astore 13
    //   596: goto +1041 -> 1637
    //   599: astore 13
    //   601: goto +878 -> 1479
    //   604: getstatic 343	com/tencent/mobileqq/msf/core/net/c/k:f	Ljava/util/ArrayList;
    //   607: aload_2
    //   608: invokevirtual 344	java/lang/Object:toString	()Ljava/lang/String;
    //   611: invokevirtual 363	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   614: pop
    //   615: aload_0
    //   616: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   619: astore 12
    //   621: aload 12
    //   623: aload_0
    //   624: getfield 144	com/tencent/mobileqq/msf/core/net/c/f:v	J
    //   627: putfield 380	com/tencent/mobileqq/msf/core/net/c/f$e:M	J
    //   630: aload_0
    //   631: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   634: aload_0
    //   635: getfield 150	com/tencent/mobileqq/msf/core/net/c/f:y	J
    //   638: putfield 382	com/tencent/mobileqq/msf/core/net/c/f$e:N	J
    //   641: aload_0
    //   642: aload_0
    //   643: getfield 150	com/tencent/mobileqq/msf/core/net/c/f:y	J
    //   646: aload_0
    //   647: getfield 144	com/tencent/mobileqq/msf/core/net/c/f:v	J
    //   650: lsub
    //   651: putfield 162	com/tencent/mobileqq/msf/core/net/c/f:E	J
    //   654: aload_0
    //   655: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   658: getfield 384	com/tencent/mobileqq/msf/core/net/c/f$e:J	Ljava/util/ArrayList;
    //   661: aload_0
    //   662: getfield 162	com/tencent/mobileqq/msf/core/net/c/f:E	J
    //   665: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   668: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   671: pop
    //   672: aload_0
    //   673: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   676: astore 12
    //   678: aload 12
    //   680: getfield 391	com/tencent/mobileqq/msf/core/net/c/f$e:k	I
    //   683: istore 4
    //   685: iload 4
    //   687: i2l
    //   688: lstore 8
    //   690: aload 12
    //   692: lload 8
    //   694: aload_0
    //   695: getfield 162	com/tencent/mobileqq/msf/core/net/c/f:E	J
    //   698: ladd
    //   699: l2i
    //   700: putfield 391	com/tencent/mobileqq/msf/core/net/c/f$e:k	I
    //   703: aload_0
    //   704: getfield 158	com/tencent/mobileqq/msf/core/net/c/f:C	J
    //   707: lstore 8
    //   709: aload_0
    //   710: getfield 150	com/tencent/mobileqq/msf/core/net/c/f:y	J
    //   713: lstore 10
    //   715: aload_2
    //   716: astore 12
    //   718: aload_0
    //   719: lload 8
    //   721: lload 10
    //   723: aload_0
    //   724: getfield 148	com/tencent/mobileqq/msf/core/net/c/f:x	J
    //   727: lsub
    //   728: ladd
    //   729: putfield 158	com/tencent/mobileqq/msf/core/net/c/f:C	J
    //   732: aload_0
    //   733: aload_0
    //   734: getfield 160	com/tencent/mobileqq/msf/core/net/c/f:D	J
    //   737: iload_3
    //   738: i2l
    //   739: ladd
    //   740: putfield 160	com/tencent/mobileqq/msf/core/net/c/f:D	J
    //   743: aload_0
    //   744: aload_0
    //   745: getfield 365	com/tencent/mobileqq/msf/core/net/c/f:U	I
    //   748: iload_3
    //   749: iadd
    //   750: putfield 365	com/tencent/mobileqq/msf/core/net/c/f:U	I
    //   753: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   756: istore 7
    //   758: iload 7
    //   760: ifeq +118 -> 878
    //   763: new 241	java/lang/StringBuilder
    //   766: dup
    //   767: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   770: astore 15
    //   772: aload 15
    //   774: ldc_w 393
    //   777: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: pop
    //   781: aload 15
    //   783: aload_0
    //   784: getfield 162	com/tencent/mobileqq/msf/core/net/c/f:E	J
    //   787: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   790: pop
    //   791: aload 15
    //   793: ldc_w 398
    //   796: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: pop
    //   800: aload 15
    //   802: aload_0
    //   803: getfield 158	com/tencent/mobileqq/msf/core/net/c/f:C	J
    //   806: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: aload 15
    //   812: ldc_w 400
    //   815: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: aload 15
    //   821: aload_0
    //   822: getfield 160	com/tencent/mobileqq/msf/core/net/c/f:D	J
    //   825: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   828: pop
    //   829: aload 15
    //   831: ldc_w 402
    //   834: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: pop
    //   838: aload 15
    //   840: aload_0
    //   841: getfield 365	com/tencent/mobileqq/msf/core/net/c/f:U	I
    //   844: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   847: pop
    //   848: ldc 255
    //   850: iconst_4
    //   851: aload 15
    //   853: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   856: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   859: goto +19 -> 878
    //   862: astore 13
    //   864: aload 12
    //   866: astore_2
    //   867: goto +770 -> 1637
    //   870: astore 13
    //   872: aload 12
    //   874: astore_2
    //   875: goto +604 -> 1479
    //   878: aload_0
    //   879: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   882: getfield 403	com/tencent/msf/service/protocol/push/a/d:x	J
    //   885: lstore 8
    //   887: lload 8
    //   889: lconst_0
    //   890: lcmp
    //   891: ifle +173 -> 1064
    //   894: aload_0
    //   895: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   898: getfield 403	com/tencent/msf/service/protocol/push/a/d:x	J
    //   901: l2i
    //   902: istore 5
    //   904: aload_0
    //   905: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   908: getfield 404	com/tencent/msf/service/protocol/push/a/d:w	J
    //   911: l2i
    //   912: istore 6
    //   914: iload 5
    //   916: istore 4
    //   918: iload 5
    //   920: ldc_w 405
    //   923: if_icmple +8 -> 931
    //   926: ldc_w 405
    //   929: istore 4
    //   931: iload_3
    //   932: iload_1
    //   933: invokestatic 411	java/lang/Math:min	(II)I
    //   936: istore 5
    //   938: iload 6
    //   940: iload 5
    //   942: if_icmpge +122 -> 1064
    //   945: iload 4
    //   947: iload 6
    //   949: iadd
    //   950: iload 5
    //   952: if_icmple +46 -> 998
    //   955: aload_0
    //   956: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   959: astore 15
    //   961: iload 5
    //   963: iload 6
    //   965: isub
    //   966: istore 4
    //   968: aload 15
    //   970: new 219	java/lang/String
    //   973: dup
    //   974: aload 13
    //   976: iload 6
    //   978: iload 4
    //   980: invokespecial 414	java/lang/String:<init>	([BII)V
    //   983: putfield 416	com/tencent/mobileqq/msf/core/net/c/f$e:P	Ljava/lang/String;
    //   986: aload_0
    //   987: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   990: iload 4
    //   992: putfield 418	com/tencent/mobileqq/msf/core/net/c/f$e:O	I
    //   995: goto +32 -> 1027
    //   998: aload_0
    //   999: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1002: new 219	java/lang/String
    //   1005: dup
    //   1006: aload 13
    //   1008: iload 6
    //   1010: iload 4
    //   1012: invokespecial 414	java/lang/String:<init>	([BII)V
    //   1015: putfield 416	com/tencent/mobileqq/msf/core/net/c/f$e:P	Ljava/lang/String;
    //   1018: aload_0
    //   1019: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1022: iload 4
    //   1024: putfield 418	com/tencent/mobileqq/msf/core/net/c/f$e:O	I
    //   1027: aload_0
    //   1028: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1031: aload_0
    //   1032: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1035: getfield 416	com/tencent/mobileqq/msf/core/net/c/f$e:P	Ljava/lang/String;
    //   1038: invokestatic 423	com/tencent/qphone/base/util/g:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1041: putfield 416	com/tencent/mobileqq/msf/core/net/c/f$e:P	Ljava/lang/String;
    //   1044: aload_0
    //   1045: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1048: aload_0
    //   1049: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1052: getfield 416	com/tencent/mobileqq/msf/core/net/c/f$e:P	Ljava/lang/String;
    //   1055: invokevirtual 426	java/lang/String:length	()I
    //   1058: putfield 418	com/tencent/mobileqq/msf/core/net/c/f$e:O	I
    //   1061: goto +3 -> 1064
    //   1064: new 219	java/lang/String
    //   1067: dup
    //   1068: aload 13
    //   1070: iconst_0
    //   1071: iload_3
    //   1072: aload 13
    //   1074: arraylength
    //   1075: invokestatic 411	java/lang/Math:min	(II)I
    //   1078: invokespecial 414	java/lang/String:<init>	([BII)V
    //   1081: astore 13
    //   1083: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1086: istore 7
    //   1088: iload 7
    //   1090: ifeq +40 -> 1130
    //   1093: new 241	java/lang/StringBuilder
    //   1096: dup
    //   1097: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1100: astore 15
    //   1102: aload 15
    //   1104: ldc_w 428
    //   1107: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: pop
    //   1111: aload 15
    //   1113: aload 13
    //   1115: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1118: pop
    //   1119: ldc 255
    //   1121: iconst_4
    //   1122: aload 15
    //   1124: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1127: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1130: aload 13
    //   1132: aload_0
    //   1133: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1136: getfield 430	com/tencent/msf/service/protocol/push/a/d:t	Ljava/lang/String;
    //   1139: invokevirtual 434	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1142: istore 7
    //   1144: iload 7
    //   1146: ifne +11 -> 1157
    //   1149: aload_0
    //   1150: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1153: iconst_1
    //   1154: putfield 436	com/tencent/mobileqq/msf/core/net/c/f$e:F	I
    //   1157: aload_0
    //   1158: aload_0
    //   1159: getfield 305	com/tencent/mobileqq/msf/core/net/c/f:k	Ljava/net/HttpURLConnection;
    //   1162: ldc_w 438
    //   1165: invokevirtual 441	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1168: invokespecial 443	com/tencent/mobileqq/msf/core/net/c/f:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1171: astore 13
    //   1173: aload 13
    //   1175: ifnull +62 -> 1237
    //   1178: aload 13
    //   1180: invokestatic 449	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   1183: astore 15
    //   1185: aload_0
    //   1186: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1189: aload 15
    //   1191: putfield 451	com/tencent/mobileqq/msf/core/net/c/f$e:d	Ljava/net/InetAddress;
    //   1194: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1197: ifeq +40 -> 1237
    //   1200: new 241	java/lang/StringBuilder
    //   1203: dup
    //   1204: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1207: astore 15
    //   1209: aload 15
    //   1211: ldc_w 453
    //   1214: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: pop
    //   1218: aload 15
    //   1220: aload 13
    //   1222: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1225: pop
    //   1226: ldc 255
    //   1228: iconst_4
    //   1229: aload 15
    //   1231: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1234: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1237: aload_0
    //   1238: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1241: astore 13
    //   1243: aload 13
    //   1245: aload 13
    //   1247: getfield 454	com/tencent/mobileqq/msf/core/net/c/f$e:m	I
    //   1250: iconst_1
    //   1251: iadd
    //   1252: putfield 454	com/tencent/mobileqq/msf/core/net/c/f$e:m	I
    //   1255: new 241	java/lang/StringBuilder
    //   1258: dup
    //   1259: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1262: astore 13
    //   1264: aload 13
    //   1266: ldc_w 456
    //   1269: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1272: pop
    //   1273: aload 13
    //   1275: iload_3
    //   1276: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1279: pop
    //   1280: aload 13
    //   1282: ldc_w 458
    //   1285: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: pop
    //   1289: aload 13
    //   1291: iload_1
    //   1292: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1295: pop
    //   1296: aload 13
    //   1298: ldc_w 460
    //   1301: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1304: pop
    //   1305: aload 13
    //   1307: aload_0
    //   1308: getfield 162	com/tencent/mobileqq/msf/core/net/c/f:E	J
    //   1311: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1314: pop
    //   1315: aload 13
    //   1317: ldc_w 462
    //   1320: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: pop
    //   1324: aload 13
    //   1326: aload_0
    //   1327: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1330: getfield 430	com/tencent/msf/service/protocol/push/a/d:t	Ljava/lang/String;
    //   1333: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: pop
    //   1337: ldc 255
    //   1339: iconst_1
    //   1340: aload 13
    //   1342: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1345: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1348: aload 14
    //   1350: astore 15
    //   1352: aload 12
    //   1354: invokevirtual 370	java/io/InputStream:close	()V
    //   1357: goto +3358 -> 4715
    //   1360: astore_2
    //   1361: aload 14
    //   1363: astore 15
    //   1365: aload_2
    //   1366: invokevirtual 373	java/lang/Throwable:printStackTrace	()V
    //   1369: aload 14
    //   1371: astore 15
    //   1373: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1376: ifeq +3339 -> 4715
    //   1379: aload 14
    //   1381: astore 15
    //   1383: ldc 255
    //   1385: iconst_4
    //   1386: ldc_w 375
    //   1389: aload_2
    //   1390: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1393: goto +3322 -> 4715
    //   1396: astore 12
    //   1398: goto +20 -> 1418
    //   1401: astore 12
    //   1403: goto +20 -> 1423
    //   1406: astore 12
    //   1408: goto +10 -> 1418
    //   1411: astore 12
    //   1413: goto +10 -> 1423
    //   1416: astore 12
    //   1418: goto +43 -> 1461
    //   1421: astore 12
    //   1423: aload_2
    //   1424: astore 13
    //   1426: aload 12
    //   1428: astore_2
    //   1429: aload 13
    //   1431: astore 12
    //   1433: goto +40 -> 1473
    //   1436: astore 12
    //   1438: goto +23 -> 1461
    //   1441: astore 13
    //   1443: aload_2
    //   1444: astore 12
    //   1446: aload 13
    //   1448: astore_2
    //   1449: goto +24 -> 1473
    //   1452: astore 13
    //   1454: aload 12
    //   1456: astore_2
    //   1457: aload 13
    //   1459: astore 12
    //   1461: aload 12
    //   1463: astore 13
    //   1465: goto +172 -> 1637
    //   1468: astore_2
    //   1469: aload 13
    //   1471: astore 12
    //   1473: aload_2
    //   1474: astore 13
    //   1476: aload 12
    //   1478: astore_2
    //   1479: aload_2
    //   1480: ifnull +17 -> 1497
    //   1483: aload_2
    //   1484: astore 12
    //   1486: getstatic 343	com/tencent/mobileqq/msf/core/net/c/k:f	Ljava/util/ArrayList;
    //   1489: aload_2
    //   1490: invokevirtual 344	java/lang/Object:toString	()Ljava/lang/String;
    //   1493: invokevirtual 363	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   1496: pop
    //   1497: aload_2
    //   1498: astore 12
    //   1500: aload_0
    //   1501: aload 13
    //   1503: invokevirtual 463	java/lang/Exception:toString	()Ljava/lang/String;
    //   1506: invokevirtual 466	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1509: invokespecial 468	com/tencent/mobileqq/msf/core/net/c/f:a	(Ljava/lang/String;)V
    //   1512: aload_2
    //   1513: astore 12
    //   1515: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1518: ifeq +17 -> 1535
    //   1521: aload_2
    //   1522: astore 12
    //   1524: ldc 255
    //   1526: iconst_4
    //   1527: ldc_w 470
    //   1530: aload 13
    //   1532: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1535: aload_2
    //   1536: astore 12
    //   1538: aload_0
    //   1539: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1542: astore 15
    //   1544: aload_2
    //   1545: astore 12
    //   1547: aload 15
    //   1549: aload 15
    //   1551: getfield 472	com/tencent/mobileqq/msf/core/net/c/f$e:n	I
    //   1554: iconst_1
    //   1555: iadd
    //   1556: putfield 472	com/tencent/mobileqq/msf/core/net/c/f$e:n	I
    //   1559: aload_2
    //   1560: astore 12
    //   1562: aload_0
    //   1563: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1566: getfield 384	com/tencent/mobileqq/msf/core/net/c/f$e:J	Ljava/util/ArrayList;
    //   1569: ldc2_w 473
    //   1572: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1575: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1578: pop
    //   1579: aload_2
    //   1580: astore 12
    //   1582: aload 13
    //   1584: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   1587: aload_2
    //   1588: ifnull +47 -> 1635
    //   1591: aload 14
    //   1593: astore 15
    //   1595: aload_2
    //   1596: invokevirtual 370	java/io/InputStream:close	()V
    //   1599: goto +36 -> 1635
    //   1602: astore_2
    //   1603: aload 14
    //   1605: astore 15
    //   1607: aload_2
    //   1608: invokevirtual 373	java/lang/Throwable:printStackTrace	()V
    //   1611: aload 14
    //   1613: astore 15
    //   1615: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1618: ifeq +17 -> 1635
    //   1621: aload 14
    //   1623: astore 15
    //   1625: ldc 255
    //   1627: iconst_4
    //   1628: ldc_w 375
    //   1631: aload_2
    //   1632: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1635: iconst_0
    //   1636: ireturn
    //   1637: aload_2
    //   1638: ifnull +47 -> 1685
    //   1641: aload 14
    //   1643: astore 15
    //   1645: aload_2
    //   1646: invokevirtual 370	java/io/InputStream:close	()V
    //   1649: goto +36 -> 1685
    //   1652: astore_2
    //   1653: aload 14
    //   1655: astore 15
    //   1657: aload_2
    //   1658: invokevirtual 373	java/lang/Throwable:printStackTrace	()V
    //   1661: aload 14
    //   1663: astore 15
    //   1665: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1668: ifeq +17 -> 1685
    //   1671: aload 14
    //   1673: astore 15
    //   1675: ldc 255
    //   1677: iconst_4
    //   1678: ldc_w 375
    //   1681: aload_2
    //   1682: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1685: aload 14
    //   1687: astore 15
    //   1689: aload 13
    //   1691: athrow
    //   1692: aload_0
    //   1693: getfield 108	com/tencent/mobileqq/msf/core/net/c/f:h	Ljava/net/Socket;
    //   1696: invokevirtual 478	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   1699: astore 13
    //   1701: aload 14
    //   1703: astore 16
    //   1705: aload 14
    //   1707: astore 17
    //   1709: getstatic 343	com/tencent/mobileqq/msf/core/net/c/k:f	Ljava/util/ArrayList;
    //   1712: aload 13
    //   1714: invokevirtual 344	java/lang/Object:toString	()Ljava/lang/String;
    //   1717: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1720: pop
    //   1721: aload 14
    //   1723: astore 16
    //   1725: aload 14
    //   1727: astore 17
    //   1729: iload_1
    //   1730: newarray byte
    //   1732: astore 15
    //   1734: aload 14
    //   1736: astore 16
    //   1738: aload 14
    //   1740: astore 17
    //   1742: aload 13
    //   1744: aload 15
    //   1746: invokevirtual 355	java/io/InputStream:read	([B)I
    //   1749: istore_3
    //   1750: aload 14
    //   1752: astore 16
    //   1754: aload 14
    //   1756: astore 17
    //   1758: aload_0
    //   1759: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   1762: putfield 146	com/tencent/mobileqq/msf/core/net/c/f:w	J
    //   1765: aload 14
    //   1767: astore 16
    //   1769: aload 14
    //   1771: astore 17
    //   1773: aload_0
    //   1774: getfield 154	com/tencent/mobileqq/msf/core/net/c/f:A	J
    //   1777: lstore 8
    //   1779: aload 14
    //   1781: astore 16
    //   1783: aload 14
    //   1785: astore 17
    //   1787: aload_0
    //   1788: getfield 146	com/tencent/mobileqq/msf/core/net/c/f:w	J
    //   1791: lstore 10
    //   1793: ldc 255
    //   1795: astore 12
    //   1797: aload 12
    //   1799: astore 16
    //   1801: aload 12
    //   1803: astore 17
    //   1805: aload_0
    //   1806: lload 8
    //   1808: lload 10
    //   1810: aload_0
    //   1811: getfield 144	com/tencent/mobileqq/msf/core/net/c/f:v	J
    //   1814: lsub
    //   1815: ladd
    //   1816: putfield 154	com/tencent/mobileqq/msf/core/net/c/f:A	J
    //   1819: aload 12
    //   1821: astore 16
    //   1823: aload 12
    //   1825: astore 17
    //   1827: new 241	java/lang/StringBuilder
    //   1830: dup
    //   1831: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1834: astore 14
    //   1836: aload 12
    //   1838: astore 16
    //   1840: aload 12
    //   1842: astore 17
    //   1844: aload 14
    //   1846: ldc_w 480
    //   1849: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1852: pop
    //   1853: aload 12
    //   1855: astore 16
    //   1857: aload 12
    //   1859: astore 17
    //   1861: aload 14
    //   1863: aload_2
    //   1864: arraylength
    //   1865: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1868: pop
    //   1869: aload 12
    //   1871: astore 16
    //   1873: aload 12
    //   1875: astore 17
    //   1877: aload 14
    //   1879: ldc_w 482
    //   1882: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1885: pop
    //   1886: aload 12
    //   1888: astore 16
    //   1890: aload 12
    //   1892: astore 17
    //   1894: aload 14
    //   1896: aload_0
    //   1897: getfield 146	com/tencent/mobileqq/msf/core/net/c/f:w	J
    //   1900: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1903: pop
    //   1904: aload 12
    //   1906: astore 16
    //   1908: aload 12
    //   1910: astore 17
    //   1912: aload 14
    //   1914: ldc_w 484
    //   1917: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1920: pop
    //   1921: aload 12
    //   1923: astore 16
    //   1925: aload 12
    //   1927: astore 17
    //   1929: aload 14
    //   1931: aload_0
    //   1932: getfield 144	com/tencent/mobileqq/msf/core/net/c/f:v	J
    //   1935: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1938: pop
    //   1939: aload 12
    //   1941: astore 16
    //   1943: aload 12
    //   1945: astore 17
    //   1947: aload 14
    //   1949: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1952: astore 14
    //   1954: aload 12
    //   1956: iconst_1
    //   1957: aload 14
    //   1959: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1962: aload_0
    //   1963: getfield 146	com/tencent/mobileqq/msf/core/net/c/f:w	J
    //   1966: lstore 8
    //   1968: aload_0
    //   1969: lload 8
    //   1971: putfield 148	com/tencent/mobileqq/msf/core/net/c/f:x	J
    //   1974: aload_0
    //   1975: lload 8
    //   1977: putfield 150	com/tencent/mobileqq/msf/core/net/c/f:y	J
    //   1980: iload_3
    //   1981: iconst_m1
    //   1982: if_icmpeq +2718 -> 4700
    //   1985: iload_3
    //   1986: istore 4
    //   1988: aload 15
    //   1990: astore 14
    //   1992: iload_3
    //   1993: iload_1
    //   1994: if_icmpge +2699 -> 4693
    //   1997: aload 14
    //   1999: astore 16
    //   2001: aload 13
    //   2003: aload 16
    //   2005: iload_3
    //   2006: iload_1
    //   2007: iload_3
    //   2008: isub
    //   2009: invokevirtual 487	java/io/InputStream:read	([BII)I
    //   2012: istore 4
    //   2014: iconst_m1
    //   2015: iload 4
    //   2017: if_icmpne +6 -> 2023
    //   2020: goto +2673 -> 4693
    //   2023: iload_3
    //   2024: iload 4
    //   2026: iadd
    //   2027: istore_3
    //   2028: aload 12
    //   2030: astore 14
    //   2032: aload 12
    //   2034: astore 15
    //   2036: aload_0
    //   2037: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   2040: putfield 150	com/tencent/mobileqq/msf/core/net/c/f:y	J
    //   2043: aload 16
    //   2045: astore 14
    //   2047: goto -55 -> 1992
    //   2050: iconst_m1
    //   2051: iload 4
    //   2053: if_icmpne +262 -> 2315
    //   2056: aload 13
    //   2058: ifnull +23 -> 2081
    //   2061: aload 12
    //   2063: astore 14
    //   2065: aload 12
    //   2067: astore 15
    //   2069: getstatic 343	com/tencent/mobileqq/msf/core/net/c/k:f	Ljava/util/ArrayList;
    //   2072: aload 13
    //   2074: invokevirtual 344	java/lang/Object:toString	()Ljava/lang/String;
    //   2077: invokevirtual 363	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   2080: pop
    //   2081: aload 12
    //   2083: astore 14
    //   2085: aload 12
    //   2087: astore 15
    //   2089: aload_0
    //   2090: getstatic 227	com/tencent/mobileqq/msf/core/net/c/f$e$a:e	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   2093: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/f:a	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;)V
    //   2096: aload 12
    //   2098: astore 14
    //   2100: aload 12
    //   2102: astore 15
    //   2104: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2107: ifeq +2605 -> 4712
    //   2110: aload 12
    //   2112: astore 14
    //   2114: aload 12
    //   2116: astore 15
    //   2118: new 241	java/lang/StringBuilder
    //   2121: dup
    //   2122: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   2125: astore_2
    //   2126: aload 12
    //   2128: astore 14
    //   2130: aload 12
    //   2132: astore 15
    //   2134: aload_2
    //   2135: ldc_w 489
    //   2138: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2141: pop
    //   2142: aload 12
    //   2144: astore 14
    //   2146: aload 12
    //   2148: astore 15
    //   2150: aload_2
    //   2151: iload_3
    //   2152: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2155: pop
    //   2156: aload 12
    //   2158: astore 14
    //   2160: aload 12
    //   2162: astore 15
    //   2164: aload_2
    //   2165: ldc_w 327
    //   2168: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2171: pop
    //   2172: aload 12
    //   2174: astore 14
    //   2176: aload 12
    //   2178: astore 15
    //   2180: aload_2
    //   2181: iload_1
    //   2182: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2185: pop
    //   2186: aload 12
    //   2188: astore 14
    //   2190: aload 12
    //   2192: astore 15
    //   2194: aload_2
    //   2195: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2198: astore_2
    //   2199: aload 12
    //   2201: iconst_4
    //   2202: aload_2
    //   2203: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2206: goto +3 -> 2209
    //   2209: aload 12
    //   2211: astore_2
    //   2212: aload_0
    //   2213: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   2216: getfield 384	com/tencent/mobileqq/msf/core/net/c/f$e:J	Ljava/util/ArrayList;
    //   2219: ldc2_w 473
    //   2222: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2225: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2228: pop
    //   2229: aload 13
    //   2231: ifnull +46 -> 2277
    //   2234: aload_2
    //   2235: astore 15
    //   2237: aload 13
    //   2239: invokevirtual 370	java/io/InputStream:close	()V
    //   2242: goto +35 -> 2277
    //   2245: astore 12
    //   2247: aload_2
    //   2248: astore 15
    //   2250: aload 12
    //   2252: invokevirtual 373	java/lang/Throwable:printStackTrace	()V
    //   2255: aload_2
    //   2256: astore 15
    //   2258: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2261: ifeq +16 -> 2277
    //   2264: aload_2
    //   2265: astore 15
    //   2267: aload_2
    //   2268: iconst_4
    //   2269: ldc_w 375
    //   2272: aload 12
    //   2274: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2277: iconst_0
    //   2278: ireturn
    //   2279: astore 14
    //   2281: aload 12
    //   2283: astore_2
    //   2284: goto +1199 -> 3483
    //   2287: astore_2
    //   2288: aload 13
    //   2290: astore 14
    //   2292: aload 12
    //   2294: astore 13
    //   2296: goto +1040 -> 3336
    //   2299: astore_2
    //   2300: aload 14
    //   2302: astore 12
    //   2304: goto +1006 -> 3310
    //   2307: astore_2
    //   2308: aload 15
    //   2310: astore 12
    //   2312: goto +1016 -> 3328
    //   2315: aload 12
    //   2317: astore 14
    //   2319: aload 14
    //   2321: astore 16
    //   2323: aload 14
    //   2325: astore 17
    //   2327: getstatic 343	com/tencent/mobileqq/msf/core/net/c/k:f	Ljava/util/ArrayList;
    //   2330: aload 13
    //   2332: invokevirtual 344	java/lang/Object:toString	()Ljava/lang/String;
    //   2335: invokevirtual 363	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   2338: pop
    //   2339: aload 14
    //   2341: astore 16
    //   2343: aload 14
    //   2345: astore 17
    //   2347: aload_0
    //   2348: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   2351: astore 18
    //   2353: aload 14
    //   2355: astore 16
    //   2357: aload 14
    //   2359: astore 17
    //   2361: aload 18
    //   2363: aload_0
    //   2364: getfield 144	com/tencent/mobileqq/msf/core/net/c/f:v	J
    //   2367: putfield 380	com/tencent/mobileqq/msf/core/net/c/f$e:M	J
    //   2370: aload 14
    //   2372: astore 16
    //   2374: aload 14
    //   2376: astore 17
    //   2378: aload_0
    //   2379: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   2382: aload_0
    //   2383: getfield 150	com/tencent/mobileqq/msf/core/net/c/f:y	J
    //   2386: putfield 382	com/tencent/mobileqq/msf/core/net/c/f$e:N	J
    //   2389: aload 14
    //   2391: astore 16
    //   2393: aload 14
    //   2395: astore 17
    //   2397: aload_0
    //   2398: aload_0
    //   2399: getfield 150	com/tencent/mobileqq/msf/core/net/c/f:y	J
    //   2402: aload_0
    //   2403: getfield 144	com/tencent/mobileqq/msf/core/net/c/f:v	J
    //   2406: lsub
    //   2407: putfield 162	com/tencent/mobileqq/msf/core/net/c/f:E	J
    //   2410: aload 14
    //   2412: astore 16
    //   2414: aload 14
    //   2416: astore 17
    //   2418: aload_0
    //   2419: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   2422: getfield 384	com/tencent/mobileqq/msf/core/net/c/f$e:J	Ljava/util/ArrayList;
    //   2425: aload_0
    //   2426: getfield 162	com/tencent/mobileqq/msf/core/net/c/f:E	J
    //   2429: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2432: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2435: pop
    //   2436: aload 14
    //   2438: astore 16
    //   2440: aload 14
    //   2442: astore 17
    //   2444: aload_0
    //   2445: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   2448: astore 18
    //   2450: aload 14
    //   2452: astore 16
    //   2454: aload 14
    //   2456: astore 17
    //   2458: aload 18
    //   2460: getfield 391	com/tencent/mobileqq/msf/core/net/c/f$e:k	I
    //   2463: istore 4
    //   2465: iload 4
    //   2467: i2l
    //   2468: lstore 8
    //   2470: aload 18
    //   2472: lload 8
    //   2474: aload_0
    //   2475: getfield 162	com/tencent/mobileqq/msf/core/net/c/f:E	J
    //   2478: ladd
    //   2479: l2i
    //   2480: putfield 391	com/tencent/mobileqq/msf/core/net/c/f$e:k	I
    //   2483: aload_0
    //   2484: getfield 158	com/tencent/mobileqq/msf/core/net/c/f:C	J
    //   2487: lstore 8
    //   2489: aload_0
    //   2490: getfield 150	com/tencent/mobileqq/msf/core/net/c/f:y	J
    //   2493: lstore 10
    //   2495: aload_0
    //   2496: lload 8
    //   2498: lload 10
    //   2500: aload_0
    //   2501: getfield 148	com/tencent/mobileqq/msf/core/net/c/f:x	J
    //   2504: lsub
    //   2505: ladd
    //   2506: putfield 158	com/tencent/mobileqq/msf/core/net/c/f:C	J
    //   2509: aload_0
    //   2510: aload_0
    //   2511: getfield 160	com/tencent/mobileqq/msf/core/net/c/f:D	J
    //   2514: iload_1
    //   2515: i2l
    //   2516: ladd
    //   2517: putfield 160	com/tencent/mobileqq/msf/core/net/c/f:D	J
    //   2520: aload_0
    //   2521: aload_0
    //   2522: getfield 365	com/tencent/mobileqq/msf/core/net/c/f:U	I
    //   2525: iload_1
    //   2526: iadd
    //   2527: putfield 365	com/tencent/mobileqq/msf/core/net/c/f:U	I
    //   2530: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2533: istore 7
    //   2535: iload 7
    //   2537: ifeq +130 -> 2667
    //   2540: new 241	java/lang/StringBuilder
    //   2543: dup
    //   2544: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   2547: astore 16
    //   2549: aload 16
    //   2551: ldc_w 491
    //   2554: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2557: pop
    //   2558: aload 16
    //   2560: iload_3
    //   2561: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2564: pop
    //   2565: aload 16
    //   2567: ldc_w 493
    //   2570: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2573: pop
    //   2574: aload 16
    //   2576: aload_0
    //   2577: getfield 162	com/tencent/mobileqq/msf/core/net/c/f:E	J
    //   2580: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2583: pop
    //   2584: aload 16
    //   2586: ldc_w 398
    //   2589: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2592: pop
    //   2593: aload 16
    //   2595: aload_0
    //   2596: getfield 158	com/tencent/mobileqq/msf/core/net/c/f:C	J
    //   2599: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2602: pop
    //   2603: aload 16
    //   2605: ldc_w 400
    //   2608: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2611: pop
    //   2612: aload 16
    //   2614: aload_0
    //   2615: getfield 160	com/tencent/mobileqq/msf/core/net/c/f:D	J
    //   2618: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2621: pop
    //   2622: aload 16
    //   2624: ldc_w 402
    //   2627: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2630: pop
    //   2631: aload 16
    //   2633: aload_0
    //   2634: getfield 365	com/tencent/mobileqq/msf/core/net/c/f:U	I
    //   2637: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2640: pop
    //   2641: aload 16
    //   2643: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2646: astore 16
    //   2648: aload 14
    //   2650: iconst_2
    //   2651: aload 16
    //   2653: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2656: goto +11 -> 2667
    //   2659: astore_2
    //   2660: goto +650 -> 3310
    //   2663: astore_2
    //   2664: goto +664 -> 3328
    //   2667: aload 12
    //   2669: astore 14
    //   2671: aload_0
    //   2672: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2675: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   2678: istore_3
    //   2679: iload_3
    //   2680: ifeq +69 -> 2749
    //   2683: iconst_1
    //   2684: aload_0
    //   2685: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2688: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   2691: if_icmpne +6 -> 2697
    //   2694: goto +55 -> 2749
    //   2697: iconst_2
    //   2698: aload_0
    //   2699: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2702: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   2705: if_icmpne +33 -> 2738
    //   2708: aload_0
    //   2709: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   2712: astore_2
    //   2713: aload_2
    //   2714: aload_2
    //   2715: getfield 454	com/tencent/mobileqq/msf/core/net/c/f$e:m	I
    //   2718: iconst_1
    //   2719: iadd
    //   2720: putfield 454	com/tencent/mobileqq/msf/core/net/c/f$e:m	I
    //   2723: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2726: ifeq +12 -> 2738
    //   2729: aload 14
    //   2731: iconst_2
    //   2732: ldc_w 495
    //   2735: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2738: goto +110 -> 2848
    //   2741: astore_2
    //   2742: goto -82 -> 2660
    //   2745: astore_2
    //   2746: goto -82 -> 2664
    //   2749: aload_2
    //   2750: arraylength
    //   2751: bipush 8
    //   2753: isub
    //   2754: newarray byte
    //   2756: astore 16
    //   2758: aload_2
    //   2759: iconst_0
    //   2760: aload 16
    //   2762: iconst_0
    //   2763: aload 16
    //   2765: arraylength
    //   2766: invokestatic 359	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2769: iload_1
    //   2770: bipush 8
    //   2772: isub
    //   2773: newarray byte
    //   2775: astore_2
    //   2776: aload 15
    //   2778: iconst_0
    //   2779: aload_2
    //   2780: iconst_0
    //   2781: aload_2
    //   2782: arraylength
    //   2783: invokestatic 359	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2786: aload 16
    //   2788: invokestatic 501	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   2791: aload_2
    //   2792: invokestatic 501	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   2795: invokevirtual 504	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2798: ifeq +344 -> 3142
    //   2801: new 241	java/lang/StringBuilder
    //   2804: dup
    //   2805: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   2808: astore_2
    //   2809: aload_2
    //   2810: ldc_w 506
    //   2813: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2816: pop
    //   2817: aload_2
    //   2818: iload_1
    //   2819: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2822: pop
    //   2823: aload 14
    //   2825: iconst_1
    //   2826: aload_2
    //   2827: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2830: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2833: aload_0
    //   2834: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   2837: astore_2
    //   2838: aload_2
    //   2839: aload_2
    //   2840: getfield 454	com/tencent/mobileqq/msf/core/net/c/f$e:m	I
    //   2843: iconst_1
    //   2844: iadd
    //   2845: putfield 454	com/tencent/mobileqq/msf/core/net/c/f$e:m	I
    //   2848: aload 15
    //   2850: arraylength
    //   2851: istore_3
    //   2852: iload_3
    //   2853: iconst_4
    //   2854: if_icmplt +235 -> 3089
    //   2857: new 241	java/lang/StringBuilder
    //   2860: dup
    //   2861: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   2864: astore_2
    //   2865: aload_2
    //   2866: ldc_w 508
    //   2869: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2872: pop
    //   2873: aload_2
    //   2874: iload_1
    //   2875: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2878: pop
    //   2879: aload_2
    //   2880: ldc_w 510
    //   2883: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2886: pop
    //   2887: aload_2
    //   2888: aload_0
    //   2889: getfield 162	com/tencent/mobileqq/msf/core/net/c/f:E	J
    //   2892: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2895: pop
    //   2896: aload_2
    //   2897: ldc_w 512
    //   2900: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2903: pop
    //   2904: aload_2
    //   2905: aload 15
    //   2907: arraylength
    //   2908: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2911: pop
    //   2912: aload 14
    //   2914: iconst_1
    //   2915: aload_2
    //   2916: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2919: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2922: aload_0
    //   2923: getfield 118	com/tencent/mobileqq/msf/core/net/c/f:n	Ljava/net/InetAddress;
    //   2926: instanceof 514
    //   2929: ifeq +83 -> 3012
    //   2932: aload 15
    //   2934: arraylength
    //   2935: bipush 20
    //   2937: if_icmplt +152 -> 3089
    //   2940: bipush 16
    //   2942: newarray byte
    //   2944: astore_2
    //   2945: aload 15
    //   2947: aload 15
    //   2949: arraylength
    //   2950: bipush 16
    //   2952: isub
    //   2953: aload_2
    //   2954: iconst_0
    //   2955: bipush 16
    //   2957: invokestatic 359	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2960: aload_2
    //   2961: invokestatic 518	java/net/InetAddress:getByAddress	([B)Ljava/net/InetAddress;
    //   2964: astore_2
    //   2965: new 241	java/lang/StringBuilder
    //   2968: dup
    //   2969: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   2972: astore 15
    //   2974: aload 15
    //   2976: ldc_w 520
    //   2979: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2982: pop
    //   2983: aload 15
    //   2985: aload_2
    //   2986: invokevirtual 523	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2989: pop
    //   2990: aload 14
    //   2992: iconst_1
    //   2993: aload 15
    //   2995: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2998: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3001: aload_0
    //   3002: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3005: aload_2
    //   3006: putfield 451	com/tencent/mobileqq/msf/core/net/c/f$e:d	Ljava/net/InetAddress;
    //   3009: goto +80 -> 3089
    //   3012: aload 15
    //   3014: aload 15
    //   3016: arraylength
    //   3017: iconst_4
    //   3018: isub
    //   3019: invokestatic 528	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   3022: istore_1
    //   3023: iload_1
    //   3024: i2l
    //   3025: invokestatic 531	com/tencent/qphone/base/util/g:a	(J)Ljava/net/InetAddress;
    //   3028: astore_2
    //   3029: new 241	java/lang/StringBuilder
    //   3032: dup
    //   3033: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   3036: astore 15
    //   3038: aload 15
    //   3040: ldc_w 520
    //   3043: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3046: pop
    //   3047: aload 15
    //   3049: aload_2
    //   3050: invokevirtual 523	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3053: pop
    //   3054: aload 15
    //   3056: ldc_w 533
    //   3059: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3062: pop
    //   3063: aload 15
    //   3065: iload_1
    //   3066: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3069: pop
    //   3070: aload 14
    //   3072: iconst_1
    //   3073: aload 15
    //   3075: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3078: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3081: aload_0
    //   3082: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3085: aload_2
    //   3086: putfield 451	com/tencent/mobileqq/msf/core/net/c/f$e:d	Ljava/net/InetAddress;
    //   3089: aload 13
    //   3091: ifnull +1624 -> 4715
    //   3094: aload 14
    //   3096: astore 12
    //   3098: aload 13
    //   3100: invokevirtual 370	java/io/InputStream:close	()V
    //   3103: goto +1612 -> 4715
    //   3106: astore_2
    //   3107: aload 14
    //   3109: astore 12
    //   3111: aload_2
    //   3112: invokevirtual 373	java/lang/Throwable:printStackTrace	()V
    //   3115: aload 14
    //   3117: astore 12
    //   3119: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3122: ifeq +1593 -> 4715
    //   3125: aload 14
    //   3127: astore 12
    //   3129: aload 14
    //   3131: iconst_4
    //   3132: ldc_w 375
    //   3135: aload_2
    //   3136: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3139: goto +1576 -> 4715
    //   3142: aload_0
    //   3143: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3146: getfield 384	com/tencent/mobileqq/msf/core/net/c/f$e:J	Ljava/util/ArrayList;
    //   3149: aload_0
    //   3150: getfield 162	com/tencent/mobileqq/msf/core/net/c/f:E	J
    //   3153: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3156: invokevirtual 363	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   3159: pop
    //   3160: new 241	java/lang/StringBuilder
    //   3163: dup
    //   3164: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   3167: astore 12
    //   3169: aload 12
    //   3171: ldc_w 535
    //   3174: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3177: pop
    //   3178: aload 12
    //   3180: aload_2
    //   3181: invokestatic 501	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   3184: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3187: pop
    //   3188: new 280	java/lang/Exception
    //   3191: dup
    //   3192: aload 12
    //   3194: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3197: invokespecial 537	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   3200: athrow
    //   3201: astore_2
    //   3202: aload 14
    //   3204: astore 12
    //   3206: goto +80 -> 3286
    //   3209: astore_2
    //   3210: aload 14
    //   3212: astore 12
    //   3214: goto +80 -> 3294
    //   3217: astore_2
    //   3218: aload 14
    //   3220: astore 12
    //   3222: goto +64 -> 3286
    //   3225: astore_2
    //   3226: aload 14
    //   3228: astore 12
    //   3230: goto +64 -> 3294
    //   3233: astore_2
    //   3234: goto +28 -> 3262
    //   3237: astore_2
    //   3238: goto +36 -> 3274
    //   3241: astore_2
    //   3242: goto +20 -> 3262
    //   3245: astore_2
    //   3246: goto +28 -> 3274
    //   3249: astore_2
    //   3250: goto +36 -> 3286
    //   3253: astore_2
    //   3254: goto +40 -> 3294
    //   3257: astore_2
    //   3258: aload 16
    //   3260: astore 14
    //   3262: aload 14
    //   3264: astore 12
    //   3266: goto +20 -> 3286
    //   3269: astore_2
    //   3270: aload 17
    //   3272: astore 14
    //   3274: aload 14
    //   3276: astore 12
    //   3278: goto +16 -> 3294
    //   3281: astore_2
    //   3282: aload 16
    //   3284: astore 12
    //   3286: goto +24 -> 3310
    //   3289: astore_2
    //   3290: aload 17
    //   3292: astore 12
    //   3294: goto +34 -> 3328
    //   3297: astore_2
    //   3298: ldc 255
    //   3300: astore 14
    //   3302: aload 12
    //   3304: astore 13
    //   3306: aload 14
    //   3308: astore 12
    //   3310: aload_2
    //   3311: astore 14
    //   3313: aload 12
    //   3315: astore_2
    //   3316: goto +167 -> 3483
    //   3319: astore_2
    //   3320: ldc 255
    //   3322: astore 12
    //   3324: aload 15
    //   3326: astore 13
    //   3328: aload 13
    //   3330: astore 14
    //   3332: aload 12
    //   3334: astore 13
    //   3336: aload 14
    //   3338: ifnull +15 -> 3353
    //   3341: getstatic 343	com/tencent/mobileqq/msf/core/net/c/k:f	Ljava/util/ArrayList;
    //   3344: aload 14
    //   3346: invokevirtual 344	java/lang/Object:toString	()Ljava/lang/String;
    //   3349: invokevirtual 363	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   3352: pop
    //   3353: aload_0
    //   3354: aload_2
    //   3355: invokevirtual 463	java/lang/Exception:toString	()Ljava/lang/String;
    //   3358: invokevirtual 466	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   3361: invokespecial 468	com/tencent/mobileqq/msf/core/net/c/f:a	(Ljava/lang/String;)V
    //   3364: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3367: ifeq +13 -> 3380
    //   3370: aload 13
    //   3372: iconst_4
    //   3373: ldc_w 539
    //   3376: aload_2
    //   3377: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3380: aload_0
    //   3381: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3384: astore 12
    //   3386: aload 12
    //   3388: aload 12
    //   3390: getfield 472	com/tencent/mobileqq/msf/core/net/c/f$e:n	I
    //   3393: iconst_1
    //   3394: iadd
    //   3395: putfield 472	com/tencent/mobileqq/msf/core/net/c/f$e:n	I
    //   3398: aload_0
    //   3399: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3402: getfield 384	com/tencent/mobileqq/msf/core/net/c/f$e:J	Ljava/util/ArrayList;
    //   3405: ldc2_w 473
    //   3408: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3411: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3414: pop
    //   3415: aload_2
    //   3416: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   3419: aload 14
    //   3421: ifnull +48 -> 3469
    //   3424: aload 13
    //   3426: astore 12
    //   3428: aload 14
    //   3430: invokevirtual 370	java/io/InputStream:close	()V
    //   3433: goto +36 -> 3469
    //   3436: astore_2
    //   3437: aload 13
    //   3439: astore 12
    //   3441: aload_2
    //   3442: invokevirtual 373	java/lang/Throwable:printStackTrace	()V
    //   3445: aload 13
    //   3447: astore 12
    //   3449: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3452: ifeq +17 -> 3469
    //   3455: aload 13
    //   3457: astore 12
    //   3459: aload 13
    //   3461: iconst_4
    //   3462: ldc_w 375
    //   3465: aload_2
    //   3466: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3469: iconst_0
    //   3470: ireturn
    //   3471: astore_2
    //   3472: aload 13
    //   3474: astore 12
    //   3476: aload 14
    //   3478: astore 13
    //   3480: goto -170 -> 3310
    //   3483: aload 13
    //   3485: ifnull +46 -> 3531
    //   3488: aload_2
    //   3489: astore 12
    //   3491: aload 13
    //   3493: invokevirtual 370	java/io/InputStream:close	()V
    //   3496: goto +35 -> 3531
    //   3499: astore 13
    //   3501: aload_2
    //   3502: astore 12
    //   3504: aload 13
    //   3506: invokevirtual 373	java/lang/Throwable:printStackTrace	()V
    //   3509: aload_2
    //   3510: astore 12
    //   3512: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3515: ifeq +16 -> 3531
    //   3518: aload_2
    //   3519: astore 12
    //   3521: aload_2
    //   3522: iconst_4
    //   3523: ldc_w 375
    //   3526: aload 13
    //   3528: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3531: aload_2
    //   3532: astore 12
    //   3534: aload 14
    //   3536: athrow
    //   3537: ldc 255
    //   3539: astore 13
    //   3541: aload 13
    //   3543: astore 12
    //   3545: iload_1
    //   3546: newarray byte
    //   3548: astore 14
    //   3550: aload 13
    //   3552: astore 12
    //   3554: new 541	java/net/DatagramPacket
    //   3557: dup
    //   3558: aload 14
    //   3560: iload_1
    //   3561: invokespecial 544	java/net/DatagramPacket:<init>	([BI)V
    //   3564: astore 15
    //   3566: aload_0
    //   3567: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   3570: putfield 148	com/tencent/mobileqq/msf/core/net/c/f:x	J
    //   3573: aload_0
    //   3574: getfield 106	com/tencent/mobileqq/msf/core/net/c/f:g	Ljava/net/DatagramSocket;
    //   3577: aload 15
    //   3579: invokevirtual 550	java/net/DatagramSocket:receive	(Ljava/net/DatagramPacket;)V
    //   3582: aload_0
    //   3583: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   3586: putfield 150	com/tencent/mobileqq/msf/core/net/c/f:y	J
    //   3589: aload_0
    //   3590: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3593: aload_0
    //   3594: getfield 144	com/tencent/mobileqq/msf/core/net/c/f:v	J
    //   3597: putfield 380	com/tencent/mobileqq/msf/core/net/c/f$e:M	J
    //   3600: aload_0
    //   3601: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3604: aload_0
    //   3605: getfield 150	com/tencent/mobileqq/msf/core/net/c/f:y	J
    //   3608: putfield 382	com/tencent/mobileqq/msf/core/net/c/f$e:N	J
    //   3611: aload_0
    //   3612: aload_0
    //   3613: getfield 150	com/tencent/mobileqq/msf/core/net/c/f:y	J
    //   3616: aload_0
    //   3617: getfield 144	com/tencent/mobileqq/msf/core/net/c/f:v	J
    //   3620: lsub
    //   3621: putfield 162	com/tencent/mobileqq/msf/core/net/c/f:E	J
    //   3624: aload_0
    //   3625: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3628: getfield 384	com/tencent/mobileqq/msf/core/net/c/f$e:J	Ljava/util/ArrayList;
    //   3631: aload_0
    //   3632: getfield 162	com/tencent/mobileqq/msf/core/net/c/f:E	J
    //   3635: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3638: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3641: pop
    //   3642: aload_0
    //   3643: aload_0
    //   3644: getfield 158	com/tencent/mobileqq/msf/core/net/c/f:C	J
    //   3647: aload_0
    //   3648: getfield 150	com/tencent/mobileqq/msf/core/net/c/f:y	J
    //   3651: aload_0
    //   3652: getfield 148	com/tencent/mobileqq/msf/core/net/c/f:x	J
    //   3655: lsub
    //   3656: ladd
    //   3657: putfield 158	com/tencent/mobileqq/msf/core/net/c/f:C	J
    //   3660: aload_0
    //   3661: aload_0
    //   3662: getfield 160	com/tencent/mobileqq/msf/core/net/c/f:D	J
    //   3665: aload 15
    //   3667: invokevirtual 553	java/net/DatagramPacket:getLength	()I
    //   3670: i2l
    //   3671: ladd
    //   3672: putfield 160	com/tencent/mobileqq/msf/core/net/c/f:D	J
    //   3675: aload_0
    //   3676: aload_0
    //   3677: getfield 365	com/tencent/mobileqq/msf/core/net/c/f:U	I
    //   3680: aload 15
    //   3682: invokevirtual 553	java/net/DatagramPacket:getLength	()I
    //   3685: iadd
    //   3686: putfield 365	com/tencent/mobileqq/msf/core/net/c/f:U	I
    //   3689: aload_0
    //   3690: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3693: astore 12
    //   3695: aload 12
    //   3697: aload 12
    //   3699: getfield 391	com/tencent/mobileqq/msf/core/net/c/f$e:k	I
    //   3702: i2l
    //   3703: aload_0
    //   3704: getfield 162	com/tencent/mobileqq/msf/core/net/c/f:E	J
    //   3707: ladd
    //   3708: l2i
    //   3709: putfield 391	com/tencent/mobileqq/msf/core/net/c/f$e:k	I
    //   3712: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3715: ifeq +119 -> 3834
    //   3718: new 241	java/lang/StringBuilder
    //   3721: dup
    //   3722: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   3725: astore 12
    //   3727: aload 12
    //   3729: ldc_w 555
    //   3732: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3735: pop
    //   3736: aload 12
    //   3738: aload 15
    //   3740: invokevirtual 553	java/net/DatagramPacket:getLength	()I
    //   3743: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3746: pop
    //   3747: aload 12
    //   3749: ldc_w 493
    //   3752: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3755: pop
    //   3756: aload 12
    //   3758: aload_0
    //   3759: getfield 162	com/tencent/mobileqq/msf/core/net/c/f:E	J
    //   3762: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3765: pop
    //   3766: aload 12
    //   3768: ldc_w 398
    //   3771: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3774: pop
    //   3775: aload 12
    //   3777: aload_0
    //   3778: getfield 158	com/tencent/mobileqq/msf/core/net/c/f:C	J
    //   3781: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3784: pop
    //   3785: aload 12
    //   3787: ldc_w 400
    //   3790: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3793: pop
    //   3794: aload 12
    //   3796: aload_0
    //   3797: getfield 160	com/tencent/mobileqq/msf/core/net/c/f:D	J
    //   3800: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3803: pop
    //   3804: aload 12
    //   3806: ldc_w 402
    //   3809: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3812: pop
    //   3813: aload 12
    //   3815: aload_0
    //   3816: getfield 365	com/tencent/mobileqq/msf/core/net/c/f:U	I
    //   3819: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3822: pop
    //   3823: aload 13
    //   3825: iconst_2
    //   3826: aload 12
    //   3828: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3831: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3834: aload_0
    //   3835: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3838: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   3841: ifeq +323 -> 4164
    //   3844: iconst_1
    //   3845: aload_0
    //   3846: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3849: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   3852: if_icmpne +6 -> 3858
    //   3855: goto +309 -> 4164
    //   3858: iconst_2
    //   3859: aload_0
    //   3860: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3863: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   3866: if_icmpne +397 -> 4263
    //   3869: aload 15
    //   3871: invokevirtual 559	java/net/DatagramPacket:getAddress	()Ljava/net/InetAddress;
    //   3874: aload_0
    //   3875: getfield 118	com/tencent/mobileqq/msf/core/net/c/f:n	Ljava/net/InetAddress;
    //   3878: invokevirtual 560	java/net/InetAddress:equals	(Ljava/lang/Object;)Z
    //   3881: istore 7
    //   3883: iload 7
    //   3885: ifeq +153 -> 4038
    //   3888: aload 15
    //   3890: invokevirtual 563	java/net/DatagramPacket:getPort	()I
    //   3893: aload_0
    //   3894: getfield 565	com/tencent/mobileqq/msf/core/net/c/f:o	I
    //   3897: if_icmpeq +6 -> 3903
    //   3900: goto +138 -> 4038
    //   3903: new 241	java/lang/StringBuilder
    //   3906: dup
    //   3907: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   3910: astore_2
    //   3911: aload_2
    //   3912: ldc_w 567
    //   3915: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3918: pop
    //   3919: aload_2
    //   3920: aload_0
    //   3921: getfield 118	com/tencent/mobileqq/msf/core/net/c/f:n	Ljava/net/InetAddress;
    //   3924: invokevirtual 568	java/net/InetAddress:toString	()Ljava/lang/String;
    //   3927: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3930: pop
    //   3931: aload_2
    //   3932: ldc_w 570
    //   3935: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3938: pop
    //   3939: aload_2
    //   3940: aload_0
    //   3941: getfield 565	com/tencent/mobileqq/msf/core/net/c/f:o	I
    //   3944: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3947: pop
    //   3948: aload_2
    //   3949: ldc_w 572
    //   3952: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3955: pop
    //   3956: aload_2
    //   3957: aload 15
    //   3959: invokevirtual 559	java/net/DatagramPacket:getAddress	()Ljava/net/InetAddress;
    //   3962: invokevirtual 568	java/net/InetAddress:toString	()Ljava/lang/String;
    //   3965: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3968: pop
    //   3969: aload_2
    //   3970: ldc_w 570
    //   3973: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3976: pop
    //   3977: aload_2
    //   3978: aload 15
    //   3980: invokevirtual 563	java/net/DatagramPacket:getPort	()I
    //   3983: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3986: pop
    //   3987: aload_2
    //   3988: ldc_w 574
    //   3991: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3994: pop
    //   3995: aload 13
    //   3997: iconst_2
    //   3998: aload_2
    //   3999: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4002: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4005: aload_0
    //   4006: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   4009: astore_2
    //   4010: aload_2
    //   4011: aload_2
    //   4012: getfield 454	com/tencent/mobileqq/msf/core/net/c/f$e:m	I
    //   4015: iconst_1
    //   4016: iadd
    //   4017: putfield 454	com/tencent/mobileqq/msf/core/net/c/f$e:m	I
    //   4020: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4023: ifeq +240 -> 4263
    //   4026: aload 13
    //   4028: iconst_2
    //   4029: ldc_w 576
    //   4032: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4035: goto +228 -> 4263
    //   4038: aload_0
    //   4039: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   4042: astore_2
    //   4043: aload_2
    //   4044: aload_2
    //   4045: getfield 454	com/tencent/mobileqq/msf/core/net/c/f$e:m	I
    //   4048: iconst_1
    //   4049: iadd
    //   4050: putfield 454	com/tencent/mobileqq/msf/core/net/c/f$e:m	I
    //   4053: aload_0
    //   4054: getstatic 578	com/tencent/mobileqq/msf/core/net/c/f$e$a:v	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   4057: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/f:a	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;)V
    //   4060: new 241	java/lang/StringBuilder
    //   4063: dup
    //   4064: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   4067: astore_2
    //   4068: aload_2
    //   4069: ldc_w 580
    //   4072: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4075: pop
    //   4076: aload_2
    //   4077: aload_0
    //   4078: getfield 118	com/tencent/mobileqq/msf/core/net/c/f:n	Ljava/net/InetAddress;
    //   4081: invokevirtual 568	java/net/InetAddress:toString	()Ljava/lang/String;
    //   4084: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4087: pop
    //   4088: aload_2
    //   4089: ldc_w 570
    //   4092: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4095: pop
    //   4096: aload_2
    //   4097: aload_0
    //   4098: getfield 565	com/tencent/mobileqq/msf/core/net/c/f:o	I
    //   4101: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4104: pop
    //   4105: aload_2
    //   4106: ldc_w 572
    //   4109: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4112: pop
    //   4113: aload_2
    //   4114: aload 15
    //   4116: invokevirtual 559	java/net/DatagramPacket:getAddress	()Ljava/net/InetAddress;
    //   4119: invokevirtual 568	java/net/InetAddress:toString	()Ljava/lang/String;
    //   4122: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4125: pop
    //   4126: aload_2
    //   4127: ldc_w 570
    //   4130: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4133: pop
    //   4134: aload_2
    //   4135: aload 15
    //   4137: invokevirtual 563	java/net/DatagramPacket:getPort	()I
    //   4140: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4143: pop
    //   4144: aload_2
    //   4145: ldc_w 574
    //   4148: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4151: pop
    //   4152: aload 13
    //   4154: iconst_2
    //   4155: aload_2
    //   4156: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4159: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4162: iconst_0
    //   4163: ireturn
    //   4164: aload_2
    //   4165: arraylength
    //   4166: bipush 8
    //   4168: isub
    //   4169: newarray byte
    //   4171: astore 12
    //   4173: aload_2
    //   4174: iconst_0
    //   4175: aload 12
    //   4177: iconst_0
    //   4178: aload 12
    //   4180: arraylength
    //   4181: invokestatic 359	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   4184: iload_1
    //   4185: bipush 8
    //   4187: isub
    //   4188: newarray byte
    //   4190: astore_2
    //   4191: aload 14
    //   4193: iconst_0
    //   4194: aload_2
    //   4195: iconst_0
    //   4196: aload_2
    //   4197: arraylength
    //   4198: invokestatic 359	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   4201: aload 12
    //   4203: invokestatic 501	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   4206: aload_2
    //   4207: invokestatic 501	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   4210: invokevirtual 504	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4213: ifeq +282 -> 4495
    //   4216: new 241	java/lang/StringBuilder
    //   4219: dup
    //   4220: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   4223: astore_2
    //   4224: aload_2
    //   4225: ldc_w 582
    //   4228: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4231: pop
    //   4232: aload_2
    //   4233: iload_1
    //   4234: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4237: pop
    //   4238: aload 13
    //   4240: iconst_1
    //   4241: aload_2
    //   4242: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4245: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4248: aload_0
    //   4249: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   4252: astore_2
    //   4253: aload_2
    //   4254: aload_2
    //   4255: getfield 454	com/tencent/mobileqq/msf/core/net/c/f$e:m	I
    //   4258: iconst_1
    //   4259: iadd
    //   4260: putfield 454	com/tencent/mobileqq/msf/core/net/c/f$e:m	I
    //   4263: aload 14
    //   4265: arraylength
    //   4266: iconst_4
    //   4267: if_icmplt +448 -> 4715
    //   4270: aload 14
    //   4272: iconst_0
    //   4273: invokestatic 528	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   4276: istore_1
    //   4277: new 241	java/lang/StringBuilder
    //   4280: dup
    //   4281: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   4284: astore_2
    //   4285: aload_2
    //   4286: ldc_w 584
    //   4289: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4292: pop
    //   4293: aload_2
    //   4294: iload_1
    //   4295: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4298: pop
    //   4299: aload_2
    //   4300: ldc_w 512
    //   4303: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4306: pop
    //   4307: aload_2
    //   4308: aload 14
    //   4310: arraylength
    //   4311: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4314: pop
    //   4315: aload 13
    //   4317: iconst_1
    //   4318: aload_2
    //   4319: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4322: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4325: aload_0
    //   4326: getfield 118	com/tencent/mobileqq/msf/core/net/c/f:n	Ljava/net/InetAddress;
    //   4329: instanceof 514
    //   4332: ifeq +83 -> 4415
    //   4335: aload 14
    //   4337: arraylength
    //   4338: bipush 20
    //   4340: if_icmplt +375 -> 4715
    //   4343: bipush 16
    //   4345: newarray byte
    //   4347: astore_2
    //   4348: aload 14
    //   4350: aload 14
    //   4352: arraylength
    //   4353: bipush 16
    //   4355: isub
    //   4356: aload_2
    //   4357: iconst_0
    //   4358: bipush 16
    //   4360: invokestatic 359	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   4363: aload_2
    //   4364: invokestatic 518	java/net/InetAddress:getByAddress	([B)Ljava/net/InetAddress;
    //   4367: astore_2
    //   4368: new 241	java/lang/StringBuilder
    //   4371: dup
    //   4372: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   4375: astore 12
    //   4377: aload 12
    //   4379: ldc_w 586
    //   4382: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4385: pop
    //   4386: aload 12
    //   4388: aload_2
    //   4389: invokevirtual 523	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4392: pop
    //   4393: aload 13
    //   4395: iconst_1
    //   4396: aload 12
    //   4398: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4401: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4404: aload_0
    //   4405: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   4408: aload_2
    //   4409: putfield 451	com/tencent/mobileqq/msf/core/net/c/f$e:d	Ljava/net/InetAddress;
    //   4412: goto +303 -> 4715
    //   4415: aload 14
    //   4417: aload 14
    //   4419: arraylength
    //   4420: iconst_4
    //   4421: isub
    //   4422: invokestatic 528	com/tencent/mobileqq/msf/core/c:a	([BI)I
    //   4425: istore_1
    //   4426: iload_1
    //   4427: i2l
    //   4428: invokestatic 531	com/tencent/qphone/base/util/g:a	(J)Ljava/net/InetAddress;
    //   4431: astore_2
    //   4432: new 241	java/lang/StringBuilder
    //   4435: dup
    //   4436: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   4439: astore 12
    //   4441: aload 12
    //   4443: ldc_w 586
    //   4446: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4449: pop
    //   4450: aload 12
    //   4452: aload_2
    //   4453: invokevirtual 523	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4456: pop
    //   4457: aload 12
    //   4459: ldc_w 533
    //   4462: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4465: pop
    //   4466: aload 12
    //   4468: iload_1
    //   4469: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4472: pop
    //   4473: aload 13
    //   4475: iconst_1
    //   4476: aload 12
    //   4478: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4481: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4484: aload_0
    //   4485: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   4488: aload_2
    //   4489: putfield 451	com/tencent/mobileqq/msf/core/net/c/f$e:d	Ljava/net/InetAddress;
    //   4492: goto +223 -> 4715
    //   4495: aload_0
    //   4496: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   4499: getfield 384	com/tencent/mobileqq/msf/core/net/c/f$e:J	Ljava/util/ArrayList;
    //   4502: aload_0
    //   4503: getfield 162	com/tencent/mobileqq/msf/core/net/c/f:E	J
    //   4506: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4509: invokevirtual 363	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   4512: pop
    //   4513: new 241	java/lang/StringBuilder
    //   4516: dup
    //   4517: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   4520: astore 12
    //   4522: aload 12
    //   4524: ldc_w 535
    //   4527: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4530: pop
    //   4531: aload 12
    //   4533: aload_2
    //   4534: invokestatic 501	com/tencent/qphone/base/util/MD5:toMD5	([B)Ljava/lang/String;
    //   4537: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4540: pop
    //   4541: new 280	java/lang/Exception
    //   4544: dup
    //   4545: aload 12
    //   4547: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4550: invokespecial 537	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4553: athrow
    //   4554: astore_2
    //   4555: aload 13
    //   4557: astore 12
    //   4559: aload_0
    //   4560: aload_2
    //   4561: invokevirtual 463	java/lang/Exception:toString	()Ljava/lang/String;
    //   4564: invokevirtual 466	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   4567: invokespecial 468	com/tencent/mobileqq/msf/core/net/c/f:a	(Ljava/lang/String;)V
    //   4570: aload 13
    //   4572: astore 12
    //   4574: aload 13
    //   4576: iconst_1
    //   4577: ldc_w 588
    //   4580: aload_2
    //   4581: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4584: aload 13
    //   4586: astore 12
    //   4588: aload_0
    //   4589: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   4592: astore_2
    //   4593: aload 13
    //   4595: astore 12
    //   4597: aload_2
    //   4598: aload_2
    //   4599: getfield 472	com/tencent/mobileqq/msf/core/net/c/f$e:n	I
    //   4602: iconst_1
    //   4603: iadd
    //   4604: putfield 472	com/tencent/mobileqq/msf/core/net/c/f$e:n	I
    //   4607: aload 13
    //   4609: astore 12
    //   4611: aload_0
    //   4612: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   4615: getfield 384	com/tencent/mobileqq/msf/core/net/c/f$e:J	Ljava/util/ArrayList;
    //   4618: ldc2_w 473
    //   4621: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4624: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4627: pop
    //   4628: iconst_0
    //   4629: ireturn
    //   4630: aload 15
    //   4632: astore 12
    //   4634: aload_0
    //   4635: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   4638: astore_2
    //   4639: aload_2
    //   4640: aload_2
    //   4641: getfield 472	com/tencent/mobileqq/msf/core/net/c/f$e:n	I
    //   4644: iconst_1
    //   4645: iadd
    //   4646: putfield 472	com/tencent/mobileqq/msf/core/net/c/f$e:n	I
    //   4649: aload_0
    //   4650: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   4653: getfield 384	com/tencent/mobileqq/msf/core/net/c/f$e:J	Ljava/util/ArrayList;
    //   4656: ldc2_w 473
    //   4659: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4662: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4665: pop
    //   4666: aload 12
    //   4668: iconst_1
    //   4669: ldc_w 590
    //   4672: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4675: iconst_0
    //   4676: ireturn
    //   4677: astore_2
    //   4678: goto -48 -> 4630
    //   4681: astore_2
    //   4682: goto -48 -> 4634
    //   4685: astore_2
    //   4686: goto -1376 -> 3310
    //   4689: astore_2
    //   4690: goto -1362 -> 3328
    //   4693: aload 14
    //   4695: astore 15
    //   4697: goto -2647 -> 2050
    //   4700: iconst_0
    //   4701: istore 5
    //   4703: iload_3
    //   4704: istore 4
    //   4706: iload 5
    //   4708: istore_3
    //   4709: goto -2659 -> 2050
    //   4712: goto -2503 -> 2209
    //   4715: iconst_1
    //   4716: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4717	0	this	f
    //   0	4717	1	paramInt	int
    //   0	4717	2	paramArrayOfByte	byte[]
    //   128	4581	3	i1	int
    //   421	4284	4	i2	int
    //   902	3805	5	i3	int
    //   912	97	6	i4	int
    //   3	3881	7	bool	boolean
    //   344	2153	8	l1	long
    //   713	1786	10	l2	long
    //   21	1332	12	localObject1	Object
    //   1396	1	12	localObject2	Object
    //   1401	1	12	localException1	Exception
    //   1406	1	12	localObject3	Object
    //   1411	1	12	localException2	Exception
    //   1416	1	12	localObject4	Object
    //   1421	6	12	localException3	Exception
    //   1431	1	12	localObject5	Object
    //   1436	1	12	localObject6	Object
    //   1444	766	12	localObject7	Object
    //   2245	48	12	localThrowable1	Throwable
    //   2302	2365	12	localObject8	Object
    //   135	340	13	arrayOfByte	byte[]
    //   594	1	13	localObject9	Object
    //   599	1	13	localException4	Exception
    //   862	1	13	localObject10	Object
    //   870	203	13	localException5	Exception
    //   1081	349	13	localObject11	Object
    //   1441	6	13	localException6	Exception
    //   1452	6	13	localObject12	Object
    //   1463	2029	13	localObject13	Object
    //   3499	28	13	localThrowable2	Throwable
    //   3539	1069	13	str	String
    //   7	2182	14	localObject14	Object
    //   2279	1	14	localObject15	Object
    //   2290	2404	14	localObject16	Object
    //   80	4616	15	localObject17	Object
    //   144	3139	16	localObject18	Object
    //   1707	1584	17	localObject19	Object
    //   2351	120	18	locale	f.e
    // Exception table:
    //   from	to	target	type
    //   549	553	556	java/lang/Throwable
    //   415	423	594	finally
    //   435	445	594	finally
    //   456	468	594	finally
    //   471	482	594	finally
    //   487	494	594	finally
    //   501	545	594	finally
    //   415	423	599	java/lang/Exception
    //   435	445	599	java/lang/Exception
    //   456	468	599	java/lang/Exception
    //   471	482	599	java/lang/Exception
    //   487	494	599	java/lang/Exception
    //   501	545	599	java/lang/Exception
    //   763	859	862	finally
    //   894	914	862	finally
    //   931	938	862	finally
    //   955	961	862	finally
    //   968	995	862	finally
    //   998	1027	862	finally
    //   1027	1061	862	finally
    //   1093	1130	862	finally
    //   1149	1157	862	finally
    //   1178	1237	862	finally
    //   763	859	870	java/lang/Exception
    //   894	914	870	java/lang/Exception
    //   931	938	870	java/lang/Exception
    //   955	961	870	java/lang/Exception
    //   968	995	870	java/lang/Exception
    //   998	1027	870	java/lang/Exception
    //   1027	1061	870	java/lang/Exception
    //   1093	1130	870	java/lang/Exception
    //   1149	1157	870	java/lang/Exception
    //   1178	1237	870	java/lang/Exception
    //   1352	1357	1360	java/lang/Throwable
    //   718	758	1396	finally
    //   878	887	1396	finally
    //   1064	1088	1396	finally
    //   1130	1144	1396	finally
    //   1157	1173	1396	finally
    //   1237	1348	1396	finally
    //   718	758	1401	java/lang/Exception
    //   878	887	1401	java/lang/Exception
    //   1064	1088	1401	java/lang/Exception
    //   1130	1144	1401	java/lang/Exception
    //   1157	1173	1401	java/lang/Exception
    //   1237	1348	1401	java/lang/Exception
    //   690	715	1406	finally
    //   690	715	1411	java/lang/Exception
    //   621	685	1416	finally
    //   621	685	1421	java/lang/Exception
    //   385	408	1436	finally
    //   604	621	1436	finally
    //   385	408	1441	java/lang/Exception
    //   604	621	1441	java/lang/Exception
    //   162	176	1452	finally
    //   180	194	1452	finally
    //   198	205	1452	finally
    //   209	222	1452	finally
    //   226	232	1452	finally
    //   236	244	1452	finally
    //   248	256	1452	finally
    //   260	272	1452	finally
    //   276	284	1452	finally
    //   288	294	1452	finally
    //   298	306	1452	finally
    //   310	322	1452	finally
    //   326	336	1452	finally
    //   340	346	1452	finally
    //   350	356	1452	finally
    //   360	366	1452	finally
    //   370	385	1452	finally
    //   1486	1497	1452	finally
    //   1500	1512	1452	finally
    //   1515	1521	1452	finally
    //   1524	1535	1452	finally
    //   1538	1544	1452	finally
    //   1547	1559	1452	finally
    //   1562	1579	1452	finally
    //   1582	1587	1452	finally
    //   162	176	1468	java/lang/Exception
    //   180	194	1468	java/lang/Exception
    //   198	205	1468	java/lang/Exception
    //   209	222	1468	java/lang/Exception
    //   226	232	1468	java/lang/Exception
    //   236	244	1468	java/lang/Exception
    //   248	256	1468	java/lang/Exception
    //   260	272	1468	java/lang/Exception
    //   276	284	1468	java/lang/Exception
    //   288	294	1468	java/lang/Exception
    //   298	306	1468	java/lang/Exception
    //   310	322	1468	java/lang/Exception
    //   326	336	1468	java/lang/Exception
    //   340	346	1468	java/lang/Exception
    //   350	356	1468	java/lang/Exception
    //   360	366	1468	java/lang/Exception
    //   370	385	1468	java/lang/Exception
    //   1595	1599	1602	java/lang/Throwable
    //   1645	1649	1652	java/lang/Throwable
    //   2237	2242	2245	java/lang/Throwable
    //   2199	2206	2279	finally
    //   2212	2229	2279	finally
    //   2199	2206	2287	java/lang/Exception
    //   2212	2229	2287	java/lang/Exception
    //   2036	2043	2299	finally
    //   2069	2081	2299	finally
    //   2089	2096	2299	finally
    //   2104	2110	2299	finally
    //   2118	2126	2299	finally
    //   2134	2142	2299	finally
    //   2150	2156	2299	finally
    //   2164	2172	2299	finally
    //   2180	2186	2299	finally
    //   2194	2199	2299	finally
    //   2036	2043	2307	java/lang/Exception
    //   2069	2081	2307	java/lang/Exception
    //   2089	2096	2307	java/lang/Exception
    //   2104	2110	2307	java/lang/Exception
    //   2118	2126	2307	java/lang/Exception
    //   2134	2142	2307	java/lang/Exception
    //   2150	2156	2307	java/lang/Exception
    //   2164	2172	2307	java/lang/Exception
    //   2180	2186	2307	java/lang/Exception
    //   2194	2199	2307	java/lang/Exception
    //   2540	2648	2659	finally
    //   2540	2648	2663	java/lang/Exception
    //   2648	2656	2741	finally
    //   2683	2694	2741	finally
    //   2697	2738	2741	finally
    //   2857	3009	2741	finally
    //   3012	3089	2741	finally
    //   2648	2656	2745	java/lang/Exception
    //   2683	2694	2745	java/lang/Exception
    //   2697	2738	2745	java/lang/Exception
    //   2857	3009	2745	java/lang/Exception
    //   3012	3089	2745	java/lang/Exception
    //   3098	3103	3106	java/lang/Throwable
    //   3142	3201	3201	finally
    //   3142	3201	3209	java/lang/Exception
    //   2671	2679	3217	finally
    //   2749	2848	3217	finally
    //   2848	2852	3217	finally
    //   2671	2679	3225	java/lang/Exception
    //   2749	2848	3225	java/lang/Exception
    //   2848	2852	3225	java/lang/Exception
    //   2495	2535	3233	finally
    //   2495	2535	3237	java/lang/Exception
    //   2470	2495	3241	finally
    //   2470	2495	3245	java/lang/Exception
    //   1954	1980	3249	finally
    //   1954	1980	3253	java/lang/Exception
    //   1805	1819	3257	finally
    //   1827	1836	3257	finally
    //   1844	1853	3257	finally
    //   1861	1869	3257	finally
    //   1877	1886	3257	finally
    //   1894	1904	3257	finally
    //   1912	1921	3257	finally
    //   1929	1939	3257	finally
    //   1947	1954	3257	finally
    //   2361	2370	3257	finally
    //   2378	2389	3257	finally
    //   2397	2410	3257	finally
    //   2418	2436	3257	finally
    //   2444	2450	3257	finally
    //   2458	2465	3257	finally
    //   1805	1819	3269	java/lang/Exception
    //   1827	1836	3269	java/lang/Exception
    //   1844	1853	3269	java/lang/Exception
    //   1861	1869	3269	java/lang/Exception
    //   1877	1886	3269	java/lang/Exception
    //   1894	1904	3269	java/lang/Exception
    //   1912	1921	3269	java/lang/Exception
    //   1929	1939	3269	java/lang/Exception
    //   1947	1954	3269	java/lang/Exception
    //   2361	2370	3269	java/lang/Exception
    //   2378	2389	3269	java/lang/Exception
    //   2397	2410	3269	java/lang/Exception
    //   2418	2436	3269	java/lang/Exception
    //   2444	2450	3269	java/lang/Exception
    //   2458	2465	3269	java/lang/Exception
    //   1709	1721	3281	finally
    //   1729	1734	3281	finally
    //   1742	1750	3281	finally
    //   1758	1765	3281	finally
    //   1773	1779	3281	finally
    //   1787	1793	3281	finally
    //   2327	2339	3281	finally
    //   2347	2353	3281	finally
    //   1709	1721	3289	java/lang/Exception
    //   1729	1734	3289	java/lang/Exception
    //   1742	1750	3289	java/lang/Exception
    //   1758	1765	3289	java/lang/Exception
    //   1773	1779	3289	java/lang/Exception
    //   1787	1793	3289	java/lang/Exception
    //   2327	2339	3289	java/lang/Exception
    //   2347	2353	3289	java/lang/Exception
    //   1692	1701	3297	finally
    //   1692	1701	3319	java/lang/Exception
    //   3428	3433	3436	java/lang/Throwable
    //   3341	3353	3471	finally
    //   3353	3380	3471	finally
    //   3380	3419	3471	finally
    //   3491	3496	3499	java/lang/Throwable
    //   3566	3834	4554	java/lang/Exception
    //   3834	3855	4554	java/lang/Exception
    //   3858	3883	4554	java/lang/Exception
    //   3888	3900	4554	java/lang/Exception
    //   3903	4035	4554	java/lang/Exception
    //   4038	4162	4554	java/lang/Exception
    //   4164	4263	4554	java/lang/Exception
    //   4263	4412	4554	java/lang/Exception
    //   4415	4492	4554	java/lang/Exception
    //   4495	4554	4554	java/lang/Exception
    //   82	87	4677	java/lang/Exception
    //   91	98	4677	java/lang/Exception
    //   102	111	4677	java/lang/Exception
    //   117	129	4677	java/lang/Exception
    //   549	553	4677	java/lang/Exception
    //   561	565	4677	java/lang/Exception
    //   569	575	4677	java/lang/Exception
    //   579	589	4677	java/lang/Exception
    //   1352	1357	4677	java/lang/Exception
    //   1365	1369	4677	java/lang/Exception
    //   1373	1379	4677	java/lang/Exception
    //   1383	1393	4677	java/lang/Exception
    //   1595	1599	4677	java/lang/Exception
    //   1607	1611	4677	java/lang/Exception
    //   1615	1621	4677	java/lang/Exception
    //   1625	1635	4677	java/lang/Exception
    //   1645	1649	4677	java/lang/Exception
    //   1657	1661	4677	java/lang/Exception
    //   1665	1671	4677	java/lang/Exception
    //   1675	1685	4677	java/lang/Exception
    //   1689	1692	4677	java/lang/Exception
    //   2237	2242	4677	java/lang/Exception
    //   2250	2255	4677	java/lang/Exception
    //   2258	2264	4677	java/lang/Exception
    //   2267	2277	4677	java/lang/Exception
    //   3098	3103	4681	java/lang/Exception
    //   3111	3115	4681	java/lang/Exception
    //   3119	3125	4681	java/lang/Exception
    //   3129	3139	4681	java/lang/Exception
    //   3428	3433	4681	java/lang/Exception
    //   3441	3445	4681	java/lang/Exception
    //   3449	3455	4681	java/lang/Exception
    //   3459	3469	4681	java/lang/Exception
    //   3491	3496	4681	java/lang/Exception
    //   3504	3509	4681	java/lang/Exception
    //   3512	3518	4681	java/lang/Exception
    //   3521	3531	4681	java/lang/Exception
    //   3534	3537	4681	java/lang/Exception
    //   3545	3550	4681	java/lang/Exception
    //   3554	3566	4681	java/lang/Exception
    //   4559	4570	4681	java/lang/Exception
    //   4574	4584	4681	java/lang/Exception
    //   4588	4593	4681	java/lang/Exception
    //   4597	4607	4681	java/lang/Exception
    //   4611	4628	4681	java/lang/Exception
    //   2001	2014	4685	finally
    //   2001	2014	4689	java/lang/Exception
  }
  
  private boolean a(com.tencent.msf.service.protocol.push.a.a parama)
  {
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      this.p.z = ((d)localObject1).i;
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
    label2004:
    label2006:
    label2012:
    label2040:
    label2043:
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
        i1 = h.a[this.a.ordinal()];
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3) {
              return false;
            }
            try
            {
              Object localObject2 = this.n.getHostAddress();
              localObject1 = localObject2;
              if ((this.n instanceof Inet6Address))
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("[");
                ((StringBuilder)localObject1).append((String)localObject2);
                ((StringBuilder)localObject1).append("]");
                localObject1 = ((StringBuilder)localObject1).toString();
              }
              i1 = this.b.y;
              if (i1 == 1)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("https://");
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append(":");
                ((StringBuilder)localObject2).append(this.o);
                ((StringBuilder)localObject2).append("/");
                ((StringBuilder)localObject2).append(this.b.q);
                localObject1 = ((StringBuilder)localObject2).toString();
              }
              else
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("http://");
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append(":");
                ((StringBuilder)localObject2).append(this.o);
                ((StringBuilder)localObject2).append("/");
                ((StringBuilder)localObject2).append(this.b.q);
                localObject1 = ((StringBuilder)localObject2).toString();
              }
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
                  break label2004;
                }
                i1 = 1;
                break label2006;
                i3 += 1;
                if (i3 > 10)
                {
                  QLog.d("MSF.C.QualityTestManager", 4, "Redirect too much!");
                  break label2043;
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
                      break label2040;
                    }
                    this.k.setRequestProperty(((e)localObject2).a, ((e)localObject2).b);
                    if (!QLog.isColorLevel()) {
                      break label2040;
                    }
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append("reqHead.strKey:");
                    localStringBuilder.append(((e)localObject2).a);
                    localStringBuilder.append(",reqHead.strValue:");
                    localStringBuilder.append(((e)localObject2).b);
                    QLog.d("MSF.C.QualityTestManager", 4, localStringBuilder.toString());
                    break label2040;
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
                break label2012;
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
      int i1 = h.a[this.a.ordinal()];
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
            a(f.e.a.d);
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
          a(f.e.a.d);
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
        a(f.e.a.d);
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
      if (this.a != f.b.c) {
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
          int i1 = c.a(arrayOfByte, 0);
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
            b(f.e.a.f, true);
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
  
  private void b(f.e.a parama, boolean paramBoolean)
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
      this.n = com.tencent.qphone.base.util.g.a(parama);
      this.o = com.tencent.qphone.base.util.g.a(i1);
    }
    catch (UnknownHostException localUnknownHostException)
    {
      localUnknownHostException.printStackTrace();
    }
    Object localObject = this.p;
    ((f.e)localObject).e = this.n;
    ((f.e)localObject).f = this.o;
    ((f.e)localObject).C = parama.c;
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
    //   0: new 975	java/io/BufferedReader
    //   3: dup
    //   4: new 977	java/io/FileReader
    //   7: dup
    //   8: ldc_w 979
    //   11: invokespecial 980	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   14: sipush 8192
    //   17: invokespecial 983	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   20: astore_1
    //   21: aload_1
    //   22: astore_0
    //   23: aload_1
    //   24: invokevirtual 986	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: ldc_w 988
    //   30: ldc 120
    //   32: invokevirtual 992	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   35: ldc_w 624
    //   38: invokevirtual 996	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   63: ldc_w 998
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
    //   93: invokevirtual 999	java/io/BufferedReader:close	()V
    //   96: goto +23 -> 119
    //   99: astore_0
    //   100: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   103: ifeq +12 -> 115
    //   106: ldc 255
    //   108: iconst_4
    //   109: ldc_w 1001
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
    //   149: ldc_w 1003
    //   152: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_1
    //   156: astore_0
    //   157: aload_2
    //   158: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   161: aload_1
    //   162: invokevirtual 999	java/io/BufferedReader:close	()V
    //   165: ldc_w 1005
    //   168: areturn
    //   169: astore_0
    //   170: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   173: ifeq +12 -> 185
    //   176: ldc 255
    //   178: iconst_4
    //   179: ldc_w 1001
    //   182: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload_0
    //   186: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   189: ldc_w 1005
    //   192: areturn
    //   193: astore_1
    //   194: aload_0
    //   195: invokevirtual 999	java/io/BufferedReader:close	()V
    //   198: goto +23 -> 221
    //   201: astore_0
    //   202: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   205: ifeq +12 -> 217
    //   208: ldc 255
    //   210: iconst_4
    //   211: ldc_w 1001
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
    //   0: new 975	java/io/BufferedReader
    //   3: dup
    //   4: new 977	java/io/FileReader
    //   7: dup
    //   8: ldc_w 1007
    //   11: invokespecial 980	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   14: sipush 8192
    //   17: invokespecial 983	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: aload_2
    //   24: invokevirtual 986	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: ldc_w 1009
    //   30: invokevirtual 996	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   85: ldc_w 1011
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
    //   108: invokevirtual 999	java/io/BufferedReader:close	()V
    //   111: goto +23 -> 134
    //   114: astore_1
    //   115: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   118: ifeq +12 -> 130
    //   121: ldc 255
    //   123: iconst_4
    //   124: ldc_w 1001
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
    //   149: ldc_w 1013
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
    //   200: ldc_w 1015
    //   203: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_2
    //   207: astore_1
    //   208: aload_3
    //   209: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   212: aload_2
    //   213: invokevirtual 999	java/io/BufferedReader:close	()V
    //   216: ldc_w 1017
    //   219: areturn
    //   220: astore_1
    //   221: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   224: ifeq +12 -> 236
    //   227: ldc 255
    //   229: iconst_4
    //   230: ldc_w 1001
    //   233: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_1
    //   237: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   240: ldc_w 1017
    //   243: areturn
    //   244: astore_2
    //   245: aload_1
    //   246: invokevirtual 999	java/io/BufferedReader:close	()V
    //   249: goto +23 -> 272
    //   252: astore_1
    //   253: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   256: ifeq +12 -> 268
    //   259: ldc 255
    //   261: iconst_4
    //   262: ldc_w 1001
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
    //   0: getstatic 1035	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 21
    //   5: if_icmplt +157 -> 162
    //   8: invokestatic 1041	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: ldc_w 1043
    //   14: invokevirtual 1047	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 1049	android/net/ConnectivityManager
    //   20: astore_1
    //   21: aload_1
    //   22: invokevirtual 1053	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   25: astore_2
    //   26: aload_2
    //   27: invokevirtual 1058	android/net/NetworkInfo:getType	()I
    //   30: pop
    //   31: aload_2
    //   32: invokevirtual 1058	android/net/NetworkInfo:getType	()I
    //   35: ifne +6 -> 41
    //   38: goto +16 -> 54
    //   41: aload_2
    //   42: invokevirtual 1058	android/net/NetworkInfo:getType	()I
    //   45: iconst_1
    //   46: if_icmpne +8 -> 54
    //   49: iconst_1
    //   50: istore_0
    //   51: goto +5 -> 56
    //   54: iconst_0
    //   55: istore_0
    //   56: ldc_w 1049
    //   59: ldc_w 1060
    //   62: iconst_1
    //   63: anewarray 1062	java/lang/Class
    //   66: dup
    //   67: iconst_0
    //   68: getstatic 1066	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   71: aastore
    //   72: invokevirtual 1070	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
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
    //   89: invokevirtual 1076	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 1080	java/lang/Object:getClass	()Ljava/lang/Class;
    //   97: ldc_w 1082
    //   100: invokevirtual 1086	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   103: astore_2
    //   104: aload_2
    //   105: iconst_1
    //   106: invokevirtual 1091	java/lang/reflect/Field:setAccessible	(Z)V
    //   109: aload_2
    //   110: aload_1
    //   111: invokevirtual 1092	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   114: checkcast 346	java/util/ArrayList
    //   117: astore_1
    //   118: aload_1
    //   119: areturn
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 1093	java/lang/NoSuchFieldException:printStackTrace	()V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 1094	java/lang/SecurityException:printStackTrace	()V
    //   132: aconst_null
    //   133: areturn
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 1095	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   139: aconst_null
    //   140: areturn
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 1096	java/lang/IllegalAccessException:printStackTrace	()V
    //   146: aconst_null
    //   147: areturn
    //   148: astore_1
    //   149: aload_1
    //   150: invokevirtual 1097	java/lang/IllegalArgumentException:printStackTrace	()V
    //   153: aconst_null
    //   154: areturn
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 1098	java/lang/NoSuchMethodException:printStackTrace	()V
    //   160: aconst_null
    //   161: areturn
    //   162: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +45 -> 210
    //   168: new 241	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   175: astore_1
    //   176: aload_1
    //   177: ldc_w 1100
    //   180: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_1
    //   185: getstatic 1035	android/os/Build$VERSION:SDK_INT	I
    //   188: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_1
    //   193: ldc_w 1102
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
      f.a locala = new f.a();
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
      int i1 = h.a[this.a.ordinal()];
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
    //   1: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   4: ifnonnull +15 -> 19
    //   7: aload_0
    //   8: getstatic 1147	com/tencent/mobileqq/msf/core/net/c/f$e$a:k	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   11: iconst_1
    //   12: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   15: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   18: return
    //   19: aload_0
    //   20: invokespecial 1149	com/tencent/mobileqq/msf/core/net/c/f:k	()V
    //   23: aload_0
    //   24: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   27: aload_0
    //   28: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   31: getfield 1151	com/tencent/msf/service/protocol/push/a/d:a	S
    //   34: putfield 1153	com/tencent/mobileqq/msf/core/net/c/f$e:r	I
    //   37: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +246 -> 286
    //   43: new 241	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   50: astore 6
    //   52: aload 6
    //   54: ldc_w 1155
    //   57: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 6
    //   63: aload_0
    //   64: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   67: getfield 1151	com/tencent/msf/service/protocol/push/a/d:a	S
    //   70: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 6
    //   76: ldc_w 1157
    //   79: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 6
    //   85: aload_0
    //   86: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   89: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   92: invokevirtual 692	java/util/ArrayList:size	()I
    //   95: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 6
    //   101: ldc_w 1161
    //   104: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 6
    //   110: aload_0
    //   111: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   114: getfield 724	com/tencent/msf/service/protocol/push/a/d:r	S
    //   117: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 6
    //   123: ldc_w 1163
    //   126: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 6
    //   132: aload_0
    //   133: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   136: getfield 430	com/tencent/msf/service/protocol/push/a/d:t	Ljava/lang/String;
    //   139: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 6
    //   145: ldc_w 1165
    //   148: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 6
    //   154: aload_0
    //   155: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   158: getfield 1167	com/tencent/msf/service/protocol/push/a/d:u	Ljava/lang/String;
    //   161: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 6
    //   167: ldc_w 1169
    //   170: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 6
    //   176: aload_0
    //   177: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   180: getfield 404	com/tencent/msf/service/protocol/push/a/d:w	J
    //   183: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 6
    //   189: ldc_w 1171
    //   192: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 6
    //   198: aload_0
    //   199: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   202: getfield 403	com/tencent/msf/service/protocol/push/a/d:x	J
    //   205: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 6
    //   211: ldc_w 1173
    //   214: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 6
    //   220: aload_0
    //   221: getfield 132	com/tencent/mobileqq/msf/core/net/c/f:q	Lcom/tencent/mobileqq/msf/core/net/c/f$d;
    //   224: getfield 1175	com/tencent/mobileqq/msf/core/net/c/f$d:j	Ljava/lang/String;
    //   227: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 6
    //   233: ldc_w 1177
    //   236: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 6
    //   242: aload_0
    //   243: getfield 132	com/tencent/mobileqq/msf/core/net/c/f:q	Lcom/tencent/mobileqq/msf/core/net/c/f$d;
    //   246: getfield 1179	com/tencent/mobileqq/msf/core/net/c/f$d:l	J
    //   249: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 6
    //   255: ldc_w 1181
    //   258: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 6
    //   264: aload_0
    //   265: getfield 132	com/tencent/mobileqq/msf/core/net/c/f:q	Lcom/tencent/mobileqq/msf/core/net/c/f$d;
    //   268: getfield 1183	com/tencent/mobileqq/msf/core/net/c/f$d:m	Ljava/lang/String;
    //   271: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: ldc 255
    //   277: iconst_2
    //   278: aload 6
    //   280: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: aload_0
    //   287: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   290: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   293: invokevirtual 692	java/util/ArrayList:size	()I
    //   296: bipush 10
    //   298: if_icmple +35 -> 333
    //   301: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   304: ifeq +12 -> 316
    //   307: ldc 255
    //   309: iconst_4
    //   310: ldc_w 1185
    //   313: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: aload_0
    //   317: iconst_0
    //   318: putfield 134	com/tencent/mobileqq/msf/core/net/c/f:V	Z
    //   321: aload_0
    //   322: getstatic 1187	com/tencent/mobileqq/msf/core/net/c/f$e$a:m	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   325: iconst_1
    //   326: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   329: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   332: return
    //   333: aload_0
    //   334: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   337: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   340: invokevirtual 692	java/util/ArrayList:size	()I
    //   343: ifgt +35 -> 378
    //   346: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   349: ifeq +12 -> 361
    //   352: ldc 255
    //   354: iconst_4
    //   355: ldc_w 1189
    //   358: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: aload_0
    //   362: iconst_0
    //   363: putfield 134	com/tencent/mobileqq/msf/core/net/c/f:V	Z
    //   366: aload_0
    //   367: getstatic 1191	com/tencent/mobileqq/msf/core/net/c/f$e$a:n	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   370: iconst_1
    //   371: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   374: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   377: return
    //   378: aload_0
    //   379: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   382: getfield 1193	com/tencent/msf/service/protocol/push/a/d:h	J
    //   385: ldc2_w 1194
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
    //   413: ldc_w 1197
    //   416: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload 6
    //   422: aload_0
    //   423: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   426: getfield 1193	com/tencent/msf/service/protocol/push/a/d:h	J
    //   429: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 6
    //   435: ldc_w 1199
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
    //   463: getstatic 1201	com/tencent/mobileqq/msf/core/net/c/f$e$a:j	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   466: iconst_1
    //   467: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   470: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   473: return
    //   474: ldc_w 1202
    //   477: istore_2
    //   478: iload_2
    //   479: istore_1
    //   480: aload_0
    //   481: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   484: getfield 593	com/tencent/msf/service/protocol/push/a/d:i	J
    //   487: lconst_0
    //   488: lcmp
    //   489: ifle +32 -> 521
    //   492: iload_2
    //   493: istore_1
    //   494: aload_0
    //   495: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   498: getfield 593	com/tencent/msf/service/protocol/push/a/d:i	J
    //   501: ldc2_w 1203
    //   504: lcmp
    //   505: ifge +16 -> 521
    //   508: aload_0
    //   509: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   512: getfield 593	com/tencent/msf/service/protocol/push/a/d:i	J
    //   515: l2i
    //   516: sipush 1000
    //   519: imul
    //   520: istore_1
    //   521: iconst_0
    //   522: istore_2
    //   523: aload_0
    //   524: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   527: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   530: invokevirtual 692	java/util/ArrayList:size	()I
    //   533: istore_3
    //   534: iload_2
    //   535: iload_3
    //   536: if_icmpge +770 -> 1306
    //   539: aload_0
    //   540: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   543: invokestatic 208	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   546: putfield 899	com/tencent/mobileqq/msf/core/net/c/f$e:g	I
    //   549: aload_0
    //   550: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   553: invokestatic 1207	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getWifiStrength	()I
    //   556: putfield 1209	com/tencent/mobileqq/msf/core/net/c/f$e:h	I
    //   559: aload_0
    //   560: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   563: invokestatic 1212	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getCdmaStrength	()I
    //   566: putfield 1214	com/tencent/mobileqq/msf/core/net/c/f$e:j	I
    //   569: aload_0
    //   570: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   573: invokestatic 1217	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getGsmStrength	()I
    //   576: putfield 1219	com/tencent/mobileqq/msf/core/net/c/f$e:i	I
    //   579: aload_0
    //   580: aload_0
    //   581: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   584: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   587: iload_2
    //   588: invokevirtual 1222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   591: checkcast 607	com/tencent/msf/service/protocol/push/a/a
    //   594: invokestatic 928	com/tencent/qphone/base/util/g:a	(Lcom/tencent/msf/service/protocol/push/a/a;)Ljava/net/InetAddress;
    //   597: putfield 118	com/tencent/mobileqq/msf/core/net/c/f:n	Ljava/net/InetAddress;
    //   600: goto +22 -> 622
    //   603: astore 6
    //   605: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   608: ifeq +14 -> 622
    //   611: ldc 255
    //   613: iconst_4
    //   614: ldc_w 1224
    //   617: aload 6
    //   619: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   622: aload_0
    //   623: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   626: aload_0
    //   627: getfield 118	com/tencent/mobileqq/msf/core/net/c/f:n	Ljava/net/InetAddress;
    //   630: invokevirtual 614	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   633: putfield 1226	com/tencent/mobileqq/msf/core/net/c/f$e:K	Ljava/lang/String;
    //   636: aload_0
    //   637: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   640: aload_0
    //   641: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   644: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   647: iload_2
    //   648: invokevirtual 1222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   651: checkcast 607	com/tencent/msf/service/protocol/push/a/a
    //   654: getfield 609	com/tencent/msf/service/protocol/push/a/a:c	Ljava/lang/String;
    //   657: putfield 938	com/tencent/mobileqq/msf/core/net/c/f$e:C	Ljava/lang/String;
    //   660: aload_0
    //   661: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   664: getfield 938	com/tencent/mobileqq/msf/core/net/c/f$e:C	Ljava/lang/String;
    //   667: ifnull +16 -> 683
    //   670: aload_0
    //   671: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   674: getfield 938	com/tencent/mobileqq/msf/core/net/c/f$e:C	Ljava/lang/String;
    //   677: invokevirtual 1228	java/lang/String:isEmpty	()Z
    //   680: ifeq +17 -> 697
    //   683: aload_0
    //   684: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   687: aload_0
    //   688: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   691: getfield 1226	com/tencent/mobileqq/msf/core/net/c/f$e:K	Ljava/lang/String;
    //   694: putfield 938	com/tencent/mobileqq/msf/core/net/c/f$e:C	Ljava/lang/String;
    //   697: aload_0
    //   698: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   701: getfield 178	com/tencent/mobileqq/msf/core/net/c/f$e:c	Ljava/util/Map;
    //   704: invokeinterface 1231 1 0
    //   709: aload_0
    //   710: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   713: getfield 938	com/tencent/mobileqq/msf/core/net/c/f$e:C	Ljava/lang/String;
    //   716: astore 6
    //   718: aload_0
    //   719: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   722: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   725: putfield 380	com/tencent/mobileqq/msf/core/net/c/f$e:M	J
    //   728: new 1233	com/tencent/mobileqq/msf/core/net/c/i
    //   731: dup
    //   732: aload 6
    //   734: iconst_1
    //   735: iload_1
    //   736: invokespecial 1236	com/tencent/mobileqq/msf/core/net/c/i:<init>	(Ljava/lang/String;ZI)V
    //   739: astore 9
    //   741: getstatic 300	com/tencent/mobileqq/msf/core/net/c/h:a	[I
    //   744: aload_0
    //   745: getfield 166	com/tencent/mobileqq/msf/core/net/c/f:a	Lcom/tencent/mobileqq/msf/core/net/c/f$b;
    //   748: invokevirtual 303	com/tencent/mobileqq/msf/core/net/c/f$b:ordinal	()I
    //   751: iaload
    //   752: istore_3
    //   753: ldc 120
    //   755: astore 6
    //   757: iload_3
    //   758: iconst_4
    //   759: if_icmpeq +75 -> 834
    //   762: iload_3
    //   763: iconst_5
    //   764: if_icmpeq +9 -> 773
    //   767: iconst_1
    //   768: istore 4
    //   770: goto +382 -> 1152
    //   773: aload 9
    //   775: invokevirtual 1239	com/tencent/mobileqq/msf/core/net/c/i:a	()Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   778: astore 8
    //   780: aload 8
    //   782: ifnull +561 -> 1343
    //   785: aload 8
    //   787: getfield 1243	com/tencent/mobileqq/msf/core/net/c/i$a:b	Z
    //   790: ifeq +553 -> 1343
    //   793: aload 8
    //   795: getfield 1245	com/tencent/mobileqq/msf/core/net/c/i$a:d	Ljava/lang/String;
    //   798: astore 7
    //   800: aload 7
    //   802: astore 6
    //   804: aload 8
    //   806: getfield 1246	com/tencent/mobileqq/msf/core/net/c/i$a:c	Ljava/lang/String;
    //   809: invokestatic 742	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   812: ifne -45 -> 767
    //   815: aload_0
    //   816: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   819: aload 8
    //   821: getfield 1246	com/tencent/mobileqq/msf/core/net/c/i$a:c	Ljava/lang/String;
    //   824: putfield 1226	com/tencent/mobileqq/msf/core/net/c/f$e:K	Ljava/lang/String;
    //   827: aload 7
    //   829: astore 6
    //   831: goto -64 -> 767
    //   834: aload_0
    //   835: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   838: getfield 1248	com/tencent/msf/service/protocol/push/a/d:v	Ljava/util/ArrayList;
    //   841: ifnull +250 -> 1091
    //   844: aload_0
    //   845: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   848: getfield 1248	com/tencent/msf/service/protocol/push/a/d:v	Ljava/util/ArrayList;
    //   851: invokevirtual 692	java/util/ArrayList:size	()I
    //   854: ifle +237 -> 1091
    //   857: aload_0
    //   858: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   861: getfield 1248	com/tencent/msf/service/protocol/push/a/d:v	Ljava/util/ArrayList;
    //   864: invokevirtual 696	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   867: astore 10
    //   869: ldc 120
    //   871: astore 7
    //   873: aload 10
    //   875: invokeinterface 701 1 0
    //   880: ifeq +161 -> 1041
    //   883: aload 10
    //   885: invokeinterface 705 1 0
    //   890: checkcast 1250	com/tencent/msf/service/protocol/push/a/c
    //   893: astore 11
    //   895: aload 11
    //   897: ifnull -24 -> 873
    //   900: new 241	java/lang/StringBuilder
    //   903: dup
    //   904: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   907: astore 8
    //   909: aload 8
    //   911: aload 7
    //   913: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: pop
    //   917: aload 8
    //   919: aload 11
    //   921: getfield 1251	com/tencent/msf/service/protocol/push/a/c:a	Ljava/lang/String;
    //   924: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: pop
    //   928: aload 8
    //   930: ldc_w 988
    //   933: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: pop
    //   937: aload 8
    //   939: aload 11
    //   941: getfield 1252	com/tencent/msf/service/protocol/push/a/c:b	Ljava/lang/String;
    //   944: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: pop
    //   948: aload 8
    //   950: ldc_w 988
    //   953: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: pop
    //   957: aload 8
    //   959: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   962: astore 8
    //   964: aload 8
    //   966: astore 7
    //   968: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   971: ifeq -98 -> 873
    //   974: new 241	java/lang/StringBuilder
    //   977: dup
    //   978: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   981: astore 7
    //   983: aload 7
    //   985: ldc_w 1254
    //   988: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: pop
    //   992: aload 7
    //   994: aload 11
    //   996: getfield 1251	com/tencent/msf/service/protocol/push/a/c:a	Ljava/lang/String;
    //   999: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: pop
    //   1003: aload 7
    //   1005: ldc_w 1256
    //   1008: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: pop
    //   1012: aload 7
    //   1014: aload 11
    //   1016: getfield 1252	com/tencent/msf/service/protocol/push/a/c:b	Ljava/lang/String;
    //   1019: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1022: pop
    //   1023: ldc 255
    //   1025: iconst_4
    //   1026: aload 7
    //   1028: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1031: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1034: aload 8
    //   1036: astore 7
    //   1038: goto -165 -> 873
    //   1041: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1044: ifeq +40 -> 1084
    //   1047: new 241	java/lang/StringBuilder
    //   1050: dup
    //   1051: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1054: astore 8
    //   1056: aload 8
    //   1058: ldc_w 1258
    //   1061: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: pop
    //   1065: aload 8
    //   1067: aload 7
    //   1069: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: pop
    //   1073: ldc 255
    //   1075: iconst_2
    //   1076: aload 8
    //   1078: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1081: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1084: aload 9
    //   1086: aload 7
    //   1088: invokevirtual 1259	com/tencent/mobileqq/msf/core/net/c/i:a	(Ljava/lang/String;)V
    //   1091: aload 9
    //   1093: invokevirtual 1261	com/tencent/mobileqq/msf/core/net/c/i:b	()Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   1096: astore 8
    //   1098: aload 8
    //   1100: ifnull +243 -> 1343
    //   1103: aload 8
    //   1105: getfield 1243	com/tencent/mobileqq/msf/core/net/c/i$a:b	Z
    //   1108: ifeq +235 -> 1343
    //   1111: aload 8
    //   1113: getfield 1245	com/tencent/mobileqq/msf/core/net/c/i$a:d	Ljava/lang/String;
    //   1116: astore 7
    //   1118: aload 7
    //   1120: astore 6
    //   1122: aload 8
    //   1124: getfield 1246	com/tencent/mobileqq/msf/core/net/c/i$a:c	Ljava/lang/String;
    //   1127: invokestatic 742	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1130: ifne -363 -> 767
    //   1133: aload_0
    //   1134: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1137: aload 8
    //   1139: getfield 1246	com/tencent/mobileqq/msf/core/net/c/i$a:c	Ljava/lang/String;
    //   1142: putfield 1226	com/tencent/mobileqq/msf/core/net/c/f$e:K	Ljava/lang/String;
    //   1145: aload 7
    //   1147: astore 6
    //   1149: goto -382 -> 767
    //   1152: aload_0
    //   1153: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1156: aload 6
    //   1158: invokestatic 423	com/tencent/qphone/base/util/g:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1161: putfield 1263	com/tencent/mobileqq/msf/core/net/c/f$e:R	Ljava/lang/String;
    //   1164: aload_0
    //   1165: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1168: aload_0
    //   1169: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1172: getfield 1263	com/tencent/mobileqq/msf/core/net/c/f$e:R	Ljava/lang/String;
    //   1175: invokevirtual 426	java/lang/String:length	()I
    //   1178: putfield 1265	com/tencent/mobileqq/msf/core/net/c/f$e:Q	I
    //   1181: aload_0
    //   1182: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1185: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   1188: putfield 382	com/tencent/mobileqq/msf/core/net/c/f$e:N	J
    //   1191: iload_2
    //   1192: aload_0
    //   1193: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1196: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   1199: invokevirtual 692	java/util/ArrayList:size	()I
    //   1202: iconst_1
    //   1203: isub
    //   1204: if_icmpne +145 -> 1349
    //   1207: iconst_1
    //   1208: istore 5
    //   1210: goto +3 -> 1213
    //   1213: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1216: ifeq +57 -> 1273
    //   1219: new 241	java/lang/StringBuilder
    //   1222: dup
    //   1223: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1226: astore 6
    //   1228: aload 6
    //   1230: ldc_w 1267
    //   1233: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1236: pop
    //   1237: aload 6
    //   1239: iload 4
    //   1241: invokevirtual 1270	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1244: pop
    //   1245: aload 6
    //   1247: ldc_w 1272
    //   1250: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1253: pop
    //   1254: aload 6
    //   1256: iload 5
    //   1258: invokevirtual 1270	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1261: pop
    //   1262: ldc 255
    //   1264: iconst_2
    //   1265: aload 6
    //   1267: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1270: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1273: iload 4
    //   1275: ifeq +15 -> 1290
    //   1278: aload_0
    //   1279: getstatic 1274	com/tencent/mobileqq/msf/core/net/c/f$e$a:a	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   1282: iload 5
    //   1284: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   1287: goto +12 -> 1299
    //   1290: aload_0
    //   1291: getstatic 1276	com/tencent/mobileqq/msf/core/net/c/f$e$a:b	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   1294: iload 5
    //   1296: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   1299: iload_2
    //   1300: iconst_1
    //   1301: iadd
    //   1302: istore_2
    //   1303: goto -780 -> 523
    //   1306: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1309: return
    //   1310: astore 6
    //   1312: goto +19 -> 1331
    //   1315: astore 6
    //   1317: ldc 255
    //   1319: iconst_1
    //   1320: ldc_w 1278
    //   1323: aload 6
    //   1325: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1328: goto -22 -> 1306
    //   1331: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1334: goto +6 -> 1340
    //   1337: aload 6
    //   1339: athrow
    //   1340: goto -3 -> 1337
    //   1343: iconst_0
    //   1344: istore 4
    //   1346: goto -194 -> 1152
    //   1349: iconst_0
    //   1350: istore 5
    //   1352: goto -139 -> 1213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1355	0	this	f
    //   479	257	1	i1	int
    //   477	826	2	i2	int
    //   533	232	3	i3	int
    //   768	577	4	bool1	boolean
    //   1208	143	5	bool2	boolean
    //   50	405	6	localStringBuilder	StringBuilder
    //   603	15	6	localException1	Exception
    //   716	550	6	localObject1	Object
    //   1310	1	6	localObject2	Object
    //   1315	23	6	localException2	Exception
    //   798	348	7	localObject3	Object
    //   778	360	8	localObject4	Object
    //   739	353	9	locali	i
    //   867	17	10	localIterator	Iterator
    //   893	122	11	localc	com.tencent.msf.service.protocol.push.a.c
    // Exception table:
    //   from	to	target	type
    //   539	600	603	java/lang/Exception
    //   523	534	1310	finally
    //   539	600	1310	finally
    //   605	622	1310	finally
    //   622	683	1310	finally
    //   683	697	1310	finally
    //   697	753	1310	finally
    //   773	780	1310	finally
    //   785	800	1310	finally
    //   804	827	1310	finally
    //   834	869	1310	finally
    //   873	895	1310	finally
    //   900	964	1310	finally
    //   968	1034	1310	finally
    //   1041	1084	1310	finally
    //   1084	1091	1310	finally
    //   1091	1098	1310	finally
    //   1103	1118	1310	finally
    //   1122	1145	1310	finally
    //   1152	1207	1310	finally
    //   1213	1273	1310	finally
    //   1278	1287	1310	finally
    //   1290	1299	1310	finally
    //   1317	1328	1310	finally
    //   523	534	1315	java/lang/Exception
    //   605	622	1315	java/lang/Exception
    //   622	683	1315	java/lang/Exception
    //   683	697	1315	java/lang/Exception
    //   697	753	1315	java/lang/Exception
    //   773	780	1315	java/lang/Exception
    //   785	800	1315	java/lang/Exception
    //   804	827	1315	java/lang/Exception
    //   834	869	1315	java/lang/Exception
    //   873	895	1315	java/lang/Exception
    //   900	964	1315	java/lang/Exception
    //   968	1034	1315	java/lang/Exception
    //   1041	1084	1315	java/lang/Exception
    //   1084	1091	1315	java/lang/Exception
    //   1091	1098	1315	java/lang/Exception
    //   1103	1118	1315	java/lang/Exception
    //   1122	1145	1315	java/lang/Exception
    //   1152	1207	1315	java/lang/Exception
    //   1213	1273	1315	java/lang/Exception
    //   1278	1287	1315	java/lang/Exception
    //   1290	1299	1315	java/lang/Exception
  }
  
  private String j()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(NetConnInfoCenter.getActiveNetIpFamily(false));
    localStringBuilder.append("_");
    if (NetConnInfoCenter.isWifiConn())
    {
      localStringBuilder.append("wifi");
      localStringBuilder.append("_");
    }
    else if (NetConnInfoCenter.isMobileConn())
    {
      localStringBuilder.append(NetConnInfoCenter.getCurrentAPN());
      localStringBuilder.append("_");
    }
    else
    {
      localStringBuilder.append("other");
      localStringBuilder.append("_");
    }
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localStringBuilder.append("_");
    localStringBuilder.append(Build.BRAND);
    return localStringBuilder.substring(0, Math.min(32, localStringBuilder.length()));
  }
  
  private void k()
  {
    this.q.d = this.b.j;
    this.q.e = this.b.o;
    this.q.f = this.b.k;
    this.q.g = this.b.l;
    this.q.h = this.b.m;
    this.q.a = f.d.a.a;
    this.q.i = this.b.u;
    this.q.n = j();
    Object localObject = f();
    StringBuilder localStringBuilder;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      int i2 = Math.min(((ArrayList)localObject).size(), 3);
      localStringBuilder = new StringBuilder("");
      int i1 = 0;
      while (i1 < i2)
      {
        localStringBuilder.append(((InetAddress)((ArrayList)localObject).get(i1)).getHostAddress());
        if ((i2 > 1) && (i1 < i2 - 1)) {
          localStringBuilder.append(",");
        }
        i1 += 1;
      }
      this.q.j = localStringBuilder.toString();
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("MSF.C.QualityTestManager", 2, "mDnses is null");
    }
    if (0L != o.h)
    {
      this.q.l = o.h;
      localObject = this.q;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(o.i);
      localStringBuilder.append(",");
      localStringBuilder.append(o.j);
      ((f.d)localObject).m = localStringBuilder.toString();
    }
  }
  
  private boolean l()
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
  private void m()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   4: ifnonnull +15 -> 19
    //   7: aload_0
    //   8: getstatic 1353	com/tencent/mobileqq/msf/core/net/c/f$e$a:o	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   11: iconst_1
    //   12: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   15: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   18: return
    //   19: aload_0
    //   20: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   23: getstatic 1358	com/tencent/mobileqq/msf/core/net/c/f$e$b:b	Lcom/tencent/mobileqq/msf/core/net/c/f$e$b;
    //   26: putfield 1360	com/tencent/mobileqq/msf/core/net/c/f$e:a	Lcom/tencent/mobileqq/msf/core/net/c/f$e$b;
    //   29: aload_0
    //   30: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   33: invokestatic 208	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   36: putfield 899	com/tencent/mobileqq/msf/core/net/c/f$e:g	I
    //   39: aload_0
    //   40: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   43: aload_0
    //   44: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   47: getfield 1361	com/tencent/msf/service/protocol/push/a/b:a	S
    //   50: putfield 1153	com/tencent/mobileqq/msf/core/net/c/f$e:r	I
    //   53: aload_0
    //   54: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   57: aload_0
    //   58: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   61: getfield 1362	com/tencent/msf/service/protocol/push/a/b:g	J
    //   64: putfield 1363	com/tencent/mobileqq/msf/core/net/c/f$e:s	J
    //   67: aload_0
    //   68: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   71: aload_0
    //   72: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   75: getfield 1364	com/tencent/msf/service/protocol/push/a/b:f	J
    //   78: putfield 1365	com/tencent/mobileqq/msf/core/net/c/f$e:t	J
    //   81: aload_0
    //   82: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   85: new 346	java/util/ArrayList
    //   88: dup
    //   89: invokespecial 884	java/util/ArrayList:<init>	()V
    //   92: putfield 1367	com/tencent/mobileqq/msf/core/net/c/f$e:u	Ljava/util/ArrayList;
    //   95: iconst_0
    //   96: istore_1
    //   97: iload_1
    //   98: aload_0
    //   99: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   102: getfield 1369	com/tencent/msf/service/protocol/push/a/b:d	Ljava/util/ArrayList;
    //   105: invokevirtual 692	java/util/ArrayList:size	()I
    //   108: if_icmpge +32 -> 140
    //   111: aload_0
    //   112: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   115: getfield 1367	com/tencent/mobileqq/msf/core/net/c/f$e:u	Ljava/util/ArrayList;
    //   118: aload_0
    //   119: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   122: getfield 1369	com/tencent/msf/service/protocol/push/a/b:d	Ljava/util/ArrayList;
    //   125: iload_1
    //   126: invokevirtual 1222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   129: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   132: pop
    //   133: iload_1
    //   134: iconst_1
    //   135: iadd
    //   136: istore_1
    //   137: goto -40 -> 97
    //   140: aload_0
    //   141: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   144: aload_0
    //   145: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   148: getfield 1370	com/tencent/msf/service/protocol/push/a/b:h	J
    //   151: putfield 1371	com/tencent/mobileqq/msf/core/net/c/f$e:w	J
    //   154: aload_0
    //   155: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   158: new 346	java/util/ArrayList
    //   161: dup
    //   162: invokespecial 884	java/util/ArrayList:<init>	()V
    //   165: putfield 1372	com/tencent/mobileqq/msf/core/net/c/f$e:v	Ljava/util/ArrayList;
    //   168: new 241	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   175: astore 15
    //   177: aload 15
    //   179: ldc_w 1374
    //   182: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 15
    //   188: aload_0
    //   189: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   192: getfield 1364	com/tencent/msf/service/protocol/push/a/b:f	J
    //   195: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 15
    //   201: ldc_w 1157
    //   204: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 15
    //   210: aload_0
    //   211: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   214: getfield 1375	com/tencent/msf/service/protocol/push/a/b:b	Ljava/util/ArrayList;
    //   217: invokevirtual 692	java/util/ArrayList:size	()I
    //   220: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 15
    //   226: ldc_w 1377
    //   229: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 15
    //   235: aload_0
    //   236: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   239: getfield 1379	com/tencent/msf/service/protocol/push/a/b:c	Ljava/util/ArrayList;
    //   242: invokevirtual 692	java/util/ArrayList:size	()I
    //   245: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 15
    //   251: ldc_w 1381
    //   254: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 15
    //   260: aload_0
    //   261: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   264: getfield 1362	com/tencent/msf/service/protocol/push/a/b:g	J
    //   267: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: ldc 255
    //   273: iconst_1
    //   274: aload 15
    //   276: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   282: aload_0
    //   283: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   286: getfield 1375	com/tencent/msf/service/protocol/push/a/b:b	Ljava/util/ArrayList;
    //   289: invokevirtual 692	java/util/ArrayList:size	()I
    //   292: bipush 75
    //   294: if_icmple +35 -> 329
    //   297: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   300: ifeq +12 -> 312
    //   303: ldc 255
    //   305: iconst_4
    //   306: ldc_w 1185
    //   309: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: aload_0
    //   313: iconst_0
    //   314: putfield 134	com/tencent/mobileqq/msf/core/net/c/f:V	Z
    //   317: aload_0
    //   318: getstatic 1187	com/tencent/mobileqq/msf/core/net/c/f$e$a:m	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   321: iconst_1
    //   322: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   325: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   328: return
    //   329: aload_0
    //   330: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   333: getfield 1375	com/tencent/msf/service/protocol/push/a/b:b	Ljava/util/ArrayList;
    //   336: invokevirtual 692	java/util/ArrayList:size	()I
    //   339: ifgt +30 -> 369
    //   342: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   345: ifeq +12 -> 357
    //   348: ldc 255
    //   350: iconst_4
    //   351: ldc_w 1189
    //   354: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: aload_0
    //   358: getstatic 1191	com/tencent/mobileqq/msf/core/net/c/f$e$a:n	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   361: iconst_1
    //   362: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   365: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   368: return
    //   369: aload_0
    //   370: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   373: getfield 1362	com/tencent/msf/service/protocol/push/a/b:g	J
    //   376: ldc2_w 1382
    //   379: lcmp
    //   380: ifle +35 -> 415
    //   383: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   386: ifeq +12 -> 398
    //   389: ldc 255
    //   391: iconst_4
    //   392: ldc_w 1385
    //   395: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: aload_0
    //   399: iconst_0
    //   400: putfield 134	com/tencent/mobileqq/msf/core/net/c/f:V	Z
    //   403: aload_0
    //   404: getstatic 1387	com/tencent/mobileqq/msf/core/net/c/f$e$a:l	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   407: iconst_1
    //   408: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   411: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   414: return
    //   415: aload_0
    //   416: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   419: getfield 1370	com/tencent/msf/service/protocol/push/a/b:h	J
    //   422: ldc2_w 1194
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
    //   450: ldc_w 1389
    //   453: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload 15
    //   459: aload_0
    //   460: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   463: getfield 1370	com/tencent/msf/service/protocol/push/a/b:h	J
    //   466: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload 15
    //   472: ldc_w 1199
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
    //   500: getstatic 1201	com/tencent/mobileqq/msf/core/net/c/f$e$a:j	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   503: iconst_1
    //   504: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   507: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   510: return
    //   511: aload_0
    //   512: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   515: getfield 1391	com/tencent/msf/service/protocol/push/a/b:e	Ljava/util/ArrayList;
    //   518: invokevirtual 692	java/util/ArrayList:size	()I
    //   521: aload_0
    //   522: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   525: getfield 1369	com/tencent/msf/service/protocol/push/a/b:d	Ljava/util/ArrayList;
    //   528: invokevirtual 692	java/util/ArrayList:size	()I
    //   531: if_icmpne +1271 -> 1802
    //   534: aload_0
    //   535: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   538: getfield 1379	com/tencent/msf/service/protocol/push/a/b:c	Ljava/util/ArrayList;
    //   541: invokevirtual 692	java/util/ArrayList:size	()I
    //   544: aload_0
    //   545: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   548: getfield 1369	com/tencent/msf/service/protocol/push/a/b:d	Ljava/util/ArrayList;
    //   551: invokevirtual 692	java/util/ArrayList:size	()I
    //   554: if_icmpeq +6 -> 560
    //   557: goto +1245 -> 1802
    //   560: aload_0
    //   561: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   564: getfield 1362	com/tencent/msf/service/protocol/push/a/b:g	J
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
    //   589: ldc_w 1393
    //   592: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: pop
    //   596: aload 15
    //   598: aload_0
    //   599: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   602: getfield 1362	com/tencent/msf/service/protocol/push/a/b:g	J
    //   605: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   608: pop
    //   609: ldc 255
    //   611: iconst_4
    //   612: aload 15
    //   614: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   620: aload_0
    //   621: getstatic 273	com/tencent/mobileqq/msf/core/net/c/f$e$a:i	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   624: iconst_1
    //   625: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   628: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   631: return
    //   632: aload_0
    //   633: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   636: getfield 1362	com/tencent/msf/service/protocol/push/a/b:g	J
    //   639: aload_0
    //   640: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   643: getfield 1379	com/tencent/msf/service/protocol/push/a/b:c	Ljava/util/ArrayList;
    //   646: invokevirtual 692	java/util/ArrayList:size	()I
    //   649: i2l
    //   650: lmul
    //   651: ldc2_w 1382
    //   654: lcmp
    //   655: ifle +35 -> 690
    //   658: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   661: ifeq +12 -> 673
    //   664: ldc 255
    //   666: iconst_4
    //   667: ldc_w 1385
    //   670: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   673: aload_0
    //   674: iconst_0
    //   675: putfield 134	com/tencent/mobileqq/msf/core/net/c/f:V	Z
    //   678: aload_0
    //   679: getstatic 1387	com/tencent/mobileqq/msf/core/net/c/f$e$a:l	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   682: iconst_1
    //   683: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   686: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   689: return
    //   690: iconst_0
    //   691: istore_2
    //   692: iload_2
    //   693: aload_0
    //   694: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   697: getfield 1375	com/tencent/msf/service/protocol/push/a/b:b	Ljava/util/ArrayList;
    //   700: invokevirtual 692	java/util/ArrayList:size	()I
    //   703: if_icmpge +1068 -> 1771
    //   706: aload_0
    //   707: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   710: new 346	java/util/ArrayList
    //   713: dup
    //   714: invokespecial 884	java/util/ArrayList:<init>	()V
    //   717: putfield 1395	com/tencent/mobileqq/msf/core/net/c/f$e:y	Ljava/util/ArrayList;
    //   720: aload_0
    //   721: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   724: iconst_0
    //   725: putfield 391	com/tencent/mobileqq/msf/core/net/c/f$e:k	I
    //   728: aload_0
    //   729: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   732: iconst_0
    //   733: putfield 472	com/tencent/mobileqq/msf/core/net/c/f$e:n	I
    //   736: aload_0
    //   737: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   740: iconst_0
    //   741: putfield 806	com/tencent/mobileqq/msf/core/net/c/f$e:l	I
    //   744: aload_0
    //   745: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   748: iconst_0
    //   749: putfield 454	com/tencent/mobileqq/msf/core/net/c/f$e:m	I
    //   752: aload_0
    //   753: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   756: iconst_0
    //   757: putfield 764	com/tencent/mobileqq/msf/core/net/c/f$e:o	I
    //   760: aload_0
    //   761: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   764: getfield 178	com/tencent/mobileqq/msf/core/net/c/f$e:c	Ljava/util/Map;
    //   767: invokeinterface 1231 1 0
    //   772: aload_0
    //   773: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   776: getfield 1372	com/tencent/mobileqq/msf/core/net/c/f$e:v	Ljava/util/ArrayList;
    //   779: invokevirtual 1396	java/util/ArrayList:clear	()V
    //   782: aload_0
    //   783: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   786: invokestatic 1207	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getWifiStrength	()I
    //   789: putfield 1209	com/tencent/mobileqq/msf/core/net/c/f$e:h	I
    //   792: aload_0
    //   793: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   796: invokestatic 1212	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getCdmaStrength	()I
    //   799: putfield 1214	com/tencent/mobileqq/msf/core/net/c/f$e:j	I
    //   802: aload_0
    //   803: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   806: invokestatic 1217	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getGsmStrength	()I
    //   809: putfield 1219	com/tencent/mobileqq/msf/core/net/c/f$e:i	I
    //   812: goto +1022 -> 1834
    //   815: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   818: ifeq +1016 -> 1834
    //   821: ldc 255
    //   823: iconst_4
    //   824: ldc_w 1398
    //   827: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   830: goto +1004 -> 1834
    //   833: iload_3
    //   834: aload_0
    //   835: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   838: getfield 1379	com/tencent/msf/service/protocol/push/a/b:c	Ljava/util/ArrayList;
    //   841: invokevirtual 692	java/util/ArrayList:size	()I
    //   844: if_icmpge +885 -> 1729
    //   847: aload_0
    //   848: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   851: getfield 1379	com/tencent/msf/service/protocol/push/a/b:c	Ljava/util/ArrayList;
    //   854: iload_3
    //   855: invokevirtual 1222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   858: checkcast 1399	[B
    //   861: arraylength
    //   862: bipush 8
    //   864: if_icmpge +28 -> 892
    //   867: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   870: ifeq +12 -> 882
    //   873: ldc 255
    //   875: iconst_4
    //   876: ldc_w 1401
    //   879: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   882: aload_0
    //   883: getstatic 273	com/tencent/mobileqq/msf/core/net/c/f$e$a:i	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   886: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/f:a	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;)V
    //   889: goto +958 -> 1847
    //   892: aload_0
    //   893: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   896: getfield 1391	com/tencent/msf/service/protocol/push/a/b:e	Ljava/util/ArrayList;
    //   899: iload_3
    //   900: invokevirtual 1222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   903: ifnull +938 -> 1841
    //   906: aload_0
    //   907: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   910: getfield 1391	com/tencent/msf/service/protocol/push/a/b:e	Ljava/util/ArrayList;
    //   913: iload_3
    //   914: invokevirtual 1222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   917: checkcast 1399	[B
    //   920: arraylength
    //   921: ifle +920 -> 1841
    //   924: aload_0
    //   925: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   928: getfield 1391	com/tencent/msf/service/protocol/push/a/b:e	Ljava/util/ArrayList;
    //   931: iload_3
    //   932: invokevirtual 1222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   935: checkcast 1399	[B
    //   938: arraylength
    //   939: istore 4
    //   941: goto +3 -> 944
    //   944: iload 4
    //   946: i2l
    //   947: lstore 8
    //   949: aload_0
    //   950: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   953: getfield 1379	com/tencent/msf/service/protocol/push/a/b:c	Ljava/util/ArrayList;
    //   956: iload_3
    //   957: invokevirtual 1222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   960: checkcast 1399	[B
    //   963: arraylength
    //   964: i2l
    //   965: lstore 10
    //   967: aload_0
    //   968: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   971: getfield 1369	com/tencent/msf/service/protocol/push/a/b:d	Ljava/util/ArrayList;
    //   974: iload_3
    //   975: invokevirtual 1222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   978: checkcast 386	java/lang/Long
    //   981: invokevirtual 1404	java/lang/Long:longValue	()J
    //   984: lstore 12
    //   986: lload 10
    //   988: invokestatic 1408	java/lang/Long:signum	(J)I
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
    //   1014: ldc_w 1410
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
    //   1042: ldc_w 1411
    //   1045: if_icmple +74 -> 1119
    //   1048: aload_0
    //   1049: getfield 166	com/tencent/mobileqq/msf/core/net/c/f:a	Lcom/tencent/mobileqq/msf/core/net/c/f$b;
    //   1052: getstatic 1412	com/tencent/mobileqq/msf/core/net/c/f$b:a	Lcom/tencent/mobileqq/msf/core/net/c/f$b;
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
    //   1091: ldc_w 1414
    //   1094: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: pop
    //   1098: ldc 255
    //   1100: iconst_4
    //   1101: aload 15
    //   1103: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1106: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1109: aload_0
    //   1110: getstatic 264	com/tencent/mobileqq/msf/core/net/c/f$e$a:h	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   1113: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/f:a	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;)V
    //   1116: goto +731 -> 1847
    //   1119: iload 6
    //   1121: ldc_w 1411
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
    //   1160: ldc_w 1414
    //   1163: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: pop
    //   1167: ldc 255
    //   1169: iconst_4
    //   1170: aload 15
    //   1172: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1175: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1178: aload_0
    //   1179: iconst_0
    //   1180: putfield 134	com/tencent/mobileqq/msf/core/net/c/f:V	Z
    //   1183: aload_0
    //   1184: getstatic 264	com/tencent/mobileqq/msf/core/net/c/f$e$a:h	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   1187: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/f:a	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;)V
    //   1190: goto +657 -> 1847
    //   1193: aload_0
    //   1194: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1197: getfield 1364	com/tencent/msf/service/protocol/push/a/b:f	J
    //   1200: ldc2_w 1415
    //   1203: lcmp
    //   1204: ifge +646 -> 1850
    //   1207: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1210: ifeq +54 -> 1264
    //   1213: new 241	java/lang/StringBuilder
    //   1216: dup
    //   1217: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1220: astore 15
    //   1222: aload 15
    //   1224: ldc_w 1418
    //   1227: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: pop
    //   1231: aload 15
    //   1233: aload_0
    //   1234: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1237: getfield 1364	com/tencent/msf/service/protocol/push/a/b:f	J
    //   1240: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1243: pop
    //   1244: aload 15
    //   1246: ldc_w 1414
    //   1249: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: pop
    //   1253: ldc 255
    //   1255: iconst_4
    //   1256: aload 15
    //   1258: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1261: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1264: aload_0
    //   1265: getstatic 1420	com/tencent/mobileqq/msf/core/net/c/f$e$a:g	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   1268: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/f:a	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;)V
    //   1271: goto +576 -> 1847
    //   1274: iload 4
    //   1276: i2l
    //   1277: aload_0
    //   1278: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1281: getfield 1362	com/tencent/msf/service/protocol/push/a/b:g	J
    //   1284: lcmp
    //   1285: ifge +591 -> 1876
    //   1288: iload_1
    //   1289: ifne +74 -> 1363
    //   1292: aload_0
    //   1293: aload_0
    //   1294: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1297: getfield 1375	com/tencent/msf/service/protocol/push/a/b:b	Ljava/util/ArrayList;
    //   1300: iload_2
    //   1301: invokevirtual 1222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1304: checkcast 607	com/tencent/msf/service/protocol/push/a/a
    //   1307: invokespecial 1422	com/tencent/mobileqq/msf/core/net/c/f:a	(Lcom/tencent/msf/service/protocol/push/a/a;)Z
    //   1310: ifne +28 -> 1338
    //   1313: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1316: ifeq +12 -> 1328
    //   1319: ldc 255
    //   1321: iconst_4
    //   1322: ldc_w 1424
    //   1325: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1328: aload_0
    //   1329: getstatic 1426	com/tencent/mobileqq/msf/core/net/c/f$e$a:c	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   1332: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/f:a	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;)V
    //   1335: goto +532 -> 1867
    //   1338: aload_0
    //   1339: lconst_0
    //   1340: putfield 154	com/tencent/mobileqq/msf/core/net/c/f:A	J
    //   1343: aload_0
    //   1344: lconst_0
    //   1345: putfield 158	com/tencent/mobileqq/msf/core/net/c/f:C	J
    //   1348: aload_0
    //   1349: lconst_0
    //   1350: putfield 156	com/tencent/mobileqq/msf/core/net/c/f:B	J
    //   1353: aload_0
    //   1354: lconst_0
    //   1355: putfield 160	com/tencent/mobileqq/msf/core/net/c/f:D	J
    //   1358: iconst_1
    //   1359: istore_1
    //   1360: goto +3 -> 1363
    //   1363: iload 6
    //   1365: invokestatic 829	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1368: astore 15
    //   1370: iload 6
    //   1372: newarray byte
    //   1374: astore 16
    //   1376: aload_0
    //   1377: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1380: getfield 1391	com/tencent/msf/service/protocol/push/a/b:e	Ljava/util/ArrayList;
    //   1383: iload_3
    //   1384: invokevirtual 1222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1387: ifnull +469 -> 1856
    //   1390: aload_0
    //   1391: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1394: getfield 1391	com/tencent/msf/service/protocol/push/a/b:e	Ljava/util/ArrayList;
    //   1397: iload_3
    //   1398: invokevirtual 1222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1401: checkcast 1399	[B
    //   1404: arraylength
    //   1405: ifle +451 -> 1856
    //   1408: aload 15
    //   1410: aload_0
    //   1411: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1414: getfield 1391	com/tencent/msf/service/protocol/push/a/b:e	Ljava/util/ArrayList;
    //   1417: iload_3
    //   1418: invokevirtual 1222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1421: checkcast 1399	[B
    //   1424: invokevirtual 832	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   1427: pop
    //   1428: goto +428 -> 1856
    //   1431: iload 5
    //   1433: i2l
    //   1434: aload_0
    //   1435: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1438: getfield 1369	com/tencent/msf/service/protocol/push/a/b:d	Ljava/util/ArrayList;
    //   1441: iload_3
    //   1442: invokevirtual 1222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1445: checkcast 386	java/lang/Long
    //   1448: invokevirtual 1404	java/lang/Long:longValue	()J
    //   1451: lcmp
    //   1452: ifge +32 -> 1484
    //   1455: aload 15
    //   1457: aload_0
    //   1458: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1461: getfield 1379	com/tencent/msf/service/protocol/push/a/b:c	Ljava/util/ArrayList;
    //   1464: iload_3
    //   1465: invokevirtual 1222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1468: checkcast 1399	[B
    //   1471: invokevirtual 832	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   1474: pop
    //   1475: iload 5
    //   1477: iconst_1
    //   1478: iadd
    //   1479: istore 5
    //   1481: goto -50 -> 1431
    //   1484: aload 15
    //   1486: invokevirtual 838	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   1489: pop
    //   1490: aload 15
    //   1492: aload 16
    //   1494: invokevirtual 840	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1497: pop
    //   1498: aload 16
    //   1500: arraylength
    //   1501: istore 5
    //   1503: aload 16
    //   1505: iconst_0
    //   1506: invokestatic 528	com/tencent/mobileqq/msf/core/c:a	([BI)I
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
    //   1535: ldc_w 848
    //   1538: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1541: pop
    //   1542: aload 15
    //   1544: iload 7
    //   1546: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1549: pop
    //   1550: aload 15
    //   1552: ldc_w 850
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
    //   1579: getstatic 852	com/tencent/mobileqq/msf/core/net/c/f$e$a:f	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   1582: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/f:a	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;)V
    //   1585: goto +125 -> 1710
    //   1588: aload_0
    //   1589: aload 16
    //   1591: invokespecial 1428	com/tencent/mobileqq/msf/core/net/c/f:a	([B)Z
    //   1594: ifne +6 -> 1600
    //   1597: goto +265 -> 1862
    //   1600: aload_0
    //   1601: aload 16
    //   1603: arraylength
    //   1604: aload 16
    //   1606: invokespecial 1430	com/tencent/mobileqq/msf/core/net/c/f:a	(I[B)Z
    //   1609: ifne +46 -> 1655
    //   1612: aload_0
    //   1613: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1616: getfield 1372	com/tencent/mobileqq/msf/core/net/c/f$e:v	Ljava/util/ArrayList;
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
    //   1642: ldc_w 1432
    //   1645: aload 15
    //   1647: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1650: aload 15
    //   1652: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   1655: aload_0
    //   1656: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1659: getfield 1364	com/tencent/msf/service/protocol/push/a/b:f	J
    //   1662: invokestatic 1438	java/lang/Thread:sleep	(J)V
    //   1665: goto +202 -> 1867
    //   1668: astore 15
    //   1670: new 241	java/lang/StringBuilder
    //   1673: dup
    //   1674: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1677: astore 16
    //   1679: aload 16
    //   1681: ldc_w 1440
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
    //   1711: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1714: getfield 1395	com/tencent/mobileqq/msf/core/net/c/f$e:y	Ljava/util/ArrayList;
    //   1717: iload 6
    //   1719: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1722: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1725: pop
    //   1726: goto +153 -> 1879
    //   1729: aload_0
    //   1730: invokespecial 1442	com/tencent/mobileqq/msf/core/net/c/f:h	()V
    //   1733: iload_2
    //   1734: aload_0
    //   1735: getfield 168	com/tencent/mobileqq/msf/core/net/c/f:c	Lcom/tencent/msf/service/protocol/push/a/b;
    //   1738: getfield 1375	com/tencent/msf/service/protocol/push/a/b:b	Ljava/util/ArrayList;
    //   1741: invokevirtual 692	java/util/ArrayList:size	()I
    //   1744: iconst_1
    //   1745: isub
    //   1746: if_icmpne +140 -> 1886
    //   1749: iconst_1
    //   1750: istore 14
    //   1752: goto +3 -> 1755
    //   1755: aload_0
    //   1756: getstatic 1274	com/tencent/mobileqq/msf/core/net/c/f$e$a:a	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   1759: iload 14
    //   1761: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   1764: iload_2
    //   1765: iconst_1
    //   1766: iadd
    //   1767: istore_2
    //   1768: goto -1076 -> 692
    //   1771: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1774: return
    //   1775: astore 15
    //   1777: goto +19 -> 1796
    //   1780: astore 15
    //   1782: ldc 255
    //   1784: iconst_1
    //   1785: ldc_w 1444
    //   1788: aload 15
    //   1790: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1793: goto -22 -> 1771
    //   1796: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1799: aload 15
    //   1801: athrow
    //   1802: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1805: ifeq +12 -> 1817
    //   1808: ldc 255
    //   1810: iconst_4
    //   1811: ldc_w 1446
    //   1814: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1817: aload_0
    //   1818: getstatic 273	com/tencent/mobileqq/msf/core/net/c/f$e$a:i	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   1821: iconst_1
    //   1822: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   1825: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
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
    //   0	1892	0	this	f
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
  
  public void a(f.e.a parama, boolean paramBoolean)
  {
    if (parama == f.e.a.a)
    {
      this.p.b = parama;
    }
    else
    {
      this.p.b = f.e.a.b;
      if (parama != f.e.a.b) {
        a(parama);
      }
    }
    long l1;
    if (((this.a == f.b.c) && (this.l == 1)) || (this.a == f.b.a))
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
    if (this.a == f.b.a)
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
      if ((this.b != null) && (this.c == null) && (this.q.a == f.d.a.a) && (this.p.a == f.e.b.a))
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
    //   0: ldc_w 1458
    //   3: astore 23
    //   5: ldc_w 1476
    //   8: astore 22
    //   10: ldc_w 1478
    //   13: astore 24
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 104	com/tencent/mobileqq/msf/core/net/c/f:f	Z
    //   20: aload_0
    //   21: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   24: ifnonnull +15 -> 39
    //   27: aload_0
    //   28: getstatic 1147	com/tencent/mobileqq/msf/core/net/c/f$e$a:k	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   31: iconst_1
    //   32: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   35: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   38: return
    //   39: aload_0
    //   40: invokespecial 1149	com/tencent/mobileqq/msf/core/net/c/f:k	()V
    //   43: aload_0
    //   44: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   47: getstatic 1455	com/tencent/mobileqq/msf/core/net/c/f$e$b:a	Lcom/tencent/mobileqq/msf/core/net/c/f$e$b;
    //   50: putfield 1360	com/tencent/mobileqq/msf/core/net/c/f$e:a	Lcom/tencent/mobileqq/msf/core/net/c/f$e$b;
    //   53: aload_0
    //   54: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   57: aload_0
    //   58: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   61: getfield 1151	com/tencent/msf/service/protocol/push/a/d:a	S
    //   64: putfield 1153	com/tencent/mobileqq/msf/core/net/c/f$e:r	I
    //   67: aload_0
    //   68: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   71: aload_0
    //   72: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   75: getfield 1480	com/tencent/msf/service/protocol/push/a/d:c	J
    //   78: putfield 1363	com/tencent/mobileqq/msf/core/net/c/f$e:s	J
    //   81: aload_0
    //   82: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   85: aload_0
    //   86: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   89: getfield 1481	com/tencent/msf/service/protocol/push/a/d:d	J
    //   92: putfield 1365	com/tencent/mobileqq/msf/core/net/c/f$e:t	J
    //   95: aload_0
    //   96: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   99: new 346	java/util/ArrayList
    //   102: dup
    //   103: invokespecial 884	java/util/ArrayList:<init>	()V
    //   106: putfield 1367	com/tencent/mobileqq/msf/core/net/c/f$e:u	Ljava/util/ArrayList;
    //   109: aload_0
    //   110: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   113: getfield 1367	com/tencent/mobileqq/msf/core/net/c/f$e:u	Ljava/util/ArrayList;
    //   116: aload_0
    //   117: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   120: getfield 834	com/tencent/msf/service/protocol/push/a/d:f	J
    //   123: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   126: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   129: pop
    //   130: aload_0
    //   131: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   134: aload_0
    //   135: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   138: getfield 1193	com/tencent/msf/service/protocol/push/a/d:h	J
    //   141: putfield 1371	com/tencent/mobileqq/msf/core/net/c/f$e:w	J
    //   144: aload_0
    //   145: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   148: aload_0
    //   149: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   152: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   155: i2l
    //   156: putfield 1482	com/tencent/mobileqq/msf/core/net/c/f$e:B	J
    //   159: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +574 -> 736
    //   165: new 241	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   172: astore 20
    //   174: aload 20
    //   176: ldc_w 1484
    //   179: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 20
    //   185: aload_0
    //   186: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   189: getfield 1481	com/tencent/msf/service/protocol/push/a/d:d	J
    //   192: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 20
    //   198: ldc_w 1486
    //   201: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 20
    //   207: aload_0
    //   208: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   211: getfield 1481	com/tencent/msf/service/protocol/push/a/d:d	J
    //   214: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 20
    //   220: ldc_w 1157
    //   223: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 20
    //   229: aload_0
    //   230: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   233: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   236: invokevirtual 692	java/util/ArrayList:size	()I
    //   239: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 20
    //   245: ldc_w 1381
    //   248: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 20
    //   254: aload_0
    //   255: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   258: getfield 1480	com/tencent/msf/service/protocol/push/a/d:c	J
    //   261: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 20
    //   267: ldc_w 1488
    //   270: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_0
    //   275: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   278: getfield 1343	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   281: astore 18
    //   283: ldc_w 1490
    //   286: astore 19
    //   288: aload 18
    //   290: ifnull +19 -> 309
    //   293: aload_0
    //   294: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   297: getfield 1343	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   300: arraylength
    //   301: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   304: astore 18
    //   306: goto +8 -> 314
    //   309: ldc_w 1490
    //   312: astore 18
    //   314: aload 20
    //   316: aload 18
    //   318: invokevirtual 523	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 20
    //   324: ldc_w 1492
    //   327: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload_0
    //   332: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   335: getfield 1494	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   338: ifnull +19 -> 357
    //   341: aload_0
    //   342: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   345: getfield 1494	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   348: arraylength
    //   349: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: astore 18
    //   354: goto +8 -> 362
    //   357: ldc_w 1490
    //   360: astore 18
    //   362: aload 20
    //   364: aload 18
    //   366: invokevirtual 523	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload 20
    //   372: ldc_w 1496
    //   375: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload 20
    //   381: aload_0
    //   382: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   385: getfield 834	com/tencent/msf/service/protocol/push/a/d:f	J
    //   388: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 20
    //   394: ldc_w 1498
    //   397: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: pop
    //   401: aload 19
    //   403: astore 18
    //   405: aload_0
    //   406: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   409: getfield 271	com/tencent/msf/service/protocol/push/a/d:e	[B
    //   412: ifnull +16 -> 428
    //   415: aload_0
    //   416: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   419: getfield 271	com/tencent/msf/service/protocol/push/a/d:e	[B
    //   422: arraylength
    //   423: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   426: astore 18
    //   428: aload 20
    //   430: aload 18
    //   432: invokevirtual 523	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload 20
    //   438: ldc_w 1161
    //   441: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload 20
    //   447: aload_0
    //   448: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   451: getfield 724	com/tencent/msf/service/protocol/push/a/d:r	S
    //   454: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 20
    //   460: ldc_w 1500
    //   463: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload 20
    //   469: aload_0
    //   470: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   473: getfield 1305	com/tencent/msf/service/protocol/push/a/d:j	J
    //   476: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload 20
    //   482: ldc_w 1502
    //   485: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload 20
    //   491: aload_0
    //   492: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   495: getfield 1311	com/tencent/msf/service/protocol/push/a/d:k	J
    //   498: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload 20
    //   504: ldc_w 1504
    //   507: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload 20
    //   513: aload_0
    //   514: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   517: getfield 1313	com/tencent/msf/service/protocol/push/a/d:l	J
    //   520: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 20
    //   526: ldc_w 1506
    //   529: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload 20
    //   535: aload_0
    //   536: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   539: getfield 1317	com/tencent/msf/service/protocol/push/a/d:m	J
    //   542: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: aload 20
    //   548: ldc_w 1508
    //   551: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload 20
    //   557: aload_0
    //   558: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   561: getfield 1510	com/tencent/msf/service/protocol/push/a/d:n	J
    //   564: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: aload 20
    //   570: ldc_w 1512
    //   573: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload 20
    //   579: aload_0
    //   580: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   583: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   586: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload 20
    //   592: ldc_w 1165
    //   595: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload 20
    //   601: aload_0
    //   602: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   605: getfield 1167	com/tencent/msf/service/protocol/push/a/d:u	Ljava/lang/String;
    //   608: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload 20
    //   614: ldc_w 1173
    //   617: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: pop
    //   621: aload 20
    //   623: aload_0
    //   624: getfield 132	com/tencent/mobileqq/msf/core/net/c/f:q	Lcom/tencent/mobileqq/msf/core/net/c/f$d;
    //   627: getfield 1175	com/tencent/mobileqq/msf/core/net/c/f$d:j	Ljava/lang/String;
    //   630: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: pop
    //   634: aload 20
    //   636: ldc_w 1177
    //   639: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload 20
    //   645: aload_0
    //   646: getfield 132	com/tencent/mobileqq/msf/core/net/c/f:q	Lcom/tencent/mobileqq/msf/core/net/c/f$d;
    //   649: getfield 1179	com/tencent/mobileqq/msf/core/net/c/f$d:l	J
    //   652: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   655: pop
    //   656: aload 20
    //   658: ldc_w 1181
    //   661: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: pop
    //   665: aload 20
    //   667: aload_0
    //   668: getfield 132	com/tencent/mobileqq/msf/core/net/c/f:q	Lcom/tencent/mobileqq/msf/core/net/c/f$d;
    //   671: getfield 1183	com/tencent/mobileqq/msf/core/net/c/f$d:m	Ljava/lang/String;
    //   674: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: pop
    //   678: aload 20
    //   680: ldc_w 1514
    //   683: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: aload 20
    //   689: aload_0
    //   690: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   693: getfield 271	com/tencent/msf/service/protocol/push/a/d:e	[B
    //   696: invokestatic 1518	java/util/Arrays:toString	([B)Ljava/lang/String;
    //   699: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: pop
    //   703: aload 20
    //   705: ldc_w 1520
    //   708: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: aload 20
    //   714: aload_0
    //   715: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   718: getfield 620	com/tencent/msf/service/protocol/push/a/d:y	S
    //   721: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   724: pop
    //   725: ldc 255
    //   727: iconst_2
    //   728: aload 20
    //   730: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   736: aload_0
    //   737: getfield 170	com/tencent/mobileqq/msf/core/net/c/f:d	I
    //   740: istore_1
    //   741: iload_1
    //   742: iconst_1
    //   743: if_icmple +51 -> 794
    //   746: aload_0
    //   747: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   750: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   753: invokevirtual 692	java/util/ArrayList:size	()I
    //   756: sipush 200
    //   759: if_icmple +175 -> 934
    //   762: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   765: ifeq +12 -> 777
    //   768: ldc 255
    //   770: iconst_4
    //   771: ldc_w 1522
    //   774: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: aload_0
    //   778: iconst_0
    //   779: putfield 134	com/tencent/mobileqq/msf/core/net/c/f:V	Z
    //   782: aload_0
    //   783: getstatic 1187	com/tencent/mobileqq/msf/core/net/c/f$e$a:m	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   786: iconst_1
    //   787: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   790: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   793: return
    //   794: iload_1
    //   795: iconst_1
    //   796: if_icmpne +66 -> 862
    //   799: aload_0
    //   800: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   803: getfield 1317	com/tencent/msf/service/protocol/push/a/d:m	J
    //   806: ldc2_w 1523
    //   809: land
    //   810: lconst_1
    //   811: lcmp
    //   812: ifeq +50 -> 862
    //   815: aload_0
    //   816: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   819: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   822: invokevirtual 692	java/util/ArrayList:size	()I
    //   825: bipush 75
    //   827: if_icmple +107 -> 934
    //   830: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   833: ifeq +12 -> 845
    //   836: ldc 255
    //   838: iconst_4
    //   839: ldc_w 1185
    //   842: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   845: aload_0
    //   846: iconst_0
    //   847: putfield 134	com/tencent/mobileqq/msf/core/net/c/f:V	Z
    //   850: aload_0
    //   851: getstatic 1187	com/tencent/mobileqq/msf/core/net/c/f$e$a:m	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   854: iconst_1
    //   855: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   858: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   861: return
    //   862: aload_0
    //   863: getfield 170	com/tencent/mobileqq/msf/core/net/c/f:d	I
    //   866: iconst_1
    //   867: if_icmpne +67 -> 934
    //   870: aload_0
    //   871: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   874: getfield 1317	com/tencent/msf/service/protocol/push/a/d:m	J
    //   877: ldc2_w 1523
    //   880: land
    //   881: lconst_1
    //   882: lcmp
    //   883: ifne +51 -> 934
    //   886: aload_0
    //   887: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   890: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   893: invokevirtual 692	java/util/ArrayList:size	()I
    //   896: sipush 200
    //   899: if_icmple +35 -> 934
    //   902: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   905: ifeq +12 -> 917
    //   908: ldc 255
    //   910: iconst_4
    //   911: ldc_w 1522
    //   914: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   917: aload_0
    //   918: iconst_0
    //   919: putfield 134	com/tencent/mobileqq/msf/core/net/c/f:V	Z
    //   922: aload_0
    //   923: getstatic 1187	com/tencent/mobileqq/msf/core/net/c/f$e$a:m	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   926: iconst_1
    //   927: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   930: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   933: return
    //   934: aload_0
    //   935: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   938: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   941: invokevirtual 692	java/util/ArrayList:size	()I
    //   944: ifgt +30 -> 974
    //   947: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   950: ifeq +12 -> 962
    //   953: ldc 255
    //   955: iconst_4
    //   956: ldc_w 1189
    //   959: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   962: aload_0
    //   963: getstatic 1191	com/tencent/mobileqq/msf/core/net/c/f$e$a:n	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   966: iconst_1
    //   967: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   970: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   973: return
    //   974: aload_0
    //   975: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   978: getfield 834	com/tencent/msf/service/protocol/push/a/d:f	J
    //   981: lconst_0
    //   982: lcmp
    //   983: ifgt +30 -> 1013
    //   986: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   989: ifeq +12 -> 1001
    //   992: ldc 255
    //   994: iconst_4
    //   995: ldc_w 1526
    //   998: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1001: aload_0
    //   1002: getstatic 1528	com/tencent/mobileqq/msf/core/net/c/f$e$a:q	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   1005: iconst_1
    //   1006: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   1009: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1012: return
    //   1013: aload_0
    //   1014: getfield 170	com/tencent/mobileqq/msf/core/net/c/f:d	I
    //   1017: istore_1
    //   1018: iload_1
    //   1019: iconst_1
    //   1020: if_icmple +49 -> 1069
    //   1023: aload_0
    //   1024: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1027: getfield 1480	com/tencent/msf/service/protocol/push/a/d:c	J
    //   1030: ldc2_w 1529
    //   1033: lcmp
    //   1034: ifle +172 -> 1206
    //   1037: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1040: ifeq +12 -> 1052
    //   1043: ldc 255
    //   1045: iconst_4
    //   1046: ldc_w 1532
    //   1049: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1052: aload_0
    //   1053: iconst_0
    //   1054: putfield 134	com/tencent/mobileqq/msf/core/net/c/f:V	Z
    //   1057: aload_0
    //   1058: getstatic 1387	com/tencent/mobileqq/msf/core/net/c/f$e$a:l	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   1061: iconst_1
    //   1062: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   1065: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1068: return
    //   1069: iload_1
    //   1070: iconst_1
    //   1071: if_icmpne +65 -> 1136
    //   1074: aload_0
    //   1075: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1078: getfield 1317	com/tencent/msf/service/protocol/push/a/d:m	J
    //   1081: ldc2_w 1523
    //   1084: land
    //   1085: lconst_1
    //   1086: lcmp
    //   1087: ifeq +49 -> 1136
    //   1090: aload_0
    //   1091: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1094: getfield 1480	com/tencent/msf/service/protocol/push/a/d:c	J
    //   1097: ldc2_w 1382
    //   1100: lcmp
    //   1101: ifle +105 -> 1206
    //   1104: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1107: ifeq +12 -> 1119
    //   1110: ldc 255
    //   1112: iconst_4
    //   1113: ldc_w 1385
    //   1116: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1119: aload_0
    //   1120: iconst_0
    //   1121: putfield 134	com/tencent/mobileqq/msf/core/net/c/f:V	Z
    //   1124: aload_0
    //   1125: getstatic 1387	com/tencent/mobileqq/msf/core/net/c/f$e$a:l	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   1128: iconst_1
    //   1129: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   1132: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1135: return
    //   1136: aload_0
    //   1137: getfield 170	com/tencent/mobileqq/msf/core/net/c/f:d	I
    //   1140: iconst_1
    //   1141: if_icmpne +65 -> 1206
    //   1144: aload_0
    //   1145: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1148: getfield 1317	com/tencent/msf/service/protocol/push/a/d:m	J
    //   1151: ldc2_w 1523
    //   1154: land
    //   1155: lconst_1
    //   1156: lcmp
    //   1157: ifne +49 -> 1206
    //   1160: aload_0
    //   1161: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1164: getfield 1480	com/tencent/msf/service/protocol/push/a/d:c	J
    //   1167: ldc2_w 1529
    //   1170: lcmp
    //   1171: ifle +35 -> 1206
    //   1174: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1177: ifeq +12 -> 1189
    //   1180: ldc 255
    //   1182: iconst_4
    //   1183: ldc_w 1532
    //   1186: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1189: aload_0
    //   1190: iconst_0
    //   1191: putfield 134	com/tencent/mobileqq/msf/core/net/c/f:V	Z
    //   1194: aload_0
    //   1195: getstatic 1387	com/tencent/mobileqq/msf/core/net/c/f$e$a:l	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   1198: iconst_1
    //   1199: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   1202: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1205: return
    //   1206: aload_0
    //   1207: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1210: getfield 1317	com/tencent/msf/service/protocol/push/a/d:m	J
    //   1213: bipush 8
    //   1215: lshr
    //   1216: ldc2_w 1523
    //   1219: land
    //   1220: ldc2_w 1382
    //   1223: lcmp
    //   1224: ifle +35 -> 1259
    //   1227: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1230: ifeq +12 -> 1242
    //   1233: ldc 255
    //   1235: iconst_4
    //   1236: ldc_w 1534
    //   1239: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1242: aload_0
    //   1243: iconst_0
    //   1244: putfield 134	com/tencent/mobileqq/msf/core/net/c/f:V	Z
    //   1247: aload_0
    //   1248: getstatic 1387	com/tencent/mobileqq/msf/core/net/c/f$e$a:l	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   1251: iconst_1
    //   1252: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   1255: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1258: return
    //   1259: aload_0
    //   1260: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1263: getfield 1193	com/tencent/msf/service/protocol/push/a/d:h	J
    //   1266: ldc2_w 1194
    //   1269: lmul
    //   1270: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   1273: lcmp
    //   1274: ifge +81 -> 1355
    //   1277: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1280: ifeq +63 -> 1343
    //   1283: new 241	java/lang/StringBuilder
    //   1286: dup
    //   1287: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1290: astore 18
    //   1292: aload 18
    //   1294: ldc_w 1197
    //   1297: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: pop
    //   1301: aload 18
    //   1303: aload_0
    //   1304: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1307: getfield 1193	com/tencent/msf/service/protocol/push/a/d:h	J
    //   1310: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1313: pop
    //   1314: aload 18
    //   1316: ldc_w 1199
    //   1319: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1322: pop
    //   1323: aload 18
    //   1325: invokestatic 323	java/lang/System:currentTimeMillis	()J
    //   1328: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1331: pop
    //   1332: ldc 255
    //   1334: iconst_4
    //   1335: aload 18
    //   1337: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1340: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1343: aload_0
    //   1344: getstatic 1201	com/tencent/mobileqq/msf/core/net/c/f$e$a:j	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   1347: iconst_1
    //   1348: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   1351: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1354: return
    //   1355: aload_0
    //   1356: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1359: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   1362: ifeq +94 -> 1456
    //   1365: iconst_1
    //   1366: aload_0
    //   1367: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1370: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   1373: if_icmpeq +83 -> 1456
    //   1376: iconst_2
    //   1377: aload_0
    //   1378: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1381: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   1384: if_icmpeq +72 -> 1456
    //   1387: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1390: ifeq +54 -> 1444
    //   1393: new 241	java/lang/StringBuilder
    //   1396: dup
    //   1397: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1400: astore 18
    //   1402: aload 18
    //   1404: ldc_w 1536
    //   1407: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1410: pop
    //   1411: aload 18
    //   1413: aload_0
    //   1414: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1417: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   1420: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1423: pop
    //   1424: aload 18
    //   1426: ldc_w 1538
    //   1429: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: pop
    //   1433: ldc 255
    //   1435: iconst_2
    //   1436: aload 18
    //   1438: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1441: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1444: aload_0
    //   1445: getstatic 1540	com/tencent/mobileqq/msf/core/net/c/f$e$a:w	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   1448: iconst_1
    //   1449: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   1452: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1455: return
    //   1456: aload_0
    //   1457: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1460: getfield 1343	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   1463: ifnull +2857 -> 4320
    //   1466: aload_0
    //   1467: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1470: getfield 1343	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   1473: arraylength
    //   1474: ifle +2846 -> 4320
    //   1477: aload_0
    //   1478: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1481: getfield 1343	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   1484: arraylength
    //   1485: istore_1
    //   1486: goto +3 -> 1489
    //   1489: iload_1
    //   1490: i2l
    //   1491: lstore 9
    //   1493: aload_0
    //   1494: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1497: getfield 271	com/tencent/msf/service/protocol/push/a/d:e	[B
    //   1500: arraylength
    //   1501: i2l
    //   1502: lstore 11
    //   1504: aload_0
    //   1505: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1508: getfield 834	com/tencent/msf/service/protocol/push/a/d:f	J
    //   1511: lstore 13
    //   1513: lload 11
    //   1515: invokestatic 1408	java/lang/Long:signum	(J)I
    //   1518: pop
    //   1519: lload 9
    //   1521: lload 11
    //   1523: lload 13
    //   1525: lmul
    //   1526: ladd
    //   1527: l2i
    //   1528: istore_1
    //   1529: iload_1
    //   1530: istore 6
    //   1532: aload_0
    //   1533: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1536: getfield 1494	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   1539: ifnull +29 -> 1568
    //   1542: iload_1
    //   1543: istore 6
    //   1545: aload_0
    //   1546: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1549: getfield 1494	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   1552: arraylength
    //   1553: ifle +15 -> 1568
    //   1556: iload_1
    //   1557: aload_0
    //   1558: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1561: getfield 1494	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   1564: arraylength
    //   1565: iadd
    //   1566: istore 6
    //   1568: new 241	java/lang/StringBuilder
    //   1571: dup
    //   1572: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1575: astore 18
    //   1577: aload 18
    //   1579: ldc_w 1542
    //   1582: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1585: pop
    //   1586: aload 18
    //   1588: iload 6
    //   1590: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1593: pop
    //   1594: ldc 255
    //   1596: iconst_1
    //   1597: aload 18
    //   1599: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1602: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1605: aload_0
    //   1606: getfield 166	com/tencent/mobileqq/msf/core/net/c/f:a	Lcom/tencent/mobileqq/msf/core/net/c/f$b;
    //   1609: getstatic 232	com/tencent/mobileqq/msf/core/net/c/f$b:c	Lcom/tencent/mobileqq/msf/core/net/c/f$b;
    //   1612: if_acmpne +21 -> 1633
    //   1615: iload 6
    //   1617: ifne +11 -> 1628
    //   1620: aload_0
    //   1621: iconst_1
    //   1622: putfield 114	com/tencent/mobileqq/msf/core/net/c/f:l	I
    //   1625: goto +8 -> 1633
    //   1628: aload_0
    //   1629: iconst_0
    //   1630: putfield 114	com/tencent/mobileqq/msf/core/net/c/f:l	I
    //   1633: aload_0
    //   1634: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1637: getfield 1481	com/tencent/msf/service/protocol/push/a/d:d	J
    //   1640: ldc2_w 1415
    //   1643: lcmp
    //   1644: ifge +75 -> 1719
    //   1647: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1650: ifeq +54 -> 1704
    //   1653: new 241	java/lang/StringBuilder
    //   1656: dup
    //   1657: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   1660: astore 18
    //   1662: aload 18
    //   1664: ldc_w 1418
    //   1667: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1670: pop
    //   1671: aload 18
    //   1673: aload_0
    //   1674: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1677: getfield 1481	com/tencent/msf/service/protocol/push/a/d:d	J
    //   1680: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1683: pop
    //   1684: aload 18
    //   1686: ldc_w 1414
    //   1689: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1692: pop
    //   1693: ldc 255
    //   1695: iconst_4
    //   1696: aload 18
    //   1698: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1701: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1704: aload_0
    //   1705: getstatic 1420	com/tencent/mobileqq/msf/core/net/c/f$e$a:g	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   1708: iconst_1
    //   1709: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   1712: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1715: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   1718: return
    //   1719: iconst_0
    //   1720: istore_1
    //   1721: iconst_0
    //   1722: istore_3
    //   1723: iload_1
    //   1724: aload_0
    //   1725: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   1728: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   1731: invokevirtual 692	java/util/ArrayList:size	()I
    //   1734: if_icmpge +2544 -> 4278
    //   1737: iload_3
    //   1738: ifeq +6 -> 1744
    //   1741: goto +2537 -> 4278
    //   1744: aload_0
    //   1745: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1748: new 346	java/util/ArrayList
    //   1751: dup
    //   1752: invokespecial 884	java/util/ArrayList:<init>	()V
    //   1755: putfield 1395	com/tencent/mobileqq/msf/core/net/c/f$e:y	Ljava/util/ArrayList;
    //   1758: aload_0
    //   1759: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1762: iconst_0
    //   1763: putfield 391	com/tencent/mobileqq/msf/core/net/c/f$e:k	I
    //   1766: aload_0
    //   1767: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1770: iconst_0
    //   1771: putfield 472	com/tencent/mobileqq/msf/core/net/c/f$e:n	I
    //   1774: aload_0
    //   1775: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1778: iconst_0
    //   1779: putfield 806	com/tencent/mobileqq/msf/core/net/c/f$e:l	I
    //   1782: aload_0
    //   1783: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1786: iconst_0
    //   1787: putfield 454	com/tencent/mobileqq/msf/core/net/c/f$e:m	I
    //   1790: aload_0
    //   1791: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1794: iconst_0
    //   1795: putfield 764	com/tencent/mobileqq/msf/core/net/c/f$e:o	I
    //   1798: aload_0
    //   1799: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1802: getfield 178	com/tencent/mobileqq/msf/core/net/c/f$e:c	Ljava/util/Map;
    //   1805: invokeinterface 1231 1 0
    //   1810: aload_0
    //   1811: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1814: iconst_0
    //   1815: putfield 1544	com/tencent/mobileqq/msf/core/net/c/f$e:x	Z
    //   1818: aload_0
    //   1819: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1822: aconst_null
    //   1823: putfield 1546	com/tencent/mobileqq/msf/core/net/c/f$e:A	Ljava/lang/String;
    //   1826: aload_0
    //   1827: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1830: getfield 737	com/tencent/mobileqq/msf/core/net/c/f$e:I	Ljava/util/ArrayList;
    //   1833: invokevirtual 1396	java/util/ArrayList:clear	()V
    //   1836: aload_0
    //   1837: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1840: getfield 384	com/tencent/mobileqq/msf/core/net/c/f$e:J	Ljava/util/ArrayList;
    //   1843: invokevirtual 1396	java/util/ArrayList:clear	()V
    //   1846: aload_0
    //   1847: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1850: aconst_null
    //   1851: putfield 451	com/tencent/mobileqq/msf/core/net/c/f$e:d	Ljava/net/InetAddress;
    //   1854: aload_0
    //   1855: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1858: lconst_0
    //   1859: putfield 948	com/tencent/mobileqq/msf/core/net/c/f$e:D	J
    //   1862: aload_0
    //   1863: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1866: iconst_0
    //   1867: putfield 950	com/tencent/mobileqq/msf/core/net/c/f$e:E	I
    //   1870: aload_0
    //   1871: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1874: iconst_0
    //   1875: putfield 436	com/tencent/mobileqq/msf/core/net/c/f$e:F	I
    //   1878: aload_0
    //   1879: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1882: iconst_0
    //   1883: putfield 312	com/tencent/mobileqq/msf/core/net/c/f$e:G	I
    //   1886: aload_0
    //   1887: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1890: invokestatic 208	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   1893: putfield 899	com/tencent/mobileqq/msf/core/net/c/f$e:g	I
    //   1896: aload_0
    //   1897: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1900: invokestatic 1207	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getWifiStrength	()I
    //   1903: putfield 1209	com/tencent/mobileqq/msf/core/net/c/f$e:h	I
    //   1906: aload_0
    //   1907: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1910: invokestatic 1212	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getCdmaStrength	()I
    //   1913: putfield 1214	com/tencent/mobileqq/msf/core/net/c/f$e:j	I
    //   1916: aload_0
    //   1917: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   1920: invokestatic 1217	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getGsmStrength	()I
    //   1923: putfield 1219	com/tencent/mobileqq/msf/core/net/c/f$e:i	I
    //   1926: goto +18 -> 1944
    //   1929: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1932: ifeq +12 -> 1944
    //   1935: ldc 255
    //   1937: iconst_4
    //   1938: ldc_w 1398
    //   1941: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1944: aload_0
    //   1945: lconst_0
    //   1946: putfield 154	com/tencent/mobileqq/msf/core/net/c/f:A	J
    //   1949: aload_0
    //   1950: lconst_0
    //   1951: putfield 158	com/tencent/mobileqq/msf/core/net/c/f:C	J
    //   1954: aload_0
    //   1955: lconst_0
    //   1956: putfield 156	com/tencent/mobileqq/msf/core/net/c/f:B	J
    //   1959: aload_0
    //   1960: lconst_0
    //   1961: putfield 160	com/tencent/mobileqq/msf/core/net/c/f:D	J
    //   1964: invokestatic 1286	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isWifiConn	()Z
    //   1967: ifeq +173 -> 2140
    //   1970: invokestatic 1207	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getWifiStrength	()I
    //   1973: bipush 10
    //   1975: if_icmple +165 -> 2140
    //   1978: getstatic 1548	com/tencent/mobileqq/msf/core/net/c/k:e	Ljava/lang/String;
    //   1981: aload 24
    //   1983: invokevirtual 504	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1986: istore 15
    //   1988: iload 15
    //   1990: ifeq +64 -> 2054
    //   1993: aload_0
    //   1994: getfield 172	com/tencent/mobileqq/msf/core/net/c/f:e	I
    //   1997: ifeq +57 -> 2054
    //   2000: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2003: ifeq +2275 -> 4278
    //   2006: new 241	java/lang/StringBuilder
    //   2009: dup
    //   2010: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   2013: astore 18
    //   2015: aload 18
    //   2017: aload 22
    //   2019: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2022: pop
    //   2023: aload 18
    //   2025: invokestatic 1552	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2028: invokevirtual 1555	java/lang/Thread:getName	()Ljava/lang/String;
    //   2031: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2034: pop
    //   2035: ldc 255
    //   2037: iconst_2
    //   2038: aload 18
    //   2040: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2043: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2046: goto +2232 -> 4278
    //   2049: astore 18
    //   2051: goto +382 -> 2433
    //   2054: aload_0
    //   2055: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2058: getfield 1317	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2061: ldc2_w 1523
    //   2064: land
    //   2065: lconst_1
    //   2066: lcmp
    //   2067: ifne +57 -> 2124
    //   2070: aload_0
    //   2071: getfield 170	com/tencent/mobileqq/msf/core/net/c/f:d	I
    //   2074: iconst_1
    //   2075: if_icmple +37 -> 2112
    //   2078: aload_0
    //   2079: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2082: getfield 1480	com/tencent/msf/service/protocol/push/a/d:c	J
    //   2085: lstore 9
    //   2087: aload_0
    //   2088: getfield 170	com/tencent/mobileqq/msf/core/net/c/f:d	I
    //   2091: istore 4
    //   2093: iload_1
    //   2094: istore_2
    //   2095: iload 4
    //   2097: i2l
    //   2098: lstore 11
    //   2100: lload 9
    //   2102: lload 11
    //   2104: ldiv
    //   2105: lstore 9
    //   2107: iload_2
    //   2108: istore_1
    //   2109: goto +358 -> 2467
    //   2112: aload_0
    //   2113: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2116: getfield 1317	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2119: lstore 9
    //   2121: goto +2204 -> 4325
    //   2124: iload_1
    //   2125: istore_2
    //   2126: aload_0
    //   2127: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2130: getfield 1480	com/tencent/msf/service/protocol/push/a/d:c	J
    //   2133: lstore 9
    //   2135: iload_2
    //   2136: istore_1
    //   2137: goto +330 -> 2467
    //   2140: iload_1
    //   2141: istore_2
    //   2142: aload 24
    //   2144: putstatic 1548	com/tencent/mobileqq/msf/core/net/c/k:e	Ljava/lang/String;
    //   2147: aload_0
    //   2148: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2151: getfield 1317	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2154: ldc2_w 1523
    //   2157: land
    //   2158: lconst_1
    //   2159: lcmp
    //   2160: ifne +252 -> 2412
    //   2163: aload_0
    //   2164: getfield 170	com/tencent/mobileqq/msf/core/net/c/f:d	I
    //   2167: iconst_1
    //   2168: if_icmple +232 -> 2400
    //   2171: aload_0
    //   2172: getfield 172	com/tencent/mobileqq/msf/core/net/c/f:e	I
    //   2175: ifeq +52 -> 2227
    //   2178: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2181: ifeq +2097 -> 4278
    //   2184: new 241	java/lang/StringBuilder
    //   2187: dup
    //   2188: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   2191: astore 18
    //   2193: aload 18
    //   2195: aload 22
    //   2197: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2200: pop
    //   2201: aload 18
    //   2203: invokestatic 1552	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   2206: invokevirtual 1555	java/lang/Thread:getName	()Ljava/lang/String;
    //   2209: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2212: pop
    //   2213: ldc 255
    //   2215: iconst_2
    //   2216: aload 18
    //   2218: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2221: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2224: goto +2054 -> 4278
    //   2227: aload_0
    //   2228: iconst_1
    //   2229: putfield 170	com/tencent/mobileqq/msf/core/net/c/f:d	I
    //   2232: aload_0
    //   2233: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2236: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   2239: invokevirtual 692	java/util/ArrayList:size	()I
    //   2242: bipush 75
    //   2244: if_icmple +80 -> 2324
    //   2247: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2250: ifeq +12 -> 2262
    //   2253: ldc 255
    //   2255: iconst_4
    //   2256: ldc_w 1185
    //   2259: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2262: aload_0
    //   2263: getfield 122	com/tencent/mobileqq/msf/core/net/c/f:S	Ljava/lang/String;
    //   2266: aload 23
    //   2268: invokevirtual 223	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2271: istore_1
    //   2272: iload_1
    //   2273: iconst_m1
    //   2274: if_icmpeq +18 -> 2292
    //   2277: aload_0
    //   2278: aload_0
    //   2279: getfield 122	com/tencent/mobileqq/msf/core/net/c/f:S	Ljava/lang/String;
    //   2282: iconst_0
    //   2283: iload_1
    //   2284: iconst_1
    //   2285: iadd
    //   2286: invokevirtual 751	java/lang/String:substring	(II)Ljava/lang/String;
    //   2289: putfield 122	com/tencent/mobileqq/msf/core/net/c/f:S	Ljava/lang/String;
    //   2292: aload_0
    //   2293: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   2296: getfield 178	com/tencent/mobileqq/msf/core/net/c/f$e:c	Ljava/util/Map;
    //   2299: invokeinterface 1231 1 0
    //   2304: aload_0
    //   2305: iconst_0
    //   2306: putfield 134	com/tencent/mobileqq/msf/core/net/c/f:V	Z
    //   2309: aload_0
    //   2310: getstatic 1187	com/tencent/mobileqq/msf/core/net/c/f$e$a:m	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   2313: iconst_1
    //   2314: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   2317: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   2320: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   2323: return
    //   2324: aload_0
    //   2325: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2328: getfield 1317	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2331: lstore 9
    //   2333: lload 9
    //   2335: bipush 8
    //   2337: lshr
    //   2338: ldc2_w 1523
    //   2341: land
    //   2342: lstore 9
    //   2344: aload_0
    //   2345: getfield 122	com/tencent/mobileqq/msf/core/net/c/f:S	Ljava/lang/String;
    //   2348: aload 23
    //   2350: invokevirtual 223	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2353: istore_1
    //   2354: iload_1
    //   2355: iconst_m1
    //   2356: if_icmpeq +18 -> 2374
    //   2359: aload_0
    //   2360: aload_0
    //   2361: getfield 122	com/tencent/mobileqq/msf/core/net/c/f:S	Ljava/lang/String;
    //   2364: iconst_0
    //   2365: iload_1
    //   2366: iconst_1
    //   2367: iadd
    //   2368: invokevirtual 751	java/lang/String:substring	(II)Ljava/lang/String;
    //   2371: putfield 122	com/tencent/mobileqq/msf/core/net/c/f:S	Ljava/lang/String;
    //   2374: iconst_m1
    //   2375: istore_1
    //   2376: goto +91 -> 2467
    //   2379: astore 18
    //   2381: iconst_m1
    //   2382: istore_2
    //   2383: lload 9
    //   2385: lstore 11
    //   2387: goto +51 -> 2438
    //   2390: astore 18
    //   2392: lconst_1
    //   2393: lstore 11
    //   2395: iconst_m1
    //   2396: istore_2
    //   2397: goto +41 -> 2438
    //   2400: aload_0
    //   2401: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2404: getfield 1317	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2407: lstore 9
    //   2409: goto +1916 -> 4325
    //   2412: aload_0
    //   2413: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2416: getfield 1480	com/tencent/msf/service/protocol/push/a/d:c	J
    //   2419: lstore 9
    //   2421: iload_2
    //   2422: istore_1
    //   2423: goto +44 -> 2467
    //   2426: astore 18
    //   2428: goto +5 -> 2433
    //   2431: astore 18
    //   2433: lconst_1
    //   2434: lstore 11
    //   2436: iload_1
    //   2437: istore_2
    //   2438: lload 11
    //   2440: lstore 9
    //   2442: iload_2
    //   2443: istore_1
    //   2444: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2447: ifeq +20 -> 2467
    //   2450: ldc 255
    //   2452: iconst_4
    //   2453: ldc_w 1557
    //   2456: aload 18
    //   2458: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2461: iload_2
    //   2462: istore_1
    //   2463: lload 11
    //   2465: lstore 9
    //   2467: iconst_0
    //   2468: istore_2
    //   2469: iconst_1
    //   2470: istore 15
    //   2472: iload_2
    //   2473: i2l
    //   2474: lload 9
    //   2476: lcmp
    //   2477: ifge +1885 -> 4362
    //   2480: iload_1
    //   2481: iconst_m1
    //   2482: if_icmpne +6 -> 2488
    //   2485: goto +1877 -> 4362
    //   2488: invokestatic 1286	com/tencent/mobileqq/msf/core/NetConnInfoCenter:isWifiConn	()Z
    //   2491: istore 16
    //   2493: iload 16
    //   2495: ifeq +239 -> 2734
    //   2498: invokestatic 1207	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getWifiStrength	()I
    //   2501: bipush 10
    //   2503: if_icmple +231 -> 2734
    //   2506: getstatic 1548	com/tencent/mobileqq/msf/core/net/c/k:e	Ljava/lang/String;
    //   2509: aload 24
    //   2511: invokevirtual 504	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2514: ifeq +105 -> 2619
    //   2517: aload_0
    //   2518: getfield 172	com/tencent/mobileqq/msf/core/net/c/f:e	I
    //   2521: istore 4
    //   2523: iload 4
    //   2525: ifeq +94 -> 2619
    //   2528: aload_0
    //   2529: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2532: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   2535: invokevirtual 692	java/util/ArrayList:size	()I
    //   2538: istore_3
    //   2539: iload_3
    //   2540: istore_1
    //   2541: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2544: ifeq +49 -> 2593
    //   2547: iload_3
    //   2548: istore_1
    //   2549: new 241	java/lang/StringBuilder
    //   2552: dup
    //   2553: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   2556: astore 18
    //   2558: iload_3
    //   2559: istore_1
    //   2560: aload 18
    //   2562: aload 22
    //   2564: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2567: pop
    //   2568: iload_3
    //   2569: istore_1
    //   2570: aload 18
    //   2572: aload_0
    //   2573: getfield 172	com/tencent/mobileqq/msf/core/net/c/f:e	I
    //   2576: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2579: pop
    //   2580: iload_3
    //   2581: istore_1
    //   2582: ldc 255
    //   2584: iconst_2
    //   2585: aload 18
    //   2587: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2590: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2593: iconst_1
    //   2594: istore_2
    //   2595: iload_3
    //   2596: istore_1
    //   2597: iload_2
    //   2598: istore_3
    //   2599: goto +1544 -> 4143
    //   2602: astore 18
    //   2604: iload_2
    //   2605: istore_3
    //   2606: iload_1
    //   2607: istore 4
    //   2609: iconst_1
    //   2610: istore_2
    //   2611: iload_3
    //   2612: istore_1
    //   2613: iload 4
    //   2615: istore_3
    //   2616: goto +532 -> 3148
    //   2619: aload_0
    //   2620: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2623: getfield 1317	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2626: ldc2_w 1523
    //   2629: land
    //   2630: lconst_1
    //   2631: lcmp
    //   2632: ifne +68 -> 2700
    //   2635: aload_0
    //   2636: getfield 170	com/tencent/mobileqq/msf/core/net/c/f:d	I
    //   2639: iconst_1
    //   2640: if_icmple +37 -> 2677
    //   2643: aload_0
    //   2644: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2647: getfield 1480	com/tencent/msf/service/protocol/push/a/d:c	J
    //   2650: lstore 11
    //   2652: aload_0
    //   2653: getfield 170	com/tencent/mobileqq/msf/core/net/c/f:d	I
    //   2656: istore 4
    //   2658: iload 4
    //   2660: i2l
    //   2661: lstore 13
    //   2663: lload 11
    //   2665: lload 13
    //   2667: ldiv
    //   2668: lstore 11
    //   2670: lload 11
    //   2672: lstore 9
    //   2674: goto +39 -> 2713
    //   2677: aload_0
    //   2678: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2681: getfield 1317	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2684: bipush 8
    //   2686: lshr
    //   2687: ldc2_w 1523
    //   2690: land
    //   2691: lstore 11
    //   2693: lload 11
    //   2695: lstore 9
    //   2697: goto +409 -> 3106
    //   2700: aload_0
    //   2701: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2704: getfield 1480	com/tencent/msf/service/protocol/push/a/d:c	J
    //   2707: lstore 11
    //   2709: lload 11
    //   2711: lstore 9
    //   2713: goto +393 -> 3106
    //   2716: astore 18
    //   2718: goto +5 -> 2723
    //   2721: astore 18
    //   2723: iload_1
    //   2724: istore 4
    //   2726: iload_2
    //   2727: istore_1
    //   2728: iload 4
    //   2730: istore_2
    //   2731: goto +409 -> 3140
    //   2734: iload_2
    //   2735: istore 4
    //   2737: iload_1
    //   2738: istore 5
    //   2740: aload 24
    //   2742: putstatic 1548	com/tencent/mobileqq/msf/core/net/c/k:e	Ljava/lang/String;
    //   2745: aload_0
    //   2746: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2749: getfield 1317	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2752: lstore 11
    //   2754: lload 11
    //   2756: ldc2_w 1523
    //   2759: land
    //   2760: lconst_1
    //   2761: lcmp
    //   2762: ifne +331 -> 3093
    //   2765: aload_0
    //   2766: getfield 170	com/tencent/mobileqq/msf/core/net/c/f:d	I
    //   2769: istore 7
    //   2771: iload 7
    //   2773: iconst_1
    //   2774: if_icmple +280 -> 3054
    //   2777: aload_0
    //   2778: getfield 172	com/tencent/mobileqq/msf/core/net/c/f:e	I
    //   2781: istore_1
    //   2782: iload_1
    //   2783: ifeq +83 -> 2866
    //   2786: aload_0
    //   2787: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2790: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   2793: invokevirtual 692	java/util/ArrayList:size	()I
    //   2796: istore_1
    //   2797: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2800: ifeq +41 -> 2841
    //   2803: new 241	java/lang/StringBuilder
    //   2806: dup
    //   2807: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   2810: astore 18
    //   2812: aload 18
    //   2814: aload 22
    //   2816: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2819: pop
    //   2820: aload 18
    //   2822: aload_0
    //   2823: getfield 172	com/tencent/mobileqq/msf/core/net/c/f:e	I
    //   2826: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2829: pop
    //   2830: ldc 255
    //   2832: iconst_2
    //   2833: aload 18
    //   2835: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2838: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2841: iconst_1
    //   2842: istore_3
    //   2843: goto +1300 -> 4143
    //   2846: astore 18
    //   2848: iload_1
    //   2849: istore_3
    //   2850: goto +8 -> 2858
    //   2853: astore 18
    //   2855: iload 5
    //   2857: istore_3
    //   2858: iconst_1
    //   2859: istore_2
    //   2860: iload 4
    //   2862: istore_1
    //   2863: goto +285 -> 3148
    //   2866: aload_0
    //   2867: iconst_1
    //   2868: putfield 170	com/tencent/mobileqq/msf/core/net/c/f:d	I
    //   2871: aload_0
    //   2872: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2875: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   2878: invokevirtual 692	java/util/ArrayList:size	()I
    //   2881: istore_1
    //   2882: iload_1
    //   2883: bipush 75
    //   2885: if_icmple +80 -> 2965
    //   2888: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2891: ifeq +12 -> 2903
    //   2894: ldc 255
    //   2896: iconst_4
    //   2897: ldc_w 1185
    //   2900: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2903: aload_0
    //   2904: getfield 122	com/tencent/mobileqq/msf/core/net/c/f:S	Ljava/lang/String;
    //   2907: aload 23
    //   2909: invokevirtual 223	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2912: istore_1
    //   2913: iload_1
    //   2914: iconst_m1
    //   2915: if_icmpeq +18 -> 2933
    //   2918: aload_0
    //   2919: aload_0
    //   2920: getfield 122	com/tencent/mobileqq/msf/core/net/c/f:S	Ljava/lang/String;
    //   2923: iconst_0
    //   2924: iload_1
    //   2925: iconst_1
    //   2926: iadd
    //   2927: invokevirtual 751	java/lang/String:substring	(II)Ljava/lang/String;
    //   2930: putfield 122	com/tencent/mobileqq/msf/core/net/c/f:S	Ljava/lang/String;
    //   2933: aload_0
    //   2934: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   2937: getfield 178	com/tencent/mobileqq/msf/core/net/c/f$e:c	Ljava/util/Map;
    //   2940: invokeinterface 1231 1 0
    //   2945: aload_0
    //   2946: iconst_0
    //   2947: putfield 134	com/tencent/mobileqq/msf/core/net/c/f:V	Z
    //   2950: aload_0
    //   2951: getstatic 1187	com/tencent/mobileqq/msf/core/net/c/f$e$a:m	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   2954: iconst_1
    //   2955: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   2958: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   2961: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   2964: return
    //   2965: aload_0
    //   2966: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   2969: getfield 1317	com/tencent/msf/service/protocol/push/a/d:m	J
    //   2972: lstore 11
    //   2974: aload_0
    //   2975: getfield 122	com/tencent/mobileqq/msf/core/net/c/f:S	Ljava/lang/String;
    //   2978: aload 23
    //   2980: invokevirtual 223	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   2983: istore_1
    //   2984: iload_1
    //   2985: iconst_m1
    //   2986: if_icmpeq +18 -> 3004
    //   2989: aload_0
    //   2990: aload_0
    //   2991: getfield 122	com/tencent/mobileqq/msf/core/net/c/f:S	Ljava/lang/String;
    //   2994: iconst_0
    //   2995: iload_1
    //   2996: iconst_1
    //   2997: iadd
    //   2998: invokevirtual 751	java/lang/String:substring	(II)Ljava/lang/String;
    //   3001: putfield 122	com/tencent/mobileqq/msf/core/net/c/f:S	Ljava/lang/String;
    //   3004: iconst_m1
    //   3005: istore_1
    //   3006: goto +1137 -> 4143
    //   3009: astore 18
    //   3011: lload 11
    //   3013: bipush 8
    //   3015: lshr
    //   3016: ldc2_w 1523
    //   3019: land
    //   3020: lstore 9
    //   3022: iconst_0
    //   3023: istore_1
    //   3024: iconst_m1
    //   3025: istore_2
    //   3026: goto +114 -> 3140
    //   3029: astore 18
    //   3031: goto +5 -> 3036
    //   3034: astore 18
    //   3036: iconst_0
    //   3037: istore_1
    //   3038: iconst_m1
    //   3039: istore_2
    //   3040: goto +100 -> 3140
    //   3043: astore 18
    //   3045: iload 4
    //   3047: istore_1
    //   3048: iload 5
    //   3050: istore_2
    //   3051: goto +89 -> 3140
    //   3054: aload_0
    //   3055: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3058: getfield 1317	com/tencent/msf/service/protocol/push/a/d:m	J
    //   3061: lstore 11
    //   3063: lload 11
    //   3065: bipush 8
    //   3067: lshr
    //   3068: ldc2_w 1523
    //   3071: land
    //   3072: lstore 9
    //   3074: goto +32 -> 3106
    //   3077: astore 18
    //   3079: goto +5 -> 3084
    //   3082: astore 18
    //   3084: iload 4
    //   3086: istore_1
    //   3087: iload 5
    //   3089: istore_2
    //   3090: goto +50 -> 3140
    //   3093: aload_0
    //   3094: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3097: getfield 1480	com/tencent/msf/service/protocol/push/a/d:c	J
    //   3100: lstore 11
    //   3102: lload 11
    //   3104: lstore 9
    //   3106: iload_3
    //   3107: istore 4
    //   3109: iload_1
    //   3110: istore_3
    //   3111: goto +59 -> 3170
    //   3114: astore 18
    //   3116: iload 4
    //   3118: istore_1
    //   3119: iload 5
    //   3121: istore_2
    //   3122: goto +18 -> 3140
    //   3125: astore 18
    //   3127: goto +5 -> 3132
    //   3130: astore 18
    //   3132: iload_1
    //   3133: istore 4
    //   3135: iload_2
    //   3136: istore_1
    //   3137: iload 4
    //   3139: istore_2
    //   3140: iload_3
    //   3141: istore 4
    //   3143: iload_2
    //   3144: istore_3
    //   3145: iload 4
    //   3147: istore_2
    //   3148: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3151: ifeq +14 -> 3165
    //   3154: ldc 255
    //   3156: iconst_4
    //   3157: ldc_w 1557
    //   3160: aload 18
    //   3162: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3165: iload_2
    //   3166: istore 4
    //   3168: iload_1
    //   3169: istore_2
    //   3170: aload_0
    //   3171: lconst_0
    //   3172: putfield 136	com/tencent/mobileqq/msf/core/net/c/f:r	J
    //   3175: aload_0
    //   3176: lconst_0
    //   3177: putfield 138	com/tencent/mobileqq/msf/core/net/c/f:s	J
    //   3180: aload_0
    //   3181: lconst_0
    //   3182: putfield 140	com/tencent/mobileqq/msf/core/net/c/f:t	J
    //   3185: aload_0
    //   3186: lconst_0
    //   3187: putfield 142	com/tencent/mobileqq/msf/core/net/c/f:u	J
    //   3190: aload_0
    //   3191: lconst_0
    //   3192: putfield 144	com/tencent/mobileqq/msf/core/net/c/f:v	J
    //   3195: aload_0
    //   3196: lconst_0
    //   3197: putfield 146	com/tencent/mobileqq/msf/core/net/c/f:w	J
    //   3200: aload_0
    //   3201: lconst_0
    //   3202: putfield 148	com/tencent/mobileqq/msf/core/net/c/f:x	J
    //   3205: aload_0
    //   3206: lconst_0
    //   3207: putfield 150	com/tencent/mobileqq/msf/core/net/c/f:y	J
    //   3210: aload_0
    //   3211: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3214: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   3217: iload_3
    //   3218: invokevirtual 1222	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3221: checkcast 607	com/tencent/msf/service/protocol/push/a/a
    //   3224: astore 27
    //   3226: aload_0
    //   3227: aload 27
    //   3229: invokespecial 1559	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/msf/service/protocol/push/a/a;)V
    //   3232: iconst_0
    //   3233: invokestatic 1283	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
    //   3236: istore 8
    //   3238: aload_0
    //   3239: getfield 118	com/tencent/mobileqq/msf/core/net/c/f:n	Ljava/net/InetAddress;
    //   3242: instanceof 514
    //   3245: ifeq +1094 -> 4339
    //   3248: iconst_2
    //   3249: istore 5
    //   3251: goto +3 -> 3254
    //   3254: ldc 120
    //   3256: astore 19
    //   3258: iload 8
    //   3260: iconst_2
    //   3261: if_icmplt +332 -> 3593
    //   3264: aload_0
    //   3265: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3268: getfield 950	com/tencent/mobileqq/msf/core/net/c/f$e:E	I
    //   3271: istore_1
    //   3272: iload_1
    //   3273: iconst_1
    //   3274: if_icmpne +50 -> 3324
    //   3277: invokestatic 1564	com/tencent/mobileqq/msf/core/net/c/b:a	()Lcom/tencent/mobileqq/msf/core/net/c/b;
    //   3280: astore 18
    //   3282: aload_0
    //   3283: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3286: getfield 899	com/tencent/mobileqq/msf/core/net/c/f$e:g	I
    //   3289: istore_1
    //   3290: aload_0
    //   3291: getfield 166	com/tencent/mobileqq/msf/core/net/c/f:a	Lcom/tencent/mobileqq/msf/core/net/c/f$b;
    //   3294: astore 20
    //   3296: aload 18
    //   3298: iconst_1
    //   3299: iload 8
    //   3301: iload_1
    //   3302: iload 5
    //   3304: aload 20
    //   3306: aload 27
    //   3308: getfield 609	com/tencent/msf/service/protocol/push/a/a:c	Ljava/lang/String;
    //   3311: ldc 120
    //   3313: invokevirtual 1567	com/tencent/mobileqq/msf/core/net/c/b:a	(IIIILcom/tencent/mobileqq/msf/core/net/c/f$b;Ljava/lang/String;Ljava/lang/String;)V
    //   3316: goto +8 -> 3324
    //   3319: astore 18
    //   3321: goto +269 -> 3590
    //   3324: aload 19
    //   3326: astore 20
    //   3328: iload 8
    //   3330: iconst_2
    //   3331: if_icmpne +266 -> 3597
    //   3334: aload 19
    //   3336: astore 20
    //   3338: iload 5
    //   3340: iconst_1
    //   3341: if_icmpne +256 -> 3597
    //   3344: aload 19
    //   3346: astore 20
    //   3348: aload 19
    //   3350: astore 21
    //   3352: ldc_w 1569
    //   3355: invokestatic 947	java/net/InetAddress:getAllByName	(Ljava/lang/String;)[Ljava/net/InetAddress;
    //   3358: astore 25
    //   3360: aload 19
    //   3362: astore 18
    //   3364: aload 25
    //   3366: ifnull +174 -> 3540
    //   3369: aload 19
    //   3371: astore 20
    //   3373: aload 19
    //   3375: astore 21
    //   3377: aload 19
    //   3379: astore 18
    //   3381: aload 25
    //   3383: arraylength
    //   3384: ifle +156 -> 3540
    //   3387: aload 19
    //   3389: astore 20
    //   3391: aload 19
    //   3393: astore 21
    //   3395: aload 25
    //   3397: arraylength
    //   3398: istore_1
    //   3399: iconst_0
    //   3400: istore 7
    //   3402: aload 19
    //   3404: astore 18
    //   3406: iload 7
    //   3408: iload_1
    //   3409: if_icmpge +131 -> 3540
    //   3412: aload 25
    //   3414: iload 7
    //   3416: aaload
    //   3417: astore 18
    //   3419: aload 18
    //   3421: ifnull +65 -> 3486
    //   3424: aload 19
    //   3426: astore 26
    //   3428: aload 19
    //   3430: astore 20
    //   3432: aload 19
    //   3434: astore 21
    //   3436: aload 18
    //   3438: instanceof 514
    //   3441: ifeq +49 -> 3490
    //   3444: aload 19
    //   3446: astore 20
    //   3448: aload 19
    //   3450: astore 21
    //   3452: aload 18
    //   3454: invokevirtual 614	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   3457: astore 18
    //   3459: aload 18
    //   3461: astore 20
    //   3463: aload 18
    //   3465: astore 21
    //   3467: aload 18
    //   3469: invokestatic 742	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3472: istore 16
    //   3474: aload 18
    //   3476: astore 26
    //   3478: iload 16
    //   3480: ifne +10 -> 3490
    //   3483: goto +57 -> 3540
    //   3486: aload 19
    //   3488: astore 26
    //   3490: iload 7
    //   3492: iconst_1
    //   3493: iadd
    //   3494: istore 7
    //   3496: aload 26
    //   3498: astore 19
    //   3500: goto -98 -> 3402
    //   3503: astore 18
    //   3505: ldc 255
    //   3507: iconst_1
    //   3508: ldc_w 1571
    //   3511: aload 18
    //   3513: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3516: aload 20
    //   3518: astore 18
    //   3520: goto +20 -> 3540
    //   3523: astore 18
    //   3525: ldc 255
    //   3527: iconst_1
    //   3528: ldc_w 1573
    //   3531: aload 18
    //   3533: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3536: aload 21
    //   3538: astore 18
    //   3540: aload 18
    //   3542: astore 20
    //   3544: aload 18
    //   3546: invokestatic 742	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3549: ifeq +48 -> 3597
    //   3552: invokestatic 1564	com/tencent/mobileqq/msf/core/net/c/b:a	()Lcom/tencent/mobileqq/msf/core/net/c/b;
    //   3555: iconst_2
    //   3556: iload 8
    //   3558: aload_0
    //   3559: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3562: getfield 899	com/tencent/mobileqq/msf/core/net/c/f$e:g	I
    //   3565: iload 5
    //   3567: aload_0
    //   3568: getfield 166	com/tencent/mobileqq/msf/core/net/c/f:a	Lcom/tencent/mobileqq/msf/core/net/c/f$b;
    //   3571: aload 27
    //   3573: getfield 609	com/tencent/msf/service/protocol/push/a/a:c	Ljava/lang/String;
    //   3576: aload 18
    //   3578: invokevirtual 1567	com/tencent/mobileqq/msf/core/net/c/b:a	(IIIILcom/tencent/mobileqq/msf/core/net/c/f$b;Ljava/lang/String;Ljava/lang/String;)V
    //   3581: aload 18
    //   3583: astore 20
    //   3585: goto +12 -> 3597
    //   3588: astore 18
    //   3590: goto +471 -> 4061
    //   3593: aload 19
    //   3595: astore 20
    //   3597: aload_0
    //   3598: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3601: getfield 724	com/tencent/msf/service/protocol/push/a/d:r	S
    //   3604: istore_1
    //   3605: iload_1
    //   3606: iconst_2
    //   3607: iand
    //   3608: iconst_2
    //   3609: if_icmpne +33 -> 3642
    //   3612: aload_0
    //   3613: getstatic 1575	com/tencent/mobileqq/msf/core/net/c/f$e$a:z	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   3616: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/f:a	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;)V
    //   3619: aload_0
    //   3620: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3623: lconst_0
    //   3624: putfield 1363	com/tencent/mobileqq/msf/core/net/c/f$e:s	J
    //   3627: aload_0
    //   3628: invokespecial 1442	com/tencent/mobileqq/msf/core/net/c/f:h	()V
    //   3631: iconst_0
    //   3632: istore 15
    //   3634: goto +716 -> 4350
    //   3637: astore 18
    //   3639: goto -49 -> 3590
    //   3642: iload 5
    //   3644: iconst_2
    //   3645: if_icmpne +27 -> 3672
    //   3648: iload 8
    //   3650: iconst_2
    //   3651: if_icmpge +21 -> 3672
    //   3654: aload_0
    //   3655: getstatic 1577	com/tencent/mobileqq/msf/core/net/c/f$e$a:B	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   3658: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/f:a	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;)V
    //   3661: aload_0
    //   3662: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3665: lconst_0
    //   3666: putfield 1363	com/tencent/mobileqq/msf/core/net/c/f$e:s	J
    //   3669: goto -42 -> 3627
    //   3672: aload_0
    //   3673: iload 6
    //   3675: invokespecial 1579	com/tencent/mobileqq/msf/core/net/c/f:a	(I)Z
    //   3678: istore 16
    //   3680: aload_0
    //   3681: iload 6
    //   3683: aload_0
    //   3684: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3687: getfield 1343	com/tencent/msf/service/protocol/push/a/d:g	[B
    //   3690: aload_0
    //   3691: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3694: getfield 1494	com/tencent/msf/service/protocol/push/a/d:p	[B
    //   3697: invokespecial 1581	com/tencent/mobileqq/msf/core/net/c/f:a	(I[B[B)[B
    //   3700: astore 18
    //   3702: aload_0
    //   3703: aload 27
    //   3705: invokespecial 1422	com/tencent/mobileqq/msf/core/net/c/f:a	(Lcom/tencent/msf/service/protocol/push/a/a;)Z
    //   3708: istore 17
    //   3710: iload 17
    //   3712: ifne +85 -> 3797
    //   3715: invokestatic 239	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3718: ifeq +15 -> 3733
    //   3721: ldc 255
    //   3723: iconst_4
    //   3724: ldc_w 1424
    //   3727: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3730: goto +3 -> 3733
    //   3733: aload_0
    //   3734: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3737: getfield 384	com/tencent/mobileqq/msf/core/net/c/f$e:J	Ljava/util/ArrayList;
    //   3740: ldc2_w 473
    //   3743: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3746: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3749: pop
    //   3750: aload_0
    //   3751: getstatic 1426	com/tencent/mobileqq/msf/core/net/c/f$e$a:c	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   3754: invokespecial 215	com/tencent/mobileqq/msf/core/net/c/f:a	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;)V
    //   3757: invokestatic 1564	com/tencent/mobileqq/msf/core/net/c/b:a	()Lcom/tencent/mobileqq/msf/core/net/c/b;
    //   3760: iconst_3
    //   3761: iload 8
    //   3763: aload_0
    //   3764: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3767: getfield 899	com/tencent/mobileqq/msf/core/net/c/f$e:g	I
    //   3770: iload 5
    //   3772: aload_0
    //   3773: getfield 166	com/tencent/mobileqq/msf/core/net/c/f:a	Lcom/tencent/mobileqq/msf/core/net/c/f$b;
    //   3776: aload 27
    //   3778: getfield 609	com/tencent/msf/service/protocol/push/a/a:c	Ljava/lang/String;
    //   3781: aload 20
    //   3783: invokevirtual 1567	com/tencent/mobileqq/msf/core/net/c/b:a	(IIIILcom/tencent/mobileqq/msf/core/net/c/f$b;Ljava/lang/String;Ljava/lang/String;)V
    //   3786: goto -159 -> 3627
    //   3789: astore 18
    //   3791: iconst_0
    //   3792: istore 15
    //   3794: goto +267 -> 4061
    //   3797: iload 16
    //   3799: ifeq +247 -> 4046
    //   3802: aload 18
    //   3804: ifnonnull +6 -> 3810
    //   3807: goto +239 -> 4046
    //   3810: aload_0
    //   3811: getfield 166	com/tencent/mobileqq/msf/core/net/c/f:a	Lcom/tencent/mobileqq/msf/core/net/c/f$b;
    //   3814: astore 19
    //   3816: getstatic 232	com/tencent/mobileqq/msf/core/net/c/f$b:c	Lcom/tencent/mobileqq/msf/core/net/c/f$b;
    //   3819: astore 21
    //   3821: aload 19
    //   3823: aload 21
    //   3825: if_acmpne +12 -> 3837
    //   3828: aload_0
    //   3829: getfield 114	com/tencent/mobileqq/msf/core/net/c/f:l	I
    //   3832: istore_1
    //   3833: iload_1
    //   3834: ifne +65 -> 3899
    //   3837: aload_0
    //   3838: aload 18
    //   3840: invokespecial 1428	com/tencent/mobileqq/msf/core/net/c/f:a	([B)Z
    //   3843: istore 16
    //   3845: iload 16
    //   3847: ifne +52 -> 3899
    //   3850: aload_0
    //   3851: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3854: getfield 384	com/tencent/mobileqq/msf/core/net/c/f$e:J	Ljava/util/ArrayList;
    //   3857: ldc2_w 473
    //   3860: invokestatic 389	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3863: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3866: pop
    //   3867: invokestatic 1564	com/tencent/mobileqq/msf/core/net/c/b:a	()Lcom/tencent/mobileqq/msf/core/net/c/b;
    //   3870: iconst_4
    //   3871: iload 8
    //   3873: aload_0
    //   3874: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3877: getfield 899	com/tencent/mobileqq/msf/core/net/c/f$e:g	I
    //   3880: iload 5
    //   3882: aload_0
    //   3883: getfield 166	com/tencent/mobileqq/msf/core/net/c/f:a	Lcom/tencent/mobileqq/msf/core/net/c/f$b;
    //   3886: aload 27
    //   3888: getfield 609	com/tencent/msf/service/protocol/push/a/a:c	Ljava/lang/String;
    //   3891: aload 20
    //   3893: invokevirtual 1567	com/tencent/mobileqq/msf/core/net/c/b:a	(IIIILcom/tencent/mobileqq/msf/core/net/c/f$b;Ljava/lang/String;Ljava/lang/String;)V
    //   3896: goto -269 -> 3627
    //   3899: aload_0
    //   3900: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3903: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   3906: ifeq +44 -> 3950
    //   3909: iconst_1
    //   3910: aload_0
    //   3911: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3914: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   3917: if_icmpne +6 -> 3923
    //   3920: goto +30 -> 3950
    //   3923: iconst_2
    //   3924: aload_0
    //   3925: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3928: getfield 291	com/tencent/msf/service/protocol/push/a/d:o	S
    //   3931: if_icmpne +414 -> 4345
    //   3934: aload_0
    //   3935: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   3938: astore 19
    //   3940: aload 19
    //   3942: getfield 1510	com/tencent/msf/service/protocol/push/a/d:n	J
    //   3945: l2i
    //   3946: istore_1
    //   3947: goto +7 -> 3954
    //   3950: aload 18
    //   3952: arraylength
    //   3953: istore_1
    //   3954: aload_0
    //   3955: iload_1
    //   3956: aload 18
    //   3958: invokespecial 1430	com/tencent/mobileqq/msf/core/net/c/f:a	(I[B)Z
    //   3961: istore 16
    //   3963: iload 16
    //   3965: ifne +44 -> 4009
    //   3968: invokestatic 1564	com/tencent/mobileqq/msf/core/net/c/b:a	()Lcom/tencent/mobileqq/msf/core/net/c/b;
    //   3971: iconst_5
    //   3972: iload 8
    //   3974: aload_0
    //   3975: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   3978: getfield 899	com/tencent/mobileqq/msf/core/net/c/f$e:g	I
    //   3981: iload 5
    //   3983: aload_0
    //   3984: getfield 166	com/tencent/mobileqq/msf/core/net/c/f:a	Lcom/tencent/mobileqq/msf/core/net/c/f$b;
    //   3987: aload 27
    //   3989: getfield 609	com/tencent/msf/service/protocol/push/a/a:c	Ljava/lang/String;
    //   3992: aload 20
    //   3994: invokevirtual 1567	com/tencent/mobileqq/msf/core/net/c/b:a	(IIIILcom/tencent/mobileqq/msf/core/net/c/f$b;Ljava/lang/String;Ljava/lang/String;)V
    //   3997: aload_0
    //   3998: invokespecial 1442	com/tencent/mobileqq/msf/core/net/c/f:h	()V
    //   4001: goto -370 -> 3631
    //   4004: astore 18
    //   4006: goto -215 -> 3791
    //   4009: invokestatic 1564	com/tencent/mobileqq/msf/core/net/c/b:a	()Lcom/tencent/mobileqq/msf/core/net/c/b;
    //   4012: iconst_0
    //   4013: iload 8
    //   4015: aload_0
    //   4016: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   4019: getfield 899	com/tencent/mobileqq/msf/core/net/c/f$e:g	I
    //   4022: iload 5
    //   4024: aload_0
    //   4025: getfield 166	com/tencent/mobileqq/msf/core/net/c/f:a	Lcom/tencent/mobileqq/msf/core/net/c/f$b;
    //   4028: aload 27
    //   4030: getfield 609	com/tencent/msf/service/protocol/push/a/a:c	Ljava/lang/String;
    //   4033: aload 20
    //   4035: invokevirtual 1567	com/tencent/mobileqq/msf/core/net/c/b:a	(IIIILcom/tencent/mobileqq/msf/core/net/c/f$b;Ljava/lang/String;Ljava/lang/String;)V
    //   4038: goto +39 -> 4077
    //   4041: astore 18
    //   4043: goto +18 -> 4061
    //   4046: goto -49 -> 3997
    //   4049: astore 18
    //   4051: goto +10 -> 4061
    //   4054: astore 18
    //   4056: goto +80 -> 4136
    //   4059: astore 18
    //   4061: ldc 255
    //   4063: iconst_1
    //   4064: ldc_w 1432
    //   4067: aload 18
    //   4069: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4072: aload 18
    //   4074: invokevirtual 475	java/lang/Exception:printStackTrace	()V
    //   4077: aload_0
    //   4078: invokespecial 1442	com/tencent/mobileqq/msf/core/net/c/f:h	()V
    //   4081: aload_0
    //   4082: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   4085: getfield 1481	com/tencent/msf/service/protocol/push/a/d:d	J
    //   4088: invokestatic 1438	java/lang/Thread:sleep	(J)V
    //   4091: goto +259 -> 4350
    //   4094: astore 18
    //   4096: new 241	java/lang/StringBuilder
    //   4099: dup
    //   4100: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   4103: astore 19
    //   4105: aload 19
    //   4107: ldc_w 1440
    //   4110: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4113: pop
    //   4114: aload 19
    //   4116: aload 18
    //   4118: invokevirtual 523	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4121: pop
    //   4122: ldc 255
    //   4124: iconst_1
    //   4125: aload 19
    //   4127: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4130: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4133: goto +217 -> 4350
    //   4136: aload_0
    //   4137: invokespecial 1442	com/tencent/mobileqq/msf/core/net/c/f:h	()V
    //   4140: aload 18
    //   4142: athrow
    //   4143: aload_0
    //   4144: getfield 127	com/tencent/mobileqq/msf/core/net/c/f:p	Lcom/tencent/mobileqq/msf/core/net/c/f$e;
    //   4147: getfield 1395	com/tencent/mobileqq/msf/core/net/c/f$e:y	Ljava/util/ArrayList;
    //   4150: iload 6
    //   4152: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4155: invokevirtual 349	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4158: pop
    //   4159: iload_1
    //   4160: iconst_m1
    //   4161: if_icmpne +6 -> 4167
    //   4164: goto +107 -> 4271
    //   4167: iload_1
    //   4168: aload_0
    //   4169: getfield 164	com/tencent/mobileqq/msf/core/net/c/f:b	Lcom/tencent/msf/service/protocol/push/a/d;
    //   4172: getfield 1159	com/tencent/msf/service/protocol/push/a/d:b	Ljava/util/ArrayList;
    //   4175: invokevirtual 692	java/util/ArrayList:size	()I
    //   4178: iconst_1
    //   4179: isub
    //   4180: if_icmpne +185 -> 4365
    //   4183: iconst_1
    //   4184: istore 16
    //   4186: goto +3 -> 4189
    //   4189: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4192: ifeq +179 -> 4371
    //   4195: new 241	java/lang/StringBuilder
    //   4198: dup
    //   4199: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   4202: astore 18
    //   4204: aload 18
    //   4206: ldc_w 1267
    //   4209: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4212: pop
    //   4213: aload 18
    //   4215: iload 15
    //   4217: invokevirtual 1270	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4220: pop
    //   4221: ldc 255
    //   4223: iconst_2
    //   4224: aload 18
    //   4226: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4229: invokestatic 262	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4232: goto +3 -> 4235
    //   4235: iload 15
    //   4237: ifeq +15 -> 4252
    //   4240: aload_0
    //   4241: getstatic 1274	com/tencent/mobileqq/msf/core/net/c/f$e$a:a	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   4244: iload 16
    //   4246: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   4249: goto +12 -> 4261
    //   4252: aload_0
    //   4253: getstatic 1276	com/tencent/mobileqq/msf/core/net/c/f$e$a:b	Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;
    //   4256: iload 16
    //   4258: invokespecial 855	com/tencent/mobileqq/msf/core/net/c/f:b	(Lcom/tencent/mobileqq/msf/core/net/c/f$e$a;Z)V
    //   4261: iload 16
    //   4263: ifeq +8 -> 4271
    //   4266: aload_0
    //   4267: iconst_1
    //   4268: putfield 104	com/tencent/mobileqq/msf/core/net/c/f:f	Z
    //   4271: iload_1
    //   4272: iconst_1
    //   4273: iadd
    //   4274: istore_1
    //   4275: goto -2552 -> 1723
    //   4278: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   4281: return
    //   4282: astore 18
    //   4284: goto +19 -> 4303
    //   4287: astore 18
    //   4289: ldc 255
    //   4291: iconst_1
    //   4292: ldc_w 1583
    //   4295: aload 18
    //   4297: invokestatic 378	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4300: goto -22 -> 4278
    //   4303: invokestatic 857	com/tencent/mobileqq/msf/core/net/c/k:a	()V
    //   4306: goto +6 -> 4312
    //   4309: aload 18
    //   4311: athrow
    //   4312: goto -3 -> 4309
    //   4315: astore 18
    //   4317: goto -2388 -> 1929
    //   4320: iconst_0
    //   4321: istore_1
    //   4322: goto -2833 -> 1489
    //   4325: lload 9
    //   4327: bipush 8
    //   4329: lshr
    //   4330: ldc2_w 1523
    //   4333: land
    //   4334: lstore 9
    //   4336: goto -1869 -> 2467
    //   4339: iconst_1
    //   4340: istore 5
    //   4342: goto -1088 -> 3254
    //   4345: iconst_0
    //   4346: istore_1
    //   4347: goto -393 -> 3954
    //   4350: iload_2
    //   4351: iconst_1
    //   4352: iadd
    //   4353: istore_2
    //   4354: iload_3
    //   4355: istore_1
    //   4356: iload 4
    //   4358: istore_3
    //   4359: goto -1887 -> 2472
    //   4362: goto -219 -> 4143
    //   4365: iconst_0
    //   4366: istore 16
    //   4368: goto -179 -> 4189
    //   4371: goto -136 -> 4235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4374	0	this	f
    //   740	3616	1	i1	int
    //   2094	2260	2	i2	int
    //   1722	2637	3	i3	int
    //   2091	2266	4	i4	int
    //   2738	1603	5	i5	int
    //   1530	2621	6	i6	int
    //   2769	726	7	i7	int
    //   3236	778	8	i8	int
    //   1491	2844	9	l1	long
    //   1502	1601	11	l2	long
    //   1511	1155	13	l3	long
    //   1986	2250	15	bool1	boolean
    //   2491	1876	16	bool2	boolean
    //   3708	3	17	bool3	boolean
    //   281	1758	18	localObject1	Object
    //   2049	1	18	localException1	Exception
    //   2191	26	18	localStringBuilder1	StringBuilder
    //   2379	1	18	localException2	Exception
    //   2390	1	18	localException3	Exception
    //   2426	1	18	localException4	Exception
    //   2431	26	18	localException5	Exception
    //   2556	30	18	localStringBuilder2	StringBuilder
    //   2602	1	18	localException6	Exception
    //   2716	1	18	localException7	Exception
    //   2721	1	18	localException8	Exception
    //   2810	24	18	localStringBuilder3	StringBuilder
    //   2846	1	18	localException9	Exception
    //   2853	1	18	localException10	Exception
    //   3009	1	18	localException11	Exception
    //   3029	1	18	localException12	Exception
    //   3034	1	18	localException13	Exception
    //   3043	1	18	localException14	Exception
    //   3077	1	18	localException15	Exception
    //   3082	1	18	localException16	Exception
    //   3114	1	18	localException17	Exception
    //   3125	1	18	localException18	Exception
    //   3130	31	18	localException19	Exception
    //   3280	17	18	localb	b
    //   3319	1	18	localException20	Exception
    //   3362	113	18	localObject2	Object
    //   3503	9	18	localThrowable	Throwable
    //   3518	1	18	localObject3	Object
    //   3523	9	18	localUnknownHostException	UnknownHostException
    //   3538	44	18	localObject4	Object
    //   3588	1	18	localException21	Exception
    //   3637	1	18	localException22	Exception
    //   3700	1	18	arrayOfByte	byte[]
    //   3789	168	18	localException23	Exception
    //   4004	1	18	localException24	Exception
    //   4041	1	18	localException25	Exception
    //   4049	1	18	localException26	Exception
    //   4054	1	18	localObject5	Object
    //   4059	14	18	localException27	Exception
    //   4094	47	18	localException28	Exception
    //   4202	23	18	localStringBuilder4	StringBuilder
    //   4282	1	18	localObject6	Object
    //   4287	23	18	localException29	Exception
    //   4315	1	18	localException30	Exception
    //   286	3840	19	localObject7	Object
    //   172	3862	20	localObject8	Object
    //   3350	474	21	localObject9	Object
    //   8	2807	22	str1	String
    //   3	2976	23	str2	String
    //   13	2728	24	str3	String
    //   3358	55	25	arrayOfInetAddress	InetAddress[]
    //   3426	71	26	localObject10	Object
    //   3224	805	27	locala	com.tencent.msf.service.protocol.push.a.a
    // Exception table:
    //   from	to	target	type
    //   1993	2046	2049	java/lang/Exception
    //   2344	2354	2379	java/lang/Exception
    //   2359	2374	2379	java/lang/Exception
    //   2227	2262	2390	java/lang/Exception
    //   2262	2272	2390	java/lang/Exception
    //   2277	2292	2390	java/lang/Exception
    //   2292	2320	2390	java/lang/Exception
    //   2324	2333	2390	java/lang/Exception
    //   2100	2107	2426	java/lang/Exception
    //   2112	2121	2426	java/lang/Exception
    //   2126	2135	2426	java/lang/Exception
    //   2142	2224	2426	java/lang/Exception
    //   2400	2409	2426	java/lang/Exception
    //   2412	2421	2426	java/lang/Exception
    //   1964	1988	2431	java/lang/Exception
    //   2054	2093	2431	java/lang/Exception
    //   2528	2539	2602	java/lang/Exception
    //   2541	2547	2602	java/lang/Exception
    //   2549	2558	2602	java/lang/Exception
    //   2560	2568	2602	java/lang/Exception
    //   2570	2580	2602	java/lang/Exception
    //   2582	2593	2602	java/lang/Exception
    //   2663	2670	2716	java/lang/Exception
    //   2677	2693	2716	java/lang/Exception
    //   2700	2709	2716	java/lang/Exception
    //   2498	2523	2721	java/lang/Exception
    //   2619	2658	2721	java/lang/Exception
    //   2797	2841	2846	java/lang/Exception
    //   2786	2797	2853	java/lang/Exception
    //   2974	2984	3009	java/lang/Exception
    //   2989	3004	3009	java/lang/Exception
    //   2888	2903	3029	java/lang/Exception
    //   2903	2913	3029	java/lang/Exception
    //   2918	2933	3029	java/lang/Exception
    //   2933	2961	3029	java/lang/Exception
    //   2965	2974	3029	java/lang/Exception
    //   2866	2882	3034	java/lang/Exception
    //   2777	2782	3043	java/lang/Exception
    //   3054	3063	3077	java/lang/Exception
    //   2765	2771	3082	java/lang/Exception
    //   3093	3102	3114	java/lang/Exception
    //   2740	2754	3125	java/lang/Exception
    //   2488	2493	3130	java/lang/Exception
    //   3277	3296	3319	java/lang/Exception
    //   3352	3360	3503	java/lang/Throwable
    //   3381	3387	3503	java/lang/Throwable
    //   3395	3399	3503	java/lang/Throwable
    //   3436	3444	3503	java/lang/Throwable
    //   3452	3459	3503	java/lang/Throwable
    //   3467	3474	3503	java/lang/Throwable
    //   3352	3360	3523	java/net/UnknownHostException
    //   3381	3387	3523	java/net/UnknownHostException
    //   3395	3399	3523	java/net/UnknownHostException
    //   3436	3444	3523	java/net/UnknownHostException
    //   3452	3459	3523	java/net/UnknownHostException
    //   3467	3474	3523	java/net/UnknownHostException
    //   3264	3272	3588	java/lang/Exception
    //   3296	3316	3637	java/lang/Exception
    //   3352	3360	3637	java/lang/Exception
    //   3381	3387	3637	java/lang/Exception
    //   3395	3399	3637	java/lang/Exception
    //   3436	3444	3637	java/lang/Exception
    //   3452	3459	3637	java/lang/Exception
    //   3467	3474	3637	java/lang/Exception
    //   3505	3516	3637	java/lang/Exception
    //   3525	3536	3637	java/lang/Exception
    //   3544	3581	3637	java/lang/Exception
    //   3612	3627	3637	java/lang/Exception
    //   3654	3669	3637	java/lang/Exception
    //   3715	3730	3637	java/lang/Exception
    //   3828	3833	3637	java/lang/Exception
    //   3733	3786	3789	java/lang/Exception
    //   3850	3896	3789	java/lang/Exception
    //   3968	3997	4004	java/lang/Exception
    //   3940	3947	4041	java/lang/Exception
    //   3950	3954	4041	java/lang/Exception
    //   3954	3963	4041	java/lang/Exception
    //   4009	4038	4041	java/lang/Exception
    //   3597	3605	4049	java/lang/Exception
    //   3672	3710	4049	java/lang/Exception
    //   3810	3821	4049	java/lang/Exception
    //   3837	3845	4049	java/lang/Exception
    //   3899	3920	4049	java/lang/Exception
    //   3923	3940	4049	java/lang/Exception
    //   3170	3248	4054	finally
    //   3264	3272	4054	finally
    //   3277	3296	4054	finally
    //   3296	3316	4054	finally
    //   3352	3360	4054	finally
    //   3381	3387	4054	finally
    //   3395	3399	4054	finally
    //   3436	3444	4054	finally
    //   3452	3459	4054	finally
    //   3467	3474	4054	finally
    //   3505	3516	4054	finally
    //   3525	3536	4054	finally
    //   3544	3581	4054	finally
    //   3597	3605	4054	finally
    //   3612	3627	4054	finally
    //   3654	3669	4054	finally
    //   3672	3710	4054	finally
    //   3715	3730	4054	finally
    //   3733	3786	4054	finally
    //   3810	3821	4054	finally
    //   3828	3833	4054	finally
    //   3837	3845	4054	finally
    //   3850	3896	4054	finally
    //   3899	3920	4054	finally
    //   3923	3940	4054	finally
    //   3940	3947	4054	finally
    //   3950	3954	4054	finally
    //   3954	3963	4054	finally
    //   3968	3997	4054	finally
    //   4009	4038	4054	finally
    //   4061	4077	4054	finally
    //   3170	3248	4059	java/lang/Exception
    //   4081	4091	4094	java/lang/Exception
    //   1456	1486	4282	finally
    //   1493	1513	4282	finally
    //   1532	1542	4282	finally
    //   1545	1568	4282	finally
    //   1568	1615	4282	finally
    //   1620	1625	4282	finally
    //   1628	1633	4282	finally
    //   1633	1704	4282	finally
    //   1704	1715	4282	finally
    //   1723	1737	4282	finally
    //   1744	1886	4282	finally
    //   1886	1926	4282	finally
    //   1929	1944	4282	finally
    //   1944	1964	4282	finally
    //   1964	1988	4282	finally
    //   1993	2046	4282	finally
    //   2054	2093	4282	finally
    //   2100	2107	4282	finally
    //   2112	2121	4282	finally
    //   2126	2135	4282	finally
    //   2142	2224	4282	finally
    //   2227	2262	4282	finally
    //   2262	2272	4282	finally
    //   2277	2292	4282	finally
    //   2292	2320	4282	finally
    //   2324	2333	4282	finally
    //   2344	2354	4282	finally
    //   2359	2374	4282	finally
    //   2400	2409	4282	finally
    //   2412	2421	4282	finally
    //   2444	2461	4282	finally
    //   2488	2493	4282	finally
    //   2498	2523	4282	finally
    //   2528	2539	4282	finally
    //   2541	2547	4282	finally
    //   2549	2558	4282	finally
    //   2560	2568	4282	finally
    //   2570	2580	4282	finally
    //   2582	2593	4282	finally
    //   2619	2658	4282	finally
    //   2663	2670	4282	finally
    //   2677	2693	4282	finally
    //   2700	2709	4282	finally
    //   2740	2754	4282	finally
    //   2765	2771	4282	finally
    //   2777	2782	4282	finally
    //   2786	2797	4282	finally
    //   2797	2841	4282	finally
    //   2866	2882	4282	finally
    //   2888	2903	4282	finally
    //   2903	2913	4282	finally
    //   2918	2933	4282	finally
    //   2933	2961	4282	finally
    //   2965	2974	4282	finally
    //   2974	2984	4282	finally
    //   2989	3004	4282	finally
    //   3054	3063	4282	finally
    //   3093	3102	4282	finally
    //   3148	3165	4282	finally
    //   3627	3631	4282	finally
    //   3997	4001	4282	finally
    //   4077	4081	4282	finally
    //   4081	4091	4282	finally
    //   4096	4133	4282	finally
    //   4136	4143	4282	finally
    //   4143	4159	4282	finally
    //   4167	4183	4282	finally
    //   4189	4232	4282	finally
    //   4240	4249	4282	finally
    //   4252	4261	4282	finally
    //   4266	4271	4282	finally
    //   4289	4300	4282	finally
    //   1456	1486	4287	java/lang/Exception
    //   1493	1513	4287	java/lang/Exception
    //   1532	1542	4287	java/lang/Exception
    //   1545	1568	4287	java/lang/Exception
    //   1568	1615	4287	java/lang/Exception
    //   1620	1625	4287	java/lang/Exception
    //   1628	1633	4287	java/lang/Exception
    //   1633	1704	4287	java/lang/Exception
    //   1704	1715	4287	java/lang/Exception
    //   1723	1737	4287	java/lang/Exception
    //   1744	1886	4287	java/lang/Exception
    //   1929	1944	4287	java/lang/Exception
    //   1944	1964	4287	java/lang/Exception
    //   2444	2461	4287	java/lang/Exception
    //   3148	3165	4287	java/lang/Exception
    //   3627	3631	4287	java/lang/Exception
    //   3997	4001	4287	java/lang/Exception
    //   4077	4081	4287	java/lang/Exception
    //   4096	4133	4287	java/lang/Exception
    //   4136	4143	4287	java/lang/Exception
    //   4143	4159	4287	java/lang/Exception
    //   4167	4183	4287	java/lang/Exception
    //   4189	4232	4287	java/lang/Exception
    //   4240	4249	4287	java/lang/Exception
    //   4252	4261	4287	java/lang/Exception
    //   4266	4271	4287	java/lang/Exception
    //   1886	1926	4315	java/lang/Exception
  }
  
  public void run()
  {
    try
    {
      if (this.b != null)
      {
        int i1 = h.a[this.a.ordinal()];
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
        m();
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
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.f
 * JD-Core Version:    0.7.0.1
 */