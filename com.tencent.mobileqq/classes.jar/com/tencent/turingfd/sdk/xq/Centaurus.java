package com.tencent.turingfd.sdk.xq;

public final class Centaurus
  extends case
{
  public String metaData = "";
  public String sa = "";
  public String ta = "";
  public String va = "";
  public String version = "";
  public int wa = 0;
  public String xa = "";
  public String ya = "";
  
  public void a(byte parambyte)
  {
    parambyte.b(this.va, 0);
    String str = this.metaData;
    if (str != null) {
      parambyte.b(str, 1);
    }
    parambyte.b(this.ta, 2);
    parambyte.a(this.wa, 3);
    parambyte.b(this.version, 4);
    parambyte.b(this.sa, 5);
    str = this.xa;
    if (str != null) {
      parambyte.b(str, 6);
    }
    str = this.ya;
    if (str != null) {
      parambyte.b(str, 7);
    }
  }
  
  public void a(try paramtry)
  {
    this.va = paramtry.a(0, true);
    this.metaData = paramtry.a(1, false);
    this.ta = paramtry.a(2, true);
    this.wa = paramtry.a(this.wa, 3, true);
    this.version = paramtry.a(4, true);
    this.sa = paramtry.a(5, true);
    this.xa = paramtry.a(6, false);
    this.ya = paramtry.a(7, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Centaurus
 * JD-Core Version:    0.7.0.1
 */