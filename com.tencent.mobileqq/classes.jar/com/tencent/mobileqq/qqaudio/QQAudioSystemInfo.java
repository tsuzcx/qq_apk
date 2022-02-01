package com.tencent.mobileqq.qqaudio;

import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class QQAudioSystemInfo
{
  public static String a = "";
  public static String b = "";
  public static String c;
  public static String d;
  public static int e = 5;
  public static long f = 0L;
  public static int g = 1;
  public static boolean h = false;
  public static long i = 0L;
  public static boolean j = false;
  public static int k = 2;
  public static int l = 1;
  public static boolean m = true;
  public static boolean n = true;
  public static boolean o = false;
  static int t = 0;
  static long u = 0L;
  private static String v;
  public int p = 320;
  public int q = 480;
  public int r = 320;
  public int s = 240;
  
  static {}
  
  protected static float a(float paramFloat, String paramString)
  {
    int i1 = paramString.indexOf(':');
    float f1 = paramFloat;
    if (i1 > 1) {
      paramString = paramString.substring(i1 + 1, paramString.length()).trim();
    }
    try
    {
      float f2 = Float.parseFloat(paramString);
      f1 = paramFloat;
      if (f2 > paramFloat) {
        f1 = f2;
      }
      return f1;
    }
    catch (NumberFormatException paramString) {}
    return paramFloat;
  }
  
  protected static long a(long paramLong, String paramString)
  {
    int i1 = paramString.indexOf(':');
    long l1 = paramLong;
    if (i1 > 1) {
      paramString = paramString.substring(i1 + 1, paramString.length()).trim();
    }
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = paramLong;
      if (l2 >= 0L)
      {
        l2 += 1L;
        l1 = paramLong;
        if (l2 > paramLong) {
          l1 = l2;
        }
      }
      return l1;
    }
    catch (NumberFormatException paramString) {}
    return paramLong;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: getstatic 98	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:h	Z
    //   3: ifne +526 -> 529
    //   6: ldc2_w 99
    //   9: lstore_3
    //   10: ldc 101
    //   12: fstore_0
    //   13: new 103	java/lang/StringBuilder
    //   16: dup
    //   17: sipush 1024
    //   20: invokespecial 106	java/lang/StringBuilder:<init>	(I)V
    //   23: astore 9
    //   25: new 108	java/io/BufferedReader
    //   28: dup
    //   29: new 110	java/io/FileReader
    //   32: dup
    //   33: ldc 112
    //   35: invokespecial 115	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   38: invokespecial 118	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore 8
    //   43: fload_0
    //   44: fstore_1
    //   45: lload_3
    //   46: lstore 5
    //   48: aload 8
    //   50: invokevirtual 121	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore 10
    //   55: aload 10
    //   57: ifnonnull +15 -> 72
    //   60: iconst_1
    //   61: putstatic 98	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:h	Z
    //   64: lload 5
    //   66: lstore_3
    //   67: fload_1
    //   68: fstore_0
    //   69: goto +448 -> 517
    //   72: aload 10
    //   74: ldc 123
    //   76: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   79: ifeq +16 -> 95
    //   82: aload 10
    //   84: invokestatic 129	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:a	(Ljava/lang/String;)V
    //   87: lload 5
    //   89: lstore_3
    //   90: fload_1
    //   91: fstore_0
    //   92: goto -49 -> 43
    //   95: aload 10
    //   97: ldc 131
    //   99: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   102: ifeq +18 -> 120
    //   105: aload 9
    //   107: aload 10
    //   109: invokestatic 134	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:a	(Ljava/lang/StringBuilder;Ljava/lang/String;)V
    //   112: lload 5
    //   114: lstore_3
    //   115: fload_1
    //   116: fstore_0
    //   117: goto -74 -> 43
    //   120: aload 10
    //   122: ldc 136
    //   124: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   127: ifne +354 -> 481
    //   130: aload 10
    //   132: ldc 138
    //   134: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   137: istore 7
    //   139: iload 7
    //   141: ifeq +95 -> 236
    //   144: aload 10
    //   146: bipush 58
    //   148: invokevirtual 67	java/lang/String:indexOf	(I)I
    //   151: istore_2
    //   152: iload_2
    //   153: iconst_1
    //   154: if_icmple +22 -> 176
    //   157: aload 10
    //   159: iload_2
    //   160: iconst_1
    //   161: iadd
    //   162: aload 10
    //   164: invokevirtual 71	java/lang/String:length	()I
    //   167: invokevirtual 75	java/lang/String:substring	(II)Ljava/lang/String;
    //   170: invokevirtual 79	java/lang/String:trim	()Ljava/lang/String;
    //   173: putstatic 140	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:b	Ljava/lang/String;
    //   176: lload 5
    //   178: lstore_3
    //   179: fload_1
    //   180: fstore_0
    //   181: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq -141 -> 43
    //   187: aload 9
    //   189: ldc 148
    //   191: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 9
    //   197: getstatic 140	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:b	Ljava/lang/String;
    //   200: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 9
    //   206: ldc 154
    //   208: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 9
    //   214: aload 10
    //   216: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 9
    //   222: ldc 156
    //   224: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: lload 5
    //   230: lstore_3
    //   231: fload_1
    //   232: fstore_0
    //   233: goto -190 -> 43
    //   236: aload 10
    //   238: ldc 158
    //   240: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   243: ifeq +95 -> 338
    //   246: aload 10
    //   248: bipush 58
    //   250: invokevirtual 67	java/lang/String:indexOf	(I)I
    //   253: istore_2
    //   254: iload_2
    //   255: iconst_1
    //   256: if_icmple +22 -> 278
    //   259: aload 10
    //   261: iload_2
    //   262: iconst_1
    //   263: iadd
    //   264: aload 10
    //   266: invokevirtual 71	java/lang/String:length	()I
    //   269: invokevirtual 75	java/lang/String:substring	(II)Ljava/lang/String;
    //   272: invokevirtual 79	java/lang/String:trim	()Ljava/lang/String;
    //   275: putstatic 160	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:c	Ljava/lang/String;
    //   278: lload 5
    //   280: lstore_3
    //   281: fload_1
    //   282: fstore_0
    //   283: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq -243 -> 43
    //   289: aload 9
    //   291: ldc 162
    //   293: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 9
    //   299: getstatic 160	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:c	Ljava/lang/String;
    //   302: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 9
    //   308: ldc 154
    //   310: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 9
    //   316: aload 10
    //   318: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 9
    //   324: ldc 156
    //   326: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: lload 5
    //   332: lstore_3
    //   333: fload_1
    //   334: fstore_0
    //   335: goto -292 -> 43
    //   338: aload 10
    //   340: ldc 123
    //   342: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   345: ifeq +85 -> 430
    //   348: aload 10
    //   350: invokevirtual 79	java/lang/String:trim	()Ljava/lang/String;
    //   353: putstatic 164	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:d	Ljava/lang/String;
    //   356: aload 10
    //   358: ldc 166
    //   360: invokevirtual 170	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   363: ifeq +7 -> 370
    //   366: iconst_1
    //   367: putstatic 172	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:o	Z
    //   370: lload 5
    //   372: lstore_3
    //   373: fload_1
    //   374: fstore_0
    //   375: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq -335 -> 43
    //   381: aload 9
    //   383: ldc 174
    //   385: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 9
    //   391: getstatic 172	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:o	Z
    //   394: invokevirtual 177	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 9
    //   400: ldc 154
    //   402: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 9
    //   408: aload 10
    //   410: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 9
    //   416: ldc 156
    //   418: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: lload 5
    //   424: lstore_3
    //   425: fload_1
    //   426: fstore_0
    //   427: goto -384 -> 43
    //   430: aload 10
    //   432: ldc 179
    //   434: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   437: ifeq +16 -> 453
    //   440: lload 5
    //   442: aload 10
    //   444: invokestatic 181	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:a	(JLjava/lang/String;)J
    //   447: lstore_3
    //   448: fload_1
    //   449: fstore_0
    //   450: goto -407 -> 43
    //   453: lload 5
    //   455: lstore_3
    //   456: fload_1
    //   457: fstore_0
    //   458: aload 10
    //   460: ldc 183
    //   462: invokevirtual 127	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   465: ifeq -422 -> 43
    //   468: fload_1
    //   469: aload 10
    //   471: invokestatic 185	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:a	(FLjava/lang/String;)F
    //   474: fstore_0
    //   475: lload 5
    //   477: lstore_3
    //   478: goto -435 -> 43
    //   481: aload 9
    //   483: aload 10
    //   485: invokestatic 187	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:b	(Ljava/lang/StringBuilder;Ljava/lang/String;)V
    //   488: lload 5
    //   490: lstore_3
    //   491: fload_1
    //   492: fstore_0
    //   493: goto -450 -> 43
    //   496: astore 9
    //   498: goto +8 -> 506
    //   501: astore 9
    //   503: aconst_null
    //   504: astore 8
    //   506: aload 8
    //   508: invokestatic 190	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:a	(Ljava/io/BufferedReader;)V
    //   511: aload 9
    //   513: athrow
    //   514: aconst_null
    //   515: astore 8
    //   517: aload 8
    //   519: invokestatic 190	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:a	(Ljava/io/BufferedReader;)V
    //   522: lload_3
    //   523: fload_0
    //   524: aload 9
    //   526: invokestatic 193	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:a	(JFLjava/lang/StringBuilder;)V
    //   529: return
    //   530: astore 8
    //   532: goto -18 -> 514
    //   535: astore 10
    //   537: lload 5
    //   539: lstore_3
    //   540: fload_1
    //   541: fstore_0
    //   542: goto -25 -> 517
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	530	0	f1	float
    //   44	497	1	f2	float
    //   151	113	2	i1	int
    //   9	531	3	l1	long
    //   46	492	5	l2	long
    //   137	3	7	bool	boolean
    //   41	477	8	localBufferedReader	BufferedReader
    //   530	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   23	459	9	localStringBuilder1	StringBuilder
    //   496	1	9	localObject	Object
    //   501	24	9	localStringBuilder2	StringBuilder
    //   53	431	10	str	String
    //   535	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   48	55	496	finally
    //   60	64	496	finally
    //   72	87	496	finally
    //   95	112	496	finally
    //   120	139	496	finally
    //   144	152	496	finally
    //   157	176	496	finally
    //   181	228	496	finally
    //   236	254	496	finally
    //   259	278	496	finally
    //   283	330	496	finally
    //   338	370	496	finally
    //   375	422	496	finally
    //   430	448	496	finally
    //   458	475	496	finally
    //   481	488	496	finally
    //   25	43	501	finally
    //   25	43	530	java/io/FileNotFoundException
    //   25	43	530	java/io/IOException
    //   25	43	530	java/lang/NumberFormatException
    //   48	55	535	java/io/FileNotFoundException
    //   48	55	535	java/io/IOException
    //   48	55	535	java/lang/NumberFormatException
    //   60	64	535	java/io/FileNotFoundException
    //   60	64	535	java/io/IOException
    //   60	64	535	java/lang/NumberFormatException
    //   72	87	535	java/io/FileNotFoundException
    //   72	87	535	java/io/IOException
    //   72	87	535	java/lang/NumberFormatException
    //   95	112	535	java/io/FileNotFoundException
    //   95	112	535	java/io/IOException
    //   95	112	535	java/lang/NumberFormatException
    //   120	139	535	java/io/FileNotFoundException
    //   120	139	535	java/io/IOException
    //   120	139	535	java/lang/NumberFormatException
    //   144	152	535	java/io/FileNotFoundException
    //   144	152	535	java/io/IOException
    //   144	152	535	java/lang/NumberFormatException
    //   157	176	535	java/io/FileNotFoundException
    //   157	176	535	java/io/IOException
    //   157	176	535	java/lang/NumberFormatException
    //   181	228	535	java/io/FileNotFoundException
    //   181	228	535	java/io/IOException
    //   181	228	535	java/lang/NumberFormatException
    //   236	254	535	java/io/FileNotFoundException
    //   236	254	535	java/io/IOException
    //   236	254	535	java/lang/NumberFormatException
    //   259	278	535	java/io/FileNotFoundException
    //   259	278	535	java/io/IOException
    //   259	278	535	java/lang/NumberFormatException
    //   283	330	535	java/io/FileNotFoundException
    //   283	330	535	java/io/IOException
    //   283	330	535	java/lang/NumberFormatException
    //   338	370	535	java/io/FileNotFoundException
    //   338	370	535	java/io/IOException
    //   338	370	535	java/lang/NumberFormatException
    //   375	422	535	java/io/FileNotFoundException
    //   375	422	535	java/io/IOException
    //   375	422	535	java/lang/NumberFormatException
    //   430	448	535	java/io/FileNotFoundException
    //   430	448	535	java/io/IOException
    //   430	448	535	java/lang/NumberFormatException
    //   458	475	535	java/io/FileNotFoundException
    //   458	475	535	java/io/IOException
    //   458	475	535	java/lang/NumberFormatException
    //   481	488	535	java/io/FileNotFoundException
    //   481	488	535	java/io/IOException
    //   481	488	535	java/lang/NumberFormatException
  }
  
  protected static void a(long paramLong, float paramFloat, StringBuilder paramStringBuilder)
  {
    int i1 = d();
    if (i1 > 0)
    {
      g = i1;
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("[CpuInfo] mCoreNumber=");
        paramStringBuilder.append(g);
        paramStringBuilder.append("\n");
      }
    }
    else if (paramLong > 0L)
    {
      g = (int)paramLong;
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("[CpuInfo] mCoreNumber(bogoCoreNum)=");
        paramStringBuilder.append(g);
        paramStringBuilder.append("\n");
      }
    }
    paramLong = b();
    if (paramLong > 0L)
    {
      f = paramLong;
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("[CpuInfo] mMaxCpuFreq=");
        paramStringBuilder.append(f);
        paramStringBuilder.append("\n");
      }
    }
    else if (paramFloat > 0.0F)
    {
      double d1;
      if (paramFloat < 1200.0F)
      {
        d1 = paramFloat;
        Double.isNaN(d1);
        f = (d1 * 1.2D * 1000.0D);
      }
      else if (paramFloat > 2000.0F)
      {
        d1 = paramFloat;
        Double.isNaN(d1);
        f = (d1 / 1.8D * 1000.0D);
      }
      else
      {
        f = (paramFloat * 1000.0F);
      }
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("[CpuInfo] mMaxCpuFreq(bogoMIPS)=");
        paramStringBuilder.append(f);
        paramStringBuilder.append("\n");
      }
    }
    if ((g > 0) && (f > 0L))
    {
      h = true;
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("[CpuInfo] read cpu info fail because of coreNumber= ");
        paramStringBuilder.append(g);
        paramStringBuilder.append(" or maxCpuFreq=");
        paramStringBuilder.append(f);
        paramStringBuilder.append("\n");
      }
      h = false;
    }
    l = e();
    if (QLog.isColorLevel())
    {
      paramStringBuilder.append("[CpuInfo] Chip=");
      paramStringBuilder.append(l);
      paramStringBuilder.append(", Video=");
      paramStringBuilder.append(n);
      paramStringBuilder.append(", Audio=");
      paramStringBuilder.append(m);
      paramStringBuilder.append("\n");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQAudioSystemInfo: ");
      localStringBuilder.append(paramStringBuilder.toString());
      QLog.i("QQAudioSystemInfo", 2, localStringBuilder.toString());
    }
  }
  
  protected static void a(BufferedReader paramBufferedReader)
  {
    if (paramBufferedReader != null) {
      try
      {
        paramBufferedReader.close();
        return;
      }
      catch (IOException paramBufferedReader)
      {
        paramBufferedReader.printStackTrace();
      }
    }
  }
  
  protected static void a(String paramString)
  {
    int i1 = paramString.indexOf(':');
    if (i1 > 1) {
      v = paramString.substring(i1 + 1, paramString.length()).trim().replace(" ", "");
    }
  }
  
  protected static void a(StringBuilder paramStringBuilder, String paramString)
  {
    int i1 = paramString.indexOf(':');
    if (i1 > 1)
    {
      a = paramString.substring(i1 + 1, paramString.length());
      a = a.trim();
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("[CpuInfo] mProcessorName=");
        paramStringBuilder.append(a);
        paramStringBuilder.append(" | ");
        paramStringBuilder.append(paramString);
        paramStringBuilder.append("\n");
      }
    }
  }
  
  /* Error */
  static long b()
  {
    // Byte code:
    //   0: getstatic 197	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:g	I
    //   3: iconst_1
    //   4: if_icmpge +24 -> 28
    //   7: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +13 -> 23
    //   13: ldc_w 257
    //   16: iconst_2
    //   17: ldc_w 282
    //   20: invokestatic 260	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: bipush 8
    //   25: putstatic 197	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:g	I
    //   28: iconst_0
    //   29: istore_0
    //   30: lconst_0
    //   31: lstore_2
    //   32: lload_2
    //   33: lstore 4
    //   35: iconst_0
    //   36: istore_1
    //   37: iload_0
    //   38: getstatic 197	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:g	I
    //   41: if_icmpge +422 -> 463
    //   44: aconst_null
    //   45: astore 11
    //   47: aconst_null
    //   48: astore 9
    //   50: ldc 8
    //   52: astore 10
    //   54: aload 9
    //   56: astore 8
    //   58: new 103	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   65: astore 12
    //   67: aload 9
    //   69: astore 8
    //   71: aload 12
    //   73: ldc_w 284
    //   76: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 9
    //   82: astore 8
    //   84: aload 12
    //   86: iload_0
    //   87: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 9
    //   93: astore 8
    //   95: aload 12
    //   97: ldc_w 286
    //   100: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 9
    //   106: astore 8
    //   108: new 108	java/io/BufferedReader
    //   111: dup
    //   112: new 110	java/io/FileReader
    //   115: dup
    //   116: aload 12
    //   118: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokespecial 115	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   124: invokespecial 118	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   127: astore 9
    //   129: aload 9
    //   131: invokevirtual 121	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   134: astore 11
    //   136: aload 10
    //   138: astore 8
    //   140: aload 11
    //   142: invokestatic 291	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifne +10 -> 155
    //   148: aload 11
    //   150: invokevirtual 79	java/lang/String:trim	()Ljava/lang/String;
    //   153: astore 8
    //   155: lload_2
    //   156: lstore 6
    //   158: aload 8
    //   160: ifnull +21 -> 181
    //   163: lload_2
    //   164: lstore 6
    //   166: aload 8
    //   168: invokevirtual 71	java/lang/String:length	()I
    //   171: ifle +10 -> 181
    //   174: aload 8
    //   176: invokestatic 92	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   179: lstore 6
    //   181: aload 9
    //   183: invokevirtual 263	java/io/BufferedReader:close	()V
    //   186: lload 6
    //   188: lstore_2
    //   189: goto +150 -> 339
    //   192: astore 8
    //   194: aload 8
    //   196: invokevirtual 266	java/io/IOException:printStackTrace	()V
    //   199: lload 6
    //   201: lstore_2
    //   202: goto +137 -> 339
    //   205: astore 10
    //   207: aload 9
    //   209: astore 8
    //   211: aload 10
    //   213: astore 9
    //   215: goto +225 -> 440
    //   218: astore 10
    //   220: goto +14 -> 234
    //   223: astore 9
    //   225: goto +215 -> 440
    //   228: astore 10
    //   230: aload 11
    //   232: astore 9
    //   234: aload 9
    //   236: astore 8
    //   238: new 103	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   245: astore 11
    //   247: aload 9
    //   249: astore 8
    //   251: aload 11
    //   253: ldc_w 293
    //   256: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 9
    //   262: astore 8
    //   264: aload 11
    //   266: iload_0
    //   267: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 9
    //   273: astore 8
    //   275: aload 11
    //   277: ldc_w 295
    //   280: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload 9
    //   286: astore 8
    //   288: aload 11
    //   290: aload 10
    //   292: invokevirtual 296	java/lang/Exception:toString	()Ljava/lang/String;
    //   295: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 9
    //   301: astore 8
    //   303: ldc_w 257
    //   306: iconst_2
    //   307: aload 11
    //   309: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 298	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload 9
    //   317: ifnull +18 -> 335
    //   320: aload 9
    //   322: invokevirtual 263	java/io/BufferedReader:close	()V
    //   325: goto +10 -> 335
    //   328: astore 8
    //   330: aload 8
    //   332: invokevirtual 266	java/io/IOException:printStackTrace	()V
    //   335: lconst_0
    //   336: lstore_2
    //   337: iconst_1
    //   338: istore_1
    //   339: lload 4
    //   341: lstore 6
    //   343: lload_2
    //   344: lload 4
    //   346: lcmp
    //   347: ifle +6 -> 353
    //   350: lload_2
    //   351: lstore 6
    //   353: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +73 -> 429
    //   359: new 103	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   366: astore 8
    //   368: aload 8
    //   370: ldc_w 300
    //   373: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload 8
    //   379: iload_0
    //   380: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 8
    //   386: ldc_w 302
    //   389: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload 8
    //   395: lload_2
    //   396: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 8
    //   402: ldc_w 304
    //   405: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 8
    //   411: lload 6
    //   413: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: ldc_w 257
    //   420: iconst_2
    //   421: aload 8
    //   423: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 260	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: iload_0
    //   430: iconst_1
    //   431: iadd
    //   432: istore_0
    //   433: lload 6
    //   435: lstore 4
    //   437: goto -400 -> 37
    //   440: aload 8
    //   442: ifnull +18 -> 460
    //   445: aload 8
    //   447: invokevirtual 263	java/io/BufferedReader:close	()V
    //   450: goto +10 -> 460
    //   453: astore 8
    //   455: aload 8
    //   457: invokevirtual 266	java/io/IOException:printStackTrace	()V
    //   460: aload 9
    //   462: athrow
    //   463: iload_1
    //   464: ifeq +22 -> 486
    //   467: invokestatic 306	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:c	()J
    //   470: lstore 6
    //   472: lload 6
    //   474: lload_2
    //   475: lcmp
    //   476: ifle +10 -> 486
    //   479: lload 6
    //   481: lstore 4
    //   483: goto +3 -> 486
    //   486: new 103	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   493: astore 8
    //   495: aload 8
    //   497: ldc_w 308
    //   500: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 8
    //   506: lload 4
    //   508: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: ldc_w 257
    //   515: iconst_2
    //   516: aload 8
    //   518: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   521: invokestatic 260	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   524: lload 4
    //   526: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	404	0	i1	int
    //   36	428	1	i2	int
    //   31	444	2	l1	long
    //   33	492	4	l2	long
    //   156	324	6	l3	long
    //   56	119	8	localObject1	Object
    //   192	3	8	localIOException1	IOException
    //   209	93	8	localObject2	Object
    //   328	3	8	localIOException2	IOException
    //   366	80	8	localStringBuilder1	StringBuilder
    //   453	3	8	localIOException3	IOException
    //   493	24	8	localStringBuilder2	StringBuilder
    //   48	166	9	localObject3	Object
    //   223	1	9	localObject4	Object
    //   232	229	9	localObject5	Object
    //   52	85	10	str	String
    //   205	7	10	localObject6	Object
    //   218	1	10	localException1	Exception
    //   228	63	10	localException2	Exception
    //   45	263	11	localObject7	Object
    //   65	52	12	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   181	186	192	java/io/IOException
    //   129	136	205	finally
    //   140	155	205	finally
    //   166	181	205	finally
    //   129	136	218	java/lang/Exception
    //   140	155	218	java/lang/Exception
    //   166	181	218	java/lang/Exception
    //   58	67	223	finally
    //   71	80	223	finally
    //   84	91	223	finally
    //   95	104	223	finally
    //   108	129	223	finally
    //   238	247	223	finally
    //   251	260	223	finally
    //   264	271	223	finally
    //   275	284	223	finally
    //   288	299	223	finally
    //   303	315	223	finally
    //   58	67	228	java/lang/Exception
    //   71	80	228	java/lang/Exception
    //   84	91	228	java/lang/Exception
    //   95	104	228	java/lang/Exception
    //   108	129	228	java/lang/Exception
    //   320	325	328	java/io/IOException
    //   445	450	453	java/io/IOException
  }
  
  protected static void b(StringBuilder paramStringBuilder, String paramString)
  {
    int i2 = paramString.indexOf(':');
    int i1 = 1;
    if (i2 > 1)
    {
      String str = paramString.substring(i2 + 1, paramString.length()).trim();
      if ((str != null) && (str.length() > 0)) {
        if (str.equalsIgnoreCase("aarch64")) {
          e = 8;
        } else {
          for (;;)
          {
            try
            {
              e = (int)Long.parseLong(str);
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              continue;
            }
            if (i1 >= str.length()) {
              continue;
            }
            try
            {
              e = (int)Long.parseLong(str.substring(0, str.length() - i1));
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              continue;
            }
            i1 += 1;
          }
        }
      }
    }
    if (paramString.contains("5TE")) {
      e = 5;
    }
    if (QLog.isColorLevel())
    {
      paramStringBuilder.append("[CpuInfo] mCpuArchitecture=");
      paramStringBuilder.append(e);
      paramStringBuilder.append(" | ");
      paramStringBuilder.append(paramString);
      paramStringBuilder.append("\n");
    }
  }
  
  /* Error */
  static long c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: lconst_0
    //   4: lstore_3
    //   5: new 108	java/io/BufferedReader
    //   8: dup
    //   9: new 110	java/io/FileReader
    //   12: dup
    //   13: ldc_w 321
    //   16: invokespecial 115	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   19: invokespecial 118	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   22: astore 8
    //   24: aload 7
    //   26: astore 9
    //   28: aload 8
    //   30: astore 7
    //   32: aload 8
    //   34: invokevirtual 121	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   37: astore 10
    //   39: aload 10
    //   41: ifnull +267 -> 308
    //   44: aload 10
    //   46: astore 7
    //   48: goto -24 -> 24
    //   51: aload 8
    //   53: astore 7
    //   55: aload 9
    //   57: bipush 9
    //   59: invokevirtual 67	java/lang/String:indexOf	(I)I
    //   62: istore_0
    //   63: lload_3
    //   64: lstore_1
    //   65: iload_0
    //   66: iconst_m1
    //   67: if_icmpeq +47 -> 114
    //   70: aload 8
    //   72: astore 7
    //   74: aload 9
    //   76: iconst_0
    //   77: iload_0
    //   78: invokevirtual 75	java/lang/String:substring	(II)Ljava/lang/String;
    //   81: astore 9
    //   83: lload_3
    //   84: lstore_1
    //   85: aload 9
    //   87: ifnull +27 -> 114
    //   90: lload_3
    //   91: lstore_1
    //   92: aload 8
    //   94: astore 7
    //   96: aload 9
    //   98: invokevirtual 71	java/lang/String:length	()I
    //   101: ifle +13 -> 114
    //   104: aload 8
    //   106: astore 7
    //   108: aload 9
    //   110: invokestatic 92	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   113: lstore_1
    //   114: lload_1
    //   115: lstore 5
    //   117: aload 8
    //   119: invokevirtual 263	java/io/BufferedReader:close	()V
    //   122: goto +108 -> 230
    //   125: astore 7
    //   127: aload 7
    //   129: invokevirtual 266	java/io/IOException:printStackTrace	()V
    //   132: lload 5
    //   134: lstore_1
    //   135: goto +95 -> 230
    //   138: astore 9
    //   140: goto +16 -> 156
    //   143: astore 7
    //   145: aconst_null
    //   146: astore 8
    //   148: goto +131 -> 279
    //   151: astore 9
    //   153: aconst_null
    //   154: astore 8
    //   156: aload 8
    //   158: astore 7
    //   160: new 103	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   167: astore 10
    //   169: aload 8
    //   171: astore 7
    //   173: aload 10
    //   175: ldc_w 323
    //   178: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 8
    //   184: astore 7
    //   186: aload 10
    //   188: aload 9
    //   190: invokevirtual 296	java/lang/Exception:toString	()Ljava/lang/String;
    //   193: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 8
    //   199: astore 7
    //   201: ldc_w 257
    //   204: iconst_2
    //   205: aload 10
    //   207: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 298	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: lload_3
    //   214: lstore_1
    //   215: aload 8
    //   217: ifnull +13 -> 230
    //   220: lload_3
    //   221: lstore 5
    //   223: aload 8
    //   225: invokevirtual 263	java/io/BufferedReader:close	()V
    //   228: lload_3
    //   229: lstore_1
    //   230: new 103	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   237: astore 7
    //   239: aload 7
    //   241: ldc_w 325
    //   244: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 7
    //   250: lload_1
    //   251: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: ldc_w 257
    //   258: iconst_2
    //   259: aload 7
    //   261: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 260	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: lload_1
    //   268: lreturn
    //   269: astore 9
    //   271: aload 7
    //   273: astore 8
    //   275: aload 9
    //   277: astore 7
    //   279: aload 8
    //   281: ifnull +18 -> 299
    //   284: aload 8
    //   286: invokevirtual 263	java/io/BufferedReader:close	()V
    //   289: goto +10 -> 299
    //   292: astore 8
    //   294: aload 8
    //   296: invokevirtual 266	java/io/IOException:printStackTrace	()V
    //   299: goto +6 -> 305
    //   302: aload 7
    //   304: athrow
    //   305: goto -3 -> 302
    //   308: aload 9
    //   310: ifnonnull -259 -> 51
    //   313: iconst_m1
    //   314: istore_0
    //   315: goto -252 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   62	253	0	i1	int
    //   64	204	1	l1	long
    //   4	225	3	l2	long
    //   115	107	5	l3	long
    //   1	106	7	localObject1	Object
    //   125	3	7	localIOException1	IOException
    //   143	1	7	localObject2	Object
    //   158	145	7	localObject3	Object
    //   22	263	8	localObject4	Object
    //   292	3	8	localIOException2	IOException
    //   26	83	9	localObject5	Object
    //   138	1	9	localException1	Exception
    //   151	38	9	localException2	Exception
    //   269	40	9	localObject6	Object
    //   37	169	10	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   117	122	125	java/io/IOException
    //   223	228	125	java/io/IOException
    //   32	39	138	java/lang/Exception
    //   55	63	138	java/lang/Exception
    //   74	83	138	java/lang/Exception
    //   96	104	138	java/lang/Exception
    //   108	114	138	java/lang/Exception
    //   5	24	143	finally
    //   5	24	151	java/lang/Exception
    //   32	39	269	finally
    //   55	63	269	finally
    //   74	83	269	finally
    //   96	104	269	finally
    //   108	114	269	finally
    //   160	169	269	finally
    //   173	182	269	finally
    //   186	197	269	finally
    //   201	213	269	finally
    //   284	289	292	java/io/IOException
  }
  
  static int d()
  {
    try
    {
      int i1 = new File("/sys/devices/system/cpu/").listFiles(new QQAudioSystemInfo.1CpuFilter()).length;
      return i1;
    }
    catch (Exception localException)
    {
      label24:
      break label24;
    }
    return 0;
  }
  
  static int e()
  {
    if (a.contains("ARMv6")) {
      return 2;
    }
    if (Build.CPU_ABI.equalsIgnoreCase("armeabi-v7a")) {
      return 4;
    }
    if (Build.CPU_ABI.equalsIgnoreCase("armeabi")) {
      return 2;
    }
    int i1 = e;
    int i2 = 7;
    if ((i1 == 7) && (b.indexOf("neon") < 0))
    {
      long l1 = f();
      i1 = g();
      if ((l1 < 1100000L) || (i1 < 2)) {
        return 3;
      }
    }
    if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
      return 7;
    }
    i1 = e;
    if (i1 != 5)
    {
      if (i1 != 6)
      {
        if (i1 != 7)
        {
          if (i1 != 8)
          {
            String str = c;
            if (str != null)
            {
              i1 = i2;
              if (!str.equalsIgnoreCase("AuthenticAMD"))
              {
                i1 = i2;
                if (c.equalsIgnoreCase("GenuineIntel")) {}
              }
            }
            else
            {
              i1 = 0;
            }
            return i1;
          }
          return 5;
        }
        return 4;
      }
      return 2;
    }
    return 1;
  }
  
  public static long f()
  {
    
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMaxCpuFreq: ");
      localStringBuilder.append(Build.BRAND);
      localStringBuilder.append("|");
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append("|");
      localStringBuilder.append(f);
      QLog.i("QQAudioSystemInfo", 2, localStringBuilder.toString());
    }
    return f;
  }
  
  public static int g()
  {
    a();
    return g;
  }
  
  public static int h()
  {
    a();
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.QQAudioSystemInfo
 * JD-Core Version:    0.7.0.1
 */