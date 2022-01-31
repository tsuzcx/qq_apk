import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class lnz
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
  static long jdField_c_of_type_Long;
  static String jdField_c_of_type_JavaLangString;
  static boolean jdField_c_of_type_Boolean;
  static int jdField_d_of_type_Int;
  static String jdField_d_of_type_JavaLangString;
  static boolean jdField_d_of_type_Boolean;
  private static String jdField_e_of_type_JavaLangString;
  static boolean jdField_e_of_type_Boolean;
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
    jdField_c_of_type_Boolean = true;
    jdField_d_of_type_Boolean = true;
    a();
  }
  
  public lnz()
  {
    this.jdField_e_of_type_Int = 320;
  }
  
  static int a()
  {
    try
    {
      int j = new File("/sys/devices/system/cpu/").listFiles(new loa()).length;
      return j;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  /* Error */
  public static long a()
  {
    // Byte code:
    //   0: getstatic 73	lnz:jdField_b_of_type_Boolean	Z
    //   3: ifeq +7 -> 10
    //   6: getstatic 75	lnz:jdField_b_of_type_Long	J
    //   9: lreturn
    //   10: aconst_null
    //   11: astore_2
    //   12: new 77	java/io/BufferedReader
    //   15: dup
    //   16: new 79	java/io/FileReader
    //   19: dup
    //   20: ldc 81
    //   22: invokespecial 82	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   25: invokespecial 85	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_3
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: invokevirtual 89	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   35: astore 4
    //   37: aload 4
    //   39: ifnonnull +21 -> 60
    //   42: aload_3
    //   43: astore_2
    //   44: iconst_1
    //   45: putstatic 73	lnz:jdField_b_of_type_Boolean	Z
    //   48: aload_3
    //   49: ifnull +7 -> 56
    //   52: aload_3
    //   53: invokevirtual 92	java/io/BufferedReader:close	()V
    //   56: getstatic 75	lnz:jdField_b_of_type_Long	J
    //   59: lreturn
    //   60: aload_3
    //   61: astore_2
    //   62: aload 4
    //   64: ldc 94
    //   66: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   69: ifeq -40 -> 29
    //   72: aload_3
    //   73: astore_2
    //   74: aload 4
    //   76: bipush 58
    //   78: invokevirtual 104	java/lang/String:indexOf	(I)I
    //   81: istore_0
    //   82: iload_0
    //   83: iconst_1
    //   84: if_icmple -42 -> 42
    //   87: aload_3
    //   88: astore_2
    //   89: aload 4
    //   91: iload_0
    //   92: iconst_1
    //   93: iadd
    //   94: aload 4
    //   96: invokevirtual 107	java/lang/String:length	()I
    //   99: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   102: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   105: astore 5
    //   107: iconst_0
    //   108: istore_0
    //   109: aload_3
    //   110: astore_2
    //   111: iload_0
    //   112: aload 4
    //   114: invokevirtual 107	java/lang/String:length	()I
    //   117: if_icmpge +161 -> 278
    //   120: iload_0
    //   121: istore_1
    //   122: aload_3
    //   123: astore_2
    //   124: aload 5
    //   126: iload_0
    //   127: invokevirtual 118	java/lang/String:charAt	(I)C
    //   130: bipush 48
    //   132: if_icmplt +18 -> 150
    //   135: aload_3
    //   136: astore_2
    //   137: aload 5
    //   139: iload_0
    //   140: invokevirtual 118	java/lang/String:charAt	(I)C
    //   143: bipush 57
    //   145: if_icmple +77 -> 222
    //   148: iload_0
    //   149: istore_1
    //   150: aload_3
    //   151: astore_2
    //   152: aload 5
    //   154: iconst_0
    //   155: iload_1
    //   156: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   159: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   162: astore 4
    //   164: aload 4
    //   166: ifnull -124 -> 42
    //   169: aload_3
    //   170: astore_2
    //   171: aload 4
    //   173: invokevirtual 107	java/lang/String:length	()I
    //   176: ifle -134 -> 42
    //   179: aload_3
    //   180: astore_2
    //   181: aload 4
    //   183: invokestatic 124	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   186: putstatic 75	lnz:jdField_b_of_type_Long	J
    //   189: goto -147 -> 42
    //   192: astore_2
    //   193: aload_3
    //   194: astore_2
    //   195: ldc 126
    //   197: iconst_1
    //   198: ldc 128
    //   200: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload_3
    //   204: ifnull -148 -> 56
    //   207: aload_3
    //   208: invokevirtual 92	java/io/BufferedReader:close	()V
    //   211: goto -155 -> 56
    //   214: astore_2
    //   215: aload_2
    //   216: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   219: goto -163 -> 56
    //   222: iload_0
    //   223: iconst_1
    //   224: iadd
    //   225: istore_0
    //   226: goto -117 -> 109
    //   229: astore_2
    //   230: aload_2
    //   231: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   234: goto -178 -> 56
    //   237: astore 4
    //   239: aload_2
    //   240: astore_3
    //   241: aload 4
    //   243: astore_2
    //   244: aload_3
    //   245: ifnull +7 -> 252
    //   248: aload_3
    //   249: invokevirtual 92	java/io/BufferedReader:close	()V
    //   252: aload_2
    //   253: athrow
    //   254: astore_3
    //   255: aload_3
    //   256: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   259: goto -7 -> 252
    //   262: astore 4
    //   264: aload_2
    //   265: astore_3
    //   266: aload 4
    //   268: astore_2
    //   269: goto -25 -> 244
    //   272: astore_2
    //   273: aconst_null
    //   274: astore_3
    //   275: goto -82 -> 193
    //   278: iconst_0
    //   279: istore_1
    //   280: goto -130 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   81	145	0	j	int
    //   121	159	1	k	int
    //   11	170	2	localObject1	Object
    //   192	1	2	localException1	Exception
    //   194	1	2	localObject2	Object
    //   214	2	2	localIOException1	java.io.IOException
    //   229	11	2	localIOException2	java.io.IOException
    //   243	26	2	localObject3	Object
    //   272	1	2	localException2	Exception
    //   28	221	3	localObject4	Object
    //   254	2	3	localIOException3	java.io.IOException
    //   265	10	3	localObject5	Object
    //   35	147	4	str1	String
    //   237	5	4	localObject6	Object
    //   262	5	4	localObject7	Object
    //   105	48	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   31	37	192	java/lang/Exception
    //   44	48	192	java/lang/Exception
    //   62	72	192	java/lang/Exception
    //   74	82	192	java/lang/Exception
    //   89	107	192	java/lang/Exception
    //   111	120	192	java/lang/Exception
    //   124	135	192	java/lang/Exception
    //   137	148	192	java/lang/Exception
    //   152	164	192	java/lang/Exception
    //   171	179	192	java/lang/Exception
    //   181	189	192	java/lang/Exception
    //   207	211	214	java/io/IOException
    //   52	56	229	java/io/IOException
    //   12	29	237	finally
    //   248	252	254	java/io/IOException
    //   31	37	262	finally
    //   44	48	262	finally
    //   62	72	262	finally
    //   74	82	262	finally
    //   89	107	262	finally
    //   111	120	262	finally
    //   124	135	262	finally
    //   137	148	262	finally
    //   152	164	262	finally
    //   171	179	262	finally
    //   181	189	262	finally
    //   195	203	262	finally
    //   12	29	272	java/lang/Exception
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
    //   0: getstatic 144	lnz:jdField_a_of_type_Boolean	Z
    //   3: iconst_1
    //   4: if_icmpne +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 9
    //   11: ldc2_w 145
    //   14: lstore 4
    //   16: ldc 147
    //   18: fstore_0
    //   19: new 149	java/lang/StringBuilder
    //   22: dup
    //   23: sipush 1024
    //   26: invokespecial 152	java/lang/StringBuilder:<init>	(I)V
    //   29: astore 10
    //   31: new 77	java/io/BufferedReader
    //   34: dup
    //   35: new 79	java/io/FileReader
    //   38: dup
    //   39: ldc 154
    //   41: invokespecial 82	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   44: invokespecial 85	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   47: astore 8
    //   49: aload 8
    //   51: invokevirtual 89	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore 9
    //   56: aload 9
    //   58: ifnonnull +269 -> 327
    //   61: iconst_1
    //   62: putstatic 144	lnz:jdField_a_of_type_Boolean	Z
    //   65: lload 4
    //   67: lstore 6
    //   69: fload_0
    //   70: fstore_1
    //   71: aload 8
    //   73: ifnull +14 -> 87
    //   76: aload 8
    //   78: invokevirtual 92	java/io/BufferedReader:close	()V
    //   81: fload_0
    //   82: fstore_1
    //   83: lload 4
    //   85: lstore 6
    //   87: invokestatic 156	lnz:a	()I
    //   90: istore_2
    //   91: iload_2
    //   92: ifle +1153 -> 1245
    //   95: iload_2
    //   96: putstatic 29	lnz:jdField_b_of_type_Int	I
    //   99: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +28 -> 130
    //   105: aload 10
    //   107: ldc 162
    //   109: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 10
    //   115: getstatic 29	lnz:jdField_b_of_type_Int	I
    //   118: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 10
    //   124: ldc 171
    //   126: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: invokestatic 173	lnz:b	()J
    //   133: lstore 4
    //   135: lload 4
    //   137: lconst_0
    //   138: lcmp
    //   139: ifle +1154 -> 1293
    //   142: lload 4
    //   144: putstatic 175	lnz:jdField_a_of_type_Long	J
    //   147: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +28 -> 178
    //   153: aload 10
    //   155: ldc 177
    //   157: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 10
    //   163: getstatic 175	lnz:jdField_a_of_type_Long	J
    //   166: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 10
    //   172: ldc 171
    //   174: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: getstatic 29	lnz:jdField_b_of_type_Int	I
    //   181: ifle +11 -> 192
    //   184: getstatic 175	lnz:jdField_a_of_type_Long	J
    //   187: lconst_0
    //   188: lcmp
    //   189: ifgt +1204 -> 1393
    //   192: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +45 -> 240
    //   198: aload 10
    //   200: ldc 182
    //   202: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 10
    //   208: getstatic 29	lnz:jdField_b_of_type_Int	I
    //   211: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 10
    //   217: ldc 184
    //   219: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 10
    //   225: getstatic 175	lnz:jdField_a_of_type_Long	J
    //   228: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 10
    //   234: ldc 171
    //   236: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: iconst_0
    //   241: putstatic 144	lnz:jdField_a_of_type_Boolean	Z
    //   244: invokestatic 186	lnz:b	()I
    //   247: putstatic 33	lnz:jdField_d_of_type_Int	I
    //   250: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq -246 -> 7
    //   256: aload 10
    //   258: ldc 188
    //   260: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 10
    //   266: getstatic 33	lnz:jdField_d_of_type_Int	I
    //   269: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 10
    //   275: ldc 190
    //   277: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 10
    //   283: getstatic 37	lnz:jdField_d_of_type_Boolean	Z
    //   286: invokevirtual 193	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 10
    //   292: ldc 195
    //   294: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 10
    //   300: getstatic 35	lnz:jdField_c_of_type_Boolean	Z
    //   303: invokevirtual 193	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 10
    //   309: ldc 171
    //   311: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: ldc 126
    //   317: iconst_2
    //   318: aload 10
    //   320: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: return
    //   327: aload 9
    //   329: ldc 200
    //   331: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   334: ifeq +88 -> 422
    //   337: aload 9
    //   339: bipush 58
    //   341: invokevirtual 104	java/lang/String:indexOf	(I)I
    //   344: istore_2
    //   345: iload_2
    //   346: iconst_1
    //   347: if_icmple -298 -> 49
    //   350: aload 9
    //   352: iload_2
    //   353: iconst_1
    //   354: iadd
    //   355: aload 9
    //   357: invokevirtual 107	java/lang/String:length	()I
    //   360: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   363: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   366: ldc 202
    //   368: ldc 21
    //   370: invokevirtual 206	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   373: putstatic 138	lnz:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   376: goto -327 -> 49
    //   379: astore 9
    //   381: lload 4
    //   383: lstore 6
    //   385: fload_0
    //   386: fstore_1
    //   387: aload 8
    //   389: ifnull -302 -> 87
    //   392: aload 8
    //   394: invokevirtual 92	java/io/BufferedReader:close	()V
    //   397: lload 4
    //   399: lstore 6
    //   401: fload_0
    //   402: fstore_1
    //   403: goto -316 -> 87
    //   406: astore 8
    //   408: aload 8
    //   410: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   413: lload 4
    //   415: lstore 6
    //   417: fload_0
    //   418: fstore_1
    //   419: goto -332 -> 87
    //   422: aload 9
    //   424: ldc 208
    //   426: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   429: ifeq +134 -> 563
    //   432: aload 9
    //   434: bipush 58
    //   436: invokevirtual 104	java/lang/String:indexOf	(I)I
    //   439: istore_2
    //   440: iload_2
    //   441: iconst_1
    //   442: if_icmple -393 -> 49
    //   445: aload 9
    //   447: iload_2
    //   448: iconst_1
    //   449: iadd
    //   450: aload 9
    //   452: invokevirtual 107	java/lang/String:length	()I
    //   455: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   458: putstatic 23	lnz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   461: getstatic 23	lnz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   464: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   467: putstatic 23	lnz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   470: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   473: ifeq -424 -> 49
    //   476: aload 10
    //   478: ldc 210
    //   480: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 10
    //   486: getstatic 23	lnz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   489: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload 10
    //   495: ldc 212
    //   497: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 10
    //   503: aload 9
    //   505: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload 10
    //   511: ldc 171
    //   513: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   535: invokevirtual 92	java/io/BufferedReader:close	()V
    //   538: lload 4
    //   540: lstore 6
    //   542: fload_0
    //   543: fstore_1
    //   544: goto -457 -> 87
    //   547: astore 8
    //   549: aload 8
    //   551: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   554: lload 4
    //   556: lstore 6
    //   558: fload_0
    //   559: fstore_1
    //   560: goto -473 -> 87
    //   563: aload 9
    //   565: ldc 214
    //   567: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   570: ifeq +228 -> 798
    //   573: aload 9
    //   575: bipush 58
    //   577: invokevirtual 104	java/lang/String:indexOf	(I)I
    //   580: istore_2
    //   581: iload_2
    //   582: iconst_1
    //   583: if_icmple +49 -> 632
    //   586: aload 9
    //   588: iload_2
    //   589: iconst_1
    //   590: iadd
    //   591: aload 9
    //   593: invokevirtual 107	java/lang/String:length	()I
    //   596: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   599: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   602: astore 11
    //   604: aload 11
    //   606: ifnull +26 -> 632
    //   609: aload 11
    //   611: invokevirtual 107	java/lang/String:length	()I
    //   614: ifle +18 -> 632
    //   617: aload 11
    //   619: ldc 216
    //   621: invokevirtual 219	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   624: ifeq +115 -> 739
    //   627: bipush 8
    //   629: putstatic 27	lnz:jdField_a_of_type_Int	I
    //   632: aload 9
    //   634: ldc 221
    //   636: invokevirtual 225	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   639: ifeq +7 -> 646
    //   642: iconst_5
    //   643: putstatic 27	lnz:jdField_a_of_type_Int	I
    //   646: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   649: ifeq -600 -> 49
    //   652: aload 10
    //   654: ldc 227
    //   656: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: pop
    //   660: aload 10
    //   662: getstatic 27	lnz:jdField_a_of_type_Int	I
    //   665: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload 10
    //   671: ldc 212
    //   673: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 10
    //   679: aload 9
    //   681: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload 10
    //   687: ldc 171
    //   689: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   711: invokevirtual 92	java/io/BufferedReader:close	()V
    //   714: lload 4
    //   716: lstore 6
    //   718: fload_0
    //   719: fstore_1
    //   720: goto -633 -> 87
    //   723: astore 8
    //   725: aload 8
    //   727: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   730: lload 4
    //   732: lstore 6
    //   734: fload_0
    //   735: fstore_1
    //   736: goto -649 -> 87
    //   739: aload 11
    //   741: invokestatic 124	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   744: l2i
    //   745: putstatic 27	lnz:jdField_a_of_type_Int	I
    //   748: goto -116 -> 632
    //   751: astore 12
    //   753: iconst_1
    //   754: istore_2
    //   755: aload 11
    //   757: invokevirtual 107	java/lang/String:length	()I
    //   760: istore_3
    //   761: iload_2
    //   762: iload_3
    //   763: if_icmpge -131 -> 632
    //   766: aload 11
    //   768: iconst_0
    //   769: aload 11
    //   771: invokevirtual 107	java/lang/String:length	()I
    //   774: iload_2
    //   775: isub
    //   776: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   779: invokestatic 124	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   782: l2i
    //   783: putstatic 27	lnz:jdField_a_of_type_Int	I
    //   786: goto -154 -> 632
    //   789: astore 12
    //   791: iload_2
    //   792: iconst_1
    //   793: iadd
    //   794: istore_2
    //   795: goto -40 -> 755
    //   798: aload 9
    //   800: ldc 229
    //   802: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   805: ifeq +108 -> 913
    //   808: aload 9
    //   810: bipush 58
    //   812: invokevirtual 104	java/lang/String:indexOf	(I)I
    //   815: istore_2
    //   816: iload_2
    //   817: iconst_1
    //   818: if_icmple +22 -> 840
    //   821: aload 9
    //   823: iload_2
    //   824: iconst_1
    //   825: iadd
    //   826: aload 9
    //   828: invokevirtual 107	java/lang/String:length	()I
    //   831: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   834: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   837: putstatic 25	lnz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   840: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   843: ifeq -794 -> 49
    //   846: aload 10
    //   848: ldc 231
    //   850: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: pop
    //   854: aload 10
    //   856: getstatic 25	lnz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   859: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: pop
    //   863: aload 10
    //   865: ldc 212
    //   867: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: aload 10
    //   873: aload 9
    //   875: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: pop
    //   879: aload 10
    //   881: ldc 171
    //   883: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
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
    //   907: invokevirtual 92	java/io/BufferedReader:close	()V
    //   910: aload 8
    //   912: athrow
    //   913: aload 9
    //   915: ldc 233
    //   917: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   920: ifeq +85 -> 1005
    //   923: aload 9
    //   925: bipush 58
    //   927: invokevirtual 104	java/lang/String:indexOf	(I)I
    //   930: istore_2
    //   931: iload_2
    //   932: iconst_1
    //   933: if_icmple +22 -> 955
    //   936: aload 9
    //   938: iload_2
    //   939: iconst_1
    //   940: iadd
    //   941: aload 9
    //   943: invokevirtual 107	java/lang/String:length	()I
    //   946: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   949: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   952: putstatic 235	lnz:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   955: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   958: ifeq -909 -> 49
    //   961: aload 10
    //   963: ldc 237
    //   965: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: pop
    //   969: aload 10
    //   971: getstatic 235	lnz:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   974: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   977: pop
    //   978: aload 10
    //   980: ldc 212
    //   982: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: pop
    //   986: aload 10
    //   988: aload 9
    //   990: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: pop
    //   994: aload 10
    //   996: ldc 171
    //   998: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: pop
    //   1002: goto -953 -> 49
    //   1005: aload 9
    //   1007: ldc 200
    //   1009: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1012: ifeq +75 -> 1087
    //   1015: aload 9
    //   1017: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   1020: putstatic 239	lnz:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1023: aload 9
    //   1025: ldc 241
    //   1027: invokevirtual 225	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1030: ifeq +7 -> 1037
    //   1033: iconst_1
    //   1034: putstatic 243	lnz:jdField_e_of_type_Boolean	Z
    //   1037: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1040: ifeq -991 -> 49
    //   1043: aload 10
    //   1045: ldc 245
    //   1047: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: pop
    //   1051: aload 10
    //   1053: getstatic 243	lnz:jdField_e_of_type_Boolean	Z
    //   1056: invokevirtual 193	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1059: pop
    //   1060: aload 10
    //   1062: ldc 212
    //   1064: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: pop
    //   1068: aload 10
    //   1070: aload 9
    //   1072: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: pop
    //   1076: aload 10
    //   1078: ldc 171
    //   1080: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: pop
    //   1084: goto -1035 -> 49
    //   1087: aload 9
    //   1089: ldc 247
    //   1091: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1094: ifeq +67 -> 1161
    //   1097: aload 9
    //   1099: bipush 58
    //   1101: invokevirtual 104	java/lang/String:indexOf	(I)I
    //   1104: istore_2
    //   1105: iload_2
    //   1106: iconst_1
    //   1107: if_icmple -1058 -> 49
    //   1110: aload 9
    //   1112: iload_2
    //   1113: iconst_1
    //   1114: iadd
    //   1115: aload 9
    //   1117: invokevirtual 107	java/lang/String:length	()I
    //   1120: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   1123: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   1126: astore 9
    //   1128: aload 9
    //   1130: invokestatic 124	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1133: lstore 6
    //   1135: lload 6
    //   1137: lconst_0
    //   1138: lcmp
    //   1139: iflt -1090 -> 49
    //   1142: lconst_1
    //   1143: lload 6
    //   1145: ladd
    //   1146: lload 4
    //   1148: lcmp
    //   1149: ifle -1100 -> 49
    //   1152: lconst_1
    //   1153: lload 6
    //   1155: ladd
    //   1156: lstore 4
    //   1158: goto -1109 -> 49
    //   1161: aload 9
    //   1163: ldc 249
    //   1165: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1168: ifeq -1119 -> 49
    //   1171: aload 9
    //   1173: bipush 58
    //   1175: invokevirtual 104	java/lang/String:indexOf	(I)I
    //   1178: istore_2
    //   1179: iload_2
    //   1180: iconst_1
    //   1181: if_icmple -1132 -> 49
    //   1184: aload 9
    //   1186: iload_2
    //   1187: iconst_1
    //   1188: iadd
    //   1189: aload 9
    //   1191: invokevirtual 107	java/lang/String:length	()I
    //   1194: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   1197: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   1200: astore 9
    //   1202: aload 9
    //   1204: invokestatic 255	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   1207: fstore_1
    //   1208: fload_1
    //   1209: fload_0
    //   1210: fcmpl
    //   1211: ifle +232 -> 1443
    //   1214: fload_1
    //   1215: fstore_0
    //   1216: goto -1167 -> 49
    //   1219: astore 8
    //   1221: aload 8
    //   1223: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   1226: lload 4
    //   1228: lstore 6
    //   1230: fload_0
    //   1231: fstore_1
    //   1232: goto -1145 -> 87
    //   1235: astore 9
    //   1237: aload 9
    //   1239: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   1242: goto -332 -> 910
    //   1245: lload 6
    //   1247: lconst_0
    //   1248: lcmp
    //   1249: ifle -1119 -> 130
    //   1252: lload 6
    //   1254: l2i
    //   1255: putstatic 29	lnz:jdField_b_of_type_Int	I
    //   1258: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1261: ifeq -1131 -> 130
    //   1264: aload 10
    //   1266: ldc_w 257
    //   1269: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1272: pop
    //   1273: aload 10
    //   1275: getstatic 29	lnz:jdField_b_of_type_Int	I
    //   1278: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1281: pop
    //   1282: aload 10
    //   1284: ldc 171
    //   1286: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: pop
    //   1290: goto -1160 -> 130
    //   1293: fload_1
    //   1294: fconst_0
    //   1295: fcmpl
    //   1296: ifle -1118 -> 178
    //   1299: fload_1
    //   1300: ldc_w 258
    //   1303: fcmpg
    //   1304: ifge +52 -> 1356
    //   1307: fload_1
    //   1308: f2d
    //   1309: ldc2_w 259
    //   1312: dmul
    //   1313: ldc2_w 261
    //   1316: dmul
    //   1317: d2l
    //   1318: putstatic 175	lnz:jdField_a_of_type_Long	J
    //   1321: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1324: ifeq -1146 -> 178
    //   1327: aload 10
    //   1329: ldc_w 264
    //   1332: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1335: pop
    //   1336: aload 10
    //   1338: getstatic 175	lnz:jdField_a_of_type_Long	J
    //   1341: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1344: pop
    //   1345: aload 10
    //   1347: ldc 171
    //   1349: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1352: pop
    //   1353: goto -1175 -> 178
    //   1356: fload_1
    //   1357: ldc_w 265
    //   1360: fcmpl
    //   1361: ifle +20 -> 1381
    //   1364: fload_1
    //   1365: f2d
    //   1366: ldc2_w 266
    //   1369: ddiv
    //   1370: ldc2_w 261
    //   1373: dmul
    //   1374: d2l
    //   1375: putstatic 175	lnz:jdField_a_of_type_Long	J
    //   1378: goto -57 -> 1321
    //   1381: ldc_w 268
    //   1384: fload_1
    //   1385: fmul
    //   1386: f2l
    //   1387: putstatic 175	lnz:jdField_a_of_type_Long	J
    //   1390: goto -69 -> 1321
    //   1393: iconst_1
    //   1394: putstatic 144	lnz:jdField_a_of_type_Boolean	Z
    //   1397: goto -1153 -> 244
    //   1400: astore 9
    //   1402: goto -1353 -> 49
    //   1405: astore 9
    //   1407: goto -1358 -> 49
    //   1410: astore 8
    //   1412: aconst_null
    //   1413: astore 9
    //   1415: goto -515 -> 900
    //   1418: astore 8
    //   1420: aconst_null
    //   1421: astore 8
    //   1423: goto -725 -> 698
    //   1426: astore 8
    //   1428: aconst_null
    //   1429: astore 8
    //   1431: goto -909 -> 522
    //   1434: astore 8
    //   1436: aload 9
    //   1438: astore 8
    //   1440: goto -1059 -> 381
    //   1443: goto -227 -> 1216
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	1213	0	f1	float
    //   70	1315	1	f2	float
    //   90	1099	2	j	int
    //   760	4	3	k	int
    //   14	1213	4	l1	long
    //   67	1186	6	l2	long
    //   47	346	8	localBufferedReader	java.io.BufferedReader
    //   406	128	8	localIOException1	java.io.IOException
    //   547	163	8	localIOException2	java.io.IOException
    //   723	170	8	localIOException3	java.io.IOException
    //   898	13	8	localObject1	Object
    //   1219	3	8	localIOException4	java.io.IOException
    //   1410	1	8	localObject2	Object
    //   1418	1	8	localNumberFormatException1	java.lang.NumberFormatException
    //   1421	1	8	localObject3	Object
    //   1426	1	8	localIOException5	java.io.IOException
    //   1429	1	8	localObject4	Object
    //   1434	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   1438	1	8	localObject5	Object
    //   9	347	9	str1	String
    //   379	125	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   520	160	9	localIOException6	java.io.IOException
    //   696	178	9	localNumberFormatException2	java.lang.NumberFormatException
    //   894	309	9	localObject6	Object
    //   1235	3	9	localIOException7	java.io.IOException
    //   1400	1	9	localNumberFormatException3	java.lang.NumberFormatException
    //   1405	1	9	localNumberFormatException4	java.lang.NumberFormatException
    //   1413	24	9	localObject7	Object
    //   29	851	10	localStringBuilder	java.lang.StringBuilder
    //   890	456	10	localObject8	Object
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
    //   955	1002	379	java/io/FileNotFoundException
    //   1005	1037	379	java/io/FileNotFoundException
    //   1037	1084	379	java/io/FileNotFoundException
    //   1087	1105	379	java/io/FileNotFoundException
    //   1110	1128	379	java/io/FileNotFoundException
    //   1128	1135	379	java/io/FileNotFoundException
    //   1161	1179	379	java/io/FileNotFoundException
    //   1184	1202	379	java/io/FileNotFoundException
    //   1202	1208	379	java/io/FileNotFoundException
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
    //   955	1002	520	java/io/IOException
    //   1005	1037	520	java/io/IOException
    //   1037	1084	520	java/io/IOException
    //   1087	1105	520	java/io/IOException
    //   1110	1128	520	java/io/IOException
    //   1128	1135	520	java/io/IOException
    //   1161	1179	520	java/io/IOException
    //   1184	1202	520	java/io/IOException
    //   1202	1208	520	java/io/IOException
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
    //   955	1002	696	java/lang/NumberFormatException
    //   1005	1037	696	java/lang/NumberFormatException
    //   1037	1084	696	java/lang/NumberFormatException
    //   1087	1105	696	java/lang/NumberFormatException
    //   1110	1128	696	java/lang/NumberFormatException
    //   1161	1179	696	java/lang/NumberFormatException
    //   1184	1202	696	java/lang/NumberFormatException
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
    //   955	1002	890	finally
    //   1005	1037	890	finally
    //   1037	1084	890	finally
    //   1087	1105	890	finally
    //   1110	1128	890	finally
    //   1128	1135	890	finally
    //   1161	1179	890	finally
    //   1184	1202	890	finally
    //   1202	1208	890	finally
    //   76	81	1219	java/io/IOException
    //   905	910	1235	java/io/IOException
    //   1128	1135	1400	java/lang/NumberFormatException
    //   1202	1208	1405	java/lang/NumberFormatException
    //   31	49	1410	finally
    //   31	49	1418	java/lang/NumberFormatException
    //   31	49	1426	java/io/IOException
    //   31	49	1434	java/io/FileNotFoundException
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
      if (jdField_c_of_type_Long == 0L) {
        jdField_c_of_type_Long = d();
      }
    } while ((i <= 1) && (jdField_c_of_type_Long <= 1025000L));
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
      long l = d();
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
    //   0: iconst_0
    //   1: istore_1
    //   2: getstatic 29	lnz:jdField_b_of_type_Int	I
    //   5: iconst_1
    //   6: if_icmpge +23 -> 29
    //   9: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: ldc 126
    //   17: iconst_2
    //   18: ldc_w 313
    //   21: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: bipush 8
    //   26: putstatic 29	lnz:jdField_b_of_type_Int	I
    //   29: iconst_0
    //   30: istore_2
    //   31: lconst_0
    //   32: lstore 5
    //   34: lconst_0
    //   35: lstore_3
    //   36: iload_1
    //   37: getstatic 29	lnz:jdField_b_of_type_Int	I
    //   40: if_icmpge +320 -> 360
    //   43: aconst_null
    //   44: astore 12
    //   46: new 77	java/io/BufferedReader
    //   49: dup
    //   50: new 79	java/io/FileReader
    //   53: dup
    //   54: new 149	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 316
    //   64: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload_1
    //   68: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: ldc_w 318
    //   74: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 82	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   83: invokespecial 85	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   86: astore 11
    //   88: lload_3
    //   89: lstore 7
    //   91: aload 11
    //   93: ifnull +51 -> 144
    //   96: aload 11
    //   98: invokevirtual 89	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   101: astore 12
    //   103: aload 12
    //   105: invokestatic 323	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: ifne +340 -> 448
    //   111: aload 12
    //   113: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   116: astore 12
    //   118: lload_3
    //   119: lstore 7
    //   121: aload 12
    //   123: ifnull +21 -> 144
    //   126: lload_3
    //   127: lstore 7
    //   129: aload 12
    //   131: invokevirtual 107	java/lang/String:length	()I
    //   134: ifle +10 -> 144
    //   137: aload 12
    //   139: invokestatic 124	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   142: lstore 7
    //   144: iload_2
    //   145: istore_0
    //   146: lload 7
    //   148: lstore_3
    //   149: aload 11
    //   151: ifnull +13 -> 164
    //   154: aload 11
    //   156: invokevirtual 92	java/io/BufferedReader:close	()V
    //   159: lload 7
    //   161: lstore_3
    //   162: iload_2
    //   163: istore_0
    //   164: lload 5
    //   166: lstore 7
    //   168: lload_3
    //   169: lload 5
    //   171: lcmp
    //   172: ifle +6 -> 178
    //   175: lload_3
    //   176: lstore 7
    //   178: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   181: ifeq +50 -> 231
    //   184: ldc 126
    //   186: iconst_2
    //   187: new 149	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 325
    //   197: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: iload_1
    //   201: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: ldc_w 327
    //   207: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: lload_3
    //   211: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   214: ldc_w 329
    //   217: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: lload 7
    //   222: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   225: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: iload_1
    //   232: iconst_1
    //   233: iadd
    //   234: istore_1
    //   235: iload_0
    //   236: istore_2
    //   237: lload 7
    //   239: lstore 5
    //   241: goto -205 -> 36
    //   244: astore 11
    //   246: aload 11
    //   248: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   251: iload_2
    //   252: istore_0
    //   253: lload 7
    //   255: lstore_3
    //   256: goto -92 -> 164
    //   259: astore 12
    //   261: aconst_null
    //   262: astore 11
    //   264: ldc 126
    //   266: iconst_1
    //   267: new 149	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 331
    //   277: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: iload_1
    //   281: invokevirtual 169	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: ldc_w 333
    //   287: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 12
    //   292: invokevirtual 334	java/lang/Exception:toString	()Ljava/lang/String;
    //   295: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 336	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: aload 11
    //   306: ifnull +8 -> 314
    //   309: aload 11
    //   311: invokevirtual 92	java/io/BufferedReader:close	()V
    //   314: iconst_1
    //   315: istore_0
    //   316: lconst_0
    //   317: lstore_3
    //   318: goto -154 -> 164
    //   321: astore 11
    //   323: aload 11
    //   325: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   328: iconst_1
    //   329: istore_0
    //   330: lconst_0
    //   331: lstore_3
    //   332: goto -168 -> 164
    //   335: astore 11
    //   337: aload 12
    //   339: ifnull +8 -> 347
    //   342: aload 12
    //   344: invokevirtual 92	java/io/BufferedReader:close	()V
    //   347: aload 11
    //   349: athrow
    //   350: astore 12
    //   352: aload 12
    //   354: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   357: goto -10 -> 347
    //   360: lload 5
    //   362: lstore 7
    //   364: iload_2
    //   365: ifeq +23 -> 388
    //   368: invokestatic 338	lnz:c	()J
    //   371: lstore 9
    //   373: lload 5
    //   375: lstore 7
    //   377: lload 9
    //   379: lload_3
    //   380: lcmp
    //   381: ifle +7 -> 388
    //   384: lload 9
    //   386: lstore 7
    //   388: ldc 126
    //   390: new 149	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   397: ldc_w 340
    //   400: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: lload 7
    //   405: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   408: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokestatic 345	lek:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   414: lload 7
    //   416: lreturn
    //   417: astore 13
    //   419: aload 11
    //   421: astore 12
    //   423: aload 13
    //   425: astore 11
    //   427: goto -90 -> 337
    //   430: astore 13
    //   432: aload 11
    //   434: astore 12
    //   436: aload 13
    //   438: astore 11
    //   440: goto -103 -> 337
    //   443: astore 12
    //   445: goto -181 -> 264
    //   448: ldc 21
    //   450: astore 12
    //   452: goto -334 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   145	185	0	j	int
    //   1	280	1	k	int
    //   30	335	2	m	int
    //   35	345	3	l1	long
    //   32	342	5	l2	long
    //   89	326	7	l3	long
    //   371	14	9	l4	long
    //   86	69	11	localBufferedReader	java.io.BufferedReader
    //   244	3	11	localIOException1	java.io.IOException
    //   262	48	11	localObject1	Object
    //   321	3	11	localIOException2	java.io.IOException
    //   335	85	11	localObject2	Object
    //   425	14	11	localObject3	Object
    //   44	94	12	str1	String
    //   259	84	12	localException1	Exception
    //   350	3	12	localIOException3	java.io.IOException
    //   421	14	12	localObject4	Object
    //   443	1	12	localException2	Exception
    //   450	1	12	str2	String
    //   417	7	13	localObject5	Object
    //   430	7	13	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   154	159	244	java/io/IOException
    //   46	88	259	java/lang/Exception
    //   309	314	321	java/io/IOException
    //   46	88	335	finally
    //   342	347	350	java/io/IOException
    //   96	118	417	finally
    //   129	144	417	finally
    //   264	304	430	finally
    //   96	118	443	java/lang/Exception
    //   129	144	443	java/lang/Exception
  }
  
  public static String b()
  {
    return Build.MODEL;
  }
  
  public static boolean b()
  {
    return true;
  }
  
  /* Error */
  static long c()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: aconst_null
    //   3: astore 10
    //   5: new 77	java/io/BufferedReader
    //   8: dup
    //   9: new 79	java/io/FileReader
    //   12: dup
    //   13: ldc_w 350
    //   16: invokespecial 82	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   19: invokespecial 85	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   22: astore 9
    //   24: lload_3
    //   25: lstore_1
    //   26: aload 9
    //   28: ifnull +92 -> 120
    //   31: aload 9
    //   33: astore 7
    //   35: aload 9
    //   37: invokevirtual 89	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore 8
    //   42: aload 8
    //   44: ifnull +262 -> 306
    //   47: aload 9
    //   49: astore 7
    //   51: aload 9
    //   53: invokevirtual 89	java/io/BufferedReader:readLine	()Ljava/lang/String;
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
    //   84: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
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
    //   104: invokevirtual 107	java/lang/String:length	()I
    //   107: ifle +13 -> 120
    //   110: aload 9
    //   112: astore 7
    //   114: aload 8
    //   116: invokestatic 124	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   119: lstore_1
    //   120: lload_1
    //   121: lstore 5
    //   123: aload 9
    //   125: ifnull +11 -> 136
    //   128: aload 9
    //   130: invokevirtual 92	java/io/BufferedReader:close	()V
    //   133: lload_1
    //   134: lstore 5
    //   136: ldc 126
    //   138: new 149	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 352
    //   148: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: lload 5
    //   153: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   156: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 345	lek:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: lload 5
    //   164: lreturn
    //   165: aload 9
    //   167: astore 7
    //   169: aload 10
    //   171: bipush 9
    //   173: invokevirtual 104	java/lang/String:indexOf	(I)I
    //   176: istore_0
    //   177: goto -108 -> 69
    //   180: astore 7
    //   182: aload 7
    //   184: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   187: lload_1
    //   188: lstore 5
    //   190: goto -54 -> 136
    //   193: astore 10
    //   195: aconst_null
    //   196: astore 8
    //   198: aload 8
    //   200: astore 7
    //   202: ldc 126
    //   204: new 149	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 354
    //   214: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 10
    //   219: invokevirtual 334	java/lang/Exception:toString	()Ljava/lang/String;
    //   222: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 359	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   231: pop
    //   232: lload_3
    //   233: lstore 5
    //   235: aload 8
    //   237: ifnull -101 -> 136
    //   240: aload 8
    //   242: invokevirtual 92	java/io/BufferedReader:close	()V
    //   245: lload_3
    //   246: lstore 5
    //   248: goto -112 -> 136
    //   251: astore 7
    //   253: aload 7
    //   255: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   258: lload_3
    //   259: lstore 5
    //   261: goto -125 -> 136
    //   264: astore 8
    //   266: aconst_null
    //   267: astore 7
    //   269: aload 7
    //   271: ifnull +8 -> 279
    //   274: aload 7
    //   276: invokevirtual 92	java/io/BufferedReader:close	()V
    //   279: aload 8
    //   281: athrow
    //   282: astore 7
    //   284: aload 7
    //   286: invokevirtual 136	java/io/IOException:printStackTrace	()V
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
  
  public static String c()
  {
    return Build.MANUFACTURER + "_" + Build.MODEL;
  }
  
  public static boolean c()
  {
    return true;
  }
  
  public static long d()
  {
    a();
    lek.c("VcSystemInfo", "getMaxCpuFreq: " + Build.BRAND + "|" + Build.MODEL + "|" + jdField_a_of_type_Long);
    return jdField_a_of_type_Long;
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
    return jdField_e_of_type_Boolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lnz
 * JD-Core Version:    0.7.0.1
 */