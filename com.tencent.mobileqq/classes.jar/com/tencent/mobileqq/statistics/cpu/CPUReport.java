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
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  String c;
  String d;
  String e;
  int jdField_f_of_type_Int = 0;
  String jdField_f_of_type_JavaLangString = "";
  int g;
  int h;
  int i;
  int j;
  int k;
  
  public CPUReport()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
  }
  
  static int a()
  {
    try
    {
      int m = new File("/sys/devices/system/cpu/").listFiles(new CPUReport.1CpuFilter()).length;
      return m;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    return 0;
  }
  
  private static int a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int m = 0;
    if (bool) {
      return 0;
    }
    if ("arm64-v8a".equalsIgnoreCase(paramString)) {
      return jdField_c_of_type_Int;
    }
    if ("armeabi-v7a".equalsIgnoreCase(paramString)) {
      return jdField_b_of_type_Int;
    }
    if ((!"armeabi".equalsIgnoreCase(paramString)) && (paramString.indexOf("arm") < 0))
    {
      if ((!"x86".equalsIgnoreCase(paramString)) && (paramString.indexOf("x86") < 0))
      {
        if (("mips".equalsIgnoreCase(paramString)) || (paramString.indexOf("mips") >= 0)) {
          return jdField_e_of_type_Int;
        }
      }
      else {
        return jdField_d_of_type_Int;
      }
    }
    else {
      m = jdField_a_of_type_Int;
    }
    return m;
  }
  
  /* Error */
  static long a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: lconst_0
    //   4: lstore_3
    //   5: new 102	java/io/BufferedReader
    //   8: dup
    //   9: new 104	java/io/FileReader
    //   12: dup
    //   13: ldc 106
    //   15: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore 7
    //   23: aload 7
    //   25: astore 5
    //   27: aload 7
    //   29: invokevirtual 114	java/io/BufferedReader:readLine	()Ljava/lang/String;
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
    //   57: invokevirtual 114	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore 8
    //   62: aload 8
    //   64: astore 5
    //   66: goto -28 -> 38
    //   69: aload 7
    //   71: astore 5
    //   73: aload 8
    //   75: bipush 9
    //   77: invokevirtual 117	java/lang/String:indexOf	(I)I
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
    //   96: invokevirtual 121	java/lang/String:substring	(II)Ljava/lang/String;
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
    //   116: invokevirtual 124	java/lang/String:length	()I
    //   119: ifle +13 -> 132
    //   122: aload 7
    //   124: astore 5
    //   126: aload 6
    //   128: invokestatic 130	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   131: lstore_1
    //   132: lload_1
    //   133: lstore_3
    //   134: aload 7
    //   136: invokevirtual 133	java/io/BufferedReader:close	()V
    //   139: lload_1
    //   140: lreturn
    //   141: astore 5
    //   143: aload 5
    //   145: invokevirtual 136	java/io/IOException:printStackTrace	()V
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
    //   176: new 138	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   183: astore 7
    //   185: aload 6
    //   187: astore 5
    //   189: aload 7
    //   191: ldc 141
    //   193: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 6
    //   199: astore 5
    //   201: aload 7
    //   203: aload 8
    //   205: invokevirtual 148	java/lang/Exception:toString	()Ljava/lang/String;
    //   208: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 6
    //   214: astore 5
    //   216: ldc 150
    //   218: iconst_1
    //   219: aload 7
    //   221: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 156	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: aload 6
    //   229: ifnull +8 -> 237
    //   232: aload 6
    //   234: invokevirtual 133	java/io/BufferedReader:close	()V
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
    //   256: invokevirtual 133	java/io/BufferedReader:close	()V
    //   259: goto +10 -> 269
    //   262: astore 6
    //   264: aload 6
    //   266: invokevirtual 136	java/io/IOException:printStackTrace	()V
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
    //   80	205	0	m	int
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
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 162	com/tencent/mobileqq/statistics/cpu/CPUReport:jdField_b_of_type_Boolean	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: new 138	java/lang/StringBuilder
    //   11: dup
    //   12: sipush 1024
    //   15: invokespecial 165	java/lang/StringBuilder:<init>	(I)V
    //   18: pop
    //   19: ldc2_w 166
    //   22: lstore 8
    //   24: ldc 168
    //   26: fstore_3
    //   27: new 102	java/io/BufferedReader
    //   30: dup
    //   31: new 104	java/io/FileReader
    //   34: dup
    //   35: ldc 170
    //   37: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   40: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore 14
    //   45: aload 14
    //   47: invokevirtual 114	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore 15
    //   52: iconst_1
    //   53: istore 6
    //   55: aload 15
    //   57: ifnonnull +40 -> 97
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 162	com/tencent/mobileqq/statistics/cpu/CPUReport:jdField_b_of_type_Boolean	Z
    //   65: lload 8
    //   67: lstore 10
    //   69: fload_3
    //   70: fstore 4
    //   72: aload 14
    //   74: invokevirtual 133	java/io/BufferedReader:close	()V
    //   77: goto +746 -> 823
    //   80: astore 14
    //   82: aload 14
    //   84: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   87: lload 10
    //   89: lstore 8
    //   91: fload 4
    //   93: fstore_3
    //   94: goto +729 -> 823
    //   97: aload 15
    //   99: ldc 172
    //   101: invokevirtual 175	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   104: ifeq +64 -> 168
    //   107: aload 15
    //   109: bipush 58
    //   111: invokevirtual 117	java/lang/String:indexOf	(I)I
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
    //   131: invokevirtual 124	java/lang/String:length	()I
    //   134: invokevirtual 121	java/lang/String:substring	(II)Ljava/lang/String;
    //   137: putfield 36	com/tencent/mobileqq/statistics/cpu/CPUReport:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 36	com/tencent/mobileqq/statistics/cpu/CPUReport:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   145: invokevirtual 178	java/lang/String:trim	()Ljava/lang/String;
    //   148: putfield 36	com/tencent/mobileqq/statistics/cpu/CPUReport:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   151: aload_0
    //   152: aload_0
    //   153: getfield 36	com/tencent/mobileqq/statistics/cpu/CPUReport:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   156: getstatic 184	java/util/Locale:US	Ljava/util/Locale;
    //   159: invokevirtual 188	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   162: putfield 36	com/tencent/mobileqq/statistics/cpu/CPUReport:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   165: goto -120 -> 45
    //   168: aload 15
    //   170: ldc 190
    //   172: invokevirtual 175	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   175: ifeq +148 -> 323
    //   178: aload 15
    //   180: bipush 58
    //   182: invokevirtual 117	java/lang/String:indexOf	(I)I
    //   185: istore 7
    //   187: iload 7
    //   189: iconst_1
    //   190: if_icmple +115 -> 305
    //   193: aload 15
    //   195: iload 7
    //   197: iconst_1
    //   198: iadd
    //   199: aload 15
    //   201: invokevirtual 124	java/lang/String:length	()I
    //   204: invokevirtual 121	java/lang/String:substring	(II)Ljava/lang/String;
    //   207: invokevirtual 178	java/lang/String:trim	()Ljava/lang/String;
    //   210: astore 16
    //   212: aload 16
    //   214: ifnull +91 -> 305
    //   217: aload 16
    //   219: invokevirtual 124	java/lang/String:length	()I
    //   222: ifle +83 -> 305
    //   225: aload 16
    //   227: ldc 192
    //   229: invokevirtual 74	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   232: ifeq +12 -> 244
    //   235: aload_0
    //   236: bipush 8
    //   238: putfield 194	com/tencent/mobileqq/statistics/cpu/CPUReport:j	I
    //   241: goto +64 -> 305
    //   244: aload_0
    //   245: aload 16
    //   247: invokestatic 130	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   250: l2i
    //   251: putfield 194	com/tencent/mobileqq/statistics/cpu/CPUReport:j	I
    //   254: goto +51 -> 305
    //   257: aload 16
    //   259: invokevirtual 124	java/lang/String:length	()I
    //   262: istore 7
    //   264: iload 6
    //   266: iload 7
    //   268: if_icmpge +37 -> 305
    //   271: aload_0
    //   272: aload 16
    //   274: iconst_0
    //   275: aload 16
    //   277: invokevirtual 124	java/lang/String:length	()I
    //   280: iload 6
    //   282: isub
    //   283: invokevirtual 121	java/lang/String:substring	(II)Ljava/lang/String;
    //   286: invokestatic 130	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   289: l2i
    //   290: putfield 194	com/tencent/mobileqq/statistics/cpu/CPUReport:j	I
    //   293: goto +12 -> 305
    //   296: iload 6
    //   298: iconst_1
    //   299: iadd
    //   300: istore 6
    //   302: goto -45 -> 257
    //   305: aload 15
    //   307: ldc 196
    //   309: invokevirtual 199	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   312: ifeq -267 -> 45
    //   315: aload_0
    //   316: iconst_5
    //   317: putfield 194	com/tencent/mobileqq/statistics/cpu/CPUReport:j	I
    //   320: goto -275 -> 45
    //   323: aload 15
    //   325: ldc 201
    //   327: invokevirtual 175	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   330: ifeq +56 -> 386
    //   333: aload 15
    //   335: bipush 58
    //   337: invokevirtual 117	java/lang/String:indexOf	(I)I
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
    //   357: invokevirtual 124	java/lang/String:length	()I
    //   360: invokevirtual 121	java/lang/String:substring	(II)Ljava/lang/String;
    //   363: invokevirtual 178	java/lang/String:trim	()Ljava/lang/String;
    //   366: putfield 38	com/tencent/mobileqq/statistics/cpu/CPUReport:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   369: aload_0
    //   370: aload_0
    //   371: getfield 38	com/tencent/mobileqq/statistics/cpu/CPUReport:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   374: getstatic 184	java/util/Locale:US	Ljava/util/Locale;
    //   377: invokevirtual 188	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   380: putfield 38	com/tencent/mobileqq/statistics/cpu/CPUReport:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   383: goto -338 -> 45
    //   386: aload 15
    //   388: ldc 203
    //   390: invokevirtual 175	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   393: ifeq +42 -> 435
    //   396: aload 15
    //   398: bipush 58
    //   400: invokevirtual 117	java/lang/String:indexOf	(I)I
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
    //   420: invokevirtual 124	java/lang/String:length	()I
    //   423: invokevirtual 121	java/lang/String:substring	(II)Ljava/lang/String;
    //   426: invokevirtual 178	java/lang/String:trim	()Ljava/lang/String;
    //   429: putfield 40	com/tencent/mobileqq/statistics/cpu/CPUReport:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   432: goto -387 -> 45
    //   435: aload 15
    //   437: ldc 205
    //   439: invokevirtual 175	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   442: ifeq +15 -> 457
    //   445: aload_0
    //   446: aload 15
    //   448: invokevirtual 178	java/lang/String:trim	()Ljava/lang/String;
    //   451: putfield 42	com/tencent/mobileqq/statistics/cpu/CPUReport:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   454: goto -409 -> 45
    //   457: aload 15
    //   459: ldc 207
    //   461: invokevirtual 175	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   464: ifeq +72 -> 536
    //   467: aload 15
    //   469: bipush 58
    //   471: invokevirtual 117	java/lang/String:indexOf	(I)I
    //   474: istore 6
    //   476: iload 6
    //   478: iconst_1
    //   479: if_icmple -434 -> 45
    //   482: aload 15
    //   484: iload 6
    //   486: iconst_1
    //   487: iadd
    //   488: aload 15
    //   490: invokevirtual 124	java/lang/String:length	()I
    //   493: invokevirtual 121	java/lang/String:substring	(II)Ljava/lang/String;
    //   496: invokevirtual 178	java/lang/String:trim	()Ljava/lang/String;
    //   499: astore 15
    //   501: aload 15
    //   503: invokestatic 130	java/lang/Long:parseLong	(Ljava/lang/String;)J
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
    //   538: ldc 209
    //   540: invokevirtual 175	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   543: ifeq -498 -> 45
    //   546: aload 15
    //   548: bipush 58
    //   550: invokevirtual 117	java/lang/String:indexOf	(I)I
    //   553: istore 6
    //   555: iload 6
    //   557: iconst_1
    //   558: if_icmple -513 -> 45
    //   561: aload 15
    //   563: iload 6
    //   565: iconst_1
    //   566: iadd
    //   567: aload 15
    //   569: invokevirtual 124	java/lang/String:length	()I
    //   572: invokevirtual 121	java/lang/String:substring	(II)Ljava/lang/String;
    //   575: invokevirtual 178	java/lang/String:trim	()Ljava/lang/String;
    //   578: astore 15
    //   580: aload 15
    //   582: invokestatic 215	java/lang/Float:parseFloat	(Ljava/lang/String;)F
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
    //   660: invokevirtual 133	java/io/BufferedReader:close	()V
    //   663: goto +10 -> 673
    //   666: astore 14
    //   668: aload 14
    //   670: invokevirtual 136	java/io/IOException:printStackTrace	()V
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
    //   708: invokevirtual 133	java/io/BufferedReader:close	()V
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
    //   743: invokevirtual 133	java/io/BufferedReader:close	()V
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
    //   778: invokevirtual 133	java/io/BufferedReader:close	()V
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
    //   813: invokevirtual 133	java/io/BufferedReader:close	()V
    //   816: fload 5
    //   818: fstore_3
    //   819: lload 12
    //   821: lstore 8
    //   823: aload_0
    //   824: getfield 162	com/tencent/mobileqq/statistics/cpu/CPUReport:jdField_b_of_type_Boolean	Z
    //   827: ifeq +147 -> 974
    //   830: invokestatic 217	com/tencent/mobileqq/statistics/cpu/CPUReport:a	()I
    //   833: istore 6
    //   835: iload 6
    //   837: ifle +12 -> 849
    //   840: aload_0
    //   841: iload 6
    //   843: putfield 219	com/tencent/mobileqq/statistics/cpu/CPUReport:k	I
    //   846: goto +17 -> 863
    //   849: lload 8
    //   851: lconst_0
    //   852: lcmp
    //   853: ifle +10 -> 863
    //   856: aload_0
    //   857: lload 8
    //   859: l2i
    //   860: putfield 219	com/tencent/mobileqq/statistics/cpu/CPUReport:k	I
    //   863: aload_0
    //   864: invokespecial 221	com/tencent/mobileqq/statistics/cpu/CPUReport:b	()J
    //   867: lstore 8
    //   869: lload 8
    //   871: lconst_0
    //   872: lcmp
    //   873: ifle +10 -> 883
    //   876: aload_0
    //   877: lload 8
    //   879: putfield 223	com/tencent/mobileqq/statistics/cpu/CPUReport:jdField_a_of_type_Long	J
    //   882: return
    //   883: fload_3
    //   884: fconst_0
    //   885: fcmpl
    //   886: ifle +88 -> 974
    //   889: fload_3
    //   890: ldc 224
    //   892: fcmpg
    //   893: ifge +30 -> 923
    //   896: fload_3
    //   897: f2d
    //   898: dstore_1
    //   899: dload_1
    //   900: invokestatic 230	java/lang/Double:isNaN	(D)Z
    //   903: pop
    //   904: dload_1
    //   905: ldc2_w 231
    //   908: dmul
    //   909: ldc2_w 233
    //   912: dmul
    //   913: d2l
    //   914: lstore 8
    //   916: aload_0
    //   917: lload 8
    //   919: putfield 223	com/tencent/mobileqq/statistics/cpu/CPUReport:jdField_a_of_type_Long	J
    //   922: return
    //   923: fload_3
    //   924: ldc 235
    //   926: fcmpl
    //   927: ifle +30 -> 957
    //   930: fload_3
    //   931: f2d
    //   932: dstore_1
    //   933: dload_1
    //   934: invokestatic 230	java/lang/Double:isNaN	(D)Z
    //   937: pop
    //   938: dload_1
    //   939: ldc2_w 236
    //   942: ddiv
    //   943: ldc2_w 233
    //   946: dmul
    //   947: d2l
    //   948: lstore 8
    //   950: aload_0
    //   951: lload 8
    //   953: putfield 223	com/tencent/mobileqq/statistics/cpu/CPUReport:jdField_a_of_type_Long	J
    //   956: return
    //   957: aload_0
    //   958: fload_3
    //   959: ldc 238
    //   961: fmul
    //   962: f2l
    //   963: putfield 223	com/tencent/mobileqq/statistics/cpu/CPUReport:jdField_a_of_type_Long	J
    //   966: return
    //   967: astore 14
    //   969: aload 14
    //   971: invokevirtual 239	java/lang/Exception:printStackTrace	()V
    //   974: return
    //   975: astore 14
    //   977: goto +79 -> 1056
    //   980: astore 14
    //   982: goto +61 -> 1043
    //   985: astore 14
    //   987: goto +43 -> 1030
    //   990: astore 14
    //   992: goto -316 -> 676
    //   995: astore 15
    //   997: goto -359 -> 638
    //   1000: astore 15
    //   1002: goto -374 -> 628
    //   1005: astore 15
    //   1007: goto -389 -> 618
    //   1010: astore 15
    //   1012: goto -404 -> 608
    //   1015: astore 17
    //   1017: goto -760 -> 257
    //   1020: astore 17
    //   1022: goto -726 -> 296
    //   1025: astore 15
    //   1027: goto -982 -> 45
    //   1030: aconst_null
    //   1031: astore 14
    //   1033: lload 8
    //   1035: lstore 12
    //   1037: fload_3
    //   1038: fstore 5
    //   1040: goto -319 -> 721
    //   1043: aconst_null
    //   1044: astore 14
    //   1046: lload 8
    //   1048: lstore 12
    //   1050: fload_3
    //   1051: fstore 5
    //   1053: goto -297 -> 756
    //   1056: aconst_null
    //   1057: astore 14
    //   1059: lload 8
    //   1061: lstore 12
    //   1063: fload_3
    //   1064: fstore 5
    //   1066: goto -275 -> 791
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1069	0	this	CPUReport
    //   898	41	1	d1	double
    //   26	1038	3	f1	float
    //   70	740	4	f2	float
    //   613	452	5	f3	float
    //   53	789	6	m	int
    //   185	84	7	n	int
    //   22	1038	8	l1	long
    //   67	739	10	l2	long
    //   610	452	12	l3	long
    //   43	30	14	localBufferedReader	java.io.BufferedReader
    //   80	3	14	localIOException1	java.io.IOException
    //   651	8	14	localObject1	Object
    //   666	3	14	localIOException2	java.io.IOException
    //   677	135	14	localObject2	Object
    //   967	3	14	localException1	Exception
    //   975	1	14	localFileNotFoundException1	java.io.FileNotFoundException
    //   980	1	14	localIOException3	java.io.IOException
    //   985	1	14	localNumberFormatException1	java.lang.NumberFormatException
    //   990	1	14	localException2	Exception
    //   1031	27	14	localObject3	Object
    //   50	531	15	str1	String
    //   603	1	15	localObject4	Object
    //   648	26	15	localObject5	Object
    //   995	1	15	localFileNotFoundException2	java.io.FileNotFoundException
    //   1000	1	15	localIOException4	java.io.IOException
    //   1005	1	15	localNumberFormatException2	java.lang.NumberFormatException
    //   1010	1	15	localException3	Exception
    //   1025	1	15	localNumberFormatException3	java.lang.NumberFormatException
    //   210	66	16	str2	String
    //   1015	1	17	localNumberFormatException4	java.lang.NumberFormatException
    //   1020	1	17	localNumberFormatException5	java.lang.NumberFormatException
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
    //   830	835	967	java/lang/Exception
    //   840	846	967	java/lang/Exception
    //   856	863	967	java/lang/Exception
    //   863	869	967	java/lang/Exception
    //   876	882	967	java/lang/Exception
    //   916	922	967	java/lang/Exception
    //   950	956	967	java/lang/Exception
    //   957	966	967	java/lang/Exception
    //   27	45	975	java/io/FileNotFoundException
    //   27	45	980	java/io/IOException
    //   27	45	985	java/lang/NumberFormatException
    //   27	45	990	java/lang/Exception
    //   45	52	995	java/io/FileNotFoundException
    //   60	65	995	java/io/FileNotFoundException
    //   97	116	995	java/io/FileNotFoundException
    //   122	165	995	java/io/FileNotFoundException
    //   168	187	995	java/io/FileNotFoundException
    //   193	212	995	java/io/FileNotFoundException
    //   217	241	995	java/io/FileNotFoundException
    //   244	254	995	java/io/FileNotFoundException
    //   257	264	995	java/io/FileNotFoundException
    //   271	293	995	java/io/FileNotFoundException
    //   305	320	995	java/io/FileNotFoundException
    //   323	342	995	java/io/FileNotFoundException
    //   348	383	995	java/io/FileNotFoundException
    //   386	405	995	java/io/FileNotFoundException
    //   411	432	995	java/io/FileNotFoundException
    //   435	454	995	java/io/FileNotFoundException
    //   457	476	995	java/io/FileNotFoundException
    //   482	501	995	java/io/FileNotFoundException
    //   501	508	995	java/io/FileNotFoundException
    //   536	555	995	java/io/FileNotFoundException
    //   561	580	995	java/io/FileNotFoundException
    //   580	587	995	java/io/FileNotFoundException
    //   45	52	1000	java/io/IOException
    //   60	65	1000	java/io/IOException
    //   97	116	1000	java/io/IOException
    //   122	165	1000	java/io/IOException
    //   168	187	1000	java/io/IOException
    //   193	212	1000	java/io/IOException
    //   217	241	1000	java/io/IOException
    //   244	254	1000	java/io/IOException
    //   257	264	1000	java/io/IOException
    //   271	293	1000	java/io/IOException
    //   305	320	1000	java/io/IOException
    //   323	342	1000	java/io/IOException
    //   348	383	1000	java/io/IOException
    //   386	405	1000	java/io/IOException
    //   411	432	1000	java/io/IOException
    //   435	454	1000	java/io/IOException
    //   457	476	1000	java/io/IOException
    //   482	501	1000	java/io/IOException
    //   501	508	1000	java/io/IOException
    //   536	555	1000	java/io/IOException
    //   561	580	1000	java/io/IOException
    //   580	587	1000	java/io/IOException
    //   45	52	1005	java/lang/NumberFormatException
    //   60	65	1005	java/lang/NumberFormatException
    //   97	116	1005	java/lang/NumberFormatException
    //   122	165	1005	java/lang/NumberFormatException
    //   168	187	1005	java/lang/NumberFormatException
    //   193	212	1005	java/lang/NumberFormatException
    //   217	241	1005	java/lang/NumberFormatException
    //   257	264	1005	java/lang/NumberFormatException
    //   305	320	1005	java/lang/NumberFormatException
    //   323	342	1005	java/lang/NumberFormatException
    //   348	383	1005	java/lang/NumberFormatException
    //   386	405	1005	java/lang/NumberFormatException
    //   411	432	1005	java/lang/NumberFormatException
    //   435	454	1005	java/lang/NumberFormatException
    //   457	476	1005	java/lang/NumberFormatException
    //   482	501	1005	java/lang/NumberFormatException
    //   536	555	1005	java/lang/NumberFormatException
    //   561	580	1005	java/lang/NumberFormatException
    //   45	52	1010	java/lang/Exception
    //   60	65	1010	java/lang/Exception
    //   97	116	1010	java/lang/Exception
    //   122	165	1010	java/lang/Exception
    //   168	187	1010	java/lang/Exception
    //   193	212	1010	java/lang/Exception
    //   217	241	1010	java/lang/Exception
    //   244	254	1010	java/lang/Exception
    //   257	264	1010	java/lang/Exception
    //   271	293	1010	java/lang/Exception
    //   305	320	1010	java/lang/Exception
    //   323	342	1010	java/lang/Exception
    //   348	383	1010	java/lang/Exception
    //   386	405	1010	java/lang/Exception
    //   411	432	1010	java/lang/Exception
    //   435	454	1010	java/lang/Exception
    //   457	476	1010	java/lang/Exception
    //   482	501	1010	java/lang/Exception
    //   501	508	1010	java/lang/Exception
    //   536	555	1010	java/lang/Exception
    //   561	580	1010	java/lang/Exception
    //   580	587	1010	java/lang/Exception
    //   244	254	1015	java/lang/NumberFormatException
    //   271	293	1020	java/lang/NumberFormatException
    //   501	508	1025	java/lang/NumberFormatException
    //   580	587	1025	java/lang/NumberFormatException
  }
  
  /* Error */
  private long b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 219	com/tencent/mobileqq/statistics/cpu/CPUReport:k	I
    //   4: iconst_1
    //   5: if_icmpge +23 -> 28
    //   8: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +11 -> 22
    //   14: ldc 150
    //   16: iconst_2
    //   17: ldc 245
    //   19: invokestatic 247	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: bipush 8
    //   25: putfield 219	com/tencent/mobileqq/statistics/cpu/CPUReport:k	I
    //   28: iconst_0
    //   29: istore_1
    //   30: lconst_0
    //   31: lstore_3
    //   32: lload_3
    //   33: lstore 7
    //   35: iconst_0
    //   36: istore_2
    //   37: iload_1
    //   38: aload_0
    //   39: getfield 219	com/tencent/mobileqq/statistics/cpu/CPUReport:k	I
    //   42: if_icmpge +343 -> 385
    //   45: aconst_null
    //   46: astore 12
    //   48: aconst_null
    //   49: astore 10
    //   51: ldc 34
    //   53: astore 11
    //   55: aload 10
    //   57: astore 9
    //   59: new 138	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   66: astore 13
    //   68: aload 10
    //   70: astore 9
    //   72: aload 13
    //   74: ldc 249
    //   76: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload 10
    //   82: astore 9
    //   84: aload 13
    //   86: iload_1
    //   87: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 10
    //   93: astore 9
    //   95: aload 13
    //   97: ldc 254
    //   99: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 10
    //   105: astore 9
    //   107: new 102	java/io/BufferedReader
    //   110: dup
    //   111: new 104	java/io/FileReader
    //   114: dup
    //   115: aload 13
    //   117: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   123: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   126: astore 10
    //   128: aload 10
    //   130: invokevirtual 114	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   133: astore 12
    //   135: aload 11
    //   137: astore 9
    //   139: aload 12
    //   141: invokestatic 66	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +10 -> 154
    //   147: aload 12
    //   149: invokevirtual 178	java/lang/String:trim	()Ljava/lang/String;
    //   152: astore 9
    //   154: lload_3
    //   155: lstore 5
    //   157: aload 9
    //   159: ifnull +21 -> 180
    //   162: lload_3
    //   163: lstore 5
    //   165: aload 9
    //   167: invokevirtual 124	java/lang/String:length	()I
    //   170: ifle +10 -> 180
    //   173: aload 9
    //   175: invokestatic 130	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   178: lstore 5
    //   180: aload 10
    //   182: invokevirtual 133	java/io/BufferedReader:close	()V
    //   185: lload 5
    //   187: lstore_3
    //   188: goto +149 -> 337
    //   191: astore 9
    //   193: aload 9
    //   195: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   198: lload 5
    //   200: lstore_3
    //   201: goto +136 -> 337
    //   204: astore 11
    //   206: aload 10
    //   208: astore 9
    //   210: aload 11
    //   212: astore 10
    //   214: goto +148 -> 362
    //   217: astore 11
    //   219: goto +14 -> 233
    //   222: astore 10
    //   224: goto +138 -> 362
    //   227: astore 11
    //   229: aload 12
    //   231: astore 10
    //   233: aload 10
    //   235: astore 9
    //   237: new 138	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   244: astore 12
    //   246: aload 10
    //   248: astore 9
    //   250: aload 12
    //   252: ldc_w 256
    //   255: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 10
    //   261: astore 9
    //   263: aload 12
    //   265: iload_1
    //   266: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 10
    //   272: astore 9
    //   274: aload 12
    //   276: ldc_w 258
    //   279: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 10
    //   285: astore 9
    //   287: aload 12
    //   289: aload 11
    //   291: invokevirtual 148	java/lang/Exception:toString	()Ljava/lang/String;
    //   294: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 10
    //   300: astore 9
    //   302: ldc 150
    //   304: iconst_1
    //   305: aload 12
    //   307: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 156	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload 10
    //   315: ifnull +18 -> 333
    //   318: aload 10
    //   320: invokevirtual 133	java/io/BufferedReader:close	()V
    //   323: goto +10 -> 333
    //   326: astore 9
    //   328: aload 9
    //   330: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   333: lconst_0
    //   334: lstore_3
    //   335: iconst_1
    //   336: istore_2
    //   337: lload 7
    //   339: lstore 5
    //   341: lload_3
    //   342: lload 7
    //   344: lcmp
    //   345: ifle +6 -> 351
    //   348: lload_3
    //   349: lstore 5
    //   351: iload_1
    //   352: iconst_1
    //   353: iadd
    //   354: istore_1
    //   355: lload 5
    //   357: lstore 7
    //   359: goto -322 -> 37
    //   362: aload 9
    //   364: ifnull +18 -> 382
    //   367: aload 9
    //   369: invokevirtual 133	java/io/BufferedReader:close	()V
    //   372: goto +10 -> 382
    //   375: astore 9
    //   377: aload 9
    //   379: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   382: aload 10
    //   384: athrow
    //   385: iload_2
    //   386: ifeq +18 -> 404
    //   389: invokestatic 260	com/tencent/mobileqq/statistics/cpu/CPUReport:a	()J
    //   392: lstore 5
    //   394: lload 5
    //   396: lload_3
    //   397: lcmp
    //   398: ifle +6 -> 404
    //   401: lload 5
    //   403: lreturn
    //   404: lload 7
    //   406: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	this	CPUReport
    //   29	326	1	m	int
    //   36	350	2	n	int
    //   31	366	3	l1	long
    //   155	247	5	l2	long
    //   33	372	7	l3	long
    //   57	117	9	localObject1	Object
    //   191	3	9	localIOException1	java.io.IOException
    //   208	93	9	localObject2	Object
    //   326	42	9	localIOException2	java.io.IOException
    //   375	3	9	localIOException3	java.io.IOException
    //   49	164	10	localObject3	Object
    //   222	1	10	localObject4	Object
    //   231	152	10	localObject5	Object
    //   53	83	11	str	String
    //   204	7	11	localObject6	Object
    //   217	1	11	localException1	Exception
    //   227	63	11	localException2	Exception
    //   46	260	12	localObject7	Object
    //   66	50	13	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   180	185	191	java/io/IOException
    //   128	135	204	finally
    //   139	154	204	finally
    //   165	180	204	finally
    //   128	135	217	java/lang/Exception
    //   139	154	217	java/lang/Exception
    //   165	180	217	java/lang/Exception
    //   59	68	222	finally
    //   72	80	222	finally
    //   84	91	222	finally
    //   95	103	222	finally
    //   107	128	222	finally
    //   237	246	222	finally
    //   250	259	222	finally
    //   263	270	222	finally
    //   274	283	222	finally
    //   287	298	222	finally
    //   302	313	222	finally
    //   59	68	227	java/lang/Exception
    //   72	80	227	java/lang/Exception
    //   84	91	227	java/lang/Exception
    //   95	103	227	java/lang/Exception
    //   107	128	227	java/lang/Exception
    //   318	323	326	java/io/IOException
    //   367	372	375	java/io/IOException
  }
  
  public static boolean b()
  {
    int i2 = a(Build.CPU_ABI);
    if (Build.VERSION.SDK_INT >= 21)
    {
      String[] arrayOfString = Build.SUPPORTED_ABIS;
      if (arrayOfString != null)
      {
        int i3 = arrayOfString.length;
        int i1 = 0;
        m = 0;
        for (;;)
        {
          n = m;
          if (i1 >= i3) {
            break;
          }
          m |= a(arrayOfString[i1]);
          i1 += 1;
        }
      }
    }
    int n = 0;
    int m = jdField_d_of_type_Int;
    if (i2 != m)
    {
      if ((n & m) == m) {
        return false;
      }
      m = jdField_e_of_type_Int;
      if (i2 != m)
      {
        if ((n & m) == m) {
          return false;
        }
        m = jdField_c_of_type_Int;
        if (i2 != m)
        {
          if ((n & m) == m) {
            return true;
          }
          m = jdField_b_of_type_Int;
          if (i2 != m)
          {
            if ((n & m) == m) {
              return true;
            }
            m = jdField_a_of_type_Int;
            if (i2 != m) {
              return (n & m) == m;
            }
          }
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean c()
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
      int n = localObject.length;
      int m = 0;
      while (m < n)
      {
        String str = localObject[m];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(File.separator);
        localStringBuilder.append("libOpenCL.so");
        if (new File(localStringBuilder.toString()).exists()) {
          return true;
        }
        m += 1;
      }
    }
    return false;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(1024);
    this.g = a(Build.CPU_ABI);
    this.h = a(Build.CPU_ABI2);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = Build.SUPPORTED_ABIS;
      if (localObject != null)
      {
        m = 0;
        while (m < localObject.length)
        {
          this.i = (a(localObject[m]) | this.i);
          m += 1;
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
    this.jdField_a_of_type_JavaLangString = ((String)localObject);
    if (Build.MODEL == null) {
      localObject = str;
    } else {
      localObject = Build.BOARD;
    }
    this.jdField_b_of_type_JavaLangString = ((String)localObject);
    int m = this.g;
    int i1 = jdField_d_of_type_Int;
    if (m != i1)
    {
      n = this.i;
      if ((n & i1) != i1)
      {
        i1 = jdField_c_of_type_Int;
        if ((m != i1) && ((n & i1) != i1))
        {
          i1 = jdField_b_of_type_Int;
          if ((m != i1) && ((n & i1) != i1))
          {
            i1 = jdField_a_of_type_Int;
            if ((m != i1) && ((n & i1) != i1))
            {
              i1 = jdField_e_of_type_Int;
              if ((m != i1) && ((n & i1) != i1)) {
                break label325;
              }
              this.jdField_f_of_type_Int = 6;
              break label325;
            }
            this.jdField_f_of_type_Int = 1;
            break label325;
          }
          this.jdField_f_of_type_Int = 4;
          break label325;
        }
        this.jdField_f_of_type_Int = 5;
        break label325;
      }
    }
    this.jdField_f_of_type_Int = 7;
    int n = this.h;
    m = jdField_b_of_type_Int;
    if ((n != m) && (n != jdField_a_of_type_Int))
    {
      n = this.i;
      if (((n & m) != m) && ((n & m) != m)) {}
    }
    else
    {
      this.jdField_f_of_type_Int = 8;
    }
    label325:
    a();
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getCpuArch not found in android.Build infoArchId:");
        ((StringBuilder)localObject).append(this.j);
        ((StringBuilder)localObject).append(" vendorId:");
        ((StringBuilder)localObject).append(this.jdField_e_of_type_JavaLangString);
        QLog.i("CPUReport", 2, ((StringBuilder)localObject).toString());
      }
      if (this.jdField_f_of_type_Int == 0)
      {
        m = this.j;
        if (m != 5)
        {
          if (m != 6)
          {
            if (m != 7)
            {
              if (m != 8)
              {
                localObject = this.jdField_e_of_type_JavaLangString;
                if ((localObject != null) && ((((String)localObject).equalsIgnoreCase("AuthenticAMD")) || (this.jdField_e_of_type_JavaLangString.equalsIgnoreCase("GenuineIntel")))) {
                  this.jdField_f_of_type_Int = 7;
                }
              }
              else
              {
                this.jdField_f_of_type_Int = 5;
              }
            }
            else {
              this.jdField_f_of_type_Int = 4;
            }
          }
          else {
            this.jdField_f_of_type_Int = 2;
          }
        }
        else {
          this.jdField_f_of_type_Int = 1;
        }
      }
      if ((this.jdField_f_of_type_Int == 4) && (this.jdField_c_of_type_JavaLangString.contains("aarch64"))) {
        this.jdField_f_of_type_Int = 5;
      } else if ((this.jdField_f_of_type_Int == 1) && (this.jdField_c_of_type_JavaLangString.contains("armv6"))) {
        this.jdField_f_of_type_Int = 2;
      }
      if ((this.jdField_f_of_type_Int == 4) && (!this.jdField_d_of_type_JavaLangString.contains("neon")))
      {
        this.jdField_f_of_type_Int = 3;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getCpuArch armv7a neon not supported ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
          QLog.i("CPUReport", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if ((this.jdField_f_of_type_Int == 8) && (this.jdField_d_of_type_JavaLangString.contains("neon")))
      {
        this.jdField_f_of_type_Int = 9;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getCpuArch x86 neon supported ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
          QLog.i("CPUReport", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("cpuArch");
      localStringBuilder.append("=");
      localStringBuilder.append(this.jdField_f_of_type_Int);
      localStringBuilder.append('\n');
      localStringBuilder.append("CPU_ABI");
      localStringBuilder.append("=");
      localStringBuilder.append(this.g);
      localStringBuilder.append('\n');
      localStringBuilder.append("CPU_ABI2");
      localStringBuilder.append("=");
      localStringBuilder.append(this.h);
      localStringBuilder.append('\n');
      localStringBuilder.append("SUPPORTED_ABIS");
      localStringBuilder.append("=");
      localStringBuilder.append(this.i);
      localStringBuilder.append('\n');
      localStringBuilder.append("brand");
      localStringBuilder.append("=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append('\n');
      localStringBuilder.append("model");
      localStringBuilder.append("=");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append('\n');
      localStringBuilder.append("infoProcessorName");
      localStringBuilder.append("=");
      localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append('\n');
      localStringBuilder.append("infoArchitectureId");
      localStringBuilder.append("=");
      localStringBuilder.append(this.j);
      localStringBuilder.append('\n');
      localStringBuilder.append("infoVendorId");
      localStringBuilder.append("=");
      localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
      localStringBuilder.append('\n');
      localStringBuilder.append("infoHardware");
      localStringBuilder.append("=");
      localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
      localStringBuilder.append('\n');
      localStringBuilder.append("infoCoreNum");
      localStringBuilder.append("=");
      localStringBuilder.append(this.k);
      localStringBuilder.append('\n');
      localStringBuilder.append("infoMaxCoreFreq");
      localStringBuilder.append("=");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append('\n');
      localStringBuilder.append("doneReadCpuInfo");
      localStringBuilder.append("=");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append('\n');
      QLog.i("CPUReport", 2, localStringBuilder.toString());
    }
    return localStringBuilder.toString();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      a();
      this.jdField_a_of_type_Boolean = true;
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
    localHashMap.put("cpuArch", String.valueOf(this.jdField_f_of_type_Int));
    localHashMap.put("CPU_ABI", String.valueOf(this.g));
    localHashMap.put("CPU_ABI2", String.valueOf(this.h));
    localHashMap.put("SUPPORTED_ABIS", String.valueOf(this.i));
    localHashMap.put("brand", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("model", this.jdField_b_of_type_JavaLangString);
    localHashMap.put("infoProcessorName", this.jdField_c_of_type_JavaLangString);
    localHashMap.put("infoArchitectureId", String.valueOf(this.j));
    localHashMap.put("infoVendorId", this.jdField_e_of_type_JavaLangString);
    localHashMap.put("infoHardware", this.jdField_f_of_type_JavaLangString);
    localHashMap.put("infoCoreNum", String.valueOf(this.k));
    localHashMap.put("infoMaxCoreFreq", Long.toString(this.jdField_a_of_type_Long));
    boolean bool = this.jdField_b_of_type_Boolean;
    String str = "1";
    Object localObject;
    if (bool) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("doneReadCpuInfo", localObject);
    if (this.jdField_a_of_type_Boolean) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("doneGetField", localObject);
    if (c()) {
      localObject = str;
    } else {
      localObject = "0";
    }
    localHashMap.put("hasOpenCLSo", localObject);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "CPUREPORT_730", true, 0L, 0L, localHashMap, "");
  }
  
  public final boolean a()
  {
    int m = this.jdField_f_of_type_Int;
    return (m == 5) || (m == 4) || (m == 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.cpu.CPUReport
 * JD-Core Version:    0.7.0.1
 */