package com.tencent.turingfd.sdk.xq;

public class Virgo
  extends case
{
  public int ec = 0;
  
  public void a(byte parambyte)
  {
    parambyte.b(this.ec, 0);
  }
  
  public void a(try paramtry)
  {
    this.ec = paramtry.a(this.ec, 0, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Virgo)) {
      return false;
    }
    paramObject = (Virgo)paramObject;
    return char.equals(this.ec, paramObject.ec);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Virgo
 * JD-Core Version:    0.7.0.1
 */