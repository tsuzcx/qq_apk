package org.apache.commons.io.input;

import java.io.Reader;
import java.io.Serializable;

public class CharSequenceReader
  extends Reader
  implements Serializable
{
  private static final long serialVersionUID = 3724187752191401220L;
  private final CharSequence charSequence;
  private int idx;
  private int mark;
  
  public CharSequenceReader(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      paramCharSequence = "";
    }
    this.charSequence = paramCharSequence;
  }
  
  public void close()
  {
    this.idx = 0;
    this.mark = 0;
  }
  
  public void mark(int paramInt)
  {
    this.mark = this.idx;
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    if (this.idx >= this.charSequence.length()) {
      return -1;
    }
    CharSequence localCharSequence = this.charSequence;
    int i = this.idx;
    this.idx = (i + 1);
    return localCharSequence.charAt(i);
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.idx >= this.charSequence.length()) {
      return -1;
    }
    if (paramArrayOfChar != null)
    {
      if ((paramInt2 >= 0) && (paramInt1 >= 0) && (paramInt1 + paramInt2 <= paramArrayOfChar.length))
      {
        int i = 0;
        int j = 0;
        while (i < paramInt2)
        {
          int k = read();
          if (k == -1) {
            return j;
          }
          paramArrayOfChar[(paramInt1 + i)] = ((char)k);
          j += 1;
          i += 1;
        }
        return j;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Array Size=");
      localStringBuilder.append(paramArrayOfChar.length);
      localStringBuilder.append(", offset=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", length=");
      localStringBuilder.append(paramInt2);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    paramArrayOfChar = new NullPointerException("Character array is missing");
    for (;;)
    {
      throw paramArrayOfChar;
    }
  }
  
  public void reset()
  {
    this.idx = this.mark;
  }
  
  public long skip(long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (this.idx >= this.charSequence.length()) {
        return -1L;
      }
      int i = (int)Math.min(this.charSequence.length(), this.idx + paramLong);
      int j = this.idx;
      this.idx = i;
      return i - j;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Number of characters to skip is less than zero: ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public String toString()
  {
    return this.charSequence.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.CharSequenceReader
 * JD-Core Version:    0.7.0.1
 */