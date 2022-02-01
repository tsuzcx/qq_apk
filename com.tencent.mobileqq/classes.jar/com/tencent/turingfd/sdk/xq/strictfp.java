package com.tencent.turingfd.sdk.xq;

public class strictfp
{
  public String name = "";
  public int pid;
  public int rg;
  public int sg;
  public int uid;
  
  public strictfp(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4)
  {
    this.pid = paramInt1;
    this.rg = paramInt2;
    this.name = paramString1;
    this.uid = paramInt3;
    this.sg = paramInt4;
  }
  
  public String toString()
  {
    String str1 = String.format("% 6d", new Object[] { Integer.valueOf(this.pid) });
    String str2 = String.format("% 6d", new Object[] { Integer.valueOf(this.rg) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.strictfp
 * JD-Core Version:    0.7.0.1
 */