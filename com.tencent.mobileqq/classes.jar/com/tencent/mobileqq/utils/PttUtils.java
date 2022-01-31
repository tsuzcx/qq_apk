package com.tencent.mobileqq.utils;

import android.util.SparseIntArray;
import java.io.ByteArrayInputStream;

public class PttUtils
{
  private static final SparseIntArray a = new SparseIntArray(8);
  
  static
  {
    a.put(4, 13);
    a.put(12, 14);
    a.put(20, 16);
    a.put(28, 18);
    a.put(36, 20);
    a.put(44, 21);
    a.put(52, 27);
    a.put(60, 32);
  }
  
  private static final boolean a(ByteArrayInputStream paramByteArrayInputStream, int[] paramArrayOfInt)
  {
    paramByteArrayInputStream.read("#!AMR\n".getBytes());
    int j = paramByteArrayInputStream.read();
    int i = 0;
    if ((i >= paramArrayOfInt.length) || (j == paramArrayOfInt[i])) {
      if (i != paramArrayOfInt.length) {
        break label45;
      }
    }
    label45:
    do
    {
      return false;
      i += 1;
      break;
      i = a.get(j, -1);
    } while (i == -1);
    paramArrayOfInt = new byte[i - 1];
    paramByteArrayInputStream.read(paramArrayOfInt);
    for (;;)
    {
      i = paramByteArrayInputStream.read();
      if (i == -1) {
        break label95;
      }
      if (i != j) {
        break;
      }
      paramByteArrayInputStream.read(paramArrayOfInt);
    }
    label95:
    return true;
  }
  
  /* Error */
  public static final boolean a(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 52	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: iload_3
    //   12: istore_2
    //   13: aload_0
    //   14: invokevirtual 59	java/io/File:exists	()Z
    //   17: ifeq +14 -> 31
    //   20: aload_0
    //   21: invokevirtual 63	java/io/File:length	()J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifne +7 -> 33
    //   29: iload_3
    //   30: istore_2
    //   31: iload_2
    //   32: ireturn
    //   33: new 34	java/io/ByteArrayInputStream
    //   36: dup
    //   37: aload_0
    //   38: invokestatic 68	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   41: invokespecial 71	java/io/ByteArrayInputStream:<init>	([B)V
    //   44: astore 4
    //   46: aload 4
    //   48: astore_0
    //   49: aload 4
    //   51: aload_1
    //   52: invokestatic 73	com/tencent/mobileqq/utils/PttUtils:a	(Ljava/io/ByteArrayInputStream;[I)Z
    //   55: istore_2
    //   56: iload_2
    //   57: istore_3
    //   58: iload_3
    //   59: istore_2
    //   60: aload 4
    //   62: ifnull -31 -> 31
    //   65: aload 4
    //   67: invokevirtual 76	java/io/ByteArrayInputStream:close	()V
    //   70: iload_3
    //   71: ireturn
    //   72: astore_0
    //   73: iload_3
    //   74: ireturn
    //   75: astore 5
    //   77: aconst_null
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +15 -> 99
    //   87: aload_1
    //   88: astore_0
    //   89: ldc 83
    //   91: iconst_2
    //   92: ldc 85
    //   94: aload 5
    //   96: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   99: iload_3
    //   100: istore_2
    //   101: aload_1
    //   102: ifnull -71 -> 31
    //   105: aload_1
    //   106: invokevirtual 76	java/io/ByteArrayInputStream:close	()V
    //   109: iconst_0
    //   110: ireturn
    //   111: astore_0
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_0
    //   117: aload_0
    //   118: ifnull +7 -> 125
    //   121: aload_0
    //   122: invokevirtual 76	java/io/ByteArrayInputStream:close	()V
    //   125: aload_1
    //   126: athrow
    //   127: astore_0
    //   128: goto -3 -> 125
    //   131: astore_1
    //   132: goto -15 -> 117
    //   135: astore 5
    //   137: aload 4
    //   139: astore_1
    //   140: goto -61 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString	String
    //   0	143	1	paramArrayOfInt	int[]
    //   12	89	2	bool1	boolean
    //   1	99	3	bool2	boolean
    //   44	94	4	localByteArrayInputStream	ByteArrayInputStream
    //   75	20	5	localThrowable1	java.lang.Throwable
    //   135	1	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   65	70	72	java/lang/Exception
    //   33	46	75	java/lang/Throwable
    //   105	109	111	java/lang/Exception
    //   33	46	114	finally
    //   121	125	127	java/lang/Exception
    //   49	56	131	finally
    //   81	87	131	finally
    //   89	99	131	finally
    //   49	56	135	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PttUtils
 * JD-Core Version:    0.7.0.1
 */