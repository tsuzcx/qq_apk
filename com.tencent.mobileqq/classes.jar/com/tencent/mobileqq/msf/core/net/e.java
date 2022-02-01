package com.tencent.mobileqq.msf.core.net;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.quicksend.f;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class e
  implements b
{
  private static final String b = "LightHttpEngine";
  boolean a = false;
  private String c;
  private URL d;
  private int e = 10000;
  private int f = 30000;
  private int g = 0;
  private Object h;
  private HttpURLConnection i;
  private int j;
  private String k;
  
  public e(int paramInt)
  {
    this.g = paramInt;
  }
  
  public static String a(String paramString)
  {
    if (NetConnInfoCenter.getSystemNetworkType() == 0) {
      return x.m.toString();
    }
    if (paramString.indexOf("illegal") > -1) {
      return x.g.toString();
    }
    if (paramString.indexOf("route to host") > -1) {
      return x.q.toString();
    }
    if (paramString.indexOf("unreachable") > -1) {
      return x.m.toString();
    }
    if (paramString.indexOf("permission") > -1) {
      return x.i.toString();
    }
    if (paramString.indexOf("refused") > -1) {
      return x.s.toString();
    }
    if (paramString.indexOf("reset") > -1) {
      return x.r.toString();
    }
    if ((paramString.indexOf("timeoutexception") <= -1) && (paramString.indexOf(") after") <= -1))
    {
      if (paramString.indexOf("unknownhost") > -1) {
        return x.p.toString();
      }
      if (paramString.indexOf("unresolved") > -1) {
        return x.o.toString();
      }
      if (paramString.indexOf("enotsock") > -1) {
        return x.h.toString();
      }
      if (paramString.indexOf("enobufs") > -1) {
        return x.l.toString();
      }
      if (paramString.indexOf("ebadf") > -1) {
        return x.j.toString();
      }
      if (paramString.indexOf("operation") > -1) {
        return x.t.toString();
      }
      if (paramString.indexOf("invalid") > -1) {
        return x.n.toString();
      }
      return x.u.toString();
    }
    return x.t.toString();
  }
  
  private String a(String paramString, int paramInt)
  {
    Object localObject = new Random(System.currentTimeMillis());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("r=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(String.valueOf(((Random)localObject).nextInt(100000)));
    localObject = localStringBuilder.toString();
    if (paramString.contains("?"))
    {
      if (paramString.endsWith("?"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append((String)localObject);
        return localStringBuilder.toString();
      }
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("&");
      paramString.append((String)localObject);
      return paramString.toString();
    }
    paramString = new StringBuilder();
    paramString.append("?");
    paramString.append((String)localObject);
    return paramString.toString();
  }
  
  private URLConnection a(URL paramURL)
  {
    try
    {
      paramURL = paramURL.openConnection();
      Object localObject = paramURL;
      try
      {
        if (!QLog.isColorLevel()) {
          return localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openConnection by default wifi=");
        ((StringBuilder)localObject).append(NetConnInfoCenter.isWifiConn());
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramURL);
        QLog.i("LightHttpEngine", 2, ((StringBuilder)localObject).toString());
        return paramURL;
      }
      catch (Throwable localThrowable1) {}
      if (!QLog.isColorLevel()) {
        break label107;
      }
    }
    catch (Throwable localThrowable2)
    {
      paramURL = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openConnection error: wifi=");
    localStringBuilder.append(NetConnInfoCenter.isWifiConn());
    QLog.w("LightHttpEngine", 1, localStringBuilder.toString());
    label107:
    localThrowable2.printStackTrace();
    URL localURL = paramURL;
    return localURL;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(Object paramObject)
  {
    this.h = paramObject;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, f paramf)
  {
    this.a = false;
    long l2 = 0L;
    long l1 = l2;
    try
    {
      this.f = a.ab();
      l1 = l2;
      StringBuilder localStringBuilder = new StringBuilder();
      l1 = l2;
      localStringBuilder.append("http://");
      l1 = l2;
      localStringBuilder.append(paramString1);
      l1 = l2;
      localStringBuilder.append(":");
      l1 = l2;
      localStringBuilder.append(paramInt);
      l1 = l2;
      paramString1 = localStringBuilder.toString();
      l1 = l2;
      localStringBuilder = new StringBuilder();
      l1 = l2;
      localStringBuilder.append(paramString1);
      l1 = l2;
      localStringBuilder.append(a(paramString1, this.g));
      l1 = l2;
      this.c = localStringBuilder.toString();
      l1 = l2;
      this.c = MsfSdkUtils.insertMtype(paramString2, this.c);
      l1 = l2;
      paramString1 = new StringBuilder();
      l1 = l2;
      paramString1.append("LightHttpEngine try connect ");
      l1 = l2;
      paramString1.append(this.c);
      l1 = l2;
      paramString1.append(" timeout:");
      l1 = l2;
      paramString1.append(this.e);
      l1 = l2;
      paramString1.append(" ssoseq:");
      l1 = l2;
      paramString1.append(this.g);
      l1 = l2;
      QLog.d("LightHttpEngine", 1, paramString1.toString());
      l1 = l2;
      l2 = SystemClock.elapsedRealtime();
      l1 = l2;
      System.setProperty("http.keepAlive", "false");
      l1 = l2;
      this.d = new URL(this.c);
      l1 = l2;
      this.i = ((HttpURLConnection)a(this.d));
      l1 = l2;
      this.i.setDoOutput(true);
      l1 = l2;
      this.i.setDoInput(true);
      l1 = l2;
      this.i.setUseCaches(false);
      l1 = l2;
      this.i.setReadTimeout(this.f);
      l1 = l2;
      this.i.setRequestMethod("POST");
      l1 = l2;
      this.i.setRequestProperty("User-Agent", "aqq");
      l1 = l2;
      this.i.setRequestProperty("content-type", "oct");
      l1 = l2;
      this.i.setConnectTimeout(this.e);
      l1 = l2;
      this.i.setRequestProperty("Connection", "close");
      l1 = l2;
      this.i.setRequestProperty("Accept-Encoding", "");
      l1 = l2;
      this.i.connect();
      l1 = l2;
      long l3 = SystemClock.elapsedRealtime();
      l1 = l2;
      this.a = true;
      l1 = l2;
      paramString1 = new StringBuilder();
      l1 = l2;
      paramString1.append("LightHttpEngine connect ");
      l1 = l2;
      paramString1.append(this.c);
      l1 = l2;
      paramString1.append(" succ costtime:");
      l1 = l2;
      paramString1.append(l3 - l2);
      l1 = l2;
      paramString1.append(" ssoseq:");
      l1 = l2;
      paramString1.append(this.g);
      l1 = l2;
      paramString1.append(" readTimeout:");
      l1 = l2;
      paramString1.append(this.f);
      l1 = l2;
      QLog.d("LightHttpEngine", 1, paramString1.toString());
    }
    catch (Throwable paramString1)
    {
      l2 = SystemClock.elapsedRealtime();
      this.a = false;
      try
      {
        if (this.i != null) {
          this.i.disconnect();
        }
      }
      catch (Throwable paramString2)
      {
        paramString2.printStackTrace();
      }
      paramString1.printStackTrace();
      paramString1 = a(paramString1.toString().toLowerCase());
      paramString2 = new StringBuilder(paramf.m);
      paramString2.append("|");
      paramString2.append(paramString1);
      paramf.m = paramString2.toString();
      paramString2 = new StringBuilder();
      paramString2.append("LightHttpEngine connect ");
      paramString2.append(this.c);
      paramString2.append(" fail costtime:");
      paramString2.append(l2 - l1);
      paramString2.append(" ssoseq:");
      paramString2.append(this.g);
      paramString2.append(" reason:");
      paramString2.append(paramString1);
      QLog.d("LightHttpEngine", 1, paramString2.toString());
    }
    return this.a;
  }
  
  /* Error */
  public byte[] a(com.tencent.qphone.base.remote.ToServiceMsg paramToServiceMsg, byte[] paramArrayOfByte, String paramString, f paramf)
  {
    // Byte code:
    //   0: invokestatic 250	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore 6
    //   5: aload_0
    //   6: getfield 268	com/tencent/mobileqq/msf/core/net/e:i	Ljava/net/HttpURLConnection;
    //   9: invokevirtual 346	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   12: astore_1
    //   13: aload_1
    //   14: aload_2
    //   15: invokevirtual 352	java/io/OutputStream:write	([B)V
    //   18: aload_1
    //   19: invokevirtual 355	java/io/OutputStream:flush	()V
    //   22: new 141	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   29: astore_3
    //   30: aload_3
    //   31: ldc_w 357
    //   34: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_3
    //   39: aload_0
    //   40: getfield 36	com/tencent/mobileqq/msf/core/net/e:g	I
    //   43: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_3
    //   48: ldc_w 359
    //   51: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_3
    //   56: aload_2
    //   57: arraylength
    //   58: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: ldc 10
    //   64: iconst_1
    //   65: aload_3
    //   66: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 268	com/tencent/mobileqq/msf/core/net/e:i	Ljava/net/HttpURLConnection;
    //   77: invokevirtual 362	java/net/HttpURLConnection:getResponseCode	()I
    //   80: putfield 364	com/tencent/mobileqq/msf/core/net/e:j	I
    //   83: aload_0
    //   84: aload_0
    //   85: getfield 268	com/tencent/mobileqq/msf/core/net/e:i	Ljava/net/HttpURLConnection;
    //   88: invokevirtual 368	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   91: invokevirtual 371	java/net/URL:getHost	()Ljava/lang/String;
    //   94: putfield 373	com/tencent/mobileqq/msf/core/net/e:k	Ljava/lang/String;
    //   97: aload_0
    //   98: getfield 268	com/tencent/mobileqq/msf/core/net/e:i	Ljava/net/HttpURLConnection;
    //   101: invokevirtual 377	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   104: astore 12
    //   106: aload_1
    //   107: astore_2
    //   108: aload 12
    //   110: astore_3
    //   111: new 379	java/io/BufferedInputStream
    //   114: dup
    //   115: aload 12
    //   117: invokespecial 382	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   120: astore 11
    //   122: aload_1
    //   123: astore_2
    //   124: aload 12
    //   126: astore_3
    //   127: new 384	org/apache/http/util/ByteArrayBuffer
    //   130: dup
    //   131: sipush 1024
    //   134: invokespecial 386	org/apache/http/util/ByteArrayBuffer:<init>	(I)V
    //   137: astore 10
    //   139: aload_1
    //   140: astore_2
    //   141: aload 12
    //   143: astore_3
    //   144: bipush 50
    //   146: newarray byte
    //   148: astore 13
    //   150: aload_1
    //   151: astore_2
    //   152: aload 12
    //   154: astore_3
    //   155: aload 11
    //   157: aload 13
    //   159: invokevirtual 390	java/io/BufferedInputStream:read	([B)I
    //   162: istore 5
    //   164: iload 5
    //   166: iconst_m1
    //   167: if_icmpne +175 -> 342
    //   170: aload_1
    //   171: astore_2
    //   172: aload 12
    //   174: astore_3
    //   175: invokestatic 250	android/os/SystemClock:elapsedRealtime	()J
    //   178: lstore 8
    //   180: aload_1
    //   181: astore_2
    //   182: aload 12
    //   184: astore_3
    //   185: new 141	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   192: astore 11
    //   194: aload_1
    //   195: astore_2
    //   196: aload 12
    //   198: astore_3
    //   199: aload 11
    //   201: ldc_w 392
    //   204: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload_1
    //   209: astore_2
    //   210: aload 12
    //   212: astore_3
    //   213: aload 11
    //   215: aload_0
    //   216: getfield 36	com/tencent/mobileqq/msf/core/net/e:g	I
    //   219: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_1
    //   224: astore_2
    //   225: aload 12
    //   227: astore_3
    //   228: aload 11
    //   230: ldc_w 359
    //   233: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload_1
    //   238: astore_2
    //   239: aload 12
    //   241: astore_3
    //   242: aload 11
    //   244: aload 10
    //   246: invokevirtual 395	org/apache/http/util/ByteArrayBuffer:length	()I
    //   249: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_1
    //   254: astore_2
    //   255: aload 12
    //   257: astore_3
    //   258: aload 11
    //   260: ldc_w 397
    //   263: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_1
    //   268: astore_2
    //   269: aload 12
    //   271: astore_3
    //   272: aload 11
    //   274: lload 8
    //   276: lload 6
    //   278: lsub
    //   279: invokevirtual 319	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload_1
    //   284: astore_2
    //   285: aload 12
    //   287: astore_3
    //   288: ldc 10
    //   290: iconst_1
    //   291: aload 11
    //   293: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload_1
    //   300: astore_2
    //   301: aload 12
    //   303: astore_3
    //   304: aload 10
    //   306: invokevirtual 401	org/apache/http/util/ByteArrayBuffer:toByteArray	()[B
    //   309: astore 10
    //   311: aload_1
    //   312: ifnull +10 -> 322
    //   315: aload_1
    //   316: invokevirtual 403	java/io/OutputStream:close	()V
    //   319: goto +3 -> 322
    //   322: aload 12
    //   324: ifnull +15 -> 339
    //   327: aload 12
    //   329: invokevirtual 406	java/io/InputStream:close	()V
    //   332: aload 10
    //   334: areturn
    //   335: aload_1
    //   336: invokevirtual 214	java/lang/Throwable:printStackTrace	()V
    //   339: aload 10
    //   341: areturn
    //   342: aload_1
    //   343: astore_2
    //   344: aload 12
    //   346: astore_3
    //   347: aload 10
    //   349: aload 13
    //   351: iconst_0
    //   352: iload 5
    //   354: invokevirtual 409	org/apache/http/util/ByteArrayBuffer:append	([BII)V
    //   357: goto -207 -> 150
    //   360: astore 10
    //   362: aload_1
    //   363: astore 11
    //   365: aload 12
    //   367: astore_1
    //   368: goto +45 -> 413
    //   371: astore_2
    //   372: aconst_null
    //   373: astore_3
    //   374: goto +257 -> 631
    //   377: astore 10
    //   379: aconst_null
    //   380: astore_2
    //   381: aload_1
    //   382: astore 11
    //   384: aload_2
    //   385: astore_1
    //   386: goto +27 -> 413
    //   389: astore 10
    //   391: goto +16 -> 407
    //   394: astore_2
    //   395: aconst_null
    //   396: astore_1
    //   397: aload_1
    //   398: astore_3
    //   399: goto +232 -> 631
    //   402: astore 10
    //   404: lconst_0
    //   405: lstore 6
    //   407: aconst_null
    //   408: astore 11
    //   410: aload 11
    //   412: astore_1
    //   413: aload 11
    //   415: astore_2
    //   416: aload_1
    //   417: astore_3
    //   418: invokestatic 250	android/os/SystemClock:elapsedRealtime	()J
    //   421: lstore 8
    //   423: aload 11
    //   425: astore_2
    //   426: aload_1
    //   427: astore_3
    //   428: aload 10
    //   430: invokevirtual 214	java/lang/Throwable:printStackTrace	()V
    //   433: aload 11
    //   435: astore_2
    //   436: aload_1
    //   437: astore_3
    //   438: aload 4
    //   440: aload 10
    //   442: invokevirtual 325	java/lang/Throwable:toString	()Ljava/lang/String;
    //   445: putfield 411	com/tencent/mobileqq/msf/core/quicksend/f:h	Ljava/lang/String;
    //   448: aload 11
    //   450: astore_2
    //   451: aload_1
    //   452: astore_3
    //   453: new 141	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   460: astore 4
    //   462: aload 11
    //   464: astore_2
    //   465: aload_1
    //   466: astore_3
    //   467: aload 4
    //   469: ldc_w 413
    //   472: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload 11
    //   478: astore_2
    //   479: aload_1
    //   480: astore_3
    //   481: aload 4
    //   483: aload_0
    //   484: getfield 36	com/tencent/mobileqq/msf/core/net/e:g	I
    //   487: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: aload 11
    //   493: astore_2
    //   494: aload_1
    //   495: astore_3
    //   496: aload 4
    //   498: ldc_w 397
    //   501: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload 11
    //   507: astore_2
    //   508: aload_1
    //   509: astore_3
    //   510: aload 4
    //   512: lload 8
    //   514: lload 6
    //   516: lsub
    //   517: invokevirtual 319	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload 11
    //   523: astore_2
    //   524: aload_1
    //   525: astore_3
    //   526: aload 4
    //   528: ldc_w 341
    //   531: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload 11
    //   537: astore_2
    //   538: aload_1
    //   539: astore_3
    //   540: aload 4
    //   542: aload 10
    //   544: invokevirtual 325	java/lang/Throwable:toString	()Ljava/lang/String;
    //   547: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 11
    //   553: astore_2
    //   554: aload_1
    //   555: astore_3
    //   556: ldc 10
    //   558: iconst_1
    //   559: aload 4
    //   561: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokestatic 245	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   567: aload 11
    //   569: astore_2
    //   570: aload_1
    //   571: astore_3
    //   572: invokestatic 190	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq +20 -> 595
    //   578: aload 11
    //   580: astore_2
    //   581: aload_1
    //   582: astore_3
    //   583: ldc 10
    //   585: iconst_2
    //   586: aload 10
    //   588: iconst_0
    //   589: anewarray 4	java/lang/Object
    //   592: invokestatic 416	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   595: aload 11
    //   597: ifnull +11 -> 608
    //   600: aload 11
    //   602: invokevirtual 403	java/io/OutputStream:close	()V
    //   605: goto +3 -> 608
    //   608: aload_1
    //   609: ifnull +13 -> 622
    //   612: aload_1
    //   613: invokevirtual 406	java/io/InputStream:close	()V
    //   616: aconst_null
    //   617: areturn
    //   618: aload_1
    //   619: invokevirtual 214	java/lang/Throwable:printStackTrace	()V
    //   622: aconst_null
    //   623: areturn
    //   624: astore 4
    //   626: aload_2
    //   627: astore_1
    //   628: aload 4
    //   630: astore_2
    //   631: aload_1
    //   632: ifnull +10 -> 642
    //   635: aload_1
    //   636: invokevirtual 403	java/io/OutputStream:close	()V
    //   639: goto +3 -> 642
    //   642: aload_3
    //   643: ifnull +14 -> 657
    //   646: aload_3
    //   647: invokevirtual 406	java/io/InputStream:close	()V
    //   650: goto +7 -> 657
    //   653: aload_1
    //   654: invokevirtual 214	java/lang/Throwable:printStackTrace	()V
    //   657: goto +5 -> 662
    //   660: aload_2
    //   661: athrow
    //   662: goto -2 -> 660
    //   665: astore_1
    //   666: goto -331 -> 335
    //   669: astore_1
    //   670: goto -52 -> 618
    //   673: astore_1
    //   674: goto -21 -> 653
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	677	0	this	e
    //   0	677	1	paramToServiceMsg	com.tencent.qphone.base.remote.ToServiceMsg
    //   0	677	2	paramArrayOfByte	byte[]
    //   0	677	3	paramString	String
    //   0	677	4	paramf	f
    //   162	191	5	m	int
    //   3	512	6	l1	long
    //   178	335	8	l2	long
    //   137	211	10	localObject1	Object
    //   360	1	10	localThrowable1	Throwable
    //   377	1	10	localThrowable2	Throwable
    //   389	1	10	localThrowable3	Throwable
    //   402	185	10	localThrowable4	Throwable
    //   120	481	11	localObject2	Object
    //   104	262	12	localInputStream	java.io.InputStream
    //   148	202	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   111	122	360	java/lang/Throwable
    //   127	139	360	java/lang/Throwable
    //   144	150	360	java/lang/Throwable
    //   155	164	360	java/lang/Throwable
    //   175	180	360	java/lang/Throwable
    //   185	194	360	java/lang/Throwable
    //   199	208	360	java/lang/Throwable
    //   213	223	360	java/lang/Throwable
    //   228	237	360	java/lang/Throwable
    //   242	253	360	java/lang/Throwable
    //   258	267	360	java/lang/Throwable
    //   272	283	360	java/lang/Throwable
    //   288	299	360	java/lang/Throwable
    //   304	311	360	java/lang/Throwable
    //   347	357	360	java/lang/Throwable
    //   13	106	371	finally
    //   13	106	377	java/lang/Throwable
    //   5	13	389	java/lang/Throwable
    //   0	5	394	finally
    //   5	13	394	finally
    //   0	5	402	java/lang/Throwable
    //   111	122	624	finally
    //   127	139	624	finally
    //   144	150	624	finally
    //   155	164	624	finally
    //   175	180	624	finally
    //   185	194	624	finally
    //   199	208	624	finally
    //   213	223	624	finally
    //   228	237	624	finally
    //   242	253	624	finally
    //   258	267	624	finally
    //   272	283	624	finally
    //   288	299	624	finally
    //   304	311	624	finally
    //   347	357	624	finally
    //   418	423	624	finally
    //   428	433	624	finally
    //   438	448	624	finally
    //   453	462	624	finally
    //   467	476	624	finally
    //   481	491	624	finally
    //   496	505	624	finally
    //   510	521	624	finally
    //   526	535	624	finally
    //   540	551	624	finally
    //   556	567	624	finally
    //   572	578	624	finally
    //   583	595	624	finally
    //   315	319	665	java/lang/Throwable
    //   327	332	665	java/lang/Throwable
    //   600	605	669	java/lang/Throwable
    //   612	616	669	java/lang/Throwable
    //   635	639	673	java/lang/Throwable
    //   646	650	673	java/lang/Throwable
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  public void c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("LightHttpEngine disconn ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(" ssoseq:");
    ((StringBuilder)localObject).append(this.g);
    QLog.d("LightHttpEngine", 1, ((StringBuilder)localObject).toString());
    this.a = false;
    localObject = this.i;
    if (localObject != null)
    {
      ((HttpURLConnection)localObject).disconnect();
      this.i = null;
    }
  }
  
  public void d()
  {
    this.c = null;
    this.d = null;
    this.e = 10000;
    this.i = null;
    this.j = 0;
    this.k = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.e
 * JD-Core Version:    0.7.0.1
 */