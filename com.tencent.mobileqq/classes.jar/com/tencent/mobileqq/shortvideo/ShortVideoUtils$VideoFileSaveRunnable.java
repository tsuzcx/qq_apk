package com.tencent.mobileqq.shortvideo;

import mqq.os.MqqHandler;

public class ShortVideoUtils$VideoFileSaveRunnable
  implements Runnable
{
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
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 18	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +13 -> 22
    //   12: aload_0
    //   13: getfield 18	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokestatic 41	bace:a	(Ljava/lang/String;)Z
    //   19: ifne +47 -> 66
    //   22: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +31 -> 56
    //   28: ldc 49
    //   30: iconst_2
    //   31: new 51	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   38: ldc 54
    //   40: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: getfield 18	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   47: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 66	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: getfield 20	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   60: iconst_1
    //   61: invokevirtual 72	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   64: pop
    //   65: return
    //   66: new 74	java/io/File
    //   69: dup
    //   70: aload_0
    //   71: getfield 18	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   74: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore 5
    //   79: invokestatic 81	befo:b	()Z
    //   82: ifeq +70 -> 152
    //   85: getstatic 86	android/os/Environment:DIRECTORY_MOVIES	Ljava/lang/String;
    //   88: invokestatic 90	android/os/Environment:getExternalStoragePublicDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   91: astore_2
    //   92: aload_2
    //   93: invokevirtual 93	java/io/File:mkdirs	()Z
    //   96: pop
    //   97: new 74	java/io/File
    //   100: dup
    //   101: aload_2
    //   102: aload_0
    //   103: getfield 22	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:b	Ljava/lang/String;
    //   106: invokestatic 98	com/tencent/mobileqq/shortvideo/ShortVideoUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   109: invokespecial 101	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   112: astore 6
    //   114: aload_0
    //   115: getfield 24	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_Boolean	Z
    //   118: ifne +48 -> 166
    //   121: aload 6
    //   123: invokevirtual 104	java/io/File:exists	()Z
    //   126: ifeq +40 -> 166
    //   129: aload_0
    //   130: getfield 20	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   133: iconst_3
    //   134: aload_0
    //   135: getfield 18	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   138: invokevirtual 108	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   141: astore_2
    //   142: aload_0
    //   143: getfield 20	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   146: aload_2
    //   147: invokevirtual 112	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   150: pop
    //   151: return
    //   152: new 74	java/io/File
    //   155: dup
    //   156: getstatic 117	ajed:bo	Ljava/lang/String;
    //   159: invokespecial 77	java/io/File:<init>	(Ljava/lang/String;)V
    //   162: astore_2
    //   163: goto -71 -> 92
    //   166: new 119	java/io/FileOutputStream
    //   169: dup
    //   170: aload 6
    //   172: invokespecial 122	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   175: astore 4
    //   177: new 124	java/io/FileInputStream
    //   180: dup
    //   181: aload 5
    //   183: invokespecial 125	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   186: astore_2
    //   187: ldc 126
    //   189: newarray byte
    //   191: astore_3
    //   192: aload_2
    //   193: aload_3
    //   194: invokevirtual 130	java/io/FileInputStream:read	([B)I
    //   197: istore_1
    //   198: iload_1
    //   199: iconst_m1
    //   200: if_icmpeq +72 -> 272
    //   203: aload 4
    //   205: aload_3
    //   206: iconst_0
    //   207: iload_1
    //   208: invokevirtual 134	java/io/FileOutputStream:write	([BII)V
    //   211: aload 4
    //   213: invokevirtual 137	java/io/FileOutputStream:flush	()V
    //   216: goto -24 -> 192
    //   219: astore 5
    //   221: aload 4
    //   223: astore_3
    //   224: aload 5
    //   226: astore 4
    //   228: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +13 -> 244
    //   234: ldc 49
    //   236: iconst_2
    //   237: ldc 139
    //   239: aload 4
    //   241: invokestatic 142	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   244: aload_0
    //   245: getfield 20	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   248: iconst_1
    //   249: invokevirtual 72	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   252: pop
    //   253: aload_3
    //   254: ifnull +7 -> 261
    //   257: aload_3
    //   258: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   261: aload_2
    //   262: ifnull -197 -> 65
    //   265: aload_2
    //   266: invokevirtual 146	java/io/FileInputStream:close	()V
    //   269: return
    //   270: astore_2
    //   271: return
    //   272: aload_0
    //   273: getfield 20	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   276: iconst_2
    //   277: aload 6
    //   279: invokevirtual 149	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   282: invokevirtual 108	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   285: astore_3
    //   286: aload_0
    //   287: getfield 20	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   290: aload_3
    //   291: invokevirtual 112	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   294: pop
    //   295: aload 4
    //   297: ifnull +8 -> 305
    //   300: aload 4
    //   302: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   305: aload_2
    //   306: ifnull -241 -> 65
    //   309: aload_2
    //   310: invokevirtual 146	java/io/FileInputStream:close	()V
    //   313: return
    //   314: astore_2
    //   315: return
    //   316: astore_3
    //   317: aconst_null
    //   318: astore_2
    //   319: aconst_null
    //   320: astore 4
    //   322: aload 4
    //   324: ifnull +8 -> 332
    //   327: aload 4
    //   329: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   332: aload_2
    //   333: ifnull +7 -> 340
    //   336: aload_2
    //   337: invokevirtual 146	java/io/FileInputStream:close	()V
    //   340: aload_3
    //   341: athrow
    //   342: astore_3
    //   343: goto -38 -> 305
    //   346: astore_3
    //   347: goto -86 -> 261
    //   350: astore 4
    //   352: goto -20 -> 332
    //   355: astore_2
    //   356: goto -16 -> 340
    //   359: astore_3
    //   360: aconst_null
    //   361: astore_2
    //   362: goto -40 -> 322
    //   365: astore_3
    //   366: goto -44 -> 322
    //   369: astore 5
    //   371: aload_3
    //   372: astore 4
    //   374: aload 5
    //   376: astore_3
    //   377: goto -55 -> 322
    //   380: astore 4
    //   382: aconst_null
    //   383: astore_2
    //   384: goto -156 -> 228
    //   387: astore 5
    //   389: aconst_null
    //   390: astore_2
    //   391: aload 4
    //   393: astore_3
    //   394: aload 5
    //   396: astore 4
    //   398: goto -170 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	401	0	this	VideoFileSaveRunnable
    //   197	11	1	i	int
    //   91	175	2	localObject1	Object
    //   270	40	2	localIOException1	java.io.IOException
    //   314	1	2	localIOException2	java.io.IOException
    //   318	19	2	localObject2	Object
    //   355	1	2	localIOException3	java.io.IOException
    //   361	30	2	localObject3	Object
    //   1	290	3	localObject4	Object
    //   316	25	3	localObject5	Object
    //   342	1	3	localIOException4	java.io.IOException
    //   346	1	3	localIOException5	java.io.IOException
    //   359	1	3	localObject6	Object
    //   365	7	3	localObject7	Object
    //   376	18	3	localObject8	Object
    //   175	153	4	localObject9	Object
    //   350	1	4	localIOException6	java.io.IOException
    //   372	1	4	localObject10	Object
    //   380	12	4	localException1	java.lang.Exception
    //   396	1	4	localException2	java.lang.Exception
    //   77	105	5	localFile1	java.io.File
    //   219	6	5	localException3	java.lang.Exception
    //   369	6	5	localObject11	Object
    //   387	8	5	localException4	java.lang.Exception
    //   112	166	6	localFile2	java.io.File
    // Exception table:
    //   from	to	target	type
    //   187	192	219	java/lang/Exception
    //   192	198	219	java/lang/Exception
    //   203	216	219	java/lang/Exception
    //   272	295	219	java/lang/Exception
    //   265	269	270	java/io/IOException
    //   309	313	314	java/io/IOException
    //   166	177	316	finally
    //   300	305	342	java/io/IOException
    //   257	261	346	java/io/IOException
    //   327	332	350	java/io/IOException
    //   336	340	355	java/io/IOException
    //   177	187	359	finally
    //   187	192	365	finally
    //   192	198	365	finally
    //   203	216	365	finally
    //   272	295	365	finally
    //   228	244	369	finally
    //   244	253	369	finally
    //   166	177	380	java/lang/Exception
    //   177	187	387	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable
 * JD-Core Version:    0.7.0.1
 */