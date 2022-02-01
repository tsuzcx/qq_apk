package com.tencent.mobileqq.msf.sdk.b;

import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;

public class e$b
  extends e.a
{
  public static final String b = "msf.sdk.event_bindCost";
  private long c = 0L;
  private short d = 0;
  
  public static b b()
  {
    return e.b.a.a();
  }
  
  private void b(long paramLong)
  {
    a("proxy", String.valueOf(MsfServiceSdk.isUseNewProxy));
    a("cost", String.valueOf(paramLong));
    a("count", String.valueOf(this.d));
    a("msf.sdk.event_bindCost", true, paramLong, 0L, true);
  }
  
  public void a(long paramLong)
  {
    if (this.c == 0L) {
      this.c = paramLong;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.c > 0L) && (paramBoolean)) {
      b(System.currentTimeMillis() - this.c);
    }
    this.c = 0L;
    this.d = 0;
  }
  
  public void c()
  {
    this.d = ((short)(this.d + 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.b.e.b
 * JD-Core Version:    0.7.0.1
 */