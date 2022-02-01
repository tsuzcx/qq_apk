package com.tencent.mobileqq.fts.v2.tokenizer;

public final class Token
{
  String a;
  int b;
  int c;
  String d = "word";
  private int e = 1;
  
  public Token(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.a = paramString1;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramString2;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final String d()
  {
    return this.d;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuffer.append(localStringBuilder.toString());
    if (!this.d.equals("word"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(",type=");
      localStringBuilder.append(this.d);
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (this.e != 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(",posIncr=");
      localStringBuilder.append(this.e);
      localStringBuffer.append(localStringBuilder.toString());
    }
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v2.tokenizer.Token
 * JD-Core Version:    0.7.0.1
 */