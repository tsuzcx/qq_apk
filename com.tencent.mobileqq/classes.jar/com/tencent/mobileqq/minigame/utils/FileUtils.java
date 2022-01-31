package com.tencent.mobileqq.minigame.utils;

public class FileUtils
{
  private static final String JS_TYPE = "js";
  private static final String TAG = "MiniGame-FileUtils";
  
  /* Error */
  public static void copyFilesFromAssets(android.content.Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: iconst_0
    //   7: istore_3
    //   8: aload_0
    //   9: invokevirtual 28	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: aload_1
    //   13: invokevirtual 34	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   16: astore 7
    //   18: aload 7
    //   20: arraylength
    //   21: ifle +91 -> 112
    //   24: new 36	java/io/File
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: invokevirtual 43	java/io/File:mkdirs	()Z
    //   35: pop
    //   36: aload 7
    //   38: arraylength
    //   39: istore 4
    //   41: iload_3
    //   42: iload 4
    //   44: if_icmpge +175 -> 219
    //   47: aload 7
    //   49: iload_3
    //   50: aaload
    //   51: astore 5
    //   53: aload_0
    //   54: new 45	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   61: aload_1
    //   62: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc 52
    //   67: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload 5
    //   72: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: new 45	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   85: aload_2
    //   86: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 52
    //   91: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload 5
    //   96: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 58	com/tencent/mobileqq/minigame/utils/FileUtils:copyFilesFromAssets	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   105: iload_3
    //   106: iconst_1
    //   107: iadd
    //   108: istore_3
    //   109: goto -68 -> 41
    //   112: aload_0
    //   113: invokevirtual 28	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   116: aload_1
    //   117: invokevirtual 62	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   120: astore_0
    //   121: new 64	java/io/FileOutputStream
    //   124: dup
    //   125: new 36	java/io/File
    //   128: dup
    //   129: aload_2
    //   130: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   133: invokespecial 67	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   136: astore_1
    //   137: sipush 1024
    //   140: newarray byte
    //   142: astore_2
    //   143: aload_0
    //   144: aload_2
    //   145: invokevirtual 73	java/io/InputStream:read	([B)I
    //   148: istore_3
    //   149: iload_3
    //   150: iconst_m1
    //   151: if_icmpeq +69 -> 220
    //   154: aload_1
    //   155: aload_2
    //   156: iconst_0
    //   157: iload_3
    //   158: invokevirtual 77	java/io/FileOutputStream:write	([BII)V
    //   161: goto -18 -> 143
    //   164: astore 5
    //   166: aload_0
    //   167: astore_2
    //   168: aload 5
    //   170: astore_0
    //   171: ldc 11
    //   173: iconst_1
    //   174: new 45	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   181: ldc 79
    //   183: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_0
    //   187: invokevirtual 82	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   190: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   199: aload_0
    //   200: invokevirtual 91	java/lang/Throwable:printStackTrace	()V
    //   203: aload_2
    //   204: ifnull +7 -> 211
    //   207: aload_2
    //   208: invokevirtual 94	java/io/InputStream:close	()V
    //   211: aload_1
    //   212: ifnull +7 -> 219
    //   215: aload_1
    //   216: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   219: return
    //   220: aload_1
    //   221: invokevirtual 98	java/io/FileOutputStream:flush	()V
    //   224: aload_0
    //   225: invokevirtual 94	java/io/InputStream:close	()V
    //   228: aload_1
    //   229: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   232: aload_0
    //   233: ifnull +7 -> 240
    //   236: aload_0
    //   237: invokevirtual 94	java/io/InputStream:close	()V
    //   240: aload_1
    //   241: ifnull -22 -> 219
    //   244: aload_1
    //   245: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   248: return
    //   249: astore_0
    //   250: ldc 11
    //   252: iconst_1
    //   253: new 45	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   260: ldc 100
    //   262: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_0
    //   266: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   269: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: aload_0
    //   279: invokevirtual 102	java/lang/Exception:printStackTrace	()V
    //   282: return
    //   283: astore_0
    //   284: aconst_null
    //   285: astore_1
    //   286: aload 6
    //   288: astore_2
    //   289: aload_2
    //   290: ifnull +7 -> 297
    //   293: aload_2
    //   294: invokevirtual 94	java/io/InputStream:close	()V
    //   297: aload_1
    //   298: ifnull +7 -> 305
    //   301: aload_1
    //   302: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   305: aload_0
    //   306: athrow
    //   307: astore 5
    //   309: aconst_null
    //   310: astore_1
    //   311: aload_0
    //   312: astore_2
    //   313: aload 5
    //   315: astore_0
    //   316: goto -27 -> 289
    //   319: astore 5
    //   321: aload_0
    //   322: astore_2
    //   323: aload 5
    //   325: astore_0
    //   326: goto -37 -> 289
    //   329: astore_0
    //   330: goto -41 -> 289
    //   333: astore_0
    //   334: aconst_null
    //   335: astore_1
    //   336: aload 5
    //   338: astore_2
    //   339: goto -168 -> 171
    //   342: astore 5
    //   344: aconst_null
    //   345: astore_1
    //   346: aload_0
    //   347: astore_2
    //   348: aload 5
    //   350: astore_0
    //   351: goto -180 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	paramContext	android.content.Context
    //   0	354	1	paramString1	String
    //   0	354	2	paramString2	String
    //   7	151	3	i	int
    //   39	6	4	j	int
    //   4	91	5	str	String
    //   164	5	5	localThrowable1	java.lang.Throwable
    //   307	7	5	localObject1	Object
    //   319	18	5	localObject2	Object
    //   342	7	5	localThrowable2	java.lang.Throwable
    //   1	286	6	localObject3	Object
    //   16	32	7	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   137	143	164	java/lang/Throwable
    //   143	149	164	java/lang/Throwable
    //   154	161	164	java/lang/Throwable
    //   220	232	164	java/lang/Throwable
    //   8	41	249	java/lang/Exception
    //   53	105	249	java/lang/Exception
    //   207	211	249	java/lang/Exception
    //   215	219	249	java/lang/Exception
    //   236	240	249	java/lang/Exception
    //   244	248	249	java/lang/Exception
    //   293	297	249	java/lang/Exception
    //   301	305	249	java/lang/Exception
    //   305	307	249	java/lang/Exception
    //   112	121	283	finally
    //   121	137	307	finally
    //   137	143	319	finally
    //   143	149	319	finally
    //   154	161	319	finally
    //   220	232	319	finally
    //   171	203	329	finally
    //   112	121	333	java/lang/Throwable
    //   121	137	342	java/lang/Throwable
  }
  
