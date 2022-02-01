package com.tencent.mobileqq.pluginsdk;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.ZipFile;

public class IOUtil
{
  public static final long CRC32_VALUE_INVALID = -1L;
  public static final String TAG = "IOUtil";
  
  public static void closeStream(Closeable paramCloseable)
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
  
  public static void closeZipFile(ZipFile paramZipFile)
  {
    if (paramZipFile != null) {
      try
      {
        paramZipFile.close();
        return;
      }
      catch (IOException paramZipFile)
      {
        paramZipFile.printStackTrace();
      }
    }
  }
  
  /* Error */
  public static boolean contentEquals(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +128 -> 129
    //   4: aload_0
    //   5: invokevirtual 44	java/io/File:exists	()Z
    //   8: ifeq +121 -> 129
    //   11: aload_1
    //   12: ifnonnull +5 -> 17
    //   15: iconst_0
    //   16: ireturn
    //   17: aconst_null
    //   18: astore 5
    //   20: aconst_null
    //   21: astore 4
    //   23: new 46	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_0
    //   32: new 51	java/io/ByteArrayInputStream
    //   35: dup
    //   36: aload_1
    //   37: invokevirtual 57	java/lang/String:getBytes	()[B
    //   40: invokespecial 60	java/io/ByteArrayInputStream:<init>	([B)V
    //   43: astore_3
    //   44: aload_0
    //   45: aload_3
    //   46: invokestatic 63	com/tencent/mobileqq/pluginsdk/IOUtil:contentEquals	(Ljava/io/InputStream;Ljava/io/InputStream;)Z
    //   49: istore_2
    //   50: aload_0
    //   51: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   54: aload_3
    //   55: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   58: iload_2
    //   59: ireturn
    //   60: astore_1
    //   61: goto +58 -> 119
    //   64: astore_1
    //   65: goto +13 -> 78
    //   68: astore_1
    //   69: aload 5
    //   71: astore_3
    //   72: goto +47 -> 119
    //   75: astore_1
    //   76: aconst_null
    //   77: astore_3
    //   78: aload_0
    //   79: astore 4
    //   81: aload_3
    //   82: astore_0
    //   83: goto +15 -> 98
    //   86: astore_1
    //   87: aconst_null
    //   88: astore_0
    //   89: aload 5
    //   91: astore_3
    //   92: goto +27 -> 119
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_1
    //   99: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   102: aload 4
    //   104: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   107: aload_0
    //   108: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   111: iconst_0
    //   112: ireturn
    //   113: astore_1
    //   114: aload_0
    //   115: astore_3
    //   116: aload 4
    //   118: astore_0
    //   119: aload_0
    //   120: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   123: aload_3
    //   124: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   127: aload_1
    //   128: athrow
    //   129: iconst_0
    //   130: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramFile	java.io.File
    //   0	131	1	paramString	String
    //   49	10	2	bool	boolean
    //   43	81	3	localObject1	Object
    //   21	96	4	localFile	java.io.File
    //   18	72	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   44	50	60	finally
    //   44	50	64	java/lang/Exception
    //   32	44	68	finally
    //   32	44	75	java/lang/Exception
    //   23	32	86	finally
    //   23	32	95	java/lang/Exception
    //   98	102	113	finally
  }
  
  public static boolean contentEquals(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    Object localObject = paramInputStream1;
    if (!(paramInputStream1 instanceof BufferedInputStream)) {
      localObject = new BufferedInputStream(paramInputStream1);
    }
    paramInputStream1 = paramInputStream2;
    if (!(paramInputStream2 instanceof BufferedInputStream)) {
      paramInputStream1 = new BufferedInputStream(paramInputStream2);
    }
    boolean bool;
    for (int i = ((InputStream)localObject).read();; i = ((InputStream)localObject).read())
    {
      bool = false;
      if (-1 == i) {
        break;
      }
      if (i != paramInputStream1.read()) {
        return false;
      }
    }
    if (paramInputStream1.read() == -1) {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  public static long getCRC32Value(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +84 -> 85
    //   4: aload_0
    //   5: invokevirtual 44	java/io/File:exists	()Z
    //   8: ifne +7 -> 15
    //   11: ldc2_w 7
    //   14: lreturn
    //   15: aconst_null
    //   16: astore 5
    //   18: aconst_null
    //   19: astore_3
    //   20: new 46	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokestatic 82	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/InputStream;)J
    //   33: lstore_1
    //   34: aload_0
    //   35: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
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
    //   68: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   71: aload_0
    //   72: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   75: ldc2_w 7
    //   78: lreturn
    //   79: aload_3
    //   80: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   83: aload_0
    //   84: athrow
    //   85: ldc2_w 7
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
  
  public static long getCRC32Value(InputStream paramInputStream)
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
  
  /* Error */
  public static byte[] readByte(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 142	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 40	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: aload_0
    //   19: invokevirtual 44	java/io/File:exists	()Z
    //   22: ifne +5 -> 27
    //   25: aconst_null
    //   26: areturn
    //   27: new 46	java/io/FileInputStream
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: astore_1
    //   36: aload_1
    //   37: astore_0
    //   38: aload_1
    //   39: invokevirtual 91	java/io/InputStream:available	()I
    //   42: newarray byte
    //   44: astore_2
    //   45: aload_1
    //   46: astore_0
    //   47: aload_1
    //   48: aload_2
    //   49: invokevirtual 97	java/io/InputStream:read	([B)I
    //   52: pop
    //   53: aload_1
    //   54: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   57: aload_2
    //   58: areturn
    //   59: astore_2
    //   60: goto +12 -> 72
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_1
    //   66: goto +23 -> 89
    //   69: astore_2
    //   70: aconst_null
    //   71: astore_1
    //   72: aload_1
    //   73: astore_0
    //   74: aload_2
    //   75: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   78: aload_1
    //   79: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   82: aconst_null
    //   83: areturn
    //   84: astore_2
    //   85: aload_0
    //   86: astore_1
    //   87: aload_2
    //   88: astore_0
    //   89: aload_1
    //   90: invokestatic 65	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   93: aload_0
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramString	String
    //   35	55	1	localObject1	Object
    //   44	14	2	arrayOfByte	byte[]
    //   59	1	2	localException1	java.lang.Exception
    //   69	6	2	localException2	java.lang.Exception
    //   84	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   38	45	59	java/lang/Exception
    //   47	53	59	java/lang/Exception
    //   27	36	63	finally
    //   27	36	69	java/lang/Exception
    //   38	45	84	finally
    //   47	53	84	finally
    //   74	78	84	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.IOUtil
 * JD-Core Version:    0.7.0.1
 */