package com.tencent.tbs.one.impl.base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.Callable;

public class ProcessLock
{
  private final File mFile;
  private final FileLock mFileLock;
  private final FileOutputStream mOutputStream;
  
  private ProcessLock(File paramFile, FileOutputStream paramFileOutputStream, FileLock paramFileLock)
  {
    this.mFile = paramFile;
    this.mOutputStream = paramFileOutputStream;
    this.mFileLock = paramFileLock;
  }
  
  public static ProcessLock acquire(File paramFile, long paramLong)
  {
    return (ProcessLock)pollingWait(new ProcessLock.1(paramFile), paramFile, paramLong);
  }
  
  public static ProcessLock acquire(File paramFile, Callable<Boolean> paramCallable, long paramLong)
  {
    return (ProcessLock)pollingWait(new ProcessLock.2(paramCallable, paramFile), paramFile, paramLong);
  }
  
  /* Error */
  private static <T> T pollingWait(Callable<T> paramCallable, File paramFile, long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iload 4
    //   5: i2l
    //   6: lload_2
    //   7: ldc2_w 46
    //   10: ldiv
    //   11: lcmp
    //   12: ifge +86 -> 98
    //   15: aload_0
    //   16: invokeinterface 53 1 0
    //   21: astore 5
    //   23: aload 5
    //   25: ifnull +27 -> 52
    //   28: iload 4
    //   30: ifle +103 -> 133
    //   33: ldc 55
    //   35: iconst_1
    //   36: anewarray 4	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload_1
    //   42: invokevirtual 61	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   45: aastore
    //   46: invokestatic 67	com/tencent/tbs/one/impl/base/Logging:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   49: aload 5
    //   51: areturn
    //   52: iload 4
    //   54: ifne +19 -> 73
    //   57: ldc 69
    //   59: iconst_1
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload_1
    //   66: invokevirtual 61	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   69: aastore
    //   70: invokestatic 67	com/tencent/tbs/one/impl/base/Logging:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: ldc2_w 46
    //   76: invokestatic 75	java/lang/Thread:sleep	(J)V
    //   79: iload 4
    //   81: iconst_1
    //   82: iadd
    //   83: istore 4
    //   85: goto -82 -> 3
    //   88: astore_0
    //   89: new 77	java/lang/RuntimeException
    //   92: dup
    //   93: aload_0
    //   94: invokespecial 80	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   97: athrow
    //   98: new 77	java/lang/RuntimeException
    //   101: dup
    //   102: new 82	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   109: ldc 85
    //   111: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_1
    //   115: invokevirtual 61	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   118: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokespecial 95	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   127: athrow
    //   128: astore 5
    //   130: goto -51 -> 79
    //   133: aload 5
    //   135: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramCallable	Callable<T>
    //   0	136	1	paramFile	File
    //   0	136	2	paramLong	long
    //   1	83	4	i	int
    //   21	29	5	localObject	Object
    //   128	6	5	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   15	23	88	java/lang/Exception
    //   33	49	88	java/lang/Exception
    //   57	73	88	java/lang/Exception
    //   73	79	128	java/lang/InterruptedException
  }
  
  /* Error */
  public static ProcessLock tryAcquire(File paramFile)
  {
    // Byte code:
    //   0: new 102	java/io/FileOutputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 103	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 107	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   13: invokevirtual 113	java/nio/channels/FileChannel:tryLock	()Ljava/nio/channels/FileLock;
    //   16: astore_3
    //   17: aload_1
    //   18: astore_2
    //   19: aload_3
    //   20: ifnull +57 -> 77
    //   23: ldc 115
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: invokevirtual 61	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   35: aastore
    //   36: invokestatic 67	com/tencent/tbs/one/impl/base/Logging:i	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: new 2	com/tencent/tbs/one/impl/base/ProcessLock
    //   42: dup
    //   43: aload_0
    //   44: aload_1
    //   45: aload_3
    //   46: invokespecial 117	com/tencent/tbs/one/impl/base/ProcessLock:<init>	(Ljava/io/File;Ljava/io/FileOutputStream;Ljava/nio/channels/FileLock;)V
    //   49: astore_2
    //   50: aload_2
    //   51: areturn
    //   52: astore_2
    //   53: aconst_null
    //   54: astore_1
    //   55: ldc 119
    //   57: iconst_2
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_0
    //   64: invokevirtual 61	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: aload_2
    //   71: aastore
    //   72: invokestatic 122	com/tencent/tbs/one/impl/base/Logging:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: aload_1
    //   76: astore_2
    //   77: aload_2
    //   78: invokestatic 128	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   81: aconst_null
    //   82: areturn
    //   83: astore_2
    //   84: goto -29 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramFile	File
    //   8	68	1	localFileOutputStream1	FileOutputStream
    //   18	33	2	localObject	Object
    //   52	19	2	localThrowable1	java.lang.Throwable
    //   76	2	2	localFileOutputStream2	FileOutputStream
    //   83	1	2	localThrowable2	java.lang.Throwable
    //   16	30	3	localFileLock	FileLock
    // Exception table:
    //   from	to	target	type
    //   0	9	52	java/lang/Throwable
    //   9	17	83	java/lang/Throwable
    //   23	50	83	java/lang/Throwable
  }
  
  public void release()
  {
    Logging.i("Deleting lock file: %s", new Object[] { this.mFile.getAbsolutePath() });
    this.mFileLock.release();
    this.mOutputStream.close();
    if (!this.mFile.delete()) {
      throw new IOException("Failed to delete lock file: " + this.mFile.getAbsolutePath());
    }
  }
  
  public void releaseQuietly()
  {
    try
    {
      release();
      return;
    }
    catch (IOException localIOException)
    {
      Logging.e("Failed to release process lock file %s", new Object[] { this.mFile.getAbsolutePath(), localIOException });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.ProcessLock
 * JD-Core Version:    0.7.0.1
 */