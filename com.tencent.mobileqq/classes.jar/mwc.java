import android.os.Build;
import android.os.Build.VERSION;
import java.io.File;

public class mwc
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
    jdField_a_of_type_Int = 5;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 1;
    jdField_c_of_type_Boolean = true;
    jdField_d_of_type_Boolean = true;
    a();
  }
  
  public mwc()
  {
    this.jdField_e_of_type_Int = 320;
  }
  
  static int a()
  {
    try
    {
      int j = new File("/sys/devices/system/cpu/").listFiles(new mwd()).length;
      return j;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  /* Error */
  public static long a()
  {
    // Byte code:
    //   0: getstatic 73	mwc:jdField_b_of_type_Boolean	Z
    //   3: ifeq +7 -> 10
    //   6: getstatic 75	mwc:jdField_b_of_type_Long	J
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
    //   45: putstatic 73	mwc:jdField_b_of_type_Boolean	Z
    //   48: aload_3
    //   49: ifnull +7 -> 56
    //   52: aload_3
    //   53: invokevirtual 92	java/io/BufferedReader:close	()V
    //   56: getstatic 75	mwc:jdField_b_of_type_Long	J
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
    //   117: if_icmpge +160 -> 277
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
    //   145: if_icmple +76 -> 221
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
    //   186: putstatic 75	mwc:jdField_b_of_type_Long	J
    //   189: goto -147 -> 42
    //   192: astore_2
    //   193: aload_3
    //   194: astore_2
    //   195: ldc 126
    //   197: ldc 128
    //   199: invokestatic 133	mwv:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload_3
    //   203: ifnull -147 -> 56
    //   206: aload_3
    //   207: invokevirtual 92	java/io/BufferedReader:close	()V
    //   210: goto -154 -> 56
    //   213: astore_2
    //   214: aload_2
    //   215: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   218: goto -162 -> 56
    //   221: iload_0
    //   222: iconst_1
    //   223: iadd
    //   224: istore_0
    //   225: goto -116 -> 109
    //   228: astore_2
    //   229: aload_2
    //   230: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   233: goto -177 -> 56
    //   236: astore 4
    //   238: aload_2
    //   239: astore_3
    //   240: aload 4
    //   242: astore_2
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 92	java/io/BufferedReader:close	()V
    //   251: aload_2
    //   252: athrow
    //   253: astore_3
    //   254: aload_3
    //   255: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   258: goto -7 -> 251
    //   261: astore 4
    //   263: aload_2
    //   264: astore_3
    //   265: aload 4
    //   267: astore_2
    //   268: goto -25 -> 243
    //   271: astore_2
    //   272: aconst_null
    //   273: astore_3
    //   274: goto -81 -> 193
    //   277: iconst_0
    //   278: istore_1
    //   279: goto -129 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   81	144	0	j	int
    //   121	158	1	k	int
    //   11	170	2	localObject1	Object
    //   192	1	2	localException1	Exception
    //   194	1	2	localObject2	Object
    //   213	2	2	localIOException1	java.io.IOException
    //   228	11	2	localIOException2	java.io.IOException
    //   242	26	2	localObject3	Object
    //   271	1	2	localException2	Exception
    //   28	220	3	localObject4	Object
    //   253	2	3	localIOException3	java.io.IOException
    //   264	10	3	localObject5	Object
    //   35	147	4	str1	String
    //   236	5	4	localObject6	Object
    //   261	5	4	localObject7	Object
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
    //   206	210	213	java/io/IOException
    //   52	56	228	java/io/IOException
    //   12	29	236	finally
    //   247	251	253	java/io/IOException
    //   31	37	261	finally
    //   44	48	261	finally
    //   62	72	261	finally
    //   74	82	261	finally
    //   89	107	261	finally
    //   111	120	261	finally
    //   124	135	261	finally
    //   137	148	261	finally
    //   152	164	261	finally
    //   171	179	261	finally
    //   181	189	261	finally
    //   195	202	261	finally
    //   12	29	271	java/lang/Exception
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
    //   0: getstatic 144	mwc:jdField_a_of_type_Boolean	Z
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
    //   58: ifnonnull +268 -> 326
    //   61: iconst_1
    //   62: putstatic 144	mwc:jdField_a_of_type_Boolean	Z
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
    //   87: invokestatic 156	mwc:a	()I
    //   90: istore_2
    //   91: iload_2
    //   92: ifle +1152 -> 1244
    //   95: iload_2
    //   96: putstatic 29	mwc:jdField_b_of_type_Int	I
    //   99: invokestatic 159	mwv:c	()Z
    //   102: ifeq +28 -> 130
    //   105: aload 10
    //   107: ldc 161
    //   109: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 10
    //   115: getstatic 29	mwc:jdField_b_of_type_Int	I
    //   118: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 10
    //   124: ldc 170
    //   126: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: invokestatic 172	mwc:b	()J
    //   133: lstore 4
    //   135: lload 4
    //   137: lconst_0
    //   138: lcmp
    //   139: ifle +1153 -> 1292
    //   142: lload 4
    //   144: putstatic 174	mwc:jdField_a_of_type_Long	J
    //   147: invokestatic 159	mwv:c	()Z
    //   150: ifeq +28 -> 178
    //   153: aload 10
    //   155: ldc 176
    //   157: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 10
    //   163: getstatic 174	mwc:jdField_a_of_type_Long	J
    //   166: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 10
    //   172: ldc 170
    //   174: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: getstatic 29	mwc:jdField_b_of_type_Int	I
    //   181: ifle +11 -> 192
    //   184: getstatic 174	mwc:jdField_a_of_type_Long	J
    //   187: lconst_0
    //   188: lcmp
    //   189: ifgt +1203 -> 1392
    //   192: invokestatic 159	mwv:c	()Z
    //   195: ifeq +45 -> 240
    //   198: aload 10
    //   200: ldc 181
    //   202: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 10
    //   208: getstatic 29	mwc:jdField_b_of_type_Int	I
    //   211: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 10
    //   217: ldc 183
    //   219: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 10
    //   225: getstatic 174	mwc:jdField_a_of_type_Long	J
    //   228: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 10
    //   234: ldc 170
    //   236: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: iconst_0
    //   241: putstatic 144	mwc:jdField_a_of_type_Boolean	Z
    //   244: invokestatic 185	mwc:b	()I
    //   247: putstatic 33	mwc:jdField_d_of_type_Int	I
    //   250: invokestatic 159	mwv:c	()Z
    //   253: ifeq -246 -> 7
    //   256: aload 10
    //   258: ldc 187
    //   260: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 10
    //   266: getstatic 33	mwc:jdField_d_of_type_Int	I
    //   269: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 10
    //   275: ldc 189
    //   277: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 10
    //   283: getstatic 37	mwc:jdField_d_of_type_Boolean	Z
    //   286: invokevirtual 192	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload 10
    //   292: ldc 194
    //   294: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 10
    //   300: getstatic 35	mwc:jdField_c_of_type_Boolean	Z
    //   303: invokevirtual 192	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 10
    //   309: ldc 170
    //   311: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: ldc 126
    //   317: aload 10
    //   319: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 199	mwv:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: return
    //   326: aload 9
    //   328: ldc 201
    //   330: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   333: ifeq +88 -> 421
    //   336: aload 9
    //   338: bipush 58
    //   340: invokevirtual 104	java/lang/String:indexOf	(I)I
    //   343: istore_2
    //   344: iload_2
    //   345: iconst_1
    //   346: if_icmple -297 -> 49
    //   349: aload 9
    //   351: iload_2
    //   352: iconst_1
    //   353: iadd
    //   354: aload 9
    //   356: invokevirtual 107	java/lang/String:length	()I
    //   359: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   362: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   365: ldc 203
    //   367: ldc 21
    //   369: invokevirtual 207	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   372: putstatic 138	mwc:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   375: goto -326 -> 49
    //   378: astore 9
    //   380: lload 4
    //   382: lstore 6
    //   384: fload_0
    //   385: fstore_1
    //   386: aload 8
    //   388: ifnull -301 -> 87
    //   391: aload 8
    //   393: invokevirtual 92	java/io/BufferedReader:close	()V
    //   396: lload 4
    //   398: lstore 6
    //   400: fload_0
    //   401: fstore_1
    //   402: goto -315 -> 87
    //   405: astore 8
    //   407: aload 8
    //   409: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   412: lload 4
    //   414: lstore 6
    //   416: fload_0
    //   417: fstore_1
    //   418: goto -331 -> 87
    //   421: aload 9
    //   423: ldc 209
    //   425: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   428: ifeq +134 -> 562
    //   431: aload 9
    //   433: bipush 58
    //   435: invokevirtual 104	java/lang/String:indexOf	(I)I
    //   438: istore_2
    //   439: iload_2
    //   440: iconst_1
    //   441: if_icmple -392 -> 49
    //   444: aload 9
    //   446: iload_2
    //   447: iconst_1
    //   448: iadd
    //   449: aload 9
    //   451: invokevirtual 107	java/lang/String:length	()I
    //   454: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   457: putstatic 23	mwc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   460: getstatic 23	mwc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   463: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   466: putstatic 23	mwc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   469: invokestatic 159	mwv:c	()Z
    //   472: ifeq -423 -> 49
    //   475: aload 10
    //   477: ldc 211
    //   479: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload 10
    //   485: getstatic 23	mwc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   488: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 10
    //   494: ldc 213
    //   496: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload 10
    //   502: aload 9
    //   504: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload 10
    //   510: ldc 170
    //   512: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: goto -467 -> 49
    //   519: astore 9
    //   521: lload 4
    //   523: lstore 6
    //   525: fload_0
    //   526: fstore_1
    //   527: aload 8
    //   529: ifnull -442 -> 87
    //   532: aload 8
    //   534: invokevirtual 92	java/io/BufferedReader:close	()V
    //   537: lload 4
    //   539: lstore 6
    //   541: fload_0
    //   542: fstore_1
    //   543: goto -456 -> 87
    //   546: astore 8
    //   548: aload 8
    //   550: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   553: lload 4
    //   555: lstore 6
    //   557: fload_0
    //   558: fstore_1
    //   559: goto -472 -> 87
    //   562: aload 9
    //   564: ldc 215
    //   566: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   569: ifeq +228 -> 797
    //   572: aload 9
    //   574: bipush 58
    //   576: invokevirtual 104	java/lang/String:indexOf	(I)I
    //   579: istore_2
    //   580: iload_2
    //   581: iconst_1
    //   582: if_icmple +49 -> 631
    //   585: aload 9
    //   587: iload_2
    //   588: iconst_1
    //   589: iadd
    //   590: aload 9
    //   592: invokevirtual 107	java/lang/String:length	()I
    //   595: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   598: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   601: astore 11
    //   603: aload 11
    //   605: ifnull +26 -> 631
    //   608: aload 11
    //   610: invokevirtual 107	java/lang/String:length	()I
    //   613: ifle +18 -> 631
    //   616: aload 11
    //   618: ldc 217
    //   620: invokevirtual 220	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   623: ifeq +115 -> 738
    //   626: bipush 8
    //   628: putstatic 27	mwc:jdField_a_of_type_Int	I
    //   631: aload 9
    //   633: ldc 222
    //   635: invokevirtual 226	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   638: ifeq +7 -> 645
    //   641: iconst_5
    //   642: putstatic 27	mwc:jdField_a_of_type_Int	I
    //   645: invokestatic 159	mwv:c	()Z
    //   648: ifeq -599 -> 49
    //   651: aload 10
    //   653: ldc 228
    //   655: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: aload 10
    //   661: getstatic 27	mwc:jdField_a_of_type_Int	I
    //   664: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload 10
    //   670: ldc 213
    //   672: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: aload 10
    //   678: aload 9
    //   680: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: aload 10
    //   686: ldc 170
    //   688: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: goto -643 -> 49
    //   695: astore 9
    //   697: lload 4
    //   699: lstore 6
    //   701: fload_0
    //   702: fstore_1
    //   703: aload 8
    //   705: ifnull -618 -> 87
    //   708: aload 8
    //   710: invokevirtual 92	java/io/BufferedReader:close	()V
    //   713: lload 4
    //   715: lstore 6
    //   717: fload_0
    //   718: fstore_1
    //   719: goto -632 -> 87
    //   722: astore 8
    //   724: aload 8
    //   726: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   729: lload 4
    //   731: lstore 6
    //   733: fload_0
    //   734: fstore_1
    //   735: goto -648 -> 87
    //   738: aload 11
    //   740: invokestatic 124	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   743: l2i
    //   744: putstatic 27	mwc:jdField_a_of_type_Int	I
    //   747: goto -116 -> 631
    //   750: astore 12
    //   752: iconst_1
    //   753: istore_2
    //   754: aload 11
    //   756: invokevirtual 107	java/lang/String:length	()I
    //   759: istore_3
    //   760: iload_2
    //   761: iload_3
    //   762: if_icmpge -131 -> 631
    //   765: aload 11
    //   767: iconst_0
    //   768: aload 11
    //   770: invokevirtual 107	java/lang/String:length	()I
    //   773: iload_2
    //   774: isub
    //   775: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   778: invokestatic 124	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   781: l2i
    //   782: putstatic 27	mwc:jdField_a_of_type_Int	I
    //   785: goto -154 -> 631
    //   788: astore 12
    //   790: iload_2
    //   791: iconst_1
    //   792: iadd
    //   793: istore_2
    //   794: goto -40 -> 754
    //   797: aload 9
    //   799: ldc 230
    //   801: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   804: ifeq +108 -> 912
    //   807: aload 9
    //   809: bipush 58
    //   811: invokevirtual 104	java/lang/String:indexOf	(I)I
    //   814: istore_2
    //   815: iload_2
    //   816: iconst_1
    //   817: if_icmple +22 -> 839
    //   820: aload 9
    //   822: iload_2
    //   823: iconst_1
    //   824: iadd
    //   825: aload 9
    //   827: invokevirtual 107	java/lang/String:length	()I
    //   830: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   833: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   836: putstatic 25	mwc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   839: invokestatic 159	mwv:c	()Z
    //   842: ifeq -793 -> 49
    //   845: aload 10
    //   847: ldc 232
    //   849: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: aload 10
    //   855: getstatic 25	mwc:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   858: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: pop
    //   862: aload 10
    //   864: ldc 213
    //   866: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: pop
    //   870: aload 10
    //   872: aload 9
    //   874: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: pop
    //   878: aload 10
    //   880: ldc 170
    //   882: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: pop
    //   886: goto -837 -> 49
    //   889: astore 10
    //   891: aload 8
    //   893: astore 9
    //   895: aload 10
    //   897: astore 8
    //   899: aload 9
    //   901: ifnull +8 -> 909
    //   904: aload 9
    //   906: invokevirtual 92	java/io/BufferedReader:close	()V
    //   909: aload 8
    //   911: athrow
    //   912: aload 9
    //   914: ldc 234
    //   916: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   919: ifeq +85 -> 1004
    //   922: aload 9
    //   924: bipush 58
    //   926: invokevirtual 104	java/lang/String:indexOf	(I)I
    //   929: istore_2
    //   930: iload_2
    //   931: iconst_1
    //   932: if_icmple +22 -> 954
    //   935: aload 9
    //   937: iload_2
    //   938: iconst_1
    //   939: iadd
    //   940: aload 9
    //   942: invokevirtual 107	java/lang/String:length	()I
    //   945: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   948: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   951: putstatic 236	mwc:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   954: invokestatic 159	mwv:c	()Z
    //   957: ifeq -908 -> 49
    //   960: aload 10
    //   962: ldc 238
    //   964: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: pop
    //   968: aload 10
    //   970: getstatic 236	mwc:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   973: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: pop
    //   977: aload 10
    //   979: ldc 213
    //   981: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: pop
    //   985: aload 10
    //   987: aload 9
    //   989: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   992: pop
    //   993: aload 10
    //   995: ldc 170
    //   997: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1000: pop
    //   1001: goto -952 -> 49
    //   1004: aload 9
    //   1006: ldc 201
    //   1008: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1011: ifeq +75 -> 1086
    //   1014: aload 9
    //   1016: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   1019: putstatic 240	mwc:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1022: aload 9
    //   1024: ldc 242
    //   1026: invokevirtual 226	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1029: ifeq +7 -> 1036
    //   1032: iconst_1
    //   1033: putstatic 244	mwc:jdField_e_of_type_Boolean	Z
    //   1036: invokestatic 159	mwv:c	()Z
    //   1039: ifeq -990 -> 49
    //   1042: aload 10
    //   1044: ldc 246
    //   1046: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: pop
    //   1050: aload 10
    //   1052: getstatic 244	mwc:jdField_e_of_type_Boolean	Z
    //   1055: invokevirtual 192	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1058: pop
    //   1059: aload 10
    //   1061: ldc 213
    //   1063: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: pop
    //   1067: aload 10
    //   1069: aload 9
    //   1071: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: pop
    //   1075: aload 10
    //   1077: ldc 170
    //   1079: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: pop
    //   1083: goto -1034 -> 49
    //   1086: aload 9
    //   1088: ldc 248
    //   1090: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1093: ifeq +67 -> 1160
    //   1096: aload 9
    //   1098: bipush 58
    //   1100: invokevirtual 104	java/lang/String:indexOf	(I)I
    //   1103: istore_2
    //   1104: iload_2
    //   1105: iconst_1
    //   1106: if_icmple -1057 -> 49
    //   1109: aload 9
    //   1111: iload_2
    //   1112: iconst_1
    //   1113: iadd
    //   1114: aload 9
    //   1116: invokevirtual 107	java/lang/String:length	()I
    //   1119: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   1122: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   1125: astore 9
    //   1127: aload 9
    //   1129: invokestatic 124	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1132: lstore 6
    //   1134: lload 6
    //   1136: lconst_0
    //   1137: lcmp
    //   1138: iflt -1089 -> 49
    //   1141: lconst_1
    //   1142: lload 6
    //   1144: ladd
    //   1145: lload 4
    //   1147: lcmp
    //   1148: ifle -1099 -> 49
    //   1151: lconst_1
    //   1152: lload 6
    //   1154: ladd
    //   1155: lstore 4
    //   1157: goto -1108 -> 49
    //   1160: aload 9
    //   1162: ldc 250
    //   1164: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1167: ifeq -1118 -> 49
    //   1170: aload 9
    //   1172: bipush 58
    //   1174: invokevirtual 104	java/lang/String:indexOf	(I)I
    //   1177: istore_2
    //   1178: iload_2
    //   1179: iconst_1
    //   1180: if_icmple -1131 -> 49
    //   1183: aload 9
    //   1185: iload_2
    //   1186: iconst_1
    //   1187: iadd
    //   1188: aload 9
    //   1190: invokevirtual 107	java/lang/String:length	()I
    //   1193: invokevirtual 111	java/lang/String:substring	(II)Ljava/lang/String;
    //   1196: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   1199: astore 9
    //   1201: aload 9
    //   1203: invokestatic 256	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   1206: fstore_1
    //   1207: fload_1
    //   1208: fload_0
    //   1209: fcmpl
    //   1210: ifle +232 -> 1442
    //   1213: fload_1
    //   1214: fstore_0
    //   1215: goto -1166 -> 49
    //   1218: astore 8
    //   1220: aload 8
    //   1222: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   1225: lload 4
    //   1227: lstore 6
    //   1229: fload_0
    //   1230: fstore_1
    //   1231: goto -1144 -> 87
    //   1234: astore 9
    //   1236: aload 9
    //   1238: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   1241: goto -332 -> 909
    //   1244: lload 6
    //   1246: lconst_0
    //   1247: lcmp
    //   1248: ifle -1118 -> 130
    //   1251: lload 6
    //   1253: l2i
    //   1254: putstatic 29	mwc:jdField_b_of_type_Int	I
    //   1257: invokestatic 159	mwv:c	()Z
    //   1260: ifeq -1130 -> 130
    //   1263: aload 10
    //   1265: ldc_w 258
    //   1268: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: pop
    //   1272: aload 10
    //   1274: getstatic 29	mwc:jdField_b_of_type_Int	I
    //   1277: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1280: pop
    //   1281: aload 10
    //   1283: ldc 170
    //   1285: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: pop
    //   1289: goto -1159 -> 130
    //   1292: fload_1
    //   1293: fconst_0
    //   1294: fcmpl
    //   1295: ifle -1117 -> 178
    //   1298: fload_1
    //   1299: ldc_w 259
    //   1302: fcmpg
    //   1303: ifge +52 -> 1355
    //   1306: fload_1
    //   1307: f2d
    //   1308: ldc2_w 260
    //   1311: dmul
    //   1312: ldc2_w 262
    //   1315: dmul
    //   1316: d2l
    //   1317: putstatic 174	mwc:jdField_a_of_type_Long	J
    //   1320: invokestatic 159	mwv:c	()Z
    //   1323: ifeq -1145 -> 178
    //   1326: aload 10
    //   1328: ldc_w 265
    //   1331: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: pop
    //   1335: aload 10
    //   1337: getstatic 174	mwc:jdField_a_of_type_Long	J
    //   1340: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1343: pop
    //   1344: aload 10
    //   1346: ldc 170
    //   1348: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1351: pop
    //   1352: goto -1174 -> 178
    //   1355: fload_1
    //   1356: ldc_w 266
    //   1359: fcmpl
    //   1360: ifle +20 -> 1380
    //   1363: fload_1
    //   1364: f2d
    //   1365: ldc2_w 267
    //   1368: ddiv
    //   1369: ldc2_w 262
    //   1372: dmul
    //   1373: d2l
    //   1374: putstatic 174	mwc:jdField_a_of_type_Long	J
    //   1377: goto -57 -> 1320
    //   1380: ldc_w 269
    //   1383: fload_1
    //   1384: fmul
    //   1385: f2l
    //   1386: putstatic 174	mwc:jdField_a_of_type_Long	J
    //   1389: goto -69 -> 1320
    //   1392: iconst_1
    //   1393: putstatic 144	mwc:jdField_a_of_type_Boolean	Z
    //   1396: goto -1152 -> 244
    //   1399: astore 9
    //   1401: goto -1352 -> 49
    //   1404: astore 9
    //   1406: goto -1357 -> 49
    //   1409: astore 8
    //   1411: aconst_null
    //   1412: astore 9
    //   1414: goto -515 -> 899
    //   1417: astore 8
    //   1419: aconst_null
    //   1420: astore 8
    //   1422: goto -725 -> 697
    //   1425: astore 8
    //   1427: aconst_null
    //   1428: astore 8
    //   1430: goto -909 -> 521
    //   1433: astore 8
    //   1435: aload 9
    //   1437: astore 8
    //   1439: goto -1059 -> 380
    //   1442: goto -227 -> 1215
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	1212	0	f1	float
    //   70	1314	1	f2	float
    //   90	1098	2	j	int
    //   759	4	3	k	int
    //   14	1212	4	l1	long
    //   67	1185	6	l2	long
    //   47	345	8	localBufferedReader	java.io.BufferedReader
    //   405	128	8	localIOException1	java.io.IOException
    //   546	163	8	localIOException2	java.io.IOException
    //   722	170	8	localIOException3	java.io.IOException
    //   897	13	8	localObject1	Object
    //   1218	3	8	localIOException4	java.io.IOException
    //   1409	1	8	localObject2	Object
    //   1417	1	8	localNumberFormatException1	java.lang.NumberFormatException
    //   1420	1	8	localObject3	Object
    //   1425	1	8	localIOException5	java.io.IOException
    //   1428	1	8	localObject4	Object
    //   1433	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   1437	1	8	localObject5	Object
    //   9	346	9	str1	String
    //   378	125	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   519	160	9	localIOException6	java.io.IOException
    //   695	178	9	localNumberFormatException2	java.lang.NumberFormatException
    //   893	309	9	localObject6	Object
    //   1234	3	9	localIOException7	java.io.IOException
    //   1399	1	9	localNumberFormatException3	java.lang.NumberFormatException
    //   1404	1	9	localNumberFormatException4	java.lang.NumberFormatException
    //   1412	24	9	localObject7	Object
    //   29	850	10	localStringBuilder	java.lang.StringBuilder
    //   889	456	10	localObject8	Object
    //   601	168	11	str2	String
    //   750	1	12	localNumberFormatException5	java.lang.NumberFormatException
    //   788	1	12	localNumberFormatException6	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   49	56	378	java/io/FileNotFoundException
    //   61	65	378	java/io/FileNotFoundException
    //   326	344	378	java/io/FileNotFoundException
    //   349	375	378	java/io/FileNotFoundException
    //   421	439	378	java/io/FileNotFoundException
    //   444	516	378	java/io/FileNotFoundException
    //   562	580	378	java/io/FileNotFoundException
    //   585	603	378	java/io/FileNotFoundException
    //   608	631	378	java/io/FileNotFoundException
    //   631	645	378	java/io/FileNotFoundException
    //   645	692	378	java/io/FileNotFoundException
    //   738	747	378	java/io/FileNotFoundException
    //   754	760	378	java/io/FileNotFoundException
    //   765	785	378	java/io/FileNotFoundException
    //   797	815	378	java/io/FileNotFoundException
    //   820	839	378	java/io/FileNotFoundException
    //   839	886	378	java/io/FileNotFoundException
    //   912	930	378	java/io/FileNotFoundException
    //   935	954	378	java/io/FileNotFoundException
    //   954	1001	378	java/io/FileNotFoundException
    //   1004	1036	378	java/io/FileNotFoundException
    //   1036	1083	378	java/io/FileNotFoundException
    //   1086	1104	378	java/io/FileNotFoundException
    //   1109	1127	378	java/io/FileNotFoundException
    //   1127	1134	378	java/io/FileNotFoundException
    //   1160	1178	378	java/io/FileNotFoundException
    //   1183	1201	378	java/io/FileNotFoundException
    //   1201	1207	378	java/io/FileNotFoundException
    //   391	396	405	java/io/IOException
    //   49	56	519	java/io/IOException
    //   61	65	519	java/io/IOException
    //   326	344	519	java/io/IOException
    //   349	375	519	java/io/IOException
    //   421	439	519	java/io/IOException
    //   444	516	519	java/io/IOException
    //   562	580	519	java/io/IOException
    //   585	603	519	java/io/IOException
    //   608	631	519	java/io/IOException
    //   631	645	519	java/io/IOException
    //   645	692	519	java/io/IOException
    //   738	747	519	java/io/IOException
    //   754	760	519	java/io/IOException
    //   765	785	519	java/io/IOException
    //   797	815	519	java/io/IOException
    //   820	839	519	java/io/IOException
    //   839	886	519	java/io/IOException
    //   912	930	519	java/io/IOException
    //   935	954	519	java/io/IOException
    //   954	1001	519	java/io/IOException
    //   1004	1036	519	java/io/IOException
    //   1036	1083	519	java/io/IOException
    //   1086	1104	519	java/io/IOException
    //   1109	1127	519	java/io/IOException
    //   1127	1134	519	java/io/IOException
    //   1160	1178	519	java/io/IOException
    //   1183	1201	519	java/io/IOException
    //   1201	1207	519	java/io/IOException
    //   532	537	546	java/io/IOException
    //   49	56	695	java/lang/NumberFormatException
    //   61	65	695	java/lang/NumberFormatException
    //   326	344	695	java/lang/NumberFormatException
    //   349	375	695	java/lang/NumberFormatException
    //   421	439	695	java/lang/NumberFormatException
    //   444	516	695	java/lang/NumberFormatException
    //   562	580	695	java/lang/NumberFormatException
    //   585	603	695	java/lang/NumberFormatException
    //   608	631	695	java/lang/NumberFormatException
    //   631	645	695	java/lang/NumberFormatException
    //   645	692	695	java/lang/NumberFormatException
    //   754	760	695	java/lang/NumberFormatException
    //   797	815	695	java/lang/NumberFormatException
    //   820	839	695	java/lang/NumberFormatException
    //   839	886	695	java/lang/NumberFormatException
    //   912	930	695	java/lang/NumberFormatException
    //   935	954	695	java/lang/NumberFormatException
    //   954	1001	695	java/lang/NumberFormatException
    //   1004	1036	695	java/lang/NumberFormatException
    //   1036	1083	695	java/lang/NumberFormatException
    //   1086	1104	695	java/lang/NumberFormatException
    //   1109	1127	695	java/lang/NumberFormatException
    //   1160	1178	695	java/lang/NumberFormatException
    //   1183	1201	695	java/lang/NumberFormatException
    //   708	713	722	java/io/IOException
    //   738	747	750	java/lang/NumberFormatException
    //   765	785	788	java/lang/NumberFormatException
    //   49	56	889	finally
    //   61	65	889	finally
    //   326	344	889	finally
    //   349	375	889	finally
    //   421	439	889	finally
    //   444	516	889	finally
    //   562	580	889	finally
    //   585	603	889	finally
    //   608	631	889	finally
    //   631	645	889	finally
    //   645	692	889	finally
    //   738	747	889	finally
    //   754	760	889	finally
    //   765	785	889	finally
    //   797	815	889	finally
    //   820	839	889	finally
    //   839	886	889	finally
    //   912	930	889	finally
    //   935	954	889	finally
    //   954	1001	889	finally
    //   1004	1036	889	finally
    //   1036	1083	889	finally
    //   1086	1104	889	finally
    //   1109	1127	889	finally
    //   1127	1134	889	finally
    //   1160	1178	889	finally
    //   1183	1201	889	finally
    //   1201	1207	889	finally
    //   76	81	1218	java/io/IOException
    //   904	909	1234	java/io/IOException
    //   1127	1134	1399	java/lang/NumberFormatException
    //   1201	1207	1404	java/lang/NumberFormatException
    //   31	49	1409	finally
    //   31	49	1417	java/lang/NumberFormatException
    //   31	49	1425	java/io/IOException
    //   31	49	1433	java/io/FileNotFoundException
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
    //   2: getstatic 29	mwc:jdField_b_of_type_Int	I
    //   5: iconst_1
    //   6: if_icmpge +22 -> 28
    //   9: invokestatic 159	mwv:c	()Z
    //   12: ifeq +11 -> 23
    //   15: ldc 126
    //   17: ldc_w 314
    //   20: invokestatic 199	mwv:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: bipush 8
    //   25: putstatic 29	mwc:jdField_b_of_type_Int	I
    //   28: iconst_0
    //   29: istore_2
    //   30: lconst_0
    //   31: lstore 5
    //   33: lconst_0
    //   34: lstore_3
    //   35: iload_1
    //   36: getstatic 29	mwc:jdField_b_of_type_Int	I
    //   39: if_icmpge +318 -> 357
    //   42: aconst_null
    //   43: astore 12
    //   45: new 77	java/io/BufferedReader
    //   48: dup
    //   49: new 79	java/io/FileReader
    //   52: dup
    //   53: new 149	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 317
    //   63: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: iload_1
    //   67: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc_w 319
    //   73: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokespecial 82	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   82: invokespecial 85	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   85: astore 11
    //   87: lload_3
    //   88: lstore 7
    //   90: aload 11
    //   92: ifnull +51 -> 143
    //   95: aload 11
    //   97: invokevirtual 89	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   100: astore 12
    //   102: aload 12
    //   104: invokestatic 324	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   107: ifne +338 -> 445
    //   110: aload 12
    //   112: invokevirtual 114	java/lang/String:trim	()Ljava/lang/String;
    //   115: astore 12
    //   117: lload_3
    //   118: lstore 7
    //   120: aload 12
    //   122: ifnull +21 -> 143
    //   125: lload_3
    //   126: lstore 7
    //   128: aload 12
    //   130: invokevirtual 107	java/lang/String:length	()I
    //   133: ifle +10 -> 143
    //   136: aload 12
    //   138: invokestatic 124	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   141: lstore 7
    //   143: iload_2
    //   144: istore_0
    //   145: lload 7
    //   147: lstore_3
    //   148: aload 11
    //   150: ifnull +13 -> 163
    //   153: aload 11
    //   155: invokevirtual 92	java/io/BufferedReader:close	()V
    //   158: lload 7
    //   160: lstore_3
    //   161: iload_2
    //   162: istore_0
    //   163: lload 5
    //   165: lstore 7
    //   167: lload_3
    //   168: lload 5
    //   170: lcmp
    //   171: ifle +6 -> 177
    //   174: lload_3
    //   175: lstore 7
    //   177: invokestatic 159	mwv:c	()Z
    //   180: ifeq +49 -> 229
    //   183: ldc 126
    //   185: new 149	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   192: ldc_w 326
    //   195: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: iload_1
    //   199: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: ldc_w 328
    //   205: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: lload_3
    //   209: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   212: ldc_w 330
    //   215: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: lload 7
    //   220: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 199	mwv:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: iload_1
    //   230: iconst_1
    //   231: iadd
    //   232: istore_1
    //   233: iload_0
    //   234: istore_2
    //   235: lload 7
    //   237: lstore 5
    //   239: goto -204 -> 35
    //   242: astore 11
    //   244: aload 11
    //   246: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   249: iload_2
    //   250: istore_0
    //   251: lload 7
    //   253: lstore_3
    //   254: goto -91 -> 163
    //   257: astore 12
    //   259: aconst_null
    //   260: astore 11
    //   262: ldc 126
    //   264: new 149	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 332
    //   274: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: iload_1
    //   278: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: ldc_w 334
    //   284: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 12
    //   289: invokevirtual 335	java/lang/Exception:toString	()Ljava/lang/String;
    //   292: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 133	mwv:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload 11
    //   303: ifnull +8 -> 311
    //   306: aload 11
    //   308: invokevirtual 92	java/io/BufferedReader:close	()V
    //   311: iconst_1
    //   312: istore_0
    //   313: lconst_0
    //   314: lstore_3
    //   315: goto -152 -> 163
    //   318: astore 11
    //   320: aload 11
    //   322: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   325: iconst_1
    //   326: istore_0
    //   327: lconst_0
    //   328: lstore_3
    //   329: goto -166 -> 163
    //   332: astore 11
    //   334: aload 12
    //   336: ifnull +8 -> 344
    //   339: aload 12
    //   341: invokevirtual 92	java/io/BufferedReader:close	()V
    //   344: aload 11
    //   346: athrow
    //   347: astore 12
    //   349: aload 12
    //   351: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   354: goto -10 -> 344
    //   357: lload 5
    //   359: lstore 7
    //   361: iload_2
    //   362: ifeq +23 -> 385
    //   365: invokestatic 337	mwc:c	()J
    //   368: lstore 9
    //   370: lload 5
    //   372: lstore 7
    //   374: lload 9
    //   376: lload_3
    //   377: lcmp
    //   378: ifle +7 -> 385
    //   381: lload 9
    //   383: lstore 7
    //   385: ldc 126
    //   387: new 149	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   394: ldc_w 339
    //   397: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: lload 7
    //   402: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   405: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 341	mwv:g	(Ljava/lang/String;Ljava/lang/String;)V
    //   411: lload 7
    //   413: lreturn
    //   414: astore 13
    //   416: aload 11
    //   418: astore 12
    //   420: aload 13
    //   422: astore 11
    //   424: goto -90 -> 334
    //   427: astore 13
    //   429: aload 11
    //   431: astore 12
    //   433: aload 13
    //   435: astore 11
    //   437: goto -103 -> 334
    //   440: astore 12
    //   442: goto -180 -> 262
    //   445: ldc 21
    //   447: astore 12
    //   449: goto -332 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   144	183	0	j	int
    //   1	277	1	k	int
    //   29	333	2	m	int
    //   34	343	3	l1	long
    //   31	340	5	l2	long
    //   88	324	7	l3	long
    //   368	14	9	l4	long
    //   85	69	11	localBufferedReader	java.io.BufferedReader
    //   242	3	11	localIOException1	java.io.IOException
    //   260	47	11	localObject1	Object
    //   318	3	11	localIOException2	java.io.IOException
    //   332	85	11	localObject2	Object
    //   422	14	11	localObject3	Object
    //   43	94	12	str1	String
    //   257	83	12	localException1	Exception
    //   347	3	12	localIOException3	java.io.IOException
    //   418	14	12	localObject4	Object
    //   440	1	12	localException2	Exception
    //   447	1	12	str2	String
    //   414	7	13	localObject5	Object
    //   427	7	13	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   153	158	242	java/io/IOException
    //   45	87	257	java/lang/Exception
    //   306	311	318	java/io/IOException
    //   45	87	332	finally
    //   339	344	347	java/io/IOException
    //   95	117	414	finally
    //   128	143	414	finally
    //   262	301	427	finally
    //   95	117	440	java/lang/Exception
    //   128	143	440	java/lang/Exception
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
    //   13: ldc_w 346
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
    //   142: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 348
    //   148: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: lload 5
    //   153: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   156: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 341	mwv:g	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   208: invokespecial 315	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 350
    //   214: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 10
    //   219: invokevirtual 335	java/lang/Exception:toString	()Ljava/lang/String;
    //   222: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 197	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 355	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
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
    
    if (mwv.c()) {
      mwv.b("AVCoreSystemInfo", "getMaxCpuFreq: " + Build.BRAND + "|" + Build.MODEL + "|" + jdField_a_of_type_Long);
    }
    return jdField_a_of_type_Long;
  }
  
  public static String d()
  {
    a();
    return jdField_a_of_type_JavaLangString;
  }
  
  public static boolean d()
  {
    return ((a("neon")) || (a("asimd"))) && (e() >= 2) && (f() >= 4);
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
    a();
    return (jdField_d_of_type_Int >= 3) && (jdField_a_of_type_Long / 1000L >= 800L);
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
    return jdField_e_of_type_Boolean;
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
  
  public void b(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mwc
 * JD-Core Version:    0.7.0.1
 */