package com.tencent.rmonitor.sla;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class AttaParam
{
  public final String a = "08e00055686";
  public final String b = "8666841551";
  public final String c = "android";
  public final String d;
  public long e = 0L;
  public int f = 1;
  public int g = 0;
  public long h = System.currentTimeMillis();
  public int i = 1;
  private final String[] j = new String[10];
  
  public AttaParam(@NotNull String paramString)
  {
    this.d = paramString;
    Arrays.fill(this.j, null);
  }
  
  public String a(int paramInt)
  {
    if (paramInt >= 0)
    {
      String[] arrayOfString = this.j;
      if (paramInt < arrayOfString.length) {
        return arrayOfString[paramInt];
      }
    }
    return null;
  }
  
  public String a(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > paramInt) {
        str = paramString.substring(0, paramInt);
      }
    }
    return str;
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt >= 0) && (paramInt < this.j.length))
    {
      int k;
      if (paramInt <= 6) {
        k = 256;
      } else {
        k = 40960;
      }
      paramString = a(paramString, k);
      this.j[paramInt] = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.sla.AttaParam
 * JD-Core Version:    0.7.0.1
 */