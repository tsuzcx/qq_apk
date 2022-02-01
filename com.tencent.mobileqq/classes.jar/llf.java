public final class llf
{
  /* Error */
  public static java.lang.String a(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: invokestatic 16	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +37 -> 40
    //   6: ldc 18
    //   8: iconst_2
    //   9: new 20	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   16: ldc 26
    //   18: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 32
    //   27: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 40	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_0
    //   41: ifnull +25 -> 66
    //   44: aload_0
    //   45: ldc 42
    //   47: invokevirtual 48	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   50: ifne +16 -> 66
    //   53: aload_1
    //   54: ifnull +12 -> 66
    //   57: aload_1
    //   58: ldc 42
    //   60: invokevirtual 48	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   63: ifeq +7 -> 70
    //   66: aconst_null
    //   67: astore_1
    //   68: aload_1
    //   69: areturn
    //   70: new 50	java/io/File
    //   73: dup
    //   74: aload_0
    //   75: aload_1
    //   76: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: astore 5
    //   81: aload 5
    //   83: invokevirtual 56	java/io/File:exists	()Z
    //   86: ifeq +301 -> 387
    //   89: new 58	java/io/FileInputStream
    //   92: dup
    //   93: aload 5
    //   95: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   98: astore_1
    //   99: new 63	java/io/BufferedInputStream
    //   102: dup
    //   103: aload_1
    //   104: invokespecial 66	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: astore_0
    //   108: aload_1
    //   109: astore_3
    //   110: aload_0
    //   111: astore_2
    //   112: aload_1
    //   113: invokevirtual 70	java/io/FileInputStream:available	()I
    //   116: newarray byte
    //   118: astore 4
    //   120: aload_1
    //   121: astore_3
    //   122: aload_0
    //   123: astore_2
    //   124: aload_0
    //   125: aload 4
    //   127: invokevirtual 74	java/io/BufferedInputStream:read	([B)I
    //   130: pop
    //   131: aload_1
    //   132: astore_3
    //   133: aload_0
    //   134: astore_2
    //   135: new 44	java/lang/String
    //   138: dup
    //   139: aload 4
    //   141: ldc 76
    //   143: invokespecial 79	java/lang/String:<init>	([BLjava/lang/String;)V
    //   146: astore 4
    //   148: aload_0
    //   149: ifnull +7 -> 156
    //   152: aload_0
    //   153: invokevirtual 82	java/io/BufferedInputStream:close	()V
    //   156: aload 4
    //   158: astore_0
    //   159: aload_1
    //   160: ifnull +10 -> 170
    //   163: aload_1
    //   164: invokevirtual 83	java/io/FileInputStream:close	()V
    //   167: aload 4
    //   169: astore_0
    //   170: aload_0
    //   171: astore_1
    //   172: invokestatic 16	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq -107 -> 68
    //   178: ldc 18
    //   180: iconst_2
    //   181: new 20	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   188: ldc 85
    //   190: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_0
    //   194: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 40	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload_0
    //   204: areturn
    //   205: astore_0
    //   206: aload_0
    //   207: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   210: goto -54 -> 156
    //   213: astore_0
    //   214: aload_0
    //   215: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   218: aload 4
    //   220: astore_0
    //   221: goto -51 -> 170
    //   224: astore 4
    //   226: aconst_null
    //   227: astore_1
    //   228: aconst_null
    //   229: astore_0
    //   230: aload_1
    //   231: astore_3
    //   232: aload_0
    //   233: astore_2
    //   234: aload 5
    //   236: invokevirtual 91	java/io/File:delete	()Z
    //   239: pop
    //   240: aload_1
    //   241: astore_3
    //   242: aload_0
    //   243: astore_2
    //   244: invokestatic 16	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq +33 -> 280
    //   250: aload_1
    //   251: astore_3
    //   252: aload_0
    //   253: astore_2
    //   254: ldc 18
    //   256: iconst_2
    //   257: new 20	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   264: ldc 93
    //   266: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 4
    //   271: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: aload_0
    //   281: ifnull +7 -> 288
    //   284: aload_0
    //   285: invokevirtual 82	java/io/BufferedInputStream:close	()V
    //   288: aload_1
    //   289: ifnull +93 -> 382
    //   292: aload_1
    //   293: invokevirtual 83	java/io/FileInputStream:close	()V
    //   296: aconst_null
    //   297: astore_0
    //   298: goto -128 -> 170
    //   301: astore_0
    //   302: aload_0
    //   303: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   306: goto -18 -> 288
    //   309: astore_0
    //   310: aload_0
    //   311: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   314: aconst_null
    //   315: astore_0
    //   316: goto -146 -> 170
    //   319: astore_0
    //   320: aconst_null
    //   321: astore_1
    //   322: aconst_null
    //   323: astore_2
    //   324: aload_2
    //   325: ifnull +7 -> 332
    //   328: aload_2
    //   329: invokevirtual 82	java/io/BufferedInputStream:close	()V
    //   332: aload_1
    //   333: ifnull +7 -> 340
    //   336: aload_1
    //   337: invokevirtual 83	java/io/FileInputStream:close	()V
    //   340: aload_0
    //   341: athrow
    //   342: astore_2
    //   343: aload_2
    //   344: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   347: goto -15 -> 332
    //   350: astore_1
    //   351: aload_1
    //   352: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   355: goto -15 -> 340
    //   358: astore_0
    //   359: aconst_null
    //   360: astore_2
    //   361: goto -37 -> 324
    //   364: astore_0
    //   365: aload_3
    //   366: astore_1
    //   367: goto -43 -> 324
    //   370: astore 4
    //   372: aconst_null
    //   373: astore_0
    //   374: goto -144 -> 230
    //   377: astore 4
    //   379: goto -149 -> 230
    //   382: aconst_null
    //   383: astore_0
    //   384: goto -214 -> 170
    //   387: aconst_null
    //   388: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	paramString1	java.lang.String
    //   0	389	1	paramString2	java.lang.String
    //   111	218	2	str1	java.lang.String
    //   342	2	2	localIOException	java.io.IOException
    //   360	1	2	localObject1	Object
    //   109	257	3	str2	java.lang.String
    //   118	101	4	localObject2	Object
    //   224	46	4	localThrowable1	java.lang.Throwable
    //   370	1	4	localThrowable2	java.lang.Throwable
    //   377	1	4	localThrowable3	java.lang.Throwable
    //   79	156	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   152	156	205	java/io/IOException
    //   163	167	213	java/io/IOException
    //   89	99	224	java/lang/Throwable
    //   284	288	301	java/io/IOException
    //   292	296	309	java/io/IOException
    //   89	99	319	finally
    //   328	332	342	java/io/IOException
    //   336	340	350	java/io/IOException
    //   99	108	358	finally
    //   112	120	364	finally
    //   124	131	364	finally
    //   135	148	364	finally
    //   234	240	364	finally
    //   244	250	364	finally
    //   254	280	364	finally
    //   99	108	370	java/lang/Throwable
    //   112	120	377	java/lang/Throwable
    //   124	131	377	java/lang/Throwable
    //   135	148	377	java/lang/Throwable
  }
  
  /* Error */
  public static boolean a(java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 16	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +37 -> 43
    //   9: ldc 18
    //   11: iconst_2
    //   12: new 20	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   19: ldc 105
    //   21: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 32
    //   30: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_2
    //   34: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 40	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: ifnull +29 -> 73
    //   47: aload_1
    //   48: ifnull +25 -> 73
    //   51: aload_1
    //   52: ldc 42
    //   54: invokevirtual 48	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifne +16 -> 73
    //   60: aload_2
    //   61: ifnull +12 -> 73
    //   64: aload_2
    //   65: ldc 42
    //   67: invokevirtual 48	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   70: ifeq +7 -> 77
    //   73: iconst_0
    //   74: istore_3
    //   75: iload_3
    //   76: ireturn
    //   77: new 50	java/io/File
    //   80: dup
    //   81: aload_1
    //   82: aload_2
    //   83: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: astore 6
    //   88: new 50	java/io/File
    //   91: dup
    //   92: aload_1
    //   93: new 20	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   100: aload_2
    //   101: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 107
    //   106: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 53	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: astore 7
    //   117: iconst_0
    //   118: newarray byte
    //   120: astore_1
    //   121: aload_0
    //   122: ldc 76
    //   124: invokevirtual 111	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   127: astore_0
    //   128: aload 6
    //   130: invokevirtual 115	java/io/File:getParentFile	()Ljava/io/File;
    //   133: astore_1
    //   134: aload_1
    //   135: invokevirtual 56	java/io/File:exists	()Z
    //   138: ifne +8 -> 146
    //   141: aload_1
    //   142: invokevirtual 118	java/io/File:mkdir	()Z
    //   145: pop
    //   146: aload 7
    //   148: invokevirtual 56	java/io/File:exists	()Z
    //   151: ifeq +9 -> 160
    //   154: aload 7
    //   156: invokevirtual 91	java/io/File:delete	()Z
    //   159: pop
    //   160: new 120	java/io/FileOutputStream
    //   163: dup
    //   164: aload 7
    //   166: invokespecial 121	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   169: astore_2
    //   170: new 123	java/io/BufferedOutputStream
    //   173: dup
    //   174: aload_2
    //   175: invokespecial 126	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   178: astore_1
    //   179: aload_1
    //   180: aload_0
    //   181: invokevirtual 130	java/io/BufferedOutputStream:write	([B)V
    //   184: aload_1
    //   185: invokevirtual 133	java/io/BufferedOutputStream:flush	()V
    //   188: aload 7
    //   190: aload 6
    //   192: invokestatic 139	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   195: istore 4
    //   197: aload_1
    //   198: ifnull +7 -> 205
    //   201: aload_1
    //   202: invokevirtual 140	java/io/BufferedOutputStream:close	()V
    //   205: iload 4
    //   207: istore_3
    //   208: aload_2
    //   209: ifnull -134 -> 75
    //   212: aload_2
    //   213: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   216: iload 4
    //   218: ireturn
    //   219: astore_0
    //   220: aload_0
    //   221: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   224: iload 4
    //   226: ireturn
    //   227: astore_0
    //   228: aload_0
    //   229: invokevirtual 142	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   232: aload_1
    //   233: astore_0
    //   234: goto -106 -> 128
    //   237: astore_0
    //   238: aload_0
    //   239: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   242: goto -37 -> 205
    //   245: astore_2
    //   246: aconst_null
    //   247: astore_1
    //   248: aload 5
    //   250: astore_0
    //   251: aload_2
    //   252: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   255: aload_1
    //   256: ifnull +7 -> 263
    //   259: aload_1
    //   260: invokevirtual 140	java/io/BufferedOutputStream:close	()V
    //   263: aload_0
    //   264: ifnull +7 -> 271
    //   267: aload_0
    //   268: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   271: iconst_0
    //   272: ireturn
    //   273: astore_1
    //   274: aload_1
    //   275: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   278: goto -15 -> 263
    //   281: astore_0
    //   282: aload_0
    //   283: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   286: goto -15 -> 271
    //   289: astore_0
    //   290: aconst_null
    //   291: astore_1
    //   292: aconst_null
    //   293: astore_2
    //   294: aload_1
    //   295: ifnull +7 -> 302
    //   298: aload_1
    //   299: invokevirtual 140	java/io/BufferedOutputStream:close	()V
    //   302: aload_2
    //   303: ifnull +7 -> 310
    //   306: aload_2
    //   307: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   310: aload_0
    //   311: athrow
    //   312: astore_1
    //   313: aload_1
    //   314: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   317: goto -15 -> 302
    //   320: astore_1
    //   321: aload_1
    //   322: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   325: goto -15 -> 310
    //   328: astore_0
    //   329: aconst_null
    //   330: astore_1
    //   331: goto -37 -> 294
    //   334: astore_0
    //   335: goto -41 -> 294
    //   338: astore 5
    //   340: aload_0
    //   341: astore_2
    //   342: aload 5
    //   344: astore_0
    //   345: goto -51 -> 294
    //   348: astore 5
    //   350: aconst_null
    //   351: astore_1
    //   352: aload_2
    //   353: astore_0
    //   354: aload 5
    //   356: astore_2
    //   357: goto -106 -> 251
    //   360: astore 5
    //   362: aload_2
    //   363: astore_0
    //   364: aload 5
    //   366: astore_2
    //   367: goto -116 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	paramString1	java.lang.String
    //   0	370	1	paramString2	java.lang.String
    //   0	370	2	paramString3	java.lang.String
    //   74	134	3	bool1	boolean
    //   195	30	4	bool2	boolean
    //   1	248	5	localObject1	Object
    //   338	5	5	localObject2	Object
    //   348	7	5	localIOException1	java.io.IOException
    //   360	5	5	localIOException2	java.io.IOException
    //   86	105	6	localFile1	java.io.File
    //   115	74	7	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   212	216	219	java/io/IOException
    //   121	128	227	java/io/UnsupportedEncodingException
    //   201	205	237	java/io/IOException
    //   160	170	245	java/io/IOException
    //   259	263	273	java/io/IOException
    //   267	271	281	java/io/IOException
    //   160	170	289	finally
    //   298	302	312	java/io/IOException
    //   306	310	320	java/io/IOException
    //   170	179	328	finally
    //   179	197	334	finally
    //   251	255	338	finally
    //   170	179	348	java/io/IOException
    //   179	197	360	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     llf
 * JD-Core Version:    0.7.0.1
 */