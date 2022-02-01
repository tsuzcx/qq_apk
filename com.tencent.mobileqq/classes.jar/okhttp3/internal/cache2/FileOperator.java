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
    if (paramLong2 >= 0L)
    {
      while (paramLong2 > 0L)
      {
        long l = this.fileChannel.transferTo(paramLong1, paramLong2, paramBuffer);
        paramLong1 += l;
        paramLong2 -= l;
      }
      return;
    }
    paramBuffer = new IndexOutOfBoundsException();
    for (;;)
    {
      throw paramBuffer;
    }
  }
  
  public void write(long paramLong1, Buffer paramBuffer, long paramLong2)
  {
    if ((paramLong2 >= 0L) && (paramLong2 <= paramBuffer.size()))
    {
      long l = paramLong2;
      paramLong2 = paramLong1;
      for (paramLong1 = l; paramLong1 > 0L; paramLong1 -= l)
      {
        l = this.fileChannel.transferFrom(paramBuffer, paramLong2, paramLong1);
        paramLong2 += l;
      }
      return;
    }
    paramBuffer = new IndexOutOfBoundsException();
    for (;;)
    {
      throw paramBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.internal.cache2.FileOperator
 * JD-Core Version:    0.7.0.1
 */