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
    //   6: istore_1
    //   7: iload_1
    //   8: iload_3
    //   9: if_icmpge +90 -> 99
    //   12: aload_0
    //   13: getfield 40	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$width	I
    //   16: istore 4
    //   18: iconst_0
    //   19: istore_2
    //   20: iload_2
    //   21: iload 4
    //   23: if_icmpge +69 -> 92
    //   26: aload_0
    //   27: getfield 42	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$b	[I
    //   30: aload_0
    //   31: getfield 40	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$width	I
    //   34: iload_1
    //   35: imul
    //   36: iload_2
    //   37: iadd
    //   38: iaload
    //   39: istore 5
    //   41: aload_0
    //   42: getfield 44	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$bt	[I
    //   45: aload_0
    //   46: getfield 38	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$height	I
    //   49: iload_1
    //   50: isub
    //   51: iconst_1
    //   52: isub
    //   53: aload_0
    //   54: getfield 40	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$width	I
    //   57: imul
    //   58: iload_2
    //   59: iadd
    //   60: iload 5
    //   62: ldc 71
    //   64: iand
    //   65: iload 5
    //   67: bipush 16
    //   69: ishl
    //   70: ldc 72
    //   72: iand
    //   73: ior
    //   74: iload 5
    //   76: bipush 16
    //   78: ishr
    //   79: sipush 255
    //   82: iand
    //   83: ior
    //   84: iastore
    //   85: iload_2
    //   86: iconst_1
    //   87: iadd
    //   88: istore_2
    //   89: goto -69 -> 20
    //   92: iload_1
    //   93: iconst_1
    //   94: iadd
    //   95: istore_1
    //   96: goto -89 -> 7
    //   99: aload_0
    //   100: getfield 44	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$bt	[I
    //   103: aload_0
    //   104: getfield 40	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$width	I
    //   107: aload_0
    //   108: getfield 38	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$height	I
    //   111: getstatic 78	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   114: invokestatic 84	android/graphics/Bitmap:createBitmap	([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   117: astore 9
    //   119: aconst_null
    //   120: checkcast 86	java/io/FileOutputStream
    //   123: astore 7
    //   125: new 86	java/io/FileOutputStream
    //   128: dup
    //   129: aload_0
    //   130: getfield 46	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$outFilePath	Ljava/lang/String;
    //   133: invokespecial 89	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   136: astore 8
    //   138: aload 8
    //   140: astore 7
    //   142: aload 9
    //   144: aload_0
    //   145: getfield 48	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$compressFormat	Landroid/graphics/Bitmap$CompressFormat;
    //   148: aload_0
    //   149: getfield 50	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$quality	I
    //   152: aload 8
    //   154: checkcast 91	java/io/OutputStream
    //   157: invokevirtual 95	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   160: pop
    //   161: aload 8
    //   163: astore 7
    //   165: aload 8
    //   167: invokevirtual 98	java/io/FileOutputStream:flush	()V
    //   170: iconst_1
    //   171: istore 6
    //   173: aload 8
    //   175: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   178: aload_0
    //   179: getfield 52	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$callback	Lcom/tencent/tkd/topicsdk/common/ThumbnailUtil$ThumbnailCallback;
    //   182: astore 7
    //   184: aload 7
    //   186: ifnull +16 -> 202
    //   189: aload 7
    //   191: iload 6
    //   193: aload_0
    //   194: getfield 46	com/tencent/tkd/topicsdk/common/ThumbnailUtil$generateThumb$1:$outFilePath	Ljava/lang/String;
    //   197: invokeinterface 107 3 0
    //   202: return
    //   203: astore 7
    //   205: aload 7
    //   207: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   210: goto -32 -> 178
    //   213: astore 9
    //   215: aload 7
    //   217: astore 8
    //   219: aload 8
    //   221: astore 7
    //   223: aload 9
    //   225: invokevirtual 111	java/io/FileNotFoundException:printStackTrace	()V
    //   228: aload 8
    //   230: ifnull +8 -> 238
    //   233: aload 8
    //   235: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   238: iconst_0
    //   239: istore 6
    //   241: goto -63 -> 178
    //   244: astore 7
    //   246: aload 7
    //   248: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   251: goto -13 -> 238
    //   254: astore 9
    //   256: aload 7
    //   258: astore 8
    //   260: aload 8
    //   262: astore 7
    //   264: aload 9
    //   266: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   269: aload 8
    //   271: ifnull +8 -> 279
    //   274: aload 8
    //   276: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   279: iconst_0
    //   280: istore 6
    //   282: goto -104 -> 178
    //   285: astore 7
    //   287: aload 7
    //   289: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   292: goto -13 -> 279
    //   295: astore 8
    //   297: aload 7
    //   299: ifnull +8 -> 307
    //   302: aload 7
    //   304: invokevirtual 101	java/io/FileOutputStream:close	()V
    //   307: aload 8
    //   309: athrow
    //   310: astore 7
    //   312: aload 7
    //   314: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   317: goto -10 -> 307
    //   320: astore 8
    //   322: goto -25 -> 297
    //   325: astore 9
    //   327: goto -67 -> 260
    //   330: astore 9
    //   332: goto -113 -> 219
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	1
    //   6	90	1	i	int
    //   19	70	2	j	int
    //   4	6	3	k	int
    //   16	8	4	m	int
    //   39	40	5	n	int
    //   171	110	6	bool	boolean
    //   123	67	7	localObject1	java.lang.Object
    //   203	13	7	localIOException1	java.io.IOException
    //   221	1	7	localObject2	java.lang.Object
    //   244	13	7	localIOException2	java.io.IOException
    //   262	1	7	localObject3	java.lang.Object
    //   285	18	7	localIOException3	java.io.IOException
    //   310	3	7	localIOException4	java.io.IOException
    //   136	139	8	localObject4	java.lang.Object
    //   295	13	8	localObject5	java.lang.Object
    //   320	1	8	localObject6	java.lang.Object
    //   117	26	9	localBitmap	android.graphics.Bitmap
    //   213	11	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   254	11	9	localIOException5	java.io.IOException
    //   325	1	9	localIOException6	java.io.IOException
    //   330	1	9	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   173	178	203	java/io/IOException
    //   125	138	213	java/io/FileNotFoundException
    //   233	238	244	java/io/IOException
    //   125	138	254	java/io/IOException
    //   274	279	285	java/io/IOException
    //   125	138	295	finally
    //   302	307	310	java/io/IOException
    //   142	161	320	finally
    //   165	170	320	finally
    //   223	228	320	finally
    //   264	269	320	finally
    //   142	161	325	java/io/IOException
    //   165	170	325	java/io/IOException
    //   142	161	330	java/io/FileNotFoundException
    //   165	170	330	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.ThumbnailUtil.generateThumb.1
 * JD-Core Version:    0.7.0.1
 */