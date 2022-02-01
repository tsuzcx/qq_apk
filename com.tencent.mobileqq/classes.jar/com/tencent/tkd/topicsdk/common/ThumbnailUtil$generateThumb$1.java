package com.tencent.tkd.topicsdk.common;

import android.graphics.Bitmap.CompressFormat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class ThumbnailUtil$generateThumb$1
  extends Lambda
  implements Function0<Unit>
{
  ThumbnailUtil$generateThumb$1(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString, Bitmap.CompressFormat paramCompressFormat, int paramInt3, ThumbnailUtil.ThumbnailCallback paramThumbnailCallback)
  {
    super(0);
  }
  
  /* Error */
  public final void invoke()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$height	I
    //   4: istore_3
    //   5: iconst_0
    //   6: istore 8
    //   8: iconst_0
    //   9: istore_1
    //   10: iload_1
    //   11: iload_3
    //   12: if_icmpge +96 -> 108
    //   15: aload_0
    //   16: getfield 40	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$width	I
    //   19: istore 4
    //   21: iconst_0
    //   22: istore_2
    //   23: iload_2
    //   24: iload 4
    //   26: if_icmpge +75 -> 101
    //   29: aload_0
    //   30: getfield 42	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$b	[I
    //   33: astore 9
    //   35: aload_0
    //   36: getfield 40	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$width	I
    //   39: istore 5
    //   41: aload 9
    //   43: iload_1
    //   44: iload 5
    //   46: imul
    //   47: iload_2
    //   48: iadd
    //   49: iaload
    //   50: istore 6
    //   52: aload_0
    //   53: getfield 44	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$bt	[I
    //   56: aload_0
    //   57: getfield 38	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$height	I
    //   60: iload_1
    //   61: isub
    //   62: iconst_1
    //   63: isub
    //   64: iload 5
    //   66: imul
    //   67: iload_2
    //   68: iadd
    //   69: iload 6
    //   71: ldc 71
    //   73: iand
    //   74: iload 6
    //   76: bipush 16
    //   78: ishl
    //   79: ldc 72
    //   81: iand
    //   82: ior
    //   83: iload 6
    //   85: bipush 16
    //   87: ishr
    //   88: sipush 255
    //   91: iand
    //   92: ior
    //   93: iastore
    //   94: iload_2
    //   95: iconst_1
    //   96: iadd
    //   97: istore_2
    //   98: goto -75 -> 23
    //   101: iload_1
    //   102: iconst_1
    //   103: iadd
    //   104: istore_1
    //   105: goto -95 -> 10
    //   108: aload_0
    //   109: getfield 44	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$bt	[I
    //   112: aload_0
    //   113: getfield 40	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$width	I
    //   116: aload_0
    //   117: getfield 38	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$height	I
    //   120: getstatic 78	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   123: invokestatic 84	android/graphics/Bitmap:createBitmap	([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   126: astore 12
    //   128: aconst_null
    //   129: checkcast 86	java/io/FileOutputStream
    //   132: astore 11
    //   134: aload 11
    //   136: astore 9
    //   138: new 86	java/io/FileOutputStream
    //   141: dup
    //   142: aload_0
    //   143: getfield 46	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$outFilePath	Ljava/lang/String;
    //   146: invokespecial 89	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   149: astore 10
    //   151: aload 12
    //   153: aload_0
    //   154: getfield 48	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$compressFormat	Landroid/graphics/Bitmap$CompressFormat;
    //   157: aload_0
    //   158: getfield 50	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$quality	I
    //   161: aload 10
    //   163: checkcast 91	java/io/OutputStream
    //   166: invokevirtual 95	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   169: pop
    //   170: aload 10
    //   172: invokevirtual 98	java/io/FileOutputStream:flush	()V
    //   175: aload 10
    //   177: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   180: goto +10 -> 190
    //   183: astore 9
    //   185: aload 9
    //   187: invokevirtual 104	java/io/IOException:printStackTrace	()V
    //   190: iconst_1
    //   191: istore 7
    //   193: goto +122 -> 315
    //   196: astore 11
    //   198: aload 10
    //   200: astore 9
    //   202: aload 11
    //   204: astore 10
    //   206: goto +134 -> 340
    //   209: astore 9
    //   211: aload 10
    //   213: astore 11
    //   215: aload 9
    //   217: astore 10
    //   219: goto +23 -> 242
    //   222: astore 9
    //   224: aload 10
    //   226: astore 11
    //   228: aload 9
    //   230: astore 10
    //   232: goto +56 -> 288
    //   235: astore 10
    //   237: goto +103 -> 340
    //   240: astore 10
    //   242: aload 11
    //   244: astore 9
    //   246: aload 10
    //   248: invokevirtual 104	java/io/IOException:printStackTrace	()V
    //   251: iload 8
    //   253: istore 7
    //   255: aload 11
    //   257: ifnull +58 -> 315
    //   260: aload 11
    //   262: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   265: iload 8
    //   267: istore 7
    //   269: goto +46 -> 315
    //   272: astore 9
    //   274: aload 9
    //   276: invokevirtual 104	java/io/IOException:printStackTrace	()V
    //   279: iload 8
    //   281: istore 7
    //   283: goto +32 -> 315
    //   286: astore 10
    //   288: aload 11
    //   290: astore 9
    //   292: aload 10
    //   294: invokevirtual 105	java/io/FileNotFoundException:printStackTrace	()V
    //   297: iload 8
    //   299: istore 7
    //   301: aload 11
    //   303: ifnull +12 -> 315
    //   306: aload 11
    //   308: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   311: iload 8
    //   313: istore 7
    //   315: aload_0
    //   316: getfield 52	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$callback	Lcom/tencent/tkd/topicsdk/common/ThumbnailUtil$ThumbnailCallback;
    //   319: astore 9
    //   321: aload 9
    //   323: ifnull +16 -> 339
    //   326: aload 9
    //   328: iload 7
    //   330: aload_0
    //   331: getfield 46	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$outFilePath	Ljava/lang/String;
    //   334: invokeinterface 111 3 0
    //   339: return
    //   340: aload 9
    //   342: ifnull +18 -> 360
    //   345: aload 9
    //   347: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   350: goto +10 -> 360
    //   353: astore 9
    //   355: aload 9
    //   357: invokevirtual 104	java/io/IOException:printStackTrace	()V
    //   360: goto +6 -> 366
    //   363: aload 10
    //   365: athrow
    //   366: goto -3 -> 363
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	1
    //   9	96	1	i	int
    //   22	76	2	j	int
    //   4	9	3	k	int
    //   19	8	4	m	int
    //   39	28	5	n	int
    //   50	38	6	i1	int
    //   191	138	7	bool1	boolean
    //   6	306	8	bool2	boolean
    //   33	104	9	localObject1	java.lang.Object
    //   183	3	9	localIOException1	java.io.IOException
    //   200	1	9	localObject2	java.lang.Object
    //   209	7	9	localIOException2	java.io.IOException
    //   222	7	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   244	1	9	localObject3	java.lang.Object
    //   272	3	9	localIOException3	java.io.IOException
    //   290	56	9	localObject4	java.lang.Object
    //   353	3	9	localIOException4	java.io.IOException
    //   149	82	10	localObject5	java.lang.Object
    //   235	1	10	localObject6	java.lang.Object
    //   240	7	10	localIOException5	java.io.IOException
    //   286	78	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   132	3	11	localFileOutputStream	java.io.FileOutputStream
    //   196	7	11	localObject7	java.lang.Object
    //   213	94	11	localObject8	java.lang.Object
    //   126	26	12	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   175	180	183	java/io/IOException
    //   151	175	196	finally
    //   151	175	209	java/io/IOException
    //   151	175	222	java/io/FileNotFoundException
    //   138	151	235	finally
    //   246	251	235	finally
    //   292	297	235	finally
    //   138	151	240	java/io/IOException
    //   260	265	272	java/io/IOException
    //   306	311	272	java/io/IOException
    //   138	151	286	java/io/FileNotFoundException
    //   345	350	353	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.ThumbnailUtil.generateThumb.1
 * JD-Core Version:    0.7.0.1
 */