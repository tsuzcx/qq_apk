package com.tencent.turingfd.sdk.xq;

public final class Sagittarius
  extends case
{
  public String Zb = "";
  public String md = "";
  
  public void a(byte parambyte)
  {
    String str = this.Zb;
    if (str != null) {
      parambyte.b(str, 0);
    }
    str = this.md;
    if (str != null) {
      parambyte.b(str, 1);
    }
  }
  
  public void a(try paramtry)
  {
    this.Zb = paramtry.a(0, false);
    this.md = paramtry.a(1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Sagittarius
 * JD-Core Version:    0.7.0.1
 */