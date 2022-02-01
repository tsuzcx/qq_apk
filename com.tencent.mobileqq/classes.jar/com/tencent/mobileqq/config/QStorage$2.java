package com.tencent.mobileqq.config;

import java.io.File;

class QStorage$2
  implements IQStorageIOProcessor<T, String>
{
  QStorage$2(QStorage paramQStorage, File paramFile, String paramString) {}
  
  /* Error */
  public T a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: new 34	java/io/ObjectInputStream
    //   3: dup
    //   4: new 36	java/io/BufferedInputStream
    //   7: dup
    //   8: new 38	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: getfield 19	com/tencent/mobileqq/config/QStorage$2:a	Ljava/io/File;
    //   16: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: invokespecial 44	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: invokespecial 45	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 49	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   32: checkcast 51	java/io/Serializable
    //   35: astore_3
    //   36: aload_2
    //   37: invokevirtual 54	java/io/ObjectInputStream:close	()V
    //   40: aload_3
    //   41: areturn
    //   42: astore_3
    //   43: goto +20 -> 63
    //   46: astore_3
    //   47: goto +76 -> 123
    //   50: astore_3
    //   51: goto +126 -> 177
    //   54: astore_2
    //   55: aconst_null
    //   56: astore_1
    //   57: goto +177 -> 234
    //   60: astore_3
    //   61: aconst_null
    //   62: astore_2
    //   63: aload_2
    //   64: astore_1
    //   65: new 56	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   72: astore 4
    //   74: aload_2
    //   75: astore_1
    //   76: aload 4
    //   78: ldc 59
    //   80: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_2
    //   85: astore_1
    //   86: aload 4
    //   88: aload_0
    //   89: getfield 21	com/tencent/mobileqq/config/QStorage$2:b	Ljava/lang/String;
    //   92: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_2
    //   97: astore_1
    //   98: ldc 65
    //   100: iconst_1
    //   101: aload 4
    //   103: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: aload_3
    //   107: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   110: aload_2
    //   111: ifnull +120 -> 231
    //   114: aload_2
    //   115: invokevirtual 54	java/io/ObjectInputStream:close	()V
    //   118: aconst_null
    //   119: areturn
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: astore_1
    //   125: new 56	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   132: astore 4
    //   134: aload_2
    //   135: astore_1
    //   136: aload 4
    //   138: ldc 59
    //   140: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload_2
    //   145: astore_1
    //   146: aload 4
    //   148: aload_0
    //   149: getfield 21	com/tencent/mobileqq/config/QStorage$2:b	Ljava/lang/String;
    //   152: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_2
    //   157: astore_1
    //   158: ldc 65
    //   160: iconst_1
    //   161: aload 4
    //   163: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: aload_3
    //   167: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   170: aload_2
    //   171: ifnull +60 -> 231
    //   174: goto -60 -> 114
    //   177: aload_2
    //   178: astore_1
    //   179: new 56	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   186: astore 4
    //   188: aload_2
    //   189: astore_1
    //   190: aload 4
    //   192: ldc 59
    //   194: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_2
    //   199: astore_1
    //   200: aload 4
    //   202: aload_0
    //   203: getfield 21	com/tencent/mobileqq/config/QStorage$2:b	Ljava/lang/String;
    //   206: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_2
    //   211: astore_1
    //   212: ldc 65
    //   214: iconst_1
    //   215: aload 4
    //   217: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: aload_3
    //   221: invokestatic 75	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   224: aload_2
    //   225: ifnull +6 -> 231
    //   228: goto -114 -> 114
    //   231: aconst_null
    //   232: areturn
    //   233: astore_2
    //   234: aload_1
    //   235: ifnull +7 -> 242
    //   238: aload_1
    //   239: invokevirtual 54	java/io/ObjectInputStream:close	()V
    //   242: goto +5 -> 247
    //   245: aload_2
    //   246: athrow
    //   247: goto -2 -> 245
    //   250: astore_1
    //   251: goto -211 -> 40
    //   254: astore_1
    //   255: aconst_null
    //   256: areturn
    //   257: astore_1
    //   258: goto -16 -> 242
    //   261: astore_3
    //   262: aconst_null
    //   263: astore_2
    //   264: goto -87 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	2
    //   0	267	1	paramFile	File
    //   0	267	2	paramString	String
    //   35	6	3	localSerializable	java.io.Serializable
    //   42	1	3	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   46	1	3	localIOException1	java.io.IOException
    //   50	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   60	47	3	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   120	101	3	localIOException2	java.io.IOException
    //   261	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   72	144	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   28	36	42	java/lang/ClassNotFoundException
    //   28	36	46	java/io/IOException
    //   28	36	50	java/io/FileNotFoundException
    //   0	26	54	finally
    //   0	26	60	java/lang/ClassNotFoundException
    //   0	26	120	java/io/IOException
    //   28	36	233	finally
    //   65	74	233	finally
    //   76	84	233	finally
    //   86	96	233	finally
    //   98	110	233	finally
    //   125	134	233	finally
    //   136	144	233	finally
    //   146	156	233	finally
    //   158	170	233	finally
    //   179	188	233	finally
    //   190	198	233	finally
    //   200	210	233	finally
    //   212	224	233	finally
    //   36	40	250	java/io/IOException
    //   114	118	254	java/io/IOException
    //   238	242	257	java/io/IOException
    //   0	26	261	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.QStorage.2
 * JD-Core Version:    0.7.0.1
 */