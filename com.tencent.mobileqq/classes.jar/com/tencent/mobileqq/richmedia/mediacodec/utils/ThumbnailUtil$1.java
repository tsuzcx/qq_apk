package com.tencent.mobileqq.richmedia.mediacodec.utils;

import android.graphics.Bitmap.CompressFormat;
import bahi;

public final class ThumbnailUtil$1
  implements Runnable
{
  public ThumbnailUtil$1(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String paramString, Bitmap.CompressFormat paramCompressFormat, int paramInt3, bahi parambahi) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore_1
    //   5: iload_1
    //   6: aload_0
    //   7: getfield 18	com/tencent/mobileqq/richmedia/mediacodec/utils/ThumbnailUtil$1:jdField_a_of_type_Int	I
    //   10: if_icmpge +82 -> 92
    //   13: iconst_0
    //   14: istore_2
    //   15: iload_2
    //   16: aload_0
    //   17: getfield 20	com/tencent/mobileqq/richmedia/mediacodec/utils/ThumbnailUtil$1:jdField_b_of_type_Int	I
    //   20: if_icmpge +65 -> 85
    //   23: aload_0
    //   24: getfield 22	com/tencent/mobileqq/richmedia/mediacodec/utils/ThumbnailUtil$1:jdField_a_of_type_ArrayOfInt	[I
    //   27: aload_0
    //   28: getfield 20	com/tencent/mobileqq/richmedia/mediacodec/utils/ThumbnailUtil$1:jdField_b_of_type_Int	I
    //   31: iload_1
    //   32: imul
    //   33: iload_2
    //   34: iadd
    //   35: iaload
    //   36: istore_3
    //   37: aload_0
    //   38: getfield 24	com/tencent/mobileqq/richmedia/mediacodec/utils/ThumbnailUtil$1:jdField_b_of_type_ArrayOfInt	[I
    //   41: aload_0
    //   42: getfield 18	com/tencent/mobileqq/richmedia/mediacodec/utils/ThumbnailUtil$1:jdField_a_of_type_Int	I
    //   45: iload_1
    //   46: isub
    //   47: iconst_1
    //   48: isub
    //   49: aload_0
    //   50: getfield 20	com/tencent/mobileqq/richmedia/mediacodec/utils/ThumbnailUtil$1:jdField_b_of_type_Int	I
    //   53: imul
    //   54: iload_2
    //   55: iadd
    //   56: iload_3
    //   57: ldc 42
    //   59: iand
    //   60: iload_3
    //   61: bipush 16
    //   63: ishl
    //   64: ldc 43
    //   66: iand
    //   67: ior
    //   68: iload_3
    //   69: bipush 16
    //   71: ishr
    //   72: sipush 255
    //   75: iand
    //   76: ior
    //   77: iastore
    //   78: iload_2
    //   79: iconst_1
    //   80: iadd
    //   81: istore_2
    //   82: goto -67 -> 15
    //   85: iload_1
    //   86: iconst_1
    //   87: iadd
    //   88: istore_1
    //   89: goto -84 -> 5
    //   92: aload_0
    //   93: getfield 24	com/tencent/mobileqq/richmedia/mediacodec/utils/ThumbnailUtil$1:jdField_b_of_type_ArrayOfInt	[I
    //   96: aload_0
    //   97: getfield 20	com/tencent/mobileqq/richmedia/mediacodec/utils/ThumbnailUtil$1:jdField_b_of_type_Int	I
    //   100: aload_0
    //   101: getfield 18	com/tencent/mobileqq/richmedia/mediacodec/utils/ThumbnailUtil$1:jdField_a_of_type_Int	I
    //   104: getstatic 49	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   107: invokestatic 55	android/graphics/Bitmap:createBitmap	([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   110: astore 8
    //   112: new 57	java/io/FileOutputStream
    //   115: dup
    //   116: aload_0
    //   117: getfield 26	com/tencent/mobileqq/richmedia/mediacodec/utils/ThumbnailUtil$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   120: invokespecial 60	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   123: astore 7
    //   125: aload 7
    //   127: astore 6
    //   129: aload 8
    //   131: aload_0
    //   132: getfield 28	com/tencent/mobileqq/richmedia/mediacodec/utils/ThumbnailUtil$1:jdField_a_of_type_AndroidGraphicsBitmap$CompressFormat	Landroid/graphics/Bitmap$CompressFormat;
    //   135: aload_0
    //   136: getfield 30	com/tencent/mobileqq/richmedia/mediacodec/utils/ThumbnailUtil$1:c	I
    //   139: aload 7
    //   141: invokevirtual 64	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   144: pop
    //   145: aload 7
    //   147: astore 6
    //   149: aload 7
    //   151: invokevirtual 67	java/io/FileOutputStream:flush	()V
    //   154: iconst_1
    //   155: istore 5
    //   157: iload 5
    //   159: istore 4
    //   161: aload 7
    //   163: ifnull +12 -> 175
    //   166: aload 7
    //   168: invokevirtual 70	java/io/FileOutputStream:close	()V
    //   171: iload 5
    //   173: istore 4
    //   175: aload_0
    //   176: getfield 32	com/tencent/mobileqq/richmedia/mediacodec/utils/ThumbnailUtil$1:jdField_a_of_type_Bahi	Lbahi;
    //   179: ifnull +18 -> 197
    //   182: aload_0
    //   183: getfield 32	com/tencent/mobileqq/richmedia/mediacodec/utils/ThumbnailUtil$1:jdField_a_of_type_Bahi	Lbahi;
    //   186: iload 4
    //   188: aload_0
    //   189: getfield 26	com/tencent/mobileqq/richmedia/mediacodec/utils/ThumbnailUtil$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   192: invokeinterface 75 3 0
    //   197: return
    //   198: astore 6
    //   200: aload 6
    //   202: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   205: iload 5
    //   207: istore 4
    //   209: goto -34 -> 175
    //   212: astore 8
    //   214: aconst_null
    //   215: astore 7
    //   217: aload 7
    //   219: astore 6
    //   221: aload 8
    //   223: invokevirtual 79	java/io/FileNotFoundException:printStackTrace	()V
    //   226: iload 5
    //   228: istore 4
    //   230: aload 7
    //   232: ifnull -57 -> 175
    //   235: aload 7
    //   237: invokevirtual 70	java/io/FileOutputStream:close	()V
    //   240: iload 5
    //   242: istore 4
    //   244: goto -69 -> 175
    //   247: astore 6
    //   249: aload 6
    //   251: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   254: iload 5
    //   256: istore 4
    //   258: goto -83 -> 175
    //   261: astore 8
    //   263: aconst_null
    //   264: astore 7
    //   266: aload 7
    //   268: astore 6
    //   270: aload 8
    //   272: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   275: iload 5
    //   277: istore 4
    //   279: aload 7
    //   281: ifnull -106 -> 175
    //   284: aload 7
    //   286: invokevirtual 70	java/io/FileOutputStream:close	()V
    //   289: iload 5
    //   291: istore 4
    //   293: goto -118 -> 175
    //   296: astore 6
    //   298: aload 6
    //   300: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   303: iload 5
    //   305: istore 4
    //   307: goto -132 -> 175
    //   310: astore 7
    //   312: aconst_null
    //   313: astore 6
    //   315: aload 6
    //   317: ifnull +8 -> 325
    //   320: aload 6
    //   322: invokevirtual 70	java/io/FileOutputStream:close	()V
    //   325: aload 7
    //   327: athrow
    //   328: astore 6
    //   330: aload 6
    //   332: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   335: goto -10 -> 325
    //   338: astore 7
    //   340: goto -25 -> 315
    //   343: astore 8
    //   345: goto -79 -> 266
    //   348: astore 8
    //   350: goto -133 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	this	1
    //   4	85	1	i	int
    //   14	68	2	j	int
    //   36	36	3	k	int
    //   159	147	4	bool1	boolean
    //   1	303	5	bool2	boolean
    //   127	21	6	localFileOutputStream1	java.io.FileOutputStream
    //   198	3	6	localIOException1	java.io.IOException
    //   219	1	6	localFileOutputStream2	java.io.FileOutputStream
    //   247	3	6	localIOException2	java.io.IOException
    //   268	1	6	localFileOutputStream3	java.io.FileOutputStream
    //   296	3	6	localIOException3	java.io.IOException
    //   313	8	6	localObject1	Object
    //   328	3	6	localIOException4	java.io.IOException
    //   123	162	7	localFileOutputStream4	java.io.FileOutputStream
    //   310	16	7	localObject2	Object
    //   338	1	7	localObject3	Object
    //   110	20	8	localBitmap	android.graphics.Bitmap
    //   212	10	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   261	10	8	localIOException5	java.io.IOException
    //   343	1	8	localIOException6	java.io.IOException
    //   348	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   166	171	198	java/io/IOException
    //   112	125	212	java/io/FileNotFoundException
    //   235	240	247	java/io/IOException
    //   112	125	261	java/io/IOException
    //   284	289	296	java/io/IOException
    //   112	125	310	finally
    //   320	325	328	java/io/IOException
    //   129	145	338	finally
    //   149	154	338	finally
    //   221	226	338	finally
    //   270	275	338	finally
    //   129	145	343	java/io/IOException
    //   149	154	343	java/io/IOException
    //   129	145	348	java/io/FileNotFoundException
    //   149	154	348	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.utils.ThumbnailUtil.1
 * JD-Core Version:    0.7.0.1
 */