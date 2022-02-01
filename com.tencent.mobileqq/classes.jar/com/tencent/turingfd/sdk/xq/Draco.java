package com.tencent.turingfd.sdk.xq;

public class Draco
  extends case
{
  public static Perseus jb = new Perseus();
  public static String kb = new String();
  public Perseus lb = null;
  public String mb = "";
  public String nb = "";
  public String ob = null;
  
  public void a(byte parambyte)
  {
    parambyte.a(this.lb, 0);
    String str = this.mb;
    if (str != null) {
      parambyte.b(str, 1);
    }
    str = this.nb;
    if (str != null) {
      parambyte.b(str, 2);
    }
    str = this.ob;
    if (str != null) {
      parambyte.b(str, 3);
    }
  }
  
  public void a(try paramtry)
  {
    this.lb = ((Perseus)paramtry.a(jb, 0, true));
    this.mb = paramtry.a(1, false);
    this.nb = paramtry.a(2, false);
    this.ob = paramtry.a(kb, 3, false);
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
      if (!(paramObject instanceof Draco)) {
        return false;
      }
      paramObject = (Draco)paramObject;
    } while ((char.equals(this.lb, paramObject.lb)) && (char.equals(this.mb, paramObject.mb)) && (char.equals(this.nb, paramObject.nb)) && (char.equals(this.ob, paramObject.ob)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Draco
 * JD-Core Version:    0.7.0.1
 */