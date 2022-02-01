package com.tencent.mobileqq.config;

import java.io.Serializable;

class QStorage$1
  implements IQStorageIOProcessor<String, T>
{
  QStorage$1(QStorage paramQStorage, String paramString, Serializable paramSerializable) {}
  
  /* Error */
  public String a(java.io.File paramFile, T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/tencent/mobileqq/config/QStorage$1:jdField_a_of_type_ComTencentMobileqqConfigQStorage	Lcom/tencent/mobileqq/config/QStorage;
    //   4: aload_0
    //   5: getfield 17	com/tencent/mobileqq/config/QStorage$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: ldc 37
    //   10: invokevirtual 42	com/tencent/mobileqq/config/QStorage:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   13: astore_2
    //   14: aconst_null
    //   15: astore_3
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 4
    //   22: aconst_null
    //   23: astore_1
    //   24: new 44	java/io/ObjectOutputStream
    //   27: dup
    //   28: new 46	java/io/BufferedOutputStream
    //   31: dup
    //   32: new 48	java/io/FileOutputStream
    //   35: dup
    //   36: aload_2
    //   37: invokespecial 51	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   40: invokespecial 54	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   43: invokespecial 55	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   46: astore_2
    //   47: aload_2
    //   48: aload_0
    //   49: getfield 19	com/tencent/mobileqq/config/QStorage$1:jdField_a_of_type_JavaIoSerializable	Ljava/io/Serializable;
    //   52: invokevirtual 59	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   55: aload_2
    //   56: invokevirtual 62	java/io/ObjectOutputStream:flush	()V
    //   59: aload_2
    //   60: invokevirtual 65	java/io/ObjectOutputStream:close	()V
    //   63: goto +202 -> 265
    //   66: astore_3
    //   67: aload_2
    //   68: astore_1
    //   69: aload_3
    //   70: astore_2
    //   71: goto +197 -> 268
    //   74: astore_3
    //   75: goto +20 -> 95
    //   78: astore_3
    //   79: goto +78 -> 157
    //   82: astore_3
    //   83: goto +128 -> 211
    //   86: astore_2
    //   87: goto +181 -> 268
    //   90: astore_1
    //   91: aload_3
    //   92: astore_2
    //   93: aload_1
    //   94: astore_3
    //   95: aload_2
    //   96: astore_1
    //   97: new 67	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   104: astore 4
    //   106: aload_2
    //   107: astore_1
    //   108: aload 4
    //   110: ldc 70
    //   112: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_2
    //   117: astore_1
    //   118: aload 4
    //   120: aload_0
    //   121: getfield 17	com/tencent/mobileqq/config/QStorage$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   124: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_2
    //   129: astore_1
    //   130: ldc 76
    //   132: iconst_1
    //   133: aload 4
    //   135: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: aload_3
    //   139: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   142: aload_2
    //   143: ifnull +122 -> 265
    //   146: aload_2
    //   147: invokevirtual 65	java/io/ObjectOutputStream:close	()V
    //   150: goto +115 -> 265
    //   153: astore_3
    //   154: aload 5
    //   156: astore_2
    //   157: aload_2
    //   158: astore_1
    //   159: new 67	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   166: astore 4
    //   168: aload_2
    //   169: astore_1
    //   170: aload 4
    //   172: ldc 70
    //   174: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_2
    //   179: astore_1
    //   180: aload 4
    //   182: aload_0
    //   183: getfield 17	com/tencent/mobileqq/config/QStorage$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   186: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload_2
    //   191: astore_1
    //   192: ldc 76
    //   194: iconst_1
    //   195: aload 4
    //   197: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: aload_3
    //   201: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   204: aload_2
    //   205: ifnull +60 -> 265
    //   208: goto -62 -> 146
    //   211: aload_2
    //   212: astore_1
    //   213: new 67	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   220: astore 4
    //   222: aload_2
    //   223: astore_1
    //   224: aload 4
    //   226: ldc 70
    //   228: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload_2
    //   233: astore_1
    //   234: aload 4
    //   236: aload_0
    //   237: getfield 17	com/tencent/mobileqq/config/QStorage$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   240: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_2
    //   245: astore_1
    //   246: ldc 76
    //   248: iconst_1
    //   249: aload 4
    //   251: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: aload_3
    //   255: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   258: aload_2
    //   259: ifnull +6 -> 265
    //   262: goto -116 -> 146
    //   265: ldc 88
    //   267: areturn
    //   268: aload_1
    //   269: ifnull +7 -> 276
    //   272: aload_1
    //   273: invokevirtual 65	java/io/ObjectOutputStream:close	()V
    //   276: goto +5 -> 281
    //   279: aload_2
    //   280: athrow
    //   281: goto -2 -> 279
    //   284: astore_1
    //   285: goto -20 -> 265
    //   288: astore_1
    //   289: goto -13 -> 276
    //   292: astore_3
    //   293: aload 4
    //   295: astore_2
    //   296: goto -85 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	this	1
    //   0	299	1	paramFile	java.io.File
    //   0	299	2	paramT	T
    //   15	1	3	localObject1	Object
    //   66	4	3	localObject2	Object
    //   74	1	3	localIOException	java.io.IOException
    //   78	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   82	10	3	localNotSerializableException1	java.io.NotSerializableException
    //   94	45	3	localFile	java.io.File
    //   153	102	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   292	1	3	localNotSerializableException2	java.io.NotSerializableException
    //   20	274	4	localStringBuilder	java.lang.StringBuilder
    //   17	138	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   47	59	66	finally
    //   47	59	74	java/io/IOException
    //   47	59	78	java/io/FileNotFoundException
    //   47	59	82	java/io/NotSerializableException
    //   24	47	86	finally
    //   97	106	86	finally
    //   108	116	86	finally
    //   118	128	86	finally
    //   130	142	86	finally
    //   159	168	86	finally
    //   170	178	86	finally
    //   180	190	86	finally
    //   192	204	86	finally
    //   213	222	86	finally
    //   224	232	86	finally
    //   234	244	86	finally
    //   246	258	86	finally
    //   24	47	90	java/io/IOException
    //   24	47	153	java/io/FileNotFoundException
    //   59	63	284	java/io/IOException
    //   146	150	284	java/io/IOException
    //   272	276	288	java/io/IOException
    //   24	47	292	java/io/NotSerializableException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.QStorage.1
 * JD-Core Version:    0.7.0.1
 */