package com.tencent.sharpP;

import android.graphics.Bitmap;
import android.util.Log;

public final class SharpPUtil
{
  private static final String SHARPP_TAG = "SHARPP";
  public static final String TAG = "SharpPUtil";
  public static final String soLibName = "libSharpPDec.so";
  
  public static Bitmap decodeSharpPByFilePath(String paramString)
  {
    Object localObject2 = null;
    SharpPDecoder localSharpPDecoder = new SharpPDecoder();
    int i = localSharpPDecoder.parseHeader(paramString);
    if (i != 0)
    {
      Log.d("SharpPUtil", "status: " + i);
      return null;
    }
    i = localSharpPDecoder.getSharpPType();
    Object localObject1 = localObject2;
    if (3 != i)
    {
      localObject1 = localObject2;
      if (4 == i) {}
    }
    try
    {
      localObject1 = localSharpPDecoder.decodeSharpP2PNG2(paramString, 4, 1000);
      return localObject1;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        Log.e("SharpPUtil", "sharpP so link error, missing native method.");
        paramString.printStackTrace();
        localObject1 = localObject2;
      }
    }
  }
  
  /* Error */
  public static boolean isSharpPFile(java.io.File paramFile)
  {
    // Byte code:
    //   0: bipush 6
    //   2: newarray byte
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_1
    //   7: aconst_null
    //   8: astore_2
    //   9: new 73	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: astore_0
    //   18: aload_0
    //   19: aload_3
    //   20: invokevirtual 80	java/io/FileInputStream:read	([B)I
    //   23: pop
    //   24: aload_0
    //   25: ifnull +183 -> 208
    //   28: aload_0
    //   29: invokevirtual 83	java/io/FileInputStream:close	()V
    //   32: new 85	java/lang/String
    //   35: dup
    //   36: aload_3
    //   37: invokespecial 88	java/lang/String:<init>	([B)V
    //   40: astore_0
    //   41: ldc 11
    //   43: new 32	java/lang/StringBuilder
    //   46: dup
    //   47: ldc 90
    //   49: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   52: aload_0
    //   53: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 51	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   62: pop
    //   63: aload_0
    //   64: ldc 8
    //   66: invokevirtual 97	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   69: ireturn
    //   70: astore_1
    //   71: aload_2
    //   72: astore_0
    //   73: aload_1
    //   74: astore_2
    //   75: aload_0
    //   76: astore_1
    //   77: ldc 11
    //   79: new 32	java/lang/StringBuilder
    //   82: dup
    //   83: ldc 99
    //   85: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: aload_2
    //   89: invokevirtual 102	java/io/IOException:getMessage	()Ljava/lang/String;
    //   92: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 51	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   101: pop
    //   102: aload_0
    //   103: ifnull -71 -> 32
    //   106: aload_0
    //   107: invokevirtual 83	java/io/FileInputStream:close	()V
    //   110: goto -78 -> 32
    //   113: astore_0
    //   114: ldc 11
    //   116: new 32	java/lang/StringBuilder
    //   119: dup
    //   120: ldc 104
    //   122: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload_0
    //   126: invokevirtual 102	java/io/IOException:getMessage	()Ljava/lang/String;
    //   129: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 51	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   138: pop
    //   139: goto -107 -> 32
    //   142: astore_0
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 83	java/io/FileInputStream:close	()V
    //   151: aload_0
    //   152: athrow
    //   153: astore_1
    //   154: ldc 11
    //   156: new 32	java/lang/StringBuilder
    //   159: dup
    //   160: ldc 104
    //   162: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   165: aload_1
    //   166: invokevirtual 102	java/io/IOException:getMessage	()Ljava/lang/String;
    //   169: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 51	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   178: pop
    //   179: goto -28 -> 151
    //   182: astore_0
    //   183: ldc 11
    //   185: new 32	java/lang/StringBuilder
    //   188: dup
    //   189: ldc 104
    //   191: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   194: aload_0
    //   195: invokevirtual 102	java/io/IOException:getMessage	()Ljava/lang/String;
    //   198: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 51	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   207: pop
    //   208: goto -176 -> 32
    //   211: astore_2
    //   212: aload_0
    //   213: astore_1
    //   214: aload_2
    //   215: astore_0
    //   216: goto -73 -> 143
    //   219: astore_2
    //   220: goto -145 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	paramFile	java.io.File
    //   6	1	1	localObject1	Object
    //   70	4	1	localIOException1	java.io.IOException
    //   76	72	1	localFile1	java.io.File
    //   153	13	1	localIOException2	java.io.IOException
    //   213	1	1	localFile2	java.io.File
    //   8	81	2	localIOException3	java.io.IOException
    //   211	4	2	localObject2	Object
    //   219	1	2	localIOException4	java.io.IOException
    //   4	33	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   9	18	70	java/io/IOException
    //   106	110	113	java/io/IOException
    //   9	18	142	finally
    //   77	102	142	finally
    //   147	151	153	java/io/IOException
    //   28	32	182	java/io/IOException
    //   18	24	211	finally
    //   18	24	219	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sharpP.SharpPUtil
 * JD-Core Version:    0.7.0.1
 */