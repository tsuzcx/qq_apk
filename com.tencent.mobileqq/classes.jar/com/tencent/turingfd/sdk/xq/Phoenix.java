package com.tencent.turingfd.sdk.xq;

public class Phoenix
  extends case
{
  public int _b = 0;
  public int jd = 0;
  public int kd = 0;
  
  public void a(byte parambyte)
  {
    parambyte.a(this._b, 0);
    parambyte.a(this.jd, 1);
    parambyte.a(this.kd, 2);
  }
  
  public void a(try paramtry)
  {
    this._b = paramtry.a(this._b, 0, false);
    this.jd = paramtry.a(this.jd, 1, false);
    this.kd = paramtry.a(this.kd, 2, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof Phoenix)) {
        return false;
      }
      paramObject = (Phoenix)paramObject;
    } while ((char.equals(this._b, paramObject._b)) && (char.equals(this.jd, paramObject.jd)) && (char.equals(this.kd, paramObject.kd)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Phoenix
 * JD-Core Version:    0.7.0.1
 */