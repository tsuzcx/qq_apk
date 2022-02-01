package com.tencent.turingfd.sdk.xq;

public class Orion
  extends case
{
  public static byte[] Ec;
  public static Phoenix Fc = new Phoenix();
  public static Leo Gc = new Leo();
  public static byte[] l = new byte[1];
  public int Hc = 0;
  public int Ic = 0;
  public int Jc = 0;
  public int Kc = 0;
  public int Lc = 0;
  public int Mc = 0;
  public int Nc = 0;
  public long Oc = 0L;
  public byte[] Pc = null;
  public int Qc = 0;
  public int Rc = 0;
  public Phoenix Sc = null;
  public Leo Tc = null;
  public byte[] v = null;
  
  static
  {
    l[0] = 0;
    Ec = new byte[1];
    Ec[0] = 0;
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.Hc, 0);
    parambyte.a(this.Ic, 1);
    parambyte.a(this.Jc, 2);
    parambyte.a(this.Kc, 3);
    parambyte.a(this.Lc, 4);
    Object localObject = this.v;
    if (localObject != null) {
      parambyte.a((byte[])localObject, 5);
    }
    parambyte.a(this.Mc, 6);
    parambyte.a(this.Nc, 7);
    parambyte.a(this.Oc, 8);
    localObject = this.Pc;
    if (localObject != null) {
      parambyte.a((byte[])localObject, 9);
    }
    parambyte.a(this.Qc, 10);
    parambyte.a(this.Rc, 11);
    localObject = this.Sc;
    if (localObject != null) {
      parambyte.a((case)localObject, 12);
    }
    localObject = this.Tc;
    if (localObject != null) {
      parambyte.a((case)localObject, 13);
    }
  }
  
  public void a(try paramtry)
  {
    this.Hc = paramtry.a(this.Hc, 0, false);
    this.Ic = paramtry.a(this.Ic, 1, false);
    this.Jc = paramtry.a(this.Jc, 2, false);
    this.Kc = paramtry.a(this.Kc, 3, false);
    this.Lc = paramtry.a(this.Lc, 4, false);
    this.v = paramtry.a(l, 5, false);
    this.Mc = paramtry.a(this.Mc, 6, false);
    this.Nc = paramtry.a(this.Nc, 7, false);
    this.Oc = paramtry.a(this.Oc, 8, false);
    this.Pc = paramtry.a(Ec, 9, false);
    this.Qc = paramtry.a(this.Qc, 10, false);
    this.Rc = paramtry.a(this.Rc, 11, false);
    this.Sc = ((Phoenix)paramtry.a(Fc, 12, false));
    this.Tc = ((Leo)paramtry.a(Gc, 13, false));
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
      if (!(paramObject instanceof Orion)) {
        return false;
      }
      paramObject = (Orion)paramObject;
    } while ((char.equals(this.Hc, paramObject.Hc)) && (char.equals(this.Ic, paramObject.Ic)) && (char.equals(this.Jc, paramObject.Jc)) && (char.equals(this.Kc, paramObject.Kc)) && (char.equals(this.Lc, paramObject.Lc)) && (char.equals(this.v, paramObject.v)) && (char.equals(this.Mc, paramObject.Mc)) && (char.equals(this.Nc, paramObject.Nc)) && (char.a(this.Oc, paramObject.Oc)) && (char.equals(this.Pc, paramObject.Pc)) && (char.equals(this.Qc, paramObject.Qc)) && (char.equals(this.Rc, paramObject.Rc)) && (char.equals(this.Sc, paramObject.Sc)) && (char.equals(this.Tc, paramObject.Tc)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Orion
 * JD-Core Version:    0.7.0.1
 */