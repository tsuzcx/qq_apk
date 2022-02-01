package org.apache.commons.lang.text;

import java.util.List;

class StrBuilder$StrBuilderTokenizer
  extends StrTokenizer
{
  private final StrBuilder this$0;
  
  StrBuilder$StrBuilderTokenizer(StrBuilder paramStrBuilder)
  {
    this.this$0 = paramStrBuilder;
  }
  
  public String getContent()
  {
    String str2 = super.getContent();
    String str1 = str2;
    if (str2 == null) {
      str1 = this.this$0.toString();
    }
    return str1;
  }
  
  protected List tokenize(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfChar == null) {
      return super.tokenize(this.this$0.buffer, 0, this.this$0.size());
    }
    return super.tokenize(paramArrayOfChar, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.text.StrBuilder.StrBuilderTokenizer
 * JD-Core Version:    0.7.0.1
 */