package com.tencent.turingfd.sdk.xq;

public final class Octans
  extends case
{
  public String Aa = "";
  public int Ba = 0;
  public String Ca = "";
  public String Da = "";
  public String metaData = "";
  public String version = "";
  public String xa = "";
  public String ya = "";
  
  public void a(byte parambyte)
  {
    parambyte.b(this.Aa, 0);
    String str = this.metaData;
    if (str != null) {
      parambyte.b(str, 1);
    }
    parambyte.b(this.ya, 2);
    parambyte.b(this.Ba, 3);
    parambyte.b(this.version, 4);
    parambyte.b(this.xa, 5);
    str = this.Ca;
    if (str != null) {
      parambyte.b(str, 6);
    }
    str = this.Da;
    if (str != null) {
      parambyte.b(str, 7);
    }
  }
  
  public void a(try paramtry)
  {
    this.Aa = paramtry.a(0, true);
    this.metaData = paramtry.a(1, false);
    this.ya = paramtry.a(2, true);
    this.Ba = paramtry.a(this.Ba, 3, true);
    this.version = paramtry.a(4, true);
    this.xa = paramtry.a(5, true);
    this.Ca = paramtry.a(6, false);
    this.Da = paramtry.a(7, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Octans
 * JD-Core Version:    0.7.0.1
 */