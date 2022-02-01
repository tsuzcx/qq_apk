package com.tencent.mobileqq.msf.core.net.c;

import android.text.TextUtils;
import java.util.HashMap;

public class i
{
  private static final String a = "PingAndTraceroute";
  private boolean b = false;
  private String c = "";
  private String d = "";
  private int e = 60;
  private int f = 10;
  private int g = 1200000;
  private int h = 3;
  private boolean i = false;
  private i.a j = new i.a();
  private HashMap k = null;
  private String l = "";
  
  public i(String paramString, boolean paramBoolean)
  {
    this.c = paramString;
    this.b = paramBoolean;
  }
  
  public i(String paramString, boolean paramBoolean, int paramInt)
  {
    this.c = paramString;
    this.b = paramBoolean;
    this.g = paramInt;
  }
  
  /* Error */
  private String a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 32
    //   2: astore 5
    //   4: invokestatic 67	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   7: astore 4
    //   9: new 69	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   16: astore 6
    //   18: aload 6
    //   20: ldc 72
    //   22: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload 6
    //   28: iload_3
    //   29: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 6
    //   35: ldc 81
    //   37: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 6
    //   43: iload_2
    //   44: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 6
    //   50: ldc 83
    //   52: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 6
    //   58: aload_1
    //   59: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 4
    //   65: aload 6
    //   67: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokevirtual 91	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   73: astore 6
    //   75: aload 5
    //   77: astore 4
    //   79: new 93	java/io/BufferedReader
    //   82: dup
    //   83: new 95	java/io/InputStreamReader
    //   86: dup
    //   87: aload 6
    //   89: invokevirtual 101	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   92: invokespecial 104	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   95: invokespecial 107	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   98: astore 7
    //   100: aload 5
    //   102: astore 4
    //   104: new 109	java/lang/String
    //   107: dup
    //   108: invokespecial 110	java/lang/String:<init>	()V
    //   111: pop
    //   112: aload 5
    //   114: astore_1
    //   115: aload_1
    //   116: astore 4
    //   118: aload 7
    //   120: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   123: astore 5
    //   125: aload 5
    //   127: ifnull +48 -> 175
    //   130: aload_1
    //   131: astore 4
    //   133: new 69	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   140: astore 8
    //   142: aload_1
    //   143: astore 4
    //   145: aload 8
    //   147: aload_1
    //   148: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_1
    //   153: astore 4
    //   155: aload 8
    //   157: aload 5
    //   159: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_1
    //   164: astore 4
    //   166: aload 8
    //   168: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore_1
    //   172: goto -57 -> 115
    //   175: aload 6
    //   177: invokevirtual 117	java/lang/Process:exitValue	()I
    //   180: pop
    //   181: goto +54 -> 235
    //   184: astore 4
    //   186: aload 6
    //   188: invokevirtual 120	java/lang/Process:destroy	()V
    //   191: goto +44 -> 235
    //   194: aload 4
    //   196: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   199: goto +36 -> 235
    //   202: astore_1
    //   203: goto +37 -> 240
    //   206: astore_1
    //   207: aload_1
    //   208: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   211: aload 6
    //   213: invokevirtual 117	java/lang/Process:exitValue	()I
    //   216: pop
    //   217: aload 4
    //   219: astore_1
    //   220: goto +15 -> 235
    //   223: astore 5
    //   225: aload 4
    //   227: astore_1
    //   228: aload 5
    //   230: astore 4
    //   232: goto -46 -> 186
    //   235: aload_1
    //   236: invokevirtual 126	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   239: areturn
    //   240: aload 6
    //   242: invokevirtual 117	java/lang/Process:exitValue	()I
    //   245: pop
    //   246: goto +18 -> 264
    //   249: astore 4
    //   251: aload 6
    //   253: invokevirtual 120	java/lang/Process:destroy	()V
    //   256: goto +8 -> 264
    //   259: aload 4
    //   261: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   264: goto +5 -> 269
    //   267: aload_1
    //   268: athrow
    //   269: goto -2 -> 267
    //   272: astore 5
    //   274: goto -80 -> 194
    //   277: astore 5
    //   279: goto -20 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	i
    //   0	282	1	paramString	String
    //   0	282	2	paramInt1	int
    //   0	282	3	paramInt2	int
    //   7	158	4	localObject1	Object
    //   184	42	4	localException1	java.lang.Exception
    //   230	1	4	localException2	java.lang.Exception
    //   249	11	4	localException3	java.lang.Exception
    //   2	156	5	str	String
    //   223	6	5	localException4	java.lang.Exception
    //   272	1	5	localException5	java.lang.Exception
    //   277	1	5	localException6	java.lang.Exception
    //   16	236	6	localObject2	Object
    //   98	21	7	localBufferedReader	java.io.BufferedReader
    //   140	27	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   175	181	184	java/lang/Exception
    //   79	100	202	finally
    //   104	112	202	finally
    //   118	125	202	finally
    //   133	142	202	finally
    //   145	152	202	finally
    //   155	163	202	finally
    //   166	172	202	finally
    //   207	211	202	finally
    //   79	100	206	java/lang/Exception
    //   104	112	206	java/lang/Exception
    //   118	125	206	java/lang/Exception
    //   133	142	206	java/lang/Exception
    //   145	152	206	java/lang/Exception
    //   155	163	206	java/lang/Exception
    //   166	172	206	java/lang/Exception
    //   211	217	223	java/lang/Exception
    //   240	246	249	java/lang/Exception
    //   186	191	272	java/lang/Exception
    //   251	256	277	java/lang/Exception
  }
  
  private String b(String paramString)
  {
    int m = paramString.indexOf("from");
    if (m >= 0)
    {
      m += 5;
      int n = paramString.indexOf(" ", m);
      if (n > 0)
      {
        paramString = paramString.substring(m, n);
        break label40;
      }
    }
    paramString = "*";
    label40:
    String str = paramString.trim();
    paramString = str;
    if (str.endsWith(":")) {
      paramString = str.substring(0, str.length() - 1).trim();
    }
    str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "*";
    }
    return str;
  }
  
  private String c(String paramString)
  {
    if (paramString.contains("ping")) {
      return paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")"));
    }
    return "";
  }
  
  private String d()
  {
    if (TextUtils.isEmpty(this.d)) {
      return this.c;
    }
    return this.d;
  }
  
  /* Error */
  public i.a a()
  {
    // Byte code:
    //   0: invokestatic 176	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore 5
    //   5: new 69	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   12: astore 16
    //   14: iconst_1
    //   15: istore_1
    //   16: aload_0
    //   17: getfield 38	com/tencent/mobileqq/msf/core/net/c/i:e	I
    //   20: istore_2
    //   21: ldc 8
    //   23: astore 12
    //   25: iload_1
    //   26: iload_2
    //   27: if_icmpge +563 -> 590
    //   30: ldc 142
    //   32: astore 13
    //   34: ldc 32
    //   36: astore 14
    //   38: iconst_0
    //   39: istore_2
    //   40: iload_2
    //   41: aload_0
    //   42: getfield 45	com/tencent/mobileqq/msf/core/net/c/i:h	I
    //   45: if_icmpge +380 -> 425
    //   48: invokestatic 176	android/os/SystemClock:elapsedRealtime	()J
    //   51: lstore 7
    //   53: aload_0
    //   54: getfield 40	com/tencent/mobileqq/msf/core/net/c/i:f	I
    //   57: istore_3
    //   58: lload 7
    //   60: lload 5
    //   62: lsub
    //   63: l2i
    //   64: istore 4
    //   66: iload 4
    //   68: aload_0
    //   69: getfield 43	com/tencent/mobileqq/msf/core/net/c/i:g	I
    //   72: if_icmplt +48 -> 120
    //   75: aload_0
    //   76: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   79: iconst_1
    //   80: putfield 177	com/tencent/mobileqq/msf/core/net/c/i$a:b	Z
    //   83: aload_0
    //   84: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   87: iload_1
    //   88: putfield 179	com/tencent/mobileqq/msf/core/net/c/i$a:a	I
    //   91: aload_0
    //   92: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   95: astore 13
    //   97: aload 16
    //   99: ldc 181
    //   101: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 13
    //   107: aload 16
    //   109: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: putfield 182	com/tencent/mobileqq/msf/core/net/c/i$a:d	Ljava/lang/String;
    //   115: aload_0
    //   116: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   119: areturn
    //   120: aload_0
    //   121: getfield 43	com/tencent/mobileqq/msf/core/net/c/i:g	I
    //   124: iload 4
    //   126: isub
    //   127: sipush 10000
    //   130: if_icmpge +17 -> 147
    //   133: aload_0
    //   134: getfield 43	com/tencent/mobileqq/msf/core/net/c/i:g	I
    //   137: iload 4
    //   139: isub
    //   140: sipush 1000
    //   143: idiv
    //   144: iconst_1
    //   145: iadd
    //   146: istore_3
    //   147: aload_0
    //   148: aload_0
    //   149: invokespecial 184	com/tencent/mobileqq/msf/core/net/c/i:d	()Ljava/lang/String;
    //   152: iload_1
    //   153: iload_3
    //   154: invokespecial 186	com/tencent/mobileqq/msf/core/net/c/i:a	(Ljava/lang/String;II)Ljava/lang/String;
    //   157: astore 14
    //   159: invokestatic 176	android/os/SystemClock:elapsedRealtime	()J
    //   162: lstore 9
    //   164: aload_0
    //   165: aload 14
    //   167: invokespecial 188	com/tencent/mobileqq/msf/core/net/c/i:c	(Ljava/lang/String;)Ljava/lang/String;
    //   170: astore 15
    //   172: aload 15
    //   174: invokestatic 160	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: ifne +622 -> 799
    //   180: aload_0
    //   181: aload 15
    //   183: putfield 36	com/tencent/mobileqq/msf/core/net/c/i:d	Ljava/lang/String;
    //   186: aload_0
    //   187: getfield 47	com/tencent/mobileqq/msf/core/net/c/i:i	Z
    //   190: ifne +609 -> 799
    //   193: aload_0
    //   194: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   197: aload 15
    //   199: putfield 189	com/tencent/mobileqq/msf/core/net/c/i$a:c	Ljava/lang/String;
    //   202: new 69	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   209: astore 17
    //   211: aload 17
    //   213: ldc 191
    //   215: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 17
    //   221: aload_0
    //   222: getfield 34	com/tencent/mobileqq/msf/core/net/c/i:c	Ljava/lang/String;
    //   225: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 17
    //   231: ldc 193
    //   233: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload 17
    //   239: aload 15
    //   241: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload 17
    //   247: ldc 195
    //   249: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 17
    //   255: aload_0
    //   256: getfield 38	com/tencent/mobileqq/msf/core/net/c/i:e	I
    //   259: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 17
    //   265: ldc 197
    //   267: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 17
    //   273: aload_0
    //   274: getfield 40	com/tencent/mobileqq/msf/core/net/c/i:f	I
    //   277: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 17
    //   283: ldc 199
    //   285: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload 17
    //   291: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: astore 15
    //   296: aload_0
    //   297: iconst_1
    //   298: putfield 47	com/tencent/mobileqq/msf/core/net/c/i:i	Z
    //   301: aload_0
    //   302: getfield 30	com/tencent/mobileqq/msf/core/net/c/i:b	Z
    //   305: istore 11
    //   307: iload 11
    //   309: ifeq +482 -> 791
    //   312: aload 12
    //   314: iconst_1
    //   315: aload 15
    //   317: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: goto +3 -> 323
    //   323: aload 16
    //   325: aload 15
    //   327: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 16
    //   333: ldc 181
    //   335: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: goto +3 -> 342
    //   342: aload_0
    //   343: aload 14
    //   345: invokespecial 206	com/tencent/mobileqq/msf/core/net/c/i:b	(Ljava/lang/String;)Ljava/lang/String;
    //   348: astore 14
    //   350: aload 14
    //   352: ldc 142
    //   354: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   357: ifne +452 -> 809
    //   360: aload 14
    //   362: aload 13
    //   364: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   367: ifeq +435 -> 802
    //   370: ldc 32
    //   372: astore 14
    //   374: goto +3 -> 377
    //   377: ldc 212
    //   379: iconst_2
    //   380: anewarray 4	java/lang/Object
    //   383: dup
    //   384: iconst_0
    //   385: aload 14
    //   387: aastore
    //   388: dup
    //   389: iconst_1
    //   390: lload 9
    //   392: lload 7
    //   394: lsub
    //   395: invokestatic 218	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   398: aastore
    //   399: invokestatic 222	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   402: invokevirtual 223	java/lang/String:toString	()Ljava/lang/String;
    //   405: astore 14
    //   407: goto +3 -> 410
    //   410: aload 16
    //   412: aload 14
    //   414: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: iload_2
    //   419: iconst_1
    //   420: iadd
    //   421: istore_2
    //   422: goto -382 -> 40
    //   425: aload 12
    //   427: astore 15
    //   429: aload 16
    //   431: ldc 181
    //   433: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload_0
    //   438: getfield 30	com/tencent/mobileqq/msf/core/net/c/i:b	Z
    //   441: ifeq +11 -> 452
    //   444: aload 15
    //   446: iconst_1
    //   447: aload 14
    //   449: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   452: aload_0
    //   453: getfield 34	com/tencent/mobileqq/msf/core/net/c/i:c	Ljava/lang/String;
    //   456: aload 13
    //   458: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   461: ifne +18 -> 479
    //   464: aload_0
    //   465: getfield 36	com/tencent/mobileqq/msf/core/net/c/i:d	Ljava/lang/String;
    //   468: aload 13
    //   470: invokevirtual 210	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   473: ifeq +348 -> 821
    //   476: goto +3 -> 479
    //   479: aload_0
    //   480: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   483: iconst_1
    //   484: putfield 177	com/tencent/mobileqq/msf/core/net/c/i$a:b	Z
    //   487: aload_0
    //   488: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   491: iload_1
    //   492: putfield 179	com/tencent/mobileqq/msf/core/net/c/i$a:a	I
    //   495: aload 15
    //   497: astore 12
    //   499: goto +95 -> 594
    //   502: astore 13
    //   504: goto +5 -> 509
    //   507: astore 13
    //   509: aload 13
    //   511: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   514: new 69	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   521: astore 14
    //   523: aload 14
    //   525: ldc 225
    //   527: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload 14
    //   533: aload 13
    //   535: invokevirtual 228	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   538: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload 14
    //   544: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: astore 13
    //   549: aload_0
    //   550: getfield 30	com/tencent/mobileqq/msf/core/net/c/i:b	Z
    //   553: ifeq +14 -> 567
    //   556: aload 12
    //   558: iconst_1
    //   559: aload 13
    //   561: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: goto +3 -> 567
    //   567: aload 16
    //   569: aload 13
    //   571: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload 16
    //   577: ldc 181
    //   579: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: iload_1
    //   584: iconst_1
    //   585: iadd
    //   586: istore_1
    //   587: goto -571 -> 16
    //   590: ldc 8
    //   592: astore 12
    //   594: aload_0
    //   595: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   598: getfield 177	com/tencent/mobileqq/msf/core/net/c/i$a:b	Z
    //   601: ifeq +79 -> 680
    //   604: new 69	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   611: astore 13
    //   613: aload 13
    //   615: ldc 230
    //   617: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: pop
    //   621: aload 13
    //   623: aload_0
    //   624: getfield 34	com/tencent/mobileqq/msf/core/net/c/i:c	Ljava/lang/String;
    //   627: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: aload 13
    //   633: ldc 167
    //   635: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: pop
    //   639: aload 13
    //   641: aload_0
    //   642: getfield 36	com/tencent/mobileqq/msf/core/net/c/i:d	Ljava/lang/String;
    //   645: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: aload 13
    //   651: ldc 232
    //   653: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload 13
    //   659: aload_0
    //   660: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   663: getfield 179	com/tencent/mobileqq/msf/core/net/c/i$a:a	I
    //   666: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   669: pop
    //   670: aload 13
    //   672: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: astore 13
    //   677: goto +76 -> 753
    //   680: new 69	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   687: astore 13
    //   689: aload 13
    //   691: ldc 234
    //   693: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload 13
    //   699: aload_0
    //   700: getfield 34	com/tencent/mobileqq/msf/core/net/c/i:c	Ljava/lang/String;
    //   703: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: aload 13
    //   709: ldc 167
    //   711: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload 13
    //   717: aload_0
    //   718: getfield 36	com/tencent/mobileqq/msf/core/net/c/i:d	Ljava/lang/String;
    //   721: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: pop
    //   725: aload 13
    //   727: ldc 232
    //   729: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: pop
    //   733: aload 13
    //   735: aload_0
    //   736: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   739: getfield 179	com/tencent/mobileqq/msf/core/net/c/i$a:a	I
    //   742: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: aload 13
    //   748: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: astore 13
    //   753: aload_0
    //   754: getfield 30	com/tencent/mobileqq/msf/core/net/c/i:b	Z
    //   757: ifeq +17 -> 774
    //   760: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   763: ifeq +11 -> 774
    //   766: aload 12
    //   768: iconst_2
    //   769: aload 13
    //   771: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   774: aload_0
    //   775: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   778: aload 16
    //   780: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   783: putfield 182	com/tencent/mobileqq/msf/core/net/c/i$a:d	Ljava/lang/String;
    //   786: aload_0
    //   787: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   790: areturn
    //   791: goto -468 -> 323
    //   794: astore 13
    //   796: goto +22 -> 818
    //   799: goto -457 -> 342
    //   802: aload 14
    //   804: astore 13
    //   806: goto -429 -> 377
    //   809: ldc 240
    //   811: astore 14
    //   813: goto -403 -> 410
    //   816: astore 13
    //   818: goto -309 -> 509
    //   821: goto -238 -> 583
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	824	0	this	i
    //   15	572	1	m	int
    //   20	402	2	n	int
    //   57	97	3	i1	int
    //   64	76	4	i2	int
    //   3	58	5	l1	long
    //   51	342	7	l2	long
    //   162	229	9	l3	long
    //   305	3	11	bool	boolean
    //   23	744	12	localObject1	Object
    //   32	437	13	localObject2	Object
    //   502	1	13	localException1	java.lang.Exception
    //   507	27	13	localException2	java.lang.Exception
    //   547	223	13	localObject3	Object
    //   794	1	13	localException3	java.lang.Exception
    //   804	1	13	localObject4	Object
    //   816	1	13	localException4	java.lang.Exception
    //   36	776	14	localObject5	Object
    //   170	326	15	localObject6	Object
    //   12	767	16	localStringBuilder1	java.lang.StringBuilder
    //   209	81	17	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   312	320	502	java/lang/Exception
    //   323	339	502	java/lang/Exception
    //   342	370	502	java/lang/Exception
    //   377	407	502	java/lang/Exception
    //   410	418	502	java/lang/Exception
    //   429	452	502	java/lang/Exception
    //   452	476	502	java/lang/Exception
    //   479	495	502	java/lang/Exception
    //   40	58	507	java/lang/Exception
    //   211	307	794	java/lang/Exception
    //   66	120	816	java/lang/Exception
    //   120	147	816	java/lang/Exception
    //   147	211	816	java/lang/Exception
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(String paramString)
  {
    this.l = paramString;
  }
  
  public void a(HashMap paramHashMap)
  {
    this.k = paramHashMap;
  }
  
  /* Error */
  public i.a b()
  {
    // Byte code:
    //   0: invokestatic 176	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_1
    //   4: new 69	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   11: astore 6
    //   13: aload_0
    //   14: getfield 56	com/tencent/mobileqq/msf/core/net/c/i:l	Ljava/lang/String;
    //   17: invokestatic 160	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: istore_3
    //   21: iload_3
    //   22: ifne +132 -> 154
    //   25: new 69	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   32: astore 4
    //   34: aload 4
    //   36: ldc 245
    //   38: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload 4
    //   44: aload_0
    //   45: getfield 56	com/tencent/mobileqq/msf/core/net/c/i:l	Ljava/lang/String;
    //   48: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 4
    //   54: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore 5
    //   59: aload 5
    //   61: astore 4
    //   63: aload 5
    //   65: ldc 247
    //   67: invokevirtual 165	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   70: ifne +35 -> 105
    //   73: new 69	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   80: astore 4
    //   82: aload 4
    //   84: aload 5
    //   86: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 4
    //   92: ldc 249
    //   94: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload 4
    //   100: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore 4
    //   105: aload 4
    //   107: astore 5
    //   109: aload 4
    //   111: ldc 251
    //   113: invokevirtual 165	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   116: ifne +70 -> 186
    //   119: new 69	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   126: astore 5
    //   128: aload 5
    //   130: aload 4
    //   132: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 5
    //   138: ldc 253
    //   140: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 5
    //   146: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: astore 5
    //   151: goto +35 -> 186
    //   154: new 69	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   161: astore 4
    //   163: aload 4
    //   165: ldc 245
    //   167: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 4
    //   173: ldc 255
    //   175: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 4
    //   181: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: astore 5
    //   186: new 69	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   193: astore 4
    //   195: aload 4
    //   197: aload 5
    //   199: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 4
    //   205: aload_0
    //   206: invokespecial 184	com/tencent/mobileqq/msf/core/net/c/i:d	()Ljava/lang/String;
    //   209: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 4
    //   215: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: astore 4
    //   220: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +40 -> 263
    //   226: new 69	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   233: astore 5
    //   235: aload 5
    //   237: ldc_w 257
    //   240: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 5
    //   246: aload 4
    //   248: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: ldc 8
    //   254: iconst_2
    //   255: aload 5
    //   257: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: invokestatic 67	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   266: aload 4
    //   268: invokevirtual 91	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   271: astore 5
    //   273: new 93	java/io/BufferedReader
    //   276: dup
    //   277: new 95	java/io/InputStreamReader
    //   280: dup
    //   281: aload 5
    //   283: invokevirtual 101	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   286: invokespecial 104	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   289: invokespecial 107	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   292: astore 4
    //   294: new 109	java/lang/String
    //   297: dup
    //   298: invokespecial 110	java/lang/String:<init>	()V
    //   301: pop
    //   302: aload 4
    //   304: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   307: astore 7
    //   309: aload 7
    //   311: ifnull +33 -> 344
    //   314: aload 6
    //   316: aload 7
    //   318: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 6
    //   324: ldc 181
    //   326: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: invokestatic 176	android/os/SystemClock:elapsedRealtime	()J
    //   333: lload_1
    //   334: lsub
    //   335: aload_0
    //   336: getfield 43	com/tencent/mobileqq/msf/core/net/c/i:g	I
    //   339: i2l
    //   340: lcmp
    //   341: iflt -39 -> 302
    //   344: aload_0
    //   345: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   348: iconst_1
    //   349: putfield 177	com/tencent/mobileqq/msf/core/net/c/i$a:b	Z
    //   352: aload 5
    //   354: invokevirtual 117	java/lang/Process:exitValue	()I
    //   357: pop
    //   358: goto +99 -> 457
    //   361: astore 4
    //   363: aload 5
    //   365: invokevirtual 120	java/lang/Process:destroy	()V
    //   368: goto +89 -> 457
    //   371: aload 4
    //   373: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   376: goto +81 -> 457
    //   379: astore 4
    //   381: goto +29 -> 410
    //   384: astore 4
    //   386: aload 4
    //   388: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   391: aload 5
    //   393: invokevirtual 117	java/lang/Process:exitValue	()I
    //   396: pop
    //   397: goto +60 -> 457
    //   400: astore 4
    //   402: aload 5
    //   404: invokevirtual 120	java/lang/Process:destroy	()V
    //   407: goto +50 -> 457
    //   410: aload 5
    //   412: invokevirtual 117	java/lang/Process:exitValue	()I
    //   415: pop
    //   416: goto +18 -> 434
    //   419: astore 7
    //   421: aload 5
    //   423: invokevirtual 120	java/lang/Process:destroy	()V
    //   426: goto +8 -> 434
    //   429: aload 7
    //   431: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   434: aload 4
    //   436: athrow
    //   437: astore 4
    //   439: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq +15 -> 457
    //   445: ldc 8
    //   447: iconst_2
    //   448: aload 4
    //   450: iconst_0
    //   451: anewarray 4	java/lang/Object
    //   454: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   457: aload_0
    //   458: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   461: aload 6
    //   463: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: putfield 182	com/tencent/mobileqq/msf/core/net/c/i$a:d	Ljava/lang/String;
    //   469: aload_0
    //   470: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   473: astore 4
    //   475: aload 4
    //   477: aload_0
    //   478: aload 4
    //   480: getfield 182	com/tencent/mobileqq/msf/core/net/c/i$a:d	Ljava/lang/String;
    //   483: invokevirtual 126	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   486: invokespecial 188	com/tencent/mobileqq/msf/core/net/c/i:c	(Ljava/lang/String;)Ljava/lang/String;
    //   489: putfield 189	com/tencent/mobileqq/msf/core/net/c/i$a:c	Ljava/lang/String;
    //   492: aload_0
    //   493: getfield 52	com/tencent/mobileqq/msf/core/net/c/i:j	Lcom/tencent/mobileqq/msf/core/net/c/i$a;
    //   496: areturn
    //   497: astore 5
    //   499: goto -128 -> 371
    //   502: astore 5
    //   504: goto -75 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	this	i
    //   3	331	1	l1	long
    //   20	2	3	bool	boolean
    //   32	271	4	localObject1	Object
    //   361	11	4	localException1	java.lang.Exception
    //   379	1	4	localObject2	Object
    //   384	3	4	localException2	java.lang.Exception
    //   400	35	4	localException3	java.lang.Exception
    //   437	12	4	localException4	java.lang.Exception
    //   473	6	4	locala	i.a
    //   57	365	5	localObject3	Object
    //   497	1	5	localException5	java.lang.Exception
    //   502	1	5	localException6	java.lang.Exception
    //   11	451	6	localStringBuilder	java.lang.StringBuilder
    //   307	10	7	str	String
    //   419	11	7	localException7	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   352	358	361	java/lang/Exception
    //   273	302	379	finally
    //   302	309	379	finally
    //   314	344	379	finally
    //   344	352	379	finally
    //   386	391	379	finally
    //   273	302	384	java/lang/Exception
    //   302	309	384	java/lang/Exception
    //   314	344	384	java/lang/Exception
    //   344	352	384	java/lang/Exception
    //   391	397	400	java/lang/Exception
    //   410	416	419	java/lang/Exception
    //   13	21	437	java/lang/Exception
    //   25	59	437	java/lang/Exception
    //   63	105	437	java/lang/Exception
    //   109	151	437	java/lang/Exception
    //   154	186	437	java/lang/Exception
    //   186	263	437	java/lang/Exception
    //   263	273	437	java/lang/Exception
    //   371	376	437	java/lang/Exception
    //   429	434	437	java/lang/Exception
    //   434	437	437	java/lang/Exception
    //   363	368	497	java/lang/Exception
    //   402	407	497	java/lang/Exception
    //   421	426	502	java/lang/Exception
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public i.a c()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c.i
 * JD-Core Version:    0.7.0.1
 */