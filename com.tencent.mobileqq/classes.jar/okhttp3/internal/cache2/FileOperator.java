package okhttp3.internal.cache2;

import java.nio.channels.FileChannel;
import okio.Buffer;

final class FileOperator
{
  private final FileChannel fileChannel;
  
  FileOperator(FileChannel paramFileChannel)
  {
    this.fileChannel = paramFileChannel;
  }
  
  public void read(long paramLong1, Buffer paramBuffer, long paramLong2)
  {
    if (paramLong2 < 0L) {
      throw new IndexOutOfBoundsException();
    }
    for (;;)
    {
      if (paramLong2 > 0L)
      {
        long l = this.fileChannel.transferTo(paramLong1, paramLong2, paramBuffer);
        paramLong1 += l;
        paramLong2 -= l;
      }
      else
      {
        return;
      }
    }
  }
  
  public void write(long paramLong1, Buffer paramBuffer, long paramLong2)
  {
    if ((paramLong2 < 0L) || (paramLong2 > paramBuffer.size())) {
      throw new IndexOutOfBoundsException();
    }
    for (;;)
    {
      if (paramLong2 > 0L)
      {
        long l = this.fileChannel.transferFrom(paramBuffer, paramLong1, paramLong2);
        paramLong1 += l;
        paramLong2 -= l;
      }
      else
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okhttp3.internal.cache2.FileOperator
 * JD-Core Version:    0.7.0.1
 */