package com.tencent.mobileqq.pic;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;

public final class JpegCompressor
{
  public static final int COLOR_SPACE_GRAY = 3;
  public static final int COLOR_SPACE_RGB = 1;
  public static final int COLOR_SPACE_RGBA = 2;
  static boolean soLoadStatus = false;
  private long nativePtr;
  
  static
  {
    try
    {
      jpegcompressLoadSo();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      soLoadStatus = false;
    }
  }
  
  public JpegCompressor(JpegDataDest paramJpegDataDest)
  {
    try
    {
      this.nativePtr = init(paramJpegDataDest);
      return;
    }
    catch (UnsatisfiedLinkError paramJpegDataDest) {}
  }
  
  private native long compressBitMap(long paramLong, Bitmap paramBitmap, byte[] paramArrayOfByte);
  
  private native long compressByteArray(long paramLong, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2);
  
  private native int compressCb(long paramLong, Bitmap paramBitmap);
  
  public static void compressJpeg(Bitmap paramBitmap, String paramString, JpegCompressOptions paramJpegCompressOptions)
  {
    JpegCompressor localJpegCompressor = new JpegCompressor(new JpegCompressor.JpegDataDestImpl(paramString));
    paramString = paramJpegCompressOptions;
    if (paramJpegCompressOptions == null) {
      paramString = JpegCompressOptions.DEFAULT;
    }
    try
    {
      localJpegCompressor.setParams(paramString.CompressQuality, paramString.isOptimize, paramString.isProgress, paramString.isArithCode, paramString.isPreferQualityOverSpeed);
      localJpegCompressor.compress(paramBitmap);
      return;
    }
    finally
    {
      localJpegCompressor.close();
    }
  }
  
  private native void destroy(long paramLong);
  
