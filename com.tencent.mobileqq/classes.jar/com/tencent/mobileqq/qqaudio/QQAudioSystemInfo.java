package com.tencent.mobileqq.qqaudio;

import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class QQAudioSystemInfo
{
  public static int a;
  public static long a;
  public static String a;
  public static boolean a;
  public static int b;
  public static long b;
  public static String b;
  public static boolean b;
  public static int c;
  static long c;
  public static String c;
  public static boolean c;
  public static int d;
  public static String d;
  public static boolean d;
  private static String e;
  public static boolean e;
  static int i;
  public int e;
  public int f = 480;
  public int g = 320;
  public int h = 240;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
    jdField_c_of_type_JavaLangString = null;
    jdField_d_of_type_JavaLangString = null;
    jdField_a_of_type_Int = 5;
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Int = 1;
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Long = 0L;
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 1;
    jdField_c_of_type_Boolean = true;
    jdField_d_of_type_Boolean = true;
    jdField_e_of_type_Boolean = false;
    a();
    i = 0;
    jdField_c_of_type_Long = 0L;
  }
  
  public QQAudioSystemInfo()
  {
    this.jdField_e_of_type_Int = 320;
  }
  
  static int a()
  {
    try
    {
      int j = new File("/sys/devices/system/cpu/").listFiles(new QQAudioSystemInfo.1CpuFilter()).length;
      return j;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  /* Error */
  static long a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: getstatic 35	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_b_of_type_Int	I
    //   5: iconst_1
    //   6: if_icmpge +22 -> 28
    //   9: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +11 -> 23
    //   15: ldc 97
    //   17: iconst_2
    //   18: ldc 99
    //   20: invokestatic 102	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: bipush 8
    //   25: putstatic 35	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_b_of_type_Int	I
    //   28: iconst_0
    //   29: istore_2
    //   30: lconst_0
    //   31: lstore 5
    //   33: lconst_0
    //   34: lstore_3
    //   35: iload_1
    //   36: getstatic 35	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_b_of_type_Int	I
    //   39: if_icmpge +313 -> 352
    //   42: aconst_null
    //   43: astore 12
    //   45: new 104	java/io/BufferedReader
    //   48: dup
    //   49: new 106	java/io/FileReader
    //   52: dup
    //   53: new 108	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   60: ldc 111
    //   62: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: iload_1
    //   66: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: ldc 120
    //   71: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokespecial 125	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   80: invokespecial 128	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   83: astore 11
    //   85: lload_3
    //   86: lstore 7
    //   88: aload 11
    //   90: ifnull +51 -> 141
    //   93: aload 11
    //   95: invokevirtual 131	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   98: astore 12
    //   100: aload 12
    //   102: invokestatic 137	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +335 -> 440
    //   108: aload 12
    //   110: invokevirtual 142	java/lang/String:trim	()Ljava/lang/String;
    //   113: astore 12
    //   115: lload_3
    //   116: lstore 7
    //   118: aload 12
    //   120: ifnull +21 -> 141
    //   123: lload_3
    //   124: lstore 7
    //   126: aload 12
    //   128: invokevirtual 145	java/lang/String:length	()I
    //   131: ifle +10 -> 141
    //   134: aload 12
    //   136: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   139: lstore 7
    //   141: iload_2
    //   142: istore_0
    //   143: lload 7
    //   145: lstore_3
    //   146: aload 11
    //   148: ifnull +13 -> 161
    //   151: aload 11
    //   153: invokevirtual 154	java/io/BufferedReader:close	()V
    //   156: lload 7
    //   158: lstore_3
    //   159: iload_2
    //   160: istore_0
    //   161: lload 5
    //   163: lstore 7
    //   165: lload_3
    //   166: lload 5
    //   168: lcmp
    //   169: ifle +6 -> 175
    //   172: lload_3
    //   173: lstore 7
    //   175: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +47 -> 225
    //   181: ldc 97
    //   183: iconst_2
    //   184: new 108	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   191: ldc 156
    //   193: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: iload_1
    //   197: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: ldc 158
    //   202: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: lload_3
    //   206: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   209: ldc 163
    //   211: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: lload 7
    //   216: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   219: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 102	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: iload_1
    //   226: iconst_1
    //   227: iadd
    //   228: istore_1
    //   229: iload_0
    //   230: istore_2
    //   231: lload 7
    //   233: lstore 5
    //   235: goto -200 -> 35
    //   238: astore 11
    //   240: aload 11
    //   242: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   245: iload_2
    //   246: istore_0
    //   247: lload 7
    //   249: lstore_3
    //   250: goto -89 -> 161
    //   253: astore 12
    //   255: aconst_null
    //   256: astore 11
    //   258: ldc 97
    //   260: iconst_2
    //   261: new 108	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   268: ldc 168
    //   270: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: iload_1
    //   274: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: ldc 170
    //   279: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload 12
    //   284: invokevirtual 171	java/lang/Exception:toString	()Ljava/lang/String;
    //   287: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: aload 11
    //   298: ifnull +8 -> 306
    //   301: aload 11
    //   303: invokevirtual 154	java/io/BufferedReader:close	()V
    //   306: iconst_1
    //   307: istore_0
    //   308: lconst_0
    //   309: lstore_3
    //   310: goto -149 -> 161
    //   313: astore 11
    //   315: aload 11
    //   317: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   320: iconst_1
    //   321: istore_0
    //   322: lconst_0
    //   323: lstore_3
    //   324: goto -163 -> 161
    //   327: astore 11
    //   329: aload 12
    //   331: ifnull +8 -> 339
    //   334: aload 12
    //   336: invokevirtual 154	java/io/BufferedReader:close	()V
    //   339: aload 11
    //   341: athrow
    //   342: astore 12
    //   344: aload 12
    //   346: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   349: goto -10 -> 339
    //   352: lload 5
    //   354: lstore 7
    //   356: iload_2
    //   357: ifeq +23 -> 380
    //   360: invokestatic 175	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:b	()J
    //   363: lstore 9
    //   365: lload 5
    //   367: lstore 7
    //   369: lload 9
    //   371: lload_3
    //   372: lcmp
    //   373: ifle +7 -> 380
    //   376: lload 9
    //   378: lstore 7
    //   380: ldc 97
    //   382: iconst_2
    //   383: new 108	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   390: ldc 177
    //   392: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: lload 7
    //   397: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   400: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 102	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: lload 7
    //   408: lreturn
    //   409: astore 13
    //   411: aload 11
    //   413: astore 12
    //   415: aload 13
    //   417: astore 11
    //   419: goto -90 -> 329
    //   422: astore 13
    //   424: aload 11
    //   426: astore 12
    //   428: aload 13
    //   430: astore 11
    //   432: goto -103 -> 329
    //   435: astore 12
    //   437: goto -179 -> 258
    //   440: ldc 21
    //   442: astore 12
    //   444: goto -329 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   142	180	0	j	int
    //   1	273	1	k	int
    //   29	328	2	m	int
    //   34	338	3	l1	long
    //   31	335	5	l2	long
    //   86	321	7	l3	long
    //   363	14	9	l4	long
    //   83	69	11	localBufferedReader	java.io.BufferedReader
    //   238	3	11	localIOException1	java.io.IOException
    //   256	46	11	localObject1	Object
    //   313	3	11	localIOException2	java.io.IOException
    //   327	85	11	localObject2	Object
    //   417	14	11	localObject3	Object
    //   43	92	12	str1	String
    //   253	82	12	localException1	Exception
    //   342	3	12	localIOException3	java.io.IOException
    //   413	14	12	localObject4	Object
    //   435	1	12	localException2	Exception
    //   442	1	12	str2	String
    //   409	7	13	localObject5	Object
    //   422	7	13	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   151	156	238	java/io/IOException
    //   45	85	253	java/lang/Exception
    //   301	306	313	java/io/IOException
    //   45	85	327	finally
    //   334	339	342	java/io/IOException
    //   93	115	409	finally
    //   126	141	409	finally
    //   258	296	422	finally
    //   93	115	435	java/lang/Exception
    //   126	141	435	java/lang/Exception
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: getstatic 37	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Boolean	Z
    //   3: ifne +291 -> 294
    //   6: aconst_null
    //   7: astore 9
    //   9: ldc2_w 182
    //   12: lstore 4
    //   14: ldc 184
    //   16: fstore_0
    //   17: new 108	java/lang/StringBuilder
    //   20: dup
    //   21: sipush 1024
    //   24: invokespecial 187	java/lang/StringBuilder:<init>	(I)V
    //   27: astore 10
    //   29: new 104	java/io/BufferedReader
    //   32: dup
    //   33: new 106	java/io/FileReader
    //   36: dup
    //   37: ldc 189
    //   39: invokespecial 125	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   42: invokespecial 128	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore 8
    //   47: aload 8
    //   49: invokevirtual 131	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore 9
    //   54: aload 9
    //   56: ifnonnull +239 -> 295
    //   59: iconst_1
    //   60: putstatic 37	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Boolean	Z
    //   63: lload 4
    //   65: lstore 6
    //   67: fload_0
    //   68: fstore_1
    //   69: aload 8
    //   71: ifnull +14 -> 85
    //   74: aload 8
    //   76: invokevirtual 154	java/io/BufferedReader:close	()V
    //   79: fload_0
    //   80: fstore_1
    //   81: lload 4
    //   83: lstore 6
    //   85: invokestatic 191	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:a	()I
    //   88: istore_2
    //   89: iload_2
    //   90: ifle +1129 -> 1219
    //   93: iload_2
    //   94: putstatic 35	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_b_of_type_Int	I
    //   97: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +28 -> 128
    //   103: aload 10
    //   105: ldc 193
    //   107: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 10
    //   113: getstatic 35	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_b_of_type_Int	I
    //   116: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 10
    //   122: ldc 195
    //   124: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: invokestatic 197	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:a	()J
    //   131: lstore 4
    //   133: lload 4
    //   135: lconst_0
    //   136: lcmp
    //   137: ifle +1130 -> 1267
    //   140: lload 4
    //   142: putstatic 33	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Long	J
    //   145: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +28 -> 176
    //   151: aload 10
    //   153: ldc 199
    //   155: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 10
    //   161: getstatic 33	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Long	J
    //   164: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 10
    //   170: ldc 195
    //   172: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: getstatic 35	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_b_of_type_Int	I
    //   179: ifle +1188 -> 1367
    //   182: getstatic 33	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Long	J
    //   185: lconst_0
    //   186: lcmp
    //   187: ifle +1180 -> 1367
    //   190: iconst_1
    //   191: putstatic 37	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Boolean	Z
    //   194: invokestatic 201	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:b	()I
    //   197: putstatic 45	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_d_of_type_Int	I
    //   200: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   203: ifeq +91 -> 294
    //   206: aload 10
    //   208: ldc 203
    //   210: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 10
    //   216: getstatic 45	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_d_of_type_Int	I
    //   219: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 10
    //   225: ldc 205
    //   227: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 10
    //   233: getstatic 49	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_d_of_type_Boolean	Z
    //   236: invokevirtual 208	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 10
    //   242: ldc 210
    //   244: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload 10
    //   250: getstatic 47	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_c_of_type_Boolean	Z
    //   253: invokevirtual 208	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 10
    //   259: ldc 195
    //   261: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: ldc 97
    //   267: iconst_2
    //   268: new 108	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   275: ldc 212
    //   277: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 10
    //   282: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 102	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: return
    //   295: aload 9
    //   297: ldc 214
    //   299: invokevirtual 218	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   302: ifeq +88 -> 390
    //   305: aload 9
    //   307: bipush 58
    //   309: invokevirtual 222	java/lang/String:indexOf	(I)I
    //   312: istore_2
    //   313: iload_2
    //   314: iconst_1
    //   315: if_icmple -268 -> 47
    //   318: aload 9
    //   320: iload_2
    //   321: iconst_1
    //   322: iadd
    //   323: aload 9
    //   325: invokevirtual 145	java/lang/String:length	()I
    //   328: invokevirtual 226	java/lang/String:substring	(II)Ljava/lang/String;
    //   331: invokevirtual 142	java/lang/String:trim	()Ljava/lang/String;
    //   334: ldc 228
    //   336: ldc 21
    //   338: invokevirtual 232	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   341: putstatic 234	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   344: goto -297 -> 47
    //   347: astore 9
    //   349: lload 4
    //   351: lstore 6
    //   353: fload_0
    //   354: fstore_1
    //   355: aload 8
    //   357: ifnull -272 -> 85
    //   360: aload 8
    //   362: invokevirtual 154	java/io/BufferedReader:close	()V
    //   365: lload 4
    //   367: lstore 6
    //   369: fload_0
    //   370: fstore_1
    //   371: goto -286 -> 85
    //   374: astore 8
    //   376: aload 8
    //   378: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   381: lload 4
    //   383: lstore 6
    //   385: fload_0
    //   386: fstore_1
    //   387: goto -302 -> 85
    //   390: aload 9
    //   392: ldc 236
    //   394: invokevirtual 218	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   397: ifeq +134 -> 531
    //   400: aload 9
    //   402: bipush 58
    //   404: invokevirtual 222	java/lang/String:indexOf	(I)I
    //   407: istore_2
    //   408: iload_2
    //   409: iconst_1
    //   410: if_icmple -363 -> 47
    //   413: aload 9
    //   415: iload_2
    //   416: iconst_1
    //   417: iadd
    //   418: aload 9
    //   420: invokevirtual 145	java/lang/String:length	()I
    //   423: invokevirtual 226	java/lang/String:substring	(II)Ljava/lang/String;
    //   426: putstatic 23	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   429: getstatic 23	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   432: invokevirtual 142	java/lang/String:trim	()Ljava/lang/String;
    //   435: putstatic 23	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   438: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   441: ifeq -394 -> 47
    //   444: aload 10
    //   446: ldc 238
    //   448: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload 10
    //   454: getstatic 23	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   457: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload 10
    //   463: ldc 240
    //   465: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 10
    //   471: aload 9
    //   473: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 10
    //   479: ldc 195
    //   481: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: goto -438 -> 47
    //   488: astore 9
    //   490: lload 4
    //   492: lstore 6
    //   494: fload_0
    //   495: fstore_1
    //   496: aload 8
    //   498: ifnull -413 -> 85
    //   501: aload 8
    //   503: invokevirtual 154	java/io/BufferedReader:close	()V
    //   506: lload 4
    //   508: lstore 6
    //   510: fload_0
    //   511: fstore_1
    //   512: goto -427 -> 85
    //   515: astore 8
    //   517: aload 8
    //   519: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   522: lload 4
    //   524: lstore 6
    //   526: fload_0
    //   527: fstore_1
    //   528: goto -443 -> 85
    //   531: aload 9
    //   533: ldc 242
    //   535: invokevirtual 218	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   538: ifne +470 -> 1008
    //   541: aload 9
    //   543: ldc 244
    //   545: invokevirtual 218	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   548: ifeq +128 -> 676
    //   551: aload 9
    //   553: bipush 58
    //   555: invokevirtual 222	java/lang/String:indexOf	(I)I
    //   558: istore_2
    //   559: iload_2
    //   560: iconst_1
    //   561: if_icmple +22 -> 583
    //   564: aload 9
    //   566: iload_2
    //   567: iconst_1
    //   568: iadd
    //   569: aload 9
    //   571: invokevirtual 145	java/lang/String:length	()I
    //   574: invokevirtual 226	java/lang/String:substring	(II)Ljava/lang/String;
    //   577: invokevirtual 142	java/lang/String:trim	()Ljava/lang/String;
    //   580: putstatic 25	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   583: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   586: ifeq -539 -> 47
    //   589: aload 10
    //   591: ldc 246
    //   593: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload 10
    //   599: getstatic 25	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   602: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload 10
    //   608: ldc 240
    //   610: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload 10
    //   616: aload 9
    //   618: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: aload 10
    //   624: ldc 195
    //   626: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: goto -583 -> 47
    //   633: astore 9
    //   635: lload 4
    //   637: lstore 6
    //   639: fload_0
    //   640: fstore_1
    //   641: aload 8
    //   643: ifnull -558 -> 85
    //   646: aload 8
    //   648: invokevirtual 154	java/io/BufferedReader:close	()V
    //   651: lload 4
    //   653: lstore 6
    //   655: fload_0
    //   656: fstore_1
    //   657: goto -572 -> 85
    //   660: astore 8
    //   662: aload 8
    //   664: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   667: lload 4
    //   669: lstore 6
    //   671: fload_0
    //   672: fstore_1
    //   673: goto -588 -> 85
    //   676: aload 9
    //   678: ldc 248
    //   680: invokevirtual 218	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   683: ifeq +108 -> 791
    //   686: aload 9
    //   688: bipush 58
    //   690: invokevirtual 222	java/lang/String:indexOf	(I)I
    //   693: istore_2
    //   694: iload_2
    //   695: iconst_1
    //   696: if_icmple +22 -> 718
    //   699: aload 9
    //   701: iload_2
    //   702: iconst_1
    //   703: iadd
    //   704: aload 9
    //   706: invokevirtual 145	java/lang/String:length	()I
    //   709: invokevirtual 226	java/lang/String:substring	(II)Ljava/lang/String;
    //   712: invokevirtual 142	java/lang/String:trim	()Ljava/lang/String;
    //   715: putstatic 27	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   718: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   721: ifeq -674 -> 47
    //   724: aload 10
    //   726: ldc 250
    //   728: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: pop
    //   732: aload 10
    //   734: getstatic 27	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   737: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: aload 10
    //   743: ldc 240
    //   745: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 10
    //   751: aload 9
    //   753: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: aload 10
    //   759: ldc 195
    //   761: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: pop
    //   765: goto -718 -> 47
    //   768: astore 10
    //   770: aload 8
    //   772: astore 9
    //   774: aload 10
    //   776: astore 8
    //   778: aload 9
    //   780: ifnull +8 -> 788
    //   783: aload 9
    //   785: invokevirtual 154	java/io/BufferedReader:close	()V
    //   788: aload 8
    //   790: athrow
    //   791: aload 9
    //   793: ldc 214
    //   795: invokevirtual 218	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   798: ifeq +76 -> 874
    //   801: aload 9
    //   803: invokevirtual 142	java/lang/String:trim	()Ljava/lang/String;
    //   806: putstatic 29	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   809: aload 9
    //   811: ldc 252
    //   813: invokevirtual 255	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   816: ifeq +7 -> 823
    //   819: iconst_1
    //   820: putstatic 51	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_e_of_type_Boolean	Z
    //   823: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   826: ifeq -779 -> 47
    //   829: aload 10
    //   831: ldc_w 257
    //   834: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: pop
    //   838: aload 10
    //   840: getstatic 51	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_e_of_type_Boolean	Z
    //   843: invokevirtual 208	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   846: pop
    //   847: aload 10
    //   849: ldc 240
    //   851: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: pop
    //   855: aload 10
    //   857: aload 9
    //   859: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: pop
    //   863: aload 10
    //   865: ldc 195
    //   867: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: goto -824 -> 47
    //   874: aload 9
    //   876: ldc_w 259
    //   879: invokevirtual 218	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   882: ifeq +67 -> 949
    //   885: aload 9
    //   887: bipush 58
    //   889: invokevirtual 222	java/lang/String:indexOf	(I)I
    //   892: istore_2
    //   893: iload_2
    //   894: iconst_1
    //   895: if_icmple -848 -> 47
    //   898: aload 9
    //   900: iload_2
    //   901: iconst_1
    //   902: iadd
    //   903: aload 9
    //   905: invokevirtual 145	java/lang/String:length	()I
    //   908: invokevirtual 226	java/lang/String:substring	(II)Ljava/lang/String;
    //   911: invokevirtual 142	java/lang/String:trim	()Ljava/lang/String;
    //   914: astore 9
    //   916: aload 9
    //   918: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   921: lstore 6
    //   923: lload 6
    //   925: lconst_0
    //   926: lcmp
    //   927: iflt -880 -> 47
    //   930: lconst_1
    //   931: lload 6
    //   933: ladd
    //   934: lload 4
    //   936: lcmp
    //   937: ifle -890 -> 47
    //   940: lconst_1
    //   941: lload 6
    //   943: ladd
    //   944: lstore 4
    //   946: goto -899 -> 47
    //   949: aload 9
    //   951: ldc_w 261
    //   954: invokevirtual 218	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   957: ifeq -910 -> 47
    //   960: aload 9
    //   962: bipush 58
    //   964: invokevirtual 222	java/lang/String:indexOf	(I)I
    //   967: istore_2
    //   968: iload_2
    //   969: iconst_1
    //   970: if_icmple -923 -> 47
    //   973: aload 9
    //   975: iload_2
    //   976: iconst_1
    //   977: iadd
    //   978: aload 9
    //   980: invokevirtual 145	java/lang/String:length	()I
    //   983: invokevirtual 226	java/lang/String:substring	(II)Ljava/lang/String;
    //   986: invokevirtual 142	java/lang/String:trim	()Ljava/lang/String;
    //   989: astore 9
    //   991: aload 9
    //   993: invokestatic 267	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   996: fstore_1
    //   997: fload_1
    //   998: fload_0
    //   999: fcmpl
    //   1000: ifle +467 -> 1467
    //   1003: fload_1
    //   1004: fstore_0
    //   1005: goto -958 -> 47
    //   1008: aload 9
    //   1010: bipush 58
    //   1012: invokevirtual 222	java/lang/String:indexOf	(I)I
    //   1015: istore_2
    //   1016: iload_2
    //   1017: iconst_1
    //   1018: if_icmple +50 -> 1068
    //   1021: aload 9
    //   1023: iload_2
    //   1024: iconst_1
    //   1025: iadd
    //   1026: aload 9
    //   1028: invokevirtual 145	java/lang/String:length	()I
    //   1031: invokevirtual 226	java/lang/String:substring	(II)Ljava/lang/String;
    //   1034: invokevirtual 142	java/lang/String:trim	()Ljava/lang/String;
    //   1037: astore 11
    //   1039: aload 11
    //   1041: ifnull +27 -> 1068
    //   1044: aload 11
    //   1046: invokevirtual 145	java/lang/String:length	()I
    //   1049: ifle +19 -> 1068
    //   1052: aload 11
    //   1054: ldc_w 269
    //   1057: invokevirtual 272	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1060: ifeq +74 -> 1134
    //   1063: bipush 8
    //   1065: putstatic 31	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Int	I
    //   1068: aload 9
    //   1070: ldc_w 274
    //   1073: invokevirtual 255	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1076: ifeq +7 -> 1083
    //   1079: iconst_5
    //   1080: putstatic 31	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Int	I
    //   1083: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1086: ifeq -1039 -> 47
    //   1089: aload 10
    //   1091: ldc_w 276
    //   1094: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: pop
    //   1098: aload 10
    //   1100: getstatic 31	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Int	I
    //   1103: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1106: pop
    //   1107: aload 10
    //   1109: ldc 240
    //   1111: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: pop
    //   1115: aload 10
    //   1117: aload 9
    //   1119: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: pop
    //   1123: aload 10
    //   1125: ldc 195
    //   1127: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1130: pop
    //   1131: goto -1084 -> 47
    //   1134: aload 11
    //   1136: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1139: l2i
    //   1140: putstatic 31	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Int	I
    //   1143: goto -75 -> 1068
    //   1146: astore 12
    //   1148: iconst_1
    //   1149: istore_2
    //   1150: aload 11
    //   1152: invokevirtual 145	java/lang/String:length	()I
    //   1155: istore_3
    //   1156: iload_2
    //   1157: iload_3
    //   1158: if_icmpge -90 -> 1068
    //   1161: aload 11
    //   1163: iconst_0
    //   1164: aload 11
    //   1166: invokevirtual 145	java/lang/String:length	()I
    //   1169: iload_2
    //   1170: isub
    //   1171: invokevirtual 226	java/lang/String:substring	(II)Ljava/lang/String;
    //   1174: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1177: l2i
    //   1178: putstatic 31	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Int	I
    //   1181: goto -113 -> 1068
    //   1184: astore 12
    //   1186: iload_2
    //   1187: iconst_1
    //   1188: iadd
    //   1189: istore_2
    //   1190: goto -40 -> 1150
    //   1193: astore 8
    //   1195: aload 8
    //   1197: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   1200: lload 4
    //   1202: lstore 6
    //   1204: fload_0
    //   1205: fstore_1
    //   1206: goto -1121 -> 85
    //   1209: astore 9
    //   1211: aload 9
    //   1213: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   1216: goto -428 -> 788
    //   1219: lload 6
    //   1221: lconst_0
    //   1222: lcmp
    //   1223: ifle -1095 -> 128
    //   1226: lload 6
    //   1228: l2i
    //   1229: putstatic 35	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_b_of_type_Int	I
    //   1232: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1235: ifeq -1107 -> 128
    //   1238: aload 10
    //   1240: ldc_w 278
    //   1243: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: pop
    //   1247: aload 10
    //   1249: getstatic 35	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_b_of_type_Int	I
    //   1252: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1255: pop
    //   1256: aload 10
    //   1258: ldc 195
    //   1260: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: pop
    //   1264: goto -1136 -> 128
    //   1267: fload_1
    //   1268: fconst_0
    //   1269: fcmpl
    //   1270: ifle -1094 -> 176
    //   1273: fload_1
    //   1274: ldc_w 279
    //   1277: fcmpg
    //   1278: ifge +52 -> 1330
    //   1281: fload_1
    //   1282: f2d
    //   1283: ldc2_w 280
    //   1286: dmul
    //   1287: ldc2_w 282
    //   1290: dmul
    //   1291: d2l
    //   1292: putstatic 33	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Long	J
    //   1295: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1298: ifeq -1122 -> 176
    //   1301: aload 10
    //   1303: ldc_w 285
    //   1306: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1309: pop
    //   1310: aload 10
    //   1312: getstatic 33	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Long	J
    //   1315: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1318: pop
    //   1319: aload 10
    //   1321: ldc 195
    //   1323: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1326: pop
    //   1327: goto -1151 -> 176
    //   1330: fload_1
    //   1331: ldc_w 286
    //   1334: fcmpl
    //   1335: ifle +20 -> 1355
    //   1338: fload_1
    //   1339: f2d
    //   1340: ldc2_w 287
    //   1343: ddiv
    //   1344: ldc2_w 282
    //   1347: dmul
    //   1348: d2l
    //   1349: putstatic 33	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Long	J
    //   1352: goto -57 -> 1295
    //   1355: ldc_w 289
    //   1358: fload_1
    //   1359: fmul
    //   1360: f2l
    //   1361: putstatic 33	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Long	J
    //   1364: goto -69 -> 1295
    //   1367: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1370: ifeq +47 -> 1417
    //   1373: aload 10
    //   1375: ldc_w 291
    //   1378: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1381: pop
    //   1382: aload 10
    //   1384: getstatic 35	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_b_of_type_Int	I
    //   1387: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1390: pop
    //   1391: aload 10
    //   1393: ldc_w 293
    //   1396: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: pop
    //   1400: aload 10
    //   1402: getstatic 33	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Long	J
    //   1405: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1408: pop
    //   1409: aload 10
    //   1411: ldc 195
    //   1413: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1416: pop
    //   1417: iconst_0
    //   1418: putstatic 37	com/tencent/mobileqq/qqaudio/QQAudioSystemInfo:jdField_a_of_type_Boolean	Z
    //   1421: goto -1227 -> 194
    //   1424: astore 9
    //   1426: goto -1379 -> 47
    //   1429: astore 9
    //   1431: goto -1384 -> 47
    //   1434: astore 8
    //   1436: aconst_null
    //   1437: astore 9
    //   1439: goto -661 -> 778
    //   1442: astore 8
    //   1444: aconst_null
    //   1445: astore 8
    //   1447: goto -812 -> 635
    //   1450: astore 8
    //   1452: aconst_null
    //   1453: astore 8
    //   1455: goto -965 -> 490
    //   1458: astore 8
    //   1460: aload 9
    //   1462: astore 8
    //   1464: goto -1115 -> 349
    //   1467: goto -462 -> 1005
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	1189	0	f1	float
    //   68	1291	1	f2	float
    //   88	1102	2	j	int
    //   1155	4	3	k	int
    //   12	1189	4	l1	long
    //   65	1162	6	l2	long
    //   45	316	8	localBufferedReader	java.io.BufferedReader
    //   374	128	8	localIOException1	java.io.IOException
    //   515	132	8	localIOException2	java.io.IOException
    //   660	111	8	localIOException3	java.io.IOException
    //   776	13	8	localObject1	Object
    //   1193	3	8	localIOException4	java.io.IOException
    //   1434	1	8	localObject2	Object
    //   1442	1	8	localNumberFormatException1	java.lang.NumberFormatException
    //   1445	1	8	localObject3	Object
    //   1450	1	8	localIOException5	java.io.IOException
    //   1453	1	8	localObject4	Object
    //   1458	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   1462	1	8	localObject5	Object
    //   7	317	9	str1	String
    //   347	125	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   488	129	9	localIOException6	java.io.IOException
    //   633	119	9	localNumberFormatException2	java.lang.NumberFormatException
    //   772	346	9	localObject6	Object
    //   1209	3	9	localIOException7	java.io.IOException
    //   1424	1	9	localNumberFormatException3	java.lang.NumberFormatException
    //   1429	1	9	localNumberFormatException4	java.lang.NumberFormatException
    //   1437	24	9	localObject7	Object
    //   27	731	10	localStringBuilder	java.lang.StringBuilder
    //   768	642	10	localObject8	Object
    //   1037	128	11	str2	String
    //   1146	1	12	localNumberFormatException5	java.lang.NumberFormatException
    //   1184	1	12	localNumberFormatException6	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   47	54	347	java/io/FileNotFoundException
    //   59	63	347	java/io/FileNotFoundException
    //   295	313	347	java/io/FileNotFoundException
    //   318	344	347	java/io/FileNotFoundException
    //   390	408	347	java/io/FileNotFoundException
    //   413	485	347	java/io/FileNotFoundException
    //   531	559	347	java/io/FileNotFoundException
    //   564	583	347	java/io/FileNotFoundException
    //   583	630	347	java/io/FileNotFoundException
    //   676	694	347	java/io/FileNotFoundException
    //   699	718	347	java/io/FileNotFoundException
    //   718	765	347	java/io/FileNotFoundException
    //   791	823	347	java/io/FileNotFoundException
    //   823	871	347	java/io/FileNotFoundException
    //   874	893	347	java/io/FileNotFoundException
    //   898	916	347	java/io/FileNotFoundException
    //   916	923	347	java/io/FileNotFoundException
    //   949	968	347	java/io/FileNotFoundException
    //   973	991	347	java/io/FileNotFoundException
    //   991	997	347	java/io/FileNotFoundException
    //   1008	1016	347	java/io/FileNotFoundException
    //   1021	1039	347	java/io/FileNotFoundException
    //   1044	1068	347	java/io/FileNotFoundException
    //   1068	1083	347	java/io/FileNotFoundException
    //   1083	1131	347	java/io/FileNotFoundException
    //   1134	1143	347	java/io/FileNotFoundException
    //   1150	1156	347	java/io/FileNotFoundException
    //   1161	1181	347	java/io/FileNotFoundException
    //   360	365	374	java/io/IOException
    //   47	54	488	java/io/IOException
    //   59	63	488	java/io/IOException
    //   295	313	488	java/io/IOException
    //   318	344	488	java/io/IOException
    //   390	408	488	java/io/IOException
    //   413	485	488	java/io/IOException
    //   531	559	488	java/io/IOException
    //   564	583	488	java/io/IOException
    //   583	630	488	java/io/IOException
    //   676	694	488	java/io/IOException
    //   699	718	488	java/io/IOException
    //   718	765	488	java/io/IOException
    //   791	823	488	java/io/IOException
    //   823	871	488	java/io/IOException
    //   874	893	488	java/io/IOException
    //   898	916	488	java/io/IOException
    //   916	923	488	java/io/IOException
    //   949	968	488	java/io/IOException
    //   973	991	488	java/io/IOException
    //   991	997	488	java/io/IOException
    //   1008	1016	488	java/io/IOException
    //   1021	1039	488	java/io/IOException
    //   1044	1068	488	java/io/IOException
    //   1068	1083	488	java/io/IOException
    //   1083	1131	488	java/io/IOException
    //   1134	1143	488	java/io/IOException
    //   1150	1156	488	java/io/IOException
    //   1161	1181	488	java/io/IOException
    //   501	506	515	java/io/IOException
    //   47	54	633	java/lang/NumberFormatException
    //   59	63	633	java/lang/NumberFormatException
    //   295	313	633	java/lang/NumberFormatException
    //   318	344	633	java/lang/NumberFormatException
    //   390	408	633	java/lang/NumberFormatException
    //   413	485	633	java/lang/NumberFormatException
    //   531	559	633	java/lang/NumberFormatException
    //   564	583	633	java/lang/NumberFormatException
    //   583	630	633	java/lang/NumberFormatException
    //   676	694	633	java/lang/NumberFormatException
    //   699	718	633	java/lang/NumberFormatException
    //   718	765	633	java/lang/NumberFormatException
    //   791	823	633	java/lang/NumberFormatException
    //   823	871	633	java/lang/NumberFormatException
    //   874	893	633	java/lang/NumberFormatException
    //   898	916	633	java/lang/NumberFormatException
    //   949	968	633	java/lang/NumberFormatException
    //   973	991	633	java/lang/NumberFormatException
    //   1008	1016	633	java/lang/NumberFormatException
    //   1021	1039	633	java/lang/NumberFormatException
    //   1044	1068	633	java/lang/NumberFormatException
    //   1068	1083	633	java/lang/NumberFormatException
    //   1083	1131	633	java/lang/NumberFormatException
    //   1150	1156	633	java/lang/NumberFormatException
    //   646	651	660	java/io/IOException
    //   47	54	768	finally
    //   59	63	768	finally
    //   295	313	768	finally
    //   318	344	768	finally
    //   390	408	768	finally
    //   413	485	768	finally
    //   531	559	768	finally
    //   564	583	768	finally
    //   583	630	768	finally
    //   676	694	768	finally
    //   699	718	768	finally
    //   718	765	768	finally
    //   791	823	768	finally
    //   823	871	768	finally
    //   874	893	768	finally
    //   898	916	768	finally
    //   916	923	768	finally
    //   949	968	768	finally
    //   973	991	768	finally
    //   991	997	768	finally
    //   1008	1016	768	finally
    //   1021	1039	768	finally
    //   1044	1068	768	finally
    //   1068	1083	768	finally
    //   1083	1131	768	finally
    //   1134	1143	768	finally
    //   1150	1156	768	finally
    //   1161	1181	768	finally
    //   1134	1143	1146	java/lang/NumberFormatException
    //   1161	1181	1184	java/lang/NumberFormatException
    //   74	79	1193	java/io/IOException
    //   783	788	1209	java/io/IOException
    //   916	923	1424	java/lang/NumberFormatException
    //   991	997	1429	java/lang/NumberFormatException
    //   29	47	1434	finally
    //   29	47	1442	java/lang/NumberFormatException
    //   29	47	1450	java/io/IOException
    //   29	47	1458	java/io/FileNotFoundException
  }
  
  static int b()
  {
    int k = 7;
    int j;
    if (jdField_a_of_type_JavaLangString.contains("ARMv6")) {
      j = 2;
    }
    do
    {
      do
      {
        do
        {
          return j;
          if (Build.CPU_ABI.equalsIgnoreCase("armeabi-v7a")) {
            return 4;
          }
          if (Build.CPU_ABI.equalsIgnoreCase("armeabi")) {
            return 2;
          }
          if ((jdField_a_of_type_Int == 7) && (jdField_b_of_type_JavaLangString.indexOf("neon") < 0))
          {
            long l = c();
            j = c();
            if ((l < 1100000L) || (j < 2)) {
              return 3;
            }
          }
          j = k;
        } while (Build.CPU_ABI.equalsIgnoreCase("x86"));
        switch (jdField_a_of_type_Int)
        {
        default: 
          if (jdField_c_of_type_JavaLangString == null) {
            break label170;
          }
          j = k;
        }
      } while (jdField_c_of_type_JavaLangString.equalsIgnoreCase("AuthenticAMD"));
      j = k;
    } while (jdField_c_of_type_JavaLangString.equalsIgnoreCase("GenuineIntel"));
    label170:
    return 0;
    return 1;
    return 2;
    return 4;
    return 5;
  }
  
  /* Error */
  static long b()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: aconst_null
    //   3: astore 10
    //   5: new 104	java/io/BufferedReader
    //   8: dup
    //   9: new 106	java/io/FileReader
    //   12: dup
    //   13: ldc_w 323
    //   16: invokespecial 125	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   19: invokespecial 128	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   22: astore 9
    //   24: lload_3
    //   25: lstore_1
    //   26: aload 9
    //   28: ifnull +92 -> 120
    //   31: aload 9
    //   33: astore 7
    //   35: aload 9
    //   37: invokevirtual 131	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore 8
    //   42: aload 8
    //   44: ifnull +263 -> 307
    //   47: aload 9
    //   49: astore 7
    //   51: aload 9
    //   53: invokevirtual 131	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 11
    //   58: aload 8
    //   60: astore 10
    //   62: aload 11
    //   64: astore 8
    //   66: goto -24 -> 42
    //   69: lload_3
    //   70: lstore_1
    //   71: iload_0
    //   72: iconst_m1
    //   73: if_icmpeq +47 -> 120
    //   76: aload 9
    //   78: astore 7
    //   80: aload 10
    //   82: iconst_0
    //   83: iload_0
    //   84: invokevirtual 226	java/lang/String:substring	(II)Ljava/lang/String;
    //   87: astore 8
    //   89: lload_3
    //   90: lstore_1
    //   91: aload 8
    //   93: ifnull +27 -> 120
    //   96: lload_3
    //   97: lstore_1
    //   98: aload 9
    //   100: astore 7
    //   102: aload 8
    //   104: invokevirtual 145	java/lang/String:length	()I
    //   107: ifle +13 -> 120
    //   110: aload 9
    //   112: astore 7
    //   114: aload 8
    //   116: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   119: lstore_1
    //   120: lload_1
    //   121: lstore 5
    //   123: aload 9
    //   125: ifnull +11 -> 136
    //   128: aload 9
    //   130: invokevirtual 154	java/io/BufferedReader:close	()V
    //   133: lload_1
    //   134: lstore 5
    //   136: ldc 97
    //   138: iconst_2
    //   139: new 108	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 325
    //   149: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: lload 5
    //   154: invokevirtual 161	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   157: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 102	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: lload 5
    //   165: lreturn
    //   166: aload 9
    //   168: astore 7
    //   170: aload 10
    //   172: bipush 9
    //   174: invokevirtual 222	java/lang/String:indexOf	(I)I
    //   177: istore_0
    //   178: goto -109 -> 69
    //   181: astore 7
    //   183: aload 7
    //   185: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   188: lload_1
    //   189: lstore 5
    //   191: goto -55 -> 136
    //   194: astore 10
    //   196: aconst_null
    //   197: astore 8
    //   199: aload 8
    //   201: astore 7
    //   203: ldc 97
    //   205: iconst_2
    //   206: new 108	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 327
    //   216: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload 10
    //   221: invokevirtual 171	java/lang/Exception:toString	()Ljava/lang/String;
    //   224: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 173	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: lload_3
    //   234: lstore 5
    //   236: aload 8
    //   238: ifnull -102 -> 136
    //   241: aload 8
    //   243: invokevirtual 154	java/io/BufferedReader:close	()V
    //   246: lload_3
    //   247: lstore 5
    //   249: goto -113 -> 136
    //   252: astore 7
    //   254: aload 7
    //   256: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   259: lload_3
    //   260: lstore 5
    //   262: goto -126 -> 136
    //   265: astore 8
    //   267: aconst_null
    //   268: astore 7
    //   270: aload 7
    //   272: ifnull +8 -> 280
    //   275: aload 7
    //   277: invokevirtual 154	java/io/BufferedReader:close	()V
    //   280: aload 8
    //   282: athrow
    //   283: astore 7
    //   285: aload 7
    //   287: invokevirtual 166	java/io/IOException:printStackTrace	()V
    //   290: goto -10 -> 280
    //   293: astore 8
    //   295: goto -25 -> 270
    //   298: astore 10
    //   300: aload 9
    //   302: astore 8
    //   304: goto -105 -> 199
    //   307: aload 10
    //   309: ifnonnull -143 -> 166
    //   312: iconst_m1
    //   313: istore_0
    //   314: goto -245 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   71	243	0	j	int
    //   25	164	1	l1	long
    //   1	259	3	l2	long
    //   121	140	5	l3	long
    //   33	136	7	localBufferedReader1	java.io.BufferedReader
    //   181	3	7	localIOException1	java.io.IOException
    //   201	1	7	localObject1	Object
    //   252	3	7	localIOException2	java.io.IOException
    //   268	8	7	localObject2	Object
    //   283	3	7	localIOException3	java.io.IOException
    //   40	202	8	localObject3	Object
    //   265	16	8	localObject4	Object
    //   293	1	8	localObject5	Object
    //   302	1	8	localBufferedReader2	java.io.BufferedReader
    //   22	279	9	localBufferedReader3	java.io.BufferedReader
    //   3	168	10	localObject6	Object
    //   194	26	10	localException1	Exception
    //   298	10	10	localException2	Exception
    //   56	7	11	str	String
    // Exception table:
    //   from	to	target	type
    //   128	133	181	java/io/IOException
    //   5	24	194	java/lang/Exception
    //   241	246	252	java/io/IOException
    //   5	24	265	finally
    //   275	280	283	java/io/IOException
    //   35	42	293	finally
    //   51	58	293	finally
    //   80	89	293	finally
    //   102	110	293	finally
    //   114	120	293	finally
    //   170	178	293	finally
    //   203	233	293	finally
    //   35	42	298	java/lang/Exception
    //   51	58	298	java/lang/Exception
    //   80	89	298	java/lang/Exception
    //   102	110	298	java/lang/Exception
    //   114	120	298	java/lang/Exception
    //   170	178	298	java/lang/Exception
  }
  
  public static int c()
  {
    a();
    return jdField_b_of_type_Int;
  }
  
  public static long c()
  {
    
    if (QLog.isColorLevel()) {
      QLog.i("QQAudioSystemInfo", 2, "getMaxCpuFreq: " + Build.BRAND + "|" + Build.MODEL + "|" + jdField_a_of_type_Long);
    }
    return jdField_a_of_type_Long;
  }
  
  public static int d()
  {
    a();
    return jdField_d_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.QQAudioSystemInfo
 * JD-Core Version:    0.7.0.1
 */