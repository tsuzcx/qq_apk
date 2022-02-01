package com.tencent.turingfd.sdk.xq;

public final class Avocado
  extends case
{
  public String Zc = "";
  public String _c = "";
  public String ad = "";
  public String bd = "";
  public int cd = 0;
  public String dd = "";
  public int ed = 0;
  public String za = "";
  
  public void a(byte parambyte)
  {
    String str = this.Zc;
    if (str != null) {
      parambyte.b(str, 0);
    }
    str = this._c;
    if (str != null) {
      parambyte.b(str, 1);
    }
    str = this.ad;
    if (str != null) {
      parambyte.b(str, 2);
    }
    str = this.bd;
    if (str != null) {
      parambyte.b(str, 3);
    }
    int i = this.cd;
    if (i != 0) {
      parambyte.b(i, 4);
    }
    str = this.dd;
    if (str != null) {
      parambyte.b(str, 5);
    }
    str = this.za;
    if (str != null) {
      parambyte.b(str, 6);
    }
    i = this.ed;
    if (i != 0) {
      parambyte.b(i, 7);
    }
  }
  
  public void a(try paramtry)
  {
    this.Zc = paramtry.a(0, false);
    this._c = paramtry.a(1, false);
    this.ad = paramtry.a(2, false);
    this.bd = paramtry.a(3, false);
    this.cd = paramtry.a(this.cd, 4, false);
    this.dd = paramtry.a(5, false);
    this.za = paramtry.a(6, false);
    this.ed = paramtry.a(this.ed, 7, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Avocado
 * JD-Core Version:    0.7.0.1
 */