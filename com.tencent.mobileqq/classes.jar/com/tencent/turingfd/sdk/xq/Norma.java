package com.tencent.turingfd.sdk.xq;

public final class Norma
  extends case
{
  public int va = 0;
  public String wa = "";
  public String xa = "";
  public String ya = "";
  public int za = 0;
  
  public void a(byte parambyte)
  {
    parambyte.b(this.va, 0);
    parambyte.b(this.wa, 1);
    parambyte.b(this.xa, 2);
    parambyte.b(this.ya, 3);
    parambyte.b(this.za, 4);
  }
  
  public void a(try paramtry)
  {
    this.va = paramtry.a(this.va, 0, true);
    this.wa = paramtry.a(1, true);
    this.xa = paramtry.a(2, true);
    this.ya = paramtry.a(3, true);
    this.za = paramtry.a(this.za, 4, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Norma
 * JD-Core Version:    0.7.0.1
 */