  /* Error */
  public static float getJpegQuality(String paramString)
  {
    // Byte code:
    //   0: getstatic 21	com/tencent/mobileqq/pic/JpegCompressor:soLoadStatus	Z
    //   3: ifne +8 -> 11
    //   6: bipush 50
    //   8: invokestatic 99	com/tencent/mobileqq/pic/JpegError:throwException	(I)V
    //   11: new 101	java/io/BufferedInputStream
    //   14: dup
    //   15: new 103	java/io/FileInputStream
    //   18: dup
    //   19: new 105	java/io/File
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 109	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: invokespecial 112	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: astore_3
    //   34: aload_3
    //   35: astore_0
    //   36: new 114	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: sipush 1000
    //   43: invokespecial 116	java/io/ByteArrayOutputStream:<init>	(I)V
    //   46: astore 4
    //   48: aload_3
    //   49: astore_0
    //   50: sipush 1000
    //   53: newarray byte
    //   55: astore 5
    //   57: aload_3
    //   58: astore_0
    //   59: aload_3
    //   60: aload 5
    //   62: invokevirtual 120	java/io/BufferedInputStream:read	([B)I
    //   65: istore_2
    //   66: iload_2
    //   67: iconst_m1
    //   68: if_icmpne +50 -> 118
    //   71: aload_3
    //   72: astore_0
    //   73: aload 4
    //   75: invokevirtual 121	java/io/ByteArrayOutputStream:close	()V
    //   78: aload_3
    //   79: astore_0
    //   80: aload 4
    //   82: invokevirtual 125	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   85: astore 4
    //   87: aload_3
    //   88: astore_0
    //   89: aload 4
    //   91: aload 4
    //   93: arraylength
    //   94: invokestatic 129	com/tencent/mobileqq/pic/JpegCompressor:getQuality	([BI)F
    //   97: fstore_1
    //   98: aload_3
    //   99: ifnull +167 -> 266
    //   102: aload_3
    //   103: invokevirtual 130	java/io/BufferedInputStream:close	()V
    //   106: iconst_0
    //   107: istore_2
    //   108: iload_2
    //   109: ifeq +7 -> 116
    //   112: iload_2
    //   113: invokestatic 99	com/tencent/mobileqq/pic/JpegError:throwException	(I)V
    //   116: fload_1
    //   117: freturn
    //   118: aload_3
    //   119: astore_0
    //   120: aload 4
    //   122: aload 5
    //   124: iconst_0
    //   125: iload_2
    //   126: invokevirtual 134	java/io/ByteArrayOutputStream:write	([BII)V
    //   129: goto -72 -> 57
    //   132: astore 4
    //   134: aload_3
    //   135: astore_0
    //   136: aload 4
    //   138: invokevirtual 135	java/io/FileNotFoundException:printStackTrace	()V
    //   141: aload_3
    //   142: ifnull +134 -> 276
    //   145: aload_3
    //   146: invokevirtual 130	java/io/BufferedInputStream:close	()V
    //   149: iconst_0
    //   150: istore_2
    //   151: fconst_0
    //   152: fstore_1
    //   153: goto -45 -> 108
    //   156: astore_0
    //   157: iconst_0
    //   158: istore_2
    //   159: fconst_0
    //   160: fstore_1
    //   161: goto -53 -> 108
    //   164: astore 4
    //   166: aconst_null
    //   167: astore_3
    //   168: aload_3
    //   169: astore_0
    //   170: aload 4
    //   172: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   175: aload_3
    //   176: ifnull +100 -> 276
    //   179: aload_3
    //   180: invokevirtual 130	java/io/BufferedInputStream:close	()V
    //   183: iconst_0
    //   184: istore_2
    //   185: fconst_0
    //   186: fstore_1
    //   187: goto -79 -> 108
    //   190: astore_0
    //   191: iconst_0
    //   192: istore_2
    //   193: fconst_0
    //   194: fstore_1
    //   195: goto -87 -> 108
    //   198: astore_0
    //   199: aconst_null
    //   200: astore_3
    //   201: bipush 52
    //   203: istore_2
    //   204: aload_3
    //   205: ifnull +66 -> 271
    //   208: aload_3
    //   209: invokevirtual 130	java/io/BufferedInputStream:close	()V
    //   212: fconst_0
    //   213: fstore_1
    //   214: goto -106 -> 108
    //   217: astore_0
    //   218: fconst_0
    //   219: fstore_1
    //   220: goto -112 -> 108
    //   223: astore_3
    //   224: aconst_null
    //   225: astore_0
    //   226: aload_0
    //   227: ifnull +7 -> 234
    //   230: aload_0
    //   231: invokevirtual 130	java/io/BufferedInputStream:close	()V
    //   234: aload_3
    //   235: athrow
    //   236: astore_0
    //   237: iconst_0
    //   238: istore_2
    //   239: goto -131 -> 108
    //   242: astore_0
    //   243: goto -9 -> 234
    //   246: astore_3
    //   247: goto -21 -> 226
    //   250: astore_0
    //   251: goto -50 -> 201
    //   254: astore 4
    //   256: goto -88 -> 168
    //   259: astore 4
    //   261: aconst_null
    //   262: astore_3
    //   263: goto -129 -> 134
    //   266: iconst_0
    //   267: istore_2
    //   268: goto -160 -> 108
    //   271: fconst_0
    //   272: fstore_1
    //   273: goto -165 -> 108
    //   276: iconst_0
    //   277: istore_2
    //   278: fconst_0
    //   279: fstore_1
    //   280: goto -172 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramString	String
    //   97	183	1	f	float
    //   65	213	2	i	int
    //   33	176	3	localBufferedInputStream	java.io.BufferedInputStream
    //   223	12	3	localObject1	Object
    //   246	1	3	localObject2	Object
    //   262	1	3	localObject3	Object
    //   46	75	4	localObject4	Object
    //   132	5	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   164	7	4	localIOException1	java.io.IOException
    //   254	1	4	localIOException2	java.io.IOException
    //   259	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   55	68	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   36	48	132	java/io/FileNotFoundException
    //   50	57	132	java/io/FileNotFoundException
    //   59	66	132	java/io/FileNotFoundException
    //   73	78	132	java/io/FileNotFoundException
    //   80	87	132	java/io/FileNotFoundException
    //   89	98	132	java/io/FileNotFoundException
    //   120	129	132	java/io/FileNotFoundException
    //   145	149	156	java/io/IOException
    //   11	34	164	java/io/IOException
    //   179	183	190	java/io/IOException
    //   11	34	198	java/lang/UnsatisfiedLinkError
    //   208	212	217	java/io/IOException
    //   11	34	223	finally
    //   102	106	236	java/io/IOException
    //   230	234	242	java/io/IOException
    //   36	48	246	finally
    //   50	57	246	finally
    //   59	66	246	finally
    //   73	78	246	finally
    //   80	87	246	finally
    //   89	98	246	finally
    //   120	129	246	finally
    //   136	141	246	finally
    //   170	175	246	finally
    //   36	48	250	java/lang/UnsatisfiedLinkError
    //   50	57	250	java/lang/UnsatisfiedLinkError
    //   59	66	250	java/lang/UnsatisfiedLinkError
    //   73	78	250	java/lang/UnsatisfiedLinkError
    //   80	87	250	java/lang/UnsatisfiedLinkError
    //   89	98	250	java/lang/UnsatisfiedLinkError
    //   120	129	250	java/lang/UnsatisfiedLinkError
    //   36	48	254	java/io/IOException
    //   50	57	254	java/io/IOException
    //   59	66	254	java/io/IOException
    //   73	78	254	java/io/IOException
    //   80	87	254	java/io/IOException
    //   89	98	254	java/io/IOException
    //   120	129	254	java/io/IOException
    //   11	34	259	java/io/FileNotFoundException
  }
  
