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
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 19	java/io/File:exists	()Z
    //   8: ifne +7 -> 15
    //   11: ldc2_w 20
    //   14: lreturn
    //   15: new 23	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 26	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_3
    //   24: aload_3
    //   25: astore_0
    //   26: aload_3
    //   27: invokestatic 29	com/tencent/mobileqq/soload/util/IOUtil:a	(Ljava/io/InputStream;)J
    //   30: lstore_1
    //   31: aload_3
    //   32: invokestatic 32	com/tencent/mobileqq/soload/util/IOUtil:a	(Ljava/io/Closeable;)V
    //   35: lload_1
    //   36: lreturn
    //   37: astore 4
    //   39: aconst_null
    //   40: astore_3
    //   41: aload_3
    //   42: astore_0
    //   43: aload 4
    //   45: invokevirtual 35	java/lang/Exception:printStackTrace	()V
    //   48: aload_3
    //   49: invokestatic 32	com/tencent/mobileqq/soload/util/IOUtil:a	(Ljava/io/Closeable;)V
    //   52: ldc2_w 20
    //   55: lreturn
    //   56: astore_3
    //   57: aconst_null
    //   58: astore_0
    //   59: aload_0
    //   60: invokestatic 32	com/tencent/mobileqq/soload/util/IOUtil:a	(Ljava/io/Closeable;)V
    //   63: aload_3
    //   64: athrow
    //   65: astore_3
    //   66: goto -7 -> 59
    //   69: astore 4
    //   71: goto -30 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramFile	java.io.File
    //   30	6	1	l	long
    //   23	26	3	localFileInputStream	java.io.FileInputStream
    //   56	8	3	localObject1	Object
    //   65	1	3	localObject2	Object
    //   37	7	4	localException1	java.lang.Exception
    //   69	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   15	24	37	java/lang/Exception
    //   15	24	56	finally
    //   26	31	65	finally
    //   43	48	65	finally
    //   26	31	69	java/lang/Exception
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
    if (QLog.isColorLevel()) {
      QLog.d("IOUtil", 2, "getCRC32Value fileTotalSize = " + i + " takeTime = " + (System.currentTimeMillis() - l1));
    }
    return l2;
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.util.IOUtil
 * JD-Core Version:    0.7.0.1
 */