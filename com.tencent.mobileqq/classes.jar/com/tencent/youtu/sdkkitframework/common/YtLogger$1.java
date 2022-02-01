package com.tencent.youtu.sdkkitframework.common;

import java.io.File;

final class YtLogger$1
  implements Runnable
{
  YtLogger$1(File paramFile, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: new 25	java/io/PrintWriter
    //   8: dup
    //   9: new 27	java/io/BufferedWriter
    //   12: dup
    //   13: new 29	java/io/FileWriter
    //   16: dup
    //   17: aload_0
    //   18: getfield 14	com/tencent/youtu/sdkkitframework/common/YtLogger$1:val$file	Ljava/io/File;
    //   21: iconst_1
    //   22: invokespecial 32	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   25: invokespecial 35	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   28: invokespecial 36	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   31: astore_2
    //   32: aload_2
    //   33: aload_0
    //   34: getfield 16	com/tencent/youtu/sdkkitframework/common/YtLogger$1:val$content	Ljava/lang/String;
    //   37: invokevirtual 40	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   40: aload_2
    //   41: invokevirtual 43	java/io/PrintWriter:flush	()V
    //   44: aload_2
    //   45: invokevirtual 46	java/io/PrintWriter:close	()V
    //   48: return
    //   49: astore_1
    //   50: goto +36 -> 86
    //   53: astore_1
    //   54: aload_1
    //   55: astore_3
    //   56: goto +15 -> 71
    //   59: astore_3
    //   60: aload_1
    //   61: astore_2
    //   62: aload_3
    //   63: astore_1
    //   64: goto +22 -> 86
    //   67: astore_3
    //   68: aload 4
    //   70: astore_2
    //   71: aload_2
    //   72: astore_1
    //   73: aload_3
    //   74: invokevirtual 49	java/lang/Exception:printStackTrace	()V
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 46	java/io/PrintWriter:close	()V
    //   85: return
    //   86: aload_2
    //   87: ifnull +7 -> 94
    //   90: aload_2
    //   91: invokevirtual 46	java/io/PrintWriter:close	()V
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	1
    //   4	1	1	localObject1	Object
    //   49	1	1	localObject2	Object
    //   53	8	1	localException1	java.lang.Exception
    //   63	32	1	localObject3	Object
    //   31	60	2	localObject4	Object
    //   55	1	3	localException2	java.lang.Exception
    //   59	4	3	localObject5	Object
    //   67	7	3	localException3	java.lang.Exception
    //   1	68	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   32	44	49	finally
    //   32	44	53	java/lang/Exception
    //   5	32	59	finally
    //   73	77	59	finally
    //   5	32	67	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtLogger.1
 * JD-Core Version:    0.7.0.1
 */