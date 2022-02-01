package com.tencent.mobileqq.minigame.utils;

public class FileUtils
{
  private static final String JS_TYPE = "js";
  private static final String TAG = "MiniGame-FileUtils";
  
  /* Error */
  public static void copyFilesFromAssets(android.content.Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 28	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: aload_1
    //   5: invokevirtual 34	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   8: astore 5
    //   10: aload 5
    //   12: arraylength
    //   13: istore 4
    //   15: iconst_0
    //   16: istore_3
    //   17: iload 4
    //   19: ifle +121 -> 140
    //   22: new 36	java/io/File
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: invokevirtual 43	java/io/File:mkdirs	()Z
    //   33: pop
    //   34: aload 5
    //   36: arraylength
    //   37: istore 4
    //   39: iload_3
    //   40: iload 4
    //   42: if_icmpge +345 -> 387
    //   45: aload 5
    //   47: iload_3
    //   48: aaload
    //   49: astore 6
    //   51: new 45	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   58: astore 7
    //   60: aload 7
    //   62: aload_1
    //   63: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 7
    //   69: ldc 52
    //   71: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 7
    //   77: aload 6
    //   79: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 7
    //   85: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore 7
    //   90: new 45	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   97: astore 8
    //   99: aload 8
    //   101: aload_2
    //   102: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 8
    //   108: ldc 52
    //   110: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload 8
    //   116: aload 6
    //   118: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_0
    //   123: aload 7
    //   125: aload 8
    //   127: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 58	com/tencent/mobileqq/minigame/utils/FileUtils:copyFilesFromAssets	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   133: iload_3
    //   134: iconst_1
    //   135: iadd
    //   136: istore_3
    //   137: goto -98 -> 39
    //   140: aconst_null
    //   141: astore 7
    //   143: aconst_null
    //   144: astore 6
    //   146: aload_0
    //   147: invokevirtual 28	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   150: aload_1
    //   151: invokevirtual 62	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   154: astore 5
    //   156: new 64	java/io/FileOutputStream
    //   159: dup
    //   160: new 36	java/io/File
    //   163: dup
    //   164: aload_2
    //   165: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   168: invokespecial 67	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   171: astore_0
    //   172: sipush 1024
    //   175: newarray byte
    //   177: astore_1
    //   178: aload 5
    //   180: aload_1
    //   181: invokevirtual 73	java/io/InputStream:read	([B)I
    //   184: istore_3
    //   185: iload_3
    //   186: iconst_m1
    //   187: if_icmpeq +13 -> 200
    //   190: aload_0
    //   191: aload_1
    //   192: iconst_0
    //   193: iload_3
    //   194: invokevirtual 77	java/io/FileOutputStream:write	([BII)V
    //   197: goto -19 -> 178
    //   200: aload_0
    //   201: invokevirtual 80	java/io/FileOutputStream:flush	()V
    //   204: aload 5
    //   206: invokevirtual 83	java/io/InputStream:close	()V
    //   209: aload_0
    //   210: invokevirtual 84	java/io/FileOutputStream:close	()V
    //   213: aload_0
    //   214: astore_1
    //   215: aload 5
    //   217: ifnull +10 -> 227
    //   220: aload 5
    //   222: invokevirtual 83	java/io/InputStream:close	()V
    //   225: aload_0
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual 84	java/io/FileOutputStream:close	()V
    //   231: return
    //   232: astore_1
    //   233: aload_0
    //   234: astore_2
    //   235: aload_1
    //   236: astore_0
    //   237: goto +10 -> 247
    //   240: astore_1
    //   241: goto +15 -> 256
    //   244: astore_0
    //   245: aconst_null
    //   246: astore_2
    //   247: aload 5
    //   249: astore_1
    //   250: goto +80 -> 330
    //   253: astore_1
    //   254: aconst_null
    //   255: astore_0
    //   256: aload 5
    //   258: astore_2
    //   259: goto +18 -> 277
    //   262: astore_0
    //   263: aconst_null
    //   264: astore_2
    //   265: aload 7
    //   267: astore_1
    //   268: goto +62 -> 330
    //   271: astore_1
    //   272: aconst_null
    //   273: astore_0
    //   274: aload 6
    //   276: astore_2
    //   277: new 45	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   284: astore 5
    //   286: aload 5
    //   288: ldc 86
    //   290: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload 5
    //   296: aload_1
    //   297: invokevirtual 89	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   300: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: ldc 11
    //   306: iconst_1
    //   307: aload 5
    //   309: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload_1
    //   316: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   319: aload_2
    //   320: ifnull +68 -> 388
    //   323: aload_2
    //   324: invokevirtual 83	java/io/InputStream:close	()V
    //   327: goto +61 -> 388
    //   330: aload_1
    //   331: ifnull +7 -> 338
    //   334: aload_1
    //   335: invokevirtual 83	java/io/InputStream:close	()V
    //   338: aload_2
    //   339: ifnull +7 -> 346
    //   342: aload_2
    //   343: invokevirtual 84	java/io/FileOutputStream:close	()V
    //   346: aload_0
    //   347: athrow
    //   348: astore_0
    //   349: new 45	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   356: astore_1
    //   357: aload_1
    //   358: ldc 100
    //   360: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload_1
    //   365: aload_0
    //   366: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   369: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: ldc 11
    //   375: iconst_1
    //   376: aload_1
    //   377: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: aload_0
    //   384: invokevirtual 102	java/lang/Exception:printStackTrace	()V
    //   387: return
    //   388: aload_0
    //   389: ifnull -2 -> 387
    //   392: aload_0
    //   393: astore_1
    //   394: goto -167 -> 227
    //   397: astore 5
    //   399: aload_2
    //   400: astore_1
    //   401: aload_0
    //   402: astore_2
    //   403: aload 5
    //   405: astore_0
    //   406: goto -76 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	paramContext	android.content.Context
    //   0	409	1	paramString1	String
    //   0	409	2	paramString2	String
    //   16	178	3	i	int
    //   13	30	4	j	int
    //   8	300	5	localObject1	Object
    //   397	7	5	localObject2	Object
    //   49	226	6	str	String
    //   58	208	7	localObject3	Object
    //   97	29	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   172	178	232	finally
    //   178	185	232	finally
    //   190	197	232	finally
    //   200	213	232	finally
    //   172	178	240	java/lang/Throwable
    //   178	185	240	java/lang/Throwable
    //   190	197	240	java/lang/Throwable
    //   200	213	240	java/lang/Throwable
    //   156	172	244	finally
    //   156	172	253	java/lang/Throwable
    //   146	156	262	finally
    //   146	156	271	java/lang/Throwable
    //   0	15	348	java/lang/Exception
    //   22	39	348	java/lang/Exception
    //   51	133	348	java/lang/Exception
    //   220	225	348	java/lang/Exception
    //   227	231	348	java/lang/Exception
    //   323	327	348	java/lang/Exception
    //   334	338	348	java/lang/Exception
    //   342	346	348	java/lang/Exception
    //   346	348	348	java/lang/Exception
    //   277	319	397	finally
  }
  