  private static native float getQuality(byte[] paramArrayOfByte, int paramInt);
  
  private native long init(JpegDataDest paramJpegDataDest);
  
  public static void jpegcompressLoadSo()
  {
    if ((!soLoadStatus) && (JpegSoLoad.LoadJpegExtractedSo("jpegc_above665") == 0))
    {
      int i = Color.argb(255, 0, 1, 2);
      Object localObject = Bitmap.Config.ARGB_8888;
      localObject = Bitmap.createBitmap(new int[] { i }, 1, 1, (Bitmap.Config)localObject);
      if (localObject != null) {
        predictPixelStorage((Bitmap)localObject);
      }
      soLoadStatus = true;
    }
  }
  
  private static native void predictPixelStorage(Bitmap paramBitmap);
  
  private native void setParams(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  
  public void close()
  {
    try
    {
      if (this.nativePtr != 0L)
      {
        destroy(this.nativePtr);
        this.nativePtr = 0L;
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public int compress(Bitmap paramBitmap, byte[] paramArrayOfByte)
  {
    if (!soLoadStatus) {
      JpegError.throwException(50);
    }
    long l1 = 0L;
    try
    {
      long l2 = compressBitMap(this.nativePtr, paramBitmap, paramArrayOfByte);
      l1 = l2;
      i = (int)(l1 & 0xFFFFFFFF);
    }
    catch (UnsatisfiedLinkError paramBitmap)
    {
      for (;;)
      {
        int i = 52;
      }
    }
    if (i != 0) {
      JpegError.throwException(i);
    }
    return (int)(l1 >> 32 & 0xFFFFFFFF);
  }
  
  public int compress(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2)
  {
    if (!soLoadStatus) {
      JpegError.throwException(50);
    }
    int i = 3;
    switch (paramInt3)
    {
    }
    for (;;)
    {
      if (i * (paramInt1 * paramInt2) > paramArrayOfByte1.length) {
        JpegError.throwException(4);
      }
      try
      {
        l = compressByteArray(this.nativePtr, paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramArrayOfByte2);
        paramInt1 = (int)(0xFFFFFFFF & l);
      }
      catch (UnsatisfiedLinkError paramArrayOfByte1)
      {
        for (;;)
        {
          paramInt1 = 52;
          long l = 0L;
        }
      }
      if (paramInt1 != 0) {
        JpegError.throwException(paramInt1);
      }
      return (int)(l >> 32 & 0xFFFFFFFF);
      i = 4;
      continue;
      i = 1;
    }
  }
  
  public void compress(Bitmap paramBitmap)
  {
    if (!soLoadStatus) {
      JpegError.throwException(50);
    }
    try
    {
      i = compressCb(this.nativePtr, paramBitmap);
      if (i != 0) {
        JpegError.throwException(i);
      }
      return;
    }
    catch (UnsatisfiedLinkError paramBitmap)
    {
      for (;;)
      {
        int i = 52;
      }
    }
  }
  
  public int computeOutSize(Bitmap paramBitmap)
  {
    int i = 0;
    if (paramBitmap != null) {
      i = paramBitmap.getHeight() * paramBitmap.getRowBytes() + 2048;
    }
    return i;
  }
  
  public void finalize()
  {
    try
    {
      close();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public void setParams(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    try
    {
      setParams(this.nativePtr, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, false);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public void setParams(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    try
    {
      setParams(this.nativePtr, paramInt, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.pic.JpegCompressor
 * JD-Core Version:    0.7.0.1
 */