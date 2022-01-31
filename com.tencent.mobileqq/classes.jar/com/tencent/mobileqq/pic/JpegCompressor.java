package com.tencent.mobileqq.pic;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

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
    throws Exception
  {
    JpegCompressor localJpegCompressor = new JpegCompressor(new JpegDataDestImpl(paramString));
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
    //   0: fconst_0
    //   1: fstore_2
    //   2: getstatic 24	com/tencent/mobileqq/pic/JpegCompressor:soLoadStatus	Z
    //   5: ifne +8 -> 13
    //   8: bipush 50
    //   10: invokestatic 103	com/tencent/mobileqq/pic/JpegError:throwException	(I)V
    //   13: iconst_0
    //   14: istore 4
    //   16: aconst_null
    //   17: astore 7
    //   19: aconst_null
    //   20: astore 8
    //   22: aconst_null
    //   23: astore 5
    //   25: aconst_null
    //   26: astore 6
    //   28: new 105	java/io/BufferedInputStream
    //   31: dup
    //   32: new 107	java/io/FileInputStream
    //   35: dup
    //   36: new 109	java/io/File
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: invokespecial 113	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: invokespecial 116	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: astore_0
    //   51: new 118	java/io/ByteArrayOutputStream
    //   54: dup
    //   55: sipush 1000
    //   58: invokespecial 120	java/io/ByteArrayOutputStream:<init>	(I)V
    //   61: astore 5
    //   63: sipush 1000
    //   66: newarray byte
    //   68: astore 6
    //   70: aload_0
    //   71: aload 6
    //   73: invokevirtual 124	java/io/BufferedInputStream:read	([B)I
    //   76: istore_3
    //   77: iload_3
    //   78: iconst_m1
    //   79: if_icmpne +45 -> 124
    //   82: aload 5
    //   84: invokevirtual 125	java/io/ByteArrayOutputStream:close	()V
    //   87: aload 5
    //   89: invokevirtual 129	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   92: astore 5
    //   94: aload 5
    //   96: aload 5
    //   98: arraylength
    //   99: invokestatic 133	com/tencent/mobileqq/pic/JpegCompressor:getQuality	([BI)F
    //   102: fstore_1
    //   103: aload_0
    //   104: ifnull +211 -> 315
    //   107: aload_0
    //   108: invokevirtual 134	java/io/BufferedInputStream:close	()V
    //   111: iload 4
    //   113: istore_3
    //   114: iload_3
    //   115: ifeq +7 -> 122
    //   118: iload_3
    //   119: invokestatic 103	com/tencent/mobileqq/pic/JpegError:throwException	(I)V
    //   122: fload_1
    //   123: freturn
    //   124: aload 5
    //   126: aload 6
    //   128: iconst_0
    //   129: iload_3
    //   130: invokevirtual 138	java/io/ByteArrayOutputStream:write	([BII)V
    //   133: goto -63 -> 70
    //   136: astore 6
    //   138: aload_0
    //   139: astore 5
    //   141: aload 6
    //   143: invokevirtual 139	java/io/FileNotFoundException:printStackTrace	()V
    //   146: iload 4
    //   148: istore_3
    //   149: fload_2
    //   150: fstore_1
    //   151: aload_0
    //   152: ifnull -38 -> 114
    //   155: aload_0
    //   156: invokevirtual 134	java/io/BufferedInputStream:close	()V
    //   159: iload 4
    //   161: istore_3
    //   162: fload_2
    //   163: fstore_1
    //   164: goto -50 -> 114
    //   167: astore_0
    //   168: iload 4
    //   170: istore_3
    //   171: fload_2
    //   172: fstore_1
    //   173: goto -59 -> 114
    //   176: astore 6
    //   178: aload 7
    //   180: astore_0
    //   181: aload_0
    //   182: astore 5
    //   184: aload 6
    //   186: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   189: iload 4
    //   191: istore_3
    //   192: fload_2
    //   193: fstore_1
    //   194: aload_0
    //   195: ifnull -81 -> 114
    //   198: aload_0
    //   199: invokevirtual 134	java/io/BufferedInputStream:close	()V
    //   202: iload 4
    //   204: istore_3
    //   205: fload_2
    //   206: fstore_1
    //   207: goto -93 -> 114
    //   210: astore_0
    //   211: iload 4
    //   213: istore_3
    //   214: fload_2
    //   215: fstore_1
    //   216: goto -102 -> 114
    //   219: astore_0
    //   220: aload 8
    //   222: astore_0
    //   223: bipush 52
    //   225: istore 4
    //   227: iload 4
    //   229: istore_3
    //   230: fload_2
    //   231: fstore_1
    //   232: aload_0
    //   233: ifnull -119 -> 114
    //   236: aload_0
    //   237: invokevirtual 134	java/io/BufferedInputStream:close	()V
    //   240: iload 4
    //   242: istore_3
    //   243: fload_2
    //   244: fstore_1
    //   245: goto -131 -> 114
    //   248: astore_0
    //   249: iload 4
    //   251: istore_3
    //   252: fload_2
    //   253: fstore_1
    //   254: goto -140 -> 114
    //   257: astore_0
    //   258: aload 5
    //   260: ifnull +8 -> 268
    //   263: aload 5
    //   265: invokevirtual 134	java/io/BufferedInputStream:close	()V
    //   268: aload_0
    //   269: athrow
    //   270: astore_0
    //   271: iload 4
    //   273: istore_3
    //   274: goto -160 -> 114
    //   277: astore 5
    //   279: goto -11 -> 268
    //   282: astore 6
    //   284: aload_0
    //   285: astore 5
    //   287: aload 6
    //   289: astore_0
    //   290: goto -32 -> 258
    //   293: astore 5
    //   295: goto -72 -> 223
    //   298: astore 6
    //   300: goto -119 -> 181
    //   303: astore 5
    //   305: aload 6
    //   307: astore_0
    //   308: aload 5
    //   310: astore 6
    //   312: goto -174 -> 138
    //   315: iload 4
    //   317: istore_3
    //   318: goto -204 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	paramString	String
    //   102	152	1	f1	float
    //   1	252	2	f2	float
    //   76	242	3	i	int
    //   14	302	4	j	int
    //   23	241	5	localObject1	Object
    //   277	1	5	localIOException1	IOException
    //   285	1	5	str	String
    //   293	1	5	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   303	6	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   26	101	6	arrayOfByte	byte[]
    //   136	6	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   176	9	6	localIOException2	IOException
    //   282	6	6	localObject2	Object
    //   298	8	6	localIOException3	IOException
    //   310	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   17	162	7	localObject3	Object
    //   20	201	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   51	70	136	java/io/FileNotFoundException
    //   70	77	136	java/io/FileNotFoundException
    //   82	103	136	java/io/FileNotFoundException
    //   124	133	136	java/io/FileNotFoundException
    //   155	159	167	java/io/IOException
    //   28	51	176	java/io/IOException
    //   198	202	210	java/io/IOException
    //   28	51	219	java/lang/UnsatisfiedLinkError
    //   236	240	248	java/io/IOException
    //   28	51	257	finally
    //   141	146	257	finally
    //   184	189	257	finally
    //   107	111	270	java/io/IOException
    //   263	268	277	java/io/IOException
    //   51	70	282	finally
    //   70	77	282	finally
    //   82	103	282	finally
    //   124	133	282	finally
    //   51	70	293	java/lang/UnsatisfiedLinkError
    //   70	77	293	java/lang/UnsatisfiedLinkError
    //   82	103	293	java/lang/UnsatisfiedLinkError
    //   124	133	293	java/lang/UnsatisfiedLinkError
    //   51	70	298	java/io/IOException
    //   70	77	298	java/io/IOException
    //   82	103	298	java/io/IOException
    //   124	133	298	java/io/IOException
    //   28	51	303	java/io/FileNotFoundException
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
    throws Exception
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
    throws Exception
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
      if (paramInt1 * paramInt2 * i > paramArrayOfByte1.length) {
        JpegError.throwException(4);
      }
      long l1 = 0L;
      try
      {
        long l2 = compressByteArray(this.nativePtr, paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramArrayOfByte2);
        l1 = l2;
        paramInt1 = (int)(0xFFFFFFFF & l1);
      }
      catch (UnsatisfiedLinkError paramArrayOfByte1)
      {
        for (;;)
        {
          paramInt1 = 52;
        }
      }
      if (paramInt1 != 0) {
        JpegError.throwException(paramInt1);
      }
      return (int)(l1 >> 32 & 0xFFFFFFFF);
      i = 4;
      continue;
      i = 1;
    }
  }
  
  public void compress(Bitmap paramBitmap)
    throws Exception
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
    throws Throwable
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
  
  private static class JpegDataDestImpl
    implements JpegDataDest
  {
    private FileOutputStream writer = null;
    
    public JpegDataDestImpl(String paramString)
    {
      paramString = new File(paramString);
      try
      {
        if (paramString.exists()) {
          paramString.delete();
        }
        paramString.createNewFile();
        this.writer = new FileOutputStream(paramString);
        return;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
      }
    }
    
    public void dataArrived(ByteBuffer paramByteBuffer, boolean paramBoolean, Object paramObject)
    {
      try
      {
        paramObject = new byte[paramByteBuffer.capacity()];
        paramByteBuffer.get(paramObject);
        this.writer.write(paramObject, 0, paramObject.length);
        if (!paramBoolean) {}
      }
      catch (Exception paramByteBuffer)
      {
        for (;;)
        {
          try
          {
            this.writer.close();
            return;
          }
          catch (IOException paramByteBuffer)
          {
            paramByteBuffer.printStackTrace();
          }
          paramByteBuffer = paramByteBuffer;
          paramByteBuffer.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.pic.JpegCompressor
 * JD-Core Version:    0.7.0.1
 */