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
    //   1: astore_1
    //   2: getstatic 29	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   5: astore 4
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
    //   30: ifeq +138 -> 168
    //   33: new 53	java/io/File
    //   36: dup
    //   37: aload 4
    //   39: invokevirtual 57	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
    //   42: ldc 59
    //   44: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   47: astore 5
    //   49: aload 5
    //   51: ifnull +117 -> 168
    //   54: aload 5
    //   56: invokevirtual 65	java/io/File:isDirectory	()Z
    //   59: ifeq +109 -> 168
    //   62: aload 5
    //   64: invokevirtual 69	java/io/File:list	()[Ljava/lang/String;
    //   67: astore 6
    //   69: aload 6
    //   71: ifnull +97 -> 168
    //   74: aload 6
    //   76: arraylength
    //   77: istore_3
    //   78: iconst_0
    //   79: istore_2
    //   80: iload_2
    //   81: iload_3
    //   82: if_icmpge +86 -> 168
    //   85: aload 6
    //   87: iload_2
    //   88: aaload
    //   89: astore 7
    //   91: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +29 -> 123
    //   97: ldc 37
    //   99: iconst_2
    //   100: new 71	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   107: ldc 74
    //   109: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 7
    //   114: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 43	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload 7
    //   125: ifnull +346 -> 471
    //   128: aload 7
    //   130: ldc 84
    //   132: invokevirtual 51	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   135: ifeq +336 -> 471
    //   138: new 53	java/io/File
    //   141: dup
    //   142: aload 5
    //   144: aload 7
    //   146: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   149: astore 7
    //   151: aload 7
    //   153: invokevirtual 87	java/io/File:exists	()Z
    //   156: ifeq +315 -> 471
    //   159: aload 7
    //   161: invokevirtual 90	java/io/File:delete	()Z
    //   164: pop
    //   165: goto +306 -> 471
    //   168: new 53	java/io/File
    //   171: dup
    //   172: aload 4
    //   174: invokevirtual 57	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
    //   177: aload_0
    //   178: getfield 17	com/tencent/mobileqq/startup/step/InitSkin$CreateSkinEngineCacheTask:a	Ljava/lang/String;
    //   181: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   184: astore 5
    //   186: new 53	java/io/File
    //   189: dup
    //   190: aload 4
    //   192: invokevirtual 57	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
    //   195: aload_0
    //   196: getfield 19	com/tencent/mobileqq/startup/step/InitSkin$CreateSkinEngineCacheTask:b	Ljava/lang/String;
    //   199: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   202: astore 6
    //   204: new 53	java/io/File
    //   207: dup
    //   208: aload 4
    //   210: invokevirtual 57	com/tencent/common/app/BaseApplicationImpl:getCacheDir	()Ljava/io/File;
    //   213: new 71	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   220: aload_0
    //   221: getfield 19	com/tencent/mobileqq/startup/step/InitSkin$CreateSkinEngineCacheTask:b	Ljava/lang/String;
    //   224: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc 92
    //   229: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   238: astore 4
    //   240: aload 5
    //   242: invokevirtual 95	java/io/File:getParentFile	()Ljava/io/File;
    //   245: astore 7
    //   247: aload 7
    //   249: invokevirtual 87	java/io/File:exists	()Z
    //   252: ifne +9 -> 261
    //   255: aload 7
    //   257: invokevirtual 98	java/io/File:mkdirs	()Z
    //   260: pop
    //   261: aload 6
    //   263: invokevirtual 87	java/io/File:exists	()Z
    //   266: ifeq +9 -> 275
    //   269: aload 6
    //   271: invokevirtual 90	java/io/File:delete	()Z
    //   274: pop
    //   275: aload 5
    //   277: invokevirtual 87	java/io/File:exists	()Z
    //   280: ifeq +9 -> 289
    //   283: aload 5
    //   285: invokevirtual 90	java/io/File:delete	()Z
    //   288: pop
    //   289: aload 4
    //   291: invokevirtual 87	java/io/File:exists	()Z
    //   294: ifeq +9 -> 303
    //   297: aload 4
    //   299: invokevirtual 90	java/io/File:delete	()Z
    //   302: pop
    //   303: invokestatic 104	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   306: aload 4
    //   308: invokevirtual 108	com/tencent/theme/SkinEngine:writeCacheFile	(Ljava/io/File;)V
    //   311: aload 4
    //   313: invokevirtual 87	java/io/File:exists	()Z
    //   316: ifeq +11 -> 327
    //   319: aload 4
    //   321: aload 6
    //   323: invokevirtual 112	java/io/File:renameTo	(Ljava/io/File;)Z
    //   326: pop
    //   327: new 114	java/io/ObjectOutputStream
    //   330: dup
    //   331: new 116	java/io/BufferedOutputStream
    //   334: dup
    //   335: new 118	java/io/FileOutputStream
    //   338: dup
    //   339: aload 5
    //   341: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   344: invokespecial 123	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   347: invokespecial 124	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   350: astore 4
    //   352: aload 4
    //   354: astore_1
    //   355: aload 4
    //   357: invokestatic 129	com/tencent/common/config/AppSetting:a	()I
    //   360: invokevirtual 133	java/io/ObjectOutputStream:writeInt	(I)V
    //   363: aload 4
    //   365: astore_1
    //   366: aload 4
    //   368: ldc 135
    //   370: invokevirtual 139	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   373: aload 4
    //   375: ifnull +8 -> 383
    //   378: aload 4
    //   380: invokevirtual 142	java/io/ObjectOutputStream:close	()V
    //   383: aconst_null
    //   384: areturn
    //   385: astore 5
    //   387: aconst_null
    //   388: astore 4
    //   390: aload 4
    //   392: astore_1
    //   393: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   396: ifeq +16 -> 412
    //   399: aload 4
    //   401: astore_1
    //   402: ldc 37
    //   404: iconst_2
    //   405: ldc 144
    //   407: aload 5
    //   409: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   412: aload 4
    //   414: ifnull -31 -> 383
    //   417: aload 4
    //   419: invokevirtual 142	java/io/ObjectOutputStream:close	()V
    //   422: aconst_null
    //   423: areturn
    //   424: astore_1
    //   425: aconst_null
    //   426: areturn
    //   427: astore 5
    //   429: aload_1
    //   430: astore 4
    //   432: aload 5
    //   434: astore_1
    //   435: aload 4
    //   437: ifnull +8 -> 445
    //   440: aload 4
    //   442: invokevirtual 142	java/io/ObjectOutputStream:close	()V
    //   445: aload_1
    //   446: athrow
    //   447: astore_1
    //   448: aconst_null
    //   449: areturn
    //   450: astore 4
    //   452: goto -7 -> 445
    //   455: astore 5
    //   457: aload_1
    //   458: astore 4
    //   460: aload 5
    //   462: astore_1
    //   463: goto -28 -> 435
    //   466: astore 5
    //   468: goto -78 -> 390
    //   471: iload_2
    //   472: iconst_1
    //   473: iadd
    //   474: istore_2
    //   475: goto -395 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	this	CreateSkinEngineCacheTask
    //   0	478	1	paramVarArgs	Void[]
    //   79	396	2	i	int
    //   77	6	3	j	int
    //   5	436	4	localObject1	java.lang.Object
    //   450	1	4	localIOException1	java.io.IOException
    //   458	1	4	arrayOfVoid	Void[]
    //   47	293	5	localFile	java.io.File
    //   385	23	5	localIOException2	java.io.IOException
    //   427	6	5	localObject2	java.lang.Object
    //   455	6	5	localObject3	java.lang.Object
    //   466	1	5	localIOException3	java.io.IOException
    //   67	255	6	localObject4	java.lang.Object
    //   89	167	7	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	21	385	java/io/IOException
    //   21	49	385	java/io/IOException
    //   54	69	385	java/io/IOException
    //   74	78	385	java/io/IOException
    //   91	123	385	java/io/IOException
    //   128	165	385	java/io/IOException
    //   168	261	385	java/io/IOException
    //   261	275	385	java/io/IOException
    //   275	289	385	java/io/IOException
    //   289	303	385	java/io/IOException
    //   303	327	385	java/io/IOException
    //   327	352	385	java/io/IOException
    //   417	422	424	java/io/IOException
    //   2	21	427	finally
    //   21	49	427	finally
    //   54	69	427	finally
    //   74	78	427	finally
    //   91	123	427	finally
    //   128	165	427	finally
    //   168	261	427	finally
    //   261	275	427	finally
    //   275	289	427	finally
    //   289	303	427	finally
    //   303	327	427	finally
    //   327	352	427	finally
    //   378	383	447	java/io/IOException
    //   440	445	450	java/io/IOException
    //   355	363	455	finally
    //   366	373	455	finally
    //   393	399	455	finally
    //   402	412	455	finally
    //   355	363	466	java/io/IOException
    //   366	373	466	java/io/IOException
  }
  
  public void run()
  {
    Utils.executeAsyncTaskOnThreadPool(this, new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitSkin.CreateSkinEngineCacheTask
 * JD-Core Version:    0.7.0.1
 */