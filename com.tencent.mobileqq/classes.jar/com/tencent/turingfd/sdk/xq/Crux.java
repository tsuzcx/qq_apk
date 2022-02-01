package com.tencent.turingfd.sdk.xq;

public class Crux
  extends case
{
  public static Orion Xa = new Orion();
  public static Pegasus Ya = new Pegasus();
  public Orion Za = null;
  public Pegasus _a = null;
  public int ab = 0;
  public String bb = "";
  public String cb = "";
  
  public void a(byte parambyte)
  {
    Object localObject = this.Za;
    if (localObject != null) {
      parambyte.a((case)localObject, 0);
    }
    localObject = this._a;
    if (localObject != null) {
      parambyte.a((case)localObject, 1);
    }
    parambyte.a(this.ab, 2);
    localObject = this.bb;
    if (localObject != null) {
      parambyte.b((String)localObject, 3);
    }
    localObject = this.cb;
    if (localObject != null) {
      parambyte.b((String)localObject, 4);
    }
  }
  
  public void a(try paramtry)
  {
    this.Za = ((Orion)paramtry.a(Xa, 0, false));
    this._a = ((Pegasus)paramtry.a(Ya, 1, false));
    this.ab = paramtry.a(this.ab, 2, false);
    this.bb = paramtry.a(3, false);
    this.cb = paramtry.a(4, false);
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
      if (!(paramObject instanceof Crux)) {
        return false;
      }
      paramObject = (Crux)paramObject;
    } while ((char.equals(this.Za, paramObject.Za)) && (char.equals(this._a, paramObject._a)) && (char.equals(this.ab, paramObject.ab)) && (char.equals(this.bb, paramObject.bb)) && (char.equals(this.cb, paramObject.cb)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Crux
 * JD-Core Version:    0.7.0.1
 */