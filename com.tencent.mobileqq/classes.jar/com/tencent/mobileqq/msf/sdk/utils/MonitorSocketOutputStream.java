package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.c.k;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class MonitorSocketOutputStream
  extends OutputStream
{
  private Context context;
  private OutputStream mOutputStream;
  private c monitorSocketImpl;
  private String refer = null;
  private String urlTag = "";
  
  public MonitorSocketOutputStream(OutputStream paramOutputStream, c paramc, Context paramContext)
  {
    this.mOutputStream = paramOutputStream;
    this.monitorSocketImpl = paramc;
    this.context = paramContext;
  }
  
  public static String getMType(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    String str1 = c.k;
    int i = paramInt1;
    int j = paramInt1;
    if ((i >= paramInt2 + paramInt1) || (i + 1 == paramInt2)) {}
    String str2;
    label100:
    do
    {
      return str1;
      int k = j;
      if (paramArrayOfByte[i] == 13)
      {
        k = j;
        if (paramArrayOfByte[(i + 1)] == 10)
        {
          str2 = new String(paramArrayOfByte, j, i - j);
          j = str2.indexOf("mType=");
          if (j != -1) {
            break label100;
          }
          k = i + 2;
        }
      }
      i += 1;
      j = k;
      break;
      paramInt1 = str2.indexOf("&", j + 6);
      if (paramInt1 != -1) {
        break label148;
      }
      paramInt1 = str2.indexOf(" ", j + 6);
    } while (paramInt1 == -1);
    return str2.substring(j + 6, paramInt1);
    label148:
    return str2.substring(j + 6, paramInt1);
  }
  
  public static String getRefer(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt;
    Object localObject1;
    if (i < paramArrayOfByte.length) {
      if ((paramArrayOfByte[i] == 13) && (paramArrayOfByte[(i + 1)] == 10))
      {
        localObject1 = new String(paramArrayOfByte, paramInt, i - paramInt).trim().split(" ");
        if (localObject1.length == 2) {
          localObject1 = localObject1[0];
        }
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        i = paramArrayOfByte.length - 1;
        for (;;)
        {
          localObject2 = localObject1;
          if (i < paramInt) {
            break;
          }
          if (paramArrayOfByte[i] == 32)
          {
            localObject1 = new String(paramArrayOfByte, paramInt, i - paramInt);
            localObject2 = ((String)localObject1).trim().split(" ");
            if (localObject2.length == 2) {
              localObject1 = localObject2[0];
            }
          }
          i -= 1;
        }
        localObject1 = "";
        continue;
        i += 1;
        break;
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new String(paramArrayOfByte, paramInt, paramArrayOfByte.length - paramInt);
      }
      paramArrayOfByte = (byte[])localObject1;
      if (((String)localObject1).length() > 100) {
        paramArrayOfByte = ((String)localObject1).substring(0, 42);
      }
      return paramArrayOfByte;
      localObject1 = null;
    }
  }
  
  private void initKnownMType()
  {
    if ((this.monitorSocketImpl.f.contains("beacon")) || (this.monitorSocketImpl.f.contains("feedback"))) {
      this.monitorSocketImpl.j = "beacon";
    }
    do
    {
      do
      {
        return;
        if (this.monitorSocketImpl.f.contains("map"))
        {
          this.monitorSocketImpl.j = "Map";
          return;
        }
        if ((this.monitorSocketImpl.f.toLowerCase().contains("tmassistant")) || (this.monitorSocketImpl.f.contains("apkupdate")))
        {
          this.monitorSocketImpl.j = "yingyongbao";
          return;
        }
        if (this.monitorSocketImpl.f.contains("smtt"))
        {
          this.monitorSocketImpl.j = "Web";
          return;
        }
        if (this.monitorSocketImpl.f.contains("readinjoy"))
        {
          this.monitorSocketImpl.j = "Readinjoy";
          return;
        }
        if ((this.monitorSocketImpl.f.contains("biz")) || (this.monitorSocketImpl.f.contains("troop")))
        {
          this.monitorSocketImpl.j = "AppDepart";
          return;
        }
        if ((this.monitorSocketImpl.f.contains("highway")) && (TextUtils.isEmpty(this.refer)))
        {
          this.monitorSocketImpl.j = "highway";
          return;
        }
      } while (TextUtils.isEmpty(this.refer));
      if (this.refer.contains("beacon"))
      {
        this.monitorSocketImpl.j = "beacon";
        this.refer = "/mType=beacon";
        return;
      }
      if (this.refer.contains("mstat/report"))
      {
        this.monitorSocketImpl.j = "MTA";
        return;
      }
    } while (!this.refer.contains("comdata"));
    this.monitorSocketImpl.j = "comdata";
  }
  
  public void close()
  {
    this.mOutputStream.close();
  }
  
  public void flush()
  {
    this.mOutputStream.flush();
  }
  
  /* Error */
  public void getSocketInfo(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   7: getstatic 38	com/tencent/mobileqq/msf/sdk/utils/c:k	Ljava/lang/String;
    //   10: putfield 89	com/tencent/mobileqq/msf/sdk/utils/c:j	Ljava/lang/String;
    //   13: new 144	com/tencent/mobileqq/msf/sdk/utils/MonitorHttpInfo
    //   16: dup
    //   17: invokespecial 145	com/tencent/mobileqq/msf/sdk/utils/MonitorHttpInfo:<init>	()V
    //   20: astore 7
    //   22: iconst_4
    //   23: newarray byte
    //   25: astore 8
    //   27: aload_1
    //   28: iconst_0
    //   29: aload 8
    //   31: iconst_0
    //   32: aload 8
    //   34: arraylength
    //   35: invokestatic 151	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   38: new 40	java/lang/String
    //   41: dup
    //   42: aload 8
    //   44: invokespecial 154	java/lang/String:<init>	([B)V
    //   47: ldc 156
    //   49: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifeq +527 -> 579
    //   55: aload_0
    //   56: aload_1
    //   57: iconst_5
    //   58: invokestatic 162	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:getRefer	([BI)Ljava/lang/String;
    //   61: putfield 20	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:refer	Ljava/lang/String;
    //   64: aload_0
    //   65: new 164	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   72: ldc 167
    //   74: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_0
    //   78: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   81: getfield 174	com/tencent/mobileqq/msf/sdk/utils/c:b	Ljava/lang/String;
    //   84: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc 176
    //   89: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   96: getfield 180	com/tencent/mobileqq/msf/sdk/utils/c:c	I
    //   99: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: getfield 20	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:refer	Ljava/lang/String;
    //   106: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: putfield 24	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:urlTag	Ljava/lang/String;
    //   115: aload 7
    //   117: ldc 156
    //   119: invokevirtual 190	com/tencent/mobileqq/msf/sdk/utils/MonitorHttpInfo:setMethod	(Ljava/lang/String;)V
    //   122: aload 7
    //   124: aload_0
    //   125: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   128: getfield 174	com/tencent/mobileqq/msf/sdk/utils/c:b	Ljava/lang/String;
    //   131: invokevirtual 193	com/tencent/mobileqq/msf/sdk/utils/MonitorHttpInfo:setHost	(Ljava/lang/String;)V
    //   134: aload 7
    //   136: new 164	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   143: aload_0
    //   144: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   147: getfield 180	com/tencent/mobileqq/msf/sdk/utils/c:c	I
    //   150: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: ldc 22
    //   155: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokevirtual 196	com/tencent/mobileqq/msf/sdk/utils/MonitorHttpInfo:setPort	(Ljava/lang/String;)V
    //   164: aload 7
    //   166: aload_0
    //   167: getfield 20	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:refer	Ljava/lang/String;
    //   170: invokevirtual 199	com/tencent/mobileqq/msf/sdk/utils/MonitorHttpInfo:setUrl	(Ljava/lang/String;)V
    //   173: iload 4
    //   175: ifeq +126 -> 301
    //   178: new 40	java/lang/String
    //   181: dup
    //   182: aload_1
    //   183: iload_2
    //   184: iload_3
    //   185: invokespecial 43	java/lang/String:<init>	([BII)V
    //   188: astore 8
    //   190: aload 8
    //   192: ifnull +37 -> 229
    //   195: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +31 -> 229
    //   201: aload 8
    //   203: ldc 207
    //   205: invokevirtual 49	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   208: istore 5
    //   210: iload 5
    //   212: ifle +17 -> 229
    //   215: ldc 209
    //   217: iconst_2
    //   218: aload 8
    //   220: iconst_0
    //   221: iload 5
    //   223: invokevirtual 60	java/lang/String:substring	(II)Ljava/lang/String;
    //   226: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload 8
    //   231: ldc 215
    //   233: invokevirtual 49	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   236: istore 5
    //   238: iload 5
    //   240: iflt +48 -> 288
    //   243: aload 8
    //   245: ldc 207
    //   247: iload 5
    //   249: invokevirtual 54	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   252: istore 6
    //   254: aload_0
    //   255: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   258: aload 8
    //   260: iload 5
    //   262: ldc 215
    //   264: invokevirtual 74	java/lang/String:length	()I
    //   267: iadd
    //   268: iload 6
    //   270: invokevirtual 60	java/lang/String:substring	(II)Ljava/lang/String;
    //   273: putfield 218	com/tencent/mobileqq/msf/sdk/utils/c:a	Ljava/lang/String;
    //   276: aload 7
    //   278: aload_0
    //   279: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   282: getfield 218	com/tencent/mobileqq/msf/sdk/utils/c:a	Ljava/lang/String;
    //   285: invokevirtual 193	com/tencent/mobileqq/msf/sdk/utils/MonitorHttpInfo:setHost	(Ljava/lang/String;)V
    //   288: aload_0
    //   289: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   292: aload_1
    //   293: iload_2
    //   294: iload_3
    //   295: invokestatic 220	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:getMType	([BII)Ljava/lang/String;
    //   298: putfield 89	com/tencent/mobileqq/msf/sdk/utils/c:j	Ljava/lang/String;
    //   301: aload_0
    //   302: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   305: getfield 89	com/tencent/mobileqq/msf/sdk/utils/c:j	Ljava/lang/String;
    //   308: getstatic 38	com/tencent/mobileqq/msf/sdk/utils/c:k	Ljava/lang/String;
    //   311: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   314: ifne +33 -> 347
    //   317: aload_0
    //   318: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   321: getfield 89	com/tencent/mobileqq/msf/sdk/utils/c:j	Ljava/lang/String;
    //   324: ldc 222
    //   326: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   329: ifne +18 -> 347
    //   332: aload_0
    //   333: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   336: getfield 89	com/tencent/mobileqq/msf/sdk/utils/c:j	Ljava/lang/String;
    //   339: ldc 224
    //   341: invokevirtual 84	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   344: ifeq +7 -> 351
    //   347: aload_0
    //   348: invokespecial 226	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:initKnownMType	()V
    //   351: aload_0
    //   352: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   355: getfield 89	com/tencent/mobileqq/msf/sdk/utils/c:j	Ljava/lang/String;
    //   358: getstatic 38	com/tencent/mobileqq/msf/sdk/utils/c:k	Ljava/lang/String;
    //   361: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   364: ifne +18 -> 382
    //   367: aload_0
    //   368: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   371: getfield 89	com/tencent/mobileqq/msf/sdk/utils/c:j	Ljava/lang/String;
    //   374: ldc 222
    //   376: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   379: ifeq +46 -> 425
    //   382: aload_0
    //   383: getfield 20	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:refer	Ljava/lang/String;
    //   386: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   389: ifne +36 -> 425
    //   392: aload_0
    //   393: getfield 20	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:refer	Ljava/lang/String;
    //   396: ldc 228
    //   398: invokevirtual 49	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   401: istore 5
    //   403: iload 5
    //   405: ifle +329 -> 734
    //   408: aload_0
    //   409: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   412: aload_0
    //   413: getfield 20	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:refer	Ljava/lang/String;
    //   416: iconst_0
    //   417: iload 5
    //   419: invokevirtual 60	java/lang/String:substring	(II)Ljava/lang/String;
    //   422: putfield 89	com/tencent/mobileqq/msf/sdk/utils/c:j	Ljava/lang/String;
    //   425: iload 4
    //   427: ifeq +64 -> 491
    //   430: aload_0
    //   431: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   434: getfield 89	com/tencent/mobileqq/msf/sdk/utils/c:j	Ljava/lang/String;
    //   437: getstatic 38	com/tencent/mobileqq/msf/sdk/utils/c:k	Ljava/lang/String;
    //   440: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   443: ifeq +48 -> 491
    //   446: aload_0
    //   447: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   450: getfield 218	com/tencent/mobileqq/msf/sdk/utils/c:a	Ljava/lang/String;
    //   453: ldc 230
    //   455: invokevirtual 84	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   458: ifeq +302 -> 760
    //   461: aload_0
    //   462: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   465: aload_0
    //   466: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   469: getfield 218	com/tencent/mobileqq/msf/sdk/utils/c:a	Ljava/lang/String;
    //   472: iconst_0
    //   473: aload_0
    //   474: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   477: getfield 218	com/tencent/mobileqq/msf/sdk/utils/c:a	Ljava/lang/String;
    //   480: ldc 230
    //   482: invokevirtual 49	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   485: invokevirtual 60	java/lang/String:substring	(II)Ljava/lang/String;
    //   488: putfield 89	com/tencent/mobileqq/msf/sdk/utils/c:j	Ljava/lang/String;
    //   491: iload 4
    //   493: ifeq +85 -> 578
    //   496: new 164	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   503: astore 8
    //   505: aload_0
    //   506: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   509: astore 9
    //   511: aload 9
    //   513: aload 8
    //   515: aload 9
    //   517: getfield 218	com/tencent/mobileqq/msf/sdk/utils/c:a	Ljava/lang/String;
    //   520: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: aload_0
    //   524: getfield 20	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:refer	Ljava/lang/String;
    //   527: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: putfield 218	com/tencent/mobileqq/msf/sdk/utils/c:a	Ljava/lang/String;
    //   536: aload 7
    //   538: aload_0
    //   539: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   542: getfield 89	com/tencent/mobileqq/msf/sdk/utils/c:j	Ljava/lang/String;
    //   545: invokevirtual 233	com/tencent/mobileqq/msf/sdk/utils/MonitorHttpInfo:setType	(Ljava/lang/String;)V
    //   548: iload_3
    //   549: newarray byte
    //   551: astore 8
    //   553: aload_1
    //   554: iload_2
    //   555: aload 8
    //   557: iconst_0
    //   558: iload_3
    //   559: invokestatic 151	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   562: aload 7
    //   564: aload 8
    //   566: invokevirtual 236	com/tencent/mobileqq/msf/sdk/utils/MonitorHttpInfo:setRequestBuffer	([B)V
    //   569: aload_0
    //   570: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   573: aload 7
    //   575: putfield 240	com/tencent/mobileqq/msf/sdk/utils/c:g	Lcom/tencent/mobileqq/msf/sdk/utils/MonitorHttpInfo;
    //   578: return
    //   579: new 40	java/lang/String
    //   582: dup
    //   583: aload 8
    //   585: invokespecial 154	java/lang/String:<init>	([B)V
    //   588: ldc 242
    //   590: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   593: ifeq +231 -> 824
    //   596: aload_0
    //   597: aload_1
    //   598: iconst_4
    //   599: invokestatic 162	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:getRefer	([BI)Ljava/lang/String;
    //   602: putfield 20	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:refer	Ljava/lang/String;
    //   605: aload_0
    //   606: new 164	java/lang/StringBuilder
    //   609: dup
    //   610: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   613: ldc 167
    //   615: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload_0
    //   619: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   622: getfield 174	com/tencent/mobileqq/msf/sdk/utils/c:b	Ljava/lang/String;
    //   625: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: ldc 176
    //   630: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: aload_0
    //   634: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   637: getfield 180	com/tencent/mobileqq/msf/sdk/utils/c:c	I
    //   640: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   643: aload_0
    //   644: getfield 20	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:refer	Ljava/lang/String;
    //   647: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   653: putfield 24	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:urlTag	Ljava/lang/String;
    //   656: aload 7
    //   658: ldc 244
    //   660: invokevirtual 190	com/tencent/mobileqq/msf/sdk/utils/MonitorHttpInfo:setMethod	(Ljava/lang/String;)V
    //   663: aload 7
    //   665: aload_0
    //   666: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   669: getfield 174	com/tencent/mobileqq/msf/sdk/utils/c:b	Ljava/lang/String;
    //   672: invokevirtual 193	com/tencent/mobileqq/msf/sdk/utils/MonitorHttpInfo:setHost	(Ljava/lang/String;)V
    //   675: aload 7
    //   677: new 164	java/lang/StringBuilder
    //   680: dup
    //   681: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   684: aload_0
    //   685: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   688: getfield 180	com/tencent/mobileqq/msf/sdk/utils/c:c	I
    //   691: invokevirtual 183	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   694: ldc 22
    //   696: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: invokevirtual 196	com/tencent/mobileqq/msf/sdk/utils/MonitorHttpInfo:setPort	(Ljava/lang/String;)V
    //   705: aload 7
    //   707: aload_0
    //   708: getfield 20	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:refer	Ljava/lang/String;
    //   711: invokevirtual 199	com/tencent/mobileqq/msf/sdk/utils/MonitorHttpInfo:setUrl	(Ljava/lang/String;)V
    //   714: goto -541 -> 173
    //   717: astore_1
    //   718: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   721: ifeq -143 -> 578
    //   724: ldc 209
    //   726: iconst_2
    //   727: ldc 246
    //   729: aload_1
    //   730: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   733: return
    //   734: aload_0
    //   735: getfield 20	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:refer	Ljava/lang/String;
    //   738: invokevirtual 74	java/lang/String:length	()I
    //   741: bipush 20
    //   743: if_icmpge -318 -> 425
    //   746: aload_0
    //   747: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   750: aload_0
    //   751: getfield 20	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:refer	Ljava/lang/String;
    //   754: putfield 89	com/tencent/mobileqq/msf/sdk/utils/c:j	Ljava/lang/String;
    //   757: goto -332 -> 425
    //   760: aload_0
    //   761: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   764: getfield 218	com/tencent/mobileqq/msf/sdk/utils/c:a	Ljava/lang/String;
    //   767: ldc 251
    //   769: invokevirtual 84	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   772: ifne +18 -> 790
    //   775: aload_0
    //   776: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   779: getfield 218	com/tencent/mobileqq/msf/sdk/utils/c:a	Ljava/lang/String;
    //   782: ldc 253
    //   784: invokevirtual 84	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   787: ifeq -296 -> 491
    //   790: aload_0
    //   791: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   794: aload_0
    //   795: getfield 28	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketOutputStream:monitorSocketImpl	Lcom/tencent/mobileqq/msf/sdk/utils/c;
    //   798: getfield 218	com/tencent/mobileqq/msf/sdk/utils/c:a	Ljava/lang/String;
    //   801: putfield 89	com/tencent/mobileqq/msf/sdk/utils/c:j	Ljava/lang/String;
    //   804: goto -313 -> 491
    //   807: astore_1
    //   808: invokestatic 205	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   811: ifeq -233 -> 578
    //   814: ldc 209
    //   816: iconst_2
    //   817: ldc 255
    //   819: aload_1
    //   820: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   823: return
    //   824: iconst_0
    //   825: istore 4
    //   827: goto -654 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	830	0	this	MonitorSocketOutputStream
    //   0	830	1	paramArrayOfByte	byte[]
    //   0	830	2	paramInt1	int
    //   0	830	3	paramInt2	int
    //   1	825	4	i	int
    //   208	210	5	j	int
    //   252	17	6	k	int
    //   20	686	7	localMonitorHttpInfo	MonitorHttpInfo
    //   25	559	8	localObject	Object
    //   509	7	9	localc	c
    // Exception table:
    //   from	to	target	type
    //   22	173	717	java/lang/Exception
    //   178	190	717	java/lang/Exception
    //   195	210	717	java/lang/Exception
    //   215	229	717	java/lang/Exception
    //   229	238	717	java/lang/Exception
    //   243	288	717	java/lang/Exception
    //   288	301	717	java/lang/Exception
    //   301	347	717	java/lang/Exception
    //   347	351	717	java/lang/Exception
    //   351	382	717	java/lang/Exception
    //   382	403	717	java/lang/Exception
    //   408	425	717	java/lang/Exception
    //   430	491	717	java/lang/Exception
    //   496	536	717	java/lang/Exception
    //   536	578	717	java/lang/Exception
    //   579	714	717	java/lang/Exception
    //   734	757	717	java/lang/Exception
    //   760	790	717	java/lang/Exception
    //   790	804	717	java/lang/Exception
    //   808	823	717	java/lang/Exception
    //   536	578	807	java/lang/Throwable
  }
  
  public int hashCode()
  {
    return this.mOutputStream.hashCode();
  }
  
  public void write(int paramInt)
  {
    this.mOutputStream.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = 2;
    this.mOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
    if (MonitorSocketImplFactory.isServerSocket(toString())) {
      return;
    }
    label611:
    label1009:
    label1014:
    label1017:
    for (;;)
    {
      int i;
      try
      {
        if ((this.monitorSocketImpl.d != null) && (this.monitorSocketImpl.d.contains(":MSF")))
        {
          i = NetConnInfoCenter.getSystemNetworkType();
          if (i != 0) {
            break label1017;
          }
          localObject = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
          if (localObject == null) {
            break label1017;
          }
          i = ((NetworkInfo)localObject).getType();
          if (i != 1) {
            continue;
          }
          i = j;
          if (this.monitorSocketImpl.j == null) {
            getSocketInfo(paramArrayOfByte, paramInt1, paramInt2);
          }
          if ((this.monitorSocketImpl.d == null) || (!this.monitorSocketImpl.d.contains(":MSF"))) {
            break label809;
          }
          if (!m.q.contains(toString())) {
            continue;
          }
          paramArrayOfByte = null;
          if (paramArrayOfByte == null) {
            break;
          }
          paramArrayOfByte.a = this.monitorSocketImpl.d;
          paramArrayOfByte.k = System.currentTimeMillis();
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.d("MSF.D.MonitorSocket", 1, "analyze netflow failed.", paramArrayOfByte);
        return;
        i = AppNetConnInfo.getSystemNetworkType();
        continue;
        if (MonitorSocketImplFactory.isNetworkTypeMobile(i) != true) {
          break label1014;
        }
        i = 1;
        continue;
        if (BaseApplication.exclusiveStreamList.contains(toString()))
        {
          if (!QLog.isColorLevel()) {
            break label1009;
          }
          QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.e + "|write|" + paramInt2 + "|" + i + "|BigData|" + BaseApplication.monitor.getSTATUS());
          paramArrayOfByte = null;
          continue;
        }
        if (!k.g.contains(toString())) {
          break label611;
        }
        paramArrayOfByte = this.monitorSocketImpl;
        localObject = (b)c.o.get(Integer.valueOf(this.monitorSocketImpl.e.hashCode()));
        if (localObject == null)
        {
          localObject = new b(this.monitorSocketImpl.b, null, this.monitorSocketImpl.c, c.l, paramInt2, i);
          ((b)localObject).h = "QualityTest";
          ((b)localObject).i = BaseApplication.monitor.getSTATUS();
          ((b)localObject).j = this.monitorSocketImpl.e.hashCode();
          paramArrayOfByte = this.monitorSocketImpl;
          c.o.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localObject);
          if (((b)localObject).l == null) {
            this.monitorSocketImpl.a(((b)localObject).j, c.l);
          }
          paramArrayOfByte = (byte[])localObject;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.e + "|write|" + paramInt2 + "|" + i + "|" + "QualityTest.PushList" + "|" + BaseApplication.monitor.getSTATUS());
          paramArrayOfByte = (byte[])localObject;
          continue;
        }
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        QLog.d("MSF.D.MonitorSocket", 1, "write OOM.");
        return;
      }
      paramArrayOfByte = this.monitorSocketImpl;
      c.o.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), ((b)localObject).a(paramInt2));
      continue;
      paramArrayOfByte = this.monitorSocketImpl;
      Object localObject = (b)c.o.get(Integer.valueOf(this.monitorSocketImpl.e.hashCode()));
      if (localObject == null)
      {
        localObject = new b(this.monitorSocketImpl.b, null, this.monitorSocketImpl.c, c.l, paramInt2, i);
        ((b)localObject).i = BaseApplication.monitor.getSTATUS();
        ((b)localObject).h = this.monitorSocketImpl.j;
        ((b)localObject).j = this.monitorSocketImpl.e.hashCode();
        paramArrayOfByte = this.monitorSocketImpl;
        c.o.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localObject);
      }
      for (;;)
      {
        paramArrayOfByte = (byte[])localObject;
        if (((b)localObject).l != null) {
          break;
        }
        this.monitorSocketImpl.a(((b)localObject).j, c.l);
        paramArrayOfByte = (byte[])localObject;
        break;
        paramArrayOfByte = this.monitorSocketImpl;
        c.o.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), ((b)localObject).a(paramInt2));
      }
      if (this.monitorSocketImpl.j != null)
      {
        paramArrayOfByte = this.monitorSocketImpl;
        paramArrayOfByte = (b)c.o.get(Integer.valueOf(this.monitorSocketImpl.e.hashCode()));
        if (paramArrayOfByte == null)
        {
          localObject = new b(this.monitorSocketImpl.b, this.monitorSocketImpl.a, this.monitorSocketImpl.c, c.l, paramInt2, i);
          ((b)localObject).h = this.monitorSocketImpl.j;
          ((b)localObject).j = this.monitorSocketImpl.e.hashCode();
          paramArrayOfByte = this.monitorSocketImpl;
          c.o.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localObject);
        }
        for (;;)
        {
          ((b)localObject).i = BaseApplication.monitor.getSTATUS();
          paramArrayOfByte = (byte[])localObject;
          if (((b)localObject).l != null) {
            break;
          }
          this.monitorSocketImpl.a(((b)localObject).j, c.l);
          paramArrayOfByte = (byte[])localObject;
          break;
          localObject = paramArrayOfByte.a(paramInt2);
          ((b)localObject).h = this.monitorSocketImpl.j;
        }
      }
      paramArrayOfByte = null;
      continue;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketOutputStream
 * JD-Core Version:    0.7.0.1
 */