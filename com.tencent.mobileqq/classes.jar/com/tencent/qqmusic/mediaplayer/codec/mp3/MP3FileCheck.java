package com.tencent.qqmusic.mediaplayer.codec.mp3;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;

public class MP3FileCheck
{
  private static final String TAG = "MP3FileCheck";
  private byte[] buf = new byte[8192];
  private int endPos;
  private boolean eof;
  private int frameCount;
  private boolean hasCheck = false;
  private boolean hasID3V2 = false;
  private MP3Header header = new MP3Header();
  private int headerMask;
  private boolean isMP3 = false;
  private String mFilePath = null;
  private int mID3V2Size = -1;
  private RandomAccessFile mRandomAccessFile = null;
  private int pos;
  private int skipped;
  private boolean sync;
  
  public MP3FileCheck(String paramString)
  {
    this.mFilePath = paramString;
  }
  
  private boolean available(int paramInt1, int paramInt2)
  {
    if (((paramInt1 & paramInt2) == paramInt2) && ((paramInt1 >> 19 & 0x3) != 1) && ((paramInt1 >> 17 & 0x3) != 0))
    {
      paramInt2 = paramInt1 >> 12 & 0xF;
      if ((paramInt2 != 15) && (paramInt2 != 0) && ((paramInt1 >> 10 & 0x3) != 3)) {
        return true;
      }
    }
    return false;
  }
  
