package com.tencent.mobileqq.pic;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import com.tencent.qphone.base.util.BaseApplication;

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
    //   68: if_icmpeq +48 -> 116
    //   71: aload_3
    //   72: astore_0
    //   73: aload 4
    //   75: aload 5
    //   77: iconst_0
    //   78: iload_2
    //   79: invokevirtual 124	java/io/ByteArrayOutputStream:write	([BII)V
    //   82: goto -25 -> 57
    //   85: astore 4
    //   87: aload_3
    //   88: astore_0
    //   89: aload 4
    //   91: invokevirtual 125	java/io/FileNotFoundException:printStackTrace	()V
    //   94: aload_3
    //   95: ifnull +176 -> 271
    //   98: aload_3
    //   99: invokevirtual 126	java/io/BufferedInputStream:close	()V
    //   102: iconst_0
    //   103: istore_2
    //   104: fconst_0
    //   105: fstore_1
    //   106: iload_2
    //   107: ifeq +7 -> 114
    //   110: iload_2
    //   111: invokestatic 99	com/tencent/mobileqq/pic/JpegError:throwException	(I)V
    //   114: fload_1
    //   115: freturn
    //   116: aload_3
    //   117: astore_0
    //   118: aload 4
    //   120: invokevirtual 127	java/io/ByteArrayOutputStream:close	()V
    //   123: aload_3
    //   124: astore_0
    //   125: aload 4
    //   127: invokevirtual 131	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   130: astore 4
    //   132: aload_3
    //   133: astore_0
    //   134: aload 4
    //   136: aload 4
    //   138: arraylength
    //   139: invokestatic 135	com/tencent/mobileqq/pic/JpegCompressor:getQuality	([BI)F
    //   142: fstore_1
    //   143: aload_3
    //   144: ifnull +134 -> 278
    //   147: aload_3
    //   148: invokevirtual 126	java/io/BufferedInputStream:close	()V
    //   151: iconst_0
    //   152: istore_2
    //   153: goto -47 -> 106
    //   156: astore_0
    //   157: iconst_0
    //   158: istore_2
    //   159: goto -53 -> 106
    //   162: astore_0
    //   163: iconst_0
    //   164: istore_2
    //   165: fconst_0
    //   166: fstore_1
    //   167: goto -61 -> 106
    //   170: astore 4
    //   172: aconst_null
    //   173: astore_3
    //   174: aload_3
    //   175: astore_0
    //   176: aload 4
    //   178: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   181: aload_3
    //   182: ifnull +89 -> 271
    //   185: aload_3
    //   186: invokevirtual 126	java/io/BufferedInputStream:close	()V
    //   189: iconst_0
    //   190: istore_2
    //   191: fconst_0
    //   192: fstore_1
    //   193: goto -87 -> 106
    //   196: astore_0
    //   197: iconst_0
    //   198: istore_2
    //   199: fconst_0
    //   200: fstore_1
    //   201: goto -95 -> 106
    //   204: astore_0
    //   205: aconst_null
    //   206: astore_3
    //   207: bipush 52
    //   209: istore_2
    //   210: aload_3
    //   211: ifnull +55 -> 266
    //   214: aload_3
    //   215: invokevirtual 126	java/io/BufferedInputStream:close	()V
    //   218: fconst_0
    //   219: fstore_1
    //   220: goto -114 -> 106
    //   223: astore_0
    //   224: fconst_0
    //   225: fstore_1
    //   226: goto -120 -> 106
    //   229: astore_3
    //   230: aconst_null
    //   231: astore_0
    //   232: aload_0
    //   233: ifnull +7 -> 240
    //   236: aload_0
    //   237: invokevirtual 126	java/io/BufferedInputStream:close	()V
    //   240: aload_3
    //   241: athrow
    //   242: astore_0
    //   243: goto -3 -> 240
    //   246: astore_3
    //   247: goto -15 -> 232
    //   250: astore_0
    //   251: goto -44 -> 207
    //   254: astore 4
    //   256: goto -82 -> 174
    //   259: astore 4
    //   261: aconst_null
    //   262: astore_3
    //   263: goto -176 -> 87
    //   266: fconst_0
    //   267: fstore_1
    //   268: goto -162 -> 106
    //   271: iconst_0
    //   272: istore_2
    //   273: fconst_0
    //   274: fstore_1
    //   275: goto -169 -> 106
    //   278: iconst_0
    //   279: istore_2
    //   280: goto -174 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramString	String
    //   105	170	1	f	float
    //   65	215	2	i	int
    //   33	182	3	localBufferedInputStream	java.io.BufferedInputStream
    //   229	12	3	localObject1	Object
    //   246	1	3	localObject2	Object
    //   262	1	3	localObject3	Object
    //   46	28	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   85	41	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   130	7	4	arrayOfByte1	byte[]
    //   170	7	4	localIOException1	java.io.IOException
    //   254	1	4	localIOException2	java.io.IOException
    //   259	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   55	21	5	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   36	48	85	java/io/FileNotFoundException
    //   50	57	85	java/io/FileNotFoundException
    //   59	66	85	java/io/FileNotFoundException
    //   73	82	85	java/io/FileNotFoundException
    //   118	123	85	java/io/FileNotFoundException
    //   125	132	85	java/io/FileNotFoundException
    //   134	143	85	java/io/FileNotFoundException
    //   147	151	156	java/io/IOException
    //   98	102	162	java/io/IOException
    //   11	34	170	java/io/IOException
    //   185	189	196	java/io/IOException
    //   11	34	204	java/lang/UnsatisfiedLinkError
    //   214	218	223	java/io/IOException
    //   11	34	229	finally
    //   236	240	242	java/io/IOException
    //   36	48	246	finally
    //   50	57	246	finally
    //   59	66	246	finally
    //   73	82	246	finally
    //   89	94	246	finally
    //   118	123	246	finally
    //   125	132	246	finally
    //   134	143	246	finally
    //   176	181	246	finally
    //   36	48	250	java/lang/UnsatisfiedLinkError
    //   50	57	250	java/lang/UnsatisfiedLinkError
    //   59	66	250	java/lang/UnsatisfiedLinkError
    //   73	82	250	java/lang/UnsatisfiedLinkError
    //   118	123	250	java/lang/UnsatisfiedLinkError
    //   125	132	250	java/lang/UnsatisfiedLinkError
    //   134	143	250	java/lang/UnsatisfiedLinkError
    //   36	48	254	java/io/IOException
    //   50	57	254	java/io/IOException
    //   59	66	254	java/io/IOException
    //   73	82	254	java/io/IOException
    //   118	123	254	java/io/IOException
    //   125	132	254	java/io/IOException
    //   134	143	254	java/io/IOException
    //   11	34	259	java/io/FileNotFoundException
  }
  
  private static native float getQuality(byte[] paramArrayOfByte, int paramInt);
  
  private native long init(JpegDataDest paramJpegDataDest);
  
  public static void jpegcompressLoadSo()
  {
    if ((!soLoadStatus) && (JpegSoLoad.LoadJpegExtractedSo("jpegc_above820", BaseApplication.getContext()) == 0))
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