package org.apache.commons.lang.text;

import java.io.Writer;

class StrBuilder$StrBuilderWriter
  extends Writer
{
  private final StrBuilder this$0;
  
  StrBuilder$StrBuilderWriter(StrBuilder paramStrBuilder)
  {
    this.this$0 = paramStrBuilder;
  }
  
  public void close() {}
  
  public void flush() {}
  
  public void write(int paramInt)
  {
    this.this$0.append((char)paramInt);
  }
  
  public void write(String paramString)
  {
    this.this$0.append(paramString);
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
  {
    this.this$0.append(paramString, paramInt1, paramInt2);
  }
  
  public void write(char[] paramArrayOfChar)
  {
    this.this$0.append(paramArrayOfChar);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.this$0.append(paramArrayOfChar, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.text.StrBuilder.StrBuilderWriter
 * JD-Core Version:    0.7.0.1
 */