  private int byte2int(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return paramArrayOfByte[(paramInt + 3)] & 0xFF | i << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  private boolean checkAndSeekID3V2Tag()
  {
    Object localObject = new byte[10];
    int i = fillBuffer((byte[])localObject, 0, localObject.length);
    if (i <= 0) {
      return false;
    }
    if ((localObject[0] == 73) && (localObject[1] == 68) && (localObject[2] == 51))
    {
      this.mID3V2Size = ((localObject[6] << 21) + (localObject[7] << 14) + (localObject[8] << 7) + localObject[9]);
      this.hasID3V2 = true;
      seekTo(this.mID3V2Size - i);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("有ID3V2，ID3V2大小 = ");
      ((StringBuilder)localObject).append(this.mID3V2Size);
      Logger.d("MP3FileCheck", ((StringBuilder)localObject).toString());
    }
    else
    {
      closeFileStream();
      Logger.d("MP3FileCheck", "没有有ID3V2");
    }
    return this.hasID3V2;
  }
  
  private void closeFileStream()
  {
    RandomAccessFile localRandomAccessFile = this.mRandomAccessFile;
    if (localRandomAccessFile != null)
    {
      try
      {
        localRandomAccessFile.close();
      }
      catch (IOException localIOException)
      {
        Logger.e("MP3FileCheck", localIOException);
      }
      this.mRandomAccessFile = null;
    }
  }
  
  private int fillBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      if (this.mRandomAccessFile == null) {
        this.mRandomAccessFile = new RandomAccessFile(this.mFilePath, "r");
      }
      paramInt1 = this.mRandomAccessFile.read(paramArrayOfByte, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (Exception paramArrayOfByte)
    {
      label37:
      break label37;
    }
    return -1;
  }
  
  private boolean isMp3File()
  {
    if (!this.hasCheck) {
      fileCheck();
    }
    return this.isMP3;
  }
  
  public static boolean isMp3File(String paramString)
  {
    return new MP3FileCheck(paramString).isMp3File();
  }
  
  private void nextFrameHeader()
  {
    int i = 0;
    while ((!this.eof) && (!syncFrame()))
    {
      int k = this.endPos;
      int j = this.pos;
      k -= j;
      if (k > 0)
      {
        byte[] arrayOfByte = this.buf;
        System.arraycopy(arrayOfByte, j, arrayOfByte, 0, k);
      }
      this.endPos = (fillBuffer(this.buf, k, this.pos) + k);
      j = i;
      if (this.endPos > k)
      {
        j = i + this.pos;
        i = j;
        if (j <= 65536) {}
      }
      else
      {
        this.eof = true;
        i = j;
      }
      this.pos = 0;
    }
  }
  
  private void seekTo(int paramInt)
  {
    try
    {
      this.mRandomAccessFile.seek(paramInt);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("MP3FileCheck", localException);
    }
  }
  
  private boolean syncFrame()
  {
    int j = this.pos;
    if (this.endPos - j <= 4) {
      return false;
    }
    int i = byte2int(this.buf, j);
    this.pos += 4;
    System.out.println(this.frameCount);
    while (!this.eof)
    {
      while (!available(i, this.headerMask))
      {
        arrayOfByte = this.buf;
        k = this.pos;
        this.pos = (k + 1);
        i = i << 8 | arrayOfByte[k] & 0xFF;
        k = this.pos;
        if (k == this.endPos)
        {
          i = this.skipped;
          k -= 4;
          this.pos = k;
          this.skipped = (i + (k - j));
          return false;
        }
      }
      int k = this.pos;
      if (k > j + 4)
      {
        this.sync = false;
        this.skipped += k - 4 - j;
      }
      this.header.decode(i);
      int m = this.header.getFrameSize();
      k = this.pos;
      int n = this.endPos;
      if (k + m > n + 4)
      {
        i = this.skipped;
        k -= 4;
        this.pos = k;
        this.skipped = (i + (k - j));
        return false;
      }
      if (this.sync) {
        break;
      }
      if (k + m > n)
      {
        i = this.skipped;
        k -= 4;
        this.pos = k;
        this.skipped = (i + (k - j));
        return false;
      }
      n = 0x180000 & i | 0xFFE00000 | 0x60000 & i | i & 0xC00;
      if (available(byte2int(this.buf, k - 4 + m), n))
      {
        if (this.headerMask == -2097152) {
          this.headerMask = n;
        }
        this.sync = true;
        break;
      }
      byte[] arrayOfByte = this.buf;
      k = this.pos;
      this.pos = (k + 1);
      i = i << 8 | arrayOfByte[k] & 0xFF;
    }
    if (this.header.isProtected()) {
      this.pos += 2;
    }
    this.frameCount += 1;
    i = this.skipped;
    if ((i > 0) || ((i == 0) && (this.sync)))
    {
      this.isMP3 = true;
      this.skipped = 0;
    }
    return true;
  }
  
  /* Error */
  public void fileCheck()
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: putfield 35	com/tencent/qqmusic/mediaplayer/codec/mp3/MP3FileCheck:hasCheck	Z
    //   5: aload_0
    //   6: invokespecial 180	com/tencent/qqmusic/mediaplayer/codec/mp3/MP3FileCheck:checkAndSeekID3V2Tag	()Z
    //   9: pop
    //   10: aload_0
    //   11: ldc 174
    //   13: putfield 159	com/tencent/qqmusic/mediaplayer/codec/mp3/MP3FileCheck:headerMask	I
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 165	com/tencent/qqmusic/mediaplayer/codec/mp3/MP3FileCheck:sync	Z
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 126	com/tencent/qqmusic/mediaplayer/codec/mp3/MP3FileCheck:eof	Z
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield 152	com/tencent/qqmusic/mediaplayer/codec/mp3/MP3FileCheck:frameCount	I
    //   31: aload_0
    //   32: getfield 50	com/tencent/qqmusic/mediaplayer/codec/mp3/MP3FileCheck:buf	[B
    //   35: arraylength
    //   36: istore_1
    //   37: aload_0
    //   38: iload_1
    //   39: putfield 133	com/tencent/qqmusic/mediaplayer/codec/mp3/MP3FileCheck:pos	I
    //   42: aload_0
    //   43: iload_1
    //   44: putfield 131	com/tencent/qqmusic/mediaplayer/codec/mp3/MP3FileCheck:endPos	I
    //   47: aload_0
    //   48: getfield 48	com/tencent/qqmusic/mediaplayer/codec/mp3/MP3FileCheck:header	Lcom/tencent/qqmusic/mediaplayer/codec/mp3/MP3Header;
    //   51: invokevirtual 183	com/tencent/qqmusic/mediaplayer/codec/mp3/MP3Header:initialize	()V
    //   54: aload_0
    //   55: invokespecial 185	com/tencent/qqmusic/mediaplayer/codec/mp3/MP3FileCheck:nextFrameHeader	()V
    //   58: aload_0
    //   59: getfield 39	com/tencent/qqmusic/mediaplayer/codec/mp3/MP3FileCheck:mRandomAccessFile	Ljava/io/RandomAccessFile;
    //   62: astore_2
    //   63: aload_2
    //   64: ifnull +40 -> 104
    //   67: aload_2
    //   68: invokevirtual 101	java/io/RandomAccessFile:close	()V
    //   71: return
    //   72: astore_2
    //   73: goto +32 -> 105
    //   76: astore_2
    //   77: ldc 8
    //   79: aload_2
    //   80: invokestatic 105	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   83: aload_0
    //   84: getfield 39	com/tencent/qqmusic/mediaplayer/codec/mp3/MP3FileCheck:mRandomAccessFile	Ljava/io/RandomAccessFile;
    //   87: astore_2
    //   88: aload_2
    //   89: ifnull +15 -> 104
    //   92: aload_2
    //   93: invokevirtual 101	java/io/RandomAccessFile:close	()V
    //   96: return
    //   97: astore_2
    //   98: ldc 8
    //   100: aload_2
    //   101: invokestatic 105	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   104: return
    //   105: aload_0
    //   106: getfield 39	com/tencent/qqmusic/mediaplayer/codec/mp3/MP3FileCheck:mRandomAccessFile	Ljava/io/RandomAccessFile;
    //   109: astore_3
    //   110: aload_3
    //   111: ifnull +17 -> 128
    //   114: aload_3
    //   115: invokevirtual 101	java/io/RandomAccessFile:close	()V
    //   118: goto +10 -> 128
    //   121: astore_3
    //   122: ldc 8
    //   124: aload_3
    //   125: invokestatic 105	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_2
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	MP3FileCheck
    //   36	8	1	i	int
    //   62	6	2	localRandomAccessFile1	RandomAccessFile
    //   72	1	2	localObject	Object
    //   76	4	2	localException1	Exception
    //   87	6	2	localRandomAccessFile2	RandomAccessFile
    //   97	32	2	localException2	Exception
    //   109	6	3	localRandomAccessFile3	RandomAccessFile
    //   121	4	3	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   0	58	72	finally
    //   77	83	72	finally
    //   0	58	76	java/lang/Exception
    //   67	71	97	java/lang/Exception
    //   92	96	97	java/lang/Exception
    //   114	118	121	java/lang/Exception
  }
  
  public int getFrameSize()
  {
    MP3Header localMP3Header = this.header;
    if (localMP3Header != null) {
      return localMP3Header.getFrameSize();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.mp3.MP3FileCheck
 * JD-Core Version:    0.7.0.1
 */