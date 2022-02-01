package com.tencent.turingfd.sdk.xq;

public class package
{
  public int Yf;
  public int Zf;
  public String name = "";
  public int pid;
  public int uid;
  
  public package(int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2, int paramInt4)
  {
    this.pid = paramInt1;
    this.Yf = paramInt2;
    this.name = paramString1;
    this.uid = paramInt3;
    this.Zf = paramInt4;
  }
  
  public String toString()
  {
    String str1 = String.format("% 6d", new Object[] { Integer.valueOf(this.pid) });
    String str2 = String.format("% 6d", new Object[] { Integer.valueOf(this.Yf) });
    String str3 = String.format("% 6d", new Object[] { Integer.valueOf(this.uid) });
    return "" + str1 + "    " + str2 + "    " + str3 + "    " + this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.package
 * JD-Core Version:    0.7.0.1
 */