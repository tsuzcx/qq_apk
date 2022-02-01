package com.tencent.turingfd.sdk.xq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Cygnus
  extends case
{
  public static byte[] Ja = new byte[1];
  public static List<String> La;
  public static List<String> Ma;
  public static byte[] db;
  public int Ra = 0;
  public byte[] Sa = null;
  public String Ua = "";
  public List<String> Va = null;
  public List<String> Wa = null;
  public int eb = 0;
  public String fb = "";
  public long gb = 0L;
  public byte[] hb = null;
  public int type = 0;
  
  static
  {
    Ja[0] = 0;
    db = new byte[1];
    db[0] = 0;
    La = new ArrayList();
    La.add("");
    Ma = new ArrayList();
    Ma.add("");
  }
  
  public void a(byte parambyte)
  {
    parambyte.a(this.eb, 0);
    Object localObject = this.fb;
    if (localObject != null) {
      parambyte.b((String)localObject, 1);
    }
    parambyte.a(this.gb, 2);
    parambyte.a(this.type, 3);
    localObject = this.Sa;
    if (localObject != null) {
      parambyte.a((byte[])localObject, 4);
    }
    localObject = this.hb;
    if (localObject != null) {
      parambyte.a((byte[])localObject, 5);
    }
    parambyte.a(this.Ra, 6);
    localObject = this.Ua;
    if (localObject != null) {
      parambyte.b((String)localObject, 7);
    }
    localObject = this.Va;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 8);
    }
    localObject = this.Wa;
    if (localObject != null) {
      parambyte.a((Collection)localObject, 9);
    }
  }
  
  public void a(try paramtry)
  {
    this.eb = paramtry.a(this.eb, 0, true);
    this.fb = paramtry.a(1, false);
    this.gb = paramtry.a(this.gb, 2, false);
    this.type = paramtry.a(this.type, 3, false);
    this.Sa = paramtry.a(Ja, 4, false);
    this.hb = paramtry.a(db, 5, false);
    this.Ra = paramtry.a(this.Ra, 6, false);
    this.Ua = paramtry.a(7, false);
    this.Va = ((List)paramtry.a(La, 8, false));
    this.Wa = ((List)paramtry.a(Ma, 9, false));
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
      if (!(paramObject instanceof Cygnus)) {
        return false;
      }
      paramObject = (Cygnus)paramObject;
    } while ((char.equals(this.eb, paramObject.eb)) && (char.equals(this.fb, paramObject.fb)) && (char.a(this.gb, paramObject.gb)) && (char.equals(this.type, paramObject.type)) && (char.equals(this.Sa, paramObject.Sa)) && (char.equals(this.hb, paramObject.hb)) && (char.equals(this.Ra, paramObject.Ra)) && (char.equals(this.Ua, paramObject.Ua)) && (char.equals(this.Va, paramObject.Va)) && (char.equals(this.Wa, paramObject.Wa)));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Cygnus
 * JD-Core Version:    0.7.0.1
 */