package com.tencent.turingfd.sdk.xq;

public class Serpens
  extends case
{
  public int Ab = 0;
  public String rb = "";
  public int ub = 0;
  public int vb = 0;
  public String yb = "";
  public String zb = "";
  
  public void a(byte parambyte)
  {
    parambyte.b(this.ub, 0);
    parambyte.b(this.vb, 1);
    String str = this.yb;
    if (str != null) {
      parambyte.b(str, 2);
    }
    str = this.zb;
    if (str != null) {
      parambyte.b(str, 3);
    }
    parambyte.b(this.Ab, 4);
    str = this.rb;
    if (str != null) {
      parambyte.b(str, 5);
    }
  }
  
  public void a(try paramtry)
  {
    this.ub = paramtry.a(this.ub, 0, true);
    this.vb = paramtry.a(this.vb, 1, false);
    this.yb = paramtry.a(2, false);
    this.zb = paramtry.a(3, false);
    this.Ab = paramtry.a(this.Ab, 4, false);
    this.rb = paramtry.a(5, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Serpens)) {
      return false;
    }
    paramObject = (Serpens)paramObject;
    return (char.equals(this.ub, paramObject.ub)) && (char.equals(this.vb, paramObject.vb)) && (char.equals(this.yb, paramObject.yb)) && (char.equals(this.zb, paramObject.zb)) && (char.equals(this.Ab, paramObject.Ab)) && (char.equals(this.rb, paramObject.rb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Serpens
 * JD-Core Version:    0.7.0.1
 */