package dov.com.tencent.mobileqq.shortvideo;

import java.io.InputStream;
import mqq.os.MqqHandler;

public class ShortVideoUtils$VideoFileSaveRunnable
  implements Runnable
{
  InputStream jdField_a_of_type_JavaIoInputStream;
  String jdField_a_of_type_JavaLangString;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean;
  String b;
  
  public ShortVideoUtils$VideoFileSaveRunnable(String paramString1, MqqHandler paramMqqHandler, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.b = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 7
    //   12: aload_0
    //   13: getfield 19	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifne +13 -> 32
    //   22: aload_0
    //   23: getfield 19	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   26: invokestatic 42	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   29: ifne +54 -> 83
    //   32: aload_0
    //   33: getfield 44	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   36: ifnonnull +47 -> 83
    //   39: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +31 -> 73
    //   45: ldc 52
    //   47: iconst_2
    //   48: new 54	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   55: ldc 57
    //   57: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_0
    //   61: getfield 19	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   64: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 69	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aload_0
    //   74: getfield 21	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   77: iconst_1
    //   78: invokevirtual 75	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   81: pop
    //   82: return
    //   83: aload_0
    //   84: getfield 44	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   87: ifnonnull +431 -> 518
    //   90: new 77	java/io/File
    //   93: dup
    //   94: aload_0
    //   95: getfield 19	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   98: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: astore_3
    //   102: invokestatic 84	com/tencent/util/VersionUtils:b	()Z
    //   105: ifeq +70 -> 175
    //   108: getstatic 89	android/os/Environment:DIRECTORY_MOVIES	Ljava/lang/String;
    //   111: invokestatic 93	android/os/Environment:getExternalStoragePublicDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   114: astore_2
    //   115: aload_2
    //   116: invokevirtual 96	java/io/File:mkdirs	()Z
    //   119: pop
    //   120: new 77	java/io/File
    //   123: dup
    //   124: aload_2
    //   125: aload_0
    //   126: getfield 23	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:b	Ljava/lang/String;
    //   129: invokestatic 102	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:c	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokespecial 105	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   135: astore 10
    //   137: aload_0
    //   138: getfield 25	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_Boolean	Z
    //   141: ifne +48 -> 189
    //   144: aload 10
    //   146: invokevirtual 108	java/io/File:exists	()Z
    //   149: ifeq +40 -> 189
    //   152: aload_0
    //   153: getfield 21	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   156: iconst_3
    //   157: aload_0
    //   158: getfield 19	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   161: invokevirtual 112	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   164: astore_2
    //   165: aload_0
    //   166: getfield 21	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   169: aload_2
    //   170: invokevirtual 116	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   173: pop
    //   174: return
    //   175: new 77	java/io/File
    //   178: dup
    //   179: getstatic 121	com/tencent/mobileqq/app/AppConstants:bd	Ljava/lang/String;
    //   182: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   185: astore_2
    //   186: goto -71 -> 115
    //   189: new 123	java/io/FileOutputStream
    //   192: dup
    //   193: aload 10
    //   195: invokespecial 126	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   198: astore 6
    //   200: aload 7
    //   202: astore 5
    //   204: aload 9
    //   206: astore_2
    //   207: aload 6
    //   209: astore 4
    //   211: aload_0
    //   212: getfield 44	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   215: ifnull +161 -> 376
    //   218: aload 7
    //   220: astore 5
    //   222: aload 9
    //   224: astore_2
    //   225: aload 6
    //   227: astore 4
    //   229: aload_0
    //   230: getfield 44	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   233: astore_3
    //   234: aload_3
    //   235: astore 5
    //   237: aload_3
    //   238: astore_2
    //   239: aload 6
    //   241: astore 4
    //   243: ldc 127
    //   245: newarray byte
    //   247: astore 7
    //   249: aload_3
    //   250: astore 5
    //   252: aload_3
    //   253: astore_2
    //   254: aload 6
    //   256: astore 4
    //   258: aload_3
    //   259: aload 7
    //   261: invokevirtual 133	java/io/InputStream:read	([B)I
    //   264: istore_1
    //   265: iload_1
    //   266: iconst_m1
    //   267: if_icmpeq +132 -> 399
    //   270: aload_3
    //   271: astore 5
    //   273: aload_3
    //   274: astore_2
    //   275: aload 6
    //   277: astore 4
    //   279: aload 6
    //   281: aload 7
    //   283: iconst_0
    //   284: iload_1
    //   285: invokevirtual 137	java/io/FileOutputStream:write	([BII)V
    //   288: aload_3
    //   289: astore 5
    //   291: aload_3
    //   292: astore_2
    //   293: aload 6
    //   295: astore 4
    //   297: aload 6
    //   299: invokevirtual 140	java/io/FileOutputStream:flush	()V
    //   302: goto -53 -> 249
    //   305: astore_2
    //   306: aload 6
    //   308: astore_3
    //   309: aload_2
    //   310: astore 6
    //   312: aload 5
    //   314: astore_2
    //   315: aload_3
    //   316: astore 4
    //   318: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +19 -> 340
    //   324: aload 5
    //   326: astore_2
    //   327: aload_3
    //   328: astore 4
    //   330: ldc 52
    //   332: iconst_2
    //   333: ldc 142
    //   335: aload 6
    //   337: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   340: aload 5
    //   342: astore_2
    //   343: aload_3
    //   344: astore 4
    //   346: aload_0
    //   347: getfield 21	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   350: iconst_1
    //   351: invokevirtual 75	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   354: pop
    //   355: aload_3
    //   356: ifnull +7 -> 363
    //   359: aload_3
    //   360: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   363: aload 5
    //   365: ifnull -283 -> 82
    //   368: aload 5
    //   370: invokevirtual 149	java/io/InputStream:close	()V
    //   373: return
    //   374: astore_2
    //   375: return
    //   376: aload 7
    //   378: astore 5
    //   380: aload 9
    //   382: astore_2
    //   383: aload 6
    //   385: astore 4
    //   387: new 151	java/io/FileInputStream
    //   390: dup
    //   391: aload_3
    //   392: invokespecial 152	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   395: astore_3
    //   396: goto -162 -> 234
    //   399: aload_3
    //   400: astore 5
    //   402: aload_3
    //   403: astore_2
    //   404: aload 6
    //   406: astore 4
    //   408: aload_0
    //   409: getfield 21	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   412: iconst_2
    //   413: aload 10
    //   415: invokevirtual 155	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   418: invokevirtual 112	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   421: astore 7
    //   423: aload_3
    //   424: astore 5
    //   426: aload_3
    //   427: astore_2
    //   428: aload 6
    //   430: astore 4
    //   432: aload_0
    //   433: getfield 21	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   436: aload 7
    //   438: invokevirtual 116	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   441: pop
    //   442: aload 6
    //   444: ifnull +8 -> 452
    //   447: aload 6
    //   449: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   452: aload_3
    //   453: ifnull -371 -> 82
    //   456: aload_3
    //   457: invokevirtual 149	java/io/InputStream:close	()V
    //   460: return
    //   461: astore_2
    //   462: return
    //   463: astore_3
    //   464: aconst_null
    //   465: astore 4
    //   467: aload 8
    //   469: astore_2
    //   470: aload 4
    //   472: ifnull +8 -> 480
    //   475: aload 4
    //   477: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   480: aload_2
    //   481: ifnull +7 -> 488
    //   484: aload_2
    //   485: invokevirtual 149	java/io/InputStream:close	()V
    //   488: aload_3
    //   489: athrow
    //   490: astore_2
    //   491: goto -39 -> 452
    //   494: astore_2
    //   495: goto -132 -> 363
    //   498: astore 4
    //   500: goto -20 -> 480
    //   503: astore_2
    //   504: goto -16 -> 488
    //   507: astore_3
    //   508: goto -38 -> 470
    //   511: astore 6
    //   513: aconst_null
    //   514: astore_3
    //   515: goto -203 -> 312
    //   518: aconst_null
    //   519: astore_3
    //   520: goto -418 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	this	VideoFileSaveRunnable
    //   264	21	1	i	int
    //   114	179	2	localObject1	Object
    //   305	5	2	localException1	java.lang.Exception
    //   314	29	2	localObject2	Object
    //   374	1	2	localIOException1	java.io.IOException
    //   382	46	2	localObject3	Object
    //   461	1	2	localIOException2	java.io.IOException
    //   469	16	2	localObject4	Object
    //   490	1	2	localIOException3	java.io.IOException
    //   494	1	2	localIOException4	java.io.IOException
    //   503	1	2	localIOException5	java.io.IOException
    //   101	356	3	localObject5	Object
    //   463	26	3	localObject6	Object
    //   507	1	3	localObject7	Object
    //   514	6	3	localObject8	Object
    //   209	267	4	localObject9	Object
    //   498	1	4	localIOException6	java.io.IOException
    //   1	424	5	localObject10	Object
    //   198	250	6	localObject11	Object
    //   511	1	6	localException2	java.lang.Exception
    //   10	427	7	localObject12	Object
    //   4	464	8	localObject13	Object
    //   7	374	9	localObject14	Object
    //   135	279	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   211	218	305	java/lang/Exception
    //   229	234	305	java/lang/Exception
    //   243	249	305	java/lang/Exception
    //   258	265	305	java/lang/Exception
    //   279	288	305	java/lang/Exception
    //   297	302	305	java/lang/Exception
    //   387	396	305	java/lang/Exception
    //   408	423	305	java/lang/Exception
    //   432	442	305	java/lang/Exception
    //   368	373	374	java/io/IOException
    //   456	460	461	java/io/IOException
    //   189	200	463	finally
    //   447	452	490	java/io/IOException
    //   359	363	494	java/io/IOException
    //   475	480	498	java/io/IOException
    //   484	488	503	java/io/IOException
    //   211	218	507	finally
    //   229	234	507	finally
    //   243	249	507	finally
    //   258	265	507	finally
    //   279	288	507	finally
    //   297	302	507	finally
    //   318	324	507	finally
    //   330	340	507	finally
    //   346	355	507	finally
    //   387	396	507	finally
    //   408	423	507	finally
    //   432	442	507	finally
    //   189	200	511	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable
 * JD-Core Version:    0.7.0.1
 */