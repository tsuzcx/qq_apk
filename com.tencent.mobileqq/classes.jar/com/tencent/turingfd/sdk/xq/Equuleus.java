package com.tencent.turingfd.sdk.xq;

public class Equuleus
  extends case
{
  public String mb = "";
  public int pb = 0;
  public int qb = 0;
  public String tb = "";
  public String ub = "";
  public int vb = 0;
  
  public void a(byte parambyte)
  {
    parambyte.a(this.pb, 0);
    parambyte.a(this.qb, 1);
    String str = this.tb;
    if (str != null) {
      parambyte.b(str, 2);
    }
    str = this.ub;
    if (str != null) {
      parambyte.b(str, 3);
    }
    parambyte.a(this.vb, 4);
    str = this.mb;
    if (str != null) {
      parambyte.b(str, 5);
    }
  }
  
  public void a(try paramtry)
  {
    this.pb = paramtry.a(this.pb, 0, true);
    this.qb = paramtry.a(this.qb, 1, false);
    this.tb = paramtry.a(2, false);
    this.ub = paramtry.a(3, false);
    this.vb = paramtry.a(this.vb, 4, false);
    this.mb = paramtry.a(5, false);
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
      if (!(paramObject instanceof Equuleus)) {
        return false;
      }
      paramObject = (Equuleus)paramObject;
    } while ((char.equals(this.pb, paramObject.pb)) && (char.equals(this.qb, paramObject.qb)) && (char.equals(this.tb, paramObject.tb)) && (char.equals(this.ub, paramObject.ub)) && (char.equals(this.vb, paramObject.vb)) && (char.equals(this.mb, paramObject.mb)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Equuleus
 * JD-Core Version:    0.7.0.1
 */