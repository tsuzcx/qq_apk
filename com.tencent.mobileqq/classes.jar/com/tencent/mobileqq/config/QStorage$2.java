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
    //   0: new 32	java/io/ObjectInputStream
    //   3: dup
    //   4: new 34	java/io/BufferedInputStream
    //   7: dup
    //   8: new 36	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: getfield 17	com/tencent/mobileqq/config/QStorage$2:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   16: invokespecial 39	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: invokespecial 42	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: invokespecial 43	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore_1
    //   28: aload_2
    //   29: invokevirtual 47	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   32: checkcast 49	java/io/Serializable
    //   35: astore_3
    //   36: aload_2
    //   37: ifnull +7 -> 44
    //   40: aload_2
    //   41: invokevirtual 52	java/io/ObjectInputStream:close	()V
    //   44: aload_3
    //   45: areturn
    //   46: astore_3
    //   47: aconst_null
    //   48: astore_2
    //   49: aload_2
    //   50: astore_1
    //   51: ldc 54
    //   53: iconst_1
    //   54: new 56	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   61: ldc 59
    //   63: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_0
    //   67: getfield 19	com/tencent/mobileqq/config/QStorage$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   70: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: aload_3
    //   77: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   80: aload_2
    //   81: ifnull +142 -> 223
    //   84: aload_2
    //   85: invokevirtual 52	java/io/ObjectInputStream:close	()V
    //   88: aconst_null
    //   89: areturn
    //   90: astore_1
    //   91: aconst_null
    //   92: areturn
    //   93: astore_3
    //   94: aconst_null
    //   95: astore_2
    //   96: aload_2
    //   97: astore_1
    //   98: ldc 54
    //   100: iconst_1
    //   101: new 56	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   108: ldc 59
    //   110: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 19	com/tencent/mobileqq/config/QStorage$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   117: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: aload_3
    //   124: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload_2
    //   128: ifnull +95 -> 223
    //   131: aload_2
    //   132: invokevirtual 52	java/io/ObjectInputStream:close	()V
    //   135: aconst_null
    //   136: areturn
    //   137: astore_1
    //   138: aconst_null
    //   139: areturn
    //   140: astore_3
    //   141: aconst_null
    //   142: astore_2
    //   143: aload_2
    //   144: astore_1
    //   145: ldc 54
    //   147: iconst_1
    //   148: new 56	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   155: ldc 59
    //   157: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_0
    //   161: getfield 19	com/tencent/mobileqq/config/QStorage$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   164: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: aload_3
    //   171: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload_2
    //   175: ifnull +48 -> 223
    //   178: aload_2
    //   179: invokevirtual 52	java/io/ObjectInputStream:close	()V
    //   182: aconst_null
    //   183: areturn
    //   184: astore_1
    //   185: aconst_null
    //   186: areturn
    //   187: astore_2
    //   188: aconst_null
    //   189: astore_1
    //   190: aload_1
    //   191: ifnull +7 -> 198
    //   194: aload_1
    //   195: invokevirtual 52	java/io/ObjectInputStream:close	()V
    //   198: aload_2
    //   199: athrow
    //   200: astore_1
    //   201: aload_3
    //   202: areturn
    //   203: astore_1
    //   204: goto -6 -> 198
    //   207: astore_2
    //   208: goto -18 -> 190
    //   211: astore_3
    //   212: goto -69 -> 143
    //   215: astore_3
    //   216: goto -120 -> 96
    //   219: astore_3
    //   220: goto -171 -> 49
    //   223: aconst_null
    //   224: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	2
    //   0	225	1	paramFile	File
    //   0	225	2	paramString	String
    //   35	10	3	localSerializable	java.io.Serializable
    //   46	31	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   93	31	3	localIOException1	java.io.IOException
    //   140	62	3	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   211	1	3	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   215	1	3	localIOException2	java.io.IOException
    //   219	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   0	26	46	java/io/FileNotFoundException
    //   84	88	90	java/io/IOException
    //   0	26	93	java/io/IOException
    //   131	135	137	java/io/IOException
    //   0	26	140	java/lang/ClassNotFoundException
    //   178	182	184	java/io/IOException
    //   0	26	187	finally
    //   40	44	200	java/io/IOException
    //   194	198	203	java/io/IOException
    //   28	36	207	finally
    //   51	80	207	finally
    //   98	127	207	finally
    //   145	174	207	finally
    //   28	36	211	java/lang/ClassNotFoundException
    //   28	36	215	java/io/IOException
    //   28	36	219	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.QStorage.2
 * JD-Core Version:    0.7.0.1
 */