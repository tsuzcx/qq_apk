package com.tencent.turingfd.sdk.xq;

public class Sculptor
  extends case
{
  public int Ab = 0;
  public String rb = "";
  public int ub = 0;
  public int vb = 0;
  public int wb = 0;
  public int xb = 0;
  public String yb = "";
  public String zb = "";
  
  public void a(byte parambyte)
  {
    parambyte.b(this.ub, 0);
    parambyte.b(this.vb, 1);
    parambyte.b(this.wb, 2);
    parambyte.b(this.xb, 3);
    String str = this.yb;
    if (str != null) {
      parambyte.b(str, 4);
    }
    str = this.zb;
    if (str != null) {
      parambyte.b(str, 5);
    }
    parambyte.b(this.Ab, 6);
    str = this.rb;
    if (str != null) {
      parambyte.b(str, 7);
    }
  }
  
  public void a(try paramtry)
  {
    this.ub = paramtry.a(this.ub, 0, true);
    this.vb = paramtry.a(this.vb, 1, false);
    this.wb = paramtry.a(this.wb, 2, false);
    this.xb = paramtry.a(this.xb, 3, false);
    this.yb = paramtry.a(4, false);
    this.zb = paramtry.a(5, false);
    this.Ab = paramtry.a(this.Ab, 6, false);
    this.rb = paramtry.a(7, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Sculptor)) {
      return false;
    }
    paramObject = (Sculptor)paramObject;
    return (char.equals(this.ub, paramObject.ub)) && (char.equals(this.vb, paramObject.vb)) && (char.equals(this.wb, paramObject.wb)) && (char.equals(this.xb, paramObject.xb)) && (char.equals(this.yb, paramObject.yb)) && (char.equals(this.zb, paramObject.zb)) && (char.equals(this.Ab, paramObject.Ab)) && (char.equals(this.rb, paramObject.rb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Sculptor
 * JD-Core Version:    0.7.0.1
 */