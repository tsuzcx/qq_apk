package com.tencent.turingfd.sdk.xq;

public class Leo
  extends case
{
  public int _b = 0;
  
  public void a(byte parambyte)
  {
    parambyte.a(this._b, 0);
  }
  
  public void a(try paramtry)
  {
    this._b = paramtry.a(this._b, 0, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (!(paramObject instanceof Leo));
    paramObject = (Leo)paramObject;
    return char.equals(this._b, paramObject._b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Leo
 * JD-Core Version:    0.7.0.1
 */