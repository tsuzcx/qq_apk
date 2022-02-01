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
    //   0: getstatic 28	com/tencent/mobileqq/pic/JpegCompressor:soLoadStatus	Z
    //   3: ifne +8 -> 11
    //   6: bipush 50
    //   8: invokestatic 100	com/tencent/mobileqq/pic/JpegError:throwException	(I)V
    //   11: iconst_0
    //   12: istore 4
    //   14: iconst_0
    //   15: istore 5
    //   17: fconst_0
    //   18: fstore_3
    //   19: fconst_0
    //   20: fstore_2
    //   21: new 102	java/io/BufferedInputStream
    //   24: dup
    //   25: new 104	java/io/FileInputStream
    //   28: dup
    //   29: new 106	java/io/File
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: invokespecial 110	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   40: invokespecial 113	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_0
    //   44: aload_0
    //   45: astore 7
    //   47: new 115	java/io/ByteArrayOutputStream
    //   50: dup
    //   51: sipush 1000
    //   54: invokespecial 117	java/io/ByteArrayOutputStream:<init>	(I)V
    //   57: astore 8
    //   59: aload_0
    //   60: astore 7
    //   62: sipush 1000
    //   65: newarray byte
    //   67: astore 9
    //   69: aload_0
    //   70: astore 7
    //   72: aload_0
    //   73: aload 9
    //   75: invokevirtual 121	java/io/BufferedInputStream:read	([B)I
    //   78: istore 6
    //   80: iload 6
    //   82: iconst_m1
    //   83: if_icmpeq +19 -> 102
    //   86: aload_0
    //   87: astore 7
    //   89: aload 8
    //   91: aload 9
    //   93: iconst_0
    //   94: iload 6
    //   96: invokevirtual 125	java/io/ByteArrayOutputStream:write	([BII)V
    //   99: goto -30 -> 69
    //   102: aload_0
    //   103: astore 7
    //   105: aload 8
    //   107: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   110: aload_0
    //   111: astore 7
    //   113: aload 8
    //   115: invokevirtual 130	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   118: astore 8
    //   120: aload_0
    //   121: astore 7
    //   123: aload 8
    //   125: aload 8
    //   127: arraylength
    //   128: invokestatic 134	com/tencent/mobileqq/pic/JpegCompressor:getQuality	([BI)F
    //   131: fstore_1
    //   132: iload 5
    //   134: istore 4
    //   136: aload_0
    //   137: invokevirtual 135	java/io/BufferedInputStream:close	()V
    //   140: goto +101 -> 241
    //   143: goto +98 -> 241
    //   146: goto +22 -> 168
    //   149: astore 8
    //   151: goto +44 -> 195
    //   154: astore 8
    //   156: goto +62 -> 218
    //   159: astore_0
    //   160: aconst_null
    //   161: astore 7
    //   163: goto +91 -> 254
    //   166: aconst_null
    //   167: astore_0
    //   168: bipush 52
    //   170: istore 5
    //   172: iload 5
    //   174: istore 4
    //   176: fload_3
    //   177: fstore_1
    //   178: aload_0
    //   179: ifnull +62 -> 241
    //   182: iload 5
    //   184: istore 4
    //   186: fload_2
    //   187: fstore_1
    //   188: goto -52 -> 136
    //   191: astore 8
    //   193: aconst_null
    //   194: astore_0
    //   195: aload_0
    //   196: astore 7
    //   198: aload 8
    //   200: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   203: fload_3
    //   204: fstore_1
    //   205: aload_0
    //   206: ifnull +35 -> 241
    //   209: iload 5
    //   211: istore 4
    //   213: fload_2
    //   214: fstore_1
    //   215: goto -79 -> 136
    //   218: aload_0
    //   219: astore 7
    //   221: aload 8
    //   223: invokevirtual 137	java/io/FileNotFoundException:printStackTrace	()V
    //   226: fload_3
    //   227: fstore_1
    //   228: aload_0
    //   229: ifnull +12 -> 241
    //   232: iload 5
    //   234: istore 4
    //   236: fload_2
    //   237: fstore_1
    //   238: goto -102 -> 136
    //   241: iload 4
    //   243: ifeq +8 -> 251
    //   246: iload 4
    //   248: invokestatic 100	com/tencent/mobileqq/pic/JpegError:throwException	(I)V
    //   251: fload_1
    //   252: freturn
    //   253: astore_0
    //   254: aload 7
    //   256: ifnull +8 -> 264
    //   259: aload 7
    //   261: invokevirtual 135	java/io/BufferedInputStream:close	()V
    //   264: goto +5 -> 269
    //   267: aload_0
    //   268: athrow
    //   269: goto -2 -> 267
    //   272: astore_0
    //   273: goto -107 -> 166
    //   276: astore 7
    //   278: goto -132 -> 146
    //   281: astore_0
    //   282: goto -139 -> 143
    //   285: astore 7
    //   287: goto -23 -> 264
    //   290: astore 8
    //   292: aconst_null
    //   293: astore_0
    //   294: goto -76 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramString	String
    //   131	121	1	f1	float
    //   20	217	2	f2	float
    //   18	209	3	f3	float
    //   12	235	4	i	int
    //   15	218	5	j	int
    //   78	17	6	k	int
    //   45	215	7	str	String
    //   276	1	7	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   285	1	7	localIOException1	java.io.IOException
    //   57	69	8	localObject	Object
    //   149	1	8	localIOException2	java.io.IOException
    //   154	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   191	31	8	localIOException3	java.io.IOException
    //   290	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   67	25	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   47	59	149	java/io/IOException
    //   62	69	149	java/io/IOException
    //   72	80	149	java/io/IOException
    //   89	99	149	java/io/IOException
    //   105	110	149	java/io/IOException
    //   113	120	149	java/io/IOException
    //   123	132	149	java/io/IOException
    //   47	59	154	java/io/FileNotFoundException
    //   62	69	154	java/io/FileNotFoundException
    //   72	80	154	java/io/FileNotFoundException
    //   89	99	154	java/io/FileNotFoundException
    //   105	110	154	java/io/FileNotFoundException
    //   113	120	154	java/io/FileNotFoundException
    //   123	132	154	java/io/FileNotFoundException
    //   21	44	159	finally
    //   21	44	191	java/io/IOException
    //   47	59	253	finally
    //   62	69	253	finally
    //   72	80	253	finally
    //   89	99	253	finally
    //   105	110	253	finally
    //   113	120	253	finally
    //   123	132	253	finally
    //   198	203	253	finally
    //   221	226	253	finally
    //   21	44	272	java/lang/UnsatisfiedLinkError
    //   47	59	276	java/lang/UnsatisfiedLinkError
    //   62	69	276	java/lang/UnsatisfiedLinkError
    //   72	80	276	java/lang/UnsatisfiedLinkError
    //   89	99	276	java/lang/UnsatisfiedLinkError
    //   105	110	276	java/lang/UnsatisfiedLinkError
    //   113	120	276	java/lang/UnsatisfiedLinkError
    //   123	132	276	java/lang/UnsatisfiedLinkError
    //   136	140	281	java/io/IOException
    //   259	264	285	java/io/IOException
    //   21	44	290	java/io/FileNotFoundException
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
      i = (int)(l2 & 0xFFFFFFFF);
      l1 = l2;
    }
    catch (UnsatisfiedLinkError paramBitmap)
    {
      int i;
      label41:
      break label41;
    }
    i = 52;
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
    int i;
    if (paramInt3 != 2)
    {
      if (paramInt3 != 3) {
        i = 3;
      } else {
        i = 1;
      }
    }
    else {
      i = 4;
    }
    if (paramInt1 * paramInt2 * i > paramArrayOfByte1.length) {
      JpegError.throwException(4);
    }
    long l1 = 0L;
    try
    {
      long l2 = compressByteArray(this.nativePtr, paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramArrayOfByte2);
      paramInt1 = (int)(l2 & 0xFFFFFFFF);
      l1 = l2;
    }
    catch (UnsatisfiedLinkError paramArrayOfByte1)
    {
      label88:
      break label88;
    }
    paramInt1 = 52;
    if (paramInt1 != 0) {
      JpegError.throwException(paramInt1);
    }
    return (int)(l1 >> 32 & 0xFFFFFFFF);
  }
  
  public void compress(Bitmap paramBitmap)
  {
    if (!soLoadStatus) {
      JpegError.throwException(50);
    }
    try
    {
      i = compressCb(this.nativePtr, paramBitmap);
    }
    catch (UnsatisfiedLinkError paramBitmap)
    {
      int i;
      label24:
      break label24;
    }
    i = 52;
    if (i != 0) {
      JpegError.throwException(i);
    }
  }
  
  public int computeOutSize(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      return paramBitmap.getHeight() * paramBitmap.getRowBytes() + 2048;
    }
    return 0;
  }
  
  /* Error */
  public void finalize()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 86	com/tencent/mobileqq/pic/JpegCompressor:close	()V
    //   4: aload_0
    //   5: invokespecial 199	java/lang/Object:finalize	()V
    //   8: return
    //   9: astore_1
    //   10: goto +11 -> 21
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   18: goto -14 -> 4
    //   21: aload_0
    //   22: invokespecial 199	java/lang/Object:finalize	()V
    //   25: goto +5 -> 30
    //   28: aload_1
    //   29: athrow
    //   30: goto -2 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	JpegCompressor
    //   9	1	1	localObject	Object
    //   13	16	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	9	finally
    //   14	18	9	finally
    //   0	4	13	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.JpegCompressor
 * JD-Core Version:    0.7.0.1
 */