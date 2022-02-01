package com.tencent.turingfd.sdk.xq;

public class Banana
  extends case
{
  public int ec = 0;
  public int od = 0;
  public int pd = 0;
  
  public void a(byte parambyte)
  {
    parambyte.b(this.ec, 0);
    parambyte.b(this.od, 1);
    parambyte.b(this.pd, 2);
  }
  
  public void a(try paramtry)
  {
    this.ec = paramtry.a(this.ec, 0, false);
    this.od = paramtry.a(this.od, 1, false);
    this.pd = paramtry.a(this.pd, 2, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Banana)) {
      return false;
    }
    paramObject = (Banana)paramObject;
    return (char.equals(this.ec, paramObject.ec)) && (char.equals(this.od, paramObject.od)) && (char.equals(this.pd, paramObject.pd));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Banana
 * JD-Core Version:    0.7.0.1
 */