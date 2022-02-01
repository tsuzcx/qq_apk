package org.apache.commons.io.output;

import java.io.FilterWriter;
import java.io.Writer;

public class ChunkedWriter
  extends FilterWriter
{
  private static final int DEFAULT_CHUNK_SIZE = 4096;
  private final int chunkSize;
  
  public ChunkedWriter(Writer paramWriter)
  {
    this(paramWriter, 4096);
  }
  
  public ChunkedWriter(Writer paramWriter, int paramInt)
  {
    super(paramWriter);
    if (paramInt > 0)
    {
      this.chunkSize = paramInt;
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    while (paramInt2 > 0)
    {
      int i = Math.min(paramInt2, this.chunkSize);
      this.out.write(paramArrayOfChar, paramInt1, i);
      paramInt2 -= i;
      paramInt1 += i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.output.ChunkedWriter
 * JD-Core Version:    0.7.0.1
 */