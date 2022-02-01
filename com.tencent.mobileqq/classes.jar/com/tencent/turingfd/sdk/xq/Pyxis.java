package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Pyxis
  extends case
{
  public static byte[] Oa = new byte[1];
  public static List<String> Qa;
  public static List<String> Ra;
  public static byte[] ib;
  public int Wa = 0;
  public byte[] Xa = null;
  public String Za = "";
  public List<String> _a = null;
  public List<String> ab = null;
  public int jb = 0;
  public String kb = "";
  public long lb = 0L;
  public byte[] mb = null;
  public int type = 0;
  
  static
  {
    Oa[0] = 0;
    ib = new byte[1];
    ib[0] = 0;
    Qa = new ArrayList();
    Qa.add("");
    Ra = new ArrayList();
    Ra.add("");
  }
  
  public void a(byte parambyte)
  {
    parambyte.b(this.jb, 0);
    Object localObject = this.kb;
    if (localObject != null) {
      parambyte.b((String)localObject, 1);
    }
    parambyte.a(this.lb, 2);
    parambyte.b(this.type, 3);
    localObject = this.Xa;
    if (localObject != null) {
      parambyte.a((byte[])localObject, 4);
    }
    localObject = this.mb;
    if (localObject != null) {
      parambyte.a((byte[])localObject, 5);
    }
    parambyte.b(this.Wa, 6);
    localObject = this.Za;
    if (localObject != null) {
      parambyte.b((String)localObject, 7);
    }
    localObject = this._a;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 8);
    }
    localObject = this.ab;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 9);
    }
  }
  
  public void a(try paramtry)
  {
    this.jb = paramtry.a(this.jb, 0, true);
    this.kb = paramtry.a(1, false);
    this.lb = paramtry.a(this.lb, 2, false);
    this.type = paramtry.a(this.type, 3, false);
    this.Xa = paramtry.a(Oa, 4, false);
    this.mb = paramtry.a(ib, 5, false);
    this.Wa = paramtry.a(this.Wa, 6, false);
    this.Za = paramtry.a(7, false);
    this._a = ((List)paramtry.a(Qa, 8, false));
    this.ab = ((List)paramtry.a(Ra, 9, false));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!(paramObject instanceof Pyxis)) {
      return false;
    }
    paramObject = (Pyxis)paramObject;
    return (char.equals(this.jb, paramObject.jb)) && (char.equals(this.kb, paramObject.kb)) && (char.a(this.lb, paramObject.lb)) && (char.equals(this.type, paramObject.type)) && (char.equals(this.Xa, paramObject.Xa)) && (char.equals(this.mb, paramObject.mb)) && (char.equals(this.Wa, paramObject.Wa)) && (char.equals(this.Za, paramObject.Za)) && (char.equals(this._a, paramObject._a)) && (char.equals(this.ab, paramObject.ab));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Pyxis
 * JD-Core Version:    0.7.0.1
 */