  /* Error */
  public static boolean copyFolder(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 36	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aload 5
    //   12: invokevirtual 107	java/io/File:exists	()Z
    //   15: ifne +21 -> 36
    //   18: aload 5
    //   20: invokevirtual 43	java/io/File:mkdirs	()Z
    //   23: ifne +13 -> 36
    //   26: ldc 109
    //   28: iconst_1
    //   29: ldc 111
    //   31: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: iconst_0
    //   35: ireturn
    //   36: new 36	java/io/File
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: invokevirtual 114	java/io/File:list	()[Ljava/lang/String;
    //   47: astore 10
    //   49: aload 10
    //   51: arraylength
    //   52: istore_3
    //   53: iconst_0
    //   54: istore_2
    //   55: iload_2
    //   56: iload_3
    //   57: if_icmpge +560 -> 617
    //   60: aload 10
    //   62: iload_2
    //   63: aaload
    //   64: astore 6
    //   66: aload_0
    //   67: getstatic 117	java/io/File:separator	Ljava/lang/String;
    //   70: invokevirtual 123	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   73: ifeq +130 -> 203
    //   76: new 36	java/io/File
    //   79: dup
    //   80: new 45	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   87: aload_0
    //   88: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 6
    //   93: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   102: astore 5
    //   104: new 36	java/io/File
    //   107: dup
    //   108: new 45	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   115: aload_1
    //   116: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc 52
    //   121: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload 5
    //   126: invokevirtual 126	java/io/File:getName	()Ljava/lang/String;
    //   129: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   138: astore 7
    //   140: aload 5
    //   142: invokevirtual 129	java/io/File:isDirectory	()Z
    //   145: ifeq +130 -> 275
    //   148: new 45	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   155: aload_0
    //   156: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc 52
    //   161: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 6
    //   166: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: new 45	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   179: aload_1
    //   180: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc 52
    //   185: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload 6
    //   190: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 131	com/tencent/mobileqq/minigame/utils/FileUtils:copyFolder	(Ljava/lang/String;Ljava/lang/String;)Z
    //   199: pop
    //   200: goto +453 -> 653
    //   203: new 36	java/io/File
    //   206: dup
    //   207: new 45	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   214: aload_0
    //   215: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: getstatic 117	java/io/File:separator	Ljava/lang/String;
    //   221: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload 6
    //   226: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   235: astore 5
    //   237: goto -133 -> 104
    //   240: astore_0
    //   241: ldc 11
    //   243: iconst_1
    //   244: new 45	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   251: ldc 133
    //   253: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_0
    //   257: invokevirtual 101	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   260: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: aload_0
    //   270: invokevirtual 102	java/lang/Exception:printStackTrace	()V
    //   273: iconst_0
    //   274: ireturn
    //   275: aload 5
    //   277: invokevirtual 107	java/io/File:exists	()Z
    //   280: ifne +13 -> 293
    //   283: ldc 109
    //   285: iconst_1
    //   286: ldc 135
    //   288: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: iconst_0
    //   292: ireturn
    //   293: aload 5
    //   295: invokevirtual 138	java/io/File:isFile	()Z
    //   298: ifne +13 -> 311
    //   301: ldc 109
    //   303: iconst_1
    //   304: ldc 140
    //   306: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: iconst_0
    //   310: ireturn
    //   311: aload 5
    //   313: invokevirtual 143	java/io/File:canRead	()Z
    //   316: ifne +13 -> 329
    //   319: ldc 109
    //   321: iconst_1
    //   322: ldc 145
    //   324: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   327: iconst_0
    //   328: ireturn
    //   329: aload 5
    //   331: invokevirtual 138	java/io/File:isFile	()Z
    //   334: ifeq +44 -> 378
    //   337: aload 7
    //   339: invokevirtual 107	java/io/File:exists	()Z
    //   342: ifeq +36 -> 378
    //   345: aload 7
    //   347: invokevirtual 138	java/io/File:isFile	()Z
    //   350: ifeq +28 -> 378
    //   353: aload 5
    //   355: invokevirtual 149	java/io/File:length	()J
    //   358: aload 7
    //   360: invokevirtual 149	java/io/File:length	()J
    //   363: lcmp
    //   364: ifne +289 -> 653
    //   367: ldc 109
    //   369: iconst_1
    //   370: ldc 151
    //   372: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: goto +278 -> 653
    //   378: new 153	java/io/FileInputStream
    //   381: dup
    //   382: aload 5
    //   384: invokespecial 154	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   387: astore 6
    //   389: new 64	java/io/FileOutputStream
    //   392: dup
    //   393: new 45	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   400: aload_1
    //   401: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: ldc 52
    //   406: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: aload 5
    //   411: invokevirtual 126	java/io/File:getName	()Ljava/lang/String;
    //   414: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokespecial 155	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   423: astore 5
    //   425: aload 5
    //   427: astore 8
    //   429: aload 6
    //   431: astore 7
    //   433: sipush 1024
    //   436: newarray byte
    //   438: astore 9
    //   440: aload 5
    //   442: astore 8
    //   444: aload 6
    //   446: astore 7
    //   448: aload 6
    //   450: aload 9
    //   452: invokevirtual 156	java/io/FileInputStream:read	([B)I
    //   455: istore 4
    //   457: iload 4
    //   459: iconst_m1
    //   460: if_icmpeq +99 -> 559
    //   463: aload 5
    //   465: astore 8
    //   467: aload 6
    //   469: astore 7
    //   471: aload 5
    //   473: aload 9
    //   475: iconst_0
    //   476: iload 4
    //   478: invokevirtual 77	java/io/FileOutputStream:write	([BII)V
    //   481: goto -41 -> 440
    //   484: astore 9
    //   486: aload 5
    //   488: astore 8
    //   490: aload 6
    //   492: astore 7
    //   494: ldc 11
    //   496: iconst_1
    //   497: new 45	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   504: ldc 158
    //   506: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload 9
    //   511: invokevirtual 82	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   514: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: aload 5
    //   525: astore 8
    //   527: aload 6
    //   529: astore 7
    //   531: aload 9
    //   533: invokevirtual 91	java/lang/Throwable:printStackTrace	()V
    //   536: aload 6
    //   538: ifnull +8 -> 546
    //   541: aload 6
    //   543: invokevirtual 159	java/io/FileInputStream:close	()V
    //   546: aload 5
    //   548: ifnull +105 -> 653
    //   551: aload 5
    //   553: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   556: goto +97 -> 653
    //   559: aload 5
    //   561: astore 8
    //   563: aload 6
    //   565: astore 7
    //   567: aload 5
    //   569: invokevirtual 98	java/io/FileOutputStream:flush	()V
    //   572: aload 6
    //   574: ifnull +8 -> 582
    //   577: aload 6
    //   579: invokevirtual 159	java/io/FileInputStream:close	()V
    //   582: aload 5
    //   584: ifnull +69 -> 653
    //   587: aload 5
    //   589: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   592: goto +61 -> 653
    //   595: aload 6
    //   597: ifnull +8 -> 605
    //   600: aload 6
    //   602: invokevirtual 159	java/io/FileInputStream:close	()V
    //   605: aload 8
    //   607: ifnull +8 -> 615
    //   610: aload 8
    //   612: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   615: aload_0
    //   616: athrow
    //   617: iconst_1
    //   618: ireturn
    //   619: astore_0
    //   620: aconst_null
    //   621: astore 8
    //   623: goto -28 -> 595
    //   626: astore_0
    //   627: aload 7
    //   629: astore 6
    //   631: goto -36 -> 595
    //   634: astore 9
    //   636: aconst_null
    //   637: astore 5
    //   639: aconst_null
    //   640: astore 6
    //   642: goto -156 -> 486
    //   645: astore 9
    //   647: aconst_null
    //   648: astore 5
    //   650: goto -164 -> 486
    //   653: iload_2
    //   654: iconst_1
    //   655: iadd
    //   656: istore_2
    //   657: goto -602 -> 55
    //   660: astore_0
    //   661: aconst_null
    //   662: astore 8
    //   664: aconst_null
    //   665: astore 6
    //   667: goto -72 -> 595
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	670	0	paramString1	String
    //   0	670	1	paramString2	String
    //   54	603	2	i	int
    //   52	6	3	j	int
    //   455	22	4	k	int
    //   8	641	5	localObject1	Object
    //   64	602	6	localObject2	Object
    //   138	490	7	localObject3	Object
    //   427	236	8	localObject4	Object
    //   438	36	9	arrayOfByte	byte[]
    //   484	48	9	localThrowable1	java.lang.Throwable
    //   634	1	9	localThrowable2	java.lang.Throwable
    //   645	1	9	localThrowable3	java.lang.Throwable
    //   47	14	10	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   0	34	240	java/lang/Exception
    //   36	53	240	java/lang/Exception
    //   66	104	240	java/lang/Exception
    //   104	200	240	java/lang/Exception
    //   203	237	240	java/lang/Exception
    //   275	291	240	java/lang/Exception
    //   293	309	240	java/lang/Exception
    //   311	327	240	java/lang/Exception
    //   329	375	240	java/lang/Exception
    //   541	546	240	java/lang/Exception
    //   551	556	240	java/lang/Exception
    //   577	582	240	java/lang/Exception
    //   587	592	240	java/lang/Exception
    //   600	605	240	java/lang/Exception
    //   610	615	240	java/lang/Exception
    //   615	617	240	java/lang/Exception
    //   433	440	484	java/lang/Throwable
    //   448	457	484	java/lang/Throwable
    //   471	481	484	java/lang/Throwable
    //   567	572	484	java/lang/Throwable
    //   389	425	619	finally
    //   433	440	626	finally
    //   448	457	626	finally
    //   471	481	626	finally
    //   494	523	626	finally
    //   531	536	626	finally
    //   567	572	626	finally
    //   378	389	634	java/lang/Throwable
    //   389	425	645	java/lang/Throwable
    //   378	389	660	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */