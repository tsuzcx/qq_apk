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
    //   1: astore_1
    //   2: new 25	java/io/PrintWriter
    //   5: dup
    //   6: new 27	java/io/BufferedWriter
    //   9: dup
    //   10: new 29	java/io/FileWriter
    //   13: dup
    //   14: aload_0
    //   15: getfield 14	com/tencent/youtu/sdkkitframework/common/YtLogger$1:val$file	Ljava/io/File;
    //   18: iconst_1
    //   19: invokespecial 32	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   22: invokespecial 35	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   25: invokespecial 36	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   28: astore_2
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: aload_0
    //   33: getfield 16	com/tencent/youtu/sdkkitframework/common/YtLogger$1:val$content	Ljava/lang/String;
    //   36: invokevirtual 40	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: invokevirtual 43	java/io/PrintWriter:flush	()V
    //   45: aload_2
    //   46: ifnull +7 -> 53
    //   49: aload_2
    //   50: invokevirtual 46	java/io/PrintWriter:close	()V
    //   53: return
    //   54: astore_3
    //   55: aconst_null
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: aload_3
    //   60: invokevirtual 49	java/lang/Exception:printStackTrace	()V
    //   63: aload_2
    //   64: ifnull -11 -> 53
    //   67: aload_2
    //   68: invokevirtual 46	java/io/PrintWriter:close	()V
    //   71: return
    //   72: astore_3
    //   73: aload_1
    //   74: astore_2
    //   75: aload_3
    //   76: astore_1
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 46	java/io/PrintWriter:close	()V
    //   85: aload_1
    //   86: athrow
    //   87: astore_3
    //   88: aload_1
    //   89: astore_2
    //   90: aload_3
    //   91: astore_1
    //   92: goto -15 -> 77
    //   95: astore_3
    //   96: goto -39 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	1
    //   1	91	1	localObject1	Object
    //   28	62	2	localObject2	Object
    //   54	6	3	localException1	java.lang.Exception
    //   72	4	3	localObject3	Object
    //   87	4	3	localObject4	Object
    //   95	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	29	54	java/lang/Exception
    //   2	29	72	finally
    //   31	39	87	finally
    //   41	45	87	finally
    //   59	63	87	finally
    //   31	39	95	java/lang/Exception
    //   41	45	95	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtLogger.1
 * JD-Core Version:    0.7.0.1
 */