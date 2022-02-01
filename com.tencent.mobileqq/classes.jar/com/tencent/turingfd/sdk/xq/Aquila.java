package com.tencent.turingfd.sdk.xq;

public class Aquila
{
  public int a;
  public int b;
  public int c;
  public String d = "";
  public int e;
  
  public Aquila(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.d = paramString1;
    this.c = paramInt3;
    this.e = paramInt4;
  }
  
  public String toString()
  {
    String str1 = String.format("% 6d", new Object[] { Integer.valueOf(this.a) });
    String str2 = String.format("% 6d", new Object[] { Integer.valueOf(this.b) });
    String str3 = String.format("% 6d", new Object[] { Integer.valueOf(this.c) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(str1);
    localStringBuilder.append("    ");
    localStringBuilder.append(str2);
    localStringBuilder.append("    ");
    localStringBuilder.append(str3);
    localStringBuilder.append("    ");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Aquila
 * JD-Core Version:    0.7.0.1
 */