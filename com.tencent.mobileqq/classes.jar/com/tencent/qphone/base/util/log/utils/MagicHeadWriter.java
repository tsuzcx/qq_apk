package com.tencent.qphone.base.util.log.utils;

import java.nio.MappedByteBuffer;

public class MagicHeadWriter
{
  public static final int MAGIC_ENCRYPT_CODE = -20190711;
  public static final int MAGIC_HEAD_COMPRESS = -21937241;
  public static final int MAGIC_HEAD_LENGTH = 8;
  public static final int MAGIC_HEAD_NO_COMPRESS = -18239;
  public static final byte MAGIC_VERSION_CODE = 1;
  private static final String TAG = "MagicHeadWriter";
  MappedByteBuffer cacheFileMmapBuffer;
  final boolean compress;
  
  public MagicHeadWriter(MappedByteBuffer paramMappedByteBuffer, boolean paramBoolean)
  {
    this.compress = paramBoolean;
    this.cacheFileMmapBuffer = paramMappedByteBuffer;
  }
  
  public void prepareToWrite(boolean paramBoolean)
  {
    this.cacheFileMmapBuffer.flip();
    if (!paramBoolean) {
      this.cacheFileMmapBuffer.position(8);
    }
  }
  
  public boolean prepareToWrite()
  {
    MappedByteBuffer localMappedByteBuffer = this.cacheFileMmapBuffer;
    boolean bool = false;
    int i = localMappedByteBuffer.getInt(0);
    int j = this.cacheFileMmapBuffer.getInt(4);
    if ((j > 0) && (j < this.cacheFileMmapBuffer.capacity() - 8) && ((i == -21937241) || (i == -18239)))
    {
      this.cacheFileMmapBuffer.position(j + 8);
      if (i == -21937241) {
        bool = true;
      }
      prepareToWrite(bool);
      return true;
    }
    return false;
  }
  
  public void updateLength()
  {
    MappedByteBuffer localMappedByteBuffer = this.cacheFileMmapBuffer;
    int i;
    if (this.compress) {
      i = -21937241;
    } else {
      i = -18239;
    }
    localMappedByteBuffer.putInt(0, i);
    localMappedByteBuffer = this.cacheFileMmapBuffer;
    localMappedByteBuffer.putInt(4, localMappedByteBuffer.position() - 8);
  }
  
  public void writeInitLength()
  {
    MappedByteBuffer localMappedByteBuffer = this.cacheFileMmapBuffer;
    int i;
    if (this.compress) {
      i = -21937241;
    } else {
      i = -18239;
    }
    localMappedByteBuffer.putInt(i);
    localMappedByteBuffer = this.cacheFileMmapBuffer;
    localMappedByteBuffer.putInt(localMappedByteBuffer.position() - 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.utils.MagicHeadWriter
 * JD-Core Version:    0.7.0.1
 */