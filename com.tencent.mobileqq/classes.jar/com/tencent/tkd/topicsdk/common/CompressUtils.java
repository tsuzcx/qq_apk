package com.tencent.tkd.topicsdk.common;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/CompressUtils;", "", "()V", "BUFFER_SIZE", "", "DEFAULT_JPEG_QUALITY", "ERR_CODE_BITMAP_HAS_RECYCLED", "ERR_CODE_COMPRESS_FAILED", "ERR_CODE_CREATE_FILE_FAILED", "ERR_CODE_SUCCESS", "ERR_CODE_UNKNOWN_EXCEPTION", "compressToFile", "bitmap", "Landroid/graphics/Bitmap;", "path", "", "format", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class CompressUtils
{
  public static final CompressUtils a = new CompressUtils();
  
  /* Error */
  @kotlin.jvm.JvmStatic
  public static final int a(@org.jetbrains.annotations.NotNull android.graphics.Bitmap paramBitmap, @org.jetbrains.annotations.NotNull java.lang.String paramString, @org.jetbrains.annotations.NotNull android.graphics.Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 48
    //   3: invokestatic 54	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 55
    //   9: invokestatic 54	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_2
    //   13: ldc 56
    //   15: invokestatic 54	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_0
    //   19: invokevirtual 62	android/graphics/Bitmap:isRecycled	()Z
    //   22: ifeq +5 -> 27
    //   25: iconst_3
    //   26: ireturn
    //   27: aconst_null
    //   28: checkcast 64	java/io/BufferedOutputStream
    //   31: astore 5
    //   33: new 66	java/io/File
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore_1
    //   42: aload_1
    //   43: invokevirtual 72	java/io/File:exists	()Z
    //   46: ifne +27 -> 73
    //   49: aload_1
    //   50: invokevirtual 75	java/io/File:createNewFile	()Z
    //   53: istore 4
    //   55: iload 4
    //   57: ifne +16 -> 73
    //   60: getstatic 80	com/tencent/tkd/topicsdk/common/IoUtils:a	Lcom/tencent/tkd/topicsdk/common/IoUtils;
    //   63: aload 5
    //   65: checkcast 82	java/io/Closeable
    //   68: invokevirtual 85	com/tencent/tkd/topicsdk/common/IoUtils:a	(Ljava/io/Closeable;)V
    //   71: iconst_1
    //   72: ireturn
    //   73: new 64	java/io/BufferedOutputStream
    //   76: dup
    //   77: new 87	java/io/FileOutputStream
    //   80: dup
    //   81: aload_1
    //   82: invokespecial 90	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   85: checkcast 92	java/io/OutputStream
    //   88: sipush 8192
    //   91: invokespecial 95	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   94: astore_1
    //   95: aload_0
    //   96: invokevirtual 62	android/graphics/Bitmap:isRecycled	()Z
    //   99: istore 4
    //   101: iload 4
    //   103: ifeq +15 -> 118
    //   106: getstatic 80	com/tencent/tkd/topicsdk/common/IoUtils:a	Lcom/tencent/tkd/topicsdk/common/IoUtils;
    //   109: aload_1
    //   110: checkcast 82	java/io/Closeable
    //   113: invokevirtual 85	com/tencent/tkd/topicsdk/common/IoUtils:a	(Ljava/io/Closeable;)V
    //   116: iconst_3
    //   117: ireturn
    //   118: aload_0
    //   119: aload_2
    //   120: iload_3
    //   121: aload_1
    //   122: checkcast 92	java/io/OutputStream
    //   125: invokevirtual 99	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   128: istore 4
    //   130: iload 4
    //   132: ifne +15 -> 147
    //   135: getstatic 80	com/tencent/tkd/topicsdk/common/IoUtils:a	Lcom/tencent/tkd/topicsdk/common/IoUtils;
    //   138: aload_1
    //   139: checkcast 82	java/io/Closeable
    //   142: invokevirtual 85	com/tencent/tkd/topicsdk/common/IoUtils:a	(Ljava/io/Closeable;)V
    //   145: iconst_2
    //   146: ireturn
    //   147: getstatic 80	com/tencent/tkd/topicsdk/common/IoUtils:a	Lcom/tencent/tkd/topicsdk/common/IoUtils;
    //   150: aload_1
    //   151: checkcast 82	java/io/Closeable
    //   154: invokevirtual 85	com/tencent/tkd/topicsdk/common/IoUtils:a	(Ljava/io/Closeable;)V
    //   157: iconst_0
    //   158: ireturn
    //   159: astore_0
    //   160: aload_1
    //   161: astore 5
    //   163: goto +7 -> 170
    //   166: goto +17 -> 183
    //   169: astore_0
    //   170: getstatic 80	com/tencent/tkd/topicsdk/common/IoUtils:a	Lcom/tencent/tkd/topicsdk/common/IoUtils;
    //   173: aload 5
    //   175: checkcast 82	java/io/Closeable
    //   178: invokevirtual 85	com/tencent/tkd/topicsdk/common/IoUtils:a	(Ljava/io/Closeable;)V
    //   181: aload_0
    //   182: athrow
    //   183: getstatic 80	com/tencent/tkd/topicsdk/common/IoUtils:a	Lcom/tencent/tkd/topicsdk/common/IoUtils;
    //   186: aload_1
    //   187: checkcast 82	java/io/Closeable
    //   190: invokevirtual 85	com/tencent/tkd/topicsdk/common/IoUtils:a	(Ljava/io/Closeable;)V
    //   193: iconst_4
    //   194: ireturn
    //   195: astore_0
    //   196: aload 5
    //   198: astore_1
    //   199: goto -16 -> 183
    //   202: astore_0
    //   203: goto -37 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramBitmap	android.graphics.Bitmap
    //   0	206	1	paramString	java.lang.String
    //   0	206	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	206	3	paramInt	int
    //   53	78	4	bool	boolean
    //   31	166	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   95	101	159	finally
    //   118	130	159	finally
    //   42	55	169	finally
    //   73	95	169	finally
    //   42	55	195	java/lang/Exception
    //   73	95	195	java/lang/Exception
    //   95	101	202	java/lang/Exception
    //   118	130	202	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.CompressUtils
 * JD-Core Version:    0.7.0.1
 */