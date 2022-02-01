package com.tencent.turingfd.sdk.xq;

public final class Bergamot
  extends case
{
  public String dc = "";
  public String rd = "";
  
  public void a(byte parambyte)
  {
    String str = this.dc;
    if (str != null) {
      parambyte.b(str, 0);
    }
    str = this.rd;
    if (str != null) {
      parambyte.b(str, 1);
    }
  }
  
  public void a(try paramtry)
  {
    this.dc = paramtry.a(0, false);
    this.rd = paramtry.a(1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Bergamot
 * JD-Core Version:    0.7.0.1
 */