package com.tencent.mobileqq.troop.shortcutbar;

public class ShortcutBarInfo
{
  private long a;
  private String b;
  private String c;
  private int d;
  private boolean e;
  
  public ShortcutBarInfo()
  {
    this.e = true;
  }
  
  public ShortcutBarInfo(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    this.a = paramLong;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt;
    this.e = true;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public long b()
  {
    return 0L;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public int c()
  {
    return 0;
  }
  
  public long d()
  {
    return this.a;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public String f()
  {
    return this.c;
  }
  
  public int g()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo
 * JD-Core Version:    0.7.0.1
 */