  /* Error */
  public static boolean copyFolder(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 36	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 6
    //   10: aload 6
    //   12: invokevirtual 107	java/io/File:exists	()Z
    //   15: istore 5
    //   17: iload 5
    //   19: ifne +21 -> 40
    //   22: aload 6
    //   24: invokevirtual 43	java/io/File:mkdirs	()Z
    //   27: ifne +13 -> 40
    //   30: ldc 109
    //   32: iconst_1
    //   33: ldc 111
    //   35: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: iconst_0
    //   39: ireturn
    //   40: new 36	java/io/File
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: invokevirtual 114	java/io/File:list	()[Ljava/lang/String;
    //   51: astore 10
    //   53: aload 10
    //   55: arraylength
    //   56: istore_3
    //   57: iconst_0
    //   58: istore_2
    //   59: iload_2
    //   60: iload_3
    //   61: if_icmpge +593 -> 654
    //   64: aload 10
    //   66: iload_2
    //   67: aaload
    //   68: astore 7
    //   70: aload_0
    //   71: getstatic 117	java/io/File:separator	Ljava/lang/String;
    //   74: invokevirtual 123	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   77: ifeq +44 -> 121
    //   80: new 45	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   87: astore 6
    //   89: aload 6
    //   91: aload_0
    //   92: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 6
    //   98: aload 7
    //   100: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: new 36	java/io/File
    //   107: dup
    //   108: aload 6
    //   110: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: astore 6
    //   118: goto +50 -> 168
    //   121: new 45	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   128: astore 6
    //   130: aload 6
    //   132: aload_0
    //   133: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 6
    //   139: getstatic 117	java/io/File:separator	Ljava/lang/String;
    //   142: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 6
    //   148: aload 7
    //   150: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: new 36	java/io/File
    //   157: dup
    //   158: aload 6
    //   160: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   166: astore 6
    //   168: new 45	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   175: astore 8
    //   177: aload 8
    //   179: aload_1
    //   180: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 8
    //   186: ldc 52
    //   188: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 8
    //   194: aload 6
    //   196: invokevirtual 126	java/io/File:getName	()Ljava/lang/String;
    //   199: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: new 36	java/io/File
    //   206: dup
    //   207: aload 8
    //   209: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   215: astore 8
    //   217: aload 6
    //   219: invokevirtual 129	java/io/File:isDirectory	()Z
    //   222: ifeq +88 -> 310
    //   225: new 45	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   232: astore 6
    //   234: aload 6
    //   236: aload_0
    //   237: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload 6
    //   243: ldc 52
    //   245: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 6
    //   251: aload 7
    //   253: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 6
    //   259: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: astore 6
    //   264: new 45	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   271: astore 8
    //   273: aload 8
    //   275: aload_1
    //   276: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 8
    //   282: ldc 52
    //   284: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 8
    //   290: aload 7
    //   292: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 6
    //   298: aload 8
    //   300: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 131	com/tencent/mobileqq/minigame/utils/FileUtils:copyFolder	(Ljava/lang/String;Ljava/lang/String;)Z
    //   306: pop
    //   307: goto +398 -> 705
    //   310: aload 6
    //   312: invokevirtual 107	java/io/File:exists	()Z
    //   315: ifne +13 -> 328
    //   318: ldc 109
    //   320: iconst_1
    //   321: ldc 133
    //   323: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   326: iconst_0
    //   327: ireturn
    //   328: aload 6
    //   330: invokevirtual 136	java/io/File:isFile	()Z
    //   333: ifne +13 -> 346
    //   336: ldc 109
    //   338: iconst_1
    //   339: ldc 138
    //   341: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: iconst_0
    //   345: ireturn
    //   346: aload 6
    //   348: invokevirtual 141	java/io/File:canRead	()Z
    //   351: ifne +13 -> 364
    //   354: ldc 109
    //   356: iconst_1
    //   357: ldc 143
    //   359: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: iconst_0
    //   363: ireturn
    //   364: aload 6
    //   366: invokevirtual 136	java/io/File:isFile	()Z
    //   369: ifeq +44 -> 413
    //   372: aload 8
    //   374: invokevirtual 107	java/io/File:exists	()Z
    //   377: ifeq +36 -> 413
    //   380: aload 8
    //   382: invokevirtual 136	java/io/File:isFile	()Z
    //   385: ifeq +28 -> 413
    //   388: aload 6
    //   390: invokevirtual 147	java/io/File:length	()J
    //   393: aload 8
    //   395: invokevirtual 147	java/io/File:length	()J
    //   398: lcmp
    //   399: ifne +306 -> 705
    //   402: ldc 109
    //   404: iconst_1
    //   405: ldc 149
    //   407: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: goto +295 -> 705
    //   413: aconst_null
    //   414: astore 9
    //   416: new 151	java/io/FileInputStream
    //   419: dup
    //   420: aload 6
    //   422: invokespecial 152	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   425: astore 7
    //   427: new 45	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   434: astore 8
    //   436: aload 8
    //   438: aload_1
    //   439: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload 8
    //   445: ldc 52
    //   447: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload 8
    //   453: aload 6
    //   455: invokevirtual 126	java/io/File:getName	()Ljava/lang/String;
    //   458: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: new 64	java/io/FileOutputStream
    //   465: dup
    //   466: aload 8
    //   468: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokespecial 153	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   474: astore 6
    //   476: sipush 1024
    //   479: newarray byte
    //   481: astore 8
    //   483: aload 7
    //   485: aload 8
    //   487: invokevirtual 154	java/io/FileInputStream:read	([B)I
    //   490: istore 4
    //   492: iload 4
    //   494: iconst_m1
    //   495: if_icmpeq +16 -> 511
    //   498: aload 6
    //   500: aload 8
    //   502: iconst_0
    //   503: iload 4
    //   505: invokevirtual 77	java/io/FileOutputStream:write	([BII)V
    //   508: goto -25 -> 483
    //   511: aload 6
    //   513: invokevirtual 80	java/io/FileOutputStream:flush	()V
    //   516: aload 7
    //   518: invokevirtual 155	java/io/FileInputStream:close	()V
    //   521: aload 6
    //   523: invokevirtual 84	java/io/FileOutputStream:close	()V
    //   526: goto +179 -> 705
    //   529: astore_0
    //   530: aload 7
    //   532: astore_1
    //   533: goto +101 -> 634
    //   536: astore 8
    //   538: goto +18 -> 556
    //   541: astore_0
    //   542: aconst_null
    //   543: astore 6
    //   545: aload 7
    //   547: astore_1
    //   548: goto +86 -> 634
    //   551: astore 8
    //   553: aconst_null
    //   554: astore 6
    //   556: goto +21 -> 577
    //   559: astore_0
    //   560: aconst_null
    //   561: astore_1
    //   562: aload_1
    //   563: astore 6
    //   565: goto +69 -> 634
    //   568: astore 8
    //   570: aconst_null
    //   571: astore 6
    //   573: aload 9
    //   575: astore 7
    //   577: new 45	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   584: astore 9
    //   586: aload 9
    //   588: ldc 157
    //   590: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload 9
    //   596: aload 8
    //   598: invokevirtual 89	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   601: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: ldc 11
    //   607: iconst_1
    //   608: aload 9
    //   610: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: aload 8
    //   618: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   621: aload 7
    //   623: ifnull +74 -> 697
    //   626: aload 7
    //   628: invokevirtual 155	java/io/FileInputStream:close	()V
    //   631: goto +66 -> 697
    //   634: aload_1
    //   635: ifnull +7 -> 642
    //   638: aload_1
    //   639: invokevirtual 155	java/io/FileInputStream:close	()V
    //   642: aload 6
    //   644: ifnull +8 -> 652
    //   647: aload 6
    //   649: invokevirtual 84	java/io/FileOutputStream:close	()V
    //   652: aload_0
    //   653: athrow
    //   654: iconst_1
    //   655: ireturn
    //   656: astore_0
    //   657: new 45	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   664: astore_1
    //   665: aload_1
    //   666: ldc 159
    //   668: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload_1
    //   673: aload_0
    //   674: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   677: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: ldc 11
    //   683: iconst_1
    //   684: aload_1
    //   685: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 95	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   691: aload_0
    //   692: invokevirtual 102	java/lang/Exception:printStackTrace	()V
    //   695: iconst_0
    //   696: ireturn
    //   697: aload 6
    //   699: ifnull +6 -> 705
    //   702: goto -181 -> 521
    //   705: iload_2
    //   706: iconst_1
    //   707: iadd
    //   708: istore_2
    //   709: goto -650 -> 59
    //   712: astore_0
    //   713: aload 7
    //   715: astore_1
    //   716: goto -82 -> 634
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	719	0	paramString1	String
    //   0	719	1	paramString2	String
    //   58	651	2	i	int
    //   56	6	3	j	int
    //   490	14	4	k	int
    //   15	3	5	bool	boolean
    //   8	690	6	localObject1	Object
    //   68	646	7	localObject2	Object
    //   175	326	8	localObject3	Object
    //   536	1	8	localThrowable1	java.lang.Throwable
    //   551	1	8	localThrowable2	java.lang.Throwable
    //   568	49	8	localThrowable3	java.lang.Throwable
    //   414	195	9	localStringBuilder	java.lang.StringBuilder
    //   51	14	10	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   476	483	529	finally
    //   483	492	529	finally
    //   498	508	529	finally
    //   511	516	529	finally
    //   476	483	536	java/lang/Throwable
    //   483	492	536	java/lang/Throwable
    //   498	508	536	java/lang/Throwable
    //   511	516	536	java/lang/Throwable
    //   427	476	541	finally
    //   427	476	551	java/lang/Throwable
    //   416	427	559	finally
    //   416	427	568	java/lang/Throwable
    //   0	17	656	java/lang/Exception
    //   22	38	656	java/lang/Exception
    //   40	57	656	java/lang/Exception
    //   70	118	656	java/lang/Exception
    //   121	168	656	java/lang/Exception
    //   168	307	656	java/lang/Exception
    //   310	326	656	java/lang/Exception
    //   328	344	656	java/lang/Exception
    //   346	362	656	java/lang/Exception
    //   364	410	656	java/lang/Exception
    //   516	521	656	java/lang/Exception
    //   521	526	656	java/lang/Exception
    //   626	631	656	java/lang/Exception
    //   638	642	656	java/lang/Exception
    //   647	652	656	java/lang/Exception
    //   652	654	656	java/lang/Exception
    //   577	621	712	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */