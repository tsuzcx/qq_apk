package com.tencent.mobileqq.videocodec.mediacodec.util;

import android.graphics.Bitmap.CompressFormat;

final class ThumbnailUtil$1
  implements Runnable
{
  ThumbnailUtil$1(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString, Bitmap.CompressFormat paramCompressFormat, int paramInt3, ThumbnailUtil.ThumbnailCallback paramThumbnailCallback) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore_1
    //   5: aload_0
    //   6: getfield 23	com/tencent/mobileqq/videocodec/mediacodec/util/ThumbnailUtil$1:a	I
    //   9: istore_2
    //   10: iload_1
    //   11: iload_2
    //   12: if_icmpge +82 -> 94
    //   15: iconst_0
    //   16: istore_2
    //   17: aload_0
    //   18: getfield 25	com/tencent/mobileqq/videocodec/mediacodec/util/ThumbnailUtil$1:b	I
    //   21: istore_3
    //   22: iload_2
    //   23: iload_3
    //   24: if_icmpge +63 -> 87
    //   27: aload_0
    //   28: getfield 27	com/tencent/mobileqq/videocodec/mediacodec/util/ThumbnailUtil$1:c	[I
    //   31: iload_1
    //   32: iload_3
    //   33: imul
    //   34: iload_2
    //   35: iadd
    //   36: iaload
    //   37: istore 4
    //   39: aload_0
    //   40: getfield 29	com/tencent/mobileqq/videocodec/mediacodec/util/ThumbnailUtil$1:d	[I
    //   43: aload_0
    //   44: getfield 23	com/tencent/mobileqq/videocodec/mediacodec/util/ThumbnailUtil$1:a	I
    //   47: iload_1
    //   48: isub
    //   49: iconst_1
    //   50: isub
    //   51: iload_3
    //   52: imul
    //   53: iload_2
    //   54: iadd
    //   55: iload 4
    //   57: ldc 47
    //   59: iand
    //   60: iload 4
    //   62: bipush 16
    //   64: ishl
    //   65: ldc 48
    //   67: iand
    //   68: ior
    //   69: iload 4
    //   71: bipush 16
    //   73: ishr
    //   74: sipush 255
    //   77: iand
    //   78: ior
    //   79: iastore
    //   80: iload_2
    //   81: iconst_1
    //   82: iadd
    //   83: istore_2
    //   84: goto -67 -> 17
    //   87: iload_1
    //   88: iconst_1
    //   89: iadd
    //   90: istore_1
    //   91: goto -86 -> 5
    //   94: aload_0
    //   95: getfield 29	com/tencent/mobileqq/videocodec/mediacodec/util/ThumbnailUtil$1:d	[I
    //   98: aload_0
    //   99: getfield 25	com/tencent/mobileqq/videocodec/mediacodec/util/ThumbnailUtil$1:b	I
    //   102: iload_2
    //   103: getstatic 54	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   106: invokestatic 60	android/graphics/Bitmap:createBitmap	([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   109: astore 11
    //   111: aconst_null
    //   112: astore 9
    //   114: aconst_null
    //   115: astore 10
    //   117: aconst_null
    //   118: astore 7
    //   120: new 62	java/io/FileOutputStream
    //   123: dup
    //   124: aload_0
    //   125: getfield 31	com/tencent/mobileqq/videocodec/mediacodec/util/ThumbnailUtil$1:e	Ljava/lang/String;
    //   128: invokespecial 65	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   131: astore 8
    //   133: aload 11
    //   135: aload_0
    //   136: getfield 33	com/tencent/mobileqq/videocodec/mediacodec/util/ThumbnailUtil$1:f	Landroid/graphics/Bitmap$CompressFormat;
    //   139: aload_0
    //   140: getfield 35	com/tencent/mobileqq/videocodec/mediacodec/util/ThumbnailUtil$1:g	I
    //   143: aload 8
    //   145: invokevirtual 69	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   148: pop
    //   149: aload 8
    //   151: invokevirtual 72	java/io/FileOutputStream:flush	()V
    //   154: aload 8
    //   156: invokevirtual 75	java/io/FileOutputStream:close	()V
    //   159: goto +10 -> 169
    //   162: astore 7
    //   164: aload 7
    //   166: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   169: iconst_1
    //   170: istore 5
    //   172: goto +118 -> 290
    //   175: astore 9
    //   177: aload 8
    //   179: astore 7
    //   181: aload 9
    //   183: astore 8
    //   185: goto +130 -> 315
    //   188: astore 9
    //   190: goto +23 -> 213
    //   193: astore 9
    //   195: goto +54 -> 249
    //   198: astore 8
    //   200: goto +115 -> 315
    //   203: astore 7
    //   205: aload 9
    //   207: astore 8
    //   209: aload 7
    //   211: astore 9
    //   213: aload 8
    //   215: astore 7
    //   217: aload 9
    //   219: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   222: iload 6
    //   224: istore 5
    //   226: aload 8
    //   228: ifnull +62 -> 290
    //   231: aload 8
    //   233: invokevirtual 75	java/io/FileOutputStream:close	()V
    //   236: iload 6
    //   238: istore 5
    //   240: goto +50 -> 290
    //   243: astore 9
    //   245: aload 10
    //   247: astore 8
    //   249: aload 8
    //   251: astore 7
    //   253: aload 9
    //   255: invokevirtual 79	java/io/FileNotFoundException:printStackTrace	()V
    //   258: iload 6
    //   260: istore 5
    //   262: aload 8
    //   264: ifnull +26 -> 290
    //   267: aload 8
    //   269: invokevirtual 75	java/io/FileOutputStream:close	()V
    //   272: iload 6
    //   274: istore 5
    //   276: goto +14 -> 290
    //   279: astore 7
    //   281: aload 7
    //   283: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   286: iload 6
    //   288: istore 5
    //   290: aload_0
    //   291: getfield 37	com/tencent/mobileqq/videocodec/mediacodec/util/ThumbnailUtil$1:h	Lcom/tencent/mobileqq/videocodec/mediacodec/util/ThumbnailUtil$ThumbnailCallback;
    //   294: astore 7
    //   296: aload 7
    //   298: ifnull +16 -> 314
    //   301: aload 7
    //   303: iload 5
    //   305: aload_0
    //   306: getfield 31	com/tencent/mobileqq/videocodec/mediacodec/util/ThumbnailUtil$1:e	Ljava/lang/String;
    //   309: invokeinterface 84 3 0
    //   314: return
    //   315: aload 7
    //   317: ifnull +18 -> 335
    //   320: aload 7
    //   322: invokevirtual 75	java/io/FileOutputStream:close	()V
    //   325: goto +10 -> 335
    //   328: astore 7
    //   330: aload 7
    //   332: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   335: goto +6 -> 341
    //   338: aload 8
    //   340: athrow
    //   341: goto -3 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	this	1
    //   4	87	1	i	int
    //   9	94	2	j	int
    //   21	32	3	k	int
    //   37	37	4	m	int
    //   170	134	5	bool1	boolean
    //   1	286	6	bool2	boolean
    //   118	1	7	localObject1	Object
    //   162	3	7	localIOException1	java.io.IOException
    //   179	1	7	localObject2	Object
    //   203	7	7	localIOException2	java.io.IOException
    //   215	37	7	localObject3	Object
    //   279	3	7	localIOException3	java.io.IOException
    //   294	27	7	localThumbnailCallback	ThumbnailUtil.ThumbnailCallback
    //   328	3	7	localIOException4	java.io.IOException
    //   131	53	8	localObject4	Object
    //   198	1	8	localObject5	Object
    //   207	132	8	localObject6	Object
    //   112	1	9	localObject7	Object
    //   175	7	9	localObject8	Object
    //   188	1	9	localIOException5	java.io.IOException
    //   193	13	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   211	7	9	localObject9	Object
    //   243	11	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   115	131	10	localObject10	Object
    //   109	25	11	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   154	159	162	java/io/IOException
    //   133	154	175	finally
    //   133	154	188	java/io/IOException
    //   133	154	193	java/io/FileNotFoundException
    //   120	133	198	finally
    //   217	222	198	finally
    //   253	258	198	finally
    //   120	133	203	java/io/IOException
    //   120	133	243	java/io/FileNotFoundException
    //   231	236	279	java/io/IOException
    //   267	272	279	java/io/IOException
    //   320	325	328	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.mediacodec.util.ThumbnailUtil.1
 * JD-Core Version:    0.7.0.1
 */