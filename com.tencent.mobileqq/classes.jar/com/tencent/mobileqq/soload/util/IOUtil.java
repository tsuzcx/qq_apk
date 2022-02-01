package com.tencent.mobileqq.soload.util;

import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;

public class IOUtil
{
  /* Error */
  public static long a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +84 -> 85
    //   4: aload_0
    //   5: invokevirtual 19	java/io/File:exists	()Z
    //   8: ifne +7 -> 15
    //   11: ldc2_w 20
    //   14: lreturn
    //   15: aconst_null
    //   16: astore 5
    //   18: aconst_null
    //   19: astore_3
    //   20: new 23	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 26	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokestatic 29	com/tencent/mobileqq/soload/util/IOUtil:a	(Ljava/io/InputStream;)J
    //   33: lstore_1
    //   34: aload_0
    //   35: invokestatic 32	com/tencent/mobileqq/soload/util/IOUtil:a	(Ljava/io/Closeable;)V
    //   38: lload_1
    //   39: lreturn
    //   40: astore 4
    //   42: aload_0
    //   43: astore_3
    //   44: aload 4
    //   46: astore_0
    //   47: goto +32 -> 79
    //   50: astore 4
    //   52: goto +12 -> 64
    //   55: astore_0
    //   56: goto +23 -> 79
    //   59: astore 4
    //   61: aload 5
    //   63: astore_0
    //   64: aload_0
    //   65: astore_3
    //   66: aload 4
    //   68: invokevirtual 35	java/lang/Exception:printStackTrace	()V
    //   71: aload_0
    //   72: invokestatic 32	com/tencent/mobileqq/soload/util/IOUtil:a	(Ljava/io/Closeable;)V
    //   75: ldc2_w 20
    //   78: lreturn
    //   79: aload_3
    //   80: invokestatic 32	com/tencent/mobileqq/soload/util/IOUtil:a	(Ljava/io/Closeable;)V
    //   83: aload_0
    //   84: athrow
    //   85: ldc2_w 20
    //   88: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramFile	java.io.File
    //   33	6	1	l	long
    //   19	61	3	localFile	java.io.File
    //   40	5	4	localObject1	Object
    //   50	1	4	localException1	java.lang.Exception
    //   59	8	4	localException2	java.lang.Exception
    //   16	46	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   29	34	40	finally
    //   29	34	50	java/lang/Exception
    //   20	29	55	finally
    //   66	71	55	finally
    //   20	29	59	java/lang/Exception
  }
  
  public static long a(InputStream paramInputStream)
  {
    long l1 = System.currentTimeMillis();
    int i = paramInputStream.available();
    byte[] arrayOfByte = new byte[8192];
    CRC32 localCRC32 = new CRC32();
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (j == -1) {
        break;
      }
      localCRC32.update(arrayOfByte, 0, j);
    }
    long l2 = localCRC32.getValue();
    if (QLog.isColorLevel())
    {
      paramInputStream = new StringBuilder();
      paramInputStream.append("getCRC32Value fileTotalSize = ");
      paramInputStream.append(i);
      paramInputStream.append(" takeTime = ");
      paramInputStream.append(System.currentTimeMillis() - l1);
      QLog.d("IOUtil", 2, paramInputStream.toString());
    }
    return l2;
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable)
      {
        paramCloseable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.util.IOUtil
 * JD-Core Version:    0.7.0.1
 */