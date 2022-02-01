package com.tencent.qqmusic.mediaplayer.perf;

public class FileLogger
{
  private static final String TAG = "FileLogger";
  
  /* Error */
  public static void write(java.lang.StringBuilder paramStringBuilder, java.io.File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 19	java/io/FileWriter
    //   8: dup
    //   9: aload_1
    //   10: iload_2
    //   11: invokespecial 22	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   14: astore_1
    //   15: aload_1
    //   16: aload_0
    //   17: invokevirtual 28	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: invokevirtual 31	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   23: aload_1
    //   24: invokevirtual 34	java/io/FileWriter:flush	()V
    //   27: aload_1
    //   28: invokevirtual 37	java/io/FileWriter:close	()V
    //   31: return
    //   32: astore_0
    //   33: aload_1
    //   34: astore_3
    //   35: goto +38 -> 73
    //   38: astore_3
    //   39: aload_1
    //   40: astore_0
    //   41: aload_3
    //   42: astore_1
    //   43: goto +11 -> 54
    //   46: astore_0
    //   47: goto +26 -> 73
    //   50: astore_1
    //   51: aload 4
    //   53: astore_0
    //   54: aload_0
    //   55: astore_3
    //   56: ldc 8
    //   58: ldc 39
    //   60: aload_1
    //   61: invokestatic 45	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 37	java/io/FileWriter:close	()V
    //   72: return
    //   73: aload_3
    //   74: ifnull +7 -> 81
    //   77: aload_3
    //   78: invokevirtual 37	java/io/FileWriter:close	()V
    //   81: aload_0
    //   82: athrow
    //   83: astore_0
    //   84: return
    //   85: astore_1
    //   86: goto -5 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramStringBuilder	java.lang.StringBuilder
    //   0	89	1	paramFile	java.io.File
    //   0	89	2	paramBoolean	boolean
    //   4	31	3	localFile	java.io.File
    //   38	4	3	localIOException	java.io.IOException
    //   55	23	3	localStringBuilder	java.lang.StringBuilder
    //   1	51	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	27	32	finally
    //   15	27	38	java/io/IOException
    //   5	15	46	finally
    //   56	64	46	finally
    //   5	15	50	java/io/IOException
    //   27	31	83	java/io/IOException
    //   68	72	83	java/io/IOException
    //   77	81	85	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.FileLogger
 * JD-Core Version:    0.7.0.1
 */