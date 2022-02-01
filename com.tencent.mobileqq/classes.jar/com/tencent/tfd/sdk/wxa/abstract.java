package com.tencent.tfd.sdk.wxa;

public class abstract
{
  public int Jc;
  public int Kc;
  public String name = "";
  public int pid;
  public int uid;
  
  public abstract(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4)
  {
    this.pid = paramInt1;
    this.Jc = paramInt2;
    this.name = paramString1;
    this.uid = paramInt3;
    this.Kc = paramInt4;
  }
  
  public String toString()
  {
    String str1 = String.format("% 6d", new Object[] { Integer.valueOf(this.pid) });
    String str2 = String.format("% 6d", new Object[] { Integer.valueOf(this.Jc) });
    String str3 = String.format("% 6d", new Object[] { Integer.valueOf(this.uid) });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(str1);
    localStringBuilder.append("    ");
    localStringBuilder.append(str2);
    localStringBuilder.append("    ");
    localStringBuilder.append(str3);
    localStringBuilder.append("    ");
    localStringBuilder.append(this.name);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.abstract
 * JD-Core Version:    0.7.0.1
 */