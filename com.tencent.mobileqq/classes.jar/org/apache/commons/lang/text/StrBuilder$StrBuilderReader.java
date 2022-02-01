package org.apache.commons.lang.text;

import java.io.Reader;

class StrBuilder$StrBuilderReader
  extends Reader
{
  private int mark;
  private int pos;
  private final StrBuilder this$0;
  
  StrBuilder$StrBuilderReader(StrBuilder paramStrBuilder)
  {
    this.this$0 = paramStrBuilder;
  }
  
  public void close() {}
  
  public void mark(int paramInt)
  {
    this.mark = this.pos;
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    if (!ready()) {
      return -1;
    }
    StrBuilder localStrBuilder = this.this$0;
    int i = this.pos;
    this.pos = (i + 1);
    return localStrBuilder.charAt(i);
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 <= paramArrayOfChar.length))
    {
      int i = paramInt1 + paramInt2;
      if ((i <= paramArrayOfChar.length) && (i >= 0))
      {
        if (paramInt2 == 0) {
          return 0;
        }
        if (this.pos >= this.this$0.size()) {
          return -1;
        }
        i = paramInt2;
        if (this.pos + paramInt2 > this.this$0.size()) {
          i = this.this$0.size() - this.pos;
        }
        StrBuilder localStrBuilder = this.this$0;
        paramInt2 = this.pos;
        localStrBuilder.getChars(paramInt2, paramInt2 + i, paramArrayOfChar, paramInt1);
        this.pos += i;
        return i;
      }
    }
    throw new IndexOutOfBoundsException();
  }
  
  public boolean ready()
  {
    return this.pos < this.this$0.size();
  }
  
  public void reset()
  {
    this.pos = this.mark;
  }
  
  public long skip(long paramLong)
  {
    long l = paramLong;
    if (this.pos + paramLong > this.this$0.size()) {
      l = this.this$0.size() - this.pos;
    }
    if (l < 0L) {
      return 0L;
    }
    this.pos = ((int)(this.pos + l));
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.text.StrBuilder.StrBuilderReader
 * JD-Core Version:    0.7.0.1
 */