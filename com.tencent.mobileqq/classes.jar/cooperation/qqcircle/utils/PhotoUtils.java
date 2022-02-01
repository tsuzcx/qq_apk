package cooperation.qqcircle.utils;

public class PhotoUtils
{
  private static final String TAG = "PhotoUtils";
  
  /* Error */
  public static boolean saveBitmapToFile(android.graphics.Bitmap paramBitmap, String paramString, android.graphics.Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 21	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 24	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 7
    //   10: aload 7
    //   12: invokevirtual 28	java/io/File:exists	()Z
    //   15: ifne +22 -> 37
    //   18: aload 7
    //   20: invokevirtual 31	java/io/File:createNewFile	()Z
    //   23: pop
    //   24: goto +13 -> 37
    //   27: astore_1
    //   28: ldc 8
    //   30: iconst_1
    //   31: ldc 33
    //   33: aload_1
    //   34: invokestatic 39	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   37: iconst_0
    //   38: istore 6
    //   40: iconst_0
    //   41: istore 5
    //   43: aconst_null
    //   44: astore 8
    //   46: aconst_null
    //   47: astore_1
    //   48: new 41	java/io/BufferedOutputStream
    //   51: dup
    //   52: new 43	java/io/FileOutputStream
    //   55: dup
    //   56: aload 7
    //   58: invokespecial 46	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: invokespecial 49	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   64: astore 7
    //   66: aload_0
    //   67: aload_2
    //   68: iload_3
    //   69: aload 7
    //   71: invokevirtual 55	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   74: istore 6
    //   76: iload 6
    //   78: istore 5
    //   80: aload 7
    //   82: invokevirtual 58	java/io/BufferedOutputStream:flush	()V
    //   85: iload 4
    //   87: ifeq +11 -> 98
    //   90: iload 6
    //   92: istore 5
    //   94: aload_0
    //   95: invokevirtual 61	android/graphics/Bitmap:recycle	()V
    //   98: iload 6
    //   100: istore 4
    //   102: aload 7
    //   104: invokevirtual 64	java/io/BufferedOutputStream:close	()V
    //   107: iload 6
    //   109: ireturn
    //   110: astore_0
    //   111: aload_0
    //   112: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   115: iload 4
    //   117: ireturn
    //   118: astore_0
    //   119: aload 7
    //   121: astore_1
    //   122: goto +48 -> 170
    //   125: astore_2
    //   126: aload 7
    //   128: astore_0
    //   129: goto +15 -> 144
    //   132: astore_0
    //   133: goto +37 -> 170
    //   136: astore_2
    //   137: iload 6
    //   139: istore 5
    //   141: aload 8
    //   143: astore_0
    //   144: aload_0
    //   145: astore_1
    //   146: ldc 8
    //   148: iconst_1
    //   149: ldc 69
    //   151: aload_2
    //   152: invokestatic 39	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   155: aload_0
    //   156: ifnull +11 -> 167
    //   159: iload 5
    //   161: istore 4
    //   163: aload_0
    //   164: invokevirtual 64	java/io/BufferedOutputStream:close	()V
    //   167: iload 5
    //   169: ireturn
    //   170: aload_1
    //   171: ifnull +15 -> 186
    //   174: aload_1
    //   175: invokevirtual 64	java/io/BufferedOutputStream:close	()V
    //   178: goto +8 -> 186
    //   181: astore_1
    //   182: aload_1
    //   183: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   186: aload_0
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramBitmap	android.graphics.Bitmap
    //   0	188	1	paramString	String
    //   0	188	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	188	3	paramInt	int
    //   0	188	4	paramBoolean	boolean
    //   41	127	5	bool1	boolean
    //   38	100	6	bool2	boolean
    //   8	119	7	localObject1	Object
    //   44	98	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   18	24	27	java/lang/Exception
    //   102	107	110	java/io/IOException
    //   163	167	110	java/io/IOException
    //   66	76	118	finally
    //   80	85	118	finally
    //   94	98	118	finally
    //   66	76	125	java/lang/Exception
    //   80	85	125	java/lang/Exception
    //   94	98	125	java/lang/Exception
    //   48	66	132	finally
    //   146	155	132	finally
    //   48	66	136	java/lang/Exception
    //   174	178	181	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.utils.PhotoUtils
 * JD-Core Version:    0.7.0.1
 */