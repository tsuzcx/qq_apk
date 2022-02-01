package com.tencent.mobileqq.shortvideo;

import mqq.os.MqqHandler;

public class ShortVideoUtils$VideoFileSaveRunnable
  implements Runnable
{
  String jdField_a_of_type_JavaLangString;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  
  public ShortVideoUtils$VideoFileSaveRunnable(String paramString1, MqqHandler paramMqqHandler, String paramString2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 20	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +13 -> 23
    //   13: aload_0
    //   14: getfield 20	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   17: invokestatic 43	bhmi:a	(Ljava/lang/String;)Z
    //   20: ifne +47 -> 67
    //   23: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +31 -> 57
    //   29: ldc 51
    //   31: iconst_2
    //   32: new 53	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   39: ldc 56
    //   41: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: getfield 20	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   48: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 68	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 22	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   61: iconst_1
    //   62: invokevirtual 74	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   65: pop
    //   66: return
    //   67: new 76	java/io/File
    //   70: dup
    //   71: aload_0
    //   72: getfield 20	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   75: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore 6
    //   80: invokestatic 84	com/tencent/util/VersionUtils:isrFroyo	()Z
    //   83: ifeq +74 -> 157
    //   86: getstatic 89	android/os/Environment:DIRECTORY_MOVIES	Ljava/lang/String;
    //   89: invokestatic 93	android/os/Environment:getExternalStoragePublicDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   92: astore_2
    //   93: aload_2
    //   94: invokevirtual 96	java/io/File:mkdirs	()Z
    //   97: pop
    //   98: aload_0
    //   99: getfield 18	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_b_of_type_Boolean	Z
    //   102: ifeq +69 -> 171
    //   105: aload_0
    //   106: getfield 24	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   109: astore_3
    //   110: new 76	java/io/File
    //   113: dup
    //   114: aload_2
    //   115: aload_3
    //   116: invokespecial 99	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 26	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_Boolean	Z
    //   124: ifne +58 -> 182
    //   127: aload_3
    //   128: invokevirtual 102	java/io/File:exists	()Z
    //   131: ifeq +51 -> 182
    //   134: aload_0
    //   135: getfield 22	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   138: iconst_3
    //   139: aload_0
    //   140: getfield 20	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   143: invokevirtual 106	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   146: astore_2
    //   147: aload_0
    //   148: getfield 22	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   151: aload_2
    //   152: invokevirtual 110	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   155: pop
    //   156: return
    //   157: new 76	java/io/File
    //   160: dup
    //   161: getstatic 115	antf:bu	Ljava/lang/String;
    //   164: invokespecial 79	java/io/File:<init>	(Ljava/lang/String;)V
    //   167: astore_2
    //   168: goto -75 -> 93
    //   171: aload_0
    //   172: getfield 24	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   175: invokestatic 120	com/tencent/mobileqq/shortvideo/ShortVideoUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   178: astore_3
    //   179: goto -69 -> 110
    //   182: new 122	java/io/FileOutputStream
    //   185: dup
    //   186: aload_3
    //   187: invokespecial 125	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   190: astore 4
    //   192: new 127	java/io/FileInputStream
    //   195: dup
    //   196: aload 6
    //   198: invokespecial 128	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   201: astore_2
    //   202: ldc 129
    //   204: newarray byte
    //   206: astore 5
    //   208: aload_2
    //   209: aload 5
    //   211: invokevirtual 133	java/io/FileInputStream:read	([B)I
    //   214: istore_1
    //   215: iload_1
    //   216: iconst_m1
    //   217: if_icmpeq +73 -> 290
    //   220: aload 4
    //   222: aload 5
    //   224: iconst_0
    //   225: iload_1
    //   226: invokevirtual 137	java/io/FileOutputStream:write	([BII)V
    //   229: aload 4
    //   231: invokevirtual 140	java/io/FileOutputStream:flush	()V
    //   234: goto -26 -> 208
    //   237: astore 5
    //   239: aload 4
    //   241: astore_3
    //   242: aload 5
    //   244: astore 4
    //   246: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq +13 -> 262
    //   252: ldc 51
    //   254: iconst_2
    //   255: ldc 142
    //   257: aload 4
    //   259: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   262: aload_0
    //   263: getfield 22	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   266: iconst_1
    //   267: invokevirtual 74	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   270: pop
    //   271: aload_3
    //   272: ifnull +7 -> 279
    //   275: aload_3
    //   276: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   279: aload_2
    //   280: ifnull -214 -> 66
    //   283: aload_2
    //   284: invokevirtual 149	java/io/FileInputStream:close	()V
    //   287: return
    //   288: astore_2
    //   289: return
    //   290: aload_0
    //   291: getfield 22	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   294: iconst_2
    //   295: aload_3
    //   296: invokevirtual 152	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   299: invokevirtual 106	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   302: astore_3
    //   303: aload_0
    //   304: getfield 22	com/tencent/mobileqq/shortvideo/ShortVideoUtils$VideoFileSaveRunnable:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   307: aload_3
    //   308: invokevirtual 110	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   311: pop
    //   312: aload 4
    //   314: ifnull +8 -> 322
    //   317: aload 4
    //   319: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   322: aload_2
    //   323: ifnull -257 -> 66
    //   326: aload_2
    //   327: invokevirtual 149	java/io/FileInputStream:close	()V
    //   330: return
    //   331: astore_2
    //   332: return
    //   333: astore_3
    //   334: aconst_null
    //   335: astore_2
    //   336: aconst_null
    //   337: astore 4
    //   339: aload 4
    //   341: ifnull +8 -> 349
    //   344: aload 4
    //   346: invokevirtual 148	java/io/FileOutputStream:close	()V
    //   349: aload_2
    //   350: ifnull +7 -> 357
    //   353: aload_2
    //   354: invokevirtual 149	java/io/FileInputStream:close	()V
    //   357: aload_3
    //   358: athrow
    //   359: astore_3
    //   360: goto -38 -> 322
    //   363: astore_3
    //   364: goto -85 -> 279
    //   367: astore 4
    //   369: goto -20 -> 349
    //   372: astore_2
    //   373: goto -16 -> 357
    //   376: astore_3
    //   377: aconst_null
    //   378: astore_2
    //   379: goto -40 -> 339
    //   382: astore_3
    //   383: goto -44 -> 339
    //   386: astore 5
    //   388: aload_3
    //   389: astore 4
    //   391: aload 5
    //   393: astore_3
    //   394: goto -55 -> 339
    //   397: astore 4
    //   399: aconst_null
    //   400: astore_2
    //   401: aload 5
    //   403: astore_3
    //   404: goto -158 -> 246
    //   407: astore 5
    //   409: aconst_null
    //   410: astore_2
    //   411: aload 4
    //   413: astore_3
    //   414: aload 5
    //   416: astore 4
    //   418: goto -172 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	this	VideoFileSaveRunnable
    //   214	12	1	i	int
    //   92	192	2	localObject1	Object
    //   288	39	2	localIOException1	java.io.IOException
    //   331	1	2	localIOException2	java.io.IOException
    //   335	19	2	localObject2	Object
    //   372	1	2	localIOException3	java.io.IOException
    //   378	33	2	localObject3	Object
    //   109	199	3	localObject4	Object
    //   333	25	3	localObject5	Object
    //   359	1	3	localIOException4	java.io.IOException
    //   363	1	3	localIOException5	java.io.IOException
    //   376	1	3	localObject6	Object
    //   382	7	3	localObject7	Object
    //   393	21	3	localObject8	Object
    //   190	155	4	localObject9	Object
    //   367	1	4	localIOException6	java.io.IOException
    //   389	1	4	localObject10	Object
    //   397	15	4	localException1	java.lang.Exception
    //   416	1	4	localException2	java.lang.Exception
    //   1	222	5	arrayOfByte	byte[]
    //   237	6	5	localException3	java.lang.Exception
    //   386	16	5	localObject11	Object
    //   407	8	5	localException4	java.lang.Exception
    //   78	119	6	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   202	208	237	java/lang/Exception
    //   208	215	237	java/lang/Exception
    //   220	234	237	java/lang/Exception
    //   290	312	237	java/lang/Exception
    //   283	287	288	java/io/IOException
    //   326	330	331	java/io/IOException
    //   182	192	333	finally
    //   317	322	359	java/io/IOException
    //   275	279	363	java/io/IOException
    //   344	349	367	java/io/IOException
    //   353	357	372	java/io/IOException
    //   192	202	376	finally
    //   202	208	382	finally
    //   208	215	382	finally
    //   220	234	382	finally
    //   290	312	382	finally
    //   246	262	386	finally
    //   262	271	386	finally
    //   182	192	397	java/lang/Exception
    //   192	202	407	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable
 * JD-Core Version:    0.7.0.1
 */