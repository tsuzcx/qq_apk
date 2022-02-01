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
    int i = this.charsRead;
    this.readAheadLimit = (paramInt - i);
    this.markedAt = i;
    this.target.mark(paramInt);
  }
  
  public int read()
  {
    int i = this.charsRead;
    if (i >= this.maxCharsFromTargetReader) {
      return -1;
    }
    int j = this.markedAt;
    if ((j >= 0) && (i - j >= this.readAheadLimit)) {
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
        paramInt1 = i;
        if (i == 0) {
          paramInt1 = -1;
        }
        return paramInt1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.BoundedReader
 * JD-Core Version:    0.7.0.1
 */