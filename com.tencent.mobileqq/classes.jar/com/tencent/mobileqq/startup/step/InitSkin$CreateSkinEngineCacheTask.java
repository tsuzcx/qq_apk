package com.tencent.mobileqq.startup.step;

import android.os.AsyncTask;
import com.tencent.image.Utils;

class InitSkin$CreateSkinEngineCacheTask
  extends AsyncTask<Void, Void, Void>
  implements Runnable
{
  private String a;
  private String b;
  
  public InitSkin$CreateSkinEngineCacheTask(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  /* Error */
  public Void a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 29	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   6: astore_1
    //   7: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +11 -> 21
    //   13: ldc 37
    //   15: iconst_2
    //   16: ldc 39
    //   18: invokestatic 43	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_0
    //   22: getfield 19	com/tencent/mobileqq/startup/step/InitSkin$CreateSkinEngineCacheTask:b	Ljava/lang/String;
    //   25: ldc 45
    //   27: invokevirtual 51	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   30: ifeq +142 -> 172
    //   33: new 53	java/io/File
    //   36: dup
    //   37: aload_1
    //   38: invokevirtual 57	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
    //   41: ldc 59
    //   43: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   46: astore 5
    //   48: aload 5
    //   50: invokevirtual 65	java/io/File:isDirectory	()Z
    //   53: ifeq +119 -> 172
    //   56: aload 5
    //   58: invokevirtual 69	java/io/File:list	()[Ljava/lang/String;
    //   61: astore 6
    //   63: aload 6
    //   65: ifnull +107 -> 172
    //   68: aload 6
    //   70: arraylength
    //   71: istore_3
    //   72: iconst_0
    //   73: istore_2
    //   74: iload_2
    //   75: iload_3
    //   76: if_icmpge +96 -> 172
    //   79: aload 6
    //   81: iload_2
    //   82: aaload
    //   83: astore 7
    //   85: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +39 -> 127
    //   91: new 71	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   98: astore 8
    //   100: aload 8
    //   102: ldc 74
    //   104: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 8
    //   110: aload 7
    //   112: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: ldc 37
    //   118: iconst_2
    //   119: aload 8
    //   121: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 43	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload 7
    //   129: ifnull +326 -> 455
    //   132: aload 7
    //   134: ldc 84
    //   136: invokevirtual 51	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   139: ifeq +316 -> 455
    //   142: new 53	java/io/File
    //   145: dup
    //   146: aload 5
    //   148: aload 7
    //   150: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   153: astore 7
    //   155: aload 7
    //   157: invokevirtual 87	java/io/File:exists	()Z
    //   160: ifeq +295 -> 455
    //   163: aload 7
    //   165: invokevirtual 90	java/io/File:delete	()Z
    //   168: pop
    //   169: goto +286 -> 455
    //   172: new 53	java/io/File
    //   175: dup
    //   176: aload_1
    //   177: invokevirtual 57	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
    //   180: aload_0
    //   181: getfield 17	com/tencent/mobileqq/startup/step/InitSkin$CreateSkinEngineCacheTask:a	Ljava/lang/String;
    //   184: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   187: astore 5
    //   189: new 53	java/io/File
    //   192: dup
    //   193: aload_1
    //   194: invokevirtual 57	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
    //   197: aload_0
    //   198: getfield 19	com/tencent/mobileqq/startup/step/InitSkin$CreateSkinEngineCacheTask:b	Ljava/lang/String;
    //   201: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   204: astore 6
    //   206: aload_1
    //   207: invokevirtual 57	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
    //   210: astore_1
    //   211: new 71	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   218: astore 7
    //   220: aload 7
    //   222: aload_0
    //   223: getfield 19	com/tencent/mobileqq/startup/step/InitSkin$CreateSkinEngineCacheTask:b	Ljava/lang/String;
    //   226: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload 7
    //   232: ldc 92
    //   234: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: new 53	java/io/File
    //   241: dup
    //   242: aload_1
    //   243: aload 7
    //   245: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   251: astore_1
    //   252: aload 5
    //   254: invokevirtual 95	java/io/File:getParentFile	()Ljava/io/File;
    //   257: astore 7
    //   259: aload 7
    //   261: invokevirtual 87	java/io/File:exists	()Z
    //   264: ifne +9 -> 273
    //   267: aload 7
    //   269: invokevirtual 98	java/io/File:mkdirs	()Z
    //   272: pop
    //   273: aload 6
    //   275: invokevirtual 87	java/io/File:exists	()Z
    //   278: ifeq +9 -> 287
    //   281: aload 6
    //   283: invokevirtual 90	java/io/File:delete	()Z
    //   286: pop
    //   287: aload 5
    //   289: invokevirtual 87	java/io/File:exists	()Z
    //   292: ifeq +9 -> 301
    //   295: aload 5
    //   297: invokevirtual 90	java/io/File:delete	()Z
    //   300: pop
    //   301: aload_1
    //   302: invokevirtual 87	java/io/File:exists	()Z
    //   305: ifeq +8 -> 313
    //   308: aload_1
    //   309: invokevirtual 90	java/io/File:delete	()Z
    //   312: pop
    //   313: invokestatic 104	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   316: aload_1
    //   317: invokevirtual 108	com/tencent/theme/SkinEngine:writeCacheFile	(Ljava/io/File;)V
    //   320: aload_1
    //   321: invokevirtual 87	java/io/File:exists	()Z
    //   324: ifeq +10 -> 334
    //   327: aload_1
    //   328: aload 6
    //   330: invokevirtual 112	java/io/File:renameTo	(Ljava/io/File;)Z
    //   333: pop
    //   334: new 114	java/io/ObjectOutputStream
    //   337: dup
    //   338: new 116	java/io/BufferedOutputStream
    //   341: dup
    //   342: new 118	java/io/FileOutputStream
    //   345: dup
    //   346: aload 5
    //   348: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   351: invokespecial 123	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   354: invokespecial 124	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   357: astore_1
    //   358: aload_1
    //   359: invokestatic 129	com/tencent/common/config/AppSetting:d	()I
    //   362: invokevirtual 133	java/io/ObjectOutputStream:writeInt	(I)V
    //   365: aload_1
    //   366: ldc 135
    //   368: invokevirtual 139	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   371: aload_1
    //   372: invokevirtual 142	java/io/ObjectOutputStream:close	()V
    //   375: aconst_null
    //   376: areturn
    //   377: astore 4
    //   379: goto +52 -> 431
    //   382: astore 4
    //   384: goto +19 -> 403
    //   387: astore 5
    //   389: aload 4
    //   391: astore_1
    //   392: aload 5
    //   394: astore 4
    //   396: goto +35 -> 431
    //   399: astore 4
    //   401: aconst_null
    //   402: astore_1
    //   403: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq +13 -> 419
    //   409: ldc 37
    //   411: iconst_2
    //   412: ldc 144
    //   414: aload 4
    //   416: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   419: aload_1
    //   420: ifnull +7 -> 427
    //   423: aload_1
    //   424: invokevirtual 142	java/io/ObjectOutputStream:close	()V
    //   427: aconst_null
    //   428: areturn
    //   429: astore 4
    //   431: aload_1
    //   432: ifnull +7 -> 439
    //   435: aload_1
    //   436: invokevirtual 142	java/io/ObjectOutputStream:close	()V
    //   439: goto +6 -> 445
    //   442: aload 4
    //   444: athrow
    //   445: goto -3 -> 442
    //   448: astore_1
    //   449: aconst_null
    //   450: areturn
    //   451: astore_1
    //   452: goto -13 -> 439
    //   455: iload_2
    //   456: iconst_1
    //   457: iadd
    //   458: istore_2
    //   459: goto -385 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	this	CreateSkinEngineCacheTask
    //   0	462	1	paramVarArgs	Void[]
    //   73	386	2	i	int
    //   71	6	3	j	int
    //   1	1	4	localObject1	java.lang.Object
    //   377	1	4	localObject2	java.lang.Object
    //   382	8	4	localIOException1	java.io.IOException
    //   394	1	4	localObject3	java.lang.Object
    //   399	16	4	localIOException2	java.io.IOException
    //   429	14	4	localObject4	java.lang.Object
    //   46	301	5	localFile	java.io.File
    //   387	6	5	localObject5	java.lang.Object
    //   61	268	6	localObject6	java.lang.Object
    //   83	185	7	localObject7	java.lang.Object
    //   98	22	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   358	371	377	finally
    //   358	371	382	java/io/IOException
    //   3	21	387	finally
    //   21	63	387	finally
    //   68	72	387	finally
    //   85	127	387	finally
    //   132	169	387	finally
    //   172	273	387	finally
    //   273	287	387	finally
    //   287	301	387	finally
    //   301	313	387	finally
    //   313	334	387	finally
    //   334	358	387	finally
    //   3	21	399	java/io/IOException
    //   21	63	399	java/io/IOException
    //   68	72	399	java/io/IOException
    //   85	127	399	java/io/IOException
    //   132	169	399	java/io/IOException
    //   172	273	399	java/io/IOException
    //   273	287	399	java/io/IOException
    //   287	301	399	java/io/IOException
    //   301	313	399	java/io/IOException
    //   313	334	399	java/io/IOException
    //   334	358	399	java/io/IOException
    //   403	419	429	finally
    //   371	375	448	java/io/IOException
    //   423	427	448	java/io/IOException
    //   435	439	451	java/io/IOException
  }
  
  public void run()
  {
    Utils.executeAsyncTaskOnThreadPool(this, new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin.CreateSkinEngineCacheTask
 * JD-Core Version:    0.7.0.1
 */