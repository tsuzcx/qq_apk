package com.tencent.turingfd.sdk.xq;

public class Arbutus
  extends case
{
  public static byte[] Jc;
  public static Banana Kc = new Banana();
  public static Virgo Lc = new Virgo();
  public static byte[] q = new byte[1];
  public byte[] F = null;
  public int Mc = 0;
  public int Nc = 0;
  public int Oc = 0;
  public int Pc = 0;
  public int Qc = 0;
  public int Rc = 0;
  public int Sc = 0;
  public long Tc = 0L;
  public byte[] Uc = null;
  public int Vc = 0;
  public int Wc = 0;
  public Banana Xc = null;
  public Virgo Yc = null;
  
  static
  {
    q[0] = 0;
    Jc = new byte[1];
    Jc[0] = 0;
  }
  
  public void a(byte parambyte)
  {
    parambyte.b(this.Mc, 0);
    parambyte.b(this.Nc, 1);
    parambyte.b(this.Oc, 2);
    parambyte.b(this.Pc, 3);
    parambyte.b(this.Qc, 4);
    Object localObject = this.F;
    if (localObject != null) {
      parambyte.a((byte[])localObject, 5);
    }
    parambyte.b(this.Rc, 6);
    parambyte.b(this.Sc, 7);
    parambyte.a(this.Tc, 8);
    localObject = this.Uc;
    if (localObject != null) {
      parambyte.a((byte[])localObject, 9);
    }
    parambyte.b(this.Vc, 10);
    parambyte.b(this.Wc, 11);
    localObject = this.Xc;
    if (localObject != null) {
      parambyte.a((case)localObject, 12);
    }
    localObject = this.Yc;
    if (localObject != null) {
      parambyte.a((case)localObject, 13);
    }
  }
  
  public void a(try paramtry)
  {
    this.Mc = paramtry.a(this.Mc, 0, false);
    this.Nc = paramtry.a(this.Nc, 1, false);
    this.Oc = paramtry.a(this.Oc, 2, false);
    this.Pc = paramtry.a(this.Pc, 3, false);
    this.Qc = paramtry.a(this.Qc, 4, false);
    this.F = paramtry.a(q, 5, false);
    this.Rc = paramtry.a(this.Rc, 6, false);
    this.Sc = paramtry.a(this.Sc, 7, false);
    this.Tc = paramtry.a(this.Tc, 8, false);
    this.Uc = paramtry.a(Jc, 9, false);
    this.Vc = paramtry.a(this.Vc, 10, false);
    this.Wc = paramtry.a(this.Wc, 11, false);
    this.Xc = ((Banana)paramtry.a(Kc, 12, false));
    this.Yc = ((Virgo)paramtry.a(Lc, 13, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Arbutus)) {
      return false;
    }
    paramObject = (Arbutus)paramObject;
    return (char.equals(this.Mc, paramObject.Mc)) && (char.equals(this.Nc, paramObject.Nc)) && (char.equals(this.Oc, paramObject.Oc)) && (char.equals(this.Pc, paramObject.Pc)) && (char.equals(this.Qc, paramObject.Qc)) && (char.equals(this.F, paramObject.F)) && (char.equals(this.Rc, paramObject.Rc)) && (char.equals(this.Sc, paramObject.Sc)) && (char.a(this.Tc, paramObject.Tc)) && (char.equals(this.Uc, paramObject.Uc)) && (char.equals(this.Vc, paramObject.Vc)) && (char.equals(this.Wc, paramObject.Wc)) && (char.equals(this.Xc, paramObject.Xc)) && (char.equals(this.Yc, paramObject.Yc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Arbutus
 * JD-Core Version:    0.7.0.1
 */