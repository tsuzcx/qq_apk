import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lbk
{
  static int jdField_a_of_type_Int;
  public static long a;
  static String jdField_a_of_type_JavaLangString = "";
  static boolean jdField_a_of_type_Boolean;
  public static int b;
  static long jdField_b_of_type_Long;
  static String jdField_b_of_type_JavaLangString = "";
  static boolean jdField_b_of_type_Boolean;
  static int jdField_c_of_type_Int;
  static String jdField_c_of_type_JavaLangString;
  static boolean jdField_c_of_type_Boolean;
  static int jdField_d_of_type_Int;
  static String jdField_d_of_type_JavaLangString;
  static boolean jdField_d_of_type_Boolean;
  private static String e;
  static int i;
  public int e;
  public int f = 480;
  public int g = 320;
  public int h = 240;
  
  static
  {
    jdField_a_of_type_Int = 5;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 1;
    jdField_b_of_type_Boolean = true;
    jdField_c_of_type_Boolean = true;
    a();
  }
  
  public lbk()
  {
    this.jdField_e_of_type_Int = 320;
  }
  
  static int a()
  {
    try
    {
      int j = new File("/sys/devices/system/cpu/").listFiles(new lbl()).length;
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
    //   2: getstatic 29	lbk:jdField_b_of_type_Int	I
    //   5: iconst_1
    //   6: if_icmpge +22 -> 28
    //   9: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +11 -> 23
    //   15: ldc 79
    //   17: iconst_2
    //   18: ldc 81
    //   20: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: bipush 8
    //   25: putstatic 29	lbk:jdField_b_of_type_Int	I
    //   28: iconst_0
    //   29: istore_2
    //   30: lconst_0
    //   31: lstore 5
    //   33: lconst_0
    //   34: lstore_3
    //   35: iload_1
    //   36: getstatic 29	lbk:jdField_b_of_type_Int	I
    //   39: if_icmpge +313 -> 352
    //   42: aconst_null
    //   43: astore 12
    //   45: new 86	java/io/BufferedReader
    //   48: dup
    //   49: new 88	java/io/FileReader
    //   52: dup
    //   53: new 90	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   60: ldc 93
    //   62: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: iload_1
    //   66: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: ldc 102
    //   71: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   80: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   83: astore 11
    //   85: lload_3
    //   86: lstore 7
    //   88: aload 11
    //   90: ifnull +51 -> 141
    //   93: aload 11
    //   95: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   98: astore 12
    //   100: aload 12
    //   102: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +334 -> 439
    //   108: aload 12
    //   110: invokevirtual 124	java/lang/String:trim	()Ljava/lang/String;
    //   113: astore 12
    //   115: lload_3
    //   116: lstore 7
    //   118: aload 12
    //   120: ifnull +21 -> 141
    //   123: lload_3
    //   124: lstore 7
    //   126: aload 12
    //   128: invokevirtual 127	java/lang/String:length	()I
    //   131: ifle +10 -> 141
    //   134: aload 12
    //   136: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   139: lstore 7
    //   141: iload_2
    //   142: istore_0
    //   143: lload 7
    //   145: lstore_3
    //   146: aload 11
    //   148: ifnull +13 -> 161
    //   151: aload 11
    //   153: invokevirtual 136	java/io/BufferedReader:close	()V
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
    //   175: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +47 -> 225
    //   181: ldc 79
    //   183: iconst_2
    //   184: new 90	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   191: ldc 138
    //   193: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: iload_1
    //   197: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   200: ldc 140
    //   202: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: lload_3
    //   206: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   209: ldc 145
    //   211: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: lload 7
    //   216: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   219: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   242: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   245: iload_2
    //   246: istore_0
    //   247: lload 7
    //   249: lstore_3
    //   250: goto -89 -> 161
    //   253: astore 12
    //   255: aconst_null
    //   256: astore 11
    //   258: ldc 79
    //   260: iconst_1
    //   261: new 90	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   268: ldc 150
    //   270: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: iload_1
    //   274: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   277: ldc 152
    //   279: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload 12
    //   284: invokevirtual 153	java/lang/Exception:toString	()Ljava/lang/String;
    //   287: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 155	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: aload 11
    //   298: ifnull +8 -> 306
    //   301: aload 11
    //   303: invokevirtual 136	java/io/BufferedReader:close	()V
    //   306: iconst_1
    //   307: istore_0
    //   308: lconst_0
    //   309: lstore_3
    //   310: goto -149 -> 161
    //   313: astore 11
    //   315: aload 11
    //   317: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   320: iconst_1
    //   321: istore_0
    //   322: lconst_0
    //   323: lstore_3
    //   324: goto -163 -> 161
    //   327: astore 11
    //   329: aload 12
    //   331: ifnull +8 -> 339
    //   334: aload 12
    //   336: invokevirtual 136	java/io/BufferedReader:close	()V
    //   339: aload 11
    //   341: athrow
    //   342: astore 12
    //   344: aload 12
    //   346: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   349: goto -10 -> 339
    //   352: lload 5
    //   354: lstore 7
    //   356: iload_2
    //   357: ifeq +23 -> 380
    //   360: invokestatic 157	lbk:b	()J
    //   363: lstore 9
    //   365: lload 5
    //   367: lstore 7
    //   369: lload 9
    //   371: lload_3
    //   372: lcmp
    //   373: ifle +7 -> 380
    //   376: lload 9
    //   378: lstore 7
    //   380: ldc 79
    //   382: new 90	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   389: ldc 159
    //   391: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: lload 7
    //   396: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   399: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 164	krx:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: lload 7
    //   407: lreturn
    //   408: astore 13
    //   410: aload 11
    //   412: astore 12
    //   414: aload 13
    //   416: astore 11
    //   418: goto -89 -> 329
    //   421: astore 13
    //   423: aload 11
    //   425: astore 12
    //   427: aload 13
    //   429: astore 11
    //   431: goto -102 -> 329
    //   434: astore 12
    //   436: goto -178 -> 258
    //   439: ldc 21
    //   441: astore 12
    //   443: goto -328 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   142	180	0	j	int
    //   1	273	1	k	int
    //   29	328	2	m	int
    //   34	338	3	l1	long
    //   31	335	5	l2	long
    //   86	320	7	l3	long
    //   363	14	9	l4	long
    //   83	69	11	localBufferedReader	java.io.BufferedReader
    //   238	3	11	localIOException1	java.io.IOException
    //   256	46	11	localObject1	Object
    //   313	3	11	localIOException2	java.io.IOException
    //   327	84	11	localObject2	Object
    //   416	14	11	localObject3	Object
    //   43	92	12	str1	String
    //   253	82	12	localException1	Exception
    //   342	3	12	localIOException3	java.io.IOException
    //   412	14	12	localObject4	Object
    //   434	1	12	localException2	Exception
    //   441	1	12	str2	String
    //   408	7	13	localObject5	Object
    //   421	7	13	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   151	156	238	java/io/IOException
    //   45	85	253	java/lang/Exception
    //   301	306	313	java/io/IOException
    //   45	85	327	finally
    //   334	339	342	java/io/IOException
    //   93	115	408	finally
    //   126	141	408	finally
    //   258	296	421	finally
    //   93	115	434	java/lang/Exception
    //   126	141	434	java/lang/Exception
  }
  
  public static String a()
  {
    a();
    return jdField_e_of_type_JavaLangString;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: getstatic 172	lbk:jdField_a_of_type_Boolean	Z
    //   3: iconst_1
    //   4: if_icmpne +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 9
    //   11: ldc2_w 173
    //   14: lstore 4
    //   16: ldc 175
    //   18: fstore_0
    //   19: new 90	java/lang/StringBuilder
    //   22: dup
    //   23: sipush 1024
    //   26: invokespecial 178	java/lang/StringBuilder:<init>	(I)V
    //   29: astore 10
    //   31: new 86	java/io/BufferedReader
    //   34: dup
    //   35: new 88	java/io/FileReader
    //   38: dup
    //   39: ldc 180
    //   41: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   44: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   47: astore 8
    //   49: aload 8
    //   51: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore 9
    //   56: aload 9
    //   58: ifnonnull +269 -> 327
    //   61: iconst_1
    //   62: putstatic 172	lbk:jdField_a_of_type_Boolean	Z
    //   65: lload 4
    //   67: lstore 6
    //   69: fload_0
    //   70: fstore_1
    //   71: aload 8
    //   73: ifnull +14 -> 87
    //   76: aload 8
    //   78: invokevirtual 136	java/io/BufferedReader:close	()V
    //   81: fload_0
    //   82: fstore_1
    //   83: lload 4
    //   85: lstore 6
    //   87: invokestatic 182	lbk:a	()I
    //   90: istore_2
    //   91: iload_2
    //   92: ifle +1158 -> 1250
    //   95: iload_2
    //   96: putstatic 29	lbk:jdField_b_of_type_Int	I
    //   99: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +28 -> 130
    //   105: aload 10
    //   107: ldc 184
    //   109: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 10
    //   115: getstatic 29	lbk:jdField_b_of_type_Int	I
    //   118: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 10
    //   124: ldc 186
    //   126: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: invokestatic 188	lbk:a	()J
    //   133: lstore 4
    //   135: lload 4
    //   137: lconst_0
    //   138: lcmp
    //   139: ifle +1159 -> 1298
    //   142: lload 4
    //   144: putstatic 190	lbk:jdField_a_of_type_Long	J
    //   147: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +28 -> 178
    //   153: aload 10
    //   155: ldc 192
    //   157: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 10
    //   163: getstatic 190	lbk:jdField_a_of_type_Long	J
    //   166: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 10
    //   172: ldc 186
    //   174: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: getstatic 29	lbk:jdField_b_of_type_Int	I
    //   181: ifle +11 -> 192
    //   184: getstatic 190	lbk:jdField_a_of_type_Long	J
    //   187: lconst_0
    //   188: lcmp
    //   189: ifgt +1209 -> 1398
    //   192: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +45 -> 240
    //   198: aload 10
    //   200: ldc 194
    //   202: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 10
    //   208: getstatic 29	lbk:jdField_b_of_type_Int	I
    //   211: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 10
    //   217: ldc 196
    //   219: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 10
    //   225: getstatic 190	lbk:jdField_a_of_type_Long	J
    //   228: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 10
    //   234: ldc 186
    //   236: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: iconst_0
    //   241: putstatic 172	lbk:jdField_a_of_type_Boolean	Z
    //   244: invokestatic 198	lbk:b	()I
    //   247: putstatic 33	lbk:jdField_d_of_type_Int	I
    //   250: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq -246 -> 7
    //   256: aload 10
    //   258: ldc 200
    //   260: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 10
    //   266: getstatic 33	lbk:jdField_d_of_type_Int	I
    //   269: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 10
    //   275: ldc 202
    //   277: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 10
    //   283: getstatic 37	lbk:jdField_c_of_type_Boolean	Z
    //   286: invokevirtual 205	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 10
    //   292: ldc 207
    //   294: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 10
    //   300: getstatic 35	lbk:jdField_b_of_type_Boolean	Z
    //   303: invokevirtual 205	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 10
    //   309: ldc 186
    //   311: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: ldc 79
    //   317: iconst_2
    //   318: aload 10
    //   320: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: return
    //   327: aload 9
    //   329: ldc 209
    //   331: invokevirtual 213	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   334: ifeq +88 -> 422
    //   337: aload 9
    //   339: bipush 58
    //   341: invokevirtual 217	java/lang/String:indexOf	(I)I
    //   344: istore_2
    //   345: iload_2
    //   346: iconst_1
    //   347: if_icmple -298 -> 49
    //   350: aload 9
    //   352: iload_2
    //   353: iconst_1
    //   354: iadd
    //   355: aload 9
    //   357: invokevirtual 127	java/lang/String:length	()I
    //   360: invokevirtual 221	java/lang/String:substring	(II)Ljava/lang/String;
    //   363: invokevirtual 124	java/lang/String:trim	()Ljava/lang/String;
    //   366: ldc 223
    //   368: ldc 21
    //   370: invokevirtual 227	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   373: putstatic 166	lbk:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   376: goto -327 -> 49
    //   379: astore 9
    //   381: lload 4
    //   383: lstore 6
    //   385: fload_0
    //   386: fstore_1
    //   387: aload 8
    //   389: ifnull -302 -> 87
    //   392: aload 8
    //   394: invokevirtual 136	java/io/BufferedReader:close	()V
    //   397: lload 4
    //   399: lstore 6
    //   401: fload_0
    //   402: fstore_1
    //   403: goto -316 -> 87
    //   406: astore 8
    //   408: aload 8
    //   410: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   413: lload 4
    //   415: lstore 6
    //   417: fload_0
    //   418: fstore_1
    //   419: goto -332 -> 87
    //   422: aload 9
    //   424: ldc 229
    //   426: invokevirtual 213	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   429: ifeq +134 -> 563
    //   432: aload 9
    //   434: bipush 58
    //   436: invokevirtual 217	java/lang/String:indexOf	(I)I
    //   439: istore_2
    //   440: iload_2
    //   441: iconst_1
    //   442: if_icmple -393 -> 49
    //   445: aload 9
    //   447: iload_2
    //   448: iconst_1
    //   449: iadd
    //   450: aload 9
    //   452: invokevirtual 127	java/lang/String:length	()I
    //   455: invokevirtual 221	java/lang/String:substring	(II)Ljava/lang/String;
    //   458: putstatic 23	lbk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   461: getstatic 23	lbk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   464: invokevirtual 124	java/lang/String:trim	()Ljava/lang/String;
    //   467: putstatic 23	lbk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   470: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   473: ifeq -424 -> 49
    //   476: aload 10
    //   478: ldc 231
    //   480: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 10
    //   486: getstatic 23	lbk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   489: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload 10
    //   495: ldc 233
    //   497: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 10
    //   503: aload 9
    //   505: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 10
    //   511: ldc 186
    //   513: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: goto -468 -> 49
    //   520: astore 9
    //   522: lload 4
    //   524: lstore 6
    //   526: fload_0
    //   527: fstore_1
    //   528: aload 8
    //   530: ifnull -443 -> 87
    //   533: aload 8
    //   535: invokevirtual 136	java/io/BufferedReader:close	()V
    //   538: lload 4
    //   540: lstore 6
    //   542: fload_0
    //   543: fstore_1
    //   544: goto -457 -> 87
    //   547: astore 8
    //   549: aload 8
    //   551: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   554: lload 4
    //   556: lstore 6
    //   558: fload_0
    //   559: fstore_1
    //   560: goto -473 -> 87
    //   563: aload 9
    //   565: ldc 235
    //   567: invokevirtual 213	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   570: ifeq +228 -> 798
    //   573: aload 9
    //   575: bipush 58
    //   577: invokevirtual 217	java/lang/String:indexOf	(I)I
    //   580: istore_2
    //   581: iload_2
    //   582: iconst_1
    //   583: if_icmple +49 -> 632
    //   586: aload 9
    //   588: iload_2
    //   589: iconst_1
    //   590: iadd
    //   591: aload 9
    //   593: invokevirtual 127	java/lang/String:length	()I
    //   596: invokevirtual 221	java/lang/String:substring	(II)Ljava/lang/String;
    //   599: invokevirtual 124	java/lang/String:trim	()Ljava/lang/String;
    //   602: astore 11
    //   604: aload 11
    //   606: ifnull +26 -> 632
    //   609: aload 11
    //   611: invokevirtual 127	java/lang/String:length	()I
    //   614: ifle +18 -> 632
    //   617: aload 11
    //   619: ldc 237
    //   621: invokevirtual 240	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   624: ifeq +115 -> 739
    //   627: bipush 8
    //   629: putstatic 27	lbk:jdField_a_of_type_Int	I
    //   632: aload 9
    //   634: ldc 242
    //   636: invokevirtual 245	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   639: ifeq +7 -> 646
    //   642: iconst_5
    //   643: putstatic 27	lbk:jdField_a_of_type_Int	I
    //   646: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   649: ifeq -600 -> 49
    //   652: aload 10
    //   654: ldc 247
    //   656: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: pop
    //   660: aload 10
    //   662: getstatic 27	lbk:jdField_a_of_type_Int	I
    //   665: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload 10
    //   671: ldc 233
    //   673: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 10
    //   679: aload 9
    //   681: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload 10
    //   687: ldc 186
    //   689: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: goto -644 -> 49
    //   696: astore 9
    //   698: lload 4
    //   700: lstore 6
    //   702: fload_0
    //   703: fstore_1
    //   704: aload 8
    //   706: ifnull -619 -> 87
    //   709: aload 8
    //   711: invokevirtual 136	java/io/BufferedReader:close	()V
    //   714: lload 4
    //   716: lstore 6
    //   718: fload_0
    //   719: fstore_1
    //   720: goto -633 -> 87
    //   723: astore 8
    //   725: aload 8
    //   727: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   730: lload 4
    //   732: lstore 6
    //   734: fload_0
    //   735: fstore_1
    //   736: goto -649 -> 87
    //   739: aload 11
    //   741: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   744: l2i
    //   745: putstatic 27	lbk:jdField_a_of_type_Int	I
    //   748: goto -116 -> 632
    //   751: astore 12
    //   753: iconst_1
    //   754: istore_2
    //   755: aload 11
    //   757: invokevirtual 127	java/lang/String:length	()I
    //   760: istore_3
    //   761: iload_2
    //   762: iload_3
    //   763: if_icmpge -131 -> 632
    //   766: aload 11
    //   768: iconst_0
    //   769: aload 11
    //   771: invokevirtual 127	java/lang/String:length	()I
    //   774: iload_2
    //   775: isub
    //   776: invokevirtual 221	java/lang/String:substring	(II)Ljava/lang/String;
    //   779: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   782: l2i
    //   783: putstatic 27	lbk:jdField_a_of_type_Int	I
    //   786: goto -154 -> 632
    //   789: astore 12
    //   791: iload_2
    //   792: iconst_1
    //   793: iadd
    //   794: istore_2
    //   795: goto -40 -> 755
    //   798: aload 9
    //   800: ldc 249
    //   802: invokevirtual 213	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   805: ifeq +108 -> 913
    //   808: aload 9
    //   810: bipush 58
    //   812: invokevirtual 217	java/lang/String:indexOf	(I)I
    //   815: istore_2
    //   816: iload_2
    //   817: iconst_1
    //   818: if_icmple +22 -> 840
    //   821: aload 9
    //   823: iload_2
    //   824: iconst_1
    //   825: iadd
    //   826: aload 9
    //   828: invokevirtual 127	java/lang/String:length	()I
    //   831: invokevirtual 221	java/lang/String:substring	(II)Ljava/lang/String;
    //   834: invokevirtual 124	java/lang/String:trim	()Ljava/lang/String;
    //   837: putstatic 25	lbk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   840: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   843: ifeq -794 -> 49
    //   846: aload 10
    //   848: ldc 251
    //   850: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: pop
    //   854: aload 10
    //   856: getstatic 25	lbk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   859: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: pop
    //   863: aload 10
    //   865: ldc 233
    //   867: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: aload 10
    //   873: aload 9
    //   875: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: pop
    //   879: aload 10
    //   881: ldc 186
    //   883: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: pop
    //   887: goto -838 -> 49
    //   890: astore 10
    //   892: aload 8
    //   894: astore 9
    //   896: aload 10
    //   898: astore 8
    //   900: aload 9
    //   902: ifnull +8 -> 910
    //   905: aload 9
    //   907: invokevirtual 136	java/io/BufferedReader:close	()V
    //   910: aload 8
    //   912: athrow
    //   913: aload 9
    //   915: ldc 253
    //   917: invokevirtual 213	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   920: ifeq +86 -> 1006
    //   923: aload 9
    //   925: bipush 58
    //   927: invokevirtual 217	java/lang/String:indexOf	(I)I
    //   930: istore_2
    //   931: iload_2
    //   932: iconst_1
    //   933: if_icmple +22 -> 955
    //   936: aload 9
    //   938: iload_2
    //   939: iconst_1
    //   940: iadd
    //   941: aload 9
    //   943: invokevirtual 127	java/lang/String:length	()I
    //   946: invokevirtual 221	java/lang/String:substring	(II)Ljava/lang/String;
    //   949: invokevirtual 124	java/lang/String:trim	()Ljava/lang/String;
    //   952: putstatic 255	lbk:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   955: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   958: ifeq -909 -> 49
    //   961: aload 10
    //   963: ldc_w 257
    //   966: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   969: pop
    //   970: aload 10
    //   972: getstatic 255	lbk:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   975: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: pop
    //   979: aload 10
    //   981: ldc 233
    //   983: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: pop
    //   987: aload 10
    //   989: aload 9
    //   991: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: pop
    //   995: aload 10
    //   997: ldc 186
    //   999: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: pop
    //   1003: goto -954 -> 49
    //   1006: aload 9
    //   1008: ldc 209
    //   1010: invokevirtual 213	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1013: ifeq +77 -> 1090
    //   1016: aload 9
    //   1018: invokevirtual 124	java/lang/String:trim	()Ljava/lang/String;
    //   1021: putstatic 259	lbk:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1024: aload 9
    //   1026: ldc_w 261
    //   1029: invokevirtual 245	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1032: ifeq +7 -> 1039
    //   1035: iconst_1
    //   1036: putstatic 263	lbk:jdField_d_of_type_Boolean	Z
    //   1039: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1042: ifeq -993 -> 49
    //   1045: aload 10
    //   1047: ldc_w 265
    //   1050: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: pop
    //   1054: aload 10
    //   1056: getstatic 263	lbk:jdField_d_of_type_Boolean	Z
    //   1059: invokevirtual 205	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1062: pop
    //   1063: aload 10
    //   1065: ldc 233
    //   1067: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: pop
    //   1071: aload 10
    //   1073: aload 9
    //   1075: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: pop
    //   1079: aload 10
    //   1081: ldc 186
    //   1083: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: pop
    //   1087: goto -1038 -> 49
    //   1090: aload 9
    //   1092: ldc_w 267
    //   1095: invokevirtual 213	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1098: ifeq +67 -> 1165
    //   1101: aload 9
    //   1103: bipush 58
    //   1105: invokevirtual 217	java/lang/String:indexOf	(I)I
    //   1108: istore_2
    //   1109: iload_2
    //   1110: iconst_1
    //   1111: if_icmple -1062 -> 49
    //   1114: aload 9
    //   1116: iload_2
    //   1117: iconst_1
    //   1118: iadd
    //   1119: aload 9
    //   1121: invokevirtual 127	java/lang/String:length	()I
    //   1124: invokevirtual 221	java/lang/String:substring	(II)Ljava/lang/String;
    //   1127: invokevirtual 124	java/lang/String:trim	()Ljava/lang/String;
    //   1130: astore 9
    //   1132: aload 9
    //   1134: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1137: lstore 6
    //   1139: lload 6
    //   1141: lconst_0
    //   1142: lcmp
    //   1143: iflt -1094 -> 49
    //   1146: lconst_1
    //   1147: lload 6
    //   1149: ladd
    //   1150: lload 4
    //   1152: lcmp
    //   1153: ifle -1104 -> 49
    //   1156: lconst_1
    //   1157: lload 6
    //   1159: ladd
    //   1160: lstore 4
    //   1162: goto -1113 -> 49
    //   1165: aload 9
    //   1167: ldc_w 269
    //   1170: invokevirtual 213	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1173: ifeq -1124 -> 49
    //   1176: aload 9
    //   1178: bipush 58
    //   1180: invokevirtual 217	java/lang/String:indexOf	(I)I
    //   1183: istore_2
    //   1184: iload_2
    //   1185: iconst_1
    //   1186: if_icmple -1137 -> 49
    //   1189: aload 9
    //   1191: iload_2
    //   1192: iconst_1
    //   1193: iadd
    //   1194: aload 9
    //   1196: invokevirtual 127	java/lang/String:length	()I
    //   1199: invokevirtual 221	java/lang/String:substring	(II)Ljava/lang/String;
    //   1202: invokevirtual 124	java/lang/String:trim	()Ljava/lang/String;
    //   1205: astore 9
    //   1207: aload 9
    //   1209: invokestatic 275	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   1212: fstore_1
    //   1213: fload_1
    //   1214: fload_0
    //   1215: fcmpl
    //   1216: ifle +232 -> 1448
    //   1219: fload_1
    //   1220: fstore_0
    //   1221: goto -1172 -> 49
    //   1224: astore 8
    //   1226: aload 8
    //   1228: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   1231: lload 4
    //   1233: lstore 6
    //   1235: fload_0
    //   1236: fstore_1
    //   1237: goto -1150 -> 87
    //   1240: astore 9
    //   1242: aload 9
    //   1244: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   1247: goto -337 -> 910
    //   1250: lload 6
    //   1252: lconst_0
    //   1253: lcmp
    //   1254: ifle -1124 -> 130
    //   1257: lload 6
    //   1259: l2i
    //   1260: putstatic 29	lbk:jdField_b_of_type_Int	I
    //   1263: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1266: ifeq -1136 -> 130
    //   1269: aload 10
    //   1271: ldc_w 277
    //   1274: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1277: pop
    //   1278: aload 10
    //   1280: getstatic 29	lbk:jdField_b_of_type_Int	I
    //   1283: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1286: pop
    //   1287: aload 10
    //   1289: ldc 186
    //   1291: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1294: pop
    //   1295: goto -1165 -> 130
    //   1298: fload_1
    //   1299: fconst_0
    //   1300: fcmpl
    //   1301: ifle -1123 -> 178
    //   1304: fload_1
    //   1305: ldc_w 278
    //   1308: fcmpg
    //   1309: ifge +52 -> 1361
    //   1312: fload_1
    //   1313: f2d
    //   1314: ldc2_w 279
    //   1317: dmul
    //   1318: ldc2_w 281
    //   1321: dmul
    //   1322: d2l
    //   1323: putstatic 190	lbk:jdField_a_of_type_Long	J
    //   1326: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1329: ifeq -1151 -> 178
    //   1332: aload 10
    //   1334: ldc_w 284
    //   1337: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: pop
    //   1341: aload 10
    //   1343: getstatic 190	lbk:jdField_a_of_type_Long	J
    //   1346: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1349: pop
    //   1350: aload 10
    //   1352: ldc 186
    //   1354: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: pop
    //   1358: goto -1180 -> 178
    //   1361: fload_1
    //   1362: ldc_w 285
    //   1365: fcmpl
    //   1366: ifle +20 -> 1386
    //   1369: fload_1
    //   1370: f2d
    //   1371: ldc2_w 286
    //   1374: ddiv
    //   1375: ldc2_w 281
    //   1378: dmul
    //   1379: d2l
    //   1380: putstatic 190	lbk:jdField_a_of_type_Long	J
    //   1383: goto -57 -> 1326
    //   1386: ldc_w 288
    //   1389: fload_1
    //   1390: fmul
    //   1391: f2l
    //   1392: putstatic 190	lbk:jdField_a_of_type_Long	J
    //   1395: goto -69 -> 1326
    //   1398: iconst_1
    //   1399: putstatic 172	lbk:jdField_a_of_type_Boolean	Z
    //   1402: goto -1158 -> 244
    //   1405: astore 9
    //   1407: goto -1358 -> 49
    //   1410: astore 9
    //   1412: goto -1363 -> 49
    //   1415: astore 8
    //   1417: aconst_null
    //   1418: astore 9
    //   1420: goto -520 -> 900
    //   1423: astore 8
    //   1425: aconst_null
    //   1426: astore 8
    //   1428: goto -730 -> 698
    //   1431: astore 8
    //   1433: aconst_null
    //   1434: astore 8
    //   1436: goto -914 -> 522
    //   1439: astore 8
    //   1441: aload 9
    //   1443: astore 8
    //   1445: goto -1064 -> 381
    //   1448: goto -227 -> 1221
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	1218	0	f1	float
    //   70	1320	1	f2	float
    //   90	1104	2	j	int
    //   760	4	3	k	int
    //   14	1218	4	l1	long
    //   67	1191	6	l2	long
    //   47	346	8	localBufferedReader	java.io.BufferedReader
    //   406	128	8	localIOException1	java.io.IOException
    //   547	163	8	localIOException2	java.io.IOException
    //   723	170	8	localIOException3	java.io.IOException
    //   898	13	8	localObject1	Object
    //   1224	3	8	localIOException4	java.io.IOException
    //   1415	1	8	localObject2	Object
    //   1423	1	8	localNumberFormatException1	java.lang.NumberFormatException
    //   1426	1	8	localObject3	Object
    //   1431	1	8	localIOException5	java.io.IOException
    //   1434	1	8	localObject4	Object
    //   1439	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   1443	1	8	localObject5	Object
    //   9	347	9	str1	String
    //   379	125	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   520	160	9	localIOException6	java.io.IOException
    //   696	178	9	localNumberFormatException2	java.lang.NumberFormatException
    //   894	314	9	localObject6	Object
    //   1240	3	9	localIOException7	java.io.IOException
    //   1405	1	9	localNumberFormatException3	java.lang.NumberFormatException
    //   1410	1	9	localNumberFormatException4	java.lang.NumberFormatException
    //   1418	24	9	localObject7	Object
    //   29	851	10	localStringBuilder	java.lang.StringBuilder
    //   890	461	10	localObject8	Object
    //   602	168	11	str2	String
    //   751	1	12	localNumberFormatException5	java.lang.NumberFormatException
    //   789	1	12	localNumberFormatException6	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   49	56	379	java/io/FileNotFoundException
    //   61	65	379	java/io/FileNotFoundException
    //   327	345	379	java/io/FileNotFoundException
    //   350	376	379	java/io/FileNotFoundException
    //   422	440	379	java/io/FileNotFoundException
    //   445	517	379	java/io/FileNotFoundException
    //   563	581	379	java/io/FileNotFoundException
    //   586	604	379	java/io/FileNotFoundException
    //   609	632	379	java/io/FileNotFoundException
    //   632	646	379	java/io/FileNotFoundException
    //   646	693	379	java/io/FileNotFoundException
    //   739	748	379	java/io/FileNotFoundException
    //   755	761	379	java/io/FileNotFoundException
    //   766	786	379	java/io/FileNotFoundException
    //   798	816	379	java/io/FileNotFoundException
    //   821	840	379	java/io/FileNotFoundException
    //   840	887	379	java/io/FileNotFoundException
    //   913	931	379	java/io/FileNotFoundException
    //   936	955	379	java/io/FileNotFoundException
    //   955	1003	379	java/io/FileNotFoundException
    //   1006	1039	379	java/io/FileNotFoundException
    //   1039	1087	379	java/io/FileNotFoundException
    //   1090	1109	379	java/io/FileNotFoundException
    //   1114	1132	379	java/io/FileNotFoundException
    //   1132	1139	379	java/io/FileNotFoundException
    //   1165	1184	379	java/io/FileNotFoundException
    //   1189	1207	379	java/io/FileNotFoundException
    //   1207	1213	379	java/io/FileNotFoundException
    //   392	397	406	java/io/IOException
    //   49	56	520	java/io/IOException
    //   61	65	520	java/io/IOException
    //   327	345	520	java/io/IOException
    //   350	376	520	java/io/IOException
    //   422	440	520	java/io/IOException
    //   445	517	520	java/io/IOException
    //   563	581	520	java/io/IOException
    //   586	604	520	java/io/IOException
    //   609	632	520	java/io/IOException
    //   632	646	520	java/io/IOException
    //   646	693	520	java/io/IOException
    //   739	748	520	java/io/IOException
    //   755	761	520	java/io/IOException
    //   766	786	520	java/io/IOException
    //   798	816	520	java/io/IOException
    //   821	840	520	java/io/IOException
    //   840	887	520	java/io/IOException
    //   913	931	520	java/io/IOException
    //   936	955	520	java/io/IOException
    //   955	1003	520	java/io/IOException
    //   1006	1039	520	java/io/IOException
    //   1039	1087	520	java/io/IOException
    //   1090	1109	520	java/io/IOException
    //   1114	1132	520	java/io/IOException
    //   1132	1139	520	java/io/IOException
    //   1165	1184	520	java/io/IOException
    //   1189	1207	520	java/io/IOException
    //   1207	1213	520	java/io/IOException
    //   533	538	547	java/io/IOException
    //   49	56	696	java/lang/NumberFormatException
    //   61	65	696	java/lang/NumberFormatException
    //   327	345	696	java/lang/NumberFormatException
    //   350	376	696	java/lang/NumberFormatException
    //   422	440	696	java/lang/NumberFormatException
    //   445	517	696	java/lang/NumberFormatException
    //   563	581	696	java/lang/NumberFormatException
    //   586	604	696	java/lang/NumberFormatException
    //   609	632	696	java/lang/NumberFormatException
    //   632	646	696	java/lang/NumberFormatException
    //   646	693	696	java/lang/NumberFormatException
    //   755	761	696	java/lang/NumberFormatException
    //   798	816	696	java/lang/NumberFormatException
    //   821	840	696	java/lang/NumberFormatException
    //   840	887	696	java/lang/NumberFormatException
    //   913	931	696	java/lang/NumberFormatException
    //   936	955	696	java/lang/NumberFormatException
    //   955	1003	696	java/lang/NumberFormatException
    //   1006	1039	696	java/lang/NumberFormatException
    //   1039	1087	696	java/lang/NumberFormatException
    //   1090	1109	696	java/lang/NumberFormatException
    //   1114	1132	696	java/lang/NumberFormatException
    //   1165	1184	696	java/lang/NumberFormatException
    //   1189	1207	696	java/lang/NumberFormatException
    //   709	714	723	java/io/IOException
    //   739	748	751	java/lang/NumberFormatException
    //   766	786	789	java/lang/NumberFormatException
    //   49	56	890	finally
    //   61	65	890	finally
    //   327	345	890	finally
    //   350	376	890	finally
    //   422	440	890	finally
    //   445	517	890	finally
    //   563	581	890	finally
    //   586	604	890	finally
    //   609	632	890	finally
    //   632	646	890	finally
    //   646	693	890	finally
    //   739	748	890	finally
    //   755	761	890	finally
    //   766	786	890	finally
    //   798	816	890	finally
    //   821	840	890	finally
    //   840	887	890	finally
    //   913	931	890	finally
    //   936	955	890	finally
    //   955	1003	890	finally
    //   1006	1039	890	finally
    //   1039	1087	890	finally
    //   1090	1109	890	finally
    //   1114	1132	890	finally
    //   1132	1139	890	finally
    //   1165	1184	890	finally
    //   1189	1207	890	finally
    //   1207	1213	890	finally
    //   76	81	1224	java/io/IOException
    //   905	910	1240	java/io/IOException
    //   1132	1139	1405	java/lang/NumberFormatException
    //   1207	1213	1410	java/lang/NumberFormatException
    //   31	49	1415	finally
    //   31	49	1423	java/lang/NumberFormatException
    //   31	49	1431	java/io/IOException
    //   31	49	1439	java/io/FileNotFoundException
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return true;
      if (i == 0) {
        i = e();
      }
      if (jdField_b_of_type_Long == 0L) {
        jdField_b_of_type_Long = c();
      }
    } while ((i <= 1) && (jdField_b_of_type_Long <= 1025000L));
    return false;
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      if ((jdField_b_of_type_JavaLangString == null) || (jdField_b_of_type_JavaLangString.equals(""))) {
        a();
      }
      int j = jdField_b_of_type_JavaLangString.indexOf(paramString);
      if (j > 0) {
        return true;
      }
    }
    catch (Exception paramString) {}
    return false;
  }
  
  static int b()
  {
    if (jdField_a_of_type_JavaLangString.contains("ARMv6")) {}
    do
    {
      return 2;
      if (Build.CPU_ABI.equalsIgnoreCase("armeabi-v7a")) {
        return 4;
      }
    } while (Build.CPU_ABI.equalsIgnoreCase("armeabi"));
    if ((jdField_a_of_type_Int == 7) && (jdField_b_of_type_JavaLangString.indexOf("neon") < 0))
    {
      long l = c();
      int j = e();
      if ((l < 1100000L) || (j < 2)) {
        return 3;
      }
    }
    if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
      return 7;
    }
    switch (jdField_a_of_type_Int)
    {
    case 6: 
    default: 
      if ((jdField_c_of_type_JavaLangString != null) && ((jdField_c_of_type_JavaLangString.equalsIgnoreCase("AuthenticAMD")) || (jdField_c_of_type_JavaLangString.equalsIgnoreCase("GenuineIntel")))) {
        return 7;
      }
      break;
    case 5: 
      return 1;
    case 7: 
      return 4;
    case 8: 
      return 5;
    }
    return 0;
  }
  
  /* Error */
  static long b()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: aconst_null
    //   3: astore 10
    //   5: new 86	java/io/BufferedReader
    //   8: dup
    //   9: new 88	java/io/FileReader
    //   12: dup
    //   13: ldc_w 333
    //   16: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   19: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   22: astore 9
    //   24: lload_3
    //   25: lstore_1
    //   26: aload 9
    //   28: ifnull +92 -> 120
    //   31: aload 9
    //   33: astore 7
    //   35: aload 9
    //   37: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore 8
    //   42: aload 8
    //   44: ifnull +262 -> 306
    //   47: aload 9
    //   49: astore 7
    //   51: aload 9
    //   53: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
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
    //   84: invokevirtual 221	java/lang/String:substring	(II)Ljava/lang/String;
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
    //   104: invokevirtual 127	java/lang/String:length	()I
    //   107: ifle +13 -> 120
    //   110: aload 9
    //   112: astore 7
    //   114: aload 8
    //   116: invokestatic 133	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   119: lstore_1
    //   120: lload_1
    //   121: lstore 5
    //   123: aload 9
    //   125: ifnull +11 -> 136
    //   128: aload 9
    //   130: invokevirtual 136	java/io/BufferedReader:close	()V
    //   133: lload_1
    //   134: lstore 5
    //   136: ldc 79
    //   138: new 90	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 335
    //   148: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: lload 5
    //   153: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   156: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 164	krx:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: lload 5
    //   164: lreturn
    //   165: aload 9
    //   167: astore 7
    //   169: aload 10
    //   171: bipush 9
    //   173: invokevirtual 217	java/lang/String:indexOf	(I)I
    //   176: istore_0
    //   177: goto -108 -> 69
    //   180: astore 7
    //   182: aload 7
    //   184: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   187: lload_1
    //   188: lstore 5
    //   190: goto -54 -> 136
    //   193: astore 10
    //   195: aconst_null
    //   196: astore 8
    //   198: aload 8
    //   200: astore 7
    //   202: ldc 79
    //   204: new 90	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 337
    //   214: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 10
    //   219: invokevirtual 153	java/lang/Exception:toString	()Ljava/lang/String;
    //   222: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 342	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   231: pop
    //   232: lload_3
    //   233: lstore 5
    //   235: aload 8
    //   237: ifnull -101 -> 136
    //   240: aload 8
    //   242: invokevirtual 136	java/io/BufferedReader:close	()V
    //   245: lload_3
    //   246: lstore 5
    //   248: goto -112 -> 136
    //   251: astore 7
    //   253: aload 7
    //   255: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   258: lload_3
    //   259: lstore 5
    //   261: goto -125 -> 136
    //   264: astore 8
    //   266: aconst_null
    //   267: astore 7
    //   269: aload 7
    //   271: ifnull +8 -> 279
    //   274: aload 7
    //   276: invokevirtual 136	java/io/BufferedReader:close	()V
    //   279: aload 8
    //   281: athrow
    //   282: astore 7
    //   284: aload 7
    //   286: invokevirtual 148	java/io/IOException:printStackTrace	()V
    //   289: goto -10 -> 279
    //   292: astore 8
    //   294: goto -25 -> 269
    //   297: astore 10
    //   299: aload 9
    //   301: astore 8
    //   303: goto -105 -> 198
    //   306: aload 10
    //   308: ifnonnull -143 -> 165
    //   311: iconst_m1
    //   312: istore_0
    //   313: goto -244 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   71	242	0	j	int
    //   25	163	1	l1	long
    //   1	258	3	l2	long
    //   121	139	5	l3	long
    //   33	135	7	localBufferedReader1	java.io.BufferedReader
    //   180	3	7	localIOException1	java.io.IOException
    //   200	1	7	localObject1	Object
    //   251	3	7	localIOException2	java.io.IOException
    //   267	8	7	localObject2	Object
    //   282	3	7	localIOException3	java.io.IOException
    //   40	201	8	localObject3	Object
    //   264	16	8	localObject4	Object
    //   292	1	8	localObject5	Object
    //   301	1	8	localBufferedReader2	java.io.BufferedReader
    //   22	278	9	localBufferedReader3	java.io.BufferedReader
    //   3	167	10	localObject6	Object
    //   193	25	10	localException1	Exception
    //   297	10	10	localException2	Exception
    //   56	7	11	str	String
    // Exception table:
    //   from	to	target	type
    //   128	133	180	java/io/IOException
    //   5	24	193	java/lang/Exception
    //   240	245	251	java/io/IOException
    //   5	24	264	finally
    //   274	279	282	java/io/IOException
    //   35	42	292	finally
    //   51	58	292	finally
    //   80	89	292	finally
    //   102	110	292	finally
    //   114	120	292	finally
    //   169	177	292	finally
    //   202	232	292	finally
    //   35	42	297	java/lang/Exception
    //   51	58	297	java/lang/Exception
    //   80	89	297	java/lang/Exception
    //   102	110	297	java/lang/Exception
    //   114	120	297	java/lang/Exception
    //   169	177	297	java/lang/Exception
  }
  
  public static String b()
  {
    return Build.MODEL;
  }
  
  public static boolean b()
  {
    return true;
  }
  
  public static long c()
  {
    a();
    krx.c("VcSystemInfo", "getMaxCpuFreq: " + Build.BRAND + "|" + Build.MODEL + "|" + jdField_a_of_type_Long);
    return jdField_a_of_type_Long;
  }
  
  public static String c()
  {
    return Build.MANUFACTURER + "_" + Build.MODEL;
  }
  
  public static boolean c()
  {
    return true;
  }
  
  public static String d()
  {
    a();
    return jdField_a_of_type_JavaLangString;
  }
  
  public static boolean d()
  {
    if (jdField_d_of_type_Int > 2) {}
    BaseApplication localBaseApplication;
    do
    {
      return true;
      localBaseApplication = BaseApplicationImpl.getContext();
    } while (UpdateAvSo.a(localBaseApplication, Boolean.valueOf(false)));
    if (QLog.isColorLevel()) {
      QLog.w("VcSystemInfo", 2, "EarlyDownload libs is not ready for armv6/armv5 device");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.v2q.downloadAvSo");
    localIntent.setPackage(localBaseApplication.getPackageName());
    localBaseApplication.sendBroadcast(localIntent);
    return false;
  }
  
  public static int e()
  {
    a();
    return jdField_b_of_type_Int;
  }
  
  public static String e()
  {
    a();
    return "prcs(" + jdField_a_of_type_JavaLangString + ") arch(" + jdField_a_of_type_Int + ") hard(" + jdField_d_of_type_JavaLangString + ") chip(" + jdField_d_of_type_Int + ") freq(" + jdField_a_of_type_Long + ") num(" + jdField_b_of_type_Int + ")";
  }
  
  public static boolean e()
  {
    return ((a("neon")) || (a("asimd"))) && (e() >= 2) && (f() >= 4);
  }
  
  public static int f()
  {
    a();
    return jdField_d_of_type_Int;
  }
  
  public static String f()
  {
    a();
    return "model(" + Build.MODEL + ") Mnfc(" + Build.MANUFACTURER + ") dev(" + Build.VERSION.INCREMENTAL + ") sdk(" + Build.VERSION.SDK_INT + ") gl(" + jdField_c_of_type_Int + ")";
  }
  
  public static boolean f()
  {
    a();
    return (jdField_d_of_type_Int >= 3) && (jdField_a_of_type_Long / 1000L >= 800L);
  }
  
  public static int g()
  {
    a();
    return jdField_c_of_type_Int;
  }
  
  public static String g()
  {
    a();
    return jdField_b_of_type_JavaLangString;
  }
  
  public static boolean g()
  {
    a();
    return jdField_d_of_type_Boolean;
  }
  
  public static String h()
  {
    a();
    return jdField_c_of_type_JavaLangString;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_e_of_type_Int = paramInt1;
    this.f = paramInt2;
  }
  
  public int c()
  {
    return 2;
  }
  
  public int d()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      if (str.equals("L")) {
        return 118;
      }
      if (Build.VERSION.SDK_INT == 20) {
        return 118;
      }
      if (Build.VERSION.SDK_INT <= 20)
      {
        int k = str.charAt(0);
        int m = str.charAt(2);
        int j = 0;
        if (str.length() >= 5) {
          j = str.charAt(4);
        }
        switch (k)
        {
        default: 
          return 200;
        case 49: 
          if (m == 49) {
            return 101;
          }
          if (m == 53) {
            return 102;
          }
          if (m == 54) {
            return 103;
          }
          break;
        case 50: 
          if (m == 48)
          {
            if (j == 49) {
              return 105;
            }
            return 104;
          }
          if (m == 49) {
            return 106;
          }
          if (m == 50)
          {
            if (j == 49) {
              return 108;
            }
            return 107;
          }
          if ((m == 51) && (j >= 48) && (j <= 57)) {
            return 109;
          }
          break;
        case 51: 
          if (m == 48) {
            return 110;
          }
          if (m == 49) {
            return 111;
          }
          if (m == 50) {
            return 112;
          }
          break;
        case 52: 
          if (m == 48) {
            return 113;
          }
          if (m == 49) {
            return 114;
          }
          if (m == 50) {
            return 115;
          }
          if (m == 51) {
            return 116;
          }
          if (m == 52) {
            return 117;
          }
          break;
        case 53: 
          if (m == 48) {
            return 118;
          }
          break;
        }
      }
    }
    catch (Exception localException) {}
    return 200;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lbk
 * JD-Core Version:    0.7.0.1
 */