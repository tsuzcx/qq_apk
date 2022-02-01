package com.tencent.mobileqq.qcircle.api.util;

public class PhotoUtils
{
  /* Error */
  public static boolean a(android.graphics.Bitmap paramBitmap, java.lang.String paramString, android.graphics.Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 17	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 20	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 24	java/io/File:exists	()Z
    //   13: ifne +8 -> 21
    //   16: aload_1
    //   17: invokevirtual 27	java/io/File:createNewFile	()Z
    //   20: pop
    //   21: new 29	java/io/BufferedOutputStream
    //   24: dup
    //   25: new 31	java/io/FileOutputStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 34	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: invokespecial 37	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   36: astore 7
    //   38: aload 7
    //   40: astore_1
    //   41: aload_0
    //   42: aload_2
    //   43: iload_3
    //   44: aload 7
    //   46: invokevirtual 43	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   49: istore 5
    //   51: aload 7
    //   53: astore_1
    //   54: aload 7
    //   56: invokevirtual 46	java/io/BufferedOutputStream:flush	()V
    //   59: iload 4
    //   61: ifeq +10 -> 71
    //   64: aload 7
    //   66: astore_1
    //   67: aload_0
    //   68: invokevirtual 49	android/graphics/Bitmap:recycle	()V
    //   71: iload 5
    //   73: istore 6
    //   75: aload 7
    //   77: ifnull +12 -> 89
    //   80: aload 7
    //   82: invokevirtual 52	java/io/BufferedOutputStream:close	()V
    //   85: iload 5
    //   87: istore 6
    //   89: iload 6
    //   91: ireturn
    //   92: astore 7
    //   94: ldc 54
    //   96: iconst_1
    //   97: ldc 56
    //   99: aload 7
    //   101: invokestatic 62	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   104: goto -83 -> 21
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   112: iload 5
    //   114: ireturn
    //   115: astore_0
    //   116: aconst_null
    //   117: astore_2
    //   118: iconst_0
    //   119: istore 4
    //   121: aload_2
    //   122: astore_1
    //   123: ldc 54
    //   125: iconst_1
    //   126: ldc 67
    //   128: aload_0
    //   129: invokestatic 62	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   132: iload 4
    //   134: istore 6
    //   136: aload_2
    //   137: ifnull -48 -> 89
    //   140: aload_2
    //   141: invokevirtual 52	java/io/BufferedOutputStream:close	()V
    //   144: iload 4
    //   146: ireturn
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   152: iload 4
    //   154: ireturn
    //   155: astore_0
    //   156: aconst_null
    //   157: astore_1
    //   158: aload_1
    //   159: ifnull +7 -> 166
    //   162: aload_1
    //   163: invokevirtual 52	java/io/BufferedOutputStream:close	()V
    //   166: aload_0
    //   167: athrow
    //   168: astore_1
    //   169: aload_1
    //   170: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   173: goto -7 -> 166
    //   176: astore_0
    //   177: goto -19 -> 158
    //   180: astore_0
    //   181: iconst_0
    //   182: istore 4
    //   184: aload 7
    //   186: astore_2
    //   187: goto -66 -> 121
    //   190: astore_0
    //   191: iload 5
    //   193: istore 4
    //   195: aload 7
    //   197: astore_2
    //   198: goto -77 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	paramBitmap	android.graphics.Bitmap
    //   0	201	1	paramString	java.lang.String
    //   0	201	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	201	3	paramInt	int
    //   0	201	4	paramBoolean	boolean
    //   49	143	5	bool1	boolean
    //   73	62	6	bool2	boolean
    //   36	45	7	localBufferedOutputStream	java.io.BufferedOutputStream
    //   92	104	7	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   16	21	92	java/lang/Exception
    //   80	85	107	java/io/IOException
    //   21	38	115	java/lang/Exception
    //   140	144	147	java/io/IOException
    //   21	38	155	finally
    //   162	166	168	java/io/IOException
    //   41	51	176	finally
    //   54	59	176	finally
    //   67	71	176	finally
    //   123	132	176	finally
    //   41	51	180	java/lang/Exception
    //   54	59	190	java/lang/Exception
    //   67	71	190	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.util.PhotoUtils
 * JD-Core Version:    0.7.0.1
 */