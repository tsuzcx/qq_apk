package com.tencent.mobileqq.util;

import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class SSODebugUtil
{
  public static String a;
  public static String b = "testserver";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append("/testEnv/");
    a = localStringBuilder.toString();
  }
  
  /* Error */
  public static String[] a()
  {
    // Byte code:
    //   0: new 26	java/io/File
    //   3: dup
    //   4: getstatic 41	com/tencent/mobileqq/util/SSODebugUtil:a	Ljava/lang/String;
    //   7: getstatic 45	com/tencent/mobileqq/util/SSODebugUtil:b	Ljava/lang/String;
    //   10: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 59	java/io/File:exists	()Z
    //   18: ifne +18 -> 36
    //   21: iconst_2
    //   22: anewarray 61	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc 63
    //   29: aastore
    //   30: dup
    //   31: iconst_1
    //   32: ldc 63
    //   34: aastore
    //   35: areturn
    //   36: new 65	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 68	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: astore_3
    //   45: aload_3
    //   46: astore_1
    //   47: new 70	java/util/Properties
    //   50: dup
    //   51: invokespecial 71	java/util/Properties:<init>	()V
    //   54: astore_0
    //   55: aload_3
    //   56: astore_1
    //   57: aload_0
    //   58: aload_3
    //   59: invokevirtual 75	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   62: aload_3
    //   63: astore_1
    //   64: aload_0
    //   65: ldc 77
    //   67: invokevirtual 81	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 4
    //   72: aload_3
    //   73: astore_1
    //   74: aload_0
    //   75: ldc 83
    //   77: invokevirtual 81	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_0
    //   81: aload_3
    //   82: invokevirtual 86	java/io/FileInputStream:close	()V
    //   85: aload 4
    //   87: astore_1
    //   88: goto +66 -> 154
    //   91: astore_1
    //   92: aload_1
    //   93: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   96: aload 4
    //   98: astore_1
    //   99: goto +55 -> 154
    //   102: astore_2
    //   103: aload 4
    //   105: astore_0
    //   106: goto +20 -> 126
    //   109: astore_2
    //   110: aconst_null
    //   111: astore_0
    //   112: goto +14 -> 126
    //   115: astore_0
    //   116: aconst_null
    //   117: astore_1
    //   118: goto +74 -> 192
    //   121: astore_2
    //   122: aconst_null
    //   123: astore_3
    //   124: aload_3
    //   125: astore_0
    //   126: aload_3
    //   127: astore_1
    //   128: aload_2
    //   129: invokevirtual 90	java/lang/Exception:printStackTrace	()V
    //   132: aload_3
    //   133: ifnull +15 -> 148
    //   136: aload_3
    //   137: invokevirtual 86	java/io/FileInputStream:close	()V
    //   140: goto +8 -> 148
    //   143: astore_1
    //   144: aload_1
    //   145: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   148: aconst_null
    //   149: astore_2
    //   150: aload_0
    //   151: astore_1
    //   152: aload_2
    //   153: astore_0
    //   154: aload_1
    //   155: astore_2
    //   156: aload_1
    //   157: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   160: ifeq +6 -> 166
    //   163: ldc 63
    //   165: astore_2
    //   166: aload_0
    //   167: astore_1
    //   168: aload_0
    //   169: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   172: ifeq +6 -> 178
    //   175: ldc 63
    //   177: astore_1
    //   178: iconst_2
    //   179: anewarray 61	java/lang/String
    //   182: dup
    //   183: iconst_0
    //   184: aload_2
    //   185: aastore
    //   186: dup
    //   187: iconst_1
    //   188: aload_1
    //   189: aastore
    //   190: areturn
    //   191: astore_0
    //   192: aload_1
    //   193: ifnull +15 -> 208
    //   196: aload_1
    //   197: invokevirtual 86	java/io/FileInputStream:close	()V
    //   200: goto +8 -> 208
    //   203: astore_1
    //   204: aload_1
    //   205: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   208: aload_0
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	99	0	localObject1	Object
    //   115	1	0	localObject2	Object
    //   125	44	0	localObject3	Object
    //   191	18	0	localObject4	Object
    //   46	42	1	localObject5	Object
    //   91	2	1	localIOException1	java.io.IOException
    //   98	30	1	localObject6	Object
    //   143	2	1	localIOException2	java.io.IOException
    //   151	46	1	localObject7	Object
    //   203	2	1	localIOException3	java.io.IOException
    //   102	1	2	localException1	java.lang.Exception
    //   109	1	2	localException2	java.lang.Exception
    //   121	8	2	localException3	java.lang.Exception
    //   149	36	2	localObject8	Object
    //   44	93	3	localFileInputStream	java.io.FileInputStream
    //   70	34	4	str	String
    // Exception table:
    //   from	to	target	type
    //   81	85	91	java/io/IOException
    //   74	81	102	java/lang/Exception
    //   47	55	109	java/lang/Exception
    //   57	62	109	java/lang/Exception
    //   64	72	109	java/lang/Exception
    //   36	45	115	finally
    //   36	45	121	java/lang/Exception
    //   136	140	143	java/io/IOException
    //   47	55	191	finally
    //   57	62	191	finally
    //   64	72	191	finally
    //   74	81	191	finally
    //   128	132	191	finally
    //   196	200	203	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.SSODebugUtil
 * JD-Core Version:    0.7.0.1
 */