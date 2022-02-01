package com.tencent.mobileqq.statistics.cpu;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class CPUReport
{
  public static int a = 1;
  public static int b = 2;
  public static int c = 4;
  public static int d = 8;
  public static int e = 16;
  int f = 0;
  String g;
  String h;
  int i;
  int j;
  int k;
  boolean l;
  String m = "";
  int n;
  String o = "";
  String p = "";
  String q = "";
  int r;
  long s;
  boolean t;
  
  private static int a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i1 = 0;
    if (bool) {
      return 0;
    }
    if ("arm64-v8a".equalsIgnoreCase(paramString)) {
      return c;
    }
    if ("armeabi-v7a".equalsIgnoreCase(paramString)) {
      return b;
    }
    if ((!"armeabi".equalsIgnoreCase(paramString)) && (paramString.indexOf("arm") < 0))
    {
      if ((!"x86".equalsIgnoreCase(paramString)) && (paramString.indexOf("x86") < 0))
      {
        if (("mips".equalsIgnoreCase(paramString)) || (paramString.indexOf("mips") >= 0)) {
          return e;
        }
      }
      else {
        return d;
      }
    }
    else {
      i1 = a;
    }
    return i1;
  }
  
  public static boolean c()
  {
    int i4 = a(Build.CPU_ABI);
    if (Build.VERSION.SDK_INT >= 21)
    {
      String[] arrayOfString = Build.SUPPORTED_ABIS;
      if (arrayOfString != null)
      {
        int i5 = arrayOfString.length;
        int i3 = 0;
        i1 = 0;
        for (;;)
        {
          i2 = i1;
          if (i3 >= i5) {
            break;
          }
          i1 |= a(arrayOfString[i3]);
          i3 += 1;
        }
      }
    }
    int i2 = 0;
    int i1 = d;
    if (i4 != i1)
    {
      if ((i2 & i1) == i1) {
        return false;
      }
      i1 = e;
      if (i4 != i1)
      {
        if ((i2 & i1) == i1) {
          return false;
        }
        i1 = c;
        if (i4 != i1)
        {
          if ((i2 & i1) == i1) {
            return true;
          }
          i1 = b;
          if (i4 != i1)
          {
            if ((i2 & i1) == i1) {
              return true;
            }
            i1 = a;
            if (i4 != i1) {
              return (i2 & i1) == i1;
            }
          }
        }
        return true;
      }
    }
    return false;
  }
  
  static int d()
  {
    try
    {
      int i1 = new File("/sys/devices/system/cpu/").listFiles(new CPUReport.1CpuFilter()).length;
      return i1;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    return 0;
  }
  
  /* Error */
  static long e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: lconst_0
    //   4: lstore_3
    //   5: new 128	java/io/BufferedReader
    //   8: dup
    //   9: new 130	java/io/FileReader
    //   12: dup
    //   13: ldc 132
    //   15: invokespecial 133	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 136	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore 7
    //   23: aload 7
    //   25: astore 5
    //   27: aload 7
    //   29: invokevirtual 140	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore 8
    //   34: aload 8
    //   36: astore 5
    //   38: aload 6
    //   40: astore 8
    //   42: aload 5
    //   44: astore 6
    //   46: aload 6
    //   48: ifnull +230 -> 278
    //   51: aload 7
    //   53: astore 5
    //   55: aload 7
    //   57: invokevirtual 140	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore 8
    //   62: aload 8
    //   64: astore 5
    //   66: goto -28 -> 38
    //   69: aload 7
    //   71: astore 5
    //   73: aload 8
    //   75: bipush 9
    //   77: invokevirtual 143	java/lang/String:indexOf	(I)I
    //   80: istore_0
    //   81: lload_3
    //   82: lstore_1
    //   83: iload_0
    //   84: iconst_m1
    //   85: if_icmpeq +47 -> 132
    //   88: aload 7
    //   90: astore 5
    //   92: aload 8
    //   94: iconst_0
    //   95: iload_0
    //   96: invokevirtual 147	java/lang/String:substring	(II)Ljava/lang/String;
    //   99: astore 6
    //   101: lload_3
    //   102: lstore_1
    //   103: aload 6
    //   105: ifnull +27 -> 132
    //   108: lload_3
    //   109: lstore_1
    //   110: aload 7
    //   112: astore 5
    //   114: aload 6
    //   116: invokevirtual 150	java/lang/String:length	()I
    //   119: ifle +13 -> 132
    //   122: aload 7
    //   124: astore 5
    //   126: aload 6
    //   128: invokestatic 156	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   131: lstore_1
    //   132: lload_1
    //   133: lstore_3
    //   134: aload 7
    //   136: invokevirtual 159	java/io/BufferedReader:close	()V
    //   139: lload_1
    //   140: lreturn
    //   141: astore 5
    //   143: aload 5
    //   145: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   148: lload_3
    //   149: lreturn
    //   150: astore 8
    //   152: aload 7
    //   154: astore 6
    //   156: goto +16 -> 172
    //   159: astore 5
    //   161: aconst_null
    //   162: astore 6
    //   164: goto +85 -> 249
    //   167: astore 8
    //   169: aconst_null
    //   170: astore 6
    //   172: aload 6
    //   174: astore 5
    //   176: new 164	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   183: astore 7
    //   185: aload 6
    //   187: astore 5
    //   189: aload 7
    //   191: ldc 167
    //   193: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 6
    //   199: astore 5
    //   201: aload 7
    //   203: aload 8
    //   205: invokevirtual 174	java/lang/Exception:toString	()Ljava/lang/String;
    //   208: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 6
    //   214: astore 5
    //   216: ldc 176
    //   218: iconst_1
    //   219: aload 7
    //   221: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 182	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: aload 6
    //   229: ifnull +8 -> 237
    //   232: aload 6
    //   234: invokevirtual 159	java/io/BufferedReader:close	()V
    //   237: lconst_0
    //   238: lreturn
    //   239: astore 7
    //   241: aload 5
    //   243: astore 6
    //   245: aload 7
    //   247: astore 5
    //   249: aload 6
    //   251: ifnull +18 -> 269
    //   254: aload 6
    //   256: invokevirtual 159	java/io/BufferedReader:close	()V
    //   259: goto +10 -> 269
    //   262: astore 6
    //   264: aload 6
    //   266: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   269: goto +6 -> 275
    //   272: aload 5
    //   274: athrow
    //   275: goto -3 -> 272
    //   278: aload 8
    //   280: ifnonnull -211 -> 69
    //   283: iconst_m1
    //   284: istore_0
    //   285: goto -204 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   80	205	0	i1	int
    //   82	58	1	l1	long
    //   4	145	3	l2	long
    //   25	100	5	localObject1	Object
    //   141	3	5	localIOException1	java.io.IOException
    //   159	1	5	localObject2	Object
    //   174	99	5	localObject3	Object
    //   1	254	6	localObject4	Object
    //   262	3	6	localIOException2	java.io.IOException
    //   21	199	7	localObject5	Object
    //   239	7	7	localObject6	Object
    //   32	61	8	localObject7	Object
    //   150	1	8	localException1	Exception
    //   167	112	8	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   134	139	141	java/io/IOException
    //   232	237	141	java/io/IOException
    //   27	34	150	java/lang/Exception
    //   55	62	150	java/lang/Exception
    //   73	81	150	java/lang/Exception
    //   92	101	150	java/lang/Exception
    //   114	122	150	java/lang/Exception
    //   126	132	150	java/lang/Exception
    //   5	23	159	finally
    //   5	23	167	java/lang/Exception
    //   27	34	239	finally
    //   55	62	239	finally
    //   73	81	239	finally
    //   92	101	239	finally
    //   114	122	239	finally
    //   126	132	239	finally
    //   176	185	239	finally
    //   189	197	239	finally
    //   201	212	239	finally
    //   216	227	239	finally
    //   254	259	262	java/io/IOException
  }
  
  /* Error */
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 188	com/tencent/mobileqq/statistics/cpu/CPUReport:t	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: new 164	java/lang/StringBuilder
    //   11: dup
    //   12: sipush 1024
    //   15: invokespecial 191	java/lang/StringBuilder:<init>	(I)V
    //   18: pop
    //   19: ldc2_w 192
    //   22: lstore 8
    //   24: ldc 194
    //   26: fstore_3
    //   27: new 128	java/io/BufferedReader
    //   30: dup
    //   31: new 130	java/io/FileReader
    //   34: dup
    //   35: ldc 196
    //   37: invokespecial 133	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   40: invokespecial 136	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore 14
    //   45: aload 14
    //   47: invokevirtual 140	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore 15
    //   52: iconst_1
    //   53: istore 6
    //   55: aload 15
    //   57: ifnonnull +40 -> 97
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 188	com/tencent/mobileqq/statistics/cpu/CPUReport:t	Z
    //   65: lload 8
    //   67: lstore 10
    //   69: fload_3
    //   70: fstore 4
    //   72: aload 14
    //   74: invokevirtual 159	java/io/BufferedReader:close	()V
    //   77: goto +746 -> 823
    //   80: astore 14
    //   82: aload 14
    //   84: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   87: lload 10
    //   89: lstore 8
    //   91: fload 4
    //   93: fstore_3
    //   94: goto +729 -> 823
    //   97: aload 15
    //   99: ldc 198
    //   101: invokevirtual 201	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   104: ifeq +64 -> 168
    //   107: aload 15
    //   109: bipush 58
    //   111: invokevirtual 143	java/lang/String:indexOf	(I)I
    //   114: istore 6
    //   116: iload 6
    //   118: iconst_1
    //   119: if_icmple -74 -> 45
    //   122: aload_0
    //   123: aload 15
    //   125: iload 6
    //   127: iconst_1
    //   128: iadd
    //   129: aload 15
    //   131: invokevirtual 150	java/lang/String:length	()I
    //   134: invokevirtual 147	java/lang/String:substring	(II)Ljava/lang/String;
    //   137: putfield 45	com/tencent/mobileqq/statistics/cpu/CPUReport:m	Ljava/lang/String;
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 45	com/tencent/mobileqq/statistics/cpu/CPUReport:m	Ljava/lang/String;
    //   145: invokevirtual 204	java/lang/String:trim	()Ljava/lang/String;
    //   148: putfield 45	com/tencent/mobileqq/statistics/cpu/CPUReport:m	Ljava/lang/String;
    //   151: aload_0
    //   152: aload_0
    //   153: getfield 45	com/tencent/mobileqq/statistics/cpu/CPUReport:m	Ljava/lang/String;
    //   156: getstatic 210	java/util/Locale:US	Ljava/util/Locale;
    //   159: invokevirtual 214	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   162: putfield 45	com/tencent/mobileqq/statistics/cpu/CPUReport:m	Ljava/lang/String;
    //   165: goto -120 -> 45
    //   168: aload 15
    //   170: ldc 216
    //   172: invokevirtual 201	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   175: ifeq +148 -> 323
    //   178: aload 15
    //   180: bipush 58
    //   182: invokevirtual 143	java/lang/String:indexOf	(I)I
    //   185: istore 7
    //   187: iload 7
    //   189: iconst_1
    //   190: if_icmple +115 -> 305
    //   193: aload 15
    //   195: iload 7
    //   197: iconst_1
    //   198: iadd
    //   199: aload 15
    //   201: invokevirtual 150	java/lang/String:length	()I
    //   204: invokevirtual 147	java/lang/String:substring	(II)Ljava/lang/String;
    //   207: invokevirtual 204	java/lang/String:trim	()Ljava/lang/String;
    //   210: astore 16
    //   212: aload 16
    //   214: ifnull +91 -> 305
    //   217: aload 16
    //   219: invokevirtual 150	java/lang/String:length	()I
    //   222: ifle +83 -> 305
    //   225: aload 16
    //   227: ldc 218
    //   229: invokevirtual 66	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   232: ifeq +12 -> 244
    //   235: aload_0
    //   236: bipush 8
    //   238: putfield 220	com/tencent/mobileqq/statistics/cpu/CPUReport:n	I
    //   241: goto +64 -> 305
    //   244: aload_0
    //   245: aload 16
    //   247: invokestatic 156	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   250: l2i
    //   251: putfield 220	com/tencent/mobileqq/statistics/cpu/CPUReport:n	I
    //   254: goto +51 -> 305
    //   257: aload 16
    //   259: invokevirtual 150	java/lang/String:length	()I
    //   262: istore 7
    //   264: iload 6
    //   266: iload 7
    //   268: if_icmpge +37 -> 305
    //   271: aload_0
    //   272: aload 16
    //   274: iconst_0
    //   275: aload 16
    //   277: invokevirtual 150	java/lang/String:length	()I
    //   280: iload 6
    //   282: isub
    //   283: invokevirtual 147	java/lang/String:substring	(II)Ljava/lang/String;
    //   286: invokestatic 156	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   289: l2i
    //   290: putfield 220	com/tencent/mobileqq/statistics/cpu/CPUReport:n	I
    //   293: goto +12 -> 305
    //   296: iload 6
    //   298: iconst_1
    //   299: iadd
    //   300: istore 6
    //   302: goto -45 -> 257
    //   305: aload 15
    //   307: ldc 222
    //   309: invokevirtual 225	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   312: ifeq -267 -> 45
    //   315: aload_0
    //   316: iconst_5
    //   317: putfield 220	com/tencent/mobileqq/statistics/cpu/CPUReport:n	I
    //   320: goto -275 -> 45
    //   323: aload 15
    //   325: ldc 227
    //   327: invokevirtual 201	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   330: ifeq +56 -> 386
    //   333: aload 15
    //   335: bipush 58
    //   337: invokevirtual 143	java/lang/String:indexOf	(I)I
    //   340: istore 6
    //   342: iload 6
    //   344: iconst_1
    //   345: if_icmple -300 -> 45
    //   348: aload_0
    //   349: aload 15
    //   351: iload 6
    //   353: iconst_1
    //   354: iadd
    //   355: aload 15
    //   357: invokevirtual 150	java/lang/String:length	()I
    //   360: invokevirtual 147	java/lang/String:substring	(II)Ljava/lang/String;
    //   363: invokevirtual 204	java/lang/String:trim	()Ljava/lang/String;
    //   366: putfield 47	com/tencent/mobileqq/statistics/cpu/CPUReport:o	Ljava/lang/String;
    //   369: aload_0
    //   370: aload_0
    //   371: getfield 47	com/tencent/mobileqq/statistics/cpu/CPUReport:o	Ljava/lang/String;
    //   374: getstatic 210	java/util/Locale:US	Ljava/util/Locale;
    //   377: invokevirtual 214	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   380: putfield 47	com/tencent/mobileqq/statistics/cpu/CPUReport:o	Ljava/lang/String;
    //   383: goto -338 -> 45
    //   386: aload 15
    //   388: ldc 229
    //   390: invokevirtual 201	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   393: ifeq +42 -> 435
    //   396: aload 15
    //   398: bipush 58
    //   400: invokevirtual 143	java/lang/String:indexOf	(I)I
    //   403: istore 6
    //   405: iload 6
    //   407: iconst_1
    //   408: if_icmple -363 -> 45
    //   411: aload_0
    //   412: aload 15
    //   414: iload 6
    //   416: iconst_1
    //   417: iadd
    //   418: aload 15
    //   420: invokevirtual 150	java/lang/String:length	()I
    //   423: invokevirtual 147	java/lang/String:substring	(II)Ljava/lang/String;
    //   426: invokevirtual 204	java/lang/String:trim	()Ljava/lang/String;
    //   429: putfield 49	com/tencent/mobileqq/statistics/cpu/CPUReport:p	Ljava/lang/String;
    //   432: goto -387 -> 45
    //   435: aload 15
    //   437: ldc 231
    //   439: invokevirtual 201	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   442: ifeq +15 -> 457
    //   445: aload_0
    //   446: aload 15
    //   448: invokevirtual 204	java/lang/String:trim	()Ljava/lang/String;
    //   451: putfield 51	com/tencent/mobileqq/statistics/cpu/CPUReport:q	Ljava/lang/String;
    //   454: goto -409 -> 45
    //   457: aload 15
    //   459: ldc 233
    //   461: invokevirtual 201	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   464: ifeq +72 -> 536
    //   467: aload 15
    //   469: bipush 58
    //   471: invokevirtual 143	java/lang/String:indexOf	(I)I
    //   474: istore 6
    //   476: iload 6
    //   478: iconst_1
    //   479: if_icmple -434 -> 45
    //   482: aload 15
    //   484: iload 6
    //   486: iconst_1
    //   487: iadd
    //   488: aload 15
    //   490: invokevirtual 150	java/lang/String:length	()I
    //   493: invokevirtual 147	java/lang/String:substring	(II)Ljava/lang/String;
    //   496: invokevirtual 204	java/lang/String:trim	()Ljava/lang/String;
    //   499: astore 15
    //   501: aload 15
    //   503: invokestatic 156	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   506: lstore 10
    //   508: lload 10
    //   510: lconst_0
    //   511: lcmp
    //   512: iflt -467 -> 45
    //   515: lload 10
    //   517: lconst_1
    //   518: ladd
    //   519: lstore 10
    //   521: lload 10
    //   523: lload 8
    //   525: lcmp
    //   526: ifle -481 -> 45
    //   529: lload 10
    //   531: lstore 8
    //   533: goto -488 -> 45
    //   536: aload 15
    //   538: ldc 235
    //   540: invokevirtual 201	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   543: ifeq -498 -> 45
    //   546: aload 15
    //   548: bipush 58
    //   550: invokevirtual 143	java/lang/String:indexOf	(I)I
    //   553: istore 6
    //   555: iload 6
    //   557: iconst_1
    //   558: if_icmple -513 -> 45
    //   561: aload 15
    //   563: iload 6
    //   565: iconst_1
    //   566: iadd
    //   567: aload 15
    //   569: invokevirtual 150	java/lang/String:length	()I
    //   572: invokevirtual 147	java/lang/String:substring	(II)Ljava/lang/String;
    //   575: invokevirtual 204	java/lang/String:trim	()Ljava/lang/String;
    //   578: astore 15
    //   580: aload 15
    //   582: invokestatic 241	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   585: fstore 4
    //   587: fload 4
    //   589: fload_3
    //   590: fcmpl
    //   591: ifle +9 -> 600
    //   594: fload 4
    //   596: fstore_3
    //   597: goto +3 -> 600
    //   600: goto -555 -> 45
    //   603: astore 15
    //   605: goto +48 -> 653
    //   608: lload 8
    //   610: lstore 12
    //   612: fload_3
    //   613: fstore 5
    //   615: goto +71 -> 686
    //   618: lload 8
    //   620: lstore 12
    //   622: fload_3
    //   623: fstore 5
    //   625: goto +96 -> 721
    //   628: lload 8
    //   630: lstore 12
    //   632: fload_3
    //   633: fstore 5
    //   635: goto +121 -> 756
    //   638: lload 8
    //   640: lstore 12
    //   642: fload_3
    //   643: fstore 5
    //   645: goto +146 -> 791
    //   648: astore 15
    //   650: aconst_null
    //   651: astore 14
    //   653: aload 14
    //   655: ifnull +18 -> 673
    //   658: aload 14
    //   660: invokevirtual 159	java/io/BufferedReader:close	()V
    //   663: goto +10 -> 673
    //   666: astore 14
    //   668: aload 14
    //   670: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   673: aload 15
    //   675: athrow
    //   676: aconst_null
    //   677: astore 14
    //   679: fload_3
    //   680: fstore 5
    //   682: lload 8
    //   684: lstore 12
    //   686: lload 12
    //   688: lstore 8
    //   690: fload 5
    //   692: fstore_3
    //   693: aload 14
    //   695: ifnull +128 -> 823
    //   698: lload 12
    //   700: lstore 10
    //   702: fload 5
    //   704: fstore 4
    //   706: aload 14
    //   708: invokevirtual 159	java/io/BufferedReader:close	()V
    //   711: lload 12
    //   713: lstore 8
    //   715: fload 5
    //   717: fstore_3
    //   718: goto +105 -> 823
    //   721: lload 12
    //   723: lstore 8
    //   725: fload 5
    //   727: fstore_3
    //   728: aload 14
    //   730: ifnull +93 -> 823
    //   733: lload 12
    //   735: lstore 10
    //   737: fload 5
    //   739: fstore 4
    //   741: aload 14
    //   743: invokevirtual 159	java/io/BufferedReader:close	()V
    //   746: lload 12
    //   748: lstore 8
    //   750: fload 5
    //   752: fstore_3
    //   753: goto +70 -> 823
    //   756: lload 12
    //   758: lstore 8
    //   760: fload 5
    //   762: fstore_3
    //   763: aload 14
    //   765: ifnull +58 -> 823
    //   768: lload 12
    //   770: lstore 10
    //   772: fload 5
    //   774: fstore 4
    //   776: aload 14
    //   778: invokevirtual 159	java/io/BufferedReader:close	()V
    //   781: lload 12
    //   783: lstore 8
    //   785: fload 5
    //   787: fstore_3
    //   788: goto +35 -> 823
    //   791: lload 12
    //   793: lstore 8
    //   795: fload 5
    //   797: fstore_3
    //   798: aload 14
    //   800: ifnull +23 -> 823
    //   803: lload 12
    //   805: lstore 10
    //   807: fload 5
    //   809: fstore 4
    //   811: aload 14
    //   813: invokevirtual 159	java/io/BufferedReader:close	()V
    //   816: fload 5
    //   818: fstore_3
    //   819: lload 12
    //   821: lstore 8
    //   823: aload_0
    //   824: getfield 188	com/tencent/mobileqq/statistics/cpu/CPUReport:t	Z
    //   827: ifeq +149 -> 976
    //   830: invokestatic 243	com/tencent/mobileqq/statistics/cpu/CPUReport:d	()I
    //   833: istore 6
    //   835: iload 6
    //   837: ifle +12 -> 849
    //   840: aload_0
    //   841: iload 6
    //   843: putfield 245	com/tencent/mobileqq/statistics/cpu/CPUReport:r	I
    //   846: goto +17 -> 863
    //   849: lload 8
    //   851: lconst_0
    //   852: lcmp
    //   853: ifle +10 -> 863
    //   856: aload_0
    //   857: lload 8
    //   859: l2i
    //   860: putfield 245	com/tencent/mobileqq/statistics/cpu/CPUReport:r	I
    //   863: aload_0
    //   864: invokespecial 247	com/tencent/mobileqq/statistics/cpu/CPUReport:g	()J
    //   867: lstore 8
    //   869: lload 8
    //   871: lconst_0
    //   872: lcmp
    //   873: ifle +10 -> 883
    //   876: aload_0
    //   877: lload 8
    //   879: putfield 249	com/tencent/mobileqq/statistics/cpu/CPUReport:s	J
    //   882: return
    //   883: fload_3
    //   884: fconst_0
    //   885: fcmpl
    //   886: ifle +90 -> 976
    //   889: fload_3
    //   890: ldc 250
    //   892: fcmpg
    //   893: ifge +30 -> 923
    //   896: fload_3
    //   897: f2d
    //   898: dstore_1
    //   899: dload_1
    //   900: invokestatic 256	java/lang/Double:isNaN	(D)Z
    //   903: pop
    //   904: dload_1
    //   905: ldc2_w 257
    //   908: dmul
    //   909: ldc2_w 259
    //   912: dmul
    //   913: d2l
    //   914: lstore 8
    //   916: aload_0
    //   917: lload 8
    //   919: putfield 249	com/tencent/mobileqq/statistics/cpu/CPUReport:s	J
    //   922: return
    //   923: fload_3
    //   924: ldc_w 261
    //   927: fcmpl
    //   928: ifle +30 -> 958
    //   931: fload_3
    //   932: f2d
    //   933: dstore_1
    //   934: dload_1
    //   935: invokestatic 256	java/lang/Double:isNaN	(D)Z
    //   938: pop
    //   939: dload_1
    //   940: ldc2_w 262
    //   943: ddiv
    //   944: ldc2_w 259
    //   947: dmul
    //   948: d2l
    //   949: lstore 8
    //   951: aload_0
    //   952: lload 8
    //   954: putfield 249	com/tencent/mobileqq/statistics/cpu/CPUReport:s	J
    //   957: return
    //   958: aload_0
    //   959: fload_3
    //   960: ldc_w 264
    //   963: fmul
    //   964: f2l
    //   965: putfield 249	com/tencent/mobileqq/statistics/cpu/CPUReport:s	J
    //   968: return
    //   969: astore 14
    //   971: aload 14
    //   973: invokevirtual 265	java/lang/Exception:printStackTrace	()V
    //   976: return
    //   977: astore 14
    //   979: goto +79 -> 1058
    //   982: astore 14
    //   984: goto +61 -> 1045
    //   987: astore 14
    //   989: goto +43 -> 1032
    //   992: astore 14
    //   994: goto -318 -> 676
    //   997: astore 15
    //   999: goto -361 -> 638
    //   1002: astore 15
    //   1004: goto -376 -> 628
    //   1007: astore 15
    //   1009: goto -391 -> 618
    //   1012: astore 15
    //   1014: goto -406 -> 608
    //   1017: astore 17
    //   1019: goto -762 -> 257
    //   1022: astore 17
    //   1024: goto -728 -> 296
    //   1027: astore 15
    //   1029: goto -984 -> 45
    //   1032: aconst_null
    //   1033: astore 14
    //   1035: lload 8
    //   1037: lstore 12
    //   1039: fload_3
    //   1040: fstore 5
    //   1042: goto -321 -> 721
    //   1045: aconst_null
    //   1046: astore 14
    //   1048: lload 8
    //   1050: lstore 12
    //   1052: fload_3
    //   1053: fstore 5
    //   1055: goto -299 -> 756
    //   1058: aconst_null
    //   1059: astore 14
    //   1061: lload 8
    //   1063: lstore 12
    //   1065: fload_3
    //   1066: fstore 5
    //   1068: goto -277 -> 791
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1071	0	this	CPUReport
    //   898	42	1	d1	double
    //   26	1040	3	f1	float
    //   70	740	4	f2	float
    //   613	454	5	f3	float
    //   53	789	6	i1	int
    //   185	84	7	i2	int
    //   22	1040	8	l1	long
    //   67	739	10	l2	long
    //   610	454	12	l3	long
    //   43	30	14	localBufferedReader	java.io.BufferedReader
    //   80	3	14	localIOException1	java.io.IOException
    //   651	8	14	localObject1	Object
    //   666	3	14	localIOException2	java.io.IOException
    //   677	135	14	localObject2	Object
    //   969	3	14	localException1	Exception
    //   977	1	14	localFileNotFoundException1	java.io.FileNotFoundException
    //   982	1	14	localIOException3	java.io.IOException
    //   987	1	14	localNumberFormatException1	java.lang.NumberFormatException
    //   992	1	14	localException2	Exception
    //   1033	27	14	localObject3	Object
    //   50	531	15	str1	String
    //   603	1	15	localObject4	Object
    //   648	26	15	localObject5	Object
    //   997	1	15	localFileNotFoundException2	java.io.FileNotFoundException
    //   1002	1	15	localIOException4	java.io.IOException
    //   1007	1	15	localNumberFormatException2	java.lang.NumberFormatException
    //   1012	1	15	localException3	Exception
    //   1027	1	15	localNumberFormatException3	java.lang.NumberFormatException
    //   210	66	16	str2	String
    //   1017	1	17	localNumberFormatException4	java.lang.NumberFormatException
    //   1022	1	17	localNumberFormatException5	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   72	77	80	java/io/IOException
    //   706	711	80	java/io/IOException
    //   741	746	80	java/io/IOException
    //   776	781	80	java/io/IOException
    //   811	816	80	java/io/IOException
    //   45	52	603	finally
    //   60	65	603	finally
    //   97	116	603	finally
    //   122	165	603	finally
    //   168	187	603	finally
    //   193	212	603	finally
    //   217	241	603	finally
    //   244	254	603	finally
    //   257	264	603	finally
    //   271	293	603	finally
    //   305	320	603	finally
    //   323	342	603	finally
    //   348	383	603	finally
    //   386	405	603	finally
    //   411	432	603	finally
    //   435	454	603	finally
    //   457	476	603	finally
    //   482	501	603	finally
    //   501	508	603	finally
    //   536	555	603	finally
    //   561	580	603	finally
    //   580	587	603	finally
    //   27	45	648	finally
    //   658	663	666	java/io/IOException
    //   830	835	969	java/lang/Exception
    //   840	846	969	java/lang/Exception
    //   856	863	969	java/lang/Exception
    //   863	869	969	java/lang/Exception
    //   876	882	969	java/lang/Exception
    //   916	922	969	java/lang/Exception
    //   951	957	969	java/lang/Exception
    //   958	968	969	java/lang/Exception
    //   27	45	977	java/io/FileNotFoundException
    //   27	45	982	java/io/IOException
    //   27	45	987	java/lang/NumberFormatException
    //   27	45	992	java/lang/Exception
    //   45	52	997	java/io/FileNotFoundException
    //   60	65	997	java/io/FileNotFoundException
    //   97	116	997	java/io/FileNotFoundException
    //   122	165	997	java/io/FileNotFoundException
    //   168	187	997	java/io/FileNotFoundException
    //   193	212	997	java/io/FileNotFoundException
    //   217	241	997	java/io/FileNotFoundException
    //   244	254	997	java/io/FileNotFoundException
    //   257	264	997	java/io/FileNotFoundException
    //   271	293	997	java/io/FileNotFoundException
    //   305	320	997	java/io/FileNotFoundException
    //   323	342	997	java/io/FileNotFoundException
    //   348	383	997	java/io/FileNotFoundException
    //   386	405	997	java/io/FileNotFoundException
    //   411	432	997	java/io/FileNotFoundException
    //   435	454	997	java/io/FileNotFoundException
    //   457	476	997	java/io/FileNotFoundException
    //   482	501	997	java/io/FileNotFoundException
    //   501	508	997	java/io/FileNotFoundException
    //   536	555	997	java/io/FileNotFoundException
    //   561	580	997	java/io/FileNotFoundException
    //   580	587	997	java/io/FileNotFoundException
    //   45	52	1002	java/io/IOException
    //   60	65	1002	java/io/IOException
    //   97	116	1002	java/io/IOException
    //   122	165	1002	java/io/IOException
    //   168	187	1002	java/io/IOException
    //   193	212	1002	java/io/IOException
    //   217	241	1002	java/io/IOException
    //   244	254	1002	java/io/IOException
    //   257	264	1002	java/io/IOException
    //   271	293	1002	java/io/IOException
    //   305	320	1002	java/io/IOException
    //   323	342	1002	java/io/IOException
    //   348	383	1002	java/io/IOException
    //   386	405	1002	java/io/IOException
    //   411	432	1002	java/io/IOException
    //   435	454	1002	java/io/IOException
    //   457	476	1002	java/io/IOException
    //   482	501	1002	java/io/IOException
    //   501	508	1002	java/io/IOException
    //   536	555	1002	java/io/IOException
    //   561	580	1002	java/io/IOException
    //   580	587	1002	java/io/IOException
    //   45	52	1007	java/lang/NumberFormatException
    //   60	65	1007	java/lang/NumberFormatException
    //   97	116	1007	java/lang/NumberFormatException
    //   122	165	1007	java/lang/NumberFormatException
    //   168	187	1007	java/lang/NumberFormatException
    //   193	212	1007	java/lang/NumberFormatException
    //   217	241	1007	java/lang/NumberFormatException
    //   257	264	1007	java/lang/NumberFormatException
    //   305	320	1007	java/lang/NumberFormatException
    //   323	342	1007	java/lang/NumberFormatException
    //   348	383	1007	java/lang/NumberFormatException
    //   386	405	1007	java/lang/NumberFormatException
    //   411	432	1007	java/lang/NumberFormatException
    //   435	454	1007	java/lang/NumberFormatException
    //   457	476	1007	java/lang/NumberFormatException
    //   482	501	1007	java/lang/NumberFormatException
    //   536	555	1007	java/lang/NumberFormatException
    //   561	580	1007	java/lang/NumberFormatException
    //   45	52	1012	java/lang/Exception
    //   60	65	1012	java/lang/Exception
    //   97	116	1012	java/lang/Exception
    //   122	165	1012	java/lang/Exception
    //   168	187	1012	java/lang/Exception
    //   193	212	1012	java/lang/Exception
    //   217	241	1012	java/lang/Exception
    //   244	254	1012	java/lang/Exception
    //   257	264	1012	java/lang/Exception
    //   271	293	1012	java/lang/Exception
    //   305	320	1012	java/lang/Exception
    //   323	342	1012	java/lang/Exception
    //   348	383	1012	java/lang/Exception
    //   386	405	1012	java/lang/Exception
    //   411	432	1012	java/lang/Exception
    //   435	454	1012	java/lang/Exception
    //   457	476	1012	java/lang/Exception
    //   482	501	1012	java/lang/Exception
    //   501	508	1012	java/lang/Exception
    //   536	555	1012	java/lang/Exception
    //   561	580	1012	java/lang/Exception
    //   580	587	1012	java/lang/Exception
    //   244	254	1017	java/lang/NumberFormatException
    //   271	293	1022	java/lang/NumberFormatException
    //   501	508	1027	java/lang/NumberFormatException
    //   580	587	1027	java/lang/NumberFormatException
  }
  
  /* Error */
  private long g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 245	com/tencent/mobileqq/statistics/cpu/CPUReport:r	I
    //   4: iconst_1
    //   5: if_icmpge +24 -> 29
    //   8: invokestatic 268	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +12 -> 23
    //   14: ldc 176
    //   16: iconst_2
    //   17: ldc_w 270
    //   20: invokestatic 272	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: bipush 8
    //   26: putfield 245	com/tencent/mobileqq/statistics/cpu/CPUReport:r	I
    //   29: iconst_0
    //   30: istore_1
    //   31: lconst_0
    //   32: lstore_3
    //   33: lload_3
    //   34: lstore 7
    //   36: iconst_0
    //   37: istore_2
    //   38: iload_1
    //   39: aload_0
    //   40: getfield 245	com/tencent/mobileqq/statistics/cpu/CPUReport:r	I
    //   43: if_icmpge +345 -> 388
    //   46: aconst_null
    //   47: astore 12
    //   49: aconst_null
    //   50: astore 10
    //   52: ldc 43
    //   54: astore 11
    //   56: aload 10
    //   58: astore 9
    //   60: new 164	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   67: astore 13
    //   69: aload 10
    //   71: astore 9
    //   73: aload 13
    //   75: ldc_w 274
    //   78: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 10
    //   84: astore 9
    //   86: aload 13
    //   88: iload_1
    //   89: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 10
    //   95: astore 9
    //   97: aload 13
    //   99: ldc_w 279
    //   102: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 10
    //   108: astore 9
    //   110: new 128	java/io/BufferedReader
    //   113: dup
    //   114: new 130	java/io/FileReader
    //   117: dup
    //   118: aload 13
    //   120: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokespecial 133	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   126: invokespecial 136	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   129: astore 10
    //   131: aload 10
    //   133: invokevirtual 140	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   136: astore 12
    //   138: aload 11
    //   140: astore 9
    //   142: aload 12
    //   144: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   147: ifne +10 -> 157
    //   150: aload 12
    //   152: invokevirtual 204	java/lang/String:trim	()Ljava/lang/String;
    //   155: astore 9
    //   157: lload_3
    //   158: lstore 5
    //   160: aload 9
    //   162: ifnull +21 -> 183
    //   165: lload_3
    //   166: lstore 5
    //   168: aload 9
    //   170: invokevirtual 150	java/lang/String:length	()I
    //   173: ifle +10 -> 183
    //   176: aload 9
    //   178: invokestatic 156	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   181: lstore 5
    //   183: aload 10
    //   185: invokevirtual 159	java/io/BufferedReader:close	()V
    //   188: lload 5
    //   190: lstore_3
    //   191: goto +149 -> 340
    //   194: astore 9
    //   196: aload 9
    //   198: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   201: lload 5
    //   203: lstore_3
    //   204: goto +136 -> 340
    //   207: astore 11
    //   209: aload 10
    //   211: astore 9
    //   213: aload 11
    //   215: astore 10
    //   217: goto +148 -> 365
    //   220: astore 11
    //   222: goto +14 -> 236
    //   225: astore 10
    //   227: goto +138 -> 365
    //   230: astore 11
    //   232: aload 12
    //   234: astore 10
    //   236: aload 10
    //   238: astore 9
    //   240: new 164	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 165	java/lang/StringBuilder:<init>	()V
    //   247: astore 12
    //   249: aload 10
    //   251: astore 9
    //   253: aload 12
    //   255: ldc_w 281
    //   258: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 10
    //   264: astore 9
    //   266: aload 12
    //   268: iload_1
    //   269: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 10
    //   275: astore 9
    //   277: aload 12
    //   279: ldc_w 283
    //   282: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 10
    //   288: astore 9
    //   290: aload 12
    //   292: aload 11
    //   294: invokevirtual 174	java/lang/Exception:toString	()Ljava/lang/String;
    //   297: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 10
    //   303: astore 9
    //   305: ldc 176
    //   307: iconst_1
    //   308: aload 12
    //   310: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 182	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: aload 10
    //   318: ifnull +18 -> 336
    //   321: aload 10
    //   323: invokevirtual 159	java/io/BufferedReader:close	()V
    //   326: goto +10 -> 336
    //   329: astore 9
    //   331: aload 9
    //   333: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   336: lconst_0
    //   337: lstore_3
    //   338: iconst_1
    //   339: istore_2
    //   340: lload 7
    //   342: lstore 5
    //   344: lload_3
    //   345: lload 7
    //   347: lcmp
    //   348: ifle +6 -> 354
    //   351: lload_3
    //   352: lstore 5
    //   354: iload_1
    //   355: iconst_1
    //   356: iadd
    //   357: istore_1
    //   358: lload 5
    //   360: lstore 7
    //   362: goto -324 -> 38
    //   365: aload 9
    //   367: ifnull +18 -> 385
    //   370: aload 9
    //   372: invokevirtual 159	java/io/BufferedReader:close	()V
    //   375: goto +10 -> 385
    //   378: astore 9
    //   380: aload 9
    //   382: invokevirtual 162	java/io/IOException:printStackTrace	()V
    //   385: aload 10
    //   387: athrow
    //   388: iload_2
    //   389: ifeq +18 -> 407
    //   392: invokestatic 285	com/tencent/mobileqq/statistics/cpu/CPUReport:e	()J
    //   395: lstore 5
    //   397: lload 5
    //   399: lload_3
    //   400: lcmp
    //   401: ifle +6 -> 407
    //   404: lload 5
    //   406: lreturn
    //   407: lload 7
    //   409: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	this	CPUReport
    //   30	328	1	i1	int
    //   37	352	2	i2	int
    //   32	368	3	l1	long
    //   158	247	5	l2	long
    //   34	374	7	l3	long
    //   58	119	9	localObject1	Object
    //   194	3	9	localIOException1	java.io.IOException
    //   211	93	9	localObject2	Object
    //   329	42	9	localIOException2	java.io.IOException
    //   378	3	9	localIOException3	java.io.IOException
    //   50	166	10	localObject3	Object
    //   225	1	10	localObject4	Object
    //   234	152	10	localObject5	Object
    //   54	85	11	str	String
    //   207	7	11	localObject6	Object
    //   220	1	11	localException1	Exception
    //   230	63	11	localException2	Exception
    //   47	262	12	localObject7	Object
    //   67	52	13	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   183	188	194	java/io/IOException
    //   131	138	207	finally
    //   142	157	207	finally
    //   168	183	207	finally
    //   131	138	220	java/lang/Exception
    //   142	157	220	java/lang/Exception
    //   168	183	220	java/lang/Exception
    //   60	69	225	finally
    //   73	82	225	finally
    //   86	93	225	finally
    //   97	106	225	finally
    //   110	131	225	finally
    //   240	249	225	finally
    //   253	262	225	finally
    //   266	273	225	finally
    //   277	286	225	finally
    //   290	301	225	finally
    //   305	316	225	finally
    //   60	69	230	java/lang/Exception
    //   73	82	230	java/lang/Exception
    //   86	93	230	java/lang/Exception
    //   97	106	230	java/lang/Exception
    //   110	131	230	java/lang/Exception
    //   321	326	329	java/io/IOException
    //   370	375	378	java/io/IOException
  }
  
  private boolean h()
  {
    Object localObject = System.getProperty("java.library.path");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    localObject = ((String)localObject).split(":");
    if (localObject != null)
    {
      if (localObject.length == 0) {
        return false;
      }
      int i2 = localObject.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = localObject[i1];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(File.separator);
        localStringBuilder.append("libOpenCL.so");
        if (new File(localStringBuilder.toString()).exists()) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      b();
      this.l = true;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("cpuArch", String.valueOf(this.f));
    localHashMap.put("CPU_ABI", String.valueOf(this.i));
    localHashMap.put("CPU_ABI2", String.valueOf(this.j));
    localHashMap.put("SUPPORTED_ABIS", String.valueOf(this.k));
    localHashMap.put("brand", this.g);
    localHashMap.put("model", this.h);
    localHashMap.put("infoProcessorName", this.m);
    localHashMap.put("infoArchitectureId", String.valueOf(this.n));
    localHashMap.put("infoVendorId", this.p);
    localHashMap.put("infoHardware", this.q);
    localHashMap.put("infoCoreNum", String.valueOf(this.r));
    localHashMap.put("infoMaxCoreFreq", Long.toString(this.s));
    boolean bool = this.t;
    String str = "1";
    Object localObject;
    if (bool) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("doneReadCpuInfo", localObject);
    if (this.l) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("doneGetField", localObject);
    if (h()) {
      localObject = str;
    } else {
      localObject = "0";
    }
    localHashMap.put("hasOpenCLSo", localObject);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "CPUREPORT_730", true, 0L, 0L, localHashMap, "");
  }
  
  public final boolean a()
  {
    int i1 = this.f;
    return (i1 == 5) || (i1 == 4) || (i1 == 9);
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    this.i = a(Build.CPU_ABI);
    this.j = a(Build.CPU_ABI2);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = Build.SUPPORTED_ABIS;
      if (localObject != null)
      {
        i1 = 0;
        while (i1 < localObject.length)
        {
          this.k = (a(localObject[i1]) | this.k);
          i1 += 1;
        }
      }
    }
    Object localObject = Build.BRAND;
    String str = "";
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = Build.BRAND;
    }
    this.g = ((String)localObject);
    if (Build.MODEL == null) {
      localObject = str;
    } else {
      localObject = Build.BOARD;
    }
    this.h = ((String)localObject);
    int i1 = this.i;
    int i3 = d;
    if (i1 != i3)
    {
      i2 = this.k;
      if ((i2 & i3) != i3)
      {
        i3 = c;
        if ((i1 != i3) && ((i2 & i3) != i3))
        {
          i3 = b;
          if ((i1 != i3) && ((i2 & i3) != i3))
          {
            i3 = a;
            if ((i1 != i3) && ((i2 & i3) != i3))
            {
              i3 = e;
              if ((i1 != i3) && ((i2 & i3) != i3)) {
                break label325;
              }
              this.f = 6;
              break label325;
            }
            this.f = 1;
            break label325;
          }
          this.f = 4;
          break label325;
        }
        this.f = 5;
        break label325;
      }
    }
    this.f = 7;
    int i2 = this.j;
    i1 = b;
    if ((i2 != i1) && (i2 != a))
    {
      i2 = this.k;
      if (((i2 & i1) != i1) && ((i2 & i1) != i1)) {}
    }
    else
    {
      this.f = 8;
    }
    label325:
    f();
    if (this.t)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getCpuArch not found in android.Build infoArchId:");
        ((StringBuilder)localObject).append(this.n);
        ((StringBuilder)localObject).append(" vendorId:");
        ((StringBuilder)localObject).append(this.p);
        QLog.i("CPUReport", 2, ((StringBuilder)localObject).toString());
      }
      if (this.f == 0)
      {
        i1 = this.n;
        if (i1 != 5)
        {
          if (i1 != 6)
          {
            if (i1 != 7)
            {
              if (i1 != 8)
              {
                localObject = this.p;
                if ((localObject != null) && ((((String)localObject).equalsIgnoreCase("AuthenticAMD")) || (this.p.equalsIgnoreCase("GenuineIntel")))) {
                  this.f = 7;
                }
              }
              else
              {
                this.f = 5;
              }
            }
            else {
              this.f = 4;
            }
          }
          else {
            this.f = 2;
          }
        }
        else {
          this.f = 1;
        }
      }
      if ((this.f == 4) && (this.m.contains("aarch64"))) {
        this.f = 5;
      } else if ((this.f == 1) && (this.m.contains("armv6"))) {
        this.f = 2;
      }
      if ((this.f == 4) && (!this.o.contains("neon")))
      {
        this.f = 3;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getCpuArch armv7a neon not supported ");
          ((StringBuilder)localObject).append(this.g);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(this.h);
          QLog.i("CPUReport", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if ((this.f == 8) && (this.o.contains("neon")))
      {
        this.f = 9;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getCpuArch x86 neon supported ");
          ((StringBuilder)localObject).append(this.g);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(this.h);
          QLog.i("CPUReport", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("cpuArch");
      localStringBuilder.append("=");
      localStringBuilder.append(this.f);
      localStringBuilder.append('\n');
      localStringBuilder.append("CPU_ABI");
      localStringBuilder.append("=");
      localStringBuilder.append(this.i);
      localStringBuilder.append('\n');
      localStringBuilder.append("CPU_ABI2");
      localStringBuilder.append("=");
      localStringBuilder.append(this.j);
      localStringBuilder.append('\n');
      localStringBuilder.append("SUPPORTED_ABIS");
      localStringBuilder.append("=");
      localStringBuilder.append(this.k);
      localStringBuilder.append('\n');
      localStringBuilder.append("brand");
      localStringBuilder.append("=");
      localStringBuilder.append(this.g);
      localStringBuilder.append('\n');
      localStringBuilder.append("model");
      localStringBuilder.append("=");
      localStringBuilder.append(this.h);
      localStringBuilder.append('\n');
      localStringBuilder.append("infoProcessorName");
      localStringBuilder.append("=");
      localStringBuilder.append(this.m);
      localStringBuilder.append('\n');
      localStringBuilder.append("infoArchitectureId");
      localStringBuilder.append("=");
      localStringBuilder.append(this.n);
      localStringBuilder.append('\n');
      localStringBuilder.append("infoVendorId");
      localStringBuilder.append("=");
      localStringBuilder.append(this.p);
      localStringBuilder.append('\n');
      localStringBuilder.append("infoHardware");
      localStringBuilder.append("=");
      localStringBuilder.append(this.q);
      localStringBuilder.append('\n');
      localStringBuilder.append("infoCoreNum");
      localStringBuilder.append("=");
      localStringBuilder.append(this.r);
      localStringBuilder.append('\n');
      localStringBuilder.append("infoMaxCoreFreq");
      localStringBuilder.append("=");
      localStringBuilder.append(this.s);
      localStringBuilder.append('\n');
      localStringBuilder.append("doneReadCpuInfo");
      localStringBuilder.append("=");
      localStringBuilder.append(this.t);
      localStringBuilder.append('\n');
      QLog.i("CPUReport", 2, localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.cpu.CPUReport
 * JD-Core Version:    0.7.0.1
 */