package com.tencent.mobileqq.qqaudio;

import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class QQAudioSystemInfo
{
  public static int a = 5;
  public static long a = 0L;
  public static String a = "";
  public static boolean a = false;
  public static int b = 1;
  public static long b = 0L;
  public static String b = "";
  public static boolean b = false;
  public static int c = 2;
  static long c = 0L;
  public static String c;
  public static boolean c = true;
  public static int d = 1;
  public static String d;
  public static boolean d = true;
  private static String e;
  public static boolean e = false;
  static int i;
  public int e;
  public int f = 480;
  public int g = 320;
  public int h = 240;
  
  static
  {
    a();
    i = 0;
    jdField_c_of_type_Long = 0L;
  }
  
  public QQAudioSystemInfo()
  {
    this.jdField_e_of_type_Int = 320;
  }
  
  protected static float a(float paramFloat, String paramString)
  {
    int j = paramString.indexOf(':');
    float f1 = paramFloat;
    if (j > 1) {
      paramString = paramString.substring(j + 1, paramString.length()).trim();
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
  
  static int a()
  {
    try
    {
      int j = new File("/sys/devices/system/cpu/").listFiles(new QQAudioSystemInfo.1CpuFilter()).length;
      return j;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    return 0;
  }
  
  /* Error */
  static long a()
  {
    // Byte code:
    //   0: getstatic 93	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_b_of_type_Int	I
    //   3: iconst_1
    //   4: if_icmpge +22 -> 26
    //   7: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +11 -> 21
    //   13: ldc 101
    //   15: iconst_2
    //   16: ldc 103
    //   18: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: bipush 8
    //   23: putstatic 93	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_b_of_type_Int	I
    //   26: iconst_0
    //   27: istore_0
    //   28: lconst_0
    //   29: lstore_2
    //   30: lload_2
    //   31: lstore 4
    //   33: iconst_0
    //   34: istore_1
    //   35: iload_0
    //   36: getstatic 93	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_b_of_type_Int	I
    //   39: if_icmpge +413 -> 452
    //   42: aconst_null
    //   43: astore 11
    //   45: aconst_null
    //   46: astore 9
    //   48: ldc 13
    //   50: astore 10
    //   52: aload 9
    //   54: astore 8
    //   56: new 108	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   63: astore 12
    //   65: aload 9
    //   67: astore 8
    //   69: aload 12
    //   71: ldc 111
    //   73: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 9
    //   79: astore 8
    //   81: aload 12
    //   83: iload_0
    //   84: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 9
    //   90: astore 8
    //   92: aload 12
    //   94: ldc 120
    //   96: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 9
    //   102: astore 8
    //   104: new 122	java/io/BufferedReader
    //   107: dup
    //   108: new 124	java/io/FileReader
    //   111: dup
    //   112: aload 12
    //   114: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokespecial 128	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   120: invokespecial 131	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   123: astore 9
    //   125: aload 9
    //   127: invokevirtual 134	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   130: astore 11
    //   132: aload 10
    //   134: astore 8
    //   136: aload 11
    //   138: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   141: ifne +10 -> 151
    //   144: aload 11
    //   146: invokevirtual 66	java/lang/String:trim	()Ljava/lang/String;
    //   149: astore 8
    //   151: lload_2
    //   152: lstore 6
    //   154: aload 8
    //   156: ifnull +21 -> 177
    //   159: lload_2
    //   160: lstore 6
    //   162: aload 8
    //   164: invokevirtual 58	java/lang/String:length	()I
    //   167: ifle +10 -> 177
    //   170: aload 8
    //   172: invokestatic 146	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   175: lstore 6
    //   177: aload 9
    //   179: invokevirtual 149	java/io/BufferedReader:close	()V
    //   182: lload 6
    //   184: lstore_2
    //   185: goto +147 -> 332
    //   188: astore 8
    //   190: aload 8
    //   192: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   195: lload 6
    //   197: lstore_2
    //   198: goto +134 -> 332
    //   201: astore 10
    //   203: aload 9
    //   205: astore 8
    //   207: aload 10
    //   209: astore 9
    //   211: goto +218 -> 429
    //   214: astore 10
    //   216: goto +14 -> 230
    //   219: astore 9
    //   221: goto +208 -> 429
    //   224: astore 10
    //   226: aload 11
    //   228: astore 9
    //   230: aload 9
    //   232: astore 8
    //   234: new 108	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   241: astore 11
    //   243: aload 9
    //   245: astore 8
    //   247: aload 11
    //   249: ldc 154
    //   251: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 9
    //   257: astore 8
    //   259: aload 11
    //   261: iload_0
    //   262: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 9
    //   268: astore 8
    //   270: aload 11
    //   272: ldc 156
    //   274: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload 9
    //   280: astore 8
    //   282: aload 11
    //   284: aload 10
    //   286: invokevirtual 157	java/lang/Exception:toString	()Ljava/lang/String;
    //   289: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 9
    //   295: astore 8
    //   297: ldc 101
    //   299: iconst_2
    //   300: aload 11
    //   302: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 159	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: aload 9
    //   310: ifnull +18 -> 328
    //   313: aload 9
    //   315: invokevirtual 149	java/io/BufferedReader:close	()V
    //   318: goto +10 -> 328
    //   321: astore 8
    //   323: aload 8
    //   325: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   328: lconst_0
    //   329: lstore_2
    //   330: iconst_1
    //   331: istore_1
    //   332: lload 4
    //   334: lstore 6
    //   336: lload_2
    //   337: lload 4
    //   339: lcmp
    //   340: ifle +6 -> 346
    //   343: lload_2
    //   344: lstore 6
    //   346: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq +69 -> 418
    //   352: new 108	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   359: astore 8
    //   361: aload 8
    //   363: ldc 161
    //   365: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 8
    //   371: iload_0
    //   372: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 8
    //   378: ldc 163
    //   380: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 8
    //   386: lload_2
    //   387: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload 8
    //   393: ldc 168
    //   395: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 8
    //   401: lload 6
    //   403: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: ldc 101
    //   409: iconst_2
    //   410: aload 8
    //   412: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: iload_0
    //   419: iconst_1
    //   420: iadd
    //   421: istore_0
    //   422: lload 6
    //   424: lstore 4
    //   426: goto -391 -> 35
    //   429: aload 8
    //   431: ifnull +18 -> 449
    //   434: aload 8
    //   436: invokevirtual 149	java/io/BufferedReader:close	()V
    //   439: goto +10 -> 449
    //   442: astore 8
    //   444: aload 8
    //   446: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   449: aload 9
    //   451: athrow
    //   452: iload_1
    //   453: ifeq +22 -> 475
    //   456: invokestatic 170	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:b	()J
    //   459: lstore 6
    //   461: lload 6
    //   463: lload_2
    //   464: lcmp
    //   465: ifle +10 -> 475
    //   468: lload 6
    //   470: lstore 4
    //   472: goto +3 -> 475
    //   475: new 108	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   482: astore 8
    //   484: aload 8
    //   486: ldc 172
    //   488: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 8
    //   494: lload 4
    //   496: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: ldc 101
    //   502: iconst_2
    //   503: aload 8
    //   505: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   511: lload 4
    //   513: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   27	395	0	j	int
    //   34	419	1	k	int
    //   29	435	2	l1	long
    //   31	481	4	l2	long
    //   152	317	6	l3	long
    //   54	117	8	localObject1	Object
    //   188	3	8	localIOException1	IOException
    //   205	91	8	localObject2	Object
    //   321	3	8	localIOException2	IOException
    //   359	76	8	localStringBuilder1	StringBuilder
    //   442	3	8	localIOException3	IOException
    //   482	22	8	localStringBuilder2	StringBuilder
    //   46	164	9	localObject3	Object
    //   219	1	9	localObject4	Object
    //   228	222	9	localObject5	Object
    //   50	83	10	str	String
    //   201	7	10	localObject6	Object
    //   214	1	10	localException1	Exception
    //   224	61	10	localException2	Exception
    //   43	258	11	localObject7	Object
    //   63	50	12	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   177	182	188	java/io/IOException
    //   125	132	201	finally
    //   136	151	201	finally
    //   162	177	201	finally
    //   125	132	214	java/lang/Exception
    //   136	151	214	java/lang/Exception
    //   162	177	214	java/lang/Exception
    //   56	65	219	finally
    //   69	77	219	finally
    //   81	88	219	finally
    //   92	100	219	finally
    //   104	125	219	finally
    //   234	243	219	finally
    //   247	255	219	finally
    //   259	266	219	finally
    //   270	278	219	finally
    //   282	293	219	finally
    //   297	308	219	finally
    //   56	65	224	java/lang/Exception
    //   69	77	224	java/lang/Exception
    //   81	88	224	java/lang/Exception
    //   92	100	224	java/lang/Exception
    //   104	125	224	java/lang/Exception
    //   313	318	321	java/io/IOException
    //   434	439	442	java/io/IOException
  }
  
  protected static long a(long paramLong, String paramString)
  {
    int j = paramString.indexOf(':');
    long l1 = paramLong;
    if (j > 1) {
      paramString = paramString.substring(j + 1, paramString.length()).trim();
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
    //   0: getstatic 177	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Boolean	Z
    //   3: ifne +526 -> 529
    //   6: ldc2_w 178
    //   9: lstore_3
    //   10: ldc 180
    //   12: fstore_0
    //   13: new 108	java/lang/StringBuilder
    //   16: dup
    //   17: sipush 1024
    //   20: invokespecial 183	java/lang/StringBuilder:<init>	(I)V
    //   23: astore 9
    //   25: new 122	java/io/BufferedReader
    //   28: dup
    //   29: new 124	java/io/FileReader
    //   32: dup
    //   33: ldc 185
    //   35: invokespecial 128	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   38: invokespecial 131	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore 8
    //   43: fload_0
    //   44: fstore_1
    //   45: lload_3
    //   46: lstore 5
    //   48: aload 8
    //   50: invokevirtual 134	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore 10
    //   55: aload 10
    //   57: ifnonnull +15 -> 72
    //   60: iconst_1
    //   61: putstatic 177	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Boolean	Z
    //   64: lload 5
    //   66: lstore_3
    //   67: fload_1
    //   68: fstore_0
    //   69: goto +448 -> 517
    //   72: aload 10
    //   74: ldc 187
    //   76: invokevirtual 191	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   79: ifeq +16 -> 95
    //   82: aload 10
    //   84: invokestatic 193	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:a	(Ljava/lang/String;)V
    //   87: lload 5
    //   89: lstore_3
    //   90: fload_1
    //   91: fstore_0
    //   92: goto -49 -> 43
    //   95: aload 10
    //   97: ldc 195
    //   99: invokevirtual 191	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   102: ifeq +18 -> 120
    //   105: aload 9
    //   107: aload 10
    //   109: invokestatic 198	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:a	(Ljava/lang/StringBuilder;Ljava/lang/String;)V
    //   112: lload 5
    //   114: lstore_3
    //   115: fload_1
    //   116: fstore_0
    //   117: goto -74 -> 43
    //   120: aload 10
    //   122: ldc 200
    //   124: invokevirtual 191	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   127: ifne +354 -> 481
    //   130: aload 10
    //   132: ldc 202
    //   134: invokevirtual 191	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   137: istore 7
    //   139: iload 7
    //   141: ifeq +95 -> 236
    //   144: aload 10
    //   146: bipush 58
    //   148: invokevirtual 54	java/lang/String:indexOf	(I)I
    //   151: istore_2
    //   152: iload_2
    //   153: iconst_1
    //   154: if_icmple +22 -> 176
    //   157: aload 10
    //   159: iload_2
    //   160: iconst_1
    //   161: iadd
    //   162: aload 10
    //   164: invokevirtual 58	java/lang/String:length	()I
    //   167: invokevirtual 62	java/lang/String:substring	(II)Ljava/lang/String;
    //   170: invokevirtual 66	java/lang/String:trim	()Ljava/lang/String;
    //   173: putstatic 204	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   176: lload 5
    //   178: lstore_3
    //   179: fload_1
    //   180: fstore_0
    //   181: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   184: ifeq -141 -> 43
    //   187: aload 9
    //   189: ldc 206
    //   191: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 9
    //   197: getstatic 204	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   200: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 9
    //   206: ldc 208
    //   208: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 9
    //   214: aload 10
    //   216: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 9
    //   222: ldc 210
    //   224: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: lload 5
    //   230: lstore_3
    //   231: fload_1
    //   232: fstore_0
    //   233: goto -190 -> 43
    //   236: aload 10
    //   238: ldc 212
    //   240: invokevirtual 191	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   243: ifeq +95 -> 338
    //   246: aload 10
    //   248: bipush 58
    //   250: invokevirtual 54	java/lang/String:indexOf	(I)I
    //   253: istore_2
    //   254: iload_2
    //   255: iconst_1
    //   256: if_icmple +22 -> 278
    //   259: aload 10
    //   261: iload_2
    //   262: iconst_1
    //   263: iadd
    //   264: aload 10
    //   266: invokevirtual 58	java/lang/String:length	()I
    //   269: invokevirtual 62	java/lang/String:substring	(II)Ljava/lang/String;
    //   272: invokevirtual 66	java/lang/String:trim	()Ljava/lang/String;
    //   275: putstatic 214	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   278: lload 5
    //   280: lstore_3
    //   281: fload_1
    //   282: fstore_0
    //   283: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq -243 -> 43
    //   289: aload 9
    //   291: ldc 216
    //   293: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload 9
    //   299: getstatic 214	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   302: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 9
    //   308: ldc 208
    //   310: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 9
    //   316: aload 10
    //   318: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 9
    //   324: ldc 210
    //   326: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: lload 5
    //   332: lstore_3
    //   333: fload_1
    //   334: fstore_0
    //   335: goto -292 -> 43
    //   338: aload 10
    //   340: ldc 187
    //   342: invokevirtual 191	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   345: ifeq +85 -> 430
    //   348: aload 10
    //   350: invokevirtual 66	java/lang/String:trim	()Ljava/lang/String;
    //   353: putstatic 218	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   356: aload 10
    //   358: ldc 220
    //   360: invokevirtual 223	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   363: ifeq +7 -> 370
    //   366: iconst_1
    //   367: putstatic 225	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_e_of_type_Boolean	Z
    //   370: lload 5
    //   372: lstore_3
    //   373: fload_1
    //   374: fstore_0
    //   375: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq -335 -> 43
    //   381: aload 9
    //   383: ldc 227
    //   385: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 9
    //   391: getstatic 225	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_e_of_type_Boolean	Z
    //   394: invokevirtual 230	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 9
    //   400: ldc 208
    //   402: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 9
    //   408: aload 10
    //   410: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 9
    //   416: ldc 210
    //   418: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: lload 5
    //   424: lstore_3
    //   425: fload_1
    //   426: fstore_0
    //   427: goto -384 -> 43
    //   430: aload 10
    //   432: ldc 232
    //   434: invokevirtual 191	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   437: ifeq +16 -> 453
    //   440: lload 5
    //   442: aload 10
    //   444: invokestatic 234	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:a	(JLjava/lang/String;)J
    //   447: lstore_3
    //   448: fload_1
    //   449: fstore_0
    //   450: goto -407 -> 43
    //   453: lload 5
    //   455: lstore_3
    //   456: fload_1
    //   457: fstore_0
    //   458: aload 10
    //   460: ldc 236
    //   462: invokevirtual 191	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   465: ifeq -422 -> 43
    //   468: fload_1
    //   469: aload 10
    //   471: invokestatic 238	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:a	(FLjava/lang/String;)F
    //   474: fstore_0
    //   475: lload 5
    //   477: lstore_3
    //   478: goto -435 -> 43
    //   481: aload 9
    //   483: aload 10
    //   485: invokestatic 240	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:b	(Ljava/lang/StringBuilder;Ljava/lang/String;)V
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
    //   508: invokestatic 243	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:a	(Ljava/io/BufferedReader;)V
    //   511: aload 9
    //   513: athrow
    //   514: aconst_null
    //   515: astore 8
    //   517: aload 8
    //   519: invokestatic 243	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:a	(Ljava/io/BufferedReader;)V
    //   522: lload_3
    //   523: fload_0
    //   524: aload 9
    //   526: invokestatic 246	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:a	(JFLjava/lang/StringBuilder;)V
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
    //   151	113	2	j	int
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
    int j = a();
    if (j > 0)
    {
      jdField_b_of_type_Int = j;
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("[CpuInfo] mCoreNumber=");
        paramStringBuilder.append(jdField_b_of_type_Int);
        paramStringBuilder.append("\n");
      }
    }
    else if (paramLong > 0L)
    {
      jdField_b_of_type_Int = (int)paramLong;
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("[CpuInfo] mCoreNumber(bogoCoreNum)=");
        paramStringBuilder.append(jdField_b_of_type_Int);
        paramStringBuilder.append("\n");
      }
    }
    paramLong = a();
    if (paramLong > 0L)
    {
      jdField_a_of_type_Long = paramLong;
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("[CpuInfo] mMaxCpuFreq=");
        paramStringBuilder.append(jdField_a_of_type_Long);
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
        jdField_a_of_type_Long = (d1 * 1.2D * 1000.0D);
      }
      else if (paramFloat > 2000.0F)
      {
        d1 = paramFloat;
        Double.isNaN(d1);
        jdField_a_of_type_Long = (d1 / 1.8D * 1000.0D);
      }
      else
      {
        jdField_a_of_type_Long = (paramFloat * 1000.0F);
      }
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("[CpuInfo] mMaxCpuFreq(bogoMIPS)=");
        paramStringBuilder.append(jdField_a_of_type_Long);
        paramStringBuilder.append("\n");
      }
    }
    if ((jdField_b_of_type_Int > 0) && (jdField_a_of_type_Long > 0L))
    {
      jdField_a_of_type_Boolean = true;
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("[CpuInfo] read cpu info fail because of coreNumber= ");
        paramStringBuilder.append(jdField_b_of_type_Int);
        paramStringBuilder.append(" or maxCpuFreq=");
        paramStringBuilder.append(jdField_a_of_type_Long);
        paramStringBuilder.append("\n");
      }
      jdField_a_of_type_Boolean = false;
    }
    jdField_d_of_type_Int = b();
    if (QLog.isColorLevel())
    {
      paramStringBuilder.append("[CpuInfo] Chip=");
      paramStringBuilder.append(jdField_d_of_type_Int);
      paramStringBuilder.append(", Video=");
      paramStringBuilder.append(jdField_d_of_type_Boolean);
      paramStringBuilder.append(", Audio=");
      paramStringBuilder.append(jdField_c_of_type_Boolean);
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
    int j = paramString.indexOf(':');
    if (j > 1) {
      jdField_e_of_type_JavaLangString = paramString.substring(j + 1, paramString.length()).trim().replace(" ", "");
    }
  }
  
  protected static void a(StringBuilder paramStringBuilder, String paramString)
  {
    int j = paramString.indexOf(':');
    if (j > 1)
    {
      jdField_a_of_type_JavaLangString = paramString.substring(j + 1, paramString.length());
      jdField_a_of_type_JavaLangString = jdField_a_of_type_JavaLangString.trim();
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("[CpuInfo] mProcessorName=");
        paramStringBuilder.append(jdField_a_of_type_JavaLangString);
        paramStringBuilder.append(" | ");
        paramStringBuilder.append(paramString);
        paramStringBuilder.append("\n");
      }
    }
  }
  
  static int b()
  {
    if (jdField_a_of_type_JavaLangString.contains("ARMv6")) {
      return 2;
    }
    if (Build.CPU_ABI.equalsIgnoreCase("armeabi-v7a")) {
      return 4;
    }
    if (Build.CPU_ABI.equalsIgnoreCase("armeabi")) {
      return 2;
    }
    int j = jdField_a_of_type_Int;
    int k = 7;
    if ((j == 7) && (jdField_b_of_type_JavaLangString.indexOf("neon") < 0))
    {
      long l = c();
      j = c();
      if ((l < 1100000L) || (j < 2)) {
        return 3;
      }
    }
    if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
      return 7;
    }
    j = jdField_a_of_type_Int;
    if (j != 5)
    {
      if (j != 6)
      {
        if (j != 7)
        {
          if (j != 8)
          {
            String str = jdField_c_of_type_JavaLangString;
            if (str != null)
            {
              j = k;
              if (!str.equalsIgnoreCase("AuthenticAMD"))
              {
                j = k;
                if (jdField_c_of_type_JavaLangString.equalsIgnoreCase("GenuineIntel")) {}
              }
            }
            else
            {
              j = 0;
            }
            return j;
          }
          return 5;
        }
        return 4;
      }
      return 2;
    }
    return 1;
  }
  
  /* Error */
  static long b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: lconst_0
    //   4: lstore_3
    //   5: new 122	java/io/BufferedReader
    //   8: dup
    //   9: new 124	java/io/FileReader
    //   12: dup
    //   13: ldc_w 342
    //   16: invokespecial 128	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   19: invokespecial 131	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   22: astore 8
    //   24: aload 7
    //   26: astore 9
    //   28: aload 8
    //   30: astore 7
    //   32: aload 8
    //   34: invokevirtual 134	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   37: astore 10
    //   39: aload 10
    //   41: ifnull +265 -> 306
    //   44: aload 10
    //   46: astore 7
    //   48: goto -24 -> 24
    //   51: aload 8
    //   53: astore 7
    //   55: aload 9
    //   57: bipush 9
    //   59: invokevirtual 54	java/lang/String:indexOf	(I)I
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
    //   78: invokevirtual 62	java/lang/String:substring	(II)Ljava/lang/String;
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
    //   98: invokevirtual 58	java/lang/String:length	()I
    //   101: ifle +13 -> 114
    //   104: aload 8
    //   106: astore 7
    //   108: aload 9
    //   110: invokestatic 146	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   113: lstore_1
    //   114: lload_1
    //   115: lstore 5
    //   117: aload 8
    //   119: invokevirtual 149	java/io/BufferedReader:close	()V
    //   122: goto +107 -> 229
    //   125: astore 7
    //   127: aload 7
    //   129: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   132: lload 5
    //   134: lstore_1
    //   135: goto +94 -> 229
    //   138: astore 9
    //   140: goto +16 -> 156
    //   143: astore 7
    //   145: aconst_null
    //   146: astore 8
    //   148: goto +129 -> 277
    //   151: astore 9
    //   153: aconst_null
    //   154: astore 8
    //   156: aload 8
    //   158: astore 7
    //   160: new 108	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   167: astore 10
    //   169: aload 8
    //   171: astore 7
    //   173: aload 10
    //   175: ldc_w 344
    //   178: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 8
    //   184: astore 7
    //   186: aload 10
    //   188: aload 9
    //   190: invokevirtual 157	java/lang/Exception:toString	()Ljava/lang/String;
    //   193: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 8
    //   199: astore 7
    //   201: ldc 101
    //   203: iconst_2
    //   204: aload 10
    //   206: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 159	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: lload_3
    //   213: lstore_1
    //   214: aload 8
    //   216: ifnull +13 -> 229
    //   219: lload_3
    //   220: lstore 5
    //   222: aload 8
    //   224: invokevirtual 149	java/io/BufferedReader:close	()V
    //   227: lload_3
    //   228: lstore_1
    //   229: new 108	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   236: astore 7
    //   238: aload 7
    //   240: ldc_w 346
    //   243: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 7
    //   249: lload_1
    //   250: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: ldc 101
    //   256: iconst_2
    //   257: aload 7
    //   259: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: lload_1
    //   266: lreturn
    //   267: astore 9
    //   269: aload 7
    //   271: astore 8
    //   273: aload 9
    //   275: astore 7
    //   277: aload 8
    //   279: ifnull +18 -> 297
    //   282: aload 8
    //   284: invokevirtual 149	java/io/BufferedReader:close	()V
    //   287: goto +10 -> 297
    //   290: astore 8
    //   292: aload 8
    //   294: invokevirtual 152	java/io/IOException:printStackTrace	()V
    //   297: goto +6 -> 303
    //   300: aload 7
    //   302: athrow
    //   303: goto -3 -> 300
    //   306: aload 9
    //   308: ifnonnull -257 -> 51
    //   311: iconst_m1
    //   312: istore_0
    //   313: goto -250 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   62	251	0	j	int
    //   64	202	1	l1	long
    //   4	224	3	l2	long
    //   115	106	5	l3	long
    //   1	106	7	localObject1	Object
    //   125	3	7	localIOException1	IOException
    //   143	1	7	localObject2	Object
    //   158	143	7	localObject3	Object
    //   22	261	8	localObject4	Object
    //   290	3	8	localIOException2	IOException
    //   26	83	9	localObject5	Object
    //   138	1	9	localException1	Exception
    //   151	38	9	localException2	Exception
    //   267	40	9	localObject6	Object
    //   37	168	10	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   117	122	125	java/io/IOException
    //   222	227	125	java/io/IOException
    //   32	39	138	java/lang/Exception
    //   55	63	138	java/lang/Exception
    //   74	83	138	java/lang/Exception
    //   96	104	138	java/lang/Exception
    //   108	114	138	java/lang/Exception
    //   5	24	143	finally
    //   5	24	151	java/lang/Exception
    //   32	39	267	finally
    //   55	63	267	finally
    //   74	83	267	finally
    //   96	104	267	finally
    //   108	114	267	finally
    //   160	169	267	finally
    //   173	182	267	finally
    //   186	197	267	finally
    //   201	212	267	finally
    //   282	287	290	java/io/IOException
  }
  
  protected static void b(StringBuilder paramStringBuilder, String paramString)
  {
    int k = paramString.indexOf(':');
    int j = 1;
    if (k > 1)
    {
      String str = paramString.substring(k + 1, paramString.length()).trim();
      if ((str != null) && (str.length() > 0)) {
        if (str.equalsIgnoreCase("aarch64")) {
          jdField_a_of_type_Int = 8;
        } else {
          for (;;)
          {
            try
            {
              jdField_a_of_type_Int = (int)Long.parseLong(str);
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              continue;
            }
            if (j >= str.length()) {
              continue;
            }
            try
            {
              jdField_a_of_type_Int = (int)Long.parseLong(str.substring(0, str.length() - j));
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              continue;
            }
            j += 1;
          }
        }
      }
    }
    if (paramString.contains("5TE")) {
      jdField_a_of_type_Int = 5;
    }
    if (QLog.isColorLevel())
    {
      paramStringBuilder.append("[CpuInfo] mCpuArchitecture=");
      paramStringBuilder.append(jdField_a_of_type_Int);
      paramStringBuilder.append(" | ");
      paramStringBuilder.append(paramString);
      paramStringBuilder.append("\n");
    }
  }
  
  public static int c()
  {
    a();
    return jdField_b_of_type_Int;
  }
  
  public static long c()
  {
    
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMaxCpuFreq: ");
      localStringBuilder.append(Build.BRAND);
      localStringBuilder.append("|");
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append("|");
      localStringBuilder.append(jdField_a_of_type_Long);
      QLog.i("QQAudioSystemInfo", 2, localStringBuilder.toString());
    }
    return jdField_a_of_type_Long;
  }
  
  public static int d()
  {
    a();
    return jdField_d_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.QQAudioSystemInfo
 * JD-Core Version:    0.7.0.1
 */