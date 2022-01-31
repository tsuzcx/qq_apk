package com.tencent.upload.d;

public enum c
{
  private int i;
  private String j;
  private int k;
  
  private c(int paramInt1, String paramString, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramString;
    this.k = paramInt2;
  }
  
  public static c a(int paramInt)
  {
    c[] arrayOfc = values();
    int n = arrayOfc.length;
    int m = 0;
    while (m < n)
    {
      c localc = arrayOfc[m];
      if (localc.i == paramInt) {
        return localc;
      }
      m += 1;
    }
    return a;
  }
  
  public int a()
  {
    return this.i;
  }
  
  public String b()
  {
    return this.j;
  }
  
  public int c()
  {
    return this.k;
  }
  
  public String toString()
  {
    return "[" + this.i + "," + this.j + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.d.c
 * JD-Core Version:    0.7.0.1
 */