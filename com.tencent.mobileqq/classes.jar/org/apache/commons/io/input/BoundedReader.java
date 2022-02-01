package org.apache.commons.io.input;

import java.io.Reader;

public class BoundedReader
  extends Reader
{
  private static final int INVALID = -1;
  private int charsRead = 0;
  private int markedAt = -1;
  private final int maxCharsFromTargetReader;
  private int readAheadLimit;
  private final Reader target;
  
  public BoundedReader(Reader paramReader, int paramInt)
  {
    this.target = paramReader;
    this.maxCharsFromTargetReader = paramInt;
  }
  
  public void close()
  {
    this.target.close();
  }
  
  public void mark(int paramInt)
  {
    this.readAheadLimit = (paramInt - this.charsRead);
    this.markedAt = this.charsRead;
    this.target.mark(paramInt);
  }
  
  public int read()
  {
    if (this.charsRead >= this.maxCharsFromTargetReader) {}
    while ((this.markedAt >= 0) && (this.charsRead - this.markedAt >= this.readAheadLimit)) {
      return -1;
    }
    this.charsRead += 1;
    return this.target.read();
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = read();
      if (j == -1)
      {
        if (i == 0) {
          return -1;
        }
        return i;
      }
      paramArrayOfChar[(paramInt1 + i)] = ((char)j);
      i += 1;
    }
    return paramInt2;
  }
  
  public void reset()
  {
    this.charsRead = this.markedAt;
    this.target.reset();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.input.BoundedReader
 * JD-Core Version:    0.7.0.1
 */