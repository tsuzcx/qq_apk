package com.tencent.turingfd.sdk.xq;

public final class Pegasus
  extends case
{
  public String Uc = "";
  public String Vc = "";
  public String Wc = "";
  public String Xc = "";
  public int Yc = 0;
  public String Zc = "";
  public int _c = 0;
  public String ua = "";
  
  public void a(byte parambyte)
  {
    String str = this.Uc;
    if (str != null) {
      parambyte.b(str, 0);
    }
    str = this.Vc;
    if (str != null) {
      parambyte.b(str, 1);
    }
    str = this.Wc;
    if (str != null) {
      parambyte.b(str, 2);
    }
    str = this.Xc;
    if (str != null) {
      parambyte.b(str, 3);
    }
    int i = this.Yc;
    if (i != 0) {
      parambyte.a(i, 4);
    }
    str = this.Zc;
    if (str != null) {
      parambyte.b(str, 5);
    }
    str = this.ua;
    if (str != null) {
      parambyte.b(str, 6);
    }
    i = this._c;
    if (i != 0) {
      parambyte.a(i, 7);
    }
  }
  
  public void a(try paramtry)
  {
    this.Uc = paramtry.a(0, false);
    this.Vc = paramtry.a(1, false);
    this.Wc = paramtry.a(2, false);
    this.Xc = paramtry.a(3, false);
    this.Yc = paramtry.a(this.Yc, 4, false);
    this.Zc = paramtry.a(5, false);
    this.ua = paramtry.a(6, false);
    this._c = paramtry.a(this._c, 7, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Pegasus
 * JD-Core Version:    0.7.0.1
 */