package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.util.ArrayList;

public class MonitorSocketInputStream
  extends InputStream
{
  private Context context;
  private boolean isFirstReadBuffer = true;
  private InputStream mInputStream;
  private c monitorSocketImpl;
  
  public MonitorSocketInputStream(InputStream paramInputStream, c paramc, Context paramContext)
  {
    this.mInputStream = paramInputStream;
    this.monitorSocketImpl = paramc;
    this.context = paramContext;
  }
  
  private static String bytesToHex(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuffer.append(0);
      }
      localStringBuffer.append(str);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void getHttpResponseInfo(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    int j = i;
    int k = 0;
    int m = i;
    for (;;)
    {
      int i1 = paramInt1 + paramInt2;
      if (j < i1)
      {
        int n = m;
        i = k;
        if (paramArrayOfByte[j] == 13)
        {
          int i2 = j + 1;
          n = m;
          i = k;
          if (i2 < i1)
          {
            n = m;
            i = k;
            if (paramArrayOfByte[i2] != 10) {}
          }
        }
        try
        {
          Object localObject = new String(paramArrayOfByte, m, j - m);
          n = j + 2;
          i = k + 1;
          if (i == 1)
          {
            localObject = ((String)localObject).split(" ");
            if (localObject.length >= 2) {
              this.monitorSocketImpl.g.setResponseCode(localObject[1]);
            }
          }
          else
          {
            boolean bool = TextUtils.isEmpty((CharSequence)localObject);
            if (bool)
            {
              if (n + 16 < i1)
              {
                localObject = bytesToHex(paramArrayOfByte, n, 16);
                if (((String)localObject).toUpperCase().startsWith("504B0304")) {
                  this.monitorSocketImpl.g.setFileType(1);
                }
                this.monitorSocketImpl.g.setResponseBodyHex((String)localObject);
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.D.MonitorSocket", 2, new Object[] { "Read Head=", localObject, " String=", new String(paramArrayOfByte, n, 16) });
                }
              }
              else
              {
                paramInt1 = i1 - n;
                localObject = bytesToHex(paramArrayOfByte, n, paramInt1);
                if (((String)localObject).toUpperCase().startsWith("504B0304")) {
                  this.monitorSocketImpl.g.setFileType(1);
                }
                this.monitorSocketImpl.g.setResponseBodyHex((String)localObject);
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.D.MonitorSocket", 2, new Object[] { "Read Head=", localObject, " String=", new String(paramArrayOfByte, n, paramInt1) });
                }
              }
              if ((this.monitorSocketImpl.g.getUrl() == null) || (!this.monitorSocketImpl.g.getUrl().contains(".apk")) || ((this.monitorSocketImpl.g.getFileType() == 1) && (this.monitorSocketImpl.g.getFileType() == 2))) {
                return;
              }
              this.monitorSocketImpl.g.responseHeaderGuessInfo.add(this.monitorSocketImpl.g.getUrl());
              this.monitorSocketImpl.g.setFileType(2);
              return;
            }
            k = ((String)localObject).indexOf(":");
            if (k > 0) {
              try
              {
                String str1 = ((String)localObject).substring(0, k);
                String str2 = ((String)localObject).substring(k + 2);
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.D.MonitorSocket", 2, new Object[] { "line", Integer.valueOf(i), "{", str1, str2, "}" });
                }
                if ("Content-Type".equals(str1))
                {
                  this.monitorSocketImpl.g.setMimeType(str2);
                  if ("application/vnd.android.package-archive".equals(str2)) {
                    this.monitorSocketImpl.g.setFileType(1);
                  }
                }
                else if ("Content-Length".equals(str1))
                {
                  this.monitorSocketImpl.g.setResponseLength(str2);
                }
                else if ((str2.indexOf(".apk") > 0) && (this.monitorSocketImpl.g.getFileType() != 1))
                {
                  this.monitorSocketImpl.g.responseHeaderGuessInfo.add(localObject);
                  this.monitorSocketImpl.g.setFileType(2);
                }
              }
              catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("MSF.D.MonitorSocket", 2, new Object[] { "header parse error, index=", Integer.valueOf(k), " line=", localObject, " error info=", localStringIndexOutOfBoundsException });
                }
              }
            }
          }
          j += 1;
          m = n;
          k = i;
        }
        catch (Exception paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MSF.D.MonitorSocket", 2, "getHttpResponseInfo ERROR=", paramArrayOfByte);
          }
        }
      }
    }
  }
  
  public void close()
  {
    this.mInputStream.close();
  }
  
  public int hashCode()
  {
    return this.mInputStream.hashCode();
  }
  
  public int read()
  {
    return this.mInputStream.read();
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  /* Error */
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:mInputStream	Ljava/io/InputStream;
    //   4: aload_1
    //   5: iload_2
    //   6: iload_3
    //   7: invokevirtual 211	java/io/InputStream:read	([BII)I
    //   10: istore 4
    //   12: aload_0
    //   13: getfield 19	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:isFirstReadBuffer	Z
    //   16: ifeq +31 -> 47
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 19	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:isFirstReadBuffer	Z
    //   24: getstatic 216	com/tencent/qphone/base/util/BaseApplication:httpMonitorBan	Z
    //   27: ifne +20 -> 47
    //   30: aload_0
    //   31: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   34: getfield 74	com/tencent/mobileqq/msf/sdk/utils/c:g	Lcom/tencent/mobileqq/msf/sdk/utils/MonitorHttpInfo;
    //   37: ifnull +10 -> 47
    //   40: aload_0
    //   41: aload_1
    //   42: iload_2
    //   43: iload_3
    //   44: invokespecial 218	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:getHttpResponseInfo	([BII)V
    //   47: iload 4
    //   49: iconst_m1
    //   50: if_icmpne +6 -> 56
    //   53: iload 4
    //   55: ireturn
    //   56: aload_0
    //   57: invokevirtual 219	java/lang/Object:toString	()Ljava/lang/String;
    //   60: invokestatic 224	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketImplFactory:isServerSocket	(Ljava/lang/String;)Z
    //   63: ifeq +6 -> 69
    //   66: iload 4
    //   68: ireturn
    //   69: aload_0
    //   70: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   73: getfield 227	com/tencent/mobileqq/msf/sdk/utils/c:d	Ljava/lang/String;
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull +25 -> 103
    //   81: aload_0
    //   82: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   85: getfield 227	com/tencent/mobileqq/msf/sdk/utils/c:d	Ljava/lang/String;
    //   88: ldc 229
    //   90: invokevirtual 130	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   93: ifeq +10 -> 103
    //   96: invokestatic 234	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getSystemNetworkType	()I
    //   99: istore_3
    //   100: goto +7 -> 107
    //   103: invokestatic 237	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getSystemNetworkType	()I
    //   106: istore_3
    //   107: iload_3
    //   108: istore_2
    //   109: iload_3
    //   110: ifne +51 -> 161
    //   113: invokestatic 241	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   116: ldc 243
    //   118: invokevirtual 247	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   121: checkcast 249	android/net/ConnectivityManager
    //   124: invokevirtual 253	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   127: astore_1
    //   128: iload_3
    //   129: istore_2
    //   130: aload_1
    //   131: ifnull +30 -> 161
    //   134: aload_1
    //   135: invokevirtual 258	android/net/NetworkInfo:getType	()I
    //   138: istore_3
    //   139: iload_3
    //   140: iconst_1
    //   141: if_icmpne +8 -> 149
    //   144: iconst_2
    //   145: istore_2
    //   146: goto +15 -> 161
    //   149: iload_3
    //   150: istore_2
    //   151: iload_3
    //   152: invokestatic 262	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketImplFactory:isNetworkTypeMobile	(I)Z
    //   155: iconst_1
    //   156: if_icmpne +5 -> 161
    //   159: iconst_1
    //   160: istore_2
    //   161: aconst_null
    //   162: astore_1
    //   163: aload_0
    //   164: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   167: getfield 227	com/tencent/mobileqq/msf/sdk/utils/c:d	Ljava/lang/String;
    //   170: ifnull +561 -> 731
    //   173: aload_0
    //   174: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   177: getfield 227	com/tencent/mobileqq/msf/sdk/utils/c:d	Ljava/lang/String;
    //   180: ldc 229
    //   182: invokevirtual 130	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   185: ifeq +546 -> 731
    //   188: getstatic 267	com/tencent/mobileqq/msf/core/net/m:q	Ljava/util/ArrayList;
    //   191: aload_0
    //   192: invokevirtual 219	java/lang/Object:toString	()Ljava/lang/String;
    //   195: invokevirtual 269	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   198: ifeq +6 -> 204
    //   201: goto +728 -> 929
    //   204: getstatic 274	com/tencent/mobileqq/msf/core/net/c/k:f	Ljava/util/ArrayList;
    //   207: aload_0
    //   208: invokevirtual 219	java/lang/Object:toString	()Ljava/lang/String;
    //   211: invokevirtual 269	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   214: ifeq +321 -> 535
    //   217: aload_0
    //   218: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   221: astore_1
    //   222: getstatic 278	com/tencent/mobileqq/msf/sdk/utils/c:n	Ljava/util/concurrent/ConcurrentHashMap;
    //   225: aload_0
    //   226: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   229: getfield 281	com/tencent/mobileqq/msf/sdk/utils/c:e	Ljava/lang/String;
    //   232: invokevirtual 282	java/lang/String:hashCode	()I
    //   235: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: invokevirtual 288	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   241: checkcast 290	com/tencent/mobileqq/msf/sdk/utils/b
    //   244: astore_1
    //   245: aload_1
    //   246: ifnonnull +94 -> 340
    //   249: new 290	com/tencent/mobileqq/msf/sdk/utils/b
    //   252: dup
    //   253: aload_0
    //   254: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   257: getfield 293	com/tencent/mobileqq/msf/sdk/utils/c:b	Ljava/lang/String;
    //   260: aconst_null
    //   261: aload_0
    //   262: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   265: getfield 297	com/tencent/mobileqq/msf/sdk/utils/c:c	I
    //   268: getstatic 301	com/tencent/mobileqq/msf/sdk/utils/c:m	S
    //   271: iload 4
    //   273: i2l
    //   274: iload_2
    //   275: invokespecial 304	com/tencent/mobileqq/msf/sdk/utils/b:<init>	(Ljava/lang/String;Ljava/lang/String;IIJI)V
    //   278: astore_1
    //   279: aload_1
    //   280: ldc_w 306
    //   283: putfield 309	com/tencent/mobileqq/msf/sdk/utils/b:h	Ljava/lang/String;
    //   286: aload_1
    //   287: getstatic 313	com/tencent/qphone/base/util/BaseApplication:monitor	Lcom/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat;
    //   290: invokevirtual 319	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat:getSTATUS	()B
    //   293: putfield 323	com/tencent/mobileqq/msf/sdk/utils/b:i	B
    //   296: aload_1
    //   297: aload_0
    //   298: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   301: getfield 281	com/tencent/mobileqq/msf/sdk/utils/c:e	Ljava/lang/String;
    //   304: invokevirtual 282	java/lang/String:hashCode	()I
    //   307: putfield 326	com/tencent/mobileqq/msf/sdk/utils/b:j	I
    //   310: aload_0
    //   311: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   314: astore 5
    //   316: getstatic 278	com/tencent/mobileqq/msf/sdk/utils/c:n	Ljava/util/concurrent/ConcurrentHashMap;
    //   319: aload_0
    //   320: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   323: getfield 281	com/tencent/mobileqq/msf/sdk/utils/c:e	Ljava/lang/String;
    //   326: invokevirtual 282	java/lang/String:hashCode	()I
    //   329: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   332: aload_1
    //   333: invokevirtual 330	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   336: pop
    //   337: goto +36 -> 373
    //   340: aload_0
    //   341: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   344: astore 5
    //   346: getstatic 278	com/tencent/mobileqq/msf/sdk/utils/c:n	Ljava/util/concurrent/ConcurrentHashMap;
    //   349: aload_0
    //   350: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   353: getfield 281	com/tencent/mobileqq/msf/sdk/utils/c:e	Ljava/lang/String;
    //   356: invokevirtual 282	java/lang/String:hashCode	()I
    //   359: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   362: aload_1
    //   363: iload 4
    //   365: i2l
    //   366: invokevirtual 334	com/tencent/mobileqq/msf/sdk/utils/b:a	(J)Lcom/tencent/mobileqq/msf/sdk/utils/b;
    //   369: invokevirtual 330	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   372: pop
    //   373: aload_1
    //   374: astore 5
    //   376: aload 5
    //   378: getfield 338	com/tencent/mobileqq/msf/sdk/utils/b:l	Ljava/lang/Runnable;
    //   381: ifnonnull +19 -> 400
    //   384: aload_0
    //   385: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   388: aload 5
    //   390: getfield 326	com/tencent/mobileqq/msf/sdk/utils/b:j	I
    //   393: getstatic 301	com/tencent/mobileqq/msf/sdk/utils/c:m	S
    //   396: invokevirtual 341	com/tencent/mobileqq/msf/sdk/utils/c:a	(II)Ljava/lang/Runnable;
    //   399: pop
    //   400: aload 5
    //   402: astore_1
    //   403: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +523 -> 929
    //   409: new 343	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 344	java/lang/StringBuilder:<init>	()V
    //   416: astore_1
    //   417: aload_1
    //   418: ldc_w 346
    //   421: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload_1
    //   426: aload_0
    //   427: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   430: getfield 281	com/tencent/mobileqq/msf/sdk/utils/c:e	Ljava/lang/String;
    //   433: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload_1
    //   438: ldc_w 351
    //   441: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_1
    //   446: iload 4
    //   448: invokevirtual 354	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload_1
    //   453: ldc_w 356
    //   456: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload_1
    //   461: iload_2
    //   462: invokevirtual 354	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload_1
    //   467: ldc_w 356
    //   470: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload_1
    //   475: ldc_w 358
    //   478: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload_1
    //   483: ldc_w 356
    //   486: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload_1
    //   491: getstatic 313	com/tencent/qphone/base/util/BaseApplication:monitor	Lcom/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat;
    //   494: invokevirtual 319	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat:getSTATUS	()B
    //   497: invokevirtual 354	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload_1
    //   502: ldc_w 356
    //   505: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload_1
    //   510: aload 5
    //   512: invokevirtual 359	com/tencent/mobileqq/msf/sdk/utils/b:toString	()Ljava/lang/String;
    //   515: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: ldc 112
    //   521: iconst_2
    //   522: aload_1
    //   523: invokevirtual 360	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 363	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: aload 5
    //   531: astore_1
    //   532: goto +397 -> 929
    //   535: aload_0
    //   536: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   539: astore_1
    //   540: getstatic 278	com/tencent/mobileqq/msf/sdk/utils/c:n	Ljava/util/concurrent/ConcurrentHashMap;
    //   543: aload_0
    //   544: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   547: getfield 281	com/tencent/mobileqq/msf/sdk/utils/c:e	Ljava/lang/String;
    //   550: invokevirtual 282	java/lang/String:hashCode	()I
    //   553: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   556: invokevirtual 288	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   559: checkcast 290	com/tencent/mobileqq/msf/sdk/utils/b
    //   562: astore_1
    //   563: aload_1
    //   564: ifnonnull +98 -> 662
    //   567: new 290	com/tencent/mobileqq/msf/sdk/utils/b
    //   570: dup
    //   571: aload_0
    //   572: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   575: getfield 293	com/tencent/mobileqq/msf/sdk/utils/c:b	Ljava/lang/String;
    //   578: aconst_null
    //   579: aload_0
    //   580: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   583: getfield 297	com/tencent/mobileqq/msf/sdk/utils/c:c	I
    //   586: getstatic 301	com/tencent/mobileqq/msf/sdk/utils/c:m	S
    //   589: iload 4
    //   591: i2l
    //   592: iload_2
    //   593: invokespecial 304	com/tencent/mobileqq/msf/sdk/utils/b:<init>	(Ljava/lang/String;Ljava/lang/String;IIJI)V
    //   596: astore_1
    //   597: aload_1
    //   598: getstatic 313	com/tencent/qphone/base/util/BaseApplication:monitor	Lcom/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat;
    //   601: invokevirtual 319	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat:getSTATUS	()B
    //   604: putfield 323	com/tencent/mobileqq/msf/sdk/utils/b:i	B
    //   607: aload_1
    //   608: aload_0
    //   609: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   612: getfield 365	com/tencent/mobileqq/msf/sdk/utils/c:j	Ljava/lang/String;
    //   615: putfield 309	com/tencent/mobileqq/msf/sdk/utils/b:h	Ljava/lang/String;
    //   618: aload_1
    //   619: aload_0
    //   620: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   623: getfield 281	com/tencent/mobileqq/msf/sdk/utils/c:e	Ljava/lang/String;
    //   626: invokevirtual 282	java/lang/String:hashCode	()I
    //   629: putfield 326	com/tencent/mobileqq/msf/sdk/utils/b:j	I
    //   632: aload_0
    //   633: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   636: astore 5
    //   638: getstatic 278	com/tencent/mobileqq/msf/sdk/utils/c:n	Ljava/util/concurrent/ConcurrentHashMap;
    //   641: aload_0
    //   642: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   645: getfield 281	com/tencent/mobileqq/msf/sdk/utils/c:e	Ljava/lang/String;
    //   648: invokevirtual 282	java/lang/String:hashCode	()I
    //   651: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   654: aload_1
    //   655: invokevirtual 330	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   658: pop
    //   659: goto +36 -> 695
    //   662: aload_0
    //   663: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   666: astore 5
    //   668: getstatic 278	com/tencent/mobileqq/msf/sdk/utils/c:n	Ljava/util/concurrent/ConcurrentHashMap;
    //   671: aload_0
    //   672: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   675: getfield 281	com/tencent/mobileqq/msf/sdk/utils/c:e	Ljava/lang/String;
    //   678: invokevirtual 282	java/lang/String:hashCode	()I
    //   681: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   684: aload_1
    //   685: iload 4
    //   687: i2l
    //   688: invokevirtual 334	com/tencent/mobileqq/msf/sdk/utils/b:a	(J)Lcom/tencent/mobileqq/msf/sdk/utils/b;
    //   691: invokevirtual 330	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   694: pop
    //   695: aload_1
    //   696: astore 5
    //   698: aload 5
    //   700: astore_1
    //   701: aload 5
    //   703: getfield 338	com/tencent/mobileqq/msf/sdk/utils/b:l	Ljava/lang/Runnable;
    //   706: ifnonnull +223 -> 929
    //   709: aload_0
    //   710: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   713: aload 5
    //   715: getfield 326	com/tencent/mobileqq/msf/sdk/utils/b:j	I
    //   718: getstatic 301	com/tencent/mobileqq/msf/sdk/utils/c:m	S
    //   721: invokevirtual 341	com/tencent/mobileqq/msf/sdk/utils/c:a	(II)Ljava/lang/Runnable;
    //   724: pop
    //   725: aload 5
    //   727: astore_1
    //   728: goto +201 -> 929
    //   731: aload_0
    //   732: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   735: getfield 365	com/tencent/mobileqq/msf/sdk/utils/c:j	Ljava/lang/String;
    //   738: ifnull +191 -> 929
    //   741: aload_0
    //   742: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   745: astore_1
    //   746: getstatic 278	com/tencent/mobileqq/msf/sdk/utils/c:n	Ljava/util/concurrent/ConcurrentHashMap;
    //   749: aload_0
    //   750: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   753: getfield 281	com/tencent/mobileqq/msf/sdk/utils/c:e	Ljava/lang/String;
    //   756: invokevirtual 282	java/lang/String:hashCode	()I
    //   759: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   762: invokevirtual 288	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   765: checkcast 290	com/tencent/mobileqq/msf/sdk/utils/b
    //   768: astore_1
    //   769: aload_1
    //   770: ifnonnull +97 -> 867
    //   773: new 290	com/tencent/mobileqq/msf/sdk/utils/b
    //   776: dup
    //   777: aload_0
    //   778: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   781: getfield 293	com/tencent/mobileqq/msf/sdk/utils/c:b	Ljava/lang/String;
    //   784: aload_0
    //   785: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   788: getfield 367	com/tencent/mobileqq/msf/sdk/utils/c:a	Ljava/lang/String;
    //   791: aload_0
    //   792: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   795: getfield 297	com/tencent/mobileqq/msf/sdk/utils/c:c	I
    //   798: getstatic 301	com/tencent/mobileqq/msf/sdk/utils/c:m	S
    //   801: iload 4
    //   803: i2l
    //   804: iload_2
    //   805: invokespecial 304	com/tencent/mobileqq/msf/sdk/utils/b:<init>	(Ljava/lang/String;Ljava/lang/String;IIJI)V
    //   808: astore 5
    //   810: aload 5
    //   812: aload_0
    //   813: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   816: getfield 365	com/tencent/mobileqq/msf/sdk/utils/c:j	Ljava/lang/String;
    //   819: putfield 309	com/tencent/mobileqq/msf/sdk/utils/b:h	Ljava/lang/String;
    //   822: aload 5
    //   824: aload_0
    //   825: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   828: getfield 281	com/tencent/mobileqq/msf/sdk/utils/c:e	Ljava/lang/String;
    //   831: invokevirtual 282	java/lang/String:hashCode	()I
    //   834: putfield 326	com/tencent/mobileqq/msf/sdk/utils/b:j	I
    //   837: aload_0
    //   838: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   841: astore_1
    //   842: getstatic 278	com/tencent/mobileqq/msf/sdk/utils/c:n	Ljava/util/concurrent/ConcurrentHashMap;
    //   845: aload_0
    //   846: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   849: getfield 281	com/tencent/mobileqq/msf/sdk/utils/c:e	Ljava/lang/String;
    //   852: invokevirtual 282	java/lang/String:hashCode	()I
    //   855: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   858: aload 5
    //   860: invokevirtual 330	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   863: pop
    //   864: goto +24 -> 888
    //   867: aload_1
    //   868: iload 4
    //   870: i2l
    //   871: invokevirtual 334	com/tencent/mobileqq/msf/sdk/utils/b:a	(J)Lcom/tencent/mobileqq/msf/sdk/utils/b;
    //   874: astore 5
    //   876: aload 5
    //   878: aload_0
    //   879: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   882: getfield 365	com/tencent/mobileqq/msf/sdk/utils/c:j	Ljava/lang/String;
    //   885: putfield 309	com/tencent/mobileqq/msf/sdk/utils/b:h	Ljava/lang/String;
    //   888: aload 5
    //   890: getstatic 313	com/tencent/qphone/base/util/BaseApplication:monitor	Lcom/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat;
    //   893: invokevirtual 319	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat:getSTATUS	()B
    //   896: putfield 323	com/tencent/mobileqq/msf/sdk/utils/b:i	B
    //   899: aload 5
    //   901: astore_1
    //   902: aload 5
    //   904: getfield 338	com/tencent/mobileqq/msf/sdk/utils/b:l	Ljava/lang/Runnable;
    //   907: ifnonnull +22 -> 929
    //   910: aload_0
    //   911: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   914: aload 5
    //   916: getfield 326	com/tencent/mobileqq/msf/sdk/utils/b:j	I
    //   919: getstatic 301	com/tencent/mobileqq/msf/sdk/utils/c:m	S
    //   922: invokevirtual 341	com/tencent/mobileqq/msf/sdk/utils/c:a	(II)Ljava/lang/Runnable;
    //   925: pop
    //   926: aload 5
    //   928: astore_1
    //   929: aload_1
    //   930: ifnull +47 -> 977
    //   933: aload_1
    //   934: aload_0
    //   935: getfield 23	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketInputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   938: getfield 227	com/tencent/mobileqq/msf/sdk/utils/c:d	Ljava/lang/String;
    //   941: putfield 368	com/tencent/mobileqq/msf/sdk/utils/b:a	Ljava/lang/String;
    //   944: aload_1
    //   945: invokestatic 374	java/lang/System:currentTimeMillis	()J
    //   948: putfield 378	com/tencent/mobileqq/msf/sdk/utils/b:k	J
    //   951: iload 4
    //   953: ireturn
    //   954: ldc 112
    //   956: iconst_1
    //   957: ldc_w 380
    //   960: invokestatic 363	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   963: iload 4
    //   965: ireturn
    //   966: astore_1
    //   967: ldc 112
    //   969: iconst_1
    //   970: ldc_w 382
    //   973: aload_1
    //   974: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   977: iload 4
    //   979: ireturn
    //   980: astore_1
    //   981: aload_1
    //   982: athrow
    //   983: astore_1
    //   984: ldc 112
    //   986: iconst_1
    //   987: ldc_w 384
    //   990: aload_1
    //   991: invokestatic 386	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   994: aload_1
    //   995: athrow
    //   996: astore_1
    //   997: goto -43 -> 954
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1000	0	this	MonitorSocketInputStream
    //   0	1000	1	paramArrayOfByte	byte[]
    //   0	1000	2	paramInt1	int
    //   0	1000	3	paramInt2	int
    //   10	968	4	i	int
    //   314	613	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   69	77	966	java/lang/Exception
    //   81	100	966	java/lang/Exception
    //   103	107	966	java/lang/Exception
    //   113	128	966	java/lang/Exception
    //   134	139	966	java/lang/Exception
    //   151	159	966	java/lang/Exception
    //   163	201	966	java/lang/Exception
    //   204	245	966	java/lang/Exception
    //   249	337	966	java/lang/Exception
    //   340	373	966	java/lang/Exception
    //   376	400	966	java/lang/Exception
    //   403	529	966	java/lang/Exception
    //   535	563	966	java/lang/Exception
    //   567	659	966	java/lang/Exception
    //   662	695	966	java/lang/Exception
    //   701	725	966	java/lang/Exception
    //   731	769	966	java/lang/Exception
    //   773	864	966	java/lang/Exception
    //   867	888	966	java/lang/Exception
    //   888	899	966	java/lang/Exception
    //   902	926	966	java/lang/Exception
    //   933	951	966	java/lang/Exception
    //   0	12	980	java/net/SocketTimeoutException
    //   0	12	983	java/net/SocketException
    //   69	77	996	java/lang/OutOfMemoryError
    //   81	100	996	java/lang/OutOfMemoryError
    //   103	107	996	java/lang/OutOfMemoryError
    //   113	128	996	java/lang/OutOfMemoryError
    //   134	139	996	java/lang/OutOfMemoryError
    //   151	159	996	java/lang/OutOfMemoryError
    //   163	201	996	java/lang/OutOfMemoryError
    //   204	245	996	java/lang/OutOfMemoryError
    //   249	337	996	java/lang/OutOfMemoryError
    //   340	373	996	java/lang/OutOfMemoryError
    //   376	400	996	java/lang/OutOfMemoryError
    //   403	529	996	java/lang/OutOfMemoryError
    //   535	563	996	java/lang/OutOfMemoryError
    //   567	659	996	java/lang/OutOfMemoryError
    //   662	695	996	java/lang/OutOfMemoryError
    //   701	725	996	java/lang/OutOfMemoryError
    //   731	769	996	java/lang/OutOfMemoryError
    //   773	864	996	java/lang/OutOfMemoryError
    //   867	888	996	java/lang/OutOfMemoryError
    //   888	899	996	java/lang/OutOfMemoryError
    //   902	926	996	java/lang/OutOfMemoryError
    //   933	951	996	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketInputStream
 * JD-Core Version:    0.7.0.1
 */