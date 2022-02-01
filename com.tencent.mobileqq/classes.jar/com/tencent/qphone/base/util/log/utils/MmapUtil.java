package com.tencent.qphone.base.util.log.utils;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class MmapUtil
{
  public static MappedByteBuffer getMmapFileByPath(String paramString, int paramInt)
  {
    return new RandomAccessFile(paramString, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.utils.MmapUtil
 * JD-Core Version:    0.7.0.1
 */